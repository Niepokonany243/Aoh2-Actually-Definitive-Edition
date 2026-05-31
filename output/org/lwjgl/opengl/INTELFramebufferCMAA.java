/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;

public class INTELFramebufferCMAA {
    protected INTELFramebufferCMAA() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glApplyFramebufferAttachmentCMAAINTEL);
    }

    public static native void glApplyFramebufferAttachmentCMAAINTEL();

    static {
        GL.initialize();
    }
}

