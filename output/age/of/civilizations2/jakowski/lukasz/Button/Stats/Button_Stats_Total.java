
package age.of.civilizations2.jakowski.lukasz.Button.Stats;

import age.of.civilizations2.jakowski.lukasz.Button.Stats.ButtonStats;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Stats_Total
extends ButtonStats {
    public Button_Stats_Total(String sText, int iTextPosX, int iPosX, int iPosY, int iWidth, int iHeight) {
        super(sText, iTextPosX, iPosX, iPosY, iWidth, iHeight, CFG.FONT_BOLD_SMALL);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextToDrawElem(), this.getPosXE() + this.textPosition.getTextPosition() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.iTextHeight / 2 + iTranslateY, this.getColorE(isActive));
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_TEXT_GRAY_NS : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : CFG.COLOR_TEXT_GRAY_NS_HOVER) : CFG.COLOR_BUTTON_MENU_TEXT_NOT_CLICKABLE);
    }
}

