/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import java.nio.ByteBuffer;
import org.lwjgl.system.MemoryStack;

@FunctionalInterface
public interface FunctionProvider {
    default public long getFunctionAddress(CharSequence functionName) {
        try (MemoryStack stack = MemoryStack.stackPush();){
            long l = this.getFunctionAddress(stack.ASCII(functionName));
            return l;
        }
    }

    public long getFunctionAddress(ByteBuffer var1);
}

