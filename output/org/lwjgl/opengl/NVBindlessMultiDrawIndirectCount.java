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

public class NVBindlessMultiDrawIndirectCount {
    protected NVBindlessMultiDrawIndirectCount() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glMultiDrawArraysIndirectBindlessCountNV, caps.glMultiDrawElementsIndirectBindlessCountNV);
    }

    public static native void nglMultiDrawArraysIndirectBindlessCountNV(int var0, long var1, long var3, int var5, int var6, int var7);

    public static void glMultiDrawArraysIndirectBindlessCountNV(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ByteBuffer indirect, @NativeType(value="GLintptr") long drawCount, @NativeType(value="GLsizei") int maxDrawCount, @NativeType(value="GLsizei") int stride, @NativeType(value="GLint") int vertexBufferCount) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)indirect, maxDrawCount * (stride == 0 ? 16 + vertexBufferCount * 24 : stride));
        }
        NVBindlessMultiDrawIndirectCount.nglMultiDrawArraysIndirectBindlessCountNV(mode, MemoryUtil.memAddress(indirect), drawCount, maxDrawCount, stride, vertexBufferCount);
    }

    public static void glMultiDrawArraysIndirectBindlessCountNV(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") long indirect, @NativeType(value="GLintptr") long drawCount, @NativeType(value="GLsizei") int maxDrawCount, @NativeType(value="GLsizei") int stride, @NativeType(value="GLint") int vertexBufferCount) {
        NVBindlessMultiDrawIndirectCount.nglMultiDrawArraysIndirectBindlessCountNV(mode, indirect, drawCount, maxDrawCount, stride, vertexBufferCount);
    }

    public static native void nglMultiDrawElementsIndirectBindlessCountNV(int var0, int var1, long var2, long var4, int var6, int var7, int var8);

    public static void glMultiDrawElementsIndirectBindlessCountNV(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer indirect, @NativeType(value="GLintptr") long drawCount, @NativeType(value="GLsizei") int maxDrawCount, @NativeType(value="GLsizei") int stride, @NativeType(value="GLint") int vertexBufferCount) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)indirect, maxDrawCount * (stride == 0 ? (vertexBufferCount + 2) * 24 : stride));
        }
        NVBindlessMultiDrawIndirectCount.nglMultiDrawElementsIndirectBindlessCountNV(mode, type, MemoryUtil.memAddress(indirect), drawCount, maxDrawCount, stride, vertexBufferCount);
    }

    public static void glMultiDrawElementsIndirectBindlessCountNV(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long indirect, @NativeType(value="GLintptr") long drawCount, @NativeType(value="GLsizei") int maxDrawCount, @NativeType(value="GLsizei") int stride, @NativeType(value="GLint") int vertexBufferCount) {
        NVBindlessMultiDrawIndirectCount.nglMultiDrawElementsIndirectBindlessCountNV(mode, type, indirect, drawCount, maxDrawCount, stride, vertexBufferCount);
    }

    static {
        GL.initialize();
    }
}

