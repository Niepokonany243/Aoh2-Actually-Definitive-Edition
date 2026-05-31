
package age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Clear;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slider;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Slider_InGame_Clear_Flag_Tribute
extends Slider {
    public int iCivID;

    public Slider_InGame_Clear_Flag_Tribute(int iCivID, String sText, int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        this.initSlider(sText, iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
        this.iCivID = iCivID;
        this.setCurr(this.getCurr());
    }

    public Slider_InGame_Clear_Flag_Tribute(int iCivID, String sText, int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        this(iCivID, sText, iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        this.drawSliderBG_UpdateAnimation();
        this.drawSliderBG(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
        this.drawSliderBorder(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getDrawText(), this.getPosXE() + this.getWidthE() - CFG.PADD - this.getTextWidthU() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_CIV_INFO_TITLE);
    }

    @Override
    public String getDrawText() {
        return this.getCurr() + "%";
    }

    @Override
    public void actionElem(int iID) {
        CFG.core.getCiv(CFG.core.getCiv(this.iCivID).getPuppetOfCiv()).getVassal(this.iCivID).setTribute((int)this.getCurr());
    }
}
