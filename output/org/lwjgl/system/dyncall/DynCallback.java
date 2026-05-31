/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.dyncall;

import java.nio.ByteBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class DynCallback {
    public static final char DCB_SIGCHAR_CC_PREFIX = '_';
    public static final char DCB_SIGCHAR_CC_ELLIPSIS = 'e';
    public static final char DCB_SIGCHAR_CC_STDCALL = 's';
    public static final char DCB_SIGCHAR_CC_FASTCALL_GNU = 'f';
    public static final char DCB_SIGCHAR_CC_FASTCALL_MS = 'F';
    public static final char DCB_SIGCHAR_CC_THISCALL_MS = '+';

    protected DynCallback() {
        throw new UnsupportedOperationException();
    }

    public static native long ndcbNewCallback(long var0, long var2, long var4);

    @NativeType(value="DCCallback *")
    public static long dcbNewCallback(@NativeType(value="char const *") ByteBuffer signature, @NativeType(value="DCCallbackHandler *") long funcptr, @NativeType(value="void *") long userdata) {
        if (Checks.CHECKS) {
            Checks.checkNT1(signature);
            Checks.check(funcptr);
            Checks.check(userdata);
        }
        return DynCallback.ndcbNewCallback(MemoryUtil.memAddress(signature), funcptr, userdata);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="DCCallback *")
    public static long dcbNewCallback(@NativeType(value="char const *") CharSequence signature, @NativeType(value="DCCallbackHandler *") long funcptr, @NativeType(value="void *") long userdata) {
        if (Checks.CHECKS) {
            Checks.check(funcptr);
            Checks.check(userdata);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(signature, true);
            long signatureEncoded = stack.getPointerAddress();
            long l = DynCallback.ndcbNewCallback(signatureEncoded, funcptr, userdata);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void ndcbInitCallback(long var0, long var2, long var4, long var6);

    public static void dcbInitCallback(@NativeType(value="DCCallback *") long pcb, @NativeType(value="char const *") ByteBuffer signature, @NativeType(value="DCCallbackHandler *") long handler, @NativeType(value="void *") long userdata) {
        if (Checks.CHECKS) {
            Checks.check(pcb);
            Checks.checkNT1(signature);
            Checks.check(handler);
            Checks.check(userdata);
        }
        DynCallback.ndcbInitCallback(pcb, MemoryUtil.memAddress(signature), handler, userdata);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void dcbInitCallback(@NativeType(value="DCCallback *") long pcb, @NativeType(value="char const *") CharSequence signature, @NativeType(value="DCCallbackHandler *") long handler, @NativeType(value="void *") long userdata) {
        if (Checks.CHECKS) {
            Checks.check(pcb);
            Checks.check(handler);
            Checks.check(userdata);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(signature, true);
            long signatureEncoded = stack.getPointerAddress();
            DynCallback.ndcbInitCallback(pcb, signatureEncoded, handler, userdata);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void ndcbFreeCallback(long var0);

    public static void dcbFreeCallback(@NativeType(value="DCCallback *") long pcb) {
        if (Checks.CHECKS) {
            Checks.check(pcb);
        }
        DynCallback.ndcbFreeCallback(pcb);
    }

    public static native long ndcbGetUserData(long var0);

    @NativeType(value="void *")
    public static long dcbGetUserData(@NativeType(value="DCCallback *") long pcb) {
        if (Checks.CHECKS) {
            Checks.check(pcb);
        }
        return DynCallback.ndcbGetUserData(pcb);
    }

    public static native int ndcbArgBool(long var0);

    @NativeType(value="DCbool")
    public static boolean dcbArgBool(@NativeType(value="DCArgs *") long args) {
        if (Checks.CHECKS) {
            Checks.check(args);
        }
        return DynCallback.ndcbArgBool(args) != 0;
    }

    public static native byte ndcbArgChar(long var0);

    @NativeType(value="DCchar")
    public static byte dcbArgChar(@NativeType(value="DCArgs *") long args) {
        if (Checks.CHECKS) {
            Checks.check(args);
        }
        return DynCallback.ndcbArgChar(args);
    }

    public static native short ndcbArgShort(long var0);

    @NativeType(value="DCshort")
    public static short dcbArgShort(@NativeType(value="DCArgs *") long args) {
        if (Checks.CHECKS) {
            Checks.check(args);
        }
        return DynCallback.ndcbArgShort(args);
    }

    public static native int ndcbArgInt(long var0);

    @NativeType(value="DCint")
    public static int dcbArgInt(@NativeType(value="DCArgs *") long args) {
        if (Checks.CHECKS) {
            Checks.check(args);
        }
        return DynCallback.ndcbArgInt(args);
    }

    public static native long ndcbArgLong(long var0);

    @NativeType(value="DClong")
    public static long dcbArgLong(@NativeType(value="DCArgs *") long args) {
        if (Checks.CHECKS) {
            Checks.check(args);
        }
        return DynCallback.ndcbArgLong(args);
    }

    public static native long ndcbArgLongLong(long var0);

    @NativeType(value="DClonglong")
    public static long dcbArgLongLong(@NativeType(value="DCArgs *") long args) {
        if (Checks.CHECKS) {
            Checks.check(args);
        }
        return DynCallback.ndcbArgLongLong(args);
    }

    public static native byte ndcbArgUChar(long var0);

    @NativeType(value="DCchar")
    public static byte dcbArgUChar(@NativeType(value="DCArgs *") long args) {
        if (Checks.CHECKS) {
            Checks.check(args);
        }
        return DynCallback.ndcbArgUChar(args);
    }

    public static native short ndcbArgUShort(long var0);

    @NativeType(value="DCshort")
    public static short dcbArgUShort(@NativeType(value="DCArgs *") long args) {
        if (Checks.CHECKS) {
            Checks.check(args);
        }
        return DynCallback.ndcbArgUShort(args);
    }

    public static native int ndcbArgUInt(long var0);

    @NativeType(value="DCint")
    public static int dcbArgUInt(@NativeType(value="DCArgs *") long args) {
        if (Checks.CHECKS) {
            Checks.check(args);
        }
        return DynCallback.ndcbArgUInt(args);
    }

    public static native long ndcbArgULong(long var0);

    @NativeType(value="DClong")
    public static long dcbArgULong(@NativeType(value="DCArgs *") long args) {
        if (Checks.CHECKS) {
            Checks.check(args);
        }
        return DynCallback.ndcbArgULong(args);
    }

    public static native long ndcbArgULongLong(long var0);

    @NativeType(value="DClonglong")
    public static long dcbArgULongLong(@NativeType(value="DCArgs *") long args) {
        if (Checks.CHECKS) {
            Checks.check(args);
        }
        return DynCallback.ndcbArgULongLong(args);
    }

    public static native float ndcbArgFloat(long var0);

    @NativeType(value="DCfloat")
    public static float dcbArgFloat(@NativeType(value="DCArgs *") long args) {
        if (Checks.CHECKS) {
            Checks.check(args);
        }
        return DynCallback.ndcbArgFloat(args);
    }

    public static native double ndcbArgDouble(long var0);

    @NativeType(value="DCdouble")
    public static double dcbArgDouble(@NativeType(value="DCArgs *") long args) {
        if (Checks.CHECKS) {
            Checks.check(args);
        }
        return DynCallback.ndcbArgDouble(args);
    }

    public static native long ndcbArgPointer(long var0);

    @NativeType(value="DCpointer")
    public static long dcbArgPointer(@NativeType(value="DCArgs *") long args) {
        if (Checks.CHECKS) {
            Checks.check(args);
        }
        return DynCallback.ndcbArgPointer(args);
    }

    static {
        Library.initialize();
    }
}

