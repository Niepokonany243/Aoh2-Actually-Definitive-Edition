/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.jemalloc;

import javax.annotation.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.jemalloc.ExtentCommitI;

public abstract class ExtentCommit
extends Callback
implements ExtentCommitI {
    public static ExtentCommit create(long functionPointer) {
        ExtentCommitI instance = (ExtentCommitI)Callback.get(functionPointer);
        return instance instanceof ExtentCommit ? (ExtentCommit)instance : new Container(functionPointer, instance);
    }

    @Nullable
    public static ExtentCommit createSafe(long functionPointer) {
        return functionPointer == 0L ? null : ExtentCommit.create(functionPointer);
    }

    public static ExtentCommit create(ExtentCommitI instance) {
        return instance instanceof ExtentCommit ? (ExtentCommit)instance : new Container(instance.address(), instance);
    }

    protected ExtentCommit() {
        super("(pppppi)B");
    }

    ExtentCommit(long functionPointer) {
        super(functionPointer);
    }

    private static final class Container
    extends ExtentCommit {
        private final ExtentCommitI delegate;

        Container(long functionPointer, ExtentCommitI delegate) {
            super(functionPointer);
            this.delegate = delegate;
        }

        @Override
        public boolean invoke(long extent_hooks, long addr, long size, long offset, long length, int arena_ind) {
            return this.delegate.invoke(extent_hooks, addr, size, offset, length, arena_ind);
        }
    }
}

