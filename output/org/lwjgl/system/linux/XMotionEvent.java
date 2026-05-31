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

public class XMotionEvent
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
    public static final int STATE;
    public static final int IS_HINT;
    public static final int SAME_SCREEN;

    public XMotionEvent(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), XMotionEvent.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XMotionEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XMotionEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XMotionEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XMotionEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XMotionEvent.nwindow(this.address());
    }

    @NativeType(value="Window")
    public long root() {
        return XMotionEvent.nroot(this.address());
    }

    @NativeType(value="Window")
    public long subwindow() {
        return XMotionEvent.nsubwindow(this.address());
    }

    @NativeType(value="Time")
    public long time() {
        return XMotionEvent.ntime(this.address());
    }

    public int x() {
        return XMotionEvent.nx(this.address());
    }

    public int y() {
        return XMotionEvent.ny(this.address());
    }

    public int x_root() {
        return XMotionEvent.nx_root(this.address());
    }

    public int y_root() {
        return XMotionEvent.ny_root(this.address());
    }

    @NativeType(value="unsigned int")
    public int state() {
        return XMotionEvent.nstate(this.address());
    }

    @NativeType(value="char")
    public byte is_hint() {
        return XMotionEvent.nis_hint(this.address());
    }

    @NativeType(value="Bool")
    public boolean same_screen() {
        return XMotionEvent.nsame_screen(this.address()) != 0;
    }

    public XMotionEvent type(int value) {
        XMotionEvent.ntype(this.address(), value);
        return this;
    }

    public XMotionEvent serial(@NativeType(value="unsigned long") long value) {
        XMotionEvent.nserial(this.address(), value);
        return this;
    }

    public XMotionEvent send_event(@NativeType(value="Bool") boolean value) {
        XMotionEvent.nsend_event(this.address(), value ? 1 : 0);
        return this;
    }

    public XMotionEvent display(@NativeType(value="Display *") long value) {
        XMotionEvent.ndisplay(this.address(), value);
        return this;
    }

    public XMotionEvent window(@NativeType(value="Window") long value) {
        XMotionEvent.nwindow(this.address(), value);
        return this;
    }

    public XMotionEvent root(@NativeType(value="Window") long value) {
        XMotionEvent.nroot(this.address(), value);
        return this;
    }

    public XMotionEvent subwindow(@NativeType(value="Window") long value) {
        XMotionEvent.nsubwindow(this.address(), value);
        return this;
    }

    public XMotionEvent time(@NativeType(value="Time") long value) {
        XMotionEvent.ntime(this.address(), value);
        return this;
    }

    public XMotionEvent x(int value) {
        XMotionEvent.nx(this.address(), value);
        return this;
    }

    public XMotionEvent y(int value) {
        XMotionEvent.ny(this.address(), value);
        return this;
    }

    public XMotionEvent x_root(int value) {
        XMotionEvent.nx_root(this.address(), value);
        return this;
    }

    public XMotionEvent y_root(int value) {
        XMotionEvent.ny_root(this.address(), value);
        return this;
    }

    public XMotionEvent state(@NativeType(value="unsigned int") int value) {
        XMotionEvent.nstate(this.address(), value);
        return this;
    }

    public XMotionEvent is_hint(@NativeType(value="char") byte value) {
        XMotionEvent.nis_hint(this.address(), value);
        return this;
    }

    public XMotionEvent same_screen(@NativeType(value="Bool") boolean value) {
        XMotionEvent.nsame_screen(this.address(), value ? 1 : 0);
        return this;
    }

    public XMotionEvent set(int type, long serial, boolean send_event, long display, long window, long root, long subwindow, long time, int x, int y, int x_root, int y_root, int state, byte is_hint, boolean same_screen) {
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
        this.state(state);
        this.is_hint(is_hint);
        this.same_screen(same_screen);
        return this;
    }

    public XMotionEvent set(XMotionEvent src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static XMotionEvent malloc() {
        return XMotionEvent.wrap(XMotionEvent.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XMotionEvent calloc() {
        return XMotionEvent.wrap(XMotionEvent.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XMotionEvent create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return XMotionEvent.wrap(XMotionEvent.class, MemoryUtil.memAddress(container), container);
    }

    public static XMotionEvent create(long address) {
        return XMotionEvent.wrap(XMotionEvent.class, address);
    }

    @Nullable
    public static XMotionEvent createSafe(long address) {
        return address == 0L ? null : XMotionEvent.wrap(XMotionEvent.class, address);
    }

    public static Buffer malloc(int capacity) {
        return XMotionEvent.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XMotionEvent.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return XMotionEvent.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = XMotionEvent.__create(capacity, SIZEOF);
        return XMotionEvent.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return XMotionEvent.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : XMotionEvent.wrap(Buffer.class, address, capacity);
    }

    public static XMotionEvent mallocStack() {
        return XMotionEvent.mallocStack(MemoryStack.stackGet());
    }

    public static XMotionEvent callocStack() {
        return XMotionEvent.callocStack(MemoryStack.stackGet());
    }

    public static XMotionEvent mallocStack(MemoryStack stack) {
        return XMotionEvent.wrap(XMotionEvent.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XMotionEvent callocStack(MemoryStack stack) {
        return XMotionEvent.wrap(XMotionEvent.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return XMotionEvent.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return XMotionEvent.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return XMotionEvent.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return XMotionEvent.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
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

    public static int nstate(long struct) {
        return UNSAFE.getInt(null, struct + (long)STATE);
    }

    public static byte nis_hint(long struct) {
        return UNSAFE.getByte(null, struct + (long)IS_HINT);
    }

    public static int nsame_screen(long struct) {
        return UNSAFE.getInt(null, struct + (long)SAME_SCREEN);
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

    public static void nstate(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)STATE, value);
    }

    public static void nis_hint(long struct, byte value) {
        UNSAFE.putByte(null, struct + (long)IS_HINT, value);
    }

    public static void nsame_screen(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)SAME_SCREEN, value);
    }

    public static void validate(long struct) {
        Checks.check(MemoryUtil.memGetAddress(struct + (long)DISPLAY));
    }

    public static void validate(long array, int count) {
        for (int i = 0; i < count; ++i) {
            XMotionEvent.validate(array + Integer.toUnsignedLong(i) * (long)SIZEOF);
        }
    }

    static {
        Struct.Layout layout = XMotionEvent.__struct(XMotionEvent.__member(4), XMotionEvent.__member(CLONG_SIZE), XMotionEvent.__member(4), XMotionEvent.__member(POINTER_SIZE), XMotionEvent.__member(CLONG_SIZE), XMotionEvent.__member(CLONG_SIZE), XMotionEvent.__member(CLONG_SIZE), XMotionEvent.__member(CLONG_SIZE), XMotionEvent.__member(4), XMotionEvent.__member(4), XMotionEvent.__member(4), XMotionEvent.__member(4), XMotionEvent.__member(4), XMotionEvent.__member(1), XMotionEvent.__member(4));
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
        STATE = layout.offsetof(12);
        IS_HINT = layout.offsetof(13);
        SAME_SCREEN = layout.offsetof(14);
    }

    public static class Buffer
    extends StructBuffer<XMotionEvent, Buffer>
    implements NativeResource {
        private static final XMotionEvent ELEMENT_FACTORY = XMotionEvent.create(-1L);

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
        protected XMotionEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XMotionEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XMotionEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XMotionEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XMotionEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XMotionEvent.nwindow(this.address());
        }

        @NativeType(value="Window")
        public long root() {
            return XMotionEvent.nroot(this.address());
        }

        @NativeType(value="Window")
        public long subwindow() {
            return XMotionEvent.nsubwindow(this.address());
        }

        @NativeType(value="Time")
        public long time() {
            return XMotionEvent.ntime(this.address());
        }

        public int x() {
            return XMotionEvent.nx(this.address());
        }

        public int y() {
            return XMotionEvent.ny(this.address());
        }

        public int x_root() {
            return XMotionEvent.nx_root(this.address());
        }

        public int y_root() {
            return XMotionEvent.ny_root(this.address());
        }

        @NativeType(value="unsigned int")
        public int state() {
            return XMotionEvent.nstate(this.address());
        }

        @NativeType(value="char")
        public byte is_hint() {
            return XMotionEvent.nis_hint(this.address());
        }

        @NativeType(value="Bool")
        public boolean same_screen() {
            return XMotionEvent.nsame_screen(this.address()) != 0;
        }

        public Buffer type(int value) {
            XMotionEvent.ntype(this.address(), value);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long value) {
            XMotionEvent.nserial(this.address(), value);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean value) {
            XMotionEvent.nsend_event(this.address(), value ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long value) {
            XMotionEvent.ndisplay(this.address(), value);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long value) {
            XMotionEvent.nwindow(this.address(), value);
            return this;
        }

        public Buffer root(@NativeType(value="Window") long value) {
            XMotionEvent.nroot(this.address(), value);
            return this;
        }

        public Buffer subwindow(@NativeType(value="Window") long value) {
            XMotionEvent.nsubwindow(this.address(), value);
            return this;
        }

        public Buffer time(@NativeType(value="Time") long value) {
            XMotionEvent.ntime(this.address(), value);
            return this;
        }

        public Buffer x(int value) {
            XMotionEvent.nx(this.address(), value);
            return this;
        }

        public Buffer y(int value) {
            XMotionEvent.ny(this.address(), value);
            return this;
        }

        public Buffer x_root(int value) {
            XMotionEvent.nx_root(this.address(), value);
            return this;
        }

        public Buffer y_root(int value) {
            XMotionEvent.ny_root(this.address(), value);
            return this;
        }

        public Buffer state(@NativeType(value="unsigned int") int value) {
            XMotionEvent.nstate(this.address(), value);
            return this;
        }

        public Buffer is_hint(@NativeType(value="char") byte value) {
            XMotionEvent.nis_hint(this.address(), value);
            return this;
        }

        public Buffer same_screen(@NativeType(value="Bool") boolean value) {
            XMotionEvent.nsame_screen(this.address(), value ? 1 : 0);
            return this;
        }
    }
}

