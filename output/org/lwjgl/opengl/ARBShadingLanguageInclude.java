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
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBShadingLanguageInclude {
    public static final int GL_SHADER_INCLUDE_ARB = 36270;
    public static final int GL_NAMED_STRING_LENGTH_ARB = 36329;
    public static final int GL_NAMED_STRING_TYPE_ARB = 36330;

    protected ARBShadingLanguageInclude() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glNamedStringARB, caps.glDeleteNamedStringARB, caps.glCompileShaderIncludeARB, caps.glIsNamedStringARB, caps.glGetNamedStringARB, caps.glGetNamedStringivARB);
    }

    public static native void nglNamedStringARB(int var0, int var1, long var2, int var4, long var5);

    public static void glNamedStringARB(@NativeType(value="GLenum") int type, @NativeType(value="GLchar const *") ByteBuffer name, @NativeType(value="GLchar const *") ByteBuffer string) {
        ARBShadingLanguageInclude.nglNamedStringARB(type, name.remaining(), MemoryUtil.memAddress(name), string.remaining(), MemoryUtil.memAddress(string));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glNamedStringARB(@NativeType(value="GLenum") int type, @NativeType(value="GLchar const *") CharSequence name, @NativeType(value="GLchar const *") CharSequence string) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            int nameEncodedLength = stack.nASCII(name, false);
            long nameEncoded = stack.getPointerAddress();
            int stringEncodedLength = stack.nUTF8(string, false);
            long stringEncoded = stack.getPointerAddress();
            ARBShadingLanguageInclude.nglNamedStringARB(type, nameEncodedLength, nameEncoded, stringEncodedLength, stringEncoded);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglDeleteNamedStringARB(int var0, long var1);

    public static void glDeleteNamedStringARB(@NativeType(value="GLchar const *") ByteBuffer name) {
        ARBShadingLanguageInclude.nglDeleteNamedStringARB(name.remaining(), MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDeleteNamedStringARB(@NativeType(value="GLchar const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            int nameEncodedLength = stack.nASCII(name, false);
            long nameEncoded = stack.getPointerAddress();
            ARBShadingLanguageInclude.nglDeleteNamedStringARB(nameEncodedLength, nameEncoded);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglCompileShaderIncludeARB(int var0, int var1, long var2, long var4);

    public static void glCompileShaderIncludeARB(@NativeType(value="GLuint") int shader, @NativeType(value="GLchar const * const *") PointerBuffer path, @Nullable @NativeType(value="GLint const *") IntBuffer length) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)length, path.remaining());
        }
        ARBShadingLanguageInclude.nglCompileShaderIncludeARB(shader, path.remaining(), MemoryUtil.memAddress(path), MemoryUtil.memAddressSafe(length));
    }

    public static native boolean nglIsNamedStringARB(int var0, long var1);

    @NativeType(value="GLboolean")
    public static boolean glIsNamedStringARB(@NativeType(value="GLchar const *") ByteBuffer name) {
        return ARBShadingLanguageInclude.nglIsNamedStringARB(name.remaining(), MemoryUtil.memAddress(name));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLboolean")
    public static boolean glIsNamedStringARB(@NativeType(value="GLchar const *") CharSequence name) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            int nameEncodedLength = stack.nASCII(name, false);
            long nameEncoded = stack.getPointerAddress();
            boolean bl = ARBShadingLanguageInclude.nglIsNamedStringARB(nameEncodedLength, nameEncoded);
            return bl;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static native void nglGetNamedStringARB(int var0, long var1, int var3, long var4, long var6);

    public static void glGetNamedStringARB(@NativeType(value="GLchar const *") ByteBuffer name, @Nullable @NativeType(value="GLint *") IntBuffer stringlen, @NativeType(value="GLchar *") ByteBuffer string) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)stringlen, 1);
        }
        ARBShadingLanguageInclude.nglGetNamedStringARB(name.remaining(), MemoryUtil.memAddress(name), string.remaining(), MemoryUtil.memAddressSafe(stringlen), MemoryUtil.memAddress(string));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glGetNamedStringARB(@NativeType(value="GLchar const *") CharSequence name, @Nullable @NativeType(value="GLint *") IntBuffer stringlen, @NativeType(value="GLchar *") ByteBuffer string) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)stringlen, 1);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            int nameEncodedLength = stack.nASCII(name, false);
            long nameEncoded = stack.getPointerAddress();
            ARBShadingLanguageInclude.nglGetNamedStringARB(nameEncodedLength, nameEncoded, string.remaining(), MemoryUtil.memAddressSafe(stringlen), MemoryUtil.memAddress(string));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetNamedStringARB(@NativeType(value="GLchar const *") CharSequence name, @NativeType(value="GLsizei") int bufSize) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            int nameEncodedLength = stack.nASCII(name, false);
            long nameEncoded = stack.getPointerAddress();
            IntBuffer stringlen = stack.ints(0);
            ByteBuffer string = stack.malloc(bufSize);
            ARBShadingLanguageInclude.nglGetNamedStringARB(nameEncodedLength, nameEncoded, bufSize, MemoryUtil.memAddress(stringlen), MemoryUtil.memAddress(string));
            String string2 = MemoryUtil.memUTF8(string, stringlen.get(0));
            return string2;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    @NativeType(value="void")
    public static String glGetNamedStringARB(@NativeType(value="GLchar const *") CharSequence name) {
        return ARBShadingLanguageInclude.glGetNamedStringARB(name, ARBShadingLanguageInclude.glGetNamedStringiARB(name, 36329));
    }

    public static native void nglGetNamedStringivARB(int var0, long var1, int var3, long var4);

    public static void glGetNamedStringivARB(@NativeType(value="GLchar const *") ByteBuffer name, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        ARBShadingLanguageInclude.nglGetNamedStringivARB(name.remaining(), MemoryUtil.memAddress(name), pname, MemoryUtil.memAddress(params));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glGetNamedStringivARB(@NativeType(value="GLchar const *") CharSequence name, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") IntBuffer params) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)params, 1);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            int nameEncodedLength = stack.nASCII(name, false);
            long nameEncoded = stack.getPointerAddress();
            ARBShadingLanguageInclude.nglGetNamedStringivARB(nameEncodedLength, nameEncoded, pname, MemoryUtil.memAddress(params));
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetNamedStringiARB(@NativeType(value="GLchar const *") CharSequence name, @NativeType(value="GLenum") int pname) {
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            int nameEncodedLength = stack.nASCII(name, false);
            long nameEncoded = stack.getPointerAddress();
            IntBuffer params = stack.callocInt(1);
            ARBShadingLanguageInclude.nglGetNamedStringivARB(nameEncodedLength, nameEncoded, pname, MemoryUtil.memAddress(params));
            int n = params.get(0);
            return n;
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glCompileShaderIncludeARB(@NativeType(value="GLuint") int shader, @NativeType(value="GLchar const * const *") PointerBuffer path, @Nullable @NativeType(value="GLint const *") int[] length) {
        long __functionAddress = GL.getICD().glCompileShaderIncludeARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(length, path.remaining());
        }
        JNI.callPPV(shader, path.remaining(), MemoryUtil.memAddress(path), length, __functionAddress);
    }

    public static void glGetNamedStringARB(@NativeType(value="GLchar const *") ByteBuffer name, @Nullable @NativeType(value="GLint *") int[] stringlen, @NativeType(value="GLchar *") ByteBuffer string) {
        long __functionAddress = GL.getICD().glGetNamedStringARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(stringlen, 1);
        }
        JNI.callPPPV(name.remaining(), MemoryUtil.memAddress(name), string.remaining(), stringlen, MemoryUtil.memAddress(string), __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glGetNamedStringARB(@NativeType(value="GLchar const *") CharSequence name, @Nullable @NativeType(value="GLint *") int[] stringlen, @NativeType(value="GLchar *") ByteBuffer string) {
        long __functionAddress = GL.getICD().glGetNamedStringARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.checkSafe(stringlen, 1);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            int nameEncodedLength = stack.nASCII(name, false);
            long nameEncoded = stack.getPointerAddress();
            JNI.callPPPV(nameEncodedLength, nameEncoded, string.remaining(), stringlen, MemoryUtil.memAddress(string), __functionAddress);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    public static void glGetNamedStringivARB(@NativeType(value="GLchar const *") ByteBuffer name, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetNamedStringivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        JNI.callPPV(name.remaining(), MemoryUtil.memAddress(name), pname, params, __functionAddress);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glGetNamedStringivARB(@NativeType(value="GLchar const *") CharSequence name, @NativeType(value="GLenum") int pname, @NativeType(value="GLint *") int[] params) {
        long __functionAddress = GL.getICD().glGetNamedStringivARB;
        if (Checks.CHECKS) {
            Checks.check(__functionAddress);
            Checks.check(params, 1);
        }
        MemoryStack stack = MemoryStack.stackGet();
        int stackPointer = stack.getPointer();
        try {
            int nameEncodedLength = stack.nASCII(name, false);
            long nameEncoded = stack.getPointerAddress();
            JNI.callPPV(nameEncodedLength, nameEncoded, pname, params, __functionAddress);
        }
        finally {
            stack.setPointer(stackPointer);
        }
    }

    static {
        GL.initialize();
    }
}

