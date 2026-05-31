/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.lwjgl.system.CallbackI;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.dyncall.DynCallback;

@FunctionalInterface
@NativeType(value="GLFWframebuffersizefun")
public interface GLFWFramebufferSizeCallbackI
extends CallbackI.V {
    public static final String SIGNATURE = "(pii)v";

    @Override
    default public String getSignature() {
        return SIGNATURE;
    }

    @Override
    default public void callback(long args) {
        this.invoke(DynCallback.dcbArgPointer(args), DynCallback.dcbArgInt(args), DynCallback.dcbArgInt(args));
    }

    public void invoke(@NativeType(value="GLFWwindow *") long var1, int var3, int var4);
}

