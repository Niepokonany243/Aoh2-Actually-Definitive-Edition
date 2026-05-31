/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class GLFWNativeNSGL {
    protected GLFWNativeNSGL() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="id")
    public static long glfwGetNSGLContext(@NativeType(value="GLFWwindow *") long window) {
        long __functionAddress = Functions.GetNSGLContext;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePP(window, __functionAddress);
    }

    public static final class Functions {
        public static final long GetNSGLContext = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetNSGLContext");

        private Functions() {
        }
    }
}

