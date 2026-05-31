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

public class EXTTimerQuery {
    public static final int GL_TIME_ELAPSED_EXT = 35007;

    protected EXTTimerQuery() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glGetQueryObjecti64vEXT, caps.glGetQueryObjectui64vEXT);
    }

    public static native void nglGetQueryObjecti64vEXT(int var0, int var1, long var2);

    public static void glGetQueryObjecti64vEXT(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") LongBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTTimerQuery.nglGetQueryObjecti64vEXT(id, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetQueryObjecti64EXT(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer params = stack.callocLong(1);
            EXTTimerQuery.nglGetQueryObjecti64vEXT(id, pname, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetQueryObjectui64vEXT(int var0, int var1, long var2);

    public static void glGetQueryObjectui64vEXT(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint64 *") LongBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTTimerQuery.nglGetQueryObjectui64vEXT(id, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetQueryObjectui64EXT(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer params = stack.callocLong(1);
            EXTTimerQuery.nglGetQueryObjectui64vEXT(id, pname, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glGetQueryObjecti64vEXT(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") long[] params) {
        long __functionAddress = GL.getICD().glGetQueryObjecti64vEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(id, pname, params, __functionAddress);
    }

    public static void glGetQueryObjectui64vEXT(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint64 *") long[] params) {
        long __functionAddress = GL.getICD().glGetQueryObjectui64vEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(id, pname, params, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

