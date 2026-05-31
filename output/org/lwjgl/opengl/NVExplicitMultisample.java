/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVExplicitMultisample {
    public static final int GL_SAMPLE_POSITION_NV = 36432;
    public static final int GL_SAMPLE_MASK_NV = 36433;
    public static final int GL_SAMPLE_MASK_VALUE_NV = 36434;
    public static final int GL_TEXTURE_BINDING_RENDERBUFFER_NV = 36435;
    public static final int GL_TEXTURE_RENDERBUFFER_DATA_STORE_BINDING_NV = 36436;
    public static final int GL_MAX_SAMPLE_MASK_WORDS_NV = 36441;
    public static final int GL_TEXTURE_RENDERBUFFER_NV = 36437;
    public static final int GL_SAMPLER_RENDERBUFFER_NV = 36438;
    public static final int GL_INT_SAMPLER_RENDERBUFFER_NV = 36439;
    public static final int GL_UNSIGNED_INT_SAMPLER_RENDERBUFFER_NV = 36440;

    protected NVExplicitMultisample() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glGetMultisamplefvNV, caps.glSampleMaskIndexedNV, caps.glTexRenderbufferNV);
    }

    public static native void nglGetMultisamplefvNV(int var0, int var1, long var2);

    public static void glGetMultisamplefvNV(@NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat *") FloatBuffer val) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)val, 2);
        }
        NVExplicitMultisample.nglGetMultisamplefvNV(pname, index, MemoryUtil.memAddress(val));
    }

    public static native void glSampleMaskIndexedNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLbitfield") int var1);

    public static native void glTexRenderbufferNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static void glGetMultisamplefvNV(@NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat *") float[] val) {
        long __functionAddress = GL.getICD().glGetMultisamplefvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(val, 2);
        }
        JNI.callPV(pname, index, val, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

