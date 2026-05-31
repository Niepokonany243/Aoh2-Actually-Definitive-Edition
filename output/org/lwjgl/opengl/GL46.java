/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL45;
import org.lwjgl.opengl.GL46C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class GL46
extends GL45 {
    public static final int GL_PARAMETER_BUFFER = 33006;
    public static final int GL_PARAMETER_BUFFER_BINDING = 33007;
    public static final int GL_VERTICES_SUBMITTED = 33518;
    public static final int GL_PRIMITIVES_SUBMITTED = 33519;
    public static final int GL_VERTEX_SHADER_INVOCATIONS = 33520;
    public static final int GL_TESS_CONTROL_SHADER_PATCHES = 33521;
    public static final int GL_TESS_EVALUATION_SHADER_INVOCATIONS = 33522;
    public static final int GL_GEOMETRY_SHADER_PRIMITIVES_EMITTED = 33523;
    public static final int GL_FRAGMENT_SHADER_INVOCATIONS = 33524;
    public static final int GL_COMPUTE_SHADER_INVOCATIONS = 33525;
    public static final int GL_CLIPPING_INPUT_PRIMITIVES = 33526;
    public static final int GL_CLIPPING_OUTPUT_PRIMITIVES = 33527;
    public static final int GL_POLYGON_OFFSET_CLAMP = 36379;
    public static final int GL_CONTEXT_FLAG_NO_ERROR_BIT = 8;
    public static final int GL_SHADER_BINARY_FORMAT_SPIR_V = 38225;
    public static final int GL_SPIR_V_BINARY = 38226;
    public static final int GL_SPIR_V_EXTENSIONS = 38227;
    public static final int GL_NUM_SPIR_V_EXTENSIONS = 38228;
    public static final int GL_TEXTURE_MAX_ANISOTROPY = 34046;
    public static final int GL_MAX_TEXTURE_MAX_ANISOTROPY = 34047;
    public static final int GL_TRANSFORM_FEEDBACK_OVERFLOW = 33516;
    public static final int GL_TRANSFORM_FEEDBACK_STREAM_OVERFLOW = 33517;

    protected GL46() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glMultiDrawArraysIndirectCount, caps.glMultiDrawElementsIndirectCount, caps.glPolygonOffsetClamp, caps.glSpecializeShader);
    }

    public static void nglMultiDrawArraysIndirectCount(int mode, long indirect, long drawcount, int maxdrawcount, int stride) {
        GL46C.nglMultiDrawArraysIndirectCount(mode, indirect, drawcount, maxdrawcount, stride);
    }

    public static void glMultiDrawArraysIndirectCount(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ByteBuffer indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        GL46C.glMultiDrawArraysIndirectCount(mode, indirect, drawcount, maxdrawcount, stride);
    }

    public static void glMultiDrawArraysIndirectCount(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") long indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        GL46C.glMultiDrawArraysIndirectCount(mode, indirect, drawcount, maxdrawcount, stride);
    }

    public static void glMultiDrawArraysIndirectCount(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") IntBuffer indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        GL46C.glMultiDrawArraysIndirectCount(mode, indirect, drawcount, maxdrawcount, stride);
    }

    public static void nglMultiDrawElementsIndirectCount(int mode, int type, long indirect, long drawcount, int maxdrawcount, int stride) {
        GL46C.nglMultiDrawElementsIndirectCount(mode, type, indirect, drawcount, maxdrawcount, stride);
    }

    public static void glMultiDrawElementsIndirectCount(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        GL46C.glMultiDrawElementsIndirectCount(mode, type, indirect, drawcount, maxdrawcount, stride);
    }

    public static void glMultiDrawElementsIndirectCount(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        GL46C.glMultiDrawElementsIndirectCount(mode, type, indirect, drawcount, maxdrawcount, stride);
    }

    public static void glMultiDrawElementsIndirectCount(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        GL46C.glMultiDrawElementsIndirectCount(mode, type, indirect, drawcount, maxdrawcount, stride);
    }

    public static void glPolygonOffsetClamp(@NativeType(value="GLfloat") float factor, @NativeType(value="GLfloat") float units, @NativeType(value="GLfloat") float clamp) {
        GL46C.glPolygonOffsetClamp(factor, units, clamp);
    }

    public static void nglSpecializeShader(int shader, long pEntryPoint, int numSpecializationConstants, long pConstantIndex, long pConstantValue) {
        GL46C.nglSpecializeShader(shader, pEntryPoint, numSpecializationConstants, pConstantIndex, pConstantValue);
    }

    public static void glSpecializeShader(@NativeType(value="GLuint") int shader, @NativeType(value="GLchar const *") ByteBuffer pEntryPoint, @NativeType(value="GLuint const *") IntBuffer pConstantIndex, @NativeType(value="GLuint const *") IntBuffer pConstantValue) {
        GL46C.glSpecializeShader(shader, pEntryPoint, pConstantIndex, pConstantValue);
    }

    public static void glSpecializeShader(@NativeType(value="GLuint") int shader, @NativeType(value="GLchar const *") CharSequence pEntryPoint, @NativeType(value="GLuint const *") IntBuffer pConstantIndex, @NativeType(value="GLuint const *") IntBuffer pConstantValue) {
        GL46C.glSpecializeShader(shader, pEntryPoint, pConstantIndex, pConstantValue);
    }

    public static void glMultiDrawArraysIndirectCount(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") int[] indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        GL46C.glMultiDrawArraysIndirectCount(mode, indirect, drawcount, maxdrawcount, stride);
    }

    public static void glMultiDrawElementsIndirectCount(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] indirect, @NativeType(value="GLintptr") long drawcount, @NativeType(value="GLsizei") int maxdrawcount, @NativeType(value="GLsizei") int stride) {
        GL46C.glMultiDrawElementsIndirectCount(mode, type, indirect, drawcount, maxdrawcount, stride);
    }

    public static void glSpecializeShader(@NativeType(value="GLuint") int shader, @NativeType(value="GLchar const *") ByteBuffer pEntryPoint, @NativeType(value="GLuint const *") int[] pConstantIndex, @NativeType(value="GLuint const *") int[] pConstantValue) {
        GL46C.glSpecializeShader(shader, pEntryPoint, pConstantIndex, pConstantValue);
    }

    public static void glSpecializeShader(@NativeType(value="GLuint") int shader, @NativeType(value="GLchar const *") CharSequence pEntryPoint, @NativeType(value="GLuint const *") int[] pConstantIndex, @NativeType(value="GLuint const *") int[] pConstantValue) {
        GL46C.glSpecializeShader(shader, pEntryPoint, pConstantIndex, pConstantValue);
    }

    static {
        GL.initialize();
    }
}

