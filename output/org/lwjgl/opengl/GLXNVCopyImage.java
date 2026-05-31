/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLXCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class GLXNVCopyImage {
    protected GLXNVCopyImage() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLXCapabilities caps) {
        return Checks.checkFunctions(caps.glXCopyImageSubDataNV);
    }

    public static void glXCopyImageSubDataNV(@NativeType(value="Display *") long display, @NativeType(value="GLXContext") long srcCtx, @NativeType(value="GLuint") int srcName, @NativeType(value="GLenum") int srcTarget, @NativeType(value="GLint") int srcLevel, @NativeType(value="GLint") int srcX, @NativeType(value="GLint") int srcY, @NativeType(value="GLint") int srcZ, @NativeType(value="GLXContext") long dstCtx, @NativeType(value="GLuint") int dstName, @NativeType(value="GLenum") int dstTarget, @NativeType(value="GLint") int dstLevel, @NativeType(value="GLint") int dstX, @NativeType(value="GLint") int dstY, @NativeType(value="GLint") int dstZ, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXCopyImageSubDataNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
        }
        JNI.callPPPV(display, srcCtx, srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstCtx, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, width, height, depth, __functionAddress);
    }
}

