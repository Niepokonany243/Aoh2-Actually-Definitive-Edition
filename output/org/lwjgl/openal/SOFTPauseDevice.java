/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class SOFTPauseDevice {
    protected SOFTPauseDevice() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(ALCCapabilities caps) {
        return Checks.checkFunctions(caps.alcDevicePauseSOFT, caps.alcDeviceResumeSOFT);
    }

    @NativeType(value="ALCvoid")
    public static void alcDevicePauseSOFT(@NativeType(value="ALCdevice *") long device) {
        long __functionAddress = ALC.getICD().alcDevicePauseSOFT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(device);
        }
        JNI.invokePV(device, __functionAddress);
    }

    @NativeType(value="ALCvoid")
    public static void alcDeviceResumeSOFT(@NativeType(value="ALCdevice *") long device) {
        long __functionAddress = ALC.getICD().alcDeviceResumeSOFT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(device);
        }
        JNI.invokePV(device, __functionAddress);
    }
}

