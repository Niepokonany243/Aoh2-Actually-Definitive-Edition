/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class EXTPolygonOffsetClamp {
    public static final int GL_POLYGON_OFFSET_CLAMP_EXT = 36379;

    protected EXTPolygonOffsetClamp() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glPolygonOffsetClampEXT);
    }

    public static native void glPolygonOffsetClampEXT(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    static {
        GL.initialize();
    }
}

