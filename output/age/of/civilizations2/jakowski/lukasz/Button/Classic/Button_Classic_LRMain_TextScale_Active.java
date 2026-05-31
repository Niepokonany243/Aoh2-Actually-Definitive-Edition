/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.Classic;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Main;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Classic_LRMain_TextScale_Active
extends Button_Classic_LR_Main {
    public Button_Classic_LRMain_TextScale_Active(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable);
    }

    public Button_Classic_LRMain_TextScale_Active(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable, boolean checkboxState) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, checkboxState);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(1.0f, 1.0f, 1.0f, 0.55f);
        if (!this.getIsClickable()) {
            oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.4f));
            IMGManager.getIMG(Images.btnMenuH).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE() - IMGManager.getIMG(Images.btnMenuH).getWidth());
            IMGManager.getIMG(Images.btnMenuH).drawO(oSB, this.getPosXE() + this.getWidthE() - IMGManager.getIMG(Images.btnMenuH).getWidth() + iTranslateX, this.getPosY() + iTranslateY, true);
        } else if (isActive) {
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
        if (this.getIsClickable() && !isActive && animationState >= 0) {
            if (animationState == 0) {
                float drawPerc = Math.min(1.0f * (float)(System.currentTimeMillis() - lTimeAnimation) / 750.0f, this.getIsHovered() ? 1.0f : 0.65f);
                oSB.setColor(Button_Classic_LRMain_TextScale_Active.getColorLine());
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, (int)((float)(this.getWidthE() - CFG.PADD * 2) * drawPerc), 1);
                if (lTimeAnimation < System.currentTimeMillis() - 750L) {
                    ++animationState;
                    lTimeAnimation = System.currentTimeMillis();
                }
            } else {
                float drawPerc = Math.min(1.0f * (float)(System.currentTimeMillis() - lTimeAnimation) / 750.0f, this.getIsHovered() ? 1.0f : 0.65f);
                oSB.setColor(Button_Classic_LRMain_TextScale_Active.getColorLine());
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
        if (isActive) {
            Renderer.drawText(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
        } else {
            Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
        }
    }
}

