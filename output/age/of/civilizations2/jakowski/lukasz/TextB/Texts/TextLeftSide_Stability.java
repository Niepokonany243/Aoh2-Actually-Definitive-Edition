
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextLeftSide;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextLeftSide_Stability
extends TextLeftSide {
    private int iCurrent = 0;

    public TextLeftSide_Stability(String sText, int iPosX, int iPosY) {
        super(sText, iPosX, iPosY);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        IMGManager.getIMG(Images.diploStability).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + (this.getHeightE() - (int)((float)IMGManager.getIMG(Images.diploStability).getHeight() * this.getImageScale(IMGManager.getIMG(Images.diploStability).getHeight()))) / 2 - IMGManager.getIMG(Images.diploStability).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.diploStability).getWidth() * this.getImageScale(IMGManager.getIMG(Images.diploStability).getHeight())), (int)((float)IMGManager.getIMG(Images.diploStability).getHeight() * this.getImageScale(IMGManager.getIMG(Images.diploStability).getHeight())));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + (int)((float)IMGManager.getIMG(Images.diploStability).getWidth() * this.getImageScale(IMGManager.getIMG(Images.diploStability).getHeight())) + CFG.PADD + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, this.getColor(isActive));
    }

    @Override
    public int getPosXE() {
        return super.getPosXE() - (int)((float)IMGManager.getIMG(Images.diploStability).getWidth() * this.getImageScale(IMGManager.getIMG(Images.diploStability).getHeight())) - CFG.PADD;
    }

    @Override
    public int getWidthE() {
        return this.getTextWidthU() + (int)((float)IMGManager.getIMG(Images.diploStability).getWidth() * this.getImageScale(IMGManager.getIMG(Images.diploStability).getHeight())) + CFG.PADD;
    }

    private final float getImageScale(int nImageHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT_SMALL / (float)nImageHeight < 1.0f ? (float)CFG.TEXT_HEIGHT_DEFAULT_SMALL / (float)nImageHeight : 1.0f;
    }

    @Override
    public Color getColor(boolean isActive) {
        return isActive ? CFG.getColorStep(CFG.COLOR_PROVINCE_STABILITY_MIN, CFG.COLOR_PROVINCE_STABILITY_MAX, this.getCurr(), 100, 1.0f) : (this.getIsClickable() ? (this.getIsHovered() ? CFG.getColorStep(CFG.COLOR_PROVINCE_STABILITY_MIN, CFG.COLOR_PROVINCE_STABILITY_MAX, this.getCurr(), 100, 1.0f) : CFG.getColorStep(CFG.COLOR_PROVINCE_STABILITY_MIN, CFG.COLOR_PROVINCE_STABILITY_MAX, this.getCurr(), 100, 1.0f)) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
    }

    @Override
    public int getCurr() {
        return this.iCurrent;
    }

    @Override
    public void setCurr(int nCurrent) {
        this.iCurrent = nCurrent;
        this.setTextE("" + this.iCurrent + "%");
    }
}

