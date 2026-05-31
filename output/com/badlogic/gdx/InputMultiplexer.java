/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.SnapshotArray;

public class InputMultiplexer
implements InputProcessor {
    private SnapshotArray<InputProcessor> processors = new SnapshotArray(4);

    public InputMultiplexer() {
    }

    public InputMultiplexer(InputProcessor ... processors) {
        this.processors.addAll((InputProcessor[])processors);
    }

    public void addProcessor(int index, InputProcessor processor) {
        if (processor == null) {
            throw new NullPointerException("processor cannot be null");
        }
        this.processors.insert(index, processor);
    }

    public void removeProcessor(int index) {
        this.processors.removeIndex(index);
    }

    public void addProcessor(InputProcessor processor) {
        if (processor == null) {
            throw new NullPointerException("processor cannot be null");
        }
        this.processors.add(processor);
    }

    public void removeProcessor(InputProcessor processor) {
        this.processors.removeValue(processor, true);
    }

    public int size() {
        return this.processors.size;
    }

    public void clear() {
        this.processors.clear();
    }

    public void setProcessors(InputProcessor ... processors) {
        this.processors.clear();
        this.processors.addAll((InputProcessor[])processors);
    }

    public void setProcessors(Array<InputProcessor> processors) {
        this.processors.clear();
        this.processors.addAll(processors);
    }

    public SnapshotArray<InputProcessor> getProcessors() {
        return this.processors;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean keyDown(int keycode) {
        InputProcessor[] items = this.processors.begin();
        try {
            int n = this.processors.size;
            for (int i = 0; i < n; ++i) {
                if (!items[i].keyDown(keycode)) continue;
                boolean bl = true;
                return bl;
            }
        }
        finally {
            this.processors.end();
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean keyUp(int keycode) {
        InputProcessor[] items = this.processors.begin();
        try {
            int n = this.processors.size;
            for (int i = 0; i < n; ++i) {
                if (!items[i].keyUp(keycode)) continue;
                boolean bl = true;
                return bl;
            }
        }
        finally {
            this.processors.end();
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean keyTyped(char character) {
        InputProcessor[] items = this.processors.begin();
        try {
            int n = this.processors.size;
            for (int i = 0; i < n; ++i) {
                if (!items[i].keyTyped(character)) continue;
                boolean bl = true;
                return bl;
            }
        }
        finally {
            this.processors.end();
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        InputProcessor[] items = this.processors.begin();
        try {
            int n = this.processors.size;
            for (int i = 0; i < n; ++i) {
                if (!items[i].touchDown(screenX, screenY, pointer, button)) continue;
                boolean bl = true;
                return bl;
            }
        }
        finally {
            this.processors.end();
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        InputProcessor[] items = this.processors.begin();
        try {
            int n = this.processors.size;
            for (int i = 0; i < n; ++i) {
                if (!items[i].touchUp(screenX, screenY, pointer, button)) continue;
                boolean bl = true;
                return bl;
            }
        }
        finally {
            this.processors.end();
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        InputProcessor[] items = this.processors.begin();
        try {
            int n = this.processors.size;
            for (int i = 0; i < n; ++i) {
                if (!items[i].touchDragged(screenX, screenY, pointer)) continue;
                boolean bl = true;
                return bl;
            }
        }
        finally {
            this.processors.end();
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        InputProcessor[] items = this.processors.begin();
        try {
            int n = this.processors.size;
            for (int i = 0; i < n; ++i) {
                if (!items[i].mouseMoved(screenX, screenY)) continue;
                boolean bl = true;
                return bl;
            }
        }
        finally {
            this.processors.end();
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean scrolled(float amountX, float amountY) {
        InputProcessor[] items = this.processors.begin();
        try {
            int n = this.processors.size;
            for (int i = 0; i < n; ++i) {
                if (!items[i].scrolled(amountX, amountY)) continue;
                boolean bl = true;
                return bl;
            }
        }
        finally {
            this.processors.end();
        }
        return false;
    }
}

