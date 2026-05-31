/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class NVXConditionalRender {
    protected NVXConditionalRender() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glBeginConditionalRenderNVX, caps.glEndConditionalRenderNVX);
    }

    public static native void glBeginConditionalRenderNVX(@NativeType(value="GLuint") int var0);

    public static native void glEndConditionalRenderNVX();

    static {
        GL.initialize();
    }
}

