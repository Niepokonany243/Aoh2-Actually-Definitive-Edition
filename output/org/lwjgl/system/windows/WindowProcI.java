/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.windows;

import org.lwjgl.system.Callback;
import org.lwjgl.system.CallbackI;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.dyncall.DynCallback;

@FunctionalInterface
@NativeType(value="WNDPROC")
public interface WindowProcI
extends CallbackI.P {
    public static final String SIGNATURE = Callback.__stdcall("(pipp)p");

    @Override
    default public String getSignature() {
        return SIGNATURE;
    }

    @Override
    default public long callback(long args) {
        return this.invoke(DynCallback.dcbArgPointer(args), DynCallback.dcbArgInt(args), DynCallback.dcbArgPointer(args), DynCallback.dcbArgPointer(args));
    }

    @NativeType(value="LRESULT")
    public long invoke(@NativeType(value="HWND") long var1, @NativeType(value="UINT") int var3, @NativeType(value="WPARAM") long var4, @NativeType(value="LPARAM") long var6);
}

