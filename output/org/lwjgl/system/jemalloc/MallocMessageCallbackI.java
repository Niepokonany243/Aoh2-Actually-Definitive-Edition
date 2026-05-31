/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.jemalloc;

import org.lwjgl.system.CallbackI;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.dyncall.DynCallback;

@FunctionalInterface
@NativeType(value="void (*) (void *, char const *)")
public interface MallocMessageCallbackI
extends CallbackI.V {
    public static final String SIGNATURE = "(pp)v";

    @Override
    default public String getSignature() {
        return SIGNATURE;
    }

    @Override
    default public void callback(long args) {
        this.invoke(DynCallback.dcbArgPointer(args), DynCallback.dcbArgPointer(args));
    }

    public void invoke(@NativeType(value="void *") long var1, @NativeType(value="char const *") long var3);
}

