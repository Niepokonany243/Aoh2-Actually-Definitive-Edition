/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWKeyCallback
extends Callback
implements GLFWKeyCallbackI {
    public static GLFWKeyCallback create(long functionPointer) {
        GLFWKeyCallbackI instance = (GLFWKeyCallbackI)Callback.get(functionPointer);
        return instance instanceof GLFWKeyCallback ? (GLFWKeyCallback)instance : new Container(functionPointer, instance);
    }

    @Nullable
    public static GLFWKeyCallback createSafe(long functionPointer) {
        return functionPointer == 0L ? null : GLFWKeyCallback.create(functionPointer);
    }

    public static GLFWKeyCallback create(GLFWKeyCallbackI instance) {
        return instance instanceof GLFWKeyCallback ? (GLFWKeyCallback)instance : new Container(instance.address(), instance);
    }

    protected GLFWKeyCallback() {
        super("(piiii)v");
    }

    GLFWKeyCallback(long functionPointer) {
        super(functionPointer);
    }

    public GLFWKeyCallback set(long window) {
        GLFW.glfwSetKeyCallback(window, this);
        return this;
    }

    private static final class Container
    extends GLFWKeyCallback {
        private final GLFWKeyCallbackI delegate;

        Container(long functionPointer, GLFWKeyCallbackI delegate) {
            super(functionPointer);
            this.delegate = delegate;
        }

        @Override
        public void invoke(long window, int key, int scancode, int action, int mods) {
            this.delegate.invoke(window, key, scancode, action, mods);
        }
    }
}

