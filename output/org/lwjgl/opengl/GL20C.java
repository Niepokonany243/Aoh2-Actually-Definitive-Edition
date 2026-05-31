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
import org.lwjgl.opengl.GL15C;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL20C
extends GL15C {
    public static final int GL_SHADING_LANGUAGE_VERSION = 35724;
    public static final int GL_CURRENT_PROGRAM = 35725;
    public static final int GL_SHADER_TYPE = 35663;
    public static final int GL_DELETE_STATUS = 35712;
    public static final int GL_COMPILE_STATUS = 35713;
    public static final int GL_LINK_STATUS = 35714;
    public static final int GL_VALIDATE_STATUS = 35715;
    public static final int GL_INFO_LOG_LENGTH = 35716;
    public static final int GL_ATTACHED_SHADERS = 35717;
    public static final int GL_ACTIVE_UNIFORMS = 35718;
    public static final int GL_ACTIVE_UNIFORM_MAX_LENGTH = 35719;
    public static final int GL_ACTIVE_ATTRIBUTES = 35721;
    public static final int GL_ACTIVE_ATTRIBUTE_MAX_LENGTH = 35722;
    public static final int GL_SHADER_SOURCE_LENGTH = 35720;
    public static final int GL_FLOAT_VEC2 = 35664;
    public static final int GL_FLOAT_VEC3 = 35665;
    public static final int GL_FLOAT_VEC4 = 35666;
    public static final int GL_INT_VEC2 = 35667;
    public static final int GL_INT_VEC3 = 35668;
    public static final int GL_INT_VEC4 = 35669;
    public static final int GL_BOOL = 35670;
    public static final int GL_BOOL_VEC2 = 35671;
    public static final int GL_BOOL_VEC3 = 35672;
    public static final int GL_BOOL_VEC4 = 35673;
    public static final int GL_FLOAT_MAT2 = 35674;
    public static final int GL_FLOAT_MAT3 = 35675;
    public static final int GL_FLOAT_MAT4 = 35676;
    public static final int GL_SAMPLER_1D = 35677;
    public static final int GL_SAMPLER_2D = 35678;
    public static final int GL_SAMPLER_3D = 35679;
    public static final int GL_SAMPLER_CUBE = 35680;
    public static final int GL_SAMPLER_1D_SHADOW = 35681;
    public static final int GL_SAMPLER_2D_SHADOW = 35682;
    public static final int GL_VERTEX_SHADER = 35633;
    public static final int GL_MAX_VERTEX_UNIFORM_COMPONENTS = 35658;
    public static final int GL_MAX_VARYING_FLOATS = 35659;
    public static final int GL_MAX_VERTEX_ATTRIBS = 34921;
    public static final int GL_MAX_TEXTURE_IMAGE_UNITS = 34930;
    public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS = 35660;
    public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = 35661;
    public static final int GL_VERTEX_PROGRAM_POINT_SIZE = 34370;
    public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED = 34338;
    public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE = 34339;
    public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE = 34340;
    public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE = 34341;
    public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED = 34922;
    public static final int GL_CURRENT_VERTEX_ATTRIB = 34342;
    public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER = 34373;
    public static final int GL_FRAGMENT_SHADER = 35632;
    public static final int GL_MAX_FRAGMENT_UNIFORM_COMPONENTS = 35657;
    public static final int GL_FRAGMENT_SHADER_DERIVATIVE_HINT = 35723;
    public static final int GL_MAX_DRAW_BUFFERS = 34852;
    public static final int GL_DRAW_BUFFER0 = 34853;
    public static final int GL_DRAW_BUFFER1 = 34854;
    public static final int GL_DRAW_BUFFER2 = 34855;
    public static final int GL_DRAW_BUFFER3 = 34856;
    public static final int GL_DRAW_BUFFER4 = 34857;
    public static final int GL_DRAW_BUFFER5 = 34858;
    public static final int GL_DRAW_BUFFER6 = 34859;
    public static final int GL_DRAW_BUFFER7 = 34860;
    public static final int GL_DRAW_BUFFER8 = 34861;
    public static final int GL_DRAW_BUFFER9 = 34862;
    public static final int GL_DRAW_BUFFER10 = 34863;
    public static final int GL_DRAW_BUFFER11 = 34864;
    public static final int GL_DRAW_BUFFER12 = 34865;
    public static final int GL_DRAW_BUFFER13 = 34866;
    public static final int GL_DRAW_BUFFER14 = 34867;
    public static final int GL_DRAW_BUFFER15 = 34868;
    public static final int GL_POINT_SPRITE_COORD_ORIGIN = 36000;
    public static final int GL_LOWER_LEFT = 36001;
    public static final int GL_UPPER_LEFT = 36002;
    public static final int GL_BLEND_EQUATION_RGB = 32777;
    public static final int GL_BLEND_EQUATION_ALPHA = 34877;
    public static final int GL_STENCIL_BACK_FUNC = 34816;
    public static final int GL_STENCIL_BACK_FAIL = 34817;
    public static final int GL_STENCIL_BACK_PASS_DEPTH_FAIL = 34818;
    public static final int GL_STENCIL_BACK_PASS_DEPTH_PASS = 34819;
    public static final int GL_STENCIL_BACK_REF = 36003;
    public static final int GL_STENCIL_BACK_VALUE_MASK = 36004;
    public static final int GL_STENCIL_BACK_WRITEMASK = 36005;

    protected GL20C() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="GLuint")
    public static native int glCreateProgram();

    public static native void glDeleteProgram(@NativeType(value="GLuint") int var0);

    @NativeType(value="GLboolean")
    public static native boolean glIsProgram(@NativeType(value="GLuint") int var0);

    @NativeType(value="GLuint")
    public static native int glCreateShader(@NativeType(value="GLenum") int var0);

    public static native void glDeleteShader(@NativeType(value="GLuint") int var0);

    @NativeType(value="GLboolean")
    public static native boolean glIsShader(@NativeType(value="GLuint") int var0);

    public static native void glAttachShader(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void glDetachShader(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglShaderSource(int var0, int var1, long var2, long var4);

    public static void glShaderSource(@NativeType(value="GLuint") int shader, @NativeType(value="GLchar const **") PointerBuffer strings, @Nullable @NativeType(value="GLint const *") IntBuffer length) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, strings.remaining());
        }
        GL20C.nglShaderSource(shader, strings.remaining(), MemoryUtil.memAddress(strings), MemoryUtil.memAddressSafe(length));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glShaderSource(@NativeType(value="GLuint") int shader, CharSequence ... strings) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            long stringsAddress = APIUtil.apiArrayi(stack, MemoryUtil::memUTF8, strings);
            GL20C.nglShaderSource(shader, strings.length, stringsAddress, stringsAddress - (long)(strings.length << 2));
            APIUtil.apiArrayFree(stringsAddress, strings.length);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glShaderSource(@NativeType(value="GLuint") int shader, @NativeType(value="GLchar const **") CharSequence string) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            long stringsAddress = APIUtil.apiArrayi(stack, MemoryUtil::memUTF8, string);
            GL20C.nglShaderSource(shader, 1, stringsAddress, stringsAddress - 4L);
            APIUtil.apiArrayFree(stringsAddress, 1);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glCompileShader(@NativeType(value="GLuint") int var0);

    public static native void glLinkProgram(@NativeType(value="GLuint") int var0);

    public static native void glUseProgram(@NativeType(value="GLuint") int var0);

    public static native void glValidateProgram(@NativeType(value="GLuint") int var0);

    public static native void glUniform1f(@NativeType(value="GLint") int var0, @NativeType(value="GLfloat") float var1);

    public static native void glUniform2f(@NativeType(value="GLint") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    public static native void glUniform3f(@NativeType(value="GLint") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    public static native void glUniform4f(@NativeType(value="GLint") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLfloat") float var4);

    public static native void glUniform1i(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1);

    public static native void glUniform2i(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void glUniform3i(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3);

    public static native void glUniform4i(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4);

    public static native void nglUniform1fv(int var0, int var1, long var2);

    public static void glUniform1fv(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL20C.nglUniform1fv(location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void nglUniform2fv(int var0, int var1, long var2);

    public static void glUniform2fv(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL20C.nglUniform2fv(location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void nglUniform3fv(int var0, int var1, long var2);

    public static void glUniform3fv(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL20C.nglUniform3fv(location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void nglUniform4fv(int var0, int var1, long var2);

    public static void glUniform4fv(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL20C.nglUniform4fv(location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static native void nglUniform1iv(int var0, int var1, long var2);

    public static void glUniform1iv(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        GL20C.nglUniform1iv(location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void nglUniform2iv(int var0, int var1, long var2);

    public static void glUniform2iv(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        GL20C.nglUniform2iv(location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void nglUniform3iv(int var0, int var1, long var2);

    public static void glUniform3iv(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        GL20C.nglUniform3iv(location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void nglUniform4iv(int var0, int var1, long var2);

    public static void glUniform4iv(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        GL20C.nglUniform4iv(location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static native void nglUniformMatrix2fv(int var0, int var1, boolean var2, long var3);

    public static void glUniformMatrix2fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL20C.nglUniformMatrix2fv(location, value.remaining() >> 2, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglUniformMatrix3fv(int var0, int var1, boolean var2, long var3);

    public static void glUniformMatrix3fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL20C.nglUniformMatrix3fv(location, value.remaining() / 9, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglUniformMatrix4fv(int var0, int var1, boolean var2, long var3);

    public static void glUniformMatrix4fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL20C.nglUniformMatrix4fv(location, value.remaining() >> 4, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglGetShaderiv(int var0, int var1, long var2);

    public static void glGetShaderiv(@NativeType(value="GLuint") int shader, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL20C.nglGetShaderiv(shader, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetShaderi(@NativeType(value="GLuint") int shader, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL20C.nglGetShaderiv(shader, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetProgramiv(int var0, int var1, long var2);

    public static void glGetProgramiv(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL20C.nglGetProgramiv(program, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetProgrami(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL20C.nglGetProgramiv(program, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetShaderInfoLog(int var0, int var1, long var2, long var4);

    public static void glGetShaderInfoLog(@NativeType(value="GLuint") int shader, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer infoLog) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, 1);
        }
        GL20C.nglGetShaderInfoLog(shader, infoLog.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(infoLog));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetShaderInfoLog(@NativeType(value="GLuint") int shader, @NativeType(value="GLsizei") int maxLength) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        ByteBuffer infoLog = MemoryUtil.memAlloc(maxLength);
        try {
            IntBuffer length = stack.ints(0);
            GL20C.nglGetShaderInfoLog(shader, maxLength, MemoryUtil.memAddress(length), MemoryUtil.memAddress(infoLog));
            String string = MemoryUtil.memUTF8(infoLog, length.get(0));
            return string;
        }
        finally {
            MemoryUtil.memFree(infoLog);
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="void")
    public static String glGetShaderInfoLog(@NativeType(value="GLuint") int shader) {
        return GL20C.glGetShaderInfoLog(shader, GL20C.glGetShaderi(shader, 35716));
    }

    public static native void nglGetProgramInfoLog(int var0, int var1, long var2, long var4);

    public static void glGetProgramInfoLog(@NativeType(value="GLuint") int program, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer infoLog) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, 1);
        }
        GL20C.nglGetProgramInfoLog(program, infoLog.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(infoLog));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetProgramInfoLog(@NativeType(value="GLuint") int program, @NativeType(value="GLsizei") int maxLength) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        ByteBuffer infoLog = MemoryUtil.memAlloc(maxLength);
        try {
            IntBuffer length = stack.ints(0);
            GL20C.nglGetProgramInfoLog(program, maxLength, MemoryUtil.memAddress(length), MemoryUtil.memAddress(infoLog));
            String string = MemoryUtil.memUTF8(infoLog, length.get(0));
            return string;
        }
        finally {
            MemoryUtil.memFree(infoLog);
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="void")
    public static String glGetProgramInfoLog(@NativeType(value="GLuint") int program) {
        return GL20C.glGetProgramInfoLog(program, GL20C.glGetProgrami(program, 35716));
    }

    public static native void nglGetAttachedShaders(int var0, int var1, long var2, long var4);

    public static void glGetAttachedShaders(@NativeType(value="GLuint") int program, @Nullable @NativeType(value="GLsizei *") IntBuffer count, @NativeType(value="GLuint *") IntBuffer shaders) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)count, 1);
        }
        GL20C.nglGetAttachedShaders(program, shaders.remaining(), MemoryUtil.memAddressSafe(count), MemoryUtil.memAddress(shaders));
    }

    public static native int nglGetUniformLocation(int var0, long var1);

    @NativeType(value="GLint")
    public static int glGetUniformLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return GL20C.nglGetUniformLocation(program, MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLint")
    public static int glGetUniformLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(name, true);
            long nameEncoded = stack.getPointerAddress();
            int n = GL20C.nglGetUniformLocation(program, nameEncoded);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetActiveUniform(int var0, int var1, int var2, long var3, long var5, long var7, long var9);

    public static void glGetActiveUniform(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLint *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type, @NativeType(value="GLchar *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, 1);
            Checks.check((Buffer)size, 1);
            Checks.check((Buffer)type, 1);
        }
        GL20C.nglGetActiveUniform(program, index, name.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetActiveUniform(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @NativeType(value="GLsizei") int maxLength, @NativeType(value="GLint *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)size, 1);
            Checks.check((Buffer)type, 1);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer length = stack.ints(0);
            ByteBuffer name = stack.malloc(maxLength);
            GL20C.nglGetActiveUniform(program, index, maxLength, MemoryUtil.memAddress(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
            String string = MemoryUtil.memASCII(name, length.get(0));
            return string;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="void")
    public static String glGetActiveUniform(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type) {
        return GL20C.glGetActiveUniform(program, index, GL20C.glGetProgrami(program, 35719), size, type);
    }

    public static native void nglGetUniformfv(int var0, int var1, long var2);

    public static void glGetUniformfv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL20C.nglGetUniformfv(program, location, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetUniformf(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer params = stack.callocFloat(1);
            GL20C.nglGetUniformfv(program, location, MemoryUtil.memAddress(params));
            float f = params.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetUniformiv(int var0, int var1, long var2);

    public static void glGetUniformiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL20C.nglGetUniformiv(program, location, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetUniformi(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL20C.nglGetUniformiv(program, location, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetShaderSource(int var0, int var1, long var2, long var4);

    public static void glGetShaderSource(@NativeType(value="GLuint") int shader, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer source) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, 1);
        }
        GL20C.nglGetShaderSource(shader, source.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(source));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetShaderSource(@NativeType(value="GLuint") int shader, @NativeType(value="GLsizei") int maxLength) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        ByteBuffer source = MemoryUtil.memAlloc(maxLength);
        try {
            IntBuffer length = stack.ints(0);
            GL20C.nglGetShaderSource(shader, maxLength, MemoryUtil.memAddress(length), MemoryUtil.memAddress(source));
            String string = MemoryUtil.memUTF8(source, length.get(0));
            return string;
        }
        finally {
            MemoryUtil.memFree(source);
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="void")
    public static String glGetShaderSource(@NativeType(value="GLuint") int shader) {
        return GL20C.glGetShaderSource(shader, GL20C.glGetShaderi(shader, 35720));
    }

    public static native void glVertexAttrib1f(@NativeType(value="GLuint") int var0, @NativeType(value="GLfloat") float var1);

    public static native void glVertexAttrib1s(@NativeType(value="GLuint") int var0, @NativeType(value="GLshort") short var1);

    public static native void glVertexAttrib1d(@NativeType(value="GLuint") int var0, @NativeType(value="GLdouble") double var1);

    public static native void glVertexAttrib2f(@NativeType(value="GLuint") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    public static native void glVertexAttrib2s(@NativeType(value="GLuint") int var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2);

    public static native void glVertexAttrib2d(@NativeType(value="GLuint") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3);

    public static native void glVertexAttrib3f(@NativeType(value="GLuint") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    public static native void glVertexAttrib3s(@NativeType(value="GLuint") int var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2, @NativeType(value="GLshort") short var3);

    public static native void glVertexAttrib3d(@NativeType(value="GLuint") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5);

    public static native void glVertexAttrib4f(@NativeType(value="GLuint") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLfloat") float var4);

    public static native void glVertexAttrib4s(@NativeType(value="GLuint") int var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2, @NativeType(value="GLshort") short var3, @NativeType(value="GLshort") short var4);

    public static native void glVertexAttrib4d(@NativeType(value="GLuint") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5, @NativeType(value="GLdouble") double var7);

    public static native void glVertexAttrib4Nub(@NativeType(value="GLuint") int var0, @NativeType(value="GLubyte") byte var1, @NativeType(value="GLubyte") byte var2, @NativeType(value="GLubyte") byte var3, @NativeType(value="GLubyte") byte var4);

    public static native void nglVertexAttrib1fv(int var0, long var1);

    public static void glVertexAttrib1fv(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        GL20C.nglVertexAttrib1fv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib1sv(int var0, long var1);

    public static void glVertexAttrib1sv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        GL20C.nglVertexAttrib1sv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib1dv(int var0, long var1);

    public static void glVertexAttrib1dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        GL20C.nglVertexAttrib1dv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib2fv(int var0, long var1);

    public static void glVertexAttrib2fv(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        GL20C.nglVertexAttrib2fv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib2sv(int var0, long var1);

    public static void glVertexAttrib2sv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        GL20C.nglVertexAttrib2sv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib2dv(int var0, long var1);

    public static void glVertexAttrib2dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        GL20C.nglVertexAttrib2dv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib3fv(int var0, long var1);

    public static void glVertexAttrib3fv(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL20C.nglVertexAttrib3fv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib3sv(int var0, long var1);

    public static void glVertexAttrib3sv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL20C.nglVertexAttrib3sv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib3dv(int var0, long var1);

    public static void glVertexAttrib3dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL20C.nglVertexAttrib3dv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4fv(int var0, long var1);

    public static void glVertexAttrib4fv(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL20C.nglVertexAttrib4fv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4sv(int var0, long var1);

    public static void glVertexAttrib4sv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL20C.nglVertexAttrib4sv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4dv(int var0, long var1);

    public static void glVertexAttrib4dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL20C.nglVertexAttrib4dv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4iv(int var0, long var1);

    public static void glVertexAttrib4iv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL20C.nglVertexAttrib4iv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4bv(int var0, long var1);

    public static void glVertexAttrib4bv(@NativeType(value="GLuint") int index, @NativeType(value="GLbyte const *") ByteBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL20C.nglVertexAttrib4bv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4ubv(int var0, long var1);

    public static void glVertexAttrib4ubv(@NativeType(value="GLuint") int index, @NativeType(value="GLubyte const *") ByteBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL20C.nglVertexAttrib4ubv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4usv(int var0, long var1);

    public static void glVertexAttrib4usv(@NativeType(value="GLuint") int index, @NativeType(value="GLushort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL20C.nglVertexAttrib4usv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4uiv(int var0, long var1);

    public static void glVertexAttrib4uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL20C.nglVertexAttrib4uiv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4Nbv(int var0, long var1);

    public static void glVertexAttrib4Nbv(@NativeType(value="GLuint") int index, @NativeType(value="GLbyte const *") ByteBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL20C.nglVertexAttrib4Nbv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4Nsv(int var0, long var1);

    public static void glVertexAttrib4Nsv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL20C.nglVertexAttrib4Nsv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4Niv(int var0, long var1);

    public static void glVertexAttrib4Niv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL20C.nglVertexAttrib4Niv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4Nubv(int var0, long var1);

    public static void glVertexAttrib4Nubv(@NativeType(value="GLuint") int index, @NativeType(value="GLubyte const *") ByteBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL20C.nglVertexAttrib4Nubv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4Nusv(int var0, long var1);

    public static void glVertexAttrib4Nusv(@NativeType(value="GLuint") int index, @NativeType(value="GLushort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL20C.nglVertexAttrib4Nusv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4Nuiv(int var0, long var1);

    public static void glVertexAttrib4Nuiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL20C.nglVertexAttrib4Nuiv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribPointer(int var0, int var1, int var2, boolean var3, int var4, long var5);

    public static void glVertexAttribPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ByteBuffer pointer) {
        GL20C.nglVertexAttribPointer(index, size, type, normalized, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glVertexAttribPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") long pointer) {
        GL20C.nglVertexAttribPointer(index, size, type, normalized, stride, pointer);
    }

    public static void glVertexAttribPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ShortBuffer pointer) {
        GL20C.nglVertexAttribPointer(index, size, type, normalized, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glVertexAttribPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") IntBuffer pointer) {
        GL20C.nglVertexAttribPointer(index, size, type, normalized, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glVertexAttribPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") FloatBuffer pointer) {
        GL20C.nglVertexAttribPointer(index, size, type, normalized, stride, MemoryUtil.memAddress(pointer));
    }

    public static native void glEnableVertexAttribArray(@NativeType(value="GLuint") int var0);

    public static native void glDisableVertexAttribArray(@NativeType(value="GLuint") int var0);

    public static native void nglBindAttribLocation(int var0, int var1, long var2);

    public static void glBindAttribLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @NativeType(value="GLchar const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        GL20C.nglBindAttribLocation(program, index, MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glBindAttribLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @NativeType(value="GLchar const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(name, true);
            long nameEncoded = stack.getPointerAddress();
            GL20C.nglBindAttribLocation(program, index, nameEncoded);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetActiveAttrib(int var0, int var1, int var2, long var3, long var5, long var7, long var9);

    public static void glGetActiveAttrib(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLint *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type, @NativeType(value="GLchar *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, 1);
            Checks.check((Buffer)size, 1);
            Checks.check((Buffer)type, 1);
        }
        GL20C.nglGetActiveAttrib(program, index, name.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetActiveAttrib(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @NativeType(value="GLsizei") int maxLength, @NativeType(value="GLint *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)size, 1);
            Checks.check((Buffer)type, 1);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer length = stack.ints(0);
            ByteBuffer name = stack.malloc(maxLength);
            GL20C.nglGetActiveAttrib(program, index, maxLength, MemoryUtil.memAddress(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
            String string = MemoryUtil.memASCII(name, length.get(0));
            return string;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="void")
    public static String glGetActiveAttrib(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type) {
        return GL20C.glGetActiveAttrib(program, index, GL20C.glGetProgrami(program, 35722), size, type);
    }

    public static native int nglGetAttribLocation(int var0, long var1);

    @NativeType(value="GLint")
    public static int glGetAttribLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return GL20C.nglGetAttribLocation(program, MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLint")
    public static int glGetAttribLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(name, true);
            long nameEncoded = stack.getPointerAddress();
            int n = GL20C.nglGetAttribLocation(program, nameEncoded);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetVertexAttribiv(int var0, int var1, long var2);

    public static void glGetVertexAttribiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL20C.nglGetVertexAttribiv(index, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetVertexAttribi(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL20C.nglGetVertexAttribiv(index, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetVertexAttribfv(int var0, int var1, long var2);

    public static void glGetVertexAttribfv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        GL20C.nglGetVertexAttribfv(index, pname, MemoryUtil.memAddress(params));
    }

    public static native void nglGetVertexAttribdv(int var0, int var1, long var2);

    public static void glGetVertexAttribdv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLdouble *") DoubleBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        GL20C.nglGetVertexAttribdv(index, pname, MemoryUtil.memAddress(params));
    }

    public static native void nglGetVertexAttribPointerv(int var0, int var1, long var2);

    public static void glGetVertexAttribPointerv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="void **") PointerBuffer pointer) {
        if (Checks.CHECKS) {
            Checks.check(pointer, 1);
        }
        GL20C.nglGetVertexAttribPointerv(index, pname, MemoryUtil.memAddress(pointer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetVertexAttribPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            PointerBuffer pointer = stack.callocPointer(1);
            GL20C.nglGetVertexAttribPointerv(index, pname, MemoryUtil.memAddress(pointer));
            long l = pointer.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglDrawBuffers(int var0, long var1);

    public static void glDrawBuffers(@NativeType(value="GLenum const *") IntBuffer bufs) {
        GL20C.nglDrawBuffers(bufs.remaining(), MemoryUtil.memAddress(bufs));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDrawBuffers(@NativeType(value="GLenum const *") int buf) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer bufs = stack.ints(buf);
            GL20C.nglDrawBuffers(1, MemoryUtil.memAddress(bufs));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glBlendEquationSeparate(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1);

    public static native void glStencilOpSeparate(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLenum") int var3);

    public static native void glStencilFuncSeparate(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLuint") int var3);

    public static native void glStencilMaskSeparate(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static void glShaderSource(@NativeType(value="GLuint") int shader, @NativeType(value="GLchar const **") PointerBuffer strings, @Nullable @NativeType(value="GLint const *") int[] length) {
        long __functionAddress = GL.getICD().glShaderSource;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, strings.remaining());
        }
        JNI.callPPV(shader, strings.remaining(), MemoryUtil.memAddress(strings), length, __functionAddress);
    }

    public static void glUniform1fv(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glUniform1fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length, value, __functionAddress);
    }

    public static void glUniform2fv(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glUniform2fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 1, value, __functionAddress);
    }

    public static void glUniform3fv(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glUniform3fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length / 3, value, __functionAddress);
    }

    public static void glUniform4fv(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glUniform4fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 2, value, __functionAddress);
    }

    public static void glUniform1iv(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        long __functionAddress = GL.getICD().glUniform1iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length, value, __functionAddress);
    }

    public static void glUniform2iv(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        long __functionAddress = GL.getICD().glUniform2iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 1, value, __functionAddress);
    }

    public static void glUniform3iv(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        long __functionAddress = GL.getICD().glUniform3iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length / 3, value, __functionAddress);
    }

    public static void glUniform4iv(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        long __functionAddress = GL.getICD().glUniform4iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 2, value, __functionAddress);
    }

    public static void glUniformMatrix2fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glUniformMatrix2fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 2, transpose, value, __functionAddress);
    }

    public static void glUniformMatrix3fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glUniformMatrix3fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length / 9, transpose, value, __functionAddress);
    }

    public static void glUniformMatrix4fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glUniformMatrix4fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 4, transpose, value, __functionAddress);
    }

    public static void glGetShaderiv(@NativeType(value="GLuint") int shader, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetShaderiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(shader, pname, params, __functionAddress);
    }

    public static void glGetProgramiv(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetProgramiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(program, pname, params, __functionAddress);
    }

    public static void glGetShaderInfoLog(@NativeType(value="GLuint") int shader, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer infoLog) {
        long __functionAddress = GL.getICD().glGetShaderInfoLog;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, 1);
        }
        JNI.callPPV(shader, infoLog.remaining(), length, MemoryUtil.memAddress(infoLog), __functionAddress);
    }

    public static void glGetProgramInfoLog(@NativeType(value="GLuint") int program, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer infoLog) {
        long __functionAddress = GL.getICD().glGetProgramInfoLog;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, 1);
        }
        JNI.callPPV(program, infoLog.remaining(), length, MemoryUtil.memAddress(infoLog), __functionAddress);
    }

    public static void glGetAttachedShaders(@NativeType(value="GLuint") int program, @Nullable @NativeType(value="GLsizei *") int[] count, @NativeType(value="GLuint *") int[] shaders) {
        long __functionAddress = GL.getICD().glGetAttachedShaders;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(count, 1);
        }
        JNI.callPPV(program, shaders.length, count, shaders, __functionAddress);
    }

    public static void glGetActiveUniform(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLint *") int[] size, @NativeType(value="GLenum *") int[] type, @NativeType(value="GLchar *") ByteBuffer name) {
        long __functionAddress = GL.getICD().glGetActiveUniform;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, 1);
            Checks.check(size, 1);
            Checks.check(type, 1);
        }
        JNI.callPPPPV(program, index, name.remaining(), length, size, type, MemoryUtil.memAddress(name), __functionAddress);
    }

    public static void glGetUniformfv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetUniformfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(program, location, params, __functionAddress);
    }

    public static void glGetUniformiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetUniformiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(program, location, params, __functionAddress);
    }

    public static void glGetShaderSource(@NativeType(value="GLuint") int shader, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer source) {
        long __functionAddress = GL.getICD().glGetShaderSource;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, 1);
        }
        JNI.callPPV(shader, source.remaining(), length, MemoryUtil.memAddress(source), __functionAddress);
    }

    public static void glVertexAttrib1fv(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib1fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib1sv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib1sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib1dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib1dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib2fv(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib2fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib2sv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib2sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib2dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib2dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib3fv(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib3fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib3sv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib3sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib3dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib3dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib4fv(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib4fv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib4sv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib4sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib4dv(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib4dv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib4iv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib4iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib4usv(@NativeType(value="GLuint") int index, @NativeType(value="GLushort const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib4usv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib4uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib4uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib4Nsv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib4Nsv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib4Niv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib4Niv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib4Nusv(@NativeType(value="GLuint") int index, @NativeType(value="GLushort const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib4Nusv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib4Nuiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib4Nuiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glGetActiveAttrib(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLint *") int[] size, @NativeType(value="GLenum *") int[] type, @NativeType(value="GLchar *") ByteBuffer name) {
        long __functionAddress = GL.getICD().glGetActiveAttrib;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, 1);
            Checks.check(size, 1);
            Checks.check(type, 1);
        }
        JNI.callPPPPV(program, index, name.remaining(), length, size, type, MemoryUtil.memAddress(name), __functionAddress);
    }

    public static void glGetVertexAttribiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetVertexAttribiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(index, pname, params, __functionAddress);
    }

    public static void glGetVertexAttribfv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetVertexAttribfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(index, pname, params, __functionAddress);
    }

    public static void glGetVertexAttribdv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLdouble *") double[] params) {
        long __functionAddress = GL.getICD().glGetVertexAttribdv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(index, pname, params, __functionAddress);
    }

    public static void glDrawBuffers(@NativeType(value="GLenum const *") int[] bufs) {
        long __functionAddress = GL.getICD().glDrawBuffers;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(bufs.length, bufs, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

