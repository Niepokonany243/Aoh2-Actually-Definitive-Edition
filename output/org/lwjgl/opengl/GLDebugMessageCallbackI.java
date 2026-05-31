/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.system.Callback;
import org.lwjgl.system.CallbackI;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.dyncall.DynCallback;

@FunctionalInterface
@NativeType(value="GLDEBUGPROC")
public interface GLDebugMessageCallbackI
extends CallbackI.V {
    public static final String SIGNATURE = Callback.__stdcall("(iiiiipp)v");

    @Override
    default public String getSignature() {
        return SIGNATURE;
    }

    @Override
    default public void callback(long args) {
        this.invoke(DynCallback.dcbArgInt(args), DynCallback.dcbArgInt(args), DynCallback.dcbArgInt(args), DynCallback.dcbArgInt(args), DynCallback.dcbArgInt(args), DynCallback.dcbArgPointer(args), DynCallback.dcbArgPointer(args));
    }

    public void invoke(@NativeType(value="GLenum") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLuint") int var3, @NativeType(value="GLenum") int var4, @NativeType(value="GLsizei") int var5, @NativeType(value="GLchar const *") long var6, @NativeType(value="void const *") long var8);
}

