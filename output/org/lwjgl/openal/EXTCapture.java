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
import org.lwjgl.openal.ALC11;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class EXTCapture {
    public static final int ALC_CAPTURE_DEVICE_SPECIFIER = 784;
    public static final int ALC_CAPTURE_DEFAULT_DEVICE_SPECIFIER = 785;
    public static final int ALC_CAPTURE_SAMPLES = 786;

    protected EXTCapture() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(ALCCapabilities caps) {
        return Checks.checkFunctions(caps.alcCaptureOpenDevice, caps.alcCaptureCloseDevice, caps.alcCaptureStart, caps.alcCaptureStop, caps.alcCaptureSamples);
    }

    public static long nalcCaptureOpenDevice(long deviceName, int frequency, int format, int samples) {
        return ALC11.nalcCaptureOpenDevice(deviceName, frequency, format, samples);
    }

    @NativeType(value="ALCdevice *")
    public static long alcCaptureOpenDevice(@Nullable @NativeType(value="ALCchar const *") ByteBuffer deviceName, @NativeType(value="ALCuint") int frequency, @NativeType(value="ALCenum") int format, @NativeType(value="ALCsizei") int samples) {
        return ALC11.alcCaptureOpenDevice(deviceName, frequency, format, samples);
    }

    @NativeType(value="ALCdevice *")
    public static long alcCaptureOpenDevice(@Nullable @NativeType(value="ALCchar const *") CharSequence deviceName, @NativeType(value="ALCuint") int frequency, @NativeType(value="ALCenum") int format, @NativeType(value="ALCsizei") int samples) {
        return ALC11.alcCaptureOpenDevice(deviceName, frequency, format, samples);
    }

    @NativeType(value="ALCboolean")
    public static boolean alcCaptureCloseDevice(@NativeType(value="ALCdevice *") long device) {
        return ALC11.alcCaptureCloseDevice(device);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureStart(@NativeType(value="ALCdevice *") long device) {
        ALC11.alcCaptureStart(device);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureStop(@NativeType(value="ALCdevice *") long device) {
        ALC11.alcCaptureStop(device);
    }

    public static void nalcCaptureSamples(long device, long buffer, int samples) {
        ALC11.nalcCaptureSamples(device, buffer, samples);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCvoid *") ByteBuffer buffer, @NativeType(value="ALCsizei") int samples) {
        ALC11.alcCaptureSamples(device, buffer, samples);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCvoid *") ShortBuffer buffer, @NativeType(value="ALCsizei") int samples) {
        ALC11.alcCaptureSamples(device, buffer, samples);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCvoid *") IntBuffer buffer, @NativeType(value="ALCsizei") int samples) {
        ALC11.alcCaptureSamples(device, buffer, samples);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCvoid *") FloatBuffer buffer, @NativeType(value="ALCsizei") int samples) {
        ALC11.alcCaptureSamples(device, buffer, samples);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCvoid *") short[] buffer, @NativeType(value="ALCsizei") int samples) {
        ALC11.alcCaptureSamples(device, buffer, samples);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCvoid *") int[] buffer, @NativeType(value="ALCsizei") int samples) {
        ALC11.alcCaptureSamples(device, buffer, samples);
    }

    @NativeType(value="ALCvoid")
    public static void alcCaptureSamples(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCvoid *") float[] buffer, @NativeType(value="ALCsizei") int samples) {
        ALC11.alcCaptureSamples(device, buffer, samples);
    }
}

