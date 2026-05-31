
package age.of.civilizations2.jakowski.lukasz.Button.Game;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.CFG;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Game_TextTwoLines
extends Button_Game {
    private String sTextBot;
    private int iTextBotWidth = 0;

    public Button_Game_TextTwoLines(String sText, String sTextBot, int iTextPositionX, int iPosX, int iPosY, int nWidth, boolean isClickable) {
        super(sText, iTextPositionX, iPosX, iPosY, nWidth, isClickable);
        this.sTextBot = sTextBot;
        CFG.fontMain.get(0).getData().setScale(0.8f);
        CFG.glyphLay.setText(CFG.fontMain.get(0), sTextBot);
        this.iTextBotWidth = (int)CFG.glyphLay.width;
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        if (isActive) {
            CFG.drawTextDefault(oSB, this.getTextToDrawElem(), this.getPosXE() + (this.getWidthE() - super.getTextWidthU()) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD / 2 - this.iTextHeight + iTranslateY, this.getColorE(isActive));
        } else {
            CFG.drawTextDefaultWithShadow(oSB, this.getTextToDrawElem(), this.getPosXE() + (this.getWidthE() - super.getTextWidthU()) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.PADD / 2 - this.iTextHeight + iTranslateY, this.getColorE(isActive));
        }
        CFG.fontMain.get(0).getData().setScale(0.8f);
        CFG.drawTextDefaultWithShadow(oSB, this.sTextBot, this.getPosXE() + (this.getWidthE() - this.iTextBotWidth) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 + CFG.PADD + (CFG.TEXT_HEIGHT_DEFAULT - CFG.TEXT_HEIGHT_DEFAULT) / 2 + iTranslateY, new Color(0.46f, 0.46f, 0.46f, 1.0f));
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    @Override
    public int getTextWidthU() {
        return super.getTextWidthU() > this.iTextBotWidth ? super.getTextWidthU() : this.iTextBotWidth;
    }

    @Override
    public int getTextPosElem() {
        return super.getTextWidthU();
    }

    @Override
    public Color getColorE(boolean isActive) {
        return isActive ? CFG.COLOR_HOVER_TITLE : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_BUTTON_GAME_TEXT_HOVERED : CFG.COLOR_BUTTON_GAME_TEXT) : CFG.COLOR_BUTTON_GAME_TEXT_NOT_CLICKABLE);
    }
}

