/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextActionInfo;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextActionInfo_ArmyBonus
extends TextActionInfo {
    private String sValue;
    private int iValueWidth = 0;

    public TextActionInfo_ArmyBonus(String sText, String sValue, int iPosX, int iPosY) {
        super(sText, iPosX, iPosY);
        this.sValue = sValue;
        CFG.glyphLay.setText(CFG.fontMain.get(0), sValue);
        this.iValueWidth = (int)(CFG.glyphLay.width * 0.8f);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.9f));
        IMGManager.getIMG(Images.civNameBG).draw2O(oSB, this.getPosXE() + (iTranslateX -= (int)((float)this.getWidthE() - (float)this.getWidthE() * CFG.fMOVE_MENU_PERCENTAGE / 100.0f)), this.getPosY() - IMGManager.getIMG(Images.civNameBG).getHeight() + iTranslateY, (int)((float)this.getWidthE() * 0.8f) + CFG.PADD * 3, this.getHeightE() - IMGManager.getIMG(Images.civNameBG).getHeight(), true, false);
        IMGManager.getIMG(Images.civNameBG).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.civNameBG).getHeight() - IMGManager.getIMG(Images.civNameBG).getHeight() + iTranslateY, (int)((float)this.getWidthE() * 0.8f) + CFG.PADD * 3, IMGManager.getIMG(Images.civNameBG).getHeight(), true, true);
        oSB.setColor(new Color(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.r, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.g, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.b, 0.75f));
        IMGManager.getIMG(Images.civNameBG).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - 1 - IMGManager.getIMG(Images.civNameBG).getHeight() + iTranslateY, (int)((float)this.getWidthE() * 0.8f) + CFG.PADD * 3, 1, true, false);
        IMGManager.getIMG(Images.civNameBG).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.civNameBG).getHeight() + iTranslateY, (int)((float)this.getWidthE() * 0.8f) + CFG.PADD * 3, 1, true, false);
        oSB.setColor(Color.WHITE);
        CFG.fontMain.get(0).getData().setScale(0.8f);
        CFG.drawTextDefaultWithShadow(oSB, this.sText, this.getPosXE() + this.textPosition.getTextPosition() + iTranslateX, this.getPosY() + (int)(((float)this.getHeightE() - (float)this.iTextHeight * 0.8f) / 2.0f) + iTranslateY, this.getColor(isActive));
        CFG.drawTextDefaultWithShadow(oSB, this.sValue, this.getPosXE() + this.textPosition.getTextPosition() + (int)((float)this.getTextWidthU() * 0.8f) + iTranslateX, this.getPosY() + (int)(((float)this.getHeightE() - (float)this.iTextHeight * 0.8f) / 2.0f) + iTranslateY, CFG.COLOR_POSITIVE);
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    @Override
    public int getWidthE() {
        return super.getWidthE() + this.iValueWidth + CFG.PADD;
    }

    @Override
    public Color getColor(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_CIV_NAME_ACTIVE : (this.getIsHovered() ? CFG.COLOR_TEXT_CIV_NAME_HOVERED : CFG.COLOR_TEXT_CIV_NAME);
    }
}

