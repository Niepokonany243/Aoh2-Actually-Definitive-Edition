
package age.of.civilizations2.jakowski.lukasz.Sliders.ZRest;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slider;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Slider_BG_ZeroInMiddle
extends Slider {
    public Slider_BG_ZeroInMiddle(int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        this.initSlider("", iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
    }

    public Slider_BG_ZeroInMiddle(int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        this(iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        this.drawSliderBG_UpdateAnimation();
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.25f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - 1 + iTranslateY, this.getWidthE(), this.getHeightE());
        if (this.getCurr() > 0L) {
            oSB.setColor(this.getColorLEFT().r, this.getColorLEFT().g, this.getColorLEFT().b, 0.7f);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 + iTranslateX, this.getPosY() - 1 + iTranslateY, this.iCurrentPosX + this.iDifference_CurrentPosX - this.getWidthE() / 2, this.getHeightE());
            oSB.setColor(this.getColorLEFT().r * 1.3f, this.getColorLEFT().g * 1.3f, this.getColorLEFT().b * 1.3f, 1.0f);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.iCurrentPosX + this.iDifference_CurrentPosX - this.getWidthE() / 2, this.getHeightE(), false, false);
        } else if (this.getCurr() < 0L) {
            oSB.setColor(this.getColorRIGHT().r, this.getColorRIGHT().g, this.getColorRIGHT().b, 0.7f);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.iCurrentPosX + this.iDifference_CurrentPosX + iTranslateX, this.getPosY() - 1 + iTranslateY, this.getWidthE() / 2 - (this.iCurrentPosX + this.iDifference_CurrentPosX), this.getHeightE());
            oSB.setColor(this.getColorRIGHT().r * 1.3f, this.getColorRIGHT().g * 1.3f, this.getColorRIGHT().b * 1.3f, 1.0f);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.iCurrentPosX + this.iDifference_CurrentPosX + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2 - (this.iCurrentPosX + this.iDifference_CurrentPosX), this.getHeightE(), true, false);
        }
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.7f);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - 1 + iTranslateX, this.getPosY() - 1 + iTranslateY, 2, this.getHeightE());
        this.drawSliderText(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
    }

    @Override
    public Color getColorLEFT() {
        return CFG.COLOR_SLIDER_LEFT_BG;
    }

    @Override
    public Color getColorRIGHT() {
        return CFG.COLOR_SLIDER_RIGHT_BG;
    }
}
