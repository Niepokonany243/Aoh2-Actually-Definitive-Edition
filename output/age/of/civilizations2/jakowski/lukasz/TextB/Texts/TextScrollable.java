/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;

public class TextScrollable
extends Text {
    private Color textColor;
    private int iScrollPosX = 0;
    private boolean scrollRight = true;
    private long lTime;
    private float fTextScale = 1.0f;
    private boolean center = false;
    private DrawText drawText;

    public TextScrollable(String sText, int iPosX, int iPosY, int iWidth, Color textColor) {
        this.init(sText, iPosX, iPosY, iWidth, 0, textColor, 1.0f, 0);
    }

    public TextScrollable(String sText, int iPosX, int iPosY, int iWidth, Color textColor, float nTextScale) {
        this.init(sText, iPosX, iPosY, iWidth, 0, textColor, nTextScale, 0);
    }

    public TextScrollable(String sText, int iPosX, int iPosY, int iWidth, int iHeight, Color textColor, float nTextScale) {
        this.init(sText, iPosX, iPosY, iWidth, iHeight, textColor, nTextScale, 0);
    }

    public TextScrollable(String sText, int iPosX, int iPosY, int iWidth, int iHeight, Color textColor, float nTextScale, int iTextPos) {
        this.init(sText, iPosX, iPosY, iWidth, iHeight, textColor, nTextScale, iTextPos);
    }

    private final void init(String sText, int iPosX, int iPosY, int iWidth, int iHeight, Color textColor, float nTextScale, int iTextPos) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT;
        this.iScrollPosX = iTextPos;
        this.fTextScale = nTextScale;
        this.center = iTextPos < 0;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setWidthE(iWidth);
        if (iHeight > 0) {
            this.setHeightE(iHeight);
        }
        this.setTextE(sText);
        this.textColor = textColor;
        this.updateTextPosition();
        this.drawText = this.fTextScale != 1.0f ? new DrawText(){

            @Override
            public void draw_Element(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                CFG.fontMain.get(0).getData().setScale(TextScrollable.this.fTextScale);
                CFG.drawTextDefaultWithShadow(oSB, TextScrollable.this.getTextE(), TextScrollable.this.getPosXE() + (isActive && !TextScrollable.this.center ? TextScrollable.this.iScrollPosX : TextScrollable.this.textPosition.getTextPosition()) + iTranslateX, TextScrollable.this.getPosY() + TextScrollable.this.getHeightE() / 2 - TextScrollable.this.iTextHeight / 2 + iTranslateY, TextScrollable.this.getColor(isActive));
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }
        } : new DrawText(){

            @Override
            public void draw_Element(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                CFG.drawTextDefaultWithShadow(oSB, TextScrollable.this.getTextE(), TextScrollable.this.getPosXE() + (isActive && !TextScrollable.this.center ? TextScrollable.this.iScrollPosX : TextScrollable.this.textPosition.getTextPosition()) + iTranslateX, TextScrollable.this.getPosY() + TextScrollable.this.getHeightE() / 2 - TextScrollable.this.iTextHeight / 2 + iTranslateY, TextScrollable.this.getColor(isActive));
            }
        };
    }

    public void draw_StartClip(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        int rectW = this.getWidthE();
        int rectH = this.getHeightE() + CFG.PADD * 2;
        int rectX = this.getPosXE() + iTranslateX;
        int rectY = CFG.GAMEHEIGHT - this.getPosY() - iTranslateY - rectH;
        Rectangle clipBounds = new Rectangle(rectX, rectY, rectW, rectH);
        oSB.flush();
        ScissorStack.pushScissors(clipBounds);
    }

    public void draw_Element(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        this.drawText.draw_Element(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
    }

    public void draw_EndClip(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        try {
            oSB.flush();
            ScissorStack.popScissors();
        }
        catch (IllegalStateException illegalStateException) {
            // empty catch block
        }
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        this.draw_StartClip(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
        this.draw_Element(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
        this.draw_EndClip(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
    }

    @Override
    public Color getColor(boolean isActive) {
        return isActive ? CFG.COLOR_HOVER_TITLE : (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_HOVERED : (this.getIsClickable() ? this.textColor : new Color(0.78f, 0.78f, 0.78f, 0.7f)));
    }

    @Override
    public void setTextE(String sText) {
        this.sText = sText == null ? "" : sText;
        try {
            if (CFG.fontMain != null && CFG.fontMain.size() > this.fontID) {
                CFG.fontMain.get(this.fontID).getData().setScale(this.fTextScale);
                this.iTextWidth = CFG.getGlyphWidth(CFG.fontMain.get(this.fontID), this.sText);
                this.iTextHeight = CFG.getGlyphHeight(CFG.fontMain.get(this.fontID), this.sText);
                this.updateTextPosition();
            } else {
                this.iTextWidth = this.sText.length() * CFG.TEXT_HEIGHT_DEFAULT;
                this.iTextHeight = CFG.TEXT_HEIGHT_DEFAULT;
            }
            // Stability: Do NOT expand width automatically here. Keep it pinned to constructor width.
            if (this.getHeightE() < this.iTextHeight) {
                this.setHeightE(this.iTextHeight);
            }
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
        try {
            if (CFG.fontMain != null && CFG.fontMain.size() > this.fontID) {
                CFG.fontMain.get(this.fontID).getData().setScale(1.0f);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public final void updateTextPosition() {
        this.textPosition = this.getTextWidthU() > this.getWidthE() + CFG.PADD ? new Text.TextPosition(){

            @Override
            public int getTextPosition() {
                if (TextScrollable.this.lTime + 35L <= System.currentTimeMillis()) {
                    if (TextScrollable.this.scrollRight) {
                        --TextScrollable.this.iScrollPosX;
                        if (TextScrollable.this.getWidthE() - TextScrollable.this.iScrollPosX >= TextScrollable.this.getTextWidthU() + CFG.PADD) {
                            TextScrollable.this.scrollRight = !TextScrollable.this.scrollRight;
                        }
                    } else {
                        ++TextScrollable.this.iScrollPosX;
                        if (TextScrollable.this.iScrollPosX == CFG.PADD) {
                            TextScrollable.this.scrollRight = !TextScrollable.this.scrollRight;
                        }
                    }
                    TextScrollable.this.lTime = System.currentTimeMillis();
                    CFG.setRenderO(true);
                }
                return TextScrollable.this.iScrollPosX;
            }
        } : (this.center ? new Text.TextPosition(){

            @Override
            public int getTextPosition() {
                return TextScrollable.this.getWidthE() / 2 - TextScrollable.this.getTextWidthU() / 2;
            }
        } : new Text.TextPosition(){

            @Override
            public int getTextPosition() {
                return 0;
            }
        });
        this.iScrollPosX = 0;
        this.scrollRight = true;
    }

    @Override
    public int getCurr() {
        return this.iScrollPosX;
    }

    private static interface DrawText {
        public void draw_Element(SpriteBatch var1, int var2, int var3, boolean var4, boolean var5);
    }
}

