/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Sliders.InGame;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slider;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Slider_InGame
extends Slider {
    public static final Color bgColor = new Color(0.0f, 0.0f, 0.0f, 0.3f);
    public String sSpendings;
    public int iSpendingsWidth = 0;
    public boolean drawSpendings;

    public Slider_InGame(String sText, int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        this.initSlider(sText, iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
        this.setCurr(this.getCurr());
    }

    public Slider_InGame(String sText, int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        this.initSlider(sText, iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
        this.setCurr(this.getCurr());
    }

    public Slider_InGame(String sText, int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent, boolean clickable) {
        this.initSlider(sText, iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
        this.setCurr(this.getCurr());
        this.setClickable(clickable);
    }

    public Slider_InGame(String sText, int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent, boolean clickable) {
        this.initSlider(sText, iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
        this.setCurr(this.getCurr());
        this.setClickable(clickable);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        this.drawSliderBG_UpdateAnimation();
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.25f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, this.getHeightE());
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, this.getHeightE() * 3 / 5, false, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.275f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 4, this.getHeightE(), false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() - CFG.PADD + this.getWidthE() + CFG.PADD * 2 - this.getWidthE() / 4 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 4, this.getHeightE(), true, false);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.65f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() + CFG.PADD * 2, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.175f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - this.getSliderHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getSliderHeight());
        oSB.setColor(new Color(this.getColorLEFT().r, this.getColorLEFT().g, this.getColorLEFT().b, this.getColorLEFT().a));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - this.getSliderHeight() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.iCurrentPosX + this.iDifference_CurrentPosX, this.getSliderHeight());
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - this.getSliderHeight() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.iCurrentPosX + this.iDifference_CurrentPosX, this.getSliderHeight());
        oSB.setColor(new Color(this.getColorLEFT().r, this.getColorLEFT().g, this.getColorLEFT().b, this.getColorLEFT().a * 0.92f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - this.getSliderHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.iCurrentPosX + this.iDifference_CurrentPosX, this.getSliderHeight());
        for (int i = 1; i < 10; ++i) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.1f));
            IMGManager.getIMG(Images.line32Vertical).draw2O(oSB, this.getPosXE() + this.getWidthE() / 10 * i + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - this.getSliderHeight() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getSliderHeight());
        }
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.iCurrentPosX + this.iDifference_CurrentPosX + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - this.getSliderHeight() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getSliderHeight());
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - this.getSliderHeight() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - CFG.PADD + 1 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD, false, true);
        if (this.getIsClickable()) {
            oSB.setColor(new Color(CFG.COLOR_NEW_GAME_EDGE_LINE.r, CFG.COLOR_NEW_GAME_EDGE_LINE.g, CFG.COLOR_NEW_GAME_EDGE_LINE.b, 0.7f));
        } else {
            oSB.setColor(new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.775f));
        }
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - this.getSliderHeight() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.9f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.iCurrentPosX + this.iDifference_CurrentPosX + iTranslateX, this.getPosY() + this.getHeightE() + 1 - this.getSliderHeight() - CFG.PADD - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getSliderHeight() - 1);
        if (this.iMinMarker >= 0L) {
            oSB.setColor(new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.5f));
            int minMarkerPosX = (int)((double)(this.iMinMarker - this.iMin) * 100.0 / (double)Math.max(1L, this.iMax - this.iMin) * (double)this.getWidthE() / 100.0);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + minMarkerPosX + iTranslateX, this.getPosY() + this.getHeightE() - this.getSliderHeight() - CFG.PADD - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getSliderHeight());
        }
        if (isActive) {
            oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.045f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - this.getSliderHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        }
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - this.getSliderHeight() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - this.getSliderHeight() - 1 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD + 1 - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - this.getSliderHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 8, 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 8, 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 8 + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - this.getSliderHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 8, 1, true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 8 + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 8, 1, true, false);
        oSB.setColor(Color.WHITE);
        this.drawTextLeft(oSB, iTranslateX, iTranslateY, isActive);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getDrawText(), this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 - this.getSliderHeight() - CFG.TEXT_HEIGHT_DEFAULT + iTranslateY, CFG.COLOR_TEXT_CIV_INFO_TITLE);
        if (this.drawSpendings) {
            oSB.setColor(new Color(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.r, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.g, CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS.b, 0.85f));
            IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 3 - this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 - this.getSliderHeight() - this.getTextHeight() - IMGManager.getIMG(Images.line32Vertical).getHeight() + iTranslateY, 1, this.getTextHeight());
            oSB.setColor(Color.WHITE);
            Renderer.drawTextWithShadow(oSB, this.fontID, this.sSpendings, this.getPosXE() + this.getWidthE() - CFG.PADD * 4 - this.iSpendingsWidth - this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 - this.getSliderHeight() - this.getTextHeight() + iTranslateY, CFG.COLOR_NEUTRAL2);
            IMGManager.getIMG(Images.topGold()).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 5 - this.iSpendingsWidth - this.getTextWidthU() - (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(1.0f, Images.topGold())) + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 - this.getSliderHeight() - (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(1.0f, Images.topGold())) - IMGManager.getIMG(Images.topGold()).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.topGold()).getWidth() * this.getImageScale(1.0f, Images.topGold())), (int)((float)IMGManager.getIMG(Images.topGold()).getHeight() * this.getImageScale(1.0f, Images.topGold())));
        }
    }

    public void drawTextLeft(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 - this.getSliderHeight() - CFG.TEXT_HEIGHT_DEFAULT + iTranslateY, this.getColor(isActive));
    }

    @Override
    public Color getColorLEFT() {
        return new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.75f);
    }

    public Color getColor(boolean isActive) {
        return isActive ? new Color(0.71f, 0.71f, 0.71f, 1.0f) : (this.getIsHovered() ? new Color(0.82f, 0.82f, 0.82f, 1.0f) : Color.WHITE);
    }

    @Override
    public String getDrawText() {
        return CFG.getNumberWthSpaces("" + this.getCurrLong());
    }

    public int getSliderHeight() {
        return CFG.PADD * 3;
    }

    @Override
    public void setCurr(long nCurrent) {
        super.setCurr(nCurrent);
        int tempSpend = (int)CFG.gameUpdate.getResearchSpending(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).iBudget);
        this.drawSpendings = tempSpend != 0;
        this.sSpendings = CFG.getNumberWthSpaces("" + tempSpend);
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sSpendings);
        this.iSpendingsWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public void setCurr(int nCurrent) {
        this.setCurr((long)nCurrent);
    }

    public final float getImageScale(float fScale, int nImageID) {
        return (float)this.getTextHeight() * fScale / (float)IMGManager.getIMG(nImageID).getHeight();
    }
}

