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

public class XExposeEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int X;
    public static final int Y;
    public static final int WIDTH;
    public static final int HEIGHT;
    public static final int COUNT;

    public XExposeEvent(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), XExposeEvent.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XExposeEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XExposeEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XExposeEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XExposeEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XExposeEvent.nwindow(this.address());
    }

    public int x() {
        return XExposeEvent.nx(this.address());
    }

    public int y() {
        return XExposeEvent.ny(this.address());
    }

    public int width() {
        return XExposeEvent.nwidth(this.address());
    }

    public int height() {
        return XExposeEvent.nheight(this.address());
    }

    public int count() {
        return XExposeEvent.ncount(this.address());
    }

    public XExposeEvent type(int value) {
        XExposeEvent.ntype(this.address(), value);
        return this;
    }

    public XExposeEvent serial(@NativeType(value="unsigned long") long value) {
        XExposeEvent.nserial(this.address(), value);
        return this;
    }

    public XExposeEvent send_event(@NativeType(value="Bool") boolean value) {
        XExposeEvent.nsend_event(this.address(), value ? 1 : 0);
        return this;
    }

    public XExposeEvent display(@NativeType(value="Display *") long value) {
        XExposeEvent.ndisplay(this.address(), value);
        return this;
    }

    public XExposeEvent window(@NativeType(value="Window") long value) {
        XExposeEvent.nwindow(this.address(), value);
        return this;
    }

    public XExposeEvent x(int value) {
        XExposeEvent.nx(this.address(), value);
        return this;
    }

    public XExposeEvent y(int value) {
        XExposeEvent.ny(this.address(), value);
        return this;
    }

    public XExposeEvent width(int value) {
        XExposeEvent.nwidth(this.address(), value);
        return this;
    }

    public XExposeEvent height(int value) {
        XExposeEvent.nheight(this.address(), value);
        return this;
    }

    public XExposeEvent count(int value) {
        XExposeEvent.ncount(this.address(), value);
        return this;
    }

    public XExposeEvent set(int type, long serial, boolean send_event, long display, long window, int x, int y, int width, int height, int count) {
        this.type(type);
        this.serial(serial);
        this.send_event(send_event);
        this.display(display);
        this.window(window);
        this.x(x);
        this.y(y);
        this.width(width);
        this.height(height);
        this.count(count);
        return this;
    }

    public XExposeEvent set(XExposeEvent src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static XExposeEvent malloc() {
        return XExposeEvent.wrap(XExposeEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XExposeEvent calloc() {
        return XExposeEvent.wrap(XExposeEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XExposeEvent create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return XExposeEvent.wrap(XExposeEvent.class, MemoryUtil.memAddress(container), container);
    }

    public static XExposeEvent create(long address) {
        return XExposeEvent.wrap(XExposeEvent.class, address);
    }

    @Nullable
    public static XExposeEvent createSafe(long address) {
        return address == 0L ? null : XExposeEvent.wrap(XExposeEvent.class, address);
    }

    public static Buffer malloc(int capacity) {
        return XExposeEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XExposeEvent.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return XExposeEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = XExposeEvent.__create(capacity, SIZEOF);
        return XExposeEvent.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return XExposeEvent.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : XExposeEvent.wrap(Buffer.class, address, capacity);
    }

    public static XExposeEvent mallocStack() {
        return XExposeEvent.mallocStack(MemoryStack.stackGet());
    }

    public static XExposeEvent callocStack() {
        return XExposeEvent.callocStack(MemoryStack.stackGet());
    }

    public static XExposeEvent mallocStack(MemoryStack stack) {
        return XExposeEvent.wrap(XExposeEvent.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XExposeEvent callocStack(MemoryStack stack) {
        return XExposeEvent.wrap(XExposeEvent.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return XExposeEvent.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return XExposeEvent.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return XExposeEvent.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return XExposeEvent.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
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

    public static int ncount(long struct) {
        return UNSAFE.getInt(null, struct + (long)COUNT);
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

    public static void ncount(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)COUNT, value);
    }

    public static void validate(long struct) {
        Checks.check(MemoryUtil.memGetAddress(struct + (long)DISPLAY));
    }

    public static void validate(long array, int count) {
        for (int i = 0; i < count; ++i) {
            XExposeEvent.validate(array + Integer.toUnsignedLong(i) * (long)SIZEOF);
        }
    }

    static {
        Struct.Layout layout = XExposeEvent.__struct(XExposeEvent.__member(4), XExposeEvent.__member(CLONG_SIZE), XExposeEvent.__member(4), XExposeEvent.__member(POINTER_SIZE), XExposeEvent.__member(CLONG_SIZE), XExposeEvent.__member(4), XExposeEvent.__member(4), XExposeEvent.__member(4), XExposeEvent.__member(4), XExposeEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        X = layout.offsetof(5);
        Y = layout.offsetof(6);
        WIDTH = layout.offsetof(7);
        HEIGHT = layout.offsetof(8);
        COUNT = layout.offsetof(9);
    }

    public static class Buffer
    extends StructBuffer<XExposeEvent, Buffer>
    implements NativeResource {
        private static final XExposeEvent ELEMENT_FACTORY = XExposeEvent.create(-1L);

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
        protected XExposeEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XExposeEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XExposeEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XExposeEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XExposeEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XExposeEvent.nwindow(this.address());
        }

        public int x() {
            return XExposeEvent.nx(this.address());
        }

        public int y() {
            return XExposeEvent.ny(this.address());
        }

        public int width() {
            return XExposeEvent.nwidth(this.address());
        }

        public int height() {
            return XExposeEvent.nheight(this.address());
        }

        public int count() {
            return XExposeEvent.ncount(this.address());
        }

        public Buffer type(int value) {
            XExposeEvent.ntype(this.address(), value);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long value) {
            XExposeEvent.nserial(this.address(), value);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean value) {
            XExposeEvent.nsend_event(this.address(), value ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long value) {
            XExposeEvent.ndisplay(this.address(), value);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long value) {
            XExposeEvent.nwindow(this.address(), value);
            return this;
        }

        public Buffer x(int value) {
            XExposeEvent.nx(this.address(), value);
            return this;
        }

        public Buffer y(int value) {
            XExposeEvent.ny(this.address(), value);
            return this;
        }

        public Buffer width(int value) {
            XExposeEvent.nwidth(this.address(), value);
            return this;
        }

        public Buffer height(int value) {
            XExposeEvent.nheight(this.address(), value);
            return this;
        }

        public Buffer count(int value) {
            XExposeEvent.ncount(this.address(), value);
            return this;
        }
    }
}

