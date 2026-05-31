/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL14C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBImaging {
    public static final int GL_COLOR_TABLE = 32976;
    public static final int GL_POST_CONVOLUTION_COLOR_TABLE = 32977;
    public static final int GL_POST_COLOR_MATRIX_COLOR_TABLE = 32978;
    public static final int GL_PROXY_COLOR_TABLE = 32979;
    public static final int GL_PROXY_POST_CONVOLUTION_COLOR_TABLE = 32980;
    public static final int GL_PROXY_POST_COLOR_MATRIX_COLOR_TABLE = 32981;
    public static final int GL_COLOR_TABLE_SCALE = 32982;
    public static final int GL_COLOR_TABLE_BIAS = 32983;
    public static final int GL_COLOR_TABLE_FORMAT = 32984;
    public static final int GL_COLOR_TABLE_WIDTH = 32985;
    public static final int GL_COLOR_TABLE_RED_SIZE = 32986;
    public static final int GL_COLOR_TABLE_GREEN_SIZE = 32987;
    public static final int GL_COLOR_TABLE_BLUE_SIZE = 32988;
    public static final int GL_COLOR_TABLE_ALPHA_SIZE = 32989;
    public static final int GL_COLOR_TABLE_LUMINANCE_SIZE = 32990;
    public static final int GL_COLOR_TABLE_INTENSITY_SIZE = 32991;
    public static final int GL_TABLE_TOO_LARGE = 32817;
    public static final int GL_CONVOLUTION_1D = 32784;
    public static final int GL_CONVOLUTION_2D = 32785;
    public static final int GL_SEPARABLE_2D = 32786;
    public static final int GL_CONVOLUTION_BORDER_MODE = 32787;
    public static final int GL_CONVOLUTION_FILTER_SCALE = 32788;
    public static final int GL_CONVOLUTION_FILTER_BIAS = 32789;
    public static final int GL_REDUCE = 32790;
    public static final int GL_CONVOLUTION_FORMAT = 32791;
    public static final int GL_CONVOLUTION_WIDTH = 32792;
    public static final int GL_CONVOLUTION_HEIGHT = 32793;
    public static final int GL_MAX_CONVOLUTION_WIDTH = 32794;
    public static final int GL_MAX_CONVOLUTION_HEIGHT = 32795;
    public static final int GL_POST_CONVOLUTION_RED_SCALE = 32796;
    public static final int GL_POST_CONVOLUTION_GREEN_SCALE = 32797;
    public static final int GL_POST_CONVOLUTION_BLUE_SCALE = 32798;
    public static final int GL_POST_CONVOLUTION_ALPHA_SCALE = 32799;
    public static final int GL_POST_CONVOLUTION_RED_BIAS = 32800;
    public static final int GL_POST_CONVOLUTION_GREEN_BIAS = 32801;
    public static final int GL_POST_CONVOLUTION_BLUE_BIAS = 32802;
    public static final int GL_POST_CONVOLUTION_ALPHA_BIAS = 32803;
    public static final int GL_CONSTANT_BORDER = 33105;
    public static final int GL_REPLICATE_BORDER = 33107;
    public static final int GL_CONVOLUTION_BORDER_COLOR = 33108;
    public static final int GL_COLOR_MATRIX = 32945;
    public static final int GL_COLOR_MATRIX_STACK_DEPTH = 32946;
    public static final int GL_MAX_COLOR_MATRIX_STACK_DEPTH = 32947;
    public static final int GL_POST_COLOR_MATRIX_RED_SCALE = 32948;
    public static final int GL_POST_COLOR_MATRIX_GREEN_SCALE = 32949;
    public static final int GL_POST_COLOR_MATRIX_BLUE_SCALE = 32950;
    public static final int GL_POST_COLOR_MATRIX_ALPHA_SCALE = 32951;
    public static final int GL_POST_COLOR_MATRIX_RED_BIAS = 32952;
    public static final int GL_POST_COLOR_MATRIX_GREEN_BIAS = 32953;
    public static final int GL_POST_COLOR_MATRIX_BLUE_BIAS = 32954;
    public static final int GL_POST_COLOR_MATRIX_ALPHA_BIAS = 32955;
    public static final int GL_HISTOGRAM = 32804;
    public static final int GL_PROXY_HISTOGRAM = 32805;
    public static final int GL_HISTOGRAM_WIDTH = 32806;
    public static final int GL_HISTOGRAM_FORMAT = 32807;
    public static final int GL_HISTOGRAM_RED_SIZE = 32808;
    public static final int GL_HISTOGRAM_GREEN_SIZE = 32809;
    public static final int GL_HISTOGRAM_BLUE_SIZE = 32810;
    public static final int GL_HISTOGRAM_ALPHA_SIZE = 32811;
    public static final int GL_HISTOGRAM_LUMINANCE_SIZE = 32812;
    public static final int GL_HISTOGRAM_SINK = 32813;
    public static final int GL_MINMAX = 32814;
    public static final int GL_MINMAX_FORMAT = 32815;
    public static final int GL_MINMAX_SINK = 32816;
    public static final int GL_CONSTANT_COLOR = 32769;
    public static final int GL_ONE_MINUS_CONSTANT_COLOR = 32770;
    public static final int GL_CONSTANT_ALPHA = 32771;
    public static final int GL_ONE_MINUS_CONSTANT_ALPHA = 32772;
    public static final int GL_BLEND_COLOR = 32773;
    public static final int GL_FUNC_ADD = 32774;
    public static final int GL_MIN = 32775;
    public static final int GL_MAX = 32776;
    public static final int GL_BLEND_EQUATION = 32777;
    public static final int GL_FUNC_SUBTRACT = 32778;
    public static final int GL_FUNC_REVERSE_SUBTRACT = 32779;

    protected ARBImaging() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, boolean fc) {
        return (fc || Checks.checkFunctions(caps.glColorTable, caps.glCopyColorTable, caps.glColorTableParameteriv, caps.glColorTableParameterfv, caps.glGetColorTable, caps.glGetColorTableParameteriv, caps.glGetColorTableParameterfv, caps.glColorSubTable, caps.glCopyColorSubTable, caps.glConvolutionFilter1D, caps.glConvolutionFilter2D, caps.glCopyConvolutionFilter1D, caps.glCopyConvolutionFilter2D, caps.glGetConvolutionFilter, caps.glSeparableFilter2D, caps.glGetSeparableFilter, caps.glConvolutionParameteri, caps.glConvolutionParameteriv, caps.glConvolutionParameterf, caps.glConvolutionParameterfv, caps.glGetConvolutionParameteriv, caps.glGetConvolutionParameterfv, caps.glHistogram, caps.glResetHistogram, caps.glGetHistogram, caps.glGetHistogramParameteriv, caps.glGetHistogramParameterfv, caps.glMinmax, caps.glResetMinmax, caps.glGetMinmax, caps.glGetMinmaxParameteriv, caps.glGetMinmaxParameterfv)) && Checks.checkFunctions(caps.glBlendColor, caps.glBlendEquation);
    }

    public static native void nglColorTable(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer table) {
        ARBImaging.nglColorTable(target, internalformat, width, format, type, MemoryUtil.memAddress(table));
    }

    public static void glColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long table) {
        ARBImaging.nglColorTable(target, internalformat, width, format, type, table);
    }

    public static void glColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ShortBuffer table) {
        ARBImaging.nglColorTable(target, internalformat, width, format, type, MemoryUtil.memAddress(table));
    }

    public static void glColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer table) {
        ARBImaging.nglColorTable(target, internalformat, width, format, type, MemoryUtil.memAddress(table));
    }

    public static void glColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") FloatBuffer table) {
        ARBImaging.nglColorTable(target, internalformat, width, format, type, MemoryUtil.memAddress(table));
    }

    public static native void glCopyColorTable(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLsizei") int var4);

    public static native void nglColorTableParameteriv(int var0, int var1, long var2);

    public static void glColorTableParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        ARBImaging.nglColorTableParameteriv(target, pname, MemoryUtil.memAddress(params));
    }

    public static native void nglColorTableParameterfv(int var0, int var1, long var2);

    public static void glColorTableParameterfv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        ARBImaging.nglColorTableParameterfv(target, pname, MemoryUtil.memAddress(params));
    }

    public static native void nglGetColorTable(int var0, int var1, int var2, long var3);

    public static void glGetColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer table) {
        ARBImaging.nglGetColorTable(target, format, type, MemoryUtil.memAddress(table));
    }

    public static void glGetColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") long table) {
        ARBImaging.nglGetColorTable(target, format, type, table);
    }

    public static void glGetColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ShortBuffer table) {
        ARBImaging.nglGetColorTable(target, format, type, MemoryUtil.memAddress(table));
    }

    public static void glGetColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") IntBuffer table) {
        ARBImaging.nglGetColorTable(target, format, type, MemoryUtil.memAddress(table));
    }

    public static void glGetColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") FloatBuffer table) {
        ARBImaging.nglGetColorTable(target, format, type, MemoryUtil.memAddress(table));
    }

    public static native void nglGetColorTableParameteriv(int var0, int var1, long var2);

    public static void glGetColorTableParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        ARBImaging.nglGetColorTableParameteriv(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetColorTableParameteri(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            ARBImaging.nglGetColorTableParameteriv(target, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetColorTableParameterfv(int var0, int var1, long var2);

    public static void glGetColorTableParameterfv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        ARBImaging.nglGetColorTableParameterfv(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetColorTableParameterf(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer params = stack.callocFloat(1);
            ARBImaging.nglGetColorTableParameterfv(target, pname, MemoryUtil.memAddress(params));
            float f = params.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglColorSubTable(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glColorSubTable(@NativeType(value="GLenum") int target, @NativeType(value="GLsizei") int start, @NativeType(value="GLsizei") int count, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer data) {
        ARBImaging.nglColorSubTable(target, start, count, format, type, MemoryUtil.memAddress(data));
    }

    public static void glColorSubTable(@NativeType(value="GLenum") int target, @NativeType(value="GLsizei") int start, @NativeType(value="GLsizei") int count, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long data) {
        ARBImaging.nglColorSubTable(target, start, count, format, type, data);
    }

    public static native void glCopyColorSubTable(@NativeType(value="GLenum") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLsizei") int var4);

    public static native void nglConvolutionFilter1D(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glConvolutionFilter1D(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer data) {
        ARBImaging.nglConvolutionFilter1D(target, internalformat, width, format, type, MemoryUtil.memAddress(data));
    }

    public static void glConvolutionFilter1D(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long data) {
        ARBImaging.nglConvolutionFilter1D(target, internalformat, width, format, type, data);
    }

    public static native void nglConvolutionFilter2D(int var0, int var1, int var2, int var3, int var4, int var5, long var6);

    public static void glConvolutionFilter2D(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer data) {
        ARBImaging.nglConvolutionFilter2D(target, internalformat, width, height, format, type, MemoryUtil.memAddress(data));
    }

    public static void glConvolutionFilter2D(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long data) {
        ARBImaging.nglConvolutionFilter2D(target, internalformat, width, height, format, type, data);
    }

    public static native void glCopyConvolutionFilter1D(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLsizei") int var4);

    public static native void glCopyConvolutionFilter2D(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLsizei") int var5);

    public static native void nglGetConvolutionFilter(int var0, int var1, int var2, long var3);

    public static void glGetConvolutionFilter(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer image) {
        ARBImaging.nglGetConvolutionFilter(target, format, type, MemoryUtil.memAddress(image));
    }

    public static void glGetConvolutionFilter(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") long image) {
        ARBImaging.nglGetConvolutionFilter(target, format, type, image);
    }

    public static native void nglSeparableFilter2D(int var0, int var1, int var2, int var3, int var4, int var5, long var6, long var8);

    public static void glSeparableFilter2D(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer row, @NativeType(value="void const *") ByteBuffer column) {
        ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, MemoryUtil.memAddress(row), MemoryUtil.memAddress(column));
    }

    public static void glSeparableFilter2D(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long row, @NativeType(value="void const *") long column) {
        ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, row, column);
    }

    public static native void nglGetSeparableFilter(int var0, int var1, int var2, long var3, long var5, long var7);

    public static void glGetSeparableFilter(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer row, @NativeType(value="void *") ByteBuffer column, @Nullable @NativeType(value="void *") ByteBuffer span) {
        ARBImaging.nglGetSeparableFilter(target, format, type, MemoryUtil.memAddress(row), MemoryUtil.memAddress(column), MemoryUtil.memAddressSafe(span));
    }

    public static void glGetSeparableFilter(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") long row, @NativeType(value="void *") long column, @Nullable @NativeType(value="void *") ByteBuffer span) {
        ARBImaging.nglGetSeparableFilter(target, format, type, row, column, MemoryUtil.memAddressSafe(span));
    }

    public static native void glConvolutionParameteri(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2);

    public static native void nglConvolutionParameteriv(int var0, int var1, long var2);

    public static void glConvolutionParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        ARBImaging.nglConvolutionParameteriv(target, pname, MemoryUtil.memAddress(params));
    }

    public static native void glConvolutionParameterf(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLfloat") float var2);

    public static native void nglConvolutionParameterfv(int var0, int var1, long var2);

    public static void glConvolutionParameterfv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        ARBImaging.nglConvolutionParameterfv(target, pname, MemoryUtil.memAddress(params));
    }

    public static native void nglGetConvolutionParameteriv(int var0, int var1, long var2);

    public static void glGetConvolutionParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        ARBImaging.nglGetConvolutionParameteriv(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetConvolutionParameteri(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            ARBImaging.nglGetConvolutionParameteriv(target, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetConvolutionParameterfv(int var0, int var1, long var2);

    public static void glGetConvolutionParameterfv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        ARBImaging.nglGetConvolutionParameterfv(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetConvolutionParameterf(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer params = stack.callocFloat(1);
            ARBImaging.nglGetConvolutionParameterfv(target, pname, MemoryUtil.memAddress(params));
            float f = params.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glHistogram(@NativeType(value="GLenum") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLboolean") boolean var3);

    public static native void glResetHistogram(@NativeType(value="GLenum") int var0);

    public static native void nglGetHistogram(int var0, boolean var1, int var2, int var3, long var4);

    public static void glGetHistogram(@NativeType(value="GLenum") int target, @NativeType(value="GLboolean") boolean reset, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer values) {
        ARBImaging.nglGetHistogram(target, reset, format, type, MemoryUtil.memAddress(values));
    }

    public static void glGetHistogram(@NativeType(value="GLenum") int target, @NativeType(value="GLboolean") boolean reset, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") long values) {
        ARBImaging.nglGetHistogram(target, reset, format, type, values);
    }

    public static native void nglGetHistogramParameteriv(int var0, int var1, long var2);

    public static void glGetHistogramParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        ARBImaging.nglGetHistogramParameteriv(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetHistogramParameteri(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            ARBImaging.nglGetHistogramParameteriv(target, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetHistogramParameterfv(int var0, int var1, long var2);

    public static void glGetHistogramParameterfv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        ARBImaging.nglGetHistogramParameterfv(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetHistogramParameterf(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer params = stack.callocFloat(1);
            ARBImaging.nglGetHistogramParameterfv(target, pname, MemoryUtil.memAddress(params));
            float f = params.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glMinmax(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLboolean") boolean var2);

    public static native void glResetMinmax(@NativeType(value="GLenum") int var0);

    public static native void nglGetMinmax(int var0, boolean var1, int var2, int var3, long var4);

    public static void glGetMinmax(@NativeType(value="GLenum") int target, @NativeType(value="GLboolean") boolean reset, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer values) {
        ARBImaging.nglGetMinmax(target, reset, format, type, MemoryUtil.memAddress(values));
    }

    public static void glGetMinmax(@NativeType(value="GLenum") int target, @NativeType(value="GLboolean") boolean reset, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") long values) {
        ARBImaging.nglGetMinmax(target, reset, format, type, values);
    }

    public static native void nglGetMinmaxParameteriv(int var0, int var1, long var2);

    public static void glGetMinmaxParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        ARBImaging.nglGetMinmaxParameteriv(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetMinmaxParameteri(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            ARBImaging.nglGetMinmaxParameteriv(target, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetMinmaxParameterfv(int var0, int var1, long var2);

    public static void glGetMinmaxParameterfv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        ARBImaging.nglGetMinmaxParameterfv(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetMinmaxParameterf(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer params = stack.callocFloat(1);
            ARBImaging.nglGetMinmaxParameterfv(target, pname, MemoryUtil.memAddress(params));
            float f = params.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glBlendColor(@NativeType(value="GLfloat") float red, @NativeType(value="GLfloat") float green, @NativeType(value="GLfloat") float blue, @NativeType(value="GLfloat") float alpha) {
        GL14C.glBlendColor(red, green, blue, alpha);
    }

    public static void glBlendEquation(@NativeType(value="GLenum") int mode) {
        GL14C.glBlendEquation(mode);
    }

    public static void glColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") short[] table) {
        long __functionAddress = GL.getICD().glColorTable;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, internalformat, width, format, type, table, __functionAddress);
    }

    public static void glColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] table) {
        long __functionAddress = GL.getICD().glColorTable;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, internalformat, width, format, type, table, __functionAddress);
    }

    public static void glColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") float[] table) {
        long __functionAddress = GL.getICD().glColorTable;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, internalformat, width, format, type, table, __functionAddress);
    }

    public static void glColorTableParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = GL.getICD().glColorTableParameteriv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glColorTableParameterfv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] params) {
        long __functionAddress = GL.getICD().glColorTableParameterfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glGetColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") short[] table) {
        long __functionAddress = GL.getICD().glGetColorTable;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, format, type, table, __functionAddress);
    }

    public static void glGetColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") int[] table) {
        long __functionAddress = GL.getICD().glGetColorTable;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, format, type, table, __functionAddress);
    }

    public static void glGetColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") float[] table) {
        long __functionAddress = GL.getICD().glGetColorTable;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, format, type, table, __functionAddress);
    }

    public static void glGetColorTableParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetColorTableParameteriv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glGetColorTableParameterfv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetColorTableParameterfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glConvolutionParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = GL.getICD().glConvolutionParameteriv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glConvolutionParameterfv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] params) {
        long __functionAddress = GL.getICD().glConvolutionParameterfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glGetConvolutionParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetConvolutionParameteriv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glGetConvolutionParameterfv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetConvolutionParameterfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glGetHistogramParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetHistogramParameteriv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glGetHistogramParameterfv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetHistogramParameterfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glGetMinmaxParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetMinmaxParameteriv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glGetMinmaxParameterfv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetMinmaxParameterfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

