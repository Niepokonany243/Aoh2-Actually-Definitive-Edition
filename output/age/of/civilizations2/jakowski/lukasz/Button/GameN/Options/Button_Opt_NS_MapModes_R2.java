/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.GameN.Options;

import age.of.civilizations2.jakowski.lukasz.Button.GameN.Options.Button_Opt_MapModes_R;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Opt_NS_MapModes_R2
extends Button_Opt_MapModes_R {
    public Button_Opt_NS_MapModes_R2(int iCurrent, String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(iCurrent, sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable);
    }

    public Button_Opt_NS_MapModes_R2(int iCurrent, String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable, boolean checkboxState, int posID) {
        super(iCurrent, sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, checkboxState, posID);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.pix255).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + CFG.PADD / 2 + iTranslateY - IMGManager.getIMG(Images.pix255).getHeight(), this.getWidthE(), this.getHeightE() - CFG.PADD);
        oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, isActive ? 0.225f : (this.getIsHovered() ? 0.175f : 0.225f)));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + CFG.PADD / 2 + iTranslateY - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthE() / 2, this.getHeightE() - CFG.PADD, false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX + this.getWidthE() - this.getWidthE() / 2, this.getPosY() + CFG.PADD / 2 + iTranslateY - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthE() / 2, this.getHeightE() - CFG.PADD, true, false);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.45f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + CFG.PADD / 2 + iTranslateY - IMGManager.getIMG(Images.gradient).getHeight(), this.getWidthE(), (this.getHeightE() - CFG.PADD) / 5);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.375f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + CFG.PADD / 2 + iTranslateY + (this.getHeightE() - CFG.PADD) - (this.getHeightE() - CFG.PADD) / 5 - IMGManager.getIMG(Images.gradient).getHeight(), this.getWidthE(), (this.getHeightE() - CFG.PADD) / 5, false, true);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, isActive || this.getIsHovered() ? 0.325f : 0.225f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + CFG.PADD / 2 + iTranslateY - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthE(), 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + CFG.PADD / 2 + iTranslateY + (this.getHeightE() - CFG.PADD) - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthE(), 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + CFG.PADD / 2 + iTranslateY - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthE(), 1, true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + CFG.PADD / 2 + iTranslateY + (this.getHeightE() - CFG.PADD) - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthE(), 1, true, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.175f));
        CFG.drawRect(oSB, this.getPosXE() + iTranslateX - 1, this.getPosY() + CFG.PADD / 2 + iTranslateY - 2, this.getWidthE() + 2, this.getHeightE() - CFG.PADD + 2);
        oSB.setColor(Color.WHITE);
    }
}

