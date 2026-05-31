/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL45C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBClipControl {
    public static final int GL_LOWER_LEFT = 36001;
    public static final int GL_UPPER_LEFT = 36002;
    public static final int GL_NEGATIVE_ONE_TO_ONE = 37726;
    public static final int GL_ZERO_TO_ONE = 37727;
    public static final int GL_CLIP_ORIGIN = 37724;
    public static final int GL_CLIP_DEPTH_MODE = 37725;

    protected ARBClipControl() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glClipControl);
    }

    public static void glClipControl(@NativeType(value="GLenum") int origin, @NativeType(value="GLenum") int depth) {
        GL45C.glClipControl(origin, depth);
    }

    static {
        GL.initialize();
    }
}

