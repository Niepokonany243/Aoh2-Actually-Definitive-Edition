/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class GLFWNativeWayland {
    protected GLFWNativeWayland() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="struct wl_display *")
    public static long glfwGetWaylandDisplay() {
        long __functionAddress = Functions.GetWaylandDisplay;
        return JNI.invokeP(__functionAddress);
    }

    @NativeType(value="struct wl_output *")
    public static long glfwGetWaylandMonitor(@NativeType(value="GLFWmonitor *") long monitor) {
        long __functionAddress = Functions.GetWaylandMonitor;
        if (Checks.CHECKS) {
            Checks.check(monitor);
        }
        return JNI.invokePP(monitor, __functionAddress);
    }

    @NativeType(value="struct wl_surface *")
    public static long glfwGetWaylandWindow(@NativeType(value="GLFWwindow *") long window) {
        long __functionAddress = Functions.GetWaylandWindow;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePP(window, __functionAddress);
    }

    public static final class Functions {
        public static final long GetWaylandDisplay = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetWaylandDisplay");
        public static final long GetWaylandMonitor = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetWaylandMonitor");
        public static final long GetWaylandWindow = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetWaylandWindow");

        private Functions() {
        }
    }
}

