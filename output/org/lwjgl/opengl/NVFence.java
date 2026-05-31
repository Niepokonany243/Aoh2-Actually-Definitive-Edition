/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVFence {
    public static final int GL_ALL_COMPLETED_NV = 34034;
    public static final int GL_FENCE_STATUS_NV = 34035;
    public static final int GL_FENCE_CONDITION_NV = 34036;

    protected NVFence() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glDeleteFencesNV, caps.glGenFencesNV, caps.glIsFenceNV, caps.glTestFenceNV, caps.glGetFenceivNV, caps.glFinishFenceNV, caps.glSetFenceNV);
    }

    public static native void nglDeleteFencesNV(int var0, long var1);

    public static void glDeleteFencesNV(@NativeType(value="GLuint const *") IntBuffer fences) {
        NVFence.nglDeleteFencesNV(fences.remaining(), MemoryUtil.memAddress(fences));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDeleteFencesNV(@NativeType(value="GLuint const *") int fence) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer fences = stack.ints(fence);
            NVFence.nglDeleteFencesNV(1, MemoryUtil.memAddress(fences));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGenFencesNV(int var0, long var1);

    public static void glGenFencesNV(@NativeType(value="GLuint *") IntBuffer fences) {
        NVFence.nglGenFencesNV(fences.remaining(), MemoryUtil.memAddress(fences));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGenFencesNV() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer fences = stack.callocInt(1);
            NVFence.nglGenFencesNV(1, MemoryUtil.memAddress(fences));
            int n = fences.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="GLboolean")
    public static native boolean glIsFenceNV(@NativeType(value="GLuint") int var0);

    @NativeType(value="GLboolean")
    public static native boolean glTestFenceNV(@NativeType(value="GLuint") int var0);

    public static native void nglGetFenceivNV(int var0, int var1, long var2);

    public static void glGetFenceivNV(@NativeType(value="GLuint") int fence, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        NVFence.nglGetFenceivNV(fence, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetFenceiNV(@NativeType(value="GLuint") int fence, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            NVFence.nglGetFenceivNV(fence, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glFinishFenceNV(@NativeType(value="GLuint") int var0);

    public static native void glSetFenceNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static void glDeleteFencesNV(@NativeType(value="GLuint const *") int[] fences) {
        long __functionAddress = GL.getICD().glDeleteFencesNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(fences.length, fences, __functionAddress);
    }

    public static void glGenFencesNV(@NativeType(value="GLuint *") int[] fences) {
        long __functionAddress = GL.getICD().glGenFencesNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(fences.length, fences, __functionAddress);
    }

    public static void glGetFenceivNV(@NativeType(value="GLuint") int fence, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetFenceivNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(fence, pname, params, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

