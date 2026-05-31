/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL21C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class GL21
extends GL20 {
    public static final int GL_CURRENT_RASTER_SECONDARY_COLOR = 33887;
    public static final int GL_FLOAT_MAT2x3 = 35685;
    public static final int GL_FLOAT_MAT2x4 = 35686;
    public static final int GL_FLOAT_MAT3x2 = 35687;
    public static final int GL_FLOAT_MAT3x4 = 35688;
    public static final int GL_FLOAT_MAT4x2 = 35689;
    public static final int GL_FLOAT_MAT4x3 = 35690;
    public static final int GL_PIXEL_PACK_BUFFER = 35051;
    public static final int GL_PIXEL_UNPACK_BUFFER = 35052;
    public static final int GL_PIXEL_PACK_BUFFER_BINDING = 35053;
    public static final int GL_PIXEL_UNPACK_BUFFER_BINDING = 35055;
    public static final int GL_SRGB = 35904;
    public static final int GL_SRGB8 = 35905;
    public static final int GL_SRGB_ALPHA = 35906;
    public static final int GL_SRGB8_ALPHA8 = 35907;
    public static final int GL_SLUMINANCE_ALPHA = 35908;
    public static final int GL_SLUMINANCE8_ALPHA8 = 35909;
    public static final int GL_SLUMINANCE = 35910;
    public static final int GL_SLUMINANCE8 = 35911;
    public static final int GL_COMPRESSED_SRGB = 35912;
    public static final int GL_COMPRESSED_SRGB_ALPHA = 35913;
    public static final int GL_COMPRESSED_SLUMINANCE = 35914;
    public static final int GL_COMPRESSED_SLUMINANCE_ALPHA = 35915;

    protected GL21() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glUniformMatrix2x3fv, caps.glUniformMatrix3x2fv, caps.glUniformMatrix2x4fv, caps.glUniformMatrix4x2fv, caps.glUniformMatrix3x4fv, caps.glUniformMatrix4x3fv);
    }

    public static void nglUniformMatrix2x3fv(int location, int count, boolean transpose, long value) {
        GL21C.nglUniformMatrix2x3fv(location, count, transpose, value);
    }

    public static void glUniformMatrix2x3fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL21C.glUniformMatrix2x3fv(location, transpose, value);
    }

    public static void nglUniformMatrix3x2fv(int location, int count, boolean transpose, long value) {
        GL21C.nglUniformMatrix3x2fv(location, count, transpose, value);
    }

    public static void glUniformMatrix3x2fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL21C.glUniformMatrix3x2fv(location, transpose, value);
    }

    public static void nglUniformMatrix2x4fv(int location, int count, boolean transpose, long value) {
        GL21C.nglUniformMatrix2x4fv(location, count, transpose, value);
    }

    public static void glUniformMatrix2x4fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL21C.glUniformMatrix2x4fv(location, transpose, value);
    }

    public static void nglUniformMatrix4x2fv(int location, int count, boolean transpose, long value) {
        GL21C.nglUniformMatrix4x2fv(location, count, transpose, value);
    }

    public static void glUniformMatrix4x2fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL21C.glUniformMatrix4x2fv(location, transpose, value);
    }

    public static void nglUniformMatrix3x4fv(int location, int count, boolean transpose, long value) {
        GL21C.nglUniformMatrix3x4fv(location, count, transpose, value);
    }

    public static void glUniformMatrix3x4fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL21C.glUniformMatrix3x4fv(location, transpose, value);
    }

    public static void nglUniformMatrix4x3fv(int location, int count, boolean transpose, long value) {
        GL21C.nglUniformMatrix4x3fv(location, count, transpose, value);
    }

    public static void glUniformMatrix4x3fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") FloatBuffer value) {
        GL21C.glUniformMatrix4x3fv(location, transpose, value);
    }

    public static void glUniformMatrix2x3fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        GL21C.glUniformMatrix2x3fv(location, transpose, value);
    }

    public static void glUniformMatrix3x2fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        GL21C.glUniformMatrix3x2fv(location, transpose, value);
    }

    public static void glUniformMatrix2x4fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        GL21C.glUniformMatrix2x4fv(location, transpose, value);
    }

    public static void glUniformMatrix4x2fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        GL21C.glUniformMatrix4x2fv(location, transpose, value);
    }

    public static void glUniformMatrix3x4fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        GL21C.glUniformMatrix3x4fv(location, transpose, value);
    }

    public static void glUniformMatrix4x3fv(@NativeType(value="GLint") int location, @NativeType(value="GLboolean") boolean transpose, @NativeType(value="GLfloat const *") float[] value) {
        GL21C.glUniformMatrix4x3fv(location, transpose, value);
    }

    static {
        GL.initialize();
    }
}

