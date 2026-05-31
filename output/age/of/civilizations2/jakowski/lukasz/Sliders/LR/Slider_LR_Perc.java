
package age.of.civilizations2.jakowski.lukasz.Sliders.LR;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Sliders.LR.Slider_LR;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Slider_LR_Perc
extends Slider_LR {
    public Slider_LR_Perc(int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        super("", iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
    }

    public Slider_LR_Perc(int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        this(iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
    }

    public Slider_LR_Perc(String sText, int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        super(sText, iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
    }

    public Slider_LR_Perc(String sText, int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        this(sText, iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
    }

    @Override
    public void drawSliderBG(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        this.drawSliderBG_UpdateAnimation();
        oSB.setColor(this.getColorLEFT().r, this.getColorLEFT().g, this.getColorLEFT().b, 0.7f);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - 1 + iTranslateY, this.iCurrentPosX + this.iDifference_CurrentPosX, this.getHeightE());
        oSB.setColor(this.getColorLEFT().r, this.getColorLEFT().g, this.getColorLEFT().b, 0.7f);
        IMGManager.getIMG(Images.sliderArmy).draw2(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.iCurrentPosX + this.iDifference_CurrentPosX, this.getHeightE());
        oSB.setColor(this.getColorLEFT().r * 1.3f, this.getColorLEFT().g * 1.3f, this.getColorLEFT().b * 1.3f, 0.5f);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.iCurrentPosX + this.iDifference_CurrentPosX, this.getHeightE(), false, false);
        oSB.setColor(this.getColorRIGHT().r, this.getColorRIGHT().g, this.getColorRIGHT().b, 0.6f);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.iCurrentPosX + this.iDifference_CurrentPosX + iTranslateX, this.getPosY() - 1 + iTranslateY, this.getWidthE() - this.iCurrentPosX - this.iDifference_CurrentPosX, this.getHeightE());
        oSB.setColor(this.getColorRIGHT().r, this.getColorRIGHT().g, this.getColorRIGHT().b, 0.6f);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.iCurrentPosX + this.iDifference_CurrentPosX + iTranslateX, this.getPosY() - 1 + iTranslateY, this.getWidthE() - this.iCurrentPosX - this.iDifference_CurrentPosX, this.getHeightE(), true, false);
        oSB.setColor(Color.WHITE);
    }
}
