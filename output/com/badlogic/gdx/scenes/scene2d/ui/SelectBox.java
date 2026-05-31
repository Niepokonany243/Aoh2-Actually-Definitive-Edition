/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.utils.ArraySelection;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.OrderedSet;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;

public class SelectBox<T>
extends Widget
implements Disableable {
    static final Vector2 temp = new Vector2();
    SelectBoxStyle style;
    final Array<T> items = new Array();
    SelectBoxList<T> selectBoxList;
    private float prefWidth;
    private float prefHeight;
    private ClickListener clickListener;
    boolean disabled;
    private int alignment = 8;
    boolean selectedPrefWidth;
    final ArraySelection<T> selection = new ArraySelection(this.items){

        @Override
        public boolean fireChangeEvent() {
            if (SelectBox.this.selectedPrefWidth) {
                SelectBox.this.invalidateHierarchy();
            }
            return super.fireChangeEvent();
        }
    };

    public SelectBox(Skin skin) {
        this(skin.get(SelectBoxStyle.class));
    }

    public SelectBox(Skin skin, String styleName) {
        this(skin.get(styleName, SelectBoxStyle.class));
    }

    public SelectBox(SelectBoxStyle style) {
        this.setStyle(style);
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
        this.selection.setActor(this);
        this.selection.setRequired(true);
        this.selectBoxList = new SelectBoxList(this);
        this.clickListener = new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (pointer == 0 && button != 0) {
                    return false;
                }
                if (SelectBox.this.isDisabled()) {
                    return false;
                }
                if (SelectBox.this.selectBoxList.hasParent()) {
                    SelectBox.this.hideList();
                } else {
                    SelectBox.this.showList();
                }
                return true;
            }
        };
        this.addListener(this.clickListener);
    }

    public void setMaxListCount(int maxListCount) {
        this.selectBoxList.maxListCount = maxListCount;
    }

    public int getMaxListCount() {
        return this.selectBoxList.maxListCount;
    }

    @Override
    protected void setStage(Stage stage) {
        if (stage == null) {
            this.selectBoxList.hide();
        }
        super.setStage(stage);
    }

    public void setStyle(SelectBoxStyle style) {
        if (style == null) {
            throw new IllegalArgumentException("style cannot be null.");
        }
        this.style = style;
        if (this.selectBoxList != null) {
            this.selectBoxList.setStyle(style.scrollStyle);
            this.selectBoxList.list.setStyle(style.listStyle);
        }
        this.invalidateHierarchy();
    }

    public SelectBoxStyle getStyle() {
        return this.style;
    }

    public void setItems(T ... newItems) {
        if (newItems == null) {
            throw new IllegalArgumentException("newItems cannot be null.");
        }
        float oldPrefWidth = this.getPrefWidth();
        this.items.clear();
        this.items.addAll(newItems);
        this.selection.validate();
        this.selectBoxList.list.setItems(this.items);
        this.invalidate();
        if (oldPrefWidth != this.getPrefWidth()) {
            this.invalidateHierarchy();
        }
    }

    public void setItems(Array<T> newItems) {
        if (newItems == null) {
            throw new IllegalArgumentException("newItems cannot be null.");
        }
        float oldPrefWidth = this.getPrefWidth();
        if (newItems != this.items) {
            this.items.clear();
            this.items.addAll(newItems);
        }
        this.selection.validate();
        this.selectBoxList.list.setItems(this.items);
        this.invalidate();
        if (oldPrefWidth != this.getPrefWidth()) {
            this.invalidateHierarchy();
        }
    }

    public void clearItems() {
        if (this.items.size == 0) {
            return;
        }
        this.items.clear();
        this.selection.clear();
        this.invalidateHierarchy();
    }

    public Array<T> getItems() {
        return this.items;
    }

    @Override
    public void layout() {
        Drawable bg = this.style.background;
        BitmapFont font = this.style.font;
        this.prefHeight = bg != null ? Math.max(bg.getTopHeight() + bg.getBottomHeight() + font.getCapHeight() - font.getDescent() * 2.0f, bg.getMinHeight()) : font.getCapHeight() - font.getDescent() * 2.0f;
        Pool<GlyphLayout> layoutPool = Pools.get(GlyphLayout.class);
        GlyphLayout layout = layoutPool.obtain();
        if (this.selectedPrefWidth) {
            T selected;
            this.prefWidth = 0.0f;
            if (bg != null) {
                this.prefWidth = bg.getLeftWidth() + bg.getRightWidth();
            }
            if ((selected = this.getSelected()) != null) {
                layout.setText(font, this.toString(selected));
                this.prefWidth += layout.width;
            }
        } else {
            float maxItemWidth = 0.0f;
            for (int i = 0; i < this.items.size; ++i) {
                layout.setText(font, this.toString(this.items.get(i)));
                maxItemWidth = Math.max(layout.width, maxItemWidth);
            }
            this.prefWidth = maxItemWidth;
            if (bg != null) {
                this.prefWidth = Math.max(this.prefWidth + bg.getLeftWidth() + bg.getRightWidth(), bg.getMinWidth());
            }
            List.ListStyle listStyle = this.style.listStyle;
            ScrollPane.ScrollPaneStyle scrollStyle = this.style.scrollStyle;
            float listWidth = maxItemWidth + listStyle.selection.getLeftWidth() + listStyle.selection.getRightWidth();
            bg = scrollStyle.background;
            if (bg != null) {
                listWidth = Math.max(listWidth + bg.getLeftWidth() + bg.getRightWidth(), bg.getMinWidth());
            }
            if (this.selectBoxList == null || !this.selectBoxList.disableY) {
                listWidth += Math.max(this.style.scrollStyle.vScroll != null ? this.style.scrollStyle.vScroll.getMinWidth() : 0.0f, this.style.scrollStyle.vScrollKnob != null ? this.style.scrollStyle.vScrollKnob.getMinWidth() : 0.0f);
            }
            this.prefWidth = Math.max(this.prefWidth, listWidth);
        }
        layoutPool.free(layout);
    }

    @Null
    protected Drawable getBackgroundDrawable() {
        if (this.isDisabled() && this.style.backgroundDisabled != null) {
            return this.style.backgroundDisabled;
        }
        if (this.selectBoxList.hasParent() && this.style.backgroundOpen != null) {
            return this.style.backgroundOpen;
        }
        if (this.isOver() && this.style.backgroundOver != null) {
            return this.style.backgroundOver;
        }
        return this.style.background;
    }

    @Null
    protected Color getFontColor() {
        if (this.isDisabled() && this.style.disabledFontColor != null) {
            return this.style.disabledFontColor;
        }
        if (this.style.overFontColor != null && (this.isOver() || this.selectBoxList.hasParent())) {
            return this.style.overFontColor;
        }
        return this.style.fontColor;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Object selected;
        this.validate();
        Drawable background = this.getBackgroundDrawable();
        Color fontColor = this.getFontColor();
        BitmapFont font = this.style.font;
        Color color = this.getColor();
        float x = this.getX();
        float y = this.getY();
        float width = this.getWidth();
        float height = this.getHeight();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        if (background != null) {
            background.draw(batch, x, y, width, height);
        }
        if ((selected = this.selection.first()) != null) {
            if (background != null) {
                width -= background.getLeftWidth() + background.getRightWidth();
                x += background.getLeftWidth();
                y += (float)((int)((height -= background.getBottomHeight() + background.getTopHeight()) / 2.0f + background.getBottomHeight() + font.getData().capHeight / 2.0f));
            } else {
                y += (float)((int)(height / 2.0f + font.getData().capHeight / 2.0f));
            }
            font.setColor(fontColor.r, fontColor.g, fontColor.b, fontColor.a * parentAlpha);
            this.drawItem(batch, font, selected, x, y, width);
        }
    }

    protected GlyphLayout drawItem(Batch batch, BitmapFont font, T item, float x, float y, float width) {
        String string = this.toString(item);
        return font.draw(batch, string, x, y, 0, string.length(), width, this.alignment, false, "...");
    }

    public void setAlignment(int alignment) {
        this.alignment = alignment;
    }

    public ArraySelection<T> getSelection() {
        return this.selection;
    }

    @Null
    public T getSelected() {
        return this.selection.first();
    }

    public void setSelected(@Null T item) {
        if (this.items.contains(item, false)) {
            this.selection.set(item);
        } else if (this.items.size > 0) {
            this.selection.set(this.items.first());
        } else {
            this.selection.clear();
        }
    }

    public int getSelectedIndex() {
        OrderedSet selected = this.selection.items();
        return selected.size == 0 ? -1 : this.items.indexOf(selected.first(), false);
    }

    public void setSelectedIndex(int index) {
        this.selection.set(this.items.get(index));
    }

    public void setSelectedPrefWidth(boolean selectedPrefWidth) {
        this.selectedPrefWidth = selectedPrefWidth;
    }

    public float getMaxSelectedPrefWidth() {
        Pool<GlyphLayout> layoutPool = Pools.get(GlyphLayout.class);
        GlyphLayout layout = layoutPool.obtain();
        float width = 0.0f;
        for (int i = 0; i < this.items.size; ++i) {
            layout.setText(this.style.font, this.toString(this.items.get(i)));
            width = Math.max(layout.width, width);
        }
        Drawable bg = this.style.background;
        if (bg != null) {
            width = Math.max(width + bg.getLeftWidth() + bg.getRightWidth(), bg.getMinWidth());
        }
        return width;
    }

    @Override
    public void setDisabled(boolean disabled) {
        if (disabled && !this.disabled) {
            this.hideList();
        }
        this.disabled = disabled;
    }

    @Override
    public boolean isDisabled() {
        return this.disabled;
    }

    @Override
    public float getPrefWidth() {
        this.validate();
        return this.prefWidth;
    }

    @Override
    public float getPrefHeight() {
        this.validate();
        return this.prefHeight;
    }

    protected String toString(T item) {
        return item.toString();
    }

    public void showList() {
        if (this.items.size == 0) {
            return;
        }
        if (this.getStage() != null) {
            this.selectBoxList.show(this.getStage());
        }
    }

    public void hideList() {
        this.selectBoxList.hide();
    }

    public List<T> getList() {
        return this.selectBoxList.list;
    }

    public void setScrollingDisabled(boolean y) {
        this.selectBoxList.setScrollingDisabled(true, y);
        this.invalidateHierarchy();
    }

    public ScrollPane getScrollPane() {
        return this.selectBoxList;
    }

    public boolean isOver() {
        return this.clickListener.isOver();
    }

    public ClickListener getClickListener() {
        return this.clickListener;
    }

    protected void onShow(Actor selectBoxList, boolean below) {
        selectBoxList.getColor().a = 0.0f;
        selectBoxList.addAction(Actions.fadeIn(0.3f, Interpolation.fade));
    }

    protected void onHide(Actor selectBoxList) {
        selectBoxList.getColor().a = 1.0f;
        selectBoxList.addAction(Actions.sequence((Action)Actions.fadeOut(0.15f, Interpolation.fade), (Action)Actions.removeActor()));
    }

    public static class SelectBoxStyle {
        public BitmapFont font;
        public Color fontColor = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        @Null
        public Color overFontColor;
        @Null
        public Color disabledFontColor;
        @Null
        public Drawable background;
        public ScrollPane.ScrollPaneStyle scrollStyle;
        public List.ListStyle listStyle;
        @Null
        public Drawable backgroundOver;
        @Null
        public Drawable backgroundOpen;
        @Null
        public Drawable backgroundDisabled;

        public SelectBoxStyle() {
        }

        public SelectBoxStyle(BitmapFont font, Color fontColor, @Null Drawable background, ScrollPane.ScrollPaneStyle scrollStyle, List.ListStyle listStyle) {
            this.font = font;
            this.fontColor.set(fontColor);
            this.background = background;
            this.scrollStyle = scrollStyle;
            this.listStyle = listStyle;
        }

        public SelectBoxStyle(SelectBoxStyle style) {
            this.font = style.font;
            this.fontColor.set(style.fontColor);
            if (style.overFontColor != null) {
                this.overFontColor = new Color(style.overFontColor);
            }
            if (style.disabledFontColor != null) {
                this.disabledFontColor = new Color(style.disabledFontColor);
            }
            this.background = style.background;
            this.scrollStyle = new ScrollPane.ScrollPaneStyle(style.scrollStyle);
            this.listStyle = new List.ListStyle(style.listStyle);
            this.backgroundOver = style.backgroundOver;
            this.backgroundOpen = style.backgroundOpen;
            this.backgroundDisabled = style.backgroundDisabled;
        }
    }

    static class SelectBoxList<T>
    extends ScrollPane {
        private final SelectBox<T> selectBox;
        int maxListCount;
        private final Vector2 stagePosition = new Vector2();
        final List<T> list;
        private InputListener hideListener;
        private Actor previousScrollFocus;

        public SelectBoxList(final SelectBox<T> selectBox) {
            super(null, selectBox.style.scrollStyle);
            this.selectBox = selectBox;
            this.setOverscroll(false, false);
            this.setFadeScrollBars(false);
            this.setScrollingDisabled(true, false);
            this.list = new List<T>(selectBox.style.listStyle){

                @Override
                public String toString(T obj) {
                    return selectBox.toString(obj);
                }
            };
            this.list.setTouchable(Touchable.disabled);
            this.list.setTypeToSelect(true);
            this.setActor(this.list);
            this.list.addListener(new ClickListener(){

                @Override
                public void clicked(InputEvent event, float x, float y) {
                    Object selected = SelectBoxList.this.list.getSelected();
                    if (selected != null) {
                        selectBox.selection.items().clear();
                    }
                    selectBox.selection.choose(selected);
                    SelectBoxList.this.hide();
                }

                @Override
                public boolean mouseMoved(InputEvent event, float x, float y) {
                    int index = SelectBoxList.this.list.getItemIndexAt(y);
                    if (index != -1) {
                        SelectBoxList.this.list.setSelectedIndex(index);
                    }
                    return true;
                }
            });
            this.addListener(new InputListener(){

                @Override
                public void exit(InputEvent event, float x, float y, int pointer, @Null Actor toActor) {
                    if (toActor == null || !SelectBoxList.this.isAscendantOf(toActor)) {
                        SelectBoxList.this.list.selection.set(selectBox.getSelected());
                    }
                }
            });
            this.hideListener = new InputListener(){

                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Actor target = event.getTarget();
                    if (SelectBoxList.this.isAscendantOf(target)) {
                        return false;
                    }
                    SelectBoxList.this.list.selection.set(selectBox.getSelected());
                    SelectBoxList.this.hide();
                    return false;
                }

                @Override
                public boolean keyDown(InputEvent event, int keycode) {
                    switch (keycode) {
                        case 66: 
                        case 160: {
                            selectBox.selection.choose(SelectBoxList.this.list.getSelected());
                        }
                        case 111: {
                            SelectBoxList.this.hide();
                            event.stop();
                            return true;
                        }
                    }
                    return false;
                }
            };
        }

        public void show(Stage stage) {
            Drawable listBackground;
            if (this.list.isTouchable()) {
                return;
            }
            stage.addActor(this);
            stage.addCaptureListener(this.hideListener);
            stage.addListener(this.list.getKeyListener());
            this.selectBox.localToStageCoordinates(this.stagePosition.set(0.0f, 0.0f));
            float itemHeight = this.list.getItemHeight();
            float height = itemHeight * (float)(this.maxListCount <= 0 ? this.selectBox.items.size : Math.min(this.maxListCount, this.selectBox.items.size));
            Drawable scrollPaneBackground = this.getStyle().background;
            if (scrollPaneBackground != null) {
                height += scrollPaneBackground.getTopHeight() + scrollPaneBackground.getBottomHeight();
            }
            if ((listBackground = this.list.getStyle().background) != null) {
                height += listBackground.getTopHeight() + listBackground.getBottomHeight();
            }
            float heightBelow = this.stagePosition.y;
            float heightAbove = stage.getHeight() - heightBelow - this.selectBox.getHeight();
            boolean below = true;
            if (height > heightBelow) {
                if (heightAbove > heightBelow) {
                    below = false;
                    height = Math.min(height, heightAbove);
                } else {
                    height = heightBelow;
                }
            }
            if (below) {
                this.setY(this.stagePosition.y - height);
            } else {
                this.setY(this.stagePosition.y + this.selectBox.getHeight());
            }
            this.setX(this.stagePosition.x);
            this.setHeight(height);
            this.validate();
            float width = Math.max(this.getPrefWidth(), this.selectBox.getWidth());
            if (this.getPrefHeight() > height && !this.disableY) {
                width += this.getScrollBarWidth();
            }
            this.setWidth(width);
            this.validate();
            this.scrollTo(0.0f, this.list.getHeight() - (float)this.selectBox.getSelectedIndex() * itemHeight - itemHeight / 2.0f, 0.0f, 0.0f, true, true);
            this.updateVisualScroll();
            this.previousScrollFocus = null;
            Actor actor = stage.getScrollFocus();
            if (actor != null && !actor.isDescendantOf(this)) {
                this.previousScrollFocus = actor;
            }
            stage.setScrollFocus(this);
            this.list.selection.set(this.selectBox.getSelected());
            this.list.setTouchable(Touchable.enabled);
            this.clearActions();
            this.selectBox.onShow(this, below);
        }

        public void hide() {
            if (!this.list.isTouchable() || !this.hasParent()) {
                return;
            }
            this.list.setTouchable(Touchable.disabled);
            Stage stage = this.getStage();
            if (stage != null) {
                Actor actor;
                stage.removeCaptureListener(this.hideListener);
                stage.removeListener(this.list.getKeyListener());
                if (this.previousScrollFocus != null && this.previousScrollFocus.getStage() == null) {
                    this.previousScrollFocus = null;
                }
                if ((actor = stage.getScrollFocus()) == null || this.isAscendantOf(actor)) {
                    stage.setScrollFocus(this.previousScrollFocus);
                }
            }
            this.clearActions();
            this.selectBox.onHide(this);
        }

        @Override
        public void draw(Batch batch, float parentAlpha) {
            this.selectBox.localToStageCoordinates(temp.set(0.0f, 0.0f));
            if (!temp.equals(this.stagePosition)) {
                this.hide();
            }
            super.draw(batch, parentAlpha);
        }

        @Override
        public void act(float delta) {
            super.act(delta);
            this.toFront();
        }

        @Override
        protected void setStage(Stage stage) {
            Stage oldStage = this.getStage();
            if (oldStage != null) {
                oldStage.removeCaptureListener(this.hideListener);
                oldStage.removeListener(this.list.getKeyListener());
            }
            super.setStage(stage);
        }
    }
}

