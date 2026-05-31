/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL45C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class KHRRobustness {
    public static final int GL_NO_ERROR = 0;
    public static final int GL_GUILTY_CONTEXT_RESET = 33363;
    public static final int GL_INNOCENT_CONTEXT_RESET = 33364;
    public static final int GL_UNKNOWN_CONTEXT_RESET = 33365;
    public static final int GL_CONTEXT_ROBUST_ACCESS = 37107;
    public static final int GL_RESET_NOTIFICATION_STRATEGY = 33366;
    public static final int GL_LOSE_CONTEXT_ON_RESET = 33362;
    public static final int GL_NO_RESET_NOTIFICATION = 33377;
    public static final int GL_CONTEXT_LOST = 1287;

    protected KHRRobustness() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glGetGraphicsResetStatus, caps.glReadnPixels, caps.glGetnUniformfv, caps.glGetnUniformiv, caps.glGetnUniformuiv);
    }

    @NativeType(value="GLenum")
    public static int glGetGraphicsResetStatus() {
        return GL45C.glGetGraphicsResetStatus();
    }

    public static void nglReadnPixels(int x, int y, int width, int height, int format, int type, int bufSize, long pixels) {
        GL45C.nglReadnPixels(x, y, width, height, format, type, bufSize, pixels);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long pixels) {
        GL45C.glReadnPixels(x, y, width, height, format, type, bufSize, pixels);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer pixels) {
        GL45C.glReadnPixels(x, y, width, height, format, type, pixels);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ShortBuffer pixels) {
        GL45C.glReadnPixels(x, y, width, height, format, type, pixels);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") IntBuffer pixels) {
        GL45C.glReadnPixels(x, y, width, height, format, type, pixels);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") FloatBuffer pixels) {
        GL45C.glReadnPixels(x, y, width, height, format, type, pixels);
    }

    public static void nglGetnUniformfv(int program, int location, int bufSize, long params) {
        GL45C.nglGetnUniformfv(program, location, bufSize, params);
    }

    public static void glGetnUniformfv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat *") FloatBuffer params) {
        GL45C.glGetnUniformfv(program, location, params);
    }

    @NativeType(value="void")
    public static float glGetnUniformf(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        return GL45C.glGetnUniformf(program, location);
    }

    public static void nglGetnUniformiv(int program, int location, int bufSize, long params) {
        GL45C.nglGetnUniformiv(program, location, bufSize, params);
    }

    public static void glGetnUniformiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint *") IntBuffer params) {
        GL45C.glGetnUniformiv(program, location, params);
    }

    @NativeType(value="void")
    public static int glGetnUniformi(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        return GL45C.glGetnUniformi(program, location);
    }

    public static void nglGetnUniformuiv(int program, int location, int bufSize, long params) {
        GL45C.nglGetnUniformuiv(program, location, bufSize, params);
    }

    public static void glGetnUniformuiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint *") IntBuffer params) {
        GL45C.glGetnUniformuiv(program, location, params);
    }

    @NativeType(value="void")
    public static int glGetnUniformui(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        return GL45C.glGetnUniformui(program, location);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") short[] pixels) {
        GL45C.glReadnPixels(x, y, width, height, format, type, pixels);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") int[] pixels) {
        GL45C.glReadnPixels(x, y, width, height, format, type, pixels);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") float[] pixels) {
        GL45C.glReadnPixels(x, y, width, height, format, type, pixels);
    }

    public static void glGetnUniformfv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat *") float[] params) {
        GL45C.glGetnUniformfv(program, location, params);
    }

    public static void glGetnUniformiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint *") int[] params) {
        GL45C.glGetnUniformiv(program, location, params);
    }

    public static void glGetnUniformuiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint *") int[] params) {
        GL45C.glGetnUniformuiv(program, location, params);
    }

    static {
        GL.initialize();
    }
}

