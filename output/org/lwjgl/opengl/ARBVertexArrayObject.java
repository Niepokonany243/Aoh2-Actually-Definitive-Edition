/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL30C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBVertexArrayObject {
    public static final int GL_VERTEX_ARRAY_BINDING = 34229;

    protected ARBVertexArrayObject() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glBindVertexArray, caps.glDeleteVertexArrays, caps.glGenVertexArrays, caps.glIsVertexArray);
    }

    public static void glBindVertexArray(@NativeType(value="GLuint") int array) {
        GL30C.glBindVertexArray(array);
    }

    public static void nglDeleteVertexArrays(int n, long arrays) {
        GL30C.nglDeleteVertexArrays(n, arrays);
    }

    public static void glDeleteVertexArrays(@NativeType(value="GLuint const *") IntBuffer arrays) {
        GL30C.glDeleteVertexArrays(arrays);
    }

    public static void glDeleteVertexArrays(@NativeType(value="GLuint const *") int array) {
        GL30C.glDeleteVertexArrays(array);
    }

    public static void nglGenVertexArrays(int n, long arrays) {
        GL30C.nglGenVertexArrays(n, arrays);
    }

    public static void glGenVertexArrays(@NativeType(value="GLuint *") IntBuffer arrays) {
        GL30C.glGenVertexArrays(arrays);
    }

    @NativeType(value="void")
    public static int glGenVertexArrays() {
        return GL30C.glGenVertexArrays();
    }

    @NativeType(value="GLboolean")
    public static boolean glIsVertexArray(@NativeType(value="GLuint") int array) {
        return GL30C.glIsVertexArray(array);
    }

    public static void glDeleteVertexArrays(@NativeType(value="GLuint const *") int[] arrays) {
        GL30C.glDeleteVertexArrays(arrays);
    }

    public static void glGenVertexArrays(@NativeType(value="GLuint *") int[] arrays) {
        GL30C.glGenVertexArrays(arrays);
    }

    static {
        GL.initialize();
    }
}

