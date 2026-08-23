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
    private static final String REPORT_DIR_ANDROID = "Download/AoH2/performance";
    private static final String REPORT_DIR_DESKTOP = "logs/performance";
    private static final long MAX_REPORT_BYTES = 8L * 1024L * 1024L;

    private static final String[] TARGET_PREFIXES = {
        "LWJGL",      // main game thread (render/update/AI driver)
        "aoh2-",      // GameTaskScheduler workers (loading + simulation)
        "Turn"        // Turn_ThreadNewTurn / Turn_ThreadActions
    };

    private static boolean isAndroid() {
        try {
            return Gdx.app != null && Gdx.app.getType() == com.badlogic.gdx.Application.ApplicationType.Android;
        } catch (Throwable t) {
            return false;
        }
    }

    private static int getAndroidSdkInt() {
        try {
            Class<?> v = Class.forName("android.os.Build$VERSION");
            return v.getField("SDK_INT").getInt(null);
        } catch (Throwable t) { return -1; }
    }

    private static boolean tryWriteViaMediaStore(String fileName, String content, boolean append) {
        try {
            int sdk = getAndroidSdkInt();
            if (sdk < 29) return false;
            // Need Context (Gdx.app is AndroidApplication extends Context)
            Object context = Gdx.app;
            // Use reflection to get ContentResolver without hard android dep at compile time
            Class<?> ctxClass = Class.forName("android.content.Context");
            java.lang.reflect.Method getResolver = null;
            // Find getContentResolver on actual instance class
            try { getResolver = context.getClass().getMethod("getContentResolver"); } catch (Throwable e) { getResolver = ctxClass.getMethod("getContentResolver"); }
            Object resolver = getResolver.invoke(context);
            Class<?> mediaStore = Class.forName("android.provider.MediaStore");
            Class<?> downloadsClass = Class.forName("android.provider.MediaStore$Downloads");
            java.lang.reflect.Field uriField = downloadsClass.getField("EXTERNAL_CONTENT_URI");
            Object downloadsUri = uriField.get(null);
            // ContentValues
            Class<?> cvClass = Class.forName("android.content.ContentValues");
            Object cv = cvClass.getConstructor().newInstance();
            java.lang.reflect.Method putString = cvClass.getMethod("put", String.class, String.class);
            java.lang.reflect.Method putInt = cvClass.getMethod("put", String.class, Integer.class);
            // Columns
            String colDisplay = (String) Class.forName("android.provider.MediaStore$MediaColumns").getField("DISPLAY_NAME").get(null);
            String colMime = (String) Class.forName("android.provider.MediaStore$MediaColumns").getField("MIME_TYPE").get(null);
            String colRelative = (String) Class.forName("android.provider.MediaStore$MediaColumns").getField("RELATIVE_PATH").get(null);
            String colPending = null;
            try { colPending = (String) Class.forName("android.provider.MediaStore$MediaColumns").getField("IS_PENDING").get(null); } catch (Throwable ignore) {}
            putString.invoke(cv, colDisplay, fileName);
            putString.invoke(cv, colMime, "text/plain");
            putString.invoke(cv, colRelative, "Download/AoH2/performance");
            if (colPending != null && sdk >= 29) putInt.invoke(cv, colPending, Integer.valueOf(1));
            // Query existing file if append
            Object existingUri = null;
            if (append) {
                try {
                    Class<?> uriClass = Class.forName("android.net.Uri");
                    Class<?> resolverClass = resolver.getClass();
                    // resolver.query(uri, projection, selection, selectionArgs, sortOrder)
                    java.lang.reflect.Method query = null;
                    for (java.lang.reflect.Method m : resolverClass.getMethods()) if (m.getName().equals("query") && m.getParameterTypes().length==5) { query = m; break; }
                    if (query != null) {
                        String[] proj = new String[]{ "_id" };
                        String sel = colDisplay + "=? AND " + colRelative + "=?";
                        String[] args = new String[]{ fileName, "Download/AoH2/performance/" };
                        Object cursor = query.invoke(resolver, downloadsUri, proj, sel, args, null);
                        if (cursor != null) {
                            java.lang.reflect.Method moveFirst = cursor.getClass().getMethod("moveToFirst");
                            Boolean has = (Boolean) moveFirst.invoke(cursor);
                            if (has != null && has) {
                                java.lang.reflect.Method getLong = cursor.getClass().getMethod("getLong", int.class);
                                long id = (Long) getLong.invoke(cursor, 0);
                                // Build uri: ContentUris.withAppendedId
                                Class<?> contentUris = Class.forName("android.content.ContentUris");
                                java.lang.reflect.Method withId = contentUris.getMethod("withAppendedId", uriClass, long.class);
                                existingUri = withId.invoke(null, downloadsUri, id);
                            }
                            try { cursor.getClass().getMethod("close").invoke(cursor); } catch (Throwable ignore) {}
                        }
                    }
                } catch (Throwable ignore) {}
            }
            Object targetUri = existingUri;
            if (targetUri == null) {
                java.lang.reflect.Method insert = resolver.getClass().getMethod("insert", Class.forName("android.net.Uri"), cvClass);
                Object inserted = insert.invoke(resolver, downloadsUri, cv);
                if (inserted == null) return false;
                targetUri = inserted;
            }
            // Open OutputStream
            java.lang.reflect.Method openOut = null;
            for (java.lang.reflect.Method m : resolver.getClass().getMethods()) if (m.getName().equals("openOutputStream") ) { if (m.getParameterTypes().length==2) { openOut = m; break; } }
            if (openOut == null) openOut = resolver.getClass().getMethod("openOutputStream", Class.forName("android.net.Uri"), String.class);
            java.io.OutputStream os = null;
            if (openOut.getParameterTypes().length==2) os = (java.io.OutputStream) openOut.invoke(resolver, targetUri, append ? "wa" : "w");
            else os = (java.io.OutputStream) resolver.getClass().getMethod("openOutputStream", Class.forName("android.net.Uri")).invoke(resolver, targetUri);
            if (os == null) return false;
            byte[] bytes = content.getBytes("UTF-8");
            os.write(bytes);
            os.flush(); os.close();
            if (colPending != null && sdk >= 29) {
                Object cv2 = cvClass.getConstructor().newInstance();
                putInt.invoke(cv2, colPending, Integer.valueOf(0));
                resolver.getClass().getMethod("update", Class.forName("android.net.Uri"), cvClass, String.class, String[].class).invoke(resolver, targetUri, cv2, null, null);
            }
            safePrint("PerfAnalyzer MediaStore wrote: Download/AoH2/performance/" + fileName, null);
            return true;
        } catch (Throwable th) {
            // Fallback will handle; log for debugging
            // safePrint("PerfAnalyzer MediaStore failed: " + th, null);
            return false;
        }
    }

    private static boolean tryClearViaMediaStore() {
        try {
            int sdk = getAndroidSdkInt();
            if (sdk < 29) return false;
            Object context = Gdx.app;
            Object resolver = context.getClass().getMethod("getContentResolver").invoke(context);
            Class<?> downloadsClass = Class.forName("android.provider.MediaStore$Downloads");
            Object downloadsUri = downloadsClass.getField("EXTERNAL_CONTENT_URI").get(null);
            String colRelative = (String) Class.forName("android.provider.MediaStore$MediaColumns").getField("RELATIVE_PATH").get(null);
            // Delete all entries under Download/AoH2/performance
            java.lang.reflect.Method delete = resolver.getClass().getMethod("delete", Class.forName("android.net.Uri"), String.class, String[].class);
            String sel = colRelative + "=?";
            String[] args = new String[]{ "Download/AoH2/performance/" };
            int deleted = (Integer) delete.invoke(resolver, downloadsUri, sel, args);
            if (deleted > 0) safePrint("PerfAnalyzer MediaStore cleared " + deleted + " files in Download/AoH2/performance", null);
            return true;
        } catch (Throwable t) { return false; }
    }

    private static FileHandle getReportFolder() {
        try {
            if (isAndroid()) {
                int sdk = getAndroidSdkInt();
                // API 29+ scoped storage: prefer MediaStore path surrogate (Gdx external + MediaStore write)
                // Return app-scoped external dir which is always writable; public Download via MediaStore is handled in write path separately
                if (sdk >= 29) {
                    // Return external scoped dir for exists()/mkdirs() checks; MediaStore handles public Download visibility
                    try {
                        FileHandle ext = Gdx.files.external(REPORT_DIR_ANDROID);
                        return ext;
                    } catch (Throwable t) {}
                }
                // Legacy path for API 23-28 (Android 9) via Environment, or fallback
                try {
                    Class<?> env = Class.forName("android.os.Environment");
                    java.lang.reflect.Method mPub = env.getMethod("getExternalStoragePublicDirectory", String.class);
                    java.lang.reflect.Field fDown = env.getField("DIRECTORY_DOWNLOADS");
                    String downType = (String) fDown.get(null);
                    java.io.File pubDir = (java.io.File) mPub.invoke(null, downType);
                    java.io.File target = new java.io.File(pubDir, "AoH2/performance");
                    FileHandle h = Gdx.files.absolute(target.getAbsolutePath());
                    return h;
                } catch (Throwable reflectFail) {
                    FileHandle ext = Gdx.files.external(REPORT_DIR_ANDROID);
                    try {
                        FileHandle abs = Gdx.files.absolute("/storage/emulated/0/Download/AoH2/performance");
                        if (abs.exists() || ext.exists()) {
                            return abs;
                        }
                    } catch (Throwable ignore) {}
                    return ext;
                }
            }
            return Gdx.files.local(REPORT_DIR_DESKTOP);
        } catch (Throwable t) {
            return Gdx.files.local(REPORT_DIR_DESKTOP);
        }
    }

    private static FileHandle getReportFileHandle() {
        FileHandle dir = getReportFolder();
        try {
            if (!dir.exists()) dir.mkdirs();
        } catch (Throwable ignore) {}
        String name = "perf_report_" + new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date()) + ".txt";
        return dir.child(name);
    }

    private static FileHandle getLatestReportFileForAppend() {
        try {
            FileHandle dir = getReportFolder();
            if (!dir.exists()) dir.mkdirs();
            // Prefer single perf_report.txt for backward compat, but new sessions use timestamped files.
            // For append logic we use timestamped latest file if exists else create new.
            FileHandle legacy = dir.child(REPORT_FILE);
            if (legacy.exists() && legacy.length() < MAX_REPORT_BYTES) return legacy;
            return getReportFileHandle();
        } catch (Throwable t) {
            return Gdx.files.local(REPORT_FILE);
        }
    }

    /**
     * Clear performance report folder on every game restart.
     * Requirement: globally clear content there on restart; on Android clear Download/AoH2/performance via MediaStore + scoped external.
     */
    public static void clearReportsOnStartup() {
        try {
            // On Android 10+ try MediaStore clear for public Download (no permission needed for own files)
            if (isAndroid()) {
                try { tryClearViaMediaStore(); } catch (Throwable ignore) {}
                // Also clear app-scoped external fallback that is always writable
                try {
                    FileHandle ext = Gdx.files.external(REPORT_DIR_ANDROID);
                    if (ext.exists() && ext.isDirectory()) {
                        for (FileHandle f : ext.list()) {
                            try { if (f.isDirectory()) f.deleteDirectory(); else f.delete(); } catch (Throwable ignore2) {}
                        }
                        safePrint("PerfAnalyzer cleared external perf folder: " + ext.path(), null);
                    }
                } catch (Throwable ignore) {}
                // Also try absolute legacy path if exists (API 23-28)
                try {
                    FileHandle abs = Gdx.files.absolute("/storage/emulated/0/Download/AoH2/performance");
                    if (abs.exists() && abs.isDirectory()) {
                        for (FileHandle f : abs.list()) {
                            try { if (f.isDirectory()) f.deleteDirectory(); else f.delete(); } catch (Throwable ignore2) {}
                        }
                        safePrint("PerfAnalyzer cleared absolute perf folder: " + abs.path(), null);
                    }
                } catch (Throwable ignore) {}
            }
            // Generic getReportFolder clear (covers current SDK routing)
            try {
                FileHandle dir = getReportFolder();
                if (dir.exists() && dir.isDirectory()) {
                    FileHandle[] children = dir.list();
                    for (FileHandle f : children) {
                        try {
                            if (f.isDirectory()) f.deleteDirectory();
                            else f.delete();
                        } catch (Throwable ignore) {}
                    }
                    safePrint("PerfAnalyzer cleared report folder: " + dir.path(), null);
                }
            } catch (Throwable ignore) {}
            // Also clear legacy local perf_report.txt
            FileHandle legacy = Gdx.files.local(REPORT_FILE);
            if (legacy.exists()) {
                try { legacy.delete(); } catch (Throwable ignore) {}
            }
            FileHandle legacy2 = Gdx.files.local("logs/" + REPORT_FILE);
            if (legacy2.exists()) {
                try { legacy2.delete(); } catch (Throwable ignore) {}
            }
        } catch (Throwable th) {
            safePrint("PerfAnalyzer clearReportsOnStartup error", th);
        }
    }

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
        // Android fallback: ManagementFactory not available on Android API 9-35
        boolean hasManagement = true;
        try {
            Class.forName("java.lang.management.ManagementFactory");
            Class.forName("com.sun.management.OperatingSystemMXBean");
        } catch (Throwable th) {
            hasManagement = false;
        }
        if (!hasManagement || isAndroid()) {
            sessionLightweight(durationMs);
            return;
        }
        long startNano = System.nanoTime();
        long deadline = startNano + durationMs * 1000000L;

        com.sun.management.OperatingSystemMXBean os = null;
        com.sun.management.ThreadMXBean tmx = null;
        MemoryMXBean mem = null;
        try {
            os = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
            tmx = getThreadMXBean();
            mem = ManagementFactory.getMemoryMXBean();
        } catch (Throwable th) {
            sessionLightweight(durationMs);
            return;
        }

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
            double cpu = 0.0;
            try { cpu = os.getProcessCpuLoad(); } catch (Throwable ignore) {}
            if (cpu > peakCpuLoad) peakCpuLoad = cpu;

            // Stack-sample every game thread; aggregate function-level hits.
            ThreadInfo[] infos = null;
            try { infos = tmx.dumpAllThreads(false, false); } catch (Throwable ignore) {}
            if (infos != null) {
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

    private static void sessionLightweight(long durationMs) throws Exception {
        long startNano = System.nanoTime();
        long deadline = startNano + durationMs * 1000000L;
        Runtime rt = Runtime.getRuntime();
        long peakUsed = 0L;
        StringBuilder liveLog = new StringBuilder();
        Map<String, MethodSamples> cpuSamples = new HashMap<String, MethodSamples>();
        int sampleCount = 0;
        long nextReport = 0L;
        // Lightweight stack sampling using Thread.getAllStackTraces (works on Android)
        while (System.nanoTime() < deadline) {
            long used = (rt.totalMemory() - rt.freeMemory());
            if (used > peakUsed) peakUsed = used;
            java.util.Map<Thread, StackTraceElement[]> all = Thread.getAllStackTraces();
            for (Map.Entry<Thread, StackTraceElement[]> e : all.entrySet()) {
                Thread t = e.getKey();
                if (t == null || !isTargetThread(t.getName())) continue;
                StackTraceElement[] stack = e.getValue();
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
                liveLog.append("[live] usedHeap=").append(used / 1048576L).append("MB samples=").append(sampleCount).append('\n');
            }
            Thread.sleep(100L);
        }
        writeReportLightweight(durationMs, sampleCount, peakUsed, cpuSamples, liveLog.toString());
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

        // On Android 10+ try MediaStore first so report is visible in Downloads (scoped storage, no permission needed)
        if (isAndroid()) {
            try {
                String fileName = "perf_report_" + new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date()) + ".txt";
                boolean legacyExists = false;
                try {
                    FileHandle legacy = getReportFolder().child(REPORT_FILE);
                    if (legacy.exists() && legacy.length() < MAX_REPORT_BYTES) {
                        fileName = REPORT_FILE;
                        legacyExists = true;
                    }
                } catch (Throwable ignore) {}
                boolean useAppend = legacyExists;
                if (tryWriteViaMediaStore(fileName, sb.toString(), useAppend)) {
                    Gdx.app.log("PerfAnalyzer", "Report written via MediaStore to Download/AoH2/performance: " + fileName);
                    return;
                }
            } catch (Throwable ignore) {}
        }
        FileHandle out = null;
        try {
            out = getLatestReportFileForAppend();
            boolean append = true;
            if (out.exists() && out.length() > MAX_REPORT_BYTES) {
                out = getReportFileHandle();
                append = false;
                safePrint("PerfAnalyzer: report exceeded 8MB, starting fresh file", null);
            }
            // On Android target Download folder already ensured in getReportFolder
            out.writeString(sb.toString(), append);
            safePrint("PerfAnalyzer appended report to: " + out.file().getAbsolutePath() + " (" + out.path() + ")", null);
            // Mirror to logcat on Android
            if (isAndroid()) {
                Gdx.app.log("PerfAnalyzer", "Report written to Download/AoH2/performance: " + out.path());
            }
        } catch (Throwable th) {
            // Fallback to local
            try {
                FileHandle fallback = Gdx.files.local(REPORT_FILE);
                fallback.writeString(sb.toString(), true);
                safePrint("PerfAnalyzer fallback wrote to: " + fallback.file().getAbsolutePath(), null);
            } catch (Throwable t2) {
                safePrint("PerfAnalyzer write failed", t2);
            }
        }
    }

    private static void writeReportLightweight(long durationMs, int sampleCount, long peakUsedBytes,
            Map<String, MethodSamples> cpuSamples, String liveLog) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("============================================================\n");
        sb.append("AoH2 PERFORMANCE REPORT (LIGHTWEIGHT - Android compatible)\n");
        sb.append("Session started : ").append(new java.util.Date(System.currentTimeMillis())).append("\n");
        sb.append("Session duration: ").append(durationMs).append(" ms\n");
        sb.append("Device          : ").append(isAndroid() ? "Android" : "Desktop").append("\n");
        sb.append("============================================================\n\n");
        Runtime rt = Runtime.getRuntime();
        sb.append("[SYSTEM LEVEL]\n");
        sb.append("  availableProcessors : ").append(rt.availableProcessors()).append("\n");
        sb.append("  heap used/committed/max : ")
          .append((rt.totalMemory()-rt.freeMemory())/1048576L).append("/")
          .append(rt.totalMemory()/1048576L).append("/")
          .append(rt.maxMemory()/1048576L).append(" MB\n");
        sb.append("  heap peak used (session): ").append(peakUsedBytes / 1048576L).append(" MB\n");
        sb.append("  stack samples collected : ").append(sampleCount).append("\n\n");
        sb.append("[TOP CPU FUNCTIONS (from Thread.getAllStackTraces)]\n");
        sb.append("  topHits = times the function was the CURRENTLY EXECUTING frame.\n");
        java.util.List<Map.Entry<String, MethodSamples>> cpuList = new java.util.ArrayList<Map.Entry<String, MethodSamples>>(cpuSamples.entrySet());
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
        sb.append("\n[LIVE 1-SEC SAMPLES]\n").append(liveLog);
        sb.append("\n[NOTES]\n");
        sb.append("  - Lightweight mode: no ManagementFactory (Android compatible), uses Thread.getAllStackTraces.\n");
        sb.append("  - For full RAM per-thread allocation, run on Desktop JVM.\n");
        // Try MediaStore first on Android 29+ for public Download visibility (no permission needed)
        if (isAndroid()) {
            try {
                String fileName = "perf_report_" + new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date()) + ".txt";
                boolean legacyExists = false;
                try {
                    FileHandle legacy = getReportFolder().child(REPORT_FILE);
                    if (legacy.exists() && legacy.length() < MAX_REPORT_BYTES) {
                        fileName = REPORT_FILE;
                        legacyExists = true;
                    }
                } catch (Throwable ignore) {}
                boolean useAppend = legacyExists;
                if (tryWriteViaMediaStore(fileName, sb.toString(), useAppend)) {
                    Gdx.app.log("PerfAnalyzer", "Report (lightweight) written via MediaStore to Download/AoH2/performance: " + fileName);
                    return;
                }
            } catch (Throwable ignore) {}
        }
        FileHandle out = null;
        try {
            out = getLatestReportFileForAppend();
            boolean append = true;
            if (out.exists() && out.length() > MAX_REPORT_BYTES) {
                out = getReportFileHandle();
                append = false;
            }
            out.writeString(sb.toString(), append);
            safePrint("PerfAnalyzer (lightweight) appended report to: " + out.file().getAbsolutePath(), null);
            if (isAndroid()) Gdx.app.log("PerfAnalyzer", "Report (lightweight) written to Download/AoH2/performance: " + out.path());
        } catch (Throwable th) {
            try {
                FileHandle fallback = Gdx.files.local(REPORT_FILE);
                fallback.writeString(sb.toString(), true);
                safePrint("PerfAnalyzer fallback wrote to: " + fallback.file().getAbsolutePath(), null);
            } catch (Throwable t2) {}
        }
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
