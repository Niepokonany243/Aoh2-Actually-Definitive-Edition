/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.WGLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class WGLARBCreateContext {
    public static final int WGL_CONTEXT_MAJOR_VERSION_ARB = 8337;
    public static final int WGL_CONTEXT_MINOR_VERSION_ARB = 8338;
    public static final int WGL_CONTEXT_LAYER_PLANE_ARB = 8339;
    public static final int WGL_CONTEXT_FLAGS_ARB = 8340;
    public static final int WGL_CONTEXT_DEBUG_BIT_ARB = 1;
    public static final int WGL_CONTEXT_FORWARD_COMPATIBLE_BIT_ARB = 2;
    public static final int ERROR_INVALID_VERSION_ARB = 8341;

    protected WGLARBCreateContext() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(WGLCapabilities caps) {
        return Checks.checkFunctions(caps.wglCreateContextAttribsARB);
    }

    public static long nwglCreateContextAttribsARB(long hdc, long shareContext, long attribList) {
        long __functionAddress = GL.getCapabilitiesWGL().wglCreateContextAttribsARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hdc);
        }
        return JNI.callPPPP(hdc, shareContext, attribList, __functionAddress);
    }

    @NativeType(value="HGLRC")
    public static long wglCreateContextAttribsARB(@NativeType(value="HDC") long hdc, @NativeType(value="HGLRC") long shareContext, @Nullable @NativeType(value="int const *") IntBuffer attribList) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(attribList);
        }
        return WGLARBCreateContext.nwglCreateContextAttribsARB(hdc, shareContext, MemoryUtil.memAddressSafe(attribList));
    }

    @NativeType(value="HGLRC")
    public static long wglCreateContextAttribsARB(@NativeType(value="HDC") long hdc, @NativeType(value="HGLRC") long shareContext, @Nullable @NativeType(value="int const *") int[] attribList) {
        long __functionAddress = GL.getCapabilitiesWGL().wglCreateContextAttribsARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hdc);
            Checks.checkNTSafe(attribList);
        }
        return JNI.callPPPP(hdc, shareContext, attribList, __functionAddress);
    }
}

