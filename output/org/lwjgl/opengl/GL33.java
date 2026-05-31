/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL32;
import org.lwjgl.opengl.GL33C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL33
extends GL32 {
    public static final int GL_SRC1_COLOR = 35065;
    public static final int GL_ONE_MINUS_SRC1_COLOR = 35066;
    public static final int GL_ONE_MINUS_SRC1_ALPHA = 35067;
    public static final int GL_MAX_DUAL_SOURCE_DRAW_BUFFERS = 35068;
    public static final int GL_ANY_SAMPLES_PASSED = 35887;
    public static final int GL_SAMPLER_BINDING = 35097;
    public static final int GL_RGB10_A2UI = 36975;
    public static final int GL_TEXTURE_SWIZZLE_R = 36418;
    public static final int GL_TEXTURE_SWIZZLE_G = 36419;
    public static final int GL_TEXTURE_SWIZZLE_B = 36420;
    public static final int GL_TEXTURE_SWIZZLE_A = 36421;
    public static final int GL_TEXTURE_SWIZZLE_RGBA = 36422;
    public static final int GL_TIME_ELAPSED = 35007;
    public static final int GL_TIMESTAMP = 36392;
    public static final int GL_VERTEX_ATTRIB_ARRAY_DIVISOR = 35070;
    public static final int GL_INT_2_10_10_10_REV = 36255;

    protected GL33() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, boolean fc) {
        return (fc || Checks.checkFunctions(caps.glVertexP2ui, caps.glVertexP3ui, caps.glVertexP4ui, caps.glVertexP2uiv, caps.glVertexP3uiv, caps.glVertexP4uiv, caps.glTexCoordP1ui, caps.glTexCoordP2ui, caps.glTexCoordP3ui, caps.glTexCoordP4ui, caps.glTexCoordP1uiv, caps.glTexCoordP2uiv, caps.glTexCoordP3uiv, caps.glTexCoordP4uiv, caps.glMultiTexCoordP1ui, caps.glMultiTexCoordP2ui, caps.glMultiTexCoordP3ui, caps.glMultiTexCoordP4ui, caps.glMultiTexCoordP1uiv, caps.glMultiTexCoordP2uiv, caps.glMultiTexCoordP3uiv, caps.glMultiTexCoordP4uiv, caps.glNormalP3ui, caps.glNormalP3uiv, caps.glColorP3ui, caps.glColorP4ui, caps.glColorP3uiv, caps.glColorP4uiv, caps.glSecondaryColorP3ui, caps.glSecondaryColorP3uiv)) && Checks.checkFunctions(caps.glBindFragDataLocationIndexed, caps.glGetFragDataIndex, caps.glGenSamplers, caps.glDeleteSamplers, caps.glIsSampler, caps.glBindSampler, caps.glSamplerParameteri, caps.glSamplerParameterf, caps.glSamplerParameteriv, caps.glSamplerParameterfv, caps.glSamplerParameterIiv, caps.glSamplerParameterIuiv, caps.glGetSamplerParameteriv, caps.glGetSamplerParameterfv, caps.glGetSamplerParameterIiv, caps.glGetSamplerParameterIuiv, caps.glQueryCounter, caps.glGetQueryObjecti64v, caps.glGetQueryObjectui64v, caps.glVertexAttribDivisor, caps.glVertexAttribP1ui, caps.glVertexAttribP2ui, caps.glVertexAttribP3ui, caps.glVertexAttribP4ui, caps.glVertexAttribP1uiv, caps.glVertexAttribP2uiv, caps.glVertexAttribP3uiv, caps.glVertexAttribP4uiv);
    }

    public static void nglBindFragDataLocationIndexed(int program, int colorNumber, int index, long name) {
        GL33C.nglBindFragDataLocationIndexed(program, colorNumber, index, name);
    }

    public static void glBindFragDataLocationIndexed(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int colorNumber, @NativeType(value="GLuint") int index, @NativeType(value="GLchar const *") ByteBuffer name) {
        GL33C.glBindFragDataLocationIndexed(program, colorNumber, index, name);
    }

    public static void glBindFragDataLocationIndexed(@NativeType(value="GLuint") int program, @NativeType(value="GLuint") int colorNumber, @NativeType(value="GLuint") int index, @NativeType(value="GLchar const *") CharSequence name) {
        GL33C.glBindFragDataLocationIndexed(program, colorNumber, index, name);
    }

    public static int nglGetFragDataIndex(int program, long name) {
        return GL33C.nglGetFragDataIndex(program, name);
    }

    @NativeType(value="GLint")
    public static int glGetFragDataIndex(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") ByteBuffer name) {
        return GL33C.glGetFragDataIndex(program, name);
    }

    @NativeType(value="GLint")
    public static int glGetFragDataIndex(@NativeType(value="GLuint") int program, @NativeType(value="GLchar const *") CharSequence name) {
        return GL33C.glGetFragDataIndex(program, name);
    }

    public static void nglGenSamplers(int count, long samplers) {
        GL33C.nglGenSamplers(count, samplers);
    }

    public static void glGenSamplers(@NativeType(value="GLuint *") IntBuffer samplers) {
        GL33C.glGenSamplers(samplers);
    }

    @NativeType(value="void")
    public static int glGenSamplers() {
        return GL33C.glGenSamplers();
    }

    public static void nglDeleteSamplers(int count, long samplers) {
        GL33C.nglDeleteSamplers(count, samplers);
    }

    public static void glDeleteSamplers(@NativeType(value="GLuint const *") IntBuffer samplers) {
        GL33C.glDeleteSamplers(samplers);
    }

    public static void glDeleteSamplers(@NativeType(value="GLuint const *") int sampler) {
        GL33C.glDeleteSamplers(sampler);
    }

    @NativeType(value="GLboolean")
    public static boolean glIsSampler(@NativeType(value="GLuint") int sampler) {
        return GL33C.glIsSampler(sampler);
    }

    public static void glBindSampler(@NativeType(value="GLuint") int unit, @NativeType(value="GLuint") int sampler) {
        GL33C.glBindSampler(unit, sampler);
    }

    public static void glSamplerParameteri(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint") int param) {
        GL33C.glSamplerParameteri(sampler, pname, param);
    }

    public static void glSamplerParameterf(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat") float param) {
        GL33C.glSamplerParameterf(sampler, pname, param);
    }

    public static void nglSamplerParameteriv(int sampler, int pname, long params) {
        GL33C.nglSamplerParameteriv(sampler, pname, params);
    }

    public static void glSamplerParameteriv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        GL33C.glSamplerParameteriv(sampler, pname, params);
    }

    public static void nglSamplerParameterfv(int sampler, int pname, long params) {
        GL33C.nglSamplerParameterfv(sampler, pname, params);
    }

    public static void glSamplerParameterfv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") FloatBuffer params) {
        GL33C.glSamplerParameterfv(sampler, pname, params);
    }

    public static void nglSamplerParameterIiv(int sampler, int pname, long params) {
        GL33C.nglSamplerParameterIiv(sampler, pname, params);
    }

    public static void glSamplerParameterIiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") IntBuffer params) {
        GL33C.glSamplerParameterIiv(sampler, pname, params);
    }

    public static void nglSamplerParameterIuiv(int sampler, int pname, long params) {
        GL33C.nglSamplerParameterIuiv(sampler, pname, params);
    }

    public static void glSamplerParameterIuiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint const *") IntBuffer params) {
        GL33C.glSamplerParameterIuiv(sampler, pname, params);
    }

    public static void nglGetSamplerParameteriv(int sampler, int pname, long params) {
        GL33C.nglGetSamplerParameteriv(sampler, pname, params);
    }

    public static void glGetSamplerParameteriv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL33C.glGetSamplerParameteriv(sampler, pname, params);
    }

    @NativeType(value="void")
    public static int glGetSamplerParameteri(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname) {
        return GL33C.glGetSamplerParameteri(sampler, pname);
    }

    public static void nglGetSamplerParameterfv(int sampler, int pname, long params) {
        GL33C.nglGetSamplerParameterfv(sampler, pname, params);
    }

    public static void glGetSamplerParameterfv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") FloatBuffer params) {
        GL33C.glGetSamplerParameterfv(sampler, pname, params);
    }

    @NativeType(value="void")
    public static float glGetSamplerParameterf(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname) {
        return GL33C.glGetSamplerParameterf(sampler, pname);
    }

    public static void nglGetSamplerParameterIiv(int sampler, int pname, long params) {
        GL33C.nglGetSamplerParameterIiv(sampler, pname, params);
    }

    public static void glGetSamplerParameterIiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        GL33C.glGetSamplerParameterIiv(sampler, pname, params);
    }

    @NativeType(value="void")
    public static int glGetSamplerParameterIi(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname) {
        return GL33C.glGetSamplerParameterIi(sampler, pname);
    }

    public static void nglGetSamplerParameterIuiv(int sampler, int pname, long params) {
        GL33C.nglGetSamplerParameterIuiv(sampler, pname, params);
    }

    public static void glGetSamplerParameterIuiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") IntBuffer params) {
        GL33C.glGetSamplerParameterIuiv(sampler, pname, params);
    }

    @NativeType(value="void")
    public static int glGetSamplerParameterIui(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname) {
        return GL33C.glGetSamplerParameterIui(sampler, pname);
    }

    public static void glQueryCounter(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int target) {
        GL33C.glQueryCounter(id, target);
    }

    public static void nglGetQueryObjecti64v(int id, int pname, long params) {
        GL33C.nglGetQueryObjecti64v(id, pname, params);
    }

    public static void glGetQueryObjecti64v(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") LongBuffer params) {
        GL33C.glGetQueryObjecti64v(id, pname, params);
    }

    @NativeType(value="void")
    public static long glGetQueryObjecti64(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname) {
        return GL33C.glGetQueryObjecti64(id, pname);
    }

    public static void nglGetQueryObjectui64v(int id, int pname, long params) {
        GL33C.nglGetQueryObjectui64v(id, pname, params);
    }

    public static void glGetQueryObjectui64v(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint64 *") LongBuffer params) {
        GL33C.glGetQueryObjectui64v(id, pname, params);
    }

    @NativeType(value="void")
    public static long glGetQueryObjectui64(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname) {
        return GL33C.glGetQueryObjectui64(id, pname);
    }

    public static void glVertexAttribDivisor(@NativeType(value="GLuint") int index, @NativeType(value="GLuint") int divisor) {
        GL33C.glVertexAttribDivisor(index, divisor);
    }

    public static native void glVertexP2ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glVertexP3ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glVertexP4ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglVertexP2uiv(int var0, long var1);

    public static void glVertexP2uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        GL33.nglVertexP2uiv(type, MemoryUtil.memAddress(value));
    }

    public static native void nglVertexP3uiv(int var0, long var1);

    public static void glVertexP3uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        GL33.nglVertexP3uiv(type, MemoryUtil.memAddress(value));
    }

    public static native void nglVertexP4uiv(int var0, long var1);

    public static void glVertexP4uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer value) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)value, 1);
        }
        GL33.nglVertexP4uiv(type, MemoryUtil.memAddress(value));
    }

    public static native void glTexCoordP1ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glTexCoordP2ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glTexCoordP3ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glTexCoordP4ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglTexCoordP1uiv(int var0, long var1);

    public static void glTexCoordP1uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 1);
        }
        GL33.nglTexCoordP1uiv(type, MemoryUtil.memAddress(coords));
    }

    public static native void nglTexCoordP2uiv(int var0, long var1);

    public static void glTexCoordP2uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 1);
        }
        GL33.nglTexCoordP2uiv(type, MemoryUtil.memAddress(coords));
    }

    public static native void nglTexCoordP3uiv(int var0, long var1);

    public static void glTexCoordP3uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 1);
        }
        GL33.nglTexCoordP3uiv(type, MemoryUtil.memAddress(coords));
    }

    public static native void nglTexCoordP4uiv(int var0, long var1);

    public static void glTexCoordP4uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 1);
        }
        GL33.nglTexCoordP4uiv(type, MemoryUtil.memAddress(coords));
    }

    public static native void glMultiTexCoordP1ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2);

    public static native void glMultiTexCoordP2ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2);

    public static native void glMultiTexCoordP3ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2);

    public static native void glMultiTexCoordP4ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2);

    public static native void nglMultiTexCoordP1uiv(int var0, int var1, long var2);

    public static void glMultiTexCoordP1uiv(@NativeType(value="GLenum") int texture, @NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 1);
        }
        GL33.nglMultiTexCoordP1uiv(texture, type, MemoryUtil.memAddress(coords));
    }

    public static native void nglMultiTexCoordP2uiv(int var0, int var1, long var2);

    public static void glMultiTexCoordP2uiv(@NativeType(value="GLenum") int texture, @NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 1);
        }
        GL33.nglMultiTexCoordP2uiv(texture, type, MemoryUtil.memAddress(coords));
    }

    public static native void nglMultiTexCoordP3uiv(int var0, int var1, long var2);

    public static void glMultiTexCoordP3uiv(@NativeType(value="GLenum") int texture, @NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 1);
        }
        GL33.nglMultiTexCoordP3uiv(texture, type, MemoryUtil.memAddress(coords));
    }

    public static native void nglMultiTexCoordP4uiv(int var0, int var1, long var2);

    public static void glMultiTexCoordP4uiv(@NativeType(value="GLenum") int texture, @NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 1);
        }
        GL33.nglMultiTexCoordP4uiv(texture, type, MemoryUtil.memAddress(coords));
    }

    public static native void glNormalP3ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglNormalP3uiv(int var0, long var1);

    public static void glNormalP3uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer coords) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)coords, 1);
        }
        GL33.nglNormalP3uiv(type, MemoryUtil.memAddress(coords));
    }

    public static native void glColorP3ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glColorP4ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglColorP3uiv(int var0, long var1);

    public static void glColorP3uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer color) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)color, 1);
        }
        GL33.nglColorP3uiv(type, MemoryUtil.memAddress(color));
    }

    public static native void nglColorP4uiv(int var0, long var1);

    public static void glColorP4uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer color) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)color, 1);
        }
        GL33.nglColorP4uiv(type, MemoryUtil.memAddress(color));
    }

    public static native void glSecondaryColorP3ui(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglSecondaryColorP3uiv(int var0, long var1);

    public static void glSecondaryColorP3uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer color) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)color, 1);
        }
        GL33.nglSecondaryColorP3uiv(type, MemoryUtil.memAddress(color));
    }

    public static void glVertexAttribP1ui(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint") int value) {
        GL33C.glVertexAttribP1ui(index, type, normalized, value);
    }

    public static void glVertexAttribP2ui(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint") int value) {
        GL33C.glVertexAttribP2ui(index, type, normalized, value);
    }

    public static void glVertexAttribP3ui(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint") int value) {
        GL33C.glVertexAttribP3ui(index, type, normalized, value);
    }

    public static void glVertexAttribP4ui(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint") int value) {
        GL33C.glVertexAttribP4ui(index, type, normalized, value);
    }

    public static void nglVertexAttribP1uiv(int index, int type, boolean normalized, long value) {
        GL33C.nglVertexAttribP1uiv(index, type, normalized, value);
    }

    public static void glVertexAttribP1uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") IntBuffer value) {
        GL33C.glVertexAttribP1uiv(index, type, normalized, value);
    }

    public static void nglVertexAttribP2uiv(int index, int type, boolean normalized, long value) {
        GL33C.nglVertexAttribP2uiv(index, type, normalized, value);
    }

    public static void glVertexAttribP2uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") IntBuffer value) {
        GL33C.glVertexAttribP2uiv(index, type, normalized, value);
    }

    public static void nglVertexAttribP3uiv(int index, int type, boolean normalized, long value) {
        GL33C.nglVertexAttribP3uiv(index, type, normalized, value);
    }

    public static void glVertexAttribP3uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") IntBuffer value) {
        GL33C.glVertexAttribP3uiv(index, type, normalized, value);
    }

    public static void nglVertexAttribP4uiv(int index, int type, boolean normalized, long value) {
        GL33C.nglVertexAttribP4uiv(index, type, normalized, value);
    }

    public static void glVertexAttribP4uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") IntBuffer value) {
        GL33C.glVertexAttribP4uiv(index, type, normalized, value);
    }

    public static void glGenSamplers(@NativeType(value="GLuint *") int[] samplers) {
        GL33C.glGenSamplers(samplers);
    }

    public static void glDeleteSamplers(@NativeType(value="GLuint const *") int[] samplers) {
        GL33C.glDeleteSamplers(samplers);
    }

    public static void glSamplerParameteriv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        GL33C.glSamplerParameteriv(sampler, pname, params);
    }

    public static void glSamplerParameterfv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat const *") float[] params) {
        GL33C.glSamplerParameterfv(sampler, pname, params);
    }

    public static void glSamplerParameterIiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint const *") int[] params) {
        GL33C.glSamplerParameterIiv(sampler, pname, params);
    }

    public static void glSamplerParameterIuiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint const *") int[] params) {
        GL33C.glSamplerParameterIuiv(sampler, pname, params);
    }

    public static void glGetSamplerParameteriv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL33C.glGetSamplerParameteriv(sampler, pname, params);
    }

    public static void glGetSamplerParameterfv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLfloat *") float[] params) {
        GL33C.glGetSamplerParameterfv(sampler, pname, params);
    }

    public static void glGetSamplerParameterIiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        GL33C.glGetSamplerParameterIiv(sampler, pname, params);
    }

    public static void glGetSamplerParameterIuiv(@NativeType(value="GLuint") int sampler, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint *") int[] params) {
        GL33C.glGetSamplerParameterIuiv(sampler, pname, params);
    }

    public static void glGetQueryObjecti64v(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLint64 *") long[] params) {
        GL33C.glGetQueryObjecti64v(id, pname, params);
    }

    public static void glGetQueryObjectui64v(@NativeType(value="GLuint") int id, @NativeType(value="GLenum") int pname, @NativeType(value="GLuint64 *") long[] params) {
        GL33C.glGetQueryObjectui64v(id, pname, params);
    }

    public static void glVertexP2uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glVertexP2uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(value, 1);
        }
        JNI.callPV(type, value, __functionAddress);
    }

    public static void glVertexP3uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glVertexP3uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(value, 1);
        }
        JNI.callPV(type, value, __functionAddress);
    }

    public static void glVertexP4uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] value) {
        long __functionAddress = GL.getICD().glVertexP4uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(value, 1);
        }
        JNI.callPV(type, value, __functionAddress);
    }

    public static void glTexCoordP1uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] coords) {
        long __functionAddress = GL.getICD().glTexCoordP1uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 1);
        }
        JNI.callPV(type, coords, __functionAddress);
    }

    public static void glTexCoordP2uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] coords) {
        long __functionAddress = GL.getICD().glTexCoordP2uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 1);
        }
        JNI.callPV(type, coords, __functionAddress);
    }

    public static void glTexCoordP3uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] coords) {
        long __functionAddress = GL.getICD().glTexCoordP3uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 1);
        }
        JNI.callPV(type, coords, __functionAddress);
    }

    public static void glTexCoordP4uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] coords) {
        long __functionAddress = GL.getICD().glTexCoordP4uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 1);
        }
        JNI.callPV(type, coords, __functionAddress);
    }

    public static void glMultiTexCoordP1uiv(@NativeType(value="GLenum") int texture, @NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] coords) {
        long __functionAddress = GL.getICD().glMultiTexCoordP1uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 1);
        }
        JNI.callPV(texture, type, coords, __functionAddress);
    }

    public static void glMultiTexCoordP2uiv(@NativeType(value="GLenum") int texture, @NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] coords) {
        long __functionAddress = GL.getICD().glMultiTexCoordP2uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 1);
        }
        JNI.callPV(texture, type, coords, __functionAddress);
    }

    public static void glMultiTexCoordP3uiv(@NativeType(value="GLenum") int texture, @NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] coords) {
        long __functionAddress = GL.getICD().glMultiTexCoordP3uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 1);
        }
        JNI.callPV(texture, type, coords, __functionAddress);
    }

    public static void glMultiTexCoordP4uiv(@NativeType(value="GLenum") int texture, @NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] coords) {
        long __functionAddress = GL.getICD().glMultiTexCoordP4uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 1);
        }
        JNI.callPV(texture, type, coords, __functionAddress);
    }

    public static void glNormalP3uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] coords) {
        long __functionAddress = GL.getICD().glNormalP3uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(coords, 1);
        }
        JNI.callPV(type, coords, __functionAddress);
    }

    public static void glColorP3uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] color) {
        long __functionAddress = GL.getICD().glColorP3uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(color, 1);
        }
        JNI.callPV(type, color, __functionAddress);
    }

    public static void glColorP4uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] color) {
        long __functionAddress = GL.getICD().glColorP4uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(color, 1);
        }
        JNI.callPV(type, color, __functionAddress);
    }

    public static void glSecondaryColorP3uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] color) {
        long __functionAddress = GL.getICD().glSecondaryColorP3uiv;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(color, 1);
        }
        JNI.callPV(type, color, __functionAddress);
    }

    public static void glVertexAttribP1uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") int[] value) {
        GL33C.glVertexAttribP1uiv(index, type, normalized, value);
    }

    public static void glVertexAttribP2uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") int[] value) {
        GL33C.glVertexAttribP2uiv(index, type, normalized, value);
    }

    public static void glVertexAttribP3uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") int[] value) {
        GL33C.glVertexAttribP3uiv(index, type, normalized, value);
    }

    public static void glVertexAttribP4uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") int[] value) {
        GL33C.glVertexAttribP4uiv(index, type, normalized, value);
    }

    static {
        GL.initialize();
    }
}

