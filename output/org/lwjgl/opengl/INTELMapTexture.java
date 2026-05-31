/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class INTELMapTexture {
    public static final int GL_TEXTURE_MEMORY_LAYOUT_INTEL = 33791;
    public static final int GL_LAYOUT_DEFAULT_INTEL = 0;
    public static final int GL_LAYOUT_LINEAR_INTEL = 1;
    public static final int GL_LAYOUT_LINEAR_CPU_CACHED_INTEL = 2;

    protected INTELMapTexture() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glSyncTextureINTEL, caps.glUnmapTexture2DINTEL, caps.glMapTexture2DINTEL);
    }

    public static native void glSyncTextureINTEL(@NativeType(value="GLuint") int var0);

    public static native void glUnmapTexture2DINTEL(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1);

    public static native long nglMapTexture2DINTEL(int var0, int var1, int var2, long var3, long var5);

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapTexture2DINTEL(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLbitfield") int access, @NativeType(value="GLint *") IntBuffer stride, @NativeType(value="GLenum *") IntBuffer layout) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)stride, 1);
            Checks.check((Buffer)layout, 1);
        }
        long __result = INTELMapTexture.nglMapTexture2DINTEL(texture, level, access, MemoryUtil.memAddress(stride), MemoryUtil.memAddress(layout));
        return MemoryUtil.memByteBufferSafe(__result, INTELMapTexture.getStride(stride) * GLChecks.getTexLevelParameteri(texture, 3553, level, 4097));
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapTexture2DINTEL(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLbitfield") int access, @NativeType(value="GLint *") IntBuffer stride, @NativeType(value="GLenum *") IntBuffer layout, @Nullable ByteBuffer old_buffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)stride, 1);
            Checks.check((Buffer)layout, 1);
        }
        long __result = INTELMapTexture.nglMapTexture2DINTEL(texture, level, access, MemoryUtil.memAddress(stride), MemoryUtil.memAddress(layout));
        int length = INTELMapTexture.getStride(stride) * GLChecks.getTexLevelParameteri(texture, 3553, level, 4097);
        return APIUtil.apiGetMappedBuffer(old_buffer, __result, length);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapTexture2DINTEL(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLbitfield") int access, @NativeType(value="GLint *") IntBuffer stride, @NativeType(value="GLenum *") IntBuffer layout, long length, @Nullable ByteBuffer old_buffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)stride, 1);
            Checks.check((Buffer)layout, 1);
        }
        long __result = INTELMapTexture.nglMapTexture2DINTEL(texture, level, access, MemoryUtil.memAddress(stride), MemoryUtil.memAddress(layout));
        return APIUtil.apiGetMappedBuffer(old_buffer, __result, (int)length);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapTexture2DINTEL(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLbitfield") int access, @NativeType(value="GLint *") int[] stride, @NativeType(value="GLenum *") int[] layout) {
        long __functionAddress = GL.getICD().glMapTexture2DINTEL;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(stride, 1);
            Checks.check(layout, 1);
        }
        long __result = JNI.callPPP(texture, level, access, stride, layout, __functionAddress);
        return MemoryUtil.memByteBufferSafe(__result, INTELMapTexture.getStride(stride) * GLChecks.getTexLevelParameteri(texture, 3553, level, 4097));
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapTexture2DINTEL(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLbitfield") int access, @NativeType(value="GLint *") int[] stride, @NativeType(value="GLenum *") int[] layout, @Nullable ByteBuffer old_buffer) {
        long __functionAddress = GL.getICD().glMapTexture2DINTEL;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(stride, 1);
            Checks.check(layout, 1);
        }
        long __result = JNI.callPPP(texture, level, access, stride, layout, __functionAddress);
        int length = INTELMapTexture.getStride(stride) * GLChecks.getTexLevelParameteri(texture, 3553, level, 4097);
        return APIUtil.apiGetMappedBuffer(old_buffer, __result, length);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapTexture2DINTEL(@NativeType(value="GLuint") int texture, @NativeType(value="GLint") int level, @NativeType(value="GLbitfield") int access, @NativeType(value="GLint *") int[] stride, @NativeType(value="GLenum *") int[] layout, long length, @Nullable ByteBuffer old_buffer) {
        long __functionAddress = GL.getICD().glMapTexture2DINTEL;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(stride, 1);
            Checks.check(layout, 1);
        }
        long __result = JNI.callPPP(texture, level, access, stride, layout, __functionAddress);
        return APIUtil.apiGetMappedBuffer(old_buffer, __result, (int)length);
    }

    private static int getStride(IntBuffer stride) {
        return stride.get(stride.position());
    }

    private static int getStride(int[] stride) {
        return stride[0];
    }

    static {
        GL.initialize();
    }
}

