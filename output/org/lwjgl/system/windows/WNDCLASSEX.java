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
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.windows.WindowProc;
import org.lwjgl.system.windows.WindowProcI;

public class WNDCLASSEX
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int CBSIZE;
    public static final int STYLE;
    public static final int LPFNWNDPROC;
    public static final int CBCLSEXTRA;
    public static final int CBWNDEXTRA;
    public static final int HINSTANCE;
    public static final int HICON;
    public static final int HCURSOR;
    public static final int HBRBACKGROUND;
    public static final int LPSZMENUNAME;
    public static final int LPSZCLASSNAME;
    public static final int HICONSM;

    public WNDCLASSEX(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), WNDCLASSEX.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="UINT")
    public int cbSize() {
        return WNDCLASSEX.ncbSize(this.address());
    }

    @NativeType(value="UINT")
    public int style() {
        return WNDCLASSEX.nstyle(this.address());
    }

    @NativeType(value="WNDPROC")
    public WindowProc lpfnWndProc() {
        return WNDCLASSEX.nlpfnWndProc(this.address());
    }

    public int cbClsExtra() {
        return WNDCLASSEX.ncbClsExtra(this.address());
    }

    public int cbWndExtra() {
        return WNDCLASSEX.ncbWndExtra(this.address());
    }

    @NativeType(value="HINSTANCE")
    public long hInstance() {
        return WNDCLASSEX.nhInstance(this.address());
    }

    @NativeType(value="HICON")
    public long hIcon() {
        return WNDCLASSEX.nhIcon(this.address());
    }

    @NativeType(value="HCURSOR")
    public long hCursor() {
        return WNDCLASSEX.nhCursor(this.address());
    }

    @NativeType(value="HBRUSH")
    public long hbrBackground() {
        return WNDCLASSEX.nhbrBackground(this.address());
    }

    @Nullable
    @NativeType(value="LPCTSTR")
    public ByteBuffer lpszMenuName() {
        return WNDCLASSEX.nlpszMenuName(this.address());
    }

    @Nullable
    @NativeType(value="LPCTSTR")
    public String lpszMenuNameString() {
        return WNDCLASSEX.nlpszMenuNameString(this.address());
    }

    @NativeType(value="LPCTSTR")
    public ByteBuffer lpszClassName() {
        return WNDCLASSEX.nlpszClassName(this.address());
    }

    @NativeType(value="LPCTSTR")
    public String lpszClassNameString() {
        return WNDCLASSEX.nlpszClassNameString(this.address());
    }

    @NativeType(value="HICON")
    public long hIconSm() {
        return WNDCLASSEX.nhIconSm(this.address());
    }

    public WNDCLASSEX cbSize(@NativeType(value="UINT") int value) {
        WNDCLASSEX.ncbSize(this.address(), value);
        return this;
    }

    public WNDCLASSEX style(@NativeType(value="UINT") int value) {
        WNDCLASSEX.nstyle(this.address(), value);
        return this;
    }

    public WNDCLASSEX lpfnWndProc(@NativeType(value="WNDPROC") WindowProcI value) {
        WNDCLASSEX.nlpfnWndProc(this.address(), value);
        return this;
    }

    public WNDCLASSEX cbClsExtra(int value) {
        WNDCLASSEX.ncbClsExtra(this.address(), value);
        return this;
    }

    public WNDCLASSEX cbWndExtra(int value) {
        WNDCLASSEX.ncbWndExtra(this.address(), value);
        return this;
    }

    public WNDCLASSEX hInstance(@NativeType(value="HINSTANCE") long value) {
        WNDCLASSEX.nhInstance(this.address(), value);
        return this;
    }

    public WNDCLASSEX hIcon(@NativeType(value="HICON") long value) {
        WNDCLASSEX.nhIcon(this.address(), value);
        return this;
    }

    public WNDCLASSEX hCursor(@NativeType(value="HCURSOR") long value) {
        WNDCLASSEX.nhCursor(this.address(), value);
        return this;
    }

    public WNDCLASSEX hbrBackground(@NativeType(value="HBRUSH") long value) {
        WNDCLASSEX.nhbrBackground(this.address(), value);
        return this;
    }

    public WNDCLASSEX lpszMenuName(@Nullable @NativeType(value="LPCTSTR") ByteBuffer value) {
        WNDCLASSEX.nlpszMenuName(this.address(), value);
        return this;
    }

    public WNDCLASSEX lpszClassName(@NativeType(value="LPCTSTR") ByteBuffer value) {
        WNDCLASSEX.nlpszClassName(this.address(), value);
        return this;
    }

    public WNDCLASSEX hIconSm(@NativeType(value="HICON") long value) {
        WNDCLASSEX.nhIconSm(this.address(), value);
        return this;
    }

    public WNDCLASSEX set(int cbSize, int style, WindowProcI lpfnWndProc, int cbClsExtra, int cbWndExtra, long hInstance, long hIcon, long hCursor, long hbrBackground, @Nullable ByteBuffer lpszMenuName, ByteBuffer lpszClassName, long hIconSm) {
        this.cbSize(cbSize);
        this.style(style);
        this.lpfnWndProc(lpfnWndProc);
        this.cbClsExtra(cbClsExtra);
        this.cbWndExtra(cbWndExtra);
        this.hInstance(hInstance);
        this.hIcon(hIcon);
        this.hCursor(hCursor);
        this.hbrBackground(hbrBackground);
        this.lpszMenuName(lpszMenuName);
        this.lpszClassName(lpszClassName);
        this.hIconSm(hIconSm);
        return this;
    }

    public WNDCLASSEX set(WNDCLASSEX src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static WNDCLASSEX malloc() {
        return WNDCLASSEX.wrap(WNDCLASSEX.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static WNDCLASSEX calloc() {
        return WNDCLASSEX.wrap(WNDCLASSEX.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static WNDCLASSEX create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return WNDCLASSEX.wrap(WNDCLASSEX.class, MemoryUtil.memAddress(container), container);
    }

    public static WNDCLASSEX create(long address) {
        return WNDCLASSEX.wrap(WNDCLASSEX.class, address);
    }

    @Nullable
    public static WNDCLASSEX createSafe(long address) {
        return address == 0L ? null : WNDCLASSEX.wrap(WNDCLASSEX.class, address);
    }

    public static Buffer malloc(int capacity) {
        return WNDCLASSEX.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(WNDCLASSEX.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return WNDCLASSEX.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = WNDCLASSEX.__create(capacity, SIZEOF);
        return WNDCLASSEX.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return WNDCLASSEX.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : WNDCLASSEX.wrap(Buffer.class, address, capacity);
    }

    public static WNDCLASSEX mallocStack() {
        return WNDCLASSEX.mallocStack(MemoryStack.stackGet());
    }

    public static WNDCLASSEX callocStack() {
        return WNDCLASSEX.callocStack(MemoryStack.stackGet());
    }

    public static WNDCLASSEX mallocStack(MemoryStack stack) {
        return WNDCLASSEX.wrap(WNDCLASSEX.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static WNDCLASSEX callocStack(MemoryStack stack) {
        return WNDCLASSEX.wrap(WNDCLASSEX.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return WNDCLASSEX.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return WNDCLASSEX.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return WNDCLASSEX.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return WNDCLASSEX.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    public static int ncbSize(long struct) {
        return UNSAFE.getInt(null, struct + (long)CBSIZE);
    }

    public static int nstyle(long struct) {
        return UNSAFE.getInt(null, struct + (long)STYLE);
    }

    public static WindowProc nlpfnWndProc(long struct) {
        return WindowProc.create(MemoryUtil.memGetAddress(struct + (long)LPFNWNDPROC));
    }

    public static int ncbClsExtra(long struct) {
        return UNSAFE.getInt(null, struct + (long)CBCLSEXTRA);
    }

    public static int ncbWndExtra(long struct) {
        return UNSAFE.getInt(null, struct + (long)CBWNDEXTRA);
    }

    public static long nhInstance(long struct) {
        return MemoryUtil.memGetAddress(struct + (long)HINSTANCE);
    }

    public static long nhIcon(long struct) {
        return MemoryUtil.memGetAddress(struct + (long)HICON);
    }

    public static long nhCursor(long struct) {
        return MemoryUtil.memGetAddress(struct + (long)HCURSOR);
    }

    public static long nhbrBackground(long struct) {
        return MemoryUtil.memGetAddress(struct + (long)HBRBACKGROUND);
    }

    @Nullable
    public static ByteBuffer nlpszMenuName(long struct) {
        return MemoryUtil.memByteBufferNT2Safe(MemoryUtil.memGetAddress(struct + (long)LPSZMENUNAME));
    }

    @Nullable
    public static String nlpszMenuNameString(long struct) {
        return MemoryUtil.memUTF16Safe(MemoryUtil.memGetAddress(struct + (long)LPSZMENUNAME));
    }

    public static ByteBuffer nlpszClassName(long struct) {
        return MemoryUtil.memByteBufferNT2(MemoryUtil.memGetAddress(struct + (long)LPSZCLASSNAME));
    }

    public static String nlpszClassNameString(long struct) {
        return MemoryUtil.memUTF16(MemoryUtil.memGetAddress(struct + (long)LPSZCLASSNAME));
    }

    public static long nhIconSm(long struct) {
        return MemoryUtil.memGetAddress(struct + (long)HICONSM);
    }

    public static void ncbSize(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)CBSIZE, value);
    }

    public static void nstyle(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)STYLE, value);
    }

    public static void nlpfnWndProc(long struct, WindowProcI value) {
        MemoryUtil.memPutAddress(struct + (long)LPFNWNDPROC, value.address());
    }

    public static void ncbClsExtra(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)CBCLSEXTRA, value);
    }

    public static void ncbWndExtra(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)CBWNDEXTRA, value);
    }

    public static void nhInstance(long struct, long value) {
        MemoryUtil.memPutAddress(struct + (long)HINSTANCE, Checks.check(value));
    }

    public static void nhIcon(long struct, long value) {
        MemoryUtil.memPutAddress(struct + (long)HICON, value);
    }

    public static void nhCursor(long struct, long value) {
        MemoryUtil.memPutAddress(struct + (long)HCURSOR, value);
    }

    public static void nhbrBackground(long struct, long value) {
        MemoryUtil.memPutAddress(struct + (long)HBRBACKGROUND, value);
    }

    public static void nlpszMenuName(long struct, @Nullable ByteBuffer value) {
        if (Checks.CHECKS) {
            Checks.checkNT2Safe(value);
        }
        MemoryUtil.memPutAddress(struct + (long)LPSZMENUNAME, MemoryUtil.memAddressSafe(value));
    }

    public static void nlpszClassName(long struct, ByteBuffer value) {
        if (Checks.CHECKS) {
            Checks.checkNT2(value);
        }
        MemoryUtil.memPutAddress(struct + (long)LPSZCLASSNAME, MemoryUtil.memAddress(value));
    }

    public static void nhIconSm(long struct, long value) {
        MemoryUtil.memPutAddress(struct + (long)HICONSM, value);
    }

    public static void validate(long struct) {
        Checks.check(MemoryUtil.memGetAddress(struct + (long)LPFNWNDPROC));
        Checks.check(MemoryUtil.memGetAddress(struct + (long)HINSTANCE));
        Checks.check(MemoryUtil.memGetAddress(struct + (long)LPSZCLASSNAME));
    }

    public static void validate(long array, int count) {
        for (int i = 0; i < count; ++i) {
            WNDCLASSEX.validate(array + Integer.toUnsignedLong(i) * (long)SIZEOF);
        }
    }

    static {
        Struct.Layout layout = WNDCLASSEX.__struct(WNDCLASSEX.__member(4), WNDCLASSEX.__member(4), WNDCLASSEX.__member(POINTER_SIZE), WNDCLASSEX.__member(4), WNDCLASSEX.__member(4), WNDCLASSEX.__member(POINTER_SIZE), WNDCLASSEX.__member(POINTER_SIZE), WNDCLASSEX.__member(POINTER_SIZE), WNDCLASSEX.__member(POINTER_SIZE), WNDCLASSEX.__member(POINTER_SIZE), WNDCLASSEX.__member(POINTER_SIZE), WNDCLASSEX.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        CBSIZE = layout.offsetof(0);
        STYLE = layout.offsetof(1);
        LPFNWNDPROC = layout.offsetof(2);
        CBCLSEXTRA = layout.offsetof(3);
        CBWNDEXTRA = layout.offsetof(4);
        HINSTANCE = layout.offsetof(5);
        HICON = layout.offsetof(6);
        HCURSOR = layout.offsetof(7);
        HBRBACKGROUND = layout.offsetof(8);
        LPSZMENUNAME = layout.offsetof(9);
        LPSZCLASSNAME = layout.offsetof(10);
        HICONSM = layout.offsetof(11);
    }

    public static class Buffer
    extends StructBuffer<WNDCLASSEX, Buffer>
    implements NativeResource {
        private static final WNDCLASSEX ELEMENT_FACTORY = WNDCLASSEX.create(-1L);

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
        protected WNDCLASSEX getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="UINT")
        public int cbSize() {
            return WNDCLASSEX.ncbSize(this.address());
        }

        @NativeType(value="UINT")
        public int style() {
            return WNDCLASSEX.nstyle(this.address());
        }

        @NativeType(value="WNDPROC")
        public WindowProc lpfnWndProc() {
            return WNDCLASSEX.nlpfnWndProc(this.address());
        }

        public int cbClsExtra() {
            return WNDCLASSEX.ncbClsExtra(this.address());
        }

        public int cbWndExtra() {
            return WNDCLASSEX.ncbWndExtra(this.address());
        }

        @NativeType(value="HINSTANCE")
        public long hInstance() {
            return WNDCLASSEX.nhInstance(this.address());
        }

        @NativeType(value="HICON")
        public long hIcon() {
            return WNDCLASSEX.nhIcon(this.address());
        }

        @NativeType(value="HCURSOR")
        public long hCursor() {
            return WNDCLASSEX.nhCursor(this.address());
        }

        @NativeType(value="HBRUSH")
        public long hbrBackground() {
            return WNDCLASSEX.nhbrBackground(this.address());
        }

        @Nullable
        @NativeType(value="LPCTSTR")
        public ByteBuffer lpszMenuName() {
            return WNDCLASSEX.nlpszMenuName(this.address());
        }

        @Nullable
        @NativeType(value="LPCTSTR")
        public String lpszMenuNameString() {
            return WNDCLASSEX.nlpszMenuNameString(this.address());
        }

        @NativeType(value="LPCTSTR")
        public ByteBuffer lpszClassName() {
            return WNDCLASSEX.nlpszClassName(this.address());
        }

        @NativeType(value="LPCTSTR")
        public String lpszClassNameString() {
            return WNDCLASSEX.nlpszClassNameString(this.address());
        }

        @NativeType(value="HICON")
        public long hIconSm() {
            return WNDCLASSEX.nhIconSm(this.address());
        }

        public Buffer cbSize(@NativeType(value="UINT") int value) {
            WNDCLASSEX.ncbSize(this.address(), value);
            return this;
        }

        public Buffer style(@NativeType(value="UINT") int value) {
            WNDCLASSEX.nstyle(this.address(), value);
            return this;
        }

        public Buffer lpfnWndProc(@NativeType(value="WNDPROC") WindowProcI value) {
            WNDCLASSEX.nlpfnWndProc(this.address(), value);
            return this;
        }

        public Buffer cbClsExtra(int value) {
            WNDCLASSEX.ncbClsExtra(this.address(), value);
            return this;
        }

        public Buffer cbWndExtra(int value) {
            WNDCLASSEX.ncbWndExtra(this.address(), value);
            return this;
        }

        public Buffer hInstance(@NativeType(value="HINSTANCE") long value) {
            WNDCLASSEX.nhInstance(this.address(), value);
            return this;
        }

        public Buffer hIcon(@NativeType(value="HICON") long value) {
            WNDCLASSEX.nhIcon(this.address(), value);
            return this;
        }

        public Buffer hCursor(@NativeType(value="HCURSOR") long value) {
            WNDCLASSEX.nhCursor(this.address(), value);
            return this;
        }

        public Buffer hbrBackground(@NativeType(value="HBRUSH") long value) {
            WNDCLASSEX.nhbrBackground(this.address(), value);
            return this;
        }

        public Buffer lpszMenuName(@Nullable @NativeType(value="LPCTSTR") ByteBuffer value) {
            WNDCLASSEX.nlpszMenuName(this.address(), value);
            return this;
        }

        public Buffer lpszClassName(@NativeType(value="LPCTSTR") ByteBuffer value) {
            WNDCLASSEX.nlpszClassName(this.address(), value);
            return this;
        }

        public Buffer hIconSm(@NativeType(value="HICON") long value) {
            WNDCLASSEX.nhIconSm(this.address(), value);
            return this;
        }
    }
}

