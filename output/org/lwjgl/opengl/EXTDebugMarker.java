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

public class EXTDebugMarker {
    protected EXTDebugMarker() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glInsertEventMarkerEXT, caps.glPushGroupMarkerEXT, caps.glPopGroupMarkerEXT);
    }

    public static native void nglInsertEventMarkerEXT(int var0, long var1);

    public static void glInsertEventMarkerEXT(@NativeType(value="GLchar const *") ByteBuffer marker) {
        EXTDebugMarker.nglInsertEventMarkerEXT(marker.remaining(), MemoryUtil.memAddress(marker));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glInsertEventMarkerEXT(@NativeType(value="GLchar const *") CharSequence marker) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            int markerEncodedLength = stack.nUTF8(marker, false);
            long markerEncoded = stack.getPointerAddress();
            EXTDebugMarker.nglInsertEventMarkerEXT(markerEncodedLength, markerEncoded);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglPushGroupMarkerEXT(int var0, long var1);

    public static void glPushGroupMarkerEXT(@NativeType(value="GLchar const *") ByteBuffer marker) {
        EXTDebugMarker.nglPushGroupMarkerEXT(marker.remaining(), MemoryUtil.memAddress(marker));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glPushGroupMarkerEXT(@NativeType(value="GLchar const *") CharSequence marker) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            int markerEncodedLength = stack.nUTF8(marker, false);
            long markerEncoded = stack.getPointerAddress();
            EXTDebugMarker.nglPushGroupMarkerEXT(markerEncodedLength, markerEncoded);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void glPopGroupMarkerEXT();

    static {
        GL.initialize();
    }
}

