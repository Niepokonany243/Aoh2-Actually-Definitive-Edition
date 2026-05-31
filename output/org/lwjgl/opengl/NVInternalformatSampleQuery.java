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

public class NVInternalformatSampleQuery {
    public static final int GL_MULTISAMPLES_NV = 37745;
    public static final int GL_SUPERSAMPLE_SCALE_X_NV = 37746;
    public static final int GL_SUPERSAMPLE_SCALE_Y_NV = 37747;
    public static final int GL_CONFORMANT_NV = 37748;

    protected NVInternalformatSampleQuery() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glGetInternalformatSampleivNV);
    }

    public static native void nglGetInternalformatSampleivNV(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glGetInternalformatSampleivNV(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int samples, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        NVInternalformatSampleQuery.nglGetInternalformatSampleivNV(target, internalformat, samples, pname, params.remaining(), MemoryUtil.memAddress(params));
    }

    public static void glGetInternalformatSampleivNV(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int samples, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetInternalformatSampleivNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, internalformat, samples, pname, params.length, params, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

