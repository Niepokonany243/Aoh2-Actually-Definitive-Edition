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

public class NVShaderBufferLoad {
    public static final int GL_BUFFER_GPU_ADDRESS_NV = 36637;
    public static final int GL_GPU_ADDRESS_NV = 36660;
    public static final int GL_MAX_SHADER_BUFFER_ADDRESS_NV = 36661;

    protected NVShaderBufferLoad() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glMakeBufferResidentNV, caps.glMakeBufferNonResidentNV, caps.glIsBufferResidentNV, caps.glMakeNamedBufferResidentNV, caps.glMakeNamedBufferNonResidentNV, caps.glIsNamedBufferResidentNV, caps.glGetBufferParameterui64vNV, caps.glGetNamedBufferParameterui64vNV, caps.glGetIntegerui64vNV, caps.glUniformui64NV, caps.glUniformui64vNV, caps.glGetUniformui64vNV, caps.glProgramUniformui64NV, caps.glProgramUniformui64vNV);
    }

    public static native void glMakeBufferResidentNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1);

    public static native void glMakeBufferNonResidentNV(@NativeType(value="GLenum") int var0);

    @NativeType(value="GLboolean")
    public static native boolean glIsBufferResidentNV(@NativeType(value="GLenum") int var0);

    public static native void glMakeNamedBufferResidentNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void glMakeNamedBufferNonResidentNV(@NativeType(value="GLuint") int var0);

    @NativeType(value="GLboolean")
    public static native boolean glIsNamedBufferResidentNV(@NativeType(value="GLuint") int var0);

    public static native void nglGetBufferParameterui64vNV(int var0, int var1, long var2);

    public static void glGetBufferParameterui64vNV(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint64EXT *") LongBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        NVShaderBufferLoad.nglGetBufferParameterui64vNV(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetBufferParameterui64NV(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer params = stack.callocLong(1);
            NVShaderBufferLoad.nglGetBufferParameterui64vNV(target, pname, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetNamedBufferParameterui64vNV(int var0, int var1, long var2);

    public static void glGetNamedBufferParameterui64vNV(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint64EXT *") LongBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        NVShaderBufferLoad.nglGetNamedBufferParameterui64vNV(buffer, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetNamedBufferParameterui64NV(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer params = stack.callocLong(1);
            NVShaderBufferLoad.nglGetNamedBufferParameterui64vNV(buffer, pname, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetIntegerui64vNV(int var0, long var1);

    public static void glGetIntegerui64vNV(@NativeType(value="GLenum") int value, @NativeType(value="GLuint64EXT *") LongBuffer result) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)result, 1);
        }
        NVShaderBufferLoad.nglGetIntegerui64vNV(value, MemoryUtil.memAddress(result));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetIntegerui64NV(@NativeType(value="GLenum") int value) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer result = stack.callocLong(1);
            NVShaderBufferLoad.nglGetIntegerui64vNV(value, MemoryUtil.memAddress(result));
            long l = result.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glUniformui64NV(@NativeType(value="GLint") int var0, @NativeType(value="GLuint64EXT") long var1);

    public static native void nglUniformui64vNV(int var0, int var1, long var2);

    public static void glUniformui64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") LongBuffer value) {
        NVShaderBufferLoad.nglUniformui64vNV(location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void nglGetUniformui64vNV(int var0, int var1, long var2);

    public static void glGetUniformui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT *") LongBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        NVShaderBufferLoad.nglGetUniformui64vNV(program, location, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetUniformui64NV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer params = stack.callocLong(1);
            NVShaderBufferLoad.nglGetUniformui64vNV(program, location, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glProgramUniformui64NV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint64EXT") long var2);

    public static native void nglProgramUniformui64vNV(int var0, int var1, int var2, long var3);

    public static void glProgramUniformui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") LongBuffer value) {
        NVShaderBufferLoad.nglProgramUniformui64vNV(program, location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static void glGetBufferParameterui64vNV(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint64EXT *") long[] params) {
        long __functionAddress = GL.getICD().glGetBufferParameterui64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glGetNamedBufferParameterui64vNV(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint64EXT *") long[] params) {
        long __functionAddress = GL.getICD().glGetNamedBufferParameterui64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(buffer, pname, params, __functionAddress);
    }

    public static void glGetIntegerui64vNV(@NativeType(value="GLenum") int value, @NativeType(value="GLuint64EXT *") long[] result) {
        long __functionAddress = GL.getICD().glGetIntegerui64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(result, 1);
        }
        JNI.callPV(value, result, __functionAddress);
    }

    public static void glUniformui64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") long[] value) {
        long __functionAddress = GL.getICD().glUniformui64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length, value, __functionAddress);
    }

    public static void glGetUniformui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT *") long[] params) {
        long __functionAddress = GL.getICD().glGetUniformui64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(program, location, params, __functionAddress);
    }

    public static void glProgramUniformui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64EXT const *") long[] value) {
        long __functionAddress = GL.getICD().glProgramUniformui64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length, value, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

