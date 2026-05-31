
package age.of.civilizations2.jakowski.lukasz.Menus.Z_Rest;

import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Classic;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_Description;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LRMain_DC;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LRMain_TextScale;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_LRMain_TextScale_Important;
import age.of.civilizations2.jakowski.lukasz.Button.Classic.Button_Classic_ReflectedBG;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
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
import age.of.civilizations2.jakowski.lukasz.Menus.Alliance.Menu_FB;
import age.of.civilizations2.jakowski.lukasz.Menus.Main.Menu_Main;
import age.of.civilizations2.jakowski.lukasz.Menus.RandomGame.Menu_RandomGame_Settings;
import age.of.civilizations2.jakowski.lukasz.Menus.Settings.Menu_Settings_Options;
import age.of.civilizations2.jakowski.lukasz.RandomGame_Manager;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;
import age.of.civilizations2.jakowski.lukasz.TextB.Text;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import age.of.civilizations2.jakowski.lukasz.Z_Other.PNM;
import age.of.civilizations2.jakowski.lukasz.Z_Other.Undo.Undo_AssignProvinceCiv;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.Random;

public class Menu_Games
extends Menu {
    public Menu_Games() {
        ArrayList<MenuElemUI> menuElements = new ArrayList<MenuElemUI>();
        int tempMenuWidth = Menu_Main.getMenuWidth_Default();
        int tY = 0;
        menuElements.add(new Text(null, -1, 0, tY, tempMenuWidth, CFG.BUTTON_H * 3 / 4, CFG.FONT_BOLD_SMALL){

            @Override
            public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
                CFG.drawRect_InfoBox_Right_Title(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
                Renderer.drawTextWithShadow(oSB, this.fontID, this.getTextE(), this.getPosXE() + this.getWidthE() / 2 - this.getTextWidthU() / 2 + iTranslateX, this.getPosY() + this.getHeightE() / 2 - this.getTextHeight() / 2 + iTranslateY, CFG.COLOR_TEXT_CIV_INFO_TITLE);
            }
        });
        menuElements.add(new Button_Classic_Description(CFG.map.getMapAuthor(CFG.map.getActiveMapIDN()), CFG.lang.get("MapType") + ": " + CFG.map.getMapName(CFG.map.getActiveMapIDN()), (int)(50.0f * CFG.GUI_SCALE), 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempMenuWidth, CFG.BUTTON_H, true){

            @Override
            public void setButtonAlpha(SpriteBatch oSB, boolean isActive) {
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.55f);
                if (!this.getIsClickable()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.4f));
                } else if (!isActive && this.getIsHovered() && this.getIsClickable()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.485f));
                }
            }

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
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN())), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("LandProvinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.countLandProvinces()), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SeaProvinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.core.countSeaProvinces()), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic_LRMain_TextScale(null, -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempMenuWidth, CFG.BUTTON_H, true));
        menuElements.add(new Button_Classic_LRMain_TextScale(null, -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempMenuWidth, CFG.BUTTON_H, true){

            @Override
            public boolean getIsClickable() {
                return SaveGameManager.gameCanBeContinued;
            }
        });
        menuElements.add(new Button_Classic_LRMain_TextScale_Important(null, -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempMenuWidth, CFG.BUTTON_H, true){

            @Override
            public Color getColorE(boolean isActive) {
                if (!this.getIsHovered() && !isActive) {
                    return CFG.COLOR_HOVER_TITLE;
                }
                return super.getColorE(isActive);
            }

            @Override
            public void actionElemPPM() {
                Menu_FB.goBack = View.eGAMES;
                CFG.menus.setMenuID(View.eFB);
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(CFG.core.getScenarioID())), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.time, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(GameCalendar.getCurrDate(), CFG.COLOR_HOVER_TITLE));
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
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_Classic("<<", -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, CFG.BUTTON_W, CFG.BUTTON_H, true){

            @Override
            public void setButtonAlpha(SpriteBatch oSB, boolean isActive) {
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.55f);
                if (!this.getIsClickable()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.4f));
                } else if (!isActive && this.getIsHovered() && this.getIsClickable()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.485f));
                }
            }
        });
        menuElements.add(new Button_Classic_Classic(null, -1, CFG.BUTTON_W, tY, tempMenuWidth - CFG.BUTTON_W * 2, CFG.BUTTON_H, true){

            @Override
            public void setButtonAlpha(SpriteBatch oSB, boolean isActive) {
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.55f);
                if (!this.getIsClickable()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.4f));
                } else if (!isActive && this.getIsHovered() && this.getIsClickable()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.485f));
                }
            }
        });
        menuElements.add(new Button_Classic_ReflectedBG(">>", -1, tempMenuWidth - CFG.BUTTON_W, tY, CFG.BUTTON_W, CFG.BUTTON_H, true){

            @Override
            public void setButtonAlpha(SpriteBatch oSB, boolean isActive) {
                oSB.setColor(1.0f, 1.0f, 1.0f, 0.55f);
                if (!this.getIsClickable()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.4f));
                } else if (!isActive && this.getIsHovered() && this.getIsClickable()) {
                    oSB.setColor(new Color(1.0f, 1.0f, 1.0f, 0.485f));
                }
            }
        });
        menuElements.add(new Button_Classic_LRMain_DC(CFG.lang.get("RandomGame"), null, -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempMenuWidth, CFG.BUTTON_H, true){

            @Override
            public void buildElemHover() {
                try {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("RandomGame"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.dice, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
                catch (IndexOutOfBoundsException ex) {
                    this.menuElemHover = null;
                }
            }

            @Override
            public int getSFXElem() {
                return SFXManager.SFX_RANDOM;
            }
        });
        menuElements.add(new Button_Classic_LRMain_TextScale_Important(null, -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempMenuWidth, CFG.BUTTON_H, true){});
        menuElements.add(new Button_Classic_LRMain_DC("Age of History 2: Definitive Edition", null, -1, 0, tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD, tempMenuWidth, CFG.BUTTON_H, true));
        tY += ((MenuElemUI)menuElements.get(menuElements.size() - 1)).getHeightE() + CFG.PADD;
        this.initMenu(null, Menu_Main.getMenuPosX_Default(), 0, tempMenuWidth, CFG.GAMEHEIGHT - CFG.BUTTON_H - CFG.PADD, menuElements);
        this.updateLang();
        CFG.lCreateScenario_UndoAssignProvsCivID = new ArrayList<Undo_AssignProvinceCiv>();
        CFG.lCreateScenario_UndoWastelandProvinces = new ArrayList<Integer>();
    }

    @Override
    public void updateLang() {
        this.getMenuElem(0).setTextE(CFG.lang.get("Games"));
        this.getMenuElem(2).setTextE(CFG.lang.get("LoadGame"));
        this.getMenuElem(3).setTextE(CFG.lang.get("ContinueGame"));
        this.getMenuElem(4).setTextE(CFG.lang.get("NewGame"));
        this.getMenuElem(8).setTextE(CFG.lang.get("AgeofCivilizations"));
        this.getMenuElem(6).setTextE(CFG.lang.get(Menu_Settings_Options.getSettingsText_Names()));
        this.getMenuElem(9).setTextE(CFG.lang.get("Tutorial"));
        this.getMenuElem(10).setTextE(CFG.lang.get("Achievements"));
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        super.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        super.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.map.getIcon(CFG.map.getActiveMapIDN()).drawO(oSB, this.getPosX() + this.getMenuElem(1).getTextPosElem() / 2 - CFG.map.getIcon(CFG.map.getActiveMapIDN()).getWidth() / 2 + iTranslateX, this.getMenuElem(1).getPosY() + this.getMenuElem(1).getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + this.getMenuPosY() - CFG.map.getIcon(CFG.map.getActiveMapIDN()).getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
        super.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        CFG.setRenderO(true);
    }

    public static final void clickNewGame() {
        if (CFG.SPECTATOR_MODE) {
            CFG.SPECTATOR_MODE = false;
            CFG.FOG_OF_WAR = 2;
        }
        CFG.AGE_OF_CHAOS_MODE = false;
        CFG.USE_NEW_DECLARE_WAR_SYSTEM = true;
        CFG.USE_OLD_DECLARE_WAR_CHANGE_100 = 0;
        CFG.TOTAL_WARMODE = false;
        CFG.CAPITULATION = GameValues.gvCapitulation.CAPITULATION_PROVINCES_LEFT_PERC_DEFAULT;
        CFG.GET_SPY_MESSAGE_ABOUT_AI_PREPARING_FOR_WAR_CHANCE_1000 = GameValues.gvWar.GET_SPY_MESSAGE_ABOUT_AI_PREPARING_FOR_WAR_CHANCE_1000;
        CFG.COLONIZATION_AUTO_EXPAND_CHANCE = GameValues.gvColonize.COLONIZATION_AUTO_EXPAND_CHANCE_100_DEFAULT;
        CFG.NUKES_MIN_YEAR_ENABLED = true;
        CFG.VASSALS_CAN_DECLARE_INDEPENDENCE = true;
        CFG.ASSIMILATION_COST_MODIFIER = 1.0f;
        CFG.MOVEMENT_POINTS_EXTRA = 0;
        CFG.ASSIMILATION_SPEED_MODIFIER = 1.0f;
        CFG.MOVEMENT_POINTS_MAX_MODIFIER = GameValues.gvMovementPoints.MOVEMENT_POINTS_MAX_MODIFIER;
        CFG.DIPLOMACY_POINTS_EXTRA = 0;
        CFG.POPULATION_GROWTH_RATE = 1.0f;
        CFG.ECONOMY_GROWTH_RATE = 1.0f;
        CFG.TECHNOLOGY_LEVEL_BONUS_ARMY_DEFENSE = GameValues.gvBattle.TECHNOLOGY_LEVEL_BONUS_ARMY_DEFENSE_DEFAULT;
        CFG.TECHNOLOGY_LEVEL_BONUS_ARMY_ATTACK = GameValues.gvBattle.TECHNOLOGY_LEVEL_BONUS_ARMY_ATTACK_DEFAULT;
        CFG.AI_UNIONS_ENABLED = false;
        CFG.AI_CONQUER_VASSALS = GameValues.gvAiDeclareWar.AI_CONQUER_VASSALS;
        CFG.AI_VASSALS_CAN_DECLARE_WARS = false;
        CFG.AI_CONQUER_OWN_VASSALS_IF_OVER = GameValues.gvAiDeclareWar.AI_CONQUER_OWN_VASSALS_IF_OVER;
        CFG.SANDBOX_MODE_AI = false;
        CFG.BUILD_NUKES_EXTRA_COST = 0;
        CFG.NUKES_REQUIRED_TECH_LVL = GameValues.gvAtomic.NUKES_REQUIRED_TECH_LVL;
        CFG.PLUNDER_MODIFIER = 1.0f;
        CFG.AI_PLUNDER_ENABLED = true;
        CFG.PLUNDER_CHANCE = 0.0f;
        CFG.GENOCIDE_CHANCE = 0.0f;
        CFG.AI_GENOCIDE_ENABLED = true;
        CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS = GameValues.gvWar.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS_DEFAULT;
        CFG.PEACE_TREATY_VICTORY_POINTS_MODIFIER = 1.0f;
        CFG.MOVE_AND_RECRUIT_ARMY_AT_WAR_BY_AI = false;
        CFG.clCPNC();
        CFG.ENABLE_NUKES = true;
        CFG.MIN_ARMY_REQUIRED_TO_ATTACK = GameValues.gvMove.MIN_ARMY_REQUIRED_TO_ATTACK_DEFAULT;
        CFG.MAX_PROVINCES_FOR_ALLIANCE_PROPOSAL = 20;
        CFG.PROPOSE_ALLIANCE_CHANCE_100 = 62;
        CFG.REBELS_POWER = 1.5f;
        CFG.SANDBOX_MODE = false;
        CFG.RANDOM_PLACEMENT = false;
        CFG.RANDOM_FILL = false;
        GameCalendar.GAME_SPEED = 1.0f;
        GameCalendar.AI_AGGRESSIVENESS = GameCalendar.AI_AGGRESSIVENESS_DEFAULT;
        CFG.menus.setMenuID(View.eCREATE_NEW_GAME);
        CFG.menus.setVisible_CreateNewGame_Options(false);
        CFG.menus.setVisible_CreateNewGame_CivInfo(true);
        CFG.menus.setVisible_CreateNewGame_AddCiv(false);
        CFG.menus.setVisible_CreateNewGame_AddCiv_Gov(false);
    }

    public static final void clickRandomGame() {
        CFG.randomGameManager = new RandomGame_Manager();
        GameCalendar.GAME_SPEED = 1.0f;
        CFG.RANDOM_PLACEMENT = false;
        CFG.RANDOM_FILL = false;
        CFG.TOTAL_WARMODE = false;
        CFG.CAPITULATION = GameValues.gvCapitulation.CAPITULATION_PROVINCES_LEFT_PERC_DEFAULT;
        CFG.GET_SPY_MESSAGE_ABOUT_AI_PREPARING_FOR_WAR_CHANCE_1000 = GameValues.gvWar.GET_SPY_MESSAGE_ABOUT_AI_PREPARING_FOR_WAR_CHANCE_1000;
        CFG.COLONIZATION_AUTO_EXPAND_CHANCE = GameValues.gvColonize.COLONIZATION_AUTO_EXPAND_CHANCE_100_DEFAULT;
        CFG.NUKES_MIN_YEAR_ENABLED = true;
        CFG.VASSALS_CAN_DECLARE_INDEPENDENCE = true;
        CFG.ASSIMILATION_COST_MODIFIER = 1.0f;
        CFG.MOVEMENT_POINTS_EXTRA = 0;
        CFG.ASSIMILATION_SPEED_MODIFIER = 1.0f;
        CFG.MOVEMENT_POINTS_MAX_MODIFIER = GameValues.gvMovementPoints.MOVEMENT_POINTS_MAX_MODIFIER;
        CFG.DIPLOMACY_POINTS_EXTRA = 0;
        CFG.POPULATION_GROWTH_RATE = 1.0f;
        CFG.ECONOMY_GROWTH_RATE = 1.0f;
        CFG.TECHNOLOGY_LEVEL_BONUS_ARMY_DEFENSE = GameValues.gvBattle.TECHNOLOGY_LEVEL_BONUS_ARMY_DEFENSE_DEFAULT;
        CFG.TECHNOLOGY_LEVEL_BONUS_ARMY_ATTACK = GameValues.gvBattle.TECHNOLOGY_LEVEL_BONUS_ARMY_ATTACK_DEFAULT;
        CFG.AI_UNIONS_ENABLED = false;
        CFG.AI_CONQUER_VASSALS = GameValues.gvAiDeclareWar.AI_CONQUER_VASSALS;
        CFG.AI_VASSALS_CAN_DECLARE_WARS = false;
        CFG.AI_CONQUER_OWN_VASSALS_IF_OVER = GameValues.gvAiDeclareWar.AI_CONQUER_OWN_VASSALS_IF_OVER;
        CFG.SANDBOX_MODE_AI = false;
        CFG.BUILD_NUKES_EXTRA_COST = 0;
        CFG.NUKES_REQUIRED_TECH_LVL = GameValues.gvAtomic.NUKES_REQUIRED_TECH_LVL;
        CFG.PLUNDER_MODIFIER = 1.0f;
        CFG.AI_PLUNDER_ENABLED = true;
        CFG.PLUNDER_CHANCE = 0.0f;
        CFG.GENOCIDE_CHANCE = 0.0f;
        CFG.AI_GENOCIDE_ENABLED = true;
        CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS = GameValues.gvWar.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS_DEFAULT;
        CFG.PEACE_TREATY_VICTORY_POINTS_MODIFIER = 1.0f;
        CFG.MOVE_AND_RECRUIT_ARMY_AT_WAR_BY_AI = false;
        CFG.clCPNC();
        GameCalendar.currYear = -4000 - CFG.oR.nextInt(1000);
        GameCalendar.currDay = 15;
        GameCalendar.currMonth = 5;
        GameCalendar.CURRENT_AGEID = CFG.gameAges.getAgeOfYear(GameCalendar.currYear);
        GameCalendar.ENABLE_COLONIZATION = false;
        GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES = false;
        CFG.FOG_OF_WAR = 2;
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getSeaProv()) continue;
            CFG.core.getProv(i).setWastelandLvl(-1);
        }
        Random oR = new Random();
        try {
            CFG.randomGameManager.setCivilizationsSize(Math.min((int)Math.max((float)Menu_RandomGame_Settings.getCivMax() * 0.1f, 2.0f) + oR.nextInt((int)((float)Menu_RandomGame_Settings.getCivMax() * 0.1f)), Menu_RandomGame_Settings.getCivMax()));
        }
        catch (Exception ex) {
            CFG.randomGameManager.setCivilizationsSize(100);
        }
        CFG.core.getGameScenars().setScenarioStartingArmyInCapitals(75);
        CFG.randomGameManager.setNeutralArmy(30);
        CFG.core.getGameScenars().setScenarioStartingPopulation(21000);
        CFG.core.getGameScenars().setScenarioStartingEconomy(9750);
        CFG.core.getGameScenars().setScenarioStartingMoney(50);
        CFG.menus.setMenuID(View.eCREATE_RANDOM_GAME);
        CFG.menus.rebuildCreateRandomGame_Settings();
    }

    @Override
    public final void actionEL(int iID) {
        switch (iID) {
            case 1: {
                CFG.backToMenu = View.eGAMES;
                CFG.menus.setMenuID(View.eSELECT_MAP_TYPE);
                break;
            }
            case 2: {
                CFG.menus.setMenuID(View.eLOADGAME);
                CFG.menus.setOrderOfMenu_LoadGame();
                break;
            }
            case 3: {
                CFG.menus.setMenuID(View.eINGAME);
                CFG.menus.setVisible_InGame_Options(false);
                try {
                    if (CFG.SPECTATOR_MODE || CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID() < 0) break;
                    CFG.map.getMpC().centerToProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                    CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {}
                break;
            }
            case 4: {
                if (SaveGameManager.gameCanBeContinued) {
                    CFG.setDialogType(DialogType.ALL_NOT_SAVED_PROGRESS_WILL_BE_LOST);
                    break;
                }
                Menu_Games.clickNewGame();
                break;
            }
            case 8: {
                if (!CFG.getIsDesktop()) break;
                if (SaveGameManager.gameCanBeContinued) {
                    CFG.setDialogType(DialogType.ALL_NOT_SAVED_PROGRESS_WILL_BE_LOST2);
                    break;
                }
                CFG.setDialogType(DialogType.AGE_OF_CIVILIZATIONS_MENU);
                break;
            }
            case 5: {
                --CFG.settingsGD.SPROVN;
                CFG.settingsGD.SPROVN = Math.max(0, CFG.settingsGD.SPROVN);
                this.getMenuElem(6).setTextE(Menu_Settings_Options.getSettingsText_Names());
                PNM.uDPN();
                break;
            }
            case 7: {
                ++CFG.settingsGD.SPROVN;
                CFG.settingsGD.SPROVN = Math.min(3, CFG.settingsGD.SPROVN);
                this.getMenuElem(6).setTextE(Menu_Settings_Options.getSettingsText_Names());
                PNM.uDPN();
                break;
            }
            case 9: {
                CFG.setDialogType(DialogType.START_TUTORIAL);
                break;
            }
            case 10: {
                CFG.menus.setMenuID(View.eACHIEVEMENTS);
            }
        }
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_Games();
    }
}

