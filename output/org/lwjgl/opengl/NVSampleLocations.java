/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVSampleLocations {
    public static final int GL_SAMPLE_LOCATION_SUBPIXEL_BITS_NV = 37693;
    public static final int GL_SAMPLE_LOCATION_PIXEL_GRID_WIDTH_NV = 37694;
    public static final int GL_SAMPLE_LOCATION_PIXEL_GRID_HEIGHT_NV = 37695;
    public static final int GL_PROGRAMMABLE_SAMPLE_LOCATION_TABLE_SIZE_NV = 37696;
    public static final int GL_SAMPLE_LOCATION_NV = 36432;
    public static final int GL_PROGRAMMABLE_SAMPLE_LOCATION_NV = 37697;
    public static final int GL_FRAMEBUFFER_PROGRAMMABLE_SAMPLE_LOCATIONS_NV = 37698;
    public static final int GL_FRAMEBUFFER_SAMPLE_LOCATION_PIXEL_GRID_NV = 37699;

    protected NVSampleLocations() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glFramebufferSampleLocationsfvNV, caps.glNamedFramebufferSampleLocationsfvNV, caps.glResolveDepthValuesNV);
    }

    public static native void nglFramebufferSampleLocationsfvNV(int var0, int var1, int var2, long var3);

    public static void glFramebufferSampleLocationsfvNV(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int start, @NativeType(value="GLfloat const *") FloatBuffer v) {
        NVSampleLocations.nglFramebufferSampleLocationsfvNV(target, start, v.remaining() >> 1, MemoryUtil.memAddress(v));
    }

    public static native void nglNamedFramebufferSampleLocationsfvNV(int var0, int var1, int var2, long var3);

    public static void glNamedFramebufferSampleLocationsfvNV(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLuint") int start, @NativeType(value="GLfloat const *") FloatBuffer v) {
        NVSampleLocations.nglNamedFramebufferSampleLocationsfvNV(framebuffer, start, v.remaining() >> 1, MemoryUtil.memAddress(v));
    }

    public static native void glResolveDepthValuesNV();

    public static void glFramebufferSampleLocationsfvNV(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int start, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glFramebufferSampleLocationsfvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, start, v.length >> 1, v, __functionAddress);
    }

    public static void glNamedFramebufferSampleLocationsfvNV(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLuint") int start, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glNamedFramebufferSampleLocationsfvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(framebuffer, start, v.length >> 1, v, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

