/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button2;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ButtonFlagDiplomacy
extends ButtonM {
    public int iCivID;

    public ButtonFlagDiplomacy(int iCivID, int iPosX, int iPosY, boolean isClickable) {
        this.init("", this.iTextPositionX, iPosX, iPosY, IMGManager.getIMG(Images.flagDiplomacyOver).getWidth(), IMGManager.getIMG(Images.flagDiplomacyOver).getHeight(), isClickable, true, false, false);
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.BUTTON_FLAG;
        this.iCivID = iCivID;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setShader(Renderer.shaderAlpha);
        if (this.getFlagCivID() >= 0) {
            CFG.core.getCiv(this.getFlagCivID()).getFlagC().getTexture().bind(1);
        } else {
            IMGManager.getIMG(Images.randomCivilizationFlag).getTexture().bind(1);
        }
        Gdx.gl.glActiveTexture(33984);
        IMGManager.getIMG(Images.flagDiplomacyMask).draw(oSB, this.getPosXE() + iTranslateX + (IMGManager.getIMG(Images.flagDiplomacyOver).getWidth() - IMGManager.getIMG(Images.flagDiplomacyMask).getWidth()) / 2, this.getPosY() + iTranslateY + (IMGManager.getIMG(Images.flagDiplomacyOver).getHeight() - IMGManager.getIMG(Images.flagDiplomacyMask).getHeight()) / 2, IMGManager.getIMG(Images.flagDiplomacyMask).getWidth(), IMGManager.getIMG(Images.flagDiplomacyMask).getHeight());
        oSB.flush();
        oSB.setShader(AoCGame.shaderDef);
        IMGManager.getIMG(Images.flagDiplomacyOver).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY);
    }

    public int getFlagCivID() {
        return this.iCivID;
    }

    @Override
    public int getCurr() {
        return this.iCivID;
    }

    @Override
    public void actionElemPPM() {
        try {
            CFG.map.getMpC().centerToProvID(CFG.core.getCiv(this.getCurr()).getCapitalProvID());
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static int getButtonWidth() {
        return IMGManager.getIMG(Images.flagDiplomacyOver).getWidth();
    }

    public static int getButtonHeight() {
        return IMGManager.getIMG(Images.flagDiplomacyOver).getHeight();
    }
}

