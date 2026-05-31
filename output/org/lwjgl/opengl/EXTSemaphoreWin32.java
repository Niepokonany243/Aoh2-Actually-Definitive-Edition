/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class EXTSemaphoreWin32 {
    public static final int GL_HANDLE_TYPE_OPAQUE_WIN32_EXT = 38279;
    public static final int GL_HANDLE_TYPE_OPAQUE_WIN32_KMT_EXT = 38280;
    public static final int GL_DEVICE_LUID_EXT = 38297;
    public static final int GL_DEVICE_NODE_MASK_EXT = 38298;
    public static final int GL_LUID_SIZE_EXT = 8;
    public static final int GL_HANDLE_TYPE_D3D12_FENCE_EXT = 38292;
    public static final int GL_D3D12_FENCE_VALUE_EXT = 38293;

    protected EXTSemaphoreWin32() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glImportSemaphoreWin32HandleEXT, caps.glImportSemaphoreWin32NameEXT);
    }

    public static native void nglImportSemaphoreWin32HandleEXT(int var0, int var1, long var2);

    public static void glImportSemaphoreWin32HandleEXT(@NativeType(value="GLuint") int semaphore, @NativeType(value="GLenum") int handleType, @NativeType(value="void *") long handle) {
        if (Checks.CHECKS) {
            Checks.check(handle);
        }
        EXTSemaphoreWin32.nglImportSemaphoreWin32HandleEXT(semaphore, handleType, handle);
    }

    public static native void nglImportSemaphoreWin32NameEXT(int var0, int var1, long var2);

    public static void glImportSemaphoreWin32NameEXT(@NativeType(value="GLuint") int semaphore, @NativeType(value="GLenum") int handleType, @NativeType(value="void const *") long name) {
        if (Checks.CHECKS) {
            Checks.check(name);
        }
        EXTSemaphoreWin32.nglImportSemaphoreWin32NameEXT(semaphore, handleType, name);
    }

    static {
        GL.initialize();
    }
}

