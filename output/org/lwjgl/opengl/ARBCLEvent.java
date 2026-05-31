/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBCLEvent {
    public static final int GL_SYNC_CL_EVENT_ARB = 33344;
    public static final int GL_SYNC_CL_EVENT_COMPLETE_ARB = 33345;

    protected ARBCLEvent() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glCreateSyncFromCLeventARB);
    }

    public static native long nglCreateSyncFromCLeventARB(long var0, long var2, int var4);

    @NativeType(value="GLsync")
    public static long glCreateSyncFromCLeventARB(@NativeType(value="cl_context") long context, @NativeType(value="cl_event") long event, @NativeType(value="GLbitfield") int flags) {
        if (Checks.CHECKS) {
            Checks.check(context);
            Checks.check(event);
        }
        return ARBCLEvent.nglCreateSyncFromCLeventARB(context, event, flags);
    }

    static {
        GL.initialize();
    }
}

