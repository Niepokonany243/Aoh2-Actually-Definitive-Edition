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

public class XCrossingEvent
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int ROOT;
    public static final int SUBWINDOW;
    public static final int TIME;
    public static final int X;
    public static final int Y;
    public static final int X_ROOT;
    public static final int Y_ROOT;
    public static final int MODE;
    public static final int DETAIL;
    public static final int SAME_SCREEN;
    public static final int FOCUS;
    public static final int STATE;

    public XCrossingEvent(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), XCrossingEvent.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XCrossingEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XCrossingEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XCrossingEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XCrossingEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XCrossingEvent.nwindow(this.address());
    }

    @NativeType(value="Window")
    public long root() {
        return XCrossingEvent.nroot(this.address());
    }

    @NativeType(value="Window")
    public long subwindow() {
        return XCrossingEvent.nsubwindow(this.address());
    }

    @NativeType(value="Time")
    public long time() {
        return XCrossingEvent.ntime(this.address());
    }

    public int x() {
        return XCrossingEvent.nx(this.address());
    }

    public int y() {
        return XCrossingEvent.ny(this.address());
    }

    public int x_root() {
        return XCrossingEvent.nx_root(this.address());
    }

    public int y_root() {
        return XCrossingEvent.ny_root(this.address());
    }

    public int mode() {
        return XCrossingEvent.nmode(this.address());
    }

    public int detail() {
        return XCrossingEvent.ndetail(this.address());
    }

    public int same_screen() {
        return XCrossingEvent.nsame_screen(this.address());
    }

    public int focus() {
        return XCrossingEvent.nfocus(this.address());
    }

    @NativeType(value="unsigned int")
    public int state() {
        return XCrossingEvent.nstate(this.address());
    }

    public XCrossingEvent type(int value) {
        XCrossingEvent.ntype(this.address(), value);
        return this;
    }

    public XCrossingEvent serial(@NativeType(value="unsigned long") long value) {
        XCrossingEvent.nserial(this.address(), value);
        return this;
    }

    public XCrossingEvent send_event(@NativeType(value="Bool") boolean value) {
        XCrossingEvent.nsend_event(this.address(), value ? 1 : 0);
        return this;
    }

    public XCrossingEvent display(@NativeType(value="Display *") long value) {
        XCrossingEvent.ndisplay(this.address(), value);
        return this;
    }

    public XCrossingEvent window(@NativeType(value="Window") long value) {
        XCrossingEvent.nwindow(this.address(), value);
        return this;
    }

    public XCrossingEvent root(@NativeType(value="Window") long value) {
        XCrossingEvent.nroot(this.address(), value);
        return this;
    }

    public XCrossingEvent subwindow(@NativeType(value="Window") long value) {
        XCrossingEvent.nsubwindow(this.address(), value);
        return this;
    }

    public XCrossingEvent time(@NativeType(value="Time") long value) {
        XCrossingEvent.ntime(this.address(), value);
        return this;
    }

    public XCrossingEvent x(int value) {
        XCrossingEvent.nx(this.address(), value);
        return this;
    }

    public XCrossingEvent y(int value) {
        XCrossingEvent.ny(this.address(), value);
        return this;
    }

    public XCrossingEvent x_root(int value) {
        XCrossingEvent.nx_root(this.address(), value);
        return this;
    }

    public XCrossingEvent y_root(int value) {
        XCrossingEvent.ny_root(this.address(), value);
        return this;
    }

    public XCrossingEvent mode(int value) {
        XCrossingEvent.nmode(this.address(), value);
        return this;
    }

    public XCrossingEvent detail(int value) {
        XCrossingEvent.ndetail(this.address(), value);
        return this;
    }

    public XCrossingEvent same_screen(int value) {
        XCrossingEvent.nsame_screen(this.address(), value);
        return this;
    }

    public XCrossingEvent focus(int value) {
        XCrossingEvent.nfocus(this.address(), value);
        return this;
    }

    public XCrossingEvent state(@NativeType(value="unsigned int") int value) {
        XCrossingEvent.nstate(this.address(), value);
        return this;
    }

    public XCrossingEvent set(int type, long serial, boolean send_event, long display, long window, long root, long subwindow, long time, int x, int y, int x_root, int y_root, int mode, int detail, int same_screen, int focus, int state) {
        this.type(type);
        this.serial(serial);
        this.send_event(send_event);
        this.display(display);
        this.window(window);
        this.root(root);
        this.subwindow(subwindow);
        this.time(time);
        this.x(x);
        this.y(y);
        this.x_root(x_root);
        this.y_root(y_root);
        this.mode(mode);
        this.detail(detail);
        this.same_screen(same_screen);
        this.focus(focus);
        this.state(state);
        return this;
    }

    public XCrossingEvent set(XCrossingEvent src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static XCrossingEvent malloc() {
        return XCrossingEvent.wrap(XCrossingEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XCrossingEvent calloc() {
        return XCrossingEvent.wrap(XCrossingEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XCrossingEvent create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return XCrossingEvent.wrap(XCrossingEvent.class, MemoryUtil.memAddress(container), container);
    }

    public static XCrossingEvent create(long address) {
        return XCrossingEvent.wrap(XCrossingEvent.class, address);
    }

    @Nullable
    public static XCrossingEvent createSafe(long address) {
        return address == 0L ? null : XCrossingEvent.wrap(XCrossingEvent.class, address);
    }

    public static Buffer malloc(int capacity) {
        return XCrossingEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XCrossingEvent.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return XCrossingEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = XCrossingEvent.__create(capacity, SIZEOF);
        return XCrossingEvent.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return XCrossingEvent.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : XCrossingEvent.wrap(Buffer.class, address, capacity);
    }

    public static XCrossingEvent mallocStack() {
        return XCrossingEvent.mallocStack(MemoryStack.stackGet());
    }

    public static XCrossingEvent callocStack() {
        return XCrossingEvent.callocStack(MemoryStack.stackGet());
    }

    public static XCrossingEvent mallocStack(MemoryStack stack) {
        return XCrossingEvent.wrap(XCrossingEvent.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XCrossingEvent callocStack(MemoryStack stack) {
        return XCrossingEvent.wrap(XCrossingEvent.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return XCrossingEvent.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return XCrossingEvent.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return XCrossingEvent.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return XCrossingEvent.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
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

    public static long nroot(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)ROOT);
    }

    public static long nsubwindow(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)SUBWINDOW);
    }

    public static long ntime(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)TIME);
    }

    public static int nx(long struct) {
        return UNSAFE.getInt(null, struct + (long)X);
    }

    public static int ny(long struct) {
        return UNSAFE.getInt(null, struct + (long)Y);
    }

    public static int nx_root(long struct) {
        return UNSAFE.getInt(null, struct + (long)X_ROOT);
    }

    public static int ny_root(long struct) {
        return UNSAFE.getInt(null, struct + (long)Y_ROOT);
    }

    public static int nmode(long struct) {
        return UNSAFE.getInt(null, struct + (long)MODE);
    }

    public static int ndetail(long struct) {
        return UNSAFE.getInt(null, struct + (long)DETAIL);
    }

    public static int nsame_screen(long struct) {
        return UNSAFE.getInt(null, struct + (long)SAME_SCREEN);
    }

    public static int nfocus(long struct) {
        return UNSAFE.getInt(null, struct + (long)FOCUS);
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

    public static void nroot(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)ROOT, value);
    }

    public static void nsubwindow(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)SUBWINDOW, value);
    }

    public static void ntime(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)TIME, value);
    }

    public static void nx(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)X, value);
    }

    public static void ny(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)Y, value);
    }

    public static void nx_root(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)X_ROOT, value);
    }

    public static void ny_root(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)Y_ROOT, value);
    }

    public static void nmode(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)MODE, value);
    }

    public static void ndetail(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)DETAIL, value);
    }

    public static void nsame_screen(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)SAME_SCREEN, value);
    }

    public static void nfocus(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)FOCUS, value);
    }

    public static void nstate(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)STATE, value);
    }

    public static void validate(long struct) {
        Checks.check(MemoryUtil.memGetAddress(struct + (long)DISPLAY));
    }

    public static void validate(long array, int count) {
        for (int i = 0; i < count; ++i) {
            XCrossingEvent.validate(array + Integer.toUnsignedLong(i) * (long)SIZEOF);
        }
    }

    static {
        Struct.Layout layout = XCrossingEvent.__struct(XCrossingEvent.__member(4), XCrossingEvent.__member(CLONG_SIZE), XCrossingEvent.__member(4), XCrossingEvent.__member(POINTER_SIZE), XCrossingEvent.__member(CLONG_SIZE), XCrossingEvent.__member(CLONG_SIZE), XCrossingEvent.__member(CLONG_SIZE), XCrossingEvent.__member(CLONG_SIZE), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        ROOT = layout.offsetof(5);
        SUBWINDOW = layout.offsetof(6);
        TIME = layout.offsetof(7);
        X = layout.offsetof(8);
        Y = layout.offsetof(9);
        X_ROOT = layout.offsetof(10);
        Y_ROOT = layout.offsetof(11);
        MODE = layout.offsetof(12);
        DETAIL = layout.offsetof(13);
        SAME_SCREEN = layout.offsetof(14);
        FOCUS = layout.offsetof(15);
        STATE = layout.offsetof(16);
    }

    public static class Buffer
    extends StructBuffer<XCrossingEvent, Buffer>
    implements NativeResource {
        private static final XCrossingEvent ELEMENT_FACTORY = XCrossingEvent.create(-1L);

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
        protected XCrossingEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XCrossingEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XCrossingEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XCrossingEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XCrossingEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XCrossingEvent.nwindow(this.address());
        }

        @NativeType(value="Window")
        public long root() {
            return XCrossingEvent.nroot(this.address());
        }

        @NativeType(value="Window")
        public long subwindow() {
            return XCrossingEvent.nsubwindow(this.address());
        }

        @NativeType(value="Time")
        public long time() {
            return XCrossingEvent.ntime(this.address());
        }

        public int x() {
            return XCrossingEvent.nx(this.address());
        }

        public int y() {
            return XCrossingEvent.ny(this.address());
        }

        public int x_root() {
            return XCrossingEvent.nx_root(this.address());
        }

        public int y_root() {
            return XCrossingEvent.ny_root(this.address());
        }

        public int mode() {
            return XCrossingEvent.nmode(this.address());
        }

        public int detail() {
            return XCrossingEvent.ndetail(this.address());
        }

        public int same_screen() {
            return XCrossingEvent.nsame_screen(this.address());
        }

        public int focus() {
            return XCrossingEvent.nfocus(this.address());
        }

        @NativeType(value="unsigned int")
        public int state() {
            return XCrossingEvent.nstate(this.address());
        }

        public Buffer type(int value) {
            XCrossingEvent.ntype(this.address(), value);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long value) {
            XCrossingEvent.nserial(this.address(), value);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean value) {
            XCrossingEvent.nsend_event(this.address(), value ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long value) {
            XCrossingEvent.ndisplay(this.address(), value);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long value) {
            XCrossingEvent.nwindow(this.address(), value);
            return this;
        }

        public Buffer root(@NativeType(value="Window") long value) {
            XCrossingEvent.nroot(this.address(), value);
            return this;
        }

        public Buffer subwindow(@NativeType(value="Window") long value) {
            XCrossingEvent.nsubwindow(this.address(), value);
            return this;
        }

        public Buffer time(@NativeType(value="Time") long value) {
            XCrossingEvent.ntime(this.address(), value);
            return this;
        }

        public Buffer x(int value) {
            XCrossingEvent.nx(this.address(), value);
            return this;
        }

        public Buffer y(int value) {
            XCrossingEvent.ny(this.address(), value);
            return this;
        }

        public Buffer x_root(int value) {
            XCrossingEvent.nx_root(this.address(), value);
            return this;
        }

        public Buffer y_root(int value) {
            XCrossingEvent.ny_root(this.address(), value);
            return this;
        }

        public Buffer mode(int value) {
            XCrossingEvent.nmode(this.address(), value);
            return this;
        }

        public Buffer detail(int value) {
            XCrossingEvent.ndetail(this.address(), value);
            return this;
        }

        public Buffer same_screen(int value) {
            XCrossingEvent.nsame_screen(this.address(), value);
            return this;
        }

        public Buffer focus(int value) {
            XCrossingEvent.nfocus(this.address(), value);
            return this;
        }

        public Buffer state(@NativeType(value="unsigned int") int value) {
            XCrossingEvent.nstate(this.address(), value);
            return this;
        }
    }
}

