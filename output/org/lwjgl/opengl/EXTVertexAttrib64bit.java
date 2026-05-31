/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.util.Set;
import org.lwjgl.opengl.ARBVertexAttrib64Bit;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTVertexAttrib64bit {
    public static final int GL_DOUBLE_VEC2_EXT = 36860;
    public static final int GL_DOUBLE_VEC3_EXT = 36861;
    public static final int GL_DOUBLE_VEC4_EXT = 36862;
    public static final int GL_DOUBLE_MAT2_EXT = 36678;
    public static final int GL_DOUBLE_MAT3_EXT = 36679;
    public static final int GL_DOUBLE_MAT4_EXT = 36680;
    public static final int GL_DOUBLE_MAT2x3_EXT = 36681;
    public static final int GL_DOUBLE_MAT2x4_EXT = 36682;
    public static final int GL_DOUBLE_MAT3x2_EXT = 36683;
    public static final int GL_DOUBLE_MAT3x4_EXT = 36684;
    public static final int GL_DOUBLE_MAT4x2_EXT = 36685;
    public static final int GL_DOUBLE_MAT4x3_EXT = 36686;

    protected EXTVertexAttrib64bit() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, Set<String> ext) {
        return Checks.checkFunctions(caps.glVertexAttribL1dEXT, caps.glVertexAttribL2dEXT, caps.glVertexAttribL3dEXT, caps.glVertexAttribL4dEXT, caps.glVertexAttribL1dvEXT, caps.glVertexAttribL2dvEXT, caps.glVertexAttribL3dvEXT, caps.glVertexAttribL4dvEXT, caps.glVertexAttribLPointerEXT, caps.glGetVertexAttribLdvEXT, ext.contains("GL_EXT_direct_state_access") ? caps.glVertexArrayVertexAttribLOffsetEXT : -1L);
    }

    public static native void glVertexAttribL1dEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLdouble") double var1);

    public static native void glVertexAttribL2dEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3);

    public static native void glVertexAttribL3dEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5);

    public static native void glVertexAttribL4dEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5, @NativeType(value="GLdouble") double var7);

    public static native void nglVertexAttribL1dvEXT(int var0, long var1);

    public static void glVertexAttribL1dvEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        EXTVertexAttrib64bit.nglVertexAttribL1dvEXT(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribL2dvEXT(int var0, long var1);

    public static void glVertexAttribL2dvEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        EXTVertexAttrib64bit.nglVertexAttribL2dvEXT(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribL3dvEXT(int var0, long var1);

    public static void glVertexAttribL3dvEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        EXTVertexAttrib64bit.nglVertexAttribL3dvEXT(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribL4dvEXT(int var0, long var1);

    public static void glVertexAttribL4dvEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        EXTVertexAttrib64bit.nglVertexAttribL4dvEXT(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribLPointerEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glVertexAttribLPointerEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ByteBuffer pointer) {
        EXTVertexAttrib64bit.nglVertexAttribLPointerEXT(index, size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glVertexAttribLPointerEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") long pointer) {
        EXTVertexAttrib64bit.nglVertexAttribLPointerEXT(index, size, type, stride, pointer);
    }

    public static void glVertexAttribLPointerEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") DoubleBuffer pointer) {
        EXTVertexAttrib64bit.nglVertexAttribLPointerEXT(index, size, 5130, stride, MemoryUtil.memAddress(pointer));
    }

    public static native void nglGetVertexAttribLdvEXT(int var0, int var1, long var2);

    public static void glGetVertexAttribLdvEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLdouble *") DoubleBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        EXTVertexAttrib64bit.nglGetVertexAttribLdvEXT(index, pname, MemoryUtil.memAddress(params));
    }

    public static void glVertexArrayVertexAttribLOffsetEXT(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int buffer, @NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="GLintptr") long offset) {
        ARBVertexAttrib64Bit.glVertexArrayVertexAttribLOffsetEXT(vaobj, buffer, index, size, type, stride, offset);
    }

    public static void glVertexAttribL1dvEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glVertexAttribL1dvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribL2dvEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glVertexAttribL2dvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribL3dvEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glVertexAttribL3dvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribL4dvEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glVertexAttribL4dvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glGetVertexAttribLdvEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLdouble *") double[] params) {
        long __functionAddress = GL.getICD().glGetVertexAttribLdvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(index, pname, params, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

