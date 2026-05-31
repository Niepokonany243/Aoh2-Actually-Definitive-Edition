/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowIconifyCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWWindowIconifyCallback
extends Callback
implements GLFWWindowIconifyCallbackI {
    public static GLFWWindowIconifyCallback create(long functionPointer) {
        GLFWWindowIconifyCallbackI instance = (GLFWWindowIconifyCallbackI)Callback.get(functionPointer);
        return instance instanceof GLFWWindowIconifyCallback ? (GLFWWindowIconifyCallback)instance : new Container(functionPointer, instance);
    }

    @Nullable
    public static GLFWWindowIconifyCallback createSafe(long functionPointer) {
        return functionPointer == 0L ? null : GLFWWindowIconifyCallback.create(functionPointer);
    }

    public static GLFWWindowIconifyCallback create(GLFWWindowIconifyCallbackI instance) {
        return instance instanceof GLFWWindowIconifyCallback ? (GLFWWindowIconifyCallback)instance : new Container(instance.address(), instance);
    }

    protected GLFWWindowIconifyCallback() {
        super("(pi)v");
    }

    GLFWWindowIconifyCallback(long functionPointer) {
        super(functionPointer);
    }

    public GLFWWindowIconifyCallback set(long window) {
        GLFW.glfwSetWindowIconifyCallback(window, this);
        return this;
    }

    private static final class Container
    extends GLFWWindowIconifyCallback {
        private final GLFWWindowIconifyCallbackI delegate;

        Container(long functionPointer, GLFWWindowIconifyCallbackI delegate) {
            super(functionPointer);
            this.delegate = delegate;
        }

        @Override
        public void invoke(long window, boolean iconified) {
            this.delegate.invoke(window, iconified);
        }
    }
}

