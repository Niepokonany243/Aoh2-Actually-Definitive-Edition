/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Window;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3WindowListener;

public class Lwjgl3WindowAdapter
implements Lwjgl3WindowListener {
    @Override
    public void created(Lwjgl3Window window) {
    }

    @Override
    public void iconified(boolean isIconified) {
    }

    @Override
    public void maximized(boolean isMaximized) {
    }

    @Override
    public void focusLost() {
    }

    @Override
    public void focusGained() {
    }

    @Override
    public boolean closeRequested() {
        return true;
    }

    @Override
    public void filesDropped(String[] files) {
    }

    @Override
    public void refreshRequested() {
    }
}

