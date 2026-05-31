/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTSeparateShaderObjects {
    public static final int GL_ACTIVE_PROGRAM_EXT = 35725;

    protected EXTSeparateShaderObjects() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glUseShaderProgramEXT, caps.glActiveProgramEXT, caps.glCreateShaderProgramEXT);
    }

    public static native void glUseShaderProgramEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glActiveProgramEXT(@NativeType(value="GLuint") int var0);

    public static native int nglCreateShaderProgramEXT(int var0, long var1);

    @NativeType(value="GLuint")
    public static int glCreateShaderProgramEXT(@NativeType(value="GLenum") int type, @NativeType(value="GLchar const *") ByteBuffer string) {
        if (Checks.CHECKS) {
            Checks.checkNT1(string);
        }
        return EXTSeparateShaderObjects.nglCreateShaderProgramEXT(type, MemoryUtil.memAddress(string));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLuint")
    public static int glCreateShaderProgramEXT(@NativeType(value="GLenum") int type, @NativeType(value="GLchar const *") CharSequence string) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(string, true);
            long stringEncoded = stack.getPointerAddress();
            int n = EXTSeparateShaderObjects.nglCreateShaderProgramEXT(type, stringEncoded);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    static {
        GL.initialize();
    }
}

