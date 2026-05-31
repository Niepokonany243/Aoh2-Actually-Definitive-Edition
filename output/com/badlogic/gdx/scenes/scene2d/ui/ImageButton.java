/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Scaling;

public class ImageButton
extends Button {
    private final Image image = new Image();
    private ImageButtonStyle style;

    public ImageButton(Skin skin) {
        this(skin.get(ImageButtonStyle.class));
        this.setSkin(skin);
    }

    public ImageButton(Skin skin, String styleName) {
        this(skin.get(styleName, ImageButtonStyle.class));
        this.setSkin(skin);
    }

    public ImageButton(ImageButtonStyle style) {
        super(style);
        this.image.setScaling(Scaling.fit);
        this.add(this.image);
        this.setStyle(style);
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
    }

    public ImageButton(@Null Drawable imageUp) {
        this(new ImageButtonStyle(null, null, null, imageUp, null, null));
    }

    public ImageButton(@Null Drawable imageUp, @Null Drawable imageDown) {
        this(new ImageButtonStyle(null, null, null, imageUp, imageDown, null));
    }

    public ImageButton(@Null Drawable imageUp, @Null Drawable imageDown, @Null Drawable imageChecked) {
        this(new ImageButtonStyle(null, null, null, imageUp, imageDown, imageChecked));
    }

    @Override
    public void setStyle(Button.ButtonStyle style) {
        if (!(style instanceof ImageButtonStyle)) {
            throw new IllegalArgumentException("style must be an ImageButtonStyle.");
        }
        this.style = (ImageButtonStyle)style;
        super.setStyle(style);
        if (this.image != null) {
            this.updateImage();
        }
    }

    @Override
    public ImageButtonStyle getStyle() {
        return this.style;
    }

    @Null
    protected Drawable getImageDrawable() {
        if (this.isDisabled() && this.style.imageDisabled != null) {
            return this.style.imageDisabled;
        }
        if (this.isPressed()) {
            if (this.isChecked() && this.style.imageCheckedDown != null) {
                return this.style.imageCheckedDown;
            }
            if (this.style.imageDown != null) {
                return this.style.imageDown;
            }
        }
        if (this.isOver()) {
            if (this.isChecked()) {
                if (this.style.imageCheckedOver != null) {
                    return this.style.imageCheckedOver;
                }
            } else if (this.style.imageOver != null) {
                return this.style.imageOver;
            }
        }
        if (this.isChecked()) {
            if (this.style.imageChecked != null) {
                return this.style.imageChecked;
            }
            if (this.isOver() && this.style.imageOver != null) {
                return this.style.imageOver;
            }
        }
        return this.style.imageUp;
    }

    protected void updateImage() {
        this.image.setDrawable(this.getImageDrawable());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        this.updateImage();
        super.draw(batch, parentAlpha);
    }

    public Image getImage() {
        return this.image;
    }

    public Cell getImageCell() {
        return this.getCell(this.image);
    }

    @Override
    public String toString() {
        String name = this.getName();
        if (name != null) {
            return name;
        }
        String className = this.getClass().getName();
        int dotIndex = className.lastIndexOf(46);
        if (dotIndex != -1) {
            className = className.substring(dotIndex + 1);
        }
        return (className.indexOf(36) != -1 ? "ImageButton " : "") + className + ": " + this.image.getDrawable();
    }

    public static class ImageButtonStyle
    extends Button.ButtonStyle {
        @Null
        public Drawable imageUp;
        @Null
        public Drawable imageDown;
        @Null
        public Drawable imageOver;
        @Null
        public Drawable imageDisabled;
        @Null
        public Drawable imageChecked;
        @Null
        public Drawable imageCheckedDown;
        @Null
        public Drawable imageCheckedOver;

        public ImageButtonStyle() {
        }

        public ImageButtonStyle(@Null Drawable up, @Null Drawable down, @Null Drawable checked, @Null Drawable imageUp, @Null Drawable imageDown, @Null Drawable imageChecked) {
            super(up, down, checked);
            this.imageUp = imageUp;
            this.imageDown = imageDown;
            this.imageChecked = imageChecked;
        }

        public ImageButtonStyle(ImageButtonStyle style) {
            super(style);
            this.imageUp = style.imageUp;
            this.imageDown = style.imageDown;
            this.imageOver = style.imageOver;
            this.imageDisabled = style.imageDisabled;
            this.imageChecked = style.imageChecked;
            this.imageCheckedDown = style.imageCheckedDown;
            this.imageCheckedOver = style.imageCheckedOver;
        }

        public ImageButtonStyle(Button.ButtonStyle style) {
            super(style);
        }
    }
}

