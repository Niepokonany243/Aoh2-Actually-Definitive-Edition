/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTDrawBuffers2 {
    protected EXTDrawBuffers2() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glColorMaskIndexedEXT, caps.glGetBooleanIndexedvEXT, caps.glGetIntegerIndexedvEXT, caps.glEnableIndexedEXT, caps.glDisableIndexedEXT, caps.glIsEnabledIndexedEXT);
    }

    public static native void glColorMaskIndexedEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLboolean") boolean var1, @NativeType(value="GLboolean") boolean var2, @NativeType(value="GLboolean") boolean var3, @NativeType(value="GLboolean") boolean var4);

    public static native void nglGetBooleanIndexedvEXT(int var0, int var1, long var2);

    public static void glGetBooleanIndexedvEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLboolean *") ByteBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 1);
        }
        EXTDrawBuffers2.nglGetBooleanIndexedvEXT(target, index, MemoryUtil.memAddress(data));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static boolean glGetBooleanIndexedEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            ByteBuffer data = stack.calloc(1);
            EXTDrawBuffers2.nglGetBooleanIndexedvEXT(target, index, MemoryUtil.memAddress(data));
            boolean bl = data.get(0) != 0;
            return bl;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetIntegerIndexedvEXT(int var0, int var1, long var2);

    public static void glGetIntegerIndexedvEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") IntBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 1);
        }
        EXTDrawBuffers2.nglGetIntegerIndexedvEXT(target, index, MemoryUtil.memAddress(data));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetIntegerIndexedEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer data = stack.callocInt(1);
            EXTDrawBuffers2.nglGetIntegerIndexedvEXT(target, index, MemoryUtil.memAddress(data));
            int n = data.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glEnableIndexedEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glDisableIndexedEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    @NativeType(value="GLboolean")
    public static native boolean glIsEnabledIndexedEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static void glGetIntegerIndexedvEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") int[] data) {
        long __functionAddress = GL.getICD().glGetIntegerIndexedvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(data, 1);
        }
        JNI.callPV(target, index, data, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

