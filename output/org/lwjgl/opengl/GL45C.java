/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL44C;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL45C
extends GL44C {
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

    protected GL45C() {
        throw new UnsupportedOperationException();
    }

    public static native void glClipControl(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1);

    public static native void nglCreateTransformFeedbacks(int var0, long var1);

    public static void glCreateTransformFeedbacks(@NativeType(value="GLuint *") IntBuffer ids) {
        GL45C.nglCreateTransformFeedbacks(ids.remaining(), MemoryUtil.memAddress(ids));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glCreateTransformFeedbacks() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer ids = stack.callocInt(1);
            GL45C.nglCreateTransformFeedbacks(1, MemoryUtil.memAddress(ids));
            int n = ids.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glTransformFeedbackBufferBase(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    public static native void glTransformFeedbackBufferRange(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLintptr") long var3, @NativeType(value="GLsizeiptr") long var5);

    public static native void nglGetTransformFeedbackiv(int var0, int var1, long var2);

    public static void glGetTransformFeedbackiv(@NativeType(value="GLuint") int xfb, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer param) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param, 1);
        }
        GL45C.nglGetTransformFeedbackiv(xfb, pname, MemoryUtil.memAddress(param));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTransformFeedbacki(@NativeType(value="GLuint") int xfb, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer param = stack.callocInt(1);
            GL45C.nglGetTransformFeedbackiv(xfb, pname, MemoryUtil.memAddress(param));
            int n = param.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetTransformFeedbacki_v(int var0, int var1, int var2, long var3);

    public static void glGetTransformFeedbacki_v(@NativeType(value="GLuint") int xfb, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") IntBuffer param) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param, 1);
        }
        GL45C.nglGetTransformFeedbacki_v(xfb, pname, index, MemoryUtil.memAddress(param));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTransformFeedbacki(@NativeType(value="GLuint") int xfb, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer param = stack.callocInt(1);
            GL45C.nglGetTransformFeedbacki_v(xfb, pname, index, MemoryUtil.memAddress(param));
            int n = param.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetTransformFeedbacki64_v(int var0, int var1, int var2, long var3);

    public static void glGetTransformFeedbacki64_v(@NativeType(value="GLuint") int xfb, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index, @NativeType(value="GLint64 *") LongBuffer param) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param, 1);
        }
        GL45C.nglGetTransformFeedbacki64_v(xfb, pname, index, MemoryUtil.memAddress(param));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetTransformFeedbacki64(@NativeType(value="GLuint") int xfb, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer param = stack.callocLong(1);
            GL45C.nglGetTransformFeedbacki64_v(xfb, pname, index, MemoryUtil.memAddress(param));
            long l = param.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglCreateBuffers(int var0, long var1);

    public static void glCreateBuffers(@NativeType(value="GLuint *") IntBuffer buffers) {
        GL45C.nglCreateBuffers(buffers.remaining(), MemoryUtil.memAddress(buffers));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glCreateBuffers() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer buffers = stack.callocInt(1);
            GL45C.nglCreateBuffers(1, MemoryUtil.memAddress(buffers));
            int n = buffers.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglNamedBufferStorage(int var0, long var1, long var3, int var5);

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int buffer, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLbitfield") int flags) {
        GL45C.nglNamedBufferStorage(buffer, size, 0L, flags);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") ByteBuffer data, @NativeType(value="GLbitfield") int flags) {
        GL45C.nglNamedBufferStorage(buffer, data.remaining(), MemoryUtil.memAddress(data), flags);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") ShortBuffer data, @NativeType(value="GLbitfield") int flags) {
        GL45C.nglNamedBufferStorage(buffer, Integer.toUnsignedLong(data.remaining()) << 1, MemoryUtil.memAddress(data), flags);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") IntBuffer data, @NativeType(value="GLbitfield") int flags) {
        GL45C.nglNamedBufferStorage(buffer, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data), flags);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") FloatBuffer data, @NativeType(value="GLbitfield") int flags) {
        GL45C.nglNamedBufferStorage(buffer, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data), flags);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") DoubleBuffer data, @NativeType(value="GLbitfield") int flags) {
        GL45C.nglNamedBufferStorage(buffer, Integer.toUnsignedLong(data.remaining()) << 3, MemoryUtil.memAddress(data), flags);
    }

    public static native void nglNamedBufferData(int var0, long var1, long var3, int var5);

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int usage) {
        GL45C.nglNamedBufferData(buffer, size, 0L, usage);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") ByteBuffer data, @NativeType(value="GLenum") int usage) {
        GL45C.nglNamedBufferData(buffer, data.remaining(), MemoryUtil.memAddress(data), usage);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") ShortBuffer data, @NativeType(value="GLenum") int usage) {
        GL45C.nglNamedBufferData(buffer, Integer.toUnsignedLong(data.remaining()) << 1, MemoryUtil.memAddress(data), usage);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") IntBuffer data, @NativeType(value="GLenum") int usage) {
        GL45C.nglNamedBufferData(buffer, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data), usage);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") LongBuffer data, @NativeType(value="GLenum") int usage) {
        GL45C.nglNamedBufferData(buffer, Integer.toUnsignedLong(data.remaining()) << 3, MemoryUtil.memAddress(data), usage);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") FloatBuffer data, @NativeType(value="GLenum") int usage) {
        GL45C.nglNamedBufferData(buffer, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data), usage);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") DoubleBuffer data, @NativeType(value="GLenum") int usage) {
        GL45C.nglNamedBufferData(buffer, Integer.toUnsignedLong(data.remaining()) << 3, MemoryUtil.memAddress(data), usage);
    }

    public static native void nglNamedBufferSubData(int var0, long var1, long var3, long var5);

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") ByteBuffer data) {
        GL45C.nglNamedBufferSubData(buffer, offset, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") ShortBuffer data) {
        GL45C.nglNamedBufferSubData(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 1, MemoryUtil.memAddress(data));
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") IntBuffer data) {
        GL45C.nglNamedBufferSubData(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data));
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") LongBuffer data) {
        GL45C.nglNamedBufferSubData(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 3, MemoryUtil.memAddress(data));
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") FloatBuffer data) {
        GL45C.nglNamedBufferSubData(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data));
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") DoubleBuffer data) {
        GL45C.nglNamedBufferSubData(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 3, MemoryUtil.memAddress(data));
    }

    public static native void glCopyNamedBufferSubData(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLintptr") long var2, @NativeType(value="GLintptr") long var4, @NativeType(value="GLsizeiptr") long var6);

    public static native void nglClearNamedBufferData(int var0, int var1, int var2, int var3, long var4);

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ByteBuffer data) {
        GL45C.nglClearNamedBufferData(buffer, internalformat, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ShortBuffer data) {
        GL45C.nglClearNamedBufferData(buffer, internalformat, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") IntBuffer data) {
        GL45C.nglClearNamedBufferData(buffer, internalformat, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") FloatBuffer data) {
        GL45C.nglClearNamedBufferData(buffer, internalformat, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static native void nglClearNamedBufferSubData(int var0, int var1, long var2, long var4, int var6, int var7, long var8);

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ByteBuffer data) {
        GL45C.nglClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ShortBuffer data) {
        GL45C.nglClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") IntBuffer data) {
        GL45C.nglClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") FloatBuffer data) {
        GL45C.nglClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static native long nglMapNamedBuffer(int var0, int var1);

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBuffer(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int access) {
        long __result = GL45C.nglMapNamedBuffer(buffer, access);
        return MemoryUtil.memByteBufferSafe(__result, GL45C.glGetNamedBufferParameteri(buffer, 34660));
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBuffer(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int access, @Nullable ByteBuffer old_buffer) {
        long __result = GL45C.nglMapNamedBuffer(buffer, access);
        int length = GL45C.glGetNamedBufferParameteri(buffer, 34660);
        return APIUtil.apiGetMappedBuffer(old_buffer, __result, length);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBuffer(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int access, long length, @Nullable ByteBuffer old_buffer) {
        long __result = GL45C.nglMapNamedBuffer(buffer, access);
        return APIUtil.apiGetMappedBuffer(old_buffer, __result, (int)length);
    }

    public static native long nglMapNamedBufferRange(int var0, long var1, long var3, int var5);

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBufferRange(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long length, @NativeType(value="GLbitfield") int access) {
        long __result = GL45C.nglMapNamedBufferRange(buffer, offset, length, access);
        return MemoryUtil.memByteBufferSafe(__result, (int)length);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBufferRange(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long length, @NativeType(value="GLbitfield") int access, @Nullable ByteBuffer old_buffer) {
        long __result = GL45C.nglMapNamedBufferRange(buffer, offset, length, access);
        return APIUtil.apiGetMappedBuffer(old_buffer, __result, (int)length);
    }

    @NativeType(value="GLboolean")
    public static native boolean glUnmapNamedBuffer(@NativeType(value="GLuint") int var0);

    public static native void glFlushMappedNamedBufferRange(@NativeType(value="GLuint") int var0, @NativeType(value="GLintptr") long var1, @NativeType(value="GLsizeiptr") long var3);

    public static native void nglGetNamedBufferParameteriv(int var0, int var1, long var2);

    public static void glGetNamedBufferParameteriv(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL45C.nglGetNamedBufferParameteriv(buffer, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetNamedBufferParameteri(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL45C.nglGetNamedBufferParameteriv(buffer, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetNamedBufferParameteri64v(int var0, int var1, long var2);

    public static void glGetNamedBufferParameteri64v(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") LongBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL45C.nglGetNamedBufferParameteri64v(buffer, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetNamedBufferParameteri64(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer params = stack.callocLong(1);
            GL45C.nglGetNamedBufferParameteri64v(buffer, pname, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetNamedBufferPointerv(int var0, int var1, long var2);

    public static void glGetNamedBufferPointerv(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname, @NativeType(value="void **") PointerBuffer params) {
        if (Checks.CHECKS) {
            Checks.check(params, 1);
        }
        GL45C.nglGetNamedBufferPointerv(buffer, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetNamedBufferPointer(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            PointerBuffer params = stack.callocPointer(1);
            GL45C.nglGetNamedBufferPointerv(buffer, pname, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetNamedBufferSubData(int var0, long var1, long var3, long var5);

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") ByteBuffer data) {
        GL45C.nglGetNamedBufferSubData(buffer, offset, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") ShortBuffer data) {
        GL45C.nglGetNamedBufferSubData(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 1, MemoryUtil.memAddress(data));
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") IntBuffer data) {
        GL45C.nglGetNamedBufferSubData(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data));
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") LongBuffer data) {
        GL45C.nglGetNamedBufferSubData(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 3, MemoryUtil.memAddress(data));
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") FloatBuffer data) {
        GL45C.nglGetNamedBufferSubData(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data));
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") DoubleBuffer data) {
        GL45C.nglGetNamedBufferSubData(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 3, MemoryUtil.memAddress(data));
    }

    public static native void nglCreateFramebuffers(int var0, long var1);

    public static void glCreateFramebuffers(@NativeType(value="GLuint *") IntBuffer framebuffers) {
        GL45C.nglCreateFramebuffers(framebuffers.remaining(), MemoryUtil.memAddress(framebuffers));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glCreateFramebuffers() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer framebuffers = stack.callocInt(1);
            GL45C.nglCreateFramebuffers(1, MemoryUtil.memAddress(framebuffers));
            int n = framebuffers.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glNamedFramebufferRenderbuffer(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLuint") int var3);

    public static native void glNamedFramebufferParameteri(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2);

    public static native void glNamedFramebufferTexture(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLint") int var3);

    public static native void glNamedFramebufferTextureLayer(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4);

    public static native void glNamedFramebufferDrawBuffer(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void nglNamedFramebufferDrawBuffers(int var0, int var1, long var2);

    public static void glNamedFramebufferDrawBuffers(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum const *") IntBuffer bufs) {
        GL45C.nglNamedFramebufferDrawBuffers(framebuffer, bufs.remaining(), MemoryUtil.memAddress(bufs));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glNamedFramebufferDrawBuffers(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum const *") int buf) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer bufs = stack.ints(buf);
            GL45C.nglNamedFramebufferDrawBuffers(framebuffer, 1, MemoryUtil.memAddress(bufs));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glNamedFramebufferReadBuffer(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void nglInvalidateNamedFramebufferData(int var0, int var1, long var2);

    public static void glInvalidateNamedFramebufferData(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum const *") IntBuffer attachments) {
        GL45C.nglInvalidateNamedFramebufferData(framebuffer, attachments.remaining(), MemoryUtil.memAddress(attachments));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glInvalidateNamedFramebufferData(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum const *") int attachment) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer attachments = stack.ints(attachment);
            GL45C.nglInvalidateNamedFramebufferData(framebuffer, 1, MemoryUtil.memAddress(attachments));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglInvalidateNamedFramebufferSubData(int var0, int var1, long var2, int var4, int var5, int var6, int var7);

    public static void glInvalidateNamedFramebufferSubData(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum const *") IntBuffer attachments, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height) {
        GL45C.nglInvalidateNamedFramebufferSubData(framebuffer, attachments.remaining(), MemoryUtil.memAddress(attachments), x, y, width, height);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glInvalidateNamedFramebufferSubData(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum const *") int attachment, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer attachments = stack.ints(attachment);
            GL45C.nglInvalidateNamedFramebufferSubData(framebuffer, 1, MemoryUtil.memAddress(attachments), x, y, width, height);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglClearNamedFramebufferiv(int var0, int var1, int var2, long var3);

    public static void glClearNamedFramebufferiv(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLint *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        GL45C.nglClearNamedFramebufferiv(framebuffer, buffer, drawbuffer, MemoryUtil.memAddress(value));
    }

    public static native void nglClearNamedFramebufferuiv(int var0, int var1, int var2, long var3);

    public static void glClearNamedFramebufferuiv(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLint *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 4);
        }
        GL45C.nglClearNamedFramebufferuiv(framebuffer, buffer, drawbuffer, MemoryUtil.memAddress(value));
    }

    public static native void nglClearNamedFramebufferfv(int var0, int var1, int var2, long var3);

    public static void glClearNamedFramebufferfv(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLfloat *") FloatBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        GL45C.nglClearNamedFramebufferfv(framebuffer, buffer, drawbuffer, MemoryUtil.memAddress(value));
    }

    public static native void glClearNamedFramebufferfi(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLint") int var4);

    public static native void glBlitNamedFramebuffer(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLint") int var6, @NativeType(value="GLint") int var7, @NativeType(value="GLint") int var8, @NativeType(value="GLint") int var9, @NativeType(value="GLbitfield") int var10, @NativeType(value="GLenum") int var11);

    @NativeType(value="GLenum")
    public static native int glCheckNamedFramebufferStatus(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void nglGetNamedFramebufferParameteriv(int var0, int var1, long var2);

    public static void glGetNamedFramebufferParameteriv(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL45C.nglGetNamedFramebufferParameteriv(framebuffer, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetNamedFramebufferParameteri(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL45C.nglGetNamedFramebufferParameteriv(framebuffer, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetNamedFramebufferAttachmentParameteriv(int var0, int var1, int var2, long var3);

    public static void glGetNamedFramebufferAttachmentParameteriv(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int attachment, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL45C.nglGetNamedFramebufferAttachmentParameteriv(framebuffer, attachment, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetNamedFramebufferAttachmentParameteri(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int attachment, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL45C.nglGetNamedFramebufferAttachmentParameteriv(framebuffer, attachment, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglCreateRenderbuffers(int var0, long var1);

    public static void glCreateRenderbuffers(@NativeType(value="GLuint *") IntBuffer renderbuffers) {
        GL45C.nglCreateRenderbuffers(renderbuffers.remaining(), MemoryUtil.memAddress(renderbuffers));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glCreateRenderbuffers() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer renderbuffers = stack.callocInt(1);
            GL45C.nglCreateRenderbuffers(1, MemoryUtil.memAddress(renderbuffers));
            int n = renderbuffers.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glNamedRenderbufferStorage(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLsizei") int var2, @NativeType(value="GLsizei") int var3);

    public static native void glNamedRenderbufferStorageMultisample(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4);

    public static native void nglGetNamedRenderbufferParameteriv(int var0, int var1, long var2);

    public static void glGetNamedRenderbufferParameteriv(@NativeType(value="GLuint") int renderbuffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL45C.nglGetNamedRenderbufferParameteriv(renderbuffer, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetNamedRenderbufferParameteri(@NativeType(value="GLuint") int renderbuffer, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL45C.nglGetNamedRenderbufferParameteriv(renderbuffer, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglCreateTextures(int var0, int var1, long var2);

    public static void glCreateTextures(@NativeType(value="GLenum") int target, @NativeType(value="GLuint *") IntBuffer textures) {
        GL45C.nglCreateTextures(target, textures.remaining(), MemoryUtil.memAddress(textures));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glCreateTextures(@NativeType(value="GLenum") int target) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer textures = stack.callocInt(1);
            GL45C.nglCreateTextures(target, 1, MemoryUtil.memAddress(textures));
            int n = textures.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glTextureBuffer(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2);

    public static native void glTextureBufferRange(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLintptr") long var3, @NativeType(value="GLsizeiptr") long var5);

    public static native void glTextureStorage1D(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3);

    public static native void glTextureStorage2D(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4);

    public static native void glTextureStorage3D(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLsizei") int var5);

    public static native void glTextureStorage2DMultisample(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLboolean") boolean var5);

    public static native void glTextureStorage3DMultisample(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLsizei") int var5, @NativeType(value="GLboolean") boolean var6);

    public static native void nglTextureSubImage1D(int var0, int var1, int var2, int var3, int var4, int var5, long var6);

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer pixels) {
        GL45C.nglTextureSubImage1D(texture, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long pixels) {
        GL45C.nglTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ShortBuffer pixels) {
        GL45C.nglTextureSubImage1D(texture, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer pixels) {
        GL45C.nglTextureSubImage1D(texture, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") FloatBuffer pixels) {
        GL45C.nglTextureSubImage1D(texture, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") DoubleBuffer pixels) {
        GL45C.nglTextureSubImage1D(texture, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
    }

    public static native void nglTextureSubImage2D(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, long var8);

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer pixels) {
        GL45C.nglTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long pixels) {
        GL45C.nglTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ShortBuffer pixels) {
        GL45C.nglTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer pixels) {
        GL45C.nglTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") FloatBuffer pixels) {
        GL45C.nglTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") DoubleBuffer pixels) {
        GL45C.nglTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
    }

    public static native void nglTextureSubImage3D(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, long var10);

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer pixels) {
        GL45C.nglTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long pixels) {
        GL45C.nglTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ShortBuffer pixels) {
        GL45C.nglTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer pixels) {
        GL45C.nglTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") FloatBuffer pixels) {
        GL45C.nglTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") DoubleBuffer pixels) {
        GL45C.nglTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
    }

    public static native void nglCompressedTextureSubImage1D(int var0, int var1, int var2, int var3, int var4, int var5, long var6);

    public static void glCompressedTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int imageSize, @NativeType(value="void const *") long data) {
        GL45C.nglCompressedTextureSubImage1D(texture, level, xoffset, width, format, imageSize, data);
    }

    public static void glCompressedTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="void const *") ByteBuffer data) {
        GL45C.nglCompressedTextureSubImage1D(texture, level, xoffset, width, format, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static native void nglCompressedTextureSubImage2D(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, long var8);

    public static void glCompressedTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int imageSize, @NativeType(value="void const *") long data) {
        GL45C.nglCompressedTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, imageSize, data);
    }

    public static void glCompressedTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="void const *") ByteBuffer data) {
        GL45C.nglCompressedTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static native void nglCompressedTextureSubImage3D(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, long var10);

    public static void glCompressedTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int imageSize, @NativeType(value="void const *") long data) {
        GL45C.nglCompressedTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
    }

    public static void glCompressedTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="void const *") ByteBuffer data) {
        GL45C.nglCompressedTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static native void glCopyTextureSubImage1D(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLsizei") int var5);

    public static native void glCopyTextureSubImage2D(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLsizei") int var6, @NativeType(value="GLsizei") int var7);

    public static native void glCopyTextureSubImage3D(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLint") int var6, @NativeType(value="GLsizei") int var7, @NativeType(value="GLsizei") int var8);

    public static native void glTextureParameterf(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLfloat") float var2);

    public static native void nglTextureParameterfv(int var0, int var1, long var2);

    public static void glTextureParameterfv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        GL45C.nglTextureParameterfv(texture, pname, MemoryUtil.memAddress(params));
    }

    public static native void glTextureParameteri(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2);

    public static native void nglTextureParameterIiv(int var0, int var1, long var2);

    public static void glTextureParameterIiv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL45C.nglTextureParameterIiv(texture, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glTextureParameterIi(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int param) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.ints(param);
            GL45C.nglTextureParameterIiv(texture, pname, MemoryUtil.memAddress(params));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglTextureParameterIuiv(int var0, int var1, long var2);

    public static void glTextureParameterIuiv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL45C.nglTextureParameterIuiv(texture, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glTextureParameterIui(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint const *") int param) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.ints(param);
            GL45C.nglTextureParameterIuiv(texture, pname, MemoryUtil.memAddress(params));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglTextureParameteriv(int var0, int var1, long var2);

    public static void glTextureParameteriv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        GL45C.nglTextureParameteriv(texture, pname, MemoryUtil.memAddress(params));
    }

    public static native void glGenerateTextureMipmap(@NativeType(value="GLuint") int var0);

    public static native void glBindTextureUnit(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglGetTextureImage(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glGetTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long pixels) {
        GL45C.nglGetTextureImage(texture, level, format, type, bufSize, pixels);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer pixels) {
        GL45C.nglGetTextureImage(texture, level, format, type, pixels.remaining(), MemoryUtil.memAddress(pixels));
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ShortBuffer pixels) {
        GL45C.nglGetTextureImage(texture, level, format, type, pixels.remaining() << 1, MemoryUtil.memAddress(pixels));
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") IntBuffer pixels) {
        GL45C.nglGetTextureImage(texture, level, format, type, pixels.remaining() << 2, MemoryUtil.memAddress(pixels));
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") FloatBuffer pixels) {
        GL45C.nglGetTextureImage(texture, level, format, type, pixels.remaining() << 2, MemoryUtil.memAddress(pixels));
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") DoubleBuffer pixels) {
        GL45C.nglGetTextureImage(texture, level, format, type, pixels.remaining() << 3, MemoryUtil.memAddress(pixels));
    }

    public static native void nglGetCompressedTextureImage(int var0, int var1, int var2, long var3);

    public static void glGetCompressedTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long pixels) {
        GL45C.nglGetCompressedTextureImage(texture, level, bufSize, pixels);
    }

    public static void glGetCompressedTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="void *") ByteBuffer pixels) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)pixels, GL45C.glGetTextureLevelParameteri(texture, level, 34464));
        }
        GL45C.nglGetCompressedTextureImage(texture, level, pixels.remaining(), MemoryUtil.memAddress(pixels));
    }

    public static native void nglGetTextureLevelParameterfv(int var0, int var1, int var2, long var3);

    public static void glGetTextureLevelParameterfv(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL45C.nglGetTextureLevelParameterfv(texture, level, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetTextureLevelParameterf(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer params = stack.callocFloat(1);
            GL45C.nglGetTextureLevelParameterfv(texture, level, pname, MemoryUtil.memAddress(params));
            float f = params.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetTextureLevelParameteriv(int var0, int var1, int var2, long var3);

    public static void glGetTextureLevelParameteriv(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL45C.nglGetTextureLevelParameteriv(texture, level, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTextureLevelParameteri(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL45C.nglGetTextureLevelParameteriv(texture, level, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetTextureParameterfv(int var0, int var1, long var2);

    public static void glGetTextureParameterfv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL45C.nglGetTextureParameterfv(texture, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetTextureParameterf(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer params = stack.callocFloat(1);
            GL45C.nglGetTextureParameterfv(texture, pname, MemoryUtil.memAddress(params));
            float f = params.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetTextureParameterIiv(int var0, int var1, long var2);

    public static void glGetTextureParameterIiv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL45C.nglGetTextureParameterIiv(texture, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTextureParameterIi(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL45C.nglGetTextureParameterIiv(texture, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetTextureParameterIuiv(int var0, int var1, long var2);

    public static void glGetTextureParameterIuiv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL45C.nglGetTextureParameterIuiv(texture, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTextureParameterIui(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL45C.nglGetTextureParameterIuiv(texture, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetTextureParameteriv(int var0, int var1, long var2);

    public static void glGetTextureParameteriv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL45C.nglGetTextureParameteriv(texture, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTextureParameteri(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL45C.nglGetTextureParameteriv(texture, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglCreateVertexArrays(int var0, long var1);

    public static void glCreateVertexArrays(@NativeType(value="GLuint *") IntBuffer arrays) {
        GL45C.nglCreateVertexArrays(arrays.remaining(), MemoryUtil.memAddress(arrays));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glCreateVertexArrays() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer arrays = stack.callocInt(1);
            GL45C.nglCreateVertexArrays(1, MemoryUtil.memAddress(arrays));
            int n = arrays.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glDisableVertexArrayAttrib(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void glEnableVertexArrayAttrib(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void glVertexArrayElementBuffer(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void glVertexArrayVertexBuffer(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLintptr") long var3, @NativeType(value="GLsizei") int var5);

    public static native void nglVertexArrayVertexBuffers(int var0, int var1, int var2, long var3, long var5, long var7);

    public static void glVertexArrayVertexBuffers(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") IntBuffer buffers, @Nullable @NativeType(value="GLintptr const *") PointerBuffer offsets, @Nullable @NativeType(value="GLsizei const *") IntBuffer strides) {
        if (Checks.CHECKS) {
            Checks.checkSafe(offsets, Checks.remainingSafe(buffers));
            Checks.checkSafe((Buffer)strides, Checks.remainingSafe(buffers));
        }
        GL45C.nglVertexArrayVertexBuffers(vaobj, first, Checks.remainingSafe(buffers), MemoryUtil.memAddressSafe(buffers), MemoryUtil.memAddressSafe(offsets), MemoryUtil.memAddressSafe(strides));
    }

    public static native void glVertexArrayAttribFormat(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLboolean") boolean var4, @NativeType(value="GLuint") int var5);

    public static native void glVertexArrayAttribIFormat(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLuint") int var4);

    public static native void glVertexArrayAttribLFormat(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLuint") int var4);

    public static native void glVertexArrayAttribBinding(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    public static native void glVertexArrayBindingDivisor(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    public static native void nglGetVertexArrayiv(int var0, int var1, long var2);

    public static void glGetVertexArrayiv(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer param) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param, 1);
        }
        GL45C.nglGetVertexArrayiv(vaobj, pname, MemoryUtil.memAddress(param));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetVertexArrayi(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer param = stack.callocInt(1);
            GL45C.nglGetVertexArrayiv(vaobj, pname, MemoryUtil.memAddress(param));
            int n = param.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetVertexArrayIndexediv(int var0, int var1, int var2, long var3);

    public static void glGetVertexArrayIndexediv(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer param) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param, 1);
        }
        GL45C.nglGetVertexArrayIndexediv(vaobj, index, pname, MemoryUtil.memAddress(param));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetVertexArrayIndexedi(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer param = stack.callocInt(1);
            GL45C.nglGetVertexArrayIndexediv(vaobj, index, pname, MemoryUtil.memAddress(param));
            int n = param.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetVertexArrayIndexed64iv(int var0, int var1, int var2, long var3);

    public static void glGetVertexArrayIndexed64iv(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") LongBuffer param) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param, 1);
        }
        GL45C.nglGetVertexArrayIndexed64iv(vaobj, index, pname, MemoryUtil.memAddress(param));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetVertexArrayIndexed64i(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer param = stack.callocLong(1);
            GL45C.nglGetVertexArrayIndexed64iv(vaobj, index, pname, MemoryUtil.memAddress(param));
            long l = param.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglCreateSamplers(int var0, long var1);

    public static void glCreateSamplers(@NativeType(value="GLuint *") IntBuffer samplers) {
        GL45C.nglCreateSamplers(samplers.remaining(), MemoryUtil.memAddress(samplers));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glCreateSamplers() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer samplers = stack.callocInt(1);
            GL45C.nglCreateSamplers(1, MemoryUtil.memAddress(samplers));
            int n = samplers.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglCreateProgramPipelines(int var0, long var1);

    public static void glCreateProgramPipelines(@NativeType(value="GLuint *") IntBuffer pipelines) {
        GL45C.nglCreateProgramPipelines(pipelines.remaining(), MemoryUtil.memAddress(pipelines));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glCreateProgramPipelines() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer pipelines = stack.callocInt(1);
            GL45C.nglCreateProgramPipelines(1, MemoryUtil.memAddress(pipelines));
            int n = pipelines.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglCreateQueries(int var0, int var1, long var2);

    public static void glCreateQueries(@NativeType(value="GLenum") int target, @NativeType(value="GLuint *") IntBuffer ids) {
        GL45C.nglCreateQueries(target, ids.remaining(), MemoryUtil.memAddress(ids));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glCreateQueries(@NativeType(value="GLenum") int target) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer ids = stack.callocInt(1);
            GL45C.nglCreateQueries(target, 1, MemoryUtil.memAddress(ids));
            int n = ids.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glGetQueryBufferObjectiv(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLintptr") long var3);

    public static native void glGetQueryBufferObjectuiv(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLintptr") long var3);

    public static native void glGetQueryBufferObjecti64v(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLintptr") long var3);

    public static native void glGetQueryBufferObjectui64v(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLintptr") long var3);

    public static native void glMemoryBarrierByRegion(@NativeType(value="GLbitfield") int var0);

    public static native void nglGetTextureSubImage(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, long var11);

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long pixels) {
        GL45C.nglGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, bufSize, pixels);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer pixels) {
        GL45C.nglGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels.remaining(), MemoryUtil.memAddress(pixels));
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ShortBuffer pixels) {
        GL45C.nglGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels.remaining() << 1, MemoryUtil.memAddress(pixels));
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") IntBuffer pixels) {
        GL45C.nglGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels.remaining() << 2, MemoryUtil.memAddress(pixels));
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") FloatBuffer pixels) {
        GL45C.nglGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels.remaining() << 2, MemoryUtil.memAddress(pixels));
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") DoubleBuffer pixels) {
        GL45C.nglGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels.remaining() << 3, MemoryUtil.memAddress(pixels));
    }

    public static native void nglGetCompressedTextureSubImage(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9);

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long pixels) {
        GL45C.nglGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, bufSize, pixels);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") ByteBuffer pixels) {
        GL45C.nglGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels.remaining(), MemoryUtil.memAddress(pixels));
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") ShortBuffer pixels) {
        GL45C.nglGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels.remaining() << 1, MemoryUtil.memAddress(pixels));
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") IntBuffer pixels) {
        GL45C.nglGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels.remaining() << 2, MemoryUtil.memAddress(pixels));
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") FloatBuffer pixels) {
        GL45C.nglGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels.remaining() << 2, MemoryUtil.memAddress(pixels));
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") DoubleBuffer pixels) {
        GL45C.nglGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels.remaining() << 3, MemoryUtil.memAddress(pixels));
    }

    public static native void glTextureBarrier();

    @NativeType(value="GLenum")
    public static native int glGetGraphicsResetStatus();

    public static native void nglGetnTexImage(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glGetnTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long img) {
        GL45C.nglGetnTexImage(tex, level, format, type, bufSize, img);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer img) {
        GL45C.nglGetnTexImage(tex, level, format, type, img.remaining(), MemoryUtil.memAddress(img));
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ShortBuffer img) {
        GL45C.nglGetnTexImage(tex, level, format, type, img.remaining() << 1, MemoryUtil.memAddress(img));
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") IntBuffer img) {
        GL45C.nglGetnTexImage(tex, level, format, type, img.remaining() << 2, MemoryUtil.memAddress(img));
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") FloatBuffer img) {
        GL45C.nglGetnTexImage(tex, level, format, type, img.remaining() << 2, MemoryUtil.memAddress(img));
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") DoubleBuffer img) {
        GL45C.nglGetnTexImage(tex, level, format, type, img.remaining() << 3, MemoryUtil.memAddress(img));
    }

    public static native void nglReadnPixels(int var0, int var1, int var2, int var3, int var4, int var5, int var6, long var7);

    public static void glReadnPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long pixels) {
        GL45C.nglReadnPixels(x, y, width, height, format, type, bufSize, pixels);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer pixels) {
        GL45C.nglReadnPixels(x, y, width, height, format, type, pixels.remaining(), MemoryUtil.memAddress(pixels));
    }

    public static void glReadnPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ShortBuffer pixels) {
        GL45C.nglReadnPixels(x, y, width, height, format, type, pixels.remaining() << 1, MemoryUtil.memAddress(pixels));
    }

    public static void glReadnPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") IntBuffer pixels) {
        GL45C.nglReadnPixels(x, y, width, height, format, type, pixels.remaining() << 2, MemoryUtil.memAddress(pixels));
    }

    public static void glReadnPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") FloatBuffer pixels) {
        GL45C.nglReadnPixels(x, y, width, height, format, type, pixels.remaining() << 2, MemoryUtil.memAddress(pixels));
    }

    public static native void nglGetnCompressedTexImage(int var0, int var1, int var2, long var3);

    public static void glGetnCompressedTexImage(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLsizei") int bufSize, @NativeType(value="void *") long img) {
        GL45C.nglGetnCompressedTexImage(target, level, bufSize, img);
    }

    public static void glGetnCompressedTexImage(@NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="void *") ByteBuffer img) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)img, GL11.glGetTexLevelParameteri(target, level, 34464));
        }
        GL45C.nglGetnCompressedTexImage(target, level, img.remaining(), MemoryUtil.memAddress(img));
    }

    public static native void nglGetnUniformfv(int var0, int var1, int var2, long var3);

    public static void glGetnUniformfv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat *") FloatBuffer params) {
        GL45C.nglGetnUniformfv(program, location, params.remaining(), MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetnUniformf(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer params = stack.callocFloat(1);
            GL45C.nglGetnUniformfv(program, location, 1, MemoryUtil.memAddress(params));
            float f = params.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetnUniformdv(int var0, int var1, int var2, long var3);

    public static void glGetnUniformdv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble *") DoubleBuffer params) {
        GL45C.nglGetnUniformdv(program, location, params.remaining(), MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static double glGetnUniformd(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            DoubleBuffer params = stack.callocDouble(1);
            GL45C.nglGetnUniformdv(program, location, 1, MemoryUtil.memAddress(params));
            double d = params.get(0);
            return d;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetnUniformiv(int var0, int var1, int var2, long var3);

    public static void glGetnUniformiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint *") IntBuffer params) {
        GL45C.nglGetnUniformiv(program, location, params.remaining(), MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetnUniformi(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL45C.nglGetnUniformiv(program, location, 1, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetnUniformuiv(int var0, int var1, int var2, long var3);

    public static void glGetnUniformuiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint *") IntBuffer params) {
        GL45C.nglGetnUniformuiv(program, location, params.remaining(), MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetnUniformui(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL45C.nglGetnUniformuiv(program, location, 1, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glCreateTransformFeedbacks(@NativeType(value="GLuint *") int[] ids) {
        long __functionAddress = GL.getICD().glCreateTransformFeedbacks;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(ids.length, ids, __functionAddress);
    }

    public static void glGetTransformFeedbackiv(@NativeType(value="GLuint") int xfb, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] param) {
        long __functionAddress = GL.getICD().glGetTransformFeedbackiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(param, 1);
        }
        JNI.callPV(xfb, pname, param, __functionAddress);
    }

    public static void glGetTransformFeedbacki_v(@NativeType(value="GLuint") int xfb, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") int[] param) {
        long __functionAddress = GL.getICD().glGetTransformFeedbacki_v;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(param, 1);
        }
        JNI.callPV(xfb, pname, index, param, __functionAddress);
    }

    public static void glGetTransformFeedbacki64_v(@NativeType(value="GLuint") int xfb, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index, @NativeType(value="GLint64 *") long[] param) {
        long __functionAddress = GL.getICD().glGetTransformFeedbacki64_v;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(param, 1);
        }
        JNI.callPV(xfb, pname, index, param, __functionAddress);
    }

    public static void glCreateBuffers(@NativeType(value="GLuint *") int[] buffers) {
        long __functionAddress = GL.getICD().glCreateBuffers;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(buffers.length, buffers, __functionAddress);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") short[] data, @NativeType(value="GLbitfield") int flags) {
        long __functionAddress = GL.getICD().glNamedBufferStorage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 1, data, flags, __functionAddress);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") int[] data, @NativeType(value="GLbitfield") int flags) {
        long __functionAddress = GL.getICD().glNamedBufferStorage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 2, data, flags, __functionAddress);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") float[] data, @NativeType(value="GLbitfield") int flags) {
        long __functionAddress = GL.getICD().glNamedBufferStorage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 2, data, flags, __functionAddress);
    }

    public static void glNamedBufferStorage(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") double[] data, @NativeType(value="GLbitfield") int flags) {
        long __functionAddress = GL.getICD().glNamedBufferStorage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 3, data, flags, __functionAddress);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") short[] data, @NativeType(value="GLenum") int usage) {
        long __functionAddress = GL.getICD().glNamedBufferData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 1, data, usage, __functionAddress);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") int[] data, @NativeType(value="GLenum") int usage) {
        long __functionAddress = GL.getICD().glNamedBufferData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 2, data, usage, __functionAddress);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") long[] data, @NativeType(value="GLenum") int usage) {
        long __functionAddress = GL.getICD().glNamedBufferData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 3, data, usage, __functionAddress);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") float[] data, @NativeType(value="GLenum") int usage) {
        long __functionAddress = GL.getICD().glNamedBufferData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 2, data, usage, __functionAddress);
    }

    public static void glNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") double[] data, @NativeType(value="GLenum") int usage) {
        long __functionAddress = GL.getICD().glNamedBufferData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 3, data, usage, __functionAddress);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") short[] data) {
        long __functionAddress = GL.getICD().glNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 1, data, __functionAddress);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") int[] data) {
        long __functionAddress = GL.getICD().glNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 2, data, __functionAddress);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") long[] data) {
        long __functionAddress = GL.getICD().glNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 3, data, __functionAddress);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") float[] data) {
        long __functionAddress = GL.getICD().glNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 2, data, __functionAddress);
    }

    public static void glNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") double[] data) {
        long __functionAddress = GL.getICD().glNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 3, data, __functionAddress);
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") short[] data) {
        long __functionAddress = GL.getICD().glClearNamedBufferData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(buffer, internalformat, format, type, data, __functionAddress);
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") int[] data) {
        long __functionAddress = GL.getICD().glClearNamedBufferData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(buffer, internalformat, format, type, data, __functionAddress);
    }

    public static void glClearNamedBufferData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") float[] data) {
        long __functionAddress = GL.getICD().glClearNamedBufferData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(buffer, internalformat, format, type, data, __functionAddress);
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") short[] data) {
        long __functionAddress = GL.getICD().glClearNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, internalformat, offset, size, format, type, data, __functionAddress);
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") int[] data) {
        long __functionAddress = GL.getICD().glClearNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, internalformat, offset, size, format, type, data, __functionAddress);
    }

    public static void glClearNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") float[] data) {
        long __functionAddress = GL.getICD().glClearNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, internalformat, offset, size, format, type, data, __functionAddress);
    }

    public static void glGetNamedBufferParameteriv(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetNamedBufferParameteriv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(buffer, pname, params, __functionAddress);
    }

    public static void glGetNamedBufferParameteri64v(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") long[] params) {
        long __functionAddress = GL.getICD().glGetNamedBufferParameteri64v;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(buffer, pname, params, __functionAddress);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") short[] data) {
        long __functionAddress = GL.getICD().glGetNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 1, data, __functionAddress);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") int[] data) {
        long __functionAddress = GL.getICD().glGetNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 2, data, __functionAddress);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") long[] data) {
        long __functionAddress = GL.getICD().glGetNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 3, data, __functionAddress);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") float[] data) {
        long __functionAddress = GL.getICD().glGetNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 2, data, __functionAddress);
    }

    public static void glGetNamedBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") double[] data) {
        long __functionAddress = GL.getICD().glGetNamedBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 3, data, __functionAddress);
    }

    public static void glCreateFramebuffers(@NativeType(value="GLuint *") int[] framebuffers) {
        long __functionAddress = GL.getICD().glCreateFramebuffers;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(framebuffers.length, framebuffers, __functionAddress);
    }

    public static void glNamedFramebufferDrawBuffers(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum const *") int[] bufs) {
        long __functionAddress = GL.getICD().glNamedFramebufferDrawBuffers;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(framebuffer, bufs.length, bufs, __functionAddress);
    }

    public static void glInvalidateNamedFramebufferData(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum const *") int[] attachments) {
        long __functionAddress = GL.getICD().glInvalidateNamedFramebufferData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(framebuffer, attachments.length, attachments, __functionAddress);
    }

    public static void glInvalidateNamedFramebufferSubData(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum const *") int[] attachments, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height) {
        long __functionAddress = GL.getICD().glInvalidateNamedFramebufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(framebuffer, attachments.length, attachments, x, y, width, height, __functionAddress);
    }

    public static void glClearNamedFramebufferiv(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLint *") int[] value) {
        long __functionAddress = GL.getICD().glClearNamedFramebufferiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(value, 1);
        }
        JNI.callPV(framebuffer, buffer, drawbuffer, value, __functionAddress);
    }

    public static void glClearNamedFramebufferuiv(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLint *") int[] value) {
        long __functionAddress = GL.getICD().glClearNamedFramebufferuiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(value, 4);
        }
        JNI.callPV(framebuffer, buffer, drawbuffer, value, __functionAddress);
    }

    public static void glClearNamedFramebufferfv(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLfloat *") float[] value) {
        long __functionAddress = GL.getICD().glClearNamedFramebufferfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(value, 1);
        }
        JNI.callPV(framebuffer, buffer, drawbuffer, value, __functionAddress);
    }

    public static void glGetNamedFramebufferParameteriv(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetNamedFramebufferParameteriv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(framebuffer, pname, params, __functionAddress);
    }

    public static void glGetNamedFramebufferAttachmentParameteriv(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int attachment, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetNamedFramebufferAttachmentParameteriv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(framebuffer, attachment, pname, params, __functionAddress);
    }

    public static void glCreateRenderbuffers(@NativeType(value="GLuint *") int[] renderbuffers) {
        long __functionAddress = GL.getICD().glCreateRenderbuffers;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(renderbuffers.length, renderbuffers, __functionAddress);
    }

    public static void glGetNamedRenderbufferParameteriv(@NativeType(value="GLuint") int renderbuffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetNamedRenderbufferParameteriv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(renderbuffer, pname, params, __functionAddress);
    }

    public static void glCreateTextures(@NativeType(value="GLenum") int target, @NativeType(value="GLuint *") int[] textures) {
        long __functionAddress = GL.getICD().glCreateTextures;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, textures.length, textures, __functionAddress);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") short[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage1D;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, width, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage1D;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, width, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") float[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage1D;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, width, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage1D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") double[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage1D;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, width, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") short[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage2D;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage2D;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") float[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage2D;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage2D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") double[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage2D;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") short[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage3D;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage3D;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") float[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage3D;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage3D(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") double[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage3D;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
    }

    public static void glTextureParameterfv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] params) {
        long __functionAddress = GL.getICD().glTextureParameterfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(texture, pname, params, __functionAddress);
    }

    public static void glTextureParameterIiv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = GL.getICD().glTextureParameterIiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texture, pname, params, __functionAddress);
    }

    public static void glTextureParameterIuiv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint const *") int[] params) {
        long __functionAddress = GL.getICD().glTextureParameterIuiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texture, pname, params, __functionAddress);
    }

    public static void glTextureParameteriv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = GL.getICD().glTextureParameteriv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(texture, pname, params, __functionAddress);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") short[] pixels) {
        long __functionAddress = GL.getICD().glGetTextureImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, format, type, pixels.length << 1, pixels, __functionAddress);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") int[] pixels) {
        long __functionAddress = GL.getICD().glGetTextureImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, format, type, pixels.length << 2, pixels, __functionAddress);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") float[] pixels) {
        long __functionAddress = GL.getICD().glGetTextureImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, format, type, pixels.length << 2, pixels, __functionAddress);
    }

    public static void glGetTextureImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") double[] pixels) {
        long __functionAddress = GL.getICD().glGetTextureImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, format, type, pixels.length << 3, pixels, __functionAddress);
    }

    public static void glGetTextureLevelParameterfv(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetTextureLevelParameterfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texture, level, pname, params, __functionAddress);
    }

    public static void glGetTextureLevelParameteriv(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetTextureLevelParameteriv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texture, level, pname, params, __functionAddress);
    }

    public static void glGetTextureParameterfv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetTextureParameterfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texture, pname, params, __functionAddress);
    }

    public static void glGetTextureParameterIiv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetTextureParameterIiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texture, pname, params, __functionAddress);
    }

    public static void glGetTextureParameterIuiv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") int[] params) {
        long __functionAddress = GL.getICD().glGetTextureParameterIuiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texture, pname, params, __functionAddress);
    }

    public static void glGetTextureParameteriv(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetTextureParameteriv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texture, pname, params, __functionAddress);
    }

    public static void glCreateVertexArrays(@NativeType(value="GLuint *") int[] arrays) {
        long __functionAddress = GL.getICD().glCreateVertexArrays;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(arrays.length, arrays, __functionAddress);
    }

    public static void glVertexArrayVertexBuffers(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") int[] buffers, @Nullable @NativeType(value="GLintptr const *") PointerBuffer offsets, @Nullable @NativeType(value="GLsizei const *") int[] strides) {
        long __functionAddress = GL.getICD().glVertexArrayVertexBuffers;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(offsets, Checks.lengthSafe(buffers));
            Checks.checkSafe(strides, Checks.lengthSafe(buffers));
        }
        JNI.callPPPV(vaobj, first, Checks.lengthSafe(buffers), buffers, MemoryUtil.memAddressSafe(offsets), strides, __functionAddress);
    }

    public static void glGetVertexArrayiv(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] param) {
        long __functionAddress = GL.getICD().glGetVertexArrayiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(param, 1);
        }
        JNI.callPV(vaobj, pname, param, __functionAddress);
    }

    public static void glGetVertexArrayIndexediv(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] param) {
        long __functionAddress = GL.getICD().glGetVertexArrayIndexediv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(param, 1);
        }
        JNI.callPV(vaobj, index, pname, param, __functionAddress);
    }

    public static void glGetVertexArrayIndexed64iv(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") long[] param) {
        long __functionAddress = GL.getICD().glGetVertexArrayIndexed64iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(param, 1);
        }
        JNI.callPV(vaobj, index, pname, param, __functionAddress);
    }

    public static void glCreateSamplers(@NativeType(value="GLuint *") int[] samplers) {
        long __functionAddress = GL.getICD().glCreateSamplers;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(samplers.length, samplers, __functionAddress);
    }

    public static void glCreateProgramPipelines(@NativeType(value="GLuint *") int[] pipelines) {
        long __functionAddress = GL.getICD().glCreateProgramPipelines;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(pipelines.length, pipelines, __functionAddress);
    }

    public static void glCreateQueries(@NativeType(value="GLenum") int target, @NativeType(value="GLuint *") int[] ids) {
        long __functionAddress = GL.getICD().glCreateQueries;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, ids.length, ids, __functionAddress);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") short[] pixels) {
        long __functionAddress = GL.getICD().glGetTextureSubImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels.length << 1, pixels, __functionAddress);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") int[] pixels) {
        long __functionAddress = GL.getICD().glGetTextureSubImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels.length << 2, pixels, __functionAddress);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") float[] pixels) {
        long __functionAddress = GL.getICD().glGetTextureSubImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels.length << 2, pixels, __functionAddress);
    }

    public static void glGetTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") double[] pixels) {
        long __functionAddress = GL.getICD().glGetTextureSubImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels.length << 3, pixels, __functionAddress);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") short[] pixels) {
        long __functionAddress = GL.getICD().glGetCompressedTextureSubImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels.length << 1, pixels, __functionAddress);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") int[] pixels) {
        long __functionAddress = GL.getICD().glGetCompressedTextureSubImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels.length << 2, pixels, __functionAddress);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") float[] pixels) {
        long __functionAddress = GL.getICD().glGetCompressedTextureSubImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels.length << 2, pixels, __functionAddress);
    }

    public static void glGetCompressedTextureSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="void *") double[] pixels) {
        long __functionAddress = GL.getICD().glGetCompressedTextureSubImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, pixels.length << 3, pixels, __functionAddress);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") short[] img) {
        long __functionAddress = GL.getICD().glGetnTexImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(tex, level, format, type, img.length << 1, img, __functionAddress);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") int[] img) {
        long __functionAddress = GL.getICD().glGetnTexImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(tex, level, format, type, img.length << 2, img, __functionAddress);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") float[] img) {
        long __functionAddress = GL.getICD().glGetnTexImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(tex, level, format, type, img.length << 2, img, __functionAddress);
    }

    public static void glGetnTexImage(@NativeType(value="GLenum") int tex, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") double[] img) {
        long __functionAddress = GL.getICD().glGetnTexImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(tex, level, format, type, img.length << 3, img, __functionAddress);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") short[] pixels) {
        long __functionAddress = GL.getICD().glReadnPixels;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(x, y, width, height, format, type, pixels.length << 1, pixels, __functionAddress);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") int[] pixels) {
        long __functionAddress = GL.getICD().glReadnPixels;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(x, y, width, height, format, type, pixels.length << 2, pixels, __functionAddress);
    }

    public static void glReadnPixels(@NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") float[] pixels) {
        long __functionAddress = GL.getICD().glReadnPixels;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(x, y, width, height, format, type, pixels.length << 2, pixels, __functionAddress);
    }

    public static void glGetnUniformfv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetnUniformfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, params.length, params, __functionAddress);
    }

    public static void glGetnUniformdv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble *") double[] params) {
        long __functionAddress = GL.getICD().glGetnUniformdv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, params.length, params, __functionAddress);
    }

    public static void glGetnUniformiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetnUniformiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, params.length, params, __functionAddress);
    }

    public static void glGetnUniformuiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint *") int[] params) {
        long __functionAddress = GL.getICD().glGetnUniformuiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, params.length, params, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

