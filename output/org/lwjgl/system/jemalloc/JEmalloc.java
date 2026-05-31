/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.jemalloc;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.JNI;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Platform;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.jemalloc.MallocMessageCallbackI;

public class JEmalloc {
    public static final int JEMALLOC_VERSION_MAJOR = 5;
    public static final int JEMALLOC_VERSION_MINOR = 2;
    public static final int JEMALLOC_VERSION_BUGFIX = 0;
    public static final int JEMALLOC_VERSION_NREV = 0;
    public static final String JEMALLOC_VERSION_GID = "b0b3e49a54ec29e32636f4577d9d5a896d67fd20";
    public static final String JEMALLOC_VERSION = "5.2.0-0-gb0b3e49a54ec29e32636f4577d9d5a896d67fd20";
    public static final int MALLOCX_ZERO = 64;
    public static final int MALLOCX_TCACHE_NONE = JEmalloc.MALLOCX_TCACHE(-1);
    public static final int MALLCTL_ARENAS_ALL = 4096;
    public static final int MALLCTL_ARENAS_DESTROYED = 4097;
    private static final SharedLibrary JEMALLOC = Library.loadNative(JEmalloc.class, "org.lwjgl.jemalloc", Configuration.JEMALLOC_LIBRARY_NAME.get(Platform.mapLibraryNameBundled("jemalloc")), true);

    protected JEmalloc() {
        throw new UnsupportedOperationException();
    }

    public static SharedLibrary getLibrary() {
        return JEMALLOC;
    }

    @NativeType(value="void (*) (void *, char const *) *")
    public static PointerBuffer je_malloc_message() {
        long __result = Functions.malloc_message;
        return MemoryUtil.memPointerBuffer(__result, 1);
    }

    public static long nje_malloc(long size) {
        long __functionAddress = Functions.malloc;
        return JNI.invokePP(size, __functionAddress);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer je_malloc(@NativeType(value="size_t") long size) {
        long __result = JEmalloc.nje_malloc(size);
        return MemoryUtil.memByteBufferSafe(__result, (int)size);
    }

    public static long nje_calloc(long num, long size) {
        long __functionAddress = Functions.calloc;
        return JNI.invokePPP(num, size, __functionAddress);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer je_calloc(@NativeType(value="size_t") long num, @NativeType(value="size_t") long size) {
        long __result = JEmalloc.nje_calloc(num, size);
        return MemoryUtil.memByteBufferSafe(__result, (int)num * (int)size);
    }

    public static int nje_posix_memalign(long memptr, long alignment, long size) {
        long __functionAddress = Functions.posix_memalign;
        return JNI.invokePPPI(memptr, alignment, size, __functionAddress);
    }

    public static int je_posix_memalign(@NativeType(value="void **") PointerBuffer memptr, @NativeType(value="size_t") long alignment, @NativeType(value="size_t") long size) {
        if (Checks.CHECKS) {
            Checks.check(memptr, 1);
        }
        return JEmalloc.nje_posix_memalign(MemoryUtil.memAddress(memptr), alignment, size);
    }

    public static long nje_aligned_alloc(long alignment, long size) {
        long __functionAddress = Functions.aligned_alloc;
        return JNI.invokePPP(alignment, size, __functionAddress);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer je_aligned_alloc(@NativeType(value="size_t") long alignment, @NativeType(value="size_t") long size) {
        long __result = JEmalloc.nje_aligned_alloc(alignment, size);
        return MemoryUtil.memByteBufferSafe(__result, (int)size);
    }

    public static long nje_realloc(long ptr, long size) {
        long __functionAddress = Functions.realloc;
        return JNI.invokePPP(ptr, size, __functionAddress);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer je_realloc(@Nullable @NativeType(value="void *") ByteBuffer ptr, @NativeType(value="size_t") long size) {
        long __result = JEmalloc.nje_realloc(MemoryUtil.memAddressSafe(ptr), size);
        return MemoryUtil.memByteBufferSafe(__result, (int)size);
    }

    public static void nje_free(long ptr) {
        long __functionAddress = Functions.free;
        JNI.invokePV(ptr, __functionAddress);
    }

    public static void je_free(@Nullable @NativeType(value="void *") ByteBuffer ptr) {
        JEmalloc.nje_free(MemoryUtil.memAddressSafe(ptr));
    }

    public static void je_free(@Nullable @NativeType(value="void *") ShortBuffer ptr) {
        JEmalloc.nje_free(MemoryUtil.memAddressSafe(ptr));
    }

    public static void je_free(@Nullable @NativeType(value="void *") IntBuffer ptr) {
        JEmalloc.nje_free(MemoryUtil.memAddressSafe(ptr));
    }

    public static void je_free(@Nullable @NativeType(value="void *") LongBuffer ptr) {
        JEmalloc.nje_free(MemoryUtil.memAddressSafe(ptr));
    }

    public static void je_free(@Nullable @NativeType(value="void *") FloatBuffer ptr) {
        JEmalloc.nje_free(MemoryUtil.memAddressSafe(ptr));
    }

    public static void je_free(@Nullable @NativeType(value="void *") DoubleBuffer ptr) {
        JEmalloc.nje_free(MemoryUtil.memAddressSafe(ptr));
    }

    public static void je_free(@Nullable @NativeType(value="void *") PointerBuffer ptr) {
        JEmalloc.nje_free(MemoryUtil.memAddressSafe(ptr));
    }

    public static long nje_mallocx(long size, int flags) {
        long __functionAddress = Functions.mallocx;
        return JNI.invokePP(size, flags, __functionAddress);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer je_mallocx(@NativeType(value="size_t") long size, int flags) {
        long __result = JEmalloc.nje_mallocx(size, flags);
        return MemoryUtil.memByteBufferSafe(__result, (int)size);
    }

    public static long nje_rallocx(long ptr, long size, int flags) {
        long __functionAddress = Functions.rallocx;
        return JNI.invokePPP(ptr, size, flags, __functionAddress);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer je_rallocx(@Nullable @NativeType(value="void *") ByteBuffer ptr, @NativeType(value="size_t") long size, int flags) {
        long __result = JEmalloc.nje_rallocx(MemoryUtil.memAddressSafe(ptr), size, flags);
        return MemoryUtil.memByteBufferSafe(__result, (int)size);
    }

    public static long nje_xallocx(long ptr, long size, long extra, int flags) {
        long __functionAddress = Functions.xallocx;
        return JNI.invokePPPP(ptr, size, extra, flags, __functionAddress);
    }

    @NativeType(value="size_t")
    public static long je_xallocx(@Nullable @NativeType(value="void *") ByteBuffer ptr, @NativeType(value="size_t") long size, @NativeType(value="size_t") long extra, int flags) {
        return JEmalloc.nje_xallocx(MemoryUtil.memAddressSafe(ptr), size, extra, flags);
    }

    public static long nje_sallocx(long ptr, int flags) {
        long __functionAddress = Functions.sallocx;
        return JNI.invokePP(ptr, flags, __functionAddress);
    }

    @NativeType(value="size_t")
    public static long je_sallocx(@NativeType(value="void const *") ByteBuffer ptr, int flags) {
        return JEmalloc.nje_sallocx(MemoryUtil.memAddress(ptr), flags);
    }

    public static void nje_dallocx(long ptr, int flags) {
        long __functionAddress = Functions.dallocx;
        JNI.invokePV(ptr, flags, __functionAddress);
    }

    public static void je_dallocx(@NativeType(value="void *") ByteBuffer ptr, int flags) {
        JEmalloc.nje_dallocx(MemoryUtil.memAddress(ptr), flags);
    }

    public static void je_dallocx(@NativeType(value="void *") ShortBuffer ptr, int flags) {
        JEmalloc.nje_dallocx(MemoryUtil.memAddress(ptr), flags);
    }

    public static void je_dallocx(@NativeType(value="void *") IntBuffer ptr, int flags) {
        JEmalloc.nje_dallocx(MemoryUtil.memAddress(ptr), flags);
    }

    public static void je_dallocx(@NativeType(value="void *") LongBuffer ptr, int flags) {
        JEmalloc.nje_dallocx(MemoryUtil.memAddress(ptr), flags);
    }

    public static void je_dallocx(@NativeType(value="void *") FloatBuffer ptr, int flags) {
        JEmalloc.nje_dallocx(MemoryUtil.memAddress(ptr), flags);
    }

    public static void je_dallocx(@NativeType(value="void *") DoubleBuffer ptr, int flags) {
        JEmalloc.nje_dallocx(MemoryUtil.memAddress(ptr), flags);
    }

    public static void je_dallocx(@NativeType(value="void *") PointerBuffer ptr, int flags) {
        JEmalloc.nje_dallocx(MemoryUtil.memAddress(ptr), flags);
    }

    public static void nje_sdallocx(long ptr, long size, int flags) {
        long __functionAddress = Functions.sdallocx;
        JNI.invokePPV(ptr, size, flags, __functionAddress);
    }

    public static void je_sdallocx(@NativeType(value="void *") ByteBuffer ptr, int flags) {
        JEmalloc.nje_sdallocx(MemoryUtil.memAddress(ptr), ptr.remaining(), flags);
    }

    public static void je_sdallocx(@NativeType(value="void *") ShortBuffer ptr, int flags) {
        JEmalloc.nje_sdallocx(MemoryUtil.memAddress(ptr), Integer.toUnsignedLong(ptr.remaining()) << 1, flags);
    }

    public static void je_sdallocx(@NativeType(value="void *") IntBuffer ptr, int flags) {
        JEmalloc.nje_sdallocx(MemoryUtil.memAddress(ptr), Integer.toUnsignedLong(ptr.remaining()) << 2, flags);
    }

    public static void je_sdallocx(@NativeType(value="void *") LongBuffer ptr, int flags) {
        JEmalloc.nje_sdallocx(MemoryUtil.memAddress(ptr), Integer.toUnsignedLong(ptr.remaining()) << 3, flags);
    }

    public static void je_sdallocx(@NativeType(value="void *") FloatBuffer ptr, int flags) {
        JEmalloc.nje_sdallocx(MemoryUtil.memAddress(ptr), Integer.toUnsignedLong(ptr.remaining()) << 2, flags);
    }

    public static void je_sdallocx(@NativeType(value="void *") DoubleBuffer ptr, int flags) {
        JEmalloc.nje_sdallocx(MemoryUtil.memAddress(ptr), Integer.toUnsignedLong(ptr.remaining()) << 3, flags);
    }

    public static void je_sdallocx(@NativeType(value="void *") PointerBuffer ptr, int flags) {
        JEmalloc.nje_sdallocx(MemoryUtil.memAddress(ptr), Integer.toUnsignedLong(ptr.remaining()) << Pointer.POINTER_SHIFT, flags);
    }

    public static long nje_nallocx(long size, int flags) {
        long __functionAddress = Functions.nallocx;
        return JNI.invokePP(size, flags, __functionAddress);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer je_nallocx(@NativeType(value="size_t") long size, int flags) {
        long __result = JEmalloc.nje_nallocx(size, flags);
        return MemoryUtil.memByteBufferSafe(__result, (int)size);
    }

    public static int nje_mallctl(long name, long oldp, long oldlenp, long newp, long newlen) {
        long __functionAddress = Functions.mallctl;
        return JNI.invokePPPPPI(name, oldp, oldlenp, newp, newlen, __functionAddress);
    }

    public static int je_mallctl(@NativeType(value="char const *") ByteBuffer name, @Nullable @NativeType(value="void *") ByteBuffer oldp, @Nullable @NativeType(value="size_t *") PointerBuffer oldlenp, @Nullable @NativeType(value="void *") ByteBuffer newp) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
            Checks.checkSafe(oldlenp, 1);
        }
        return JEmalloc.nje_mallctl(MemoryUtil.memAddress(name), MemoryUtil.memAddressSafe(oldp), MemoryUtil.memAddressSafe(oldlenp), MemoryUtil.memAddressSafe(newp), Checks.remainingSafe(newp));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int je_mallctl(@NativeType(value="char const *") CharSequence name, @Nullable @NativeType(value="void *") ByteBuffer oldp, @Nullable @NativeType(value="size_t *") PointerBuffer oldlenp, @Nullable @NativeType(value="void *") ByteBuffer newp) {
        if (Checks.CHECKS) {
            Checks.checkSafe(oldlenp, 1);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(name, true);
            long nameEncoded = stack.getPointerAddress();
            int n = JEmalloc.nje_mallctl(nameEncoded, MemoryUtil.memAddressSafe(oldp), MemoryUtil.memAddressSafe(oldlenp), MemoryUtil.memAddressSafe(newp), Checks.remainingSafe(newp));
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static int nje_mallctlnametomib(long name, long mibp, long miblenp) {
        long __functionAddress = Functions.mallctlnametomib;
        return JNI.invokePPPI(name, mibp, miblenp, __functionAddress);
    }

    public static int je_mallctlnametomib(@NativeType(value="char const *") ByteBuffer name, @NativeType(value="size_t *") PointerBuffer mibp, @NativeType(value="size_t *") PointerBuffer miblenp) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
            Checks.check(miblenp, 1);
            Checks.check(mibp, miblenp.get(miblenp.position()));
        }
        return JEmalloc.nje_mallctlnametomib(MemoryUtil.memAddress(name), MemoryUtil.memAddress(mibp), MemoryUtil.memAddress(miblenp));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int je_mallctlnametomib(@NativeType(value="char const *") CharSequence name, @NativeType(value="size_t *") PointerBuffer mibp, @NativeType(value="size_t *") PointerBuffer miblenp) {
        if (Checks.CHECKS) {
            Checks.check(miblenp, 1);
            Checks.check(mibp, miblenp.get(miblenp.position()));
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(name, true);
            long nameEncoded = stack.getPointerAddress();
            int n = JEmalloc.nje_mallctlnametomib(nameEncoded, MemoryUtil.memAddress(mibp), MemoryUtil.memAddress(miblenp));
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static int nje_mallctlbymib(long mib, long miblen, long oldp, long oldlenp, long newp, long newlen) {
        long __functionAddress = Functions.mallctlbymib;
        return JNI.invokePPPPPPI(mib, miblen, oldp, oldlenp, newp, newlen, __functionAddress);
    }

    public static int je_mallctlbymib(@NativeType(value="size_t const *") PointerBuffer mib, @Nullable @NativeType(value="void *") ByteBuffer oldp, @Nullable @NativeType(value="size_t *") PointerBuffer oldlenp, @Nullable @NativeType(value="void *") ByteBuffer newp) {
        if (Checks.CHECKS) {
            Checks.checkSafe(oldlenp, 1);
        }
        return JEmalloc.nje_mallctlbymib(MemoryUtil.memAddress(mib), mib.remaining(), MemoryUtil.memAddressSafe(oldp), MemoryUtil.memAddressSafe(oldlenp), MemoryUtil.memAddressSafe(newp), Checks.remainingSafe(newp));
    }

    public static void nje_malloc_stats_print(long write_cb, long cbopaque, long opts) {
        long __functionAddress = Functions.malloc_stats_print;
        JNI.invokePPPV(write_cb, cbopaque, opts, __functionAddress);
    }

    public static void je_malloc_stats_print(@Nullable @NativeType(value="void (*) (void *, char const *)") MallocMessageCallbackI write_cb, @NativeType(value="void *") long cbopaque, @Nullable @NativeType(value="char const *") ByteBuffer opts) {
        if (Checks.CHECKS) {
            Checks.checkNT1Safe(opts);
        }
        JEmalloc.nje_malloc_stats_print(MemoryUtil.memAddressSafe(write_cb), cbopaque, MemoryUtil.memAddressSafe(opts));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void je_malloc_stats_print(@Nullable @NativeType(value="void (*) (void *, char const *)") MallocMessageCallbackI write_cb, @NativeType(value="void *") long cbopaque, @Nullable @NativeType(value="char const *") CharSequence opts) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCIISafe(opts, true);
            long optsEncoded = opts == null ? 0L : stack.getPointerAddress();
            JEmalloc.nje_malloc_stats_print(MemoryUtil.memAddressSafe(write_cb), cbopaque, optsEncoded);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nje_malloc_usable_size(long ptr) {
        long __functionAddress = Functions.malloc_usable_size;
        return JNI.invokePP(ptr, __functionAddress);
    }

    @NativeType(value="size_t")
    public static long je_malloc_usable_size(@NativeType(value="void const *") ByteBuffer ptr) {
        return JEmalloc.nje_malloc_usable_size(MemoryUtil.memAddress(ptr));
    }

    public static int MALLOCX_LG_ALIGN(int la) {
        return la;
    }

    public static int MALLOCX_ALIGN(int a) {
        return Integer.numberOfTrailingZeros(a);
    }

    public static int MALLOCX_TCACHE(int tc) {
        return tc + 2 << 8;
    }

    public static int MALLOCX_ARENA(int a) {
        return a + 1 << 20;
    }

    static /* synthetic */ SharedLibrary access$000() {
        return JEMALLOC;
    }

    static {
        if (Platform.get() == Platform.WINDOWS) {
            JEmalloc.nje_free(JEmalloc.nje_malloc(8L));
        }
    }

    public static final class Functions {
        public static final long malloc_message = APIUtil.apiGetFunctionAddress(JEmalloc.access$000(), "je_malloc_message");
        public static final long malloc = APIUtil.apiGetFunctionAddress(JEmalloc.access$000(), "je_malloc");
        public static final long calloc = APIUtil.apiGetFunctionAddress(JEmalloc.access$000(), "je_calloc");
        public static final long posix_memalign = APIUtil.apiGetFunctionAddress(JEmalloc.access$000(), "je_posix_memalign");
        public static final long aligned_alloc = APIUtil.apiGetFunctionAddress(JEmalloc.access$000(), "je_aligned_alloc");
        public static final long realloc = APIUtil.apiGetFunctionAddress(JEmalloc.access$000(), "je_realloc");
        public static final long free = APIUtil.apiGetFunctionAddress(JEmalloc.access$000(), "je_free");
        public static final long mallocx = APIUtil.apiGetFunctionAddress(JEmalloc.access$000(), "je_mallocx");
        public static final long rallocx = APIUtil.apiGetFunctionAddress(JEmalloc.access$000(), "je_rallocx");
        public static final long xallocx = APIUtil.apiGetFunctionAddress(JEmalloc.access$000(), "je_xallocx");
        public static final long sallocx = APIUtil.apiGetFunctionAddress(JEmalloc.access$000(), "je_sallocx");
        public static final long dallocx = APIUtil.apiGetFunctionAddress(JEmalloc.access$000(), "je_dallocx");
        public static final long sdallocx = APIUtil.apiGetFunctionAddress(JEmalloc.access$000(), "je_sdallocx");
        public static final long nallocx = APIUtil.apiGetFunctionAddress(JEmalloc.access$000(), "je_nallocx");
        public static final long mallctl = APIUtil.apiGetFunctionAddress(JEmalloc.access$000(), "je_mallctl");
        public static final long mallctlnametomib = APIUtil.apiGetFunctionAddress(JEmalloc.access$000(), "je_mallctlnametomib");
        public static final long mallctlbymib = APIUtil.apiGetFunctionAddress(JEmalloc.access$000(), "je_mallctlbymib");
        public static final long malloc_stats_print = APIUtil.apiGetFunctionAddress(JEmalloc.access$000(), "je_malloc_stats_print");
        public static final long malloc_usable_size = APIUtil.apiGetFunctionAddress(JEmalloc.access$000(), "je_malloc_usable_size");

        private Functions() {
        }
    }
}

