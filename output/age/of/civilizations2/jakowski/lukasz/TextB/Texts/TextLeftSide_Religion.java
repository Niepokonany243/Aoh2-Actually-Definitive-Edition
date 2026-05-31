
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextLeftSide;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextLeftSide_Religion
extends TextLeftSide {
    private int iCurrent = 0;

    public TextLeftSide_Religion(String sText, int iPosX, int iPosY) {
        super(sText, iPosX, iPosY);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        CFG.religionManager.religionImages.get(this.iCurrent).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + (this.getHeightE() - (int)((float)CFG.religionManager.religionImages.get(this.iCurrent).getHeight() * this.getImageScale(CFG.religionManager.religionImages.get(this.iCurrent).getHeight()))) / 2 - CFG.religionManager.religionImages.get(this.iCurrent).getHeight() + iTranslateY, (int)((float)CFG.religionManager.religionImages.get(this.iCurrent).getWidth() * this.getImageScale(CFG.religionManager.religionImages.get(this.iCurrent).getHeight())), (int)((float)CFG.religionManager.religionImages.get(this.iCurrent).getHeight() * this.getImageScale(CFG.religionManager.religionImages.get(this.iCurrent).getHeight())));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + (int)((float)CFG.religionManager.religionImages.get(this.iCurrent).getWidth() * this.getImageScale(CFG.religionManager.religionImages.get(this.iCurrent).getHeight())) + CFG.PADD + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, this.getColor(isActive));
    }

    @Override
    public int getPosXE() {
        if (this.iCurrent < 0) {
            return super.getPosXE() - (int)((float)IMGManager.getIMG(Images.hreCrownScaled).getWidth() * this.getImageScale(IMGManager.getIMG(Images.hreCrownScaled).getHeight())) - CFG.PADD;
        }
        return super.getPosXE() - (int)((float)CFG.religionManager.religionImages.get(this.iCurrent).getWidth() * this.getImageScale(CFG.religionManager.religionImages.get(this.iCurrent).getHeight())) - CFG.PADD;
    }

    @Override
    public int getWidthE() {
        if (this.iCurrent < 0) {
            return this.getTextWidthU() + (int)((float)IMGManager.getIMG(Images.hreCrownScaled).getWidth() * this.getImageScale(IMGManager.getIMG(Images.hreCrownScaled).getHeight())) + CFG.PADD;
        }
        return this.getTextWidthU() + (int)((float)CFG.religionManager.religionImages.get(this.iCurrent).getWidth() * this.getImageScale(CFG.religionManager.religionImages.get(this.iCurrent).getHeight())) + CFG.PADD;
    }

    private final float getImageScale(int nImageHeight) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nImageHeight < 1.0f ? (float)CFG.TEXT_HEIGHT_DEFAULT / (float)nImageHeight : 1.0f;
    }

    @Override
    public Color getColor(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
    }

    @Override
    public int getCurr() {
        return this.iCurrent;
    }

    @Override
    public void setCurr(int nCurrent) {
        this.iCurrent = nCurrent;
    }
}

