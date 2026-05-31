/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Editors;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Description;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LR_Line;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_ReflectedBG;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Scenario;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Editor.ExportScenarioAsMod;
import age.of.civilizations2.jakowski.lukasz.Events_GameData;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.Game_Scenarios;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Civs.Select.Menu_CreateScenario_Civilizations_Select_List;
import age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Choose.Menu_ChooseScenario;
import age.of.civilizations2.jakowski.lukasz.Province_Cores_GameData;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.Undo.Undo_AssignProvinceCiv;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_Editor_Scenarios
extends Menu {
    public boolean addGenerate = true;

    public Menu_Editor_Scenarios() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        this.addGenerate = CFG.getIsDesktop();
        try {
            Menu_ChooseScenario.loadPreview();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        menuElements.add(new Button_Classic_Description(CFG.map.getMapAuthor(CFG.map.getActiveMapIDN()), CFG.lang.get("MapType") + ": " + CFG.map.getMapName(CFG.map.getActiveMapIDN()), (int)(50.0f * CFG.GUI_SCALE), 0 + AoCGame.LEFT, CFG.PADD, CFG.GAMEWIDTH - AoCGame.LEFT, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("LandProvinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.countLandProvinces(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SeaProvinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.countSeaProvinces(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic_LR_Line(null, -1, 0 + AoCGame.LEFT, CFG.BUTTON_H + CFG.PADD * 2, CFG.GAMEWIDTH - AoCGame.LEFT, CFG.BUTTON_H, true));
        for (int i = 0; i < Game_Scenarios.SCENARIOS_SIZE; ++i) {
            menuElements.add(new Button_Classic_Scenario(i, "", (int)(50.0f * CFG.GUI_SCALE), 0 + AoCGame.LEFT, CFG.BUTTON_H * (i + 2) + CFG.PADD * (i + 3), CFG.GAMEWIDTH - AoCGame.LEFT - CFG.BUTTON_W * 2 - (this.addGenerate ? CFG.BUTTON_W * 2 : 0), CFG.BUTTON_H, true){

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(this.getCurr())), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text(CFG.core.getGameScenars().getScenarioDay(this.getCurr()) + " " + GameCalendar.getMonthName(CFG.core.getGameScenars().getScenarioMonth(this.getCurr())) + " " + CFG.gameAges.getYear(CFG.core.getGameScenars().getScenarioYearID(this.getCurr())), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.gameAges.getAge(CFG.core.getGameScenars().getScenarioAgeID(this.getCurr())).getName()));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Civilizations") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioNumOfCivs(this.getCurr()), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Author") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioAuthorID(this.getCurr()), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Tag") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioTagID(this.getCurr()), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            if (this.addGenerate) {
                menuElements.add(new Button_Classic_Description(CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(i)), CFG.lang.get("Generate") + ": " + CFG.lang.get("Mod"), CFG.PADD * 2, CFG.GAMEWIDTH - AoCGame.LEFT - CFG.BUTTON_W * 2 - CFG.BUTTON_W * 2, CFG.BUTTON_H * (i + 2) + CFG.PADD * (i + 3), CFG.BUTTON_W * 2, CFG.BUTTON_H, true){
                    int id;
                    {
                        this.id = 0;
                    }

                    @Override
                    public int getCurr() {
                        return this.id;
                    }

                    @Override
                    public void setCurr(int nCurrent) {
                        this.id = nCurrent;
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Generate") + ": " + CFG.lang.get("Mod"), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(this.getCurr())), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Text(CFG.core.getGameScenars().getScenarioDay(this.getCurr()) + " " + GameCalendar.getMonthName(CFG.core.getGameScenars().getScenarioMonth(this.getCurr())) + " " + CFG.gameAges.getYear(CFG.core.getGameScenars().getScenarioYearID(this.getCurr())), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.gameAges.getAge(CFG.core.getGameScenars().getScenarioAgeID(this.getCurr())).getName()));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Civilizations") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioNumOfCivs(this.getCurr()), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Author") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioAuthorID(this.getCurr()), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Tag") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioTagID(this.getCurr()), CFG.COLOR_HOVER_TITLE));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
            }
            menuElements.add(new Button_Classic_ReflectedBG(CFG.lang.get("Copy"), -1, CFG.GAMEWIDTH - CFG.BUTTON_W * 2, CFG.BUTTON_H * (i + 2) + CFG.PADD * (i + 3), CFG.BUTTON_W * 2, CFG.BUTTON_H, true){
                int id;
                {
                    this.id = 0;
                }

                @Override
                public int getCurr() {
                    return this.id;
                }

                @Override
                public void setCurr(int nCurrent) {
                    this.id = nCurrent;
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(this.getCurr())), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text(CFG.core.getGameScenars().getScenarioDay(this.getCurr()) + " " + GameCalendar.getMonthName(CFG.core.getGameScenars().getScenarioMonth(this.getCurr())) + " " + CFG.gameAges.getYear(CFG.core.getGameScenars().getScenarioYearID(this.getCurr())), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.gameAges.getAge(CFG.core.getGameScenars().getScenarioAgeID(this.getCurr())).getName()));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Civilizations") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioNumOfCivs(this.getCurr()), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Author") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioAuthorID(this.getCurr()), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Tag") + ": "));
                    nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioTagID(this.getCurr()), CFG.COLOR_HOVER_TITLE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            ((MenuElemUI)menuElements.get(menuElements.size() - 1)).setCurr(i);
        }
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H - CFG.PADD, menuElements);
        this.updateLang();
        CFG.lCreateScenario_UndoAssignProvsCivID = new ArrayList<Undo_AssignProvinceCiv>();
        CFG.lCreateScenario_UndoWastelandProvinces = new ArrayList<Integer>();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(1).setTextE(CFG.lang.get("CreateNewScenario"));
        if (this.addGenerate) {
            for (int i = 0; i < Game_Scenarios.SCENARIOS_SIZE; ++i) {
                this.getMenuElem(i * 3 + 2).setTextE(CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(i)));
            }
        } else {
            for (int i = 0; i < Game_Scenarios.SCENARIOS_SIZE; ++i) {
                this.getMenuElem(i * 2 + 2).setTextE(CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(i)));
            }
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.map.getIcon(CFG.map.getActiveMapIDN()).drawO(oSB, this.getMenuElem(0).getPosXE() + this.getMenuElem(0).getTextPosElem() / 2 - CFG.map.getIcon(CFG.map.getActiveMapIDN()).getWidth() / 2 + iTranslateX, this.getMenuElem(0).getPosY() + this.getMenuElem(0).getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + this.getMenuPosY() - CFG.map.getIcon(CFG.map.getActiveMapIDN()).getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public final void actionEL(int iID) {
        Menu_CreateScenario_Civilizations_Select_List.allTags.clear();
        Menu_CreateScenario_Civilizations_Select_List.allNames.clear();
        switch (iID) {
            case 0: {
                CFG.backToMenu = View.eEDITOR_SCENARIOS;
                CFG.menus.setMenuID(View.eSELECT_MAP_TYPE);
                return;
            }
            case 1: {
                CFG.province_CoresGD = new Province_Cores_GameData();
                CFG.chosenAlphabetCharachter = null;
                CFG.RELOAD_SCENARIO = true;
                if (CFG.FOG_OF_WAR > 1) {
                    CFG.FOG_OF_WAR = 1;
                }
                CFG.core.initPlayers();
                CFG.core.getPlayer(0).setCivId(0);
                CFG.palletManager.setActivePalletID(0);
                CFG.createScenarioAssignProvsCiv = 0;
                CFG.lCreateScenario_UndoAssignProvsCivID.clear();
                CFG.lCreateScenario_UndoWastelandProvinces.clear();
                CFG.eventsManager.events = new Events_GameData();
                CFG.core.setActiveProvID(-1);
                CFG.core.createScenarioClearCivilizations();
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_WASTELAND);
                CFG.CREATE_SCENARIO_NAME = "";
                CFG.CREATE_SCENARIO_AUTHOR = "";
                CFG.CREATE_SCENARIO_WIKI = "";
                CFG.CREATE_SCENARIO_GAME_DATA_TAG = "" + System.currentTimeMillis() + CFG.extraRandomTag();
                CFG.CREATE_SCENARIO_AGE = 0;
                GameCalendar.currYear = CFG.gameAges.getAge(CFG.CREATE_SCENARIO_AGE).getBeginningYear();
                GameCalendar.ENABLE_COLONIZATION = false;
                GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES = false;
                GameCalendar.COLONIZATION_TECH_LEVEL = 0.8f;
                CFG.CREATE_SCENARIO_IS_PART_OF_CAMPAIGN = false;
                CFG.lCREATE_SCENARIO_IS_PART_OF_CAMPAIGN_CIVSIDS.clear();
                CFG.buildCreateScenario_TechnologyLevelsByContinents();
                CFG.map.getMpB().disposeMinimapOfCivilizations();
                CFG.core.getGameScenars().setScenarioStartingArmyInCapitals(750);
                CFG.core.getGameScenars().setScenarioStartingPopulation(65000);
                CFG.core.getGameScenars().setScenarioStartingEconomy(32000);
                CFG.core.getGameScenars().setScenarioStartingMoney(4500);
                CFG.core.getGameScenars().setScenarioActivePallet_TAG(null);
                return;
            }
        }
        if (this.addGenerate) {
            if ((iID - 2) % 3 == 1) {
                ExportScenarioAsMod.exportScenario(CFG.core.getGameScenars().getScenarioTagID(this.getMenuElem(iID).getCurr()), CFG.core.getGameScenars().getScenarioNameID(this.getMenuElem(iID).getCurr()), CFG.core.getGameScenars().getScenarioYearID(this.getMenuElem(iID).getCurr()));
                CFG.menus.setMenuID(View.eWORKSHOP);
                CFG.toastM.addM(CFG.lang.get("Done") + ": Now share the mod scenario to the Steam Workshop");
            } else {
                CFG.chosenAlphabetCharachter = null;
                CFG.RELOAD_SCENARIO = true;
                if (CFG.FOG_OF_WAR > 1) {
                    CFG.FOG_OF_WAR = 1;
                }
                CFG.core.initPlayers();
                CFG.core.getPlayer(0).setCivId(0);
                CFG.core.setActiveProvID(-1);
                CFG.createScenarioAssignProvsCiv = 0;
                CFG.lCreateScenario_UndoAssignProvsCivID.clear();
                CFG.lCreateScenario_UndoWastelandProvinces.clear();
                CFG.core.getGameScenars().editScenario(this.getMenuElem(iID).getCurr());
                CFG.core.getGameScenars().loadArmiesData();
                if ((iID - 2) % 3 == 2) {
                    CFG.CREATE_SCENARIO_GAME_DATA_TAG = "" + System.currentTimeMillis() + CFG.extraRandomTag();
                }
                CFG.menus.setMenuID(View.eCREATE_SCENARIO_CIVILIZATIONS);
                CFG.map.getMpB().disposeMinimapOfCivilizations();
            }
        } else {
            CFG.chosenAlphabetCharachter = null;
            CFG.RELOAD_SCENARIO = true;
            if (CFG.FOG_OF_WAR > 1) {
                CFG.FOG_OF_WAR = 1;
            }
            CFG.core.initPlayers();
            CFG.core.getPlayer(0).setCivId(0);
            CFG.core.setActiveProvID(-1);
            CFG.createScenarioAssignProvsCiv = 0;
            CFG.lCreateScenario_UndoAssignProvsCivID.clear();
            CFG.lCreateScenario_UndoWastelandProvinces.clear();
            CFG.core.getGameScenars().editScenario(this.getMenuElem(iID).getCurr());
            CFG.core.getGameScenars().loadArmiesData();
            if ((iID - 2) % 2 == 1) {
                CFG.CREATE_SCENARIO_GAME_DATA_TAG = "" + System.currentTimeMillis() + CFG.extraRandomTag();
            }
            CFG.menus.setMenuID(View.eCREATE_SCENARIO_CIVILIZATIONS);
            CFG.map.getMpB().disposeMinimapOfCivilizations();
        }
    }

    @Override
    public void onBackPressed() {
        Menu_ChooseScenario.disposePreview();
    }
}

