/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.lang.reflect.Method;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.CallbackI;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.MemoryManage;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.Platform;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.dyncall.DynCallback;
import org.lwjgl.system.jni.JNINativeInterface;

public abstract class Callback
implements Pointer,
NativeResource {
    private static final boolean DEBUG_ALLOCATOR = Configuration.DEBUG_MEMORY_ALLOCATOR.get(false);
    private static final long VOID;
    private static final long BOOLEAN;
    private static final long BYTE;
    private static final long SHORT;
    private static final long INT;
    private static final long LONG;
    private static final long CLONG;
    private static final long FLOAT;
    private static final long DOUBLE;
    private static final long PTR;
    private long address;

    protected Callback(String signature) {
        this.address = Callback.create(signature, this);
    }

    protected Callback(long address) {
        if (Checks.CHECKS) {
            Checks.check(address);
        }
        this.address = address;
    }

    @Override
    public long address() {
        return this.address;
    }

    @Override
    public void free() {
        Callback.free(this.address());
    }

    private static native long getNativeCallbacks(Method[] var0, long var1);

    public static String __stdcall(String signature) {
        return Platform.get() == Platform.WINDOWS && Pointer.BITS32 ? "_s" + signature : signature;
    }

    static long create(String signature, Object instance) {
        long funcptr = Callback.getNativeFunction(signature.charAt(signature.length() - 1));
        long handle = DynCallback.dcbNewCallback(signature, funcptr, JNINativeInterface.NewGlobalRef(instance));
        if (handle == 0L) {
            throw new IllegalStateException("Failed to create the DCCallback object");
        }
        if (DEBUG_ALLOCATOR) {
            MemoryManage.DebugAllocator.track(handle, 2L * (long)POINTER_SIZE);
        }
        return handle;
    }

    private static long getNativeFunction(char type) {
        switch (type) {
            case 'v': {
                return VOID;
            }
            case 'B': {
                return BOOLEAN;
            }
            case 'c': {
                return BYTE;
            }
            case 's': {
                return SHORT;
            }
            case 'i': {
                return INT;
            }
            case 'l': {
                return LONG;
            }
            case 'j': {
                return CLONG;
            }
            case 'p': {
                return PTR;
            }
            case 'f': {
                return FLOAT;
            }
            case 'd': {
                return DOUBLE;
            }
        }
        throw new IllegalArgumentException();
    }

    public static <T extends CallbackI> T get(long functionPointer) {
        return (T)((CallbackI)MemoryUtil.memGlobalRefToObject(DynCallback.dcbGetUserData(functionPointer)));
    }

    @Nullable
    public static <T extends CallbackI> T getSafe(long functionPointer) {
        return functionPointer == 0L ? null : (T)Callback.get(functionPointer);
    }

    public static void free(long functionPointer) {
        if (DEBUG_ALLOCATOR) {
            MemoryManage.DebugAllocator.untrack(functionPointer);
        }
        JNINativeInterface.DeleteGlobalRef(DynCallback.dcbGetUserData(functionPointer));
        DynCallback.dcbFreeCallback(functionPointer);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Callback)) {
            return false;
        }
        Callback that = (Callback)o;
        return this.address == that.address();
    }

    public int hashCode() {
        return (int)(this.address ^ this.address >>> 32);
    }

    public String toString() {
        return String.format("%s pointer [0x%X]", this.getClass().getSimpleName(), this.address);
    }

    static {
        try (MemoryStack stack = MemoryStack.stackPush();){
            Class[] params = new Class[]{Long.TYPE};
            Method[] methods = new Method[]{CallbackI.V.class.getDeclaredMethod("callback", params), CallbackI.Z.class.getDeclaredMethod("callback", params), CallbackI.B.class.getDeclaredMethod("callback", params), CallbackI.S.class.getDeclaredMethod("callback", params), CallbackI.I.class.getDeclaredMethod("callback", params), CallbackI.J.class.getDeclaredMethod("callback", params), CallbackI.N.class.getDeclaredMethod("callback", params), CallbackI.F.class.getDeclaredMethod("callback", params), CallbackI.D.class.getDeclaredMethod("callback", params), CallbackI.P.class.getDeclaredMethod("callback", params)};
            PointerBuffer callbacks = stack.mallocPointer(methods.length);
            Callback.getNativeCallbacks(methods, MemoryUtil.memAddress(callbacks));
            VOID = callbacks.get();
            BOOLEAN = callbacks.get();
            BYTE = callbacks.get();
            SHORT = callbacks.get();
            INT = callbacks.get();
            LONG = callbacks.get();
            CLONG = callbacks.get();
            FLOAT = callbacks.get();
            DOUBLE = callbacks.get();
            PTR = callbacks.get();
        }
        catch (Exception e) {
            throw new IllegalStateException("Failed to initialize native callbacks.", e);
        }
        MemoryUtil.getAllocator();
    }
}

