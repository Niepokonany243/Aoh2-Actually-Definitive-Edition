/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GLFWNativeWin32 {
    protected GLFWNativeWin32() {
        throw new UnsupportedOperationException();
    }

    public static long nglfwGetWin32Adapter(long monitor) {
        long __functionAddress = Functions.GetWin32Adapter;
        if (Checks.CHECKS) {
            Checks.check(monitor);
        }
        return JNI.invokePP(monitor, __functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String glfwGetWin32Adapter(@NativeType(value="GLFWmonitor *") long monitor) {
        long __result = GLFWNativeWin32.nglfwGetWin32Adapter(monitor);
        return MemoryUtil.memUTF8Safe(__result);
    }

    public static long nglfwGetWin32Monitor(long monitor) {
        long __functionAddress = Functions.GetWin32Monitor;
        if (Checks.CHECKS) {
            Checks.check(monitor);
        }
        return JNI.invokePP(monitor, __functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String glfwGetWin32Monitor(@NativeType(value="GLFWmonitor *") long monitor) {
        long __result = GLFWNativeWin32.nglfwGetWin32Monitor(monitor);
        return MemoryUtil.memUTF8Safe(__result);
    }

    @NativeType(value="HWND")
    public static long glfwGetWin32Window(@NativeType(value="GLFWwindow *") long window) {
        long __functionAddress = Functions.GetWin32Window;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePP(window, __functionAddress);
    }

    @NativeType(value="GLFWwindow *")
    public static long glfwAttachWin32Window(@NativeType(value="HWND") long handle, @NativeType(value="GLFWwindow *") long share) {
        long __functionAddress = Functions.AttachWin32Window;
        if (Checks.CHECKS) {
            Checks.check(handle);
        }
        return JNI.invokePPP(handle, share, __functionAddress);
    }

    public static final class Functions {
        public static final long GetWin32Adapter = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetWin32Adapter");
        public static final long GetWin32Monitor = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetWin32Monitor");
        public static final long GetWin32Window = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetWin32Window");
        public static final long AttachWin32Window = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwAttachWin32Window");

        private Functions() {
        }
    }
}

