
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextActionInfo;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextActionInfo_Turns
extends TextActionInfo {
    public TextActionInfo_Turns(String sText, int iPosX, int iPosY) {
        super(sText, iPosX, iPosY);
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
        IMGManager.getIMG(Images.time).draw(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + (int)(((float)this.getHeightE() - (float)IMGManager.getIMG(Images.time).getHeight() * this.getImageScale()) / 2.0f) + iTranslateY, (int)((float)IMGManager.getIMG(Images.time).getWidth() * this.getImageScale()), (int)((float)IMGManager.getIMG(Images.time).getHeight() * this.getImageScale()));
        CFG.fontMain.get(0).getData().setScale(0.8f);
        CFG.drawTextDefaultWithShadow(oSB, this.sText, this.getPosXE() + (int)((float)IMGManager.getIMG(Images.time).getWidth() * this.getImageScale()) + CFG.PADD * 2 + iTranslateX, this.getPosY() + (int)(((float)this.getHeightE() - (float)this.iTextHeight * 0.8f) / 2.0f) + iTranslateY, this.getColor(isActive));
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    private final float getImageScale() {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(Images.time).getHeight();
    }

    @Override
    public int getWidthE() {
        return super.getWidthE() + (int)((float)IMGManager.getIMG(Images.time).getWidth() * this.getImageScale()) + CFG.PADD * 2;
    }

    @Override
    public Color getColor(boolean isActive) {
        return isActive ? CFG.COLOR_NEUTRAL : (this.getIsClickable() ? Color.WHITE : new Color(0.78f, 0.78f, 0.78f, 0.7f));
    }
}

