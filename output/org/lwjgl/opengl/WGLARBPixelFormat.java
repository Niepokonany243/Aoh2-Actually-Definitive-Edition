/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.WGLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class WGLARBPixelFormat {
    public static final int WGL_NUMBER_PIXEL_FORMATS_ARB = 8192;
    public static final int WGL_DRAW_TO_WINDOW_ARB = 8193;
    public static final int WGL_DRAW_TO_BITMAP_ARB = 8194;
    public static final int WGL_ACCELERATION_ARB = 8195;
    public static final int WGL_NEED_PALETTE_ARB = 8196;
    public static final int WGL_NEED_SYSTEM_PALETTE_ARB = 8197;
    public static final int WGL_SWAP_LAYER_BUFFERS_ARB = 8198;
    public static final int WGL_SWAP_METHOD_ARB = 8199;
    public static final int WGL_NUMBER_OVERLAYS_ARB = 8200;
    public static final int WGL_NUMBER_UNDERLAYS_ARB = 8201;
    public static final int WGL_TRANSPARENT_ARB = 8202;
    public static final int WGL_TRANSPARENT_RED_VALUE_ARB = 8247;
    public static final int WGL_TRANSPARENT_GREEN_VALUE_ARB = 8248;
    public static final int WGL_TRANSPARENT_BLUE_VALUE_ARB = 8249;
    public static final int WGL_TRANSPARENT_ALPHA_VALUE_ARB = 8250;
    public static final int WGL_TRANSPARENT_INDEX_VALUE_ARB = 8251;
    public static final int WGL_SHARE_DEPTH_ARB = 8204;
    public static final int WGL_SHARE_STENCIL_ARB = 8205;
    public static final int WGL_SHARE_ACCUM_ARB = 8206;
    public static final int WGL_SUPPORT_GDI_ARB = 8207;
    public static final int WGL_SUPPORT_OPENGL_ARB = 8208;
    public static final int WGL_DOUBLE_BUFFER_ARB = 8209;
    public static final int WGL_STEREO_ARB = 8210;
    public static final int WGL_PIXEL_TYPE_ARB = 8211;
    public static final int WGL_COLOR_BITS_ARB = 8212;
    public static final int WGL_RED_BITS_ARB = 8213;
    public static final int WGL_RED_SHIFT_ARB = 8214;
    public static final int WGL_GREEN_BITS_ARB = 8215;
    public static final int WGL_GREEN_SHIFT_ARB = 8216;
    public static final int WGL_BLUE_BITS_ARB = 8217;
    public static final int WGL_BLUE_SHIFT_ARB = 8218;
    public static final int WGL_ALPHA_BITS_ARB = 8219;
    public static final int WGL_ALPHA_SHIFT_ARB = 8220;
    public static final int WGL_ACCUM_BITS_ARB = 8221;
    public static final int WGL_ACCUM_RED_BITS_ARB = 8222;
    public static final int WGL_ACCUM_GREEN_BITS_ARB = 8223;
    public static final int WGL_ACCUM_BLUE_BITS_ARB = 8224;
    public static final int WGL_ACCUM_ALPHA_BITS_ARB = 8225;
    public static final int WGL_DEPTH_BITS_ARB = 8226;
    public static final int WGL_STENCIL_BITS_ARB = 8227;
    public static final int WGL_AUX_BUFFERS_ARB = 8228;
    public static final int WGL_NO_ACCELERATION_ARB = 8229;
    public static final int WGL_GENERIC_ACCELERATION_ARB = 8230;
    public static final int WGL_FULL_ACCELERATION_ARB = 8231;
    public static final int WGL_SWAP_EXCHANGE_ARB = 8232;
    public static final int WGL_SWAP_COPY_ARB = 8233;
    public static final int WGL_SWAP_UNDEFINED_ARB = 8234;
    public static final int WGL_TYPE_RGBA_ARB = 8235;
    public static final int WGL_TYPE_COLORINDEX_ARB = 8236;

    protected WGLARBPixelFormat() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(WGLCapabilities caps) {
        return Checks.checkFunctions(caps.wglGetPixelFormatAttribivARB, caps.wglGetPixelFormatAttribfvARB, caps.wglChoosePixelFormatARB);
    }

    public static int nwglGetPixelFormatAttribivARB(long hdc, int pixelFormat, int layerPlane, int n, long attributes, long values) {
        long __functionAddress = GL.getCapabilitiesWGL().wglGetPixelFormatAttribivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hdc);
        }
        return JNI.callPPPI(hdc, pixelFormat, layerPlane, n, attributes, values, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean wglGetPixelFormatAttribivARB(@NativeType(value="HDC") long hdc, int pixelFormat, int layerPlane, @NativeType(value="int const *") IntBuffer attributes, @NativeType(value="int *") IntBuffer values) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)values, attributes.remaining());
        }
        return WGLARBPixelFormat.nwglGetPixelFormatAttribivARB(hdc, pixelFormat, layerPlane, attributes.remaining(), MemoryUtil.memAddress(attributes), MemoryUtil.memAddress(values)) != 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="BOOL")
    public static boolean wglGetPixelFormatAttribiARB(@NativeType(value="HDC") long hdc, int pixelFormat, int layerPlane, @NativeType(value="int const *") int attribute, @NativeType(value="int *") IntBuffer values) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)values, 1);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer attributes = stack.ints(attribute);
            boolean bl = WGLARBPixelFormat.nwglGetPixelFormatAttribivARB(hdc, pixelFormat, layerPlane, 1, MemoryUtil.memAddress(attributes), MemoryUtil.memAddress(values)) != 0;
            return bl;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static int nwglGetPixelFormatAttribfvARB(long hdc, int pixelFormat, int layerPlane, int n, long attributes, long values) {
        long __functionAddress = GL.getCapabilitiesWGL().wglGetPixelFormatAttribfvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hdc);
        }
        return JNI.callPPPI(hdc, pixelFormat, layerPlane, n, attributes, values, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean wglGetPixelFormatAttribfvARB(@NativeType(value="HDC") long hdc, int pixelFormat, int layerPlane, @NativeType(value="int const *") IntBuffer attributes, @NativeType(value="FLOAT *") FloatBuffer values) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)values, attributes.remaining());
        }
        return WGLARBPixelFormat.nwglGetPixelFormatAttribfvARB(hdc, pixelFormat, layerPlane, attributes.remaining(), MemoryUtil.memAddress(attributes), MemoryUtil.memAddress(values)) != 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="BOOL")
    public static boolean wglGetPixelFormatAttribfARB(@NativeType(value="HDC") long hdc, int pixelFormat, int layerPlane, @NativeType(value="int const *") int attribute, @NativeType(value="FLOAT *") FloatBuffer values) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)values, 1);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer attributes = stack.ints(attribute);
            boolean bl = WGLARBPixelFormat.nwglGetPixelFormatAttribfvARB(hdc, pixelFormat, layerPlane, 1, MemoryUtil.memAddress(attributes), MemoryUtil.memAddress(values)) != 0;
            return bl;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static int nwglChoosePixelFormatARB(long hdc, long attribIList, long attribFList, int maxFormats, long formats, long numFormats) {
        long __functionAddress = GL.getCapabilitiesWGL().wglChoosePixelFormatARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hdc);
        }
        return JNI.callPPPPPI(hdc, attribIList, attribFList, maxFormats, formats, numFormats, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean wglChoosePixelFormatARB(@NativeType(value="HDC") long hdc, @Nullable @NativeType(value="int const *") IntBuffer attribIList, @Nullable @NativeType(value="FLOAT const *") FloatBuffer attribFList, @NativeType(value="int *") IntBuffer formats, @NativeType(value="UINT *") IntBuffer numFormats) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(attribIList);
            Checks.checkNTSafe(attribFList);
            Checks.check((Buffer)numFormats, 1);
        }
        return WGLARBPixelFormat.nwglChoosePixelFormatARB(hdc, MemoryUtil.memAddressSafe(attribIList), MemoryUtil.memAddressSafe(attribFList), formats.remaining(), MemoryUtil.memAddress(formats), MemoryUtil.memAddress(numFormats)) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean wglGetPixelFormatAttribivARB(@NativeType(value="HDC") long hdc, int pixelFormat, int layerPlane, @NativeType(value="int const *") int[] attributes, @NativeType(value="int *") int[] values) {
        long __functionAddress = GL.getCapabilitiesWGL().wglGetPixelFormatAttribivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hdc);
            Checks.check(values, attributes.length);
        }
        return JNI.callPPPI(hdc, pixelFormat, layerPlane, attributes.length, attributes, values, __functionAddress) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean wglGetPixelFormatAttribfvARB(@NativeType(value="HDC") long hdc, int pixelFormat, int layerPlane, @NativeType(value="int const *") int[] attributes, @NativeType(value="FLOAT *") float[] values) {
        long __functionAddress = GL.getCapabilitiesWGL().wglGetPixelFormatAttribfvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hdc);
            Checks.check(values, attributes.length);
        }
        return JNI.callPPPI(hdc, pixelFormat, layerPlane, attributes.length, attributes, values, __functionAddress) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean wglChoosePixelFormatARB(@NativeType(value="HDC") long hdc, @Nullable @NativeType(value="int const *") int[] attribIList, @Nullable @NativeType(value="FLOAT const *") float[] attribFList, @NativeType(value="int *") int[] formats, @NativeType(value="UINT *") int[] numFormats) {
        long __functionAddress = GL.getCapabilitiesWGL().wglChoosePixelFormatARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hdc);
            Checks.checkNTSafe(attribIList);
            Checks.checkNTSafe(attribFList);
            Checks.check(numFormats, 1);
        }
        return JNI.callPPPPPI(hdc, attribIList, attribFList, formats.length, formats, numFormats, __functionAddress) != 0;
    }
}

