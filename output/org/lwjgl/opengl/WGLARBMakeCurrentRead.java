/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.WGLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class WGLARBMakeCurrentRead {
    public static final int ERROR_INVALID_PIXEL_TYPE_ARB = 8259;
    public static final int ERROR_INCOMPATIBLE_DEVICE_CONTEXTS_ARB = 8276;

    protected WGLARBMakeCurrentRead() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(WGLCapabilities caps) {
        return Checks.checkFunctions(caps.wglMakeContextCurrentARB, caps.wglGetCurrentReadDCARB);
    }

    @NativeType(value="BOOL")
    public static boolean wglMakeContextCurrentARB(@NativeType(value="HDC") long drawDC, @NativeType(value="HDC") long readDC, @NativeType(value="HGLRC") long hglrc) {
        long __functionAddress = GL.getCapabilitiesWGL().wglMakeContextCurrentARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(drawDC);
            Checks.check(readDC);
            Checks.check(hglrc);
        }
        return JNI.callPPPI(drawDC, readDC, hglrc, __functionAddress) != 0;
    }

    @NativeType(value="HDC")
    public static long wglGetCurrentReadDCARB() {
        long __functionAddress = GL.getCapabilitiesWGL().wglGetCurrentReadDCARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callP(__functionAddress);
    }
}

