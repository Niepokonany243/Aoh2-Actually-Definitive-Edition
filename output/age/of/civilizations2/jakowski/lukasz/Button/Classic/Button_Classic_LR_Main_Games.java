/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Classic;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Classic_LR_Main_Games
extends Button_Classic {
    private long lTime = System.currentTimeMillis();
    private float fAlphaMod = 0.0f;
    private boolean backAnimation = false;

    public Button_Classic_LR_Main_Games(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (CFG.settingsGD.BETTER_UI) {
            Color primary = BetterUI_Manager.getPrimaryColor();
            Color bg = BetterUI_Manager.getBackgroundColor(0.85f);
            
            if (isActive) {
                oSB.setColor(primary.r, primary.g, primary.b, 0.5f);
            } else if (this.getIsHovered()) {
                oSB.setColor(primary.r, primary.g, primary.b, 0.3f);
            } else {
                oSB.setColor(bg);
            }
            Images.pix.draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());

            // Add full borders to main clickable buttons
            BetterUI_Manager.drawBetterButtonBorder(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), this.getIsHovered(), isActive, this.getIsClickable());

            oSB.setColor(Color.WHITE);
            return;
        }
        oSB.setColor(1.0f, 1.0f, 1.0f, 0.55f);
        if (isActive) {
            IMGManager.getIMG(Images.btnHMenuH).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.btnHMenuH).getWidth());
            IMGManager.getIMG(Images.btnHMenuH).drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.btnHMenuH).getWidth() + iTranslateX, this.getPosY() + iTranslateY, true);
        } else if (this.getIsHovered() && this.getIsClickable()) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.485f));
            IMGManager.getIMG(Images.btnMenuH).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.btnMenuH).getWidth());
            IMGManager.getIMG(Images.btnMenuH).drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.btnMenuH).getWidth() + iTranslateX, this.getPosY() + iTranslateY, true);
        } else {
            IMGManager.getIMG(Images.btnMenuH).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.btnMenuH).getWidth());
            IMGManager.getIMG(Images.btnMenuH).drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.btnMenuH).getWidth() + iTranslateX, this.getPosY() + iTranslateY, true);
        }
        if (!isActive) {
            if (this.lTime < System.currentTimeMillis() - 70L) {
                if (this.backAnimation) {
                    this.fAlphaMod -= 0.02f;
                    if (this.fAlphaMod < 0.0f) {
                        this.backAnimation = false;
                    }
                } else {
                    this.fAlphaMod += 0.02f;
                    if (this.fAlphaMod >= 0.35f) {
                        this.backAnimation = true;
                        this.fAlphaMod = 0.35f;
                    }
                }
                this.lTime = System.currentTimeMillis();
                CFG.setRenderO(true);
            }
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f - this.fAlphaMod));
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 2 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 8);
            IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 - this.getHeightE() / 8 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() / 8, false, true);
        }
        if (this.getIsClickable() && this.getIsHovered() && !isActive && animationState >= 0) {
            if (animationState == 0) {
                float drawPerc = Math.min(1.0f * (float)(System.currentTimeMillis() - lTimeAnimation) / 750.0f, 1.0f);
                oSB.setColor(Button_Classic_LR_Main_Games.getColorLine());
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                if (lTimeAnimation < System.currentTimeMillis() - 750L) {
                    ++animationState;
                    lTimeAnimation = System.currentTimeMillis();
                }
            } else {
                float drawPerc = Math.min(1.0f * (float)(System.currentTimeMillis() - lTimeAnimation) / 750.0f, 1.0f);
                oSB.setColor(Button_Classic_LR_Main_Games.getColorLine());
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
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, isActive ? 0.0f : (this.getIsHovered() ? 0.3f : 0.2f)));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (this.getWidthE() - CFG.PADD * 8) / 2 - this.getTextWidthU() / 2, 1, true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 + this.getTextWidthU() / 2 + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (this.getWidthE() - CFG.PADD * 8) / 2 - this.getTextWidthU() / 2, 1, false, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, isActive ? 0.0f : (this.getIsHovered() ? 0.3f : 0.175f)));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() - 1 + this.getHeightE() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (this.getWidthE() - CFG.PADD * 8) / 2 - this.getTextWidthU() / 2, 1, true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 + this.getTextWidthU() / 2 + CFG.PADD * 2 + iTranslateX, this.getPosY() - 1 + this.getHeightE() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (this.getWidthE() - CFG.PADD * 8) / 2 - this.getTextWidthU() / 2, 1, false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + 1 + this.getHeightE() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (this.getWidthE() - CFG.PADD * 8) / 2 - this.getTextWidthU() / 2, 1, true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 + this.getTextWidthU() / 2 + CFG.PADD * 2 + iTranslateX, this.getPosY() + 1 + this.getHeightE() / 2 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, (this.getWidthE() - CFG.PADD * 8) / 2 - this.getTextWidthU() / 2, 1, false, false);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
    }
}

