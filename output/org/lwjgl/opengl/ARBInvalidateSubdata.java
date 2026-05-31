/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBInvalidateSubdata {
    protected ARBInvalidateSubdata() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glInvalidateTexSubImage, caps.glInvalidateTexImage, caps.glInvalidateBufferSubData, caps.glInvalidateBufferData, caps.glInvalidateFramebuffer, caps.glInvalidateSubFramebuffer);
    }

    public static void glInvalidateTexSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth) {
        GL43C.glInvalidateTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth);
    }

    public static void glInvalidateTexImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level) {
        GL43C.glInvalidateTexImage(texture, level);
    }

    public static void glInvalidateBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long length) {
        GL43C.glInvalidateBufferSubData(buffer, offset, length);
    }

    public static void glInvalidateBufferData(@NativeType(value="GLuint") int buffer) {
        GL43C.glInvalidateBufferData(buffer);
    }

    public static void nglInvalidateFramebuffer(int target, int numAttachments, long attachments) {
        GL43C.nglInvalidateFramebuffer(target, numAttachments, attachments);
    }

    public static void glInvalidateFramebuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum const *") IntBuffer attachments) {
        GL43C.glInvalidateFramebuffer(target, attachments);
    }

    public static void glInvalidateFramebuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum const *") int attachment) {
        GL43C.glInvalidateFramebuffer(target, attachment);
    }

    public static void nglInvalidateSubFramebuffer(int target, int numAttachments, long attachments, int x, int y, int width, int height) {
        GL43C.nglInvalidateSubFramebuffer(target, numAttachments, attachments, x, y, width, height);
    }

    public static void glInvalidateSubFramebuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum const *") IntBuffer attachments, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height) {
        GL43C.glInvalidateSubFramebuffer(target, attachments, x, y, width, height);
    }

    public static void glInvalidateSubFramebuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum const *") int attachment, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height) {
        GL43C.glInvalidateSubFramebuffer(target, attachment, x, y, width, height);
    }

    public static void glInvalidateFramebuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum const *") int[] attachments) {
        GL43C.glInvalidateFramebuffer(target, attachments);
    }

    public static void glInvalidateSubFramebuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum const *") int[] attachments, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height) {
        GL43C.glInvalidateSubFramebuffer(target, attachments, x, y, width, height);
    }

    static {
        GL.initialize();
    }
}

