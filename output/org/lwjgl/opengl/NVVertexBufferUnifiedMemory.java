/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.LongBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVVertexBufferUnifiedMemory {
    public static final int GL_VERTEX_ATTRIB_ARRAY_UNIFIED_NV = 36638;
    public static final int GL_ELEMENT_ARRAY_UNIFIED_NV = 36639;
    public static final int GL_VERTEX_ATTRIB_ARRAY_ADDRESS_NV = 36640;
    public static final int GL_TEXTURE_COORD_ARRAY_ADDRESS_NV = 36645;
    public static final int GL_VERTEX_ARRAY_ADDRESS_NV = 36641;
    public static final int GL_NORMAL_ARRAY_ADDRESS_NV = 36642;
    public static final int GL_COLOR_ARRAY_ADDRESS_NV = 36643;
    public static final int GL_INDEX_ARRAY_ADDRESS_NV = 36644;
    public static final int GL_EDGE_FLAG_ARRAY_ADDRESS_NV = 36646;
    public static final int GL_SECONDARY_COLOR_ARRAY_ADDRESS_NV = 36647;
    public static final int GL_FOG_COORD_ARRAY_ADDRESS_NV = 36648;
    public static final int GL_ELEMENT_ARRAY_ADDRESS_NV = 36649;
    public static final int GL_VERTEX_ATTRIB_ARRAY_LENGTH_NV = 36650;
    public static final int GL_TEXTURE_COORD_ARRAY_LENGTH_NV = 36655;
    public static final int GL_VERTEX_ARRAY_LENGTH_NV = 36651;
    public static final int GL_NORMAL_ARRAY_LENGTH_NV = 36652;
    public static final int GL_COLOR_ARRAY_LENGTH_NV = 36653;
    public static final int GL_INDEX_ARRAY_LENGTH_NV = 36654;
    public static final int GL_EDGE_FLAG_ARRAY_LENGTH_NV = 36656;
    public static final int GL_SECONDARY_COLOR_ARRAY_LENGTH_NV = 36657;
    public static final int GL_FOG_COORD_ARRAY_LENGTH_NV = 36658;
    public static final int GL_ELEMENT_ARRAY_LENGTH_NV = 36659;

    protected NVVertexBufferUnifiedMemory() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glBufferAddressRangeNV, caps.glVertexFormatNV, caps.glNormalFormatNV, caps.glColorFormatNV, caps.glIndexFormatNV, caps.glTexCoordFormatNV, caps.glEdgeFlagFormatNV, caps.glSecondaryColorFormatNV, caps.glFogCoordFormatNV, caps.glVertexAttribFormatNV, caps.glVertexAttribIFormatNV, caps.glGetIntegerui64i_vNV);
    }

    public static native void glBufferAddressRangeNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint64EXT") long var2, @NativeType(value="GLsizeiptr") long var4);

    public static native void glVertexFormatNV(@NativeType(value="GLint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLsizei") int var2);

    public static native void glNormalFormatNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLsizei") int var1);

    public static native void glColorFormatNV(@NativeType(value="GLint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLsizei") int var2);

    public static native void glIndexFormatNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLsizei") int var1);

    public static native void glTexCoordFormatNV(@NativeType(value="GLint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLsizei") int var2);

    public static native void glEdgeFlagFormatNV(@NativeType(value="GLsizei") int var0);

    public static native void glSecondaryColorFormatNV(@NativeType(value="GLint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLsizei") int var2);

    public static native void glFogCoordFormatNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLsizei") int var1);

    public static native void glVertexAttribFormatNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLboolean") boolean var3, @NativeType(value="GLsizei") int var4);

    public static native void glVertexAttribIFormatNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3);

    public static native void nglGetIntegerui64i_vNV(int var0, int var1, long var2);

    public static void glGetIntegerui64i_vNV(@NativeType(value="GLenum") int value, @NativeType(value="GLuint") int index, @NativeType(value="GLuint64EXT *") LongBuffer result) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)result, 1);
        }
        NVVertexBufferUnifiedMemory.nglGetIntegerui64i_vNV(value, index, MemoryUtil.memAddress(result));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetIntegerui64iNV(@NativeType(value="GLenum") int value, @NativeType(value="GLuint") int index) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            LongBuffer result = stack.callocLong(1);
            NVVertexBufferUnifiedMemory.nglGetIntegerui64i_vNV(value, index, MemoryUtil.memAddress(result));
            long l = result.get(0);
            return l;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glGetIntegerui64i_vNV(@NativeType(value="GLenum") int value, @NativeType(value="GLuint") int index, @NativeType(value="GLuint64EXT *") long[] result) {
        long __functionAddress = GL.getICD().glGetIntegerui64i_vNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(result, 1);
        }
        JNI.callPV(value, index, result, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

