/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class AMDPerformanceMonitor {
    public static final int GL_COUNTER_TYPE_AMD = 35776;
    public static final int GL_COUNTER_RANGE_AMD = 35777;
    public static final int GL_UNSIGNED_INT64_AMD = 35778;
    public static final int GL_PERCENTAGE_AMD = 35779;
    public static final int GL_PERFMON_RESULT_AVAILABLE_AMD = 35780;
    public static final int GL_PERFMON_RESULT_SIZE_AMD = 35781;
    public static final int GL_PERFMON_RESULT_AMD = 35782;

    protected AMDPerformanceMonitor() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glGetPerfMonitorGroupsAMD, caps.glGetPerfMonitorCountersAMD, caps.glGetPerfMonitorGroupStringAMD, caps.glGetPerfMonitorCounterStringAMD, caps.glGetPerfMonitorCounterInfoAMD, caps.glGenPerfMonitorsAMD, caps.glDeletePerfMonitorsAMD, caps.glSelectPerfMonitorCountersAMD, caps.glBeginPerfMonitorAMD, caps.glEndPerfMonitorAMD, caps.glGetPerfMonitorCounterDataAMD);
    }

    public static native void nglGetPerfMonitorGroupsAMD(long var0, int var2, long var3);

    public static void glGetPerfMonitorGroupsAMD(@Nullable @NativeType(value="GLint *") IntBuffer numGroups, @Nullable @NativeType(value="GLuint *") IntBuffer groups) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)numGroups, 1);
        }
        AMDPerformanceMonitor.nglGetPerfMonitorGroupsAMD(MemoryUtil.memAddressSafe(numGroups), Checks.remainingSafe(groups), MemoryUtil.memAddressSafe(groups));
    }

    public static native void nglGetPerfMonitorCountersAMD(int var0, long var1, long var3, int var5, long var6);

    public static void glGetPerfMonitorCountersAMD(@NativeType(value="GLuint") int group, @NativeType(value="GLint *") IntBuffer numCounters, @NativeType(value="GLint *") IntBuffer maxActiveCounters, @NativeType(value="GLuint *") IntBuffer counters) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)numCounters, 1);
            Checks.check((Buffer)maxActiveCounters, 1);
        }
        AMDPerformanceMonitor.nglGetPerfMonitorCountersAMD(group, MemoryUtil.memAddress(numCounters), MemoryUtil.memAddress(maxActiveCounters), counters.remaining(), MemoryUtil.memAddress(counters));
    }

    public static native void nglGetPerfMonitorGroupStringAMD(int var0, int var1, long var2, long var4);

    public static void glGetPerfMonitorGroupStringAMD(@NativeType(value="GLuint") int group, @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer groupString) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)length, 1);
        }
        AMDPerformanceMonitor.nglGetPerfMonitorGroupStringAMD(group, groupString.remaining(), MemoryUtil.memAddress(length), MemoryUtil.memAddress(groupString));
    }

    public static native void nglGetPerfMonitorCounterStringAMD(int var0, int var1, int var2, long var3, long var5);

    public static void glGetPerfMonitorCounterStringAMD(@NativeType(value="GLuint") int group, @NativeType(value="GLuint") int counter, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @Nullable @NativeType(value="GLchar *") ByteBuffer counterString) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, 1);
        }
        AMDPerformanceMonitor.nglGetPerfMonitorCounterStringAMD(group, counter, Checks.remainingSafe(counterString), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddressSafe(counterString));
    }

    public static native void nglGetPerfMonitorCounterInfoAMD(int var0, int var1, int var2, long var3);

    public static void glGetPerfMonitorCounterInfoAMD(@NativeType(value="GLuint") int group, @NativeType(value="GLuint") int counter, @NativeType(value="GLenum") int pname, @NativeType(value="void *") ByteBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 4);
        }
        AMDPerformanceMonitor.nglGetPerfMonitorCounterInfoAMD(group, counter, pname, MemoryUtil.memAddress(data));
    }

    public static void glGetPerfMonitorCounterInfoAMD(@NativeType(value="GLuint") int group, @NativeType(value="GLuint") int counter, @NativeType(value="GLenum") int pname, @NativeType(value="void *") IntBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 1);
        }
        AMDPerformanceMonitor.nglGetPerfMonitorCounterInfoAMD(group, counter, pname, MemoryUtil.memAddress(data));
    }

    public static void glGetPerfMonitorCounterInfoAMD(@NativeType(value="GLuint") int group, @NativeType(value="GLuint") int counter, @NativeType(value="GLenum") int pname, @NativeType(value="void *") FloatBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 1);
        }
        AMDPerformanceMonitor.nglGetPerfMonitorCounterInfoAMD(group, counter, pname, MemoryUtil.memAddress(data));
    }

    public static native void nglGenPerfMonitorsAMD(int var0, long var1);

    public static void glGenPerfMonitorsAMD(@NativeType(value="GLuint *") IntBuffer monitors) {
        AMDPerformanceMonitor.nglGenPerfMonitorsAMD(monitors.remaining(), MemoryUtil.memAddress(monitors));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGenPerfMonitorsAMD() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer monitors = stack.callocInt(1);
            AMDPerformanceMonitor.nglGenPerfMonitorsAMD(1, MemoryUtil.memAddress(monitors));
            int n = monitors.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglDeletePerfMonitorsAMD(int var0, long var1);

    public static void glDeletePerfMonitorsAMD(@NativeType(value="GLuint *") IntBuffer monitors) {
        AMDPerformanceMonitor.nglDeletePerfMonitorsAMD(monitors.remaining(), MemoryUtil.memAddress(monitors));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDeletePerfMonitorsAMD(@NativeType(value="GLuint *") int monitor) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer monitors = stack.ints(monitor);
            AMDPerformanceMonitor.nglDeletePerfMonitorsAMD(1, MemoryUtil.memAddress(monitors));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglSelectPerfMonitorCountersAMD(int var0, boolean var1, int var2, int var3, long var4);

    public static void glSelectPerfMonitorCountersAMD(@NativeType(value="GLuint") int monitor, @NativeType(value="GLboolean") boolean enable, @NativeType(value="GLuint") int group, @NativeType(value="GLuint *") IntBuffer counterList) {
        AMDPerformanceMonitor.nglSelectPerfMonitorCountersAMD(monitor, enable, group, counterList.remaining(), MemoryUtil.memAddress(counterList));
    }

    public static native void glBeginPerfMonitorAMD(@NativeType(value="GLuint") int var0);

    public static native void glEndPerfMonitorAMD(@NativeType(value="GLuint") int var0);

    public static native void nglGetPerfMonitorCounterDataAMD(int var0, int var1, int var2, long var3, long var5);

    public static void glGetPerfMonitorCounterDataAMD(@NativeType(value="GLuint") int monitor, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") IntBuffer data, @Nullable @NativeType(value="GLint *") IntBuffer bytesWritten) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)bytesWritten, 1);
        }
        AMDPerformanceMonitor.nglGetPerfMonitorCounterDataAMD(monitor, pname, data.remaining(), MemoryUtil.memAddress(data), MemoryUtil.memAddressSafe(bytesWritten));
    }

    public static void glGetPerfMonitorGroupsAMD(@Nullable @NativeType(value="GLint *") int[] numGroups, @Nullable @NativeType(value="GLuint *") int[] groups) {
        long __functionAddress = GL.getICD().glGetPerfMonitorGroupsAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(numGroups, 1);
        }
        JNI.callPPV(numGroups, Checks.lengthSafe(groups), groups, __functionAddress);
    }

    public static void glGetPerfMonitorCountersAMD(@NativeType(value="GLuint") int group, @NativeType(value="GLint *") int[] numCounters, @NativeType(value="GLint *") int[] maxActiveCounters, @NativeType(value="GLuint *") int[] counters) {
        long __functionAddress = GL.getICD().glGetPerfMonitorCountersAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(numCounters, 1);
            Checks.check(maxActiveCounters, 1);
        }
        JNI.callPPPV(group, numCounters, maxActiveCounters, counters.length, counters, __functionAddress);
    }

    public static void glGetPerfMonitorGroupStringAMD(@NativeType(value="GLuint") int group, @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer groupString) {
        long __functionAddress = GL.getICD().glGetPerfMonitorGroupStringAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(length, 1);
        }
        JNI.callPPV(group, groupString.remaining(), length, MemoryUtil.memAddress(groupString), __functionAddress);
    }

    public static void glGetPerfMonitorCounterStringAMD(@NativeType(value="GLuint") int group, @NativeType(value="GLuint") int counter, @Nullable @NativeType(value="GLsizei *") int[] length, @Nullable @NativeType(value="GLchar *") ByteBuffer counterString) {
        long __functionAddress = GL.getICD().glGetPerfMonitorCounterStringAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, 1);
        }
        JNI.callPPV(group, counter, Checks.remainingSafe(counterString), length, MemoryUtil.memAddressSafe(counterString), __functionAddress);
    }

    public static void glGetPerfMonitorCounterInfoAMD(@NativeType(value="GLuint") int group, @NativeType(value="GLuint") int counter, @NativeType(value="GLenum") int pname, @NativeType(value="void *") int[] data) {
        long __functionAddress = GL.getICD().glGetPerfMonitorCounterInfoAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(data, 1);
        }
        JNI.callPV(group, counter, pname, data, __functionAddress);
    }

    public static void glGetPerfMonitorCounterInfoAMD(@NativeType(value="GLuint") int group, @NativeType(value="GLuint") int counter, @NativeType(value="GLenum") int pname, @NativeType(value="void *") float[] data) {
        long __functionAddress = GL.getICD().glGetPerfMonitorCounterInfoAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(data, 1);
        }
        JNI.callPV(group, counter, pname, data, __functionAddress);
    }

    public static void glGenPerfMonitorsAMD(@NativeType(value="GLuint *") int[] monitors) {
        long __functionAddress = GL.getICD().glGenPerfMonitorsAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(monitors.length, monitors, __functionAddress);
    }

    public static void glDeletePerfMonitorsAMD(@NativeType(value="GLuint *") int[] monitors) {
        long __functionAddress = GL.getICD().glDeletePerfMonitorsAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(monitors.length, monitors, __functionAddress);
    }

    public static void glSelectPerfMonitorCountersAMD(@NativeType(value="GLuint") int monitor, @NativeType(value="GLboolean") boolean enable, @NativeType(value="GLuint") int group, @NativeType(value="GLuint *") int[] counterList) {
        long __functionAddress = GL.getICD().glSelectPerfMonitorCountersAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(monitor, enable, group, counterList.length, counterList, __functionAddress);
    }

    public static void glGetPerfMonitorCounterDataAMD(@NativeType(value="GLuint") int monitor, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") int[] data, @Nullable @NativeType(value="GLint *") int[] bytesWritten) {
        long __functionAddress = GL.getICD().glGetPerfMonitorCounterDataAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(bytesWritten, 1);
        }
        JNI.callPPV(monitor, pname, data.length, data, bytesWritten, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

