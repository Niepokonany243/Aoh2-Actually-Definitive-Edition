/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBTransposeMatrix {
    public static final int GL_TRANSPOSE_MODELVIEW_MATRIX_ARB = 34019;
    public static final int GL_TRANSPOSE_PROJECTION_MATRIX_ARB = 34020;
    public static final int GL_TRANSPOSE_TEXTURE_MATRIX_ARB = 34021;
    public static final int GL_TRANSPOSE_COLOR_MATRIX_ARB = 34022;

    protected ARBTransposeMatrix() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glLoadTransposeMatrixfARB, caps.glLoadTransposeMatrixdARB, caps.glMultTransposeMatrixfARB, caps.glMultTransposeMatrixdARB);
    }

    public static native void nglLoadTransposeMatrixfARB(long var0);

    public static void glLoadTransposeMatrixfARB(@NativeType(value="GLfloat const *") FloatBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 16);
        }
        ARBTransposeMatrix.nglLoadTransposeMatrixfARB(MemoryUtil.memAddress(m));
    }

    public static native void nglLoadTransposeMatrixdARB(long var0);

    public static void glLoadTransposeMatrixdARB(@NativeType(value="GLdouble const *") DoubleBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 16);
        }
        ARBTransposeMatrix.nglLoadTransposeMatrixdARB(MemoryUtil.memAddress(m));
    }

    public static native void nglMultTransposeMatrixfARB(long var0);

    public static void glMultTransposeMatrixfARB(@NativeType(value="GLfloat const *") FloatBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 16);
        }
        ARBTransposeMatrix.nglMultTransposeMatrixfARB(MemoryUtil.memAddress(m));
    }

    public static native void nglMultTransposeMatrixdARB(long var0);

    public static void glMultTransposeMatrixdARB(@NativeType(value="GLdouble const *") DoubleBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 16);
        }
        ARBTransposeMatrix.nglMultTransposeMatrixdARB(MemoryUtil.memAddress(m));
    }

    public static void glLoadTransposeMatrixfARB(@NativeType(value="GLfloat const *") float[] m) {
        long __functionAddress = GL.getICD().glLoadTransposeMatrixfARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 16);
        }
        JNI.callPV(m, __functionAddress);
    }

    public static void glLoadTransposeMatrixdARB(@NativeType(value="GLdouble const *") double[] m) {
        long __functionAddress = GL.getICD().glLoadTransposeMatrixdARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 16);
        }
        JNI.callPV(m, __functionAddress);
    }

    public static void glMultTransposeMatrixfARB(@NativeType(value="GLfloat const *") float[] m) {
        long __functionAddress = GL.getICD().glMultTransposeMatrixfARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 16);
        }
        JNI.callPV(m, __functionAddress);
    }

    public static void glMultTransposeMatrixdARB(@NativeType(value="GLdouble const *") double[] m) {
        long __functionAddress = GL.getICD().glMultTransposeMatrixdARB;
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

