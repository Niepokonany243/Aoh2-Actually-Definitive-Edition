/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Province_Port_Center {
    public int iShiftX;
    public int iShiftY;

    public Province_Port_Center() {
        this.iShiftX = 0;
        this.iShiftY = 0;
    }

    public Province_Port_Center(int iShiftX, int iShiftY) {
        this.iShiftX = iShiftX;
        this.iShiftY = iShiftY;
    }

    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nScale) {
        IMGManager.getIMG(Images.portIco).drawO(oSB, nPosX + (int)((float)this.iShiftX * nScale) - IMGManager.getIMG(Images.portIco).getWidth() / 2, nPosY + (int)((float)this.iShiftY * nScale) - IMGManager.getIMG(Images.portIco).getHeight() / 2);
    }

    public final int getShiftX() {
        return this.iShiftX;
    }

    public final int getShiftY() {
        return this.iShiftY;
    }
}

