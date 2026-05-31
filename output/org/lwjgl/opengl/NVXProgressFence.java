/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVXProgressFence {
    protected NVXProgressFence() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glCreateProgressFenceNVX, caps.glSignalSemaphoreui64NVX, caps.glWaitSemaphoreui64NVX, caps.glClientWaitSemaphoreui64NVX);
    }

    @NativeType(value="GLuint")
    public static native int glCreateProgressFenceNVX();

    public static native void nglSignalSemaphoreui64NVX(int var0, int var1, long var2, long var4);

    public static void glSignalSemaphoreui64NVX(@NativeType(value="GLuint") int signalGpu, @NativeType(value="GLuint const *") IntBuffer semaphoreArray, @NativeType(value="GLuint64 const *") LongBuffer fenceValueArray) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)fenceValueArray, semaphoreArray.remaining());
        }
        NVXProgressFence.nglSignalSemaphoreui64NVX(signalGpu, semaphoreArray.remaining(), MemoryUtil.memAddress(semaphoreArray), MemoryUtil.memAddress(fenceValueArray));
    }

    public static native void nglWaitSemaphoreui64NVX(int var0, int var1, long var2, long var4);

    public static void glWaitSemaphoreui64NVX(@NativeType(value="GLuint") int waitGpu, @NativeType(value="GLuint const *") IntBuffer semaphoreArray, @NativeType(value="GLuint64 const *") LongBuffer fenceValueArray) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)fenceValueArray, semaphoreArray.remaining());
        }
        NVXProgressFence.nglWaitSemaphoreui64NVX(waitGpu, semaphoreArray.remaining(), MemoryUtil.memAddress(semaphoreArray), MemoryUtil.memAddress(fenceValueArray));
    }

    public static native void nglClientWaitSemaphoreui64NVX(int var0, long var1, long var3);

    public static void glClientWaitSemaphoreui64NVX(@NativeType(value="GLuint const *") IntBuffer semaphoreArray, @NativeType(value="GLuint64 const *") LongBuffer fenceValueArray) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)fenceValueArray, semaphoreArray.remaining());
        }
        NVXProgressFence.nglClientWaitSemaphoreui64NVX(semaphoreArray.remaining(), MemoryUtil.memAddress(semaphoreArray), MemoryUtil.memAddress(fenceValueArray));
    }

    public static void glSignalSemaphoreui64NVX(@NativeType(value="GLuint") int signalGpu, @NativeType(value="GLuint const *") int[] semaphoreArray, @NativeType(value="GLuint64 const *") long[] fenceValueArray) {
        long __functionAddress = GL.getICD().glSignalSemaphoreui64NVX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(fenceValueArray, semaphoreArray.length);
        }
        JNI.callPPV(signalGpu, semaphoreArray.length, semaphoreArray, fenceValueArray, __functionAddress);
    }

    public static void glWaitSemaphoreui64NVX(@NativeType(value="GLuint") int waitGpu, @NativeType(value="GLuint const *") int[] semaphoreArray, @NativeType(value="GLuint64 const *") long[] fenceValueArray) {
        long __functionAddress = GL.getICD().glWaitSemaphoreui64NVX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(fenceValueArray, semaphoreArray.length);
        }
        JNI.callPPV(waitGpu, semaphoreArray.length, semaphoreArray, fenceValueArray, __functionAddress);
    }

    public static void glClientWaitSemaphoreui64NVX(@NativeType(value="GLuint const *") int[] semaphoreArray, @NativeType(value="GLuint64 const *") long[] fenceValueArray) {
        long __functionAddress = GL.getICD().glClientWaitSemaphoreui64NVX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(fenceValueArray, semaphoreArray.length);
        }
        JNI.callPPV(semaphoreArray.length, semaphoreArray, fenceValueArray, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

