/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL40C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBShaderSubroutine {
    public static final int GL_ACTIVE_SUBROUTINES = 36325;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORMS = 36326;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_LOCATIONS = 36423;
    public static final int GL_ACTIVE_SUBROUTINE_MAX_LENGTH = 36424;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_MAX_LENGTH = 36425;
    public static final int GL_MAX_SUBROUTINES = 36327;
    public static final int GL_MAX_SUBROUTINE_UNIFORM_LOCATIONS = 36328;
    public static final int GL_NUM_COMPATIBLE_SUBROUTINES = 36426;
    public static final int GL_COMPATIBLE_SUBROUTINES = 36427;

    protected ARBShaderSubroutine() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glGetSubroutineUniformLocation, caps.glGetSubroutineIndex, caps.glGetActiveSubroutineUniformiv, caps.glGetActiveSubroutineUniformName, caps.glGetActiveSubroutineName, caps.glUniformSubroutinesuiv, caps.glGetUniformSubroutineuiv, caps.glGetProgramStageiv);
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
        return ARBShaderSubroutine.glGetActiveSubroutineUniformName(program, shadertype, index, ARBShaderSubroutine.glGetActiveSubroutineUniformi(program, shadertype, index, 35385));
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
        return ARBShaderSubroutine.glGetActiveSubroutineName(program, shadertype, index, ARBShaderSubroutine.glGetProgramStagei(program, shadertype, 36424));
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

    static {
        GL.initialize();
    }
}

