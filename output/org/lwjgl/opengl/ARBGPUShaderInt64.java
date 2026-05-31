/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.LongBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBGPUShaderInt64 {
    public static final int GL_INT64_ARB = 5134;
    public static final int GL_UNSIGNED_INT64_ARB = 5135;
    public static final int GL_INT64_VEC2_ARB = 36841;
    public static final int GL_INT64_VEC3_ARB = 36842;
    public static final int GL_INT64_VEC4_ARB = 36843;
    public static final int GL_UNSIGNED_INT64_VEC2_ARB = 36853;
    public static final int GL_UNSIGNED_INT64_VEC3_ARB = 36854;
    public static final int GL_UNSIGNED_INT64_VEC4_ARB = 36855;

    protected ARBGPUShaderInt64() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glUniform1i64ARB, caps.glUniform1i64vARB, caps.glProgramUniform1i64ARB, caps.glProgramUniform1i64vARB, caps.glUniform2i64ARB, caps.glUniform2i64vARB, caps.glProgramUniform2i64ARB, caps.glProgramUniform2i64vARB, caps.glUniform3i64ARB, caps.glUniform3i64vARB, caps.glProgramUniform3i64ARB, caps.glProgramUniform3i64vARB, caps.glUniform4i64ARB, caps.glUniform4i64vARB, caps.glProgramUniform4i64ARB, caps.glProgramUniform4i64vARB, caps.glUniform1ui64ARB, caps.glUniform1ui64vARB, caps.glProgramUniform1ui64ARB, caps.glProgramUniform1ui64vARB, caps.glUniform2ui64ARB, caps.glUniform2ui64vARB, caps.glProgramUniform2ui64ARB, caps.glProgramUniform2ui64vARB, caps.glUniform3ui64ARB, caps.glUniform3ui64vARB, caps.glProgramUniform3ui64ARB, caps.glProgramUniform3ui64vARB, caps.glUniform4ui64ARB, caps.glUniform4ui64vARB, caps.glProgramUniform4ui64ARB, caps.glProgramUniform4ui64vARB, caps.glGetUniformi64vARB, caps.glGetUniformui64vARB, caps.glGetnUniformi64vARB, caps.glGetnUniformui64vARB);
    }

    public static native void glUniform1i64ARB(@NativeType(value="GLint") int var0, @NativeType(value="GLint64") long var1);

    public static native void nglUniform1i64vARB(int var0, int var1, long var2);

    public static void glUniform1i64vARB(@NativeType(value="GLint") int location, @NativeType(value="GLint64 *") LongBuffer value) {
        ARBGPUShaderInt64.nglUniform1i64vARB(location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void glProgramUniform1i64ARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint64") long var2);

    public static native void nglProgramUniform1i64vARB(int var0, int var1, int var2, long var3);

    public static void glProgramUniform1i64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64 *") LongBuffer value) {
        ARBGPUShaderInt64.nglProgramUniform1i64vARB(program, location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void glUniform2i64ARB(@NativeType(value="GLint") int var0, @NativeType(value="GLint64") long var1, @NativeType(value="GLint64") long var3);

    public static native void nglUniform2i64vARB(int var0, int var1, long var2);

    public static void glUniform2i64vARB(@NativeType(value="GLint") int location, @NativeType(value="GLint64 *") LongBuffer value) {
        ARBGPUShaderInt64.nglUniform2i64vARB(location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void glProgramUniform2i64ARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint64") long var2, @NativeType(value="GLint64") long var4);

    public static native void nglProgramUniform2i64vARB(int var0, int var1, int var2, long var3);

    public static void glProgramUniform2i64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64 *") LongBuffer value) {
        ARBGPUShaderInt64.nglProgramUniform2i64vARB(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void glUniform3i64ARB(@NativeType(value="GLint") int var0, @NativeType(value="GLint64") long var1, @NativeType(value="GLint64") long var3, @NativeType(value="GLint64") long var5);

    public static native void nglUniform3i64vARB(int var0, int var1, long var2);

    public static void glUniform3i64vARB(@NativeType(value="GLint") int location, @NativeType(value="GLint64 *") LongBuffer value) {
        ARBGPUShaderInt64.nglUniform3i64vARB(location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void glProgramUniform3i64ARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint64") long var2, @NativeType(value="GLint64") long var4, @NativeType(value="GLint64") long var6);

    public static native void nglProgramUniform3i64vARB(int var0, int var1, int var2, long var3);

    public static void glProgramUniform3i64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64 *") LongBuffer value) {
        ARBGPUShaderInt64.nglProgramUniform3i64vARB(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void glUniform4i64ARB(@NativeType(value="GLint") int var0, @NativeType(value="GLint64") long var1, @NativeType(value="GLint64") long var3, @NativeType(value="GLint64") long var5, @NativeType(value="GLint64") long var7);

    public static native void nglUniform4i64vARB(int var0, int var1, long var2);

    public static void glUniform4i64vARB(@NativeType(value="GLint") int location, @NativeType(value="GLint64 *") LongBuffer value) {
        ARBGPUShaderInt64.nglUniform4i64vARB(location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static native void glProgramUniform4i64ARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint64") long var2, @NativeType(value="GLint64") long var4, @NativeType(value="GLint64") long var6, @NativeType(value="GLint64") long var8);

    public static native void nglProgramUniform4i64vARB(int var0, int var1, int var2, long var3);

    public static void glProgramUniform4i64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64 *") LongBuffer value) {
        ARBGPUShaderInt64.nglProgramUniform4i64vARB(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static native void glUniform1ui64ARB(@NativeType(value="GLint") int var0, @NativeType(value="GLuint64") long var1);

    public static native void nglUniform1ui64vARB(int var0, int var1, long var2);

    public static void glUniform1ui64vARB(@NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") LongBuffer value) {
        ARBGPUShaderInt64.nglUniform1ui64vARB(location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void glProgramUniform1ui64ARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint64") long var2);

    public static native void nglProgramUniform1ui64vARB(int var0, int var1, int var2, long var3);

    public static void glProgramUniform1ui64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") LongBuffer value) {
        ARBGPUShaderInt64.nglProgramUniform1ui64vARB(program, location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void glUniform2ui64ARB(@NativeType(value="GLint") int var0, @NativeType(value="GLuint64") long var1, @NativeType(value="GLuint64") long var3);

    public static native void nglUniform2ui64vARB(int var0, int var1, long var2);

    public static void glUniform2ui64vARB(@NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") LongBuffer value) {
        ARBGPUShaderInt64.nglUniform2ui64vARB(location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void glProgramUniform2ui64ARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint64") long var2, @NativeType(value="GLuint64") long var4);

    public static native void nglProgramUniform2ui64vARB(int var0, int var1, int var2, long var3);

    public static void glProgramUniform2ui64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") LongBuffer value) {
        ARBGPUShaderInt64.nglProgramUniform2ui64vARB(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void glUniform3ui64ARB(@NativeType(value="GLint") int var0, @NativeType(value="GLuint64") long var1, @NativeType(value="GLuint64") long var3, @NativeType(value="GLuint64") long var5);

    public static native void nglUniform3ui64vARB(int var0, int var1, long var2);

    public static void glUniform3ui64vARB(@NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") LongBuffer value) {
        ARBGPUShaderInt64.nglUniform3ui64vARB(location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void glProgramUniform3ui64ARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint64") long var2, @NativeType(value="GLuint64") long var4, @NativeType(value="GLuint64") long var6);

    public static native void nglProgramUniform3ui64vARB(int var0, int var1, int var2, long var3);

    public static void glProgramUniform3ui64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") LongBuffer value) {
        ARBGPUShaderInt64.nglProgramUniform3ui64vARB(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void glUniform4ui64ARB(@NativeType(value="GLint") int var0, @NativeType(value="GLuint64") long var1, @NativeType(value="GLuint64") long var3, @NativeType(value="GLuint64") long var5, @NativeType(value="GLuint64") long var7);

    public static native void nglUniform4ui64vARB(int var0, int var1, long var2);

    public static void glUniform4ui64vARB(@NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") LongBuffer value) {
        ARBGPUShaderInt64.nglUniform4ui64vARB(location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static native void glProgramUniform4ui64ARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint64") long var2, @NativeType(value="GLuint64") long var4, @NativeType(value="GLuint64") long var6, @NativeType(value="GLuint64") long var8);

    public static native void nglProgramUniform4ui64vARB(int var0, int var1, int var2, long var3);

    public static void glProgramUniform4ui64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") LongBuffer value) {
        ARBGPUShaderInt64.nglProgramUniform4ui64vARB(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static native void nglGetUniformi64vARB(int var0, int var1, long var2);

    public static void glGetUniformi64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64 *") LongBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        ARBGPUShaderInt64.nglGetUniformi64vARB(program, location, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetUniformi64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer params = stack.callocLong(1);
            ARBGPUShaderInt64.nglGetUniformi64vARB(program, location, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetUniformui64vARB(int var0, int var1, long var2);

    public static void glGetUniformui64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64 *") LongBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        ARBGPUShaderInt64.nglGetUniformui64vARB(program, location, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetUniformui64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer params = stack.callocLong(1);
            ARBGPUShaderInt64.nglGetUniformui64vARB(program, location, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetnUniformi64vARB(int var0, int var1, int var2, long var3);

    public static void glGetnUniformi64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64 *") LongBuffer params) {
        ARBGPUShaderInt64.nglGetnUniformi64vARB(program, location, params.remaining(), MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetnUniformi64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer params = stack.callocLong(1);
            ARBGPUShaderInt64.nglGetnUniformi64vARB(program, location, 1, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetnUniformui64vARB(int var0, int var1, int var2, long var3);

    public static void glGetnUniformui64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64 *") LongBuffer params) {
        ARBGPUShaderInt64.nglGetnUniformui64vARB(program, location, params.remaining(), MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetnUniformui64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer params = stack.callocLong(1);
            ARBGPUShaderInt64.nglGetnUniformui64vARB(program, location, 1, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glUniform1i64vARB(@NativeType(value="GLint") int location, @NativeType(value="GLint64 *") long[] value) {
        long __functionAddress = GL.getICD().glUniform1i64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length, value, __functionAddress);
    }

    public static void glProgramUniform1i64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64 *") long[] value) {
        long __functionAddress = GL.getICD().glProgramUniform1i64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length, value, __functionAddress);
    }

    public static void glUniform2i64vARB(@NativeType(value="GLint") int location, @NativeType(value="GLint64 *") long[] value) {
        long __functionAddress = GL.getICD().glUniform2i64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 1, value, __functionAddress);
    }

    public static void glProgramUniform2i64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64 *") long[] value) {
        long __functionAddress = GL.getICD().glProgramUniform2i64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
    }

    public static void glUniform3i64vARB(@NativeType(value="GLint") int location, @NativeType(value="GLint64 *") long[] value) {
        long __functionAddress = GL.getICD().glUniform3i64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length / 3, value, __functionAddress);
    }

    public static void glProgramUniform3i64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64 *") long[] value) {
        long __functionAddress = GL.getICD().glProgramUniform3i64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 3, value, __functionAddress);
    }

    public static void glUniform4i64vARB(@NativeType(value="GLint") int location, @NativeType(value="GLint64 *") long[] value) {
        long __functionAddress = GL.getICD().glUniform4i64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 2, value, __functionAddress);
    }

    public static void glProgramUniform4i64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64 *") long[] value) {
        long __functionAddress = GL.getICD().glProgramUniform4i64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
    }

    public static void glUniform1ui64vARB(@NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") long[] value) {
        long __functionAddress = GL.getICD().glUniform1ui64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length, value, __functionAddress);
    }

    public static void glProgramUniform1ui64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") long[] value) {
        long __functionAddress = GL.getICD().glProgramUniform1ui64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length, value, __functionAddress);
    }

    public static void glUniform2ui64vARB(@NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") long[] value) {
        long __functionAddress = GL.getICD().glUniform2ui64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 1, value, __functionAddress);
    }

    public static void glProgramUniform2ui64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") long[] value) {
        long __functionAddress = GL.getICD().glProgramUniform2ui64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
    }

    public static void glUniform3ui64vARB(@NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") long[] value) {
        long __functionAddress = GL.getICD().glUniform3ui64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length / 3, value, __functionAddress);
    }

    public static void glProgramUniform3ui64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") long[] value) {
        long __functionAddress = GL.getICD().glProgramUniform3ui64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 3, value, __functionAddress);
    }

    public static void glUniform4ui64vARB(@NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") long[] value) {
        long __functionAddress = GL.getICD().glUniform4ui64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 2, value, __functionAddress);
    }

    public static void glProgramUniform4ui64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") long[] value) {
        long __functionAddress = GL.getICD().glProgramUniform4ui64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
    }

    public static void glGetUniformi64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64 *") long[] params) {
        long __functionAddress = GL.getICD().glGetUniformi64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(program, location, params, __functionAddress);
    }

    public static void glGetUniformui64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64 *") long[] params) {
        long __functionAddress = GL.getICD().glGetUniformui64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(program, location, params, __functionAddress);
    }

    public static void glGetnUniformi64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64 *") long[] params) {
        long __functionAddress = GL.getICD().glGetnUniformi64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, params.length, params, __functionAddress);
    }

    public static void glGetnUniformui64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64 *") long[] params) {
        long __functionAddress = GL.getICD().glGetnUniformui64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, params.length, params, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

