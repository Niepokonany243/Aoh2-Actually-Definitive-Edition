/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowCloseCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWWindowCloseCallback
extends Callback
implements GLFWWindowCloseCallbackI {
    public static GLFWWindowCloseCallback create(long functionPointer) {
        GLFWWindowCloseCallbackI instance = (GLFWWindowCloseCallbackI)Callback.get(functionPointer);
        return instance instanceof GLFWWindowCloseCallback ? (GLFWWindowCloseCallback)instance : new Container(functionPointer, instance);
    }

    @Nullable
    public static GLFWWindowCloseCallback createSafe(long functionPointer) {
        return functionPointer == 0L ? null : GLFWWindowCloseCallback.create(functionPointer);
    }

    public static GLFWWindowCloseCallback create(GLFWWindowCloseCallbackI instance) {
        return instance instanceof GLFWWindowCloseCallback ? (GLFWWindowCloseCallback)instance : new Container(instance.address(), instance);
    }

    protected GLFWWindowCloseCallback() {
        super("(p)v");
    }

    GLFWWindowCloseCallback(long functionPointer) {
        super(functionPointer);
    }

    public GLFWWindowCloseCallback set(long window) {
        GLFW.glfwSetWindowCloseCallback(window, this);
        return this;
    }

    private static final class Container
    extends GLFWWindowCloseCallback {
        private final GLFWWindowCloseCallbackI delegate;

        Container(long functionPointer, GLFWWindowCloseCallbackI delegate) {
            super(functionPointer);
            this.delegate = delegate;
        }

        @Override
        public void invoke(long window) {
            this.delegate.invoke(window);
        }
    }
}

