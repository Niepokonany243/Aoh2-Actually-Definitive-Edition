
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextLeftSide
extends Text {
    public TextLeftSide(String sText, int iPosX, int iPosY) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        this.typeOfMenuElemUI = MenuElemUI.TypeOfMenuElemUI.TEXT;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setTextE(sText);
        this.updateTextPosition();
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, this.getColor(isActive));
    }

    @Override
    public int getPosXE() {
        return super.getPosXE() - this.getTextWidthU();
    }

    @Override
    public int getHeightE() {
        return CFG.TEXT_HEIGHT_DEFAULT;
    }

    @Override
    public int getWidthE() {
        return this.getTextWidthU();
    }

    @Override
    public Color getColor(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS_ACTIVE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS_HOVER : CFG.COLOR_TEXT_GRAY_NS) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
    }
}

