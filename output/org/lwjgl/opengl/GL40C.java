/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL33C;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL40C
extends GL33C {
    public static final int GL_DRAW_INDIRECT_BUFFER = 36671;
    public static final int GL_DRAW_INDIRECT_BUFFER_BINDING = 36675;
    public static final int GL_GEOMETRY_SHADER_INVOCATIONS = 34943;
    public static final int GL_MAX_GEOMETRY_SHADER_INVOCATIONS = 36442;
    public static final int GL_MIN_FRAGMENT_INTERPOLATION_OFFSET = 36443;
    public static final int GL_MAX_FRAGMENT_INTERPOLATION_OFFSET = 36444;
    public static final int GL_FRAGMENT_INTERPOLATION_OFFSET_BITS = 36445;
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
    public static final int GL_SAMPLE_SHADING = 35894;
    public static final int GL_MIN_SAMPLE_SHADING_VALUE = 35895;
    public static final int GL_ACTIVE_SUBROUTINES = 36325;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORMS = 36326;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_LOCATIONS = 36423;
    public static final int GL_ACTIVE_SUBROUTINE_MAX_LENGTH = 36424;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_MAX_LENGTH = 36425;
    public static final int GL_MAX_SUBROUTINES = 36327;
    public static final int GL_MAX_SUBROUTINE_UNIFORM_LOCATIONS = 36328;
    public static final int GL_NUM_COMPATIBLE_SUBROUTINES = 36426;
    public static final int GL_COMPATIBLE_SUBROUTINES = 36427;
    public static final int GL_PATCHES = 14;
    public static final int GL_PATCH_VERTICES = 36466;
    public static final int GL_PATCH_DEFAULT_INNER_LEVEL = 36467;
    public static final int GL_PATCH_DEFAULT_OUTER_LEVEL = 36468;
    public static final int GL_TESS_CONTROL_OUTPUT_VERTICES = 36469;
    public static final int GL_TESS_GEN_MODE = 36470;
    public static final int GL_TESS_GEN_SPACING = 36471;
    public static final int GL_TESS_GEN_VERTEX_ORDER = 36472;
    public static final int GL_TESS_GEN_POINT_MODE = 36473;
    public static final int GL_ISOLINES = 36474;
    public static final int GL_FRACTIONAL_ODD = 36475;
    public static final int GL_FRACTIONAL_EVEN = 36476;
    public static final int GL_MAX_PATCH_VERTICES = 36477;
    public static final int GL_MAX_TESS_GEN_LEVEL = 36478;
    public static final int GL_MAX_TESS_CONTROL_UNIFORM_COMPONENTS = 36479;
    public static final int GL_MAX_TESS_EVALUATION_UNIFORM_COMPONENTS = 36480;
    public static final int GL_MAX_TESS_CONTROL_TEXTURE_IMAGE_UNITS = 36481;
    public static final int GL_MAX_TESS_EVALUATION_TEXTURE_IMAGE_UNITS = 36482;
    public static final int GL_MAX_TESS_CONTROL_OUTPUT_COMPONENTS = 36483;
    public static final int GL_MAX_TESS_PATCH_COMPONENTS = 36484;
    public static final int GL_MAX_TESS_CONTROL_TOTAL_OUTPUT_COMPONENTS = 36485;
    public static final int GL_MAX_TESS_EVALUATION_OUTPUT_COMPONENTS = 36486;
    public static final int GL_MAX_TESS_CONTROL_UNIFORM_BLOCKS = 36489;
    public static final int GL_MAX_TESS_EVALUATION_UNIFORM_BLOCKS = 36490;
    public static final int GL_MAX_TESS_CONTROL_INPUT_COMPONENTS = 34924;
    public static final int GL_MAX_TESS_EVALUATION_INPUT_COMPONENTS = 34925;
    public static final int GL_MAX_COMBINED_TESS_CONTROL_UNIFORM_COMPONENTS = 36382;
    public static final int GL_MAX_COMBINED_TESS_EVALUATION_UNIFORM_COMPONENTS = 36383;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_CONTROL_SHADER = 34032;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_EVALUATION_SHADER = 34033;
    public static final int GL_TESS_EVALUATION_SHADER = 36487;
    public static final int GL_TESS_CONTROL_SHADER = 36488;
    public static final int GL_TEXTURE_CUBE_MAP_ARRAY = 36873;
    public static final int GL_TEXTURE_BINDING_CUBE_MAP_ARRAY = 36874;
    public static final int GL_PROXY_TEXTURE_CUBE_MAP_ARRAY = 36875;
    public static final int GL_SAMPLER_CUBE_MAP_ARRAY = 36876;
    public static final int GL_SAMPLER_CUBE_MAP_ARRAY_SHADOW = 36877;
    public static final int GL_INT_SAMPLER_CUBE_MAP_ARRAY = 36878;
    public static final int GL_UNSIGNED_INT_SAMPLER_CUBE_MAP_ARRAY = 36879;
    public static final int GL_MIN_PROGRAM_TEXTURE_GATHER_OFFSET = 36446;
    public static final int GL_MAX_PROGRAM_TEXTURE_GATHER_OFFSET = 36447;
    public static final int GL_TRANSFORM_FEEDBACK = 36386;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED = 36387;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE = 36388;
    public static final int GL_TRANSFORM_FEEDBACK_BINDING = 36389;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_BUFFERS = 36464;
    public static final int GL_MAX_VERTEX_STREAMS = 36465;

    protected GL40C() {
        throw new UnsupportedOperationException();
    }

    public static native void glBlendEquationi(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void glBlendEquationSeparatei(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2);

    public static native void glBlendFunci(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2);

    public static native void glBlendFuncSeparatei(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLenum") int var4);

    public static native void nglDrawArraysIndirect(int var0, long var1);

    public static void glDrawArraysIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ByteBuffer indirect) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)indirect, 16);
        }
        GL40C.nglDrawArraysIndirect(mode, MemoryUtil.memAddress(indirect));
    }

    public static void glDrawArraysIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") long indirect) {
        GL40C.nglDrawArraysIndirect(mode, indirect);
    }

    public static void glDrawArraysIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") IntBuffer indirect) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)indirect, 4);
        }
        GL40C.nglDrawArraysIndirect(mode, MemoryUtil.memAddress(indirect));
    }

    public static native void nglDrawElementsIndirect(int var0, int var1, long var2);

    public static void glDrawElementsIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer indirect) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)indirect, 20);
        }
        GL40C.nglDrawElementsIndirect(mode, type, MemoryUtil.memAddress(indirect));
    }

    public static void glDrawElementsIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long indirect) {
        GL40C.nglDrawElementsIndirect(mode, type, indirect);
    }

    public static void glDrawElementsIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer indirect) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)indirect, 5);
        }
        GL40C.nglDrawElementsIndirect(mode, type, MemoryUtil.memAddress(indirect));
    }

    public static native void glUniform1d(@NativeType(value="GLint") int var0, @NativeType(value="GLdouble") double var1);

    public static native void glUniform2d(@NativeType(value="GLint") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3);

    public static native void glUniform3d(@NativeType(value="GLint") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5);

    public static native void glUniform4d(@NativeType(value="GLint") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5, @NativeType(value="GLdouble") double var7);

    public static native void nglUniform1dv(int var0, int var1, long var2);

    public static void glUniform1dv(@NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.nglUniform1dv(location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void nglUniform2dv(int var0, int var1, long var2);

    public static void glUniform2dv(@NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.nglUniform2dv(location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void nglUniform3dv(int var0, int var1, long var2);

    public static void glUniform3dv(@NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.nglUniform3dv(location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void nglUniform4dv(int var0, int var1, long var2);

    public static void glUniform4dv(@NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.nglUniform4dv(location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static native void nglUniformMatrix2dv(int var0, int var1, boolean var2, long var3);

    public static void glUniformMatrix2dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.nglUniformMatrix2dv(location, value.remaining() >> 2, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglUniformMatrix3dv(int var0, int var1, boolean var2, long var3);

    public static void glUniformMatrix3dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.nglUniformMatrix3dv(location, value.remaining() / 9, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglUniformMatrix4dv(int var0, int var1, boolean var2, long var3);

    public static void glUniformMatrix4dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.nglUniformMatrix4dv(location, value.remaining() >> 4, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglUniformMatrix2x3dv(int var0, int var1, boolean var2, long var3);

    public static void glUniformMatrix2x3dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.nglUniformMatrix2x3dv(location, value.remaining() / 6, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglUniformMatrix2x4dv(int var0, int var1, boolean var2, long var3);

    public static void glUniformMatrix2x4dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.nglUniformMatrix2x4dv(location, value.remaining() >> 3, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglUniformMatrix3x2dv(int var0, int var1, boolean var2, long var3);

    public static void glUniformMatrix3x2dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.nglUniformMatrix3x2dv(location, value.remaining() / 6, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglUniformMatrix3x4dv(int var0, int var1, boolean var2, long var3);

    public static void glUniformMatrix3x4dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.nglUniformMatrix3x4dv(location, value.remaining() / 12, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglUniformMatrix4x2dv(int var0, int var1, boolean var2, long var3);

    public static void glUniformMatrix4x2dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.nglUniformMatrix4x2dv(location, value.remaining() >> 3, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglUniformMatrix4x3dv(int var0, int var1, boolean var2, long var3);

    public static void glUniformMatrix4x3dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL40C.nglUniformMatrix4x3dv(location, value.remaining() / 12, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglGetUniformdv(int var0, int var1, long var2);

    public static void glGetUniformdv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble *") DoubleBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL40C.nglGetUniformdv(program, location, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static double glGetUniformd(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            DoubleBuffer params = stack.callocDouble(1);
            GL40C.nglGetUniformdv(program, location, MemoryUtil.memAddress(params));
            double d = params.get(0);
            return d;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glMinSampleShading(@NativeType(value="GLfloat") float var0);

    public static native int nglGetSubroutineUniformLocation(int var0, int var1, long var2);

    @NativeType(value="GLint")
    public static int glGetSubroutineUniformLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLchar const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return GL40C.nglGetSubroutineUniformLocation(program, shadertype, MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLint")
    public static int glGetSubroutineUniformLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLchar const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(name, true);
            long nameEncoded = stack.getPointerAddress();
            int n = GL40C.nglGetSubroutineUniformLocation(program, shadertype, nameEncoded);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native int nglGetSubroutineIndex(int var0, int var1, long var2);

    @NativeType(value="GLuint")
    public static int glGetSubroutineIndex(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLchar const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return GL40C.nglGetSubroutineIndex(program, shadertype, MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLuint")
    public static int glGetSubroutineIndex(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLchar const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(name, true);
            long nameEncoded = stack.getPointerAddress();
            int n = GL40C.nglGetSubroutineIndex(program, shadertype, nameEncoded);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetActiveSubroutineUniformiv(int var0, int var1, int var2, int var3, long var4);

    public static void glGetActiveSubroutineUniformiv(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer values) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)values, 1);
        }
        GL40C.nglGetActiveSubroutineUniformiv(program, shadertype, index, pname, MemoryUtil.memAddress(values));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetActiveSubroutineUniformi(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer values = stack.callocInt(1);
            GL40C.nglGetActiveSubroutineUniformiv(program, shadertype, index, pname, MemoryUtil.memAddress(values));
            int n = values.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetActiveSubroutineUniformName(int var0, int var1, int var2, int var3, long var4, long var6);

    public static void glGetActiveSubroutineUniformName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, 1);
        }
        GL40C.nglGetActiveSubroutineUniformName(program, shadertype, index, name.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetActiveSubroutineUniformName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint") int index, @NativeType(value="GLsizei") int bufsize) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer length = stack.ints(0);
            ByteBuffer name = stack.malloc(bufsize);
            GL40C.nglGetActiveSubroutineUniformName(program, shadertype, index, bufsize, MemoryUtil.memAddress(length), MemoryUtil.memAddress(name));
            String string = MemoryUtil.memASCII(name, length.get(0));
            return string;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="void")
    public static String glGetActiveSubroutineUniformName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint") int index) {
        return GL40C.glGetActiveSubroutineUniformName(program, shadertype, index, GL40C.glGetActiveSubroutineUniformi(program, shadertype, index, 35385));
    }

    public static native void nglGetActiveSubroutineName(int var0, int var1, int var2, int var3, long var4, long var6);

    public static void glGetActiveSubroutineName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, 1);
        }
        GL40C.nglGetActiveSubroutineName(program, shadertype, index, name.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetActiveSubroutineName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint") int index, @NativeType(value="GLsizei") int bufsize) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer length = stack.ints(0);
            ByteBuffer name = stack.malloc(bufsize);
            GL40C.nglGetActiveSubroutineName(program, shadertype, index, bufsize, MemoryUtil.memAddress(length), MemoryUtil.memAddress(name));
            String string = MemoryUtil.memASCII(name, length.get(0));
            return string;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="void")
    public static String glGetActiveSubroutineName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint") int index) {
        return GL40C.glGetActiveSubroutineName(program, shadertype, index, GL40C.glGetProgramStagei(program, shadertype, 36424));
    }

    public static native void nglUniformSubroutinesuiv(int var0, int var1, long var2);

    public static void glUniformSubroutinesuiv(@NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint const *") IntBuffer indices) {
        GL40C.nglUniformSubroutinesuiv(shadertype, indices.remaining(), MemoryUtil.memAddress(indices));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glUniformSubroutinesui(@NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint const *") int index) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer indices = stack.ints(index);
            GL40C.nglUniformSubroutinesuiv(shadertype, 1, MemoryUtil.memAddress(indices));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetUniformSubroutineuiv(int var0, int var1, long var2);

    public static void glGetUniformSubroutineuiv(@NativeType(value="GLenum") int shadertype, @NativeType(value="GLint") int location, @NativeType(value="GLuint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL40C.nglGetUniformSubroutineuiv(shadertype, location, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetUniformSubroutineui(@NativeType(value="GLenum") int shadertype, @NativeType(value="GLint") int location) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL40C.nglGetUniformSubroutineuiv(shadertype, location, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetProgramStageiv(int var0, int var1, int var2, long var3);

    public static void glGetProgramStageiv(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer values) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)values, 1);
        }
        GL40C.nglGetProgramStageiv(program, shadertype, pname, MemoryUtil.memAddress(values));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetProgramStagei(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer values = stack.callocInt(1);
            GL40C.nglGetProgramStageiv(program, shadertype, pname, MemoryUtil.memAddress(values));
            int n = values.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glPatchParameteri(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1);

    public static native void nglPatchParameterfv(int var0, long var1);

    public static void glPatchParameterfv(@NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer values) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)values, GL11.glGetInteger(36466));
        }
        GL40C.nglPatchParameterfv(pname, MemoryUtil.memAddress(values));
    }

    public static native void glBindTransformFeedback(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglDeleteTransformFeedbacks(int var0, long var1);

    public static void glDeleteTransformFeedbacks(@NativeType(value="GLuint const *") IntBuffer ids) {
        GL40C.nglDeleteTransformFeedbacks(ids.remaining(), MemoryUtil.memAddress(ids));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDeleteTransformFeedbacks(@NativeType(value="GLuint const *") int id) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer ids = stack.ints(id);
            GL40C.nglDeleteTransformFeedbacks(1, MemoryUtil.memAddress(ids));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGenTransformFeedbacks(int var0, long var1);

    public static void glGenTransformFeedbacks(@NativeType(value="GLuint *") IntBuffer ids) {
        GL40C.nglGenTransformFeedbacks(ids.remaining(), MemoryUtil.memAddress(ids));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGenTransformFeedbacks() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer ids = stack.callocInt(1);
            GL40C.nglGenTransformFeedbacks(1, MemoryUtil.memAddress(ids));
            int n = ids.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="GLboolean")
    public static native boolean glIsTransformFeedback(@NativeType(value="GLuint") int var0);

    public static native void glPauseTransformFeedback();

    public static native void glResumeTransformFeedback();

    public static native void glDrawTransformFeedback(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glDrawTransformFeedbackStream(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    public static native void glBeginQueryIndexed(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    public static native void glEndQueryIndexed(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglGetQueryIndexediv(int var0, int var1, int var2, long var3);

    public static void glGetQueryIndexediv(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL40C.nglGetQueryIndexediv(target, index, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetQueryIndexedi(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL40C.nglGetQueryIndexediv(target, index, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glDrawArraysIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") int[] indirect) {
        long __functionAddress = GL.getICD().glDrawArraysIndirect;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(indirect, 4);
        }
        JNI.callPV(mode, indirect, __functionAddress);
    }

    public static void glDrawElementsIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] indirect) {
        long __functionAddress = GL.getICD().glDrawElementsIndirect;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(indirect, 5);
        }
        JNI.callPV(mode, type, indirect, __functionAddress);
    }

    public static void glUniform1dv(@NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glUniform1dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length, value, __functionAddress);
    }

    public static void glUniform2dv(@NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glUniform2dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 1, value, __functionAddress);
    }

    public static void glUniform3dv(@NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glUniform3dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length / 3, value, __functionAddress);
    }

    public static void glUniform4dv(@NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glUniform4dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 2, value, __functionAddress);
    }

    public static void glUniformMatrix2dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glUniformMatrix2dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 2, transpose, value, __functionAddress);
    }

    public static void glUniformMatrix3dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glUniformMatrix3dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length / 9, transpose, value, __functionAddress);
    }

    public static void glUniformMatrix4dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glUniformMatrix4dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 4, transpose, value, __functionAddress);
    }

    public static void glUniformMatrix2x3dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glUniformMatrix2x3dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length / 6, transpose, value, __functionAddress);
    }

    public static void glUniformMatrix2x4dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glUniformMatrix2x4dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 3, transpose, value, __functionAddress);
    }

    public static void glUniformMatrix3x2dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glUniformMatrix3x2dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length / 6, transpose, value, __functionAddress);
    }

    public static void glUniformMatrix3x4dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glUniformMatrix3x4dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length / 12, transpose, value, __functionAddress);
    }

    public static void glUniformMatrix4x2dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glUniformMatrix4x2dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 3, transpose, value, __functionAddress);
    }

    public static void glUniformMatrix4x3dv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glUniformMatrix4x3dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length / 12, transpose, value, __functionAddress);
    }

    public static void glGetUniformdv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble *") double[] params) {
        long __functionAddress = GL.getICD().glGetUniformdv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(program, location, params, __functionAddress);
    }

    public static void glGetActiveSubroutineUniformiv(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] values) {
        long __functionAddress = GL.getICD().glGetActiveSubroutineUniformiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(values, 1);
        }
        JNI.callPV(program, shadertype, index, pname, values, __functionAddress);
    }

    public static void glGetActiveSubroutineUniformName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer name) {
        long __functionAddress = GL.getICD().glGetActiveSubroutineUniformName;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, 1);
        }
        JNI.callPPV(program, shadertype, index, name.remaining(), length, MemoryUtil.memAddress(name), __functionAddress);
    }

    public static void glGetActiveSubroutineName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer name) {
        long __functionAddress = GL.getICD().glGetActiveSubroutineName;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, 1);
        }
        JNI.callPPV(program, shadertype, index, name.remaining(), length, MemoryUtil.memAddress(name), __functionAddress);
    }

    public static void glUniformSubroutinesuiv(@NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint const *") int[] indices) {
        long __functionAddress = GL.getICD().glUniformSubroutinesuiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(shadertype, indices.length, indices, __functionAddress);
    }

    public static void glGetUniformSubroutineuiv(@NativeType(value="GLenum") int shadertype, @NativeType(value="GLint") int location, @NativeType(value="GLuint *") int[] params) {
        long __functionAddress = GL.getICD().glGetUniformSubroutineuiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(shadertype, location, params, __functionAddress);
    }

    public static void glGetProgramStageiv(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] values) {
        long __functionAddress = GL.getICD().glGetProgramStageiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(values, 1);
        }
        JNI.callPV(program, shadertype, pname, values, __functionAddress);
    }

    public static void glPatchParameterfv(@NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] values) {
        long __functionAddress = GL.getICD().glPatchParameterfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            if (Checks.DEBUG) {
                Checks.check(values, GL11.glGetInteger(36466));
            }
        }
        JNI.callPV(pname, values, __functionAddress);
    }

    public static void glDeleteTransformFeedbacks(@NativeType(value="GLuint const *") int[] ids) {
        long __functionAddress = GL.getICD().glDeleteTransformFeedbacks;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(ids.length, ids, __functionAddress);
    }

    public static void glGenTransformFeedbacks(@NativeType(value="GLuint *") int[] ids) {
        long __functionAddress = GL.getICD().glGenTransformFeedbacks;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(ids.length, ids, __functionAddress);
    }

    public static void glGetQueryIndexediv(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetQueryIndexediv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, index, pname, params, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

