
package age.of.civilizations2.jakowski.lukasz.Menus.Civilization;

import age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle.AIPlaystyle;
import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_DiplomacyAction;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_DiplomacyAction_TextRight;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_DiplomacyAction_TextRight2;
import age.of.civilizations2.jakowski.lukasz.Button.Diplomacy.Action.Button_DiplomacyAction_XV;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button2.ButtonFlagBig;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.PeaceTreaty_Data;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology_Vassal_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image_Big2;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Religion;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text_Big;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.Build.Menu_InGame_BuildForeign;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_Civ_Decisions;
import age.of.civilizations2.jakowski.lukasz.Menus.Civilization.Menu_InGame_ProposeFormUnion;
import age.of.civilizations2.jakowski.lukasz.Menus.Continents.Menu_InGame_LeaderC;
import age.of.civilizations2.jakowski.lukasz.Menus.Menu_InitGame;
import age.of.civilizations2.jakowski.lukasz.Menus.PeaceTreaty.Menu_PeaceTreaty;
import age.of.civilizations2.jakowski.lukasz.Menus.Relations.Actions.Menu_InGameOfferAlliance;
import age.of.civilizations2.jakowski.lukasz.Menus.Relations.Actions.Menu_InGame_HostSummit;
import age.of.civilizations2.jakowski.lukasz.Menus.Send.Army.Menu_InGame_SendArmy;
import age.of.civilizations2.jakowski.lukasz.Menus.Send.Nuke.Menu_InGame_SendNuke;
import age.of.civilizations2.jakowski.lukasz.Menus.Vassal.Menu_InGame_SpreadPropaganda;
import age.of.civilizations2.jakowski.lukasz.Menus.Wars.Details.Menu_InGame_WarDetails;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_CivilizationView;
import age.of.civilizations2.jakowski.lukasz.RTS;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Touch;
import age.of.civilizations2.jakowski.lukasz.TradeRequest_GameData;
import age.of.civilizations2.jakowski.lukasz.Ultimatum_GameData;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Menu_InGame_Civ_Actions
extends Menu {
    public static boolean toTheBottom = false;
    public static int extraPosX = 0;

    public static int getButtonH() {
        return Math.max(CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD * 4, CFG.BUTTON_H * 7 / 10);
    }

    public Menu_InGame_Civ_Actions() {
        int i;
        ArrayList<MenuElemUI> menuElems = new ArrayList<MenuElemUI>();
        int menuW = Menu_InGame_Civ.getMenuCivInfoWidth();
        int nPosY = 0;
        int tempElemH = Menu_InGame_Civ_Actions.getButtonH();
        boolean isRebels = false;
        try {
            isRebels = CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.getActiveCivInfoId()).getIdeology()).REVOLUTIONARY;
        }
        catch (Exception exception) {
            
        }
        if (CFG.SPECTATOR_MODE) {
            menuElems.add(new Button_DiplomacyAction(Images.diploAZ, CFG.lang.get("LockCivilization") + ": " + (CFG.SPECTATOR_MODE_LOCK_CIV ? CFG.lang.get("On") : CFG.lang.get("Off")), 0, 0, nPosY, menuW - 2, tempElemH, true){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("LockCivilization"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploAZ, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("LockCivilizationDesc")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }

                @Override
                public void actionElem(int iID) {
                    CFG.SPECTATOR_MODE_LOCK_CIV = !CFG.SPECTATOR_MODE_LOCK_CIV;
                    this.setTextE(CFG.lang.get("LockCivilization") + ": " + (CFG.SPECTATOR_MODE_LOCK_CIV ? CFG.lang.get("On") : CFG.lang.get("Off")));
                }
            });
            nPosY += tempElemH;
        }
        if (!CFG.core.getCivsAtWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())) {
            int i2;
            if (!CFG.SANDBOX_MODE && CFG.core.getCivTruce(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId()) > 0) {
                menuElems.add(new Button_DiplomacyAction_TextRight(Images.diploWar, CFG.lang.get("DeclareWar"), 0, 0, nPosY, menuW - 2, tempElemH, CFG.core.canDeclareWar_TribalColonize_NeedsToBorder(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId()), "" + CFG.core.getCivTruce(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId()), Images.diploTruce){
                    {
                        this.setCurr(CFG.getActiveCivInfoId());
                    }
                    @Override
                    public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        if (this.menuElemHover != null) {
                            this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                        }
                    }
                    @Override
                    public void buildElemHover() {
                        this.menuElemHover = Menu_InGame_Civ_Actions.this.getHoverDeclareWar();
                    }
                    @Override
                    public void actionElem(int iID) {
                        CFG.menus.rebuildInGame_DeclareWar(CFG.getActiveCivInfoId());
                    }
                    @Override
                    public boolean getIsClickable() {
                        return super.getIsClickable() && (CFG.SANDBOX_MODE || (GameCalendar.TURNID > CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS && CFG.core.getCivTruce(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId()) == 0));
                    }
                    @Override
                    public int getSFXElem() {
                        return this.getIsClickable() ? SFXManager.SFX_WAR : super.getSFXElem();
                    }
                });
            } else {
                menuElems.add(new Button_DiplomacyAction(Images.diploWar, CFG.lang.get("DeclareWar"), 0, 0, nPosY, menuW - 2, tempElemH, CFG.SANDBOX_MODE || CFG.core.canDeclareWar_TribalColonize_NeedsToBorder(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivID_Any())){
                    {
                        this.setCurr(CFG.getActiveCivInfoId());
                    }
                    @Override
                    public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        if (this.menuElemHover != null) {
                            this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                        }
                    }
                    @Override
                    public void buildElemHover() {
                        this.menuElemHover = Menu_InGame_Civ_Actions.this.getHoverDeclareWar();
                    }
                    @Override
                    public void actionElem(int iID) {
                        CFG.menus.rebuildInGame_DeclareWar(CFG.getActiveCivInfoId());
                    }
                    @Override
                    public boolean getIsClickable() {
                        return super.getIsClickable() && (CFG.SANDBOX_MODE || (GameCalendar.TURNID > CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS && CFG.core.getCivTruce(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId()) == 0));
                    }
                    @Override
                    public int getSFXElem() {
                        return this.getIsClickable() ? SFXManager.SFX_WAR : super.getSFXElem();
                    }
                });
            }
            nPosY += tempElemH;
            boolean canPrepareForWar = CFG.SANDBOX_MODE;
            if (!canPrepareForWar && CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance() > 0) {
                for (i2 = 0; i2 < CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance()).getCivilizationsSize(); ++i2) {
                    if (CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance()).getCivilization(i2) == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.getActiveCivInfoId() == CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance()).getCivilization(i2) || CFG.core.getCivsAtWar(CFG.getActiveCivInfoId(), CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance()).getCivilization(i2))) continue;
                    canPrepareForWar = true;
                    break;
                }
            }
            if (!canPrepareForWar) {
                for (i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                    if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == i2 || CFG.core.getCiv(i2).getPuppetOfCiv() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getCivsAtWar(CFG.getActiveCivInfoId(), i2)) continue;
                    canPrepareForWar = true;
                    break;
                }
            }
            if (canPrepareForWar) {
                menuElems.add(new Button_DiplomacyAction(Images.diploWarPreparations, CFG.lang.get("PrepareForWar"), 0, 0, nPosY, menuW - 2, tempElemH, CFG.SANDBOX_MODE || CFG.core.canDeclareWar_TribalColonize_NeedsToBorder(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())){

                    {
                        this.setCurr(CFG.getActiveCivInfoId());
                    }

                    @Override
                    public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        if (this.menuElemHover != null) {
                            this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                        }
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        if (GameCalendar.TURNID <= CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AWarCantBeDeclaredInFirstXTurns", CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS) + ".", CFG.COLOR_NEGATIVE_2));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, 0));
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (CFG.core.getCivTruce(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId()) > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("WeHaveATruceUntil") + ": ", CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Text_Big(GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getCivTruce(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId()))));
                            nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", CFG.core.getCivTruce(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.diploTruce, CFG.PADD, 0));
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (!CFG.core.canDeclareWar_TribalColonize_NeedsToBorder(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("YouMustBorderWithCivilization"), CFG.COLOR_NEGATIVE_2));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, 0));
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Space());
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Flag(CFG.getActiveCivInfoId()));
                            nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Government") + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.getActiveCivInfoId()).getIdeology()).getName(), CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.getActiveCivInfoId()).getIdeology()).getColor()));
                            nData.add(new ME_Hover_2Type_Ideology(CFG.core.getCiv(CFG.getActiveCivInfoId()).getIdeology(), CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("PrepareForTheWarAgainst") + ": ", CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), 0, CFG.PADD));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivName()));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.diploWarPreparations, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("PrepareForWarDesc")));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.menus.rebuildInGame_WarPreparations(this.getCurr());
                    }

                    @Override
                    public boolean getIsClickable() {
                        return super.getIsClickable() && (CFG.SANDBOX_MODE || (GameCalendar.TURNID > CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS && CFG.core.getCivTruce(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), this.getCurr()) == 0));
                    }

                    @Override
                    public int getSFXElem() {
                        return this.getIsClickable() ? SFXManager.SFX_WAR : super.getSFXElem();
                    }
                });
                nPosY += tempElemH;
            }
            if (!isRebels) {
                menuElems.add(new Button_DiplomacyAction(Images.diploRivals, CFG.lang.get("SendUltimatum"), 0, 0, nPosY, menuW - 2, tempElemH, CFG.core.canDeclareWar_TribalColonize_NeedsToBorder(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())){

                    @Override
                    public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        if (this.menuElemHover != null) {
                            this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                        }
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SendUltimatum") + ": ", CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivName()));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        if (GameCalendar.TURNID <= CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AWarCantBeDeclaredInFirstXTurns", CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS) + ".", CFG.COLOR_NEGATIVE_2));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, 0));
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (CFG.core.getCivTruce(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId()) > 0) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("WeHaveATruceUntil") + ": ", CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Text_Big(GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getCivTruce(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId()))));
                            nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", CFG.core.getCivTruce(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.diploTruce, CFG.PADD, 0));
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (!CFG.core.canDeclareWar_TribalColonize_NeedsToBorder(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("YouMustBorderWithCivilization"), CFG.COLOR_NEGATIVE_2));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, 0));
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Space());
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Flag(CFG.getActiveCivInfoId()));
                            nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Government") + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.getActiveCivInfoId()).getIdeology()).getName(), CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.getActiveCivInfoId()).getIdeology()).getColor()));
                            nData.add(new ME_Hover_2Type_Ideology(CFG.core.getCiv(CFG.getActiveCivInfoId()).getIdeology(), CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv() != CFG.getActiveCivInfoId() && CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("YouCanSendDemandsOnlyToALordOrYourVassal"), CFG.COLOR_NEGATIVE_2));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.diploRivals, CFG.PADD, 0));
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else if (CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) > (float)GameValues.gvUltimatum.ULTIMATUM_REQUIRED_RELATIONS) {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("OurRelationsNeedsToBeBelow") + ": "));
                            nData.add(new ME_Hover_2Type_Text_Big("" + GameValues.gvUltimatum.ULTIMATUM_REQUIRED_RELATIONS, CFG.COLOR_NEGATIVE_2));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelations, CFG.PADD, 0));
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        } else {
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("OurRelationsNeedsToBeBelow") + ": "));
                            nData.add(new ME_Hover_2Type_Text_Big("" + GameValues.gvUltimatum.ULTIMATUM_REQUIRED_RELATIONS, CFG.COLOR_NEGATIVE_2));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelations, CFG.PADD, 0));
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("SendUltimatumDesc")));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.ultimatum = new Ultimatum_GameData();
                        CFG.menus.rebuildInGame_SendUltimatum(CFG.getActiveCivInfoId());
                    }

                    @Override
                    public boolean getIsClickable() {
                        return super.getIsClickable() && (CFG.SANDBOX_MODE || (GameCalendar.TURNID > CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS && CFG.core.getCivTruce(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId()) == 0 && (CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv() == CFG.getActiveCivInfoId() || CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) && CFG.core.getCivRelationOfCivB(CFG.getActiveCivInfoId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) <= (float)GameValues.gvUltimatum.ULTIMATUM_REQUIRED_RELATIONS));
                    }
                });
                nPosY += tempElemH;
            }
            if (CFG.SANDBOX_MODE && !isRebels) {
                menuElems.add(new Button_DiplomacyAction(Images.frontline, "Control", 0, 0, nPosY, menuW - 2, tempElemH, true){
                    @Override
                    public void actionElem(int iID) {
                        CFG.menus.rebuildInGame_CivControl(CFG.getActiveCivInfoId());
                    }
                });
                nPosY += tempElemH;
            }
            if (!isRebels) {
                menuElems.add(new Button_DiplomacyAction(Images.diploTrade, CFG.lang.get("TradeRequest"), 0, 0, nPosY, menuW - 2, tempElemH, true){

                    @Override
                    public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        if (this.menuElemHover != null) {
                            this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                        }
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.tradeRequest = new TradeRequest_GameData();
                        CFG.tradeRequest.iCivLEFT = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                        CFG.tradeRequest.iCivRIGHT = CFG.getActiveCivInfoId();
                        CFG.menus.rebuildInGame_TradeRequest(CFG.getActiveCivInfoId());
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("TradeRequest"), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploTrade, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("TradeDealDesc")));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                nPosY += tempElemH;
            }
        } else {
            menuElems.add(new Button_DiplomacyAction(Images.diploWar, CFG.lang.get("AtWar"), 0, 0, nPosY, menuW - 2, tempElemH, true){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AtWar"), CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }

                @Override
                public Color getColorE(boolean isActive) {
                    return isActive ? CFG.COLOR_NEGATIVE_ACTIVE : (this.getIsHovered() ? CFG.COLOR_NEGATIVE_HOVER : new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.6f));
                }

                @Override
                public void actionElem(int iID) {
                    Menu_InGame_WarDetails.WAR_ID = CFG.core.getWarID(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId());
                    CFG.menus.rebuildInGame_WarDetails();
                }
            });
            nPosY += tempElemH;
        }
        if (CFG.core.getCivsAtWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())) {
            menuElems.add(new Button_DiplomacyAction(Images.diploRivals, CFG.lang.get("CallToArms"), 0, 0, nPosY, menuW - 2, tempElemH, true){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_CallToArms(CFG.getActiveCivInfoId());
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("CallToArms"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploRivals, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            nPosY += tempElemH;
        }
        if (CFG.core.getCivsAtWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())) {
            menuElems.add(new Button_DiplomacyAction(Images.diploTruce, CFG.lang.get("PeaceNegotiations"), 0, 0, nPosY, menuW - 2, tempElemH, true){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void actionElem(int iID) {
                    int nWarID = CFG.core.getWarID(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId());
                    if (nWarID >= 0) {
                        CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_ActiveProvince = CFG.core.getActiveProvID();
                        CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                        CFG.mapModesManager.disableAllViews();
                        Menu_PeaceTreaty.WAR_ID = nWarID;
                        CFG.peaceTreatyData = new PeaceTreaty_Data(Menu_PeaceTreaty.WAR_ID, CFG.core.getWar(nWarID).getIsAggressor(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                        CFG.core.resetChooseProvinceData_Immediately();
                        CFG.core.resetRegroupArmy_Data();
                        CFG.menus.setMenuID(View.eINGAME_PEACE_TREATY);
                    }
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("PeaceNegotiations"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploTruce, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            nPosY += tempElemH;
            if (GameValues.gvCeasefire.ENABLE_CEASEFIRE) {
                menuElems.add(new Button_DiplomacyAction(Images.diploTruce, CFG.lang.get("NegotiateCeasefire"), 0, 0, nPosY, menuW - 2, tempElemH, true){

                    @Override
                    public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        if (this.menuElemHover != null) {
                            this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                        }
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.menus.rebuildInGame_Fc(CFG.getActiveCivInfoId());
                    }

                    @Override
                    public Color getColorE(boolean isActive) {
                        try {
                            if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.orzC > GameCalendar.TURNID) {
                                return isActive ? CFG.COLOR_NEGATIVE_ACTIVE : (this.getIsHovered() ? CFG.COLOR_NEGATIVE_HOVER : new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.6f));
                            }
                        }
                        catch (Exception exception) {
                            
                        }
                        return super.getColorE(isActive);
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("NegotiateCeasefire"), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploTruce, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        if (CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.orzC > GameCalendar.TURNID) {
                            nData.add(new ME_Hover_2Type_Space());
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("ActionAvailableInTurn") + " " + CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.orzC, CFG.COLOR_NEGATIVE_2));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_TextDesc(GameCalendar.getDate_ByTurnID(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.orzC), CFG.COLOR_NEGATIVE_2));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        try {
                            int warID = CFG.core.getWarID(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId());
                            if (warID >= 0 && GameCalendar.TURNID < CFG.core.getWar(warID).getWarTurnID() + GameValues.gvCeasefire.CEASEFIRE_MIN_TURNS_OF_WAR) {
                                nData.add(new ME_Hover_2Type_Space());
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("ACeasefireCannotBeProposedShortlyAfterAWarBegins") + " " + CFG.lang.get("TurnsX", GameValues.gvCeasefire.CEASEFIRE_MIN_TURNS_OF_WAR), CFG.COLOR_NEGATIVE_2));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                        }
                        catch (Exception exception) {
                            
                        }
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("CeasefireDesc") + " " + CFG.lang.get("TurnsX", GameValues.gvCeasefire.CEASEFIRE_TURNS)));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("CeasefireDesc2"), CFG.COLOR_NEGATIVE_2));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("ACeasefireCannotBeProposedShortlyAfterAWarBegins") + " " + CFG.lang.get("TurnsX", GameValues.gvCeasefire.CEASEFIRE_MIN_TURNS_OF_WAR)));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("ACeasefireCanOnlyBeProposedOnceEvery") + " " + CFG.lang.get("TurnsX", GameValues.gvCeasefire.CEASEFIRE_COOLDOWN)));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                nPosY += tempElemH;
            }
        } else {
            if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv() == CFG.getActiveCivInfoId()) {
                menuElems.add(new Button_DiplomacyAction(Images.diploVassal, CFG.lang.get("DeclarationOfIndependence"), 0, 0, nPosY, menuW - 2, tempElemH, CFG.SANDBOX_MODE || CFG.core.getCivTruce(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv()) == 0){

                    @Override
                    public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        if (this.menuElemHover != null) {
                            this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                        }
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.menus.rebuildInGame_DeclarationOfIndependence(CFG.getActiveCivInfoId());
                    }

                    @Override
                    public void buildElemHover() {
                        try {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            if (CFG.core.getCivTruce(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv()) > 0) {
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("WeHaveATruceUntil") + ": ", CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Text_Big(GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getCivTruce(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv()))));
                                nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", CFG.core.getCivTruce(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv())) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.diploTruce, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                this.menuElemHover = new ME_Hover_v2(nElements);
                            } else {
                                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DeclarationOfIndependence"), CFG.COLOR_HOVER_TITLE));
                                nData.add(new ME_Hover_2Type_Image_Big(Images.diploVassal, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                                this.menuElemHover = new ME_Hover_v2(nElements);
                            }
                        }
                        catch (Exception ex) {
                            this.menuElemHover = null;
                        }
                    }
                });
                nPosY += ((MenuElemUI)menuElems.get(menuElems.size() - 1)).getHeightE();
            }
            menuElems.add(new Button_DiplomacyAction_TextRight(Images.diploIntervene, CFG.lang.get("InterveneInWar"), 0, 0, nPosY, menuW - 2, tempElemH, true, "" + CFG.core.getCiv((int)CFG.getActiveCivInfoId()).isAtWarWithCivs.size(), Images.diploWar){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_Wars_Civ(CFG.getActiveCivInfoId());
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("InterveneInWar"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploIntervene, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("InterveneInWarDesc")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            nPosY += tempElemH;
            if (!isRebels) {
                menuElems.add(new Button_DiplomacyAction_TextRight(Images.diploTruce, CFG.lang.get("EnforcePeace"), 0, 0, nPosY, menuW - 2, tempElemH, true, "" + CFG.core.getCiv((int)CFG.getActiveCivInfoId()).isAtWarWithCivs.size(), Images.diploWar){

                    @Override
                    public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        if (this.menuElemHover != null) {
                            this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                        }
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.menus.rebuildInGame_EnforcePeace_Wars(CFG.getActiveCivInfoId());
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("EnforcePeace"), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploTruce, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploRivals, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DemandThatTheAggressorEndTheirWar")));
                        nData.add(new ME_Hover_2Type_Image(Images.diploWar, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("EnforcePeaceText1")));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("EnforcePeaceText2")));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("EnforcePeaceDesc"), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                nPosY += tempElemH;
            }
        }
        if (CFG.getActiveCivInfoId() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() && CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
            menuElems.add(new Button_DiplomacyAction_TextRight(Images.diploVassal, CFG.lang.get("Tribute"), 0, 0, nPosY, menuW - 2, tempElemH, true, "" + CFG.getNumberWthSpaces("" + (int)CFG.gameUpdate.getVassalizationMoney(CFG.getActiveCivInfoId())), Images.topGold()){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void actionElem(int iID) {
                    if (CFG.menus.getVisibleInGame_Tribute()) {
                        CFG.menus.setVisibleInGame_Tribute(false);
                    } else {
                        CFG.menus.rebuildInGame_Tribute();
                    }
                }

                @Override
                public void buildElemHover() {
                    int i;
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Vassals") + ": " + CFG.lang.get("Tribute"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Ideology_Vassal_Big(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("VassalsLibertyDesireDesc")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    for (i = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() - 1; i > 0; --i) {
                        if (CFG.core.getCiv(i).getNumOfProvs() <= 0 || CFG.core.getCiv(i).getPuppetOfCiv() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) continue;
                        nData.add(new ME_Hover_2Type_Flag(i));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(i).getCivName() + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + (int)CFG.gameUpdate.getIncomeVassals(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), i), CFG.COLOR_POSITIVE));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    for (i = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() + 1; i < CFG.core.getCivsSize(); ++i) {
                        if (CFG.core.getCiv(i).getNumOfProvs() <= 0 || CFG.core.getCiv(i).getPuppetOfCiv() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) continue;
                        nData.add(new ME_Hover_2Type_Flag(i));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(i).getCivName() + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + (int)CFG.gameUpdate.getIncomeVassals(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), i), CFG.COLOR_POSITIVE));
                        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    if (nElements.size() <= 2) {
                        nElements.clear();
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("NoVassals"), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Ideology_Vassal_Big(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIdeology(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            nPosY += ((MenuElemUI)menuElems.get(menuElems.size() - 1)).getHeightE();
        }
        int tempTurns = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().getIsImprovingRelationsTurns(CFG.getActiveCivInfoId());
        menuElems.add(new Button_DiplomacyAction_TextRight2(Images.diploRelationsInc, CFG.lang.get("ImproveRelations"), 0, 0, nPosY, menuW - 2, tempElemH, !CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivDiploGD().getIsEmbassyClosed(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), tempTurns > 0 ? "" + tempTurns : "", Images.time){

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.menus.rebuildInGame_ImproveRelations(CFG.getActiveCivInfoId());
            }

            @Override
            public void actionElemPPM() {
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().getIsImprovingRelations(CFG.getActiveCivInfoId())) {
                    CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().removeImproveRelations_WithCivID(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId());
                    CFG.toastM.addM(CFG.lang.get("Removed") + "!", CFG.COLOR_GOLD);
                    CFG.toastM.setTimeInView(3500);
                    CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("ImproveRelations") + ": " + CFG.lang.get("Removed"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId(), Images.infoRelations);
                } else {
                    CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().addImproveRelations(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId(), GameValues.gvRelationImprove.IMPROVE_RELATIONS_MAX_NUM_OF_TURNS);
                    CFG.toastM.addM(CFG.lang.get("DiplomatSent") + "!", CFG.COLOR_POSITIVE);
                    CFG.toastM.setTimeInView(3500);
                    CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("DiplomatSent"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId(), Images.infoRelations);
                }
                CFG.updateActiveCivilizationInfoInGame();
                CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            }

            @Override
            public Color getColorE(boolean isActive) {
                try {
                    if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().getIsImprovingRelations(CFG.getActiveCivInfoId())) {
                        return Colors.getColorPositive(isActive, this.getIsHovered());
                    }
                }
                catch (Exception exception) {
                    
                }
                return super.getColorE(isActive);
            }

            @Override
            public void buildElemHover() {
                if (CFG.core.getCivsAtWar(CFG.getActiveCivInfoId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("WeAreAtWar"), CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else if (CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivDiploGD().getIsEmbassyClosed(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DiplomaticRelationsAreSuspended"), CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelationsDec, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                    nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName()));
                    nData.add(new ME_Hover_2Type_Text(" - " + GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivDiploGD().isEmbassyClosed_Turns(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())), CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Text(" [" + CFG.lang.get("TurnsX", CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivDiploGD().isEmbassyClosed_Turns(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                } else {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ImproveRelations"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelationsInc, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    float relation = CFG.core.getCiv(CFG.getActiveCivInfoId()).getRelationD(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelations, 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Opinion") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big("" + (relation > 0.0f ? "+" : "") + CFG.getPrecision2(relation, 100), relation < 0.0f ? CFG.COLOR_NEGATIVE_2 : (relation > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEUTRAL)));
                    nData.add(new ME_Hover_2Type_Image_Big2(Images.diploRelations, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Relations") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big("+" + CFG.getPrecision2(GameManager.getImproveRelation(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId()) * GameValues.gvRelationImprove.IMPROVE_RELATIONS_RECIPROCITY_MODIFIER, 100), CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelationsInc, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            }

            @Override
            public boolean getIsClickable() {
                return super.getIsClickable() && !CFG.core.getCivsAtWar(CFG.getActiveCivInfoId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            }
        });
        nPosY += tempElemH;
        String decreaseRelationsText = CFG.lang.get("SendAnInsult");
        if (GameValues.gvInGame.IMPOSE_TARIFFS_INSULT_TEXT && CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivTag()).equals("usa") && CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.leaderData != null && CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.leaderData.getName().equals("Donald Trump")) {
            decreaseRelationsText = CFG.lang.get("ImposeTariffs");
        }
        menuElems.add(new Button_DiplomacyAction_TextRight2(Images.diploRelationsDec, decreaseRelationsText, 0, 0, nPosY, menuW - 2, tempElemH, true, (tempTurns = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().isEmbassyClosed_Turns(CFG.getActiveCivInfoId())) > 0 ? "" + tempTurns : "", Images.time){

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.menus.rebuildInGame_SendInsult(CFG.getActiveCivInfoId());
            }

            @Override
            public void actionElemPPM() {
                if (GameManager.decreaseRelation(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId(), GameValues.gvRelationDecrease.SUSPEND_DIPLOMATIC_RELATIONS_MAX)) {
                    CFG.toastM.addM(CFG.lang.get("Sent") + "!", CFG.COLOR_POSITIVE);
                    CFG.toastM.setTimeInView(3500);
                    CFG.updateActiveCivilizationInfoInGame();
                    CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                    CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("AnInsultHasBeenSent"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId(), Images.infoRelations);
                }
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SendAnInsult"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelationsDec, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                float relation = CFG.core.getCiv(CFG.getActiveCivInfoId()).getRelationD(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelations, 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Opinion") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + (relation > 0.0f ? "+" : "") + CFG.getPrecision2(relation, 100), relation < 0.0f ? CFG.COLOR_NEGATIVE_2 : (relation > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEUTRAL)));
                nData.add(new ME_Hover_2Type_Image_Big2(Images.diploRelations, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DecreaseRelation") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + CFG.getPrecision2(GameManager.getDecreaseRelation(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId()), 10), CFG.COLOR_NEGATIVE_2));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelationsDec, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().isEmbassyClosed_Turns(CFG.getActiveCivInfoId()) > 0) {
                    int tTurns = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().isEmbassyClosed_Turns(CFG.getActiveCivInfoId());
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("EmbassyClosed") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big("" + CFG.lang.get("TurnsX", tTurns), CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.time, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelationsDec, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        nPosY += tempElemH;
        if (!CFG.core.getCivsAtWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())) {
            boolean summitClickable = true;
            tempTurns = 0;
            for (i = CFG.core.diplomaticSummitCooldowns.size() - 1; i >= 0; --i) {
                if (CFG.core.diplomaticSummitCooldowns.get((int)i).civID != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) continue;
                summitClickable = false;
                tempTurns = CFG.core.diplomaticSummitCooldowns.get((int)i).turnID - GameCalendar.TURNID;
                break;
            }
            menuElems.add(new Button_DiplomacyAction_TextRight2(Images.summit, CFG.lang.get("HostDiplomaticSummit"), 0, 0, nPosY, menuW - 2, tempElemH, summitClickable, tempTurns > 0 ? "" + tempTurns : "", Images.time){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void actionElem(int iID) {
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() == CFG.getActiveCivInfoId()) {
                        switch (CFG.oR.nextInt(3)) {
                            case 0: {
                                Menu_InGame_HostSummit.summitName = CFG.lang.get("Summit1");
                                break;
                            }
                            case 1: {
                                Menu_InGame_HostSummit.summitName = CFG.lang.get("Summit2");
                                break;
                            }
                            case 2: {
                                Menu_InGame_HostSummit.summitName = CFG.lang.get("Summit3");
                            }
                        }
                        Menu_InGame_HostSummit.provinceID = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID();
                        Menu_InGame_HostSummit.invitedCivs.clear();
                        Menu_InGame_HostSummit.invitedCivs.add(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        Menu_InGame_HostSummit.invitedCivs.add(CFG.getActiveCivInfoId());
                        CFG.menus.rebuildInGame_HostSummit();
                    }
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("HostDiplomaticSummit"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.summit, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (this.getIsClickable()) {
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("InviteCivilization") + ": "));
                        nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Flag(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    } else {
                        int turnID = 1;
                        for (int i = CFG.core.diplomaticSummitCooldowns.size() - 1; i >= 0; --i) {
                            if (CFG.core.diplomaticSummitCooldowns.get((int)i).civID != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) continue;
                            turnID = CFG.core.diplomaticSummitCooldowns.get((int)i).turnID;
                            break;
                        }
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("NextPossibleSummitDate") + ": "));
                        nData.add(new ME_Hover_2Type_Text(GameCalendar.getDate_ByTurnID(turnID), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Turn") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + turnID, CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("HostDiplomaticSummitDesc")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            nPosY += tempElemH;
        }
        menuElems.add(new Button_DiplomacyAction(Images.propaganda, CFG.lang.get("SpreadPropaganda"), 0, 0, nPosY, menuW - 2, tempElemH, true){

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                }
            }

            @Override
            public void actionElem(int iID) {
                Menu_InGame_SpreadPropaganda.provinces.clear();
                if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() == CFG.getActiveCivInfoId()) {
                    Menu_InGame_SpreadPropaganda.activeProvince = CFG.core.getActiveProvID();
                    Menu_InGame_SpreadPropaganda.provinces.add(CFG.core.getActiveProvID());
                } else {
                    Menu_InGame_SpreadPropaganda.activeProvince = -1;
                }
                CFG.menus.rebuildInGame_SpreadPropaganda(CFG.getActiveCivInfoId());
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SpreadPropaganda"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.propaganda, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("QuietlyReduceStabilityDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        nPosY += tempElemH;
        if (!CFG.core.getCivsAtWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())) {
            if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance() <= 0 || CFG.core.getCiv(CFG.getActiveCivInfoId()).getAlliance() != CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance()) {
                menuElems.add(new Button_DiplomacyAction_XV(Images.diploAlliance, CFG.lang.get("OfferAlliance"), 0, 0, nPosY, menuW - 2, tempElemH, true, CFG.getActiveCivInfoId() >= 0 && CFG.core.getCiv(CFG.getActiveCivInfoId()).getNumOfProvs() > 0 && GameManager.getLikelihoodScore(GameManager.getAllianceProposal_Positive(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId()) + GameManager.getAllianceProposal_Negative(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())) > 0.5f){

                    @Override
                    public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        if (this.menuElemHover != null) {
                            this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                        }
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.menus.rebuildInGame_OfferAlliance(CFG.getActiveCivInfoId());
                    }

                    @Override
                    public void buildElemHover() {
                        this.menuElemHover = Menu_InGameOfferAlliance.getHoverAllianceScore(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId());
                    }
                });
                nPosY += tempElemH;
            }
            if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance() > 0 && CFG.core.getCiv(CFG.getActiveCivInfoId()).getAlliance() == CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance()) {
                menuElems.add(new Button_DiplomacyAction(Images.diploAlliance, CFG.lang.get("KickFromAlliance"), 0, 0, nPosY, menuW - 2, tempElemH, true){

                    @Override
                    public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        if (this.menuElemHover != null) {
                            this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                        }
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.menus.rebuildInGame_KickFromAlliance(CFG.getActiveCivInfoId());
                    }
                });
                nPosY += tempElemH;
            }
            menuElems.add(new Button_DiplomacyAction(Images.investF1, CFG.lang.get("InvestInForeignProvince"), 0, 0, nPosY, menuW - 2, tempElemH, true){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void actionElem(int iID) {
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() == CFG.getActiveCivInfoId()) {
                        CFG.menus.rebuildInGame_InvestForeign(CFG.getActiveCivInfoId(), CFG.core.getActiveProvID());
                    } else {
                        CFG.menus.rebuildInGame_InvestForeign(CFG.getActiveCivInfoId());
                    }
                }

                @Override
                public void actionElemPPM() {
                    if (CFG.core.getActiveProvID() >= 0) {
                        try {
                            int provinceID = CFG.core.getActiveProvID();
                            if (CFG.core.getProv(provinceID).getCivId() <= 0) {
                                CFG.toastM.addM(CFG.lang.get("Civilization") + ": " + CFG.lang.get("Neutral"), CFG.COLOR_NEGATIVE_1);
                            } else if (CFG.core.getProv(provinceID).getCivId() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                                CFG.toastM.addM(CFG.lang.get("Civilization") + ": " + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName(), CFG.COLOR_NEGATIVE_1);
                            } else if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).areSanctionsAdded(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getProv(provinceID).getCivId()) || CFG.core.getCiv(CFG.core.getProv(provinceID).getCivId()).areSanctionsAdded(CFG.core.getProv(provinceID).getCivId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId())) {
                                CFG.toastM.addM(CFG.lang.get("SanctionsBox1"), CFG.COLOR_NEGATIVE_1);
                            } else if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getGold() > 49L) {
                                GameManager.investForeignEconomy(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), provinceID, GameManager.invest_MaxEconomy_Gold(provinceID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()));
                                CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                                CFG.gameAction.updateInGame_ProvinceInfo();
                                CFG.toastM.addM(CFG.lang.get("Ok") + "!", CFG.COLOR_POSITIVE);
                                CFG.toastM.setTimeInView(3500);
                                CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("InvestInForeignProvince"), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.core.getProv(provinceID).getCivId(), Images.infoEconomy);
                            }
                        }
                        catch (Exception exception) {
                            
                        }
                    }
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("InvestInForeignProvince"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.investF1, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("ForeignInvestYourGoldDirectlyDesc")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            menuElems.add(new Button_DiplomacyAction(Images.investB1, CFG.lang.get("BuildInForeignProvince"), 0, 0, nPosY += tempElemH, menuW - 2, tempElemH, true){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void actionElem(int iID) {
                    if (CFG.core.getActiveProvID() >= 0 && CFG.core.getProv(CFG.core.getActiveProvID()).getCivId() == CFG.getActiveCivInfoId()) {
                        Menu_InGame_BuildForeign.buildBuildList();
                        CFG.menus.rebuildInGame_BuildForeign(CFG.getActiveCivInfoId(), CFG.core.getActiveProvID());
                    } else {
                        Menu_InGame_BuildForeign.buildBuildList();
                        CFG.menus.rebuildInGame_BuildForeign(CFG.getActiveCivInfoId());
                    }
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("BuildInForeignProvince"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.investB1, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("ForeignInvestYourGoldDirectlyDesc")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            nPosY += tempElemH;
        }
        if (!CFG.core.getCivsAtWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())) {
            menuElems.add(new Button_DiplomacyAction(Images.diploArmySend, CFG.lang.get("SendVolunteerArmy"), 0, 0, nPosY, menuW - 2, tempElemH, true){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void actionElem(int iID) {
                    Menu_InGame_SendArmy.toProvinceID = -1;
                    CFG.menus.rebuildInGame_SendArmy(CFG.core.getActiveProvID());
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SendVolunteerArmy"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploArmySend, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Province") + ": "));
                    nData.add(new ME_Hover_2Type_Text(CFG.core.getProv(CFG.core.getActiveProvID()).getProvName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                    nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("SendVolunteerArmyText")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            nPosY += ((MenuElemUI)menuElems.get(menuElems.size() - 1)).getHeightE();

        }
        menuElems.add(new Button_DiplomacyAction_XV(Images.sanctions, CFG.lang.get("ImposeSanctions"), 0, 0, nPosY, menuW - 2, tempElemH, true, !CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).areSanctionsAdded(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())){

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.menus.rebuildInGame_ImposeSanctions(CFG.getActiveCivInfoId());
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ImposeSanctions"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.sanctions, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("ImposeSanctionsDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        nPosY += tempElemH;
        if (!CFG.core.getCivsAtWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())) {
            tempTurns = CFG.core.getCivNonAggressionPact(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId());
            menuElems.add(new Button_DiplomacyAction_TextRight2(Images.diploNonAggression, CFG.lang.get("NonAggressionPact"), 0, 0, nPosY, menuW - 2, tempElemH, true, tempTurns > 0 ? "" + tempTurns : "", Images.time){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_NonAggressionPact(CFG.getActiveCivInfoId());
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("NonAggressionPact"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploNonAggression, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("NonAggressionPactDesc")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            nPosY += tempElemH;
        }
        if (!CFG.core.getCivsAtWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId()) && !isRebels) {
            tempTurns = CFG.core.getDefensivePact(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId());
            menuElems.add(new Button_DiplomacyAction_TextRight2(Images.diploDefensivePact, CFG.lang.get("FormDefensivePact"), 0, 0, nPosY, menuW - 2, tempElemH, true, tempTurns > 0 ? "" + tempTurns : "", Images.time){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_DefensivePact(CFG.getActiveCivInfoId());
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("FormDefensivePact"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploDefensivePact, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("DefensivePactDesc")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            nPosY += tempElemH;
        }
        if (!CFG.core.getCivsAtWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId()) && !isRebels) {
            menuElems.add(new Button_DiplomacyAction(Images.diploGuaranteeGives, CFG.lang.get("ProclaimIndependence"), 0, 0, nPosY, menuW - 2, tempElemH, true){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_ProclaimIndependence(CFG.getActiveCivInfoId());
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ProclaimIndependence"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploGuaranteeGives, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("ProclaimDesc")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            nPosY += tempElemH;
        }
        if (!isRebels && !CFG.core.getCivsAtWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())) {
            if (GameValues.gvInGame.SHOW_UNION_RESPONSE_IN_DIPLOMACY_MENU) {
                menuElems.add(new Button_DiplomacyAction_XV(Images.diploUnion, CFG.lang.get("FormUnion"), 0, 0, nPosY, menuW - 2, tempElemH, true, AIPlaystyle.unionResponseAI(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())){

                    @Override
                    public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        if (this.menuElemHover != null) {
                            this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                        }
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.menus.rebuildInGame_FormUnion(CFG.getActiveCivInfoId());
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("FormUnion"), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploUnion, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        boolean unionResponse = AIPlaystyle.unionResponseAI(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId());
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("LikelihoodOfSuccess") + ": "));
                        nData.add(new ME_Hover_2Type_Text(unionResponse ? CFG.lang.get("High") : CFG.lang.get("Low"), unionResponse ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2));
                        nData.add(new ME_Hover_2Type_Image(unionResponse ? Images.iconTrue : Images.iconFalse, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("FormUnionDesc")));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
            } else {
                menuElems.add(new Button_DiplomacyAction(Images.diploUnion, CFG.lang.get("FormUnion"), 0, 0, nPosY, menuW - 2, tempElemH, true){

                    @Override
                    public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        if (this.menuElemHover != null) {
                            this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                        }
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.menus.rebuildInGame_FormUnion(CFG.getActiveCivInfoId());
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("FormUnion"), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploUnion, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("FormUnionDesc")));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
            }
            nPosY += tempElemH;
            if (!CFG.core.getCiv(CFG.getActiveCivInfoId()).getIsPlayer()) {
                menuElems.add(new Button_DiplomacyAction(Images.diploUnion, CFG.lang.get("ProposeUnionBetweenCivilizations"), 0, 0, nPosY, menuW - 2, tempElemH, true){

                    @Override
                    public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        if (this.menuElemHover != null) {
                            this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                        }
                    }

                    @Override
                    public void actionElem(int iID) {
                        Menu_InGame_ProposeFormUnion.civID2 = -1;
                        CFG.menus.rebuildInGame_ProposeFormUnion(CFG.getActiveCivInfoId());
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ProposeUnionBetweenCivilizations"), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploUnion, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("ProposeUnionBetweenCivilizationsDesc")));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                nPosY += tempElemH;
            }
            if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getIsPartOfHolyRomanEmpire()) {
                if (!CFG.core.getCiv(CFG.getActiveCivInfoId()).getIsPartOfHolyRomanEmpire()) {
                    menuElems.add(new Button_DiplomacyAction(Images.hreIcon, CFG.lang.get("InviteCivilization") + ": " + CFG.lang.get("HolyRomanEmpire"), 0, 0, nPosY, menuW - 2, tempElemH, true){

                        @Override
                        public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                            if (this.menuElemHover != null) {
                                this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                            }
                        }

                        @Override
                        public void actionElem(int iID) {
                            CFG.setDialogType(DialogType.INVITE_TO_HRE);
                        }

                        @Override
                        public void buildElemHover() {
                            ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                            ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("InviteCivilization") + ": "));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("HolyRomanEmpire"), CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.hreIcon, CFG.PADD, 0));
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Space());
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Image(Images.hreIcon, 0, CFG.PADD));
                            nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCivName() + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IsTheEmperor"), CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Image(CFG.hreMgr.getHRE().getIsEmperor(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) ? Images.iconTrue : Images.iconFalse, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            float relation = CFG.core.getCiv(CFG.getActiveCivInfoId()).getRelationD(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Relation") + " >= "));
                            nData.add(new ME_Hover_2Type_Text("" + GameValues.gvHre.REQUIRED_RELATION));
                            nData.add(new ME_Hover_2Type_Image(Images.diploRelations, CFG.PADD, 0));
                            nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                            nData.add(new ME_Hover_2Type_Flag(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                            nData.add(new ME_Hover_2Type_Image(relation >= (float)GameValues.gvHre.REQUIRED_RELATION ? Images.iconTrue : Images.iconFalse, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), 0, CFG.PADD));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelations, 0, CFG.PADD));
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Opinion") + ": "));
                            nData.add(new ME_Hover_2Type_Text_Big("" + (relation > 0.0f ? "+" : "") + CFG.getPrecision2(relation, 100), relation < 0.0f ? CFG.COLOR_NEGATIVE_2 : (relation > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEUTRAL)));
                            nData.add(new ME_Hover_2Type_Image_Big2(Images.diploRelations, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Limit") + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("InviteCivilization") + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).playerGD.INVITED_CIVS_HRE + " / " + GameValues.gvHre.MAX_INVITED_CIVS, CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Image(Images.hreIcon, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            this.menuElemHover = new ME_Hover_v2(nElements);
                        }
                    });
                    nPosY += ((MenuElemUI)menuElems.get(menuElems.size() - 1)).getHeightE();
                }
            } else if (CFG.core.getCiv(CFG.getActiveCivInfoId()).getIsPartOfHolyRomanEmpire()) {
                menuElems.add(new Button_DiplomacyAction(Images.hreIcon, CFG.lang.get("JoinAlliance") + ": " + CFG.lang.get("HolyRomanEmpire"), 0, 0, nPosY, menuW - 2, tempElemH, true){

                    @Override
                    public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        if (this.menuElemHover != null) {
                            this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                        }
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.setDialogType(DialogType.JOIN_TO_HRE);
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("JoinAlliance") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("HolyRomanEmpire"), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.hreIcon, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        try {
                            nData.add(new ME_Hover_2Type_Space());
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Image(Images.hreIcon, 0, CFG.PADD));
                            nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivName() + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IsTheEmperor"), CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Image(CFG.hreMgr.getHRE().getEmperor() == CFG.getActiveCivInfoId() ? Images.iconTrue : Images.iconFalse, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            float relation = CFG.core.getCiv(CFG.getActiveCivInfoId()).getRelationD(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Relation") + " >= "));
                            nData.add(new ME_Hover_2Type_Text("" + GameValues.gvHre.REQUIRED_RELATION_JOIN));
                            nData.add(new ME_Hover_2Type_Image(Images.diploRelations, CFG.PADD, 0));
                            nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                            nData.add(new ME_Hover_2Type_Flag(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                            nData.add(new ME_Hover_2Type_Image(relation >= (float)GameValues.gvHre.REQUIRED_RELATION_JOIN ? Images.iconTrue : Images.iconFalse, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), 0, CFG.PADD));
                            nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelations, 0, CFG.PADD));
                            nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Opinion") + ": "));
                            nData.add(new ME_Hover_2Type_Text_Big("" + (relation > 0.0f ? "+" : "") + CFG.getPrecision2(relation, 100), relation < 0.0f ? CFG.COLOR_NEGATIVE_2 : (relation > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEUTRAL)));
                            nData.add(new ME_Hover_2Type_Image_Big2(Images.diploRelations, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Religion") + ": "));
                            nData.add(new ME_Hover_2Type_Text(CFG.lang.get(CFG.religionManager.getReligion(CFG.core.getCiv(CFG.getActiveCivInfoId()).getReligionID()).getName()), CFG.COLOR_HOVER_TITLE));
                            nData.add(new ME_Hover_2Type_Religion(CFG.core.getCiv(CFG.getActiveCivInfoId()).getReligionID(), CFG.PADD, 0));
                            nData.add(new ME_Hover_2Type_Image(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getReligionID() == CFG.core.getCiv(CFG.getActiveCivInfoId()).getReligionID() ? Images.iconTrue : Images.iconFalse, CFG.PADD, 0));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                        catch (Exception exception) {
                            
                        }
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                nPosY += ((MenuElemUI)menuElems.get(menuElems.size() - 1)).getHeightE();
            }
        }
        if (!CFG.core.getCivsAtWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())) {
            if (GameValues.gvLoan.ENABLE_REQUEST_LOAN) {
                menuElems.add(new Button_DiplomacyAction_TextRight2(Images.loanRe, CFG.lang.get("RequestLoan"), 0, 0, nPosY, menuW - 2, tempElemH, true, "" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getLoansFromCivSize() + "/" + GameValues.gvLoan.REQUEST_LOAN_MAX_NUM_OF_LOANS, Images.loanRe){

                    @Override
                    public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                        if (this.menuElemHover != null) {
                            this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                        }
                    }

                    @Override
                    public void actionElem(int iID) {
                        CFG.menus.rebuildInGame_RequestLoan(CFG.getActiveCivInfoId());
                    }

                    @Override
                    public void buildElemHover() {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("RequestLoan"), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.loanRe, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("RequestLoanDesc")));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        float relation = CFG.core.getCiv(CFG.getActiveCivInfoId()).getRelationD(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MinimumRelations") + ": ", relation < (float)GameValues.gvLoan.REQUEST_LOAN_REQUIRED_RELATION ? CFG.COLOR_NEGATIVE_2 : new Color(1.0f, 1.0f, 1.0f, 1.0f)));
                        nData.add(new ME_Hover_2Type_Text((GameValues.gvLoan.REQUEST_LOAN_REQUIRED_RELATION > 0 ? "+" : "") + GameValues.gvLoan.REQUEST_LOAN_REQUIRED_RELATION, relation < (float)GameValues.gvLoan.REQUEST_LOAN_REQUIRED_RELATION ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image(Images.diploRelations, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Opinion") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big("" + (relation > 0.0f ? "+" : "") + CFG.getPrecision2(relation, 100), relation < (float)GameValues.gvLoan.REQUEST_LOAN_REQUIRED_RELATION ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_POSITIVE));
                        nData.add(new ME_Hover_2Type_Image_Big2(Images.diploRelations, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelations, 0, CFG.PADD));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0, CFG.PADD));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Image(CFG.core.isAtPeace(CFG.getActiveCivInfoId()) ? Images.iconTrue : Images.iconFalse));
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AtPeace")));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Loans") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getLoansFromCivSize() + " / ", CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Text("" + GameValues.gvLoan.REQUEST_LOAN_MAX_NUM_OF_LOANS, CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                        nData.add(new ME_Hover_2Type_Image(Images.debt, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getLoansFromCivSize() > 0) {
                            nData.add(new ME_Hover_2Type_Space());
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            for (int i = 0; i < CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getLoansFromCivSize(); ++i) {
                                nData.add(new ME_Hover_2Type_Text(i + 1 + ". "));
                                nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getLoanFromCiv((int)i).iGoldPerTurn * CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getLoanFromCiv((int)i).iTurnsLeft), CFG.COLOR_GOLD));
                                nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
                                nData.add(new ME_Hover_2Type_Flag(CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getLoanFromCiv((int)i).fromCivID, CFG.PADD, CFG.PADD));
                                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TurnsX", CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getLoanFromCiv((int)i).iTurnsLeft)));
                                nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                                nElements.add(new MEHover_2E(nData));
                                nData.clear();
                            }
                        }
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                });
                nPosY += tempElemH;
            }
            menuElems.add(new Button_DiplomacyAction_TextRight(Images.debt, CFG.lang.get("OfferDebtRelief"), 0, 0, nPosY, menuW - 2, tempElemH, true, "" + CFG.core.getCiv(CFG.getActiveCivInfoId()).getLoansSize(), Images.diploLoan){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_DebtRelief(CFG.getActiveCivInfoId());
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("OfferDebtRelief"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.debt, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("RepayCivilizationsLoanDesc")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            nPosY += tempElemH;
        }
        if (!isRebels && !CFG.core.getCivsAtWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId()) && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() != CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()) {
            menuElems.add(new Button_DiplomacyAction_XV(Images.diploVassal, CFG.lang.get("OfferVassalization"), 0, 0, nPosY, menuW - 2, tempElemH, true, AIPlaystyle.offerVassalization_AIResponse(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_OfferVassalization(CFG.getActiveCivInfoId());
                }

                @Override
                public boolean getIsClickable() {
                    return super.getIsClickable() && CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivId() == CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv();
                }

                @Override
                public void buildElemHover() {
                    if (CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivId() == CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()) {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("OfferVassalization"), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploVassal, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("TheBudgetMustBeHigherThanThatOfTheTargetCivilization") + ": x" + CFG.getPrecision2(AIPlaystyle.offerVassalization_BudgetToAccept(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()), 100)));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("EachVassalIncreasesTheRequiredAmount")));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RequiredRelationsOver") + ": "));
                        nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(GameValues.gvAiDiplomacy.OFFER_VASSALIZATION_MIN_RELATION, 100), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Image(Images.diploRelations, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    } else {
                        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("VassalOfAnotherCivilization"), CFG.COLOR_NEGATIVE_2));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv(), CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        this.menuElemHover = new ME_Hover_v2(nElements);
                    }
                }
            });
            nPosY += tempElemH;
        }
        if (!CFG.core.getCivsAtWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId()) && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == CFG.core.getCiv(CFG.getActiveCivInfoId()).getPuppetOfCiv()) {
            menuElems.add(new Button_DiplomacyAction(Images.diploLord, CFG.lang.get("LiberateAVassal"), 0, 0, nPosY, menuW - 2, tempElemH, true){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_LiberateAVassal(CFG.getActiveCivInfoId());
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("LiberateAVassal"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploLord, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            nPosY += tempElemH;
        }
        if (!isRebels) {
            menuElems.add(new Button_DiplomacyAction(Images.diploRevolution, "Support Revolution", 0, 0, nPosY, menuW - 2, tempElemH, true){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_SupportRevolution(CFG.getActiveCivInfoId());
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big("Support Revolution", CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploRevolution, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc("Fund an ideological civil war to change this civilization's government."));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc("Supports core, minority and immigrant revolutionary movements."));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            nPosY += tempElemH;
        }
        if (!CFG.core.getCivsAtWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())) {
            tempTurns = CFG.core.getMilitaryAccess(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId());
            menuElems.add(new Button_DiplomacyAction_TextRight2(Images.diploAccessHas, CFG.lang.get("AskForMilitaryAccess"), 0, 0, nPosY, menuW - 2, tempElemH, true, tempTurns > 0 ? "" + tempTurns : "", Images.time){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_MilitartAccess_Ask(CFG.getActiveCivInfoId());
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AskForMilitaryAccess"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploAccessHas, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("MilitaryAccessAskDesc")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            nPosY += tempElemH;
        }
        if (!CFG.core.getCivsAtWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())) {
            tempTurns = CFG.core.getMilitaryAccess(CFG.getActiveCivInfoId(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            menuElems.add(new Button_DiplomacyAction_TextRight2(Images.diploAccessGives, CFG.lang.get("OfferMilitaryAccess"), 0, 0, nPosY, menuW - 2, tempElemH, true, tempTurns > 0 ? "" + tempTurns : "", Images.time){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_MilitartAccess_Give(CFG.getActiveCivInfoId());
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("OfferMilitaryAccess"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploAccessGives, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("MilitaryAccessGiveDesc")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            nPosY += tempElemH;
        }
        tempTurns = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getTechLevelINT() - CFG.core.getCiv(CFG.getActiveCivInfoId()).getTechLevelINT();
        menuElems.add(new Button_DiplomacyAction_TextRight2(Images.technology, CFG.lang.get("ShareTechnology"), 0, 0, nPosY, menuW - 2, tempElemH, true, tempTurns > 0 ? CFG.getPrecision2((float)tempTurns / 100.0f, 100) : "", Images.technology){

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.menus.rebuildInGame_ShareTechnology(CFG.getActiveCivInfoId());
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("ShareTechnology"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.technology, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("ShareTechDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        nPosY += tempElemH;
        if (CFG.ENABLE_NUKES) {
            menuElems.add(new Button_DiplomacyAction_TextRight(Images.nuke, CFG.lang.get("SendNuclearWeapon"), 0, 0, nPosY, menuW - 2, tempElemH, true, "" + CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.iNukes, Images.nuke){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void actionElem(int iID) {
                    Menu_InGame_SendNuke.toCivID = CFG.getActiveCivInfoId();
                    CFG.menus.rebuildInGame_SendNuke();
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SendNuclearWeapon"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.nuke, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("SendNukeDesc")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            nPosY += tempElemH;
        }
        menuElems.add(new Button_DiplomacyAction(Images.diploGift, CFG.lang.get("SendGift"), 0, 0, nPosY, menuW - 2, tempElemH, !CFG.core.getCivsAtWar(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())){

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                }
            }

            @Override
            public void actionElem(int iID) {
                CFG.menus.rebuildInGame_SendGift(CFG.getActiveCivInfoId());
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("SendGift"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploGift, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("GiftDDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        nPosY += tempElemH;
        if (!isRebels) {
            menuElems.add(new Button_DiplomacyAction_XV(Images.diploVassal, CFG.lang.get("AskToBecomeAVassal"), 0, 0, nPosY, menuW - 2, tempElemH, true, CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_BecomeVassal(CFG.getActiveCivInfoId());
                }

                @Override
                public boolean getIsClickable() {
                    return super.getIsClickable() && CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AskToBecomeAVassal"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploVassal, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv() != CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
                        nData.add(new ME_Hover_2Type_Space());
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Lord") + ": "));
                        nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv()).getCivName(), CFG.COLOR_HOVER_TITLE));
                        nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv(), CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.diploLord, CFG.PADD, 0));
                        nData.add(new ME_Hover_2Type_Image_Big(Images.iconFalse, CFG.PADD, 0));
                        nElements.add(new MEHover_2E(nData));
                        nData.clear();
                    }
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("BecomeAVassalOfAnotherCivilization")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            menuElems.add(new Button_DiplomacyAction_TextRight(Images.diploVassal, CFG.lang.get("TransferVassal"), 0, 0, nPosY += tempElemH, menuW - 2, tempElemH, true, "" + CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).civGD.iVassalsSize, Images.diploVassal){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void actionElem(int iID) {
                    CFG.menus.rebuildInGame_TransferVassal(CFG.getActiveCivInfoId());
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("TransferVassal"), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploVassal, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("TransferVassalDesc")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Space());
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Relations") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big((GameValues.gvVassal.TRANSFER_VASSAL_RELATION > 0.0f ? "+" : "") + CFG.getPrecision2(GameValues.gvVassal.TRANSFER_VASSAL_RELATION, 100), GameValues.gvVassal.TRANSFER_VASSAL_RELATION > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image_Big(Images.diploRelationsInc, CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }
            });
            nPosY += tempElemH;
        }
        menuElems.add(new Button_DiplomacyAction(Images.editorLeaders, CFG.lang.get("AppointANewLeader"), 0, 0, nPosY, menuW - 2, tempElemH, true){

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                }
            }

            @Override
            public void actionElem(int iID) {
                Menu_InGame_LeaderC.civID = CFG.getActiveCivInfoId();
                CFG.menus.rebuildInGame_LeaderC();
            }

            @Override
            public void actionElemPPM() {
                Menu_InGame_LeaderC.civID = CFG.getActiveCivInfoId();
                Menu_InGame_Civ_Decisions.rebuildLeaderC();
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AppointANewLeader"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.editorLeaders, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("LeaderDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElems.add(new Button_DiplomacyAction_TextRight(Images.frontline, CFG.lang.get("CivilizationTerritoryView"), 0, 0, nPosY += ((MenuElemUI)menuElems.get(menuElems.size() - 1)).getHeightE(), menuW - 2, tempElemH, true, "" + CFG.core.getCiv(CFG.getActiveCivInfoId()).getNumOfProvs(), Images.provinces){

            @Override
            public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (this.menuElemHover != null) {
                    this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                }
            }

            @Override
            public void actionElem(int iID) {
                try {
                    if (CFG.core.getCiv(CFG.getActiveCivInfoId()).getNumOfProvs() > 0) {
                        Menu_InGame_CivilizationView.iCivID = CFG.getActiveCivInfoId();
                        CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_PosX = CFG.map.getMpC().getPX();
                        CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_PosY = CFG.map.getMpC().getPY();
                        CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).fBefore_Scale = CFG.map.getMpS().getCurrSc();
                        CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_ActiveProvince = CFG.core.getActiveProvID();
                        CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
                        CFG.mapModesManager.disableAllViews();
                        CFG.menus.setMenuID(View.eINGAME_CIV_VIEW);
                        if (CFG.FOG_OF_WAR == 2) {
                            CFG.core.enableDrawCivilizationRegions_FogOfWar(Menu_InGame_CivilizationView.iCivID, 0);
                        } else {
                            CFG.core.enableDrawCivilizationRegions(Menu_InGame_CivilizationView.iCivID, 0);
                        }
                        CFG.map.getMpB().updateWorldMap_Shaders();
                        CFG.toastM.addM(CFG.core.getCiv(Menu_InGame_CivilizationView.iCivID).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                        CFG.toastM.setTimeInView(1500);
                    }
                }
                catch (Exception ex) {
                    Menu_InGame_CivilizationView.iCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                }
            }

            @Override
            public void buildElemHover() {
                ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("CivilizationTerritoryView"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image_Big(Images.frontline, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        nPosY += tempElemH;
        if (CFG.SANDBOX_MODE || CFG.SPECTATOR_MODE || Menu_InitGame.EAPWS) {
            menuElems.add(new Button_DiplomacyAction(Images.iconTrue, CFG.lang.get("AddPlayer") + ": " + CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivName(), 0, 0, nPosY, menuW - 2, tempElemH, true){

                @Override
                public void drawMEH2(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                    if (this.menuElemHover != null) {
                        this.menuElemHover.drawAlwaysBelowMEH(oSB, Menu_InGame_Civ_Actions.this.getPosX() + this.getWidthE() + Core.PADDING + iTranslateX, Touch.getMousePosY());
                    }
                }

                @Override
                public void buildElemHover() {
                    ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
                    ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AddPlayer") + ": "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivName(), CFG.COLOR_HOVER_TITLE));
                    nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                    this.menuElemHover = new ME_Hover_v2(nElements);
                }

                @Override
                public void actionElem(int iID) {
                    CFG.setDialogType(DialogType.ADD_PLAYER);
                }
            });
            nPosY += tempElemH;
        }
        int tempMenuH = tempElemH * 8;
        this.initMenu(null, AoCGame.LEFT, IMGManager.getIMG(Images.gameTop).getHeight() + CFG.PADD * 4 + (int)((float)CFG.TEXT_HEIGHT_DEFAULT * 0.6f) + ButtonFlagBig.getButtonH() + CFG.PADD * 4, menuW, tempMenuH, menuElems, false, false);
        this.updateLang();
        for (i = 0; i < this.getMenuElemsSize(); ++i) {
            this.getMenuElem(i).setCurr(i % 2);
        }
        extraPosX = -this.getWidthM();
        try {
            if (Menu_InitGame.ENDA) {
                for (i = 0; i < this.getMenuElemsSize(); ++i) {
                    this.getMenuElem(i).setTextE(i + 1 + ". " + this.getMenuElem(i).getTextE());
                }
            }
        }
        catch (Exception exception) {
            
        }
    }

    @Override
    public void updateLang() {
    }

    @Override
    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (Menu_InGame_Civ.lTime + (long)GameValues.gvInGame.MENUS_ANIMATION_TIME >= System.currentTimeMillis()) {
            if (Menu_InGame_Civ.hideAnimation) {
                extraPosX = -((int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - Menu_InGame_Civ.lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME)));
                iTranslateX += extraPosX;
            } else {
                extraPosX = -this.getWidthM() + (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - Menu_InGame_Civ.lTime) / (float)GameValues.gvInGame.MENUS_ANIMATION_TIME));
                iTranslateX += extraPosX;
            }
        } else {
            if (Menu_InGame_Civ.hideAnimation) {
                super.setVisibleM(false);
                extraPosX = 0;
                return;
            }
            extraPosX = 0;
        }
        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + Core.PADDING, this.getHeightM() + 2, true, false);
        this.beginClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(Color.WHITE);
        this.drawMenuM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        this.endClipM(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM() + 1, this.getWidthM() - 2, 1);
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4f));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.line32Off1).getHeight() + 1 + this.getHeightM(), this.getWidthM() - 2, 1);
        oSB.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + 2 + this.getHeightM(), this.getWidthM(), 1);
        oSB.setColor(Color.WHITE);
        if (AoCGame.LEFT != 0) {
            oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
            IMGManager.getIMG(Images.pix255).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightM() + 2, true, false);
            oSB.setColor(Color.WHITE);
        }
    }

    @Override
    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (sliderMenuIsActive) {
            super.drawScrollPos(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        }
    }

    public ME_Hover_v2 getHoverDeclareWar() {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        if (GameCalendar.TURNID <= CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS) {
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AWarCantBeDeclaredInFirstXTurns", CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS) + ".", CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, 0));
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        } else if (CFG.core.getCivTruce(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId()) > 0) {
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("WeHaveATruceUntil") + ": ", CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Text_Big(GameCalendar.getDate_ByTurnID(GameCalendar.TURNID + CFG.core.getCivTruce(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId()))));
            nData.add(new ME_Hover_2Type_Text_Big(" [" + CFG.lang.get("TurnsX", CFG.core.getCivTruce(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())) + "]", CFG.COLOR_TEXT_GRAY_NS_HOVER));
            nData.add(new ME_Hover_2Type_Image_Big(Images.diploTruce, CFG.PADD, 0));
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        } else if (!CFG.core.canDeclareWar_TribalColonize_NeedsToBorder(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), CFG.getActiveCivInfoId())) {
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("YouMustBorderWithCivilization"), CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, 0));
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Space());
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Flag(CFG.getActiveCivInfoId()));
            nData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivName(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Government") + ": "));
            nData.add(new ME_Hover_2Type_Text(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.getActiveCivInfoId()).getIdeology()).getName(), CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(CFG.getActiveCivInfoId()).getIdeology()).getColor()));
            nData.add(new ME_Hover_2Type_Ideology(CFG.core.getCiv(CFG.getActiveCivInfoId()).getIdeology(), CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        } else {
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("DeclareWarOn") + ": ", CFG.COLOR_HOVER_TITLE));
            nData.add(new ME_Hover_2Type_Flag_Big(CFG.getActiveCivInfoId(), 0, CFG.PADD));
            nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCivName()));
            nData.add(new ME_Hover_2Type_Image_Big(Images.diploWar, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }
        try {
            ArrayList<Integer> lAlliesDefender = new ArrayList<Integer>();
            int iOnCivID = CFG.getActiveCivInfoId();
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (i == iOnCivID || i == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getCiv(i).getNumOfProvs() <= 0 || CFG.core.getCiv(i).getPuppetOfCiv() == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getPuppetOfCiv() == i) continue;
                if (CFG.core.getCiv(i).getPuppetOfCiv() == iOnCivID) {
                    lAlliesDefender.add(i);
                    continue;
                }
                if (i == CFG.core.getCiv(iOnCivID).getPuppetOfCiv()) {
                    lAlliesDefender.add(i);
                    continue;
                }
                if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance() > 0 && CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getAlliance() == CFG.core.getCiv(i).getAlliance()) continue;
                if (CFG.core.getCiv(iOnCivID).getAlliance() > 0 && CFG.core.getCiv(iOnCivID).getAlliance() == CFG.core.getCiv(i).getAlliance()) {
                    lAlliesDefender.add(i);
                    continue;
                }
                if (CFG.core.getDefensivePact(iOnCivID, i) > 0) {
                    lAlliesDefender.add(i);
                    continue;
                }
                if (CFG.core.getGuarantee(i, iOnCivID) <= 0) continue;
                lAlliesDefender.add(i);
            }
            if (!lAlliesDefender.isEmpty()) {
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                ArrayList<Integer> sorted = new ArrayList<Integer>();
                while (!lAlliesDefender.isEmpty()) {
                    int bestID = 0;
                    for (int i = 0; i < lAlliesDefender.size(); ++i) {
                        if (CFG.core.getCiv((Integer)lAlliesDefender.get(bestID)).getNumOfProvs() >= CFG.core.getCiv((Integer)lAlliesDefender.get(i)).getNumOfProvs()) continue;
                        bestID = i;
                    }
                    sorted.add((Integer)lAlliesDefender.get(bestID));
                    lAlliesDefender.remove(bestID);
                }
                nData.add(new ME_Hover_2Type_Image_Big(Images.diploAlliance, 0, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Allies") + ": "));
                nData.add(new ME_Hover_2Type_Text_Big("" + sorted.size(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                for (int added = 0; added < sorted.size() && added < GameValues.gvInGame.DIPLOMACY_DECLARE_WAR_BUTTON_HOVER_CIVS_LIMIT; ++added) {
                    nData.add(new ME_Hover_2Type_Flag_Big((Integer)sorted.get(added), 0, CFG.PADD));
                    nData.add(new ME_Hover_2Type_Text_Big("" + (added + 1) + ". "));
                    nData.add(new ME_Hover_2Type_Text_Big(CFG.core.getCiv((Integer)sorted.get(added)).getCivName()));
                    nData.add(new ME_Hover_2Type_Text_Big(" #" + CFG.core.getCiv((Integer)sorted.get(added)).getRankPos(), CFG.COLOR_NEUTRAL));
                    nData.add(new ME_Hover_2Type_Image_Big(CFG.getCivilizationRanking_IMG_STAR_CIVID((Integer)sorted.get(added)), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return new ME_Hover_v2(nElements);
    }

    @Override
    public void onHovered() {
        CFG.menus.setOrderOfMenu_InGame_CivInfo();
    }

    @Override
    public void actionEL(int iID) {
        if (CFG.gameAction.getActiveTurnStateID() != GameAction.TurnStates.INPUT_ORDERS) {
            return;
        }
        this.getMenuElem(iID).actionElem(iID);
        if (RTS.isEnabled() && !RTS.PAUSE) {
            RTS.updateTimePast_AfterAction(0.3f);
        }
    }

    @Override
    public void setVisibleM(boolean visible) {
        if (visible) {
            super.setVisibleM(visible);
        }
    }

    @Override
    public void actionCloseMenu() {
        super.setVisibleM(false);
    }

    @Override
    public void setPosY(int iPosY) {
        super.setPosY(iPosY);
        this.setHeight(this.iMaxSliderPosY);
        if (this.getPosY() + this.getHeightM() > CFG.GAMEHEIGHT) {
            this.setHeight(Math.max(CFG.GAMEHEIGHT - this.getPosY(), CFG.BUTTON_H / 2));
        }
        int tempElemH = Menu_InGame_Civ_Actions.getButtonH();
        this.setHeight(Math.max(CFG.GAMEHEIGHT - this.getPosY() - CFG.PADD, Math.min(this.getHeightM(), tempElemH * (CFG.getIsDesktop() ? 8 : 6))));
        this.updateMenuElements_IsInView();
    }
}

