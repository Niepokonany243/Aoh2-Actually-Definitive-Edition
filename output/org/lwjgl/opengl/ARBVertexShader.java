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
import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBVertexShader {
    public static final int GL_VERTEX_SHADER_ARB = 35633;
    public static final int GL_MAX_VERTEX_UNIFORM_COMPONENTS_ARB = 35658;
    public static final int GL_MAX_VARYING_FLOATS_ARB = 35659;
    public static final int GL_MAX_VERTEX_ATTRIBS_ARB = 34921;
    public static final int GL_MAX_TEXTURE_IMAGE_UNITS_ARB = 34930;
    public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS_ARB = 35660;
    public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS_ARB = 35661;
    public static final int GL_MAX_TEXTURE_COORDS_ARB = 34929;
    public static final int GL_VERTEX_PROGRAM_POINT_SIZE_ARB = 34370;
    public static final int GL_VERTEX_PROGRAM_TWO_SIDE_ARB = 34371;
    public static final int GL_OBJECT_ACTIVE_ATTRIBUTES_ARB = 35721;
    public static final int GL_OBJECT_ACTIVE_ATTRIBUTE_MAX_LENGTH_ARB = 35722;
    public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED_ARB = 34338;
    public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE_ARB = 34339;
    public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE_ARB = 34340;
    public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE_ARB = 34341;
    public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED_ARB = 34922;
    public static final int GL_CURRENT_VERTEX_ATTRIB_ARB = 34342;
    public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER_ARB = 34373;
    public static final int GL_FLOAT_VEC2_ARB = 35664;
    public static final int GL_FLOAT_VEC3_ARB = 35665;
    public static final int GL_FLOAT_VEC4_ARB = 35666;
    public static final int GL_FLOAT_MAT2_ARB = 35674;
    public static final int GL_FLOAT_MAT3_ARB = 35675;
    public static final int GL_FLOAT_MAT4_ARB = 35676;

    protected ARBVertexShader() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glVertexAttrib1fARB, caps.glVertexAttrib1sARB, caps.glVertexAttrib1dARB, caps.glVertexAttrib2fARB, caps.glVertexAttrib2sARB, caps.glVertexAttrib2dARB, caps.glVertexAttrib3fARB, caps.glVertexAttrib3sARB, caps.glVertexAttrib3dARB, caps.glVertexAttrib4fARB, caps.glVertexAttrib4sARB, caps.glVertexAttrib4dARB, caps.glVertexAttrib4NubARB, caps.glVertexAttrib1fvARB, caps.glVertexAttrib1svARB, caps.glVertexAttrib1dvARB, caps.glVertexAttrib2fvARB, caps.glVertexAttrib2svARB, caps.glVertexAttrib2dvARB, caps.glVertexAttrib3fvARB, caps.glVertexAttrib3svARB, caps.glVertexAttrib3dvARB, caps.glVertexAttrib4fvARB, caps.glVertexAttrib4svARB, caps.glVertexAttrib4dvARB, caps.glVertexAttrib4ivARB, caps.glVertexAttrib4bvARB, caps.glVertexAttrib4ubvARB, caps.glVertexAttrib4usvARB, caps.glVertexAttrib4uivARB, caps.glVertexAttrib4NbvARB, caps.glVertexAttrib4NsvARB, caps.glVertexAttrib4NivARB, caps.glVertexAttrib4NubvARB, caps.glVertexAttrib4NusvARB, caps.glVertexAttrib4NuivARB, caps.glVertexAttribPointerARB, caps.glEnableVertexAttribArrayARB, caps.glDisableVertexAttribArrayARB, caps.glBindAttribLocationARB, caps.glGetActiveAttribARB, caps.glGetAttribLocationARB, caps.glGetVertexAttribivARB, caps.glGetVertexAttribfvARB, caps.glGetVertexAttribdvARB, caps.glGetVertexAttribPointervARB);
    }

    public static native void glVertexAttrib1fARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLfloat") float var1);

    public static native void glVertexAttrib1sARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLshort") short var1);

    public static native void glVertexAttrib1dARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLdouble") double var1);

    public static native void glVertexAttrib2fARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    public static native void glVertexAttrib2sARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2);

    public static native void glVertexAttrib2dARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3);

    public static native void glVertexAttrib3fARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    public static native void glVertexAttrib3sARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2, @NativeType(value="GLshort") short var3);

    public static native void glVertexAttrib3dARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5);

    public static native void glVertexAttrib4fARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLfloat") float var4);

    public static native void glVertexAttrib4sARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLshort") short var1, @NativeType(value="GLshort") short var2, @NativeType(value="GLshort") short var3, @NativeType(value="GLshort") short var4);

    public static native void glVertexAttrib4dARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5, @NativeType(value="GLdouble") double var7);

    public static native void glVertexAttrib4NubARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLubyte") byte var1, @NativeType(value="GLubyte") byte var2, @NativeType(value="GLubyte") byte var3, @NativeType(value="GLubyte") byte var4);

    public static native void nglVertexAttrib1fvARB(int var0, long var1);

    public static void glVertexAttrib1fvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        ARBVertexShader.nglVertexAttrib1fvARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib1svARB(int var0, long var1);

    public static void glVertexAttrib1svARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        ARBVertexShader.nglVertexAttrib1svARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib1dvARB(int var0, long var1);

    public static void glVertexAttrib1dvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        ARBVertexShader.nglVertexAttrib1dvARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib2fvARB(int var0, long var1);

    public static void glVertexAttrib2fvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        ARBVertexShader.nglVertexAttrib2fvARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib2svARB(int var0, long var1);

    public static void glVertexAttrib2svARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        ARBVertexShader.nglVertexAttrib2svARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib2dvARB(int var0, long var1);

    public static void glVertexAttrib2dvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        ARBVertexShader.nglVertexAttrib2dvARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib3fvARB(int var0, long var1);

    public static void glVertexAttrib3fvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        ARBVertexShader.nglVertexAttrib3fvARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib3svARB(int var0, long var1);

    public static void glVertexAttrib3svARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        ARBVertexShader.nglVertexAttrib3svARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib3dvARB(int var0, long var1);

    public static void glVertexAttrib3dvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        ARBVertexShader.nglVertexAttrib3dvARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4fvARB(int var0, long var1);

    public static void glVertexAttrib4fvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        ARBVertexShader.nglVertexAttrib4fvARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4svARB(int var0, long var1);

    public static void glVertexAttrib4svARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        ARBVertexShader.nglVertexAttrib4svARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4dvARB(int var0, long var1);

    public static void glVertexAttrib4dvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        ARBVertexShader.nglVertexAttrib4dvARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4ivARB(int var0, long var1);

    public static void glVertexAttrib4ivARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        ARBVertexShader.nglVertexAttrib4ivARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4bvARB(int var0, long var1);

    public static void glVertexAttrib4bvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLbyte const *") ByteBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        ARBVertexShader.nglVertexAttrib4bvARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4ubvARB(int var0, long var1);

    public static void glVertexAttrib4ubvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLubyte const *") ByteBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        ARBVertexShader.nglVertexAttrib4ubvARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4usvARB(int var0, long var1);

    public static void glVertexAttrib4usvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLushort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        ARBVertexShader.nglVertexAttrib4usvARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4uivARB(int var0, long var1);

    public static void glVertexAttrib4uivARB(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        ARBVertexShader.nglVertexAttrib4uivARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4NbvARB(int var0, long var1);

    public static void glVertexAttrib4NbvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLbyte const *") ByteBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        ARBVertexShader.nglVertexAttrib4NbvARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4NsvARB(int var0, long var1);

    public static void glVertexAttrib4NsvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        ARBVertexShader.nglVertexAttrib4NsvARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4NivARB(int var0, long var1);

    public static void glVertexAttrib4NivARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        ARBVertexShader.nglVertexAttrib4NivARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4NubvARB(int var0, long var1);

    public static void glVertexAttrib4NubvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLubyte const *") ByteBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        ARBVertexShader.nglVertexAttrib4NubvARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4NusvARB(int var0, long var1);

    public static void glVertexAttrib4NusvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLushort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        ARBVertexShader.nglVertexAttrib4NusvARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttrib4NuivARB(int var0, long var1);

    public static void glVertexAttrib4NuivARB(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        ARBVertexShader.nglVertexAttrib4NuivARB(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribPointerARB(int var0, int var1, int var2, boolean var3, int var4, long var5);

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ByteBuffer pointer) {
        ARBVertexShader.nglVertexAttribPointerARB(index, size, type, normalized, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") long pointer) {
        ARBVertexShader.nglVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ShortBuffer pointer) {
        ARBVertexShader.nglVertexAttribPointerARB(index, size, type, normalized, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") IntBuffer pointer) {
        ARBVertexShader.nglVertexAttribPointerARB(index, size, type, normalized, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") FloatBuffer pointer) {
        ARBVertexShader.nglVertexAttribPointerARB(index, size, type, normalized, stride, MemoryUtil.memAddress(pointer));
    }

    public static native void glEnableVertexAttribArrayARB(@NativeType(value="GLuint") int var0);

    public static native void glDisableVertexAttribArrayARB(@NativeType(value="GLuint") int var0);

    public static native void nglBindAttribLocationARB(int var0, int var1, long var2);

    public static void glBindAttribLocationARB(@NativeType(value="GLhandleARB") int programObj, @NativeType(value="GLuint") int index, @NativeType(value="GLchar const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        ARBVertexShader.nglBindAttribLocationARB(programObj, index, MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glBindAttribLocationARB(@NativeType(value="GLhandleARB") int programObj, @NativeType(value="GLuint") int index, @NativeType(value="GLchar const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(name, true);
            long nameEncoded = stack.getPointerAddress();
            ARBVertexShader.nglBindAttribLocationARB(programObj, index, nameEncoded);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetActiveAttribARB(int var0, int var1, int var2, long var3, long var5, long var7, long var9);

    public static void glGetActiveAttribARB(@NativeType(value="GLhandleARB") int programObj, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLint *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type, @NativeType(value="GLchar *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, 1);
            Checks.check((Buffer)size, 1);
            Checks.check((Buffer)type, 1);
        }
        ARBVertexShader.nglGetActiveAttribARB(programObj, index, name.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetActiveAttribARB(@NativeType(value="GLhandleARB") int programObj, @NativeType(value="GLuint") int index, @NativeType(value="GLsizei") int maxLength, @NativeType(value="GLint *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)size, 1);
            Checks.check((Buffer)type, 1);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer length = stack.ints(0);
            ByteBuffer name = stack.malloc(maxLength);
            ARBVertexShader.nglGetActiveAttribARB(programObj, index, maxLength, MemoryUtil.memAddress(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
            String string = MemoryUtil.memASCII(name, length.get(0));
            return string;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="void")
    public static String glGetActiveAttribARB(@NativeType(value="GLhandleARB") int programObj, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type) {
        return ARBVertexShader.glGetActiveAttribARB(programObj, index, ARBShaderObjects.glGetObjectParameteriARB(programObj, 35722), size, type);
    }

    public static native int nglGetAttribLocationARB(int var0, long var1);

    @NativeType(value="GLint")
    public static int glGetAttribLocationARB(@NativeType(value="GLhandleARB") int programObj, @NativeType(value="GLchar const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return ARBVertexShader.nglGetAttribLocationARB(programObj, MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLint")
    public static int glGetAttribLocationARB(@NativeType(value="GLhandleARB") int programObj, @NativeType(value="GLchar const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(name, true);
            long nameEncoded = stack.getPointerAddress();
            int n = ARBVertexShader.nglGetAttribLocationARB(programObj, nameEncoded);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetVertexAttribivARB(int var0, int var1, long var2);

    public static void glGetVertexAttribivARB(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        ARBVertexShader.nglGetVertexAttribivARB(index, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetVertexAttribiARB(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            ARBVertexShader.nglGetVertexAttribivARB(index, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetVertexAttribfvARB(int var0, int var1, long var2);

    public static void glGetVertexAttribfvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        ARBVertexShader.nglGetVertexAttribfvARB(index, pname, MemoryUtil.memAddress(params));
    }

    public static native void nglGetVertexAttribdvARB(int var0, int var1, long var2);

    public static void glGetVertexAttribdvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLdouble *") DoubleBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        ARBVertexShader.nglGetVertexAttribdvARB(index, pname, MemoryUtil.memAddress(params));
    }

    public static native void nglGetVertexAttribPointervARB(int var0, int var1, long var2);

    public static void glGetVertexAttribPointervARB(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="void **") PointerBuffer pointer) {
        if (Checks.CHECKS) {
            Checks.check(pointer, 1);
        }
        ARBVertexShader.nglGetVertexAttribPointervARB(index, pname, MemoryUtil.memAddress(pointer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetVertexAttribPointerARB(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            PointerBuffer pointer = stack.callocPointer(1);
            ARBVertexShader.nglGetVertexAttribPointervARB(index, pname, MemoryUtil.memAddress(pointer));
            long l = pointer.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glVertexAttrib1fvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib1fvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib1svARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib1svARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib1dvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib1dvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib2fvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib2fvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib2svARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib2svARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib2dvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib2dvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib3fvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib3fvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib3svARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib3svARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib3dvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib3dvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib4fvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib4fvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib4svARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib4svARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib4dvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib4dvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib4ivARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib4ivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib4usvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLushort const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib4usvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib4uivARB(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib4uivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib4NsvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib4NsvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib4NivARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib4NivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib4NusvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLushort const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib4NusvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib4NuivARB(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib4NuivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") short[] pointer) {
        long __functionAddress = GL.getICD().glVertexAttribPointerARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(index, size, type, normalized, stride, pointer, __functionAddress);
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") int[] pointer) {
        long __functionAddress = GL.getICD().glVertexAttribPointerARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(index, size, type, normalized, stride, pointer, __functionAddress);
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") float[] pointer) {
        long __functionAddress = GL.getICD().glVertexAttribPointerARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(index, size, type, normalized, stride, pointer, __functionAddress);
    }

    public static void glGetActiveAttribARB(@NativeType(value="GLhandleARB") int programObj, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLint *") int[] size, @NativeType(value="GLenum *") int[] type, @NativeType(value="GLchar *") ByteBuffer name) {
        long __functionAddress = GL.getICD().glGetActiveAttribARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, 1);
            Checks.check(size, 1);
            Checks.check(type, 1);
        }
        JNI.callPPPPV(programObj, index, name.remaining(), length, size, type, MemoryUtil.memAddress(name), __functionAddress);
    }

    public static void glGetVertexAttribivARB(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetVertexAttribivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(index, pname, params, __functionAddress);
    }

    public static void glGetVertexAttribfvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetVertexAttribfvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(index, pname, params, __functionAddress);
    }

    public static void glGetVertexAttribdvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLdouble *") double[] params) {
        long __functionAddress = GL.getICD().glGetVertexAttribdvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(index, pname, params, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

