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
import java.util.Set;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBRobustness {
    public static final int GL_GUILTY_CONTEXT_RESET_ARB = 33363;
    public static final int GL_INNOCENT_CONTEXT_RESET_ARB = 33364;
    public static final int GL_UNKNOWN_CONTEXT_RESET_ARB = 33365;
    public static final int GL_RESET_NOTIFICATION_STRATEGY_ARB = 33366;
    public static final int GL_LOSE_CONTEXT_ON_RESET_ARB = 33362;
    public static final int GL_NO_RESET_NOTIFICATION_ARB = 33377;
    public static final int GL_CONTEXT_FLAG_ROBUST_ACCESS_BIT_ARB = 4;

    protected ARBRobustness() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, Set<String> ext) {
        return Checks.checkFunctions(caps.glGetGraphicsResetStatusARB, caps.glGetMapdv != 0L ? caps.glGetnMapdvARB : -1L, caps.glGetMapfv != 0L ? caps.glGetnMapfvARB : -1L, caps.glGetMapiv != 0L ? caps.glGetnMapivARB : -1L, caps.glGetPixelMapfv != 0L ? caps.glGetnPixelMapfvARB : -1L, caps.glGetPixelMapuiv != 0L ? caps.glGetnPixelMapuivARB : -1L, caps.glGetPixelMapusv != 0L ? caps.glGetnPixelMapusvARB : -1L, caps.glGetPolygonStipple != 0L ? caps.glGetnPolygonStippleARB : -1L, caps.glGetnTexImageARB, caps.glReadnPixelsARB, ext.contains("GL_ARB_imaging") && caps.glGetColorTable != 0L ? caps.glGetnColorTableARB : -1L, ext.contains("GL_ARB_imaging") && caps.glGetConvolutionFilter != 0L ? caps.glGetnConvolutionFilterARB : -1L, ext.contains("GL_ARB_imaging") && caps.glGetSeparableFilter != 0L ? caps.glGetnSeparableFilterARB : -1L, ext.contains("GL_ARB_imaging") && caps.glGetHistogram != 0L ? caps.glGetnHistogramARB : -1L, ext.contains("GL_ARB_imaging") && caps.glGetMinmax != 0L ? caps.glGetnMinmaxARB : -1L, ext.contains("OpenGL13") ? caps.glGetnCompressedTexImageARB : -1L, ext.contains("OpenGL20") ? caps.glGetnUniformfvARB : -1L, ext.contains("OpenGL20") ? caps.glGetnUniformivARB : -1L, ext.contains("OpenGL30") ? caps.glGetnUniformuivARB : -1L, ext.contains("OpenGL40") ? caps.glGetnUniformdvARB : -1L);
    }

    @NativeType(value="GLenum")
    public static native int glGetGraphicsResetStatusARB();

    public static native void nglGetnMapdvARB(int var0, int var1, int var2, long var3);

    public static void glGetnMapdvARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query, @NativeType(value="GLdouble *") DoubleBuffer data) {
        ARBRobustness.nglGetnMapdvARB(target, query, data.remaining(), MemoryUtil.memAddress(data));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static double glGetnMapdARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            DoubleBuffer data = stack.callocDouble(1);
            ARBRobustness.nglGetnMapdvARB(target, query, 1, MemoryUtil.memAddress(data));
            double d = data.get(0);
            return d;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetnMapfvARB(int var0, int var1, int var2, long var3);

    public static void glGetnMapfvARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query, @NativeType(value="GLfloat *") FloatBuffer data) {
        ARBRobustness.nglGetnMapfvARB(target, query, data.remaining(), MemoryUtil.memAddress(data));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetnMapfARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer data = stack.callocFloat(1);
            ARBRobustness.nglGetnMapfvARB(target, query, 1, MemoryUtil.memAddress(data));
            float f = data.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetnMapivARB(int var0, int var1, int var2, long var3);

    public static void glGetnMapivARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query, @NativeType(value="GLint *") IntBuffer data) {
        ARBRobustness.nglGetnMapivARB(target, query, data.remaining(), MemoryUtil.memAddress(data));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetnMapiARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer data = stack.callocInt(1);
            ARBRobustness.nglGetnMapivARB(target, query, 1, MemoryUtil.memAddress(data));
            int n = data.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetnPixelMapfvARB(int var0, int var1, long var2);

    public static void glGetnPixelMapfvARB(@NativeType(value="GLenum") int map, @NativeType(value="GLfloat *") FloatBuffer data) {
        ARBRobustness.nglGetnPixelMapfvARB(map, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static native void nglGetnPixelMapuivARB(int var0, int var1, long var2);

    public static void glGetnPixelMapuivARB(@NativeType(value="GLenum") int map, @NativeType(value="GLuint *") IntBuffer data) {
        ARBRobustness.nglGetnPixelMapuivARB(map, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static native void nglGetnPixelMapusvARB(int var0, int var1, long var2);

    public static void glGetnPixelMapusvARB(@NativeType(value="GLenum") int map, @NativeType(value="GLushort *") ShortBuffer data) {
        ARBRobustness.nglGetnPixelMapusvARB(map, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static native void nglGetnPolygonStippleARB(int var0, long var1);

    public static void glGetnPolygonStippleARB(@NativeType(value="GLsizei") int bufSize, @NativeType(value="GLubyte *") long pattern) {
        ARBRobustness.nglGetnPolygonStippleARB(bufSize, pattern);
    }

    public static void glGetnPolygonStippleARB(@NativeType(value="GLubyte *") ByteBuffer pattern) {
        ARBRobustness.nglGetnPolygonStippleARB(pattern.remaining(), MemoryUtil.memAddress(pattern));
    }

    public static native void nglGetnTexImageARB(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glGetnTexImageARB(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long img) {
        ARBRobustness.nglGetnTexImageARB(tex, level, format, type, bufSize, img);
    }

    public static void glGetnTexImageARB(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer img) {
        ARBRobustness.nglGetnTexImageARB(tex, level, format, type, img.remaining(), MemoryUtil.memAddress(img));
    }

    public static void glGetnTexImageARB(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ShortBuffer img) {
        ARBRobustness.nglGetnTexImageARB(tex, level, format, type, img.remaining() << 1, MemoryUtil.memAddress(img));
    }

    public static void glGetnTexImageARB(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") IntBuffer img) {
        ARBRobustness.nglGetnTexImageARB(tex, level, format, type, img.remaining() << 2, MemoryUtil.memAddress(img));
    }

    public static void glGetnTexImageARB(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") FloatBuffer img) {
        ARBRobustness.nglGetnTexImageARB(tex, level, format, type, img.remaining() << 2, MemoryUtil.memAddress(img));
    }

    public static void glGetnTexImageARB(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") DoubleBuffer img) {
        ARBRobustness.nglGetnTexImageARB(tex, level, format, type, img.remaining() << 3, MemoryUtil.memAddress(img));
    }

    public static native void nglReadnPixelsARB(int var0, int var1, int var2, int var3, int var4, int var5, int var6, long var7);

    public static void glReadnPixelsARB(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long data) {
        ARBRobustness.nglReadnPixelsARB(x, y, width, height, format, type, bufSize, data);
    }

    public static void glReadnPixelsARB(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer data) {
        ARBRobustness.nglReadnPixelsARB(x, y, width, height, format, type, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static void glReadnPixelsARB(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ShortBuffer data) {
        ARBRobustness.nglReadnPixelsARB(x, y, width, height, format, type, data.remaining() << 1, MemoryUtil.memAddress(data));
    }

    public static void glReadnPixelsARB(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") IntBuffer data) {
        ARBRobustness.nglReadnPixelsARB(x, y, width, height, format, type, data.remaining() << 2, MemoryUtil.memAddress(data));
    }

    public static void glReadnPixelsARB(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") FloatBuffer data) {
        ARBRobustness.nglReadnPixelsARB(x, y, width, height, format, type, data.remaining() << 2, MemoryUtil.memAddress(data));
    }

    public static native void nglGetnColorTableARB(int var0, int var1, int var2, int var3, long var4);

    public static void glGetnColorTableARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long table) {
        ARBRobustness.nglGetnColorTableARB(target, format, type, bufSize, table);
    }

    public static void glGetnColorTableARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer table) {
        ARBRobustness.nglGetnColorTableARB(target, format, type, table.remaining(), MemoryUtil.memAddress(table));
    }

    public static void glGetnColorTableARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ShortBuffer table) {
        ARBRobustness.nglGetnColorTableARB(target, format, type, table.remaining() << 1, MemoryUtil.memAddress(table));
    }

    public static void glGetnColorTableARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") IntBuffer table) {
        ARBRobustness.nglGetnColorTableARB(target, format, type, table.remaining() << 2, MemoryUtil.memAddress(table));
    }

    public static void glGetnColorTableARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") FloatBuffer table) {
        ARBRobustness.nglGetnColorTableARB(target, format, type, table.remaining() << 2, MemoryUtil.memAddress(table));
    }

    public static native void nglGetnConvolutionFilterARB(int var0, int var1, int var2, int var3, long var4);

    public static void glGetnConvolutionFilterARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long image) {
        ARBRobustness.nglGetnConvolutionFilterARB(target, format, type, bufSize, image);
    }

    public static void glGetnConvolutionFilterARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer image) {
        ARBRobustness.nglGetnConvolutionFilterARB(target, format, type, image.remaining(), MemoryUtil.memAddress(image));
    }

    public static native void nglGetnSeparableFilterARB(int var0, int var1, int var2, int var3, long var4, int var6, long var7, long var9);

    public static void glGetnSeparableFilterARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int rowBufSize, @NativeType(value="void *") long row, @NativeType(value="GLsizei") int columnBufSize, @NativeType(value="void *") long column, @Nullable @NativeType(value="void *") ByteBuffer span) {
        ARBRobustness.nglGetnSeparableFilterARB(target, format, type, rowBufSize, row, columnBufSize, column, MemoryUtil.memAddressSafe(span));
    }

    public static void glGetnSeparableFilterARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer row, @NativeType(value="void *") ByteBuffer column, @Nullable @NativeType(value="void *") ByteBuffer span) {
        ARBRobustness.nglGetnSeparableFilterARB(target, format, type, row.remaining(), MemoryUtil.memAddress(row), column.remaining(), MemoryUtil.memAddress(column), MemoryUtil.memAddressSafe(span));
    }

    public static native void nglGetnHistogramARB(int var0, boolean var1, int var2, int var3, int var4, long var5);

    public static void glGetnHistogramARB(@NativeType(value="GLenum") int target, @NativeType(value="GLboolean") boolean reset, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long values) {
        ARBRobustness.nglGetnHistogramARB(target, reset, format, type, bufSize, values);
    }

    public static void glGetnHistogramARB(@NativeType(value="GLenum") int target, @NativeType(value="GLboolean") boolean reset, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer values) {
        ARBRobustness.nglGetnHistogramARB(target, reset, format, type, values.remaining(), MemoryUtil.memAddress(values));
    }

    public static native void nglGetnMinmaxARB(int var0, boolean var1, int var2, int var3, int var4, long var5);

    public static void glGetnMinmaxARB(@NativeType(value="GLenum") int target, @NativeType(value="GLboolean") boolean reset, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long values) {
        ARBRobustness.nglGetnMinmaxARB(target, reset, format, type, bufSize, values);
    }

    public static void glGetnMinmaxARB(@NativeType(value="GLenum") int target, @NativeType(value="GLboolean") boolean reset, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer values) {
        ARBRobustness.nglGetnMinmaxARB(target, reset, format, type, values.remaining(), MemoryUtil.memAddress(values));
    }

    public static native void nglGetnCompressedTexImageARB(int var0, int var1, int var2, long var3);

    public static void glGetnCompressedTexImageARB(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long img) {
        ARBRobustness.nglGetnCompressedTexImageARB(target, level, bufSize, img);
    }

    public static void glGetnCompressedTexImageARB(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="void *") ByteBuffer img) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)img, GL11.glGetTexLevelParameteri(target, level, 34464));
        }
        ARBRobustness.nglGetnCompressedTexImageARB(target, level, img.remaining(), MemoryUtil.memAddress(img));
    }

    public static native void nglGetnUniformfvARB(int var0, int var1, int var2, long var3);

    public static void glGetnUniformfvARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat *") FloatBuffer params) {
        ARBRobustness.nglGetnUniformfvARB(program, location, params.remaining(), MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetnUniformfARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer params = stack.callocFloat(1);
            ARBRobustness.nglGetnUniformfvARB(program, location, 1, MemoryUtil.memAddress(params));
            float f = params.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetnUniformivARB(int var0, int var1, int var2, long var3);

    public static void glGetnUniformivARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint *") IntBuffer params) {
        ARBRobustness.nglGetnUniformivARB(program, location, params.remaining(), MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetnUniformiARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            ARBRobustness.nglGetnUniformivARB(program, location, 1, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetnUniformuivARB(int var0, int var1, int var2, long var3);

    public static void glGetnUniformuivARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint *") IntBuffer params) {
        ARBRobustness.nglGetnUniformuivARB(program, location, params.remaining(), MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetnUniformuiARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            ARBRobustness.nglGetnUniformuivARB(program, location, 1, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetnUniformdvARB(int var0, int var1, int var2, long var3);

    public static void glGetnUniformdvARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble *") DoubleBuffer params) {
        ARBRobustness.nglGetnUniformdvARB(program, location, params.remaining(), MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static double glGetnUniformdARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            DoubleBuffer params = stack.callocDouble(1);
            ARBRobustness.nglGetnUniformdvARB(program, location, 1, MemoryUtil.memAddress(params));
            double d = params.get(0);
            return d;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glGetnMapdvARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query, @NativeType(value="GLdouble *") double[] data) {
        long __functionAddress = GL.getICD().glGetnMapdvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, query, data.length, data, __functionAddress);
    }

    public static void glGetnMapfvARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query, @NativeType(value="GLfloat *") float[] data) {
        long __functionAddress = GL.getICD().glGetnMapfvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, query, data.length, data, __functionAddress);
    }

    public static void glGetnMapivARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query, @NativeType(value="GLint *") int[] data) {
        long __functionAddress = GL.getICD().glGetnMapivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, query, data.length, data, __functionAddress);
    }

    public static void glGetnPixelMapfvARB(@NativeType(value="GLenum") int map, @NativeType(value="GLfloat *") float[] data) {
        long __functionAddress = GL.getICD().glGetnPixelMapfvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(map, data.length, data, __functionAddress);
    }

    public static void glGetnPixelMapuivARB(@NativeType(value="GLenum") int map, @NativeType(value="GLuint *") int[] data) {
        long __functionAddress = GL.getICD().glGetnPixelMapuivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(map, data.length, data, __functionAddress);
    }

    public static void glGetnPixelMapusvARB(@NativeType(value="GLenum") int map, @NativeType(value="GLushort *") short[] data) {
        long __functionAddress = GL.getICD().glGetnPixelMapusvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(map, data.length, data, __functionAddress);
    }

    public static void glGetnTexImageARB(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") short[] img) {
        long __functionAddress = GL.getICD().glGetnTexImageARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(tex, level, format, type, img.length << 1, img, __functionAddress);
    }

    public static void glGetnTexImageARB(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") int[] img) {
        long __functionAddress = GL.getICD().glGetnTexImageARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(tex, level, format, type, img.length << 2, img, __functionAddress);
    }

    public static void glGetnTexImageARB(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") float[] img) {
        long __functionAddress = GL.getICD().glGetnTexImageARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(tex, level, format, type, img.length << 2, img, __functionAddress);
    }

    public static void glGetnTexImageARB(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") double[] img) {
        long __functionAddress = GL.getICD().glGetnTexImageARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(tex, level, format, type, img.length << 3, img, __functionAddress);
    }

    public static void glReadnPixelsARB(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") short[] data) {
        long __functionAddress = GL.getICD().glReadnPixelsARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(x, y, width, height, format, type, data.length << 1, data, __functionAddress);
    }

    public static void glReadnPixelsARB(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") int[] data) {
        long __functionAddress = GL.getICD().glReadnPixelsARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(x, y, width, height, format, type, data.length << 2, data, __functionAddress);
    }

    public static void glReadnPixelsARB(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") float[] data) {
        long __functionAddress = GL.getICD().glReadnPixelsARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(x, y, width, height, format, type, data.length << 2, data, __functionAddress);
    }

    public static void glGetnColorTableARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") short[] table) {
        long __functionAddress = GL.getICD().glGetnColorTableARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, format, type, table.length << 1, table, __functionAddress);
    }

    public static void glGetnColorTableARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") int[] table) {
        long __functionAddress = GL.getICD().glGetnColorTableARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, format, type, table.length << 2, table, __functionAddress);
    }

    public static void glGetnColorTableARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") float[] table) {
        long __functionAddress = GL.getICD().glGetnColorTableARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, format, type, table.length << 2, table, __functionAddress);
    }

    public static void glGetnUniformfvARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetnUniformfvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, params.length, params, __functionAddress);
    }

    public static void glGetnUniformivARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetnUniformivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, params.length, params, __functionAddress);
    }

    public static void glGetnUniformuivARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint *") int[] params) {
        long __functionAddress = GL.getICD().glGetnUniformuivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, params.length, params, __functionAddress);
    }

    public static void glGetnUniformdvARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble *") double[] params) {
        long __functionAddress = GL.getICD().glGetnUniformdvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, params.length, params, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

