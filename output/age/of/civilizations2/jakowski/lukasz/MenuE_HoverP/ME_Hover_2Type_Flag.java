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

public class ME_Hover_2Type_Flag
implements ME_Hover_2Type {
    private int iCivID;
    private int offsetLeft = 0;
    private int offsetRight = 0;

    public ME_Hover_2Type_Flag(int iCivID) {
        this.iCivID = iCivID;
        this.offsetLeft = 0;
        this.offsetRight = CFG.PADD;
    }

    public ME_Hover_2Type_Flag(int iCivID, int offsetLeft) {
        this.iCivID = iCivID;
        this.offsetLeft = offsetLeft;
        this.offsetRight = CFG.PADD;
    }

    public ME_Hover_2Type_Flag(int iCivID, int offsetLeft, int offsetRight) {
        this.iCivID = iCivID;
        this.offsetLeft = offsetLeft;
        this.offsetRight = offsetRight;
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha) {
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, nAlpha));
        try {
            if (this.iCivID >= 0) {
                CFG.core.getCiv(this.iCivID).getFlagC().drawO(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD - CFG.core.getCiv(this.iCivID).getFlagC().getHeight() + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f), (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
            } else {
                IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f), (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
            }
        }
        catch (IndexOutOfBoundsException e) {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f), (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
        }
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD - IMGManager.getIMG(Images.flagRectSmall).getHeight() + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f), (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha, int iMaxWidth) {
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, nAlpha));
        try {
            if (this.iCivID >= 0) {
                CFG.core.getCiv(this.iCivID).getFlagC().drawO(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD - CFG.core.getCiv(this.iCivID).getFlagC().getHeight() + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f), (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
            } else {
                IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f), (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
            }
        }
        catch (IndexOutOfBoundsException e) {
            IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f), (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
        }
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD - IMGManager.getIMG(Images.flagRectSmall).getHeight() + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale() / 2.0f), (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale()), (int)((float)CFG.CIV_FLAG_HEIGHT * this.getImageScale()));
    }

    @Override
    public int getWidth() {
        return this.offsetRight + this.offsetLeft + (int)((float)CFG.CIV_FLAG_WIDTH * this.getImageScale());
    }

    @Override
    public int getHeight() {
        return CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD;
    }

    private final float getImageScale() {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)CFG.CIV_FLAG_HEIGHT;
    }
}

