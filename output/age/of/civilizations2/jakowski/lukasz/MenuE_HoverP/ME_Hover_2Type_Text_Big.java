/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.MenuE_HoverP;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ME_Hover_2Type_Text_Big
implements ME_Hover_2Type {
    private String sText;
    private int iTextWidth;
    private Color oColor;

    public ME_Hover_2Type_Text_Big(String sText) {
        this.init(sText, new Color(0.9843137f, 0.9843137f, 0.9843137f, 1.0f));
    }

    public ME_Hover_2Type_Text_Big(String sText, Color nColor) {
        this.init(sText, nColor);
    }

    private final void init(String sText, Color oColor) {
        this.sText = sText;
        this.oColor = oColor;
        CFG.glyphLay.setText(CFG.fontMain.get(0), sText);
        this.iTextWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha) {
        Renderer.drawTextWithShadowAlpha(oSB, this.sText, nPosX, nPosY + CFG.PADD + IMGManager.getIMG(Images.flagRect2Mask).getHeight() / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2, new Color(this.oColor.r, this.oColor.g, this.oColor.b, nAlpha));
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha, int iMaxWidth) {
        Renderer.drawTextWithShadowAlpha(oSB, this.sText, nPosX, nPosY + CFG.PADD + IMGManager.getIMG(Images.flagRect2Mask).getHeight() / 2 - CFG.TEXT_HEIGHT_DEFAULT / 2, new Color(this.oColor.r, this.oColor.g, this.oColor.b, nAlpha));
    }

    @Override
    public int getWidth() {
        return this.iTextWidth;
    }

    @Override
    public int getHeight() {
        return IMGManager.getIMG(Images.flagRect2Mask).getHeight() + CFG.PADD;
    }
}

