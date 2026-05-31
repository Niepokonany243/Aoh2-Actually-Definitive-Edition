/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWJoystickCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWJoystickCallback
extends Callback
implements GLFWJoystickCallbackI {
    public static GLFWJoystickCallback create(long functionPointer) {
        GLFWJoystickCallbackI instance = (GLFWJoystickCallbackI)Callback.get(functionPointer);
        return instance instanceof GLFWJoystickCallback ? (GLFWJoystickCallback)instance : new Container(functionPointer, instance);
    }

    @Nullable
    public static GLFWJoystickCallback createSafe(long functionPointer) {
        return functionPointer == 0L ? null : GLFWJoystickCallback.create(functionPointer);
    }

    public static GLFWJoystickCallback create(GLFWJoystickCallbackI instance) {
        return instance instanceof GLFWJoystickCallback ? (GLFWJoystickCallback)instance : new Container(instance.address(), instance);
    }

    protected GLFWJoystickCallback() {
        super("(ii)v");
    }

    GLFWJoystickCallback(long functionPointer) {
        super(functionPointer);
    }

    public GLFWJoystickCallback set() {
        GLFW.glfwSetJoystickCallback(this);
        return this;
    }

    private static final class Container
    extends GLFWJoystickCallback {
        private final GLFWJoystickCallbackI delegate;

        Container(long functionPointer, GLFWJoystickCallbackI delegate) {
            super(functionPointer);
            this.delegate = delegate;
        }

        @Override
        public void invoke(int jid, int event) {
            this.delegate.invoke(jid, event);
        }
    }
}

