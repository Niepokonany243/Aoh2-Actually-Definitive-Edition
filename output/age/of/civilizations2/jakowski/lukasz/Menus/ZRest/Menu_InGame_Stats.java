/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.ZRest;

import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_DiplomacyAction;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Budget.Menu_InGame_FA_RightRank;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_Actions;
import age.of.civilizations2.jakowski.lukasz.Menus.Outliner.Menu_InGame_OutlinerStats;
import age.of.civilizations2.jakowski.lukasz.Menus.Relations.Actions.Menu_InGameOfferAlliance;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_Stats
extends Menu {
    public static int getMenuX() {
        return CFG.GAMEWIDTH - Menu_InGame_Stats.getMenuW() - Menu_InGame_OutlinerStats.getMenuW() * 6 / 11;
    }

    public static int getMenuW() {
        return CFG.BUTTON_W * 2 + CFG.BUTTON_W * 3 / 5;
    }

    public static int getMenuY() {
        return IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4;
    }

    public Menu_InGame_Stats() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = Menu_InGame_Stats.getMenuW();
        int tY = 0;
        int tempElemH = Menu_InGame_Civ_Actions.getButtonH();
        menuElements.add(new Button_DiplomacyAction(Images.editorGame, CFG.lang.get("Audio"), 0, 0, tY, tempWidth - 2, tempElemH, true){

            @Override
            public void buildElemHover() {
                if (CFG.getIsDesktop()) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Audio"), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("F12", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else {
                    this.menuElemHover = null;
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.menus.setVisibleInGame_Playlist(!CFG.menus.getVisibleInGame_Playlist());
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
        menuElements.add(new Button_DiplomacyAction(Images.attack, CFG.lang.get("ShowCombatMovement"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 2, tempElemH, true, CFG.settingsGD.SHOW_COMBAT_MOVEMENT){

            @Override
            public void buildElemHover() {
                if (CFG.getIsDesktop()) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ShowCombatMovement") + ": " + (CFG.settingsGD.SHOW_COMBAT_MOVEMENT ? CFG.lang.get("On") : CFG.lang.get("Off")), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.attack, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else {
                    this.menuElemHover = null;
                }
            }

            @Override
            public boolean getCheckboxSt() {
                return CFG.settingsGD.SHOW_COMBAT_MOVEMENT;
            }

            @Override
            public void actionElem(int iID) {
                CFG.settingsGD.SHOW_COMBAT_MOVEMENT = !CFG.settingsGD.SHOW_COMBAT_MOVEMENT;
                CFG.saveSettings();
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
        menuElements.add(new Button_DiplomacyAction(Images.battle, CFG.lang.get("ShowBattleReports"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 2, tempElemH, true, CFG.settingsGD.SHOW_BATTLE_REPORT){

            @Override
            public void buildElemHover() {
                if (CFG.getIsDesktop()) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ShowBattleReports") + ": " + (CFG.settingsGD.SHOW_BATTLE_REPORT ? CFG.lang.get("On") : CFG.lang.get("Off")), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.battle, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else {
                    this.menuElemHover = null;
                }
            }

            @Override
            public boolean getCheckboxSt() {
                return CFG.settingsGD.SHOW_BATTLE_REPORT;
            }

            @Override
            public void actionElem(int iID) {
                CFG.settingsGD.SHOW_BATTLE_REPORT = !CFG.settingsGD.SHOW_BATTLE_REPORT;
                CFG.saveSettings();
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
        menuElements.add(new Button_DiplomacyAction(Images.diploWar, CFG.lang.get("Wars"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 2, tempElemH, true){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_Wars()) {
                    CFG.menus.setVisibleInGame_Wars(false);
                } else {
                    CFG.menus.rebuildInGame_Wars();
                }
            }

            @Override
            public void buildElemHover() {
                if (CFG.getIsDesktop()) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("CurrentWars"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("F6", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else {
                    this.menuElemHover = null;
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
        menuElements.add(new Button_DiplomacyAction(Images.diploAlliance, CFG.lang.get("Alliances"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 2, tempElemH, true){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_MilitaryAlliances()) {
                    CFG.menus.setVisibleInGame_MilitaryAlliances(false);
                } else {
                    CFG.menus.rebuildInGame_MilitaryAlliances();
                }
            }

            @Override
            public void buildElemHover() {
                if (CFG.getIsDesktop()) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Alliances"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploAlliance, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("F7", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else {
                    this.menuElemHover = null;
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
        menuElements.add(new Button_DiplomacyAction(Images.rank, CFG.lang.get("Rank"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 2, tempElemH, true){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_Rank()) {
                    CFG.menus.setVisibleInGame_Rank(false);
                } else {
                    CFG.menus.rebuildInGame_Rank();
                }
            }

            @Override
            public void buildElemHover() {
                if (CFG.getIsDesktop()) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Ranking"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.rank, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Shortcut") + ": "));
                    nData.add(new ME_Hover_2Type_Text("F9", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Image(Images.key, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else {
                    this.menuElemHover = null;
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
        menuElements.add(new Button_DiplomacyAction(Images.wonders, CFG.lang.get("Wonders"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 2, tempElemH, true){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_Wonders()) {
                    CFG.menus.setVisibleInGame_Wonders(false);
                } else {
                    CFG.menus.rebuildInGame_Wonders();
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
        menuElements.add(new Button_DiplomacyAction(Images.pop, CFG.lang.get("Population"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 2, tempElemH, true){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_WorldPopulation()) {
                    CFG.menus.setVisibleInGame_WorldPopulation(false);
                } else {
                    CFG.menus.rebuildInGame_WorldPopulation();
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
        menuElements.add(new Button_DiplomacyAction(Images.economy, CFG.lang.get("Economy"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 2, tempElemH, true){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_WorldEconomy()) {
                    CFG.menus.setVisibleInGame_WorldEconomy(false);
                } else {
                    CFG.menus.rebuildInGame_WorldEconomy();
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
        menuElements.add(new Button_DiplomacyAction(Images.hreIcon, CFG.lang.get("HolyRomanEmpire"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 2, tempElemH, true){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGameHRE()) {
                    CFG.menus.setVisibleInGameHRE(false);
                } else {
                    CFG.menus.rebuildInGameHRE();
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
        menuElements.add(new Button_DiplomacyAction(Images.provinces, CFG.lang.get("ConqueredProvinces"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 2, tempElemH, true){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_ConquredProvinces()) {
                    CFG.menus.setVisibleInGame_ConquredProvinces(false);
                } else {
                    CFG.menus.rebuildInGame_ConqueredProvinces();
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
        menuElements.add(new Button_DiplomacyAction(Images.victoryPoints, CFG.lang.get("VictoryConditions"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 2, tempElemH, true){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_VictoryConditions()) {
                    CFG.menus.setVisibleInGame_VictoryConditions(false);
                } else {
                    CFG.menus.rebuildInGame_VictoryConditions();
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
        menuElements.add(new Button_DiplomacyAction(Images.buildAll, CFG.lang.get("BuildingConstructed"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 2, tempElemH, true){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_BuildingsConstructed()) {
                    CFG.menus.setVisibleInGame_BuildingsConstructed(false);
                } else {
                    CFG.menus.rebuildInGame_BuildingsConstructed();
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
        menuElements.add(new Button_DiplomacyAction(Images.diploArmy, CFG.lang.get("Army"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 2, tempElemH, true){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_Army()) {
                    CFG.menus.setVisibleInGame_Army(false);
                } else {
                    CFG.menus.rebuildInGame_Army();
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
        menuElements.add(new Button_DiplomacyAction(Images.diploArmy, CFG.lang.get("RecruitArmy"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 2, tempElemH, true){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_RecruitedArmy()) {
                    CFG.menus.setVisibleInGame_RecruitedArmy(false);
                } else {
                    CFG.menus.rebuildInGame_RecruitedArmy();
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
        menuElements.add(new Button_DiplomacyAction(Images.diploArmy, CFG.lang.get("Demography"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 2, tempElemH, true){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_CensusOfProvince()) {
                    CFG.menus.setVisibleInGame_CensusOfProvince(false);
                } else if (CFG.core.getActiveProvID() >= 0) {
                    CFG.menus.rebuildInGame_CensusOfProvince(CFG.core.getActiveProvID());
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
        menuElements.add(new Button_DiplomacyAction(Images.time, CFG.lang.get("History"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 2, tempElemH, true){

            @Override
            public void actionElem(int iID) {
                if (CFG.menus.getVisibleInGame_History()) {
                    CFG.menus.setVisibleInGame_History(false);
                } else {
                    CFG.menus.rebuildInGame_History();
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
        menuElements.add(new Button_DiplomacyAction(Images.time, CFG.lang.get("Timeline"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 2, tempElemH, true){

            @Override
            public void actionElem(int iID) {
                CFG.core.resetChooseProvinceData_Immediately();
                CFG.core.resetRegroupArmy_Data();
                CFG.menus.setMenuID(View.eTIMELINE);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
        menuElements.add(new Button_DiplomacyAction(Images.stats, CFG.lang.get("Province"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 2, tempElemH, true){

            @Override
            public void actionElem(int iID) {
                if (Menu_InGame_FA_RightRank.iViewMode == 0 && CFG.menus.getVisible_Menu_InGame_Graph()) {
                    CFG.menus.setVisible_Menu_InGame_Graph(false);
                } else {
                    Menu_InGame_FA_RightRank.iViewMode = 0;
                    CFG.menus.rebuildInGame_Graph();
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
        menuElements.add(new Button_DiplomacyAction(Images.stats, CFG.lang.get("Population"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 2, tempElemH, true){

            @Override
            public void actionElem(int iID) {
                if (Menu_InGame_FA_RightRank.iViewMode == 1 && CFG.menus.getVisible_Menu_InGame_Graph()) {
                    CFG.menus.setVisible_Menu_InGame_Graph(false);
                } else {
                    Menu_InGame_FA_RightRank.iViewMode = 1;
                    CFG.menus.rebuildInGame_Graph();
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
        menuElements.add(new Button_DiplomacyAction(Images.stats, CFG.lang.get("TechnologyLevel"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 2, tempElemH, true){

            @Override
            public void actionElem(int iID) {
                if (Menu_InGame_FA_RightRank.iViewMode == 2 && CFG.menus.getVisible_Menu_InGame_Graph()) {
                    CFG.menus.setVisible_Menu_InGame_Graph(false);
                } else {
                    Menu_InGame_FA_RightRank.iViewMode = 2;
                    CFG.menus.rebuildInGame_Graph();
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
        menuElements.add(new Button_DiplomacyAction(Images.stats, CFG.lang.get("RankScore"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempWidth - 2, tempElemH, true){

            @Override
            public void actionElem(int iID) {
                if (Menu_InGame_FA_RightRank.iViewMode == 3 && CFG.menus.getVisible_Menu_InGame_Graph()) {
                    CFG.menus.setVisible_Menu_InGame_Graph(false);
                } else {
                    Menu_InGame_FA_RightRank.iViewMode = 3;
                    CFG.menus.rebuildInGame_Graph();
                }
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(menuElements.size() % 2);
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        int tempMenuPosY = Menu_InGame_Stats.getMenuY();
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("Statistics"), CFG.BUTTON_H * 3 / 4, true, true){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX - 2 - Core.PADDING + iTranslateX, nPosY - this.getHeightT() - IMGManager.getIMG(Images.dialog_title).getHeight() - Core.PADDING, nWidth + Core.PADDING * 2 + 4 - IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING);
                IMGManager.getIMG(Images.dialog_title).draw2O(oSB, nPosX + nWidth + Core.PADDING + 2 - IMGManager.getIMG(Images.dialog_title).getWidth() + iTranslateX, nPosY - this.getHeightT() - Core.PADDING - IMGManager.getIMG(Images.dialog_title).getHeight(), IMGManager.getIMG(Images.dialog_title).getWidth(), this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.29411766f, 0.47058824f, 0.627451f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.29411766f, 0.47058824f, 0.627451f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - CFG.PADD - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, CFG.PADD, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.pix255).getHeight(), nWidth, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.55f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, 1);
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.45f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, nPosX + nWidth - nWidth / 2 + iTranslateX, nPosY - 1 - IMGManager.getIMG(Images.sliderGradient).getHeight(), nWidth / 2, 1, true, false);
                oSB.setColor(Color.WHITE);
                int imgID = Images.stats;
                IMGManager.getIMG(imgID).drawO(oSB, nPosX + (nWidth - (this.getTextWidth() + IMGManager.getIMG(imgID).getWidth() + CFG.PADD)) / 2 + iTranslateX, Menu_InGame_Stats.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(imgID).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + (nWidth - (this.getTextWidth() + IMGManager.getIMG(imgID).getWidth() + CFG.PADD)) / 2 + IMGManager.getIMG(imgID).getWidth() + CFG.PADD + iTranslateX, 2 + nPosY - this.getHeightT() + (this.getHeightT() - this.getTextHeight()) / 2, Color.WHITE);
            }
        }, Menu_InGame_Stats.getMenuX(), tempMenuPosY, tempWidth, Math.min(CFG.GAMEHEIGHT / 2, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD), menuElements, false, true);
        this.updateLang();
        Menu_InGameOfferAlliance.lTime = System.currentTimeMillis();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() - 2 - Core.PADDING + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + Core.PADDING * 2 + 4, this.getHeightM() + CFG.PADD + Core.PADDING, false, true);
        IMGManager.getIMG(Images.gameTopEdge).draw2O(oSB, this.getPosX() + 2 + Core.PADDING + this.getWidthM() - IMGManager.getIMG(Images.gameTopEdge).getWidth() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdge).getHeight() + iTranslateY, IMGManager.getIMG(Images.gameTopEdge).getWidth(), this.getHeightM() + CFG.PADD + Core.PADDING, true, true);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.45f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM() - 4, this.getHeightM() / 4);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + 2 + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, this.getWidthM() - 4, 1);
        oSB.setColor(Color.WHITE);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    public final int getW() {
        return this.getWidthM() - 4;
    }

    public final int getElementW() {
        return this.getW() / 2;
    }
}

