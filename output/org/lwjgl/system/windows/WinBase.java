/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class WinBase {
    public static final int FALSE = 0;
    public static final int TRUE = 1;

    protected WinBase() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="DWORD")
    public static native int GetLastError();

    @NativeType(value="DWORD")
    public static native int getLastError();

    public static native long nGetModuleHandle(long var0);

    @NativeType(value="HMODULE")
    public static long GetModuleHandle(@Nullable @NativeType(value="LPCTSTR") ByteBuffer moduleName) {
        if (Checks.CHECKS) {
            Checks.checkNT2Safe(moduleName);
        }
        return WinBase.nGetModuleHandle(MemoryUtil.memAddressSafe(moduleName));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="HMODULE")
    public static long GetModuleHandle(@Nullable @NativeType(value="LPCTSTR") CharSequence moduleName) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF16Safe(moduleName, true);
            long moduleNameEncoded = moduleName == null ? 0L : stack.getPointerAddress();
            long l = WinBase.nGetModuleHandle(moduleNameEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native long nLoadLibrary(long var0);

    @NativeType(value="HMODULE")
    public static long LoadLibrary(@NativeType(value="LPCTSTR") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.checkNT2(name);
        }
        return WinBase.nLoadLibrary(MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="HMODULE")
    public static long LoadLibrary(@NativeType(value="LPCTSTR") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF16(name, true);
            long nameEncoded = stack.getPointerAddress();
            long l = WinBase.nLoadLibrary(nameEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native long nGetProcAddress(long var0, long var2);

    @NativeType(value="FARPROC")
    public static long GetProcAddress(@NativeType(value="HMODULE") long handle, @NativeType(value="LPCSTR") ByteBuffer name) {
        if (Checks.CHECKS) {
            Checks.check(handle);
            Checks.checkNT1(name);
        }
        return WinBase.nGetProcAddress(handle, MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="FARPROC")
    public static long GetProcAddress(@NativeType(value="HMODULE") long handle, @NativeType(value="LPCSTR") CharSequence name) {
        if (Checks.CHECKS) {
            Checks.check(handle);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(name, true);
            long nameEncoded = stack.getPointerAddress();
            long l = WinBase.nGetProcAddress(handle, nameEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native int nFreeLibrary(long var0);

    @NativeType(value="BOOL")
    public static boolean FreeLibrary(@NativeType(value="HMODULE") long handle) {
        if (Checks.CHECKS) {
            Checks.check(handle);
        }
        return WinBase.nFreeLibrary(handle) != 0;
    }

    static {
        Library.initialize();
    }
}

