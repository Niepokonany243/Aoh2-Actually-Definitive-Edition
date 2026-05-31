/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Scaling;

public class CheckBox
extends TextButton {
    private Image image;
    private Cell imageCell;
    private CheckBoxStyle style;

    public CheckBox(@Null String text, Skin skin) {
        this(text, skin.get(CheckBoxStyle.class));
    }

    public CheckBox(@Null String text, Skin skin, String styleName) {
        this(text, skin.get(styleName, CheckBoxStyle.class));
    }

    public CheckBox(@Null String text, CheckBoxStyle style) {
        super(text, style);
        this.clearChildren();
        Label label = this.getLabel();
        this.image = new Image(style.checkboxOff, Scaling.none);
        this.imageCell = this.add(this.image);
        this.add(label);
        label.setAlignment(8);
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
    }

    @Override
    public void setStyle(Button.ButtonStyle style) {
        if (!(style instanceof CheckBoxStyle)) {
            throw new IllegalArgumentException("style must be a CheckBoxStyle.");
        }
        this.style = (CheckBoxStyle)style;
        super.setStyle(style);
    }

    @Override
    public CheckBoxStyle getStyle() {
        return this.style;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Drawable checkbox = null;
        if (this.isDisabled()) {
            checkbox = this.isChecked && this.style.checkboxOnDisabled != null ? this.style.checkboxOnDisabled : this.style.checkboxOffDisabled;
        }
        if (checkbox == null) {
            boolean over;
            boolean bl = over = this.isOver() && !this.isDisabled();
            checkbox = this.isChecked && this.style.checkboxOn != null ? (over && this.style.checkboxOnOver != null ? this.style.checkboxOnOver : this.style.checkboxOn) : (over && this.style.checkboxOver != null ? this.style.checkboxOver : this.style.checkboxOff);
        }
        this.image.setDrawable(checkbox);
        super.draw(batch, parentAlpha);
    }

    public Image getImage() {
        return this.image;
    }

    public Cell getImageCell() {
        return this.imageCell;
    }

    public static class CheckBoxStyle
    extends TextButton.TextButtonStyle {
        public Drawable checkboxOn;
        public Drawable checkboxOff;
        @Null
        public Drawable checkboxOnOver;
        @Null
        public Drawable checkboxOver;
        @Null
        public Drawable checkboxOnDisabled;
        @Null
        public Drawable checkboxOffDisabled;

        public CheckBoxStyle() {
        }

        public CheckBoxStyle(Drawable checkboxOff, Drawable checkboxOn, BitmapFont font, @Null Color fontColor) {
            this.checkboxOff = checkboxOff;
            this.checkboxOn = checkboxOn;
            this.font = font;
            this.fontColor = fontColor;
        }

        public CheckBoxStyle(CheckBoxStyle style) {
            super(style);
            this.checkboxOff = style.checkboxOff;
            this.checkboxOn = style.checkboxOn;
            this.checkboxOnOver = style.checkboxOnOver;
            this.checkboxOver = style.checkboxOver;
            this.checkboxOnDisabled = style.checkboxOnDisabled;
            this.checkboxOffDisabled = style.checkboxOffDisabled;
        }
    }
}

