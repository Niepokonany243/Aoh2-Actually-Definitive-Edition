/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import org.lwjgl.glfw.GLFW;

class Sync {
    private static final long NANOS_IN_SECOND = 1000000000L;
    private long nextFrame = 0L;
    private boolean initialised = false;
    private RunningAvg sleepDurations = new RunningAvg(10);
    private RunningAvg yieldDurations = new RunningAvg(10);

    public void sync(int fps) {
        if (fps <= 0) {
            return;
        }
        if (!this.initialised) {
            this.initialise();
        }
        try {
            long t1;
            long t0 = this.getTime();
            while (this.nextFrame - t0 > this.sleepDurations.avg()) {
                Thread.sleep(1L);
                t1 = this.getTime();
                this.sleepDurations.add(t1 - t0);
                t0 = t1;
            }
            this.sleepDurations.dampenForLowResTicker();
            t0 = this.getTime();
            while (this.nextFrame - t0 > this.yieldDurations.avg()) {
                Thread.yield();
                t1 = this.getTime();
                this.yieldDurations.add(t1 - t0);
                t0 = t1;
            }
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        this.nextFrame = Math.max(this.nextFrame + 1000000000L / (long)fps, this.getTime());
    }

    private void initialise() {
        this.initialised = true;
        this.sleepDurations.init(1000000L);
        this.yieldDurations.init((int)((double)(-(this.getTime() - this.getTime())) * 1.333));
        this.nextFrame = this.getTime();
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Win")) {
            Thread timerAccuracyThread = new Thread(new Runnable(){

                @Override
                public void run() {
                    try {
                        Thread.sleep(Long.MAX_VALUE);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
            });
            timerAccuracyThread.setName("LWJGL3 Timer");
            timerAccuracyThread.setDaemon(true);
            timerAccuracyThread.start();
        }
    }

    private long getTime() {
        return (long)(GLFW.glfwGetTime() * 1.0E9);
    }

    private class RunningAvg {
        private final long[] slots;
        private int offset;
        private static final long DAMPEN_THRESHOLD = 10000000L;
        private static final float DAMPEN_FACTOR = 0.9f;

        public RunningAvg(int slotCount) {
            this.slots = new long[slotCount];
            this.offset = 0;
        }

        public void init(long value) {
            while (this.offset < this.slots.length) {
                this.slots[this.offset++] = value;
            }
        }

        public void add(long value) {
            this.slots[this.offset++ % this.slots.length] = value;
            this.offset %= this.slots.length;
        }

        public long avg() {
            long sum = 0L;
            for (int i = 0; i < this.slots.length; ++i) {
                sum += this.slots[i];
            }
            return sum / (long)this.slots.length;
        }

        public void dampenForLowResTicker() {
            if (this.avg() > 10000000L) {
                int i = 0;
                while (i < this.slots.length) {
                    int n = i++;
                    this.slots[n] = (long)((float)this.slots[n] * 0.9f);
                }
            }
        }
    }
}

