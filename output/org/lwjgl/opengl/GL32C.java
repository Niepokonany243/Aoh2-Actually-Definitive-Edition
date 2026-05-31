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
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL31C;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL32C
extends GL31C {
    public static final int GL_CONTEXT_PROFILE_MASK = 37158;
    public static final int GL_CONTEXT_CORE_PROFILE_BIT = 1;
    public static final int GL_CONTEXT_COMPATIBILITY_PROFILE_BIT = 2;
    public static final int GL_MAX_VERTEX_OUTPUT_COMPONENTS = 37154;
    public static final int GL_MAX_GEOMETRY_INPUT_COMPONENTS = 37155;
    public static final int GL_MAX_GEOMETRY_OUTPUT_COMPONENTS = 37156;
    public static final int GL_MAX_FRAGMENT_INPUT_COMPONENTS = 37157;
    public static final int GL_FIRST_VERTEX_CONVENTION = 36429;
    public static final int GL_LAST_VERTEX_CONVENTION = 36430;
    public static final int GL_PROVOKING_VERTEX = 36431;
    public static final int GL_QUADS_FOLLOW_PROVOKING_VERTEX_CONVENTION = 36428;
    public static final int GL_TEXTURE_CUBE_MAP_SEAMLESS = 34895;
    public static final int GL_SAMPLE_POSITION = 36432;
    public static final int GL_SAMPLE_MASK = 36433;
    public static final int GL_SAMPLE_MASK_VALUE = 36434;
    public static final int GL_TEXTURE_2D_MULTISAMPLE = 37120;
    public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE = 37121;
    public static final int GL_TEXTURE_2D_MULTISAMPLE_ARRAY = 37122;
    public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE_ARRAY = 37123;
    public static final int GL_MAX_SAMPLE_MASK_WORDS = 36441;
    public static final int GL_MAX_COLOR_TEXTURE_SAMPLES = 37134;
    public static final int GL_MAX_DEPTH_TEXTURE_SAMPLES = 37135;
    public static final int GL_MAX_INTEGER_SAMPLES = 37136;
    public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE = 37124;
    public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE_ARRAY = 37125;
    public static final int GL_TEXTURE_SAMPLES = 37126;
    public static final int GL_TEXTURE_FIXED_SAMPLE_LOCATIONS = 37127;
    public static final int GL_SAMPLER_2D_MULTISAMPLE = 37128;
    public static final int GL_INT_SAMPLER_2D_MULTISAMPLE = 37129;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE = 37130;
    public static final int GL_SAMPLER_2D_MULTISAMPLE_ARRAY = 37131;
    public static final int GL_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37132;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37133;
    public static final int GL_DEPTH_CLAMP = 34383;
    public static final int GL_GEOMETRY_SHADER = 36313;
    public static final int GL_GEOMETRY_VERTICES_OUT = 36314;
    public static final int GL_GEOMETRY_INPUT_TYPE = 36315;
    public static final int GL_GEOMETRY_OUTPUT_TYPE = 36316;
    public static final int GL_MAX_GEOMETRY_TEXTURE_IMAGE_UNITS = 35881;
    public static final int GL_MAX_GEOMETRY_UNIFORM_COMPONENTS = 36319;
    public static final int GL_MAX_GEOMETRY_OUTPUT_VERTICES = 36320;
    public static final int GL_MAX_GEOMETRY_TOTAL_OUTPUT_COMPONENTS = 36321;
    public static final int GL_LINES_ADJACENCY = 10;
    public static final int GL_LINE_STRIP_ADJACENCY = 11;
    public static final int GL_TRIANGLES_ADJACENCY = 12;
    public static final int GL_TRIANGLE_STRIP_ADJACENCY = 13;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS = 36264;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_LAYERED = 36263;
    public static final int GL_PROGRAM_POINT_SIZE = 34370;
    public static final int GL_MAX_SERVER_WAIT_TIMEOUT = 37137;
    public static final int GL_OBJECT_TYPE = 37138;
    public static final int GL_SYNC_CONDITION = 37139;
    public static final int GL_SYNC_STATUS = 37140;
    public static final int GL_SYNC_FLAGS = 37141;
    public static final int GL_SYNC_FENCE = 37142;
    public static final int GL_SYNC_GPU_COMMANDS_COMPLETE = 37143;
    public static final int GL_UNSIGNALED = 37144;
    public static final int GL_SIGNALED = 37145;
    public static final int GL_SYNC_FLUSH_COMMANDS_BIT = 1;
    public static final long GL_TIMEOUT_IGNORED = -1L;
    public static final int GL_ALREADY_SIGNALED = 37146;
    public static final int GL_TIMEOUT_EXPIRED = 37147;
    public static final int GL_CONDITION_SATISFIED = 37148;
    public static final int GL_WAIT_FAILED = 37149;

    protected GL32C() {
        throw new UnsupportedOperationException();
    }

    public static native void nglGetBufferParameteri64v(int var0, int var1, long var2);

    public static void glGetBufferParameteri64v(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") LongBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL32C.nglGetBufferParameteri64v(target, pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetBufferParameteri64(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer params = stack.callocLong(1);
            GL32C.nglGetBufferParameteri64v(target, pname, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglDrawElementsBaseVertex(int var0, int var1, int var2, long var3, int var5);

    public static void glDrawElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="GLsizei") int count, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long indices, @NativeType(value="GLint") int basevertex) {
        GL32C.nglDrawElementsBaseVertex(mode, count, type, indices, basevertex);
    }

    public static void glDrawElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer indices, @NativeType(value="GLint") int basevertex) {
        GL32C.nglDrawElementsBaseVertex(mode, indices.remaining() >> GLChecks.typeToByteShift(type), type, MemoryUtil.memAddress(indices), basevertex);
    }

    public static void glDrawElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ByteBuffer indices, @NativeType(value="GLint") int basevertex) {
        GL32C.nglDrawElementsBaseVertex(mode, indices.remaining(), 5121, MemoryUtil.memAddress(indices), basevertex);
    }

    public static void glDrawElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ShortBuffer indices, @NativeType(value="GLint") int basevertex) {
        GL32C.nglDrawElementsBaseVertex(mode, indices.remaining(), 5123, MemoryUtil.memAddress(indices), basevertex);
    }

    public static void glDrawElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") IntBuffer indices, @NativeType(value="GLint") int basevertex) {
        GL32C.nglDrawElementsBaseVertex(mode, indices.remaining(), 5125, MemoryUtil.memAddress(indices), basevertex);
    }

    public static native void nglDrawRangeElementsBaseVertex(int var0, int var1, int var2, int var3, int var4, long var5, int var7);

    public static void glDrawRangeElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="GLuint") int start, @NativeType(value="GLuint") int end, @NativeType(value="GLsizei") int count, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long indices, @NativeType(value="GLint") int basevertex) {
        GL32C.nglDrawRangeElementsBaseVertex(mode, start, end, count, type, indices, basevertex);
    }

    public static void glDrawRangeElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="GLuint") int start, @NativeType(value="GLuint") int end, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer indices, @NativeType(value="GLint") int basevertex) {
        GL32C.nglDrawRangeElementsBaseVertex(mode, start, end, indices.remaining() >> GLChecks.typeToByteShift(type), type, MemoryUtil.memAddress(indices), basevertex);
    }

    public static void glDrawRangeElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="GLuint") int start, @NativeType(value="GLuint") int end, @NativeType(value="void const *") ByteBuffer indices, @NativeType(value="GLint") int basevertex) {
        GL32C.nglDrawRangeElementsBaseVertex(mode, start, end, indices.remaining(), 5121, MemoryUtil.memAddress(indices), basevertex);
    }

    public static void glDrawRangeElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="GLuint") int start, @NativeType(value="GLuint") int end, @NativeType(value="void const *") ShortBuffer indices, @NativeType(value="GLint") int basevertex) {
        GL32C.nglDrawRangeElementsBaseVertex(mode, start, end, indices.remaining(), 5123, MemoryUtil.memAddress(indices), basevertex);
    }

    public static void glDrawRangeElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="GLuint") int start, @NativeType(value="GLuint") int end, @NativeType(value="void const *") IntBuffer indices, @NativeType(value="GLint") int basevertex) {
        GL32C.nglDrawRangeElementsBaseVertex(mode, start, end, indices.remaining(), 5125, MemoryUtil.memAddress(indices), basevertex);
    }

    public static native void nglDrawElementsInstancedBaseVertex(int var0, int var1, int var2, long var3, int var5, int var6);

    public static void glDrawElementsInstancedBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="GLsizei") int count, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long indices, @NativeType(value="GLsizei") int primcount, @NativeType(value="GLint") int basevertex) {
        GL32C.nglDrawElementsInstancedBaseVertex(mode, count, type, indices, primcount, basevertex);
    }

    public static void glDrawElementsInstancedBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer indices, @NativeType(value="GLsizei") int primcount, @NativeType(value="GLint") int basevertex) {
        GL32C.nglDrawElementsInstancedBaseVertex(mode, indices.remaining() >> GLChecks.typeToByteShift(type), type, MemoryUtil.memAddress(indices), primcount, basevertex);
    }

    public static void glDrawElementsInstancedBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ByteBuffer indices, @NativeType(value="GLsizei") int primcount, @NativeType(value="GLint") int basevertex) {
        GL32C.nglDrawElementsInstancedBaseVertex(mode, indices.remaining(), 5121, MemoryUtil.memAddress(indices), primcount, basevertex);
    }

    public static void glDrawElementsInstancedBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ShortBuffer indices, @NativeType(value="GLsizei") int primcount, @NativeType(value="GLint") int basevertex) {
        GL32C.nglDrawElementsInstancedBaseVertex(mode, indices.remaining(), 5123, MemoryUtil.memAddress(indices), primcount, basevertex);
    }

    public static void glDrawElementsInstancedBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") IntBuffer indices, @NativeType(value="GLsizei") int primcount, @NativeType(value="GLint") int basevertex) {
        GL32C.nglDrawElementsInstancedBaseVertex(mode, indices.remaining(), 5125, MemoryUtil.memAddress(indices), primcount, basevertex);
    }

    public static native void nglMultiDrawElementsBaseVertex(int var0, long var1, int var3, long var4, int var6, long var7);

    public static void glMultiDrawElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="GLsizei const *") IntBuffer count, @NativeType(value="GLenum") int type, @NativeType(value="void const **") PointerBuffer indices, @NativeType(value="GLint *") IntBuffer basevertex) {
        if (Checks.CHECKS) {
            Checks.check(indices, count.remaining());
            Checks.check((Buffer)basevertex, count.remaining());
        }
        GL32C.nglMultiDrawElementsBaseVertex(mode, MemoryUtil.memAddress(count), type, MemoryUtil.memAddress(indices), count.remaining(), MemoryUtil.memAddress(basevertex));
    }

    public static native void glProvokingVertex(@NativeType(value="GLenum") int var0);

    public static native void glTexImage2DMultisample(@NativeType(value="GLenum") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLboolean") boolean var5);

    public static native void glTexImage3DMultisample(@NativeType(value="GLenum") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLsizei") int var5, @NativeType(value="GLboolean") boolean var6);

    public static native void nglGetMultisamplefv(int var0, int var1, long var2);

    public static void glGetMultisamplefv(@NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat *") FloatBuffer val) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)val, 1);
        }
        GL32C.nglGetMultisamplefv(pname, index, MemoryUtil.memAddress(val));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetMultisamplef(@NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            FloatBuffer val = stack.callocFloat(1);
            GL32C.nglGetMultisamplefv(pname, index, MemoryUtil.memAddress(val));
            float f = val.get(0);
            return f;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glSampleMaski(@NativeType(value="GLuint") int var0, @NativeType(value="GLbitfield") int var1);

    public static native void glFramebufferTexture(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLint") int var3);

    @NativeType(value="GLsync")
    public static native long glFenceSync(@NativeType(value="GLenum") int var0, @NativeType(value="GLbitfield") int var1);

    public static native boolean nglIsSync(long var0);

    @NativeType(value="GLboolean")
    public static boolean glIsSync(@NativeType(value="GLsync") long sync) {
        if (Checks.CHECKS) {
            Checks.check(sync);
        }
        return GL32C.nglIsSync(sync);
    }

    public static native void nglDeleteSync(long var0);

    public static void glDeleteSync(@NativeType(value="GLsync") long sync) {
        if (Checks.CHECKS) {
            Checks.check(sync);
        }
        GL32C.nglDeleteSync(sync);
    }

    public static native int nglClientWaitSync(long var0, int var2, long var3);

    @NativeType(value="GLenum")
    public static int glClientWaitSync(@NativeType(value="GLsync") long sync, @NativeType(value="GLbitfield") int flags, @NativeType(value="GLuint64") long timeout) {
        if (Checks.CHECKS) {
            Checks.check(sync);
        }
        return GL32C.nglClientWaitSync(sync, flags, timeout);
    }

    public static native void nglWaitSync(long var0, int var2, long var3);

    public static void glWaitSync(@NativeType(value="GLsync") long sync, @NativeType(value="GLbitfield") int flags, @NativeType(value="GLuint64") long timeout) {
        if (Checks.CHECKS) {
            Checks.check(sync);
        }
        GL32C.nglWaitSync(sync, flags, timeout);
    }

    public static native void nglGetInteger64v(int var0, long var1);

    public static void glGetInteger64v(@NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") LongBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL32C.nglGetInteger64v(pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetInteger64(@NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer params = stack.callocLong(1);
            GL32C.nglGetInteger64v(pname, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetInteger64i_v(int var0, int var1, long var2);

    public static void glGetInteger64i_v(@NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index, @NativeType(value="GLint64 *") LongBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        GL32C.nglGetInteger64i_v(pname, index, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetInteger64i(@NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer params = stack.callocLong(1);
            GL32C.nglGetInteger64i_v(pname, index, MemoryUtil.memAddress(params));
            long l = params.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetSynciv(long var0, int var2, int var3, long var4, long var6);

    public static void glGetSynciv(@NativeType(value="GLsync") long sync, @NativeType(value="GLenum") int pname, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLint *") IntBuffer values) {
        if (Checks.CHECKS) {
            Checks.check(sync);
            Checks.checkSafe((Buffer)length, 1);
        }
        GL32C.nglGetSynciv(sync, pname, values.remaining(), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(values));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetSynci(@NativeType(value="GLsync") long sync, @NativeType(value="GLenum") int pname, @Nullable @NativeType(value="GLsizei *") IntBuffer length) {
        if (Checks.CHECKS) {
            Checks.check(sync);
            Checks.checkSafe((Buffer)length, 1);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer values = stack.callocInt(1);
            GL32C.nglGetSynciv(sync, pname, 1, MemoryUtil.memAddressSafe(length), MemoryUtil.memAddress(values));
            int n = values.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glGetBufferParameteri64v(@NativeType(value="GLenum") int target, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") long[] params) {
        long __functionAddress = GL.getICD().glGetBufferParameteri64v;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(target, pname, params, __functionAddress);
    }

    public static void glMultiDrawElementsBaseVertex(@NativeType(value="GLenum") int mode, @NativeType(value="GLsizei const *") int[] count, @NativeType(value="GLenum") int type, @NativeType(value="void const **") PointerBuffer indices, @NativeType(value="GLint *") int[] basevertex) {
        long __functionAddress = GL.getICD().glMultiDrawElementsBaseVertex;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(indices, count.length);
            Checks.check(basevertex, count.length);
        }
        JNI.callPPPV(mode, count, type, MemoryUtil.memAddress(indices), count.length, basevertex, __functionAddress);
    }

    public static void glGetMultisamplefv(@NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index, @NativeType(value="GLfloat *") float[] val) {
        long __functionAddress = GL.getICD().glGetMultisamplefv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(val, 1);
        }
        JNI.callPV(pname, index, val, __functionAddress);
    }

    public static void glGetInteger64v(@NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") long[] params) {
        long __functionAddress = GL.getICD().glGetInteger64v;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(pname, params, __functionAddress);
    }

    public static void glGetInteger64i_v(@NativeType(value="GLenum") int pname, @NativeType(value="GLuint") int index, @NativeType(value="GLint64 *") long[] params) {
        long __functionAddress = GL.getICD().glGetInteger64i_v;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPV(pname, index, params, __functionAddress);
    }

    public static void glGetSynciv(@NativeType(value="GLsync") long sync, @NativeType(value="GLenum") int pname, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLint *") int[] values) {
        long __functionAddress = GL.getICD().glGetSynciv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(sync);
            Checks.checkSafe(length, 1);
        }
        JNI.callPPPV(sync, pname, values.length, length, values, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

