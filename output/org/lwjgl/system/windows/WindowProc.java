/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import javax.annotation.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.windows.WindowProcI;

public abstract class WindowProc
extends Callback
implements WindowProcI {
    public static WindowProc create(long functionPointer) {
        WindowProcI instance = (WindowProcI)Callback.get(functionPointer);
        return instance instanceof WindowProc ? (WindowProc)instance : new Container(functionPointer, instance);
    }

    @Nullable
    public static WindowProc createSafe(long functionPointer) {
        return functionPointer == 0L ? null : WindowProc.create(functionPointer);
    }

    public static WindowProc create(WindowProcI instance) {
        return instance instanceof WindowProc ? (WindowProc)instance : new Container(instance.address(), instance);
    }

    protected WindowProc() {
        super(SIGNATURE);
    }

    WindowProc(long functionPointer) {
        super(functionPointer);
    }

    private static final class Container
    extends WindowProc {
        private final WindowProcI delegate;

        Container(long functionPointer, WindowProcI delegate) {
            super(functionPointer);
            this.delegate = delegate;
        }

        @Override
        public long invoke(long hwnd, int uMsg, long wParam, long lParam) {
            return this.delegate.invoke(hwnd, uMsg, wParam, lParam);
        }
    }
}

