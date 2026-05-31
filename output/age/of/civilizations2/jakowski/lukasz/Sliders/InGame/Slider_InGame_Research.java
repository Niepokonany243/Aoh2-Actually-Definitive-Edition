
package age.of.civilizations2.jakowski.lukasz.Sliders.InGame;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menus.Budget.Menu_InGame_Budget;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Slider_InGame;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Slider_InGame_Research
extends Slider_InGame {
    public int iconWidth;
    public int iconHeight;

    public Slider_InGame_Research(String sText, int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        super(sText, iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
        int nIMGID = Images.technology;
        float iconScale = Slider_InGame_Research.getImageScale(nIMGID);
        this.iconWidth = (int)((float)IMGManager.getIMG(nIMGID).getWidth() * iconScale);
        this.iconHeight = (int)((float)IMGManager.getIMG(nIMGID).getHeight() * iconScale);
    }

    public Slider_InGame_Research(String sText, int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        this(sText, iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
    }

    public Slider_InGame_Research(String sText, int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent, boolean clickable) {
        super(sText, iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent, clickable);
        int nIMGID = Images.technology;
        float iconScale = Slider_InGame_Research.getImageScale(nIMGID);
        this.iconWidth = (int)((float)IMGManager.getIMG(nIMGID).getWidth() * iconScale);
        this.iconHeight = (int)((float)IMGManager.getIMG(nIMGID).getHeight() * iconScale);
    }

    public Slider_InGame_Research(String sText, int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent, boolean clickable) {
        this(sText, iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent, clickable);
    }

    public static final float getImageScale(int iImageID) {
        return Math.min(1.0f, (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(iImageID).getHeight());
    }

    @Override
    public void drawTextLeft(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        IMGManager.getIMG(Images.technology).draw(oSB, this.getPosXE() + CFG.PADD + (Menu_InGame_Budget.maxIconWidth - this.iconWidth) / 2 + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 - this.getSliderHeight() - this.iconHeight + iTranslateY, this.iconWidth, this.iconHeight);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD * 2 + Menu_InGame_Budget.maxIconWidth + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD * 2 - this.getSliderHeight() - CFG.TEXT_HEIGHT_DEFAULT + iTranslateY, this.getColor(isActive));
    }
}
