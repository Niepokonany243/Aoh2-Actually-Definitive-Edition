/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBTextureView {
    public static final int GL_TEXTURE_VIEW_MIN_LEVEL = 33499;
    public static final int GL_TEXTURE_VIEW_NUM_LEVELS = 33500;
    public static final int GL_TEXTURE_VIEW_MIN_LAYER = 33501;
    public static final int GL_TEXTURE_VIEW_NUM_LAYERS = 33502;
    public static final int GL_TEXTURE_IMMUTABLE_LEVELS = 33503;

    protected ARBTextureView() {
        throw new UnsupportedOperationException();
    }

    static boolean isAvailable(GLCapabilities caps) {
        return Checks.checkFunctions(caps.glTextureView);
    }

    public static void glTextureView(@NativeType(value="GLuint") int texture, @NativeType(value="GLenum") int target, @NativeType(value="GLuint") int origtexture, @NativeType(value="GLenum") int internalformat, @NativeType(value="GLuint") int minlevel, @NativeType(value="GLuint") int numlevels, @NativeType(value="GLuint") int minlayer, @NativeType(value="GLuint") int numlayers) {
        GL43C.glTextureView(texture, target, origtexture, internalformat, minlevel, numlevels, minlayer, numlayers);
    }

    static {
        GL.initialize();
    }
}

