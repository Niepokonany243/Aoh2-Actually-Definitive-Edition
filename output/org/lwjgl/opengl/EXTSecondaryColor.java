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
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTSecondaryColor {
    public static final int GL_COLOR_SUM_EXT = 33880;
    public static final int GL_CURRENT_SECONDARY_COLOR_EXT = 33881;
    public static final int GL_SECONDARY_COLOR_ARRAY_SIZE_EXT = 33882;
    public static final int GL_SECONDARY_COLOR_ARRAY_TYPE_EXT = 33883;
    public static final int GL_SECONDARY_COLOR_ARRAY_STRIDE_EXT = 33884;
    public static final int GL_SECONDARY_COLOR_ARRAY_POINTER_EXT = 33885;
    public static final int GL_SECONDARY_COLOR_ARRAY_EXT = 33886;

    protected EXTSecondaryColor() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glSecondaryColor3bEXT, caps.glSecondaryColor3sEXT, caps.glSecondaryColor3iEXT, caps.glSecondaryColor3fEXT, caps.glSecondaryColor3dEXT, caps.glSecondaryColor3ubEXT, caps.glSecondaryColor3usEXT, caps.glSecondaryColor3uiEXT, caps.glSecondaryColor3bvEXT, caps.glSecondaryColor3svEXT, caps.glSecondaryColor3ivEXT, caps.glSecondaryColor3fvEXT, caps.glSecondaryColor3dvEXT, caps.glSecondaryColor3ubvEXT, caps.glSecondaryColor3usvEXT, caps.glSecondaryColor3uivEXT, caps.glSecondaryColorPointerEXT);
    }

    public static native void glSecondaryColor3bEXT(@NativeType(value="GLbyte") byte var0, @NativeType(value="GLbyte") byte var1, @NativeType(value="GLbyte") byte var2);

    public static native void glSecondaryColor3sEXT(@NativeType(value="GLshort") short var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2);

    public static native void glSecondaryColor3iEXT(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void glSecondaryColor3fEXT(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    public static native void glSecondaryColor3dEXT(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4);

    public static native void glSecondaryColor3ubEXT(@NativeType(value="GLubyte") byte var0, @NativeType(value="GLubyte") byte var1, @NativeType(value="GLubyte") byte var2);

    public static native void glSecondaryColor3usEXT(@NativeType(value="GLushort") short var0, @NativeType(value="GLushort") short var1, @NativeType(value="GLushort") short var2);

    public static native void glSecondaryColor3uiEXT(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void nglSecondaryColor3bvEXT(long var0);

    public static void glSecondaryColor3bvEXT(@NativeType(value="GLbyte const *") ByteBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        EXTSecondaryColor.nglSecondaryColor3bvEXT(MemoryUtil.memAddress(v));
    }

    public static native void nglSecondaryColor3svEXT(long var0);

    public static void glSecondaryColor3svEXT(@NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        EXTSecondaryColor.nglSecondaryColor3svEXT(MemoryUtil.memAddress(v));
    }

    public static native void nglSecondaryColor3ivEXT(long var0);

    public static void glSecondaryColor3ivEXT(@NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        EXTSecondaryColor.nglSecondaryColor3ivEXT(MemoryUtil.memAddress(v));
    }

    public static native void nglSecondaryColor3fvEXT(long var0);

    public static void glSecondaryColor3fvEXT(@NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        EXTSecondaryColor.nglSecondaryColor3fvEXT(MemoryUtil.memAddress(v));
    }

    public static native void nglSecondaryColor3dvEXT(long var0);

    public static void glSecondaryColor3dvEXT(@NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        EXTSecondaryColor.nglSecondaryColor3dvEXT(MemoryUtil.memAddress(v));
    }

    public static native void nglSecondaryColor3ubvEXT(long var0);

    public static void glSecondaryColor3ubvEXT(@NativeType(value="GLubyte const *") ByteBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        EXTSecondaryColor.nglSecondaryColor3ubvEXT(MemoryUtil.memAddress(v));
    }

    public static native void nglSecondaryColor3usvEXT(long var0);

    public static void glSecondaryColor3usvEXT(@NativeType(value="GLushort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        EXTSecondaryColor.nglSecondaryColor3usvEXT(MemoryUtil.memAddress(v));
    }

    public static native void nglSecondaryColor3uivEXT(long var0);

    public static void glSecondaryColor3uivEXT(@NativeType(value="GLuint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        EXTSecondaryColor.nglSecondaryColor3uivEXT(MemoryUtil.memAddress(v));
    }

    public static native void nglSecondaryColorPointerEXT(int var0, int var1, int var2, long var3);

    public static void glSecondaryColorPointerEXT(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ByteBuffer pointer) {
        EXTSecondaryColor.nglSecondaryColorPointerEXT(size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glSecondaryColorPointerEXT(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") long pointer) {
        EXTSecondaryColor.nglSecondaryColorPointerEXT(size, type, stride, pointer);
    }

    public static void glSecondaryColorPointerEXT(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ShortBuffer pointer) {
        EXTSecondaryColor.nglSecondaryColorPointerEXT(size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glSecondaryColorPointerEXT(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") IntBuffer pointer) {
        EXTSecondaryColor.nglSecondaryColorPointerEXT(size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glSecondaryColorPointerEXT(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") FloatBuffer pointer) {
        EXTSecondaryColor.nglSecondaryColorPointerEXT(size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glSecondaryColor3svEXT(@NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glSecondaryColor3svEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glSecondaryColor3ivEXT(@NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glSecondaryColor3ivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glSecondaryColor3fvEXT(@NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glSecondaryColor3fvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glSecondaryColor3dvEXT(@NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glSecondaryColor3dvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glSecondaryColor3usvEXT(@NativeType(value="GLushort const *") short[] v) {
        long __functionAddress = GL.getICD().glSecondaryColor3usvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glSecondaryColor3uivEXT(@NativeType(value="GLuint const *") int[] v) {
        long __functionAddress = GL.getICD().glSecondaryColor3uivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glSecondaryColorPointerEXT(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") short[] pointer) {
        long __functionAddress = GL.getICD().glSecondaryColorPointerEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(size, type, stride, pointer, __functionAddress);
    }

    public static void glSecondaryColorPointerEXT(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") int[] pointer) {
        long __functionAddress = GL.getICD().glSecondaryColorPointerEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(size, type, stride, pointer, __functionAddress);
    }

    public static void glSecondaryColorPointerEXT(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") float[] pointer) {
        long __functionAddress = GL.getICD().glSecondaryColorPointerEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(size, type, stride, pointer, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

