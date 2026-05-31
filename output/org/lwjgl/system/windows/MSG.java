/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.windows.POINT;

public class MSG
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int HWND;
    public static final int MESSAGE;
    public static final int WPARAM;
    public static final int LPARAM;
    public static final int TIME;
    public static final int PT;

    public MSG(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), MSG.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="HWND")
    public long hwnd() {
        return MSG.nhwnd(this.address());
    }

    @NativeType(value="UINT")
    public int message() {
        return MSG.nmessage(this.address());
    }

    @NativeType(value="WPARAM")
    public long wParam() {
        return MSG.nwParam(this.address());
    }

    @NativeType(value="LPARAM")
    public long lParam() {
        return MSG.nlParam(this.address());
    }

    @NativeType(value="DWORD")
    public int time() {
        return MSG.ntime(this.address());
    }

    public POINT pt() {
        return MSG.npt(this.address());
    }

    public MSG hwnd(@NativeType(value="HWND") long value) {
        MSG.nhwnd(this.address(), value);
        return this;
    }

    public MSG message(@NativeType(value="UINT") int value) {
        MSG.nmessage(this.address(), value);
        return this;
    }

    public MSG wParam(@NativeType(value="WPARAM") long value) {
        MSG.nwParam(this.address(), value);
        return this;
    }

    public MSG lParam(@NativeType(value="LPARAM") long value) {
        MSG.nlParam(this.address(), value);
        return this;
    }

    public MSG time(@NativeType(value="DWORD") int value) {
        MSG.ntime(this.address(), value);
        return this;
    }

    public MSG pt(POINT value) {
        MSG.npt(this.address(), value);
        return this;
    }

    public MSG pt(Consumer<POINT> consumer) {
        consumer.accept(this.pt());
        return this;
    }

    public MSG set(long hwnd, int message, long wParam, long lParam, int time, POINT pt) {
        this.hwnd(hwnd);
        this.message(message);
        this.wParam(wParam);
        this.lParam(lParam);
        this.time(time);
        this.pt(pt);
        return this;
    }

    public MSG set(MSG src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static MSG malloc() {
        return MSG.wrap(MSG.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static MSG calloc() {
        return MSG.wrap(MSG.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static MSG create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return MSG.wrap(MSG.class, MemoryUtil.memAddress(container), container);
    }

    public static MSG create(long address) {
        return MSG.wrap(MSG.class, address);
    }

    @Nullable
    public static MSG createSafe(long address) {
        return address == 0L ? null : MSG.wrap(MSG.class, address);
    }

    public static Buffer malloc(int capacity) {
        return MSG.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(MSG.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return MSG.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = MSG.__create(capacity, SIZEOF);
        return MSG.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return MSG.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : MSG.wrap(Buffer.class, address, capacity);
    }

    public static MSG mallocStack() {
        return MSG.mallocStack(MemoryStack.stackGet());
    }

    public static MSG callocStack() {
        return MSG.callocStack(MemoryStack.stackGet());
    }

    public static MSG mallocStack(MemoryStack stack) {
        return MSG.wrap(MSG.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static MSG callocStack(MemoryStack stack) {
        return MSG.wrap(MSG.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return MSG.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return MSG.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return MSG.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return MSG.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    public static long nhwnd(long struct) {
        return MemoryUtil.memGetAddress(struct + (long)HWND);
    }

    public static int nmessage(long struct) {
        return UNSAFE.getInt(null, struct + (long)MESSAGE);
    }

    public static long nwParam(long struct) {
        return MemoryUtil.memGetAddress(struct + (long)WPARAM);
    }

    public static long nlParam(long struct) {
        return MemoryUtil.memGetAddress(struct + (long)LPARAM);
    }

    public static int ntime(long struct) {
        return UNSAFE.getInt(null, struct + (long)TIME);
    }

    public static POINT npt(long struct) {
        return POINT.create(struct + (long)PT);
    }

    public static void nhwnd(long struct, long value) {
        MemoryUtil.memPutAddress(struct + (long)HWND, value);
    }

    public static void nmessage(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)MESSAGE, value);
    }

    public static void nwParam(long struct, long value) {
        MemoryUtil.memPutAddress(struct + (long)WPARAM, value);
    }

    public static void nlParam(long struct, long value) {
        MemoryUtil.memPutAddress(struct + (long)LPARAM, value);
    }

    public static void ntime(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)TIME, value);
    }

    public static void npt(long struct, POINT value) {
        MemoryUtil.memCopy(value.address(), struct + (long)PT, POINT.SIZEOF);
    }

    static {
        Struct.Layout layout = MSG.__struct(MSG.__member(POINTER_SIZE), MSG.__member(4), MSG.__member(POINTER_SIZE), MSG.__member(POINTER_SIZE), MSG.__member(4), MSG.__member(POINT.SIZEOF, POINT.ALIGNOF));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        HWND = layout.offsetof(0);
        MESSAGE = layout.offsetof(1);
        WPARAM = layout.offsetof(2);
        LPARAM = layout.offsetof(3);
        TIME = layout.offsetof(4);
        PT = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<MSG, Buffer>
    implements NativeResource {
        private static final MSG ELEMENT_FACTORY = MSG.create(-1L);

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
        protected MSG getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="HWND")
        public long hwnd() {
            return MSG.nhwnd(this.address());
        }

        @NativeType(value="UINT")
        public int message() {
            return MSG.nmessage(this.address());
        }

        @NativeType(value="WPARAM")
        public long wParam() {
            return MSG.nwParam(this.address());
        }

        @NativeType(value="LPARAM")
        public long lParam() {
            return MSG.nlParam(this.address());
        }

        @NativeType(value="DWORD")
        public int time() {
            return MSG.ntime(this.address());
        }

        public POINT pt() {
            return MSG.npt(this.address());
        }

        public Buffer hwnd(@NativeType(value="HWND") long value) {
            MSG.nhwnd(this.address(), value);
            return this;
        }

        public Buffer message(@NativeType(value="UINT") int value) {
            MSG.nmessage(this.address(), value);
            return this;
        }

        public Buffer wParam(@NativeType(value="WPARAM") long value) {
            MSG.nwParam(this.address(), value);
            return this;
        }

        public Buffer lParam(@NativeType(value="LPARAM") long value) {
            MSG.nlParam(this.address(), value);
            return this;
        }

        public Buffer time(@NativeType(value="DWORD") int value) {
            MSG.ntime(this.address(), value);
            return this;
        }

        public Buffer pt(POINT value) {
            MSG.npt(this.address(), value);
            return this;
        }

        public Buffer pt(Consumer<POINT> consumer) {
            consumer.accept(this.pt());
            return this;
        }
    }
}

