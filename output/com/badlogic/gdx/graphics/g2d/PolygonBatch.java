/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;

public interface PolygonBatch
extends Batch {
    public void draw(PolygonRegion var1, float var2, float var3);

    public void draw(PolygonRegion var1, float var2, float var3, float var4, float var5);

    public void draw(PolygonRegion var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10);

    public void draw(Texture var1, float[] var2, int var3, int var4, short[] var5, int var6, int var7);
}

