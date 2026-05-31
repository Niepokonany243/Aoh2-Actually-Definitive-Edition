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

public class ButtonFlagRect
extends ButtonM {
    public int iCivID;

    public ButtonFlagRect(int iCivID, int iPosX, int iPosY, boolean isClickable) {
        this.init("", this.iTextPositionX, iPosX, iPosY, IMGManager.getIMG(Images.flagRect2).getWidth(), IMGManager.getIMG(Images.flagRect2).getHeight(), isClickable, true, false, false);
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
        IMGManager.getIMG(Images.flagRect2Mask).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.flush();
        oSB.setShader(AoCGame.shaderDef);
        IMGManager.getIMG(Images.flagRect2).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
    }

    public int getFlagCivID() {
        return this.iCivID;
    }

    @Override
    public int getCurr() {
        return this.iCivID;
    }

    public static int getButtonWidth() {
        return IMGManager.getIMG(Images.flagRect2).getWidth();
    }

    public static int getButtonHeight() {
        return IMGManager.getIMG(Images.flagRect2).getHeight();
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
}

