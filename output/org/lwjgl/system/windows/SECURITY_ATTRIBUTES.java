/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

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

public class SECURITY_ATTRIBUTES
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int NLENGTH;
    public static final int LPSECURITYDESCRIPTOR;
    public static final int BINHERITHANDLE;

    public SECURITY_ATTRIBUTES(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), SECURITY_ATTRIBUTES.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int nLength() {
        return SECURITY_ATTRIBUTES.nnLength(this.address());
    }

    @NativeType(value="LPVOID")
    public long lpSecurityDescriptor() {
        return SECURITY_ATTRIBUTES.nlpSecurityDescriptor(this.address());
    }

    @NativeType(value="BOOL")
    public boolean bInheritHandle() {
        return SECURITY_ATTRIBUTES.nbInheritHandle(this.address()) != 0;
    }

    public SECURITY_ATTRIBUTES nLength(@NativeType(value="DWORD") int value) {
        SECURITY_ATTRIBUTES.nnLength(this.address(), value);
        return this;
    }

    public SECURITY_ATTRIBUTES lpSecurityDescriptor(@NativeType(value="LPVOID") long value) {
        SECURITY_ATTRIBUTES.nlpSecurityDescriptor(this.address(), value);
        return this;
    }

    public SECURITY_ATTRIBUTES bInheritHandle(@NativeType(value="BOOL") boolean value) {
        SECURITY_ATTRIBUTES.nbInheritHandle(this.address(), value ? 1 : 0);
        return this;
    }

    public SECURITY_ATTRIBUTES set(int nLength, long lpSecurityDescriptor, boolean bInheritHandle) {
        this.nLength(nLength);
        this.lpSecurityDescriptor(lpSecurityDescriptor);
        this.bInheritHandle(bInheritHandle);
        return this;
    }

    public SECURITY_ATTRIBUTES set(SECURITY_ATTRIBUTES src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static SECURITY_ATTRIBUTES malloc() {
        return SECURITY_ATTRIBUTES.wrap(SECURITY_ATTRIBUTES.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static SECURITY_ATTRIBUTES calloc() {
        return SECURITY_ATTRIBUTES.wrap(SECURITY_ATTRIBUTES.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static SECURITY_ATTRIBUTES create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return SECURITY_ATTRIBUTES.wrap(SECURITY_ATTRIBUTES.class, MemoryUtil.memAddress(container), container);
    }

    public static SECURITY_ATTRIBUTES create(long address) {
        return SECURITY_ATTRIBUTES.wrap(SECURITY_ATTRIBUTES.class, address);
    }

    @Nullable
    public static SECURITY_ATTRIBUTES createSafe(long address) {
        return address == 0L ? null : SECURITY_ATTRIBUTES.wrap(SECURITY_ATTRIBUTES.class, address);
    }

    public static Buffer malloc(int capacity) {
        return SECURITY_ATTRIBUTES.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(SECURITY_ATTRIBUTES.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return SECURITY_ATTRIBUTES.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = SECURITY_ATTRIBUTES.__create(capacity, SIZEOF);
        return SECURITY_ATTRIBUTES.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return SECURITY_ATTRIBUTES.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : SECURITY_ATTRIBUTES.wrap(Buffer.class, address, capacity);
    }

    public static SECURITY_ATTRIBUTES mallocStack() {
        return SECURITY_ATTRIBUTES.mallocStack(MemoryStack.stackGet());
    }

    public static SECURITY_ATTRIBUTES callocStack() {
        return SECURITY_ATTRIBUTES.callocStack(MemoryStack.stackGet());
    }

    public static SECURITY_ATTRIBUTES mallocStack(MemoryStack stack) {
        return SECURITY_ATTRIBUTES.wrap(SECURITY_ATTRIBUTES.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static SECURITY_ATTRIBUTES callocStack(MemoryStack stack) {
        return SECURITY_ATTRIBUTES.wrap(SECURITY_ATTRIBUTES.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return SECURITY_ATTRIBUTES.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return SECURITY_ATTRIBUTES.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return SECURITY_ATTRIBUTES.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return SECURITY_ATTRIBUTES.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    public static int nnLength(long struct) {
        return UNSAFE.getInt(null, struct + (long)NLENGTH);
    }

    public static long nlpSecurityDescriptor(long struct) {
        return MemoryUtil.memGetAddress(struct + (long)LPSECURITYDESCRIPTOR);
    }

    public static int nbInheritHandle(long struct) {
        return UNSAFE.getInt(null, struct + (long)BINHERITHANDLE);
    }

    public static void nnLength(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)NLENGTH, value);
    }

    public static void nlpSecurityDescriptor(long struct, long value) {
        MemoryUtil.memPutAddress(struct + (long)LPSECURITYDESCRIPTOR, Checks.check(value));
    }

    public static void nbInheritHandle(long struct, int value) {
        UNSAFE.putInt(null, struct + (long)BINHERITHANDLE, value);
    }

    public static void validate(long struct) {
        Checks.check(MemoryUtil.memGetAddress(struct + (long)LPSECURITYDESCRIPTOR));
    }

    public static void validate(long array, int count) {
        for (int i = 0; i < count; ++i) {
            SECURITY_ATTRIBUTES.validate(array + Integer.toUnsignedLong(i) * (long)SIZEOF);
        }
    }

    static {
        Struct.Layout layout = SECURITY_ATTRIBUTES.__struct(SECURITY_ATTRIBUTES.__member(4), SECURITY_ATTRIBUTES.__member(POINTER_SIZE), SECURITY_ATTRIBUTES.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        NLENGTH = layout.offsetof(0);
        LPSECURITYDESCRIPTOR = layout.offsetof(1);
        BINHERITHANDLE = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<SECURITY_ATTRIBUTES, Buffer>
    implements NativeResource {
        private static final SECURITY_ATTRIBUTES ELEMENT_FACTORY = SECURITY_ATTRIBUTES.create(-1L);

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
        protected SECURITY_ATTRIBUTES getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int nLength() {
            return SECURITY_ATTRIBUTES.nnLength(this.address());
        }

        @NativeType(value="LPVOID")
        public long lpSecurityDescriptor() {
            return SECURITY_ATTRIBUTES.nlpSecurityDescriptor(this.address());
        }

        @NativeType(value="BOOL")
        public boolean bInheritHandle() {
            return SECURITY_ATTRIBUTES.nbInheritHandle(this.address()) != 0;
        }

        public Buffer nLength(@NativeType(value="DWORD") int value) {
            SECURITY_ATTRIBUTES.nnLength(this.address(), value);
            return this;
        }

        public Buffer lpSecurityDescriptor(@NativeType(value="LPVOID") long value) {
            SECURITY_ATTRIBUTES.nlpSecurityDescriptor(this.address(), value);
            return this;
        }

        public Buffer bInheritHandle(@NativeType(value="BOOL") boolean value) {
            SECURITY_ATTRIBUTES.nbInheritHandle(this.address(), value ? 1 : 0);
            return this;
        }
    }
}

