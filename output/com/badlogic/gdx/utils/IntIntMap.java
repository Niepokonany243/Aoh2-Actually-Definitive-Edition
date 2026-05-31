/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Collections;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.ObjectSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntIntMap
implements Iterable<Entry> {
    public int size;
    int[] keyTable;
    int[] valueTable;
    int zeroValue;
    boolean hasZeroValue;
    private final float loadFactor;
    private int threshold;
    protected int shift;
    protected int mask;
    private transient Entries entries1;
    private transient Entries entries2;
    private transient Values values1;
    private transient Values values2;
    private transient Keys keys1;
    private transient Keys keys2;

    public IntIntMap() {
        this(51, 0.8f);
    }

    public IntIntMap(int initialCapacity) {
        this(initialCapacity, 0.8f);
    }

    public IntIntMap(int initialCapacity, float loadFactor) {
        if (loadFactor <= 0.0f || loadFactor >= 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + loadFactor);
        }
        this.loadFactor = loadFactor;
        int tableSize = ObjectSet.tableSize(initialCapacity, loadFactor);
        this.threshold = (int)((float)tableSize * loadFactor);
        this.mask = tableSize - 1;
        this.shift = Long.numberOfLeadingZeros(this.mask);
        this.keyTable = new int[tableSize];
        this.valueTable = new int[tableSize];
    }

    public IntIntMap(IntIntMap map) {
        this((int)((float)map.keyTable.length * map.loadFactor), map.loadFactor);
        System.arraycopy(map.keyTable, 0, this.keyTable, 0, map.keyTable.length);
        System.arraycopy(map.valueTable, 0, this.valueTable, 0, map.valueTable.length);
        this.size = map.size;
        this.zeroValue = map.zeroValue;
        this.hasZeroValue = map.hasZeroValue;
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

    public void put(int key, int value) {
        if (key == 0) {
            this.zeroValue = value;
            if (!this.hasZeroValue) {
                this.hasZeroValue = true;
                ++this.size;
            }
            return;
        }
        int i = this.locateKey(key);
        if (i >= 0) {
            this.valueTable[i] = value;
            return;
        }
        i = -(i + 1);
        this.keyTable[i] = key;
        this.valueTable[i] = value;
        if (++this.size >= this.threshold) {
            this.resize(this.keyTable.length << 1);
        }
    }

    public int put(int key, int value, int defaultValue) {
        if (key == 0) {
            int oldValue = this.zeroValue;
            this.zeroValue = value;
            if (!this.hasZeroValue) {
                this.hasZeroValue = true;
                ++this.size;
                return defaultValue;
            }
            return oldValue;
        }
        int i = this.locateKey(key);
        if (i >= 0) {
            int oldValue = this.valueTable[i];
            this.valueTable[i] = value;
            return oldValue;
        }
        i = -(i + 1);
        this.keyTable[i] = key;
        this.valueTable[i] = value;
        if (++this.size >= this.threshold) {
            this.resize(this.keyTable.length << 1);
        }
        return defaultValue;
    }

    public void putAll(IntIntMap map) {
        this.ensureCapacity(map.size);
        if (map.hasZeroValue) {
            this.put(0, map.zeroValue);
        }
        int[] keyTable = map.keyTable;
        int[] valueTable = map.valueTable;
        int n = keyTable.length;
        for (int i = 0; i < n; ++i) {
            int key = keyTable[i];
            if (key == 0) continue;
            this.put(key, valueTable[i]);
        }
    }

    private void putResize(int key, int value) {
        int[] keyTable = this.keyTable;
        int i = this.place(key);
        while (true) {
            if (keyTable[i] == 0) {
                keyTable[i] = key;
                this.valueTable[i] = value;
                return;
            }
            i = i + 1 & this.mask;
        }
    }

    public int get(int key, int defaultValue) {
        if (key == 0) {
            return this.hasZeroValue ? this.zeroValue : defaultValue;
        }
        int i = this.locateKey(key);
        return i >= 0 ? this.valueTable[i] : defaultValue;
    }

    public int getAndIncrement(int key, int defaultValue, int increment) {
        if (key == 0) {
            if (!this.hasZeroValue) {
                this.hasZeroValue = true;
                this.zeroValue = defaultValue + increment;
                ++this.size;
                return defaultValue;
            }
            int oldValue = this.zeroValue;
            this.zeroValue += increment;
            return oldValue;
        }
        int i = this.locateKey(key);
        if (i >= 0) {
            int oldValue = this.valueTable[i];
            int n = i;
            this.valueTable[n] = this.valueTable[n] + increment;
            return oldValue;
        }
        i = -(i + 1);
        this.keyTable[i] = key;
        this.valueTable[i] = defaultValue + increment;
        if (++this.size >= this.threshold) {
            this.resize(this.keyTable.length << 1);
        }
        return defaultValue;
    }

    public int remove(int key, int defaultValue) {
        if (key == 0) {
            if (!this.hasZeroValue) {
                return defaultValue;
            }
            this.hasZeroValue = false;
            --this.size;
            return this.zeroValue;
        }
        int i = this.locateKey(key);
        if (i < 0) {
            return defaultValue;
        }
        int[] keyTable = this.keyTable;
        int[] valueTable = this.valueTable;
        int oldValue = valueTable[i];
        int mask = this.mask;
        int next = i + 1 & mask;
        while ((key = keyTable[next]) != 0) {
            int placement = this.place(key);
            if ((next - placement & mask) > (i - placement & mask)) {
                keyTable[i] = key;
                valueTable[i] = valueTable[next];
                i = next;
            }
            next = next + 1 & mask;
        }
        keyTable[i] = 0;
        --this.size;
        return oldValue;
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
        Arrays.fill(this.keyTable, 0);
        this.size = 0;
        this.hasZeroValue = false;
    }

    public boolean containsValue(int value) {
        if (this.hasZeroValue && this.zeroValue == value) {
            return true;
        }
        int[] keyTable = this.keyTable;
        int[] valueTable = this.valueTable;
        for (int i = valueTable.length - 1; i >= 0; --i) {
            if (keyTable[i] == 0 || valueTable[i] != value) continue;
            return true;
        }
        return false;
    }

    public boolean containsKey(int key) {
        if (key == 0) {
            return this.hasZeroValue;
        }
        return this.locateKey(key) >= 0;
    }

    public int findKey(int value, int notFound) {
        if (this.hasZeroValue && this.zeroValue == value) {
            return 0;
        }
        int[] keyTable = this.keyTable;
        int[] valueTable = this.valueTable;
        for (int i = valueTable.length - 1; i >= 0; --i) {
            int key = keyTable[i];
            if (key == 0 || valueTable[i] != value) continue;
            return key;
        }
        return notFound;
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
        int[] oldValueTable = this.valueTable;
        this.keyTable = new int[newSize];
        this.valueTable = new int[newSize];
        if (this.size > 0) {
            for (int i = 0; i < oldCapacity; ++i) {
                int key = oldKeyTable[i];
                if (key == 0) continue;
                this.putResize(key, oldValueTable[i]);
            }
        }
    }

    public int hashCode() {
        int h = this.size;
        if (this.hasZeroValue) {
            h += this.zeroValue;
        }
        int[] keyTable = this.keyTable;
        int[] valueTable = this.valueTable;
        int n = keyTable.length;
        for (int i = 0; i < n; ++i) {
            int key = keyTable[i];
            if (key == 0) continue;
            h += key * 31 + valueTable[i];
        }
        return h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IntIntMap)) {
            return false;
        }
        IntIntMap other = (IntIntMap)obj;
        if (other.size != this.size) {
            return false;
        }
        if (other.hasZeroValue != this.hasZeroValue) {
            return false;
        }
        if (this.hasZeroValue && other.zeroValue != this.zeroValue) {
            return false;
        }
        int[] keyTable = this.keyTable;
        int[] valueTable = this.valueTable;
        int n = keyTable.length;
        for (int i = 0; i < n; ++i) {
            int key = keyTable[i];
            if (key == 0) continue;
            int otherValue = other.get(key, 0);
            if (otherValue == 0 && !other.containsKey(key)) {
                return false;
            }
            if (otherValue == valueTable[i]) continue;
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
        int[] valueTable = this.valueTable;
        int i = keyTable.length;
        if (this.hasZeroValue) {
            buffer.append("0=");
            buffer.append(this.zeroValue);
        } else {
            while (i-- > 0) {
                key = keyTable[i];
                if (key == 0) continue;
                buffer.append(key);
                buffer.append('=');
                buffer.append(valueTable[i]);
                break;
            }
        }
        while (i-- > 0) {
            key = keyTable[i];
            if (key == 0) continue;
            buffer.append(", ");
            buffer.append(key);
            buffer.append('=');
            buffer.append(valueTable[i]);
        }
        buffer.append(']');
        return buffer.toString();
    }

    @Override
    public Iterator<Entry> iterator() {
        return this.entries();
    }

    public Entries entries() {
        if (Collections.allocateIterators) {
            return new Entries(this);
        }
        if (this.entries1 == null) {
            this.entries1 = new Entries(this);
            this.entries2 = new Entries(this);
        }
        if (!this.entries1.valid) {
            this.entries1.reset();
            this.entries1.valid = true;
            this.entries2.valid = false;
            return this.entries1;
        }
        this.entries2.reset();
        this.entries2.valid = true;
        this.entries1.valid = false;
        return this.entries2;
    }

    public Values values() {
        if (Collections.allocateIterators) {
            return new Values(this);
        }
        if (this.values1 == null) {
            this.values1 = new Values(this);
            this.values2 = new Values(this);
        }
        if (!this.values1.valid) {
            this.values1.reset();
            this.values1.valid = true;
            this.values2.valid = false;
            return this.values1;
        }
        this.values2.reset();
        this.values2.valid = true;
        this.values1.valid = false;
        return this.values2;
    }

    public Keys keys() {
        if (Collections.allocateIterators) {
            return new Keys(this);
        }
        if (this.keys1 == null) {
            this.keys1 = new Keys(this);
            this.keys2 = new Keys(this);
        }
        if (!this.keys1.valid) {
            this.keys1.reset();
            this.keys1.valid = true;
            this.keys2.valid = false;
            return this.keys1;
        }
        this.keys2.reset();
        this.keys2.valid = true;
        this.keys1.valid = false;
        return this.keys2;
    }

    public static class Keys
    extends MapIterator {
        public Keys(IntIntMap map) {
            super(map);
        }

        public int next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            int key = this.nextIndex == -1 ? 0 : this.map.keyTable[this.nextIndex];
            this.currentIndex = this.nextIndex;
            this.findNextIndex();
            return key;
        }

        public IntArray toArray() {
            IntArray array = new IntArray(true, this.map.size);
            while (this.hasNext) {
                array.add(this.next());
            }
            return array;
        }

        public IntArray toArray(IntArray array) {
            while (this.hasNext) {
                array.add(this.next());
            }
            return array;
        }
    }

    public static class Values
    extends MapIterator {
        public Values(IntIntMap map) {
            super(map);
        }

        public boolean hasNext() {
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return this.hasNext;
        }

        public int next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            int value = this.nextIndex == -1 ? this.map.zeroValue : this.map.valueTable[this.nextIndex];
            this.currentIndex = this.nextIndex;
            this.findNextIndex();
            return value;
        }

        public Values iterator() {
            return this;
        }

        public IntArray toArray() {
            IntArray array = new IntArray(true, this.map.size);
            while (this.hasNext) {
                array.add(this.next());
            }
            return array;
        }

        public IntArray toArray(IntArray array) {
            while (this.hasNext) {
                array.add(this.next());
            }
            return array;
        }
    }

    public static class Entries
    extends MapIterator
    implements Iterable<Entry>,
    Iterator<Entry> {
        private final Entry entry = new Entry();

        public Entries(IntIntMap map) {
            super(map);
        }

        @Override
        public Entry next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            int[] keyTable = this.map.keyTable;
            if (this.nextIndex == -1) {
                this.entry.key = 0;
                this.entry.value = this.map.zeroValue;
            } else {
                this.entry.key = keyTable[this.nextIndex];
                this.entry.value = this.map.valueTable[this.nextIndex];
            }
            this.currentIndex = this.nextIndex;
            this.findNextIndex();
            return this.entry;
        }

        @Override
        public boolean hasNext() {
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return this.hasNext;
        }

        @Override
        public Iterator<Entry> iterator() {
            return this;
        }
    }

    private static class MapIterator {
        private static final int INDEX_ILLEGAL = -2;
        static final int INDEX_ZERO = -1;
        public boolean hasNext;
        final IntIntMap map;
        int nextIndex;
        int currentIndex;
        boolean valid = true;

        public MapIterator(IntIntMap map) {
            this.map = map;
            this.reset();
        }

        public void reset() {
            this.currentIndex = -2;
            this.nextIndex = -1;
            if (this.map.hasZeroValue) {
                this.hasNext = true;
            } else {
                this.findNextIndex();
            }
        }

        void findNextIndex() {
            int[] keyTable = this.map.keyTable;
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
            if (i == -1 && this.map.hasZeroValue) {
                this.map.hasZeroValue = false;
            } else {
                int key;
                if (i < 0) {
                    throw new IllegalStateException("next must be called before remove.");
                }
                int[] keyTable = this.map.keyTable;
                int[] valueTable = this.map.valueTable;
                int mask = this.map.mask;
                int next = i + 1 & mask;
                while ((key = keyTable[next]) != 0) {
                    int placement = this.map.place(key);
                    if ((next - placement & mask) > (i - placement & mask)) {
                        keyTable[i] = key;
                        valueTable[i] = valueTable[next];
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
            --this.map.size;
        }
    }

    public static class Entry {
        public int key;
        public int value;

        public String toString() {
            return this.key + "=" + this.value;
        }
    }
}

