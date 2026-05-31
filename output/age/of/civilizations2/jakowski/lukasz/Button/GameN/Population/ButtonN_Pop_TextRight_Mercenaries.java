/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.GameN.Population;

import age.of.civilizations2.jakowski.lukasz.Button.GameN.Population.ButtonN_Pop_TextRight;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menus.Merce.Menu_InGame_Mercenaries;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ButtonN_Pop_TextRight_Mercenaries
extends ButtonN_Pop_TextRight {
    public int id;

    public ButtonN_Pop_TextRight_Mercenaries(Color nColor, String sText, int nCivID, String sTextLeft, String nPop, int iImageID, Color textColor, int iPosX, int iPosY, int iWidth, String textRight, int imageRight, int id) {
        super(nColor, sText, nCivID, sTextLeft, nPop, iImageID, textColor, iPosX, iPosY, iWidth, textRight, imageRight);
        this.id = id;
        this.setHeightE(CFG.BUTTON_H * 4 / 5);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
        if (this.getCurr() == Menu_InGame_Mercenaries.hireID) {
            oSB.setColor(new Color(CFG.COLOR_POSITIVE.r, CFG.COLOR_POSITIVE.g, CFG.COLOR_POSITIVE.b, 0.2f));
        } else {
            oSB.setColor(new Color(CFG.COLOR_NEGATIVE_1.r, CFG.COLOR_NEGATIVE_1.g, CFG.COLOR_NEGATIVE_1.b, 0.085f));
        }
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(Color.WHITE);
    }

    @Override
    public Color getColorRight() {
        return CFG.COLOR_GOLD;
    }

    @Override
    public int getCurr() {
        return this.id;
    }
}

