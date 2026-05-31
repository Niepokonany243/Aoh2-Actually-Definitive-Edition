/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Transparent_WithHoverEnabled
extends ButtonM {
    public Button_Transparent_WithHoverEnabled(int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super.init("", 0, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false, null);
    }

    public Button_Transparent_WithHoverEnabled(int iTextPos, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super.init("", iTextPos, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false, null);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
    }
}

