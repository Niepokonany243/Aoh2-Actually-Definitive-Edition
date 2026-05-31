/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.ObjectMap;

public class IdentityMap<K, V>
extends ObjectMap<K, V> {
    public IdentityMap() {
    }

    public IdentityMap(int initialCapacity) {
        super(initialCapacity);
    }

    public IdentityMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public IdentityMap(IdentityMap<K, V> map) {
        super(map);
    }

    @Override
    protected int place(K item) {
        return (int)((long)System.identityHashCode(item) * -7046029254386353131L >>> this.shift);
    }

    @Override
    int locateKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null.");
        }
        Object[] keyTable = this.keyTable;
        int i = this.place(key);
        Object other;
        while ((other = keyTable[i]) != null) {
            if (other == key) {
                return i;
            }
            i = i + 1 & this.mask;
        }
        return -(i + 1);
    }

    @Override
    public int hashCode() {
        int h = this.size;
        Object[] keyTable = this.keyTable;
        Object[] valueTable = this.valueTable;
        int n = keyTable.length;
        for (int i = 0; i < n; ++i) {
            Object key = keyTable[i];
            if (key == null) continue;
            h += System.identityHashCode(key);
            Object value = valueTable[i];
            if (value == null) continue;
            h += value.hashCode();
        }
        return h;
    }
}

