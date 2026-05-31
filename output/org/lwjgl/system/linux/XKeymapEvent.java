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

public class XKeymapEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int KEY_VECTOR;

    public XKeymapEvent(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), XKeymapEvent.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XKeymapEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XKeymapEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XKeymapEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XKeymapEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XKeymapEvent.nwindow(this.address());
    }

    @NativeType(value="char[32]")
    public ByteBuffer key_vector() {
        return XKeymapEvent.nkey_vector(this.address());
    }

    @NativeType(value="char")
    public byte key_vector(int index) {
        return XKeymapEvent.nkey_vector(this.address(), index);
    }

    public XKeymapEvent type(int value) {
        XKeymapEvent.ntype(this.address(), value);
        return this;
    }

    public XKeymapEvent serial(@NativeType(value="unsigned long") long value) {
        XKeymapEvent.nserial(this.address(), value);
        return this;
    }

    public XKeymapEvent send_event(@NativeType(value="Bool") boolean value) {
        XKeymapEvent.nsend_event(this.address(), value ? 1 : 0);
        return this;
    }

    public XKeymapEvent display(@NativeType(value="Display *") long value) {
        XKeymapEvent.ndisplay(this.address(), value);
        return this;
    }

    public XKeymapEvent window(@NativeType(value="Window") long value) {
        XKeymapEvent.nwindow(this.address(), value);
        return this;
    }

    public XKeymapEvent key_vector(@NativeType(value="char[32]") ByteBuffer value) {
        XKeymapEvent.nkey_vector(this.address(), value);
        return this;
    }

    public XKeymapEvent key_vector(int index, @NativeType(value="char") byte value) {
        XKeymapEvent.nkey_vector(this.address(), index, value);
        return this;
    }

    public XKeymapEvent set(int type, long serial, boolean send_event, long display, long window, ByteBuffer key_vector) {
        this.type(type);
        this.serial(serial);
        this.send_event(send_event);
        this.display(display);
        this.window(window);
        this.key_vector(key_vector);
        return this;
    }

    public XKeymapEvent set(XKeymapEvent src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static XKeymapEvent malloc() {
        return XKeymapEvent.wrap(XKeymapEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XKeymapEvent calloc() {
        return XKeymapEvent.wrap(XKeymapEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XKeymapEvent create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return XKeymapEvent.wrap(XKeymapEvent.class, MemoryUtil.memAddress(container), container);
    }

    public static XKeymapEvent create(long address) {
        return XKeymapEvent.wrap(XKeymapEvent.class, address);
    }

    @Nullable
    public static XKeymapEvent createSafe(long address) {
        return address == 0L ? null : XKeymapEvent.wrap(XKeymapEvent.class, address);
    }

    public static Buffer malloc(int capacity) {
        return XKeymapEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XKeymapEvent.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return XKeymapEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = XKeymapEvent.__create(capacity, SIZEOF);
        return XKeymapEvent.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return XKeymapEvent.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : XKeymapEvent.wrap(Buffer.class, address, capacity);
    }

    public static XKeymapEvent mallocStack() {
        return XKeymapEvent.mallocStack(MemoryStack.stackGet());
    }

    public static XKeymapEvent callocStack() {
        return XKeymapEvent.callocStack(MemoryStack.stackGet());
    }

    public static XKeymapEvent mallocStack(MemoryStack stack) {
        return XKeymapEvent.wrap(XKeymapEvent.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XKeymapEvent callocStack(MemoryStack stack) {
        return XKeymapEvent.wrap(XKeymapEvent.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return XKeymapEvent.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return XKeymapEvent.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return XKeymapEvent.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return XKeymapEvent.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
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

    public static ByteBuffer nkey_vector(long struct) {
        return MemoryUtil.memByteBuffer(struct + (long)KEY_VECTOR, 32);
    }

    public static byte nkey_vector(long struct, int index) {
        return UNSAFE.getByte(null, struct + (long)KEY_VECTOR + Checks.check(index, 32) * 1L);
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

    public static void nkey_vector(long struct, ByteBuffer value) {
        if (Checks.CHECKS) {
            Checks.checkGT(value, 32);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + (long)KEY_VECTOR, value.remaining() * 1);
    }

    public static void nkey_vector(long struct, int index, byte value) {
        UNSAFE.putByte(null, struct + (long)KEY_VECTOR + Checks.check(index, 32) * 1L, value);
    }

    public static void validate(long struct) {
        Checks.check(MemoryUtil.memGetAddress(struct + (long)DISPLAY));
    }

    public static void validate(long array, int count) {
        for (int i = 0; i < count; ++i) {
            XKeymapEvent.validate(array + Integer.toUnsignedLong(i) * (long)SIZEOF);
        }
    }

    static {
        Struct.Layout layout = XKeymapEvent.__struct(XKeymapEvent.__member(4), XKeymapEvent.__member(CLONG_SIZE), XKeymapEvent.__member(4), XKeymapEvent.__member(POINTER_SIZE), XKeymapEvent.__member(CLONG_SIZE), XKeymapEvent.__array(1, 32));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        KEY_VECTOR = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<XKeymapEvent, Buffer>
    implements NativeResource {
        private static final XKeymapEvent ELEMENT_FACTORY = XKeymapEvent.create(-1L);

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
        protected XKeymapEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XKeymapEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XKeymapEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XKeymapEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XKeymapEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XKeymapEvent.nwindow(this.address());
        }

        @NativeType(value="char[32]")
        public ByteBuffer key_vector() {
            return XKeymapEvent.nkey_vector(this.address());
        }

        @NativeType(value="char")
        public byte key_vector(int index) {
            return XKeymapEvent.nkey_vector(this.address(), index);
        }

        public Buffer type(int value) {
            XKeymapEvent.ntype(this.address(), value);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long value) {
            XKeymapEvent.nserial(this.address(), value);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean value) {
            XKeymapEvent.nsend_event(this.address(), value ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long value) {
            XKeymapEvent.ndisplay(this.address(), value);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long value) {
            XKeymapEvent.nwindow(this.address(), value);
            return this;
        }

        public Buffer key_vector(@NativeType(value="char[32]") ByteBuffer value) {
            XKeymapEvent.nkey_vector(this.address(), value);
            return this;
        }

        public Buffer key_vector(int index, @NativeType(value="char") byte value) {
            XKeymapEvent.nkey_vector(this.address(), index, value);
            return this;
        }
    }
}

