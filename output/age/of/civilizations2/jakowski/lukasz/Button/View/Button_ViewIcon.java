/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.View;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_ViewIcon
extends ButtonM {
    public Button_ViewIcon(int iPosX, int iPosY, boolean isClickable) {
        super.init("", -1, iPosX, iPosY, 25, 10, isClickable, true, false, false, null);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
    }
}

