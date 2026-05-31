/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLX;
import org.lwjgl.opengl.GLXCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GLX11
extends GLX {
    public static final int GLX_VENDOR = 1;
    public static final int GLX_VERSION = 2;
    public static final int GLX_EXTENSIONS = 3;

    protected GLX11() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLXCapabilities caps) {
        return Checks.checkFunctions(caps.glXQueryExtensionsString, caps.glXGetClientString, caps.glXQueryServerString);
    }

    public static long nglXQueryExtensionsString(long display, int screen) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXQueryExtensionsString;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
        }
        return JNI.callPP(display, screen, __functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String glXQueryExtensionsString(@NativeType(value="Display *") long display, int screen) {
        long __result = GLX11.nglXQueryExtensionsString(display, screen);
        return MemoryUtil.memASCIISafe(__result);
    }

    public static long nglXGetClientString(long display, int name) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXGetClientString;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
        }
        return JNI.callPP(display, name, __functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String glXGetClientString(@NativeType(value="Display *") long display, int name) {
        long __result = GLX11.nglXGetClientString(display, name);
        return MemoryUtil.memASCIISafe(__result);
    }

    public static long nglXQueryServerString(long display, int screen, int name) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXQueryServerString;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
        }
        return JNI.callPP(display, screen, name, __functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String glXQueryServerString(@NativeType(value="Display *") long display, int screen, int name) {
        long __result = GLX11.nglXQueryServerString(display, screen, name);
        return MemoryUtil.memASCIISafe(__result);
    }
}

