/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVGPUMulticast {
    public static final int GL_PER_GPU_STORAGE_BIT_NV = 2048;
    public static final int GL_MULTICAST_GPUS_NV = 37562;
    public static final int GL_RENDER_GPU_MASK_NV = 38232;
    public static final int GL_PER_GPU_STORAGE_NV = 38216;
    public static final int GL_MULTICAST_PROGRAMMABLE_SAMPLE_LOCATION_NV = 38217;

    protected NVGPUMulticast() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glRenderGpuMaskNV, caps.glMulticastBufferSubDataNV, caps.glMulticastCopyBufferSubDataNV, caps.glMulticastCopyImageSubDataNV, caps.glMulticastBlitFramebufferNV, caps.glMulticastFramebufferSampleLocationsfvNV, caps.glMulticastBarrierNV, caps.glMulticastWaitSyncNV, caps.glMulticastGetQueryObjectivNV, caps.glMulticastGetQueryObjectuivNV, caps.glMulticastGetQueryObjecti64vNV, caps.glMulticastGetQueryObjectui64vNV);
    }

    public static native void glRenderGpuMaskNV(@NativeType(value="GLbitfield") int var0);

    public static native void nglMulticastBufferSubDataNV(int var0, int var1, long var2, long var4, long var6);

    public static void glMulticastBufferSubDataNV(@NativeType(value="GLbitfield") int gpuMask, @NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") ByteBuffer data) {
        NVGPUMulticast.nglMulticastBufferSubDataNV(gpuMask, buffer, offset, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static void glMulticastBufferSubDataNV(@NativeType(value="GLbitfield") int gpuMask, @NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") ShortBuffer data) {
        NVGPUMulticast.nglMulticastBufferSubDataNV(gpuMask, buffer, offset, Integer.toUnsignedLong(data.remaining()) << 1, MemoryUtil.memAddress(data));
    }

    public static void glMulticastBufferSubDataNV(@NativeType(value="GLbitfield") int gpuMask, @NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") IntBuffer data) {
        NVGPUMulticast.nglMulticastBufferSubDataNV(gpuMask, buffer, offset, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data));
    }

    public static void glMulticastBufferSubDataNV(@NativeType(value="GLbitfield") int gpuMask, @NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") FloatBuffer data) {
        NVGPUMulticast.nglMulticastBufferSubDataNV(gpuMask, buffer, offset, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data));
    }

    public static void glMulticastBufferSubDataNV(@NativeType(value="GLbitfield") int gpuMask, @NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") DoubleBuffer data) {
        NVGPUMulticast.nglMulticastBufferSubDataNV(gpuMask, buffer, offset, Integer.toUnsignedLong(data.remaining()) << 3, MemoryUtil.memAddress(data));
    }

    public static native void glMulticastCopyBufferSubDataNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLbitfield") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLuint") int var3, @NativeType(value="GLintptr") long var4, @NativeType(value="GLintptr") long var6, @NativeType(value="GLsizeiptr") long var8);

    public static native void glMulticastCopyImageSubDataNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLbitfield") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLint") int var6, @NativeType(value="GLint") int var7, @NativeType(value="GLuint") int var8, @NativeType(value="GLenum") int var9, @NativeType(value="GLint") int var10, @NativeType(value="GLint") int var11, @NativeType(value="GLint") int var12, @NativeType(value="GLint") int var13, @NativeType(value="GLsizei") int var14, @NativeType(value="GLsizei") int var15, @NativeType(value="GLsizei") int var16);

    public static native void glMulticastBlitFramebufferNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLint") int var6, @NativeType(value="GLint") int var7, @NativeType(value="GLint") int var8, @NativeType(value="GLint") int var9, @NativeType(value="GLbitfield") int var10, @NativeType(value="GLenum") int var11);

    public static native void nglMulticastFramebufferSampleLocationsfvNV(int var0, int var1, int var2, int var3, long var4);

    public static void glMulticastFramebufferSampleLocationsfvNV(@NativeType(value="GLuint") int gpu, @NativeType(value="GLuint") int framebuffer, @NativeType(value="GLuint") int start, @NativeType(value="GLfloat const *") FloatBuffer v) {
        NVGPUMulticast.nglMulticastFramebufferSampleLocationsfvNV(gpu, framebuffer, start, v.remaining() >> 1, MemoryUtil.memAddress(v));
    }

    public static native void glMulticastBarrierNV();

    public static native void glMulticastWaitSyncNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLbitfield") int var1);

    public static native void nglMulticastGetQueryObjectivNV(int var0, int var1, int var2, long var3);

    public static void glMulticastGetQueryObjectivNV(@NativeType(value="GLuint") int gpu, @NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        NVGPUMulticast.nglMulticastGetQueryObjectivNV(gpu, id, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glMulticastGetQueryObjectiNV(@NativeType(value="GLuint") int gpu, @NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            NVGPUMulticast.nglMulticastGetQueryObjectivNV(gpu, id, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglMulticastGetQueryObjectuivNV(int var0, int var1, int var2, long var3);

    public static void glMulticastGetQueryObjectuivNV(@NativeType(value="GLuint") int gpu, @NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        NVGPUMulticast.nglMulticastGetQueryObjectuivNV(gpu, id, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glMulticastGetQueryObjectuiNV(@NativeType(value="GLuint") int gpu, @NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            NVGPUMulticast.nglMulticastGetQueryObjectuivNV(gpu, id, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglMulticastGetQueryObjecti64vNV(int var0, int var1, int var2, long var3);

    public static void glMulticastGetQueryObjecti64vNV(@NativeType(value="GLuint") int gpu, @NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") LongBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        NVGPUMulticast.nglMulticastGetQueryObjecti64vNV(gpu, id, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glMulticastGetQueryObjecti64NV(@NativeType(value="GLuint") int gpu, @NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer params = stack.callocLong(1);
            NVGPUMulticast.nglMulticastGetQueryObjecti64vNV(gpu, id, pname, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglMulticastGetQueryObjectui64vNV(int var0, int var1, int var2, long var3);

    public static void glMulticastGetQueryObjectui64vNV(@NativeType(value="GLuint") int gpu, @NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint64 *") LongBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        NVGPUMulticast.nglMulticastGetQueryObjectui64vNV(gpu, id, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glMulticastGetQueryObjectui64NV(@NativeType(value="GLuint") int gpu, @NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer params = stack.callocLong(1);
            NVGPUMulticast.nglMulticastGetQueryObjectui64vNV(gpu, id, pname, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glMulticastBufferSubDataNV(@NativeType(value="GLbitfield") int gpuMask, @NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") short[] data) {
        long __functionAddress = GL.getICD().glMulticastBufferSubDataNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(gpuMask, buffer, offset, Integer.toUnsignedLong(data.length) << 1, data, __functionAddress);
    }

    public static void glMulticastBufferSubDataNV(@NativeType(value="GLbitfield") int gpuMask, @NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") int[] data) {
        long __functionAddress = GL.getICD().glMulticastBufferSubDataNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(gpuMask, buffer, offset, Integer.toUnsignedLong(data.length) << 2, data, __functionAddress);
    }

    public static void glMulticastBufferSubDataNV(@NativeType(value="GLbitfield") int gpuMask, @NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") float[] data) {
        long __functionAddress = GL.getICD().glMulticastBufferSubDataNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(gpuMask, buffer, offset, Integer.toUnsignedLong(data.length) << 2, data, __functionAddress);
    }

    public static void glMulticastBufferSubDataNV(@NativeType(value="GLbitfield") int gpuMask, @NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") double[] data) {
        long __functionAddress = GL.getICD().glMulticastBufferSubDataNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(gpuMask, buffer, offset, Integer.toUnsignedLong(data.length) << 3, data, __functionAddress);
    }

    public static void glMulticastFramebufferSampleLocationsfvNV(@NativeType(value="GLuint") int gpu, @NativeType(value="GLuint") int framebuffer, @NativeType(value="GLuint") int start, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glMulticastFramebufferSampleLocationsfvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(gpu, framebuffer, start, v.length >> 1, v, __functionAddress);
    }

    public static void glMulticastGetQueryObjectivNV(@NativeType(value="GLuint") int gpu, @NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glMulticastGetQueryObjectivNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(gpu, id, pname, params, __functionAddress);
    }

    public static void glMulticastGetQueryObjectuivNV(@NativeType(value="GLuint") int gpu, @NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") int[] params) {
        long __functionAddress = GL.getICD().glMulticastGetQueryObjectuivNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(gpu, id, pname, params, __functionAddress);
    }

    public static void glMulticastGetQueryObjecti64vNV(@NativeType(value="GLuint") int gpu, @NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") long[] params) {
        long __functionAddress = GL.getICD().glMulticastGetQueryObjecti64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(gpu, id, pname, params, __functionAddress);
    }

    public static void glMulticastGetQueryObjectui64vNV(@NativeType(value="GLuint") int gpu, @NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint64 *") long[] params) {
        long __functionAddress = GL.getICD().glMulticastGetQueryObjectui64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(gpu, id, pname, params, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

