/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Collections;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.ObjectSet;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class IntSet {
    public int size;
    int[] keyTable;
    boolean hasZeroValue;
    private final float loadFactor;
    private int threshold;
    protected int shift;
    protected int mask;
    private transient IntSetIterator iterator1;
    private transient IntSetIterator iterator2;

    public IntSet() {
        this(51, 0.8f);
    }

    public IntSet(int initialCapacity) {
        this(initialCapacity, 0.8f);
    }

    public IntSet(int initialCapacity, float loadFactor) {
        if (loadFactor <= 0.0f || loadFactor >= 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + loadFactor);
        }
        this.loadFactor = loadFactor;
        int tableSize = ObjectSet.tableSize(initialCapacity, loadFactor);
        this.threshold = (int)((float)tableSize * loadFactor);
        this.mask = tableSize - 1;
        this.shift = Long.numberOfLeadingZeros(this.mask);
        this.keyTable = new int[tableSize];
    }

    public IntSet(IntSet set) {
        this((int)((float)set.keyTable.length * set.loadFactor), set.loadFactor);
        System.arraycopy(set.keyTable, 0, this.keyTable, 0, set.keyTable.length);
        this.size = set.size;
        this.hasZeroValue = set.hasZeroValue;
    }

    protected int place(int item) {
        return (int)((long)item * -7046029254386353131L >>> this.shift);
    }

    private int locateKey(int key) {
        int[] keyTable = this.keyTable;
        int i = this.place(key);
        int other;
        while ((other = keyTable[i]) != 0) {
            if (other == key) {
                return i;
            }
            i = i + 1 & this.mask;
        }
        return -(i + 1);
    }

    public boolean add(int key) {
        if (key == 0) {
            if (this.hasZeroValue) {
                return false;
            }
            this.hasZeroValue = true;
            ++this.size;
            return true;
        }
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

    public void addAll(IntArray array) {
        this.addAll(array.items, 0, array.size);
    }

    public void addAll(IntArray array, int offset, int length) {
        if (offset + length > array.size) {
            throw new IllegalArgumentException("offset + length must be <= size: " + offset + " + " + length + " <= " + array.size);
        }
        this.addAll(array.items, offset, length);
    }

    public void addAll(int ... array) {
        this.addAll(array, 0, array.length);
    }

    public void addAll(int[] array, int offset, int length) {
        int i;
        this.ensureCapacity(length);
        int n = i + length;
        for (i = offset; i < n; ++i) {
            this.add(array[i]);
        }
    }

    public void addAll(IntSet set) {
        this.ensureCapacity(set.size);
        if (set.hasZeroValue) {
            this.add(0);
        }
        for (int key : set.keyTable) {
            if (key == 0) continue;
            this.add(key);
        }
    }

    private void addResize(int key) {
        int[] keyTable = this.keyTable;
        int i = this.place(key);
        while (true) {
            if (keyTable[i] == 0) {
                keyTable[i] = key;
                return;
            }
            i = i + 1 & this.mask;
        }
    }

    public boolean remove(int key) {
        if (key == 0) {
            if (!this.hasZeroValue) {
                return false;
            }
            this.hasZeroValue = false;
            --this.size;
            return true;
        }
        int i = this.locateKey(key);
        if (i < 0) {
            return false;
        }
        int[] keyTable = this.keyTable;
        int mask = this.mask;
        int next = i + 1 & mask;
        while ((key = keyTable[next]) != 0) {
            int placement = this.place(key);
            if ((next - placement & mask) > (i - placement & mask)) {
                keyTable[i] = key;
                i = next;
            }
            next = next + 1 & mask;
        }
        keyTable[i] = 0;
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
        this.hasZeroValue = false;
        this.resize(tableSize);
    }

    public void clear() {
        if (this.size == 0) {
            return;
        }
        this.size = 0;
        Arrays.fill(this.keyTable, 0);
        this.hasZeroValue = false;
    }

    public boolean contains(int key) {
        if (key == 0) {
            return this.hasZeroValue;
        }
        return this.locateKey(key) >= 0;
    }

    public int first() {
        if (this.hasZeroValue) {
            return 0;
        }
        int[] keyTable = this.keyTable;
        int n = keyTable.length;
        for (int i = 0; i < n; ++i) {
            if (keyTable[i] == 0) continue;
            return keyTable[i];
        }
        throw new IllegalStateException("IntSet is empty.");
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
        int[] oldKeyTable = this.keyTable;
        this.keyTable = new int[newSize];
        if (this.size > 0) {
            for (int i = 0; i < oldCapacity; ++i) {
                int key = oldKeyTable[i];
                if (key == 0) continue;
                this.addResize(key);
            }
        }
    }

    public int hashCode() {
        int h = this.size;
        for (int key : this.keyTable) {
            if (key == 0) continue;
            h += key;
        }
        return h;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IntSet)) {
            return false;
        }
        IntSet other = (IntSet)obj;
        if (other.size != this.size) {
            return false;
        }
        if (other.hasZeroValue != this.hasZeroValue) {
            return false;
        }
        int[] keyTable = this.keyTable;
        int n = keyTable.length;
        for (int i = 0; i < n; ++i) {
            if (keyTable[i] == 0 || other.contains(keyTable[i])) continue;
            return false;
        }
        return true;
    }

    public String toString() {
        int key;
        if (this.size == 0) {
            return "[]";
        }
        StringBuilder buffer = new StringBuilder(32);
        buffer.append('[');
        int[] keyTable = this.keyTable;
        int i = keyTable.length;
        if (this.hasZeroValue) {
            buffer.append("0");
        } else {
            while (i-- > 0) {
                key = keyTable[i];
                if (key == 0) continue;
                buffer.append(key);
                break;
            }
        }
        while (i-- > 0) {
            key = keyTable[i];
            if (key == 0) continue;
            buffer.append(", ");
            buffer.append(key);
        }
        buffer.append(']');
        return buffer.toString();
    }

    public IntSetIterator iterator() {
        if (Collections.allocateIterators) {
            return new IntSetIterator(this);
        }
        if (this.iterator1 == null) {
            this.iterator1 = new IntSetIterator(this);
            this.iterator2 = new IntSetIterator(this);
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

    public static IntSet with(int ... array) {
        IntSet set = new IntSet();
        set.addAll(array);
        return set;
    }

    public static class IntSetIterator {
        private static final int INDEX_ILLEGAL = -2;
        private static final int INDEX_ZERO = -1;
        public boolean hasNext;
        final IntSet set;
        int nextIndex;
        int currentIndex;
        boolean valid = true;

        public IntSetIterator(IntSet set) {
            this.set = set;
            this.reset();
        }

        public void reset() {
            this.currentIndex = -2;
            this.nextIndex = -1;
            if (this.set.hasZeroValue) {
                this.hasNext = true;
            } else {
                this.findNextIndex();
            }
        }

        void findNextIndex() {
            int[] keyTable = this.set.keyTable;
            int n = keyTable.length;
            while (++this.nextIndex < n) {
                if (keyTable[this.nextIndex] == 0) continue;
                this.hasNext = true;
                return;
            }
            this.hasNext = false;
        }

        public void remove() {
            int i = this.currentIndex;
            if (i == -1 && this.set.hasZeroValue) {
                this.set.hasZeroValue = false;
            } else {
                int key;
                if (i < 0) {
                    throw new IllegalStateException("next must be called before remove.");
                }
                int[] keyTable = this.set.keyTable;
                int mask = this.set.mask;
                int next = i + 1 & mask;
                while ((key = keyTable[next]) != 0) {
                    int placement = this.set.place(key);
                    if ((next - placement & mask) > (i - placement & mask)) {
                        keyTable[i] = key;
                        i = next;
                    }
                    next = next + 1 & mask;
                }
                keyTable[i] = 0;
                if (i != this.currentIndex) {
                    --this.nextIndex;
                }
            }
            this.currentIndex = -2;
            --this.set.size;
        }

        public int next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            int key = this.nextIndex == -1 ? 0 : this.set.keyTable[this.nextIndex];
            this.currentIndex = this.nextIndex;
            this.findNextIndex();
            return key;
        }

        public IntArray toArray() {
            IntArray array = new IntArray(true, this.set.size);
            while (this.hasNext) {
                array.add(this.next());
            }
            return array;
        }
    }
}

