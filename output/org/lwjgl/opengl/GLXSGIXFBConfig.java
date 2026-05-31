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
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLXCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.linux.XVisualInfo;

public class GLXSGIXFBConfig {
    public static final int GLX_DRAWABLE_TYPE_SGIX = 32784;
    public static final int GLX_RENDER_TYPE_SGIX = 32785;
    public static final int GLX_X_RENDERABLE_SGIX = 32786;
    public static final int GLX_FBCONFIG_ID_SGIX = 32787;
    public static final int GLX_SCREEN_EXT = 32780;
    public static final int GLX_WINDOW_BIT_SGIX = 1;
    public static final int GLX_PIXMAP_BIT_SGIX = 2;
    public static final int GLX_RGBA_BIT_SGIX = 1;
    public static final int GLX_COLOR_INDEX_BIT_SGIX = 2;
    public static final int GLX_RGBA_TYPE_SGIX = 32788;
    public static final int GLX_COLOR_INDEX_TYPE_SGIX = 32789;

    protected GLXSGIXFBConfig() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLXCapabilities caps) {
        return Checks.checkFunctions(caps.glXGetFBConfigAttribSGIX, caps.glXChooseFBConfigSGIX, caps.glXCreateGLXPixmapWithConfigSGIX, caps.glXCreateContextWithConfigSGIX, caps.glXGetVisualFromFBConfigSGIX, caps.glXGetFBConfigFromVisualSGIX);
    }

    public static int nglXGetFBConfigAttribSGIX(long display, long config, int attribute, long value) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXGetFBConfigAttribSGIX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(config);
        }
        return JNI.callPPPI(display, config, attribute, value, __functionAddress);
    }

    public static int glXGetFBConfigAttribSGIX(@NativeType(value="Display *") long display, @NativeType(value="GLXFBConfigSGIX") long config, int attribute, @NativeType(value="int *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        return GLXSGIXFBConfig.nglXGetFBConfigAttribSGIX(display, config, attribute, MemoryUtil.memAddress(value));
    }

    public static long nglXChooseFBConfigSGIX(long display, int screen, long attrib_list, long nelements) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXChooseFBConfigSGIX;
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
    @NativeType(value="GLXFBConfigSGIX *")
    public static PointerBuffer glXChooseFBConfigSGIX(@NativeType(value="Display *") long display, int screen, @Nullable @NativeType(value="int const *") IntBuffer attrib_list) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(attrib_list);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        IntBuffer nelements = stack.callocInt(1);
        try {
            long __result = GLXSGIXFBConfig.nglXChooseFBConfigSGIX(display, screen, MemoryUtil.memAddressSafe(attrib_list), MemoryUtil.memAddress(nelements));
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(__result, nelements.get(0));
            return pointerBuffer;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="GLXPixmap")
    public static long glXCreateGLXPixmapWithConfigSGIX(@NativeType(value="Display *") long display, @NativeType(value="GLXFBConfig") long config, @NativeType(value="Pixmap") long pixmap) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXCreateGLXPixmapWithConfigSGIX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(config);
        }
        return JNI.callPPNP(display, config, pixmap, __functionAddress);
    }

    @NativeType(value="GLXContext")
    public static long glXCreateContextWithConfigSGIX(@NativeType(value="Display *") long display, @NativeType(value="GLXFBConfig") long config, int render_type, @NativeType(value="GLXContext") long share_list, @NativeType(value="Bool") boolean direct) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXCreateContextWithConfigSGIX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(config);
            Checks.check(share_list);
        }
        return JNI.callPPPP(display, config, render_type, share_list, direct ? 1 : 0, __functionAddress);
    }

    public static long nglXGetVisualFromFBConfigSGIX(long display, long config) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXGetVisualFromFBConfigSGIX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(config);
        }
        return JNI.callPPP(display, config, __functionAddress);
    }

    @Nullable
    @NativeType(value="XVisualInfo *")
    public static XVisualInfo glXGetVisualFromFBConfigSGIX(@NativeType(value="Display *") long display, @NativeType(value="GLXFBConfig") long config) {
        long __result = GLXSGIXFBConfig.nglXGetVisualFromFBConfigSGIX(display, config);
        return XVisualInfo.createSafe(__result);
    }

    public static long nglXGetFBConfigFromVisualSGIX(long display, long vis) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXGetFBConfigFromVisualSGIX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            XVisualInfo.validate(vis);
        }
        return JNI.callPPP(display, vis, __functionAddress);
    }

    @NativeType(value="GLXFBConfigSGIX")
    public static long glXGetFBConfigFromVisualSGIX(@NativeType(value="Display *") long display, @NativeType(value="XVisualInfo *") XVisualInfo vis) {
        return GLXSGIXFBConfig.nglXGetFBConfigFromVisualSGIX(display, vis.address());
    }

    public static int glXGetFBConfigAttribSGIX(@NativeType(value="Display *") long display, @NativeType(value="GLXFBConfigSGIX") long config, int attribute, @NativeType(value="int *") int[] value) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXGetFBConfigAttribSGIX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(config);
            Checks.check(value, 1);
        }
        return JNI.callPPPI(display, config, attribute, value, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="GLXFBConfigSGIX *")
    public static PointerBuffer glXChooseFBConfigSGIX(@NativeType(value="Display *") long display, int screen, @Nullable @NativeType(value="int const *") int[] attrib_list) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXChooseFBConfigSGIX;
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
}

