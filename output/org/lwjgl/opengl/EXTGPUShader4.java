/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTGPUShader4 {
    public static final int GL_VERTEX_ATTRIB_ARRAY_INTEGER_EXT = 35069;
    public static final int GL_SAMPLER_1D_ARRAY_EXT = 36288;
    public static final int GL_SAMPLER_2D_ARRAY_EXT = 36289;
    public static final int GL_SAMPLER_BUFFER_EXT = 36290;
    public static final int GL_SAMPLER_1D_ARRAY_SHADOW_EXT = 36291;
    public static final int GL_SAMPLER_2D_ARRAY_SHADOW_EXT = 36292;
    public static final int GL_SAMPLER_CUBE_SHADOW_EXT = 36293;
    public static final int GL_UNSIGNED_INT_VEC2_EXT = 36294;
    public static final int GL_UNSIGNED_INT_VEC3_EXT = 36295;
    public static final int GL_UNSIGNED_INT_VEC4_EXT = 36296;
    public static final int GL_INT_SAMPLER_1D_EXT = 36297;
    public static final int GL_INT_SAMPLER_2D_EXT = 36298;
    public static final int GL_INT_SAMPLER_3D_EXT = 36299;
    public static final int GL_INT_SAMPLER_CUBE_EXT = 36300;
    public static final int GL_INT_SAMPLER_2D_RECT_EXT = 36301;
    public static final int GL_INT_SAMPLER_1D_ARRAY_EXT = 36302;
    public static final int GL_INT_SAMPLER_2D_ARRAY_EXT = 36303;
    public static final int GL_INT_SAMPLER_BUFFER_EXT = 36304;
    public static final int GL_UNSIGNED_INT_SAMPLER_1D_EXT = 36305;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_EXT = 36306;
    public static final int GL_UNSIGNED_INT_SAMPLER_3D_EXT = 36307;
    public static final int GL_UNSIGNED_INT_SAMPLER_CUBE_EXT = 36308;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_RECT_EXT = 36309;
    public static final int GL_UNSIGNED_INT_SAMPLER_1D_ARRAY_EXT = 36310;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_ARRAY_EXT = 36311;
    public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER_EXT = 36312;
    public static final int GL_MIN_PROGRAM_TEXEL_OFFSET_EXT = 35076;
    public static final int GL_MAX_PROGRAM_TEXEL_OFFSET_EXT = 35077;

    protected EXTGPUShader4() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glVertexAttribI1iEXT, caps.glVertexAttribI2iEXT, caps.glVertexAttribI3iEXT, caps.glVertexAttribI4iEXT, caps.glVertexAttribI1uiEXT, caps.glVertexAttribI2uiEXT, caps.glVertexAttribI3uiEXT, caps.glVertexAttribI4uiEXT, caps.glVertexAttribI1ivEXT, caps.glVertexAttribI2ivEXT, caps.glVertexAttribI3ivEXT, caps.glVertexAttribI4ivEXT, caps.glVertexAttribI1uivEXT, caps.glVertexAttribI2uivEXT, caps.glVertexAttribI3uivEXT, caps.glVertexAttribI4uivEXT, caps.glVertexAttribI4bvEXT, caps.glVertexAttribI4svEXT, caps.glVertexAttribI4ubvEXT, caps.glVertexAttribI4usvEXT, caps.glVertexAttribIPointerEXT, caps.glGetVertexAttribIivEXT, caps.glGetVertexAttribIuivEXT, caps.glGetUniformuivEXT, caps.glBindFragDataLocationEXT, caps.glGetFragDataLocationEXT, caps.glUniform1uiEXT, caps.glUniform2uiEXT, caps.glUniform3uiEXT, caps.glUniform4uiEXT, caps.glUniform1uivEXT, caps.glUniform2uivEXT, caps.glUniform3uivEXT, caps.glUniform4uivEXT);
    }

    public static native void glVertexAttribI1iEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1);

    public static native void glVertexAttribI2iEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void glVertexAttribI3iEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3);

    public static native void glVertexAttribI4iEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4);

    public static native void glVertexAttribI1uiEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void glVertexAttribI2uiEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    public static native void glVertexAttribI3uiEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3);

    public static native void glVertexAttribI4uiEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4);

    public static native void nglVertexAttribI1ivEXT(int var0, long var1);

    public static void glVertexAttribI1ivEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        EXTGPUShader4.nglVertexAttribI1ivEXT(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribI2ivEXT(int var0, long var1);

    public static void glVertexAttribI2ivEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        EXTGPUShader4.nglVertexAttribI2ivEXT(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribI3ivEXT(int var0, long var1);

    public static void glVertexAttribI3ivEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        EXTGPUShader4.nglVertexAttribI3ivEXT(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribI4ivEXT(int var0, long var1);

    public static void glVertexAttribI4ivEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        EXTGPUShader4.nglVertexAttribI4ivEXT(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribI1uivEXT(int var0, long var1);

    public static void glVertexAttribI1uivEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        EXTGPUShader4.nglVertexAttribI1uivEXT(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribI2uivEXT(int var0, long var1);

    public static void glVertexAttribI2uivEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        EXTGPUShader4.nglVertexAttribI2uivEXT(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribI3uivEXT(int var0, long var1);

    public static void glVertexAttribI3uivEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        EXTGPUShader4.nglVertexAttribI3uivEXT(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribI4uivEXT(int var0, long var1);

    public static void glVertexAttribI4uivEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        EXTGPUShader4.nglVertexAttribI4uivEXT(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribI4bvEXT(int var0, long var1);

    public static void glVertexAttribI4bvEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLbyte const *") ByteBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        EXTGPUShader4.nglVertexAttribI4bvEXT(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribI4svEXT(int var0, long var1);

    public static void glVertexAttribI4svEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        EXTGPUShader4.nglVertexAttribI4svEXT(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribI4ubvEXT(int var0, long var1);

    public static void glVertexAttribI4ubvEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLbyte const *") ByteBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        EXTGPUShader4.nglVertexAttribI4ubvEXT(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribI4usvEXT(int var0, long var1);

    public static void glVertexAttribI4usvEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        EXTGPUShader4.nglVertexAttribI4usvEXT(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribIPointerEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glVertexAttribIPointerEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ByteBuffer pointer) {
        EXTGPUShader4.nglVertexAttribIPointerEXT(index, size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glVertexAttribIPointerEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") long pointer) {
        EXTGPUShader4.nglVertexAttribIPointerEXT(index, size, type, stride, pointer);
    }

    public static void glVertexAttribIPointerEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ShortBuffer pointer) {
        EXTGPUShader4.nglVertexAttribIPointerEXT(index, size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glVertexAttribIPointerEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") IntBuffer pointer) {
        EXTGPUShader4.nglVertexAttribIPointerEXT(index, size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static native void nglGetVertexAttribIivEXT(int var0, int var1, long var2);

    public static void glGetVertexAttribIivEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        EXTGPUShader4.nglGetVertexAttribIivEXT(index, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetVertexAttribIiEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            EXTGPUShader4.nglGetVertexAttribIivEXT(index, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetVertexAttribIuivEXT(int var0, int var1, long var2);

    public static void glGetVertexAttribIuivEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        EXTGPUShader4.nglGetVertexAttribIuivEXT(index, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetVertexAttribIuiEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            EXTGPUShader4.nglGetVertexAttribIuivEXT(index, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetUniformuivEXT(int var0, int var1, long var2);

    public static void glGetUniformuivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTGPUShader4.nglGetUniformuivEXT(program, location, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetUniformuiEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            EXTGPUShader4.nglGetUniformuivEXT(program, location, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglBindFragDataLocationEXT(int var0, int var1, long var2);

    public static void glBindFragDataLocationEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int color, @NativeType(value="GLchar const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        EXTGPUShader4.nglBindFragDataLocationEXT(program, color, MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glBindFragDataLocationEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int color, @NativeType(value="GLchar const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(name, true);
            long nameEncoded = stack.getPointerAddress();
            EXTGPUShader4.nglBindFragDataLocationEXT(program, color, nameEncoded);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native int nglGetFragDataLocationEXT(int var0, long var1);

    @NativeType(value="GLint")
    public static int glGetFragDataLocationEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return EXTGPUShader4.nglGetFragDataLocationEXT(program, MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLint")
    public static int glGetFragDataLocationEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(name, true);
            long nameEncoded = stack.getPointerAddress();
            int n = EXTGPUShader4.nglGetFragDataLocationEXT(program, nameEncoded);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glUniform1uiEXT(@NativeType(value="GLint") int var0, @NativeType(value="GLuint") int var1);

    public static native void glUniform2uiEXT(@NativeType(value="GLint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    public static native void glUniform3uiEXT(@NativeType(value="GLint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLuint") int var3);

    public static native void glUniform4uiEXT(@NativeType(value="GLint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLuint") int var3, @NativeType(value="GLuint") int var4);

    public static native void nglUniform1uivEXT(int var0, int var1, long var2);

    public static void glUniform1uivEXT(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        EXTGPUShader4.nglUniform1uivEXT(location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void nglUniform2uivEXT(int var0, int var1, long var2);

    public static void glUniform2uivEXT(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        EXTGPUShader4.nglUniform2uivEXT(location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void nglUniform3uivEXT(int var0, int var1, long var2);

    public static void glUniform3uivEXT(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        EXTGPUShader4.nglUniform3uivEXT(location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void nglUniform4uivEXT(int var0, int var1, long var2);

    public static void glUniform4uivEXT(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        EXTGPUShader4.nglUniform4uivEXT(location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static void glVertexAttribI1ivEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttribI1ivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribI2ivEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttribI2ivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribI3ivEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttribI3ivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribI4ivEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttribI4ivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribI1uivEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttribI1uivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribI2uivEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttribI2uivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribI3uivEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttribI3uivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribI4uivEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttribI4uivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribI4svEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttribI4svEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribI4usvEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttribI4usvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribIPointerEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") short[] pointer) {
        long __functionAddress = GL.getICD().glVertexAttribIPointerEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(index, size, type, stride, pointer, __functionAddress);
    }

    public static void glVertexAttribIPointerEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") int[] pointer) {
        long __functionAddress = GL.getICD().glVertexAttribIPointerEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(index, size, type, stride, pointer, __functionAddress);
    }

    public static void glGetVertexAttribIivEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetVertexAttribIivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(index, pname, params, __functionAddress);
    }

    public static void glGetVertexAttribIuivEXT(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") int[] params) {
        long __functionAddress = GL.getICD().glGetVertexAttribIuivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(index, pname, params, __functionAddress);
    }

    public static void glGetUniformuivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint *") int[] params) {
        long __functionAddress = GL.getICD().glGetUniformuivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(program, location, params, __functionAddress);
    }

    public static void glUniform1uivEXT(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glUniform1uivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length, value, __functionAddress);
    }

    public static void glUniform2uivEXT(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glUniform2uivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 1, value, __functionAddress);
    }

    public static void glUniform3uivEXT(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glUniform3uivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length / 3, value, __functionAddress);
    }

    public static void glUniform4uivEXT(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glUniform4uivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 2, value, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

