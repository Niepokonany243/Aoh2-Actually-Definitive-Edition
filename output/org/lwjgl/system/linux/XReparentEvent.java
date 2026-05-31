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

public class XReparentEvent
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
    public static final int PARENT;
    public static final int X;
    public static final int Y;
    public static final int OVERRIDE_REDIRECT;

    public XReparentEvent(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), XReparentEvent.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XReparentEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XReparentEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XReparentEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XReparentEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long event() {
        return XReparentEvent.nevent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XReparentEvent.nwindow(this.address());
    }

    @NativeType(value="Window")
    public long parent() {
        return XReparentEvent.nparent(this.address());
    }

    public int x() {
        return XReparentEvent.nx(this.address());
    }

    public int y() {
        return XReparentEvent.ny(this.address());
    }

    public int override_redirect() {
        return XReparentEvent.noverride_redirect(this.address());
    }

    public XReparentEvent type(int value) {
        XReparentEvent.ntype(this.address(), value);
        return this;
    }

    public XReparentEvent serial(@NativeType(value="unsigned long") long value) {
        XReparentEvent.nserial(this.address(), value);
        return this;
    }

    public XReparentEvent send_event(@NativeType(value="Bool") boolean value) {
        XReparentEvent.nsend_event(this.address(), value ? 1 : 0);
        return this;
    }

    public XReparentEvent display(@NativeType(value="Display *") long value) {
        XReparentEvent.ndisplay(this.address(), value);
        return this;
    }

    public XReparentEvent event(@NativeType(value="Window") long value) {
        XReparentEvent.nevent(this.address(), value);
        return this;
    }

    public XReparentEvent window(@NativeType(value="Window") long value) {
        XReparentEvent.nwindow(this.address(), value);
        return this;
    }

    public XReparentEvent parent(@NativeType(value="Window") long value) {
        XReparentEvent.nparent(this.address(), value);
        return this;
    }

    public XReparentEvent x(int value) {
        XReparentEvent.nx(this.address(), value);
        return this;
    }

    public XReparentEvent y(int value) {
        XReparentEvent.ny(this.address(), value);
        return this;
    }

    public XReparentEvent override_redirect(int value) {
        XReparentEvent.noverride_redirect(this.address(), value);
        return this;
    }

    public XReparentEvent set(int type, long serial, boolean send_event, long display, long event, long window, long parent, int x, int y, int override_redirect) {
        this.type(type);
        this.serial(serial);
        this.send_event(send_event);
        this.display(display);
        this.event(event);
        this.window(window);
        this.parent(parent);
        this.x(x);
        this.y(y);
        this.override_redirect(override_redirect);
        return this;
    }

    public XReparentEvent set(XReparentEvent src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static XReparentEvent malloc() {
        return XReparentEvent.wrap(XReparentEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XReparentEvent calloc() {
        return XReparentEvent.wrap(XReparentEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XReparentEvent create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return XReparentEvent.wrap(XReparentEvent.class, MemoryUtil.memAddress(container), container);
    }

    public static XReparentEvent create(long address) {
        return XReparentEvent.wrap(XReparentEvent.class, address);
    }

    @Nullable
    public static XReparentEvent createSafe(long address) {
        return address == 0L ? null : XReparentEvent.wrap(XReparentEvent.class, address);
    }

    public static Buffer malloc(int capacity) {
        return XReparentEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XReparentEvent.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return XReparentEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = XReparentEvent.__create(capacity, SIZEOF);
        return XReparentEvent.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return XReparentEvent.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : XReparentEvent.wrap(Buffer.class, address, capacity);
    }

    public static XReparentEvent mallocStack() {
        return XReparentEvent.mallocStack(MemoryStack.stackGet());
    }

    public static XReparentEvent callocStack() {
        return XReparentEvent.callocStack(MemoryStack.stackGet());
    }

    public static XReparentEvent mallocStack(MemoryStack stack) {
        return XReparentEvent.wrap(XReparentEvent.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XReparentEvent callocStack(MemoryStack stack) {
        return XReparentEvent.wrap(XReparentEvent.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return XReparentEvent.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return XReparentEvent.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return XReparentEvent.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return XReparentEvent.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
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

    public static long nparent(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)PARENT);
    }

    public static int nx(long struct) {
        return UNSAFE.getInt(null, struct + (long)X);
    }

    public static int ny(long struct) {
        return UNSAFE.getInt(null, struct + (long)Y);
    }

    public static int noverride_redirect(long struct) {
        return UNSAFE.getInt(null, struct + (long)OVERRIDE_REDIRECT);
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

    public static void nparent(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)PARENT, value);
    }

    public static void nx(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)X, value);
    }

    public static void ny(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)Y, value);
    }

    public static void noverride_redirect(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)OVERRIDE_REDIRECT, value);
    }

    public static void validate(long struct) {
        Checks.check(MemoryUtil.memGetAddress(struct + (long)DISPLAY));
    }

    public static void validate(long array, int count) {
        for (int i = 0; i < count; ++i) {
            XReparentEvent.validate(array + Integer.toUnsignedLong(i) * (long)SIZEOF);
        }
    }

    static {
        Struct.Layout layout = XReparentEvent.__struct(XReparentEvent.__member(4), XReparentEvent.__member(CLONG_SIZE), XReparentEvent.__member(4), XReparentEvent.__member(POINTER_SIZE), XReparentEvent.__member(CLONG_SIZE), XReparentEvent.__member(CLONG_SIZE), XReparentEvent.__member(CLONG_SIZE), XReparentEvent.__member(4), XReparentEvent.__member(4), XReparentEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        EVENT = layout.offsetof(4);
        WINDOW = layout.offsetof(5);
        PARENT = layout.offsetof(6);
        X = layout.offsetof(7);
        Y = layout.offsetof(8);
        OVERRIDE_REDIRECT = layout.offsetof(9);
    }

    public static class Buffer
    extends StructBuffer<XReparentEvent, Buffer>
    implements NativeResource {
        private static final XReparentEvent ELEMENT_FACTORY = XReparentEvent.create(-1L);

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
        protected XReparentEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XReparentEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XReparentEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XReparentEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XReparentEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long event() {
            return XReparentEvent.nevent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XReparentEvent.nwindow(this.address());
        }

        @NativeType(value="Window")
        public long parent() {
            return XReparentEvent.nparent(this.address());
        }

        public int x() {
            return XReparentEvent.nx(this.address());
        }

        public int y() {
            return XReparentEvent.ny(this.address());
        }

        public int override_redirect() {
            return XReparentEvent.noverride_redirect(this.address());
        }

        public Buffer type(int value) {
            XReparentEvent.ntype(this.address(), value);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long value) {
            XReparentEvent.nserial(this.address(), value);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean value) {
            XReparentEvent.nsend_event(this.address(), value ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long value) {
            XReparentEvent.ndisplay(this.address(), value);
            return this;
        }

        public Buffer event(@NativeType(value="Window") long value) {
            XReparentEvent.nevent(this.address(), value);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long value) {
            XReparentEvent.nwindow(this.address(), value);
            return this;
        }

        public Buffer parent(@NativeType(value="Window") long value) {
            XReparentEvent.nparent(this.address(), value);
            return this;
        }

        public Buffer x(int value) {
            XReparentEvent.nx(this.address(), value);
            return this;
        }

        public Buffer y(int value) {
            XReparentEvent.ny(this.address(), value);
            return this;
        }

        public Buffer override_redirect(int value) {
            XReparentEvent.noverride_redirect(this.address(), value);
            return this;
        }
    }
}

