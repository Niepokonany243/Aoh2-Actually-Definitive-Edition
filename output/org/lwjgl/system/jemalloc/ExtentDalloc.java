/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.jemalloc;

import javax.annotation.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.jemalloc.ExtentDallocI;

public abstract class ExtentDalloc
extends Callback
implements ExtentDallocI {
    public static ExtentDalloc create(long functionPointer) {
        ExtentDallocI instance = (ExtentDallocI)Callback.get(functionPointer);
        return instance instanceof ExtentDalloc ? (ExtentDalloc)instance : new Container(functionPointer, instance);
    }

    @Nullable
    public static ExtentDalloc createSafe(long functionPointer) {
        return functionPointer == 0L ? null : ExtentDalloc.create(functionPointer);
    }

    public static ExtentDalloc create(ExtentDallocI instance) {
        return instance instanceof ExtentDalloc ? (ExtentDalloc)instance : new Container(instance.address(), instance);
    }

    protected ExtentDalloc() {
        super("(pppBi)B");
    }

    ExtentDalloc(long functionPointer) {
        super(functionPointer);
    }

    private static final class Container
    extends ExtentDalloc {
        private final ExtentDallocI delegate;

        Container(long functionPointer, ExtentDallocI delegate) {
            super(functionPointer);
            this.delegate = delegate;
        }

        @Override
        public boolean invoke(long extent_hooks, long addr, long size, boolean committed, int arena_ind) {
            return this.delegate.invoke(extent_hooks, addr, size, committed, arena_ind);
        }
    }
}

