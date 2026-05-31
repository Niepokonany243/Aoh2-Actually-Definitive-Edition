
package age.of.civilizations2.jakowski.lukasz.Sliders.ZRest;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Sliders.Slider;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Slider_BG
extends Slider {
    public Slider_BG(int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        this.initSlider("", iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
    }

    public Slider_BG(int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        this.initSlider("", iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
    }

    public Slider_BG(String sText, int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        this.initSlider(sText, iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
    }

    public Slider_BG(String sText, int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        this.initSlider(sText, iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        if (CFG.settingsGD.BETTER_UI) {
            super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
            return;
        }
        IMGManager.getIMG(Images.btnMenuH).drawO(oSB, iTranslateX, this.getPosY() - CFG.PADD + iTranslateY, CFG.GAMEWIDTH);
        super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
    }
}

