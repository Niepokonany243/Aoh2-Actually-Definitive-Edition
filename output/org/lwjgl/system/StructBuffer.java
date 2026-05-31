/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import javax.annotation.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.Struct;

public abstract class StructBuffer<T extends Struct, SELF extends StructBuffer<T, SELF>>
extends CustomBuffer<SELF>
implements Iterable<T> {
    protected StructBuffer(ByteBuffer container, int remaining) {
        super(MemoryUtil.memAddress(container), container, -1, 0, remaining, remaining);
    }

    protected StructBuffer(long address, @Nullable ByteBuffer container, int mark, int position, int limit, int capacity) {
        super(address, container, mark, position, limit, capacity);
    }

    @Override
    public int sizeof() {
        return ((Struct)this.getElementFactory()).sizeof();
    }

    public T get() {
        return ((Struct)this.getElementFactory()).wrap(this.address, this.nextGetIndex(), this.container);
    }

    public SELF get(T value) {
        int sizeof = ((Struct)this.getElementFactory()).sizeof();
        MemoryUtil.memCopy(this.address + Integer.toUnsignedLong(this.nextGetIndex()) * (long)sizeof, ((Pointer.Default)value).address(), sizeof);
        return (SELF)((StructBuffer)this.self());
    }

    @Override
    public SELF put(T value) {
        int sizeof = ((Struct)this.getElementFactory()).sizeof();
        MemoryUtil.memCopy(((Pointer.Default)value).address(), this.address + Integer.toUnsignedLong(this.nextPutIndex()) * (long)sizeof, sizeof);
        return (SELF)((StructBuffer)this.self());
    }

    public T get(int index) {
        return ((Struct)this.getElementFactory()).wrap(this.address, StructBuffer.check(index, this.limit), this.container);
    }

    public SELF get(int index, T value) {
        int sizeof = ((Struct)this.getElementFactory()).sizeof();
        MemoryUtil.memCopy(this.address + Checks.check(index, this.limit) * (long)sizeof, ((Pointer.Default)value).address(), sizeof);
        return (SELF)((StructBuffer)this.self());
    }

    public SELF put(int index, T value) {
        int sizeof = ((Struct)this.getElementFactory()).sizeof();
        MemoryUtil.memCopy(((Pointer.Default)value).address(), this.address + Checks.check(index, this.limit) * (long)sizeof, sizeof);
        return (SELF)((StructBuffer)this.self());
    }

    public SELF apply(Consumer<T> consumer) {
        consumer.accept(this.get());
        return (SELF)((StructBuffer)this.self());
    }

    public SELF apply(int index, Consumer<T> consumer) {
        consumer.accept(this.get(index));
        return (SELF)((StructBuffer)this.self());
    }

    @Override
    public Iterator<T> iterator() {
        return new StructIterator(this.address, this.container, this.getElementFactory(), this.position, this.limit);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        T factory = this.getElementFactory();
        int fence = this.limit;
        for (int i = this.position; i < fence; ++i) {
            action.accept(((Struct)factory).wrap(this.address, i, this.container));
        }
    }

    @Override
    public Spliterator<T> spliterator() {
        return new StructSpliterator(this.address, this.container, this.getElementFactory(), this.position, this.limit);
    }

    public Stream<T> stream() {
        return StreamSupport.stream(this.spliterator(), false);
    }

    public Stream<T> parallelStream() {
        return StreamSupport.stream(this.spliterator(), true);
    }

    protected abstract T getElementFactory();

    private static int check(int index, int length) {
        if (Checks.CHECKS && (index < 0 || length <= index)) {
            throw new IndexOutOfBoundsException();
        }
        return index;
    }

    private static class StructSpliterator<T extends Struct, SELF extends StructBuffer<T, SELF>>
    implements Spliterator<T> {
        private long address;
        @Nullable
        private ByteBuffer container;
        private T factory;
        private int index;
        private int fence;

        StructSpliterator(long address, @Nullable ByteBuffer container, T factory, int position, int limit) {
            this.address = address;
            this.container = container;
            this.factory = factory;
            this.index = position;
            this.fence = limit;
        }

        @Override
        public boolean tryAdvance(Consumer<? super T> action) {
            Objects.requireNonNull(action);
            if (this.index < this.fence) {
                action.accept(((Struct)this.factory).wrap(this.address, this.index++, this.container));
                return true;
            }
            return false;
        }

        @Override
        @Nullable
        public Spliterator<T> trySplit() {
            StructSpliterator<T, SELF> structSpliterator;
            int lo = this.index;
            int mid = lo + this.fence >>> 1;
            if (lo < mid) {
                this.index = mid;
                StructSpliterator<T, SELF> structSpliterator2 = new StructSpliterator<T, SELF>(this.address, this.container, this.factory, lo, this.index);
                structSpliterator = structSpliterator2;
            } else {
                structSpliterator = null;
            }
            return structSpliterator;
        }

        @Override
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override
        public int characteristics() {
            return 17744;
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            int i;
            Objects.requireNonNull(action);
            try {
                for (i = this.index; i < this.fence; ++i) {
                    action.accept(((Struct)this.factory).wrap(this.address, i, this.container));
                }
            }
            finally {
                this.index = i;
            }
        }

        @Override
        public Comparator<? super T> getComparator() {
            throw new IllegalStateException();
        }
    }

    private static class StructIterator<T extends Struct, SELF extends StructBuffer<T, SELF>>
    implements Iterator<T> {
        private long address;
        @Nullable
        private ByteBuffer container;
        private T factory;
        private int index;
        private int fence;

        StructIterator(long address, @Nullable ByteBuffer container, T factory, int position, int limit) {
            this.address = address;
            this.container = container;
            this.factory = factory;
            this.index = position;
            this.fence = limit;
        }

        @Override
        public boolean hasNext() {
            return this.index < this.fence;
        }

        @Override
        public T next() {
            if (Checks.CHECKS && this.fence <= this.index) {
                throw new NoSuchElementException();
            }
            return ((Struct)this.factory).wrap(this.address, this.index++, this.container);
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            int i;
            Objects.requireNonNull(action);
            try {
                for (i = this.index; i < this.fence; ++i) {
                    action.accept(((Struct)this.factory).wrap(this.address, i, this.container));
                }
            }
            finally {
                this.index = i;
            }
        }
    }
}

