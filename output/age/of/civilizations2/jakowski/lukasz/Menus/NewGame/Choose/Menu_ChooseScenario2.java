/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Choose;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Button_Gor;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_ReflectedBG;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Scenario;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.Game_Scenarios;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Load.Scenario.Menu_LoadScenario;
import age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Choose.Menu_ChooseScenario;
import age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Choose.Menu_ChooseScenario_Title;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;
import java.util.Random;

public class Menu_ChooseScenario2
extends Menu {
    public Menu_ChooseScenario2() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        if (CFG.map.getFile_ActiveMap_Path2().equals("Earth14K") || CFG.map.getFile_ActiveMap_Path2().equals("Earth")) {
            menuElements.add(new Button_Classic_ReflectedBG(null, -1, 0 + AoCGame.LEFT, CFG.PADD, CFG.GAMEWIDTH - AoCGame.LEFT, CFG.BUTTON_H, true));
        } else {
            menuElements.add(new Button_Gor(this.getSU(), null, -1, 0 + AoCGame.LEFT, CFG.PADD, CFG.GAMEWIDTH - AoCGame.LEFT, CFG.BUTTON_H, true));
        }
        try {
            Menu_ChooseScenario.loadPreview();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        int tY = CFG.BUTTON_H + CFG.PADD * 2;
        int tY2 = CFG.BUTTON_H + CFG.PADD * 2;
        int i = 0;
        try {
            while ((double)i < Math.ceil((float)Game_Scenarios.SCENARIOS_SIZE / 2.0f)) {
                try {
                    menuElements.add(new Button_Classic_Scenario(i, null, (int)(50.0f * CFG.GUI_SCALE), AoCGame.LEFT, tY, (CFG.GAMEWIDTH - AoCGame.LEFT) / 2, CFG.BUTTON_H, true, Menu_ChooseScenario_Title.iPreviewScenarioID == i){

                        @Override
                        public void buildElemHover() {
                            try {
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
                                try {
                                    if (FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(this.getCurr()) + "/Desc.txt").exists()) {
                                        String tText = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(this.getCurr()) + "/Desc.txt").readString();
                                        String[] splited = tText.split(";");
                                        String fullText = "";
                                        for (int q = 0; q < splited.length; ++q) {
                                            fullText = fullText + CFG.lang.get(splited[q]) + " ";
                                        }
                                        if (fullText != null && fullText.length() > 0) {
                                            nData.add(new ME_Hover_2Type_Space());
                                            nElements.add(new MEHover_2E(nData));
                                            nData.clear();
                                            nData.add(new ME_Hover_2Type_TextDesc(fullText, CFG.FONT_REGULAR_SMALL));
                                            nElements.add(new MEHover_2E(nData));
                                            nData.clear();
                                        }
                                    }
                                }
                                catch (Exception exception) {
                                    // empty catch block
                                }
                                this.menuElemHover = new ME_Hover_v2(nElements);
                            }
                            catch (IndexOutOfBoundsException ex) {
                                this.menuElemHover = null;
                            }
                        }

                        @Override
                        public boolean getCheckboxSt() {
                            return this.getCurr() == Menu_ChooseScenario_Title.iPreviewScenarioID;
                        }
                    });
                    tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                ++i;
            }
            tY = tY2;
            while (i < Game_Scenarios.SCENARIOS_SIZE) {
                try {
                    menuElements.add(new Button_Classic_Scenario(i, null, (int)(50.0f * CFG.GUI_SCALE), AoCGame.LEFT + (CFG.GAMEWIDTH - AoCGame.LEFT) / 2, tY, (CFG.GAMEWIDTH - AoCGame.LEFT) / 2, CFG.BUTTON_H, true, Menu_ChooseScenario_Title.iPreviewScenarioID == i){

                        @Override
                        public void buildElemHover() {
                            try {
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
                                try {
                                    if (FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(this.getCurr()) + "/Desc.txt").exists()) {
                                        String tText = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(this.getCurr()) + "/Desc.txt").readString();
                                        String[] splited = tText.split(";");
                                        String fullText = "";
                                        for (int q = 0; q < splited.length; ++q) {
                                            fullText = fullText + CFG.lang.get(splited[q]) + " ";
                                        }
                                        if (fullText != null && fullText.length() > 0) {
                                            nData.add(new ME_Hover_2Type_Space());
                                            nElements.add(new MEHover_2E(nData));
                                            nData.clear();
                                            nData.add(new ME_Hover_2Type_TextDesc(fullText, CFG.FONT_REGULAR_SMALL));
                                            nElements.add(new MEHover_2E(nData));
                                            nData.clear();
                                        }
                                    }
                                }
                                catch (Exception exception) {
                                    // empty catch block
                                }
                                this.menuElemHover = new ME_Hover_v2(nElements);
                            }
                            catch (IndexOutOfBoundsException ex) {
                                this.menuElemHover = null;
                            }
                        }

                        @Override
                        public boolean getCheckboxSt() {
                            return this.getCurr() == Menu_ChooseScenario_Title.iPreviewScenarioID;
                        }
                    });
                    tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                ++i;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.initMenu(null, 0, CFG.BUTTON_H * 3 / 4 + CFG.BUTTON_H * 3 + CFG.PADD, CFG.GAMEWIDTH, CFG.GAMEHEIGHT - CFG.BUTTON_H * 3 / 4 - CFG.BUTTON_H * 3 - CFG.PADD, menuElements);
        this.updateLang();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("RandomScenario"));
        for (int i = 0; i < Game_Scenarios.SCENARIOS_SIZE; ++i) {
            this.getMenuElem(i + 1).setTextE(CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(i)));
            this.getMenuElem(i + 1).setCurr(i);
        }
    }

    public String getSU() {
        int key = 5;
        char[] data = new char[]{'D', 'b', '`', '%', 'j', 'c', '%', 'M', 'l', 'v', 'q', 'j', 'w', '|', '%', '7', '?', '%', 'A', '`', 'c', 'l', 'k', 'l', 'q', 'l', 's', '`', '%', '@', 'a', 'l', 'q', 'l', 'j', 'k'};
        StringBuilder sb = new StringBuilder();
        for (char c : data) {
            sb.append((char)(c ^ key));
        }
        return sb.toString();
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 0: {
                Random oR = new Random();
                if (Game_Scenarios.SCENARIOS_SIZE > 1) {
                    int nScenarioID;
                    while ((nScenarioID = oR.nextInt(Game_Scenarios.SCENARIOS_SIZE)) == CFG.core.getScenarioID()) {
                    }
                    CFG.core.setScenarioID(nScenarioID);
                }
                CFG.mapModesManager.disableAllViews();
                Menu_LoadScenario.editor = false;
                Menu_LoadScenario.goToView = null;
                Menu_LoadScenario.loadActionEND = 3;
                CFG.menus.setMenuIDWithoutAnim(View.eLOAD_SCENARIO);
                break;
            }
            default: {
                try {
                    this.getMenuElem(iID).setCheckboxSt(false);
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    // empty catch block
                }
                Menu_ChooseScenario_Title.loadPreview(iID - 1);
                try {
                    this.getMenuElem(iID).setCheckboxSt(true);
                    break;
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    // empty catch block
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        Menu_ChooseScenario.disposePreview();
    }
}

