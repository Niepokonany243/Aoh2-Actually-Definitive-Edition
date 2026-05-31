/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBCopyImage {
    protected ARBCopyImage() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glCopyImageSubData);
    }

    public static void glCopyImageSubData(@NativeType(value="GLuint") int srcName, @NativeType(value="GLenum") int srcTarget, @NativeType(value="GLint") int srcLevel, @NativeType(value="GLint") int srcX, @NativeType(value="GLint") int srcY, @NativeType(value="GLint") int srcZ, @NativeType(value="GLuint") int dstName, @NativeType(value="GLenum") int dstTarget, @NativeType(value="GLint") int dstLevel, @NativeType(value="GLint") int dstX, @NativeType(value="GLint") int dstY, @NativeType(value="GLint") int dstZ, @NativeType(value="GLsizei") int srcWidth, @NativeType(value="GLsizei") int srcHeight, @NativeType(value="GLsizei") int srcDepth) {
        GL43C.glCopyImageSubData(srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, srcWidth, srcHeight, srcDepth);
    }

    static {
        GL.initialize();
    }
}

