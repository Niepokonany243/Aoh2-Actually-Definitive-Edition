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
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL21C;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL30C
extends GL21C {
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
    public static final int GL_CLAMP_READ_COLOR = 35100;
    public static final int GL_FIXED_ONLY = 35101;
    public static final int GL_DEPTH_COMPONENT32F = 36012;
    public static final int GL_DEPTH32F_STENCIL8 = 36013;
    public static final int GL_FLOAT_32_UNSIGNED_INT_24_8_REV = 36269;
    public static final int GL_TEXTURE_RED_TYPE = 35856;
    public static final int GL_TEXTURE_GREEN_TYPE = 35857;
    public static final int GL_TEXTURE_BLUE_TYPE = 35858;
    public static final int GL_TEXTURE_ALPHA_TYPE = 35859;
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

    protected GL30C() {
        throw new UnsupportedOperationException();
    }

    public static native long nglGetStringi(int var0, int var1);

    @Nullable
    @NativeType(value="GLubyte const *")
    public static String glGetStringi(@NativeType(value="GLenum") int name, @NativeType(value="GLuint") int index) {
        long __result = GL30C.nglGetStringi(name, index);
        return MemoryUtil.memUTF8Safe(__result);
    }

    public static native void nglClearBufferiv(int var0, int var1, long var2);

    public static void glClearBufferiv(@NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLint *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        GL30C.nglClearBufferiv(buffer, drawbuffer, MemoryUtil.memAddress(value));
    }

    public static native void nglClearBufferuiv(int var0, int var1, long var2);

    public static void glClearBufferuiv(@NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLint *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 4);
        }
        GL30C.nglClearBufferuiv(buffer, drawbuffer, MemoryUtil.memAddress(value));
    }

    public static native void nglClearBufferfv(int var0, int var1, long var2);

    public static void glClearBufferfv(@NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLfloat *") FloatBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        GL30C.nglClearBufferfv(buffer, drawbuffer, MemoryUtil.memAddress(value));
    }

    public static native void glClearBufferfi(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLint") int var3);

    public static native void glVertexAttribI1i(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1);

    public static native void glVertexAttribI2i(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2);

    public static native void glVertexAttribI3i(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3);

    public static native void glVertexAttribI4i(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4);

    public static native void glVertexAttribI1ui(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void glVertexAttribI2ui(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    public static native void glVertexAttribI3ui(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3);

    public static native void glVertexAttribI4ui(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4);

    public static native void nglVertexAttribI1iv(int var0, long var1);

    public static void glVertexAttribI1iv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        GL30C.nglVertexAttribI1iv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribI2iv(int var0, long var1);

    public static void glVertexAttribI2iv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        GL30C.nglVertexAttribI2iv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribI3iv(int var0, long var1);

    public static void glVertexAttribI3iv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL30C.nglVertexAttribI3iv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribI4iv(int var0, long var1);

    public static void glVertexAttribI4iv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL30C.nglVertexAttribI4iv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribI1uiv(int var0, long var1);

    public static void glVertexAttribI1uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 1);
        }
        GL30C.nglVertexAttribI1uiv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribI2uiv(int var0, long var1);

    public static void glVertexAttribI2uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 2);
        }
        GL30C.nglVertexAttribI2uiv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribI3uiv(int var0, long var1);

    public static void glVertexAttribI3uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 3);
        }
        GL30C.nglVertexAttribI3uiv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribI4uiv(int var0, long var1);

    public static void glVertexAttribI4uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") IntBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL30C.nglVertexAttribI4uiv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribI4bv(int var0, long var1);

    public static void glVertexAttribI4bv(@NativeType(value="GLuint") int index, @NativeType(value="GLbyte const *") ByteBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL30C.nglVertexAttribI4bv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribI4sv(int var0, long var1);

    public static void glVertexAttribI4sv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL30C.nglVertexAttribI4sv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribI4ubv(int var0, long var1);

    public static void glVertexAttribI4ubv(@NativeType(value="GLuint") int index, @NativeType(value="GLbyte const *") ByteBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL30C.nglVertexAttribI4ubv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribI4usv(int var0, long var1);

    public static void glVertexAttribI4usv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") ShortBuffer v) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)v, 4);
        }
        GL30C.nglVertexAttribI4usv(index, MemoryUtil.memAddress(v));
    }

    public static native void nglVertexAttribIPointer(int var0, int var1, int var2, int var3, long var4);

    public static void glVertexAttribIPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ByteBuffer pointer) {
        GL30C.nglVertexAttribIPointer(index, size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glVertexAttribIPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") long pointer) {
        GL30C.nglVertexAttribIPointer(index, size, type, stride, pointer);
    }

    public static void glVertexAttribIPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") ShortBuffer pointer) {
        GL30C.nglVertexAttribIPointer(index, size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static void glVertexAttribIPointer(@NativeType(value="GLuint") int index, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLsizei") int stride, @NativeType(value="void const *") IntBuffer pointer) {
        GL30C.nglVertexAttribIPointer(index, size, type, stride, MemoryUtil.memAddress(pointer));
    }

    public static native void nglGetVertexAttribIiv(int var0, int var1, long var2);

    public static void glGetVertexAttribIiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        GL30C.nglGetVertexAttribIiv(index, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetVertexAttribIi(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL30C.nglGetVertexAttribIiv(index, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetVertexAttribIuiv(int var0, int var1, long var2);

    public static void glGetVertexAttribIuiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 4);
        }
        GL30C.nglGetVertexAttribIuiv(index, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetVertexAttribIui(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL30C.nglGetVertexAttribIuiv(index, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glUniform1ui(@NativeType(value="GLint") int var0, @NativeType(value="GLuint") int var1);

    public static native void glUniform2ui(@NativeType(value="GLint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    public static native void glUniform3ui(@NativeType(value="GLint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLuint") int var3);

    public static native void glUniform4ui(@NativeType(value="GLint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLuint") int var3, @NativeType(value="GLuint") int var4);

    public static native void nglUniform1uiv(int var0, int var1, long var2);

    public static void glUniform1uiv(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        GL30C.nglUniform1uiv(location, value.remaining(), MemoryUtil.memAddress(value));
    }

    public static native void nglUniform2uiv(int var0, int var1, long var2);

    public static void glUniform2uiv(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        GL30C.nglUniform2uiv(location, value.remaining() >> 1, MemoryUtil.memAddress(value));
    }

    public static native void nglUniform3uiv(int var0, int var1, long var2);

    public static void glUniform3uiv(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        GL30C.nglUniform3uiv(location, value.remaining() / 3, MemoryUtil.memAddress(value));
    }

    public static native void nglUniform4uiv(int var0, int var1, long var2);

    public static void glUniform4uiv(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") IntBuffer value) {
        GL30C.nglUniform4uiv(location, value.remaining() >> 2, MemoryUtil.memAddress(value));
    }

    public static native void nglGetUniformuiv(int var0, int var1, long var2);

    public static void glGetUniformuiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL30C.nglGetUniformuiv(program, location, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetUniformui(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL30C.nglGetUniformuiv(program, location, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglBindFragDataLocation(int var0, int var1, long var2);

    public static void glBindFragDataLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int colorNumber, @NativeType(value="GLchar const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        GL30C.nglBindFragDataLocation(program, colorNumber, MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glBindFragDataLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int colorNumber, @NativeType(value="GLchar const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(name, true);
            long nameEncoded = stack.getPointerAddress();
            GL30C.nglBindFragDataLocation(program, colorNumber, nameEncoded);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native int nglGetFragDataLocation(int var0, long var1);

    @NativeType(value="GLint")
    public static int glGetFragDataLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT1(name);
        }
        return GL30C.nglGetFragDataLocation(program, MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLint")
    public static int glGetFragDataLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(name, true);
            long nameEncoded = stack.getPointerAddress();
            int n = GL30C.nglGetFragDataLocation(program, nameEncoded);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glBeginConditionalRender(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void glEndConditionalRender();

    public static native long nglMapBufferRange(int var0, long var1, long var3, int var5);

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapBufferRange(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long length, @NativeType(value="GLbitfield") int access) {
        long __result = GL30C.nglMapBufferRange(target, offset, length, access);
        return MemoryUtil.memByteBufferSafe(__result, (int)length);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapBufferRange(@NativeType(value="GLenum") int target, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long length, @NativeType(value="GLbitfield") int access, @Nullable ByteBuffer old_buffer) {
        long __result = GL30C.nglMapBufferRange(target, offset, length, access);
        return APIUtil.apiGetMappedBuffer(old_buffer, __result, (int)length);
    }

    public static native void glFlushMappedBufferRange(@NativeType(value="GLenum") int var0, @NativeType(value="GLintptr") long var1, @NativeType(value="GLsizeiptr") long var3);

    public static native void glClampColor(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1);

    @NativeType(value="GLboolean")
    public static native boolean glIsRenderbuffer(@NativeType(value="GLuint") int var0);

    public static native void glBindRenderbuffer(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglDeleteRenderbuffers(int var0, long var1);

    public static void glDeleteRenderbuffers(@NativeType(value="GLuint const *") IntBuffer renderbuffers) {
        GL30C.nglDeleteRenderbuffers(renderbuffers.remaining(), MemoryUtil.memAddress(renderbuffers));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDeleteRenderbuffers(@NativeType(value="GLuint const *") int renderbuffer) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer renderbuffers = stack.ints(renderbuffer);
            GL30C.nglDeleteRenderbuffers(1, MemoryUtil.memAddress(renderbuffers));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGenRenderbuffers(int var0, long var1);

    public static void glGenRenderbuffers(@NativeType(value="GLuint *") IntBuffer renderbuffers) {
        GL30C.nglGenRenderbuffers(renderbuffers.remaining(), MemoryUtil.memAddress(renderbuffers));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGenRenderbuffers() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer renderbuffers = stack.callocInt(1);
            GL30C.nglGenRenderbuffers(1, MemoryUtil.memAddress(renderbuffers));
            int n = renderbuffers.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glRenderbufferStorage(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLsizei") int var2, @NativeType(value="GLsizei") int var3);

    public static native void glRenderbufferStorageMultisample(@NativeType(value="GLenum") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4);

    public static native void nglGetRenderbufferParameteriv(int var0, int var1, long var2);

    public static void glGetRenderbufferParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL30C.nglGetRenderbufferParameteriv(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetRenderbufferParameteri(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL30C.nglGetRenderbufferParameteriv(target, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="GLboolean")
    public static native boolean glIsFramebuffer(@NativeType(value="GLuint") int var0);

    public static native void glBindFramebuffer(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglDeleteFramebuffers(int var0, long var1);

    public static void glDeleteFramebuffers(@NativeType(value="GLuint const *") IntBuffer framebuffers) {
        GL30C.nglDeleteFramebuffers(framebuffers.remaining(), MemoryUtil.memAddress(framebuffers));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDeleteFramebuffers(@NativeType(value="GLuint const *") int framebuffer) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer framebuffers = stack.ints(framebuffer);
            GL30C.nglDeleteFramebuffers(1, MemoryUtil.memAddress(framebuffers));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGenFramebuffers(int var0, long var1);

    public static void glGenFramebuffers(@NativeType(value="GLuint *") IntBuffer framebuffers) {
        GL30C.nglGenFramebuffers(framebuffers.remaining(), MemoryUtil.memAddress(framebuffers));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGenFramebuffers() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer framebuffers = stack.callocInt(1);
            GL30C.nglGenFramebuffers(1, MemoryUtil.memAddress(framebuffers));
            int n = framebuffers.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="GLenum")
    public static native int glCheckFramebufferStatus(@NativeType(value="GLenum") int var0);

    public static native void glFramebufferTexture1D(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLuint") int var3, @NativeType(value="GLint") int var4);

    public static native void glFramebufferTexture2D(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLuint") int var3, @NativeType(value="GLint") int var4);

    public static native void glFramebufferTexture3D(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLuint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5);

    public static native void glFramebufferTextureLayer(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4);

    public static native void glFramebufferRenderbuffer(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLuint") int var3);

    public static native void nglGetFramebufferAttachmentParameteriv(int var0, int var1, int var2, long var3);

    public static void glGetFramebufferAttachmentParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int attachment, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL30C.nglGetFramebufferAttachmentParameteriv(target, attachment, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetFramebufferAttachmentParameteri(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int attachment, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL30C.nglGetFramebufferAttachmentParameteriv(target, attachment, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glBlitFramebuffer(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLint") int var6, @NativeType(value="GLint") int var7, @NativeType(value="GLbitfield") int var8, @NativeType(value="GLenum") int var9);

    public static native void glGenerateMipmap(@NativeType(value="GLenum") int var0);

    public static native void nglTexParameterIiv(int var0, int var1, long var2);

    public static void glTexParameterIiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL30C.nglTexParameterIiv(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glTexParameterIi(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int param) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.ints(param);
            GL30C.nglTexParameterIiv(target, pname, MemoryUtil.memAddress(params));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglTexParameterIuiv(int var0, int var1, long var2);

    public static void glTexParameterIuiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint const *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL30C.nglTexParameterIuiv(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glTexParameterIui(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint const *") int param) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.ints(param);
            GL30C.nglTexParameterIuiv(target, pname, MemoryUtil.memAddress(params));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetTexParameterIiv(int var0, int var1, long var2);

    public static void glGetTexParameterIiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL30C.nglGetTexParameterIiv(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTexParameterIi(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL30C.nglGetTexParameterIiv(target, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetTexParameterIuiv(int var0, int var1, long var2);

    public static void glGetTexParameterIuiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL30C.nglGetTexParameterIuiv(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTexParameterIui(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer params = stack.callocInt(1);
            GL30C.nglGetTexParameterIuiv(target, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glColorMaski(@NativeType(value="GLuint") int var0, @NativeType(value="GLboolean") boolean var1, @NativeType(value="GLboolean") boolean var2, @NativeType(value="GLboolean") boolean var3, @NativeType(value="GLboolean") boolean var4);

    public static native void nglGetBooleani_v(int var0, int var1, long var2);

    public static void glGetBooleani_v(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLboolean *") ByteBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 1);
        }
        GL30C.nglGetBooleani_v(target, index, MemoryUtil.memAddress(data));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static boolean glGetBooleani(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            ByteBuffer data = stack.calloc(1);
            GL30C.nglGetBooleani_v(target, index, MemoryUtil.memAddress(data));
            boolean bl = data.get(0) != 0;
            return bl;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetIntegeri_v(int var0, int var1, long var2);

    public static void glGetIntegeri_v(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") IntBuffer data) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)data, 1);
        }
        GL30C.nglGetIntegeri_v(target, index, MemoryUtil.memAddress(data));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetIntegeri(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer data = stack.callocInt(1);
            GL30C.nglGetIntegeri_v(target, index, MemoryUtil.memAddress(data));
            int n = data.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glEnablei(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glDisablei(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    @NativeType(value="GLboolean")
    public static native boolean glIsEnabledi(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glBindBufferRange(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLintptr") long var3, @NativeType(value="GLsizeiptr") long var5);

    public static native void glBindBufferBase(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    public static native void glBeginTransformFeedback(@NativeType(value="GLenum") int var0);

    public static native void glEndTransformFeedback();

    public static native void nglTransformFeedbackVaryings(int var0, int var1, long var2, int var4);

    public static void glTransformFeedbackVaryings(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const **") PointerBuffer varyings, @NativeType(value="GLenum") int bufferMode) {
        GL30C.nglTransformFeedbackVaryings(program, varyings.remaining(), MemoryUtil.memAddress(varyings), bufferMode);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glTransformFeedbackVaryings(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const **") CharSequence[] varyings, @NativeType(value="GLenum") int bufferMode) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            long varyingsAddress = APIUtil.apiArray(stack, MemoryUtil::memASCII, varyings);
            GL30C.nglTransformFeedbackVaryings(program, varyings.length, varyingsAddress, bufferMode);
            APIUtil.apiArrayFree(varyingsAddress, varyings.length);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glTransformFeedbackVaryings(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const **") CharSequence varying, @NativeType(value="GLenum") int bufferMode) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            long varyingsAddress = APIUtil.apiArray(stack, MemoryUtil::memASCII, varying);
            GL30C.nglTransformFeedbackVaryings(program, 1, varyingsAddress, bufferMode);
            APIUtil.apiArrayFree(varyingsAddress, 1);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetTransformFeedbackVarying(int var0, int var1, int var2, long var3, long var5, long var7, long var9);

    public static void glGetTransformFeedbackVarying(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLsizei *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type, @NativeType(value="GLchar *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, 1);
            Checks.check((Buffer)size, 1);
            Checks.check((Buffer)type, 1);
        }
        GL30C.nglGetTransformFeedbackVarying(program, index, name.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetTransformFeedbackVarying(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @NativeType(value="GLsizei") int bufSize, @NativeType(value="GLsizei *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)size, 1);
            Checks.check((Buffer)type, 1);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer length = stack.ints(0);
            ByteBuffer name = stack.malloc(bufSize);
            GL30C.nglGetTransformFeedbackVarying(program, index, bufSize, MemoryUtil.memAddress(length), MemoryUtil.memAddress(size), MemoryUtil.memAddress(type), MemoryUtil.memAddress(name));
            String string = MemoryUtil.memASCII(name, length.get(0));
            return string;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="void")
    public static String glGetTransformFeedbackVarying(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @NativeType(value="GLsizei *") IntBuffer size, @NativeType(value="GLenum *") IntBuffer type) {
        return GL30C.glGetTransformFeedbackVarying(program, index, GL20.glGetProgrami(program, 35958), size, type);
    }

    public static native void glBindVertexArray(@NativeType(value="GLuint") int var0);

    public static native void nglDeleteVertexArrays(int var0, long var1);

    public static void glDeleteVertexArrays(@NativeType(value="GLuint const *") IntBuffer arrays) {
        GL30C.nglDeleteVertexArrays(arrays.remaining(), MemoryUtil.memAddress(arrays));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDeleteVertexArrays(@NativeType(value="GLuint const *") int array) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer arrays = stack.ints(array);
            GL30C.nglDeleteVertexArrays(1, MemoryUtil.memAddress(arrays));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGenVertexArrays(int var0, long var1);

    public static void glGenVertexArrays(@NativeType(value="GLuint *") IntBuffer arrays) {
        GL30C.nglGenVertexArrays(arrays.remaining(), MemoryUtil.memAddress(arrays));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGenVertexArrays() {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer arrays = stack.callocInt(1);
            GL30C.nglGenVertexArrays(1, MemoryUtil.memAddress(arrays));
            int n = arrays.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="GLboolean")
    public static native boolean glIsVertexArray(@NativeType(value="GLuint") int var0);

    public static void glClearBufferiv(@NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLint *") int[] value) {
        long __functionAddress = GL.getICD().glClearBufferiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(value, 1);
        }
        JNI.callPV(buffer, drawbuffer, value, __functionAddress);
    }

    public static void glClearBufferuiv(@NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLint *") int[] value) {
        long __functionAddress = GL.getICD().glClearBufferuiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(value, 4);
        }
        JNI.callPV(buffer, drawbuffer, value, __functionAddress);
    }

    public static void glClearBufferfv(@NativeType(value="GLenum") int buffer, @NativeType(value="GLint") int drawbuffer, @NativeType(value="GLfloat *") float[] value) {
        long __functionAddress = GL.getICD().glClearBufferfv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(value, 1);
        }
        JNI.callPV(buffer, drawbuffer, value, __functionAddress);
    }

    public static void glVertexAttribI1iv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttribI1iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribI2iv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttribI2iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribI3iv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttribI3iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribI4iv(@NativeType(value="GLuint") int index, @NativeType(value="GLint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttribI4iv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribI1uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttribI1uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 1);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribI2uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttribI2uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 2);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribI3uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttribI3uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 3);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribI4uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLuint const *") int[] v) {
        long __functionAddress = GL.getICD().glVertexAttribI4uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribI4sv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttribI4sv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glVertexAttribI4usv(@NativeType(value="GLuint") int index, @NativeType(value="GLshort const *") short[] v) {
        long __functionAddress = GL.getICD().glVertexAttribI4usv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(v, 4);
        }
        JNI.callPV(index, v, __functionAddress);
    }

    public static void glGetVertexAttribIiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetVertexAttribIiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(index, pname, params, __functionAddress);
    }

    public static void glGetVertexAttribIuiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") int[] params) {
        long __functionAddress = GL.getICD().glGetVertexAttribIuiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 4);
        }
        JNI.callPV(index, pname, params, __functionAddress);
    }

    public static void glUniform1uiv(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glUniform1uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length, value, __functionAddress);
    }

    public static void glUniform2uiv(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glUniform2uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 1, value, __functionAddress);
    }

    public static void glUniform3uiv(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glUniform3uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length / 3, value, __functionAddress);
    }

    public static void glUniform4uiv(@NativeType(value="GLint") int location, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glUniform4uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(location, value.length >> 2, value, __functionAddress);
    }

    public static void glGetUniformuiv(@NativeType(value="GLuint") int program, @NativeType(value="GLint") int location, @NativeType(value="GLuint *") int[] params) {
        long __functionAddress = GL.getICD().glGetUniformuiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(program, location, params, __functionAddress);
    }

    public static void glDeleteRenderbuffers(@NativeType(value="GLuint const *") int[] renderbuffers) {
        long __functionAddress = GL.getICD().glDeleteRenderbuffers;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(renderbuffers.length, renderbuffers, __functionAddress);
    }

    public static void glGenRenderbuffers(@NativeType(value="GLuint *") int[] renderbuffers) {
        long __functionAddress = GL.getICD().glGenRenderbuffers;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(renderbuffers.length, renderbuffers, __functionAddress);
    }

    public static void glGetRenderbufferParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetRenderbufferParameteriv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glDeleteFramebuffers(@NativeType(value="GLuint const *") int[] framebuffers) {
        long __functionAddress = GL.getICD().glDeleteFramebuffers;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(framebuffers.length, framebuffers, __functionAddress);
    }

    public static void glGenFramebuffers(@NativeType(value="GLuint *") int[] framebuffers) {
        long __functionAddress = GL.getICD().glGenFramebuffers;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(framebuffers.length, framebuffers, __functionAddress);
    }

    public static void glGetFramebufferAttachmentParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int attachment, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetFramebufferAttachmentParameteriv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, attachment, pname, params, __functionAddress);
    }

    public static void glTexParameterIiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        long __functionAddress = GL.getICD().glTexParameterIiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glTexParameterIuiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint const *") int[] params) {
        long __functionAddress = GL.getICD().glTexParameterIuiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glGetTexParameterIiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetTexParameterIiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glGetTexParameterIuiv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") int[] params) {
        long __functionAddress = GL.getICD().glGetTexParameterIuiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glGetIntegeri_v(@NativeType(value="GLenum") int target, @NativeType(value="GLuint") int index, @NativeType(value="GLint *") int[] data) {
        long __functionAddress = GL.getICD().glGetIntegeri_v;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(data, 1);
        }
        JNI.callPV(target, index, data, __functionAddress);
    }

    public static void glGetTransformFeedbackVarying(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLsizei *") int[] size, @NativeType(value="GLenum *") int[] type, @NativeType(value="GLchar *") ByteBuffer name) {
        long __functionAddress = GL.getICD().glGetTransformFeedbackVarying;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, 1);
            Checks.check(size, 1);
            Checks.check(type, 1);
        }
        JNI.callPPPPV(program, index, name.remaining(), length, size, type, MemoryUtil.memAddress(name), __functionAddress);
    }

    public static void glDeleteVertexArrays(@NativeType(value="GLuint const *") int[] arrays) {
        long __functionAddress = GL.getICD().glDeleteVertexArrays;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(arrays.length, arrays, __functionAddress);
    }

    public static void glGenVertexArrays(@NativeType(value="GLuint *") int[] arrays) {
        long __functionAddress = GL.getICD().glGenVertexArrays;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(arrays.length, arrays, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

