/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Collections;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntMap<V>
implements Iterable<Entry<V>> {
    public int size;
    int[] keyTable;
    V[] valueTable;
    V zeroValue;
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

    public IntMap() {
        this(51, 0.8f);
    }

    public IntMap(int initialCapacity) {
        this(initialCapacity, 0.8f);
    }

    public IntMap(int initialCapacity, float loadFactor) {
        if (loadFactor <= 0.0f || loadFactor >= 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + loadFactor);
        }
        this.loadFactor = loadFactor;
        int tableSize = ObjectSet.tableSize(initialCapacity, loadFactor);
        this.threshold = (int)((float)tableSize * loadFactor);
        this.mask = tableSize - 1;
        this.shift = Long.numberOfLeadingZeros(this.mask);
        this.keyTable = new int[tableSize];
        this.valueTable = new Object[tableSize];
    }

    public IntMap(IntMap<? extends V> map) {
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

    @Null
    public V put(int key, @Null V value) {
        if (key == 0) {
            V oldValue = this.zeroValue;
            this.zeroValue = value;
            if (!this.hasZeroValue) {
                this.hasZeroValue = true;
                ++this.size;
            }
            return oldValue;
        }
        int i = this.locateKey(key);
        if (i >= 0) {
            V oldValue = this.valueTable[i];
            this.valueTable[i] = value;
            return oldValue;
        }
        i = -(i + 1);
        this.keyTable[i] = key;
        this.valueTable[i] = value;
        if (++this.size >= this.threshold) {
            this.resize(this.keyTable.length << 1);
        }
        return null;
    }

    public void putAll(IntMap<? extends V> map) {
        this.ensureCapacity(map.size);
        if (map.hasZeroValue) {
            this.put(0, map.zeroValue);
        }
        int[] keyTable = map.keyTable;
        V[] valueTable = map.valueTable;
        int n = keyTable.length;
        for (int i = 0; i < n; ++i) {
            int key = keyTable[i];
            if (key == 0) continue;
            this.put(key, valueTable[i]);
        }
    }

    private void putResize(int key, @Null V value) {
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

    public V get(int key) {
        if (key == 0) {
            return this.hasZeroValue ? (V)this.zeroValue : null;
        }
        int i = this.locateKey(key);
        return i >= 0 ? (V)this.valueTable[i] : null;
    }

    public V get(int key, @Null V defaultValue) {
        if (key == 0) {
            return this.hasZeroValue ? this.zeroValue : defaultValue;
        }
        int i = this.locateKey(key);
        return i >= 0 ? this.valueTable[i] : defaultValue;
    }

    @Null
    public V remove(int key) {
        if (key == 0) {
            if (!this.hasZeroValue) {
                return null;
            }
            this.hasZeroValue = false;
            V oldValue = this.zeroValue;
            this.zeroValue = null;
            --this.size;
            return oldValue;
        }
        int i = this.locateKey(key);
        if (i < 0) {
            return null;
        }
        int[] keyTable = this.keyTable;
        V[] valueTable = this.valueTable;
        V oldValue = valueTable[i];
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
        valueTable[i] = null;
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
        this.zeroValue = null;
        this.resize(tableSize);
    }

    public void clear() {
        if (this.size == 0) {
            return;
        }
        this.size = 0;
        Arrays.fill(this.keyTable, 0);
        Arrays.fill(this.valueTable, null);
        this.zeroValue = null;
        this.hasZeroValue = false;
    }

    public boolean containsValue(@Null Object value, boolean identity) {
        V[] valueTable = this.valueTable;
        if (value == null) {
            if (this.hasZeroValue && this.zeroValue == null) {
                return true;
            }
            int[] keyTable = this.keyTable;
            for (int i = valueTable.length - 1; i >= 0; --i) {
                if (keyTable[i] == 0 || valueTable[i] != null) continue;
                return true;
            }
        } else if (identity) {
            if (value == this.zeroValue) {
                return true;
            }
            for (int i = valueTable.length - 1; i >= 0; --i) {
                if (valueTable[i] != value) continue;
                return true;
            }
        } else {
            if (this.hasZeroValue && value.equals(this.zeroValue)) {
                return true;
            }
            for (int i = valueTable.length - 1; i >= 0; --i) {
                if (!value.equals(valueTable[i])) continue;
                return true;
            }
        }
        return false;
    }

    public boolean containsKey(int key) {
        if (key == 0) {
            return this.hasZeroValue;
        }
        return this.locateKey(key) >= 0;
    }

    public int findKey(@Null Object value, boolean identity, int notFound) {
        V[] valueTable = this.valueTable;
        if (value == null) {
            if (this.hasZeroValue && this.zeroValue == null) {
                return 0;
            }
            int[] keyTable = this.keyTable;
            for (int i = valueTable.length - 1; i >= 0; --i) {
                if (keyTable[i] == 0 || valueTable[i] != null) continue;
                return keyTable[i];
            }
        } else if (identity) {
            if (value == this.zeroValue) {
                return 0;
            }
            for (int i = valueTable.length - 1; i >= 0; --i) {
                if (valueTable[i] != value) continue;
                return this.keyTable[i];
            }
        } else {
            if (this.hasZeroValue && value.equals(this.zeroValue)) {
                return 0;
            }
            for (int i = valueTable.length - 1; i >= 0; --i) {
                if (!value.equals(valueTable[i])) continue;
                return this.keyTable[i];
            }
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
        V[] oldValueTable = this.valueTable;
        this.keyTable = new int[newSize];
        this.valueTable = new Object[newSize];
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
        if (this.hasZeroValue && this.zeroValue != null) {
            h += this.zeroValue.hashCode();
        }
        int[] keyTable = this.keyTable;
        V[] valueTable = this.valueTable;
        int n = keyTable.length;
        for (int i = 0; i < n; ++i) {
            int key = keyTable[i];
            if (key == 0) continue;
            h += key * 31;
            V value = valueTable[i];
            if (value == null) continue;
            h += value.hashCode();
        }
        return h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IntMap)) {
            return false;
        }
        IntMap other = (IntMap)obj;
        if (other.size != this.size) {
            return false;
        }
        if (other.hasZeroValue != this.hasZeroValue) {
            return false;
        }
        if (this.hasZeroValue && (other.zeroValue == null ? this.zeroValue != null : !other.zeroValue.equals(this.zeroValue))) {
            return false;
        }
        int[] keyTable = this.keyTable;
        V[] valueTable = this.valueTable;
        int n = keyTable.length;
        for (int i = 0; i < n; ++i) {
            V value;
            int key = keyTable[i];
            if (key == 0 || !((value = valueTable[i]) == null ? other.get(key, ObjectMap.dummy) != null : !value.equals(other.get(key)))) continue;
            return false;
        }
        return true;
    }

    public boolean equalsIdentity(@Null Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IntMap)) {
            return false;
        }
        IntMap other = (IntMap)obj;
        if (other.size != this.size) {
            return false;
        }
        if (other.hasZeroValue != this.hasZeroValue) {
            return false;
        }
        if (this.hasZeroValue && this.zeroValue != other.zeroValue) {
            return false;
        }
        int[] keyTable = this.keyTable;
        V[] valueTable = this.valueTable;
        int n = keyTable.length;
        for (int i = 0; i < n; ++i) {
            int key = keyTable[i];
            if (key == 0 || valueTable[i] == other.get(key, ObjectMap.dummy)) continue;
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
        V[] valueTable = this.valueTable;
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
    public Iterator<Entry<V>> iterator() {
        return this.entries();
    }

    public Entries<V> entries() {
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

    public Values<V> values() {
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
        public Keys(IntMap map) {
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

    public static class Values<V>
    extends MapIterator<V>
    implements Iterable<V>,
    Iterator<V> {
        public Values(IntMap<V> map) {
            super(map);
        }

        @Override
        public boolean hasNext() {
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return this.hasNext;
        }

        @Override
        @Null
        public V next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            Object value = this.nextIndex == -1 ? this.map.zeroValue : this.map.valueTable[this.nextIndex];
            this.currentIndex = this.nextIndex;
            this.findNextIndex();
            return value;
        }

        @Override
        public Iterator<V> iterator() {
            return this;
        }

        public Array<V> toArray() {
            Array<V> array = new Array<V>(true, this.map.size);
            while (this.hasNext) {
                array.add(this.next());
            }
            return array;
        }
    }

    public static class Entries<V>
    extends MapIterator<V>
    implements Iterable<Entry<V>>,
    Iterator<Entry<V>> {
        private final Entry<V> entry = new Entry();

        public Entries(IntMap map) {
            super(map);
        }

        @Override
        public Entry<V> next() {
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
        public Iterator<Entry<V>> iterator() {
            return this;
        }
    }

    private static class MapIterator<V> {
        private static final int INDEX_ILLEGAL = -2;
        static final int INDEX_ZERO = -1;
        public boolean hasNext;
        final IntMap<V> map;
        int nextIndex;
        int currentIndex;
        boolean valid = true;

        public MapIterator(IntMap<V> map) {
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
                this.map.zeroValue = null;
            } else {
                int key;
                if (i < 0) {
                    throw new IllegalStateException("next must be called before remove.");
                }
                int[] keyTable = this.map.keyTable;
                V[] valueTable = this.map.valueTable;
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
                valueTable[i] = null;
                if (i != this.currentIndex) {
                    --this.nextIndex;
                }
            }
            this.currentIndex = -2;
            --this.map.size;
        }
    }

    public static class Entry<V> {
        public int key;
        @Null
        public V value;

        public String toString() {
            return this.key + "=" + this.value;
        }
    }
}

