/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.GLFrameBuffer;
import com.badlogic.gdx.graphics.glutils.GLOnlyTextureData;

public class FrameBuffer
extends GLFrameBuffer<Texture> {
    FrameBuffer() {
    }

    protected FrameBuffer(GLFrameBuffer.GLFrameBufferBuilder<? extends GLFrameBuffer<Texture>> bufferBuilder) {
        super(bufferBuilder);
    }

    public FrameBuffer(Pixmap.Format format, int width, int height, boolean hasDepth) {
        this(format, width, height, hasDepth, false);
    }

    public FrameBuffer(Pixmap.Format format, int width, int height, boolean hasDepth, boolean hasStencil) {
        GLFrameBuffer.FrameBufferBuilder frameBufferBuilder = new GLFrameBuffer.FrameBufferBuilder(width, height);
        frameBufferBuilder.addBasicColorTextureAttachment(format);
        if (hasDepth) {
            frameBufferBuilder.addBasicDepthRenderBuffer();
        }
        if (hasStencil) {
            frameBufferBuilder.addBasicStencilRenderBuffer();
        }
        this.bufferBuilder = frameBufferBuilder;
        this.build();
    }

    @Override
    protected Texture createTexture(GLFrameBuffer.FrameBufferTextureAttachmentSpec attachmentSpec) {
        GLOnlyTextureData data = new GLOnlyTextureData(this.bufferBuilder.width, this.bufferBuilder.height, 0, attachmentSpec.internalFormat, attachmentSpec.format, attachmentSpec.type);
        Texture result = new Texture(data);
        result.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        result.setWrap(Texture.TextureWrap.ClampToEdge, Texture.TextureWrap.ClampToEdge);
        return result;
    }

    @Override
    protected void disposeColorTexture(Texture colorTexture) {
        colorTexture.dispose();
    }

    @Override
    protected void attachFrameBufferColorTexture(Texture texture) {
        Gdx.gl20.glFramebufferTexture2D(36160, 36064, 3553, texture.getTextureObjectHandle(), 0);
    }

    public static void unbind() {
        GLFrameBuffer.unbind();
    }
}

