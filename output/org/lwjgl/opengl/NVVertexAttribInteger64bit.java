/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.LongBuffer;
import java.util.Set;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVVertexAttribInteger64bit {
    public static final int GL_INT64_NV = 5134;
    public static final int GL_UNSIGNED_INT64_NV = 5135;

    protected NVVertexAttribInteger64bit() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, Set<String> ext) {
        return Checks.checkFunctions(caps.glVertexAttribL1i64NV, caps.glVertexAttribL2i64NV, caps.glVertexAttribL3i64NV, caps.glVertexAttribL4i64NV, caps.glVertexAttribL1i64vNV, caps.glVertexAttribL2i64vNV, caps.glVertexAttribL3i64vNV, caps.glVertexAttribL4i64vNV, caps.glVertexAttribL1ui64NV, caps.glVertexAttribL2ui64NV, caps.glVertexAttribL3ui64NV, caps.glVertexAttribL4ui64NV, caps.glVertexAttribL1ui64vNV, caps.glVertexAttribL2ui64vNV, caps.glVertexAttribL3ui64vNV, caps.glVertexAttribL4ui64vNV, caps.glGetVertexAttribLi64vNV, caps.glGetVertexAttribLui64vNV, ext.contains("GL_NV_vertex_buffer_unified_memory") ? caps.glVertexAttribLFormatNV : -1L);
    }

    public static native void glVertexAttribL1i64NV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint64EXT") long var1);

    public static native void glVertexAttribL2i64NV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint64EXT") long var1, @NativeType(value="GLint64EXT") long var3);

    public static native void glVertexAttribL3i64NV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint64EXT") long var1, @NativeType(value="GLint64EXT") long var3, @NativeType(value="GLint64EXT") long var5);

    public static native void glVertexAttribL4i64NV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint64EXT") long var1, @NativeType(value="GLint64EXT") long var3, @NativeType(value="GLint64EXT") long var5, @NativeType(value="GLint64EXT") long var7);

    public static native void nglVertexAttribL1i64vNV(int var0, long var1);

    public static void glVertexAttribL1i64vNV(@NativeType(value="GLuint") int index, @NativeType(value="GLint64EXT const *") LongBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        NVVertexAttribInteger64bit.nglVertexAttribL1i64vNV(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribL2i64vNV(int var0, long var1);

    public static void glVertexAttribL2i64vNV(@NativeType(value="GLuint") int index, @NativeType(value="GLint64EXT const *") LongBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        NVVertexAttribInteger64bit.nglVertexAttribL2i64vNV(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribL3i64vNV(int var0, long var1);

    public static void glVertexAttribL3i64vNV(@NativeType(value="GLuint") int index, @NativeType(value="GLint64EXT const *") LongBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        NVVertexAttribInteger64bit.nglVertexAttribL3i64vNV(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribL4i64vNV(int var0, long var1);

    public static void glVertexAttribL4i64vNV(@NativeType(value="GLuint") int index, @NativeType(value="GLint64EXT const *") LongBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        NVVertexAttribInteger64bit.nglVertexAttribL4i64vNV(index, MemoryUtil.memAddress(v));
    }

    public static native void glVertexAttribL1ui64NV(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint64EXT") long var1);

    public static native void glVertexAttribL2ui64NV(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint64EXT") long var1, @NativeType(value="GLuint64EXT") long var3);

    public static native void glVertexAttribL3ui64NV(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint64EXT") long var1, @NativeType(value="GLuint64EXT") long var3, @NativeType(value="GLuint64EXT") long var5);

    public static native void glVertexAttribL4ui64NV(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint64EXT") long var1, @NativeType(value="GLuint64EXT") long var3, @NativeType(value="GLuint64EXT") long var5, @NativeType(value="GLuint64EXT") long var7);

    public static native void nglVertexAttribL1ui64vNV(int var0, long var1);

    public static void glVertexAttribL1ui64vNV(@NativeType(value="GLuint") int index, @NativeType(value="GLuint64EXT const *") LongBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        NVVertexAttribInteger64bit.nglVertexAttribL1ui64vNV(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribL2ui64vNV(int var0, long var1);

    public static void glVertexAttribL2ui64vNV(@NativeType(value="GLuint") int index, @NativeType(value="GLuint64EXT const *") LongBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        NVVertexAttribInteger64bit.nglVertexAttribL2ui64vNV(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribL3ui64vNV(int var0, long var1);

    public static void glVertexAttribL3ui64vNV(@NativeType(value="GLuint") int index, @NativeType(value="GLuint64EXT const *") LongBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        NVVertexAttribInteger64bit.nglVertexAttribL3ui64vNV(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribL4ui64vNV(int var0, long var1);

    public static void glVertexAttribL4ui64vNV(@NativeType(value="GLuint") int index, @NativeType(value="GLuint64EXT const *") LongBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        NVVertexAttribInteger64bit.nglVertexAttribL4ui64vNV(index, MemoryUtil.memAddress(v));
    }

    public static native void nglGetVertexAttribLi64vNV(int var0, int var1, long var2);

    public static void glGetVertexAttribLi64vNV(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64EXT *") LongBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        NVVertexAttribInteger64bit.nglGetVertexAttribLi64vNV(index, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetVertexAttribLi64NV(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer params = stack.callocLong(1);
            NVVertexAttribInteger64bit.nglGetVertexAttribLi64vNV(index, pname, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetVertexAttribLui64vNV(int var0, int var1, long var2);

    public static void glGetVertexAttribLui64vNV(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint64EXT *") LongBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        NVVertexAttribInteger64bit.nglGetVertexAttribLui64vNV(index, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetVertexAttribLui64NV(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer params = stack.callocLong(1);
            NVVertexAttribInteger64bit.nglGetVertexAttribLui64vNV(index, pname, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glVertexAttribLFormatNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3);

    public static void glVertexAttribL1i64vNV(@NativeType(value="GLuint") int index, @NativeType(value="GLint64EXT const *") long[] v) {
        long __functionAddress = GL.getICD().glVertexAttribL1i64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribL2i64vNV(@NativeType(value="GLuint") int index, @NativeType(value="GLint64EXT const *") long[] v) {
        long __functionAddress = GL.getICD().glVertexAttribL2i64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribL3i64vNV(@NativeType(value="GLuint") int index, @NativeType(value="GLint64EXT const *") long[] v) {
        long __functionAddress = GL.getICD().glVertexAttribL3i64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribL4i64vNV(@NativeType(value="GLuint") int index, @NativeType(value="GLint64EXT const *") long[] v) {
        long __functionAddress = GL.getICD().glVertexAttribL4i64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribL1ui64vNV(@NativeType(value="GLuint") int index, @NativeType(value="GLuint64EXT const *") long[] v) {
        long __functionAddress = GL.getICD().glVertexAttribL1ui64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribL2ui64vNV(@NativeType(value="GLuint") int index, @NativeType(value="GLuint64EXT const *") long[] v) {
        long __functionAddress = GL.getICD().glVertexAttribL2ui64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribL3ui64vNV(@NativeType(value="GLuint") int index, @NativeType(value="GLuint64EXT const *") long[] v) {
        long __functionAddress = GL.getICD().glVertexAttribL3ui64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribL4ui64vNV(@NativeType(value="GLuint") int index, @NativeType(value="GLuint64EXT const *") long[] v) {
        long __functionAddress = GL.getICD().glVertexAttribL4ui64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glGetVertexAttribLi64vNV(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64EXT *") long[] params) {
        long __functionAddress = GL.getICD().glGetVertexAttribLi64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(index, pname, params, __functionAddress);
    }

    public static void glGetVertexAttribLui64vNV(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint64EXT *") long[] params) {
        long __functionAddress = GL.getICD().glGetVertexAttribLui64vNV;
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

