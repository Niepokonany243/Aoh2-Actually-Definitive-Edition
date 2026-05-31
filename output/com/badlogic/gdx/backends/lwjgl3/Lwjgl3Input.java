/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.Disposable;

public interface Lwjgl3Input
extends Input,
Disposable {
    public void windowHandleChanged(long var1);

    public void update();

    public void prepareNext();

    public void resetPollingStates();
}

