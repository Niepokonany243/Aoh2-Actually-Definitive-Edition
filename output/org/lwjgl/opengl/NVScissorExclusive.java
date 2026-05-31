/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVScissorExclusive {
    public static final int GL_SCISSOR_TEST_EXCLUSIVE_NV = 38229;
    public static final int GL_SCISSOR_BOX_EXCLUSIVE_NV = 38230;

    protected NVScissorExclusive() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glScissorExclusiveArrayvNV, caps.glScissorExclusiveNV);
    }

    public static native void nglScissorExclusiveArrayvNV(int var0, int var1, long var2);

    public static void glScissorExclusiveArrayvNV(@NativeType(value="GLuint") int first, @NativeType(value="GLint const *") IntBuffer v) {
        NVScissorExclusive.nglScissorExclusiveArrayvNV(first, v.remaining() >> 2, MemoryUtil.memAddress(v));
    }

    public static native void glScissorExclusiveNV(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLsizei") int var2, @NativeType(value="GLsizei") int var3);

    public static void glScissorExclusiveArrayvNV(@NativeType(value="GLuint") int first, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glScissorExclusiveArrayvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(first, v.length >> 2, v, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

