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
import org.lwjgl.opengl.WGLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class WGLNVVertexArrayRange {
    protected WGLNVVertexArrayRange() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(WGLCapabilities caps) {
        return Checks.checkFunctions(caps.wglAllocateMemoryNV, caps.wglFreeMemoryNV);
    }

    public static long nwglAllocateMemoryNV(int size, float readfreq, float writefreq, float priority) {
        long __functionAddress = GL.getCapabilitiesWGL().wglAllocateMemoryNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callP(size, readfreq, writefreq, priority, __functionAddress);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer wglAllocateMemoryNV(@NativeType(value="GLsizei") int size, @NativeType(value="GLfloat") float readfreq, @NativeType(value="GLfloat") float writefreq, @NativeType(value="GLfloat") float priority) {
        long __result = WGLNVVertexArrayRange.nwglAllocateMemoryNV(size, readfreq, writefreq, priority);
        return MemoryUtil.memByteBufferSafe(__result, size);
    }

    public static void nwglFreeMemoryNV(long pointer) {
        long __functionAddress = GL.getCapabilitiesWGL().wglFreeMemoryNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(pointer, __functionAddress);
    }

    public static void wglFreeMemoryNV(@NativeType(value="void *") ByteBuffer pointer) {
        WGLNVVertexArrayRange.nwglFreeMemoryNV(MemoryUtil.memAddress(pointer));
    }
}

