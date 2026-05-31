/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWFramebufferSizeCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWFramebufferSizeCallback
extends Callback
implements GLFWFramebufferSizeCallbackI {
    public static GLFWFramebufferSizeCallback create(long functionPointer) {
        GLFWFramebufferSizeCallbackI instance = (GLFWFramebufferSizeCallbackI)Callback.get(functionPointer);
        return instance instanceof GLFWFramebufferSizeCallback ? (GLFWFramebufferSizeCallback)instance : new Container(functionPointer, instance);
    }

    @Nullable
    public static GLFWFramebufferSizeCallback createSafe(long functionPointer) {
        return functionPointer == 0L ? null : GLFWFramebufferSizeCallback.create(functionPointer);
    }

    public static GLFWFramebufferSizeCallback create(GLFWFramebufferSizeCallbackI instance) {
        return instance instanceof GLFWFramebufferSizeCallback ? (GLFWFramebufferSizeCallback)instance : new Container(instance.address(), instance);
    }

    protected GLFWFramebufferSizeCallback() {
        super("(pii)v");
    }

    GLFWFramebufferSizeCallback(long functionPointer) {
        super(functionPointer);
    }

    public GLFWFramebufferSizeCallback set(long window) {
        GLFW.glfwSetFramebufferSizeCallback(window, this);
        return this;
    }

    private static final class Container
    extends GLFWFramebufferSizeCallback {
        private final GLFWFramebufferSizeCallbackI delegate;

        Container(long functionPointer, GLFWFramebufferSizeCallbackI delegate) {
            super(functionPointer);
            this.delegate = delegate;
        }

        @Override
        public void invoke(long window, int width, int height) {
            this.delegate.invoke(window, width, height);
        }
    }
}

