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

public class XErrorEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int DISPLAY;
    public static final int RESOURCEID;
    public static final int SERIAL;
    public static final int ERROR_CODE;
    public static final int REQUEST_CODE;
    public static final int MINOR_CODE;

    public XErrorEvent(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), XErrorEvent.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XErrorEvent.ntype(this.address());
    }

    @NativeType(value="Display *")
    public long display() {
        return XErrorEvent.ndisplay(this.address());
    }

    @NativeType(value="XID")
    public long resourceid() {
        return XErrorEvent.nresourceid(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XErrorEvent.nserial(this.address());
    }

    @NativeType(value="unsigned char")
    public byte error_code() {
        return XErrorEvent.nerror_code(this.address());
    }

    @NativeType(value="unsigned char")
    public byte request_code() {
        return XErrorEvent.nrequest_code(this.address());
    }

    @NativeType(value="unsigned char")
    public byte minor_code() {
        return XErrorEvent.nminor_code(this.address());
    }

    public XErrorEvent type(int value) {
        XErrorEvent.ntype(this.address(), value);
        return this;
    }

    public XErrorEvent display(@NativeType(value="Display *") long value) {
        XErrorEvent.ndisplay(this.address(), value);
        return this;
    }

    public XErrorEvent resourceid(@NativeType(value="XID") long value) {
        XErrorEvent.nresourceid(this.address(), value);
        return this;
    }

    public XErrorEvent serial(@NativeType(value="unsigned long") long value) {
        XErrorEvent.nserial(this.address(), value);
        return this;
    }

    public XErrorEvent error_code(@NativeType(value="unsigned char") byte value) {
        XErrorEvent.nerror_code(this.address(), value);
        return this;
    }

    public XErrorEvent request_code(@NativeType(value="unsigned char") byte value) {
        XErrorEvent.nrequest_code(this.address(), value);
        return this;
    }

    public XErrorEvent minor_code(@NativeType(value="unsigned char") byte value) {
        XErrorEvent.nminor_code(this.address(), value);
        return this;
    }

    public XErrorEvent set(int type, long display, long resourceid, long serial, byte error_code, byte request_code, byte minor_code) {
        this.type(type);
        this.display(display);
        this.resourceid(resourceid);
        this.serial(serial);
        this.error_code(error_code);
        this.request_code(request_code);
        this.minor_code(minor_code);
        return this;
    }

    public XErrorEvent set(XErrorEvent src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static XErrorEvent malloc() {
        return XErrorEvent.wrap(XErrorEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XErrorEvent calloc() {
        return XErrorEvent.wrap(XErrorEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XErrorEvent create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return XErrorEvent.wrap(XErrorEvent.class, MemoryUtil.memAddress(container), container);
    }

    public static XErrorEvent create(long address) {
        return XErrorEvent.wrap(XErrorEvent.class, address);
    }

    @Nullable
    public static XErrorEvent createSafe(long address) {
        return address == 0L ? null : XErrorEvent.wrap(XErrorEvent.class, address);
    }

    public static Buffer malloc(int capacity) {
        return XErrorEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XErrorEvent.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return XErrorEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = XErrorEvent.__create(capacity, SIZEOF);
        return XErrorEvent.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return XErrorEvent.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : XErrorEvent.wrap(Buffer.class, address, capacity);
    }

    public static XErrorEvent mallocStack() {
        return XErrorEvent.mallocStack(MemoryStack.stackGet());
    }

    public static XErrorEvent callocStack() {
        return XErrorEvent.callocStack(MemoryStack.stackGet());
    }

    public static XErrorEvent mallocStack(MemoryStack stack) {
        return XErrorEvent.wrap(XErrorEvent.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XErrorEvent callocStack(MemoryStack stack) {
        return XErrorEvent.wrap(XErrorEvent.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return XErrorEvent.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return XErrorEvent.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return XErrorEvent.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return XErrorEvent.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    public static int ntype(long struct) {
        return UNSAFE.getInt(null, struct + (long)TYPE);
    }

    public static long ndisplay(long struct) {
        return MemoryUtil.memGetAddress(struct + (long)DISPLAY);
    }

    public static long nresourceid(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)RESOURCEID);
    }

    public static long nserial(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)SERIAL);
    }

    public static byte nerror_code(long struct) {
        return UNSAFE.getByte(null, struct + (long)ERROR_CODE);
    }

    public static byte nrequest_code(long struct) {
        return UNSAFE.getByte(null, struct + (long)REQUEST_CODE);
    }

    public static byte nminor_code(long struct) {
        return UNSAFE.getByte(null, struct + (long)MINOR_CODE);
    }

    public static void ntype(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)TYPE, value);
    }

    public static void ndisplay(long struct, long value) {
        MemoryUtil.memPutAddress(struct + (long)DISPLAY, Checks.check(value));
    }

    public static void nresourceid(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)RESOURCEID, value);
    }

    public static void nserial(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)SERIAL, value);
    }

    public static void nerror_code(long struct, byte value) {
        UNSAFE.putByte(null, struct + (long)ERROR_CODE, value);
    }

    public static void nrequest_code(long struct, byte value) {
        UNSAFE.putByte(null, struct + (long)REQUEST_CODE, value);
    }

    public static void nminor_code(long struct, byte value) {
        UNSAFE.putByte(null, struct + (long)MINOR_CODE, value);
    }

    public static void validate(long struct) {
        Checks.check(MemoryUtil.memGetAddress(struct + (long)DISPLAY));
    }

    public static void validate(long array, int count) {
        for (int i = 0; i < count; ++i) {
            XErrorEvent.validate(array + Integer.toUnsignedLong(i) * (long)SIZEOF);
        }
    }

    static {
        Struct.Layout layout = XErrorEvent.__struct(XErrorEvent.__member(4), XErrorEvent.__member(POINTER_SIZE), XErrorEvent.__member(CLONG_SIZE), XErrorEvent.__member(CLONG_SIZE), XErrorEvent.__member(1), XErrorEvent.__member(1), XErrorEvent.__member(1));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        DISPLAY = layout.offsetof(1);
        RESOURCEID = layout.offsetof(2);
        SERIAL = layout.offsetof(3);
        ERROR_CODE = layout.offsetof(4);
        REQUEST_CODE = layout.offsetof(5);
        MINOR_CODE = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<XErrorEvent, Buffer>
    implements NativeResource {
        private static final XErrorEvent ELEMENT_FACTORY = XErrorEvent.create(-1L);

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
        protected XErrorEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XErrorEvent.ntype(this.address());
        }

        @NativeType(value="Display *")
        public long display() {
            return XErrorEvent.ndisplay(this.address());
        }

        @NativeType(value="XID")
        public long resourceid() {
            return XErrorEvent.nresourceid(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XErrorEvent.nserial(this.address());
        }

        @NativeType(value="unsigned char")
        public byte error_code() {
            return XErrorEvent.nerror_code(this.address());
        }

        @NativeType(value="unsigned char")
        public byte request_code() {
            return XErrorEvent.nrequest_code(this.address());
        }

        @NativeType(value="unsigned char")
        public byte minor_code() {
            return XErrorEvent.nminor_code(this.address());
        }

        public Buffer type(int value) {
            XErrorEvent.ntype(this.address(), value);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long value) {
            XErrorEvent.ndisplay(this.address(), value);
            return this;
        }

        public Buffer resourceid(@NativeType(value="XID") long value) {
            XErrorEvent.nresourceid(this.address(), value);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long value) {
            XErrorEvent.nserial(this.address(), value);
            return this;
        }

        public Buffer error_code(@NativeType(value="unsigned char") byte value) {
            XErrorEvent.nerror_code(this.address(), value);
            return this;
        }

        public Buffer request_code(@NativeType(value="unsigned char") byte value) {
            XErrorEvent.nrequest_code(this.address(), value);
            return this;
        }

        public Buffer minor_code(@NativeType(value="unsigned char") byte value) {
            XErrorEvent.nminor_code(this.address(), value);
            return this;
        }
    }
}

