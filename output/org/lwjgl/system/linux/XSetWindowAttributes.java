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
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class XSetWindowAttributes
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int BACKGROUND_PIXMAP;
    public static final int BACKGROUND_PIXEL;
    public static final int BORDER_PIXMAP;
    public static final int BORDER_PIXEL;
    public static final int BIT_GRAVITY;
    public static final int WIN_GRAVITY;
    public static final int BACKING_STORE;
    public static final int BACKING_PLANES;
    public static final int BACKING_PIXEL;
    public static final int SAVE_UNDER;
    public static final int EVENT_MASK;
    public static final int DO_NOT_PROPAGATE_MASK;
    public static final int OVERRIDE_REDIRECT;
    public static final int COLORMAP;
    public static final int CURSOR;

    public XSetWindowAttributes(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), XSetWindowAttributes.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="Pixmap")
    public long background_pixmap() {
        return XSetWindowAttributes.nbackground_pixmap(this.address());
    }

    @NativeType(value="unsigned long")
    public long background_pixel() {
        return XSetWindowAttributes.nbackground_pixel(this.address());
    }

    @NativeType(value="Pixmap")
    public long border_pixmap() {
        return XSetWindowAttributes.nborder_pixmap(this.address());
    }

    @NativeType(value="unsigned long")
    public long border_pixel() {
        return XSetWindowAttributes.nborder_pixel(this.address());
    }

    public int bit_gravity() {
        return XSetWindowAttributes.nbit_gravity(this.address());
    }

    public int win_gravity() {
        return XSetWindowAttributes.nwin_gravity(this.address());
    }

    public int backing_store() {
        return XSetWindowAttributes.nbacking_store(this.address());
    }

    @NativeType(value="unsigned long")
    public long backing_planes() {
        return XSetWindowAttributes.nbacking_planes(this.address());
    }

    @NativeType(value="unsigned long")
    public long backing_pixel() {
        return XSetWindowAttributes.nbacking_pixel(this.address());
    }

    @NativeType(value="Bool")
    public boolean save_under() {
        return XSetWindowAttributes.nsave_under(this.address()) != 0;
    }

    public long event_mask() {
        return XSetWindowAttributes.nevent_mask(this.address());
    }

    public long do_not_propagate_mask() {
        return XSetWindowAttributes.ndo_not_propagate_mask(this.address());
    }

    @NativeType(value="Bool")
    public boolean override_redirect() {
        return XSetWindowAttributes.noverride_redirect(this.address()) != 0;
    }

    @NativeType(value="Colormap")
    public long colormap() {
        return XSetWindowAttributes.ncolormap(this.address());
    }

    @NativeType(value="Cursor")
    public long cursor() {
        return XSetWindowAttributes.ncursor(this.address());
    }

    public XSetWindowAttributes background_pixmap(@NativeType(value="Pixmap") long value) {
        XSetWindowAttributes.nbackground_pixmap(this.address(), value);
        return this;
    }

    public XSetWindowAttributes background_pixel(@NativeType(value="unsigned long") long value) {
        XSetWindowAttributes.nbackground_pixel(this.address(), value);
        return this;
    }

    public XSetWindowAttributes border_pixmap(@NativeType(value="Pixmap") long value) {
        XSetWindowAttributes.nborder_pixmap(this.address(), value);
        return this;
    }

    public XSetWindowAttributes border_pixel(@NativeType(value="unsigned long") long value) {
        XSetWindowAttributes.nborder_pixel(this.address(), value);
        return this;
    }

    public XSetWindowAttributes bit_gravity(int value) {
        XSetWindowAttributes.nbit_gravity(this.address(), value);
        return this;
    }

    public XSetWindowAttributes win_gravity(int value) {
        XSetWindowAttributes.nwin_gravity(this.address(), value);
        return this;
    }

    public XSetWindowAttributes backing_store(int value) {
        XSetWindowAttributes.nbacking_store(this.address(), value);
        return this;
    }

    public XSetWindowAttributes backing_planes(@NativeType(value="unsigned long") long value) {
        XSetWindowAttributes.nbacking_planes(this.address(), value);
        return this;
    }

    public XSetWindowAttributes backing_pixel(@NativeType(value="unsigned long") long value) {
        XSetWindowAttributes.nbacking_pixel(this.address(), value);
        return this;
    }

    public XSetWindowAttributes save_under(@NativeType(value="Bool") boolean value) {
        XSetWindowAttributes.nsave_under(this.address(), value ? 1 : 0);
        return this;
    }

    public XSetWindowAttributes event_mask(long value) {
        XSetWindowAttributes.nevent_mask(this.address(), value);
        return this;
    }

    public XSetWindowAttributes do_not_propagate_mask(long value) {
        XSetWindowAttributes.ndo_not_propagate_mask(this.address(), value);
        return this;
    }

    public XSetWindowAttributes override_redirect(@NativeType(value="Bool") boolean value) {
        XSetWindowAttributes.noverride_redirect(this.address(), value ? 1 : 0);
        return this;
    }

    public XSetWindowAttributes colormap(@NativeType(value="Colormap") long value) {
        XSetWindowAttributes.ncolormap(this.address(), value);
        return this;
    }

    public XSetWindowAttributes cursor(@NativeType(value="Cursor") long value) {
        XSetWindowAttributes.ncursor(this.address(), value);
        return this;
    }

    public XSetWindowAttributes set(long background_pixmap, long background_pixel, long border_pixmap, long border_pixel, int bit_gravity, int win_gravity, int backing_store, long backing_planes, long backing_pixel, boolean save_under, long event_mask, long do_not_propagate_mask, boolean override_redirect, long colormap, long cursor) {
        this.background_pixmap(background_pixmap);
        this.background_pixel(background_pixel);
        this.border_pixmap(border_pixmap);
        this.border_pixel(border_pixel);
        this.bit_gravity(bit_gravity);
        this.win_gravity(win_gravity);
        this.backing_store(backing_store);
        this.backing_planes(backing_planes);
        this.backing_pixel(backing_pixel);
        this.save_under(save_under);
        this.event_mask(event_mask);
        this.do_not_propagate_mask(do_not_propagate_mask);
        this.override_redirect(override_redirect);
        this.colormap(colormap);
        this.cursor(cursor);
        return this;
    }

    public XSetWindowAttributes set(XSetWindowAttributes src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static XSetWindowAttributes malloc() {
        return XSetWindowAttributes.wrap(XSetWindowAttributes.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static XSetWindowAttributes calloc() {
        return XSetWindowAttributes.wrap(XSetWindowAttributes.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static XSetWindowAttributes create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return XSetWindowAttributes.wrap(XSetWindowAttributes.class, MemoryUtil.memAddress(container), container);
    }

    public static XSetWindowAttributes create(long address) {
        return XSetWindowAttributes.wrap(XSetWindowAttributes.class, address);
    }

    @Nullable
    public static XSetWindowAttributes createSafe(long address) {
        return address == 0L ? null : XSetWindowAttributes.wrap(XSetWindowAttributes.class, address);
    }

    public static Buffer malloc(int capacity) {
        return XSetWindowAttributes.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(XSetWindowAttributes.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return XSetWindowAttributes.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = XSetWindowAttributes.__create(capacity, SIZEOF);
        return XSetWindowAttributes.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return XSetWindowAttributes.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : XSetWindowAttributes.wrap(Buffer.class, address, capacity);
    }

    public static XSetWindowAttributes mallocStack() {
        return XSetWindowAttributes.mallocStack(MemoryStack.stackGet());
    }

    public static XSetWindowAttributes callocStack() {
        return XSetWindowAttributes.callocStack(MemoryStack.stackGet());
    }

    public static XSetWindowAttributes mallocStack(MemoryStack stack) {
        return XSetWindowAttributes.wrap(XSetWindowAttributes.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static XSetWindowAttributes callocStack(MemoryStack stack) {
        return XSetWindowAttributes.wrap(XSetWindowAttributes.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return XSetWindowAttributes.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return XSetWindowAttributes.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return XSetWindowAttributes.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return XSetWindowAttributes.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    public static long nbackground_pixmap(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)BACKGROUND_PIXMAP);
    }

    public static long nbackground_pixel(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)BACKGROUND_PIXEL);
    }

    public static long nborder_pixmap(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)BORDER_PIXMAP);
    }

    public static long nborder_pixel(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)BORDER_PIXEL);
    }

    public static int nbit_gravity(long struct) {
        return UNSAFE.getInt(null, struct + (long)BIT_GRAVITY);
    }

    public static int nwin_gravity(long struct) {
        return UNSAFE.getInt(null, struct + (long)WIN_GRAVITY);
    }

    public static int nbacking_store(long struct) {
        return UNSAFE.getInt(null, struct + (long)BACKING_STORE);
    }

    public static long nbacking_planes(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)BACKING_PLANES);
    }

    public static long nbacking_pixel(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)BACKING_PIXEL);
    }

    public static int nsave_under(long struct) {
        return UNSAFE.getInt(null, struct + (long)SAVE_UNDER);
    }

    public static long nevent_mask(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)EVENT_MASK);
    }

    public static long ndo_not_propagate_mask(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)DO_NOT_PROPAGATE_MASK);
    }

    public static int noverride_redirect(long struct) {
        return UNSAFE.getInt(null, struct + (long)OVERRIDE_REDIRECT);
    }

    public static long ncolormap(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)COLORMAP);
    }

    public static long ncursor(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)CURSOR);
    }

    public static void nbackground_pixmap(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)BACKGROUND_PIXMAP, value);
    }

    public static void nbackground_pixel(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)BACKGROUND_PIXEL, value);
    }

    public static void nborder_pixmap(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)BORDER_PIXMAP, value);
    }

    public static void nborder_pixel(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)BORDER_PIXEL, value);
    }

    public static void nbit_gravity(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)BIT_GRAVITY, value);
    }

    public static void nwin_gravity(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)WIN_GRAVITY, value);
    }

    public static void nbacking_store(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)BACKING_STORE, value);
    }

    public static void nbacking_planes(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)BACKING_PLANES, value);
    }

    public static void nbacking_pixel(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)BACKING_PIXEL, value);
    }

    public static void nsave_under(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)SAVE_UNDER, value);
    }

    public static void nevent_mask(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)EVENT_MASK, value);
    }

    public static void ndo_not_propagate_mask(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)DO_NOT_PROPAGATE_MASK, value);
    }

    public static void noverride_redirect(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)OVERRIDE_REDIRECT, value);
    }

    public static void ncolormap(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)COLORMAP, value);
    }

    public static void ncursor(long struct, long value) {
        MemoryUtil.memPutCLong(struct + (long)CURSOR, value);
    }

    static {
        Struct.Layout layout = XSetWindowAttributes.__struct(XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(4), XSetWindowAttributes.__member(4), XSetWindowAttributes.__member(4), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(4), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(4), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        BACKGROUND_PIXMAP = layout.offsetof(0);
        BACKGROUND_PIXEL = layout.offsetof(1);
        BORDER_PIXMAP = layout.offsetof(2);
        BORDER_PIXEL = layout.offsetof(3);
        BIT_GRAVITY = layout.offsetof(4);
        WIN_GRAVITY = layout.offsetof(5);
        BACKING_STORE = layout.offsetof(6);
        BACKING_PLANES = layout.offsetof(7);
        BACKING_PIXEL = layout.offsetof(8);
        SAVE_UNDER = layout.offsetof(9);
        EVENT_MASK = layout.offsetof(10);
        DO_NOT_PROPAGATE_MASK = layout.offsetof(11);
        OVERRIDE_REDIRECT = layout.offsetof(12);
        COLORMAP = layout.offsetof(13);
        CURSOR = layout.offsetof(14);
    }

    public static class Buffer
    extends StructBuffer<XSetWindowAttributes, Buffer>
    implements NativeResource {
        private static final XSetWindowAttributes ELEMENT_FACTORY = XSetWindowAttributes.create(-1L);

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
        protected XSetWindowAttributes getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="Pixmap")
        public long background_pixmap() {
            return XSetWindowAttributes.nbackground_pixmap(this.address());
        }

        @NativeType(value="unsigned long")
        public long background_pixel() {
            return XSetWindowAttributes.nbackground_pixel(this.address());
        }

        @NativeType(value="Pixmap")
        public long border_pixmap() {
            return XSetWindowAttributes.nborder_pixmap(this.address());
        }

        @NativeType(value="unsigned long")
        public long border_pixel() {
            return XSetWindowAttributes.nborder_pixel(this.address());
        }

        public int bit_gravity() {
            return XSetWindowAttributes.nbit_gravity(this.address());
        }

        public int win_gravity() {
            return XSetWindowAttributes.nwin_gravity(this.address());
        }

        public int backing_store() {
            return XSetWindowAttributes.nbacking_store(this.address());
        }

        @NativeType(value="unsigned long")
        public long backing_planes() {
            return XSetWindowAttributes.nbacking_planes(this.address());
        }

        @NativeType(value="unsigned long")
        public long backing_pixel() {
            return XSetWindowAttributes.nbacking_pixel(this.address());
        }

        @NativeType(value="Bool")
        public boolean save_under() {
            return XSetWindowAttributes.nsave_under(this.address()) != 0;
        }

        public long event_mask() {
            return XSetWindowAttributes.nevent_mask(this.address());
        }

        public long do_not_propagate_mask() {
            return XSetWindowAttributes.ndo_not_propagate_mask(this.address());
        }

        @NativeType(value="Bool")
        public boolean override_redirect() {
            return XSetWindowAttributes.noverride_redirect(this.address()) != 0;
        }

        @NativeType(value="Colormap")
        public long colormap() {
            return XSetWindowAttributes.ncolormap(this.address());
        }

        @NativeType(value="Cursor")
        public long cursor() {
            return XSetWindowAttributes.ncursor(this.address());
        }

        public Buffer background_pixmap(@NativeType(value="Pixmap") long value) {
            XSetWindowAttributes.nbackground_pixmap(this.address(), value);
            return this;
        }

        public Buffer background_pixel(@NativeType(value="unsigned long") long value) {
            XSetWindowAttributes.nbackground_pixel(this.address(), value);
            return this;
        }

        public Buffer border_pixmap(@NativeType(value="Pixmap") long value) {
            XSetWindowAttributes.nborder_pixmap(this.address(), value);
            return this;
        }

        public Buffer border_pixel(@NativeType(value="unsigned long") long value) {
            XSetWindowAttributes.nborder_pixel(this.address(), value);
            return this;
        }

        public Buffer bit_gravity(int value) {
            XSetWindowAttributes.nbit_gravity(this.address(), value);
            return this;
        }

        public Buffer win_gravity(int value) {
            XSetWindowAttributes.nwin_gravity(this.address(), value);
            return this;
        }

        public Buffer backing_store(int value) {
            XSetWindowAttributes.nbacking_store(this.address(), value);
            return this;
        }

        public Buffer backing_planes(@NativeType(value="unsigned long") long value) {
            XSetWindowAttributes.nbacking_planes(this.address(), value);
            return this;
        }

        public Buffer backing_pixel(@NativeType(value="unsigned long") long value) {
            XSetWindowAttributes.nbacking_pixel(this.address(), value);
            return this;
        }

        public Buffer save_under(@NativeType(value="Bool") boolean value) {
            XSetWindowAttributes.nsave_under(this.address(), value ? 1 : 0);
            return this;
        }

        public Buffer event_mask(long value) {
            XSetWindowAttributes.nevent_mask(this.address(), value);
            return this;
        }

        public Buffer do_not_propagate_mask(long value) {
            XSetWindowAttributes.ndo_not_propagate_mask(this.address(), value);
            return this;
        }

        public Buffer override_redirect(@NativeType(value="Bool") boolean value) {
            XSetWindowAttributes.noverride_redirect(this.address(), value ? 1 : 0);
            return this;
        }

        public Buffer colormap(@NativeType(value="Colormap") long value) {
            XSetWindowAttributes.ncolormap(this.address(), value);
            return this;
        }

        public Buffer cursor(@NativeType(value="Cursor") long value) {
            XSetWindowAttributes.ncursor(this.address(), value);
            return this;
        }
    }
}

