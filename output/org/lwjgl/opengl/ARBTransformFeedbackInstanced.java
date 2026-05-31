/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL42C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBTransformFeedbackInstanced {
    protected ARBTransformFeedbackInstanced() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glDrawTransformFeedbackInstanced, caps.glDrawTransformFeedbackStreamInstanced);
    }

    public static void glDrawTransformFeedbackInstanced(@NativeType(value="GLenum") int mode, @NativeType(value="GLuint") int id, @NativeType(value="GLsizei") int primcount) {
        GL42C.glDrawTransformFeedbackInstanced(mode, id, primcount);
    }

    public static void glDrawTransformFeedbackStreamInstanced(@NativeType(value="GLenum") int mode, @NativeType(value="GLuint") int id, @NativeType(value="GLuint") int stream, @NativeType(value="GLsizei") int primcount) {
        GL42C.glDrawTransformFeedbackStreamInstanced(mode, id, stream, primcount);
    }

    static {
        GL.initialize();
    }
}

