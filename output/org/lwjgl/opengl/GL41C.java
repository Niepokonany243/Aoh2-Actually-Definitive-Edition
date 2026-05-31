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
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL40C;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL41C
extends GL40C {
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
    public static final int GL_PROGRAM_BINARY_RETRIEVABLE_HINT = 33367;
    public static final int GL_PROGRAM_BINARY_LENGTH = 34625;
    public static final int GL_NUM_PROGRAM_BINARY_FORMATS = 34814;
    public static final int GL_PROGRAM_BINARY_FORMATS = 34815;
    public static final int GL_VERTEX_SHADER_BIT = 1;
    public static final int GL_FRAGMENT_SHADER_BIT = 2;
    public static final int GL_GEOMETRY_SHADER_BIT = 4;
    public static final int GL_TESS_CONTROL_SHADER_BIT = 8;
    public static final int GL_TESS_EVALUATION_SHADER_BIT = 16;
    public static final int GL_ALL_SHADER_BITS = -1;
    public static final int GL_PROGRAM_SEPARABLE = 33368;
    public static final int GL_ACTIVE_PROGRAM = 33369;
    public static final int GL_PROGRAM_PIPELINE_BINDING = 33370;
    public static final int GL_MAX_VIEWPORTS = 33371;
    public static final int GL_VIEWPORT_SUBPIXEL_BITS = 33372;
    public static final int GL_VIEWPORT_BOUNDS_RANGE = 33373;
    public static final int GL_LAYER_PROVOKING_VERTEX = 33374;
    public static final int GL_VIEWPORT_INDEX_PROVOKING_VERTEX = 33375;
    public static final int GL_UNDEFINED_VERTEX = 33376;

    protected GL41C() {
        throw new UnsupportedOperationException();
    }

    public static native void glReleaseShaderCompiler();

    public static native void nglShaderBinary(int var0, long var1, int var3, long var4, int var6);

    public static void glShaderBinary(@NativeType(value="GLuint const *") IntBuffer shaders, @NativeType(value="GLenum") int binaryformat, @NativeType(value="void const *") ByteBuffer binary) {
        GL41C.nglShaderBinary(shaders.remaining(), MemoryUtil.memAddress(shaders), binaryformat, MemoryUtil.memAddress(binary), binary.remaining());
    }

    public static native void nglGetShaderPrecisionFormat(int var0, int var1, long var2, long var4);

    public static void glGetShaderPrecisionFormat(@NativeType(value="GLenum") int shadertype, @NativeType(value="GLenum") int precisiontype, @NativeType(value="GLint *") IntBuffer range, @NativeType(value="GLint *") IntBuffer precision) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)range, 2);
            Checks.check((Buffer)precision, 1);
        }
        GL41C.nglGetShaderPrecisionFormat(shadertype, precisiontype, MemoryUtil.memAddress(range), MemoryUtil.memAddress(precision));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetShaderPrecisionFormat(@NativeType(value="GLenum") int shadertype, @NativeType(value="GLenum") int precisiontype, @NativeType(value="GLint *") IntBuffer range) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)range, 2);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer precision = stack.callocInt(1);
            GL41C.nglGetShaderPrecisionFormat(shadertype, precisiontype, MemoryUtil.memAddress(range), MemoryUtil.memAddress(precision));
            int n = precision.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glDepthRangef(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1);

    public static native void glClearDepthf(@NativeType(value="GLfloat") float var0);

    public static native void nglGetProgramBinary(int var0, int var1, long var2, long var4, long var6);

    public static void glGetProgramBinary(@NativeType(value="GLuint") int program, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLenum *") IntBuffer binaryFormat, @NativeType(value="void *") ByteBuffer binary) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, 1);
            Checks.check((Buffer)binaryFormat, 1);
        }
        GL41C.nglGetProgramBinary(program, binary.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(binaryFormat), MemoryUtil.memAddress(binary));
    }

    public static native void nglProgramBinary(int var0, int var1, long var2, int var4);

    public static void glProgramBinary(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int binaryFormat, @NativeType(value="void const *") ByteBuffer binary) {
        GL41C.nglProgramBinary(program, binaryFormat, MemoryUtil.memAddress(binary), binary.remaining());
    }

    public static native void glProgramParameteri(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2);

    public static native void glUseProgramStages(@NativeType(value="GLuint") int var0, @NativeType(value="GLbitfield") int var1, @NativeType(value="GLuint") int var2);

    public static native void glActiveShaderProgram(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native int nglCreateShaderProgramv(int var0, int var1, long var2);

    @NativeType(value="GLuint")
    public static int glCreateShaderProgramv(@NativeType(value="GLenum") int type, @NativeType(value="GLchar const **") PointerBuffer strings) {
        return GL41C.nglCreateShaderProgramv(type, strings.remaining(), MemoryUtil.memAddress(strings));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLuint")
    public static int glCreateShaderProgramv(@NativeType(value="GLenum") int type, CharSequence ... strings) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            long stringsAddress = APIUtil.apiArray(stack, MemoryUtil::memUTF8, strings);
            int __result = GL41C.nglCreateShaderProgramv(type, strings.length, stringsAddress);
            APIUtil.apiArrayFree(stringsAddress, strings.length);
            int n = __result;
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLuint")
    public static int glCreateShaderProgramv(@NativeType(value="GLenum") int type, @NativeType(value="GLchar const **") CharSequence string) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            long stringsAddress = APIUtil.apiArray(stack, MemoryUtil::memUTF8, string);
            int __result = GL41C.nglCreateShaderProgramv(type, 1, stringsAddress);
            APIUtil.apiArrayFree(stringsAddress, 1);
            int n = __result;
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glBindProgramPipeline(@NativeType(value="GLuint") int var0);

    public static native void nglDeleteProgramPipelines(int var0, long var1);

    public static void glDeleteProgramPipelines(@NativeType(value="GLuint const *") IntBuffer pipelines) {
        GL41C.nglDeleteProgramPipelines(pipelines.remaining(), MemoryUtil.memAddress(pipelines));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDeleteProgramPipelines(@NativeType(value="GLuint const *") int pipeline) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer pipelines = stack.ints(pipeline);
            GL41C.nglDeleteProgramPipelines(1, MemoryUtil.memAddress(pipelines));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGenProgramPipelines(int var0, long var1);

    public static void glGenProgramPipelines(@NativeType(value="GLuint *") IntBuffer pipelines) {
        GL41C.nglGenProgramPipelines(pipelines.remaining(), MemoryUtil.memAddress(pipelines));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGenProgramPipelines() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer pipelines = stack.callocInt(1);
            GL41C.nglGenProgramPipelines(1, MemoryUtil.memAddress(pipelines));
            int n = pipelines.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="GLboolean")
    public static native boolean glIsProgramPipeline(@NativeType(value="GLuint") int var0);

    public static native void nglGetProgramPipelineiv(int var0, int var1, long var2);

    public static void glGetProgramPipelineiv(@NativeType(value="GLuint") int pipeline, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL41C.nglGetProgramPipelineiv(pipeline, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetProgramPipelinei(@NativeType(value="GLuint") int pipeline, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL41C.nglGetProgramPipelineiv(pipeline, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glProgramUniform1i(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void glProgramUniform2i(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3);

    public static native void glProgramUniform3i(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4);

    public static native void glProgramUniform4i(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5);

    public static native void glProgramUniform1ui(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint") int var2);

    public static native void glProgramUniform2ui(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLuint") int var3);

    public static native void glProgramUniform3ui(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLuint") int var3, @NativeType(value="GLuint") int var4);

    public static native void glProgramUniform4ui(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLuint") int var3, @NativeType(value="GLuint") int var4, @NativeType(value="GLuint") int var5);

    public static native void glProgramUniform1f(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLfloat") float var2);

    public static native void glProgramUniform2f(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    public static native void glProgramUniform3f(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLfloat") float var4);

    public static native void glProgramUniform4f(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLfloat") float var4, @NativeType(value="GLfloat") float var5);

    public static native void glProgramUniform1d(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLdouble") double var2);

    public static native void glProgramUniform2d(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4);

    public static native void glProgramUniform3d(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4, @NativeType(value="GLdouble") double var6);

    public static native void glProgramUniform4d(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4, @NativeType(value="GLdouble") double var6, @NativeType(value="GLdouble") double var8);

    public static native void nglProgramUniform1iv(int var0, int var1, int var2, long var3);

    public static void glProgramUniform1iv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        GL41C.nglProgramUniform1iv(program, location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform2iv(int var0, int var1, int var2, long var3);

    public static void glProgramUniform2iv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        GL41C.nglProgramUniform2iv(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform3iv(int var0, int var1, int var2, long var3);

    public static void glProgramUniform3iv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        GL41C.nglProgramUniform3iv(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform4iv(int var0, int var1, int var2, long var3);

    public static void glProgramUniform4iv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        GL41C.nglProgramUniform4iv(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform1uiv(int var0, int var1, int var2, long var3);

    public static void glProgramUniform1uiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        GL41C.nglProgramUniform1uiv(program, location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform2uiv(int var0, int var1, int var2, long var3);

    public static void glProgramUniform2uiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        GL41C.nglProgramUniform2uiv(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform3uiv(int var0, int var1, int var2, long var3);

    public static void glProgramUniform3uiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        GL41C.nglProgramUniform3uiv(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform4uiv(int var0, int var1, int var2, long var3);

    public static void glProgramUniform4uiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        GL41C.nglProgramUniform4uiv(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform1fv(int var0, int var1, int var2, long var3);

    public static void glProgramUniform1fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.nglProgramUniform1fv(program, location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform2fv(int var0, int var1, int var2, long var3);

    public static void glProgramUniform2fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.nglProgramUniform2fv(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform3fv(int var0, int var1, int var2, long var3);

    public static void glProgramUniform3fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.nglProgramUniform3fv(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform4fv(int var0, int var1, int var2, long var3);

    public static void glProgramUniform4fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.nglProgramUniform4fv(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform1dv(int var0, int var1, int var2, long var3);

    public static void glProgramUniform1dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.nglProgramUniform1dv(program, location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform2dv(int var0, int var1, int var2, long var3);

    public static void glProgramUniform2dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.nglProgramUniform2dv(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform3dv(int var0, int var1, int var2, long var3);

    public static void glProgramUniform3dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.nglProgramUniform3dv(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform4dv(int var0, int var1, int var2, long var3);

    public static void glProgramUniform4dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.nglProgramUniform4dv(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix2fv(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix2fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.nglProgramUniformMatrix2fv(program, location, value.remaining() >> 2, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix3fv(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix3fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.nglProgramUniformMatrix3fv(program, location, value.remaining() / 9, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix4fv(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix4fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.nglProgramUniformMatrix4fv(program, location, value.remaining() >> 4, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix2dv(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix2dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.nglProgramUniformMatrix2dv(program, location, value.remaining() >> 2, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix3dv(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix3dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.nglProgramUniformMatrix3dv(program, location, value.remaining() / 9, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix4dv(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix4dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.nglProgramUniformMatrix4dv(program, location, value.remaining() >> 4, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix2x3fv(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix2x3fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.nglProgramUniformMatrix2x3fv(program, location, value.remaining() / 6, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix3x2fv(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix3x2fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.nglProgramUniformMatrix3x2fv(program, location, value.remaining() / 6, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix2x4fv(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix2x4fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.nglProgramUniformMatrix2x4fv(program, location, value.remaining() >> 3, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix4x2fv(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix4x2fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.nglProgramUniformMatrix4x2fv(program, location, value.remaining() >> 3, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix3x4fv(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix3x4fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.nglProgramUniformMatrix3x4fv(program, location, value.remaining() / 12, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix4x3fv(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix4x3fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL41C.nglProgramUniformMatrix4x3fv(program, location, value.remaining() / 12, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix2x3dv(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix2x3dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.nglProgramUniformMatrix2x3dv(program, location, value.remaining() / 6, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix3x2dv(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix3x2dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.nglProgramUniformMatrix3x2dv(program, location, value.remaining() / 6, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix2x4dv(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix2x4dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.nglProgramUniformMatrix2x4dv(program, location, value.remaining() >> 3, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix4x2dv(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix4x2dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.nglProgramUniformMatrix4x2dv(program, location, value.remaining() >> 3, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix3x4dv(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix3x4dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.nglProgramUniformMatrix3x4dv(program, location, value.remaining() / 12, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix4x3dv(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix4x3dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") DoubleBuffer value) {
        GL41C.nglProgramUniformMatrix4x3dv(program, location, value.remaining() / 12, transpose, MemoryUtil.memAddress(value));
    }

    public static native void glValidateProgramPipeline(@NativeType(value="GLuint") int var0);

    public static native void nglGetProgramPipelineInfoLog(int var0, int var1, long var2, long var4);

    public static void glGetProgramPipelineInfoLog(@NativeType(value="GLuint") int pipeline, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer infoLog) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, 1);
        }
        GL41C.nglGetProgramPipelineInfoLog(pipeline, infoLog.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(infoLog));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetProgramPipelineInfoLog(@NativeType(value="GLuint") int pipeline, @NativeType(value="GLsizei") int bufSize) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        ByteBuffer infoLog = MemoryUtil.memAlloc(bufSize);
        try {
            IntBuffer length = stack.ints(0);
            GL41C.nglGetProgramPipelineInfoLog(pipeline, bufSize, MemoryUtil.memAddress(length), MemoryUtil.memAddress(infoLog));
            String string = MemoryUtil.memUTF8(infoLog, length.get(0));
            return string;
        }
        finally {
            MemoryUtil.memFree(infoLog);
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="void")
    public static String glGetProgramPipelineInfoLog(@NativeType(value="GLuint") int pipeline) {
        return GL41C.glGetProgramPipelineInfoLog(pipeline, GL41C.glGetProgramPipelinei(pipeline, 35716));
    }

    public static native void glVertexAttribL1d(@NativeType(value="GLuint") int var0, @NativeType(value="GLdouble") double var1);

    public static native void glVertexAttribL2d(@NativeType(value="GLuint") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3);

    public static native void glVertexAttribL3d(@NativeType(value="GLuint") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5);

    public static native void glVertexAttribL4d(@NativeType(value="GLuint") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5, @NativeType(value="GLdouble") double var7);

    public static native void nglVertexAttribL1dv(int var0, long var1);

    public static void glVertexAttribL1dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        GL41C.nglVertexAttribL1dv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribL2dv(int var0, long var1);

    public static void glVertexAttribL2dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        GL41C.nglVertexAttribL2dv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribL3dv(int var0, long var1);

    public static void glVertexAttribL3dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL41C.nglVertexAttribL3dv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribL4dv(int var0, long var1);

    public static void glVertexAttribL4dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL41C.nglVertexAttribL4dv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribLPointer(int var0, int var1, int var2, int var3, long var4);

    public static void glVertexAttribLPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ByteBuffer pointer) {
        GL41C.nglVertexAttribLPointer(index, size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glVertexAttribLPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") long pointer) {
        GL41C.nglVertexAttribLPointer(index, size, type, stride, pointer);
    }

    public static void glVertexAttribLPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") DoubleBuffer pointer) {
        GL41C.nglVertexAttribLPointer(index, size, 5130, stride, MemoryUtil.memAddress(pointer));
    }

    public static native void nglGetVertexAttribLdv(int var0, int var1, long var2);

    public static void glGetVertexAttribLdv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLdouble *") DoubleBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL41C.nglGetVertexAttribLdv(index, pname, MemoryUtil.memAddress(params));
    }

    public static native void nglViewportArrayv(int var0, int var1, long var2);

    public static void glViewportArrayv(@NativeType(value="GLuint") int first, @NativeType(value="GLfloat const *") FloatBuffer v) {
        GL41C.nglViewportArrayv(first, v.remaining() >> 2, MemoryUtil.memAddress(v));
    }

    public static native void glViewportIndexedf(@NativeType(value="GLuint") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLfloat") float var4);

    public static native void nglViewportIndexedfv(int var0, long var1);

    public static void glViewportIndexedfv(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL41C.nglViewportIndexedfv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglScissorArrayv(int var0, int var1, long var2);

    public static void glScissorArrayv(@NativeType(value="GLuint") int first, @NativeType(value="GLint const *") IntBuffer v) {
        GL41C.nglScissorArrayv(first, v.remaining() >> 2, MemoryUtil.memAddress(v));
    }

    public static native void glScissorIndexed(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4);

    public static native void nglScissorIndexedv(int var0, long var1);

    public static void glScissorIndexedv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL41C.nglScissorIndexedv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglDepthRangeArrayv(int var0, int var1, long var2);

    public static void glDepthRangeArrayv(@NativeType(value="GLuint") int first, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        GL41C.nglDepthRangeArrayv(first, v.remaining() >> 1, MemoryUtil.memAddress(v));
    }

    public static native void glDepthRangeIndexed(@NativeType(value="GLuint") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3);

    public static native void nglGetFloati_v(int var0, int var1, long var2);

    public static void glGetFloati_v(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat *") FloatBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 1);
        }
        GL41C.nglGetFloati_v(target, index, MemoryUtil.memAddress(data));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetFloati(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer data = stack.callocFloat(1);
            GL41C.nglGetFloati_v(target, index, MemoryUtil.memAddress(data));
            float f = data.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetDoublei_v(int var0, int var1, long var2);

    public static void glGetDoublei_v(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLdouble *") DoubleBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 1);
        }
        GL41C.nglGetDoublei_v(target, index, MemoryUtil.memAddress(data));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static double glGetDoublei(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            DoubleBuffer data = stack.callocDouble(1);
            GL41C.nglGetDoublei_v(target, index, MemoryUtil.memAddress(data));
            double d = data.get(0);
            return d;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glShaderBinary(@NativeType(value="GLuint const *") int[] shaders, @NativeType(value="GLenum") int binaryformat, @NativeType(value="void const *") ByteBuffer binary) {
        long __functionAddress = GL.getICD().glShaderBinary;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(shaders.length, shaders, binaryformat, MemoryUtil.memAddress(binary), binary.remaining(), __functionAddress);
    }

    public static void glGetShaderPrecisionFormat(@NativeType(value="GLenum") int shadertype, @NativeType(value="GLenum") int precisiontype, @NativeType(value="GLint *") int[] range, @NativeType(value="GLint *") int[] precision) {
        long __functionAddress = GL.getICD().glGetShaderPrecisionFormat;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(range, 2);
            Checks.check(precision, 1);
        }
        JNI.callPPV(shadertype, precisiontype, range, precision, __functionAddress);
    }

    public static void glGetProgramBinary(@NativeType(value="GLuint") int program, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLenum *") int[] binaryFormat, @NativeType(value="void *") ByteBuffer binary) {
        long __functionAddress = GL.getICD().glGetProgramBinary;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, 1);
            Checks.check(binaryFormat, 1);
        }
        JNI.callPPPV(program, binary.remaining(), length, binaryFormat, MemoryUtil.memAddress(binary), __functionAddress);
    }

    public static void glDeleteProgramPipelines(@NativeType(value="GLuint const *") int[] pipelines) {
        long __functionAddress = GL.getICD().glDeleteProgramPipelines;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(pipelines.length, pipelines, __functionAddress);
    }

    public static void glGenProgramPipelines(@NativeType(value="GLuint *") int[] pipelines) {
        long __functionAddress = GL.getICD().glGenProgramPipelines;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(pipelines.length, pipelines, __functionAddress);
    }

    public static void glGetProgramPipelineiv(@NativeType(value="GLuint") int pipeline, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetProgramPipelineiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(pipeline, pname, params, __functionAddress);
    }

    public static void glProgramUniform1iv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        long __functionAddress = GL.getICD().glProgramUniform1iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length, value, __functionAddress);
    }

    public static void glProgramUniform2iv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        long __functionAddress = GL.getICD().glProgramUniform2iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
    }

    public static void glProgramUniform3iv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        long __functionAddress = GL.getICD().glProgramUniform3iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 3, value, __functionAddress);
    }

    public static void glProgramUniform4iv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        long __functionAddress = GL.getICD().glProgramUniform4iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
    }

    public static void glProgramUniform1uiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glProgramUniform1uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length, value, __functionAddress);
    }

    public static void glProgramUniform2uiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glProgramUniform2uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
    }

    public static void glProgramUniform3uiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glProgramUniform3uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 3, value, __functionAddress);
    }

    public static void glProgramUniform4uiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glProgramUniform4uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
    }

    public static void glProgramUniform1fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniform1fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length, value, __functionAddress);
    }

    public static void glProgramUniform2fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniform2fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
    }

    public static void glProgramUniform3fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniform3fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 3, value, __functionAddress);
    }

    public static void glProgramUniform4fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniform4fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
    }

    public static void glProgramUniform1dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniform1dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length, value, __functionAddress);
    }

    public static void glProgramUniform2dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniform2dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
    }

    public static void glProgramUniform3dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniform3dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 3, value, __functionAddress);
    }

    public static void glProgramUniform4dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniform4dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
    }

    public static void glProgramUniformMatrix2fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix2fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 2, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix3fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix3fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 9, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix4fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix4fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 4, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix2dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix2dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 2, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix3dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix3dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 9, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix4dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix4dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 4, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix2x3fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix2x3fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 6, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix3x2fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix3x2fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 6, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix2x4fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix2x4fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 3, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix4x2fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix4x2fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 3, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix3x4fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix3x4fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 12, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix4x3fv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix4x3fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 12, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix2x3dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix2x3dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 6, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix3x2dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix3x2dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 6, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix2x4dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix2x4dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 3, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix4x2dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix4x2dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 3, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix3x4dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix3x4dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 12, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix4x3dv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLdouble const *") double[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix4x3dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 12, transpose, value, __functionAddress);
    }

    public static void glGetProgramPipelineInfoLog(@NativeType(value="GLuint") int pipeline, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer infoLog) {
        long __functionAddress = GL.getICD().glGetProgramPipelineInfoLog;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, 1);
        }
        JNI.callPPV(pipeline, infoLog.remaining(), length, MemoryUtil.memAddress(infoLog), __functionAddress);
    }

    public static void glVertexAttribL1dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glVertexAttribL1dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribL2dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glVertexAttribL2dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribL3dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glVertexAttribL3dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribL4dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glVertexAttribL4dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glGetVertexAttribLdv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLdouble *") double[] params) {
        long __functionAddress = GL.getICD().glGetVertexAttribLdv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(index, pname, params, __functionAddress);
    }

    public static void glViewportArrayv(@NativeType(value="GLuint") int first, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glViewportArrayv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(first, v.length >> 2, v, __functionAddress);
    }

    public static void glViewportIndexedfv(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glViewportIndexedfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glScissorArrayv(@NativeType(value="GLuint") int first, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glScissorArrayv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(first, v.length >> 2, v, __functionAddress);
    }

    public static void glScissorIndexedv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glScissorIndexedv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glDepthRangeArrayv(@NativeType(value="GLuint") int first, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glDepthRangeArrayv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(first, v.length >> 1, v, __functionAddress);
    }

    public static void glGetFloati_v(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat *") float[] data) {
        long __functionAddress = GL.getICD().glGetFloati_v;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(data, 1);
        }
        JNI.callPV(target, index, data, __functionAddress);
    }

    public static void glGetDoublei_v(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLdouble *") double[] data) {
        long __functionAddress = GL.getICD().glGetDoublei_v;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(data, 1);
        }
        JNI.callPV(target, index, data, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

