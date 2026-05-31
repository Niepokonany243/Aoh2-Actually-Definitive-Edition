
package age.of.civilizations2.jakowski.lukasz.Button.Game;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Game_ArrowDown
extends Button_Game {
    public Button_Game_ArrowDown(int iPosX, int iPosY, boolean isClickable) {
        super("", 0, iPosX, iPosY, isClickable);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive) {
            IMGManager.getIMG(Images.arrowActive).drawO(oSB, this.getPosXE() - IMGManager.getIMG(Images.arrowActive).getHeight() / 2 + this.getWidthE() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + IMGManager.getIMG(Images.arrowActive).getWidth() / 2 - IMGManager.getIMG(Images.arrowActive).getHeight() + iTranslateY, IMGManager.getIMG(Images.arrowActive).getWidth(), IMGManager.getIMG(Images.arrowActive).getHeight(), 90.0f);
        } else {
            IMGManager.getIMG(Images.arrow).drawO(oSB, this.getPosXE() - IMGManager.getIMG(Images.arrow).getHeight() / 2 + this.getWidthE() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + IMGManager.getIMG(Images.arrow).getWidth() / 2 - IMGManager.getIMG(Images.arrow).getHeight() + iTranslateY, IMGManager.getIMG(Images.arrow).getWidth(), IMGManager.getIMG(Images.arrow).getHeight(), 90.0f);
        }
    }
}

