/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.WGLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class WGLEXTSwapControl {
    protected WGLEXTSwapControl() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(WGLCapabilities caps) {
        return Checks.checkFunctions(caps.wglSwapIntervalEXT, caps.wglGetSwapIntervalEXT);
    }

    @NativeType(value="BOOL")
    public static boolean wglSwapIntervalEXT(int interval) {
        long __functionAddress = GL.getCapabilitiesWGL().wglSwapIntervalEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callI(interval, __functionAddress) != 0;
    }

    public static int wglGetSwapIntervalEXT() {
        long __functionAddress = GL.getCapabilitiesWGL().wglGetSwapIntervalEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callI(__functionAddress);
    }
}

