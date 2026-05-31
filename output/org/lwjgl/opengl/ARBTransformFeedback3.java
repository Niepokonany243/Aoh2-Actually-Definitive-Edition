/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL40C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBTransformFeedback3 {
    public static final int GL_MAX_TRANSFORM_FEEDBACK_BUFFERS = 36464;
    public static final int GL_MAX_VERTEX_STREAMS = 36465;

    protected ARBTransformFeedback3() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glDrawTransformFeedbackStream, caps.glBeginQueryIndexed, caps.glEndQueryIndexed, caps.glGetQueryIndexediv);
    }

    public static void glDrawTransformFeedbackStream(@NativeType(value="GLenum") int mode, @NativeType(value="GLuint") int id, @NativeType(value="GLuint") int stream) {
        GL40C.glDrawTransformFeedbackStream(mode, id, stream);
    }

    public static void glBeginQueryIndexed(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLuint") int id) {
        GL40C.glBeginQueryIndexed(target, index, id);
    }

    public static void glEndQueryIndexed(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        GL40C.glEndQueryIndexed(target, index);
    }

    public static void nglGetQueryIndexediv(int target, int index, int pname, long params) {
        GL40C.nglGetQueryIndexediv(target, index, pname, params);
    }

    public static void glGetQueryIndexediv(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL40C.glGetQueryIndexediv(target, index, pname, params);
    }

    @NativeType(value="void")
    public static int glGetQueryIndexedi(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        return GL40C.glGetQueryIndexedi(target, index, pname);
    }

    public static void glGetQueryIndexediv(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL40C.glGetQueryIndexediv(target, index, pname, params);
    }

    static {
        GL.initialize();
    }
}

