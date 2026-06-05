package age.of.civilizations2.jakowski.lukasz.Menus.Civilization;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_DiplomacyAction;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_DiplomacyAction_TextRight;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_Diplomacy_Action_Government;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_Diplomacy_Action_Religion;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_Diplomacy_Action_Tech;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Button_Diplomacy_Civilize;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Button_Diplomacy_FormCivilization;
import age.of.civilizations2.jakowski.lukasz.Button.GameN.ButtonN_ActionAll;
import age.of.civilizations2.jakowski.lukasz.Button.Game.Button_Game;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.ButtonFlagBig;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.City;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.CreateVassal_Data;
import age.of.civilizations2.jakowski.lukasz.Diplomacy.Loans;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.IdeologiesManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Challenge.Challenge;
import age.of.civilizations2.jakowski.lukasz.MapA.Challenge.ChallengesManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Plagues.Nuke.NukeManager;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology_Vassal_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big2;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Religion_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_DiplomacyORActions;
import age.of.civilizations2.jakowski.lukasz.Menus.Continents.Menu_InGame_LeaderC;
import age.of.civilizations2.jakowski.lukasz.Menus.Formable.AddCiv.Menu_InGame_AddCiv;
import age.of.civilizations2.jakowski.lukasz.Menus.Menu_InitGame;
import age.of.civilizations2.jakowski.lukasz.Menus.Province.Menu_InGame_RelocatePopulation;
import age.of.civilizations2.jakowski.lukasz.Menus.Send.Army.Menu_InGame_SendArmy;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_CivilizationView;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.Touch;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_Civ_Decisions extends Menu {
    public static boolean toTheBottom = false;
    public static int LAST_ELEMENT_POSY = 0;
    public static int extraPosX = 0;

    public static int getButtonH() {
        return Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.BUTTON_H * 7 / 10);
    }

    public Menu_InGame_Civ_Decisions() {
        ArrayList<MenuElemUI> menuElems = new ArrayList<MenuElemUI>();
        int menuW = Menu_InGame_Civ.getMenuCivInfoWidth();
        int tempElemH = Menu_InGame_Civ_Decisions.getButtonH();
        int tY = 0;

        menuElems.add(new Button_DiplomacyAction(Images.frontline, CFG.lang.get("Strategy"), 0, 0, tY, menuW - 2, tempElemH, true){
            @Override
            public void actionElem(int iID) { CFG.menus.rebuildInGame_Strategy(); }
        });
        
        if (CFG.settingsGD.MISSILES) {
            menuElems.add(new Button_DiplomacyAction(Images.nuke, "Missile Program", 0, 0, tY += tempElemH, menuW - 2, tempElemH, true){
                @Override
                public void actionElem(int iID) { CFG.menus.rebuildInGame_Missiles(); }
                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big("Missile Program", CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.nuke, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc("Produce and upgrade tactical missiles."));
                    nElements.add(new MEHover_2E(nData));
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
        }

        if (CFG.SPECTATOR_MODE) {
            menuElems.add(new Button_DiplomacyAction(Images.diploAZ, CFG.lang.get("LockCivilization") + ": " + (CFG.SPECTATOR_MODE_LOCK_CIV ? CFG.lang.get("On") : CFG.lang.get("Off")), 0, 0, tY += tempElemH, menuW - 2, tempElemH, true){
                @Override
                public void actionElem(int iID) {
                    CFG.SPECTATOR_MODE_LOCK_CIV = !CFG.SPECTATOR_MODE_LOCK_CIV;
                    this.setTextE(CFG.lang.get("LockCivilization") + ": " + (CFG.SPECTATOR_MODE_LOCK_CIV ? CFG.lang.get("On") : CFG.lang.get("Off")));
                }
            });
            menuElems.add(new Button_DiplomacyAction(Images.diploWar, CFG.lang.get("DeclareWar"), 0, 0, tY += tempElemH, menuW - 2, tempElemH, true){
                @Override
                public void actionElem(int iID) {
                    CFG.SPECTATOR_MODE_DECLARE_WAR_MODE = 0;
                    CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("DeclareWar"), CFG.lang.get("ChooseAProvince"), Images.infoDiplomacy);
                }
            });
        }

        if (CFG.SPECTATOR_MODE || CFG.SANDBOX_MODE) {
            menuElems.add(new Button_DiplomacyAction(Images.topDiplomacyPoints, CFG.lang.get("ManageDiplomacy"), 0, 0, tY += tempElemH, menuW - 2, tempElemH, true){
                @Override
                public void actionElem(int iID) {
                    CFG.core.setActiveProvID(-1);
                    CFG.menus.rebuildManageDiplomacy_Alliances();
                    CFG.menus.setMenuID(View.eMANAGE_DIPLOMACY);
                }
            });
        }

        if (GameValues.gvInGame.SHOW_ALL_ACTIONS_IN_CIV_DECISIONS) {
            menuElems.add(new ButtonN_ActionAll(Colors.COLOR_TEXT_MODIFIER_POSITIVE, CFG.lang.get("Assimilate") + ": " + CFG.lang.get("AllProvinces"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.lang.get("Provinces") + ": ", CFG.getNumberWthSpaces("" + CFG.core.assimilateAllProvinces_Number(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getNumberWthSpaces("" + CFG.core.assimilateAllProvinces_Cost(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.getPrecision2(CFG.core.assimilateAllProvinces_CostDiplomacy(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 10), Images.topDiplomacyPoints, CFG.COLOR_DIPLOMACY_POINTS, Images.diploStability, CFG.getColorStep(CFG.COLOR_PROVINCE_STABILITY_MIN, CFG.COLOR_PROVINCE_STABILITY_MAX, (int)(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getStabilityCiv() * 100.0f), 100, 1.0f), 0, tY += tempElemH, menuW - 2, tempElemH){
                @Override
                public void actionElem(int iID) { CFG.setDialogType(DialogType.ALL_ASSIMILATE); }
            });
        }

        menuElems.add(new Button_Diplomacy_Action_Tech(Images.technology, CFG.lang.get("Technology"), 0, 0, tY += tempElemH, menuW - 2, tempElemH, true){
            @Override
            public void actionElem(int iID) { CFG.menus.rebuildInGame_Technology(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()); }
        });

        menuElems.add(new Button_DiplomacyAction(Images.gov, CFG.lang.get(GameValues.gvAdministrationPolicy.POLICY_NAME[CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.policyID]), 0, 0, tY += tempElemH, menuW - 2, tempElemH, true){
            @Override
            public void actionElem(int iID) { CFG.menus.rebuildInGame_AdministrationPolicy(); }
        });

        menuElems.add(new Button_DiplomacyAction_TextRight(Images.diploLoan, CFG.lang.get("TakeLoan"), 0, 0, tY += tempElemH, menuW - 2, tempElemH, true, "" + CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getLoansSize(), Images.diploLoan){
            @Override
            public void actionElem(int iID) { CFG.menus.rebuildInGame_TakeLoan(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()); }
        });

        menuElems.add(new Button_DiplomacyAction(Images.pop, CFG.lang.get("RelocatePopulation"), 0, 0, tY += tempElemH, menuW - 2, tempElemH, true){
            @Override
            public void actionElem(int iID) { CFG.menus.rebuildInGame_Build_RelocatePopulation(CFG.core.getActiveProvID()); }
            @Override
            public boolean getIsClickable() { return CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(); }
        });

        menuElems.add(new Button_DiplomacyAction(Images.diploMessage, CFG.lang.get("PopulationTransfer"), 0, 0, tY += tempElemH, menuW - 2, tempElemH, true){
            @Override
            public void actionElem(int iID) { CFG.menus.rebuildInGameForceMigration(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()); }
        });

        menuElems.add(new Button_DiplomacyAction(Images.diploAZ, CFG.lang.get("FormableCivilizations"), 0, 0, tY += tempElemH, menuW - 2, tempElemH, true){
            @Override
            public void actionElem(int iID) { CFG.menus.rebuildInGame_FormCivList(); }
        });

        menuElems.add(new Button_DiplomacyAction(Images.diploVassal, CFG.lang.get("LiberateAVassal"), 0, 0, tY += tempElemH, menuW - 2, tempElemH, true){
            @Override
            public void actionElem(int iID) {
                CFG.core.setActiveProvID(-1);
                CFG.menus.rebuildManageDiplomacy_Vassals();
                CFG.menus.setMenuID(View.eMANAGE_DIPLOMACY);
            }
        });

        menuElems.add(new Button_DiplomacyAction(Images.nuke, CFG.lang.get("BuildAnAtomicBomb"), 0, 0, tY += tempElemH, menuW - 2, tempElemH, true){
            @Override
            public void actionElem(int iID) { CFG.menus.rebuildInGame_Build_Nuke(); }
        });

        if (CFG.SANDBOX_MODE) {
            menuElems.add(new Button_DiplomacyAction(Images.diploWar, CFG.lang.get("FightTheCoalition"), 0, 0, tY += tempElemH, menuW - 2, tempElemH, true){
                @Override
                public void actionElem(int iID) { CFG.menus.rebuildInGame_FightCoalition(); }
                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("FightTheCoalition"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("FightTheCoalitionDesc")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
        }

        menuElems.add(new Button_DiplomacyAction(Images.gov, CFG.lang.get("ChangeGovernment"), 0, 0, tY += tempElemH, menuW - 2, tempElemH, true){
            @Override
            public void actionElem(int iID) { CFG.menus.rebuildInGame_ChangeGovernment(); }
        });

        menuElems.add(new Button_DiplomacyAction(Images.diploAlliance, CFG.lang.get("Alliances"), 0, 0, tY += tempElemH, menuW - 2, tempElemH, true){
            @Override
            public void actionElem(int iID) { CFG.menus.rebuildInGame_FormAlliance(); }
        });

        menuElems.add(new Button_DiplomacyAction(Images.diploUnion, CFG.lang.get("Unions"), 0, 0, tY += tempElemH, menuW - 2, tempElemH, true){
            @Override
            public void actionElem(int iID) { CFG.menus.rebuildInGame_FormUnionList(); }
        });

        menuElems.add(new Button_DiplomacyAction(Images.diploWar, CFG.lang.get("Wars"), 0, 0, tY += tempElemH, menuW - 2, tempElemH, true){
            @Override
            public void actionElem(int iID) { CFG.menus.rebuildInGame_Wars(); }
        });

        menuElems.add(new Button_DiplomacyAction(Images.diploArmy, CFG.lang.get("Army"), 0, 0, tY += tempElemH, menuW - 2, tempElemH, true){
            @Override
            public void actionElem(int iID) { CFG.menus.rebuildInGame_Army(); }
        });

        menuElems.add(new Button_DiplomacyAction(Images.diploArmyStar, CFG.lang.get("MoveCapital"), 0, 0, tY += tempElemH, menuW - 2, tempElemH, true){
            @Override
            public void actionElem(int iID) { CFG.menus.rebuildInGame_MoveCapital(CFG.core.getActiveProvID()); }
            @Override
            public boolean getIsClickable() { return CFG.core.getActiveProvID() >= 0; }
        });

        menuElems.add(new Button_DiplomacyAction(Images.victoryPoints, CFG.lang.get("VictoryConditions"), 0, 0, tY += tempElemH, menuW - 2, tempElemH, true){
            @Override
            public void actionElem(int iID) { CFG.menus.rebuildInGame_VictoryConditions(); }
        });

        menuElems.add(new Button_DiplomacyAction(Images.time, CFG.lang.get("History"), 0, 0, tY += tempElemH, menuW - 2, tempElemH, true){
            @Override
            public void actionElem(int iID) { CFG.menus.rebuildInGame_History(); }
        });

        LAST_ELEMENT_POSY = tY;
        this.initMenu(new TitleM_TextSmall(null, Menu_InGame_Civ_DiplomacyORActions.getButtonHeight(), false, false){
            @Override
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, Menu_InGame_Civ_Decisions.this.getPosX() + iTranslateX, Menu_InGame_Civ_Decisions.this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() - this.getHeightT(), Menu_InGame_Civ_Decisions.this.getWidthM() + Core.PADDING, this.getHeightT(), true, false);
                CFG.drawRectInfoBox_Left_Title(oSB, Menu_InGame_Civ_Decisions.this.getPosX() + iTranslateX, Menu_InGame_Civ_Decisions.this.getPosY() - this.getHeightT(), Menu_InGame_Civ_Decisions.this.getWidthM() - 2, this.getHeightT());
                Renderer.drawTextWithShadow(oSB, CFG.FONT_BOLD_SMALL, CFG.lang.get("Decisions"), nPosX + nWidth / 2 - (int)CFG.glyphLay.width / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - (int)CFG.glyphLay.height / 2, CFG.COLOR_TEXT_CIV_INFO_TITLE);
            }
        }, AoCGame.LEFT, IMGManager.getIMG(Images.gameTop).getHeight() + CFG.PADD * 4 + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.6f) + ButtonFlagBig.getButtonH() + CFG.PADD * 4, menuW, tempElemH * 22 + 1, menuElems, true, false);
        this.updateLang();
        for (int i = 0; i < this.getMenuElemsSize(); ++i) this.getMenuElem(i).setCurr(i % 2);
        extraPosX = -this.getWidthM();
    }

    @Override
    public void updateLang() { this.getTitleM().setText(CFG.lang.get("Decisions")); }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (Menu_InGame_Civ.lTime + (long)GameValues.gvInGame.MENUS_ANIMATION_TIME >= System.currentTimeMillis()) {
            if (Menu_InGame_Civ.hideAnimation) extraPosX = -((int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - Menu_InGame_Civ.lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME)));
            else extraPosX = -this.getWidthM() + (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - Menu_InGame_Civ.lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME));
            iTranslateX += extraPosX;
        } else if (Menu_InGame_Civ.hideAnimation) { super.setVisibleM(false); return; } else { extraPosX = 0; }
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING, this.getHeightM() + 2, true, false);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
    }

    @Override
    public void actionEL(int iID) { if (CFG.gameAction.getActiveTurnStateID() == GameAction.TurnStates.INPUT_ORDERS) this.getMenuElem(iID).actionElem(iID); }

    @Override
    public void setPosY(int iPosY) {
        super.setPosY(iPosY);
        int tempElemH = Menu_InGame_Civ_Decisions.getButtonH();
        this.setHeight(Math.max(CFG.GAMEHEIGHT - this.getPosY() - CFG.PADD, Math.min(this.getHeightM(), tempElemH * 22)));
        this.updateMenuElements_IsInView();
    }

    public static void rebuildLeaderC() {
        try {
            if (Menu_InGame_LeaderC.civID > 0) {
                if (CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(Menu_InGame_LeaderC.civID).getCivTag()).equals("pol")) {
                    if (CFG.oR.nextInt(100) < 50) CFG.menus.rebuildInGame_LeaderC("Lukasz Jakowski");
                    else CFG.menus.rebuildInGame_LeaderC("Ryniu");
                } else if (CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(Menu_InGame_LeaderC.civID).getCivTag()).equals("fra")) {
                    CFG.menus.rebuildInGame_LeaderC("BalekduNom");
                } else if (CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(Menu_InGame_LeaderC.civID).getCivTag()).equals("tur")) {
                    CFG.menus.rebuildInGame_LeaderC("Kerem Yilmaz");
                } else if (CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(Menu_InGame_LeaderC.civID).getCivTag()).equals("rus")) {
                    CFG.menus.rebuildInGame_LeaderC("Dimzap");
                }
            }
        } catch (Exception ex) { CFG.exceptionStack(ex); }
    }
}
