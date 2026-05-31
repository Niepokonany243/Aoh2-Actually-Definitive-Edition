/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GREMEDYStringMarker {
    protected GREMEDYStringMarker() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glStringMarkerGREMEDY);
    }

    public static native void nglStringMarkerGREMEDY(int var0, long var1);

    public static void glStringMarkerGREMEDY(@NativeType(value="GLchar const *") ByteBuffer string) {
        GREMEDYStringMarker.nglStringMarkerGREMEDY(string.remaining(), MemoryUtil.memAddress(string));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glStringMarkerGREMEDY(@NativeType(value="GLchar const *") CharSequence string) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            int stringEncodedLength = stack.nUTF8(string, false);
            long stringEncoded = stack.getPointerAddress();
            GREMEDYStringMarker.nglStringMarkerGREMEDY(stringEncodedLength, stringEncoded);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    static {
        GL.initialize();
    }
}

