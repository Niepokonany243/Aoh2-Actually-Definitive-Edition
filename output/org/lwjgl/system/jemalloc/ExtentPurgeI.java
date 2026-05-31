/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.jemalloc;

import org.lwjgl.system.CallbackI;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.dyncall.DynCallback;

@FunctionalInterface
@NativeType(value="extent_purge_t")
public interface ExtentPurgeI
extends CallbackI.Z {
    public static final String SIGNATURE = "(pppppi)B";

    @Override
    default public String getSignature() {
        return SIGNATURE;
    }

    @Override
    default public boolean callback(long args) {
        return this.invoke(DynCallback.dcbArgPointer(args), DynCallback.dcbArgPointer(args), DynCallback.dcbArgPointer(args), DynCallback.dcbArgPointer(args), DynCallback.dcbArgPointer(args), DynCallback.dcbArgInt(args));
    }

    @NativeType(value="bool")
    public boolean invoke(@NativeType(value="extent_hooks_t *") long var1, @NativeType(value="void *") long var3, @NativeType(value="size_t") long var5, @NativeType(value="size_t") long var7, @NativeType(value="size_t") long var9, @NativeType(value="unsigned int") int var11);
}

