/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScrollable;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextScrollable_BG
extends TextScrollable {
    public TextScrollable_BG(String sText, int iPosX, int iPosY, int iWidth, Color textColor) {
        super(sText, iPosX, iPosY, iWidth, textColor);
    }

    public TextScrollable_BG(String sText, int iPosX, int iPosY, int iWidth, Color textColor, float nTextScale) {
        super(sText, iPosX, iPosY, iWidth, textColor, nTextScale);
    }

    public TextScrollable_BG(String sText, int iPosX, int iPosY, int iWidth, int iHeight, Color textColor, float nTextScale) {
        super(sText, iPosX, iPosY, iWidth, iHeight, textColor, nTextScale);
    }

    public TextScrollable_BG(String sText, int iPosX, int iPosY, int iWidth, int iHeight, Color textColor, float nTextScale, int iTextPos) {
        super(sText, iPosX, iPosY, iWidth, iHeight, textColor, nTextScale, iTextPos);
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        oSB.setColor(new Color(Colors.COLOR_STATS_RECT_BG.r, Colors.COLOR_STATS_RECT_BG.g, Colors.COLOR_STATS_RECT_BG.b, 0.5f));
        Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE() + CFG.PADD * 2, this.getHeightE(), 1.0f);
        oSB.setColor(Color.WHITE);
        oSB.setColor(new Color(Colors.COLOR_GRADIENT.r, Colors.COLOR_GRADIENT.g, Colors.COLOR_GRADIENT.b, 0.4f));
        IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE() + CFG.PADD * 2, this.getHeightE() / 2, false, true);
        IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() / 2 + iTranslateY, this.getWidthE() + CFG.PADD * 2, this.getHeightE() / 2, false, false);
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - 2 + iTranslateY, this.getWidthE() + CFG.PADD * 2, 1);
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + 1 + iTranslateY, this.getWidthE() + CFG.PADD * 2, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.2f));
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE() + CFG.PADD * 2, 1);
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() - CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - 1 + iTranslateY, this.getWidthE() + CFG.PADD * 2, 1);
        oSB.setColor(Color.WHITE);
        super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
    }
}

