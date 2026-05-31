
package age.of.civilizations2.jakowski.lukasz.Button.Game;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Game_ExtraText
extends Button_Game {
    public String textB = "";
    public int iTextBWidth = 0;
    public int lastActiveProvinceID = -1;
    public int fontID2 = CFG.FONT_REGULAR_SMALL;

    public Button_Game_ExtraText(String sText, int iTextPositionX, int iPosX, int iPosY, int nWidth) {
        super(sText, iTextPositionX, iPosX, iPosY, nWidth);
    }

    public Button_Game_ExtraText(String sText, int iTextPositionX, int iPosX, int iPosY, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, isClickable);
    }

    public Button_Game_ExtraText(String sText, int iTextPositionX, int iPosX, int iPosY, int nWidth, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, nWidth, isClickable);
    }

    public Button_Game_ExtraText(String sText, int iTextPositionX, int iPosX, int iPosY, boolean isClickable, boolean isVisible) {
        super(sText, iTextPositionX, iPosX, iPosY, isClickable, isVisible);
    }

    public void updateText() {
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        Renderer.drawText(oSB, this.fontID2, this.textB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() - this.iTextHeight - CFG.PADD + iTranslateY, this.getColorE(isActive));
        super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
        this.updateText();
    }
}

