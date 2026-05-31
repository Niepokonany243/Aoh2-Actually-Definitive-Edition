/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.jemalloc;

import javax.annotation.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.jemalloc.ExtentAllocI;

public abstract class ExtentAlloc
extends Callback
implements ExtentAllocI {
    public static ExtentAlloc create(long functionPointer) {
        ExtentAllocI instance = (ExtentAllocI)Callback.get(functionPointer);
        return instance instanceof ExtentAlloc ? (ExtentAlloc)instance : new Container(functionPointer, instance);
    }

    @Nullable
    public static ExtentAlloc createSafe(long functionPointer) {
        return functionPointer == 0L ? null : ExtentAlloc.create(functionPointer);
    }

    public static ExtentAlloc create(ExtentAllocI instance) {
        return instance instanceof ExtentAlloc ? (ExtentAlloc)instance : new Container(instance.address(), instance);
    }

    protected ExtentAlloc() {
        super("(ppppppi)p");
    }

    ExtentAlloc(long functionPointer) {
        super(functionPointer);
    }

    private static final class Container
    extends ExtentAlloc {
        private final ExtentAllocI delegate;

        Container(long functionPointer, ExtentAllocI delegate) {
            super(functionPointer);
            this.delegate = delegate;
        }

        @Override
        public long invoke(long extent_hooks, long new_addr, long size, long alignment, long zero, long commit, int arena_ind) {
            return this.delegate.invoke(extent_hooks, new_addr, size, alignment, zero, commit, arena_ind);
        }
    }
}

