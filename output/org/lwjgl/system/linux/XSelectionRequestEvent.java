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

public class XSelectionRequestEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int OWNER;
    public static final int REQUESTOR;
    public static final int SELECTION;
    public static final int TARGET;
    public static final int PROPERTY;
    public static final int TIME;

    public XSelectionRequestEvent(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), XSelectionRequestEvent.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XSelectionRequestEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XSelectionRequestEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XSelectionRequestEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XSelectionRequestEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long owner() {
        return XSelectionRequestEvent.nowner(this.address());
    }

    @NativeType(value="Window")
    public long requestor() {
        return XSelectionRequestEvent.nrequestor(this.address());
    }

    @NativeType(value="Atom")
    public long selection() {
        return XSelectionRequestEvent.nselection(this.address());
    }

    @NativeType(value="Atom")
    public long target() {
        return XSelectionRequestEvent.ntarget(this.address());
    }

    @NativeType(value="Atom")
    public long property() {
        return XSelectionRequestEvent.nproperty(this.address());
    }

    @NativeType(value="Time")
    public long time() {
        return XSelectionRequestEvent.ntime(this.address());
    }

    public XSelectionRequestEvent type(int value) {
        XSelectionRequestEvent.ntype(this.address(), value);
        return this;
    }

    public XSelectionRequestEvent serial(@NativeType(value="unsigned long") long value) {
        XSelectionRequestEvent.nserial(this.address(), value);
        return this;
    }

    public XSelectionRequestEvent send_event(@NativeType(value="Bool") boolean value) {
        XSelectionRequestEvent.nsend_event(this.address(), value ? 1 : 0);
        return this;
    }

    public XSelectionRequestEvent display(@NativeType(value="Display *") long value) {
        XSelectionRequestEvent.ndisplay(this.address(), value);
        return this;
    }

    public XSelectionRequestEvent owner(@NativeType(value="Window") long value) {
        XSelectionRequestEvent.nowner(this.address(), value);
        return this;
    }

    public XSelectionRequestEvent requestor(@NativeType(value="Window") long value) {
        XSelectionRequestEvent.nrequestor(this.address(), value);
        return this;
    }

    public XSelectionRequestEvent selection(@NativeType(value="Atom") long value) {
        XSelectionRequestEvent.nselection(this.address(), value);
        return this;
    }

    public XSelectionRequestEvent target(@NativeType(value="Atom") long value) {
        XSelectionRequestEvent.ntarget(this.address(), value);
        return this;
    }

    public XSelectionRequestEvent property(@NativeType(value="Atom") long value) {
        XSelectionRequestEvent.nproperty(this.address(), value);
        return this;
    }

    public XSelectionRequestEvent time(@NativeType(value="Time") long value) {
        XSelectionRequestEvent.ntime(this.address(), value);
        return this;
    }

    public XSelectionRequestEvent set(int type, long serial, boolean send_event, long display, long owner, long requestor, long selection, long target, long property, long time) {
        this.type(type);
        this.serial(serial);
        this.send_event(send_event);
        this.display(display);
        this.owner(owner);
        this.requestor(requestor);
        this.selection(selection);
        this.target(target);
        this.property(property);
        this.time(time);
        return this;
    }

    public XSelectionRequestEvent set(XSelectionRequestEvent src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static XSelectionRequestEvent malloc() {
        return XSelectionRequestEvent.wrap(XSelectionRequestEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XSelectionRequestEvent calloc() {
        return XSelectionRequestEvent.wrap(XSelectionRequestEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XSelectionRequestEvent create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return XSelectionRequestEvent.wrap(XSelectionRequestEvent.class, MemoryUtil.memAddress(container), container);
    }

    public static XSelectionRequestEvent create(long address) {
        return XSelectionRequestEvent.wrap(XSelectionRequestEvent.class, address);
    }

    @Nullable
    public static XSelectionRequestEvent createSafe(long address) {
        return address == 0L ? null : XSelectionRequestEvent.wrap(XSelectionRequestEvent.class, address);
    }

    public static Buffer malloc(int capacity) {
        return XSelectionRequestEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XSelectionRequestEvent.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return XSelectionRequestEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = XSelectionRequestEvent.__create(capacity, SIZEOF);
        return XSelectionRequestEvent.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return XSelectionRequestEvent.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : XSelectionRequestEvent.wrap(Buffer.class, address, capacity);
    }

    public static XSelectionRequestEvent mallocStack() {
        return XSelectionRequestEvent.mallocStack(MemoryStack.stackGet());
    }

    public static XSelectionRequestEvent callocStack() {
        return XSelectionRequestEvent.callocStack(MemoryStack.stackGet());
    }

    public static XSelectionRequestEvent mallocStack(MemoryStack stack) {
        return XSelectionRequestEvent.wrap(XSelectionRequestEvent.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XSelectionRequestEvent callocStack(MemoryStack stack) {
        return XSelectionRequestEvent.wrap(XSelectionRequestEvent.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return XSelectionRequestEvent.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return XSelectionRequestEvent.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return XSelectionRequestEvent.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return XSelectionRequestEvent.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
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

    public static long nowner(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)OWNER);
    }

    public static long nrequestor(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)REQUESTOR);
    }

    public static long nselection(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)SELECTION);
    }

    public static long ntarget(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)TARGET);
    }

    public static long nproperty(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)PROPERTY);
    }

    public static long ntime(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)TIME);
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

    public static void nowner(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)OWNER, value);
    }

    public static void nrequestor(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)REQUESTOR, value);
    }

    public static void nselection(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)SELECTION, value);
    }

    public static void ntarget(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)TARGET, value);
    }

    public static void nproperty(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)PROPERTY, value);
    }

    public static void ntime(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)TIME, value);
    }

    public static void validate(long struct) {
        Checks.check(MemoryUtil.memGetAddress(struct + (long)DISPLAY));
    }

    public static void validate(long array, int count) {
        for (int i = 0; i < count; ++i) {
            XSelectionRequestEvent.validate(array + Integer.toUnsignedLong(i) * (long)SIZEOF);
        }
    }

    static {
        Struct.Layout layout = XSelectionRequestEvent.__struct(XSelectionRequestEvent.__member(4), XSelectionRequestEvent.__member(CLONG_SIZE), XSelectionRequestEvent.__member(4), XSelectionRequestEvent.__member(POINTER_SIZE), XSelectionRequestEvent.__member(CLONG_SIZE), XSelectionRequestEvent.__member(CLONG_SIZE), XSelectionRequestEvent.__member(CLONG_SIZE), XSelectionRequestEvent.__member(CLONG_SIZE), XSelectionRequestEvent.__member(CLONG_SIZE), XSelectionRequestEvent.__member(CLONG_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        OWNER = layout.offsetof(4);
        REQUESTOR = layout.offsetof(5);
        SELECTION = layout.offsetof(6);
        TARGET = layout.offsetof(7);
        PROPERTY = layout.offsetof(8);
        TIME = layout.offsetof(9);
    }

    public static class Buffer
    extends StructBuffer<XSelectionRequestEvent, Buffer>
    implements NativeResource {
        private static final XSelectionRequestEvent ELEMENT_FACTORY = XSelectionRequestEvent.create(-1L);

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
        protected XSelectionRequestEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XSelectionRequestEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XSelectionRequestEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XSelectionRequestEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XSelectionRequestEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long owner() {
            return XSelectionRequestEvent.nowner(this.address());
        }

        @NativeType(value="Window")
        public long requestor() {
            return XSelectionRequestEvent.nrequestor(this.address());
        }

        @NativeType(value="Atom")
        public long selection() {
            return XSelectionRequestEvent.nselection(this.address());
        }

        @NativeType(value="Atom")
        public long target() {
            return XSelectionRequestEvent.ntarget(this.address());
        }

        @NativeType(value="Atom")
        public long property() {
            return XSelectionRequestEvent.nproperty(this.address());
        }

        @NativeType(value="Time")
        public long time() {
            return XSelectionRequestEvent.ntime(this.address());
        }

        public Buffer type(int value) {
            XSelectionRequestEvent.ntype(this.address(), value);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long value) {
            XSelectionRequestEvent.nserial(this.address(), value);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean value) {
            XSelectionRequestEvent.nsend_event(this.address(), value ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long value) {
            XSelectionRequestEvent.ndisplay(this.address(), value);
            return this;
        }

        public Buffer owner(@NativeType(value="Window") long value) {
            XSelectionRequestEvent.nowner(this.address(), value);
            return this;
        }

        public Buffer requestor(@NativeType(value="Window") long value) {
            XSelectionRequestEvent.nrequestor(this.address(), value);
            return this;
        }

        public Buffer selection(@NativeType(value="Atom") long value) {
            XSelectionRequestEvent.nselection(this.address(), value);
            return this;
        }

        public Buffer target(@NativeType(value="Atom") long value) {
            XSelectionRequestEvent.ntarget(this.address(), value);
            return this;
        }

        public Buffer property(@NativeType(value="Atom") long value) {
            XSelectionRequestEvent.nproperty(this.address(), value);
            return this;
        }

        public Buffer time(@NativeType(value="Time") long value) {
            XSelectionRequestEvent.ntime(this.address(), value);
            return this;
        }
    }
}

