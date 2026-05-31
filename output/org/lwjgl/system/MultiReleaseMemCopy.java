/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.libc.LibCString;

final class MultiReleaseMemCopy {
    private MultiReleaseMemCopy() {
    }

    static void copy(long src, long dst, long bytes) {
        if (bytes < 384L) {
            if (((int)src & 7) == 0 && ((int)dst & 7) == 0) {
                MemoryUtil.memCopyAligned(src, dst, (int)bytes & 0x1FF);
            } else {
                MemoryUtil.UNSAFE.copyMemory(src, dst, bytes);
            }
        } else {
            LibCString.nmemcpy(dst, src, bytes);
        }
    }
}

