
package age.of.civilizations2.jakowski.lukasz.Sliders.LR;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Sliders.LR.Slider_LR_PercOver;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Slider_LR_PercOver_Regroup
extends Slider_LR_PercOver {
    public String sProvinces = CFG.lang.get("Provinces") + ": ";
    public int provincesW = 0;
    public int provincesH = 0;

    public Slider_LR_PercOver_Regroup(int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        super(iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
        this.updateProvinces();
    }

    public Slider_LR_PercOver_Regroup(int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        this(iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
    }

    public Slider_LR_PercOver_Regroup(String sText, int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        super(sText, iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
        this.updateProvinces();
    }

    public Slider_LR_PercOver_Regroup(String sText, int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
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
        oSB.setColor(this.getColorRIGHT().r, this.getColorRIGHT().g, this.getColorRIGHT().b, 0.2f);
        IMGManager.getIMG(Images.sliderArmy).draw2(oSB, this.getPosXE() + this.iCurrentPosX + this.iDifference_CurrentPosX + iTranslateX, this.getPosY() - 1 + iTranslateY, this.getWidthE() - this.iCurrentPosX - this.iDifference_CurrentPosX, this.getHeightE(), this.iCurrentPosX + this.iDifference_CurrentPosX);
        oSB.setColor(this.getColorRIGHT().r, this.getColorRIGHT().g, this.getColorRIGHT().b, 0.6f);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.iCurrentPosX + this.iDifference_CurrentPosX + iTranslateX, this.getPosY() - 1 + iTranslateY, this.getWidthE() - this.iCurrentPosX - this.iDifference_CurrentPosX, this.getHeightE(), true, false);
        for (int i = 1; i < 10; ++i) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.04f));
            IMGManager.getIMG(Images.line32Vertical).draw2O(oSB, this.getPosXE() + this.getWidthE() / 10 * i + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getHeightE());
            oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.8f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 10 * i + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, 1, Math.max(CFG.PADD, this.getHeightE() / 6));
        }
        oSB.setColor(Color.WHITE);
    }

    public final void updateProvinces() {
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sProvinces);
        this.provincesW = (int)CFG.glyphLay.width;
        this.provincesH = (int)CFG.glyphLay.height;
    }
}
