/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;

public class EXTShaderFramebufferFetchNonCoherent {
    protected EXTShaderFramebufferFetchNonCoherent() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glFramebufferFetchBarrierEXT);
    }

    public static native void glFramebufferFetchBarrierEXT();

    static {
        GL.initialize();
    }
}

