/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVTransformFeedback2 {
    public static final int GL_TRANSFORM_FEEDBACK_NV = 36386;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED_NV = 36387;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE_NV = 36388;
    public static final int GL_TRANSFORM_FEEDBACK_BINDING_NV = 36389;

    protected NVTransformFeedback2() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glBindTransformFeedbackNV, caps.glDeleteTransformFeedbacksNV, caps.glGenTransformFeedbacksNV, caps.glIsTransformFeedbackNV, caps.glPauseTransformFeedbackNV, caps.glResumeTransformFeedbackNV, caps.glDrawTransformFeedbackNV);
    }

    public static native void glBindTransformFeedbackNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglDeleteTransformFeedbacksNV(int var0, long var1);

    public static void glDeleteTransformFeedbacksNV(@NativeType(value="GLuint const *") IntBuffer ids) {
        NVTransformFeedback2.nglDeleteTransformFeedbacksNV(ids.remaining(), MemoryUtil.memAddress(ids));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDeleteTransformFeedbacksNV(@NativeType(value="GLuint const *") int id) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer ids = stack.ints(id);
            NVTransformFeedback2.nglDeleteTransformFeedbacksNV(1, MemoryUtil.memAddress(ids));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGenTransformFeedbacksNV(int var0, long var1);

    public static void glGenTransformFeedbacksNV(@NativeType(value="GLuint *") IntBuffer ids) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)ids, 1);
        }
        NVTransformFeedback2.nglGenTransformFeedbacksNV(ids.remaining(), MemoryUtil.memAddress(ids));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGenTransformFeedbacksNV() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer ids = stack.callocInt(1);
            NVTransformFeedback2.nglGenTransformFeedbacksNV(1, MemoryUtil.memAddress(ids));
            int n = ids.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="GLboolean")
    public static native boolean glIsTransformFeedbackNV(@NativeType(value="GLuint") int var0);

    public static native void glPauseTransformFeedbackNV();

    public static native void glResumeTransformFeedbackNV();

    public static native void glDrawTransformFeedbackNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static void glDeleteTransformFeedbacksNV(@NativeType(value="GLuint const *") int[] ids) {
        long __functionAddress = GL.getICD().glDeleteTransformFeedbacksNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(ids.length, ids, __functionAddress);
    }

    public static void glGenTransformFeedbacksNV(@NativeType(value="GLuint *") int[] ids) {
        long __functionAddress = GL.getICD().glGenTransformFeedbacksNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(ids, 1);
        }
        JNI.callPV(ids.length, ids, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

