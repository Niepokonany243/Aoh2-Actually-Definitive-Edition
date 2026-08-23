
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBudgetTitle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextBudgetTitle_TextLeft
extends TextBudgetTitle {
    public String leftText;
    public int iconLeft;

    public TextBudgetTitle_TextLeft(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, String textLeft, int iconLeft) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight);
        this.leftText = textLeft;
        this.iconLeft = iconLeft;
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        if (isActive) {
            oSB.setColor(new Color(0.16f, 0.15f, 0.12f, 0.5f));
        } else if (this.getIsHovered()) {
            oSB.setColor(new Color(0.16f, 0.15f, 0.12f, 0.35f));
        } else {
            oSB.setColor(new Color(0.16f, 0.15f, 0.12f, 0.25f));
        }
        Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosXE() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(CFG.COLOR_NEW_GAME_EDGE_LINE.r, CFG.COLOR_NEW_GAME_EDGE_LINE.g, CFG.COLOR_NEW_GAME_EDGE_LINE.b, 0.55f));
        Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 1.0f);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.35f));
        Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosXE() + 1 + iTranslateX, this.getPosY() + 1 + iTranslateY, this.getWidthE() - 2, this.getHeightE() - 2, 1.0f);
        oSB.setColor(Color.WHITE);
        if (Menu_InGame_Civ.getUseMenu_UI2()) {
            Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + this.getWidthE() - this.getTextWidthU() - CFG.PADD * 2 + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, this.getColor(isActive));
        } else {
            Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + (this.getWidthE() - this.getTextWidthU()) / 2 + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, this.getColor(isActive));
        }
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(this.iconLeft).draw(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(this.iconLeft).getHeight() / 2 + iTranslateY);
        Renderer.drawTextWithShadow(oSB, this.fontID, this.leftText, this.getPosXE() + CFG.PADD * 3 + IMGManager.getIMG(this.iconLeft).getWidth() + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, this.getColor(isActive));
    }
}

