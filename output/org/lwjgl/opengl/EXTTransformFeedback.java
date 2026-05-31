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
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.EXTDrawBuffers2;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTTransformFeedback {
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_EXT = 35982;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_START_EXT = 35972;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_SIZE_EXT = 35973;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING_EXT = 35983;
    public static final int GL_INTERLEAVED_ATTRIBS_EXT = 35980;
    public static final int GL_SEPARATE_ATTRIBS_EXT = 35981;
    public static final int GL_PRIMITIVES_GENERATED_EXT = 35975;
    public static final int GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN_EXT = 35976;
    public static final int GL_RASTERIZER_DISCARD_EXT = 35977;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS_EXT = 35978;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS_EXT = 35979;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS_EXT = 35968;
    public static final int GL_TRANSFORM_FEEDBACK_VARYINGS_EXT = 35971;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_MODE_EXT = 35967;
    public static final int GL_TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH_EXT = 35958;

    protected EXTTransformFeedback() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glBindBufferRangeEXT, caps.glBindBufferOffsetEXT, caps.glBindBufferBaseEXT, caps.glBeginTransformFeedbackEXT, caps.glEndTransformFeedbackEXT, caps.glTransformFeedbackVaryingsEXT, caps.glGetTransformFeedbackVaryingEXT, caps.glGetIntegerIndexedvEXT, caps.glGetBooleanIndexedvEXT);
    }

    public static native void glBindBufferRangeEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLintptr") long var3, @NativeType(value="GLsizeiptr") long var5);

    public static native void glBindBufferOffsetEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLintptr") long var3);

    public static native void glBindBufferBaseEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    public static native void glBeginTransformFeedbackEXT(@NativeType(value="GLenum") int var0);

    public static native void glEndTransformFeedbackEXT();

    public static native void nglTransformFeedbackVaryingsEXT(int var0, int var1, long var2, int var4);

    public static void glTransformFeedbackVaryingsEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const * const *") PointerBuffer varyings, @NativeType(value="GLenum") int bufferMode) {
        EXTTransformFeedback.nglTransformFeedbackVaryingsEXT(program, varyings.remaining(), MemoryUtil.memAddress(varyings), bufferMode);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glTransformFeedbackVaryingsEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const * const *") CharSequence[] varyings, @NativeType(value="GLenum") int bufferMode) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            long varyingsAddress = APIUtil.apiArray(stack, MemoryUtil::memASCII, varyings);
            EXTTransformFeedback.nglTransformFeedbackVaryingsEXT(program, varyings.length, varyingsAddress, bufferMode);
            APIUtil.apiArrayFree(varyingsAddress, varyings.length);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glTransformFeedbackVaryingsEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const * const *") CharSequence varying, @NativeType(value="GLenum") int bufferMode) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            long varyingsAddress = APIUtil.apiArray(stack, MemoryUtil::memASCII, varying);
            EXTTransformFeedback.nglTransformFeedbackVaryingsEXT(program, 1, varyingsAddress, bufferMode);
            APIUtil.apiArrayFree(varyingsAddress, 1);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetTransformFeedbackVaryingEXT(int var0, int var1, int var2, long var3, long var5, long var7, long var9);

    public static void glGetTransformFeedbackVaryingEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLsizei *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type, @NativeType(value="GLchar *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, 1);
            Checks.check((Buffer)size, 1);
            Checks.check((Buffer)type, 1);
        }
        EXTTransformFeedback.nglGetTransformFeedbackVaryingEXT(program, index, name.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetTransformFeedbackVaryingEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @NativeType(value="GLsizei") int bufSize, @NativeType(value="GLsizei *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)size, 1);
            Checks.check((Buffer)type, 1);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer length = stack.ints(0);
            ByteBuffer name = stack.malloc(bufSize);
            EXTTransformFeedback.nglGetTransformFeedbackVaryingEXT(program, index, bufSize, MemoryUtil.memAddress(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
            String string = MemoryUtil.memASCII(name, length.get(0));
            return string;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="void")
    public static String glGetTransformFeedbackVaryingEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @NativeType(value="GLsizei *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type) {
        return EXTTransformFeedback.glGetTransformFeedbackVaryingEXT(program, index, GL.getCapabilities().OpenGL20 ? GL20.glGetProgrami(program, 35958) : ARBShaderObjects.glGetObjectParameteriARB(program, 35958), size, type);
    }

    public static void nglGetIntegerIndexedvEXT(int target, int index, long data) {
        EXTDrawBuffers2.nglGetIntegerIndexedvEXT(target, index, data);
    }

    public static void glGetIntegerIndexedvEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") IntBuffer data) {
        EXTDrawBuffers2.glGetIntegerIndexedvEXT(target, index, data);
    }

    @NativeType(value="void")
    public static int glGetIntegerIndexedEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        return EXTDrawBuffers2.glGetIntegerIndexedEXT(target, index);
    }

    public static void nglGetBooleanIndexedvEXT(int target, int index, long data) {
        EXTDrawBuffers2.nglGetBooleanIndexedvEXT(target, index, data);
    }

    public static void glGetBooleanIndexedvEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLboolean *") ByteBuffer data) {
        EXTDrawBuffers2.glGetBooleanIndexedvEXT(target, index, data);
    }

    @NativeType(value="void")
    public static boolean glGetBooleanIndexedEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        return EXTDrawBuffers2.glGetBooleanIndexedEXT(target, index);
    }

    public static void glGetTransformFeedbackVaryingEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLsizei *") int[] size, @NativeType(value="GLenum *") int[] type, @NativeType(value="GLchar *") ByteBuffer name) {
        long __functionAddress = GL.getICD().glGetTransformFeedbackVaryingEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, 1);
            Checks.check(size, 1);
            Checks.check(type, 1);
        }
        JNI.callPPPPV(program, index, name.remaining(), length, size, type, MemoryUtil.memAddress(name), __functionAddress);
    }

    public static void glGetIntegerIndexedvEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") int[] data) {
        EXTDrawBuffers2.glGetIntegerIndexedvEXT(target, index, data);
    }

    static {
        GL.initialize();
    }
}

