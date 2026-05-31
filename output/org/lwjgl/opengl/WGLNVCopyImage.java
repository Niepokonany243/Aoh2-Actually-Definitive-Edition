/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.WGLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class WGLNVCopyImage {
    protected WGLNVCopyImage() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(WGLCapabilities caps) {
        return Checks.checkFunctions(caps.wglCopyImageSubDataNV);
    }

    @NativeType(value="BOOL")
    public static boolean wglCopyImageSubDataNV(@NativeType(value="HGLRC") long srcRC, @NativeType(value="GLuint") int srcName, @NativeType(value="GLenum") int srcTarget, @NativeType(value="GLint") int srcLevel, @NativeType(value="GLint") int srcX, @NativeType(value="GLint") int srcY, @NativeType(value="GLint") int srcZ, @NativeType(value="HGLRC") long dstRC, @NativeType(value="GLuint") int dstName, @NativeType(value="GLenum") int dstTarget, @NativeType(value="GLint") int dstLevel, @NativeType(value="GLint") int dstX, @NativeType(value="GLint") int dstY, @NativeType(value="GLint") int dstZ, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth) {
        long __functionAddress = GL.getCapabilitiesWGL().wglCopyImageSubDataNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(srcRC);
            Checks.check(dstRC);
        }
        return JNI.callPPI(srcRC, srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstRC, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, width, height, depth, __functionAddress) != 0;
    }
}

