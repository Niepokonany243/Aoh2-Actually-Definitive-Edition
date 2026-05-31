/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextLeftSide;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextLeftSide_Happiness
extends TextLeftSide {
    private int iCurrent = 0;

    public TextLeftSide_Happiness(String sText, int iPosX, int iPosY) {
        super(sText, iPosX, iPosY);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        IMGManager.getIMG(CFG.getHappinessImage(this.getCurr())).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + (this.getHeightE() - (int)((float)IMGManager.getIMG(Images.happiness).getHeight() * this.getImageScale(IMGManager.getIMG(Images.happiness).getHeight()))) / 2 - IMGManager.getIMG(Images.happiness).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.happiness).getWidth() * this.getImageScale(IMGManager.getIMG(Images.happiness).getHeight())), (int)((float)IMGManager.getIMG(Images.happiness).getHeight() * this.getImageScale(IMGManager.getIMG(Images.happiness).getHeight())));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + (int)((float)IMGManager.getIMG(Images.happiness).getWidth() * this.getImageScale(IMGManager.getIMG(Images.happiness).getHeight())) + CFG.PADD + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, this.getColor(isActive));
    }

    @Override
    public int getPosXE() {
        return super.getPosXE() - (int)((float)IMGManager.getIMG(Images.happiness).getWidth() * this.getImageScale(IMGManager.getIMG(Images.happiness).getHeight())) - CFG.PADD;
    }

    @Override
    public int getWidthE() {
        return this.getTextWidthU() + (int)((float)IMGManager.getIMG(Images.happiness).getWidth() * this.getImageScale(IMGManager.getIMG(Images.happiness).getHeight())) + CFG.PADD;
    }

    private final float getImageScale(int nImageHeight) {
        return (float)this.getHeightE() / (float)nImageHeight < 1.0f ? (float)this.getHeightE() / (float)nImageHeight : 1.0f;
    }

    @Override
    public Color getColor(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_HAPPINESS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_HAPPINESS_HOVER : CFG.getColorStep(CFG.COLOR_HAPPINESS_MIN, CFG.COLOR_HAPPINESS_MAX, this.getCurr(), 100, 1.0f)) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
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

