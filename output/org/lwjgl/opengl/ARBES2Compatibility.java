/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL41C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBES2Compatibility {
    public static final int GL_SHADER_COMPILER = 36346;
    public static final int GL_SHADER_BINARY_FORMATS = 36344;
    public static final int GL_NUM_SHADER_BINARY_FORMATS = 36345;
    public static final int GL_MAX_VERTEX_UNIFORM_VECTORS = 36347;
    public static final int GL_MAX_VARYING_VECTORS = 36348;
    public static final int GL_MAX_FRAGMENT_UNIFORM_VECTORS = 36349;
    public static final int GL_IMPLEMENTATION_COLOR_READ_TYPE = 35738;
    public static final int GL_IMPLEMENTATION_COLOR_READ_FORMAT = 35739;
    public static final int GL_FIXED = 5132;
    public static final int GL_LOW_FLOAT = 36336;
    public static final int GL_MEDIUM_FLOAT = 36337;
    public static final int GL_HIGH_FLOAT = 36338;
    public static final int GL_LOW_INT = 36339;
    public static final int GL_MEDIUM_INT = 36340;
    public static final int GL_HIGH_INT = 36341;
    public static final int GL_RGB565 = 36194;

    protected ARBES2Compatibility() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glReleaseShaderCompiler, caps.glShaderBinary, caps.glGetShaderPrecisionFormat, caps.glDepthRangef, caps.glClearDepthf);
    }

    public static void glReleaseShaderCompiler() {
        GL41C.glReleaseShaderCompiler();
    }

    public static void nglShaderBinary(int count, long shaders, int binaryformat, long binary, int length) {
        GL41C.nglShaderBinary(count, shaders, binaryformat, binary, length);
    }

    public static void glShaderBinary(@NativeType(value="GLuint const *") IntBuffer shaders, @NativeType(value="GLenum") int binaryformat, @NativeType(value="void const *") ByteBuffer binary) {
        GL41C.glShaderBinary(shaders, binaryformat, binary);
    }

    public static void nglGetShaderPrecisionFormat(int shadertype, int precisiontype, long range, long precision) {
        GL41C.nglGetShaderPrecisionFormat(shadertype, precisiontype, range, precision);
    }

    public static void glGetShaderPrecisionFormat(@NativeType(value="GLenum") int shadertype, @NativeType(value="GLenum") int precisiontype, @NativeType(value="GLint *") IntBuffer range, @NativeType(value="GLint *") IntBuffer precision) {
        GL41C.glGetShaderPrecisionFormat(shadertype, precisiontype, range, precision);
    }

    @NativeType(value="void")
    public static int glGetShaderPrecisionFormat(@NativeType(value="GLenum") int shadertype, @NativeType(value="GLenum") int precisiontype, @NativeType(value="GLint *") IntBuffer range) {
        return GL41C.glGetShaderPrecisionFormat(shadertype, precisiontype, range);
    }

    public static void glDepthRangef(@NativeType(value="GLfloat") float zNear, @NativeType(value="GLfloat") float zFar) {
        GL41C.glDepthRangef(zNear, zFar);
    }

    public static void glClearDepthf(@NativeType(value="GLfloat") float depth) {
        GL41C.glClearDepthf(depth);
    }

    public static void glShaderBinary(@NativeType(value="GLuint const *") int[] shaders, @NativeType(value="GLenum") int binaryformat, @NativeType(value="void const *") ByteBuffer binary) {
        GL41C.glShaderBinary(shaders, binaryformat, binary);
    }

    public static void glGetShaderPrecisionFormat(@NativeType(value="GLenum") int shadertype, @NativeType(value="GLenum") int precisiontype, @NativeType(value="GLint *") int[] range, @NativeType(value="GLint *") int[] precision) {
        GL41C.glGetShaderPrecisionFormat(shadertype, precisiontype, range, precision);
    }

    static {
        GL.initialize();
    }
}

