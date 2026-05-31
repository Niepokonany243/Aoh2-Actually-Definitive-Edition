/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBMultiDrawIndirect {
    protected ARBMultiDrawIndirect() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glMultiDrawArraysIndirect, caps.glMultiDrawElementsIndirect);
    }

    public static void nglMultiDrawArraysIndirect(int mode, long indirect, int drawcount, int stride) {
        GL43C.nglMultiDrawArraysIndirect(mode, indirect, drawcount, stride);
    }

    public static void glMultiDrawArraysIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ByteBuffer indirect, @NativeType(value="GLsizei") int drawcount, @NativeType(value="GLsizei") int stride) {
        GL43C.glMultiDrawArraysIndirect(mode, indirect, drawcount, stride);
    }

    public static void glMultiDrawArraysIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") long indirect, @NativeType(value="GLsizei") int drawcount, @NativeType(value="GLsizei") int stride) {
        GL43C.glMultiDrawArraysIndirect(mode, indirect, drawcount, stride);
    }

    public static void glMultiDrawArraysIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") IntBuffer indirect, @NativeType(value="GLsizei") int drawcount, @NativeType(value="GLsizei") int stride) {
        GL43C.glMultiDrawArraysIndirect(mode, indirect, drawcount, stride);
    }

    public static void nglMultiDrawElementsIndirect(int mode, int type, long indirect, int drawcount, int stride) {
        GL43C.nglMultiDrawElementsIndirect(mode, type, indirect, drawcount, stride);
    }

    public static void glMultiDrawElementsIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer indirect, @NativeType(value="GLsizei") int drawcount, @NativeType(value="GLsizei") int stride) {
        GL43C.glMultiDrawElementsIndirect(mode, type, indirect, drawcount, stride);
    }

    public static void glMultiDrawElementsIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long indirect, @NativeType(value="GLsizei") int drawcount, @NativeType(value="GLsizei") int stride) {
        GL43C.glMultiDrawElementsIndirect(mode, type, indirect, drawcount, stride);
    }

    public static void glMultiDrawElementsIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer indirect, @NativeType(value="GLsizei") int drawcount, @NativeType(value="GLsizei") int stride) {
        GL43C.glMultiDrawElementsIndirect(mode, type, indirect, drawcount, stride);
    }

    public static void glMultiDrawArraysIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") int[] indirect, @NativeType(value="GLsizei") int drawcount, @NativeType(value="GLsizei") int stride) {
        GL43C.glMultiDrawArraysIndirect(mode, indirect, drawcount, stride);
    }

    public static void glMultiDrawElementsIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] indirect, @NativeType(value="GLsizei") int drawcount, @NativeType(value="GLsizei") int stride) {
        GL43C.glMultiDrawElementsIndirect(mode, type, indirect, drawcount, stride);
    }

    static {
        GL.initialize();
    }
}

