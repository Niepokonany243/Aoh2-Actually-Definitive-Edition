/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class HARDWAREINPUT
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int UMSG;
    public static final int WPARAML;
    public static final int WPARAMH;

    public HARDWAREINPUT(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), HARDWAREINPUT.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int uMsg() {
        return HARDWAREINPUT.nuMsg(this.address());
    }

    @NativeType(value="WORD")
    public short wParamL() {
        return HARDWAREINPUT.nwParamL(this.address());
    }

    @NativeType(value="WORD")
    public short wParamH() {
        return HARDWAREINPUT.nwParamH(this.address());
    }

    public HARDWAREINPUT uMsg(@NativeType(value="DWORD") int value) {
        HARDWAREINPUT.nuMsg(this.address(), value);
        return this;
    }

    public HARDWAREINPUT wParamL(@NativeType(value="WORD") short value) {
        HARDWAREINPUT.nwParamL(this.address(), value);
        return this;
    }

    public HARDWAREINPUT wParamH(@NativeType(value="WORD") short value) {
        HARDWAREINPUT.nwParamH(this.address(), value);
        return this;
    }

    public HARDWAREINPUT set(int uMsg, short wParamL, short wParamH) {
        this.uMsg(uMsg);
        this.wParamL(wParamL);
        this.wParamH(wParamH);
        return this;
    }

    public HARDWAREINPUT set(HARDWAREINPUT src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static HARDWAREINPUT malloc() {
        return HARDWAREINPUT.wrap(HARDWAREINPUT.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static HARDWAREINPUT calloc() {
        return HARDWAREINPUT.wrap(HARDWAREINPUT.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static HARDWAREINPUT create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return HARDWAREINPUT.wrap(HARDWAREINPUT.class, MemoryUtil.memAddress(container), container);
    }

    public static HARDWAREINPUT create(long address) {
        return HARDWAREINPUT.wrap(HARDWAREINPUT.class, address);
    }

    @Nullable
    public static HARDWAREINPUT createSafe(long address) {
        return address == 0L ? null : HARDWAREINPUT.wrap(HARDWAREINPUT.class, address);
    }

    public static Buffer malloc(int capacity) {
        return HARDWAREINPUT.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(HARDWAREINPUT.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return HARDWAREINPUT.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = HARDWAREINPUT.__create(capacity, SIZEOF);
        return HARDWAREINPUT.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return HARDWAREINPUT.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : HARDWAREINPUT.wrap(Buffer.class, address, capacity);
    }

    public static HARDWAREINPUT mallocStack() {
        return HARDWAREINPUT.mallocStack(MemoryStack.stackGet());
    }

    public static HARDWAREINPUT callocStack() {
        return HARDWAREINPUT.callocStack(MemoryStack.stackGet());
    }

    public static HARDWAREINPUT mallocStack(MemoryStack stack) {
        return HARDWAREINPUT.wrap(HARDWAREINPUT.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static HARDWAREINPUT callocStack(MemoryStack stack) {
        return HARDWAREINPUT.wrap(HARDWAREINPUT.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return HARDWAREINPUT.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return HARDWAREINPUT.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return HARDWAREINPUT.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return HARDWAREINPUT.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    public static int nuMsg(long struct) {
        return UNSAFE.getInt(null, struct + (long)UMSG);
    }

    public static short nwParamL(long struct) {
        return UNSAFE.getShort(null, struct + (long)WPARAML);
    }

    public static short nwParamH(long struct) {
        return UNSAFE.getShort(null, struct + (long)WPARAMH);
    }

    public static void nuMsg(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)UMSG, value);
    }

    public static void nwParamL(long struct, short value) {
        UNSAFE.putShort(null, struct + (long)WPARAML, value);
    }

    public static void nwParamH(long struct, short value) {
        UNSAFE.putShort(null, struct + (long)WPARAMH, value);
    }

    static {
        Struct.Layout layout = HARDWAREINPUT.__struct(HARDWAREINPUT.__member(4), HARDWAREINPUT.__member(2), HARDWAREINPUT.__member(2));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        UMSG = layout.offsetof(0);
        WPARAML = layout.offsetof(1);
        WPARAMH = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<HARDWAREINPUT, Buffer>
    implements NativeResource {
        private static final HARDWAREINPUT ELEMENT_FACTORY = HARDWAREINPUT.create(-1L);

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
        protected HARDWAREINPUT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int uMsg() {
            return HARDWAREINPUT.nuMsg(this.address());
        }

        @NativeType(value="WORD")
        public short wParamL() {
            return HARDWAREINPUT.nwParamL(this.address());
        }

        @NativeType(value="WORD")
        public short wParamH() {
            return HARDWAREINPUT.nwParamH(this.address());
        }

        public Buffer uMsg(@NativeType(value="DWORD") int value) {
            HARDWAREINPUT.nuMsg(this.address(), value);
            return this;
        }

        public Buffer wParamL(@NativeType(value="WORD") short value) {
            HARDWAREINPUT.nwParamL(this.address(), value);
            return this;
        }

        public Buffer wParamH(@NativeType(value="WORD") short value) {
            HARDWAREINPUT.nwParamH(this.address(), value);
            return this;
        }
    }
}

