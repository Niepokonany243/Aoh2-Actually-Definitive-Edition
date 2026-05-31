
package age.of.civilizations2.jakowski.lukasz.Button2;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Text_Static
extends MenuElemUI {
    public int iCurrent;
    protected String sText = null;
    protected int iTextWidth = -1;
    protected int iTextHeight = -1;
    protected int iTextPositionX;
    protected TextPosition textPosition;

    protected Text_Static() {
    }

    public Text_Static(String sText, int iPosX, int iPosY) {
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

    public Text_Static(String sText, int iPosX, int iPosY, int fontID) {
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

    public Text_Static(String sText, int iTextPositionX, int iPosX, int iPosY, int iHeight) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT;
        this.iTextPositionX = iTextPositionX;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setHeightE(iHeight);
        this.setTextE(sText);
        this.updateTextPosition();
    }

    public Text_Static(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT;
        this.iTextPositionX = iTextPositionX;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setWidthE(iWidth);
        this.setHeightE(iHeight);
        this.setTextE(sText);
        this.updateTextPosition();
    }

    public Text_Static(String sText, int fontID, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT;
        this.fontID = fontID;
        this.iTextPositionX = iTextPositionX;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setWidthE(iWidth);
        this.setHeightE(iHeight);
        this.setTextE(sText);
        this.updateTextPosition();
    }

    public Text_Static(String sText, int fontID, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, int nCurrent) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT;
        this.fontID = fontID;
        this.iCurrent = nCurrent;
        this.iTextPositionX = iTextPositionX;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setWidthE(iWidth);
        this.setHeightE(iHeight);
        this.setTextE(sText);
        this.updateTextPosition();
    }

    protected void updateTextPosition() {
        this.textPosition = this.iTextPositionX < 0 ? new TextPosition(){

            @Override
            public int getTextPosition() {
                return Text_Static.this.getWidthE() / 2 - Text_Static.this.iTextWidth / 2;
            }
        } : new TextPosition(){

            @Override
            public int getTextPosition() {
                return Text_Static.this.iTextPositionX;
            }
        };
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + this.textPosition.getTextPosition() + iTranslateX, this.getPosY() + (this.getHeightE() - CFG.TEXT_HEIGHT_DEFAULT) / 2 + iTranslateY, this.getColor(isActive));
    }

    protected Color getColor(boolean isActive) {
        return isActive ? new Color(0.56f, 0.56f, 0.56f, 1.0f) : (this.getIsClickable() ? (this.getIsHovered() ? new Color(0.68f, 0.68f, 0.68f, 1.0f) : new Color(0.82f, 0.82f, 0.82f, 1.0f)) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
    }

    @Override
    public final String getTextE() {
        return this.sText;
    }

    @Override
    public void setTextE(String sText) {
        this.sText = sText;
        try {
            GlyphLayout glyphLayout = new GlyphLayout();
            glyphLayout.setText(CFG.fontMain.get(this.fontID), sText);
            this.iTextWidth = (int)glyphLayout.width;
            this.iTextHeight = (int)glyphLayout.height;
            if (super.getWidthE() < this.iTextWidth) {
                this.setWidthE(this.iTextWidth);
            }
            if (this.getHeightE() < this.iTextHeight) {
                this.setHeightE(this.iTextHeight);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    @Override
    public int getTextWidthU() {
        return this.iTextWidth;
    }

    @Override
    public int getTextHeight() {
        return this.iTextHeight;
    }

    @Override
    public int getCurr() {
        return this.iCurrent;
    }

    static interface TextPosition {
        public int getTextPosition();
    }
}

