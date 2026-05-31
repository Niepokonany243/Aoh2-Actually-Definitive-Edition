/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pool;

public abstract class TemporalAction
extends Action {
    private float duration;
    private float time;
    @Null
    private Interpolation interpolation;
    private boolean reverse;
    private boolean began;
    private boolean complete;

    public TemporalAction() {
    }

    public TemporalAction(float duration) {
        this.duration = duration;
    }

    public TemporalAction(float duration, @Null Interpolation interpolation) {
        this.duration = duration;
        this.interpolation = interpolation;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean act(float delta) {
        if (this.complete) {
            return true;
        }
        Pool pool = this.getPool();
        this.setPool(null);
        try {
            float percent;
            if (!this.began) {
                this.begin();
                this.began = true;
            }
            this.time += delta;
            this.complete = this.time >= this.duration;
            float f = percent = this.complete ? 1.0f : this.time / this.duration;
            if (this.interpolation != null) {
                percent = this.interpolation.apply(percent);
            }
            this.update(this.reverse ? 1.0f - percent : percent);
            if (this.complete) {
                this.end();
            }
            boolean bl = this.complete;
            return bl;
        }
        finally {
            this.setPool(pool);
        }
    }

    protected void begin() {
    }

    protected void end() {
    }

    protected abstract void update(float var1);

    public void finish() {
        this.time = this.duration;
    }

    @Override
    public void restart() {
        this.time = 0.0f;
        this.began = false;
        this.complete = false;
    }

    @Override
    public void reset() {
        super.reset();
        this.reverse = false;
        this.interpolation = null;
    }

    public float getTime() {
        return this.time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public float getDuration() {
        return this.duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    @Null
    public Interpolation getInterpolation() {
        return this.interpolation;
    }

    public void setInterpolation(@Null Interpolation interpolation) {
        this.interpolation = interpolation;
    }

    public boolean isReverse() {
        return this.reverse;
    }

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    public boolean isComplete() {
        return this.complete;
    }
}

