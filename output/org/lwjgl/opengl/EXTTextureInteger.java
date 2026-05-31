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

public class EXTTextureInteger {
    public static final int GL_RGBA_INTEGER_MODE_EXT = 36254;
    public static final int GL_RGBA32UI_EXT = 36208;
    public static final int GL_RGB32UI_EXT = 36209;
    public static final int GL_ALPHA32UI_EXT = 36210;
    public static final int GL_INTENSITY32UI_EXT = 36211;
    public static final int GL_LUMINANCE32UI_EXT = 36212;
    public static final int GL_LUMINANCE_ALPHA32UI_EXT = 36213;
    public static final int GL_RGBA16UI_EXT = 36214;
    public static final int GL_RGB16UI_EXT = 36215;
    public static final int GL_ALPHA16UI_EXT = 36216;
    public static final int GL_INTENSITY16UI_EXT = 36217;
    public static final int GL_LUMINANCE16UI_EXT = 36218;
    public static final int GL_LUMINANCE_ALPHA16UI_EXT = 36219;
    public static final int GL_RGBA8UI_EXT = 36220;
    public static final int GL_RGB8UI_EXT = 36221;
    public static final int GL_ALPHA8UI_EXT = 36222;
    public static final int GL_INTENSITY8UI_EXT = 36223;
    public static final int GL_LUMINANCE8UI_EXT = 36224;
    public static final int GL_LUMINANCE_ALPHA8UI_EXT = 36225;
    public static final int GL_RGBA32I_EXT = 36226;
    public static final int GL_RGB32I_EXT = 36227;
    public static final int GL_ALPHA32I_EXT = 36228;
    public static final int GL_INTENSITY32I_EXT = 36229;
    public static final int GL_LUMINANCE32I_EXT = 36230;
    public static final int GL_LUMINANCE_ALPHA32I_EXT = 36231;
    public static final int GL_RGBA16I_EXT = 36232;
    public static final int GL_RGB16I_EXT = 36233;
    public static final int GL_ALPHA16I_EXT = 36234;
    public static final int GL_INTENSITY16I_EXT = 36235;
    public static final int GL_LUMINANCE16I_EXT = 36236;
    public static final int GL_LUMINANCE_ALPHA16I_EXT = 36237;
    public static final int GL_RGBA8I_EXT = 36238;
    public static final int GL_RGB8I_EXT = 36239;
    public static final int GL_ALPHA8I_EXT = 36240;
    public static final int GL_INTENSITY8I_EXT = 36241;
    public static final int GL_LUMINANCE8I_EXT = 36242;
    public static final int GL_LUMINANCE_ALPHA8I_EXT = 36243;
    public static final int GL_RED_INTEGER_EXT = 36244;
    public static final int GL_GREEN_INTEGER_EXT = 36245;
    public static final int GL_BLUE_INTEGER_EXT = 36246;
    public static final int GL_ALPHA_INTEGER_EXT = 36247;
    public static final int GL_RGB_INTEGER_EXT = 36248;
    public static final int GL_RGBA_INTEGER_EXT = 36249;
    public static final int GL_BGR_INTEGER_EXT = 36250;
    public static final int GL_BGRA_INTEGER_EXT = 36251;
    public static final int GL_LUMINANCE_INTEGER_EXT = 36252;
    public static final int GL_LUMINANCE_ALPHA_INTEGER_EXT = 36253;

    protected EXTTextureInteger() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glClearColorIiEXT, caps.glClearColorIuiEXT, caps.glTexParameterIivEXT, caps.glTexParameterIuivEXT, caps.glGetTexParameterIivEXT, caps.glGetTexParameterIuivEXT);
    }

    public static native void glClearColorIiEXT(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3);

    public static native void glClearColorIuiEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLuint") int var3);

    public static native void nglTexParameterIivEXT(int var0, int var1, long var2);

    public static void glTexParameterIivEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTTextureInteger.nglTexParameterIivEXT(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glTexParameterIiEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int param) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.ints(param);
            EXTTextureInteger.nglTexParameterIivEXT(target, pname, MemoryUtil.memAddress(params));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglTexParameterIuivEXT(int var0, int var1, long var2);

    public static void glTexParameterIuivEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTTextureInteger.nglTexParameterIuivEXT(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glTexParameterIuiEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") int param) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.ints(param);
            EXTTextureInteger.nglTexParameterIuivEXT(target, pname, MemoryUtil.memAddress(params));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetTexParameterIivEXT(int var0, int var1, long var2);

    public static void glGetTexParameterIivEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTTextureInteger.nglGetTexParameterIivEXT(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTexParameterIiEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            EXTTextureInteger.nglGetTexParameterIivEXT(target, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetTexParameterIuivEXT(int var0, int var1, long var2);

    public static void glGetTexParameterIuivEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTTextureInteger.nglGetTexParameterIuivEXT(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTexParameterIuiEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            EXTTextureInteger.nglGetTexParameterIuivEXT(target, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glTexParameterIivEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glTexParameterIivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glTexParameterIuivEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") int[] params) {
        long __functionAddress = GL.getICD().glTexParameterIuivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glGetTexParameterIivEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetTexParameterIivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glGetTexParameterIuivEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") int[] params) {
        long __functionAddress = GL.getICD().glGetTexParameterIuivEXT;
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

