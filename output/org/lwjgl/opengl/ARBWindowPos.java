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

public class ARBWindowPos {
    protected ARBWindowPos() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glWindowPos2iARB, caps.glWindowPos2sARB, caps.glWindowPos2fARB, caps.glWindowPos2dARB, caps.glWindowPos2ivARB, caps.glWindowPos2svARB, caps.glWindowPos2fvARB, caps.glWindowPos2dvARB, caps.glWindowPos3iARB, caps.glWindowPos3sARB, caps.glWindowPos3fARB, caps.glWindowPos3dARB, caps.glWindowPos3ivARB, caps.glWindowPos3svARB, caps.glWindowPos3fvARB, caps.glWindowPos3dvARB);
    }

    public static native void glWindowPos2iARB(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1);

    public static native void glWindowPos2sARB(@NativeType(value="GLshort") short var0, @NativeType(value="GLshort") short var1);

    public static native void glWindowPos2fARB(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1);

    public static native void glWindowPos2dARB(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2);

    public static native void nglWindowPos2ivARB(long var0);

    public static void glWindowPos2ivARB(@NativeType(value="GLint const *") IntBuffer p) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)p, 2);
        }
        ARBWindowPos.nglWindowPos2ivARB(MemoryUtil.memAddress(p));
    }

    public static native void nglWindowPos2svARB(long var0);

    public static void glWindowPos2svARB(@NativeType(value="GLshort const *") ShortBuffer p) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)p, 2);
        }
        ARBWindowPos.nglWindowPos2svARB(MemoryUtil.memAddress(p));
    }

    public static native void nglWindowPos2fvARB(long var0);

    public static void glWindowPos2fvARB(@NativeType(value="GLfloat const *") FloatBuffer p) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)p, 2);
        }
        ARBWindowPos.nglWindowPos2fvARB(MemoryUtil.memAddress(p));
    }

    public static native void nglWindowPos2dvARB(long var0);

    public static void glWindowPos2dvARB(@NativeType(value="GLdouble const *") DoubleBuffer p) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)p, 2);
        }
        ARBWindowPos.nglWindowPos2dvARB(MemoryUtil.memAddress(p));
    }

    public static native void glWindowPos3iARB(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void glWindowPos3sARB(@NativeType(value="GLshort") short var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2);

    public static native void glWindowPos3fARB(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    public static native void glWindowPos3dARB(@NativeType(value="GLdouble") double var0, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4);

    public static native void nglWindowPos3ivARB(long var0);

    public static void glWindowPos3ivARB(@NativeType(value="GLint const *") IntBuffer p) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)p, 3);
        }
        ARBWindowPos.nglWindowPos3ivARB(MemoryUtil.memAddress(p));
    }

    public static native void nglWindowPos3svARB(long var0);

    public static void glWindowPos3svARB(@NativeType(value="GLshort const *") ShortBuffer p) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)p, 3);
        }
        ARBWindowPos.nglWindowPos3svARB(MemoryUtil.memAddress(p));
    }

    public static native void nglWindowPos3fvARB(long var0);

    public static void glWindowPos3fvARB(@NativeType(value="GLfloat const *") FloatBuffer p) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)p, 3);
        }
        ARBWindowPos.nglWindowPos3fvARB(MemoryUtil.memAddress(p));
    }

    public static native void nglWindowPos3dvARB(long var0);

    public static void glWindowPos3dvARB(@NativeType(value="GLdouble const *") DoubleBuffer p) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)p, 3);
        }
        ARBWindowPos.nglWindowPos3dvARB(MemoryUtil.memAddress(p));
    }

    public static void glWindowPos2ivARB(@NativeType(value="GLint const *") int[] p) {
        long __functionAddress = GL.getICD().glWindowPos2ivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(p, 2);
        }
        JNI.callPV(p, __functionAddress);
    }

    public static void glWindowPos2svARB(@NativeType(value="GLshort const *") short[] p) {
        long __functionAddress = GL.getICD().glWindowPos2svARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(p, 2);
        }
        JNI.callPV(p, __functionAddress);
    }

    public static void glWindowPos2fvARB(@NativeType(value="GLfloat const *") float[] p) {
        long __functionAddress = GL.getICD().glWindowPos2fvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(p, 2);
        }
        JNI.callPV(p, __functionAddress);
    }

    public static void glWindowPos2dvARB(@NativeType(value="GLdouble const *") double[] p) {
        long __functionAddress = GL.getICD().glWindowPos2dvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(p, 2);
        }
        JNI.callPV(p, __functionAddress);
    }

    public static void glWindowPos3ivARB(@NativeType(value="GLint const *") int[] p) {
        long __functionAddress = GL.getICD().glWindowPos3ivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(p, 3);
        }
        JNI.callPV(p, __functionAddress);
    }

    public static void glWindowPos3svARB(@NativeType(value="GLshort const *") short[] p) {
        long __functionAddress = GL.getICD().glWindowPos3svARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(p, 3);
        }
        JNI.callPV(p, __functionAddress);
    }

    public static void glWindowPos3fvARB(@NativeType(value="GLfloat const *") float[] p) {
        long __functionAddress = GL.getICD().glWindowPos3fvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(p, 3);
        }
        JNI.callPV(p, __functionAddress);
    }

    public static void glWindowPos3dvARB(@NativeType(value="GLdouble const *") double[] p) {
        long __functionAddress = GL.getICD().glWindowPos3dvARB;
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

