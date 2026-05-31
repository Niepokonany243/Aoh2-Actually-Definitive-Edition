/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.ARBVertexShader;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBVertexProgram {
    public static final int GL_VERTEX_PROGRAM_ARB = 34336;
    public static final int GL_VERTEX_PROGRAM_POINT_SIZE_ARB = 34370;
    public static final int GL_VERTEX_PROGRAM_TWO_SIDE_ARB = 34371;
    public static final int GL_COLOR_SUM_ARB = 33880;
    public static final int GL_PROGRAM_FORMAT_ASCII_ARB = 34933;
    public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED_ARB = 34338;
    public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE_ARB = 34339;
    public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE_ARB = 34340;
    public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE_ARB = 34341;
    public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED_ARB = 34922;
    public static final int GL_CURRENT_VERTEX_ATTRIB_ARB = 34342;
    public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER_ARB = 34373;
    public static final int GL_PROGRAM_LENGTH_ARB = 34343;
    public static final int GL_PROGRAM_FORMAT_ARB = 34934;
    public static final int GL_PROGRAM_BINDING_ARB = 34423;
    public static final int GL_PROGRAM_INSTRUCTIONS_ARB = 34976;
    public static final int GL_MAX_PROGRAM_INSTRUCTIONS_ARB = 34977;
    public static final int GL_PROGRAM_NATIVE_INSTRUCTIONS_ARB = 34978;
    public static final int GL_MAX_PROGRAM_NATIVE_INSTRUCTIONS_ARB = 34979;
    public static final int GL_PROGRAM_TEMPORARIES_ARB = 34980;
    public static final int GL_MAX_PROGRAM_TEMPORARIES_ARB = 34981;
    public static final int GL_PROGRAM_NATIVE_TEMPORARIES_ARB = 34982;
    public static final int GL_MAX_PROGRAM_NATIVE_TEMPORARIES_ARB = 34983;
    public static final int GL_PROGRAM_PARAMETERS_ARB = 34984;
    public static final int GL_MAX_PROGRAM_PARAMETERS_ARB = 34985;
    public static final int GL_PROGRAM_NATIVE_PARAMETERS_ARB = 34986;
    public static final int GL_MAX_PROGRAM_NATIVE_PARAMETERS_ARB = 34987;
    public static final int GL_PROGRAM_ATTRIBS_ARB = 34988;
    public static final int GL_MAX_PROGRAM_ATTRIBS_ARB = 34989;
    public static final int GL_PROGRAM_NATIVE_ATTRIBS_ARB = 34990;
    public static final int GL_MAX_PROGRAM_NATIVE_ATTRIBS_ARB = 34991;
    public static final int GL_PROGRAM_ADDRESS_REGISTERS_ARB = 34992;
    public static final int GL_MAX_PROGRAM_ADDRESS_REGISTERS_ARB = 34993;
    public static final int GL_PROGRAM_NATIVE_ADDRESS_REGISTERS_ARB = 34994;
    public static final int GL_MAX_PROGRAM_NATIVE_ADDRESS_REGISTERS_ARB = 34995;
    public static final int GL_MAX_PROGRAM_LOCAL_PARAMETERS_ARB = 34996;
    public static final int GL_MAX_PROGRAM_ENV_PARAMETERS_ARB = 34997;
    public static final int GL_PROGRAM_UNDER_NATIVE_LIMITS_ARB = 34998;
    public static final int GL_PROGRAM_STRING_ARB = 34344;
    public static final int GL_PROGRAM_ERROR_POSITION_ARB = 34379;
    public static final int GL_CURRENT_MATRIX_ARB = 34369;
    public static final int GL_TRANSPOSE_CURRENT_MATRIX_ARB = 34999;
    public static final int GL_CURRENT_MATRIX_STACK_DEPTH_ARB = 34368;
    public static final int GL_MAX_VERTEX_ATTRIBS_ARB = 34921;
    public static final int GL_MAX_PROGRAM_MATRICES_ARB = 34351;
    public static final int GL_MAX_PROGRAM_MATRIX_STACK_DEPTH_ARB = 34350;
    public static final int GL_PROGRAM_ERROR_STRING_ARB = 34932;
    public static final int GL_MATRIX0_ARB = 35008;
    public static final int GL_MATRIX1_ARB = 35009;
    public static final int GL_MATRIX2_ARB = 35010;
    public static final int GL_MATRIX3_ARB = 35011;
    public static final int GL_MATRIX4_ARB = 35012;
    public static final int GL_MATRIX5_ARB = 35013;
    public static final int GL_MATRIX6_ARB = 35014;
    public static final int GL_MATRIX7_ARB = 35015;
    public static final int GL_MATRIX8_ARB = 35016;
    public static final int GL_MATRIX9_ARB = 35017;
    public static final int GL_MATRIX10_ARB = 35018;
    public static final int GL_MATRIX11_ARB = 35019;
    public static final int GL_MATRIX12_ARB = 35020;
    public static final int GL_MATRIX13_ARB = 35021;
    public static final int GL_MATRIX14_ARB = 35022;
    public static final int GL_MATRIX15_ARB = 35023;
    public static final int GL_MATRIX16_ARB = 35024;
    public static final int GL_MATRIX17_ARB = 35025;
    public static final int GL_MATRIX18_ARB = 35026;
    public static final int GL_MATRIX19_ARB = 35027;
    public static final int GL_MATRIX20_ARB = 35028;
    public static final int GL_MATRIX21_ARB = 35029;
    public static final int GL_MATRIX22_ARB = 35030;
    public static final int GL_MATRIX23_ARB = 35031;
    public static final int GL_MATRIX24_ARB = 35032;
    public static final int GL_MATRIX25_ARB = 35033;
    public static final int GL_MATRIX26_ARB = 35034;
    public static final int GL_MATRIX27_ARB = 35035;
    public static final int GL_MATRIX28_ARB = 35036;
    public static final int GL_MATRIX29_ARB = 35037;
    public static final int GL_MATRIX30_ARB = 35038;
    public static final int GL_MATRIX31_ARB = 35039;

    protected ARBVertexProgram() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glVertexAttrib1sARB, caps.glVertexAttrib1fARB, caps.glVertexAttrib1dARB, caps.glVertexAttrib2sARB, caps.glVertexAttrib2fARB, caps.glVertexAttrib2dARB, caps.glVertexAttrib3sARB, caps.glVertexAttrib3fARB, caps.glVertexAttrib3dARB, caps.glVertexAttrib4sARB, caps.glVertexAttrib4fARB, caps.glVertexAttrib4dARB, caps.glVertexAttrib4NubARB, caps.glVertexAttrib1svARB, caps.glVertexAttrib1fvARB, caps.glVertexAttrib1dvARB, caps.glVertexAttrib2svARB, caps.glVertexAttrib2fvARB, caps.glVertexAttrib2dvARB, caps.glVertexAttrib3svARB, caps.glVertexAttrib3fvARB, caps.glVertexAttrib3dvARB, caps.glVertexAttrib4fvARB, caps.glVertexAttrib4bvARB, caps.glVertexAttrib4svARB, caps.glVertexAttrib4ivARB, caps.glVertexAttrib4ubvARB, caps.glVertexAttrib4usvARB, caps.glVertexAttrib4uivARB, caps.glVertexAttrib4dvARB, caps.glVertexAttrib4NbvARB, caps.glVertexAttrib4NsvARB, caps.glVertexAttrib4NivARB, caps.glVertexAttrib4NubvARB, caps.glVertexAttrib4NusvARB, caps.glVertexAttrib4NuivARB, caps.glVertexAttribPointerARB, caps.glEnableVertexAttribArrayARB, caps.glDisableVertexAttribArrayARB, caps.glProgramStringARB, caps.glBindProgramARB, caps.glDeleteProgramsARB, caps.glGenProgramsARB, caps.glProgramEnvParameter4dARB, caps.glProgramEnvParameter4dvARB, caps.glProgramEnvParameter4fARB, caps.glProgramEnvParameter4fvARB, caps.glProgramLocalParameter4dARB, caps.glProgramLocalParameter4dvARB, caps.glProgramLocalParameter4fARB, caps.glProgramLocalParameter4fvARB, caps.glGetProgramEnvParameterfvARB, caps.glGetProgramEnvParameterdvARB, caps.glGetProgramLocalParameterfvARB, caps.glGetProgramLocalParameterdvARB, caps.glGetProgramivARB, caps.glGetProgramStringARB, caps.glGetVertexAttribfvARB, caps.glGetVertexAttribdvARB, caps.glGetVertexAttribivARB, caps.glGetVertexAttribPointervARB, caps.glIsProgramARB);
    }

    public static void glVertexAttrib1sARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort") short v0) {
        ARBVertexShader.glVertexAttrib1sARB(index, v0);
    }

    public static void glVertexAttrib1fARB(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat") float v0) {
        ARBVertexShader.glVertexAttrib1fARB(index, v0);
    }

    public static void glVertexAttrib1dARB(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble") double v0) {
        ARBVertexShader.glVertexAttrib1dARB(index, v0);
    }

    public static void glVertexAttrib2sARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort") short v0, @NativeType(value="GLshort") short v1) {
        ARBVertexShader.glVertexAttrib2sARB(index, v0, v1);
    }

    public static void glVertexAttrib2fARB(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat") float v0, @NativeType(value="GLfloat") float v1) {
        ARBVertexShader.glVertexAttrib2fARB(index, v0, v1);
    }

    public static void glVertexAttrib2dARB(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble") double v0, @NativeType(value="GLdouble") double v1) {
        ARBVertexShader.glVertexAttrib2dARB(index, v0, v1);
    }

    public static void glVertexAttrib3sARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort") short v0, @NativeType(value="GLshort") short v1, @NativeType(value="GLshort") short v2) {
        ARBVertexShader.glVertexAttrib3sARB(index, v0, v1, v2);
    }

    public static void glVertexAttrib3fARB(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat") float v0, @NativeType(value="GLfloat") float v1, @NativeType(value="GLfloat") float v2) {
        ARBVertexShader.glVertexAttrib3fARB(index, v0, v1, v2);
    }

    public static void glVertexAttrib3dARB(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble") double v0, @NativeType(value="GLdouble") double v1, @NativeType(value="GLdouble") double v2) {
        ARBVertexShader.glVertexAttrib3dARB(index, v0, v1, v2);
    }

    public static void glVertexAttrib4sARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort") short v0, @NativeType(value="GLshort") short v1, @NativeType(value="GLshort") short v2, @NativeType(value="GLshort") short v3) {
        ARBVertexShader.glVertexAttrib4sARB(index, v0, v1, v2, v3);
    }

    public static void glVertexAttrib4fARB(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat") float v0, @NativeType(value="GLfloat") float v1, @NativeType(value="GLfloat") float v2, @NativeType(value="GLfloat") float v3) {
        ARBVertexShader.glVertexAttrib4fARB(index, v0, v1, v2, v3);
    }

    public static void glVertexAttrib4dARB(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble") double v0, @NativeType(value="GLdouble") double v1, @NativeType(value="GLdouble") double v2, @NativeType(value="GLdouble") double v3) {
        ARBVertexShader.glVertexAttrib4dARB(index, v0, v1, v2, v3);
    }

    public static void glVertexAttrib4NubARB(@NativeType(value="GLuint") int index, @NativeType(value="GLubyte") byte x, @NativeType(value="GLubyte") byte y, @NativeType(value="GLubyte") byte z, @NativeType(value="GLubyte") byte w) {
        ARBVertexShader.glVertexAttrib4NubARB(index, x, y, z, w);
    }

    public static void nglVertexAttrib1svARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib1svARB(index, v);
    }

    public static void glVertexAttrib1svARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        ARBVertexShader.glVertexAttrib1svARB(index, v);
    }

    public static void nglVertexAttrib1fvARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib1fvARB(index, v);
    }

    public static void glVertexAttrib1fvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer v) {
        ARBVertexShader.glVertexAttrib1fvARB(index, v);
    }

    public static void nglVertexAttrib1dvARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib1dvARB(index, v);
    }

    public static void glVertexAttrib1dvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        ARBVertexShader.glVertexAttrib1dvARB(index, v);
    }

    public static void nglVertexAttrib2svARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib2svARB(index, v);
    }

    public static void glVertexAttrib2svARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        ARBVertexShader.glVertexAttrib2svARB(index, v);
    }

    public static void nglVertexAttrib2fvARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib2fvARB(index, v);
    }

    public static void glVertexAttrib2fvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer v) {
        ARBVertexShader.glVertexAttrib2fvARB(index, v);
    }

    public static void nglVertexAttrib2dvARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib2dvARB(index, v);
    }

    public static void glVertexAttrib2dvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        ARBVertexShader.glVertexAttrib2dvARB(index, v);
    }

    public static void nglVertexAttrib3svARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib3svARB(index, v);
    }

    public static void glVertexAttrib3svARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        ARBVertexShader.glVertexAttrib3svARB(index, v);
    }

    public static void nglVertexAttrib3fvARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib3fvARB(index, v);
    }

    public static void glVertexAttrib3fvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer v) {
        ARBVertexShader.glVertexAttrib3fvARB(index, v);
    }

    public static void nglVertexAttrib3dvARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib3dvARB(index, v);
    }

    public static void glVertexAttrib3dvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        ARBVertexShader.glVertexAttrib3dvARB(index, v);
    }

    public static void nglVertexAttrib4fvARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib4fvARB(index, v);
    }

    public static void glVertexAttrib4fvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer v) {
        ARBVertexShader.glVertexAttrib4fvARB(index, v);
    }

    public static void nglVertexAttrib4bvARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib4bvARB(index, v);
    }

    public static void glVertexAttrib4bvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLbyte const *") ByteBuffer v) {
        ARBVertexShader.glVertexAttrib4bvARB(index, v);
    }

    public static void nglVertexAttrib4svARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib4svARB(index, v);
    }

    public static void glVertexAttrib4svARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        ARBVertexShader.glVertexAttrib4svARB(index, v);
    }

    public static void nglVertexAttrib4ivARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib4ivARB(index, v);
    }

    public static void glVertexAttrib4ivARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer v) {
        ARBVertexShader.glVertexAttrib4ivARB(index, v);
    }

    public static void nglVertexAttrib4ubvARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib4ubvARB(index, v);
    }

    public static void glVertexAttrib4ubvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLubyte const *") ByteBuffer v) {
        ARBVertexShader.glVertexAttrib4ubvARB(index, v);
    }

    public static void nglVertexAttrib4usvARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib4usvARB(index, v);
    }

    public static void glVertexAttrib4usvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLushort const *") ShortBuffer v) {
        ARBVertexShader.glVertexAttrib4usvARB(index, v);
    }

    public static void nglVertexAttrib4uivARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib4uivARB(index, v);
    }

    public static void glVertexAttrib4uivARB(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") IntBuffer v) {
        ARBVertexShader.glVertexAttrib4uivARB(index, v);
    }

    public static void nglVertexAttrib4dvARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib4dvARB(index, v);
    }

    public static void glVertexAttrib4dvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer v) {
        ARBVertexShader.glVertexAttrib4dvARB(index, v);
    }

    public static void nglVertexAttrib4NbvARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib4NbvARB(index, v);
    }

    public static void glVertexAttrib4NbvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLbyte const *") ByteBuffer v) {
        ARBVertexShader.glVertexAttrib4NbvARB(index, v);
    }

    public static void nglVertexAttrib4NsvARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib4NsvARB(index, v);
    }

    public static void glVertexAttrib4NsvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        ARBVertexShader.glVertexAttrib4NsvARB(index, v);
    }

    public static void nglVertexAttrib4NivARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib4NivARB(index, v);
    }

    public static void glVertexAttrib4NivARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer v) {
        ARBVertexShader.glVertexAttrib4NivARB(index, v);
    }

    public static void nglVertexAttrib4NubvARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib4NubvARB(index, v);
    }

    public static void glVertexAttrib4NubvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLubyte const *") ByteBuffer v) {
        ARBVertexShader.glVertexAttrib4NubvARB(index, v);
    }

    public static void nglVertexAttrib4NusvARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib4NusvARB(index, v);
    }

    public static void glVertexAttrib4NusvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLushort const *") ShortBuffer v) {
        ARBVertexShader.glVertexAttrib4NusvARB(index, v);
    }

    public static void nglVertexAttrib4NuivARB(int index, long v) {
        ARBVertexShader.nglVertexAttrib4NuivARB(index, v);
    }

    public static void glVertexAttrib4NuivARB(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") IntBuffer v) {
        ARBVertexShader.glVertexAttrib4NuivARB(index, v);
    }

    public static void nglVertexAttribPointerARB(int index, int size, int type, boolean normalized, int stride, long pointer) {
        ARBVertexShader.nglVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ByteBuffer pointer) {
        ARBVertexShader.glVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") long pointer) {
        ARBVertexShader.glVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ShortBuffer pointer) {
        ARBVertexShader.glVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") IntBuffer pointer) {
        ARBVertexShader.glVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") FloatBuffer pointer) {
        ARBVertexShader.glVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
    }

    public static void glEnableVertexAttribArrayARB(@NativeType(value="GLuint") int index) {
        ARBVertexShader.glEnableVertexAttribArrayARB(index);
    }

    public static void glDisableVertexAttribArrayARB(@NativeType(value="GLuint") int index) {
        ARBVertexShader.glDisableVertexAttribArrayARB(index);
    }

    public static native void nglProgramStringARB(int var0, int var1, int var2, long var3);

    public static void glProgramStringARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="void const *") ByteBuffer string) {
        ARBVertexProgram.nglProgramStringARB(target, format, string.remaining(), MemoryUtil.memAddress(string));
    }

    public static native void glBindProgramARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglDeleteProgramsARB(int var0, long var1);

    public static void glDeleteProgramsARB(@NativeType(value="GLuint const *") IntBuffer programs) {
        ARBVertexProgram.nglDeleteProgramsARB(programs.remaining(), MemoryUtil.memAddress(programs));
    }

    public static native void nglGenProgramsARB(int var0, long var1);

    public static void glGenProgramsARB(@NativeType(value="GLuint *") IntBuffer programs) {
        ARBVertexProgram.nglGenProgramsARB(programs.remaining(), MemoryUtil.memAddress(programs));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGenProgramsARB() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer programs = stack.callocInt(1);
            ARBVertexProgram.nglGenProgramsARB(1, MemoryUtil.memAddress(programs));
            int n = programs.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glProgramEnvParameter4dARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4, @NativeType(value="GLdouble") double var6, @NativeType(value="GLdouble") double var8);

    public static native void nglProgramEnvParameter4dvARB(int var0, int var1, long var2);

    public static void glProgramEnvParameter4dvARB(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        ARBVertexProgram.nglProgramEnvParameter4dvARB(target, index, MemoryUtil.memAddress(params));
    }

    public static native void glProgramEnvParameter4fARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLfloat") float var4, @NativeType(value="GLfloat") float var5);

    public static native void nglProgramEnvParameter4fvARB(int var0, int var1, long var2);

    public static void glProgramEnvParameter4fvARB(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        ARBVertexProgram.nglProgramEnvParameter4fvARB(target, index, MemoryUtil.memAddress(params));
    }

    public static native void glProgramLocalParameter4dARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLdouble") double var2, @NativeType(value="GLdouble") double var4, @NativeType(value="GLdouble") double var6, @NativeType(value="GLdouble") double var8);

    public static native void nglProgramLocalParameter4dvARB(int var0, int var1, long var2);

    public static void glProgramLocalParameter4dvARB(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        ARBVertexProgram.nglProgramLocalParameter4dvARB(target, index, MemoryUtil.memAddress(params));
    }

    public static native void glProgramLocalParameter4fARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLfloat") float var4, @NativeType(value="GLfloat") float var5);

    public static native void nglProgramLocalParameter4fvARB(int var0, int var1, long var2);

    public static void glProgramLocalParameter4fvARB(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        ARBVertexProgram.nglProgramLocalParameter4fvARB(target, index, MemoryUtil.memAddress(params));
    }

    public static native void nglGetProgramEnvParameterfvARB(int var0, int var1, long var2);

    public static void glGetProgramEnvParameterfvARB(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        ARBVertexProgram.nglGetProgramEnvParameterfvARB(target, index, MemoryUtil.memAddress(params));
    }

    public static native void nglGetProgramEnvParameterdvARB(int var0, int var1, long var2);

    public static void glGetProgramEnvParameterdvARB(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLdouble *") DoubleBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        ARBVertexProgram.nglGetProgramEnvParameterdvARB(target, index, MemoryUtil.memAddress(params));
    }

    public static native void nglGetProgramLocalParameterfvARB(int var0, int var1, long var2);

    public static void glGetProgramLocalParameterfvARB(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        ARBVertexProgram.nglGetProgramLocalParameterfvARB(target, index, MemoryUtil.memAddress(params));
    }

    public static native void nglGetProgramLocalParameterdvARB(int var0, int var1, long var2);

    public static void glGetProgramLocalParameterdvARB(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLdouble *") DoubleBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        ARBVertexProgram.nglGetProgramLocalParameterdvARB(target, index, MemoryUtil.memAddress(params));
    }

    public static native void nglGetProgramivARB(int var0, int var1, long var2);

    public static void glGetProgramivARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        ARBVertexProgram.nglGetProgramivARB(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetProgramiARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            ARBVertexProgram.nglGetProgramivARB(target, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetProgramStringARB(int var0, int var1, long var2);

    public static void glGetProgramStringARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="void *") ByteBuffer string) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)string, ARBVertexProgram.glGetProgramiARB(target, 34343));
        }
        ARBVertexProgram.nglGetProgramStringARB(target, pname, MemoryUtil.memAddress(string));
    }

    public static void nglGetVertexAttribfvARB(int index, int pname, long params) {
        ARBVertexShader.nglGetVertexAttribfvARB(index, pname, params);
    }

    public static void glGetVertexAttribfvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        ARBVertexShader.glGetVertexAttribfvARB(index, pname, params);
    }

    public static void nglGetVertexAttribdvARB(int index, int pname, long params) {
        ARBVertexShader.nglGetVertexAttribdvARB(index, pname, params);
    }

    public static void glGetVertexAttribdvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLdouble *") DoubleBuffer params) {
        ARBVertexShader.glGetVertexAttribdvARB(index, pname, params);
    }

    public static void nglGetVertexAttribivARB(int index, int pname, long params) {
        ARBVertexShader.nglGetVertexAttribivARB(index, pname, params);
    }

    public static void glGetVertexAttribivARB(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        ARBVertexShader.glGetVertexAttribivARB(index, pname, params);
    }

    @NativeType(value="void")
    public static int glGetVertexAttribiARB(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        return ARBVertexShader.glGetVertexAttribiARB(index, pname);
    }

    public static void nglGetVertexAttribPointervARB(int index, int pname, long pointer) {
        ARBVertexShader.nglGetVertexAttribPointervARB(index, pname, pointer);
    }

    public static void glGetVertexAttribPointervARB(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="void **") PointerBuffer pointer) {
        ARBVertexShader.glGetVertexAttribPointervARB(index, pname, pointer);
    }

    @NativeType(value="void")
    public static long glGetVertexAttribPointerARB(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        return ARBVertexShader.glGetVertexAttribPointerARB(index, pname);
    }

    @NativeType(value="GLboolean")
    public static native boolean glIsProgramARB(@NativeType(value="GLuint") int var0);

    public static void glVertexAttrib1svARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        ARBVertexShader.glVertexAttrib1svARB(index, v);
    }

    public static void glVertexAttrib1fvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] v) {
        ARBVertexShader.glVertexAttrib1fvARB(index, v);
    }

    public static void glVertexAttrib1dvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        ARBVertexShader.glVertexAttrib1dvARB(index, v);
    }

    public static void glVertexAttrib2svARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        ARBVertexShader.glVertexAttrib2svARB(index, v);
    }

    public static void glVertexAttrib2fvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] v) {
        ARBVertexShader.glVertexAttrib2fvARB(index, v);
    }

    public static void glVertexAttrib2dvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        ARBVertexShader.glVertexAttrib2dvARB(index, v);
    }

    public static void glVertexAttrib3svARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        ARBVertexShader.glVertexAttrib3svARB(index, v);
    }

    public static void glVertexAttrib3fvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] v) {
        ARBVertexShader.glVertexAttrib3fvARB(index, v);
    }

    public static void glVertexAttrib3dvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        ARBVertexShader.glVertexAttrib3dvARB(index, v);
    }

    public static void glVertexAttrib4fvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] v) {
        ARBVertexShader.glVertexAttrib4fvARB(index, v);
    }

    public static void glVertexAttrib4svARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        ARBVertexShader.glVertexAttrib4svARB(index, v);
    }

    public static void glVertexAttrib4ivARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] v) {
        ARBVertexShader.glVertexAttrib4ivARB(index, v);
    }

    public static void glVertexAttrib4usvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLushort const *") short[] v) {
        ARBVertexShader.glVertexAttrib4usvARB(index, v);
    }

    public static void glVertexAttrib4uivARB(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") int[] v) {
        ARBVertexShader.glVertexAttrib4uivARB(index, v);
    }

    public static void glVertexAttrib4dvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] v) {
        ARBVertexShader.glVertexAttrib4dvARB(index, v);
    }

    public static void glVertexAttrib4NsvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        ARBVertexShader.glVertexAttrib4NsvARB(index, v);
    }

    public static void glVertexAttrib4NivARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] v) {
        ARBVertexShader.glVertexAttrib4NivARB(index, v);
    }

    public static void glVertexAttrib4NusvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLushort const *") short[] v) {
        ARBVertexShader.glVertexAttrib4NusvARB(index, v);
    }

    public static void glVertexAttrib4NuivARB(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") int[] v) {
        ARBVertexShader.glVertexAttrib4NuivARB(index, v);
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") short[] pointer) {
        ARBVertexShader.glVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") int[] pointer) {
        ARBVertexShader.glVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
    }

    public static void glVertexAttribPointerARB(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") float[] pointer) {
        ARBVertexShader.glVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
    }

    public static void glDeleteProgramsARB(@NativeType(value="GLuint const *") int[] programs) {
        long __functionAddress = GL.getICD().glDeleteProgramsARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(programs.length, programs, __functionAddress);
    }

    public static void glGenProgramsARB(@NativeType(value="GLuint *") int[] programs) {
        long __functionAddress = GL.getICD().glGenProgramsARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(programs.length, programs, __functionAddress);
    }

    public static void glProgramEnvParameter4dvARB(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] params) {
        long __functionAddress = GL.getICD().glProgramEnvParameter4dvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(target, index, params, __functionAddress);
    }

    public static void glProgramEnvParameter4fvARB(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] params) {
        long __functionAddress = GL.getICD().glProgramEnvParameter4fvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(target, index, params, __functionAddress);
    }

    public static void glProgramLocalParameter4dvARB(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] params) {
        long __functionAddress = GL.getICD().glProgramLocalParameter4dvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(target, index, params, __functionAddress);
    }

    public static void glProgramLocalParameter4fvARB(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] params) {
        long __functionAddress = GL.getICD().glProgramLocalParameter4fvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(target, index, params, __functionAddress);
    }

    public static void glGetProgramEnvParameterfvARB(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetProgramEnvParameterfvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(target, index, params, __functionAddress);
    }

    public static void glGetProgramEnvParameterdvARB(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLdouble *") double[] params) {
        long __functionAddress = GL.getICD().glGetProgramEnvParameterdvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(target, index, params, __functionAddress);
    }

    public static void glGetProgramLocalParameterfvARB(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetProgramLocalParameterfvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(target, index, params, __functionAddress);
    }

    public static void glGetProgramLocalParameterdvARB(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLdouble *") double[] params) {
        long __functionAddress = GL.getICD().glGetProgramLocalParameterdvARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(target, index, params, __functionAddress);
    }

    public static void glGetProgramivARB(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetProgramivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glGetVertexAttribfvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        ARBVertexShader.glGetVertexAttribfvARB(index, pname, params);
    }

    public static void glGetVertexAttribdvARB(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLdouble *") double[] params) {
        ARBVertexShader.glGetVertexAttribdvARB(index, pname, params);
    }

    public static void glGetVertexAttribivARB(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        ARBVertexShader.glGetVertexAttribivARB(index, pname, params);
    }

    static {
        GL.initialize();
    }
}

