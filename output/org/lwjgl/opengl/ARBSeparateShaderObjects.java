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
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL41C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBSeparateShaderObjects {
    public static final int GL_VERTEX_SHADER_BIT = 1;
    public static final int GL_FRAGMENT_SHADER_BIT = 2;
    public static final int GL_GEOMETRY_SHADER_BIT = 4;
    public static final int GL_TESS_CONTROL_SHADER_BIT = 8;
    public static final int GL_TESS_EVALUATION_SHADER_BIT = 16;
    public static final int GL_ALL_SHADER_BITS = -1;
    public static final int GL_PROGRAM_SEPARABLE = 33368;
    public static final int GL_ACTIVE_PROGRAM = 33369;
    public static final int GL_PROGRAM_PIPELINE_BINDING = 33370;

    protected ARBSeparateShaderObjects() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glUseProgramStages, caps.glActiveShaderProgram, caps.glCreateShaderProgramv, caps.glBindProgramPipeline, caps.glDeleteProgramPipelines, caps.glGenProgramPipelines, caps.glIsProgramPipeline, caps.glProgramParameteri, caps.glGetProgramPipelineiv, caps.glProgramUniform1i, caps.glProgramUniform2i, caps.glProgramUniform3i, caps.glProgramUniform4i, caps.glProgramUniform1ui, caps.glProgramUniform2ui, caps.glProgramUniform3ui, caps.glProgramUniform4ui, caps.glProgramUniform1f, caps.glProgramUniform2f, caps.glProgramUniform3f, caps.glProgramUniform4f, caps.glProgramUniform1d, caps.glProgramUniform2d, caps.glProgramUniform3d, caps.glProgramUniform4d, caps.glProgramUniform1iv, caps.glProgramUniform2iv, caps.glProgramUniform3iv, caps.glProgramUniform4iv, caps.glProgramUniform1uiv, caps.glProgramUniform2uiv, caps.glProgramUniform3uiv, caps.glProgramUniform4uiv, caps.glProgramUniform1fv, caps.glProgramUniform2fv, caps.glProgramUniform3fv, caps.glProgramUniform4fv, caps.glProgramUniform1dv, caps.glProgramUniform2dv, caps.glProgramUniform3dv, caps.glProgramUniform4dv, caps.glProgramUniformMatrix2fv, caps.glProgramUniformMatrix3fv, caps.glProgramUniformMatrix4fv, caps.glProgramUniformMatrix2dv, caps.glProgramUniformMatrix3dv, caps.glProgramUniformMatrix4dv, caps.glProgramUniformMatrix2x3fv, caps.glProgramUniformMatrix3x2fv, caps.glProgramUniformMatrix2x4fv, caps.glProgramUniformMatrix4x2fv, caps.glProgramUniformMatrix3x4fv, caps.glProgramUniformMatrix4x3fv, caps.glProgramUniformMatrix2x3dv, caps.glProgramUniformMatrix3x2dv, caps.glProgramUniformMatrix2x4dv, caps.glProgramUniformMatrix4x2dv, caps.glProgramUniformMatrix3x4dv, caps.glProgramUniformMatrix4x3dv, caps.glValidateProgramPipeline, caps.glGetProgramPipelineInfoLog);
    }

    public static void glUseProgramStages(@NativeType(value="GLuint") int pipeline, @NativeType(value="GLbitfield") int stages, @NativeType(value="GLuint") int program) {
        GL41C.glUseProgramStages(pipeline, stages, program);
    }

    public static void glActiveShaderProgram(@NativeType(value="GLuint") int pipeline, @NativeType(value="GLuint") int program) {
        GL41C.glActiveShaderProgram(pipeline, program);
    }

    public static int nglCreateShaderProgramv(int type, int count, long strings) {
        return GL41C.nglCreateShaderProgramv(type, count, strings);
    }

    @NativeType(value="GLuint")
    public static int glCreateShaderProgramv(@NativeType(value="GLenum") int type, @NativeType(value="GLchar const **") PointerBuffer strings) {
        return GL41C.glCreateShaderProgramv(type, strings);
    }

    @NativeType(value="GLuint")
    public static int glCreateShaderProgramv(@NativeType(value="GLenum") int type, CharSequence ... strings) {
        return GL41C.glCreateShaderProgramv(type, strings);
    }

    @NativeType(value="GLuint")
    public static int glCreateShaderProgramv(@NativeType(value="GLenum") int type, @NativeType(value="GLchar const **") CharSequence string) {
        return GL41C.glCreateShaderProgramv(type, string);
    }

    public static void glBindProgramPipeline(@NativeType(value="GLuint") int pipeline) {
        GL41C.glBindProgramPipeline(pipeline);
    }

    public static void nglDeleteProgramPipelines(int n, long pipelines) {
        GL41C.nglDeleteProgramPipelines(n, pipelines);
    }

    public static void glDeleteProgramPipelines(@NativeType(value="GLuint const *") IntBuffer pipelines) {
        GL41C.glDeleteProgramPipelines(pipelines);
    }

    public static void glDeleteProgramPipelines(@NativeType(value="GLuint const *") int pipeline) {
        GL41C.glDeleteProgramPipelines(pipeline);
    }

    public static void nglGenProgramPipelines(int n, long pipelines) {
        GL41C.nglGenProgramPipelines(n, pipelines);
    }

    public static void glGenProgramPipelines(@NativeType(value="GLuint *") IntBuffer pipelines) {
        GL41C.glGenProgramPipelines(pipelines);
    }

    @NativeType(value="void")
    public static int glGenProgramPipelines() {
        return GL41C.glGenProgramPipelines();
    }

    @NativeType(value="GLboolean")
    public static boolean glIsProgramPipeline(@NativeType(value="GLuint") int pipeline) {
        return GL41C.glIsProgramPipeline(pipeline);
    }

    public static void glProgramParameteri(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int pname, @NativeType(value="GLint") int value) {
        GL41C.glProgramParameteri(program, pname, value);
    }

    public static void nglGetProgramPipelineiv(int pipeline, int pname, long params) {
        GL41C.nglGetProgramPipelineiv(pipeline, pname, params);
    }

    public static void glGetProgramPipelineiv(@NativeType(value="GLuint") int pipeline, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL41C.glGetProgramPipelineiv(pipeline, pname, params);
    }

    @NativeType(value="void")
    public static int glGetProgramPipelinei(@NativeType(value="GLuint") int pipeline, @NativeType(value="GLenum") int pname) {
        return GL41C.glGetProgramPipelinei(pipeline, pname);
    }

    public static void glProgramUniform1i(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint") int x) {
        GL41C.glProgramUniform1i(program, location, x);
    }

    public static void glProgramUniform2i(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y) {
        GL41C.glProgramUniform2i(program, location, x, y);
    }

    public static void glProgramUniform3i(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLint") int z) {
        GL41C.glProgramUniform3i(program, location, x, y, z);
    }

    public static void glProgramUniform4i(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLint") int z, @NativeType(value="GLint") int w) {
        GL41C.glProgramUniform4i(program, location, x, y, z, w);
    }

    public static void glProgramUniform1ui(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint") int x) {
        GL41C.glProgramUniform1ui(program, location, x);
    }

    public static void glProgramUniform2ui(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint") int x, @NativeType(value="GLuint") int y) {
        GL41C.glProgramUniform2ui(program, location, x, y);
    }

    public static void glProgramUniform3ui(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint") int x, @NativeType(value="GLuint") int y, @NativeType(value="GLuint") int z) {
        GL41C.glProgramUniform3ui(program, location, x, y, z);
    }

    public static void glProgramUniform4ui(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint") int x, @NativeType(value="GLuint") int y, @NativeType(value="GLuint") int z, @NativeType(value="GLuint") int w) {
        GL41C.glProgramUniform4ui(program, location, x, y, z, w);
    }

    public static void glProgramUniform1f(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat") float x) {
        GL41C.glProgramUniform1f(program, location, x);
    }

    public static void glProgramUniform2f(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat") float x, @NativeType(value="GLfloat") float y) {
        GL41C.glProgramUniform2f(program, location, x, y);
    }

    public static void glProgramUniform3f(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat") float x, @NativeType(value="GLfloat") float y, @NativeType(value="GLfloat") float z) {
        GL41C.glProgramUniform3f(program, location, x, y, z);
    }

    public static void glProgramUniform4f(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat") float x, @NativeType(value="GLfloat") float y, @NativeType(value="GLfloat") float z, @NativeType(value="GLfloat") float w) {
        GL41C.glProgramUniform4f(program, location, x, y, z, w);
    }

    public static void glProgramUniform1d(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble") double x) {
        GL41C.glProgramUniform1d(program, location, x);
    }

    public static void glProgramUniform2d(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble") double x, @NativeType(value="GLdouble") double y) {
        GL41C.glProgramUniform2d(program, location, x, y);
    }

    public static void glProgramUniform3d(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble") double x, @NativeType(value="GLdouble") double y, @NativeType(value="GLdouble") double z) {
        GL41C.glProgramUniform3d(program, location, x, y, z);
    }

    public static void glProgramUniform4d(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble") double x, @NativeType(value="GLdouble") double y, @NativeType(value="GLdouble") double z, @NativeType(value="GLdouble") double w) {
        GL41C.glProgramUniform4d(program, location, x, y, z, w);
    }

    public static void nglProgramUniform1iv(int program, int location, int count, long value) {
        GL41C.nglProgramUniform1iv(program, location, count, value);
    }

    public static void glProgramUniform1iv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        GL41C.glProgramUniform1iv(program, location, value);
    }

    public static void nglProgramUniform2iv(int program, int location, int count, long value) {
        GL41C.nglProgramUniform2iv(program, location, count, value);
    }

    public static void glProgramUniform2iv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        GL41C.glProgramUniform2iv(program, location, value);
    }

    public static void nglProgramUniform3iv(int program, int location, int count, long value) {
        GL41C.nglProgramUniform3iv(program, location, count, value);
    }

    public static void glProgramUniform3iv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        GL41C.glProgramUniform3iv(program, location, value);
    }

    public static void nglProgramUniform4iv(int program, int location, int count, long value) {
        GL41C.nglProgramUniform4iv(program, location, count, value);
    }

    public static void glProgramUniform4iv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        GL41C.glProgramUniform4iv(program, location, value);
    }

    public static void nglProgramUniform1uiv(int program, int location, int count, long value) {
        GL41C.nglProgramUniform1uiv(program, location, count, value);
    }

    public static void glProgramUniform1uiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        GL41C.glProgramUniform1uiv(program, location, value);
    }

    public static void nglProgramUniform2uiv(int program, int location, int count, long value) {
        GL41C.nglProgramUniform2uiv(program, location, count, value);
    }

    public static void glProgramUniform2uiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        GL41C.glProgramUniform2uiv(program, location, value);
    }

    public static void nglProgramUniform3uiv(int program, int location, int count, long value) {
        GL41C.nglProgramUniform3uiv(program, location, count, value);
    }

    public static void glProgramUniform3uiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        GL41C.glProgramUniform3uiv(program, location, value);
    }

    public static void nglProgramUniform4uiv(int program, int location, int count, long value) {
        GL41C.nglProgramUniform4uiv(program, location, count, value);
    }

    public static void glProgramUniform4uiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        GL41C.glProgramUniform4uiv(program, location, value);
    }

    public static void nglProgramUniform1fv(int program, int location, int count, long value) {
        GL41C.nglProgramUniform1fv(program, location, count, value);
    }

    public static void glProgramUniform1fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.glProgramUniform1fv(program, location, value);
    }

    public static void nglProgramUniform2fv(int program, int location, int count, long value) {
        GL41C.nglProgramUniform2fv(program, location, count, value);
    }

    public static void glProgramUniform2fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.glProgramUniform2fv(program, location, value);
    }

    public static void nglProgramUniform3fv(int program, int location, int count, long value) {
        GL41C.nglProgramUniform3fv(program, location, count, value);
    }

    public static void glProgramUniform3fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.glProgramUniform3fv(program, location, value);
    }

    public static void nglProgramUniform4fv(int program, int location, int count, long value) {
        GL41C.nglProgramUniform4fv(program, location, count, value);
    }

    public static void glProgramUniform4fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.glProgramUniform4fv(program, location, value);
    }

    public static void nglProgramUniform1dv(int program, int location, int count, long value) {
        GL41C.nglProgramUniform1dv(program, location, count, value);
    }

    public static void glProgramUniform1dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.glProgramUniform1dv(program, location, value);
    }

    public static void nglProgramUniform2dv(int program, int location, int count, long value) {
        GL41C.nglProgramUniform2dv(program, location, count, value);
    }

    public static void glProgramUniform2dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.glProgramUniform2dv(program, location, value);
    }

    public static void nglProgramUniform3dv(int program, int location, int count, long value) {
        GL41C.nglProgramUniform3dv(program, location, count, value);
    }

    public static void glProgramUniform3dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.glProgramUniform3dv(program, location, value);
    }

    public static void nglProgramUniform4dv(int program, int location, int count, long value) {
        GL41C.nglProgramUniform4dv(program, location, count, value);
    }

    public static void glProgramUniform4dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.glProgramUniform4dv(program, location, value);
    }

    public static void nglProgramUniformMatrix2fv(int program, int location, int count, boolean transpose, long value) {
        GL41C.nglProgramUniformMatrix2fv(program, location, count, transpose, value);
    }

    public static void glProgramUniformMatrix2fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.glProgramUniformMatrix2fv(program, location, transpose, value);
    }

    public static void nglProgramUniformMatrix3fv(int program, int location, int count, boolean transpose, long value) {
        GL41C.nglProgramUniformMatrix3fv(program, location, count, transpose, value);
    }

    public static void glProgramUniformMatrix3fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.glProgramUniformMatrix3fv(program, location, transpose, value);
    }

    public static void nglProgramUniformMatrix4fv(int program, int location, int count, boolean transpose, long value) {
        GL41C.nglProgramUniformMatrix4fv(program, location, count, transpose, value);
    }

    public static void glProgramUniformMatrix4fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.glProgramUniformMatrix4fv(program, location, transpose, value);
    }

    public static void nglProgramUniformMatrix2dv(int program, int location, int count, boolean transpose, long value) {
        GL41C.nglProgramUniformMatrix2dv(program, location, count, transpose, value);
    }

    public static void glProgramUniformMatrix2dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.glProgramUniformMatrix2dv(program, location, transpose, value);
    }

    public static void nglProgramUniformMatrix3dv(int program, int location, int count, boolean transpose, long value) {
        GL41C.nglProgramUniformMatrix3dv(program, location, count, transpose, value);
    }

    public static void glProgramUniformMatrix3dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.glProgramUniformMatrix3dv(program, location, transpose, value);
    }

    public static void nglProgramUniformMatrix4dv(int program, int location, int count, boolean transpose, long value) {
        GL41C.nglProgramUniformMatrix4dv(program, location, count, transpose, value);
    }

    public static void glProgramUniformMatrix4dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.glProgramUniformMatrix4dv(program, location, transpose, value);
    }

    public static void nglProgramUniformMatrix2x3fv(int program, int location, int count, boolean transpose, long value) {
        GL41C.nglProgramUniformMatrix2x3fv(program, location, count, transpose, value);
    }

    public static void glProgramUniformMatrix2x3fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.glProgramUniformMatrix2x3fv(program, location, transpose, value);
    }

    public static void nglProgramUniformMatrix3x2fv(int program, int location, int count, boolean transpose, long value) {
        GL41C.nglProgramUniformMatrix3x2fv(program, location, count, transpose, value);
    }

    public static void glProgramUniformMatrix3x2fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.glProgramUniformMatrix3x2fv(program, location, transpose, value);
    }

    public static void nglProgramUniformMatrix2x4fv(int program, int location, int count, boolean transpose, long value) {
        GL41C.nglProgramUniformMatrix2x4fv(program, location, count, transpose, value);
    }

    public static void glProgramUniformMatrix2x4fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.glProgramUniformMatrix2x4fv(program, location, transpose, value);
    }

    public static void nglProgramUniformMatrix4x2fv(int program, int location, int count, boolean transpose, long value) {
        GL41C.nglProgramUniformMatrix4x2fv(program, location, count, transpose, value);
    }

    public static void glProgramUniformMatrix4x2fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.glProgramUniformMatrix4x2fv(program, location, transpose, value);
    }

    public static void nglProgramUniformMatrix3x4fv(int program, int location, int count, boolean transpose, long value) {
        GL41C.nglProgramUniformMatrix3x4fv(program, location, count, transpose, value);
    }

    public static void glProgramUniformMatrix3x4fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.glProgramUniformMatrix3x4fv(program, location, transpose, value);
    }

    public static void nglProgramUniformMatrix4x3fv(int program, int location, int count, boolean transpose, long value) {
        GL41C.nglProgramUniformMatrix4x3fv(program, location, count, transpose, value);
    }

    public static void glProgramUniformMatrix4x3fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.glProgramUniformMatrix4x3fv(program, location, transpose, value);
    }

    public static void nglProgramUniformMatrix2x3dv(int program, int location, int count, boolean transpose, long value) {
        GL41C.nglProgramUniformMatrix2x3dv(program, location, count, transpose, value);
    }

    public static void glProgramUniformMatrix2x3dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.glProgramUniformMatrix2x3dv(program, location, transpose, value);
    }

    public static void nglProgramUniformMatrix3x2dv(int program, int location, int count, boolean transpose, long value) {
        GL41C.nglProgramUniformMatrix3x2dv(program, location, count, transpose, value);
    }

    public static void glProgramUniformMatrix3x2dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.glProgramUniformMatrix3x2dv(program, location, transpose, value);
    }

    public static void nglProgramUniformMatrix2x4dv(int program, int location, int count, boolean transpose, long value) {
        GL41C.nglProgramUniformMatrix2x4dv(program, location, count, transpose, value);
    }

    public static void glProgramUniformMatrix2x4dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.glProgramUniformMatrix2x4dv(program, location, transpose, value);
    }

    public static void nglProgramUniformMatrix4x2dv(int program, int location, int count, boolean transpose, long value) {
        GL41C.nglProgramUniformMatrix4x2dv(program, location, count, transpose, value);
    }

    public static void glProgramUniformMatrix4x2dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.glProgramUniformMatrix4x2dv(program, location, transpose, value);
    }

    public static void nglProgramUniformMatrix3x4dv(int program, int location, int count, boolean transpose, long value) {
        GL41C.nglProgramUniformMatrix3x4dv(program, location, count, transpose, value);
    }

    public static void glProgramUniformMatrix3x4dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.glProgramUniformMatrix3x4dv(program, location, transpose, value);
    }

    public static void nglProgramUniformMatrix4x3dv(int program, int location, int count, boolean transpose, long value) {
        GL41C.nglProgramUniformMatrix4x3dv(program, location, count, transpose, value);
    }

    public static void glProgramUniformMatrix4x3dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.glProgramUniformMatrix4x3dv(program, location, transpose, value);
    }

    public static void glValidateProgramPipeline(@NativeType(value="GLuint") int pipeline) {
        GL41C.glValidateProgramPipeline(pipeline);
    }

    public static void nglGetProgramPipelineInfoLog(int pipeline, int bufSize, long length, long infoLog) {
        GL41C.nglGetProgramPipelineInfoLog(pipeline, bufSize, length, infoLog);
    }

    public static void glGetProgramPipelineInfoLog(@NativeType(value="GLuint") int pipeline, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer infoLog) {
        GL41C.glGetProgramPipelineInfoLog(pipeline, length, infoLog);
    }

    @NativeType(value="void")
    public static String glGetProgramPipelineInfoLog(@NativeType(value="GLuint") int pipeline, @NativeType(value="GLsizei") int bufSize) {
        return GL41C.glGetProgramPipelineInfoLog(pipeline, bufSize);
    }

    @NativeType(value="void")
    public static String glGetProgramPipelineInfoLog(@NativeType(value="GLuint") int pipeline) {
        return ARBSeparateShaderObjects.glGetProgramPipelineInfoLog(pipeline, ARBSeparateShaderObjects.glGetProgramPipelinei(pipeline, 35716));
    }

    public static void glDeleteProgramPipelines(@NativeType(value="GLuint const *") int[] pipelines) {
        GL41C.glDeleteProgramPipelines(pipelines);
    }

    public static void glGenProgramPipelines(@NativeType(value="GLuint *") int[] pipelines) {
        GL41C.glGenProgramPipelines(pipelines);
    }

    public static void glGetProgramPipelineiv(@NativeType(value="GLuint") int pipeline, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL41C.glGetProgramPipelineiv(pipeline, pname, params);
    }

    public static void glProgramUniform1iv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        GL41C.glProgramUniform1iv(program, location, value);
    }

    public static void glProgramUniform2iv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        GL41C.glProgramUniform2iv(program, location, value);
    }

    public static void glProgramUniform3iv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        GL41C.glProgramUniform3iv(program, location, value);
    }

    public static void glProgramUniform4iv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        GL41C.glProgramUniform4iv(program, location, value);
    }

    public static void glProgramUniform1uiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        GL41C.glProgramUniform1uiv(program, location, value);
    }

    public static void glProgramUniform2uiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        GL41C.glProgramUniform2uiv(program, location, value);
    }

    public static void glProgramUniform3uiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        GL41C.glProgramUniform3uiv(program, location, value);
    }

    public static void glProgramUniform4uiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        GL41C.glProgramUniform4uiv(program, location, value);
    }

    public static void glProgramUniform1fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        GL41C.glProgramUniform1fv(program, location, value);
    }

    public static void glProgramUniform2fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        GL41C.glProgramUniform2fv(program, location, value);
    }

    public static void glProgramUniform3fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        GL41C.glProgramUniform3fv(program, location, value);
    }

    public static void glProgramUniform4fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        GL41C.glProgramUniform4fv(program, location, value);
    }

    public static void glProgramUniform1dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") double[] value) {
        GL41C.glProgramUniform1dv(program, location, value);
    }

    public static void glProgramUniform2dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") double[] value) {
        GL41C.glProgramUniform2dv(program, location, value);
    }

    public static void glProgramUniform3dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") double[] value) {
        GL41C.glProgramUniform3dv(program, location, value);
    }

    public static void glProgramUniform4dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") double[] value) {
        GL41C.glProgramUniform4dv(program, location, value);
    }

    public static void glProgramUniformMatrix2fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        GL41C.glProgramUniformMatrix2fv(program, location, transpose, value);
    }

    public static void glProgramUniformMatrix3fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        GL41C.glProgramUniformMatrix3fv(program, location, transpose, value);
    }

    public static void glProgramUniformMatrix4fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        GL41C.glProgramUniformMatrix4fv(program, location, transpose, value);
    }

    public static void glProgramUniformMatrix2dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        GL41C.glProgramUniformMatrix2dv(program, location, transpose, value);
    }

    public static void glProgramUniformMatrix3dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        GL41C.glProgramUniformMatrix3dv(program, location, transpose, value);
    }

    public static void glProgramUniformMatrix4dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        GL41C.glProgramUniformMatrix4dv(program, location, transpose, value);
    }

    public static void glProgramUniformMatrix2x3fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        GL41C.glProgramUniformMatrix2x3fv(program, location, transpose, value);
    }

    public static void glProgramUniformMatrix3x2fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        GL41C.glProgramUniformMatrix3x2fv(program, location, transpose, value);
    }

    public static void glProgramUniformMatrix2x4fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        GL41C.glProgramUniformMatrix2x4fv(program, location, transpose, value);
    }

    public static void glProgramUniformMatrix4x2fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        GL41C.glProgramUniformMatrix4x2fv(program, location, transpose, value);
    }

    public static void glProgramUniformMatrix3x4fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        GL41C.glProgramUniformMatrix3x4fv(program, location, transpose, value);
    }

    public static void glProgramUniformMatrix4x3fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        GL41C.glProgramUniformMatrix4x3fv(program, location, transpose, value);
    }

    public static void glProgramUniformMatrix2x3dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        GL41C.glProgramUniformMatrix2x3dv(program, location, transpose, value);
    }

    public static void glProgramUniformMatrix3x2dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        GL41C.glProgramUniformMatrix3x2dv(program, location, transpose, value);
    }

    public static void glProgramUniformMatrix2x4dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        GL41C.glProgramUniformMatrix2x4dv(program, location, transpose, value);
    }

    public static void glProgramUniformMatrix4x2dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        GL41C.glProgramUniformMatrix4x2dv(program, location, transpose, value);
    }

    public static void glProgramUniformMatrix3x4dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        GL41C.glProgramUniformMatrix3x4dv(program, location, transpose, value);
    }

    public static void glProgramUniformMatrix4x3dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        GL41C.glProgramUniformMatrix4x3dv(program, location, transpose, value);
    }

    public static void glGetProgramPipelineInfoLog(@NativeType(value="GLuint") int pipeline, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer infoLog) {
        GL41C.glGetProgramPipelineInfoLog(pipeline, length, infoLog);
    }

    static {
        GL.initialize();
    }
}

