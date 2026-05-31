/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.LongBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL33C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBTimerQuery {
    public static final int GL_TIME_ELAPSED = 35007;
    public static final int GL_TIMESTAMP = 36392;

    protected ARBTimerQuery() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glQueryCounter, caps.glGetQueryObjecti64v, caps.glGetQueryObjectui64v);
    }

    public static void glQueryCounter(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int target) {
        GL33C.glQueryCounter(id, target);
    }

    public static void nglGetQueryObjecti64v(int id, int pname, long params) {
        GL33C.nglGetQueryObjecti64v(id, pname, params);
    }

    public static void glGetQueryObjecti64v(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") LongBuffer params) {
        GL33C.glGetQueryObjecti64v(id, pname, params);
    }

    @NativeType(value="void")
    public static long glGetQueryObjecti64(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname) {
        return GL33C.glGetQueryObjecti64(id, pname);
    }

    public static void nglGetQueryObjectui64v(int id, int pname, long params) {
        GL33C.nglGetQueryObjectui64v(id, pname, params);
    }

    public static void glGetQueryObjectui64v(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint64 *") LongBuffer params) {
        GL33C.glGetQueryObjectui64v(id, pname, params);
    }

    @NativeType(value="void")
    public static long glGetQueryObjectui64(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname) {
        return GL33C.glGetQueryObjectui64(id, pname);
    }

    public static void glGetQueryObjecti64v(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") long[] params) {
        GL33C.glGetQueryObjecti64v(id, pname, params);
    }

    public static void glGetQueryObjectui64v(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint64 *") long[] params) {
        GL33C.glGetQueryObjectui64v(id, pname, params);
    }

    static {
        GL.initialize();
    }
}

