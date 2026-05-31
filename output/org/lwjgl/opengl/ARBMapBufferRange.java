/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL30C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBMapBufferRange {
    public static final int GL_MAP_READ_BIT = 1;
    public static final int GL_MAP_WRITE_BIT = 2;
    public static final int GL_MAP_INVALIDATE_RANGE_BIT = 4;
    public static final int GL_MAP_INVALIDATE_BUFFER_BIT = 8;
    public static final int GL_MAP_FLUSH_EXPLICIT_BIT = 16;
    public static final int GL_MAP_UNSYNCHRONIZED_BIT = 32;

    protected ARBMapBufferRange() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glMapBufferRange, caps.glFlushMappedBufferRange);
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

    static {
        GL.initialize();
    }
}

