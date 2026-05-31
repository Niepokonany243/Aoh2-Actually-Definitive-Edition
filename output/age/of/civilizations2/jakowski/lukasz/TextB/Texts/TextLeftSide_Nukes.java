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

public class TextLeftSide_Nukes
extends TextLeftSide {
    public TextLeftSide_Nukes(String sText, int iPosX, int iPosY) {
        super(sText, iPosX, iPosY);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        IMGManager.getIMG(Images.nuke).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + (this.getHeightE() - (int)((float)IMGManager.getIMG(Images.nuke).getHeight() * this.getImageScale(IMGManager.getIMG(Images.nuke).getHeight()))) / 2 - IMGManager.getIMG(Images.nuke).getHeight() + iTranslateY, (int)((float)IMGManager.getIMG(Images.nuke).getWidth() * this.getImageScale(IMGManager.getIMG(Images.nuke).getHeight())), (int)((float)IMGManager.getIMG(Images.nuke).getHeight() * this.getImageScale(IMGManager.getIMG(Images.nuke).getHeight())));
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + (int)((float)IMGManager.getIMG(Images.nuke).getWidth() * this.getImageScale(IMGManager.getIMG(Images.nuke).getHeight())) + CFG.PADD + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, this.getColor(isActive));
    }

    @Override
    public int getPosXE() {
        return super.getPosXE() - (int)((float)IMGManager.getIMG(Images.nuke).getWidth() * this.getImageScale(IMGManager.getIMG(Images.nuke).getHeight())) - CFG.PADD;
    }

    @Override
    public int getWidthE() {
        return this.getTextWidthU() + (int)((float)IMGManager.getIMG(Images.nuke).getWidth() * this.getImageScale(IMGManager.getIMG(Images.nuke).getHeight())) + CFG.PADD;
    }

    private final float getImageScale(int nImageHeight) {
        return (float)this.getHeightE() / (float)nImageHeight < 1.0f ? (float)this.getHeightE() / (float)nImageHeight : 1.0f;
    }

    @Override
    public Color getColor(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
    }

    @Override
    public void setCurr(int nCurrent) {
        this.setTextE("" + nCurrent);
    }
}

