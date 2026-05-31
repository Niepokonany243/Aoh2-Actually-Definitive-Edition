/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.jemalloc;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.jemalloc.JEmalloc;

public class JEmallocAllocator
implements MemoryUtil.MemoryAllocator {
    @Override
    public long getMalloc() {
        return JEmalloc.Functions.malloc;
    }

    @Override
    public long getCalloc() {
        return JEmalloc.Functions.calloc;
    }

    @Override
    public long getRealloc() {
        return JEmalloc.Functions.realloc;
    }

    @Override
    public long getFree() {
        return JEmalloc.Functions.free;
    }

    @Override
    public long getAlignedAlloc() {
        return JEmalloc.Functions.aligned_alloc;
    }

    @Override
    public long getAlignedFree() {
        return JEmalloc.Functions.free;
    }

    @Override
    public long malloc(long size) {
        return JEmalloc.nje_malloc(size);
    }

    @Override
    public long calloc(long num, long size) {
        return JEmalloc.nje_calloc(num, size);
    }

    @Override
    public long realloc(long ptr, long size) {
        return JEmalloc.nje_realloc(ptr, size);
    }

    @Override
    public void free(long ptr) {
        JEmalloc.nje_free(ptr);
    }

    @Override
    public long aligned_alloc(long alignment, long size) {
        return JEmalloc.nje_aligned_alloc(alignment, size);
    }

    @Override
    public void aligned_free(long ptr) {
        JEmalloc.nje_free(ptr);
    }

    static {
        JEmalloc.getLibrary();
    }
}

