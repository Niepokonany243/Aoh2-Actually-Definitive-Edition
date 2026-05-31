/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.DoubleBuffer;
import java.util.Set;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL40C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBGPUShaderFP64 {
    public static final int GL_DOUBLE_VEC2 = 36860;
    public static final int GL_DOUBLE_VEC3 = 36861;
    public static final int GL_DOUBLE_VEC4 = 36862;
    public static final int GL_DOUBLE_MAT2 = 36678;
    public static final int GL_DOUBLE_MAT3 = 36679;
    public static final int GL_DOUBLE_MAT4 = 36680;
    public static final int GL_DOUBLE_MAT2x3 = 36681;
    public static final int GL_DOUBLE_MAT2x4 = 36682;
    public static final int GL_DOUBLE_MAT3x2 = 36683;
    public static final int GL_DOUBLE_MAT3x4 = 36684;
    public static final int GL_DOUBLE_MAT4x2 = 36685;
    public static final int GL_DOUBLE_MAT4x3 = 36686;

    protected ARBGPUShaderFP64() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, Set<String> ext) {
        return Checks.checkFunctions(caps.glUniform1d, caps.glUniform2d, caps.glUniform3d, caps.glUniform4d, caps.glUniform1dv, caps.glUniform2dv, caps.glUniform3dv, caps.glUniform4dv, caps.glUniformMatrix2dv, caps.glUniformMatrix3dv, caps.glUniformMatrix4dv, caps.glUniformMatrix2x3dv, caps.glUniformMatrix2x4dv, caps.glUniformMatrix3x2dv, caps.glUniformMatrix3x4dv, caps.glUniformMatrix4x2dv, caps.glUniformMatrix4x3dv, caps.glGetUniformdv);
    }

    public static void glUniform1d(@NativeType(value="GLint") int location, @NativeType(value="GLdouble") double x) {
        GL40C.glUniform1d(location, x);
    }

    public static void glUniform2d(@NativeType(value="GLint") int location, @NativeType(value="GLdouble") double x, @NativeType(value="GLdouble") double y) {
        GL40C.glUniform2d(location, x, y);
    }

    public static void glUniform3d(@NativeType(value="GLint") int location, @NativeType(value="GLdouble") double x, @NativeType(value="GLdouble") double y, @NativeType(value="GLdouble") double z) {
        GL40C.glUniform3d(location, x, y, z);
    }

    public static void glUniform4d(@NativeType(value="GLint") int location, @NativeType(value="GLdouble") double x, @NativeType(value="GLdouble") double y, @NativeType(value="GLdouble") double z, @NativeType(value="GLdouble") double w) {
        GL40C.glUniform4d(location, x, y, z, w);
    }

    public static void nglUniform1dv(int location, int count, long value) {
        GL40C.nglUniform1dv(location, count, value);
    }

    public static void glUniform1dv(@NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.glUniform1dv(location, value);
    }

    public static void nglUniform2dv(int location, int count, long value) {
        GL40C.nglUniform2dv(location, count, value);
    }

    public static void glUniform2dv(@NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.glUniform2dv(location, value);
    }

    public static void nglUniform3dv(int location, int count, long value) {
        GL40C.nglUniform3dv(location, count, value);
    }

    public static void glUniform3dv(@NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.glUniform3dv(location, value);
    }

    public static void nglUniform4dv(int location, int count, long value) {
        GL40C.nglUniform4dv(location, count, value);
    }

    public static void glUniform4dv(@NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.glUniform4dv(location, value);
    }

    public static void nglUniformMatrix2dv(int location, int count, boolean transpose, long value) {
        GL40C.nglUniformMatrix2dv(location, count, transpose, value);
    }

    public static void glUniformMatrix2dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.glUniformMatrix2dv(location, transpose, value);
    }

    public static void nglUniformMatrix3dv(int location, int count, boolean transpose, long value) {
        GL40C.nglUniformMatrix3dv(location, count, transpose, value);
    }

    public static void glUniformMatrix3dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.glUniformMatrix3dv(location, transpose, value);
    }

    public static void nglUniformMatrix4dv(int location, int count, boolean transpose, long value) {
        GL40C.nglUniformMatrix4dv(location, count, transpose, value);
    }

    public static void glUniformMatrix4dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.glUniformMatrix4dv(location, transpose, value);
    }

    public static void nglUniformMatrix2x3dv(int location, int count, boolean transpose, long value) {
        GL40C.nglUniformMatrix2x3dv(location, count, transpose, value);
    }

    public static void glUniformMatrix2x3dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.glUniformMatrix2x3dv(location, transpose, value);
    }

    public static void nglUniformMatrix2x4dv(int location, int count, boolean transpose, long value) {
        GL40C.nglUniformMatrix2x4dv(location, count, transpose, value);
    }

    public static void glUniformMatrix2x4dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.glUniformMatrix2x4dv(location, transpose, value);
    }

    public static void nglUniformMatrix3x2dv(int location, int count, boolean transpose, long value) {
        GL40C.nglUniformMatrix3x2dv(location, count, transpose, value);
    }

    public static void glUniformMatrix3x2dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.glUniformMatrix3x2dv(location, transpose, value);
    }

    public static void nglUniformMatrix3x4dv(int location, int count, boolean transpose, long value) {
        GL40C.nglUniformMatrix3x4dv(location, count, transpose, value);
    }

    public static void glUniformMatrix3x4dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.glUniformMatrix3x4dv(location, transpose, value);
    }

    public static void nglUniformMatrix4x2dv(int location, int count, boolean transpose, long value) {
        GL40C.nglUniformMatrix4x2dv(location, count, transpose, value);
    }

    public static void glUniformMatrix4x2dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.glUniformMatrix4x2dv(location, transpose, value);
    }

    public static void nglUniformMatrix4x3dv(int location, int count, boolean transpose, long value) {
        GL40C.nglUniformMatrix4x3dv(location, count, transpose, value);
    }

    public static void glUniformMatrix4x3dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.glUniformMatrix4x3dv(location, transpose, value);
    }

    public static void nglGetUniformdv(int program, int location, long params) {
        GL40C.nglGetUniformdv(program, location, params);
    }

    public static void glGetUniformdv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble *") DoubleBuffer params) {
        GL40C.glGetUniformdv(program, location, params);
    }

    @NativeType(value="void")
    public static double glGetUniformd(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        return GL40C.glGetUniformd(program, location);
    }

    public static native void glProgramUniform1dEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLdouble") double var2);

    public static native void glProgramUniform2dEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4);

    public static native void glProgramUniform3dEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4, @NativeType(value="GLdouble") double var6);

    public static native void glProgramUniform4dEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4, @NativeType(value="GLdouble") double var6, @NativeType(value="GLdouble") double var8);

    public static native void nglProgramUniform1dvEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform1dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        ARBGPUShaderFP64.nglProgramUniform1dvEXT(program, location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform2dvEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform2dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        ARBGPUShaderFP64.nglProgramUniform2dvEXT(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform3dvEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform3dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        ARBGPUShaderFP64.nglProgramUniform3dvEXT(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform4dvEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform4dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        ARBGPUShaderFP64.nglProgramUniform4dvEXT(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix2dvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix2dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        ARBGPUShaderFP64.nglProgramUniformMatrix2dvEXT(program, location, value.remaining() >> 2, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix3dvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix3dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        ARBGPUShaderFP64.nglProgramUniformMatrix3dvEXT(program, location, value.remaining() / 9, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix4dvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix4dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        ARBGPUShaderFP64.nglProgramUniformMatrix4dvEXT(program, location, value.remaining() >> 4, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix2x3dvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix2x3dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        ARBGPUShaderFP64.nglProgramUniformMatrix2x3dvEXT(program, location, value.remaining() / 6, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix2x4dvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix2x4dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        ARBGPUShaderFP64.nglProgramUniformMatrix2x4dvEXT(program, location, value.remaining() >> 3, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix3x2dvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix3x2dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        ARBGPUShaderFP64.nglProgramUniformMatrix3x2dvEXT(program, location, value.remaining() / 6, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix3x4dvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix3x4dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        ARBGPUShaderFP64.nglProgramUniformMatrix3x4dvEXT(program, location, value.remaining() / 12, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix4x2dvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix4x2dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        ARBGPUShaderFP64.nglProgramUniformMatrix4x2dvEXT(program, location, value.remaining() >> 3, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix4x3dvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix4x3dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        ARBGPUShaderFP64.nglProgramUniformMatrix4x3dvEXT(program, location, value.remaining() / 12, transpose, MemoryUtil.memAddress(value));
    }

    public static void glUniform1dv(@NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") double[] value) {
        GL40C.glUniform1dv(location, value);
    }

    public static void glUniform2dv(@NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") double[] value) {
        GL40C.glUniform2dv(location, value);
    }

    public static void glUniform3dv(@NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") double[] value) {
        GL40C.glUniform3dv(location, value);
    }

    public static void glUniform4dv(@NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") double[] value) {
        GL40C.glUniform4dv(location, value);
    }

    public static void glUniformMatrix2dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        GL40C.glUniformMatrix2dv(location, transpose, value);
    }

    public static void glUniformMatrix3dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        GL40C.glUniformMatrix3dv(location, transpose, value);
    }

    public static void glUniformMatrix4dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        GL40C.glUniformMatrix4dv(location, transpose, value);
    }

    public static void glUniformMatrix2x3dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        GL40C.glUniformMatrix2x3dv(location, transpose, value);
    }

    public static void glUniformMatrix2x4dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        GL40C.glUniformMatrix2x4dv(location, transpose, value);
    }

    public static void glUniformMatrix3x2dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        GL40C.glUniformMatrix3x2dv(location, transpose, value);
    }

    public static void glUniformMatrix3x4dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        GL40C.glUniformMatrix3x4dv(location, transpose, value);
    }

    public static void glUniformMatrix4x2dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        GL40C.glUniformMatrix4x2dv(location, transpose, value);
    }

    public static void glUniformMatrix4x3dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        GL40C.glUniformMatrix4x3dv(location, transpose, value);
    }

    public static void glGetUniformdv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble *") double[] params) {
        GL40C.glGetUniformdv(program, location, params);
    }

    public static void glProgramUniform1dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniform1dvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length, value, __functionAddress);
    }

    public static void glProgramUniform2dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniform2dvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
    }

    public static void glProgramUniform3dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniform3dvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 3, value, __functionAddress);
    }

    public static void glProgramUniform4dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniform4dvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
    }

    public static void glProgramUniformMatrix2dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix2dvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 2, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix3dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix3dvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 9, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix4dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix4dvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 4, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix2x3dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix2x3dvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 6, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix2x4dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix2x4dvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 3, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix3x2dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix3x2dvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 6, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix3x4dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix3x4dvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 12, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix4x2dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix4x2dvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 3, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix4x3dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix4x3dvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 12, transpose, value, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

