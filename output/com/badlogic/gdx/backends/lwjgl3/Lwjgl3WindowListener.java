/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Window;

public interface Lwjgl3WindowListener {
    public void created(Lwjgl3Window var1);

    public void iconified(boolean var1);

    public void maximized(boolean var1);

    public void focusLost();

    public void focusGained();

    public boolean closeRequested();

    public void filesDropped(String[] var1);

    public void refreshRequested();
}

