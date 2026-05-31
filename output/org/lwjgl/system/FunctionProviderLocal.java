/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import java.nio.ByteBuffer;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.MemoryStack;

public interface FunctionProviderLocal
extends FunctionProvider {
    default public long getFunctionAddress(long handle, CharSequence functionName) {
        try (MemoryStack stack = MemoryStack.stackPush();){
            long l = this.getFunctionAddress(handle, stack.ASCII(functionName));
            return l;
        }
    }

    public long getFunctionAddress(long var1, ByteBuffer var3);
}

