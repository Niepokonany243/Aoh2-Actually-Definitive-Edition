/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class EXTStencilTwoSide {
    public static final int GL_STENCIL_TEST_TWO_SIDE_EXT = 35088;
    public static final int GL_ACTIVE_STENCIL_FACE_EXT = 35089;

    protected EXTStencilTwoSide() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glActiveStencilFaceEXT);
    }

    public static native void glActiveStencilFaceEXT(@NativeType(value="GLenum") int var0);

    static {
        GL.initialize();
    }
}

