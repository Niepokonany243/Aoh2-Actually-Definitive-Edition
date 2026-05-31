/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.io.Serializable;

public class City
implements Serializable {
    private static final long serialVersionUID = 0L;
    private String sCityName = null;
    public int iWidth = 0;
    private int iPosX;
    private int iPosY;
    private int iCityLevel = 0;

    public City(String sName, int nPosX, int nPosY, int iCityLevel) {
        sName = CFG.stripBOM(sName);
        this.sCityName = sName;
        this.updateCityNameWidth();
        this.iPosX = nPosX;
        this.iPosY = nPosY;
        this.iCityLevel = iCityLevel;
    }

    public final void draw(SpriteBatch oSB, int nProvinceID, float nScale) {
        this.draw(oSB, nProvinceID, nScale, CFG.COLOR_CITY_NAME, this.getCityLevel());
    }

    public final void drawInLine(SpriteBatch oSB, int nProvinceID, float nScale) {
        this.drawInLine(oSB, nProvinceID, nScale, CFG.COLOR_CITY_NAME, this.getCityLevel());
    }

    public final void draw(SpriteBatch oSB, int nProvinceID, float nScale, int nImageID) {
        this.draw(oSB, nProvinceID, nScale, CFG.COLOR_CITY_NAME, nImageID);
    }

    public final void draw(SpriteBatch oSB, int nProvinceID, float nScale, Color nColor) {
        this.draw(oSB, nProvinceID, nScale, nColor, this.getCityLevel());
    }

    public final void draw(SpriteBatch oSB, int nProvinceID, float nScale, Color nColor, int nImageID) {
        IMGManager.getIMG(nImageID).drawO(oSB, (int)((float)(this.getPoX() * CFG.map.getMpB().getMapSc3() + CFG.core.getProv(nProvinceID).getTranslateProvPosX()) * nScale - (float)(IMGManager.getIMG(nImageID).getWidth() / 2)), (int)((float)(this.getPosY() * CFG.map.getMpB().getMapSc3() + CFG.map.getMpC().getPY()) * nScale) - IMGManager.getIMG(nImageID).getHeight() / 2);
    }

    public final void drawWithName(SpriteBatch oSB, int nProvinceID, float nScale) {
        this.drawWithName(oSB, nProvinceID, nScale, CFG.COLOR_CITY_NAME, this.getCityLevel());
    }

    public final void drawWithName(SpriteBatch oSB, int nProvinceID, float nScale, int nImageID) {
        this.drawWithName(oSB, nProvinceID, nScale, CFG.COLOR_CITY_NAME, nImageID);
    }

    public final void drawWithName(SpriteBatch oSB, int nProvinceID, float nScale, Color nColor) {
        this.drawWithName(oSB, nProvinceID, nScale, nColor, this.getCityLevel());
    }

    public final void drawWithName(SpriteBatch oSB, int nProvinceID, float nScale, Color nColor, int nImageID) {
        CFG.drawTextDefault(oSB, this.getCityName(), (int)((float)(this.getPoX() * CFG.map.getMpB().getMapSc3() + CFG.core.getProv(nProvinceID).getTranslateProvPosX()) * nScale - (float)this.iWidth / 2.0f), (int)((float)(this.getPosY() * CFG.map.getMpB().getMapSc3() + CFG.map.getMpC().getPY()) * nScale) - IMGManager.getIMG(nImageID).getHeight() / 2 + IMGManager.getIMG(nImageID).getHeight() + 2, nColor);
        IMGManager.getIMG(nImageID).drawO(oSB, (int)((float)(this.getPoX() * CFG.map.getMpB().getMapSc3() + CFG.core.getProv(nProvinceID).getTranslateProvPosX()) * nScale - (float)(IMGManager.getIMG(nImageID).getWidth() / 2)), (int)((float)(this.getPosY() * CFG.map.getMpB().getMapSc3() + CFG.map.getMpC().getPY()) * nScale) - IMGManager.getIMG(nImageID).getHeight() / 2);
    }

    public final void drawInLine(SpriteBatch oSB, int nProvinceID, float nScale, Color nColor, int nImageID) {
        IMGManager.getIMG(nImageID).drawO(oSB, (int)((float)(this.getPoX() * CFG.map.getMpB().getMapSc3() + CFG.core.getProv(nProvinceID).getTranslateProvPosX()) * nScale - (float)(IMGManager.getIMG(nImageID).getWidth() / 2)), (int)((float)(this.getPosY() * CFG.map.getMpB().getMapSc3() + CFG.map.getMpC().getPY()) * nScale) - IMGManager.getIMG(nImageID).getHeight() / 2);
        CFG.drawTextDefault(oSB, this.getCityName(), (int)((float)(this.getPoX() * CFG.map.getMpB().getMapSc3() + CFG.core.getProv(nProvinceID).getTranslateProvPosX()) * nScale + (float)(IMGManager.getIMG(nImageID).getWidth() / 2) + 1.0f), (int)((float)(this.getPosY() * CFG.map.getMpB().getMapSc3() + CFG.map.getMpC().getPY()) * nScale - (float)(IMGManager.getIMG(nImageID).getHeight() / 2) + (float)(IMGManager.getIMG(nImageID).getHeight() / 2) - (float)(CFG.ARMY_HEIGHT / 4) + 1.0f), nColor);
    }

    public final void drawCityImage_Level(SpriteBatch oSB, int nProvinceID, float nScale) {
        IMGManager.getIMG(this.getCityLevel()).drawO(oSB, (int)((float)(this.getPoX() * CFG.map.getMpB().getMapSc3() + CFG.core.getProv(nProvinceID).getTranslateProvPosX()) * nScale - (float)(IMGManager.getIMG(this.getCityLevel()).getWidth() / 2)), (int)((float)(this.getPosY() * CFG.map.getMpB().getMapSc3() + CFG.map.getMpC().getPY()) * nScale) - IMGManager.getIMG(this.getCityLevel()).getHeight() / 2);
    }

    public final void updateCityNameWidth() {
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sCityName);
        this.iWidth = (int)(CFG.glyphLay.width * CFG.settingsGD.CITIES_FONT_SCALE);
    }

    public final String getCityName() {
        return this.sCityName;
    }

    public final void setCityName(String sCityName) {
        sCityName = CFG.stripBOM(sCityName);
        this.sCityName = sCityName;
        this.updateCityNameWidth();
    }

    public final int getPoX() {
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

    public final int getCityLevel() {
        return this.iCityLevel;
    }

    public final void setCityLevel(int iCityLevel) {
        this.iCityLevel = iCityLevel;
    }
}

