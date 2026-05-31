/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL41C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBViewportArray {
    public static final int GL_MAX_VIEWPORTS = 33371;
    public static final int GL_VIEWPORT_SUBPIXEL_BITS = 33372;
    public static final int GL_VIEWPORT_BOUNDS_RANGE = 33373;
    public static final int GL_LAYER_PROVOKING_VERTEX = 33374;
    public static final int GL_VIEWPORT_INDEX_PROVOKING_VERTEX = 33375;
    public static final int GL_UNDEFINED_VERTEX = 33376;

    protected ARBViewportArray() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glViewportArrayv, caps.glViewportIndexedf, caps.glViewportIndexedfv, caps.glScissorArrayv, caps.glScissorIndexed, caps.glScissorIndexedv, caps.glDepthRangeArrayv, caps.glDepthRangeIndexed, caps.glGetFloati_v, caps.glGetDoublei_v);
    }

    public static void nglViewportArrayv(int first, int count, long v) {
        GL41C.nglViewportArrayv(first, count, v);
    }

    public static void glViewportArrayv(@NativeType(value="GLuint") int first, @NativeType(value="GLfloat const *") FloatBuffer v) {
        GL41C.glViewportArrayv(first, v);
    }

    public static void glViewportIndexedf(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat") float x, @NativeType(value="GLfloat") float y, @NativeType(value="GLfloat") float w, @NativeType(value="GLfloat") float h) {
        GL41C.glViewportIndexedf(index, x, y, w, h);
    }

    public static void nglViewportIndexedfv(int index, long v) {
        GL41C.nglViewportIndexedfv(index, v);
    }

    public static void glViewportIndexedfv(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer v) {
        GL41C.glViewportIndexedfv(index, v);
    }

    public static void nglScissorArrayv(int first, int count, long v) {
        GL41C.nglScissorArrayv(first, count, v);
    }

    public static void glScissorArrayv(@NativeType(value="GLuint") int first, @NativeType(value="GLint const *") IntBuffer v) {
        GL41C.glScissorArrayv(first, v);
    }

    public static void glScissorIndexed(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int left, @NativeType(value="GLint") int bottom, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height) {
        GL41C.glScissorIndexed(index, left, bottom, width, height);
    }

    public static void nglScissorIndexedv(int index, long v) {
        GL41C.nglScissorIndexedv(index, v);
    }

    public static void glScissorIndexedv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer v) {
        GL41C.glScissorIndexedv(index, v);
    }

    public static void nglDepthRangeArrayv(int first, int count, long v) {
        GL41C.nglDepthRangeArrayv(first, count, v);
    }

    public static void glDepthRangeArrayv(@NativeType(value="GLuint") int first, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        GL41C.glDepthRangeArrayv(first, v);
    }

    public static void glDepthRangeIndexed(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble") double zNear, @NativeType(value="GLdouble") double zFar) {
        GL41C.glDepthRangeIndexed(index, zNear, zFar);
    }

    public static void nglGetFloati_v(int target, int index, long data) {
        GL41C.nglGetFloati_v(target, index, data);
    }

    public static void glGetFloati_v(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat *") FloatBuffer data) {
        GL41C.glGetFloati_v(target, index, data);
    }

    @NativeType(value="void")
    public static float glGetFloati(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        return GL41C.glGetFloati(target, index);
    }

    public static void nglGetDoublei_v(int target, int index, long data) {
        GL41C.nglGetDoublei_v(target, index, data);
    }

    public static void glGetDoublei_v(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLdouble *") DoubleBuffer data) {
        GL41C.glGetDoublei_v(target, index, data);
    }

    @NativeType(value="void")
    public static double glGetDoublei(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        return GL41C.glGetDoublei(target, index);
    }

    public static void glViewportArrayv(@NativeType(value="GLuint") int first, @NativeType(value="GLfloat const *") float[] v) {
        GL41C.glViewportArrayv(first, v);
    }

    public static void glViewportIndexedfv(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] v) {
        GL41C.glViewportIndexedfv(index, v);
    }

    public static void glScissorArrayv(@NativeType(value="GLuint") int first, @NativeType(value="GLint const *") int[] v) {
        GL41C.glScissorArrayv(first, v);
    }

    public static void glScissorIndexedv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] v) {
        GL41C.glScissorIndexedv(index, v);
    }

    public static void glDepthRangeArrayv(@NativeType(value="GLuint") int first, @NativeType(value="GLdouble const *") double[] v) {
        GL41C.glDepthRangeArrayv(first, v);
    }

    public static void glGetFloati_v(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat *") float[] data) {
        GL41C.glGetFloati_v(target, index, data);
    }

    public static void glGetDoublei_v(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLdouble *") double[] data) {
        GL41C.glGetDoublei_v(target, index, data);
    }

    static {
        GL.initialize();
    }
}

