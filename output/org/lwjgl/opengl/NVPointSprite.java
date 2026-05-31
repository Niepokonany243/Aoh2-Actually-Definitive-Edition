/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVPointSprite {
    public static final int GL_POINT_SPRITE_NV = 34913;
    public static final int GL_COORD_REPLACE_NV = 34914;
    public static final int GL_POINT_SPRITE_R_MODE_NV = 34915;

    protected NVPointSprite() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glPointParameteriNV, caps.glPointParameterivNV);
    }

    public static native void glPointParameteriNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1);

    public static native void nglPointParameterivNV(int var0, long var1);

    public static void glPointParameterivNV(@NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        NVPointSprite.nglPointParameterivNV(pname, MemoryUtil.memAddress(params));
    }

    public static void glPointParameterivNV(@NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = GL.getICD().glPointParameterivNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(pname, params, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

