/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.ZRest;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Add
extends ButtonM {
    public Button_Add(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super.init(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false, null);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.getIsClickable()) {
            if (isActive) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.75f));
            } else if (this.getIsHovered()) {
                oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
            } else {
                oSB.setColor(Color.WHITE);
            }
        } else if (isActive) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.35f));
        } else {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.5f));
        }
        IMGManager.getIMG(Images.btnAdd).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.btnAdd).getHeight() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.btnAdd).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.btnAdd).getHeight());
        IMGManager.getIMG(Images.btnAdd).draw2O(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.btnAdd).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.btnAdd).getHeight() + iTranslateY, IMGManager.getIMG(Images.btnAdd).getWidth(), this.getHeightE() - IMGManager.getIMG(Images.btnAdd).getHeight(), true);
        IMGManager.getIMG(Images.btnAdd).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.btnAdd).getHeight() * 2 + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.btnAdd).getWidth(), IMGManager.getIMG(Images.btnAdd).getHeight(), false, true);
        IMGManager.getIMG(Images.btnAdd).drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.btnAdd).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.btnAdd).getHeight() + iTranslateY, true, true);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public final Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_HOVER_TITLE : (this.getIsClickable() ? (this.getIsHovered() ? new Color(0.82f, 0.82f, 0.82f, 1.0f) : new Color(0.7f, 0.7f, 0.7f, 1.0f)) : new Color(0.764f, 0.764f, 0.764f, 0.6f));
    }
}

