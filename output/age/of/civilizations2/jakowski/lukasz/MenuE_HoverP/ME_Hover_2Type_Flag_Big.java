/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.MenuE_HoverP;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ME_Hover_2Type_Flag_Big
implements ME_Hover_2Type {
    private int iCivID;
    private int offsetLeft = 0;
    private int offsetRight = 0;

    public ME_Hover_2Type_Flag_Big(int iCivID) {
        this.iCivID = iCivID;
        this.offsetLeft = 0;
        this.offsetRight = CFG.PADD;
    }

    public ME_Hover_2Type_Flag_Big(int iCivID, int offsetLeft) {
        this.iCivID = iCivID;
        this.offsetLeft = offsetLeft;
        this.offsetRight = CFG.PADD;
    }

    public ME_Hover_2Type_Flag_Big(int iCivID, int offsetLeft, int offsetRight) {
        this.iCivID = iCivID;
        this.offsetLeft = offsetLeft;
        this.offsetRight = offsetRight;
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha) {
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, nAlpha));
        Core.drawFlagRect(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD, this.iCivID);
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha, int iMaxWidth) {
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, nAlpha));
        Core.drawFlagRect(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD, this.iCivID);
    }

    @Override
    public int getWidth() {
        return this.offsetRight + this.offsetLeft + IMGManager.getIMG(Images.flagRect2Mask).getWidth();
    }

    @Override
    public int getHeight() {
        return IMGManager.getIMG(Images.flagRect2Mask).getHeight() + CFG.PADD;
    }
}

