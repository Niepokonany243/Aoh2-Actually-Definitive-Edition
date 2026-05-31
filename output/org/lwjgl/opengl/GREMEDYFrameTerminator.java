/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;

public class GREMEDYFrameTerminator {
    protected GREMEDYFrameTerminator() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glFrameTerminatorGREMEDY);
    }

    public static native void glFrameTerminatorGREMEDY();

    static {
        GL.initialize();
    }
}

