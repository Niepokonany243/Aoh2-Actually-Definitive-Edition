/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct GLFWimage")
public class GLFWImage
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int WIDTH;
    public static final int HEIGHT;
    public static final int PIXELS;

    public GLFWImage(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), GLFWImage.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int width() {
        return GLFWImage.nwidth(this.address());
    }

    public int height() {
        return GLFWImage.nheight(this.address());
    }

    @NativeType(value="unsigned char *")
    public ByteBuffer pixels(int capacity) {
        return GLFWImage.npixels(this.address(), capacity);
    }

    public GLFWImage width(int value) {
        GLFWImage.nwidth(this.address(), value);
        return this;
    }

    public GLFWImage height(int value) {
        GLFWImage.nheight(this.address(), value);
        return this;
    }

    public GLFWImage pixels(@NativeType(value="unsigned char *") ByteBuffer value) {
        GLFWImage.npixels(this.address(), value);
        return this;
    }

    public GLFWImage set(int width, int height, ByteBuffer pixels) {
        this.width(width);
        this.height(height);
        this.pixels(pixels);
        return this;
    }

    public GLFWImage set(GLFWImage src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static GLFWImage malloc() {
        return GLFWImage.wrap(GLFWImage.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static GLFWImage calloc() {
        return GLFWImage.wrap(GLFWImage.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static GLFWImage create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return GLFWImage.wrap(GLFWImage.class, MemoryUtil.memAddress(container), container);
    }

    public static GLFWImage create(long address) {
        return GLFWImage.wrap(GLFWImage.class, address);
    }

    @Nullable
    public static GLFWImage createSafe(long address) {
        return address == 0L ? null : GLFWImage.wrap(GLFWImage.class, address);
    }

    public static Buffer malloc(int capacity) {
        return GLFWImage.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(GLFWImage.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return GLFWImage.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = GLFWImage.__create(capacity, SIZEOF);
        return GLFWImage.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return GLFWImage.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : GLFWImage.wrap(Buffer.class, address, capacity);
    }

    public static GLFWImage mallocStack() {
        return GLFWImage.mallocStack(MemoryStack.stackGet());
    }

    public static GLFWImage callocStack() {
        return GLFWImage.callocStack(MemoryStack.stackGet());
    }

    public static GLFWImage mallocStack(MemoryStack stack) {
        return GLFWImage.wrap(GLFWImage.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static GLFWImage callocStack(MemoryStack stack) {
        return GLFWImage.wrap(GLFWImage.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return GLFWImage.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return GLFWImage.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return GLFWImage.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return GLFWImage.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    public static int nwidth(long struct) {
        return UNSAFE.getInt(null, struct + (long)WIDTH);
    }

    public static int nheight(long struct) {
        return UNSAFE.getInt(null, struct + (long)HEIGHT);
    }

    public static ByteBuffer npixels(long struct, int capacity) {
        return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(struct + (long)PIXELS), capacity);
    }

    public static void nwidth(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)WIDTH, value);
    }

    public static void nheight(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)HEIGHT, value);
    }

    public static void npixels(long struct, ByteBuffer value) {
        MemoryUtil.memPutAddress(struct + (long)PIXELS, MemoryUtil.memAddress(value));
    }

    public static void validate(long struct) {
        Checks.check(MemoryUtil.memGetAddress(struct + (long)PIXELS));
    }

    public static void validate(long array, int count) {
        for (int i = 0; i < count; ++i) {
            GLFWImage.validate(array + Integer.toUnsignedLong(i) * (long)SIZEOF);
        }
    }

    static {
        Struct.Layout layout = GLFWImage.__struct(GLFWImage.__member(4), GLFWImage.__member(4), GLFWImage.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        WIDTH = layout.offsetof(0);
        HEIGHT = layout.offsetof(1);
        PIXELS = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<GLFWImage, Buffer>
    implements NativeResource {
        private static final GLFWImage ELEMENT_FACTORY = GLFWImage.create(-1L);

        public Buffer(ByteBuffer container) {
            super(container, container.remaining() / SIZEOF);
        }

        public Buffer(long address, int cap) {
            super(address, null, -1, 0, cap, cap);
        }

        Buffer(long address, @Nullable ByteBuffer container, int mark, int pos, int lim, int cap) {
            super(address, container, mark, pos, lim, cap);
        }

        @Override
        protected Buffer self() {
            return this;
        }

        @Override
        protected GLFWImage getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int width() {
            return GLFWImage.nwidth(this.address());
        }

        public int height() {
            return GLFWImage.nheight(this.address());
        }

        @NativeType(value="unsigned char *")
        public ByteBuffer pixels(int capacity) {
            return GLFWImage.npixels(this.address(), capacity);
        }

        public Buffer width(int value) {
            GLFWImage.nwidth(this.address(), value);
            return this;
        }

        public Buffer height(int value) {
            GLFWImage.nheight(this.address(), value);
            return this;
        }

        public Buffer pixels(@NativeType(value="unsigned char *") ByteBuffer value) {
            GLFWImage.npixels(this.address(), value);
            return this;
        }
    }
}

