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

public class XGenericEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int EXTENSION;
    public static final int EVTYPE;

    public XGenericEvent(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), XGenericEvent.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XGenericEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XGenericEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XGenericEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XGenericEvent.ndisplay(this.address());
    }

    public int extension() {
        return XGenericEvent.nextension(this.address());
    }

    public int evtype() {
        return XGenericEvent.nevtype(this.address());
    }

    public XGenericEvent type(int value) {
        XGenericEvent.ntype(this.address(), value);
        return this;
    }

    public XGenericEvent serial(@NativeType(value="unsigned long") long value) {
        XGenericEvent.nserial(this.address(), value);
        return this;
    }

    public XGenericEvent send_event(@NativeType(value="Bool") boolean value) {
        XGenericEvent.nsend_event(this.address(), value ? 1 : 0);
        return this;
    }

    public XGenericEvent display(@NativeType(value="Display *") long value) {
        XGenericEvent.ndisplay(this.address(), value);
        return this;
    }

    public XGenericEvent extension(int value) {
        XGenericEvent.nextension(this.address(), value);
        return this;
    }

    public XGenericEvent evtype(int value) {
        XGenericEvent.nevtype(this.address(), value);
        return this;
    }

    public XGenericEvent set(int type, long serial, boolean send_event, long display, int extension, int evtype) {
        this.type(type);
        this.serial(serial);
        this.send_event(send_event);
        this.display(display);
        this.extension(extension);
        this.evtype(evtype);
        return this;
    }

    public XGenericEvent set(XGenericEvent src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static XGenericEvent malloc() {
        return XGenericEvent.wrap(XGenericEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XGenericEvent calloc() {
        return XGenericEvent.wrap(XGenericEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XGenericEvent create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return XGenericEvent.wrap(XGenericEvent.class, MemoryUtil.memAddress(container), container);
    }

    public static XGenericEvent create(long address) {
        return XGenericEvent.wrap(XGenericEvent.class, address);
    }

    @Nullable
    public static XGenericEvent createSafe(long address) {
        return address == 0L ? null : XGenericEvent.wrap(XGenericEvent.class, address);
    }

    public static Buffer malloc(int capacity) {
        return XGenericEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XGenericEvent.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return XGenericEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = XGenericEvent.__create(capacity, SIZEOF);
        return XGenericEvent.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return XGenericEvent.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : XGenericEvent.wrap(Buffer.class, address, capacity);
    }

    public static XGenericEvent mallocStack() {
        return XGenericEvent.mallocStack(MemoryStack.stackGet());
    }

    public static XGenericEvent callocStack() {
        return XGenericEvent.callocStack(MemoryStack.stackGet());
    }

    public static XGenericEvent mallocStack(MemoryStack stack) {
        return XGenericEvent.wrap(XGenericEvent.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XGenericEvent callocStack(MemoryStack stack) {
        return XGenericEvent.wrap(XGenericEvent.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return XGenericEvent.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return XGenericEvent.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return XGenericEvent.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return XGenericEvent.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
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

    public static int nextension(long struct) {
        return UNSAFE.getInt(null, struct + (long)EXTENSION);
    }

    public static int nevtype(long struct) {
        return UNSAFE.getInt(null, struct + (long)EVTYPE);
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

    public static void nextension(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)EXTENSION, value);
    }

    public static void nevtype(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)EVTYPE, value);
    }

    public static void validate(long struct) {
        Checks.check(MemoryUtil.memGetAddress(struct + (long)DISPLAY));
    }

    public static void validate(long array, int count) {
        for (int i = 0; i < count; ++i) {
            XGenericEvent.validate(array + Integer.toUnsignedLong(i) * (long)SIZEOF);
        }
    }

    static {
        Struct.Layout layout = XGenericEvent.__struct(XGenericEvent.__member(4), XGenericEvent.__member(CLONG_SIZE), XGenericEvent.__member(4), XGenericEvent.__member(POINTER_SIZE), XGenericEvent.__member(4), XGenericEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        EXTENSION = layout.offsetof(4);
        EVTYPE = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<XGenericEvent, Buffer>
    implements NativeResource {
        private static final XGenericEvent ELEMENT_FACTORY = XGenericEvent.create(-1L);

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
        protected XGenericEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XGenericEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XGenericEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XGenericEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XGenericEvent.ndisplay(this.address());
        }

        public int extension() {
            return XGenericEvent.nextension(this.address());
        }

        public int evtype() {
            return XGenericEvent.nevtype(this.address());
        }

        public Buffer type(int value) {
            XGenericEvent.ntype(this.address(), value);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long value) {
            XGenericEvent.nserial(this.address(), value);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean value) {
            XGenericEvent.nsend_event(this.address(), value ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long value) {
            XGenericEvent.ndisplay(this.address(), value);
            return this;
        }

        public Buffer extension(int value) {
            XGenericEvent.nextension(this.address(), value);
            return this;
        }

        public Buffer evtype(int value) {
            XGenericEvent.nevtype(this.address(), value);
            return this;
        }
    }
}

