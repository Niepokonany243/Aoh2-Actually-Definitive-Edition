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

public class MOUSEINPUT
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int DX;
    public static final int DY;
    public static final int MOUSEDATA;
    public static final int DWFLAGS;
    public static final int TIME;
    public static final int DWEXTRAINFO;

    public MOUSEINPUT(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), MOUSEINPUT.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="LONG")
    public int dx() {
        return MOUSEINPUT.ndx(this.address());
    }

    @NativeType(value="LONG")
    public int dy() {
        return MOUSEINPUT.ndy(this.address());
    }

    @NativeType(value="DWORD")
    public int mouseData() {
        return MOUSEINPUT.nmouseData(this.address());
    }

    @NativeType(value="DWORD")
    public int dwFlags() {
        return MOUSEINPUT.ndwFlags(this.address());
    }

    @NativeType(value="DWORD")
    public int time() {
        return MOUSEINPUT.ntime(this.address());
    }

    @NativeType(value="ULONG_PTR")
    public long dwExtraInfo() {
        return MOUSEINPUT.ndwExtraInfo(this.address());
    }

    public MOUSEINPUT dx(@NativeType(value="LONG") int value) {
        MOUSEINPUT.ndx(this.address(), value);
        return this;
    }

    public MOUSEINPUT dy(@NativeType(value="LONG") int value) {
        MOUSEINPUT.ndy(this.address(), value);
        return this;
    }

    public MOUSEINPUT mouseData(@NativeType(value="DWORD") int value) {
        MOUSEINPUT.nmouseData(this.address(), value);
        return this;
    }

    public MOUSEINPUT dwFlags(@NativeType(value="DWORD") int value) {
        MOUSEINPUT.ndwFlags(this.address(), value);
        return this;
    }

    public MOUSEINPUT time(@NativeType(value="DWORD") int value) {
        MOUSEINPUT.ntime(this.address(), value);
        return this;
    }

    public MOUSEINPUT dwExtraInfo(@NativeType(value="ULONG_PTR") long value) {
        MOUSEINPUT.ndwExtraInfo(this.address(), value);
        return this;
    }

    public MOUSEINPUT set(int dx, int dy, int mouseData, int dwFlags, int time, long dwExtraInfo) {
        this.dx(dx);
        this.dy(dy);
        this.mouseData(mouseData);
        this.dwFlags(dwFlags);
        this.time(time);
        this.dwExtraInfo(dwExtraInfo);
        return this;
    }

    public MOUSEINPUT set(MOUSEINPUT src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static MOUSEINPUT malloc() {
        return MOUSEINPUT.wrap(MOUSEINPUT.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static MOUSEINPUT calloc() {
        return MOUSEINPUT.wrap(MOUSEINPUT.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static MOUSEINPUT create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return MOUSEINPUT.wrap(MOUSEINPUT.class, MemoryUtil.memAddress(container), container);
    }

    public static MOUSEINPUT create(long address) {
        return MOUSEINPUT.wrap(MOUSEINPUT.class, address);
    }

    @Nullable
    public static MOUSEINPUT createSafe(long address) {
        return address == 0L ? null : MOUSEINPUT.wrap(MOUSEINPUT.class, address);
    }

    public static Buffer malloc(int capacity) {
        return MOUSEINPUT.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(MOUSEINPUT.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return MOUSEINPUT.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = MOUSEINPUT.__create(capacity, SIZEOF);
        return MOUSEINPUT.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return MOUSEINPUT.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : MOUSEINPUT.wrap(Buffer.class, address, capacity);
    }

    public static MOUSEINPUT mallocStack() {
        return MOUSEINPUT.mallocStack(MemoryStack.stackGet());
    }

    public static MOUSEINPUT callocStack() {
        return MOUSEINPUT.callocStack(MemoryStack.stackGet());
    }

    public static MOUSEINPUT mallocStack(MemoryStack stack) {
        return MOUSEINPUT.wrap(MOUSEINPUT.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static MOUSEINPUT callocStack(MemoryStack stack) {
        return MOUSEINPUT.wrap(MOUSEINPUT.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return MOUSEINPUT.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return MOUSEINPUT.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return MOUSEINPUT.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return MOUSEINPUT.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    public static int ndx(long struct) {
        return UNSAFE.getInt(null, struct + (long)DX);
    }

    public static int ndy(long struct) {
        return UNSAFE.getInt(null, struct + (long)DY);
    }

    public static int nmouseData(long struct) {
        return UNSAFE.getInt(null, struct + (long)MOUSEDATA);
    }

    public static int ndwFlags(long struct) {
        return UNSAFE.getInt(null, struct + (long)DWFLAGS);
    }

    public static int ntime(long struct) {
        return UNSAFE.getInt(null, struct + (long)TIME);
    }

    public static long ndwExtraInfo(long struct) {
        return MemoryUtil.memGetAddress(struct + (long)DWEXTRAINFO);
    }

    public static void ndx(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)DX, value);
    }

    public static void ndy(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)DY, value);
    }

    public static void nmouseData(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)MOUSEDATA, value);
    }

    public static void ndwFlags(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)DWFLAGS, value);
    }

    public static void ntime(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)TIME, value);
    }

    public static void ndwExtraInfo(long struct, long value) {
        MemoryUtil.memPutAddress(struct + (long)DWEXTRAINFO, value);
    }

    static {
        Struct.Layout layout = MOUSEINPUT.__struct(MOUSEINPUT.__member(4), MOUSEINPUT.__member(4), MOUSEINPUT.__member(4), MOUSEINPUT.__member(4), MOUSEINPUT.__member(4), MOUSEINPUT.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        DX = layout.offsetof(0);
        DY = layout.offsetof(1);
        MOUSEDATA = layout.offsetof(2);
        DWFLAGS = layout.offsetof(3);
        TIME = layout.offsetof(4);
        DWEXTRAINFO = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<MOUSEINPUT, Buffer>
    implements NativeResource {
        private static final MOUSEINPUT ELEMENT_FACTORY = MOUSEINPUT.create(-1L);

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
        protected MOUSEINPUT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="LONG")
        public int dx() {
            return MOUSEINPUT.ndx(this.address());
        }

        @NativeType(value="LONG")
        public int dy() {
            return MOUSEINPUT.ndy(this.address());
        }

        @NativeType(value="DWORD")
        public int mouseData() {
            return MOUSEINPUT.nmouseData(this.address());
        }

        @NativeType(value="DWORD")
        public int dwFlags() {
            return MOUSEINPUT.ndwFlags(this.address());
        }

        @NativeType(value="DWORD")
        public int time() {
            return MOUSEINPUT.ntime(this.address());
        }

        @NativeType(value="ULONG_PTR")
        public long dwExtraInfo() {
            return MOUSEINPUT.ndwExtraInfo(this.address());
        }

        public Buffer dx(@NativeType(value="LONG") int value) {
            MOUSEINPUT.ndx(this.address(), value);
            return this;
        }

        public Buffer dy(@NativeType(value="LONG") int value) {
            MOUSEINPUT.ndy(this.address(), value);
            return this;
        }

        public Buffer mouseData(@NativeType(value="DWORD") int value) {
            MOUSEINPUT.nmouseData(this.address(), value);
            return this;
        }

        public Buffer dwFlags(@NativeType(value="DWORD") int value) {
            MOUSEINPUT.ndwFlags(this.address(), value);
            return this;
        }

        public Buffer time(@NativeType(value="DWORD") int value) {
            MOUSEINPUT.ntime(this.address(), value);
            return this;
        }

        public Buffer dwExtraInfo(@NativeType(value="ULONG_PTR") long value) {
            MOUSEINPUT.ndwExtraInfo(this.address(), value);
            return this;
        }
    }
}

