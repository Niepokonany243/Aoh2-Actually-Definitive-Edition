/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.opengl.WGLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class WGLAMDGPUAssociation {
    public static final int WGL_GPU_VENDOR_AMD = 7936;
    public static final int WGL_GPU_RENDERER_STRING_AMD = 7937;
    public static final int WGL_GPU_OPENGL_VERSION_STRING_AMD = 7938;
    public static final int WGL_GPU_FASTEST_TARGET_GPUS_AMD = 8610;
    public static final int WGL_GPU_RAM_AMD = 8611;
    public static final int WGL_GPU_CLOCK_AMD = 8612;
    public static final int WGL_GPU_NUM_PIPES_AMD = 8613;
    public static final int WGL_GPU_NUM_SIMD_AMD = 8614;
    public static final int WGL_GPU_NUM_RB_AMD = 8615;
    public static final int WGL_GPU_NUM_SPI_AMD = 8616;

    protected WGLAMDGPUAssociation() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(WGLCapabilities caps) {
        return Checks.checkFunctions(caps.wglGetGPUIDsAMD, caps.wglGetGPUInfoAMD, caps.wglGetContextGPUIDAMD, caps.wglCreateAssociatedContextAMD, caps.wglCreateAssociatedContextAttribsAMD, caps.wglDeleteAssociatedContextAMD, caps.wglMakeAssociatedContextCurrentAMD, caps.wglGetCurrentAssociatedContextAMD);
    }

    public static int nwglGetGPUIDsAMD(int maxCount, long ids) {
        long __functionAddress = GL.getCapabilitiesWGL().wglGetGPUIDsAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callPI(maxCount, ids, __functionAddress);
    }

    @NativeType(value="UINT")
    public static int wglGetGPUIDsAMD(@Nullable @NativeType(value="UINT *") IntBuffer ids) {
        return WGLAMDGPUAssociation.nwglGetGPUIDsAMD(Checks.remainingSafe(ids), MemoryUtil.memAddressSafe(ids));
    }

    public static int nwglGetGPUInfoAMD(int id, int property, int dataType, int size, long data) {
        long __functionAddress = GL.getCapabilitiesWGL().wglGetGPUInfoAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callPI(id, property, dataType, size, data, __functionAddress);
    }

    public static int wglGetGPUInfoAMD(@NativeType(value="UINT") int id, int property, @NativeType(value="GLenum") int dataType, @NativeType(value="void *") ByteBuffer data) {
        return WGLAMDGPUAssociation.nwglGetGPUInfoAMD(id, property, dataType, data.remaining() >> GLChecks.typeToByteShift(dataType), MemoryUtil.memAddress(data));
    }

    public static int wglGetGPUInfoAMD(@NativeType(value="UINT") int id, int property, @NativeType(value="GLenum") int dataType, @NativeType(value="void *") IntBuffer data) {
        return WGLAMDGPUAssociation.nwglGetGPUInfoAMD(id, property, dataType, (int)((long)data.remaining() << 2 >> GLChecks.typeToByteShift(dataType)), MemoryUtil.memAddress(data));
    }

    public static int wglGetGPUInfoAMD(@NativeType(value="UINT") int id, int property, @NativeType(value="GLenum") int dataType, @NativeType(value="void *") FloatBuffer data) {
        return WGLAMDGPUAssociation.nwglGetGPUInfoAMD(id, property, dataType, (int)((long)data.remaining() << 2 >> GLChecks.typeToByteShift(dataType)), MemoryUtil.memAddress(data));
    }

    @NativeType(value="UINT")
    public static int wglGetContextGPUIDAMD(@NativeType(value="HGLRC") long hglrc) {
        long __functionAddress = GL.getCapabilitiesWGL().wglGetContextGPUIDAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hglrc);
        }
        return JNI.callPI(hglrc, __functionAddress);
    }

    @NativeType(value="HGLRC")
    public static long wglCreateAssociatedContextAMD(@NativeType(value="UINT") int id) {
        long __functionAddress = GL.getCapabilitiesWGL().wglCreateAssociatedContextAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callP(id, __functionAddress);
    }

    public static long nwglCreateAssociatedContextAttribsAMD(int id, long shareContext, long attribList) {
        long __functionAddress = GL.getCapabilitiesWGL().wglCreateAssociatedContextAttribsAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callPPP(id, shareContext, attribList, __functionAddress);
    }

    @NativeType(value="HGLRC")
    public static long wglCreateAssociatedContextAttribsAMD(@NativeType(value="UINT") int id, @NativeType(value="HGLRC") long shareContext, @Nullable @NativeType(value="int const *") IntBuffer attribList) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(attribList);
        }
        return WGLAMDGPUAssociation.nwglCreateAssociatedContextAttribsAMD(id, shareContext, MemoryUtil.memAddressSafe(attribList));
    }

    @NativeType(value="BOOL")
    public static boolean wglDeleteAssociatedContextAMD(@NativeType(value="HGLRC") long hglrc) {
        long __functionAddress = GL.getCapabilitiesWGL().wglDeleteAssociatedContextAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hglrc);
        }
        return JNI.callPI(hglrc, __functionAddress) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean wglMakeAssociatedContextCurrentAMD(@NativeType(value="HGLRC") long hglrc) {
        long __functionAddress = GL.getCapabilitiesWGL().wglMakeAssociatedContextCurrentAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hglrc);
        }
        return JNI.callPI(hglrc, __functionAddress) != 0;
    }

    @NativeType(value="HGLRC")
    public static long wglGetCurrentAssociatedContextAMD() {
        long __functionAddress = GL.getCapabilitiesWGL().wglGetCurrentAssociatedContextAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callP(__functionAddress);
    }

    @NativeType(value="VOID")
    public static void wglBlitContextFramebufferAMD(@NativeType(value="HGLRC") long dstCtx, @NativeType(value="GLint") int srcX0, @NativeType(value="GLint") int srcY0, @NativeType(value="GLint") int srcX1, @NativeType(value="GLint") int srcY1, @NativeType(value="GLint") int dstX0, @NativeType(value="GLint") int dstY0, @NativeType(value="GLint") int dstX1, @NativeType(value="GLint") int dstY1, @NativeType(value="GLbitfield") int mask, @NativeType(value="GLenum") int filter) {
        long __functionAddress = GL.getCapabilitiesWGL().wglBlitContextFramebufferAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(dstCtx);
        }
        JNI.callPV(dstCtx, srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter, __functionAddress);
    }

    @NativeType(value="UINT")
    public static int wglGetGPUIDsAMD(@Nullable @NativeType(value="UINT *") int[] ids) {
        long __functionAddress = GL.getCapabilitiesWGL().wglGetGPUIDsAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callPI(Checks.lengthSafe(ids), ids, __functionAddress);
    }

    public static int wglGetGPUInfoAMD(@NativeType(value="UINT") int id, int property, @NativeType(value="GLenum") int dataType, @NativeType(value="void *") int[] data) {
        long __functionAddress = GL.getCapabilitiesWGL().wglGetGPUInfoAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callPI(id, property, dataType, data.length, data, __functionAddress);
    }

    public static int wglGetGPUInfoAMD(@NativeType(value="UINT") int id, int property, @NativeType(value="GLenum") int dataType, @NativeType(value="void *") float[] data) {
        long __functionAddress = GL.getCapabilitiesWGL().wglGetGPUInfoAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callPI(id, property, dataType, data.length, data, __functionAddress);
    }

    @NativeType(value="HGLRC")
    public static long wglCreateAssociatedContextAttribsAMD(@NativeType(value="UINT") int id, @NativeType(value="HGLRC") long shareContext, @Nullable @NativeType(value="int const *") int[] attribList) {
        long __functionAddress = GL.getCapabilitiesWGL().wglCreateAssociatedContextAttribsAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkNTSafe(attribList);
        }
        return JNI.callPPP(id, shareContext, attribList, __functionAddress);
    }
}

