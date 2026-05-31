/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GLFWNativeX11 {
    protected GLFWNativeX11() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="Display *")
    public static long glfwGetX11Display() {
        long __functionAddress = Functions.GetX11Display;
        return JNI.invokeP(__functionAddress);
    }

    @NativeType(value="RRCrtc")
    public static long glfwGetX11Adapter(@NativeType(value="GLFWmonitor *") long monitor) {
        long __functionAddress = Functions.GetX11Adapter;
        if (Checks.CHECKS) {
            Checks.check(monitor);
        }
        return JNI.invokePN(monitor, __functionAddress);
    }

    @NativeType(value="RROutput")
    public static long glfwGetX11Monitor(@NativeType(value="GLFWmonitor *") long monitor) {
        long __functionAddress = Functions.GetX11Monitor;
        if (Checks.CHECKS) {
            Checks.check(monitor);
        }
        return JNI.invokePN(monitor, __functionAddress);
    }

    @NativeType(value="Window")
    public static long glfwGetX11Window(@NativeType(value="GLFWwindow *") long window) {
        long __functionAddress = Functions.GetX11Window;
        if (Checks.CHECKS) {
            Checks.check(window);
        }
        return JNI.invokePN(window, __functionAddress);
    }

    public static void nglfwSetX11SelectionString(long string) {
        long __functionAddress = Functions.SetX11SelectionString;
        JNI.invokePV(string, __functionAddress);
    }

    public static void glfwSetX11SelectionString(@NativeType(value="char const *") ByteBuffer string) {
        if (Checks.CHECKS) {
            Checks.checkNT1(string);
        }
        GLFWNativeX11.nglfwSetX11SelectionString(MemoryUtil.memAddress(string));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glfwSetX11SelectionString(@NativeType(value="char const *") CharSequence string) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            stack.nUTF8(string, true);
            long stringEncoded = stack.getPointerAddress();
            GLFWNativeX11.nglfwSetX11SelectionString(stringEncoded);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static long nglfwGetX11SelectionString() {
        long __functionAddress = Functions.GetX11SelectionString;
        return JNI.invokeP(__functionAddress);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String glfwGetX11SelectionString() {
        long __result = GLFWNativeX11.nglfwGetX11SelectionString();
        return MemoryUtil.memUTF8Safe(__result);
    }

    public static final class Functions {
        public static final long GetX11Display = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetX11Display");
        public static final long GetX11Adapter = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetX11Adapter");
        public static final long GetX11Monitor = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetX11Monitor");
        public static final long GetX11Window = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetX11Window");
        public static final long SetX11SelectionString = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwSetX11SelectionString");
        public static final long GetX11SelectionString = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetX11SelectionString");

        private Functions() {
        }
    }
}

