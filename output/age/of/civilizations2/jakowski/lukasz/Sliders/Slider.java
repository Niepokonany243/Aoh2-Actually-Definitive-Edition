/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Sliders;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Slider
extends MenuElemUI {
    public long iMin;
    public long iMax;
    public long iMinMarker = -1L;
    public int iCurrentPosX = -1;
    private String sText = null;
    private long iCurrent;
    public int iTextWidth = -1;
    public int iTextHeight = -1;
    private long lTime = 0L;
    public int iDifference_CurrentPosX = 0;
    private int iDifference_PosX = 0;

    public Slider() {
    }

    public Slider(int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        this.initSlider("", iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
    }

    public Slider(int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        this.initSlider("", iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
    }

    public Slider(String sText, int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        this.initSlider(sText, iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
    }

    public Slider(String sText, int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        this.initSlider(sText, iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
    }

    public void initSlider(String sText, int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setWidthE(iWidth);
        this.setHeightE(iHeight);
        this.sText = sText;
        this.iMin = iMin;
        this.iMax = iMax;
        this.iCurrent = iCurrent;
        this.updateSlider(-1);
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.SLIDER;
    }

    public void initSlider(String sText, int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        this.initSlider(sText, iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        if (CFG.settingsGD.BETTER_UI) {
            BetterUI_Manager.drawBetterSlider(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), this.iCurrentPosX, this.iDifference_CurrentPosX, this.getIsHovered(), isActive, this.getColorLEFT());
            this.drawSliderText(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
            oSB.setColor(Color.WHITE);
            return;
        }
        this.drawSliderBG(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
        this.drawSliderText(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
        this.drawSliderBorder(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
        oSB.setColor(Color.WHITE);
    }

    public final void drawSliderBG_UpdateAnimation() {
        if (this.iDifference_CurrentPosX != 0) {
            if (this.lTime == 0L) {
                this.lTime = System.currentTimeMillis();
            }
            this.iDifference_CurrentPosX = this.iDifference_PosX - (int)((float)this.iDifference_PosX * ((float)(System.currentTimeMillis() - this.lTime) / 200.0f));
            CFG.setRenderO(true);
            if (System.currentTimeMillis() >= this.lTime + 200L) {
                this.iDifference_CurrentPosX = 0;
            }
        }
    }

    public void drawSliderBG(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        this.drawSliderBG_UpdateAnimation();
        oSB.setColor(this.getColorLEFT().r, this.getColorLEFT().g, this.getColorLEFT().b, 0.7f);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - 1 + iTranslateY, this.iCurrentPosX + this.iDifference_CurrentPosX, this.getHeightE());
        oSB.setColor(this.getColorLEFT().r * 1.3f, this.getColorLEFT().g * 1.3f, this.getColorLEFT().b * 1.3f, 1.0f);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.iCurrentPosX + this.iDifference_CurrentPosX, this.getHeightE(), false, false);
        oSB.setColor(this.getColorRIGHT().r, this.getColorRIGHT().g, this.getColorRIGHT().b, 0.6f);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + this.iCurrentPosX + this.iDifference_CurrentPosX + iTranslateX, this.getPosY() - 1 + iTranslateY, this.getWidthE() - this.iCurrentPosX - this.iDifference_CurrentPosX, this.getHeightE());
        oSB.setColor(this.getColorRIGHT().r, this.getColorRIGHT().g, this.getColorRIGHT().b, 0.6f);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.iCurrentPosX + this.iDifference_CurrentPosX + iTranslateX, this.getPosY() - 1 + iTranslateY, this.getWidthE() - this.iCurrentPosX - this.iDifference_CurrentPosX, this.getHeightE(), true, false);
    }

    public Color getColorLEFT() {
        return CFG.COLOR_SLIDER_LEFT_BG;
    }

    public Color getColorRIGHT() {
        return CFG.COLOR_SLIDER_RIGHT_BG;
    }

    public void drawSliderText(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getDrawText(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, new Color(0.945f, 0.945f, 0.945f, 1.0f));
    }

    public void drawSliderBorder(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        oSB.setColor(new Color(0.008f, 0.012f, 0.014f, 0.3f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + this.getHeightE() - this.getHeightE() / 4 + iTranslateY, this.getWidthE(), this.getHeightE() / 4, false, true);
        oSB.setColor(0.05f, 0.06f, 0.065f, 0.45f);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY + 1, this.getWidthE(), 1);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getHeightE() - 2 + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, this.getIsClickable() ? 1.0f : 0.5f));
        IMGManager.getIMG(Images.slider_rect_edge).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.slider_rect_edge).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.slider_rect_edge).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.slider_rect_edge).getHeight());
        IMGManager.getIMG(Images.slider_rect_edge).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.slider_rect_edge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.slider_rect_edge).getHeight() + iTranslateY, IMGManager.getIMG(Images.slider_rect_edge).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.slider_rect_edge).getHeight(), true, false);
        IMGManager.getIMG(Images.slider_rect_edge).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.slider_rect_edge).getHeight() * 2 + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.slider_rect_edge).getWidth(), IMGManager.getIMG(Images.slider_rect_edge).getHeight(), false, true);
        IMGManager.getIMG(Images.slider_rect_edge).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.slider_rect_edge).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.slider_rect_edge).getHeight() * 2 + iTranslateY, IMGManager.getIMG(Images.slider_rect_edge).getWidth(), IMGManager.getIMG(Images.slider_rect_edge).getHeight(), true, true);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.3f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getHeightE() - 1 + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(Color.WHITE);
    }

    public String getDrawText() {
        return this.sText + CFG.getNumber_SHORT_ARMY(this.iCurrent);
    }

    @Override
    public void updateSlider(int nX) {
        if (nX >= 0) {
            this.iCurrent = (long)((double)(nX -= this.getPosXE()) * 100.0 / (double)this.getWidthE() * (double)(this.iMax - this.iMin) / 100.0 + (double)this.iMin);
        }
        if (this.iCurrent < this.iMin) {
            this.iCurrent = this.iMin;
        } else if (this.iCurrent > this.iMax) {
            this.iCurrent = this.iMax;
        }
        this.updateCurrentPosX();
        this.updateTextWidth();
        this.iDifference_CurrentPosX = 0;
        this.iDifference_PosX = 0;
    }

    private final void updateCurrentPosX() {
        this.iCurrentPosX = (int)((double)(this.iCurrent - this.iMin) * 100.0 / (double)Math.max(1L, this.iMax - this.iMin) * (double)this.getWidthE() / 100.0);
    }

    public void updateTextWidth() {
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.getDrawText());
        this.iTextWidth = (int)CFG.glyphLay.width;
        this.iTextHeight = (int)CFG.glyphLay.height;
    }

    @Override
    public final String getTextE() {
        return this.sText;
    }

    @Override
    public void setTextE(String sText) {
        this.sText = sText;
        this.updateTextWidth();
    }

    @Override
    public void setCurr(long nCurrent) {
        int tempCurr = this.iCurrentPosX;
        this.iCurrent = nCurrent > this.iMax ? this.iMax : (nCurrent < this.iMin ? this.iMin : nCurrent);
        this.updateCurrentPosX();
        this.updateTextWidth();
        if (tempCurr != this.iCurrentPosX) {
            this.lTime = 0L;
            this.iDifference_PosX = this.iDifference_CurrentPosX = tempCurr - this.iCurrentPosX;
        }
        CFG.setRenderO(true);
    }

    public void setCurr(int nCurrent) {
        this.setCurr((long)nCurrent);
    }

    @Override
    public int getCurr() {
        return (int)this.iCurrent;
    }

    @Override
    public long getCurrLong() {
        return this.iCurrent;
    }

    @Override
    public int getTextWidthU() {
        return this.iTextWidth;
    }

    @Override
    public final int getTextHeight() {
        return this.iTextHeight;
    }

    @Override
    public void setMin(long iMin) {
        this.iMin = iMin;
        if (this.iCurrent < iMin) {
            this.iCurrent = iMin;
            this.updateTextWidth();
        }
    }

    @Override
    public void setMin(int iMin) {
        this.setMin((long)iMin);
    }

    @Override
    public void setMax(long iMax) {
        this.iMax = iMax;
        if (this.iCurrent > iMax) {
            this.iCurrent = iMax;
            this.updateTextWidth();
        }
    }

    @Override
    public void setMax(int iMax) {
        this.setMax((long)iMax);
    }

    public void setMinMarker(long iMinMarker) {
        this.iMinMarker = iMinMarker;
    }

    public void setMinMarker(int iMinMarker) {
        this.setMinMarker((long)iMinMarker);
    }

    @Override
    public int getTextPosElem() {
        return (int)Math.min(2147483647L, this.iMax);
    }

    @Override
    public void srollByWheel(int nScoll) {
        this.setCurr(this.getCurrLong() + (long)nScoll);
    }

    @Override
    public boolean getIsScrollable() {
        return true;
    }

    @Override
    public int getSFXElem() {
        return SFXManager.SFX_CLICK3;
    }
}

