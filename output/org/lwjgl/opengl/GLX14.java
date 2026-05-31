/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLX13;
import org.lwjgl.opengl.GLXCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GLX14
extends GLX13 {
    public static final int GLX_SAMPLE_BUFFERS = 100000;
    public static final int GLX_SAMPLES = 100001;

    protected GLX14() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLXCapabilities caps) {
        return Checks.checkFunctions(caps.glXGetProcAddress);
    }

    public static long nglXGetProcAddress(long procName) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXGetProcAddress;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callPP(procName, __functionAddress);
    }

    @NativeType(value="void *")
    public static long glXGetProcAddress(@NativeType(value="GLchar const *") ByteBuffer procName) {
        if (Checks.CHECKS) {
            Checks.checkNT1(procName);
        }
        return GLX14.nglXGetProcAddress(MemoryUtil.memAddress(procName));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void *")
    public static long glXGetProcAddress(@NativeType(value="GLchar const *") CharSequence procName) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nASCII(procName, true);
            long procNameEncoded = stack.getPointerAddress();
            long l = GLX14.nglXGetProcAddress(procNameEncoded);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }
}

