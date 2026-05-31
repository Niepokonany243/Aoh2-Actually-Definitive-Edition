/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLXCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class GLXSGISwapControl {
    protected GLXSGISwapControl() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLXCapabilities caps) {
        return Checks.checkFunctions(caps.glXSwapIntervalSGI);
    }

    @NativeType(value="GLint")
    public static int glXSwapIntervalSGI(int interval) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXSwapIntervalSGI;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callI(interval, __functionAddress);
    }
}

