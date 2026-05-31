/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;

public class EXTDepthBoundsTest {
    public static final int GL_DEPTH_BOUNDS_TEST_EXT = 34960;
    public static final int GL_DEPTH_BOUNDS_EXT = 34961;

    protected EXTDepthBoundsTest() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glDepthBoundsEXT);
    }

    public static native void glDepthBoundsEXT(double var0, double var2);

    static {
        GL.initialize();
    }
}

