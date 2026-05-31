/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.jemalloc;

import javax.annotation.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.jemalloc.ExtentDestroyI;

public abstract class ExtentDestroy
extends Callback
implements ExtentDestroyI {
    public static ExtentDestroy create(long functionPointer) {
        ExtentDestroyI instance = (ExtentDestroyI)Callback.get(functionPointer);
        return instance instanceof ExtentDestroy ? (ExtentDestroy)instance : new Container(functionPointer, instance);
    }

    @Nullable
    public static ExtentDestroy createSafe(long functionPointer) {
        return functionPointer == 0L ? null : ExtentDestroy.create(functionPointer);
    }

    public static ExtentDestroy create(ExtentDestroyI instance) {
        return instance instanceof ExtentDestroy ? (ExtentDestroy)instance : new Container(instance.address(), instance);
    }

    protected ExtentDestroy() {
        super("(pppBi)B");
    }

    ExtentDestroy(long functionPointer) {
        super(functionPointer);
    }

    private static final class Container
    extends ExtentDestroy {
        private final ExtentDestroyI delegate;

        Container(long functionPointer, ExtentDestroyI delegate) {
            super(functionPointer);
            this.delegate = delegate;
        }

        @Override
        public boolean invoke(long extent_hooks, long addr, long size, boolean committed, int arena_ind) {
            return this.delegate.invoke(extent_hooks, addr, size, committed, arena_ind);
        }
    }
}

