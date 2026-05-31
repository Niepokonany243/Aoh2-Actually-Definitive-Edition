/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.WGLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class WGLEXTExtensionsString {
    protected WGLEXTExtensionsString() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(WGLCapabilities caps) {
        return Checks.checkFunctions(caps.wglGetExtensionsStringEXT);
    }

    public static long nwglGetExtensionsStringEXT() {
        long __functionAddress = GL.getCapabilitiesWGL().wglGetExtensionsStringEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        return JNI.callP(__functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String wglGetExtensionsStringEXT() {
        long __result = WGLEXTExtensionsString.nwglGetExtensionsStringEXT();
        return MemoryUtil.memASCIISafe(__result);
    }
}

