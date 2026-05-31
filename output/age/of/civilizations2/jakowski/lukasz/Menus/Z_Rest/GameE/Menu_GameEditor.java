/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest.GameE;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.Undo.Undo_AssignProvinceCiv;
import java.util.ArrayList;

public class Menu_GameEditor
extends Menu {
    public Menu_GameEditor() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.PADD, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H + CFG.PADD * 2, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 2 + CFG.PADD * 3, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 3 + CFG.PADD * 4, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 4 + CFG.PADD * 5, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 5 + CFG.PADD * 6, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 6 + CFG.PADD * 7, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 7 + CFG.PADD * 8, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 8 + CFG.PADD * 9, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic(null, (int)(50.0f * CFG.GUI_SCALE), 0, CFG.BUTTON_H * 9 + CFG.PADD * 10, CFG.GAMEWIDTH, CFG.BUTTON_H, true));
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H - CFG.PADD, menuElements);
        this.updateLang();
        CFG.lCreateScenario_UndoAssignProvsCivID = new ArrayList<Undo_AssignProvinceCiv>();
        CFG.lCreateScenario_UndoWastelandProvinces = new ArrayList<Integer>();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("TerrainTypesEditor"));
        this.getMenuElem(1).setTextE(CFG.lang.get("GameCivilizations"));
        this.getMenuElem(2).setTextE(CFG.lang.get("Unions"));
        this.getMenuElem(3).setTextE(CFG.lang.get("PalletCivColorsPackages"));
        this.getMenuElem(4).setTextE(CFG.lang.get("ServiceRibbonEditor"));
        this.getMenuElem(5).setTextE(CFG.lang.get("ContinentsPackages"));
        this.getMenuElem(6).setTextE(CFG.lang.get("RegionsPackages"));
        this.getMenuElem(7).setTextE(CFG.lang.get("RandomAlliancesNamesPackages"));
        this.getMenuElem(8).setTextE(CFG.lang.get("DiplomacyColorsPackages"));
        this.getMenuElem(9).setTextE(CFG.lang.get("Lines"));
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                CFG.menus.setMenuID(View.eTERRAIN_TYPES_EDITOR);
                break;
            }
            case 1: {
                CFG.menus.setMenuID(View.eEDITOR_GAME_CIVS);
                break;
            }
            case 2: {
                CFG.menus.setMenuID(View.eEDITOR_UNIONS);
                break;
            }
            case 3: {
                CFG.menus.setMenuID(View.eGAME_EDITOR_PALLETS_OF_CIVS_COLORS_PACKAGES);
                break;
            }
            case 4: {
                CFG.menus.setMenuID(View.eGAME_EDITOR_SERVICE_RIBBON);
                break;
            }
            case 5: {
                CFG.menus.setMenuID(View.eMAP_EDITOR_PACKAGES_CONTINENTS);
                break;
            }
            case 6: {
                CFG.menus.setMenuID(View.eMAP_EDITOR_PACKAGES_REGIONS);
                break;
            }
            case 7: {
                CFG.menus.setMenuID(View.eGAME_EDITOR_ALLIANCE_NAMES_PACKAGE);
                break;
            }
            case 8: {
                CFG.menus.setMenuID(View.eGAME_EDITOR_DIPLOMACY_COLORS_PACKAGES);
                break;
            }
            case 9: {
                CFG.menus.setMenuID(View.eGAME_EDITOR_LINES);
            }
        }
    }
}

