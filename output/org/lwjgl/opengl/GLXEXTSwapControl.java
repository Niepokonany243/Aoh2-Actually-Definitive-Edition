/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLXCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class GLXEXTSwapControl {
    public static final int GLX_SWAP_INTERVAL_EXT = 8433;
    public static final int GLX_MAX_SWAP_INTERVAL_EXT = 8434;

    protected GLXEXTSwapControl() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLXCapabilities caps) {
        return Checks.checkFunctions(caps.glXSwapIntervalEXT);
    }

    public static void glXSwapIntervalEXT(@NativeType(value="Display *") long display, @NativeType(value="GLXDrawable") long drawable, int interval) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXSwapIntervalEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(drawable);
        }
        JNI.callPPV(display, drawable, interval, __functionAddress);
    }
}

