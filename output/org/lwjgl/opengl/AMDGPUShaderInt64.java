/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.LongBuffer;
import java.util.Set;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.opengl.NVGPUShader5;
import org.lwjgl.opengl.NVShaderBufferLoad;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class AMDGPUShaderInt64 {
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

    protected AMDGPUShaderInt64() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, Set<String> ext) {
        return Checks.checkFunctions(caps.glUniform1i64NV, caps.glUniform2i64NV, caps.glUniform3i64NV, caps.glUniform4i64NV, caps.glUniform1i64vNV, caps.glUniform2i64vNV, caps.glUniform3i64vNV, caps.glUniform4i64vNV, caps.glUniform1ui64NV, caps.glUniform2ui64NV, caps.glUniform3ui64NV, caps.glUniform4ui64NV, caps.glUniform1ui64vNV, caps.glUniform2ui64vNV, caps.glUniform3ui64vNV, caps.glUniform4ui64vNV, caps.glGetUniformi64vNV, caps.glGetUniformui64vNV, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform1i64NV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform2i64NV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform3i64NV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform4i64NV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform1i64vNV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform2i64vNV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform3i64vNV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform4i64vNV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform1ui64NV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform2ui64NV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform3ui64NV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform4ui64NV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform1ui64vNV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform2ui64vNV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform3ui64vNV : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glProgramUniform4ui64vNV : -1L);
    }

    public static void glUniform1i64NV(@NativeType(value="GLint") int location, @NativeType(value="GLint64EXT") long x) {
        NVGPUShader5.glUniform1i64NV(location, x);
    }

    public static void glUniform2i64NV(@NativeType(value="GLint") int location, @NativeType(value="GLint64EXT") long x, @NativeType(value="GLint64EXT") long y) {
        NVGPUShader5.glUniform2i64NV(location, x, y);
    }

    public static void glUniform3i64NV(@NativeType(value="GLint") int location, @NativeType(value="GLint64EXT") long x, @NativeType(value="GLint64EXT") long y, @NativeType(value="GLint64EXT") long z) {
        NVGPUShader5.glUniform3i64NV(location, x, y, z);
    }

    public static void glUniform4i64NV(@NativeType(value="GLint") int location, @NativeType(value="GLint64EXT") long x, @NativeType(value="GLint64EXT") long y, @NativeType(value="GLint64EXT") long z, @NativeType(value="GLint64EXT") long w) {
        NVGPUShader5.glUniform4i64NV(location, x, y, z, w);
    }

    public static void nglUniform1i64vNV(int location, int count, long value) {
        NVGPUShader5.nglUniform1i64vNV(location, count, value);
    }

    public static void glUniform1i64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") LongBuffer value) {
        NVGPUShader5.glUniform1i64vNV(location, value);
    }

    public static void nglUniform2i64vNV(int location, int count, long value) {
        NVGPUShader5.nglUniform2i64vNV(location, count, value);
    }

    public static void glUniform2i64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") LongBuffer value) {
        NVGPUShader5.glUniform2i64vNV(location, value);
    }

    public static void nglUniform3i64vNV(int location, int count, long value) {
        NVGPUShader5.nglUniform3i64vNV(location, count, value);
    }

    public static void glUniform3i64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") LongBuffer value) {
        NVGPUShader5.glUniform3i64vNV(location, value);
    }

    public static void nglUniform4i64vNV(int location, int count, long value) {
        NVGPUShader5.nglUniform4i64vNV(location, count, value);
    }

    public static void glUniform4i64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") LongBuffer value) {
        NVGPUShader5.glUniform4i64vNV(location, value);
    }

    public static void glUniform1ui64NV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT") long x) {
        NVGPUShader5.glUniform1ui64NV(location, x);
    }

    public static void glUniform2ui64NV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT") long x, @NativeType(value="GLuint64EXT") long y) {
        NVGPUShader5.glUniform2ui64NV(location, x, y);
    }

    public static void glUniform3ui64NV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT") long x, @NativeType(value="GLuint64EXT") long y, @NativeType(value="GLuint64EXT") long z) {
        NVGPUShader5.glUniform3ui64NV(location, x, y, z);
    }

    public static void glUniform4ui64NV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT") long x, @NativeType(value="GLuint64EXT") long y, @NativeType(value="GLuint64EXT") long z, @NativeType(value="GLuint64EXT") long w) {
        NVGPUShader5.glUniform4ui64NV(location, x, y, z, w);
    }

    public static void nglUniform1ui64vNV(int location, int count, long value) {
        NVGPUShader5.nglUniform1ui64vNV(location, count, value);
    }

    public static void glUniform1ui64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") LongBuffer value) {
        NVGPUShader5.glUniform1ui64vNV(location, value);
    }

    public static void nglUniform2ui64vNV(int location, int count, long value) {
        NVGPUShader5.nglUniform2ui64vNV(location, count, value);
    }

    public static void glUniform2ui64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT *") LongBuffer value) {
        NVGPUShader5.glUniform2ui64vNV(location, value);
    }

    public static void nglUniform3ui64vNV(int location, int count, long value) {
        NVGPUShader5.nglUniform3ui64vNV(location, count, value);
    }

    public static void glUniform3ui64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") LongBuffer value) {
        NVGPUShader5.glUniform3ui64vNV(location, value);
    }

    public static void nglUniform4ui64vNV(int location, int count, long value) {
        NVGPUShader5.nglUniform4ui64vNV(location, count, value);
    }

    public static void glUniform4ui64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") LongBuffer value) {
        NVGPUShader5.glUniform4ui64vNV(location, value);
    }

    public static void nglGetUniformi64vNV(int program, int location, long params) {
        NVGPUShader5.nglGetUniformi64vNV(program, location, params);
    }

    public static void glGetUniformi64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT *") LongBuffer params) {
        NVGPUShader5.glGetUniformi64vNV(program, location, params);
    }

    @NativeType(value="void")
    public static long glGetUniformi64NV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        return NVGPUShader5.glGetUniformi64NV(program, location);
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

    public static void glProgramUniform1i64NV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT") long x) {
        NVGPUShader5.glProgramUniform1i64NV(program, location, x);
    }

    public static void glProgramUniform2i64NV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT") long x, @NativeType(value="GLint64EXT") long y) {
        NVGPUShader5.glProgramUniform2i64NV(program, location, x, y);
    }

    public static void glProgramUniform3i64NV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT") long x, @NativeType(value="GLint64EXT") long y, @NativeType(value="GLint64EXT") long z) {
        NVGPUShader5.glProgramUniform3i64NV(program, location, x, y, z);
    }

    public static void glProgramUniform4i64NV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT") long x, @NativeType(value="GLint64EXT") long y, @NativeType(value="GLint64EXT") long z, @NativeType(value="GLint64EXT") long w) {
        NVGPUShader5.glProgramUniform4i64NV(program, location, x, y, z, w);
    }

    public static void nglProgramUniform1i64vNV(int program, int location, int count, long value) {
        NVGPUShader5.nglProgramUniform1i64vNV(program, location, count, value);
    }

    public static void glProgramUniform1i64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") LongBuffer value) {
        NVGPUShader5.glProgramUniform1i64vNV(program, location, value);
    }

    public static void nglProgramUniform2i64vNV(int program, int location, int count, long value) {
        NVGPUShader5.nglProgramUniform2i64vNV(program, location, count, value);
    }

    public static void glProgramUniform2i64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") LongBuffer value) {
        NVGPUShader5.glProgramUniform2i64vNV(program, location, value);
    }

    public static void nglProgramUniform3i64vNV(int program, int location, int count, long value) {
        NVGPUShader5.nglProgramUniform3i64vNV(program, location, count, value);
    }

    public static void glProgramUniform3i64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") LongBuffer value) {
        NVGPUShader5.glProgramUniform3i64vNV(program, location, value);
    }

    public static void nglProgramUniform4i64vNV(int program, int location, int count, long value) {
        NVGPUShader5.nglProgramUniform4i64vNV(program, location, count, value);
    }

    public static void glProgramUniform4i64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") LongBuffer value) {
        NVGPUShader5.glProgramUniform4i64vNV(program, location, value);
    }

    public static void glProgramUniform1ui64NV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT") long x) {
        NVGPUShader5.glProgramUniform1ui64NV(program, location, x);
    }

    public static void glProgramUniform2ui64NV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT") long x, @NativeType(value="GLuint64EXT") long y) {
        NVGPUShader5.glProgramUniform2ui64NV(program, location, x, y);
    }

    public static void glProgramUniform3ui64NV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT") long x, @NativeType(value="GLuint64EXT") long y, @NativeType(value="GLuint64EXT") long z) {
        NVGPUShader5.glProgramUniform3ui64NV(program, location, x, y, z);
    }

    public static void glProgramUniform4ui64NV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT") long x, @NativeType(value="GLuint64EXT") long y, @NativeType(value="GLuint64EXT") long z, @NativeType(value="GLuint64EXT") long w) {
        NVGPUShader5.glProgramUniform4ui64NV(program, location, x, y, z, w);
    }

    public static void nglProgramUniform1ui64vNV(int program, int location, int count, long value) {
        NVGPUShader5.nglProgramUniform1ui64vNV(program, location, count, value);
    }

    public static void glProgramUniform1ui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") LongBuffer value) {
        NVGPUShader5.glProgramUniform1ui64vNV(program, location, value);
    }

    public static void nglProgramUniform2ui64vNV(int program, int location, int count, long value) {
        NVGPUShader5.nglProgramUniform2ui64vNV(program, location, count, value);
    }

    public static void glProgramUniform2ui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") LongBuffer value) {
        NVGPUShader5.glProgramUniform2ui64vNV(program, location, value);
    }

    public static void nglProgramUniform3ui64vNV(int program, int location, int count, long value) {
        NVGPUShader5.nglProgramUniform3ui64vNV(program, location, count, value);
    }

    public static void glProgramUniform3ui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") LongBuffer value) {
        NVGPUShader5.glProgramUniform3ui64vNV(program, location, value);
    }

    public static void nglProgramUniform4ui64vNV(int program, int location, int count, long value) {
        NVGPUShader5.nglProgramUniform4ui64vNV(program, location, count, value);
    }

    public static void glProgramUniform4ui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") LongBuffer value) {
        NVGPUShader5.glProgramUniform4ui64vNV(program, location, value);
    }

    public static void glUniform1i64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") long[] value) {
        NVGPUShader5.glUniform1i64vNV(location, value);
    }

    public static void glUniform2i64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") long[] value) {
        NVGPUShader5.glUniform2i64vNV(location, value);
    }

    public static void glUniform3i64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") long[] value) {
        NVGPUShader5.glUniform3i64vNV(location, value);
    }

    public static void glUniform4i64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") long[] value) {
        NVGPUShader5.glUniform4i64vNV(location, value);
    }

    public static void glUniform1ui64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") long[] value) {
        NVGPUShader5.glUniform1ui64vNV(location, value);
    }

    public static void glUniform2ui64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT *") long[] value) {
        NVGPUShader5.glUniform2ui64vNV(location, value);
    }

    public static void glUniform3ui64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") long[] value) {
        NVGPUShader5.glUniform3ui64vNV(location, value);
    }

    public static void glUniform4ui64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") long[] value) {
        NVGPUShader5.glUniform4ui64vNV(location, value);
    }

    public static void glGetUniformi64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT *") long[] params) {
        NVGPUShader5.glGetUniformi64vNV(program, location, params);
    }

    public static void glGetUniformui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT *") long[] params) {
        NVShaderBufferLoad.glGetUniformui64vNV(program, location, params);
    }

    public static void glProgramUniform1i64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") long[] value) {
        NVGPUShader5.glProgramUniform1i64vNV(program, location, value);
    }

    public static void glProgramUniform2i64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") long[] value) {
        NVGPUShader5.glProgramUniform2i64vNV(program, location, value);
    }

    public static void glProgramUniform3i64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") long[] value) {
        NVGPUShader5.glProgramUniform3i64vNV(program, location, value);
    }

    public static void glProgramUniform4i64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint64EXT const *") long[] value) {
        NVGPUShader5.glProgramUniform4i64vNV(program, location, value);
    }

    public static void glProgramUniform1ui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") long[] value) {
        NVGPUShader5.glProgramUniform1ui64vNV(program, location, value);
    }

    public static void glProgramUniform2ui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") long[] value) {
        NVGPUShader5.glProgramUniform2ui64vNV(program, location, value);
    }

    public static void glProgramUniform3ui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") long[] value) {
        NVGPUShader5.glProgramUniform3ui64vNV(program, location, value);
    }

    public static void glProgramUniform4ui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") long[] value) {
        NVGPUShader5.glProgramUniform4ui64vNV(program, location, value);
    }

    static {
        GL.initialize();
    }
}

