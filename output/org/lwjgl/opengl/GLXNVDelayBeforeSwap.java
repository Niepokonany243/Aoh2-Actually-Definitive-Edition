/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLXCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class GLXNVDelayBeforeSwap {
    protected GLXNVDelayBeforeSwap() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLXCapabilities caps) {
        return Checks.checkFunctions(caps.glXDelayBeforeSwapNV);
    }

    @NativeType(value="Bool")
    public static boolean glXDelayBeforeSwapNV(@NativeType(value="Display *") long display, @NativeType(value="GLXDrawable") long drawable, @NativeType(value="GLfloat") float seconds) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXDelayBeforeSwapNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(drawable);
        }
        return JNI.callPPI(display, drawable, seconds, __functionAddress) != 0;
    }
}

