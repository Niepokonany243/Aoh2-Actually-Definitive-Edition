/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVQueryResourceTag {
    protected NVQueryResourceTag() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glGenQueryResourceTagNV, caps.glDeleteQueryResourceTagNV, caps.glQueryResourceTagNV);
    }

    public static native void nglGenQueryResourceTagNV(int var0, long var1);

    public static void glGenQueryResourceTagNV(@NativeType(value="GLuint *") IntBuffer tagIds) {
        NVQueryResourceTag.nglGenQueryResourceTagNV(tagIds.remaining(), MemoryUtil.memAddress(tagIds));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGenQueryResourceTagNV() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer tagIds = stack.callocInt(1);
            NVQueryResourceTag.nglGenQueryResourceTagNV(1, MemoryUtil.memAddress(tagIds));
            int n = tagIds.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglDeleteQueryResourceTagNV(int var0, long var1);

    public static void glDeleteQueryResourceTagNV(@NativeType(value="GLuint const *") IntBuffer tagIds) {
        NVQueryResourceTag.nglDeleteQueryResourceTagNV(tagIds.remaining(), MemoryUtil.memAddress(tagIds));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDeleteQueryResourceTagNV(@NativeType(value="GLuint const *") int tagId) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer tagIds = stack.ints(tagId);
            NVQueryResourceTag.nglDeleteQueryResourceTagNV(1, MemoryUtil.memAddress(tagIds));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglQueryResourceTagNV(int var0, long var1);

    public static void glQueryResourceTagNV(@NativeType(value="GLuint") int tagId, @NativeType(value="GLchar const *") ByteBuffer tagString) {
        if (Checks.CHECKS) {
            Checks.checkNT1(tagString);
        }
        NVQueryResourceTag.nglQueryResourceTagNV(tagId, MemoryUtil.memAddress(tagString));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glQueryResourceTagNV(@NativeType(value="GLuint") int tagId, @NativeType(value="GLchar const *") CharSequence tagString) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(tagString, true);
            long tagStringEncoded = stack.getPointerAddress();
            NVQueryResourceTag.nglQueryResourceTagNV(tagId, tagStringEncoded);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glGenQueryResourceTagNV(@NativeType(value="GLuint *") int[] tagIds) {
        long __functionAddress = GL.getICD().glGenQueryResourceTagNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(tagIds.length, tagIds, __functionAddress);
    }

    public static void glDeleteQueryResourceTagNV(@NativeType(value="GLuint const *") int[] tagIds) {
        long __functionAddress = GL.getICD().glDeleteQueryResourceTagNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(tagIds.length, tagIds, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

