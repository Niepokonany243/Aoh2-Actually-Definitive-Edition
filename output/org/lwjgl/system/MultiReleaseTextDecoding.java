/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import java.nio.charset.StandardCharsets;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryUtil;

final class MultiReleaseTextDecoding {
    private MultiReleaseTextDecoding() {
    }

    static String decodeUTF8(long source, int length) {
        if (length <= 0) {
            return "";
        }
        if (Checks.DEBUG) {
            byte[] bytes = length <= MemoryUtil.ARRAY_TLC_SIZE ? MemoryUtil.ARRAY_TLC_BYTE.get() : new byte[length];
            MemoryUtil.memByteBuffer(source, length).get(bytes, 0, length);
            return new String(bytes, 0, length, StandardCharsets.UTF_8);
        }
        char[] string = length <= MemoryUtil.ARRAY_TLC_SIZE ? MemoryUtil.ARRAY_TLC_CHAR.get() : new char[length];
        int i = 0;
        int position = 0;
        while (position < length) {
            char c;
            int b0;
            if ((b0 = MemoryUtil.UNSAFE.getByte(null, source + (long)position++) & 0xFF) < 128) {
                c = (char)b0;
            } else {
                int b1 = MemoryUtil.UNSAFE.getByte(null, source + (long)position++) & 0x3F;
                if ((b0 & 0xE0) == 192) {
                    c = (char)((b0 & 0x1F) << 6 | b1);
                } else {
                    int b2 = MemoryUtil.UNSAFE.getByte(null, source + (long)position++) & 0x3F;
                    if ((b0 & 0xF0) == 224) {
                        c = (char)((b0 & 0xF) << 12 | b1 << 6 | b2);
                    } else {
                        int b3 = MemoryUtil.UNSAFE.getByte(null, source + (long)position++) & 0x3F;
                        int cp = (b0 & 7) << 18 | b1 << 12 | b2 << 6 | b3;
                        if (i < length) {
                            string[i++] = (char)((cp >>> 10) + 55232);
                        }
                        c = (char)((cp & 0x3FF) + 56320);
                    }
                }
            }
            if (i >= length) continue;
            string[i++] = c;
        }
        return new String(string, 0, Math.min(i, length));
    }
}

