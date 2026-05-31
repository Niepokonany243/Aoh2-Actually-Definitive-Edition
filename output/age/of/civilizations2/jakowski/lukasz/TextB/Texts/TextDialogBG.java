/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextDialogBG
extends Text {
    public TextDialogBG(String sText, int iPosX, int iPosY) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setTextE(sText);
        this.textPosition = new Text.TextPosition(){

            @Override
            public int getTextPosition() {
                return 0;
            }
        };
    }

    public TextDialogBG(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT;
        this.iTextPositionX = iTextPositionX;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setWidthE(iWidth);
        this.setHeightE(iHeight);
        this.setTextE(sText);
        this.updateTextPosition();
    }

    public TextDialogBG(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, int fontID) {
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT;
        this.iTextPositionX = iTextPositionX;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setWidthE(iWidth);
        this.setHeightE(iHeight);
        this.setTextE(sText);
        this.updateTextPosition();
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
    }
}

