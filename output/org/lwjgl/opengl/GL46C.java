/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL45C;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL46C
extends GL45C {
    public static final int GL_PARAMETER_BUFFER = 33006;
    public static final int GL_PARAMETER_BUFFER_BINDING = 33007;
    public static final int GL_VERTICES_SUBMITTED = 33518;
    public static final int GL_PRIMITIVES_SUBMITTED = 33519;
    public static final int GL_VERTEX_SHADER_INVOCATIONS = 33520;
    public static final int GL_TESS_CONTROL_SHADER_PATCHES = 33521;
    public static final int GL_TESS_EVALUATION_SHADER_INVOCATIONS = 33522;
    public static final int GL_GEOMETRY_SHADER_PRIMITIVES_EMITTED = 33523;
    public static final int GL_FRAGMENT_SHADER_INVOCATIONS = 33524;
    public static final int GL_COMPUTE_SHADER_INVOCATIONS = 33525;
    public static final int GL_CLIPPING_INPUT_PRIMITIVES = 33526;
    public static final int GL_CLIPPING_OUTPUT_PRIMITIVES = 33527;
    public static final int GL_POLYGON_OFFSET_CLAMP = 36379;
    public static final int GL_CONTEXT_FLAG_NO_ERROR_BIT = 8;
    public static final int GL_SHADER_BINARY_FORMAT_SPIR_V = 38225;
    public static final int GL_SPIR_V_BINARY = 38226;
    public static final int GL_SPIR_V_EXTENSIONS = 38227;
    public static final int GL_NUM_SPIR_V_EXTENSIONS = 38228;
    public static final int GL_TEXTURE_MAX_ANISOTROPY = 34046;
    public static final int GL_MAX_TEXTURE_MAX_ANISOTROPY = 34047;
    public static final int GL_TRANSFORM_FEEDBACK_OVERFLOW = 33516;
    public static final int GL_TRANSFORM_FEEDBACK_STREAM_OVERFLOW = 33517;

    protected GL46C() {
        throw new UnsupportedOperationException();
    }

    public static native void nglMultiDrawArraysIndirectCount(int var0, long var1, long var3, int var5, int var6);

    public static void glMultiDrawArraysIndirectCount(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ByteBuffer indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)indirect, maxdrawcount * (stride == 0 ? 16 : stride));
        }
        GL46C.nglMultiDrawArraysIndirectCount(mode, MemoryUtil.memAddress(indirect), drawcount, maxdrawcount, stride);
    }

    public static void glMultiDrawArraysIndirectCount(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") long indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        GL46C.nglMultiDrawArraysIndirectCount(mode, indirect, drawcount, maxdrawcount, stride);
    }

    public static void glMultiDrawArraysIndirectCount(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") IntBuffer indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)indirect, maxdrawcount * (stride == 0 ? 16 : stride) >> 2);
        }
        GL46C.nglMultiDrawArraysIndirectCount(mode, MemoryUtil.memAddress(indirect), drawcount, maxdrawcount, stride);
    }

    public static native void nglMultiDrawElementsIndirectCount(int var0, int var1, long var2, long var4, int var6, int var7);

    public static void glMultiDrawElementsIndirectCount(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)indirect, maxdrawcount * (stride == 0 ? 20 : stride));
        }
        GL46C.nglMultiDrawElementsIndirectCount(mode, type, MemoryUtil.memAddress(indirect), drawcount, maxdrawcount, stride);
    }

    public static void glMultiDrawElementsIndirectCount(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        GL46C.nglMultiDrawElementsIndirectCount(mode, type, indirect, drawcount, maxdrawcount, stride);
    }

    public static void glMultiDrawElementsIndirectCount(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)indirect, maxdrawcount * (stride == 0 ? 20 : stride) >> 2);
        }
        GL46C.nglMultiDrawElementsIndirectCount(mode, type, MemoryUtil.memAddress(indirect), drawcount, maxdrawcount, stride);
    }

    public static native void glPolygonOffsetClamp(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    public static native void nglSpecializeShader(int var0, long var1, int var3, long var4, long var6);

    public static void glSpecializeShader(@NativeType(value="GLuint") int shader, @NativeType(value="GLchar const *") ByteBuffer pEntryPoint, @NativeType(value="GLuint const *") IntBuffer pConstantIndex, @NativeType(value="GLuint const *") IntBuffer pConstantValue) {
        if (Checks.CHECKS) {
            Checks.checkNT1(pEntryPoint);
            Checks.check((Buffer)pConstantValue, pConstantIndex.remaining());
        }
        GL46C.nglSpecializeShader(shader, MemoryUtil.memAddress(pEntryPoint), pConstantIndex.remaining(), MemoryUtil.memAddress(pConstantIndex), MemoryUtil.memAddress(pConstantValue));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glSpecializeShader(@NativeType(value="GLuint") int shader, @NativeType(value="GLchar const *") CharSequence pEntryPoint, @NativeType(value="GLuint const *") IntBuffer pConstantIndex, @NativeType(value="GLuint const *") IntBuffer pConstantValue) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)pConstantValue, pConstantIndex.remaining());
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(pEntryPoint, true);
            long pEntryPointEncoded = stack.getPointerAddress();
            GL46C.nglSpecializeShader(shader, pEntryPointEncoded, pConstantIndex.remaining(), MemoryUtil.memAddress(pConstantIndex), MemoryUtil.memAddress(pConstantValue));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glMultiDrawArraysIndirectCount(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") int[] indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        long __functionAddress = GL.getICD().glMultiDrawArraysIndirectCount;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(indirect, maxdrawcount * (stride == 0 ? 16 : stride) >> 2);
        }
        JNI.callPPV(mode, indirect, drawcount, maxdrawcount, stride, __functionAddress);
    }

    public static void glMultiDrawElementsIndirectCount(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        long __functionAddress = GL.getICD().glMultiDrawElementsIndirectCount;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(indirect, maxdrawcount * (stride == 0 ? 20 : stride) >> 2);
        }
        JNI.callPPV(mode, type, indirect, drawcount, maxdrawcount, stride, __functionAddress);
    }

    public static void glSpecializeShader(@NativeType(value="GLuint") int shader, @NativeType(value="GLchar const *") ByteBuffer pEntryPoint, @NativeType(value="GLuint const *") int[] pConstantIndex, @NativeType(value="GLuint const *") int[] pConstantValue) {
        long __functionAddress = GL.getICD().glSpecializeShader;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkNT1(pEntryPoint);
            Checks.check(pConstantValue, pConstantIndex.length);
        }
        JNI.callPPPV(shader, MemoryUtil.memAddress(pEntryPoint), pConstantIndex.length, pConstantIndex, pConstantValue, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glSpecializeShader(@NativeType(value="GLuint") int shader, @NativeType(value="GLchar const *") CharSequence pEntryPoint, @NativeType(value="GLuint const *") int[] pConstantIndex, @NativeType(value="GLuint const *") int[] pConstantValue) {
        long __functionAddress = GL.getICD().glSpecializeShader;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(pConstantValue, pConstantIndex.length);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(pEntryPoint, true);
            long pEntryPointEncoded = stack.getPointerAddress();
            JNI.callPPPV(shader, pEntryPointEncoded, pConstantIndex.length, pConstantIndex, pConstantValue, __functionAddress);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    static {
        GL.initialize();
    }
}

