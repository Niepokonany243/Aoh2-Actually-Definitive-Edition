/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.opengl.GLDebugMessageARBCallbackI;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBDebugOutput {
    public static final int GL_DEBUG_OUTPUT_SYNCHRONOUS_ARB = 33346;
    public static final int GL_MAX_DEBUG_MESSAGE_LENGTH_ARB = 37187;
    public static final int GL_MAX_DEBUG_LOGGED_MESSAGES_ARB = 37188;
    public static final int GL_DEBUG_LOGGED_MESSAGES_ARB = 37189;
    public static final int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH_ARB = 33347;
    public static final int GL_DEBUG_CALLBACK_FUNCTION_ARB = 33348;
    public static final int GL_DEBUG_CALLBACK_USER_PARAM_ARB = 33349;
    public static final int GL_DEBUG_SOURCE_API_ARB = 33350;
    public static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM_ARB = 33351;
    public static final int GL_DEBUG_SOURCE_SHADER_COMPILER_ARB = 33352;
    public static final int GL_DEBUG_SOURCE_THIRD_PARTY_ARB = 33353;
    public static final int GL_DEBUG_SOURCE_APPLICATION_ARB = 33354;
    public static final int GL_DEBUG_SOURCE_OTHER_ARB = 33355;
    public static final int GL_DEBUG_TYPE_ERROR_ARB = 33356;
    public static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR_ARB = 33357;
    public static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR_ARB = 33358;
    public static final int GL_DEBUG_TYPE_PORTABILITY_ARB = 33359;
    public static final int GL_DEBUG_TYPE_PERFORMANCE_ARB = 33360;
    public static final int GL_DEBUG_TYPE_OTHER_ARB = 33361;
    public static final int GL_DEBUG_SEVERITY_HIGH_ARB = 37190;
    public static final int GL_DEBUG_SEVERITY_MEDIUM_ARB = 37191;
    public static final int GL_DEBUG_SEVERITY_LOW_ARB = 37192;

    protected ARBDebugOutput() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glDebugMessageControlARB, caps.glDebugMessageInsertARB, caps.glDebugMessageCallbackARB, caps.glGetDebugMessageLogARB);
    }

    public static native void nglDebugMessageControlARB(int var0, int var1, int var2, int var3, long var4, boolean var6);

    public static void glDebugMessageControlARB(@NativeType(value="GLenum") int source, @NativeType(value="GLenum") int type, @NativeType(value="GLenum") int severity, @Nullable @NativeType(value="GLuint const *") IntBuffer ids, @NativeType(value="GLboolean") boolean enabled) {
        ARBDebugOutput.nglDebugMessageControlARB(source, type, severity, Checks.remainingSafe(ids), MemoryUtil.memAddressSafe(ids), enabled);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDebugMessageControlARB(@NativeType(value="GLenum") int source, @NativeType(value="GLenum") int type, @NativeType(value="GLenum") int severity, @NativeType(value="GLuint const *") int id, @NativeType(value="GLboolean") boolean enabled) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer ids = stack.ints(id);
            ARBDebugOutput.nglDebugMessageControlARB(source, type, severity, 1, MemoryUtil.memAddress(ids), enabled);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglDebugMessageInsertARB(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glDebugMessageInsertARB(@NativeType(value="GLenum") int source, @NativeType(value="GLenum") int type, @NativeType(value="GLuint") int id, @NativeType(value="GLenum") int severity, @NativeType(value="GLchar const *") ByteBuffer buf) {
        ARBDebugOutput.nglDebugMessageInsertARB(source, type, id, severity, buf.remaining(), MemoryUtil.memAddress(buf));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDebugMessageInsertARB(@NativeType(value="GLenum") int source, @NativeType(value="GLenum") int type, @NativeType(value="GLuint") int id, @NativeType(value="GLenum") int severity, @NativeType(value="GLchar const *") CharSequence buf) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            int bufEncodedLength = stack.nUTF8(buf, false);
            long bufEncoded = stack.getPointerAddress();
            ARBDebugOutput.nglDebugMessageInsertARB(source, type, id, severity, bufEncodedLength, bufEncoded);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglDebugMessageCallbackARB(long var0, long var2);

    public static void glDebugMessageCallbackARB(@Nullable @NativeType(value="GLDEBUGPROCARB") GLDebugMessageARBCallbackI callback, @NativeType(value="void const *") long userParam) {
        ARBDebugOutput.nglDebugMessageCallbackARB(MemoryUtil.memAddressSafe(callback), userParam);
    }

    public static native int nglGetDebugMessageLogARB(int var0, int var1, long var2, long var4, long var6, long var8, long var10, long var12);

    @NativeType(value="GLuint")
    public static int glGetDebugMessageLogARB(@NativeType(value="GLuint") int count, @Nullable @NativeType(value="GLenum *") IntBuffer sources, @Nullable @NativeType(value="GLenum *") IntBuffer types, @Nullable @NativeType(value="GLuint *") IntBuffer ids, @Nullable @NativeType(value="GLenum *") IntBuffer severities, @Nullable @NativeType(value="GLsizei *") IntBuffer lengths, @Nullable @NativeType(value="GLchar *") ByteBuffer messageLog) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)sources, count);
            Checks.checkSafe((Buffer)types, count);
            Checks.checkSafe((Buffer)ids, count);
            Checks.checkSafe((Buffer)severities, count);
            Checks.checkSafe((Buffer)lengths, count);
        }
        return ARBDebugOutput.nglGetDebugMessageLogARB(count, Checks.remainingSafe(messageLog), MemoryUtil.memAddressSafe(sources), MemoryUtil.memAddressSafe(types), MemoryUtil.memAddressSafe(ids), MemoryUtil.memAddressSafe(severities), MemoryUtil.memAddressSafe(lengths), MemoryUtil.memAddressSafe(messageLog));
    }

    public static void glDebugMessageControlARB(@NativeType(value="GLenum") int source, @NativeType(value="GLenum") int type, @NativeType(value="GLenum") int severity, @Nullable @NativeType(value="GLuint const *") int[] ids, @NativeType(value="GLboolean") boolean enabled) {
        long __functionAddress = GL.getICD().glDebugMessageControlARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(source, type, severity, Checks.lengthSafe(ids), ids, enabled, __functionAddress);
    }

    @NativeType(value="GLuint")
    public static int glGetDebugMessageLogARB(@NativeType(value="GLuint") int count, @Nullable @NativeType(value="GLenum *") int[] sources, @Nullable @NativeType(value="GLenum *") int[] types, @Nullable @NativeType(value="GLuint *") int[] ids, @Nullable @NativeType(value="GLenum *") int[] severities, @Nullable @NativeType(value="GLsizei *") int[] lengths, @Nullable @NativeType(value="GLchar *") ByteBuffer messageLog) {
        long __functionAddress = GL.getICD().glGetDebugMessageLogARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(sources, count);
            Checks.checkSafe(types, count);
            Checks.checkSafe(ids, count);
            Checks.checkSafe(severities, count);
            Checks.checkSafe(lengths, count);
        }
        return JNI.callPPPPPPI(count, Checks.remainingSafe(messageLog), sources, types, ids, severities, lengths, MemoryUtil.memAddressSafe(messageLog), __functionAddress);
    }

    static {
        GL.initialize();
    }
}

