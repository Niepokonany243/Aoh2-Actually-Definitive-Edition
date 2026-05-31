/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.actions.TemporalAction;

public class RotateToAction
extends TemporalAction {
    private float start;
    private float end;
    private boolean useShortestDirection = false;

    public RotateToAction() {
    }

    public RotateToAction(boolean useShortestDirection) {
        this.useShortestDirection = useShortestDirection;
    }

    @Override
    protected void begin() {
        this.start = this.target.getRotation();
    }

    @Override
    protected void update(float percent) {
        float rotation = percent == 0.0f ? this.start : (percent == 1.0f ? this.end : (this.useShortestDirection ? MathUtils.lerpAngleDeg(this.start, this.end, percent) : this.start + (this.end - this.start) * percent));
        this.target.setRotation(rotation);
    }

    public float getRotation() {
        return this.end;
    }

    public void setRotation(float rotation) {
        this.end = rotation;
    }

    public boolean isUseShortestDirection() {
        return this.useShortestDirection;
    }

    public void setUseShortestDirection(boolean useShortestDirection) {
        this.useShortestDirection = useShortestDirection;
    }
}

