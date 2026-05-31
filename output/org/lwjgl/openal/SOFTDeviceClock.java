/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import java.nio.LongBuffer;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class SOFTDeviceClock {
    public static final int ALC_DEVICE_CLOCK_SOFT = 5632;
    public static final int ALC_DEVICE_LATENCY_SOFT = 5633;
    public static final int ALC_DEVICE_CLOCK_LATENCY_SOFT = 5634;
    public static final int AL_SAMPLE_OFFSET_CLOCK_SOFT = 4610;
    public static final int AL_SEC_OFFSET_CLOCK_SOFT = 4611;

    protected SOFTDeviceClock() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(ALCCapabilities caps) {
        return Checks.checkFunctions(caps.alcGetInteger64vSOFT);
    }

    public static void nalcGetInteger64vSOFT(long device, int pname, int size, long values) {
        long __functionAddress = ALC.getICD().alcGetInteger64vSOFT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.invokePPV(device, pname, size, values, __functionAddress);
    }

    @NativeType(value="ALCvoid")
    public static void alcGetInteger64vSOFT(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCenum") int pname, @NativeType(value="ALCint64SOFT *") LongBuffer values) {
        SOFTDeviceClock.nalcGetInteger64vSOFT(device, pname, values.remaining(), MemoryUtil.memAddress(values));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALCvoid")
    public static long alcGetInteger64vSOFT(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer values = stack.callocLong(1);
            SOFTDeviceClock.nalcGetInteger64vSOFT(device, pname, 1, MemoryUtil.memAddress(values));
            long l = values.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="ALCvoid")
    public static void alcGetInteger64vSOFT(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCenum") int pname, @NativeType(value="ALCint64SOFT *") long[] values) {
        long __functionAddress = ALC.getICD().alcGetInteger64vSOFT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.invokePPV(device, pname, values.length, values, __functionAddress);
    }
}

