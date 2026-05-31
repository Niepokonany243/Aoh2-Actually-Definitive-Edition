/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Close
extends ButtonM {
    public Button_Close(int iPosX, int iPosY, int iWidth, int iHeight) {
        super.init("", 0, iPosX, iPosY, iWidth, iHeight, true, true, false, false, null);
    }

    @Override
    public final void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        IMGManager.getIMG(Images.btnClose).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY);
    }
}

