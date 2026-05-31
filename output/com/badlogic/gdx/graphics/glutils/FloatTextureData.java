/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.glutils.GLVersion;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.FloatBuffer;

public class FloatTextureData
implements TextureData {
    int width = 0;
    int height = 0;
    int internalFormat;
    int format;
    int type;
    boolean isGpuOnly;
    boolean isPrepared = false;
    FloatBuffer buffer;

    public FloatTextureData(int w, int h, int internalFormat, int format, int type, boolean isGpuOnly) {
        this.width = w;
        this.height = h;
        this.internalFormat = internalFormat;
        this.format = format;
        this.type = type;
        this.isGpuOnly = isGpuOnly;
    }

    @Override
    public TextureData.TextureDataType getType() {
        return TextureData.TextureDataType.Custom;
    }

    @Override
    public boolean isPrepared() {
        return this.isPrepared;
    }

    @Override
    public void prepare() {
        if (this.isPrepared) {
            throw new GdxRuntimeException("Already prepared");
        }
        if (!this.isGpuOnly) {
            int amountOfFloats = 4;
            if (Gdx.graphics.getGLVersion().getType().equals((Object)GLVersion.Type.OpenGL)) {
                if (this.internalFormat == 34842 || this.internalFormat == 34836) {
                    amountOfFloats = 4;
                }
                if (this.internalFormat == 34843 || this.internalFormat == 34837) {
                    amountOfFloats = 3;
                }
                if (this.internalFormat == 33327 || this.internalFormat == 33328) {
                    amountOfFloats = 2;
                }
                if (this.internalFormat == 33325 || this.internalFormat == 33326) {
                    amountOfFloats = 1;
                }
            }
            this.buffer = BufferUtils.newFloatBuffer(this.width * this.height * amountOfFloats);
        }
        this.isPrepared = true;
    }

    @Override
    public void consumeCustomData(int target) {
        if (Gdx.app.getType() == Application.ApplicationType.Android || Gdx.app.getType() == Application.ApplicationType.iOS || Gdx.app.getType() == Application.ApplicationType.WebGL) {
            if (!Gdx.graphics.supportsExtension("OES_texture_float")) {
                throw new GdxRuntimeException("Extension OES_texture_float not supported!");
            }
            Gdx.gl.glTexImage2D(target, 0, 6408, this.width, this.height, 0, 6408, 5126, this.buffer);
        } else {
            if (!Gdx.graphics.isGL30Available() && !Gdx.graphics.supportsExtension("GL_ARB_texture_float")) {
                throw new GdxRuntimeException("Extension GL_ARB_texture_float not supported!");
            }
            Gdx.gl.glTexImage2D(target, 0, this.internalFormat, this.width, this.height, 0, this.format, 5126, this.buffer);
        }
    }

    @Override
    public Pixmap consumePixmap() {
        throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
    }

    @Override
    public boolean disposePixmap() {
        throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public Pixmap.Format getFormat() {
        return Pixmap.Format.RGBA8888;
    }

    @Override
    public boolean useMipMaps() {
        return false;
    }

    @Override
    public boolean isManaged() {
        return true;
    }

    public FloatBuffer getBuffer() {
        return this.buffer;
    }
}

