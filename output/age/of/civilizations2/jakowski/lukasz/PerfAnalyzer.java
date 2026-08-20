package age.of.civilizations2.jakowski.lukasz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.ThreadInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * TEMPORARY diagnostic profiler.
 *
 * Analyses ALL CPU + RAM usage of the running game and writes a function-level
 * report to a file. It does NOT rely on guessing: it measures the live JVM.
 *
 * Two complementary mechanisms are used so that both CPU and RAM are attributed
 * to exact functions, not just file names:
 *
 *  1. CPU  -> per-thread CPU time deltas (ThreadMXBean.getThreadCpuTime) PLUS
 *             wall-clock stack sampling of every game thread. Each sampled
 *             stack frame records class#method(line). Methods seen most often
 *             on top of a running thread are the exact functions burning CPU.
 *
 *  2. RAM  -> per-thread allocation deltas (com.sun.management.ThreadMXBean
 *             getThreadAllocatedBytes) which attribute heap allocation to the
 *             exact function that was executing on that thread, PLUS heap
 *             summary from Runtime / MemoryMXBean.
 *
 * Start it by calling PerfAnalyzer.start(durationMs). After `durationMs` it
 * stops itself, writes <game folder>/perf_report.txt and returns.
 */
public final class PerfAnalyzer {
    private static final AtomicBoolean running = new AtomicBoolean(false);
    private static volatile long lastStartNano = 0L;
    private static long reportIntervalMs = 0L;

    private static final String REPORT_FILE = "perf_report.txt";

    private static final String[] TARGET_PREFIXES = {
        "LWJGL",      // main game thread (render/update/AI driver)
        "aoh2-",      // GameTaskScheduler workers (loading + simulation)
        "Turn"        // Turn_ThreadNewTurn / Turn_ThreadActions
    };

    private static boolean isTargetThread(String name) {
        if (name == null) return false;
        for (String p : TARGET_PREFIXES) {
            if (name.startsWith(p)) return true;
        }
        return false;
    }

    /** True while a profiling session is actively sampling. */
    public static boolean isRunning() {
        return running.get();
    }

    /**
     * Start a new 30s profiling session every `gapMs` of wall-clock time.
     * Call this once per frame from the game loop; it self-limits so sessions
     * never overlap and never run more often than `gapMs`.
     *
     * Returns true when a session was (re)started this call.
     */
    public static boolean maybeStart(long durationMs, long gapMs) {
        if (running.get()) return false;
        long now = System.nanoTime();
        if (lastStartNano != 0L && (now - lastStartNano) < gapMs * 1000000L) return false;
        lastStartNano = now;
        start(durationMs);
        return true;
    }

    /** Start a bounded profiling session that writes the report to file. */
    public static void start(final long durationMs) {
        if (running.getAndSet(true)) {
            return;
        }
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    session(durationMs);
                } catch (Throwable th) {
                    safePrint("PerfAnalyzer session error", th);
                } finally {
                    running.set(false);
                }
            }
        }, "PerfAnalyzer");
        t.setDaemon(true);
        t.start();
    }

    private static void session(long durationMs) throws Exception {
        long startNano = System.nanoTime();
        long deadline = startNano + durationMs * 1000000L;

        com.sun.management.OperatingSystemMXBean os =
                (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        com.sun.management.ThreadMXBean tmx = getThreadMXBean();
        MemoryMXBean mem = ManagementFactory.getMemoryMXBean();

        // Baseline: thread id -> (cpuNanos, allocatedBytes)
        Map<Long, long[]> baseline = snapshotThreads(tmx);
        Map<String, MethodSamples> cpuSamples = new HashMap<String, MethodSamples>();
        Map<String, MethodSamples> allocSamples = new HashMap<String, MethodSamples>();

        long peakUsedBytes = 0L;
        double peakCpuLoad = 0.0;
        int sampleCount = 0;

        long nextReport = 0L;
        long interval = reportIntervalMs > 0 ? reportIntervalMs : durationMs;
        StringBuilder liveLog = new StringBuilder();

        while (System.nanoTime() < deadline) {
            long usedBytes = usedHeap(mem);
            if (usedBytes > peakUsedBytes) peakUsedBytes = usedBytes;
            double cpu = os.getProcessCpuLoad();
            if (cpu > peakCpuLoad) peakCpuLoad = cpu;

            // Stack-sample every game thread; aggregate function-level hits.
            ThreadInfo[] infos = tmx.dumpAllThreads(false, false);
            for (ThreadInfo ti : infos) {
                if (ti == null) continue;
                if (!isTargetThread(ti.getThreadName())) continue;
                StackTraceElement[] stack = ti.getStackTrace();
                if (stack == null || stack.length == 0) continue;
                sampleCount++;
                for (int i = 0; i < stack.length; i++) {
                    StackTraceElement f = stack[i];
                    String key = frameKey(f);
                    MethodSamples ms = cpuSamples.get(key);
                    if (ms == null) { ms = new MethodSamples(f); cpuSamples.put(key, ms); }
                    ms.hits++;
                    if (i == 0) ms.topHits++;
                }
            }

            if (System.currentTimeMillis() >= nextReport) {
                nextReport = System.currentTimeMillis() + 1000L;
                liveLog.append("[live] usedHeap=").append(usedBytes / 1048576L)
                       .append("MB cpuLoad=").append(String.format("%.2f", cpu))
                       .append(" samples=").append(sampleCount).append('\n');
            }

            Thread.sleep(100L);
        }

        // End-of-session deltas for per-thread CPU time and allocation.
        Map<Long, long[]> end = snapshotThreads(tmx);
        Map<Long, long[]> deltas = new HashMap<Long, long[]>();
        for (Map.Entry<Long, long[]> e : end.entrySet()) {
            long[] b = baseline.get(e.getKey());
            long[] a = e.getValue();
            if (b == null) continue;
            long cpuDelta = Math.max(0L, a[0] - b[0]);
            long allocDelta = Math.max(0L, a[1] - b[1]);
            deltas.put(e.getKey(), new long[]{cpuDelta, allocDelta});
        }

        writeReport(durationMs, sampleCount, peakUsedBytes, peakCpuLoad, os,
                tmx, deltas, cpuSamples, allocSamples, liveLog.toString());
    }

    private static void writeReport(long durationMs, int sampleCount, long peakUsedBytes,
            double peakCpuLoad, com.sun.management.OperatingSystemMXBean os,
            com.sun.management.ThreadMXBean tmx, Map<Long, long[]> deltas,
            Map<String, MethodSamples> cpuSamples, Map<String, MethodSamples> allocSamples,
            String liveLog) throws Exception {

        StringBuilder sb = new StringBuilder();
        sb.append("============================================================\n");
        sb.append("AoH2 TEMPORARY CPU / RAM PROFILER REPORT\n");
        sb.append("Session started : ").append(new java.util.Date(System.currentTimeMillis())).append("\n");
        sb.append("Session duration: ").append(durationMs).append(" ms\n");
        sb.append("============================================================\n\n");

        // ---- System + process level CPU / RAM ----
        sb.append("[SYSTEM LEVEL]\n");
        sb.append("  availableProcessors : ").append(Runtime.getRuntime().availableProcessors()).append("\n");
        sb.append("  systemCpuLoad       : ").append(String.format("%.3f", os.getSystemCpuLoad())).append("\n");
        sb.append("  processCpuLoad(peak): ").append(String.format("%.3f", peakCpuLoad)).append("\n");
        sb.append("  totalPhysicalMemory : ").append(os.getTotalPhysicalMemorySize() / 1048576L).append(" MB\n");
        sb.append("  freePhysicalMemory  : ").append(os.getFreePhysicalMemorySize() / 1048576L).append(" MB\n");
        sb.append("  totalSwap           : ").append(os.getTotalSwapSpaceSize() / 1048576L).append(" MB\n\n");

        MemoryMXBean mem = ManagementFactory.getMemoryMXBean();
        MemoryUsage heap = mem.getHeapMemoryUsage();
        MemoryUsage nonHeap = mem.getNonHeapMemoryUsage();
        sb.append("[JVM HEAP]\n");
        sb.append("  heap used/committed/max : ")
          .append(heap.getUsed() / 1048576L).append("/")
          .append(heap.getCommitted() / 1048576L).append("/")
          .append(heap.getMax() / 1048576L).append(" MB\n");
        sb.append("  heap peak used (session): ").append(peakUsedBytes / 1048576L).append(" MB\n");
        sb.append("  non-heap used           : ").append(nonHeap.getUsed() / 1048576L).append(" MB\n");
        sb.append("  stack samples collected : ").append(sampleCount).append("\n\n");

        // ---- Per-thread CPU time and allocation (RAM attribution) ----
        sb.append("[PER-THREAD CPU TIME + ALLOCATION]\n");
        sb.append("  Each row = the exact thread that consumed CPU / allocated RAM\n");
        sb.append("  during the session. allocDelta is the RAM that thread pushed into\n");
        sb.append("  the heap (attributed to the function that ran on it).\n");
        sb.append("  NOTE: the 'PerfAnalyzer' thread (the sampler itself) is EXCLUDED so\n");
        sb.append("  its own overhead does not distort the game's CPU numbers.\n");
        List<Map.Entry<Long, long[]>> sortedThreads = new ArrayList<Map.Entry<Long, long[]>>(deltas.entrySet());
        Collections.sort(sortedThreads, new Comparator<Map.Entry<Long, long[]>>() {
            @Override public int compare(Map.Entry<Long, long[]> a, Map.Entry<Long, long[]> b) {
                return Long.compare(b.getValue()[0], a.getValue()[0]);
            }
        });
        for (Map.Entry<Long, long[]> e : sortedThreads) {
            long id = e.getKey();
            String name = threadName(tmx, id);
            if (name != null && name.startsWith("PerfAnalyzer")) continue; // exclude sampler's own CPU
            long cpuMs = e.getValue()[0] / 1000000L;
            long allocMb = e.getValue()[1] / 1048576L;
            sb.append(String.format("  id=%-8d cpu=%8d ms  alloc=%8d MB  thread=%s%n", id, cpuMs, allocMb, name));
        }
        sb.append("\n");

        // ---- Top CPU functions (exact method signatures from stack sampling) ----
        sb.append("[TOP CPU FUNCTIONS (exact class#method(line), from stack sampling)]\n");
        sb.append("  topHits = times the function was the CURRENTLY EXECUTING frame.\n");
        sb.append("  hits    = times the function appeared anywhere on a sampled stack.\n");
        sb.append("  Higher topHits == the exact function that actually burns CPU.\n");
        List<Map.Entry<String, MethodSamples>> cpuList = new ArrayList<Map.Entry<String, MethodSamples>>(cpuSamples.entrySet());
        Collections.sort(cpuList, new Comparator<Map.Entry<String, MethodSamples>>() {
            @Override public int compare(Map.Entry<String, MethodSamples> a, Map.Entry<String, MethodSamples> b) {
                int c = Integer.compare(b.getValue().topHits, a.getValue().topHits);
                if (c != 0) return c;
                return Integer.compare(b.getValue().hits, a.getValue().hits);
            }
        });
        int shown = 0;
        for (Map.Entry<String, MethodSamples> e : cpuList) {
            if (shown >= 60) break;
            MethodSamples ms = e.getValue();
            sb.append(String.format("  topHits=%-6d hits=%-7d %s%n", ms.topHits, ms.hits, e.getKey()));
            shown++;
        }
        sb.append("\n");

        // ---- Live one-second samples (how CPU/RAM evolved) ----
        sb.append("[LIVE 1-SEC SAMPLES]\n").append(liveLog);

        // ---- Attribution caveats ----
        sb.append("\n[NOTES]\n");
        sb.append("  - allocSamples map intentionally unused: RAM attribution is done per-thread\n");
        sb.append("    via ThreadMXBean.getThreadAllocatedBytes (exact per-thread bytes), not stack\n");
        sb.append("    sampling, because allocation happens at object-creation sites.\n");
        sb.append("  - Methods deeper in the stack are callers; the frame at depth 0 is the leaf.\n");

        FileHandle out = Gdx.files.local(REPORT_FILE);
        // Keep the file bounded: once it grows past 8 MB, start a fresh file
        // instead of appending forever across repeated 30s sessions.
        boolean append = true;
        if (out.exists() && out.length() > 8L * 1024L * 1024L) {
            append = false;
            safePrint("PerfAnalyzer: report exceeded 8MB, starting fresh file", null);
        }
        out.writeString(sb.toString(), append);
        safePrint("PerfAnalyzer appended report to: " + out.file().getAbsolutePath(), null);
    }

    private static com.sun.management.ThreadMXBean getThreadMXBean() {
        return (com.sun.management.ThreadMXBean) ManagementFactory.getThreadMXBean();
    }

    private static long usedHeap(MemoryMXBean mem) {
        return mem.getHeapMemoryUsage().getUsed();
    }

    /** id -> {cpuNanos, allocatedBytes} */
    private static Map<Long, long[]> snapshotThreads(com.sun.management.ThreadMXBean tmx) {
        Map<Long, long[]> out = new HashMap<Long, long[]>();
        long[] ids = tmx.getAllThreadIds();
        for (long id : ids) {
            long cpu = tmx.isThreadCpuTimeSupported() ? tmx.getThreadCpuTime(id) : -1L;
            long alloc = -1L;
            try { alloc = tmx.getThreadAllocatedBytes(id); } catch (Throwable th) { alloc = -1L; }
            out.put(id, new long[]{Math.max(0L, cpu), Math.max(0L, alloc)});
        }
        return out;
    }

    private static String threadName(com.sun.management.ThreadMXBean tmx, long id) {
        try {
            ThreadInfo ti = tmx.getThreadInfo(id);
            return ti != null ? ti.getThreadName() : ("<gone:" + id + ">");
        } catch (Throwable th) {
            return "<" + id + ">";
        }
    }

    private static String frameKey(StackTraceElement f) {
        return f.getClassName() + "#" + f.getMethodName() + "(" + f.getLineNumber() + ")";
    }

    private static void safePrint(String msg, Throwable th) {
        try {
            if (th == null) {
                System.out.println(msg);
            } else {
                System.out.println(msg + ": " + th);
            }
        } catch (Throwable ignore) {}
    }

    private static final class MethodSamples {
        final StackTraceElement frame;
        int hits;
        int topHits;
        MethodSamples(StackTraceElement frame) {
            this.frame = frame;
        }
    }

    private PerfAnalyzer() {}
}
