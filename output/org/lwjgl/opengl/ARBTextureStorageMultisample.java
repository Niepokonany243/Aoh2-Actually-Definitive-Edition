/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.util.Set;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBTextureStorageMultisample {
    protected ARBTextureStorageMultisample() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, Set<String> ext) {
        return Checks.checkFunctions(caps.glTexStorage2DMultisample, caps.glTexStorage3DMultisample, ext.contains("GL_EXT_direct_state_access") ? caps.glTextureStorage2DMultisampleEXT : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glTextureStorage3DMultisampleEXT : -1L);
    }

    public static void glTexStorage2DMultisample(@NativeType(value="GLenum") int target, @NativeType(value="GLsizei") int samples, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLboolean") boolean fixedsamplelocations) {
        GL43C.glTexStorage2DMultisample(target, samples, internalformat, width, height, fixedsamplelocations);
    }

    public static void glTexStorage3DMultisample(@NativeType(value="GLenum") int target, @NativeType(value="GLsizei") int samples, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLboolean") boolean fixedsamplelocations) {
        GL43C.glTexStorage3DMultisample(target, samples, internalformat, width, height, depth, fixedsamplelocations);
    }

    public static native void glTextureStorage2DMultisampleEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLsizei") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLsizei") int var5, @NativeType(value="GLboolean") boolean var6);

    public static native void glTextureStorage3DMultisampleEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLsizei") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLsizei") int var5, @NativeType(value="GLsizei") int var6, @NativeType(value="GLboolean") boolean var7);

    static {
        GL.initialize();
    }
}

