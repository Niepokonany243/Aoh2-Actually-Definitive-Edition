
package age.of.civilizations2.jakowski.lukasz.Sliders.ZRest;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slider;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Slider_InGame
extends Slider {
    public Slider_InGame(int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        super.initSlider("", iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
    }

    public Slider_InGame(int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        super.initSlider("", iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
    }

    public Slider_InGame(String sText, int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        super.initSlider(sText, iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
    }

    public Slider_InGame(String sText, int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        super.initSlider(sText, iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
    }

    @Override
    public void drawSliderBG(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        if (CFG.settingsGD.BETTER_UI) {
            BetterUI_Manager.drawBetterSlider(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.sliderHeight() + iTranslateY, this.getWidthE(), this.sliderHeight(), this.iCurrentPosX, this.iDifference_CurrentPosX, this.getIsHovered(), isActive, this.getColorLEFT());
            return;
        }
        this.drawSliderBG_UpdateAnimation();
        oSB.setColor(this.getColorLEFT().r, this.getColorLEFT().g, this.getColorLEFT().b, 0.7f);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.sliderHeight() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.iCurrentPosX + this.iDifference_CurrentPosX, this.sliderHeight());
        oSB.setColor(this.getColorLEFT().r * 1.3f, this.getColorLEFT().g * 1.3f, this.getColorLEFT().b * 1.3f, 1.0f);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.sliderHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.iCurrentPosX + this.iDifference_CurrentPosX, this.sliderHeight());
        oSB.setColor(this.getColorRIGHT().r, this.getColorRIGHT().g, this.getColorRIGHT().b, 0.6f);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.iCurrentPosX + this.iDifference_CurrentPosX + iTranslateX, this.getPosY() + this.getHeightE() - this.sliderHeight() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE() - this.iCurrentPosX - this.iDifference_CurrentPosX, this.sliderHeight());
        oSB.setColor(this.getColorRIGHT().r, this.getColorRIGHT().g, this.getColorRIGHT().b, 0.6f);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.iCurrentPosX + this.iDifference_CurrentPosX + iTranslateX, this.getPosY() + this.getHeightE() - this.sliderHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() - this.iCurrentPosX - this.iDifference_CurrentPosX, this.sliderHeight(), true, false);
    }

    @Override
    public void drawSliderBorder(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        if (CFG.settingsGD.BETTER_UI) return;
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, this.getIsClickable() ? 1.0f : 0.5f));
        IMGManager.getIMG(Images.slider_rect_edge).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.sliderHeight() - IMGManager.getIMG(Images.slider_rect_edge).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.slider_rect_edge).getWidth(), this.sliderHeight() - IMGManager.getIMG(Images.slider_rect_edge).getHeight());
        IMGManager.getIMG(Images.slider_rect_edge).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.slider_rect_edge).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() - this.sliderHeight() - IMGManager.getIMG(Images.slider_rect_edge).getHeight() + iTranslateY, IMGManager.getIMG(Images.slider_rect_edge).getWidth(), this.sliderHeight() - IMGManager.getIMG(Images.slider_rect_edge).getHeight(), true, false);
        IMGManager.getIMG(Images.slider_rect_edge).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.slider_rect_edge).getHeight() * 2 + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.slider_rect_edge).getWidth(), IMGManager.getIMG(Images.slider_rect_edge).getHeight(), false, true);
        IMGManager.getIMG(Images.slider_rect_edge).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.slider_rect_edge).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.slider_rect_edge).getHeight() * 2 + iTranslateY, IMGManager.getIMG(Images.slider_rect_edge).getWidth(), IMGManager.getIMG(Images.slider_rect_edge).getHeight(), true, true);
    }

    @Override
    public void drawSliderText(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        if (CFG.settingsGD.BETTER_UI) {
            Color primary = BetterUI_Manager.getPrimaryColor();
            Renderer.drawText(oSB, this.fontID, this.getDrawText(), this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 - this.getTextHeight() + iTranslateY, Color.WHITE);
            Renderer.drawText(oSB, this.fontID, this.getDrawText(), this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 - this.getTextHeight() + iTranslateY, primary);
            return;
        }
        Renderer.drawText(oSB, this.fontID, this.getDrawText(), this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 - this.getTextHeight() + iTranslateY, new Color(0.945f, 0.945f, 0.945f, 1.0f));
        Renderer.drawText(oSB, this.fontID, this.getDrawText(), this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 - this.getTextHeight() + iTranslateY, new Color(this.getColorLEFT().r * 1.85f, this.getColorLEFT().g * 1.85f, this.getColorLEFT().b * 2.4f, 1.0f));
    }

    private final int sliderHeight() {
        return CFG.PADD * 4 + CFG.TEXT_HEIGHT_DEFAULT;
    }
}

