/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.Terrain;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Color_GameData;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Terrain;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Terrain_GameData3;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.io.IOException;
import java.util.ArrayList;

public class Menu_TerrainTypes_Editor
extends Menu {
    public Menu_TerrainTypes_Editor() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        for (int i = 1; i < CFG.terrainTypesManager.getTerrainsSize(); ++i) {
            menuElements.add(new Button_Classic(CFG.terrainTypesManager.getName(i), (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * i + CFG.PADD * (i + 1), CFG.GAMEWIDTH, CFG.BUTTON_H, true){
                int iCurrent;
                {
                    this.iCurrent = 0;
                }

                @Override
                public int getCurr() {
                    return this.iCurrent;
                }

                @Override
                public void setCurr(int nCurrent) {
                    this.iCurrent = nCurrent;
                }

                @Override
                public void buildElemHover() {
                    try {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Terrain") + ": "));
                        nData.add(new ME_Hover_2Type_Text(CFG.terrainTypesManager.getName(this.getCurr()), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Terrain(this.getCurr(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefenseModifier") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + (CFG.terrainTypesManager.getDefense(this.getCurr()) > 0.0f ? "+" : "") + (int)(CFG.terrainTypesManager.getDefense(this.getCurr()) * 100.0f) + "%", CFG.terrainTypesManager.getDefense(this.getCurr()) == 0.0f ? CFG.COLOR_NEUTRAL : (CFG.terrainTypesManager.getDefense(this.getCurr()) > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeepModifier") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + (CFG.terrainTypesManager.getMilitaryUpkeep(this.getCurr()) > 0.0f ? "+" : "") + (int)(CFG.terrainTypesManager.getMilitaryUpkeep(this.getCurr()) * 100.0f) + "%", CFG.terrainTypesManager.getMilitaryUpkeep(this.getCurr()) == 0.0f ? CFG.COLOR_NEUTRAL : (CFG.terrainTypesManager.getMilitaryUpkeep(this.getCurr()) < 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MovementCostModifier") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + (CFG.terrainTypesManager.getMovementCost(this.getCurr()) > 0.0f ? "+" : "") + (int)(CFG.terrainTypesManager.getMovementCost(this.getCurr()) * 100.0f) + "%", CFG.terrainTypesManager.getMovementCost(this.getCurr()) == 0.0f ? CFG.COLOR_NEUTRAL : (CFG.terrainTypesManager.getMovementCost(this.getCurr()) < 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PopulationGrowthModifier") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + (CFG.terrainTypesManager.getPopulationGrowth(this.getCurr()) > 0.0f ? "+" : "") + (int)(CFG.terrainTypesManager.getPopulationGrowth(this.getCurr()) * 100.0f) + "%", CFG.terrainTypesManager.getPopulationGrowth(this.getCurr()) == 0.0f ? CFG.COLOR_NEUTRAL : (CFG.terrainTypesManager.getPopulationGrowth(this.getCurr()) > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EconomyGrowthModifier") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + (CFG.terrainTypesManager.getEconomyGrowth(this.getCurr()) > 0.0f ? "+" : "") + (int)(CFG.terrainTypesManager.getEconomyGrowth(this.getCurr()) * 100.0f) + "%", CFG.terrainTypesManager.getEconomyGrowth(this.getCurr()) == 0.0f ? CFG.COLOR_NEUTRAL : (CFG.terrainTypesManager.getEconomyGrowth(this.getCurr()) > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BuildCostModifier") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + (CFG.terrainTypesManager.getBuildCost(this.getCurr()) > 0.0f ? "+" : "") + (int)(CFG.terrainTypesManager.getBuildCost(this.getCurr()) * 100.0f) + "%", CFG.terrainTypesManager.getBuildCost(this.getCurr()) == 0.0f ? CFG.COLOR_NEUTRAL : (CFG.terrainTypesManager.getBuildCost(this.getCurr()) < 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BaseProvinceValue") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + (CFG.terrainTypesManager.getBaseProvinceValue(this.getCurr()) > 0 ? "+" : "") + CFG.terrainTypesManager.getBaseProvinceValue(this.getCurr()), CFG.terrainTypesManager.getBaseProvinceValue(this.getCurr()) == 0 ? CFG.COLOR_NEUTRAL : (CFG.terrainTypesManager.getBaseProvinceValue(this.getCurr()) > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BaseDevelopmentLevel") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + (CFG.terrainTypesManager.getBaseDevelopmentModifier(this.getCurr()) > 0.0f ? "+" : "") + (int)(CFG.terrainTypesManager.getBaseDevelopmentModifier(this.getCurr()) * 100.0f) + "%", CFG.terrainTypesManager.getBaseDevelopmentModifier(this.getCurr()) == 0.0f ? CFG.COLOR_NEUTRAL : (CFG.terrainTypesManager.getBaseDevelopmentModifier(this.getCurr()) > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                    catch (IndexOutOfBoundsException ex) {
                        this.menuElemHover = null;
                    }
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
        }
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H - CFG.PADD, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("AddNewTerrain"));
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        for (int i = 1; i < this.getMenuElemsSize(); ++i) {
            CFG.terrainTypesManager.getIcon(i).drawO(oSB, this.getMenuElem(i).getPosXE() + this.getWidthM() - CFG.terrainTypesManager.getIcon(i).getWidth() - CFG.PADD * 2 + iTranslateX, this.getMenuElem(i).getPosY() + this.getMenuElem(i).getHeightE() / 2 - CFG.terrainTypesManager.getIcon(i).getHeight() / 2 + this.getMenuPosY() + iTranslateY);
            oSB.setColor(new Color(CFG.terrainTypesManager.getColor((int)i).r, CFG.terrainTypesManager.getColor((int)i).g, CFG.terrainTypesManager.getColor((int)i).b, 1.0f));
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getMenuElem(i).getPosXE() + this.getMenuElem(i).getTextPosElem() + iTranslateX, this.getMenuElem(i).getPosY() + this.getMenuPosY() + this.getMenuElem(i).getHeightE() / 2 + this.getMenuElem(i).getTextHeight() / 2 + CFG.PADD + iTranslateY, this.getMenuElem(i).getTextWidthU(), CFG.CIV_COLOR_W);
            oSB.setColor(Color.WHITE);
        }
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.EDITOR_ACTIVE_GAMEDATA_TAG = System.currentTimeMillis() + CFG.extraRandomTag();
                CFG.editorTerrain_Data2 = new Terrain_GameData3();
                Color tempColor = CFG.getRandomColor();
                CFG.editorTerrain_Data2.setColor(new Color_GameData(tempColor.r, tempColor.g, tempColor.b));
                CFG.menus.setMenuID(View.eTERRAIN_TYPE_ADD);
                break;
            }
            default: {
                CFG.EDITOR_ACTIVE_GAMEDATA_TAG = CFG.terrainTypesManager.getTag(iID);
                FileHandle fileData = FileManager.loadFile("game/terrain_types/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG);
                try {
                    CFG.editorTerrain_Data2 = (Terrain_GameData3)CFG.deserialize(fileData.readBytes());
                }
                catch (ClassNotFoundException classNotFoundException) {
                }
                catch (IOException iOException) {
                    // empty catch block
                }
                CFG.menus.setMenuID(View.eTERRAIN_TYPE_ADD);
            }
        }
        RenderProvince.updateDrawProvinces();
    }
}

