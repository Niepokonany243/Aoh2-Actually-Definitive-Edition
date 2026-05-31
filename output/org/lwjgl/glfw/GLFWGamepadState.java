/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct GLFWgamepadstate")
public class GLFWGamepadState
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int BUTTONS;
    public static final int AXES;

    public GLFWGamepadState(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), GLFWGamepadState.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="unsigned char[15]")
    public ByteBuffer buttons() {
        return GLFWGamepadState.nbuttons(this.address());
    }

    @NativeType(value="unsigned char")
    public byte buttons(int index) {
        return GLFWGamepadState.nbuttons(this.address(), index);
    }

    @NativeType(value="float[6]")
    public FloatBuffer axes() {
        return GLFWGamepadState.naxes(this.address());
    }

    public float axes(int index) {
        return GLFWGamepadState.naxes(this.address(), index);
    }

    public GLFWGamepadState buttons(@NativeType(value="unsigned char[15]") ByteBuffer value) {
        GLFWGamepadState.nbuttons(this.address(), value);
        return this;
    }

    public GLFWGamepadState buttons(int index, @NativeType(value="unsigned char") byte value) {
        GLFWGamepadState.nbuttons(this.address(), index, value);
        return this;
    }

    public GLFWGamepadState axes(@NativeType(value="float[6]") FloatBuffer value) {
        GLFWGamepadState.naxes(this.address(), value);
        return this;
    }

    public GLFWGamepadState axes(int index, float value) {
        GLFWGamepadState.naxes(this.address(), index, value);
        return this;
    }

    public GLFWGamepadState set(ByteBuffer buttons, FloatBuffer axes) {
        this.buttons(buttons);
        this.axes(axes);
        return this;
    }

    public GLFWGamepadState set(GLFWGamepadState src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static GLFWGamepadState malloc() {
        return GLFWGamepadState.wrap(GLFWGamepadState.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static GLFWGamepadState calloc() {
        return GLFWGamepadState.wrap(GLFWGamepadState.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static GLFWGamepadState create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return GLFWGamepadState.wrap(GLFWGamepadState.class, MemoryUtil.memAddress(container), container);
    }

    public static GLFWGamepadState create(long address) {
        return GLFWGamepadState.wrap(GLFWGamepadState.class, address);
    }

    @Nullable
    public static GLFWGamepadState createSafe(long address) {
        return address == 0L ? null : GLFWGamepadState.wrap(GLFWGamepadState.class, address);
    }

    public static Buffer malloc(int capacity) {
        return GLFWGamepadState.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(GLFWGamepadState.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return GLFWGamepadState.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = GLFWGamepadState.__create(capacity, SIZEOF);
        return GLFWGamepadState.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return GLFWGamepadState.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : GLFWGamepadState.wrap(Buffer.class, address, capacity);
    }

    public static GLFWGamepadState mallocStack() {
        return GLFWGamepadState.mallocStack(MemoryStack.stackGet());
    }

    public static GLFWGamepadState callocStack() {
        return GLFWGamepadState.callocStack(MemoryStack.stackGet());
    }

    public static GLFWGamepadState mallocStack(MemoryStack stack) {
        return GLFWGamepadState.wrap(GLFWGamepadState.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static GLFWGamepadState callocStack(MemoryStack stack) {
        return GLFWGamepadState.wrap(GLFWGamepadState.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return GLFWGamepadState.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return GLFWGamepadState.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return GLFWGamepadState.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return GLFWGamepadState.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    public static ByteBuffer nbuttons(long struct) {
        return MemoryUtil.memByteBuffer(struct + (long)BUTTONS, 15);
    }

    public static byte nbuttons(long struct, int index) {
        return UNSAFE.getByte(null, struct + (long)BUTTONS + Checks.check(index, 15) * 1L);
    }

    public static FloatBuffer naxes(long struct) {
        return MemoryUtil.memFloatBuffer(struct + (long)AXES, 6);
    }

    public static float naxes(long struct, int index) {
        return UNSAFE.getFloat(null, struct + (long)AXES + Checks.check(index, 6) * 4L);
    }

    public static void nbuttons(long struct, ByteBuffer value) {
        if (Checks.CHECKS) {
            Checks.checkGT(value, 15);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + (long)BUTTONS, value.remaining() * 1);
    }

    public static void nbuttons(long struct, int index, byte value) {
        UNSAFE.putByte(null, struct + (long)BUTTONS + Checks.check(index, 15) * 1L, value);
    }

    public static void naxes(long struct, FloatBuffer value) {
        if (Checks.CHECKS) {
            Checks.checkGT(value, 6);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + (long)AXES, value.remaining() * 4);
    }

    public static void naxes(long struct, int index, float value) {
        UNSAFE.putFloat(null, struct + (long)AXES + Checks.check(index, 6) * 4L, value);
    }

    static {
        Struct.Layout layout = GLFWGamepadState.__struct(GLFWGamepadState.__array(1, 15), GLFWGamepadState.__array(4, 6));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        BUTTONS = layout.offsetof(0);
        AXES = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<GLFWGamepadState, Buffer>
    implements NativeResource {
        private static final GLFWGamepadState ELEMENT_FACTORY = GLFWGamepadState.create(-1L);

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
        protected GLFWGamepadState getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="unsigned char[15]")
        public ByteBuffer buttons() {
            return GLFWGamepadState.nbuttons(this.address());
        }

        @NativeType(value="unsigned char")
        public byte buttons(int index) {
            return GLFWGamepadState.nbuttons(this.address(), index);
        }

        @NativeType(value="float[6]")
        public FloatBuffer axes() {
            return GLFWGamepadState.naxes(this.address());
        }

        public float axes(int index) {
            return GLFWGamepadState.naxes(this.address(), index);
        }

        public Buffer buttons(@NativeType(value="unsigned char[15]") ByteBuffer value) {
            GLFWGamepadState.nbuttons(this.address(), value);
            return this;
        }

        public Buffer buttons(int index, @NativeType(value="unsigned char") byte value) {
            GLFWGamepadState.nbuttons(this.address(), index, value);
            return this;
        }

        public Buffer axes(@NativeType(value="float[6]") FloatBuffer value) {
            GLFWGamepadState.naxes(this.address(), value);
            return this;
        }

        public Buffer axes(int index, float value) {
            GLFWGamepadState.naxes(this.address(), index, value);
            return this;
        }
    }
}

