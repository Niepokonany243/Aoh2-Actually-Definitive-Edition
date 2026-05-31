/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.Set;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL44C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBBufferStorage {
    public static final int GL_MAP_PERSISTENT_BIT = 64;
    public static final int GL_MAP_COHERENT_BIT = 128;
    public static final int GL_DYNAMIC_STORAGE_BIT = 256;
    public static final int GL_CLIENT_STORAGE_BIT = 512;
    public static final int GL_BUFFER_IMMUTABLE_STORAGE = 33311;
    public static final int GL_BUFFER_STORAGE_FLAGS = 33312;
    public static final int GL_CLIENT_MAPPED_BUFFER_BARRIER_BIT = 16384;

    protected ARBBufferStorage() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, Set<String> ext) {
        return Checks.checkFunctions(caps.glBufferStorage, ext.contains("GL_EXT_direct_state_access") ? caps.glNamedBufferStorageEXT : -1L);
    }

    public static void nglBufferStorage(int target, long size, long data, int flags) {
        GL44C.nglBufferStorage(target, size, data, flags);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int target, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLbitfield") int flags) {
        GL44C.glBufferStorage(target, size, flags);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int target, @NativeType(value="void const *") ByteBuffer data, @NativeType(value="GLbitfield") int flags) {
        GL44C.glBufferStorage(target, data, flags);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int target, @NativeType(value="void const *") ShortBuffer data, @NativeType(value="GLbitfield") int flags) {
        GL44C.glBufferStorage(target, data, flags);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int target, @NativeType(value="void const *") IntBuffer data, @NativeType(value="GLbitfield") int flags) {
        GL44C.glBufferStorage(target, data, flags);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int target, @NativeType(value="void const *") FloatBuffer data, @NativeType(value="GLbitfield") int flags) {
        GL44C.glBufferStorage(target, data, flags);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int target, @NativeType(value="void const *") DoubleBuffer data, @NativeType(value="GLbitfield") int flags) {
        GL44C.glBufferStorage(target, data, flags);
    }

    public static native void nglNamedBufferStorageEXT(int var0, long var1, long var3, int var5);

    public static void glNamedBufferStorageEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLbitfield") int flags) {
        ARBBufferStorage.nglNamedBufferStorageEXT(buffer, size, 0L, flags);
    }

    public static void glNamedBufferStorageEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") ByteBuffer data, @NativeType(value="GLbitfield") int flags) {
        ARBBufferStorage.nglNamedBufferStorageEXT(buffer, data.remaining(), MemoryUtil.memAddress(data), flags);
    }

    public static void glNamedBufferStorageEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") ShortBuffer data, @NativeType(value="GLbitfield") int flags) {
        ARBBufferStorage.nglNamedBufferStorageEXT(buffer, Integer.toUnsignedLong(data.remaining()) << 1, MemoryUtil.memAddress(data), flags);
    }

    public static void glNamedBufferStorageEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") IntBuffer data, @NativeType(value="GLbitfield") int flags) {
        ARBBufferStorage.nglNamedBufferStorageEXT(buffer, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data), flags);
    }

    public static void glNamedBufferStorageEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") FloatBuffer data, @NativeType(value="GLbitfield") int flags) {
        ARBBufferStorage.nglNamedBufferStorageEXT(buffer, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data), flags);
    }

    public static void glNamedBufferStorageEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") DoubleBuffer data, @NativeType(value="GLbitfield") int flags) {
        ARBBufferStorage.nglNamedBufferStorageEXT(buffer, Integer.toUnsignedLong(data.remaining()) << 3, MemoryUtil.memAddress(data), flags);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int target, @NativeType(value="void const *") short[] data, @NativeType(value="GLbitfield") int flags) {
        GL44C.glBufferStorage(target, data, flags);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int target, @NativeType(value="void const *") int[] data, @NativeType(value="GLbitfield") int flags) {
        GL44C.glBufferStorage(target, data, flags);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int target, @NativeType(value="void const *") float[] data, @NativeType(value="GLbitfield") int flags) {
        GL44C.glBufferStorage(target, data, flags);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int target, @NativeType(value="void const *") double[] data, @NativeType(value="GLbitfield") int flags) {
        GL44C.glBufferStorage(target, data, flags);
    }

    public static void glNamedBufferStorageEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") short[] data, @NativeType(value="GLbitfield") int flags) {
        long __functionAddress = GL.getICD().glNamedBufferStorageEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 1, data, flags, __functionAddress);
    }

    public static void glNamedBufferStorageEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") int[] data, @NativeType(value="GLbitfield") int flags) {
        long __functionAddress = GL.getICD().glNamedBufferStorageEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 2, data, flags, __functionAddress);
    }

    public static void glNamedBufferStorageEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") float[] data, @NativeType(value="GLbitfield") int flags) {
        long __functionAddress = GL.getICD().glNamedBufferStorageEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 2, data, flags, __functionAddress);
    }

    public static void glNamedBufferStorageEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") double[] data, @NativeType(value="GLbitfield") int flags) {
        long __functionAddress = GL.getICD().glNamedBufferStorageEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 3, data, flags, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

