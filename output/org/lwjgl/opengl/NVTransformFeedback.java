/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVTransformFeedback {
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_NV = 35982;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_START_NV = 35972;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_SIZE_NV = 35973;
    public static final int GL_TRANSFORM_FEEDBACK_RECORD_NV = 35974;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING_NV = 35983;
    public static final int GL_INTERLEAVED_ATTRIBS_NV = 35980;
    public static final int GL_SEPARATE_ATTRIBS_NV = 35981;
    public static final int GL_PRIMITIVES_GENERATED_NV = 35975;
    public static final int GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN_NV = 35976;
    public static final int GL_RASTERIZER_DISCARD_NV = 35977;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS_NV = 35978;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS_NV = 35979;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS_NV = 35968;
    public static final int GL_TRANSFORM_FEEDBACK_ATTRIBS_NV = 35966;
    public static final int GL_ACTIVE_VARYINGS_NV = 35969;
    public static final int GL_ACTIVE_VARYING_MAX_LENGTH_NV = 35970;
    public static final int GL_TRANSFORM_FEEDBACK_VARYINGS_NV = 35971;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_MODE_NV = 35967;
    public static final int GL_BACK_PRIMARY_COLOR_NV = 35959;
    public static final int GL_BACK_SECONDARY_COLOR_NV = 35960;
    public static final int GL_TEXTURE_COORD_NV = 35961;
    public static final int GL_CLIP_DISTANCE_NV = 35962;
    public static final int GL_VERTEX_ID_NV = 35963;
    public static final int GL_PRIMITIVE_ID_NV = 35964;
    public static final int GL_GENERIC_ATTRIB_NV = 35965;
    public static final int GL_SECONDARY_COLOR_NV = 34093;
    public static final int GL_LAYER_NV = 36266;

    protected NVTransformFeedback() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glBeginTransformFeedbackNV, caps.glEndTransformFeedbackNV, caps.glTransformFeedbackAttribsNV, caps.glBindBufferRangeNV, caps.glBindBufferOffsetNV, caps.glBindBufferBaseNV, caps.glTransformFeedbackVaryingsNV, caps.glActiveVaryingNV, caps.glGetVaryingLocationNV, caps.glGetActiveVaryingNV, caps.glGetTransformFeedbackVaryingNV, caps.glTransformFeedbackStreamAttribsNV);
    }

    public static native void glBeginTransformFeedbackNV(@NativeType(value="GLenum") int var0);

    public static native void glEndTransformFeedbackNV();

    public static native void nglTransformFeedbackAttribsNV(int var0, long var1, int var3);

    public static void glTransformFeedbackAttribsNV(@NativeType(value="GLint const *") IntBuffer attribs, @NativeType(value="GLenum") int bufferMode) {
        NVTransformFeedback.nglTransformFeedbackAttribsNV(attribs.remaining(), MemoryUtil.memAddress(attribs), bufferMode);
    }

    public static native void glBindBufferRangeNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLintptr") long var3, @NativeType(value="GLsizeiptr") long var5);

    public static native void glBindBufferOffsetNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLintptr") long var3);

    public static native void glBindBufferBaseNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    public static native void nglTransformFeedbackVaryingsNV(int var0, int var1, long var2, int var4);

    public static void glTransformFeedbackVaryingsNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint const *") IntBuffer locations, @NativeType(value="GLenum") int bufferMode) {
        NVTransformFeedback.nglTransformFeedbackVaryingsNV(program, locations.remaining(), MemoryUtil.memAddress(locations), bufferMode);
    }

    public static native void nglActiveVaryingNV(int var0, long var1);

    public static void glActiveVaryingNV(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        NVTransformFeedback.nglActiveVaryingNV(program, MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glActiveVaryingNV(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(name, true);
            long nameEncoded = stack.getPointerAddress();
            NVTransformFeedback.nglActiveVaryingNV(program, nameEncoded);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native int nglGetVaryingLocationNV(int var0, long var1);

    @NativeType(value="GLint")
    public static int glGetVaryingLocationNV(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return NVTransformFeedback.nglGetVaryingLocationNV(program, MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLint")
    public static int glGetVaryingLocationNV(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(name, true);
            long nameEncoded = stack.getPointerAddress();
            int n = NVTransformFeedback.nglGetVaryingLocationNV(program, nameEncoded);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetActiveVaryingNV(int var0, int var1, int var2, long var3, long var5, long var7, long var9);

    public static void glGetActiveVaryingNV(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLsizei *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type, @NativeType(value="GLchar *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, 1);
            Checks.check((Buffer)size, 1);
            Checks.check((Buffer)type, 1);
        }
        NVTransformFeedback.nglGetActiveVaryingNV(program, index, name.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
    }

    public static native void nglGetTransformFeedbackVaryingNV(int var0, int var1, long var2);

    public static void glGetTransformFeedbackVaryingNV(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") IntBuffer location) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)location, 1);
        }
        NVTransformFeedback.nglGetTransformFeedbackVaryingNV(program, index, MemoryUtil.memAddress(location));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTransformFeedbackVaryingNV(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer location = stack.callocInt(1);
            NVTransformFeedback.nglGetTransformFeedbackVaryingNV(program, index, MemoryUtil.memAddress(location));
            int n = location.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglTransformFeedbackStreamAttribsNV(int var0, long var1, int var3, long var4, int var6);

    public static void glTransformFeedbackStreamAttribsNV(@NativeType(value="GLint const *") IntBuffer attribs, @NativeType(value="GLint const *") IntBuffer bufstreams, @NativeType(value="GLenum") int bufferMode) {
        NVTransformFeedback.nglTransformFeedbackStreamAttribsNV(attribs.remaining(), MemoryUtil.memAddress(attribs), bufstreams.remaining(), MemoryUtil.memAddress(bufstreams), bufferMode);
    }

    public static void glTransformFeedbackAttribsNV(@NativeType(value="GLint const *") int[] attribs, @NativeType(value="GLenum") int bufferMode) {
        long __functionAddress = GL.getICD().glTransformFeedbackAttribsNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(attribs.length, attribs, bufferMode, __functionAddress);
    }

    public static void glTransformFeedbackVaryingsNV(@NativeType(value="GLuint") int program, @NativeType(value="GLint const *") int[] locations, @NativeType(value="GLenum") int bufferMode) {
        long __functionAddress = GL.getICD().glTransformFeedbackVaryingsNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, locations.length, locations, bufferMode, __functionAddress);
    }

    public static void glGetActiveVaryingNV(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLsizei *") int[] size, @NativeType(value="GLenum *") int[] type, @NativeType(value="GLchar *") ByteBuffer name) {
        long __functionAddress = GL.getICD().glGetActiveVaryingNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, 1);
            Checks.check(size, 1);
            Checks.check(type, 1);
        }
        JNI.callPPPPV(program, index, name.remaining(), length, size, type, MemoryUtil.memAddress(name), __functionAddress);
    }

    public static void glGetTransformFeedbackVaryingNV(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") int[] location) {
        long __functionAddress = GL.getICD().glGetTransformFeedbackVaryingNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(location, 1);
        }
        JNI.callPV(program, index, location, __functionAddress);
    }

    public static void glTransformFeedbackStreamAttribsNV(@NativeType(value="GLint const *") int[] attribs, @NativeType(value="GLint const *") int[] bufstreams, @NativeType(value="GLenum") int bufferMode) {
        long __functionAddress = GL.getICD().glTransformFeedbackStreamAttribsNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(attribs.length, attribs, bufstreams.length, bufstreams, bufferMode, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

