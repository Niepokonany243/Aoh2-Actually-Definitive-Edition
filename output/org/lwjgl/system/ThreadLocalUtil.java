/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.jni.JNINativeInterface;

public final class ThreadLocalUtil {
    private static final long JNI_NATIVE_INTERFACE;
    private static final long FUNCTION_MISSING_ABORT;
    private static final long SIZE_OF_JNI_NATIVE_INTERFACE;

    private ThreadLocalUtil() {
    }

    private static native long getThreadJNIEnv();

    private static native void setThreadJNIEnv(long var0);

    private static native long getFunctionMissingAbort();

    public static void setEnv(long capabilities, int index) {
        if (index < 0 || 3 < index) {
            throw new IndexOutOfBoundsException();
        }
        long env = ThreadLocalUtil.getThreadJNIEnv();
        if (capabilities == 0L) {
            if (env != JNI_NATIVE_INTERFACE) {
                ThreadLocalUtil.setThreadJNIEnv(JNI_NATIVE_INTERFACE);
                MemoryUtil.nmemFree(env);
            }
        } else {
            if (env == JNI_NATIVE_INTERFACE) {
                long newEnv = MemoryUtil.nmemAllocChecked(SIZE_OF_JNI_NATIVE_INTERFACE);
                MemoryUtil.memCopy(env, newEnv, SIZE_OF_JNI_NATIVE_INTERFACE);
                env = newEnv;
                ThreadLocalUtil.setThreadJNIEnv(env);
            }
            MemoryUtil.memPutAddress(env + Integer.toUnsignedLong(index) * (long)Pointer.POINTER_SIZE, capabilities);
        }
    }

    private static List<Field> getFieldsFromCapabilities(Class<?> capabilitiesClass) {
        ArrayList<Field> fields = new ArrayList<Field>();
        for (Field field : capabilitiesClass.getFields()) {
            if (field.getType() != Long.TYPE) continue;
            fields.add(field);
        }
        return fields;
    }

    public static void setFunctionMissingAddresses(@Nullable Class<?> capabilitiesClass, int index) {
        if (capabilitiesClass == null) {
            long missingCaps = MemoryUtil.memGetAddress(JNI_NATIVE_INTERFACE + Integer.toUnsignedLong(index) * (long)Pointer.POINTER_SIZE);
            if (missingCaps != 0L) {
                MemoryUtil.getAllocator().free(missingCaps);
                MemoryUtil.memPutAddress(JNI_NATIVE_INTERFACE + Integer.toUnsignedLong(index) * (long)Pointer.POINTER_SIZE, 0L);
            }
        } else {
            int functionCount = ThreadLocalUtil.getFieldsFromCapabilities(capabilitiesClass).size();
            long missingCaps = MemoryUtil.getAllocator().malloc(Integer.toUnsignedLong(functionCount) * (long)Pointer.POINTER_SIZE);
            for (int i = 0; i < functionCount; ++i) {
                MemoryUtil.memPutAddress(missingCaps + Integer.toUnsignedLong(i) * (long)Pointer.POINTER_SIZE, FUNCTION_MISSING_ABORT);
            }
            MemoryUtil.memPutAddress(JNI_NATIVE_INTERFACE + Integer.toUnsignedLong(index) * (long)Pointer.POINTER_SIZE, missingCaps);
        }
    }

    public static PointerBuffer getAddressesFromCapabilities(Object caps) {
        List<Field> fields = ThreadLocalUtil.getFieldsFromCapabilities(caps.getClass());
        PointerBuffer addresses = BufferUtils.createPointerBuffer(fields.size());
        try {
            for (int i = 0; i < fields.size(); ++i) {
                long a = fields.get(i).getLong(caps);
                addresses.put(i, a != 0L ? a : FUNCTION_MISSING_ABORT);
            }
        }
        catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return addresses;
    }

    public static boolean areCapabilitiesDifferent(PointerBuffer ref, PointerBuffer caps) {
        for (int i = 0; i < ref.remaining(); ++i) {
            if (ref.get(i) == caps.get(i) || caps.get(i) == 0L) continue;
            return true;
        }
        return false;
    }

    static {
        int jniCallCount;
        int reservedCount;
        JNI_NATIVE_INTERFACE = ThreadLocalUtil.getThreadJNIEnv();
        FUNCTION_MISSING_ABORT = ThreadLocalUtil.getFunctionMissingAbort();
        int JNI_VERSION = JNINativeInterface.GetVersion();
        switch (JNI_VERSION) {
            case 65537: {
                reservedCount = 12;
                break;
            }
            default: {
                reservedCount = 4;
            }
        }
        switch (JNI_VERSION) {
            case 65537: {
                jniCallCount = 208;
                break;
            }
            case 65538: {
                jniCallCount = 225;
                break;
            }
            case 65540: {
                jniCallCount = 228;
                break;
            }
            case 65542: 
            case 65544: {
                jniCallCount = 229;
                break;
            }
            case 589824: 
            case 655360: {
                jniCallCount = 230;
                break;
            }
            default: {
                jniCallCount = 230;
                APIUtil.DEBUG_STREAM.println("[LWJGL] [ThreadLocalUtil] Unsupported JNI version detected, this may result in a crash. Please inform LWJGL developers.");
            }
        }
        SIZE_OF_JNI_NATIVE_INTERFACE = Integer.toUnsignedLong(reservedCount + jniCallCount) * (long)Pointer.POINTER_SIZE;
    }
}

