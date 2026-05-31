/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.WGLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class WGLARBBufferRegion {
    public static final int WGL_FRONT_COLOR_BUFFER_BIT_ARB = 1;
    public static final int WGL_BACK_COLOR_BUFFER_BIT_ARB = 2;
    public static final int WGL_DEPTH_BUFFER_BIT_ARB = 4;
    public static final int WGL_STENCIL_BUFFER_BIT_ARB = 8;

    protected WGLARBBufferRegion() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(WGLCapabilities caps) {
        return Checks.checkFunctions(caps.wglCreateBufferRegionARB, caps.wglDeleteBufferRegionARB, caps.wglSaveBufferRegionARB, caps.wglRestoreBufferRegionARB);
    }

    @NativeType(value="HANDLE")
    public static long wglCreateBufferRegionARB(@NativeType(value="HDC") long hdc, int layerPlane, @NativeType(value="UINT") int type) {
        long __functionAddress = GL.getCapabilitiesWGL().wglCreateBufferRegionARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hdc);
        }
        return JNI.callPP(hdc, layerPlane, type, __functionAddress);
    }

    @NativeType(value="VOID")
    public static void wglDeleteBufferRegionARB(@NativeType(value="HANDLE") long region) {
        long __functionAddress = GL.getCapabilitiesWGL().wglDeleteBufferRegionARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(region);
        }
        JNI.callPV(region, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean wglSaveBufferRegionARB(@NativeType(value="HANDLE") long region, int x, int y, int width, int height) {
        long __functionAddress = GL.getCapabilitiesWGL().wglSaveBufferRegionARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(region);
        }
        return JNI.callPI(region, x, y, width, height, __functionAddress) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean wglRestoreBufferRegionARB(@NativeType(value="HANDLE") long region, int x, int y, int width, int height, int xSrc, int ySrc) {
        long __functionAddress = GL.getCapabilitiesWGL().wglRestoreBufferRegionARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(region);
        }
        return JNI.callPI(region, x, y, width, height, xSrc, ySrc, __functionAddress) != 0;
    }
}

