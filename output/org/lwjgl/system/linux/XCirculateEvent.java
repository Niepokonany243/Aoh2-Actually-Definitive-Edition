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

public class XCirculateEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int EVENT;
    public static final int WINDOW;
    public static final int PLACE;

    public XCirculateEvent(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), XCirculateEvent.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XCirculateEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XCirculateEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XCirculateEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XCirculateEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long event() {
        return XCirculateEvent.nevent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XCirculateEvent.nwindow(this.address());
    }

    public int place() {
        return XCirculateEvent.nplace(this.address());
    }

    public XCirculateEvent type(int value) {
        XCirculateEvent.ntype(this.address(), value);
        return this;
    }

    public XCirculateEvent serial(@NativeType(value="unsigned long") long value) {
        XCirculateEvent.nserial(this.address(), value);
        return this;
    }

    public XCirculateEvent send_event(@NativeType(value="Bool") boolean value) {
        XCirculateEvent.nsend_event(this.address(), value ? 1 : 0);
        return this;
    }

    public XCirculateEvent display(@NativeType(value="Display *") long value) {
        XCirculateEvent.ndisplay(this.address(), value);
        return this;
    }

    public XCirculateEvent event(@NativeType(value="Window") long value) {
        XCirculateEvent.nevent(this.address(), value);
        return this;
    }

    public XCirculateEvent window(@NativeType(value="Window") long value) {
        XCirculateEvent.nwindow(this.address(), value);
        return this;
    }

    public XCirculateEvent place(int value) {
        XCirculateEvent.nplace(this.address(), value);
        return this;
    }

    public XCirculateEvent set(int type, long serial, boolean send_event, long display, long event, long window, int place) {
        this.type(type);
        this.serial(serial);
        this.send_event(send_event);
        this.display(display);
        this.event(event);
        this.window(window);
        this.place(place);
        return this;
    }

    public XCirculateEvent set(XCirculateEvent src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static XCirculateEvent malloc() {
        return XCirculateEvent.wrap(XCirculateEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XCirculateEvent calloc() {
        return XCirculateEvent.wrap(XCirculateEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XCirculateEvent create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return XCirculateEvent.wrap(XCirculateEvent.class, MemoryUtil.memAddress(container), container);
    }

    public static XCirculateEvent create(long address) {
        return XCirculateEvent.wrap(XCirculateEvent.class, address);
    }

    @Nullable
    public static XCirculateEvent createSafe(long address) {
        return address == 0L ? null : XCirculateEvent.wrap(XCirculateEvent.class, address);
    }

    public static Buffer malloc(int capacity) {
        return XCirculateEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XCirculateEvent.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return XCirculateEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = XCirculateEvent.__create(capacity, SIZEOF);
        return XCirculateEvent.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return XCirculateEvent.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : XCirculateEvent.wrap(Buffer.class, address, capacity);
    }

    public static XCirculateEvent mallocStack() {
        return XCirculateEvent.mallocStack(MemoryStack.stackGet());
    }

    public static XCirculateEvent callocStack() {
        return XCirculateEvent.callocStack(MemoryStack.stackGet());
    }

    public static XCirculateEvent mallocStack(MemoryStack stack) {
        return XCirculateEvent.wrap(XCirculateEvent.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XCirculateEvent callocStack(MemoryStack stack) {
        return XCirculateEvent.wrap(XCirculateEvent.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return XCirculateEvent.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return XCirculateEvent.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return XCirculateEvent.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return XCirculateEvent.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
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

    public static long nevent(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)EVENT);
    }

    public static long nwindow(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)WINDOW);
    }

    public static int nplace(long struct) {
        return UNSAFE.getInt(null, struct + (long)PLACE);
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

    public static void nevent(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)EVENT, value);
    }

    public static void nwindow(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)WINDOW, value);
    }

    public static void nplace(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)PLACE, value);
    }

    public static void validate(long struct) {
        Checks.check(MemoryUtil.memGetAddress(struct + (long)DISPLAY));
    }

    public static void validate(long array, int count) {
        for (int i = 0; i < count; ++i) {
            XCirculateEvent.validate(array + Integer.toUnsignedLong(i) * (long)SIZEOF);
        }
    }

    static {
        Struct.Layout layout = XCirculateEvent.__struct(XCirculateEvent.__member(4), XCirculateEvent.__member(CLONG_SIZE), XCirculateEvent.__member(4), XCirculateEvent.__member(POINTER_SIZE), XCirculateEvent.__member(CLONG_SIZE), XCirculateEvent.__member(CLONG_SIZE), XCirculateEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        EVENT = layout.offsetof(4);
        WINDOW = layout.offsetof(5);
        PLACE = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<XCirculateEvent, Buffer>
    implements NativeResource {
        private static final XCirculateEvent ELEMENT_FACTORY = XCirculateEvent.create(-1L);

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
        protected XCirculateEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XCirculateEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XCirculateEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XCirculateEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XCirculateEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long event() {
            return XCirculateEvent.nevent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XCirculateEvent.nwindow(this.address());
        }

        public int place() {
            return XCirculateEvent.nplace(this.address());
        }

        public Buffer type(int value) {
            XCirculateEvent.ntype(this.address(), value);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long value) {
            XCirculateEvent.nserial(this.address(), value);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean value) {
            XCirculateEvent.nsend_event(this.address(), value ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long value) {
            XCirculateEvent.ndisplay(this.address(), value);
            return this;
        }

        public Buffer event(@NativeType(value="Window") long value) {
            XCirculateEvent.nevent(this.address(), value);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long value) {
            XCirculateEvent.nwindow(this.address(), value);
            return this;
        }

        public Buffer place(int value) {
            XCirculateEvent.nplace(this.address(), value);
            return this;
        }
    }
}

