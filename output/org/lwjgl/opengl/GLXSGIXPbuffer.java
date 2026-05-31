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
import org.lwjgl.CLongBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLXCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GLXSGIXPbuffer {
    public static final int GLX_MAX_PBUFFER_WIDTH_SGIX = 32790;
    public static final int GLX_MAX_PBUFFER_HEIGHT_SGIX = 32791;
    public static final int GLX_MAX_PBUFFER_PIXELS_SGIX = 32792;
    public static final int GLX_OPTIMAL_PBUFFER_WIDTH_SGIX = 32793;
    public static final int GLX_OPTIMAL_PBUFFER_HEIGHT_SGIX = 32794;
    public static final int GLX_PBUFFER_BIT_SGIX = 4;
    public static final int GLX_PRESERVED_CONTENTS_SGIX = 32795;
    public static final int GLX_LARGEST_PBUFFER_SGIX = 32796;
    public static final int GLX_WIDTH_SGIX = 32797;
    public static final int GLX_HEIGHT_SGIX = 32798;
    public static final int GLX_EVENT_MASK_SGIX = 32799;
    public static final int GLX_BUFFER_CLOBBER_MASK_SGIX = 0x8000000;
    public static final int GLX_DAMAGED_SGIX = 32800;
    public static final int GLX_SAVED_SGIX = 32801;
    public static final int GLX_WINDOW_SGIX = 32802;
    public static final int GLX_PBUFFER_SGIX = 32803;
    public static final int GLX_FRONT_LEFT_BUFFER_BIT_SGIX = 1;
    public static final int GLX_FRONT_RIGHT_BUFFER_BIT_SGIX = 2;
    public static final int GLX_BACK_LEFT_BUFFER_BIT_SGIX = 4;
    public static final int GLX_BACK_RIGHT_BUFFER_BIT_SGIX = 8;
    public static final int GLX_AUX_BUFFERS_BIT_SGIX = 16;
    public static final int GLX_DEPTH_BUFFER_BIT_SGIX = 32;
    public static final int GLX_STENCIL_BUFFER_BIT_SGIX = 64;
    public static final int GLX_ACCUM_BUFFER_BIT_SGIX = 128;
    public static final int GLX_SAMPLE_BUFFERS_BIT_SGIX = 256;

    protected GLXSGIXPbuffer() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLXCapabilities caps) {
        return Checks.checkFunctions(caps.glXCreateGLXPbufferSGIX, caps.glXDestroyGLXPbufferSGIX, caps.glXQueryGLXPbufferSGIX, caps.glXSelectEventSGIX, caps.glXGetSelectedEventSGIX);
    }

    public static long nglXCreateGLXPbufferSGIX(long display, long config, int width, int height, long attrib_list) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXCreateGLXPbufferSGIX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(config);
        }
        return JNI.callPPPP(display, config, width, height, attrib_list, __functionAddress);
    }

    @NativeType(value="GLXPbuffer")
    public static long glXCreateGLXPbufferSGIX(@NativeType(value="Display *") long display, @NativeType(value="GLXFBConfig") long config, @NativeType(value="unsigned int") int width, @NativeType(value="unsigned int") int height, @Nullable @NativeType(value="int *") IntBuffer attrib_list) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(attrib_list);
        }
        return GLXSGIXPbuffer.nglXCreateGLXPbufferSGIX(display, config, width, height, MemoryUtil.memAddressSafe(attrib_list));
    }

    public static void glXDestroyGLXPbufferSGIX(@NativeType(value="Display *") long display, @NativeType(value="GLXPbuffer") long pbuf) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXDestroyGLXPbufferSGIX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(pbuf);
        }
        JNI.callPPV(display, pbuf, __functionAddress);
    }

    public static void nglXQueryGLXPbufferSGIX(long display, long pbuf, int attribute, long value) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXQueryGLXPbufferSGIX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(pbuf);
        }
        JNI.callPPPV(display, pbuf, attribute, value, __functionAddress);
    }

    public static void glXQueryGLXPbufferSGIX(@NativeType(value="Display *") long display, @NativeType(value="GLXPbuffer") long pbuf, int attribute, @NativeType(value="unsigned int *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        GLXSGIXPbuffer.nglXQueryGLXPbufferSGIX(display, pbuf, attribute, MemoryUtil.memAddress(value));
    }

    public static void glXSelectEventSGIX(@NativeType(value="Display *") long display, @NativeType(value="GLXDrawable") long drawable, @NativeType(value="unsigned long") long mask) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXSelectEventSGIX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(drawable);
        }
        JNI.callPPNV(display, drawable, mask, __functionAddress);
    }

    public static void nglXGetSelectedEventSGIX(long display, long drawable, long mask) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXGetSelectedEventSGIX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(drawable);
        }
        JNI.callPPPV(display, drawable, mask, __functionAddress);
    }

    public static void glXGetSelectedEventSGIX(@NativeType(value="Display *") long display, @NativeType(value="GLXDrawable") long drawable, @NativeType(value="unsigned long *") CLongBuffer mask) {
        if (Checks.CHECKS) {
            Checks.check(mask, 1);
        }
        GLXSGIXPbuffer.nglXGetSelectedEventSGIX(display, drawable, MemoryUtil.memAddress(mask));
    }

    @NativeType(value="GLXPbuffer")
    public static long glXCreateGLXPbufferSGIX(@NativeType(value="Display *") long display, @NativeType(value="GLXFBConfig") long config, @NativeType(value="unsigned int") int width, @NativeType(value="unsigned int") int height, @Nullable @NativeType(value="int *") int[] attrib_list) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXCreateGLXPbufferSGIX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(config);
            Checks.checkNTSafe(attrib_list);
        }
        return JNI.callPPPP(display, config, width, height, attrib_list, __functionAddress);
    }

    public static void glXQueryGLXPbufferSGIX(@NativeType(value="Display *") long display, @NativeType(value="GLXPbuffer") long pbuf, int attribute, @NativeType(value="unsigned int *") int[] value) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXQueryGLXPbufferSGIX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(pbuf);
            Checks.check(value, 1);
        }
        JNI.callPPPV(display, pbuf, attribute, value, __functionAddress);
    }
}

