/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class EXTBlendFuncSeparate {
    public static final int GL_BLEND_DST_RGB_EXT = 32968;
    public static final int GL_BLEND_SRC_RGB_EXT = 32969;
    public static final int GL_BLEND_DST_ALPHA_EXT = 32970;
    public static final int GL_BLEND_SRC_ALPHA_EXT = 32971;

    protected EXTBlendFuncSeparate() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glBlendFuncSeparateEXT);
    }

    public static native void glBlendFuncSeparateEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLenum") int var3);

    static {
        GL.initialize();
    }
}

