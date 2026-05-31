/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
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

public class ARBShaderObjects {
    public static final int GL_PROGRAM_OBJECT_ARB = 35648;
    public static final int GL_OBJECT_TYPE_ARB = 35662;
    public static final int GL_OBJECT_SUBTYPE_ARB = 35663;
    public static final int GL_OBJECT_DELETE_STATUS_ARB = 35712;
    public static final int GL_OBJECT_COMPILE_STATUS_ARB = 35713;
    public static final int GL_OBJECT_LINK_STATUS_ARB = 35714;
    public static final int GL_OBJECT_VALIDATE_STATUS_ARB = 35715;
    public static final int GL_OBJECT_INFO_LOG_LENGTH_ARB = 35716;
    public static final int GL_OBJECT_ATTACHED_OBJECTS_ARB = 35717;
    public static final int GL_OBJECT_ACTIVE_UNIFORMS_ARB = 35718;
    public static final int GL_OBJECT_ACTIVE_UNIFORM_MAX_LENGTH_ARB = 35719;
    public static final int GL_OBJECT_SHADER_SOURCE_LENGTH_ARB = 35720;
    public static final int GL_SHADER_OBJECT_ARB = 35656;
    public static final int GL_FLOAT_VEC2_ARB = 35664;
    public static final int GL_FLOAT_VEC3_ARB = 35665;
    public static final int GL_FLOAT_VEC4_ARB = 35666;
    public static final int GL_INT_VEC2_ARB = 35667;
    public static final int GL_INT_VEC3_ARB = 35668;
    public static final int GL_INT_VEC4_ARB = 35669;
    public static final int GL_BOOL_ARB = 35670;
    public static final int GL_BOOL_VEC2_ARB = 35671;
    public static final int GL_BOOL_VEC3_ARB = 35672;
    public static final int GL_BOOL_VEC4_ARB = 35673;
    public static final int GL_FLOAT_MAT2_ARB = 35674;
    public static final int GL_FLOAT_MAT3_ARB = 35675;
    public static final int GL_FLOAT_MAT4_ARB = 35676;
    public static final int GL_SAMPLER_1D_ARB = 35677;
    public static final int GL_SAMPLER_2D_ARB = 35678;
    public static final int GL_SAMPLER_3D_ARB = 35679;
    public static final int GL_SAMPLER_CUBE_ARB = 35680;
    public static final int GL_SAMPLER_1D_SHADOW_ARB = 35681;
    public static final int GL_SAMPLER_2D_SHADOW_ARB = 35682;
    public static final int GL_SAMPLER_2D_RECT_ARB = 35683;
    public static final int GL_SAMPLER_2D_RECT_SHADOW_ARB = 35684;

    protected ARBShaderObjects() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glDeleteObjectARB, caps.glGetHandleARB, caps.glDetachObjectARB, caps.glCreateShaderObjectARB, caps.glShaderSourceARB, caps.glCompileShaderARB, caps.glCreateProgramObjectARB, caps.glAttachObjectARB, caps.glLinkProgramARB, caps.glUseProgramObjectARB, caps.glValidateProgramARB, caps.glUniform1fARB, caps.glUniform2fARB, caps.glUniform3fARB, caps.glUniform4fARB, caps.glUniform1iARB, caps.glUniform2iARB, caps.glUniform3iARB, caps.glUniform4iARB, caps.glUniform1fvARB, caps.glUniform2fvARB, caps.glUniform3fvARB, caps.glUniform4fvARB, caps.glUniform1ivARB, caps.glUniform2ivARB, caps.glUniform3ivARB, caps.glUniform4ivARB, caps.glUniformMatrix2fvARB, caps.glUniformMatrix3fvARB, caps.glUniformMatrix4fvARB, caps.glGetObjectParameterfvARB, caps.glGetObjectParameterivARB, caps.glGetInfoLogARB, caps.glGetAttachedObjectsARB, caps.glGetUniformLocationARB, caps.glGetActiveUniformARB, caps.glGetUniformfvARB, caps.glGetUniformivARB, caps.glGetShaderSourceARB);
    }

    public static native void glDeleteObjectARB(@NativeType(value="GLhandleARB") int var0);

    @NativeType(value="GLhandleARB")
    public static native int glGetHandleARB(@NativeType(value="GLenum") int var0);

    public static native void glDetachObjectARB(@NativeType(value="GLhandleARB") int var0, @NativeType(value="GLhandleARB") int var1);

    @NativeType(value="GLhandleARB")
    public static native int glCreateShaderObjectARB(@NativeType(value="GLenum") int var0);

    public static native void nglShaderSourceARB(int var0, int var1, long var2, long var4);

    public static void glShaderSourceARB(@NativeType(value="GLhandleARB") int shaderObj, @NativeType(value="GLcharARB const **") PointerBuffer string, @Nullable @NativeType(value="GLint const *") IntBuffer length) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, string.remaining());
        }
        ARBShaderObjects.nglShaderSourceARB(shaderObj, string.remaining(), MemoryUtil.memAddress(string), MemoryUtil.memAddressSafe(length));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glShaderSourceARB(@NativeType(value="GLhandleARB") int shaderObj, CharSequence ... string) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            long stringAddress = APIUtil.apiArrayi(stack, MemoryUtil::memUTF8, string);
            ARBShaderObjects.nglShaderSourceARB(shaderObj, string.length, stringAddress, stringAddress - (long)(string.length << 2));
            APIUtil.apiArrayFree(stringAddress, string.length);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glShaderSourceARB(@NativeType(value="GLhandleARB") int shaderObj, @NativeType(value="GLcharARB const **") CharSequence string) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            long stringAddress = APIUtil.apiArrayi(stack, MemoryUtil::memUTF8, string);
            ARBShaderObjects.nglShaderSourceARB(shaderObj, 1, stringAddress, stringAddress - 4L);
            APIUtil.apiArrayFree(stringAddress, 1);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glCompileShaderARB(@NativeType(value="GLhandleARB") int var0);

    @NativeType(value="GLhandleARB")
    public static native int glCreateProgramObjectARB();

    public static native void glAttachObjectARB(@NativeType(value="GLhandleARB") int var0, @NativeType(value="GLhandleARB") int var1);

    public static native void glLinkProgramARB(@NativeType(value="GLhandleARB") int var0);

    public static native void glUseProgramObjectARB(@NativeType(value="GLhandleARB") int var0);

    public static native void glValidateProgramARB(@NativeType(value="GLhandleARB") int var0);

    public static native void glUniform1fARB(@NativeType(value="GLint") int var0, @NativeType(value="GLfloat") float var1);

    public static native void glUniform2fARB(@NativeType(value="GLint") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    public static native void glUniform3fARB(@NativeType(value="GLint") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    public static native void glUniform4fARB(@NativeType(value="GLint") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLfloat") float var4);

    public static native void glUniform1iARB(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1);

    public static native void glUniform2iARB(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void glUniform3iARB(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3);

    public static native void glUniform4iARB(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4);

    public static native void nglUniform1fvARB(int var0, int var1, long var2);

    public static void glUniform1fvARB(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        ARBShaderObjects.nglUniform1fvARB(location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void nglUniform2fvARB(int var0, int var1, long var2);

    public static void glUniform2fvARB(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        ARBShaderObjects.nglUniform2fvARB(location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void nglUniform3fvARB(int var0, int var1, long var2);

    public static void glUniform3fvARB(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        ARBShaderObjects.nglUniform3fvARB(location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void nglUniform4fvARB(int var0, int var1, long var2);

    public static void glUniform4fvARB(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        ARBShaderObjects.nglUniform4fvARB(location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static native void nglUniform1ivARB(int var0, int var1, long var2);

    public static void glUniform1ivARB(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        ARBShaderObjects.nglUniform1ivARB(location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void nglUniform2ivARB(int var0, int var1, long var2);

    public static void glUniform2ivARB(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        ARBShaderObjects.nglUniform2ivARB(location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void nglUniform3ivARB(int var0, int var1, long var2);

    public static void glUniform3ivARB(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        ARBShaderObjects.nglUniform3ivARB(location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void nglUniform4ivARB(int var0, int var1, long var2);

    public static void glUniform4ivARB(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        ARBShaderObjects.nglUniform4ivARB(location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static native void nglUniformMatrix2fvARB(int var0, int var1, boolean var2, long var3);

    public static void glUniformMatrix2fvARB(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        ARBShaderObjects.nglUniformMatrix2fvARB(location, value.remaining() >> 2, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglUniformMatrix3fvARB(int var0, int var1, boolean var2, long var3);

    public static void glUniformMatrix3fvARB(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        ARBShaderObjects.nglUniformMatrix3fvARB(location, value.remaining() / 9, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglUniformMatrix4fvARB(int var0, int var1, boolean var2, long var3);

    public static void glUniformMatrix4fvARB(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        ARBShaderObjects.nglUniformMatrix4fvARB(location, value.remaining() >> 4, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglGetObjectParameterfvARB(int var0, int var1, long var2);

    public static void glGetObjectParameterfvARB(@NativeType(value="GLhandleARB") int obj, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        ARBShaderObjects.nglGetObjectParameterfvARB(obj, pname, MemoryUtil.memAddress(params));
    }

    public static native void nglGetObjectParameterivARB(int var0, int var1, long var2);

    public static void glGetObjectParameterivARB(@NativeType(value="GLhandleARB") int obj, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        ARBShaderObjects.nglGetObjectParameterivARB(obj, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetObjectParameteriARB(@NativeType(value="GLhandleARB") int obj, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            ARBShaderObjects.nglGetObjectParameterivARB(obj, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetInfoLogARB(int var0, int var1, long var2, long var4);

    public static void glGetInfoLogARB(@NativeType(value="GLhandleARB") int obj, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLcharARB *") ByteBuffer infoLog) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, 1);
        }
        ARBShaderObjects.nglGetInfoLogARB(obj, infoLog.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(infoLog));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetInfoLogARB(@NativeType(value="GLhandleARB") int obj, @NativeType(value="GLsizei") int maxLength) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        ByteBuffer infoLog = MemoryUtil.memAlloc(maxLength);
        try {
            IntBuffer length = stack.ints(0);
            ARBShaderObjects.nglGetInfoLogARB(obj, maxLength, MemoryUtil.memAddress(length), MemoryUtil.memAddress(infoLog));
            String string = MemoryUtil.memUTF8(infoLog, length.get(0));
            return string;
        }
        finally {
            MemoryUtil.memFree(infoLog);
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="void")
    public static String glGetInfoLogARB(@NativeType(value="GLhandleARB") int obj) {
        return ARBShaderObjects.glGetInfoLogARB(obj, ARBShaderObjects.glGetObjectParameteriARB(obj, 35716));
    }

    public static native void nglGetAttachedObjectsARB(int var0, int var1, long var2, long var4);

    public static void glGetAttachedObjectsARB(@NativeType(value="GLhandleARB") int containerObj, @Nullable @NativeType(value="GLsizei *") IntBuffer count, @NativeType(value="GLhandleARB *") IntBuffer obj) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)count, 1);
        }
        ARBShaderObjects.nglGetAttachedObjectsARB(containerObj, obj.remaining(), MemoryUtil.memAddressSafe(count), MemoryUtil.memAddress(obj));
    }

    public static native int nglGetUniformLocationARB(int var0, long var1);

    @NativeType(value="GLint")
    public static int glGetUniformLocationARB(@NativeType(value="GLhandleARB") int programObj, @NativeType(value="GLcharARB const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return ARBShaderObjects.nglGetUniformLocationARB(programObj, MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLint")
    public static int glGetUniformLocationARB(@NativeType(value="GLhandleARB") int programObj, @NativeType(value="GLcharARB const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(name, true);
            long nameEncoded = stack.getPointerAddress();
            int n = ARBShaderObjects.nglGetUniformLocationARB(programObj, nameEncoded);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetActiveUniformARB(int var0, int var1, int var2, long var3, long var5, long var7, long var9);

    public static void glGetActiveUniformARB(@NativeType(value="GLhandleARB") int programObj, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLint *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type, @NativeType(value="GLcharARB *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, 1);
            Checks.check((Buffer)size, 1);
            Checks.check((Buffer)type, 1);
        }
        ARBShaderObjects.nglGetActiveUniformARB(programObj, index, name.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetActiveUniformARB(@NativeType(value="GLhandleARB") int programObj, @NativeType(value="GLuint") int index, @NativeType(value="GLsizei") int maxLength, @NativeType(value="GLint *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)size, 1);
            Checks.check((Buffer)type, 1);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer length = stack.ints(0);
            ByteBuffer name = stack.malloc(maxLength);
            ARBShaderObjects.nglGetActiveUniformARB(programObj, index, maxLength, MemoryUtil.memAddress(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
            String string = MemoryUtil.memUTF8(name, length.get(0));
            return string;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="void")
    public static String glGetActiveUniformARB(@NativeType(value="GLhandleARB") int programObj, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type) {
        return ARBShaderObjects.glGetActiveUniformARB(programObj, index, ARBShaderObjects.glGetObjectParameteriARB(programObj, 35719), size, type);
    }

    public static native void nglGetUniformfvARB(int var0, int var1, long var2);

    public static void glGetUniformfvARB(@NativeType(value="GLhandleARB") int programObj, @NativeType(value="GLint") int location, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        ARBShaderObjects.nglGetUniformfvARB(programObj, location, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetUniformfARB(@NativeType(value="GLhandleARB") int programObj, @NativeType(value="GLint") int location) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer params = stack.callocFloat(1);
            ARBShaderObjects.nglGetUniformfvARB(programObj, location, MemoryUtil.memAddress(params));
            float f = params.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetUniformivARB(int var0, int var1, long var2);

    public static void glGetUniformivARB(@NativeType(value="GLhandleARB") int programObj, @NativeType(value="GLint") int location, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        ARBShaderObjects.nglGetUniformivARB(programObj, location, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetUniformiARB(@NativeType(value="GLhandleARB") int programObj, @NativeType(value="GLint") int location) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            ARBShaderObjects.nglGetUniformivARB(programObj, location, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetShaderSourceARB(int var0, int var1, long var2, long var4);

    public static void glGetShaderSourceARB(@NativeType(value="GLhandleARB") int obj, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLcharARB *") ByteBuffer source) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, 1);
        }
        ARBShaderObjects.nglGetShaderSourceARB(obj, source.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(source));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetShaderSourceARB(@NativeType(value="GLhandleARB") int obj, @NativeType(value="GLsizei") int maxLength) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        ByteBuffer source = MemoryUtil.memAlloc(maxLength);
        try {
            IntBuffer length = stack.ints(0);
            ARBShaderObjects.nglGetShaderSourceARB(obj, maxLength, MemoryUtil.memAddress(length), MemoryUtil.memAddress(source));
            String string = MemoryUtil.memUTF8(source, length.get(0));
            return string;
        }
        finally {
            MemoryUtil.memFree(source);
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="void")
    public static String glGetShaderSourceARB(@NativeType(value="GLhandleARB") int obj) {
        return ARBShaderObjects.glGetShaderSourceARB(obj, ARBShaderObjects.glGetObjectParameteriARB(obj, 35720));
    }

    public static void glShaderSourceARB(@NativeType(value="GLhandleARB") int shaderObj, @NativeType(value="GLcharARB const **") PointerBuffer string, @Nullable @NativeType(value="GLint const *") int[] length) {
        long __functionAddress = GL.getICD().glShaderSourceARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, string.remaining());
        }
        JNI.callPPV(shaderObj, string.remaining(), MemoryUtil.memAddress(string), length, __functionAddress);
    }

    public static void glUniform1fvARB(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glUniform1fvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length, value, __functionAddress);
    }

    public static void glUniform2fvARB(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glUniform2fvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 1, value, __functionAddress);
    }

    public static void glUniform3fvARB(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glUniform3fvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length / 3, value, __functionAddress);
    }

    public static void glUniform4fvARB(@NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glUniform4fvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 2, value, __functionAddress);
    }

    public static void glUniform1ivARB(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        long __functionAddress = GL.getICD().glUniform1ivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length, value, __functionAddress);
    }

    public static void glUniform2ivARB(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        long __functionAddress = GL.getICD().glUniform2ivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 1, value, __functionAddress);
    }

    public static void glUniform3ivARB(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        long __functionAddress = GL.getICD().glUniform3ivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length / 3, value, __functionAddress);
    }

    public static void glUniform4ivARB(@NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        long __functionAddress = GL.getICD().glUniform4ivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 2, value, __functionAddress);
    }

    public static void glUniformMatrix2fvARB(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glUniformMatrix2fvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 2, transpose, value, __functionAddress);
    }

    public static void glUniformMatrix3fvARB(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glUniformMatrix3fvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length / 9, transpose, value, __functionAddress);
    }

    public static void glUniformMatrix4fvARB(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glUniformMatrix4fvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 4, transpose, value, __functionAddress);
    }

    public static void glGetObjectParameterfvARB(@NativeType(value="GLhandleARB") int obj, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetObjectParameterfvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(obj, pname, params, __functionAddress);
    }

    public static void glGetObjectParameterivARB(@NativeType(value="GLhandleARB") int obj, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetObjectParameterivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(obj, pname, params, __functionAddress);
    }

    public static void glGetInfoLogARB(@NativeType(value="GLhandleARB") int obj, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLcharARB *") ByteBuffer infoLog) {
        long __functionAddress = GL.getICD().glGetInfoLogARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, 1);
        }
        JNI.callPPV(obj, infoLog.remaining(), length, MemoryUtil.memAddress(infoLog), __functionAddress);
    }

    public static void glGetAttachedObjectsARB(@NativeType(value="GLhandleARB") int containerObj, @Nullable @NativeType(value="GLsizei *") int[] count, @NativeType(value="GLhandleARB *") int[] obj) {
        long __functionAddress = GL.getICD().glGetAttachedObjectsARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(count, 1);
        }
        JNI.callPPV(containerObj, obj.length, count, obj, __functionAddress);
    }

    public static void glGetActiveUniformARB(@NativeType(value="GLhandleARB") int programObj, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLint *") int[] size, @NativeType(value="GLenum *") int[] type, @NativeType(value="GLcharARB *") ByteBuffer name) {
        long __functionAddress = GL.getICD().glGetActiveUniformARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, 1);
            Checks.check(size, 1);
            Checks.check(type, 1);
        }
        JNI.callPPPPV(programObj, index, name.remaining(), length, size, type, MemoryUtil.memAddress(name), __functionAddress);
    }

    public static void glGetUniformfvARB(@NativeType(value="GLhandleARB") int programObj, @NativeType(value="GLint") int location, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetUniformfvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(programObj, location, params, __functionAddress);
    }

    public static void glGetUniformivARB(@NativeType(value="GLhandleARB") int programObj, @NativeType(value="GLint") int location, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetUniformivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(programObj, location, params, __functionAddress);
    }

    public static void glGetShaderSourceARB(@NativeType(value="GLhandleARB") int obj, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLcharARB *") ByteBuffer source) {
        long __functionAddress = GL.getICD().glGetShaderSourceARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, 1);
        }
        JNI.callPPV(obj, source.remaining(), length, MemoryUtil.memAddress(source), __functionAddress);
    }

    static {
        GL.initialize();
    }
}

