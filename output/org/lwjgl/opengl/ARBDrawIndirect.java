/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL40C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBDrawIndirect {
    public static final int GL_DRAW_INDIRECT_BUFFER = 36671;
    public static final int GL_DRAW_INDIRECT_BUFFER_BINDING = 36675;

    protected ARBDrawIndirect() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glDrawArraysIndirect, caps.glDrawElementsIndirect);
    }

    public static void nglDrawArraysIndirect(int mode, long indirect) {
        GL40C.nglDrawArraysIndirect(mode, indirect);
    }

    public static void glDrawArraysIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ByteBuffer indirect) {
        GL40C.glDrawArraysIndirect(mode, indirect);
    }

    public static void glDrawArraysIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") long indirect) {
        GL40C.glDrawArraysIndirect(mode, indirect);
    }

    public static void glDrawArraysIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") IntBuffer indirect) {
        GL40C.glDrawArraysIndirect(mode, indirect);
    }

    public static void nglDrawElementsIndirect(int mode, int type, long indirect) {
        GL40C.nglDrawElementsIndirect(mode, type, indirect);
    }

    public static void glDrawElementsIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer indirect) {
        GL40C.glDrawElementsIndirect(mode, type, indirect);
    }

    public static void glDrawElementsIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long indirect) {
        GL40C.glDrawElementsIndirect(mode, type, indirect);
    }

    public static void glDrawElementsIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer indirect) {
        GL40C.glDrawElementsIndirect(mode, type, indirect);
    }

    public static void glDrawArraysIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") int[] indirect) {
        GL40C.glDrawArraysIndirect(mode, indirect);
    }

    public static void glDrawElementsIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] indirect) {
        GL40C.glDrawElementsIndirect(mode, type, indirect);
    }

    static {
        GL.initialize();
    }
}

