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
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL42;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.opengl.GLDebugMessageCallbackI;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class GL43
extends GL42 {
    public static final int GL_NUM_SHADING_LANGUAGE_VERSIONS = 33513;
    public static final int GL_VERTEX_ATTRIB_ARRAY_LONG = 34638;
    public static final int GL_COMPRESSED_RGB8_ETC2 = 37492;
    public static final int GL_COMPRESSED_SRGB8_ETC2 = 37493;
    public static final int GL_COMPRESSED_RGB8_PUNCHTHROUGH_ALPHA1_ETC2 = 37494;
    public static final int GL_COMPRESSED_SRGB8_PUNCHTHROUGH_ALPHA1_ETC2 = 37495;
    public static final int GL_COMPRESSED_RGBA8_ETC2_EAC = 37496;
    public static final int GL_COMPRESSED_SRGB8_ALPHA8_ETC2_EAC = 37497;
    public static final int GL_COMPRESSED_R11_EAC = 37488;
    public static final int GL_COMPRESSED_SIGNED_R11_EAC = 37489;
    public static final int GL_COMPRESSED_RG11_EAC = 37490;
    public static final int GL_COMPRESSED_SIGNED_RG11_EAC = 37491;
    public static final int GL_PRIMITIVE_RESTART_FIXED_INDEX = 36201;
    public static final int GL_ANY_SAMPLES_PASSED_CONSERVATIVE = 36202;
    public static final int GL_MAX_ELEMENT_INDEX = 36203;
    public static final int GL_TEXTURE_IMMUTABLE_LEVELS = 33503;
    public static final int GL_COMPUTE_SHADER = 37305;
    public static final int GL_MAX_COMPUTE_UNIFORM_BLOCKS = 37307;
    public static final int GL_MAX_COMPUTE_TEXTURE_IMAGE_UNITS = 37308;
    public static final int GL_MAX_COMPUTE_IMAGE_UNIFORMS = 37309;
    public static final int GL_MAX_COMPUTE_SHARED_MEMORY_SIZE = 33378;
    public static final int GL_MAX_COMPUTE_UNIFORM_COMPONENTS = 33379;
    public static final int GL_MAX_COMPUTE_ATOMIC_COUNTER_BUFFERS = 33380;
    public static final int GL_MAX_COMPUTE_ATOMIC_COUNTERS = 33381;
    public static final int GL_MAX_COMBINED_COMPUTE_UNIFORM_COMPONENTS = 33382;
    public static final int GL_MAX_COMPUTE_WORK_GROUP_INVOCATIONS = 37099;
    public static final int GL_MAX_COMPUTE_WORK_GROUP_COUNT = 37310;
    public static final int GL_MAX_COMPUTE_WORK_GROUP_SIZE = 37311;
    public static final int GL_COMPUTE_WORK_GROUP_SIZE = 33383;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_COMPUTE_SHADER = 37100;
    public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_COMPUTE_SHADER = 37101;
    public static final int GL_DISPATCH_INDIRECT_BUFFER = 37102;
    public static final int GL_DISPATCH_INDIRECT_BUFFER_BINDING = 37103;
    public static final int GL_COMPUTE_SHADER_BIT = 32;
    public static final int GL_DEBUG_OUTPUT = 37600;
    public static final int GL_DEBUG_OUTPUT_SYNCHRONOUS = 33346;
    public static final int GL_CONTEXT_FLAG_DEBUG_BIT = 2;
    public static final int GL_MAX_DEBUG_MESSAGE_LENGTH = 37187;
    public static final int GL_MAX_DEBUG_LOGGED_MESSAGES = 37188;
    public static final int GL_DEBUG_LOGGED_MESSAGES = 37189;
    public static final int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH = 33347;
    public static final int GL_MAX_DEBUG_GROUP_STACK_DEPTH = 33388;
    public static final int GL_DEBUG_GROUP_STACK_DEPTH = 33389;
    public static final int GL_MAX_LABEL_LENGTH = 33512;
    public static final int GL_DEBUG_CALLBACK_FUNCTION = 33348;
    public static final int GL_DEBUG_CALLBACK_USER_PARAM = 33349;
    public static final int GL_DEBUG_SOURCE_API = 33350;
    public static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM = 33351;
    public static final int GL_DEBUG_SOURCE_SHADER_COMPILER = 33352;
    public static final int GL_DEBUG_SOURCE_THIRD_PARTY = 33353;
    public static final int GL_DEBUG_SOURCE_APPLICATION = 33354;
    public static final int GL_DEBUG_SOURCE_OTHER = 33355;
    public static final int GL_DEBUG_TYPE_ERROR = 33356;
    public static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR = 33357;
    public static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR = 33358;
    public static final int GL_DEBUG_TYPE_PORTABILITY = 33359;
    public static final int GL_DEBUG_TYPE_PERFORMANCE = 33360;
    public static final int GL_DEBUG_TYPE_OTHER = 33361;
    public static final int GL_DEBUG_TYPE_MARKER = 33384;
    public static final int GL_DEBUG_TYPE_PUSH_GROUP = 33385;
    public static final int GL_DEBUG_TYPE_POP_GROUP = 33386;
    public static final int GL_DEBUG_SEVERITY_HIGH = 37190;
    public static final int GL_DEBUG_SEVERITY_MEDIUM = 37191;
    public static final int GL_DEBUG_SEVERITY_LOW = 37192;
    public static final int GL_DEBUG_SEVERITY_NOTIFICATION = 33387;
    public static final int GL_BUFFER = 33504;
    public static final int GL_SHADER = 33505;
    public static final int GL_PROGRAM = 33506;
    public static final int GL_QUERY = 33507;
    public static final int GL_PROGRAM_PIPELINE = 33508;
    public static final int GL_SAMPLER = 33510;
    public static final int GL_DISPLAY_LIST = 33511;
    public static final int GL_MAX_UNIFORM_LOCATIONS = 33390;
    public static final int GL_FRAMEBUFFER_DEFAULT_WIDTH = 37648;
    public static final int GL_FRAMEBUFFER_DEFAULT_HEIGHT = 37649;
    public static final int GL_FRAMEBUFFER_DEFAULT_LAYERS = 37650;
    public static final int GL_FRAMEBUFFER_DEFAULT_SAMPLES = 37651;
    public static final int GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS = 37652;
    public static final int GL_MAX_FRAMEBUFFER_WIDTH = 37653;
    public static final int GL_MAX_FRAMEBUFFER_HEIGHT = 37654;
    public static final int GL_MAX_FRAMEBUFFER_LAYERS = 37655;
    public static final int GL_MAX_FRAMEBUFFER_SAMPLES = 37656;
    public static final int GL_INTERNALFORMAT_SUPPORTED = 33391;
    public static final int GL_INTERNALFORMAT_PREFERRED = 33392;
    public static final int GL_INTERNALFORMAT_RED_SIZE = 33393;
    public static final int GL_INTERNALFORMAT_GREEN_SIZE = 33394;
    public static final int GL_INTERNALFORMAT_BLUE_SIZE = 33395;
    public static final int GL_INTERNALFORMAT_ALPHA_SIZE = 33396;
    public static final int GL_INTERNALFORMAT_DEPTH_SIZE = 33397;
    public static final int GL_INTERNALFORMAT_STENCIL_SIZE = 33398;
    public static final int GL_INTERNALFORMAT_SHARED_SIZE = 33399;
    public static final int GL_INTERNALFORMAT_RED_TYPE = 33400;
    public static final int GL_INTERNALFORMAT_GREEN_TYPE = 33401;
    public static final int GL_INTERNALFORMAT_BLUE_TYPE = 33402;
    public static final int GL_INTERNALFORMAT_ALPHA_TYPE = 33403;
    public static final int GL_INTERNALFORMAT_DEPTH_TYPE = 33404;
    public static final int GL_INTERNALFORMAT_STENCIL_TYPE = 33405;
    public static final int GL_MAX_WIDTH = 33406;
    public static final int GL_MAX_HEIGHT = 33407;
    public static final int GL_MAX_DEPTH = 33408;
    public static final int GL_MAX_LAYERS = 33409;
    public static final int GL_MAX_COMBINED_DIMENSIONS = 33410;
    public static final int GL_COLOR_COMPONENTS = 33411;
    public static final int GL_DEPTH_COMPONENTS = 33412;
    public static final int GL_STENCIL_COMPONENTS = 33413;
    public static final int GL_COLOR_RENDERABLE = 33414;
    public static final int GL_DEPTH_RENDERABLE = 33415;
    public static final int GL_STENCIL_RENDERABLE = 33416;
    public static final int GL_FRAMEBUFFER_RENDERABLE = 33417;
    public static final int GL_FRAMEBUFFER_RENDERABLE_LAYERED = 33418;
    public static final int GL_FRAMEBUFFER_BLEND = 33419;
    public static final int GL_READ_PIXELS = 33420;
    public static final int GL_READ_PIXELS_FORMAT = 33421;
    public static final int GL_READ_PIXELS_TYPE = 33422;
    public static final int GL_TEXTURE_IMAGE_FORMAT = 33423;
    public static final int GL_TEXTURE_IMAGE_TYPE = 33424;
    public static final int GL_GET_TEXTURE_IMAGE_FORMAT = 33425;
    public static final int GL_GET_TEXTURE_IMAGE_TYPE = 33426;
    public static final int GL_MIPMAP = 33427;
    public static final int GL_MANUAL_GENERATE_MIPMAP = 33428;
    public static final int GL_AUTO_GENERATE_MIPMAP = 33429;
    public static final int GL_COLOR_ENCODING = 33430;
    public static final int GL_SRGB_READ = 33431;
    public static final int GL_SRGB_WRITE = 33432;
    public static final int GL_FILTER = 33434;
    public static final int GL_VERTEX_TEXTURE = 33435;
    public static final int GL_TESS_CONTROL_TEXTURE = 33436;
    public static final int GL_TESS_EVALUATION_TEXTURE = 33437;
    public static final int GL_GEOMETRY_TEXTURE = 33438;
    public static final int GL_FRAGMENT_TEXTURE = 33439;
    public static final int GL_COMPUTE_TEXTURE = 33440;
    public static final int GL_TEXTURE_SHADOW = 33441;
    public static final int GL_TEXTURE_GATHER = 33442;
    public static final int GL_TEXTURE_GATHER_SHADOW = 33443;
    public static final int GL_SHADER_IMAGE_LOAD = 33444;
    public static final int GL_SHADER_IMAGE_STORE = 33445;
    public static final int GL_SHADER_IMAGE_ATOMIC = 33446;
    public static final int GL_IMAGE_TEXEL_SIZE = 33447;
    public static final int GL_IMAGE_COMPATIBILITY_CLASS = 33448;
    public static final int GL_IMAGE_PIXEL_FORMAT = 33449;
    public static final int GL_IMAGE_PIXEL_TYPE = 33450;
    public static final int GL_SIMULTANEOUS_TEXTURE_AND_DEPTH_TEST = 33452;
    public static final int GL_SIMULTANEOUS_TEXTURE_AND_STENCIL_TEST = 33453;
    public static final int GL_SIMULTANEOUS_TEXTURE_AND_DEPTH_WRITE = 33454;
    public static final int GL_SIMULTANEOUS_TEXTURE_AND_STENCIL_WRITE = 33455;
    public static final int GL_TEXTURE_COMPRESSED_BLOCK_WIDTH = 33457;
    public static final int GL_TEXTURE_COMPRESSED_BLOCK_HEIGHT = 33458;
    public static final int GL_TEXTURE_COMPRESSED_BLOCK_SIZE = 33459;
    public static final int GL_CLEAR_BUFFER = 33460;
    public static final int GL_TEXTURE_VIEW = 33461;
    public static final int GL_VIEW_COMPATIBILITY_CLASS = 33462;
    public static final int GL_FULL_SUPPORT = 33463;
    public static final int GL_CAVEAT_SUPPORT = 33464;
    public static final int GL_IMAGE_CLASS_4_X_32 = 33465;
    public static final int GL_IMAGE_CLASS_2_X_32 = 33466;
    public static final int GL_IMAGE_CLASS_1_X_32 = 33467;
    public static final int GL_IMAGE_CLASS_4_X_16 = 33468;
    public static final int GL_IMAGE_CLASS_2_X_16 = 33469;
    public static final int GL_IMAGE_CLASS_1_X_16 = 33470;
    public static final int GL_IMAGE_CLASS_4_X_8 = 33471;
    public static final int GL_IMAGE_CLASS_2_X_8 = 33472;
    public static final int GL_IMAGE_CLASS_1_X_8 = 33473;
    public static final int GL_IMAGE_CLASS_11_11_10 = 33474;
    public static final int GL_IMAGE_CLASS_10_10_10_2 = 33475;
    public static final int GL_VIEW_CLASS_128_BITS = 33476;
    public static final int GL_VIEW_CLASS_96_BITS = 33477;
    public static final int GL_VIEW_CLASS_64_BITS = 33478;
    public static final int GL_VIEW_CLASS_48_BITS = 33479;
    public static final int GL_VIEW_CLASS_32_BITS = 33480;
    public static final int GL_VIEW_CLASS_24_BITS = 33481;
    public static final int GL_VIEW_CLASS_16_BITS = 33482;
    public static final int GL_VIEW_CLASS_8_BITS = 33483;
    public static final int GL_VIEW_CLASS_S3TC_DXT1_RGB = 33484;
    public static final int GL_VIEW_CLASS_S3TC_DXT1_RGBA = 33485;
    public static final int GL_VIEW_CLASS_S3TC_DXT3_RGBA = 33486;
    public static final int GL_VIEW_CLASS_S3TC_DXT5_RGBA = 33487;
    public static final int GL_VIEW_CLASS_RGTC1_RED = 33488;
    public static final int GL_VIEW_CLASS_RGTC2_RG = 33489;
    public static final int GL_VIEW_CLASS_BPTC_UNORM = 33490;
    public static final int GL_VIEW_CLASS_BPTC_FLOAT = 33491;
    public static final int GL_UNIFORM = 37601;
    public static final int GL_UNIFORM_BLOCK = 37602;
    public static final int GL_PROGRAM_INPUT = 37603;
    public static final int GL_PROGRAM_OUTPUT = 37604;
    public static final int GL_BUFFER_VARIABLE = 37605;
    public static final int GL_SHADER_STORAGE_BLOCK = 37606;
    public static final int GL_VERTEX_SUBROUTINE = 37608;
    public static final int GL_TESS_CONTROL_SUBROUTINE = 37609;
    public static final int GL_TESS_EVALUATION_SUBROUTINE = 37610;
    public static final int GL_GEOMETRY_SUBROUTINE = 37611;
    public static final int GL_FRAGMENT_SUBROUTINE = 37612;
    public static final int GL_COMPUTE_SUBROUTINE = 37613;
    public static final int GL_VERTEX_SUBROUTINE_UNIFORM = 37614;
    public static final int GL_TESS_CONTROL_SUBROUTINE_UNIFORM = 37615;
    public static final int GL_TESS_EVALUATION_SUBROUTINE_UNIFORM = 37616;
    public static final int GL_GEOMETRY_SUBROUTINE_UNIFORM = 37617;
    public static final int GL_FRAGMENT_SUBROUTINE_UNIFORM = 37618;
    public static final int GL_COMPUTE_SUBROUTINE_UNIFORM = 37619;
    public static final int GL_TRANSFORM_FEEDBACK_VARYING = 37620;
    public static final int GL_ACTIVE_RESOURCES = 37621;
    public static final int GL_MAX_NAME_LENGTH = 37622;
    public static final int GL_MAX_NUM_ACTIVE_VARIABLES = 37623;
    public static final int GL_MAX_NUM_COMPATIBLE_SUBROUTINES = 37624;
    public static final int GL_NAME_LENGTH = 37625;
    public static final int GL_TYPE = 37626;
    public static final int GL_ARRAY_SIZE = 37627;
    public static final int GL_OFFSET = 37628;
    public static final int GL_BLOCK_INDEX = 37629;
    public static final int GL_ARRAY_STRIDE = 37630;
    public static final int GL_MATRIX_STRIDE = 37631;
    public static final int GL_IS_ROW_MAJOR = 37632;
    public static final int GL_ATOMIC_COUNTER_BUFFER_INDEX = 37633;
    public static final int GL_BUFFER_BINDING = 37634;
    public static final int GL_BUFFER_DATA_SIZE = 37635;
    public static final int GL_NUM_ACTIVE_VARIABLES = 37636;
    public static final int GL_ACTIVE_VARIABLES = 37637;
    public static final int GL_REFERENCED_BY_VERTEX_SHADER = 37638;
    public static final int GL_REFERENCED_BY_TESS_CONTROL_SHADER = 37639;
    public static final int GL_REFERENCED_BY_TESS_EVALUATION_SHADER = 37640;
    public static final int GL_REFERENCED_BY_GEOMETRY_SHADER = 37641;
    public static final int GL_REFERENCED_BY_FRAGMENT_SHADER = 37642;
    public static final int GL_REFERENCED_BY_COMPUTE_SHADER = 37643;
    public static final int GL_TOP_LEVEL_ARRAY_SIZE = 37644;
    public static final int GL_TOP_LEVEL_ARRAY_STRIDE = 37645;
    public static final int GL_LOCATION = 37646;
    public static final int GL_LOCATION_INDEX = 37647;
    public static final int GL_IS_PER_PATCH = 37607;
    public static final int GL_SHADER_STORAGE_BUFFER = 37074;
    public static final int GL_SHADER_STORAGE_BUFFER_BINDING = 37075;
    public static final int GL_SHADER_STORAGE_BUFFER_START = 37076;
    public static final int GL_SHADER_STORAGE_BUFFER_SIZE = 37077;
    public static final int GL_MAX_VERTEX_SHADER_STORAGE_BLOCKS = 37078;
    public static final int GL_MAX_GEOMETRY_SHADER_STORAGE_BLOCKS = 37079;
    public static final int GL_MAX_TESS_CONTROL_SHADER_STORAGE_BLOCKS = 37080;
    public static final int GL_MAX_TESS_EVALUATION_SHADER_STORAGE_BLOCKS = 37081;
    public static final int GL_MAX_FRAGMENT_SHADER_STORAGE_BLOCKS = 37082;
    public static final int GL_MAX_COMPUTE_SHADER_STORAGE_BLOCKS = 37083;
    public static final int GL_MAX_COMBINED_SHADER_STORAGE_BLOCKS = 37084;
    public static final int GL_MAX_SHADER_STORAGE_BUFFER_BINDINGS = 37085;
    public static final int GL_MAX_SHADER_STORAGE_BLOCK_SIZE = 37086;
    public static final int GL_SHADER_STORAGE_BUFFER_OFFSET_ALIGNMENT = 37087;
    public static final int GL_SHADER_STORAGE_BARRIER_BIT = 8192;
    public static final int GL_MAX_COMBINED_SHADER_OUTPUT_RESOURCES = 36665;
    public static final int GL_DEPTH_STENCIL_TEXTURE_MODE = 37098;
    public static final int GL_TEXTURE_BUFFER_OFFSET = 37277;
    public static final int GL_TEXTURE_BUFFER_SIZE = 37278;
    public static final int GL_TEXTURE_BUFFER_OFFSET_ALIGNMENT = 37279;
    public static final int GL_TEXTURE_VIEW_MIN_LEVEL = 33499;
    public static final int GL_TEXTURE_VIEW_NUM_LEVELS = 33500;
    public static final int GL_TEXTURE_VIEW_MIN_LAYER = 33501;
    public static final int GL_TEXTURE_VIEW_NUM_LAYERS = 33502;
    public static final int GL_VERTEX_ATTRIB_BINDING = 33492;
    public static final int GL_VERTEX_ATTRIB_RELATIVE_OFFSET = 33493;
    public static final int GL_VERTEX_BINDING_DIVISOR = 33494;
    public static final int GL_VERTEX_BINDING_OFFSET = 33495;
    public static final int GL_VERTEX_BINDING_STRIDE = 33496;
    public static final int GL_VERTEX_BINDING_BUFFER = 36687;
    public static final int GL_MAX_VERTEX_ATTRIB_RELATIVE_OFFSET = 33497;
    public static final int GL_MAX_VERTEX_ATTRIB_BINDINGS = 33498;

    protected GL43() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glClearBufferData, caps.glClearBufferSubData, caps.glDispatchCompute, caps.glDispatchComputeIndirect, caps.glCopyImageSubData, caps.glDebugMessageControl, caps.glDebugMessageInsert, caps.glDebugMessageCallback, caps.glGetDebugMessageLog, caps.glPushDebugGroup, caps.glPopDebugGroup, caps.glObjectLabel, caps.glGetObjectLabel, caps.glObjectPtrLabel, caps.glGetObjectPtrLabel, caps.glFramebufferParameteri, caps.glGetFramebufferParameteriv, caps.glGetInternalformati64v, caps.glInvalidateTexSubImage, caps.glInvalidateTexImage, caps.glInvalidateBufferSubData, caps.glInvalidateBufferData, caps.glInvalidateFramebuffer, caps.glInvalidateSubFramebuffer, caps.glMultiDrawArraysIndirect, caps.glMultiDrawElementsIndirect, caps.glGetProgramInterfaceiv, caps.glGetProgramResourceIndex, caps.glGetProgramResourceName, caps.glGetProgramResourceiv, caps.glGetProgramResourceLocation, caps.glGetProgramResourceLocationIndex, caps.glShaderStorageBlockBinding, caps.glTexBufferRange, caps.glTexStorage2DMultisample, caps.glTexStorage3DMultisample, caps.glTextureView, caps.glBindVertexBuffer, caps.glVertexAttribFormat, caps.glVertexAttribIFormat, caps.glVertexAttribLFormat, caps.glVertexAttribBinding, caps.glVertexBindingDivisor);
    }

    public static void nglClearBufferData(int target, int internalformat, int format, int type, long data) {
        GL43C.nglClearBufferData(target, internalformat, format, type, data);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ByteBuffer data) {
        GL43C.glClearBufferData(target, internalformat, format, type, data);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ShortBuffer data) {
        GL43C.glClearBufferData(target, internalformat, format, type, data);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") IntBuffer data) {
        GL43C.glClearBufferData(target, internalformat, format, type, data);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") FloatBuffer data) {
        GL43C.glClearBufferData(target, internalformat, format, type, data);
    }

    public static void nglClearBufferSubData(int target, int internalformat, long offset, long size, int format, int type, long data) {
        GL43C.nglClearBufferSubData(target, internalformat, offset, size, format, type, data);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ByteBuffer data) {
        GL43C.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") ShortBuffer data) {
        GL43C.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") IntBuffer data) {
        GL43C.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") FloatBuffer data) {
        GL43C.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
    }

    public static void glDispatchCompute(@NativeType(value="GLuint") int num_groups_x, @NativeType(value="GLuint") int num_groups_y, @NativeType(value="GLuint") int num_groups_z) {
        GL43C.glDispatchCompute(num_groups_x, num_groups_y, num_groups_z);
    }

    public static void glDispatchComputeIndirect(@NativeType(value="GLintptr") long indirect) {
        GL43C.glDispatchComputeIndirect(indirect);
    }

    public static void glCopyImageSubData(@NativeType(value="GLuint") int srcName, @NativeType(value="GLenum") int srcTarget, @NativeType(value="GLint") int srcLevel, @NativeType(value="GLint") int srcX, @NativeType(value="GLint") int srcY, @NativeType(value="GLint") int srcZ, @NativeType(value="GLuint") int dstName, @NativeType(value="GLenum") int dstTarget, @NativeType(value="GLint") int dstLevel, @NativeType(value="GLint") int dstX, @NativeType(value="GLint") int dstY, @NativeType(value="GLint") int dstZ, @NativeType(value="GLsizei") int srcWidth, @NativeType(value="GLsizei") int srcHeight, @NativeType(value="GLsizei") int srcDepth) {
        GL43C.glCopyImageSubData(srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, srcWidth, srcHeight, srcDepth);
    }

    public static void nglDebugMessageControl(int source, int type, int severity, int count, long ids, boolean enabled) {
        GL43C.nglDebugMessageControl(source, type, severity, count, ids, enabled);
    }

    public static void glDebugMessageControl(@NativeType(value="GLenum") int source, @NativeType(value="GLenum") int type, @NativeType(value="GLenum") int severity, @Nullable @NativeType(value="GLuint const *") IntBuffer ids, @NativeType(value="GLboolean") boolean enabled) {
        GL43C.glDebugMessageControl(source, type, severity, ids, enabled);
    }

    public static void glDebugMessageControl(@NativeType(value="GLenum") int source, @NativeType(value="GLenum") int type, @NativeType(value="GLenum") int severity, @NativeType(value="GLuint const *") int id, @NativeType(value="GLboolean") boolean enabled) {
        GL43C.glDebugMessageControl(source, type, severity, id, enabled);
    }

    public static void nglDebugMessageInsert(int source, int type, int id, int severity, int length, long message) {
        GL43C.nglDebugMessageInsert(source, type, id, severity, length, message);
    }

    public static void glDebugMessageInsert(@NativeType(value="GLenum") int source, @NativeType(value="GLenum") int type, @NativeType(value="GLuint") int id, @NativeType(value="GLenum") int severity, @NativeType(value="GLchar const *") ByteBuffer message) {
        GL43C.glDebugMessageInsert(source, type, id, severity, message);
    }

    public static void glDebugMessageInsert(@NativeType(value="GLenum") int source, @NativeType(value="GLenum") int type, @NativeType(value="GLuint") int id, @NativeType(value="GLenum") int severity, @NativeType(value="GLchar const *") CharSequence message) {
        GL43C.glDebugMessageInsert(source, type, id, severity, message);
    }

    public static void nglDebugMessageCallback(long callback, long userParam) {
        GL43C.nglDebugMessageCallback(callback, userParam);
    }

    public static void glDebugMessageCallback(@Nullable @NativeType(value="GLDEBUGPROC") GLDebugMessageCallbackI callback, @NativeType(value="void const *") long userParam) {
        GL43C.glDebugMessageCallback(callback, userParam);
    }

    public static int nglGetDebugMessageLog(int count, int bufsize, long sources, long types, long ids, long severities, long lengths, long messageLog) {
        return GL43C.nglGetDebugMessageLog(count, bufsize, sources, types, ids, severities, lengths, messageLog);
    }

    @NativeType(value="GLuint")
    public static int glGetDebugMessageLog(@NativeType(value="GLuint") int count, @Nullable @NativeType(value="GLenum *") IntBuffer sources, @Nullable @NativeType(value="GLenum *") IntBuffer types, @Nullable @NativeType(value="GLuint *") IntBuffer ids, @Nullable @NativeType(value="GLenum *") IntBuffer severities, @Nullable @NativeType(value="GLsizei *") IntBuffer lengths, @Nullable @NativeType(value="GLchar *") ByteBuffer messageLog) {
        return GL43C.glGetDebugMessageLog(count, sources, types, ids, severities, lengths, messageLog);
    }

    public static void nglPushDebugGroup(int source, int id, int length, long message) {
        GL43C.nglPushDebugGroup(source, id, length, message);
    }

    public static void glPushDebugGroup(@NativeType(value="GLenum") int source, @NativeType(value="GLuint") int id, @NativeType(value="GLchar const *") ByteBuffer message) {
        GL43C.glPushDebugGroup(source, id, message);
    }

    public static void glPushDebugGroup(@NativeType(value="GLenum") int source, @NativeType(value="GLuint") int id, @NativeType(value="GLchar const *") CharSequence message) {
        GL43C.glPushDebugGroup(source, id, message);
    }

    public static void glPopDebugGroup() {
        GL43C.glPopDebugGroup();
    }

    public static void nglObjectLabel(int identifier, int name, int length, long label) {
        GL43C.nglObjectLabel(identifier, name, length, label);
    }

    public static void glObjectLabel(@NativeType(value="GLenum") int identifier, @NativeType(value="GLuint") int name, @NativeType(value="GLchar const *") ByteBuffer label) {
        GL43C.glObjectLabel(identifier, name, label);
    }

    public static void glObjectLabel(@NativeType(value="GLenum") int identifier, @NativeType(value="GLuint") int name, @NativeType(value="GLchar const *") CharSequence label) {
        GL43C.glObjectLabel(identifier, name, label);
    }

    public static void nglGetObjectLabel(int identifier, int name, int bufSize, long length, long label) {
        GL43C.nglGetObjectLabel(identifier, name, bufSize, length, label);
    }

    public static void glGetObjectLabel(@NativeType(value="GLenum") int identifier, @NativeType(value="GLuint") int name, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer label) {
        GL43C.glGetObjectLabel(identifier, name, length, label);
    }

    @NativeType(value="void")
    public static String glGetObjectLabel(@NativeType(value="GLenum") int identifier, @NativeType(value="GLuint") int name, @NativeType(value="GLsizei") int bufSize) {
        return GL43C.glGetObjectLabel(identifier, name, bufSize);
    }

    @NativeType(value="void")
    public static String glGetObjectLabel(@NativeType(value="GLenum") int identifier, @NativeType(value="GLuint") int name) {
        return GL43.glGetObjectLabel(identifier, name, GL11.glGetInteger(33512));
    }

    public static void nglObjectPtrLabel(long ptr, int length, long label) {
        GL43C.nglObjectPtrLabel(ptr, length, label);
    }

    public static void glObjectPtrLabel(@NativeType(value="void *") long ptr, @NativeType(value="GLchar const *") ByteBuffer label) {
        GL43C.glObjectPtrLabel(ptr, label);
    }

    public static void glObjectPtrLabel(@NativeType(value="void *") long ptr, @NativeType(value="GLchar const *") CharSequence label) {
        GL43C.glObjectPtrLabel(ptr, label);
    }

    public static void nglGetObjectPtrLabel(long ptr, int bufSize, long length, long label) {
        GL43C.nglGetObjectPtrLabel(ptr, bufSize, length, label);
    }

    public static void glGetObjectPtrLabel(@NativeType(value="void *") long ptr, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer label) {
        GL43C.glGetObjectPtrLabel(ptr, length, label);
    }

    @NativeType(value="void")
    public static String glGetObjectPtrLabel(@NativeType(value="void *") long ptr, @NativeType(value="GLsizei") int bufSize) {
        return GL43C.glGetObjectPtrLabel(ptr, bufSize);
    }

    @NativeType(value="void")
    public static String glGetObjectPtrLabel(@NativeType(value="void *") long ptr) {
        return GL43.glGetObjectPtrLabel(ptr, GL11.glGetInteger(33512));
    }

    public static void glFramebufferParameteri(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint") int param) {
        GL43C.glFramebufferParameteri(target, pname, param);
    }

    public static void nglGetFramebufferParameteriv(int target, int pname, long params) {
        GL43C.nglGetFramebufferParameteriv(target, pname, params);
    }

    public static void glGetFramebufferParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL43C.glGetFramebufferParameteriv(target, pname, params);
    }

    @NativeType(value="void")
    public static int glGetFramebufferParameteri(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        return GL43C.glGetFramebufferParameteri(target, pname);
    }

    public static void nglGetInternalformati64v(int target, int internalformat, int pname, int bufSize, long params) {
        GL43C.nglGetInternalformati64v(target, internalformat, pname, bufSize, params);
    }

    public static void glGetInternalformati64v(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") LongBuffer params) {
        GL43C.glGetInternalformati64v(target, internalformat, pname, params);
    }

    @NativeType(value="void")
    public static long glGetInternalformati64(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int pname) {
        return GL43C.glGetInternalformati64(target, internalformat, pname);
    }

    public static void glInvalidateTexSubImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLint") int xoffset, @NativeType(value="GLint") int yoffset, @NativeType(value="GLint") int zoffset, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth) {
        GL43C.glInvalidateTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth);
    }

    public static void glInvalidateTexImage(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level) {
        GL43C.glInvalidateTexImage(texture, level);
    }

    public static void glInvalidateBufferSubData(@NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long length) {
        GL43C.glInvalidateBufferSubData(buffer, offset, length);
    }

    public static void glInvalidateBufferData(@NativeType(value="GLuint") int buffer) {
        GL43C.glInvalidateBufferData(buffer);
    }

    public static void nglInvalidateFramebuffer(int target, int numAttachments, long attachments) {
        GL43C.nglInvalidateFramebuffer(target, numAttachments, attachments);
    }

    public static void glInvalidateFramebuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum const *") IntBuffer attachments) {
        GL43C.glInvalidateFramebuffer(target, attachments);
    }

    public static void glInvalidateFramebuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum const *") int attachment) {
        GL43C.glInvalidateFramebuffer(target, attachment);
    }

    public static void nglInvalidateSubFramebuffer(int target, int numAttachments, long attachments, int x, int y, int width, int height) {
        GL43C.nglInvalidateSubFramebuffer(target, numAttachments, attachments, x, y, width, height);
    }

    public static void glInvalidateSubFramebuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum const *") IntBuffer attachments, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height) {
        GL43C.glInvalidateSubFramebuffer(target, attachments, x, y, width, height);
    }

    public static void glInvalidateSubFramebuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum const *") int attachment, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height) {
        GL43C.glInvalidateSubFramebuffer(target, attachment, x, y, width, height);
    }

    public static void nglMultiDrawArraysIndirect(int mode, long indirect, int drawcount, int stride) {
        GL43C.nglMultiDrawArraysIndirect(mode, indirect, drawcount, stride);
    }

    public static void glMultiDrawArraysIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ByteBuffer indirect, @NativeType(value="GLsizei") int drawcount, @NativeType(value="GLsizei") int stride) {
        GL43C.glMultiDrawArraysIndirect(mode, indirect, drawcount, stride);
    }

    public static void glMultiDrawArraysIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") long indirect, @NativeType(value="GLsizei") int drawcount, @NativeType(value="GLsizei") int stride) {
        GL43C.glMultiDrawArraysIndirect(mode, indirect, drawcount, stride);
    }

    public static void glMultiDrawArraysIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") IntBuffer indirect, @NativeType(value="GLsizei") int drawcount, @NativeType(value="GLsizei") int stride) {
        GL43C.glMultiDrawArraysIndirect(mode, indirect, drawcount, stride);
    }

    public static void nglMultiDrawElementsIndirect(int mode, int type, long indirect, int drawcount, int stride) {
        GL43C.nglMultiDrawElementsIndirect(mode, type, indirect, drawcount, stride);
    }

    public static void glMultiDrawElementsIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer indirect, @NativeType(value="GLsizei") int drawcount, @NativeType(value="GLsizei") int stride) {
        GL43C.glMultiDrawElementsIndirect(mode, type, indirect, drawcount, stride);
    }

    public static void glMultiDrawElementsIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long indirect, @NativeType(value="GLsizei") int drawcount, @NativeType(value="GLsizei") int stride) {
        GL43C.glMultiDrawElementsIndirect(mode, type, indirect, drawcount, stride);
    }

    public static void glMultiDrawElementsIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") IntBuffer indirect, @NativeType(value="GLsizei") int drawcount, @NativeType(value="GLsizei") int stride) {
        GL43C.glMultiDrawElementsIndirect(mode, type, indirect, drawcount, stride);
    }

    public static void nglGetProgramInterfaceiv(int program, int programInterface, int pname, long params) {
        GL43C.nglGetProgramInterfaceiv(program, programInterface, pname, params);
    }

    public static void glGetProgramInterfaceiv(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL43C.glGetProgramInterfaceiv(program, programInterface, pname, params);
    }

    @NativeType(value="void")
    public static int glGetProgramInterfacei(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLenum") int pname) {
        return GL43C.glGetProgramInterfacei(program, programInterface, pname);
    }

    public static int nglGetProgramResourceIndex(int program, int programInterface, long name) {
        return GL43C.nglGetProgramResourceIndex(program, programInterface, name);
    }

    @NativeType(value="GLuint")
    public static int glGetProgramResourceIndex(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLchar const *") ByteBuffer name) {
        return GL43C.glGetProgramResourceIndex(program, programInterface, name);
    }

    @NativeType(value="GLuint")
    public static int glGetProgramResourceIndex(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLchar const *") CharSequence name) {
        return GL43C.glGetProgramResourceIndex(program, programInterface, name);
    }

    public static void nglGetProgramResourceName(int program, int programInterface, int index, int bufSize, long length, long name) {
        GL43C.nglGetProgramResourceName(program, programInterface, index, bufSize, length, name);
    }

    public static void glGetProgramResourceName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer name) {
        GL43C.glGetProgramResourceName(program, programInterface, index, length, name);
    }

    @NativeType(value="void")
    public static String glGetProgramResourceName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLuint") int index, @NativeType(value="GLsizei") int bufSize) {
        return GL43C.glGetProgramResourceName(program, programInterface, index, bufSize);
    }

    @NativeType(value="void")
    public static String glGetProgramResourceName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLuint") int index) {
        return GL43.glGetProgramResourceName(program, programInterface, index, GL43.glGetProgramInterfacei(program, programInterface, 37622));
    }

    public static void nglGetProgramResourceiv(int program, int programInterface, int index, int propCount, long props, int bufSize, long length, long params) {
        GL43C.nglGetProgramResourceiv(program, programInterface, index, propCount, props, bufSize, length, params);
    }

    public static void glGetProgramResourceiv(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLuint") int index, @NativeType(value="GLenum const *") IntBuffer props, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLint *") IntBuffer params) {
        GL43C.glGetProgramResourceiv(program, programInterface, index, props, length, params);
    }

    public static int nglGetProgramResourceLocation(int program, int programInterface, long name) {
        return GL43C.nglGetProgramResourceLocation(program, programInterface, name);
    }

    @NativeType(value="GLint")
    public static int glGetProgramResourceLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLchar const *") ByteBuffer name) {
        return GL43C.glGetProgramResourceLocation(program, programInterface, name);
    }

    @NativeType(value="GLint")
    public static int glGetProgramResourceLocation(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLchar const *") CharSequence name) {
        return GL43C.glGetProgramResourceLocation(program, programInterface, name);
    }

    public static int nglGetProgramResourceLocationIndex(int program, int programInterface, long name) {
        return GL43C.nglGetProgramResourceLocationIndex(program, programInterface, name);
    }

    @NativeType(value="GLint")
    public static int glGetProgramResourceLocationIndex(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLchar const *") ByteBuffer name) {
        return GL43C.glGetProgramResourceLocationIndex(program, programInterface, name);
    }

    @NativeType(value="GLint")
    public static int glGetProgramResourceLocationIndex(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLchar const *") CharSequence name) {
        return GL43C.glGetProgramResourceLocationIndex(program, programInterface, name);
    }

    public static void glShaderStorageBlockBinding(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int storageBlockIndex, @NativeType(value="GLuint") int storageBlockBinding) {
        GL43C.glShaderStorageBlockBinding(program, storageBlockIndex, storageBlockBinding);
    }

    public static void glTexBufferRange(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size) {
        GL43C.glTexBufferRange(target, internalformat, buffer, offset, size);
    }

    public static void glTexStorage2DMultisample(@NativeType(value="GLenum") int target, @NativeType(value="GLsizei") int samples, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLboolean") boolean fixedsamplelocations) {
        GL43C.glTexStorage2DMultisample(target, samples, internalformat, width, height, fixedsamplelocations);
    }

    public static void glTexStorage3DMultisample(@NativeType(value="GLenum") int target, @NativeType(value="GLsizei") int samples, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height, @NativeType(value="GLsizei") int depth, @NativeType(value="GLboolean") boolean fixedsamplelocations) {
        GL43C.glTexStorage3DMultisample(target, samples, internalformat, width, height, depth, fixedsamplelocations);
    }

    public static void glTextureView(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int origtexture, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLuint") int minlevel, @NativeType(value="GLuint") int numlevels, @NativeType(value="GLuint") int minlayer, @NativeType(value="GLuint") int numlayers) {
        GL43C.glTextureView(texture, target, origtexture, internalformat, minlevel, numlevels, minlayer, numlayers);
    }

    public static void glBindVertexBuffer(@NativeType(value="GLuint") int bindingindex, @NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizei") int stride) {
        GL43C.glBindVertexBuffer(bindingindex, buffer, offset, stride);
    }

    public static void glVertexAttribFormat(@NativeType(value="GLuint") int attribindex, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint") int relativeoffset) {
        GL43C.glVertexAttribFormat(attribindex, size, type, normalized, relativeoffset);
    }

    public static void glVertexAttribIFormat(@NativeType(value="GLuint") int attribindex, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLuint") int relativeoffset) {
        GL43C.glVertexAttribIFormat(attribindex, size, type, relativeoffset);
    }

    public static void glVertexAttribLFormat(@NativeType(value="GLuint") int attribindex, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLuint") int relativeoffset) {
        GL43C.glVertexAttribLFormat(attribindex, size, type, relativeoffset);
    }

    public static void glVertexAttribBinding(@NativeType(value="GLuint") int attribindex, @NativeType(value="GLuint") int bindingindex) {
        GL43C.glVertexAttribBinding(attribindex, bindingindex);
    }

    public static void glVertexBindingDivisor(@NativeType(value="GLuint") int bindingindex, @NativeType(value="GLuint") int divisor) {
        GL43C.glVertexBindingDivisor(bindingindex, divisor);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") short[] data) {
        GL43C.glClearBufferData(target, internalformat, format, type, data);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") int[] data) {
        GL43C.glClearBufferData(target, internalformat, format, type, data);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") float[] data) {
        GL43C.glClearBufferData(target, internalformat, format, type, data);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") short[] data) {
        GL43C.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") int[] data) {
        GL43C.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizeiptr") long size, @NativeType(value="GLenum") int format, @NativeType(value="GLenum") int type, @Nullable @NativeType(value="void const *") float[] data) {
        GL43C.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
    }

    public static void glDebugMessageControl(@NativeType(value="GLenum") int source, @NativeType(value="GLenum") int type, @NativeType(value="GLenum") int severity, @Nullable @NativeType(value="GLuint const *") int[] ids, @NativeType(value="GLboolean") boolean enabled) {
        GL43C.glDebugMessageControl(source, type, severity, ids, enabled);
    }

    @NativeType(value="GLuint")
    public static int glGetDebugMessageLog(@NativeType(value="GLuint") int count, @Nullable @NativeType(value="GLenum *") int[] sources, @Nullable @NativeType(value="GLenum *") int[] types, @Nullable @NativeType(value="GLuint *") int[] ids, @Nullable @NativeType(value="GLenum *") int[] severities, @Nullable @NativeType(value="GLsizei *") int[] lengths, @Nullable @NativeType(value="GLchar *") ByteBuffer messageLog) {
        return GL43C.glGetDebugMessageLog(count, sources, types, ids, severities, lengths, messageLog);
    }

    public static void glGetObjectLabel(@NativeType(value="GLenum") int identifier, @NativeType(value="GLuint") int name, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer label) {
        GL43C.glGetObjectLabel(identifier, name, length, label);
    }

    public static void glGetObjectPtrLabel(@NativeType(value="void *") long ptr, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer label) {
        GL43C.glGetObjectPtrLabel(ptr, length, label);
    }

    public static void glGetFramebufferParameteriv(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL43C.glGetFramebufferParameteriv(target, pname, params);
    }

    public static void glGetInternalformati64v(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") long[] params) {
        GL43C.glGetInternalformati64v(target, internalformat, pname, params);
    }

    public static void glInvalidateFramebuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum const *") int[] attachments) {
        GL43C.glInvalidateFramebuffer(target, attachments);
    }

    public static void glInvalidateSubFramebuffer(@NativeType(value="GLenum") int target, @NativeType(value="GLenum const *") int[] attachments, @NativeType(value="GLint") int x, @NativeType(value="GLint") int y, @NativeType(value="GLsizei") int width, @NativeType(value="GLsizei") int height) {
        GL43C.glInvalidateSubFramebuffer(target, attachments, x, y, width, height);
    }

    public static void glMultiDrawArraysIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") int[] indirect, @NativeType(value="GLsizei") int drawcount, @NativeType(value="GLsizei") int stride) {
        GL43C.glMultiDrawArraysIndirect(mode, indirect, drawcount, stride);
    }

    public static void glMultiDrawElementsIndirect(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") int[] indirect, @NativeType(value="GLsizei") int drawcount, @NativeType(value="GLsizei") int stride) {
        GL43C.glMultiDrawElementsIndirect(mode, type, indirect, drawcount, stride);
    }

    public static void glGetProgramInterfaceiv(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL43C.glGetProgramInterfaceiv(program, programInterface, pname, params);
    }

    public static void glGetProgramResourceName(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLuint") int index, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer name) {
        GL43C.glGetProgramResourceName(program, programInterface, index, length, name);
    }

    public static void glGetProgramResourceiv(@NativeType(value="GLuint") int program, @NativeType(value="GLenum") int programInterface, @NativeType(value="GLuint") int index, @NativeType(value="GLenum const *") int[] props, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLint *") int[] params) {
        GL43C.glGetProgramResourceiv(program, programInterface, index, props, length, params);
    }

    static {
        GL.initialize();
    }
}

