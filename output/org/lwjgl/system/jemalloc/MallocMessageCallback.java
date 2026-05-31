/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.jemalloc;

import javax.annotation.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.jemalloc.MallocMessageCallbackI;

public abstract class MallocMessageCallback
extends Callback
implements MallocMessageCallbackI {
    public static MallocMessageCallback create(long functionPointer) {
        MallocMessageCallbackI instance = (MallocMessageCallbackI)Callback.get(functionPointer);
        return instance instanceof MallocMessageCallback ? (MallocMessageCallback)instance : new Container(functionPointer, instance);
    }

    @Nullable
    public static MallocMessageCallback createSafe(long functionPointer) {
        return functionPointer == 0L ? null : MallocMessageCallback.create(functionPointer);
    }

    public static MallocMessageCallback create(MallocMessageCallbackI instance) {
        return instance instanceof MallocMessageCallback ? (MallocMessageCallback)instance : new Container(instance.address(), instance);
    }

    protected MallocMessageCallback() {
        super("(pp)v");
    }

    MallocMessageCallback(long functionPointer) {
        super(functionPointer);
    }

    public static String getMessage(long s) {
        return MemoryUtil.memASCII(s);
    }

    private static final class Container
    extends MallocMessageCallback {
        private final MallocMessageCallbackI delegate;

        Container(long functionPointer, MallocMessageCallbackI delegate) {
            super(functionPointer);
            this.delegate = delegate;
        }

        @Override
        public void invoke(long cbopaque, long s) {
            this.delegate.invoke(cbopaque, s);
        }
    }
}

