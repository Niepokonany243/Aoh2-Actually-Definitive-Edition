/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx;

import com.badlogic.gdx.Graphics;

public abstract class AbstractGraphics
implements Graphics {
    @Override
    public float getRawDeltaTime() {
        return this.getDeltaTime();
    }

    @Override
    public float getDensity() {
        return this.getPpiX() / 160.0f;
    }

    @Override
    public float getBackBufferScale() {
        return (float)this.getBackBufferWidth() / (float)this.getWidth();
    }
}

