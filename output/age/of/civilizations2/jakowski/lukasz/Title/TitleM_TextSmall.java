/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Title;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TitleM_TextSmall
extends TitleM {
    public TitleM_TextSmall(String sText, int iHeight, boolean moveable, boolean resizable) {
        super(sText, iHeight, moveable, resizable);
    }

    @Override
    public void drawText(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
        Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.sText, nPosX + nWidth / 2 - this.iTextWidth / 2 + iTranslateX, nPosY - this.iHeight + this.iHeight / 2 - this.iTextHeight / 2, new Color(0.92941177f, 0.99607843f, 1.0f, 1.0f));
    }

    @Override
    public void setText(String sText) {
        this.sText = sText;
        this.setTextWidth(-1);
        if (sText != null && this.getTextWidth() < 0) {
            CFG.glyphLay.setText(CFG.fontMain.get(CFG.FONT_BOLD_SMALL), sText);
            this.setTextWidth((int)CFG.glyphLay.width);
            this.setTextHeight((int)CFG.glyphLay.height);
        }
    }
}

