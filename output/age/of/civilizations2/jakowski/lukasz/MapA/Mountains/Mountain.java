/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.MapA.Mountains;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.io.Serializable;

public class Mountain
implements Serializable {
    private static final long serialVersionUID = 0L;
    private String sName = null;
    private int iPosX;
    private int iPosY;
    private int iElevation;

    public Mountain(String sName, int iElevation, int nPosX, int nPosY) {
        this.sName = sName;
        this.iElevation = iElevation;
        this.iPosX = nPosX;
        this.iPosY = nPosY;
    }

    public final void draw(SpriteBatch oSB, int nProvinceID, float nScale) {
        this.draw(oSB, nProvinceID, nScale, new Color(1.0f, 1.0f, 1.0f, 0.85f), Images.mount);
    }

    public final void draw(SpriteBatch oSB, int nProvinceID, float nScale, int nImageID) {
        this.draw(oSB, nProvinceID, nScale, new Color(1.0f, 1.0f, 1.0f, 0.85f), nImageID);
    }

    public final void draw(SpriteBatch oSB, int nProvinceID, float nScale, Color nColor) {
        this.draw(oSB, nProvinceID, nScale, nColor, Images.mount);
    }

    public final void draw(SpriteBatch oSB, int nProvinceID, float nScale, Color nColor, int nImageID) {
        IMGManager.getIMG(nImageID).drawO(oSB, (int)((float)(this.getPosX() * CFG.map.getMpB().getMapSc3() + CFG.core.getProv(nProvinceID).getTranslateProvPosX()) * nScale - (float)(IMGManager.getIMG(nImageID).getWidth() / 2)), (int)((float)(this.getPosY() * CFG.map.getMpB().getMapSc3() + CFG.map.getMpC().getPY()) * nScale) - IMGManager.getIMG(nImageID).getHeight() / 2);
        CFG.drawTextDefault(oSB, this.getName(), (int)((float)(this.getPosX() * CFG.map.getMpB().getMapSc3() + CFG.core.getProv(nProvinceID).getTranslateProvPosX()) * nScale + (float)(IMGManager.getIMG(nImageID).getWidth() / 2) + 1.0f), (int)((float)(this.getPosY() * CFG.map.getMpB().getMapSc3() + CFG.map.getMpC().getPY()) * nScale - (float)(IMGManager.getIMG(nImageID).getHeight() / 2) + (float)(IMGManager.getIMG(nImageID).getHeight() / 2) - (float)(CFG.ARMY_HEIGHT / 4) + 1.0f), nColor);
        CFG.drawTextDefault(oSB, "" + this.iElevation + "m", (int)((float)(this.getPosX() * CFG.map.getMpB().getMapSc3() + CFG.core.getProv(nProvinceID).getTranslateProvPosX()) * nScale + (float)(IMGManager.getIMG(nImageID).getWidth() / 2) + 1.0f), (int)((float)(this.getPosY() * CFG.map.getMpB().getMapSc3() + CFG.map.getMpC().getPY()) * nScale - (float)(IMGManager.getIMG(nImageID).getHeight() / 2) + (float)(IMGManager.getIMG(nImageID).getHeight() / 2) + (float)(CFG.ARMY_HEIGHT / 4) + 1.0f + (float)CFG.PADD), CFG.COLOR_NEUTRAL);
    }

    public final void drawImage(SpriteBatch oSB, int nProvinceID, float nScale) {
        IMGManager.getIMG(Images.mount).drawO(oSB, (int)((float)(this.getPosX() * CFG.map.getMpB().getMapSc3() + CFG.core.getProv(nProvinceID).getTranslateProvPosX()) * nScale - (float)(IMGManager.getIMG(Images.mount).getWidth() / 2)), (int)((float)(this.getPosY() * CFG.map.getMpB().getMapSc3() + CFG.map.getMpC().getPY()) * nScale) - IMGManager.getIMG(Images.mount).getHeight() / 2);
    }

    public final String getName() {
        return this.sName;
    }

    public final void setName(String sName) {
        this.sName = sName;
    }

    public final int getPosX() {
        return this.iPosX;
    }

    public final void setPosX(int iPosX) {
        this.iPosX = iPosX;
    }

    public final int getPosY() {
        return this.iPosY;
    }

    public final void setPosY(int iPosY) {
        this.iPosY = iPosY;
    }

    public final int getElevation() {
        return this.iElevation;
    }

    public final void setElevation(int iElevation) {
        this.iElevation = iElevation;
    }
}

