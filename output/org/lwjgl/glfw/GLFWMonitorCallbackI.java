/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.lwjgl.system.CallbackI;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.dyncall.DynCallback;

@FunctionalInterface
@NativeType(value="GLFWmonitorfun")
public interface GLFWMonitorCallbackI
extends CallbackI.V {
    public static final String SIGNATURE = "(pi)v";

    @Override
    default public String getSignature() {
        return SIGNATURE;
    }

    @Override
    default public void callback(long args) {
        this.invoke(DynCallback.dcbArgPointer(args), DynCallback.dcbArgInt(args));
    }

    public void invoke(@NativeType(value="GLFWmonitor *") long var1, int var3);
}

