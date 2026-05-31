/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.lwjgl.system.CallbackI;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.dyncall.DynCallback;

@FunctionalInterface
@NativeType(value="GLFWwindowclosefun")
public interface GLFWWindowCloseCallbackI
extends CallbackI.V {
    public static final String SIGNATURE = "(p)v";

    @Override
    default public String getSignature() {
        return SIGNATURE;
    }

    @Override
    default public void callback(long args) {
        this.invoke(DynCallback.dcbArgPointer(args));
    }

    public void invoke(@NativeType(value="GLFWwindow *") long var1);
}

