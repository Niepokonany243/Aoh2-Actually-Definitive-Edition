
package age.of.civilizations2.jakowski.lukasz.TextB.Texts;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextBuildTitle_Terrain
extends TextBuildTitle {
    private int iTerrainID;

    public TextBuildTitle_Terrain(String sText, int iTextPositionX, int iPosX, int iPosY, int iWidth, int iHeight, int iTerrainID) {
        super(sText, iTextPositionX, iPosX, iPosY, iWidth, iHeight);
        this.iTerrainID = iTerrainID;
    }

    @Override
    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        super.drawE(oSB, iTranslateX, iTranslateY, isActive, scrollableY);
        CFG.terrainTypesManager.getIcon(this.iTerrainID).drawO(oSB, this.getPosXE() + this.getWidthE() - CFG.PADD * 2 - (int)((float)CFG.terrainTypesManager.getIcon(this.iTerrainID).getWidth() * this.getImageScale()) + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.terrainTypesManager.getIcon(this.iTerrainID).getHeight() - (int)((float)CFG.terrainTypesManager.getIcon(this.iTerrainID).getHeight() * this.getImageScale()) / 2 + iTranslateY, (int)((float)CFG.terrainTypesManager.getIcon(this.iTerrainID).getWidth() * this.getImageScale()), (int)((float)CFG.terrainTypesManager.getIcon(this.iTerrainID).getHeight() * this.getImageScale()));
    }

    public float getImageScale() {
        return (float)CFG.TEXT_HEIGHT_DEFAULT * 1.0f / (float)CFG.terrainTypesManager.getIcon(this.iTerrainID).getHeight();
    }
}

