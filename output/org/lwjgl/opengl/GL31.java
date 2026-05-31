/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL31C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class GL31
extends GL30 {
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

    protected GL31() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glDrawArraysInstanced, caps.glDrawElementsInstanced, caps.glCopyBufferSubData, caps.glPrimitiveRestartIndex, caps.glTexBuffer, caps.glGetUniformIndices, caps.glGetActiveUniformsiv, caps.glGetActiveUniformName, caps.glGetUniformBlockIndex, caps.glGetActiveUniformBlockiv, caps.glGetActiveUniformBlockName, caps.glUniformBlockBinding);
    }

    public static void glDrawArraysInstanced(@NativeType(value="GLenum") int mode, @NativeType(value="GLint") int first, @NativeType(value="GLsizei") int count, @NativeType(value="GLsizei") int primcount) {
        GL31C.glDrawArraysInstanced(mode, first, count, primcount);
    }

    public static void nglDrawElementsInstanced(int mode, int count, int type, long indices, int primcount) {
        GL31C.nglDrawElementsInstanced(mode, count, type, indices, primcount);
    }

    public static void glDrawElementsInstanced(@NativeType(value="GLenum") int mode, @NativeType(value="GLsizei") int count, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long indices, @NativeType(value="GLsizei") int primcount) {
        GL31C.glDrawElementsInstanced(mode, count, type, indices, primcount);
    }

    public static void glDrawElementsInstanced(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer indices, @NativeType(value="GLsizei") int primcount) {
        GL31C.glDrawElementsInstanced(mode, type, indices, primcount);
    }

    public static void glDrawElementsInstanced(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ByteBuffer indices, @NativeType(value="GLsizei") int primcount) {
        GL31C.glDrawElementsInstanced(mode, indices, primcount);
    }

    public static void glDrawElementsInstanced(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ShortBuffer indices, @NativeType(value="GLsizei") int primcount) {
        GL31C.glDrawElementsInstanced(mode, indices, primcount);
    }

    public static void glDrawElementsInstanced(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") IntBuffer indices, @NativeType(value="GLsizei") int primcount) {
        GL31C.glDrawElementsInstanced(mode, indices, primcount);
    }

    public static void glCopyBufferSubData(@NativeType(value="GLenum") int readTarget, @NativeType(value="GLenum") int writeTarget, @NativeType(value="GLintptr") long readOffset, @NativeType(value="GLintptr") long writeOffset, @NativeType(value="GLsizeiptr") long size) {
        GL31C.glCopyBufferSubData(readTarget, writeTarget, readOffset, writeOffset, size);
    }

    public static void glPrimitiveRestartIndex(@NativeType(value="GLuint") int index) {
        GL31C.glPrimitiveRestartIndex(index);
    }

    public static void glTexBuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLuint") int buffer) {
        GL31C.glTexBuffer(target, internalformat, buffer);
    }

    public static void nglGetUniformIndices(int program, int uniformCount, long uniformNames, long uniformIndices) {
        GL31C.nglGetUniformIndices(program, uniformCount, uniformNames, uniformIndices);
    }

    public static void glGetUniformIndices(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const **") PointerBuffer uniformNames, @NativeType(value="GLuint *") IntBuffer uniformIndices) {
        GL31C.glGetUniformIndices(program, uniformNames, uniformIndices);
    }

    public static void glGetUniformIndices(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const **") CharSequence[] uniformNames, @NativeType(value="GLuint *") IntBuffer uniformIndices) {
        GL31C.glGetUniformIndices(program, uniformNames, uniformIndices);
    }

    @NativeType(value="void")
    public static int glGetUniformIndices(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const **") CharSequence uniformName) {
        return GL31C.glGetUniformIndices(program, uniformName);
    }

    public static void nglGetActiveUniformsiv(int program, int uniformCount, long uniformIndices, int pname, long params) {
        GL31C.nglGetActiveUniformsiv(program, uniformCount, uniformIndices, pname, params);
    }

    public static void glGetActiveUniformsiv(@NativeType(value="GLuint") int program, @NativeType(value="GLuint const *") IntBuffer uniformIndices, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL31C.glGetActiveUniformsiv(program, uniformIndices, pname, params);
    }

    @NativeType(value="void")
    public static int glGetActiveUniformsi(@NativeType(value="GLuint") int program, @NativeType(value="GLuint const *") int uniformIndex, @NativeType(value="GLenum") int pname) {
        return GL31C.glGetActiveUniformsi(program, uniformIndex, pname);
    }

    public static void nglGetActiveUniformName(int program, int uniformIndex, int bufSize, long length, long uniformName) {
        GL31C.nglGetActiveUniformName(program, uniformIndex, bufSize, length, uniformName);
    }

    public static void glGetActiveUniformName(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformIndex, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer uniformName) {
        GL31C.glGetActiveUniformName(program, uniformIndex, length, uniformName);
    }

    @NativeType(value="void")
    public static String glGetActiveUniformName(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformIndex, @NativeType(value="GLsizei") int bufSize) {
        return GL31C.glGetActiveUniformName(program, uniformIndex, bufSize);
    }

    @NativeType(value="void")
    public static String glGetActiveUniformName(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformIndex) {
        return GL31.glGetActiveUniformName(program, uniformIndex, GL31.glGetActiveUniformsi(program, uniformIndex, 35385));
    }

    public static int nglGetUniformBlockIndex(int program, long uniformBlockName) {
        return GL31C.nglGetUniformBlockIndex(program, uniformBlockName);
    }

    @NativeType(value="GLuint")
    public static int glGetUniformBlockIndex(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") ByteBuffer uniformBlockName) {
        return GL31C.glGetUniformBlockIndex(program, uniformBlockName);
    }

    @NativeType(value="GLuint")
    public static int glGetUniformBlockIndex(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") CharSequence uniformBlockName) {
        return GL31C.glGetUniformBlockIndex(program, uniformBlockName);
    }

    public static void nglGetActiveUniformBlockiv(int program, int uniformBlockIndex, int pname, long params) {
        GL31C.nglGetActiveUniformBlockiv(program, uniformBlockIndex, pname, params);
    }

    public static void glGetActiveUniformBlockiv(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformBlockIndex, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL31C.glGetActiveUniformBlockiv(program, uniformBlockIndex, pname, params);
    }

    @NativeType(value="void")
    public static int glGetActiveUniformBlocki(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformBlockIndex, @NativeType(value="GLenum") int pname) {
        return GL31C.glGetActiveUniformBlocki(program, uniformBlockIndex, pname);
    }

    public static void nglGetActiveUniformBlockName(int program, int uniformBlockIndex, int bufSize, long length, long uniformBlockName) {
        GL31C.nglGetActiveUniformBlockName(program, uniformBlockIndex, bufSize, length, uniformBlockName);
    }

    public static void glGetActiveUniformBlockName(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformBlockIndex, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer uniformBlockName) {
        GL31C.glGetActiveUniformBlockName(program, uniformBlockIndex, length, uniformBlockName);
    }

    @NativeType(value="void")
    public static String glGetActiveUniformBlockName(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformBlockIndex, @NativeType(value="GLsizei") int bufSize) {
        return GL31C.glGetActiveUniformBlockName(program, uniformBlockIndex, bufSize);
    }

    @NativeType(value="void")
    public static String glGetActiveUniformBlockName(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformBlockIndex) {
        return GL31.glGetActiveUniformBlockName(program, uniformBlockIndex, GL31.glGetActiveUniformBlocki(program, uniformBlockIndex, 35393));
    }

    public static void glUniformBlockBinding(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformBlockIndex, @NativeType(value="GLuint") int uniformBlockBinding) {
        GL31C.glUniformBlockBinding(program, uniformBlockIndex, uniformBlockBinding);
    }

    public static void glGetUniformIndices(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const **") PointerBuffer uniformNames, @NativeType(value="GLuint *") int[] uniformIndices) {
        GL31C.glGetUniformIndices(program, uniformNames, uniformIndices);
    }

    public static void glGetActiveUniformsiv(@NativeType(value="GLuint") int program, @NativeType(value="GLuint const *") int[] uniformIndices, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL31C.glGetActiveUniformsiv(program, uniformIndices, pname, params);
    }

    public static void glGetActiveUniformName(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformIndex, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer uniformName) {
        GL31C.glGetActiveUniformName(program, uniformIndex, length, uniformName);
    }

    public static void glGetActiveUniformBlockiv(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformBlockIndex, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL31C.glGetActiveUniformBlockiv(program, uniformBlockIndex, pname, params);
    }

    public static void glGetActiveUniformBlockName(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int uniformBlockIndex, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer uniformBlockName) {
        GL31C.glGetActiveUniformBlockName(program, uniformBlockIndex, length, uniformBlockName);
    }

    static {
        GL.initialize();
    }
}

