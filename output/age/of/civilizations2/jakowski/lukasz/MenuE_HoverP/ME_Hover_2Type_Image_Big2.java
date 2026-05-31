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

public class ME_Hover_2Type_Image_Big2
implements ME_Hover_2Type {
    private int iImageID;
    private int offsetLeft;
    private int offsetRight;

    public ME_Hover_2Type_Image_Big2(int iImageID) {
        this.iImageID = iImageID;
        this.offsetLeft = 0;
        this.offsetRight = CFG.PADD;
    }

    public ME_Hover_2Type_Image_Big2(int iImageID, int offsetLeft) {
        this.iImageID = iImageID;
        this.offsetLeft = offsetLeft;
        this.offsetRight = CFG.PADD;
    }

    public ME_Hover_2Type_Image_Big2(int iImageID, int offsetLeft, int offsetRight) {
        this.iImageID = iImageID;
        this.offsetLeft = offsetLeft;
        this.offsetRight = offsetRight;
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha) {
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, nAlpha));
        IMGManager.getIMG(this.iImageID).draw(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD + IMGManager.getIMG(Images.flagRect2Mask).getHeight() / 2 - (int)((float)IMGManager.getIMG(this.iImageID).getHeight() * this.getImageScale() / 2.0f), (int)((float)IMGManager.getIMG(this.iImageID).getWidth() * this.getImageScale()), (int)((float)IMGManager.getIMG(this.iImageID).getHeight() * this.getImageScale()));
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha, int iMaxWidth) {
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, nAlpha));
        IMGManager.getIMG(this.iImageID).draw(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD + IMGManager.getIMG(Images.flagRect2Mask).getHeight() / 2 - (int)((float)IMGManager.getIMG(this.iImageID).getHeight() * this.getImageScale() / 2.0f), (int)((float)IMGManager.getIMG(this.iImageID).getWidth() * this.getImageScale()), (int)((float)IMGManager.getIMG(this.iImageID).getHeight() * this.getImageScale()));
    }

    @Override
    public int getWidth() {
        return this.offsetLeft + this.offsetRight + (int)((float)IMGManager.getIMG(this.iImageID).getWidth() * this.getImageScale());
    }

    @Override
    public int getHeight() {
        return IMGManager.getIMG(Images.flagRect2Mask).getHeight() + CFG.PADD;
    }

    private float getImageScale() {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)IMGManager.getIMG(this.iImageID).getHeight();
    }
}

