/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTGPUProgramParameters {
    protected EXTGPUProgramParameters() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glProgramEnvParameters4fvEXT, caps.glProgramLocalParameters4fvEXT);
    }

    public static native void nglProgramEnvParameters4fvEXT(int var0, int var1, int var2, long var3);

    public static void glProgramEnvParameters4fvEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer params) {
        EXTGPUProgramParameters.nglProgramEnvParameters4fvEXT(target, index, params.remaining() >> 2, MemoryUtil.memAddress(params));
    }

    public static native void nglProgramLocalParameters4fvEXT(int var0, int var1, int var2, long var3);

    public static void glProgramLocalParameters4fvEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer params) {
        EXTGPUProgramParameters.nglProgramLocalParameters4fvEXT(target, index, params.remaining() >> 2, MemoryUtil.memAddress(params));
    }

    public static void glProgramEnvParameters4fvEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] params) {
        long __functionAddress = GL.getICD().glProgramEnvParameters4fvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, index, params.length >> 2, params, __functionAddress);
    }

    public static void glProgramLocalParameters4fvEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] params) {
        long __functionAddress = GL.getICD().glProgramLocalParameters4fvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, index, params.length >> 2, params, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

