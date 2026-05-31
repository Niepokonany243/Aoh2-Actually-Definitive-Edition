/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL42C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBInternalformatQuery {
    public static final int GL_NUM_SAMPLE_COUNTS = 37760;

    protected ARBInternalformatQuery() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glGetInternalformativ);
    }

    public static void nglGetInternalformativ(int target, int internalformat, int pname, int bufSize, long params) {
        GL42C.nglGetInternalformativ(target, internalformat, pname, bufSize, params);
    }

    public static void glGetInternalformativ(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL42C.glGetInternalformativ(target, internalformat, pname, params);
    }

    @NativeType(value="void")
    public static int glGetInternalformati(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int pname) {
        return GL42C.glGetInternalformati(target, internalformat, pname);
    }

    public static void glGetInternalformativ(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL42C.glGetInternalformativ(target, internalformat, pname, params);
    }

    static {
        GL.initialize();
    }
}

