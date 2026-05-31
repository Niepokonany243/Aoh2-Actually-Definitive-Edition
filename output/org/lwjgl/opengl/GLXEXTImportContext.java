/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLXCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GLXEXTImportContext {
    public static final int GLX_SHARE_CONTEXT_EXT = 32778;
    public static final int GLX_VISUAL_ID_EXT = 32779;
    public static final int GLX_SCREEN_EXT = 32780;

    protected GLXEXTImportContext() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLXCapabilities caps) {
        return Checks.checkFunctions(caps.glXGetCurrentDisplayEXT, caps.glXQueryContextInfoEXT, caps.glXGetContextIDEXT, caps.glXImportContextEXT, caps.glXFreeContextEXT);
    }

    @NativeType(value="Display *")
    public static long glXGetCurrentDisplayEXT() {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXGetCurrentDisplayEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callP(__functionAddress);
    }

    public static int nglXQueryContextInfoEXT(long display, long context, int attribute, long value) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXQueryContextInfoEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(context);
        }
        return JNI.callPPPI(display, context, attribute, value, __functionAddress);
    }

    public static int glXQueryContextInfoEXT(@NativeType(value="Display *") long display, @NativeType(value="GLXContext") long context, int attribute, @NativeType(value="int *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        return GLXEXTImportContext.nglXQueryContextInfoEXT(display, context, attribute, MemoryUtil.memAddress(value));
    }

    @NativeType(value="GLXContextID")
    public static long glXGetContextIDEXT(@NativeType(value="GLXContext const") long context) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXGetContextIDEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(context);
        }
        return JNI.callPN(context, __functionAddress);
    }

    @NativeType(value="GLXContext")
    public static long glXImportContextEXT(@NativeType(value="Display *") long display, @NativeType(value="GLXContextID") long contextID) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXImportContextEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
        }
        return JNI.callPNP(display, contextID, __functionAddress);
    }

    public static void glXFreeContextEXT(@NativeType(value="Display *") long display, @NativeType(value="GLXContext") long context) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXFreeContextEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(context);
        }
        JNI.callPPV(display, context, __functionAddress);
    }

    public static int glXQueryContextInfoEXT(@NativeType(value="Display *") long display, @NativeType(value="GLXContext") long context, int attribute, @NativeType(value="int *") int[] value) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXQueryContextInfoEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(context);
            Checks.check(value, 1);
        }
        return JNI.callPPPI(display, context, attribute, value, __functionAddress);
    }
}

