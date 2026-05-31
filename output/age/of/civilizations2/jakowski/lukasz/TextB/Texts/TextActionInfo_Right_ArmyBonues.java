/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextActionInfo_Right;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextActionInfo_Right_ArmyBonues
extends TextActionInfo_Right {
    private String sValue;
    private int iValueWidth = 0;

    public TextActionInfo_Right_ArmyBonues(String sText, String sValue, int iPosX, int iPosY) {
        super(sText, iPosX, iPosY);
        this.sValue = sValue;
        CFG.glyphLay.setText(CFG.fontMain.get(0), sValue);
        this.iValueWidth = (int)(CFG.glyphLay.width * 0.8f);
        this.setPosX(CFG.GAMEWIDTH - this.getWidthE());
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.9f));
        IMGManager.getIMG(Images.civNameBG).draw2O(oSB, this.getPosXE() + (iTranslateX += (int)((float)this.getWidthE() - (float)this.getWidthE() * CFG.fMOVE_MENU_PERCENTAGE / 100.0f)), this.getPosY() - IMGManager.getIMG(Images.civNameBG).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - IMGManager.getIMG(Images.civNameBG).getHeight(), false, false);
        IMGManager.getIMG(Images.civNameBG).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.civNameBG).getHeight() - IMGManager.getIMG(Images.civNameBG).getHeight() + iTranslateY, this.getWidthE(), IMGManager.getIMG(Images.civNameBG).getHeight(), false, true);
        oSB.setColor(new Color(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.r, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.g, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.b, 0.75f));
        IMGManager.getIMG(Images.civNameBG).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - 1 - IMGManager.getIMG(Images.civNameBG).getHeight() + iTranslateY, this.getWidthE(), 1, false, false);
        IMGManager.getIMG(Images.civNameBG).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.civNameBG).getHeight() + iTranslateY, this.getWidthE(), 1, false, false);
        oSB.setColor(Color.WHITE);
        CFG.fontMain.get(0).getData().setScale(0.8f);
        CFG.drawTextDefaultWithShadow(oSB, this.sText, this.getPosXE() + this.getWidthE() - (int)((float)this.getTextWidthU() * 0.8f) - this.iValueWidth - CFG.PADD + iTranslateX, this.getPosY() + (int)(((float)this.getHeightE() - (float)this.iTextHeight * 0.8f) / 2.0f) + iTranslateY, this.getColor(isActive));
        CFG.drawTextDefaultWithShadow(oSB, this.sValue, this.getPosXE() + this.getWidthE() - this.iValueWidth - CFG.PADD + iTranslateX, this.getPosY() + (int)(((float)this.getHeightE() - (float)this.iTextHeight * 0.8f) / 2.0f) + iTranslateY, this.getColorValue());
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    @Override
    public int getWidthE() {
        return super.getWidthE() + this.iValueWidth;
    }

    @Override
    public Color getColor(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_CIV_NAME_ACTIVE : (this.getIsHovered() ? CFG.COLOR_TEXT_CIV_NAME_HOVERED : CFG.COLOR_TEXT_CIV_NAME);
    }

    public Color getColorValue() {
        return CFG.COLOR_POSITIVE;
    }
}

