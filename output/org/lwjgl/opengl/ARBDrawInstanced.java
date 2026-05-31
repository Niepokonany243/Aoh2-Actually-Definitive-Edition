/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBDrawInstanced {
    protected ARBDrawInstanced() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glDrawArraysInstancedARB, caps.glDrawElementsInstancedARB);
    }

    public static native void glDrawArraysInstancedARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLsizei") int var2, @NativeType(value="GLsizei") int var3);

    public static native void nglDrawElementsInstancedARB(int var0, int var1, int var2, long var3, int var5);

    public static void glDrawElementsInstancedARB(@NativeType(value="GLenum") int mode, @NativeType(value="GLsizei") int count, @NativeType(value="GLenum") int type, @NativeType(value="void const *") long indices, @NativeType(value="GLsizei") int primcount) {
        ARBDrawInstanced.nglDrawElementsInstancedARB(mode, count, type, indices, primcount);
    }

    public static void glDrawElementsInstancedARB(@NativeType(value="GLenum") int mode, @NativeType(value="GLenum") int type, @NativeType(value="void const *") ByteBuffer indices, @NativeType(value="GLsizei") int primcount) {
        ARBDrawInstanced.nglDrawElementsInstancedARB(mode, indices.remaining() >> GLChecks.typeToByteShift(type), type, MemoryUtil.memAddress(indices), primcount);
    }

    public static void glDrawElementsInstancedARB(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ByteBuffer indices, @NativeType(value="GLsizei") int primcount) {
        ARBDrawInstanced.nglDrawElementsInstancedARB(mode, indices.remaining(), 5121, MemoryUtil.memAddress(indices), primcount);
    }

    public static void glDrawElementsInstancedARB(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") ShortBuffer indices, @NativeType(value="GLsizei") int primcount) {
        ARBDrawInstanced.nglDrawElementsInstancedARB(mode, indices.remaining(), 5123, MemoryUtil.memAddress(indices), primcount);
    }

    public static void glDrawElementsInstancedARB(@NativeType(value="GLenum") int mode, @NativeType(value="void const *") IntBuffer indices, @NativeType(value="GLsizei") int primcount) {
        ARBDrawInstanced.nglDrawElementsInstancedARB(mode, indices.remaining(), 5125, MemoryUtil.memAddress(indices), primcount);
    }

    static {
        GL.initialize();
    }
}

