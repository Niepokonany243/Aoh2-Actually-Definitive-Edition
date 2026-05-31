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

public class LibCStdio {
    public static final long sscanf;
    public static final long sprintf;
    public static final long snprintf;

    protected LibCStdio() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="void *")
    private static native long sscanf();

    public static native int nvsscanf(long var0, long var2, long var4);

    public static int vsscanf(@NativeType(value="char const *") ByteBuffer buffer, @NativeType(value="char const *") ByteBuffer format, @NativeType(value="va_list") long vlist) {
        if (Checks.CHECKS) {
            Checks.checkNT1(buffer);
            Checks.checkNT1(format);
            Checks.check(vlist);
        }
        return LibCStdio.nvsscanf(MemoryUtil.memAddress(buffer), MemoryUtil.memAddress(format), vlist);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int vsscanf(@NativeType(value="char const *") CharSequence buffer, @NativeType(value="char const *") CharSequence format, @NativeType(value="va_list") long vlist) {
        if (Checks.CHECKS) {
            Checks.check(vlist);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(buffer, true);
            long bufferEncoded = stack.getPointerAddress();
            stack.nASCII(format, true);
            long formatEncoded = stack.getPointerAddress();
            int n = LibCStdio.nvsscanf(bufferEncoded, formatEncoded, vlist);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="void *")
    private static native long sprintf();

    @NativeType(value="void *")
    private static native long snprintf();

    public static native int nvsnprintf(long var0, long var2, long var4, long var6);

    public static int vsnprintf(@Nullable @NativeType(value="char *") ByteBuffer buffer, @NativeType(value="char const *") ByteBuffer format, @NativeType(value="va_list") long vlist) {
        if (Checks.CHECKS) {
            Checks.checkNT1(format);
            Checks.check(vlist);
        }
        return LibCStdio.nvsnprintf(MemoryUtil.memAddressSafe(buffer), Checks.remainingSafe(buffer), MemoryUtil.memAddress(format), vlist);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int vsnprintf(@Nullable @NativeType(value="char *") ByteBuffer buffer, @NativeType(value="char const *") CharSequence format, @NativeType(value="va_list") long vlist) {
        if (Checks.CHECKS) {
            Checks.check(vlist);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(format, true);
            long formatEncoded = stack.getPointerAddress();
            int n = LibCStdio.nvsnprintf(MemoryUtil.memAddressSafe(buffer), Checks.remainingSafe(buffer), formatEncoded, vlist);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    static {
        Library.initialize();
        sscanf = LibCStdio.sscanf();
        sprintf = LibCStdio.sprintf();
        snprintf = LibCStdio.snprintf();
    }
}

