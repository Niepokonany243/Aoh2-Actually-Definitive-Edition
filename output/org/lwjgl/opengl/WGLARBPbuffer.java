/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.WGLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class WGLARBPbuffer {
    public static final int WGL_DRAW_TO_PBUFFER_ARB = 8237;
    public static final int WGL_MAX_PBUFFER_PIXELS_ARB = 8238;
    public static final int WGL_MAX_PBUFFER_WIDTH_ARB = 8239;
    public static final int WGL_MAX_PBUFFER_HEIGHT_ARB = 8240;
    public static final int WGL_PBUFFER_LARGEST_ARB = 8243;
    public static final int WGL_PBUFFER_WIDTH_ARB = 8244;
    public static final int WGL_PBUFFER_HEIGHT_ARB = 8245;
    public static final int WGL_PBUFFER_LOST_ARB = 8246;

    protected WGLARBPbuffer() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(WGLCapabilities caps) {
        return Checks.checkFunctions(caps.wglCreatePbufferARB, caps.wglGetPbufferDCARB, caps.wglReleasePbufferDCARB, caps.wglDestroyPbufferARB, caps.wglQueryPbufferARB);
    }

    public static long nwglCreatePbufferARB(long hdc, int pixelFormat, int width, int height, long attribList) {
        long __functionAddress = GL.getCapabilitiesWGL().wglCreatePbufferARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hdc);
        }
        return JNI.callPPP(hdc, pixelFormat, width, height, attribList, __functionAddress);
    }

    @NativeType(value="HPBUFFERARB")
    public static long wglCreatePbufferARB(@NativeType(value="HDC") long hdc, int pixelFormat, int width, int height, @Nullable @NativeType(value="int const *") IntBuffer attribList) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(attribList);
        }
        return WGLARBPbuffer.nwglCreatePbufferARB(hdc, pixelFormat, width, height, MemoryUtil.memAddressSafe(attribList));
    }

    @NativeType(value="HDC")
    public static long wglGetPbufferDCARB(@NativeType(value="HPBUFFERARB") long pbuffer) {
        long __functionAddress = GL.getCapabilitiesWGL().wglGetPbufferDCARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(pbuffer);
        }
        return JNI.callPP(pbuffer, __functionAddress);
    }

    public static int wglReleasePbufferDCARB(@NativeType(value="HPBUFFERARB") long pbuffer, @NativeType(value="HDC") long hdc) {
        long __functionAddress = GL.getCapabilitiesWGL().wglReleasePbufferDCARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(pbuffer);
            Checks.check(hdc);
        }
        return JNI.callPPI(pbuffer, hdc, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean wglDestroyPbufferARB(@NativeType(value="HPBUFFERARB") long pbuffer) {
        long __functionAddress = GL.getCapabilitiesWGL().wglDestroyPbufferARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(pbuffer);
        }
        return JNI.callPI(pbuffer, __functionAddress) != 0;
    }

    public static int nwglQueryPbufferARB(long pbuffer, int attribute, long value) {
        long __functionAddress = GL.getCapabilitiesWGL().wglQueryPbufferARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(pbuffer);
        }
        return JNI.callPPI(pbuffer, attribute, value, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean wglQueryPbufferARB(@NativeType(value="HPBUFFERARB") long pbuffer, int attribute, @NativeType(value="int *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        return WGLARBPbuffer.nwglQueryPbufferARB(pbuffer, attribute, MemoryUtil.memAddress(value)) != 0;
    }

    @NativeType(value="HPBUFFERARB")
    public static long wglCreatePbufferARB(@NativeType(value="HDC") long hdc, int pixelFormat, int width, int height, @Nullable @NativeType(value="int const *") int[] attribList) {
        long __functionAddress = GL.getCapabilitiesWGL().wglCreatePbufferARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hdc);
            Checks.checkNTSafe(attribList);
        }
        return JNI.callPPP(hdc, pixelFormat, width, height, attribList, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean wglQueryPbufferARB(@NativeType(value="HPBUFFERARB") long pbuffer, int attribute, @NativeType(value="int *") int[] value) {
        long __functionAddress = GL.getCapabilitiesWGL().wglQueryPbufferARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(pbuffer);
            Checks.check(value, 1);
        }
        return JNI.callPPI(pbuffer, attribute, value, __functionAddress) != 0;
    }
}

