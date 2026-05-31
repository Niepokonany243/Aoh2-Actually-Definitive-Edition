/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTDebugLabel {
    public static final int GL_BUFFER_OBJECT_EXT = 37201;
    public static final int GL_SHADER_OBJECT_EXT = 35656;
    public static final int GL_PROGRAM_OBJECT_EXT = 35648;
    public static final int GL_VERTEX_ARRAY_OBJECT_EXT = 37204;
    public static final int GL_QUERY_OBJECT_EXT = 37203;
    public static final int GL_PROGRAM_PIPELINE_OBJECT_EXT = 35407;

    protected EXTDebugLabel() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glLabelObjectEXT, caps.glGetObjectLabelEXT);
    }

    public static native void nglLabelObjectEXT(int var0, int var1, int var2, long var3);

    public static void glLabelObjectEXT(@NativeType(value="GLenum") int type, @NativeType(value="GLuint") int object, @NativeType(value="GLchar const *") ByteBuffer label) {
        EXTDebugLabel.nglLabelObjectEXT(type, object, label.remaining(), MemoryUtil.memAddress(label));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glLabelObjectEXT(@NativeType(value="GLenum") int type, @NativeType(value="GLuint") int object, @NativeType(value="GLchar const *") CharSequence label) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            int labelEncodedLength = stack.nUTF8(label, false);
            long labelEncoded = stack.getPointerAddress();
            EXTDebugLabel.nglLabelObjectEXT(type, object, labelEncodedLength, labelEncoded);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetObjectLabelEXT(int var0, int var1, int var2, long var3, long var5);

    public static void glGetObjectLabelEXT(@NativeType(value="GLenum") int type, @NativeType(value="GLuint") int object, @NativeType(value="GLsizei *") IntBuffer length, @NativeType(value="GLchar *") ByteBuffer label) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)length, 1);
        }
        EXTDebugLabel.nglGetObjectLabelEXT(type, object, label.remaining(), MemoryUtil.memAddress(length), MemoryUtil.memAddress(label));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetObjectLabelEXT(@NativeType(value="GLenum") int type, @NativeType(value="GLuint") int object, @NativeType(value="GLsizei") int bufSize) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            IntBuffer length = stack.ints(0);
            ByteBuffer label = stack.malloc(bufSize);
            EXTDebugLabel.nglGetObjectLabelEXT(type, object, bufSize, MemoryUtil.memAddress(length), MemoryUtil.memAddress(label));
            String string = MemoryUtil.memUTF8(label, length.get(0));
            return string;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glGetObjectLabelEXT(@NativeType(value="GLenum") int type, @NativeType(value="GLuint") int object, @NativeType(value="GLsizei *") int[] length, @NativeType(value="GLchar *") ByteBuffer label) {
        long __functionAddress = GL.getICD().glGetObjectLabelEXT;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(length, 1);
        }
        JNI.callPPV(type, object, label.remaining(), length, MemoryUtil.memAddress(label), __functionAddress);
    }

    static {
        GL.initialize();
    }
}

