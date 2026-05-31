/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Collections;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectSet;
import java.util.NoSuchElementException;

public class OrderedSet<T>
extends ObjectSet<T> {
    final Array<T> items;
    transient OrderedSetIterator iterator1;
    transient OrderedSetIterator iterator2;

    public OrderedSet() {
        this.items = new Array();
    }

    public OrderedSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
        this.items = new Array(initialCapacity);
    }

    public OrderedSet(int initialCapacity) {
        super(initialCapacity);
        this.items = new Array(initialCapacity);
    }

    public OrderedSet(OrderedSet<? extends T> set) {
        super(set);
        this.items = new Array<T>(set.items);
    }

    @Override
    public boolean add(T key) {
        if (!super.add(key)) {
            return false;
        }
        this.items.add(key);
        return true;
    }

    public boolean add(T key, int index) {
        if (!super.add(key)) {
            int oldIndex = this.items.indexOf(key, true);
            if (oldIndex != index) {
                this.items.insert(index, this.items.removeIndex(oldIndex));
            }
            return false;
        }
        this.items.insert(index, key);
        return true;
    }

    @Override
    public void addAll(OrderedSet<T> set) {
        this.ensureCapacity(set.size);
        T[] keys = set.items.items;
        int n = set.items.size;
        for (int i = 0; i < n; ++i) {
            this.add(keys[i]);
        }
    }

    @Override
    public boolean remove(T key) {
        if (!super.remove(key)) {
            return false;
        }
        this.items.removeValue(key, false);
        return true;
    }

    public T removeIndex(int index) {
        T key = this.items.removeIndex(index);
        super.remove(key);
        return key;
    }

    public boolean alter(T before, T after) {
        if (this.contains(after)) {
            return false;
        }
        if (!super.remove(before)) {
            return false;
        }
        super.add(after);
        this.items.set(this.items.indexOf(before, false), after);
        return true;
    }

    public boolean alterIndex(int index, T after) {
        if (index < 0 || index >= this.size || this.contains(after)) {
            return false;
        }
        super.remove(this.items.get(index));
        super.add(after);
        this.items.set(index, after);
        return true;
    }

    @Override
    public void clear(int maximumCapacity) {
        this.items.clear();
        super.clear(maximumCapacity);
    }

    @Override
    public void clear() {
        this.items.clear();
        super.clear();
    }

    public Array<T> orderedItems() {
        return this.items;
    }

    @Override
    public OrderedSetIterator<T> iterator() {
        if (Collections.allocateIterators) {
            return new OrderedSetIterator(this);
        }
        if (this.iterator1 == null) {
            this.iterator1 = new OrderedSetIterator(this);
            this.iterator2 = new OrderedSetIterator(this);
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

    @Override
    public String toString() {
        if (this.size == 0) {
            return "{}";
        }
        T[] items = this.items.items;
        StringBuilder buffer = new StringBuilder(32);
        buffer.append('{');
        buffer.append(items[0]);
        for (int i = 1; i < this.size; ++i) {
            buffer.append(", ");
            buffer.append(items[i]);
        }
        buffer.append('}');
        return buffer.toString();
    }

    @Override
    public String toString(String separator) {
        return this.items.toString(separator);
    }

    public static <T> OrderedSet<T> with(T ... array) {
        OrderedSet<T> set = new OrderedSet<T>();
        set.addAll(array);
        return set;
    }

    public static class OrderedSetIterator<K>
    extends ObjectSet.ObjectSetIterator<K> {
        private Array<K> items;

        public OrderedSetIterator(OrderedSet<K> set) {
            super(set);
            this.items = set.items;
        }

        @Override
        public void reset() {
            this.nextIndex = 0;
            this.hasNext = this.set.size > 0;
        }

        @Override
        public K next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            K key = this.items.get(this.nextIndex);
            ++this.nextIndex;
            this.hasNext = this.nextIndex < this.set.size;
            return key;
        }

        @Override
        public void remove() {
            if (this.nextIndex < 0) {
                throw new IllegalStateException("next must be called before remove.");
            }
            --this.nextIndex;
            ((OrderedSet)this.set).removeIndex(this.nextIndex);
        }

        @Override
        public Array<K> toArray(Array<K> array) {
            array.addAll(this.items, this.nextIndex, this.items.size - this.nextIndex);
            this.nextIndex = this.items.size;
            this.hasNext = false;
            return array;
        }

        @Override
        public Array<K> toArray() {
            return this.toArray(new Array(true, this.set.size - this.nextIndex));
        }
    }
}

