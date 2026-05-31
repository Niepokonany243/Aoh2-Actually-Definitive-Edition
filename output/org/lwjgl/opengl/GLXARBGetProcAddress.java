/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLXCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GLXARBGetProcAddress {
    protected GLXARBGetProcAddress() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLXCapabilities caps) {
        return Checks.checkFunctions(caps.glXGetProcAddressARB);
    }

    public static long nglXGetProcAddressARB(long procName) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXGetProcAddressARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callPP(procName, __functionAddress);
    }

    @NativeType(value="void *")
    public static long glXGetProcAddressARB(@NativeType(value="GLchar const *") ByteBuffer procName) {
        if (Checks.CHECKS) {
            Checks.checkNT1(procName);
        }
        return GLXARBGetProcAddress.nglXGetProcAddressARB(MemoryUtil.memAddress(procName));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void *")
    public static long glXGetProcAddressARB(@NativeType(value="GLchar const *") CharSequence procName) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(procName, true);
            long procNameEncoded = stack.getPointerAddress();
            long l = GLXARBGetProcAddress.nglXGetProcAddressARB(procNameEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }
}

