/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL30C;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL31C
extends GL30C {
    public static final int GL_R8_SNORM = 36756;
    public static final int GL_RG8_SNORM = 36757;
    public static final int GL_RGB8_SNORM = 36758;
    public static final int GL_RGBA8_SNORM = 36759;
    public static final int GL_R16_SNORM = 36760;
    public static final int GL_RG16_SNORM = 36761;
    public static final int GL_RGB16_SNORM = 36762;
    public static final int GL_RGBA16_SNORM = 36763;
    public static final int GL_SIGNED_NORMALIZED = 36764;
    public static final int GL_SAMPLER_BUFFER = 36290;
    public static final int GL_INT_SAMPLER_2D_RECT = 36301;
    public static final int GL_INT_SAMPLER_BUFFER = 36304;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_RECT = 36309;
    public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER = 36312;
    public static final int GL_COPY_READ_BUFFER = 36662;
    public static final int GL_COPY_WRITE_BUFFER = 36663;
    public static final int GL_PRIMITIVE_RESTART = 36765;
    public static final int GL_PRIMITIVE_RESTART_INDEX = 36766;
    public static final int GL_TEXTURE_BUFFER = 35882;
    public static final int GL_MAX_TEXTURE_BUFFER_SIZE = 35883;
    public static final int GL_TEXTURE_BINDING_BUFFER = 35884;
    public static final int GL_TEXTURE_BUFFER_DATA_STORE_BINDING = 35885;
    public static final int GL_TEXTURE_RECTANGLE = 34037;
    public static final int GL_TEXTURE_BINDING_RECTANGLE = 34038;
    public static final int GL_PROXY_TEXTURE_RECTANGLE = 34039;
    public static final int GL_MAX_RECTANGLE_TEXTURE_SIZE = 34040;
    public static final int GL_SAMPLER_2D_RECT = 35683;
    public static final int GL_SAMPLER_2D_RECT_SHADOW = 35684;
    public static final int GL_UNIFORM_BUFFER = 35345;
    public static final int GL_UNIFORM_BUFFER_BINDING = 35368;
    public static final int GL_UNIFORM_BUFFER_START = 35369;
    public static final int GL_UNIFORM_BUFFER_SIZE = 35370;
    public static final int GL_MAX_VERTEX_UNIFORM_BLOCKS = 35371;
    public static final int GL_MAX_GEOMETRY_UNIFORM_BLOCKS = 35372;
    public static final int GL_MAX_FRAGMENT_UNIFORM_BLOCKS = 35373;
    public static final int GL_MAX_COMBINED_UNIFORM_BLOCKS = 35374;
    public static final int GL_MAX_UNIFORM_BUFFER_BINDINGS = 35375;
    public static final int GL_MAX_UNIFORM_BLOCK_SIZE = 35376;
    public static final int GL_MAX_COMBINED_VERTEX_UNIFORM_COMPONENTS = 35377;
    public static final int GL_MAX_COMBINED_GEOMETRY_UNIFORM_COMPONENTS = 35378;
    public static final int GL_MAX_COMBINED_FRAGMENT_UNIFORM_COMPONENTS = 35379;
    public static final int GL_UNIFORM_BUFFER_OFFSET_ALIGNMENT = 35380;
    public static final int GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH = 35381;
    public static final int GL_ACTIVE_UNIFORM_BLOCKS = 35382;
    public static final int GL_UNIFORM_TYPE = 35383;
    public static final int GL_UNIFORM_SIZE = 35384;
    public static final int GL_UNIFORM_NAME_LENGTH = 35385;
    public static final int GL_UNIFORM_BLOCK_INDEX = 35386;
    public static final int GL_UNIFORM_OFFSET = 35387;
    public static final int GL_UNIFORM_ARRAY_STRIDE = 35388;
    public static final int GL_UNIFORM_MATRIX_STRIDE = 35389;
    public static final int GL_UNIFORM_IS_ROW_MAJOR = 35390;
    public static final int GL_UNIFORM_BLOCK_BINDING = 35391;
    public static final int GL_UNIFORM_BLOCK_DATA_SIZE = 35392;
    public static final int GL_UNIFORM_BLOCK_NAME_LENGTH = 35393;
    public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS = 35394;
    public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES = 35395;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER = 35396;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER = 35397;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER = 35398;
    public static final int GL_INVALID_INDEX = -1;

    protected GL31C() {
        throw new UnsupportedOperationException();
    }

    public static native void glDrawArraysInstanced(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLsizei") int var2, @NativeType(value="GLsizei") int var3);

    public static native void nglDrawElementsInstanced(int var0, int var1, int var2, long var3, int var5);

    public static void glDrawElementsInstanced(@NativeType(value="GLenum") int mode, @NativeType(value="GLsizei") int count, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long indices, @NativeType(value="GLsizei") int primcount) {
        GL31C.nglDrawElementsInstanced(mode, count, type, indices, primcount);
    }

    public static void glDrawElementsInstanced(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer indices, @NativeType(value="GLsizei") int primcount) {
        GL31C.nglDrawElementsInstanced(mode, indices.remaining() >> GLChecks.typeToByteShift(type), type, MemoryUtil.memAddress(indices), primcount);
    }

    public static void glDrawElementsInstanced(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ByteBuffer indices, @NativeType(value="GLsizei") int primcount) {
        GL31C.nglDrawElementsInstanced(mode, indices.remaining(), 5121, MemoryUtil.memAddress(indices), primcount);
    }

    public static void glDrawElementsInstanced(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ShortBuffer indices, @NativeType(value="GLsizei") int primcount) {
        GL31C.nglDrawElementsInstanced(mode, indices.remaining(), 5123, MemoryUtil.memAddress(indices), primcount);
    }

    public static void glDrawElementsInstanced(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") IntBuffer indices, @NativeType(value="GLsizei") int primcount) {
        GL31C.nglDrawElementsInstanced(mode, indices.remaining(), 5125, MemoryUtil.memAddress(indices), primcount);
    }

    public static native void glCopyBufferSubData(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLintptr") long var2, @NativeType(value="GLintptr") long var4, @NativeType(value="GLsizeiptr") long var6);

    public static native void glPrimitiveRestartIndex(@NativeType(value="GLuint") int var0);

    public static native void glTexBuffer(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2);

    public static native void nglGetUniformIndices(int var0, int var1, long var2, long var4);

    public static void glGetUniformIndices(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const **") PointerBuffer uniformNames, @NativeType(value="GLuint *") IntBuffer uniformIndices) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)uniformIndices, uniformNames.remaining());
        }
        GL31C.nglGetUniformIndices(program, uniformNames.remaining(), MemoryUtil.memAddress(uniformNames), MemoryUtil.memAddress(uniformIndices));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glGetUniformIndices(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const **") CharSequence[] uniformNames, @NativeType(value="GLuint *") IntBuffer uniformIndices) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)uniformIndices, uniformNames.length);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            long uniformNamesAddress = APIUtil.apiArray(stack, MemoryUtil::memASCII, uniformNames);
            GL31C.nglGetUniformIndices(program, uniformNames.length, uniformNamesAddress, MemoryUtil.memAddress(uniformIndices));
            APIUtil.apiArrayFree(uniformNamesAddress, uniformNames.length);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetUniformIndices(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const **") CharSequence uniformName) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            long uniformNamesAddress = APIUtil.apiArray(stack, MemoryUtil::memASCII, uniformName);
            IntBuffer uniformIndices = stack.callocInt(1);
            GL31C.nglGetUniformIndices(program, 1, uniformNamesAddress, MemoryUtil.memAddress(uniformIndices));
            APIUtil.apiArrayFree(uniformNamesAddress, 1);
            int n = uniformIndices.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetActiveUniformsiv(int var0, int var1, long var2, int var4, long var5);

    public static void glGetActiveUniformsiv(@NativeType(value="GLuint") int program, @NativeType(value="GLuint const *") IntBuffer uniformIndices, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, uniformIndices.remaining());
        }
        GL31C.nglGetActiveUniformsiv(program, uniformIndices.remaining(), MemoryUtil.memAddress(uniformIndices), pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetActiveUniformsi(@NativeType(value="GLuint") int program, @NativeType(value="GLuint const *") int uniformIndex, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            IntBuffer uniformIndices = stack.ints(uniformIndex);
            GL31C.nglGetActiveUniformsiv(program, 1, MemoryUtil.memAddress(uniformIndices), pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetActiveUniformName(int var0, int var1, int var2, long var3, long var5);

    public static void glGetActiveUniformName(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformIndex, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer uniformName) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, 1);
        }
        GL31C.nglGetActiveUniformName(program, uniformIndex, uniformName.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(uniformName));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetActiveUniformName(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformIndex, @NativeType(value="GLsizei") int bufSize) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer length = stack.ints(0);
            ByteBuffer uniformName = stack.malloc(bufSize);
            GL31C.nglGetActiveUniformName(program, uniformIndex, bufSize, MemoryUtil.memAddress(length), MemoryUtil.memAddress(uniformName));
            String string = MemoryUtil.memASCII(uniformName, length.get(0));
            return string;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="void")
    public static String glGetActiveUniformName(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformIndex) {
        return GL31C.glGetActiveUniformName(program, uniformIndex, GL31C.glGetActiveUniformsi(program, uniformIndex, 35385));
    }

    public static native int nglGetUniformBlockIndex(int var0, long var1);

    @NativeType(value="GLuint")
    public static int glGetUniformBlockIndex(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") ByteBuffer uniformBlockName) {
        if (Checks.CHECKS) {
            Checks.checkNT1(uniformBlockName);
        }
        return GL31C.nglGetUniformBlockIndex(program, MemoryUtil.memAddress(uniformBlockName));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLuint")
    public static int glGetUniformBlockIndex(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") CharSequence uniformBlockName) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(uniformBlockName, true);
            long uniformBlockNameEncoded = stack.getPointerAddress();
            int n = GL31C.nglGetUniformBlockIndex(program, uniformBlockNameEncoded);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetActiveUniformBlockiv(int var0, int var1, int var2, long var3);

    public static void glGetActiveUniformBlockiv(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformBlockIndex, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL31C.nglGetActiveUniformBlockiv(program, uniformBlockIndex, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetActiveUniformBlocki(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformBlockIndex, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL31C.nglGetActiveUniformBlockiv(program, uniformBlockIndex, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetActiveUniformBlockName(int var0, int var1, int var2, long var3, long var5);

    public static void glGetActiveUniformBlockName(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformBlockIndex, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer uniformBlockName) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, 1);
        }
        GL31C.nglGetActiveUniformBlockName(program, uniformBlockIndex, uniformBlockName.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(uniformBlockName));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetActiveUniformBlockName(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformBlockIndex, @NativeType(value="GLsizei") int bufSize) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer length = stack.ints(0);
            ByteBuffer uniformBlockName = stack.malloc(bufSize);
            GL31C.nglGetActiveUniformBlockName(program, uniformBlockIndex, bufSize, MemoryUtil.memAddress(length), MemoryUtil.memAddress(uniformBlockName));
            String string = MemoryUtil.memASCII(uniformBlockName, length.get(0));
            return string;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="void")
    public static String glGetActiveUniformBlockName(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformBlockIndex) {
        return GL31C.glGetActiveUniformBlockName(program, uniformBlockIndex, GL31C.glGetActiveUniformBlocki(program, uniformBlockIndex, 35393));
    }

    public static native void glUniformBlockBinding(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    public static void glGetUniformIndices(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const **") PointerBuffer uniformNames, @NativeType(value="GLuint *") int[] uniformIndices) {
        long __functionAddress = GL.getICD().glGetUniformIndices;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(uniformIndices, uniformNames.remaining());
        }
        JNI.callPPV(program, uniformNames.remaining(), MemoryUtil.memAddress(uniformNames), uniformIndices, __functionAddress);
    }

    public static void glGetActiveUniformsiv(@NativeType(value="GLuint") int program, @NativeType(value="GLuint const *") int[] uniformIndices, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetActiveUniformsiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, uniformIndices.length);
        }
        JNI.callPPV(program, uniformIndices.length, uniformIndices, pname, params, __functionAddress);
    }

    public static void glGetActiveUniformName(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformIndex, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer uniformName) {
        long __functionAddress = GL.getICD().glGetActiveUniformName;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, 1);
        }
        JNI.callPPV(program, uniformIndex, uniformName.remaining(), length, MemoryUtil.memAddress(uniformName), __functionAddress);
    }

    public static void glGetActiveUniformBlockiv(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformBlockIndex, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetActiveUniformBlockiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(program, uniformBlockIndex, pname, params, __functionAddress);
    }

    public static void glGetActiveUniformBlockName(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformBlockIndex, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer uniformBlockName) {
        long __functionAddress = GL.getICD().glGetActiveUniformBlockName;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, 1);
        }
        JNI.callPPV(program, uniformBlockIndex, uniformBlockName.remaining(), length, MemoryUtil.memAddress(uniformBlockName), __functionAddress);
    }

    static {
        GL.initialize();
    }
}

