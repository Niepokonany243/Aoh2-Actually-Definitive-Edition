/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.View;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ButtonView
extends ButtonM {
    public ButtonView(String sText, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super.init(sText, -1, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false, null);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        IMGManager.getIMG(isActive ? Images.top_view_right_h : Images.top_view_right).draw2O(oSB, this.getPosXE() + iTranslateX, this.getHeightE() - IMGManager.getIMG(Images.top_view_right).getHeight() * 2, this.getWidthE(), IMGManager.getIMG(Images.top_view_right).getHeight(), true);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive) {
            CFG.fontMain.get(0).getData().setScale(0.6f);
            CFG.drawTextDefault(oSB, this.getTextE(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - (int)((float)this.getTextWidthU() * 0.6f / 2.0f) : this.getTextPosElem()) + iTranslateX, this.getPosY() + IMGManager.getIMG(Images.topBar).getHeight() + (this.getHeightE() - IMGManager.getIMG(Images.topBar).getHeight() - 2) / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.6f / 2.0f) + iTranslateY, this.getColorE(isActive));
            CFG.fontMain.get(0).getData().setScale(1.0f);
        } else {
            CFG.fontMain.get(0).getData().setScale(0.6f);
            CFG.drawTextDefault(oSB, this.getTextE(), this.getPosXE() + (this.getTextPosElem() < 0 ? this.getWidthE() / 2 - (int)((float)this.getTextWidthU() * 0.6f / 2.0f) : this.getTextPosElem()) + iTranslateX, this.getPosY() + IMGManager.getIMG(Images.topBar).getHeight() + (this.getHeightE() - IMGManager.getIMG(Images.topBar).getHeight() - 2) / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.6f / 2.0f) + iTranslateY, this.getColorE(isActive));
            CFG.fontMain.get(0).getData().setScale(1.0f);
        }
    }

    @Override
    public final Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_TOP_VIEWS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_TOP_VIEWS_HOVER : CFG.COLOR_TEXT_TOP_VIEWS) : CFG.COLOR_TEXT_TOP_VIEWS_NOT_CLICKABLE);
    }
}

