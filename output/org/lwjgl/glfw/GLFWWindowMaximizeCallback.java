/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowMaximizeCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWWindowMaximizeCallback
extends Callback
implements GLFWWindowMaximizeCallbackI {
    public static GLFWWindowMaximizeCallback create(long functionPointer) {
        GLFWWindowMaximizeCallbackI instance = (GLFWWindowMaximizeCallbackI)Callback.get(functionPointer);
        return instance instanceof GLFWWindowMaximizeCallback ? (GLFWWindowMaximizeCallback)instance : new Container(functionPointer, instance);
    }

    @Nullable
    public static GLFWWindowMaximizeCallback createSafe(long functionPointer) {
        return functionPointer == 0L ? null : GLFWWindowMaximizeCallback.create(functionPointer);
    }

    public static GLFWWindowMaximizeCallback create(GLFWWindowMaximizeCallbackI instance) {
        return instance instanceof GLFWWindowMaximizeCallback ? (GLFWWindowMaximizeCallback)instance : new Container(instance.address(), instance);
    }

    protected GLFWWindowMaximizeCallback() {
        super("(pi)v");
    }

    GLFWWindowMaximizeCallback(long functionPointer) {
        super(functionPointer);
    }

    public GLFWWindowMaximizeCallback set(long window) {
        GLFW.glfwSetWindowMaximizeCallback(window, this);
        return this;
    }

    private static final class Container
    extends GLFWWindowMaximizeCallback {
        private final GLFWWindowMaximizeCallbackI delegate;

        Container(long functionPointer, GLFWWindowMaximizeCallbackI delegate) {
            super(functionPointer);
            this.delegate = delegate;
        }

        @Override
        public void invoke(long window, boolean maximized) {
            this.delegate.invoke(window, maximized);
        }
    }
}

