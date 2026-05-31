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
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL12;
import org.lwjgl.opengl.GL13C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL13
extends GL12 {
    public static final int GL_COMPRESSED_ALPHA = 34025;
    public static final int GL_COMPRESSED_LUMINANCE = 34026;
    public static final int GL_COMPRESSED_LUMINANCE_ALPHA = 34027;
    public static final int GL_COMPRESSED_INTENSITY = 34028;
    public static final int GL_COMPRESSED_RGB = 34029;
    public static final int GL_COMPRESSED_RGBA = 34030;
    public static final int GL_TEXTURE_COMPRESSION_HINT = 34031;
    public static final int GL_TEXTURE_COMPRESSED_IMAGE_SIZE = 34464;
    public static final int GL_TEXTURE_COMPRESSED = 34465;
    public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS = 34466;
    public static final int GL_COMPRESSED_TEXTURE_FORMATS = 34467;
    public static final int GL_NORMAL_MAP = 34065;
    public static final int GL_REFLECTION_MAP = 34066;
    public static final int GL_TEXTURE_CUBE_MAP = 34067;
    public static final int GL_TEXTURE_BINDING_CUBE_MAP = 34068;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X = 34069;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X = 34070;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y = 34071;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y = 34072;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z = 34073;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z = 34074;
    public static final int GL_PROXY_TEXTURE_CUBE_MAP = 34075;
    public static final int GL_MAX_CUBE_MAP_TEXTURE_SIZE = 34076;
    public static final int GL_MULTISAMPLE = 32925;
    public static final int GL_SAMPLE_ALPHA_TO_COVERAGE = 32926;
    public static final int GL_SAMPLE_ALPHA_TO_ONE = 32927;
    public static final int GL_SAMPLE_COVERAGE = 32928;
    public static final int GL_MULTISAMPLE_BIT = 0x20000000;
    public static final int GL_SAMPLE_BUFFERS = 32936;
    public static final int GL_SAMPLES = 32937;
    public static final int GL_SAMPLE_COVERAGE_VALUE = 32938;
    public static final int GL_SAMPLE_COVERAGE_INVERT = 32939;
    public static final int GL_TEXTURE0 = 33984;
    public static final int GL_TEXTURE1 = 33985;
    public static final int GL_TEXTURE2 = 33986;
    public static final int GL_TEXTURE3 = 33987;
    public static final int GL_TEXTURE4 = 33988;
    public static final int GL_TEXTURE5 = 33989;
    public static final int GL_TEXTURE6 = 33990;
    public static final int GL_TEXTURE7 = 33991;
    public static final int GL_TEXTURE8 = 33992;
    public static final int GL_TEXTURE9 = 33993;
    public static final int GL_TEXTURE10 = 33994;
    public static final int GL_TEXTURE11 = 33995;
    public static final int GL_TEXTURE12 = 33996;
    public static final int GL_TEXTURE13 = 33997;
    public static final int GL_TEXTURE14 = 33998;
    public static final int GL_TEXTURE15 = 33999;
    public static final int GL_TEXTURE16 = 34000;
    public static final int GL_TEXTURE17 = 34001;
    public static final int GL_TEXTURE18 = 34002;
    public static final int GL_TEXTURE19 = 34003;
    public static final int GL_TEXTURE20 = 34004;
    public static final int GL_TEXTURE21 = 34005;
    public static final int GL_TEXTURE22 = 34006;
    public static final int GL_TEXTURE23 = 34007;
    public static final int GL_TEXTURE24 = 34008;
    public static final int GL_TEXTURE25 = 34009;
    public static final int GL_TEXTURE26 = 34010;
    public static final int GL_TEXTURE27 = 34011;
    public static final int GL_TEXTURE28 = 34012;
    public static final int GL_TEXTURE29 = 34013;
    public static final int GL_TEXTURE30 = 34014;
    public static final int GL_TEXTURE31 = 34015;
    public static final int GL_ACTIVE_TEXTURE = 34016;
    public static final int GL_CLIENT_ACTIVE_TEXTURE = 34017;
    public static final int GL_MAX_TEXTURE_UNITS = 34018;
    public static final int GL_COMBINE = 34160;
    public static final int GL_COMBINE_RGB = 34161;
    public static final int GL_COMBINE_ALPHA = 34162;
    public static final int GL_SOURCE0_RGB = 34176;
    public static final int GL_SOURCE1_RGB = 34177;
    public static final int GL_SOURCE2_RGB = 34178;
    public static final int GL_SOURCE0_ALPHA = 34184;
    public static final int GL_SOURCE1_ALPHA = 34185;
    public static final int GL_SOURCE2_ALPHA = 34186;
    public static final int GL_OPERAND0_RGB = 34192;
    public static final int GL_OPERAND1_RGB = 34193;
    public static final int GL_OPERAND2_RGB = 34194;
    public static final int GL_OPERAND0_ALPHA = 34200;
    public static final int GL_OPERAND1_ALPHA = 34201;
    public static final int GL_OPERAND2_ALPHA = 34202;
    public static final int GL_RGB_SCALE = 34163;
    public static final int GL_ADD_SIGNED = 34164;
    public static final int GL_INTERPOLATE = 34165;
    public static final int GL_SUBTRACT = 34023;
    public static final int GL_CONSTANT = 34166;
    public static final int GL_PRIMARY_COLOR = 34167;
    public static final int GL_PREVIOUS = 34168;
    public static final int GL_DOT3_RGB = 34478;
    public static final int GL_DOT3_RGBA = 34479;
    public static final int GL_CLAMP_TO_BORDER = 33069;
    public static final int GL_TRANSPOSE_MODELVIEW_MATRIX = 34019;
    public static final int GL_TRANSPOSE_PROJECTION_MATRIX = 34020;
    public static final int GL_TRANSPOSE_TEXTURE_MATRIX = 34021;
    public static final int GL_TRANSPOSE_COLOR_MATRIX = 34022;

    protected GL13() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, boolean fc) {
        return (fc || Checks.checkFunctions(caps.glClientActiveTexture, caps.glMultiTexCoord1f, caps.glMultiTexCoord1s, caps.glMultiTexCoord1i, caps.glMultiTexCoord1d, caps.glMultiTexCoord1fv, caps.glMultiTexCoord1sv, caps.glMultiTexCoord1iv, caps.glMultiTexCoord1dv, caps.glMultiTexCoord2f, caps.glMultiTexCoord2s, caps.glMultiTexCoord2i, caps.glMultiTexCoord2d, caps.glMultiTexCoord2fv, caps.glMultiTexCoord2sv, caps.glMultiTexCoord2iv, caps.glMultiTexCoord2dv, caps.glMultiTexCoord3f, caps.glMultiTexCoord3s, caps.glMultiTexCoord3i, caps.glMultiTexCoord3d, caps.glMultiTexCoord3fv, caps.glMultiTexCoord3sv, caps.glMultiTexCoord3iv, caps.glMultiTexCoord3dv, caps.glMultiTexCoord4f, caps.glMultiTexCoord4s, caps.glMultiTexCoord4i, caps.glMultiTexCoord4d, caps.glMultiTexCoord4fv, caps.glMultiTexCoord4sv, caps.glMultiTexCoord4iv, caps.glMultiTexCoord4dv, caps.glLoadTransposeMatrixf, caps.glLoadTransposeMatrixd, caps.glMultTransposeMatrixf, caps.glMultTransposeMatrixd)) && Checks.checkFunctions(caps.glCompressedTexImage3D, caps.glCompressedTexImage2D, caps.glCompressedTexImage1D, caps.glCompressedTexSubImage3D, caps.glCompressedTexSubImage2D, caps.glCompressedTexSubImage1D, caps.glGetCompressedTexImage, caps.glSampleCoverage, caps.glActiveTexture);
    }

    public static void nglCompressedTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, long data) {
        GL13C.nglCompressedTexImage3D(target, level, internalformat, width, height, depth, border, imageSize, data);
    }

    public static void glCompressedTexImage3D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLsizei") int imageSize, @Nullable @NativeType(value="void const *") long data) {
        GL13C.glCompressedTexImage3D(target, level, internalformat, width, height, depth, border, imageSize, data);
    }

    public static void glCompressedTexImage3D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @Nullable @NativeType(value="void const *") ByteBuffer data) {
        GL13C.glCompressedTexImage3D(target, level, internalformat, width, height, depth, border, data);
    }

    public static void nglCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize, long data) {
        GL13C.nglCompressedTexImage2D(target, level, internalformat, width, height, border, imageSize, data);
    }

    public static void glCompressedTexImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLsizei") int imageSize, @Nullable @NativeType(value="void const *") long data) {
        GL13C.glCompressedTexImage2D(target, level, internalformat, width, height, border, imageSize, data);
    }

    public static void glCompressedTexImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @Nullable @NativeType(value="void const *") ByteBuffer data) {
        GL13C.glCompressedTexImage2D(target, level, internalformat, width, height, border, data);
    }

    public static void nglCompressedTexImage1D(int target, int level, int internalformat, int width, int border, int imageSize, long data) {
        GL13C.nglCompressedTexImage1D(target, level, internalformat, width, border, imageSize, data);
    }

    public static void glCompressedTexImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLsizei") int imageSize, @Nullable @NativeType(value="void const *") long data) {
        GL13C.glCompressedTexImage1D(target, level, internalformat, width, border, imageSize, data);
    }

    public static void glCompressedTexImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @Nullable @NativeType(value="void const *") ByteBuffer data) {
        GL13C.glCompressedTexImage1D(target, level, internalformat, width, border, data);
    }

    public static void nglCompressedTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, long data) {
        GL13C.nglCompressedTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
    }

    public static void glCompressedTexSubImage3D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int imageSize, @NativeType(value="void const *") long data) {
        GL13C.glCompressedTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
    }

    public static void glCompressedTexSubImage3D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="void const *") ByteBuffer data) {
        GL13C.glCompressedTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, data);
    }

    public static void nglCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, long data) {
        GL13C.nglCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, imageSize, data);
    }

    public static void glCompressedTexSubImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int imageSize, @NativeType(value="void const *") long data) {
        GL13C.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, imageSize, data);
    }

    public static void glCompressedTexSubImage2D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="void const *") ByteBuffer data) {
        GL13C.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, data);
    }

    public static void nglCompressedTexSubImage1D(int target, int level, int xoffset, int width, int format, int imageSize, long data) {
        GL13C.nglCompressedTexSubImage1D(target, level, xoffset, width, format, imageSize, data);
    }

    public static void glCompressedTexSubImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int imageSize, @NativeType(value="void const *") long data) {
        GL13C.glCompressedTexSubImage1D(target, level, xoffset, width, format, imageSize, data);
    }

    public static void glCompressedTexSubImage1D(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="void const *") ByteBuffer data) {
        GL13C.glCompressedTexSubImage1D(target, level, xoffset, width, format, data);
    }

    public static void nglGetCompressedTexImage(int target, int level, long pixels) {
        GL13C.nglGetCompressedTexImage(target, level, pixels);
    }

    public static void glGetCompressedTexImage(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="void *") ByteBuffer pixels) {
        GL13C.glGetCompressedTexImage(target, level, pixels);
    }

    public static void glGetCompressedTexImage(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="void *") long pixels) {
        GL13C.glGetCompressedTexImage(target, level, pixels);
    }

    public static void glSampleCoverage(@NativeType(value="GLfloat") float value, @NativeType(value="GLboolean") boolean invert) {
        GL13C.glSampleCoverage(value, invert);
    }

    public static void glActiveTexture(@NativeType(value="GLenum") int texture) {
        GL13C.glActiveTexture(texture);
    }

    public static native void glClientActiveTexture(@NativeType(value="GLenum") int var0);

    public static native void glMultiTexCoord1f(@NativeType(value="GLenum") int var0, @NativeType(value="GLfloat") float var1);

    public static native void glMultiTexCoord1s(@NativeType(value="GLenum") int var0, @NativeType(value="GLshort") short var1);

    public static native void glMultiTexCoord1i(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1);

    public static native void glMultiTexCoord1d(@NativeType(value="GLenum") int var0, @NativeType(value="GLdouble") double var1);

    public static native void nglMultiTexCoord1fv(int var0, long var1);

    public static void glMultiTexCoord1fv(@NativeType(value="GLenum") int texture, @NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        GL13.nglMultiTexCoord1fv(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord1sv(int var0, long var1);

    public static void glMultiTexCoord1sv(@NativeType(value="GLenum") int texture, @NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        GL13.nglMultiTexCoord1sv(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord1iv(int var0, long var1);

    public static void glMultiTexCoord1iv(@NativeType(value="GLenum") int texture, @NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        GL13.nglMultiTexCoord1iv(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord1dv(int var0, long var1);

    public static void glMultiTexCoord1dv(@NativeType(value="GLenum") int texture, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        GL13.nglMultiTexCoord1dv(texture, MemoryUtil.memAddress(v));
    }

    public static native void glMultiTexCoord2f(@NativeType(value="GLenum") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    public static native void glMultiTexCoord2s(@NativeType(value="GLenum") int var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2);

    public static native void glMultiTexCoord2i(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void glMultiTexCoord2d(@NativeType(value="GLenum") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3);

    public static native void nglMultiTexCoord2fv(int var0, long var1);

    public static void glMultiTexCoord2fv(@NativeType(value="GLenum") int texture, @NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        GL13.nglMultiTexCoord2fv(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord2sv(int var0, long var1);

    public static void glMultiTexCoord2sv(@NativeType(value="GLenum") int texture, @NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        GL13.nglMultiTexCoord2sv(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord2iv(int var0, long var1);

    public static void glMultiTexCoord2iv(@NativeType(value="GLenum") int texture, @NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        GL13.nglMultiTexCoord2iv(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord2dv(int var0, long var1);

    public static void glMultiTexCoord2dv(@NativeType(value="GLenum") int texture, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        GL13.nglMultiTexCoord2dv(texture, MemoryUtil.memAddress(v));
    }

    public static native void glMultiTexCoord3f(@NativeType(value="GLenum") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    public static native void glMultiTexCoord3s(@NativeType(value="GLenum") int var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2, @NativeType(value="GLshort") short var3);

    public static native void glMultiTexCoord3i(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3);

    public static native void glMultiTexCoord3d(@NativeType(value="GLenum") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5);

    public static native void nglMultiTexCoord3fv(int var0, long var1);

    public static void glMultiTexCoord3fv(@NativeType(value="GLenum") int texture, @NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL13.nglMultiTexCoord3fv(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord3sv(int var0, long var1);

    public static void glMultiTexCoord3sv(@NativeType(value="GLenum") int texture, @NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL13.nglMultiTexCoord3sv(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord3iv(int var0, long var1);

    public static void glMultiTexCoord3iv(@NativeType(value="GLenum") int texture, @NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL13.nglMultiTexCoord3iv(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord3dv(int var0, long var1);

    public static void glMultiTexCoord3dv(@NativeType(value="GLenum") int texture, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL13.nglMultiTexCoord3dv(texture, MemoryUtil.memAddress(v));
    }

    public static native void glMultiTexCoord4f(@NativeType(value="GLenum") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLfloat") float var4);

    public static native void glMultiTexCoord4s(@NativeType(value="GLenum") int var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2, @NativeType(value="GLshort") short var3, @NativeType(value="GLshort") short var4);

    public static native void glMultiTexCoord4i(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4);

    public static native void glMultiTexCoord4d(@NativeType(value="GLenum") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5, @NativeType(value="GLdouble") double var7);

    public static native void nglMultiTexCoord4fv(int var0, long var1);

    public static void glMultiTexCoord4fv(@NativeType(value="GLenum") int texture, @NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL13.nglMultiTexCoord4fv(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord4sv(int var0, long var1);

    public static void glMultiTexCoord4sv(@NativeType(value="GLenum") int texture, @NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL13.nglMultiTexCoord4sv(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord4iv(int var0, long var1);

    public static void glMultiTexCoord4iv(@NativeType(value="GLenum") int texture, @NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL13.nglMultiTexCoord4iv(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord4dv(int var0, long var1);

    public static void glMultiTexCoord4dv(@NativeType(value="GLenum") int texture, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL13.nglMultiTexCoord4dv(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglLoadTransposeMatrixf(long var0);

    public static void glLoadTransposeMatrixf(@NativeType(value="GLfloat const *") FloatBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 16);
        }
        GL13.nglLoadTransposeMatrixf(MemoryUtil.memAddress(m));
    }

    public static native void nglLoadTransposeMatrixd(long var0);

    public static void glLoadTransposeMatrixd(@NativeType(value="GLdouble const *") DoubleBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 16);
        }
        GL13.nglLoadTransposeMatrixd(MemoryUtil.memAddress(m));
    }

    public static native void nglMultTransposeMatrixf(long var0);

    public static void glMultTransposeMatrixf(@NativeType(value="GLfloat const *") FloatBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 16);
        }
        GL13.nglMultTransposeMatrixf(MemoryUtil.memAddress(m));
    }

    public static native void nglMultTransposeMatrixd(long var0);

    public static void glMultTransposeMatrixd(@NativeType(value="GLdouble const *") DoubleBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 16);
        }
        GL13.nglMultTransposeMatrixd(MemoryUtil.memAddress(m));
    }

    public static void glMultiTexCoord1fv(@NativeType(value="GLenum") int texture, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord1fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord1sv(@NativeType(value="GLenum") int texture, @NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord1sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord1iv(@NativeType(value="GLenum") int texture, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord1iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord1dv(@NativeType(value="GLenum") int texture, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord1dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord2fv(@NativeType(value="GLenum") int texture, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord2fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord2sv(@NativeType(value="GLenum") int texture, @NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord2sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord2iv(@NativeType(value="GLenum") int texture, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord2iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord2dv(@NativeType(value="GLenum") int texture, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord2dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord3fv(@NativeType(value="GLenum") int texture, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord3fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord3sv(@NativeType(value="GLenum") int texture, @NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord3sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord3iv(@NativeType(value="GLenum") int texture, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord3iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord3dv(@NativeType(value="GLenum") int texture, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord3dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord4fv(@NativeType(value="GLenum") int texture, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord4fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord4sv(@NativeType(value="GLenum") int texture, @NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord4sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord4iv(@NativeType(value="GLenum") int texture, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord4iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord4dv(@NativeType(value="GLenum") int texture, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord4dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glLoadTransposeMatrixf(@NativeType(value="GLfloat const *") float[] m) {
        long __functionAddress = GL.getICD().glLoadTransposeMatrixf;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 16);
        }
        JNI.callPV(m, __functionAddress);
    }

    public static void glLoadTransposeMatrixd(@NativeType(value="GLdouble const *") double[] m) {
        long __functionAddress = GL.getICD().glLoadTransposeMatrixd;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 16);
        }
        JNI.callPV(m, __functionAddress);
    }

    public static void glMultTransposeMatrixf(@NativeType(value="GLfloat const *") float[] m) {
        long __functionAddress = GL.getICD().glMultTransposeMatrixf;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 16);
        }
        JNI.callPV(m, __functionAddress);
    }

    public static void glMultTransposeMatrixd(@NativeType(value="GLdouble const *") double[] m) {
        long __functionAddress = GL.getICD().glMultTransposeMatrixd;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 16);
        }
        JNI.callPV(m, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

