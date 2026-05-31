/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVQueryResource {
    public static final int GL_QUERY_RESOURCE_TYPE_VIDMEM_ALLOC_NV = 38208;
    public static final int GL_QUERY_RESOURCE_MEMTYPE_VIDMEM_NV = 38210;
    public static final int GL_QUERY_RESOURCE_SYS_RESERVED_NV = 38212;
    public static final int GL_QUERY_RESOURCE_TEXTURE_NV = 38213;
    public static final int GL_QUERY_RESOURCE_RENDERBUFFER_NV = 38214;
    public static final int GL_QUERY_RESOURCE_BUFFEROBJECT_NV = 38215;

    protected NVQueryResource() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glQueryResourceNV);
    }

    public static native int nglQueryResourceNV(int var0, int var1, int var2, long var3);

    @NativeType(value="GLint")
    public static int glQueryResourceNV(@NativeType(value="GLenum") int queryType, @NativeType(value="GLint") int pname, @NativeType(value="GLint *") IntBuffer buffer) {
        return NVQueryResource.nglQueryResourceNV(queryType, pname, buffer.remaining(), MemoryUtil.memAddress(buffer));
    }

    @NativeType(value="GLint")
    public static int glQueryResourceNV(@NativeType(value="GLenum") int queryType, @NativeType(value="GLint") int pname, @NativeType(value="GLint *") int[] buffer) {
        long __functionAddress = GL.getICD().glQueryResourceNV;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callPI(queryType, pname, buffer.length, buffer, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

