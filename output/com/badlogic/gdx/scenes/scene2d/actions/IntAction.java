/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.TemporalAction;
import com.badlogic.gdx.utils.Null;

public class IntAction
extends TemporalAction {
    private int start;
    private int end;
    private int value;

    public IntAction() {
        this.start = 0;
        this.end = 1;
    }

    public IntAction(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public IntAction(int start, int end, float duration) {
        super(duration);
        this.start = start;
        this.end = end;
    }

    public IntAction(int start, int end, float duration, @Null Interpolation interpolation) {
        super(duration, interpolation);
        this.start = start;
        this.end = end;
    }

    @Override
    protected void begin() {
        this.value = this.start;
    }

    @Override
    protected void update(float percent) {
        this.value = percent == 0.0f ? this.start : (percent == 1.0f ? this.end : (int)((float)this.start + (float)(this.end - this.start) * percent));
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return this.end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}

