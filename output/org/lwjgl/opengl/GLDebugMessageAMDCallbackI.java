/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.system.Callback;
import org.lwjgl.system.CallbackI;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.dyncall.DynCallback;

@FunctionalInterface
@NativeType(value="GLDEBUGPROCAMD")
public interface GLDebugMessageAMDCallbackI
extends CallbackI.V {
    public static final String SIGNATURE = Callback.__stdcall("(iiiipp)v");

    @Override
    default public String getSignature() {
        return SIGNATURE;
    }

    @Override
    default public void callback(long args) {
        this.invoke(DynCallback.dcbArgInt(args), DynCallback.dcbArgInt(args), DynCallback.dcbArgInt(args), DynCallback.dcbArgInt(args), DynCallback.dcbArgPointer(args), DynCallback.dcbArgPointer(args));
    }

    public void invoke(@NativeType(value="GLuint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLchar const *") long var5, @NativeType(value="void *") long var7);
}

