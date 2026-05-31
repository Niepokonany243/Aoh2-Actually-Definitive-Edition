/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.util.Set;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBInstancedArrays {
    public static final int GL_VERTEX_ATTRIB_ARRAY_DIVISOR_ARB = 35070;

    protected ARBInstancedArrays() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, Set<String> ext) {
        return Checks.checkFunctions(caps.glVertexAttribDivisorARB);
    }

    public static native void glVertexAttribDivisorARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void glVertexArrayVertexAttribDivisorEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    static {
        GL.initialize();
    }
}

