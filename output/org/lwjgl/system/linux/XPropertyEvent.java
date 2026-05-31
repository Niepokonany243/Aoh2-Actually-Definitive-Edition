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

public class XPropertyEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int ATOM;
    public static final int TIME;
    public static final int STATE;

    public XPropertyEvent(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), XPropertyEvent.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XPropertyEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XPropertyEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XPropertyEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XPropertyEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XPropertyEvent.nwindow(this.address());
    }

    @NativeType(value="Atom")
    public long atom() {
        return XPropertyEvent.natom(this.address());
    }

    @NativeType(value="Time")
    public long time() {
        return XPropertyEvent.ntime(this.address());
    }

    public int state() {
        return XPropertyEvent.nstate(this.address());
    }

    public XPropertyEvent type(int value) {
        XPropertyEvent.ntype(this.address(), value);
        return this;
    }

    public XPropertyEvent serial(@NativeType(value="unsigned long") long value) {
        XPropertyEvent.nserial(this.address(), value);
        return this;
    }

    public XPropertyEvent send_event(@NativeType(value="Bool") boolean value) {
        XPropertyEvent.nsend_event(this.address(), value ? 1 : 0);
        return this;
    }

    public XPropertyEvent display(@NativeType(value="Display *") long value) {
        XPropertyEvent.ndisplay(this.address(), value);
        return this;
    }

    public XPropertyEvent window(@NativeType(value="Window") long value) {
        XPropertyEvent.nwindow(this.address(), value);
        return this;
    }

    public XPropertyEvent atom(@NativeType(value="Atom") long value) {
        XPropertyEvent.natom(this.address(), value);
        return this;
    }

    public XPropertyEvent time(@NativeType(value="Time") long value) {
        XPropertyEvent.ntime(this.address(), value);
        return this;
    }

    public XPropertyEvent state(int value) {
        XPropertyEvent.nstate(this.address(), value);
        return this;
    }

    public XPropertyEvent set(int type, long serial, boolean send_event, long display, long window, long atom, long time, int state) {
        this.type(type);
        this.serial(serial);
        this.send_event(send_event);
        this.display(display);
        this.window(window);
        this.atom(atom);
        this.time(time);
        this.state(state);
        return this;
    }

    public XPropertyEvent set(XPropertyEvent src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static XPropertyEvent malloc() {
        return XPropertyEvent.wrap(XPropertyEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XPropertyEvent calloc() {
        return XPropertyEvent.wrap(XPropertyEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XPropertyEvent create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return XPropertyEvent.wrap(XPropertyEvent.class, MemoryUtil.memAddress(container), container);
    }

    public static XPropertyEvent create(long address) {
        return XPropertyEvent.wrap(XPropertyEvent.class, address);
    }

    @Nullable
    public static XPropertyEvent createSafe(long address) {
        return address == 0L ? null : XPropertyEvent.wrap(XPropertyEvent.class, address);
    }

    public static Buffer malloc(int capacity) {
        return XPropertyEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XPropertyEvent.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return XPropertyEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = XPropertyEvent.__create(capacity, SIZEOF);
        return XPropertyEvent.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return XPropertyEvent.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : XPropertyEvent.wrap(Buffer.class, address, capacity);
    }

    public static XPropertyEvent mallocStack() {
        return XPropertyEvent.mallocStack(MemoryStack.stackGet());
    }

    public static XPropertyEvent callocStack() {
        return XPropertyEvent.callocStack(MemoryStack.stackGet());
    }

    public static XPropertyEvent mallocStack(MemoryStack stack) {
        return XPropertyEvent.wrap(XPropertyEvent.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XPropertyEvent callocStack(MemoryStack stack) {
        return XPropertyEvent.wrap(XPropertyEvent.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return XPropertyEvent.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return XPropertyEvent.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return XPropertyEvent.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return XPropertyEvent.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
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

    public static long natom(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)ATOM);
    }

    public static long ntime(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)TIME);
    }

    public static int nstate(long struct) {
        return UNSAFE.getInt(null, struct + (long)STATE);
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

    public static void natom(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)ATOM, value);
    }

    public static void ntime(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)TIME, value);
    }

    public static void nstate(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)STATE, value);
    }

    public static void validate(long struct) {
        Checks.check(MemoryUtil.memGetAddress(struct + (long)DISPLAY));
    }

    public static void validate(long array, int count) {
        for (int i = 0; i < count; ++i) {
            XPropertyEvent.validate(array + Integer.toUnsignedLong(i) * (long)SIZEOF);
        }
    }

    static {
        Struct.Layout layout = XPropertyEvent.__struct(XPropertyEvent.__member(4), XPropertyEvent.__member(CLONG_SIZE), XPropertyEvent.__member(4), XPropertyEvent.__member(POINTER_SIZE), XPropertyEvent.__member(CLONG_SIZE), XPropertyEvent.__member(CLONG_SIZE), XPropertyEvent.__member(CLONG_SIZE), XPropertyEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        ATOM = layout.offsetof(5);
        TIME = layout.offsetof(6);
        STATE = layout.offsetof(7);
    }

    public static class Buffer
    extends StructBuffer<XPropertyEvent, Buffer>
    implements NativeResource {
        private static final XPropertyEvent ELEMENT_FACTORY = XPropertyEvent.create(-1L);

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
        protected XPropertyEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XPropertyEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XPropertyEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XPropertyEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XPropertyEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XPropertyEvent.nwindow(this.address());
        }

        @NativeType(value="Atom")
        public long atom() {
            return XPropertyEvent.natom(this.address());
        }

        @NativeType(value="Time")
        public long time() {
            return XPropertyEvent.ntime(this.address());
        }

        public int state() {
            return XPropertyEvent.nstate(this.address());
        }

        public Buffer type(int value) {
            XPropertyEvent.ntype(this.address(), value);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long value) {
            XPropertyEvent.nserial(this.address(), value);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean value) {
            XPropertyEvent.nsend_event(this.address(), value ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long value) {
            XPropertyEvent.ndisplay(this.address(), value);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long value) {
            XPropertyEvent.nwindow(this.address(), value);
            return this;
        }

        public Buffer atom(@NativeType(value="Atom") long value) {
            XPropertyEvent.natom(this.address(), value);
            return this;
        }

        public Buffer time(@NativeType(value="Time") long value) {
            XPropertyEvent.ntime(this.address(), value);
            return this;
        }

        public Buffer state(int value) {
            XPropertyEvent.nstate(this.address(), value);
            return this;
        }
    }
}

