/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Game;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Game_NewGameBoxStyle_RIGHT_Remove
extends ButtonM {
    public Button_Game_NewGameBoxStyle_RIGHT_Remove(int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super.init("", 0, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false, null);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive) {
            IMGManager.getIMG(Images.gameBoxHover).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBoxHover).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - IMGManager.getIMG(Images.gameBoxHover).getHeight(), true, false);
            IMGManager.getIMG(Images.gameBoxHover).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gameBoxHover).getHeight() * 2 + iTranslateY, this.getWidthE(), IMGManager.getIMG(Images.gameBoxHover).getHeight(), true, true);
            oSB.setColor(1.0f, 1.0f, 1.0f, 0.45f);
            IMGManager.getIMG(Images.btnRemove).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.btnRemove).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.btnRemove).getHeight() / 2 + iTranslateY, true);
        } else {
            IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBox).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - IMGManager.getIMG(Images.gameBox).getHeight(), true, false);
            IMGManager.getIMG(Images.gameBox).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gameBox).getHeight() * 2 + iTranslateY, this.getWidthE(), IMGManager.getIMG(Images.gameBox).getHeight(), true, true);
            IMGManager.getIMG(Images.btnRemove).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.btnRemove).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.btnRemove).getHeight() / 2 + iTranslateY, true);
        }
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + 1 + iTranslateX, this.getPosY() + 2 + iTranslateY, 1, this.getHeightE() - 6);
        oSB.setColor(Color.WHITE);
    }
}

