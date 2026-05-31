/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.WGLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class WGLNVDelayBeforeSwap {
    protected WGLNVDelayBeforeSwap() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(WGLCapabilities caps) {
        return Checks.checkFunctions(caps.wglDelayBeforeSwapNV);
    }

    @NativeType(value="BOOL")
    public static boolean wglDelayBeforeSwapNV(@NativeType(value="HDC") long hDC, @NativeType(value="GLfloat") float seconds) {
        long __functionAddress = GL.getCapabilitiesWGL().wglDelayBeforeSwapNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hDC);
        }
        return JNI.callPI(hDC, seconds, __functionAddress) != 0;
    }
}

