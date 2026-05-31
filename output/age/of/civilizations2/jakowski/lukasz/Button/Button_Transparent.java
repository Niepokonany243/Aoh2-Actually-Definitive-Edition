/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;

public class Button_Transparent
extends ButtonM {
    public Button_Transparent(int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super.init("", 0, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false, null);
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.BUTTON_TRANSPARENT;
    }

    public Button_Transparent(int iTextPos, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super.init("", iTextPos, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false, null);
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.BUTTON_TRANSPARENT;
    }

    public Button_Transparent(int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable, int b) {
        super.init("", 0, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false, null);
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TRANSPARENT;
    }
}

