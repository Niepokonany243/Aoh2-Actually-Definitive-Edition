/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVBindlessMultiDrawIndirect {
    protected NVBindlessMultiDrawIndirect() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glMultiDrawArraysIndirectBindlessNV, caps.glMultiDrawElementsIndirectBindlessNV);
    }

    public static native void nglMultiDrawArraysIndirectBindlessNV(int var0, long var1, int var3, int var4, int var5);

    public static void glMultiDrawArraysIndirectBindlessNV(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ByteBuffer indirect, @NativeType(value="GLsizei") int drawCount, @NativeType(value="GLsizei") int stride, @NativeType(value="GLint") int vertexBufferCount) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)indirect, drawCount * (stride == 0 ? 16 + vertexBufferCount * 24 : stride));
        }
        NVBindlessMultiDrawIndirect.nglMultiDrawArraysIndirectBindlessNV(mode, MemoryUtil.memAddress(indirect), drawCount, stride, vertexBufferCount);
    }

    public static void glMultiDrawArraysIndirectBindlessNV(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") long indirect, @NativeType(value="GLsizei") int drawCount, @NativeType(value="GLsizei") int stride, @NativeType(value="GLint") int vertexBufferCount) {
        NVBindlessMultiDrawIndirect.nglMultiDrawArraysIndirectBindlessNV(mode, indirect, drawCount, stride, vertexBufferCount);
    }

    public static native void nglMultiDrawElementsIndirectBindlessNV(int var0, int var1, long var2, int var4, int var5, int var6);

    public static void glMultiDrawElementsIndirectBindlessNV(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer indirect, @NativeType(value="GLsizei") int drawCount, @NativeType(value="GLsizei") int stride, @NativeType(value="GLint") int vertexBufferCount) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)indirect, drawCount * (stride == 0 ? (vertexBufferCount + 2) * 24 : stride));
        }
        NVBindlessMultiDrawIndirect.nglMultiDrawElementsIndirectBindlessNV(mode, type, MemoryUtil.memAddress(indirect), drawCount, stride, vertexBufferCount);
    }

    public static void glMultiDrawElementsIndirectBindlessNV(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long indirect, @NativeType(value="GLsizei") int drawCount, @NativeType(value="GLsizei") int stride, @NativeType(value="GLint") int vertexBufferCount) {
        NVBindlessMultiDrawIndirect.nglMultiDrawElementsIndirectBindlessNV(mode, type, indirect, drawCount, stride, vertexBufferCount);
    }

    static {
        GL.initialize();
    }
}

