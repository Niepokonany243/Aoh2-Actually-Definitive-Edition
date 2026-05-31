/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL44C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBMultiBind {
    protected ARBMultiBind() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glBindBuffersBase, caps.glBindBuffersRange, caps.glBindTextures, caps.glBindSamplers, caps.glBindImageTextures, caps.glBindVertexBuffers);
    }

    public static void nglBindBuffersBase(int target, int first, int count, long buffers) {
        GL44C.nglBindBuffersBase(target, first, count, buffers);
    }

    public static void glBindBuffersBase(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") IntBuffer buffers) {
        GL44C.glBindBuffersBase(target, first, buffers);
    }

    public static void nglBindBuffersRange(int target, int first, int count, long buffers, long offsets, long sizes) {
        GL44C.nglBindBuffersRange(target, first, count, buffers, offsets, sizes);
    }

    public static void glBindBuffersRange(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") IntBuffer buffers, @Nullable @NativeType(value="GLintptr const *") PointerBuffer offsets, @Nullable @NativeType(value="GLsizeiptr const *") PointerBuffer sizes) {
        GL44C.glBindBuffersRange(target, first, buffers, offsets, sizes);
    }

    public static void nglBindTextures(int first, int count, long textures) {
        GL44C.nglBindTextures(first, count, textures);
    }

    public static void glBindTextures(@NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") IntBuffer textures) {
        GL44C.glBindTextures(first, textures);
    }

    public static void nglBindSamplers(int first, int count, long samplers) {
        GL44C.nglBindSamplers(first, count, samplers);
    }

    public static void glBindSamplers(@NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") IntBuffer samplers) {
        GL44C.glBindSamplers(first, samplers);
    }

    public static void nglBindImageTextures(int first, int count, long textures) {
        GL44C.nglBindImageTextures(first, count, textures);
    }

    public static void glBindImageTextures(@NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") IntBuffer textures) {
        GL44C.glBindImageTextures(first, textures);
    }

    public static void nglBindVertexBuffers(int first, int count, long buffers, long offsets, long strides) {
        GL44C.nglBindVertexBuffers(first, count, buffers, offsets, strides);
    }

    public static void glBindVertexBuffers(@NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") IntBuffer buffers, @Nullable @NativeType(value="GLintptr const *") PointerBuffer offsets, @Nullable @NativeType(value="GLsizei const *") IntBuffer strides) {
        GL44C.glBindVertexBuffers(first, buffers, offsets, strides);
    }

    public static void glBindBuffersBase(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") int[] buffers) {
        GL44C.glBindBuffersBase(target, first, buffers);
    }

    public static void glBindBuffersRange(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") int[] buffers, @Nullable @NativeType(value="GLintptr const *") PointerBuffer offsets, @Nullable @NativeType(value="GLsizeiptr const *") PointerBuffer sizes) {
        GL44C.glBindBuffersRange(target, first, buffers, offsets, sizes);
    }

    public static void glBindTextures(@NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") int[] textures) {
        GL44C.glBindTextures(first, textures);
    }

    public static void glBindSamplers(@NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") int[] samplers) {
        GL44C.glBindSamplers(first, samplers);
    }

    public static void glBindImageTextures(@NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") int[] textures) {
        GL44C.glBindImageTextures(first, textures);
    }

    public static void glBindVertexBuffers(@NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") int[] buffers, @Nullable @NativeType(value="GLintptr const *") PointerBuffer offsets, @Nullable @NativeType(value="GLsizei const *") int[] strides) {
        GL44C.glBindVertexBuffers(first, buffers, offsets, strides);
    }

    static {
        GL.initialize();
    }
}

