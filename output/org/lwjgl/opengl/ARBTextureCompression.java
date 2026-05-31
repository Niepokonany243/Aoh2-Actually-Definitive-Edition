/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBTextureCompression {
    public static final int GL_COMPRESSED_ALPHA_ARB = 34025;
    public static final int GL_COMPRESSED_LUMINANCE_ARB = 34026;
    public static final int GL_COMPRESSED_LUMINANCE_ALPHA_ARB = 34027;
    public static final int GL_COMPRESSED_INTENSITY_ARB = 34028;
    public static final int GL_COMPRESSED_RGB_ARB = 34029;
    public static final int GL_COMPRESSED_RGBA_ARB = 34030;
    public static final int GL_TEXTURE_COMPRESSION_HINT_ARB = 34031;
    public static final int GL_TEXTURE_COMPRESSED_IMAGE_SIZE_ARB = 34464;
    public static final int GL_TEXTURE_COMPRESSED_ARB = 34465;
    public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS_ARB = 34466;
    public static final int GL_COMPRESSED_TEXTURE_FORMATS_ARB = 34467;

    protected ARBTextureCompression() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glCompressedTexImage3DARB, caps.glCompressedTexImage2DARB, caps.glCompressedTexImage1DARB, caps.glCompressedTexSubImage3DARB, caps.glCompressedTexSubImage2DARB, caps.glCompressedTexSubImage1DARB, caps.glGetCompressedTexImageARB);
    }

    public static native void nglCompressedTexImage3DARB(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, long var8);

    public static void glCompressedTexImage3DARB(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLsizei") int imageSize, @NativeType(value="void const *") long data) {
        ARBTextureCompression.nglCompressedTexImage3DARB(target, level, internalformat, width, height, depth, border, imageSize, data);
    }

    public static void glCompressedTexImage3DARB(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void const *") ByteBuffer data) {
        ARBTextureCompression.nglCompressedTexImage3DARB(target, level, internalformat, width, height, depth, 0, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static native void nglCompressedTexImage2DARB(int var0, int var1, int var2, int var3, int var4, int var5, int var6, long var7);

    public static void glCompressedTexImage2DARB(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLsizei") int imageSize, @NativeType(value="void const *") long data) {
        ARBTextureCompression.nglCompressedTexImage2DARB(target, level, internalformat, width, height, border, imageSize, data);
    }

    public static void glCompressedTexImage2DARB(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="void const *") ByteBuffer data) {
        ARBTextureCompression.nglCompressedTexImage2DARB(target, level, internalformat, width, height, 0, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static native void nglCompressedTexImage1DARB(int var0, int var1, int var2, int var3, int var4, int var5, long var6);

    public static void glCompressedTexImage1DARB(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLsizei") int imageSize, @NativeType(value="void const *") long data) {
        ARBTextureCompression.nglCompressedTexImage1DARB(target, level, internalformat, width, border, imageSize, data);
    }

    public static void glCompressedTexImage1DARB(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="void const *") ByteBuffer data) {
        ARBTextureCompression.nglCompressedTexImage1DARB(target, level, internalformat, width, 0, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static native void nglCompressedTexSubImage3DARB(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, long var10);

    public static void glCompressedTexSubImage3DARB(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int imageSize, @NativeType(value="void const *") long data) {
        ARBTextureCompression.nglCompressedTexSubImage3DARB(target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
    }

    public static void glCompressedTexSubImage3DARB(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="void const *") ByteBuffer data) {
        ARBTextureCompression.nglCompressedTexSubImage3DARB(target, level, xoffset, yoffset, zoffset, width, height, depth, format, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static native void nglCompressedTexSubImage2DARB(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, long var8);

    public static void glCompressedTexSubImage2DARB(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int imageSize, @NativeType(value="void const *") long data) {
        ARBTextureCompression.nglCompressedTexSubImage2DARB(target, level, xoffset, yoffset, width, height, format, imageSize, data);
    }

    public static void glCompressedTexSubImage2DARB(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="void const *") ByteBuffer data) {
        ARBTextureCompression.nglCompressedTexSubImage2DARB(target, level, xoffset, yoffset, width, height, format, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static native void nglCompressedTexSubImage1DARB(int var0, int var1, int var2, int var3, int var4, int var5, long var6);

    public static void glCompressedTexSubImage1DARB(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int imageSize, @NativeType(value="void const *") long data) {
        ARBTextureCompression.nglCompressedTexSubImage1DARB(target, level, xoffset, width, format, imageSize, data);
    }

    public static void glCompressedTexSubImage1DARB(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="void const *") ByteBuffer data) {
        ARBTextureCompression.nglCompressedTexSubImage1DARB(target, level, xoffset, width, format, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static native void nglGetCompressedTexImageARB(int var0, int var1, long var2);

    public static void glGetCompressedTexImageARB(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="void *") ByteBuffer pixels) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)pixels, GL11.glGetTexLevelParameteri(target, level, 34464));
        }
        ARBTextureCompression.nglGetCompressedTexImageARB(target, level, MemoryUtil.memAddress(pixels));
    }

    public static void glGetCompressedTexImageARB(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="void *") long pixels) {
        ARBTextureCompression.nglGetCompressedTexImageARB(target, level, pixels);
    }

    static {
        GL.initialize();
    }
}

