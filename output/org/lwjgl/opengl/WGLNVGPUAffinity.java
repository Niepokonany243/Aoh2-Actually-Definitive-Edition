/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GPU_DEVICE;
import org.lwjgl.opengl.WGLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class WGLNVGPUAffinity {
    public static final int ERROR_INCOMPATIBLE_AFFINITY_MASKS_NV = 8400;
    public static final int ERROR_MISSING_AFFINITY_MASK_NV = 8401;

    protected WGLNVGPUAffinity() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(WGLCapabilities caps) {
        return Checks.checkFunctions(caps.wglEnumGpusNV, caps.wglEnumGpuDevicesNV, caps.wglCreateAffinityDCNV, caps.wglEnumGpusFromAffinityDCNV, caps.wglDeleteDCNV);
    }

    public static int nwglEnumGpusNV(int gpuIndex, long gpu) {
        long __functionAddress = GL.getCapabilitiesWGL().wglEnumGpusNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callPI(gpuIndex, gpu, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean wglEnumGpusNV(@NativeType(value="UINT") int gpuIndex, @NativeType(value="HGPUNV *") PointerBuffer gpu) {
        if (Checks.CHECKS) {
            Checks.check(gpu, 1);
        }
        return WGLNVGPUAffinity.nwglEnumGpusNV(gpuIndex, MemoryUtil.memAddress(gpu)) != 0;
    }

    public static int nwglEnumGpuDevicesNV(long gpu, int deviceIndex, long gpuDevice) {
        long __functionAddress = GL.getCapabilitiesWGL().wglEnumGpuDevicesNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(gpu);
        }
        return JNI.callPPI(gpu, deviceIndex, gpuDevice, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean wglEnumGpuDevicesNV(@NativeType(value="HGPUNV") long gpu, @NativeType(value="UINT") int deviceIndex, @NativeType(value="PGPU_DEVICE") GPU_DEVICE gpuDevice) {
        return WGLNVGPUAffinity.nwglEnumGpuDevicesNV(gpu, deviceIndex, gpuDevice.address()) != 0;
    }

    public static long nwglCreateAffinityDCNV(long gpuList) {
        long __functionAddress = GL.getCapabilitiesWGL().wglCreateAffinityDCNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callPP(gpuList, __functionAddress);
    }

    @NativeType(value="HDC")
    public static long wglCreateAffinityDCNV(@NativeType(value="HGPUNV const *") PointerBuffer gpuList) {
        if (Checks.CHECKS) {
            Checks.checkNT(gpuList);
        }
        return WGLNVGPUAffinity.nwglCreateAffinityDCNV(MemoryUtil.memAddress(gpuList));
    }

    public static int nwglEnumGpusFromAffinityDCNV(long affinityDC, int gpuIndex, long gpu) {
        long __functionAddress = GL.getCapabilitiesWGL().wglEnumGpusFromAffinityDCNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(affinityDC);
        }
        return JNI.callPPI(affinityDC, gpuIndex, gpu, __functionAddress);
    }

    @NativeType(value="BOOL")
    public static boolean wglEnumGpusFromAffinityDCNV(@NativeType(value="HDC") long affinityDC, @NativeType(value="UINT") int gpuIndex, @NativeType(value="HGPUNV *") PointerBuffer gpu) {
        if (Checks.CHECKS) {
            Checks.check(gpu, 1);
        }
        return WGLNVGPUAffinity.nwglEnumGpusFromAffinityDCNV(affinityDC, gpuIndex, MemoryUtil.memAddress(gpu)) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean wglDeleteDCNV(@NativeType(value="HDC") long hdc) {
        long __functionAddress = GL.getCapabilitiesWGL().wglDeleteDCNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(hdc);
        }
        return JNI.callPI(hdc, __functionAddress) != 0;
    }
}

