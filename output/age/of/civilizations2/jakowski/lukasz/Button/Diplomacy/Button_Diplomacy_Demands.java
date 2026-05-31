
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Diplomacy_Demands
extends ButtonStats {
    private int iCivA;
    private String sCivName;
    private int iCivNameWidth;

    public Button_Diplomacy_Demands(String sText, int nCiv, int iPosX, int iPosY, int iWidth) {
        super(sText, 0, iPosX, iPosY, iWidth, Math.max(CFG.BUTTON_H * 3 / 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4), false);
        this.iCivA = nCiv;
        this.row = !this.row;
        this.sCivName = CFG.core.getCiv(nCiv).getCivName() + ": ";
        CFG.glyphLay.setText(CFG.fontMain.get(this.fontID), this.sCivName);
        this.iCivNameWidth = (int)CFG.glyphLay.width;
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
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.25f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(Color.WHITE);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() * 3 / 5, false, false);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.275f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 4, this.getHeightE(), false, false);
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - this.getWidthE() / 4 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE() / 4, this.getHeightE(), true, false);
        super.drawButtonBGE(oSB, iTranslateX, iTranslateY, isActive);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.3f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD, false, false);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD, false, true);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, 0.45f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - 4, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.7f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + this.getHeightE() - 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE() - 4, 1);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        oSB.setColor(Color.WHITE);
        Core.drawFlagRect(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.flagRect2).getHeight() / 2 + iTranslateY, this.iCivA);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sCivName, this.getPosXE() + CFG.PADD * 3 + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, Color.WHITE);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD * 3 + this.iCivNameWidth + IMGManager.getIMG(Images.flagRect2).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
        oSB.setColor(Color.WHITE);
    }

    private final float getImageScale(int nImageID) {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() < 1.0f ? (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(nImageID).getHeight() : 1.0f;
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS);
    }

    @Override
    public int getSFXElem() {
        return SFXManager.SFX_CLICK2;
    }
}

