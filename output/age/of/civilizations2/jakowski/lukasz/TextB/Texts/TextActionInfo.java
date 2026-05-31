/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextActionInfo
extends Text {
    public static final float ALPHA = 0.9f;
    public static final float ALPHA_LINE = 0.75f;
    public static final float FONT_SCALE = 0.8f;

    public TextActionInfo(String sText, int iPosX, int iPosY) {
        super(sText, CFG.PADD, iPosX, iPosY, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2);
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
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    @Override
    public Color getColor(boolean isActive) {
        return isActive ? CFG.COLOR_NEUTRAL : (this.getIsClickable() ? CFG.COLOR_NEUTRAL2 : new Color(0.78f, 0.78f, 0.78f, 0.7f));
    }
}

