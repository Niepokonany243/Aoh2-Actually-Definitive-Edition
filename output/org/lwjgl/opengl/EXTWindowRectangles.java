/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTWindowRectangles {
    public static final int GL_INCLUSIVE_EXT = 36624;
    public static final int GL_EXCLUSIVE_EXT = 36625;
    public static final int GL_WINDOW_RECTANGLE_EXT = 36626;
    public static final int GL_WINDOW_RECTANGLE_MODE_EXT = 36627;
    public static final int GL_MAX_WINDOW_RECTANGLES_EXT = 36628;
    public static final int GL_NUM_WINDOW_RECTANGLES_EXT = 36629;

    protected EXTWindowRectangles() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glWindowRectanglesEXT);
    }

    public static native void nglWindowRectanglesEXT(int var0, int var1, long var2);

    public static void glWindowRectanglesEXT(@NativeType(value="GLenum") int mode, @Nullable @NativeType(value="GLint const *") IntBuffer box) {
        EXTWindowRectangles.nglWindowRectanglesEXT(mode, Checks.remainingSafe(box) >> 2, MemoryUtil.memAddressSafe(box));
    }

    public static void glWindowRectanglesEXT(@NativeType(value="GLenum") int mode, @Nullable @NativeType(value="GLint const *") int[] box) {
        long __functionAddress = GL.getICD().glWindowRectanglesEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(mode, Checks.lengthSafe(box) >> 2, box, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

