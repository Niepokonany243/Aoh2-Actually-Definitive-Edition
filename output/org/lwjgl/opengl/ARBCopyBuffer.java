/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL31C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBCopyBuffer {
    public static final int GL_COPY_READ_BUFFER = 36662;
    public static final int GL_COPY_WRITE_BUFFER = 36663;

    protected ARBCopyBuffer() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glCopyBufferSubData);
    }

    public static void glCopyBufferSubData(@NativeType(value="GLenum") int readTarget, @NativeType(value="GLenum") int writeTarget, @NativeType(value="GLintptr") long readOffset, @NativeType(value="GLintptr") long writeOffset, @NativeType(value="GLsizeiptr") long size) {
        GL31C.glCopyBufferSubData(readTarget, writeTarget, readOffset, writeOffset, size);
    }

    static {
        GL.initialize();
    }
}

