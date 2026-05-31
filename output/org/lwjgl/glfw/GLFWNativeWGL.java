/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class GLFWNativeWGL {
    protected GLFWNativeWGL() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="HGLRC")
    public static long glfwGetWGLContext(@NativeType(value="GLFWwindow *") long window) {
        long __functionAddress = Functions.GetWGLContext;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePP(window, __functionAddress);
    }

    public static final class Functions {
        public static final long GetWGLContext = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetWGLContext");

        private Functions() {
        }
    }
}

