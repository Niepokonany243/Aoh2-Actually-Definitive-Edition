/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class EXTThreadLocalContext {
    protected EXTThreadLocalContext() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(ALCCapabilities caps) {
        return Checks.checkFunctions(caps.alcSetThreadContext, caps.alcGetThreadContext);
    }

    @NativeType(value="ALCboolean")
    public static boolean alcSetThreadContext(@NativeType(value="ALCcontext *") long context) {
        long __functionAddress = ALC.getICD().alcSetThreadContext;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.invokePZ(context, __functionAddress);
    }

    @NativeType(value="ALCcontext *")
    public static long alcGetThreadContext() {
        long __functionAddress = ALC.getICD().alcGetThreadContext;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.invokeP(__functionAddress);
    }
}

