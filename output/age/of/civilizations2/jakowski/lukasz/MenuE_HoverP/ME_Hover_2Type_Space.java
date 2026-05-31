/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.MenuE_HoverP;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ME_Hover_2Type_Space
implements ME_Hover_2Type {
    private static final String sText = "---";
    private int iTextWidth;

    public ME_Hover_2Type_Space() {
        CFG.glyphLay.setText(CFG.fontMain.get(0), sText);
        this.iTextWidth = (int)CFG.glyphLay.width;
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha) {
        CFG.drawTextDefault(oSB, sText, nPosX, nPosY + CFG.PADD + (CFG.TEXT_HEIGHT_DEFAULT - CFG.TEXT_HEIGHT_DEFAULT) / 2, new Color(0.85f, 0.85f, 0.85f, nAlpha));
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha, int iMaxWidth) {
        oSB.setColor(new Color(Colors.HOVER_LINE1.r, Colors.HOVER_LINE1.g, Colors.HOVER_LINE1.b, Colors.HOVER_LINE1.a * nAlpha));
        Images.pix.draw(oSB, nPosX + CFG.PADD * 2, nPosY + CFG.PADD / 2 + 1, iMaxWidth - CFG.PADD * 4, 1);
        IMGManager.getIMG(Images.gradientHorizontal).draw(oSB, nPosX, nPosY + CFG.PADD / 2 + 1, CFG.PADD * 2, 1, true, false);
        IMGManager.getIMG(Images.gradientHorizontal).draw(oSB, nPosX + iMaxWidth - CFG.PADD * 2, nPosY + CFG.PADD / 2 + 1, CFG.PADD * 2, 1);
        oSB.setColor(new Color(Colors.HOVER_LINE2.r, Colors.HOVER_LINE2.g, Colors.HOVER_LINE2.b, Colors.HOVER_LINE2.a * nAlpha));
        Images.pix.draw(oSB, nPosX + CFG.PADD * 2, nPosY + CFG.PADD / 2 + 2, iMaxWidth - CFG.PADD * 4, 1);
        IMGManager.getIMG(Images.gradientHorizontal).draw(oSB, nPosX, nPosY + CFG.PADD / 2 + 2, CFG.PADD * 2, 1, true, false);
        IMGManager.getIMG(Images.gradientHorizontal).draw(oSB, nPosX + iMaxWidth - CFG.PADD * 2, nPosY + CFG.PADD / 2 + 2, CFG.PADD * 2, 1);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public int getWidth() {
        return this.iTextWidth;
    }

    @Override
    public int getHeight() {
        return CFG.PADD;
    }
}

