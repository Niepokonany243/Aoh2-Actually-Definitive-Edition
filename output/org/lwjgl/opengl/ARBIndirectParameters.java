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
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBIndirectParameters {
    public static final int GL_PARAMETER_BUFFER_ARB = 33006;
    public static final int GL_PARAMETER_BUFFER_BINDING_ARB = 33007;

    protected ARBIndirectParameters() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glMultiDrawArraysIndirectCountARB, caps.glMultiDrawElementsIndirectCountARB);
    }

    public static native void nglMultiDrawArraysIndirectCountARB(int var0, long var1, long var3, int var5, int var6);

    public static void glMultiDrawArraysIndirectCountARB(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ByteBuffer indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)indirect, maxdrawcount * (stride == 0 ? 16 : stride));
        }
        ARBIndirectParameters.nglMultiDrawArraysIndirectCountARB(mode, MemoryUtil.memAddress(indirect), drawcount, maxdrawcount, stride);
    }

    public static void glMultiDrawArraysIndirectCountARB(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") long indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        ARBIndirectParameters.nglMultiDrawArraysIndirectCountARB(mode, indirect, drawcount, maxdrawcount, stride);
    }

    public static void glMultiDrawArraysIndirectCountARB(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") IntBuffer indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)indirect, maxdrawcount * (stride == 0 ? 16 : stride) >> 2);
        }
        ARBIndirectParameters.nglMultiDrawArraysIndirectCountARB(mode, MemoryUtil.memAddress(indirect), drawcount, maxdrawcount, stride);
    }

    public static native void nglMultiDrawElementsIndirectCountARB(int var0, int var1, long var2, long var4, int var6, int var7);

    public static void glMultiDrawElementsIndirectCountARB(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)indirect, maxdrawcount * (stride == 0 ? 20 : stride));
        }
        ARBIndirectParameters.nglMultiDrawElementsIndirectCountARB(mode, type, MemoryUtil.memAddress(indirect), drawcount, maxdrawcount, stride);
    }

    public static void glMultiDrawElementsIndirectCountARB(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        ARBIndirectParameters.nglMultiDrawElementsIndirectCountARB(mode, type, indirect, drawcount, maxdrawcount, stride);
    }

    public static void glMultiDrawElementsIndirectCountARB(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)indirect, maxdrawcount * (stride == 0 ? 20 : stride) >> 2);
        }
        ARBIndirectParameters.nglMultiDrawElementsIndirectCountARB(mode, type, MemoryUtil.memAddress(indirect), drawcount, maxdrawcount, stride);
    }

    public static void glMultiDrawArraysIndirectCountARB(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") int[] indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        long __functionAddress = GL.getICD().glMultiDrawArraysIndirectCountARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(indirect, maxdrawcount * (stride == 0 ? 16 : stride) >> 2);
        }
        JNI.callPPV(mode, indirect, drawcount, maxdrawcount, stride, __functionAddress);
    }

    public static void glMultiDrawElementsIndirectCountARB(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        long __functionAddress = GL.getICD().glMultiDrawElementsIndirectCountARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(indirect, maxdrawcount * (stride == 0 ? 20 : stride) >> 2);
        }
        JNI.callPPV(mode, type, indirect, drawcount, maxdrawcount, stride, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

