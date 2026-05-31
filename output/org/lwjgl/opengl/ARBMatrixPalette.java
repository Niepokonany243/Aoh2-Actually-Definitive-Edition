/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBMatrixPalette {
    public static final int GL_MATRIX_PALETTE_ARB = 34880;
    public static final int GL_MAX_MATRIX_PALETTE_STACK_DEPTH_ARB = 34881;
    public static final int GL_MAX_PALETTE_MATRICES_ARB = 34882;
    public static final int GL_CURRENT_PALETTE_MATRIX_ARB = 34883;
    public static final int GL_MATRIX_INDEX_ARRAY_ARB = 34884;
    public static final int GL_CURRENT_MATRIX_INDEX_ARB = 34885;
    public static final int GL_MATRIX_INDEX_ARRAY_SIZE_ARB = 34886;
    public static final int GL_MATRIX_INDEX_ARRAY_TYPE_ARB = 34887;
    public static final int GL_MATRIX_INDEX_ARRAY_STRIDE_ARB = 34888;
    public static final int GL_MATRIX_INDEX_ARRAY_POINTER_ARB = 34889;

    protected ARBMatrixPalette() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glCurrentPaletteMatrixARB, caps.glMatrixIndexuivARB, caps.glMatrixIndexubvARB, caps.glMatrixIndexusvARB, caps.glMatrixIndexPointerARB);
    }

    public static native void glCurrentPaletteMatrixARB(@NativeType(value="GLint") int var0);

    public static native void nglMatrixIndexuivARB(int var0, long var1);

    public static void glMatrixIndexuivARB(@NativeType(value="GLuint *") IntBuffer indices) {
        ARBMatrixPalette.nglMatrixIndexuivARB(indices.remaining(), MemoryUtil.memAddress(indices));
    }

    public static native void nglMatrixIndexubvARB(int var0, long var1);

    public static void glMatrixIndexubvARB(@NativeType(value="GLubyte *") ByteBuffer indices) {
        ARBMatrixPalette.nglMatrixIndexubvARB(indices.remaining(), MemoryUtil.memAddress(indices));
    }

    public static native void nglMatrixIndexusvARB(int var0, long var1);

    public static void glMatrixIndexusvARB(@NativeType(value="GLushort *") ShortBuffer indices) {
        ARBMatrixPalette.nglMatrixIndexusvARB(indices.remaining(), MemoryUtil.memAddress(indices));
    }

    public static native void nglMatrixIndexPointerARB(int var0, int var1, int var2, long var3);

    public static void glMatrixIndexPointerARB(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ByteBuffer pointer) {
        ARBMatrixPalette.nglMatrixIndexPointerARB(size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glMatrixIndexPointerARB(@NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") long pointer) {
        ARBMatrixPalette.nglMatrixIndexPointerARB(size, type, stride, pointer);
    }

    public static void glMatrixIndexPointerARB(@NativeType(value="GLint") int size, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ByteBuffer pointer) {
        ARBMatrixPalette.nglMatrixIndexPointerARB(size, 5121, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glMatrixIndexPointerARB(@NativeType(value="GLint") int size, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ShortBuffer pointer) {
        ARBMatrixPalette.nglMatrixIndexPointerARB(size, 5123, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glMatrixIndexPointerARB(@NativeType(value="GLint") int size, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") IntBuffer pointer) {
        ARBMatrixPalette.nglMatrixIndexPointerARB(size, 5125, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glMatrixIndexuivARB(@NativeType(value="GLuint *") int[] indices) {
        long __functionAddress = GL.getICD().glMatrixIndexuivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(indices.length, indices, __functionAddress);
    }

    public static void glMatrixIndexusvARB(@NativeType(value="GLushort *") short[] indices) {
        long __functionAddress = GL.getICD().glMatrixIndexusvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(indices.length, indices, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

