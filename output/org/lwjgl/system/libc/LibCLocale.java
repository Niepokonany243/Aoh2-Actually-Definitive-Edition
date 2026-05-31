/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.libc;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class LibCLocale {
    public static final int LC_ALL;
    public static final int LC_COLLATE;
    public static final int LC_CTYPE;
    public static final int LC_MONETARY;
    public static final int LC_NUMERIC;
    public static final int LC_TIME;

    protected LibCLocale() {
        throw new UnsupportedOperationException();
    }

    private static native int LC_ALL();

    private static native int LC_COLLATE();

    private static native int LC_CTYPE();

    private static native int LC_MONETARY();

    private static native int LC_NUMERIC();

    private static native int LC_TIME();

    public static native long nsetlocale(int var0, long var1);

    @Nullable
    @NativeType(value="char *")
    public static String setlocale(int category, @NativeType(value="char const *") ByteBuffer locale) {
        if (Checks.CHECKS) {
            Checks.checkNT1(locale);
        }
        long __result = LibCLocale.nsetlocale(category, MemoryUtil.memAddress(locale));
        return MemoryUtil.memASCIISafe(__result);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="char *")
    public static String setlocale(int category, @NativeType(value="char const *") CharSequence locale) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(locale, true);
            long localeEncoded = stack.getPointerAddress();
            long __result = LibCLocale.nsetlocale(category, localeEncoded);
            String string = MemoryUtil.memASCIISafe(__result);
            return string;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    static {
        Library.initialize();
        LC_ALL = LibCLocale.LC_ALL();
        LC_COLLATE = LibCLocale.LC_COLLATE();
        LC_CTYPE = LibCLocale.LC_CTYPE();
        LC_MONETARY = LibCLocale.LC_MONETARY();
        LC_NUMERIC = LibCLocale.LC_NUMERIC();
        LC_TIME = LibCLocale.LC_TIME();
    }
}

