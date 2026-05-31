/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.glutils.FloatFrameBuffer;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.FrameBufferCubemap;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;

public abstract class GLFrameBuffer<T extends GLTexture>
implements Disposable {
    protected static final Map<Application, Array<GLFrameBuffer>> buffers = new HashMap<Application, Array<GLFrameBuffer>>();
    protected static final int GL_DEPTH24_STENCIL8_OES = 35056;
    protected Array<T> textureAttachments = new Array();
    protected static int defaultFramebufferHandle;
    protected static boolean defaultFramebufferHandleInitialized;
    protected int framebufferHandle;
    protected int depthbufferHandle;
    protected int stencilbufferHandle;
    protected int depthStencilPackedBufferHandle;
    protected boolean hasDepthStencilPackedBuffer;
    protected boolean isMRT;
    protected GLFrameBufferBuilder<? extends GLFrameBuffer<T>> bufferBuilder;

    GLFrameBuffer() {
    }

    protected GLFrameBuffer(GLFrameBufferBuilder<? extends GLFrameBuffer<T>> bufferBuilder) {
        this.bufferBuilder = bufferBuilder;
        this.build();
    }

    public T getColorBufferTexture() {
        return (T)((GLTexture)this.textureAttachments.first());
    }

    public Array<T> getTextureAttachments() {
        return this.textureAttachments;
    }

    protected abstract T createTexture(FrameBufferTextureAttachmentSpec var1);

    protected abstract void disposeColorTexture(T var1);

    protected abstract void attachFrameBufferColorTexture(T var1);

    protected void build() {
        GL20 gl = Gdx.gl20;
        this.checkValidBuilder();
        if (!defaultFramebufferHandleInitialized) {
            defaultFramebufferHandleInitialized = true;
            if (Gdx.app.getType() == Application.ApplicationType.iOS) {
                IntBuffer intbuf = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asIntBuffer();
                gl.glGetIntegerv(36006, intbuf);
                defaultFramebufferHandle = intbuf.get(0);
            } else {
                defaultFramebufferHandle = 0;
            }
        }
        this.framebufferHandle = gl.glGenFramebuffer();
        gl.glBindFramebuffer(36160, this.framebufferHandle);
        int width = this.bufferBuilder.width;
        int height = this.bufferBuilder.height;
        if (this.bufferBuilder.hasDepthRenderBuffer) {
            this.depthbufferHandle = gl.glGenRenderbuffer();
            gl.glBindRenderbuffer(36161, this.depthbufferHandle);
            gl.glRenderbufferStorage(36161, this.bufferBuilder.depthRenderBufferSpec.internalFormat, width, height);
        }
        if (this.bufferBuilder.hasStencilRenderBuffer) {
            this.stencilbufferHandle = gl.glGenRenderbuffer();
            gl.glBindRenderbuffer(36161, this.stencilbufferHandle);
            gl.glRenderbufferStorage(36161, this.bufferBuilder.stencilRenderBufferSpec.internalFormat, width, height);
        }
        if (this.bufferBuilder.hasPackedStencilDepthRenderBuffer) {
            this.depthStencilPackedBufferHandle = gl.glGenRenderbuffer();
            gl.glBindRenderbuffer(36161, this.depthStencilPackedBufferHandle);
            gl.glRenderbufferStorage(36161, this.bufferBuilder.packedStencilDepthRenderBufferSpec.internalFormat, width, height);
        }
        this.isMRT = this.bufferBuilder.textureAttachmentSpecs.size > 1;
        int colorTextureCounter = 0;
        if (this.isMRT) {
            for (FrameBufferTextureAttachmentSpec attachmentSpec : this.bufferBuilder.textureAttachmentSpecs) {
                Object texture = this.createTexture(attachmentSpec);
                this.textureAttachments.add(texture);
                if (attachmentSpec.isColorTexture()) {
                    gl.glFramebufferTexture2D(36160, 36064 + colorTextureCounter, 3553, ((GLTexture)texture).getTextureObjectHandle(), 0);
                    ++colorTextureCounter;
                    continue;
                }
                if (attachmentSpec.isDepth) {
                    gl.glFramebufferTexture2D(36160, 36096, 3553, ((GLTexture)texture).getTextureObjectHandle(), 0);
                    continue;
                }
                if (!attachmentSpec.isStencil) continue;
                gl.glFramebufferTexture2D(36160, 36128, 3553, ((GLTexture)texture).getTextureObjectHandle(), 0);
            }
        } else {
            T texture = this.createTexture(this.bufferBuilder.textureAttachmentSpecs.first());
            this.textureAttachments.add(texture);
            gl.glBindTexture(((GLTexture)texture).glTarget, ((GLTexture)texture).getTextureObjectHandle());
        }
        if (this.isMRT) {
            IntBuffer buffer = BufferUtils.newIntBuffer(colorTextureCounter);
            for (int i = 0; i < colorTextureCounter; ++i) {
                buffer.put(36064 + i);
            }
            ((Buffer)buffer).position(0);
            Gdx.gl30.glDrawBuffers(colorTextureCounter, buffer);
        } else {
            this.attachFrameBufferColorTexture((GLTexture)this.textureAttachments.first());
        }
        if (this.bufferBuilder.hasDepthRenderBuffer) {
            gl.glFramebufferRenderbuffer(36160, 36096, 36161, this.depthbufferHandle);
        }
        if (this.bufferBuilder.hasStencilRenderBuffer) {
            gl.glFramebufferRenderbuffer(36160, 36128, 36161, this.stencilbufferHandle);
        }
        if (this.bufferBuilder.hasPackedStencilDepthRenderBuffer) {
            gl.glFramebufferRenderbuffer(36160, 33306, 36161, this.depthStencilPackedBufferHandle);
        }
        gl.glBindRenderbuffer(36161, 0);
        for (GLTexture texture : this.textureAttachments) {
            gl.glBindTexture(texture.glTarget, 0);
        }
        int result = gl.glCheckFramebufferStatus(36160);
        if (result == 36061 && this.bufferBuilder.hasDepthRenderBuffer && this.bufferBuilder.hasStencilRenderBuffer && (Gdx.graphics.supportsExtension("GL_OES_packed_depth_stencil") || Gdx.graphics.supportsExtension("GL_EXT_packed_depth_stencil"))) {
            if (this.bufferBuilder.hasDepthRenderBuffer) {
                gl.glDeleteRenderbuffer(this.depthbufferHandle);
                this.depthbufferHandle = 0;
            }
            if (this.bufferBuilder.hasStencilRenderBuffer) {
                gl.glDeleteRenderbuffer(this.stencilbufferHandle);
                this.stencilbufferHandle = 0;
            }
            if (this.bufferBuilder.hasPackedStencilDepthRenderBuffer) {
                gl.glDeleteRenderbuffer(this.depthStencilPackedBufferHandle);
                this.depthStencilPackedBufferHandle = 0;
            }
            this.depthStencilPackedBufferHandle = gl.glGenRenderbuffer();
            this.hasDepthStencilPackedBuffer = true;
            gl.glBindRenderbuffer(36161, this.depthStencilPackedBufferHandle);
            gl.glRenderbufferStorage(36161, 35056, width, height);
            gl.glBindRenderbuffer(36161, 0);
            gl.glFramebufferRenderbuffer(36160, 36096, 36161, this.depthStencilPackedBufferHandle);
            gl.glFramebufferRenderbuffer(36160, 36128, 36161, this.depthStencilPackedBufferHandle);
            result = gl.glCheckFramebufferStatus(36160);
        }
        gl.glBindFramebuffer(36160, defaultFramebufferHandle);
        if (result != 36053) {
            for (Object texture : this.textureAttachments) {
                this.disposeColorTexture(texture);
            }
            if (this.hasDepthStencilPackedBuffer) {
                gl.glDeleteBuffer(this.depthStencilPackedBufferHandle);
            } else {
                if (this.bufferBuilder.hasDepthRenderBuffer) {
                    gl.glDeleteRenderbuffer(this.depthbufferHandle);
                }
                if (this.bufferBuilder.hasStencilRenderBuffer) {
                    gl.glDeleteRenderbuffer(this.stencilbufferHandle);
                }
            }
            gl.glDeleteFramebuffer(this.framebufferHandle);
            if (result == 36054) {
                throw new IllegalStateException("Frame buffer couldn't be constructed: incomplete attachment");
            }
            if (result == 36057) {
                throw new IllegalStateException("Frame buffer couldn't be constructed: incomplete dimensions");
            }
            if (result == 36055) {
                throw new IllegalStateException("Frame buffer couldn't be constructed: missing attachment");
            }
            if (result == 36061) {
                throw new IllegalStateException("Frame buffer couldn't be constructed: unsupported combination of formats");
            }
            throw new IllegalStateException("Frame buffer couldn't be constructed: unknown error " + result);
        }
        GLFrameBuffer.addManagedFrameBuffer(Gdx.app, this);
    }

    private void checkValidBuilder() {
        boolean runningGL30 = Gdx.graphics.isGL30Available();
        if (!runningGL30) {
            if (this.bufferBuilder.hasPackedStencilDepthRenderBuffer) {
                throw new GdxRuntimeException("Packed Stencil/Render render buffers are not available on GLES 2.0");
            }
            if (this.bufferBuilder.textureAttachmentSpecs.size > 1) {
                throw new GdxRuntimeException("Multiple render targets not available on GLES 2.0");
            }
            for (FrameBufferTextureAttachmentSpec spec : this.bufferBuilder.textureAttachmentSpecs) {
                if (spec.isDepth) {
                    throw new GdxRuntimeException("Depth texture FrameBuffer Attachment not available on GLES 2.0");
                }
                if (spec.isStencil) {
                    throw new GdxRuntimeException("Stencil texture FrameBuffer Attachment not available on GLES 2.0");
                }
                if (!spec.isFloat || Gdx.graphics.supportsExtension("OES_texture_float")) continue;
                throw new GdxRuntimeException("Float texture FrameBuffer Attachment not available on GLES 2.0");
            }
        }
    }

    @Override
    public void dispose() {
        GL20 gl = Gdx.gl20;
        for (GLTexture texture : this.textureAttachments) {
            this.disposeColorTexture(texture);
        }
        if (this.hasDepthStencilPackedBuffer) {
            gl.glDeleteRenderbuffer(this.depthStencilPackedBufferHandle);
        } else {
            if (this.bufferBuilder.hasDepthRenderBuffer) {
                gl.glDeleteRenderbuffer(this.depthbufferHandle);
            }
            if (this.bufferBuilder.hasStencilRenderBuffer) {
                gl.glDeleteRenderbuffer(this.stencilbufferHandle);
            }
        }
        gl.glDeleteFramebuffer(this.framebufferHandle);
        if (buffers.get(Gdx.app) != null) {
            buffers.get(Gdx.app).removeValue(this, true);
        }
    }

    public void bind() {
        Gdx.gl20.glBindFramebuffer(36160, this.framebufferHandle);
    }

    public static void unbind() {
        Gdx.gl20.glBindFramebuffer(36160, defaultFramebufferHandle);
    }

    public void begin() {
        this.bind();
        this.setFrameBufferViewport();
    }

    protected void setFrameBufferViewport() {
        Gdx.gl20.glViewport(0, 0, this.bufferBuilder.width, this.bufferBuilder.height);
    }

    public void end() {
        this.end(0, 0, Gdx.graphics.getBackBufferWidth(), Gdx.graphics.getBackBufferHeight());
    }

    public void end(int x, int y, int width, int height) {
        GLFrameBuffer.unbind();
        Gdx.gl20.glViewport(x, y, width, height);
    }

    public int getFramebufferHandle() {
        return this.framebufferHandle;
    }

    public int getDepthBufferHandle() {
        return this.depthbufferHandle;
    }

    public int getStencilBufferHandle() {
        return this.stencilbufferHandle;
    }

    protected int getDepthStencilPackedBuffer() {
        return this.depthStencilPackedBufferHandle;
    }

    public int getHeight() {
        return this.bufferBuilder.height;
    }

    public int getWidth() {
        return this.bufferBuilder.width;
    }

    private static void addManagedFrameBuffer(Application app, GLFrameBuffer frameBuffer) {
        Array managedResources = buffers.get(app);
        if (managedResources == null) {
            managedResources = new Array();
        }
        managedResources.add(frameBuffer);
        buffers.put(app, managedResources);
    }

    public static void invalidateAllFrameBuffers(Application app) {
        if (Gdx.gl20 == null) {
            return;
        }
        Array<GLFrameBuffer> bufferArray = buffers.get(app);
        if (bufferArray == null) {
            return;
        }
        for (int i = 0; i < bufferArray.size; ++i) {
            bufferArray.get(i).build();
        }
    }

    public static void clearAllFrameBuffers(Application app) {
        buffers.remove(app);
    }

    public static StringBuilder getManagedStatus(StringBuilder builder) {
        builder.append("Managed buffers/app: { ");
        for (Application app : buffers.keySet()) {
            builder.append(GLFrameBuffer.buffers.get((Object)app).size);
            builder.append(" ");
        }
        builder.append("}");
        return builder;
    }

    public static String getManagedStatus() {
        return GLFrameBuffer.getManagedStatus(new StringBuilder()).toString();
    }

    static {
        defaultFramebufferHandleInitialized = false;
    }

    public static class FrameBufferCubemapBuilder
    extends GLFrameBufferBuilder<FrameBufferCubemap> {
        public FrameBufferCubemapBuilder(int width, int height) {
            super(width, height);
        }

        @Override
        public FrameBufferCubemap build() {
            return new FrameBufferCubemap(this);
        }
    }

    public static class FloatFrameBufferBuilder
    extends GLFrameBufferBuilder<FloatFrameBuffer> {
        public FloatFrameBufferBuilder(int width, int height) {
            super(width, height);
        }

        @Override
        public FloatFrameBuffer build() {
            return new FloatFrameBuffer(this);
        }
    }

    public static class FrameBufferBuilder
    extends GLFrameBufferBuilder<FrameBuffer> {
        public FrameBufferBuilder(int width, int height) {
            super(width, height);
        }

        @Override
        public FrameBuffer build() {
            return new FrameBuffer(this);
        }
    }

    public static abstract class GLFrameBufferBuilder<U extends GLFrameBuffer<? extends GLTexture>> {
        protected int width;
        protected int height;
        protected Array<FrameBufferTextureAttachmentSpec> textureAttachmentSpecs = new Array();
        protected FrameBufferRenderBufferAttachmentSpec stencilRenderBufferSpec;
        protected FrameBufferRenderBufferAttachmentSpec depthRenderBufferSpec;
        protected FrameBufferRenderBufferAttachmentSpec packedStencilDepthRenderBufferSpec;
        protected boolean hasStencilRenderBuffer;
        protected boolean hasDepthRenderBuffer;
        protected boolean hasPackedStencilDepthRenderBuffer;

        public GLFrameBufferBuilder(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public GLFrameBufferBuilder<U> addColorTextureAttachment(int internalFormat, int format, int type) {
            this.textureAttachmentSpecs.add(new FrameBufferTextureAttachmentSpec(internalFormat, format, type));
            return this;
        }

        public GLFrameBufferBuilder<U> addBasicColorTextureAttachment(Pixmap.Format format) {
            int glFormat = Pixmap.Format.toGlFormat(format);
            int glType = Pixmap.Format.toGlType(format);
            return this.addColorTextureAttachment(glFormat, glFormat, glType);
        }

        public GLFrameBufferBuilder<U> addFloatAttachment(int internalFormat, int format, int type, boolean gpuOnly) {
            FrameBufferTextureAttachmentSpec spec = new FrameBufferTextureAttachmentSpec(internalFormat, format, type);
            spec.isFloat = true;
            spec.isGpuOnly = gpuOnly;
            this.textureAttachmentSpecs.add(spec);
            return this;
        }

        public GLFrameBufferBuilder<U> addDepthTextureAttachment(int internalFormat, int type) {
            FrameBufferTextureAttachmentSpec spec = new FrameBufferTextureAttachmentSpec(internalFormat, 6402, type);
            spec.isDepth = true;
            this.textureAttachmentSpecs.add(spec);
            return this;
        }

        public GLFrameBufferBuilder<U> addStencilTextureAttachment(int internalFormat, int type) {
            FrameBufferTextureAttachmentSpec spec = new FrameBufferTextureAttachmentSpec(internalFormat, 36128, type);
            spec.isStencil = true;
            this.textureAttachmentSpecs.add(spec);
            return this;
        }

        public GLFrameBufferBuilder<U> addDepthRenderBuffer(int internalFormat) {
            this.depthRenderBufferSpec = new FrameBufferRenderBufferAttachmentSpec(internalFormat);
            this.hasDepthRenderBuffer = true;
            return this;
        }

        public GLFrameBufferBuilder<U> addStencilRenderBuffer(int internalFormat) {
            this.stencilRenderBufferSpec = new FrameBufferRenderBufferAttachmentSpec(internalFormat);
            this.hasStencilRenderBuffer = true;
            return this;
        }

        public GLFrameBufferBuilder<U> addStencilDepthPackedRenderBuffer(int internalFormat) {
            this.packedStencilDepthRenderBufferSpec = new FrameBufferRenderBufferAttachmentSpec(internalFormat);
            this.hasPackedStencilDepthRenderBuffer = true;
            return this;
        }

        public GLFrameBufferBuilder<U> addBasicDepthRenderBuffer() {
            return this.addDepthRenderBuffer(33189);
        }

        public GLFrameBufferBuilder<U> addBasicStencilRenderBuffer() {
            return this.addStencilRenderBuffer(36168);
        }

        public GLFrameBufferBuilder<U> addBasicStencilDepthPackedRenderBuffer() {
            return this.addStencilDepthPackedRenderBuffer(35056);
        }

        public abstract U build();
    }

    protected static class FrameBufferRenderBufferAttachmentSpec {
        int internalFormat;

        public FrameBufferRenderBufferAttachmentSpec(int internalFormat) {
            this.internalFormat = internalFormat;
        }
    }

    protected static class FrameBufferTextureAttachmentSpec {
        int internalFormat;
        int format;
        int type;
        boolean isFloat;
        boolean isGpuOnly;
        boolean isDepth;
        boolean isStencil;

        public FrameBufferTextureAttachmentSpec(int internalformat, int format, int type) {
            this.internalFormat = internalformat;
            this.format = format;
            this.type = type;
        }

        public boolean isColorTexture() {
            return !this.isDepth && !this.isStencil;
        }
    }
}

