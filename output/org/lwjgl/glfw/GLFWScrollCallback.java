/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWScrollCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWScrollCallback
extends Callback
implements GLFWScrollCallbackI {
    public static GLFWScrollCallback create(long functionPointer) {
        GLFWScrollCallbackI instance = (GLFWScrollCallbackI)Callback.get(functionPointer);
        return instance instanceof GLFWScrollCallback ? (GLFWScrollCallback)instance : new Container(functionPointer, instance);
    }

    @Nullable
    public static GLFWScrollCallback createSafe(long functionPointer) {
        return functionPointer == 0L ? null : GLFWScrollCallback.create(functionPointer);
    }

    public static GLFWScrollCallback create(GLFWScrollCallbackI instance) {
        return instance instanceof GLFWScrollCallback ? (GLFWScrollCallback)instance : new Container(instance.address(), instance);
    }

    protected GLFWScrollCallback() {
        super("(pdd)v");
    }

    GLFWScrollCallback(long functionPointer) {
        super(functionPointer);
    }

    public GLFWScrollCallback set(long window) {
        GLFW.glfwSetScrollCallback(window, this);
        return this;
    }

    private static final class Container
    extends GLFWScrollCallback {
        private final GLFWScrollCallbackI delegate;

        Container(long functionPointer, GLFWScrollCallbackI delegate) {
            super(functionPointer);
            this.delegate = delegate;
        }

        @Override
        public void invoke(long window, double xoffset, double yoffset) {
            this.delegate.invoke(window, xoffset, yoffset);
        }
    }
}

