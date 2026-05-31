/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL14
extends GL13 {
    public static final int GL_GENERATE_MIPMAP = 33169;
    public static final int GL_GENERATE_MIPMAP_HINT = 33170;
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
    public static final int GL_DEPTH_TEXTURE_MODE = 34891;
    public static final int GL_TEXTURE_COMPARE_MODE = 34892;
    public static final int GL_TEXTURE_COMPARE_FUNC = 34893;
    public static final int GL_COMPARE_R_TO_TEXTURE = 34894;
    public static final int GL_FOG_COORDINATE_SOURCE = 33872;
    public static final int GL_FOG_COORDINATE = 33873;
    public static final int GL_FRAGMENT_DEPTH = 33874;
    public static final int GL_CURRENT_FOG_COORDINATE = 33875;
    public static final int GL_FOG_COORDINATE_ARRAY_TYPE = 33876;
    public static final int GL_FOG_COORDINATE_ARRAY_STRIDE = 33877;
    public static final int GL_FOG_COORDINATE_ARRAY_POINTER = 33878;
    public static final int GL_FOG_COORDINATE_ARRAY = 33879;
    public static final int GL_POINT_SIZE_MIN = 33062;
    public static final int GL_POINT_SIZE_MAX = 33063;
    public static final int GL_POINT_FADE_THRESHOLD_SIZE = 33064;
    public static final int GL_POINT_DISTANCE_ATTENUATION = 33065;
    public static final int GL_COLOR_SUM = 33880;
    public static final int GL_CURRENT_SECONDARY_COLOR = 33881;
    public static final int GL_SECONDARY_COLOR_ARRAY_SIZE = 33882;
    public static final int GL_SECONDARY_COLOR_ARRAY_TYPE = 33883;
    public static final int GL_SECONDARY_COLOR_ARRAY_STRIDE = 33884;
    public static final int GL_SECONDARY_COLOR_ARRAY_POINTER = 33885;
    public static final int GL_SECONDARY_COLOR_ARRAY = 33886;
    public static final int GL_BLEND_DST_RGB = 32968;
    public static final int GL_BLEND_SRC_RGB = 32969;
    public static final int GL_BLEND_DST_ALPHA = 32970;
    public static final int GL_BLEND_SRC_ALPHA = 32971;
    public static final int GL_INCR_WRAP = 34055;
    public static final int GL_DECR_WRAP = 34056;
    public static final int GL_TEXTURE_FILTER_CONTROL = 34048;
    public static final int GL_TEXTURE_LOD_BIAS = 34049;
    public static final int GL_MAX_TEXTURE_LOD_BIAS = 34045;
    public static final int GL_MIRRORED_REPEAT = 33648;

    protected GL14() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, boolean fc) {
        return (fc || Checks.checkFunctions(caps.glFogCoordf, caps.glFogCoordd, caps.glFogCoordfv, caps.glFogCoorddv, caps.glFogCoordPointer, caps.glSecondaryColor3b, caps.glSecondaryColor3s, caps.glSecondaryColor3i, caps.glSecondaryColor3f, caps.glSecondaryColor3d, caps.glSecondaryColor3ub, caps.glSecondaryColor3us, caps.glSecondaryColor3ui, caps.glSecondaryColor3bv, caps.glSecondaryColor3sv, caps.glSecondaryColor3iv, caps.glSecondaryColor3fv, caps.glSecondaryColor3dv, caps.glSecondaryColor3ubv, caps.glSecondaryColor3usv, caps.glSecondaryColor3uiv, caps.glSecondaryColorPointer, caps.glWindowPos2i, caps.glWindowPos2s, caps.glWindowPos2f, caps.glWindowPos2d, caps.glWindowPos2iv, caps.glWindowPos2sv, caps.glWindowPos2fv, caps.glWindowPos2dv, caps.glWindowPos3i, caps.glWindowPos3s, caps.glWindowPos3f, caps.glWindowPos3d, caps.glWindowPos3iv, caps.glWindowPos3sv, caps.glWindowPos3fv, caps.glWindowPos3dv)) && Checks.checkFunctions(caps.glBlendColor, caps.glBlendEquation, caps.glMultiDrawArrays, caps.glMultiDrawElements, caps.glPointParameterf, caps.glPointParameteri, caps.glPointParameterfv, caps.glPointParameteriv, caps.glBlendFuncSeparate);
    }

    public static void glBlendColor(@NativeType(value="GLfloat") float red, @NativeType(value="GLfloat") float green, @NativeType(value="GLfloat") float blue, @NativeType(value="GLfloat") float alpha) {
        GL14C.glBlendColor(red, green, blue, alpha);
    }

    public static void glBlendEquation(@NativeType(value="GLenum") int mode) {
        GL14C.glBlendEquation(mode);
    }

    public static native void glFogCoordf(@NativeType(value="GLfloat") float var0);

    public static native void glFogCoordd(@NativeType(value="GLdouble") double var0);

    public static native void nglFogCoordfv(long var0);

    public static void glFogCoordfv(@NativeType(value="GLfloat const *") FloatBuffer coord) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coord, 1);
        }
        GL14.nglFogCoordfv(MemoryUtil.memAddress(coord));
    }

    public static native void nglFogCoorddv(long var0);

    public static void glFogCoorddv(@NativeType(value="GLdouble const *") DoubleBuffer coord) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coord, 1);
        }
        GL14.nglFogCoorddv(MemoryUtil.memAddress(coord));
    }

    public static native void nglFogCoordPointer(int var0, int var1, long var2);

    public static void glFogCoordPointer(@NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ByteBuffer pointer) {
        GL14.nglFogCoordPointer(type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glFogCoordPointer(@NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") long pointer) {
        GL14.nglFogCoordPointer(type, stride, pointer);
    }

    public static void glFogCoordPointer(@NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ShortBuffer pointer) {
        GL14.nglFogCoordPointer(type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glFogCoordPointer(@NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") FloatBuffer pointer) {
        GL14.nglFogCoordPointer(type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void nglMultiDrawArrays(int mode, long first, long count, int drawcount) {
        GL14C.nglMultiDrawArrays(mode, first, count, drawcount);
    }

    public static void glMultiDrawArrays(@NativeType(value="GLenum") int mode, @NativeType(value="GLint const *") IntBuffer first, @NativeType(value="GLsizei const *") IntBuffer count) {
        GL14C.glMultiDrawArrays(mode, first, count);
    }

    public static void nglMultiDrawElements(int mode, long count, int type, long indices, int drawcount) {
        GL14C.nglMultiDrawElements(mode, count, type, indices, drawcount);
    }

    public static void glMultiDrawElements(@NativeType(value="GLenum") int mode, @NativeType(value="GLsizei *") IntBuffer count, @NativeType(value="GLenum") int type, @NativeType(value="void const **") PointerBuffer indices) {
        GL14C.glMultiDrawElements(mode, count, type, indices);
    }

    public static void glPointParameterf(@NativeType(value="GLenum") int pname, @NativeType(value="GLfloat") float param) {
        GL14C.glPointParameterf(pname, param);
    }

    public static void glPointParameteri(@NativeType(value="GLenum") int pname, @NativeType(value="GLint") int param) {
        GL14C.glPointParameteri(pname, param);
    }

    public static void nglPointParameterfv(int pname, long params) {
        GL14C.nglPointParameterfv(pname, params);
    }

    public static void glPointParameterfv(@NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer params) {
        GL14C.glPointParameterfv(pname, params);
    }

    public static void nglPointParameteriv(int pname, long params) {
        GL14C.nglPointParameteriv(pname, params);
    }

    public static void glPointParameteriv(@NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        GL14C.glPointParameteriv(pname, params);
    }

    public static native void glSecondaryColor3b(@NativeType(value="GLbyte") byte var0, @NativeType(value="GLbyte") byte var1, @NativeType(value="GLbyte") byte var2);

    public static native void glSecondaryColor3s(@NativeType(value="GLshort") short var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2);

    public static native void glSecondaryColor3i(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void glSecondaryColor3f(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    public static native void glSecondaryColor3d(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4);

    public static native void glSecondaryColor3ub(@NativeType(value="GLubyte") byte var0, @NativeType(value="GLubyte") byte var1, @NativeType(value="GLubyte") byte var2);

    public static native void glSecondaryColor3us(@NativeType(value="GLushort") short var0, @NativeType(value="GLushort") short var1, @NativeType(value="GLushort") short var2);

    public static native void glSecondaryColor3ui(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void nglSecondaryColor3bv(long var0);

    public static void glSecondaryColor3bv(@NativeType(value="GLbyte const *") ByteBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL14.nglSecondaryColor3bv(MemoryUtil.memAddress(v));
    }

    public static native void nglSecondaryColor3sv(long var0);

    public static void glSecondaryColor3sv(@NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL14.nglSecondaryColor3sv(MemoryUtil.memAddress(v));
    }

    public static native void nglSecondaryColor3iv(long var0);

    public static void glSecondaryColor3iv(@NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL14.nglSecondaryColor3iv(MemoryUtil.memAddress(v));
    }

    public static native void nglSecondaryColor3fv(long var0);

    public static void glSecondaryColor3fv(@NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL14.nglSecondaryColor3fv(MemoryUtil.memAddress(v));
    }

    public static native void nglSecondaryColor3dv(long var0);

    public static void glSecondaryColor3dv(@NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL14.nglSecondaryColor3dv(MemoryUtil.memAddress(v));
    }

    public static native void nglSecondaryColor3ubv(long var0);

    public static void glSecondaryColor3ubv(@NativeType(value="GLubyte const *") ByteBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL14.nglSecondaryColor3ubv(MemoryUtil.memAddress(v));
    }

    public static native void nglSecondaryColor3usv(long var0);

    public static void glSecondaryColor3usv(@NativeType(value="GLushort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL14.nglSecondaryColor3usv(MemoryUtil.memAddress(v));
    }

    public static native void nglSecondaryColor3uiv(long var0);

    public static void glSecondaryColor3uiv(@NativeType(value="GLuint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL14.nglSecondaryColor3uiv(MemoryUtil.memAddress(v));
    }

    public static native void nglSecondaryColorPointer(int var0, int var1, int var2, long var3);

    public static void glSecondaryColorPointer(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ByteBuffer pointer) {
        GL14.nglSecondaryColorPointer(size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glSecondaryColorPointer(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") long pointer) {
        GL14.nglSecondaryColorPointer(size, type, stride, pointer);
    }

    public static void glSecondaryColorPointer(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ShortBuffer pointer) {
        GL14.nglSecondaryColorPointer(size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glSecondaryColorPointer(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") IntBuffer pointer) {
        GL14.nglSecondaryColorPointer(size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glSecondaryColorPointer(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") FloatBuffer pointer) {
        GL14.nglSecondaryColorPointer(size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glBlendFuncSeparate(@NativeType(value="GLenum") int sfactorRGB, @NativeType(value="GLenum") int dfactorRGB, @NativeType(value="GLenum") int sfactorAlpha, @NativeType(value="GLenum") int dfactorAlpha) {
        GL14C.glBlendFuncSeparate(sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha);
    }

    public static native void glWindowPos2i(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1);

    public static native void glWindowPos2s(@NativeType(value="GLshort") short var0, @NativeType(value="GLshort") short var1);

    public static native void glWindowPos2f(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1);

    public static native void glWindowPos2d(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2);

    public static native void nglWindowPos2iv(long var0);

    public static void glWindowPos2iv(@NativeType(value="GLint const *") IntBuffer p) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)p, 2);
        }
        GL14.nglWindowPos2iv(MemoryUtil.memAddress(p));
    }

    public static native void nglWindowPos2sv(long var0);

    public static void glWindowPos2sv(@NativeType(value="GLshort const *") ShortBuffer p) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)p, 2);
        }
        GL14.nglWindowPos2sv(MemoryUtil.memAddress(p));
    }

    public static native void nglWindowPos2fv(long var0);

    public static void glWindowPos2fv(@NativeType(value="GLfloat const *") FloatBuffer p) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)p, 2);
        }
        GL14.nglWindowPos2fv(MemoryUtil.memAddress(p));
    }

    public static native void nglWindowPos2dv(long var0);

    public static void glWindowPos2dv(@NativeType(value="GLdouble const *") DoubleBuffer p) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)p, 2);
        }
        GL14.nglWindowPos2dv(MemoryUtil.memAddress(p));
    }

    public static native void glWindowPos3i(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void glWindowPos3s(@NativeType(value="GLshort") short var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2);

    public static native void glWindowPos3f(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    public static native void glWindowPos3d(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4);

    public static native void nglWindowPos3iv(long var0);

    public static void glWindowPos3iv(@NativeType(value="GLint const *") IntBuffer p) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)p, 3);
        }
        GL14.nglWindowPos3iv(MemoryUtil.memAddress(p));
    }

    public static native void nglWindowPos3sv(long var0);

    public static void glWindowPos3sv(@NativeType(value="GLshort const *") ShortBuffer p) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)p, 3);
        }
        GL14.nglWindowPos3sv(MemoryUtil.memAddress(p));
    }

    public static native void nglWindowPos3fv(long var0);

    public static void glWindowPos3fv(@NativeType(value="GLfloat const *") FloatBuffer p) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)p, 3);
        }
        GL14.nglWindowPos3fv(MemoryUtil.memAddress(p));
    }

    public static native void nglWindowPos3dv(long var0);

    public static void glWindowPos3dv(@NativeType(value="GLdouble const *") DoubleBuffer p) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)p, 3);
        }
        GL14.nglWindowPos3dv(MemoryUtil.memAddress(p));
    }

    public static void glFogCoordfv(@NativeType(value="GLfloat const *") float[] coord) {
        long __functionAddress = GL.getICD().glFogCoordfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coord, 1);
        }
        JNI.callPV(coord, __functionAddress);
    }

    public static void glFogCoorddv(@NativeType(value="GLdouble const *") double[] coord) {
        long __functionAddress = GL.getICD().glFogCoorddv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coord, 1);
        }
        JNI.callPV(coord, __functionAddress);
    }

    public static void glMultiDrawArrays(@NativeType(value="GLenum") int mode, @NativeType(value="GLint const *") int[] first, @NativeType(value="GLsizei const *") int[] count) {
        GL14C.glMultiDrawArrays(mode, first, count);
    }

    public static void glMultiDrawElements(@NativeType(value="GLenum") int mode, @NativeType(value="GLsizei *") int[] count, @NativeType(value="GLenum") int type, @NativeType(value="void const **") PointerBuffer indices) {
        GL14C.glMultiDrawElements(mode, count, type, indices);
    }

    public static void glPointParameterfv(@NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] params) {
        GL14C.glPointParameterfv(pname, params);
    }

    public static void glPointParameteriv(@NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        GL14C.glPointParameteriv(pname, params);
    }

    public static void glSecondaryColor3sv(@NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glSecondaryColor3sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glSecondaryColor3iv(@NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glSecondaryColor3iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glSecondaryColor3fv(@NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glSecondaryColor3fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glSecondaryColor3dv(@NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glSecondaryColor3dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glSecondaryColor3usv(@NativeType(value="GLushort const *") short[] v) {
        long __functionAddress = GL.getICD().glSecondaryColor3usv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glSecondaryColor3uiv(@NativeType(value="GLuint const *") int[] v) {
        long __functionAddress = GL.getICD().glSecondaryColor3uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glWindowPos2iv(@NativeType(value="GLint const *") int[] p) {
        long __functionAddress = GL.getICD().glWindowPos2iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(p, 2);
        }
        JNI.callPV(p, __functionAddress);
    }

    public static void glWindowPos2sv(@NativeType(value="GLshort const *") short[] p) {
        long __functionAddress = GL.getICD().glWindowPos2sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(p, 2);
        }
        JNI.callPV(p, __functionAddress);
    }

    public static void glWindowPos2fv(@NativeType(value="GLfloat const *") float[] p) {
        long __functionAddress = GL.getICD().glWindowPos2fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(p, 2);
        }
        JNI.callPV(p, __functionAddress);
    }

    public static void glWindowPos2dv(@NativeType(value="GLdouble const *") double[] p) {
        long __functionAddress = GL.getICD().glWindowPos2dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(p, 2);
        }
        JNI.callPV(p, __functionAddress);
    }

    public static void glWindowPos3iv(@NativeType(value="GLint const *") int[] p) {
        long __functionAddress = GL.getICD().glWindowPos3iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(p, 3);
        }
        JNI.callPV(p, __functionAddress);
    }

    public static void glWindowPos3sv(@NativeType(value="GLshort const *") short[] p) {
        long __functionAddress = GL.getICD().glWindowPos3sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(p, 3);
        }
        JNI.callPV(p, __functionAddress);
    }

    public static void glWindowPos3fv(@NativeType(value="GLfloat const *") float[] p) {
        long __functionAddress = GL.getICD().glWindowPos3fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(p, 3);
        }
        JNI.callPV(p, __functionAddress);
    }

    public static void glWindowPos3dv(@NativeType(value="GLdouble const *") double[] p) {
        long __functionAddress = GL.getICD().glWindowPos3dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(p, 3);
        }
        JNI.callPV(p, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

