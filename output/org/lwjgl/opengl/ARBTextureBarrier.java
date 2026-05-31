/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL45C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;

public class ARBTextureBarrier {
    protected ARBTextureBarrier() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glTextureBarrier);
    }

    public static void glTextureBarrier() {
        GL45C.glTextureBarrier();
    }

    static {
        GL.initialize();
    }
}

