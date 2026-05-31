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

public class KEYBDINPUT
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int WVK;
    public static final int WSCAN;
    public static final int DWFLAGS;
    public static final int TIME;
    public static final int DWEXTRAINFO;

    public KEYBDINPUT(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), KEYBDINPUT.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="WORD")
    public short wVk() {
        return KEYBDINPUT.nwVk(this.address());
    }

    @NativeType(value="WORD")
    public short wScan() {
        return KEYBDINPUT.nwScan(this.address());
    }

    @NativeType(value="DWORD")
    public int dwFlags() {
        return KEYBDINPUT.ndwFlags(this.address());
    }

    @NativeType(value="DWORD")
    public int time() {
        return KEYBDINPUT.ntime(this.address());
    }

    @NativeType(value="ULONG_PTR")
    public long dwExtraInfo() {
        return KEYBDINPUT.ndwExtraInfo(this.address());
    }

    public KEYBDINPUT wVk(@NativeType(value="WORD") short value) {
        KEYBDINPUT.nwVk(this.address(), value);
        return this;
    }

    public KEYBDINPUT wScan(@NativeType(value="WORD") short value) {
        KEYBDINPUT.nwScan(this.address(), value);
        return this;
    }

    public KEYBDINPUT dwFlags(@NativeType(value="DWORD") int value) {
        KEYBDINPUT.ndwFlags(this.address(), value);
        return this;
    }

    public KEYBDINPUT time(@NativeType(value="DWORD") int value) {
        KEYBDINPUT.ntime(this.address(), value);
        return this;
    }

    public KEYBDINPUT dwExtraInfo(@NativeType(value="ULONG_PTR") long value) {
        KEYBDINPUT.ndwExtraInfo(this.address(), value);
        return this;
    }

    public KEYBDINPUT set(short wVk, short wScan, int dwFlags, int time, long dwExtraInfo) {
        this.wVk(wVk);
        this.wScan(wScan);
        this.dwFlags(dwFlags);
        this.time(time);
        this.dwExtraInfo(dwExtraInfo);
        return this;
    }

    public KEYBDINPUT set(KEYBDINPUT src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static KEYBDINPUT malloc() {
        return KEYBDINPUT.wrap(KEYBDINPUT.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static KEYBDINPUT calloc() {
        return KEYBDINPUT.wrap(KEYBDINPUT.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static KEYBDINPUT create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return KEYBDINPUT.wrap(KEYBDINPUT.class, MemoryUtil.memAddress(container), container);
    }

    public static KEYBDINPUT create(long address) {
        return KEYBDINPUT.wrap(KEYBDINPUT.class, address);
    }

    @Nullable
    public static KEYBDINPUT createSafe(long address) {
        return address == 0L ? null : KEYBDINPUT.wrap(KEYBDINPUT.class, address);
    }

    public static Buffer malloc(int capacity) {
        return KEYBDINPUT.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(KEYBDINPUT.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return KEYBDINPUT.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = KEYBDINPUT.__create(capacity, SIZEOF);
        return KEYBDINPUT.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return KEYBDINPUT.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : KEYBDINPUT.wrap(Buffer.class, address, capacity);
    }

    public static KEYBDINPUT mallocStack() {
        return KEYBDINPUT.mallocStack(MemoryStack.stackGet());
    }

    public static KEYBDINPUT callocStack() {
        return KEYBDINPUT.callocStack(MemoryStack.stackGet());
    }

    public static KEYBDINPUT mallocStack(MemoryStack stack) {
        return KEYBDINPUT.wrap(KEYBDINPUT.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static KEYBDINPUT callocStack(MemoryStack stack) {
        return KEYBDINPUT.wrap(KEYBDINPUT.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return KEYBDINPUT.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return KEYBDINPUT.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return KEYBDINPUT.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return KEYBDINPUT.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    public static short nwVk(long struct) {
        return UNSAFE.getShort(null, struct + (long)WVK);
    }

    public static short nwScan(long struct) {
        return UNSAFE.getShort(null, struct + (long)WSCAN);
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

    public static void nwVk(long struct, short value) {
        UNSAFE.putShort(null, struct + (long)WVK, value);
    }

    public static void nwScan(long struct, short value) {
        UNSAFE.putShort(null, struct + (long)WSCAN, value);
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
        Struct.Layout layout = KEYBDINPUT.__struct(KEYBDINPUT.__member(2), KEYBDINPUT.__member(2), KEYBDINPUT.__member(4), KEYBDINPUT.__member(4), KEYBDINPUT.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        WVK = layout.offsetof(0);
        WSCAN = layout.offsetof(1);
        DWFLAGS = layout.offsetof(2);
        TIME = layout.offsetof(3);
        DWEXTRAINFO = layout.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<KEYBDINPUT, Buffer>
    implements NativeResource {
        private static final KEYBDINPUT ELEMENT_FACTORY = KEYBDINPUT.create(-1L);

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
        protected KEYBDINPUT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="WORD")
        public short wVk() {
            return KEYBDINPUT.nwVk(this.address());
        }

        @NativeType(value="WORD")
        public short wScan() {
            return KEYBDINPUT.nwScan(this.address());
        }

        @NativeType(value="DWORD")
        public int dwFlags() {
            return KEYBDINPUT.ndwFlags(this.address());
        }

        @NativeType(value="DWORD")
        public int time() {
            return KEYBDINPUT.ntime(this.address());
        }

        @NativeType(value="ULONG_PTR")
        public long dwExtraInfo() {
            return KEYBDINPUT.ndwExtraInfo(this.address());
        }

        public Buffer wVk(@NativeType(value="WORD") short value) {
            KEYBDINPUT.nwVk(this.address(), value);
            return this;
        }

        public Buffer wScan(@NativeType(value="WORD") short value) {
            KEYBDINPUT.nwScan(this.address(), value);
            return this;
        }

        public Buffer dwFlags(@NativeType(value="DWORD") int value) {
            KEYBDINPUT.ndwFlags(this.address(), value);
            return this;
        }

        public Buffer time(@NativeType(value="DWORD") int value) {
            KEYBDINPUT.ntime(this.address(), value);
            return this;
        }

        public Buffer dwExtraInfo(@NativeType(value="ULONG_PTR") long value) {
            KEYBDINPUT.ndwExtraInfo(this.address(), value);
            return this;
        }
    }
}

