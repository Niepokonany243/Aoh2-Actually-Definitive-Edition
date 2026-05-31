/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.LongBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVBindlessTexture {
    protected NVBindlessTexture() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glGetTextureHandleNV, caps.glGetTextureSamplerHandleNV, caps.glMakeTextureHandleResidentNV, caps.glMakeTextureHandleNonResidentNV, caps.glGetImageHandleNV, caps.glMakeImageHandleResidentNV, caps.glMakeImageHandleNonResidentNV, caps.glUniformHandleui64NV, caps.glUniformHandleui64vNV, caps.glProgramUniformHandleui64NV, caps.glProgramUniformHandleui64vNV, caps.glIsTextureHandleResidentNV, caps.glIsImageHandleResidentNV);
    }

    @NativeType(value="GLuint64")
    public static native long glGetTextureHandleNV(@NativeType(value="GLuint") int var0);

    @NativeType(value="GLuint64")
    public static native long glGetTextureSamplerHandleNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void glMakeTextureHandleResidentNV(@NativeType(value="GLuint64") long var0);

    public static native void glMakeTextureHandleNonResidentNV(@NativeType(value="GLuint64") long var0);

    @NativeType(value="GLuint64")
    public static native long glGetImageHandleNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLboolean") boolean var2, @NativeType(value="GLint") int var3, @NativeType(value="GLenum") int var4);

    public static native void glMakeImageHandleResidentNV(@NativeType(value="GLuint64") long var0, @NativeType(value="GLenum") int var2);

    public static native void glMakeImageHandleNonResidentNV(@NativeType(value="GLuint64") long var0);

    public static native void glUniformHandleui64NV(@NativeType(value="GLint") int var0, @NativeType(value="GLuint64") long var1);

    public static native void nglUniformHandleui64vNV(int var0, int var1, long var2);

    public static void glUniformHandleui64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") LongBuffer values) {
        NVBindlessTexture.nglUniformHandleui64vNV(location, values.remaining(), MemoryUtil.memAddress(values));
    }

    public static native void glProgramUniformHandleui64NV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint64") long var2);

    public static native void nglProgramUniformHandleui64vNV(int var0, int var1, int var2, long var3);

    public static void glProgramUniformHandleui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") LongBuffer values) {
        NVBindlessTexture.nglProgramUniformHandleui64vNV(program, location, values.remaining(), MemoryUtil.memAddress(values));
    }

    @NativeType(value="GLboolean")
    public static native boolean glIsTextureHandleResidentNV(@NativeType(value="GLuint64") long var0);

    @NativeType(value="GLboolean")
    public static native boolean glIsImageHandleResidentNV(@NativeType(value="GLuint64") long var0);

    public static void glUniformHandleui64vNV(@NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") long[] values) {
        long __functionAddress = GL.getICD().glUniformHandleui64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, values.length, values, __functionAddress);
    }

    public static void glProgramUniformHandleui64vNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint64 const *") long[] values) {
        long __functionAddress = GL.getICD().glProgramUniformHandleui64vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, values.length, values, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

