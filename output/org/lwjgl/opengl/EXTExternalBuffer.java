/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.util.Set;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class EXTExternalBuffer {
    protected EXTExternalBuffer() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, Set<String> ext) {
        return Checks.checkFunctions(caps.glBufferStorageExternalEXT, caps.hasDSA(ext) ? caps.glNamedBufferStorageExternalEXT : -1L);
    }

    public static native void nglBufferStorageExternalEXT(int var0, long var1, long var3, long var5, int var7);

    public static void glBufferStorageExternalEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLeglClientBufferEXT") long clientBuffer, @NativeType(value="GLbitfield") int flags) {
        if (Checks.CHECKS) {
            Checks.check(clientBuffer);
        }
        EXTExternalBuffer.nglBufferStorageExternalEXT(target, offset, size, clientBuffer, flags);
    }

    public static native void nglNamedBufferStorageExternalEXT(int var0, long var1, long var3, long var5, int var7);

    public static void glNamedBufferStorageExternalEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLeglClientBufferEXT") long clientBuffer, @NativeType(value="GLbitfield") int flags) {
        if (Checks.CHECKS) {
            Checks.check(clientBuffer);
        }
        EXTExternalBuffer.nglNamedBufferStorageExternalEXT(buffer, offset, size, clientBuffer, flags);
    }

    static {
        GL.initialize();
    }
}

