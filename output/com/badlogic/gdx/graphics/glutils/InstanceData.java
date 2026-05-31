/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.Disposable;
import java.nio.FloatBuffer;

public interface InstanceData
extends Disposable {
    public int getNumInstances();

    public int getNumMaxInstances();

    public VertexAttributes getAttributes();

    public void setInstanceData(float[] var1, int var2, int var3);

    public void updateInstanceData(int var1, float[] var2, int var3, int var4);

    public void setInstanceData(FloatBuffer var1, int var2);

    public void updateInstanceData(int var1, FloatBuffer var2, int var3, int var4);

    public FloatBuffer getBuffer();

    public void bind(ShaderProgram var1);

    public void bind(ShaderProgram var1, int[] var2);

    public void unbind(ShaderProgram var1);

    public void unbind(ShaderProgram var1, int[] var2);

    public void invalidate();

    @Override
    public void dispose();
}

