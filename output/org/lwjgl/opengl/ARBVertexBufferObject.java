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
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBVertexBufferObject {
    public static final int GL_ARRAY_BUFFER_ARB = 34962;
    public static final int GL_ELEMENT_ARRAY_BUFFER_ARB = 34963;
    public static final int GL_ARRAY_BUFFER_BINDING_ARB = 34964;
    public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING_ARB = 34965;
    public static final int GL_VERTEX_ARRAY_BUFFER_BINDING_ARB = 34966;
    public static final int GL_NORMAL_ARRAY_BUFFER_BINDING_ARB = 34967;
    public static final int GL_COLOR_ARRAY_BUFFER_BINDING_ARB = 34968;
    public static final int GL_INDEX_ARRAY_BUFFER_BINDING_ARB = 34969;
    public static final int GL_TEXTURE_COORD_ARRAY_BUFFER_BINDING_ARB = 34970;
    public static final int GL_EDGE_FLAG_ARRAY_BUFFER_BINDING_ARB = 34971;
    public static final int GL_SECONDARY_COLOR_ARRAY_BUFFER_BINDING_ARB = 34972;
    public static final int GL_FOG_COORDINATE_ARRAY_BUFFER_BINDING_ARB = 34973;
    public static final int GL_WEIGHT_ARRAY_BUFFER_BINDING_ARB = 34974;
    public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING_ARB = 34975;
    public static final int GL_STREAM_DRAW_ARB = 35040;
    public static final int GL_STREAM_READ_ARB = 35041;
    public static final int GL_STREAM_COPY_ARB = 35042;
    public static final int GL_STATIC_DRAW_ARB = 35044;
    public static final int GL_STATIC_READ_ARB = 35045;
    public static final int GL_STATIC_COPY_ARB = 35046;
    public static final int GL_DYNAMIC_DRAW_ARB = 35048;
    public static final int GL_DYNAMIC_READ_ARB = 35049;
    public static final int GL_DYNAMIC_COPY_ARB = 35050;
    public static final int GL_READ_ONLY_ARB = 35000;
    public static final int GL_WRITE_ONLY_ARB = 35001;
    public static final int GL_READ_WRITE_ARB = 35002;
    public static final int GL_BUFFER_SIZE_ARB = 34660;
    public static final int GL_BUFFER_USAGE_ARB = 34661;
    public static final int GL_BUFFER_ACCESS_ARB = 35003;
    public static final int GL_BUFFER_MAPPED_ARB = 35004;
    public static final int GL_BUFFER_MAP_POINTER_ARB = 35005;

    protected ARBVertexBufferObject() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glBindBufferARB, caps.glDeleteBuffersARB, caps.glGenBuffersARB, caps.glIsBufferARB, caps.glBufferDataARB, caps.glBufferSubDataARB, caps.glGetBufferSubDataARB, caps.glMapBufferARB, caps.glUnmapBufferARB, caps.glGetBufferParameterivARB, caps.glGetBufferPointervARB);
    }

    public static native void glBindBufferARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglDeleteBuffersARB(int var0, long var1);

    public static void glDeleteBuffersARB(@NativeType(value="GLuint const *") IntBuffer buffers) {
        ARBVertexBufferObject.nglDeleteBuffersARB(buffers.remaining(), MemoryUtil.memAddress(buffers));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDeleteBuffersARB(@NativeType(value="GLuint const *") int buffer) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer buffers = stack.ints(buffer);
            ARBVertexBufferObject.nglDeleteBuffersARB(1, MemoryUtil.memAddress(buffers));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGenBuffersARB(int var0, long var1);

    public static void glGenBuffersARB(@NativeType(value="GLuint *") IntBuffer buffers) {
        ARBVertexBufferObject.nglGenBuffersARB(buffers.remaining(), MemoryUtil.memAddress(buffers));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGenBuffersARB() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer buffers = stack.callocInt(1);
            ARBVertexBufferObject.nglGenBuffersARB(1, MemoryUtil.memAddress(buffers));
            int n = buffers.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="GLboolean")
    public static native boolean glIsBufferARB(@NativeType(value="GLuint") int var0);

    public static native void nglBufferDataARB(int var0, long var1, long var3, int var5);

    public static void glBufferDataARB(@NativeType(value="GLenum") int target, @NativeType(value="GLsizeiptrARB") long size, @NativeType(value="GLenum") int usage) {
        ARBVertexBufferObject.nglBufferDataARB(target, size, 0L, usage);
    }

    public static void glBufferDataARB(@NativeType(value="GLenum") int target, @NativeType(value="void const *") ByteBuffer data, @NativeType(value="GLenum") int usage) {
        ARBVertexBufferObject.nglBufferDataARB(target, data.remaining(), MemoryUtil.memAddress(data), usage);
    }

    public static void glBufferDataARB(@NativeType(value="GLenum") int target, @NativeType(value="void const *") ShortBuffer data, @NativeType(value="GLenum") int usage) {
        ARBVertexBufferObject.nglBufferDataARB(target, Integer.toUnsignedLong(data.remaining()) << 1, MemoryUtil.memAddress(data), usage);
    }

    public static void glBufferDataARB(@NativeType(value="GLenum") int target, @NativeType(value="void const *") IntBuffer data, @NativeType(value="GLenum") int usage) {
        ARBVertexBufferObject.nglBufferDataARB(target, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data), usage);
    }

    public static void glBufferDataARB(@NativeType(value="GLenum") int target, @NativeType(value="void const *") FloatBuffer data, @NativeType(value="GLenum") int usage) {
        ARBVertexBufferObject.nglBufferDataARB(target, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data), usage);
    }

    public static void glBufferDataARB(@NativeType(value="GLenum") int target, @NativeType(value="void const *") DoubleBuffer data, @NativeType(value="GLenum") int usage) {
        ARBVertexBufferObject.nglBufferDataARB(target, Integer.toUnsignedLong(data.remaining()) << 3, MemoryUtil.memAddress(data), usage);
    }

    public static native void nglBufferSubDataARB(int var0, long var1, long var3, long var5);

    public static void glBufferSubDataARB(@NativeType(value="GLenum") int target, @NativeType(value="GLintptrARB") long offset, @NativeType(value="void const *") ByteBuffer data) {
        ARBVertexBufferObject.nglBufferSubDataARB(target, offset, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static void glBufferSubDataARB(@NativeType(value="GLenum") int target, @NativeType(value="GLintptrARB") long offset, @NativeType(value="void const *") ShortBuffer data) {
        ARBVertexBufferObject.nglBufferSubDataARB(target, offset, Integer.toUnsignedLong(data.remaining()) << 1, MemoryUtil.memAddress(data));
    }

    public static void glBufferSubDataARB(@NativeType(value="GLenum") int target, @NativeType(value="GLintptrARB") long offset, @NativeType(value="void const *") IntBuffer data) {
        ARBVertexBufferObject.nglBufferSubDataARB(target, offset, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data));
    }

    public static void glBufferSubDataARB(@NativeType(value="GLenum") int target, @NativeType(value="GLintptrARB") long offset, @NativeType(value="void const *") FloatBuffer data) {
        ARBVertexBufferObject.nglBufferSubDataARB(target, offset, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data));
    }

    public static void glBufferSubDataARB(@NativeType(value="GLenum") int target, @NativeType(value="GLintptrARB") long offset, @NativeType(value="void const *") DoubleBuffer data) {
        ARBVertexBufferObject.nglBufferSubDataARB(target, offset, Integer.toUnsignedLong(data.remaining()) << 3, MemoryUtil.memAddress(data));
    }

    public static native void nglGetBufferSubDataARB(int var0, long var1, long var3, long var5);

    public static void glGetBufferSubDataARB(@NativeType(value="GLenum") int target, @NativeType(value="GLintptrARB") long offset, @NativeType(value="void *") ByteBuffer data) {
        ARBVertexBufferObject.nglGetBufferSubDataARB(target, offset, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static void glGetBufferSubDataARB(@NativeType(value="GLenum") int target, @NativeType(value="GLintptrARB") long offset, @NativeType(value="void *") ShortBuffer data) {
        ARBVertexBufferObject.nglGetBufferSubDataARB(target, offset, Integer.toUnsignedLong(data.remaining()) << 1, MemoryUtil.memAddress(data));
    }

    public static void glGetBufferSubDataARB(@NativeType(value="GLenum") int target, @NativeType(value="GLintptrARB") long offset, @NativeType(value="void *") IntBuffer data) {
        ARBVertexBufferObject.nglGetBufferSubDataARB(target, offset, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data));
    }

    public static void glGetBufferSubDataARB(@NativeType(value="GLenum") int target, @NativeType(value="GLintptrARB") long offset, @NativeType(value="void *") FloatBuffer data) {
        ARBVertexBufferObject.nglGetBufferSubDataARB(target, offset, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data));
    }

    public static void glGetBufferSubDataARB(@NativeType(value="GLenum") int target, @NativeType(value="GLintptrARB") long offset, @NativeType(value="void *") DoubleBuffer data) {
        ARBVertexBufferObject.nglGetBufferSubDataARB(target, offset, Integer.toUnsignedLong(data.remaining()) << 3, MemoryUtil.memAddress(data));
    }

    public static native long nglMapBufferARB(int var0, int var1);

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapBufferARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int access) {
        long __result = ARBVertexBufferObject.nglMapBufferARB(target, access);
        return MemoryUtil.memByteBufferSafe(__result, ARBVertexBufferObject.glGetBufferParameteriARB(target, 34660));
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapBufferARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int access, @Nullable ByteBuffer old_buffer) {
        long __result = ARBVertexBufferObject.nglMapBufferARB(target, access);
        int length = ARBVertexBufferObject.glGetBufferParameteriARB(target, 34660);
        return APIUtil.apiGetMappedBuffer(old_buffer, __result, length);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapBufferARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int access, long length, @Nullable ByteBuffer old_buffer) {
        long __result = ARBVertexBufferObject.nglMapBufferARB(target, access);
        return APIUtil.apiGetMappedBuffer(old_buffer, __result, (int)length);
    }

    @NativeType(value="GLboolean")
    public static native boolean glUnmapBufferARB(@NativeType(value="GLenum") int var0);

    public static native void nglGetBufferParameterivARB(int var0, int var1, long var2);

    public static void glGetBufferParameterivARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        ARBVertexBufferObject.nglGetBufferParameterivARB(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetBufferParameteriARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            ARBVertexBufferObject.nglGetBufferParameterivARB(target, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetBufferPointervARB(int var0, int var1, long var2);

    public static void glGetBufferPointervARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="void **") PointerBuffer params) {
        if (Checks.CHECKS) {
            Checks.check(params, 1);
        }
        ARBVertexBufferObject.nglGetBufferPointervARB(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetBufferPointerARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            PointerBuffer params = stack.callocPointer(1);
            ARBVertexBufferObject.nglGetBufferPointervARB(target, pname, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glDeleteBuffersARB(@NativeType(value="GLuint const *") int[] buffers) {
        long __functionAddress = GL.getICD().glDeleteBuffersARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(buffers.length, buffers, __functionAddress);
    }

    public static void glGenBuffersARB(@NativeType(value="GLuint *") int[] buffers) {
        long __functionAddress = GL.getICD().glGenBuffersARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(buffers.length, buffers, __functionAddress);
    }

    public static void glBufferDataARB(@NativeType(value="GLenum") int target, @NativeType(value="void const *") short[] data, @NativeType(value="GLenum") int usage) {
        long __functionAddress = GL.getICD().glBufferDataARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 1, data, usage, __functionAddress);
    }

    public static void glBufferDataARB(@NativeType(value="GLenum") int target, @NativeType(value="void const *") int[] data, @NativeType(value="GLenum") int usage) {
        long __functionAddress = GL.getICD().glBufferDataARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 2, data, usage, __functionAddress);
    }

    public static void glBufferDataARB(@NativeType(value="GLenum") int target, @NativeType(value="void const *") float[] data, @NativeType(value="GLenum") int usage) {
        long __functionAddress = GL.getICD().glBufferDataARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 2, data, usage, __functionAddress);
    }

    public static void glBufferDataARB(@NativeType(value="GLenum") int target, @NativeType(value="void const *") double[] data, @NativeType(value="GLenum") int usage) {
        long __functionAddress = GL.getICD().glBufferDataARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(target, Integer.toUnsignedLong(data.length) << 3, data, usage, __functionAddress);
    }

    public static void glBufferSubDataARB(@NativeType(value="GLenum") int target, @NativeType(value="GLintptrARB") long offset, @NativeType(value="void const *") short[] data) {
        long __functionAddress = GL.getICD().glBufferSubDataARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 1, data, __functionAddress);
    }

    public static void glBufferSubDataARB(@NativeType(value="GLenum") int target, @NativeType(value="GLintptrARB") long offset, @NativeType(value="void const *") int[] data) {
        long __functionAddress = GL.getICD().glBufferSubDataARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 2, data, __functionAddress);
    }

    public static void glBufferSubDataARB(@NativeType(value="GLenum") int target, @NativeType(value="GLintptrARB") long offset, @NativeType(value="void const *") float[] data) {
        long __functionAddress = GL.getICD().glBufferSubDataARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 2, data, __functionAddress);
    }

    public static void glBufferSubDataARB(@NativeType(value="GLenum") int target, @NativeType(value="GLintptrARB") long offset, @NativeType(value="void const *") double[] data) {
        long __functionAddress = GL.getICD().glBufferSubDataARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 3, data, __functionAddress);
    }

    public static void glGetBufferSubDataARB(@NativeType(value="GLenum") int target, @NativeType(value="GLintptrARB") long offset, @NativeType(value="void *") short[] data) {
        long __functionAddress = GL.getICD().glGetBufferSubDataARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 1, data, __functionAddress);
    }

    public static void glGetBufferSubDataARB(@NativeType(value="GLenum") int target, @NativeType(value="GLintptrARB") long offset, @NativeType(value="void *") int[] data) {
        long __functionAddress = GL.getICD().glGetBufferSubDataARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 2, data, __functionAddress);
    }

    public static void glGetBufferSubDataARB(@NativeType(value="GLenum") int target, @NativeType(value="GLintptrARB") long offset, @NativeType(value="void *") float[] data) {
        long __functionAddress = GL.getICD().glGetBufferSubDataARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 2, data, __functionAddress);
    }

    public static void glGetBufferSubDataARB(@NativeType(value="GLenum") int target, @NativeType(value="GLintptrARB") long offset, @NativeType(value="void *") double[] data) {
        long __functionAddress = GL.getICD().glGetBufferSubDataARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(target, offset, Integer.toUnsignedLong(data.length) << 3, data, __functionAddress);
    }

    public static void glGetBufferParameterivARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetBufferParameterivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

