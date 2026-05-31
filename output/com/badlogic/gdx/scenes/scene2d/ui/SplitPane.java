/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Null;

public class SplitPane
extends WidgetGroup {
    SplitPaneStyle style;
    @Null
    private Actor firstWidget;
    @Null
    private Actor secondWidget;
    boolean vertical;
    float splitAmount = 0.5f;
    float minAmount;
    float maxAmount = 1.0f;
    private final Rectangle firstWidgetBounds = new Rectangle();
    private final Rectangle secondWidgetBounds = new Rectangle();
    final Rectangle handleBounds = new Rectangle();
    boolean cursorOverHandle;
    private final Rectangle tempScissors = new Rectangle();
    Vector2 lastPoint = new Vector2();
    Vector2 handlePosition = new Vector2();

    public SplitPane(@Null Actor firstWidget, @Null Actor secondWidget, boolean vertical, Skin skin) {
        this(firstWidget, secondWidget, vertical, skin, "default-" + (vertical ? "vertical" : "horizontal"));
    }

    public SplitPane(@Null Actor firstWidget, @Null Actor secondWidget, boolean vertical, Skin skin, String styleName) {
        this(firstWidget, secondWidget, vertical, skin.get(styleName, SplitPaneStyle.class));
    }

    public SplitPane(@Null Actor firstWidget, @Null Actor secondWidget, boolean vertical, SplitPaneStyle style) {
        this.vertical = vertical;
        this.setStyle(style);
        this.setFirstWidget(firstWidget);
        this.setSecondWidget(secondWidget);
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
        this.initialize();
    }

    private void initialize() {
        this.addListener(new InputListener(){
            int draggingPointer = -1;

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (this.draggingPointer != -1) {
                    return false;
                }
                if (pointer == 0 && button != 0) {
                    return false;
                }
                if (SplitPane.this.handleBounds.contains(x, y)) {
                    this.draggingPointer = pointer;
                    SplitPane.this.lastPoint.set(x, y);
                    SplitPane.this.handlePosition.set(SplitPane.this.handleBounds.x, SplitPane.this.handleBounds.y);
                    return true;
                }
                return false;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (pointer == this.draggingPointer) {
                    this.draggingPointer = -1;
                }
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                if (pointer != this.draggingPointer) {
                    return;
                }
                Drawable handle = SplitPane.this.style.handle;
                if (!SplitPane.this.vertical) {
                    float dragX;
                    float delta = x - SplitPane.this.lastPoint.x;
                    float availWidth = SplitPane.this.getWidth() - handle.getMinWidth();
                    SplitPane.this.handlePosition.x = dragX = SplitPane.this.handlePosition.x + delta;
                    dragX = Math.max(0.0f, dragX);
                    dragX = Math.min(availWidth, dragX);
                    SplitPane.this.splitAmount = dragX / availWidth;
                    SplitPane.this.lastPoint.set(x, y);
                } else {
                    float dragY;
                    float delta = y - SplitPane.this.lastPoint.y;
                    float availHeight = SplitPane.this.getHeight() - handle.getMinHeight();
                    SplitPane.this.handlePosition.y = dragY = SplitPane.this.handlePosition.y + delta;
                    dragY = Math.max(0.0f, dragY);
                    dragY = Math.min(availHeight, dragY);
                    SplitPane.this.splitAmount = 1.0f - dragY / availHeight;
                    SplitPane.this.lastPoint.set(x, y);
                }
                SplitPane.this.invalidate();
            }

            @Override
            public boolean mouseMoved(InputEvent event, float x, float y) {
                SplitPane.this.cursorOverHandle = SplitPane.this.handleBounds.contains(x, y);
                return false;
            }
        });
    }

    public void setStyle(SplitPaneStyle style) {
        this.style = style;
        this.invalidateHierarchy();
    }

    public SplitPaneStyle getStyle() {
        return this.style;
    }

    @Override
    public void layout() {
        Actor secondWidget;
        this.clampSplitAmount();
        if (!this.vertical) {
            this.calculateHorizBoundsAndPositions();
        } else {
            this.calculateVertBoundsAndPositions();
        }
        Actor firstWidget = this.firstWidget;
        if (firstWidget != null) {
            Rectangle firstWidgetBounds = this.firstWidgetBounds;
            firstWidget.setBounds(firstWidgetBounds.x, firstWidgetBounds.y, firstWidgetBounds.width, firstWidgetBounds.height);
            if (firstWidget instanceof Layout) {
                ((Layout)((Object)firstWidget)).validate();
            }
        }
        if ((secondWidget = this.secondWidget) != null) {
            Rectangle secondWidgetBounds = this.secondWidgetBounds;
            secondWidget.setBounds(secondWidgetBounds.x, secondWidgetBounds.y, secondWidgetBounds.width, secondWidgetBounds.height);
            if (secondWidget instanceof Layout) {
                ((Layout)((Object)secondWidget)).validate();
            }
        }
    }

    @Override
    public float getPrefWidth() {
        float second = 0.0f;
        float first = 0.0f;
        if (this.firstWidget != null) {
            first = this.firstWidget instanceof Layout ? ((Layout)((Object)this.firstWidget)).getPrefWidth() : this.firstWidget.getWidth();
        }
        if (this.secondWidget != null) {
            second = this.secondWidget instanceof Layout ? ((Layout)((Object)this.secondWidget)).getPrefWidth() : this.secondWidget.getWidth();
        }
        if (this.vertical) {
            return Math.max(first, second);
        }
        return first + this.style.handle.getMinWidth() + second;
    }

    @Override
    public float getPrefHeight() {
        float second = 0.0f;
        float first = 0.0f;
        if (this.firstWidget != null) {
            first = this.firstWidget instanceof Layout ? ((Layout)((Object)this.firstWidget)).getPrefHeight() : this.firstWidget.getHeight();
        }
        if (this.secondWidget != null) {
            second = this.secondWidget instanceof Layout ? ((Layout)((Object)this.secondWidget)).getPrefHeight() : this.secondWidget.getHeight();
        }
        if (!this.vertical) {
            return Math.max(first, second);
        }
        return first + this.style.handle.getMinHeight() + second;
    }

    @Override
    public float getMinWidth() {
        float second;
        float first = this.firstWidget instanceof Layout ? ((Layout)((Object)this.firstWidget)).getMinWidth() : 0.0f;
        float f = second = this.secondWidget instanceof Layout ? ((Layout)((Object)this.secondWidget)).getMinWidth() : 0.0f;
        if (this.vertical) {
            return Math.max(first, second);
        }
        return first + this.style.handle.getMinWidth() + second;
    }

    @Override
    public float getMinHeight() {
        float second;
        float first = this.firstWidget instanceof Layout ? ((Layout)((Object)this.firstWidget)).getMinHeight() : 0.0f;
        float f = second = this.secondWidget instanceof Layout ? ((Layout)((Object)this.secondWidget)).getMinHeight() : 0.0f;
        if (!this.vertical) {
            return Math.max(first, second);
        }
        return first + this.style.handle.getMinHeight() + second;
    }

    public void setVertical(boolean vertical) {
        if (this.vertical == vertical) {
            return;
        }
        this.vertical = vertical;
        this.invalidateHierarchy();
    }

    public boolean isVertical() {
        return this.vertical;
    }

    private void calculateHorizBoundsAndPositions() {
        Drawable handle = this.style.handle;
        float height = this.getHeight();
        float availWidth = this.getWidth() - handle.getMinWidth();
        float leftAreaWidth = (int)(availWidth * this.splitAmount);
        float rightAreaWidth = availWidth - leftAreaWidth;
        float handleWidth = handle.getMinWidth();
        this.firstWidgetBounds.set(0.0f, 0.0f, leftAreaWidth, height);
        this.secondWidgetBounds.set(leftAreaWidth + handleWidth, 0.0f, rightAreaWidth, height);
        this.handleBounds.set(leftAreaWidth, 0.0f, handleWidth, height);
    }

    private void calculateVertBoundsAndPositions() {
        Drawable handle = this.style.handle;
        float width = this.getWidth();
        float height = this.getHeight();
        float availHeight = height - handle.getMinHeight();
        float topAreaHeight = (int)(availHeight * this.splitAmount);
        float bottomAreaHeight = availHeight - topAreaHeight;
        float handleHeight = handle.getMinHeight();
        this.firstWidgetBounds.set(0.0f, height - topAreaHeight, width, topAreaHeight);
        this.secondWidgetBounds.set(0.0f, 0.0f, width, bottomAreaHeight);
        this.handleBounds.set(0.0f, bottomAreaHeight, width, handleHeight);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Stage stage = this.getStage();
        if (stage == null) {
            return;
        }
        this.validate();
        Color color = this.getColor();
        float alpha = color.a * parentAlpha;
        this.applyTransform(batch, this.computeTransform());
        if (this.firstWidget != null && this.firstWidget.isVisible()) {
            batch.flush();
            stage.calculateScissors(this.firstWidgetBounds, this.tempScissors);
            if (ScissorStack.pushScissors(this.tempScissors)) {
                this.firstWidget.draw(batch, alpha);
                batch.flush();
                ScissorStack.popScissors();
            }
        }
        if (this.secondWidget != null && this.secondWidget.isVisible()) {
            batch.flush();
            stage.calculateScissors(this.secondWidgetBounds, this.tempScissors);
            if (ScissorStack.pushScissors(this.tempScissors)) {
                this.secondWidget.draw(batch, alpha);
                batch.flush();
                ScissorStack.popScissors();
            }
        }
        batch.setColor(color.r, color.g, color.b, alpha);
        this.style.handle.draw(batch, this.handleBounds.x, this.handleBounds.y, this.handleBounds.width, this.handleBounds.height);
        this.resetTransform(batch);
    }

    public void setSplitAmount(float splitAmount) {
        this.splitAmount = splitAmount;
        this.invalidate();
    }

    public float getSplitAmount() {
        return this.splitAmount;
    }

    protected void clampSplitAmount() {
        float effectiveMinAmount = this.minAmount;
        float effectiveMaxAmount = this.maxAmount;
        if (this.vertical) {
            float availableHeight = this.getHeight() - this.style.handle.getMinHeight();
            if (this.firstWidget instanceof Layout) {
                effectiveMinAmount = Math.max(effectiveMinAmount, Math.min(((Layout)((Object)this.firstWidget)).getMinHeight() / availableHeight, 1.0f));
            }
            if (this.secondWidget instanceof Layout) {
                effectiveMaxAmount = Math.min(effectiveMaxAmount, 1.0f - Math.min(((Layout)((Object)this.secondWidget)).getMinHeight() / availableHeight, 1.0f));
            }
        } else {
            float availableWidth = this.getWidth() - this.style.handle.getMinWidth();
            if (this.firstWidget instanceof Layout) {
                effectiveMinAmount = Math.max(effectiveMinAmount, Math.min(((Layout)((Object)this.firstWidget)).getMinWidth() / availableWidth, 1.0f));
            }
            if (this.secondWidget instanceof Layout) {
                effectiveMaxAmount = Math.min(effectiveMaxAmount, 1.0f - Math.min(((Layout)((Object)this.secondWidget)).getMinWidth() / availableWidth, 1.0f));
            }
        }
        this.splitAmount = effectiveMinAmount > effectiveMaxAmount ? 0.5f * (effectiveMinAmount + effectiveMaxAmount) : Math.max(Math.min(this.splitAmount, effectiveMaxAmount), effectiveMinAmount);
    }

    public float getMinSplitAmount() {
        return this.minAmount;
    }

    public void setMinSplitAmount(float minAmount) {
        if (minAmount < 0.0f || minAmount > 1.0f) {
            throw new GdxRuntimeException("minAmount has to be >= 0 and <= 1");
        }
        this.minAmount = minAmount;
    }

    public float getMaxSplitAmount() {
        return this.maxAmount;
    }

    public void setMaxSplitAmount(float maxAmount) {
        if (maxAmount < 0.0f || maxAmount > 1.0f) {
            throw new GdxRuntimeException("maxAmount has to be >= 0 and <= 1");
        }
        this.maxAmount = maxAmount;
    }

    public void setFirstWidget(@Null Actor widget) {
        if (this.firstWidget != null) {
            super.removeActor(this.firstWidget);
        }
        this.firstWidget = widget;
        if (widget != null) {
            super.addActor(widget);
        }
        this.invalidate();
    }

    public void setSecondWidget(@Null Actor widget) {
        if (this.secondWidget != null) {
            super.removeActor(this.secondWidget);
        }
        this.secondWidget = widget;
        if (widget != null) {
            super.addActor(widget);
        }
        this.invalidate();
    }

    @Override
    public void addActor(Actor actor) {
        throw new UnsupportedOperationException("Use SplitPane#setWidget.");
    }

    @Override
    public void addActorAt(int index, Actor actor) {
        throw new UnsupportedOperationException("Use SplitPane#setWidget.");
    }

    @Override
    public void addActorBefore(Actor actorBefore, Actor actor) {
        throw new UnsupportedOperationException("Use SplitPane#setWidget.");
    }

    @Override
    public boolean removeActor(Actor actor) {
        if (actor == null) {
            throw new IllegalArgumentException("actor cannot be null.");
        }
        if (actor == this.firstWidget) {
            this.setFirstWidget(null);
            return true;
        }
        if (actor == this.secondWidget) {
            this.setSecondWidget(null);
            return true;
        }
        return true;
    }

    @Override
    public boolean removeActor(Actor actor, boolean unfocus) {
        if (actor == null) {
            throw new IllegalArgumentException("actor cannot be null.");
        }
        if (actor == this.firstWidget) {
            super.removeActor(actor, unfocus);
            this.firstWidget = null;
            this.invalidate();
            return true;
        }
        if (actor == this.secondWidget) {
            super.removeActor(actor, unfocus);
            this.secondWidget = null;
            this.invalidate();
            return true;
        }
        return false;
    }

    @Override
    public Actor removeActorAt(int index, boolean unfocus) {
        Actor actor = super.removeActorAt(index, unfocus);
        if (actor == this.firstWidget) {
            super.removeActor(actor, unfocus);
            this.firstWidget = null;
            this.invalidate();
        } else if (actor == this.secondWidget) {
            super.removeActor(actor, unfocus);
            this.secondWidget = null;
            this.invalidate();
        }
        return actor;
    }

    public boolean isCursorOverHandle() {
        return this.cursorOverHandle;
    }

    public static class SplitPaneStyle {
        public Drawable handle;

        public SplitPaneStyle() {
        }

        public SplitPaneStyle(Drawable handle) {
            this.handle = handle;
        }

        public SplitPaneStyle(SplitPaneStyle style) {
            this.handle = style.handle;
        }
    }
}

