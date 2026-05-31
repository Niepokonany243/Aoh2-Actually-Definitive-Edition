
package age.of.civilizations2.jakowski.lukasz.Sliders.LR;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Sliders.LR.Slider_LR_Perc;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Slider_LR_Flag
extends Slider_LR_Perc {
    public int iCivID;

    public Slider_LR_Flag(int iCivID, int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        super(iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
        this.iCivID = iCivID;
    }

    public Slider_LR_Flag(int iCivID, int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        this(iCivID, iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
    }

    @Override
    public void drawSliderText(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        CFG.core.getCiv(this.iCivID).getFlagC().drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        Renderer.drawText(oSB, this.fontID, this.getDrawText(), this.getPosXE() + CFG.PADD * 2 + CFG.CIV_FLAG_WIDTH + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, new Color(0.945f, 0.945f, 0.945f, 1.0f));
    }
}
