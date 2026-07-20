package age.of.civilizations2.jakowski.lukasz;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.IntConsumer;

/** One bounded, lifecycle-aware worker owner shared by loading and simulation. */
public final class GameTaskScheduler {
    private static final Object lifecycleLock = new Object();
    private static final AtomicBoolean parallelCoordinator = new AtomicBoolean();
    private static volatile PausableExecutor executor = createExecutor(1, 32, "aoh2-worker");

    private GameTaskScheduler() {
    }

    public static void install(int workers, int queueCapacity, String threadPrefix) {
        if (workers < 1 || queueCapacity < 1) {
            throw new IllegalArgumentException("Scheduler capacity must be positive");
        }
        synchronized (lifecycleLock) {
            if (executor.getActiveCount() != 0 || !executor.getQueue().isEmpty()) {
                throw new IllegalStateException("Cannot replace an active game scheduler");
            }
            executor.shutdownNow();
            executor = createExecutor(workers, queueCapacity, threadPrefix);
        }
    }

    public static int parallelism() {
        return executor.getCorePoolSize();
    }

    public static ExecutorService executor() {
        return executor;
    }

    public static Future<?> submit(Runnable task) {
        return executor.submit(task);
    }

    public static void parallelRange(int startInclusive, int endExclusive, int grain, IntConsumer action) {
        if (executor.isShutdown()) {
            throw new RejectedExecutionException("Game scheduler is shut down");
        }
        int size = endExclusive - startInclusive;
        if (size <= 0) {
            return;
        }
        int workers = Math.min(parallelism(), Math.max(1, (size + grain - 1) / grain));
        if (workers == 1) {
            runRange(startInclusive, endExclusive, action);
            return;
        }

        if (executor.isWorkerThread()) {
            if (!parallelCoordinator.compareAndSet(false, true)) {
                runRange(startInclusive, endExclusive, action);
                return;
            }
            int middle = startInclusive + size / 2;
            Future<?> helper;
            try {
                helper = executor.submit(() -> runRange(middle, endExclusive, action));
            } catch (RuntimeException rejected) {
                parallelCoordinator.set(false);
                throw rejected;
            }
            try {
                runRange(startInclusive, middle, action);
                await(helper);
            } catch (RuntimeException failure) {
                helper.cancel(true);
                throw failure;
            } finally {
                parallelCoordinator.set(false);
            }
            return;
        }

        List<Future<?>> tasks = new ArrayList<Future<?>>(workers);
        int chunkSize = (size + workers - 1) / workers;
        try {
            for (int worker = 0; worker < workers; ++worker) {
                final int from = startInclusive + worker * chunkSize;
                final int to = Math.min(endExclusive, from + chunkSize);
                tasks.add(executor.submit(() -> runRange(from, to, action)));
            }
            for (Future<?> task : tasks) {
                await(task);
            }
        } catch (RuntimeException failure) {
            for (Future<?> task : tasks) {
                task.cancel(true);
            }
            throw failure;
        }
    }

    public static void pause() {
        executor.pauseWork();
    }

    public static void resume() {
        executor.resumeWork();
    }

    public static void checkpoint() {
        executor.awaitIfPaused();
        if (Thread.currentThread().isInterrupted()) {
            throw new RejectedExecutionException("Game task was cancelled");
        }
    }

    public static void shutdownAndAwait() {
        PausableExecutor current;
        synchronized (lifecycleLock) {
            current = executor;
            current.shutdownNow();
        }
        try {
            if (!current.awaitTermination(5L, TimeUnit.SECONDS)) {
                throw new IllegalStateException("Game workers did not stop before runtime disposal");
            }
        } catch (InterruptedException interrupted) {
            current.shutdownNow();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted while stopping game workers", interrupted);
        }
    }

    private static void runRange(int from, int to, IntConsumer action) {
        for (int i = from; i < to; ++i) {
            checkpoint();
            action.accept(i);
        }
    }

    private static void await(Future<?> task) {
        try {
            task.get();
        } catch (InterruptedException interrupted) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while waiting for game tasks", interrupted);
        } catch (ExecutionException failed) {
            Throwable cause = failed.getCause();
            if (cause instanceof RuntimeException) {
                throw (RuntimeException)cause;
            }
            throw new RuntimeException("Parallel game task failed", cause);
        }
    }

    private static PausableExecutor createExecutor(int workers, int queueCapacity, String prefix) {
        AtomicInteger sequence = new AtomicInteger();
        ThreadFactory factory = task -> {
            Thread thread = new Thread(task, prefix + "-" + sequence.incrementAndGet());
            thread.setDaemon(true);
            thread.setPriority(Thread.NORM_PRIORITY - 1);
            return thread;
        };
        return new PausableExecutor(workers, queueCapacity, factory);
    }

    private static final class PausableExecutor extends ThreadPoolExecutor {
        private final Object pauseLock = new Object();
        private final ThreadLocal<Boolean> workerThread = new ThreadLocal<Boolean>();
        private boolean paused;

        PausableExecutor(int workers, int queueCapacity, ThreadFactory factory) {
            super(workers, workers, 0L, TimeUnit.MILLISECONDS,
                    new ArrayBlockingQueue<Runnable>(queueCapacity), factory,
                    new ThreadPoolExecutor.AbortPolicy());
        }

        @Override
        protected void beforeExecute(Thread thread, Runnable task) {
            super.beforeExecute(thread, task);
            workerThread.set(Boolean.TRUE);
            synchronized (pauseLock) {
                while (paused && !isShutdown()) {
                    try {
                        pauseLock.wait();
                    } catch (InterruptedException interrupted) {
                        thread.interrupt();
                        return;
                    }
                }
            }
        }

        @Override
        protected void afterExecute(Runnable task, Throwable failure) {
            workerThread.remove();
            super.afterExecute(task, failure);
        }

        boolean isWorkerThread() {
            return Boolean.TRUE.equals(workerThread.get());
        }

        void pauseWork() {
            synchronized (pauseLock) {
                paused = true;
            }
        }

        void resumeWork() {
            synchronized (pauseLock) {
                paused = false;
                pauseLock.notifyAll();
            }
        }

        void awaitIfPaused() {
            synchronized (pauseLock) {
                while (paused && !isShutdown()) {
                    try {
                        pauseLock.wait();
                    } catch (InterruptedException interrupted) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }
    }
}
