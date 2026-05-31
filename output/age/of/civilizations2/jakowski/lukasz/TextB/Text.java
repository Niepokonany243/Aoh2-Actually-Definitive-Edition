
package age.of.civilizations2.jakowski.lukasz.TextB;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Text
extends MenuElemUI {
    public String sText = null;
    public int iTextWidth = -1;
    public int iTextHeight = -1;
    public int iTextPositionX;
    public TextPosition textPosition;

    public Text() {
    }

    public Text(String sText, int iPosX, int iPosY) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setHeightE(CFG.TEXT_HEIGHT_DEFAULT);
        this.setTextE(sText);
        this.textPosition = new TextPosition(){

            @Override
            public int getTextPosition() {
                return 0;
            }
        };
    }

    public Text(String sText, int iPosX, int iPosY, int fontID) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT;
        this.fontID = fontID;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setHeightE(CFG.TEXT_HEIGHT_DEFAULT);
        this.setTextE(sText);
        this.textPosition = new TextPosition(){

            @Override
            public int getTextPosition() {
                return 0;
            }
        };
    }

    public Text(String sText, int iTextPositionX, int iPosX, int iPosY, int iHeight) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT;
        this.iTextPositionX = iTextPositionX;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setHeightE(iHeight);
        this.setTextE(sText);
        this.updateTextPosition();
    }

    public Text(String sText, int iTextPositionX, int iPosX, int iPosY, int iHeight, float fontID) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT;
        this.fontID = (int)fontID;
        this.iTextPositionX = iTextPositionX;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setHeightE(iHeight);
        this.setTextE(sText);
        this.updateTextPosition();
    }

    public Text(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT;
        this.iTextPositionX = iTextPositionX;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setWidthE(iWidth);
        this.setHeightE(iHeight);
        this.setTextE(sText);
        this.updateTextPosition();
    }

    public Text(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, int fontID) {
        this.fontID = fontID;
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT;
        this.iTextPositionX = iTextPositionX;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setWidthE(iWidth);
        this.setHeightE(iHeight);
        this.setTextE(sText);
        this.updateTextPosition();
    }

    public void updateTextPosition() {
        this.textPosition = this.iTextPositionX < 0 ? new TextPosition(){

            @Override
            public int getTextPosition() {
                return Text.this.getWidthE() / 2 - Text.this.iTextWidth / 2;
            }
        } : new TextPosition(){

            @Override
            public int getTextPosition() {
                return Text.this.iTextPositionX;
            }
        };
    }

    @Override
    public String getTextE() {
        return this.sText;
    }

    @Override
    public String getTextToDrawElem() {
        return this.sText;
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        String text = this.sText == null ? "" : this.sText;
        int drawPosX = this.getPosXE() + iTranslateX;
        try {
            drawPosX += this.textPosition.getTextPosition();
        } catch (Exception ex) {
            drawPosX += this.getWidthE() / 2 - this.getTextWidthU() / 2;
        }
        int drawPosY = this.getPosY() + (this.getHeightE() - this.getTextHeight()) / 2 + iTranslateY;
        
        Renderer.drawTextWithShadow(oSB, this.fontID, text, drawPosX, drawPosY, this.getColor(isActive));
    }

    public Color getColor(boolean isActive) {
        return isActive ? new Color(0.56f, 0.56f, 0.56f, 1.0f) : (this.getIsClickable() ? (this.getIsHovered() ? new Color(0.68f, 0.68f, 0.68f, 1.0f) : CFG.COLOR_BUTTON_MENU_TEXT) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
    }

    @Override
    public void setTextE(String sText) {
        this.sText = sText == null ? "" : sText;
        try {
            if (this.sText.length() > 0) {
                if (CFG.fontMain != null && CFG.fontMain.size() > this.fontID) {
                    this.iTextWidth = CFG.getGlyphWidth(CFG.fontMain.get(this.fontID), this.sText);
                    this.iTextHeight = CFG.getGlyphHeight(CFG.fontMain.get(this.fontID), this.sText);
                } else {
                    this.iTextWidth = this.sText.length() * CFG.TEXT_HEIGHT_DEFAULT;
                    this.iTextHeight = CFG.TEXT_HEIGHT_DEFAULT;
                }

                
                if (super.getWidthE() <= 0 || (super.getWidthE() < this.iTextWidth && !this.isPinnedWidth())) {
                    this.setWidthE(this.iTextWidth);
                }
                if (this.getHeightE() < this.iTextHeight) {
                    this.setHeightE(this.iTextHeight);
                }
            } else {
                this.iTextWidth = 0;
                this.iTextHeight = CFG.TEXT_HEIGHT_DEFAULT;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    private boolean pinnedWidth = false;
    public final boolean isPinnedWidth() { return pinnedWidth; }
    public final void setPinnedWidth(boolean pinned) { this.pinnedWidth = pinned; }

    @Override
    public int getTextWidthU() {
        return this.iTextWidth;
    }

    @Override
    public int getTextHeight() {
        return this.iTextHeight;
    }

    public static interface TextPosition {
        public int getTextPosition();
    }
}

