/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.libc;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class LibCStdlib {
    protected LibCStdlib() {
        throw new UnsupportedOperationException();
    }

    public static native long nmalloc(long var0);

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer malloc(@NativeType(value="size_t") long size) {
        long __result = LibCStdlib.nmalloc(size);
        return MemoryUtil.memByteBufferSafe(__result, (int)size);
    }

    public static native long ncalloc(long var0, long var2);

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer calloc(@NativeType(value="size_t") long nmemb, @NativeType(value="size_t") long size) {
        long __result = LibCStdlib.ncalloc(nmemb, size);
        return MemoryUtil.memByteBufferSafe(__result, (int)nmemb * (int)size);
    }

    public static native long nrealloc(long var0, long var2);

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer realloc(@Nullable @NativeType(value="void *") ByteBuffer ptr, @NativeType(value="size_t") long size) {
        long __result = LibCStdlib.nrealloc(MemoryUtil.memAddressSafe(ptr), size);
        return MemoryUtil.memByteBufferSafe(__result, (int)size);
    }

    public static native void nfree(long var0);

    public static void free(@Nullable @NativeType(value="void *") ByteBuffer ptr) {
        LibCStdlib.nfree(MemoryUtil.memAddressSafe(ptr));
    }

    public static void free(@Nullable @NativeType(value="void *") ShortBuffer ptr) {
        LibCStdlib.nfree(MemoryUtil.memAddressSafe(ptr));
    }

    public static void free(@Nullable @NativeType(value="void *") IntBuffer ptr) {
        LibCStdlib.nfree(MemoryUtil.memAddressSafe(ptr));
    }

    public static void free(@Nullable @NativeType(value="void *") LongBuffer ptr) {
        LibCStdlib.nfree(MemoryUtil.memAddressSafe(ptr));
    }

    public static void free(@Nullable @NativeType(value="void *") FloatBuffer ptr) {
        LibCStdlib.nfree(MemoryUtil.memAddressSafe(ptr));
    }

    public static void free(@Nullable @NativeType(value="void *") DoubleBuffer ptr) {
        LibCStdlib.nfree(MemoryUtil.memAddressSafe(ptr));
    }

    public static void free(@Nullable @NativeType(value="void *") PointerBuffer ptr) {
        LibCStdlib.nfree(MemoryUtil.memAddressSafe(ptr));
    }

    public static native long naligned_alloc(long var0, long var2);

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer aligned_alloc(@NativeType(value="size_t") long alignment, @NativeType(value="size_t") long size) {
        long __result = LibCStdlib.naligned_alloc(alignment, size);
        return MemoryUtil.memByteBufferSafe(__result, (int)size);
    }

    public static native void naligned_free(long var0);

    public static void aligned_free(@Nullable @NativeType(value="void *") ByteBuffer ptr) {
        LibCStdlib.naligned_free(MemoryUtil.memAddressSafe(ptr));
    }

    public static void aligned_free(@Nullable @NativeType(value="void *") ShortBuffer ptr) {
        LibCStdlib.naligned_free(MemoryUtil.memAddressSafe(ptr));
    }

    public static void aligned_free(@Nullable @NativeType(value="void *") IntBuffer ptr) {
        LibCStdlib.naligned_free(MemoryUtil.memAddressSafe(ptr));
    }

    public static void aligned_free(@Nullable @NativeType(value="void *") LongBuffer ptr) {
        LibCStdlib.naligned_free(MemoryUtil.memAddressSafe(ptr));
    }

    public static void aligned_free(@Nullable @NativeType(value="void *") FloatBuffer ptr) {
        LibCStdlib.naligned_free(MemoryUtil.memAddressSafe(ptr));
    }

    public static void aligned_free(@Nullable @NativeType(value="void *") DoubleBuffer ptr) {
        LibCStdlib.naligned_free(MemoryUtil.memAddressSafe(ptr));
    }

    public static void aligned_free(@Nullable @NativeType(value="void *") PointerBuffer ptr) {
        LibCStdlib.naligned_free(MemoryUtil.memAddressSafe(ptr));
    }

    static {
        Library.initialize();
    }
}

