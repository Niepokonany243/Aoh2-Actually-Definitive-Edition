/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.NewGame;

import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_InGameBox;
import age.of.civilizations2.jakowski.lukasz.CFG;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_In_Game_Box_Special
extends Button_InGameBox {
    public Button_In_Game_Box_Special(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, isClickable);
    }

    public Button_In_Game_Box_Special(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive) {
            CFG.fontMain.get(0).getData().setScale(0.8f);
            CFG.drawTextDefault(oSB, this.getTextToDrawElem(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - (int)((float)this.getTextWidthU() * 0.8f / 2.0f) : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.8f / 2.0f) + iTranslateY, this.getColorE(isActive));
            CFG.fontMain.get(0).getData().setScale(1.0f);
        } else {
            CFG.fontMain.get(0).getData().setScale(0.8f);
            CFG.drawTextDefault(oSB, this.getTextToDrawElem(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - (int)((float)this.getTextWidthU() * 0.8f / 2.0f) : this.getTextPosElem()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.8f / 2.0f) + iTranslateY, this.getColorE(isActive));
            CFG.fontMain.get(0).getData().setScale(1.0f);
        }
    }
}

