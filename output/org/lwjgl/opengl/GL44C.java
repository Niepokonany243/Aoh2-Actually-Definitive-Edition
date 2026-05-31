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
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL44C
extends GL43C {
    public static final int GL_MAX_VERTEX_ATTRIB_STRIDE = 33509;
    public static final int GL_PRIMITIVE_RESTART_FOR_PATCHES_SUPPORTED = 33313;
    public static final int GL_TEXTURE_BUFFER_BINDING = 35882;
    public static final int GL_MAP_PERSISTENT_BIT = 64;
    public static final int GL_MAP_COHERENT_BIT = 128;
    public static final int GL_DYNAMIC_STORAGE_BIT = 256;
    public static final int GL_CLIENT_STORAGE_BIT = 512;
    public static final int GL_BUFFER_IMMUTABLE_STORAGE = 33311;
    public static final int GL_BUFFER_STORAGE_FLAGS = 33312;
    public static final int GL_CLIENT_MAPPED_BUFFER_BARRIER_BIT = 16384;
    public static final int GL_CLEAR_TEXTURE = 37733;
    public static final int GL_LOCATION_COMPONENT = 37706;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_INDEX = 37707;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_STRIDE = 37708;
    public static final int GL_QUERY_RESULT_NO_WAIT = 37268;
    public static final int GL_QUERY_BUFFER = 37266;
    public static final int GL_QUERY_BUFFER_BINDING = 37267;
    public static final int GL_QUERY_BUFFER_BARRIER_BIT = 32768;
    public static final int GL_MIRROR_CLAMP_TO_EDGE = 34627;

    protected GL44C() {
        throw new UnsupportedOperationException();
    }

    public static native void nglBufferStorage(int var0, long var1, long var3, int var5);

    public static void glBufferStorage(@NativeType(value="GLenum") int target, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLbitfield") int flags) {
        GL44C.nglBufferStorage(target, size, 0L, flags);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int target, @NativeType(value="void const *") ByteBuffer data, @NativeType(value="GLbitfield") int flags) {
        GL44C.nglBufferStorage(target, data.remaining(), MemoryUtil.memAddress(data), flags);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int target, @NativeType(value="void const *") ShortBuffer data, @NativeType(value="GLbitfield") int flags) {
        GL44C.nglBufferStorage(target, Integer.toUnsignedLong(data.remaining()) << 1, MemoryUtil.memAddress(data), flags);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int target, @NativeType(value="void const *") IntBuffer data, @NativeType(value="GLbitfield") int flags) {
        GL44C.nglBufferStorage(target, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data), flags);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int target, @NativeType(value="void const *") FloatBuffer data, @NativeType(value="GLbitfield") int flags) {
        GL44C.nglBufferStorage(target, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data), flags);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int target, @NativeType(value="void const *") DoubleBuffer data, @NativeType(value="GLbitfield") int flags) {
        GL44C.nglBufferStorage(target, Integer.toUnsignedLong(data.remaining()) << 3, MemoryUtil.memAddress(data), flags);
    }

    public static native void nglClearTexSubImage(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, long var10);

    public static void glClearTexSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ByteBuffer data) {
        GL44C.nglClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ShortBuffer data) {
        GL44C.nglClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") IntBuffer data) {
        GL44C.nglClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") FloatBuffer data) {
        GL44C.nglClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") DoubleBuffer data) {
        GL44C.nglClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static native void nglClearTexImage(int var0, int var1, int var2, int var3, long var4);

    public static void glClearTexImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ByteBuffer data) {
        GL44C.nglClearTexImage(texture, level, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ShortBuffer data) {
        GL44C.nglClearTexImage(texture, level, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") IntBuffer data) {
        GL44C.nglClearTexImage(texture, level, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") FloatBuffer data) {
        GL44C.nglClearTexImage(texture, level, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") DoubleBuffer data) {
        GL44C.nglClearTexImage(texture, level, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static native void nglBindBuffersBase(int var0, int var1, int var2, long var3);

    public static void glBindBuffersBase(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") IntBuffer buffers) {
        GL44C.nglBindBuffersBase(target, first, Checks.remainingSafe(buffers), MemoryUtil.memAddressSafe(buffers));
    }

    public static native void nglBindBuffersRange(int var0, int var1, int var2, long var3, long var5, long var7);

    public static void glBindBuffersRange(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") IntBuffer buffers, @Nullable @NativeType(value="GLintptr const *") PointerBuffer offsets, @Nullable @NativeType(value="GLsizeiptr const *") PointerBuffer sizes) {
        if (Checks.CHECKS) {
            Checks.checkSafe(offsets, Checks.remainingSafe(buffers));
            Checks.checkSafe(sizes, Checks.remainingSafe(buffers));
        }
        GL44C.nglBindBuffersRange(target, first, Checks.remainingSafe(buffers), MemoryUtil.memAddressSafe(buffers), MemoryUtil.memAddressSafe(offsets), MemoryUtil.memAddressSafe(sizes));
    }

    public static native void nglBindTextures(int var0, int var1, long var2);

    public static void glBindTextures(@NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") IntBuffer textures) {
        GL44C.nglBindTextures(first, Checks.remainingSafe(textures), MemoryUtil.memAddressSafe(textures));
    }

    public static native void nglBindSamplers(int var0, int var1, long var2);

    public static void glBindSamplers(@NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") IntBuffer samplers) {
        GL44C.nglBindSamplers(first, Checks.remainingSafe(samplers), MemoryUtil.memAddressSafe(samplers));
    }

    public static native void nglBindImageTextures(int var0, int var1, long var2);

    public static void glBindImageTextures(@NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") IntBuffer textures) {
        GL44C.nglBindImageTextures(first, Checks.remainingSafe(textures), MemoryUtil.memAddressSafe(textures));
    }

    public static native void nglBindVertexBuffers(int var0, int var1, long var2, long var4, long var6);

    public static void glBindVertexBuffers(@NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") IntBuffer buffers, @Nullable @NativeType(value="GLintptr const *") PointerBuffer offsets, @Nullable @NativeType(value="GLsizei const *") IntBuffer strides) {
        if (Checks.CHECKS) {
            Checks.checkSafe(offsets, Checks.remainingSafe(buffers));
            Checks.checkSafe((Buffer)strides, Checks.remainingSafe(buffers));
        }
        GL44C.nglBindVertexBuffers(first, Checks.remainingSafe(buffers), MemoryUtil.memAddressSafe(buffers), MemoryUtil.memAddressSafe(offsets), MemoryUtil.memAddressSafe(strides));
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int target, @NativeType(value="void const *") short[] data, @NativeType(value="GLbitfield") int flags) {
        long __functionAddress = GL.getICD().glBufferStorage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 1, data, flags, __functionAddress);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int target, @NativeType(value="void const *") int[] data, @NativeType(value="GLbitfield") int flags) {
        long __functionAddress = GL.getICD().glBufferStorage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 2, data, flags, __functionAddress);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int target, @NativeType(value="void const *") float[] data, @NativeType(value="GLbitfield") int flags) {
        long __functionAddress = GL.getICD().glBufferStorage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 2, data, flags, __functionAddress);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int target, @NativeType(value="void const *") double[] data, @NativeType(value="GLbitfield") int flags) {
        long __functionAddress = GL.getICD().glBufferStorage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 3, data, flags, __functionAddress);
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") short[] data) {
        long __functionAddress = GL.getICD().glClearTexSubImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data, __functionAddress);
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") int[] data) {
        long __functionAddress = GL.getICD().glClearTexSubImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data, __functionAddress);
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") float[] data) {
        long __functionAddress = GL.getICD().glClearTexSubImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data, __functionAddress);
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") double[] data) {
        long __functionAddress = GL.getICD().glClearTexSubImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data, __functionAddress);
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") short[] data) {
        long __functionAddress = GL.getICD().glClearTexImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, format, type, data, __functionAddress);
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") int[] data) {
        long __functionAddress = GL.getICD().glClearTexImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, format, type, data, __functionAddress);
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") float[] data) {
        long __functionAddress = GL.getICD().glClearTexImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, format, type, data, __functionAddress);
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") double[] data) {
        long __functionAddress = GL.getICD().glClearTexImage;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, level, format, type, data, __functionAddress);
    }

    public static void glBindBuffersBase(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") int[] buffers) {
        long __functionAddress = GL.getICD().glBindBuffersBase;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(target, first, Checks.lengthSafe(buffers), buffers, __functionAddress);
    }

    public static void glBindBuffersRange(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") int[] buffers, @Nullable @NativeType(value="GLintptr const *") PointerBuffer offsets, @Nullable @NativeType(value="GLsizeiptr const *") PointerBuffer sizes) {
        long __functionAddress = GL.getICD().glBindBuffersRange;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(offsets, Checks.lengthSafe(buffers));
            Checks.checkSafe(sizes, Checks.lengthSafe(buffers));
        }
        JNI.callPPPV(target, first, Checks.lengthSafe(buffers), buffers, MemoryUtil.memAddressSafe(offsets), MemoryUtil.memAddressSafe(sizes), __functionAddress);
    }

    public static void glBindTextures(@NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") int[] textures) {
        long __functionAddress = GL.getICD().glBindTextures;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(first, Checks.lengthSafe(textures), textures, __functionAddress);
    }

    public static void glBindSamplers(@NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") int[] samplers) {
        long __functionAddress = GL.getICD().glBindSamplers;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(first, Checks.lengthSafe(samplers), samplers, __functionAddress);
    }

    public static void glBindImageTextures(@NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") int[] textures) {
        long __functionAddress = GL.getICD().glBindImageTextures;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(first, Checks.lengthSafe(textures), textures, __functionAddress);
    }

    public static void glBindVertexBuffers(@NativeType(value="GLuint") int first, @Nullable @NativeType(value="GLuint const *") int[] buffers, @Nullable @NativeType(value="GLintptr const *") PointerBuffer offsets, @Nullable @NativeType(value="GLsizei const *") int[] strides) {
        long __functionAddress = GL.getICD().glBindVertexBuffers;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(offsets, Checks.lengthSafe(buffers));
            Checks.checkSafe(strides, Checks.lengthSafe(buffers));
        }
        JNI.callPPPV(first, Checks.lengthSafe(buffers), buffers, MemoryUtil.memAddressSafe(offsets), strides, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

