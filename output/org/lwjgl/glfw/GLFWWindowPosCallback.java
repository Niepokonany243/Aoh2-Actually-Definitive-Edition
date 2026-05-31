/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowPosCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWWindowPosCallback
extends Callback
implements GLFWWindowPosCallbackI {
    public static GLFWWindowPosCallback create(long functionPointer) {
        GLFWWindowPosCallbackI instance = (GLFWWindowPosCallbackI)Callback.get(functionPointer);
        return instance instanceof GLFWWindowPosCallback ? (GLFWWindowPosCallback)instance : new Container(functionPointer, instance);
    }

    @Nullable
    public static GLFWWindowPosCallback createSafe(long functionPointer) {
        return functionPointer == 0L ? null : GLFWWindowPosCallback.create(functionPointer);
    }

    public static GLFWWindowPosCallback create(GLFWWindowPosCallbackI instance) {
        return instance instanceof GLFWWindowPosCallback ? (GLFWWindowPosCallback)instance : new Container(instance.address(), instance);
    }

    protected GLFWWindowPosCallback() {
        super("(pii)v");
    }

    GLFWWindowPosCallback(long functionPointer) {
        super(functionPointer);
    }

    public GLFWWindowPosCallback set(long window) {
        GLFW.glfwSetWindowPosCallback(window, this);
        return this;
    }

    private static final class Container
    extends GLFWWindowPosCallback {
        private final GLFWWindowPosCallbackI delegate;

        Container(long functionPointer, GLFWWindowPosCallbackI delegate) {
            super(functionPointer);
            this.delegate = delegate;
        }

        @Override
        public void invoke(long window, int xpos, int ypos) {
            this.delegate.invoke(window, xpos, ypos);
        }
    }
}

