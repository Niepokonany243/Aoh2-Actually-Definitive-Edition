
package age.of.civilizations2.jakowski.lukasz.Button.Diplomacy;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Diplo_Actions
extends ButtonM {
    public Button_Diplo_Actions(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, boolean isClickable) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, isClickable, true, false, false);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (!CFG.menus.getVisible_InGame_Civ_Opinions()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.625f));
            IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2, true, false);
        }
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD, false, false);
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 + this.getHeightE() - 2 - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthE(), CFG.PADD, false, true);
        if (isActive || this.getIsHovered()) {
            oSB.setColor(new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.45f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE() - 2, true, false);
            oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD + iTranslateX, this.getPosY() + 1 - IMGManager.getIMG(Images.sliderGradient).getHeight() + iTranslateY, CFG.PADD, this.getHeightE() - 2, true, false);
        }
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        IMGManager.getIMG(Images.topDiplomacyPoints).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.topDiplomacyPoints).getWidth() - CFG.PADD - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.topDiplomacyPoints).getHeight() / 2 + iTranslateY);
        Renderer.drawText(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
    }
}

