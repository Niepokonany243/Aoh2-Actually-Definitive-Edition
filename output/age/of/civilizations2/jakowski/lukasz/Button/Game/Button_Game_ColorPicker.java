/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Game;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Game_ColorPicker
extends Button_Game {
    public Button_Game_ColorPicker(int iPosX, int iPosY, boolean isClickable) {
        super("", 0, iPosX, iPosY, isClickable);
    }

    public Button_Game_ColorPicker(int iPosX, int iPosY, int nWidth, boolean isClickable) {
        super("", 0, iPosX, iPosY, nWidth, isClickable);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
        if (isActive) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.8f));
            IMGManager.getIMG(Images.pickerIcon).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.pickerIcon).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.pickerIcon).getHeight() / 2 + iTranslateY);
            oSB.setColor(Color.WHITE);
        } else {
            IMGManager.getIMG(Images.pickerIcon).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.pickerIcon).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.pickerIcon).getHeight() / 2 + iTranslateY);
        }
    }
}

