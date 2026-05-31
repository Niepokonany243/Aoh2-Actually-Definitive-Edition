/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.Top;

import age.of.civilizations2.jakowski.lukasz.BetterUI_Manager;
import age.of.civilizations2.jakowski.lukasz.Button.Button_CreateNewGameScenario;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.Game_Scenarios;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.CivInfo.Menu_Civilization_Info;
import age.of.civilizations2.jakowski.lukasz.Menus.Load.Scenario.Menu_LoadScenario;
import age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Menu_CreateNewGame;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_CreateNewGame_Top
extends Menu {
    public static final float SCALE_OF_CLICK_TEXT = 0.6f;
    private String sClickOnTheMap;
    private int iClickOnTheMapWidth;
    public static int iBGWidth;
    public static float fMovePercentage;
    private long lTime;

    public Menu_CreateNewGame_Top() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        menuElements.add(new Text(null, CFG.GAMEWIDTH / 2, CFG.PADD){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                CFG.fontMain.get(0).getData().setScale(0.9f);
                CFG.drawTextDefaultWithShadow(oSB, this.sText, this.getPosXE() + this.getWidthE() / 2 - (int)((float)this.getTextWidthU() * 0.9f) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)this.getTextHeight() * 0.9f) / 2 + iTranslateY, this.getColor(isActive));
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? new Color(0.68f, 0.68f, 0.68f, 1.0f) : (this.getIsClickable() ? (this.getIsHovered() ? CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME_HOVER : CFG.COLOR_TEXT_CNG_TOP_SCENARIO_NAME) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void setWidthE(int iWidth) {
                if (iWidth < CFG.BUTTON_W) {
                    iWidth = CFG.BUTTON_W;
                }
                super.setWidthE(iWidth);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(CFG.core.getScenarioID())), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(GameCalendar.getCurrDate(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.gameAges.getAge(CFG.core.getGameScenars().getScenarioAgeID(CFG.core.getScenarioID())).getName()));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Civilizations") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioNumOfCivs(CFG.core.getScenarioID()), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Author") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioAuthorID(CFG.core.getScenarioID()), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                try {
                    if (FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/Desc.txt").exists()) {
                        String tText = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/Desc.txt").readString();
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
        });
        menuElements.add(new Text(null, CFG.GAMEWIDTH / 2, CFG.PADD){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                CFG.fontMain.get(0).getData().setScale(0.6f);
                CFG.drawTextDefaultWithShadow(oSB, this.sText, this.getPosXE() + this.getWidthE() / 2 - (int)((float)this.getTextWidthU() * 0.6f) / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - (int)((float)this.getTextHeight() * 0.6f) / 2 + iTranslateY, this.getColor(isActive));
                CFG.fontMain.get(0).getData().setScale(1.0f);
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? new Color(0.63f, 0.63f, 0.63f, 1.0f) : (this.getIsClickable() ? (this.getIsHovered() ? new Color(0.6f, 0.6f, 0.6f, 1.0f) : CFG.COLOR_TEXT_CNG_TOP_SCENARIO_INFO) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(CFG.core.getScenarioID())), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(GameCalendar.getCurrDate(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.gameAges.getAge(CFG.core.getGameScenars().getScenarioAgeID(CFG.core.getScenarioID())).getName()));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Civilizations") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioNumOfCivs(CFG.core.getScenarioID()), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Author") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioAuthorID(CFG.core.getScenarioID()), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                try {
                    if (FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/Desc.txt").exists()) {
                        String tText = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/Desc.txt").readString();
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
        });
        menuElements.add(new Text(null, -1, 0, 0, IMGManager.getIMG(Images.topBar).getHeight(), (float)CFG.FONT_BOLD_SMALL){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColor(isActive));
            }

            @Override
            public int getPosXE() {
                if (CFG.getIsDesktop()) {
                    if (Menu_Civilization_Info.getUseMenu_UI2()) {
                        return super.getPosXE();
                    }
                    return CFG.GAMEWIDTH - this.getWidthE();
                }
                return super.getPosXE();
            }

            @Override
            public int getWidthE() {
                return this.getTextWidthU() + CFG.PADD * 4;
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_CLICK2;
            }
        });
        menuElements.add(new Text(null, -1, 0, 0, IMGManager.getIMG(Images.topBar).getHeight(), (float)CFG.FONT_BOLD_SMALL){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                IMGManager.getIMG(Images.dice).drawO(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + (this.getHeightE() - IMGManager.getIMG(Images.dice).getHeight()) / 2 + iTranslateY);
                Renderer.drawTextWithShadow(oSB, this.fontID, this.sText, this.getPosXE() + CFG.PADD * 3 + IMGManager.getIMG(Images.dice).getWidth() + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, this.getColor(isActive));
            }

            @Override
            public Color getColor(boolean isActive) {
                return isActive ? new Color(0.56f, 0.56f, 0.56f, 1.0f) : (this.getIsClickable() ? (this.getIsHovered() ? new Color(0.68f, 0.68f, 0.68f, 1.0f) : CFG.COLOR_NEUTRAL) : new Color(0.78f, 0.78f, 0.78f, 0.7f));
            }

            @Override
            public int getPosXE() {
                return 0;
            }

            @Override
            public int getWidthE() {
                return this.getTextWidthU() + CFG.PADD * 5 + IMGManager.getIMG(Images.dice).getWidth();
            }
        });
        menuElements.add(new Button_CreateNewGameScenario("<<", -1, 0, CFG.PADD * 2, IMGManager.getIMG(Images.gameTop).getHeight() - CFG.PADD){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                int nScenarioID = CFG.core.getScenarioID() + 1;
                CFG.core.getGameScenars();
                if (nScenarioID > Game_Scenarios.SCENARIOS_SIZE - 1) {
                    nScenarioID = 0;
                }
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(nScenarioID)), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioDay(nScenarioID) + " " + GameCalendar.getMonthName(CFG.core.getGameScenars().getScenarioMonth(nScenarioID)) + " " + CFG.gameAges.getYear(CFG.core.getGameScenars().getScenarioYearID(nScenarioID)), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.gameAges.getAge(CFG.core.getGameScenars().getScenarioAgeID(nScenarioID)).getName()));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Civilizations") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioNumOfCivs(nScenarioID), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Author") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioAuthorID(nScenarioID), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                try {
                    if (FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(nScenarioID) + "/Desc.txt").exists()) {
                        String tText = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(nScenarioID) + "/Desc.txt").readString();
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
        });
        menuElements.add(new Button_CreateNewGameScenario(">>", -1, 0, CFG.PADD * 2, IMGManager.getIMG(Images.gameTop).getHeight() - CFG.PADD){

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                int nScenarioID = CFG.core.getScenarioID() - 1;
                if (nScenarioID < 0) {
                    CFG.core.getGameScenars();
                    nScenarioID = Game_Scenarios.SCENARIOS_SIZE - 1;
                }
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(nScenarioID)), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioDay(nScenarioID) + " " + GameCalendar.getMonthName(CFG.core.getGameScenars().getScenarioMonth(nScenarioID)) + " " + CFG.gameAges.getYear(CFG.core.getGameScenars().getScenarioYearID(nScenarioID)), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.gameAges.getAge(CFG.core.getGameScenars().getScenarioAgeID(nScenarioID)).getName()));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Civilizations") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioNumOfCivs(nScenarioID), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Author") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioAuthorID(nScenarioID), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                try {
                    if (FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(nScenarioID) + "/Desc.txt").exists()) {
                        String tText = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + CFG.core.getGameScenars().lScenarios_TagsList.get(nScenarioID) + "/Desc.txt").readString();
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
        });
        int maxH = 0;
        for (int i = menuElements.size() - 1; i >= 0; --i) {
            if (((MenuElemUI)menuElements.get(i)).getPosY() + ((MenuElemUI)menuElements.get(i)).getHeightE() <= maxH) continue;
            maxH = ((MenuElemUI)menuElements.get(i)).getPosY() + ((MenuElemUI)menuElements.get(i)).getHeightE();
        }
        this.initMenu(null, 0, 0, CFG.GAMEWIDTH, Math.max(CFG.BUTTON_H + CFG.PADD * 2, maxH + 1), menuElements, false, false);
        this.updateLang();
        if (Menu_Civilization_Info.getUseMenu_UI2()) {
            this.getMenuElem(2).setPosX(this.getMenuElem(3).getPosXE() + this.getMenuElem(3).getWidthE() + CFG.PADD * 2);
        }
    }

    @Override
    public void updateLang() {
        this.sClickOnTheMap = CFG.lang.get("ClickOnTheMap");
        CFG.fontMain.get(0).getData().setScale(0.6f);
        CFG.glyphLay.setText(CFG.fontMain.get(0), this.sClickOnTheMap);
        this.iClickOnTheMapWidth = (int)CFG.glyphLay.width;
        CFG.fontMain.get(0).getData().setScale(1.0f);
        int tNumOfCivs = 0;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
            ++tNumOfCivs;
        }
        this.getMenuElem(0).setTextE(CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(CFG.core.getScenarioID())));
        this.getMenuElem(1).setTextE("" + tNumOfCivs + " " + CFG.lang.get("Civilizations") + " | " + CFG.lang.get("Year") + ": " + CFG.gameAges.getYear(CFG.core.getGameScenars().getScenarioYearID(CFG.core.getScenarioID())));
        this.getMenuElem(0).setPosY(CFG.PADD + IMGManager.getIMG(Images.gameTop).getHeight() / 2 - ((int)((float)this.getMenuElem(0).getTextHeight() * 0.9f + (float)this.getMenuElem(1).getTextHeight() * 0.6f) + CFG.PADD * 3) / 2);
        this.getMenuElem(0).setHeightE((int)((float)this.getMenuElem(0).getTextHeight() * 0.9f) + CFG.PADD * 2);
        this.getMenuElem(1).setPosY(CFG.PADD + IMGManager.getIMG(Images.gameTop).getHeight() / 2 - ((int)((float)this.getMenuElem(0).getTextHeight() * 0.9f + (float)this.getMenuElem(1).getTextHeight() * 0.6f) + CFG.PADD * 3) / 2 + this.getMenuElem(0).getHeightE());
        this.getMenuElem(1).setHeightE((int)((float)this.getMenuElem(1).getTextHeight() * 0.6f + (float)CFG.PADD));
        iBGWidth = this.getMenuElem(0).getTextWidthU() > this.iClickOnTheMapWidth - CFG.PADD * 4 ? this.getMenuElem(0).getTextWidthU() + CFG.PADD * 6 : this.iClickOnTheMapWidth + CFG.PADD * 4;
        iBGWidth = (int)((float)this.getMenuElem(1).getTextWidthU() * 0.6f > (float)iBGWidth ? (float)this.getMenuElem(1).getTextWidthU() * 0.6f + (float)(CFG.PADD * 6) : (float)iBGWidth);
        this.getMenuElem(0).setWidthE(iBGWidth);
        this.getMenuElem(1).setWidthE(iBGWidth);
        this.getMenuElem(0).setPosX(CFG.GAMEWIDTH / 2 - this.getMenuElem(0).getWidthE() / 2);
        this.getMenuElem(1).setPosX(CFG.GAMEWIDTH / 2 - this.getMenuElem(1).getWidthE() / 2);
        this.lTime = System.currentTimeMillis();
        fMovePercentage = 5.0f;
        this.getMenuElem(2).setTextE(CFG.lang.get("MapModes"));
        this.getMenuElem(3).setTextE(CFG.lang.get("RandomCivilization"));
        this.getMenuElem(4).setPosX(this.getMenuElem(0).getPosXE() - this.getMenuElem(4).getWidthE() - CFG.PADD * 2 - CFG.PADD / 2);
        this.getMenuElem(5).setPosX(this.getMenuElem(0).getPosXE() + this.getMenuElem(0).getWidthE() + CFG.PADD * 2 + CFG.PADD / 2);
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if ((fMovePercentage += (float)(System.currentTimeMillis() - this.lTime) / 300.0f * 95.0f) > 100.0f) {
            fMovePercentage = 100.0f;
        } else {
            CFG.setRenderO(true);
        }
        this.lTime = System.currentTimeMillis();
        iTranslateY -= (int)((float)this.getHeightM() * (100.0f - fMovePercentage) / 100.0f);
        
        if (CFG.settingsGD.BETTER_UI) {
            BetterUI_Manager.drawBetterMenuBG(oSB, this.getPosX() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthM(), this.getHeightM());
            super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
            
            CFG.fontMain.get(0).getData().setScale(0.6f);
            CFG.drawTextDefault(oSB, this.sClickOnTheMap, CFG.GAMEWIDTH / 2 - this.iClickOnTheMapWidth / 2 + iTranslateX, this.getHeightM() - CFG.PADD * 3 + iTranslateY, new Color(1.0f, 1.0f, 1.0f, 0.6f));
            CFG.fontMain.get(0).getData().setScale(1.0f);
            return;
        }

        if (Menu_Civilization_Info.getUseMenu_UI2()) {
            IMGManager.getIMG(Images.topBar).draw2(oSB, this.getMenuElem(2).getPosXE() - CFG.topBox.topBarPaddingRight - CFG.PADD * 3 + iTranslateX, this.getMenuElem(2).getPosY() + iTranslateY, this.getMenuElem(2).getWidthE() + CFG.topBox.topBarPaddingRight * 2 + CFG.PADD * 3, IMGManager.getIMG(Images.topBar).getHeight(), true, false);
            IMGManager.getIMG(Images.topBar).draw2(oSB, this.getMenuElem(3).getPosXE() + iTranslateX, this.getMenuElem(3).getPosY() + iTranslateY, this.getMenuElem(3).getWidthE() + CFG.topBox.topBarPaddingRight, IMGManager.getIMG(Images.topBar).getHeight(), true, false);
        } else {
            IMGManager.getIMG(Images.topBar).draw2(oSB, this.getMenuElem(2).getPosXE() - CFG.topBox.topBarPaddingRight + iTranslateX, this.getMenuElem(2).getPosY() + iTranslateY, this.getMenuElem(2).getWidthE() + CFG.topBox.topBarPaddingRight, IMGManager.getIMG(Images.topBar).getHeight(), false, false);
            IMGManager.getIMG(Images.topBar).draw2(oSB, this.getMenuElem(3).getPosXE() + iTranslateX, this.getMenuElem(3).getPosY() + iTranslateY, this.getMenuElem(3).getWidthE() + CFG.topBox.topBarPaddingRight, IMGManager.getIMG(Images.topBar).getHeight(), true, false);
        }
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.6f));
        IMGManager.getIMG(Images.gradient).drawO(oSB, iTranslateX, -IMGManager.getIMG(Images.gradient).getHeight(), CFG.GAMEWIDTH, CFG.PADD * 3);
        oSB.setColor(Color.WHITE);
        IMGManager.getIMG(Images.gameTop).drawO(oSB, CFG.GAMEWIDTH / 2 - iBGWidth / 2 - CFG.PADD * 2 + iTranslateX, CFG.PADD + iTranslateY, iBGWidth + CFG.PADD * 4 - IMGManager.getIMG(Images.gameTop).getWidth());
        IMGManager.getIMG(Images.gameTop).drawO(oSB, CFG.GAMEWIDTH / 2 + iBGWidth / 2 + CFG.PADD * 2 - IMGManager.getIMG(Images.gameTop).getWidth() + iTranslateX, CFG.PADD + iTranslateY, true);
        oSB.setColor(new Color(CFG.COLOR_GRADIENT_BLUE.r, CFG.COLOR_GRADIENT_BLUE.g, CFG.COLOR_GRADIENT_BLUE.b, this.getMenuElem(0).getIsHovered() || this.getMenuElem(1).getIsHovered() ? 0.325f : 0.225f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, CFG.GAMEWIDTH / 2 - iBGWidth / 2 - CFG.PADD * 2 + iTranslateX, CFG.PADD + 2 - IMGManager.getIMG(Images.line32Off1).getHeight() + iTranslateY, iBGWidth + CFG.PADD * 4, IMGManager.getIMG(Images.gameTop).getHeight() - 4);
        oSB.setColor(Color.WHITE);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.fontMain.get(0).getData().setScale(0.6f);
        CFG.drawTextDefault(oSB, this.sClickOnTheMap, CFG.GAMEWIDTH / 2 - this.iClickOnTheMapWidth / 2 + iTranslateX, CFG.PADD * 2 + IMGManager.getIMG(Images.gameTop).getHeight() + iTranslateY, new Color(1.0f, 1.0f, 1.0f, 0.4f));
        CFG.fontMain.get(0).getData().setScale(1.0f);
    }

    public static final void clickChooseScenario() {
        Menu_CreateNewGame.CHALLENGE_MODE_NG = -1;
        CFG.core.disableDrawCivlizationsRegions_Players();
        CFG.menus.setMenuID(View.eCHOOSE_SCENARIO);
        CFG.backToMenu = View.eCREATE_NEW_GAME;
        CFG.goToMenu = View.eCREATE_NEW_GAME;
        if (CFG.menus.getColorPicker().getVisible()) {
            CFG.menus.getColorPicker().setVisible(false, null);
        }
        CFG.menus.setVisible_CreateNewGame_AddCiv(false);
        CFG.menus.setVisible_CreateNewGame_AddCiv_Gov(false);
    }

    @Override
    public void actionEL(int iID) {
        CFG.brushMode = false;
        switch (iID) {
            case 0: 
            case 1: {
                Menu_CreateNewGame_Top.clickChooseScenario();
                break;
            }
            case 2: {
                CFG.menus.getCreateNewGame_MapModes().setVisibleM(!CFG.menus.getCreateNewGame_MapModes().getVisibleM());
                if (CFG.menus.getCreateNewGame_MapModes().getPosX() >= 0) break;
                CFG.menus.getCreateNewGame_MapModes().setPosX_Force(CFG.GAMEWIDTH - CFG.CIV_INFO_MENU_WIDTH - CFG.PADD * 2 - CFG.menus.getCreateNewGame_MapModes().getWidthM());
                CFG.menus.getCreateNewGame_MapModes().setPosY(CFG.menus.getCreateNewGame_MapModes().getTitleM().getHeightT() + IMGManager.getIMG(Images.gameTop).getHeight() + CFG.PADD * 4 + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.6f));
                break;
            }
            case 3: {
                Menu_CreateNewGame.CHALLENGE_MODE_NG = -1;
                CFG.core.disableDrawCivilizationRegions_Active();
                ArrayList<Integer> tempCivs = new ArrayList<Integer>();
                for (int i = 0; i < CFG.core.getCivsSize(); ++i) {
                    if (CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
                    tempCivs.add(i);
                }
                int tempR = CFG.oR.nextInt(tempCivs.size());
                if (CFG.core.getCiv((Integer)tempCivs.get(tempR)).getCapitalProvID() >= 0) {
                    CFG.core.setActiveProvID(CFG.core.getCiv((Integer)tempCivs.get(tempR)).getCapitalProvID());
                } else {
                    CFG.core.setActiveProvID(CFG.core.getCiv((Integer)tempCivs.get(tempR)).getProvID(0));
                }
                CFG.map.getMpC().centerToProvID(CFG.core.getActiveProvID());
                CFG.setActiveCivInfoId(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
                CFG.updateActiveCivInfo_CreateNewGame();
                if (CFG.core.getPlayersSize() == 1 && CFG.getActiveCivInfoId() > 0) {
                    CFG.core.getPlayer(0).setCivId(CFG.getActiveCivInfoId());
                    CFG.menus.rebuildCivs_Info_Players();
                }
                CFG.core.enableDrawCivlizationsRegions_Players();
                CFG.core.enableDrawCivilizationRegions_ActiveProvince();
                tempCivs.clear();
                tempCivs = null;
                break;
            }
            case 4: {
                Menu_CreateNewGame.CHALLENGE_MODE_NG = -1;
                int nScenarioID = CFG.core.getScenarioID() + 1;
                CFG.core.getGameScenars();
                if (nScenarioID > Game_Scenarios.SCENARIOS_SIZE - 1) {
                    nScenarioID = 0;
                }
                CFG.core.setActiveProvID(-1);
                CFG.mapModesManager.disableAllViews();
                CFG.core.setScenarioID(nScenarioID);
                Menu_LoadScenario.editor = false;
                Menu_LoadScenario.goToView = View.eCREATE_NEW_GAME;
                Menu_LoadScenario.loadActionEND = 6;
                CFG.menus.setMenuIDWithoutAnim(View.eLOAD_SCENARIO);
                CFG.menus.setVisible_CreateNewGame_AddCiv(false);
                CFG.menus.setVisible_CreateNewGame_AddCiv_Gov(false);
                break;
            }
            case 5: {
                Menu_CreateNewGame.CHALLENGE_MODE_NG = -1;
                int nScenarioID = CFG.core.getScenarioID() - 1;
                if (nScenarioID < 0) {
                    CFG.core.getGameScenars();
                    nScenarioID = Game_Scenarios.SCENARIOS_SIZE - 1;
                }
                CFG.core.setActiveProvID(-1);
                CFG.mapModesManager.disableAllViews();
                CFG.core.setScenarioID(nScenarioID);
                Menu_LoadScenario.editor = false;
                Menu_LoadScenario.goToView = View.eCREATE_NEW_GAME;
                Menu_LoadScenario.loadActionEND = 6;
                CFG.menus.setMenuIDWithoutAnim(View.eLOAD_SCENARIO);
                break;
            }
        }
    }

    @Override
    public void setVisibleM(boolean visible) {
        this.lTime = System.currentTimeMillis();
        fMovePercentage = 5.0f;
        super.setVisibleM(visible);
    }
}

