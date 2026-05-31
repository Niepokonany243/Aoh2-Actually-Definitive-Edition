/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Terrain;

import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game_Checkbox;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Editor.Editor_TerrainType;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Terrain;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Touch;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_MapEditor_Terrain_List
extends Menu {
    public Menu_MapEditor_Terrain_List() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = (CFG.GAMEWIDTH - CFG.PADD * 2 - CFG.BUTTON_W * 2 - CFG.PADD * 2 - CFG.PADD * (CFG.terrainTypesManager.getTerrainsSize() - 2)) / (CFG.terrainTypesManager.getTerrainsSize() - 1);
        if (tempWidth < CFG.BUTTON_W) {
            tempWidth = CFG.BUTTON_W;
        }
        for (int i = 1; i < CFG.terrainTypesManager.getTerrainsSize(); ++i) {
            menuElements.add(new Button_Game_Checkbox(CFG.terrainTypesManager.getName(i), -1, CFG.PADD + tempWidth * (i - 1) + CFG.PADD * (i - 1), CFG.PADD, tempWidth, true, false){
                int iCurrent;
                {
                    this.iCurrent = 0;
                }

                @Override
                public boolean getCheckboxSt() {
                    return Editor_TerrainType.currentTerrainTypeID == this.getCurr();
                }

                @Override
                public void setCurr(int nCurrent) {
                    this.iCurrent = nCurrent;
                }

                @Override
                public int getCurr() {
                    return this.iCurrent;
                }

                @Override
                public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (isActive) {
                        CFG.drawTextDefault(oSB, this.getTextToDrawElem(), this.getPosXE() + CFG.PADD + CFG.terrainTypesManager.getIcon(this.iCurrent).getWidth() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
                    } else {
                        CFG.drawTextDefaultWithShadow(oSB, this.getTextToDrawElem(), this.getPosXE() + CFG.PADD + CFG.terrainTypesManager.getIcon(this.iCurrent).getWidth() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColorE(isActive));
                    }
                    CFG.terrainTypesManager.getIcon(this.iCurrent).drawO(oSB, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.terrainTypesManager.getIcon(this.iCurrent).getHeight() / 2 + iTranslateY);
                }

                @Override
                public int getTextWidthU() {
                    return super.getTextWidthU() + CFG.PADD + CFG.terrainTypesManager.getIcon(this.iCurrent).getWidth();
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
                        if (CFG.terrainTypesManager.getDefense(this.getCurr()) != 0.0f) {
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefenseModifier") + ": "));
                            nData.add(new ME_Hover_2Type_Text("" + (CFG.terrainTypesManager.getDefense(this.getCurr()) > 0.0f ? "+" : "") + (int)(CFG.terrainTypesManager.getDefense(this.getCurr()) * 100.0f) + "%", CFG.terrainTypesManager.getDefense(this.getCurr()) == 0.0f ? CFG.COLOR_NEUTRAL : (CFG.terrainTypesManager.getDefense(this.getCurr()) > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.terrainTypesManager.getMilitaryUpkeep(this.getCurr()) != 0.0f) {
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeepModifier") + ": "));
                            nData.add(new ME_Hover_2Type_Text("" + (CFG.terrainTypesManager.getMilitaryUpkeep(this.getCurr()) > 0.0f ? "+" : "") + (int)(CFG.terrainTypesManager.getMilitaryUpkeep(this.getCurr()) * 100.0f) + "%", CFG.terrainTypesManager.getMilitaryUpkeep(this.getCurr()) == 0.0f ? CFG.COLOR_NEUTRAL : (CFG.terrainTypesManager.getMilitaryUpkeep(this.getCurr()) < 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.terrainTypesManager.getMovementCost(this.getCurr()) != 0.0f) {
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MovementCostModifier") + ": "));
                            nData.add(new ME_Hover_2Type_Text("" + (CFG.terrainTypesManager.getMovementCost(this.getCurr()) > 0.0f ? "+" : "") + (int)(CFG.terrainTypesManager.getMovementCost(this.getCurr()) * 100.0f) + "%", CFG.terrainTypesManager.getMovementCost(this.getCurr()) == 0.0f ? CFG.COLOR_NEUTRAL : (CFG.terrainTypesManager.getMovementCost(this.getCurr()) < 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.terrainTypesManager.getPopulationGrowth(this.getCurr()) != 0.0f) {
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PopulationGrowthModifier") + ": "));
                            nData.add(new ME_Hover_2Type_Text("" + (CFG.terrainTypesManager.getPopulationGrowth(this.getCurr()) > 0.0f ? "+" : "") + (int)(CFG.terrainTypesManager.getPopulationGrowth(this.getCurr()) * 100.0f) + "%", CFG.terrainTypesManager.getPopulationGrowth(this.getCurr()) == 0.0f ? CFG.COLOR_NEUTRAL : (CFG.terrainTypesManager.getPopulationGrowth(this.getCurr()) > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.terrainTypesManager.getEconomyGrowth(this.getCurr()) != 0.0f) {
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EconomyGrowthModifier") + ": "));
                            nData.add(new ME_Hover_2Type_Text("" + (CFG.terrainTypesManager.getEconomyGrowth(this.getCurr()) > 0.0f ? "+" : "") + (int)(CFG.terrainTypesManager.getEconomyGrowth(this.getCurr()) * 100.0f) + "%", CFG.terrainTypesManager.getEconomyGrowth(this.getCurr()) == 0.0f ? CFG.COLOR_NEUTRAL : (CFG.terrainTypesManager.getEconomyGrowth(this.getCurr()) > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.terrainTypesManager.getBuildCost(this.getCurr()) != 0.0f) {
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BuildCostModifier") + ": "));
                            nData.add(new ME_Hover_2Type_Text("" + (CFG.terrainTypesManager.getBuildCost(this.getCurr()) > 0.0f ? "+" : "") + (int)(CFG.terrainTypesManager.getBuildCost(this.getCurr()) * 100.0f) + "%", CFG.terrainTypesManager.getBuildCost(this.getCurr()) == 0.0f ? CFG.COLOR_NEUTRAL : (CFG.terrainTypesManager.getBuildCost(this.getCurr()) < 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.terrainTypesManager.getBaseProvinceValue(this.getCurr()) != 0) {
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BaseProvinceValue") + ": "));
                            nData.add(new ME_Hover_2Type_Text("" + (CFG.terrainTypesManager.getBaseProvinceValue(this.getCurr()) > 0 ? "+" : "") + CFG.terrainTypesManager.getBaseProvinceValue(this.getCurr()), CFG.terrainTypesManager.getBaseProvinceValue(this.getCurr()) == 0 ? CFG.COLOR_NEUTRAL : (CFG.terrainTypesManager.getBaseProvinceValue(this.getCurr()) > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        if (CFG.terrainTypesManager.getBaseDevelopmentModifier(this.getCurr()) != 0.0f) {
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BaseDevelopmentLevel") + ": "));
                            nData.add(new ME_Hover_2Type_Text("" + (CFG.terrainTypesManager.getBaseDevelopmentModifier(this.getCurr()) > 0.0f ? "+" : "") + (int)(CFG.terrainTypesManager.getBaseDevelopmentModifier(this.getCurr()) * 100.0f) + "%", CFG.terrainTypesManager.getBaseDevelopmentModifier(this.getCurr()) == 0.0f ? CFG.COLOR_NEUTRAL : (CFG.terrainTypesManager.getBaseDevelopmentModifier(this.getCurr()) > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_1)));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                    catch (IndexOutOfBoundsException ex) {
                        this.menuElemHover = null;
                    }
                }

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysOverM(oSB, Touch.getMousePosX(), Touch.getMousePosY());
                    }
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
        }
        this.initMenu(null, CFG.PADD * 2 + CFG.BUTTON_W * 2, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2, CFG.GAMEWIDTH - (CFG.PADD * 2 + CFG.BUTTON_W * 2), CFG.BUTTON_H + CFG.PADD * 2, menuElements);
        if (tempWidth < CFG.BUTTON_W * 2) {
            this.updatedButtonsWidth(CFG.PADD, CFG.BUTTON_W * 2);
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        IMGManager.getIMG(Images.editor_line).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.editor_line).getHeight() + iTranslateY, this.getWidthM(), CFG.BUTTON_H + CFG.PADD * 2);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        for (int i = 0; i < this.getMenuElemsSize(); ++i) {
            oSB.setColor(new Color(CFG.terrainTypesManager.getColor((int)(i + 1)).r, CFG.terrainTypesManager.getColor((int)(i + 1)).g, CFG.terrainTypesManager.getColor((int)(i + 1)).b, 1.0f));
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getMenuPosX() + this.getMenuElem(i).getPosXE() + this.getMenuElem(i).getWidthE() / 2 - this.getMenuElem(i).getTextWidthU() / 2 + iTranslateX, this.getMenuElem(i).getPosY() + this.getMenuPosY() + this.getMenuElem(i).getHeightE() / 2 + this.getMenuElem(i).getTextHeight() / 2 + CFG.PADD + iTranslateY, CFG.PADD, CFG.CIV_COLOR_W, true, false);
            IMGManager.getIMG(Images.pix255).drawO(oSB, this.getMenuPosX() + this.getMenuElem(i).getPosXE() + this.getMenuElem(i).getWidthE() / 2 + CFG.PADD - this.getMenuElem(i).getTextWidthU() / 2 + iTranslateX, this.getMenuElem(i).getPosY() + this.getMenuPosY() + this.getMenuElem(i).getHeightE() / 2 + this.getMenuElem(i).getTextHeight() / 2 + CFG.PADD + iTranslateY, this.getMenuElem(i).getTextWidthU() - CFG.PADD * 2, CFG.CIV_COLOR_W);
            IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getMenuPosX() + this.getMenuElem(i).getPosXE() + this.getMenuElem(i).getWidthE() / 2 - this.getMenuElem(i).getTextWidthU() / 2 + this.getMenuElem(i).getTextWidthU() - CFG.PADD + iTranslateX, this.getMenuElem(i).getPosY() + this.getMenuPosY() + this.getMenuElem(i).getHeightE() / 2 + this.getMenuElem(i).getTextHeight() / 2 + CFG.PADD + iTranslateY, CFG.PADD, CFG.CIV_COLOR_W);
            oSB.setColor(Color.WHITE);
        }
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        Editor_TerrainType.currentTerrainTypeID = iID + 1;
    }
}

