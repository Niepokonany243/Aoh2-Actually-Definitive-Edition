/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL21;
import org.lwjgl.opengl.GL30C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class GL30
extends GL21 {
    public static final int GL_MAJOR_VERSION = 33307;
    public static final int GL_MINOR_VERSION = 33308;
    public static final int GL_NUM_EXTENSIONS = 33309;
    public static final int GL_CONTEXT_FLAGS = 33310;
    public static final int GL_CONTEXT_FLAG_FORWARD_COMPATIBLE_BIT = 1;
    public static final int GL_COMPARE_REF_TO_TEXTURE = 34894;
    public static final int GL_CLIP_DISTANCE0 = 12288;
    public static final int GL_CLIP_DISTANCE1 = 12289;
    public static final int GL_CLIP_DISTANCE2 = 12290;
    public static final int GL_CLIP_DISTANCE3 = 12291;
    public static final int GL_CLIP_DISTANCE4 = 12292;
    public static final int GL_CLIP_DISTANCE5 = 12293;
    public static final int GL_CLIP_DISTANCE6 = 12294;
    public static final int GL_CLIP_DISTANCE7 = 12295;
    public static final int GL_MAX_CLIP_DISTANCES = 3378;
    public static final int GL_MAX_VARYING_COMPONENTS = 35659;
    public static final int GL_VERTEX_ATTRIB_ARRAY_INTEGER = 35069;
    public static final int GL_SAMPLER_1D_ARRAY = 36288;
    public static final int GL_SAMPLER_2D_ARRAY = 36289;
    public static final int GL_SAMPLER_1D_ARRAY_SHADOW = 36291;
    public static final int GL_SAMPLER_2D_ARRAY_SHADOW = 36292;
    public static final int GL_SAMPLER_CUBE_SHADOW = 36293;
    public static final int GL_UNSIGNED_INT_VEC2 = 36294;
    public static final int GL_UNSIGNED_INT_VEC3 = 36295;
    public static final int GL_UNSIGNED_INT_VEC4 = 36296;
    public static final int GL_INT_SAMPLER_1D = 36297;
    public static final int GL_INT_SAMPLER_2D = 36298;
    public static final int GL_INT_SAMPLER_3D = 36299;
    public static final int GL_INT_SAMPLER_CUBE = 36300;
    public static final int GL_INT_SAMPLER_1D_ARRAY = 36302;
    public static final int GL_INT_SAMPLER_2D_ARRAY = 36303;
    public static final int GL_UNSIGNED_INT_SAMPLER_1D = 36305;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D = 36306;
    public static final int GL_UNSIGNED_INT_SAMPLER_3D = 36307;
    public static final int GL_UNSIGNED_INT_SAMPLER_CUBE = 36308;
    public static final int GL_UNSIGNED_INT_SAMPLER_1D_ARRAY = 36310;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_ARRAY = 36311;
    public static final int GL_MIN_PROGRAM_TEXEL_OFFSET = 35076;
    public static final int GL_MAX_PROGRAM_TEXEL_OFFSET = 35077;
    public static final int GL_QUERY_WAIT = 36371;
    public static final int GL_QUERY_NO_WAIT = 36372;
    public static final int GL_QUERY_BY_REGION_WAIT = 36373;
    public static final int GL_QUERY_BY_REGION_NO_WAIT = 36374;
    public static final int GL_MAP_READ_BIT = 1;
    public static final int GL_MAP_WRITE_BIT = 2;
    public static final int GL_MAP_INVALIDATE_RANGE_BIT = 4;
    public static final int GL_MAP_INVALIDATE_BUFFER_BIT = 8;
    public static final int GL_MAP_FLUSH_EXPLICIT_BIT = 16;
    public static final int GL_MAP_UNSYNCHRONIZED_BIT = 32;
    public static final int GL_BUFFER_ACCESS_FLAGS = 37151;
    public static final int GL_BUFFER_MAP_LENGTH = 37152;
    public static final int GL_BUFFER_MAP_OFFSET = 37153;
    public static final int GL_CLAMP_VERTEX_COLOR = 35098;
    public static final int GL_CLAMP_FRAGMENT_COLOR = 35099;
    public static final int GL_CLAMP_READ_COLOR = 35100;
    public static final int GL_FIXED_ONLY = 35101;
    public static final int GL_DEPTH_COMPONENT32F = 36012;
    public static final int GL_DEPTH32F_STENCIL8 = 36013;
    public static final int GL_FLOAT_32_UNSIGNED_INT_24_8_REV = 36269;
    public static final int GL_TEXTURE_RED_TYPE = 35856;
    public static final int GL_TEXTURE_GREEN_TYPE = 35857;
    public static final int GL_TEXTURE_BLUE_TYPE = 35858;
    public static final int GL_TEXTURE_ALPHA_TYPE = 35859;
    public static final int GL_TEXTURE_LUMINANCE_TYPE = 35860;
    public static final int GL_TEXTURE_INTENSITY_TYPE = 35861;
    public static final int GL_TEXTURE_DEPTH_TYPE = 35862;
    public static final int GL_UNSIGNED_NORMALIZED = 35863;
    public static final int GL_RGBA32F = 34836;
    public static final int GL_RGB32F = 34837;
    public static final int GL_RGBA16F = 34842;
    public static final int GL_RGB16F = 34843;
    public static final int GL_R11F_G11F_B10F = 35898;
    public static final int GL_UNSIGNED_INT_10F_11F_11F_REV = 35899;
    public static final int GL_RGB9_E5 = 35901;
    public static final int GL_UNSIGNED_INT_5_9_9_9_REV = 35902;
    public static final int GL_TEXTURE_SHARED_SIZE = 35903;
    public static final int GL_FRAMEBUFFER = 36160;
    public static final int GL_READ_FRAMEBUFFER = 36008;
    public static final int GL_DRAW_FRAMEBUFFER = 36009;
    public static final int GL_RENDERBUFFER = 36161;
    public static final int GL_STENCIL_INDEX1 = 36166;
    public static final int GL_STENCIL_INDEX4 = 36167;
    public static final int GL_STENCIL_INDEX8 = 36168;
    public static final int GL_STENCIL_INDEX16 = 36169;
    public static final int GL_RENDERBUFFER_WIDTH = 36162;
    public static final int GL_RENDERBUFFER_HEIGHT = 36163;
    public static final int GL_RENDERBUFFER_INTERNAL_FORMAT = 36164;
    public static final int GL_RENDERBUFFER_RED_SIZE = 36176;
    public static final int GL_RENDERBUFFER_GREEN_SIZE = 36177;
    public static final int GL_RENDERBUFFER_BLUE_SIZE = 36178;
    public static final int GL_RENDERBUFFER_ALPHA_SIZE = 36179;
    public static final int GL_RENDERBUFFER_DEPTH_SIZE = 36180;
    public static final int GL_RENDERBUFFER_STENCIL_SIZE = 36181;
    public static final int GL_RENDERBUFFER_SAMPLES = 36011;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = 36048;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = 36049;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = 36050;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 36051;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER = 36052;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING = 33296;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE = 33297;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_RED_SIZE = 33298;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_GREEN_SIZE = 33299;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_BLUE_SIZE = 33300;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_ALPHA_SIZE = 33301;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_DEPTH_SIZE = 33302;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_STENCIL_SIZE = 33303;
    public static final int GL_FRAMEBUFFER_DEFAULT = 33304;
    public static final int GL_INDEX = 33314;
    public static final int GL_COLOR_ATTACHMENT0 = 36064;
    public static final int GL_COLOR_ATTACHMENT1 = 36065;
    public static final int GL_COLOR_ATTACHMENT2 = 36066;
    public static final int GL_COLOR_ATTACHMENT3 = 36067;
    public static final int GL_COLOR_ATTACHMENT4 = 36068;
    public static final int GL_COLOR_ATTACHMENT5 = 36069;
    public static final int GL_COLOR_ATTACHMENT6 = 36070;
    public static final int GL_COLOR_ATTACHMENT7 = 36071;
    public static final int GL_COLOR_ATTACHMENT8 = 36072;
    public static final int GL_COLOR_ATTACHMENT9 = 36073;
    public static final int GL_COLOR_ATTACHMENT10 = 36074;
    public static final int GL_COLOR_ATTACHMENT11 = 36075;
    public static final int GL_COLOR_ATTACHMENT12 = 36076;
    public static final int GL_COLOR_ATTACHMENT13 = 36077;
    public static final int GL_COLOR_ATTACHMENT14 = 36078;
    public static final int GL_COLOR_ATTACHMENT15 = 36079;
    public static final int GL_COLOR_ATTACHMENT16 = 36080;
    public static final int GL_COLOR_ATTACHMENT17 = 36081;
    public static final int GL_COLOR_ATTACHMENT18 = 36082;
    public static final int GL_COLOR_ATTACHMENT19 = 36083;
    public static final int GL_COLOR_ATTACHMENT20 = 36084;
    public static final int GL_COLOR_ATTACHMENT21 = 36085;
    public static final int GL_COLOR_ATTACHMENT22 = 36086;
    public static final int GL_COLOR_ATTACHMENT23 = 36087;
    public static final int GL_COLOR_ATTACHMENT24 = 36088;
    public static final int GL_COLOR_ATTACHMENT25 = 36089;
    public static final int GL_COLOR_ATTACHMENT26 = 36090;
    public static final int GL_COLOR_ATTACHMENT27 = 36091;
    public static final int GL_COLOR_ATTACHMENT28 = 36092;
    public static final int GL_COLOR_ATTACHMENT29 = 36093;
    public static final int GL_COLOR_ATTACHMENT30 = 36094;
    public static final int GL_COLOR_ATTACHMENT31 = 36095;
    public static final int GL_DEPTH_ATTACHMENT = 36096;
    public static final int GL_STENCIL_ATTACHMENT = 36128;
    public static final int GL_DEPTH_STENCIL_ATTACHMENT = 33306;
    public static final int GL_MAX_SAMPLES = 36183;
    public static final int GL_FRAMEBUFFER_COMPLETE = 36053;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT = 36054;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = 36055;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER = 36059;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER = 36060;
    public static final int GL_FRAMEBUFFER_UNSUPPORTED = 36061;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE = 36182;
    public static final int GL_FRAMEBUFFER_UNDEFINED = 33305;
    public static final int GL_FRAMEBUFFER_BINDING = 36006;
    public static final int GL_DRAW_FRAMEBUFFER_BINDING = 36006;
    public static final int GL_READ_FRAMEBUFFER_BINDING = 36010;
    public static final int GL_RENDERBUFFER_BINDING = 36007;
    public static final int GL_MAX_COLOR_ATTACHMENTS = 36063;
    public static final int GL_MAX_RENDERBUFFER_SIZE = 34024;
    public static final int GL_INVALID_FRAMEBUFFER_OPERATION = 1286;
    public static final int GL_DEPTH_STENCIL = 34041;
    public static final int GL_UNSIGNED_INT_24_8 = 34042;
    public static final int GL_DEPTH24_STENCIL8 = 35056;
    public static final int GL_TEXTURE_STENCIL_SIZE = 35057;
    public static final int GL_HALF_FLOAT = 5131;
    public static final int GL_RGBA32UI = 36208;
    public static final int GL_RGB32UI = 36209;
    public static final int GL_RGBA16UI = 36214;
    public static final int GL_RGB16UI = 36215;
    public static final int GL_RGBA8UI = 36220;
    public static final int GL_RGB8UI = 36221;
    public static final int GL_RGBA32I = 36226;
    public static final int GL_RGB32I = 36227;
    public static final int GL_RGBA16I = 36232;
    public static final int GL_RGB16I = 36233;
    public static final int GL_RGBA8I = 36238;
    public static final int GL_RGB8I = 36239;
    public static final int GL_RED_INTEGER = 36244;
    public static final int GL_GREEN_INTEGER = 36245;
    public static final int GL_BLUE_INTEGER = 36246;
    public static final int GL_ALPHA_INTEGER = 36247;
    public static final int GL_RGB_INTEGER = 36248;
    public static final int GL_RGBA_INTEGER = 36249;
    public static final int GL_BGR_INTEGER = 36250;
    public static final int GL_BGRA_INTEGER = 36251;
    public static final int GL_TEXTURE_1D_ARRAY = 35864;
    public static final int GL_TEXTURE_2D_ARRAY = 35866;
    public static final int GL_PROXY_TEXTURE_2D_ARRAY = 35867;
    public static final int GL_PROXY_TEXTURE_1D_ARRAY = 35865;
    public static final int GL_TEXTURE_BINDING_1D_ARRAY = 35868;
    public static final int GL_TEXTURE_BINDING_2D_ARRAY = 35869;
    public static final int GL_MAX_ARRAY_TEXTURE_LAYERS = 35071;
    public static final int GL_COMPRESSED_RED_RGTC1 = 36283;
    public static final int GL_COMPRESSED_SIGNED_RED_RGTC1 = 36284;
    public static final int GL_COMPRESSED_RG_RGTC2 = 36285;
    public static final int GL_COMPRESSED_SIGNED_RG_RGTC2 = 36286;
    public static final int GL_R8 = 33321;
    public static final int GL_R16 = 33322;
    public static final int GL_RG8 = 33323;
    public static final int GL_RG16 = 33324;
    public static final int GL_R16F = 33325;
    public static final int GL_R32F = 33326;
    public static final int GL_RG16F = 33327;
    public static final int GL_RG32F = 33328;
    public static final int GL_R8I = 33329;
    public static final int GL_R8UI = 33330;
    public static final int GL_R16I = 33331;
    public static final int GL_R16UI = 33332;
    public static final int GL_R32I = 33333;
    public static final int GL_R32UI = 33334;
    public static final int GL_RG8I = 33335;
    public static final int GL_RG8UI = 33336;
    public static final int GL_RG16I = 33337;
    public static final int GL_RG16UI = 33338;
    public static final int GL_RG32I = 33339;
    public static final int GL_RG32UI = 33340;
    public static final int GL_RG = 33319;
    public static final int GL_COMPRESSED_RED = 33317;
    public static final int GL_COMPRESSED_RG = 33318;
    public static final int GL_RG_INTEGER = 33320;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER = 35982;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_START = 35972;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_SIZE = 35973;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING = 35983;
    public static final int GL_INTERLEAVED_ATTRIBS = 35980;
    public static final int GL_SEPARATE_ATTRIBS = 35981;
    public static final int GL_PRIMITIVES_GENERATED = 35975;
    public static final int GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN = 35976;
    public static final int GL_RASTERIZER_DISCARD = 35977;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS = 35978;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS = 35979;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS = 35968;
    public static final int GL_TRANSFORM_FEEDBACK_VARYINGS = 35971;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_MODE = 35967;
    public static final int GL_TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH = 35958;
    public static final int GL_VERTEX_ARRAY_BINDING = 34229;
    public static final int GL_FRAMEBUFFER_SRGB = 36281;

    protected GL30() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glGetStringi, caps.glClearBufferiv, caps.glClearBufferuiv, caps.glClearBufferfv, caps.glClearBufferfi, caps.glVertexAttribI1i, caps.glVertexAttribI2i, caps.glVertexAttribI3i, caps.glVertexAttribI4i, caps.glVertexAttribI1ui, caps.glVertexAttribI2ui, caps.glVertexAttribI3ui, caps.glVertexAttribI4ui, caps.glVertexAttribI1iv, caps.glVertexAttribI2iv, caps.glVertexAttribI3iv, caps.glVertexAttribI4iv, caps.glVertexAttribI1uiv, caps.glVertexAttribI2uiv, caps.glVertexAttribI3uiv, caps.glVertexAttribI4uiv, caps.glVertexAttribI4bv, caps.glVertexAttribI4sv, caps.glVertexAttribI4ubv, caps.glVertexAttribI4usv, caps.glVertexAttribIPointer, caps.glGetVertexAttribIiv, caps.glGetVertexAttribIuiv, caps.glUniform1ui, caps.glUniform2ui, caps.glUniform3ui, caps.glUniform4ui, caps.glUniform1uiv, caps.glUniform2uiv, caps.glUniform3uiv, caps.glUniform4uiv, caps.glGetUniformuiv, caps.glBindFragDataLocation, caps.glGetFragDataLocation, caps.glBeginConditionalRender, caps.glEndConditionalRender, caps.glMapBufferRange, caps.glFlushMappedBufferRange, caps.glClampColor, caps.glIsRenderbuffer, caps.glBindRenderbuffer, caps.glDeleteRenderbuffers, caps.glGenRenderbuffers, caps.glRenderbufferStorage, caps.glRenderbufferStorageMultisample, caps.glGetRenderbufferParameteriv, caps.glIsFramebuffer, caps.glBindFramebuffer, caps.glDeleteFramebuffers, caps.glGenFramebuffers, caps.glCheckFramebufferStatus, caps.glFramebufferTexture1D, caps.glFramebufferTexture2D, caps.glFramebufferTexture3D, caps.glFramebufferTextureLayer, caps.glFramebufferRenderbuffer, caps.glGetFramebufferAttachmentParameteriv, caps.glBlitFramebuffer, caps.glGenerateMipmap, caps.glTexParameterIiv, caps.glTexParameterIuiv, caps.glGetTexParameterIiv, caps.glGetTexParameterIuiv, caps.glColorMaski, caps.glGetBooleani_v, caps.glGetIntegeri_v, caps.glEnablei, caps.glDisablei, caps.glIsEnabledi, caps.glBindBufferRange, caps.glBindBufferBase, caps.glBeginTransformFeedback, caps.glEndTransformFeedback, caps.glTransformFeedbackVaryings, caps.glGetTransformFeedbackVarying, caps.glBindVertexArray, caps.glDeleteVertexArrays, caps.glGenVertexArrays, caps.glIsVertexArray);
    }

    public static long nglGetStringi(int name, int index) {
        return GL30C.nglGetStringi(name, index);
    }

    @Nullable
    @NativeType(value="GLubyte const *")
    public static String glGetStringi(@NativeType(value="GLenum") int name, @NativeType(value="GLuint") int index) {
        return GL30C.glGetStringi(name, index);
    }

    public static void nglClearBufferiv(int buffer, int drawbuffer, long value) {
        GL30C.nglClearBufferiv(buffer, drawbuffer, value);
    }

    public static void glClearBufferiv(@NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLint *") IntBuffer value) {
        GL30C.glClearBufferiv(buffer, drawbuffer, value);
    }

    public static void nglClearBufferuiv(int buffer, int drawbuffer, long value) {
        GL30C.nglClearBufferuiv(buffer, drawbuffer, value);
    }

    public static void glClearBufferuiv(@NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLint *") IntBuffer value) {
        GL30C.glClearBufferuiv(buffer, drawbuffer, value);
    }

    public static void nglClearBufferfv(int buffer, int drawbuffer, long value) {
        GL30C.nglClearBufferfv(buffer, drawbuffer, value);
    }

    public static void glClearBufferfv(@NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLfloat *") FloatBuffer value) {
        GL30C.glClearBufferfv(buffer, drawbuffer, value);
    }

    public static void glClearBufferfi(@NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLfloat") float depth, @NativeType(value="GLint") int stencil) {
        GL30C.glClearBufferfi(buffer, drawbuffer, depth, stencil);
    }

    public static void glVertexAttribI1i(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int x) {
        GL30C.glVertexAttribI1i(index, x);
    }

    public static void glVertexAttribI2i(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y) {
        GL30C.glVertexAttribI2i(index, x, y);
    }

    public static void glVertexAttribI3i(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLint") int z) {
        GL30C.glVertexAttribI3i(index, x, y, z);
    }

    public static void glVertexAttribI4i(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLint") int z, @NativeType(value="GLint") int w) {
        GL30C.glVertexAttribI4i(index, x, y, z, w);
    }

    public static void glVertexAttribI1ui(@NativeType(value="GLuint") int index, @NativeType(value="GLuint") int x) {
        GL30C.glVertexAttribI1ui(index, x);
    }

    public static void glVertexAttribI2ui(@NativeType(value="GLuint") int index, @NativeType(value="GLuint") int x, @NativeType(value="GLuint") int y) {
        GL30C.glVertexAttribI2ui(index, x, y);
    }

    public static void glVertexAttribI3ui(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLint") int z) {
        GL30C.glVertexAttribI3ui(index, x, y, z);
    }

    public static void glVertexAttribI4ui(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLint") int z, @NativeType(value="GLint") int w) {
        GL30C.glVertexAttribI4ui(index, x, y, z, w);
    }

    public static void nglVertexAttribI1iv(int index, long v) {
        GL30C.nglVertexAttribI1iv(index, v);
    }

    public static void glVertexAttribI1iv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer v) {
        GL30C.glVertexAttribI1iv(index, v);
    }

    public static void nglVertexAttribI2iv(int index, long v) {
        GL30C.nglVertexAttribI2iv(index, v);
    }

    public static void glVertexAttribI2iv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer v) {
        GL30C.glVertexAttribI2iv(index, v);
    }

    public static void nglVertexAttribI3iv(int index, long v) {
        GL30C.nglVertexAttribI3iv(index, v);
    }

    public static void glVertexAttribI3iv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer v) {
        GL30C.glVertexAttribI3iv(index, v);
    }

    public static void nglVertexAttribI4iv(int index, long v) {
        GL30C.nglVertexAttribI4iv(index, v);
    }

    public static void glVertexAttribI4iv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer v) {
        GL30C.glVertexAttribI4iv(index, v);
    }

    public static void nglVertexAttribI1uiv(int index, long v) {
        GL30C.nglVertexAttribI1uiv(index, v);
    }

    public static void glVertexAttribI1uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") IntBuffer v) {
        GL30C.glVertexAttribI1uiv(index, v);
    }

    public static void nglVertexAttribI2uiv(int index, long v) {
        GL30C.nglVertexAttribI2uiv(index, v);
    }

    public static void glVertexAttribI2uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") IntBuffer v) {
        GL30C.glVertexAttribI2uiv(index, v);
    }

    public static void nglVertexAttribI3uiv(int index, long v) {
        GL30C.nglVertexAttribI3uiv(index, v);
    }

    public static void glVertexAttribI3uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") IntBuffer v) {
        GL30C.glVertexAttribI3uiv(index, v);
    }

    public static void nglVertexAttribI4uiv(int index, long v) {
        GL30C.nglVertexAttribI4uiv(index, v);
    }

    public static void glVertexAttribI4uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") IntBuffer v) {
        GL30C.glVertexAttribI4uiv(index, v);
    }

    public static void nglVertexAttribI4bv(int index, long v) {
        GL30C.nglVertexAttribI4bv(index, v);
    }

    public static void glVertexAttribI4bv(@NativeType(value="GLuint") int index, @NativeType(value="GLbyte const *") ByteBuffer v) {
        GL30C.glVertexAttribI4bv(index, v);
    }

    public static void nglVertexAttribI4sv(int index, long v) {
        GL30C.nglVertexAttribI4sv(index, v);
    }

    public static void glVertexAttribI4sv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        GL30C.glVertexAttribI4sv(index, v);
    }

    public static void nglVertexAttribI4ubv(int index, long v) {
        GL30C.nglVertexAttribI4ubv(index, v);
    }

    public static void glVertexAttribI4ubv(@NativeType(value="GLuint") int index, @NativeType(value="GLbyte const *") ByteBuffer v) {
        GL30C.glVertexAttribI4ubv(index, v);
    }

    public static void nglVertexAttribI4usv(int index, long v) {
        GL30C.nglVertexAttribI4usv(index, v);
    }

    public static void glVertexAttribI4usv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        GL30C.glVertexAttribI4usv(index, v);
    }

    public static void nglVertexAttribIPointer(int index, int size, int type, int stride, long pointer) {
        GL30C.nglVertexAttribIPointer(index, size, type, stride, pointer);
    }

    public static void glVertexAttribIPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ByteBuffer pointer) {
        GL30C.glVertexAttribIPointer(index, size, type, stride, pointer);
    }

    public static void glVertexAttribIPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") long pointer) {
        GL30C.glVertexAttribIPointer(index, size, type, stride, pointer);
    }

    public static void glVertexAttribIPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ShortBuffer pointer) {
        GL30C.glVertexAttribIPointer(index, size, type, stride, pointer);
    }

    public static void glVertexAttribIPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") IntBuffer pointer) {
        GL30C.glVertexAttribIPointer(index, size, type, stride, pointer);
    }

    public static void nglGetVertexAttribIiv(int index, int pname, long params) {
        GL30C.nglGetVertexAttribIiv(index, pname, params);
    }

    public static void glGetVertexAttribIiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL30C.glGetVertexAttribIiv(index, pname, params);
    }

    @NativeType(value="void")
    public static int glGetVertexAttribIi(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        return GL30C.glGetVertexAttribIi(index, pname);
    }

    public static void nglGetVertexAttribIuiv(int index, int pname, long params) {
        GL30C.nglGetVertexAttribIuiv(index, pname, params);
    }

    public static void glGetVertexAttribIuiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") IntBuffer params) {
        GL30C.glGetVertexAttribIuiv(index, pname, params);
    }

    @NativeType(value="void")
    public static int glGetVertexAttribIui(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        return GL30C.glGetVertexAttribIui(index, pname);
    }

    public static void glUniform1ui(@NativeType(value="GLint") int location, @NativeType(value="GLuint") int v0) {
        GL30C.glUniform1ui(location, v0);
    }

    public static void glUniform2ui(@NativeType(value="GLint") int location, @NativeType(value="GLuint") int v0, @NativeType(value="GLuint") int v1) {
        GL30C.glUniform2ui(location, v0, v1);
    }

    public static void glUniform3ui(@NativeType(value="GLint") int location, @NativeType(value="GLuint") int v0, @NativeType(value="GLuint") int v1, @NativeType(value="GLuint") int v2) {
        GL30C.glUniform3ui(location, v0, v1, v2);
    }

    public static void glUniform4ui(@NativeType(value="GLint") int location, @NativeType(value="GLuint") int v0, @NativeType(value="GLuint") int v1, @NativeType(value="GLuint") int v2, @NativeType(value="GLuint") int v3) {
        GL30C.glUniform4ui(location, v0, v1, v2, v3);
    }

    public static void nglUniform1uiv(int location, int count, long value) {
        GL30C.nglUniform1uiv(location, count, value);
    }

    public static void glUniform1uiv(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        GL30C.glUniform1uiv(location, value);
    }

    public static void nglUniform2uiv(int location, int count, long value) {
        GL30C.nglUniform2uiv(location, count, value);
    }

    public static void glUniform2uiv(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        GL30C.glUniform2uiv(location, value);
    }

    public static void nglUniform3uiv(int location, int count, long value) {
        GL30C.nglUniform3uiv(location, count, value);
    }

    public static void glUniform3uiv(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        GL30C.glUniform3uiv(location, value);
    }

    public static void nglUniform4uiv(int location, int count, long value) {
        GL30C.nglUniform4uiv(location, count, value);
    }

    public static void glUniform4uiv(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        GL30C.glUniform4uiv(location, value);
    }

    public static void nglGetUniformuiv(int program, int location, long params) {
        GL30C.nglGetUniformuiv(program, location, params);
    }

    public static void glGetUniformuiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint *") IntBuffer params) {
        GL30C.glGetUniformuiv(program, location, params);
    }

    @NativeType(value="void")
    public static int glGetUniformui(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        return GL30C.glGetUniformui(program, location);
    }

    public static void nglBindFragDataLocation(int program, int colorNumber, long name) {
        GL30C.nglBindFragDataLocation(program, colorNumber, name);
    }

    public static void glBindFragDataLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int colorNumber, @NativeType(value="GLchar const *") ByteBuffer name) {
        GL30C.glBindFragDataLocation(program, colorNumber, name);
    }

    public static void glBindFragDataLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int colorNumber, @NativeType(value="GLchar const *") CharSequence name) {
        GL30C.glBindFragDataLocation(program, colorNumber, name);
    }

    public static int nglGetFragDataLocation(int program, long name) {
        return GL30C.nglGetFragDataLocation(program, name);
    }

    @NativeType(value="GLint")
    public static int glGetFragDataLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") ByteBuffer name) {
        return GL30C.glGetFragDataLocation(program, name);
    }

    @NativeType(value="GLint")
    public static int glGetFragDataLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") CharSequence name) {
        return GL30C.glGetFragDataLocation(program, name);
    }

    public static void glBeginConditionalRender(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int mode) {
        GL30C.glBeginConditionalRender(id, mode);
    }

    public static void glEndConditionalRender() {
        GL30C.glEndConditionalRender();
    }

    public static long nglMapBufferRange(int target, long offset, long length, int access) {
        return GL30C.nglMapBufferRange(target, offset, length, access);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapBufferRange(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long length, @NativeType(value="GLbitfield") int access) {
        return GL30C.glMapBufferRange(target, offset, length, access);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapBufferRange(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long length, @NativeType(value="GLbitfield") int access, @Nullable ByteBuffer old_buffer) {
        return GL30C.glMapBufferRange(target, offset, length, access, old_buffer);
    }

    public static void glFlushMappedBufferRange(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long length) {
        GL30C.glFlushMappedBufferRange(target, offset, length);
    }

    public static void glClampColor(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int clamp) {
        GL30C.glClampColor(target, clamp);
    }

    @NativeType(value="GLboolean")
    public static boolean glIsRenderbuffer(@NativeType(value="GLuint") int renderbuffer) {
        return GL30C.glIsRenderbuffer(renderbuffer);
    }

    public static void glBindRenderbuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int renderbuffer) {
        GL30C.glBindRenderbuffer(target, renderbuffer);
    }

    public static void nglDeleteRenderbuffers(int n, long renderbuffers) {
        GL30C.nglDeleteRenderbuffers(n, renderbuffers);
    }

    public static void glDeleteRenderbuffers(@NativeType(value="GLuint const *") IntBuffer renderbuffers) {
        GL30C.glDeleteRenderbuffers(renderbuffers);
    }

    public static void glDeleteRenderbuffers(@NativeType(value="GLuint const *") int renderbuffer) {
        GL30C.glDeleteRenderbuffers(renderbuffer);
    }

    public static void nglGenRenderbuffers(int n, long renderbuffers) {
        GL30C.nglGenRenderbuffers(n, renderbuffers);
    }

    public static void glGenRenderbuffers(@NativeType(value="GLuint *") IntBuffer renderbuffers) {
        GL30C.glGenRenderbuffers(renderbuffers);
    }

    @NativeType(value="void")
    public static int glGenRenderbuffers() {
        return GL30C.glGenRenderbuffers();
    }

    public static void glRenderbufferStorage(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height) {
        GL30C.glRenderbufferStorage(target, internalformat, width, height);
    }

    public static void glRenderbufferStorageMultisample(@NativeType(value="GLenum") int target, @NativeType(value="GLsizei") int samples, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height) {
        GL30C.glRenderbufferStorageMultisample(target, samples, internalformat, width, height);
    }

    public static void nglGetRenderbufferParameteriv(int target, int pname, long params) {
        GL30C.nglGetRenderbufferParameteriv(target, pname, params);
    }

    public static void glGetRenderbufferParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL30C.glGetRenderbufferParameteriv(target, pname, params);
    }

    @NativeType(value="void")
    public static int glGetRenderbufferParameteri(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        return GL30C.glGetRenderbufferParameteri(target, pname);
    }

    @NativeType(value="GLboolean")
    public static boolean glIsFramebuffer(@NativeType(value="GLuint") int framebuffer) {
        return GL30C.glIsFramebuffer(framebuffer);
    }

    public static void glBindFramebuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int framebuffer) {
        GL30C.glBindFramebuffer(target, framebuffer);
    }

    public static void nglDeleteFramebuffers(int n, long framebuffers) {
        GL30C.nglDeleteFramebuffers(n, framebuffers);
    }

    public static void glDeleteFramebuffers(@NativeType(value="GLuint const *") IntBuffer framebuffers) {
        GL30C.glDeleteFramebuffers(framebuffers);
    }

    public static void glDeleteFramebuffers(@NativeType(value="GLuint const *") int framebuffer) {
        GL30C.glDeleteFramebuffers(framebuffer);
    }

    public static void nglGenFramebuffers(int n, long framebuffers) {
        GL30C.nglGenFramebuffers(n, framebuffers);
    }

    public static void glGenFramebuffers(@NativeType(value="GLuint *") IntBuffer framebuffers) {
        GL30C.glGenFramebuffers(framebuffers);
    }

    @NativeType(value="void")
    public static int glGenFramebuffers() {
        return GL30C.glGenFramebuffers();
    }

    @NativeType(value="GLenum")
    public static int glCheckFramebufferStatus(@NativeType(value="GLenum") int target) {
        return GL30C.glCheckFramebufferStatus(target);
    }

    public static void glFramebufferTexture1D(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int attachment, @NativeType(value="GLenum") int textarget, @NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level) {
        GL30C.glFramebufferTexture1D(target, attachment, textarget, texture, level);
    }

    public static void glFramebufferTexture2D(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int attachment, @NativeType(value="GLenum") int textarget, @NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level) {
        GL30C.glFramebufferTexture2D(target, attachment, textarget, texture, level);
    }

    public static void glFramebufferTexture3D(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int attachment, @NativeType(value="GLenum") int textarget, @NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int layer) {
        GL30C.glFramebufferTexture3D(target, attachment, textarget, texture, level, layer);
    }

    public static void glFramebufferTextureLayer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int attachment, @NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int layer) {
        GL30C.glFramebufferTextureLayer(target, attachment, texture, level, layer);
    }

    public static void glFramebufferRenderbuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int attachment, @NativeType(value="GLenum") int renderbuffertarget, @NativeType(value="GLuint") int renderbuffer) {
        GL30C.glFramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer);
    }

    public static void nglGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, long params) {
        GL30C.nglGetFramebufferAttachmentParameteriv(target, attachment, pname, params);
    }

    public static void glGetFramebufferAttachmentParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int attachment, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL30C.glGetFramebufferAttachmentParameteriv(target, attachment, pname, params);
    }

    @NativeType(value="void")
    public static int glGetFramebufferAttachmentParameteri(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int attachment, @NativeType(value="GLenum") int pname) {
        return GL30C.glGetFramebufferAttachmentParameteri(target, attachment, pname);
    }

    public static void glBlitFramebuffer(@NativeType(value="GLint") int srcX0, @NativeType(value="GLint") int srcY0, @NativeType(value="GLint") int srcX1, @NativeType(value="GLint") int srcY1, @NativeType(value="GLint") int dstX0, @NativeType(value="GLint") int dstY0, @NativeType(value="GLint") int dstX1, @NativeType(value="GLint") int dstY1, @NativeType(value="GLbitfield") int mask, @NativeType(value="GLenum") int filter) {
        GL30C.glBlitFramebuffer(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
    }

    public static void glGenerateMipmap(@NativeType(value="GLenum") int target) {
        GL30C.glGenerateMipmap(target);
    }

    public static void nglTexParameterIiv(int target, int pname, long params) {
        GL30C.nglTexParameterIiv(target, pname, params);
    }

    public static void glTexParameterIiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        GL30C.glTexParameterIiv(target, pname, params);
    }

    public static void glTexParameterIi(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int param) {
        GL30C.glTexParameterIi(target, pname, param);
    }

    public static void nglTexParameterIuiv(int target, int pname, long params) {
        GL30C.nglTexParameterIuiv(target, pname, params);
    }

    public static void glTexParameterIuiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint const *") IntBuffer params) {
        GL30C.glTexParameterIuiv(target, pname, params);
    }

    public static void glTexParameterIui(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint const *") int param) {
        GL30C.glTexParameterIui(target, pname, param);
    }

    public static void nglGetTexParameterIiv(int target, int pname, long params) {
        GL30C.nglGetTexParameterIiv(target, pname, params);
    }

    public static void glGetTexParameterIiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL30C.glGetTexParameterIiv(target, pname, params);
    }

    @NativeType(value="void")
    public static int glGetTexParameterIi(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        return GL30C.glGetTexParameterIi(target, pname);
    }

    public static void nglGetTexParameterIuiv(int target, int pname, long params) {
        GL30C.nglGetTexParameterIuiv(target, pname, params);
    }

    public static void glGetTexParameterIuiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") IntBuffer params) {
        GL30C.glGetTexParameterIuiv(target, pname, params);
    }

    @NativeType(value="void")
    public static int glGetTexParameterIui(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        return GL30C.glGetTexParameterIui(target, pname);
    }

    public static void glColorMaski(@NativeType(value="GLuint") int buf, @NativeType(value="GLboolean") boolean r, @NativeType(value="GLboolean") boolean g, @NativeType(value="GLboolean") boolean b, @NativeType(value="GLboolean") boolean a) {
        GL30C.glColorMaski(buf, r, g, b, a);
    }

    public static void nglGetBooleani_v(int target, int index, long data) {
        GL30C.nglGetBooleani_v(target, index, data);
    }

    public static void glGetBooleani_v(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLboolean *") ByteBuffer data) {
        GL30C.glGetBooleani_v(target, index, data);
    }

    @NativeType(value="void")
    public static boolean glGetBooleani(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        return GL30C.glGetBooleani(target, index);
    }

    public static void nglGetIntegeri_v(int target, int index, long data) {
        GL30C.nglGetIntegeri_v(target, index, data);
    }

    public static void glGetIntegeri_v(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") IntBuffer data) {
        GL30C.glGetIntegeri_v(target, index, data);
    }

    @NativeType(value="void")
    public static int glGetIntegeri(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        return GL30C.glGetIntegeri(target, index);
    }

    public static void glEnablei(@NativeType(value="GLenum") int cap, @NativeType(value="GLuint") int index) {
        GL30C.glEnablei(cap, index);
    }

    public static void glDisablei(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        GL30C.glDisablei(target, index);
    }

    @NativeType(value="GLboolean")
    public static boolean glIsEnabledi(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        return GL30C.glIsEnabledi(target, index);
    }

    public static void glBindBufferRange(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size) {
        GL30C.glBindBufferRange(target, index, buffer, offset, size);
    }

    public static void glBindBufferBase(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLuint") int buffer) {
        GL30C.glBindBufferBase(target, index, buffer);
    }

    public static void glBeginTransformFeedback(@NativeType(value="GLenum") int primitiveMode) {
        GL30C.glBeginTransformFeedback(primitiveMode);
    }

    public static void glEndTransformFeedback() {
        GL30C.glEndTransformFeedback();
    }

    public static void nglTransformFeedbackVaryings(int program, int count, long varyings, int bufferMode) {
        GL30C.nglTransformFeedbackVaryings(program, count, varyings, bufferMode);
    }

    public static void glTransformFeedbackVaryings(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const **") PointerBuffer varyings, @NativeType(value="GLenum") int bufferMode) {
        GL30C.glTransformFeedbackVaryings(program, varyings, bufferMode);
    }

    public static void glTransformFeedbackVaryings(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const **") CharSequence[] varyings, @NativeType(value="GLenum") int bufferMode) {
        GL30C.glTransformFeedbackVaryings(program, varyings, bufferMode);
    }

    public static void glTransformFeedbackVaryings(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const **") CharSequence varying, @NativeType(value="GLenum") int bufferMode) {
        GL30C.glTransformFeedbackVaryings(program, varying, bufferMode);
    }

    public static void nglGetTransformFeedbackVarying(int program, int index, int bufSize, long length, long size, long type, long name) {
        GL30C.nglGetTransformFeedbackVarying(program, index, bufSize, length, size, type, name);
    }

    public static void glGetTransformFeedbackVarying(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLsizei *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type, @NativeType(value="GLchar *") ByteBuffer name) {
        GL30C.glGetTransformFeedbackVarying(program, index, length, size, type, name);
    }

    @NativeType(value="void")
    public static String glGetTransformFeedbackVarying(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @NativeType(value="GLsizei") int bufSize, @NativeType(value="GLsizei *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type) {
        return GL30C.glGetTransformFeedbackVarying(program, index, bufSize, size, type);
    }

    @NativeType(value="void")
    public static String glGetTransformFeedbackVarying(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @NativeType(value="GLsizei *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type) {
        return GL30.glGetTransformFeedbackVarying(program, index, GL20.glGetProgrami(program, 35958), size, type);
    }

    public static void glBindVertexArray(@NativeType(value="GLuint") int array) {
        GL30C.glBindVertexArray(array);
    }

    public static void nglDeleteVertexArrays(int n, long arrays) {
        GL30C.nglDeleteVertexArrays(n, arrays);
    }

    public static void glDeleteVertexArrays(@NativeType(value="GLuint const *") IntBuffer arrays) {
        GL30C.glDeleteVertexArrays(arrays);
    }

    public static void glDeleteVertexArrays(@NativeType(value="GLuint const *") int array) {
        GL30C.glDeleteVertexArrays(array);
    }

    public static void nglGenVertexArrays(int n, long arrays) {
        GL30C.nglGenVertexArrays(n, arrays);
    }

    public static void glGenVertexArrays(@NativeType(value="GLuint *") IntBuffer arrays) {
        GL30C.glGenVertexArrays(arrays);
    }

    @NativeType(value="void")
    public static int glGenVertexArrays() {
        return GL30C.glGenVertexArrays();
    }

    @NativeType(value="GLboolean")
    public static boolean glIsVertexArray(@NativeType(value="GLuint") int array) {
        return GL30C.glIsVertexArray(array);
    }

    public static void glClearBufferiv(@NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLint *") int[] value) {
        GL30C.glClearBufferiv(buffer, drawbuffer, value);
    }

    public static void glClearBufferuiv(@NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLint *") int[] value) {
        GL30C.glClearBufferuiv(buffer, drawbuffer, value);
    }

    public static void glClearBufferfv(@NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLfloat *") float[] value) {
        GL30C.glClearBufferfv(buffer, drawbuffer, value);
    }

    public static void glVertexAttribI1iv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] v) {
        GL30C.glVertexAttribI1iv(index, v);
    }

    public static void glVertexAttribI2iv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] v) {
        GL30C.glVertexAttribI2iv(index, v);
    }

    public static void glVertexAttribI3iv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] v) {
        GL30C.glVertexAttribI3iv(index, v);
    }

    public static void glVertexAttribI4iv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] v) {
        GL30C.glVertexAttribI4iv(index, v);
    }

    public static void glVertexAttribI1uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") int[] v) {
        GL30C.glVertexAttribI1uiv(index, v);
    }

    public static void glVertexAttribI2uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") int[] v) {
        GL30C.glVertexAttribI2uiv(index, v);
    }

    public static void glVertexAttribI3uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") int[] v) {
        GL30C.glVertexAttribI3uiv(index, v);
    }

    public static void glVertexAttribI4uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") int[] v) {
        GL30C.glVertexAttribI4uiv(index, v);
    }

    public static void glVertexAttribI4sv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        GL30C.glVertexAttribI4sv(index, v);
    }

    public static void glVertexAttribI4usv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        GL30C.glVertexAttribI4usv(index, v);
    }

    public static void glGetVertexAttribIiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL30C.glGetVertexAttribIiv(index, pname, params);
    }

    public static void glGetVertexAttribIuiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") int[] params) {
        GL30C.glGetVertexAttribIuiv(index, pname, params);
    }

    public static void glUniform1uiv(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        GL30C.glUniform1uiv(location, value);
    }

    public static void glUniform2uiv(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        GL30C.glUniform2uiv(location, value);
    }

    public static void glUniform3uiv(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        GL30C.glUniform3uiv(location, value);
    }

    public static void glUniform4uiv(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        GL30C.glUniform4uiv(location, value);
    }

    public static void glGetUniformuiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint *") int[] params) {
        GL30C.glGetUniformuiv(program, location, params);
    }

    public static void glDeleteRenderbuffers(@NativeType(value="GLuint const *") int[] renderbuffers) {
        GL30C.glDeleteRenderbuffers(renderbuffers);
    }

    public static void glGenRenderbuffers(@NativeType(value="GLuint *") int[] renderbuffers) {
        GL30C.glGenRenderbuffers(renderbuffers);
    }

    public static void glGetRenderbufferParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL30C.glGetRenderbufferParameteriv(target, pname, params);
    }

    public static void glDeleteFramebuffers(@NativeType(value="GLuint const *") int[] framebuffers) {
        GL30C.glDeleteFramebuffers(framebuffers);
    }

    public static void glGenFramebuffers(@NativeType(value="GLuint *") int[] framebuffers) {
        GL30C.glGenFramebuffers(framebuffers);
    }

    public static void glGetFramebufferAttachmentParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int attachment, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL30C.glGetFramebufferAttachmentParameteriv(target, attachment, pname, params);
    }

    public static void glTexParameterIiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        GL30C.glTexParameterIiv(target, pname, params);
    }

    public static void glTexParameterIuiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint const *") int[] params) {
        GL30C.glTexParameterIuiv(target, pname, params);
    }

    public static void glGetTexParameterIiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL30C.glGetTexParameterIiv(target, pname, params);
    }

    public static void glGetTexParameterIuiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") int[] params) {
        GL30C.glGetTexParameterIuiv(target, pname, params);
    }

    public static void glGetIntegeri_v(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") int[] data) {
        GL30C.glGetIntegeri_v(target, index, data);
    }

    public static void glGetTransformFeedbackVarying(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLsizei *") int[] size, @NativeType(value="GLenum *") int[] type, @NativeType(value="GLchar *") ByteBuffer name) {
        GL30C.glGetTransformFeedbackVarying(program, index, length, size, type, name);
    }

    public static void glDeleteVertexArrays(@NativeType(value="GLuint const *") int[] arrays) {
        GL30C.glDeleteVertexArrays(arrays);
    }

    public static void glGenVertexArrays(@NativeType(value="GLuint *") int[] arrays) {
        GL30C.glGenVertexArrays(arrays);
    }

    static {
        GL.initialize();
    }
}

