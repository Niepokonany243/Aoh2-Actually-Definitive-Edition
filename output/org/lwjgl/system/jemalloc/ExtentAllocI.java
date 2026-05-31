/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.jemalloc;

import org.lwjgl.system.CallbackI;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.dyncall.DynCallback;

@FunctionalInterface
@NativeType(value="extent_alloc_t")
public interface ExtentAllocI
extends CallbackI.P {
    public static final String SIGNATURE = "(ppppppi)p";

    @Override
    default public String getSignature() {
        return SIGNATURE;
    }

    @Override
    default public long callback(long args) {
        return this.invoke(DynCallback.dcbArgPointer(args), DynCallback.dcbArgPointer(args), DynCallback.dcbArgPointer(args), DynCallback.dcbArgPointer(args), DynCallback.dcbArgPointer(args), DynCallback.dcbArgPointer(args), DynCallback.dcbArgInt(args));
    }

    @NativeType(value="void *")
    public long invoke(@NativeType(value="extent_hooks_t *") long var1, @NativeType(value="void *") long var3, @NativeType(value="size_t") long var5, @NativeType(value="size_t") long var7, @NativeType(value="bool *") long var9, @NativeType(value="bool *") long var11, @NativeType(value="unsigned int") int var13);
}

