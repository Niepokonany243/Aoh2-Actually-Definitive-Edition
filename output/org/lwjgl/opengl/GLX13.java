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
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLX12;
import org.lwjgl.opengl.GLXCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.linux.XVisualInfo;

public class GLX13
extends GLX12 {
    public static final int GLX_WINDOW_BIT = 1;
    public static final int GLX_PIXMAP_BIT = 2;
    public static final int GLX_PBUFFER_BIT = 4;
    public static final int GLX_RGBA_BIT = 1;
    public static final int GLX_COLOR_INDEX_BIT = 2;
    public static final int GLX_PBUFFER_CLOBBER_MASK = 0x8000000;
    public static final int GLX_FRONT_LEFT_BUFFER_BIT = 1;
    public static final int GLX_FRONT_RIGHT_BUFFER_BIT = 2;
    public static final int GLX_BACK_LEFT_BUFFER_BIT = 4;
    public static final int GLX_BACK_RIGHT_BUFFER_BIT = 8;
    public static final int GLX_AUX_BUFFERS_BIT = 16;
    public static final int GLX_DEPTH_BUFFER_BIT = 32;
    public static final int GLX_STENCIL_BUFFER_BIT = 64;
    public static final int GLX_ACCUM_BUFFER_BIT = 128;
    public static final int GLX_CONFIG_CAVEAT = 32;
    public static final int GLX_X_VISUAL_TYPE = 34;
    public static final int GLX_TRANSPARENT_TYPE = 35;
    public static final int GLX_TRANSPARENT_INDEX_VALUE = 36;
    public static final int GLX_TRANSPARENT_RED_VALUE = 37;
    public static final int GLX_TRANSPARENT_GREEN_VALUE = 38;
    public static final int GLX_TRANSPARENT_BLUE_VALUE = 39;
    public static final int GLX_TRANSPARENT_ALPHA_VALUE = 40;
    public static final int GLX_DONT_CARE = -1;
    public static final int GLX_NONE = 32768;
    public static final int GLX_SLOW_CONFIG = 32769;
    public static final int GLX_TRUE_COLOR = 32770;
    public static final int GLX_DIRECT_COLOR = 32771;
    public static final int GLX_PSEUDO_COLOR = 32772;
    public static final int GLX_STATIC_COLOR = 32773;
    public static final int GLX_GRAY_SCALE = 32774;
    public static final int GLX_STATIC_GRAY = 32775;
    public static final int GLX_TRANSPARENT_RGB = 32776;
    public static final int GLX_TRANSPARENT_INDEX = 32777;
    public static final int GLX_VISUAL_ID = 32779;
    public static final int GLX_SCREEN = 32780;
    public static final int GLX_NON_CONFORMANT_CONFIG = 32781;
    public static final int GLX_DRAWABLE_TYPE = 32784;
    public static final int GLX_RENDER_TYPE = 32785;
    public static final int GLX_X_RENDERABLE = 32786;
    public static final int GLX_FBCONFIG_ID = 32787;
    public static final int GLX_RGBA_TYPE = 32788;
    public static final int GLX_COLOR_INDEX_TYPE = 32789;
    public static final int GLX_MAX_PBUFFER_WIDTH = 32790;
    public static final int GLX_MAX_PBUFFER_HEIGHT = 32791;
    public static final int GLX_MAX_PBUFFER_PIXELS = 32792;
    public static final int GLX_PRESERVED_CONTENTS = 32795;
    public static final int GLX_LARGEST_PBUFFER = 32796;
    public static final int GLX_WIDTH = 32797;
    public static final int GLX_HEIGHT = 32798;
    public static final int GLX_EVENT_MASK = 32799;
    public static final int GLX_DAMAGED = 32800;
    public static final int GLX_SAVED = 32801;
    public static final int GLX_WINDOW = 32802;
    public static final int GLX_PBUFFER = 32803;
    public static final int GLX_PBUFFER_HEIGHT = 32832;
    public static final int GLX_PBUFFER_WIDTH = 32833;

    protected GLX13() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLXCapabilities caps) {
        return Checks.checkFunctions(caps.glXGetFBConfigs, caps.glXChooseFBConfig, caps.glXGetFBConfigAttrib, caps.glXGetVisualFromFBConfig, caps.glXCreateWindow, caps.glXCreatePixmap, caps.glXDestroyPixmap, caps.glXCreatePbuffer, caps.glXDestroyPbuffer, caps.glXQueryDrawable, caps.glXCreateNewContext, caps.glXMakeContextCurrent, caps.glXGetCurrentReadDrawable, caps.glXQueryContext, caps.glXSelectEvent, caps.glXGetSelectedEvent);
    }

    public static long nglXGetFBConfigs(long display, int screen, long nelements) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXGetFBConfigs;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
        }
        return JNI.callPPP(display, screen, nelements, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="GLXFBConfig *")
    public static PointerBuffer glXGetFBConfigs(@NativeType(value="Display *") long display, int screen) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        IntBuffer nelements = stack.callocInt(1);
        try {
            long __result = GLX13.nglXGetFBConfigs(display, screen, MemoryUtil.memAddress(nelements));
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(__result, nelements.get(0));
            return pointerBuffer;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nglXChooseFBConfig(long display, int screen, long attrib_list, long nelements) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXChooseFBConfig;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
        }
        return JNI.callPPPP(display, screen, attrib_list, nelements, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="GLXFBConfig *")
    public static PointerBuffer glXChooseFBConfig(@NativeType(value="Display *") long display, int screen, @Nullable @NativeType(value="int const *") IntBuffer attrib_list) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(attrib_list);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        IntBuffer nelements = stack.callocInt(1);
        try {
            long __result = GLX13.nglXChooseFBConfig(display, screen, MemoryUtil.memAddressSafe(attrib_list), MemoryUtil.memAddress(nelements));
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(__result, nelements.get(0));
            return pointerBuffer;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static int nglXGetFBConfigAttrib(long display, long config, int attribute, long value) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXGetFBConfigAttrib;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(config);
        }
        return JNI.callPPPI(display, config, attribute, value, __functionAddress);
    }

    public static int glXGetFBConfigAttrib(@NativeType(value="Display *") long display, @NativeType(value="GLXFBConfig") long config, int attribute, @NativeType(value="int *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        return GLX13.nglXGetFBConfigAttrib(display, config, attribute, MemoryUtil.memAddress(value));
    }

    public static long nglXGetVisualFromFBConfig(long display, long config) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXGetVisualFromFBConfig;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(config);
        }
        return JNI.callPPP(display, config, __functionAddress);
    }

    @Nullable
    @NativeType(value="XVisualInfo *")
    public static XVisualInfo glXGetVisualFromFBConfig(@NativeType(value="Display *") long display, @NativeType(value="GLXFBConfig") long config) {
        long __result = GLX13.nglXGetVisualFromFBConfig(display, config);
        return XVisualInfo.createSafe(__result);
    }

    public static long nglXCreateWindow(long display, long config, long win, long attrib_list) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXCreateWindow;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(config);
        }
        return JNI.callPPNPP(display, config, win, attrib_list, __functionAddress);
    }

    @NativeType(value="GLXWindow")
    public static long glXCreateWindow(@NativeType(value="Display *") long display, @NativeType(value="GLXFBConfig") long config, @NativeType(value="Window") long win, @Nullable @NativeType(value="int const *") IntBuffer attrib_list) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(attrib_list);
        }
        return GLX13.nglXCreateWindow(display, config, win, MemoryUtil.memAddressSafe(attrib_list));
    }

    public static long nglXCreatePixmap(long display, long config, long pixmap, long attrib_list) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXCreatePixmap;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(config);
        }
        return JNI.callPPNPP(display, config, pixmap, attrib_list, __functionAddress);
    }

    @NativeType(value="GLXPixmap")
    public static long glXCreatePixmap(@NativeType(value="Display *") long display, @NativeType(value="GLXFBConfig") long config, @NativeType(value="Pixmap") long pixmap, @Nullable @NativeType(value="int const *") IntBuffer attrib_list) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(attrib_list);
        }
        return GLX13.nglXCreatePixmap(display, config, pixmap, MemoryUtil.memAddressSafe(attrib_list));
    }

    public static void glXDestroyPixmap(@NativeType(value="Display *") long display, @NativeType(value="GLXPixmap") long pixmap) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXDestroyPixmap;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(pixmap);
        }
        JNI.callPPV(display, pixmap, __functionAddress);
    }

    public static long nglXCreatePbuffer(long display, long config, long attrib_list) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXCreatePbuffer;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(config);
        }
        return JNI.callPPPP(display, config, attrib_list, __functionAddress);
    }

    @NativeType(value="GLXPbuffer")
    public static long glXCreatePbuffer(@NativeType(value="Display *") long display, @NativeType(value="GLXFBConfig") long config, @Nullable @NativeType(value="int const *") IntBuffer attrib_list) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(attrib_list);
        }
        return GLX13.nglXCreatePbuffer(display, config, MemoryUtil.memAddressSafe(attrib_list));
    }

    public static void glXDestroyPbuffer(@NativeType(value="Display *") long display, @NativeType(value="GLXPbuffer") long pbuf) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXDestroyPbuffer;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(pbuf);
        }
        JNI.callPPV(display, pbuf, __functionAddress);
    }

    public static void nglXQueryDrawable(long display, long draw, int attribute, long value) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXQueryDrawable;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(draw);
        }
        JNI.callPPPV(display, draw, attribute, value, __functionAddress);
    }

    public static void glXQueryDrawable(@NativeType(value="Display *") long display, @NativeType(value="GLXDrawable") long draw, int attribute, @NativeType(value="unsigned int *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        GLX13.nglXQueryDrawable(display, draw, attribute, MemoryUtil.memAddress(value));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glXQueryDrawable(@NativeType(value="Display *") long display, @NativeType(value="GLXDrawable") long draw, int attribute) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer value = stack.callocInt(1);
            GLX13.nglXQueryDrawable(display, draw, attribute, MemoryUtil.memAddress(value));
            int n = value.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="GLXContext")
    public static long glXCreateNewContext(@NativeType(value="Display *") long display, @NativeType(value="GLXFBConfig") long config, int render_type, @NativeType(value="GLXContext") long share_list, @NativeType(value="Bool") boolean direct) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXCreateNewContext;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(config);
        }
        return JNI.callPPPP(display, config, render_type, share_list, direct ? 1 : 0, __functionAddress);
    }

    @NativeType(value="Bool")
    public static boolean glXMakeContextCurrent(@NativeType(value="Display *") long display, @NativeType(value="GLXDrawable") long draw, @NativeType(value="GLXDrawable") long read, @NativeType(value="GLXContext") long ctx) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXMakeContextCurrent;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
        }
        return JNI.callPPPPI(display, draw, read, ctx, __functionAddress) != 0;
    }

    @NativeType(value="GLXDrawable")
    public static long glXGetCurrentReadDrawable() {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXGetCurrentReadDrawable;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callP(__functionAddress);
    }

    public static int nglXQueryContext(long display, long ctx, int attribute, long value) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXQueryContext;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(ctx);
        }
        return JNI.callPPPI(display, ctx, attribute, value, __functionAddress);
    }

    public static int glXQueryContext(@NativeType(value="Display *") long display, @NativeType(value="GLXContext") long ctx, int attribute, @NativeType(value="int *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        return GLX13.nglXQueryContext(display, ctx, attribute, MemoryUtil.memAddress(value));
    }

    public static void glXSelectEvent(@NativeType(value="Display *") long display, @NativeType(value="GLXDrawable") long draw, @NativeType(value="unsigned long") long event_mask) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXSelectEvent;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(draw);
        }
        JNI.callPPNV(display, draw, event_mask, __functionAddress);
    }

    public static void nglXGetSelectedEvent(long display, long draw, long event_mask) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXGetSelectedEvent;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(draw);
        }
        JNI.callPPPV(display, draw, event_mask, __functionAddress);
    }

    public static void glXGetSelectedEvent(@NativeType(value="Display *") long display, @NativeType(value="GLXDrawable") long draw, @NativeType(value="unsigned long *") CLongBuffer event_mask) {
        if (Checks.CHECKS) {
            Checks.check(event_mask, 1);
        }
        GLX13.nglXGetSelectedEvent(display, draw, MemoryUtil.memAddress(event_mask));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="GLXFBConfig *")
    public static PointerBuffer glXChooseFBConfig(@NativeType(value="Display *") long display, int screen, @Nullable @NativeType(value="int const *") int[] attrib_list) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXChooseFBConfig;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.checkNTSafe(attrib_list);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        IntBuffer nelements = stack.callocInt(1);
        try {
            long __result = JNI.callPPPP(display, screen, attrib_list, MemoryUtil.memAddress(nelements), __functionAddress);
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(__result, nelements.get(0));
            return pointerBuffer;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static int glXGetFBConfigAttrib(@NativeType(value="Display *") long display, @NativeType(value="GLXFBConfig") long config, int attribute, @NativeType(value="int *") int[] value) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXGetFBConfigAttrib;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(config);
            Checks.check(value, 1);
        }
        return JNI.callPPPI(display, config, attribute, value, __functionAddress);
    }

    @NativeType(value="GLXWindow")
    public static long glXCreateWindow(@NativeType(value="Display *") long display, @NativeType(value="GLXFBConfig") long config, @NativeType(value="Window") long win, @Nullable @NativeType(value="int const *") int[] attrib_list) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXCreateWindow;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(config);
            Checks.checkNTSafe(attrib_list);
        }
        return JNI.callPPNPP(display, config, win, attrib_list, __functionAddress);
    }

    @NativeType(value="GLXPixmap")
    public static long glXCreatePixmap(@NativeType(value="Display *") long display, @NativeType(value="GLXFBConfig") long config, @NativeType(value="Pixmap") long pixmap, @Nullable @NativeType(value="int const *") int[] attrib_list) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXCreatePixmap;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(config);
            Checks.checkNTSafe(attrib_list);
        }
        return JNI.callPPNPP(display, config, pixmap, attrib_list, __functionAddress);
    }

    @NativeType(value="GLXPbuffer")
    public static long glXCreatePbuffer(@NativeType(value="Display *") long display, @NativeType(value="GLXFBConfig") long config, @Nullable @NativeType(value="int const *") int[] attrib_list) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXCreatePbuffer;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(config);
            Checks.checkNTSafe(attrib_list);
        }
        return JNI.callPPPP(display, config, attrib_list, __functionAddress);
    }

    public static void glXQueryDrawable(@NativeType(value="Display *") long display, @NativeType(value="GLXDrawable") long draw, int attribute, @NativeType(value="unsigned int *") int[] value) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXQueryDrawable;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(draw);
            Checks.check(value, 1);
        }
        JNI.callPPPV(display, draw, attribute, value, __functionAddress);
    }

    public static int glXQueryContext(@NativeType(value="Display *") long display, @NativeType(value="GLXContext") long ctx, int attribute, @NativeType(value="int *") int[] value) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXQueryContext;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(ctx);
            Checks.check(value, 1);
        }
        return JNI.callPPPI(display, ctx, attribute, value, __functionAddress);
    }
}

