/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Clear;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Sliders.InGame.Clear.Slider_InGame_Clear_Tech;

public class Slider_InGame_Clear_Adm
extends Slider_InGame_Clear_Tech {
    public Slider_InGame_Clear_Adm(float fModifier, String sText, int iPosX, int iPosY, int iWidth, int iHeight, long iMin, long iMax, long iCurrent) {
        super(fModifier, sText, iPosX, iPosY, iWidth, iHeight, iMin, iMax, iCurrent);
    }

    public Slider_InGame_Clear_Adm(float fModifier, String sText, int iPosX, int iPosY, int iWidth, int iHeight, int iMin, int iMax, int iCurrent) {
        this(fModifier, sText, iPosX, iPosY, iWidth, iHeight, (long)iMin, (long)iMax, (long)iCurrent);
    }

    @Override
    public String getTextLeft() {
        if (this.fModifier == 0.0f) {
            return this.getTextE();
        }
        return this.getTextE() + ": " + CFG.getNumberWthSpaces("" + (int)((float)this.getCurr() * this.fModifier));
    }
}
