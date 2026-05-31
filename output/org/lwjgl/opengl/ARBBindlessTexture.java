/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.LongBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBBindlessTexture {
    public static final int GL_UNSIGNED_INT64_ARB = 5135;

    protected ARBBindlessTexture() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glGetTextureHandleARB, caps.glGetTextureSamplerHandleARB, caps.glMakeTextureHandleResidentARB, caps.glMakeTextureHandleNonResidentARB, caps.glGetImageHandleARB, caps.glMakeImageHandleResidentARB, caps.glMakeImageHandleNonResidentARB, caps.glUniformHandleui64ARB, caps.glUniformHandleui64vARB, caps.glProgramUniformHandleui64ARB, caps.glProgramUniformHandleui64vARB, caps.glIsTextureHandleResidentARB, caps.glIsImageHandleResidentARB, caps.glVertexAttribL1ui64ARB, caps.glVertexAttribL1ui64vARB, caps.glGetVertexAttribLui64vARB);
    }

    @NativeType(value="GLuint64")
    public static native long glGetTextureHandleARB(@NativeType(value="GLuint") int var0);

    @NativeType(value="GLuint64")
    public static native long glGetTextureSamplerHandleARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void glMakeTextureHandleResidentARB(@NativeType(value="GLuint64") long var0);

    public static native void glMakeTextureHandleNonResidentARB(@NativeType(value="GLuint64") long var0);

    @NativeType(value="GLuint64")
    public static native long glGetImageHandleARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLboolean") boolean var2, @NativeType(value="GLint") int var3, @NativeType(value="GLenum") int var4);

    public static native void glMakeImageHandleResidentARB(@NativeType(value="GLuint64") long var0, @NativeType(value="GLenum") int var2);

    public static native void glMakeImageHandleNonResidentARB(@NativeType(value="GLuint64") long var0);

    public static native void glUniformHandleui64ARB(@NativeType(value="GLint") int var0, @NativeType(value="GLuint64") long var1);

    public static native void nglUniformHandleui64vARB(int var0, int var1, long var2);

    public static void glUniformHandleui64vARB(@NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") LongBuffer values) {
        ARBBindlessTexture.nglUniformHandleui64vARB(location, values.remaining(), MemoryUtil.memAddress(values));
    }

    public static native void glProgramUniformHandleui64ARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint64") long var2);

    public static native void nglProgramUniformHandleui64vARB(int var0, int var1, int var2, long var3);

    public static void glProgramUniformHandleui64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") LongBuffer values) {
        ARBBindlessTexture.nglProgramUniformHandleui64vARB(program, location, values.remaining(), MemoryUtil.memAddress(values));
    }

    @NativeType(value="GLboolean")
    public static native boolean glIsTextureHandleResidentARB(@NativeType(value="GLuint64") long var0);

    @NativeType(value="GLboolean")
    public static native boolean glIsImageHandleResidentARB(@NativeType(value="GLuint64") long var0);

    public static native void glVertexAttribL1ui64ARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint64") long var1);

    public static native void nglVertexAttribL1ui64vARB(int var0, long var1);

    public static void glVertexAttribL1ui64vARB(@NativeType(value="GLuint") int index, @NativeType(value="GLuint64 const *") LongBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        ARBBindlessTexture.nglVertexAttribL1ui64vARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglGetVertexAttribLui64vARB(int var0, int var1, long var2);

    public static void glGetVertexAttribLui64vARB(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint64 *") LongBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        ARBBindlessTexture.nglGetVertexAttribLui64vARB(index, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetVertexAttribLui64ARB(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer params = stack.callocLong(1);
            ARBBindlessTexture.nglGetVertexAttribLui64vARB(index, pname, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glUniformHandleui64vARB(@NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") long[] values) {
        long __functionAddress = GL.getICD().glUniformHandleui64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, values.length, values, __functionAddress);
    }

    public static void glProgramUniformHandleui64vARB(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") long[] values) {
        long __functionAddress = GL.getICD().glProgramUniformHandleui64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, values.length, values, __functionAddress);
    }

    public static void glVertexAttribL1ui64vARB(@NativeType(value="GLuint") int index, @NativeType(value="GLuint64 const *") long[] v) {
        long __functionAddress = GL.getICD().glVertexAttribL1ui64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glGetVertexAttribLui64vARB(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint64 *") long[] params) {
        long __functionAddress = GL.getICD().glGetVertexAttribLui64vARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(index, pname, params, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

