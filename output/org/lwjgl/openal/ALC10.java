/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.openal;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ALC10 {
    public static final int ALC_INVALID = -1;
    public static final int ALC_FALSE = 0;
    public static final int ALC_TRUE = 1;
    public static final int ALC_FREQUENCY = 4103;
    public static final int ALC_REFRESH = 4104;
    public static final int ALC_SYNC = 4105;
    public static final int ALC_NO_ERROR = 0;
    public static final int ALC_INVALID_DEVICE = 40961;
    public static final int ALC_INVALID_CONTEXT = 40962;
    public static final int ALC_INVALID_ENUM = 40963;
    public static final int ALC_INVALID_VALUE = 40964;
    public static final int ALC_OUT_OF_MEMORY = 40965;
    public static final int ALC_DEFAULT_DEVICE_SPECIFIER = 4100;
    public static final int ALC_DEVICE_SPECIFIER = 4101;
    public static final int ALC_EXTENSIONS = 4102;
    public static final int ALC_MAJOR_VERSION = 4096;
    public static final int ALC_MINOR_VERSION = 4097;
    public static final int ALC_ATTRIBUTES_SIZE = 4098;
    public static final int ALC_ALL_ATTRIBUTES = 4099;

    protected ALC10() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(ALCCapabilities caps) {
        return Checks.checkFunctions(caps.alcOpenDevice, caps.alcCloseDevice, caps.alcCreateContext, caps.alcMakeContextCurrent, caps.alcProcessContext, caps.alcSuspendContext, caps.alcDestroyContext, caps.alcGetCurrentContext, caps.alcGetContextsDevice, caps.alcIsExtensionPresent, caps.alcGetProcAddress, caps.alcGetEnumValue, caps.alcGetError, caps.alcGetString, caps.alcGetIntegerv);
    }

    public static long nalcOpenDevice(long deviceSpecifier) {
        long __functionAddress = ALC.getICD().alcOpenDevice;
        return JNI.invokePP(deviceSpecifier, __functionAddress);
    }

    @NativeType(value="ALCdevice *")
    public static long alcOpenDevice(@Nullable @NativeType(value="ALCchar const *") ByteBuffer deviceSpecifier) {
        if (Checks.CHECKS) {
            Checks.checkNT1Safe(deviceSpecifier);
        }
        return ALC10.nalcOpenDevice(MemoryUtil.memAddressSafe(deviceSpecifier));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALCdevice *")
    public static long alcOpenDevice(@Nullable @NativeType(value="ALCchar const *") CharSequence deviceSpecifier) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8Safe(deviceSpecifier, true);
            long deviceSpecifierEncoded = deviceSpecifier == null ? 0L : stack.getPointerAddress();
            long l = ALC10.nalcOpenDevice(deviceSpecifierEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="ALCboolean")
    public static boolean alcCloseDevice(@NativeType(value="ALCdevice const *") long deviceHandle) {
        long __functionAddress = ALC.getICD().alcCloseDevice;
        if (Checks.CHECKS) {
            Checks.check(deviceHandle);
        }
        return JNI.invokePZ(deviceHandle, __functionAddress);
    }

    public static long nalcCreateContext(long deviceHandle, long attrList) {
        long __functionAddress = ALC.getICD().alcCreateContext;
        if (Checks.CHECKS) {
            Checks.check(deviceHandle);
        }
        return JNI.invokePPP(deviceHandle, attrList, __functionAddress);
    }

    @NativeType(value="ALCcontext *")
    public static long alcCreateContext(@NativeType(value="ALCdevice const *") long deviceHandle, @Nullable @NativeType(value="ALCint const *") IntBuffer attrList) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(attrList);
        }
        return ALC10.nalcCreateContext(deviceHandle, MemoryUtil.memAddressSafe(attrList));
    }

    @NativeType(value="ALCboolean")
    public static boolean alcMakeContextCurrent(@NativeType(value="ALCcontext *") long context) {
        long __functionAddress = ALC.getICD().alcMakeContextCurrent;
        return JNI.invokePZ(context, __functionAddress);
    }

    @NativeType(value="ALCvoid")
    public static void alcProcessContext(@NativeType(value="ALCcontext *") long context) {
        long __functionAddress = ALC.getICD().alcProcessContext;
        if (Checks.CHECKS) {
            Checks.check(context);
        }
        JNI.invokePV(context, __functionAddress);
    }

    @NativeType(value="ALCvoid")
    public static void alcSuspendContext(@NativeType(value="ALCcontext *") long context) {
        long __functionAddress = ALC.getICD().alcSuspendContext;
        if (Checks.CHECKS) {
            Checks.check(context);
        }
        JNI.invokePV(context, __functionAddress);
    }

    @NativeType(value="ALCvoid")
    public static void alcDestroyContext(@NativeType(value="ALCcontext *") long context) {
        long __functionAddress = ALC.getICD().alcDestroyContext;
        if (Checks.CHECKS) {
            Checks.check(context);
        }
        JNI.invokePV(context, __functionAddress);
    }

    @NativeType(value="ALCcontext *")
    public static long alcGetCurrentContext() {
        long __functionAddress = ALC.getICD().alcGetCurrentContext;
        return JNI.invokeP(__functionAddress);
    }

    @NativeType(value="ALCdevice *")
    public static long alcGetContextsDevice(@NativeType(value="ALCcontext *") long context) {
        long __functionAddress = ALC.getICD().alcGetContextsDevice;
        if (Checks.CHECKS) {
            Checks.check(context);
        }
        return JNI.invokePP(context, __functionAddress);
    }

    public static boolean nalcIsExtensionPresent(long deviceHandle, long extName) {
        long __functionAddress = ALC.getICD().alcIsExtensionPresent;
        return JNI.invokePPZ(deviceHandle, extName, __functionAddress);
    }

    @NativeType(value="ALCboolean")
    public static boolean alcIsExtensionPresent(@NativeType(value="ALCdevice const *") long deviceHandle, @NativeType(value="ALCchar const *") ByteBuffer extName) {
        if (Checks.CHECKS) {
            Checks.checkNT1(extName);
        }
        return ALC10.nalcIsExtensionPresent(deviceHandle, MemoryUtil.memAddress(extName));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALCboolean")
    public static boolean alcIsExtensionPresent(@NativeType(value="ALCdevice const *") long deviceHandle, @NativeType(value="ALCchar const *") CharSequence extName) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(extName, true);
            long extNameEncoded = stack.getPointerAddress();
            boolean bl = ALC10.nalcIsExtensionPresent(deviceHandle, extNameEncoded);
            return bl;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nalcGetProcAddress(long deviceHandle, long funcName) {
        long __functionAddress = ALC.getICD().alcGetProcAddress;
        return JNI.invokePPP(deviceHandle, funcName, __functionAddress);
    }

    @NativeType(value="void *")
    public static long alcGetProcAddress(@NativeType(value="ALCdevice const *") long deviceHandle, @NativeType(value="ALchar const *") ByteBuffer funcName) {
        if (Checks.CHECKS) {
            Checks.checkNT1(funcName);
        }
        return ALC10.nalcGetProcAddress(deviceHandle, MemoryUtil.memAddress(funcName));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void *")
    public static long alcGetProcAddress(@NativeType(value="ALCdevice const *") long deviceHandle, @NativeType(value="ALchar const *") CharSequence funcName) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(funcName, true);
            long funcNameEncoded = stack.getPointerAddress();
            long l = ALC10.nalcGetProcAddress(deviceHandle, funcNameEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static int nalcGetEnumValue(long deviceHandle, long enumName) {
        long __functionAddress = ALC.getICD().alcGetEnumValue;
        return JNI.invokePPI(deviceHandle, enumName, __functionAddress);
    }

    @NativeType(value="ALCenum")
    public static int alcGetEnumValue(@NativeType(value="ALCdevice const *") long deviceHandle, @NativeType(value="ALCchar const *") ByteBuffer enumName) {
        if (Checks.CHECKS) {
            Checks.checkNT1(enumName);
        }
        return ALC10.nalcGetEnumValue(deviceHandle, MemoryUtil.memAddress(enumName));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALCenum")
    public static int alcGetEnumValue(@NativeType(value="ALCdevice const *") long deviceHandle, @NativeType(value="ALCchar const *") CharSequence enumName) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(enumName, true);
            long enumNameEncoded = stack.getPointerAddress();
            int n = ALC10.nalcGetEnumValue(deviceHandle, enumNameEncoded);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="ALCenum")
    public static int alcGetError(@NativeType(value="ALCdevice *") long deviceHandle) {
        long __functionAddress = ALC.getICD().alcGetError;
        return JNI.invokePI(deviceHandle, __functionAddress);
    }

    public static long nalcGetString(long deviceHandle, int token) {
        long __functionAddress = ALC.getICD().alcGetString;
        return JNI.invokePP(deviceHandle, token, __functionAddress);
    }

    @Nullable
    @NativeType(value="ALCchar const *")
    public static String alcGetString(@NativeType(value="ALCdevice *") long deviceHandle, @NativeType(value="ALCenum") int token) {
        long __result = ALC10.nalcGetString(deviceHandle, token);
        return MemoryUtil.memUTF8Safe(__result);
    }

    public static void nalcGetIntegerv(long deviceHandle, int token, int size, long dest) {
        long __functionAddress = ALC.getICD().alcGetIntegerv;
        JNI.invokePPV(deviceHandle, token, size, dest, __functionAddress);
    }

    @NativeType(value="ALCvoid")
    public static void alcGetIntegerv(@NativeType(value="ALCdevice *") long deviceHandle, @NativeType(value="ALCenum") int token, @NativeType(value="ALCint *") IntBuffer dest) {
        ALC10.nalcGetIntegerv(deviceHandle, token, dest.remaining(), MemoryUtil.memAddress(dest));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALCvoid")
    public static int alcGetInteger(@NativeType(value="ALCdevice *") long deviceHandle, @NativeType(value="ALCenum") int token) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer dest = stack.callocInt(1);
            ALC10.nalcGetIntegerv(deviceHandle, token, 1, MemoryUtil.memAddress(dest));
            int n = dest.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="ALCcontext *")
    public static long alcCreateContext(@NativeType(value="ALCdevice const *") long deviceHandle, @Nullable @NativeType(value="ALCint const *") int[] attrList) {
        long __functionAddress = ALC.getICD().alcCreateContext;
        if (Checks.CHECKS) {
            Checks.check(deviceHandle);
            Checks.checkNTSafe(attrList);
        }
        return JNI.invokePPP(deviceHandle, attrList, __functionAddress);
    }

    @NativeType(value="ALCvoid")
    public static void alcGetIntegerv(@NativeType(value="ALCdevice *") long deviceHandle, @NativeType(value="ALCenum") int token, @NativeType(value="ALCint *") int[] dest) {
        long __functionAddress = ALC.getICD().alcGetIntegerv;
        JNI.invokePPV(deviceHandle, token, dest.length, dest, __functionAddress);
    }
}

