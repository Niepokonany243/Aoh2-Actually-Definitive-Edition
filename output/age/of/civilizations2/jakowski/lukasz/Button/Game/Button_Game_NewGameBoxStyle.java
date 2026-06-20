package age.of.civilizations2.jakowski.lukasz.Button.Game;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public final class Button_Game_NewGameBoxStyle {
    private Button_Game_NewGameBoxStyle() {
    }

    public static void draw(SpriteBatch oSB, ButtonM button, int iTranslateX, int iTranslateY, boolean isActive) {
        int iBGImageID;
        if (isActive || button.getIsHovered()) {
            oSB.setColor(new Color(0.925f, 0.925f, 1.0f, 0.975f));
            iBGImageID = Images.gameBox;
        } else {
            iBGImageID = Images.gameBoxHover;
        }
        IMGManager.getIMG(iBGImageID).draw2O(oSB, button.getPosXE() + iTranslateX, button.getPosY() - IMGManager.getIMG(iBGImageID).getHeight() + iTranslateY, button.getWidthE() / 2, button.getHeightE() - IMGManager.getIMG(iBGImageID).getHeight(), false, false);
        IMGManager.getIMG(iBGImageID).draw2O(oSB, button.getPosXE() + button.getWidthE() / 2 + iTranslateX, button.getPosY() - IMGManager.getIMG(iBGImageID).getHeight() + iTranslateY, button.getWidthE() / 2, button.getHeightE() - IMGManager.getIMG(iBGImageID).getHeight(), true, false);
        IMGManager.getIMG(iBGImageID).draw2O(oSB, button.getPosXE() + iTranslateX, button.getPosY() + button.getHeightE() - IMGManager.getIMG(iBGImageID).getHeight() * 2 + iTranslateY, button.getWidthE() / 2, IMGManager.getIMG(iBGImageID).getHeight(), false, true);
        IMGManager.getIMG(iBGImageID).draw2O(oSB, button.getPosXE() + button.getWidthE() / 2 + iTranslateX, button.getPosY() + button.getHeightE() - IMGManager.getIMG(iBGImageID).getHeight() * 2 + iTranslateY, button.getWidthE() / 2, IMGManager.getIMG(iBGImageID).getHeight(), true, true);
        oSB.setColor(Color.WHITE);
    }
}
