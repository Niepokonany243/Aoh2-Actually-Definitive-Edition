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

public class XCreateWindowEvent
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
    public static final int OVERRIDE_REDIRECT;

    public XCreateWindowEvent(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), XCreateWindowEvent.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XCreateWindowEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XCreateWindowEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XCreateWindowEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XCreateWindowEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long parent() {
        return XCreateWindowEvent.nparent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XCreateWindowEvent.nwindow(this.address());
    }

    public int x() {
        return XCreateWindowEvent.nx(this.address());
    }

    public int y() {
        return XCreateWindowEvent.ny(this.address());
    }

    public int width() {
        return XCreateWindowEvent.nwidth(this.address());
    }

    public int height() {
        return XCreateWindowEvent.nheight(this.address());
    }

    public int border_width() {
        return XCreateWindowEvent.nborder_width(this.address());
    }

    public int override_redirect() {
        return XCreateWindowEvent.noverride_redirect(this.address());
    }

    public XCreateWindowEvent type(int value) {
        XCreateWindowEvent.ntype(this.address(), value);
        return this;
    }

    public XCreateWindowEvent serial(@NativeType(value="unsigned long") long value) {
        XCreateWindowEvent.nserial(this.address(), value);
        return this;
    }

    public XCreateWindowEvent send_event(@NativeType(value="Bool") boolean value) {
        XCreateWindowEvent.nsend_event(this.address(), value ? 1 : 0);
        return this;
    }

    public XCreateWindowEvent display(@NativeType(value="Display *") long value) {
        XCreateWindowEvent.ndisplay(this.address(), value);
        return this;
    }

    public XCreateWindowEvent parent(@NativeType(value="Window") long value) {
        XCreateWindowEvent.nparent(this.address(), value);
        return this;
    }

    public XCreateWindowEvent window(@NativeType(value="Window") long value) {
        XCreateWindowEvent.nwindow(this.address(), value);
        return this;
    }

    public XCreateWindowEvent x(int value) {
        XCreateWindowEvent.nx(this.address(), value);
        return this;
    }

    public XCreateWindowEvent y(int value) {
        XCreateWindowEvent.ny(this.address(), value);
        return this;
    }

    public XCreateWindowEvent width(int value) {
        XCreateWindowEvent.nwidth(this.address(), value);
        return this;
    }

    public XCreateWindowEvent height(int value) {
        XCreateWindowEvent.nheight(this.address(), value);
        return this;
    }

    public XCreateWindowEvent border_width(int value) {
        XCreateWindowEvent.nborder_width(this.address(), value);
        return this;
    }

    public XCreateWindowEvent override_redirect(int value) {
        XCreateWindowEvent.noverride_redirect(this.address(), value);
        return this;
    }

    public XCreateWindowEvent set(int type, long serial, boolean send_event, long display, long parent, long window, int x, int y, int width, int height, int border_width, int override_redirect) {
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
        this.override_redirect(override_redirect);
        return this;
    }

    public XCreateWindowEvent set(XCreateWindowEvent src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static XCreateWindowEvent malloc() {
        return XCreateWindowEvent.wrap(XCreateWindowEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XCreateWindowEvent calloc() {
        return XCreateWindowEvent.wrap(XCreateWindowEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XCreateWindowEvent create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return XCreateWindowEvent.wrap(XCreateWindowEvent.class, MemoryUtil.memAddress(container), container);
    }

    public static XCreateWindowEvent create(long address) {
        return XCreateWindowEvent.wrap(XCreateWindowEvent.class, address);
    }

    @Nullable
    public static XCreateWindowEvent createSafe(long address) {
        return address == 0L ? null : XCreateWindowEvent.wrap(XCreateWindowEvent.class, address);
    }

    public static Buffer malloc(int capacity) {
        return XCreateWindowEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XCreateWindowEvent.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return XCreateWindowEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = XCreateWindowEvent.__create(capacity, SIZEOF);
        return XCreateWindowEvent.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return XCreateWindowEvent.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : XCreateWindowEvent.wrap(Buffer.class, address, capacity);
    }

    public static XCreateWindowEvent mallocStack() {
        return XCreateWindowEvent.mallocStack(MemoryStack.stackGet());
    }

    public static XCreateWindowEvent callocStack() {
        return XCreateWindowEvent.callocStack(MemoryStack.stackGet());
    }

    public static XCreateWindowEvent mallocStack(MemoryStack stack) {
        return XCreateWindowEvent.wrap(XCreateWindowEvent.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XCreateWindowEvent callocStack(MemoryStack stack) {
        return XCreateWindowEvent.wrap(XCreateWindowEvent.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return XCreateWindowEvent.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return XCreateWindowEvent.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return XCreateWindowEvent.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return XCreateWindowEvent.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
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

    public static int noverride_redirect(long struct) {
        return UNSAFE.getInt(null, struct + (long)OVERRIDE_REDIRECT);
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

    public static void noverride_redirect(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)OVERRIDE_REDIRECT, value);
    }

    public static void validate(long struct) {
        Checks.check(MemoryUtil.memGetAddress(struct + (long)DISPLAY));
    }

    public static void validate(long array, int count) {
        for (int i = 0; i < count; ++i) {
            XCreateWindowEvent.validate(array + Integer.toUnsignedLong(i) * (long)SIZEOF);
        }
    }

    static {
        Struct.Layout layout = XCreateWindowEvent.__struct(XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(CLONG_SIZE), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(POINTER_SIZE), XCreateWindowEvent.__member(CLONG_SIZE), XCreateWindowEvent.__member(CLONG_SIZE), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(4));
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
        OVERRIDE_REDIRECT = layout.offsetof(11);
    }

    public static class Buffer
    extends StructBuffer<XCreateWindowEvent, Buffer>
    implements NativeResource {
        private static final XCreateWindowEvent ELEMENT_FACTORY = XCreateWindowEvent.create(-1L);

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
        protected XCreateWindowEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XCreateWindowEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XCreateWindowEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XCreateWindowEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XCreateWindowEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long parent() {
            return XCreateWindowEvent.nparent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XCreateWindowEvent.nwindow(this.address());
        }

        public int x() {
            return XCreateWindowEvent.nx(this.address());
        }

        public int y() {
            return XCreateWindowEvent.ny(this.address());
        }

        public int width() {
            return XCreateWindowEvent.nwidth(this.address());
        }

        public int height() {
            return XCreateWindowEvent.nheight(this.address());
        }

        public int border_width() {
            return XCreateWindowEvent.nborder_width(this.address());
        }

        public int override_redirect() {
            return XCreateWindowEvent.noverride_redirect(this.address());
        }

        public Buffer type(int value) {
            XCreateWindowEvent.ntype(this.address(), value);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long value) {
            XCreateWindowEvent.nserial(this.address(), value);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean value) {
            XCreateWindowEvent.nsend_event(this.address(), value ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long value) {
            XCreateWindowEvent.ndisplay(this.address(), value);
            return this;
        }

        public Buffer parent(@NativeType(value="Window") long value) {
            XCreateWindowEvent.nparent(this.address(), value);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long value) {
            XCreateWindowEvent.nwindow(this.address(), value);
            return this;
        }

        public Buffer x(int value) {
            XCreateWindowEvent.nx(this.address(), value);
            return this;
        }

        public Buffer y(int value) {
            XCreateWindowEvent.ny(this.address(), value);
            return this;
        }

        public Buffer width(int value) {
            XCreateWindowEvent.nwidth(this.address(), value);
            return this;
        }

        public Buffer height(int value) {
            XCreateWindowEvent.nheight(this.address(), value);
            return this;
        }

        public Buffer border_width(int value) {
            XCreateWindowEvent.nborder_width(this.address(), value);
            return this;
        }

        public Buffer override_redirect(int value) {
            XCreateWindowEvent.noverride_redirect(this.address(), value);
            return this;
        }
    }
}

