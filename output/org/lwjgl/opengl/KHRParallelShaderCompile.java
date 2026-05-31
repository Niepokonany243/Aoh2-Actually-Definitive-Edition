/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class KHRParallelShaderCompile {
    public static final int GL_MAX_SHADER_COMPILER_THREADS_KHR = 37296;
    public static final int GL_COMPLETION_STATUS_KHR = 37297;

    protected KHRParallelShaderCompile() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glMaxShaderCompilerThreadsKHR);
    }

    public static native void glMaxShaderCompilerThreadsKHR(@NativeType(value="GLuint") int var0);

    static {
        GL.initialize();
    }
}

