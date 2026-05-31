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
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class CGPoint
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int X;
    public static final int Y;

    public CGPoint(ByteBuffer container) {
        super(MemoryUtil.memAddress(container), CGPoint.__checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="CGFloat")
    public double x() {
        return CGPoint.nx(this.address());
    }

    @NativeType(value="CGFloat")
    public double y() {
        return CGPoint.ny(this.address());
    }

    public CGPoint x(@NativeType(value="CGFloat") double value) {
        CGPoint.nx(this.address(), value);
        return this;
    }

    public CGPoint y(@NativeType(value="CGFloat") double value) {
        CGPoint.ny(this.address(), value);
        return this;
    }

    public CGPoint set(double x, double y) {
        this.x(x);
        this.y(y);
        return this;
    }

    public CGPoint set(CGPoint src) {
        MemoryUtil.memCopy(src.address(), this.address(), SIZEOF);
        return this;
    }

    public static CGPoint malloc() {
        return CGPoint.wrap(CGPoint.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static CGPoint calloc() {
        return CGPoint.wrap(CGPoint.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static CGPoint create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return CGPoint.wrap(CGPoint.class, MemoryUtil.memAddress(container), container);
    }

    public static CGPoint create(long address) {
        return CGPoint.wrap(CGPoint.class, address);
    }

    @Nullable
    public static CGPoint createSafe(long address) {
        return address == 0L ? null : CGPoint.wrap(CGPoint.class, address);
    }

    public static Buffer malloc(int capacity) {
        return CGPoint.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(CGPoint.__checkMalloc(capacity, SIZEOF)), capacity);
    }

    public static Buffer calloc(int capacity) {
        return CGPoint.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    public static Buffer create(int capacity) {
        ByteBuffer container = CGPoint.__create(capacity, SIZEOF);
        return CGPoint.wrap(Buffer.class, MemoryUtil.memAddress(container), capacity, container);
    }

    public static Buffer create(long address, int capacity) {
        return CGPoint.wrap(Buffer.class, address, capacity);
    }

    @Nullable
    public static Buffer createSafe(long address, int capacity) {
        return address == 0L ? null : CGPoint.wrap(Buffer.class, address, capacity);
    }

    public static CGPoint mallocStack() {
        return CGPoint.mallocStack(MemoryStack.stackGet());
    }

    public static CGPoint callocStack() {
        return CGPoint.callocStack(MemoryStack.stackGet());
    }

    public static CGPoint mallocStack(MemoryStack stack) {
        return CGPoint.wrap(CGPoint.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static CGPoint callocStack(MemoryStack stack) {
        return CGPoint.wrap(CGPoint.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer mallocStack(int capacity) {
        return CGPoint.mallocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer callocStack(int capacity) {
        return CGPoint.callocStack(capacity, MemoryStack.stackGet());
    }

    public static Buffer mallocStack(int capacity, MemoryStack stack) {
        return CGPoint.wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    public static Buffer callocStack(int capacity, MemoryStack stack) {
        return CGPoint.wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    public static double nx(long struct) {
        return UNSAFE.getDouble(null, struct + (long)X);
    }

    public static double ny(long struct) {
        return UNSAFE.getDouble(null, struct + (long)Y);
    }

    public static void nx(long struct, double value) {
        UNSAFE.putDouble(null, struct + (long)X, value);
    }

    public static void ny(long struct, double value) {
        UNSAFE.putDouble(null, struct + (long)Y, value);
    }

    static {
        Struct.Layout layout = CGPoint.__struct(CGPoint.__member(8), CGPoint.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        X = layout.offsetof(0);
        Y = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<CGPoint, Buffer>
    implements NativeResource {
        private static final CGPoint ELEMENT_FACTORY = CGPoint.create(-1L);

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
        protected CGPoint getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="CGFloat")
        public double x() {
            return CGPoint.nx(this.address());
        }

        @NativeType(value="CGFloat")
        public double y() {
            return CGPoint.ny(this.address());
        }

        public Buffer x(@NativeType(value="CGFloat") double value) {
            CGPoint.nx(this.address(), value);
            return this;
        }

        public Buffer y(@NativeType(value="CGFloat") double value) {
            CGPoint.ny(this.address(), value);
            return this;
        }
    }
}

