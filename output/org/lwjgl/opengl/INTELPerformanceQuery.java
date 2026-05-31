/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class INTELPerformanceQuery {
    public static final int GL_PERFQUERY_SINGLE_CONTEXT_INTEL = 0;
    public static final int GL_PERFQUERY_GLOBAL_CONTEXT_INTEL = 1;
    public static final int GL_PERFQUERY_WAIT_INTEL = 33787;
    public static final int GL_PERFQUERY_FLUSH_INTEL = 33786;
    public static final int GL_PERFQUERY_DONOT_FLUSH_INTEL = 33785;
    public static final int GL_PERFQUERY_COUNTER_EVENT_INTEL = 38128;
    public static final int GL_PERFQUERY_COUNTER_DURATION_NORM_INTEL = 38129;
    public static final int GL_PERFQUERY_COUNTER_DURATION_RAW_INTEL = 38130;
    public static final int GL_PERFQUERY_COUNTER_THROUGHPUT_INTEL = 38131;
    public static final int GL_PERFQUERY_COUNTER_RAW_INTEL = 38132;
    public static final int GL_PERFQUERY_COUNTER_TIMESTAMP_INTEL = 38133;
    public static final int GL_PERFQUERY_COUNTER_DATA_UINT32_INTEL = 38136;
    public static final int GL_PERFQUERY_COUNTER_DATA_UINT64_INTEL = 38137;
    public static final int GL_PERFQUERY_COUNTER_DATA_FLOAT_INTEL = 38138;
    public static final int GL_PERFQUERY_COUNTER_DATA_DOUBLE_INTEL = 38139;
    public static final int GL_PERFQUERY_COUNTER_DATA_BOOL32_INTEL = 38140;
    public static final int GL_PERFQUERY_QUERY_NAME_LENGTH_MAX_INTEL = 38141;
    public static final int GL_PERFQUERY_COUNTER_NAME_LENGTH_MAX_INTEL = 38142;
    public static final int GL_PERFQUERY_COUNTER_DESC_LENGTH_MAX_INTEL = 38143;
    public static final int GL_PERFQUERY_GPA_EXTENDED_COUNTERS_INTEL = 38144;

    protected INTELPerformanceQuery() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glBeginPerfQueryINTEL, caps.glCreatePerfQueryINTEL, caps.glDeletePerfQueryINTEL, caps.glEndPerfQueryINTEL, caps.glGetFirstPerfQueryIdINTEL, caps.glGetNextPerfQueryIdINTEL, caps.glGetPerfCounterInfoINTEL, caps.glGetPerfQueryDataINTEL, caps.glGetPerfQueryIdByNameINTEL, caps.glGetPerfQueryInfoINTEL);
    }

    public static native void glBeginPerfQueryINTEL(@NativeType(value="GLuint") int var0);

    public static native void nglCreatePerfQueryINTEL(int var0, long var1);

    public static void glCreatePerfQueryINTEL(@NativeType(value="GLuint") int queryId, @NativeType(value="GLuint *") IntBuffer queryHandle) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)queryHandle, 1);
        }
        INTELPerformanceQuery.nglCreatePerfQueryINTEL(queryId, MemoryUtil.memAddress(queryHandle));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glCreatePerfQueryINTEL(@NativeType(value="GLuint") int queryId) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer queryHandle = stack.callocInt(1);
            INTELPerformanceQuery.nglCreatePerfQueryINTEL(queryId, MemoryUtil.memAddress(queryHandle));
            int n = queryHandle.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glDeletePerfQueryINTEL(@NativeType(value="GLuint") int var0);

    public static native void glEndPerfQueryINTEL(@NativeType(value="GLuint") int var0);

    public static native void nglGetFirstPerfQueryIdINTEL(long var0);

    public static void glGetFirstPerfQueryIdINTEL(@NativeType(value="GLuint *") IntBuffer queryId) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)queryId, 1);
        }
        INTELPerformanceQuery.nglGetFirstPerfQueryIdINTEL(MemoryUtil.memAddress(queryId));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetFirstPerfQueryIdINTEL() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer queryId = stack.callocInt(1);
            INTELPerformanceQuery.nglGetFirstPerfQueryIdINTEL(MemoryUtil.memAddress(queryId));
            int n = queryId.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetNextPerfQueryIdINTEL(int var0, long var1);

    public static void glGetNextPerfQueryIdINTEL(@NativeType(value="GLuint") int queryId, @NativeType(value="GLuint *") IntBuffer nextQueryId) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)nextQueryId, 1);
        }
        INTELPerformanceQuery.nglGetNextPerfQueryIdINTEL(queryId, MemoryUtil.memAddress(nextQueryId));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetNextPerfQueryIdINTEL(@NativeType(value="GLuint") int queryId) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer nextQueryId = stack.callocInt(1);
            INTELPerformanceQuery.nglGetNextPerfQueryIdINTEL(queryId, MemoryUtil.memAddress(nextQueryId));
            int n = nextQueryId.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetPerfCounterInfoINTEL(int var0, int var1, int var2, long var3, int var5, long var6, long var8, long var10, long var12, long var14, long var16);

    public static void glGetPerfCounterInfoINTEL(@NativeType(value="GLuint") int queryId, @NativeType(value="GLuint") int counterId, @NativeType(value="GLchar *") ByteBuffer counterName, @NativeType(value="GLchar *") ByteBuffer counterDesc, @NativeType(value="GLuint *") IntBuffer counterOffset, @NativeType(value="GLuint *") IntBuffer counterDataSize, @NativeType(value="GLuint *") IntBuffer counterTypeEnum, @NativeType(value="GLuint *") IntBuffer counterDataTypeEnum, @NativeType(value="GLuint64 *") LongBuffer rawCounterMaxValue) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)counterOffset, 1);
            Checks.check((Buffer)counterDataSize, 1);
            Checks.check((Buffer)counterTypeEnum, 1);
            Checks.check((Buffer)counterDataTypeEnum, 1);
            Checks.check((Buffer)rawCounterMaxValue, 1);
        }
        INTELPerformanceQuery.nglGetPerfCounterInfoINTEL(queryId, counterId, counterName.remaining(), MemoryUtil.memAddress(counterName), counterDesc.remaining(), MemoryUtil.memAddress(counterDesc), MemoryUtil.memAddress(counterOffset), MemoryUtil.memAddress(counterDataSize), MemoryUtil.memAddress(counterTypeEnum), MemoryUtil.memAddress(counterDataTypeEnum), MemoryUtil.memAddress(rawCounterMaxValue));
    }

    public static native void nglGetPerfQueryDataINTEL(int var0, int var1, int var2, long var3, long var5);

    public static void glGetPerfQueryDataINTEL(@NativeType(value="GLuint") int queryHandle, @NativeType(value="GLuint") int flags, @NativeType(value="void *") ByteBuffer data, @NativeType(value="GLuint *") IntBuffer bytesWritten) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)bytesWritten, 1);
        }
        INTELPerformanceQuery.nglGetPerfQueryDataINTEL(queryHandle, flags, data.remaining(), MemoryUtil.memAddress(data), MemoryUtil.memAddress(bytesWritten));
    }

    public static native void nglGetPerfQueryIdByNameINTEL(long var0, long var2);

    public static void glGetPerfQueryIdByNameINTEL(@NativeType(value="GLchar *") ByteBuffer queryName, @NativeType(value="GLuint *") IntBuffer queryId) {
        if (Checks.CHECKS) {
            Checks.checkNT1(queryName);
            Checks.check((Buffer)queryId, 1);
        }
        INTELPerformanceQuery.nglGetPerfQueryIdByNameINTEL(MemoryUtil.memAddress(queryName), MemoryUtil.memAddress(queryId));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glGetPerfQueryIdByNameINTEL(@NativeType(value="GLchar *") CharSequence queryName, @NativeType(value="GLuint *") IntBuffer queryId) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)queryId, 1);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(queryName, true);
            long queryNameEncoded = stack.getPointerAddress();
            INTELPerformanceQuery.nglGetPerfQueryIdByNameINTEL(queryNameEncoded, MemoryUtil.memAddress(queryId));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetPerfQueryIdByNameINTEL(@NativeType(value="GLchar *") CharSequence queryName) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(queryName, true);
            long queryNameEncoded = stack.getPointerAddress();
            IntBuffer queryId = stack.callocInt(1);
            INTELPerformanceQuery.nglGetPerfQueryIdByNameINTEL(queryNameEncoded, MemoryUtil.memAddress(queryId));
            int n = queryId.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetPerfQueryInfoINTEL(int var0, int var1, long var2, long var4, long var6, long var8, long var10);

    public static void glGetPerfQueryInfoINTEL(@NativeType(value="GLuint") int queryId, @NativeType(value="GLchar *") ByteBuffer queryName, @NativeType(value="GLuint *") IntBuffer dataSize, @NativeType(value="GLuint *") IntBuffer noCounters, @NativeType(value="GLuint *") IntBuffer noInstances, @NativeType(value="GLuint *") IntBuffer capsMask) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)dataSize, 1);
            Checks.check((Buffer)noCounters, 1);
            Checks.check((Buffer)noInstances, 1);
            Checks.check((Buffer)capsMask, 1);
        }
        INTELPerformanceQuery.nglGetPerfQueryInfoINTEL(queryId, queryName.remaining(), MemoryUtil.memAddress(queryName), MemoryUtil.memAddress(dataSize), MemoryUtil.memAddress(noCounters), MemoryUtil.memAddress(noInstances), MemoryUtil.memAddress(capsMask));
    }

    public static void glCreatePerfQueryINTEL(@NativeType(value="GLuint") int queryId, @NativeType(value="GLuint *") int[] queryHandle) {
        long __functionAddress = GL.getICD().glCreatePerfQueryINTEL;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(queryHandle, 1);
        }
        JNI.callPV(queryId, queryHandle, __functionAddress);
    }

    public static void glGetFirstPerfQueryIdINTEL(@NativeType(value="GLuint *") int[] queryId) {
        long __functionAddress = GL.getICD().glGetFirstPerfQueryIdINTEL;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(queryId, 1);
        }
        JNI.callPV(queryId, __functionAddress);
    }

    public static void glGetNextPerfQueryIdINTEL(@NativeType(value="GLuint") int queryId, @NativeType(value="GLuint *") int[] nextQueryId) {
        long __functionAddress = GL.getICD().glGetNextPerfQueryIdINTEL;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(nextQueryId, 1);
        }
        JNI.callPV(queryId, nextQueryId, __functionAddress);
    }

    public static void glGetPerfCounterInfoINTEL(@NativeType(value="GLuint") int queryId, @NativeType(value="GLuint") int counterId, @NativeType(value="GLchar *") ByteBuffer counterName, @NativeType(value="GLchar *") ByteBuffer counterDesc, @NativeType(value="GLuint *") int[] counterOffset, @NativeType(value="GLuint *") int[] counterDataSize, @NativeType(value="GLuint *") int[] counterTypeEnum, @NativeType(value="GLuint *") int[] counterDataTypeEnum, @NativeType(value="GLuint64 *") long[] rawCounterMaxValue) {
        long __functionAddress = GL.getICD().glGetPerfCounterInfoINTEL;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(counterOffset, 1);
            Checks.check(counterDataSize, 1);
            Checks.check(counterTypeEnum, 1);
            Checks.check(counterDataTypeEnum, 1);
            Checks.check(rawCounterMaxValue, 1);
        }
        JNI.callPPPPPPPV(queryId, counterId, counterName.remaining(), MemoryUtil.memAddress(counterName), counterDesc.remaining(), MemoryUtil.memAddress(counterDesc), counterOffset, counterDataSize, counterTypeEnum, counterDataTypeEnum, rawCounterMaxValue, __functionAddress);
    }

    public static void glGetPerfQueryDataINTEL(@NativeType(value="GLuint") int queryHandle, @NativeType(value="GLuint") int flags, @NativeType(value="void *") ByteBuffer data, @NativeType(value="GLuint *") int[] bytesWritten) {
        long __functionAddress = GL.getICD().glGetPerfQueryDataINTEL;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(bytesWritten, 1);
        }
        JNI.callPPV(queryHandle, flags, data.remaining(), MemoryUtil.memAddress(data), bytesWritten, __functionAddress);
    }

    public static void glGetPerfQueryIdByNameINTEL(@NativeType(value="GLchar *") ByteBuffer queryName, @NativeType(value="GLuint *") int[] queryId) {
        long __functionAddress = GL.getICD().glGetPerfQueryIdByNameINTEL;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkNT1(queryName);
            Checks.check(queryId, 1);
        }
        JNI.callPPV(MemoryUtil.memAddress(queryName), queryId, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glGetPerfQueryIdByNameINTEL(@NativeType(value="GLchar *") CharSequence queryName, @NativeType(value="GLuint *") int[] queryId) {
        long __functionAddress = GL.getICD().glGetPerfQueryIdByNameINTEL;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(queryId, 1);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(queryName, true);
            long queryNameEncoded = stack.getPointerAddress();
            JNI.callPPV(queryNameEncoded, queryId, __functionAddress);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glGetPerfQueryInfoINTEL(@NativeType(value="GLuint") int queryId, @NativeType(value="GLchar *") ByteBuffer queryName, @NativeType(value="GLuint *") int[] dataSize, @NativeType(value="GLuint *") int[] noCounters, @NativeType(value="GLuint *") int[] noInstances, @NativeType(value="GLuint *") int[] capsMask) {
        long __functionAddress = GL.getICD().glGetPerfQueryInfoINTEL;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(dataSize, 1);
            Checks.check(noCounters, 1);
            Checks.check(noInstances, 1);
            Checks.check(capsMask, 1);
        }
        JNI.callPPPPPV(queryId, queryName.remaining(), MemoryUtil.memAddress(queryName), dataSize, noCounters, noInstances, capsMask, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

