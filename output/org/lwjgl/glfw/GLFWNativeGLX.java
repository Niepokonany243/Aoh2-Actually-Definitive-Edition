/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class GLFWNativeGLX {
    protected GLFWNativeGLX() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="GLXContext")
    public static long glfwGetGLXContext(@NativeType(value="GLFWwindow *") long window) {
        long __functionAddress = Functions.GetGLXContext;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePP(window, __functionAddress);
    }

    @NativeType(value="GLXWindow")
    public static long glfwGetGLXWindow(@NativeType(value="GLFWwindow *") long window) {
        long __functionAddress = Functions.GetGLXWindow;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePP(window, __functionAddress);
    }

    public static final class Functions {
        public static final long GetGLXContext = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetGLXContext");
        public static final long GetGLXWindow = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetGLXWindow");

        private Functions() {
        }
    }
}

