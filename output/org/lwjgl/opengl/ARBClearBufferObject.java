/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.Set;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBClearBufferObject {
    protected ARBClearBufferObject() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, Set<String> ext) {
        return Checks.checkFunctions(caps.glClearBufferData, caps.glClearBufferSubData, ext.contains("GL_EXT_direct_state_access") ? caps.glClearNamedBufferDataEXT : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glClearNamedBufferSubDataEXT : -1L);
    }

    public static void nglClearBufferData(int target, int internalformat, int format, int type, long data) {
        GL43C.nglClearBufferData(target, internalformat, format, type, data);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ByteBuffer data) {
        GL43C.glClearBufferData(target, internalformat, format, type, data);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ShortBuffer data) {
        GL43C.glClearBufferData(target, internalformat, format, type, data);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") IntBuffer data) {
        GL43C.glClearBufferData(target, internalformat, format, type, data);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") FloatBuffer data) {
        GL43C.glClearBufferData(target, internalformat, format, type, data);
    }

    public static void nglClearBufferSubData(int target, int internalformat, long offset, long size, int format, int type, long data) {
        GL43C.nglClearBufferSubData(target, internalformat, offset, size, format, type, data);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ByteBuffer data) {
        GL43C.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ShortBuffer data) {
        GL43C.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") IntBuffer data) {
        GL43C.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") FloatBuffer data) {
        GL43C.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
    }

    public static native void nglClearNamedBufferDataEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glClearNamedBufferDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ByteBuffer data) {
        ARBClearBufferObject.nglClearNamedBufferDataEXT(buffer, internalformat, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static void glClearNamedBufferDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ShortBuffer data) {
        ARBClearBufferObject.nglClearNamedBufferDataEXT(buffer, internalformat, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static void glClearNamedBufferDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") IntBuffer data) {
        ARBClearBufferObject.nglClearNamedBufferDataEXT(buffer, internalformat, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static void glClearNamedBufferDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") FloatBuffer data) {
        ARBClearBufferObject.nglClearNamedBufferDataEXT(buffer, internalformat, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static native void nglClearNamedBufferSubDataEXT(int var0, int var1, long var2, long var4, int var6, int var7, long var8);

    public static void glClearNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ByteBuffer data) {
        ARBClearBufferObject.nglClearNamedBufferSubDataEXT(buffer, internalformat, offset, size, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static void glClearNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ShortBuffer data) {
        ARBClearBufferObject.nglClearNamedBufferSubDataEXT(buffer, internalformat, offset, size, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static void glClearNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") IntBuffer data) {
        ARBClearBufferObject.nglClearNamedBufferSubDataEXT(buffer, internalformat, offset, size, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static void glClearNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") FloatBuffer data) {
        ARBClearBufferObject.nglClearNamedBufferSubDataEXT(buffer, internalformat, offset, size, format, type, MemoryUtil.memAddressSafe(data));
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") short[] data) {
        GL43C.glClearBufferData(target, internalformat, format, type, data);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") int[] data) {
        GL43C.glClearBufferData(target, internalformat, format, type, data);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") float[] data) {
        GL43C.glClearBufferData(target, internalformat, format, type, data);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") short[] data) {
        GL43C.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") int[] data) {
        GL43C.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") float[] data) {
        GL43C.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
    }

    public static void glClearNamedBufferDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") short[] data) {
        long __functionAddress = GL.getICD().glClearNamedBufferDataEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(buffer, internalformat, format, type, data, __functionAddress);
    }

    public static void glClearNamedBufferDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") int[] data) {
        long __functionAddress = GL.getICD().glClearNamedBufferDataEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(buffer, internalformat, format, type, data, __functionAddress);
    }

    public static void glClearNamedBufferDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") float[] data) {
        long __functionAddress = GL.getICD().glClearNamedBufferDataEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(buffer, internalformat, format, type, data, __functionAddress);
    }

    public static void glClearNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") short[] data) {
        long __functionAddress = GL.getICD().glClearNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, internalformat, offset, size, format, type, data, __functionAddress);
    }

    public static void glClearNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") int[] data) {
        long __functionAddress = GL.getICD().glClearNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, internalformat, offset, size, format, type, data, __functionAddress);
    }

    public static void glClearNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") float[] data) {
        long __functionAddress = GL.getICD().glClearNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, internalformat, offset, size, format, type, data, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

