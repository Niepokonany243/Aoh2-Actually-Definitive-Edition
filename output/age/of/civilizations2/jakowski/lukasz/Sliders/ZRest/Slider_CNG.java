/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Sliders.ZRest;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Sliders.ZRest.Slider_BG;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Slider_CNG
extends Slider_BG {
    public Slider_CNG(int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        super(iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
    }
    public Slider_CNG(int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        super(iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
    }

    public Slider_CNG(String sText, int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        super(sText, iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
    }
    public Slider_CNG(String sText, int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        super(sText, iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        if (CFG.settingsGD.BETTER_UI) {
            BetterUI_Manager.drawBetterSlider(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), this.iCurrentPosX, this.iDifference_CurrentPosX, this.getIsHovered(), isActive, this.getColorLEFT());
            this.drawSliderText(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
            oSB.setColor(Color.WHITE);
            return;
        }
        if (isActive) {
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.4f));
        } else {
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.2f));
        }
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() - CFG.PADD * 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - CFG.PADD + iTranslateY, this.getWidthE() + CFG.PADD * 4, this.getHeightE() + CFG.PADD * 2);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() - CFG.PADD * 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() - CFG.PADD + iTranslateY, this.getWidthE() + CFG.PADD * 4, this.getHeightE() / 4);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() - CFG.PADD * 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + CFG.PADD + this.getHeightE() - this.getHeightE() / 4 + iTranslateY, this.getWidthE() + CFG.PADD * 4, this.getHeightE() / 4, false, true);
        oSB.setColor(new Color(0.20392157f, 0.23921569f, 0.26666668f, 0.35f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() - CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() + CFG.PADD - IMGManager.getIMG(Images.pix255).getHeight() * 2 + iTranslateY, this.getWidthE() + CFG.PADD * 4, 1);
        oSB.setColor(new Color(0.20392157f, 0.23921569f, 0.26666668f, 0.65f));
        IMGManager.getIMG(Images.line32).drawO(oSB, this.getPosXE() - CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() + CFG.PADD - IMGManager.getIMG(Images.line32).getHeight() * 2 + iTranslateY, this.getWidthE() + CFG.PADD * 4, 1);
        oSB.setColor(Color.WHITE);
        this.drawSliderBG(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
        this.drawSliderText(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
        super.drawSliderBorder(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawSliderBG(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        this.drawSliderBG_UpdateAnimation();
        oSB.setColor(CFG.COLOR_GRADIENT_DARK_BLUE);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(0.05f, 0.07f, 0.12f, 1.0f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, false);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, true, true);
        oSB.setColor(this.getColorLEFT());
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - 1 + iTranslateY, this.iCurrentPosX + this.iDifference_CurrentPosX, this.getHeightE());
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.iCurrentPosX + this.iDifference_CurrentPosX + iTranslateX, this.getPosY() - 1 + iTranslateY, 1, this.getHeightE());
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawSliderText(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getDrawText(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColor(isActive));
    }

    public Color getColor(boolean isActive) {
        return isActive ? new Color(0.66f, 0.658f, 0.665f, 1.0f) : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_MENU_TEXT_HOVERED : CFG.COLOR_BUTTON_MENU_TEXT) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
    }
}

