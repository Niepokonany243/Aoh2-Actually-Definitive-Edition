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
import org.lwjgl.opengl.GL14C;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL15C
extends GL14C {
    public static final int GL_SRC1_ALPHA = 34185;
    public static final int GL_ARRAY_BUFFER = 34962;
    public static final int GL_ELEMENT_ARRAY_BUFFER = 34963;
    public static final int GL_ARRAY_BUFFER_BINDING = 34964;
    public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING = 34965;
    public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = 34975;
    public static final int GL_STREAM_DRAW = 35040;
    public static final int GL_STREAM_READ = 35041;
    public static final int GL_STREAM_COPY = 35042;
    public static final int GL_STATIC_DRAW = 35044;
    public static final int GL_STATIC_READ = 35045;
    public static final int GL_STATIC_COPY = 35046;
    public static final int GL_DYNAMIC_DRAW = 35048;
    public static final int GL_DYNAMIC_READ = 35049;
    public static final int GL_DYNAMIC_COPY = 35050;
    public static final int GL_READ_ONLY = 35000;
    public static final int GL_WRITE_ONLY = 35001;
    public static final int GL_READ_WRITE = 35002;
    public static final int GL_BUFFER_SIZE = 34660;
    public static final int GL_BUFFER_USAGE = 34661;
    public static final int GL_BUFFER_ACCESS = 35003;
    public static final int GL_BUFFER_MAPPED = 35004;
    public static final int GL_BUFFER_MAP_POINTER = 35005;
    public static final int GL_SAMPLES_PASSED = 35092;
    public static final int GL_QUERY_COUNTER_BITS = 34916;
    public static final int GL_CURRENT_QUERY = 34917;
    public static final int GL_QUERY_RESULT = 34918;
    public static final int GL_QUERY_RESULT_AVAILABLE = 34919;

    protected GL15C() {
        throw new UnsupportedOperationException();
    }

    public static native void glBindBuffer(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglDeleteBuffers(int var0, long var1);

    public static void glDeleteBuffers(@NativeType(value="GLuint const *") IntBuffer buffers) {
        GL15C.nglDeleteBuffers(buffers.remaining(), MemoryUtil.memAddress(buffers));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDeleteBuffers(@NativeType(value="GLuint const *") int buffer) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer buffers = stack.ints(buffer);
            GL15C.nglDeleteBuffers(1, MemoryUtil.memAddress(buffers));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGenBuffers(int var0, long var1);

    public static void glGenBuffers(@NativeType(value="GLuint *") IntBuffer buffers) {
        GL15C.nglGenBuffers(buffers.remaining(), MemoryUtil.memAddress(buffers));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGenBuffers() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer buffers = stack.callocInt(1);
            GL15C.nglGenBuffers(1, MemoryUtil.memAddress(buffers));
            int n = buffers.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="GLboolean")
    public static native boolean glIsBuffer(@NativeType(value="GLuint") int var0);

    public static native void nglBufferData(int var0, long var1, long var3, int var5);

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int usage) {
        GL15C.nglBufferData(target, size, 0L, usage);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="void const *") ByteBuffer data, @NativeType(value="GLenum") int usage) {
        GL15C.nglBufferData(target, data.remaining(), MemoryUtil.memAddress(data), usage);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="void const *") ShortBuffer data, @NativeType(value="GLenum") int usage) {
        GL15C.nglBufferData(target, Integer.toUnsignedLong(data.remaining()) << 1, MemoryUtil.memAddress(data), usage);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="void const *") IntBuffer data, @NativeType(value="GLenum") int usage) {
        GL15C.nglBufferData(target, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data), usage);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="void const *") LongBuffer data, @NativeType(value="GLenum") int usage) {
        GL15C.nglBufferData(target, Integer.toUnsignedLong(data.remaining()) << 3, MemoryUtil.memAddress(data), usage);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="void const *") FloatBuffer data, @NativeType(value="GLenum") int usage) {
        GL15C.nglBufferData(target, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data), usage);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="void const *") DoubleBuffer data, @NativeType(value="GLenum") int usage) {
        GL15C.nglBufferData(target, Integer.toUnsignedLong(data.remaining()) << 3, MemoryUtil.memAddress(data), usage);
    }

    public static native void nglBufferSubData(int var0, long var1, long var3, long var5);

    public static void glBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") ByteBuffer data) {
        GL15C.nglBufferSubData(target, offset, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static void glBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") ShortBuffer data) {
        GL15C.nglBufferSubData(target, offset, Integer.toUnsignedLong(data.remaining()) << 1, MemoryUtil.memAddress(data));
    }

    public static void glBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") IntBuffer data) {
        GL15C.nglBufferSubData(target, offset, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data));
    }

    public static void glBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") LongBuffer data) {
        GL15C.nglBufferSubData(target, offset, Integer.toUnsignedLong(data.remaining()) << 3, MemoryUtil.memAddress(data));
    }

    public static void glBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") FloatBuffer data) {
        GL15C.nglBufferSubData(target, offset, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data));
    }

    public static void glBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") DoubleBuffer data) {
        GL15C.nglBufferSubData(target, offset, Integer.toUnsignedLong(data.remaining()) << 3, MemoryUtil.memAddress(data));
    }

    public static native void nglGetBufferSubData(int var0, long var1, long var3, long var5);

    public static void glGetBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") ByteBuffer data) {
        GL15C.nglGetBufferSubData(target, offset, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static void glGetBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") ShortBuffer data) {
        GL15C.nglGetBufferSubData(target, offset, Integer.toUnsignedLong(data.remaining()) << 1, MemoryUtil.memAddress(data));
    }

    public static void glGetBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") IntBuffer data) {
        GL15C.nglGetBufferSubData(target, offset, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data));
    }

    public static void glGetBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") LongBuffer data) {
        GL15C.nglGetBufferSubData(target, offset, Integer.toUnsignedLong(data.remaining()) << 3, MemoryUtil.memAddress(data));
    }

    public static void glGetBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") FloatBuffer data) {
        GL15C.nglGetBufferSubData(target, offset, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data));
    }

    public static void glGetBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") DoubleBuffer data) {
        GL15C.nglGetBufferSubData(target, offset, Integer.toUnsignedLong(data.remaining()) << 3, MemoryUtil.memAddress(data));
    }

    public static native long nglMapBuffer(int var0, int var1);

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapBuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int access) {
        long __result = GL15C.nglMapBuffer(target, access);
        return MemoryUtil.memByteBufferSafe(__result, GL15C.glGetBufferParameteri(target, 34660));
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapBuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int access, @Nullable ByteBuffer old_buffer) {
        long __result = GL15C.nglMapBuffer(target, access);
        int length = GL15C.glGetBufferParameteri(target, 34660);
        return APIUtil.apiGetMappedBuffer(old_buffer, __result, length);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapBuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int access, long length, @Nullable ByteBuffer old_buffer) {
        long __result = GL15C.nglMapBuffer(target, access);
        return APIUtil.apiGetMappedBuffer(old_buffer, __result, (int)length);
    }

    @NativeType(value="GLboolean")
    public static native boolean glUnmapBuffer(@NativeType(value="GLenum") int var0);

    public static native void nglGetBufferParameteriv(int var0, int var1, long var2);

    public static void glGetBufferParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL15C.nglGetBufferParameteriv(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetBufferParameteri(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL15C.nglGetBufferParameteriv(target, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetBufferPointerv(int var0, int var1, long var2);

    public static void glGetBufferPointerv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="void **") PointerBuffer params) {
        if (Checks.CHECKS) {
            Checks.check(params, 1);
        }
        GL15C.nglGetBufferPointerv(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetBufferPointer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            PointerBuffer params = stack.callocPointer(1);
            GL15C.nglGetBufferPointerv(target, pname, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGenQueries(int var0, long var1);

    public static void glGenQueries(@NativeType(value="GLuint *") IntBuffer ids) {
        GL15C.nglGenQueries(ids.remaining(), MemoryUtil.memAddress(ids));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGenQueries() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer ids = stack.callocInt(1);
            GL15C.nglGenQueries(1, MemoryUtil.memAddress(ids));
            int n = ids.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglDeleteQueries(int var0, long var1);

    public static void glDeleteQueries(@NativeType(value="GLuint const *") IntBuffer ids) {
        GL15C.nglDeleteQueries(ids.remaining(), MemoryUtil.memAddress(ids));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDeleteQueries(@NativeType(value="GLuint const *") int id) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer ids = stack.ints(id);
            GL15C.nglDeleteQueries(1, MemoryUtil.memAddress(ids));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="GLboolean")
    public static native boolean glIsQuery(@NativeType(value="GLuint") int var0);

    public static native void glBeginQuery(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glEndQuery(@NativeType(value="GLenum") int var0);

    public static native void nglGetQueryiv(int var0, int var1, long var2);

    public static void glGetQueryiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL15C.nglGetQueryiv(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetQueryi(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL15C.nglGetQueryiv(target, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetQueryObjectiv(int var0, int var1, long var2);

    public static void glGetQueryObjectiv(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL15C.nglGetQueryObjectiv(id, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetQueryObjecti(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL15C.nglGetQueryObjectiv(id, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetQueryObjectuiv(int var0, int var1, long var2);

    public static void glGetQueryObjectuiv(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL15C.nglGetQueryObjectuiv(id, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetQueryObjectui(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL15C.nglGetQueryObjectuiv(id, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glDeleteBuffers(@NativeType(value="GLuint const *") int[] buffers) {
        long __functionAddress = GL.getICD().glDeleteBuffers;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(buffers.length, buffers, __functionAddress);
    }

    public static void glGenBuffers(@NativeType(value="GLuint *") int[] buffers) {
        long __functionAddress = GL.getICD().glGenBuffers;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(buffers.length, buffers, __functionAddress);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="void const *") short[] data, @NativeType(value="GLenum") int usage) {
        long __functionAddress = GL.getICD().glBufferData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 1, data, usage, __functionAddress);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="void const *") int[] data, @NativeType(value="GLenum") int usage) {
        long __functionAddress = GL.getICD().glBufferData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 2, data, usage, __functionAddress);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="void const *") long[] data, @NativeType(value="GLenum") int usage) {
        long __functionAddress = GL.getICD().glBufferData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 3, data, usage, __functionAddress);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="void const *") float[] data, @NativeType(value="GLenum") int usage) {
        long __functionAddress = GL.getICD().glBufferData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 2, data, usage, __functionAddress);
    }

    public static void glBufferData(@NativeType(value="GLenum") int target, @NativeType(value="void const *") double[] data, @NativeType(value="GLenum") int usage) {
        long __functionAddress = GL.getICD().glBufferData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 3, data, usage, __functionAddress);
    }

    public static void glBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") short[] data) {
        long __functionAddress = GL.getICD().glBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 1, data, __functionAddress);
    }

    public static void glBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") int[] data) {
        long __functionAddress = GL.getICD().glBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 2, data, __functionAddress);
    }

    public static void glBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") long[] data) {
        long __functionAddress = GL.getICD().glBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 3, data, __functionAddress);
    }

    public static void glBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") float[] data) {
        long __functionAddress = GL.getICD().glBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 2, data, __functionAddress);
    }

    public static void glBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") double[] data) {
        long __functionAddress = GL.getICD().glBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 3, data, __functionAddress);
    }

    public static void glGetBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") short[] data) {
        long __functionAddress = GL.getICD().glGetBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 1, data, __functionAddress);
    }

    public static void glGetBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") int[] data) {
        long __functionAddress = GL.getICD().glGetBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 2, data, __functionAddress);
    }

    public static void glGetBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") long[] data) {
        long __functionAddress = GL.getICD().glGetBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 3, data, __functionAddress);
    }

    public static void glGetBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") float[] data) {
        long __functionAddress = GL.getICD().glGetBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 2, data, __functionAddress);
    }

    public static void glGetBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") double[] data) {
        long __functionAddress = GL.getICD().glGetBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 3, data, __functionAddress);
    }

    public static void glGetBufferParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetBufferParameteriv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glGenQueries(@NativeType(value="GLuint *") int[] ids) {
        long __functionAddress = GL.getICD().glGenQueries;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(ids.length, ids, __functionAddress);
    }

    public static void glDeleteQueries(@NativeType(value="GLuint const *") int[] ids) {
        long __functionAddress = GL.getICD().glDeleteQueries;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(ids.length, ids, __functionAddress);
    }

    public static void glGetQueryiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetQueryiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glGetQueryObjectiv(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetQueryObjectiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(id, pname, params, __functionAddress);
    }

    public static void glGetQueryObjectuiv(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") int[] params) {
        long __functionAddress = GL.getICD().glGetQueryObjectuiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(id, pname, params, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

