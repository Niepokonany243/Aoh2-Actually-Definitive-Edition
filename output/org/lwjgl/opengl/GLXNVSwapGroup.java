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

public class GLXNVSwapGroup {
    protected GLXNVSwapGroup() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLXCapabilities caps) {
        return Checks.checkFunctions(caps.glXJoinSwapGroupNV, caps.glXBindSwapBarrierNV, caps.glXQuerySwapGroupNV, caps.glXQueryMaxSwapGroupsNV, caps.glXQueryFrameCountNV, caps.glXResetFrameCountNV);
    }

    @NativeType(value="Bool")
    public static boolean glXJoinSwapGroupNV(@NativeType(value="Display *") long display, @NativeType(value="GLXDrawable") long drawable, @NativeType(value="GLuint") int group) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXJoinSwapGroupNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(drawable);
        }
        return JNI.callPPI(display, drawable, group, __functionAddress) != 0;
    }

    @NativeType(value="Bool")
    public static boolean glXBindSwapBarrierNV(@NativeType(value="Display *") long display, @NativeType(value="GLuint") int group, @NativeType(value="GLuint") int barrier) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXBindSwapBarrierNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
        }
        return JNI.callPI(display, group, barrier, __functionAddress) != 0;
    }

    public static int nglXQuerySwapGroupNV(long display, long drawable, long group, long barrier) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXQuerySwapGroupNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(drawable);
        }
        return JNI.callPPPPI(display, drawable, group, barrier, __functionAddress);
    }

    @NativeType(value="Bool")
    public static boolean glXQuerySwapGroupNV(@NativeType(value="Display *") long display, @NativeType(value="GLXDrawable") long drawable, @NativeType(value="GLuint *") IntBuffer group, @NativeType(value="GLuint *") IntBuffer barrier) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)group, 1);
            Checks.check((Buffer)barrier, 1);
        }
        return GLXNVSwapGroup.nglXQuerySwapGroupNV(display, drawable, MemoryUtil.memAddress(group), MemoryUtil.memAddress(barrier)) != 0;
    }

    public static int nglXQueryMaxSwapGroupsNV(long display, int screen, long maxGroups, long maxBarriers) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXQueryMaxSwapGroupsNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
        }
        return JNI.callPPPI(display, screen, maxGroups, maxBarriers, __functionAddress);
    }

    @NativeType(value="Bool")
    public static boolean glXQueryMaxSwapGroupsNV(@NativeType(value="Display *") long display, int screen, @NativeType(value="GLuint *") IntBuffer maxGroups, @NativeType(value="GLuint *") IntBuffer maxBarriers) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)maxGroups, 1);
            Checks.check((Buffer)maxBarriers, 1);
        }
        return GLXNVSwapGroup.nglXQueryMaxSwapGroupsNV(display, screen, MemoryUtil.memAddress(maxGroups), MemoryUtil.memAddress(maxBarriers)) != 0;
    }

    public static int nglXQueryFrameCountNV(long display, int screen, long count) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXQueryFrameCountNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
        }
        return JNI.callPPI(display, screen, count, __functionAddress);
    }

    @NativeType(value="Bool")
    public static boolean glXQueryFrameCountNV(@NativeType(value="Display *") long display, int screen, @NativeType(value="GLuint *") IntBuffer count) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)count, 1);
        }
        return GLXNVSwapGroup.nglXQueryFrameCountNV(display, screen, MemoryUtil.memAddress(count)) != 0;
    }

    @NativeType(value="Bool")
    public static boolean glXResetFrameCountNV(@NativeType(value="Display *") long display, int screen) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXResetFrameCountNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
        }
        return JNI.callPI(display, screen, __functionAddress) != 0;
    }

    @NativeType(value="Bool")
    public static boolean glXQuerySwapGroupNV(@NativeType(value="Display *") long display, @NativeType(value="GLXDrawable") long drawable, @NativeType(value="GLuint *") int[] group, @NativeType(value="GLuint *") int[] barrier) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXQuerySwapGroupNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(drawable);
            Checks.check(group, 1);
            Checks.check(barrier, 1);
        }
        return JNI.callPPPPI(display, drawable, group, barrier, __functionAddress) != 0;
    }

    @NativeType(value="Bool")
    public static boolean glXQueryMaxSwapGroupsNV(@NativeType(value="Display *") long display, int screen, @NativeType(value="GLuint *") int[] maxGroups, @NativeType(value="GLuint *") int[] maxBarriers) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXQueryMaxSwapGroupsNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(maxGroups, 1);
            Checks.check(maxBarriers, 1);
        }
        return JNI.callPPPI(display, screen, maxGroups, maxBarriers, __functionAddress) != 0;
    }

    @NativeType(value="Bool")
    public static boolean glXQueryFrameCountNV(@NativeType(value="Display *") long display, int screen, @NativeType(value="GLuint *") int[] count) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXQueryFrameCountNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(count, 1);
        }
        return JNI.callPPI(display, screen, count, __functionAddress) != 0;
    }
}

