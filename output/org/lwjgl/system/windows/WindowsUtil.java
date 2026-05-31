/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.windows;

import org.lwjgl.system.windows.WinBase;

public final class WindowsUtil {
    private WindowsUtil() {
    }

    public static void windowsThrowException(String msg) {
        throw new RuntimeException(msg + " (error code = " + WinBase.getLastError() + ")");
    }
}

