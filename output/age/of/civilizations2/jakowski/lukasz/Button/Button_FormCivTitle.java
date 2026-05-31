
package age.of.civilizations2.jakowski.lukasz.Button;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_FormCivTitle
extends ButtonM {
    public Button_FormCivTitle(String sText, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable, boolean checkboxState) {
        this.fontID = CFG.FONT_BOLD;
        super.init(sText, -1, iPosX, iPosY, iWidth, iHeight, isClickable, true, true, checkboxState, null);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.55f));
        } else if (this.getIsHovered()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DARK_BLUE.r, CFG.COLOR_GRADIENT_DARK_BLUE.g, CFG.COLOR_GRADIENT_DARK_BLUE.b, 0.65f));
        } else {
            oSB.setColor(CFG.COLOR_GRADIENT_DARK_BLUE);
        }
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_LIGHTER_DARK_BLUE.r, CFG.COLOR_GRADIENT_LIGHTER_DARK_BLUE.g, CFG.COLOR_GRADIENT_LIGHTER_DARK_BLUE.b, 0.5f));
        IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(CFG.COLOR_FLAG_FRAME);
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), 1);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + (this.getWidthE() - this.getTextWidthU()) / 2 + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, this.getColorE(isActive));
    }

    private final float getImageScale(int nImageID) {
        return (float)(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 0.7f / (float)IMGManager.getIMG(nImageID).getHeight() < 1.0f ? (float)(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 0.7f / (float)IMGManager.getIMG(nImageID).getHeight() : 1.0f;
    }

    @Override
    public ButtonM.Checkbox buildCheckbox() {
        return new ButtonM.Checkbox(){

            @Override
            public void drawCheckBox(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean scrollableY) {
            }
        };
    }

    @Override
    public Color getColorE(boolean isActive) {
        if (this.getCheckboxSt()) {
            return isActive ? CFG.COLOR_POSITIVE_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_POSITIVE_HOVER : CFG.COLOR_POSITIVE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
        }
        return isActive ? CFG.COLOR_NEGATIVE_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_NEGATIVE_HOVER : CFG.COLOR_NEGATIVE_2) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
    }
}

