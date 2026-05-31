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
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class GL20
extends GL15 {
    public static final int GL_SHADING_LANGUAGE_VERSION = 35724;
    public static final int GL_CURRENT_PROGRAM = 35725;
    public static final int GL_SHADER_TYPE = 35663;
    public static final int GL_DELETE_STATUS = 35712;
    public static final int GL_COMPILE_STATUS = 35713;
    public static final int GL_LINK_STATUS = 35714;
    public static final int GL_VALIDATE_STATUS = 35715;
    public static final int GL_INFO_LOG_LENGTH = 35716;
    public static final int GL_ATTACHED_SHADERS = 35717;
    public static final int GL_ACTIVE_UNIFORMS = 35718;
    public static final int GL_ACTIVE_UNIFORM_MAX_LENGTH = 35719;
    public static final int GL_ACTIVE_ATTRIBUTES = 35721;
    public static final int GL_ACTIVE_ATTRIBUTE_MAX_LENGTH = 35722;
    public static final int GL_SHADER_SOURCE_LENGTH = 35720;
    public static final int GL_FLOAT_VEC2 = 35664;
    public static final int GL_FLOAT_VEC3 = 35665;
    public static final int GL_FLOAT_VEC4 = 35666;
    public static final int GL_INT_VEC2 = 35667;
    public static final int GL_INT_VEC3 = 35668;
    public static final int GL_INT_VEC4 = 35669;
    public static final int GL_BOOL = 35670;
    public static final int GL_BOOL_VEC2 = 35671;
    public static final int GL_BOOL_VEC3 = 35672;
    public static final int GL_BOOL_VEC4 = 35673;
    public static final int GL_FLOAT_MAT2 = 35674;
    public static final int GL_FLOAT_MAT3 = 35675;
    public static final int GL_FLOAT_MAT4 = 35676;
    public static final int GL_SAMPLER_1D = 35677;
    public static final int GL_SAMPLER_2D = 35678;
    public static final int GL_SAMPLER_3D = 35679;
    public static final int GL_SAMPLER_CUBE = 35680;
    public static final int GL_SAMPLER_1D_SHADOW = 35681;
    public static final int GL_SAMPLER_2D_SHADOW = 35682;
    public static final int GL_VERTEX_SHADER = 35633;
    public static final int GL_MAX_VERTEX_UNIFORM_COMPONENTS = 35658;
    public static final int GL_MAX_VARYING_FLOATS = 35659;
    public static final int GL_MAX_VERTEX_ATTRIBS = 34921;
    public static final int GL_MAX_TEXTURE_IMAGE_UNITS = 34930;
    public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS = 35660;
    public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = 35661;
    public static final int GL_MAX_TEXTURE_COORDS = 34929;
    public static final int GL_VERTEX_PROGRAM_POINT_SIZE = 34370;
    public static final int GL_VERTEX_PROGRAM_TWO_SIDE = 34371;
    public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED = 34338;
    public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE = 34339;
    public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE = 34340;
    public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE = 34341;
    public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED = 34922;
    public static final int GL_CURRENT_VERTEX_ATTRIB = 34342;
    public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER = 34373;
    public static final int GL_FRAGMENT_SHADER = 35632;
    public static final int GL_MAX_FRAGMENT_UNIFORM_COMPONENTS = 35657;
    public static final int GL_FRAGMENT_SHADER_DERIVATIVE_HINT = 35723;
    public static final int GL_MAX_DRAW_BUFFERS = 34852;
    public static final int GL_DRAW_BUFFER0 = 34853;
    public static final int GL_DRAW_BUFFER1 = 34854;
    public static final int GL_DRAW_BUFFER2 = 34855;
    public static final int GL_DRAW_BUFFER3 = 34856;
    public static final int GL_DRAW_BUFFER4 = 34857;
    public static final int GL_DRAW_BUFFER5 = 34858;
    public static final int GL_DRAW_BUFFER6 = 34859;
    public static final int GL_DRAW_BUFFER7 = 34860;
    public static final int GL_DRAW_BUFFER8 = 34861;
    public static final int GL_DRAW_BUFFER9 = 34862;
    public static final int GL_DRAW_BUFFER10 = 34863;
    public static final int GL_DRAW_BUFFER11 = 34864;
    public static final int GL_DRAW_BUFFER12 = 34865;
    public static final int GL_DRAW_BUFFER13 = 34866;
    public static final int GL_DRAW_BUFFER14 = 34867;
    public static final int GL_DRAW_BUFFER15 = 34868;
    public static final int GL_POINT_SPRITE = 34913;
    public static final int GL_COORD_REPLACE = 34914;
    public static final int GL_POINT_SPRITE_COORD_ORIGIN = 36000;
    public static final int GL_LOWER_LEFT = 36001;
    public static final int GL_UPPER_LEFT = 36002;
    public static final int GL_BLEND_EQUATION_RGB = 32777;
    public static final int GL_BLEND_EQUATION_ALPHA = 34877;
    public static final int GL_STENCIL_BACK_FUNC = 34816;
    public static final int GL_STENCIL_BACK_FAIL = 34817;
    public static final int GL_STENCIL_BACK_PASS_DEPTH_FAIL = 34818;
    public static final int GL_STENCIL_BACK_PASS_DEPTH_PASS = 34819;
    public static final int GL_STENCIL_BACK_REF = 36003;
    public static final int GL_STENCIL_BACK_VALUE_MASK = 36004;
    public static final int GL_STENCIL_BACK_WRITEMASK = 36005;

    protected GL20() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glCreateProgram, caps.glDeleteProgram, caps.glIsProgram, caps.glCreateShader, caps.glDeleteShader, caps.glIsShader, caps.glAttachShader, caps.glDetachShader, caps.glShaderSource, caps.glCompileShader, caps.glLinkProgram, caps.glUseProgram, caps.glValidateProgram, caps.glUniform1f, caps.glUniform2f, caps.glUniform3f, caps.glUniform4f, caps.glUniform1i, caps.glUniform2i, caps.glUniform3i, caps.glUniform4i, caps.glUniform1fv, caps.glUniform2fv, caps.glUniform3fv, caps.glUniform4fv, caps.glUniform1iv, caps.glUniform2iv, caps.glUniform3iv, caps.glUniform4iv, caps.glUniformMatrix2fv, caps.glUniformMatrix3fv, caps.glUniformMatrix4fv, caps.glGetShaderiv, caps.glGetProgramiv, caps.glGetShaderInfoLog, caps.glGetProgramInfoLog, caps.glGetAttachedShaders, caps.glGetUniformLocation, caps.glGetActiveUniform, caps.glGetUniformfv, caps.glGetUniformiv, caps.glGetShaderSource, caps.glVertexAttrib1f, caps.glVertexAttrib1s, caps.glVertexAttrib1d, caps.glVertexAttrib2f, caps.glVertexAttrib2s, caps.glVertexAttrib2d, caps.glVertexAttrib3f, caps.glVertexAttrib3s, caps.glVertexAttrib3d, caps.glVertexAttrib4f, caps.glVertexAttrib4s, caps.glVertexAttrib4d, caps.glVertexAttrib4Nub, caps.glVertexAttrib1fv, caps.glVertexAttrib1sv, caps.glVertexAttrib1dv, caps.glVertexAttrib2fv, caps.glVertexAttrib2sv, caps.glVertexAttrib2dv, caps.glVertexAttrib3fv, caps.glVertexAttrib3sv, caps.glVertexAttrib3dv, caps.glVertexAttrib4fv, caps.glVertexAttrib4sv, caps.glVertexAttrib4dv, caps.glVertexAttrib4iv, caps.glVertexAttrib4bv, caps.glVertexAttrib4ubv, caps.glVertexAttrib4usv, caps.glVertexAttrib4uiv, caps.glVertexAttrib4Nbv, caps.glVertexAttrib4Nsv, caps.glVertexAttrib4Niv, caps.glVertexAttrib4Nubv, caps.glVertexAttrib4Nusv, caps.glVertexAttrib4Nuiv, caps.glVertexAttribPointer, caps.glEnableVertexAttribArray, caps.glDisableVertexAttribArray, caps.glBindAttribLocation, caps.glGetActiveAttrib, caps.glGetAttribLocation, caps.glGetVertexAttribiv, caps.glGetVertexAttribfv, caps.glGetVertexAttribdv, caps.glGetVertexAttribPointerv, caps.glDrawBuffers, caps.glBlendEquationSeparate, caps.glStencilOpSeparate, caps.glStencilFuncSeparate, caps.glStencilMaskSeparate);
    }

    @NativeType(value="GLuint")
    public static int glCreateProgram() {
        return GL20C.glCreateProgram();
    }

    public static void glDeleteProgram(@NativeType(value="GLuint") int program) {
        GL20C.glDeleteProgram(program);
    }

    @NativeType(value="GLboolean")
    public static boolean glIsProgram(@NativeType(value="GLuint") int program) {
        return GL20C.glIsProgram(program);
    }

    @NativeType(value="GLuint")
    public static int glCreateShader(@NativeType(value="GLenum") int type) {
        return GL20C.glCreateShader(type);
    }

    public static void glDeleteShader(@NativeType(value="GLuint") int shader) {
        GL20C.glDeleteShader(shader);
    }

    @NativeType(value="GLboolean")
    public static boolean glIsShader(@NativeType(value="GLuint") int shader) {
        return GL20C.glIsShader(shader);
    }

    public static void glAttachShader(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int shader) {
        GL20C.glAttachShader(program, shader);
    }

    public static void glDetachShader(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int shader) {
        GL20C.glDetachShader(program, shader);
    }

    public static void nglShaderSource(int shader, int count, long strings, long length) {
        GL20C.nglShaderSource(shader, count, strings, length);
    }

    public static void glShaderSource(@NativeType(value="GLuint") int shader, @NativeType(value="GLchar const **") PointerBuffer strings, @Nullable @NativeType(value="GLint const *") IntBuffer length) {
        GL20C.glShaderSource(shader, strings, length);
    }

    public static void glShaderSource(@NativeType(value="GLuint") int shader, CharSequence ... strings) {
        GL20C.glShaderSource(shader, strings);
    }

    public static void glShaderSource(@NativeType(value="GLuint") int shader, @NativeType(value="GLchar const **") CharSequence string) {
        GL20C.glShaderSource(shader, string);
    }

    public static void glCompileShader(@NativeType(value="GLuint") int shader) {
        GL20C.glCompileShader(shader);
    }

    public static void glLinkProgram(@NativeType(value="GLuint") int program) {
        GL20C.glLinkProgram(program);
    }

    public static void glUseProgram(@NativeType(value="GLuint") int program) {
        GL20C.glUseProgram(program);
    }

    public static void glValidateProgram(@NativeType(value="GLuint") int program) {
        GL20C.glValidateProgram(program);
    }

    public static void glUniform1f(@NativeType(value="GLint") int location, @NativeType(value="GLfloat") float v0) {
        GL20C.glUniform1f(location, v0);
    }

    public static void glUniform2f(@NativeType(value="GLint") int location, @NativeType(value="GLfloat") float v0, @NativeType(value="GLfloat") float v1) {
        GL20C.glUniform2f(location, v0, v1);
    }

    public static void glUniform3f(@NativeType(value="GLint") int location, @NativeType(value="GLfloat") float v0, @NativeType(value="GLfloat") float v1, @NativeType(value="GLfloat") float v2) {
        GL20C.glUniform3f(location, v0, v1, v2);
    }

    public static void glUniform4f(@NativeType(value="GLint") int location, @NativeType(value="GLfloat") float v0, @NativeType(value="GLfloat") float v1, @NativeType(value="GLfloat") float v2, @NativeType(value="GLfloat") float v3) {
        GL20C.glUniform4f(location, v0, v1, v2, v3);
    }

    public static void glUniform1i(@NativeType(value="GLint") int location, @NativeType(value="GLint") int v0) {
        GL20C.glUniform1i(location, v0);
    }

    public static void glUniform2i(@NativeType(value="GLint") int location, @NativeType(value="GLint") int v0, @NativeType(value="GLint") int v1) {
        GL20C.glUniform2i(location, v0, v1);
    }

    public static void glUniform3i(@NativeType(value="GLint") int location, @NativeType(value="GLint") int v0, @NativeType(value="GLint") int v1, @NativeType(value="GLint") int v2) {
        GL20C.glUniform3i(location, v0, v1, v2);
    }

    public static void glUniform4i(@NativeType(value="GLint") int location, @NativeType(value="GLint") int v0, @NativeType(value="GLint") int v1, @NativeType(value="GLint") int v2, @NativeType(value="GLint") int v3) {
        GL20C.glUniform4i(location, v0, v1, v2, v3);
    }

    public static void nglUniform1fv(int location, int count, long value) {
        GL20C.nglUniform1fv(location, count, value);
    }

    public static void glUniform1fv(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL20C.glUniform1fv(location, value);
    }

    public static void nglUniform2fv(int location, int count, long value) {
        GL20C.nglUniform2fv(location, count, value);
    }

    public static void glUniform2fv(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL20C.glUniform2fv(location, value);
    }

    public static void nglUniform3fv(int location, int count, long value) {
        GL20C.nglUniform3fv(location, count, value);
    }

    public static void glUniform3fv(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL20C.glUniform3fv(location, value);
    }

    public static void nglUniform4fv(int location, int count, long value) {
        GL20C.nglUniform4fv(location, count, value);
    }

    public static void glUniform4fv(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL20C.glUniform4fv(location, value);
    }

    public static void nglUniform1iv(int location, int count, long value) {
        GL20C.nglUniform1iv(location, count, value);
    }

    public static void glUniform1iv(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        GL20C.glUniform1iv(location, value);
    }

    public static void nglUniform2iv(int location, int count, long value) {
        GL20C.nglUniform2iv(location, count, value);
    }

    public static void glUniform2iv(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        GL20C.glUniform2iv(location, value);
    }

    public static void nglUniform3iv(int location, int count, long value) {
        GL20C.nglUniform3iv(location, count, value);
    }

    public static void glUniform3iv(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        GL20C.glUniform3iv(location, value);
    }

    public static void nglUniform4iv(int location, int count, long value) {
        GL20C.nglUniform4iv(location, count, value);
    }

    public static void glUniform4iv(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        GL20C.glUniform4iv(location, value);
    }

    public static void nglUniformMatrix2fv(int location, int count, boolean transpose, long value) {
        GL20C.nglUniformMatrix2fv(location, count, transpose, value);
    }

    public static void glUniformMatrix2fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL20C.glUniformMatrix2fv(location, transpose, value);
    }

    public static void nglUniformMatrix3fv(int location, int count, boolean transpose, long value) {
        GL20C.nglUniformMatrix3fv(location, count, transpose, value);
    }

    public static void glUniformMatrix3fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL20C.glUniformMatrix3fv(location, transpose, value);
    }

    public static void nglUniformMatrix4fv(int location, int count, boolean transpose, long value) {
        GL20C.nglUniformMatrix4fv(location, count, transpose, value);
    }

    public static void glUniformMatrix4fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL20C.glUniformMatrix4fv(location, transpose, value);
    }

    public static void nglGetShaderiv(int shader, int pname, long params) {
        GL20C.nglGetShaderiv(shader, pname, params);
    }

    public static void glGetShaderiv(@NativeType(value="GLuint") int shader, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL20C.glGetShaderiv(shader, pname, params);
    }

    @NativeType(value="void")
    public static int glGetShaderi(@NativeType(value="GLuint") int shader, @NativeType(value="GLenum") int pname) {
        return GL20C.glGetShaderi(shader, pname);
    }

    public static void nglGetProgramiv(int program, int pname, long params) {
        GL20C.nglGetProgramiv(program, pname, params);
    }

    public static void glGetProgramiv(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL20C.glGetProgramiv(program, pname, params);
    }

    @NativeType(value="void")
    public static int glGetProgrami(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int pname) {
        return GL20C.glGetProgrami(program, pname);
    }

    public static void nglGetShaderInfoLog(int shader, int maxLength, long length, long infoLog) {
        GL20C.nglGetShaderInfoLog(shader, maxLength, length, infoLog);
    }

    public static void glGetShaderInfoLog(@NativeType(value="GLuint") int shader, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer infoLog) {
        GL20C.glGetShaderInfoLog(shader, length, infoLog);
    }

    @NativeType(value="void")
    public static String glGetShaderInfoLog(@NativeType(value="GLuint") int shader, @NativeType(value="GLsizei") int maxLength) {
        return GL20C.glGetShaderInfoLog(shader, maxLength);
    }

    @NativeType(value="void")
    public static String glGetShaderInfoLog(@NativeType(value="GLuint") int shader) {
        return GL20.glGetShaderInfoLog(shader, GL20.glGetShaderi(shader, 35716));
    }

    public static void nglGetProgramInfoLog(int program, int maxLength, long length, long infoLog) {
        GL20C.nglGetProgramInfoLog(program, maxLength, length, infoLog);
    }

    public static void glGetProgramInfoLog(@NativeType(value="GLuint") int program, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer infoLog) {
        GL20C.glGetProgramInfoLog(program, length, infoLog);
    }

    @NativeType(value="void")
    public static String glGetProgramInfoLog(@NativeType(value="GLuint") int program, @NativeType(value="GLsizei") int maxLength) {
        return GL20C.glGetProgramInfoLog(program, maxLength);
    }

    @NativeType(value="void")
    public static String glGetProgramInfoLog(@NativeType(value="GLuint") int program) {
        return GL20.glGetProgramInfoLog(program, GL20.glGetProgrami(program, 35716));
    }

    public static void nglGetAttachedShaders(int program, int maxCount, long count, long shaders) {
        GL20C.nglGetAttachedShaders(program, maxCount, count, shaders);
    }

    public static void glGetAttachedShaders(@NativeType(value="GLuint") int program, @Nullable @NativeType(value="GLsizei *") IntBuffer count, @NativeType(value="GLuint *") IntBuffer shaders) {
        GL20C.glGetAttachedShaders(program, count, shaders);
    }

    public static int nglGetUniformLocation(int program, long name) {
        return GL20C.nglGetUniformLocation(program, name);
    }

    @NativeType(value="GLint")
    public static int glGetUniformLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") ByteBuffer name) {
        return GL20C.glGetUniformLocation(program, name);
    }

    @NativeType(value="GLint")
    public static int glGetUniformLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") CharSequence name) {
        return GL20C.glGetUniformLocation(program, name);
    }

    public static void nglGetActiveUniform(int program, int index, int maxLength, long length, long size, long type, long name) {
        GL20C.nglGetActiveUniform(program, index, maxLength, length, size, type, name);
    }

    public static void glGetActiveUniform(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLint *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type, @NativeType(value="GLchar *") ByteBuffer name) {
        GL20C.glGetActiveUniform(program, index, length, size, type, name);
    }

    @NativeType(value="void")
    public static String glGetActiveUniform(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @NativeType(value="GLsizei") int maxLength, @NativeType(value="GLint *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type) {
        return GL20C.glGetActiveUniform(program, index, maxLength, size, type);
    }

    @NativeType(value="void")
    public static String glGetActiveUniform(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type) {
        return GL20.glGetActiveUniform(program, index, GL20.glGetProgrami(program, 35719), size, type);
    }

    public static void nglGetUniformfv(int program, int location, long params) {
        GL20C.nglGetUniformfv(program, location, params);
    }

    public static void glGetUniformfv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat *") FloatBuffer params) {
        GL20C.glGetUniformfv(program, location, params);
    }

    @NativeType(value="void")
    public static float glGetUniformf(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        return GL20C.glGetUniformf(program, location);
    }

    public static void nglGetUniformiv(int program, int location, long params) {
        GL20C.nglGetUniformiv(program, location, params);
    }

    public static void glGetUniformiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint *") IntBuffer params) {
        GL20C.glGetUniformiv(program, location, params);
    }

    @NativeType(value="void")
    public static int glGetUniformi(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        return GL20C.glGetUniformi(program, location);
    }

    public static void nglGetShaderSource(int shader, int maxLength, long length, long source) {
        GL20C.nglGetShaderSource(shader, maxLength, length, source);
    }

    public static void glGetShaderSource(@NativeType(value="GLuint") int shader, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer source) {
        GL20C.glGetShaderSource(shader, length, source);
    }

    @NativeType(value="void")
    public static String glGetShaderSource(@NativeType(value="GLuint") int shader, @NativeType(value="GLsizei") int maxLength) {
        return GL20C.glGetShaderSource(shader, maxLength);
    }

    @NativeType(value="void")
    public static String glGetShaderSource(@NativeType(value="GLuint") int shader) {
        return GL20.glGetShaderSource(shader, GL20.glGetShaderi(shader, 35720));
    }

    public static void glVertexAttrib1f(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat") float v0) {
        GL20C.glVertexAttrib1f(index, v0);
    }

    public static void glVertexAttrib1s(@NativeType(value="GLuint") int index, @NativeType(value="GLshort") short v0) {
        GL20C.glVertexAttrib1s(index, v0);
    }

    public static void glVertexAttrib1d(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble") double v0) {
        GL20C.glVertexAttrib1d(index, v0);
    }

    public static void glVertexAttrib2f(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat") float v0, @NativeType(value="GLfloat") float v1) {
        GL20C.glVertexAttrib2f(index, v0, v1);
    }

    public static void glVertexAttrib2s(@NativeType(value="GLuint") int index, @NativeType(value="GLshort") short v0, @NativeType(value="GLshort") short v1) {
        GL20C.glVertexAttrib2s(index, v0, v1);
    }

    public static void glVertexAttrib2d(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble") double v0, @NativeType(value="GLdouble") double v1) {
        GL20C.glVertexAttrib2d(index, v0, v1);
    }

    public static void glVertexAttrib3f(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat") float v0, @NativeType(value="GLfloat") float v1, @NativeType(value="GLfloat") float v2) {
        GL20C.glVertexAttrib3f(index, v0, v1, v2);
    }

    public static void glVertexAttrib3s(@NativeType(value="GLuint") int index, @NativeType(value="GLshort") short v0, @NativeType(value="GLshort") short v1, @NativeType(value="GLshort") short v2) {
        GL20C.glVertexAttrib3s(index, v0, v1, v2);
    }

    public static void glVertexAttrib3d(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble") double v0, @NativeType(value="GLdouble") double v1, @NativeType(value="GLdouble") double v2) {
        GL20C.glVertexAttrib3d(index, v0, v1, v2);
    }

    public static void glVertexAttrib4f(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat") float v0, @NativeType(value="GLfloat") float v1, @NativeType(value="GLfloat") float v2, @NativeType(value="GLfloat") float v3) {
        GL20C.glVertexAttrib4f(index, v0, v1, v2, v3);
    }

    public static void glVertexAttrib4s(@NativeType(value="GLuint") int index, @NativeType(value="GLshort") short v0, @NativeType(value="GLshort") short v1, @NativeType(value="GLshort") short v2, @NativeType(value="GLshort") short v3) {
        GL20C.glVertexAttrib4s(index, v0, v1, v2, v3);
    }

    public static void glVertexAttrib4d(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble") double v0, @NativeType(value="GLdouble") double v1, @NativeType(value="GLdouble") double v2, @NativeType(value="GLdouble") double v3) {
        GL20C.glVertexAttrib4d(index, v0, v1, v2, v3);
    }

    public static void glVertexAttrib4Nub(@NativeType(value="GLuint") int index, @NativeType(value="GLubyte") byte x, @NativeType(value="GLubyte") byte y, @NativeType(value="GLubyte") byte z, @NativeType(value="GLubyte") byte w) {
        GL20C.glVertexAttrib4Nub(index, x, y, z, w);
    }

    public static void nglVertexAttrib1fv(int index, long v) {
        GL20C.nglVertexAttrib1fv(index, v);
    }

    public static void glVertexAttrib1fv(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer v) {
        GL20C.glVertexAttrib1fv(index, v);
    }

    public static void nglVertexAttrib1sv(int index, long v) {
        GL20C.nglVertexAttrib1sv(index, v);
    }

    public static void glVertexAttrib1sv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        GL20C.glVertexAttrib1sv(index, v);
    }

    public static void nglVertexAttrib1dv(int index, long v) {
        GL20C.nglVertexAttrib1dv(index, v);
    }

    public static void glVertexAttrib1dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        GL20C.glVertexAttrib1dv(index, v);
    }

    public static void nglVertexAttrib2fv(int index, long v) {
        GL20C.nglVertexAttrib2fv(index, v);
    }

    public static void glVertexAttrib2fv(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer v) {
        GL20C.glVertexAttrib2fv(index, v);
    }

    public static void nglVertexAttrib2sv(int index, long v) {
        GL20C.nglVertexAttrib2sv(index, v);
    }

    public static void glVertexAttrib2sv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        GL20C.glVertexAttrib2sv(index, v);
    }

    public static void nglVertexAttrib2dv(int index, long v) {
        GL20C.nglVertexAttrib2dv(index, v);
    }

    public static void glVertexAttrib2dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        GL20C.glVertexAttrib2dv(index, v);
    }

    public static void nglVertexAttrib3fv(int index, long v) {
        GL20C.nglVertexAttrib3fv(index, v);
    }

    public static void glVertexAttrib3fv(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer v) {
        GL20C.glVertexAttrib3fv(index, v);
    }

    public static void nglVertexAttrib3sv(int index, long v) {
        GL20C.nglVertexAttrib3sv(index, v);
    }

    public static void glVertexAttrib3sv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        GL20C.glVertexAttrib3sv(index, v);
    }

    public static void nglVertexAttrib3dv(int index, long v) {
        GL20C.nglVertexAttrib3dv(index, v);
    }

    public static void glVertexAttrib3dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        GL20C.glVertexAttrib3dv(index, v);
    }

    public static void nglVertexAttrib4fv(int index, long v) {
        GL20C.nglVertexAttrib4fv(index, v);
    }

    public static void glVertexAttrib4fv(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer v) {
        GL20C.glVertexAttrib4fv(index, v);
    }

    public static void nglVertexAttrib4sv(int index, long v) {
        GL20C.nglVertexAttrib4sv(index, v);
    }

    public static void glVertexAttrib4sv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        GL20C.glVertexAttrib4sv(index, v);
    }

    public static void nglVertexAttrib4dv(int index, long v) {
        GL20C.nglVertexAttrib4dv(index, v);
    }

    public static void glVertexAttrib4dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        GL20C.glVertexAttrib4dv(index, v);
    }

    public static void nglVertexAttrib4iv(int index, long v) {
        GL20C.nglVertexAttrib4iv(index, v);
    }

    public static void glVertexAttrib4iv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer v) {
        GL20C.glVertexAttrib4iv(index, v);
    }

    public static void nglVertexAttrib4bv(int index, long v) {
        GL20C.nglVertexAttrib4bv(index, v);
    }

    public static void glVertexAttrib4bv(@NativeType(value="GLuint") int index, @NativeType(value="GLbyte const *") ByteBuffer v) {
        GL20C.glVertexAttrib4bv(index, v);
    }

    public static void nglVertexAttrib4ubv(int index, long v) {
        GL20C.nglVertexAttrib4ubv(index, v);
    }

    public static void glVertexAttrib4ubv(@NativeType(value="GLuint") int index, @NativeType(value="GLubyte const *") ByteBuffer v) {
        GL20C.glVertexAttrib4ubv(index, v);
    }

    public static void nglVertexAttrib4usv(int index, long v) {
        GL20C.nglVertexAttrib4usv(index, v);
    }

    public static void glVertexAttrib4usv(@NativeType(value="GLuint") int index, @NativeType(value="GLushort const *") ShortBuffer v) {
        GL20C.glVertexAttrib4usv(index, v);
    }

    public static void nglVertexAttrib4uiv(int index, long v) {
        GL20C.nglVertexAttrib4uiv(index, v);
    }

    public static void glVertexAttrib4uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") IntBuffer v) {
        GL20C.glVertexAttrib4uiv(index, v);
    }

    public static void nglVertexAttrib4Nbv(int index, long v) {
        GL20C.nglVertexAttrib4Nbv(index, v);
    }

    public static void glVertexAttrib4Nbv(@NativeType(value="GLuint") int index, @NativeType(value="GLbyte const *") ByteBuffer v) {
        GL20C.glVertexAttrib4Nbv(index, v);
    }

    public static void nglVertexAttrib4Nsv(int index, long v) {
        GL20C.nglVertexAttrib4Nsv(index, v);
    }

    public static void glVertexAttrib4Nsv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        GL20C.glVertexAttrib4Nsv(index, v);
    }

    public static void nglVertexAttrib4Niv(int index, long v) {
        GL20C.nglVertexAttrib4Niv(index, v);
    }

    public static void glVertexAttrib4Niv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer v) {
        GL20C.glVertexAttrib4Niv(index, v);
    }

    public static void nglVertexAttrib4Nubv(int index, long v) {
        GL20C.nglVertexAttrib4Nubv(index, v);
    }

    public static void glVertexAttrib4Nubv(@NativeType(value="GLuint") int index, @NativeType(value="GLubyte const *") ByteBuffer v) {
        GL20C.glVertexAttrib4Nubv(index, v);
    }

    public static void nglVertexAttrib4Nusv(int index, long v) {
        GL20C.nglVertexAttrib4Nusv(index, v);
    }

    public static void glVertexAttrib4Nusv(@NativeType(value="GLuint") int index, @NativeType(value="GLushort const *") ShortBuffer v) {
        GL20C.glVertexAttrib4Nusv(index, v);
    }

    public static void nglVertexAttrib4Nuiv(int index, long v) {
        GL20C.nglVertexAttrib4Nuiv(index, v);
    }

    public static void glVertexAttrib4Nuiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") IntBuffer v) {
        GL20C.glVertexAttrib4Nuiv(index, v);
    }

    public static void nglVertexAttribPointer(int index, int size, int type, boolean normalized, int stride, long pointer) {
        GL20C.nglVertexAttribPointer(index, size, type, normalized, stride, pointer);
    }

    public static void glVertexAttribPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ByteBuffer pointer) {
        GL20C.glVertexAttribPointer(index, size, type, normalized, stride, pointer);
    }

    public static void glVertexAttribPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") long pointer) {
        GL20C.glVertexAttribPointer(index, size, type, normalized, stride, pointer);
    }

    public static void glVertexAttribPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ShortBuffer pointer) {
        GL20C.glVertexAttribPointer(index, size, type, normalized, stride, pointer);
    }

    public static void glVertexAttribPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") IntBuffer pointer) {
        GL20C.glVertexAttribPointer(index, size, type, normalized, stride, pointer);
    }

    public static void glVertexAttribPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") FloatBuffer pointer) {
        GL20C.glVertexAttribPointer(index, size, type, normalized, stride, pointer);
    }

    public static void glEnableVertexAttribArray(@NativeType(value="GLuint") int index) {
        GL20C.glEnableVertexAttribArray(index);
    }

    public static void glDisableVertexAttribArray(@NativeType(value="GLuint") int index) {
        GL20C.glDisableVertexAttribArray(index);
    }

    public static void nglBindAttribLocation(int program, int index, long name) {
        GL20C.nglBindAttribLocation(program, index, name);
    }

    public static void glBindAttribLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @NativeType(value="GLchar const *") ByteBuffer name) {
        GL20C.glBindAttribLocation(program, index, name);
    }

    public static void glBindAttribLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @NativeType(value="GLchar const *") CharSequence name) {
        GL20C.glBindAttribLocation(program, index, name);
    }

    public static void nglGetActiveAttrib(int program, int index, int maxLength, long length, long size, long type, long name) {
        GL20C.nglGetActiveAttrib(program, index, maxLength, length, size, type, name);
    }

    public static void glGetActiveAttrib(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLint *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type, @NativeType(value="GLchar *") ByteBuffer name) {
        GL20C.glGetActiveAttrib(program, index, length, size, type, name);
    }

    @NativeType(value="void")
    public static String glGetActiveAttrib(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @NativeType(value="GLsizei") int maxLength, @NativeType(value="GLint *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type) {
        return GL20C.glGetActiveAttrib(program, index, maxLength, size, type);
    }

    @NativeType(value="void")
    public static String glGetActiveAttrib(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type) {
        return GL20.glGetActiveAttrib(program, index, GL20.glGetProgrami(program, 35722), size, type);
    }

    public static int nglGetAttribLocation(int program, long name) {
        return GL20C.nglGetAttribLocation(program, name);
    }

    @NativeType(value="GLint")
    public static int glGetAttribLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") ByteBuffer name) {
        return GL20C.glGetAttribLocation(program, name);
    }

    @NativeType(value="GLint")
    public static int glGetAttribLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") CharSequence name) {
        return GL20C.glGetAttribLocation(program, name);
    }

    public static void nglGetVertexAttribiv(int index, int pname, long params) {
        GL20C.nglGetVertexAttribiv(index, pname, params);
    }

    public static void glGetVertexAttribiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL20C.glGetVertexAttribiv(index, pname, params);
    }

    @NativeType(value="void")
    public static int glGetVertexAttribi(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        return GL20C.glGetVertexAttribi(index, pname);
    }

    public static void nglGetVertexAttribfv(int index, int pname, long params) {
        GL20C.nglGetVertexAttribfv(index, pname, params);
    }

    public static void glGetVertexAttribfv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        GL20C.glGetVertexAttribfv(index, pname, params);
    }

    public static void nglGetVertexAttribdv(int index, int pname, long params) {
        GL20C.nglGetVertexAttribdv(index, pname, params);
    }

    public static void glGetVertexAttribdv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLdouble *") DoubleBuffer params) {
        GL20C.glGetVertexAttribdv(index, pname, params);
    }

    public static void nglGetVertexAttribPointerv(int index, int pname, long pointer) {
        GL20C.nglGetVertexAttribPointerv(index, pname, pointer);
    }

    public static void glGetVertexAttribPointerv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="void **") PointerBuffer pointer) {
        GL20C.glGetVertexAttribPointerv(index, pname, pointer);
    }

    @NativeType(value="void")
    public static long glGetVertexAttribPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        return GL20C.glGetVertexAttribPointer(index, pname);
    }

    public static void nglDrawBuffers(int n, long bufs) {
        GL20C.nglDrawBuffers(n, bufs);
    }

    public static void glDrawBuffers(@NativeType(value="GLenum const *") IntBuffer bufs) {
        GL20C.glDrawBuffers(bufs);
    }

    public static void glDrawBuffers(@NativeType(value="GLenum const *") int buf) {
        GL20C.glDrawBuffers(buf);
    }

    public static void glBlendEquationSeparate(@NativeType(value="GLenum") int modeRGB, @NativeType(value="GLenum") int modeAlpha) {
        GL20C.glBlendEquationSeparate(modeRGB, modeAlpha);
    }

    public static void glStencilOpSeparate(@NativeType(value="GLenum") int face, @NativeType(value="GLenum") int sfail, @NativeType(value="GLenum") int dpfail, @NativeType(value="GLenum") int dppass) {
        GL20C.glStencilOpSeparate(face, sfail, dpfail, dppass);
    }

    public static void glStencilFuncSeparate(@NativeType(value="GLenum") int face, @NativeType(value="GLenum") int func, @NativeType(value="GLint") int ref, @NativeType(value="GLuint") int mask) {
        GL20C.glStencilFuncSeparate(face, func, ref, mask);
    }

    public static void glStencilMaskSeparate(@NativeType(value="GLenum") int face, @NativeType(value="GLuint") int mask) {
        GL20C.glStencilMaskSeparate(face, mask);
    }

    public static void glShaderSource(@NativeType(value="GLuint") int shader, @NativeType(value="GLchar const **") PointerBuffer strings, @Nullable @NativeType(value="GLint const *") int[] length) {
        GL20C.glShaderSource(shader, strings, length);
    }

    public static void glUniform1fv(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        GL20C.glUniform1fv(location, value);
    }

    public static void glUniform2fv(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        GL20C.glUniform2fv(location, value);
    }

    public static void glUniform3fv(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        GL20C.glUniform3fv(location, value);
    }

    public static void glUniform4fv(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        GL20C.glUniform4fv(location, value);
    }

    public static void glUniform1iv(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        GL20C.glUniform1iv(location, value);
    }

    public static void glUniform2iv(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        GL20C.glUniform2iv(location, value);
    }

    public static void glUniform3iv(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        GL20C.glUniform3iv(location, value);
    }

    public static void glUniform4iv(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        GL20C.glUniform4iv(location, value);
    }

    public static void glUniformMatrix2fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        GL20C.glUniformMatrix2fv(location, transpose, value);
    }

    public static void glUniformMatrix3fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        GL20C.glUniformMatrix3fv(location, transpose, value);
    }

    public static void glUniformMatrix4fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        GL20C.glUniformMatrix4fv(location, transpose, value);
    }

    public static void glGetShaderiv(@NativeType(value="GLuint") int shader, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL20C.glGetShaderiv(shader, pname, params);
    }

    public static void glGetProgramiv(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL20C.glGetProgramiv(program, pname, params);
    }

    public static void glGetShaderInfoLog(@NativeType(value="GLuint") int shader, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer infoLog) {
        GL20C.glGetShaderInfoLog(shader, length, infoLog);
    }

    public static void glGetProgramInfoLog(@NativeType(value="GLuint") int program, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer infoLog) {
        GL20C.glGetProgramInfoLog(program, length, infoLog);
    }

    public static void glGetAttachedShaders(@NativeType(value="GLuint") int program, @Nullable @NativeType(value="GLsizei *") int[] count, @NativeType(value="GLuint *") int[] shaders) {
        GL20C.glGetAttachedShaders(program, count, shaders);
    }

    public static void glGetActiveUniform(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLint *") int[] size, @NativeType(value="GLenum *") int[] type, @NativeType(value="GLchar *") ByteBuffer name) {
        GL20C.glGetActiveUniform(program, index, length, size, type, name);
    }

    public static void glGetUniformfv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat *") float[] params) {
        GL20C.glGetUniformfv(program, location, params);
    }

    public static void glGetUniformiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint *") int[] params) {
        GL20C.glGetUniformiv(program, location, params);
    }

    public static void glGetShaderSource(@NativeType(value="GLuint") int shader, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer source) {
        GL20C.glGetShaderSource(shader, length, source);
    }

    public static void glVertexAttrib1fv(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] v) {
        GL20C.glVertexAttrib1fv(index, v);
    }

    public static void glVertexAttrib1sv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        GL20C.glVertexAttrib1sv(index, v);
    }

    public static void glVertexAttrib1dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        GL20C.glVertexAttrib1dv(index, v);
    }

    public static void glVertexAttrib2fv(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] v) {
        GL20C.glVertexAttrib2fv(index, v);
    }

    public static void glVertexAttrib2sv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        GL20C.glVertexAttrib2sv(index, v);
    }

    public static void glVertexAttrib2dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        GL20C.glVertexAttrib2dv(index, v);
    }

    public static void glVertexAttrib3fv(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] v) {
        GL20C.glVertexAttrib3fv(index, v);
    }

    public static void glVertexAttrib3sv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        GL20C.glVertexAttrib3sv(index, v);
    }

    public static void glVertexAttrib3dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        GL20C.glVertexAttrib3dv(index, v);
    }

    public static void glVertexAttrib4fv(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] v) {
        GL20C.glVertexAttrib4fv(index, v);
    }

    public static void glVertexAttrib4sv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        GL20C.glVertexAttrib4sv(index, v);
    }

    public static void glVertexAttrib4dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        GL20C.glVertexAttrib4dv(index, v);
    }

    public static void glVertexAttrib4iv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] v) {
        GL20C.glVertexAttrib4iv(index, v);
    }

    public static void glVertexAttrib4usv(@NativeType(value="GLuint") int index, @NativeType(value="GLushort const *") short[] v) {
        GL20C.glVertexAttrib4usv(index, v);
    }

    public static void glVertexAttrib4uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") int[] v) {
        GL20C.glVertexAttrib4uiv(index, v);
    }

    public static void glVertexAttrib4Nsv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        GL20C.glVertexAttrib4Nsv(index, v);
    }

    public static void glVertexAttrib4Niv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] v) {
        GL20C.glVertexAttrib4Niv(index, v);
    }

    public static void glVertexAttrib4Nusv(@NativeType(value="GLuint") int index, @NativeType(value="GLushort const *") short[] v) {
        GL20C.glVertexAttrib4Nusv(index, v);
    }

    public static void glVertexAttrib4Nuiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") int[] v) {
        GL20C.glVertexAttrib4Nuiv(index, v);
    }

    public static void glGetActiveAttrib(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLint *") int[] size, @NativeType(value="GLenum *") int[] type, @NativeType(value="GLchar *") ByteBuffer name) {
        GL20C.glGetActiveAttrib(program, index, length, size, type, name);
    }

    public static void glGetVertexAttribiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL20C.glGetVertexAttribiv(index, pname, params);
    }

    public static void glGetVertexAttribfv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        GL20C.glGetVertexAttribfv(index, pname, params);
    }

    public static void glGetVertexAttribdv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLdouble *") double[] params) {
        GL20C.glGetVertexAttribdv(index, pname, params);
    }

    public static void glDrawBuffers(@NativeType(value="GLenum const *") int[] bufs) {
        GL20C.glDrawBuffers(bufs);
    }

    static {
        GL.initialize();
    }
}

