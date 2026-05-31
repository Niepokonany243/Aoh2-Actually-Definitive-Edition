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

public class ARBTransformFeedback2 {
    public static final int GL_TRANSFORM_FEEDBACK = 36386;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED = 36387;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE = 36388;
    public static final int GL_TRANSFORM_FEEDBACK_BINDING = 36389;

    protected ARBTransformFeedback2() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glBindTransformFeedback, caps.glDeleteTransformFeedbacks, caps.glGenTransformFeedbacks, caps.glIsTransformFeedback, caps.glPauseTransformFeedback, caps.glResumeTransformFeedback, caps.glDrawTransformFeedback);
    }

    public static void glBindTransformFeedback(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int id) {
        GL40C.glBindTransformFeedback(target, id);
    }

    public static void nglDeleteTransformFeedbacks(int n, long ids) {
        GL40C.nglDeleteTransformFeedbacks(n, ids);
    }

    public static void glDeleteTransformFeedbacks(@NativeType(value="GLuint const *") IntBuffer ids) {
        GL40C.glDeleteTransformFeedbacks(ids);
    }

    public static void glDeleteTransformFeedbacks(@NativeType(value="GLuint const *") int id) {
        GL40C.glDeleteTransformFeedbacks(id);
    }

    public static void nglGenTransformFeedbacks(int n, long ids) {
        GL40C.nglGenTransformFeedbacks(n, ids);
    }

    public static void glGenTransformFeedbacks(@NativeType(value="GLuint *") IntBuffer ids) {
        GL40C.glGenTransformFeedbacks(ids);
    }

    @NativeType(value="void")
    public static int glGenTransformFeedbacks() {
        return GL40C.glGenTransformFeedbacks();
    }

    @NativeType(value="GLboolean")
    public static boolean glIsTransformFeedback(@NativeType(value="GLuint") int id) {
        return GL40C.glIsTransformFeedback(id);
    }

    public static void glPauseTransformFeedback() {
        GL40C.glPauseTransformFeedback();
    }

    public static void glResumeTransformFeedback() {
        GL40C.glResumeTransformFeedback();
    }

    public static void glDrawTransformFeedback(@NativeType(value="GLenum") int mode, @NativeType(value="GLuint") int id) {
        GL40C.glDrawTransformFeedback(mode, id);
    }

    public static void glDeleteTransformFeedbacks(@NativeType(value="GLuint const *") int[] ids) {
        GL40C.glDeleteTransformFeedbacks(ids);
    }

    public static void glGenTransformFeedbacks(@NativeType(value="GLuint *") int[] ids) {
        GL40C.glGenTransformFeedbacks(ids);
    }

    static {
        GL.initialize();
    }
}

