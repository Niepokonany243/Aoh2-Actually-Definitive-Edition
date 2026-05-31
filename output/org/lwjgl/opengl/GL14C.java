/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL13C;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL14C
extends GL13C {
    public static final int GL_CONSTANT_COLOR = 32769;
    public static final int GL_ONE_MINUS_CONSTANT_COLOR = 32770;
    public static final int GL_CONSTANT_ALPHA = 32771;
    public static final int GL_ONE_MINUS_CONSTANT_ALPHA = 32772;
    public static final int GL_FUNC_ADD = 32774;
    public static final int GL_MIN = 32775;
    public static final int GL_MAX = 32776;
    public static final int GL_FUNC_SUBTRACT = 32778;
    public static final int GL_FUNC_REVERSE_SUBTRACT = 32779;
    public static final int GL_DEPTH_COMPONENT16 = 33189;
    public static final int GL_DEPTH_COMPONENT24 = 33190;
    public static final int GL_DEPTH_COMPONENT32 = 33191;
    public static final int GL_TEXTURE_DEPTH_SIZE = 34890;
    public static final int GL_TEXTURE_COMPARE_MODE = 34892;
    public static final int GL_TEXTURE_COMPARE_FUNC = 34893;
    public static final int GL_POINT_FADE_THRESHOLD_SIZE = 33064;
    public static final int GL_BLEND_DST_RGB = 32968;
    public static final int GL_BLEND_SRC_RGB = 32969;
    public static final int GL_BLEND_DST_ALPHA = 32970;
    public static final int GL_BLEND_SRC_ALPHA = 32971;
    public static final int GL_INCR_WRAP = 34055;
    public static final int GL_DECR_WRAP = 34056;
    public static final int GL_TEXTURE_LOD_BIAS = 34049;
    public static final int GL_MAX_TEXTURE_LOD_BIAS = 34045;
    public static final int GL_MIRRORED_REPEAT = 33648;

    protected GL14C() {
        throw new UnsupportedOperationException();
    }

    public static native void glBlendColor(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    public static native void glBlendEquation(@NativeType(value="GLenum") int var0);

    public static native void nglMultiDrawArrays(int var0, long var1, long var3, int var5);

    public static void glMultiDrawArrays(@NativeType(value="GLenum") int mode, @NativeType(value="GLint const *") IntBuffer first, @NativeType(value="GLsizei const *") IntBuffer count) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)count, first.remaining());
        }
        GL14C.nglMultiDrawArrays(mode, MemoryUtil.memAddress(first), MemoryUtil.memAddress(count), first.remaining());
    }

    public static native void nglMultiDrawElements(int var0, long var1, int var3, long var4, int var6);

    public static void glMultiDrawElements(@NativeType(value="GLenum") int mode, @NativeType(value="GLsizei *") IntBuffer count, @NativeType(value="GLenum") int type, @NativeType(value="void const **") PointerBuffer indices) {
        if (Checks.CHECKS) {
            Checks.check(indices, count.remaining());
        }
        GL14C.nglMultiDrawElements(mode, MemoryUtil.memAddress(count), type, MemoryUtil.memAddress(indices), count.remaining());
    }

    public static native void glPointParameterf(@NativeType(value="GLenum") int var0, @NativeType(value="GLfloat") float var1);

    public static native void glPointParameteri(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1);

    public static native void nglPointParameterfv(int var0, long var1);

    public static void glPointParameterfv(@NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 3);
        }
        GL14C.nglPointParameterfv(pname, MemoryUtil.memAddress(params));
    }

    public static native void nglPointParameteriv(int var0, long var1);

    public static void glPointParameteriv(@NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 3);
        }
        GL14C.nglPointParameteriv(pname, MemoryUtil.memAddress(params));
    }

    public static native void glBlendFuncSeparate(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLenum") int var3);

    public static void glMultiDrawArrays(@NativeType(value="GLenum") int mode, @NativeType(value="GLint const *") int[] first, @NativeType(value="GLsizei const *") int[] count) {
        long __functionAddress = GL.getICD().glMultiDrawArrays;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(count, first.length);
        }
        JNI.callPPV(mode, first, count, first.length, __functionAddress);
    }

    public static void glMultiDrawElements(@NativeType(value="GLenum") int mode, @NativeType(value="GLsizei *") int[] count, @NativeType(value="GLenum") int type, @NativeType(value="void const **") PointerBuffer indices) {
        long __functionAddress = GL.getICD().glMultiDrawElements;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(indices, count.length);
        }
        JNI.callPPV(mode, count, type, MemoryUtil.memAddress(indices), count.length, __functionAddress);
    }

    public static void glPointParameterfv(@NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] params) {
        long __functionAddress = GL.getICD().glPointParameterfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 3);
        }
        JNI.callPV(pname, params, __functionAddress);
    }

    public static void glPointParameteriv(@NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = GL.getICD().glPointParameteriv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 3);
        }
        JNI.callPV(pname, params, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

