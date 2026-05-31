/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextScale
extends Text {
    private float fScale = 1.0f;

    public TextScale(String sText, int iPosX, int iPosY, float nScale) {
        super(sText, iPosX, iPosY);
        this.fScale = nScale;
    }

    public TextScale(String sText, int iTextPositionX, int iPosX, int iPosY, float nScale) {
        super(sText, iTextPositionX, iPosX, iPosY, (int)((float)CFG.TEXT_HEIGHT_DEFAULT * nScale));
        this.fScale = nScale;
    }

    public TextScale(String sText, int iTextPositionX, int iPosX, int iPosY, int iHeight, float nScale) {
        super(sText, iTextPositionX, iPosX, iPosY, iHeight);
        this.fScale = nScale;
    }

    public TextScale(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, float nScale) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight, CFG.FONT_BOLD_SMALL);
        this.fScale = nScale;
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, this.sText, this.getPosXE() + (this.iTextPositionX != 0 ? (this.getWidthE() - this.getTextWidthU()) / 2 : 0) + iTranslateX, this.getPosY() + (this.getHeightE() - this.iTextHeight) / 2 + iTranslateY, this.getColor(isActive));
    }
}

