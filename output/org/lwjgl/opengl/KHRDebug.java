/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.opengl.GLDebugMessageCallbackI;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class KHRDebug {
    public static final int GL_DEBUG_OUTPUT = 37600;
    public static final int GL_DEBUG_OUTPUT_SYNCHRONOUS = 33346;
    public static final int GL_CONTEXT_FLAG_DEBUG_BIT = 2;
    public static final int GL_MAX_DEBUG_MESSAGE_LENGTH = 37187;
    public static final int GL_MAX_DEBUG_LOGGED_MESSAGES = 37188;
    public static final int GL_DEBUG_LOGGED_MESSAGES = 37189;
    public static final int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH = 33347;
    public static final int GL_MAX_DEBUG_GROUP_STACK_DEPTH = 33388;
    public static final int GL_DEBUG_GROUP_STACK_DEPTH = 33389;
    public static final int GL_MAX_LABEL_LENGTH = 33512;
    public static final int GL_DEBUG_CALLBACK_FUNCTION = 33348;
    public static final int GL_DEBUG_CALLBACK_USER_PARAM = 33349;
    public static final int GL_DEBUG_SOURCE_API = 33350;
    public static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM = 33351;
    public static final int GL_DEBUG_SOURCE_SHADER_COMPILER = 33352;
    public static final int GL_DEBUG_SOURCE_THIRD_PARTY = 33353;
    public static final int GL_DEBUG_SOURCE_APPLICATION = 33354;
    public static final int GL_DEBUG_SOURCE_OTHER = 33355;
    public static final int GL_DEBUG_TYPE_ERROR = 33356;
    public static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR = 33357;
    public static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR = 33358;
    public static final int GL_DEBUG_TYPE_PORTABILITY = 33359;
    public static final int GL_DEBUG_TYPE_PERFORMANCE = 33360;
    public static final int GL_DEBUG_TYPE_OTHER = 33361;
    public static final int GL_DEBUG_TYPE_MARKER = 33384;
    public static final int GL_DEBUG_TYPE_PUSH_GROUP = 33385;
    public static final int GL_DEBUG_TYPE_POP_GROUP = 33386;
    public static final int GL_DEBUG_SEVERITY_HIGH = 37190;
    public static final int GL_DEBUG_SEVERITY_MEDIUM = 37191;
    public static final int GL_DEBUG_SEVERITY_LOW = 37192;
    public static final int GL_DEBUG_SEVERITY_NOTIFICATION = 33387;
    public static final int GL_BUFFER = 33504;
    public static final int GL_SHADER = 33505;
    public static final int GL_PROGRAM = 33506;
    public static final int GL_QUERY = 33507;
    public static final int GL_PROGRAM_PIPELINE = 33508;
    public static final int GL_SAMPLER = 33510;
    public static final int GL_DISPLAY_LIST = 33511;

    protected KHRDebug() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glDebugMessageControl, caps.glDebugMessageInsert, caps.glDebugMessageCallback, caps.glGetDebugMessageLog, caps.glPushDebugGroup, caps.glPopDebugGroup, caps.glObjectLabel, caps.glGetObjectLabel, caps.glObjectPtrLabel, caps.glGetObjectPtrLabel);
    }

    public static void nglDebugMessageControl(int source, int type, int severity, int count, long ids, boolean enabled) {
        GL43C.nglDebugMessageControl(source, type, severity, count, ids, enabled);
    }

    public static void glDebugMessageControl(@NativeType(value="GLenum") int source, @NativeType(value="GLenum") int type, @NativeType(value="GLenum") int severity, @Nullable @NativeType(value="GLuint const *") IntBuffer ids, @NativeType(value="GLboolean") boolean enabled) {
        GL43C.glDebugMessageControl(source, type, severity, ids, enabled);
    }

    public static void glDebugMessageControl(@NativeType(value="GLenum") int source, @NativeType(value="GLenum") int type, @NativeType(value="GLenum") int severity, @NativeType(value="GLuint const *") int id, @NativeType(value="GLboolean") boolean enabled) {
        GL43C.glDebugMessageControl(source, type, severity, id, enabled);
    }

    public static void nglDebugMessageInsert(int source, int type, int id, int severity, int length, long message) {
        GL43C.nglDebugMessageInsert(source, type, id, severity, length, message);
    }

    public static void glDebugMessageInsert(@NativeType(value="GLenum") int source, @NativeType(value="GLenum") int type, @NativeType(value="GLuint") int id, @NativeType(value="GLenum") int severity, @NativeType(value="GLchar const *") ByteBuffer message) {
        GL43C.glDebugMessageInsert(source, type, id, severity, message);
    }

    public static void glDebugMessageInsert(@NativeType(value="GLenum") int source, @NativeType(value="GLenum") int type, @NativeType(value="GLuint") int id, @NativeType(value="GLenum") int severity, @NativeType(value="GLchar const *") CharSequence message) {
        GL43C.glDebugMessageInsert(source, type, id, severity, message);
    }

    public static void nglDebugMessageCallback(long callback, long userParam) {
        GL43C.nglDebugMessageCallback(callback, userParam);
    }

    public static void glDebugMessageCallback(@Nullable @NativeType(value="GLDEBUGPROC") GLDebugMessageCallbackI callback, @NativeType(value="void const *") long userParam) {
        GL43C.glDebugMessageCallback(callback, userParam);
    }

    public static int nglGetDebugMessageLog(int count, int bufsize, long sources, long types, long ids, long severities, long lengths, long messageLog) {
        return GL43C.nglGetDebugMessageLog(count, bufsize, sources, types, ids, severities, lengths, messageLog);
    }

    @NativeType(value="GLuint")
    public static int glGetDebugMessageLog(@NativeType(value="GLuint") int count, @Nullable @NativeType(value="GLenum *") IntBuffer sources, @Nullable @NativeType(value="GLenum *") IntBuffer types, @Nullable @NativeType(value="GLuint *") IntBuffer ids, @Nullable @NativeType(value="GLenum *") IntBuffer severities, @Nullable @NativeType(value="GLsizei *") IntBuffer lengths, @Nullable @NativeType(value="GLchar *") ByteBuffer messageLog) {
        return GL43C.glGetDebugMessageLog(count, sources, types, ids, severities, lengths, messageLog);
    }

    public static void nglPushDebugGroup(int source, int id, int length, long message) {
        GL43C.nglPushDebugGroup(source, id, length, message);
    }

    public static void glPushDebugGroup(@NativeType(value="GLenum") int source, @NativeType(value="GLuint") int id, @NativeType(value="GLchar const *") ByteBuffer message) {
        GL43C.glPushDebugGroup(source, id, message);
    }

    public static void glPushDebugGroup(@NativeType(value="GLenum") int source, @NativeType(value="GLuint") int id, @NativeType(value="GLchar const *") CharSequence message) {
        GL43C.glPushDebugGroup(source, id, message);
    }

    public static void glPopDebugGroup() {
        GL43C.glPopDebugGroup();
    }

    public static void nglObjectLabel(int identifier, int name, int length, long label) {
        GL43C.nglObjectLabel(identifier, name, length, label);
    }

    public static void glObjectLabel(@NativeType(value="GLenum") int identifier, @NativeType(value="GLuint") int name, @NativeType(value="GLchar const *") ByteBuffer label) {
        GL43C.glObjectLabel(identifier, name, label);
    }

    public static void glObjectLabel(@NativeType(value="GLenum") int identifier, @NativeType(value="GLuint") int name, @NativeType(value="GLchar const *") CharSequence label) {
        GL43C.glObjectLabel(identifier, name, label);
    }

    public static void nglGetObjectLabel(int identifier, int name, int bufSize, long length, long label) {
        GL43C.nglGetObjectLabel(identifier, name, bufSize, length, label);
    }

    public static void glGetObjectLabel(@NativeType(value="GLenum") int identifier, @NativeType(value="GLuint") int name, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer label) {
        GL43C.glGetObjectLabel(identifier, name, length, label);
    }

    @NativeType(value="void")
    public static String glGetObjectLabel(@NativeType(value="GLenum") int identifier, @NativeType(value="GLuint") int name, @NativeType(value="GLsizei") int bufSize) {
        return GL43C.glGetObjectLabel(identifier, name, bufSize);
    }

    @NativeType(value="void")
    public static String glGetObjectLabel(@NativeType(value="GLenum") int identifier, @NativeType(value="GLuint") int name) {
        return KHRDebug.glGetObjectLabel(identifier, name, GL11.glGetInteger(33512));
    }

    public static void nglObjectPtrLabel(long ptr, int length, long label) {
        GL43C.nglObjectPtrLabel(ptr, length, label);
    }

    public static void glObjectPtrLabel(@NativeType(value="void *") long ptr, @NativeType(value="GLchar const *") ByteBuffer label) {
        GL43C.glObjectPtrLabel(ptr, label);
    }

    public static void glObjectPtrLabel(@NativeType(value="void *") long ptr, @NativeType(value="GLchar const *") CharSequence label) {
        GL43C.glObjectPtrLabel(ptr, label);
    }

    public static void nglGetObjectPtrLabel(long ptr, int bufSize, long length, long label) {
        GL43C.nglGetObjectPtrLabel(ptr, bufSize, length, label);
    }

    public static void glGetObjectPtrLabel(@NativeType(value="void *") long ptr, @Nullable @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer label) {
        GL43C.glGetObjectPtrLabel(ptr, length, label);
    }

    @NativeType(value="void")
    public static String glGetObjectPtrLabel(@NativeType(value="void *") long ptr, @NativeType(value="GLsizei") int bufSize) {
        return GL43C.glGetObjectPtrLabel(ptr, bufSize);
    }

    @NativeType(value="void")
    public static String glGetObjectPtrLabel(@NativeType(value="void *") long ptr) {
        return KHRDebug.glGetObjectPtrLabel(ptr, GL11.glGetInteger(33512));
    }

    public static void glDebugMessageControl(@NativeType(value="GLenum") int source, @NativeType(value="GLenum") int type, @NativeType(value="GLenum") int severity, @Nullable @NativeType(value="GLuint const *") int[] ids, @NativeType(value="GLboolean") boolean enabled) {
        GL43C.glDebugMessageControl(source, type, severity, ids, enabled);
    }

    @NativeType(value="GLuint")
    public static int glGetDebugMessageLog(@NativeType(value="GLuint") int count, @Nullable @NativeType(value="GLenum *") int[] sources, @Nullable @NativeType(value="GLenum *") int[] types, @Nullable @NativeType(value="GLuint *") int[] ids, @Nullable @NativeType(value="GLenum *") int[] severities, @Nullable @NativeType(value="GLsizei *") int[] lengths, @Nullable @NativeType(value="GLchar *") ByteBuffer messageLog) {
        return GL43C.glGetDebugMessageLog(count, sources, types, ids, severities, lengths, messageLog);
    }

    public static void glGetObjectLabel(@NativeType(value="GLenum") int identifier, @NativeType(value="GLuint") int name, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer label) {
        GL43C.glGetObjectLabel(identifier, name, length, label);
    }

    public static void glGetObjectPtrLabel(@NativeType(value="void *") long ptr, @Nullable @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer label) {
        GL43C.glGetObjectPtrLabel(ptr, length, label);
    }

    static {
        GL.initialize();
    }
}

