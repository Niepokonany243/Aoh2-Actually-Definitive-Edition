/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.LifecycleListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class Timer {
    static final Object threadLock = new Object();
    static TimerThread thread;
    final Array<Task> tasks = new Array(false, 8);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Timer instance() {
        Object object = threadLock;
        synchronized (object) {
            TimerThread thread = Timer.thread();
            if (thread.instance == null) {
                thread.instance = new Timer();
            }
            return thread.instance;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static TimerThread thread() {
        Object object = threadLock;
        synchronized (object) {
            if (thread == null || Timer.thread.files != Gdx.files) {
                if (thread != null) {
                    thread.dispose();
                }
                thread = new TimerThread();
            }
            return thread;
        }
    }

    public Timer() {
        this.start();
    }

    public Task postTask(Task task) {
        return this.scheduleTask(task, 0.0f, 0.0f, 0);
    }

    public Task scheduleTask(Task task, float delaySeconds) {
        return this.scheduleTask(task, delaySeconds, 0.0f, 0);
    }

    public Task scheduleTask(Task task, float delaySeconds, float intervalSeconds) {
        return this.scheduleTask(task, delaySeconds, intervalSeconds, -1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Task scheduleTask(Task task, float delaySeconds, float intervalSeconds, int repeatCount) {
        Object object = threadLock;
        synchronized (object) {
            Timer timer = this;
            synchronized (timer) {
                Task task2 = task;
                synchronized (task2) {
                    if (task.timer != null) {
                        throw new IllegalArgumentException("The same task may not be scheduled twice.");
                    }
                    task.timer = this;
                    long timeMillis = System.nanoTime() / 1000000L;
                    long executeTimeMillis = timeMillis + (long)(delaySeconds * 1000.0f);
                    if (Timer.thread.pauseTimeMillis > 0L) {
                        executeTimeMillis -= timeMillis - Timer.thread.pauseTimeMillis;
                    }
                    task.executeTimeMillis = executeTimeMillis;
                    task.intervalMillis = (long)(intervalSeconds * 1000.0f);
                    task.repeatCount = repeatCount;
                    this.tasks.add(task);
                }
            }
            threadLock.notifyAll();
        }
        return task;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void stop() {
        Object object = threadLock;
        synchronized (object) {
            Timer.thread().instances.removeValue(this, true);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void start() {
        Object object = threadLock;
        synchronized (object) {
            TimerThread thread = Timer.thread();
            Array<Timer> instances = thread.instances;
            if (instances.contains(this, true)) {
                return;
            }
            instances.add(this);
            threadLock.notifyAll();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized void clear() {
        int n = this.tasks.size;
        for (int i = 0; i < n; ++i) {
            Task task;
            Task task2 = task = this.tasks.get(i);
            synchronized (task2) {
                task.executeTimeMillis = 0L;
                task.timer = null;
                continue;
            }
        }
        this.tasks.clear();
    }

    public synchronized boolean isEmpty() {
        return this.tasks.size == 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    synchronized long update(long timeMillis, long waitMillis) {
        int n = this.tasks.size;
        for (int i = 0; i < n; ++i) {
            Task task;
            Task task2 = task = this.tasks.get(i);
            synchronized (task2) {
                if (task.executeTimeMillis > timeMillis) {
                    waitMillis = Math.min(waitMillis, task.executeTimeMillis - timeMillis);
                    continue;
                }
                if (task.repeatCount == 0) {
                    task.timer = null;
                    this.tasks.removeIndex(i);
                    --i;
                    --n;
                } else {
                    task.executeTimeMillis = timeMillis + task.intervalMillis;
                    waitMillis = Math.min(waitMillis, task.intervalMillis);
                    if (task.repeatCount > 0) {
                        --task.repeatCount;
                    }
                }
                task.app.postRunnable(task);
                continue;
            }
        }
        return waitMillis;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized void delay(long delayMillis) {
        int n = this.tasks.size;
        for (int i = 0; i < n; ++i) {
            Task task;
            Task task2 = task = this.tasks.get(i);
            synchronized (task2) {
                task.executeTimeMillis += delayMillis;
                continue;
            }
        }
    }

    public static Task post(Task task) {
        return Timer.instance().postTask(task);
    }

    public static Task schedule(Task task, float delaySeconds) {
        return Timer.instance().scheduleTask(task, delaySeconds);
    }

    public static Task schedule(Task task, float delaySeconds, float intervalSeconds) {
        return Timer.instance().scheduleTask(task, delaySeconds, intervalSeconds);
    }

    public static Task schedule(Task task, float delaySeconds, float intervalSeconds, int repeatCount) {
        return Timer.instance().scheduleTask(task, delaySeconds, intervalSeconds, repeatCount);
    }

    static class TimerThread
    implements Runnable,
    LifecycleListener {
        final Files files;
        final Application app;
        final Array<Timer> instances = new Array(1);
        Timer instance;
        long pauseTimeMillis;

        public TimerThread() {
            this.files = Gdx.files;
            this.app = Gdx.app;
            this.app.addLifecycleListener(this);
            this.resume();
            Thread thread = new Thread((Runnable)this, "Timer");
            thread.setDaemon(true);
            thread.start();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void run() {
            while (true) {
                Object object = threadLock;
                synchronized (object) {
                    if (thread != this || this.files != Gdx.files) {
                        break;
                    }
                    long waitMillis = 5000L;
                    if (this.pauseTimeMillis == 0L) {
                        long timeMillis = System.nanoTime() / 1000000L;
                        int n = this.instances.size;
                        for (int i = 0; i < n; ++i) {
                            try {
                                waitMillis = this.instances.get(i).update(timeMillis, waitMillis);
                                continue;
                            }
                            catch (Throwable ex) {
                                throw new GdxRuntimeException("Task failed: " + this.instances.get(i).getClass().getName(), ex);
                            }
                        }
                    }
                    if (thread != this || this.files != Gdx.files) {
                        break;
                    }
                    try {
                        if (waitMillis > 0L) {
                            threadLock.wait(waitMillis);
                        }
                    }
                    catch (InterruptedException interruptedException) {
                        // empty catch block
                    }
                }
            }
            this.dispose();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void resume() {
            Object object = threadLock;
            synchronized (object) {
                long delayMillis = System.nanoTime() / 1000000L - this.pauseTimeMillis;
                int n = this.instances.size;
                for (int i = 0; i < n; ++i) {
                    this.instances.get(i).delay(delayMillis);
                }
                this.pauseTimeMillis = 0L;
                threadLock.notifyAll();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void pause() {
            Object object = threadLock;
            synchronized (object) {
                this.pauseTimeMillis = System.nanoTime() / 1000000L;
                threadLock.notifyAll();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void dispose() {
            Object object = threadLock;
            synchronized (object) {
                if (thread == this) {
                    thread = null;
                }
                this.instances.clear();
                threadLock.notifyAll();
            }
            this.app.removeLifecycleListener(this);
        }
    }

    public static abstract class Task
    implements Runnable {
        final Application app = Gdx.app;
        long executeTimeMillis;
        long intervalMillis;
        int repeatCount;
        volatile Timer timer;

        public Task() {
            if (this.app == null) {
                throw new IllegalStateException("Gdx.app not available.");
            }
        }

        @Override
        public abstract void run();

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void cancel() {
            Timer timer = this.timer;
            if (timer != null) {
                Timer timer2 = timer;
                synchronized (timer2) {
                    Task task = this;
                    synchronized (task) {
                        this.executeTimeMillis = 0L;
                        this.timer = null;
                        timer.tasks.removeValue(this, true);
                    }
                }
            }
            Task task = this;
            synchronized (task) {
                this.executeTimeMillis = 0L;
                this.timer = null;
            }
        }

        public boolean isScheduled() {
            return this.timer != null;
        }

        public synchronized long getExecuteTimeMillis() {
            return this.executeTimeMillis;
        }
    }
}

