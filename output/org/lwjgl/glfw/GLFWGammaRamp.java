/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct GLFWgammaramp")
public class GLFWGammaRamp
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int RED;
    public static final int GREEN;
    public static final int BLUE;
    public static final int SIZE;

    public GLFWGammaRamp(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), GLFWGammaRamp.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="unsigned short *")
    public ShortBuffer red() {
        return GLFWGammaRamp.nred(this.address());
    }

    @NativeType(value="unsigned short *")
    public ShortBuffer green() {
        return GLFWGammaRamp.ngreen(this.address());
    }

    @NativeType(value="unsigned short *")
    public ShortBuffer blue() {
        return GLFWGammaRamp.nblue(this.address());
    }

    @NativeType(value="unsigned int")
    public int size() {
        return GLFWGammaRamp.nsize(this.address());
    }

    public GLFWGammaRamp red(@NativeType(value="unsigned short *") ShortBuffer value) {
        GLFWGammaRamp.nred(this.address(), value);
        return this;
    }

    public GLFWGammaRamp green(@NativeType(value="unsigned short *") ShortBuffer value) {
        GLFWGammaRamp.ngreen(this.address(), value);
        return this;
    }

    public GLFWGammaRamp blue(@NativeType(value="unsigned short *") ShortBuffer value) {
        GLFWGammaRamp.nblue(this.address(), value);
        return this;
    }

    public GLFWGammaRamp size(@NativeType(value="unsigned int") int value) {
        GLFWGammaRamp.nsize(this.address(), value);
        return this;
    }

    public GLFWGammaRamp set(ShortBuffer red, ShortBuffer green, ShortBuffer blue, int size) {
        this.red(red);
        this.green(green);
        this.blue(blue);
        this.size(size);
        return this;
    }

    public GLFWGammaRamp set(GLFWGammaRamp src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static GLFWGammaRamp malloc() {
        return GLFWGammaRamp.wrap(GLFWGammaRamp.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static GLFWGammaRamp calloc() {
        return GLFWGammaRamp.wrap(GLFWGammaRamp.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static GLFWGammaRamp create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return GLFWGammaRamp.wrap(GLFWGammaRamp.class, MemoryUtil.memAddress(container), container);
    }

    public static GLFWGammaRamp create(long address) {
        return GLFWGammaRamp.wrap(GLFWGammaRamp.class, address);
    }

    @Nullable
    public static GLFWGammaRamp createSafe(long address) {
        return address == 0L ? null : GLFWGammaRamp.wrap(GLFWGammaRamp.class, address);
    }

    public static Buffer malloc(int capacity) {
        return GLFWGammaRamp.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(GLFWGammaRamp.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return GLFWGammaRamp.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = GLFWGammaRamp.__create(capacity, SIZEOF);
        return GLFWGammaRamp.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return GLFWGammaRamp.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : GLFWGammaRamp.wrap(Buffer.class, address, capacity);
    }

    public static GLFWGammaRamp mallocStack() {
        return GLFWGammaRamp.mallocStack(MemoryStack.stackGet());
    }

    public static GLFWGammaRamp callocStack() {
        return GLFWGammaRamp.callocStack(MemoryStack.stackGet());
    }

    public static GLFWGammaRamp mallocStack(MemoryStack stack) {
        return GLFWGammaRamp.wrap(GLFWGammaRamp.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static GLFWGammaRamp callocStack(MemoryStack stack) {
        return GLFWGammaRamp.wrap(GLFWGammaRamp.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return GLFWGammaRamp.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return GLFWGammaRamp.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return GLFWGammaRamp.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return GLFWGammaRamp.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    public static ShortBuffer nred(long struct) {
        return MemoryUtil.memShortBuffer(MemoryUtil.memGetAddress(struct + (long)RED), GLFWGammaRamp.nsize(struct));
    }

    public static ShortBuffer ngreen(long struct) {
        return MemoryUtil.memShortBuffer(MemoryUtil.memGetAddress(struct + (long)GREEN), GLFWGammaRamp.nsize(struct));
    }

    public static ShortBuffer nblue(long struct) {
        return MemoryUtil.memShortBuffer(MemoryUtil.memGetAddress(struct + (long)BLUE), GLFWGammaRamp.nsize(struct));
    }

    public static int nsize(long struct) {
        return UNSAFE.getInt(null, struct + (long)SIZE);
    }

    public static void nred(long struct, ShortBuffer value) {
        MemoryUtil.memPutAddress(struct + (long)RED, MemoryUtil.memAddress(value));
    }

    public static void ngreen(long struct, ShortBuffer value) {
        MemoryUtil.memPutAddress(struct + (long)GREEN, MemoryUtil.memAddress(value));
    }

    public static void nblue(long struct, ShortBuffer value) {
        MemoryUtil.memPutAddress(struct + (long)BLUE, MemoryUtil.memAddress(value));
    }

    public static void nsize(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)SIZE, value);
    }

    public static void validate(long struct) {
        Checks.check(MemoryUtil.memGetAddress(struct + (long)RED));
        Checks.check(MemoryUtil.memGetAddress(struct + (long)GREEN));
        Checks.check(MemoryUtil.memGetAddress(struct + (long)BLUE));
    }

    public static void validate(long array, int count) {
        for (int i = 0; i < count; ++i) {
            GLFWGammaRamp.validate(array + Integer.toUnsignedLong(i) * (long)SIZEOF);
        }
    }

    static {
        Struct.Layout layout = GLFWGammaRamp.__struct(GLFWGammaRamp.__member(POINTER_SIZE), GLFWGammaRamp.__member(POINTER_SIZE), GLFWGammaRamp.__member(POINTER_SIZE), GLFWGammaRamp.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        RED = layout.offsetof(0);
        GREEN = layout.offsetof(1);
        BLUE = layout.offsetof(2);
        SIZE = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<GLFWGammaRamp, Buffer>
    implements NativeResource {
        private static final GLFWGammaRamp ELEMENT_FACTORY = GLFWGammaRamp.create(-1L);

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
        protected GLFWGammaRamp getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="unsigned short *")
        public ShortBuffer red() {
            return GLFWGammaRamp.nred(this.address());
        }

        @NativeType(value="unsigned short *")
        public ShortBuffer green() {
            return GLFWGammaRamp.ngreen(this.address());
        }

        @NativeType(value="unsigned short *")
        public ShortBuffer blue() {
            return GLFWGammaRamp.nblue(this.address());
        }

        @NativeType(value="unsigned int")
        public int size() {
            return GLFWGammaRamp.nsize(this.address());
        }

        public Buffer red(@NativeType(value="unsigned short *") ShortBuffer value) {
            GLFWGammaRamp.nred(this.address(), value);
            return this;
        }

        public Buffer green(@NativeType(value="unsigned short *") ShortBuffer value) {
            GLFWGammaRamp.ngreen(this.address(), value);
            return this;
        }

        public Buffer blue(@NativeType(value="unsigned short *") ShortBuffer value) {
            GLFWGammaRamp.nblue(this.address(), value);
            return this;
        }

        public Buffer size(@NativeType(value="unsigned int") int value) {
            GLFWGammaRamp.nsize(this.address(), value);
            return this;
        }
    }
}

