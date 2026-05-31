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
import org.lwjgl.openal.ALC10;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ALC11
extends ALC10 {
    public static final int ALC_MONO_SOURCES = 4112;
    public static final int ALC_STEREO_SOURCES = 4113;
    public static final int ALC_DEFAULT_ALL_DEVICES_SPECIFIER = 4114;
    public static final int ALC_ALL_DEVICES_SPECIFIER = 4115;
    public static final int ALC_CAPTURE_DEVICE_SPECIFIER = 784;
    public static final int ALC_CAPTURE_DEFAULT_DEVICE_SPECIFIER = 785;
    public static final int ALC_CAPTURE_SAMPLES = 786;

    protected ALC11() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(ALCCapabilities caps) {
        return Checks.checkFunctions(caps.alcCaptureOpenDevice, caps.alcCaptureCloseDevice, caps.alcCaptureStart, caps.alcCaptureStop, caps.alcCaptureSamples);
    }

    public static long nalcCaptureOpenDevice(long deviceName, int frequency, int format, int samples) {
        long __functionAddress = ALC.getICD().alcCaptureOpenDevice;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.invokePP(deviceName, frequency, format, samples, __functionAddress);
    }

    @NativeType(value="ALCdevice *")
    public static long alcCaptureOpenDevice(@Nullable @NativeType(value="ALCchar const *") ByteBuffer deviceName, @NativeType(value="ALCuint") int frequency, @NativeType(value="ALCenum") int format, @NativeType(value="ALCsizei") int samples) {
        if (Checks.CHECKS) {
            Checks.checkNT1Safe(deviceName);
        }
        return ALC11.nalcCaptureOpenDevice(MemoryUtil.memAddressSafe(deviceName), frequency, format, samples);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALCdevice *")
    public static long alcCaptureOpenDevice(@Nullable @NativeType(value="ALCchar const *") CharSequence deviceName, @NativeType(value="ALCuint") int frequency, @NativeType(value="ALCenum") int format, @NativeType(value="ALCsizei") int samples) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8Safe(deviceName, true);
            long deviceNameEncoded = deviceName == null ? 0L : stack.getPointerAddress();
            long l = ALC11.nalcCaptureOpenDevice(deviceNameEncoded, frequency, format, samples);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="ALCboolean")
    public static boolean alcCaptureCloseDevice(@NativeType(value="ALCdevice *") long device) {
        long __functionAddress = ALC.getICD().alcCaptureCloseDevice;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(device);
        }
        return JNI.invokePZ(device, __functionAddress);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureStart(@NativeType(value="ALCdevice *") long device) {
        long __functionAddress = ALC.getICD().alcCaptureStart;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(device);
        }
        JNI.invokePV(device, __functionAddress);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureStop(@NativeType(value="ALCdevice *") long device) {
        long __functionAddress = ALC.getICD().alcCaptureStop;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(device);
        }
        JNI.invokePV(device, __functionAddress);
    }

    public static void nalcCaptureSamples(long device, long buffer, int samples) {
        long __functionAddress = ALC.getICD().alcCaptureSamples;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(device);
        }
        JNI.invokePPV(device, buffer, samples, __functionAddress);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCvoid *") ByteBuffer buffer, @NativeType(value="ALCsizei") int samples) {
        ALC11.nalcCaptureSamples(device, MemoryUtil.memAddress(buffer), samples);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCvoid *") ShortBuffer buffer, @NativeType(value="ALCsizei") int samples) {
        ALC11.nalcCaptureSamples(device, MemoryUtil.memAddress(buffer), samples);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCvoid *") IntBuffer buffer, @NativeType(value="ALCsizei") int samples) {
        ALC11.nalcCaptureSamples(device, MemoryUtil.memAddress(buffer), samples);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCvoid *") FloatBuffer buffer, @NativeType(value="ALCsizei") int samples) {
        ALC11.nalcCaptureSamples(device, MemoryUtil.memAddress(buffer), samples);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCvoid *") short[] buffer, @NativeType(value="ALCsizei") int samples) {
        long __functionAddress = ALC.getICD().alcCaptureSamples;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(device);
        }
        JNI.invokePPV(device, buffer, samples, __functionAddress);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCvoid *") int[] buffer, @NativeType(value="ALCsizei") int samples) {
        long __functionAddress = ALC.getICD().alcCaptureSamples;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(device);
        }
        JNI.invokePPV(device, buffer, samples, __functionAddress);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCvoid *") float[] buffer, @NativeType(value="ALCsizei") int samples) {
        long __functionAddress = ALC.getICD().alcCaptureSamples;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(device);
        }
        JNI.invokePPV(device, buffer, samples, __functionAddress);
    }
}

