/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Collections;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.LongArray;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ObjectSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ObjectLongMap<K>
implements Iterable<Entry<K>> {
    public int size;
    K[] keyTable;
    long[] valueTable;
    float loadFactor;
    int threshold;
    protected int shift;
    protected int mask;
    transient Entries entries1;
    transient Entries entries2;
    transient Values values1;
    transient Values values2;
    transient Keys keys1;
    transient Keys keys2;

    public ObjectLongMap() {
        this(51, 0.8f);
    }

    public ObjectLongMap(int initialCapacity) {
        this(initialCapacity, 0.8f);
    }

    public ObjectLongMap(int initialCapacity, float loadFactor) {
        if (loadFactor <= 0.0f || loadFactor >= 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + loadFactor);
        }
        this.loadFactor = loadFactor;
        int tableSize = ObjectSet.tableSize(initialCapacity, loadFactor);
        this.threshold = (int)((float)tableSize * loadFactor);
        this.mask = tableSize - 1;
        this.shift = Long.numberOfLeadingZeros(this.mask);
        this.keyTable = new Object[tableSize];
        this.valueTable = new long[tableSize];
    }

    public ObjectLongMap(ObjectLongMap<? extends K> map) {
        this((int)((float)map.keyTable.length * map.loadFactor), map.loadFactor);
        System.arraycopy(map.keyTable, 0, this.keyTable, 0, map.keyTable.length);
        System.arraycopy(map.valueTable, 0, this.valueTable, 0, map.valueTable.length);
        this.size = map.size;
    }

    protected int place(K item) {
        return (int)((long)item.hashCode() * -7046029254386353131L >>> this.shift);
    }

    int locateKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null.");
        }
        K[] keyTable = this.keyTable;
        int i = this.place(key);
        K other;
        while ((other = keyTable[i]) != null) {
            if (other.equals(key)) {
                return i;
            }
            i = i + 1 & this.mask;
        }
        return -(i + 1);
    }

    public void put(K key, long value) {
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

    public long put(K key, long value, long defaultValue) {
        int i = this.locateKey(key);
        if (i >= 0) {
            long oldValue = this.valueTable[i];
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

    public void putAll(ObjectLongMap<? extends K> map) {
        this.ensureCapacity(map.size);
        K[] keyTable = map.keyTable;
        long[] valueTable = map.valueTable;
        int n = keyTable.length;
        for (int i = 0; i < n; ++i) {
            K key = keyTable[i];
            if (key == null) continue;
            this.put(key, valueTable[i]);
        }
    }

    private void putResize(K key, long value) {
        K[] keyTable = this.keyTable;
        int i = this.place(key);
        while (true) {
            if (keyTable[i] == null) {
                keyTable[i] = key;
                this.valueTable[i] = value;
                return;
            }
            i = i + 1 & this.mask;
        }
    }

    public long get(K key, long defaultValue) {
        int i = this.locateKey(key);
        return i < 0 ? defaultValue : this.valueTable[i];
    }

    public long getAndIncrement(K key, long defaultValue, long increment) {
        int i = this.locateKey(key);
        if (i >= 0) {
            long oldValue = this.valueTable[i];
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

    public long remove(K key, long defaultValue) {
        int i = this.locateKey(key);
        if (i < 0) {
            return defaultValue;
        }
        K[] keyTable = this.keyTable;
        long[] valueTable = this.valueTable;
        long oldValue = valueTable[i];
        int mask = this.mask;
        int next = i + 1 & mask;
        while ((key = keyTable[next]) != null) {
            int placement = this.place(key);
            if ((next - placement & mask) > (i - placement & mask)) {
                keyTable[i] = key;
                valueTable[i] = valueTable[next];
                i = next;
            }
            next = next + 1 & mask;
        }
        keyTable[i] = null;
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
        this.resize(tableSize);
    }

    public void clear() {
        if (this.size == 0) {
            return;
        }
        this.size = 0;
        Arrays.fill(this.keyTable, null);
    }

    public boolean containsValue(long value) {
        K[] keyTable = this.keyTable;
        long[] valueTable = this.valueTable;
        for (int i = valueTable.length - 1; i >= 0; --i) {
            if (keyTable[i] == null || valueTable[i] != value) continue;
            return true;
        }
        return false;
    }

    public boolean containsKey(K key) {
        return this.locateKey(key) >= 0;
    }

    @Null
    public K findKey(long value) {
        K[] keyTable = this.keyTable;
        long[] valueTable = this.valueTable;
        for (int i = valueTable.length - 1; i >= 0; --i) {
            K key = keyTable[i];
            if (key == null || valueTable[i] != value) continue;
            return key;
        }
        return null;
    }

    public void ensureCapacity(int additionalCapacity) {
        int tableSize = ObjectSet.tableSize(this.size + additionalCapacity, this.loadFactor);
        if (this.keyTable.length < tableSize) {
            this.resize(tableSize);
        }
    }

    final void resize(int newSize) {
        int oldCapacity = this.keyTable.length;
        this.threshold = (int)((float)newSize * this.loadFactor);
        this.mask = newSize - 1;
        this.shift = Long.numberOfLeadingZeros(this.mask);
        K[] oldKeyTable = this.keyTable;
        long[] oldValueTable = this.valueTable;
        this.keyTable = new Object[newSize];
        this.valueTable = new long[newSize];
        if (this.size > 0) {
            for (int i = 0; i < oldCapacity; ++i) {
                K key = oldKeyTable[i];
                if (key == null) continue;
                this.putResize(key, oldValueTable[i]);
            }
        }
    }

    public int hashCode() {
        int h = this.size;
        K[] keyTable = this.keyTable;
        long[] valueTable = this.valueTable;
        int n = keyTable.length;
        for (int i = 0; i < n; ++i) {
            K key = keyTable[i];
            if (key == null) continue;
            h = (int)((long)h + ((long)key.hashCode() + valueTable[i]));
        }
        return h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ObjectLongMap)) {
            return false;
        }
        ObjectLongMap other = (ObjectLongMap)obj;
        if (other.size != this.size) {
            return false;
        }
        K[] keyTable = this.keyTable;
        long[] valueTable = this.valueTable;
        int n = keyTable.length;
        for (int i = 0; i < n; ++i) {
            K key = keyTable[i];
            if (key == null) continue;
            long otherValue = other.get(key, 0L);
            if (otherValue == 0L && !other.containsKey(key)) {
                return false;
            }
            if (otherValue == valueTable[i]) continue;
            return false;
        }
        return true;
    }

    public String toString(String separator) {
        return this.toString(separator, false);
    }

    public String toString() {
        return this.toString(", ", true);
    }

    private String toString(String separator, boolean braces) {
        K key;
        if (this.size == 0) {
            return braces ? "{}" : "";
        }
        StringBuilder buffer = new StringBuilder(32);
        if (braces) {
            buffer.append('{');
        }
        K[] keyTable = this.keyTable;
        long[] valueTable = this.valueTable;
        int i = keyTable.length;
        while (i-- > 0) {
            key = keyTable[i];
            if (key == null) continue;
            buffer.append(key);
            buffer.append('=');
            buffer.append(valueTable[i]);
            break;
        }
        while (i-- > 0) {
            key = keyTable[i];
            if (key == null) continue;
            buffer.append(separator);
            buffer.append(key);
            buffer.append('=');
            buffer.append(valueTable[i]);
        }
        if (braces) {
            buffer.append('}');
        }
        return buffer.toString();
    }

    @Override
    public Entries<K> iterator() {
        return this.entries();
    }

    public Entries<K> entries() {
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
            return new Values((ObjectLongMap<?>)this);
        }
        if (this.values1 == null) {
            this.values1 = new Values((ObjectLongMap<?>)this);
            this.values2 = new Values((ObjectLongMap<?>)this);
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

    public Keys<K> keys() {
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

    public static class Keys<K>
    extends MapIterator<K>
    implements Iterable<K>,
    Iterator<K> {
        public Keys(ObjectLongMap<K> map) {
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
        public K next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            Object key = this.map.keyTable[this.nextIndex];
            this.currentIndex = this.nextIndex;
            this.findNextIndex();
            return key;
        }

        @Override
        public Keys<K> iterator() {
            return this;
        }

        public Array<K> toArray() {
            return this.toArray(new Array(true, this.map.size));
        }

        public Array<K> toArray(Array<K> array) {
            while (this.hasNext) {
                array.add(this.next());
            }
            return array;
        }
    }

    public static class Values
    extends MapIterator<Object> {
        public Values(ObjectLongMap<?> map) {
            super(map);
        }

        public boolean hasNext() {
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return this.hasNext;
        }

        public long next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            long value = this.map.valueTable[this.nextIndex];
            this.currentIndex = this.nextIndex;
            this.findNextIndex();
            return value;
        }

        public Values iterator() {
            return this;
        }

        public LongArray toArray() {
            LongArray array = new LongArray(true, this.map.size);
            while (this.hasNext) {
                array.add(this.next());
            }
            return array;
        }

        public LongArray toArray(LongArray array) {
            while (this.hasNext) {
                array.add(this.next());
            }
            return array;
        }
    }

    public static class Entries<K>
    extends MapIterator<K>
    implements Iterable<Entry<K>>,
    Iterator<Entry<K>> {
        Entry<K> entry = new Entry();

        public Entries(ObjectLongMap<K> map) {
            super(map);
        }

        @Override
        public Entry<K> next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            K[] keyTable = this.map.keyTable;
            this.entry.key = keyTable[this.nextIndex];
            this.entry.value = this.map.valueTable[this.nextIndex];
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
        public Entries<K> iterator() {
            return this;
        }
    }

    private static class MapIterator<K> {
        public boolean hasNext;
        final ObjectLongMap<K> map;
        int nextIndex;
        int currentIndex;
        boolean valid = true;

        public MapIterator(ObjectLongMap<K> map) {
            this.map = map;
            this.reset();
        }

        public void reset() {
            this.currentIndex = -1;
            this.nextIndex = -1;
            this.findNextIndex();
        }

        void findNextIndex() {
            K[] keyTable = this.map.keyTable;
            int n = keyTable.length;
            while (++this.nextIndex < n) {
                if (keyTable[this.nextIndex] == null) continue;
                this.hasNext = true;
                return;
            }
            this.hasNext = false;
        }

        public void remove() {
            Object key;
            int i = this.currentIndex;
            if (i < 0) {
                throw new IllegalStateException("next must be called before remove.");
            }
            K[] keyTable = this.map.keyTable;
            long[] valueTable = this.map.valueTable;
            int mask = this.map.mask;
            int next = i + 1 & mask;
            while ((key = keyTable[next]) != null) {
                int placement = this.map.place(key);
                if ((next - placement & mask) > (i - placement & mask)) {
                    keyTable[i] = key;
                    valueTable[i] = valueTable[next];
                    i = next;
                }
                next = next + 1 & mask;
            }
            keyTable[i] = null;
            --this.map.size;
            if (i != this.currentIndex) {
                --this.nextIndex;
            }
            this.currentIndex = -1;
        }
    }

    public static class Entry<K> {
        public K key;
        public long value;

        public String toString() {
            return this.key + "=" + this.value;
        }
    }
}

