
package age.of.civilizations2.jakowski.lukasz.Button2;

import age.of.civilizations2.jakowski.lukasz.Button.ButtonM;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menus.Info.Menu_InGame_ProvInfo;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button_Terrain_ProvinceInfo
extends ButtonM {
    public int lastActiveProvinceID = -1;

    public Button_Terrain_ProvinceInfo(int iPosX, int iPosY) {
        this.fontID = CFG.FONT_BOLD_SMALL;
        super.init("", 0, iPosX, iPosY, IMGManager.getIMG(Images.terrainUnknown).getWidth(), IMGManager.getIMG(Images.terrainUnknown).getHeight(), true, true, false, false, null);
    }

    @Override
    public void drawButtonBGE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
        try {
            int activeProvinceInfo;
            int n = activeProvinceInfo = CFG.chosenProvinceID >= 0 ? CFG.chosenProvinceID : CFG.core.getActiveProvID();
            if (Menu_InGame_ProvInfo.provinceIMG_ID_Loaded == activeProvinceInfo) {
                try {
                    Menu_InGame_ProvInfo.provinceIMG.draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, IMGManager.getIMG(Images.terrainOver).getWidth(), IMGManager.getIMG(Images.terrainOver).getHeight());
                    IMGManager.getIMG(Images.terrainOver).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY);
                }
                catch (Exception exr) {
                    CFG.terrainTypesManager.getIcon(CFG.core.getProv(activeProvinceInfo).getTerrainTypeID()).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY);
                }
            } else {
                CFG.terrainTypesManager.getIcon(CFG.core.getProv(activeProvinceInfo).getTerrainTypeID()).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY);
            }
            if (this.lastActiveProvinceID != activeProvinceInfo) {
                this.lastActiveProvinceID = activeProvinceInfo;
                this.setTextE(CFG.terrainTypesManager.getName(CFG.core.getProv(activeProvinceInfo).getTerrainTypeID()));
            }
            try {
                Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + this.getHeightE() - this.getTextHeight() - CFG.PADD + iTranslateY, this.getColorE(isActive));
            }
            catch (Exception exception) {}
        }
        catch (Exception exception) {
            
        }
    }

    @Override
    public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
    }

    @Override
    public Color getColorE(boolean isActive) {
        return Colors.getColorButtonHover(isActive, this.getIsHovered());
    }
}

