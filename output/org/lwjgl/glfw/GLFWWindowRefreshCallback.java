/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowRefreshCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWWindowRefreshCallback
extends Callback
implements GLFWWindowRefreshCallbackI {
    public static GLFWWindowRefreshCallback create(long functionPointer) {
        GLFWWindowRefreshCallbackI instance = (GLFWWindowRefreshCallbackI)Callback.get(functionPointer);
        return instance instanceof GLFWWindowRefreshCallback ? (GLFWWindowRefreshCallback)instance : new Container(functionPointer, instance);
    }

    @Nullable
    public static GLFWWindowRefreshCallback createSafe(long functionPointer) {
        return functionPointer == 0L ? null : GLFWWindowRefreshCallback.create(functionPointer);
    }

    public static GLFWWindowRefreshCallback create(GLFWWindowRefreshCallbackI instance) {
        return instance instanceof GLFWWindowRefreshCallback ? (GLFWWindowRefreshCallback)instance : new Container(instance.address(), instance);
    }

    protected GLFWWindowRefreshCallback() {
        super("(p)v");
    }

    GLFWWindowRefreshCallback(long functionPointer) {
        super(functionPointer);
    }

    public GLFWWindowRefreshCallback set(long window) {
        GLFW.glfwSetWindowRefreshCallback(window, this);
        return this;
    }

    private static final class Container
    extends GLFWWindowRefreshCallback {
        private final GLFWWindowRefreshCallbackI delegate;

        Container(long functionPointer, GLFWWindowRefreshCallbackI delegate) {
            super(functionPointer);
            this.delegate = delegate;
        }

        @Override
        public void invoke(long window) {
            this.delegate.invoke(window);
        }
    }
}

