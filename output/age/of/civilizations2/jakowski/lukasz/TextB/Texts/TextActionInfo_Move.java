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

public class TextActionInfo_Move
extends TextActionInfo {
    public TextActionInfo_Move(String sText, int iPosX, int iPosY) {
        super(sText, iPosX, iPosY);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        oSB.setColor(new com.badlogic.gdx.graphics.Color(0.0f, 0.0f, 0.0f, 0.9f));
        IMGManager.getIMG(Images.civNameBG).draw2O(oSB, this.getPosXE() + (iTranslateX -= (int)((float)this.getWidthE() - (float)this.getWidthE() * CFG.fMOVE_MENU_PERCENTAGE / 100.0f)), this.getPosY() - IMGManager.getIMG(Images.civNameBG).getHeight() + iTranslateY, (int)((float)this.getWidthE() * 0.8f) + CFG.PADD * 3, this.getHeightE() - IMGManager.getIMG(Images.civNameBG).getHeight(), true, false);
        IMGManager.getIMG(Images.civNameBG).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.civNameBG).getHeight() - IMGManager.getIMG(Images.civNameBG).getHeight() + iTranslateY, (int)((float)this.getWidthE() * 0.8f) + CFG.PADD * 3, IMGManager.getIMG(Images.civNameBG).getHeight(), true, true);
        oSB.setColor(new com.badlogic.gdx.graphics.Color(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.r, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.g, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.b, 0.75f));
        IMGManager.getIMG(Images.civNameBG).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - 1 - IMGManager.getIMG(Images.civNameBG).getHeight() + iTranslateY, (int)((float)this.getWidthE() * 0.8f) + CFG.PADD * 3, 1, true, false);
        IMGManager.getIMG(Images.civNameBG).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.civNameBG).getHeight() + iTranslateY, (int)((float)this.getWidthE() * 0.8f) + CFG.PADD * 3, 1, true, false);
        oSB.setColor(com.badlogic.gdx.graphics.Color.WHITE);
        CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + (int)(((float)this.getHeightE() - (float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()) / 2.0f) - CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getFlagC().getHeight() + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + (int)(((float)this.getHeightE() - (float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()) / 2.0f) - IMGManager.getIMG(Images.flagRectSmall).getHeight() + iTranslateY, (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
        CFG.fontMain.get(0).getData().setScale(0.8f);
        CFG.drawTextDefaultWithShadow(oSB, this.sText, this.getPosXE() + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) + CFG.PADD * 2 + iTranslateX, this.getPosY() + (int)(((float)this.getHeightE() - (float)this.iTextHeight * 0.8f) / 2.0f) + iTranslateY, this.getColor(isActive));
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    private final float getImageScale() {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)CFG.CIV_FLAG_HEIGHT;
    }

    @Override
    public int getWidthE() {
        return super.getWidthE() + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()) + CFG.PADD * 2;
    }

    @Override
    public Color getColor(boolean isActive) {
        return isActive ? new Color(0.56f, 0.56f, 0.56f, 1.0f) : (this.getIsClickable() ? CFG.COLOR_NEUTRAL2 : new Color(0.78f, 0.78f, 0.78f, 0.7f));
    }
}

