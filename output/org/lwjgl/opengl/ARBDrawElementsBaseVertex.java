/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL32C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBDrawElementsBaseVertex {
    protected ARBDrawElementsBaseVertex() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glDrawElementsBaseVertex, caps.glDrawRangeElementsBaseVertex, caps.glDrawElementsInstancedBaseVertex, caps.glMultiDrawElementsBaseVertex);
    }

    public static void nglDrawElementsBaseVertex(int mode, int count, int type, long indices, int basevertex) {
        GL32C.nglDrawElementsBaseVertex(mode, count, type, indices, basevertex);
    }

    public static void glDrawElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="GLsizei") int count, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long indices, @NativeType(value="GLint") int basevertex) {
        GL32C.glDrawElementsBaseVertex(mode, count, type, indices, basevertex);
    }

    public static void glDrawElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer indices, @NativeType(value="GLint") int basevertex) {
        GL32C.glDrawElementsBaseVertex(mode, type, indices, basevertex);
    }

    public static void glDrawElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ByteBuffer indices, @NativeType(value="GLint") int basevertex) {
        GL32C.glDrawElementsBaseVertex(mode, indices, basevertex);
    }

    public static void glDrawElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ShortBuffer indices, @NativeType(value="GLint") int basevertex) {
        GL32C.glDrawElementsBaseVertex(mode, indices, basevertex);
    }

    public static void glDrawElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") IntBuffer indices, @NativeType(value="GLint") int basevertex) {
        GL32C.glDrawElementsBaseVertex(mode, indices, basevertex);
    }

    public static void nglDrawRangeElementsBaseVertex(int mode, int start, int end, int count, int type, long indices, int basevertex) {
        GL32C.nglDrawRangeElementsBaseVertex(mode, start, end, count, type, indices, basevertex);
    }

    public static void glDrawRangeElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="GLuint") int start, @NativeType(value="GLuint") int end, @NativeType(value="GLsizei") int count, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long indices, @NativeType(value="GLint") int basevertex) {
        GL32C.glDrawRangeElementsBaseVertex(mode, start, end, count, type, indices, basevertex);
    }

    public static void glDrawRangeElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="GLuint") int start, @NativeType(value="GLuint") int end, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer indices, @NativeType(value="GLint") int basevertex) {
        GL32C.glDrawRangeElementsBaseVertex(mode, start, end, type, indices, basevertex);
    }

    public static void glDrawRangeElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="GLuint") int start, @NativeType(value="GLuint") int end, @NativeType(value="void const *") ByteBuffer indices, @NativeType(value="GLint") int basevertex) {
        GL32C.glDrawRangeElementsBaseVertex(mode, start, end, indices, basevertex);
    }

    public static void glDrawRangeElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="GLuint") int start, @NativeType(value="GLuint") int end, @NativeType(value="void const *") ShortBuffer indices, @NativeType(value="GLint") int basevertex) {
        GL32C.glDrawRangeElementsBaseVertex(mode, start, end, indices, basevertex);
    }

    public static void glDrawRangeElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="GLuint") int start, @NativeType(value="GLuint") int end, @NativeType(value="void const *") IntBuffer indices, @NativeType(value="GLint") int basevertex) {
        GL32C.glDrawRangeElementsBaseVertex(mode, start, end, indices, basevertex);
    }

    public static void nglDrawElementsInstancedBaseVertex(int mode, int count, int type, long indices, int primcount, int basevertex) {
        GL32C.nglDrawElementsInstancedBaseVertex(mode, count, type, indices, primcount, basevertex);
    }

    public static void glDrawElementsInstancedBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="GLsizei") int count, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long indices, @NativeType(value="GLsizei") int primcount, @NativeType(value="GLint") int basevertex) {
        GL32C.glDrawElementsInstancedBaseVertex(mode, count, type, indices, primcount, basevertex);
    }

    public static void glDrawElementsInstancedBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer indices, @NativeType(value="GLsizei") int primcount, @NativeType(value="GLint") int basevertex) {
        GL32C.glDrawElementsInstancedBaseVertex(mode, type, indices, primcount, basevertex);
    }

    public static void glDrawElementsInstancedBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ByteBuffer indices, @NativeType(value="GLsizei") int primcount, @NativeType(value="GLint") int basevertex) {
        GL32C.glDrawElementsInstancedBaseVertex(mode, indices, primcount, basevertex);
    }

    public static void glDrawElementsInstancedBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ShortBuffer indices, @NativeType(value="GLsizei") int primcount, @NativeType(value="GLint") int basevertex) {
        GL32C.glDrawElementsInstancedBaseVertex(mode, indices, primcount, basevertex);
    }

    public static void glDrawElementsInstancedBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") IntBuffer indices, @NativeType(value="GLsizei") int primcount, @NativeType(value="GLint") int basevertex) {
        GL32C.glDrawElementsInstancedBaseVertex(mode, indices, primcount, basevertex);
    }

    public static void nglMultiDrawElementsBaseVertex(int mode, long count, int type, long indices, int drawcount, long basevertex) {
        GL32C.nglMultiDrawElementsBaseVertex(mode, count, type, indices, drawcount, basevertex);
    }

    public static void glMultiDrawElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="GLsizei const *") IntBuffer count, @NativeType(value="GLenum") int type, @NativeType(value="void const **") PointerBuffer indices, @NativeType(value="GLint *") IntBuffer basevertex) {
        GL32C.glMultiDrawElementsBaseVertex(mode, count, type, indices, basevertex);
    }

    public static void glMultiDrawElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="GLsizei const *") int[] count, @NativeType(value="GLenum") int type, @NativeType(value="void const **") PointerBuffer indices, @NativeType(value="GLint *") int[] basevertex) {
        GL32C.glMultiDrawElementsBaseVertex(mode, count, type, indices, basevertex);
    }

    static {
        GL.initialize();
    }
}

