/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.MapEditor;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Editor.Editors;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.SelectMapType.Menu_SelectMapType_Scale;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_MapEditor_Edit_Options
extends Menu {
    public Menu_MapEditor_Edit_Options() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 3 + CFG.PADD * 4, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 5 + CFG.PADD * 6, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 4 + CFG.PADD * 5, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 7 + CFG.PADD * 8, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 9 + CFG.PADD * 10, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 10 + CFG.PADD * 11, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 11 + CFG.PADD * 12, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 14 + CFG.PADD * 15, CFG.GAMEWIDTH, CFG.BUTTON_H, true, CFG.getFileNames_Length2("map/" + CFG.map.getFileActiveMapPath() + "suggested_owners/") > 0){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BasedOnAllScenarios") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 16 + CFG.PADD * 17, CFG.GAMEWIDTH, CFG.BUTTON_H, true, CFG.getFileNames_Length2("map/" + CFG.map.getFileActiveMapPath() + "data/" + "sea_routes/") > 0));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H + CFG.PADD * 2, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 12 + CFG.PADD * 13, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 2 + CFG.PADD * 3, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 15 + CFG.PADD * 16, CFG.GAMEWIDTH, CFG.BUTTON_H, true, CFG.getFileNames_Length2("map/" + CFG.map.getFileActiveMapPath() + "data/" + "predefined_borders/") > 0){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BasedOnAllScenarios") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 8 + CFG.PADD * 9, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 6 + CFG.PADD * 7, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 17 + CFG.PADD * 18, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 13 + CFG.PADD * 14, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 18 + CFG.PADD * 19, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 19 + CFG.PADD * 20, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H - CFG.PADD, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("EditTerrainTypes"));
        this.getMenuElem(1).setTextE(CFG.lang.get("ContinentsEditor"));
        this.getMenuElem(2).setTextE(CFG.lang.get("GrowthRateEditor"));
        this.getMenuElem(3).setTextE(CFG.lang.get("ArmyPositionEditor"));
        this.getMenuElem(4).setTextE(CFG.lang.get("SeaArmyBoxesEditor"));
        this.getMenuElem(5).setTextE(CFG.lang.get("OptimizationRegionsEditor"));
        this.getMenuElem(6).setTextE(CFG.lang.get("WastelandMapsEditor"));
        this.getMenuElem(7).setTextE(CFG.lang.get("GenerateSuggestedCivilizations"));
        this.getMenuElem(8).setTextE(CFG.lang.get("GenerateSeaRoutes"));
        this.getMenuElem(9).setTextE(CFG.map.getMapName(CFG.map.getActiveMapIDN()) + " - " + CFG.lang.get("Scale") + ": " + CFG.map.getMapScale(CFG.map.getActiveMapIDN()));
        this.getMenuElem(10).setTextE(CFG.lang.get("EditConnectionsAndProvinces"));
        this.getMenuElem(11).setTextE(CFG.lang.get("EditProvinceBackground"));
        this.getMenuElem(12).setTextE(CFG.lang.get("EditSeaProvinces"));
        this.getMenuElem(13).setTextE(CFG.lang.get("GeneratePreDefinedBorders"));
        this.getMenuElem(14).setTextE(CFG.lang.get("PortPositionEditor"));
        this.getMenuElem(15).setTextE(CFG.lang.get("RegionsEditor"));
        this.getMenuElem(16).setTextE(CFG.lang.get("PrintAMap"));
        this.getMenuElem(17).setTextE(CFG.lang.get("FormableCivilizations"));
        this.getMenuElem(18).setTextE(CFG.lang.get("ProvinceName"));
        this.getMenuElem(19).setTextE(CFG.lang.get("Generate") + ": Civilization Templates");
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.map.getIcon(CFG.map.getActiveMapIDN()).drawO(oSB, this.getMenuElem(9).getTextPosElem() / 2 - CFG.map.getIcon(CFG.map.getActiveMapIDN()).getWidth() / 2 + iTranslateX, this.getMenuElem(9).getPosY() + this.getMenuElem(9).getHeightE() / 2 - CFG.map.getIcon(CFG.map.getActiveMapIDN()).getHeight() / 2 + this.getMenuPosY() + iTranslateY);
        CFG.fontMain.get(0).getData().setScale(0.6f);
        CFG.drawTextDefault(oSB, CFG.sAUTHOR + ": " + CFG.map.getMapAuthor(CFG.map.getActiveMapIDN()), this.getMenuElem(9).getTextPosElem() + this.getMenuElem(9).getTextWidthU() + CFG.PADD + iTranslateX, this.getMenuElem(9).getPosY() + this.getMenuElem(9).getHeightE() / 2 + CFG.TEXT_HEIGHT_DEFAULT / 2 - (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.6f) + this.getMenuPosY() + iTranslateY, CFG.COLOR_BUTTON_EXTRA_DESCRIPTION);
        CFG.fontMain.get(0).getData().setScale(1.0f);
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    CFG.core.getProv(i).setWastelandLvl(-1);
                }
                CFG.menus.setMenuID(View.eMAP_EDITOR_TERRAIN);
                CFG.editorManager.setInUse(Editors.eTERRAINS);
                RenderProvince.updateDrawProvinces();
                return;
            }
            case 1: {
                CFG.menus.setMenuID(View.eMAP_EDITOR_CONTINENTS);
                CFG.editorManager.setInUse(Editors.ePROVINCE_CONTINENTS);
                RenderProvince.updateDrawProvinces();
                return;
            }
            case 2: {
                CFG.menus.setMenuID(View.eMAP_EDITOR_GROWTH_RATE);
                CFG.editorManager.setInUse(Editors.eGROWTH_RATE);
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    CFG.core.getProv(i).setWastelandLvl(-1);
                    CFG.core.getProv(i).getArmyObject(0).updateArmyWidth("" + (int)(CFG.core.getProv(i).getGrowthRate_Pop() * 100.0f) + "%");
                }
                RenderProvince.updateDrawProvinces();
                return;
            }
            case 3: {
                CFG.menus.setMenuID(View.eMAP_EDITOR_ARMY_POSITION);
                CFG.editorManager.setInUse(Editors.eSHIFT_ARMY);
                RenderProvince.updateDrawProvinces();
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    CFG.core.getProv(i).setWastelandLvl(-1);
                    CFG.core.getProv(i).getArmyObject(0).updateArmyWidth(i);
                }
                return;
            }
            case 4: {
                CFG.RELOAD_SCENARIO = true;
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    if (!CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getCivsSize() != 1) continue;
                    CFG.core.getPlayer(CFG.PLAYER_TURN_ID).setFogOfWar(i, true);
                    CFG.core.getProv(i).addArmy(1, i);
                    CFG.core.getProv(i).updateDrawArmyInProv();
                }
                CFG.menus.setMenuID(View.eMAP_EDITOR_ARMY_SEA_BOXES);
                return;
            }
            case 5: {
                int i;
                for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                    CFG.core.getProv(i).setWastelandLvl(-1);
                }
                CFG.menus.setMenuID(View.eGAME_EDITOR_REGIONS);
                CFG.editorManager.setInUse(Editors.ePROVINCE_REGIONS);
                RenderProvince.updateDrawProvinces();
                for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                    CFG.core.getProv(i).getArmyObject(0).updateArmyWidth(CFG.core.getRegionID(i));
                }
                return;
            }
            case 6: {
                CFG.menus.setMenuID(View.eMAP_EDITOR_WASTELAND_MAPS);
                return;
            }
            case 7: {
                CFG.setDialogType(DialogType.GENERATE_SUGGESTED_OWNERS);
                return;
            }
            case 8: {
                CFG.setDialogType(DialogType.GENERATE_SEA_ROUTES);
                this.getMenuElem(iID).setCheckboxSt(CFG.getFileNames_Length2("map/" + CFG.map.getFileActiveMapPath() + "data/" + "sea_routes/") > 0);
                return;
            }
            case 9: {
                CFG.backToMenu = View.eMAP_EDITOR_EDIT;
                CFG.goToMenu = View.eMAP_EDITOR_EDIT;
                Menu_SelectMapType_Scale.MAP_ID_TO_LOAD = CFG.map.getActiveMapIDN();
                CFG.menus.setMenuID(View.eSELECT_MAP_TYPE_SCALE);
                return;
            }
            case 10: {
                CFG.VIEW_SHOW_VALUES = true;
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    CFG.core.getProv(i).setWastelandLvl(-1);
                    CFG.core.getProv(i).getArmyObject(0).updateArmyWidth(i);
                }
                CFG.editorManager.setInUse(Editors.eNEIGHBORING_PROVINCES);
                CFG.menus.setMenuID(View.eMAP_EDITOR_CONNECTIONS);
                return;
            }
            case 11: {
                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV1 = -1;
                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
                CFG.MANAGE_DIPLOMACY_CUSTOMIZE_ALLIANCE_ID = 0;
                CFG.VIEW_SHOW_VALUES = true;
                CFG.map.getMpS().setScaleBeforeReset(8.0f);
                CFG.editorManager.setInUse(Editors.ePROVINCE_TEXTURE);
                CFG.menus.setMenuID(View.eMAP_EDITOR_PROVINCE_BACKGROUND);
                return;
            }
            case 12: {
                CFG.MANAGE_DIPLOMACY_ADD_NEW_PACT_CIV2 = -1;
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    CFG.core.getProv(i).setWastelandLvl(-1);
                    CFG.core.getProv(i).getArmyObject(0).updateArmyWidth(CFG.core.getProv(i).getLvlOfPort());
                }
                CFG.editorManager.setInUse(Editors.eLEVEL_OF_PORT);
                CFG.menus.setMenuID(View.eMAP_EDITOR_SEA_PROVINCES);
                return;
            }
            case 13: {
                CFG.setDialogType(DialogType.GENERATE_PRE_DEFINED_BORDERS);
                return;
            }
            case 14: {
                CFG.menus.setMenuID(View.eMAP_EDITOR_PORT_POSITION);
                CFG.editorManager.setInUse(Editors.eSHIFT_PORT);
                RenderProvince.updateDrawProvinces();
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    CFG.core.getProv(i).setWastelandLvl(-1);
                    if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getLvlOfPort() < 0) continue;
                    CFG.core.getProv(i).setLvlOfPort(1);
                }
                return;
            }
            case 15: {
                CFG.menus.setMenuID(View.eMAP_EDITOR_REGIONS);
                CFG.editorManager.setInUse(Editors.ePROVINCE_MAP_REGIONS);
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    CFG.core.getProv(i).setWastelandLvl(-1);
                    if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getLvlOfPort() < 0) continue;
                    CFG.core.getProv(i).setLvlOfPort(1);
                }
                RenderProvince.updateDrawProvinces();
                return;
            }
            case 16: {
                return;
            }
            case 17: {
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    CFG.core.getProv(i).setWastelandLvl(-1);
                }
                CFG.menus.setMenuID(View.eMAP_EDITOR_FORMABLE_CIVS);
                return;
            }
            case 18: {
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    CFG.core.getProv(i).setWastelandLvl(-1);
                }
                CFG.editorManager.setInUse(Editors.ePROVINCE_NAME);
                CFG.menus.setMenuID(View.eMAP_EDITOR_PROVINCE_NAMES);
                break;
            }
            case 19: {
                CFG.menus.setMenuID(View.eLOAD_GENERATE_CIVS_TEMPLATES);
            }
        }
    }
}

