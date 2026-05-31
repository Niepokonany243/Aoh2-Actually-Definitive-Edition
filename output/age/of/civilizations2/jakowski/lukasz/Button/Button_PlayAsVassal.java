/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_PlayAsVassal
extends ButtonM {
    public Button_PlayAsVassal(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable, boolean checkboxState) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, true, true, checkboxState, null);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.textPosition.getTextPosition() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
    }

    @Override
    public ButtonM.Checkbox buildCheckbox() {
        if (this.checkbox) {
            return new ButtonM.Checkbox(){

                @Override
                public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
                    if (Button_PlayAsVassal.this.getCheckboxSt()) {
                        oSB.setColor(new Color(0.55f, 0.8f, 0.0f, 0.4f));
                    } else {
                        oSB.setColor(new Color(0.8f, 0.137f, 0.0f, 0.4f));
                    }
                    IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Button_PlayAsVassal.this.getPosXE() + Button_PlayAsVassal.this.getWidthE() - Button_PlayAsVassal.this.getWidthE() / 2 + iTranslateX, Button_PlayAsVassal.this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + 1 + iTranslateY, Button_PlayAsVassal.this.getWidthE() / 2, Button_PlayAsVassal.this.getHeightE() - 2, true, false);
                    oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.3f));
                    IMGManager.getIMG(Images.gradient).drawO(oSB, Button_PlayAsVassal.this.getPosXE() + iTranslateX, Button_PlayAsVassal.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + 1 + iTranslateY, Button_PlayAsVassal.this.getWidthE(), Button_PlayAsVassal.this.getHeightE() / 4, false, false);
                    IMGManager.getIMG(Images.gradient).drawO(oSB, Button_PlayAsVassal.this.getPosXE() + iTranslateX, Button_PlayAsVassal.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + Button_PlayAsVassal.this.getHeightE() - 1 + iTranslateY - Button_PlayAsVassal.this.getHeightE() / 4, Button_PlayAsVassal.this.getWidthE(), Button_PlayAsVassal.this.getHeightE() / 4, false, true);
                    oSB.setColor(Color.WHITE);
                    CFG.drawRect_InfoBox_Left(oSB, Button_PlayAsVassal.this.getPosXE() + iTranslateX, Button_PlayAsVassal.this.getPosY() + iTranslateY, Button_PlayAsVassal.this.getWidthE(), Button_PlayAsVassal.this.getHeightE());
                    if (Button_PlayAsVassal.this.getCheckboxSt()) {
                        IMGManager.getIMG(Images.iconTrue).drawO(oSB, Button_PlayAsVassal.this.getPosXE() + Button_PlayAsVassal.this.getWidthE() - CFG.PADD - IMGManager.getIMG(Images.iconTrue).getWidth() + iTranslateX, Button_PlayAsVassal.this.getPosY() + Button_PlayAsVassal.this.getHeightE() / 2 - IMGManager.getIMG(Images.iconTrue).getHeight() / 2 + iTranslateY);
                    } else {
                        IMGManager.getIMG(Images.iconFalse).drawO(oSB, Button_PlayAsVassal.this.getPosXE() + Button_PlayAsVassal.this.getWidthE() - CFG.PADD - IMGManager.getIMG(Images.iconTrue).getWidth() + iTranslateX, Button_PlayAsVassal.this.getPosY() + Button_PlayAsVassal.this.getHeightE() / 2 - IMGManager.getIMG(Images.iconFalse).getHeight() / 2 + iTranslateY);
                    }
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

