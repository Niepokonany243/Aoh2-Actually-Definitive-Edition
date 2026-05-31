/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBMultitexture {
    public static final int GL_TEXTURE0_ARB = 33984;
    public static final int GL_TEXTURE1_ARB = 33985;
    public static final int GL_TEXTURE2_ARB = 33986;
    public static final int GL_TEXTURE3_ARB = 33987;
    public static final int GL_TEXTURE4_ARB = 33988;
    public static final int GL_TEXTURE5_ARB = 33989;
    public static final int GL_TEXTURE6_ARB = 33990;
    public static final int GL_TEXTURE7_ARB = 33991;
    public static final int GL_TEXTURE8_ARB = 33992;
    public static final int GL_TEXTURE9_ARB = 33993;
    public static final int GL_TEXTURE10_ARB = 33994;
    public static final int GL_TEXTURE11_ARB = 33995;
    public static final int GL_TEXTURE12_ARB = 33996;
    public static final int GL_TEXTURE13_ARB = 33997;
    public static final int GL_TEXTURE14_ARB = 33998;
    public static final int GL_TEXTURE15_ARB = 33999;
    public static final int GL_TEXTURE16_ARB = 34000;
    public static final int GL_TEXTURE17_ARB = 34001;
    public static final int GL_TEXTURE18_ARB = 34002;
    public static final int GL_TEXTURE19_ARB = 34003;
    public static final int GL_TEXTURE20_ARB = 34004;
    public static final int GL_TEXTURE21_ARB = 34005;
    public static final int GL_TEXTURE22_ARB = 34006;
    public static final int GL_TEXTURE23_ARB = 34007;
    public static final int GL_TEXTURE24_ARB = 34008;
    public static final int GL_TEXTURE25_ARB = 34009;
    public static final int GL_TEXTURE26_ARB = 34010;
    public static final int GL_TEXTURE27_ARB = 34011;
    public static final int GL_TEXTURE28_ARB = 34012;
    public static final int GL_TEXTURE29_ARB = 34013;
    public static final int GL_TEXTURE30_ARB = 34014;
    public static final int GL_TEXTURE31_ARB = 34015;
    public static final int GL_ACTIVE_TEXTURE_ARB = 34016;
    public static final int GL_CLIENT_ACTIVE_TEXTURE_ARB = 34017;
    public static final int GL_MAX_TEXTURE_UNITS_ARB = 34018;

    protected ARBMultitexture() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glActiveTextureARB, caps.glClientActiveTextureARB, caps.glMultiTexCoord1fARB, caps.glMultiTexCoord1sARB, caps.glMultiTexCoord1iARB, caps.glMultiTexCoord1dARB, caps.glMultiTexCoord1fvARB, caps.glMultiTexCoord1svARB, caps.glMultiTexCoord1ivARB, caps.glMultiTexCoord1dvARB, caps.glMultiTexCoord2fARB, caps.glMultiTexCoord2sARB, caps.glMultiTexCoord2iARB, caps.glMultiTexCoord2dARB, caps.glMultiTexCoord2fvARB, caps.glMultiTexCoord2svARB, caps.glMultiTexCoord2ivARB, caps.glMultiTexCoord2dvARB, caps.glMultiTexCoord3fARB, caps.glMultiTexCoord3sARB, caps.glMultiTexCoord3iARB, caps.glMultiTexCoord3dARB, caps.glMultiTexCoord3fvARB, caps.glMultiTexCoord3svARB, caps.glMultiTexCoord3ivARB, caps.glMultiTexCoord3dvARB, caps.glMultiTexCoord4fARB, caps.glMultiTexCoord4sARB, caps.glMultiTexCoord4iARB, caps.glMultiTexCoord4dARB, caps.glMultiTexCoord4fvARB, caps.glMultiTexCoord4svARB, caps.glMultiTexCoord4ivARB, caps.glMultiTexCoord4dvARB);
    }

    public static native void glActiveTextureARB(@NativeType(value="GLenum") int var0);

    public static native void glClientActiveTextureARB(@NativeType(value="GLenum") int var0);

    public static native void glMultiTexCoord1fARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLfloat") float var1);

    public static native void glMultiTexCoord1sARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLshort") short var1);

    public static native void glMultiTexCoord1iARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1);

    public static native void glMultiTexCoord1dARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLdouble") double var1);

    public static native void nglMultiTexCoord1fvARB(int var0, long var1);

    public static void glMultiTexCoord1fvARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        ARBMultitexture.nglMultiTexCoord1fvARB(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord1svARB(int var0, long var1);

    public static void glMultiTexCoord1svARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        ARBMultitexture.nglMultiTexCoord1svARB(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord1ivARB(int var0, long var1);

    public static void glMultiTexCoord1ivARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        ARBMultitexture.nglMultiTexCoord1ivARB(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord1dvARB(int var0, long var1);

    public static void glMultiTexCoord1dvARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        ARBMultitexture.nglMultiTexCoord1dvARB(texture, MemoryUtil.memAddress(v));
    }

    public static native void glMultiTexCoord2fARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    public static native void glMultiTexCoord2sARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2);

    public static native void glMultiTexCoord2iARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void glMultiTexCoord2dARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3);

    public static native void nglMultiTexCoord2fvARB(int var0, long var1);

    public static void glMultiTexCoord2fvARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        ARBMultitexture.nglMultiTexCoord2fvARB(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord2svARB(int var0, long var1);

    public static void glMultiTexCoord2svARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        ARBMultitexture.nglMultiTexCoord2svARB(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord2ivARB(int var0, long var1);

    public static void glMultiTexCoord2ivARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        ARBMultitexture.nglMultiTexCoord2ivARB(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord2dvARB(int var0, long var1);

    public static void glMultiTexCoord2dvARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        ARBMultitexture.nglMultiTexCoord2dvARB(texture, MemoryUtil.memAddress(v));
    }

    public static native void glMultiTexCoord3fARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    public static native void glMultiTexCoord3sARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2, @NativeType(value="GLshort") short var3);

    public static native void glMultiTexCoord3iARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3);

    public static native void glMultiTexCoord3dARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5);

    public static native void nglMultiTexCoord3fvARB(int var0, long var1);

    public static void glMultiTexCoord3fvARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        ARBMultitexture.nglMultiTexCoord3fvARB(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord3svARB(int var0, long var1);

    public static void glMultiTexCoord3svARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        ARBMultitexture.nglMultiTexCoord3svARB(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord3ivARB(int var0, long var1);

    public static void glMultiTexCoord3ivARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        ARBMultitexture.nglMultiTexCoord3ivARB(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord3dvARB(int var0, long var1);

    public static void glMultiTexCoord3dvARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        ARBMultitexture.nglMultiTexCoord3dvARB(texture, MemoryUtil.memAddress(v));
    }

    public static native void glMultiTexCoord4fARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLfloat") float var4);

    public static native void glMultiTexCoord4sARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2, @NativeType(value="GLshort") short var3, @NativeType(value="GLshort") short var4);

    public static native void glMultiTexCoord4iARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4);

    public static native void glMultiTexCoord4dARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5, @NativeType(value="GLdouble") double var7);

    public static native void nglMultiTexCoord4fvARB(int var0, long var1);

    public static void glMultiTexCoord4fvARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        ARBMultitexture.nglMultiTexCoord4fvARB(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord4svARB(int var0, long var1);

    public static void glMultiTexCoord4svARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        ARBMultitexture.nglMultiTexCoord4svARB(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord4ivARB(int var0, long var1);

    public static void glMultiTexCoord4ivARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        ARBMultitexture.nglMultiTexCoord4ivARB(texture, MemoryUtil.memAddress(v));
    }

    public static native void nglMultiTexCoord4dvARB(int var0, long var1);

    public static void glMultiTexCoord4dvARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        ARBMultitexture.nglMultiTexCoord4dvARB(texture, MemoryUtil.memAddress(v));
    }

    public static void glMultiTexCoord1fvARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord1fvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord1svARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord1svARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord1ivARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord1ivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord1dvARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord1dvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord2fvARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord2fvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord2svARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord2svARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord2ivARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord2ivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord2dvARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord2dvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord3fvARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord3fvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord3svARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord3svARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord3ivARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord3ivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord3dvARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord3dvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord4fvARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord4fvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord4svARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord4svARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord4ivARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord4ivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    public static void glMultiTexCoord4dvARB(@NativeType(value="GLenum") int texture, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord4dvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(texture, v, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

