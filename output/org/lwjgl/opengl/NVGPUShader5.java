/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.LongBuffer;
import java.util.Set;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.opengl.NVShaderBufferLoad;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVGPUShader5 {
    public static final int GL_INT64_NV = 5134;
    public static final int GL_UNSIGNED_INT64_NV = 5135;
    public static final int GL_INT8_NV = 36832;
    public static final int GL_INT8_VEC2_NV = 36833;
    public static final int GL_INT8_VEC3_NV = 36834;
    public static final int GL_INT8_VEC4_NV = 36835;
    public static final int GL_INT16_NV = 36836;
    public static final int GL_INT16_VEC2_NV = 36837;
    public static final int GL_INT16_VEC3_NV = 36838;
    public static final int GL_INT16_VEC4_NV = 36839;
    public static final int GL_INT64_VEC2_NV = 36841;
    public static final int GL_INT64_VEC3_NV = 36842;
    public static final int GL_INT64_VEC4_NV = 36843;
    public static final int GL_UNSIGNED_INT8_NV = 36844;
    public static final int GL_UNSIGNED_INT8_VEC2_NV = 36845;
    public static final int GL_UNSIGNED_INT8_VEC3_NV = 36846;
    public static final int GL_UNSIGNED_INT8_VEC4_NV = 36847;
    public static final int GL_UNSIGNED_INT16_NV = 36848;
    public static final int GL_UNSIGNED_INT16_VEC2_NV = 36849;
    public static final int GL_UNSIGNED_INT16_VEC3_NV = 36850;
    public static final int GL_UNSIGNED_INT16_VEC4_NV = 36851;
    public static final int GL_UNSIGNED_INT64_VEC2_NV = 36853;
    public static final int GL_UNSIGNED_INT64_VEC3_NV = 36854;
    public static final int GL_UNSIGNED_INT64_VEC4_NV = 36855;
    public static final int GL_FLOAT16_NV = 36856;
    public static final int GL_FLOAT16_VEC2_NV = 36857;
    public static final int GL_FLOAT16_VEC3_NV = 36858;
    public static final int GL_FLOAT16_VEC4_NV = 36859;

    protected NVGPUShader5() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, Set<String> ext) {
        return Checks.checkFunctions(caps.glUniform1i64NV, caps.glUniform2i64NV, caps.glUniform3i64NV, caps.glUniform4i64NV, caps.glUniform1i64vNV, caps.glUniform2i64vNV, caps.glUniform3i64vNV, caps.glUniform4i64vNV, caps.glUniform1ui64NV, caps.glUniform2ui64NV, caps.glUniform3ui64NV, caps.glUniform4ui64NV, caps.glUniform1ui64vNV, caps.glUniform2ui64vNV, caps.glUniform3ui64vNV, caps.glUniform4ui64vNV, caps.glGetUniformi64vNV, caps.glGetUniformui64vNV, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform1i64NV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform2i64NV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform3i64NV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform4i64NV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform1i64vNV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform2i64vNV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform3i64vNV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform4i64vNV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform1ui64NV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform2ui64NV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform3ui64NV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform4ui64NV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform1ui64vNV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform2ui64vNV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform3ui64vNV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform4ui64vNV : -1L);
    }

    public static native void glUniform1i64NV(@NativeType(value="GLint") int var0, @NativeType(value="GLint64EXT") long var1);

    public static native void glUniform2i64NV(@NativeType(value="GLint") int var0, @NativeType(value="GLint64EXT") long var1, @NativeType(value="GLint64EXT") long var3);

    public static native void glUniform3i64NV(@NativeType(value="GLint") int var0, @NativeType(value="GLint64EXT") long var1, @NativeType(value="GLint64EXT") long var3, @NativeType(value="GLint64EXT") long var5);

    public static native void glUniform4i64NV(@NativeType(value="GLint") int var0, @NativeType(value="GLint64EXT") long var1, @NativeType(value="GLint64EXT") long var3, @NativeType(value="GLint64EXT") long var5, @NativeType(value="GLint64EXT") long var7);

    public static native void nglUniform1i64vNV(int var0, int var1, long var2);

    public static void glUniform1i64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") LongBuffer value) {
        NVGPUShader5.nglUniform1i64vNV(location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void nglUniform2i64vNV(int var0, int var1, long var2);

    public static void glUniform2i64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") LongBuffer value) {
        NVGPUShader5.nglUniform2i64vNV(location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void nglUniform3i64vNV(int var0, int var1, long var2);

    public static void glUniform3i64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") LongBuffer value) {
        NVGPUShader5.nglUniform3i64vNV(location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void nglUniform4i64vNV(int var0, int var1, long var2);

    public static void glUniform4i64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") LongBuffer value) {
        NVGPUShader5.nglUniform4i64vNV(location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static native void glUniform1ui64NV(@NativeType(value="GLint") int var0, @NativeType(value="GLuint64EXT") long var1);

    public static native void glUniform2ui64NV(@NativeType(value="GLint") int var0, @NativeType(value="GLuint64EXT") long var1, @NativeType(value="GLuint64EXT") long var3);

    public static native void glUniform3ui64NV(@NativeType(value="GLint") int var0, @NativeType(value="GLuint64EXT") long var1, @NativeType(value="GLuint64EXT") long var3, @NativeType(value="GLuint64EXT") long var5);

    public static native void glUniform4ui64NV(@NativeType(value="GLint") int var0, @NativeType(value="GLuint64EXT") long var1, @NativeType(value="GLuint64EXT") long var3, @NativeType(value="GLuint64EXT") long var5, @NativeType(value="GLuint64EXT") long var7);

    public static native void nglUniform1ui64vNV(int var0, int var1, long var2);

    public static void glUniform1ui64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") LongBuffer value) {
        NVGPUShader5.nglUniform1ui64vNV(location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void nglUniform2ui64vNV(int var0, int var1, long var2);

    public static void glUniform2ui64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT *") LongBuffer value) {
        NVGPUShader5.nglUniform2ui64vNV(location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void nglUniform3ui64vNV(int var0, int var1, long var2);

    public static void glUniform3ui64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") LongBuffer value) {
        NVGPUShader5.nglUniform3ui64vNV(location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void nglUniform4ui64vNV(int var0, int var1, long var2);

    public static void glUniform4ui64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") LongBuffer value) {
        NVGPUShader5.nglUniform4ui64vNV(location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static native void nglGetUniformi64vNV(int var0, int var1, long var2);

    public static void glGetUniformi64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT *") LongBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        NVGPUShader5.nglGetUniformi64vNV(program, location, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetUniformi64NV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer params = stack.callocLong(1);
            NVGPUShader5.nglGetUniformi64vNV(program, location, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void nglGetUniformui64vNV(int program, int location, long params) {
        NVShaderBufferLoad.nglGetUniformui64vNV(program, location, params);
    }

    public static void glGetUniformui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT *") LongBuffer params) {
        NVShaderBufferLoad.glGetUniformui64vNV(program, location, params);
    }

    @NativeType(value="void")
    public static long glGetUniformui64NV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        return NVShaderBufferLoad.glGetUniformui64NV(program, location);
    }

    public static native void glProgramUniform1i64NV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint64EXT") long var2);

    public static native void glProgramUniform2i64NV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint64EXT") long var2, @NativeType(value="GLint64EXT") long var4);

    public static native void glProgramUniform3i64NV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint64EXT") long var2, @NativeType(value="GLint64EXT") long var4, @NativeType(value="GLint64EXT") long var6);

    public static native void glProgramUniform4i64NV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint64EXT") long var2, @NativeType(value="GLint64EXT") long var4, @NativeType(value="GLint64EXT") long var6, @NativeType(value="GLint64EXT") long var8);

    public static native void nglProgramUniform1i64vNV(int var0, int var1, int var2, long var3);

    public static void glProgramUniform1i64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") LongBuffer value) {
        NVGPUShader5.nglProgramUniform1i64vNV(program, location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform2i64vNV(int var0, int var1, int var2, long var3);

    public static void glProgramUniform2i64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") LongBuffer value) {
        NVGPUShader5.nglProgramUniform2i64vNV(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform3i64vNV(int var0, int var1, int var2, long var3);

    public static void glProgramUniform3i64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") LongBuffer value) {
        NVGPUShader5.nglProgramUniform3i64vNV(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform4i64vNV(int var0, int var1, int var2, long var3);

    public static void glProgramUniform4i64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") LongBuffer value) {
        NVGPUShader5.nglProgramUniform4i64vNV(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static native void glProgramUniform1ui64NV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint64EXT") long var2);

    public static native void glProgramUniform2ui64NV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint64EXT") long var2, @NativeType(value="GLuint64EXT") long var4);

    public static native void glProgramUniform3ui64NV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint64EXT") long var2, @NativeType(value="GLuint64EXT") long var4, @NativeType(value="GLuint64EXT") long var6);

    public static native void glProgramUniform4ui64NV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint64EXT") long var2, @NativeType(value="GLuint64EXT") long var4, @NativeType(value="GLuint64EXT") long var6, @NativeType(value="GLuint64EXT") long var8);

    public static native void nglProgramUniform1ui64vNV(int var0, int var1, int var2, long var3);

    public static void glProgramUniform1ui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") LongBuffer value) {
        NVGPUShader5.nglProgramUniform1ui64vNV(program, location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform2ui64vNV(int var0, int var1, int var2, long var3);

    public static void glProgramUniform2ui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") LongBuffer value) {
        NVGPUShader5.nglProgramUniform2ui64vNV(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform3ui64vNV(int var0, int var1, int var2, long var3);

    public static void glProgramUniform3ui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") LongBuffer value) {
        NVGPUShader5.nglProgramUniform3ui64vNV(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform4ui64vNV(int var0, int var1, int var2, long var3);

    public static void glProgramUniform4ui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") LongBuffer value) {
        NVGPUShader5.nglProgramUniform4ui64vNV(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static void glUniform1i64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") long[] value) {
        long __functionAddress = GL.getICD().glUniform1i64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length, value, __functionAddress);
    }

    public static void glUniform2i64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") long[] value) {
        long __functionAddress = GL.getICD().glUniform2i64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 1, value, __functionAddress);
    }

    public static void glUniform3i64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") long[] value) {
        long __functionAddress = GL.getICD().glUniform3i64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length / 3, value, __functionAddress);
    }

    public static void glUniform4i64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") long[] value) {
        long __functionAddress = GL.getICD().glUniform4i64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 2, value, __functionAddress);
    }

    public static void glUniform1ui64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") long[] value) {
        long __functionAddress = GL.getICD().glUniform1ui64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length, value, __functionAddress);
    }

    public static void glUniform2ui64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT *") long[] value) {
        long __functionAddress = GL.getICD().glUniform2ui64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 1, value, __functionAddress);
    }

    public static void glUniform3ui64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") long[] value) {
        long __functionAddress = GL.getICD().glUniform3ui64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length / 3, value, __functionAddress);
    }

    public static void glUniform4ui64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") long[] value) {
        long __functionAddress = GL.getICD().glUniform4ui64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 2, value, __functionAddress);
    }

    public static void glGetUniformi64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT *") long[] params) {
        long __functionAddress = GL.getICD().glGetUniformi64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(program, location, params, __functionAddress);
    }

    public static void glGetUniformui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT *") long[] params) {
        NVShaderBufferLoad.glGetUniformui64vNV(program, location, params);
    }

    public static void glProgramUniform1i64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") long[] value) {
        long __functionAddress = GL.getICD().glProgramUniform1i64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length, value, __functionAddress);
    }

    public static void glProgramUniform2i64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") long[] value) {
        long __functionAddress = GL.getICD().glProgramUniform2i64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
    }

    public static void glProgramUniform3i64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") long[] value) {
        long __functionAddress = GL.getICD().glProgramUniform3i64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 3, value, __functionAddress);
    }

    public static void glProgramUniform4i64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") long[] value) {
        long __functionAddress = GL.getICD().glProgramUniform4i64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
    }

    public static void glProgramUniform1ui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") long[] value) {
        long __functionAddress = GL.getICD().glProgramUniform1ui64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length, value, __functionAddress);
    }

    public static void glProgramUniform2ui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") long[] value) {
        long __functionAddress = GL.getICD().glProgramUniform2ui64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
    }

    public static void glProgramUniform3ui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") long[] value) {
        long __functionAddress = GL.getICD().glProgramUniform3ui64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 3, value, __functionAddress);
    }

    public static void glProgramUniform4ui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") long[] value) {
        long __functionAddress = GL.getICD().glProgramUniform4ui64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

