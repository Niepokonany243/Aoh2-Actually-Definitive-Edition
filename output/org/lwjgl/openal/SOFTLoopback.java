/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.openal;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class SOFTLoopback {
    public static final int ALC_BYTE_SOFT = 5120;
    public static final int ALC_UNSIGNED_BYTE_SOFT = 5121;
    public static final int ALC_SHORT_SOFT = 5122;
    public static final int ALC_UNSIGNED_SHORT_SOFT = 5123;
    public static final int ALC_INT_SOFT = 5124;
    public static final int ALC_UNSIGNED_INT_SOFT = 5125;
    public static final int ALC_FLOAT_SOFT = 5126;
    public static final int ALC_MONO_SOFT = 5376;
    public static final int ALC_STEREO_SOFT = 5377;
    public static final int ALC_QUAD_SOFT = 5379;
    public static final int ALC_5POINT1_SOFT = 5380;
    public static final int ALC_6POINT1_SOFT = 5381;
    public static final int ALC_7POINT1_SOFT = 5382;
    public static final int ALC_FORMAT_CHANNELS_SOFT = 6544;
    public static final int ALC_FORMAT_TYPE_SOFT = 6545;

    protected SOFTLoopback() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(ALCCapabilities caps) {
        return Checks.checkFunctions(caps.alcLoopbackOpenDeviceSOFT, caps.alcIsRenderFormatSupportedSOFT, caps.alcRenderSamplesSOFT);
    }

    public static long nalcLoopbackOpenDeviceSOFT(long deviceName) {
        long __functionAddress = ALC.getICD().alcLoopbackOpenDeviceSOFT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.invokePP(deviceName, __functionAddress);
    }

    @NativeType(value="ALCdevice *")
    public static long alcLoopbackOpenDeviceSOFT(@Nullable @NativeType(value="ALCchar const *") ByteBuffer deviceName) {
        if (Checks.CHECKS) {
            Checks.checkNT1Safe(deviceName);
        }
        return SOFTLoopback.nalcLoopbackOpenDeviceSOFT(MemoryUtil.memAddressSafe(deviceName));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALCdevice *")
    public static long alcLoopbackOpenDeviceSOFT(@Nullable @NativeType(value="ALCchar const *") CharSequence deviceName) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8Safe(deviceName, true);
            long deviceNameEncoded = deviceName == null ? 0L : stack.getPointerAddress();
            long l = SOFTLoopback.nalcLoopbackOpenDeviceSOFT(deviceNameEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="ALCboolean")
    public static boolean alcIsRenderFormatSupportedSOFT(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCsizei") int frequency, @NativeType(value="ALCenum") int channels, @NativeType(value="ALCenum") int type) {
        long __functionAddress = ALC.getICD().alcIsRenderFormatSupportedSOFT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(device);
        }
        return JNI.invokePZ(device, frequency, channels, type, __functionAddress);
    }

    public static void nalcRenderSamplesSOFT(long device, long buffer, int samples) {
        long __functionAddress = ALC.getICD().alcRenderSamplesSOFT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(device);
        }
        JNI.invokePPV(device, buffer, samples, __functionAddress);
    }

    @NativeType(value="ALCvoid")
    public static void alcRenderSamplesSOFT(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCvoid *") ByteBuffer buffer, @NativeType(value="ALCsizei") int samples) {
        SOFTLoopback.nalcRenderSamplesSOFT(device, MemoryUtil.memAddress(buffer), samples);
    }

    @NativeType(value="ALCvoid")
    public static void alcRenderSamplesSOFT(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCvoid *") ShortBuffer buffer, @NativeType(value="ALCsizei") int samples) {
        SOFTLoopback.nalcRenderSamplesSOFT(device, MemoryUtil.memAddress(buffer), samples);
    }

    @NativeType(value="ALCvoid")
    public static void alcRenderSamplesSOFT(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCvoid *") IntBuffer buffer, @NativeType(value="ALCsizei") int samples) {
        SOFTLoopback.nalcRenderSamplesSOFT(device, MemoryUtil.memAddress(buffer), samples);
    }

    @NativeType(value="ALCvoid")
    public static void alcRenderSamplesSOFT(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCvoid *") FloatBuffer buffer, @NativeType(value="ALCsizei") int samples) {
        SOFTLoopback.nalcRenderSamplesSOFT(device, MemoryUtil.memAddress(buffer), samples);
    }

    @NativeType(value="ALCvoid")
    public static void alcRenderSamplesSOFT(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCvoid *") short[] buffer, @NativeType(value="ALCsizei") int samples) {
        long __functionAddress = ALC.getICD().alcRenderSamplesSOFT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(device);
        }
        JNI.invokePPV(device, buffer, samples, __functionAddress);
    }

    @NativeType(value="ALCvoid")
    public static void alcRenderSamplesSOFT(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCvoid *") int[] buffer, @NativeType(value="ALCsizei") int samples) {
        long __functionAddress = ALC.getICD().alcRenderSamplesSOFT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(device);
        }
        JNI.invokePPV(device, buffer, samples, __functionAddress);
    }

    @NativeType(value="ALCvoid")
    public static void alcRenderSamplesSOFT(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCvoid *") float[] buffer, @NativeType(value="ALCsizei") int samples) {
        long __functionAddress = ALC.getICD().alcRenderSamplesSOFT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(device);
        }
        JNI.invokePPV(device, buffer, samples, __functionAddress);
    }
}

