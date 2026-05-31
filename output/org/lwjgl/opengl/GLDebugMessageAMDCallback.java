/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import javax.annotation.Nullable;
import org.lwjgl.opengl.GLDebugMessageAMDCallbackI;
import org.lwjgl.system.Callback;
import org.lwjgl.system.MemoryUtil;

public abstract class GLDebugMessageAMDCallback
extends Callback
implements GLDebugMessageAMDCallbackI {
    public static GLDebugMessageAMDCallback create(long functionPointer) {
        GLDebugMessageAMDCallbackI instance = (GLDebugMessageAMDCallbackI)Callback.get(functionPointer);
        return instance instanceof GLDebugMessageAMDCallback ? (GLDebugMessageAMDCallback)instance : new Container(functionPointer, instance);
    }

    @Nullable
    public static GLDebugMessageAMDCallback createSafe(long functionPointer) {
        return functionPointer == 0L ? null : GLDebugMessageAMDCallback.create(functionPointer);
    }

    public static GLDebugMessageAMDCallback create(GLDebugMessageAMDCallbackI instance) {
        return instance instanceof GLDebugMessageAMDCallback ? (GLDebugMessageAMDCallback)instance : new Container(instance.address(), instance);
    }

    protected GLDebugMessageAMDCallback() {
        super(SIGNATURE);
    }

    GLDebugMessageAMDCallback(long functionPointer) {
        super(functionPointer);
    }

    public static String getMessage(int length, long message) {
        return MemoryUtil.memUTF8(MemoryUtil.memByteBuffer(message, length));
    }

    private static final class Container
    extends GLDebugMessageAMDCallback {
        private final GLDebugMessageAMDCallbackI delegate;

        Container(long functionPointer, GLDebugMessageAMDCallbackI delegate) {
            super(functionPointer);
            this.delegate = delegate;
        }

        @Override
        public void invoke(int id, int category, int severity, int length, long message, long userParam) {
            this.delegate.invoke(id, category, severity, length, message, userParam);
        }
    }
}

