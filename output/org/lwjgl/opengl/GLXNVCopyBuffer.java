/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLXCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class GLXNVCopyBuffer {
    protected GLXNVCopyBuffer() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLXCapabilities caps) {
        return Checks.checkFunctions(caps.glXCopyBufferSubDataNV, caps.glXNamedCopyBufferSubDataNV);
    }

    public static void glXCopyBufferSubDataNV(@NativeType(value="Display *") long display, @NativeType(value="GLXContext") long readCtx, @NativeType(value="GLXContext") long writeCtx, @NativeType(value="GLenum") int readTarget, @NativeType(value="GLenum") int writeTarget, @NativeType(value="GLintptr") long readOffset, @NativeType(value="GLintptr") long writeOffset, @NativeType(value="GLsizeiptr") long size) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXCopyBufferSubDataNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(readCtx);
            Checks.check(writeCtx);
        }
        JNI.callPPPPPPV(display, readCtx, writeCtx, readTarget, writeTarget, readOffset, writeOffset, size, __functionAddress);
    }

    public static void glXNamedCopyBufferSubDataNV(@NativeType(value="Display *") long display, @NativeType(value="GLXContext") long readCtx, @NativeType(value="GLXContext") long writeCtx, @NativeType(value="GLuint") int readBuffer, @NativeType(value="GLuint") int writeBuffer, @NativeType(value="GLintptr") long readOffset, @NativeType(value="GLintptr") long writeOffset, @NativeType(value="GLsizeiptr") long size) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXNamedCopyBufferSubDataNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(readCtx);
            Checks.check(writeCtx);
        }
        JNI.callPPPPPPV(display, readCtx, writeCtx, readBuffer, writeBuffer, readOffset, writeOffset, size, __functionAddress);
    }
}

