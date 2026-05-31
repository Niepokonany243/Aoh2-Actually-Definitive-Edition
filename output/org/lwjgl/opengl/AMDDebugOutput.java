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
import org.lwjgl.opengl.GLDebugMessageAMDCallbackI;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class AMDDebugOutput {
    public static final int GL_MAX_DEBUG_MESSAGE_LENGTH_AMD = 37187;
    public static final int GL_MAX_DEBUG_LOGGED_MESSAGES_AMD = 37188;
    public static final int GL_DEBUG_LOGGED_MESSAGES_AMD = 37189;
    public static final int GL_DEBUG_SEVERITY_HIGH_AMD = 37190;
    public static final int GL_DEBUG_SEVERITY_MEDIUM_AMD = 37191;
    public static final int GL_DEBUG_SEVERITY_LOW_AMD = 37192;
    public static final int GL_DEBUG_CATEGORY_API_ERROR_AMD = 37193;
    public static final int GL_DEBUG_CATEGORY_WINDOW_SYSTEM_AMD = 37194;
    public static final int GL_DEBUG_CATEGORY_DEPRECATION_AMD = 37195;
    public static final int GL_DEBUG_CATEGORY_UNDEFINED_BEHAVIOR_AMD = 37196;
    public static final int GL_DEBUG_CATEGORY_PERFORMANCE_AMD = 37197;
    public static final int GL_DEBUG_CATEGORY_SHADER_COMPILER_AMD = 37198;
    public static final int GL_DEBUG_CATEGORY_APPLICATION_AMD = 37199;
    public static final int GL_DEBUG_CATEGORY_OTHER_AMD = 37200;

    protected AMDDebugOutput() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glDebugMessageEnableAMD, caps.glDebugMessageInsertAMD, caps.glDebugMessageCallbackAMD, caps.glGetDebugMessageLogAMD);
    }

    public static native void nglDebugMessageEnableAMD(int var0, int var1, int var2, long var3, boolean var5);

    public static void glDebugMessageEnableAMD(@NativeType(value="GLenum") int category, @NativeType(value="GLenum") int severity, @Nullable @NativeType(value="GLuint const *") IntBuffer ids, @NativeType(value="GLboolean") boolean enabled) {
        AMDDebugOutput.nglDebugMessageEnableAMD(category, severity, Checks.remainingSafe(ids), MemoryUtil.memAddressSafe(ids), enabled);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDebugMessageEnableAMD(@NativeType(value="GLenum") int category, @NativeType(value="GLenum") int severity, @NativeType(value="GLuint const *") int id, @NativeType(value="GLboolean") boolean enabled) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer ids = stack.ints(id);
            AMDDebugOutput.nglDebugMessageEnableAMD(category, severity, 1, MemoryUtil.memAddress(ids), enabled);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglDebugMessageInsertAMD(int var0, int var1, int var2, int var3, long var4);

    public static void glDebugMessageInsertAMD(@NativeType(value="GLenum") int category, @NativeType(value="GLenum") int severity, @NativeType(value="GLuint") int id, @NativeType(value="GLchar const *") ByteBuffer buf) {
        AMDDebugOutput.nglDebugMessageInsertAMD(category, severity, id, buf.remaining(), MemoryUtil.memAddress(buf));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDebugMessageInsertAMD(@NativeType(value="GLenum") int category, @NativeType(value="GLenum") int severity, @NativeType(value="GLuint") int id, @NativeType(value="GLchar const *") CharSequence buf) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            int bufEncodedLength = stack.nUTF8(buf, false);
            long bufEncoded = stack.getPointerAddress();
            AMDDebugOutput.nglDebugMessageInsertAMD(category, severity, id, bufEncodedLength, bufEncoded);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglDebugMessageCallbackAMD(long var0, long var2);

    public static void glDebugMessageCallbackAMD(@Nullable @NativeType(value="GLDEBUGPROCAMD") GLDebugMessageAMDCallbackI callback, @NativeType(value="void *") long userParam) {
        AMDDebugOutput.nglDebugMessageCallbackAMD(MemoryUtil.memAddressSafe(callback), userParam);
    }

    public static native int nglGetDebugMessageLogAMD(int var0, int var1, long var2, long var4, long var6, long var8, long var10);

    @NativeType(value="GLuint")
    public static int glGetDebugMessageLogAMD(@NativeType(value="GLuint") int count, @Nullable @NativeType(value="GLenum *") IntBuffer categories, @Nullable @NativeType(value="GLuint *") IntBuffer severities, @Nullable @NativeType(value="GLuint *") IntBuffer ids, @Nullable @NativeType(value="GLsizei *") IntBuffer lengths, @Nullable @NativeType(value="GLchar *") ByteBuffer messageLog) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)categories, count);
            Checks.checkSafe((Buffer)severities, count);
            Checks.checkSafe((Buffer)ids, count);
            Checks.checkSafe((Buffer)lengths, count);
        }
        return AMDDebugOutput.nglGetDebugMessageLogAMD(count, Checks.remainingSafe(messageLog), MemoryUtil.memAddressSafe(categories), MemoryUtil.memAddressSafe(severities), MemoryUtil.memAddressSafe(ids), MemoryUtil.memAddressSafe(lengths), MemoryUtil.memAddressSafe(messageLog));
    }

    public static void glDebugMessageEnableAMD(@NativeType(value="GLenum") int category, @NativeType(value="GLenum") int severity, @Nullable @NativeType(value="GLuint const *") int[] ids, @NativeType(value="GLboolean") boolean enabled) {
        long __functionAddress = GL.getICD().glDebugMessageEnableAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
        }
        JNI.callPV(category, severity, Checks.lengthSafe(ids), ids, enabled, __functionAddress);
    }

    @NativeType(value="GLuint")
    public static int glGetDebugMessageLogAMD(@NativeType(value="GLuint") int count, @Nullable @NativeType(value="GLenum *") int[] categories, @Nullable @NativeType(value="GLuint *") int[] severities, @Nullable @NativeType(value="GLuint *") int[] ids, @Nullable @NativeType(value="GLsizei *") int[] lengths, @Nullable @NativeType(value="GLchar *") ByteBuffer messageLog) {
        long __functionAddress = GL.getICD().glGetDebugMessageLogAMD;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(categories, count);
            Checks.checkSafe(severities, count);
            Checks.checkSafe(ids, count);
            Checks.checkSafe(lengths, count);
        }
        return JNI.callPPPPPI(count, Checks.remainingSafe(messageLog), categories, severities, ids, lengths, MemoryUtil.memAddressSafe(messageLog), __functionAddress);
    }

    static {
        GL.initialize();
    }
}

