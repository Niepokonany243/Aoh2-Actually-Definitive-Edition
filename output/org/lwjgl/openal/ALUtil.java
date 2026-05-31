/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.openal;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import org.lwjgl.openal.ALC10;
import org.lwjgl.system.MemoryUtil;

public final class ALUtil {
    private ALUtil() {
    }

    @Nullable
    public static List<String> getStringList(long deviceHandle, int token) {
        long __result = ALC10.nalcGetString(deviceHandle, token);
        if (__result == 0L) {
            return null;
        }
        ByteBuffer buffer = MemoryUtil.memByteBuffer(__result, Integer.MAX_VALUE);
        ArrayList<String> strings = new ArrayList<String>();
        int offset = 0;
        while (true) {
            if (buffer.get() != 0) {
                continue;
            }
            int limit = buffer.position() - 1;
            if (limit == offset) break;
            strings.add(MemoryUtil.memUTF8(buffer, limit - offset, offset));
            offset = buffer.position();
        }
        return strings;
    }
}

