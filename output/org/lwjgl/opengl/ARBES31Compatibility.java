/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL45C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBES31Compatibility {
    protected ARBES31Compatibility() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glMemoryBarrierByRegion);
    }

    public static void glMemoryBarrierByRegion(@NativeType(value="GLbitfield") int barriers) {
        GL45C.glMemoryBarrierByRegion(barriers);
    }

    static {
        GL.initialize();
    }
}

