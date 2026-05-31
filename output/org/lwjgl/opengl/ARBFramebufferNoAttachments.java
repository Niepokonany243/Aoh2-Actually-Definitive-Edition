/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.Set;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBFramebufferNoAttachments {
    public static final int GL_FRAMEBUFFER_DEFAULT_WIDTH = 37648;
    public static final int GL_FRAMEBUFFER_DEFAULT_HEIGHT = 37649;
    public static final int GL_FRAMEBUFFER_DEFAULT_LAYERS = 37650;
    public static final int GL_FRAMEBUFFER_DEFAULT_SAMPLES = 37651;
    public static final int GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS = 37652;
    public static final int GL_MAX_FRAMEBUFFER_WIDTH = 37653;
    public static final int GL_MAX_FRAMEBUFFER_HEIGHT = 37654;
    public static final int GL_MAX_FRAMEBUFFER_LAYERS = 37655;
    public static final int GL_MAX_FRAMEBUFFER_SAMPLES = 37656;

    protected ARBFramebufferNoAttachments() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, Set<String> ext) {
        return Checks.checkFunctions(caps.glFramebufferParameteri, caps.glGetFramebufferParameteriv, ext.contains("GL_EXT_direct_state_access") ? caps.glNamedFramebufferParameteriEXT : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glGetNamedFramebufferParameterivEXT : -1L);
    }

    public static void glFramebufferParameteri(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint") int param) {
        GL43C.glFramebufferParameteri(target, pname, param);
    }

    public static void nglGetFramebufferParameteriv(int target, int pname, long params) {
        GL43C.nglGetFramebufferParameteriv(target, pname, params);
    }

    public static void glGetFramebufferParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL43C.glGetFramebufferParameteriv(target, pname, params);
    }

    @NativeType(value="void")
    public static int glGetFramebufferParameteri(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        return GL43C.glGetFramebufferParameteri(target, pname);
    }

    public static native void glNamedFramebufferParameteriEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2);

    public static native void nglGetNamedFramebufferParameterivEXT(int var0, int var1, long var2);

    public static void glGetNamedFramebufferParameterivEXT(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        ARBFramebufferNoAttachments.nglGetNamedFramebufferParameterivEXT(framebuffer, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetNamedFramebufferParameteriEXT(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            ARBFramebufferNoAttachments.nglGetNamedFramebufferParameterivEXT(framebuffer, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glGetFramebufferParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL43C.glGetFramebufferParameteriv(target, pname, params);
    }

    public static void glGetNamedFramebufferParameterivEXT(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetNamedFramebufferParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(framebuffer, pname, params, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

