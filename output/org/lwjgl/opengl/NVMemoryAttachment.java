/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import java.util.Set;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVMemoryAttachment {
    public static final int GL_ATTACHED_MEMORY_OBJECT_NV = 38308;
    public static final int GL_ATTACHED_MEMORY_OFFSET_NV = 38309;
    public static final int GL_MEMORY_ATTACHABLE_ALIGNMENT_NV = 38310;
    public static final int GL_MEMORY_ATTACHABLE_SIZE_NV = 38311;
    public static final int GL_MEMORY_ATTACHABLE_NV = 38312;
    public static final int GL_DETACHED_MEMORY_INCARNATION_NV = 38313;
    public static final int GL_DETACHED_TEXTURES_NV = 38314;
    public static final int GL_DETACHED_BUFFERS_NV = 38315;
    public static final int GL_MAX_DETACHED_TEXTURES_NV = 38316;
    public static final int GL_MAX_DETACHED_BUFFERS_NV = 38317;

    protected NVMemoryAttachment() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, Set<String> ext) {
        return Checks.checkFunctions(caps.glGetMemoryObjectDetachedResourcesuivNV, caps.glResetMemoryObjectParameterNV, caps.glTexAttachMemoryNV, caps.glBufferAttachMemoryNV, caps.hasDSA(ext) ? caps.glTextureAttachMemoryNV : -1L, caps.hasDSA(ext) ? caps.glNamedBufferAttachMemoryNV : -1L);
    }

    public static native void nglGetMemoryObjectDetachedResourcesuivNV(int var0, int var1, int var2, int var3, long var4);

    public static void glGetMemoryObjectDetachedResourcesuivNV(@NativeType(value="GLuint") int memory, @NativeType(value="GLenum") int pname, @NativeType(value="GLint") int first, @NativeType(value="GLuint *") IntBuffer params) {
        NVMemoryAttachment.nglGetMemoryObjectDetachedResourcesuivNV(memory, pname, first, params.remaining(), MemoryUtil.memAddress(params));
    }

    public static native void glResetMemoryObjectParameterNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void glTexAttachMemoryNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint64") long var2);

    public static native void glBufferAttachMemoryNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint64") long var2);

    public static native void glTextureAttachMemoryNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint64") long var2);

    public static native void glNamedBufferAttachMemoryNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint64") long var2);

    public static void glGetMemoryObjectDetachedResourcesuivNV(@NativeType(value="GLuint") int memory, @NativeType(value="GLenum") int pname, @NativeType(value="GLint") int first, @NativeType(value="GLuint *") int[] params) {
        long __functionAddress = GL.getICD().glGetMemoryObjectDetachedResourcesuivNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(memory, pname, first, params.length, params, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

