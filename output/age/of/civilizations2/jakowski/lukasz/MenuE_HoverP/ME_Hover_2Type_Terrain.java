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

public class ME_Hover_2Type_Terrain
implements ME_Hover_2Type {
    private int iTerrainID;
    private int offsetLeft = 0;
    private int offsetRight = 0;

    public ME_Hover_2Type_Terrain(int iTerrainID) {
        this.iTerrainID = iTerrainID;
        this.offsetLeft = 0;
        this.offsetRight = CFG.PADD;
    }

    public ME_Hover_2Type_Terrain(int iTerrainID, int offsetLeft) {
        this.iTerrainID = iTerrainID;
        this.offsetLeft = offsetLeft;
        this.offsetRight = CFG.PADD;
    }

    public ME_Hover_2Type_Terrain(int iTerrainID, int offsetLeft, int offsetRight) {
        this.iTerrainID = iTerrainID;
        this.offsetLeft = offsetLeft;
        this.offsetRight = offsetRight;
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha) {
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, nAlpha));
        CFG.terrainTypesManager.getIcon(this.iTerrainID).drawO(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD - CFG.terrainTypesManager.getIcon(this.iTerrainID).getHeight() + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.terrainTypesManager.getIcon(this.iTerrainID).getHeight() * this.getImageScale() / 2.0f), (int)((float)CFG.terrainTypesManager.getIcon(this.iTerrainID).getWidth() * this.getImageScale()), (int)((float)CFG.terrainTypesManager.getIcon(this.iTerrainID).getHeight() * this.getImageScale()));
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD - IMGManager.getIMG(Images.flagRectSmall).getHeight() + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.terrainTypesManager.getIcon(this.iTerrainID).getHeight() * this.getImageScale() / 2.0f), (int)((float)CFG.terrainTypesManager.getIcon(this.iTerrainID).getWidth() * this.getImageScale()), (int)((float)CFG.terrainTypesManager.getIcon(this.iTerrainID).getHeight() * this.getImageScale()));
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha, int iMaxWidth) {
        oSB.setColor(new Color(1.0f, 1.0f, 1.0f, nAlpha));
        CFG.terrainTypesManager.getIcon(this.iTerrainID).drawO(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD - CFG.terrainTypesManager.getIcon(this.iTerrainID).getHeight() + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.terrainTypesManager.getIcon(this.iTerrainID).getHeight() * this.getImageScale() / 2.0f), (int)((float)CFG.terrainTypesManager.getIcon(this.iTerrainID).getWidth() * this.getImageScale()), (int)((float)CFG.terrainTypesManager.getIcon(this.iTerrainID).getHeight() * this.getImageScale()));
        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, nPosX + this.offsetLeft, nPosY + CFG.PADD - IMGManager.getIMG(Images.flagRectSmall).getHeight() + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.terrainTypesManager.getIcon(this.iTerrainID).getHeight() * this.getImageScale() / 2.0f), (int)((float)CFG.terrainTypesManager.getIcon(this.iTerrainID).getWidth() * this.getImageScale()), (int)((float)CFG.terrainTypesManager.getIcon(this.iTerrainID).getHeight() * this.getImageScale()));
        oSB.setColor(Color.WHITE);
    }

    @Override
    public int getWidth() {
        return this.offsetRight + this.offsetLeft + (int)((float)CFG.terrainTypesManager.getIcon(this.iTerrainID).getWidth() * this.getImageScale());
    }

    @Override
    public int getHeight() {
        return CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD;
    }

    private final float getImageScale() {
        return (float)CFG.TEXT_HEIGHT_DEFAULT / (float)CFG.terrainTypesManager.getIcon(this.iTerrainID).getHeight();
    }
}

