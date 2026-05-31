/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Set;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTMemoryObject {
    public static final int GL_TEXTURE_TILING_EXT = 38272;
    public static final int GL_DEDICATED_MEMORY_OBJECT_EXT = 38273;
    public static final int GL_NUM_TILING_TYPES_EXT = 38274;
    public static final int GL_TILING_TYPES_EXT = 38275;
    public static final int GL_OPTIMAL_TILING_EXT = 38276;
    public static final int GL_LINEAR_TILING_EXT = 38277;
    public static final int GL_NUM_DEVICE_UUIDS_EXT = 38294;
    public static final int GL_DEVICE_UUID_EXT = 38295;
    public static final int GL_DRIVER_UUID_EXT = 38296;
    public static final int GL_UUID_SIZE_EXT = 16;

    protected EXTMemoryObject() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, Set<String> ext) {
        return Checks.checkFunctions(caps.glGetUnsignedBytevEXT, caps.glGetUnsignedBytei_vEXT, caps.glDeleteMemoryObjectsEXT, caps.glIsMemoryObjectEXT, caps.glCreateMemoryObjectsEXT, caps.glMemoryObjectParameterivEXT, caps.glGetMemoryObjectParameterivEXT, caps.glTexStorageMem2DEXT, caps.glTexStorageMem2DMultisampleEXT, caps.glTexStorageMem3DEXT, caps.glTexStorageMem3DMultisampleEXT, caps.glBufferStorageMemEXT, caps.hasDSA(ext) ? caps.glTextureStorageMem2DEXT : -1L, caps.hasDSA(ext) ? caps.glTextureStorageMem2DMultisampleEXT : -1L, caps.hasDSA(ext) ? caps.glTextureStorageMem3DEXT : -1L, caps.hasDSA(ext) ? caps.glTextureStorageMem3DMultisampleEXT : -1L, caps.hasDSA(ext) ? caps.glNamedBufferStorageMemEXT : -1L, caps.glTexStorageMem1DEXT, caps.hasDSA(ext) ? caps.glTextureStorageMem1DEXT : -1L);
    }

    public static native void nglGetUnsignedBytevEXT(int var0, long var1);

    public static void glGetUnsignedBytevEXT(@NativeType(value="GLenum") int pname, @NativeType(value="GLubyte *") ByteBuffer data) {
        EXTMemoryObject.nglGetUnsignedBytevEXT(pname, MemoryUtil.memAddress(data));
    }

    public static native void nglGetUnsignedBytei_vEXT(int var0, int var1, long var2);

    public static void glGetUnsignedBytei_vEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLubyte *") ByteBuffer data) {
        EXTMemoryObject.nglGetUnsignedBytei_vEXT(target, index, MemoryUtil.memAddress(data));
    }

    public static native void nglDeleteMemoryObjectsEXT(int var0, long var1);

    public static void glDeleteMemoryObjectsEXT(@NativeType(value="GLuint const *") IntBuffer memoryObjects) {
        EXTMemoryObject.nglDeleteMemoryObjectsEXT(memoryObjects.remaining(), MemoryUtil.memAddress(memoryObjects));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDeleteMemoryObjectsEXT(@NativeType(value="GLuint const *") int memoryObject) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer memoryObjects = stack.ints(memoryObject);
            EXTMemoryObject.nglDeleteMemoryObjectsEXT(1, MemoryUtil.memAddress(memoryObjects));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="GLboolean")
    public static native boolean glIsMemoryObjectEXT(@NativeType(value="GLuint") int var0);

    public static native void nglCreateMemoryObjectsEXT(int var0, long var1);

    public static void glCreateMemoryObjectsEXT(@NativeType(value="GLuint *") IntBuffer memoryObjects) {
        EXTMemoryObject.nglCreateMemoryObjectsEXT(memoryObjects.remaining(), MemoryUtil.memAddress(memoryObjects));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glCreateMemoryObjectsEXT() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer memoryObjects = stack.callocInt(1);
            EXTMemoryObject.nglCreateMemoryObjectsEXT(1, MemoryUtil.memAddress(memoryObjects));
            int n = memoryObjects.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglMemoryObjectParameterivEXT(int var0, int var1, long var2);

    public static void glMemoryObjectParameterivEXT(@NativeType(value="GLuint") int memoryObject, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTMemoryObject.nglMemoryObjectParameterivEXT(memoryObject, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glMemoryObjectParameteriEXT(@NativeType(value="GLuint") int memoryObject, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int param) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.ints(param);
            EXTMemoryObject.nglMemoryObjectParameterivEXT(memoryObject, pname, MemoryUtil.memAddress(params));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetMemoryObjectParameterivEXT(int var0, int var1, long var2);

    public static void glGetMemoryObjectParameterivEXT(@NativeType(value="GLuint") int memoryObject, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTMemoryObject.nglGetMemoryObjectParameterivEXT(memoryObject, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetMemoryObjectParameteriEXT(@NativeType(value="GLuint") int memoryObject, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            EXTMemoryObject.nglGetMemoryObjectParameterivEXT(memoryObject, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glTexStorageMem2DEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLuint") int var5, @NativeType(value="GLuint64") long var6);

    public static native void glTexStorageMem2DMultisampleEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLboolean") boolean var5, @NativeType(value="GLuint") int var6, @NativeType(value="GLuint64") long var7);

    public static native void glTexStorageMem3DEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLsizei") int var5, @NativeType(value="GLuint") int var6, @NativeType(value="GLuint64") long var7);

    public static native void glTexStorageMem3DMultisampleEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLsizei") int var5, @NativeType(value="GLboolean") boolean var6, @NativeType(value="GLuint") int var7, @NativeType(value="GLuint64") long var8);

    public static native void glBufferStorageMemEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLsizeiptr") long var1, @NativeType(value="GLuint") int var3, @NativeType(value="GLuint64") long var4);

    public static native void glTextureStorageMem2DEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLuint") int var5, @NativeType(value="GLuint64") long var6);

    public static native void glTextureStorageMem2DMultisampleEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLboolean") boolean var5, @NativeType(value="GLuint") int var6, @NativeType(value="GLuint64") long var7);

    public static native void glTextureStorageMem3DEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLsizei") int var5, @NativeType(value="GLuint") int var6, @NativeType(value="GLuint64") long var7);

    public static native void glTextureStorageMem3DMultisampleEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLsizei") int var5, @NativeType(value="GLboolean") boolean var6, @NativeType(value="GLuint") int var7, @NativeType(value="GLuint64") long var8);

    public static native void glNamedBufferStorageMemEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizeiptr") long var1, @NativeType(value="GLuint") int var3, @NativeType(value="GLuint64") long var4);

    public static native void glTexStorageMem1DEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLuint") int var4, @NativeType(value="GLuint64") long var5);

    public static native void glTextureStorageMem1DEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLuint") int var4, @NativeType(value="GLuint64") long var5);

    public static void glDeleteMemoryObjectsEXT(@NativeType(value="GLuint const *") int[] memoryObjects) {
        long __functionAddress = GL.getICD().glDeleteMemoryObjectsEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(memoryObjects.length, memoryObjects, __functionAddress);
    }

    public static void glCreateMemoryObjectsEXT(@NativeType(value="GLuint *") int[] memoryObjects) {
        long __functionAddress = GL.getICD().glCreateMemoryObjectsEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(memoryObjects.length, memoryObjects, __functionAddress);
    }

    public static void glMemoryObjectParameterivEXT(@NativeType(value="GLuint") int memoryObject, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = GL.getICD().glMemoryObjectParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(memoryObject, pname, params, __functionAddress);
    }

    public static void glGetMemoryObjectParameterivEXT(@NativeType(value="GLuint") int memoryObject, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetMemoryObjectParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(memoryObject, pname, params, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

