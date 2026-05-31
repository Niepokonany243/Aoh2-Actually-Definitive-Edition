
package age.of.civilizations2.jakowski.lukasz.Button.View;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_ViewPercentageInfo
extends ButtonM {
    private int iCurrent;

    public Button_ViewPercentageInfo(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super.init(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false, null);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(CFG.COLOR_ECONOMY_GRADIENT[this.getCurr()].r, CFG.COLOR_ECONOMY_GRADIENT[this.getCurr()].g, CFG.COLOR_ECONOMY_GRADIENT[this.getCurr()].b, 0.8f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE(), true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 2, this.getHeightE(), true, false);
        oSB.setColor(new Color(CFG.COLOR_ECONOMY_GRADIENT[this.getCurr()].r, CFG.COLOR_ECONOMY_GRADIENT[this.getCurr()].g, CFG.COLOR_ECONOMY_GRADIENT[this.getCurr()].b, 0.25f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, true, false);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - this.getHeightE() / 4 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 4, true, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), 1, true, false);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        CFG.fontMain.get(0).getData().setScale(0.65f);
        if (isActive) {
            CFG.drawTextDefault(oSB, this.getTextToDrawElem(), this.getPosXE() + this.getWidthE() / 2 - (int)((float)this.getTextWidthU() * 0.65f / 2.0f) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)this.getTextHeight() * 0.65f / 2.0f) + iTranslateY, this.getColorE(isActive));
        } else {
            CFG.drawTextDefault(oSB, this.getTextToDrawElem(), this.getPosXE() + this.getWidthE() / 2 - (int)((float)this.getTextWidthU() * 0.65f / 2.0f) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)this.getTextHeight() * 0.65f / 2.0f) + iTranslateY, this.getColorE(isActive));
        }
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? new Color(0.1f, 0.1f, 0.1f, 1.0f) : (this.getIsClickable() ? CFG.COLOR_TEXT_RANK : new Color(0.78f, 0.78f, 0.78f, 0.75f));
    }

    @Override
    public void setCurr(int nCurrent) {
        this.iCurrent = nCurrent;
    }

    @Override
    public int getCurr() {
        return this.iCurrent;
    }
}

