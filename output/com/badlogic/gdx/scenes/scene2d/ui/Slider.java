/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pools;

public class Slider
extends ProgressBar {
    int button = -1;
    int draggingPointer = -1;
    boolean mouseOver;
    private Interpolation visualInterpolationInverse = Interpolation.linear;
    private float[] snapValues;
    private float threshold;

    public Slider(float min, float max, float stepSize, boolean vertical, Skin skin) {
        this(min, max, stepSize, vertical, skin.get("default-" + (vertical ? "vertical" : "horizontal"), SliderStyle.class));
    }

    public Slider(float min, float max, float stepSize, boolean vertical, Skin skin, String styleName) {
        this(min, max, stepSize, vertical, skin.get(styleName, SliderStyle.class));
    }

    public Slider(float min, float max, float stepSize, boolean vertical, SliderStyle style) {
        super(min, max, stepSize, vertical, style);
        this.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (Slider.this.disabled) {
                    return false;
                }
                if (Slider.this.button != -1 && Slider.this.button != button) {
                    return false;
                }
                if (Slider.this.draggingPointer != -1) {
                    return false;
                }
                Slider.this.draggingPointer = pointer;
                Slider.this.calculatePositionAndValue(x, y);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (pointer != Slider.this.draggingPointer) {
                    return;
                }
                Slider.this.draggingPointer = -1;
                if (event.isTouchFocusCancel() || !Slider.this.calculatePositionAndValue(x, y)) {
                    ChangeListener.ChangeEvent changeEvent = Pools.obtain(ChangeListener.ChangeEvent.class);
                    Slider.this.fire(changeEvent);
                    Pools.free(changeEvent);
                }
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                Slider.this.calculatePositionAndValue(x, y);
            }

            @Override
            public void enter(InputEvent event, float x, float y, int pointer, @Null Actor fromActor) {
                if (pointer == -1) {
                    Slider.this.mouseOver = true;
                }
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, @Null Actor toActor) {
                if (pointer == -1) {
                    Slider.this.mouseOver = false;
                }
            }
        });
    }

    @Override
    public SliderStyle getStyle() {
        return (SliderStyle)super.getStyle();
    }

    public boolean isOver() {
        return this.mouseOver;
    }

    @Override
    @Null
    protected Drawable getBackgroundDrawable() {
        SliderStyle style = (SliderStyle)super.getStyle();
        if (this.disabled && style.disabledBackground != null) {
            return style.disabledBackground;
        }
        if (this.isDragging() && style.backgroundDown != null) {
            return style.backgroundDown;
        }
        if (this.mouseOver && style.backgroundOver != null) {
            return style.backgroundOver;
        }
        return style.background;
    }

    @Override
    @Null
    protected Drawable getKnobDrawable() {
        SliderStyle style = (SliderStyle)super.getStyle();
        if (this.disabled && style.disabledKnob != null) {
            return style.disabledKnob;
        }
        if (this.isDragging() && style.knobDown != null) {
            return style.knobDown;
        }
        if (this.mouseOver && style.knobOver != null) {
            return style.knobOver;
        }
        return style.knob;
    }

    @Override
    protected Drawable getKnobBeforeDrawable() {
        SliderStyle style = (SliderStyle)super.getStyle();
        if (this.disabled && style.disabledKnobBefore != null) {
            return style.disabledKnobBefore;
        }
        if (this.isDragging() && style.knobBeforeDown != null) {
            return style.knobBeforeDown;
        }
        if (this.mouseOver && style.knobBeforeOver != null) {
            return style.knobBeforeOver;
        }
        return style.knobBefore;
    }

    @Override
    protected Drawable getKnobAfterDrawable() {
        SliderStyle style = (SliderStyle)super.getStyle();
        if (this.disabled && style.disabledKnobAfter != null) {
            return style.disabledKnobAfter;
        }
        if (this.isDragging() && style.knobAfterDown != null) {
            return style.knobAfterDown;
        }
        if (this.mouseOver && style.knobAfterOver != null) {
            return style.knobAfterOver;
        }
        return style.knobAfter;
    }

    boolean calculatePositionAndValue(float x, float y) {
        float value;
        SliderStyle style = this.getStyle();
        Drawable knob = style.knob;
        Drawable bg = this.getBackgroundDrawable();
        float oldPosition = this.position;
        float min = this.getMinValue();
        float max = this.getMaxValue();
        if (this.vertical) {
            float height = this.getHeight() - bg.getTopHeight() - bg.getBottomHeight();
            float knobHeight = knob == null ? 0.0f : knob.getMinHeight();
            this.position = y - bg.getBottomHeight() - knobHeight * 0.5f;
            value = min + (max - min) * this.visualInterpolationInverse.apply(this.position / (height - knobHeight));
            this.position = Math.max(Math.min(0.0f, bg.getBottomHeight()), this.position);
            this.position = Math.min(height - knobHeight, this.position);
        } else {
            float width = this.getWidth() - bg.getLeftWidth() - bg.getRightWidth();
            float knobWidth = knob == null ? 0.0f : knob.getMinWidth();
            this.position = x - bg.getLeftWidth() - knobWidth * 0.5f;
            value = min + (max - min) * this.visualInterpolationInverse.apply(this.position / (width - knobWidth));
            this.position = Math.max(Math.min(0.0f, bg.getLeftWidth()), this.position);
            this.position = Math.min(width - knobWidth, this.position);
        }
        float oldValue = value;
        if (!Gdx.input.isKeyPressed(59) && !Gdx.input.isKeyPressed(60)) {
            value = this.snap(value);
        }
        boolean valueSet = this.setValue(value);
        if (value == oldValue) {
            this.position = oldPosition;
        }
        return valueSet;
    }

    protected float snap(float value) {
        if (this.snapValues == null || this.snapValues.length == 0) {
            return value;
        }
        float bestDiff = -1.0f;
        float bestValue = 0.0f;
        for (int i = 0; i < this.snapValues.length; ++i) {
            float snapValue = this.snapValues[i];
            float diff = Math.abs(value - snapValue);
            if (!(diff <= this.threshold) || bestDiff != -1.0f && !(diff < bestDiff)) continue;
            bestDiff = diff;
            bestValue = snapValue;
        }
        return bestDiff == -1.0f ? value : bestValue;
    }

    public void setSnapToValues(@Null float[] values, float threshold) {
        this.snapValues = values;
        this.threshold = threshold;
    }

    public boolean isDragging() {
        return this.draggingPointer != -1;
    }

    public void setButton(int button) {
        this.button = button;
    }

    public void setVisualInterpolationInverse(Interpolation interpolation) {
        this.visualInterpolationInverse = interpolation;
    }

    public void setVisualPercent(float percent) {
        this.setValue(this.min + (this.max - this.min) * this.visualInterpolationInverse.apply(percent));
    }

    public static class SliderStyle
    extends ProgressBar.ProgressBarStyle {
        @Null
        public Drawable backgroundOver;
        @Null
        public Drawable backgroundDown;
        @Null
        public Drawable knobOver;
        @Null
        public Drawable knobDown;
        @Null
        public Drawable knobBeforeOver;
        @Null
        public Drawable knobBeforeDown;
        @Null
        public Drawable knobAfterOver;
        @Null
        public Drawable knobAfterDown;

        public SliderStyle() {
        }

        public SliderStyle(@Null Drawable background, @Null Drawable knob) {
            super(background, knob);
        }

        public SliderStyle(SliderStyle style) {
            super(style);
            this.backgroundOver = style.backgroundOver;
            this.backgroundDown = style.backgroundDown;
            this.knobOver = style.knobOver;
            this.knobDown = style.knobDown;
            this.knobBeforeOver = style.knobBeforeOver;
            this.knobBeforeDown = style.knobBeforeDown;
            this.knobAfterOver = style.knobAfterOver;
            this.knobAfterDown = style.knobAfterDown;
        }
    }
}

