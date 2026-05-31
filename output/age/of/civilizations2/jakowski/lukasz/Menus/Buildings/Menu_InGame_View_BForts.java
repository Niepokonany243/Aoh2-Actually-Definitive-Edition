/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Buildings;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build_Level2;
import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build_Text;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_ActionAll;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Options.Button_Opt_MapModesNormal;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Population.ButtonN_Pop;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.Button_Icon;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.ConstructionType;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Build.Menu_InGame_Build_Fort;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_View_BForts
extends Menu {
    public static long lTime = 0L;
    public static boolean hideAnimation = true;
    private int iCivID = 0;

    public Menu_InGame_View_BForts() {
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        int tY = 0;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.iCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(CFG.core.getActiveProvID());
        int extraW = CFG.BUTTON_W * 3 / 4;
        if (this.iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
            tempW += extraW;
        }
        int worldTotal = 0;
        if (this.iCivID != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
            int a;
            ArrayList<Integer> tCivs = new ArrayList<Integer>();
            ArrayList<Integer> tNum = new ArrayList<Integer>();
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
                int tTotal = 0;
                for (a = 0; a < CFG.core.getCiv(i).getNumOfProvs(); ++a) {
                    tTotal += CFG.core.getProv(CFG.core.getCiv(i).getProvID(a)).getLvlOfFort();
                }
                worldTotal += tTotal;
                tCivs.add(i);
                tNum.add(tTotal);
            }
            int tRow = 0;
            while (!tCivs.isEmpty()) {
                int tBestID = 0;
                int aSize = tCivs.size();
                for (a = 1; a < aSize; ++a) {
                    if ((Integer)tNum.get(tBestID) >= (Integer)tNum.get(a)) continue;
                    tBestID = a;
                }
                if ((Integer)tNum.get(tBestID) == 0) break;
                boolean met = CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv((Integer)tCivs.get(tBestID));
                menuElements.add(new ButtonN_Pop(new Color((float)CFG.core.getCiv((Integer)tCivs.get(tBestID)).getR() / 255.0f, (float)CFG.core.getCiv((Integer)tCivs.get(tBestID)).getG() / 255.0f, (float)CFG.core.getCiv((Integer)tCivs.get(tBestID)).getB() / 255.0f, 1.0f), tRow + 1 + ". " + (met ? CFG.core.getCiv((Integer)tCivs.get(tBestID)).getCivName() : CFG.lang.get("Undiscovered")), met ? (Integer)tCivs.get(tBestID) : -1, CFG.lang.get("Buildings") + ": ", CFG.getNumberWthSpaces("" + tNum.get(tBestID)), Images.bFort, CFG.COLOR_TEXT_NUM_OF_PROVINCES, 0, tY, tempW){

                    @Override
                    public void actionElem(int iID) {
                        if (this.iCivID > 0) {
                            CFG.map.getMpC().centerToCapital_OrMetProvinceCivID(this.iCivID);
                        }
                    }

                    @Override
                    public void actionElemPPM() {
                        if (this.iCivID > 0) {
                            CFG.map.getMpC().centerToCapital_OrMetProvinceCivID(this.iCivID);
                        }
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Flag_Big(this.iCivID, 0, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Text_Big(this.getTextE(), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text_Big(this.sDeathsTEXT));
                        nData.add(new ME_Hover_2Type_Text_Big(this.sDeaths, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.bFort, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(tRow++ % 2);
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                tCivs.remove(tBestID);
                tNum.remove(tBestID);
            }
            if (menuElements.size() == 0) {
                menuElements.add(new TextScale(CFG.lang.get("NoData"), -1, 0, tY, tempW, CFG.BUTTON_H * 3 / 4, 0.75f));
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        } else {
            ArrayList<Integer> tempProvincesSorted = new ArrayList<Integer>();
            ArrayList<Integer> tempProvs = new ArrayList<Integer>();
            int buildingsTotal = 0;
            for (int i = 0; i < CFG.core.getCiv(this.iCivID).getNumOfProvs(); ++i) {
                if (CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(this.iCivID).getProvID(i))) continue;
                tempProvs.add(CFG.core.getCiv(this.iCivID).getProvID(i));
                if (CFG.core.getProv(CFG.core.getCiv(this.iCivID).getProvID(i)).getLvlOfFort() <= 0) continue;
                buildingsTotal += CFG.core.getProv(CFG.core.getCiv(this.iCivID).getProvID(i)).getLvlOfFort();
            }
            while (!tempProvs.isEmpty()) {
                int tBest = 0;
                for (int i = 1; i < tempProvs.size(); ++i) {
                    if (CFG.core.getProv((Integer)tempProvs.get(tBest)).getPop().getPops() <= CFG.core.getProv((Integer)tempProvs.get(i)).getPop().getPops()) continue;
                    tBest = i;
                }
                tempProvincesSorted.add((Integer)tempProvs.get(tBest));
                tempProvs.remove(tBest);
            }
            int buttonH = Math.max(CFG.BUTTON_H * 3 / 4, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4);
            boolean row = false;
            if (!tempProvincesSorted.isEmpty()) {
                menuElements.add(new ButtonN_Pop(new Color((float)CFG.core.getCiv(this.iCivID).getR() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getG() / 255.0f, (float)CFG.core.getCiv(this.iCivID).getB() / 255.0f, 1.0f), CFG.core.getCiv(this.iCivID).getCivName(), this.iCivID, CFG.lang.get("Buildings") + ": " + CFG.lang.get("Fort") + " - ", CFG.getNumberWthSpaces("" + buildingsTotal), Images.bFort, CFG.COLOR_TEXT_NUM_OF_PROVINCES, 0, tY, tempW){

                    @Override
                    public void actionElemPPM() {
                        if (this.iCivID > 0) {
                            CFG.map.getMpC().centerToCapital_OrMetProvinceCivID(this.iCivID);
                        }
                    }
                });
                menuElements.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get("Build") + ": " + CFG.lang.get(BuildingsManager.getFort_Name(1)) + ": " + CFG.lang.get("AllProvinces"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.fortAllProvinces_Number(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getNumber_SHORT(CFG.core.fortAllProvinces_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getPrecision2(CFG.core.fortAllProvinces_CostMovement(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 10), Images.topMovementPoints, CFG.COLOR_MOVEMENT, Images.bFort, CFG.COLOR_TEXT_NUM_OF_PROVINCES, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, CFG.BUTTON_H){

                    @Override
                    public void actionElem(int iID) {
                        CFG.setDialogType(DialogType.ALL_FORT);
                    }

                    @Override
                    public void actionElemPPM() {
                        CFG.core.fortAllProvinces(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    }
                });
                int nX = 0;
                int nW = tempW / 8;
                menuElements.add(new Button_Icon(nX, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), nW, buttonH, Images.bTower){

                    @Override
                    public void actionElem(int iID) {
                        CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_WATCH_TOWER_MODE, false);
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("WatchTower"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.bTower, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                menuElements.add(new Button_Icon(nX += nW, tY, nW, buttonH, Images.bPort){

                    @Override
                    public void actionElem(int iID) {
                        CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_PORT_MODE, false);
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Port"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.bPort, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                menuElements.add(new Button_Icon(nX += nW, tY, nW, buttonH, Images.bFarm){

                    @Override
                    public void actionElem(int iID) {
                        CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_FARM_MODE, false);
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Farm"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.bFarm, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                menuElements.add(new Button_Icon(nX += nW, tY, nW, buttonH, Images.bWorkshop){

                    @Override
                    public void actionElem(int iID) {
                        CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_WORKSHOP_MODE, false);
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Workshop"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.bWorkshop, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                menuElements.add(new Button_Icon(nX += nW, tY, nW, buttonH, Images.bMarket){

                    @Override
                    public void actionElem(int iID) {
                        CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_MARKET_MODE, false);
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Market"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.bMarket, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                menuElements.add(new Button_Icon(nX += nW, tY, nW, buttonH, Images.bLibrary){

                    @Override
                    public void actionElem(int iID) {
                        CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_LIBRARY_MODE, false);
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Library"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.bLibrary, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                menuElements.add(new Button_Icon(nX += nW, tY, nW, buttonH, Images.bArmoury){

                    @Override
                    public void actionElem(int iID) {
                        CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_ARMOURY_MODE, false);
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Armoury"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.bArmoury, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                menuElements.add(new Button_Icon(nX += nW, tY, tempW - nX, buttonH, Images.bSupply){

                    @Override
                    public void actionElem(int iID) {
                        CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_LEVEL_OF_SUPPLY_MODE, false);
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("MapMode") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SupplyCamp"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.bSupply, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                nX += nW;
                menuElements.add(new Button_Opt_MapModesNormal(0, CFG.lang.get("BuildBySelectingAProvinceOnTheMap"), -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, buttonH, true, true){

                    @Override
                    public void actionElem(int iID) {
                        BuildingsManager.buildBySelectingProvinceOnMap = !BuildingsManager.buildBySelectingProvinceOnMap;
                    }

                    @Override
                    public boolean getCheckboxSt() {
                        return BuildingsManager.buildBySelectingProvinceOnMap;
                    }
                });
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                for (int i = tempProvincesSorted.size() - 1; i >= 0; --i) {
                    boolean investButton = CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                    menuElements.add(new Button_Build_Level2(CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getProvName(), Images.bFort, "" + CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getLvlOfFort(), BuildingsManager.getFort_BuildCost(CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getLvlOfFort() + 1, (Integer)tempProvincesSorted.get(i)), BuildingsManager.getFort_BuildMovementCost(CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getLvlOfFort() + 1), 0, tY, tempW + (investButton ? -extraW : 0), true, CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getLvlOfFort() == BuildingsManager.getFort_MaxLevel(), CFG.core.getCiv(CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getCivId()).isInConstruction((Integer)tempProvincesSorted.get(i), ConstructionType.FORT), BuildingsManager.getFort_TechLevel(CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getLvlOfFort() + 1), (Integer)tempProvincesSorted.get(i)){

                        @Override
                        public void actionElem(int iID) {
                            if (CFG.core.getProv(this.getCurr()).getLvlOfFort() == BuildingsManager.getFort_MaxLevel()) {
                                CFG.toastM.addM(CFG.lang.get("Built"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                            } else if (CFG.core.getCiv(CFG.core.getProv(this.getCurr()).getCivId()).isInConstruction(this.getCurr(), ConstructionType.FORT) > 0) {
                                CFG.toastM.addM(CFG.lang.get("InConstruction"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                            } else {
                                CFG.menus.rebuildInGame_BuildFort(this.getCurr());
                            }
                        }

                        @Override
                        public void actionElemPPM() {
                            Menu_InGame_View_BForts.build(this.getCurr());
                        }

                        @Override
                        public void buildElemHover() {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            if (CFG.core.getProv(this.getCurr()).getLvlOfFort() == BuildingsManager.getFort_MaxLevel()) {
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Fortress") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(this.getCurr()).getName().length() > 0 ? CFG.core.getProv(this.getCurr()).getName() : CFG.lang.get("Province")));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(this.getCurr()).getCivId(), CFG.PADD, 0));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.iconTrue, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text(" - "));
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("HidesTheArmyFromTheSightOfViewOfWatchTower"), CFG.COLOR_HOVER_TITLE));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text(" - "));
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefenseBonus") + ": "));
                                nData.add(new ME_Hover_2Type_Text("+" + BuildingsManager.getFort_DefenseBonus(CFG.core.getProv(this.getCurr()).getLvlOfFort()) + "%", CFG.COLOR_POSITIVE));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            } else if (CFG.core.getCiv(CFG.core.getProv(this.getCurr()).getCivId()).isInConstruction(this.getCurr(), ConstructionType.FORT) > 0) {
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("InConstruction"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text(GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getCiv(CFG.core.getProv(this.getCurr()).getCivId()).isInConstruction(this.getCurr(), ConstructionType.FORT))));
                                nData.add(new ME_Hover_2Type_Text(" [" + CFG.lang.get("TurnsX", CFG.core.getCiv(CFG.core.getProv(this.getCurr()).getCivId()).isInConstruction(this.getCurr(), ConstructionType.FORT)) + "]", CFG.COLOR_NEUTRAL));
                                nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Space());
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(CFG.core.getProv(this.getCurr()).getLvlOfFort() == 0 ? "Castle" : "Fortress") + ": ", CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(this.getCurr()).getName().length() > 0 ? CFG.core.getProv(this.getCurr()).getName() : CFG.lang.get("Province")));
                                nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(this.getCurr()).getCivId(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            } else {
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get(CFG.core.getProv(this.getCurr()).getLvlOfFort() == 0 ? "BuildCastleIn" : "BuildFortressIn") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(this.getCurr()).getName().length() > 0 ? CFG.core.getProv(this.getCurr()).getName() : CFG.lang.get("Province")));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(this.getCurr()).getCivId(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text(" - "));
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("HidesTheArmyFromTheSightOfViewOfWatchTower"), CFG.COLOR_HOVER_TITLE));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text(" - "));
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefenseBonus") + ": "));
                                nData.add(new ME_Hover_2Type_Text("+" + BuildingsManager.getFort_DefenseBonus(CFG.core.getProv(this.getCurr()).getLvlOfFort() + 1) + "%", CFG.COLOR_POSITIVE));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Space());
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Cost") + ": "));
                                nData.add(new ME_Hover_2Type_Text("" + BuildingsManager.getFort_BuildCost(CFG.core.getProv(this.getCurr()).getLvlOfFort() + 1, this.getCurr()), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() >= (long)BuildingsManager.getFort_BuildCost(CFG.core.getProv(this.getCurr()).getLvlOfFort() + 1, this.getCurr()) ? CFG.COLOR_GOLD : CFG.COLOR_NEGATIVE_2));
                                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MovementPoints") + ": "));
                                nData.add(new ME_Hover_2Type_Text("" + (float)BuildingsManager.getFort_BuildMovementCost(CFG.core.getProv(this.getCurr()).getLvlOfFort() + 1) / 10.0f, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getMovemPoints() >= BuildingsManager.getFort_BuildMovementCost(CFG.core.getProv(this.getCurr()).getLvlOfFort() + 1) ? CFG.COLOR_MOVEMENT : CFG.COLOR_NEGATIVE_2));
                                nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ConstructionWillTakeXurns", BuildingsManager.getFort_Construction(CFG.core.getProv(this.getCurr()).getLvlOfFort() + 1))));
                                nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RequiredTechnologyLevel") + ": "));
                                nData.add(new ME_Hover_2Type_Text("" + (float)((int)(BuildingsManager.getFort_TechLevel(CFG.core.getProv(this.getCurr()).getLvlOfFort() + 1) * 100.0f)) / 100.0f, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() >= BuildingsManager.getFort_TechLevel(CFG.core.getProv(this.getCurr()).getLvlOfFort() + 1) ? CFG.COLOR_TECHNOLOGY : CFG.COLOR_NEGATIVE_2));
                                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                                nData.add(new ME_Hover_2Type_Image(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() >= BuildingsManager.getFort_TechLevel(CFG.core.getProv(this.getCurr()).getLvlOfFort() + 1) ? Images.iconTrue : Images.iconFalse, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                    });
                    ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setHeightE(buttonH);
                    ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr((i + 1) % 2);
                    if (investButton) {
                        menuElements.add(new Button_Build_Text(">>", tempW - extraW, tY, extraW, buttonH, true, (Integer)tempProvincesSorted.get(i)){

                            @Override
                            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                                if (this.getIsHovered()) {
                                    IMGManager.getIMG(Images.bFort).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.bFort).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.bFort).getHeight() / 2 + iTranslateY);
                                } else {
                                    super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                                }
                            }

                            @Override
                            public void actionElem(int iID) {
                                Menu_InGame_View_BForts.build(this.getCurr());
                            }

                            @Override
                            public void buildElemHover() {
                                this.menuElemHover = Menu_InGame_Build_Fort.getHoverFort(this.getCurr());
                            }
                        });
                        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr((i + 1) % 2);
                    }
                    tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
                }
            } else {
                menuElements.add(new TextScale(CFG.lang.get("NoData"), -1, 0, tY, tempW, CFG.BUTTON_H * 3 / 4, 0.75f));
                tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            }
        }
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("Fort") + (worldTotal > 0 ? " [" + CFG.getNumberWthSpaces("" + worldTotal) + "]" : ""), CFG.BUTTON_H * 3 / 5, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_InGame_View_BForts.this.getPosX() + iTranslateX, Menu_InGame_View_BForts.this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_InGame_View_BForts.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.27450982f, 0.27450982f, 0.27450982f, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.27450982f, 0.27450982f, 0.27450982f, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_InGame_View_BForts.this.getPosX() + iTranslateX, Menu_InGame_View_BForts.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_InGame_View_BForts.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_BForts.this.getPosX() + iTranslateX, Menu_InGame_View_BForts.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_InGame_View_BForts.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_BForts.this.getPosX() + iTranslateX, Menu_InGame_View_BForts.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() - 1, Menu_InGame_View_BForts.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_BForts.this.getPosX() + iTranslateX, Menu_InGame_View_BForts.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_BForts.this.getWidthM() / 4, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_BForts.this.getPosX() + Menu_InGame_View_BForts.this.getWidthM() - Menu_InGame_View_BForts.this.getWidthM() / 4 + iTranslateX, Menu_InGame_View_BForts.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_BForts.this.getWidthM() / 4, 1, true, false);
                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(Images.bFort).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, Menu_InGame_View_BForts.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(Images.bFort).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth / 2 - this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - this.getTextHeight() / 2, Color.WHITE);
            }
        }, AoCGame.LEFT, IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 5, tempW, Math.min(tY + 1, CFG.isAndroid() && !CFG.LANDSCAPE ? (CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 4 + (CFG.PADD * 2 + CFG.BUTTON_H) * 2)) / 2 : CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topFlagBG).getHeight() + CFG.PADD * 3 + CFG.BUTTON_H * 3 / 4 + (GameValues.gvInGame.MAP_MODES_MENUS_TO_PROVINCE_INFO ? (CFG.PADD * 2 + CFG.BUTTON_H) * 2 : 0))), menuElements, false, true);
        this.updateLang();
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (lTime + (long)GameValues.gvInGame.MENUS_ANIMATION_TIME >= System.currentTimeMillis()) {
            iTranslateX = hideAnimation ? (iTranslateX -= (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME))) : (iTranslateX += -this.getWidthM() + (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME)));
            CFG.setRenderO(true);
        } else if (hideAnimation) {
            super.setVisibleM(false);
            return;
        }
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + 2 + Core.PADDING, this.getHeightM() + CFG.PADD, true, true);
        oSB.setColor(new Color(0.09803922f, 0.05882353f, 0.37254903f, 0.25f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), CFG.PADD * 4);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.65f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() + iTranslateY, this.getWidthM(), CFG.PADD * 2);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM() + CFG.PADD, this.getWidthM());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.sliderGradient).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight() + this.getHeightM() + CFG.PADD, this.getWidthM(), 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM() + CFG.PADD, this.getWidthM() + 2);
        oSB.setColor(Color.WHITE);
    }

    @Override
    public void actionEL(int iID) {
        this.getMenuElem(iID).actionElem(iID);
    }

    @Override
    public void setVisibleM(boolean visible) {
        if (visible) {
            super.setVisibleM(visible);
            this.setHideAnimation(false);
        } else {
            this.setHideAnimation(true);
        }
    }

    public final void setHideAnimation(boolean nHideAnimation) {
        if (nHideAnimation != hideAnimation) {
            lTime = lTime > System.currentTimeMillis() - (long)GameValues.gvInGame.MENUS_ANIMATION_TIME ? System.currentTimeMillis() - ((long)GameValues.gvInGame.MENUS_ANIMATION_TIME - (System.currentTimeMillis() - lTime)) : System.currentTimeMillis();
            CFG.setRenderO(true);
        }
        hideAnimation = nHideAnimation;
    }

    public static void build(int provinceID) {
        if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() < (long)BuildingsManager.getFort_BuildCost(CFG.core.getProv(provinceID).getLvlOfFort() + 1, provinceID)) {
            CFG.toastM.addM(CFG.lang.get("InsufficientGold") + ": " + CFG.getNumberWthSpaces("" + BuildingsManager.getFort_BuildCost(CFG.core.getProv(provinceID).getLvlOfFort() + 1, provinceID)), CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(3500);
        } else if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getMovemPoints() < BuildingsManager.getFort_BuildMovementCost(CFG.core.getProv(provinceID).getLvlOfFort() + 1)) {
            CFG.toastM.addM(CFG.lang.get("MovementPoints") + ": " + (float)BuildingsManager.getFort_BuildMovementCost(CFG.core.getProv(provinceID).getLvlOfFort() + 1) / 10.0f, CFG.COLOR_NEGATIVE_2);
            CFG.toastM.setTimeInView(3500);
        }
        if (BuildingsManager.constructFort(provinceID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) {
            CFG.toastM.addM(CFG.lang.get("Ok") + "!", CFG.COLOR_POSITIVE);
            CFG.toastM.setTimeInView(3500);
            CFG.gameAction.updateInGame_ProvinceInfo();
            if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                CFG.menus.setVisible_InGame_ProvinceMore(true, true);
            }
            if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_LEVEL_OF_FORTIFICATIONS_MODE && CFG.menus.getVisible_InGame_View_Stats()) {
                CFG.menus.setVisible_InGame_ViewBForts(true);
            }
        }
        CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
    }
}

