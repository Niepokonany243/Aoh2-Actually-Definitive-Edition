/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Graphics;
import com.badlogic.gdx.utils.Clipboard;
import org.lwjgl.glfw.GLFW;

public class Lwjgl3Clipboard
implements Clipboard {
    @Override
    public boolean hasContents() {
        String contents = this.getContents();
        return contents != null && !contents.isEmpty();
    }

    @Override
    public String getContents() {
        return GLFW.glfwGetClipboardString(((Lwjgl3Graphics)Gdx.graphics).getWindow().getWindowHandle());
    }

    @Override
    public void setContents(String content) {
        GLFW.glfwSetClipboardString(((Lwjgl3Graphics)Gdx.graphics).getWindow().getWindowHandle(), content);
    }
}

