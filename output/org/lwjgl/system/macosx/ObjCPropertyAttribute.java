/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.macosx;

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

@NativeType(value="struct objc_property_attribute_t")
public class ObjCPropertyAttribute
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int NAME;
    public static final int VALUE;

    public ObjCPropertyAttribute(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), ObjCPropertyAttribute.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="char *")
    public ByteBuffer name() {
        return ObjCPropertyAttribute.nname(this.address());
    }

    @NativeType(value="char *")
    public String nameString() {
        return ObjCPropertyAttribute.nnameString(this.address());
    }

    @NativeType(value="char *")
    public ByteBuffer value() {
        return ObjCPropertyAttribute.nvalue(this.address());
    }

    @NativeType(value="char *")
    public String valueString() {
        return ObjCPropertyAttribute.nvalueString(this.address());
    }

    public ObjCPropertyAttribute name(@NativeType(value="char *") ByteBuffer value) {
        ObjCPropertyAttribute.nname(this.address(), value);
        return this;
    }

    public ObjCPropertyAttribute value(@NativeType(value="char *") ByteBuffer value) {
        ObjCPropertyAttribute.nvalue(this.address(), value);
        return this;
    }

    public ObjCPropertyAttribute set(ByteBuffer name, ByteBuffer value) {
        this.name(name);
        this.value(value);
        return this;
    }

    public ObjCPropertyAttribute set(ObjCPropertyAttribute src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static ObjCPropertyAttribute malloc() {
        return ObjCPropertyAttribute.wrap(ObjCPropertyAttribute.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static ObjCPropertyAttribute calloc() {
        return ObjCPropertyAttribute.wrap(ObjCPropertyAttribute.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static ObjCPropertyAttribute create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return ObjCPropertyAttribute.wrap(ObjCPropertyAttribute.class, MemoryUtil.memAddress(container), container);
    }

    public static ObjCPropertyAttribute create(long address) {
        return ObjCPropertyAttribute.wrap(ObjCPropertyAttribute.class, address);
    }

    @Nullable
    public static ObjCPropertyAttribute createSafe(long address) {
        return address == 0L ? null : ObjCPropertyAttribute.wrap(ObjCPropertyAttribute.class, address);
    }

    public static Buffer malloc(int capacity) {
        return ObjCPropertyAttribute.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(ObjCPropertyAttribute.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return ObjCPropertyAttribute.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = ObjCPropertyAttribute.__create(capacity, SIZEOF);
        return ObjCPropertyAttribute.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return ObjCPropertyAttribute.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : ObjCPropertyAttribute.wrap(Buffer.class, address, capacity);
    }

    public static ObjCPropertyAttribute mallocStack() {
        return ObjCPropertyAttribute.mallocStack(MemoryStack.stackGet());
    }

    public static ObjCPropertyAttribute callocStack() {
        return ObjCPropertyAttribute.callocStack(MemoryStack.stackGet());
    }

    public static ObjCPropertyAttribute mallocStack(MemoryStack stack) {
        return ObjCPropertyAttribute.wrap(ObjCPropertyAttribute.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static ObjCPropertyAttribute callocStack(MemoryStack stack) {
        return ObjCPropertyAttribute.wrap(ObjCPropertyAttribute.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return ObjCPropertyAttribute.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return ObjCPropertyAttribute.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return ObjCPropertyAttribute.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return ObjCPropertyAttribute.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    public static ByteBuffer nname(long struct) {
        return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(struct + (long)NAME));
    }

    public static String nnameString(long struct) {
        return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(struct + (long)NAME));
    }

    public static ByteBuffer nvalue(long struct) {
        return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(struct + (long)VALUE));
    }

    public static String nvalueString(long struct) {
        return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(struct + (long)VALUE));
    }

    public static void nname(long struct, ByteBuffer value) {
        if (Checks.CHECKS) {
            Checks.checkNT1(value);
        }
        MemoryUtil.memPutAddress(struct + (long)NAME, MemoryUtil.memAddress(value));
    }

    public static void nvalue(long struct, ByteBuffer value) {
        if (Checks.CHECKS) {
            Checks.checkNT1(value);
        }
        MemoryUtil.memPutAddress(struct + (long)VALUE, MemoryUtil.memAddress(value));
    }

    public static void validate(long struct) {
        Checks.check(MemoryUtil.memGetAddress(struct + (long)NAME));
        Checks.check(MemoryUtil.memGetAddress(struct + (long)VALUE));
    }

    public static void validate(long array, int count) {
        for (int i = 0; i < count; ++i) {
            ObjCPropertyAttribute.validate(array + Integer.toUnsignedLong(i) * (long)SIZEOF);
        }
    }

    static {
        Struct.Layout layout = ObjCPropertyAttribute.__struct(ObjCPropertyAttribute.__member(POINTER_SIZE), ObjCPropertyAttribute.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        NAME = layout.offsetof(0);
        VALUE = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<ObjCPropertyAttribute, Buffer>
    implements NativeResource {
        private static final ObjCPropertyAttribute ELEMENT_FACTORY = ObjCPropertyAttribute.create(-1L);

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
        protected ObjCPropertyAttribute getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="char *")
        public ByteBuffer name() {
            return ObjCPropertyAttribute.nname(this.address());
        }

        @NativeType(value="char *")
        public String nameString() {
            return ObjCPropertyAttribute.nnameString(this.address());
        }

        @NativeType(value="char *")
        public ByteBuffer value() {
            return ObjCPropertyAttribute.nvalue(this.address());
        }

        @NativeType(value="char *")
        public String valueString() {
            return ObjCPropertyAttribute.nvalueString(this.address());
        }

        public Buffer name(@NativeType(value="char *") ByteBuffer value) {
            ObjCPropertyAttribute.nname(this.address(), value);
            return this;
        }

        public Buffer value(@NativeType(value="char *") ByteBuffer value) {
            ObjCPropertyAttribute.nvalue(this.address(), value);
            return this;
        }
    }
}

