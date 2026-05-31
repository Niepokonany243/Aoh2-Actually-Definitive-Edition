/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_ShowMenu
extends ButtonM {
    public Button_ShowMenu(int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super.init("", 0, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false, null);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - IMGManager.getIMG(Images.gameTopEdge).getHeight());
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gameTopEdge).getHeight() * 2 + iTranslateY, this.getWidthE(), IMGManager.getIMG(Images.gameTopEdge).getHeight(), false, true);
        if (isActive) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.65f));
        }
        IMGManager.getIMG(Images.btnShow).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.btnShow).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.btnShow).getHeight() / 2 + iTranslateY);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
    }
}

