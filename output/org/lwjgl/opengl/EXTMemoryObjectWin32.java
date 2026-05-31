/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class EXTMemoryObjectWin32 {
    public static final int GL_HANDLE_TYPE_OPAQUE_WIN32_EXT = 38279;
    public static final int GL_HANDLE_TYPE_OPAQUE_WIN32_KMT_EXT = 38280;
    public static final int GL_DEVICE_LUID_EXT = 38297;
    public static final int GL_DEVICE_NODE_MASK_EXT = 38298;
    public static final int GL_LUID_SIZE_EXT = 8;
    public static final int GL_HANDLE_TYPE_D3D12_TILEPOOL_EXT = 38281;
    public static final int GL_HANDLE_TYPE_D3D12_RESOURCE_EXT = 38282;
    public static final int GL_HANDLE_TYPE_D3D11_IMAGE_EXT = 38283;
    public static final int GL_HANDLE_TYPE_D3D11_IMAGE_KMT_EXT = 38284;

    protected EXTMemoryObjectWin32() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glImportMemoryWin32HandleEXT, caps.glImportMemoryWin32NameEXT);
    }

    public static native void nglImportMemoryWin32HandleEXT(int var0, long var1, int var3, long var4);

    public static void glImportMemoryWin32HandleEXT(@NativeType(value="GLuint") int memory, @NativeType(value="GLuint64") long size, @NativeType(value="GLenum") int handleType, @NativeType(value="void *") long handle) {
        if (Checks.CHECKS) {
            Checks.check(handle);
        }
        EXTMemoryObjectWin32.nglImportMemoryWin32HandleEXT(memory, size, handleType, handle);
    }

    public static native void nglImportMemoryWin32NameEXT(int var0, long var1, int var3, long var4);

    public static void glImportMemoryWin32NameEXT(@NativeType(value="GLuint") int memory, @NativeType(value="GLuint64") long size, @NativeType(value="GLenum") int handleType, @NativeType(value="void const *") long name) {
        if (Checks.CHECKS) {
            Checks.check(name);
        }
        EXTMemoryObjectWin32.nglImportMemoryWin32NameEXT(memory, size, handleType, name);
    }

    static {
        GL.initialize();
    }
}

