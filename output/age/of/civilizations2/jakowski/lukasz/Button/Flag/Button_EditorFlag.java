
package age.of.civilizations2.jakowski.lukasz.Button.Flag;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_EditorFlag
extends ButtonM {
    private int nCivID = 0;

    public Button_EditorFlag(int nCivID, int iPosX, int iPosY, boolean isClickable) {
        super.init("", 0, iPosX, iPosY, IMGManager.getIMG(Images.topFlagFrame).getWidth(), CFG.BUTTON_H, isClickable, true, false, false, null);
        this.setCurr(nCivID);
    }

    @Override
    public final void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (CFG.core.getCiv(this.nCivID).getCivTag().equals("ran")) {
            oSB.setColor(new Color((float)CFG.core.getCiv(this.nCivID).getR() / 255.0f, (float)CFG.core.getCiv(this.nCivID).getG() / 255.0f, (float)CFG.core.getCiv(this.nCivID).getB() / 255.0f, 1.0f));
            CFG.core.getCiv(this.nCivID).getFlagC().drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + CFG.BUTTON_H / 2 - IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2 + iTranslateY - CFG.core.getCiv(this.nCivID).getFlagC().getHeight(), IMGManager.getIMG(Images.topFlagFrame).getWidth(), IMGManager.getIMG(Images.topFlagFrame).getHeight());
            oSB.setColor(Color.WHITE);
        } else {
            CFG.core.getCiv(this.nCivID).getFlagC().drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + CFG.BUTTON_H / 2 - IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2 + iTranslateY - CFG.core.getCiv(this.nCivID).getFlagC().getHeight(), IMGManager.getIMG(Images.topFlagFrame).getWidth(), IMGManager.getIMG(Images.topFlagFrame).getHeight());
        }
        if (this.getIsHovered()) {
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.0375f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + CFG.BUTTON_H / 2 - IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2 + iTranslateY, IMGManager.getIMG(Images.topFlagFrame).getWidth(), IMGManager.getIMG(Images.topFlagFrame).getHeight());
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.425f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + CFG.BUTTON_H / 2 - IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2 + iTranslateY, IMGManager.getIMG(Images.topFlagFrame).getWidth(), IMGManager.getIMG(Images.topFlagFrame).getHeight() / 5);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + IMGManager.getIMG(Images.topFlagFrame).getHeight() - IMGManager.getIMG(Images.topFlagFrame).getHeight() / 5 + CFG.BUTTON_H / 2 - IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2 + iTranslateY, IMGManager.getIMG(Images.topFlagFrame).getWidth(), IMGManager.getIMG(Images.topFlagFrame).getHeight() / 5, false, true);
            oSB.setColor(Color.WHITE);
        }
        if (isActive || this.nCivID == CFG.createScenarioAssignProvsCiv) {
            IMGManager.getIMG(Images.topFlagFrameH).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + CFG.BUTTON_H / 2 - IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2 + iTranslateY);
        } else {
            IMGManager.getIMG(Images.topFlagFrame).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + CFG.BUTTON_H / 2 - IMGManager.getIMG(Images.topFlagFrame).getHeight() / 2 + iTranslateY);
        }
    }

    @Override
    public final Color getColorE(boolean isActive) {
        return isActive ? new Color(0.941f, 1.0f, 0.0f, 1.0f) : (this.getIsClickable() ? new Color(0.376f, 0.388f, 0.376f, 1.0f) : new Color(0.674f, 0.09f, 0.066f, 0.5f));
    }

    @Override
    public void setCurr(int nCurrent) {
        this.nCivID = nCurrent;
    }

    @Override
    public int getCurr() {
        return this.nCivID;
    }
}

