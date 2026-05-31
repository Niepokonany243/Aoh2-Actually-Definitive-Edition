/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBOcclusionQuery {
    public static final int GL_SAMPLES_PASSED_ARB = 35092;
    public static final int GL_QUERY_COUNTER_BITS_ARB = 34916;
    public static final int GL_CURRENT_QUERY_ARB = 34917;
    public static final int GL_QUERY_RESULT_ARB = 34918;
    public static final int GL_QUERY_RESULT_AVAILABLE_ARB = 34919;

    protected ARBOcclusionQuery() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glGenQueriesARB, caps.glDeleteQueriesARB, caps.glIsQueryARB, caps.glBeginQueryARB, caps.glEndQueryARB, caps.glGetQueryivARB, caps.glGetQueryObjectivARB, caps.glGetQueryObjectuivARB);
    }

    public static native void nglGenQueriesARB(int var0, long var1);

    public static void glGenQueriesARB(@NativeType(value="GLuint *") IntBuffer ids) {
        ARBOcclusionQuery.nglGenQueriesARB(ids.remaining(), MemoryUtil.memAddress(ids));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGenQueriesARB() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer ids = stack.callocInt(1);
            ARBOcclusionQuery.nglGenQueriesARB(1, MemoryUtil.memAddress(ids));
            int n = ids.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglDeleteQueriesARB(int var0, long var1);

    public static void glDeleteQueriesARB(@NativeType(value="GLuint const *") IntBuffer ids) {
        ARBOcclusionQuery.nglDeleteQueriesARB(ids.remaining(), MemoryUtil.memAddress(ids));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDeleteQueriesARB(@NativeType(value="GLuint const *") int id) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer ids = stack.ints(id);
            ARBOcclusionQuery.nglDeleteQueriesARB(1, MemoryUtil.memAddress(ids));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="GLboolean")
    public static native boolean glIsQueryARB(@NativeType(value="GLuint") int var0);

    public static native void glBeginQueryARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glEndQueryARB(@NativeType(value="GLenum") int var0);

    public static native void nglGetQueryivARB(int var0, int var1, long var2);

    public static void glGetQueryivARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        ARBOcclusionQuery.nglGetQueryivARB(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetQueryiARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            ARBOcclusionQuery.nglGetQueryivARB(target, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetQueryObjectivARB(int var0, int var1, long var2);

    public static void glGetQueryObjectivARB(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        ARBOcclusionQuery.nglGetQueryObjectivARB(id, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetQueryObjectiARB(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            ARBOcclusionQuery.nglGetQueryObjectivARB(id, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetQueryObjectuivARB(int var0, int var1, long var2);

    public static void glGetQueryObjectuivARB(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        ARBOcclusionQuery.nglGetQueryObjectuivARB(id, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetQueryObjectuiARB(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            ARBOcclusionQuery.nglGetQueryObjectuivARB(id, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glGenQueriesARB(@NativeType(value="GLuint *") int[] ids) {
        long __functionAddress = GL.getICD().glGenQueriesARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(ids.length, ids, __functionAddress);
    }

    public static void glDeleteQueriesARB(@NativeType(value="GLuint const *") int[] ids) {
        long __functionAddress = GL.getICD().glDeleteQueriesARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(ids.length, ids, __functionAddress);
    }

    public static void glGetQueryivARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetQueryivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glGetQueryObjectivARB(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetQueryObjectivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(id, pname, params, __functionAddress);
    }

    public static void glGetQueryObjectuivARB(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") int[] params) {
        long __functionAddress = GL.getICD().glGetQueryObjectuivARB;
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

