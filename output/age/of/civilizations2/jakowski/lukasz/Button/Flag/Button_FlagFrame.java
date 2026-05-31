/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Flag;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_FlagFrame
extends ButtonM {
    public Button_FlagFrame(int iPosX, int iPosY, boolean isClickable) {
        super.init("", 0, iPosX, iPosY, IMGManager.getIMG(Images.topFlagFrame).getWidth(), IMGManager.getIMG(Images.topFlagFrame).getHeight(), isClickable, true, false, false, null);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        this.getFlag().drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - this.getFlag().getHeight() + iTranslateY, IMGManager.getIMG(Images.topFlagFrame).getWidth(), IMGManager.getIMG(Images.topFlagFrame).getHeight());
        if (this.getIsHovered()) {
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.0375f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, IMGManager.getIMG(Images.topFlagFrame).getWidth(), IMGManager.getIMG(Images.topFlagFrame).getHeight());
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.425f));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, IMGManager.getIMG(Images.topFlagFrame).getWidth(), IMGManager.getIMG(Images.topFlagFrame).getHeight() / 5);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.topFlagFrame).getHeight() / 5 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, IMGManager.getIMG(Images.topFlagFrame).getWidth(), IMGManager.getIMG(Images.topFlagFrame).getHeight() / 5, false, true);
            oSB.setColor(Color.WHITE);
        }
        if (isActive) {
            IMGManager.getIMG(Images.topFlagFrameH).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY);
        } else {
            IMGManager.getIMG(Images.topFlagFrame).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY);
        }
        try {
            oSB.setColor(new Color((float)CFG.core.getCiv(CFG.getActiveCivInfoId()).getR() / 255.0f, (float)CFG.core.getCiv(CFG.getActiveCivInfoId()).getG() / 255.0f, (float)CFG.core.getCiv(CFG.getActiveCivInfoId()).getB() / 255.0f, 0.725f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (int)((float)CFG.PADD * 1.25f), IMGManager.getIMG(Images.topFlagFrame).getHeight() - 2);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (int)((float)CFG.PADD * 1.25f), 1);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() + iTranslateX, this.getPosY() + IMGManager.getIMG(Images.topFlagFrame).getHeight() - 2 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (int)((float)CFG.PADD * 1.25f), 1);
            oSB.setColor(CFG.COLOR_FLAG_FRAME);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (int)((float)CFG.PADD * 1.25f), 1);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() + iTranslateX, this.getPosY() + IMGManager.getIMG(Images.topFlagFrame).getHeight() - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (int)((float)CFG.PADD * 1.25f), 1);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            // empty catch block
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public final Color getColorE(boolean isActive) {
        return isActive ? new Color(0.941f, 1.0f, 0.0f, 1.0f) : (this.getIsClickable() ? new Color(0.376f, 0.388f, 0.376f, 1.0f) : new Color(0.674f, 0.09f, 0.066f, 0.5f));
    }

    public Image getFlag() {
        return CFG.getActiveCivFlag();
    }
}

