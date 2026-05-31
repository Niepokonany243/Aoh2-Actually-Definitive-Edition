/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL42C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBBaseInstance {
    protected ARBBaseInstance() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glDrawArraysInstancedBaseInstance, caps.glDrawElementsInstancedBaseInstance, caps.glDrawElementsInstancedBaseVertexBaseInstance);
    }

    public static void glDrawArraysInstancedBaseInstance(@NativeType(value="GLenum") int mode, @NativeType(value="GLint") int first, @NativeType(value="GLsizei") int count, @NativeType(value="GLsizei") int primcount, @NativeType(value="GLuint") int baseinstance) {
        GL42C.glDrawArraysInstancedBaseInstance(mode, first, count, primcount, baseinstance);
    }

    public static void nglDrawElementsInstancedBaseInstance(int mode, int count, int type, long indices, int primcount, int baseinstance) {
        GL42C.nglDrawElementsInstancedBaseInstance(mode, count, type, indices, primcount, baseinstance);
    }

    public static void glDrawElementsInstancedBaseInstance(@NativeType(value="GLenum") int mode, @NativeType(value="GLsizei") int count, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long indices, @NativeType(value="GLsizei") int primcount, @NativeType(value="GLuint") int baseinstance) {
        GL42C.glDrawElementsInstancedBaseInstance(mode, count, type, indices, primcount, baseinstance);
    }

    public static void glDrawElementsInstancedBaseInstance(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer indices, @NativeType(value="GLsizei") int primcount, @NativeType(value="GLuint") int baseinstance) {
        GL42C.glDrawElementsInstancedBaseInstance(mode, type, indices, primcount, baseinstance);
    }

    public static void glDrawElementsInstancedBaseInstance(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ByteBuffer indices, @NativeType(value="GLsizei") int primcount, @NativeType(value="GLuint") int baseinstance) {
        GL42C.glDrawElementsInstancedBaseInstance(mode, indices, primcount, baseinstance);
    }

    public static void glDrawElementsInstancedBaseInstance(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ShortBuffer indices, @NativeType(value="GLsizei") int primcount, @NativeType(value="GLuint") int baseinstance) {
        GL42C.glDrawElementsInstancedBaseInstance(mode, indices, primcount, baseinstance);
    }

    public static void glDrawElementsInstancedBaseInstance(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") IntBuffer indices, @NativeType(value="GLsizei") int primcount, @NativeType(value="GLuint") int baseinstance) {
        GL42C.glDrawElementsInstancedBaseInstance(mode, indices, primcount, baseinstance);
    }

    public static void nglDrawElementsInstancedBaseVertexBaseInstance(int mode, int count, int type, long indices, int primcount, int basevertex, int baseinstance) {
        GL42C.nglDrawElementsInstancedBaseVertexBaseInstance(mode, count, type, indices, primcount, basevertex, baseinstance);
    }

    public static void glDrawElementsInstancedBaseVertexBaseInstance(@NativeType(value="GLenum") int mode, @NativeType(value="GLsizei") int count, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long indices, @NativeType(value="GLsizei") int primcount, @NativeType(value="GLint") int basevertex, @NativeType(value="GLuint") int baseinstance) {
        GL42C.glDrawElementsInstancedBaseVertexBaseInstance(mode, count, type, indices, primcount, basevertex, baseinstance);
    }

    public static void glDrawElementsInstancedBaseVertexBaseInstance(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer indices, @NativeType(value="GLsizei") int primcount, @NativeType(value="GLint") int basevertex, @NativeType(value="GLuint") int baseinstance) {
        GL42C.glDrawElementsInstancedBaseVertexBaseInstance(mode, type, indices, primcount, basevertex, baseinstance);
    }

    public static void glDrawElementsInstancedBaseVertexBaseInstance(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ByteBuffer indices, @NativeType(value="GLsizei") int primcount, @NativeType(value="GLint") int basevertex, @NativeType(value="GLuint") int baseinstance) {
        GL42C.glDrawElementsInstancedBaseVertexBaseInstance(mode, indices, primcount, basevertex, baseinstance);
    }

    public static void glDrawElementsInstancedBaseVertexBaseInstance(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ShortBuffer indices, @NativeType(value="GLsizei") int primcount, @NativeType(value="GLint") int basevertex, @NativeType(value="GLuint") int baseinstance) {
        GL42C.glDrawElementsInstancedBaseVertexBaseInstance(mode, indices, primcount, basevertex, baseinstance);
    }

    public static void glDrawElementsInstancedBaseVertexBaseInstance(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") IntBuffer indices, @NativeType(value="GLsizei") int primcount, @NativeType(value="GLint") int basevertex, @NativeType(value="GLuint") int baseinstance) {
        GL42C.glDrawElementsInstancedBaseVertexBaseInstance(mode, indices, primcount, basevertex, baseinstance);
    }

    static {
        GL.initialize();
    }
}

