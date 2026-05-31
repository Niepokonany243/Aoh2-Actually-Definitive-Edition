/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLXCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class GLXSGIXSwapGroup {
    protected GLXSGIXSwapGroup() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLXCapabilities caps) {
        return Checks.checkFunctions(caps.glXJoinSwapGroupSGIX);
    }

    public static void glXJoinSwapGroupSGIX(@NativeType(value="Display *") long display, @NativeType(value="GLXDrawable") long drawable, @NativeType(value="GLXDrawable") long member) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXJoinSwapGroupSGIX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(drawable);
        }
        JNI.callPPPV(display, drawable, member, __functionAddress);
    }
}

