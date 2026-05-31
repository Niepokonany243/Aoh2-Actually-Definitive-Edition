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
import java.util.Set;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.EXTDrawBuffers2;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTDirectStateAccess {
    public static final int GL_PROGRAM_MATRIX_EXT = 36397;
    public static final int GL_TRANSPOSE_PROGRAM_MATRIX_EXT = 36398;
    public static final int GL_PROGRAM_MATRIX_STACK_DEPTH_EXT = 36399;

    protected EXTDirectStateAccess() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, Set<String> ext) {
        return Checks.checkFunctions(caps.glClientAttribDefaultEXT, caps.glPushClientAttribDefaultEXT, caps.glMatrixLoadfEXT, caps.glMatrixLoaddEXT, caps.glMatrixMultfEXT, caps.glMatrixMultdEXT, caps.glMatrixLoadIdentityEXT, caps.glMatrixRotatefEXT, caps.glMatrixRotatedEXT, caps.glMatrixScalefEXT, caps.glMatrixScaledEXT, caps.glMatrixTranslatefEXT, caps.glMatrixTranslatedEXT, caps.glMatrixOrthoEXT, caps.glMatrixFrustumEXT, caps.glMatrixPushEXT, caps.glMatrixPopEXT, caps.glTextureParameteriEXT, caps.glTextureParameterivEXT, caps.glTextureParameterfEXT, caps.glTextureParameterfvEXT, caps.glTextureImage1DEXT, caps.glTextureImage2DEXT, caps.glTextureSubImage1DEXT, caps.glTextureSubImage2DEXT, caps.glCopyTextureImage1DEXT, caps.glCopyTextureImage2DEXT, caps.glCopyTextureSubImage1DEXT, caps.glCopyTextureSubImage2DEXT, caps.glGetTextureImageEXT, caps.glGetTextureParameterfvEXT, caps.glGetTextureParameterivEXT, caps.glGetTextureLevelParameterfvEXT, caps.glGetTextureLevelParameterivEXT, ext.contains("OpenGL12") ? caps.glTextureImage3DEXT : -1L, ext.contains("OpenGL12") ? caps.glTextureSubImage3DEXT : -1L, ext.contains("OpenGL12") ? caps.glCopyTextureSubImage3DEXT : -1L, ext.contains("OpenGL13") ? caps.glBindMultiTextureEXT : -1L, ext.contains("OpenGL13") ? caps.glMultiTexCoordPointerEXT : -1L, ext.contains("OpenGL13") ? caps.glMultiTexEnvfEXT : -1L, ext.contains("OpenGL13") ? caps.glMultiTexEnvfvEXT : -1L, ext.contains("OpenGL13") ? caps.glMultiTexEnviEXT : -1L, ext.contains("OpenGL13") ? caps.glMultiTexEnvivEXT : -1L, ext.contains("OpenGL13") ? caps.glMultiTexGendEXT : -1L, ext.contains("OpenGL13") ? caps.glMultiTexGendvEXT : -1L, ext.contains("OpenGL13") ? caps.glMultiTexGenfEXT : -1L, ext.contains("OpenGL13") ? caps.glMultiTexGenfvEXT : -1L, ext.contains("OpenGL13") ? caps.glMultiTexGeniEXT : -1L, ext.contains("OpenGL13") ? caps.glMultiTexGenivEXT : -1L, ext.contains("OpenGL13") ? caps.glGetMultiTexEnvfvEXT : -1L, ext.contains("OpenGL13") ? caps.glGetMultiTexEnvivEXT : -1L, ext.contains("OpenGL13") ? caps.glGetMultiTexGendvEXT : -1L, ext.contains("OpenGL13") ? caps.glGetMultiTexGenfvEXT : -1L, ext.contains("OpenGL13") ? caps.glGetMultiTexGenivEXT : -1L, ext.contains("OpenGL13") ? caps.glMultiTexParameteriEXT : -1L, ext.contains("OpenGL13") ? caps.glMultiTexParameterivEXT : -1L, ext.contains("OpenGL13") ? caps.glMultiTexParameterfEXT : -1L, ext.contains("OpenGL13") ? caps.glMultiTexParameterfvEXT : -1L, ext.contains("OpenGL13") ? caps.glMultiTexImage1DEXT : -1L, ext.contains("OpenGL13") ? caps.glMultiTexImage2DEXT : -1L, ext.contains("OpenGL13") ? caps.glMultiTexSubImage1DEXT : -1L, ext.contains("OpenGL13") ? caps.glMultiTexSubImage2DEXT : -1L, ext.contains("OpenGL13") ? caps.glCopyMultiTexImage1DEXT : -1L, ext.contains("OpenGL13") ? caps.glCopyMultiTexImage2DEXT : -1L, ext.contains("OpenGL13") ? caps.glCopyMultiTexSubImage1DEXT : -1L, ext.contains("OpenGL13") ? caps.glCopyMultiTexSubImage2DEXT : -1L, ext.contains("OpenGL13") ? caps.glGetMultiTexImageEXT : -1L, ext.contains("OpenGL13") ? caps.glGetMultiTexParameterfvEXT : -1L, ext.contains("OpenGL13") ? caps.glGetMultiTexParameterivEXT : -1L, ext.contains("OpenGL13") ? caps.glGetMultiTexLevelParameterfvEXT : -1L, ext.contains("OpenGL13") ? caps.glGetMultiTexLevelParameterivEXT : -1L, ext.contains("OpenGL13") ? caps.glMultiTexImage3DEXT : -1L, ext.contains("OpenGL13") ? caps.glMultiTexSubImage3DEXT : -1L, ext.contains("OpenGL13") ? caps.glCopyMultiTexSubImage3DEXT : -1L, ext.contains("OpenGL13") ? caps.glEnableClientStateIndexedEXT : -1L, ext.contains("OpenGL13") ? caps.glDisableClientStateIndexedEXT : -1L, ext.contains("OpenGL13") ? caps.glGetFloatIndexedvEXT : -1L, ext.contains("OpenGL13") ? caps.glGetDoubleIndexedvEXT : -1L, ext.contains("OpenGL13") ? caps.glGetPointerIndexedvEXT : -1L, ext.contains("OpenGL13") ? caps.glEnableIndexedEXT : -1L, ext.contains("OpenGL13") ? caps.glDisableIndexedEXT : -1L, ext.contains("OpenGL13") ? caps.glIsEnabledIndexedEXT : -1L, ext.contains("OpenGL13") ? caps.glGetIntegerIndexedvEXT : -1L, ext.contains("OpenGL13") ? caps.glGetBooleanIndexedvEXT : -1L, ext.contains("GL_ARB_vertex_program") ? caps.glNamedProgramStringEXT : -1L, ext.contains("GL_ARB_vertex_program") ? caps.glNamedProgramLocalParameter4dEXT : -1L, ext.contains("GL_ARB_vertex_program") ? caps.glNamedProgramLocalParameter4dvEXT : -1L, ext.contains("GL_ARB_vertex_program") ? caps.glNamedProgramLocalParameter4fEXT : -1L, ext.contains("GL_ARB_vertex_program") ? caps.glNamedProgramLocalParameter4fvEXT : -1L, ext.contains("GL_ARB_vertex_program") ? caps.glGetNamedProgramLocalParameterdvEXT : -1L, ext.contains("GL_ARB_vertex_program") ? caps.glGetNamedProgramLocalParameterfvEXT : -1L, ext.contains("GL_ARB_vertex_program") ? caps.glGetNamedProgramivEXT : -1L, ext.contains("GL_ARB_vertex_program") ? caps.glGetNamedProgramStringEXT : -1L, ext.contains("OpenGL13") ? caps.glCompressedTextureImage3DEXT : -1L, ext.contains("OpenGL13") ? caps.glCompressedTextureImage2DEXT : -1L, ext.contains("OpenGL13") ? caps.glCompressedTextureImage1DEXT : -1L, ext.contains("OpenGL13") ? caps.glCompressedTextureSubImage3DEXT : -1L, ext.contains("OpenGL13") ? caps.glCompressedTextureSubImage2DEXT : -1L, ext.contains("OpenGL13") ? caps.glCompressedTextureSubImage1DEXT : -1L, ext.contains("OpenGL13") ? caps.glGetCompressedTextureImageEXT : -1L, ext.contains("OpenGL13") ? caps.glCompressedMultiTexImage3DEXT : -1L, ext.contains("OpenGL13") ? caps.glCompressedMultiTexImage2DEXT : -1L, ext.contains("OpenGL13") ? caps.glCompressedMultiTexImage1DEXT : -1L, ext.contains("OpenGL13") ? caps.glCompressedMultiTexSubImage3DEXT : -1L, ext.contains("OpenGL13") ? caps.glCompressedMultiTexSubImage2DEXT : -1L, ext.contains("OpenGL13") ? caps.glCompressedMultiTexSubImage1DEXT : -1L, ext.contains("OpenGL13") ? caps.glGetCompressedMultiTexImageEXT : -1L, ext.contains("OpenGL13") ? caps.glMatrixLoadTransposefEXT : -1L, ext.contains("OpenGL13") ? caps.glMatrixLoadTransposedEXT : -1L, ext.contains("OpenGL13") ? caps.glMatrixMultTransposefEXT : -1L, ext.contains("OpenGL13") ? caps.glMatrixMultTransposedEXT : -1L, ext.contains("OpenGL15") ? caps.glNamedBufferDataEXT : -1L, ext.contains("OpenGL15") ? caps.glNamedBufferSubDataEXT : -1L, ext.contains("OpenGL15") ? caps.glMapNamedBufferEXT : -1L, ext.contains("OpenGL15") ? caps.glUnmapNamedBufferEXT : -1L, ext.contains("OpenGL15") ? caps.glGetNamedBufferParameterivEXT : -1L, ext.contains("OpenGL15") ? caps.glGetNamedBufferSubDataEXT : -1L, ext.contains("OpenGL20") ? caps.glProgramUniform1fEXT : -1L, ext.contains("OpenGL20") ? caps.glProgramUniform2fEXT : -1L, ext.contains("OpenGL20") ? caps.glProgramUniform3fEXT : -1L, ext.contains("OpenGL20") ? caps.glProgramUniform4fEXT : -1L, ext.contains("OpenGL20") ? caps.glProgramUniform1iEXT : -1L, ext.contains("OpenGL20") ? caps.glProgramUniform2iEXT : -1L, ext.contains("OpenGL20") ? caps.glProgramUniform3iEXT : -1L, ext.contains("OpenGL20") ? caps.glProgramUniform4iEXT : -1L, ext.contains("OpenGL20") ? caps.glProgramUniform1fvEXT : -1L, ext.contains("OpenGL20") ? caps.glProgramUniform2fvEXT : -1L, ext.contains("OpenGL20") ? caps.glProgramUniform3fvEXT : -1L, ext.contains("OpenGL20") ? caps.glProgramUniform4fvEXT : -1L, ext.contains("OpenGL20") ? caps.glProgramUniform1ivEXT : -1L, ext.contains("OpenGL20") ? caps.glProgramUniform2ivEXT : -1L, ext.contains("OpenGL20") ? caps.glProgramUniform3ivEXT : -1L, ext.contains("OpenGL20") ? caps.glProgramUniform4ivEXT : -1L, ext.contains("OpenGL20") ? caps.glProgramUniformMatrix2fvEXT : -1L, ext.contains("OpenGL20") ? caps.glProgramUniformMatrix3fvEXT : -1L, ext.contains("OpenGL20") ? caps.glProgramUniformMatrix4fvEXT : -1L, ext.contains("OpenGL21") ? caps.glProgramUniformMatrix2x3fvEXT : -1L, ext.contains("OpenGL21") ? caps.glProgramUniformMatrix3x2fvEXT : -1L, ext.contains("OpenGL21") ? caps.glProgramUniformMatrix2x4fvEXT : -1L, ext.contains("OpenGL21") ? caps.glProgramUniformMatrix4x2fvEXT : -1L, ext.contains("OpenGL21") ? caps.glProgramUniformMatrix3x4fvEXT : -1L, ext.contains("OpenGL21") ? caps.glProgramUniformMatrix4x3fvEXT : -1L, ext.contains("GL_EXT_texture_buffer_object") ? caps.glTextureBufferEXT : -1L, ext.contains("GL_EXT_texture_buffer_object") ? caps.glMultiTexBufferEXT : -1L, ext.contains("GL_EXT_texture_integer") ? caps.glTextureParameterIivEXT : -1L, ext.contains("GL_EXT_texture_integer") ? caps.glTextureParameterIuivEXT : -1L, ext.contains("GL_EXT_texture_integer") ? caps.glGetTextureParameterIivEXT : -1L, ext.contains("GL_EXT_texture_integer") ? caps.glGetTextureParameterIuivEXT : -1L, ext.contains("GL_EXT_texture_integer") ? caps.glMultiTexParameterIivEXT : -1L, ext.contains("GL_EXT_texture_integer") ? caps.glMultiTexParameterIuivEXT : -1L, ext.contains("GL_EXT_texture_integer") ? caps.glGetMultiTexParameterIivEXT : -1L, ext.contains("GL_EXT_texture_integer") ? caps.glGetMultiTexParameterIuivEXT : -1L, ext.contains("GL_EXT_gpu_shader4") ? caps.glProgramUniform1uiEXT : -1L, ext.contains("GL_EXT_gpu_shader4") ? caps.glProgramUniform2uiEXT : -1L, ext.contains("GL_EXT_gpu_shader4") ? caps.glProgramUniform3uiEXT : -1L, ext.contains("GL_EXT_gpu_shader4") ? caps.glProgramUniform4uiEXT : -1L, ext.contains("GL_EXT_gpu_shader4") ? caps.glProgramUniform1uivEXT : -1L, ext.contains("GL_EXT_gpu_shader4") ? caps.glProgramUniform2uivEXT : -1L, ext.contains("GL_EXT_gpu_shader4") ? caps.glProgramUniform3uivEXT : -1L, ext.contains("GL_EXT_gpu_shader4") ? caps.glProgramUniform4uivEXT : -1L, ext.contains("GL_EXT_gpu_program_parameters") ? caps.glNamedProgramLocalParameters4fvEXT : -1L, ext.contains("GL_NV_gpu_program4") ? caps.glNamedProgramLocalParameterI4iEXT : -1L, ext.contains("GL_NV_gpu_program4") ? caps.glNamedProgramLocalParameterI4ivEXT : -1L, ext.contains("GL_NV_gpu_program4") ? caps.glNamedProgramLocalParametersI4ivEXT : -1L, ext.contains("GL_NV_gpu_program4") ? caps.glNamedProgramLocalParameterI4uiEXT : -1L, ext.contains("GL_NV_gpu_program4") ? caps.glNamedProgramLocalParameterI4uivEXT : -1L, ext.contains("GL_NV_gpu_program4") ? caps.glNamedProgramLocalParametersI4uivEXT : -1L, ext.contains("GL_NV_gpu_program4") ? caps.glGetNamedProgramLocalParameterIivEXT : -1L, ext.contains("GL_NV_gpu_program4") ? caps.glGetNamedProgramLocalParameterIuivEXT : -1L, ext.contains("OpenGL30") ? caps.glNamedRenderbufferStorageEXT : -1L, ext.contains("OpenGL30") ? caps.glGetNamedRenderbufferParameterivEXT : -1L, ext.contains("OpenGL30") ? caps.glNamedRenderbufferStorageMultisampleEXT : -1L, ext.contains("GL_NV_framebuffer_multisample_coverage") ? caps.glNamedRenderbufferStorageMultisampleCoverageEXT : -1L, ext.contains("OpenGL30") ? caps.glCheckNamedFramebufferStatusEXT : -1L, ext.contains("OpenGL30") ? caps.glNamedFramebufferTexture1DEXT : -1L, ext.contains("OpenGL30") ? caps.glNamedFramebufferTexture2DEXT : -1L, ext.contains("OpenGL30") ? caps.glNamedFramebufferTexture3DEXT : -1L, ext.contains("OpenGL30") ? caps.glNamedFramebufferRenderbufferEXT : -1L, ext.contains("OpenGL30") ? caps.glGetNamedFramebufferAttachmentParameterivEXT : -1L, ext.contains("OpenGL30") ? caps.glGenerateTextureMipmapEXT : -1L, ext.contains("OpenGL30") ? caps.glGenerateMultiTexMipmapEXT : -1L, ext.contains("OpenGL30") ? caps.glFramebufferDrawBufferEXT : -1L, ext.contains("OpenGL30") ? caps.glFramebufferDrawBuffersEXT : -1L, ext.contains("OpenGL30") ? caps.glFramebufferReadBufferEXT : -1L, ext.contains("OpenGL30") ? caps.glGetFramebufferParameterivEXT : -1L, ext.contains("OpenGL30") ? caps.glNamedCopyBufferSubDataEXT : -1L, ext.contains("GL_EXT_geometry_shader4") || ext.contains("GL_NV_gpu_program4") ? caps.glNamedFramebufferTextureEXT : -1L, ext.contains("GL_EXT_geometry_shader4") || ext.contains("GL_NV_gpu_program4") ? caps.glNamedFramebufferTextureLayerEXT : -1L, ext.contains("GL_EXT_geometry_shader4") || ext.contains("GL_NV_gpu_program4") ? caps.glNamedFramebufferTextureFaceEXT : -1L, ext.contains("GL_NV_explicit_multisample") ? caps.glTextureRenderbufferEXT : -1L, ext.contains("GL_NV_explicit_multisample") ? caps.glMultiTexRenderbufferEXT : -1L, ext.contains("OpenGL30") ? caps.glVertexArrayVertexOffsetEXT : -1L, ext.contains("OpenGL30") ? caps.glVertexArrayColorOffsetEXT : -1L, ext.contains("OpenGL30") ? caps.glVertexArrayEdgeFlagOffsetEXT : -1L, ext.contains("OpenGL30") ? caps.glVertexArrayIndexOffsetEXT : -1L, ext.contains("OpenGL30") ? caps.glVertexArrayNormalOffsetEXT : -1L, ext.contains("OpenGL30") ? caps.glVertexArrayTexCoordOffsetEXT : -1L, ext.contains("OpenGL30") ? caps.glVertexArrayMultiTexCoordOffsetEXT : -1L, ext.contains("OpenGL30") ? caps.glVertexArrayFogCoordOffsetEXT : -1L, ext.contains("OpenGL30") ? caps.glVertexArraySecondaryColorOffsetEXT : -1L, ext.contains("OpenGL30") ? caps.glVertexArrayVertexAttribOffsetEXT : -1L, ext.contains("OpenGL30") ? caps.glVertexArrayVertexAttribIOffsetEXT : -1L, ext.contains("OpenGL30") ? caps.glEnableVertexArrayEXT : -1L, ext.contains("OpenGL30") ? caps.glDisableVertexArrayEXT : -1L, ext.contains("OpenGL30") ? caps.glEnableVertexArrayAttribEXT : -1L, ext.contains("OpenGL30") ? caps.glDisableVertexArrayAttribEXT : -1L, ext.contains("OpenGL30") ? caps.glGetVertexArrayIntegervEXT : -1L, ext.contains("OpenGL30") ? caps.glGetVertexArrayPointervEXT : -1L, ext.contains("OpenGL30") ? caps.glGetVertexArrayIntegeri_vEXT : -1L, ext.contains("OpenGL30") ? caps.glGetVertexArrayPointeri_vEXT : -1L, ext.contains("OpenGL30") ? caps.glMapNamedBufferRangeEXT : -1L, ext.contains("OpenGL30") ? caps.glFlushMappedNamedBufferRangeEXT : -1L);
    }

    public static native void glClientAttribDefaultEXT(@NativeType(value="GLbitfield") int var0);

    public static native void glPushClientAttribDefaultEXT(@NativeType(value="GLbitfield") int var0);

    public static native void nglMatrixLoadfEXT(int var0, long var1);

    public static void glMatrixLoadfEXT(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLfloat const *") FloatBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 16);
        }
        EXTDirectStateAccess.nglMatrixLoadfEXT(matrixMode, MemoryUtil.memAddress(m));
    }

    public static native void nglMatrixLoaddEXT(int var0, long var1);

    public static void glMatrixLoaddEXT(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLdouble const *") DoubleBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 16);
        }
        EXTDirectStateAccess.nglMatrixLoaddEXT(matrixMode, MemoryUtil.memAddress(m));
    }

    public static native void nglMatrixMultfEXT(int var0, long var1);

    public static void glMatrixMultfEXT(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLfloat const *") FloatBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 16);
        }
        EXTDirectStateAccess.nglMatrixMultfEXT(matrixMode, MemoryUtil.memAddress(m));
    }

    public static native void nglMatrixMultdEXT(int var0, long var1);

    public static void glMatrixMultdEXT(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLdouble const *") DoubleBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 16);
        }
        EXTDirectStateAccess.nglMatrixMultdEXT(matrixMode, MemoryUtil.memAddress(m));
    }

    public static native void glMatrixLoadIdentityEXT(@NativeType(value="GLenum") int var0);

    public static native void glMatrixRotatefEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLfloat") float var4);

    public static native void glMatrixRotatedEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5, @NativeType(value="GLdouble") double var7);

    public static native void glMatrixScalefEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    public static native void glMatrixScaledEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5);

    public static native void glMatrixTranslatefEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    public static native void glMatrixTranslatedEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5);

    public static native void glMatrixOrthoEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5, @NativeType(value="GLdouble") double var7, @NativeType(value="GLdouble") double var9, @NativeType(value="GLdouble") double var11);

    public static native void glMatrixFrustumEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLdouble") double var1, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5, @NativeType(value="GLdouble") double var7, @NativeType(value="GLdouble") double var9, @NativeType(value="GLdouble") double var11);

    public static native void glMatrixPushEXT(@NativeType(value="GLenum") int var0);

    public static native void glMatrixPopEXT(@NativeType(value="GLenum") int var0);

    public static native void glTextureParameteriEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLint") int var3);

    public static native void nglTextureParameterivEXT(int var0, int var1, int var2, long var3);

    public static void glTextureParameterivEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer param) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param, 4);
        }
        EXTDirectStateAccess.nglTextureParameterivEXT(texture, target, pname, MemoryUtil.memAddress(param));
    }

    public static native void glTextureParameterfEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLfloat") float var3);

    public static native void nglTextureParameterfvEXT(int var0, int var1, int var2, long var3);

    public static void glTextureParameterfvEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer param) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param, 4);
        }
        EXTDirectStateAccess.nglTextureParameterfvEXT(texture, target, pname, MemoryUtil.memAddress(param));
    }

    public static native void nglTextureImage1DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, long var8);

    public static void glTextureImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ByteBuffer pixels) {
        EXTDirectStateAccess.nglTextureImage1DEXT(texture, target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glTextureImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") long pixels) {
        EXTDirectStateAccess.nglTextureImage1DEXT(texture, target, level, internalformat, width, border, format, type, pixels);
    }

    public static void glTextureImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ShortBuffer pixels) {
        EXTDirectStateAccess.nglTextureImage1DEXT(texture, target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glTextureImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") IntBuffer pixels) {
        EXTDirectStateAccess.nglTextureImage1DEXT(texture, target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glTextureImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") FloatBuffer pixels) {
        EXTDirectStateAccess.nglTextureImage1DEXT(texture, target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glTextureImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") DoubleBuffer pixels) {
        EXTDirectStateAccess.nglTextureImage1DEXT(texture, target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static native void nglTextureImage2DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9);

    public static void glTextureImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ByteBuffer pixels) {
        EXTDirectStateAccess.nglTextureImage2DEXT(texture, target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glTextureImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") long pixels) {
        EXTDirectStateAccess.nglTextureImage2DEXT(texture, target, level, internalformat, width, height, border, format, type, pixels);
    }

    public static void glTextureImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ShortBuffer pixels) {
        EXTDirectStateAccess.nglTextureImage2DEXT(texture, target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glTextureImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") IntBuffer pixels) {
        EXTDirectStateAccess.nglTextureImage2DEXT(texture, target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glTextureImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") FloatBuffer pixels) {
        EXTDirectStateAccess.nglTextureImage2DEXT(texture, target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glTextureImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") DoubleBuffer pixels) {
        EXTDirectStateAccess.nglTextureImage2DEXT(texture, target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static native void nglTextureSubImage1DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, long var7);

    public static void glTextureSubImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer pixels) {
        EXTDirectStateAccess.nglTextureSubImage1DEXT(texture, target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long pixels) {
        EXTDirectStateAccess.nglTextureSubImage1DEXT(texture, target, level, xoffset, width, format, type, pixels);
    }

    public static void glTextureSubImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ShortBuffer pixels) {
        EXTDirectStateAccess.nglTextureSubImage1DEXT(texture, target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer pixels) {
        EXTDirectStateAccess.nglTextureSubImage1DEXT(texture, target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") FloatBuffer pixels) {
        EXTDirectStateAccess.nglTextureSubImage1DEXT(texture, target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") DoubleBuffer pixels) {
        EXTDirectStateAccess.nglTextureSubImage1DEXT(texture, target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
    }

    public static native void nglTextureSubImage2DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9);

    public static void glTextureSubImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer pixels) {
        EXTDirectStateAccess.nglTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long pixels) {
        EXTDirectStateAccess.nglTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTextureSubImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ShortBuffer pixels) {
        EXTDirectStateAccess.nglTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer pixels) {
        EXTDirectStateAccess.nglTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") FloatBuffer pixels) {
        EXTDirectStateAccess.nglTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") DoubleBuffer pixels) {
        EXTDirectStateAccess.nglTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
    }

    public static native void glCopyTextureImage1DEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLsizei") int var6, @NativeType(value="GLint") int var7);

    public static native void glCopyTextureImage2DEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLsizei") int var6, @NativeType(value="GLsizei") int var7, @NativeType(value="GLint") int var8);

    public static native void glCopyTextureSubImage1DEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLsizei") int var6);

    public static native void glCopyTextureSubImage2DEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLint") int var6, @NativeType(value="GLsizei") int var7, @NativeType(value="GLsizei") int var8);

    public static native void nglGetTextureImageEXT(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glGetTextureImageEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer pixels) {
        EXTDirectStateAccess.nglGetTextureImageEXT(texture, target, level, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glGetTextureImageEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") long pixels) {
        EXTDirectStateAccess.nglGetTextureImageEXT(texture, target, level, format, type, pixels);
    }

    public static void glGetTextureImageEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ShortBuffer pixels) {
        EXTDirectStateAccess.nglGetTextureImageEXT(texture, target, level, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glGetTextureImageEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") IntBuffer pixels) {
        EXTDirectStateAccess.nglGetTextureImageEXT(texture, target, level, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glGetTextureImageEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") FloatBuffer pixels) {
        EXTDirectStateAccess.nglGetTextureImageEXT(texture, target, level, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glGetTextureImageEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") DoubleBuffer pixels) {
        EXTDirectStateAccess.nglGetTextureImageEXT(texture, target, level, format, type, MemoryUtil.memAddress(pixels));
    }

    public static native void nglGetTextureParameterfvEXT(int var0, int var1, int var2, long var3);

    public static void glGetTextureParameterfvEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetTextureParameterfvEXT(texture, target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetTextureParameterfEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer params = stack.callocFloat(1);
            EXTDirectStateAccess.nglGetTextureParameterfvEXT(texture, target, pname, MemoryUtil.memAddress(params));
            float f = params.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetTextureParameterivEXT(int var0, int var1, int var2, long var3);

    public static void glGetTextureParameterivEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetTextureParameterivEXT(texture, target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTextureParameteriEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            EXTDirectStateAccess.nglGetTextureParameterivEXT(texture, target, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetTextureLevelParameterfvEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glGetTextureLevelParameterfvEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetTextureLevelParameterfvEXT(texture, target, level, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetTextureLevelParameterfEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer params = stack.callocFloat(1);
            EXTDirectStateAccess.nglGetTextureLevelParameterfvEXT(texture, target, level, pname, MemoryUtil.memAddress(params));
            float f = params.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetTextureLevelParameterivEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glGetTextureLevelParameterivEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetTextureLevelParameterivEXT(texture, target, level, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTextureLevelParameteriEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            EXTDirectStateAccess.nglGetTextureLevelParameterivEXT(texture, target, level, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglTextureImage3DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, long var10);

    public static void glTextureImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ByteBuffer pixels) {
        EXTDirectStateAccess.nglTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glTextureImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") long pixels) {
        EXTDirectStateAccess.nglTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, format, type, pixels);
    }

    public static void glTextureImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ShortBuffer pixels) {
        EXTDirectStateAccess.nglTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glTextureImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") IntBuffer pixels) {
        EXTDirectStateAccess.nglTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glTextureImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") FloatBuffer pixels) {
        EXTDirectStateAccess.nglTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glTextureImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") DoubleBuffer pixels) {
        EXTDirectStateAccess.nglTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static native void nglTextureSubImage3DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, long var11);

    public static void glTextureSubImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer pixels) {
        EXTDirectStateAccess.nglTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long pixels) {
        EXTDirectStateAccess.nglTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glTextureSubImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ShortBuffer pixels) {
        EXTDirectStateAccess.nglTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer pixels) {
        EXTDirectStateAccess.nglTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") FloatBuffer pixels) {
        EXTDirectStateAccess.nglTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glTextureSubImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") DoubleBuffer pixels) {
        EXTDirectStateAccess.nglTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
    }

    public static native void glCopyTextureSubImage3DEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLint") int var6, @NativeType(value="GLint") int var7, @NativeType(value="GLsizei") int var8, @NativeType(value="GLsizei") int var9);

    public static native void glBindMultiTextureEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2);

    public static native void nglMultiTexCoordPointerEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glMultiTexCoordPointerEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ByteBuffer pointer) {
        EXTDirectStateAccess.nglMultiTexCoordPointerEXT(texunit, size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glMultiTexCoordPointerEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") long pointer) {
        EXTDirectStateAccess.nglMultiTexCoordPointerEXT(texunit, size, type, stride, pointer);
    }

    public static void glMultiTexCoordPointerEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ShortBuffer pointer) {
        EXTDirectStateAccess.nglMultiTexCoordPointerEXT(texunit, size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glMultiTexCoordPointerEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") IntBuffer pointer) {
        EXTDirectStateAccess.nglMultiTexCoordPointerEXT(texunit, size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glMultiTexCoordPointerEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") FloatBuffer pointer) {
        EXTDirectStateAccess.nglMultiTexCoordPointerEXT(texunit, size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static native void glMultiTexEnvfEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLfloat") float var3);

    public static native void nglMultiTexEnvfvEXT(int var0, int var1, int var2, long var3);

    public static void glMultiTexEnvfvEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        EXTDirectStateAccess.nglMultiTexEnvfvEXT(texunit, target, pname, MemoryUtil.memAddress(params));
    }

    public static native void glMultiTexEnviEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLint") int var3);

    public static native void nglMultiTexEnvivEXT(int var0, int var1, int var2, long var3);

    public static void glMultiTexEnvivEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        EXTDirectStateAccess.nglMultiTexEnvivEXT(texunit, target, pname, MemoryUtil.memAddress(params));
    }

    public static native void glMultiTexGendEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLdouble") double var3);

    public static native void nglMultiTexGendvEXT(int var0, int var1, int var2, long var3);

    public static void glMultiTexGendvEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLdouble const *") DoubleBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        EXTDirectStateAccess.nglMultiTexGendvEXT(texunit, coord, pname, MemoryUtil.memAddress(params));
    }

    public static native void glMultiTexGenfEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLfloat") float var3);

    public static native void nglMultiTexGenfvEXT(int var0, int var1, int var2, long var3);

    public static void glMultiTexGenfvEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        EXTDirectStateAccess.nglMultiTexGenfvEXT(texunit, coord, pname, MemoryUtil.memAddress(params));
    }

    public static native void glMultiTexGeniEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLint") int var3);

    public static native void nglMultiTexGenivEXT(int var0, int var1, int var2, long var3);

    public static void glMultiTexGenivEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        EXTDirectStateAccess.nglMultiTexGenivEXT(texunit, coord, pname, MemoryUtil.memAddress(params));
    }

    public static native void nglGetMultiTexEnvfvEXT(int var0, int var1, int var2, long var3);

    public static void glGetMultiTexEnvfvEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetMultiTexEnvfvEXT(texunit, target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetMultiTexEnvfEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer params = stack.callocFloat(1);
            EXTDirectStateAccess.nglGetMultiTexEnvfvEXT(texunit, target, pname, MemoryUtil.memAddress(params));
            float f = params.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetMultiTexEnvivEXT(int var0, int var1, int var2, long var3);

    public static void glGetMultiTexEnvivEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetMultiTexEnvivEXT(texunit, target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetMultiTexEnviEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            EXTDirectStateAccess.nglGetMultiTexEnvivEXT(texunit, target, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetMultiTexGendvEXT(int var0, int var1, int var2, long var3);

    public static void glGetMultiTexGendvEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLdouble *") DoubleBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetMultiTexGendvEXT(texunit, coord, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static double glGetMultiTexGendEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            DoubleBuffer params = stack.callocDouble(1);
            EXTDirectStateAccess.nglGetMultiTexGendvEXT(texunit, coord, pname, MemoryUtil.memAddress(params));
            double d = params.get(0);
            return d;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetMultiTexGenfvEXT(int var0, int var1, int var2, long var3);

    public static void glGetMultiTexGenfvEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetMultiTexGenfvEXT(texunit, coord, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetMultiTexGenfEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer params = stack.callocFloat(1);
            EXTDirectStateAccess.nglGetMultiTexGenfvEXT(texunit, coord, pname, MemoryUtil.memAddress(params));
            float f = params.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetMultiTexGenivEXT(int var0, int var1, int var2, long var3);

    public static void glGetMultiTexGenivEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetMultiTexGenivEXT(texunit, coord, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetMultiTexGeniEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            EXTDirectStateAccess.nglGetMultiTexGenivEXT(texunit, coord, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glMultiTexParameteriEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLint") int var3);

    public static native void nglMultiTexParameterivEXT(int var0, int var1, int var2, long var3);

    public static void glMultiTexParameterivEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer param) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param, 4);
        }
        EXTDirectStateAccess.nglMultiTexParameterivEXT(texunit, target, pname, MemoryUtil.memAddress(param));
    }

    public static native void glMultiTexParameterfEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLfloat") float var3);

    public static native void nglMultiTexParameterfvEXT(int var0, int var1, int var2, long var3);

    public static void glMultiTexParameterfvEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer param) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param, 4);
        }
        EXTDirectStateAccess.nglMultiTexParameterfvEXT(texunit, target, pname, MemoryUtil.memAddress(param));
    }

    public static native void nglMultiTexImage1DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, long var8);

    public static void glMultiTexImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ByteBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glMultiTexImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") long pixels) {
        EXTDirectStateAccess.nglMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, format, type, pixels);
    }

    public static void glMultiTexImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ShortBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glMultiTexImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") IntBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glMultiTexImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") FloatBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glMultiTexImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") DoubleBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static native void nglMultiTexImage2DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9);

    public static void glMultiTexImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ByteBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glMultiTexImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") long pixels) {
        EXTDirectStateAccess.nglMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, format, type, pixels);
    }

    public static void glMultiTexImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ShortBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glMultiTexImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") IntBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glMultiTexImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") FloatBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glMultiTexImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") DoubleBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static native void nglMultiTexSubImage1DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, long var7);

    public static void glMultiTexSubImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glMultiTexSubImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long pixels) {
        EXTDirectStateAccess.nglMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, type, pixels);
    }

    public static void glMultiTexSubImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ShortBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glMultiTexSubImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glMultiTexSubImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") FloatBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glMultiTexSubImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") DoubleBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, type, MemoryUtil.memAddress(pixels));
    }

    public static native void nglMultiTexSubImage2DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9);

    public static void glMultiTexSubImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glMultiTexSubImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long pixels) {
        EXTDirectStateAccess.nglMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glMultiTexSubImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ShortBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glMultiTexSubImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glMultiTexSubImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") FloatBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glMultiTexSubImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") DoubleBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, type, MemoryUtil.memAddress(pixels));
    }

    public static native void glCopyMultiTexImage1DEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLsizei") int var6, @NativeType(value="GLint") int var7);

    public static native void glCopyMultiTexImage2DEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLsizei") int var6, @NativeType(value="GLsizei") int var7, @NativeType(value="GLint") int var8);

    public static native void glCopyMultiTexSubImage1DEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLsizei") int var6);

    public static native void glCopyMultiTexSubImage2DEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLint") int var6, @NativeType(value="GLsizei") int var7, @NativeType(value="GLsizei") int var8);

    public static native void nglGetMultiTexImageEXT(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glGetMultiTexImageEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ByteBuffer pixels) {
        EXTDirectStateAccess.nglGetMultiTexImageEXT(texunit, target, level, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glGetMultiTexImageEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") long pixels) {
        EXTDirectStateAccess.nglGetMultiTexImageEXT(texunit, target, level, format, type, pixels);
    }

    public static void glGetMultiTexImageEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") ShortBuffer pixels) {
        EXTDirectStateAccess.nglGetMultiTexImageEXT(texunit, target, level, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glGetMultiTexImageEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") IntBuffer pixels) {
        EXTDirectStateAccess.nglGetMultiTexImageEXT(texunit, target, level, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glGetMultiTexImageEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") FloatBuffer pixels) {
        EXTDirectStateAccess.nglGetMultiTexImageEXT(texunit, target, level, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glGetMultiTexImageEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") DoubleBuffer pixels) {
        EXTDirectStateAccess.nglGetMultiTexImageEXT(texunit, target, level, format, type, MemoryUtil.memAddress(pixels));
    }

    public static native void nglGetMultiTexParameterfvEXT(int var0, int var1, int var2, long var3);

    public static void glGetMultiTexParameterfvEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetMultiTexParameterfvEXT(texunit, target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetMultiTexParameterfEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer params = stack.callocFloat(1);
            EXTDirectStateAccess.nglGetMultiTexParameterfvEXT(texunit, target, pname, MemoryUtil.memAddress(params));
            float f = params.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetMultiTexParameterivEXT(int var0, int var1, int var2, long var3);

    public static void glGetMultiTexParameterivEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetMultiTexParameterivEXT(texunit, target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetMultiTexParameteriEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            EXTDirectStateAccess.nglGetMultiTexParameterivEXT(texunit, target, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetMultiTexLevelParameterfvEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glGetMultiTexLevelParameterfvEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetMultiTexLevelParameterfvEXT(texunit, target, level, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetMultiTexLevelParameterfEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer params = stack.callocFloat(1);
            EXTDirectStateAccess.nglGetMultiTexLevelParameterfvEXT(texunit, target, level, pname, MemoryUtil.memAddress(params));
            float f = params.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetMultiTexLevelParameterivEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glGetMultiTexLevelParameterivEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetMultiTexLevelParameterivEXT(texunit, target, level, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetMultiTexLevelParameteriEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            EXTDirectStateAccess.nglGetMultiTexLevelParameterivEXT(texunit, target, level, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglMultiTexImage3DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, long var10);

    public static void glMultiTexImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ByteBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexImage3DEXT(texunit, target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glMultiTexImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") long pixels) {
        EXTDirectStateAccess.nglMultiTexImage3DEXT(texunit, target, level, internalformat, width, height, depth, border, format, type, pixels);
    }

    public static void glMultiTexImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ShortBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexImage3DEXT(texunit, target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glMultiTexImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") IntBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexImage3DEXT(texunit, target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glMultiTexImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") FloatBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexImage3DEXT(texunit, target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static void glMultiTexImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") DoubleBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexImage3DEXT(texunit, target, level, internalformat, width, height, depth, border, format, type, MemoryUtil.memAddressSafe(pixels));
    }

    public static native void nglMultiTexSubImage3DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, long var11);

    public static void glMultiTexSubImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glMultiTexSubImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long pixels) {
        EXTDirectStateAccess.nglMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glMultiTexSubImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ShortBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glMultiTexSubImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glMultiTexSubImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") FloatBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
    }

    public static void glMultiTexSubImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") DoubleBuffer pixels) {
        EXTDirectStateAccess.nglMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, MemoryUtil.memAddress(pixels));
    }

    public static native void glCopyMultiTexSubImage3DEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLint") int var6, @NativeType(value="GLint") int var7, @NativeType(value="GLsizei") int var8, @NativeType(value="GLsizei") int var9);

    public static native void glEnableClientStateIndexedEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glDisableClientStateIndexedEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glEnableClientStateiEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glDisableClientStateiEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglGetFloatIndexedvEXT(int var0, int var1, long var2);

    public static void glGetFloatIndexedvEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetFloatIndexedvEXT(target, index, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetFloatIndexedEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer params = stack.callocFloat(1);
            EXTDirectStateAccess.nglGetFloatIndexedvEXT(target, index, MemoryUtil.memAddress(params));
            float f = params.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetDoubleIndexedvEXT(int var0, int var1, long var2);

    public static void glGetDoubleIndexedvEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLdouble *") DoubleBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetDoubleIndexedvEXT(target, index, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static double glGetDoubleIndexedEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            DoubleBuffer params = stack.callocDouble(1);
            EXTDirectStateAccess.nglGetDoubleIndexedvEXT(target, index, MemoryUtil.memAddress(params));
            double d = params.get(0);
            return d;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetPointerIndexedvEXT(int var0, int var1, long var2);

    public static void glGetPointerIndexedvEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="void **") PointerBuffer params) {
        if (Checks.CHECKS) {
            Checks.check(params, 1);
        }
        EXTDirectStateAccess.nglGetPointerIndexedvEXT(target, index, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetPointerIndexedEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            PointerBuffer params = stack.callocPointer(1);
            EXTDirectStateAccess.nglGetPointerIndexedvEXT(target, index, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetFloati_vEXT(int var0, int var1, long var2);

    public static void glGetFloati_vEXT(@NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetFloati_vEXT(pname, index, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetFloatiEXT(@NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer params = stack.callocFloat(1);
            EXTDirectStateAccess.nglGetFloati_vEXT(pname, index, MemoryUtil.memAddress(params));
            float f = params.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetDoublei_vEXT(int var0, int var1, long var2);

    public static void glGetDoublei_vEXT(@NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index, @NativeType(value="GLdouble *") DoubleBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetDoublei_vEXT(pname, index, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static double glGetDoubleiEXT(@NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            DoubleBuffer params = stack.callocDouble(1);
            EXTDirectStateAccess.nglGetDoublei_vEXT(pname, index, MemoryUtil.memAddress(params));
            double d = params.get(0);
            return d;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetPointeri_vEXT(int var0, int var1, long var2);

    public static void glGetPointeri_vEXT(@NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index, @NativeType(value="void **") PointerBuffer params) {
        if (Checks.CHECKS) {
            Checks.check(params, 1);
        }
        EXTDirectStateAccess.nglGetPointeri_vEXT(pname, index, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetPointeriEXT(@NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            PointerBuffer params = stack.callocPointer(1);
            EXTDirectStateAccess.nglGetPointeri_vEXT(pname, index, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glEnableIndexedEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        EXTDrawBuffers2.glEnableIndexedEXT(target, index);
    }

    public static void glDisableIndexedEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        EXTDrawBuffers2.glDisableIndexedEXT(target, index);
    }

    @NativeType(value="GLboolean")
    public static boolean glIsEnabledIndexedEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        return EXTDrawBuffers2.glIsEnabledIndexedEXT(target, index);
    }

    public static void nglGetIntegerIndexedvEXT(int target, int index, long data) {
        EXTDrawBuffers2.nglGetIntegerIndexedvEXT(target, index, data);
    }

    public static void glGetIntegerIndexedvEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") IntBuffer data) {
        EXTDrawBuffers2.glGetIntegerIndexedvEXT(target, index, data);
    }

    @NativeType(value="void")
    public static int glGetIntegerIndexedEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        return EXTDrawBuffers2.glGetIntegerIndexedEXT(target, index);
    }

    public static void nglGetBooleanIndexedvEXT(int target, int index, long data) {
        EXTDrawBuffers2.nglGetBooleanIndexedvEXT(target, index, data);
    }

    public static void glGetBooleanIndexedvEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLboolean *") ByteBuffer data) {
        EXTDrawBuffers2.glGetBooleanIndexedvEXT(target, index, data);
    }

    @NativeType(value="void")
    public static boolean glGetBooleanIndexedEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        return EXTDrawBuffers2.glGetBooleanIndexedEXT(target, index);
    }

    public static native void nglNamedProgramStringEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glNamedProgramStringEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int format, @NativeType(value="void const *") ByteBuffer string) {
        EXTDirectStateAccess.nglNamedProgramStringEXT(program, target, format, string.remaining(), MemoryUtil.memAddress(string));
    }

    public static native void glNamedProgramLocalParameter4dEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLdouble") double var3, @NativeType(value="GLdouble") double var5, @NativeType(value="GLdouble") double var7, @NativeType(value="GLdouble") double var9);

    public static native void nglNamedProgramLocalParameter4dvEXT(int var0, int var1, int var2, long var3);

    public static void glNamedProgramLocalParameter4dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") DoubleBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        EXTDirectStateAccess.nglNamedProgramLocalParameter4dvEXT(program, target, index, MemoryUtil.memAddress(params));
    }

    public static native void glNamedProgramLocalParameter4fEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLfloat") float var4, @NativeType(value="GLfloat") float var5, @NativeType(value="GLfloat") float var6);

    public static native void nglNamedProgramLocalParameter4fvEXT(int var0, int var1, int var2, long var3);

    public static void glNamedProgramLocalParameter4fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        EXTDirectStateAccess.nglNamedProgramLocalParameter4fvEXT(program, target, index, MemoryUtil.memAddress(params));
    }

    public static native void nglGetNamedProgramLocalParameterdvEXT(int var0, int var1, int var2, long var3);

    public static void glGetNamedProgramLocalParameterdvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLdouble *") DoubleBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        EXTDirectStateAccess.nglGetNamedProgramLocalParameterdvEXT(program, target, index, MemoryUtil.memAddress(params));
    }

    public static native void nglGetNamedProgramLocalParameterfvEXT(int var0, int var1, int var2, long var3);

    public static void glGetNamedProgramLocalParameterfvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat *") FloatBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        EXTDirectStateAccess.nglGetNamedProgramLocalParameterfvEXT(program, target, index, MemoryUtil.memAddress(params));
    }

    public static native void nglGetNamedProgramivEXT(int var0, int var1, int var2, long var3);

    public static void glGetNamedProgramivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetNamedProgramivEXT(program, target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetNamedProgramiEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            EXTDirectStateAccess.nglGetNamedProgramivEXT(program, target, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetNamedProgramStringEXT(int var0, int var1, int var2, long var3);

    public static void glGetNamedProgramStringEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="void *") ByteBuffer string) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)string, EXTDirectStateAccess.glGetNamedProgramiEXT(program, target, 34343));
        }
        EXTDirectStateAccess.nglGetNamedProgramStringEXT(program, target, pname, MemoryUtil.memAddress(string));
    }

    public static native void nglCompressedTextureImage3DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9);

    public static void glCompressedTextureImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLsizei") int imageSize, @Nullable @NativeType(value="void const *") long data) {
        EXTDirectStateAccess.nglCompressedTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, imageSize, data);
    }

    public static void glCompressedTextureImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @Nullable @NativeType(value="void const *") ByteBuffer data) {
        EXTDirectStateAccess.nglCompressedTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, Checks.remainingSafe(data), MemoryUtil.memAddressSafe(data));
    }

    public static native void nglCompressedTextureImage2DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, long var8);

    public static void glCompressedTextureImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLsizei") int imageSize, @Nullable @NativeType(value="void const *") long data) {
        EXTDirectStateAccess.nglCompressedTextureImage2DEXT(texture, target, level, internalformat, width, height, border, imageSize, data);
    }

    public static void glCompressedTextureImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @Nullable @NativeType(value="void const *") ByteBuffer data) {
        EXTDirectStateAccess.nglCompressedTextureImage2DEXT(texture, target, level, internalformat, width, height, border, Checks.remainingSafe(data), MemoryUtil.memAddressSafe(data));
    }

    public static native void nglCompressedTextureImage1DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, long var7);

    public static void glCompressedTextureImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLsizei") int imageSize, @Nullable @NativeType(value="void const *") long data) {
        EXTDirectStateAccess.nglCompressedTextureImage1DEXT(texture, target, level, internalformat, width, border, imageSize, data);
    }

    public static void glCompressedTextureImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @Nullable @NativeType(value="void const *") ByteBuffer data) {
        EXTDirectStateAccess.nglCompressedTextureImage1DEXT(texture, target, level, internalformat, width, border, Checks.remainingSafe(data), MemoryUtil.memAddressSafe(data));
    }

    public static native void nglCompressedTextureSubImage3DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, long var11);

    public static void glCompressedTextureSubImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int imageSize, @NativeType(value="void const *") long data) {
        EXTDirectStateAccess.nglCompressedTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
    }

    public static void glCompressedTextureSubImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="void const *") ByteBuffer data) {
        EXTDirectStateAccess.nglCompressedTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static native void nglCompressedTextureSubImage2DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9);

    public static void glCompressedTextureSubImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int imageSize, @NativeType(value="void const *") long data) {
        EXTDirectStateAccess.nglCompressedTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, imageSize, data);
    }

    public static void glCompressedTextureSubImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="void const *") ByteBuffer data) {
        EXTDirectStateAccess.nglCompressedTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static native void nglCompressedTextureSubImage1DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, long var7);

    public static void glCompressedTextureSubImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int imageSize, @NativeType(value="void const *") long data) {
        EXTDirectStateAccess.nglCompressedTextureSubImage1DEXT(texture, target, level, xoffset, width, format, imageSize, data);
    }

    public static void glCompressedTextureSubImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="void const *") ByteBuffer data) {
        EXTDirectStateAccess.nglCompressedTextureSubImage1DEXT(texture, target, level, xoffset, width, format, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static native void nglGetCompressedTextureImageEXT(int var0, int var1, int var2, long var3);

    public static void glGetCompressedTextureImageEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="void *") ByteBuffer img) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)img, EXTDirectStateAccess.glGetTextureLevelParameteriEXT(texture, target, level, 34464));
        }
        EXTDirectStateAccess.nglGetCompressedTextureImageEXT(texture, target, level, MemoryUtil.memAddress(img));
    }

    public static void glGetCompressedTextureImageEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="void *") long img) {
        EXTDirectStateAccess.nglGetCompressedTextureImageEXT(texture, target, level, img);
    }

    public static native void nglCompressedMultiTexImage3DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9);

    public static void glCompressedMultiTexImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLsizei") int imageSize, @Nullable @NativeType(value="void const *") long data) {
        EXTDirectStateAccess.nglCompressedMultiTexImage3DEXT(texunit, target, level, internalformat, width, height, depth, border, imageSize, data);
    }

    public static void glCompressedMultiTexImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @Nullable @NativeType(value="void const *") ByteBuffer data) {
        EXTDirectStateAccess.nglCompressedMultiTexImage3DEXT(texunit, target, level, internalformat, width, height, depth, border, Checks.remainingSafe(data), MemoryUtil.memAddressSafe(data));
    }

    public static native void nglCompressedMultiTexImage2DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, long var8);

    public static void glCompressedMultiTexImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLsizei") int imageSize, @Nullable @NativeType(value="void const *") long data) {
        EXTDirectStateAccess.nglCompressedMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, imageSize, data);
    }

    public static void glCompressedMultiTexImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @Nullable @NativeType(value="void const *") ByteBuffer data) {
        EXTDirectStateAccess.nglCompressedMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, Checks.remainingSafe(data), MemoryUtil.memAddressSafe(data));
    }

    public static native void nglCompressedMultiTexImage1DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, long var7);

    public static void glCompressedMultiTexImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLsizei") int imageSize, @Nullable @NativeType(value="void const *") long data) {
        EXTDirectStateAccess.nglCompressedMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, imageSize, data);
    }

    public static void glCompressedMultiTexImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @Nullable @NativeType(value="void const *") ByteBuffer data) {
        EXTDirectStateAccess.nglCompressedMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, Checks.remainingSafe(data), MemoryUtil.memAddressSafe(data));
    }

    public static native void nglCompressedMultiTexSubImage3DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, long var11);

    public static void glCompressedMultiTexSubImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int imageSize, @NativeType(value="void const *") long data) {
        EXTDirectStateAccess.nglCompressedMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
    }

    public static void glCompressedMultiTexSubImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="void const *") ByteBuffer data) {
        EXTDirectStateAccess.nglCompressedMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static native void nglCompressedMultiTexSubImage2DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9);

    public static void glCompressedMultiTexSubImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int imageSize, @NativeType(value="void const *") long data) {
        EXTDirectStateAccess.nglCompressedMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, imageSize, data);
    }

    public static void glCompressedMultiTexSubImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="void const *") ByteBuffer data) {
        EXTDirectStateAccess.nglCompressedMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static native void nglCompressedMultiTexSubImage1DEXT(int var0, int var1, int var2, int var3, int var4, int var5, int var6, long var7);

    public static void glCompressedMultiTexSubImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLsizei") int imageSize, @NativeType(value="void const *") long data) {
        EXTDirectStateAccess.nglCompressedMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, imageSize, data);
    }

    public static void glCompressedMultiTexSubImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="void const *") ByteBuffer data) {
        EXTDirectStateAccess.nglCompressedMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static native void nglGetCompressedMultiTexImageEXT(int var0, int var1, int var2, long var3);

    public static void glGetCompressedMultiTexImageEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="void *") ByteBuffer img) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)img, EXTDirectStateAccess.glGetMultiTexLevelParameteriEXT(texunit, target, level, 34464));
        }
        EXTDirectStateAccess.nglGetCompressedMultiTexImageEXT(texunit, target, level, MemoryUtil.memAddress(img));
    }

    public static void glGetCompressedMultiTexImageEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="void *") long img) {
        EXTDirectStateAccess.nglGetCompressedMultiTexImageEXT(texunit, target, level, img);
    }

    public static native void nglMatrixLoadTransposefEXT(int var0, long var1);

    public static void glMatrixLoadTransposefEXT(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLfloat const *") FloatBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 16);
        }
        EXTDirectStateAccess.nglMatrixLoadTransposefEXT(matrixMode, MemoryUtil.memAddress(m));
    }

    public static native void nglMatrixLoadTransposedEXT(int var0, long var1);

    public static void glMatrixLoadTransposedEXT(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLdouble const *") DoubleBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 16);
        }
        EXTDirectStateAccess.nglMatrixLoadTransposedEXT(matrixMode, MemoryUtil.memAddress(m));
    }

    public static native void nglMatrixMultTransposefEXT(int var0, long var1);

    public static void glMatrixMultTransposefEXT(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLfloat const *") FloatBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 16);
        }
        EXTDirectStateAccess.nglMatrixMultTransposefEXT(matrixMode, MemoryUtil.memAddress(m));
    }

    public static native void nglMatrixMultTransposedEXT(int var0, long var1);

    public static void glMatrixMultTransposedEXT(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLdouble const *") DoubleBuffer m) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)m, 16);
        }
        EXTDirectStateAccess.nglMatrixMultTransposedEXT(matrixMode, MemoryUtil.memAddress(m));
    }

    public static native void nglNamedBufferDataEXT(int var0, long var1, long var3, int var5);

    public static void glNamedBufferDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int usage) {
        EXTDirectStateAccess.nglNamedBufferDataEXT(buffer, size, 0L, usage);
    }

    public static void glNamedBufferDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") ByteBuffer data, @NativeType(value="GLenum") int usage) {
        EXTDirectStateAccess.nglNamedBufferDataEXT(buffer, data.remaining(), MemoryUtil.memAddress(data), usage);
    }

    public static void glNamedBufferDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") ShortBuffer data, @NativeType(value="GLenum") int usage) {
        EXTDirectStateAccess.nglNamedBufferDataEXT(buffer, Integer.toUnsignedLong(data.remaining()) << 1, MemoryUtil.memAddress(data), usage);
    }

    public static void glNamedBufferDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") IntBuffer data, @NativeType(value="GLenum") int usage) {
        EXTDirectStateAccess.nglNamedBufferDataEXT(buffer, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data), usage);
    }

    public static void glNamedBufferDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") FloatBuffer data, @NativeType(value="GLenum") int usage) {
        EXTDirectStateAccess.nglNamedBufferDataEXT(buffer, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data), usage);
    }

    public static void glNamedBufferDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") DoubleBuffer data, @NativeType(value="GLenum") int usage) {
        EXTDirectStateAccess.nglNamedBufferDataEXT(buffer, Integer.toUnsignedLong(data.remaining()) << 3, MemoryUtil.memAddress(data), usage);
    }

    public static native void nglNamedBufferSubDataEXT(int var0, long var1, long var3, long var5);

    public static void glNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") ByteBuffer data) {
        EXTDirectStateAccess.nglNamedBufferSubDataEXT(buffer, offset, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static void glNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") ShortBuffer data) {
        EXTDirectStateAccess.nglNamedBufferSubDataEXT(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 1, MemoryUtil.memAddress(data));
    }

    public static void glNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") IntBuffer data) {
        EXTDirectStateAccess.nglNamedBufferSubDataEXT(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data));
    }

    public static void glNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") FloatBuffer data) {
        EXTDirectStateAccess.nglNamedBufferSubDataEXT(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data));
    }

    public static void glNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") DoubleBuffer data) {
        EXTDirectStateAccess.nglNamedBufferSubDataEXT(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 3, MemoryUtil.memAddress(data));
    }

    public static native long nglMapNamedBufferEXT(int var0, int var1);

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBufferEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int access) {
        long __result = EXTDirectStateAccess.nglMapNamedBufferEXT(buffer, access);
        return MemoryUtil.memByteBufferSafe(__result, EXTDirectStateAccess.glGetNamedBufferParameteriEXT(buffer, 34660));
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBufferEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int access, @Nullable ByteBuffer old_buffer) {
        long __result = EXTDirectStateAccess.nglMapNamedBufferEXT(buffer, access);
        int length = EXTDirectStateAccess.glGetNamedBufferParameteriEXT(buffer, 34660);
        return APIUtil.apiGetMappedBuffer(old_buffer, __result, length);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBufferEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int access, long length, @Nullable ByteBuffer old_buffer) {
        long __result = EXTDirectStateAccess.nglMapNamedBufferEXT(buffer, access);
        return APIUtil.apiGetMappedBuffer(old_buffer, __result, (int)length);
    }

    @NativeType(value="GLboolean")
    public static native boolean glUnmapNamedBufferEXT(@NativeType(value="GLuint") int var0);

    public static native void nglGetNamedBufferParameterivEXT(int var0, int var1, long var2);

    public static void glGetNamedBufferParameterivEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetNamedBufferParameterivEXT(buffer, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetNamedBufferParameteriEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            EXTDirectStateAccess.nglGetNamedBufferParameterivEXT(buffer, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetNamedBufferSubDataEXT(int var0, long var1, long var3, long var5);

    public static void glGetNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") ByteBuffer data) {
        EXTDirectStateAccess.nglGetNamedBufferSubDataEXT(buffer, offset, data.remaining(), MemoryUtil.memAddress(data));
    }

    public static void glGetNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") ShortBuffer data) {
        EXTDirectStateAccess.nglGetNamedBufferSubDataEXT(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 1, MemoryUtil.memAddress(data));
    }

    public static void glGetNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") IntBuffer data) {
        EXTDirectStateAccess.nglGetNamedBufferSubDataEXT(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data));
    }

    public static void glGetNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") FloatBuffer data) {
        EXTDirectStateAccess.nglGetNamedBufferSubDataEXT(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 2, MemoryUtil.memAddress(data));
    }

    public static void glGetNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") DoubleBuffer data) {
        EXTDirectStateAccess.nglGetNamedBufferSubDataEXT(buffer, offset, Integer.toUnsignedLong(data.remaining()) << 3, MemoryUtil.memAddress(data));
    }

    public static native void glProgramUniform1fEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLfloat") float var2);

    public static native void glProgramUniform2fEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    public static native void glProgramUniform3fEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLfloat") float var4);

    public static native void glProgramUniform4fEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3, @NativeType(value="GLfloat") float var4, @NativeType(value="GLfloat") float var5);

    public static native void glProgramUniform1iEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void glProgramUniform2iEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3);

    public static native void glProgramUniform3iEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4);

    public static native void glProgramUniform4iEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5);

    public static native void nglProgramUniform1fvEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform1fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        EXTDirectStateAccess.nglProgramUniform1fvEXT(program, location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform2fvEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform2fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        EXTDirectStateAccess.nglProgramUniform2fvEXT(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform3fvEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform3fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        EXTDirectStateAccess.nglProgramUniform3fvEXT(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform4fvEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform4fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") FloatBuffer value) {
        EXTDirectStateAccess.nglProgramUniform4fvEXT(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform1ivEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform1ivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        EXTDirectStateAccess.nglProgramUniform1ivEXT(program, location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform2ivEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform2ivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        EXTDirectStateAccess.nglProgramUniform2ivEXT(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform3ivEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform3ivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        EXTDirectStateAccess.nglProgramUniform3ivEXT(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform4ivEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform4ivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") IntBuffer value) {
        EXTDirectStateAccess.nglProgramUniform4ivEXT(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix2fvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix2fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        EXTDirectStateAccess.nglProgramUniformMatrix2fvEXT(program, location, value.remaining() >> 2, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix3fvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix3fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        EXTDirectStateAccess.nglProgramUniformMatrix3fvEXT(program, location, value.remaining() / 9, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix4fvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix4fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        EXTDirectStateAccess.nglProgramUniformMatrix4fvEXT(program, location, value.remaining() >> 4, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix2x3fvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix2x3fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        EXTDirectStateAccess.nglProgramUniformMatrix2x3fvEXT(program, location, value.remaining() / 6, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix3x2fvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix3x2fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        EXTDirectStateAccess.nglProgramUniformMatrix3x2fvEXT(program, location, value.remaining() / 6, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix2x4fvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix2x4fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        EXTDirectStateAccess.nglProgramUniformMatrix2x4fvEXT(program, location, value.remaining() >> 3, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix4x2fvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix4x2fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        EXTDirectStateAccess.nglProgramUniformMatrix4x2fvEXT(program, location, value.remaining() >> 3, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix3x4fvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix3x4fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        EXTDirectStateAccess.nglProgramUniformMatrix3x4fvEXT(program, location, value.remaining() / 12, transpose, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniformMatrix4x3fvEXT(int var0, int var1, int var2, boolean var3, long var4);

    public static void glProgramUniformMatrix4x3fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        EXTDirectStateAccess.nglProgramUniformMatrix4x3fvEXT(program, location, value.remaining() / 12, transpose, MemoryUtil.memAddress(value));
    }

    public static native void glTextureBufferEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLuint") int var3);

    public static native void glMultiTexBufferEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLuint") int var3);

    public static native void nglTextureParameterIivEXT(int var0, int var1, int var2, long var3);

    public static void glTextureParameterIivEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        EXTDirectStateAccess.nglTextureParameterIivEXT(texture, target, pname, MemoryUtil.memAddress(params));
    }

    public static native void nglTextureParameterIuivEXT(int var0, int var1, int var2, long var3);

    public static void glTextureParameterIuivEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        EXTDirectStateAccess.nglTextureParameterIuivEXT(texture, target, pname, MemoryUtil.memAddress(params));
    }

    public static native void nglGetTextureParameterIivEXT(int var0, int var1, int var2, long var3);

    public static void glGetTextureParameterIivEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetTextureParameterIivEXT(texture, target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTextureParameterIiEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            EXTDirectStateAccess.nglGetTextureParameterIivEXT(texture, target, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetTextureParameterIuivEXT(int var0, int var1, int var2, long var3);

    public static void glGetTextureParameterIuivEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetTextureParameterIuivEXT(texture, target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTextureParameterIuiEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            EXTDirectStateAccess.nglGetTextureParameterIuivEXT(texture, target, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglMultiTexParameterIivEXT(int var0, int var1, int var2, long var3);

    public static void glMultiTexParameterIivEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        EXTDirectStateAccess.nglMultiTexParameterIivEXT(texunit, target, pname, MemoryUtil.memAddress(params));
    }

    public static native void nglMultiTexParameterIuivEXT(int var0, int var1, int var2, long var3);

    public static void glMultiTexParameterIuivEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        EXTDirectStateAccess.nglMultiTexParameterIuivEXT(texunit, target, pname, MemoryUtil.memAddress(params));
    }

    public static native void nglGetMultiTexParameterIivEXT(int var0, int var1, int var2, long var3);

    public static void glGetMultiTexParameterIivEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetMultiTexParameterIivEXT(texunit, target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetMultiTexParameterIiEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            EXTDirectStateAccess.nglGetMultiTexParameterIivEXT(texunit, target, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetMultiTexParameterIuivEXT(int var0, int var1, int var2, long var3);

    public static void glGetMultiTexParameterIuivEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetMultiTexParameterIuivEXT(texunit, target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetMultiTexParameterIuiEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            EXTDirectStateAccess.nglGetMultiTexParameterIuivEXT(texunit, target, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glProgramUniform1uiEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint") int var2);

    public static native void glProgramUniform2uiEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLuint") int var3);

    public static native void glProgramUniform3uiEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLuint") int var3, @NativeType(value="GLuint") int var4);

    public static native void glProgramUniform4uiEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLuint") int var3, @NativeType(value="GLuint") int var4, @NativeType(value="GLuint") int var5);

    public static native void nglProgramUniform1uivEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform1uivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        EXTDirectStateAccess.nglProgramUniform1uivEXT(program, location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform2uivEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform2uivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        EXTDirectStateAccess.nglProgramUniform2uivEXT(program, location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform3uivEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform3uivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        EXTDirectStateAccess.nglProgramUniform3uivEXT(program, location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void nglProgramUniform4uivEXT(int var0, int var1, int var2, long var3);

    public static void glProgramUniform4uivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        EXTDirectStateAccess.nglProgramUniform4uivEXT(program, location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static native void nglNamedProgramLocalParameters4fvEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glNamedProgramLocalParameters4fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") FloatBuffer params) {
        EXTDirectStateAccess.nglNamedProgramLocalParameters4fvEXT(program, target, index, params.remaining() >> 2, MemoryUtil.memAddress(params));
    }

    public static native void glNamedProgramLocalParameterI4iEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLint") int var6);

    public static native void nglNamedProgramLocalParameterI4ivEXT(int var0, int var1, int var2, long var3);

    public static void glNamedProgramLocalParameterI4ivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        EXTDirectStateAccess.nglNamedProgramLocalParameterI4ivEXT(program, target, index, MemoryUtil.memAddress(params));
    }

    public static native void nglNamedProgramLocalParametersI4ivEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glNamedProgramLocalParametersI4ivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer params) {
        EXTDirectStateAccess.nglNamedProgramLocalParametersI4ivEXT(program, target, index, params.remaining() >> 2, MemoryUtil.memAddress(params));
    }

    public static native void glNamedProgramLocalParameterI4uiEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLuint") int var3, @NativeType(value="GLuint") int var4, @NativeType(value="GLuint") int var5, @NativeType(value="GLuint") int var6);

    public static native void nglNamedProgramLocalParameterI4uivEXT(int var0, int var1, int var2, long var3);

    public static void glNamedProgramLocalParameterI4uivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        EXTDirectStateAccess.nglNamedProgramLocalParameterI4uivEXT(program, target, index, MemoryUtil.memAddress(params));
    }

    public static native void nglNamedProgramLocalParametersI4uivEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glNamedProgramLocalParametersI4uivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") IntBuffer params) {
        EXTDirectStateAccess.nglNamedProgramLocalParametersI4uivEXT(program, target, index, params.remaining() >> 2, MemoryUtil.memAddress(params));
    }

    public static native void nglGetNamedProgramLocalParameterIivEXT(int var0, int var1, int var2, long var3);

    public static void glGetNamedProgramLocalParameterIivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        EXTDirectStateAccess.nglGetNamedProgramLocalParameterIivEXT(program, target, index, MemoryUtil.memAddress(params));
    }

    public static native void nglGetNamedProgramLocalParameterIuivEXT(int var0, int var1, int var2, long var3);

    public static void glGetNamedProgramLocalParameterIuivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLuint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        EXTDirectStateAccess.nglGetNamedProgramLocalParameterIuivEXT(program, target, index, MemoryUtil.memAddress(params));
    }

    public static native void glNamedRenderbufferStorageEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLsizei") int var2, @NativeType(value="GLsizei") int var3);

    public static native void nglGetNamedRenderbufferParameterivEXT(int var0, int var1, long var2);

    public static void glGetNamedRenderbufferParameterivEXT(@NativeType(value="GLuint") int renderbuffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetNamedRenderbufferParameterivEXT(renderbuffer, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetNamedRenderbufferParameteriEXT(@NativeType(value="GLuint") int renderbuffer, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            EXTDirectStateAccess.nglGetNamedRenderbufferParameterivEXT(renderbuffer, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glNamedRenderbufferStorageMultisampleEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4);

    public static native void glNamedRenderbufferStorageMultisampleCoverageEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLsizei") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLsizei") int var5);

    @NativeType(value="GLenum")
    public static native int glCheckNamedFramebufferStatusEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void glNamedFramebufferTexture1DEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLuint") int var3, @NativeType(value="GLint") int var4);

    public static native void glNamedFramebufferTexture2DEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLuint") int var3, @NativeType(value="GLint") int var4);

    public static native void glNamedFramebufferTexture3DEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLuint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5);

    public static native void glNamedFramebufferRenderbufferEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLuint") int var3);

    public static native void nglGetNamedFramebufferAttachmentParameterivEXT(int var0, int var1, int var2, long var3);

    public static void glGetNamedFramebufferAttachmentParameterivEXT(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int attachment, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        EXTDirectStateAccess.nglGetNamedFramebufferAttachmentParameterivEXT(framebuffer, attachment, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetNamedFramebufferAttachmentParameteriEXT(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int attachment, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            EXTDirectStateAccess.nglGetNamedFramebufferAttachmentParameterivEXT(framebuffer, attachment, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glGenerateTextureMipmapEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void glGenerateMultiTexMipmapEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1);

    public static native void glFramebufferDrawBufferEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void nglFramebufferDrawBuffersEXT(int var0, int var1, long var2);

    public static void glFramebufferDrawBuffersEXT(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum const *") IntBuffer bufs) {
        EXTDirectStateAccess.nglFramebufferDrawBuffersEXT(framebuffer, bufs.remaining(), MemoryUtil.memAddress(bufs));
    }

    public static native void glFramebufferReadBufferEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void nglGetFramebufferParameterivEXT(int var0, int var1, long var2);

    public static void glGetFramebufferParameterivEXT(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer param) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param, 1);
        }
        EXTDirectStateAccess.nglGetFramebufferParameterivEXT(framebuffer, pname, MemoryUtil.memAddress(param));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetFramebufferParameteriEXT(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer param = stack.callocInt(1);
            EXTDirectStateAccess.nglGetFramebufferParameterivEXT(framebuffer, pname, MemoryUtil.memAddress(param));
            int n = param.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glNamedCopyBufferSubDataEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLintptr") long var2, @NativeType(value="GLintptr") long var4, @NativeType(value="GLsizeiptr") long var6);

    public static native void glNamedFramebufferTextureEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLint") int var3);

    public static native void glNamedFramebufferTextureLayerEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4);

    public static native void glNamedFramebufferTextureFaceEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLenum") int var4);

    public static native void glTextureRenderbufferEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2);

    public static native void glMultiTexRenderbufferEXT(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2);

    public static native void glVertexArrayVertexOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLintptr") long var5);

    public static native void glVertexArrayColorOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLintptr") long var5);

    public static native void glVertexArrayEdgeFlagOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLsizei") int var2, @NativeType(value="GLintptr") long var3);

    public static native void glVertexArrayIndexOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLintptr") long var4);

    public static native void glVertexArrayNormalOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLintptr") long var4);

    public static native void glVertexArrayTexCoordOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLintptr") long var5);

    public static native void glVertexArrayMultiTexCoordOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLenum") int var4, @NativeType(value="GLsizei") int var5, @NativeType(value="GLintptr") long var6);

    public static native void glVertexArrayFogCoordOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLintptr") long var4);

    public static native void glVertexArraySecondaryColorOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLintptr") long var5);

    public static native void glVertexArrayVertexAttribOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLenum") int var4, @NativeType(value="GLboolean") boolean var5, @NativeType(value="GLsizei") int var6, @NativeType(value="GLintptr") long var7);

    public static native void glVertexArrayVertexAttribIOffsetEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLenum") int var4, @NativeType(value="GLsizei") int var5, @NativeType(value="GLintptr") long var6);

    public static native void glEnableVertexArrayEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void glDisableVertexArrayEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void glEnableVertexArrayAttribEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void glDisableVertexArrayAttribEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglGetVertexArrayIntegervEXT(int var0, int var1, long var2);

    public static void glGetVertexArrayIntegervEXT(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer param) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param, 1);
        }
        EXTDirectStateAccess.nglGetVertexArrayIntegervEXT(vaobj, pname, MemoryUtil.memAddress(param));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetVertexArrayIntegerEXT(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer param = stack.callocInt(1);
            EXTDirectStateAccess.nglGetVertexArrayIntegervEXT(vaobj, pname, MemoryUtil.memAddress(param));
            int n = param.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetVertexArrayPointervEXT(int var0, int var1, long var2);

    public static void glGetVertexArrayPointervEXT(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLenum") int pname, @NativeType(value="void **") PointerBuffer param) {
        if (Checks.CHECKS) {
            Checks.check(param, 1);
        }
        EXTDirectStateAccess.nglGetVertexArrayPointervEXT(vaobj, pname, MemoryUtil.memAddress(param));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetVertexArrayPointerEXT(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            PointerBuffer param = stack.callocPointer(1);
            EXTDirectStateAccess.nglGetVertexArrayPointervEXT(vaobj, pname, MemoryUtil.memAddress(param));
            long l = param.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetVertexArrayIntegeri_vEXT(int var0, int var1, int var2, long var3);

    public static void glGetVertexArrayIntegeri_vEXT(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer param) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param, 1);
        }
        EXTDirectStateAccess.nglGetVertexArrayIntegeri_vEXT(vaobj, index, pname, MemoryUtil.memAddress(param));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetVertexArrayIntegeriEXT(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer param = stack.callocInt(1);
            EXTDirectStateAccess.nglGetVertexArrayIntegeri_vEXT(vaobj, index, pname, MemoryUtil.memAddress(param));
            int n = param.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetVertexArrayPointeri_vEXT(int var0, int var1, int var2, long var3);

    public static void glGetVertexArrayPointeri_vEXT(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="void **") PointerBuffer param) {
        if (Checks.CHECKS) {
            Checks.check(param, 1);
        }
        EXTDirectStateAccess.nglGetVertexArrayPointeri_vEXT(vaobj, index, pname, MemoryUtil.memAddress(param));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetVertexArrayPointeriEXT(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            PointerBuffer param = stack.callocPointer(1);
            EXTDirectStateAccess.nglGetVertexArrayPointeri_vEXT(vaobj, index, pname, MemoryUtil.memAddress(param));
            long l = param.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native long nglMapNamedBufferRangeEXT(int var0, long var1, long var3, int var5);

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBufferRangeEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long length, @NativeType(value="GLbitfield") int access) {
        long __result = EXTDirectStateAccess.nglMapNamedBufferRangeEXT(buffer, offset, length, access);
        return MemoryUtil.memByteBufferSafe(__result, (int)length);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapNamedBufferRangeEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long length, @NativeType(value="GLbitfield") int access, @Nullable ByteBuffer old_buffer) {
        long __result = EXTDirectStateAccess.nglMapNamedBufferRangeEXT(buffer, offset, length, access);
        return APIUtil.apiGetMappedBuffer(old_buffer, __result, (int)length);
    }

    public static native void glFlushMappedNamedBufferRangeEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLintptr") long var1, @NativeType(value="GLsizeiptr") long var3);

    public static void glMatrixLoadfEXT(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLfloat const *") float[] m) {
        long __functionAddress = GL.getICD().glMatrixLoadfEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 16);
        }
        JNI.callPV(matrixMode, m, __functionAddress);
    }

    public static void glMatrixLoaddEXT(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLdouble const *") double[] m) {
        long __functionAddress = GL.getICD().glMatrixLoaddEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 16);
        }
        JNI.callPV(matrixMode, m, __functionAddress);
    }

    public static void glMatrixMultfEXT(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLfloat const *") float[] m) {
        long __functionAddress = GL.getICD().glMatrixMultfEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 16);
        }
        JNI.callPV(matrixMode, m, __functionAddress);
    }

    public static void glMatrixMultdEXT(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLdouble const *") double[] m) {
        long __functionAddress = GL.getICD().glMatrixMultdEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 16);
        }
        JNI.callPV(matrixMode, m, __functionAddress);
    }

    public static void glTextureParameterivEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] param) {
        long __functionAddress = GL.getICD().glTextureParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(param, 4);
        }
        JNI.callPV(texture, target, pname, param, __functionAddress);
    }

    public static void glTextureParameterfvEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] param) {
        long __functionAddress = GL.getICD().glTextureParameterfvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(param, 4);
        }
        JNI.callPV(texture, target, pname, param, __functionAddress);
    }

    public static void glTextureImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") short[] pixels) {
        long __functionAddress = GL.getICD().glTextureImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, internalformat, width, border, format, type, pixels, __functionAddress);
    }

    public static void glTextureImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") int[] pixels) {
        long __functionAddress = GL.getICD().glTextureImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, internalformat, width, border, format, type, pixels, __functionAddress);
    }

    public static void glTextureImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") float[] pixels) {
        long __functionAddress = GL.getICD().glTextureImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, internalformat, width, border, format, type, pixels, __functionAddress);
    }

    public static void glTextureImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") double[] pixels) {
        long __functionAddress = GL.getICD().glTextureImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, internalformat, width, border, format, type, pixels, __functionAddress);
    }

    public static void glTextureImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") short[] pixels) {
        long __functionAddress = GL.getICD().glTextureImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, internalformat, width, height, border, format, type, pixels, __functionAddress);
    }

    public static void glTextureImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") int[] pixels) {
        long __functionAddress = GL.getICD().glTextureImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, internalformat, width, height, border, format, type, pixels, __functionAddress);
    }

    public static void glTextureImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") float[] pixels) {
        long __functionAddress = GL.getICD().glTextureImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, internalformat, width, height, border, format, type, pixels, __functionAddress);
    }

    public static void glTextureImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") double[] pixels) {
        long __functionAddress = GL.getICD().glTextureImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, internalformat, width, height, border, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") short[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, xoffset, width, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, xoffset, width, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") float[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, xoffset, width, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage1DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") double[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, xoffset, width, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") short[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") float[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage2DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") double[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
    }

    public static void glGetTextureImageEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") short[] pixels) {
        long __functionAddress = GL.getICD().glGetTextureImageEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, format, type, pixels, __functionAddress);
    }

    public static void glGetTextureImageEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") int[] pixels) {
        long __functionAddress = GL.getICD().glGetTextureImageEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, format, type, pixels, __functionAddress);
    }

    public static void glGetTextureImageEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") float[] pixels) {
        long __functionAddress = GL.getICD().glGetTextureImageEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, format, type, pixels, __functionAddress);
    }

    public static void glGetTextureImageEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") double[] pixels) {
        long __functionAddress = GL.getICD().glGetTextureImageEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, format, type, pixels, __functionAddress);
    }

    public static void glGetTextureParameterfvEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetTextureParameterfvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texture, target, pname, params, __functionAddress);
    }

    public static void glGetTextureParameterivEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetTextureParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texture, target, pname, params, __functionAddress);
    }

    public static void glGetTextureLevelParameterfvEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetTextureLevelParameterfvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texture, target, level, pname, params, __functionAddress);
    }

    public static void glGetTextureLevelParameterivEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetTextureLevelParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texture, target, level, pname, params, __functionAddress);
    }

    public static void glTextureImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") short[] pixels) {
        long __functionAddress = GL.getICD().glTextureImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, internalformat, width, height, depth, border, format, type, pixels, __functionAddress);
    }

    public static void glTextureImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") int[] pixels) {
        long __functionAddress = GL.getICD().glTextureImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, internalformat, width, height, depth, border, format, type, pixels, __functionAddress);
    }

    public static void glTextureImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") float[] pixels) {
        long __functionAddress = GL.getICD().glTextureImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, internalformat, width, height, depth, border, format, type, pixels, __functionAddress);
    }

    public static void glTextureImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") double[] pixels) {
        long __functionAddress = GL.getICD().glTextureImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, internalformat, width, height, depth, border, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") short[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") float[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
    }

    public static void glTextureSubImage3DEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") double[] pixels) {
        long __functionAddress = GL.getICD().glTextureSubImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexCoordPointerEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") short[] pointer) {
        long __functionAddress = GL.getICD().glMultiTexCoordPointerEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, size, type, stride, pointer, __functionAddress);
    }

    public static void glMultiTexCoordPointerEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") int[] pointer) {
        long __functionAddress = GL.getICD().glMultiTexCoordPointerEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, size, type, stride, pointer, __functionAddress);
    }

    public static void glMultiTexCoordPointerEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") float[] pointer) {
        long __functionAddress = GL.getICD().glMultiTexCoordPointerEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, size, type, stride, pointer, __functionAddress);
    }

    public static void glMultiTexEnvfvEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] params) {
        long __functionAddress = GL.getICD().glMultiTexEnvfvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(texunit, target, pname, params, __functionAddress);
    }

    public static void glMultiTexEnvivEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = GL.getICD().glMultiTexEnvivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(texunit, target, pname, params, __functionAddress);
    }

    public static void glMultiTexGendvEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLdouble const *") double[] params) {
        long __functionAddress = GL.getICD().glMultiTexGendvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(texunit, coord, pname, params, __functionAddress);
    }

    public static void glMultiTexGenfvEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] params) {
        long __functionAddress = GL.getICD().glMultiTexGenfvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(texunit, coord, pname, params, __functionAddress);
    }

    public static void glMultiTexGenivEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = GL.getICD().glMultiTexGenivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(texunit, coord, pname, params, __functionAddress);
    }

    public static void glGetMultiTexEnvfvEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetMultiTexEnvfvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texunit, target, pname, params, __functionAddress);
    }

    public static void glGetMultiTexEnvivEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetMultiTexEnvivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texunit, target, pname, params, __functionAddress);
    }

    public static void glGetMultiTexGendvEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLdouble *") double[] params) {
        long __functionAddress = GL.getICD().glGetMultiTexGendvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texunit, coord, pname, params, __functionAddress);
    }

    public static void glGetMultiTexGenfvEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetMultiTexGenfvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texunit, coord, pname, params, __functionAddress);
    }

    public static void glGetMultiTexGenivEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int coord, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetMultiTexGenivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texunit, coord, pname, params, __functionAddress);
    }

    public static void glMultiTexParameterivEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] param) {
        long __functionAddress = GL.getICD().glMultiTexParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(param, 4);
        }
        JNI.callPV(texunit, target, pname, param, __functionAddress);
    }

    public static void glMultiTexParameterfvEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] param) {
        long __functionAddress = GL.getICD().glMultiTexParameterfvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(param, 4);
        }
        JNI.callPV(texunit, target, pname, param, __functionAddress);
    }

    public static void glMultiTexImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") short[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, internalformat, width, border, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") int[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, internalformat, width, border, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") float[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, internalformat, width, border, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") double[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, internalformat, width, border, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") short[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, internalformat, width, height, border, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") int[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, internalformat, width, height, border, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") float[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, internalformat, width, height, border, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") double[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, internalformat, width, height, border, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexSubImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") short[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexSubImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, xoffset, width, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexSubImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexSubImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, xoffset, width, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexSubImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") float[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexSubImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, xoffset, width, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexSubImage1DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") double[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexSubImage1DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, xoffset, width, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexSubImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") short[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexSubImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexSubImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexSubImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexSubImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") float[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexSubImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexSubImage2DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") double[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexSubImage2DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, xoffset, yoffset, width, height, format, type, pixels, __functionAddress);
    }

    public static void glGetMultiTexImageEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") short[] pixels) {
        long __functionAddress = GL.getICD().glGetMultiTexImageEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, format, type, pixels, __functionAddress);
    }

    public static void glGetMultiTexImageEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") int[] pixels) {
        long __functionAddress = GL.getICD().glGetMultiTexImageEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, format, type, pixels, __functionAddress);
    }

    public static void glGetMultiTexImageEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") float[] pixels) {
        long __functionAddress = GL.getICD().glGetMultiTexImageEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, format, type, pixels, __functionAddress);
    }

    public static void glGetMultiTexImageEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void *") double[] pixels) {
        long __functionAddress = GL.getICD().glGetMultiTexImageEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, format, type, pixels, __functionAddress);
    }

    public static void glGetMultiTexParameterfvEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetMultiTexParameterfvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texunit, target, pname, params, __functionAddress);
    }

    public static void glGetMultiTexParameterivEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetMultiTexParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texunit, target, pname, params, __functionAddress);
    }

    public static void glGetMultiTexLevelParameterfvEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetMultiTexLevelParameterfvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texunit, target, level, pname, params, __functionAddress);
    }

    public static void glGetMultiTexLevelParameterivEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetMultiTexLevelParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texunit, target, level, pname, params, __functionAddress);
    }

    public static void glMultiTexImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") short[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, internalformat, width, height, depth, border, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") int[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, internalformat, width, height, depth, border, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") float[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, internalformat, width, height, depth, border, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLint") int border, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") double[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, internalformat, width, height, depth, border, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexSubImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") short[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexSubImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexSubImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexSubImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexSubImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") float[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexSubImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
    }

    public static void glMultiTexSubImage3DEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @NativeType(value="void const *") double[] pixels) {
        long __functionAddress = GL.getICD().glMultiTexSubImage3DEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels, __functionAddress);
    }

    public static void glGetFloatIndexedvEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetFloatIndexedvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, index, params, __functionAddress);
    }

    public static void glGetDoubleIndexedvEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLdouble *") double[] params) {
        long __functionAddress = GL.getICD().glGetDoubleIndexedvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, index, params, __functionAddress);
    }

    public static void glGetFloati_vEXT(@NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetFloati_vEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(pname, index, params, __functionAddress);
    }

    public static void glGetDoublei_vEXT(@NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index, @NativeType(value="GLdouble *") double[] params) {
        long __functionAddress = GL.getICD().glGetDoublei_vEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(pname, index, params, __functionAddress);
    }

    public static void glGetIntegerIndexedvEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") int[] data) {
        EXTDrawBuffers2.glGetIntegerIndexedvEXT(target, index, data);
    }

    public static void glNamedProgramLocalParameter4dvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLdouble const *") double[] params) {
        long __functionAddress = GL.getICD().glNamedProgramLocalParameter4dvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(program, target, index, params, __functionAddress);
    }

    public static void glNamedProgramLocalParameter4fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] params) {
        long __functionAddress = GL.getICD().glNamedProgramLocalParameter4fvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(program, target, index, params, __functionAddress);
    }

    public static void glGetNamedProgramLocalParameterdvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLdouble *") double[] params) {
        long __functionAddress = GL.getICD().glGetNamedProgramLocalParameterdvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(program, target, index, params, __functionAddress);
    }

    public static void glGetNamedProgramLocalParameterfvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat *") float[] params) {
        long __functionAddress = GL.getICD().glGetNamedProgramLocalParameterfvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(program, target, index, params, __functionAddress);
    }

    public static void glGetNamedProgramivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetNamedProgramivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(program, target, pname, params, __functionAddress);
    }

    public static void glMatrixLoadTransposefEXT(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLfloat const *") float[] m) {
        long __functionAddress = GL.getICD().glMatrixLoadTransposefEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 16);
        }
        JNI.callPV(matrixMode, m, __functionAddress);
    }

    public static void glMatrixLoadTransposedEXT(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLdouble const *") double[] m) {
        long __functionAddress = GL.getICD().glMatrixLoadTransposedEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 16);
        }
        JNI.callPV(matrixMode, m, __functionAddress);
    }

    public static void glMatrixMultTransposefEXT(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLfloat const *") float[] m) {
        long __functionAddress = GL.getICD().glMatrixMultTransposefEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 16);
        }
        JNI.callPV(matrixMode, m, __functionAddress);
    }

    public static void glMatrixMultTransposedEXT(@NativeType(value="GLenum") int matrixMode, @NativeType(value="GLdouble const *") double[] m) {
        long __functionAddress = GL.getICD().glMatrixMultTransposedEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(m, 16);
        }
        JNI.callPV(matrixMode, m, __functionAddress);
    }

    public static void glNamedBufferDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") short[] data, @NativeType(value="GLenum") int usage) {
        long __functionAddress = GL.getICD().glNamedBufferDataEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 1, data, usage, __functionAddress);
    }

    public static void glNamedBufferDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") int[] data, @NativeType(value="GLenum") int usage) {
        long __functionAddress = GL.getICD().glNamedBufferDataEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 2, data, usage, __functionAddress);
    }

    public static void glNamedBufferDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") float[] data, @NativeType(value="GLenum") int usage) {
        long __functionAddress = GL.getICD().glNamedBufferDataEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 2, data, usage, __functionAddress);
    }

    public static void glNamedBufferDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="void const *") double[] data, @NativeType(value="GLenum") int usage) {
        long __functionAddress = GL.getICD().glNamedBufferDataEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPV(buffer, Integer.toUnsignedLong(data.length) << 3, data, usage, __functionAddress);
    }

    public static void glNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") short[] data) {
        long __functionAddress = GL.getICD().glNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 1, data, __functionAddress);
    }

    public static void glNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") int[] data) {
        long __functionAddress = GL.getICD().glNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 2, data, __functionAddress);
    }

    public static void glNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") float[] data) {
        long __functionAddress = GL.getICD().glNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 2, data, __functionAddress);
    }

    public static void glNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void const *") double[] data) {
        long __functionAddress = GL.getICD().glNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 3, data, __functionAddress);
    }

    public static void glGetNamedBufferParameterivEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetNamedBufferParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(buffer, pname, params, __functionAddress);
    }

    public static void glGetNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") short[] data) {
        long __functionAddress = GL.getICD().glGetNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 1, data, __functionAddress);
    }

    public static void glGetNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") int[] data) {
        long __functionAddress = GL.getICD().glGetNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 2, data, __functionAddress);
    }

    public static void glGetNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") float[] data) {
        long __functionAddress = GL.getICD().glGetNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 2, data, __functionAddress);
    }

    public static void glGetNamedBufferSubDataEXT(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="void *") double[] data) {
        long __functionAddress = GL.getICD().glGetNamedBufferSubDataEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPPPV(buffer, offset, Integer.toUnsignedLong(data.length) << 3, data, __functionAddress);
    }

    public static void glProgramUniform1fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniform1fvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length, value, __functionAddress);
    }

    public static void glProgramUniform2fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniform2fvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
    }

    public static void glProgramUniform3fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniform3fvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 3, value, __functionAddress);
    }

    public static void glProgramUniform4fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniform4fvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
    }

    public static void glProgramUniform1ivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        long __functionAddress = GL.getICD().glProgramUniform1ivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length, value, __functionAddress);
    }

    public static void glProgramUniform2ivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        long __functionAddress = GL.getICD().glProgramUniform2ivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
    }

    public static void glProgramUniform3ivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        long __functionAddress = GL.getICD().glProgramUniform3ivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 3, value, __functionAddress);
    }

    public static void glProgramUniform4ivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLint const *") int[] value) {
        long __functionAddress = GL.getICD().glProgramUniform4ivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
    }

    public static void glProgramUniformMatrix2fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix2fvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 2, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix3fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix3fvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 9, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix4fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix4fvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 4, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix2x3fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix2x3fvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 6, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix3x2fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix3x2fvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 6, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix2x4fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix2x4fvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 3, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix4x2fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix4x2fvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 3, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix3x4fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix3x4fvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 12, transpose, value, __functionAddress);
    }

    public static void glProgramUniformMatrix4x3fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        long __functionAddress = GL.getICD().glProgramUniformMatrix4x3fvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 12, transpose, value, __functionAddress);
    }

    public static void glTextureParameterIivEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = GL.getICD().glTextureParameterIivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(texture, target, pname, params, __functionAddress);
    }

    public static void glTextureParameterIuivEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint const *") int[] params) {
        long __functionAddress = GL.getICD().glTextureParameterIuivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(texture, target, pname, params, __functionAddress);
    }

    public static void glGetTextureParameterIivEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetTextureParameterIivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texture, target, pname, params, __functionAddress);
    }

    public static void glGetTextureParameterIuivEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") int[] params) {
        long __functionAddress = GL.getICD().glGetTextureParameterIuivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texture, target, pname, params, __functionAddress);
    }

    public static void glMultiTexParameterIivEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = GL.getICD().glMultiTexParameterIivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(texunit, target, pname, params, __functionAddress);
    }

    public static void glMultiTexParameterIuivEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint const *") int[] params) {
        long __functionAddress = GL.getICD().glMultiTexParameterIuivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(texunit, target, pname, params, __functionAddress);
    }

    public static void glGetMultiTexParameterIivEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetMultiTexParameterIivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texunit, target, pname, params, __functionAddress);
    }

    public static void glGetMultiTexParameterIuivEXT(@NativeType(value="GLenum") int texunit, @NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") int[] params) {
        long __functionAddress = GL.getICD().glGetMultiTexParameterIuivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(texunit, target, pname, params, __functionAddress);
    }

    public static void glProgramUniform1uivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glProgramUniform1uivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length, value, __functionAddress);
    }

    public static void glProgramUniform2uivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glProgramUniform2uivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 1, value, __functionAddress);
    }

    public static void glProgramUniform3uivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glProgramUniform3uivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length / 3, value, __functionAddress);
    }

    public static void glProgramUniform4uivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glProgramUniform4uivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, location, value.length >> 2, value, __functionAddress);
    }

    public static void glNamedProgramLocalParameters4fvEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat const *") float[] params) {
        long __functionAddress = GL.getICD().glNamedProgramLocalParameters4fvEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, target, index, params.length >> 2, params, __functionAddress);
    }

    public static void glNamedProgramLocalParameterI4ivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = GL.getICD().glNamedProgramLocalParameterI4ivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(program, target, index, params, __functionAddress);
    }

    public static void glNamedProgramLocalParametersI4ivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = GL.getICD().glNamedProgramLocalParametersI4ivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, target, index, params.length >> 2, params, __functionAddress);
    }

    public static void glNamedProgramLocalParameterI4uivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") int[] params) {
        long __functionAddress = GL.getICD().glNamedProgramLocalParameterI4uivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(program, target, index, params, __functionAddress);
    }

    public static void glNamedProgramLocalParametersI4uivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") int[] params) {
        long __functionAddress = GL.getICD().glNamedProgramLocalParametersI4uivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(program, target, index, params.length >> 2, params, __functionAddress);
    }

    public static void glGetNamedProgramLocalParameterIivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetNamedProgramLocalParameterIivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(program, target, index, params, __functionAddress);
    }

    public static void glGetNamedProgramLocalParameterIuivEXT(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLuint *") int[] params) {
        long __functionAddress = GL.getICD().glGetNamedProgramLocalParameterIuivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(program, target, index, params, __functionAddress);
    }

    public static void glGetNamedRenderbufferParameterivEXT(@NativeType(value="GLuint") int renderbuffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetNamedRenderbufferParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(renderbuffer, pname, params, __functionAddress);
    }

    public static void glGetNamedFramebufferAttachmentParameterivEXT(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int attachment, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetNamedFramebufferAttachmentParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(framebuffer, attachment, pname, params, __functionAddress);
    }

    public static void glFramebufferDrawBuffersEXT(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum const *") int[] bufs) {
        long __functionAddress = GL.getICD().glFramebufferDrawBuffersEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(framebuffer, bufs.length, bufs, __functionAddress);
    }

    public static void glGetFramebufferParameterivEXT(@NativeType(value="GLuint") int framebuffer, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] param) {
        long __functionAddress = GL.getICD().glGetFramebufferParameterivEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(param, 1);
        }
        JNI.callPV(framebuffer, pname, param, __functionAddress);
    }

    public static void glGetVertexArrayIntegervEXT(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] param) {
        long __functionAddress = GL.getICD().glGetVertexArrayIntegervEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(param, 1);
        }
        JNI.callPV(vaobj, pname, param, __functionAddress);
    }

    public static void glGetVertexArrayIntegeri_vEXT(@NativeType(value="GLuint") int vaobj, @NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] param) {
        long __functionAddress = GL.getICD().glGetVertexArrayIntegeri_vEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(param, 1);
        }
        JNI.callPV(vaobj, index, pname, param, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

