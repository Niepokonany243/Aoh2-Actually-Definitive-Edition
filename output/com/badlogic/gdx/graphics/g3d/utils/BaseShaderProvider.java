/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.utils.ShaderProvider;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;

public abstract class BaseShaderProvider
implements ShaderProvider {
    protected Array<Shader> shaders = new Array();

    @Override
    public Shader getShader(Renderable renderable) {
        Shader suggestedShader = renderable.shader;
        if (suggestedShader != null && suggestedShader.canRender(renderable)) {
            return suggestedShader;
        }
        for (Shader shader : this.shaders) {
            if (!shader.canRender(renderable)) continue;
            return shader;
        }
        Shader shader = this.createShader(renderable);
        if (!shader.canRender(renderable)) {
            throw new GdxRuntimeException("unable to provide a shader for this renderable");
        }
        shader.init();
        this.shaders.add(shader);
        return shader;
    }

    protected abstract Shader createShader(Renderable var1);

    @Override
    public void dispose() {
        for (Shader shader : this.shaders) {
            shader.dispose();
        }
        this.shaders.clear();
    }
}

