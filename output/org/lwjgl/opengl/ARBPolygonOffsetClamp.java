/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL46C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBPolygonOffsetClamp {
    public static final int GL_POLYGON_OFFSET_CLAMP = 36379;

    protected ARBPolygonOffsetClamp() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glPolygonOffsetClamp);
    }

    public static void glPolygonOffsetClamp(@NativeType(value="GLfloat") float factor, @NativeType(value="GLfloat") float units, @NativeType(value="GLfloat") float clamp) {
        GL46C.glPolygonOffsetClamp(factor, units, clamp);
    }

    static {
        GL.initialize();
    }
}

