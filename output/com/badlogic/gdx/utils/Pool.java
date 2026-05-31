/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Array;

public abstract class Pool<T> {
    public final int max;
    public int peak;
    private final Array<T> freeObjects;

    public Pool() {
        this(16, Integer.MAX_VALUE);
    }

    public Pool(int initialCapacity) {
        this(initialCapacity, Integer.MAX_VALUE);
    }

    public Pool(int initialCapacity, int max) {
        this.freeObjects = new Array(false, initialCapacity);
        this.max = max;
    }

    protected abstract T newObject();

    public T obtain() {
        return this.freeObjects.size == 0 ? this.newObject() : this.freeObjects.pop();
    }

    public void free(T object) {
        if (object == null) {
            throw new IllegalArgumentException("object cannot be null.");
        }
        if (this.freeObjects.size < this.max) {
            this.freeObjects.add(object);
            this.peak = Math.max(this.peak, this.freeObjects.size);
            this.reset(object);
        } else {
            this.discard(object);
        }
    }

    public void fill(int size) {
        for (int i = 0; i < size; ++i) {
            if (this.freeObjects.size >= this.max) continue;
            this.freeObjects.add(this.newObject());
        }
        this.peak = Math.max(this.peak, this.freeObjects.size);
    }

    protected void reset(T object) {
        if (object instanceof Poolable) {
            ((Poolable)object).reset();
        }
    }

    protected void discard(T object) {
    }

    public void freeAll(Array<T> objects) {
        if (objects == null) {
            throw new IllegalArgumentException("objects cannot be null.");
        }
        Array<T> freeObjects = this.freeObjects;
        int max = this.max;
        int n = objects.size;
        for (int i = 0; i < n; ++i) {
            T object = objects.get(i);
            if (object == null) continue;
            if (freeObjects.size < max) {
                freeObjects.add(object);
                this.reset(object);
                continue;
            }
            this.discard(object);
        }
        this.peak = Math.max(this.peak, freeObjects.size);
    }

    public void clear() {
        for (int i = 0; i < this.freeObjects.size; ++i) {
            T obj = this.freeObjects.pop();
            this.discard(obj);
        }
    }

    public int getFree() {
        return this.freeObjects.size;
    }

    public static interface Poolable {
        public void reset();
    }
}

