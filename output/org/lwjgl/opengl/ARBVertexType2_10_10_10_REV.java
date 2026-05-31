/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL33;
import org.lwjgl.opengl.GL33C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBVertexType2_10_10_10_REV {
    public static final int GL_INT_2_10_10_10_REV = 36255;

    protected ARBVertexType2_10_10_10_REV() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps, boolean fc) {
        return (fc || Checks.checkFunctions(caps.glVertexP2ui, caps.glVertexP3ui, caps.glVertexP4ui, caps.glVertexP2uiv, caps.glVertexP3uiv, caps.glVertexP4uiv, caps.glTexCoordP1ui, caps.glTexCoordP2ui, caps.glTexCoordP3ui, caps.glTexCoordP4ui, caps.glTexCoordP1uiv, caps.glTexCoordP2uiv, caps.glTexCoordP3uiv, caps.glTexCoordP4uiv, caps.glMultiTexCoordP1ui, caps.glMultiTexCoordP2ui, caps.glMultiTexCoordP3ui, caps.glMultiTexCoordP4ui, caps.glMultiTexCoordP1uiv, caps.glMultiTexCoordP2uiv, caps.glMultiTexCoordP3uiv, caps.glMultiTexCoordP4uiv, caps.glNormalP3ui, caps.glNormalP3uiv, caps.glColorP3ui, caps.glColorP4ui, caps.glColorP3uiv, caps.glColorP4uiv, caps.glSecondaryColorP3ui, caps.glSecondaryColorP3uiv)) && Checks.checkFunctions(caps.glVertexAttribP1ui, caps.glVertexAttribP2ui, caps.glVertexAttribP3ui, caps.glVertexAttribP4ui, caps.glVertexAttribP1uiv, caps.glVertexAttribP2uiv, caps.glVertexAttribP3uiv, caps.glVertexAttribP4uiv);
    }

    public static void glVertexP2ui(@NativeType(value="GLenum") int type, @NativeType(value="GLuint") int value) {
        GL33.glVertexP2ui(type, value);
    }

    public static void glVertexP3ui(@NativeType(value="GLenum") int type, @NativeType(value="GLuint") int value) {
        GL33.glVertexP3ui(type, value);
    }

    public static void glVertexP4ui(@NativeType(value="GLenum") int type, @NativeType(value="GLuint") int value) {
        GL33.glVertexP4ui(type, value);
    }

    public static void nglVertexP2uiv(int type, long value) {
        GL33.nglVertexP2uiv(type, value);
    }

    public static void glVertexP2uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer value) {
        GL33.glVertexP2uiv(type, value);
    }

    public static void nglVertexP3uiv(int type, long value) {
        GL33.nglVertexP3uiv(type, value);
    }

    public static void glVertexP3uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer value) {
        GL33.glVertexP3uiv(type, value);
    }

    public static void nglVertexP4uiv(int type, long value) {
        GL33.nglVertexP4uiv(type, value);
    }

    public static void glVertexP4uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer value) {
        GL33.glVertexP4uiv(type, value);
    }

    public static void glTexCoordP1ui(@NativeType(value="GLenum") int type, @NativeType(value="GLuint") int coords) {
        GL33.glTexCoordP1ui(type, coords);
    }

    public static void glTexCoordP2ui(@NativeType(value="GLenum") int type, @NativeType(value="GLuint") int coords) {
        GL33.glTexCoordP2ui(type, coords);
    }

    public static void glTexCoordP3ui(@NativeType(value="GLenum") int type, @NativeType(value="GLuint") int coords) {
        GL33.glTexCoordP3ui(type, coords);
    }

    public static void glTexCoordP4ui(@NativeType(value="GLenum") int type, @NativeType(value="GLuint") int coords) {
        GL33.glTexCoordP4ui(type, coords);
    }

    public static void nglTexCoordP1uiv(int type, long coords) {
        GL33.nglTexCoordP1uiv(type, coords);
    }

    public static void glTexCoordP1uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer coords) {
        GL33.glTexCoordP1uiv(type, coords);
    }

    public static void nglTexCoordP2uiv(int type, long coords) {
        GL33.nglTexCoordP2uiv(type, coords);
    }

    public static void glTexCoordP2uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer coords) {
        GL33.glTexCoordP2uiv(type, coords);
    }

    public static void nglTexCoordP3uiv(int type, long coords) {
        GL33.nglTexCoordP3uiv(type, coords);
    }

    public static void glTexCoordP3uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer coords) {
        GL33.glTexCoordP3uiv(type, coords);
    }

    public static void nglTexCoordP4uiv(int type, long coords) {
        GL33.nglTexCoordP4uiv(type, coords);
    }

    public static void glTexCoordP4uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer coords) {
        GL33.glTexCoordP4uiv(type, coords);
    }

    public static void glMultiTexCoordP1ui(@NativeType(value="GLenum") int texture, @NativeType(value="GLenum") int type, @NativeType(value="GLuint") int coords) {
        GL33.glMultiTexCoordP1ui(texture, type, coords);
    }

    public static void glMultiTexCoordP2ui(@NativeType(value="GLenum") int texture, @NativeType(value="GLenum") int type, @NativeType(value="GLuint") int coords) {
        GL33.glMultiTexCoordP2ui(texture, type, coords);
    }

    public static void glMultiTexCoordP3ui(@NativeType(value="GLenum") int texture, @NativeType(value="GLenum") int type, @NativeType(value="GLuint") int coords) {
        GL33.glMultiTexCoordP3ui(texture, type, coords);
    }

    public static void glMultiTexCoordP4ui(@NativeType(value="GLenum") int texture, @NativeType(value="GLenum") int type, @NativeType(value="GLuint") int coords) {
        GL33.glMultiTexCoordP4ui(texture, type, coords);
    }

    public static void nglMultiTexCoordP1uiv(int texture, int type, long coords) {
        GL33.nglMultiTexCoordP1uiv(texture, type, coords);
    }

    public static void glMultiTexCoordP1uiv(@NativeType(value="GLenum") int texture, @NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer coords) {
        GL33.glMultiTexCoordP1uiv(texture, type, coords);
    }

    public static void nglMultiTexCoordP2uiv(int texture, int type, long coords) {
        GL33.nglMultiTexCoordP2uiv(texture, type, coords);
    }

    public static void glMultiTexCoordP2uiv(@NativeType(value="GLenum") int texture, @NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer coords) {
        GL33.glMultiTexCoordP2uiv(texture, type, coords);
    }

    public static void nglMultiTexCoordP3uiv(int texture, int type, long coords) {
        GL33.nglMultiTexCoordP3uiv(texture, type, coords);
    }

    public static void glMultiTexCoordP3uiv(@NativeType(value="GLenum") int texture, @NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer coords) {
        GL33.glMultiTexCoordP3uiv(texture, type, coords);
    }

    public static void nglMultiTexCoordP4uiv(int texture, int type, long coords) {
        GL33.nglMultiTexCoordP4uiv(texture, type, coords);
    }

    public static void glMultiTexCoordP4uiv(@NativeType(value="GLenum") int texture, @NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer coords) {
        GL33.glMultiTexCoordP4uiv(texture, type, coords);
    }

    public static void glNormalP3ui(@NativeType(value="GLenum") int type, @NativeType(value="GLuint") int coords) {
        GL33.glNormalP3ui(type, coords);
    }

    public static void nglNormalP3uiv(int type, long coords) {
        GL33.nglNormalP3uiv(type, coords);
    }

    public static void glNormalP3uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer coords) {
        GL33.glNormalP3uiv(type, coords);
    }

    public static void glColorP3ui(@NativeType(value="GLenum") int type, @NativeType(value="GLuint") int color) {
        GL33.glColorP3ui(type, color);
    }

    public static void glColorP4ui(@NativeType(value="GLenum") int type, @NativeType(value="GLuint") int color) {
        GL33.glColorP4ui(type, color);
    }

    public static void nglColorP3uiv(int type, long color) {
        GL33.nglColorP3uiv(type, color);
    }

    public static void glColorP3uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer color) {
        GL33.glColorP3uiv(type, color);
    }

    public static void nglColorP4uiv(int type, long color) {
        GL33.nglColorP4uiv(type, color);
    }

    public static void glColorP4uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer color) {
        GL33.glColorP4uiv(type, color);
    }

    public static void glSecondaryColorP3ui(@NativeType(value="GLenum") int type, @NativeType(value="GLuint") int color) {
        GL33.glSecondaryColorP3ui(type, color);
    }

    public static void nglSecondaryColorP3uiv(int type, long color) {
        GL33.nglSecondaryColorP3uiv(type, color);
    }

    public static void glSecondaryColorP3uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") IntBuffer color) {
        GL33.glSecondaryColorP3uiv(type, color);
    }

    public static void glVertexAttribP1ui(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint") int value) {
        GL33C.glVertexAttribP1ui(index, type, normalized, value);
    }

    public static void glVertexAttribP2ui(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint") int value) {
        GL33C.glVertexAttribP2ui(index, type, normalized, value);
    }

    public static void glVertexAttribP3ui(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint") int value) {
        GL33C.glVertexAttribP3ui(index, type, normalized, value);
    }

    public static void glVertexAttribP4ui(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint") int value) {
        GL33C.glVertexAttribP4ui(index, type, normalized, value);
    }

    public static void nglVertexAttribP1uiv(int index, int type, boolean normalized, long value) {
        GL33C.nglVertexAttribP1uiv(index, type, normalized, value);
    }

    public static void glVertexAttribP1uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") IntBuffer value) {
        GL33C.glVertexAttribP1uiv(index, type, normalized, value);
    }

    public static void nglVertexAttribP2uiv(int index, int type, boolean normalized, long value) {
        GL33C.nglVertexAttribP2uiv(index, type, normalized, value);
    }

    public static void glVertexAttribP2uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") IntBuffer value) {
        GL33C.glVertexAttribP2uiv(index, type, normalized, value);
    }

    public static void nglVertexAttribP3uiv(int index, int type, boolean normalized, long value) {
        GL33C.nglVertexAttribP3uiv(index, type, normalized, value);
    }

    public static void glVertexAttribP3uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") IntBuffer value) {
        GL33C.glVertexAttribP3uiv(index, type, normalized, value);
    }

    public static void nglVertexAttribP4uiv(int index, int type, boolean normalized, long value) {
        GL33C.nglVertexAttribP4uiv(index, type, normalized, value);
    }

    public static void glVertexAttribP4uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") IntBuffer value) {
        GL33C.glVertexAttribP4uiv(index, type, normalized, value);
    }

    public static void glVertexP2uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] value) {
        GL33.glVertexP2uiv(type, value);
    }

    public static void glVertexP3uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] value) {
        GL33.glVertexP3uiv(type, value);
    }

    public static void glVertexP4uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] value) {
        GL33.glVertexP4uiv(type, value);
    }

    public static void glTexCoordP1uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] coords) {
        GL33.glTexCoordP1uiv(type, coords);
    }

    public static void glTexCoordP2uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] coords) {
        GL33.glTexCoordP2uiv(type, coords);
    }

    public static void glTexCoordP3uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] coords) {
        GL33.glTexCoordP3uiv(type, coords);
    }

    public static void glTexCoordP4uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] coords) {
        GL33.glTexCoordP4uiv(type, coords);
    }

    public static void glMultiTexCoordP1uiv(@NativeType(value="GLenum") int texture, @NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] coords) {
        GL33.glMultiTexCoordP1uiv(texture, type, coords);
    }

    public static void glMultiTexCoordP2uiv(@NativeType(value="GLenum") int texture, @NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] coords) {
        GL33.glMultiTexCoordP2uiv(texture, type, coords);
    }

    public static void glMultiTexCoordP3uiv(@NativeType(value="GLenum") int texture, @NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] coords) {
        GL33.glMultiTexCoordP3uiv(texture, type, coords);
    }

    public static void glMultiTexCoordP4uiv(@NativeType(value="GLenum") int texture, @NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] coords) {
        GL33.glMultiTexCoordP4uiv(texture, type, coords);
    }

    public static void glNormalP3uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] coords) {
        GL33.glNormalP3uiv(type, coords);
    }

    public static void glColorP3uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] color) {
        GL33.glColorP3uiv(type, color);
    }

    public static void glColorP4uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] color) {
        GL33.glColorP4uiv(type, color);
    }

    public static void glSecondaryColorP3uiv(@NativeType(value="GLenum") int type, @NativeType(value="GLuint const *") int[] color) {
        GL33.glSecondaryColorP3uiv(type, color);
    }

    public static void glVertexAttribP1uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") int[] value) {
        GL33C.glVertexAttribP1uiv(index, type, normalized, value);
    }

    public static void glVertexAttribP2uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") int[] value) {
        GL33C.glVertexAttribP2uiv(index, type, normalized, value);
    }

    public static void glVertexAttribP3uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") int[] value) {
        GL33C.glVertexAttribP3uiv(index, type, normalized, value);
    }

    public static void glVertexAttribP4uiv(@NativeType(value="GLuint") int index, @NativeType(value="GLenum") int type, @NativeType(value="GLboolean") boolean normalized, @NativeType(value="GLuint const *") int[] value) {
        GL33C.glVertexAttribP4uiv(index, type, normalized, value);
    }

    static {
        GL.initialize();
    }
}

