/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL33C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBSamplerObjects {
    public static final int GL_SAMPLER_BINDING = 35097;

    protected ARBSamplerObjects() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glGenSamplers, caps.glDeleteSamplers, caps.glIsSampler, caps.glBindSampler, caps.glSamplerParameteri, caps.glSamplerParameterf, caps.glSamplerParameteriv, caps.glSamplerParameterfv, caps.glSamplerParameterIiv, caps.glSamplerParameterIuiv, caps.glGetSamplerParameteriv, caps.glGetSamplerParameterfv, caps.glGetSamplerParameterIiv, caps.glGetSamplerParameterIuiv);
    }

    public static void nglGenSamplers(int count, long samplers) {
        GL33C.nglGenSamplers(count, samplers);
    }

    public static void glGenSamplers(@NativeType(value="GLuint *") IntBuffer samplers) {
        GL33C.glGenSamplers(samplers);
    }

    @NativeType(value="void")
    public static int glGenSamplers() {
        return GL33C.glGenSamplers();
    }

    public static void nglDeleteSamplers(int count, long samplers) {
        GL33C.nglDeleteSamplers(count, samplers);
    }

    public static void glDeleteSamplers(@NativeType(value="GLuint const *") IntBuffer samplers) {
        GL33C.glDeleteSamplers(samplers);
    }

    public static void glDeleteSamplers(@NativeType(value="GLuint const *") int sampler) {
        GL33C.glDeleteSamplers(sampler);
    }

    @NativeType(value="GLboolean")
    public static boolean glIsSampler(@NativeType(value="GLuint") int sampler) {
        return GL33C.glIsSampler(sampler);
    }

    public static void glBindSampler(@NativeType(value="GLuint") int unit, @NativeType(value="GLuint") int sampler) {
        GL33C.glBindSampler(unit, sampler);
    }

    public static void glSamplerParameteri(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint") int param) {
        GL33C.glSamplerParameteri(sampler, pname, param);
    }

    public static void glSamplerParameterf(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat") float param) {
        GL33C.glSamplerParameterf(sampler, pname, param);
    }

    public static void nglSamplerParameteriv(int sampler, int pname, long params) {
        GL33C.nglSamplerParameteriv(sampler, pname, params);
    }

    public static void glSamplerParameteriv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        GL33C.glSamplerParameteriv(sampler, pname, params);
    }

    public static void nglSamplerParameterfv(int sampler, int pname, long params) {
        GL33C.nglSamplerParameterfv(sampler, pname, params);
    }

    public static void glSamplerParameterfv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer params) {
        GL33C.glSamplerParameterfv(sampler, pname, params);
    }

    public static void nglSamplerParameterIiv(int sampler, int pname, long params) {
        GL33C.nglSamplerParameterIiv(sampler, pname, params);
    }

    public static void glSamplerParameterIiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        GL33C.glSamplerParameterIiv(sampler, pname, params);
    }

    public static void nglSamplerParameterIuiv(int sampler, int pname, long params) {
        GL33C.nglSamplerParameterIuiv(sampler, pname, params);
    }

    public static void glSamplerParameterIuiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint const *") IntBuffer params) {
        GL33C.glSamplerParameterIuiv(sampler, pname, params);
    }

    public static void nglGetSamplerParameteriv(int sampler, int pname, long params) {
        GL33C.nglGetSamplerParameteriv(sampler, pname, params);
    }

    public static void glGetSamplerParameteriv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL33C.glGetSamplerParameteriv(sampler, pname, params);
    }

    @NativeType(value="void")
    public static int glGetSamplerParameteri(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname) {
        return GL33C.glGetSamplerParameteri(sampler, pname);
    }

    public static void nglGetSamplerParameterfv(int sampler, int pname, long params) {
        GL33C.nglGetSamplerParameterfv(sampler, pname, params);
    }

    public static void glGetSamplerParameterfv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        GL33C.glGetSamplerParameterfv(sampler, pname, params);
    }

    @NativeType(value="void")
    public static float glGetSamplerParameterf(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname) {
        return GL33C.glGetSamplerParameterf(sampler, pname);
    }

    public static void nglGetSamplerParameterIiv(int sampler, int pname, long params) {
        GL33C.nglGetSamplerParameterIiv(sampler, pname, params);
    }

    public static void glGetSamplerParameterIiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL33C.glGetSamplerParameterIiv(sampler, pname, params);
    }

    @NativeType(value="void")
    public static int glGetSamplerParameterIi(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname) {
        return GL33C.glGetSamplerParameterIi(sampler, pname);
    }

    public static void nglGetSamplerParameterIuiv(int sampler, int pname, long params) {
        GL33C.nglGetSamplerParameterIuiv(sampler, pname, params);
    }

    public static void glGetSamplerParameterIuiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") IntBuffer params) {
        GL33C.glGetSamplerParameterIuiv(sampler, pname, params);
    }

    @NativeType(value="void")
    public static int glGetSamplerParameterIui(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname) {
        return GL33C.glGetSamplerParameterIui(sampler, pname);
    }

    public static void glGenSamplers(@NativeType(value="GLuint *") int[] samplers) {
        GL33C.glGenSamplers(samplers);
    }

    public static void glDeleteSamplers(@NativeType(value="GLuint const *") int[] samplers) {
        GL33C.glDeleteSamplers(samplers);
    }

    public static void glSamplerParameteriv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        GL33C.glSamplerParameteriv(sampler, pname, params);
    }

    public static void glSamplerParameterfv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] params) {
        GL33C.glSamplerParameterfv(sampler, pname, params);
    }

    public static void glSamplerParameterIiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        GL33C.glSamplerParameterIiv(sampler, pname, params);
    }

    public static void glSamplerParameterIuiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint const *") int[] params) {
        GL33C.glSamplerParameterIuiv(sampler, pname, params);
    }

    public static void glGetSamplerParameteriv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL33C.glGetSamplerParameteriv(sampler, pname, params);
    }

    public static void glGetSamplerParameterfv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        GL33C.glGetSamplerParameterfv(sampler, pname, params);
    }

    public static void glGetSamplerParameterIiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL33C.glGetSamplerParameterIiv(sampler, pname, params);
    }

    public static void glGetSamplerParameterIuiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") int[] params) {
        GL33C.glGetSamplerParameterIuiv(sampler, pname, params);
    }

    static {
        GL.initialize();
    }
}

