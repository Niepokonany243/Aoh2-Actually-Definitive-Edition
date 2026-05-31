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
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.CheckIntrinsics;
import org.lwjgl.system.Checks;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.MemoryUtil;

public class CLongBuffer
extends CustomBuffer<CLongBuffer>
implements Comparable<CLongBuffer> {
    protected CLongBuffer(long address, @Nullable ByteBuffer container, int mark, int position, int limit, int capacity) {
        super(address, container, mark, position, limit, capacity);
    }

    public static CLongBuffer allocateDirect(int capacity) {
        ByteBuffer source = BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(capacity, CLONG_SHIFT));
        return CLongBuffer.wrap(CLongBuffer.class, MemoryUtil.memAddress(source), capacity, source);
    }

    public static CLongBuffer create(long address, int capacity) {
        return CLongBuffer.wrap(CLongBuffer.class, address, capacity);
    }

    public static CLongBuffer create(ByteBuffer source) {
        int capacity = source.remaining() >> CLONG_SHIFT;
        return CLongBuffer.wrap(CLongBuffer.class, MemoryUtil.memAddress(source), capacity, source);
    }

    @Override
    protected CLongBuffer self() {
        return this;
    }

    @Override
    public int sizeof() {
        return CLONG_SIZE;
    }

    public long get() {
        return MemoryUtil.memGetCLong(this.address + Integer.toUnsignedLong(this.nextGetIndex()) * (long)CLONG_SIZE);
    }

    public static long get(ByteBuffer source) {
        if (source.remaining() < CLONG_SIZE) {
            throw new BufferUnderflowException();
        }
        try {
            long l = MemoryUtil.memGetCLong(MemoryUtil.memAddress(source));
            return l;
        }
        finally {
            source.position(source.position() + CLONG_SIZE);
        }
    }

    @Override
    public CLongBuffer put(long p) {
        MemoryUtil.memPutCLong(this.address + Integer.toUnsignedLong(this.nextPutIndex()) * (long)CLONG_SIZE, p);
        return this;
    }

    public static void put(ByteBuffer target, long p) {
        if (target.remaining() < CLONG_SIZE) {
            throw new BufferOverflowException();
        }
        try {
            MemoryUtil.memPutCLong(MemoryUtil.memAddress(target), p);
        }
        finally {
            target.position(target.position() + CLONG_SIZE);
        }
    }

    public long get(int index) {
        return MemoryUtil.memGetCLong(this.address + Checks.check(index, this.limit) * (long)CLONG_SIZE);
    }

    public static long get(ByteBuffer source, int index) {
        CheckIntrinsics.checkFromIndexSize(index, CLONG_SIZE, source.limit());
        return MemoryUtil.memGetCLong(MemoryUtil.memAddress0(source) + (long)index);
    }

    public CLongBuffer put(int index, long p) {
        MemoryUtil.memPutCLong(this.address + Checks.check(index, this.limit) * (long)CLONG_SIZE, p);
        return this;
    }

    public static void put(ByteBuffer target, int index, long p) {
        CheckIntrinsics.checkFromIndexSize(index, CLONG_SIZE, target.limit());
        MemoryUtil.memPutCLong(MemoryUtil.memAddress0(target) + (long)index, p);
    }

    public CLongBuffer get(long[] dst) {
        return this.get(dst, 0, dst.length);
    }

    public CLongBuffer get(long[] dst, int offset, int length) {
        if (CLONG_SIZE == 8) {
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
    public CLongBuffer put(long[] src) {
        return this.put(src, 0, src.length);
    }

    public CLongBuffer put(long[] src, int offset, int length) {
        if (CLONG_SIZE == 8) {
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
        if (!(ob instanceof CLongBuffer)) {
            return false;
        }
        CLongBuffer that = (CLongBuffer)ob;
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
    public int compareTo(CLongBuffer that) {
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

