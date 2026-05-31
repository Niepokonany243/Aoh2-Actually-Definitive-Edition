/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class DynamicLinkLoader {
    public static final int RTLD_LAZY = 1;
    public static final int RTLD_NOW = 2;
    public static final int RTLD_BINDING_MASK = 3;
    public static final int RTLD_NOLOAD = 4;
    public static final int RTLD_DEEPBIND = 8;
    public static final int RTLD_GLOBAL = 256;
    public static final int RTLD_LOCAL = 0;
    public static final int RTLD_NODELETE = 4096;

    protected DynamicLinkLoader() {
        throw new UnsupportedOperationException();
    }

    public static native long ndlopen(long var0, int var2);

    @NativeType(value="void *")
    public static long dlopen(@Nullable @NativeType(value="char const *") ByteBuffer filename, int mode) {
        if (Checks.CHECKS) {
            Checks.checkNT1Safe(filename);
        }
        return DynamicLinkLoader.ndlopen(MemoryUtil.memAddressSafe(filename), mode);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void *")
    public static long dlopen(@Nullable @NativeType(value="char const *") CharSequence filename, int mode) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCIISafe(filename, true);
            long filenameEncoded = filename == null ? 0L : stack.getPointerAddress();
            long l = DynamicLinkLoader.ndlopen(filenameEncoded, mode);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native long ndlerror();

    @Nullable
    @NativeType(value="char *")
    public static String dlerror() {
        long __result = DynamicLinkLoader.ndlerror();
        return MemoryUtil.memASCIISafe(__result);
    }

    public static native long ndlsym(long var0, long var2);

    @NativeType(value="void *")
    public static long dlsym(@NativeType(value="void *") long handle, @NativeType(value="char const *") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.check(handle);
            Checks.checkNT1(name);
        }
        return DynamicLinkLoader.ndlsym(handle, MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void *")
    public static long dlsym(@NativeType(value="void *") long handle, @NativeType(value="char const *") CharSequence name) {
        if (Checks.CHECKS) {
            Checks.check(handle);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(name, true);
            long nameEncoded = stack.getPointerAddress();
            long l = DynamicLinkLoader.ndlsym(handle, nameEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native int ndlclose(long var0);

    public static int dlclose(@NativeType(value="void *") long handle) {
        if (Checks.CHECKS) {
            Checks.check(handle);
        }
        return DynamicLinkLoader.ndlclose(handle);
    }

    static {
        Library.initialize();
    }
}

