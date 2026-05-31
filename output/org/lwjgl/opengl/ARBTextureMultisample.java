/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL32C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBTextureMultisample {
    public static final int GL_SAMPLE_POSITION = 36432;
    public static final int GL_SAMPLE_MASK = 36433;
    public static final int GL_SAMPLE_MASK_VALUE = 36434;
    public static final int GL_TEXTURE_2D_MULTISAMPLE = 37120;
    public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE = 37121;
    public static final int GL_TEXTURE_2D_MULTISAMPLE_ARRAY = 37122;
    public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE_ARRAY = 37123;
    public static final int GL_MAX_SAMPLE_MASK_WORDS = 36441;
    public static final int GL_MAX_COLOR_TEXTURE_SAMPLES = 37134;
    public static final int GL_MAX_DEPTH_TEXTURE_SAMPLES = 37135;
    public static final int GL_MAX_INTEGER_SAMPLES = 37136;
    public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE = 37124;
    public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE_ARRAY = 37125;
    public static final int GL_TEXTURE_SAMPLES = 37126;
    public static final int GL_TEXTURE_FIXED_SAMPLE_LOCATIONS = 37127;
    public static final int GL_SAMPLER_2D_MULTISAMPLE = 37128;
    public static final int GL_INT_SAMPLER_2D_MULTISAMPLE = 37129;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE = 37130;
    public static final int GL_SAMPLER_2D_MULTISAMPLE_ARRAY = 37131;
    public static final int GL_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37132;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37133;

    protected ARBTextureMultisample() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glTexImage2DMultisample, caps.glTexImage3DMultisample, caps.glGetMultisamplefv, caps.glSampleMaski);
    }

    public static void glTexImage2DMultisample(@NativeType(value="GLenum") int target, @NativeType(value="GLsizei") int samples, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLboolean") boolean fixedsamplelocations) {
        GL32C.glTexImage2DMultisample(target, samples, internalformat, width, height, fixedsamplelocations);
    }

    public static void glTexImage3DMultisample(@NativeType(value="GLenum") int target, @NativeType(value="GLsizei") int samples, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLboolean") boolean fixedsamplelocations) {
        GL32C.glTexImage3DMultisample(target, samples, internalformat, width, height, depth, fixedsamplelocations);
    }

    public static void nglGetMultisamplefv(int pname, int index, long val) {
        GL32C.nglGetMultisamplefv(pname, index, val);
    }

    public static void glGetMultisamplefv(@NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat *") FloatBuffer val) {
        GL32C.glGetMultisamplefv(pname, index, val);
    }

    @NativeType(value="void")
    public static float glGetMultisamplef(@NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index) {
        return GL32C.glGetMultisamplef(pname, index);
    }

    public static void glSampleMaski(@NativeType(value="GLuint") int index, @NativeType(value="GLbitfield") int mask) {
        GL32C.glSampleMaski(index, mask);
    }

    public static void glGetMultisamplefv(@NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat *") float[] val) {
        GL32C.glGetMultisamplefv(pname, index, val);
    }

    static {
        GL.initialize();
    }
}

