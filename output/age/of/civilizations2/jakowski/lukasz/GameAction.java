
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle.AIPlaystyle;
import age.of.civilizations2.jakowski.lukasz.Actions;
import age.of.civilizations2.jakowski.lukasz.Alliance;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.CivInvest;
import age.of.civilizations2.jakowski.lukasz.CivTask;
import age.of.civilizations2.jakowski.lukasz.Civilization;
import age.of.civilizations2.jakowski.lukasz.Civilization_Region;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Diplomacy.Plunder;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.GameValues.RankingSettings;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Distance;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Terrain;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.Menus.Alliance.Menu_InGame_Alliance;
import age.of.civilizations2.jakowski.lukasz.Menus.Info.Menu_InGame_ProvInfo;
import age.of.civilizations2.jakowski.lukasz.Menus.Info.Menu_InGame_ProvInfoSmall;
import age.of.civilizations2.jakowski.lukasz.Menus.Messages.Menu_InGame_Messages;
import age.of.civilizations2.jakowski.lukasz.Menus.Stats.Menu_InGame_CensusOfProvince;
import age.of.civilizations2.jakowski.lukasz.Menus.Turn.Menu_NextPlayerTurn;
import age.of.civilizations2.jakowski.lukasz.Menus.Wars.Details.Menu_InGame_WarDetails;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_2;
import age.of.civilizations2.jakowski.lukasz.Messages.Info.HRE.Message_HRE_ElectionsInNextTurn;
import age.of.civilizations2.jakowski.lukasz.Messages.Info.HRE.Message_HRE_Elections_NewEmperor;
import age.of.civilizations2.jakowski.lukasz.Messages.Province.Message_Revolt;
import age.of.civilizations2.jakowski.lukasz.MoveUnitsB.MoveUnits;
import age.of.civilizations2.jakowski.lukasz.MoveUnitsB.MoveUnits_TurnData;
import age.of.civilizations2.jakowski.lukasz.NewTurn;
import age.of.civilizations2.jakowski.lukasz.Parallel;
import age.of.civilizations2.jakowski.lukasz.Player;
import age.of.civilizations2.jakowski.lukasz.Province;
import age.of.civilizations2.jakowski.lukasz.Province_Army;
import age.of.civilizations2.jakowski.lukasz.Province_Population;
import age.of.civilizations2.jakowski.lukasz.RTS;
import age.of.civilizations2.jakowski.lukasz.Render;
import age.of.civilizations2.jakowski.lukasz.Report_Data;
import age.of.civilizations2.jakowski.lukasz.SFXManager;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;
import age.of.civilizations2.jakowski.lukasz.TechManager;
import age.of.civilizations2.jakowski.lukasz.TurnThreads.Turn_ThreadActions;
import age.of.civilizations2.jakowski.lukasz.TurnThreads.Turn_ThreadNewTurn;
import age.of.civilizations2.jakowski.lukasz.VictoryManager;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;
import java.util.List;

public class GameAction {
    private NewTurn newTurnT;
    private Actions actions;
    public int eRTO_START = 0;
    public int eRTO_START2 = 0;
    public int eRTO_START3 = 0;
    public static boolean ELF = false;
    public int diceAggressors;
    public int diceDefenders;
    public int diceAggressorsCivID;
    public int diceDefendersCivID;
    public boolean SHOW_REPORT = false;
    public boolean SAVE_REPORT = false;
    public List<Report_Data> battleReports = new ArrayList<Report_Data>();
    public Report_Data battleReportSave = new Report_Data();
    public TurnStates activeTurnAction = TurnStates.INPUT_ORDERS;
    private MoveUnits_TurnData currentMoveUnits = null;
    private int iPlayerAttack_ShowArmyInProvinceID = -1;
    public static boolean SKIP_ALL_COMBAT_MOVEMENT_ONCE = false;
    public boolean updatePosOfMap_NewTurn = false;
    public static boolean gameEnded = false;
    public Turn_ThreadNewTurn turnThreadNewTurn;
    public Turn_ThreadActions turnThreadActions;

    private final void updatePlayerData() {
        Player player = CFG.core.getPlayer(CFG.PLAYER_TURN_ID);
        player.iBefore_PosX = CFG.map.getMpC().getPX();
        player.iBefore_PosY = CFG.map.getMpC().getPY();
        player.fBefore_Scale = CFG.map.getMpS().getCurrSc();
        player.iACTIVE_VIEW_MODE = CFG.mapModesManager.getActiveMapModeID();
        player.visible_CivInfo = CFG.menus.getVisible_InGame_CivInfo() ? CFG.getActiveCivInfoId() : -1;
        player.visible_Outliner = CFG.menus.getVisible_Menu_InGame_Outliner();
        player.visible_CensusOfProvince = CFG.menus.getVisibleInGame_CensusOfProvince() ? Menu_InGame_CensusOfProvince.PROVINCE_ID : -1;
        player.visible_Wars = CFG.menus.getVisibleInGame_Wars();
        player.visible_WarStats = CFG.menus.getVisibleInGame_WarDetails() ? Menu_InGame_WarDetails.WAR_ID : -1;
        player.visible_Alliances = CFG.menus.getVisibleInGame_MilitaryAlliances();
        player.visible_Alliance = CFG.menus.getVisible_InGame_Alliance() ? Menu_InGame_Alliance.ALLIANCE_ID : -1;
        player.visible_Rank = CFG.menus.getVisibleInGame_Rank();
        player.visible_ConqueredProvinces = CFG.menus.getVisibleInGame_ConquredProvinces();
        player.visible_VictoryConditions = CFG.menus.getVisibleInGame_VictoryConditions();
        player.visible_BuildingsConstructed = CFG.menus.getVisibleInGame_BuildingsConstructed();
        player.visible_Stats = CFG.menus.getVisibleInGame_Stats();
        player.visible_RecruitedArmy = CFG.menus.getVisibleInGame_RecruitedArmy();
        player.visible_Tribute = CFG.menus.getVisibleInGame_Tribute();
        player.visible_Technology = CFG.menus.getVisibleInGame_Technology();
        player.visible_Army = CFG.menus.getVisibleInGame_Army();
        player.visible_WorldPop = CFG.menus.getVisibleInGame_WorldPopulation();
        player.visible_MapModes = CFG.menus.getVisible_InGame_MapModes();
        player.visible_History = CFG.menus.getVisibleInGame_History();
        player.visible_BuildingsMore = CFG.menus.getInGame_ProvincemMore_Visible();
        player.visible_HRE = CFG.menus.getVisibleInGameHRE();
        player.visible_Budget = CFG.menus.getVisible_InGame_Budget();
        this.hideExtraViews();
    }

    public final void hideExtraViews() {
        try {
            CFG.menus.setVisible_InGame_CivInfo(false);
            CFG.menus.setVisible_InGame_FlagAction(false);
            CFG.menus.setVisibleInGame_WarDetails(false);
            CFG.menus.setVisibleInGame_Wars(false);
            CFG.menus.setVisibleInGame_CensusOfProvince(false);
            CFG.menus.setVisibleInGame_Rank(false);
            CFG.menus.setVisibleInGame_MilitaryAlliances(false);
            CFG.menus.setVisible_InGame_Alliance(false);
            CFG.menus.setVisible_Menu_InGame_Outliner(false);
            CFG.menus.setVisibleInGame_WorldPopulation(false);
            CFG.menus.setVisible_InGame_MapModes(false);
            CFG.menus.setVisibleInGame_Playlist(false);
            CFG.menus.setVisibleInGame_WarPreparations(false);
            CFG.menus.setVisibleInGame_ConquredProvinces(false);
            CFG.menus.setVisibleInGame_VictoryConditions(false);
            CFG.menus.setVisibleInGame_BuildingsConstructed(false);
            CFG.menus.setVisibleInGame_Stats(false);
            CFG.menus.setVisibleInGame_RecruitedArmy(false);
            CFG.menus.setVisibleInGame_Tribute(false);
            CFG.menus.setVisibleInGame_Technology(false);
            CFG.menus.setVisibleInGame_Wonders(false);
            CFG.menus.setVisibleInGame_SendMessage(false);
            CFG.menus.setVisibleInGame_Plunder(false);
            CFG.menus.setVisibleInGame_MessageView(false);
            CFG.menus.setVisible_Menu_InGame_War(false);
            CFG.menus.setVisible_Menu_InGame_CapitalMoved(false);
            CFG.menus.setVisible_Menu_InGame_VassalReleased(false);
            CFG.menus.setVisible_Menu_InGame_CityHaveBeenFounded(false);
            CFG.menus.setVisible_Menu_InGame_AllianceInfo(false);
            CFG.menus.setVisible_InGame_Budget(false);
            CFG.menus.setVisible_Menu_InGame_CurrentWars(false);
            CFG.menus.setVisible_InGame_HRE(false);
            CFG.menus.setVisible_InGame_HRE_VoteFor(false);
            CFG.menus.setVisible_Menu_InGame_Graph(false);
            CFG.menus.setVisibleInGame_History(false);
        }
        catch (Exception exception) {
            
        }
    }

    private final void inputOrders() {
        this.updatePlayerData();
        try {
            if (CFG.PLAYER_TURN_ID == CFG.core.getPlayersSize() - 1) {
                this.endOfInputOrders();
            } else if (CFG.core.getCiv(CFG.core.getPlayer(++CFG.PLAYER_TURN_ID).getCivId()).getNumOfProvs() == 0 && this.showDefeatView(CFG.PLAYER_TURN_ID)) {
                this.inputOrders();
            } else {
                this.updatePosOfMap_NewTurn = true;
                this.loadActivePlayerData();
                if (CFG.FOG_OF_WAR == 2) {
                    CFG.map.getMpB().disposeMinimapOfCivilizations();
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            this.endOfInputOrders();
        }
    }

    public final String getSpawnRebels_CivRebelsTag(int nCivID) {
        if (CFG.core.getCiv(nCivID).getCivTag().lastIndexOf(95) > 0) {
            return CFG.core.getCiv(nCivID).getCivTag().substring(0, CFG.core.getCiv(nCivID).getCivTag().lastIndexOf(95) + 2);
        }
        return CFG.core.getCiv(nCivID).getCivTag();
    }

    public final int getSpawnRebels_CivRebelsTag_GetID(int nCivID) {
        if (CFG.core.getCiv(nCivID).getCivTag().lastIndexOf(95) > 0) {
            try {
                return Integer.parseInt(CFG.core.getCiv(nCivID).getCivTag().substring(CFG.core.getCiv(nCivID).getCivTag().lastIndexOf(95) + 2, CFG.core.getCiv(nCivID).getCivTag().length()));
            }
            catch (Exception exception) {
                
            }
        }
        return 0;
    }

    public final void updateMetCivilization(int nProvinceID) {
        try {
            if (CFG.FOG_OF_WAR == 2) {
                for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                    if (!CFG.core.getPlayer(i).getMetProv(nProvinceID)) continue;
                    CFG.core.getPlayer(i).setMetCiv(CFG.core.getProv(nProvinceID).getCivId(), true);
                }
            }
        }
        catch (Exception exception) {
            
        }
    }

    protected final void updateInGame_ProvinceInfoSmallClassic() {
        block23: {
            try {
                int n = CFG.ACTIVE_PROVINCE_INFO = CFG.chosenProvinceID >= 0 ? CFG.chosenProvinceID : CFG.core.getActiveProvID();
                if (CFG.ACTIVE_PROVINCE_INFO < 0) {
                    Menu_InGame_ProvInfoSmall.iMaxWidth = 0;
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(3).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(4).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(5).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(6).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(7).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(8).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(9).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(10).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(11).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(12).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(13).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(14).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(15).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(16).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(17).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(18).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(19).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(20).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(21).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(22).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(23).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(24).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(25).setVisibleE(false);
                    return;
                }
                if (CFG.FOG_OF_WAR == 2 && !CFG.getMetProv(CFG.ACTIVE_PROVINCE_INFO)) {
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setTextE(CFG.lang.get("Undiscovered"));
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setCurr(-3);
                    CFG.menus.getInGameProvInfo().getMenuElem(6).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(3).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(8).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(4).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(5).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(7).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(9).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(10).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(11).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(12).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(13).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(14).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(15).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(16).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(17).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(18).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(19).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(20).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(21).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(22).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(23).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(24).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(25).setVisibleE(false);
                    break block23;
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getWastelandLvl() >= 0) {
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setTextE(CFG.lang.get("Wasteland"));
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setCurr(-2);
                    CFG.menus.getInGameProvInfo().getMenuElem(6).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(3).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(8).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(4).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(5).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(7).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(9).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(10).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(11).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(12).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(13).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(14).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(15).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(16).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(17).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(18).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(19).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(20).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(21).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(22).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(23).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(24).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(24).setTextE("" + (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighProvincesSize() + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighSeaProvincesSize()));
                    CFG.menus.getInGameProvInfo().getMenuElem(25).setVisibleE(false);
                    break block23;
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getSeaProv()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setTextE(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName().length() > 0 ? CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName() : CFG.lang.get("Sea"));
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setCurr(-1);
                    CFG.menus.getInGameProvInfo().getMenuElem(6).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(3).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(8).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(4).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(5).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(7).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(9).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(10).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(11).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(12).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(13).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(14).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(15).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(16).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(17).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(18).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(19).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(20).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(21).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(22).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(23).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(24).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(24).setTextE("" + (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighProvincesSize() + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighSeaProvincesSize()));
                    CFG.menus.getInGameProvInfo().getMenuElem(25).setVisibleE(false);
                    break block23;
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName().length() > 0) {
                    CFG.core.updateProvNameWidth(CFG.ACTIVE_PROVINCE_INFO);
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setTextE(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName());
                } else {
                    CFG.core.updateProvNameWidth("Fokus");
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setTextE(CFG.lang.get("Fokus"));
                }
                CFG.menus.getInGameProvInfo().getMenuElem(2).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(2).setTextE(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).getCivName());
                CFG.menus.getInGameProvInfo().getMenuElem(2).setCurr(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId());
                CFG.menus.getInGameProvInfo().getMenuElem(3).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(3).setCurr(CFG.ACTIVE_PROVINCE_INFO);
                CFG.menus.getInGameProvInfo().getMenuElem(25).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(25).setTextE("" + CFG.core.getProvinceValue(CFG.ACTIVE_PROVINCE_INFO));
                CFG.menus.getInGameProvInfo().getMenuElem(4).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(4).setCurr(CFG.ACTIVE_PROVINCE_INFO);
                CFG.menus.getInGameProvInfo().getMenuElem(4).setTextE(CFG.getNumber_SHORT(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getPop().getPops()));
                CFG.menus.updateInGame_ProvinceInfoGraph(CFG.ACTIVE_PROVINCE_INFO);
                CFG.menus.getInGameProvInfo().getMenuElem(6).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(9).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(9).setCurr((int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getGrowthRate_Pop_WithFarm_WithTerrain() * 100.0f));
                CFG.menus.getInGameProvInfo().getMenuElem(9).setTextE("" + (int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getGrowthRate_Pop_WithFarm_WithTerrain() * 100.0f) + "%");
                CFG.menus.getInGameProvInfo().getMenuElem(7).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(7).setTextE(CFG.getNumber_SHORT(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getEco()));
                CFG.menus.getInGameProvInfo().getMenuElem(10).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(10).setCurr((int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getDeveLvl() * 100.0f));
                CFG.menus.getInGameProvInfo().getMenuElem(10).setTextE("" + (float)((int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getDeveLvl() * 100.0f)) / 100.0f);
                CFG.menus.getInGameProvInfo().getMenuElem(11).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(11).setCurr((int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getHappi() * 100.0f));
                CFG.menus.getInGameProvInfo().getMenuElem(11).setTextE("" + (int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getHappi() * 100.0f) + "%");
                CFG.menus.getInGameProvInfo().getMenuElem(12).setVisibleE(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isFestivalOrganized(CFG.ACTIVE_PROVINCE_INFO));
                if (CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(12).setTextE("" + CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isFestivalOrganized_TurnsLeft(CFG.ACTIVE_PROVINCE_INFO));
                }
                if (CFG.menus.getVisibleInGame_CensusOfProvince()) {
                    CFG.menus.rebuildInGame_CensusOfProvince(CFG.ACTIVE_PROVINCE_INFO);
                }
                CFG.menus.getInGameProvInfo().getMenuElem(13).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(13).setCurr((int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getProviStability() * 100.0f));
                CFG.menus.getInGameProvInfo().getMenuElem(13).setTextE("" + (int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getProviStability() * 100.0f) + "%");
                CFG.menus.getInGameProvInfo().getMenuElem(14).setVisibleE(true);
                Menu_InGame_ProvInfoSmall.updateBuildingsList(CFG.ACTIVE_PROVINCE_INFO);
                CFG.menus.getInGameProvInfo().getMenuElem(15).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(15).setCurr((int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getRevRisk() * 100.0f));
                CFG.menus.getInGameProvInfo().getMenuElem(15).setTextE("" + (int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getRevRisk() * 100.0f) + "%");
                CFG.menus.getInGameProvInfo().getMenuElem(16).setVisibleE(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isAssimilateOrganized(CFG.ACTIVE_PROVINCE_INFO));
                if (CFG.menus.getInGameProvInfo().getMenuElem(16).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(16).setTextE("" + CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isAssimilateOrganized_TurnsLeft(CFG.ACTIVE_PROVINCE_INFO));
                }
                CFG.menus.getInGameProvInfo().getMenuElem(17).setVisibleE(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isInvestOrganized(CFG.ACTIVE_PROVINCE_INFO));
                if (CFG.menus.getInGameProvInfo().getMenuElem(17).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(17).setTextE("" + CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isInvestOrganized_TurnsLeft(CFG.ACTIVE_PROVINCE_INFO));
                }
                CFG.menus.getInGameProvInfo().getMenuElem(18).setVisibleE(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isInvestOrganized_Devel(CFG.ACTIVE_PROVINCE_INFO));
                if (CFG.menus.getInGameProvInfo().getMenuElem(18).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(18).setTextE("" + CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isInvestOrganized_TurnsLeft_Devel(CFG.ACTIVE_PROVINCE_INFO));
                }
                CFG.menus.getInGameProvInfo().getMenuElem(19).setVisibleE(!CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getIsSupplied() && CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getIsNotSuppliedForXTurns() > 0);
                if (CFG.menus.getInGameProvInfo().getMenuElem(19).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(19).setTextE("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getIsNotSuppliedForXTurns());
                }
                if (CFG.SPECTATOR_MODE || CFG.SANDBOX_MODE || CFG.FOG_OF_WAR == 0 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getFog(CFG.ACTIVE_PROVINCE_INFO)) {
                    CFG.menus.getInGameProvInfo().getMenuElem(20).setVisibleE(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getDefensivePosition() > 0);
                    if (CFG.menus.getInGameProvInfo().getMenuElem(20).getVisibleE()) {
                        CFG.menus.getInGameProvInfo().getMenuElem(20).setTextE("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getDefensivePosition());
                    }
                } else {
                    CFG.menus.getInGameProvInfo().getMenuElem(20).setVisibleE(false);
                }
                CFG.menus.getInGameProvInfo().getMenuElem(21).setVisibleE(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.provincePlague != null);
                if (CFG.menus.getInGameProvInfo().getMenuElem(21).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(21).setTextE("" + CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.provincePlague.iDeaths);
                }
                CFG.menus.getInGameProvInfo().getMenuElem(22).setVisibleE(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iNewColonyBonus > 0);
                if (CFG.menus.getInGameProvInfo().getMenuElem(22).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(22).setTextE("" + CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iNewColonyBonus);
                }
                CFG.menus.getInGameProvInfo().getMenuElem(23).setVisibleE(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iSupportRebelsSize > 0);
                if (CFG.menus.getInGameProvInfo().getMenuElem(23).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(23).setCurr(CFG.ACTIVE_PROVINCE_INFO);
                }
                CFG.menus.getInGameProvInfo().getMenuElem(24).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(24).setTextE("" + (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighProvincesSize() + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighSeaProvincesSize()));
                try {
                    CFG.menus.getInGameProvInfo().getMenuElem(8).setTextE(CFG.religionManager.getReligion(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).getReligionID()).getName());
                    CFG.menus.getInGameProvInfo().getMenuElem(8).setCurr(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).getReligionID());
                    CFG.menus.getInGameProvInfo().getMenuElem(8).setVisibleE(true);
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                if (!CFG.SPECTATOR_MODE && GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES && CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId() == 0) {
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(4).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(7).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(8).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(9).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(10).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(11).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(12).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(13).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(14).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(15).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(16).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(17).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(18).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(19).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(20).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(21).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(22).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(23).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(25).setVisibleE(false);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        this.updateInGame_ProvinceInfo_PosXSmallClassic();
    }

    public final void updateIsSupplied() {
        int i2;
        try {
            for (i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                Civilization civI = CFG.core.getCiv(i2);
                if (civI.getNumOfProvs() <= 0) continue;
                for (int j = 0; j < civI.getCivRegionsSize(); ++j) {
                    Civilization_Region civRegionJ = civI.getCivRegion(j);
                    if (civRegionJ.setIsSupplied(civRegionJ.getSeaAccess() || civRegionJ.getHaveNotOccupiedProvince())) continue;
                    try {
                        block6: for (int k = 0; k < civRegionJ.getProvincesSize(); ++k) {
                            Province provinceK = CFG.core.getProv(civRegionJ.getProvince(k));
                            for (int o = 0; o < provinceK.getNeighProvincesSize(); ++o) {
                                Province provinceO = CFG.core.getProv(provinceK.getNeighProvinces(o));
                                if (provinceO.getWastelandLvl() >= 0) continue;
                                if (provinceO.getCivId() == 0) {
                                    civRegionJ.setIsSupplied(true);
                                    k = civRegionJ.getProvincesSize();
                                    continue block6;
                                }
                                if (provinceO.getCivId() == i2 || !CFG.core.getCiv(provinceO.getCivId()).getCivRegion(provinceO.getCivRegionID()).getSeaAccess() && !CFG.core.getCiv(provinceO.getCivId()).getCivRegion(provinceO.getCivRegionID()).getHaveNotOccupiedProvince() || CFG.core.getCiv(provinceO.getCivId()).getPuppetOfCiv() != i2 && CFG.core.getCiv(i2).getPuppetOfCiv() != provinceO.getCivId() && (CFG.core.getCiv(i2).getAlliance() <= 0 || CFG.core.getCiv(i2).getAlliance() != CFG.core.getCiv(provinceO.getCivId()).getAlliance()) && CFG.core.getMilitaryAccess(i2, provinceO.getCivId()) <= 0) continue;
                                civRegionJ.setIsSupplied(true);
                                k = civRegionJ.getProvincesSize();
                                continue block6;
                            }
                        }
                        continue;
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
            }
        }
        catch (Exception ex2) {
            
        }
        for (i2 = 0; i2 < CFG.core.getProvinSize(); ++i2) {
            Province province = CFG.core.getProv(i2);
            if (province.getSeaProv() || province.getWastelandLvl() >= 0 || province.getCivId() <= 0) continue;
            province.updateIsNotSuppliedForXTurns();
            province.updateDefensivePosition();
        }
    }

    public final void updateIsSupplied_Provinces_ByBatch(int startProvince, int endProvince) {
        for (int i2 = startProvince; i2 < endProvince; ++i2) {
            Province province = CFG.core.getProv(i2);
            if (province.getSeaProv() || province.getWastelandLvl() >= 0 || province.getCivId() <= 0) continue;
            province.updateIsNotSuppliedForXTurns();
            province.updateDefensivePosition();
        }
    }

    public final void buildFogOfWar(int nPlayerID) {
        try {
            int i;
            for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                CFG.core.getPlayer(nPlayerID).setFogOfWar(i, CFG.SANDBOX_MODE);
            }
            if (CFG.SANDBOX_MODE) {
                return;
            }
            this.buildFogOfWar_CivID(nPlayerID, CFG.core.getPlayer(nPlayerID).getCivId());
            if (CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getAlliance() > 0) {
                for (i = 0; i < CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getAlliance()).getCivilizationsSize(); ++i) {
                    if (CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getAlliance()).getCivilization(i) == CFG.core.getPlayer(nPlayerID).getCivId()) continue;
                    this.buildFogOfWar_CivID(nPlayerID, CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getAlliance()).getCivilization(i));
                }
            }
            for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (i == CFG.core.getPlayer(nPlayerID).getCivId() || CFG.core.getCiv(i).getPuppetOfCiv() != CFG.core.getPlayer(nPlayerID).getCivId()) continue;
                this.buildFogOfWar_CivID(nPlayerID, i);
            }
            for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (i == CFG.core.getPlayer(nPlayerID).getCivId() || CFG.core.getCiv(CFG.core.getPlayer(nPlayerID).getCivId()).getPuppetOfCiv() != i) continue;
                this.buildFogOfWar_CivID(nPlayerID, i);
            }
        }
        catch (IndexOutOfBoundsException ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void IEU() {
        try {
            int iGRR;
            int ORM = 0;
            int EOPX = 0;
            int CORX = 0;
            for (int i = 0; i < Core.AMRCT.size(); ++i) {
                ORM += Core.AMRCT.get((int)i).ILM;
                CORX += Core.AMRCT.get((int)i).ILM * CFG.gCARR(Core.AMRCT.get((int)i).OBC);
            }
            EOPX = ORM;
            float IPXCR = (float)CORX / (float)ORM;
            ORM = (int)((float)CFG.core.getCiv(CFG.core.getProv(Core.AMRCT.get((int)0).OBC).getCivId()).getGold() / IPXCR);
            if (ORM < 0) {
                ORM = 0;
            } else if (ORM > EOPX) {
                ORM = EOPX;
            }
            if (Core.AMRCT.size() == 1 && (iGRR = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isRAIP(Core.AMRCT.get((int)0).OBC)) >= 0) {
                if ((ORM += CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getRecruitArmy(iGRR).getArmy()) > this.gMARY(Core.AMRCT.get((int)0).OBC)) {
                    ORM = this.gMARY(Core.AMRCT.get((int)0).OBC);
                }
                CFG.menus.getInGame_ProvRecruitSlider().setMax(ORM);
                CFG.menus.getInGame_ProvRecruitSlider().setCurr(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getRecruitArmy(iGRR).getArmy());
                return;
            }
            CFG.menus.getInGame_ProvRecruitSlider().setMax(ORM);
            CFG.menus.getInGame_ProvRecruitSlider().setCurr((int)((float)ORM * GameValues.gvArmyRecruit.RECRUIT_ARMY_DEFAULT_SLIDER_PERC_OF_MAX));
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.menus.getInGame_ProvRecruitSlider().setMax(0);
            CFG.menus.getInGame_ProvRecruitSlider().setCurr(0);
        }
    }

    public final boolean moveCapital(int nCivID, int toProvinceID) {
        if (nCivID < 1 || toProvinceID < 0) {
            return false;
        }
        if (!this.moveCapital_CanMove(nCivID)) {
            return false;
        }
        if (!(CFG.core.getCiv(nCivID).getCapitalProvID() >= 0 && CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getCivId() != nCivID && CFG.core.getCiv(nCivID).isAtWarC() && CFG.core.getCivsAtWar(CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getCivId(), nCivID) || CFG.core.getProv(toProvinceID).getTrueOwnerOfProv() != nCivID || CFG.core.getProv(toProvinceID).getCivId() != nCivID || CFG.core.getCiv(nCivID).getCapitalProvID() == toProvinceID || CFG.core.getCiv(nCivID).getGold() < (long)this.moveCapital_Cost(nCivID))) {
            CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)this.moveCapital_Cost(nCivID));
            CFG.core.getCiv(nCivID).setCapitalMoved_LastTurnID(GameCalendar.TURNID);
            int tempOld = CFG.core.getCiv(nCivID).getCapitalProvID();
            CFG.core.getCiv(nCivID).setCapitalProvID(toProvinceID);
            CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).setIsCapital(false);
            if (tempOld >= 0) {
                CFG.core.getProv(tempOld).setIsCapital(false);
                CFG.core.getProv(tempOld).updateDrawArmyInProv();
                CFG.core.getProv(tempOld).setHappi(CFG.core.getProv(tempOld).getHappi() - CFG.core.getProv(tempOld).getHappi() * GameValues.gvMoveCapital.MOVE_CAPITAL_HAPPINESS_CHANGE_OLD - GameValues.gvMoveCapital.MOVE_CAPITAL_HAPPINESS_CHANGE_OLD);
                try {
                    CFG.core.getProv(tempOld).getCit(0).setCityLevel(CFG.getEditorCityLevel(1));
                }
                catch (Exception exception) {
                    
                }
            }
            CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).setIsCapital(true);
            CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).updateDrawArmyInProv();
            CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).setHappi(CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getHappi() + GameValues.gvMoveCapital.MOVE_CAPITAL_HAPPINESS_CHANGE_NEW);
            try {
                CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getCit(0).setCityLevel(CFG.getEditorCityLevel(0));
            }
            catch (Exception exception) {
                
            }
            CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).setDrawCitiesInProv(true);
            return true;
        }
        return false;
    }

    public final boolean moveCapital_CanMove(int nCivID) {
        if (CFG.core.getCiv(nCivID).getCapitalProvID() < 0 || CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getCivId() != nCivID && (!CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).isOccupied() || !CFG.core.getCivsAtWar(nCivID, CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getCivId()))) {
            return true;
        }
        return CFG.core.getCiv(nCivID).getCapitalMoved_LastTurnID() <= GameCalendar.TURNID - GameValues.gvMoveCapital.MOVE_CAPITAL_LOCK_MOVING_FOR_X_TURNS;
    }

    public final int moveCapital_Cost(int nCivID) {
        if (CFG.core.getCiv(nCivID).getCapitalProvID() < 0 || CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getCivId() != nCivID && (!CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).isOccupied() || !CFG.core.getCivsAtWar(nCivID, CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getCivId()))) {
            return GameValues.gvMoveCapital.MOVE_CAPITAL_COST_WHEN_NO_CAPITAL;
        }
        return (int)(GameValues.gvMoveCapital.MOVE_CAPITAL_COST_GOLD_BASE_VALUE + (float)((int)((float)CFG.core.getGameScenars().getScenario_StartingPopulation() * GameValues.gvMoveCapital.MOVE_CAPITAL_COST_GOLD_STARTING_POPULATION_PERC + (float)CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getPop().getPops() * GameValues.gvMoveCapital.MOVE_CAPITAL_COST_GOLD_PROVINCE_POPULATION_PERC + (CFG.gameUpdate.getProvIncomeTaxation(CFG.core.getCiv(nCivID).getCapitalProvID()) + CFG.gameUpdate.getProvIncomeProduction(CFG.core.getCiv(nCivID).getCapitalProvID())) * (GameValues.gvMoveCapital.MOVE_CAPITAL_INCOME_MULTIPLIER_BASE + GameValues.gvMoveCapital.MOVE_CAPITAL_INCOME_MULTIPLIER_TECH_FACTOR * CFG.core.getCiv(nCivID).getTechLevel()))));
    }

    public final boolean abandonProvince(int nProvinceID, int nCivID) {
        if (CFG.core.getProv(nProvinceID).getCivId() == nCivID && CFG.core.getCiv(nCivID).getCapitalProvID() != nProvinceID && !CFG.core.getProv(nProvinceID).isOccupied() && CFG.core.getCiv(nCivID).getNumOfProvs() > 1) {
            int i;
            for (i = 0; i < CFG.core.getCiv(nCivID).moveUnitsSize(); ++i) {
                if (CFG.core.getCiv(nCivID).getMoveUnits(i).getFromProviID() != nProvinceID) continue;
                CFG.core.getCiv(nCivID).removeMove(i--);
            }
            for (i = 0; i < CFG.core.getCiv(nCivID).getMoveUnitsPlunderSize(); ++i) {
                if (CFG.core.getCiv(nCivID).getMoveUnitsPlunder(i).getFromProvinceID() != nProvinceID) continue;
                CFG.core.getCiv(nCivID).removePlunder(i--);
            }
            for (i = 0; i < CFG.core.getCiv(nCivID).getMigrateSize(); ++i) {
                if (CFG.core.getCiv(nCivID).getMigrateMU(i).getFromProviID() != nProvinceID) continue;
                CFG.core.getCiv(nCivID).removeMigrate(i--);
            }
            for (i = 0; i < CFG.core.getCiv(nCivID).getRecruitArmySize(); ++i) {
                if (CFG.core.getCiv(nCivID).getRecruitArmy(i).getProvinceID() != nProvinceID) continue;
                CFG.core.getCiv(nCivID).removeRecruitArmy(i--);
            }
            for (i = CFG.core.getProv(nProvinceID).getPop().getNatsSize() - 1; i >= 0; --i) {
                CFG.core.getProv(nProvinceID).getPop().setPopulationOfCivID(CFG.core.getProv(nProvinceID).getPop().getCivID(i), (long)((double)CFG.core.getProv(nProvinceID).getPop().getPopulationOfCivID(CFG.core.getProv(nProvinceID).getPop().getCivID(i)) * (0.05 + (double)CFG.oR.nextInt(20) / 100.0)));
            }
            CFG.core.getProv(nProvinceID).setEco((long)((double)CFG.core.getProv(nProvinceID).getEco() * (0.025 + (double)CFG.oR.nextInt(15) / 100.0)));
            CFG.core.getProv(nProvinceID).setDevLvl((int)(CFG.core.getProv(nProvinceID).getDeveLvl() * (0.045f + (float)CFG.oR.nextInt(20) / 100.0f)));
            CFG.core.getProv(nProvinceID).setTrueOwnerOfProv(0);
            CFG.core.getProv(nProvinceID).setCivId(0, false);
            try {
                CFG.core.getProv(nProvinceID).resetArmiesAll(CFG.oR.nextInt((int)Math.max(1, CFG.core.getGameScenars().getScenario_NeutralArmy() / 2)) + CFG.core.getGameScenars().getScenario_NeutralArmy() / 2);
                CFG.core.getProv(nProvinceID).updateDrawArmyInProv();
            }
            catch (Exception exception) {
                
            }
            return true;
        }
        return false;
    }

    public final void accessLost_UpdateArmies(int inCivID, int nCivID) {
        try {
            int i;
            ArrayList<Integer> tempProvincesToMove = new ArrayList<Integer>();
            for (i = 0; i < CFG.core.getCiv(nCivID).getArmyInAnotherProvinceSize(); ++i) {
                if (CFG.core.getProv(CFG.core.getCiv(nCivID).getArmyInAnotherProviP(i)).getCivId() != inCivID) continue;
                tempProvincesToMove.add(CFG.core.getCiv(nCivID).getArmyInAnotherProviP(i));
            }
            for (i = CFG.core.getCiv(nCivID).moveUnitsSize() - 1; i >= 0; --i) {
                if (CFG.core.getProv(CFG.core.getCiv(nCivID).getMoveUnits(i).getFromProviID()).getCivId() != inCivID) continue;
                tempProvincesToMove.add(CFG.core.getCiv(nCivID).getMoveUnits(i).getFromProviID());
                this.moveArmyAction(CFG.core.getCiv(nCivID).getMoveUnits(i).getFromProviID(), CFG.core.getCiv(nCivID).getMoveUnits(i).getToProvID(), 0, nCivID, false, false);
            }
            for (i = 0; i < tempProvincesToMove.size(); ++i) {
                this.accessLost_MoveArmyToClosetsProvince(nCivID, (Integer)tempProvincesToMove.get(i));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void accessLost_MoveArmyToClosetsProvince(int nCivID, int nProvinceID) {
        this.accessLost_MoveArmyToClosetsProvince(nCivID, nProvinceID, CFG.core.getProv(nProvinceID).getArmyCivID1(nCivID));
    }

    public final void accessLost_MoveArmyToClosetsProvince(int nCivID, int nProvinceID, long nArmy) {
        try {
            if (nArmy > 0) {
                if (CFG.core.getCiv(nCivID).getNumOfProvs() > 0) {
                    try {
                        int toProvinceID = CFG.core.getCiv(nCivID).getProvID(0);
                        float fMinDistance = Distance.getDistanceFromAToB_PercOfMax(nProvinceID, toProvinceID);
                        float tempDistance = 0.0f;
                        for (int i = 1; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
                            tempDistance = Distance.getDistanceFromAToB_PercOfMax(nProvinceID, CFG.core.getCiv(nCivID).getProvID(i));
                            if (!(fMinDistance > tempDistance)) continue;
                            toProvinceID = CFG.core.getCiv(nCivID).getProvID(i);
                            fMinDistance = tempDistance;
                        }
                        CFG.core.getProv(nProvinceID).updateArmy4(nCivID, 0);
                        CFG.core.getProv(toProvinceID).updateArmy4(nCivID, CFG.core.getProv(toProvinceID).getArmyCivID1(nCivID) + nArmy);
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                        CFG.core.getCiv(nCivID).setNumberOfUnits(CFG.core.getCiv(nCivID).getNumberOfUnits() - nArmy);
                        CFG.core.getProv(nProvinceID).updateArmy4(nCivID, 0);
                    }
                } else {
                    CFG.core.getCiv(nCivID).setNumberOfUnits(CFG.core.getCiv(nCivID).getNumberOfUnits() - nArmy);
                    CFG.core.getProv(nProvinceID).updateArmy4(nCivID, 0);
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        catch (StackOverflowError exr) {
            CFG.exceptionStack(exr);
        }
    }

    public long armyRetreat(int fromProvinceID, int civID, long armyLost) {
        try {
            int i;
            if (armyLost < GameValues.gvMove.MIN_ARMY_TO_RETREAT) {
                return 0;
            }
            ArrayList<Integer> possibleProvinces = new ArrayList<Integer>();
            for (i = 0; i < CFG.core.getProv(fromProvinceID).getNeighProvincesSize(); ++i) {
                if (CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighProvinces(i)).getCivId() != civID) continue;
                possibleProvinces.add(CFG.core.getProv(fromProvinceID).getNeighProvinces(i));
            }
            if (possibleProvinces.isEmpty()) {
                for (i = 0; i < CFG.core.getProv(fromProvinceID).getNeighProvincesSize(); ++i) {
                    if (!CFG.core.isAlly(CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighProvinces(i)).getCivId(), civID) && CFG.core.getMilitaryAccess(civID, CFG.core.getProv(CFG.core.getProv(fromProvinceID).getNeighProvinces(i)).getCivId()) <= 0) continue;
                    possibleProvinces.add(CFG.core.getProv(fromProvinceID).getNeighProvinces(i));
                }
            }
            if (!possibleProvinces.isEmpty()) {
                int retreatToProvID = (Integer)possibleProvinces.get(CFG.oR.nextInt(possibleProvinces.size()));
                if ((armyLost = (long)Math.floor((float)armyLost * CFG.ARMY_RETREAT)) > 0) {
                    CFG.core.getProv(retreatToProvID).updateArmy4(civID, CFG.core.getProv(retreatToProvID).getArmyCivID1(civID) + armyLost);
                    CFG.core.getCiv(civID).setNumberOfUnits(CFG.core.getCiv(civID).getNumberOfUnits() + armyLost);
                }
                return armyLost;
            }
            return 0;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        catch (StackOverflowError exr) {
            CFG.exceptionStack(exr);
        }
        return 0;
    }

    public long armyRetreat_Defended(int fromProvinceID, int civID, long armyLost) {
        if (armyLost < GameValues.gvMove.MIN_ARMY_TO_RETREAT) {
            return 0;
        }
        if ((armyLost = (long)Math.floor((float)armyLost * CFG.ARMY_RETREAT)) > 0) {
            CFG.core.getProv(fromProvinceID).updateArmy4(civID, CFG.core.getProv(fromProvinceID).getArmyCivID1(civID) + armyLost);
            CFG.core.getCiv(civID).setNumberOfUnits(CFG.core.getCiv(civID).getNumberOfUnits() + armyLost);
        }
        return armyLost;
    }

    public long armyRetreat_Strategic(int fromProvinceID, int civID, long armyLost) {
        try {
            if (armyLost < GameValues.gvMove.MIN_ARMY_TO_RETREAT) {
                return 0;
            }
            ArrayList<Integer> backProvinces = new ArrayList<Integer>();
            ArrayList<Integer> anyOwnedProvinces = new ArrayList<Integer>();
            for (int i = 0; i < CFG.core.getProv(fromProvinceID).getNeighProvincesSize(); ++i) {
                int nProvID = CFG.core.getProv(fromProvinceID).getNeighProvinces(i);
                if (CFG.core.getProv(nProvID).getCivId() != civID) continue;
                anyOwnedProvinces.add(nProvID);
                boolean isFrontLine = false;
                for (int j = 0; j < CFG.core.getProv(nProvID).getNeighProvincesSize(); ++j) {
                    int nNeighID = CFG.core.getProv(nProvID).getNeighProvinces(j);
                    int nNeighOwner = CFG.core.getProv(nNeighID).getCivId();
                    if (nNeighOwner <= 0 || nNeighOwner == civID || !CFG.core.getCivsAtWar(civID, nNeighOwner)) continue;
                    isFrontLine = true;
                    break;
                }
                if (!isFrontLine) {
                    backProvinces.add(nProvID);
                }
            }
            ArrayList<Integer> retreatTargets = !backProvinces.isEmpty() ? backProvinces : anyOwnedProvinces;
            if (!retreatTargets.isEmpty()) {
                long totalRetreated = 0L;
                long remainingToRetreat = (long)Math.floor((float)armyLost * 0.5f);
                int numTargets = retreatTargets.size();
                for (int i = 0; i < numTargets && remainingToRetreat > 0; ++i) {
                    long share = (i < numTargets - 1) ? (remainingToRetreat / (numTargets - i)) : remainingToRetreat;
                    if (share <= 0) continue;
                    int retreatToProvID = (Integer)retreatTargets.get(i);
                    CFG.core.getProv(retreatToProvID).updateArmy4(civID, CFG.core.getProv(retreatToProvID).getArmyCivID1(civID) + share);
                    totalRetreated += share;
                    remainingToRetreat -= share;
                }
                if (totalRetreated > 0) {
                    CFG.core.getCiv(civID).setNumberOfUnits(CFG.core.getCiv(civID).getNumberOfUnits() + totalRetreated);
                }
                return totalRetreated;
            }
            return 0;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            return 0;
        }
    }

    public final TurnStates getActiveTurnStateID() {
        return this.activeTurnAction;
    }

    public final void setActiveTurnState(TurnStates nState) {
        this.activeTurnAction = nState;
    }

    public final MoveUnits_TurnData getCurrentMoveunits() {
        return this.currentMoveUnits;
    }

    public final void resetCurrentMoveUnits() {
        this.currentMoveUnits = null;
    }

    public final void buildFogOfWar_CivID(int nPlayerID, int nCivID) {
        try {
            int j;
            int i;
            Civilization civ = CFG.core.getCiv(nCivID);
            for (i = 0; i < civ.getNumOfProvs(); ++i) {
                CFG.core.getPlayer(nPlayerID).setFogOfWar(civ.getProvID(i), true);
                for (j = 0; j < CFG.core.getProv(civ.getProvID(i)).getNeighSeaProvincesSize(); ++j) {
                    CFG.core.getPlayer(nPlayerID).setFogOfWar(CFG.core.getProv(civ.getProvID(i)).getNeighSeaProvinces(j), true);
                }
                this.buildFogOfWar_WatchTower(nPlayerID, civ.getProvID(i));
            }
            for (i = 0; i < civ.getArmyInAnotherProvinceSize(); ++i) {
                CFG.core.getPlayer(nPlayerID).setFogOfWar(civ.getArmyInAnotherProviP(i), true);
                if (!CFG.core.getProv(civ.getArmyInAnotherProviP(i)).getSeaProv()) continue;
                for (j = 0; j < CFG.core.getProv(civ.getArmyInAnotherProviP(i)).getNeighProvincesSize(); ++j) {
                    if (!CFG.core.getProv(CFG.core.getProv(civ.getArmyInAnotherProviP(i)).getNeighProvinces(j)).getSeaProv()) continue;
                    CFG.core.getPlayer(nPlayerID).setFogOfWar(CFG.core.getProv(civ.getArmyInAnotherProviP(i)).getNeighProvinces(j), true);
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void buildFogOfWar_WatchTower(int nPlayerID, int nProvinceID) {
        try {
            Province province = CFG.core.getProv(nProvinceID);
            if (province.getLvlOfWatchTower() > 0) {
                if (province.getLvlOfWatchTower() == 1) {
                    for (int j = 0; j < province.getNeighProvincesSize(); ++j) {
                        if (CFG.core.getProv(province.getNeighProvinces(j)).getLvlOfFort() >= 1) continue;
                        CFG.core.getPlayer(nPlayerID).setFogOfWar(province.getNeighProvinces(j), true);
                    }
                } else {
                    for (int j = 0; j < province.getNeighProvincesSize(); ++j) {
                        if (CFG.core.getProv(province.getNeighProvinces(j)).getLvlOfFort() >= 1) continue;
                        CFG.core.getPlayer(nPlayerID).setFogOfWar(province.getNeighProvinces(j), true);
                        for (int k = 0; k < CFG.core.getProv(province.getNeighProvinces(j)).getNeighProvincesSize(); ++k) {
                            if (CFG.core.getProv(CFG.core.getProv(province.getNeighProvinces(j)).getNeighProvinces(k)).getLvlOfFort() >= 1) continue;
                            CFG.core.getPlayer(nPlayerID).setFogOfWar(CFG.core.getProv(province.getNeighProvinces(j)).getNeighProvinces(k), true);
                        }
                    }
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final boolean hasArmyInProvince(int nProvinceID, int nCivID) {
        for (int i = 0; i < CFG.core.getProv(nProvinceID).getCivsSize(); ++i) {
            if (CFG.core.getProv(nProvinceID).getCivId(i) != nCivID) continue;
            return CFG.core.getProv(nProvinceID).getArmyID(i) > 0;
        }
        return false;
    }

    public final void updateCivsMovementPoints() {
        Parallel.range(1, CFG.core.getCivsSize(), (int i) -> {
            this.updateCivsMovementPoints(i);
        });
    }

    public final void updateCivsMovementPoints(int nCivID) {
        int movePointsPerTurn = this.getCivMovementPoints(nCivID);
        CFG.core.getCiv(nCivID).setMovementPoints(Math.min((int)(CFG.MOVEMENT_POINTS_MAX_MODIFIER * (float)movePointsPerTurn), CFG.core.getCiv(nCivID).getMovemPoints() + movePointsPerTurn));
    }

    public final int getCivMaxMovementPoints(int nCivID) {
        int movePointsPerTurn = this.getCivMovementPoints(nCivID);
        return (int)(CFG.MOVEMENT_POINTS_MAX_MODIFIER * (float)movePointsPerTurn);
    }

    public final int getCivMovementPoints(int nCivID) {
        return this.getMovementPoints_BaseValue(nCivID) + this.getMovementPoints_FromCivSize(nCivID) + this.getMovementPoints_FromTechnology(nCivID) + this.getMovementPoints_TechnologyPoints(nCivID);
    }

    public final int getMovementPoints_TechnologyPoints(int nCivID) {
        return (int)Math.ceil((float)(this.getMovementPoints_BaseValue(nCivID) + this.getMovementPoints_FromCivSize(nCivID) + this.getMovementPoints_FromTechnology(nCivID)) * (GameValues.gvTechnology.PER_POINT_MOVEMENT * (float)CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_MOVEMENT));
    }

    public final int getMovementPoints_BaseValue(int nCivID) {
        return (CFG.MOVEMENT_POINTS_EXTRA + GameValues.gvMovementPoints.MOVEMENT_POINTS_BASE_VALUE + (int)((float)CFG.gameAges.getAge_StartingMovementPoints(GameCalendar.CURRENT_AGEID) * this.modifierMovePoints_CivID(nCivID) * (1.0f + CFG.core.getCiv(nCivID).getModifier_MovementPoints()))) * 8;
    }

    public final int getMovementPoints_FromCivSize(int nCivID) {
        return (int)((float)CFG.core.getCiv(nCivID).getNumOfProvs() * CFG.gameAges.getAge_MovementPointsModifier(GameCalendar.CURRENT_AGEID) * Math.min(CFG.core.getCiv(nCivID).getTechLevel() * GameValues.gvMovementPoints.MOVEMENT_POINTS_CIV_SIZE_TECHNOLOGY_LEVEL_MODIFIER, GameValues.gvMovementPoints.MOVEMENT_POINTS_CIV_SIZE_TECHNOLOGY_LEVEL_MODIFIER_LIMIT) * this.modifierMovePoints_CivID(nCivID) * (1.0f + CFG.core.getCiv(nCivID).getModifier_MovementPoints())) * 8;
    }

    public final int getMovementPoints_FromTechnology(int nCivID) {
        return (int)((float)CFG.gameAges.getAge_StartingMovementPoints(GameCalendar.CURRENT_AGEID) * CFG.core.getCiv(nCivID).getTechLevel() * GameValues.gvMovementPoints.MOVEMENT_POINTS_TECHNOLOGY_LEVEL_MODIFIER * (1.0f + CFG.core.getCiv(nCivID).getModifier_MovementPoints())) * 8;
    }

    public final void updateCivsDiploPoints_StartTheGame() {
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            this.updateCivsDiploPoints(i);
            CFG.core.getCiv(i).setDiploPoints((int)Math.max((float)CFG.core.getCiv(i).getDiploPoints() * GameValues.gvDiplomacyPoints.DIPLOMACY_POINTS_START_GAME_MODIFIER, (float)GameValues.gvDiplomacyPoints.DIPLOMACY_POINTS_START_GAME_MAX));
        }
    }

    public final void updateCivsDiploPoints() {
        Parallel.range(1, CFG.core.getCivsSize(), (int i) -> {
            this.updateCivsDiploPoints(i);
        });
    }

    public final void updateCivsDiploPoints(int nCivID) {
        CFG.core.getCiv(nCivID).setDiploPoints(CFG.core.getCiv(nCivID).getDiploPoints() + this.getUpdateCivsDiploPoints(nCivID));
    }

    public final int getUpdateCivsDiploPoints_INFO_ONLY(int nCivID) {
        return Math.max(this.getDiplomacyPoints_BaseValue(nCivID) + this.getDiplomacyPoints_FromEnemies(nCivID) + this.getDiplomacyPoints_FromRank(nCivID) + this.getDiplomacyPoints_FromTechnology(nCivID) - GameManager.getCostOfCurrentDiplomaticActionsUpdate(nCivID), 0) - CFG.core.getCiv((int)nCivID).civGD.civDiploGD.getImproveRelationsSize() * GameValues.gvRelationImprove.COST_OFFER_IMPROVE_RELATIONS_DIPLOMACY_POINTS - CFG.core.getCiv((int)nCivID).defensivePact.size() * GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_DEFENSIVE_PACT - CFG.core.getCiv((int)nCivID).nonAggressionPact.size() * GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_NONAGGRESSION - CFG.core.getCiv((int)nCivID).guarantee.size() * GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_GUARANTEE - CFG.core.getCiv((int)nCivID).militaryAccess.size() * GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_MILITARY_ACCESS;
    }

    public final int getUpdateCivsDiploPoints(int nCivID) {
        return Math.max(this.getDiplomacyPoints_BaseValue(nCivID) + this.getDiplomacyPoints_FromEnemies(nCivID) + this.getDiplomacyPoints_FromRank(nCivID) + this.getDiplomacyPoints_FromTechnology(nCivID) - GameManager.getCostOfCurrentDiplomaticActionsUpdate(nCivID), 0);
    }

    public final int getDiplomacyPoints_BaseValue(int nCivID) {
        return (CFG.DIPLOMACY_POINTS_EXTRA + GameValues.gvDiplomacyPoints.DIPLOMACY_POINTS_BASE_VALUE + (int)((float)CFG.gameAges.getAge_StartingDiplomacyPoints(GameCalendar.CURRENT_AGEID) * this.modifierMovePoints_CivID(nCivID) * GameValues.gvDiplomacyPoints.DIPLOMACY_POINTS_BASE_MODIFIER)) * 8;
    }

    public final int getDiplomacyPoints_FromTechnology(int nCivID) {
        return (int)((float)CFG.gameAges.getAge_StartingDiplomacyPoints(GameCalendar.CURRENT_AGEID) * CFG.core.getCiv(nCivID).getTechLevel() * GameValues.gvDiplomacyPoints.DIPLOMACY_POINTS_FROM_TECHNOLOGY_MODIFIER) * 8;
    }

    public final int getDiplomacyPoints_FromRank(int nCivID) {
        return (int)((float)CFG.gameAges.getAge_StartingDiplomacyPoints(GameCalendar.CURRENT_AGEID) * (1.0f - (float)CFG.core.getCiv(nCivID).getRankPos() / (float)CFG.core.getCivsSize()) * GameValues.gvDiplomacyPoints.DIPLOMACY_POINTS_FROM_RANK_MODIFIER) * 8;
    }

    public final int getDiplomacyPoints_FromEnemies(int nCivID) {
        return (int)((float)GameValues.gvDiplomacyPoints.DIPLOMACY_POINTS_FROM_ENEMIES_BASE_VALUE + (float)Math.min(CFG.oAI.MIN_NUM_OF_RIVALS, CFG.core.getCiv(nCivID).getHatedCivsSize()) * GameValues.gvDiplomacyPoints.DIPLOMACY_POINTS_PER_ENEMY) * 8;
    }

    public float modifierMovePoints_CivID(int nCivID) {
        if (CFG.core.getCiv(nCivID).getIsPlayer()) {
            switch (CFG.DIFFICULTY) {
                case 0: {
                    return GameValues.gvDifficulty.MOVEMENT_POINTS_MODIFIER_PLAYER_BEGINNER;
                }
                case 1: {
                    return GameValues.gvDifficulty.MOVEMENT_POINTS_MODIFIER_PLAYER_NORMAL;
                }
                case 2: {
                    return GameValues.gvDifficulty.MOVEMENT_POINTS_MODIFIER_PLAYER_HARD;
                }
                case 3: {
                    return GameValues.gvDifficulty.MOVEMENT_POINTS_MODIFIER_PLAYER_EXTREME;
                }
                case 4: {
                    return GameValues.gvDifficulty.MOVEMENT_POINTS_MODIFIER_PLAYER_LEGENDARY;
                }
            }
        }
        switch (CFG.DIFFICULTY) {
            case 0: {
                return GameValues.gvDifficulty.MOVEMENT_POINTS_MODIFIER_NON_PLAYER_BEGINNER;
            }
            case 1: {
                return GameValues.gvDifficulty.MOVEMENT_POINTS_MODIFIER_NON_PLAYER_NORMAL;
            }
            case 2: {
                return GameValues.gvDifficulty.MOVEMENT_POINTS_MODIFIER_NON_PLAYER_HARD;
            }
            case 3: {
                return GameValues.gvDifficulty.MOVEMENT_POINTS_MODIFIER_NON_PLAYER_EXTREME;
            }
            case 4: {
                return GameValues.gvDifficulty.MOVEMENT_POINTS_MODIFIER_NON_PLAYER_LEGENDARY;
            }
        }
        return 1.0f;
    }

    public float modifierAcceptableTaxation_CivID(int nCivID) {
        if (CFG.core.getCiv(nCivID).getIsPlayer()) {
            return 0.0f;
        }
        switch (CFG.DIFFICULTY) {
            case 0: {
                return GameValues.gvDifficulty.ACCEPTABLE_TAXATION_NON_PLAYER_BEGINNER;
            }
            case 1: {
                return GameValues.gvDifficulty.ACCEPTABLE_TAXATION_NON_PLAYER_NORMAL;
            }
            case 2: {
                return GameValues.gvDifficulty.ACCEPTABLE_TAXATION_NON_PLAYER_HARD;
            }
            case 3: {
                return GameValues.gvDifficulty.ACCEPTABLE_TAXATION_NON_PLAYER_EXTREME;
            }
            case 4: {
                return GameValues.gvDifficulty.ACCEPTABLE_TAXATION_NON_PLAYER_LEGENDARY;
            }
        }
        return 1.0f;
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    public final void turnMoves() {
        try {
            int k;
            int civRTO;
            if (this.currentMoveUnits != null && this.currentMoveUnits.getMoveUnitsSize() > 0) {
                this.turnMoves_MoveCurrentArmy();
                return;
            }
            if (CFG.menus.getInGame_Report_Visible()) {
                CFG.menus.setInGame_Report_Visible(false);
            }
            int e = this.eRTO_START2;
            while (e < CFG.core.getRTO().getRTOSize()) {
                civRTO = CFG.core.getRTO().getRTO(e);
                this.turnMoves_UpdatePlayersFogOfWar(civRTO);
                Civilization civE = CFG.core.getCiv(civRTO);
                for (int i = 0; i < civE.moveUnitsSize(); ++i) {
                    MoveUnits moveUnitsI = civE.getMoveUnits(i);
                    if (CFG.settingsGD.ANNEXATION_DELAY && CFG.core.getProv(moveUnitsI.getFromProviID()).getOccupationTurnsLeft() > 0) continue;
                    
                    if (CFG.settingsGD.ANNEXATION_DELAY && CFG.core.getProv(moveUnitsI.getToProvID()).isOccupied() && CFG.core.getProv(moveUnitsI.getToProvID()).getOccupationTurnsLeft() > 0 && CFG.core.getCivsAtWar(civRTO, CFG.core.getProv(moveUnitsI.getToProvID()).getCivId())) continue;
                    
                    if (moveUnitsI.getNumberOfUnits() <= CFG.MIN_ARMY_REQUIRED_TO_ATTACK || CFG.core.getProv(moveUnitsI.getToProvID()).getCivId() <= 0 || CFG.core.getProv(moveUnitsI.getFromProviID()).isOccupied() || !CFG.core.getProv(moveUnitsI.getToProvID()).isOccupied() || !CFG.core.getCivsAtWar(civRTO, CFG.core.getProv(moveUnitsI.getToProvID()).getCivId())) continue;
                    if (moveUnitsI.getNumberOfUnits() > CFG.core.getProv(moveUnitsI.getFromProviID()).getArmyCivID1(civRTO)) {
                        moveUnitsI.setNumberOfUnits(CFG.core.getProv(moveUnitsI.getFromProviID()).getArmyCivID1(civRTO));
                    }
                    if (moveUnitsI.getNumberOfUnits() > 0) {
                        int o;
                        this.currentMoveUnits = new MoveUnits_TurnData(civRTO);
                        this.currentMoveUnits.addMoveUnits(moveUnitsI, civRTO);
                        civE.removeMove(i--);
                        if (!CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getSeaProv()) {
                            for (k = i + 1; k < civE.moveUnitsSize(); ++k) {
                                if (this.currentMoveUnits.getMoveUnits(0).getToProvID() != civE.getMoveUnits(k).getToProvID()) continue;
                                if (civE.getMoveUnits(k).getNumberOfUnits() > CFG.core.getProv(civE.getMoveUnits(k).getFromProviID()).getArmyCivID1(civRTO)) {
                                    civE.getMoveUnits(k).setNumberOfUnits(CFG.core.getProv(civE.getMoveUnits(k).getFromProviID()).getArmyCivID1(civRTO));
                                }
                                if (civE.getMoveUnits(k).getNumberOfUnits() <= 0) continue;
                                this.currentMoveUnits.addMoveUnits(civE.getMoveUnits(k), civRTO);
                                civE.removeMove(k--);
                            }
                            if (civE.getAlliance() > 0) {
                                Alliance alliance = CFG.core.getAlliance(civE.getAlliance());
                                for (int a = 0; a < alliance.getCivilizationsSize(); ++a) {
                                    if (alliance.getCivilization(a) == civRTO) continue;
                                    for (int k2 = 0; k2 < CFG.core.getCiv(alliance.getCivilization(a)).moveUnitsSize(); ++k2) {
                                        if (this.currentMoveUnits.getMoveUnits(0).getToProvID() != CFG.core.getCiv(alliance.getCivilization(a)).getMoveUnits(k2).getToProvID()) continue;
                                        if (CFG.core.getCiv(alliance.getCivilization(a)).getMoveUnits(k2).getNumberOfUnits() > CFG.core.getProv(CFG.core.getCiv(alliance.getCivilization(a)).getMoveUnits(k2).getFromProviID()).getArmyCivID1(alliance.getCivilization(a))) {
                                            CFG.core.getCiv(alliance.getCivilization(a)).getMoveUnits(k2).setNumberOfUnits(CFG.core.getProv(CFG.core.getCiv(alliance.getCivilization(a)).getMoveUnits(k2).getFromProviID()).getArmyCivID1(alliance.getCivilization(a)));
                                        }
                                        if (CFG.core.getCiv(alliance.getCivilization(a)).getMoveUnits(k2).getNumberOfUnits() <= 0) continue;
                                        this.currentMoveUnits.addMoveUnits(CFG.core.getCiv(alliance.getCivilization(a)).getMoveUnits(k2), alliance.getCivilization(a));
                                        CFG.core.getCiv(alliance.getCivilization(a)).removeMove(k2--);
                                    }
                                }
                            }
                            for (int a = 1; a < CFG.core.getCivsSize(); ++a) {
                                if (a == civRTO || CFG.core.getCiv(a).getPuppetOfCiv() != civRTO && a != civE.getPuppetOfCiv()) continue;
                                for (int k3 = 0; k3 < CFG.core.getCiv(a).moveUnitsSize(); ++k3) {
                                    if (this.currentMoveUnits.getMoveUnits(0).getToProvID() != CFG.core.getCiv(a).getMoveUnits(k3).getToProvID()) continue;
                                    if (CFG.core.getCiv(a).getMoveUnits(k3).getNumberOfUnits() > CFG.core.getProv(CFG.core.getCiv(a).getMoveUnits(k3).getFromProviID()).getArmyCivID1(a)) {
                                        CFG.core.getCiv(a).getMoveUnits(k3).setNumberOfUnits(CFG.core.getProv(CFG.core.getCiv(a).getMoveUnits(k3).getFromProviID()).getArmyCivID1(a));
                                    }
                                    if (CFG.core.getCiv(a).getMoveUnits(k3).getNumberOfUnits() <= 0) continue;
                                    this.currentMoveUnits.addMoveUnits(CFG.core.getCiv(a).getMoveUnits(k3), a);
                                    CFG.core.getCiv(a).removeMove(k3--);
                                }
                            }
                        }
                        int attackingArmy = 0;
                        for (o = 0; o < this.currentMoveUnits.getMoveUnitsSize(); ++o) {
                            attackingArmy += this.currentMoveUnits.getMoveUnits(o).getNumberOfUnits();
                        }
                        if (attackingArmy < CFG.MIN_ARMY_REQUIRED_TO_ATTACK && CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId() > 0 && CFG.core.getCivsAtWar(civRTO, CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId())) {
                            this.currentMoveUnits = null;
                            continue;
                        }
                        for (o = 0; o < this.currentMoveUnits.getMoveUnitsSize(); ++o) {
                            this.currentMoveUnits.getMoveUnits(o).getMoveUnits_Line().updateMoveTime();
                        }
                        this.rollDices();
                        this.SAVE_REPORT = CFG.core.getCiv(this.currentMoveUnits.getCivID(0)).getIsPlayer() || CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId()).getIsPlayer() ? CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getSeaProv() && CFG.core.getSeaProvinceAttack(this.currentMoveUnits.getCivID(0), this.currentMoveUnits.getMoveUnits(0).getToProvID()) || !CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getSeaProv() && this.turnMoves_IsACombatMove(this.currentMoveUnits.getCivID(0), this.currentMoveUnits.getMoveUnits(0).getToProvID()) : false;
                        if ((CFG.SHOW_ALL_MOVES || CFG.core.getCiv(this.currentMoveUnits.getCivID(0)).getIsPlayer() || CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId()).getIsPlayer()) && CFG.settingsGD.SHOW_COMBAT_MOVEMENT && !SKIP_ALL_COMBAT_MOVEMENT_ONCE) {
                            if (CFG.SHOW_ONLY_COMBAT_MOVES) {
                                if ((CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getSeaProv() && CFG.core.getSeaProvinceAttack(this.currentMoveUnits.getCivID(0), this.currentMoveUnits.getMoveUnits(0).getToProvID()) || !CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getSeaProv() && this.turnMoves_IsACombatMove(this.currentMoveUnits.getCivID(0), this.currentMoveUnits.getMoveUnits(0).getToProvID())) && (!RTS.isEnabled() || !RTS.PAUSE && RTS.showReport() || RTS.PAUSE)) {
                                    this.SHOW_REPORT = CFG.settingsGD.SHOW_BATTLE_REPORT;
                                    this.iPlayerAttack_ShowArmyInProvinceID = this.currentMoveUnits.getMoveUnits(0).getToProvID();
                                    CFG.core.getPlayer(CFG.PLAYER_TURN_ID).setFogOfWar(this.currentMoveUnits.getMoveUnits(0).getToProvID(), true);
                                    CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateDrawArmyInProv();
                                    this.diceDefendersCivID = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId();
                                    this.diceAggressorsCivID = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getFromProviID()).getCivId();
                                    CFG.menus.setVisible_InGame_Dices(!CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getSeaProv());
                                    CFG.map.getMpC().centerToProvID(this.currentMoveUnits.getMoveUnits(0).getToProvID());
                                    if (CFG.mapModesManager.getActiveMapModeID() >= 0) {
                                        CFG.mapModesManager.disableAllViews();
                                    }
                                    return;
                                }
                                this.turnMoves_MoveCurrentArmy();
                                continue;
                            }
                            CFG.map.getMpC().centerToProvID(this.currentMoveUnits.getMoveUnits(0).getToProvID());
                            if (CFG.mapModesManager.getActiveMapModeID() >= 0) {
                                CFG.mapModesManager.disableAllViews();
                            }
                            return;
                        }
                        this.turnMoves_MoveCurrentArmy();
                        continue;
                    }
                    civE.removeMove(i--);
                }
                ++e;
                ++this.eRTO_START2;
            }
            e = this.eRTO_START;
            while (e < CFG.core.getRTO().getRTOSize()) {
                int i;
                civRTO = CFG.core.getRTO().getRTO(e);
                this.turnMoves_UpdatePlayersFogOfWar(civRTO);
                for (i = 0; i < CFG.core.getCiv(civRTO).moveUnitsSize(); ++i) {
                    MoveUnits moveUnitsI = CFG.core.getCiv(civRTO).getMoveUnits(i);
                    if (CFG.settingsGD.ANNEXATION_DELAY && CFG.core.getProv(moveUnitsI.getFromProviID()).getOccupationTurnsLeft() > 0) continue;
                    
                    if (CFG.settingsGD.ANNEXATION_DELAY && CFG.core.getProv(moveUnitsI.getToProvID()).isOccupied() && CFG.core.getProv(moveUnitsI.getToProvID()).getOccupationTurnsLeft() > 0 && CFG.core.getCivsAtWar(civRTO, CFG.core.getProv(moveUnitsI.getToProvID()).getCivId())) continue;
                    
                    if (CFG.core.getProv(moveUnitsI.getToProvID()).getCivId() == 0 || CFG.core.getCivsAtWar(civRTO, CFG.core.getProv(moveUnitsI.getToProvID()).getCivId()) || CFG.core.getMilitaryAccess(civRTO, CFG.core.getProv(moveUnitsI.getToProvID()).getCivId()) > 0 || CFG.core.getProv(moveUnitsI.getToProvID()).getCivId() == civRTO || CFG.core.getCiv(CFG.core.getProv(moveUnitsI.getToProvID()).getCivId()).getPuppetOfCiv() == civRTO || CFG.core.getCiv(civRTO).getPuppetOfCiv() == CFG.core.getProv(moveUnitsI.getToProvID()).getCivId() || CFG.core.getCiv(civRTO).getAlliance() > 0 && CFG.core.getCiv(civRTO).getAlliance() == CFG.core.getCiv(CFG.core.getProv(moveUnitsI.getToProvID()).getCivId()).getAlliance()) {
                        if (moveUnitsI.getNumberOfUnits() > CFG.core.getProv(moveUnitsI.getFromProviID()).getArmyCivID1(civRTO)) {
                            moveUnitsI.setNumberOfUnits(CFG.core.getProv(moveUnitsI.getFromProviID()).getArmyCivID1(civRTO));
                        }
                        if (moveUnitsI.getNumberOfUnits() > 0) {
                            int o;
                            this.currentMoveUnits = new MoveUnits_TurnData(civRTO);
                            this.currentMoveUnits.addMoveUnits(moveUnitsI, civRTO);
                            CFG.core.getCiv(civRTO).removeMove(i--);
                            if (!CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getSeaProv()) {
                                int a;
                                for (int k4 = i + 1; k4 < CFG.core.getCiv(civRTO).moveUnitsSize(); ++k4) {
                                    if (this.currentMoveUnits.getMoveUnits(0).getToProvID() != CFG.core.getCiv(civRTO).getMoveUnits(k4).getToProvID()) continue;
                                    if (CFG.core.getCiv(civRTO).getMoveUnits(k4).getNumberOfUnits() > CFG.core.getProv(CFG.core.getCiv(civRTO).getMoveUnits(k4).getFromProviID()).getArmyCivID1(civRTO)) {
                                        CFG.core.getCiv(civRTO).getMoveUnits(k4).setNumberOfUnits(CFG.core.getProv(CFG.core.getCiv(civRTO).getMoveUnits(k4).getFromProviID()).getArmyCivID1(civRTO));
                                    }
                                    if (CFG.core.getCiv(civRTO).getMoveUnits(k4).getNumberOfUnits() <= 0) continue;
                                    this.currentMoveUnits.addMoveUnits(CFG.core.getCiv(civRTO).getMoveUnits(k4), civRTO);
                                    CFG.core.getCiv(civRTO).removeMove(k4--);
                                }
                                if (CFG.core.getCiv(civRTO).getAlliance() > 0) {
                                    for (a = 0; a < CFG.core.getAlliance(CFG.core.getCiv(civRTO).getAlliance()).getCivilizationsSize(); ++a) {
                                        if (CFG.core.getAlliance(CFG.core.getCiv(civRTO).getAlliance()).getCivilization(a) == civRTO) continue;
                                        for (k = 0; k < CFG.core.getCiv(CFG.core.getAlliance(CFG.core.getCiv(civRTO).getAlliance()).getCivilization(a)).moveUnitsSize(); ++k) {
                                            if (this.currentMoveUnits.getMoveUnits(0).getToProvID() != CFG.core.getCiv(CFG.core.getAlliance(CFG.core.getCiv(civRTO).getAlliance()).getCivilization(a)).getMoveUnits(k).getToProvID()) continue;
                                            if (CFG.core.getCiv(CFG.core.getAlliance(CFG.core.getCiv(civRTO).getAlliance()).getCivilization(a)).getMoveUnits(k).getNumberOfUnits() > CFG.core.getProv(CFG.core.getCiv(CFG.core.getAlliance(CFG.core.getCiv(civRTO).getAlliance()).getCivilization(a)).getMoveUnits(k).getFromProviID()).getArmyCivID1(CFG.core.getAlliance(CFG.core.getCiv(civRTO).getAlliance()).getCivilization(a))) {
                                                CFG.core.getCiv(CFG.core.getAlliance(CFG.core.getCiv(civRTO).getAlliance()).getCivilization(a)).getMoveUnits(k).setNumberOfUnits(CFG.core.getProv(CFG.core.getCiv(CFG.core.getAlliance(CFG.core.getCiv(civRTO).getAlliance()).getCivilization(a)).getMoveUnits(k).getFromProviID()).getArmyCivID1(CFG.core.getAlliance(CFG.core.getCiv(civRTO).getAlliance()).getCivilization(a)));
                                            }
                                            if (CFG.core.getCiv(CFG.core.getAlliance(CFG.core.getCiv(civRTO).getAlliance()).getCivilization(a)).getMoveUnits(k).getNumberOfUnits() <= 0) continue;
                                            this.currentMoveUnits.addMoveUnits(CFG.core.getCiv(CFG.core.getAlliance(CFG.core.getCiv(civRTO).getAlliance()).getCivilization(a)).getMoveUnits(k), CFG.core.getAlliance(CFG.core.getCiv(civRTO).getAlliance()).getCivilization(a));
                                            CFG.core.getCiv(CFG.core.getAlliance(CFG.core.getCiv(civRTO).getAlliance()).getCivilization(a)).removeMove(k--);
                                        }
                                    }
                                }
                                for (a = 1; a < CFG.core.getCivsSize(); ++a) {
                                    if (a == civRTO || CFG.core.getCiv(a).getPuppetOfCiv() != civRTO && a != CFG.core.getCiv(civRTO).getPuppetOfCiv()) continue;
                                    for (k = 0; k < CFG.core.getCiv(a).moveUnitsSize(); ++k) {
                                        if (this.currentMoveUnits.getMoveUnits(0).getToProvID() != CFG.core.getCiv(a).getMoveUnits(k).getToProvID()) continue;
                                        if (CFG.core.getCiv(a).getMoveUnits(k).getNumberOfUnits() > CFG.core.getProv(CFG.core.getCiv(a).getMoveUnits(k).getFromProviID()).getArmyCivID1(a)) {
                                            CFG.core.getCiv(a).getMoveUnits(k).setNumberOfUnits(CFG.core.getProv(CFG.core.getCiv(a).getMoveUnits(k).getFromProviID()).getArmyCivID1(a));
                                        }
                                        if (CFG.core.getCiv(a).getMoveUnits(k).getNumberOfUnits() <= 0) continue;
                                        this.currentMoveUnits.addMoveUnits(CFG.core.getCiv(a).getMoveUnits(k), a);
                                        CFG.core.getCiv(a).removeMove(k--);
                                    }
                                }
                            }
                            int attackingArmy = 0;
                            for (o = 0; o < this.currentMoveUnits.getMoveUnitsSize(); ++o) {
                                attackingArmy += this.currentMoveUnits.getMoveUnits(o).getNumberOfUnits();
                            }
                            if (attackingArmy < CFG.MIN_ARMY_REQUIRED_TO_ATTACK && CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId() > 0 && CFG.core.getCivsAtWar(civRTO, CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId())) {
                                this.currentMoveUnits = null;
                                continue;
                            }
                            for (o = 0; o < this.currentMoveUnits.getMoveUnitsSize(); ++o) {
                                this.currentMoveUnits.getMoveUnits(o).getMoveUnits_Line().updateMoveTime();
                            }
                            this.rollDices();
                            this.SAVE_REPORT = this.currentMoveUnits.isPlayerMoving() || CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId()).getIsPlayer() ? CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getSeaProv() && CFG.core.getSeaProvinceAttack(this.currentMoveUnits.getCivID(0), this.currentMoveUnits.getMoveUnits(0).getToProvID()) || !CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getSeaProv() && this.turnMoves_IsACombatMove(this.currentMoveUnits.getCivID(0), this.currentMoveUnits.getMoveUnits(0).getToProvID()) : false;
                            if ((CFG.SHOW_ALL_MOVES || this.currentMoveUnits.isPlayerMoving() || CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId()).getIsPlayer()) && CFG.settingsGD.SHOW_COMBAT_MOVEMENT && !SKIP_ALL_COMBAT_MOVEMENT_ONCE) {
                                if (CFG.SHOW_ONLY_COMBAT_MOVES) {
                                    if ((CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getSeaProv() && CFG.core.getSeaProvinceAttack(this.currentMoveUnits.getCivID(0), this.currentMoveUnits.getMoveUnits(0).getToProvID()) || !CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getSeaProv() && this.turnMoves_IsACombatMove(this.currentMoveUnits.getCivID(0), this.currentMoveUnits.getMoveUnits(0).getToProvID())) && (!RTS.isEnabled() || !RTS.PAUSE && RTS.showReport() || RTS.PAUSE)) {
                                        this.SHOW_REPORT = CFG.settingsGD.SHOW_BATTLE_REPORT;
                                        this.iPlayerAttack_ShowArmyInProvinceID = this.currentMoveUnits.getMoveUnits(0).getToProvID();
                                        CFG.core.getPlayer(CFG.PLAYER_TURN_ID).setFogOfWar(this.currentMoveUnits.getMoveUnits(0).getToProvID(), true);
                                        CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateDrawArmyInProv();
                                        this.diceDefendersCivID = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId();
                                        this.diceAggressorsCivID = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getFromProviID()).getCivId();
                                        CFG.menus.setVisible_InGame_Dices(!CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getSeaProv());
                                        CFG.map.getMpC().centerToProvID(this.currentMoveUnits.getMoveUnits(0).getToProvID());
                                        if (CFG.mapModesManager.getActiveMapModeID() >= 0) {
                                            CFG.mapModesManager.disableAllViews();
                                        }
                                        return;
                                    }
                                    this.turnMoves_MoveCurrentArmy();
                                    continue;
                                }
                                CFG.map.getMpC().centerToProvID(this.currentMoveUnits.getMoveUnits(0).getToProvID());
                                if (CFG.mapModesManager.getActiveMapModeID() >= 0) {
                                    CFG.mapModesManager.disableAllViews();
                                }
                                return;
                            }
                            this.turnMoves_MoveCurrentArmy();
                            continue;
                        }
                        CFG.core.getCiv(civRTO).removeMove(i--);
                        continue;
                    }
                    CFG.core.getCiv(civRTO).removeMove(i--);
                }
                for (i = 0; i < CFG.core.getCiv(civRTO).getMoveUnitsPlunderSize(); ++i) {
                    if (CFG.core.getCiv(civRTO).getMoveUnitsPlunder(i).getNumOfUnits() > CFG.core.getProv(CFG.core.getCiv(civRTO).getMoveUnitsPlunder(i).getFromProvinceID()).getArmyCivID1(civRTO)) {
                        CFG.core.getCiv(civRTO).getMoveUnitsPlunder(i).setNumOfUnits(CFG.core.getProv(CFG.core.getCiv(civRTO).getMoveUnitsPlunder(i).getFromProvinceID()).getArmyCivID1(civRTO));
                    }
                    if (CFG.core.getCiv(civRTO).getMoveUnitsPlunder(i).getNumOfUnits() > 0) {
                        Plunder.plunder(civRTO, CFG.core.getCiv(civRTO).getMoveUnitsPlunder(i).getFromProvinceID(), CFG.core.getCiv(civRTO).getMoveUnitsPlunder(i).getNumOfUnits());
                    }
                    CFG.core.getCiv(civRTO).removePlunder(i--);
                }
                GameManager.processGenocideOperations(civRTO);
                for (i = 0; i < CFG.core.getCiv(civRTO).getMigrateSize(); ++i) {
                    this.migrateFromTo(civRTO, CFG.core.getCiv(civRTO).getMigrateMU(i).getFromProviID(), CFG.core.getCiv(civRTO).getMigrateMU(i).getToProvID());
                    CFG.core.getCiv(civRTO).removeMigrate(i--);
                }
                ++e;
                ++this.eRTO_START;
            }
        }
        catch (Exception exr) {
            CFG.exceptionStack(exr);
        }
        catch (StackOverflowError exrz) {
            CFG.exceptionStack(exrz);
        }
        CFG.PROVINCE_BORDER_ANIMATION_TIME.clear();
        this.currentMoveUnits = null;
        this.diceDefenders = 1;
        this.diceAggressors = 1;
        ++GameCalendar.TURNID;
        CFG.gameAction.updateInGame_Date();
        try {
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                CFG.core.getCiv(i).clearMoveUnits();
                CFG.core.getCiv(i).clearMoveUnits_Plunder();
            }
        }
        catch (Exception exception) {
            
        }
        this.startNewTurn();
    }

    public final void updateDisbandSlider() {
        long controlledArmy = this.getControlledArmySizeInProvince(CFG.core.getActiveProvID(), CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        CFG.menus.getInGame_ProvinceDisband_Slider().setMax(controlledArmy);
        CFG.menus.getInGame_ProvinceDisband_Slider().setCurr(controlledArmy / 2L);
    }

    public final void updateHRE_Elections() {
        block21: {
            try {
                CFG.hreMgr.getHRE().setNextElectionsIn(CFG.hreMgr.getHRE().getNextElectionsIn() - 1);
                if (CFG.hreMgr.getHRE().getNextElectionsIn() <= 0 || !this.isEmperorInTheGame()) {
                    int i;
                    int i2;
                    ArrayList<Integer> lNumOfVotes = new ArrayList<Integer>();
                    for (i2 = 0; i2 < CFG.hreMgr.getHRE().getPrincesSize(); ++i2) {
                        lNumOfVotes.add(0);
                    }
                    block3: for (i2 = 0; i2 < CFG.hreMgr.getHRE().getElectorsSize(); ++i2) {
                        for (int j = 0; j < CFG.hreMgr.getHRE().getPrincesSize(); ++j) {
                            if (CFG.hreMgr.getHRE().getPrince(j) != CFG.hreMgr.getHRE().lVotesFor.get(i2).intValue()) continue;
                            lNumOfVotes.set(j, (Integer)lNumOfVotes.get(j) + 1);
                            continue block3;
                        }
                    }
                    int maxVotes = 0;
                    for (int i3 = 0; i3 < lNumOfVotes.size(); ++i3) {
                        if ((Integer)lNumOfVotes.get(i3) <= maxVotes) continue;
                        maxVotes = (Integer)lNumOfVotes.get(i3);
                    }
                    ArrayList<Integer> nCivsWithMaxVotes = new ArrayList<Integer>();
                    for (i = 0; i < lNumOfVotes.size(); ++i) {
                        if ((Integer)lNumOfVotes.get(i) != maxVotes) continue;
                        nCivsWithMaxVotes.add(i);
                    }
                    if (nCivsWithMaxVotes.size() > 0) {
                        boolean newEmperorID = false;
                        int oldEmperorID = CFG.hreMgr.getHRE().getEmperor();
                        boolean wasElector = false;
                        if (nCivsWithMaxVotes.size() == 1) {
                            wasElector = CFG.hreMgr.getHRE().getIsElector(CFG.hreMgr.getHRE().getPrince((Integer)nCivsWithMaxVotes.get(0)));
                            CFG.hreMgr.getHRE().setEmperor(CFG.hreMgr.getHRE().getPrince((Integer)nCivsWithMaxVotes.get(0)));
                        } else {
                            boolean emperorVoted = false;
                            for (int i4 = 0; i4 < nCivsWithMaxVotes.size(); ++i4) {
                                if (CFG.hreMgr.getHRE().getEmperor() != CFG.hreMgr.getHRE().getPrince((Integer)nCivsWithMaxVotes.get(i4))) continue;
                                emperorVoted = true;
                                break;
                            }
                            if (!emperorVoted) {
                                int tBest = 0;
                                for (int i5 = tBest + 1; i5 < nCivsWithMaxVotes.size(); ++i5) {
                                    if (CFG.core.getCiv(CFG.hreMgr.getHRE().getPrince((Integer)nCivsWithMaxVotes.get(tBest))).countPop() >= CFG.core.getCiv(CFG.hreMgr.getHRE().getPrince((Integer)nCivsWithMaxVotes.get(i5))).countPop()) continue;
                                    tBest = i5;
                                }
                                wasElector = CFG.hreMgr.getHRE().getIsElector(CFG.hreMgr.getHRE().getPrince((Integer)nCivsWithMaxVotes.get(tBest)));
                                CFG.hreMgr.getHRE().setEmperor(CFG.hreMgr.getHRE().getPrince((Integer)nCivsWithMaxVotes.get(tBest)));
                            }
                        }
                        if (CFG.hreMgr.getHRE().getEmperor() != oldEmperorID && wasElector) {
                            CFG.hreMgr.getHRE().addElector(oldEmperorID);
                        }
                    }
                    for (i = 0; i < CFG.hreMgr.getHRE().getPrincesSize(); ++i) {
                        if (!CFG.core.getCiv(CFG.hreMgr.getHRE().getPrince(i)).getIsPlayer()) continue;
                        CFG.core.getCiv((int)CFG.hreMgr.getHRE().getPrince((int)i)).getCivDiploGD().messageBox.addMessage(new Message_HRE_Elections_NewEmperor(CFG.hreMgr.getHRE().getEmperor()));
                    }
                    CFG.hreMgr.getHRE().randomNextElections();
                    this.updateHRE_VotesFor();
                } else if (CFG.hreMgr.getHRE().getNextElectionsIn() == 1) {
                    for (int i = 0; i < CFG.hreMgr.getHRE().getElectorsSize(); ++i) {
                        if (!CFG.core.getCiv(CFG.hreMgr.getHRE().getPrince(CFG.hreMgr.getHRE().getElector(i))).getIsPlayer()) continue;
                        CFG.core.getCiv((int)CFG.hreMgr.getHRE().getPrince((int)CFG.hreMgr.getHRE().getElector((int)i))).getCivDiploGD().messageBox.addMessage(new Message_HRE_ElectionsInNextTurn(CFG.hreMgr.getHRE().getEmperor()));
                    }
                    this.updateHRE_VotesFor();
                } else if (GameCalendar.TURNID % 6 == 0) {
                    this.updateHRE_VotesFor();
                }
            }
            catch (IndexOutOfBoundsException ex) {
                if (!CFG.LOGs) break block21;
                CFG.exceptionStack(ex);
            }
        }
    }

    public final void updateHRE_VotesFor() {
        boolean rebuildVotes = false;
        if (CFG.hreMgr.getHRE().lVotesFor == null || CFG.hreMgr.getHRE().lVotesFor.size() != CFG.hreMgr.getHRE().getElectorsSize()) {
            rebuildVotes = true;
        }
        for (int i = CFG.hreMgr.getHRE().getElectorsSize() - 1; i >= 0; --i) {
            if (CFG.core.getCiv(CFG.hreMgr.getHRE().getPrince(CFG.hreMgr.getHRE().getElector(i))).getNumOfProvs() != 0) continue;
            CFG.hreMgr.getHRE().removeElector(CFG.hreMgr.getHRE().getPrince(CFG.hreMgr.getHRE().getElector(i)));
            CFG.hreMgr.getHRE().addStrongestPrinceAsElector();
            rebuildVotes = true;
        }
        if (rebuildVotes) {
            CFG.hreMgr.getHRE().buildVotesFor();
        }
        int nMaxProvinces = 1;
        long nMaxScore = 1;
        for (int j = 0; j < CFG.hreMgr.getHRE().getPrincesSize(); ++j) {
            if (nMaxProvinces < CFG.core.getCiv(CFG.hreMgr.getHRE().getPrince(j)).getNumOfProvs()) {
                nMaxProvinces = CFG.core.getCiv(CFG.hreMgr.getHRE().getPrince(j)).getNumOfProvs();
            }
            if (nMaxScore >= CFG.core.getCiv(CFG.hreMgr.getHRE().getPrince(j)).getRankScore()) continue;
            nMaxScore = CFG.core.getCiv(CFG.hreMgr.getHRE().getPrince(j)).getRankScore();
        }
        try {
            for (int i = 0; i < CFG.hreMgr.getHRE().getElectorsSize(); ++i) {
                if (CFG.core.getCiv(CFG.hreMgr.getHRE().getPrince(CFG.hreMgr.getHRE().getElector(i))).getIsPlayer()) continue;
                ArrayList<Float> tempScores = new ArrayList<Float>();
                for (int j = 0; j < CFG.hreMgr.getHRE().getPrincesSize(); ++j) {
                    float nScore = 0.0f;
                    nScore = CFG.hreMgr.getHRE().getPrince(j) == CFG.hreMgr.getHRE().getPrince(CFG.hreMgr.getHRE().getElector(i)) ? (nScore += (float)GameValues.gvHre.VOTE_SCORE_ELECTOR_ON_YOURSELF) : (nScore += (float)GameValues.gvHre.VOTE_SCORE_RELATIONS * CFG.core.getCivRelationOfCivB(CFG.hreMgr.getHRE().getPrince(CFG.hreMgr.getHRE().getElector(i)), CFG.hreMgr.getHRE().getPrince(j)) / 100.0f);
                    nScore += CFG.core.getCiv((int)CFG.hreMgr.getHRE().getPrince((int)j)).HRE_VOTE_FOR_PROVINCES * (float)CFG.core.getCiv(CFG.hreMgr.getHRE().getPrince(j)).getNumOfProvs() / (float)nMaxProvinces * (GameValues.gvHre.VOTE_SCORE_PROVINCES_BASE + GameValues.gvHre.VOTE_SCORE_PROVINCES_RELATION * CFG.core.getCivRelationOfCivB(CFG.hreMgr.getHRE().getPrince(CFG.hreMgr.getHRE().getElector(i)), CFG.hreMgr.getHRE().getPrince(j)) / 100.0f);
                    nScore += CFG.core.getCiv((int)CFG.hreMgr.getHRE().getPrince((int)j)).HRE_VOTE_FOR_RANK * (float)CFG.core.getCiv(CFG.hreMgr.getHRE().getPrince(j)).getRankScore() / (float)nMaxScore * (GameValues.gvHre.VOTE_SCORE_RANK_BASE + GameValues.gvHre.VOTE_SCORE_RANK_RELATION * CFG.core.getCivRelationOfCivB(CFG.hreMgr.getHRE().getPrince(CFG.hreMgr.getHRE().getElector(i)), CFG.hreMgr.getHRE().getPrince(j)) / 100.0f);
                    if (CFG.core.getCiv(CFG.hreMgr.getHRE().getPrince(j)).getPuppetOfCiv() != CFG.hreMgr.getHRE().getPrince(j)) {
                        nScore = GameValues.gvHre.VOTE_SCORE_IS_VASSAL;
                    }
                    if (CFG.core.getCiv(CFG.hreMgr.getHRE().getPrince(j)).getNumOfProvs() <= 0) {
                        nScore = -10000.0f;
                    }
                    tempScores.add(Float.valueOf(nScore));
                }
                if (tempScores.size() > 0) {
                    int tBestID = 0;
                    for (int j = tBestID + 1; j < tempScores.size(); ++j) {
                        if (!(((Float)tempScores.get(tBestID)).floatValue() < ((Float)tempScores.get(j)).floatValue())) continue;
                        tBestID = j;
                    }
                    CFG.hreMgr.getHRE().lVotesFor.set(i, CFG.hreMgr.getHRE().getPrince(tBestID));
                }
                tempScores.clear();
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final boolean canAnyCivUpraise(int nProvinceID) {
        for (int i = 0; i < CFG.core.getProv(nProvinceID).getCores().getCivsSize(); ++i) {
            if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCores().getCivID(i)).getNumOfProvs() != 0 || CFG.core.getProv(nProvinceID).getCores().getCivID(i) == CFG.core.getProv(nProvinceID).getTrueOwnerOfProv()) continue;
            return true;
        }
        return CFG.core.getProv(nProvinceID).getRevRisk() > 2.0f;
    }

    public final void startUprising() {
        if (ELF) {
            return;
        }
        ArrayList<Integer> tempPossibleUprising = new ArrayList<Integer>();
        ArrayList<Integer> tempPossibleUprising_CheckSuggest = new ArrayList<Integer>();
        ArrayList<Integer> overMin = new ArrayList<Integer>();
        int numOfTrueOwnerProvinces = 0;
        for (int i = 1; i < CFG.core.getCivsSize(); i++) {
            boolean isScheduledTurn = (i % GameValues.gvRebels.UPDATE_IGNITE_EVERY_X_TURNS == GameCalendar.TURNID % GameValues.gvRebels.UPDATE_IGNITE_EVERY_X_TURNS);
            int j;
            Civilization civI = CFG.core.getCiv(i);
            if (civI.getNumOfProvs() <= 0 || CFG.ideologiesMgr.getIdeologyID((int)civI.getIdeology()).CAN_BECOME_CIVILIZED >= 0 || CFG.ideologiesMgr.getIdeologyID((int)civI.getIdeology()).REVOLUTIONARY) continue;

            boolean hasHighRisk = false;
            if (!isScheduledTurn) {
                for (j = 0; j < civI.getNumOfProvs(); ++j) {
                    if (CFG.core.getProv(civI.getProvID(j)).getRevRisk() > 1.0f) {
                        hasHighRisk = true;
                        break;
                    }
                }
                if (!hasHighRisk) continue;
            }

            tempPossibleUprising.clear();
            tempPossibleUprising_CheckSuggest.clear();
            overMin.clear();
            numOfTrueOwnerProvinces = 0;
            for (j = 0; j < civI.getNumOfProvs(); ++j) {
                Province provinceJ = CFG.core.getProv(civI.getProvID(j));
                if (provinceJ.getCivId() != provinceJ.getTrueOwnerOfProv()) continue;
                ++numOfTrueOwnerProvinces;
                if (!(provinceJ.getRevRisk() > 1.0f) || provinceJ.isCapital()) continue;
                float modRisk = this.getModifiedRevolutionsRisk(civI.getProvID(j));
                float threshold = 1.0f;

                if (modRisk > threshold && (modRisk > 0.8f || CFG.oR.nextInt((int)(modRisk * 100.0f)) > GameValues.gvRebels.START_UPRAISE_IGNITE_RANDOM_CHANCE_100)) {
                    if (this.canAnyCivUpraise(civI.getProvID(j))) {
                        tempPossibleUprising.add(civI.getProvID(j));
                    } else {
                        tempPossibleUprising_CheckSuggest.add(civI.getProvID(j));
                    }
                }
                overMin.add(civI.getProvID(j));
            }
            if (tempPossibleUprising.isEmpty() && !tempPossibleUprising_CheckSuggest.isEmpty()) {
                block4: for (j = tempPossibleUprising_CheckSuggest.size() - 1; j >= 0; --j) {
                    try {
                        if (!FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "suggested_owners/" + tempPossibleUprising_CheckSuggest.get(j)).exists()) continue;
                        FileHandle file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "suggested_owners/" + tempPossibleUprising_CheckSuggest.get(j));
                        String sOwners = file.readString();
                        String[] sRes = sOwners.split(";");
                        for (int k = 0; k < sRes.length; k += 2) {
                            boolean canBeAdded = true;
                            int tempIdeologyID = CFG.ideologiesMgr.getIdeologyID(sRes[k]);
                            if (CFG.ideologiesMgr.getIdeologyID((int)tempIdeologyID).REVOLUTIONARY || CFG.ideologiesMgr.getIdeologyID((int)tempIdeologyID).AVAILABLE_SINCE_AGE_ID > GameCalendar.CURRENT_AGEID) continue;
                            String realTag = CFG.ideologiesMgr.getRealTag(sRes[k]);
                            for (int o = 0; o < CFG.core.getCivsSize(); ++o) {
                                if (!CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(o).getCivTag()).equals(realTag)) continue;
                                canBeAdded = false;
                                break;
                            }
                            if (!canBeAdded) continue;
                            tempPossibleUprising.add((Integer)tempPossibleUprising_CheckSuggest.get(j));
                            continue block4;
                        }
                        continue;
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
            }
            if (tempPossibleUprising.isEmpty() && overMin.isEmpty()) continue;
            this.spawnRevolution(i, tempPossibleUprising, overMin, numOfTrueOwnerProvinces);
        }
        tempPossibleUprising.clear();
        tempPossibleUprising = null;
        tempPossibleUprising_CheckSuggest.clear();
        tempPossibleUprising_CheckSuggest = null;
        overMin.clear();
        overMin = null;
    }

    public final float getModifiedRevolutionsRisk(int nProvinceID) {
        float risk = CFG.core.getProv(nProvinceID).getRevRisk();
        if (risk > 1.0f) { return risk * 2.0f; } 
        return risk * (1.0f + (float)CFG.core.getProv(nProvinceID).getCores().getCivsSize() * GameValues.gvRebels.PROVINCE_REVOLT_RISK_PER_CORE_MODIFIER) - (float)CFG.core.getProvinceArmy(nProvinceID) / (float)CFG.core.getProv(nProvinceID).getPop().getPops() * GameValues.gvRebels.PROVINCE_REVOLT_RISK_ARMY_PER_POP_REDUCTION;
    }

    public final void spawnRevolution(int nCivID, List<Integer> nProvinces, List<Integer> nOverMin, int numOfTrueOwnerProvinces) {
        try {
            int j;
            int i;
            ArrayList<Integer> tempSorted = new ArrayList<Integer>();
            while (nProvinces.size() > 0) {
                int tBest = 0;
                for (int i2 = nProvinces.size() - 1; i2 > 0; --i2) {
                    if (!(CFG.core.getProv(nProvinces.get(i2)).getRevRisk() > CFG.core.getProv(nProvinces.get(tBest)).getRevRisk())) continue;
                    tBest = i2;
                }
                tempSorted.add(nProvinces.get(tBest));
                nProvinces.remove(tBest);
            }

            
            String nRevTag = CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(nCivID).getCivTag()) + CFG.ideologiesMgr.getIdeologyID(CFG.ideologiesMgr.REBELS_ID).getExtraTag();
            int revoltCivID = -1;
            for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.core.getCiv(i).getIdeology() != CFG.ideologiesMgr.REBELS_ID || !this.getSpawnRebels_CivRebelsTag(i).equals(nRevTag)) continue;
                if (CFG.core.getCiv(i).getNumOfProvs() == 0) {
                    revoltCivID = i;
                    continue;
                }

                
                if (CFG.core.getCiv(i).getNumOfProvs() > 0) {
                    CFG.core.getCiv(i).civGD.iTurnsSinceLastAttack = 100;
                    for (j = 0; j < tempSorted.size(); ++j) {
                        int theBestProvinceID = tempSorted.get(j);
                        long nArmy0 = CFG.core.getProv(theBestProvinceID).getArmyID(0);
                        if (nArmy0 > 0) {
                            long rebelArmy = this.getRevolutionaryArmySize(theBestProvinceID, nCivID, i);
                            if (rebelArmy < nArmy0) {
                                continue;
                            }
                        }
                        CFG.core.getProv(theBestProvinceID).setCivId(i, false, true);
                        this.updateProvinceAfterRevolution(theBestProvinceID);
                        this.spawnRevolutionaryArmy(theBestProvinceID, nCivID, i);
                    }
                    return;
                }
            }

            if (revoltCivID <= 0) {
                for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                    if (CFG.core.getCiv(i).getIdeology() != CFG.ideologiesMgr.REBELS_ID || CFG.core.getCiv(i).getNumOfProvs() != 0) continue;
                    revoltCivID = i;
                    break;
                }
            }

            if (!tempSorted.isEmpty()) {
                this.spawnRevolutionInProvinceID(nCivID, revoltCivID, tempSorted.get(0), tempSorted, nOverMin);
            }
        }
        catch (Exception exr) {
            CFG.exceptionStack(exr);
        }
    }

    public final boolean hasArmyInProvince_AllianceID(int nProvinceID, int nAllianceID) {
        if (nAllianceID == 0) {
            return false;
        }
        for (int i = 0; i < CFG.core.getProv(nProvinceID).getCivsSize(); ++i) {
            if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId(i)).getAlliance() != nAllianceID) continue;
            return true;
        }
        return false;
    }

    public final boolean isMovingArmyFromProvince(int nProvinceID) {
        return this.isMovingArmyFromProvince(nProvinceID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
    }

    public final void spawnRevolution_UpdateCivData(int nCivID, int nRebelsCivID, String nRevTag) {
        if (nRebelsCivID < 0) {
            return;
        }
        CFG.core.getCiv(nRebelsCivID).civGD.iTurnsSinceLastAttack = 100;
        CFG.core.getCiv(nRebelsCivID).setCivTag(nRevTag);
        Color nColor = CFG.getRandomColor();
        CFG.core.getCiv(nRebelsCivID).setR((int)(nColor.r * 255.0f));
        CFG.core.getCiv(nRebelsCivID).setG((int)(nColor.g * 255.0f));
        CFG.core.getCiv(nRebelsCivID).setB((int)(nColor.b * 255.0f));
        if (CFG.core.getCiv(nRebelsCivID).getGold() < (long)GameValues.gvRebels.UPRAISE_GOLD_MIN) {
            CFG.core.getCiv(nRebelsCivID).setGold(GameValues.gvRebels.UPRAISE_GOLD_MIN);
        }
        CFG.core.getCiv(nRebelsCivID).setCivName(CFG.lang.get("Rebels"));
        CFG.core.getCiv(nRebelsCivID).setTechLevel(CFG.core.getCiv(nCivID).getTechLevel() * (GameValues.gvRebels.UPRAISE_TECH_LEVEL_BASE + (float)CFG.oR.nextInt(GameValues.gvRebels.UPRAISE_TECH_LEVEL_RANDOM_1000) / 1000.0f));
        CFG.core.getCiv(nRebelsCivID).setModifier_MilitaryUpkeep(-0.9f);
        CFG.core.declareWar(nRebelsCivID, nCivID, true);
    }

    public final void spawnRevolutionaryArmy(int nProvinceID, int nCivID, int nRebelsCivID) {
        long nArmy = Math.max(50, (long)((float)CFG.core.getProv(nProvinceID).getPop().getPops() * 0.10f));
        CFG.core.getProv(nProvinceID).updateArmy4(nRebelsCivID, nArmy);
        CFG.core.getCiv(nRebelsCivID).setNumberOfUnits(CFG.core.getCiv(nRebelsCivID).getNumberOfUnits() + nArmy);
    }

    public final long getRevolutionaryArmySize(int nProvinceID, int nCivID, int nRebelsCivID) {
        long nArmy = Math.max(50, (long)((float)CFG.core.getProv(nProvinceID).getPop().getPops() * 0.10f));
        return nArmy;
    }

    public final void updateProvinceAfterRevolution(int nProvinceID) {
        CFG.core.getProv(nProvinceID).setRevRisk(GameValues.gvRebels.UPRAISE_REBELS_PROVINCES_REV_RISK);
        CFG.core.getProv(nProvinceID).setHappi(CFG.core.getProv(nProvinceID).getHappi() * (GameValues.gvRebels.UPRAISE_REBELS_PROVINCE_HAPPINESS_BASE + (float)CFG.oR.nextInt(GameValues.gvRebels.UPRAISE_REBELS_PROVINCE_HAPPINESS_RANDOM_1000) / 1000.0f));
        CFG.core.getProv(nProvinceID).setEco((long)((double)CFG.core.getProv(nProvinceID).getEco() * (double)(GameValues.gvRebels.UPRAISE_REBELS_PROVINCE_ECONOMY_BASE - (float)CFG.oR.nextInt(GameValues.gvRebels.UPRAISE_REBELS_PROVINCE_ECONOMY_RANDOM_1000_MINUS) / 1000.0f)));
        CFG.core.getProv(nProvinceID).setDevLvl(CFG.core.getProv(nProvinceID).getDeveLvl() * (GameValues.gvRebels.UPRAISE_REBELS_PROVINCE_DEVELOPMENT_BASE - (float)CFG.oR.nextInt(GameValues.gvRebels.UPRAISE_REBELS_PROVINCE_DEVELOPMENT_RANDOM_1000_MINUS) / 1000.0f));
        if (CFG.core.getProv(nProvinceID).getLvlOfLibrary() > 0 && CFG.oR.nextInt(100) < GameValues.gvRebels.UPRAISE_DESTROY_LIBRARY_IN_PROVINCE_CHANCE) {
            CFG.core.getProv(nProvinceID).setLvlOfLibrary(0);
        }
        this.updateMetCivilization(nProvinceID);
    }

    public final void moveRegroupArmy() {
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            try {
                CFG.core.getCiv(i).moveRegroupArmy();
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    private final void migrateFromTo(int nCivID, int fromProvinceID, int toProvinceID) {
        block17: {
            try {
                int j;
                CivInvest tInvest;
                CivTask tAssimilate;
                Civilization civ = CFG.core.getCiv(nCivID);
                Province provinceFrom = CFG.core.getProv(fromProvinceID);
                Province provinceTo = CFG.core.getProv(toProvinceID);
                if (provinceFrom.getCivId() != nCivID) break block17;
                if (!Core.uncivilizedCanMigrate(toProvinceID, nCivID)) break block17;
                ArrayList<Integer> tCivs = new ArrayList<Integer>();
                ArrayList<Long> tArmies = new ArrayList<Long>();
                for (int j2 = 0; j2 < provinceFrom.getCivsSize(); ++j2) {
                    tCivs.add(provinceFrom.getCivId(j2));
                    tArmies.add(provinceFrom.getArmyID(j2));
                }
                CivTask tFestival = civ.isFestivalOrganized_GET(fromProvinceID);
                if (tFestival != null) {
                    civ.removeFestival_ProvinceID(fromProvinceID);
                }
                if ((tAssimilate = civ.isAssimilateOrganized_GET(fromProvinceID)) != null) {
                    civ.removeAssimilate_ProvinceID(fromProvinceID);
                }
                if ((tInvest = civ.isInvestOrganized_GET(fromProvinceID)) != null) {
                    civ.removeInvest_ProvinceID(fromProvinceID);
                }
                long tNeutral = provinceTo.getArmyID(0);
                for (j = provinceFrom.getCivsSize() - 1; j >= 0; --j) {
                    provinceFrom.updateArmy4(provinceFrom.getCivId(j), 0);
                }
                for (j = provinceTo.getCivsSize() - 1; j >= 0; --j) {
                    provinceTo.updateArmy4(provinceTo.getCivId(j), 0);
                }
                provinceFrom.setTrueOwnerOfProv(nCivID);
                provinceTo.setCivId(nCivID, false);
                provinceFrom.setTrueOwnerOfProv(0);
                provinceFrom.setCivId(0, false);
                if (civ.getCapitalProvID() == fromProvinceID) {
                    provinceTo.setIsCapital(true);
                    provinceFrom.setIsCapital(false);
                    civ.setCapitalProvID(toProvinceID);
                    try {
                        provinceFrom.getCit(0).setCityLevel(CFG.getEditorCityLevel(3));
                    }
                    catch (Exception j3) {
                        
                    }
                    try {
                        provinceTo.getCit(0).setCityLevel(CFG.getEditorCityLevel(0));
                    }
                    catch (Exception j3) {
                        
                    }
                }
                provinceFrom.setDrawCitiesInProv(false);
                provinceTo.setDrawCitiesInProv(true);
                Province_Population tempD = provinceTo.getPop();
                provinceTo.setPopsData(provinceFrom.getPop());
                provinceFrom.setPopsData(tempD);
                int tData = (int)provinceTo.getEco();
                provinceTo.setEco(provinceFrom.getEco());
                provinceFrom.setEco(tData);
                float fData = provinceTo.getHappi();
                provinceTo.setHappi(provinceFrom.getHappi());
                provinceFrom.setHappi(fData);
                long tDataLong = provinceTo.provGD.startingPopulation;
                provinceTo.provGD.startingPopulation = provinceFrom.provGD.startingPopulation;
                provinceFrom.provGD.startingPopulation = tDataLong;
                tDataLong = provinceTo.provGD.startingEconomy;
                provinceTo.provGD.startingEconomy = provinceFrom.provGD.startingEconomy;
                provinceFrom.provGD.startingEconomy = tDataLong;
                fData = provinceTo.getDeveLvl();
                provinceTo.setDevLvl(provinceFrom.getDeveLvl());
                provinceFrom.setDevLvl(fData);
                if (tFestival != null) {
                    tFestival.iProvinceID = toProvinceID;
                    civ.addFestival(tFestival);
                }
                if (tAssimilate != null) {
                    tAssimilate.iProvinceID = toProvinceID;
                    civ.addAssimilate(tAssimilate);
                }
                if (tInvest != null) {
                    tInvest.provinceID = toProvinceID;
                    civ.addInvest(tInvest);
                }
                for (int j4 = 0; j4 < tCivs.size(); ++j4) {
                    provinceTo.updateArmy4(((Number)tCivs.get(j4)).intValue(), ((Number)tArmies.get(j4)).longValue());
                }
                provinceFrom.updateArmy4(0, tNeutral);
                provinceTo.incomeTaxation = provinceFrom.incomeTaxation;
                provinceTo.incomeProduction = provinceFrom.incomeProduction;
                provinceTo.administrationCost = provinceFrom.administrationCost;
                provinceFrom.getCores().resetOwnership(nCivID);
                provinceTo.getCores().resetOwnership(nCivID);
                provinceFrom.updateDrawArmyInProv();
                provinceTo.updateDrawArmyInProv();
                TechManager.updateCivs_ResearchProgress_Migrate(nCivID, toProvinceID);
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    private final boolean turnMoves_IsACombatMove(int nCivID, int toProvinceID) {
        if (nCivID != CFG.core.getProv(toProvinceID).getCivId() && nCivID != CFG.core.getCiv(CFG.core.getProv(toProvinceID).getCivId()).getPuppetOfCiv() && CFG.core.getProv(toProvinceID).getCivId() != CFG.core.getCiv(nCivID).getPuppetOfCiv() && CFG.core.getMilitaryAccess(nCivID, CFG.core.getProv(toProvinceID).getCivId()) == 0 && (CFG.core.getCiv(nCivID).getAlliance() <= 0 || CFG.core.getCiv(nCivID).getAlliance() != CFG.core.getCiv(CFG.core.getProv(toProvinceID).getCivId()).getAlliance())) {
            return true;
        }
        for (int i = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivsSize() - 1; i > 0; --i) {
            if (!CFG.core.getCivsAtWar(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i))) continue;
            return true;
        }
        return false;
    }

    private final void turnMoves_UpdatePlayersFogOfWar(int nCivID) {
        if (CFG.core.getCiv(nCivID).getIsPlayer() && CFG.PLAYER_TURN_ID != CFG.core.getPlayerIDbyCivID(nCivID)) {
            CFG.PLAYER_TURN_ID = CFG.core.getPlayerIDbyCivID(nCivID);
            if (CFG.FOG_OF_WAR > 0) {
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    CFG.core.getProv(i).updateDrawArmyInProv();
                }
            }
            if (this.getNumOfPlayersInGame() > 1) {
                CFG.menus.updateInGame_Top_All_NextTurnActions(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            }
        }
    }

    public final float getCivOffensiveBonus(int nCivID, int toProvinceID) {
        float fBest = CFG.core.getCiv(nCivID).getModifier_AttackBonus();
        fBest += this.getAttackersBonusFromTechnology(nCivID) / 100.0f;
        if (CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getCivId() == nCivID) {
             fBest += (float)GameValues.gvCapital.BONUS_CAPITAL_ATTACK_FROM_CAPITAL / 100.0f;
        }
        return fBest;
    }

    public final float getCivDefensiveBonus(int nCivID, int toProvinceID) {
        float fOffensiveArmyModifiers = (float)CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv(nCivID).getIdeology()).DEFENSE_BONUS / 100.0f;
        if (CFG.core.getProv(toProvinceID).isCapital()) {
            fOffensiveArmyModifiers += (float)GameValues.gvCapital.BONUS_CAPITAL_DEFENSE / 100.0f;
        }
        fOffensiveArmyModifiers += (float)BuildingsManager.getFort_DefenseBonus(CFG.core.getProv(toProvinceID).getLvlOfFort()) / 100.0f;
        fOffensiveArmyModifiers += this.diceRollBonus(true) / 100.0f;
        fOffensiveArmyModifiers += (float)BuildingsManager.getTower_DefenseBonus(CFG.core.getProv(toProvinceID).getLvlOfWatchTower()) / 100.0f;
        if (CFG.terrainTypesManager.getDefense(CFG.core.getProv(toProvinceID).getTerrainTypeID()) > 0.0f) {
            fOffensiveArmyModifiers += CFG.terrainTypesManager.getDefense(CFG.core.getProv(toProvinceID).getTerrainTypeID());
        }
        fOffensiveArmyModifiers += this.getDefenseBonusFromTechnology(nCivID) / 100.0f;
        return fOffensiveArmyModifiers += CFG.core.getCiv(nCivID).getModifier_DefenseBonus();
    }

    private final void turnMoves_MoveCurrentArmy() {
        try {
            int toProvID = this.currentMoveUnits.getMoveUnits(0).getToProvID();
            int fromProvID = this.currentMoveUnits.getMoveUnits(0).getFromProviID();
            int currentCivID = this.currentMoveUnits.getCivID(0);
            Province toProv = CFG.core.getProv(toProvID);
            Province fromProv = CFG.core.getProv(fromProvID);
            long tArmy = 0L;
            long tArmy2 = 0L;
            long tArmy3 = 0L;
            long tArmyTrue = 0L;
            long tArmyTrueOwner = 0L;

            CFG.menus.setVisible_InGame_Dices(false);
            if (this.currentMoveUnits.getCivID(0) != CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId() && this.currentMoveUnits.getCivID(0) != CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId()).getPuppetOfCiv() && CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId() != CFG.core.getCiv(this.currentMoveUnits.getCivID(0)).getPuppetOfCiv() && !CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getSeaProv()) {
                if (CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId() > 0 && (CFG.core.getCivsInAlliance(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId()) || CFG.core.getMilitaryAccess(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId()) > 0)) {
                    block41: for (int i = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivsSize() - 1; i > 0; --i) {
                        long losses;
                        if (!CFG.core.getCivsAtWar(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i)) || (losses = Math.min(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i), this.currentMoveUnits.getMoveUnits_TotalNumOfUnits())) <= 0) continue;
                        int tWarID = CFG.core.getWarID(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i));
                        long tempArmy = Math.min(losses, CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i));
                        if (tWarID >= 0) {
                            try {
                                CFG.core.getProv((int)this.currentMoveUnits.getMoveUnits((int)0).getToProvID()).provGD.totalCasualtiesInProvince += tempArmy;
                                CFG.core.getWar(tWarID).addCasualties(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i), tempArmy);
                            }
                            catch (Exception exception) {
                                
                            }
                        }
                        CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i) - losses);
                        for (int j = 0; j < this.currentMoveUnits.getMoveUnitsSize(); ++j) {
                            if (this.currentMoveUnits.getMoveUnits(j).getNumberOfUnits() <= 0) continue;
                            tempArmy = Math.min(this.currentMoveUnits.getMoveUnits(j).getNumberOfUnits(), losses);
                            if (tWarID >= 0) {
                                CFG.core.getWar(tWarID).addCasualties(this.currentMoveUnits.getCivID(j), tempArmy);
                            }
                            CFG.core.getProv((int)this.currentMoveUnits.getMoveUnits((int)j).getToProvID()).provGD.totalCasualtiesInProvince += tempArmy;
                            this.currentMoveUnits.getMoveUnits(j).setNumberOfUnits(Math.max(this.currentMoveUnits.getMoveUnits(j).getNumberOfUnits() - losses, 0));
                            CFG.core.getProv(this.currentMoveUnits.getMoveUnits(j).getFromProviID()).updateArmy4(this.currentMoveUnits.getCivID(j), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(j).getFromProviID()).getArmyCivID1(this.currentMoveUnits.getCivID(j)) - losses);
                            if ((losses -= tempArmy) <= 0) continue block41;
                        }
                    }
                    this.turnMoves_MoveCurrentArmy_JustMove();
                } else {
                    try {
                        if (CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId() != 0 && !CFG.core.getCivsAtWar(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId())) {
                            int tNumOfCivs = 1;
                            for (int c = 1; c < this.currentMoveUnits.getMoveUnitsSize(); ++c) {
                                if (this.currentMoveUnits.getCivID(0) == this.currentMoveUnits.getCivID(c)) continue;
                                ++tNumOfCivs;
                                break;
                            }
                            if (tNumOfCivs == 1) {
                                this.turnMoves_MoveCurrentArmy_JustMove();
                                this.currentMoveUnits = null;
                                return;
                            }
                            if (!CFG.core.isAlly(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId())) {
                                CFG.core.declareWar(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(), false);
                            }
                        }
                        if (this.SHOW_REPORT) {
                            CFG.reportData = new Report_Data();
                            CFG.reportData.iBattleOfProvinceID = this.currentMoveUnits.getMoveUnits(0).getToProvID();
                        }
                        if (this.SAVE_REPORT) {
                            this.battleReportSave = new Report_Data();
                            this.battleReportSave.iBattleOfProvinceID = this.currentMoveUnits.getMoveUnits(0).getToProvID();
                        }
                        long tempNumOfUnits = 0;
                        for (int i = 0; i < this.currentMoveUnits.getMoveUnitsSize(); ++i) {
                            tempNumOfUnits += this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits();
                        }
                        long tempPopulationBefore = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getPop().getPops();
                        long tempEconomyBefore = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getEco();
                        if (CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId() == 0) {
                            this.updatePopulationLosses(this.currentMoveUnits.getMoveUnits(0).getToProvID(), (int)Math.min((float)tempNumOfUnits * GameValues.gvBattle.BATTLE_PROVINCE_POPULATION_LOSSES_BASE, (float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getPop().getPops() * GameValues.gvBattle.BATTLE_PROVINCE_POPULATION_LOSSES_OR_BASED_ON_POPULATION_PERC));
                            CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateProvinceEconomyLosses(tempNumOfUnits, GameValues.gvBattle.BATTLE_PROVINCE_ECONOMY_LOSSES_UNITS);
                        } else {
                            this.updatePopulationLosses(this.currentMoveUnits.getMoveUnits(0).getToProvID(), (int)Math.min((float)tempNumOfUnits * (GameValues.gvBattle.BATTLE_PROVINCE_POPULATION_LOSSES_BASE + GameValues.gvBattle.BATTLE_PROVINCE_POPULATION_LOSSES_TECH_LEVEL_MODIFIER * CFG.core.getCiv(this.currentMoveUnits.getCivID(0)).getTechLevel()), (float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getPop().getPops() * GameValues.gvBattle.BATTLE_PROVINCE_POPULATION_LOSSES_OR_BASED_ON_POPULATION_PERC));
                            CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateProvinceEconomyLosses(tempNumOfUnits, GameValues.gvBattle.BATTLE_PROVINCE_ECONOMY_LOSSES_UNITS);
                        }
                        if (this.SHOW_REPORT) {
                            CFG.reportData.iPopulationLosses = tempPopulationBefore - CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getPop().getPops();
                            CFG.reportData.iEconomyLosses = tempEconomyBefore - CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getEco();
                        }
                        if (this.SAVE_REPORT) {
                            this.battleReportSave.iPopulationLosses = tempPopulationBefore - CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getPop().getPops();
                            this.battleReportSave.iEconomyLosses = tempEconomyBefore - CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getEco();
                        }
                        int tempWarID = CFG.core.getWarID(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId());
                        CFG.core.updateWarStatistics(tempWarID, this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(), tempPopulationBefore - CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getPop().getPops(), tempEconomyBefore - CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getEco());
                        CFG.core.addArmyExperience(this.currentMoveUnits.getCivID(0), 1.0f);
                        CFG.core.addArmyExperience(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0), 1.0f);
                        if (this.turnMoves_MoveCurrentArmy_AttackResult(this.currentMoveUnits.getMoveUnits(0).getToProvID(), tempNumOfUnits)) {
                            int i;
                        long attackersArmy = tempNumOfUnits;
                        long defendersArmy = this.turnMoves_MoveCurrentArmy_Attack_NumOfDefeningUnits(this.currentMoveUnits.getMoveUnits(0).getToProvID());
                            CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).setWasAttacked(GameValues.gvAiProvince.PROVINCE_WAS_ATTACKED_TURNS);
                            attackersArmy = (long)Math.ceil(attackersArmy);
                            defendersArmy = (long)Math.ceil((float)defendersArmy * (1.0f - this.turnMoves_MoveCurrentArmy_Attack_DefensiveModifiers(this.currentMoveUnits.getMoveUnits(0).getToProvID()) + this.turnMoves_MoveCurrentArmy_Attack_OffensiveModifiers(this.currentMoveUnits.getMoveUnits(0).getToProvID())));
                            if (CFG.settingsGD.EXPERIMENTAL_BATTLE_SYSTEM && attackersArmy > 0 && defendersArmy > 0) {
                                float ratio = (float)attackersArmy / (float)defendersArmy;
                                defendersArmy = (int)((float)defendersArmy / Math.max(1.0f, ratio));
                            }
                            CFG.core.updateWarStatistics_Casualties(tempWarID, this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0));
                            try {
                                CFG.core.getProv((int)this.currentMoveUnits.getMoveUnits((int)0).getToProvID()).provGD.totalCasualtiesInProvince += CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0);
                            }
                            catch (Exception exception) {
                                
                            }
                            if (this.SHOW_REPORT) {
                                CFG.reportData.attackersWon = true;
                                CFG.reportData.lDefenders_IDs.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0));
                                CFG.reportData.lDefenders_Armies.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0));
                                CFG.reportData.lDefenders_ArmiesLost.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0));
                                CFG.SFXManager.playSound(CFG.SFXManager.playMoveArmy());
                            }
                            if (this.SAVE_REPORT) {
                                this.battleReportSave.attackersWon = true;
                                this.battleReportSave.lDefenders_IDs.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0));
                                this.battleReportSave.lDefenders_Armies.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0));
                                this.battleReportSave.lDefenders_ArmiesLost.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0));
                            }
                            if (CFG.settingsGD.BAT_PLUS) {
                                long defCivID = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0);
                                long defArmy = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0);
                                float ratio = (float)defArmy / Math.max(1.0f, (float)attackersArmy);
                                float lossRate = Math.min(0.60f, 0.30f / Math.max(0.3f, ratio));
                                long defenderCasualties = Math.max(1L, Math.min(defArmy, (long)Math.ceil((double)defArmy * (double)lossRate)));
                                long defenderSurvivors = defArmy - defenderCasualties;
                                CFG.core.getCiv((int)defCivID).setNumberOfUnits(CFG.core.getCiv((int)defCivID).getNumberOfUnits() - defArmy);
                                if (defenderSurvivors > 0) {
                                    this.armyRetreat_Strategic(this.currentMoveUnits.getMoveUnits(0).getToProvID(), (int)defCivID, defenderSurvivors);
                                }
                            } else {
                                this.armyRetreat(this.currentMoveUnits.getMoveUnits(0).getToProvID(), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0));
                                CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0)).setNumberOfUnits(CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0)).getNumberOfUnits() - CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0));
                            }
                            CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(0);
                            int i2 = 1;
                            for (int iBreak = 0; i2 < CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivsSize() && iBreak < 50; ++iBreak) {
                                if (this.shouldDeclareWarForDefenderArmy(this.currentMoveUnits.getMoveUnits(0).getToProvID(), this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i2))) {
                                    CFG.core.declareWar(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i2), false);
                                }
                                CFG.core.updateWarStatistics_Casualties(tempWarID, this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i2), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i2));
                                try {
                                    CFG.core.getProv((int)this.currentMoveUnits.getMoveUnits((int)0).getToProvID()).provGD.totalCasualtiesInProvince += CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i2);
                                }
                                catch (Exception exception) {
                                    
                                }
                                if (this.SHOW_REPORT && (CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i2) > 0 || CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivsSize() == 1)) {
                                    CFG.reportData.lDefenders_IDs.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i2));
                                    CFG.reportData.lDefenders_Armies.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i2));
                                    CFG.reportData.lDefenders_ArmiesLost.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i2));
                                }
                                if (this.SAVE_REPORT && (CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i2) > 0 || CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivsSize() == 1)) {
                                    this.battleReportSave.lDefenders_IDs.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i2));
                                    this.battleReportSave.lDefenders_Armies.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i2));
                                    this.battleReportSave.lDefenders_ArmiesLost.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i2));
                                }
                                if (CFG.settingsGD.BAT_PLUS) {
                                    long allyDefCivID = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i2);
                                    long allyDefArmy = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i2);
                                    float ratio = (float)allyDefArmy / Math.max(1.0f, (float)attackersArmy);
                                    float lossRate = Math.min(0.60f, 0.30f / Math.max(0.3f, ratio));
                                    long allyDefenderCasualties = Math.max(1L, Math.min(allyDefArmy, (long)Math.ceil((double)allyDefArmy * (double)lossRate)));
                                    long allyDefenderSurvivors = allyDefArmy - allyDefenderCasualties;
                                    CFG.core.getCiv((int)allyDefCivID).setNumberOfUnits(CFG.core.getCiv((int)allyDefCivID).getNumberOfUnits() - allyDefArmy);
                                    if (allyDefenderSurvivors > 0) {
                                        this.armyRetreat_Strategic(this.currentMoveUnits.getMoveUnits(0).getToProvID(), (int)allyDefCivID, allyDefenderSurvivors);
                                    }
                                } else {
                                    this.armyRetreat(this.currentMoveUnits.getMoveUnits(0).getToProvID(), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i2), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i2));
                                    CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i2)).setNumberOfUnits(CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i2)).getNumberOfUnits() - CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i2));
                                }
                                CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i2), 0);
                            }
                            ArrayList<Integer> tempAttackersCivID = new ArrayList<Integer>();
                            ArrayList<Long> tempAttackersArmy = new ArrayList<Long>();
                            for (i = 0; i < this.currentMoveUnits.getMoveUnitsSize(); ++i) {
                                boolean tempAdd = true;
                                for (int j = 0; j < tempAttackersCivID.size(); ++j) {
                                    if (tempAttackersCivID.get(j).equals(this.currentMoveUnits.getCivID(i))) {
                                        tempAdd = false;
                                        tempAttackersArmy.set(j, (Long)tempAttackersArmy.get(j) + (long)this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits());
                                        break;
                                    }
                                }
                                if (tempAdd) {
                                    tempAttackersCivID.add(this.currentMoveUnits.getCivID(i));
                                    tempAttackersArmy.add((long)this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits());
                                }
                                CFG.core.getProv(this.currentMoveUnits.getMoveUnits(i).getFromProviID()).updateArmy4(this.currentMoveUnits.getCivID(i), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(i).getFromProviID()).getArmyCivID1(this.currentMoveUnits.getCivID(i)) - this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits());
                            }
                            if (tempAttackersCivID.size() > 1) {
                                int iSize2 = tempAttackersCivID.size();
                                for (i = 0; i < iSize2 - 1; ++i) {
                                    int tempBiggestArmyID = i;
                                    for (int j = i + 1; j < iSize2; ++j) {
                                    if (((Number)tempAttackersArmy.get(tempBiggestArmyID)).longValue() >= ((Number)tempAttackersArmy.get(j)).longValue()) continue;
                                        tempBiggestArmyID = j;
                                    }
                                    if (tempBiggestArmyID == i) continue;
                                    int tempC = ((Number)tempAttackersCivID.get(i)).intValue();
                                    long tempA = ((Number)tempAttackersArmy.get(i)).longValue();
                                    tempAttackersCivID.set(i, (Integer)tempAttackersCivID.get(tempBiggestArmyID));
                                    tempAttackersArmy.set(i, (Long)tempAttackersArmy.get(tempBiggestArmyID));
                                    tempAttackersCivID.set(tempBiggestArmyID, tempC);
                                    tempAttackersArmy.set(tempBiggestArmyID, tempA);
                                }
                                CFG.core.updateWarStatistics_Casualties(tempWarID, CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0), ((Number)tempAttackersCivID.get(0)).intValue(), Math.max(0L, ((Number)tempAttackersArmy.get(0)).longValue() - (long)Math.ceil((double)((Long)tempAttackersArmy.get(0)).longValue() / (double)tempNumOfUnits * (double)(attackersArmy - defendersArmy))));
                                try {
                                    CFG.core.getProv((int)this.currentMoveUnits.getMoveUnits((int)0).getToProvID()).provGD.totalCasualtiesInProvince += Math.max(0L, ((Number)tempAttackersArmy.get(0)).longValue() - (long)Math.ceil((double)((Long)tempAttackersArmy.get(0)).longValue() / (double)tempNumOfUnits * (double)(attackersArmy - defendersArmy)));
                                }
                                catch (Exception ex) {
                                    
                                }
                                if (this.SHOW_REPORT) {
                                    CFG.reportData.lAttackers_IDs.add((Integer)tempAttackersCivID.get(0));
                                    CFG.reportData.lAttackers_Armies.add((Long)tempAttackersArmy.get(0));
                                    CFG.reportData.lAttackers_Armies_Lost.add((Long)tempAttackersArmy.get(0) - (long)Math.ceil((double)((Long)tempAttackersArmy.get(0)).longValue() / (double)tempNumOfUnits * (double)(attackersArmy - defendersArmy)));
                                }
                                if (this.SAVE_REPORT) {
                                    this.battleReportSave.lAttackers_IDs.add((Integer)tempAttackersCivID.get(0));
                                    this.battleReportSave.lAttackers_Armies.add((Long)tempAttackersArmy.get(0));
                                    this.battleReportSave.lAttackers_Armies_Lost.add((Long)tempAttackersArmy.get(0) - (long)Math.ceil((double)((Long)tempAttackersArmy.get(0)).longValue() / (double)tempNumOfUnits * (double)(attackersArmy - defendersArmy)));
                                }
                                this.armyRetreat(this.currentMoveUnits.getMoveUnits(0).getToProvID(), (Integer)tempAttackersCivID.get(0), (Long)tempAttackersArmy.get(0) - (long)Math.ceil((double)((Long)tempAttackersArmy.get(0)).longValue() / (double)tempNumOfUnits * (double)(attackersArmy - defendersArmy)));
                                CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4((long)Math.ceil((double)((Long)tempAttackersArmy.get(0)).longValue() / (double)tempNumOfUnits * (double)(attackersArmy - defendersArmy)));
                                CFG.core.getCiv((Integer)tempAttackersCivID.get(0)).setNumberOfUnits(CFG.core.getCiv((Integer)tempAttackersCivID.get(0)).getNumberOfUnits() - Math.min((Long)tempAttackersArmy.get(0), (Long)tempAttackersArmy.get(0) - (long)Math.ceil((double)((Long)tempAttackersArmy.get(0)).longValue() / (double)tempNumOfUnits * (double)(attackersArmy - defendersArmy))));
                                for (int i4 = 1; i4 < tempAttackersCivID.size(); ++i4) {
                                    if ((int)CFG.core.getCivRelationOfCivB((Integer)tempAttackersCivID.get(i4), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0)) != GameValues.gvDiplomacy.RELATION_AT_WAR && !CFG.core.isAlly((Integer)tempAttackersCivID.get(i4), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0))) {
                                        CFG.core.declareWar((Integer)tempAttackersCivID.get(i4), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0), false);
                                    }
                                    CFG.core.updateWarStatistics_Casualties(tempWarID, CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0), (Integer)tempAttackersCivID.get(i4), Math.max(0, (Long)tempAttackersArmy.get(i4) - (long)Math.floor((double)((Long)tempAttackersArmy.get(i4)).longValue() / (double)tempNumOfUnits * (double)(attackersArmy - defendersArmy))));
                                    try {
                                        CFG.core.getProv((int)this.currentMoveUnits.getMoveUnits((int)0).getToProvID()).provGD.totalCasualtiesInProvince += Math.max(0, (Long)tempAttackersArmy.get(i4) - (long)Math.floor((double)((Long)tempAttackersArmy.get(i4)).longValue() / (double)tempNumOfUnits * (double)(attackersArmy - defendersArmy)));
                                    }
                                    catch (Exception ex3) {
                                        
                                    }
                                    if (this.SHOW_REPORT) {
                                        CFG.reportData.lAttackers_IDs.add((Integer)tempAttackersCivID.get(i4));
                                        CFG.reportData.lAttackers_Armies.add((Long)tempAttackersArmy.get(i4));
                                        CFG.reportData.lAttackers_Armies_Lost.add(tempAttackersArmy.get(i4) - (long)Math.floor((double)tempAttackersArmy.get(i4) / (double)tempNumOfUnits * (double)(attackersArmy - defendersArmy)));
                                    }
                                    if (this.SAVE_REPORT) {
                                        this.battleReportSave.lAttackers_IDs.add((Integer)tempAttackersCivID.get(i4));
                                        this.battleReportSave.lAttackers_Armies.add((Long)tempAttackersArmy.get(i4));
                                        this.battleReportSave.lAttackers_Armies_Lost.add(tempAttackersArmy.get(i4) - (long)Math.floor((double)tempAttackersArmy.get(i4) / (double)tempNumOfUnits * (double)(attackersArmy - defendersArmy)));
                                    }
                                    this.armyRetreat(this.currentMoveUnits.getMoveUnits(0).getToProvID(), tempAttackersCivID.get(i4), tempAttackersArmy.get(i4) - (long)Math.floor((double)tempAttackersArmy.get(i4) / (double)tempNumOfUnits * (double)(attackersArmy - defendersArmy)));
                                    CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(tempAttackersCivID.get(i4), (long)Math.floor((double)tempAttackersArmy.get(i4) / (double)tempNumOfUnits * (double)(attackersArmy - defendersArmy)));
                                    CFG.core.getCiv(tempAttackersCivID.get(i4)).setNumberOfUnits(CFG.core.getCiv(tempAttackersCivID.get(i4)).getNumberOfUnits() - Math.min(tempAttackersArmy.get(i4), tempAttackersArmy.get(i4) - (long)Math.floor((double)tempAttackersArmy.get(i4) / (double)tempNumOfUnits * (double)(attackersArmy - defendersArmy))));
                                }
                                if (CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv() > 0 && CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getProv((int)this.currentMoveUnits.getMoveUnits((int)0).getToProvID()).getCivId()).getIdeology()).REVOLUTIONARY) {
                                    if (CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv() != this.currentMoveUnits.getCivID(0) && !CFG.core.getCivsAtWar(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv(), this.currentMoveUnits.getCivID(0))) {
                                        tArmy = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0);
                                        tArmyTrueOwner = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyCivID1(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv());
                                        int tTrueOwner = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv();
                                        CFG.core.updateWarStatistics_ConqueredProvinces(tempWarID, CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv(), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0));
                                        CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).setCivId(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv(), true);
                                        CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(0);
                                        CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(tTrueOwner, tArmyTrueOwner);
                                        CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(this.currentMoveUnits.getCivID(0), tArmy);
                                        if (this.currentMoveUnits.getMoveUnits(0).getToProvID() == CFG.core.getActiveProvID()) {
                                            this.updateInGame_ProvinceInfo();
                                        }
                                    } else {
                                        CFG.core.updateWarStatistics_ConqueredProvinces(tempWarID, CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv(), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0));
                                        CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).setCivId(this.currentMoveUnits.getCivID(0), true);
                                        if (this.currentMoveUnits.getMoveUnits(0).getToProvID() == CFG.core.getActiveProvID()) {
                                            this.updateInGame_ProvinceInfo();
                                        }
                                    }
                                } else if (CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv() < 1 || CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv() == ((Integer)tempAttackersCivID.get(0)).intValue()) {
                                    CFG.core.updateWarStatistics_ConqueredProvinces(tempWarID, (Integer)tempAttackersCivID.get(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0));
                                    CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).setCivId((Integer)tempAttackersCivID.get(0), true);
                                    if (this.currentMoveUnits.getMoveUnits(0).getToProvID() == CFG.core.getActiveProvID()) {
                                        this.updateInGame_ProvinceInfo();
                                    }
                                } else if (CFG.core.getCivsAtWar(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv(), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId()) && (CFG.core.getCivsAreAllied((Integer)tempAttackersCivID.get(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv()) || CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv()).getPuppetOfCiv() == ((Integer)tempAttackersCivID.get(0)).intValue() || CFG.core.getCivsAreAllied(CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv()).getPuppetOfCiv(), (Integer)tempAttackersCivID.get(0)) || CFG.core.getCiv((Integer)tempAttackersCivID.get(0)).getPuppetOfCiv() == CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv() || CFG.core.getCivsAreAllied(CFG.core.getCiv((Integer)tempAttackersCivID.get(0)).getPuppetOfCiv(), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv()))) {
                                    tArmy = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0);
                                    tArmyTrue = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyCivID1(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv());
                                    CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(0);
                                    CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv(), 0);
                                    CFG.core.updateWarStatistics_ConqueredProvinces(tempWarID, CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv(), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0));
                                    CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).setCivId(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv(), true);
                                    CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv(), tArmyTrue);
                                    CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(this.currentMoveUnits.getCivID(0), tArmy);
                                    if (this.currentMoveUnits.getMoveUnits(0).getToProvID() == CFG.core.getActiveProvID()) {
                                        this.updateInGame_ProvinceInfo();
                                    }
                                } else {
                                    int i5;
                                    boolean ownerChanged = false;
                                    for (i5 = 0; i5 < CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCores().getCivsSize(); ++i5) {
                                        if (CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCores().getCivID(i5) != ((Integer)tempAttackersCivID.get(0)).intValue()) continue;
                                        CFG.core.updateWarStatistics_ConqueredProvinces(tempWarID, (Integer)tempAttackersCivID.get(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0));
                                        CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).setCivId((Integer)tempAttackersCivID.get(0), true);
                                        ownerChanged = true;
                                        if (this.currentMoveUnits.getMoveUnits(0).getToProvID() != CFG.core.getActiveProvID()) break;
                                        this.updateInGame_ProvinceInfo();
                                        break;
                                    }
                                    if (!ownerChanged) {
                                        for (i5 = 0; i5 < CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCores().getCivsSize(); ++i5) {
                                            if (!CFG.core.getCivsAtWar(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCores().getCivID(i5), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId()) || !CFG.core.getCivsAreAllied((Integer)tempAttackersCivID.get(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCores().getCivID(i5)) && CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCores().getCivID(i5)).getPuppetOfCiv() != ((Integer)tempAttackersCivID.get(0)).intValue() && !CFG.core.getCivsAreAllied(CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCores().getCivID(i5)).getPuppetOfCiv(), (Integer)tempAttackersCivID.get(0)) && CFG.core.getCiv((Integer)tempAttackersCivID.get(0)).getPuppetOfCiv() != CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCores().getCivID(i5) && !CFG.core.getCivsAreAllied(CFG.core.getCiv((Integer)tempAttackersCivID.get(0)).getPuppetOfCiv(), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCores().getCivID(i5))) continue;
                                            tArmy2 = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0);
                                            tArmyTrue = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyCivID1(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv());
                                            CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(0);
                                            CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv(), 0);
                                            CFG.core.updateWarStatistics_ConqueredProvinces(tempWarID, CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCores().getCivID(i5), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0));
                                            CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).setCivId(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCores().getCivID(i5), true);
                                            CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv(), tArmyTrue);
                                            CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(this.currentMoveUnits.getCivID(0), tArmy2);
                                            ownerChanged = true;
                                            if (this.currentMoveUnits.getMoveUnits(0).getToProvID() != CFG.core.getActiveProvID()) break;
                                            this.updateInGame_ProvinceInfo();
                                            break;
                                        }
                                    }
                                    if (!ownerChanged) {
                                        CFG.core.updateWarStatistics_ConqueredProvinces(tempWarID, (Integer)tempAttackersCivID.get(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0));
                                        CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).setCivId((Integer)tempAttackersCivID.get(0), true);
                                        if (this.currentMoveUnits.getMoveUnits(0).getToProvID() == CFG.core.getActiveProvID()) {
                                            this.updateInGame_ProvinceInfo();
                                        }
                                    }
                                }
                            } else {
                                int i6;
                                long tempDefendersArmyLeft = defendersArmy;
                                for (i6 = 0; i6 < this.currentMoveUnits.getMoveUnitsSize(); ++i6) {
                                    CFG.core.updateWarStatistics_Casualties(tempWarID, CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0), this.currentMoveUnits.getCivID(i6), this.currentMoveUnits.getMoveUnits(i6).getNumberOfUnits() > tempDefendersArmyLeft ? tempDefendersArmyLeft : this.currentMoveUnits.getMoveUnits(i6).getNumberOfUnits());
                                    try {
                                        CFG.core.getProv((int)this.currentMoveUnits.getMoveUnits((int)0).getToProvID()).provGD.totalCasualtiesInProvince = CFG.core.getProv((int)this.currentMoveUnits.getMoveUnits((int)0).getToProvID()).provGD.totalCasualtiesInProvince + Math.max(0, this.currentMoveUnits.getMoveUnits(i6).getNumberOfUnits() > tempDefendersArmyLeft ? tempDefendersArmyLeft : this.currentMoveUnits.getMoveUnits(i6).getNumberOfUnits());
                                    }
                                    catch (Exception ex) {
                                        
                                    }
                                    if ((tempDefendersArmyLeft -= this.currentMoveUnits.getMoveUnits(i6).getNumberOfUnits()) >= 0) continue;
                                    tempDefendersArmyLeft = 0;
                                }
                                if (this.SHOW_REPORT) {
                                    tempDefendersArmyLeft = defendersArmy;
                                    for (i6 = 0; i6 < this.currentMoveUnits.getMoveUnitsSize(); ++i6) {
                                        CFG.reportData.lAttackers_IDs.add(this.currentMoveUnits.getCivID(i6));
                                        CFG.reportData.lAttackers_Armies.add(this.currentMoveUnits.getMoveUnits(i6).getNumberOfUnits());
                                        CFG.reportData.lAttackers_Armies_Lost.add(this.currentMoveUnits.getMoveUnits(i6).getNumberOfUnits() > tempDefendersArmyLeft ? tempDefendersArmyLeft : this.currentMoveUnits.getMoveUnits(i6).getNumberOfUnits());
                                        if ((tempDefendersArmyLeft -= this.currentMoveUnits.getMoveUnits(i6).getNumberOfUnits()) >= 0) continue;
                                        tempDefendersArmyLeft = 0;
                                    }
                                }
                                if (this.SAVE_REPORT) {
                                    tempDefendersArmyLeft = defendersArmy;
                                    for (i6 = 0; i6 < this.currentMoveUnits.getMoveUnitsSize(); ++i6) {
                                        this.battleReportSave.lAttackers_IDs.add(this.currentMoveUnits.getCivID(i6));
                                        this.battleReportSave.lAttackers_Armies.add(this.currentMoveUnits.getMoveUnits(i6).getNumberOfUnits());
                                        this.battleReportSave.lAttackers_Armies_Lost.add(this.currentMoveUnits.getMoveUnits(i6).getNumberOfUnits() > tempDefendersArmyLeft ? tempDefendersArmyLeft : this.currentMoveUnits.getMoveUnits(i6).getNumberOfUnits());
                                        if ((tempDefendersArmyLeft -= this.currentMoveUnits.getMoveUnits(i6).getNumberOfUnits()) >= 0) continue;
                                        tempDefendersArmyLeft = 0;
                                    }
                                }
                                this.armyRetreat(this.currentMoveUnits.getMoveUnits(0).getToProvID(), this.currentMoveUnits.getCivID(0), defendersArmy);
                                CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(attackersArmy - defendersArmy);
                                CFG.core.getCiv(this.currentMoveUnits.getCivID(0)).setNumberOfUnits(CFG.core.getCiv(this.currentMoveUnits.getCivID(0)).getNumberOfUnits() - defendersArmy);
                                if (CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv() > 0 && CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getProv((int)this.currentMoveUnits.getMoveUnits((int)0).getToProvID()).getCivId()).getIdeology()).REVOLUTIONARY) {
                                    if (CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv() != this.currentMoveUnits.getCivID(0) && !CFG.core.getCivsAtWar(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv(), this.currentMoveUnits.getCivID(0))) {
                                        tArmy = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0);
                                        tArmyTrueOwner = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyCivID1(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv());
                                        CFG.core.updateWarStatistics_ConqueredProvinces(tempWarID, CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv(), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0));
                                        CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).setCivId(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv(), true);
                                        CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(tArmyTrueOwner);
                                        CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(this.currentMoveUnits.getCivID(0), tArmy);
                                        if (this.currentMoveUnits.getMoveUnits(0).getToProvID() == CFG.core.getActiveProvID()) {
                                            this.updateInGame_ProvinceInfo();
                                        }
                                    } else {
                                        CFG.core.updateWarStatistics_ConqueredProvinces(tempWarID, CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv(), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0));
                                        CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).setCivId(this.currentMoveUnits.getCivID(0), true);
                                        if (this.currentMoveUnits.getMoveUnits(0).getToProvID() == CFG.core.getActiveProvID()) {
                                            this.updateInGame_ProvinceInfo();
                                        }
                                    }
                                } else if (CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv() < 1 || CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv() == this.currentMoveUnits.getCivID(0)) {
                                    CFG.core.updateWarStatistics_ConqueredProvinces(tempWarID, this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0));
                                    CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).setCivId(this.currentMoveUnits.getCivID(0), true);
                                    if (this.currentMoveUnits.getMoveUnits(0).getToProvID() == CFG.core.getActiveProvID()) {
                                        this.updateInGame_ProvinceInfo();
                                    }
                                } else if (CFG.core.getCivsAtWar(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv(), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId()) && (CFG.core.getCivsAreAllied(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv()) || CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv()).getPuppetOfCiv() == this.currentMoveUnits.getCivID(0) || CFG.core.getCivsAreAllied(CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv()).getPuppetOfCiv(), this.currentMoveUnits.getCivID(0)) || CFG.core.getCiv(this.currentMoveUnits.getCivID(0)).getPuppetOfCiv() == CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv() || CFG.core.getCivsAreAllied(CFG.core.getCiv(this.currentMoveUnits.getCivID(0)).getPuppetOfCiv(), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv()))) {
                                    tArmy = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0);
                                    CFG.core.updateWarStatistics_ConqueredProvinces(tempWarID, CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv(), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0));
                                    CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).setCivId(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getTrueOwnerOfProv(), true);
                                    CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(0);
                                    CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(this.currentMoveUnits.getCivID(0), tArmy);
                                    if (this.currentMoveUnits.getMoveUnits(0).getToProvID() == CFG.core.getActiveProvID()) {
                                        this.updateInGame_ProvinceInfo();
                                    }
                                } else {
                                    int i7;
                                    boolean ownerChanged = false;
                                    for (i7 = 0; i7 < CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCores().getCivsSize(); ++i7) {
                                        if (CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCores().getCivID(i7) != this.currentMoveUnits.getCivID(0)) continue;
                                        CFG.core.updateWarStatistics_ConqueredProvinces(tempWarID, this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0));
                                        CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).setCivId(this.currentMoveUnits.getCivID(0), true);
                                        ownerChanged = true;
                                        if (this.currentMoveUnits.getMoveUnits(0).getToProvID() != CFG.core.getActiveProvID()) break;
                                        this.updateInGame_ProvinceInfo();
                                        break;
                                    }
                                    if (!ownerChanged) {
                                        for (i7 = 0; i7 < CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCores().getCivsSize(); ++i7) {
                                            if (!CFG.core.getCivsAtWar(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCores().getCivID(i7), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId()) || !CFG.core.getCivsAreAllied(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCores().getCivID(i7)) && CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCores().getCivID(i7)).getPuppetOfCiv() != this.currentMoveUnits.getCivID(0) && !CFG.core.getCivsAreAllied(CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCores().getCivID(i7)).getPuppetOfCiv(), this.currentMoveUnits.getCivID(0)) && CFG.core.getCiv(this.currentMoveUnits.getCivID(0)).getPuppetOfCiv() != CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCores().getCivID(i7) && !CFG.core.getCivsAreAllied(CFG.core.getCiv(this.currentMoveUnits.getCivID(0)).getPuppetOfCiv(), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCores().getCivID(i7))) continue;
                                            tArmy3 = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0);
                                            CFG.core.updateWarStatistics_ConqueredProvinces(tempWarID, CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCores().getCivID(i7), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0));
                                            CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).setCivId(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCores().getCivID(i7), true);
                                            CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(0);
                                            CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(this.currentMoveUnits.getCivID(0), tArmy3);
                                            ownerChanged = true;
                                            if (this.currentMoveUnits.getMoveUnits(0).getToProvID() != CFG.core.getActiveProvID()) break;
                                            this.updateInGame_ProvinceInfo();
                                            break;
                                        }
                                    }
                                    if (!ownerChanged) {
                                        CFG.core.updateWarStatistics_ConqueredProvinces(tempWarID, this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0));
                                        CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).setCivId(this.currentMoveUnits.getCivID(0), true);
                                        if (this.currentMoveUnits.getMoveUnits(0).getToProvID() == CFG.core.getActiveProvID()) {
                                            this.updateInGame_ProvinceInfo();
                                        }
                                    }
                                }
                                }
                            } else {
                            if (this.SHOW_REPORT) {
                                CFG.reportData.attackersWon = false;
                            }
                            if (this.SAVE_REPORT) {
                                this.battleReportSave.attackersWon = false;
                            }
                            CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).setWasAttacked(GameValues.gvAiProvince.PROVINCE_WAS_ATTACKED_TURNS);
                        long attackersArmy = tempNumOfUnits;
                        long defendersArmy2 = this.turnMoves_MoveCurrentArmy_Attack_NumOfDefeningUnits(this.currentMoveUnits.getMoveUnits(0).getToProvID());
                            int numOfDefenders = this.turnMoves_MoveCurrentArmy_Attack_NumOfDefenders(this.currentMoveUnits.getMoveUnits(0).getToProvID());
                            attackersArmy = (long)Math.ceil((float)attackersArmy * (1.0f - this.turnMoves_MoveCurrentArmy_Attack_OffensiveModifiers(this.currentMoveUnits.getMoveUnits(0).getToProvID()) + this.turnMoves_MoveCurrentArmy_Attack_DefensiveModifiers(this.currentMoveUnits.getMoveUnits(0).getToProvID())));
                            if (CFG.settingsGD.EXPERIMENTAL_BATTLE_SYSTEM && defendersArmy2 > 0 && attackersArmy > 0) {
                                float ratio = (float)defendersArmy2 / (float)attackersArmy;
                                attackersArmy = (long)((float)attackersArmy / Math.max(1.0f, ratio));
                            }
                            if (CFG.settingsGD.BAT_PLUS) {
                                float effectiveRatio = (float)attackersArmy / Math.max(1.0f, (float)defendersArmy2);
                                float diceMod = Math.max(0.65f, Math.min(1.45f, 1.0f + (float)(this.diceDefenders - this.diceAggressors) * 0.025f));
                                float attackerLossRate = Math.min(0.85f, Math.max(0.025f, 0.22f / (float)Math.sqrt(Math.max(0.05f, effectiveRatio)))) * diceMod;
                                float defenderLossRate = Math.min(0.50f, Math.max(0.05f, 0.12f * Math.min(3.0f, effectiveRatio)));
                                long totalAttackerCasualties = Math.max(1L, Math.min(tempNumOfUnits, (long)Math.ceil((double)defendersArmy2 * (double)attackerLossRate)));
                                for (int i8 = 0; i8 < this.currentMoveUnits.getMoveUnitsSize(); ++i8) {
                                    long unitArmy = this.currentMoveUnits.getMoveUnits(i8).getNumberOfUnits();
                                    long unitLosses = Math.max(1L, Math.min(unitArmy, (long)Math.ceil((double)unitArmy / (double)tempNumOfUnits * (double)totalAttackerCasualties)));
                                    CFG.core.updateWarStatistics_Casualties(tempWarID, CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0), this.currentMoveUnits.getCivID(i8), unitLosses);
                                    try {
                                        CFG.core.getProv((int)this.currentMoveUnits.getMoveUnits((int)0).getToProvID()).provGD.totalCasualtiesInProvince += unitLosses;
                                    }
                                    catch (Exception ex) {
                                        
                                    }
                                    if (this.SHOW_REPORT) {
                                        CFG.reportData.lAttackers_IDs.add(this.currentMoveUnits.getCivID(i8));
                                        CFG.reportData.lAttackers_Armies.add(unitArmy);
                                        CFG.reportData.lAttackers_Armies_Lost.add(unitLosses);
                                    }
                                    if (this.SAVE_REPORT) {
                                        this.battleReportSave.lAttackers_IDs.add(this.currentMoveUnits.getCivID(i8));
                                        this.battleReportSave.lAttackers_Armies.add(unitArmy);
                                        this.battleReportSave.lAttackers_Armies_Lost.add(unitLosses);
                                    }
                                    this.armyRetreat(this.currentMoveUnits.getMoveUnits(i8).getToProvID(), this.currentMoveUnits.getCivID(i8), unitLosses);
                                    CFG.core.getProv(this.currentMoveUnits.getMoveUnits(i8).getFromProviID()).updateArmy4(this.currentMoveUnits.getCivID(i8), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(i8).getFromProviID()).getArmyCivID1(this.currentMoveUnits.getCivID(i8)) - unitLosses);
                                    CFG.core.getCiv(this.currentMoveUnits.getCivID(i8)).setNumberOfUnits(CFG.core.getCiv(this.currentMoveUnits.getCivID(i8)).getNumberOfUnits() - unitLosses);
                                }
                            } else {
                                for (int i8 = 0; i8 < this.currentMoveUnits.getMoveUnitsSize(); ++i8) {
                                    CFG.core.updateWarStatistics_Casualties(tempWarID, CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0), this.currentMoveUnits.getCivID(i8), this.currentMoveUnits.getMoveUnits(i8).getNumberOfUnits());
                                    try {
                                        CFG.core.getProv((int)this.currentMoveUnits.getMoveUnits((int)0).getToProvID()).provGD.totalCasualtiesInProvince += this.currentMoveUnits.getMoveUnits(i8).getNumberOfUnits();
                                    }
                                    catch (Exception ex) {
                                        
                                    }
                                    if (this.SHOW_REPORT) {
                                        CFG.reportData.lAttackers_IDs.add(this.currentMoveUnits.getCivID(i8));
                                        CFG.reportData.lAttackers_Armies.add(this.currentMoveUnits.getMoveUnits(i8).getNumberOfUnits());
                                        CFG.reportData.lAttackers_Armies_Lost.add(this.currentMoveUnits.getMoveUnits(i8).getNumberOfUnits());
                                    }
                                    if (this.SAVE_REPORT) {
                                        this.battleReportSave.lAttackers_IDs.add(this.currentMoveUnits.getCivID(i8));
                                        this.battleReportSave.lAttackers_Armies.add(this.currentMoveUnits.getMoveUnits(i8).getNumberOfUnits());
                                        this.battleReportSave.lAttackers_Armies_Lost.add(this.currentMoveUnits.getMoveUnits(i8).getNumberOfUnits());
                                    }
                                    this.armyRetreat(this.currentMoveUnits.getMoveUnits(i8).getToProvID(), this.currentMoveUnits.getCivID(i8), this.currentMoveUnits.getMoveUnits(i8).getNumberOfUnits());
                                    CFG.core.getProv(this.currentMoveUnits.getMoveUnits(i8).getFromProviID()).updateArmy4(this.currentMoveUnits.getCivID(i8), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(i8).getFromProviID()).getArmyCivID1(this.currentMoveUnits.getCivID(i8)) - this.currentMoveUnits.getMoveUnits(i8).getNumberOfUnits());
                                    CFG.core.getCiv(this.currentMoveUnits.getCivID(i8)).setNumberOfUnits(CFG.core.getCiv(this.currentMoveUnits.getCivID(i8)).getNumberOfUnits() - this.currentMoveUnits.getMoveUnits(i8).getNumberOfUnits());
                                }
                            }
                            if (CFG.settingsGD.BAT_PLUS && defendersArmy2 > 0 && attackersArmy > 0) {
                                float localRatio = (float)attackersArmy / Math.max(1.0f, (float)defendersArmy2);
                                float localDefenderLossRate = Math.min(0.50f, Math.max(0.05f, 0.12f * Math.min(3.0f, localRatio)));
                                long maxDefenderLoss = Math.max(1L, (long)Math.ceil((float)defendersArmy2 * localDefenderLossRate));
                                attackersArmy = Math.min(attackersArmy, maxDefenderLoss);
                            }
                            if (numOfDefenders > 1) {
                                int i;
                                CFG.core.updateWarStatistics_Casualties(tempWarID, this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0), (long)Math.ceil((float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0) / (float)defendersArmy2 * (float)attackersArmy));
                                try {
                                    CFG.core.getProv((int)this.currentMoveUnits.getMoveUnits((int)0).getToProvID()).provGD.totalCasualtiesInProvince += (long)Math.ceil((float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0) / (float)defendersArmy2 * (float)attackersArmy);
                                }
                                catch (Exception ex) {
                                    
                                }
                                if (this.SHOW_REPORT) {
                                    CFG.reportData.lDefenders_IDs.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0));
                                    CFG.reportData.lDefenders_Armies.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0));
                                    CFG.reportData.lDefenders_ArmiesLost.add((long)Math.ceil((float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0) / (float)defendersArmy2 * (float)attackersArmy));
                                }
                                if (this.SAVE_REPORT) {
                                    this.battleReportSave.lDefenders_IDs.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0));
                                    this.battleReportSave.lDefenders_Armies.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0));
                                    this.battleReportSave.lDefenders_ArmiesLost.add((long)Math.ceil((float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0) / (float)defendersArmy2 * (float)attackersArmy));
                                }
                                this.armyRetreat(this.currentMoveUnits.getMoveUnits(0).getToProvID(), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0), (long)Math.ceil((float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0) / (float)defendersArmy2 * (float)attackersArmy));
                                CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4((long)((double)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0) - Math.ceil((float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0) / (float)defendersArmy2 * (float)attackersArmy)));
                                CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0)).setNumberOfUnits(CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0)).getNumberOfUnits() - (long)Math.ceil((float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0) / (float)defendersArmy2 * (float)attackersArmy));
                                ArrayList<Integer> tempIDs = new ArrayList<Integer>();
                                ArrayList<Long> tempArmies = new ArrayList<Long>();
                                ArrayList<Long> tempArmies_Lost = new ArrayList<Long>();
                                for (i = 1; i < CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivsSize(); ++i) {
                                    if (!this.turnMoves_MoveCurrentArmy_Attack_NumOfDefendingUnits_IsDefender(this.currentMoveUnits.getMoveUnits(0).getToProvID(), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i))) continue;
                                    if (this.shouldDeclareWarForDefenderArmy(this.currentMoveUnits.getMoveUnits(0).getToProvID(), this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i))) {
                                        CFG.core.declareWar(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i), false);
                                    }
                                    CFG.core.updateWarStatistics_Casualties(tempWarID, this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i), (long)Math.floor((float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i) / (float)defendersArmy2 * (float)attackersArmy));
                                    try {
                                        CFG.core.getProv((int)this.currentMoveUnits.getMoveUnits((int)0).getToProvID()).provGD.totalCasualtiesInProvince += (long)Math.floor((float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i) / (float)defendersArmy2 * (float)attackersArmy);
                                    }
                                    catch (Exception exception) {
                                        
                                    }
                                    if (this.SHOW_REPORT) {
                                        CFG.reportData.lDefenders_IDs.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i));
                                        CFG.reportData.lDefenders_Armies.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i));
                                        CFG.reportData.lDefenders_ArmiesLost.add((long)Math.floor((float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i) / (float)defendersArmy2 * (float)attackersArmy));
                                    }
                                    if (this.SAVE_REPORT) {
                                        this.battleReportSave.lDefenders_IDs.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i));
                                        this.battleReportSave.lDefenders_Armies.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i));
                                        this.battleReportSave.lDefenders_ArmiesLost.add((long)Math.floor((float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i) / (float)defendersArmy2 * (float)attackersArmy));
                                    }
                                    tempIDs.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i));
                                    tempArmies.add((long)((double)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i) - Math.floor((float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i) / (float)defendersArmy2 * (float)attackersArmy)));
                                    tempArmies_Lost.add((long)Math.floor((float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i) / (float)defendersArmy2 * (float)attackersArmy));
                                }
                                for (i = 0; i < tempIDs.size(); ++i) {
                                    CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4((Integer)tempIDs.get(i), (Long)tempArmies.get(i));
                                    CFG.core.getCiv((Integer)tempIDs.get(i)).setNumberOfUnits(CFG.core.getCiv((Integer)tempIDs.get(i)).getNumberOfUnits() - (Long)tempArmies_Lost.get(i));
                                }
                                try {
                                    for (i = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivsSize() - 1; i >= 1; --i) {
                                        if (!this.turnMoves_MoveCurrentArmy_Attack_NumOfDefendingUnits_IsDefender(this.currentMoveUnits.getMoveUnits(0).getToProvID(), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i))) continue;
                                        if (this.shouldDeclareWarForDefenderArmy(this.currentMoveUnits.getMoveUnits(0).getToProvID(), this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i))) {
                                            CFG.core.declareWar(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i), false);
                                        }
                                        CFG.core.updateWarStatistics_Casualties(tempWarID, this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i), (long)Math.floor((float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i) / (float)defendersArmy2 * (float)attackersArmy));
                                        try {
                                            CFG.core.getProv((int)this.currentMoveUnits.getMoveUnits((int)0).getToProvID()).provGD.totalCasualtiesInProvince += (long)Math.floor((float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i) / (float)defendersArmy2 * (float)attackersArmy);
                                        }
                                        catch (Exception exception) {
                                            
                                        }
                                        if (this.SHOW_REPORT) {
                                            CFG.reportData.lDefenders_IDs.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i));
                                            CFG.reportData.lDefenders_Armies.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i));
                                            CFG.reportData.lDefenders_ArmiesLost.add((long)Math.floor((float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i) / (float)defendersArmy2 * (float)attackersArmy));
                                        }
                                        if (this.SAVE_REPORT) {
                                            this.battleReportSave.lDefenders_IDs.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i));
                                            this.battleReportSave.lDefenders_Armies.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i));
                                            this.battleReportSave.lDefenders_ArmiesLost.add((long)Math.floor((float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i) / (float)defendersArmy2 * (float)attackersArmy));
                                        }
                                        this.armyRetreat(this.currentMoveUnits.getMoveUnits(0).getToProvID(), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i), (long)Math.floor((float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i) / (float)defendersArmy2 * (float)attackersArmy));
                                        CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i), (int)((double)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i) - Math.floor((float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i) / (float)defendersArmy2 * (float)attackersArmy)));
                                        CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i)).setNumberOfUnits(CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i)).getNumberOfUnits() - (long)Math.floor((float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i) / (float)defendersArmy2 * (float)attackersArmy));
                                    }
                                }
                                catch (Exception exr) {
                                    CFG.exceptionStack(exr);
                                }
                            } else {
                                CFG.core.updateWarStatistics_Casualties(tempWarID, this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(), attackersArmy);
                                try {
                                    CFG.core.getProv((int)this.currentMoveUnits.getMoveUnits((int)0).getToProvID()).provGD.totalCasualtiesInProvince += attackersArmy;
                                }
                                catch (Exception tempIDs) {
                                    
                                }
                                if (this.SHOW_REPORT) {
                                    CFG.reportData.lDefenders_IDs.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId());
                                    CFG.reportData.lDefenders_Armies.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0));
                                    CFG.reportData.lDefenders_ArmiesLost.add(attackersArmy);
                                }
                                if (this.SAVE_REPORT) {
                                    this.battleReportSave.lDefenders_IDs.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId());
                                    this.battleReportSave.lDefenders_Armies.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0));
                                    this.battleReportSave.lDefenders_ArmiesLost.add(attackersArmy);
                                }
                                CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(0) - attackersArmy);
                                CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId()).setNumberOfUnits(CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId()).getNumberOfUnits() - attackersArmy);
                            }
                        }
                        if (this.SHOW_REPORT) {
                            if (CFG.reportData.getAttackersArmy() > 0 && CFG.reportData.getDefendersArmy() > 0) {
                                CFG.menus.rebuildInGame_Report();
                            }
                            this.SHOW_REPORT = false;
                        }
                        if (this.SAVE_REPORT) {
                            this.battleReports.add(this.battleReportSave);
                            this.battleReportSave = new Report_Data();
                            this.SAVE_REPORT = false;
                        }
                        if (this.iPlayerAttack_ShowArmyInProvinceID >= 0 && this.iPlayerAttack_ShowArmyInProvinceID < CFG.core.getProvinSize()) {
                            CFG.core.getProv(this.iPlayerAttack_ShowArmyInProvinceID).updateFogOfWar(CFG.PLAYER_TURN_ID);
                        }
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
            } else if (CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getSeaProv() && CFG.core.getSeaProvinceAttack(this.currentMoveUnits.getCivID(0), this.currentMoveUnits.getMoveUnits(0).getToProvID())) {
                try {
                    if (this.SHOW_REPORT) {
                        CFG.reportData = new Report_Data();
                        CFG.reportData.iBattleOfProvinceID = this.currentMoveUnits.getMoveUnits(0).getToProvID();
                    }
                    if (this.SAVE_REPORT) {
                        this.battleReportSave = new Report_Data();
                        this.battleReportSave.iBattleOfProvinceID = this.currentMoveUnits.getMoveUnits(0).getToProvID();
                    }
                    long tempNumOfUnits = 0;
                    for (int i = 0; i < this.currentMoveUnits.getMoveUnitsSize(); ++i) {
                        tempNumOfUnits += this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits();
                    }
                    if (this.SHOW_REPORT) {
                        CFG.reportData.iPopulationLosses = 0;
                        CFG.reportData.iEconomyLosses = 0;
                    }
                    if (this.SAVE_REPORT) {
                        this.battleReportSave.iPopulationLosses = 0;
                        this.battleReportSave.iEconomyLosses = 0;
                    }
                    int tempWarID = CFG.core.getWarID(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId());
                    CFG.core.addArmyExperience(this.currentMoveUnits.getCivID(0), 1.0f);
                    CFG.core.addArmyExperience(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(0), 1.0f);
                    if (this.turnMoves_MoveCurrentArmy_AttackResult_SEA(this.currentMoveUnits.getMoveUnits(0).getToProvID(), tempNumOfUnits, this.currentMoveUnits.getCivID(0))) {
                        long defendersArmy = this.turnMoves_MoveCurrentArmy_Attack_NumOfDefeningUnits_SEA(this.currentMoveUnits.getMoveUnits(0).getToProvID(), this.currentMoveUnits.getCivID(0));
                        long attackersArmy = this.currentMoveUnits.getMoveUnits(0).getNumberOfUnits();
                        if (this.SHOW_REPORT) {
                            CFG.reportData.attackersWon = true;
                            CFG.SFXManager.playSound(CFG.SFXManager.playMoveArmy());
                        }
                        if (this.SAVE_REPORT) {
                            this.battleReportSave.attackersWon = true;
                        }
                        for (int i = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivsSize() - 1; i >= 1; --i) {
                            if (!CFG.core.getCivsAtWar(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i))) continue;
                            if (this.SHOW_REPORT) {
                                tempWarID = CFG.core.getWarID(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i));
                                if (tempWarID >= 0) {
                                    CFG.core.updateWarStatistics_Casualties(tempWarID, this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i));
                                    CFG.core.updateWarStatistics_Casualties(tempWarID, CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i), this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i));
                                }
                                try {
                                    CFG.core.getProv((int)this.currentMoveUnits.getMoveUnits((int)0).getToProvID()).provGD.totalCasualtiesInProvince += CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i);
                                }
                                catch (Exception defendersArmy2) {
                                    
                                }
                                CFG.reportData.lDefenders_IDs.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i));
                                CFG.reportData.lDefenders_Armies.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i));
                                CFG.reportData.lDefenders_ArmiesLost.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i));
                            }
                            if (this.SAVE_REPORT) {
                                if (!this.SHOW_REPORT) {
                                    tempWarID = CFG.core.getWarID(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i));
                                    if (tempWarID >= 0) {
                                        CFG.core.updateWarStatistics_Casualties(tempWarID, this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i));
                                        CFG.core.updateWarStatistics_Casualties(tempWarID, CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i), this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i));
                                    }
                                    try {
                                        CFG.core.getProv((int)this.currentMoveUnits.getMoveUnits((int)0).getToProvID()).provGD.totalCasualtiesInProvince += CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i);
                                    }
                                    catch (Exception defendersArmy2) {
                                        
                                    }
                                }
                                this.battleReportSave.lDefenders_IDs.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i));
                                this.battleReportSave.lDefenders_Armies.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i));
                                this.battleReportSave.lDefenders_ArmiesLost.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i));
                            }
                            CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i)).setNumberOfUnits(CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i)).getNumberOfUnits() - CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i));
                            CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).removeArmy_ID(i);
                        }
                        long tempDefendersArmyLeft = defendersArmy;
                        if (this.SHOW_REPORT) {
                            tempDefendersArmyLeft = defendersArmy;
                            for (int i = 0; i < this.currentMoveUnits.getMoveUnitsSize(); ++i) {
                                CFG.reportData.lAttackers_IDs.add(this.currentMoveUnits.getCivID(i));
                                CFG.reportData.lAttackers_Armies.add(this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits());
                                CFG.reportData.lAttackers_Armies_Lost.add(this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits() > tempDefendersArmyLeft ? tempDefendersArmyLeft : this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits());
                                if ((tempDefendersArmyLeft -= this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits()) >= 0) continue;
                                tempDefendersArmyLeft = 0;
                            }
                        }
                        if (this.SAVE_REPORT) {
                            tempDefendersArmyLeft = defendersArmy;
                            for (int i = 0; i < this.currentMoveUnits.getMoveUnitsSize(); ++i) {
                                this.battleReportSave.lAttackers_IDs.add(this.currentMoveUnits.getCivID(i));
                                this.battleReportSave.lAttackers_Armies.add(this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits());
                                this.battleReportSave.lAttackers_Armies_Lost.add(this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits() > tempDefendersArmyLeft ? tempDefendersArmyLeft : this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits());
                                if ((tempDefendersArmyLeft -= this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits()) >= 0) continue;
                                tempDefendersArmyLeft = 0;
                            }
                        }
                        CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getFromProviID()).updateArmy4(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getFromProviID()).getArmyCivID1(this.currentMoveUnits.getCivID(0)) - this.currentMoveUnits.getMoveUnits(0).getNumberOfUnits());
                        CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(this.currentMoveUnits.getCivID(0), attackersArmy - defendersArmy);
                        CFG.core.getCiv(this.currentMoveUnits.getCivID(0)).setNumberOfUnits(CFG.core.getCiv(this.currentMoveUnits.getCivID(0)).getNumberOfUnits() - defendersArmy);
                    } else {
                        int i;
                        long defendersArmy = this.turnMoves_MoveCurrentArmy_Attack_NumOfDefeningUnits_SEA(this.currentMoveUnits.getMoveUnits(0).getToProvID(), this.currentMoveUnits.getCivID(0));
                        long attackersArmy = this.currentMoveUnits.getMoveUnits(0).getNumberOfUnits();
                        if (this.SHOW_REPORT) {
                            CFG.reportData.attackersWon = false;
                            CFG.SFXManager.playSound(CFG.SFXManager.playMoveArmy());
                        }
                        if (this.SAVE_REPORT) {
                            this.battleReportSave.attackersWon = false;
                        }
                        long tempDefendersArmyLeft = attackersArmy;
                        boolean firstCeil = true;
                        for (i = CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivsSize() - 1; i >= 1; --i) {
                            if (!CFG.core.getCivsAtWar(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i))) continue;
                            float tempCurrentLosses = (float)attackersArmy * ((float)CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i) / (float)defendersArmy);
                            long currentLosses = (long)(firstCeil ? Math.ceil(tempCurrentLosses) : Math.floor(tempCurrentLosses));
                            firstCeil = false;
                            if (this.SHOW_REPORT) {
                                tempWarID = CFG.core.getWarID(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i));
                                if (tempWarID >= 0) {
                                    CFG.core.updateWarStatistics_Casualties(tempWarID, this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i), currentLosses);
                                    CFG.core.updateWarStatistics_Casualties(tempWarID, CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i), this.currentMoveUnits.getCivID(0), currentLosses);
                                }
                                try {
                                    CFG.core.getProv((int)this.currentMoveUnits.getMoveUnits((int)0).getToProvID()).provGD.totalCasualtiesInProvince += currentLosses;
                                }
                                catch (Exception exception) {
                                    
                                }
                                CFG.reportData.lDefenders_IDs.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i));
                                CFG.reportData.lDefenders_Armies.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i));
                                CFG.reportData.lDefenders_ArmiesLost.add(currentLosses);
                            }
                            if (this.SAVE_REPORT) {
                                if (!this.SHOW_REPORT) {
                                    tempWarID = CFG.core.getWarID(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i));
                                    if (tempWarID >= 0) {
                                        CFG.core.updateWarStatistics_Casualties(tempWarID, this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i), currentLosses);
                                        CFG.core.updateWarStatistics_Casualties(tempWarID, CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i), this.currentMoveUnits.getCivID(0), currentLosses);
                                    }
                                    try {
                                        CFG.core.getProv((int)this.currentMoveUnits.getMoveUnits((int)0).getToProvID()).provGD.totalCasualtiesInProvince += currentLosses;
                                    }
                                    catch (Exception exception) {
                                        
                                    }
                                }
                                this.battleReportSave.lDefenders_IDs.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i));
                                this.battleReportSave.lDefenders_Armies.add(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i));
                                this.battleReportSave.lDefenders_ArmiesLost.add(currentLosses);
                            }
                            CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i)).setNumberOfUnits(CFG.core.getCiv(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i)).getNumberOfUnits() - currentLosses);
                            CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).updateArmy4(CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getCivId(i), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getToProvID()).getArmyID(i) - currentLosses);
                            if ((tempDefendersArmyLeft -= currentLosses) >= 0) continue;
                            tempDefendersArmyLeft = 0;
                        }
                        if (this.SHOW_REPORT) {
                            tempDefendersArmyLeft = defendersArmy;
                            for (i = 0; i < this.currentMoveUnits.getMoveUnitsSize(); ++i) {
                                CFG.reportData.lAttackers_IDs.add(this.currentMoveUnits.getCivID(i));
                                CFG.reportData.lAttackers_Armies.add(this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits());
                                CFG.reportData.lAttackers_Armies_Lost.add(this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits());
                                if ((tempDefendersArmyLeft -= this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits()) >= 0) continue;
                                tempDefendersArmyLeft = 0;
                            }
                        }
                        if (this.SAVE_REPORT) {
                            tempDefendersArmyLeft = defendersArmy;
                            for (i = 0; i < this.currentMoveUnits.getMoveUnitsSize(); ++i) {
                                this.battleReportSave.lAttackers_IDs.add(this.currentMoveUnits.getCivID(i));
                                this.battleReportSave.lAttackers_Armies.add(this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits());
                                this.battleReportSave.lAttackers_Armies_Lost.add(this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits());
                                if ((tempDefendersArmyLeft -= this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits()) >= 0) continue;
                                tempDefendersArmyLeft = 0;
                            }
                        }
                        CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getFromProviID()).updateArmy4(this.currentMoveUnits.getCivID(0), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(0).getFromProviID()).getArmyCivID1(this.currentMoveUnits.getCivID(0)) - this.currentMoveUnits.getMoveUnits(0).getNumberOfUnits());
                        CFG.core.getCiv(this.currentMoveUnits.getCivID(0)).setNumberOfUnits(CFG.core.getCiv(this.currentMoveUnits.getCivID(0)).getNumberOfUnits() - attackersArmy);
                    }
                    if (this.SHOW_REPORT) {
                        if (CFG.reportData.getAttackersArmy() > 0 && CFG.reportData.getDefendersArmy() > 0) {
                            CFG.menus.rebuildInGame_Report();
                        }
                        this.SHOW_REPORT = false;
                    }
                    if (this.SAVE_REPORT) {
                        this.battleReports.add(this.battleReportSave);
                        this.battleReportSave = new Report_Data();
                        this.SAVE_REPORT = false;
                    }
                    if (this.iPlayerAttack_ShowArmyInProvinceID >= 0 && this.iPlayerAttack_ShowArmyInProvinceID < CFG.core.getProvinSize()) {
                        CFG.core.getProv(this.iPlayerAttack_ShowArmyInProvinceID).updateFogOfWar(CFG.PLAYER_TURN_ID);
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            } else {
                try {
                    this.turnMoves_MoveCurrentArmy_JustMove();
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            this.currentMoveUnits = null;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        catch (StackOverflowError exr) {
            CFG.exceptionStack(exr);
        }
    }

    private final void rollDices() {
        this.diceAggressors = CFG.oR.nextInt(725) % GameValues.gvDices.DICE_AGGRESSOR_RANDOM + 1 + GameValues.gvDices.DICE_AGGRESSOR_BASE;
        this.diceDefenders = CFG.oR.nextInt(600) % GameValues.gvDices.DICE_DEFENDER_RANDOM + 1 + GameValues.gvDices.DICE_DEFENDER_BASE;
    }

    public final float diceRollBonus(boolean defenders) {
        int tDifference;
        int n = tDifference = defenders ? this.diceDefenders - this.diceAggressors : this.diceAggressors - this.diceDefenders;
        if (tDifference > 0) {
            return GameValues.gvDices.DICE_ROLL_BONUS * (float)tDifference;
        }
        return 0.0f;
    }

    public static int getMaxDiplomacyPoints(int civID) {
        return (int)((float)GameValues.gvDiplomacyPoints.MAX_DIPLOMACY_POINTS + (float)GameValues.gvDiplomacyPoints.MAX_DIPLOMACY_POINTS * CFG.core.getCiv(civID).getTechLevel() * GameValues.gvDiplomacy.MAX_DIPLOMACY_POINTS_TECHNOLOGY_MODIFIER_EXTRA);
    }

    private final boolean turnMoves_MoveCurrentArmy_AttackResult(int toProvinceID, long numOfAttackers) {
        long numOfDefenders = this.turnMoves_MoveCurrentArmy_Attack_NumOfDefeningUnits(toProvinceID);
        float fDefensiveArmyModifiers = 1.0f;
        float fOffensiveArmyModifiers = 1.0f;
        fDefensiveArmyModifiers += this.turnMoves_MoveCurrentArmy_Attack_OffensiveModifiers(toProvinceID);
        fOffensiveArmyModifiers += this.turnMoves_MoveCurrentArmy_Attack_DefensiveModifiers(toProvinceID);
        if (fDefensiveArmyModifiers < 0.01f) {
            fDefensiveArmyModifiers = 0.01f;
        }
        if (fOffensiveArmyModifiers < 0.01f) {
            fOffensiveArmyModifiers = 0.01f;
        }
        float modRatio = fOffensiveArmyModifiers / fDefensiveArmyModifiers;
        if (modRatio > 1.9f) {
            fOffensiveArmyModifiers = fDefensiveArmyModifiers * 1.9f;
        } else if (modRatio < 1.0f / 1.9f) {
            fDefensiveArmyModifiers = fOffensiveArmyModifiers * 1.9f;
        }
        if (CFG.settingsGD.BAT_PLUS) {
            float attackerPower = (float)numOfAttackers * fOffensiveArmyModifiers;
            float defenderPower = (float)numOfDefenders * fDefensiveArmyModifiers;
            float powerRatio = attackerPower / Math.max(1.0f, defenderPower);
            if (powerRatio < CFG.settingsGD.BAT_PLUS_BREAKTHROUGH_RATIO) {
                return false;
            }
            float diceMod = 1.0f + (float)(this.diceAggressors - this.diceDefenders) * 0.025f;
            return attackerPower * diceMod > defenderPower;
        }
        return (float)numOfAttackers * fOffensiveArmyModifiers > (float)numOfDefenders * fDefensiveArmyModifiers;
    }

    private final boolean turnMoves_MoveCurrentArmy_AttackResult_SEA(int toProvinceID, long numOfAttackers, int attackersCivID) {
        long numOfDefenders = this.turnMoves_MoveCurrentArmy_Attack_NumOfDefeningUnits_SEA(toProvinceID, attackersCivID);
        return numOfAttackers > numOfDefenders;
    }

    private final long turnMoves_MoveCurrentArmy_Attack_NumOfDefeningUnits(int toProvinceID) {
        long numOfDefenders = CFG.core.getProv(toProvinceID).getArmyID(0);
        for (int i = 1; i < CFG.core.getProv(toProvinceID).getCivsSize(); ++i) {
            if (!this.turnMoves_MoveCurrentArmy_Attack_NumOfDefendingUnits_IsDefender(toProvinceID, CFG.core.getProv(toProvinceID).getCivId(i))) continue;
            numOfDefenders += CFG.core.getProv(toProvinceID).getArmyID(i);
        }
        return numOfDefenders;
    }

    private final long turnMoves_MoveCurrentArmy_Attack_NumOfDefeningUnits_SEA(int toProvinceID, int attackersCivID) {
        int numOfDefenders = 0;
        for (int i = 1; i < CFG.core.getProv(toProvinceID).getCivsSize(); ++i) {
            if (!CFG.core.getCivsAtWar(CFG.core.getProv(toProvinceID).getCivId(i), attackersCivID)) continue;
            numOfDefenders += CFG.core.getProv(toProvinceID).getArmyID(i);
        }
        return numOfDefenders;
    }

    private final int turnMoves_MoveCurrentArmy_Attack_NumOfDefenders(int toProvinceID) {
        int numOfDefenders = 1;
        for (int i = 1; i < CFG.core.getProv(toProvinceID).getCivsSize(); ++i) {
            if (!this.turnMoves_MoveCurrentArmy_Attack_NumOfDefendingUnits_IsDefender(toProvinceID, CFG.core.getProv(toProvinceID).getCivId(i))) continue;
            ++numOfDefenders;
        }
        return numOfDefenders;
    }

    private final boolean turnMoves_MoveCurrentArmy_Attack_NumOfDefendingUnits_IsDefender(int toProvinceID, int nCivID) {
        int provinceCivID = CFG.core.getProv(toProvinceID).getCivId(0);
        return provinceCivID == nCivID || CFG.core.getCiv(nCivID).getPuppetOfCiv() == provinceCivID || CFG.core.getCiv(provinceCivID).getPuppetOfCiv() == nCivID || CFG.core.getCiv(provinceCivID).getAlliance() > 0 && CFG.core.getCiv(provinceCivID).getAlliance() == CFG.core.getCiv(nCivID).getAlliance();
    }

    private final boolean shouldDeclareWarForDefenderArmy(int toProvinceID, int attackerCivID, int defenderCivID) {
        int provinceCivID = CFG.core.getProv(toProvinceID).getCivId(0);
        if (provinceCivID > 0 && defenderCivID > 0 && CFG.core.getCiv(defenderCivID).getPuppetOfCiv() == provinceCivID) {
            return false;
        }
        return (int)CFG.core.getCivRelationOfCivB(attackerCivID, defenderCivID) != GameValues.gvDiplomacy.RELATION_AT_WAR && !CFG.core.isAlly(attackerCivID, defenderCivID);
    }

    public final float getDefenseBonusFromTechnology(int nCivID) {
        float techBonus = nCivID > 0 ? Math.min(CFG.core.getCiv(nCivID).getTechLevel() * (float)CFG.TECHNOLOGY_LEVEL_BONUS_ARMY_DEFENSE, (float)GameValues.gvBattle.TECHNOLOGY_LEVEL_BONUS_ARMY_DEFENSE_LIMIT) + this.getDefenseBonusFromMilitaryExpertise(nCivID) : 0.0f;
        float adminEff = CFG.gameUpdate.getAdministrationEfficiency(nCivID);
        return Math.max(0.0f, techBonus + (adminEff - 0.5f) * 200.0f);
    }

    public final float getDefenseBonusFromMilitaryExpertise(int nCivID) {
        return (float)CFG.core.getCiv((int)nCivID).civGD.armyExpertiseDefense * GameValues.gvMilitary.MILITARY_EXPERTISE_DEFENSE_PER_POINT;
    }

    public final void checkMessagesPauseRTS() {
        if (!CFG.SPECTATOR_MODE) {
            for (int i = 0; i < CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize(); ++i) {
                if (!CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)i).willPauseTheGame && !CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)i).requestsResponse) continue;
                CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)i).willPauseTheGame = false;
                if (RTS.PAUSE) continue;
                RTS.pauseUnpause();
                return;
            }
        }
    }

    public final void nextTurn() {
        this.resetTurnData();
        this.hideAllViews();
        switch (this.activeTurnAction) {
            case INPUT_ORDERS: {
                CFG.core.resetLastActiveProvince();
                if (CFG.core.getPlayersSize() == 1) {
                    this.updatePlayerData();
                    this.endOfInputOrders();
                } else {
                    this.inputOrders();
                }
                return;
            }
            case LOAD_AI_RTO: {
                CFG.menus.updateInGameRTO(false);
                this.turnMoves();
                return;
            }
            case TURN_ACTIONS: {
                this.turnMoves();
                return;
            }
            case LOADING_NEXT_TURN: {
                if (GameValues.gvInGame.USE_NEW_TREAD_TURN_ACTION) {
                    if (this.turnThreadNewTurn != null && !this.turnThreadNewTurn.getProcessTurn()) {
                        this.startNewTurn_End();
                    }
                } else if (this.newTurnT != null && !this.newTurnT.isAlive()) {
                    this.startNewTurn_End();
                }
                return;
            }
        }
    }

    private final void endOfInputOrders() {
        this.aA();
        if (CFG.SANDBOX_MODE) {
            try {
                int playerCivID = CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId();
                if (CFG.core.getCiv(playerCivID).civGD.sandboxMissileSpend > 0) {
                    long income = CFG.gameUpdate.getIncome(playerCivID);
                    long maxSpend = Math.min((long)CFG.core.getCiv(playerCivID).civGD.sandboxMissileSpend, CFG.core.getCiv(playerCivID).getGold());
                    long spent = 0L;
                    while (spent < maxSpend) {
                        long missileCost = age.of.civilizations2.jakowski.lukasz.MapA.MissileManager.calculateMissileCost(playerCivID);
                        if (missileCost <= 0L || spent + missileCost > maxSpend || CFG.core.getCiv(playerCivID).getGold() < missileCost) break;
                        if (age.of.civilizations2.jakowski.lukasz.MapA.MissileManager.buildMissile(playerCivID)) spent += missileCost;
                        else break;
                    }
                }
            } catch (Exception ex) { CFG.exceptionStack(ex); }
        }
        CFG.menus.getInGameProvInfo().getMenuElem(0).setClickable(false);
        this.activeTurnAction = TurnStates.LOAD_AI_RTO;
        if (this.getNumOfPlayersInGame() > 1) {
            CFG.menus.updateInGame_Top_All_NextTurnActions(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        }
        this.eRTO_START = 0;
        this.eRTO_START2 = 0;
        this.eRTO_START3 = 0;
        CFG.core.getRTO().buildRandomOrder();
        CFG.menus.updateInGameRTO(true);
        if (!CFG.getIsDesktop()) {
            Actions.runRevolts();
        }
        if (GameValues.gvInGame.USE_NEW_TREAD_TURN_ACTION) {
            this.turnThreadActions.triggerTurn();
        } else {
            this.actions = new Actions();
            this.actions.start();
        }
    }

    public final void startNewTurn() {
        try {
            Menu_InGame_2.TIME_CONTINUE = -1L;
            CFG.menus.getInGameProvInfo().getMenuElem(0).setClickable(false);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        
        this.activeTurnAction = TurnStates.LOADING_NEXT_TURN;
        if (GameValues.gvInGame.USE_NEW_TREAD_TURN_ACTION) {
            if (this.turnThreadNewTurn == null) {
                this.turnThreadNewTurn = new age.of.civilizations2.jakowski.lukasz.TurnThreads.Turn_ThreadNewTurn();
                this.turnThreadNewTurn.start();
            }
            this.turnThreadNewTurn.triggerTurn();
        } else {
            this.newTurnT = new NewTurn();
            this.newTurnT.start();
        }
    }

    public final void startNewTurn_End() {
        try {
            CFG.PLAYER_TURN_ID = 0;
            CFG.gameAction.loadActivePlayerData();
            this.updatePosOfMap_NewTurn = false;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
            if (CFG.getIsDesktop()) {
                if (GameCalendar.TURNID % GameValues.gvInGame.REBUILD_MINIMAP_EVERY_X_TURNS == 0) {
                    CFG.map.getMpB().disposeMinimapOfCivilizations();
                }
            } else if (GameCalendar.TURNID % GameValues.gvInGame.REBUILD_MINIMAP_EVERY_X_TURNS_MOBILE == 0) {
                CFG.map.getMpB().disposeMinimapOfCivilizations();
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            CFG.menus.getInGameProvInfo().getMenuElem(0).setTextE(CFG.lang.get("NextTurn"));
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        SKIP_ALL_COMBAT_MOVEMENT_ONCE = false;
        try {
            CFG.menus.getInGameProvInfo().getMenuElem(0).setClickable(true);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        CFG.gameAction.setActiveTurnState(TurnStates.INPUT_ORDERS);
        Render.updateDrawMoveUnits();
        CFG.core.updateDrawMoveUnitsArmy();
        Menu_InGame_Messages.START_ANIMATION = true;
        try {
            if (GameCalendar.TURNID % 10000 == 1992 && !CFG.SPECTATOR_MODE) {
                CFG.SFXManager.playSound(SFXManager.SFX_CROW);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            Render.updateRenderer();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        CFG.core.checkProvinceActionMenu();
        CFG.core.runAgeOfChaos();
        CFG.map.getTouchMgr().ueExA();
    }

    public final int moveArmyModifiers_Defenders(int fromProvinceID, int toProvinceID) {
        try {
            Province provinceFrom = CFG.core.getProv(fromProvinceID);
            Province provinceTo = CFG.core.getProv(toProvinceID);
            if (provinceFrom.getCivId() == provinceTo.getCivId() || provinceFrom.getCivId() == CFG.core.getCiv(provinceTo.getCivId()).getPuppetOfCiv() || CFG.core.getCiv(provinceFrom.getCivId()).getPuppetOfCiv() == provinceTo.getCivId() || CFG.core.getMilitaryAccess(provinceFrom.getCivId(), provinceTo.getCivId()) > 0 || CFG.core.getCiv(provinceFrom.getCivId()).getAlliance() > 0 && CFG.core.getCiv(provinceFrom.getCivId()).getAlliance() == CFG.core.getCiv(provinceTo.getCivId()).getAlliance()) {
                return 0;
            }
            float fOut = (float)CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)provinceTo.getCivId()).getIdeology()).DEFENSE_BONUS / 100.0f;
            fOut += this.getDefenseBonusFromTechnology(provinceTo.getCivId()) / 100.0f;
            if (provinceTo.isCapital()) {
                fOut += (float)GameValues.gvCapital.BONUS_CAPITAL_DEFENSE / 100.0f;
            }
            fOut += (float)BuildingsManager.getFort_DefenseBonus(provinceTo.getLvlOfFort()) / 100.0f;
            fOut += (float)BuildingsManager.getTower_DefenseBonus(provinceTo.getLvlOfWatchTower()) / 100.0f;
            fOut += CFG.terrainTypesManager.getDefense(provinceTo.getTerrainTypeID());
            fOut += CFG.core.getCiv(provinceTo.getCivId()).getModifier_DefenseBonus();
            if (provinceTo.getIsNotSuppliedForXTurns() > 0) {
                fOut -= this.getDefenseBonusLossPerTurnForNotSuppliedProvince(toProvinceID);
            }
            return (int)(fOut * 100.0f);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            return 0;
        }
    }

    public final List<MEHover_2E> getMoveArmyModifiers_Defenders_Hover(int fromProvinceID, int toProvinceID) {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        try {
            if (CFG.core.getProv(fromProvinceID).getCivId() != CFG.core.getProv(toProvinceID).getCivId() && CFG.core.getProv(fromProvinceID).getCivId() != CFG.core.getCiv(CFG.core.getProv(toProvinceID).getCivId()).getPuppetOfCiv() && CFG.core.getCiv(CFG.core.getProv(fromProvinceID).getCivId()).getPuppetOfCiv() != CFG.core.getProv(toProvinceID).getCivId() && CFG.core.getMilitaryAccess(CFG.core.getProv(fromProvinceID).getCivId(), CFG.core.getProv(toProvinceID).getCivId()) <= 0 && (CFG.core.getCiv(CFG.core.getProv(fromProvinceID).getCivId()).getAlliance() <= 0 || CFG.core.getCiv(CFG.core.getProv(fromProvinceID).getCivId()).getAlliance() != CFG.core.getCiv(CFG.core.getProv(toProvinceID).getCivId()).getAlliance())) {
                int fTech;
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("BaseValue") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getProv((int)toProvinceID).getCivId()).getIdeology()).DEFENSE_BONUS + "%", CFG.COLOR_POSITIVE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                if (CFG.core.getProv(toProvinceID).isCapital()) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefenseOfTheCapital") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + GameValues.gvCapital.BONUS_CAPITAL_DEFENSE + "%", CFG.COLOR_POSITIVE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if ((fTech = (int)this.getDefenseBonusFromTechnology(CFG.core.getProv(toProvinceID).getCivId())) > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Technology") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + fTech + "%", CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(toProvinceID).getCivId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (BuildingsManager.getFort_DefenseBonus(CFG.core.getProv(toProvinceID).getLvlOfFort()) > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getFort_Name(CFG.core.getProv(toProvinceID).getLvlOfFort())) + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + BuildingsManager.getFort_DefenseBonus(CFG.core.getProv(toProvinceID).getLvlOfFort()) + "%", CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.bFort, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (BuildingsManager.getTower_DefenseBonus(CFG.core.getProv(toProvinceID).getLvlOfWatchTower()) > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get(BuildingsManager.getTower_Name(CFG.core.getProv(toProvinceID).getLvlOfWatchTower())) + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + BuildingsManager.getTower_DefenseBonus(CFG.core.getProv(toProvinceID).getLvlOfWatchTower()) + "%", CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Image(Images.bTower, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getCiv(CFG.core.getProv(toProvinceID).getCivId()).getModifier_DefenseBonus() != 0.0f) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Bonus") + ": "));
                    nData.add(new ME_Hover_2Type_Text((CFG.core.getCiv(CFG.core.getProv(toProvinceID).getCivId()).getModifier_DefenseBonus() > 0.0f ? "+" : "") + (int)(CFG.core.getCiv(CFG.core.getProv(toProvinceID).getCivId()).getModifier_DefenseBonus() * 100.0f) + "%", CFG.core.getCiv(CFG.core.getProv(toProvinceID).getCivId()).getModifier_DefenseBonus() > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(toProvinceID).getCivId(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.terrainTypesManager.getDefense(CFG.core.getProv(toProvinceID).getTerrainTypeID()) != 0.0f) {
                    nData.add(new ME_Hover_2Type_Text(CFG.terrainTypesManager.getName(CFG.core.getProv(toProvinceID).getTerrainTypeID()) + ": "));
                    nData.add(new ME_Hover_2Type_Text((CFG.terrainTypesManager.getDefense(CFG.core.getProv(toProvinceID).getTerrainTypeID()) > 0.0f ? "+" : "") + (int)(CFG.terrainTypesManager.getDefense(CFG.core.getProv(toProvinceID).getTerrainTypeID()) * 100.0f) + "%", CFG.terrainTypesManager.getDefense(CFG.core.getProv(toProvinceID).getTerrainTypeID()) > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Terrain(CFG.core.getProv(toProvinceID).getTerrainTypeID(), CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getProv(toProvinceID).getIsNotSuppliedForXTurns() > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ProvinceIsNotSupplied") + ": "));
                    nData.add(new ME_Hover_2Type_Text("-" + (int)(this.getDefenseBonusLossPerTurnForNotSuppliedProvince(toProvinceID) * 100.0f) + "%", CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Image(Images.skull, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return nElements;
    }

    public final float getAttackersBonusFromTechnology(int nCivID) {
        float techBonus = Math.min(CFG.core.getCiv(nCivID).getTechLevel() * (float)CFG.TECHNOLOGY_LEVEL_BONUS_ARMY_ATTACK, (float)GameValues.gvBattle.TECHNOLOGY_LEVEL_BONUS_ARMY_ATTACK_LIMIT) + this.getAttackBonusFromMilitaryExpertise(nCivID);
        float adminEff = CFG.gameUpdate.getAdministrationEfficiency(nCivID);
        return Math.max(0.0f, techBonus + (adminEff - 0.5f) * 200.0f);
    }

    public final float getAttackBonusFromMilitaryExpertise(int nCivID) {
        return (float)CFG.core.getCiv((int)nCivID).civGD.armyExpertiseAttack * GameValues.gvMilitary.MILITARY_EXPERTISE_ATTACK_PER_POINT;
    }

    public final int moveArmyModifiers_Attackers(int fromProvinceID, int toProvinceID, int iCivID) {
        try {
            if (CFG.core.getProv(fromProvinceID).getCivId() == CFG.core.getProv(toProvinceID).getCivId() || CFG.core.getProv(fromProvinceID).getCivId() == CFG.core.getCiv(CFG.core.getProv(toProvinceID).getCivId()).getPuppetOfCiv() || CFG.core.getCiv(CFG.core.getProv(fromProvinceID).getCivId()).getPuppetOfCiv() == CFG.core.getProv(toProvinceID).getCivId() || CFG.core.getMilitaryAccess(CFG.core.getProv(fromProvinceID).getCivId(), CFG.core.getProv(toProvinceID).getCivId()) > 0 || CFG.core.getCiv(CFG.core.getProv(fromProvinceID).getCivId()).getAlliance() > 0 && CFG.core.getCiv(CFG.core.getProv(fromProvinceID).getCivId()).getAlliance() == CFG.core.getCiv(CFG.core.getProv(toProvinceID).getCivId()).getAlliance()) {
                return 0;
            }
            float fOut = 0.0f;
            if (CFG.core.getProv(fromProvinceID).isCapital()) {
                fOut += (float)GameValues.gvCapital.BONUS_CAPITAL_ATTACK_FROM_CAPITAL / 100.0f;
            }
            fOut += this.getAttackersBonusFromTechnology(iCivID) / 100.0f;
            return (int)((fOut += CFG.core.getCiv(iCivID).getModifier_AttackBonus()) * 100.0f);
        }
        catch (IndexOutOfBoundsException ex) {
            if (CFG.LOGs) {
                CFG.exceptionStack(ex);
            }
            return 0;
        }
    }

    public final List<MEHover_2E> getMoveArmyModifiers_Attackers_Hover(int fromProvinceID, int toProvinceID, int iCivID) {
        ArrayList<MEHover_2E> nElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> nData = new ArrayList<ME_Hover_2Type>();
        try {
            if (CFG.core.getProv(fromProvinceID).getCivId() != CFG.core.getProv(toProvinceID).getCivId() && CFG.core.getProv(fromProvinceID).getCivId() != CFG.core.getCiv(CFG.core.getProv(toProvinceID).getCivId()).getPuppetOfCiv() && CFG.core.getCiv(CFG.core.getProv(fromProvinceID).getCivId()).getPuppetOfCiv() != CFG.core.getProv(toProvinceID).getCivId() && CFG.core.getMilitaryAccess(CFG.core.getProv(fromProvinceID).getCivId(), CFG.core.getProv(toProvinceID).getCivId()) <= 0 && (CFG.core.getCiv(CFG.core.getProv(fromProvinceID).getCivId()).getAlliance() <= 0 || CFG.core.getCiv(CFG.core.getProv(fromProvinceID).getCivId()).getAlliance() != CFG.core.getCiv(CFG.core.getProv(toProvinceID).getCivId()).getAlliance())) {
                int fTech;
                if (CFG.core.getProv(fromProvinceID).isCapital()) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AttackFromCapital") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + GameValues.gvCapital.BONUS_CAPITAL_ATTACK_FROM_CAPITAL + "%", CFG.COLOR_POSITIVE));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if ((fTech = (int)this.getAttackersBonusFromTechnology(iCivID)) > 0) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Technology") + ": "));
                    nData.add(new ME_Hover_2Type_Text("+" + fTech + "%", CFG.COLOR_POSITIVE));
                    nData.add(new ME_Hover_2Type_Flag(iCivID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
                if (CFG.core.getCiv(iCivID).getModifier_AttackBonus() != 0.0f) {
                    nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Bonus") + ": "));
                    nData.add(new ME_Hover_2Type_Text((CFG.core.getCiv(iCivID).getModifier_AttackBonus() > 0.0f ? "+" : "") + (int)(CFG.core.getCiv(iCivID).getModifier_AttackBonus() * 100.0f) + "%", CFG.core.getCiv(iCivID).getModifier_AttackBonus() > 0.0f ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                    nData.add(new ME_Hover_2Type_Flag(iCivID, CFG.PADD, 0));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return nElements;
    }

    public final float turnMoves_MoveCurrentArmy_Attack_OffensiveModifiers(int toProvinceID) {
        float fOffensiveArmyModifiers = (float)CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getProv((int)toProvinceID).getCivId()).getIdeology()).DEFENSE_BONUS / 100.0f;
        if (CFG.core.getProv(toProvinceID).isCapital()) {
            fOffensiveArmyModifiers += (float)GameValues.gvCapital.BONUS_CAPITAL_DEFENSE / 100.0f;
        }
        fOffensiveArmyModifiers += (float)BuildingsManager.getFort_DefenseBonus(CFG.core.getProv(toProvinceID).getLvlOfFort()) / 100.0f;
        fOffensiveArmyModifiers += this.diceRollBonus(true) / 100.0f;
        fOffensiveArmyModifiers += (float)BuildingsManager.getTower_DefenseBonus(CFG.core.getProv(toProvinceID).getLvlOfWatchTower()) / 100.0f;
        if (CFG.terrainTypesManager.getDefense(CFG.core.getProv(toProvinceID).getTerrainTypeID()) > 0.0f) {
            fOffensiveArmyModifiers += CFG.terrainTypesManager.getDefense(CFG.core.getProv(toProvinceID).getTerrainTypeID());
        }
        fOffensiveArmyModifiers += this.getDefenseBonusFromTechnology(CFG.core.getProv(toProvinceID).getCivId()) / 100.0f;
        return fOffensiveArmyModifiers += CFG.core.getCiv(CFG.core.getProv(toProvinceID).getCivId()).getModifier_DefenseBonus();
    }

    public final float getDefenseBonusLossPerTurnForNotSuppliedProvince(int toProvinceID) {
        return Math.min(GameValues.gvProvinceNotSupplied.NOT_SUPPLIED_PROVINCE_DEFENSE_BONUS_DECAY_PER_TURN * (float)CFG.core.getProv(toProvinceID).getIsNotSuppliedForXTurns(), GameValues.gvProvinceNotSupplied.NOT_SUPPLIED_PROVINCE_DEFENSE_BONUS_DECAY_LIMIT);
    }

    public final float getCivAttackBonus(int nCivID, int toProvinceID) {
        float fBest = CFG.core.getCiv(nCivID).getModifier_AttackBonus();
        fBest += this.getAttackersBonusFromTechnology(nCivID) / 100.0f;
        if (CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getCivId() == nCivID) {
             fBest += (float)GameValues.gvCapital.BONUS_CAPITAL_ATTACK_FROM_CAPITAL / 100.0f;
        }
        return fBest;
    }

    public final float turnMoves_MoveCurrentArmy_Attack_DefensiveModifiers(int toProvinceID) {
        int i;
        float fDefensiveArmyModifiers = 0.0f;
        if (CFG.core.getProv(toProvinceID).getIsNotSuppliedForXTurns() > 0) {
            fDefensiveArmyModifiers += this.getDefenseBonusLossPerTurnForNotSuppliedProvince(toProvinceID);
        }
        fDefensiveArmyModifiers += this.diceRollBonus(false) / 100.0f;

        if (this.currentMoveUnits != null) {
            for (int i2 = 0; i2 < this.currentMoveUnits.getMoveUnitsSize(); ++i2) {
                if (!CFG.core.getProv(this.currentMoveUnits.getMoveUnits(i2).getFromProviID()).isCapital()) continue;
                fDefensiveArmyModifiers += (float)GameValues.gvCapital.BONUS_CAPITAL_ATTACK_FROM_CAPITAL / 100.0f;
                break;
            }
            float fBest = 0.0f;
            for (i = 0; i < this.currentMoveUnits.getMoveUnitsSize(); ++i) {
                if (!(CFG.core.getCiv(this.currentMoveUnits.getCivID(i)).getModifier_AttackBonus() > fBest)) continue;
                fBest = CFG.core.getCiv(this.currentMoveUnits.getCivID(i)).getModifier_AttackBonus();
            }
            fDefensiveArmyModifiers += fBest;
            fBest = 0.0f;
            for (i = 0; i < this.currentMoveUnits.getMoveUnitsSize(); ++i) {
                if (!(this.getAttackersBonusFromTechnology(this.currentMoveUnits.getCivID(i)) / 100.0f > fBest)) continue;
                fBest = this.getAttackersBonusFromTechnology(this.currentMoveUnits.getCivID(i)) / 100.0f;
            }
            fDefensiveArmyModifiers += fBest;
        }
        return fDefensiveArmyModifiers;
    }

    private final void turnMoves_MoveCurrentArmy_JustMove() {
        try {
            for (int i = 0; i < this.currentMoveUnits.getMoveUnitsSize(); ++i) {
                CFG.core.getProv(this.currentMoveUnits.getMoveUnits(i).getFromProviID()).updateArmy4(this.currentMoveUnits.getCivID(i), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(i).getFromProviID()).getArmyCivID1(this.currentMoveUnits.getCivID(i)) - this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits());
                CFG.core.getProv(this.currentMoveUnits.getMoveUnits(i).getToProvID()).updateArmy4(this.currentMoveUnits.getCivID(i), CFG.core.getProv(this.currentMoveUnits.getMoveUnits(i).getToProvID()).getArmyCivID1(this.currentMoveUnits.getCivID(i)) + this.currentMoveUnits.getMoveUnits(i).getNumberOfUnits());
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        catch (StackOverflowError exr) {
            CFG.exceptionStack(exr);
        }
    }

    public final void loadActivePlayerData() {
        if (CFG.FOG_OF_WAR > 0) {
            int i;
            if (CFG.FOG_OF_WAR == 2) {
                for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                    CFG.core.getProv(i).updateProvinceBorder();
                }
                Render.updateDrawCivRegionNames_FogOfWar();
            }
            for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                CFG.core.getProv(i).updateDrawArmyInProv();
            }
        }
        CFG.menus.rebuildInGame_Messages();
        CFG.menus.setVisible_Menu_InGame_CurrentWars(true);
        CFG.core.buildMoveUnits_JustDraw_AnotherArmies();
        try {
            if (!CFG.SPECTATOR_MODE && CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getNumOfProvs() == 0 && this.showDefeatView(CFG.PLAYER_TURN_ID) && !gameEnded) {
                CFG.menus.setMenuID(View.eDEFEAT);
                CFG.map.getMpB().updateWorldMap_Shaders();
                CFG.toastM.addM(CFG.lang.get("Defeat"), CFG.COLOR_NEGATIVE_2);
                gameEnded = true;
            } else if (CFG.settingsGD.CONFIRM_NEXT_PLAYER_TURN) {
                CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                if (RTS.isEnabled() && !RTS.PAUSE || CFG.SPECTATOR_MODE || !this.showNextPlayerTurnView_NextTurn()) {
                    Menu_NextPlayerTurn.clickEnd();
                } else {
                    CFG.menus.setMenuIDWithoutAnim(View.eNEXT_PLAYER_TURN);
                    CFG.core.enableDrawCivilizationRegions(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), 0);
                    CFG.map.getMpB().updateWorldMap_Shaders();
                }
                Menu_InGame_Messages.START_ANIMATION = true;
            }
        }
        catch (Exception ex) {
            Menu_NextPlayerTurn.clickEnd();
        }
    }

    public final void checkGameEnd() {
        if (!CFG.SPECTATOR_MODE && !gameEnded) {
            for (int i = CFG.core.getPlayersSize() - 1; i >= 0; --i) {
                int z;
                int numOfProvinces = CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getNumOfProvs();
                for (z = 0; z < CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civGD.iVassalsSize; ++z) {
                    numOfProvinces += CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civGD.vassals.get((int)z).iCivID).getNumOfProvs();
                }
                if (CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getAlliance() > 0) {
                    for (z = 0; z < CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getAlliance()).getCivilizationsSize(); ++z) {
                        if (CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getAlliance()).getCivilization(z) == CFG.core.getPlayer(i).getCivId() || CFG.core.getCiv(CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getAlliance()).getCivilization(z)).getPuppetOfCiv() == CFG.core.getPlayer(i).getCivId()) continue;
                        numOfProvinces += CFG.core.getCiv(CFG.core.getAlliance(CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getAlliance()).getCivilization(z)).getNumOfProvs();
                    }
                }
                if (VictoryManager.VICTORY_LIMIT_OF_TURNS != 0 && VictoryManager.VICTORY_LIMIT_OF_TURNS < GameCalendar.TURNID) {
                    CFG.menus.setMenuID(View.eVICTORY);
                    CFG.map.getMpB().updateWorldMap_Shaders();
                    CFG.toastM.addM("TurnsLimit", CFG.COLOR_POSITIVE);
                    CFG.toastM.setTimeInView(3500);
                    gameEnded = true;
                    continue;
                }
                if (CFG.oAI.PLAYABLE_PROVINCES <= numOfProvinces || (float)CFG.oAI.PLAYABLE_PROVINCES <= (float)numOfProvinces * ((float)VictoryManager.VICTORY_CONTROL_PROVINCES_PERC / 100.0f) || CFG.oAI.NUM_OF_CIVS_IN_THE_GAME < 2) {
                    CFG.menus.setMenuID(View.eVICTORY);
                    CFG.map.getMpB().updateWorldMap_Shaders();
                    gameEnded = true;
                    continue;
                }
                if (!(VictoryManager.VICTORY_TECHNOLOGY > 0.0f)) continue;
                for (z = 1; z < CFG.core.getCivsSize(); ++z) {
                    if (CFG.core.getCiv(z).getNumOfProvs() <= 0 || !(CFG.core.getCiv(z).getTechLevel() >= VictoryManager.VICTORY_TECHNOLOGY)) continue;
                    if (CFG.core.getCiv(z).getIsPlayer()) {
                        CFG.menus.setMenuID(View.eVICTORY);
                        CFG.map.getMpB().updateWorldMap_Shaders();
                        CFG.toastM.addM("Technology: " + VictoryManager.VICTORY_TECHNOLOGY, CFG.COLOR_POSITIVE);
                        CFG.toastM.setTimeInView(3500);
                        gameEnded = true;
                        continue;
                    }
                    CFG.menus.setMenuID(View.eDEFEAT);
                    CFG.map.getMpB().updateWorldMap_Shaders();
                    CFG.toastM.addM("Technology: " + VictoryManager.VICTORY_TECHNOLOGY, CFG.COLOR_NEGATIVE_2);
                    CFG.toastM.setTimeInView(3500);
                    gameEnded = true;
                }
            }
        }
    }

    public final boolean showDefeatView(int nPlayerID) {
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0 || CFG.core.getProv(i).getTrueOwnerOfProv() != CFG.core.getPlayer(nPlayerID).getCivId()) continue;
            return false;
        }
        if (!CFG.core.getPlayer((int)nPlayerID).playerGD.lostNextTurn) {
            CFG.core.getPlayer((int)nPlayerID).playerGD.lostNextTurn = true;
            return false;
        }
        return true;
    }

    public final boolean showNextPlayerTurnView() {
        return CFG.settingsGD.showNextPlayerView || SaveGameManager.gameWillBeSavedInThisTurn() || this.getNumOfPlayersInGame() > 1;
    }

    public final boolean showNextPlayerTurnView_NextTurn() {
        return CFG.settingsGD.showNextPlayerView || SaveGameManager.forceShowNextPlayerTurnView || this.getNumOfPlayersInGame() > 1;
    }

    public int getNumOfPlayersInGame() {
        int out = 0;
        for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
            if (CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getNumOfProvs() <= 0) continue;
            ++out;
        }
        return out;
    }

    public final int gMARY(int nProvinceID) {
        return this.gMARY(nProvinceID, CFG.core.getProv(nProvinceID).getCivId());
    }

    public final boolean controlsArmyInProvince(int nProvinceID, int nCivID) {
        int controlledArmyID = this.getControlledArmyIDInProvince(nProvinceID, nCivID);
        CFG.activeCivilizationArmyID = Math.max(0, controlledArmyID);
        return controlledArmyID >= 0;
    }

    public final int getControlledArmyIDInProvince(int nProvinceID, int nCivID) {
        int bestArmyID = -1;
        long bestArmy = -1L;
        for (int i = 0; i < CFG.core.getProv(nProvinceID).getCivsSize(); ++i) {
            int armyCivID = CFG.core.getProv(nProvinceID).getCivId(i);
            long army = CFG.core.getProv(nProvinceID).getArmyID(i);
            if (army <= 0 || !this.isArmyControlledByCivInProvince(nProvinceID, armyCivID, nCivID)) continue;
            if (bestArmyID >= 0 && army <= bestArmy) continue;
            bestArmyID = i;
            bestArmy = army;
        }
        return bestArmyID;
    }

    public final int getControlledArmyCivIDInProvince(int nProvinceID, int nCivID) {
        int controlledArmyID = this.getControlledArmyIDInProvince(nProvinceID, nCivID);
        if (controlledArmyID >= 0) {
            CFG.activeCivilizationArmyID = controlledArmyID;
            return CFG.core.getProv(nProvinceID).getCivId(controlledArmyID);
        }
        return nCivID;
    }

    public final long getControlledArmySizeInProvince(int nProvinceID, int nCivID) {
        int controlledArmyID = this.getControlledArmyIDInProvince(nProvinceID, nCivID);
        if (controlledArmyID >= 0) {
            return CFG.core.getProv(nProvinceID).getArmyID(controlledArmyID);
        }
        return 0L;
    }

    public final boolean isArmyControlledByCivInProvince(int nProvinceID, int armyCivID, int nCivID) {
        if (armyCivID == nCivID) {
            return true;
        }
        if (armyCivID <= 0 || nCivID <= 0 || CFG.core.getCiv(armyCivID).getPuppetOfCiv() != nCivID) {
            return false;
        }
        if (CFG.core.getProv(nProvinceID).getCivId() == nCivID) {
            return true;
        }
        return CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() == nCivID && !CFG.core.getPlayer(CFG.PLAYER_TURN_ID).playerGD.VASSALS_INDEPENDENT_ARMY;
    }

    public final int getArmyMovementPayerCivID(int fromProvinceID, int armyCivID) {
        int ownerCivID = CFG.core.getProv(fromProvinceID).getCivId();
        if (ownerCivID > 0 && armyCivID > 0 && CFG.core.getCiv(armyCivID).getPuppetOfCiv() == ownerCivID) {
            return ownerCivID;
        }
        return armyCivID;
    }

    public final boolean canColonizieWasteland_Tech(int nProvinceID, int nCivID) {
        if (!GameCalendar.getColonizationOfWastelandIsEnabled()) {
            return false;
        }
        return GameCalendar.getCanColonize_TechLevel(nCivID);
    }

    public final boolean canColonizieNeutral_Tech(int nProvinceID, int nCivID) {
        return GameCalendar.getCanColonize_TechLevel(nCivID);
    }

    public final boolean canColonizieWasteland_BorderOrArmy(int nProvinceID, int nCivID) {
        int j;
        int i;
        Province province = CFG.core.getProv(nProvinceID);
        for (i = 0; i < province.getNeighProvincesSize(); ++i) {
            if (CFG.core.getProv(province.getNeighProvinces(i)).getWastelandLvl() >= 0) continue;
            if (CFG.core.getProv(province.getNeighProvinces(i)).getCivId() == nCivID) {
                return true;
            }
            for (j = 0; j < CFG.core.getProv(province.getNeighProvinces(i)).getCivsSize(); ++j) {
                if (CFG.core.getProv(province.getNeighProvinces(i)).getCivId(j) != nCivID) continue;
                return true;
            }
        }
        for (i = 0; i < province.getNeighSeaProvincesSize(); ++i) {
            for (j = 1; j < CFG.core.getProv(province.getNeighSeaProvinces(i)).getCivsSize(); ++j) {
                if (CFG.core.getProv(province.getNeighSeaProvinces(i)).getCivId(j) != nCivID) continue;
                return true;
            }
        }
        return false;
    }

    public final void resetTurnData() {
        if (TurnStates.INPUT_ORDERS == this.activeTurnAction) {
            CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).iBefore_ActiveProvince = CFG.core.getActiveProvID();
        }
        if (CFG.chooseProvinceMode) {
            CFG.core.resetChooseProvinceData();
        }
        if (CFG.regroupArmyMode) {
            CFG.core.resetRegroupArmy_Data();
        }
    }

    public final void hideAllProvinceActionViews() {
        try {
            CFG.menus.setVisible_InGame_ProvinceMore(false, false);
            CFG.menus.setVisible_InGame_ActionInfo(false);
            CFG.menus.setVisible_InGame_ProvinceAction(false);
            CFG.menus.setVisible_InGame_ProvinceMoveUnits(false);
            CFG.menus.setVisible_InGame_ProviRecruit(false);
            CFG.menus.setVisible_InGame_ProvinceRecruitInstantly(false);
            CFG.menus.setVisible_InGame_ProvinceRegroupArmy(false);
            CFG.menus.setVisible_InGame_ProvinceDisband(false);
            CFG.menus.setVisible_InGame_ProvinceAction_Colonize(false);
            CFG.menus.setVisible_InGame_ProvinceAction_Colonize_TechRequired(false);
            CFG.menus.setVisible_InGame_ProvinceAction_Nuke(false);
        }
        catch (Exception exception) {
            
        }
    }

    public final void hideAllViews() {
        this.hideAllProvinceActionViews();
        CFG.menus.updateInGameRTO(false);
        if (CFG.menus.getColorPicker().getVisible()) {
            CFG.menus.getColorPicker().setVisible(false, null);
        }
    }

    public final boolean canMigrate_MovementPoints(int iCivID) {
        return CFG.core.getCiv(iCivID).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)iCivID).getIdeology()).COST_OF_MOVE;
    }

    public final boolean migrateToProvince(int fromProvinceID, int toProvinceID, int iCivID, boolean buildLine) {
        if (!this.canMigrate_MovementPoints(iCivID)) {
            return false;
        }
        if (!Core.uncivilizedCanMigrate_FromProv(fromProvinceID, iCivID)) {
            return false;
        }
        if (CFG.core.getCiv(iCivID).migratesFromProvinceID(fromProvinceID)) {
            return false;
        }
        CFG.core.getCiv(iCivID).newMigrate(fromProvinceID, toProvinceID, buildLine);
        CFG.core.getCiv(iCivID).setMovementPoints(CFG.core.getCiv(iCivID).getMovemPoints() - CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)iCivID).getIdeology()).COST_OF_MOVE);
        return true;
    }

    public final boolean moveArmyAction(int fromProvinceID, int toProvinceID, long nNumOfUnits, int iCivID, boolean regroupMode, boolean buildLine) {
        if (GameManager.isGenocideActive(iCivID, fromProvinceID) || CFG.core.getCiv(iCivID).isPlundred(fromProvinceID)) {
            return false;
        }
        synchronized (CFG.core) {
            try {
                Civilization civ = CFG.core.getCiv(iCivID);
                Province fromProvince = CFG.core.getProv(fromProvinceID);
                int movementPayerCivID = this.getArmyMovementPayerCivID(fromProvinceID, iCivID);
                Civilization movementPayerCiv = CFG.core.getCiv(movementPayerCivID);
                if (nNumOfUnits == 0) {
                    for (int i = 0; i < civ.moveUnitsSize(); ++i) {
                        if (civ.getMoveUnits(i).getFromProviID() != fromProvinceID || civ.getMoveUnits(i).getToProvID() != toProvinceID) continue;
                        fromProvince.updateArmy4(iCivID, fromProvince.getArmyCivID1((int)iCivID) + civ.getMoveUnits(i).getNumberOfUnits());
                        civ.removeMove(i);
                        for (int j = 0; j < civ.getRegroupArmySize(); ++j) {
                            if (civ.getRegroupArmy(j).getFromProvinceID() != toProvinceID) continue;
                            civ.removeRegroupArmy(j--);
                        }
                        movementPayerCiv.setMovementPoints(movementPayerCiv.getMovemPoints() + this.costOfMoveArmy(fromProvinceID, toProvinceID, movementPayerCivID));
                        return false;
                    }
                    return false;
                }
                for (int i = 0; i < civ.moveUnitsSize(); ++i) {
                    if (civ.getMoveUnits(i).getFromProviID() != fromProvinceID || civ.getMoveUnits(i).getToProvID() != toProvinceID) continue;
                    if (regroupMode) {
                        if (fromProvince.getArmyCivID1((int)iCivID) < nNumOfUnits) {
                            nNumOfUnits = fromProvince.getArmyCivID1((int)iCivID);
                        }
                        fromProvince.updateArmy4(iCivID, fromProvince.getArmyCivID1((int)iCivID) - nNumOfUnits);
                        civ.getMoveUnits(i).setNumberOfUnits(civ.getMoveUnits(i).getNumberOfUnits() + nNumOfUnits);
                    } else {
                        fromProvince.updateArmy4(iCivID, fromProvince.getArmyCivID1((int)iCivID) - (nNumOfUnits - civ.getMoveUnits(i).getNumberOfUnits()));
                        civ.getMoveUnits(i).setNumberOfUnits(nNumOfUnits);
                    }
                    return true;
                }
                if (movementPayerCiv.getMovemPoints() < this.costOfMoveArmy(fromProvinceID, toProvinceID, movementPayerCivID)) {
                    return false;
                }
                if (!fromProvince.getSeaProv() && CFG.core.getProv(toProvinceID).getSeaProv() && fromProvince.getLvlOfPort() < 1) {
                    return false;
                }
                if (nNumOfUnits > fromProvince.getArmyCivID1((int)iCivID)) {
                    nNumOfUnits = fromProvince.getArmyCivID1((int)iCivID);
                }
                if (nNumOfUnits <= 0) {
                    return false;
                }
                movementPayerCiv.setMovementPoints(movementPayerCiv.getMovemPoints() - this.costOfMoveArmy(fromProvinceID, toProvinceID, movementPayerCivID));
                civ.newMove(fromProvinceID, toProvinceID, nNumOfUnits, buildLine);
                fromProvince.updateArmy4(iCivID, fromProvince.getArmyCivID1((int)iCivID) - nNumOfUnits);
                return true;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
                return false;
            }
        }
    }

    public final int costOfMoveArmy(int fromProvinceID, int toProvinceID, int nCivID) {
        try {
            if (CFG.core.getProv(fromProvinceID).getCivId() > 0 && CFG.core.getProv(toProvinceID).getCivId() > 0 && CFG.core.getProv(fromProvinceID).getCivId() == CFG.core.getProv(toProvinceID).getCivId() && CFG.core.getProv(fromProvinceID).getCivId() == nCivID) {
                return CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_MOVE_OWN_PROVINCE;
            }
            if (CFG.core.getProv(fromProvinceID).getSeaProv()) {
                if (CFG.core.getProv(toProvinceID).getSeaProv()) {
                    return (int)((float)CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_MOVE * GameValues.gvMove.COST_OF_MOVE_MOVEMENTS_POINTS_LAND_TO_SEA_MODIFIER);
                }
                return (int)((float)CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_MOVE * GameValues.gvMove.COST_OF_MOVE_MOVEMENTS_POINTS_SEA_TO_SEA_MODIFIER);
            }
            for (int i = 0; i < CFG.core.getCiv(nCivID).moveUnitsSize(); ++i) {
                if (CFG.core.getCiv(nCivID).getMoveUnits(i).getToProvID() != toProvinceID) continue;
                return CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_MOVE_SAME_PROVINCE;
            }
            return CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_MOVE;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            return CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_MOVE;
        }
    }

    public final boolean getIsFreeMove(int iCivID, int fromProvinceID, int toProvinceID) {
        for (int i = 0; i < CFG.core.getCiv(iCivID).moveUnitsSize(); ++i) {
            if (CFG.core.getCiv(iCivID).getMoveUnits(i).getFromProviID() != fromProvinceID || CFG.core.getCiv(iCivID).getMoveUnits(i).getToProvID() != toProvinceID) continue;
            return true;
        }
        return false;
    }

    public final void updatePopulationLosses(int nProvinceID, long iLosses) {
        int i;
        long nRecuritedPop = CFG.core.getProv(nProvinceID).getPop().getPops();
        for (i = 0; i < CFG.core.getProv(nProvinceID).getPop().getNatsSize(); ++i) {
            if (CFG.core.getProv(nProvinceID).getPop().getCivID(i) == 0) {
                if (!CFG.core.getProv(nProvinceID).getPop().setPopulationOfCivID(CFG.core.getProv(nProvinceID).getPop().getCivID(i), (int)((double)CFG.core.getProv(nProvinceID).getPop().getPopulationID(i) - Math.floor((float)iLosses * ((float)CFG.core.getProv(nProvinceID).getPop().getPopulationID(i) / (float)nRecuritedPop))))) continue;
                --i;
                continue;
            }
            if (CFG.core.getProv(nProvinceID).getCivId() == CFG.core.getProv(nProvinceID).getPop().getCivID(i)) {
                if (!CFG.core.getProv(nProvinceID).getPop().setPopulationOfCivID(CFG.core.getProv(nProvinceID).getPop().getCivID(i), (int)((double)CFG.core.getProv(nProvinceID).getPop().getPopulationID(i) - Math.ceil((float)iLosses * ((float)CFG.core.getProv(nProvinceID).getPop().getPopulationID(i) / (float)nRecuritedPop))))) continue;
                --i;
                continue;
            }
            if ((int)CFG.core.getCivRelationOfCivB(CFG.core.getProv(nProvinceID).getCivId(), CFG.core.getProv(nProvinceID).getPop().getCivID(i)) == GameValues.gvDiplomacy.RELATION_AT_WAR) {
                if (!CFG.core.getProv(nProvinceID).getPop().setPopulationOfCivID(CFG.core.getProv(nProvinceID).getPop().getCivID(i), (int)((double)CFG.core.getProv(nProvinceID).getPop().getPopulationID(i) - Math.floor((float)iLosses * ((float)CFG.core.getProv(nProvinceID).getPop().getPopulationID(i) / (float)nRecuritedPop))))) continue;
                --i;
                continue;
            }
            if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getAlliance() > 0 && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getAlliance() == CFG.core.getCiv(CFG.core.getProv(nProvinceID).getPop().getCivID(i)).getAlliance()) {
                if (!CFG.core.getProv(nProvinceID).getPop().setPopulationOfCivID(CFG.core.getProv(nProvinceID).getPop().getCivID(i), (int)((double)CFG.core.getProv(nProvinceID).getPop().getPopulationID(i) - Math.floor((float)iLosses * ((float)CFG.core.getProv(nProvinceID).getPop().getPopulationID(i) / (float)nRecuritedPop))))) continue;
                --i;
                continue;
            }
            if (!CFG.core.getProv(nProvinceID).getPop().setPopulationOfCivID(CFG.core.getProv(nProvinceID).getPop().getCivID(i), (int)((double)CFG.core.getProv(nProvinceID).getPop().getPopulationID(i) - Math.floor((float)iLosses * ((float)CFG.core.getProv(nProvinceID).getPop().getPopulationID(i) / (float)nRecuritedPop))))) continue;
            --i;
        }
        if ((nRecuritedPop -= CFG.core.getProv(nProvinceID).getPop().getPops()) < iLosses) {
            nRecuritedPop = iLosses - nRecuritedPop;
            int tPop = 0;
            for (i = 0; i < CFG.core.getProv(nProvinceID).getPop().getNatsSize(); ++i) {
                tPop = Math.min((int)nRecuritedPop, (int)CFG.core.getProv(nProvinceID).getPop().getPopulationID(i));
                if (CFG.core.getProv(nProvinceID).getPop().setPopulationOfCivID(CFG.core.getProv(nProvinceID).getPop().getCivID(i), CFG.core.getProv(nProvinceID).getPop().getPopulationID(i) - Math.min(nRecuritedPop, CFG.core.getProv(nProvinceID).getPop().getPopulationID(i)))) {
                    --i;
                }
                if ((nRecuritedPop -= tPop) <= 0) break;
            }
        }
    }

    public final void updateRelations() {
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (i % GameValues.gvRelations.UPDATE_RELATIONS_DECAY_X_TURNS == GameCalendar.TURNID % GameValues.gvRelations.UPDATE_RELATIONS_DECAY_X_TURNS) {
                if (CFG.core.getCiv(i).getNumOfProvs() > 0) {
                    for (int j = 1; j < CFG.core.getCivsSize(); ++j) {
                        if (i == j) continue;
                        float relation = CFG.core.getCivRelationOfCivB(i, j);
                        if (relation > (float)GameValues.gvRelations.RELATIONS_DECAY_MAX) {
                            CFG.core.setCivRelationOfCivB(i, j, relation + GameValues.gvRelations.RELATIONS_DECAY_IF_POSITIVE);
                        } else if (relation < (float)GameValues.gvRelations.RELATIONS_DECAY_MIN && !CFG.core.getCivsAtWar(i, j)) {
                            CFG.core.setCivRelationOfCivB(i, j, relation + GameValues.gvRelations.RELATIONS_DECAY_IF_NEGATIVE);
                        }
                    }
                }
            }
        }
    }

    public final boolean isEmperorInTheGame() {
        try {
            return CFG.core.getCiv(CFG.hreMgr.getHRE().getEmperor()).getNumOfProvs() > 0 && CFG.core.getCiv(CFG.hreMgr.getHRE().getEmperor()).getPuppetOfCiv() == CFG.hreMgr.getHRE().getEmperor();
        }
        catch (Exception exception) {
            return true;
        }
    }

    public final void recruitArmyInstantly(int nProvinceID, long nNumOfUnits, int nCivID) {
        if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getMovemPoints() < CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_RECRUIT) {
            return;
        }
        if (nNumOfUnits >= CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getGold() / (long)CFG.getCostOfRecruitArmyMoney_Instantly(nProvinceID)) {
            nNumOfUnits = CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getGold() / (long)CFG.getCostOfRecruitArmyMoney_Instantly(nProvinceID);
        }
        if (nNumOfUnits >= this.gMARY(nProvinceID)) {
            nNumOfUnits = this.gMARY(nProvinceID);
        }
        if (nNumOfUnits > 0) {
            CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_RECRUIT);
            CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)(nNumOfUnits * CFG.getCostOfRecruitArmyMoney_Instantly(nProvinceID)));
            this.recruitArmy(nProvinceID, nNumOfUnits, nCivID);
        }
    }

    public final void recruitArmy(int nProvinceID, long nNumOfUnits, int nCivID) {
        if (nNumOfUnits >= this.gMARY(nProvinceID)) {
            nNumOfUnits = this.gMARY(nProvinceID);
        }
        if (nNumOfUnits > 0) {
            Province_Population provincePopulation;
            long nRecruitedPop;
            block17: {
                Province province = CFG.core.getProv(nProvinceID);
                Civilization civ = CFG.core.getCiv(nCivID);
                long tempProvincePopulation = province.getPop().getPops();
                province.setHappi(province.getHappi() - GameValues.gvArmyRecruit.RECRUIT_HAPPINESS_CHANGE_MODIFIER * ((float)nNumOfUnits / (float)tempProvincePopulation));
                province.setEco((long)((double)province.getEco() - (double)province.getEco() * (double)(province.isCapital() ? GameValues.gvArmyRecruit.RECRUIT_ECONOMY_CHANGE_CAPITAL_MODIFIER : GameValues.gvArmyRecruit.RECRUIT_ECONOMY_CHANGE_MODIFIER + (float)CFG.oR.nextInt(GameValues.gvArmyRecruit.RECRUIT_ECONOMY_CHANGE_RANDOM_1000) / 1000.0f) * ((double)nNumOfUnits / (double)tempProvincePopulation)));
                province.setDevLvl(province.getDeveLvl() - province.getDeveLvl() * (province.isCapital() ? GameValues.gvArmyRecruit.RECRUIT_DEVELOPMENT_CHANGE_CAPITAL_MODIFIER : GameValues.gvArmyRecruit.RECRUIT_DEVELOPMENT_CHANGE_MODIFIER + (float)CFG.oR.nextInt(GameValues.gvArmyRecruit.RECRUIT_DEVELOPMENT_CHANGE_RANDOM_1000) / 1000.0f) * ((float)nNumOfUnits / (float)tempProvincePopulation));
                if (nCivID == province.getTrueOwnerOfProv()) {
                    province.updateArmy4(province.getArmyID(0) + nNumOfUnits);
                } else {
                    province.updateArmy4(nCivID, province.getArmyID(0) + nNumOfUnits);
                }
                civ.civGD.recruitedArmy += nNumOfUnits;
                province.provGD.iNumOfRecruitedArmyTotal += nNumOfUnits;
                if (civ.getIsPlayer()) {
                    int nPlayerID = CFG.core.getPlayerIDbyCivID(nCivID);
                    try {
                        CFG.core.getPlayer((int)nPlayerID).statsCiv.setRecruitedArmy(CFG.core.getPlayer((int)nPlayerID).statsCiv.getRecruitedArmy() + nNumOfUnits);
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
                civ.setNumberOfUnits(civ.getNumberOfUnits() + nNumOfUnits);
                nRecruitedPop = tempProvincePopulation;
                provincePopulation = province.getPop();
                try {
                    int i;
                    if (nCivID == province.getTrueOwnerOfProv()) {
                        for (i = 0; i < provincePopulation.getNatsSize(); ++i) {
                            if (province.getCivId() == provincePopulation.getCivID(i)) {
                                if (!provincePopulation.setPopulationOfCivID(provincePopulation.getCivID(i), (int)((double)provincePopulation.getPopulationID(i) - Math.ceil((float)nNumOfUnits * ((float)provincePopulation.getPopulationID(i) / (float)nRecruitedPop))))) continue;
                                --i;
                                continue;
                            }
                            if (!provincePopulation.setPopulationOfCivID(provincePopulation.getCivID(i), (int)((double)provincePopulation.getPopulationID(i) - Math.floor((float)nNumOfUnits * ((float)provincePopulation.getPopulationID(i) / (float)nRecruitedPop))))) continue;
                            --i;
                        }
                        break block17;
                    }
                    for (i = 0; i < provincePopulation.getNatsSize(); ++i) {
                        if (nCivID != provincePopulation.getCivID(i)) continue;
                        if (provincePopulation.setPopulationOfCivID(provincePopulation.getCivID(i), provincePopulation.getPopulationID(i) - nNumOfUnits)) {
                            
                        }
                        break;
                    }
                }
                catch (Exception i) {
                    
                }
            }
            if ((nRecruitedPop -= (long)provincePopulation.getPops()) < (long)nNumOfUnits) {
                nRecruitedPop = (long)nNumOfUnits - nRecruitedPop;
                int tPop = 0;
                for (int i = 0; i < provincePopulation.getNatsSize(); ++i) {
                    tPop = Math.min((int)nRecruitedPop, (int)provincePopulation.getPopulationID(i));
                    if (provincePopulation.setPopulationOfCivID(provincePopulation.getCivID(i), provincePopulation.getPopulationID(i) - Math.min(nRecruitedPop, provincePopulation.getPopulationID(i)))) {
                        --i;
                    }
                    if ((nRecruitedPop -= tPop) <= 0) break;
                }
            }
        }
    }

    public final void updateRecruitSlider_OLD() {
        try {
            long tMaxRecruit = 0L;
            tMaxRecruit = CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getGold() / (long)CFG.gCARR(CFG.core.getActiveProvID());
            if (tMaxRecruit < 0L) {
                tMaxRecruit = 0L;
            } else if (tMaxRecruit > this.gMARY(CFG.core.getActiveProvID())) {
                tMaxRecruit = this.gMARY(CFG.core.getActiveProvID());
            }
            int isRecruiting = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isRAIP(CFG.core.getActiveProvID());
            if (isRecruiting >= 0) {
                if ((tMaxRecruit += CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getRecruitArmy(isRecruiting).getArmy()) > this.gMARY(CFG.core.getActiveProvID())) {
                    tMaxRecruit = this.gMARY(CFG.core.getActiveProvID());
                }
                CFG.menus.getInGame_ProvRecruitSlider().setMax(tMaxRecruit);
                CFG.menus.getInGame_ProvRecruitSlider().setCurr(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getRecruitArmy(isRecruiting).getArmy());
            } else {
                CFG.menus.getInGame_ProvRecruitSlider().setMax(tMaxRecruit);
                CFG.menus.getInGame_ProvRecruitSlider().setCurr((long)((float)tMaxRecruit * GameValues.gvArmyRecruit.RECRUIT_ARMY_DEFAULT_SLIDER_PERC_OF_MAX));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            CFG.menus.getInGame_ProvRecruitSlider().setMax(0);
            CFG.menus.getInGame_ProvRecruitSlider().setCurr(0);
        }
    }

    public final long getMaxRecruit() {
        try {
            long tMaxRecruit = 0L;
            tMaxRecruit = CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getGold() / (long)CFG.gCARR(CFG.core.getActiveProvID());
            if (tMaxRecruit < 0L) {
                tMaxRecruit = 0L;
            } else if (tMaxRecruit > this.gMARY(CFG.core.getActiveProvID())) {
                tMaxRecruit = this.gMARY(CFG.core.getActiveProvID());
            }
            int isRecruiting = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isRAIP(CFG.core.getActiveProvID());
            if (isRecruiting >= 0 && (tMaxRecruit += CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getRecruitArmy(isRecruiting).getArmy()) > this.gMARY(CFG.core.getActiveProvID())) {
                tMaxRecruit = this.gMARY(CFG.core.getActiveProvID());
            }
            return tMaxRecruit;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            return 0L;
        }
    }

    public final long getMaxRecruit(int provinceID) {
        try {
            long tMaxRecruit = 0L;
            tMaxRecruit = CFG.core.getCiv(CFG.core.getProv(provinceID).getCivId()).getGold() / (long)CFG.gCARR(provinceID);
            if (tMaxRecruit < 0L) {
                tMaxRecruit = 0L;
            } else if (tMaxRecruit > this.gMARY(provinceID)) {
                tMaxRecruit = this.gMARY(provinceID);
            }
            int isRecruiting = CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).isRAIP(provinceID);
            if (isRecruiting >= 0 && (tMaxRecruit += CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getRecruitArmy(isRecruiting).getArmy()) > this.gMARY(provinceID)) {
                tMaxRecruit = this.gMARY(provinceID);
            }
            return tMaxRecruit;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            return 0L;
        }
    }

    public final void updateRecruitSlider_Instantly() {
        try {
            long tMaxRecruit = 0L;
            tMaxRecruit = CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getGold() / (long)CFG.getCostOfRecruitArmyMoney_Instantly(CFG.core.getActiveProvID());
            if (tMaxRecruit < 0L) {
                tMaxRecruit = 0L;
            } else if (tMaxRecruit > this.gMARY(CFG.core.getActiveProvID())) {
                tMaxRecruit = this.gMARY(CFG.core.getActiveProvID());
            }
            CFG.menus.getInGame_ProvinceRecruitInstantly_Slider().setMax(tMaxRecruit);
            CFG.menus.getInGame_ProvinceRecruitInstantly_Slider().setCurr(tMaxRecruit);
        }
        catch (IndexOutOfBoundsException ex) {
            if (CFG.LOGs) {
                CFG.exceptionStack(ex);
            }
            CFG.menus.getInGame_ProvinceRecruitInstantly_Slider().setMax(0);
            CFG.menus.getInGame_ProvinceRecruitInstantly_Slider().setCurr(0);
        }
    }

    public final void disbandArmy(int nProvinceID, long nNumOfUnits, int nCivID) {
        if (nNumOfUnits < 0) {
            return;
        }
        if (nProvinceID >= 0 && nProvinceID < CFG.core.getProvinSize() && nCivID > 0) {
            int provinceOwnerCivID = CFG.core.getProv(nProvinceID).getCivId();
            if (provinceOwnerCivID > 0 && CFG.core.getCiv(nCivID).getPuppetOfCiv() == provinceOwnerCivID && !CFG.core.getCiv(nCivID).getIsPlayer()) {
                return;
            }
        }
        if (CFG.core.getCiv(nCivID).civGD.sandboxNoDisband) {
            CFG.core.getCiv(nCivID).civGD.aiNoDisbandUntilTurnID = Integer.MAX_VALUE;
            return;
        }
        if (CFG.settingsGD.EXPERIMENTAL_BATTLE_SYSTEM && !CFG.core.getCiv(nCivID).getIsPlayer() && GameCalendar.TURNID - CFG.core.getCiv(nCivID).civGD.iLastWarTurnID < 30) {
            return;
        }
        Province province = CFG.core.getProv(nProvinceID);
        if (nNumOfUnits > province.getArmyCivID1(nCivID)) {
            nNumOfUnits = province.getArmyCivID1(nCivID);
        }
        if (nNumOfUnits > 0) {
            int i;
            Civilization civ = CFG.core.getCiv(nCivID);
            if (civ.getMovemPoints() < CFG.ideologiesMgr.getIdeologyID((int)civ.getIdeology()).COST_OF_DISBAND) {
                return;
            }
            civ.setMovementPoints(civ.getMovemPoints() - CFG.ideologiesMgr.getIdeologyID((int)civ.getIdeology()).COST_OF_DISBAND);
            nNumOfUnits = Math.min(province.getArmyCivID1(nCivID), nNumOfUnits);

            if (nNumOfUnits <= 0) {
                return;
            }
            province.updateArmy4(nCivID, province.getArmyCivID1(nCivID) - nNumOfUnits);
            civ.updateNumberOfUnits();

            int nNeighboring = 1;
            for (int i2 = 0; i2 < province.getNeighProvincesSize(); ++i2) {
                if (CFG.core.getProv(province.getNeighProvinces(i2)).getCivId() != nCivID) continue;
                ++nNeighboring;
            }
            long nPop = (long)Math.ceil((float)nNumOfUnits * GameValues.gvArmyDisband.DISBAND_ARMY_RETURN_AS_POPULATION_MODIFIER);
            nNumOfUnits -= nPop;
            province.getPop().setPopulationOfCivID(nCivID, province.getPop().getPopulationOfCivID(nCivID) + (long)Math.ceil(nPop / nNeighboring));
            nPop -= (long)Math.ceil(nPop / nNeighboring);
            if (--nNeighboring > 0) {
                for (i = 0; i < province.getNeighProvincesSize(); ++i) {
                    if (CFG.core.getProv(province.getNeighProvinces(i)).getCivId() != nCivID) continue;
                    province.getPop().setPopulationOfCivID(CFG.core.getProv(province.getNeighProvinces(i)).getCivId(), province.getPop().getPopulationOfCivID(CFG.core.getProv(province.getNeighProvinces(i)).getCivId()) + nPop / nNeighboring);
                }
                nNumOfUnits += nPop - nPop / nNeighboring * nNeighboring;
            }
            if (civ.getNumOfProvs() > 0) {
                nPop = (long)Math.floor(nNumOfUnits / civ.getNumOfProvs());
                CFG.core.getProv(civ.getProvID(0)).getPop().setPopulationOfCivID(nCivID, CFG.core.getProv(civ.getProvID(0)).getPop().getPopulationOfCivID(nCivID) + (long)Math.ceil(nNumOfUnits / civ.getNumOfProvs()));
                for (i = 1; i < civ.getNumOfProvs(); ++i) {
                    CFG.core.getProv(civ.getProvID(i)).getPop().setPopulationOfCivID(nCivID, CFG.core.getProv(civ.getProvID(i)).getPop().getPopulationOfCivID(nCivID) + nPop);
                }
            } else {
                province.getPop().setPopulationOfCivID(nCivID, province.getPop().getPopulationOfCivID(nCivID) + nNumOfUnits);
            }
        }
    }

    public final int gMARY(int nProvinceID, int nCivID) {
        int nOut = 0;
        Province_Population provincePopulation = CFG.core.getProv(nProvinceID).getPop();
        if (CFG.core.getCiv(nCivID).isAtWarC() || CFG.core.getCiv(nCivID).civGD.civPlans.isPreparingForTheWar() || CFG.core.getProv(nProvinceID).getTrueOwnerOfProv() == nCivID) {
            for (int i = 0; i < provincePopulation.getNatsSize(); ++i) {
                if (provincePopulation.getCivID(i) == 0) {
                    nOut += (int)((float)provincePopulation.getPopulationID(i) * GameValues.gvArmyRecruitable.RECRUITABLE_ARMY_NEUTRAL_POP);
                    continue;
                }
                if (nCivID == provincePopulation.getCivID(i)) {
                    nOut += (int)((float)provincePopulation.getPopulationID(i) * GameValues.gvArmyRecruitable.RECRUITABLE_ARMY_OWN_POP);
                    continue;
                }
                if ((int)CFG.core.getCivRelationOfCivB(nCivID, provincePopulation.getCivID(i)) == GameValues.gvDiplomacy.RELATION_AT_WAR) {
                    nOut += (int)((float)provincePopulation.getPopulationID(i) * GameValues.gvArmyRecruitable.RECRUITABLE_ARMY_OTHER_POP_AT_WAR);
                    continue;
                }
                if (CFG.core.getCiv(nCivID).getAlliance() > 0 && CFG.core.getCiv(nCivID).getAlliance() == CFG.core.getCiv(provincePopulation.getCivID(i)).getAlliance()) {
                    nOut += (int)((float)provincePopulation.getPopulationID(i) * GameValues.gvArmyRecruitable.RECRUITABLE_ARMY_OTHER_POP_ALLIANCE);
                    continue;
                }
                nOut += (int)((float)provincePopulation.getPopulationID(i) * GameValues.gvArmyRecruitable.RECRUITABLE_ARMY_OTHER_POP);
            }
        } else {
            for (int i = 0; i < provincePopulation.getNatsSize(); ++i) {
                if (nCivID != provincePopulation.getCivID(i)) continue;
                nOut += (int)((float)provincePopulation.getPopulationID(i) * GameValues.gvArmyRecruitable.RECRUITABLE_ARMY_OWN_POP_OCCUPIED);
            }
        }
        return (int)Math.min((float)nOut * (1.0f + GameValues.gvTechnology.PER_POINT_RECRUITABLE * (float)CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_RECRUITABLE), (float)provincePopulation.getPops());
    }

    public final void updateInGame_Date() {
        CFG.menus.getInGameMenu().getMenuElem(4).setWidthE(1);
        CFG.menus.getInGameMenu().getMenuElem(4).setTextE(GameCalendar.getCurrDate());
        CFG.menus.getInGameMenu().getMenuElem(5).setWidthE(1);
        CFG.menus.getInGameMenu().getMenuElem(5).setTextE(CFG.lang.get("Turn") + ": " + GameCalendar.TURNID);
    }

    public void updateInGame_ProvinceInfo() {
        if (Menu_InGame_ProvInfo.getUseSmallProvinceInfo()) {
            this.updateInGame_ProvinceInfoSmall();
        } else {
            this.updateInGame_ProvinceInfoBig();
        }
    }

    public void updateInGame_ProvinceInfoBig() {
        block29: {
            try {
                int n = CFG.ACTIVE_PROVINCE_INFO = CFG.chosenProvinceID >= 0 ? CFG.chosenProvinceID : CFG.core.getActiveProvID();
                if (CFG.ACTIVE_PROVINCE_INFO < 0) {
                    Menu_InGame_ProvInfo.iMaxWidth = 0;
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(3).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(4).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(5).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(6).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(7).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(8).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(9).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(10).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(11).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(12).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(13).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(14).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(15).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(16).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(17).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(18).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(19).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(20).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(21).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(22).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(23).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(24).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(25).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(26).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(27).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(28).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(29).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(30).setVisibleE(false);
                    return;
                }
                if (CFG.FOG_OF_WAR == 2 && !CFG.getMetProv(CFG.ACTIVE_PROVINCE_INFO)) {
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setTextE(CFG.lang.get("Undiscovered"));
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setCurr(-3);
                    CFG.menus.getInGameProvInfo().getMenuElem(6).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(3).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(8).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(4).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(5).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(7).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(9).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(10).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(11).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(12).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(13).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(14).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(15).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(16).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(17).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(18).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(19).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(20).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(21).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(22).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(23).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(24).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(25).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(26).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(27).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(28).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(29).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(30).setVisibleE(false);
                    break block29;
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getWastelandLvl() >= 0) {
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setTextE(CFG.lang.get("Wasteland"));
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setCurr(-2);
                    CFG.menus.getInGameProvInfo().getMenuElem(6).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(3).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(8).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(4).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(5).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(7).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(9).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(10).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(11).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(12).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(13).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(14).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(15).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(16).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(17).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(18).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(19).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(20).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(21).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(22).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(23).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(24).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(24).setTextE("" + (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighProvincesSize() + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighSeaProvincesSize()));
                    CFG.menus.getInGameProvInfo().getMenuElem(25).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(26).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(27).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(28).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(29).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(30).setVisibleE(false);
                    break block29;
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getSeaProv()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setTextE(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName().length() > 0 ? CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName() : CFG.lang.get("Sea"));
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setCurr(-1);
                    CFG.menus.getInGameProvInfo().getMenuElem(6).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(3).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(8).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(4).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(5).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(7).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(9).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(10).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(11).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(12).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(13).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(14).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(15).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(16).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(17).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(18).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(19).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(20).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(21).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(22).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(23).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(24).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(24).setTextE("" + (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighProvincesSize() + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighSeaProvincesSize()));
                    CFG.menus.getInGameProvInfo().getMenuElem(25).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(26).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(27).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(28).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(29).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(30).setVisibleE(false);
                    break block29;
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName().length() > 0) {
                    CFG.core.updateProvNameWidth(CFG.ACTIVE_PROVINCE_INFO);
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setTextE(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName());
                } else {
                    CFG.core.updateProvNameWidth("Fokus");
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setTextE(CFG.lang.get("Fokus"));
                }
                try {
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setCurr(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId());
                }
                catch (Exception ex) {
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setCurr(0);
                }
                CFG.menus.getInGameProvInfo().getMenuElem(2).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(2).setTextE(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).getCivName());
                CFG.menus.getInGameProvInfo().getMenuElem(2).setCurr(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId());
                CFG.menus.getInGameProvInfo().getMenuElem(3).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(3).setCurr(CFG.ACTIVE_PROVINCE_INFO);
                CFG.menus.getInGameProvInfo().getMenuElem(8).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(8).setCurr((int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getRevRisk() * 100.0f));
                CFG.menus.getInGameProvInfo().getMenuElem(8).setTextE("" + (int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getRevRisk() * 100.0f) + "%");
                CFG.menus.getInGameProvInfo().getMenuElem(4).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(4).setCurr(CFG.ACTIVE_PROVINCE_INFO);
                int nPop = (int)CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getPop().getPops();
                CFG.menus.getInGameProvInfo().getMenuElem(4).setTextE(nPop < 1000000 ? CFG.getNumberWthSpaces("" + nPop) : CFG.getNumber_SHORT(nPop));
                CFG.menus.updateInGame_ProvinceInfoGraph(CFG.ACTIVE_PROVINCE_INFO);
                CFG.menus.getInGameProvInfo().getMenuElem(6).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(9).setVisibleE(true);
                int religionID = Math.min(Math.max(0, CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getTrueOwnerOfProv()).getReligionID()), CFG.religionManager.getReligionsSize() - 1);
                CFG.menus.getInGameProvInfo().getMenuElem(9).setCurr(religionID);
                CFG.menus.getInGameProvInfo().getMenuElem(9).setTextE(CFG.religionManager.getReligion((int)religionID).Name);
                CFG.menus.getInGameProvInfo().getMenuElem(10).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(10).setCurr((int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getHappi() * 100.0f));
                CFG.menus.getInGameProvInfo().getMenuElem(10).setTextE("" + (int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getHappi() * 100.0f) + "%");
                CFG.menus.getInGameProvInfo().getMenuElem(7).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(7).setCurr((int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getGrowthRate_Pop_WithFarm_WithTerrain() * 100.0f));
                CFG.menus.getInGameProvInfo().getMenuElem(7).setTextE("" + (int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getGrowthRate_Pop_WithFarm_WithTerrain() * 100.0f) + "%");
                CFG.menus.getInGameProvInfo().getMenuElem(11).setVisibleE(true);
                int nEco = (int)CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getEco();
                CFG.menus.getInGameProvInfo().getMenuElem(11).setTextE(nEco < 100000 ? CFG.getNumberWthSpaces("" + nEco) : CFG.getNumber_SHORT(nEco));
                CFG.menus.getInGameProvInfo().getMenuElem(12).setVisibleE(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isFestivalOrganized(CFG.ACTIVE_PROVINCE_INFO));
                if (CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(12).setTextE("" + CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isFestivalOrganized_TurnsLeft(CFG.ACTIVE_PROVINCE_INFO));
                }
                if (CFG.menus.getVisibleInGame_CensusOfProvince()) {
                    CFG.menus.rebuildInGame_CensusOfProvince(CFG.ACTIVE_PROVINCE_INFO);
                }
                CFG.menus.getInGameProvInfo().getMenuElem(13).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(13).setCurr((int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getProviStability() * 100.0f));
                CFG.menus.getInGameProvInfo().getMenuElem(13).setTextE("" + (int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getProviStability() * 100.0f) + "%");
                CFG.menus.getInGameProvInfo().getMenuElem(14).setVisibleE(true);
                Menu_InGame_ProvInfo.updateBuildingsList(CFG.ACTIVE_PROVINCE_INFO);
                CFG.menus.getInGameProvInfo().getMenuElem(15).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(15).setTextE("" + CFG.core.getProvinceValue(CFG.ACTIVE_PROVINCE_INFO));
                CFG.menus.getInGameProvInfo().getMenuElem(16).setVisibleE(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isAssimilateOrganized(CFG.ACTIVE_PROVINCE_INFO));
                if (CFG.menus.getInGameProvInfo().getMenuElem(16).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(16).setTextE("" + CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isAssimilateOrganized_TurnsLeft(CFG.ACTIVE_PROVINCE_INFO));
                }
                CFG.menus.getInGameProvInfo().getMenuElem(17).setVisibleE(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isInvestOrganized(CFG.ACTIVE_PROVINCE_INFO));
                if (CFG.menus.getInGameProvInfo().getMenuElem(17).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(17).setTextE("" + CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isInvestOrganized_TurnsLeft(CFG.ACTIVE_PROVINCE_INFO));
                }
                CFG.menus.getInGameProvInfo().getMenuElem(18).setVisibleE(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isInvestOrganized_Devel(CFG.ACTIVE_PROVINCE_INFO));
                if (CFG.menus.getInGameProvInfo().getMenuElem(18).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(18).setTextE("" + CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isInvestOrganized_TurnsLeft_Devel(CFG.ACTIVE_PROVINCE_INFO));
                }
                CFG.menus.getInGameProvInfo().getMenuElem(19).setVisibleE(!CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getIsSupplied() && CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getIsNotSuppliedForXTurns() > 0);
                if (CFG.menus.getInGameProvInfo().getMenuElem(19).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(19).setTextE("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getIsNotSuppliedForXTurns());
                }
                if (CFG.SPECTATOR_MODE || CFG.SANDBOX_MODE || CFG.FOG_OF_WAR == 0 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getFog(CFG.ACTIVE_PROVINCE_INFO)) {
                    CFG.menus.getInGameProvInfo().getMenuElem(20).setVisibleE(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getDefensivePosition() > 0);
                    if (CFG.menus.getInGameProvInfo().getMenuElem(20).getVisibleE()) {
                        CFG.menus.getInGameProvInfo().getMenuElem(20).setTextE("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getDefensivePosition());
                    }
                } else {
                    CFG.menus.getInGameProvInfo().getMenuElem(20).setVisibleE(false);
                }
                CFG.menus.getInGameProvInfo().getMenuElem(21).setVisibleE(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.provincePlague != null);
                if (CFG.menus.getInGameProvInfo().getMenuElem(21).getVisibleE()) {
                    float provinceDeaths = CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.provincePlague.iDeaths;
                    String provinceDeathsText = "";
                    provinceDeathsText = provinceDeaths < 1.0f && provinceDeaths > -1.0f ? CFG.getPrecision2(provinceDeaths, 100) : (provinceDeaths < 10.0f && provinceDeaths > -10.0f ? CFG.getPrecision2(provinceDeaths, 10) : (provinceDeaths < 100.0f && provinceDeaths > -100.0f ? CFG.getPrecision2(provinceDeaths, 1) : CFG.getNumber_SHORT((int)provinceDeaths)));
                    CFG.menus.getInGameProvInfo().getMenuElem(21).setTextE(provinceDeathsText);
                }
                CFG.menus.getInGameProvInfo().getMenuElem(22).setVisibleE(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iNewColonyBonus > 0);
                if (CFG.menus.getInGameProvInfo().getMenuElem(22).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(22).setTextE("" + CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iNewColonyBonus);
                }
                CFG.menus.getInGameProvInfo().getMenuElem(23).setVisibleE(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iSupportRebelsSize > 0);
                if (CFG.menus.getInGameProvInfo().getMenuElem(23).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(23).setCurr(CFG.ACTIVE_PROVINCE_INFO);
                }
                CFG.menus.getInGameProvInfo().getMenuElem(24).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(24).setTextE("" + (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighProvincesSize() + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighSeaProvincesSize()));
                CFG.menus.getInGameProvInfo().getMenuElem(25).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(25).setCurr((int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getDeveLvl() * 100.0f));
                CFG.menus.getInGameProvInfo().getMenuElem(25).setTextE("" + (float)((int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getDeveLvl() * 100.0f)) / 100.0f);
                CFG.menus.getInGameProvInfo().getMenuElem(26).setVisibleE(true);
                float provinceIncome = CFG.gameUpdate.getProvIncomeAndExpenses_Total(CFG.ACTIVE_PROVINCE_INFO);
                String provinceIncomeText = "";
                provinceIncomeText = provinceIncome < 1.0f && provinceIncome > -1.0f ? CFG.getPrecision2(provinceIncome, 100) : (provinceIncome < 10.0f && provinceIncome > -10.0f ? CFG.getPrecision2(provinceIncome, 10) : (provinceIncome < 100.0f && provinceIncome > -100.0f ? CFG.getPrecision2(provinceIncome, 1) : CFG.getNumber_SHORT((int)provinceIncome)));
                CFG.menus.getInGameProvInfo().getMenuElem(26).setCurr((int)provinceIncome);
                CFG.menus.getInGameProvInfo().getMenuElem(26).setTextE(provinceIncomeText);
                CFG.menus.getInGameProvInfo().getMenuElem(27).setVisibleE(CFG.core.isInvestForeignGold(CFG.ACTIVE_PROVINCE_INFO) > 0);
                if (CFG.menus.getInGameProvInfo().getMenuElem(27).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(27).setTextE("" + CFG.core.isInvestForeignGold(CFG.ACTIVE_PROVINCE_INFO));
                }
                CFG.menus.getInGameProvInfo().getMenuElem(28).setVisibleE(CFG.core.isBuildForeignGold(CFG.ACTIVE_PROVINCE_INFO) > 0);
                if (CFG.menus.getInGameProvInfo().getMenuElem(28).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(28).setTextE("" + CFG.core.isBuildForeignGold(CFG.ACTIVE_PROVINCE_INFO));
                }
                CFG.menus.getInGameProvInfo().getMenuElem(29).setVisibleE(CFG.core.isPropagandaOrganized(CFG.ACTIVE_PROVINCE_INFO) > 0);
                if (CFG.menus.getInGameProvInfo().getMenuElem(29).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(29).setTextE("" + CFG.core.isPropagandaOrganized(CFG.ACTIVE_PROVINCE_INFO));
                }
                CFG.menus.getInGameProvInfo().getMenuElem(30).setVisibleE(!CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provinceVolunteerArmySent.isEmpty());
                if (CFG.menus.getInGameProvInfo().getMenuElem(30).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(30).setTextE("" + CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provinceVolunteerArmySent.size());
                }
                if (!CFG.SPECTATOR_MODE && GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES && CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId() == 0) {
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(4).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(7).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(8).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(9).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(10).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(11).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(12).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(13).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(14).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(15).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(16).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(17).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(18).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(19).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(20).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(21).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(22).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(23).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(25).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(26).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(27).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(28).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(29).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(30).setVisibleE(false);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
                try {
                    Menu_InGame_ProvInfo.iMaxWidth = 0;
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(3).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(4).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(5).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(6).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(7).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(8).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(9).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(10).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(11).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(12).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(13).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(14).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(15).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(16).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(17).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(18).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(19).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(20).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(21).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(22).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(23).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(24).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(25).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(26).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(27).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(28).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(29).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(30).setVisibleE(false);
                }
                catch (Exception exception) {
                    
                }
            }
        }
        this.updateInGame_ProvinceInfo_PosXBig();
    }

    public final void updateInGame_ProvinceInfo_PosXBig() {
        try {
            CFG.menus.getInGameProvInfo().getMenuElem(8).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(1).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(1).getWidthE() + CFG.PADD);
            CFG.menus.getInGameProvInfo().getMenuElem(9).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(1).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(1).getWidthE() + CFG.PADD);
            CFG.menus.getInGameProvInfo().getMenuElem(10).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(7).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(7).getWidthE() + CFG.PADD);
            CFG.menus.getInGameProvInfo().getMenuElem(11).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(9).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(9).getWidthE() + CFG.PADD);
            CFG.menus.getInGameProvInfo().getMenuElem(13).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(10).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(10).getWidthE() + CFG.PADD);
            CFG.menus.getInGameProvInfo().getMenuElem(15).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(13).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(13).getWidthE() + CFG.PADD);
            CFG.menus.getInGameProvInfo().getMenuElem(25).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE() + CFG.PADD);
            ArrayList<Integer> nX = new ArrayList<Integer>();
            ArrayList<Integer> nY = new ArrayList<Integer>();
            ArrayList<Integer> nH = new ArrayList<Integer>();
            int buttonH = (CFG.menus.getInGameProvInfo().getHeightM() - CFG.PADD * 4) / 3;
            int buttonW = CFG.menus.getInGameProvInfo().getMenuElem(15).getWidthE();
            nX.add(CFG.menus.getInGameProvInfo().getMenuElem(15).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(15).getWidthE() + CFG.PADD);
            nY.add(CFG.PADD);
            nH.add(CFG.menus.getInGameProvInfo().getMenuElem(8).getHeightE());
            nX.add(CFG.menus.getInGameProvInfo().getMenuElem(15).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(15).getWidthE() + CFG.PADD);
            nY.add(CFG.PADD * 2 + CFG.menus.getInGameProvInfo().getMenuElem(8).getHeightE());
            nH.add(CFG.menus.getInGameProvInfo().getMenuElem(9).getHeightE());
            nX.add(CFG.menus.getInGameProvInfo().getMenuElem(15).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(15).getWidthE() + CFG.PADD);
            nY.add(CFG.PADD * 3 + CFG.menus.getInGameProvInfo().getMenuElem(8).getHeightE() + CFG.menus.getInGameProvInfo().getMenuElem(9).getHeightE());
            nH.add(CFG.menus.getInGameProvInfo().getMenuElem(10).getHeightE());
            nX.add(CFG.menus.getInGameProvInfo().getMenuElem(15).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(15).getWidthE() + CFG.PADD * 2 + Menu_InGame_ProvInfo.tier4Width);
            nY.add(CFG.PADD);
            nH.add(CFG.menus.getInGameProvInfo().getMenuElem(8).getHeightE());
            nX.add(CFG.menus.getInGameProvInfo().getMenuElem(15).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(15).getWidthE() + CFG.PADD * 2 + Menu_InGame_ProvInfo.tier4Width);
            nY.add(CFG.PADD * 2 + CFG.menus.getInGameProvInfo().getMenuElem(8).getHeightE());
            nH.add(CFG.menus.getInGameProvInfo().getMenuElem(9).getHeightE());
            nX.add(CFG.menus.getInGameProvInfo().getMenuElem(15).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(15).getWidthE() + CFG.PADD * 2 + Menu_InGame_ProvInfo.tier4Width);
            nY.add(CFG.PADD * 3 + CFG.menus.getInGameProvInfo().getMenuElem(8).getHeightE() + CFG.menus.getInGameProvInfo().getMenuElem(9).getHeightE());
            nH.add(CFG.menus.getInGameProvInfo().getMenuElem(10).getHeightE());
            nX.add(CFG.menus.getInGameProvInfo().getMenuElem(15).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(15).getWidthE() + CFG.PADD * 3 + Menu_InGame_ProvInfo.tier4Width * 2);
            nY.add(CFG.PADD);
            nH.add(CFG.menus.getInGameProvInfo().getMenuElem(8).getHeightE());
            nX.add(CFG.menus.getInGameProvInfo().getMenuElem(15).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(15).getWidthE() + CFG.PADD * 3 + Menu_InGame_ProvInfo.tier4Width * 2);
            nY.add(CFG.PADD * 2 + CFG.menus.getInGameProvInfo().getMenuElem(8).getHeightE());
            nH.add(CFG.menus.getInGameProvInfo().getMenuElem(9).getHeightE());
            nX.add(CFG.menus.getInGameProvInfo().getMenuElem(15).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(15).getWidthE() + CFG.PADD * 3 + Menu_InGame_ProvInfo.tier4Width * 2);
            nY.add(CFG.PADD * 3 + CFG.menus.getInGameProvInfo().getMenuElem(8).getHeightE() + CFG.menus.getInGameProvInfo().getMenuElem(9).getHeightE());
            nH.add(CFG.menus.getInGameProvInfo().getMenuElem(10).getHeightE());
            nX.add(CFG.menus.getInGameProvInfo().getMenuElem(15).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(15).getWidthE() + CFG.PADD * 4 + Menu_InGame_ProvInfo.tier4Width * 3);
            nY.add(CFG.PADD);
            nH.add(CFG.menus.getInGameProvInfo().getMenuElem(8).getHeightE());
            nX.add(CFG.menus.getInGameProvInfo().getMenuElem(15).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(15).getWidthE() + CFG.PADD * 4 + Menu_InGame_ProvInfo.tier4Width * 3);
            nY.add(CFG.PADD * 2 + CFG.menus.getInGameProvInfo().getMenuElem(8).getHeightE());
            nH.add(CFG.menus.getInGameProvInfo().getMenuElem(9).getHeightE());
            nX.add(CFG.menus.getInGameProvInfo().getMenuElem(15).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(15).getWidthE() + CFG.PADD * 4 + Menu_InGame_ProvInfo.tier4Width * 3);
            nY.add(CFG.PADD * 3 + CFG.menus.getInGameProvInfo().getMenuElem(8).getHeightE() + CFG.menus.getInGameProvInfo().getMenuElem(9).getHeightE());
            nH.add(CFG.menus.getInGameProvInfo().getMenuElem(10).getHeightE());
            nX.add(CFG.menus.getInGameProvInfo().getMenuElem(15).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(15).getWidthE() + CFG.PADD * 5 + Menu_InGame_ProvInfo.tier4Width * 4);
            nY.add(CFG.PADD);
            nH.add(CFG.menus.getInGameProvInfo().getMenuElem(8).getHeightE());
            nX.add(CFG.menus.getInGameProvInfo().getMenuElem(15).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(15).getWidthE() + CFG.PADD * 5 + Menu_InGame_ProvInfo.tier4Width * 4);
            nY.add(CFG.PADD * 2 + CFG.menus.getInGameProvInfo().getMenuElem(8).getHeightE());
            nH.add(CFG.menus.getInGameProvInfo().getMenuElem(9).getHeightE());
            nX.add(CFG.menus.getInGameProvInfo().getMenuElem(15).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(15).getWidthE() + CFG.PADD * 5 + Menu_InGame_ProvInfo.tier4Width * 4);
            nY.add(CFG.PADD * 3 + CFG.menus.getInGameProvInfo().getMenuElem(8).getHeightE() + CFG.menus.getInGameProvInfo().getMenuElem(9).getHeightE());
            nH.add(CFG.menus.getInGameProvInfo().getMenuElem(10).getHeightE());
            nX.add(CFG.menus.getInGameProvInfo().getMenuElem(15).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(15).getWidthE() + CFG.PADD * 6 + Menu_InGame_ProvInfo.tier4Width * 5);
            nY.add(CFG.PADD);
            nH.add(CFG.menus.getInGameProvInfo().getMenuElem(8).getHeightE());
            nX.add(CFG.menus.getInGameProvInfo().getMenuElem(15).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(15).getWidthE() + CFG.PADD * 6 + Menu_InGame_ProvInfo.tier4Width * 5);
            nY.add(CFG.PADD * 2 + CFG.menus.getInGameProvInfo().getMenuElem(8).getHeightE());
            nH.add(CFG.menus.getInGameProvInfo().getMenuElem(9).getHeightE());
            nX.add(CFG.menus.getInGameProvInfo().getMenuElem(15).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(15).getWidthE() + CFG.PADD * 6 + Menu_InGame_ProvInfo.tier4Width * 5);
            nY.add(CFG.PADD * 3 + CFG.menus.getInGameProvInfo().getMenuElem(8).getHeightE() + CFG.menus.getInGameProvInfo().getMenuElem(9).getHeightE());
            nH.add(CFG.menus.getInGameProvInfo().getMenuElem(10).getHeightE());
            int buttonsAdded = 0;
            if (CFG.menus.getInGameProvInfo().getMenuElem(20).getVisibleE()) {
                CFG.menus.getInGameProvInfo().getMenuElem(20).setPosX((Integer)nX.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(20).setPosY((Integer)nY.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(20).setHeightE((Integer)nH.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(20).setWidthE(Menu_InGame_ProvInfo.tier4Width);
                ++buttonsAdded;
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE()) {
                CFG.menus.getInGameProvInfo().getMenuElem(12).setPosX((Integer)nX.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(12).setPosY((Integer)nY.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(12).setHeightE((Integer)nH.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(12).setWidthE(Menu_InGame_ProvInfo.tier4Width);
                ++buttonsAdded;
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(16).getVisibleE()) {
                CFG.menus.getInGameProvInfo().getMenuElem(16).setPosX((Integer)nX.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(16).setPosY((Integer)nY.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(16).setHeightE((Integer)nH.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(16).setWidthE(Menu_InGame_ProvInfo.tier4Width);
                ++buttonsAdded;
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(17).getVisibleE()) {
                CFG.menus.getInGameProvInfo().getMenuElem(17).setPosX((Integer)nX.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(17).setPosY((Integer)nY.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(17).setHeightE((Integer)nH.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(17).setWidthE(Menu_InGame_ProvInfo.tier4Width);
                ++buttonsAdded;
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(18).getVisibleE()) {
                CFG.menus.getInGameProvInfo().getMenuElem(18).setPosX((Integer)nX.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(18).setPosY((Integer)nY.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(18).setHeightE((Integer)nH.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(18).setWidthE(Menu_InGame_ProvInfo.tier4Width);
                ++buttonsAdded;
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(19).getVisibleE()) {
                CFG.menus.getInGameProvInfo().getMenuElem(19).setPosX((Integer)nX.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(19).setPosY((Integer)nY.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(19).setHeightE((Integer)nH.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(19).setWidthE(Menu_InGame_ProvInfo.tier4Width);
                ++buttonsAdded;
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(22).getVisibleE()) {
                CFG.menus.getInGameProvInfo().getMenuElem(22).setPosX((Integer)nX.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(22).setPosY((Integer)nY.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(22).setHeightE((Integer)nH.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(22).setWidthE(Menu_InGame_ProvInfo.tier4Width);
                ++buttonsAdded;
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(23).getVisibleE()) {
                CFG.menus.getInGameProvInfo().getMenuElem(23).setPosX((Integer)nX.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(23).setPosY((Integer)nY.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(23).setHeightE((Integer)nH.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(23).setWidthE(Menu_InGame_ProvInfo.tier4Width);
                ++buttonsAdded;
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(21).getVisibleE()) {
                CFG.menus.getInGameProvInfo().getMenuElem(21).setPosX((Integer)nX.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(21).setPosY((Integer)nY.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(21).setHeightE((Integer)nH.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(21).setWidthE(Menu_InGame_ProvInfo.tier4Width);
                ++buttonsAdded;
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(27).getVisibleE()) {
                CFG.menus.getInGameProvInfo().getMenuElem(27).setPosX((Integer)nX.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(27).setPosY((Integer)nY.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(27).setHeightE((Integer)nH.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(27).setWidthE(Menu_InGame_ProvInfo.tier4Width);
                ++buttonsAdded;
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(28).getVisibleE()) {
                CFG.menus.getInGameProvInfo().getMenuElem(28).setPosX((Integer)nX.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(28).setPosY((Integer)nY.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(28).setHeightE((Integer)nH.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(28).setWidthE(Menu_InGame_ProvInfo.tier4Width);
                ++buttonsAdded;
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(29).getVisibleE()) {
                CFG.menus.getInGameProvInfo().getMenuElem(29).setPosX((Integer)nX.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(29).setPosY((Integer)nY.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(29).setHeightE((Integer)nH.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(29).setWidthE(Menu_InGame_ProvInfo.tier4Width);
                ++buttonsAdded;
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(30).getVisibleE()) {
                CFG.menus.getInGameProvInfo().getMenuElem(30).setPosX((Integer)nX.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(30).setPosY((Integer)nY.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(30).setHeightE((Integer)nH.get(buttonsAdded));
                CFG.menus.getInGameProvInfo().getMenuElem(30).setWidthE(Menu_InGame_ProvInfo.tier4Width);
                ++buttonsAdded;
            }
            nX.clear();
            nY.clear();
            nH.clear();
            Menu_InGame_ProvInfo.iMaxWidth = 1;
            if (CFG.menus.getInGameProvInfo().getMenuElem(2).getVisibleE()) {
                Menu_InGame_ProvInfo.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(2).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(2).getWidthE(), Menu_InGame_ProvInfo.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(3).getVisibleE()) {
                Menu_InGame_ProvInfo.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(3).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(3).getWidthE(), Menu_InGame_ProvInfo.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(8).getVisibleE()) {
                Menu_InGame_ProvInfo.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE(), Menu_InGame_ProvInfo.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(9).getVisibleE()) {
                Menu_InGame_ProvInfo.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(9).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(9).getWidthE(), Menu_InGame_ProvInfo.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(10).getVisibleE()) {
                Menu_InGame_ProvInfo.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(10).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(10).getWidthE(), Menu_InGame_ProvInfo.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(11).getVisibleE()) {
                Menu_InGame_ProvInfo.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(11).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(11).getWidthE(), Menu_InGame_ProvInfo.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE()) {
                Menu_InGame_ProvInfo.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(12).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(12).getWidthE(), Menu_InGame_ProvInfo.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(13).getVisibleE()) {
                Menu_InGame_ProvInfo.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(13).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(13).getWidthE(), Menu_InGame_ProvInfo.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(15).getVisibleE()) {
                Menu_InGame_ProvInfo.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(15).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(15).getWidthE(), Menu_InGame_ProvInfo.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(16).getVisibleE()) {
                Menu_InGame_ProvInfo.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(16).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(16).getWidthE(), Menu_InGame_ProvInfo.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(17).getVisibleE()) {
                Menu_InGame_ProvInfo.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(17).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(17).getWidthE(), Menu_InGame_ProvInfo.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(18).getVisibleE()) {
                Menu_InGame_ProvInfo.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(18).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(18).getWidthE(), Menu_InGame_ProvInfo.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(19).getVisibleE()) {
                Menu_InGame_ProvInfo.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(19).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(19).getWidthE(), Menu_InGame_ProvInfo.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(20).getVisibleE()) {
                Menu_InGame_ProvInfo.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(20).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(20).getWidthE(), Menu_InGame_ProvInfo.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(21).getVisibleE()) {
                Menu_InGame_ProvInfo.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(21).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(21).getWidthE(), Menu_InGame_ProvInfo.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(22).getVisibleE()) {
                Menu_InGame_ProvInfo.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(22).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(22).getWidthE(), Menu_InGame_ProvInfo.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(23).getVisibleE()) {
                Menu_InGame_ProvInfo.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(23).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(23).getWidthE(), Menu_InGame_ProvInfo.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(25).getVisibleE()) {
                Menu_InGame_ProvInfo.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(25).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(25).getWidthE(), Menu_InGame_ProvInfo.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(27).getVisibleE()) {
                Menu_InGame_ProvInfo.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(27).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(27).getWidthE(), Menu_InGame_ProvInfo.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(28).getVisibleE()) {
                Menu_InGame_ProvInfo.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(28).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(28).getWidthE(), Menu_InGame_ProvInfo.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(29).getVisibleE()) {
                Menu_InGame_ProvInfo.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(29).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(29).getWidthE(), Menu_InGame_ProvInfo.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(30).getVisibleE()) {
                Menu_InGame_ProvInfo.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(30).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(30).getWidthE(), Menu_InGame_ProvInfo.iMaxWidth);
            }
            if ((float)((Menu_InGame_ProvInfo.iMaxWidth += CFG.PADD) + (CFG.GAMEWIDTH - CFG.menus.getInGameProvInfo().getMenuElem(0).getPosXE() + CFG.PADD * 2)) >= (float)CFG.GAMEWIDTH * 0.8f) {
                Menu_InGame_ProvInfo.iMaxWidth = -1;
            }
        }
        catch (Exception exception) {
            
        }
    }

    protected final void updateInGame_ProvinceInfoSmall() {
        block23: {
            try {
                int n = CFG.ACTIVE_PROVINCE_INFO = CFG.chosenProvinceID >= 0 ? CFG.chosenProvinceID : CFG.core.getActiveProvID();
                if (CFG.ACTIVE_PROVINCE_INFO < 0) {
                    Menu_InGame_ProvInfoSmall.iMaxWidth = 0;
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(3).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(4).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(5).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(6).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(7).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(8).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(9).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(10).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(11).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(12).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(13).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(14).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(15).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(16).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(17).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(18).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(19).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(20).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(21).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(22).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(23).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(24).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(25).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(26).setVisibleE(false);
                    return;
                }
                if (CFG.FOG_OF_WAR == 2 && !CFG.getMetProv(CFG.ACTIVE_PROVINCE_INFO)) {
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setTextE(CFG.lang.get("Undiscovered"));
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setCurr(-3);
                    CFG.menus.getInGameProvInfo().getMenuElem(6).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(3).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(8).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(4).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(5).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(7).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(9).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(10).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(11).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(12).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(13).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(14).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(15).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(16).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(17).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(18).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(19).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(20).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(21).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(22).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(23).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(24).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(25).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(26).setVisibleE(false);
                    break block23;
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getWastelandLvl() >= 0) {
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setTextE(CFG.lang.get("Wasteland"));
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setCurr(-2);
                    CFG.menus.getInGameProvInfo().getMenuElem(6).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(3).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(8).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(4).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(5).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(7).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(9).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(10).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(11).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(12).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(13).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(14).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(15).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(16).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(17).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(18).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(19).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(20).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(21).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(22).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(23).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(24).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(24).setTextE("" + (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighProvincesSize() + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighSeaProvincesSize()));
                    CFG.menus.getInGameProvInfo().getMenuElem(25).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(26).setVisibleE(false);
                    break block23;
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getSeaProv()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setTextE(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName().length() > 0 ? CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName() : CFG.lang.get("Sea"));
                    CFG.menus.getInGameProvInfo().getMenuElem(2).setCurr(-1);
                    CFG.menus.getInGameProvInfo().getMenuElem(6).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(3).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(8).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(4).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(5).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(7).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(9).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(10).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(11).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(12).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(13).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(14).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(15).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(16).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(17).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(18).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(19).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(20).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(21).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(22).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(23).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(24).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(24).setTextE("" + (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighProvincesSize() + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighSeaProvincesSize()));
                    CFG.menus.getInGameProvInfo().getMenuElem(25).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(26).setVisibleE(false);
                    break block23;
                }
                if (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName().length() > 0) {
                    CFG.core.updateProvNameWidth(CFG.ACTIVE_PROVINCE_INFO);
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setTextE(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName());
                } else {
                    CFG.core.updateProvNameWidth("Fokus");
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setVisibleE(true);
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setTextE(CFG.lang.get("Fokus"));
                }
                CFG.menus.getInGameProvInfo().getMenuElem(2).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(2).setTextE(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).getCivName());
                CFG.menus.getInGameProvInfo().getMenuElem(2).setCurr(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId());
                CFG.menus.getInGameProvInfo().getMenuElem(3).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(3).setCurr(CFG.ACTIVE_PROVINCE_INFO);
                CFG.menus.getInGameProvInfo().getMenuElem(25).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(25).setTextE("" + CFG.core.getProvinceValue(CFG.ACTIVE_PROVINCE_INFO));
                CFG.menus.getInGameProvInfo().getMenuElem(4).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(4).setCurr(CFG.ACTIVE_PROVINCE_INFO);
                int nPop = (int)CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getPop().getPops();
                CFG.menus.getInGameProvInfo().getMenuElem(4).setTextE(nPop < 1000000 ? CFG.getNumberWthSpaces("" + nPop) : CFG.getNumber_SHORT(nPop));
                CFG.menus.updateInGame_ProvinceInfoGraph(CFG.ACTIVE_PROVINCE_INFO);
                CFG.menus.getInGameProvInfo().getMenuElem(6).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(9).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(9).setCurr((int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getGrowthRate_Pop_WithFarm_WithTerrain() * 100.0f));
                CFG.menus.getInGameProvInfo().getMenuElem(9).setTextE("" + (int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getGrowthRate_Pop_WithFarm_WithTerrain() * 100.0f) + "%");
                CFG.menus.getInGameProvInfo().getMenuElem(7).setVisibleE(true);
                int nEco = (int)CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getEco();
                CFG.menus.getInGameProvInfo().getMenuElem(7).setTextE(nEco < 100000 ? CFG.getNumberWthSpaces("" + nEco) : CFG.getNumber_SHORT(nEco));
                CFG.menus.getInGameProvInfo().getMenuElem(10).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(10).setCurr((int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getDeveLvl() * 100.0f));
                CFG.menus.getInGameProvInfo().getMenuElem(10).setTextE("" + (float)((int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getDeveLvl() * 100.0f)) / 100.0f);
                CFG.menus.getInGameProvInfo().getMenuElem(11).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(11).setCurr((int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getHappi() * 100.0f));
                CFG.menus.getInGameProvInfo().getMenuElem(11).setTextE("" + (int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getHappi() * 100.0f) + "%");
                CFG.menus.getInGameProvInfo().getMenuElem(12).setVisibleE(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isFestivalOrganized(CFG.ACTIVE_PROVINCE_INFO));
                if (CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(12).setTextE("" + CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isFestivalOrganized_TurnsLeft(CFG.ACTIVE_PROVINCE_INFO));
                }
                if (CFG.menus.getVisibleInGame_CensusOfProvince()) {
                    CFG.menus.rebuildInGame_CensusOfProvince(CFG.ACTIVE_PROVINCE_INFO);
                }
                CFG.menus.getInGameProvInfo().getMenuElem(13).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(13).setCurr((int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getProviStability() * 100.0f));
                CFG.menus.getInGameProvInfo().getMenuElem(13).setTextE("" + (int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getProviStability() * 100.0f) + "%");
                CFG.menus.getInGameProvInfo().getMenuElem(14).setVisibleE(true);
                Menu_InGame_ProvInfoSmall.updateBuildingsList(CFG.ACTIVE_PROVINCE_INFO);
                CFG.menus.getInGameProvInfo().getMenuElem(15).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(15).setCurr((int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getRevRisk() * 100.0f));
                CFG.menus.getInGameProvInfo().getMenuElem(15).setTextE("" + (int)(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getRevRisk() * 100.0f) + "%");
                CFG.menus.getInGameProvInfo().getMenuElem(16).setVisibleE(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isAssimilateOrganized(CFG.ACTIVE_PROVINCE_INFO));
                if (CFG.menus.getInGameProvInfo().getMenuElem(16).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(16).setTextE("" + CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isAssimilateOrganized_TurnsLeft(CFG.ACTIVE_PROVINCE_INFO));
                }
                CFG.menus.getInGameProvInfo().getMenuElem(17).setVisibleE(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isInvestOrganized(CFG.ACTIVE_PROVINCE_INFO));
                if (CFG.menus.getInGameProvInfo().getMenuElem(17).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(17).setTextE("" + CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isInvestOrganized_TurnsLeft(CFG.ACTIVE_PROVINCE_INFO));
                }
                CFG.menus.getInGameProvInfo().getMenuElem(18).setVisibleE(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isInvestOrganized_Devel(CFG.ACTIVE_PROVINCE_INFO));
                if (CFG.menus.getInGameProvInfo().getMenuElem(18).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(18).setTextE("" + CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).isInvestOrganized_TurnsLeft_Devel(CFG.ACTIVE_PROVINCE_INFO));
                }
                CFG.menus.getInGameProvInfo().getMenuElem(19).setVisibleE(!CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getIsSupplied() && CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getIsNotSuppliedForXTurns() > 0);
                if (CFG.menus.getInGameProvInfo().getMenuElem(19).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(19).setTextE("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getIsNotSuppliedForXTurns());
                }
                if (CFG.SPECTATOR_MODE || CFG.SANDBOX_MODE || CFG.FOG_OF_WAR == 0 || CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getFog(CFG.ACTIVE_PROVINCE_INFO)) {
                    CFG.menus.getInGameProvInfo().getMenuElem(20).setVisibleE(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getDefensivePosition() > 0);
                    if (CFG.menus.getInGameProvInfo().getMenuElem(20).getVisibleE()) {
                        CFG.menus.getInGameProvInfo().getMenuElem(20).setTextE("" + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getDefensivePosition());
                    }
                } else {
                    CFG.menus.getInGameProvInfo().getMenuElem(20).setVisibleE(false);
                }
                CFG.menus.getInGameProvInfo().getMenuElem(21).setVisibleE(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.provincePlague != null);
                if (CFG.menus.getInGameProvInfo().getMenuElem(21).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(21).setTextE("" + CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.provincePlague.iDeaths);
                }
                CFG.menus.getInGameProvInfo().getMenuElem(22).setVisibleE(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iNewColonyBonus > 0);
                if (CFG.menus.getInGameProvInfo().getMenuElem(22).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(22).setTextE("" + CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iNewColonyBonus);
                }
                CFG.menus.getInGameProvInfo().getMenuElem(23).setVisibleE(CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).provGD.iSupportRebelsSize > 0);
                if (CFG.menus.getInGameProvInfo().getMenuElem(23).getVisibleE()) {
                    CFG.menus.getInGameProvInfo().getMenuElem(23).setCurr(CFG.ACTIVE_PROVINCE_INFO);
                }
                boolean tIsGenocideActive = GameManager.isGenocideActive(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), (int)CFG.ACTIVE_PROVINCE_INFO);
                if (CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).isOccupied() || tIsGenocideActive) {
                    int occTurns = CFG.core.getProv((int)CFG.ACTIVE_PROVINCE_INFO).getOccupationTurnsLeft();
                    String provName = CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName().length() > 0
                        ? CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getName()
                        : CFG.lang.get("Fokus");
                    String occTag = occTurns > 0 ? " [Occ:" + occTurns + "]" : "";
                    String genTag = tIsGenocideActive ? " [Gen:" + GameManager.getGenocideTurnsLeft(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), (int)CFG.ACTIVE_PROVINCE_INFO) + "]" : "";
                    String fullTag = occTag + genTag;
                    if (!CFG.menus.getInGameProvInfo().getMenuElem(1).getTextE().endsWith(fullTag)) {
                        CFG.menus.getInGameProvInfo().getMenuElem(1).setTextE(provName + fullTag);
                    }
                }
                
                CFG.menus.getInGameProvInfo().getMenuElem(24).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(24).setTextE("" + (CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighProvincesSize() + CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getNeighSeaProvincesSize()));
                CFG.menus.getInGameProvInfo().getMenuElem(26).setVisibleE(true);
                CFG.menus.getInGameProvInfo().getMenuElem(26).setCurr(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId());
                try {
                    CFG.menus.getInGameProvInfo().getMenuElem(8).setTextE(CFG.religionManager.getReligion(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).getReligionID()).getName());
                    CFG.menus.getInGameProvInfo().getMenuElem(8).setCurr(CFG.core.getCiv(CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId()).getReligionID());
                    CFG.menus.getInGameProvInfo().getMenuElem(8).setVisibleE(true);
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                if (!CFG.SPECTATOR_MODE && GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES && CFG.core.getProv(CFG.ACTIVE_PROVINCE_INFO).getCivId() == 0) {
                    CFG.menus.getInGameProvInfo().getMenuElem(1).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(4).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(7).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(8).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(9).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(10).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(11).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(12).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(13).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(14).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(15).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(16).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(17).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(18).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(19).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(20).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(21).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(22).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(23).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(25).setVisibleE(false);
                    CFG.menus.getInGameProvInfo().getMenuElem(26).setVisibleE(false);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        this.updateInGame_ProvinceInfo_PosXSmall();
    }

    public final void takeNextTurn() {
        if (CFG.menus.getVisibleInGame_Event()) {
            CFG.menus.centerInGame_Event();
        } else {
            if (!CFG.SPECTATOR_MODE && this.activeTurnAction == TurnStates.INPUT_ORDERS) {
                for (int i = 0; i < CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessagesSize(); ++i) {
                    if (!CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)i).requestsResponse || CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage((int)i).numOfTurnsLeft > 1) continue;
                    this.checkMessagesPauseRTS();
                    CFG.core.getCiv((int)CFG.core.getPlayer((int)CFG.PLAYER_TURN_ID).getCivId()).getCivDiploGD().messageBox.getMessage(i).onAction(i);
                    CFG.toastM.addM(CFG.lang.get("TheMessageRequiresAResponse"), CFG.COLOR_TEXT_NUM_OF_PROVINCES);
                    CFG.toastM.setTimeInView(2500);
                    return;
                }
                this.checkMessagesPauseRTS();
            }
            this.nextTurn();
        }
    }

    protected final void updateInGame_ProvinceInfo_PosXSmall() {
        try {
            CFG.menus.getInGameProvInfo().getMenuElem(3).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(2).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(2).getWidthE() - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            CFG.menus.getInGameProvInfo().getMenuElem(8).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(3).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(3).getWidthE() - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            CFG.menus.getInGameProvInfo().getMenuElem(25).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE() - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            CFG.menus.getInGameProvInfo().getMenuElem(9).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(7).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(7).getWidthE() + CFG.PADD);
            CFG.menus.getInGameProvInfo().getMenuElem(10).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(7).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(7).getWidthE() + CFG.PADD);
            CFG.menus.getInGameProvInfo().getMenuElem(11).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(9).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(9).getWidthE() + CFG.PADD);
            CFG.menus.getInGameProvInfo().getMenuElem(12).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE() - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            CFG.menus.getInGameProvInfo().getMenuElem(13).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(10).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(10).getWidthE() + CFG.PADD);
            CFG.menus.getInGameProvInfo().getMenuElem(15).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(13).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(13).getWidthE() + CFG.PADD);
            CFG.menus.getInGameProvInfo().getMenuElem(16).setPosX((CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(12).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(12).getWidthE() : CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE()) - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            CFG.menus.getInGameProvInfo().getMenuElem(17).setPosX((CFG.menus.getInGameProvInfo().getMenuElem(16).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(16).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(16).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(12).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(12).getWidthE() : CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE())) - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            CFG.menus.getInGameProvInfo().getMenuElem(18).setPosX((CFG.menus.getInGameProvInfo().getMenuElem(17).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(17).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(17).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(16).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(16).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(16).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(12).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(12).getWidthE() : CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE()))) - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            CFG.menus.getInGameProvInfo().getMenuElem(19).setPosX((CFG.menus.getInGameProvInfo().getMenuElem(18).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(18).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(18).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(17).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(17).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(17).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(16).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(16).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(16).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(12).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(12).getWidthE() : CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE())))) - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            CFG.menus.getInGameProvInfo().getMenuElem(20).setPosX((CFG.menus.getInGameProvInfo().getMenuElem(19).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(19).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(19).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(18).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(18).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(18).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(17).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(17).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(17).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(16).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(16).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(16).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(12).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(12).getWidthE() : CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE()))))) - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            CFG.menus.getInGameProvInfo().getMenuElem(21).setPosX((CFG.menus.getInGameProvInfo().getMenuElem(20).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(20).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(20).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(19).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(19).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(19).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(18).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(18).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(18).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(17).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(17).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(17).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(16).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(16).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(16).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(12).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(12).getWidthE() : CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE())))))) - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            CFG.menus.getInGameProvInfo().getMenuElem(22).setPosX((CFG.menus.getInGameProvInfo().getMenuElem(21).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(21).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(21).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(20).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(20).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(20).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(19).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(19).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(19).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(18).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(18).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(18).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(17).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(17).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(17).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(16).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(16).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(16).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(12).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(12).getWidthE() : CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE()))))))) - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            CFG.menus.getInGameProvInfo().getMenuElem(23).setPosX((CFG.menus.getInGameProvInfo().getMenuElem(22).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(22).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(22).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(21).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(21).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(21).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(20).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(20).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(20).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(19).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(19).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(19).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(18).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(18).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(18).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(17).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(17).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(17).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(16).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(16).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(16).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(12).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(12).getWidthE() : CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE())))))))) - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            Menu_InGame_ProvInfoSmall.iMaxWidth = 1;
            if (CFG.menus.getInGameProvInfo().getMenuElem(2).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(2).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(2).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(3).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(3).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(3).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(8).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(9).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(9).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(9).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(10).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(10).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(10).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(11).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(11).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(11).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(12).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(12).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(13).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(13).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(13).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(15).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(15).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(15).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(16).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(16).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(16).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(17).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(17).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(17).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(18).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(18).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(18).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(19).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(19).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(19).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(20).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(20).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(20).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(21).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(21).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(21).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(22).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(22).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(22).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(23).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(23).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(23).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(25).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(25).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(25).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if ((float)((Menu_InGame_ProvInfoSmall.iMaxWidth += CFG.PADD * 2) + (CFG.GAMEWIDTH - CFG.menus.getInGameProvInfo().getMenuElem(5).getPosXE() + CFG.PADD * 2)) >= (float)CFG.GAMEWIDTH * 0.9f) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = -1;
            }
        }
        catch (Exception exception) {
            
        }
    }

    public final void updateCivsHappiness_New() {
        for (int i = 1 + GameCalendar.TURNID % GameValues.gvUpdate.UPDATE_CIV_HAPPINESS; i < CFG.core.getCivsSize(); i += GameValues.gvUpdate.UPDATE_CIV_HAPPINESS) {
            this.updateCivsHappiness(i);
        }
    }

    public final void updateCivsHappiness_AllCivs() {
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            this.updateCivsHappiness(i);
        }
    }

    public final void updateCivsHappiness(int nCivID) {
        CFG.core.getCiv(nCivID).setHappiness((int)(this.getCivHappiness(nCivID) * 100.0f));
    }

    public final float getCivHappiness(int nCivID) {
        float tHappiness = 0.0f;
        Civilization civ = CFG.core.getCiv(nCivID);
        civ.provincesWithLowHappiness.clear();
        for (int i = 0; i < civ.getNumOfProvs(); ++i) {
            tHappiness += CFG.core.getProv(civ.getProvID(i)).getHappi();
            if (!(civ.civGD.civPers.MIN_PROVINCE_HAPPINESS_RUN_FESTIVAL > CFG.core.getProv(civ.getProvID(i)).getHappi()) || civ.isFestivalOrganized(civ.getProvID(i))) continue;
            civ.provincesWithLowHappiness.add(civ.getProvID(i));
        }
        return tHappiness / (float)civ.getNumOfProvs();
    }

    protected final void updateInGame_ProvinceInfo_PosXSmallClassic() {
        try {
            CFG.menus.getInGameProvInfo().getMenuElem(3).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(2).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(2).getWidthE() - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            CFG.menus.getInGameProvInfo().getMenuElem(8).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(3).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(3).getWidthE() - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            CFG.menus.getInGameProvInfo().getMenuElem(25).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE() - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            CFG.menus.getInGameProvInfo().getMenuElem(9).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(4).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(4).getWidthE() + CFG.PADD);
            CFG.menus.getInGameProvInfo().getMenuElem(10).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(7).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(7).getWidthE() + CFG.PADD);
            CFG.menus.getInGameProvInfo().getMenuElem(11).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(9).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(9).getWidthE() + CFG.PADD);
            CFG.menus.getInGameProvInfo().getMenuElem(12).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE() - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            CFG.menus.getInGameProvInfo().getMenuElem(13).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(10).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(10).getWidthE() + CFG.PADD);
            CFG.menus.getInGameProvInfo().getMenuElem(15).setPosX(CFG.menus.getInGameProvInfo().getMenuElem(13).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(13).getWidthE() + CFG.PADD);
            CFG.menus.getInGameProvInfo().getMenuElem(16).setPosX((CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(12).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(12).getWidthE() : CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE()) - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            CFG.menus.getInGameProvInfo().getMenuElem(17).setPosX((CFG.menus.getInGameProvInfo().getMenuElem(16).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(16).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(16).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(12).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(12).getWidthE() : CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE())) - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            CFG.menus.getInGameProvInfo().getMenuElem(18).setPosX((CFG.menus.getInGameProvInfo().getMenuElem(17).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(17).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(17).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(16).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(16).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(16).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(12).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(12).getWidthE() : CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE()))) - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            CFG.menus.getInGameProvInfo().getMenuElem(19).setPosX((CFG.menus.getInGameProvInfo().getMenuElem(18).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(18).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(18).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(17).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(17).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(17).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(16).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(16).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(16).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(12).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(12).getWidthE() : CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE())))) - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            CFG.menus.getInGameProvInfo().getMenuElem(20).setPosX((CFG.menus.getInGameProvInfo().getMenuElem(19).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(19).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(19).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(18).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(18).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(18).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(17).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(17).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(17).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(16).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(16).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(16).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(12).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(12).getWidthE() : CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE()))))) - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            CFG.menus.getInGameProvInfo().getMenuElem(21).setPosX((CFG.menus.getInGameProvInfo().getMenuElem(20).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(20).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(20).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(19).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(19).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(19).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(18).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(18).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(18).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(17).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(17).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(17).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(16).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(16).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(16).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(12).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(12).getWidthE() : CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE())))))) - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            CFG.menus.getInGameProvInfo().getMenuElem(22).setPosX((CFG.menus.getInGameProvInfo().getMenuElem(21).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(21).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(21).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(20).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(20).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(20).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(19).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(19).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(19).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(18).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(18).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(18).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(17).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(17).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(17).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(16).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(16).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(16).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(12).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(12).getWidthE() : CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE()))))))) - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            CFG.menus.getInGameProvInfo().getMenuElem(23).setPosX((CFG.menus.getInGameProvInfo().getMenuElem(22).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(22).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(22).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(21).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(21).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(21).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(20).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(20).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(20).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(19).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(19).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(19).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(18).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(18).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(18).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(17).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(17).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(17).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(16).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(16).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(16).getWidthE() : (CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE() ? CFG.menus.getInGameProvInfo().getMenuElem(12).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(12).getWidthE() : CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE())))))))) - IMGManager.getIMG(Images.botLeft).getWidth() / 2);
            Menu_InGame_ProvInfoSmall.iMaxWidth = 1;
            if (CFG.menus.getInGameProvInfo().getMenuElem(2).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(2).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(2).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(3).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(3).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(3).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(8).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(8).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(8).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(9).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(9).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(9).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(10).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(10).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(10).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(11).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(11).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(11).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(12).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(12).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(12).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(13).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(13).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(13).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(15).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(15).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(15).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(16).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(16).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(16).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(17).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(17).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(17).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(18).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(18).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(18).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(19).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(19).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(19).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(20).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(20).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(20).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(21).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(21).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(21).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(22).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(22).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(22).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(23).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(23).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(23).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if (CFG.menus.getInGameProvInfo().getMenuElem(25).getVisibleE()) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = Math.max(CFG.menus.getInGameProvInfo().getMenuElem(25).getPosXE() + CFG.menus.getInGameProvInfo().getMenuElem(25).getWidthE(), Menu_InGame_ProvInfoSmall.iMaxWidth);
            }
            if ((float)((Menu_InGame_ProvInfoSmall.iMaxWidth += CFG.PADD * 2) + (CFG.GAMEWIDTH - CFG.menus.getInGameProvInfo().getMenuElem(5).getPosXE() + CFG.PADD * 2)) >= (float)CFG.GAMEWIDTH * 0.8f) {
                Menu_InGame_ProvInfoSmall.iMaxWidth = -1;
            }
        }
        catch (Exception exception) {
            
        }
    }

    public final List<Integer> getCoalitionCivs(int civID) {
        int i;
        List<Integer> civAllies = AIPlaystyle.declareWar_AlliesDefender2(civID);
        Civilization civ = CFG.core.getCiv(civID);
        long civArmyAllies = Math.max(0L, civ.getNumberOfUnits()) + (long)(((float)Math.max(0L, civ.getGold()) + (float)Math.max(0L, civ.iBudget) * GameValues.gvWar.COALITION_BUDGET_AGAINST_MODIFIER) / (float)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT);
        int coalitionArmy = 0;
        for (int a = civAllies.size() - 1; a >= 0; --a) {
            civArmyAllies += CFG.core.getCiv(civAllies.get(a)).getNumberOfUnits() + (int)(((float)Math.max(0L, CFG.core.getCiv(civAllies.get(a)).getGold()) + (float)Math.max(0L, CFG.core.getCiv((int)civAllies.get((int)a).intValue()).iBudget) * GameValues.gvWar.COALITION_BUDGET_AGAINST_MODIFIER) / (float)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT);
        }
        ArrayList<Integer> possibleCivs = new ArrayList<Integer>();
        for (i = 0; i < civ.civNeighbors.civsSize; ++i) {
            if (civ.civNeighbors.civs.get((int)i).civID == civID || civAllies.contains(civ.civNeighbors.civs.get((int)i).civID) || possibleCivs.contains(civ.civNeighbors.civs.get((int)i).civID)) continue;
            possibleCivs.add(civ.civNeighbors.civs.get((int)i).civID);
            coalitionArmy += CFG.core.getCiv(civ.civNeighbors.civs.get((int)i).civID).getNumberOfUnits();
        }
        if (possibleCivs.isEmpty() || (float)civArmyAllies > (float)coalitionArmy * GameValues.gvWar.COALITION_ARMY_MODIFIER) {
            block2: for (i = 0; i < civ.civNeighbors.civsSize; ++i) {
                for (int j = 0; j < CFG.core.getCiv((int)civ.civNeighbors.civs.get((int)i).civID).civNeighbors.civsSize; ++j) {
                    if (CFG.core.getCiv((int)civ.civNeighbors.civs.get((int)i).civID).civNeighbors.civs.get((int)j).civID == civID || civAllies.contains(CFG.core.getCiv((int)civ.civNeighbors.civs.get((int)i).civID).civNeighbors.civs.get((int)j).civID) || possibleCivs.contains(CFG.core.getCiv((int)civ.civNeighbors.civs.get((int)i).civID).civNeighbors.civs.get((int)j).civID)) continue;
                    possibleCivs.add(CFG.core.getCiv((int)civ.civNeighbors.civs.get((int)i).civID).civNeighbors.civs.get((int)j).civID);
                    if ((float)civArmyAllies < (float)(coalitionArmy += CFG.core.getCiv(CFG.core.getCiv((int)civ.civNeighbors.civs.get((int)i).civID).civNeighbors.civs.get((int)j).civID).getNumberOfUnits()) * GameValues.gvWar.COALITION_ARMY_MODIFIER) continue block2;
                }
            }
        }
        return possibleCivs;
    }

    public int fightCoalition(int civID) {
        List<Integer> coalition = this.getCoalitionCivs(civID);
        if (!coalition.isEmpty()) {
            int bestID = 0;
            for (int i = 1; i < coalition.size(); ++i) {
                if (CFG.core.getCiv(coalition.get(i)).getRankPos() >= CFG.core.getCiv(coalition.get(bestID)).getRankPos()) continue;
                bestID = i;
            }
            CFG.core.declareWar(coalition.get(bestID), civID, true);
            int tWarID = CFG.core.getWarID(coalition.get(bestID), civID);
            int out = coalition.get(bestID);
            coalition.remove(bestID);
            if (tWarID >= 0) {
                int i;
                for (i = 1; i < coalition.size(); ++i) {
                    CFG.core.joinWar(coalition.get(i), civID, tWarID);
                }
                if (CFG.core.getCiv(civID).getIsPlayer()) {
                    for (i = 1; i < coalition.size(); ++i) {
                        for (int a = 0; a < CFG.core.getCiv(coalition.get(i)).getNumOfProvs(); ++a) {
                            CFG.core.getProv(CFG.core.getCiv(coalition.get(i)).getProvID(a)).updateDrawArmyInProv();
                        }
                    }
                }
            }
            return out;
        }
        return -1;
    }

    public final void buildRank_Score() {
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            this.buildRank_Score(i);
        }
        this.buildRank_Positions();
    }

    public final void buildRank_Score(int nCivID) {
        int nScore = 0;
        if (GameValues.gvRankingSystem.MILITARY) {
            nScore += (int)this.buildRank_Score_Military(nCivID);
        }
        if (GameValues.gvRankingSystem.PRESTIGE) {
            nScore += (int)(this.buildRank_Score_Prestige(nCivID) / 3L);
        }
        if (GameValues.gvRankingSystem.POPULATION) {
            nScore += (int)this.buildRank_Score_Population(nCivID);
        }
        if (GameValues.gvRankingSystem.ECONOMY) {
            nScore += (int)this.buildRank_Score_Economy(nCivID);
        }
        if (GameValues.gvRankingSystem.HAPPINESS) {
            nScore += this.buildRank_Score_Happiness(nCivID);
        }
        CFG.core.getCiv(nCivID).setRankScore(nScore);
    }

    public final long buildRank_Score_Military(int nCivID) {
        return (long)((float)CFG.core.getCiv(nCivID).getNumberOfUnits() * (1.0f + CFG.core.getCiv(nCivID).getTechLevel()) / 25000.0f);
    }

    public final void buildRank_Positions() {
        int i;
        ArrayList<Integer> tCivIDs = new ArrayList<Integer>();
        int rankingMaxCivs = 0;
        if (CFG.core.getSortedCivsSize() > 0) {
            if (CFG.core.getSortedCivsSize() != CFG.core.getCivsSize() - 1) {
                CFG.core.sortCivilizationsAZ();
            }
            for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                tCivIDs.add(CFG.core.getSortedCivsAZ(i - 1));
            }
        } else {
            for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                tCivIDs.add(i);
            }
        }
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
            ++rankingMaxCivs;
        }
        int tRank = 1;
        int tAddID = 0;
        while (!tCivIDs.isEmpty()) {
            tAddID = 0;
            for (int i2 = tCivIDs.size() - 1; i2 > 0; --i2) {
                if (CFG.core.getCiv((Integer)tCivIDs.get(tAddID)).getRankScore() >= CFG.core.getCiv((Integer)tCivIDs.get(i2)).getRankScore()) continue;
                tAddID = i2;
            }
            CFG.core.getCiv((Integer)tCivIDs.get(tAddID)).setRankPos(tRank++);
            tCivIDs.remove(tAddID);
        }
        CFG.numGold = (int)Math.min((double)GameValues.gvRankStars.GOLD_RANK_CIVS_MAX, Math.max((double)GameValues.gvRankStars.GOLD_RANK_CIVS_MIN, Math.ceil((float)rankingMaxCivs * GameValues.gvRankStars.GOLD_RANK_CIVS_PERCENT)));
        CFG.numSilver = CFG.numGold + (int)Math.min((double)GameValues.gvRankStars.SILVER_RANK_CIVS_MAX, Math.max((double)GameValues.gvRankStars.SILVER_RANK_CIVS_MIN, Math.ceil((float)rankingMaxCivs * GameValues.gvRankStars.SILVER_RANK_CIVS_PERCENT)));
        CFG.numBronze = CFG.numSilver + Math.max(GameValues.gvRankStars.BRONZE_RANK_CIVS_MIN, (int)((float)rankingMaxCivs * GameValues.gvRankStars.BRONZE_RANK_CIVS_PERCENT));
    }

    public final long buildRank_Score_Population(int nCivID) {
        float nScore = 0.0f;
        float nTech = Math.min(1.0f, CFG.core.getCiv(nCivID).getTechLevel());
        for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
            Province province = CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i));
            for (int j = 0; j < province.getPop().getNatsSize(); ++j) {
                nScore += (float)province.getPop().getPopulationID(j) / ((float)CFG.core.getGameScenars().getScenario_StartingPopulation() / GameValues.gvRankScore.POP_RANK_SCORE_POP_DIVISOR) * (province.getPop().getCivID(j) == nCivID ? GameValues.gvRankScore.POP_RANK_SCORE_SAME_CIV_WEIGHT : GameValues.gvRankScore.POP_RANK_SCORE_FOREIGN_CIV_WEIGHT) * (GameValues.gvRankScore.POP_RANK_SCORE_STABILITY_MODIFIER_BASE + GameValues.gvRankScore.POP_RANK_SCORE_STABILITY_WEIGHT * province.getProviStability()) * (GameValues.gvRankScore.POP_RANK_SCORE_TECH_MODIFIER_BASE + GameValues.gvRankScore.POP_RANK_SCORE_TECH_WEIGHT * nTech) * (province.isOccupied() ? GameValues.gvRankScore.POP_RANK_SCORE_OCCUPIED_PROVINCE_MODIFIER : 1.0f);
            }
        }
        return (long)Math.ceil(nScore);
    }

    public final long buildRank_Score_Economy(int nCivID) {
        float nScore = 0.0f;
        for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
            nScore += (float)CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getEco() / ((float)CFG.core.getGameScenars().getScenario_StartingEconomy() / GameValues.gvRankScore.ECON_RANK_SCORE_ECONOMY_DIVISOR) * (GameValues.gvRankScore.ECON_RANK_SCORE_BASE_DEV_MODIFIER + GameValues.gvRankScore.ECON_RANK_SCORE_DEV_WEIGHT * CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getDeveLvl()) * (GameValues.gvRankScore.ECON_RANK_SCORE_BASE_STABILITY_MODIFIER + GameValues.gvRankScore.ECON_RANK_SCORE_STABILITY_WEIGHT * CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getProviStability());
        }
        return (long)Math.ceil(nScore);
    }

    public final long buildRank_Score_Prestige(int nCivID) {
        Civilization civ = CFG.core.getCiv(nCivID);
        float nScore = 0.0f;
        float nTech = Math.min(1.0f, civ.getTechLevel());
        if (civ.getNumOfProvs() > 0) {
            for (int i = 0; i < civ.getNumOfProvs(); ++i) {
                nScore += GameValues.gvRankScore.PRESTIGE_BASE_PROVINCE_SCORE * (GameValues.gvRankScore.PRESTIGE_POP_GROWTH_BASE + GameValues.gvRankScore.PRESTIGE_POP_GROWTH_WEIGHT * CFG.core.getProv(civ.getProvID(i)).getGrowthRate_Pop_WithFarm()) * (GameValues.gvRankScore.PRESTIGE_TECH_BASE + GameValues.gvRankScore.PRESTIGE_TECH_WEIGHT * nTech) * (CFG.core.getProv(civ.getProvID(i)).getCores().getHaveACore(nCivID) ? GameValues.gvRankScore.PRESTIGE_CORE_MODIFIER : GameValues.gvRankScore.PRESTIGE_NONCORE_MODIFIER) * (GameValues.gvRankScore.PRESTIGE_DEV_BASE + GameValues.gvRankScore.PRESTIGE_DEV_WEIGHT * CFG.core.getProv(civ.getProvID(i)).getDeveLvl());
            }
            nScore += GameValues.gvRankScore.PRESTIGE_TECH_BONUS * civ.getTechLevel();
        }
        return (long)Math.ceil(nScore);
    }
    public final int buildRank_Score_Happiness(int nCivID) {
        return (int)(CFG.core.getCiv(nCivID).fStability * 100.0f);
    }

    public final boolean isMovingArmyFromProvince(int nProvinceID, int nCivID) {
        for (int i = 0; i < CFG.core.getCiv(nCivID).moveUnitsSize(); ++i) {
            if (CFG.core.getCiv(nCivID).getMoveUnits(i).getFromProviID() != nProvinceID) continue;
            return true;
        }
        return false;
    }

    public final boolean controlsArmyInProvince(int nProvinceID) {
        return this.controlsArmyInProvince(nProvinceID, CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
    }

    public final void spawnRevolutionInProvinceID(int nCivID, int nRebelsCivID, int nProvinceID, List<Integer> nProvinces, List<Integer> nOverMin) {
        int i;
        int j;
        int i2;
        String nRevTag = CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(nCivID).getCivTag()) + CFG.ideologiesMgr.getIdeologyID(CFG.ideologiesMgr.REBELS_ID).getExtraTag();
        int nLastID = -1;
        for (int i3 = 1; i3 < CFG.core.getCivsSize(); ++i3) {
            int tID;
            if (!this.getSpawnRebels_CivRebelsTag(i3).equals(nRevTag) || (tID = this.getSpawnRebels_CivRebelsTag_GetID(i3)) < nLastID) continue;
            nLastID = tID + 1;
        }
        if (nLastID >= 0) {
            nRevTag = CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(nCivID).getCivTag()) + CFG.ideologiesMgr.getIdeologyID(CFG.ideologiesMgr.REBELS_ID).getExtraTag() + nLastID;
        }
        ArrayList<Province_Army> tempArmies = new ArrayList<Province_Army>();
        ArrayList<Integer> tempArmiesProvinces = new ArrayList<Integer>();
        if (nRebelsCivID <= 0) {
            for (int r = 1; r < CFG.core.getCivsSize(); ++r) {
                if (CFG.core.getCiv(r).getIdeology() == CFG.ideologiesMgr.REBELS_ID && CFG.core.getCiv(r).getCivTag().equals(nRevTag)) {
                    nRebelsCivID = r;
                    break;
                }
            }
            if (nRebelsCivID <= 0) {
                CFG.core.createScenarioAddCivilization(nRevTag, nProvinceID, false, false, true, false);
                for (i2 = CFG.core.getCivsSize() - 1; i2 > 0; --i2) {
                    if (CFG.core.getCiv(i2).getIdeology() != CFG.ideologiesMgr.REBELS_ID || !CFG.core.getCiv(i2).getCivTag().equals(nRevTag)) continue;
                    nRebelsCivID = i2;
                    break;
                }
            }
            if (nRebelsCivID > 0) {
                this.spawnRevolution_UpdateCivData(nCivID, nRebelsCivID, nRevTag);
            }
        } else if (!CFG.core.getCiv(nRebelsCivID).getCivTag().equals(nRevTag)) {
            this.spawnRevolution_UpdateCivData(nCivID, nRebelsCivID, nRevTag);
        } else {
            this.spawnRevolution_UpdateCivData(nCivID, nRebelsCivID, nRevTag);
        }
        if (nRebelsCivID < 0) {
            return;
        }
        if (CFG.core.getProv(nProvinceID).getArmyID(0) > 0) {
            long defenderArmy = CFG.core.getProv(nProvinceID).getArmyID(0);
            long rebelArmy = this.getRevolutionaryArmySize(nProvinceID, nCivID, nRebelsCivID);
            if (rebelArmy < defenderArmy) {
                return;
            }
            CFG.core.getProv(nProvinceID).updateArmy4(0);
        }
        CFG.core.getCiv(nRebelsCivID).civGD.iTurnsSinceLastAttack = 100;
        CFG.core.getCiv((int)nRebelsCivID).civGD.iRevolt_SinceTurn = GameCalendar.TURNID;
        CFG.core.getCiv((int)nRebelsCivID).civGD.iRevolt_LastTurnLostProvince = GameCalendar.TURNID;
        CFG.core.getCiv(nRebelsCivID).setCapitalProvID(nProvinceID);
        CFG.core.getProv(nProvinceID).setIsCapital(true);
        if (CFG.core.getProv(CFG.core.getCiv(nRebelsCivID).getCapitalProvID()).getCitSize() > 0) {
            for (i2 = 0; i2 < CFG.core.getProv(CFG.core.getCiv(nRebelsCivID).getCapitalProvID()).getCitSize(); ++i2) {
                if (CFG.core.getProv(CFG.core.getCiv(nRebelsCivID).getCapitalProvID()).getCit(i2).getCityLevel() != CFG.getEditorCityLevel(0)) continue;
                CFG.core.getProv(CFG.core.getCiv(nRebelsCivID).getCapitalProvID()).getCit(i2).setCityLevel(CFG.getEditorCityLevel(1));
            }
            CFG.core.getProv(CFG.core.getCiv(nRebelsCivID).getCapitalProvID()).getCit(0).setCityLevel(CFG.getEditorCityLevel(0));
        }
        CFG.core.getProv(nProvinceID).setCivId(nRebelsCivID, true);
        CFG.core.getProv(nProvinceID).setTrueOwnerOfProv(nCivID);
        this.updateProvinceAfterRevolution(nProvinceID);
        CFG.core.getProv(nProvinceID).updateArmy4(nRebelsCivID, 0);
        CFG.core.getCiv(nRebelsCivID).setNumberOfUnits(0);
        this.spawnRevolutionaryArmy(nProvinceID, nCivID, nRebelsCivID);
        if (CFG.core.getCiv(nCivID).getIsPlayer()) {
            CFG.core.getCiv((int)nCivID).civGD.civDiploGD.messageBox.addMessage(new Message_Revolt(nRebelsCivID, nProvinceID));
        }
        ArrayList<Integer> joinProvinces = new ArrayList<Integer>();
        for (int i5 = 0; i5 < nProvinces.size(); ++i5) {
            if (nProvinces.get(i5) != nProvinceID) {
                joinProvinces.add(nProvinces.get(i5));
            }
        }
        for (int i5 = 0; i5 < nOverMin.size(); ++i5) {
            boolean wasAdded = (nOverMin.get(i5) == nProvinceID);
            for (int j3 = 0; j3 < joinProvinces.size(); ++j3) {
                if (joinProvinces.get(j3) != nOverMin.get(i5)) continue;
                wasAdded = true;
                break;
            }
            if (!wasAdded) {
                joinProvinces.add(nOverMin.get(i5));
            }
        }
        for (i = 0; i < joinProvinces.size(); ++i) {
            int joinProvID = (Integer)joinProvinces.get(i);
            if (CFG.core.getProv(joinProvID).getCivId() == nRebelsCivID) continue;
            if (CFG.core.getProv(joinProvID).getArmyID(0) > 0) {
                long defenderArmy = CFG.core.getProv(joinProvID).getArmyID(0);
                long rebelArmy = this.getRevolutionaryArmySize(joinProvID, nCivID, nRebelsCivID);
                if (rebelArmy < defenderArmy) {
                    continue;
                }
                CFG.core.getProv(joinProvID).updateArmy4(0);
            }
            CFG.core.getProv(joinProvID).setCivId(nRebelsCivID, true);
            this.spawnRevolutionaryArmy(joinProvID, nCivID, nRebelsCivID);
            this.updateProvinceAfterRevolution(joinProvID);
        }
        CFG.core.getCiv(nRebelsCivID).buildCivPersonality();
        for (i = 0; i < tempArmies.size(); ++i) {
            CFG.core.getProv((Integer)tempArmiesProvinces.get(i)).updateArmy4(((Province_Army)tempArmies.get(i)).getCivID(), ((Province_Army)tempArmies.get(i)).getArmy());
            CFG.core.getCiv(((Province_Army)tempArmies.get(i)).getCivID()).newMove((Integer)tempArmiesProvinces.get(i), (Integer)tempArmiesProvinces.get(i), ((Province_Army)tempArmies.get(i)).getArmy(), true);
            for (int a = CFG.core.getProv((Integer)tempArmiesProvinces.get(i)).getCivsSize() - 1; a >= 0; --a) {
                if (CFG.core.getProv((Integer)tempArmiesProvinces.get(i)).getCivId(a) == nCivID || CFG.core.getProv((Integer)tempArmiesProvinces.get(i)).getCivId(a) == nRebelsCivID) continue;
                this.accessLost_MoveArmyToClosetsProvince(CFG.core.getProv((Integer)tempArmiesProvinces.get(i)).getCivId(a), (Integer)tempArmiesProvinces.get(i));
            }
        }
    }

    public final void aA() {
        try {
            if (!CFG.SPECTATOR_MODE) {
                for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                    Civilization civ;
                    if (!CFG.core.getPlayer((int)i).playerGD.AUTO_ASSIMILATE || (civ = CFG.core.getCiv(CFG.core.getPlayer(i).getCivId())).getNumOfProvs() <= 0 || civ.getDiploPoints() < GameValues.gvAssimilate.COST_ASSIMILATE_MOVEMENT || civ.getGold() <= (long)(GameValues.gvAssimilate.BASE_COST_OF_ASSIMILATE * 2)) continue;
                    CFG.core.assimilateAllProvinces(CFG.core.getPlayer(i).getCivId());
                }
            }
        }
        catch (Exception exception) {
            
        }
    }

    public static enum TurnStates {
        INPUT_ORDERS,
        LOAD_AI_RTO,
        TURN_ACTIONS,
        LOADING_NEXT_TURN,
        START_NEXT_TURN,
        SAVE_THE_GAME,
        RESULTS_STANDINGS,
        END_OF_THE_GAME;

    }
}





