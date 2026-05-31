/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import javax.annotation.Nullable;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Pointer;

public abstract class CustomBuffer<SELF extends CustomBuffer<SELF>>
extends Pointer.Default {
    @Nullable
    protected ByteBuffer container;
    protected int mark;
    protected int position;
    protected int limit;
    protected int capacity;

    protected CustomBuffer(long address, @Nullable ByteBuffer container, int mark, int position, int limit, int capacity) {
        super(address);
        this.container = container;
        this.mark = mark;
        this.position = position;
        this.limit = limit;
        this.capacity = capacity;
    }

    public abstract int sizeof();

    public long address0() {
        return this.address;
    }

    @Override
    public long address() {
        return this.address + Integer.toUnsignedLong(this.position) * (long)this.sizeof();
    }

    public long address(int position) {
        return this.address + Integer.toUnsignedLong(position) * (long)this.sizeof();
    }

    public void free() {
        MemoryUtil.nmemFree(this.address);
    }

    public int capacity() {
        return this.capacity;
    }

    public int position() {
        return this.position;
    }

    public SELF position(int position) {
        if (position < 0 || this.limit < position) {
            throw new IllegalArgumentException();
        }
        this.position = position;
        if (position < this.mark) {
            this.mark = -1;
        }
        return this.self();
    }

    public int limit() {
        return this.limit;
    }

    public SELF limit(int limit) {
        if (limit < 0 || this.capacity < limit) {
            throw new IllegalArgumentException();
        }
        this.limit = limit;
        if (limit < this.position) {
            this.position = limit;
        }
        if (limit < this.mark) {
            this.mark = -1;
        }
        return this.self();
    }

    public SELF mark() {
        this.mark = this.position;
        return this.self();
    }

    public SELF reset() {
        int m = this.mark;
        if (m < 0) {
            throw new InvalidMarkException();
        }
        this.position = m;
        return this.self();
    }

    public SELF clear() {
        this.position = 0;
        this.limit = this.capacity;
        this.mark = -1;
        return this.self();
    }

    public SELF flip() {
        this.limit = this.position;
        this.position = 0;
        this.mark = -1;
        return this.self();
    }

    public SELF rewind() {
        this.position = 0;
        this.mark = -1;
        return this.self();
    }

    public int remaining() {
        return this.limit - this.position;
    }

    public boolean hasRemaining() {
        return this.position < this.limit;
    }

    public SELF slice() {
        CustomBuffer slice;
        try {
            slice = (CustomBuffer)UNSAFE.allocateInstance(this.getClass());
        }
        catch (InstantiationException e) {
            throw new UnsupportedOperationException(e);
        }
        UNSAFE.putLong(slice, ADDRESS, this.address + Integer.toUnsignedLong(this.position) * (long)this.sizeof());
        UNSAFE.putInt(slice, BUFFER_MARK, -1);
        UNSAFE.putInt(slice, BUFFER_LIMIT, this.remaining());
        UNSAFE.putInt(slice, BUFFER_CAPACITY, this.remaining());
        UNSAFE.putObject(slice, BUFFER_CONTAINER, this.container);
        return (SELF)slice;
    }

    public SELF slice(int offset, int capacity) {
        CustomBuffer slice;
        int position = this.position + offset;
        if (offset < 0 || this.limit < offset) {
            throw new IllegalArgumentException();
        }
        if (capacity < 0 || this.capacity - position < capacity) {
            throw new IllegalArgumentException();
        }
        try {
            slice = (CustomBuffer)UNSAFE.allocateInstance(this.getClass());
        }
        catch (InstantiationException e) {
            throw new UnsupportedOperationException(e);
        }
        UNSAFE.putLong(slice, ADDRESS, this.address + Integer.toUnsignedLong(position) * (long)this.sizeof());
        UNSAFE.putInt(slice, BUFFER_MARK, -1);
        UNSAFE.putInt(slice, BUFFER_LIMIT, capacity);
        UNSAFE.putInt(slice, BUFFER_CAPACITY, capacity);
        UNSAFE.putObject(slice, BUFFER_CONTAINER, this.container);
        return (SELF)slice;
    }

    public SELF duplicate() {
        CustomBuffer dup;
        try {
            dup = (CustomBuffer)UNSAFE.allocateInstance(this.getClass());
        }
        catch (InstantiationException e) {
            throw new UnsupportedOperationException(e);
        }
        UNSAFE.putLong(dup, ADDRESS, this.address);
        UNSAFE.putInt(dup, BUFFER_MARK, this.mark);
        UNSAFE.putInt(dup, BUFFER_POSITION, this.position);
        UNSAFE.putInt(dup, BUFFER_LIMIT, this.limit);
        UNSAFE.putInt(dup, BUFFER_CAPACITY, this.capacity);
        UNSAFE.putObject(dup, BUFFER_CONTAINER, this.container);
        return (SELF)dup;
    }

    public SELF put(SELF src) {
        if (src == this) {
            throw new IllegalArgumentException();
        }
        int n = ((CustomBuffer)src).remaining();
        if (this.remaining() < n) {
            throw new BufferOverflowException();
        }
        MemoryUtil.memCopy(((CustomBuffer)src).address(), this.address(), Integer.toUnsignedLong(n) * (long)this.sizeof());
        this.position += n;
        return this.self();
    }

    public SELF compact() {
        MemoryUtil.memCopy(this.address(), this.address, Integer.toUnsignedLong(this.remaining()) * (long)this.sizeof());
        this.position(this.remaining());
        this.limit(this.capacity());
        this.mark = -1;
        return this.self();
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "[pos=" + this.position() + " lim=" + this.limit() + " cap=" + this.capacity() + "]";
    }

    protected abstract SELF self();

    protected final int nextGetIndex() {
        if (this.position < this.limit) {
            return this.position++;
        }
        throw new BufferUnderflowException();
    }

    protected final int nextPutIndex() {
        if (this.position < this.limit) {
            return this.position++;
        }
        throw new BufferOverflowException();
    }
}

