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

public class XUnmapEvent
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
    public static final int FROM_CONFIGURE;

    public XUnmapEvent(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), XUnmapEvent.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XUnmapEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XUnmapEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XUnmapEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XUnmapEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long event() {
        return XUnmapEvent.nevent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XUnmapEvent.nwindow(this.address());
    }

    public int from_configure() {
        return XUnmapEvent.nfrom_configure(this.address());
    }

    public XUnmapEvent type(int value) {
        XUnmapEvent.ntype(this.address(), value);
        return this;
    }

    public XUnmapEvent serial(@NativeType(value="unsigned long") long value) {
        XUnmapEvent.nserial(this.address(), value);
        return this;
    }

    public XUnmapEvent send_event(@NativeType(value="Bool") boolean value) {
        XUnmapEvent.nsend_event(this.address(), value ? 1 : 0);
        return this;
    }

    public XUnmapEvent display(@NativeType(value="Display *") long value) {
        XUnmapEvent.ndisplay(this.address(), value);
        return this;
    }

    public XUnmapEvent event(@NativeType(value="Window") long value) {
        XUnmapEvent.nevent(this.address(), value);
        return this;
    }

    public XUnmapEvent window(@NativeType(value="Window") long value) {
        XUnmapEvent.nwindow(this.address(), value);
        return this;
    }

    public XUnmapEvent from_configure(int value) {
        XUnmapEvent.nfrom_configure(this.address(), value);
        return this;
    }

    public XUnmapEvent set(int type, long serial, boolean send_event, long display, long event, long window, int from_configure) {
        this.type(type);
        this.serial(serial);
        this.send_event(send_event);
        this.display(display);
        this.event(event);
        this.window(window);
        this.from_configure(from_configure);
        return this;
    }

    public XUnmapEvent set(XUnmapEvent src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static XUnmapEvent malloc() {
        return XUnmapEvent.wrap(XUnmapEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XUnmapEvent calloc() {
        return XUnmapEvent.wrap(XUnmapEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XUnmapEvent create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return XUnmapEvent.wrap(XUnmapEvent.class, MemoryUtil.memAddress(container), container);
    }

    public static XUnmapEvent create(long address) {
        return XUnmapEvent.wrap(XUnmapEvent.class, address);
    }

    @Nullable
    public static XUnmapEvent createSafe(long address) {
        return address == 0L ? null : XUnmapEvent.wrap(XUnmapEvent.class, address);
    }

    public static Buffer malloc(int capacity) {
        return XUnmapEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XUnmapEvent.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return XUnmapEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = XUnmapEvent.__create(capacity, SIZEOF);
        return XUnmapEvent.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return XUnmapEvent.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : XUnmapEvent.wrap(Buffer.class, address, capacity);
    }

    public static XUnmapEvent mallocStack() {
        return XUnmapEvent.mallocStack(MemoryStack.stackGet());
    }

    public static XUnmapEvent callocStack() {
        return XUnmapEvent.callocStack(MemoryStack.stackGet());
    }

    public static XUnmapEvent mallocStack(MemoryStack stack) {
        return XUnmapEvent.wrap(XUnmapEvent.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XUnmapEvent callocStack(MemoryStack stack) {
        return XUnmapEvent.wrap(XUnmapEvent.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return XUnmapEvent.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return XUnmapEvent.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return XUnmapEvent.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return XUnmapEvent.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
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

    public static int nfrom_configure(long struct) {
        return UNSAFE.getInt(null, struct + (long)FROM_CONFIGURE);
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

    public static void nfrom_configure(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)FROM_CONFIGURE, value);
    }

    public static void validate(long struct) {
        Checks.check(MemoryUtil.memGetAddress(struct + (long)DISPLAY));
    }

    public static void validate(long array, int count) {
        for (int i = 0; i < count; ++i) {
            XUnmapEvent.validate(array + Integer.toUnsignedLong(i) * (long)SIZEOF);
        }
    }

    static {
        Struct.Layout layout = XUnmapEvent.__struct(XUnmapEvent.__member(4), XUnmapEvent.__member(CLONG_SIZE), XUnmapEvent.__member(4), XUnmapEvent.__member(POINTER_SIZE), XUnmapEvent.__member(CLONG_SIZE), XUnmapEvent.__member(CLONG_SIZE), XUnmapEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        EVENT = layout.offsetof(4);
        WINDOW = layout.offsetof(5);
        FROM_CONFIGURE = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<XUnmapEvent, Buffer>
    implements NativeResource {
        private static final XUnmapEvent ELEMENT_FACTORY = XUnmapEvent.create(-1L);

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
        protected XUnmapEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XUnmapEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XUnmapEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XUnmapEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XUnmapEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long event() {
            return XUnmapEvent.nevent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XUnmapEvent.nwindow(this.address());
        }

        public int from_configure() {
            return XUnmapEvent.nfrom_configure(this.address());
        }

        public Buffer type(int value) {
            XUnmapEvent.ntype(this.address(), value);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long value) {
            XUnmapEvent.nserial(this.address(), value);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean value) {
            XUnmapEvent.nsend_event(this.address(), value ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long value) {
            XUnmapEvent.ndisplay(this.address(), value);
            return this;
        }

        public Buffer event(@NativeType(value="Window") long value) {
            XUnmapEvent.nevent(this.address(), value);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long value) {
            XUnmapEvent.nwindow(this.address(), value);
            return this;
        }

        public Buffer from_configure(int value) {
            XUnmapEvent.nfrom_configure(this.address(), value);
            return this;
        }
    }
}

