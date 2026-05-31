/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import java.util.Set;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTEGLImageStorage {
    protected EXTEGLImageStorage() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, Set<String> ext) {
        return Checks.checkFunctions(caps.glEGLImageTargetTexStorageEXT, caps.hasDSA(ext) ? caps.glEGLImageTargetTextureStorageEXT : -1L);
    }

    public static native void nglEGLImageTargetTexStorageEXT(int var0, long var1, long var3);

    public static void glEGLImageTargetTexStorageEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLeglImageOES") long image, @Nullable @NativeType(value="int const *") IntBuffer attrib_list) {
        if (Checks.CHECKS) {
            Checks.check(image);
            Checks.checkNTSafe(attrib_list);
        }
        EXTEGLImageStorage.nglEGLImageTargetTexStorageEXT(target, image, MemoryUtil.memAddressSafe(attrib_list));
    }

    public static native void nglEGLImageTargetTextureStorageEXT(int var0, long var1, long var3);

    public static void glEGLImageTargetTextureStorageEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLeglImageOES") long image, @Nullable @NativeType(value="int const *") IntBuffer attrib_list) {
        if (Checks.CHECKS) {
            Checks.check(image);
            Checks.checkNTSafe(attrib_list);
        }
        EXTEGLImageStorage.nglEGLImageTargetTextureStorageEXT(texture, image, MemoryUtil.memAddressSafe(attrib_list));
    }

    public static void glEGLImageTargetTexStorageEXT(@NativeType(value="GLenum") int target, @NativeType(value="GLeglImageOES") long image, @Nullable @NativeType(value="int const *") int[] attrib_list) {
        long __functionAddress = GL.getICD().glEGLImageTargetTexStorageEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(image);
            Checks.checkNTSafe(attrib_list);
        }
        JNI.callPPV(target, image, attrib_list, __functionAddress);
    }

    public static void glEGLImageTargetTextureStorageEXT(@NativeType(value="GLuint") int texture, @NativeType(value="GLeglImageOES") long image, @Nullable @NativeType(value="int const *") int[] attrib_list) {
        long __functionAddress = GL.getICD().glEGLImageTargetTextureStorageEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(image);
            Checks.checkNTSafe(attrib_list);
        }
        JNI.callPPV(texture, image, attrib_list, __functionAddress);
    }

    static {
        GL.initialize();
    }
}

