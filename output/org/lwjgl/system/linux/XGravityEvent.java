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

public class XGravityEvent
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
    public static final int X;
    public static final int Y;

    public XGravityEvent(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), XGravityEvent.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XGravityEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XGravityEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XGravityEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XGravityEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long event() {
        return XGravityEvent.nevent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XGravityEvent.nwindow(this.address());
    }

    public int x() {
        return XGravityEvent.nx(this.address());
    }

    public int y() {
        return XGravityEvent.ny(this.address());
    }

    public XGravityEvent type(int value) {
        XGravityEvent.ntype(this.address(), value);
        return this;
    }

    public XGravityEvent serial(@NativeType(value="unsigned long") long value) {
        XGravityEvent.nserial(this.address(), value);
        return this;
    }

    public XGravityEvent send_event(@NativeType(value="Bool") boolean value) {
        XGravityEvent.nsend_event(this.address(), value ? 1 : 0);
        return this;
    }

    public XGravityEvent display(@NativeType(value="Display *") long value) {
        XGravityEvent.ndisplay(this.address(), value);
        return this;
    }

    public XGravityEvent event(@NativeType(value="Window") long value) {
        XGravityEvent.nevent(this.address(), value);
        return this;
    }

    public XGravityEvent window(@NativeType(value="Window") long value) {
        XGravityEvent.nwindow(this.address(), value);
        return this;
    }

    public XGravityEvent x(int value) {
        XGravityEvent.nx(this.address(), value);
        return this;
    }

    public XGravityEvent y(int value) {
        XGravityEvent.ny(this.address(), value);
        return this;
    }

    public XGravityEvent set(int type, long serial, boolean send_event, long display, long event, long window, int x, int y) {
        this.type(type);
        this.serial(serial);
        this.send_event(send_event);
        this.display(display);
        this.event(event);
        this.window(window);
        this.x(x);
        this.y(y);
        return this;
    }

    public XGravityEvent set(XGravityEvent src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static XGravityEvent malloc() {
        return XGravityEvent.wrap(XGravityEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XGravityEvent calloc() {
        return XGravityEvent.wrap(XGravityEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XGravityEvent create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return XGravityEvent.wrap(XGravityEvent.class, MemoryUtil.memAddress(container), container);
    }

    public static XGravityEvent create(long address) {
        return XGravityEvent.wrap(XGravityEvent.class, address);
    }

    @Nullable
    public static XGravityEvent createSafe(long address) {
        return address == 0L ? null : XGravityEvent.wrap(XGravityEvent.class, address);
    }

    public static Buffer malloc(int capacity) {
        return XGravityEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XGravityEvent.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return XGravityEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = XGravityEvent.__create(capacity, SIZEOF);
        return XGravityEvent.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return XGravityEvent.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : XGravityEvent.wrap(Buffer.class, address, capacity);
    }

    public static XGravityEvent mallocStack() {
        return XGravityEvent.mallocStack(MemoryStack.stackGet());
    }

    public static XGravityEvent callocStack() {
        return XGravityEvent.callocStack(MemoryStack.stackGet());
    }

    public static XGravityEvent mallocStack(MemoryStack stack) {
        return XGravityEvent.wrap(XGravityEvent.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XGravityEvent callocStack(MemoryStack stack) {
        return XGravityEvent.wrap(XGravityEvent.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return XGravityEvent.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return XGravityEvent.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return XGravityEvent.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return XGravityEvent.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
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

    public static int nx(long struct) {
        return UNSAFE.getInt(null, struct + (long)X);
    }

    public static int ny(long struct) {
        return UNSAFE.getInt(null, struct + (long)Y);
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

    public static void nx(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)X, value);
    }

    public static void ny(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)Y, value);
    }

    public static void validate(long struct) {
        Checks.check(MemoryUtil.memGetAddress(struct + (long)DISPLAY));
    }

    public static void validate(long array, int count) {
        for (int i = 0; i < count; ++i) {
            XGravityEvent.validate(array + Integer.toUnsignedLong(i) * (long)SIZEOF);
        }
    }

    static {
        Struct.Layout layout = XGravityEvent.__struct(XGravityEvent.__member(4), XGravityEvent.__member(CLONG_SIZE), XGravityEvent.__member(4), XGravityEvent.__member(POINTER_SIZE), XGravityEvent.__member(CLONG_SIZE), XGravityEvent.__member(CLONG_SIZE), XGravityEvent.__member(4), XGravityEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        EVENT = layout.offsetof(4);
        WINDOW = layout.offsetof(5);
        X = layout.offsetof(6);
        Y = layout.offsetof(7);
    }

    public static class Buffer
    extends StructBuffer<XGravityEvent, Buffer>
    implements NativeResource {
        private static final XGravityEvent ELEMENT_FACTORY = XGravityEvent.create(-1L);

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
        protected XGravityEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XGravityEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XGravityEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XGravityEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XGravityEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long event() {
            return XGravityEvent.nevent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XGravityEvent.nwindow(this.address());
        }

        public int x() {
            return XGravityEvent.nx(this.address());
        }

        public int y() {
            return XGravityEvent.ny(this.address());
        }

        public Buffer type(int value) {
            XGravityEvent.ntype(this.address(), value);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long value) {
            XGravityEvent.nserial(this.address(), value);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean value) {
            XGravityEvent.nsend_event(this.address(), value ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long value) {
            XGravityEvent.ndisplay(this.address(), value);
            return this;
        }

        public Buffer event(@NativeType(value="Window") long value) {
            XGravityEvent.nevent(this.address(), value);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long value) {
            XGravityEvent.nwindow(this.address(), value);
            return this;
        }

        public Buffer x(int value) {
            XGravityEvent.nx(this.address(), value);
            return this;
        }

        public Buffer y(int value) {
            XGravityEvent.ny(this.address(), value);
            return this;
        }
    }
}

