/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLXCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GLXARBCreateContext {
    public static final int GLX_CONTEXT_MAJOR_VERSION_ARB = 8337;
    public static final int GLX_CONTEXT_MINOR_VERSION_ARB = 8338;
    public static final int GLX_CONTEXT_FLAGS_ARB = 8340;
    public static final int GLX_CONTEXT_DEBUG_BIT_ARB = 1;
    public static final int GLX_CONTEXT_FORWARD_COMPATIBLE_BIT_ARB = 2;

    protected GLXARBCreateContext() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLXCapabilities caps) {
        return Checks.checkFunctions(caps.glXCreateContextAttribsARB);
    }

    public static long nglXCreateContextAttribsARB(long display, long config, long share_context, int direct, long attrib_list) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXCreateContextAttribsARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(config);
        }
        return JNI.callPPPPP(display, config, share_context, direct, attrib_list, __functionAddress);
    }

    @NativeType(value="GLXContext")
    public static long glXCreateContextAttribsARB(@NativeType(value="Display *") long display, @NativeType(value="GLXFBConfig") long config, @NativeType(value="GLXContext") long share_context, @NativeType(value="Bool") boolean direct, @Nullable @NativeType(value="int const *") IntBuffer attrib_list) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(attrib_list);
        }
        return GLXARBCreateContext.nglXCreateContextAttribsARB(display, config, share_context, direct ? 1 : 0, MemoryUtil.memAddressSafe(attrib_list));
    }

    @NativeType(value="GLXContext")
    public static long glXCreateContextAttribsARB(@NativeType(value="Display *") long display, @NativeType(value="GLXFBConfig") long config, @NativeType(value="GLXContext") long share_context, @NativeType(value="Bool") boolean direct, @Nullable @NativeType(value="int const *") int[] attrib_list) {
        long __functionAddress = GL.getCapabilitiesGLXClient().glXCreateContextAttribsARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(display);
            Checks.check(config);
            Checks.checkNTSafe(attrib_list);
        }
        return JNI.callPPPPP(display, config, share_context, direct ? 1 : 0, attrib_list, __functionAddress);
    }
}

