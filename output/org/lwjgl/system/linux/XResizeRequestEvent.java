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

public class XResizeRequestEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int WIDTH;
    public static final int HEIGHT;

    public XResizeRequestEvent(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), XResizeRequestEvent.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XResizeRequestEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XResizeRequestEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XResizeRequestEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XResizeRequestEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XResizeRequestEvent.nwindow(this.address());
    }

    public int width() {
        return XResizeRequestEvent.nwidth(this.address());
    }

    public int height() {
        return XResizeRequestEvent.nheight(this.address());
    }

    public XResizeRequestEvent type(int value) {
        XResizeRequestEvent.ntype(this.address(), value);
        return this;
    }

    public XResizeRequestEvent serial(@NativeType(value="unsigned long") long value) {
        XResizeRequestEvent.nserial(this.address(), value);
        return this;
    }

    public XResizeRequestEvent send_event(@NativeType(value="Bool") boolean value) {
        XResizeRequestEvent.nsend_event(this.address(), value ? 1 : 0);
        return this;
    }

    public XResizeRequestEvent display(@NativeType(value="Display *") long value) {
        XResizeRequestEvent.ndisplay(this.address(), value);
        return this;
    }

    public XResizeRequestEvent window(@NativeType(value="Window") long value) {
        XResizeRequestEvent.nwindow(this.address(), value);
        return this;
    }

    public XResizeRequestEvent width(int value) {
        XResizeRequestEvent.nwidth(this.address(), value);
        return this;
    }

    public XResizeRequestEvent height(int value) {
        XResizeRequestEvent.nheight(this.address(), value);
        return this;
    }

    public XResizeRequestEvent set(int type, long serial, boolean send_event, long display, long window, int width, int height) {
        this.type(type);
        this.serial(serial);
        this.send_event(send_event);
        this.display(display);
        this.window(window);
        this.width(width);
        this.height(height);
        return this;
    }

    public XResizeRequestEvent set(XResizeRequestEvent src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static XResizeRequestEvent malloc() {
        return XResizeRequestEvent.wrap(XResizeRequestEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XResizeRequestEvent calloc() {
        return XResizeRequestEvent.wrap(XResizeRequestEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XResizeRequestEvent create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return XResizeRequestEvent.wrap(XResizeRequestEvent.class, MemoryUtil.memAddress(container), container);
    }

    public static XResizeRequestEvent create(long address) {
        return XResizeRequestEvent.wrap(XResizeRequestEvent.class, address);
    }

    @Nullable
    public static XResizeRequestEvent createSafe(long address) {
        return address == 0L ? null : XResizeRequestEvent.wrap(XResizeRequestEvent.class, address);
    }

    public static Buffer malloc(int capacity) {
        return XResizeRequestEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XResizeRequestEvent.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return XResizeRequestEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = XResizeRequestEvent.__create(capacity, SIZEOF);
        return XResizeRequestEvent.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return XResizeRequestEvent.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : XResizeRequestEvent.wrap(Buffer.class, address, capacity);
    }

    public static XResizeRequestEvent mallocStack() {
        return XResizeRequestEvent.mallocStack(MemoryStack.stackGet());
    }

    public static XResizeRequestEvent callocStack() {
        return XResizeRequestEvent.callocStack(MemoryStack.stackGet());
    }

    public static XResizeRequestEvent mallocStack(MemoryStack stack) {
        return XResizeRequestEvent.wrap(XResizeRequestEvent.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XResizeRequestEvent callocStack(MemoryStack stack) {
        return XResizeRequestEvent.wrap(XResizeRequestEvent.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return XResizeRequestEvent.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return XResizeRequestEvent.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return XResizeRequestEvent.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return XResizeRequestEvent.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
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

    public static int nwidth(long struct) {
        return UNSAFE.getInt(null, struct + (long)WIDTH);
    }

    public static int nheight(long struct) {
        return UNSAFE.getInt(null, struct + (long)HEIGHT);
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

    public static void nwidth(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)WIDTH, value);
    }

    public static void nheight(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)HEIGHT, value);
    }

    public static void validate(long struct) {
        Checks.check(MemoryUtil.memGetAddress(struct + (long)DISPLAY));
    }

    public static void validate(long array, int count) {
        for (int i = 0; i < count; ++i) {
            XResizeRequestEvent.validate(array + Integer.toUnsignedLong(i) * (long)SIZEOF);
        }
    }

    static {
        Struct.Layout layout = XResizeRequestEvent.__struct(XResizeRequestEvent.__member(4), XResizeRequestEvent.__member(CLONG_SIZE), XResizeRequestEvent.__member(4), XResizeRequestEvent.__member(POINTER_SIZE), XResizeRequestEvent.__member(CLONG_SIZE), XResizeRequestEvent.__member(4), XResizeRequestEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        WIDTH = layout.offsetof(5);
        HEIGHT = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<XResizeRequestEvent, Buffer>
    implements NativeResource {
        private static final XResizeRequestEvent ELEMENT_FACTORY = XResizeRequestEvent.create(-1L);

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
        protected XResizeRequestEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XResizeRequestEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XResizeRequestEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XResizeRequestEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XResizeRequestEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XResizeRequestEvent.nwindow(this.address());
        }

        public int width() {
            return XResizeRequestEvent.nwidth(this.address());
        }

        public int height() {
            return XResizeRequestEvent.nheight(this.address());
        }

        public Buffer type(int value) {
            XResizeRequestEvent.ntype(this.address(), value);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long value) {
            XResizeRequestEvent.nserial(this.address(), value);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean value) {
            XResizeRequestEvent.nsend_event(this.address(), value ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long value) {
            XResizeRequestEvent.ndisplay(this.address(), value);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long value) {
            XResizeRequestEvent.nwindow(this.address(), value);
            return this;
        }

        public Buffer width(int value) {
            XResizeRequestEvent.nwidth(this.address(), value);
            return this;
        }

        public Buffer height(int value) {
            XResizeRequestEvent.nheight(this.address(), value);
            return this;
        }
    }
}

