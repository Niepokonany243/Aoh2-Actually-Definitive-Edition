/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL33C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBBlendFuncExtended {
    public static final int GL_SRC1_COLOR = 35065;
    public static final int GL_ONE_MINUS_SRC1_COLOR = 35066;
    public static final int GL_ONE_MINUS_SRC1_ALPHA = 35067;
    public static final int GL_MAX_DUAL_SOURCE_DRAW_BUFFERS = 35068;

    protected ARBBlendFuncExtended() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glBindFragDataLocationIndexed, caps.glGetFragDataIndex);
    }

    public static void nglBindFragDataLocationIndexed(int program, int colorNumber, int index, long name) {
        GL33C.nglBindFragDataLocationIndexed(program, colorNumber, index, name);
    }

    public static void glBindFragDataLocationIndexed(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int colorNumber, @NativeType(value="GLuint") int index, @NativeType(value="GLchar const *") ByteBuffer name) {
        GL33C.glBindFragDataLocationIndexed(program, colorNumber, index, name);
    }

    public static void glBindFragDataLocationIndexed(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int colorNumber, @NativeType(value="GLuint") int index, @NativeType(value="GLchar const *") CharSequence name) {
        GL33C.glBindFragDataLocationIndexed(program, colorNumber, index, name);
    }

    public static int nglGetFragDataIndex(int program, long name) {
        return GL33C.nglGetFragDataIndex(program, name);
    }

    @NativeType(value="GLint")
    public static int glGetFragDataIndex(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") ByteBuffer name) {
        return GL33C.glGetFragDataIndex(program, name);
    }

    @NativeType(value="GLint")
    public static int glGetFragDataIndex(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") CharSequence name) {
        return GL33C.glGetFragDataIndex(program, name);
    }

    static {
        GL.initialize();
    }
}

