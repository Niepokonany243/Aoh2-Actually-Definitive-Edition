/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVShadingRateImage {
    public static final int GL_SHADING_RATE_IMAGE_NV = 38243;
    public static final int GL_SHADING_RATE_NO_INVOCATIONS_NV = 38244;
    public static final int GL_SHADING_RATE_1_INVOCATION_PER_PIXEL_NV = 38245;
    public static final int GL_SHADING_RATE_1_INVOCATION_PER_1X2_PIXELS_NV = 38246;
    public static final int GL_SHADING_RATE_1_INVOCATION_PER_2X1_PIXELS_NV = 38247;
    public static final int GL_SHADING_RATE_1_INVOCATION_PER_2X2_PIXELS_NV = 38248;
    public static final int GL_SHADING_RATE_1_INVOCATION_PER_2X4_PIXELS_NV = 38249;
    public static final int GL_SHADING_RATE_1_INVOCATION_PER_4X2_PIXELS_NV = 38250;
    public static final int GL_SHADING_RATE_1_INVOCATION_PER_4X4_PIXELS_NV = 38251;
    public static final int GL_SHADING_RATE_2_INVOCATIONS_PER_PIXEL_NV = 38252;
    public static final int GL_SHADING_RATE_4_INVOCATIONS_PER_PIXEL_NV = 38253;
    public static final int GL_SHADING_RATE_8_INVOCATIONS_PER_PIXEL_NV = 38254;
    public static final int GL_SHADING_RATE_16_INVOCATIONS_PER_PIXEL_NV = 38255;
    public static final int GL_SHADING_RATE_IMAGE_BINDING_NV = 38235;
    public static final int GL_SHADING_RATE_IMAGE_TEXEL_WIDTH_NV = 38236;
    public static final int GL_SHADING_RATE_IMAGE_TEXEL_HEIGHT_NV = 38237;
    public static final int GL_SHADING_RATE_IMAGE_PALETTE_SIZE_NV = 38238;
    public static final int GL_MAX_COARSE_FRAGMENT_SAMPLES_NV = 38239;
    public static final int GL_SHADING_RATE_SAMPLE_ORDER_DEFAULT_NV = 38318;
    public static final int GL_SHADING_RATE_SAMPLE_ORDER_PIXEL_MAJOR_NV = 38319;
    public static final int GL_SHADING_RATE_SAMPLE_ORDER_SAMPLE_MAJOR_NV = 38320;

    protected NVShadingRateImage() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glBindShadingRateImageNV, caps.glShadingRateImagePaletteNV, caps.glGetShadingRateImagePaletteNV, caps.glShadingRateImageBarrierNV, caps.glShadingRateSampleOrderNV, caps.glShadingRateSampleOrderCustomNV, caps.glGetShadingRateSampleLocationivNV);
    }

    public static native void glBindShadingRateImageNV(@NativeType(value="GLuint") int var0);

    public static native void nglShadingRateImagePaletteNV(int var0, int var1, int var2, long var3);

    public static void glShadingRateImagePaletteNV(@NativeType(value="GLuint") int viewport, @NativeType(value="GLuint") int first, @NativeType(value="GLenum const *") IntBuffer rates) {
        NVShadingRateImage.nglShadingRateImagePaletteNV(viewport, first, rates.remaining(), MemoryUtil.memAddress(rates));
    }

    public static native void nglGetShadingRateImagePaletteNV(int var0, int var1, long var2);

    public static void glGetShadingRateImagePaletteNV(@NativeType(value="GLuint") int viewport, @NativeType(value="GLuint") int entry, @NativeType(value="GLenum *") IntBuffer rate) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)rate, 1);
        }
        NVShadingRateImage.nglGetShadingRateImagePaletteNV(viewport, entry, MemoryUtil.memAddress(rate));
    }

    public static native void glShadingRateImageBarrierNV(@NativeType(value="GLboolean") boolean var0);

    public static native void glShadingRateSampleOrderNV(@NativeType(value="GLenum") int var0);

    public static native void nglShadingRateSampleOrderCustomNV(int var0, int var1, long var2);

    public static void glShadingRateSampleOrderCustomNV(@NativeType(value="GLenum") int rate, @NativeType(value="GLuint") int samples, @NativeType(value="GLint const *") IntBuffer locations) {
        NVShadingRateImage.nglShadingRateSampleOrderCustomNV(rate, samples, MemoryUtil.memAddress(locations));
    }

    public static native void nglGetShadingRateSampleLocationivNV(int var0, int var1, int var2, long var3);

    public static void glGetShadingRateSampleLocationivNV(@NativeType(value="GLenum") int rate, @NativeType(value="GLuint") int samples, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") IntBuffer location) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)location, 3);
        }
        NVShadingRateImage.nglGetShadingRateSampleLocationivNV(rate, samples, index, MemoryUtil.memAddress(location));
    }

    public static void glShadingRateImagePaletteNV(@NativeType(value="GLuint") int viewport, @NativeType(value="GLuint") int first, @NativeType(value="GLenum const *") int[] rates) {
        long __functionAddress = GL.getICD().glShadingRateImagePaletteNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(viewport, first, rates.length, rates, __functionAddress);
    }

    public static void glGetShadingRateImagePaletteNV(@NativeType(value="GLuint") int viewport, @NativeType(value="GLuint") int entry, @NativeType(value="GLenum *") int[] rate) {
        long __functionAddress = GL.getICD().glGetShadingRateImagePaletteNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(rate, 1);
        }
        JNI.callPV(viewport, entry, rate, __functionAddress);
    }

    public static void glShadingRateSampleOrderCustomNV(@NativeType(value="GLenum") int rate, @NativeType(value="GLuint") int samples, @NativeType(value="GLint const *") int[] locations) {
        long __functionAddress = GL.getICD().glShadingRateSampleOrderCustomNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(rate, samples, locations, __functionAddress);
    }

    public static void glGetShadingRateSampleLocationivNV(@NativeType(value="GLenum") int rate, @NativeType(value="GLuint") int samples, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") int[] location) {
        long __functionAddress = GL.getICD().glGetShadingRateSampleLocationivNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(location, 3);
        }
        JNI.callPV(rate, samples, index, location, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

