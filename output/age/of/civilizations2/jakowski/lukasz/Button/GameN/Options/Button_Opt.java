/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button.GameN.Options;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Opt
extends Button_Classic {
    public Button_Opt(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, CFG.FONT_BOLD_SMALL);
    }

    public Button_Opt(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable, boolean checkboxState) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, checkboxState, CFG.FONT_BOLD_SMALL);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.pix255).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY - IMGManager.getIMG(Images.pix255).getHeight(), this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, isActive ? 0.775f : (this.getIsHovered() ? 0.675f : 0.475f)));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthE() / 2, this.getHeightE(), false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX + this.getWidthE() - this.getWidthE() / 2, this.getPosY() + iTranslateY - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthE() / 2, this.getHeightE(), true, false);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.45f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY - IMGManager.getIMG(Images.gradient).getHeight(), this.getWidthE(), this.getHeightE() / 5);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.375f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY + this.getHeightE() - this.getHeightE() / 5 - IMGManager.getIMG(Images.gradient).getHeight(), this.getWidthE(), this.getHeightE() / 5, false, true);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, isActive || this.getIsHovered() ? 0.625f : 0.475f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY - IMGManager.getIMG(Images.line32Off1).getHeight(), this.getWidthE(), 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), this.getWidthE(), 1);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.275f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getWidthE() / 4 + iTranslateX, this.getPosY() + iTranslateY - IMGManager.getIMG(Images.line32Off1).getHeight(), this.getWidthE() / 2, 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getWidthE() / 4 + iTranslateX, this.getPosY() + iTranslateY + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), this.getWidthE() / 2, 1);
        if (this.getIsHovered() || isActive) {
            oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.215f));
            IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY - IMGManager.getIMG(Images.line32Vertical).getHeight(), 1, this.getHeightE());
            IMGManager.getIMG(Images.line32Vertical).drawO(oSB, this.getPosXE() + this.getWidthE() - 1 + iTranslateX, this.getPosY() + iTranslateY - IMGManager.getIMG(Images.line32Vertical).getHeight(), 1, this.getHeightE());
        }
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.175f));
        CFG.drawRect(oSB, this.getPosXE() + iTranslateX - 1, this.getPosY() + iTranslateY - 2, this.getWidthE() + 2, this.getHeightE() + 2);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.getTextPosElem() < 0) {
            if (isActive) {
                Renderer.drawText(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
            } else {
                Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
            }
        } else if (isActive) {
            Renderer.drawText(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        } else {
            Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.getTextPosElem() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        }
    }

    @Override
    public ButtonM.Checkbox buildCheckbox() {
        if (this.checkbox) {
            return new ButtonM.Checkbox(){

                @Override
                public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
                    if (Button_Opt.this.getCheckboxSt()) {
                        oSB.setColor(CFG.COLOR_TEXT_CHECKBOX_TRUE);
                    } else {
                        oSB.setColor(CFG.COLOR_TEXT_CHECKBOX_FALSE);
                    }
                    IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Button_Opt.this.getPosXE() + iTranslateX, Button_Opt.this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY + 1, Button_Opt.this.getWidthE(), Button_Opt.this.getHeightE() - 3);
                    oSB.setColor(Color.WHITE);
                }
            };
        }
        return new ButtonM.Checkbox(){

            @Override
            public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
            }
        };
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
    }
}

