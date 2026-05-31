
package age.of.civilizations2.jakowski.lukasz.Button.Game;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Game_ArrowLeft
extends Button_Game {
    public Button_Game_ArrowLeft(int iPosX, int iPosY, boolean isClickable) {
        super("", 0, iPosX, iPosY, isClickable);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (CFG.settingsGD.BETTER_UI) {
            BetterUI_Manager.drawBetterArrow(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), this.getIsHovered(), isActive, false);
            return;
        }
        if (isActive) {
            IMGManager.getIMG(Images.arrowActive).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.arrowActive).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.arrowActive).getHeight() / 2 + iTranslateY);
        } else {
            IMGManager.getIMG(Images.arrow).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.arrow).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.arrow).getHeight() / 2 + iTranslateY);
        }
    }
}

