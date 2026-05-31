/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.lwjgl.system.CallbackI;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.dyncall.DynCallback;

@FunctionalInterface
@NativeType(value="GLFWjoystickfun")
public interface GLFWJoystickCallbackI
extends CallbackI.V {
    public static final String SIGNATURE = "(ii)v";

    @Override
    default public String getSignature() {
        return SIGNATURE;
    }

    @Override
    default public void callback(long args) {
        this.invoke(DynCallback.dcbArgInt(args), DynCallback.dcbArgInt(args));
    }

    public void invoke(int var1, int var2);
}

