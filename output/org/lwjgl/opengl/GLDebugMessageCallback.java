/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import javax.annotation.Nullable;
import org.lwjgl.opengl.GLDebugMessageCallbackI;
import org.lwjgl.system.Callback;
import org.lwjgl.system.MemoryUtil;

public abstract class GLDebugMessageCallback
extends Callback
implements GLDebugMessageCallbackI {
    public static GLDebugMessageCallback create(long functionPointer) {
        GLDebugMessageCallbackI instance = (GLDebugMessageCallbackI)Callback.get(functionPointer);
        return instance instanceof GLDebugMessageCallback ? (GLDebugMessageCallback)instance : new Container(functionPointer, instance);
    }

    @Nullable
    public static GLDebugMessageCallback createSafe(long functionPointer) {
        return functionPointer == 0L ? null : GLDebugMessageCallback.create(functionPointer);
    }

    public static GLDebugMessageCallback create(GLDebugMessageCallbackI instance) {
        return instance instanceof GLDebugMessageCallback ? (GLDebugMessageCallback)instance : new Container(instance.address(), instance);
    }

    protected GLDebugMessageCallback() {
        super(SIGNATURE);
    }

    GLDebugMessageCallback(long functionPointer) {
        super(functionPointer);
    }

    public static String getMessage(int length, long message) {
        return MemoryUtil.memUTF8(MemoryUtil.memByteBuffer(message, length));
    }

    private static final class Container
    extends GLDebugMessageCallback {
        private final GLDebugMessageCallbackI delegate;

        Container(long functionPointer, GLDebugMessageCallbackI delegate) {
            super(functionPointer);
            this.delegate = delegate;
        }

        @Override
        public void invoke(int source, int type, int id, int severity, int length, long message, long userParam) {
            this.delegate.invoke(source, type, id, severity, length, message, userParam);
        }
    }
}

