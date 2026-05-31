/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCharCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWCharCallback
extends Callback
implements GLFWCharCallbackI {
    public static GLFWCharCallback create(long functionPointer) {
        GLFWCharCallbackI instance = (GLFWCharCallbackI)Callback.get(functionPointer);
        return instance instanceof GLFWCharCallback ? (GLFWCharCallback)instance : new Container(functionPointer, instance);
    }

    @Nullable
    public static GLFWCharCallback createSafe(long functionPointer) {
        return functionPointer == 0L ? null : GLFWCharCallback.create(functionPointer);
    }

    public static GLFWCharCallback create(GLFWCharCallbackI instance) {
        return instance instanceof GLFWCharCallback ? (GLFWCharCallback)instance : new Container(instance.address(), instance);
    }

    protected GLFWCharCallback() {
        super("(pi)v");
    }

    GLFWCharCallback(long functionPointer) {
        super(functionPointer);
    }

    public GLFWCharCallback set(long window) {
        GLFW.glfwSetCharCallback(window, this);
        return this;
    }

    private static final class Container
    extends GLFWCharCallback {
        private final GLFWCharCallbackI delegate;

        Container(long functionPointer, GLFWCharCallbackI delegate) {
            super(functionPointer);
            this.delegate = delegate;
        }

        @Override
        public void invoke(long window, int codepoint) {
            this.delegate.invoke(window, codepoint);
        }
    }
}

