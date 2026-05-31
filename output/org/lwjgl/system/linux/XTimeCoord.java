/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class XTimeCoord
extends Struct {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TIME;
    public static final int X;
    public static final int Y;

    public XTimeCoord(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), XTimeCoord.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="Time")
    public long time() {
        return XTimeCoord.ntime(this.address());
    }

    public short x() {
        return XTimeCoord.nx(this.address());
    }

    public short y() {
        return XTimeCoord.ny(this.address());
    }

    public static XTimeCoord create(long address) {
        return XTimeCoord.wrap(XTimeCoord.class, address);
    }

    @Nullable
    public static XTimeCoord createSafe(long address) {
        return address == 0L ? null : XTimeCoord.wrap(XTimeCoord.class, address);
    }

    public static Buffer create(long address, int capacity) {
        return XTimeCoord.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : XTimeCoord.wrap(Buffer.class, address, capacity);
    }

    public static long ntime(long struct) {
        return MemoryUtil.memGetCLong(struct + (long)TIME);
    }

    public static short nx(long struct) {
        return UNSAFE.getShort(null, struct + (long)X);
    }

    public static short ny(long struct) {
        return UNSAFE.getShort(null, struct + (long)Y);
    }

    static {
        Struct.Layout layout = XTimeCoord.__struct(XTimeCoord.__member(CLONG_SIZE), XTimeCoord.__member(2), XTimeCoord.__member(2));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TIME = layout.offsetof(0);
        X = layout.offsetof(1);
        Y = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<XTimeCoord, Buffer> {
        private static final XTimeCoord ELEMENT_FACTORY = XTimeCoord.create(-1L);

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
        protected XTimeCoord getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="Time")
        public long time() {
            return XTimeCoord.ntime(this.address());
        }

        public short x() {
            return XTimeCoord.nx(this.address());
        }

        public short y() {
            return XTimeCoord.ny(this.address());
        }
    }
}

