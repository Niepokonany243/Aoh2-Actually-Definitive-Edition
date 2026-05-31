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

public class GLXSGIXSwapBarrier {
    protected GLXSGIXSwapBarrier() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLXCapabilities caps) {
        return Checks.checkFunctions(caps.glXBindSwapBarrierSGIX, caps.glXQueryMaxSwapBarriersSGIX);
    }

    public static void glXBindSwapBarrierSGIX(@NativeType(value="Display *") long display, @NativeType(value="GLXDrawable") long drawable, int barrier) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXBindSwapBarrierSGIX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(drawable);
        }
        JNI.callPPV(display, drawable, barrier, __functionAddress);
    }

    public static int nglXQueryMaxSwapBarriersSGIX(long display, int screen, long max) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXQueryMaxSwapBarriersSGIX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
        }
        return JNI.callPPI(display, screen, max, __functionAddress);
    }

    @NativeType(value="Bool")
    public static boolean glXQueryMaxSwapBarriersSGIX(@NativeType(value="Display *") long display, int screen, @NativeType(value="int *") IntBuffer max) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)max, 1);
        }
        return GLXSGIXSwapBarrier.nglXQueryMaxSwapBarriersSGIX(display, screen, MemoryUtil.memAddress(max)) != 0;
    }

    @NativeType(value="Bool")
    public static boolean glXQueryMaxSwapBarriersSGIX(@NativeType(value="Display *") long display, int screen, @NativeType(value="int *") int[] max) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXQueryMaxSwapBarriersSGIX;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(max, 1);
        }
        return JNI.callPPI(display, screen, max, __functionAddress) != 0;
    }
}

