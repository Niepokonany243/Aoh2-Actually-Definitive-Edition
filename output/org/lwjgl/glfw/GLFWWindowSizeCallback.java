/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowSizeCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWWindowSizeCallback
extends Callback
implements GLFWWindowSizeCallbackI {
    public static GLFWWindowSizeCallback create(long functionPointer) {
        GLFWWindowSizeCallbackI instance = (GLFWWindowSizeCallbackI)Callback.get(functionPointer);
        return instance instanceof GLFWWindowSizeCallback ? (GLFWWindowSizeCallback)instance : new Container(functionPointer, instance);
    }

    @Nullable
    public static GLFWWindowSizeCallback createSafe(long functionPointer) {
        return functionPointer == 0L ? null : GLFWWindowSizeCallback.create(functionPointer);
    }

    public static GLFWWindowSizeCallback create(GLFWWindowSizeCallbackI instance) {
        return instance instanceof GLFWWindowSizeCallback ? (GLFWWindowSizeCallback)instance : new Container(instance.address(), instance);
    }

    protected GLFWWindowSizeCallback() {
        super("(pii)v");
    }

    GLFWWindowSizeCallback(long functionPointer) {
        super(functionPointer);
    }

    public GLFWWindowSizeCallback set(long window) {
        GLFW.glfwSetWindowSizeCallback(window, this);
        return this;
    }

    private static final class Container
    extends GLFWWindowSizeCallback {
        private final GLFWWindowSizeCallbackI delegate;

        Container(long functionPointer, GLFWWindowSizeCallbackI delegate) {
            super(functionPointer);
            this.delegate = delegate;
        }

        @Override
        public void invoke(long window, int width, int height) {
            this.delegate.invoke(window, width, height);
        }
    }
}

