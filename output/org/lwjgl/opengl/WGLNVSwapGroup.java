/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.WGLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class WGLNVSwapGroup {
    protected WGLNVSwapGroup() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(WGLCapabilities caps) {
        return Checks.checkFunctions(caps.wglJoinSwapGroupNV, caps.wglBindSwapBarrierNV, caps.wglQuerySwapGroupNV, caps.wglQueryMaxSwapGroupsNV, caps.wglQueryFrameCountNV, caps.wglResetFrameCountNV);
    }

    @NativeType(value="BOOL")
    public static boolean wglJoinSwapGroupNV(@NativeType(value="HDC") long hDC, @NativeType(value="GLuint") int group) {
        long __functionAddress = GL.getCapabilitiesWGL().wglJoinSwapGroupNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hDC);
        }
        return JNI.callPI(hDC, group, __functionAddress) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean wglBindSwapBarrierNV(@NativeType(value="GLuint") int group, @NativeType(value="GLuint") int barrier) {
        long __functionAddress = GL.getCapabilitiesWGL().wglBindSwapBarrierNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callI(group, barrier, __functionAddress) != 0;
    }

    public static int nwglQuerySwapGroupNV(long hDC, long group, long barrier) {
        long __functionAddress = GL.getCapabilitiesWGL().wglQuerySwapGroupNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hDC);
        }
        return JNI.callPPPI(hDC, group, barrier, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean wglQuerySwapGroupNV(@NativeType(value="HDC") long hDC, @NativeType(value="GLuint *") IntBuffer group, @NativeType(value="GLuint *") IntBuffer barrier) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)group, 1);
            Checks.check((Buffer)barrier, 1);
        }
        return WGLNVSwapGroup.nwglQuerySwapGroupNV(hDC, MemoryUtil.memAddress(group), MemoryUtil.memAddress(barrier)) != 0;
    }

    public static int nwglQueryMaxSwapGroupsNV(long hDC, long maxGroups, long maxBarriers) {
        long __functionAddress = GL.getCapabilitiesWGL().wglQueryMaxSwapGroupsNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hDC);
        }
        return JNI.callPPPI(hDC, maxGroups, maxBarriers, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean wglQueryMaxSwapGroupsNV(@NativeType(value="HDC") long hDC, @NativeType(value="GLuint *") IntBuffer maxGroups, @NativeType(value="GLuint *") IntBuffer maxBarriers) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)maxGroups, 1);
            Checks.check((Buffer)maxBarriers, 1);
        }
        return WGLNVSwapGroup.nwglQueryMaxSwapGroupsNV(hDC, MemoryUtil.memAddress(maxGroups), MemoryUtil.memAddress(maxBarriers)) != 0;
    }

    public static int nwglQueryFrameCountNV(long hDC, long count) {
        long __functionAddress = GL.getCapabilitiesWGL().wglQueryFrameCountNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hDC);
        }
        return JNI.callPPI(hDC, count, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean wglQueryFrameCountNV(@NativeType(value="HDC") long hDC, @NativeType(value="GLuint *") IntBuffer count) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)count, 1);
        }
        return WGLNVSwapGroup.nwglQueryFrameCountNV(hDC, MemoryUtil.memAddress(count)) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean wglResetFrameCountNV(@NativeType(value="HDC") long hDC) {
        long __functionAddress = GL.getCapabilitiesWGL().wglResetFrameCountNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hDC);
        }
        return JNI.callPI(hDC, __functionAddress) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean wglQuerySwapGroupNV(@NativeType(value="HDC") long hDC, @NativeType(value="GLuint *") int[] group, @NativeType(value="GLuint *") int[] barrier) {
        long __functionAddress = GL.getCapabilitiesWGL().wglQuerySwapGroupNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hDC);
            Checks.check(group, 1);
            Checks.check(barrier, 1);
        }
        return JNI.callPPPI(hDC, group, barrier, __functionAddress) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean wglQueryMaxSwapGroupsNV(@NativeType(value="HDC") long hDC, @NativeType(value="GLuint *") int[] maxGroups, @NativeType(value="GLuint *") int[] maxBarriers) {
        long __functionAddress = GL.getCapabilitiesWGL().wglQueryMaxSwapGroupsNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hDC);
            Checks.check(maxGroups, 1);
            Checks.check(maxBarriers, 1);
        }
        return JNI.callPPPI(hDC, maxGroups, maxBarriers, __functionAddress) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean wglQueryFrameCountNV(@NativeType(value="HDC") long hDC, @NativeType(value="GLuint *") int[] count) {
        long __functionAddress = GL.getCapabilitiesWGL().wglQueryFrameCountNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hDC);
            Checks.check(count, 1);
        }
        return JNI.callPPI(hDC, count, __functionAddress) != 0;
    }
}

