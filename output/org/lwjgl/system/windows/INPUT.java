/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.windows.HARDWAREINPUT;
import org.lwjgl.system.windows.KEYBDINPUT;
import org.lwjgl.system.windows.MOUSEINPUT;

public class INPUT
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int DUMMYUNIONNAME;
    public static final int DUMMYUNIONNAME_MI;
    public static final int DUMMYUNIONNAME_KI;
    public static final int DUMMYUNIONNAME_HI;

    public INPUT(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), INPUT.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int type() {
        return INPUT.ntype(this.address());
    }

    public MOUSEINPUT DUMMYUNIONNAME_mi() {
        return INPUT.nDUMMYUNIONNAME_mi(this.address());
    }

    public KEYBDINPUT DUMMYUNIONNAME_ki() {
        return INPUT.nDUMMYUNIONNAME_ki(this.address());
    }

    public HARDWAREINPUT DUMMYUNIONNAME_hi() {
        return INPUT.nDUMMYUNIONNAME_hi(this.address());
    }

    public INPUT type(@NativeType(value="DWORD") int value) {
        INPUT.ntype(this.address(), value);
        return this;
    }

    public INPUT DUMMYUNIONNAME_mi(MOUSEINPUT value) {
        INPUT.nDUMMYUNIONNAME_mi(this.address(), value);
        return this;
    }

    public INPUT DUMMYUNIONNAME_mi(Consumer<MOUSEINPUT> consumer) {
        consumer.accept(this.DUMMYUNIONNAME_mi());
        return this;
    }

    public INPUT DUMMYUNIONNAME_ki(KEYBDINPUT value) {
        INPUT.nDUMMYUNIONNAME_ki(this.address(), value);
        return this;
    }

    public INPUT DUMMYUNIONNAME_ki(Consumer<KEYBDINPUT> consumer) {
        consumer.accept(this.DUMMYUNIONNAME_ki());
        return this;
    }

    public INPUT DUMMYUNIONNAME_hi(HARDWAREINPUT value) {
        INPUT.nDUMMYUNIONNAME_hi(this.address(), value);
        return this;
    }

    public INPUT DUMMYUNIONNAME_hi(Consumer<HARDWAREINPUT> consumer) {
        consumer.accept(this.DUMMYUNIONNAME_hi());
        return this;
    }

    public INPUT set(INPUT src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static INPUT malloc() {
        return INPUT.wrap(INPUT.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static INPUT calloc() {
        return INPUT.wrap(INPUT.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static INPUT create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return INPUT.wrap(INPUT.class, MemoryUtil.memAddress(container), container);
    }

    public static INPUT create(long address) {
        return INPUT.wrap(INPUT.class, address);
    }

    @Nullable
    public static INPUT createSafe(long address) {
        return address == 0L ? null : INPUT.wrap(INPUT.class, address);
    }

    public static Buffer malloc(int capacity) {
        return INPUT.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(INPUT.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return INPUT.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = INPUT.__create(capacity, SIZEOF);
        return INPUT.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return INPUT.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : INPUT.wrap(Buffer.class, address, capacity);
    }

    public static INPUT mallocStack() {
        return INPUT.mallocStack(MemoryStack.stackGet());
    }

    public static INPUT callocStack() {
        return INPUT.callocStack(MemoryStack.stackGet());
    }

    public static INPUT mallocStack(MemoryStack stack) {
        return INPUT.wrap(INPUT.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static INPUT callocStack(MemoryStack stack) {
        return INPUT.wrap(INPUT.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return INPUT.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return INPUT.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return INPUT.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return INPUT.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    public static int ntype(long struct) {
        return UNSAFE.getInt(null, struct + (long)TYPE);
    }

    public static MOUSEINPUT nDUMMYUNIONNAME_mi(long struct) {
        return MOUSEINPUT.create(struct + (long)DUMMYUNIONNAME_MI);
    }

    public static KEYBDINPUT nDUMMYUNIONNAME_ki(long struct) {
        return KEYBDINPUT.create(struct + (long)DUMMYUNIONNAME_KI);
    }

    public static HARDWAREINPUT nDUMMYUNIONNAME_hi(long struct) {
        return HARDWAREINPUT.create(struct + (long)DUMMYUNIONNAME_HI);
    }

    public static void ntype(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)TYPE, value);
    }

    public static void nDUMMYUNIONNAME_mi(long struct, MOUSEINPUT value) {
        MemoryUtil.memCopy(value.address(), struct + (long)DUMMYUNIONNAME_MI, MOUSEINPUT.SIZEOF);
    }

    public static void nDUMMYUNIONNAME_ki(long struct, KEYBDINPUT value) {
        MemoryUtil.memCopy(value.address(), struct + (long)DUMMYUNIONNAME_KI, KEYBDINPUT.SIZEOF);
    }

    public static void nDUMMYUNIONNAME_hi(long struct, HARDWAREINPUT value) {
        MemoryUtil.memCopy(value.address(), struct + (long)DUMMYUNIONNAME_HI, HARDWAREINPUT.SIZEOF);
    }

    static {
        Struct.Layout layout = INPUT.__struct(INPUT.__member(4), INPUT.__union(INPUT.__member(MOUSEINPUT.SIZEOF, MOUSEINPUT.ALIGNOF), INPUT.__member(KEYBDINPUT.SIZEOF, KEYBDINPUT.ALIGNOF), INPUT.__member(HARDWAREINPUT.SIZEOF, HARDWAREINPUT.ALIGNOF)));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        DUMMYUNIONNAME = layout.offsetof(1);
        DUMMYUNIONNAME_MI = layout.offsetof(2);
        DUMMYUNIONNAME_KI = layout.offsetof(3);
        DUMMYUNIONNAME_HI = layout.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<INPUT, Buffer>
    implements NativeResource {
        private static final INPUT ELEMENT_FACTORY = INPUT.create(-1L);

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
        protected INPUT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int type() {
            return INPUT.ntype(this.address());
        }

        public MOUSEINPUT DUMMYUNIONNAME_mi() {
            return INPUT.nDUMMYUNIONNAME_mi(this.address());
        }

        public KEYBDINPUT DUMMYUNIONNAME_ki() {
            return INPUT.nDUMMYUNIONNAME_ki(this.address());
        }

        public HARDWAREINPUT DUMMYUNIONNAME_hi() {
            return INPUT.nDUMMYUNIONNAME_hi(this.address());
        }

        public Buffer type(@NativeType(value="DWORD") int value) {
            INPUT.ntype(this.address(), value);
            return this;
        }

        public Buffer DUMMYUNIONNAME_mi(MOUSEINPUT value) {
            INPUT.nDUMMYUNIONNAME_mi(this.address(), value);
            return this;
        }

        public Buffer DUMMYUNIONNAME_mi(Consumer<MOUSEINPUT> consumer) {
            consumer.accept(this.DUMMYUNIONNAME_mi());
            return this;
        }

        public Buffer DUMMYUNIONNAME_ki(KEYBDINPUT value) {
            INPUT.nDUMMYUNIONNAME_ki(this.address(), value);
            return this;
        }

        public Buffer DUMMYUNIONNAME_ki(Consumer<KEYBDINPUT> consumer) {
            consumer.accept(this.DUMMYUNIONNAME_ki());
            return this;
        }

        public Buffer DUMMYUNIONNAME_hi(HARDWAREINPUT value) {
            INPUT.nDUMMYUNIONNAME_hi(this.address(), value);
            return this;
        }

        public Buffer DUMMYUNIONNAME_hi(Consumer<HARDWAREINPUT> consumer) {
            consumer.accept(this.DUMMYUNIONNAME_hi());
            return this;
        }
    }
}

