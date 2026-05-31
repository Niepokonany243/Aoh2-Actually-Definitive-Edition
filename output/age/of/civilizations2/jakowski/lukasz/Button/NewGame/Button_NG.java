/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.NewGame;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Main;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_NG
extends Button_Classic_LR_Main {
    private String sDesc;
    public int iDescWidth = 0;

    public Button_NG(String sDesc, String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable);
        this.sDesc = sDesc;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), sDesc);
        this.iDescWidth = (int)CFG.glyphLay.width;
    }

    public Button_NG(String sDesc, String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable, boolean checkboxState) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, checkboxState);
        this.sDesc = sDesc;
        CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), sDesc);
        this.iDescWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (CFG.settingsGD.BETTER_UI) {
            super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
            return;
        }
        this.setButtonAlpha(oSB, isActive);
        if (isActive) {
            IMGManager.getIMG(Images.btnHMenuH).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), true, false);
        } else if (this.getIsHovered() && this.getIsClickable()) {
            IMGManager.getIMG(Images.btnMenuH).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), true, false);
        } else {
            IMGManager.getIMG(Images.btnMenuH).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), true, false);
        }
        oSB.setColor(Color.WHITE);
        if (this.getIsClickable() && this.getIsHovered() && !isActive && animationState >= 0) {
            if (animationState == 0) {
                float drawPerc = Math.min(1.0f * (float)(System.currentTimeMillis() - lTimeAnimation) / 750.0f, 1.0f);
                oSB.setColor(Button_NG.getColorLine());
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                if (lTimeAnimation < System.currentTimeMillis() - 750L) {
                    ++animationState;
                    lTimeAnimation = System.currentTimeMillis();
                }
            } else {
                float drawPerc = Math.min(1.0f * (float)(System.currentTimeMillis() - lTimeAnimation) / 750.0f, 1.0f);
                oSB.setColor(Button_NG.getColorLine());
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc) + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - CFG.PADD * 2 - (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                if (lTimeAnimation < System.currentTimeMillis() - 750L) {
                    animationState = 0;
                    lTimeAnimation = System.currentTimeMillis();
                }
            }
            CFG.setRenderO(true);
            oSB.setColor(Color.WHITE);
        }
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (CFG.settingsGD.BETTER_UI) {
            Color primary = BetterUI_Manager.getPrimaryColor();
            Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - this.getTextHeight() + iTranslateY, this.getColorE(isActive));
            Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.sDesc, this.getPosXE() + this.getWidthE() / 2 - this.iDescWidth / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, new Color(primary.r, primary.g, primary.b, 0.7f));
            return;
        }
        Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD - this.getTextHeight() + iTranslateY, this.getColorE(isActive));
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.sDesc, this.getPosXE() + this.getWidthE() / 2 - this.iDescWidth / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + iTranslateY, new Color(0.58f, 0.58f, 0.58f, 1.0f));
    }
}

