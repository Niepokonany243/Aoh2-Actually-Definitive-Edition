/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVXGpuMulticast2 {
    protected NVXGpuMulticast2() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glAsyncCopyImageSubDataNVX, caps.glAsyncCopyBufferSubDataNVX, caps.glUploadGpuMaskNVX, caps.glMulticastViewportArrayvNVX, caps.glMulticastScissorArrayvNVX, caps.glMulticastViewportPositionWScaleNVX);
    }

    public static native int nglAsyncCopyImageSubDataNVX(int var0, long var1, long var3, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20, int var21, int var22, long var23, long var25);

    @NativeType(value="GLuint")
    public static int glAsyncCopyImageSubDataNVX(@NativeType(value="GLuint const *") IntBuffer waitSemaphoreArray, @NativeType(value="GLuint64 const *") LongBuffer waitValueArray, @NativeType(value="GLuint") int srcGpu, @NativeType(value="GLbitfield") int dstGpuMask, @NativeType(value="GLuint") int srcName, @NativeType(value="GLenum") int srcTarget, @NativeType(value="GLint") int srcLevel, @NativeType(value="GLint") int srcX, @NativeType(value="GLint") int srcY, @NativeType(value="GLint") int srcZ, @NativeType(value="GLuint") int dstName, @NativeType(value="GLenum") int dstTarget, @NativeType(value="GLint") int dstLevel, @NativeType(value="GLint") int dstX, @NativeType(value="GLint") int dstY, @NativeType(value="GLint") int dstZ, @NativeType(value="GLsizei") int srcWidth, @NativeType(value="GLsizei") int srcHeight, @NativeType(value="GLsizei") int srcDepth, @NativeType(value="GLuint const *") IntBuffer signalSemaphoreArray, @NativeType(value="GLuint64 const *") LongBuffer signalValueArray) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)waitValueArray, waitSemaphoreArray.remaining());
            Checks.check((Buffer)signalValueArray, signalSemaphoreArray.remaining());
        }
        return NVXGpuMulticast2.nglAsyncCopyImageSubDataNVX(waitSemaphoreArray.remaining(), MemoryUtil.memAddress(waitSemaphoreArray), MemoryUtil.memAddress(waitValueArray), srcGpu, dstGpuMask, srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, srcWidth, srcHeight, srcDepth, signalSemaphoreArray.remaining(), MemoryUtil.memAddress(signalSemaphoreArray), MemoryUtil.memAddress(signalValueArray));
    }

    public static native long nglAsyncCopyBufferSubDataNVX(int var0, long var1, long var3, int var5, int var6, int var7, int var8, long var9, long var11, long var13, int var15, long var16, long var18);

    @NativeType(value="GLsync")
    public static long glAsyncCopyBufferSubDataNVX(@NativeType(value="GLuint const *") IntBuffer waitSemaphoreArray, @NativeType(value="GLuint64 const *") LongBuffer fenceValueArray, @NativeType(value="GLuint") int readGpu, @NativeType(value="GLbitfield") int writeGpuMask, @NativeType(value="GLuint") int readBuffer, @NativeType(value="GLuint") int writeBuffer, @NativeType(value="GLintptr") long readOffset, @NativeType(value="GLintptr") long writeOffset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLuint const *") IntBuffer signalSemaphoreArray, @NativeType(value="GLuint64 const *") LongBuffer signalValueArray) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)fenceValueArray, waitSemaphoreArray.remaining());
            Checks.check((Buffer)signalValueArray, signalSemaphoreArray.remaining());
        }
        return NVXGpuMulticast2.nglAsyncCopyBufferSubDataNVX(waitSemaphoreArray.remaining(), MemoryUtil.memAddress(waitSemaphoreArray), MemoryUtil.memAddress(fenceValueArray), readGpu, writeGpuMask, readBuffer, writeBuffer, readOffset, writeOffset, size, signalSemaphoreArray.remaining(), MemoryUtil.memAddress(signalSemaphoreArray), MemoryUtil.memAddress(signalValueArray));
    }

    public static native void glUploadGpuMaskNVX(@NativeType(value="GLbitfield") int var0);

    public static native void nglMulticastViewportArrayvNVX(int var0, int var1, int var2, long var3);

    public static void glMulticastViewportArrayvNVX(@NativeType(value="GLuint") int gpu, @NativeType(value="GLuint") int first, @NativeType(value="GLfloat const *") FloatBuffer v) {
        NVXGpuMulticast2.nglMulticastViewportArrayvNVX(gpu, first, v.remaining() >> 2, MemoryUtil.memAddress(v));
    }

    public static native void nglMulticastScissorArrayvNVX(int var0, int var1, int var2, long var3);

    public static void glMulticastScissorArrayvNVX(@NativeType(value="GLuint") int gpu, @NativeType(value="GLuint") int first, @NativeType(value="GLint const *") IntBuffer v) {
        NVXGpuMulticast2.nglMulticastScissorArrayvNVX(gpu, first, v.remaining() >> 2, MemoryUtil.memAddress(v));
    }

    public static native void glMulticastViewportPositionWScaleNVX(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    @NativeType(value="GLuint")
    public static int glAsyncCopyImageSubDataNVX(@NativeType(value="GLuint const *") int[] waitSemaphoreArray, @NativeType(value="GLuint64 const *") long[] waitValueArray, @NativeType(value="GLuint") int srcGpu, @NativeType(value="GLbitfield") int dstGpuMask, @NativeType(value="GLuint") int srcName, @NativeType(value="GLenum") int srcTarget, @NativeType(value="GLint") int srcLevel, @NativeType(value="GLint") int srcX, @NativeType(value="GLint") int srcY, @NativeType(value="GLint") int srcZ, @NativeType(value="GLuint") int dstName, @NativeType(value="GLenum") int dstTarget, @NativeType(value="GLint") int dstLevel, @NativeType(value="GLint") int dstX, @NativeType(value="GLint") int dstY, @NativeType(value="GLint") int dstZ, @NativeType(value="GLsizei") int srcWidth, @NativeType(value="GLsizei") int srcHeight, @NativeType(value="GLsizei") int srcDepth, @NativeType(value="GLuint const *") int[] signalSemaphoreArray, @NativeType(value="GLuint64 const *") long[] signalValueArray) {
        long __functionAddress = GL.getICD().glAsyncCopyImageSubDataNVX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(waitValueArray, waitSemaphoreArray.length);
            Checks.check(signalValueArray, signalSemaphoreArray.length);
        }
        return JNI.callPPPPI(waitSemaphoreArray.length, waitSemaphoreArray, waitValueArray, srcGpu, dstGpuMask, srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, srcWidth, srcHeight, srcDepth, signalSemaphoreArray.length, signalSemaphoreArray, signalValueArray, __functionAddress);
    }

    @NativeType(value="GLsync")
    public static long glAsyncCopyBufferSubDataNVX(@NativeType(value="GLuint const *") int[] waitSemaphoreArray, @NativeType(value="GLuint64 const *") long[] fenceValueArray, @NativeType(value="GLuint") int readGpu, @NativeType(value="GLbitfield") int writeGpuMask, @NativeType(value="GLuint") int readBuffer, @NativeType(value="GLuint") int writeBuffer, @NativeType(value="GLintptr") long readOffset, @NativeType(value="GLintptr") long writeOffset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLuint const *") int[] signalSemaphoreArray, @NativeType(value="GLuint64 const *") long[] signalValueArray) {
        long __functionAddress = GL.getICD().glAsyncCopyBufferSubDataNVX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(fenceValueArray, waitSemaphoreArray.length);
            Checks.check(signalValueArray, signalSemaphoreArray.length);
        }
        return JNI.callPPPPPPPP(waitSemaphoreArray.length, waitSemaphoreArray, fenceValueArray, readGpu, writeGpuMask, readBuffer, writeBuffer, readOffset, writeOffset, size, signalSemaphoreArray.length, signalSemaphoreArray, signalValueArray, __functionAddress);
    }

    public static void glMulticastViewportArrayvNVX(@NativeType(value="GLuint") int gpu, @NativeType(value="GLuint") int first, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glMulticastViewportArrayvNVX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(gpu, first, v.length >> 2, v, __functionAddress);
    }

    public static void glMulticastScissorArrayvNVX(@NativeType(value="GLuint") int gpu, @NativeType(value="GLuint") int first, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glMulticastScissorArrayvNVX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(gpu, first, v.length >> 2, v, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

