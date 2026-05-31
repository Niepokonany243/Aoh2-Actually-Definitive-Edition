/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.IntSet;

public abstract class AbstractInput
implements Input {
    protected final boolean[] pressedKeys;
    protected final boolean[] justPressedKeys;
    private final IntSet keysToCatch = new IntSet();
    protected int pressedKeyCount;
    protected boolean keyJustPressed;

    public AbstractInput() {
        this.pressedKeys = new boolean[256];
        this.justPressedKeys = new boolean[256];
    }

    @Override
    public boolean isKeyPressed(int key) {
        if (key == -1) {
            return this.pressedKeyCount > 0;
        }
        if (key < 0 || key > 255) {
            return false;
        }
        return this.pressedKeys[key];
    }

    @Override
    public boolean isKeyJustPressed(int key) {
        if (key == -1) {
            return this.keyJustPressed;
        }
        if (key < 0 || key > 255) {
            return false;
        }
        return this.justPressedKeys[key];
    }

    @Override
    public boolean isCatchBackKey() {
        return this.keysToCatch.contains(4);
    }

    @Override
    public void setCatchBackKey(boolean catchBack) {
        this.setCatchKey(4, catchBack);
    }

    @Override
    public boolean isCatchMenuKey() {
        return this.keysToCatch.contains(82);
    }

    @Override
    public void setCatchMenuKey(boolean catchMenu) {
        this.setCatchKey(82, catchMenu);
    }

    @Override
    public void setCatchKey(int keycode, boolean catchKey) {
        if (!catchKey) {
            this.keysToCatch.remove(keycode);
        } else {
            this.keysToCatch.add(keycode);
        }
    }

    @Override
    public boolean isCatchKey(int keycode) {
        return this.keysToCatch.contains(keycode);
    }
}

