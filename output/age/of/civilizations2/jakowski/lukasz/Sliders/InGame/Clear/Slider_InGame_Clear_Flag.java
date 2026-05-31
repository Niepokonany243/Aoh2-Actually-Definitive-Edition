
package age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Clear;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slider;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Slider_InGame_Clear_Flag
extends Slider {
    public int iCivID;
    public static final Color bgColor = new Color(0.0f, 0.0f, 0.0f, 0.15f);

    public Slider_InGame_Clear_Flag(int iCivID, String sText, int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        this.initSlider(sText, iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
        this.iCivID = iCivID;
    }

    public Slider_InGame_Clear_Flag(int iCivID, String sText, int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        this(iCivID, sText, iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        this.drawSliderBG_UpdateAnimation();
        oSB.setColor(bgColor);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - 1 + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(this.getColorLEFT().r, this.getColorLEFT().g, this.getColorLEFT().b, 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - this.getSliderHeight() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), this.getSliderHeight());
        oSB.setColor(new Color(this.getColorLEFT().r, this.getColorLEFT().g, this.getColorLEFT().b, 0.9f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - this.getSliderHeight() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.iCurrentPosX + this.iDifference_CurrentPosX, this.getSliderHeight());
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - this.getSliderHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.iCurrentPosX + this.iDifference_CurrentPosX, this.getSliderHeight());
        oSB.setColor(new Color(CFG.COLOR_NEW_GAME_EDGE_LINE.r, CFG.COLOR_NEW_GAME_EDGE_LINE.g, CFG.COLOR_NEW_GAME_EDGE_LINE.b, 0.8f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - this.getSliderHeight() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.9f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.iCurrentPosX + this.iDifference_CurrentPosX + iTranslateX, this.getPosY() + this.getHeightE() + 1 - this.getSliderHeight() - CFG.PADD - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getSliderHeight() - 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - this.getSliderHeight() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD + 1 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD, false, true);
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + (this.getHeightE() - this.getSliderHeight() - CFG.PADD) / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        CFG.core.getCiv(this.iCivID).getFlagC().drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + (this.getHeightE() - this.getSliderHeight() - CFG.PADD) / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD * 2 + CFG.CIV_FLAG_WIDTH + iTranslateX, this.getPosY() + (this.getHeightE() - this.getSliderHeight() - CFG.PADD) / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2 + iTranslateY, this.getColor(isActive));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getDrawText(), this.getPosXE() + this.getWidthE() - CFG.PADD - this.getTextWidthU() + iTranslateX, this.getPosY() + (this.getHeightE() - this.getSliderHeight() - CFG.PADD) / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2 + iTranslateY, this.getCurr() == 0L ? CFG.COLOR_NEUTRAL : CFG.COLOR_TEXT_NUM_OF_PROVINCES);
    }

    public static final float getImageScale(int iImageID) {
        return Math.min(1.0f, (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(iImageID).getHeight());
    }

    @Override
    public Color getColorLEFT() {
        if (this.getCurr() > 0L) {
            return Colors.COLOR_TEXT_MODIFIER_POSITIVE;
        }
        if (this.getCurr() < 0L) {
            return Colors.COLOR_TEXT_MODIFIER_NEGATIVE;
        }
        return CFG.COLOR_SLIDER_LEFT_BG;
    }

    public Color getColor(boolean isActive) {
        return isActive ? new Color(0.71f, 0.71f, 0.71f, 1.0f) : (this.getIsHovered() ? new Color(0.82f, 0.82f, 0.82f, 1.0f) : Color.WHITE);
    }

    @Override
    public String getDrawText() {
        return (this.getCurr() > 0L ? "+" : "") + this.getCurr();
    }

    public int getSliderHeight() {
        return CFG.PADD * 2;
    }
}
