/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.dyncall;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class DynLoad {
    protected DynLoad() {
        throw new UnsupportedOperationException();
    }

    public static native long ndlLoadLibrary(long var0);

    @NativeType(value="DLLib *")
    public static long dlLoadLibrary(@NativeType(value="char const *") ByteBuffer libpath) {
        if (Checks.CHECKS) {
            Checks.checkNT1(libpath);
        }
        return DynLoad.ndlLoadLibrary(MemoryUtil.memAddress(libpath));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="DLLib *")
    public static long dlLoadLibrary(@NativeType(value="char const *") CharSequence libpath) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(libpath, true);
            long libpathEncoded = stack.getPointerAddress();
            long l = DynLoad.ndlLoadLibrary(libpathEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void ndlFreeLibrary(long var0);

    public static void dlFreeLibrary(@NativeType(value="DLLib *") long pLib) {
        if (Checks.CHECKS) {
            Checks.check(pLib);
        }
        DynLoad.ndlFreeLibrary(pLib);
    }

    public static native long ndlFindSymbol(long var0, long var2);

    @NativeType(value="void *")
    public static long dlFindSymbol(@NativeType(value="DLLib *") long pLib, @NativeType(value="char const *") ByteBuffer pSymbolName) {
        if (Checks.CHECKS) {
            Checks.check(pLib);
            Checks.checkNT1(pSymbolName);
        }
        return DynLoad.ndlFindSymbol(pLib, MemoryUtil.memAddress(pSymbolName));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void *")
    public static long dlFindSymbol(@NativeType(value="DLLib *") long pLib, @NativeType(value="char const *") CharSequence pSymbolName) {
        if (Checks.CHECKS) {
            Checks.check(pLib);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(pSymbolName, true);
            long pSymbolNameEncoded = stack.getPointerAddress();
            long l = DynLoad.ndlFindSymbol(pLib, pSymbolNameEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native int ndlGetLibraryPath(long var0, long var2, int var4);

    public static int dlGetLibraryPath(@NativeType(value="DLLib *") long pLib, @NativeType(value="char *") ByteBuffer sOut) {
        if (Checks.CHECKS) {
            Checks.check(pLib);
        }
        return DynLoad.ndlGetLibraryPath(pLib, MemoryUtil.memAddress(sOut), sOut.remaining());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="int")
    public static String dlGetLibraryPath(@NativeType(value="DLLib *") long pLib, int bufSize) {
        if (Checks.CHECKS) {
            Checks.check(pLib);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            ByteBuffer sOut = stack.malloc(bufSize);
            int __result = DynLoad.ndlGetLibraryPath(pLib, MemoryUtil.memAddress(sOut), bufSize);
            String string = MemoryUtil.memASCII(sOut, __result - 1);
            return string;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native long ndlSymsInit(long var0);

    @NativeType(value="DLSyms *")
    public static long dlSymsInit(@NativeType(value="char const *") ByteBuffer libPath) {
        if (Checks.CHECKS) {
            Checks.checkNT1(libPath);
        }
        return DynLoad.ndlSymsInit(MemoryUtil.memAddress(libPath));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="DLSyms *")
    public static long dlSymsInit(@NativeType(value="char const *") CharSequence libPath) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(libPath, true);
            long libPathEncoded = stack.getPointerAddress();
            long l = DynLoad.ndlSymsInit(libPathEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void ndlSymsCleanup(long var0);

    public static void dlSymsCleanup(@NativeType(value="DLSyms *") long pSyms) {
        if (Checks.CHECKS) {
            Checks.check(pSyms);
        }
        DynLoad.ndlSymsCleanup(pSyms);
    }

    public static native int ndlSymsCount(long var0);

    public static int dlSymsCount(@NativeType(value="DLSyms *") long pSyms) {
        if (Checks.CHECKS) {
            Checks.check(pSyms);
        }
        return DynLoad.ndlSymsCount(pSyms);
    }

    public static native long ndlSymsName(long var0, int var2);

    @Nullable
    @NativeType(value="char const *")
    public static String dlSymsName(@NativeType(value="DLSyms *") long pSyms, int index) {
        if (Checks.CHECKS) {
            Checks.check(pSyms);
        }
        long __result = DynLoad.ndlSymsName(pSyms, index);
        return MemoryUtil.memASCIISafe(__result);
    }

    public static native long ndlSymsNameFromValue(long var0, long var2);

    @Nullable
    @NativeType(value="char const *")
    public static String dlSymsNameFromValue(@NativeType(value="DLSyms *") long pSyms, @NativeType(value="void *") long value) {
        if (Checks.CHECKS) {
            Checks.check(pSyms);
            Checks.check(value);
        }
        long __result = DynLoad.ndlSymsNameFromValue(pSyms, value);
        return MemoryUtil.memASCIISafe(__result);
    }

    static {
        Library.initialize();
    }
}

