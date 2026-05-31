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
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.linux.XVisualInfo;

public class GLX {
    public static final int GLXBadContext = 0;
    public static final int GLXBadContextState = 1;
    public static final int GLXBadDrawable = 2;
    public static final int GLXBadPixmap = 3;
    public static final int GLXBadContextTag = 4;
    public static final int GLXBadCurrentWindow = 5;
    public static final int GLXBadRenderRequest = 6;
    public static final int GLXBadLargeRequest = 7;
    public static final int GLXUnsupportedPrivateRequest = 8;
    public static final int GLXBadFBConfig = 9;
    public static final int GLXBadPbuffer = 10;
    public static final int GLXBadCurrentDrawable = 11;
    public static final int GLXBadWindow = 12;
    public static final int GLX_USE_GL = 1;
    public static final int GLX_BUFFER_SIZE = 2;
    public static final int GLX_LEVEL = 3;
    public static final int GLX_RGBA = 4;
    public static final int GLX_DOUBLEBUFFER = 5;
    public static final int GLX_STEREO = 6;
    public static final int GLX_AUX_BUFFERS = 7;
    public static final int GLX_RED_SIZE = 8;
    public static final int GLX_GREEN_SIZE = 9;
    public static final int GLX_BLUE_SIZE = 10;
    public static final int GLX_ALPHA_SIZE = 11;
    public static final int GLX_DEPTH_SIZE = 12;
    public static final int GLX_STENCIL_SIZE = 13;
    public static final int GLX_ACCUM_RED_SIZE = 14;
    public static final int GLX_ACCUM_GREEN_SIZE = 15;
    public static final int GLX_ACCUM_BLUE_SIZE = 16;
    public static final int GLX_ACCUM_ALPHA_SIZE = 17;
    public static final int GLX_BAD_SCREEN = 1;
    public static final int GLX_BAD_ATTRIBUTE = 2;
    public static final int GLX_NO_EXTENSION = 3;
    public static final int GLX_BAD_VISUAL = 4;
    public static final int GLX_BAD_CONTEXT = 5;
    public static final int GLX_BAD_VALUE = 6;
    public static final int GLX_BAD_ENUM = 7;

    protected GLX() {
        throw new UnsupportedOperationException();
    }

    public static int nglXQueryExtension(long display, long error_base, long event_base) {
        long __functionAddress = Functions.QueryExtension;
        if (Checks.CHECKS) {
            Checks.check(display);
        }
        return JNI.callPPPI(display, error_base, event_base, __functionAddress);
    }

    @NativeType(value="Bool")
    public static boolean glXQueryExtension(@NativeType(value="Display *") long display, @NativeType(value="int *") IntBuffer error_base, @NativeType(value="int *") IntBuffer event_base) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)error_base, 1);
            Checks.check((Buffer)event_base, 1);
        }
        return GLX.nglXQueryExtension(display, MemoryUtil.memAddress(error_base), MemoryUtil.memAddress(event_base)) != 0;
    }

    public static int nglXQueryVersion(long display, long major, long minor) {
        long __functionAddress = Functions.QueryVersion;
        if (Checks.CHECKS) {
            Checks.check(display);
        }
        return JNI.callPPPI(display, major, minor, __functionAddress);
    }

    @NativeType(value="Bool")
    public static boolean glXQueryVersion(@NativeType(value="Display *") long display, @NativeType(value="int *") IntBuffer major, @NativeType(value="int *") IntBuffer minor) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)major, 1);
            Checks.check((Buffer)minor, 1);
        }
        return GLX.nglXQueryVersion(display, MemoryUtil.memAddress(major), MemoryUtil.memAddress(minor)) != 0;
    }

    public static int nglXGetConfig(long display, long visual, int attribute, long value) {
        long __functionAddress = Functions.GetConfig;
        if (Checks.CHECKS) {
            Checks.check(display);
            XVisualInfo.validate(visual);
        }
        return JNI.callPPPI(display, visual, attribute, value, __functionAddress);
    }

    public static int glXGetConfig(@NativeType(value="Display *") long display, @NativeType(value="XVisualInfo *") XVisualInfo visual, int attribute, @NativeType(value="int *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        return GLX.nglXGetConfig(display, visual.address(), attribute, MemoryUtil.memAddress(value));
    }

    public static long nglXChooseVisual(long display, int screen, long attrib_list) {
        long __functionAddress = Functions.ChooseVisual;
        if (Checks.CHECKS) {
            Checks.check(display);
        }
        return JNI.callPPP(display, screen, attrib_list, __functionAddress);
    }

    @Nullable
    @NativeType(value="XVisualInfo *")
    public static XVisualInfo glXChooseVisual(@NativeType(value="Display *") long display, int screen, @Nullable @NativeType(value="int *") IntBuffer attrib_list) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(attrib_list);
        }
        long __result = GLX.nglXChooseVisual(display, screen, MemoryUtil.memAddressSafe(attrib_list));
        return XVisualInfo.createSafe(__result);
    }

    public static long nglXCreateContext(long display, long visual, long share_list, int direct) {
        long __functionAddress = Functions.CreateContext;
        if (Checks.CHECKS) {
            Checks.check(display);
            XVisualInfo.validate(visual);
        }
        return JNI.callPPPP(display, visual, share_list, direct, __functionAddress);
    }

    @NativeType(value="GLXContext")
    public static long glXCreateContext(@NativeType(value="Display *") long display, @NativeType(value="XVisualInfo *") XVisualInfo visual, @NativeType(value="GLXContext") long share_list, @NativeType(value="Bool") boolean direct) {
        return GLX.nglXCreateContext(display, visual.address(), share_list, direct ? 1 : 0);
    }

    @NativeType(value="Bool")
    public static boolean glXMakeCurrent(@NativeType(value="Display *") long display, @NativeType(value="GLXDrawable") long draw, @NativeType(value="GLXContext") long ctx) {
        long __functionAddress = Functions.MakeCurrent;
        if (Checks.CHECKS) {
            Checks.check(display);
        }
        return JNI.callPPPI(display, draw, ctx, __functionAddress) != 0;
    }

    public static void glXCopyContext(@NativeType(value="Display *") long display, @NativeType(value="GLXContext") long source, @NativeType(value="GLXContext") long dest, @NativeType(value="unsigned long") long mask) {
        long __functionAddress = Functions.CopyContext;
        if (Checks.CHECKS) {
            Checks.check(display);
            Checks.check(source);
            Checks.check(dest);
        }
        JNI.callPPPNV(display, source, dest, mask, __functionAddress);
    }

    @NativeType(value="Bool")
    public static boolean glXIsDirect(@NativeType(value="Display *") long display, @NativeType(value="GLXContext") long ctx) {
        long __functionAddress = Functions.IsDirect;
        if (Checks.CHECKS) {
            Checks.check(display);
            Checks.check(ctx);
        }
        return JNI.callPPI(display, ctx, __functionAddress) != 0;
    }

    public static void glXDestroyContext(@NativeType(value="Display *") long display, @NativeType(value="GLXContext") long ctx) {
        long __functionAddress = Functions.DestroyContext;
        if (Checks.CHECKS) {
            Checks.check(display);
            Checks.check(ctx);
        }
        JNI.callPPV(display, ctx, __functionAddress);
    }

    @NativeType(value="GLXContext")
    public static long glXGetCurrentContext() {
        long __functionAddress = Functions.GetCurrentContext;
        return JNI.callP(__functionAddress);
    }

    @NativeType(value="GLXDrawable")
    public static long glXGetCurrentDrawable() {
        long __functionAddress = Functions.GetCurrentDrawable;
        return JNI.callP(__functionAddress);
    }

    public static void glXWaitGL() {
        long __functionAddress = Functions.WaitGL;
        JNI.callV(__functionAddress);
    }

    public static void glXWaitX() {
        long __functionAddress = Functions.WaitX;
        JNI.callV(__functionAddress);
    }

    public static void glXSwapBuffers(@NativeType(value="Display *") long display, @NativeType(value="GLXDrawable") long draw) {
        long __functionAddress = Functions.SwapBuffers;
        if (Checks.CHECKS) {
            Checks.check(display);
            Checks.check(draw);
        }
        JNI.callPPV(display, draw, __functionAddress);
    }

    public static void glXUseXFont(@NativeType(value="Font") long font, int first, int count, int list_base) {
        long __functionAddress = Functions.UseXFont;
        JNI.callNV(font, first, count, list_base, __functionAddress);
    }

    public static long nglXCreateGLXPixmap(long display, long visual, long pixmap) {
        long __functionAddress = Functions.CreateGLXPixmap;
        if (Checks.CHECKS) {
            Checks.check(display);
            XVisualInfo.validate(visual);
        }
        return JNI.callPPNP(display, visual, pixmap, __functionAddress);
    }

    @NativeType(value="GLXPixmap")
    public static long glXCreateGLXPixmap(@NativeType(value="Display *") long display, @NativeType(value="XVisualInfo *") XVisualInfo visual, @NativeType(value="Pixmap") long pixmap) {
        return GLX.nglXCreateGLXPixmap(display, visual.address(), pixmap);
    }

    public static void glXDestroyGLXPixmap(@NativeType(value="Display *") long display, @NativeType(value="GLXPixmap") long pixmap) {
        long __functionAddress = Functions.DestroyGLXPixmap;
        if (Checks.CHECKS) {
            Checks.check(display);
            Checks.check(pixmap);
        }
        JNI.callPPV(display, pixmap, __functionAddress);
    }

    @NativeType(value="Bool")
    public static boolean glXQueryExtension(@NativeType(value="Display *") long display, @NativeType(value="int *") int[] error_base, @NativeType(value="int *") int[] event_base) {
        long __functionAddress = Functions.QueryExtension;
        if (Checks.CHECKS) {
            Checks.check(display);
            Checks.check(error_base, 1);
            Checks.check(event_base, 1);
        }
        return JNI.callPPPI(display, error_base, event_base, __functionAddress) != 0;
    }

    @NativeType(value="Bool")
    public static boolean glXQueryVersion(@NativeType(value="Display *") long display, @NativeType(value="int *") int[] major, @NativeType(value="int *") int[] minor) {
        long __functionAddress = Functions.QueryVersion;
        if (Checks.CHECKS) {
            Checks.check(display);
            Checks.check(major, 1);
            Checks.check(minor, 1);
        }
        return JNI.callPPPI(display, major, minor, __functionAddress) != 0;
    }

    public static int glXGetConfig(@NativeType(value="Display *") long display, @NativeType(value="XVisualInfo *") XVisualInfo visual, int attribute, @NativeType(value="int *") int[] value) {
        long __functionAddress = Functions.GetConfig;
        if (Checks.CHECKS) {
            Checks.check(display);
            Checks.check(value, 1);
            XVisualInfo.validate(visual.address());
        }
        return JNI.callPPPI(display, visual.address(), attribute, value, __functionAddress);
    }

    @Nullable
    @NativeType(value="XVisualInfo *")
    public static XVisualInfo glXChooseVisual(@NativeType(value="Display *") long display, int screen, @Nullable @NativeType(value="int *") int[] attrib_list) {
        long __functionAddress = Functions.ChooseVisual;
        if (Checks.CHECKS) {
            Checks.check(display);
            Checks.checkNTSafe(attrib_list);
        }
        long __result = JNI.callPPP(display, screen, attrib_list, __functionAddress);
        return XVisualInfo.createSafe(__result);
    }

    public static final class Functions {
        public static final long QueryExtension = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXQueryExtension");
        public static final long QueryVersion = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXQueryVersion");
        public static final long GetConfig = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXGetConfig");
        public static final long ChooseVisual = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXChooseVisual");
        public static final long CreateContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXCreateContext");
        public static final long MakeCurrent = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXMakeCurrent");
        public static final long CopyContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXCopyContext");
        public static final long IsDirect = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXIsDirect");
        public static final long DestroyContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXDestroyContext");
        public static final long GetCurrentContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXGetCurrentContext");
        public static final long GetCurrentDrawable = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXGetCurrentDrawable");
        public static final long WaitGL = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXWaitGL");
        public static final long WaitX = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXWaitX");
        public static final long SwapBuffers = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXSwapBuffers");
        public static final long UseXFont = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXUseXFont");
        public static final long CreateGLXPixmap = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXCreateGLXPixmap");
        public static final long DestroyGLXPixmap = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXDestroyGLXPixmap");

        private Functions() {
        }
    }
}

