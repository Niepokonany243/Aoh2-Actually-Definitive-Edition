/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCharModsCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWCharModsCallback
extends Callback
implements GLFWCharModsCallbackI {
    public static GLFWCharModsCallback create(long functionPointer) {
        GLFWCharModsCallbackI instance = (GLFWCharModsCallbackI)Callback.get(functionPointer);
        return instance instanceof GLFWCharModsCallback ? (GLFWCharModsCallback)instance : new Container(functionPointer, instance);
    }

    @Nullable
    public static GLFWCharModsCallback createSafe(long functionPointer) {
        return functionPointer == 0L ? null : GLFWCharModsCallback.create(functionPointer);
    }

    public static GLFWCharModsCallback create(GLFWCharModsCallbackI instance) {
        return instance instanceof GLFWCharModsCallback ? (GLFWCharModsCallback)instance : new Container(instance.address(), instance);
    }

    protected GLFWCharModsCallback() {
        super("(pii)v");
    }

    GLFWCharModsCallback(long functionPointer) {
        super(functionPointer);
    }

    public GLFWCharModsCallback set(long window) {
        GLFW.glfwSetCharModsCallback(window, this);
        return this;
    }

    private static final class Container
    extends GLFWCharModsCallback {
        private final GLFWCharModsCallbackI delegate;

        Container(long functionPointer, GLFWCharModsCallbackI delegate) {
            super(functionPointer);
            this.delegate = delegate;
        }

        @Override
        public void invoke(long window, int codepoint, int mods) {
            this.delegate.invoke(window, codepoint, mods);
        }
    }
}

