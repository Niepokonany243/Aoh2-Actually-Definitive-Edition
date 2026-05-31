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

public class ARBSampleLocations {
    public static final int GL_SAMPLE_LOCATION_SUBPIXEL_BITS_ARB = 37693;
    public static final int GL_SAMPLE_LOCATION_PIXEL_GRID_WIDTH_ARB = 37694;
    public static final int GL_SAMPLE_LOCATION_PIXEL_GRID_HEIGHT_ARB = 37695;
    public static final int GL_PROGRAMMABLE_SAMPLE_LOCATION_TABLE_SIZE_ARB = 37696;
    public static final int GL_FRAMEBUFFER_PROGRAMMABLE_SAMPLE_LOCATIONS_ARB = 37698;
    public static final int GL_FRAMEBUFFER_SAMPLE_LOCATION_PIXEL_GRID_ARB = 37699;

    protected ARBSampleLocations() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glFramebufferSampleLocationsfvARB, caps.glNamedFramebufferSampleLocationsfvARB, caps.glEvaluateDepthValuesARB);
    }

    public static native void nglFramebufferSampleLocationsfvARB(int var0, int var1, int var2, long var3);

    public static void glFramebufferSampleLocationsfvARB(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int start, @NativeType(value="GLfloat const *") FloatBuffer v) {
        ARBSampleLocations.nglFramebufferSampleLocationsfvARB(target, start, v.remaining() >> 1, MemoryUtil.memAddress(v));
    }

    public static native void nglNamedFramebufferSampleLocationsfvARB(int var0, int var1, int var2, long var3);

    public static void glNamedFramebufferSampleLocationsfvARB(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLuint") int start, @NativeType(value="GLfloat const *") FloatBuffer v) {
        ARBSampleLocations.nglNamedFramebufferSampleLocationsfvARB(framebuffer, start, v.remaining() >> 1, MemoryUtil.memAddress(v));
    }

    public static native void glEvaluateDepthValuesARB();

    public static void glFramebufferSampleLocationsfvARB(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int start, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glFramebufferSampleLocationsfvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, start, v.length >> 1, v, __functionAddress);
    }

    public static void glNamedFramebufferSampleLocationsfvARB(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLuint") int start, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glNamedFramebufferSampleLocationsfvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(framebuffer, start, v.length >> 1, v, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

