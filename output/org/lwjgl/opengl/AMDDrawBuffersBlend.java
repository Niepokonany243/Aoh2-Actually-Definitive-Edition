/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class AMDDrawBuffersBlend {
    protected AMDDrawBuffersBlend() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glBlendFuncIndexedAMD, caps.glBlendFuncSeparateIndexedAMD, caps.glBlendEquationIndexedAMD, caps.glBlendEquationSeparateIndexedAMD);
    }

    public static native void glBlendFuncIndexedAMD(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2);

    public static native void glBlendFuncSeparateIndexedAMD(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLenum") int var4);

    public static native void glBlendEquationIndexedAMD(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void glBlendEquationSeparateIndexedAMD(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2);

    static {
        GL.initialize();
    }
}

