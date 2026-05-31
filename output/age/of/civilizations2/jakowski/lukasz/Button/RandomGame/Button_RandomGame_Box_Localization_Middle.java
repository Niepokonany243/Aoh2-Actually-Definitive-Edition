
package age.of.civilizations2.jakowski.lukasz.Button.RandomGame;

import age.of.civilizations2.jakowski.lukasz.Button.NewGame.Button_InGameBox;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_RandomGame_Box_Localization_Middle
extends Button_InGameBox {
    public Button_RandomGame_Box_Localization_Middle(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, isClickable);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive) {
            IMGManager.getIMG(Images.gameBoxLineHover).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBoxLineHover).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - IMGManager.getIMG(Images.gameBoxLineHover).getHeight(), true, false);
            IMGManager.getIMG(Images.gameBoxLineHover).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gameBoxLineHover).getHeight() * 2 + iTranslateY, this.getWidthE(), IMGManager.getIMG(Images.gameBoxLineHover).getHeight(), true, true);
            oSB.setColor(1.0f, 1.0f, 1.0f, 0.45f);
            IMGManager.getIMG(Images.btnLocalization).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.btnLocalization).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.btnLocalization).getHeight() / 2 + iTranslateY, true);
        } else if (this.getIsHovered()) {
            IMGManager.getIMG(Images.gameBoxLineHover).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBoxLineHover).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - IMGManager.getIMG(Images.gameBoxLineHover).getHeight(), true, false);
            IMGManager.getIMG(Images.gameBoxLineHover).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gameBoxLineHover).getHeight() * 2 + iTranslateY, this.getWidthE(), IMGManager.getIMG(Images.gameBoxLineHover).getHeight(), true, true);
            oSB.setColor(1.0f, 1.0f, 1.0f, 0.65f);
            IMGManager.getIMG(Images.btnLocalization).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.btnLocalization).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.btnLocalization).getHeight() / 2 + iTranslateY, true);
        } else {
            IMGManager.getIMG(Images.gameBoxLine).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameBoxLine).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - IMGManager.getIMG(Images.gameBoxLine).getHeight(), true, false);
            IMGManager.getIMG(Images.gameBoxLine).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.gameBoxLine).getHeight() * 2 + iTranslateY, this.getWidthE(), IMGManager.getIMG(Images.gameBoxLine).getHeight(), true, true);
            IMGManager.getIMG(Images.btnLocalization).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.btnLocalization).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.btnLocalization).getHeight() / 2 + iTranslateY, true);
        }
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + 1 + iTranslateX, this.getPosY() + 2 + iTranslateY, 1, this.getHeightE() - 6);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
    }
}

