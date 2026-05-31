/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ShortBuffer;
import java.util.Set;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVHalfFloat {
    public static final int GL_HALF_FLOAT_NV = 5131;

    protected NVHalfFloat() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, Set<String> ext) {
        return Checks.checkFunctions(caps.glVertex2hNV, caps.glVertex2hvNV, caps.glVertex3hNV, caps.glVertex3hvNV, caps.glVertex4hNV, caps.glVertex4hvNV, caps.glNormal3hNV, caps.glNormal3hvNV, caps.glColor3hNV, caps.glColor3hvNV, caps.glColor4hNV, caps.glColor4hvNV, caps.glTexCoord1hNV, caps.glTexCoord1hvNV, caps.glTexCoord2hNV, caps.glTexCoord2hvNV, caps.glTexCoord3hNV, caps.glTexCoord3hvNV, caps.glTexCoord4hNV, caps.glTexCoord4hvNV, caps.glMultiTexCoord1hNV, caps.glMultiTexCoord1hvNV, caps.glMultiTexCoord2hNV, caps.glMultiTexCoord2hvNV, caps.glMultiTexCoord3hNV, caps.glMultiTexCoord3hvNV, caps.glMultiTexCoord4hNV, caps.glMultiTexCoord4hvNV, ext.contains("GL_EXT_fog_coord") ? caps.glFogCoordhNV : -1L, ext.contains("GL_EXT_fog_coord") ? caps.glFogCoordhvNV : -1L, ext.contains("GL_EXT_secondary_color") ? caps.glSecondaryColor3hNV : -1L, ext.contains("GL_EXT_secondary_color") ? caps.glSecondaryColor3hvNV : -1L, ext.contains("GL_EXT_vertex_weighting") ? caps.glVertexWeighthNV : -1L, ext.contains("GL_EXT_vertex_weighting") ? caps.glVertexWeighthvNV : -1L, ext.contains("GL_NV_vertex_program") ? caps.glVertexAttrib1hNV : -1L, ext.contains("GL_NV_vertex_program") ? caps.glVertexAttrib1hvNV : -1L, ext.contains("GL_NV_vertex_program") ? caps.glVertexAttrib2hNV : -1L, ext.contains("GL_NV_vertex_program") ? caps.glVertexAttrib2hvNV : -1L, ext.contains("GL_NV_vertex_program") ? caps.glVertexAttrib3hNV : -1L, ext.contains("GL_NV_vertex_program") ? caps.glVertexAttrib3hvNV : -1L, ext.contains("GL_NV_vertex_program") ? caps.glVertexAttrib4hNV : -1L, ext.contains("GL_NV_vertex_program") ? caps.glVertexAttrib4hvNV : -1L, ext.contains("GL_NV_vertex_program") ? caps.glVertexAttribs1hvNV : -1L, ext.contains("GL_NV_vertex_program") ? caps.glVertexAttribs2hvNV : -1L, ext.contains("GL_NV_vertex_program") ? caps.glVertexAttribs3hvNV : -1L, ext.contains("GL_NV_vertex_program") ? caps.glVertexAttribs4hvNV : -1L);
    }

    public static native void glVertex2hNV(@NativeType(value="GLhalfNV") short var0, @NativeType(value="GLhalfNV") short var1);

    public static native void nglVertex2hvNV(long var0);

    public static void glVertex2hvNV(@NativeType(value="GLhalfNV const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        NVHalfFloat.nglVertex2hvNV(MemoryUtil.memAddress(v));
    }

    public static native void glVertex3hNV(@NativeType(value="GLhalfNV") short var0, @NativeType(value="GLhalfNV") short var1, @NativeType(value="GLhalfNV") short var2);

    public static native void nglVertex3hvNV(long var0);

    public static void glVertex3hvNV(@NativeType(value="GLhalfNV const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        NVHalfFloat.nglVertex3hvNV(MemoryUtil.memAddress(v));
    }

    public static native void glVertex4hNV(@NativeType(value="GLhalfNV") short var0, @NativeType(value="GLhalfNV") short var1, @NativeType(value="GLhalfNV") short var2, @NativeType(value="GLhalfNV") short var3);

    public static native void nglVertex4hvNV(long var0);

    public static void glVertex4hvNV(@NativeType(value="GLhalfNV const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        NVHalfFloat.nglVertex4hvNV(MemoryUtil.memAddress(v));
    }

    public static native void glNormal3hNV(@NativeType(value="GLhalfNV") short var0, @NativeType(value="GLhalfNV") short var1, @NativeType(value="GLhalfNV") short var2);

    public static native void nglNormal3hvNV(long var0);

    public static void glNormal3hvNV(@NativeType(value="GLhalfNV const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        NVHalfFloat.nglNormal3hvNV(MemoryUtil.memAddress(v));
    }

    public static native void glColor3hNV(@NativeType(value="GLhalfNV") short var0, @NativeType(value="GLhalfNV") short var1, @NativeType(value="GLhalfNV") short var2);

    public static native void nglColor3hvNV(long var0);

    public static void glColor3hvNV(@NativeType(value="GLhalfNV const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        NVHalfFloat.nglColor3hvNV(MemoryUtil.memAddress(v));
    }

    public static native void glColor4hNV(@NativeType(value="GLhalfNV") short var0, @NativeType(value="GLhalfNV") short var1, @NativeType(value="GLhalfNV") short var2, @NativeType(value="GLhalfNV") short var3);

    public static native void nglColor4hvNV(long var0);

    public static void glColor4hvNV(@NativeType(value="GLhalfNV const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        NVHalfFloat.nglColor4hvNV(MemoryUtil.memAddress(v));
    }

    public static native void glTexCoord1hNV(@NativeType(value="GLhalfNV") short var0);

    public static native void nglTexCoord1hvNV(long var0);

    public static void glTexCoord1hvNV(@NativeType(value="GLhalfNV const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        NVHalfFloat.nglTexCoord1hvNV(MemoryUtil.memAddress(v));
    }

    public static native void glTexCoord2hNV(@NativeType(value="GLhalfNV") short var0, @NativeType(value="GLhalfNV") short var1);

    public static native void nglTexCoord2hvNV(long var0);

    public static void glTexCoord2hvNV(@NativeType(value="GLhalfNV const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        NVHalfFloat.nglTexCoord2hvNV(MemoryUtil.memAddress(v));
    }

    public static native void glTexCoord3hNV(@NativeType(value="GLhalfNV") short var0, @NativeType(value="GLhalfNV") short var1, @NativeType(value="GLhalfNV") short var2);

    public static native void nglTexCoord3hvNV(long var0);

    public static void glTexCoord3hvNV(@NativeType(value="GLhalfNV const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        NVHalfFloat.nglTexCoord3hvNV(MemoryUtil.memAddress(v));
    }

    public static native void glTexCoord4hNV(@NativeType(value="GLhalfNV") short var0, @NativeType(value="GLhalfNV") short var1, @NativeType(value="GLhalfNV") short var2, @NativeType(value="GLhalfNV") short var3);

    public static native void nglTexCoord4hvNV(long var0);

    public static void glTexCoord4hvNV(@NativeType(value="GLhalfNV const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        NVHalfFloat.nglTexCoord4hvNV(MemoryUtil.memAddress(v));
    }

    public static native void glMultiTexCoord1hNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLhalfNV") short var1);

    public static native void nglMultiTexCoord1hvNV(int var0, long var1);

    public static void glMultiTexCoord1hvNV(@NativeType(value="GLenum") int target, @NativeType(value="GLhalfNV const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        NVHalfFloat.nglMultiTexCoord1hvNV(target, MemoryUtil.memAddress(v));
    }

    public static native void glMultiTexCoord2hNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLhalfNV") short var1, @NativeType(value="GLhalfNV") short var2);

    public static native void nglMultiTexCoord2hvNV(int var0, long var1);

    public static void glMultiTexCoord2hvNV(@NativeType(value="GLenum") int target, @NativeType(value="GLhalfNV const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        NVHalfFloat.nglMultiTexCoord2hvNV(target, MemoryUtil.memAddress(v));
    }

    public static native void glMultiTexCoord3hNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLhalfNV") short var1, @NativeType(value="GLhalfNV") short var2, @NativeType(value="GLhalfNV") short var3);

    public static native void nglMultiTexCoord3hvNV(int var0, long var1);

    public static void glMultiTexCoord3hvNV(@NativeType(value="GLenum") int target, @NativeType(value="GLhalfNV const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        NVHalfFloat.nglMultiTexCoord3hvNV(target, MemoryUtil.memAddress(v));
    }

    public static native void glMultiTexCoord4hNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLhalfNV") short var1, @NativeType(value="GLhalfNV") short var2, @NativeType(value="GLhalfNV") short var3, @NativeType(value="GLhalfNV") short var4);

    public static native void nglMultiTexCoord4hvNV(int var0, long var1);

    public static void glMultiTexCoord4hvNV(@NativeType(value="GLenum") int target, @NativeType(value="GLhalfNV const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        NVHalfFloat.nglMultiTexCoord4hvNV(target, MemoryUtil.memAddress(v));
    }

    public static native void glFogCoordhNV(@NativeType(value="GLhalfNV") short var0);

    public static native void nglFogCoordhvNV(long var0);

    public static void glFogCoordhvNV(@NativeType(value="GLhalfNV const *") ShortBuffer fog) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)fog, 1);
        }
        NVHalfFloat.nglFogCoordhvNV(MemoryUtil.memAddress(fog));
    }

    public static native void glSecondaryColor3hNV(@NativeType(value="GLhalfNV") short var0, @NativeType(value="GLhalfNV") short var1, @NativeType(value="GLhalfNV") short var2);

    public static native void nglSecondaryColor3hvNV(long var0);

    public static void glSecondaryColor3hvNV(@NativeType(value="GLhalfNV const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        NVHalfFloat.nglSecondaryColor3hvNV(MemoryUtil.memAddress(v));
    }

    public static native void glVertexWeighthNV(@NativeType(value="GLhalfNV") short var0);

    public static native void nglVertexWeighthvNV(long var0);

    public static void glVertexWeighthvNV(@NativeType(value="GLhalfNV const *") ShortBuffer weight) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)weight, 1);
        }
        NVHalfFloat.nglVertexWeighthvNV(MemoryUtil.memAddress(weight));
    }

    public static native void glVertexAttrib1hNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLhalfNV") short var1);

    public static native void nglVertexAttrib1hvNV(int var0, long var1);

    public static void glVertexAttrib1hvNV(@NativeType(value="GLuint") int index, @NativeType(value="GLhalfNV const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        NVHalfFloat.nglVertexAttrib1hvNV(index, MemoryUtil.memAddress(v));
    }

    public static native void glVertexAttrib2hNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLhalfNV") short var1, @NativeType(value="GLhalfNV") short var2);

    public static native void nglVertexAttrib2hvNV(int var0, long var1);

    public static void glVertexAttrib2hvNV(@NativeType(value="GLuint") int index, @NativeType(value="GLhalfNV const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        NVHalfFloat.nglVertexAttrib2hvNV(index, MemoryUtil.memAddress(v));
    }

    public static native void glVertexAttrib3hNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLhalfNV") short var1, @NativeType(value="GLhalfNV") short var2, @NativeType(value="GLhalfNV") short var3);

    public static native void nglVertexAttrib3hvNV(int var0, long var1);

    public static void glVertexAttrib3hvNV(@NativeType(value="GLuint") int index, @NativeType(value="GLhalfNV const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        NVHalfFloat.nglVertexAttrib3hvNV(index, MemoryUtil.memAddress(v));
    }

    public static native void glVertexAttrib4hNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLhalfNV") short var1, @NativeType(value="GLhalfNV") short var2, @NativeType(value="GLhalfNV") short var3, @NativeType(value="GLhalfNV") short var4);

    public static native void nglVertexAttrib4hvNV(int var0, long var1);

    public static void glVertexAttrib4hvNV(@NativeType(value="GLuint") int index, @NativeType(value="GLhalfNV const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        NVHalfFloat.nglVertexAttrib4hvNV(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribs1hvNV(int var0, int var1, long var2);

    public static void glVertexAttribs1hvNV(@NativeType(value="GLuint") int index, @NativeType(value="GLhalfNV const *") ShortBuffer v) {
        NVHalfFloat.nglVertexAttribs1hvNV(index, v.remaining(), MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribs2hvNV(int var0, int var1, long var2);

    public static void glVertexAttribs2hvNV(@NativeType(value="GLuint") int index, @NativeType(value="GLhalfNV const *") ShortBuffer v) {
        NVHalfFloat.nglVertexAttribs2hvNV(index, v.remaining() >> 1, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribs3hvNV(int var0, int var1, long var2);

    public static void glVertexAttribs3hvNV(@NativeType(value="GLuint") int index, @NativeType(value="GLhalfNV const *") ShortBuffer v) {
        NVHalfFloat.nglVertexAttribs3hvNV(index, v.remaining() / 3, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribs4hvNV(int var0, int var1, long var2);

    public static void glVertexAttribs4hvNV(@NativeType(value="GLuint") int index, @NativeType(value="GLhalfNV const *") ShortBuffer v) {
        NVHalfFloat.nglVertexAttribs4hvNV(index, v.remaining() >> 2, MemoryUtil.memAddress(v));
    }

    public static void glVertex2hvNV(@NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glVertex2hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glVertex3hvNV(@NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glVertex3hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glVertex4hvNV(@NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glVertex4hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glNormal3hvNV(@NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glNormal3hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glColor3hvNV(@NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glColor3hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glColor4hvNV(@NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glColor4hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glTexCoord1hvNV(@NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glTexCoord1hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glTexCoord2hvNV(@NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glTexCoord2hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glTexCoord3hvNV(@NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glTexCoord3hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glTexCoord4hvNV(@NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glTexCoord4hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glMultiTexCoord1hvNV(@NativeType(value="GLenum") int target, @NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord1hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(target, v, __functionAddress);
    }

    public static void glMultiTexCoord2hvNV(@NativeType(value="GLenum") int target, @NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord2hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(target, v, __functionAddress);
    }

    public static void glMultiTexCoord3hvNV(@NativeType(value="GLenum") int target, @NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord3hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(target, v, __functionAddress);
    }

    public static void glMultiTexCoord4hvNV(@NativeType(value="GLenum") int target, @NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glMultiTexCoord4hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(target, v, __functionAddress);
    }

    public static void glFogCoordhvNV(@NativeType(value="GLhalfNV const *") short[] fog) {
        long __functionAddress = GL.getICD().glFogCoordhvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(fog, 1);
        }
        JNI.callPV(fog, __functionAddress);
    }

    public static void glSecondaryColor3hvNV(@NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glSecondaryColor3hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(v, __functionAddress);
    }

    public static void glVertexWeighthvNV(@NativeType(value="GLhalfNV const *") short[] weight) {
        long __functionAddress = GL.getICD().glVertexWeighthvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(weight, 1);
        }
        JNI.callPV(weight, __functionAddress);
    }

    public static void glVertexAttrib1hvNV(@NativeType(value="GLuint") int index, @NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib1hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib2hvNV(@NativeType(value="GLuint") int index, @NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib2hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib3hvNV(@NativeType(value="GLuint") int index, @NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib3hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttrib4hvNV(@NativeType(value="GLuint") int index, @NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttrib4hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribs1hvNV(@NativeType(value="GLuint") int index, @NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttribs1hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(index, v.length, v, __functionAddress);
    }

    public static void glVertexAttribs2hvNV(@NativeType(value="GLuint") int index, @NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttribs2hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(index, v.length >> 1, v, __functionAddress);
    }

    public static void glVertexAttribs3hvNV(@NativeType(value="GLuint") int index, @NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttribs3hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(index, v.length / 3, v, __functionAddress);
    }

    public static void glVertexAttribs4hvNV(@NativeType(value="GLuint") int index, @NativeType(value="GLhalfNV const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttribs4hvNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(index, v.length >> 2, v, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

