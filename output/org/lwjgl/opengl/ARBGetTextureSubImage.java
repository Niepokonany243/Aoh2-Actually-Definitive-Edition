/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL45C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBGetTextureSubImage {
    protected ARBGetTextureSubImage() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glGetTextureSubImage, caps.glGetCompressedTextureSubImage);
    }

    public static void nglGetTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, int bufSize, long pixels) {
        GL45C.nglGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, bufSize, pixels);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long pixels) {
        GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, bufSize, pixels);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer pixels) {
        GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ShortBuffer pixels) {
        GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") IntBuffer pixels) {
        GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") FloatBuffer pixels) {
        GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") DoubleBuffer pixels) {
        GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void nglGetCompressedTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int bufSize, long pixels) {
        GL45C.nglGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, bufSize, pixels);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long pixels) {
        GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, bufSize, pixels);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") ByteBuffer pixels) {
        GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") ShortBuffer pixels) {
        GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") IntBuffer pixels) {
        GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") FloatBuffer pixels) {
        GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") DoubleBuffer pixels) {
        GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") short[] pixels) {
        GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") int[] pixels) {
        GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") float[] pixels) {
        GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") double[] pixels) {
        GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") short[] pixels) {
        GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") int[] pixels) {
        GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") float[] pixels) {
        GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") double[] pixels) {
        GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
    }

    static {
        GL.initialize();
    }
}

