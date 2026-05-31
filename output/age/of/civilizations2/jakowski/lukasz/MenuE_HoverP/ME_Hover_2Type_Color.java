/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.MenuE_HoverP;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ME_Hover_2Type_Color
implements ME_Hover_2Type {
    private Color oColor;
    private int offsetLeft = 0;
    private int offsetRight = 0;

    public ME_Hover_2Type_Color(Color oColor) {
        this.oColor = oColor;
        this.offsetLeft = 0;
        this.offsetRight = 0;
    }

    public ME_Hover_2Type_Color(Color oColor, int offsetLeft) {
        this.oColor = oColor;
        this.offsetLeft = offsetLeft;
        this.offsetRight = CFG.PADD;
    }

    public ME_Hover_2Type_Color(Color oColor, int offsetLeft, int offsetRight) {
        this.oColor = oColor;
        this.offsetLeft = offsetLeft;
        this.offsetRight = offsetRight;
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha) {
        oSB.setColor(new Color(this.oColor.r, this.oColor.g, this.oColor.b, nAlpha));
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD - IMGManager.getIMG(Images.pix255).getHeight() + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f), 2, (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha, int iMaxWidth) {
        oSB.setColor(new Color(this.oColor.r, this.oColor.g, this.oColor.b, nAlpha));
        IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD - IMGManager.getIMG(Images.pix255).getHeight() + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f), 2, (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
        oSB.setColor(Color.WHITE);
    }

    @Override
    public int getWidth() {
        return this.offsetRight + this.offsetLeft + 2;
    }

    @Override
    public int getHeight() {
        return CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD;
    }

    private final float getImageScale() {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)CFG.CIV_FLAG_HEIGHT;
    }
}

