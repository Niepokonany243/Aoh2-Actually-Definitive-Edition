/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL32C;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL33C
extends GL32C {
    public static final int GL_SRC1_COLOR = 35065;
    public static final int GL_ONE_MINUS_SRC1_COLOR = 35066;
    public static final int GL_ONE_MINUS_SRC1_ALPHA = 35067;
    public static final int GL_MAX_DUAL_SOURCE_DRAW_BUFFERS = 35068;
    public static final int GL_ANY_SAMPLES_PASSED = 35887;
    public static final int GL_SAMPLER_BINDING = 35097;
    public static final int GL_RGB10_A2UI = 36975;
    public static final int GL_TEXTURE_SWIZZLE_R = 36418;
    public static final int GL_TEXTURE_SWIZZLE_G = 36419;
    public static final int GL_TEXTURE_SWIZZLE_B = 36420;
    public static final int GL_TEXTURE_SWIZZLE_A = 36421;
    public static final int GL_TEXTURE_SWIZZLE_RGBA = 36422;
    public static final int GL_TIME_ELAPSED = 35007;
    public static final int GL_TIMESTAMP = 36392;
    public static final int GL_VERTEX_ATTRIB_ARRAY_DIVISOR = 35070;
    public static final int GL_INT_2_10_10_10_REV = 36255;

    protected GL33C() {
        throw new UnsupportedOperationException();
    }

    public static native void nglBindFragDataLocationIndexed(int var0, int var1, int var2, long var3);

    public static void glBindFragDataLocationIndexed(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int colorNumber, @NativeType(value="GLuint") int index, @NativeType(value="GLchar const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        GL33C.nglBindFragDataLocationIndexed(program, colorNumber, index, MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glBindFragDataLocationIndexed(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int colorNumber, @NativeType(value="GLuint") int index, @NativeType(value="GLchar const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(name, true);
            long nameEncoded = stack.getPointerAddress();
            GL33C.nglBindFragDataLocationIndexed(program, colorNumber, index, nameEncoded);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native int nglGetFragDataIndex(int var0, long var1);

    @NativeType(value="GLint")
    public static int glGetFragDataIndex(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return GL33C.nglGetFragDataIndex(program, MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLint")
    public static int glGetFragDataIndex(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(name, true);
            long nameEncoded = stack.getPointerAddress();
            int n = GL33C.nglGetFragDataIndex(program, nameEncoded);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGenSamplers(int var0, long var1);

    public static void glGenSamplers(@NativeType(value="GLuint *") IntBuffer samplers) {
        GL33C.nglGenSamplers(samplers.remaining(), MemoryUtil.memAddress(samplers));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGenSamplers() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer samplers = stack.callocInt(1);
            GL33C.nglGenSamplers(1, MemoryUtil.memAddress(samplers));
            int n = samplers.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglDeleteSamplers(int var0, long var1);

    public static void glDeleteSamplers(@NativeType(value="GLuint const *") IntBuffer samplers) {
        GL33C.nglDeleteSamplers(samplers.remaining(), MemoryUtil.memAddress(samplers));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDeleteSamplers(@NativeType(value="GLuint const *") int sampler) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer samplers = stack.ints(sampler);
            GL33C.nglDeleteSamplers(1, MemoryUtil.memAddress(samplers));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="GLboolean")
    public static native boolean glIsSampler(@NativeType(value="GLuint") int var0);

    public static native void glBindSampler(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void glSamplerParameteri(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2);

    public static native void glSamplerParameterf(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLfloat") float var2);

    public static native void nglSamplerParameteriv(int var0, int var1, long var2);

    public static void glSamplerParameteriv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL33C.nglSamplerParameteriv(sampler, pname, MemoryUtil.memAddress(params));
    }

    public static native void nglSamplerParameterfv(int var0, int var1, long var2);

    public static void glSamplerParameterfv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL33C.nglSamplerParameterfv(sampler, pname, MemoryUtil.memAddress(params));
    }

    public static native void nglSamplerParameterIiv(int var0, int var1, long var2);

    public static void glSamplerParameterIiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL33C.nglSamplerParameterIiv(sampler, pname, MemoryUtil.memAddress(params));
    }

    public static native void nglSamplerParameterIuiv(int var0, int var1, long var2);

    public static void glSamplerParameterIuiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL33C.nglSamplerParameterIuiv(sampler, pname, MemoryUtil.memAddress(params));
    }

    public static native void nglGetSamplerParameteriv(int var0, int var1, long var2);

    public static void glGetSamplerParameteriv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL33C.nglGetSamplerParameteriv(sampler, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetSamplerParameteri(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL33C.nglGetSamplerParameteriv(sampler, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetSamplerParameterfv(int var0, int var1, long var2);

    public static void glGetSamplerParameterfv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL33C.nglGetSamplerParameterfv(sampler, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetSamplerParameterf(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer params = stack.callocFloat(1);
            GL33C.nglGetSamplerParameterfv(sampler, pname, MemoryUtil.memAddress(params));
            float f = params.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetSamplerParameterIiv(int var0, int var1, long var2);

    public static void glGetSamplerParameterIiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL33C.nglGetSamplerParameterIiv(sampler, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetSamplerParameterIi(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL33C.nglGetSamplerParameterIiv(sampler, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetSamplerParameterIuiv(int var0, int var1, long var2);

    public static void glGetSamplerParameterIuiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL33C.nglGetSamplerParameterIuiv(sampler, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetSamplerParameterIui(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL33C.nglGetSamplerParameterIuiv(sampler, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glQueryCounter(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void nglGetQueryObjecti64v(int var0, int var1, long var2);

    public static void glGetQueryObjecti64v(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") LongBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL33C.nglGetQueryObjecti64v(id, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetQueryObjecti64(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer params = stack.callocLong(1);
            GL33C.nglGetQueryObjecti64v(id, pname, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetQueryObjectui64v(int var0, int var1, long var2);

    public static void glGetQueryObjectui64v(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint64 *") LongBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL33C.nglGetQueryObjectui64v(id, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetQueryObjectui64(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer params = stack.callocLong(1);
            GL33C.nglGetQueryObjectui64v(id, pname, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glVertexAttribDivisor(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void glVertexAttribP1ui(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLboolean") boolean var2, @NativeType(value="GLuint") int var3);

    public static native void glVertexAttribP2ui(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLboolean") boolean var2, @NativeType(value="GLuint") int var3);

    public static native void glVertexAttribP3ui(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLboolean") boolean var2, @NativeType(value="GLuint") int var3);

    public static native void glVertexAttribP4ui(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLboolean") boolean var2, @NativeType(value="GLuint") int var3);

    public static native void nglVertexAttribP1uiv(int var0, int var1, boolean var2, long var3);

    public static void glVertexAttribP1uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        GL33C.nglVertexAttribP1uiv(index, type, normalized, MemoryUtil.memAddress(value));
    }

    public static native void nglVertexAttribP2uiv(int var0, int var1, boolean var2, long var3);

    public static void glVertexAttribP2uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        GL33C.nglVertexAttribP2uiv(index, type, normalized, MemoryUtil.memAddress(value));
    }

    public static native void nglVertexAttribP3uiv(int var0, int var1, boolean var2, long var3);

    public static void glVertexAttribP3uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        GL33C.nglVertexAttribP3uiv(index, type, normalized, MemoryUtil.memAddress(value));
    }

    public static native void nglVertexAttribP4uiv(int var0, int var1, boolean var2, long var3);

    public static void glVertexAttribP4uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        GL33C.nglVertexAttribP4uiv(index, type, normalized, MemoryUtil.memAddress(value));
    }

    public static void glGenSamplers(@NativeType(value="GLuint *") int[] samplers) {
        long __functionAddress = GL.getICD().glGenSamplers;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(samplers.length, samplers, __functionAddress);
    }

    public static void glDeleteSamplers(@NativeType(value="GLuint const *") int[] samplers) {
        long __functionAddress = GL.getICD().glDeleteSamplers;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(samplers.length, samplers, __functionAddress);
    }

    public static void glSamplerParameteriv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = GL.getICD().glSamplerParameteriv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(sampler, pname, params, __functionAddress);
    }

    public static void glSamplerParameterfv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] params) {
        long __functionAddress = GL.getICD().glSamplerParameterfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(sampler, pname, params, __functionAddress);
    }

    public static void glSamplerParameterIiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = GL.getICD().glSamplerParameterIiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(sampler, pname, params, __functionAddress);
    }

    public static void glSamplerParameterIuiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint const *") int[] params) {
        long __functionAddress = GL.getICD().glSamplerParameterIuiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(sampler, pname, params, __functionAddress);
    }

    public static void glGetSamplerParameteriv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetSamplerParameteriv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(sampler, pname, params, __functionAddress);
    }

    public static void glGetSamplerParameterfv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetSamplerParameterfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(sampler, pname, params, __functionAddress);
    }

    public static void glGetSamplerParameterIiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetSamplerParameterIiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(sampler, pname, params, __functionAddress);
    }

    public static void glGetSamplerParameterIuiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") int[] params) {
        long __functionAddress = GL.getICD().glGetSamplerParameterIuiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(sampler, pname, params, __functionAddress);
    }

    public static void glGetQueryObjecti64v(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") long[] params) {
        long __functionAddress = GL.getICD().glGetQueryObjecti64v;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(id, pname, params, __functionAddress);
    }

    public static void glGetQueryObjectui64v(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint64 *") long[] params) {
        long __functionAddress = GL.getICD().glGetQueryObjectui64v;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(id, pname, params, __functionAddress);
    }

    public static void glVertexAttribP1uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glVertexAttribP1uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(value, 1);
        }
        JNI.callPV(index, type, normalized, value, __functionAddress);
    }

    public static void glVertexAttribP2uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glVertexAttribP2uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(value, 1);
        }
        JNI.callPV(index, type, normalized, value, __functionAddress);
    }

    public static void glVertexAttribP3uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glVertexAttribP3uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(value, 1);
        }
        JNI.callPV(index, type, normalized, value, __functionAddress);
    }

    public static void glVertexAttribP4uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glVertexAttribP4uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(value, 1);
        }
        JNI.callPV(index, type, normalized, value, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

