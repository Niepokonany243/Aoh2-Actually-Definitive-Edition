/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.CheckIntrinsics;
import org.lwjgl.system.Checks;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Pointer;

public class PointerBuffer
extends CustomBuffer<PointerBuffer>
implements Comparable<PointerBuffer> {
    protected PointerBuffer(long address, @Nullable ByteBuffer container, int mark, int position, int limit, int capacity) {
        super(address, container, mark, position, limit, capacity);
    }

    public static PointerBuffer allocateDirect(int capacity) {
        ByteBuffer source = BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(capacity, POINTER_SHIFT));
        return PointerBuffer.wrap(PointerBuffer.class, MemoryUtil.memAddress(source), capacity, source);
    }

    public static PointerBuffer create(long address, int capacity) {
        return PointerBuffer.wrap(PointerBuffer.class, address, capacity);
    }

    public static PointerBuffer create(ByteBuffer source) {
        int capacity = source.remaining() >> POINTER_SHIFT;
        return PointerBuffer.wrap(PointerBuffer.class, MemoryUtil.memAddress(source), capacity, source);
    }

    @Override
    protected PointerBuffer self() {
        return this;
    }

    @Override
    public int sizeof() {
        return POINTER_SIZE;
    }

    public long get() {
        return MemoryUtil.memGetAddress(this.address + Integer.toUnsignedLong(this.nextGetIndex()) * (long)POINTER_SIZE);
    }

    public static long get(ByteBuffer source) {
        if (source.remaining() < POINTER_SIZE) {
            throw new BufferUnderflowException();
        }
        try {
            long l = MemoryUtil.memGetAddress(MemoryUtil.memAddress(source));
            return l;
        }
        finally {
            source.position(source.position() + POINTER_SIZE);
        }
    }

    @Override
    public PointerBuffer put(long p) {
        MemoryUtil.memPutAddress(this.address + Integer.toUnsignedLong(this.nextPutIndex()) * (long)POINTER_SIZE, p);
        return this;
    }

    public static void put(ByteBuffer target, long p) {
        if (target.remaining() < POINTER_SIZE) {
            throw new BufferOverflowException();
        }
        try {
            MemoryUtil.memPutAddress(MemoryUtil.memAddress(target), p);
        }
        finally {
            target.position(target.position() + POINTER_SIZE);
        }
    }

    public long get(int index) {
        return MemoryUtil.memGetAddress(this.address + Checks.check(index, this.limit) * (long)POINTER_SIZE);
    }

    public static long get(ByteBuffer source, int index) {
        CheckIntrinsics.checkFromIndexSize(index, POINTER_SIZE, source.limit());
        return MemoryUtil.memGetAddress(MemoryUtil.memAddress0(source) + (long)index);
    }

    public PointerBuffer put(int index, long p) {
        MemoryUtil.memPutAddress(this.address + Checks.check(index, this.limit) * (long)POINTER_SIZE, p);
        return this;
    }

    public static void put(ByteBuffer target, int index, long p) {
        CheckIntrinsics.checkFromIndexSize(index, POINTER_SIZE, target.limit());
        MemoryUtil.memPutAddress(MemoryUtil.memAddress0(target) + (long)index, p);
    }

    @Override
    public PointerBuffer put(Pointer pointer) {
        this.put(pointer.address());
        return this;
    }

    public PointerBuffer put(int index, Pointer pointer) {
        this.put(index, pointer.address());
        return this;
    }

    @Override
    public PointerBuffer put(ByteBuffer buffer) {
        this.put(MemoryUtil.memAddress(buffer));
        return this;
    }

    @Override
    public PointerBuffer put(ShortBuffer buffer) {
        this.put(MemoryUtil.memAddress(buffer));
        return this;
    }

    @Override
    public PointerBuffer put(IntBuffer buffer) {
        this.put(MemoryUtil.memAddress(buffer));
        return this;
    }

    @Override
    public PointerBuffer put(LongBuffer buffer) {
        this.put(MemoryUtil.memAddress(buffer));
        return this;
    }

    @Override
    public PointerBuffer put(FloatBuffer buffer) {
        this.put(MemoryUtil.memAddress(buffer));
        return this;
    }

    @Override
    public PointerBuffer put(DoubleBuffer buffer) {
        this.put(MemoryUtil.memAddress(buffer));
        return this;
    }

    public PointerBuffer putAddressOf(CustomBuffer<?> buffer) {
        this.put(MemoryUtil.memAddress(buffer));
        return this;
    }

    public PointerBuffer put(int index, ByteBuffer buffer) {
        this.put(index, MemoryUtil.memAddress(buffer));
        return this;
    }

    public PointerBuffer put(int index, ShortBuffer buffer) {
        this.put(index, MemoryUtil.memAddress(buffer));
        return this;
    }

    public PointerBuffer put(int index, IntBuffer buffer) {
        this.put(index, MemoryUtil.memAddress(buffer));
        return this;
    }

    public PointerBuffer put(int index, LongBuffer buffer) {
        this.put(index, MemoryUtil.memAddress(buffer));
        return this;
    }

    public PointerBuffer put(int index, FloatBuffer buffer) {
        this.put(index, MemoryUtil.memAddress(buffer));
        return this;
    }

    public PointerBuffer put(int index, DoubleBuffer buffer) {
        this.put(index, MemoryUtil.memAddress(buffer));
        return this;
    }

    public PointerBuffer putAddressOf(int index, CustomBuffer<?> buffer) {
        this.put(index, MemoryUtil.memAddress(buffer));
        return this;
    }

    public ByteBuffer getByteBuffer(int size) {
        return MemoryUtil.memByteBuffer(this.get(), size);
    }

    public ShortBuffer getShortBuffer(int size) {
        return MemoryUtil.memShortBuffer(this.get(), size);
    }

    public IntBuffer getIntBuffer(int size) {
        return MemoryUtil.memIntBuffer(this.get(), size);
    }

    public LongBuffer getLongBuffer(int size) {
        return MemoryUtil.memLongBuffer(this.get(), size);
    }

    public FloatBuffer getFloatBuffer(int size) {
        return MemoryUtil.memFloatBuffer(this.get(), size);
    }

    public DoubleBuffer getDoubleBuffer(int size) {
        return MemoryUtil.memDoubleBuffer(this.get(), size);
    }

    public PointerBuffer getPointerBuffer(int size) {
        return MemoryUtil.memPointerBuffer(this.get(), size);
    }

    public String getStringASCII() {
        return MemoryUtil.memASCII(this.get());
    }

    public String getStringUTF8() {
        return MemoryUtil.memUTF8(this.get());
    }

    public String getStringUTF16() {
        return MemoryUtil.memUTF16(this.get());
    }

    public ByteBuffer getByteBuffer(int index, int size) {
        return MemoryUtil.memByteBuffer(this.get(index), size);
    }

    public ShortBuffer getShortBuffer(int index, int size) {
        return MemoryUtil.memShortBuffer(this.get(index), size);
    }

    public IntBuffer getIntBuffer(int index, int size) {
        return MemoryUtil.memIntBuffer(this.get(index), size);
    }

    public LongBuffer getLongBuffer(int index, int size) {
        return MemoryUtil.memLongBuffer(this.get(index), size);
    }

    public FloatBuffer getFloatBuffer(int index, int size) {
        return MemoryUtil.memFloatBuffer(this.get(index), size);
    }

    public DoubleBuffer getDoubleBuffer(int index, int size) {
        return MemoryUtil.memDoubleBuffer(this.get(index), size);
    }

    public PointerBuffer getPointerBuffer(int index, int size) {
        return MemoryUtil.memPointerBuffer(this.get(index), size);
    }

    public String getStringASCII(int index) {
        return MemoryUtil.memASCII(this.get(index));
    }

    public String getStringUTF8(int index) {
        return MemoryUtil.memUTF8(this.get(index));
    }

    public String getStringUTF16(int index) {
        return MemoryUtil.memUTF16(this.get(index));
    }

    public PointerBuffer get(long[] dst) {
        return this.get(dst, 0, dst.length);
    }

    public PointerBuffer get(long[] dst, int offset, int length) {
        if (BITS64) {
            MemoryUtil.memLongBuffer(this.address(), this.remaining()).get(dst, offset, length);
            this.position(this.position() + length);
        } else {
            this.get32(dst, offset, length);
        }
        return this;
    }

    private void get32(long[] dst, int offset, int length) {
        CheckIntrinsics.checkFromIndexSize(offset, length, dst.length);
        if (this.remaining() < length) {
            throw new BufferUnderflowException();
        }
        int end = offset + length;
        for (int i = offset; i < end; ++i) {
            dst[i] = this.get();
        }
    }

    @Override
    public PointerBuffer put(long[] src) {
        return this.put(src, 0, src.length);
    }

    public PointerBuffer put(long[] src, int offset, int length) {
        if (BITS64) {
            MemoryUtil.memLongBuffer(this.address(), this.remaining()).put(src, offset, length);
            this.position(this.position() + length);
        } else {
            this.put32(src, offset, length);
        }
        return this;
    }

    private void put32(long[] src, int offset, int length) {
        CheckIntrinsics.checkFromIndexSize(offset, length, src.length);
        if (this.remaining() < length) {
            throw new BufferOverflowException();
        }
        int end = offset + length;
        for (int i = offset; i < end; ++i) {
            this.put(src[i]);
        }
    }

    @Override
    public int hashCode() {
        int h = 1;
        int p = this.position();
        for (int i = this.limit() - 1; i >= p; --i) {
            h = 31 * h + (int)this.get(i);
        }
        return h;
    }

    @Override
    public boolean equals(Object ob) {
        if (!(ob instanceof PointerBuffer)) {
            return false;
        }
        PointerBuffer that = (PointerBuffer)ob;
        if (this.remaining() != that.remaining()) {
            return false;
        }
        int p = this.position();
        int i = this.limit() - 1;
        int j = that.limit() - 1;
        while (i >= p) {
            long v2;
            long v1 = this.get(i);
            if (v1 != (v2 = that.get(j))) {
                return false;
            }
            --i;
            --j;
        }
        return true;
    }

    @Override
    public int compareTo(PointerBuffer that) {
        int n = this.position() + Math.min(this.remaining(), that.remaining());
        int i = this.position();
        int j = that.position();
        while (i < n) {
            long v2;
            long v1 = this.get(i);
            if (v1 != (v2 = that.get(j))) {
                if (v1 < v2) {
                    return -1;
                }
                return 1;
            }
            ++i;
            ++j;
        }
        return this.remaining() - that.remaining();
    }
}

