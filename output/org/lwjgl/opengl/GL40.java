/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL33;
import org.lwjgl.opengl.GL40C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class GL40
extends GL33 {
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

    protected GL40() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glBlendEquationi, caps.glBlendEquationSeparatei, caps.glBlendFunci, caps.glBlendFuncSeparatei, caps.glDrawArraysIndirect, caps.glDrawElementsIndirect, caps.glUniform1d, caps.glUniform2d, caps.glUniform3d, caps.glUniform4d, caps.glUniform1dv, caps.glUniform2dv, caps.glUniform3dv, caps.glUniform4dv, caps.glUniformMatrix2dv, caps.glUniformMatrix3dv, caps.glUniformMatrix4dv, caps.glUniformMatrix2x3dv, caps.glUniformMatrix2x4dv, caps.glUniformMatrix3x2dv, caps.glUniformMatrix3x4dv, caps.glUniformMatrix4x2dv, caps.glUniformMatrix4x3dv, caps.glGetUniformdv, caps.glMinSampleShading, caps.glGetSubroutineUniformLocation, caps.glGetSubroutineIndex, caps.glGetActiveSubroutineUniformiv, caps.glGetActiveSubroutineUniformName, caps.glGetActiveSubroutineName, caps.glUniformSubroutinesuiv, caps.glGetUniformSubroutineuiv, caps.glGetProgramStageiv, caps.glPatchParameteri, caps.glPatchParameterfv, caps.glBindTransformFeedback, caps.glDeleteTransformFeedbacks, caps.glGenTransformFeedbacks, caps.glIsTransformFeedback, caps.glPauseTransformFeedback, caps.glResumeTransformFeedback, caps.glDrawTransformFeedback, caps.glDrawTransformFeedbackStream, caps.glBeginQueryIndexed, caps.glEndQueryIndexed, caps.glGetQueryIndexediv);
    }

    public static void glBlendEquationi(@NativeType(value="GLuint") int buf, @NativeType(value="GLenum") int mode) {
        GL40C.glBlendEquationi(buf, mode);
    }

    public static void glBlendEquationSeparatei(@NativeType(value="GLuint") int buf, @NativeType(value="GLenum") int modeRGB, @NativeType(value="GLenum") int modeAlpha) {
        GL40C.glBlendEquationSeparatei(buf, modeRGB, modeAlpha);
    }

    public static void glBlendFunci(@NativeType(value="GLuint") int buf, @NativeType(value="GLenum") int sfactor, @NativeType(value="GLenum") int dfactor) {
        GL40C.glBlendFunci(buf, sfactor, dfactor);
    }

    public static void glBlendFuncSeparatei(@NativeType(value="GLuint") int buf, @NativeType(value="GLenum") int srcRGB, @NativeType(value="GLenum") int dstRGB, @NativeType(value="GLenum") int srcAlpha, @NativeType(value="GLenum") int dstAlpha) {
        GL40C.glBlendFuncSeparatei(buf, srcRGB, dstRGB, srcAlpha, dstAlpha);
    }

    public static void nglDrawArraysIndirect(int mode, long indirect) {
        GL40C.nglDrawArraysIndirect(mode, indirect);
    }

    public static void glDrawArraysIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ByteBuffer indirect) {
        GL40C.glDrawArraysIndirect(mode, indirect);
    }

    public static void glDrawArraysIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") long indirect) {
        GL40C.glDrawArraysIndirect(mode, indirect);
    }

    public static void glDrawArraysIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") IntBuffer indirect) {
        GL40C.glDrawArraysIndirect(mode, indirect);
    }

    public static void nglDrawElementsIndirect(int mode, int type, long indirect) {
        GL40C.nglDrawElementsIndirect(mode, type, indirect);
    }

    public static void glDrawElementsIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer indirect) {
        GL40C.glDrawElementsIndirect(mode, type, indirect);
    }

    public static void glDrawElementsIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long indirect) {
        GL40C.glDrawElementsIndirect(mode, type, indirect);
    }

    public static void glDrawElementsIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer indirect) {
        GL40C.glDrawElementsIndirect(mode, type, indirect);
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

    public static void glMinSampleShading(@NativeType(value="GLfloat") float value) {
        GL40C.glMinSampleShading(value);
    }

    public static int nglGetSubroutineUniformLocation(int program, int shadertype, long name) {
        return GL40C.nglGetSubroutineUniformLocation(program, shadertype, name);
    }

    @NativeType(value="GLint")
    public static int glGetSubroutineUniformLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLchar const *") ByteBuffer name) {
        return GL40C.glGetSubroutineUniformLocation(program, shadertype, name);
    }

    @NativeType(value="GLint")
    public static int glGetSubroutineUniformLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLchar const *") CharSequence name) {
        return GL40C.glGetSubroutineUniformLocation(program, shadertype, name);
    }

    public static int nglGetSubroutineIndex(int program, int shadertype, long name) {
        return GL40C.nglGetSubroutineIndex(program, shadertype, name);
    }

    @NativeType(value="GLuint")
    public static int glGetSubroutineIndex(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLchar const *") ByteBuffer name) {
        return GL40C.glGetSubroutineIndex(program, shadertype, name);
    }

    @NativeType(value="GLuint")
    public static int glGetSubroutineIndex(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLchar const *") CharSequence name) {
        return GL40C.glGetSubroutineIndex(program, shadertype, name);
    }

    public static void nglGetActiveSubroutineUniformiv(int program, int shadertype, int index, int pname, long values) {
        GL40C.nglGetActiveSubroutineUniformiv(program, shadertype, index, pname, values);
    }

    public static void glGetActiveSubroutineUniformiv(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer values) {
        GL40C.glGetActiveSubroutineUniformiv(program, shadertype, index, pname, values);
    }

    @NativeType(value="void")
    public static int glGetActiveSubroutineUniformi(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        return GL40C.glGetActiveSubroutineUniformi(program, shadertype, index, pname);
    }

    public static void nglGetActiveSubroutineUniformName(int program, int shadertype, int index, int bufsize, long length, long name) {
        GL40C.nglGetActiveSubroutineUniformName(program, shadertype, index, bufsize, length, name);
    }

    public static void glGetActiveSubroutineUniformName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer name) {
        GL40C.glGetActiveSubroutineUniformName(program, shadertype, index, length, name);
    }

    @NativeType(value="void")
    public static String glGetActiveSubroutineUniformName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint") int index, @NativeType(value="GLsizei") int bufsize) {
        return GL40C.glGetActiveSubroutineUniformName(program, shadertype, index, bufsize);
    }

    @NativeType(value="void")
    public static String glGetActiveSubroutineUniformName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint") int index) {
        return GL40.glGetActiveSubroutineUniformName(program, shadertype, index, GL40.glGetActiveSubroutineUniformi(program, shadertype, index, 35385));
    }

    public static void nglGetActiveSubroutineName(int program, int shadertype, int index, int bufsize, long length, long name) {
        GL40C.nglGetActiveSubroutineName(program, shadertype, index, bufsize, length, name);
    }

    public static void glGetActiveSubroutineName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer name) {
        GL40C.glGetActiveSubroutineName(program, shadertype, index, length, name);
    }

    @NativeType(value="void")
    public static String glGetActiveSubroutineName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint") int index, @NativeType(value="GLsizei") int bufsize) {
        return GL40C.glGetActiveSubroutineName(program, shadertype, index, bufsize);
    }

    @NativeType(value="void")
    public static String glGetActiveSubroutineName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint") int index) {
        return GL40.glGetActiveSubroutineName(program, shadertype, index, GL40.glGetProgramStagei(program, shadertype, 36424));
    }

    public static void nglUniformSubroutinesuiv(int shadertype, int count, long indices) {
        GL40C.nglUniformSubroutinesuiv(shadertype, count, indices);
    }

    public static void glUniformSubroutinesuiv(@NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint const *") IntBuffer indices) {
        GL40C.glUniformSubroutinesuiv(shadertype, indices);
    }

    public static void glUniformSubroutinesui(@NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint const *") int index) {
        GL40C.glUniformSubroutinesui(shadertype, index);
    }

    public static void nglGetUniformSubroutineuiv(int shadertype, int location, long params) {
        GL40C.nglGetUniformSubroutineuiv(shadertype, location, params);
    }

    public static void glGetUniformSubroutineuiv(@NativeType(value="GLenum") int shadertype, @NativeType(value="GLint") int location, @NativeType(value="GLuint *") IntBuffer params) {
        GL40C.glGetUniformSubroutineuiv(shadertype, location, params);
    }

    @NativeType(value="void")
    public static int glGetUniformSubroutineui(@NativeType(value="GLenum") int shadertype, @NativeType(value="GLint") int location) {
        return GL40C.glGetUniformSubroutineui(shadertype, location);
    }

    public static void nglGetProgramStageiv(int program, int shadertype, int pname, long values) {
        GL40C.nglGetProgramStageiv(program, shadertype, pname, values);
    }

    public static void glGetProgramStageiv(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer values) {
        GL40C.glGetProgramStageiv(program, shadertype, pname, values);
    }

    @NativeType(value="void")
    public static int glGetProgramStagei(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLenum") int pname) {
        return GL40C.glGetProgramStagei(program, shadertype, pname);
    }

    public static void glPatchParameteri(@NativeType(value="GLenum") int pname, @NativeType(value="GLint") int value) {
        GL40C.glPatchParameteri(pname, value);
    }

    public static void nglPatchParameterfv(int pname, long values) {
        GL40C.nglPatchParameterfv(pname, values);
    }

    public static void glPatchParameterfv(@NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer values) {
        GL40C.glPatchParameterfv(pname, values);
    }

    public static void glBindTransformFeedback(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int id) {
        GL40C.glBindTransformFeedback(target, id);
    }

    public static void nglDeleteTransformFeedbacks(int n, long ids) {
        GL40C.nglDeleteTransformFeedbacks(n, ids);
    }

    public static void glDeleteTransformFeedbacks(@NativeType(value="GLuint const *") IntBuffer ids) {
        GL40C.glDeleteTransformFeedbacks(ids);
    }

    public static void glDeleteTransformFeedbacks(@NativeType(value="GLuint const *") int id) {
        GL40C.glDeleteTransformFeedbacks(id);
    }

    public static void nglGenTransformFeedbacks(int n, long ids) {
        GL40C.nglGenTransformFeedbacks(n, ids);
    }

    public static void glGenTransformFeedbacks(@NativeType(value="GLuint *") IntBuffer ids) {
        GL40C.glGenTransformFeedbacks(ids);
    }

    @NativeType(value="void")
    public static int glGenTransformFeedbacks() {
        return GL40C.glGenTransformFeedbacks();
    }

    @NativeType(value="GLboolean")
    public static boolean glIsTransformFeedback(@NativeType(value="GLuint") int id) {
        return GL40C.glIsTransformFeedback(id);
    }

    public static void glPauseTransformFeedback() {
        GL40C.glPauseTransformFeedback();
    }

    public static void glResumeTransformFeedback() {
        GL40C.glResumeTransformFeedback();
    }

    public static void glDrawTransformFeedback(@NativeType(value="GLenum") int mode, @NativeType(value="GLuint") int id) {
        GL40C.glDrawTransformFeedback(mode, id);
    }

    public static void glDrawTransformFeedbackStream(@NativeType(value="GLenum") int mode, @NativeType(value="GLuint") int id, @NativeType(value="GLuint") int stream) {
        GL40C.glDrawTransformFeedbackStream(mode, id, stream);
    }

    public static void glBeginQueryIndexed(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLuint") int id) {
        GL40C.glBeginQueryIndexed(target, index, id);
    }

    public static void glEndQueryIndexed(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        GL40C.glEndQueryIndexed(target, index);
    }

    public static void nglGetQueryIndexediv(int target, int index, int pname, long params) {
        GL40C.nglGetQueryIndexediv(target, index, pname, params);
    }

    public static void glGetQueryIndexediv(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL40C.glGetQueryIndexediv(target, index, pname, params);
    }

    @NativeType(value="void")
    public static int glGetQueryIndexedi(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        return GL40C.glGetQueryIndexedi(target, index, pname);
    }

    public static void glDrawArraysIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") int[] indirect) {
        GL40C.glDrawArraysIndirect(mode, indirect);
    }

    public static void glDrawElementsIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] indirect) {
        GL40C.glDrawElementsIndirect(mode, type, indirect);
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

    public static void glGetActiveSubroutineUniformiv(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] values) {
        GL40C.glGetActiveSubroutineUniformiv(program, shadertype, index, pname, values);
    }

    public static void glGetActiveSubroutineUniformName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer name) {
        GL40C.glGetActiveSubroutineUniformName(program, shadertype, index, length, name);
    }

    public static void glGetActiveSubroutineName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer name) {
        GL40C.glGetActiveSubroutineName(program, shadertype, index, length, name);
    }

    public static void glUniformSubroutinesuiv(@NativeType(value="GLenum") int shadertype, @NativeType(value="GLuint const *") int[] indices) {
        GL40C.glUniformSubroutinesuiv(shadertype, indices);
    }

    public static void glGetUniformSubroutineuiv(@NativeType(value="GLenum") int shadertype, @NativeType(value="GLint") int location, @NativeType(value="GLuint *") int[] params) {
        GL40C.glGetUniformSubroutineuiv(shadertype, location, params);
    }

    public static void glGetProgramStageiv(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int shadertype, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] values) {
        GL40C.glGetProgramStageiv(program, shadertype, pname, values);
    }

    public static void glPatchParameterfv(@NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] values) {
        GL40C.glPatchParameterfv(pname, values);
    }

    public static void glDeleteTransformFeedbacks(@NativeType(value="GLuint const *") int[] ids) {
        GL40C.glDeleteTransformFeedbacks(ids);
    }

    public static void glGenTransformFeedbacks(@NativeType(value="GLuint *") int[] ids) {
        GL40C.glGenTransformFeedbacks(ids);
    }

    public static void glGetQueryIndexediv(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL40C.glGetQueryIndexediv(target, index, pname, params);
    }

    static {
        GL.initialize();
    }
}

