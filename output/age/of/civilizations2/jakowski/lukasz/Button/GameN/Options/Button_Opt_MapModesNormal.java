
package age.of.civilizations2.jakowski.lukasz.Button.GameN.Options;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Options.Button_Opt;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Opt_MapModesNormal
extends Button_Opt {
    public int imgID = -1;
    private int iCurrent = 0;

    public Button_Opt_MapModesNormal(int iCurrent, String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable);
        this.iCurrent = iCurrent;
    }

    public Button_Opt_MapModesNormal(int iCurrent, String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable, boolean checkboxState) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, checkboxState);
        this.iCurrent = iCurrent;
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.35f));
        IMGManager.getIMG(Images.pix255).draw2O(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY - IMGManager.getIMG(Images.pix255).getHeight(), this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(CFG.COLOR_BOX_GRADIENT.r, CFG.COLOR_BOX_GRADIENT.g, CFG.COLOR_BOX_GRADIENT.b, isActive ? 0.225f : (this.getIsHovered() ? 0.175f : 0.4f)));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthE() / 2, this.getHeightE(), false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX + this.getWidthE() - this.getWidthE() / 2, this.getPosY() + iTranslateY - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthE() / 2, this.getHeightE(), true, false);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.45f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY - IMGManager.getIMG(Images.gradient).getHeight(), this.getWidthE(), this.getHeightE() / 5);
        oSB.setColor(0.0f, 0.0f, 0.0f, 0.375f);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY + this.getHeightE() - this.getHeightE() / 5 - IMGManager.getIMG(Images.gradient).getHeight(), this.getWidthE(), this.getHeightE() / 5, false, true);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, isActive || this.getIsHovered() ? 0.4f : 0.3f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthE(), 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY + this.getHeightE() - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthE(), 1);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthE(), 1, true, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY + this.getHeightE() - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), this.getWidthE(), 1, true, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, isActive || this.getIsHovered() ? 0.325f : 0.225f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY - IMGManager.getIMG(Images.line32Off1).getHeight(), this.getWidthE(), 1);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), this.getWidthE(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.175f));
        CFG.drawRect(oSB, this.getPosXE() + iTranslateX - 1, this.getPosY() + iTranslateY - 2, this.getWidthE() + 2, this.getHeightE() + 2);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public ButtonM.Checkbox buildCheckbox() {
        if (this.checkbox) {
            return new ButtonM.Checkbox(){

                @Override
                public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
                    if (Button_Opt_MapModesNormal.this.getCheckboxSt()) {
                        oSB.setColor(CFG.COLOR_TEXT_CHECKBOX_TRUE);
                    } else {
                        oSB.setColor(CFG.COLOR_TEXT_CHECKBOX_FALSE);
                    }
                    IMGManager.getIMG(Images.gradient).drawO(oSB, Button_Opt_MapModesNormal.this.getPosXE() + iTranslateX, Button_Opt_MapModesNormal.this.getPosY() + Button_Opt_MapModesNormal.this.getHeightE() / 4 + iTranslateY - IMGManager.getIMG(Images.gradient).getHeight(), Button_Opt_MapModesNormal.this.getWidthE(), Button_Opt_MapModesNormal.this.getHeightE() * 3 / 4, false, true);
                    oSB.setColor(0.0f, 0.0f, 0.0f, 0.375f);
                    IMGManager.getIMG(Images.gradient).drawO(oSB, Button_Opt_MapModesNormal.this.getPosXE() + iTranslateX, Button_Opt_MapModesNormal.this.getPosY() + iTranslateY + Button_Opt_MapModesNormal.this.getHeightE() - Button_Opt_MapModesNormal.this.getHeightE() / 5 - IMGManager.getIMG(Images.gradient).getHeight(), Button_Opt_MapModesNormal.this.getWidthE(), Button_Opt_MapModesNormal.this.getHeightE() / 5, false, true);
                    oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.65f));
                    IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Button_Opt_MapModesNormal.this.getPosXE() + iTranslateX, Button_Opt_MapModesNormal.this.getPosY() + iTranslateY - IMGManager.getIMG(Images.sliderGradient).getHeight(), Button_Opt_MapModesNormal.this.getWidthE() / 4, Button_Opt_MapModesNormal.this.getHeightE(), false, false);
                    IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Button_Opt_MapModesNormal.this.getPosXE() + Button_Opt_MapModesNormal.this.getWidthE() - Button_Opt_MapModesNormal.this.getWidthE() / 4 + iTranslateX, Button_Opt_MapModesNormal.this.getPosY() + iTranslateY - IMGManager.getIMG(Images.sliderGradient).getHeight(), Button_Opt_MapModesNormal.this.getWidthE() / 4, Button_Opt_MapModesNormal.this.getHeightE(), true, false);
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
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (this.imgID >= 0) {
            IMGManager.getIMG(this.imgID).draw(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(this.imgID).getHeight() / 2 + iTranslateY);
        }
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
    public boolean getCheckboxSt() {
        return this.getCurr() == CFG.mapModesManager.getActiveMapModeID();
    }

    @Override
    public void setCurr(int nCurrent) {
        this.iCurrent = nCurrent;
    }

    @Override
    public int getCurr() {
        return this.iCurrent;
    }

    @Override
    public void setText2(String sText) {
        try {
            this.imgID = Integer.parseInt(sText);
        }
        catch (Exception ex) {
            this.imgID = -1;
        }
    }

    @Override
    public final Color getColorE(boolean isActive) {
        return isActive || this.getCheckboxSt() ? CFG.COLOR_TEXT_TOP_VIEWS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_TOP_VIEWS_HOVER : CFG.COLOR_TEXT_TOP_VIEWS) : CFG.COLOR_TEXT_TOP_VIEWS_NOT_CLICKABLE);
    }
}

