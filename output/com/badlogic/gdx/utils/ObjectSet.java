/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Collections;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Null;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ObjectSet<T>
implements Iterable<T> {
    public int size;
    T[] keyTable;
    float loadFactor;
    int threshold;
    protected int shift;
    protected int mask;
    private transient ObjectSetIterator iterator1;
    private transient ObjectSetIterator iterator2;

    public ObjectSet() {
        this(51, 0.8f);
    }

    public ObjectSet(int initialCapacity) {
        this(initialCapacity, 0.8f);
    }

    public ObjectSet(int initialCapacity, float loadFactor) {
        if (loadFactor <= 0.0f || loadFactor >= 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + loadFactor);
        }
        this.loadFactor = loadFactor;
        int tableSize = ObjectSet.tableSize(initialCapacity, loadFactor);
        this.threshold = (int)((float)tableSize * loadFactor);
        this.mask = tableSize - 1;
        this.shift = Long.numberOfLeadingZeros(this.mask);
        this.keyTable = new Object[tableSize];
    }

    public ObjectSet(ObjectSet<? extends T> set) {
        this((int)((float)set.keyTable.length * set.loadFactor), set.loadFactor);
        System.arraycopy(set.keyTable, 0, this.keyTable, 0, set.keyTable.length);
        this.size = set.size;
    }

    protected int place(T item) {
        return (int)((long)item.hashCode() * -7046029254386353131L >>> this.shift);
    }

    int locateKey(T key) {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null.");
        }
        T[] keyTable = this.keyTable;
        int i = this.place(key);
        T other;
        while ((other = keyTable[i]) != null) {
            if (other.equals(key)) {
                return i;
            }
            i = i + 1 & this.mask;
        }
        return -(i + 1);
    }

    public boolean add(T key) {
        int i = this.locateKey(key);
        if (i >= 0) {
            return false;
        }
        i = -(i + 1);
        this.keyTable[i] = key;
        if (++this.size >= this.threshold) {
            this.resize(this.keyTable.length << 1);
        }
        return true;
    }

    public void addAll(Array<? extends T> array) {
        this.addAll(array.items, 0, array.size);
    }

    public void addAll(Array<? extends T> array, int offset, int length) {
        if (offset + length > array.size) {
            throw new IllegalArgumentException("offset + length must be <= size: " + offset + " + " + length + " <= " + array.size);
        }
        this.addAll(array.items, offset, length);
    }

    public boolean addAll(T ... array) {
        return this.addAll(array, 0, array.length);
    }

    public boolean addAll(T[] array, int offset, int length) {
        int i;
        this.ensureCapacity(length);
        int oldSize = this.size;
        int n = i + length;
        for (i = offset; i < n; ++i) {
            this.add(array[i]);
        }
        return oldSize != this.size;
    }

    public void addAll(ObjectSet<T> set) {
        this.ensureCapacity(set.size);
        for (T key : set.keyTable) {
            if (key == null) continue;
            this.add(key);
        }
    }

    private void addResize(T key) {
        T[] keyTable = this.keyTable;
        int i = this.place(key);
        while (true) {
            if (keyTable[i] == null) {
                keyTable[i] = key;
                return;
            }
            i = i + 1 & this.mask;
        }
    }

    public boolean remove(T key) {
        int i = this.locateKey(key);
        if (i < 0) {
            return false;
        }
        T[] keyTable = this.keyTable;
        int mask = this.mask;
        int next = i + 1 & mask;
        while ((key = keyTable[next]) != null) {
            int placement = this.place(key);
            if ((next - placement & mask) > (i - placement & mask)) {
                keyTable[i] = key;
                i = next;
            }
            next = next + 1 & mask;
        }
        keyTable[i] = null;
        --this.size;
        return true;
    }

    public boolean notEmpty() {
        return this.size > 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void shrink(int maximumCapacity) {
        if (maximumCapacity < 0) {
            throw new IllegalArgumentException("maximumCapacity must be >= 0: " + maximumCapacity);
        }
        int tableSize = ObjectSet.tableSize(maximumCapacity, this.loadFactor);
        if (this.keyTable.length > tableSize) {
            this.resize(tableSize);
        }
    }

    public void clear(int maximumCapacity) {
        int tableSize = ObjectSet.tableSize(maximumCapacity, this.loadFactor);
        if (this.keyTable.length <= tableSize) {
            this.clear();
            return;
        }
        this.size = 0;
        this.resize(tableSize);
    }

    public void clear() {
        if (this.size == 0) {
            return;
        }
        this.size = 0;
        Arrays.fill(this.keyTable, null);
    }

    public boolean contains(T key) {
        return this.locateKey(key) >= 0;
    }

    @Null
    public T get(T key) {
        int i = this.locateKey(key);
        return i < 0 ? null : (T)this.keyTable[i];
    }

    public T first() {
        T[] keyTable = this.keyTable;
        int n = keyTable.length;
        for (int i = 0; i < n; ++i) {
            if (keyTable[i] == null) continue;
            return keyTable[i];
        }
        throw new IllegalStateException("ObjectSet is empty.");
    }

    public void ensureCapacity(int additionalCapacity) {
        int tableSize = ObjectSet.tableSize(this.size + additionalCapacity, this.loadFactor);
        if (this.keyTable.length < tableSize) {
            this.resize(tableSize);
        }
    }

    private void resize(int newSize) {
        int oldCapacity = this.keyTable.length;
        this.threshold = (int)((float)newSize * this.loadFactor);
        this.mask = newSize - 1;
        this.shift = Long.numberOfLeadingZeros(this.mask);
        T[] oldKeyTable = this.keyTable;
        this.keyTable = new Object[newSize];
        if (this.size > 0) {
            for (int i = 0; i < oldCapacity; ++i) {
                T key = oldKeyTable[i];
                if (key == null) continue;
                this.addResize(key);
            }
        }
    }

    public int hashCode() {
        int h = this.size;
        for (T key : this.keyTable) {
            if (key == null) continue;
            h += key.hashCode();
        }
        return h;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ObjectSet)) {
            return false;
        }
        ObjectSet other = (ObjectSet)obj;
        if (other.size != this.size) {
            return false;
        }
        T[] keyTable = this.keyTable;
        int n = keyTable.length;
        for (int i = 0; i < n; ++i) {
            if (keyTable[i] == null || other.contains(keyTable[i])) continue;
            return false;
        }
        return true;
    }

    public String toString() {
        return '{' + this.toString(", ") + '}';
    }

    public String toString(String separator) {
        T key;
        if (this.size == 0) {
            return "";
        }
        StringBuilder buffer = new StringBuilder(32);
        T[] keyTable = this.keyTable;
        int i = keyTable.length;
        while (i-- > 0) {
            key = keyTable[i];
            if (key == null) continue;
            buffer.append((Object)(key == this ? "(this)" : key));
            break;
        }
        while (i-- > 0) {
            key = keyTable[i];
            if (key == null) continue;
            buffer.append(separator);
            buffer.append((Object)(key == this ? "(this)" : key));
        }
        return buffer.toString();
    }

    @Override
    public ObjectSetIterator<T> iterator() {
        if (Collections.allocateIterators) {
            return new ObjectSetIterator(this);
        }
        if (this.iterator1 == null) {
            this.iterator1 = new ObjectSetIterator(this);
            this.iterator2 = new ObjectSetIterator(this);
        }
        if (!this.iterator1.valid) {
            this.iterator1.reset();
            this.iterator1.valid = true;
            this.iterator2.valid = false;
            return this.iterator1;
        }
        this.iterator2.reset();
        this.iterator2.valid = true;
        this.iterator1.valid = false;
        return this.iterator2;
    }

    public static <T> ObjectSet<T> with(T ... array) {
        ObjectSet<T> set = new ObjectSet<T>();
        set.addAll(array);
        return set;
    }

    static int tableSize(int capacity, float loadFactor) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must be >= 0: " + capacity);
        }
        int tableSize = MathUtils.nextPowerOfTwo(Math.max(2, (int)Math.ceil((float)capacity / loadFactor)));
        if (tableSize > 0x40000000) {
            throw new IllegalArgumentException("The required capacity is too large: " + capacity);
        }
        return tableSize;
    }

    public static class ObjectSetIterator<K>
    implements Iterable<K>,
    Iterator<K> {
        public boolean hasNext;
        final ObjectSet<K> set;
        int nextIndex;
        int currentIndex;
        boolean valid = true;

        public ObjectSetIterator(ObjectSet<K> set) {
            this.set = set;
            this.reset();
        }

        public void reset() {
            this.currentIndex = -1;
            this.nextIndex = -1;
            this.findNextIndex();
        }

        private void findNextIndex() {
            T[] keyTable = this.set.keyTable;
            int n = this.set.keyTable.length;
            while (++this.nextIndex < n) {
                if (keyTable[this.nextIndex] == null) continue;
                this.hasNext = true;
                return;
            }
            this.hasNext = false;
        }

        @Override
        public void remove() {
            Object key;
            int i = this.currentIndex;
            if (i < 0) {
                throw new IllegalStateException("next must be called before remove.");
            }
            T[] keyTable = this.set.keyTable;
            int mask = this.set.mask;
            int next = i + 1 & mask;
            while ((key = keyTable[next]) != null) {
                int placement = this.set.place(key);
                if ((next - placement & mask) > (i - placement & mask)) {
                    keyTable[i] = key;
                    i = next;
                }
                next = next + 1 & mask;
            }
            keyTable[i] = null;
            --this.set.size;
            if (i != this.currentIndex) {
                --this.nextIndex;
            }
            this.currentIndex = -1;
        }

        @Override
        public boolean hasNext() {
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return this.hasNext;
        }

        @Override
        public K next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            Object key = this.set.keyTable[this.nextIndex];
            this.currentIndex = this.nextIndex;
            this.findNextIndex();
            return (K)key;
        }

        @Override
        public ObjectSetIterator<K> iterator() {
            return this;
        }

        public Array<K> toArray(Array<K> array) {
            while (this.hasNext) {
                array.add(this.next());
            }
            return array;
        }

        public Array<K> toArray() {
            return this.toArray(new Array(true, this.set.size));
        }
    }
}

