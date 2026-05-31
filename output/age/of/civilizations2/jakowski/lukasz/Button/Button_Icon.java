/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Menus.Technology.Menu_InGame_Technology;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Icon
extends Button_Build {
    public Button_Icon(int nImageID, int iPosX, int iPosY) {
        super("", nImageID, 0, 0, iPosX, iPosY, ButtonDiplomacy.iDiploWidth, true, false, 0, 0.0f);
        this.setHeightE(Menu_InGame_Technology.getButtonH());
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        try {
            IMGManager.getIMG(this.iImageID).drawO(oSB, this.getPosXE() + ButtonDiplomacy.iDiploWidth / 2 - IMGManager.getIMG(this.iImageID).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(this.iImageID).getHeight() / 2 + iTranslateY);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            // empty catch block
        }
    }
}


