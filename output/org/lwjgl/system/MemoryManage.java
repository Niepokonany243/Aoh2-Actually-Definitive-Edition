/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Callback;
import org.lwjgl.system.CallbackI;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.MemoryAccessJNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.StackWalkUtil;
import org.lwjgl.system.dyncall.DynCallback;
import org.lwjgl.system.libc.LibCStdlib;

final class MemoryManage {
    private MemoryManage() {
    }

    static MemoryUtil.MemoryAllocator getInstance() {
        Object allocator = Configuration.MEMORY_ALLOCATOR.get();
        if (allocator instanceof MemoryUtil.MemoryAllocator) {
            return (MemoryUtil.MemoryAllocator)allocator;
        }
        if (!"system".equals(allocator)) {
            String className = allocator == null || "jemalloc".equals(allocator) ? "org.lwjgl.system.jemalloc.JEmallocAllocator" : ("rpmalloc".equals(allocator) ? "org.lwjgl.system.rpmalloc.RPmallocAllocator" : allocator.toString());
            try {
                Class<?> allocatorClass = Class.forName(className);
                return (MemoryUtil.MemoryAllocator)allocatorClass.getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            catch (Throwable t) {
                if (Checks.DEBUG && allocator != null) {
                    t.printStackTrace(APIUtil.DEBUG_STREAM);
                }
                APIUtil.apiLog(String.format("Warning: Failed to instantiate memory allocator: %s. Using the system default.", className));
            }
        }
        return new StdlibAllocator();
    }

    static class DebugAllocator
    implements MemoryUtil.MemoryAllocator {
        private static final ConcurrentMap<Long, Allocation> ALLOCATIONS = new ConcurrentHashMap<Long, Allocation>();
        private static final ConcurrentMap<Long, String> THREADS = new ConcurrentHashMap<Long, String>();
        private final MemoryUtil.MemoryAllocator allocator;
        private final long[] callbacks;

        DebugAllocator(MemoryUtil.MemoryAllocator allocator) {
            this.allocator = allocator;
            this.callbacks = new long[]{new CallbackI.P(){

                @Override
                public String getSignature() {
                    return "(p)p";
                }

                @Override
                public long callback(long args) {
                    long size = DynCallback.dcbArgPointer(args);
                    return this.malloc(size);
                }
            }.address(), new CallbackI.P(){

                @Override
                public String getSignature() {
                    return "(pp)p";
                }

                @Override
                public long callback(long args) {
                    long num = DynCallback.dcbArgPointer(args);
                    long size = DynCallback.dcbArgPointer(args);
                    return this.calloc(num, size);
                }
            }.address(), new CallbackI.P(){

                @Override
                public String getSignature() {
                    return "(pp)p";
                }

                @Override
                public long callback(long args) {
                    long ptr = DynCallback.dcbArgPointer(args);
                    long size = DynCallback.dcbArgPointer(args);
                    return this.realloc(ptr, size);
                }
            }.address(), new CallbackI.V(){

                @Override
                public String getSignature() {
                    return "(p)v";
                }

                @Override
                public void callback(long args) {
                    long ptr = DynCallback.dcbArgPointer(args);
                    this.free(ptr);
                }
            }.address(), new CallbackI.P(){

                @Override
                public String getSignature() {
                    return "(pp)p";
                }

                @Override
                public long callback(long args) {
                    long alignment = DynCallback.dcbArgPointer(args);
                    long size = DynCallback.dcbArgPointer(args);
                    return this.aligned_alloc(alignment, size);
                }
            }.address(), new CallbackI.V(){

                @Override
                public String getSignature() {
                    return "(p)v";
                }

                @Override
                public void callback(long args) {
                    long ptr = DynCallback.dcbArgPointer(args);
                    this.aligned_free(ptr);
                }
            }.address()};
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                for (long callback : this.callbacks) {
                    Callback.free(callback);
                }
                if (ALLOCATIONS.isEmpty()) {
                    return;
                }
                Object object = ALLOCATIONS.entrySet().iterator();
                while (object.hasNext()) {
                    Map.Entry entry = (Map.Entry)object.next();
                    Long address = (Long)entry.getKey();
                    Allocation allocation = (Allocation)entry.getValue();
                    APIUtil.DEBUG_STREAM.format("[LWJGL] %d bytes leaked, thread %d (%s), address: 0x%s\n", allocation.size, allocation.threadId, THREADS.get(allocation.threadId), Long.toHexString(address).toUpperCase());
                    for (Object el : allocation.stackTrace) {
                        APIUtil.DEBUG_STREAM.format("\tat %s\n", el.toString());
                    }
                }
            }));
        }

        @Override
        public long getMalloc() {
            return this.callbacks[0];
        }

        @Override
        public long getCalloc() {
            return this.callbacks[1];
        }

        @Override
        public long getRealloc() {
            return this.callbacks[2];
        }

        @Override
        public long getFree() {
            return this.callbacks[3];
        }

        @Override
        public long getAlignedAlloc() {
            return this.callbacks[4];
        }

        @Override
        public long getAlignedFree() {
            return this.callbacks[5];
        }

        @Override
        public long malloc(long size) {
            return DebugAllocator.track(this.allocator.malloc(size), size);
        }

        @Override
        public long calloc(long num, long size) {
            return DebugAllocator.track(this.allocator.calloc(num, size), num * size);
        }

        @Override
        public long realloc(long ptr, long size) {
            long oldSize = DebugAllocator.untrack(ptr);
            long address = this.allocator.realloc(ptr, size);
            if (address != 0L) {
                DebugAllocator.track(address, size);
            } else if (size != 0L) {
                DebugAllocator.track(ptr, oldSize);
            }
            return address;
        }

        @Override
        public void free(long ptr) {
            DebugAllocator.untrack(ptr);
            this.allocator.free(ptr);
        }

        @Override
        public long aligned_alloc(long alignment, long size) {
            return DebugAllocator.track(this.allocator.aligned_alloc(alignment, size), size);
        }

        @Override
        public void aligned_free(long ptr) {
            DebugAllocator.untrack(ptr);
            this.allocator.aligned_free(ptr);
        }

        static long track(long address, long size) {
            if (address != 0L) {
                Allocation allocation;
                Thread t = Thread.currentThread();
                Long threadId = t.getId();
                if (!THREADS.containsKey(threadId)) {
                    THREADS.put(threadId, t.getName());
                }
                if ((allocation = ALLOCATIONS.put(address, new Allocation(StackWalkUtil.stackWalkGetTrace(), size))) != null) {
                    throw new IllegalStateException("The memory address specified is already being tracked: 0x" + Long.toHexString(address).toUpperCase());
                }
            }
            return address;
        }

        static long untrack(long address) {
            if (address == 0L) {
                return 0L;
            }
            Allocation allocation = (Allocation)ALLOCATIONS.remove(address);
            if (allocation == null) {
                throw new IllegalStateException("The memory address specified is not being tracked: 0x" + Long.toHexString(address).toUpperCase());
            }
            return allocation.size;
        }

        static void report(MemoryUtil.MemoryAllocationReport report) {
            for (Map.Entry entry : ALLOCATIONS.entrySet()) {
                Allocation allocation = (Allocation)entry.getValue();
                report.invoke((Long)entry.getKey(), allocation.size, allocation.threadId, (String)THREADS.get(allocation.threadId), allocation.getElements());
            }
        }

        private static <T> void aggregate(T t, long size, Map<T, AtomicLong> map) {
            AtomicLong node = map.computeIfAbsent(t, k -> new AtomicLong());
            node.set(node.get() + size);
        }

        static void report(MemoryUtil.MemoryAllocationReport report, MemoryUtil.MemoryAllocationReport.Aggregate groupByStackTrace, boolean groupByThread) {
            switch (groupByStackTrace) {
                case ALL: {
                    if (groupByThread) {
                        HashMap mapThread = new HashMap();
                        for (Allocation allocation : ALLOCATIONS.values()) {
                            DebugAllocator.aggregate(allocation.threadId, allocation.size, mapThread);
                        }
                        for (Map.Entry entry : mapThread.entrySet()) {
                            report.invoke(0L, ((AtomicLong)entry.getValue()).get(), (Long)entry.getKey(), (String)THREADS.get(entry.getKey()), null);
                        }
                        break;
                    }
                    long total = 0L;
                    for (Allocation allocation : ALLOCATIONS.values()) {
                        total += allocation.size;
                    }
                    report.invoke(0L, total, 0L, null, null);
                    break;
                }
                case GROUP_BY_METHOD: {
                    if (groupByThread) {
                        HashMap<Long, Map> mapThreadMethod = new HashMap<Long, Map>();
                        for (Allocation allocation : ALLOCATIONS.values()) {
                            Map mapMethod = mapThreadMethod.computeIfAbsent(allocation.threadId, k -> new HashMap());
                            DebugAllocator.aggregate(allocation.getElements()[0], allocation.size, mapMethod);
                        }
                        for (Map.Entry entry : mapThreadMethod.entrySet()) {
                            long threadId = (Long)entry.getKey();
                            Map mapmapMethod = (Map)entry.getValue();
                            for (Map.Entry ms : mapmapMethod.entrySet()) {
                                report.invoke(0L, ((AtomicLong)ms.getValue()).get(), threadId, (String)THREADS.get(threadId), (StackTraceElement)ms.getKey());
                            }
                        }
                    } else {
                        HashMap mapMethod = new HashMap();
                        for (Allocation allocation : ALLOCATIONS.values()) {
                            DebugAllocator.aggregate(allocation.getElements()[0], allocation.size, mapMethod);
                        }
                        for (Map.Entry entry : mapMethod.entrySet()) {
                            report.invoke(0L, ((AtomicLong)entry.getValue()).get(), 0L, null, (StackTraceElement)entry.getKey());
                        }
                    }
                    break;
                }
                case GROUP_BY_STACKTRACE: {
                    if (groupByThread) {
                        HashMap<Long, Map> mapThreadStackTrace = new HashMap<Long, Map>();
                        for (Allocation allocation : ALLOCATIONS.values()) {
                            Map mapStackTrace = mapThreadStackTrace.computeIfAbsent(allocation.threadId, k -> new HashMap());
                            DebugAllocator.aggregate(allocation, allocation.size, mapStackTrace);
                        }
                        for (Map.Entry entry : mapThreadStackTrace.entrySet()) {
                            long threadId = (Long)entry.getKey();
                            Map mapStackTrace = (Map)entry.getValue();
                            for (Map.Entry ss : mapStackTrace.entrySet()) {
                                report.invoke(0L, ((AtomicLong)ss.getValue()).get(), threadId, (String)THREADS.get(threadId), ((Allocation)ss.getKey()).getElements());
                            }
                        }
                    } else {
                        HashMap mapStackTrace = new HashMap();
                        for (Allocation allocation : ALLOCATIONS.values()) {
                            DebugAllocator.aggregate(allocation, allocation.size, mapStackTrace);
                        }
                        for (Map.Entry entry : mapStackTrace.entrySet()) {
                            report.invoke(0L, ((AtomicLong)entry.getValue()).get(), 0L, null, ((Allocation)entry.getKey()).getElements());
                        }
                    }
                    break;
                }
            }
        }

        private static class Allocation {
            private final Object[] stackTrace;
            @Nullable
            private StackTraceElement[] elements;
            final long size;
            final long threadId;

            Allocation(Object[] stackTrace, long size) {
                this.stackTrace = stackTrace;
                this.size = size;
                this.threadId = Thread.currentThread().getId();
            }

            private StackTraceElement[] getElements() {
                if (this.elements == null) {
                    this.elements = StackWalkUtil.stackWalkArray(this.stackTrace);
                }
                return this.elements;
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || this.getClass() != o.getClass()) {
                    return false;
                }
                Allocation that = (Allocation)o;
                return Arrays.equals(this.getElements(), that.getElements());
            }

            public int hashCode() {
                return Arrays.hashCode(this.getElements());
            }
        }
    }

    private static class StdlibAllocator
    implements MemoryUtil.MemoryAllocator {
        private StdlibAllocator() {
        }

        @Override
        public long getMalloc() {
            return MemoryAccessJNI.malloc;
        }

        @Override
        public long getCalloc() {
            return MemoryAccessJNI.calloc;
        }

        @Override
        public long getRealloc() {
            return MemoryAccessJNI.realloc;
        }

        @Override
        public long getFree() {
            return MemoryAccessJNI.free;
        }

        @Override
        public long getAlignedAlloc() {
            return MemoryAccessJNI.aligned_alloc;
        }

        @Override
        public long getAlignedFree() {
            return MemoryAccessJNI.aligned_free;
        }

        @Override
        public long malloc(long size) {
            return LibCStdlib.nmalloc(size);
        }

        @Override
        public long calloc(long num, long size) {
            return LibCStdlib.ncalloc(num, size);
        }

        @Override
        public long realloc(long ptr, long size) {
            return LibCStdlib.nrealloc(ptr, size);
        }

        @Override
        public void free(long ptr) {
            LibCStdlib.nfree(ptr);
        }

        @Override
        public long aligned_alloc(long alignment, long size) {
            return LibCStdlib.naligned_alloc(alignment, size);
        }

        @Override
        public void aligned_free(long ptr) {
            LibCStdlib.naligned_free(ptr);
        }
    }
}

