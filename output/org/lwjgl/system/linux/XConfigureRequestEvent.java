/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

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

public class XConfigureRequestEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int PARENT;
    public static final int WINDOW;
    public static final int X;
    public static final int Y;
    public static final int WIDTH;
    public static final int HEIGHT;
    public static final int BORDER_WIDTH;
    public static final int ABOVE;
    public static final int DETAIL;
    public static final int VALUE_MASK;

    public XConfigureRequestEvent(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), XConfigureRequestEvent.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XConfigureRequestEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XConfigureRequestEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XConfigureRequestEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XConfigureRequestEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long parent() {
        return XConfigureRequestEvent.nparent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XConfigureRequestEvent.nwindow(this.address());
    }

    public int x() {
        return XConfigureRequestEvent.nx(this.address());
    }

    public int y() {
        return XConfigureRequestEvent.ny(this.address());
    }

    public int width() {
        return XConfigureRequestEvent.nwidth(this.address());
    }

    public int height() {
        return XConfigureRequestEvent.nheight(this.address());
    }

    public int border_width() {
        return XConfigureRequestEvent.nborder_width(this.address());
    }

    @NativeType(value="Window")
    public long above() {
        return XConfigureRequestEvent.nabove(this.address());
    }

    public int detail() {
        return XConfigureRequestEvent.ndetail(this.address());
    }

    @NativeType(value="unsigned long")
    public long value_mask() {
        return XConfigureRequestEvent.nvalue_mask(this.address());
    }

    public XConfigureRequestEvent type(int value) {
        XConfigureRequestEvent.ntype(this.address(), value);
        return this;
    }

    public XConfigureRequestEvent serial(@NativeType(value="unsigned long") long value) {
        XConfigureRequestEvent.nserial(this.address(), value);
        return this;
    }

    public XConfigureRequestEvent send_event(@NativeType(value="Bool") boolean value) {
        XConfigureRequestEvent.nsend_event(this.address(), value ? 1 : 0);
        return this;
    }

    public XConfigureRequestEvent display(@NativeType(value="Display *") long value) {
        XConfigureRequestEvent.ndisplay(this.address(), value);
        return this;
    }

    public XConfigureRequestEvent parent(@NativeType(value="Window") long value) {
        XConfigureRequestEvent.nparent(this.address(), value);
        return this;
    }

    public XConfigureRequestEvent window(@NativeType(value="Window") long value) {
        XConfigureRequestEvent.nwindow(this.address(), value);
        return this;
    }

    public XConfigureRequestEvent x(int value) {
        XConfigureRequestEvent.nx(this.address(), value);
        return this;
    }

    public XConfigureRequestEvent y(int value) {
        XConfigureRequestEvent.ny(this.address(), value);
        return this;
    }

    public XConfigureRequestEvent width(int value) {
        XConfigureRequestEvent.nwidth(this.address(), value);
        return this;
    }

    public XConfigureRequestEvent height(int value) {
        XConfigureRequestEvent.nheight(this.address(), value);
        return this;
    }

    public XConfigureRequestEvent border_width(int value) {
        XConfigureRequestEvent.nborder_width(this.address(), value);
        return this;
    }

    public XConfigureRequestEvent above(@NativeType(value="Window") long value) {
        XConfigureRequestEvent.nabove(this.address(), value);
        return this;
    }

    public XConfigureRequestEvent detail(int value) {
        XConfigureRequestEvent.ndetail(this.address(), value);
        return this;
    }

    public XConfigureRequestEvent value_mask(@NativeType(value="unsigned long") long value) {
        XConfigureRequestEvent.nvalue_mask(this.address(), value);
        return this;
    }

    public XConfigureRequestEvent set(int type, long serial, boolean send_event, long display, long parent, long window, int x, int y, int width, int height, int border_width, long above, int detail, long value_mask) {
        this.type(type);
        this.serial(serial);
        this.send_event(send_event);
        this.display(display);
        this.parent(parent);
        this.window(window);
        this.x(x);
        this.y(y);
        this.width(width);
        this.height(height);
        this.border_width(border_width);
        this.above(above);
        this.detail(detail);
        this.value_mask(value_mask);
        return this;
    }

    public XConfigureRequestEvent set(XConfigureRequestEvent src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static XConfigureRequestEvent malloc() {
        return XConfigureRequestEvent.wrap(XConfigureRequestEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XConfigureRequestEvent calloc() {
        return XConfigureRequestEvent.wrap(XConfigureRequestEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XConfigureRequestEvent create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return XConfigureRequestEvent.wrap(XConfigureRequestEvent.class, MemoryUtil.memAddress(container), container);
    }

    public static XConfigureRequestEvent create(long address) {
        return XConfigureRequestEvent.wrap(XConfigureRequestEvent.class, address);
    }

    @Nullable
    public static XConfigureRequestEvent createSafe(long address) {
        return address == 0L ? null : XConfigureRequestEvent.wrap(XConfigureRequestEvent.class, address);
    }

    public static Buffer malloc(int capacity) {
        return XConfigureRequestEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XConfigureRequestEvent.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return XConfigureRequestEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = XConfigureRequestEvent.__create(capacity, SIZEOF);
        return XConfigureRequestEvent.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return XConfigureRequestEvent.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : XConfigureRequestEvent.wrap(Buffer.class, address, capacity);
    }

    public static XConfigureRequestEvent mallocStack() {
        return XConfigureRequestEvent.mallocStack(MemoryStack.stackGet());
    }

    public static XConfigureRequestEvent callocStack() {
        return XConfigureRequestEvent.callocStack(MemoryStack.stackGet());
    }

    public static XConfigureRequestEvent mallocStack(MemoryStack stack) {
        return XConfigureRequestEvent.wrap(XConfigureRequestEvent.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XConfigureRequestEvent callocStack(MemoryStack stack) {
        return XConfigureRequestEvent.wrap(XConfigureRequestEvent.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return XConfigureRequestEvent.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return XConfigureRequestEvent.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return XConfigureRequestEvent.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return XConfigureRequestEvent.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    public static int ntype(long struct) {
        return UNSAFE.getInt(null, struct + (long)TYPE);
    }

    public static long nserial(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)SERIAL);
    }

    public static int nsend_event(long struct) {
        return UNSAFE.getInt(null, struct + (long)SEND_EVENT);
    }

    public static long ndisplay(long struct) {
        return MemoryUtil.memGetAddress(struct + (long)DISPLAY);
    }

    public static long nparent(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)PARENT);
    }

    public static long nwindow(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)WINDOW);
    }

    public static int nx(long struct) {
        return UNSAFE.getInt(null, struct + (long)X);
    }

    public static int ny(long struct) {
        return UNSAFE.getInt(null, struct + (long)Y);
    }

    public static int nwidth(long struct) {
        return UNSAFE.getInt(null, struct + (long)WIDTH);
    }

    public static int nheight(long struct) {
        return UNSAFE.getInt(null, struct + (long)HEIGHT);
    }

    public static int nborder_width(long struct) {
        return UNSAFE.getInt(null, struct + (long)BORDER_WIDTH);
    }

    public static long nabove(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)ABOVE);
    }

    public static int ndetail(long struct) {
        return UNSAFE.getInt(null, struct + (long)DETAIL);
    }

    public static long nvalue_mask(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)VALUE_MASK);
    }

    public static void ntype(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)TYPE, value);
    }

    public static void nserial(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)SERIAL, value);
    }

    public static void nsend_event(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)SEND_EVENT, value);
    }

    public static void ndisplay(long struct, long value) {
        MemoryUtil.memPutAddress(struct + (long)DISPLAY, Checks.check(value));
    }

    public static void nparent(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)PARENT, value);
    }

    public static void nwindow(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)WINDOW, value);
    }

    public static void nx(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)X, value);
    }

    public static void ny(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)Y, value);
    }

    public static void nwidth(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)WIDTH, value);
    }

    public static void nheight(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)HEIGHT, value);
    }

    public static void nborder_width(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)BORDER_WIDTH, value);
    }

    public static void nabove(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)ABOVE, value);
    }

    public static void ndetail(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)DETAIL, value);
    }

    public static void nvalue_mask(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)VALUE_MASK, value);
    }

    public static void validate(long struct) {
        Checks.check(MemoryUtil.memGetAddress(struct + (long)DISPLAY));
    }

    public static void validate(long array, int count) {
        for (int i = 0; i < count; ++i) {
            XConfigureRequestEvent.validate(array + Integer.toUnsignedLong(i) * (long)SIZEOF);
        }
    }

    static {
        Struct.Layout layout = XConfigureRequestEvent.__struct(XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(CLONG_SIZE), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(POINTER_SIZE), XConfigureRequestEvent.__member(CLONG_SIZE), XConfigureRequestEvent.__member(CLONG_SIZE), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(CLONG_SIZE), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(CLONG_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        PARENT = layout.offsetof(4);
        WINDOW = layout.offsetof(5);
        X = layout.offsetof(6);
        Y = layout.offsetof(7);
        WIDTH = layout.offsetof(8);
        HEIGHT = layout.offsetof(9);
        BORDER_WIDTH = layout.offsetof(10);
        ABOVE = layout.offsetof(11);
        DETAIL = layout.offsetof(12);
        VALUE_MASK = layout.offsetof(13);
    }

    public static class Buffer
    extends StructBuffer<XConfigureRequestEvent, Buffer>
    implements NativeResource {
        private static final XConfigureRequestEvent ELEMENT_FACTORY = XConfigureRequestEvent.create(-1L);

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
        protected XConfigureRequestEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XConfigureRequestEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XConfigureRequestEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XConfigureRequestEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XConfigureRequestEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long parent() {
            return XConfigureRequestEvent.nparent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XConfigureRequestEvent.nwindow(this.address());
        }

        public int x() {
            return XConfigureRequestEvent.nx(this.address());
        }

        public int y() {
            return XConfigureRequestEvent.ny(this.address());
        }

        public int width() {
            return XConfigureRequestEvent.nwidth(this.address());
        }

        public int height() {
            return XConfigureRequestEvent.nheight(this.address());
        }

        public int border_width() {
            return XConfigureRequestEvent.nborder_width(this.address());
        }

        @NativeType(value="Window")
        public long above() {
            return XConfigureRequestEvent.nabove(this.address());
        }

        public int detail() {
            return XConfigureRequestEvent.ndetail(this.address());
        }

        @NativeType(value="unsigned long")
        public long value_mask() {
            return XConfigureRequestEvent.nvalue_mask(this.address());
        }

        public Buffer type(int value) {
            XConfigureRequestEvent.ntype(this.address(), value);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long value) {
            XConfigureRequestEvent.nserial(this.address(), value);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean value) {
            XConfigureRequestEvent.nsend_event(this.address(), value ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long value) {
            XConfigureRequestEvent.ndisplay(this.address(), value);
            return this;
        }

        public Buffer parent(@NativeType(value="Window") long value) {
            XConfigureRequestEvent.nparent(this.address(), value);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long value) {
            XConfigureRequestEvent.nwindow(this.address(), value);
            return this;
        }

        public Buffer x(int value) {
            XConfigureRequestEvent.nx(this.address(), value);
            return this;
        }

        public Buffer y(int value) {
            XConfigureRequestEvent.ny(this.address(), value);
            return this;
        }

        public Buffer width(int value) {
            XConfigureRequestEvent.nwidth(this.address(), value);
            return this;
        }

        public Buffer height(int value) {
            XConfigureRequestEvent.nheight(this.address(), value);
            return this;
        }

        public Buffer border_width(int value) {
            XConfigureRequestEvent.nborder_width(this.address(), value);
            return this;
        }

        public Buffer above(@NativeType(value="Window") long value) {
            XConfigureRequestEvent.nabove(this.address(), value);
            return this;
        }

        public Buffer detail(int value) {
            XConfigureRequestEvent.ndetail(this.address(), value);
            return this;
        }

        public Buffer value_mask(@NativeType(value="unsigned long") long value) {
            XConfigureRequestEvent.nvalue_mask(this.address(), value);
            return this;
        }
    }
}

