/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.macosx;

import org.lwjgl.system.CallbackI;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.dyncall.DynCallback;

@FunctionalInterface
@NativeType(value="CGEventRef (*) (CGEventTapProxy, CGEventType, CGEventRef, void *)")
public interface CGEventTapCallBackI
extends CallbackI.P {
    public static final String SIGNATURE = "(pipp)p";

    @Override
    default public String getSignature() {
        return SIGNATURE;
    }

    @Override
    default public long callback(long args) {
        return this.invoke(DynCallback.dcbArgPointer(args), DynCallback.dcbArgInt(args), DynCallback.dcbArgPointer(args), DynCallback.dcbArgPointer(args));
    }

    @NativeType(value="CGEventRef")
    public long invoke(@NativeType(value="CGEventTapProxy") long var1, @NativeType(value="CGEventType") int var3, @NativeType(value="CGEventRef") long var4, @NativeType(value="void *") long var6);
}

