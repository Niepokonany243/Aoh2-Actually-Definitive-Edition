/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.lwjgl.system.CallbackI;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.dyncall.DynCallback;

@FunctionalInterface
@NativeType(value="GLFWwindowiconifyfun")
public interface GLFWWindowIconifyCallbackI
extends CallbackI.V {
    public static final String SIGNATURE = "(pi)v";

    @Override
    default public String getSignature() {
        return SIGNATURE;
    }

    @Override
    default public void callback(long args) {
        this.invoke(DynCallback.dcbArgPointer(args), DynCallback.dcbArgInt(args) != 0);
    }

    public void invoke(@NativeType(value="GLFWwindow *") long var1, @NativeType(value="int") boolean var3);
}

