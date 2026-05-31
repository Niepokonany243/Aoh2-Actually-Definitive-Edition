/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.actions.TemporalAction;

public class SizeToAction
extends TemporalAction {
    private float startWidth;
    private float startHeight;
    private float endWidth;
    private float endHeight;

    @Override
    protected void begin() {
        this.startWidth = this.target.getWidth();
        this.startHeight = this.target.getHeight();
    }

    @Override
    protected void update(float percent) {
        float height;
        float width;
        if (percent == 0.0f) {
            width = this.startWidth;
            height = this.startHeight;
        } else if (percent == 1.0f) {
            width = this.endWidth;
            height = this.endHeight;
        } else {
            width = this.startWidth + (this.endWidth - this.startWidth) * percent;
            height = this.startHeight + (this.endHeight - this.startHeight) * percent;
        }
        this.target.setSize(width, height);
    }

    public void setSize(float width, float height) {
        this.endWidth = width;
        this.endHeight = height;
    }

    public float getWidth() {
        return this.endWidth;
    }

    public void setWidth(float width) {
        this.endWidth = width;
    }

    public float getHeight() {
        return this.endHeight;
    }

    public void setHeight(float height) {
        this.endHeight = height;
    }
}

