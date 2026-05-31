/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;

public class NVTextureBarrier {
    protected NVTextureBarrier() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glTextureBarrierNV);
    }

    public static native void glTextureBarrierNV();

    static {
        GL.initialize();
    }
}

