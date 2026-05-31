/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.openal;

import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class SOFTHRTF {
    public static final int ALC_HRTF_SOFT = 6546;
    public static final int ALC_HRTF_ID_SOFT = 6550;
    public static final int ALC_DONT_CARE_SOFT = 2;
    public static final int ALC_HRTF_STATUS_SOFT = 6547;
    public static final int ALC_NUM_HRTF_SPECIFIERS_SOFT = 6548;
    public static final int ALC_HRTF_SPECIFIER_SOFT = 6549;
    public static final int ALC_HRTF_DISABLED_SOFT = 0;
    public static final int ALC_HRTF_ENABLED_SOFT = 1;
    public static final int ALC_HRTF_DENIED_SOFT = 2;
    public static final int ALC_HRTF_REQUIRED_SOFT = 3;
    public static final int ALC_HRTF_HEADPHONES_DETECTED_SOFT = 4;
    public static final int ALC_HRTF_UNSUPPORTED_FORMAT_SOFT = 5;

    protected SOFTHRTF() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(ALCCapabilities caps) {
        return Checks.checkFunctions(caps.alcGetStringiSOFT, caps.alcResetDeviceSOFT);
    }

    public static long nalcGetStringiSOFT(long device, int paramName, int index) {
        long __functionAddress = ALC.getICD().alcGetStringiSOFT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(device);
        }
        return JNI.invokePP(device, paramName, index, __functionAddress);
    }

    @Nullable
    @NativeType(value="ALCchar const *")
    public static String alcGetStringiSOFT(@NativeType(value="ALCdevice *") long device, @NativeType(value="ALCenum") int paramName, @NativeType(value="ALCsizei") int index) {
        long __result = SOFTHRTF.nalcGetStringiSOFT(device, paramName, index);
        return MemoryUtil.memUTF8Safe(__result);
    }

    public static boolean nalcResetDeviceSOFT(long device, long attrList) {
        long __functionAddress = ALC.getICD().alcResetDeviceSOFT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(device);
        }
        return JNI.invokePPZ(device, attrList, __functionAddress);
    }

    @NativeType(value="ALCboolean")
    public static boolean alcResetDeviceSOFT(@NativeType(value="ALCdevice *") long device, @Nullable @NativeType(value="ALCint const *") IntBuffer attrList) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(attrList);
        }
        return SOFTHRTF.nalcResetDeviceSOFT(device, MemoryUtil.memAddressSafe(attrList));
    }

    @NativeType(value="ALCboolean")
    public static boolean alcResetDeviceSOFT(@NativeType(value="ALCdevice *") long device, @Nullable @NativeType(value="ALCint const *") int[] attrList) {
        long __functionAddress = ALC.getICD().alcResetDeviceSOFT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(device);
            Checks.checkNTSafe(attrList);
        }
        return JNI.invokePPZ(device, attrList, __functionAddress);
    }
}

