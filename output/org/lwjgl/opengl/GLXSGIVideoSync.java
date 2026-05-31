/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLXCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GLXSGIVideoSync {
    protected GLXSGIVideoSync() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLXCapabilities caps) {
        return Checks.checkFunctions(caps.glXGetVideoSyncSGI, caps.glXWaitVideoSyncSGI);
    }

    public static int nglXGetVideoSyncSGI(long count) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXGetVideoSyncSGI;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callPI(count, __functionAddress);
    }

    @NativeType(value="GLint")
    public static int glXGetVideoSyncSGI(@NativeType(value="unsigned int *") IntBuffer count) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)count, 1);
        }
        return GLXSGIVideoSync.nglXGetVideoSyncSGI(MemoryUtil.memAddress(count));
    }

    public static int nglXWaitVideoSyncSGI(int divisor, int remainder, long count) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXWaitVideoSyncSGI;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callPI(divisor, remainder, count, __functionAddress);
    }

    @NativeType(value="GLint")
    public static int glXWaitVideoSyncSGI(int divisor, int remainder, @NativeType(value="unsigned int *") IntBuffer count) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)count, 1);
        }
        return GLXSGIVideoSync.nglXWaitVideoSyncSGI(divisor, remainder, MemoryUtil.memAddress(count));
    }

    @NativeType(value="GLint")
    public static int glXGetVideoSyncSGI(@NativeType(value="unsigned int *") int[] count) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXGetVideoSyncSGI;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(count, 1);
        }
        return JNI.callPI(count, __functionAddress);
    }

    @NativeType(value="GLint")
    public static int glXWaitVideoSyncSGI(int divisor, int remainder, @NativeType(value="unsigned int *") int[] count) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXWaitVideoSyncSGI;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(count, 1);
        }
        return JNI.callPI(divisor, remainder, count, __functionAddress);
    }
}

