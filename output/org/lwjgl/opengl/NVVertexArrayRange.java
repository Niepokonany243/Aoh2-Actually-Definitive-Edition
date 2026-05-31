/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVVertexArrayRange {
    public static final int GL_VERTEX_ARRAY_RANGE_NV = 34077;
    public static final int GL_VERTEX_ARRAY_RANGE_LENGTH_NV = 34078;
    public static final int GL_VERTEX_ARRAY_RANGE_VALID_NV = 34079;
    public static final int GL_MAX_VERTEX_ARRAY_RANGE_ELEMENT_NV = 34080;
    public static final int GL_VERTEX_ARRAY_RANGE_POINTER_NV = 34081;

    protected NVVertexArrayRange() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glVertexArrayRangeNV, caps.glFlushVertexArrayRangeNV);
    }

    public static native void nglVertexArrayRangeNV(int var0, long var1);

    public static void glVertexArrayRangeNV(@NativeType(value="void *") ByteBuffer pointer) {
        NVVertexArrayRange.nglVertexArrayRangeNV(pointer.remaining(), MemoryUtil.memAddress(pointer));
    }

    public static native void glFlushVertexArrayRangeNV();

    static {
        GL.initialize();
    }
}

