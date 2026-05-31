/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Set;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL44;
import org.lwjgl.opengl.GL45C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL45
extends GL44 {
    public static final int GL_NEGATIVE_ONE_TO_ONE = 37726;
    public static final int GL_ZERO_TO_ONE = 37727;
    public static final int GL_CLIP_ORIGIN = 37724;
    public static final int GL_CLIP_DEPTH_MODE = 37725;
    public static final int GL_QUERY_WAIT_INVERTED = 36375;
    public static final int GL_QUERY_NO_WAIT_INVERTED = 36376;
    public static final int GL_QUERY_BY_REGION_WAIT_INVERTED = 36377;
    public static final int GL_QUERY_BY_REGION_NO_WAIT_INVERTED = 36378;
    public static final int GL_MAX_CULL_DISTANCES = 33529;
    public static final int GL_MAX_COMBINED_CLIP_AND_CULL_DISTANCES = 33530;
    public static final int GL_TEXTURE_TARGET = 4102;
    public static final int GL_QUERY_TARGET = 33514;
    public static final int GL_CONTEXT_RELEASE_BEHAVIOR = 33531;
    public static final int GL_CONTEXT_RELEASE_BEHAVIOR_FLUSH = 33532;
    public static final int GL_GUILTY_CONTEXT_RESET = 33363;
    public static final int GL_INNOCENT_CONTEXT_RESET = 33364;
    public static final int GL_UNKNOWN_CONTEXT_RESET = 33365;
    public static final int GL_RESET_NOTIFICATION_STRATEGY = 33366;
    public static final int GL_LOSE_CONTEXT_ON_RESET = 33362;
    public static final int GL_NO_RESET_NOTIFICATION = 33377;
    public static final int GL_CONTEXT_FLAG_ROBUST_ACCESS_BIT = 4;
    public static final int GL_CONTEXT_LOST = 1287;

    protected GL45() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, Set<String> ext) {
        return Checks.checkFunctions(caps.glClipControl, caps.glCreateTransformFeedbacks, caps.glTransformFeedbackBufferBase, caps.glTransformFeedbackBufferRange, caps.glGetTransformFeedbackiv, caps.glGetTransformFeedbacki_v, caps.glGetTransformFeedbacki64_v, caps.glCreateBuffers, caps.glNamedBufferStorage, caps.glNamedBufferData, caps.glNamedBufferSubData, caps.glCopyNamedBufferSubData, caps.glClearNamedBufferData, caps.glClearNamedBufferSubData, caps.glMapNamedBuffer, caps.glMapNamedBufferRange, caps.glUnmapNamedBuffer, caps.glFlushMappedNamedBufferRange, caps.glGetNamedBufferParameteriv, caps.glGetNamedBufferParameteri64v, caps.glGetNamedBufferPointerv, caps.glGetNamedBufferSubData, caps.glCreateFramebuffers, caps.glNamedFramebufferRenderbuffer, caps.glNamedFramebufferParameteri, caps.glNamedFramebufferTexture, caps.glNamedFramebufferTextureLayer, caps.glNamedFramebufferDrawBuffer, caps.glNamedFramebufferDrawBuffers, caps.glNamedFramebufferReadBuffer, caps.glInvalidateNamedFramebufferData, caps.glInvalidateNamedFramebufferSubData, caps.glClearNamedFramebufferiv, caps.glClearNamedFramebufferuiv, caps.glClearNamedFramebufferfv, caps.glClearNamedFramebufferfi, caps.glBlitNamedFramebuffer, caps.glCheckNamedFramebufferStatus, caps.glGetNamedFramebufferParameteriv, caps.glGetNamedFramebufferAttachmentParameteriv, caps.glCreateRenderbuffers, caps.glNamedRenderbufferStorage, caps.glNamedRenderbufferStorageMultisample, caps.glGetNamedRenderbufferParameteriv, caps.glCreateTextures, caps.glTextureBuffer, caps.glTextureBufferRange, caps.glTextureStorage1D, caps.glTextureStorage2D, caps.glTextureStorage3D, caps.glTextureStorage2DMultisample, caps.glTextureStorage3DMultisample, caps.glTextureSubImage1D, caps.glTextureSubImage2D, caps.glTextureSubImage3D, caps.glCompressedTextureSubImage1D, caps.glCompressedTextureSubImage2D, caps.glCompressedTextureSubImage3D, caps.glCopyTextureSubImage1D, caps.glCopyTextureSubImage2D, caps.glCopyTextureSubImage3D, caps.glTextureParameterf, caps.glTextureParameterfv, caps.glTextureParameteri, caps.glTextureParameterIiv, caps.glTextureParameterIuiv, caps.glTextureParameteriv, caps.glGenerateTextureMipmap, caps.glBindTextureUnit, caps.glGetTextureImage, caps.glGetCompressedTextureImage, caps.glGetTextureLevelParameterfv, caps.glGetTextureLevelParameteriv, caps.glGetTextureParameterfv, caps.glGetTextureParameterIiv, caps.glGetTextureParameterIuiv, caps.glGetTextureParameteriv, caps.glCreateVertexArrays, caps.glDisableVertexArrayAttrib, caps.glEnableVertexArrayAttrib, caps.glVertexArrayElementBuffer, caps.glVertexArrayVertexBuffer, caps.glVertexArrayVertexBuffers, caps.glVertexArrayAttribFormat, caps.glVertexArrayAttribIFormat, caps.glVertexArrayAttribLFormat, caps.glVertexArrayAttribBinding, caps.glVertexArrayBindingDivisor, caps.glGetVertexArrayiv, caps.glGetVertexArrayIndexediv, caps.glGetVertexArrayIndexed64iv, caps.glCreateSamplers, caps.glCreateProgramPipelines, caps.glCreateQueries, caps.glGetQueryBufferObjectiv, caps.glGetQueryBufferObjectuiv, caps.glGetQueryBufferObjecti64v, caps.glGetQueryBufferObjectui64v, caps.glMemoryBarrierByRegion, caps.glGetTextureSubImage, caps.glGetCompressedTextureSubImage, caps.glTextureBarrier, caps.glGetGraphicsResetStatus, caps.glReadnPixels, caps.glGetnUniformfv, caps.glGetnUniformiv, caps.glGetnUniformuiv);
    }

    public static void glClipControl(@NativeType(value="GLenum") int origin, @NativeType(value="GLenum") int depth) {
        GL45C.glClipControl(origin, depth);
    }

    public static void nglCreateTransformFeedbacks(int n, long ids) {
        GL45C.nglCreateTransformFeedbacks(n, ids);
    }

    public static void glCreateTransformFeedbacks(@NativeType(value="GLuint *") IntBuffer ids) {
        GL45C.glCreateTransformFeedbacks(ids);
    }

    @NativeType(value="void")
    public static int glCreateTransformFeedbacks() {
        return GL45C.glCreateTransformFeedbacks();
    }

    public static void glTransformFeedbackBufferBase(@NativeType(value="GLuint") int xfb, @NativeType(value="GLuint") int index, @NativeType(value="GLuint") int buffer) {
        GL45C.glTransformFeedbackBufferBase(xfb, index, buffer);
    }

    public static void glTransformFeedbackBufferRange(@NativeType(value="GLuint") int xfb, @NativeType(value="GLuint") int index, @NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size) {
        GL45C.glTransformFeedbackBufferRange(xfb, index, buffer, offset, size);
    }

    public static void nglGetTransformFeedbackiv(int xfb, int pname, long param) {
        GL45C.nglGetTransformFeedbackiv(xfb, pname, param);
    }

    public static void glGetTransformFeedbackiv(@NativeType(value="GLuint") int xfb, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer param) {
        GL45C.glGetTransformFeedbackiv(xfb, pname, param);
    }

    @NativeType(value="void")
    public static int glGetTransformFeedbacki(@NativeType(value="GLuint") int xfb, @NativeType(value="GLenum") int pname) {
        return GL45C.glGetTransformFeedbacki(xfb, pname);
    }

    public static void nglGetTransformFeedbacki_v(int xfb, int pname, int index, long param) {
        GL45C.nglGetTransformFeedbacki_v(xfb, pname, index, param);
    }

    public static void glGetTransformFeedbacki_v(@NativeType(value="GLuint") int xfb, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") IntBuffer param) {
        GL45C.glGetTransformFeedbacki_v(xfb, pname, index, param);
    }

    @NativeType(value="void")
    public static int glGetTransformFeedbacki(@NativeType(value="GLuint") int xfb, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index) {
        return GL45C.glGetTransformFeedbacki(xfb, pname, index);
    }

    public static void nglGetTransformFeedbacki64_v(int xfb, int pname, int index, long param) {
        GL45C.nglGetTransformFeedbacki64_v(xfb, pname, index, param);
    }

    public static void glGetTransformFeedbacki64_v(@NativeType(value="GLuint") int xfb, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index, @NativeType(value="GLint64 *") LongBuffer param) {
        GL45C.glGetTransformFeedbacki64_v(xfb, pname, index, param);
    }

    @NativeType(value="void")
    public static long glGetTransformFeedbacki64(@NativeType(value="GLuint") int xfb, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index) {
        return GL45C.glGetTransformFeedbacki64(xfb, pname, index);
    }

    public static void nglCreateBuffers(int n, long buffers) {
        GL45C.nglCreateBuffers(n, buffers);
    }

    public static void glCreateBuffers(@NativeType(value="GLuint *") IntBuffer buffers) {
        GL45C.glCreateBuffers(buffers);
    }

    @NativeType(value="void")
    public static int glCreateBuffers() {
        return GL45C.glCreateBuffers();
    }

    public static void nglNamedBufferStorage(int buffer, long size, long data, int flags) {
        GL45C.nglNamedBufferStorage(buffer, size, data, flags);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int buffer, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLbitfield") int flags) {
        GL45C.glNamedBufferStorage(buffer, size, flags);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") ByteBuffer data, @NativeType(value="GLbitfield") int flags) {
        GL45C.glNamedBufferStorage(buffer, data, flags);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") ShortBuffer data, @NativeType(value="GLbitfield") int flags) {
        GL45C.glNamedBufferStorage(buffer, data, flags);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") IntBuffer data, @NativeType(value="GLbitfield") int flags) {
        GL45C.glNamedBufferStorage(buffer, data, flags);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") FloatBuffer data, @NativeType(value="GLbitfield") int flags) {
        GL45C.glNamedBufferStorage(buffer, data, flags);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") DoubleBuffer data, @NativeType(value="GLbitfield") int flags) {
        GL45C.glNamedBufferStorage(buffer, data, flags);
    }

    public static void nglNamedBufferData(int buffer, long size, long data, int usage) {
        GL45C.nglNamedBufferData(buffer, size, data, usage);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int usage) {
        GL45C.glNamedBufferData(buffer, size, usage);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") ByteBuffer data, @NativeType(value="GLenum") int usage) {
        GL45C.glNamedBufferData(buffer, data, usage);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") ShortBuffer data, @NativeType(value="GLenum") int usage) {
        GL45C.glNamedBufferData(buffer, data, usage);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") IntBuffer data, @NativeType(value="GLenum") int usage) {
        GL45C.glNamedBufferData(buffer, data, usage);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") LongBuffer data, @NativeType(value="GLenum") int usage) {
        GL45C.glNamedBufferData(buffer, data, usage);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") FloatBuffer data, @NativeType(value="GLenum") int usage) {
        GL45C.glNamedBufferData(buffer, data, usage);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") DoubleBuffer data, @NativeType(value="GLenum") int usage) {
        GL45C.glNamedBufferData(buffer, data, usage);
    }

    public static void nglNamedBufferSubData(int buffer, long offset, long size, long data) {
        GL45C.nglNamedBufferSubData(buffer, offset, size, data);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") ByteBuffer data) {
        GL45C.glNamedBufferSubData(buffer, offset, data);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") ShortBuffer data) {
        GL45C.glNamedBufferSubData(buffer, offset, data);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") IntBuffer data) {
        GL45C.glNamedBufferSubData(buffer, offset, data);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") LongBuffer data) {
        GL45C.glNamedBufferSubData(buffer, offset, data);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") FloatBuffer data) {
        GL45C.glNamedBufferSubData(buffer, offset, data);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") DoubleBuffer data) {
        GL45C.glNamedBufferSubData(buffer, offset, data);
    }

    public static void glCopyNamedBufferSubData(@NativeType(value="GLuint") int readBuffer, @NativeType(value="GLuint") int writeBuffer, @NativeType(value="GLintptr") long readOffset, @NativeType(value="GLintptr") long writeOffset, @NativeType(value="GLsizeiptr") long size) {
        GL45C.glCopyNamedBufferSubData(readBuffer, writeBuffer, readOffset, writeOffset, size);
    }

    public static void nglClearNamedBufferData(int buffer, int internalformat, int format, int type, long data) {
        GL45C.nglClearNamedBufferData(buffer, internalformat, format, type, data);
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ByteBuffer data) {
        GL45C.glClearNamedBufferData(buffer, internalformat, format, type, data);
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ShortBuffer data) {
        GL45C.glClearNamedBufferData(buffer, internalformat, format, type, data);
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") IntBuffer data) {
        GL45C.glClearNamedBufferData(buffer, internalformat, format, type, data);
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") FloatBuffer data) {
        GL45C.glClearNamedBufferData(buffer, internalformat, format, type, data);
    }

    public static void nglClearNamedBufferSubData(int buffer, int internalformat, long offset, long size, int format, int type, long data) {
        GL45C.nglClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ByteBuffer data) {
        GL45C.glClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ShortBuffer data) {
        GL45C.glClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") IntBuffer data) {
        GL45C.glClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") FloatBuffer data) {
        GL45C.glClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
    }

    public static long nglMapNamedBuffer(int buffer, int access) {
        return GL45C.nglMapNamedBuffer(buffer, access);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBuffer(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int access) {
        return GL45C.glMapNamedBuffer(buffer, access);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBuffer(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int access, @Nullable ByteBuffer old_buffer) {
        return GL45C.glMapNamedBuffer(buffer, access, old_buffer);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBuffer(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int access, long length, @Nullable ByteBuffer old_buffer) {
        return GL45C.glMapNamedBuffer(buffer, access, length, old_buffer);
    }

    public static long nglMapNamedBufferRange(int buffer, long offset, long length, int access) {
        return GL45C.nglMapNamedBufferRange(buffer, offset, length, access);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBufferRange(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long length, @NativeType(value="GLbitfield") int access) {
        return GL45C.glMapNamedBufferRange(buffer, offset, length, access);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBufferRange(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long length, @NativeType(value="GLbitfield") int access, @Nullable ByteBuffer old_buffer) {
        return GL45C.glMapNamedBufferRange(buffer, offset, length, access, old_buffer);
    }

    @NativeType(value="GLboolean")
    public static boolean glUnmapNamedBuffer(@NativeType(value="GLuint") int buffer) {
        return GL45C.glUnmapNamedBuffer(buffer);
    }

    public static void glFlushMappedNamedBufferRange(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long length) {
        GL45C.glFlushMappedNamedBufferRange(buffer, offset, length);
    }

    public static void nglGetNamedBufferParameteriv(int buffer, int pname, long params) {
        GL45C.nglGetNamedBufferParameteriv(buffer, pname, params);
    }

    public static void glGetNamedBufferParameteriv(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL45C.glGetNamedBufferParameteriv(buffer, pname, params);
    }

    @NativeType(value="void")
    public static int glGetNamedBufferParameteri(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname) {
        return GL45C.glGetNamedBufferParameteri(buffer, pname);
    }

    public static void nglGetNamedBufferParameteri64v(int buffer, int pname, long params) {
        GL45C.nglGetNamedBufferParameteri64v(buffer, pname, params);
    }

    public static void glGetNamedBufferParameteri64v(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") LongBuffer params) {
        GL45C.glGetNamedBufferParameteri64v(buffer, pname, params);
    }

    @NativeType(value="void")
    public static long glGetNamedBufferParameteri64(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname) {
        return GL45C.glGetNamedBufferParameteri64(buffer, pname);
    }

    public static void nglGetNamedBufferPointerv(int buffer, int pname, long params) {
        GL45C.nglGetNamedBufferPointerv(buffer, pname, params);
    }

    public static void glGetNamedBufferPointerv(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname, @NativeType(value="void **") PointerBuffer params) {
        GL45C.glGetNamedBufferPointerv(buffer, pname, params);
    }

    @NativeType(value="void")
    public static long glGetNamedBufferPointer(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname) {
        return GL45C.glGetNamedBufferPointer(buffer, pname);
    }

    public static void nglGetNamedBufferSubData(int buffer, long offset, long size, long data) {
        GL45C.nglGetNamedBufferSubData(buffer, offset, size, data);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") ByteBuffer data) {
        GL45C.glGetNamedBufferSubData(buffer, offset, data);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") ShortBuffer data) {
        GL45C.glGetNamedBufferSubData(buffer, offset, data);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") IntBuffer data) {
        GL45C.glGetNamedBufferSubData(buffer, offset, data);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") LongBuffer data) {
        GL45C.glGetNamedBufferSubData(buffer, offset, data);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") FloatBuffer data) {
        GL45C.glGetNamedBufferSubData(buffer, offset, data);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") DoubleBuffer data) {
        GL45C.glGetNamedBufferSubData(buffer, offset, data);
    }

    public static void nglCreateFramebuffers(int n, long framebuffers) {
        GL45C.nglCreateFramebuffers(n, framebuffers);
    }

    public static void glCreateFramebuffers(@NativeType(value="GLuint *") IntBuffer framebuffers) {
        GL45C.glCreateFramebuffers(framebuffers);
    }

    @NativeType(value="void")
    public static int glCreateFramebuffers() {
        return GL45C.glCreateFramebuffers();
    }

    public static void glNamedFramebufferRenderbuffer(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int attachment, @NativeType(value="GLenum") int renderbuffertarget, @NativeType(value="GLuint") int renderbuffer) {
        GL45C.glNamedFramebufferRenderbuffer(framebuffer, attachment, renderbuffertarget, renderbuffer);
    }

    public static void glNamedFramebufferParameteri(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint") int param) {
        GL45C.glNamedFramebufferParameteri(framebuffer, pname, param);
    }

    public static void glNamedFramebufferTexture(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int attachment, @NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level) {
        GL45C.glNamedFramebufferTexture(framebuffer, attachment, texture, level);
    }

    public static void glNamedFramebufferTextureLayer(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int attachment, @NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int layer) {
        GL45C.glNamedFramebufferTextureLayer(framebuffer, attachment, texture, level, layer);
    }

    public static void glNamedFramebufferDrawBuffer(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int buf) {
        GL45C.glNamedFramebufferDrawBuffer(framebuffer, buf);
    }

    public static void nglNamedFramebufferDrawBuffers(int framebuffer, int n, long bufs) {
        GL45C.nglNamedFramebufferDrawBuffers(framebuffer, n, bufs);
    }

    public static void glNamedFramebufferDrawBuffers(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum const *") IntBuffer bufs) {
        GL45C.glNamedFramebufferDrawBuffers(framebuffer, bufs);
    }

    public static void glNamedFramebufferDrawBuffers(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum const *") int buf) {
        GL45C.glNamedFramebufferDrawBuffers(framebuffer, buf);
    }

    public static void glNamedFramebufferReadBuffer(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int src) {
        GL45C.glNamedFramebufferReadBuffer(framebuffer, src);
    }

    public static void nglInvalidateNamedFramebufferData(int framebuffer, int numAttachments, long attachments) {
        GL45C.nglInvalidateNamedFramebufferData(framebuffer, numAttachments, attachments);
    }

    public static void glInvalidateNamedFramebufferData(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum const *") IntBuffer attachments) {
        GL45C.glInvalidateNamedFramebufferData(framebuffer, attachments);
    }

    public static void glInvalidateNamedFramebufferData(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum const *") int attachment) {
        GL45C.glInvalidateNamedFramebufferData(framebuffer, attachment);
    }

    public static void nglInvalidateNamedFramebufferSubData(int framebuffer, int numAttachments, long attachments, int x, int y, int width, int height) {
        GL45C.nglInvalidateNamedFramebufferSubData(framebuffer, numAttachments, attachments, x, y, width, height);
    }

    public static void glInvalidateNamedFramebufferSubData(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum const *") IntBuffer attachments, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height) {
        GL45C.glInvalidateNamedFramebufferSubData(framebuffer, attachments, x, y, width, height);
    }

    public static void glInvalidateNamedFramebufferSubData(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum const *") int attachment, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height) {
        GL45C.glInvalidateNamedFramebufferSubData(framebuffer, attachment, x, y, width, height);
    }

    public static void nglClearNamedFramebufferiv(int framebuffer, int buffer, int drawbuffer, long value) {
        GL45C.nglClearNamedFramebufferiv(framebuffer, buffer, drawbuffer, value);
    }

    public static void glClearNamedFramebufferiv(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLint *") IntBuffer value) {
        GL45C.glClearNamedFramebufferiv(framebuffer, buffer, drawbuffer, value);
    }

    public static void nglClearNamedFramebufferuiv(int framebuffer, int buffer, int drawbuffer, long value) {
        GL45C.nglClearNamedFramebufferuiv(framebuffer, buffer, drawbuffer, value);
    }

    public static void glClearNamedFramebufferuiv(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLint *") IntBuffer value) {
        GL45C.glClearNamedFramebufferuiv(framebuffer, buffer, drawbuffer, value);
    }

    public static void nglClearNamedFramebufferfv(int framebuffer, int buffer, int drawbuffer, long value) {
        GL45C.nglClearNamedFramebufferfv(framebuffer, buffer, drawbuffer, value);
    }

    public static void glClearNamedFramebufferfv(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLfloat *") FloatBuffer value) {
        GL45C.glClearNamedFramebufferfv(framebuffer, buffer, drawbuffer, value);
    }

    public static void glClearNamedFramebufferfi(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLfloat") float depth, @NativeType(value="GLint") int stencil) {
        GL45C.glClearNamedFramebufferfi(framebuffer, buffer, drawbuffer, depth, stencil);
    }

    public static void glBlitNamedFramebuffer(@NativeType(value="GLuint") int readFramebuffer, @NativeType(value="GLuint") int drawFramebuffer, @NativeType(value="GLint") int srcX0, @NativeType(value="GLint") int srcY0, @NativeType(value="GLint") int srcX1, @NativeType(value="GLint") int srcY1, @NativeType(value="GLint") int dstX0, @NativeType(value="GLint") int dstY0, @NativeType(value="GLint") int dstX1, @NativeType(value="GLint") int dstY1, @NativeType(value="GLbitfield") int mask, @NativeType(value="GLenum") int filter) {
        GL45C.glBlitNamedFramebuffer(readFramebuffer, drawFramebuffer, srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
    }

    @NativeType(value="GLenum")
    public static int glCheckNamedFramebufferStatus(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int target) {
        return GL45C.glCheckNamedFramebufferStatus(framebuffer, target);
    }

    public static void nglGetNamedFramebufferParameteriv(int framebuffer, int pname, long params) {
        GL45C.nglGetNamedFramebufferParameteriv(framebuffer, pname, params);
    }

    public static void glGetNamedFramebufferParameteriv(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL45C.glGetNamedFramebufferParameteriv(framebuffer, pname, params);
    }

    @NativeType(value="void")
    public static int glGetNamedFramebufferParameteri(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int pname) {
        return GL45C.glGetNamedFramebufferParameteri(framebuffer, pname);
    }

    public static void nglGetNamedFramebufferAttachmentParameteriv(int framebuffer, int attachment, int pname, long params) {
        GL45C.nglGetNamedFramebufferAttachmentParameteriv(framebuffer, attachment, pname, params);
    }

    public static void glGetNamedFramebufferAttachmentParameteriv(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int attachment, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL45C.glGetNamedFramebufferAttachmentParameteriv(framebuffer, attachment, pname, params);
    }

    @NativeType(value="void")
    public static int glGetNamedFramebufferAttachmentParameteri(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int attachment, @NativeType(value="GLenum") int pname) {
        return GL45C.glGetNamedFramebufferAttachmentParameteri(framebuffer, attachment, pname);
    }

    public static void nglCreateRenderbuffers(int n, long renderbuffers) {
        GL45C.nglCreateRenderbuffers(n, renderbuffers);
    }

    public static void glCreateRenderbuffers(@NativeType(value="GLuint *") IntBuffer renderbuffers) {
        GL45C.glCreateRenderbuffers(renderbuffers);
    }

    @NativeType(value="void")
    public static int glCreateRenderbuffers() {
        return GL45C.glCreateRenderbuffers();
    }

    public static void glNamedRenderbufferStorage(@NativeType(value="GLuint") int renderbuffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height) {
        GL45C.glNamedRenderbufferStorage(renderbuffer, internalformat, width, height);
    }

    public static void glNamedRenderbufferStorageMultisample(@NativeType(value="GLuint") int renderbuffer, @NativeType(value="GLsizei") int samples, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height) {
        GL45C.glNamedRenderbufferStorageMultisample(renderbuffer, samples, internalformat, width, height);
    }

    public static void nglGetNamedRenderbufferParameteriv(int renderbuffer, int pname, long params) {
        GL45C.nglGetNamedRenderbufferParameteriv(renderbuffer, pname, params);
    }

    public static void glGetNamedRenderbufferParameteriv(@NativeType(value="GLuint") int renderbuffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL45C.glGetNamedRenderbufferParameteriv(renderbuffer, pname, params);
    }

    @NativeType(value="void")
    public static int glGetNamedRenderbufferParameteri(@NativeType(value="GLuint") int renderbuffer, @NativeType(value="GLenum") int pname) {
        return GL45C.glGetNamedRenderbufferParameteri(renderbuffer, pname);
    }

    public static void nglCreateTextures(int target, int n, long textures) {
        GL45C.nglCreateTextures(target, n, textures);
    }

    public static void glCreateTextures(@NativeType(value="GLenum") int target, @NativeType(value="GLuint *") IntBuffer textures) {
        GL45C.glCreateTextures(target, textures);
    }

    @NativeType(value="void")
    public static int glCreateTextures(@NativeType(value="GLenum") int target) {
        return GL45C.glCreateTextures(target);
    }

    public static void glTextureBuffer(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLuint") int buffer) {
        GL45C.glTextureBuffer(texture, internalformat, buffer);
    }

    public static void glTextureBufferRange(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size) {
        GL45C.glTextureBufferRange(texture, internalformat, buffer, offset, size);
    }

    public static void glTextureStorage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLsizei") int levels, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width) {
        GL45C.glTextureStorage1D(texture, levels, internalformat, width);
    }

    public static void glTextureStorage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLsizei") int levels, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height) {
        GL45C.glTextureStorage2D(texture, levels, internalformat, width, height);
    }

    public static void glTextureStorage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLsizei") int levels, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth) {
        GL45C.glTextureStorage3D(texture, levels, internalformat, width, height, depth);
    }

    public static void glTextureStorage2DMultisample(@NativeType(value="GLuint") int texture, @NativeType(value="GLsizei") int samples, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLboolean") boolean fixedsamplelocations) {
        GL45C.glTextureStorage2DMultisample(texture, samples, internalformat, width, height, fixedsamplelocations);
    }

    public static void glTextureStorage3DMultisample(@NativeType(value="GLuint") int texture, @NativeType(value="GLsizei") int samples, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLboolean") boolean fixedsamplelocations) {
        GL45C.glTextureStorage3DMultisample(texture, samples, internalformat, width, height, depth, fixedsamplelocations);
    }

    public static void nglTextureSubImage1D(int texture, int level, int xoffset, int width, int format, int type, long pixels) {
        GL45C.nglTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer pixels) {
        GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long pixels) {
        GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ShortBuffer pixels) {
        GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer pixels) {
        GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") FloatBuffer pixels) {
        GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") DoubleBuffer pixels) {
        GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
    }

    public static void nglTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int width, int height, int format, int type, long pixels) {
        GL45C.nglTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer pixels) {
        GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long pixels) {
        GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ShortBuffer pixels) {
        GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer pixels) {
        GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") FloatBuffer pixels) {
        GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") DoubleBuffer pixels) {
        GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void nglTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, long pixels) {
        GL45C.nglTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer pixels) {
        GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long pixels) {
        GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ShortBuffer pixels) {
        GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer pixels) {
        GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") FloatBuffer pixels) {
        GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") DoubleBuffer pixels) {
        GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void nglCompressedTextureSubImage1D(int texture, int level, int xoffset, int width, int format, int imageSize, long data) {
        GL45C.nglCompressedTextureSubImage1D(texture, level, xoffset, width, format, imageSize, data);
    }

    public static void glCompressedTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int imageSize, @NativeType(value="void const *") long data) {
        GL45C.glCompressedTextureSubImage1D(texture, level, xoffset, width, format, imageSize, data);
    }

    public static void glCompressedTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="void const *") ByteBuffer data) {
        GL45C.glCompressedTextureSubImage1D(texture, level, xoffset, width, format, data);
    }

    public static void nglCompressedTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, long data) {
        GL45C.nglCompressedTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, imageSize, data);
    }

    public static void glCompressedTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int imageSize, @NativeType(value="void const *") long data) {
        GL45C.glCompressedTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, imageSize, data);
    }

    public static void glCompressedTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="void const *") ByteBuffer data) {
        GL45C.glCompressedTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, data);
    }

    public static void nglCompressedTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, long data) {
        GL45C.nglCompressedTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
    }

    public static void glCompressedTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int imageSize, @NativeType(value="void const *") long data) {
        GL45C.glCompressedTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
    }

    public static void glCompressedTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="void const *") ByteBuffer data) {
        GL45C.glCompressedTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, data);
    }

    public static void glCopyTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width) {
        GL45C.glCopyTextureSubImage1D(texture, level, xoffset, x, y, width);
    }

    public static void glCopyTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height) {
        GL45C.glCopyTextureSubImage2D(texture, level, xoffset, yoffset, x, y, width, height);
    }

    public static void glCopyTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height) {
        GL45C.glCopyTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, x, y, width, height);
    }

    public static void glTextureParameterf(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat") float param) {
        GL45C.glTextureParameterf(texture, pname, param);
    }

    public static void nglTextureParameterfv(int texture, int pname, long params) {
        GL45C.nglTextureParameterfv(texture, pname, params);
    }

    public static void glTextureParameterfv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer params) {
        GL45C.glTextureParameterfv(texture, pname, params);
    }

    public static void glTextureParameteri(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLint") int param) {
        GL45C.glTextureParameteri(texture, pname, param);
    }

    public static void nglTextureParameterIiv(int texture, int pname, long params) {
        GL45C.nglTextureParameterIiv(texture, pname, params);
    }

    public static void glTextureParameterIiv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        GL45C.glTextureParameterIiv(texture, pname, params);
    }

    public static void glTextureParameterIi(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int param) {
        GL45C.glTextureParameterIi(texture, pname, param);
    }

    public static void nglTextureParameterIuiv(int texture, int pname, long params) {
        GL45C.nglTextureParameterIuiv(texture, pname, params);
    }

    public static void glTextureParameterIuiv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint const *") IntBuffer params) {
        GL45C.glTextureParameterIuiv(texture, pname, params);
    }

    public static void glTextureParameterIui(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint const *") int param) {
        GL45C.glTextureParameterIui(texture, pname, param);
    }

    public static void nglTextureParameteriv(int texture, int pname, long params) {
        GL45C.nglTextureParameteriv(texture, pname, params);
    }

    public static void glTextureParameteriv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        GL45C.glTextureParameteriv(texture, pname, params);
    }

    public static void glGenerateTextureMipmap(@NativeType(value="GLuint") int texture) {
        GL45C.glGenerateTextureMipmap(texture);
    }

    public static void glBindTextureUnit(@NativeType(value="GLuint") int unit, @NativeType(value="GLuint") int texture) {
        GL45C.glBindTextureUnit(unit, texture);
    }

    public static void nglGetTextureImage(int texture, int level, int format, int type, int bufSize, long pixels) {
        GL45C.nglGetTextureImage(texture, level, format, type, bufSize, pixels);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long pixels) {
        GL45C.glGetTextureImage(texture, level, format, type, bufSize, pixels);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer pixels) {
        GL45C.glGetTextureImage(texture, level, format, type, pixels);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ShortBuffer pixels) {
        GL45C.glGetTextureImage(texture, level, format, type, pixels);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") IntBuffer pixels) {
        GL45C.glGetTextureImage(texture, level, format, type, pixels);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") FloatBuffer pixels) {
        GL45C.glGetTextureImage(texture, level, format, type, pixels);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") DoubleBuffer pixels) {
        GL45C.glGetTextureImage(texture, level, format, type, pixels);
    }

    public static void nglGetCompressedTextureImage(int texture, int level, int bufSize, long pixels) {
        GL45C.nglGetCompressedTextureImage(texture, level, bufSize, pixels);
    }

    public static void glGetCompressedTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long pixels) {
        GL45C.glGetCompressedTextureImage(texture, level, bufSize, pixels);
    }

    public static void glGetCompressedTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="void *") ByteBuffer pixels) {
        GL45C.glGetCompressedTextureImage(texture, level, pixels);
    }

    public static void nglGetTextureLevelParameterfv(int texture, int level, int pname, long params) {
        GL45C.nglGetTextureLevelParameterfv(texture, level, pname, params);
    }

    public static void glGetTextureLevelParameterfv(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        GL45C.glGetTextureLevelParameterfv(texture, level, pname, params);
    }

    @NativeType(value="void")
    public static float glGetTextureLevelParameterf(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname) {
        return GL45C.glGetTextureLevelParameterf(texture, level, pname);
    }

    public static void nglGetTextureLevelParameteriv(int texture, int level, int pname, long params) {
        GL45C.nglGetTextureLevelParameteriv(texture, level, pname, params);
    }

    public static void glGetTextureLevelParameteriv(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL45C.glGetTextureLevelParameteriv(texture, level, pname, params);
    }

    @NativeType(value="void")
    public static int glGetTextureLevelParameteri(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname) {
        return GL45C.glGetTextureLevelParameteri(texture, level, pname);
    }

    public static void nglGetTextureParameterfv(int texture, int pname, long params) {
        GL45C.nglGetTextureParameterfv(texture, pname, params);
    }

    public static void glGetTextureParameterfv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        GL45C.glGetTextureParameterfv(texture, pname, params);
    }

    @NativeType(value="void")
    public static float glGetTextureParameterf(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname) {
        return GL45C.glGetTextureParameterf(texture, pname);
    }

    public static void nglGetTextureParameterIiv(int texture, int pname, long params) {
        GL45C.nglGetTextureParameterIiv(texture, pname, params);
    }

    public static void glGetTextureParameterIiv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL45C.glGetTextureParameterIiv(texture, pname, params);
    }

    @NativeType(value="void")
    public static int glGetTextureParameterIi(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname) {
        return GL45C.glGetTextureParameterIi(texture, pname);
    }

    public static void nglGetTextureParameterIuiv(int texture, int pname, long params) {
        GL45C.nglGetTextureParameterIuiv(texture, pname, params);
    }

    public static void glGetTextureParameterIuiv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") IntBuffer params) {
        GL45C.glGetTextureParameterIuiv(texture, pname, params);
    }

    @NativeType(value="void")
    public static int glGetTextureParameterIui(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname) {
        return GL45C.glGetTextureParameterIui(texture, pname);
    }

    public static void nglGetTextureParameteriv(int texture, int pname, long params) {
        GL45C.nglGetTextureParameteriv(texture, pname, params);
    }

    public static void glGetTextureParameteriv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL45C.glGetTextureParameteriv(texture, pname, params);
    }

    @NativeType(value="void")
    public static int glGetTextureParameteri(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname) {
        return GL45C.glGetTextureParameteri(texture, pname);
    }

    public static void nglCreateVertexArrays(int n, long arrays) {
        GL45C.nglCreateVertexArrays(n, arrays);
    }

    public static void glCreateVertexArrays(@NativeType(value="GLuint *") IntBuffer arrays) {
        GL45C.glCreateVertexArrays(arrays);
    }

    @NativeType(value="void")
    public static int glCreateVertexArrays() {
        return GL45C.glCreateVertexArrays();
    }

    public static void glDisableVertexArrayAttrib(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int index) {
        GL45C.glDisableVertexArrayAttrib(vaobj, index);
    }

    public static void glEnableVertexArrayAttrib(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int index) {
        GL45C.glEnableVertexArrayAttrib(vaobj, index);
    }

    public static void glVertexArrayElementBuffer(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int buffer) {
        GL45C.glVertexArrayElementBuffer(vaobj, buffer);
    }

    public static void glVertexArrayVertexBuffer(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int bindingindex, @NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizei") int stride) {
        GL45C.glVertexArrayVertexBuffer(vaobj, bindingindex, buffer, offset, stride);
    }

    public static void nglVertexArrayVertexBuffers(int vaobj, int first, int count, long buffers, long offsets, long strides) {
        GL45C.nglVertexArrayVertexBuffers(vaobj, first, count, buffers, offsets, strides);
    }

    public static void glVertexArrayVertexBuffers(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") IntBuffer buffers, @Nullable @NativeType(value="GLintptr const *") PointerBuffer offsets, @Nullable @NativeType(value="GLsizei const *") IntBuffer strides) {
        GL45C.glVertexArrayVertexBuffers(vaobj, first, buffers, offsets, strides);
    }

    public static void glVertexArrayAttribFormat(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int attribindex, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint") int relativeoffset) {
        GL45C.glVertexArrayAttribFormat(vaobj, attribindex, size, type, normalized, relativeoffset);
    }

    public static void glVertexArrayAttribIFormat(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int attribindex, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLuint") int relativeoffset) {
        GL45C.glVertexArrayAttribIFormat(vaobj, attribindex, size, type, relativeoffset);
    }

    public static void glVertexArrayAttribLFormat(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int attribindex, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLuint") int relativeoffset) {
        GL45C.glVertexArrayAttribLFormat(vaobj, attribindex, size, type, relativeoffset);
    }

    public static void glVertexArrayAttribBinding(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int attribindex, @NativeType(value="GLuint") int bindingindex) {
        GL45C.glVertexArrayAttribBinding(vaobj, attribindex, bindingindex);
    }

    public static void glVertexArrayBindingDivisor(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int bindingindex, @NativeType(value="GLuint") int divisor) {
        GL45C.glVertexArrayBindingDivisor(vaobj, bindingindex, divisor);
    }

    public static void nglGetVertexArrayiv(int vaobj, int pname, long param) {
        GL45C.nglGetVertexArrayiv(vaobj, pname, param);
    }

    public static void glGetVertexArrayiv(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer param) {
        GL45C.glGetVertexArrayiv(vaobj, pname, param);
    }

    @NativeType(value="void")
    public static int glGetVertexArrayi(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLenum") int pname) {
        return GL45C.glGetVertexArrayi(vaobj, pname);
    }

    public static void nglGetVertexArrayIndexediv(int vaobj, int index, int pname, long param) {
        GL45C.nglGetVertexArrayIndexediv(vaobj, index, pname, param);
    }

    public static void glGetVertexArrayIndexediv(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer param) {
        GL45C.glGetVertexArrayIndexediv(vaobj, index, pname, param);
    }

    @NativeType(value="void")
    public static int glGetVertexArrayIndexedi(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        return GL45C.glGetVertexArrayIndexedi(vaobj, index, pname);
    }

    public static void nglGetVertexArrayIndexed64iv(int vaobj, int index, int pname, long param) {
        GL45C.nglGetVertexArrayIndexed64iv(vaobj, index, pname, param);
    }

    public static void glGetVertexArrayIndexed64iv(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") LongBuffer param) {
        GL45C.glGetVertexArrayIndexed64iv(vaobj, index, pname, param);
    }

    @NativeType(value="void")
    public static long glGetVertexArrayIndexed64i(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        return GL45C.glGetVertexArrayIndexed64i(vaobj, index, pname);
    }

    public static void nglCreateSamplers(int n, long samplers) {
        GL45C.nglCreateSamplers(n, samplers);
    }

    public static void glCreateSamplers(@NativeType(value="GLuint *") IntBuffer samplers) {
        GL45C.glCreateSamplers(samplers);
    }

    @NativeType(value="void")
    public static int glCreateSamplers() {
        return GL45C.glCreateSamplers();
    }

    public static void nglCreateProgramPipelines(int n, long pipelines) {
        GL45C.nglCreateProgramPipelines(n, pipelines);
    }

    public static void glCreateProgramPipelines(@NativeType(value="GLuint *") IntBuffer pipelines) {
        GL45C.glCreateProgramPipelines(pipelines);
    }

    @NativeType(value="void")
    public static int glCreateProgramPipelines() {
        return GL45C.glCreateProgramPipelines();
    }

    public static void nglCreateQueries(int target, int n, long ids) {
        GL45C.nglCreateQueries(target, n, ids);
    }

    public static void glCreateQueries(@NativeType(value="GLenum") int target, @NativeType(value="GLuint *") IntBuffer ids) {
        GL45C.glCreateQueries(target, ids);
    }

    @NativeType(value="void")
    public static int glCreateQueries(@NativeType(value="GLenum") int target) {
        return GL45C.glCreateQueries(target);
    }

    public static void glGetQueryBufferObjectiv(@NativeType(value="GLuint") int id, @NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLintptr") long offset) {
        GL45C.glGetQueryBufferObjectiv(id, buffer, pname, offset);
    }

    public static void glGetQueryBufferObjectuiv(@NativeType(value="GLuint") int id, @NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLintptr") long offset) {
        GL45C.glGetQueryBufferObjectuiv(id, buffer, pname, offset);
    }

    public static void glGetQueryBufferObjecti64v(@NativeType(value="GLuint") int id, @NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLintptr") long offset) {
        GL45C.glGetQueryBufferObjecti64v(id, buffer, pname, offset);
    }

    public static void glGetQueryBufferObjectui64v(@NativeType(value="GLuint") int id, @NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLintptr") long offset) {
        GL45C.glGetQueryBufferObjectui64v(id, buffer, pname, offset);
    }

    public static void glMemoryBarrierByRegion(@NativeType(value="GLbitfield") int barriers) {
        GL45C.glMemoryBarrierByRegion(barriers);
    }

    public static void nglGetTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, int bufSize, long pixels) {
        GL45C.nglGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, bufSize, pixels);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long pixels) {
        GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, bufSize, pixels);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer pixels) {
        GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ShortBuffer pixels) {
        GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") IntBuffer pixels) {
        GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") FloatBuffer pixels) {
        GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") DoubleBuffer pixels) {
        GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void nglGetCompressedTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int bufSize, long pixels) {
        GL45C.nglGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, bufSize, pixels);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long pixels) {
        GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, bufSize, pixels);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") ByteBuffer pixels) {
        GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") ShortBuffer pixels) {
        GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") IntBuffer pixels) {
        GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") FloatBuffer pixels) {
        GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") DoubleBuffer pixels) {
        GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
    }

    public static void glTextureBarrier() {
        GL45C.glTextureBarrier();
    }

    @NativeType(value="GLenum")
    public static int glGetGraphicsResetStatus() {
        return GL45C.glGetGraphicsResetStatus();
    }

    public static native void nglGetnMapdv(int var0, int var1, int var2, long var3);

    public static void glGetnMapdv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query, @NativeType(value="GLdouble *") DoubleBuffer data) {
        GL45.nglGetnMapdv(target, query, data.remaining(), MemoryUtil.memAddress(data));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static double glGetnMapd(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            DoubleBuffer data = stack.callocDouble(1);
            GL45.nglGetnMapdv(target, query, 1, MemoryUtil.memAddress(data));
            double d = data.get(0);
            return d;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetnMapfv(int var0, int var1, int var2, long var3);

    public static void glGetnMapfv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query, @NativeType(value="GLfloat *") FloatBuffer data) {
        GL45.nglGetnMapfv(target, query, data.remaining(), MemoryUtil.memAddress(data));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetnMapf(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer data = stack.callocFloat(1);
            GL45.nglGetnMapfv(target, query, 1, MemoryUtil.memAddress(data));
            float f = data.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetnMapiv(int var0, int var1, int var2, long var3);

    public static void glGetnMapiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query, @NativeType(value="GLint *") IntBuffer data) {
        GL45.nglGetnMapiv(target, query, data.remaining(), MemoryUtil.memAddress(data));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetnMapi(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer data = stack.callocInt(1);
            GL45.nglGetnMapiv(target, query, 1, MemoryUtil.memAddress(data));
            int n = data.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetnPixelMapfv(int var0, int var1, long var2);

    public static void glGetnPixelMapfv(@NativeType(value="GLenum") int map, @NativeType(value="GLfloat *") FloatBuffer data) {
        GL45.nglGetnPixelMapfv(map, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static native void nglGetnPixelMapuiv(int var0, int var1, long var2);

    public static void glGetnPixelMapuiv(@NativeType(value="GLenum") int map, @NativeType(value="GLuint *") IntBuffer data) {
        GL45.nglGetnPixelMapuiv(map, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static native void nglGetnPixelMapusv(int var0, int var1, long var2);

    public static void glGetnPixelMapusv(@NativeType(value="GLenum") int map, @NativeType(value="GLushort *") ShortBuffer data) {
        GL45.nglGetnPixelMapusv(map, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static native void nglGetnPolygonStipple(int var0, long var1);

    public static void glGetnPolygonStipple(@NativeType(value="GLsizei") int bufSize, @NativeType(value="GLubyte *") long pattern) {
        GL45.nglGetnPolygonStipple(bufSize, pattern);
    }

    public static void glGetnPolygonStipple(@NativeType(value="GLubyte *") ByteBuffer pattern) {
        GL45.nglGetnPolygonStipple(pattern.remaining(), MemoryUtil.memAddress(pattern));
    }

    public static void nglGetnTexImage(int tex, int level, int format, int type, int bufSize, long img) {
        GL45C.nglGetnTexImage(tex, level, format, type, bufSize, img);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long img) {
        GL45C.glGetnTexImage(tex, level, format, type, bufSize, img);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer img) {
        GL45C.glGetnTexImage(tex, level, format, type, img);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ShortBuffer img) {
        GL45C.glGetnTexImage(tex, level, format, type, img);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") IntBuffer img) {
        GL45C.glGetnTexImage(tex, level, format, type, img);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") FloatBuffer img) {
        GL45C.glGetnTexImage(tex, level, format, type, img);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") DoubleBuffer img) {
        GL45C.glGetnTexImage(tex, level, format, type, img);
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

    public static native void nglGetnColorTable(int var0, int var1, int var2, int var3, long var4);

    public static void glGetnColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long table) {
        GL45.nglGetnColorTable(target, format, type, bufSize, table);
    }

    public static void glGetnColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer table) {
        GL45.nglGetnColorTable(target, format, type, table.remaining(), MemoryUtil.memAddress(table));
    }

    public static void glGetnColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ShortBuffer table) {
        GL45.nglGetnColorTable(target, format, type, table.remaining() << 1, MemoryUtil.memAddress(table));
    }

    public static void glGetnColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") IntBuffer table) {
        GL45.nglGetnColorTable(target, format, type, table.remaining() << 2, MemoryUtil.memAddress(table));
    }

    public static void glGetnColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") FloatBuffer table) {
        GL45.nglGetnColorTable(target, format, type, table.remaining() << 2, MemoryUtil.memAddress(table));
    }

    public static native void nglGetnConvolutionFilter(int var0, int var1, int var2, int var3, long var4);

    public static void glGetnConvolutionFilter(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long image) {
        GL45.nglGetnConvolutionFilter(target, format, type, bufSize, image);
    }

    public static void glGetnConvolutionFilter(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer image) {
        GL45.nglGetnConvolutionFilter(target, format, type, image.remaining(), MemoryUtil.memAddress(image));
    }

    public static native void nglGetnSeparableFilter(int var0, int var1, int var2, int var3, long var4, int var6, long var7, long var9);

    public static void glGetnSeparableFilter(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int rowBufSize, @NativeType(value="void *") long row, @NativeType(value="GLsizei") int columnBufSize, @NativeType(value="void *") long column, @Nullable @NativeType(value="void *") ByteBuffer span) {
        GL45.nglGetnSeparableFilter(target, format, type, rowBufSize, row, columnBufSize, column, MemoryUtil.memAddressSafe(span));
    }

    public static void glGetnSeparableFilter(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer row, @NativeType(value="void *") ByteBuffer column, @Nullable @NativeType(value="void *") ByteBuffer span) {
        GL45.nglGetnSeparableFilter(target, format, type, row.remaining(), MemoryUtil.memAddress(row), column.remaining(), MemoryUtil.memAddress(column), MemoryUtil.memAddressSafe(span));
    }

    public static native void nglGetnHistogram(int var0, boolean var1, int var2, int var3, int var4, long var5);

    public static void glGetnHistogram(@NativeType(value="GLenum") int target, @NativeType(value="GLboolean") boolean reset, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long values) {
        GL45.nglGetnHistogram(target, reset, format, type, bufSize, values);
    }

    public static void glGetnHistogram(@NativeType(value="GLenum") int target, @NativeType(value="GLboolean") boolean reset, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer values) {
        GL45.nglGetnHistogram(target, reset, format, type, values.remaining(), MemoryUtil.memAddress(values));
    }

    public static native void nglGetnMinmax(int var0, boolean var1, int var2, int var3, int var4, long var5);

    public static void glGetnMinmax(@NativeType(value="GLenum") int target, @NativeType(value="GLboolean") boolean reset, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long values) {
        GL45.nglGetnMinmax(target, reset, format, type, bufSize, values);
    }

    public static void glGetnMinmax(@NativeType(value="GLenum") int target, @NativeType(value="GLboolean") boolean reset, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer values) {
        GL45.nglGetnMinmax(target, reset, format, type, values.remaining(), MemoryUtil.memAddress(values));
    }

    public static void nglGetnCompressedTexImage(int target, int level, int bufSize, long img) {
        GL45C.nglGetnCompressedTexImage(target, level, bufSize, img);
    }

    public static void glGetnCompressedTexImage(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long img) {
        GL45C.glGetnCompressedTexImage(target, level, bufSize, img);
    }

    public static void glGetnCompressedTexImage(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="void *") ByteBuffer img) {
        GL45C.glGetnCompressedTexImage(target, level, img);
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

    public static void nglGetnUniformdv(int program, int location, int bufSize, long params) {
        GL45C.nglGetnUniformdv(program, location, bufSize, params);
    }

    public static void glGetnUniformdv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble *") DoubleBuffer params) {
        GL45C.glGetnUniformdv(program, location, params);
    }

    @NativeType(value="void")
    public static double glGetnUniformd(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        return GL45C.glGetnUniformd(program, location);
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

    public static void glCreateTransformFeedbacks(@NativeType(value="GLuint *") int[] ids) {
        GL45C.glCreateTransformFeedbacks(ids);
    }

    public static void glGetTransformFeedbackiv(@NativeType(value="GLuint") int xfb, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] param) {
        GL45C.glGetTransformFeedbackiv(xfb, pname, param);
    }

    public static void glGetTransformFeedbacki_v(@NativeType(value="GLuint") int xfb, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") int[] param) {
        GL45C.glGetTransformFeedbacki_v(xfb, pname, index, param);
    }

    public static void glGetTransformFeedbacki64_v(@NativeType(value="GLuint") int xfb, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index, @NativeType(value="GLint64 *") long[] param) {
        GL45C.glGetTransformFeedbacki64_v(xfb, pname, index, param);
    }

    public static void glCreateBuffers(@NativeType(value="GLuint *") int[] buffers) {
        GL45C.glCreateBuffers(buffers);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") short[] data, @NativeType(value="GLbitfield") int flags) {
        GL45C.glNamedBufferStorage(buffer, data, flags);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") int[] data, @NativeType(value="GLbitfield") int flags) {
        GL45C.glNamedBufferStorage(buffer, data, flags);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") float[] data, @NativeType(value="GLbitfield") int flags) {
        GL45C.glNamedBufferStorage(buffer, data, flags);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") double[] data, @NativeType(value="GLbitfield") int flags) {
        GL45C.glNamedBufferStorage(buffer, data, flags);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") short[] data, @NativeType(value="GLenum") int usage) {
        GL45C.glNamedBufferData(buffer, data, usage);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") int[] data, @NativeType(value="GLenum") int usage) {
        GL45C.glNamedBufferData(buffer, data, usage);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") long[] data, @NativeType(value="GLenum") int usage) {
        GL45C.glNamedBufferData(buffer, data, usage);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") float[] data, @NativeType(value="GLenum") int usage) {
        GL45C.glNamedBufferData(buffer, data, usage);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") double[] data, @NativeType(value="GLenum") int usage) {
        GL45C.glNamedBufferData(buffer, data, usage);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") short[] data) {
        GL45C.glNamedBufferSubData(buffer, offset, data);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") int[] data) {
        GL45C.glNamedBufferSubData(buffer, offset, data);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") long[] data) {
        GL45C.glNamedBufferSubData(buffer, offset, data);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") float[] data) {
        GL45C.glNamedBufferSubData(buffer, offset, data);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") double[] data) {
        GL45C.glNamedBufferSubData(buffer, offset, data);
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") short[] data) {
        GL45C.glClearNamedBufferData(buffer, internalformat, format, type, data);
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") int[] data) {
        GL45C.glClearNamedBufferData(buffer, internalformat, format, type, data);
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") float[] data) {
        GL45C.glClearNamedBufferData(buffer, internalformat, format, type, data);
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") short[] data) {
        GL45C.glClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") int[] data) {
        GL45C.glClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") float[] data) {
        GL45C.glClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
    }

    public static void glGetNamedBufferParameteriv(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL45C.glGetNamedBufferParameteriv(buffer, pname, params);
    }

    public static void glGetNamedBufferParameteri64v(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") long[] params) {
        GL45C.glGetNamedBufferParameteri64v(buffer, pname, params);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") short[] data) {
        GL45C.glGetNamedBufferSubData(buffer, offset, data);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") int[] data) {
        GL45C.glGetNamedBufferSubData(buffer, offset, data);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") long[] data) {
        GL45C.glGetNamedBufferSubData(buffer, offset, data);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") float[] data) {
        GL45C.glGetNamedBufferSubData(buffer, offset, data);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") double[] data) {
        GL45C.glGetNamedBufferSubData(buffer, offset, data);
    }

    public static void glCreateFramebuffers(@NativeType(value="GLuint *") int[] framebuffers) {
        GL45C.glCreateFramebuffers(framebuffers);
    }

    public static void glNamedFramebufferDrawBuffers(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum const *") int[] bufs) {
        GL45C.glNamedFramebufferDrawBuffers(framebuffer, bufs);
    }

    public static void glInvalidateNamedFramebufferData(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum const *") int[] attachments) {
        GL45C.glInvalidateNamedFramebufferData(framebuffer, attachments);
    }

    public static void glInvalidateNamedFramebufferSubData(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum const *") int[] attachments, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height) {
        GL45C.glInvalidateNamedFramebufferSubData(framebuffer, attachments, x, y, width, height);
    }

    public static void glClearNamedFramebufferiv(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLint *") int[] value) {
        GL45C.glClearNamedFramebufferiv(framebuffer, buffer, drawbuffer, value);
    }

    public static void glClearNamedFramebufferuiv(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLint *") int[] value) {
        GL45C.glClearNamedFramebufferuiv(framebuffer, buffer, drawbuffer, value);
    }

    public static void glClearNamedFramebufferfv(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLfloat *") float[] value) {
        GL45C.glClearNamedFramebufferfv(framebuffer, buffer, drawbuffer, value);
    }

    public static void glGetNamedFramebufferParameteriv(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL45C.glGetNamedFramebufferParameteriv(framebuffer, pname, params);
    }

    public static void glGetNamedFramebufferAttachmentParameteriv(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int attachment, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL45C.glGetNamedFramebufferAttachmentParameteriv(framebuffer, attachment, pname, params);
    }

    public static void glCreateRenderbuffers(@NativeType(value="GLuint *") int[] renderbuffers) {
        GL45C.glCreateRenderbuffers(renderbuffers);
    }

    public static void glGetNamedRenderbufferParameteriv(@NativeType(value="GLuint") int renderbuffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL45C.glGetNamedRenderbufferParameteriv(renderbuffer, pname, params);
    }

    public static void glCreateTextures(@NativeType(value="GLenum") int target, @NativeType(value="GLuint *") int[] textures) {
        GL45C.glCreateTextures(target, textures);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") short[] pixels) {
        GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] pixels) {
        GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") float[] pixels) {
        GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") double[] pixels) {
        GL45C.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") short[] pixels) {
        GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] pixels) {
        GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") float[] pixels) {
        GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") double[] pixels) {
        GL45C.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") short[] pixels) {
        GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] pixels) {
        GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") float[] pixels) {
        GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") double[] pixels) {
        GL45C.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glTextureParameterfv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] params) {
        GL45C.glTextureParameterfv(texture, pname, params);
    }

    public static void glTextureParameterIiv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        GL45C.glTextureParameterIiv(texture, pname, params);
    }

    public static void glTextureParameterIuiv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint const *") int[] params) {
        GL45C.glTextureParameterIuiv(texture, pname, params);
    }

    public static void glTextureParameteriv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        GL45C.glTextureParameteriv(texture, pname, params);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") short[] pixels) {
        GL45C.glGetTextureImage(texture, level, format, type, pixels);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") int[] pixels) {
        GL45C.glGetTextureImage(texture, level, format, type, pixels);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") float[] pixels) {
        GL45C.glGetTextureImage(texture, level, format, type, pixels);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") double[] pixels) {
        GL45C.glGetTextureImage(texture, level, format, type, pixels);
    }

    public static void glGetTextureLevelParameterfv(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        GL45C.glGetTextureLevelParameterfv(texture, level, pname, params);
    }

    public static void glGetTextureLevelParameteriv(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL45C.glGetTextureLevelParameteriv(texture, level, pname, params);
    }

    public static void glGetTextureParameterfv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        GL45C.glGetTextureParameterfv(texture, pname, params);
    }

    public static void glGetTextureParameterIiv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL45C.glGetTextureParameterIiv(texture, pname, params);
    }

    public static void glGetTextureParameterIuiv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") int[] params) {
        GL45C.glGetTextureParameterIuiv(texture, pname, params);
    }

    public static void glGetTextureParameteriv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL45C.glGetTextureParameteriv(texture, pname, params);
    }

    public static void glCreateVertexArrays(@NativeType(value="GLuint *") int[] arrays) {
        GL45C.glCreateVertexArrays(arrays);
    }

    public static void glVertexArrayVertexBuffers(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") int[] buffers, @Nullable @NativeType(value="GLintptr const *") PointerBuffer offsets, @Nullable @NativeType(value="GLsizei const *") int[] strides) {
        GL45C.glVertexArrayVertexBuffers(vaobj, first, buffers, offsets, strides);
    }

    public static void glGetVertexArrayiv(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] param) {
        GL45C.glGetVertexArrayiv(vaobj, pname, param);
    }

    public static void glGetVertexArrayIndexediv(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] param) {
        GL45C.glGetVertexArrayIndexediv(vaobj, index, pname, param);
    }

    public static void glGetVertexArrayIndexed64iv(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") long[] param) {
        GL45C.glGetVertexArrayIndexed64iv(vaobj, index, pname, param);
    }

    public static void glCreateSamplers(@NativeType(value="GLuint *") int[] samplers) {
        GL45C.glCreateSamplers(samplers);
    }

    public static void glCreateProgramPipelines(@NativeType(value="GLuint *") int[] pipelines) {
        GL45C.glCreateProgramPipelines(pipelines);
    }

    public static void glCreateQueries(@NativeType(value="GLenum") int target, @NativeType(value="GLuint *") int[] ids) {
        GL45C.glCreateQueries(target, ids);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") short[] pixels) {
        GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") int[] pixels) {
        GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") float[] pixels) {
        GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") double[] pixels) {
        GL45C.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") short[] pixels) {
        GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") int[] pixels) {
        GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") float[] pixels) {
        GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") double[] pixels) {
        GL45C.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels);
    }

    public static void glGetnMapdv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query, @NativeType(value="GLdouble *") double[] data) {
        long __functionAddress = GL.getICD().glGetnMapdv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, query, data.length, data, __functionAddress);
    }

    public static void glGetnMapfv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query, @NativeType(value="GLfloat *") float[] data) {
        long __functionAddress = GL.getICD().glGetnMapfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, query, data.length, data, __functionAddress);
    }

    public static void glGetnMapiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int query, @NativeType(value="GLint *") int[] data) {
        long __functionAddress = GL.getICD().glGetnMapiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, query, data.length, data, __functionAddress);
    }

    public static void glGetnPixelMapfv(@NativeType(value="GLenum") int map, @NativeType(value="GLfloat *") float[] data) {
        long __functionAddress = GL.getICD().glGetnPixelMapfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(map, data.length, data, __functionAddress);
    }

    public static void glGetnPixelMapuiv(@NativeType(value="GLenum") int map, @NativeType(value="GLuint *") int[] data) {
        long __functionAddress = GL.getICD().glGetnPixelMapuiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(map, data.length, data, __functionAddress);
    }

    public static void glGetnPixelMapusv(@NativeType(value="GLenum") int map, @NativeType(value="GLushort *") short[] data) {
        long __functionAddress = GL.getICD().glGetnPixelMapusv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(map, data.length, data, __functionAddress);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") short[] img) {
        GL45C.glGetnTexImage(tex, level, format, type, img);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") int[] img) {
        GL45C.glGetnTexImage(tex, level, format, type, img);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") float[] img) {
        GL45C.glGetnTexImage(tex, level, format, type, img);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") double[] img) {
        GL45C.glGetnTexImage(tex, level, format, type, img);
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

    public static void glGetnColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") short[] table) {
        long __functionAddress = GL.getICD().glGetnColorTable;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, format, type, table.length << 1, table, __functionAddress);
    }

    public static void glGetnColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") int[] table) {
        long __functionAddress = GL.getICD().glGetnColorTable;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, format, type, table.length << 2, table, __functionAddress);
    }

    public static void glGetnColorTable(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") float[] table) {
        long __functionAddress = GL.getICD().glGetnColorTable;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, format, type, table.length << 2, table, __functionAddress);
    }

    public static void glGetnUniformfv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat *") float[] params) {
        GL45C.glGetnUniformfv(program, location, params);
    }

    public static void glGetnUniformdv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble *") double[] params) {
        GL45C.glGetnUniformdv(program, location, params);
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

