/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWMouseButtonCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWMouseButtonCallback
extends Callback
implements GLFWMouseButtonCallbackI {
    public static GLFWMouseButtonCallback create(long functionPointer) {
        GLFWMouseButtonCallbackI instance = (GLFWMouseButtonCallbackI)Callback.get(functionPointer);
        return instance instanceof GLFWMouseButtonCallback ? (GLFWMouseButtonCallback)instance : new Container(functionPointer, instance);
    }

    @Nullable
    public static GLFWMouseButtonCallback createSafe(long functionPointer) {
        return functionPointer == 0L ? null : GLFWMouseButtonCallback.create(functionPointer);
    }

    public static GLFWMouseButtonCallback create(GLFWMouseButtonCallbackI instance) {
        return instance instanceof GLFWMouseButtonCallback ? (GLFWMouseButtonCallback)instance : new Container(instance.address(), instance);
    }

    protected GLFWMouseButtonCallback() {
        super("(piii)v");
    }

    GLFWMouseButtonCallback(long functionPointer) {
        super(functionPointer);
    }

    public GLFWMouseButtonCallback set(long window) {
        GLFW.glfwSetMouseButtonCallback(window, this);
        return this;
    }

    private static final class Container
    extends GLFWMouseButtonCallback {
        private final GLFWMouseButtonCallbackI delegate;

        Container(long functionPointer, GLFWMouseButtonCallbackI delegate) {
            super(functionPointer);
            this.delegate = delegate;
        }

        @Override
        public void invoke(long window, int button, int action, int mods) {
            this.delegate.invoke(window, button, action, mods);
        }
    }
}

