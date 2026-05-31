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

public class XMappingEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int REQUEST;
    public static final int FIRST_KEYCODE;
    public static final int COUNT;

    public XMappingEvent(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), XMappingEvent.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XMappingEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XMappingEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XMappingEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XMappingEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XMappingEvent.nwindow(this.address());
    }

    public int request() {
        return XMappingEvent.nrequest(this.address());
    }

    public int first_keycode() {
        return XMappingEvent.nfirst_keycode(this.address());
    }

    public int count() {
        return XMappingEvent.ncount(this.address());
    }

    public XMappingEvent type(int value) {
        XMappingEvent.ntype(this.address(), value);
        return this;
    }

    public XMappingEvent serial(@NativeType(value="unsigned long") long value) {
        XMappingEvent.nserial(this.address(), value);
        return this;
    }

    public XMappingEvent send_event(@NativeType(value="Bool") boolean value) {
        XMappingEvent.nsend_event(this.address(), value ? 1 : 0);
        return this;
    }

    public XMappingEvent display(@NativeType(value="Display *") long value) {
        XMappingEvent.ndisplay(this.address(), value);
        return this;
    }

    public XMappingEvent window(@NativeType(value="Window") long value) {
        XMappingEvent.nwindow(this.address(), value);
        return this;
    }

    public XMappingEvent request(int value) {
        XMappingEvent.nrequest(this.address(), value);
        return this;
    }

    public XMappingEvent first_keycode(int value) {
        XMappingEvent.nfirst_keycode(this.address(), value);
        return this;
    }

    public XMappingEvent count(int value) {
        XMappingEvent.ncount(this.address(), value);
        return this;
    }

    public XMappingEvent set(int type, long serial, boolean send_event, long display, long window, int request, int first_keycode, int count) {
        this.type(type);
        this.serial(serial);
        this.send_event(send_event);
        this.display(display);
        this.window(window);
        this.request(request);
        this.first_keycode(first_keycode);
        this.count(count);
        return this;
    }

    public XMappingEvent set(XMappingEvent src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static XMappingEvent malloc() {
        return XMappingEvent.wrap(XMappingEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XMappingEvent calloc() {
        return XMappingEvent.wrap(XMappingEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XMappingEvent create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return XMappingEvent.wrap(XMappingEvent.class, MemoryUtil.memAddress(container), container);
    }

    public static XMappingEvent create(long address) {
        return XMappingEvent.wrap(XMappingEvent.class, address);
    }

    @Nullable
    public static XMappingEvent createSafe(long address) {
        return address == 0L ? null : XMappingEvent.wrap(XMappingEvent.class, address);
    }

    public static Buffer malloc(int capacity) {
        return XMappingEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XMappingEvent.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return XMappingEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = XMappingEvent.__create(capacity, SIZEOF);
        return XMappingEvent.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return XMappingEvent.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : XMappingEvent.wrap(Buffer.class, address, capacity);
    }

    public static XMappingEvent mallocStack() {
        return XMappingEvent.mallocStack(MemoryStack.stackGet());
    }

    public static XMappingEvent callocStack() {
        return XMappingEvent.callocStack(MemoryStack.stackGet());
    }

    public static XMappingEvent mallocStack(MemoryStack stack) {
        return XMappingEvent.wrap(XMappingEvent.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XMappingEvent callocStack(MemoryStack stack) {
        return XMappingEvent.wrap(XMappingEvent.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return XMappingEvent.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return XMappingEvent.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return XMappingEvent.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return XMappingEvent.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
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

    public static int nrequest(long struct) {
        return UNSAFE.getInt(null, struct + (long)REQUEST);
    }

    public static int nfirst_keycode(long struct) {
        return UNSAFE.getInt(null, struct + (long)FIRST_KEYCODE);
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

    public static void nrequest(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)REQUEST, value);
    }

    public static void nfirst_keycode(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)FIRST_KEYCODE, value);
    }

    public static void ncount(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)COUNT, value);
    }

    public static void validate(long struct) {
        Checks.check(MemoryUtil.memGetAddress(struct + (long)DISPLAY));
    }

    public static void validate(long array, int count) {
        for (int i = 0; i < count; ++i) {
            XMappingEvent.validate(array + Integer.toUnsignedLong(i) * (long)SIZEOF);
        }
    }

    static {
        Struct.Layout layout = XMappingEvent.__struct(XMappingEvent.__member(4), XMappingEvent.__member(CLONG_SIZE), XMappingEvent.__member(4), XMappingEvent.__member(POINTER_SIZE), XMappingEvent.__member(CLONG_SIZE), XMappingEvent.__member(4), XMappingEvent.__member(4), XMappingEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        REQUEST = layout.offsetof(5);
        FIRST_KEYCODE = layout.offsetof(6);
        COUNT = layout.offsetof(7);
    }

    public static class Buffer
    extends StructBuffer<XMappingEvent, Buffer>
    implements NativeResource {
        private static final XMappingEvent ELEMENT_FACTORY = XMappingEvent.create(-1L);

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
        protected XMappingEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XMappingEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XMappingEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XMappingEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XMappingEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XMappingEvent.nwindow(this.address());
        }

        public int request() {
            return XMappingEvent.nrequest(this.address());
        }

        public int first_keycode() {
            return XMappingEvent.nfirst_keycode(this.address());
        }

        public int count() {
            return XMappingEvent.ncount(this.address());
        }

        public Buffer type(int value) {
            XMappingEvent.ntype(this.address(), value);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long value) {
            XMappingEvent.nserial(this.address(), value);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean value) {
            XMappingEvent.nsend_event(this.address(), value ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long value) {
            XMappingEvent.ndisplay(this.address(), value);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long value) {
            XMappingEvent.nwindow(this.address(), value);
            return this;
        }

        public Buffer request(int value) {
            XMappingEvent.nrequest(this.address(), value);
            return this;
        }

        public Buffer first_keycode(int value) {
            XMappingEvent.nfirst_keycode(this.address(), value);
            return this;
        }

        public Buffer count(int value) {
            XMappingEvent.ncount(this.address(), value);
            return this;
        }
    }
}

