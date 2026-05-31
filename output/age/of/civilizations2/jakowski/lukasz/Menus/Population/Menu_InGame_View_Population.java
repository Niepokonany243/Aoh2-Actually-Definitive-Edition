
package age.of.civilizations2.jakowski.lukasz.Menus.Population;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Build.Button_Build_Text;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_DiplomacyAction;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.ButtonDiplomacy_InGame;
import age.of.civilizations2.jakowski.lukasz.Button.Flag.Button_Flag_JustFrame;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.Population.ButtonN_Pop;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.View.Button_View_Population;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.ConstructionType;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Graphs.Graph2.Graph2;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Plagues.Nuke.NukeManager;
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
import age.of.civilizations2.jakowski.lukasz.Menus.Build.Menu_InGame_Build_Library;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_Decisions;
import age.of.civilizations2.jakowski.lukasz.Menus.Population.Menu_InGame_View_PopulationCiv;
import age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest2.Menu_InGame_View_Army;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextBuildTitle;
import age.of.civilizations2.jakowski.lukasz.TextB.Texts.TextScale;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_View_Population
extends Menu {
    public static long lTime = 0L;
    public static boolean hideAnimation = true;
    public static int iCivID = 0;

    public Menu_InGame_View_Population(int init) {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempWidth = CFG.CIV_INFO_MENU_WIDTH * 2;
        int tY = CFG.PADD;
        menuElements.add(new Button_Flag_JustFrame(CFG.PADD, tY, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        int tempMenuPosY = IMGManager.getIMG(Images.topBar).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 5;
        this.initMenu(new TitleM(CFG.lang.get("Population"), CFG.BUTTON_H * 3 / 5, true, true), CFG.GAMEWIDTH / 2 - tempWidth / 2, tempMenuPosY, tempWidth, ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD + tempMenuPosY > CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 ? Math.max(CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD * 2 - tempMenuPosY, (CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 2) * 6) : ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getPosY() + ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, menuElements, false, true);
        this.updateLang();
    }

    public Menu_InGame_View_Population() {
        boolean nukeButton;
        int tempW = CFG.CIV_INFO_MENU_WIDTH;
        int tY = 0;
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        iCivID = CFG.getActiveCivInfo_BasedOnActiveProvinceID(CFG.core.getActiveProvID());
        int extraW = CFG.BUTTON_W * 3 / 4;
        boolean bl = nukeButton = iCivID != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevel() >= CFG.NUKES_REQUIRED_TECH_LVL || CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.iNukes > 0);
        if (iCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || nukeButton) {
            tempW += extraW;
        }
        ArrayList<Integer> tempProvincesSorted = new ArrayList<Integer>();
        ArrayList<Integer> tempProvs = new ArrayList<Integer>();
        int totalPopulation = 0;
        for (int i = 0; i < CFG.core.getCiv(iCivID).getNumOfProvs(); ++i) {
            if (CFG.FOG_OF_WAR == 2 && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(CFG.core.getCiv(iCivID).getProvID(i))) continue;
            tempProvs.add(CFG.core.getCiv(iCivID).getProvID(i));
            totalPopulation += CFG.core.getProv(CFG.core.getCiv(iCivID).getProvID(i)).getPop().getPops();
        }
        while (!tempProvs.isEmpty()) {
            int tBest = 0;
            for (int i = 1; i < tempProvs.size(); ++i) {
                if (CFG.core.getProv((Integer)tempProvs.get(tBest)).getPop().getPops() >= CFG.core.getProv((Integer)tempProvs.get(i)).getPop().getPops()) continue;
                tBest = i;
            }
            tempProvincesSorted.add((Integer)tempProvs.get(tBest));
            tempProvs.remove(tBest);
        }
        menuElements.add(new Button_DiplomacyAction(Images.pop, CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()) + ": " + CFG.lang.get("Population"), 0, 0, tY, tempW, Menu_InGame_Civ_Decisions.getButtonH(), true){

            @Override
            public void actionElem(int iID) {
                CFG.menus.setVisible_InGame_ViewPopulationAll(true);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()) + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Population"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image_Big(Images.pop, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                long totalPopulation = 0L;
                for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                    if (CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
                    totalPopulation += CFG.core.getCiv(i).countPop();
                }
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Population") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.getNumberWthSpaces("" + totalPopulation), CFG.COLOR_POPULATION));
                nData.add(new ME_Hover_2Type_Image_Big(Images.pop, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(0);
        menuElements.add(new Button_DiplomacyAction(Images.pop, CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()) + ": " + CFG.lang.get("TopProvinces"), 0, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, Menu_InGame_Civ_Decisions.getButtonH(), true){

            @Override
            public void actionElem(int iID) {
                CFG.menus.setVisible_InGame_ViewPopulationProvinces(true);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()) + ": "));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("TopProvinces"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.pop, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(1);
        menuElements.add(new TextBuildTitle(CFG.lang.get("Civilization"), -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE(), tempW, CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4){

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? CFG.COLOR_TEXT_GRAY_NS_HOVER : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_GRAY_NS : Color.WHITE) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }
        });
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
        if (!tempProvincesSorted.isEmpty()) {
            int i;
            int taxesGraphW = Math.max(CFG.BUTTON_W + CFG.BUTTON_W / 4, (int)((float)(tempW - CFG.PADD * 4) * 0.125f)) - CFG.PADD;
            menuElements.add(new ButtonN_Pop(new Color((float)CFG.core.getCiv(iCivID).getR() / 255.0f, (float)CFG.core.getCiv(iCivID).getG() / 255.0f, (float)CFG.core.getCiv(iCivID).getB() / 255.0f, 1.0f), CFG.core.getCiv(iCivID).getCivName(), iCivID, "", CFG.getNumberWthSpaces("" + CFG.core.getCiv(iCivID).countPop()), Images.pop, CFG.COLOR_POPULATION, 0, tY, tempW - taxesGraphW){

                @Override
                public void buildElemHover() {
                    this.menuElemHover = CFG.core.getHover_PopulationOfCiv(this.iCivID);
                }

                @Override
                public void actionElem(int iID) {
                    Menu_InGame_View_PopulationCiv.civID = this.iCivID;
                    CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_POPULATION_OF_CIV_MODE);
                    if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_POPULATION_OF_CIV_MODE) {
                        CFG.toastM.addM(CFG.lang.get("Population"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                    }
                }
            });
            menuElements.add(new Graph2("A", "B", tempW - taxesGraphW, tY, taxesGraphW, CFG.BUTTON_H - 2, true, 1, Graph2.GraphType.CIV_POPULATION, false, iCivID, true){

                @Override
                public void buildElemHover() {
                    boolean metCiv = CFG.FOG_OF_WAR < 2 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(this.id);
                    this.menuElemHover = metCiv ? CFG.core.getHover_PopulationOfCiv(this.id) : CFG.core.getHover_PopulationOfCiv(-1);
                }

                @Override
                public int getGraphWidth() {
                    return this.getWidthE() - this.getGraphButtonWidth();
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 2)).getHeightE();
            ArrayList<Integer> tData = new ArrayList<Integer>();
            ArrayList<Integer> tempNat = new ArrayList<Integer>();
            ArrayList<Long> tempNum = new ArrayList<Long>();
            for (i = 0; i < CFG.core.getCiv(iCivID).getNumOfProvs(); ++i) {
                for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(iCivID).getProvID(i)).getPop().getNatsSize(); ++j) {
                    boolean addNew = true;
                    for (int k = 0; k < tempNat.size(); ++k) {
                        if (((Integer)tempNat.get(k)).intValue() != CFG.core.getProv(CFG.core.getCiv(iCivID).getProvID(i)).getPop().getCivID(j)) continue;
                        tempNum.set(k, tempNum.get(k) + CFG.core.getProv(CFG.core.getCiv(iCivID).getProvID(i)).getPop().getPopulationID(j));
                        addNew = false;
                        break;
                    }
                    if (!addNew) continue;
                    tempNat.add(CFG.core.getProv(CFG.core.getCiv(iCivID).getProvID(i)).getPop().getCivID(j));
                    tempNum.add(CFG.core.getProv(CFG.core.getCiv(iCivID).getProvID(i)).getPop().getPopulationID(j));
                }
            }
            while (!tempNat.isEmpty()) {
                int nMax = 0;
                for (int i2 = 1; i2 < tempNat.size(); ++i2) {
                    if (tempNum.get(nMax) >= tempNum.get(i2)) continue;
                    nMax = i2;
                }
                tData.add((Integer)tempNat.get(nMax));
                tempNat.remove(nMax);
                tempNum.remove(nMax);
            }
            menuElements.add(new ButtonDiplomacy_InGame(Images.pop, tData, 0, tY, tempW - 2){

                @Override
                public void actionElem(int iID) {
                    Menu_InGame_View_PopulationCiv.civID = iCivID;
                    CFG.mapModesManager.setActiveMapModeID(MapModesManager.VIEW_POPULATION_OF_CIV_MODE);
                    if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_POPULATION_OF_CIV_MODE) {
                        CFG.toastM.addM(CFG.lang.get("Population"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                    }
                }
            });
            tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE();
            for (i = 0; i < tempProvincesSorted.size(); ++i) {
                boolean investButton = CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                menuElements.add(new Button_View_Population(i, i + 1 + ". " + (CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getName().length() > 0 ? CFG.core.getProv((Integer)tempProvincesSorted.get(i)).getName() : CFG.core.getCiv(iCivID).getCivName()), (Integer)tempProvincesSorted.get(i), totalPopulation, 0, tY, tempW + (investButton || nukeButton ? -extraW : 0), (CFG.SPECTATOR_MODE || CFG.core.isAlly(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), iCivID)) && CFG.core.getCiv(iCivID).isInConstruction((Integer)tempProvincesSorted.get(i), ConstructionType.LIBRARY) > 0){

                    @Override
                    public void actionElem(int iID) {
                        if (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS && this.getCurr() == CFG.core.getActiveProvID() && CFG.core.getProv(this.getCurr()).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isInConstruction(this.getCurr(), ConstructionType.LIBRARY) <= 0) {
                            if (this.getCurr() >= 0) {
                                CFG.menus.rebuildInGame_BuildLibrary(this.getCurr());
                            }
                        } else {
                            CFG.core.setActiveProvID(this.getCurr());
                            CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                            if (CFG.core.getProv(CFG.core.getActiveProvID()).getName().length() > 0) {
                                CFG.toastM.addM(CFG.core.getProv(CFG.core.getActiveProvID()).getName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                            }
                        }
                    }
                });
                if (nukeButton) {
                    menuElements.add(new Button_Build_Text(">>", tempW - extraW, tY, extraW, Menu_InGame_View_Army.getButtonHeight(), true, (Integer)tempProvincesSorted.get(i)){

                        @Override
                        public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                            if (this.getIsHovered()) {
                                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                            } else {
                                IMGManager.getIMG(Images.nuke).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.nuke).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.nuke).getHeight() / 2 + iTranslateY);
                            }
                        }

                        @Override
                        public void actionElem(int iID) {
                            long out = NukeManager.dropNuke((int)CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), (int)this.getCurr());
                            if (out > 0) {
                                CFG.menus.setVisible_Menu_InGame_CurrentWars(true);
                                CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("AtomicBombing") + ": " + CFG.core.getProv(CFG.core.getActiveProvID()).getProvName(), CFG.lang.get("Casualties") + ": " + CFG.getNumberWthSpaces("" + out), Images.infoNuke);
                                CFG.menus.updateInGame_ProvinceInfoGraph(CFG.core.getActiveProvID());
                            }
                        }

                        @Override
                        public void buildElemHover() {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            if (this.getCurr() >= 0) {
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DropAtomicBomb") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getProv(this.getCurr()).getProvName()));
                                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getProv(this.getCurr()).getTrueOwnerOfProv(), CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Space());
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": "));
                                nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getProv(this.getCurr()).getPop().getPops()), CFG.COLOR_POPULATION));
                                nData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                                for (int a = 0; a < CFG.core.getProv(this.getCurr()).getPop().getNatsSize() && a < 4; ++a) {
                                    nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(this.getCurr()).getPop().getCivID(a), CFG.PADD, 0));
                                }
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Economy") + ": "));
                                nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getProv(this.getCurr()).getEco()), CFG.COLOR_ECONOMY));
                                nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                            nData.add(new ME_Hover_2Type_Space());
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AtomicBombs") + ": "));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.iNukes), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.nuke, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                    });
                    ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr((i + 1) % 2);
                }
                if (investButton) {
                    menuElements.add(new Button_Build_Text(">>", tempW - extraW, tY, extraW, Menu_InGame_View_Army.getButtonHeight(), true, (Integer)tempProvincesSorted.get(i)){

                        @Override
                        public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                            if (this.getIsHovered()) {
                                IMGManager.getIMG(Images.bLibrary).draw(oSB, this.getPosXE() + this.getWidthE() / 2 - IMGManager.getIMG(Images.bLibrary).getWidth() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - IMGManager.getIMG(Images.bLibrary).getHeight() / 2 + iTranslateY);
                            } else {
                                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
                            }
                        }

                        @Override
                        public void actionElem(int iID) {
                            if (CFG.core.getProv(this.getCurr()).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && !CFG.core.getProv(this.getCurr()).isOccupied()) {
                                int actionDone = 0;
                                if (BuildingsManager.constructLibrary(this.getCurr(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) {
                                    ++actionDone;
                                    CFG.gameAction.updateInGame_ProvinceInfo();
                                    if (CFG.menus.getInGame_ProvincemMore_Visible()) {
                                        CFG.menus.setVisible_InGame_ProvinceMore(true, true);
                                    }
                                    if (CFG.mapModesManager.getActiveMapModeID() == MapModesManager.VIEW_POPULATION_MODE) {
                                        CFG.core.getProv((int)this.getCurr()).viewBool = true;
                                        if (CFG.menus.getVisible_InGame_View_Stats()) {
                                            CFG.menus.setVisible_InGame_View(true);
                                        }
                                    }
                                    CFG.SFXManager.playSound(SFXManager.SFX_LIBRARY);
                                }
                                if (actionDone > 0) {
                                    CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                                    CFG.toastM.addM(CFG.lang.get("Done") + ": " + actionDone, CFG.COLOR_POSITIVE);
                                    CFG.toastM.setTimeInView(3500);
                                }
                            }
                        }

                        @Override
                        public void buildElemHover() {
                            this.menuElemHover = Menu_InGame_Build_Library.getHoverLibrary(this.getCurr());
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
        this.initMenu(new TitleM_TextSmall(CFG.lang.get("Population"), CFG.BUTTON_H * 3 / 5, false, false){

            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_InGame_View_Population.this.getPosX() + iTranslateX, Menu_InGame_View_Population.this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_InGame_View_Population.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(CFG.COLOR_POPULATION.r, CFG.COLOR_POPULATION.g, CFG.COLOR_POPULATION.b, 0.165f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(CFG.COLOR_POPULATION.r, CFG.COLOR_POPULATION.g, CFG.COLOR_POPULATION.b, 0.375f));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_InGame_View_Population.this.getPosX() + iTranslateX, Menu_InGame_View_Population.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_InGame_View_Population.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_Population.this.getPosX() + iTranslateX, Menu_InGame_View_Population.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_InGame_View_Population.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_InGame_View_Population.this.getPosX() + iTranslateX, Menu_InGame_View_Population.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() - 1, Menu_InGame_View_Population.this.getWidthM(), 1);
                oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.8f));
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_Population.this.getPosX() + iTranslateX, Menu_InGame_View_Population.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_Population.this.getWidthM() / 4, 1);
                IMGManager.getIMG(Images.sliderGradient).drawO(oSB, Menu_InGame_View_Population.this.getPosX() + Menu_InGame_View_Population.this.getWidthM() - Menu_InGame_View_Population.this.getWidthM() / 4 + iTranslateX, Menu_InGame_View_Population.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.sliderGradient).getHeight(), Menu_InGame_View_Population.this.getWidthM() / 4, 1, true, false);
                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(Images.pop).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, Menu_InGame_View_Population.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(Images.pop).getHeight() / 2);
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
}

