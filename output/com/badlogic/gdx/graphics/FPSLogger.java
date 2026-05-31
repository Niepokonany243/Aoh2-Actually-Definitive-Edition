/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;

public class FPSLogger {
    long startTime;
    int bound;

    public FPSLogger() {
        this(Integer.MAX_VALUE);
    }

    public FPSLogger(int bound) {
        this.bound = bound;
        this.startTime = TimeUtils.nanoTime();
    }

    public void log() {
        int fps;
        long nanoTime = TimeUtils.nanoTime();
        if (nanoTime - this.startTime > 1000000000L && (fps = Gdx.graphics.getFramesPerSecond()) < this.bound) {
            Gdx.app.log("FPSLogger", "fps: " + fps);
            this.startTime = nanoTime;
        }
    }
}

