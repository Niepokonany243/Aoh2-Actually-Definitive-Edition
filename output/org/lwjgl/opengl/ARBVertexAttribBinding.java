/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.util.Set;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBVertexAttribBinding {
    public static final int GL_VERTEX_ATTRIB_BINDING = 33492;
    public static final int GL_VERTEX_ATTRIB_RELATIVE_OFFSET = 33493;
    public static final int GL_VERTEX_BINDING_DIVISOR = 33494;
    public static final int GL_VERTEX_BINDING_OFFSET = 33495;
    public static final int GL_VERTEX_BINDING_STRIDE = 33496;
    public static final int GL_VERTEX_BINDING_BUFFER = 36687;
    public static final int GL_MAX_VERTEX_ATTRIB_RELATIVE_OFFSET = 33497;
    public static final int GL_MAX_VERTEX_ATTRIB_BINDINGS = 33498;

    protected ARBVertexAttribBinding() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, Set<String> ext) {
        return Checks.checkFunctions(caps.glBindVertexBuffer, caps.glVertexAttribFormat, caps.glVertexAttribIFormat, caps.glVertexAttribLFormat, caps.glVertexAttribBinding, caps.glVertexBindingDivisor, ext.contains("GL_EXT_direct_state_access") ? caps.glVertexArrayBindVertexBufferEXT : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glVertexArrayVertexAttribFormatEXT : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glVertexArrayVertexAttribIFormatEXT : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glVertexArrayVertexAttribLFormatEXT : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glVertexArrayVertexAttribBindingEXT : -1L, ext.contains("GL_EXT_direct_state_access") ? caps.glVertexArrayVertexBindingDivisorEXT : -1L);
    }

    public static void glBindVertexBuffer(@NativeType(value="GLuint") int bindingindex, @NativeType(value="GLuint") int buffer, @NativeType(value="GLintptr") long offset, @NativeType(value="GLsizei") int stride) {
        GL43C.glBindVertexBuffer(bindingindex, buffer, offset, stride);
    }

    public static void glVertexAttribFormat(@NativeType(value="GLuint") int attribindex, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint") int relativeoffset) {
        GL43C.glVertexAttribFormat(attribindex, size, type, normalized, relativeoffset);
    }

    public static void glVertexAttribIFormat(@NativeType(value="GLuint") int attribindex, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLuint") int relativeoffset) {
        GL43C.glVertexAttribIFormat(attribindex, size, type, relativeoffset);
    }

    public static void glVertexAttribLFormat(@NativeType(value="GLuint") int attribindex, @NativeType(value="GLint") int size, @NativeType(value="GLenum") int type, @NativeType(value="GLuint") int relativeoffset) {
        GL43C.glVertexAttribLFormat(attribindex, size, type, relativeoffset);
    }

    public static void glVertexAttribBinding(@NativeType(value="GLuint") int attribindex, @NativeType(value="GLuint") int bindingindex) {
        GL43C.glVertexAttribBinding(attribindex, bindingindex);
    }

    public static void glVertexBindingDivisor(@NativeType(value="GLuint") int bindingindex, @NativeType(value="GLuint") int divisor) {
        GL43C.glVertexBindingDivisor(bindingindex, divisor);
    }

    public static native void glVertexArrayBindVertexBufferEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLintptr") long var3, @NativeType(value="GLsizei") int var5);

    public static native void glVertexArrayVertexAttribFormatEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLboolean") boolean var4, @NativeType(value="GLuint") int var5);

    public static native void glVertexArrayVertexAttribIFormatEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLuint") int var4);

    public static native void glVertexArrayVertexAttribLFormatEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLuint") int var4);

    public static native void glVertexArrayVertexAttribBindingEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    public static native void glVertexArrayVertexBindingDivisorEXT(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    static {
        GL.initialize();
    }
}

