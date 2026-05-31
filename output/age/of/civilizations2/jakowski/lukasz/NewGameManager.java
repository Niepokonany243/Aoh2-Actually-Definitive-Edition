
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.FormableCivs_GameData;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.CitiesManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.Menus.Load.Menu_LoadSave;
import age.of.civilizations2.jakowski.lukasz.Messages.War.Message_War;
import age.of.civilizations2.jakowski.lukasz.Render;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;
import age.of.civilizations2.jakowski.lukasz.TechManager;
import age.of.civilizations2.jakowski.lukasz.VictoryManager;
import age.of.civilizations2.jakowski.lukasz.View;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.Random;

public class NewGameManager {
    public final void updateDeclareWarAll() {
        if (GameCalendar.AI_AGGRESSIVENESS <= 0.0f) {
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                CFG.core.getCiv((int)i).civGD.declareWarCheckNextTurnID = CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS + GameCalendar.TURNID + 10000;
                CFG.core.getCiv((int)i).civGD.resumeLookingForRivalAtTurnID = (int)(2.0f + ((float)CFG.oR.nextInt(8) + (float)CFG.oR.nextInt(CFG.core.getCivsSize() + 1) / 50.0f) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
                CFG.core.getCiv((int)i).civGD.resumeLookingForFriendsAtTurnID = (int)(2.0f + ((float)CFG.oR.nextInt(8) + (float)CFG.oR.nextInt(CFG.core.getCivsSize() + 1) / 50.0f) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
                CFG.core.getCiv((int)i).civGD.checkFormCiv_TurnID = 50 + CFG.oR.nextInt(50);
                CFG.core.getCiv((int)i).civGD.allianceUpdate_TurnID = (int)(26.0f + (float)CFG.oR.nextInt(40) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
                CFG.core.getCiv((int)i).civGD.circledVassals_TurnID = (int)(65.0f + (float)CFG.oR.nextInt(75) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
            }
        } else {
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                CFG.core.getCiv((int)i).civGD.declareWarCheckNextTurnID = CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS + 4 + (int)((float)(CFG.oR.nextInt(45) + (int)((float)CFG.oR.nextInt(CFG.core.getCivsSize()) / 30.0f)) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
                CFG.core.getCiv((int)i).civGD.resumeLookingForRivalAtTurnID = (int)(2.0f + ((float)CFG.oR.nextInt(8) + (float)CFG.oR.nextInt(CFG.core.getCivsSize() + 1) / 50.0f) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
                CFG.core.getCiv((int)i).civGD.resumeLookingForFriendsAtTurnID = (int)(2.0f + ((float)CFG.oR.nextInt(8) + (float)CFG.oR.nextInt(CFG.core.getCivsSize() + 1) / 50.0f) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
                CFG.core.getCiv((int)i).civGD.checkFormCiv_TurnID = 50 + CFG.oR.nextInt(50);
                CFG.core.getCiv((int)i).civGD.allianceUpdate_TurnID = (int)(26.0f + (float)CFG.oR.nextInt(40) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
                CFG.core.getCiv((int)i).civGD.circledVassals_TurnID = (int)(65.0f + (float)CFG.oR.nextInt(75) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
            }
        }
    }

    public final void newGamePrep() {
        int i;
        int i2;
        GameCalendar.TURNID = 1;
        CFG.PLAYER_TURN_ID = 0;
        GameAction.gameEnded = false;
        CFG.gameAction.battleReports.clear();
        CFG.gameAction.setActiveTurnState(GameAction.TurnStates.INPUT_ORDERS);
        SaveGameManager.saveRequest = false;
        CFG.core.clearMoveUnits_JustDraw_AnotherArmies();
        CFG.menus.setVisibleInGame_Event(false);
        CFG.mapModesManager.disableAllViews();
        CFG.mapModesManager.clearData();
        CFG.mapModesManager = new MapModesManager();
        if (CFG.RANDOM_PLACEMENT || CFG.RANDOM_FILL) {
            for (i2 = 0; i2 < CFG.core.getProvinSize(); ++i2) {
                CFG.core.getProv(i2).resetArmiesAll(0);
            }
        }
        if (!CFG.FILL_THE_MAP) {
            GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES = false;
        }
        if (CFG.RANDOM_PLACEMENT) {
            this.randomPlacement();
        }
        if (CFG.RANDOM_FILL) {
            this.randomFill();
        }
        if (!CFG.FILL_THE_MAP) {
            GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES = false;
        }
        if (CFG.RANDOM_FILL || CFG.RANDOM_PLACEMENT || !CFG.FILL_THE_MAP) {
            CFG.core.getGameScenars().buildProvincePopulationAndEconomy(false, false);
        } else {
            CFG.core.getGameScenars().loadArmiesData();
        }
        if (CFG.TOTAL_WARMODE) {
            for (i2 = 1; i2 < CFG.core.getCivsSize() - 1; ++i2) {
                if (CFG.core.getCiv(i2).getNumOfProvs() <= 0) continue;
                for (int a = 0; a < CFG.core.getCiv((int)i2).civNeighbors.civsSize; ++a) {
                    if (CFG.core.getCiv(CFG.core.getCiv((int)i2).civNeighbors.civs.get((int)a).civID).getNumOfProvs() <= 0 || CFG.core.getCiv(i2).getAlliance() > 0 && CFG.core.getCiv(i2).getAlliance() == CFG.core.getCiv(CFG.core.getCiv((int)i2).civNeighbors.civs.get((int)a).civID).getAlliance()) continue;
                    CFG.core.setCivNonAggressionPact(i2, CFG.core.getCiv((int)i2).civNeighbors.civs.get((int)a).civID, 0);
                    CFG.core.setCivRelationOfCivB_AtWar(i2, CFG.core.getCiv((int)i2).civNeighbors.civs.get((int)a).civID);
                    CFG.core.setCivRelationOfCivB_AtWar(CFG.core.getCiv((int)i2).civNeighbors.civs.get((int)a).civID, i2);
                }
            }
        }
        CFG.core.sortCivilizationsAZ();
        NewGameManager.buildFormableCivilizations();
        if (CFG.SPECTATOR_MODE) {
            NewGameManager.newGame_InitPlayers_SpectatorMode();
        } else {
            this.newGame_InitPlayers();
        }
        try {
            if (!CFG.SPECTATOR_MODE) {
                CFG.map.getMpC().centerToProvID(CFG.core.getCiv(CFG.core.getPlayer(0).getCivId()).getCapitalProvID());
            }
        }
        catch (Exception i3) {
            
        }
        this.build_StartingBuildings();
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
            CFG.core.getCiv(i).updateNumberOfUnits();
        }
        CFG.map.getMpC().setDisableMovingMap(false);
        if (CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID() >= 0) {
            CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
        }
        CFG.gameAction.updateCivsMovementPoints();
        CFG.gameAction.updateCivsDiploPoints_StartTheGame();
        try {
            CFG.gameAction.updateIsSupplied();
            NewGameManager.build_ArmyInAnotherProvince();
            if (CFG.FOG_OF_WAR > 0) {
                if (CFG.FOG_OF_WAR == 2) {
                    for (i = 0; i < CFG.core.getPlayersSize(); ++i) {
                        CFG.PLAYER_TURN_ID = i;
                        CFG.gameAction.buildFogOfWar(i);
                        CFG.core.getPlayer(i).buildMetProvsAndCivs();
                    }
                    CFG.PLAYER_TURN_ID = 0;
                    for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                        CFG.core.getProv(i).updateProvinceBorder();
                    }
                    Render.updateDrawCivRegionNames_FogOfWar();
                } else {
                    for (i = 0; i < CFG.core.getPlayersSize(); ++i) {
                        CFG.PLAYER_TURN_ID = i;
                        CFG.gameAction.buildFogOfWar(i);
                    }
                    CFG.PLAYER_TURN_ID = 0;
                }
            }
            for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                CFG.core.getProv(i).updateDrawArmyInProv();
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        CFG.gameAction.updateCivsHappiness_AllCivs();
        CFG.gameUpdate.updateProvinceStabilityAllProvinces();
        NewGameManager.updateBudgetSpendings();
        CFG.gameUpdate.updateInflationPeakValueAllCivs();
        CFG.gameUpdate.updatePlayableProvinces();
        TechManager.updateAverageTechLevel();
        this.buildCurrentWars();
        GameManager.sendUncivilizedMessages();
        GameManager.sendTechPointsMessages();
        this.buildAIPersonalities();
        if (CFG.SANDBOX_MODE && !CFG.SPECTATOR_MODE) {
            NewGameManager.sandboxMode();
        }
        if (CFG.SANDBOX_MODE_AI) {
            NewGameManager.sandboxMode_AI();
        }
        CFG.hreMgr.getHRE().randomNextElections();
        CFG.setActiveCivInfoId(0);
        CFG.map.getMpB().disposeMinimapOfCivilizations();
        CFG.timelapseManager.newGame();
        SaveGameManager.newGame();
        SaveGameManager.gameCanBeContinued = true;
        GameManager.buildFriendlyCivs();
        VictoryManager.checkVictoryConditions();
        CFG.oAI.updateExpand();
        this.updateDeclareWarAll();
        CFG.core.clearPropaganda();
        CFG.core.cleanForeignInvestmentBuild();
        Images.topGoldC = 0;
        Images.updateGold();
    }

    public final void loadGame(int iLoadID) {
        CFG.core.setActiveProvID(-1);
        CFG.core.clearMoveUnits_JustDraw_AnotherArmies();
        CFG.gameAction.setActiveTurnState(GameAction.TurnStates.INPUT_ORDERS);
        GameCalendar.TURNID = 1;
        CFG.PLAYER_TURN_ID = 0;
        GameAction.gameEnded = false;
        CFG.gameAction.battleReports.clear();
        CFG.menus.setVisibleInGame_Event(false);
        CFG.mapModesManager.disableAllViews();
        CFG.mapModesManager.clearData();
        CFG.mapModesManager = new MapModesManager();
        Menu_LoadSave.iLoadID = iLoadID;
        Menu_LoadSave.loadStepID = 0;
        Menu_LoadSave.loadStepID_TEXT = 1;
        Menu_LoadSave.pause = false;
        CFG.menus.setMenuIDWithoutAnim(View.eLOAD_SAVE);
    }

    public static final void build_ArmyInAnotherProvince() {
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            CFG.core.getProv(i).build_ArmyInAnotherProvince();
        }
    }

    public final void buildAIPersonalities() {
        int i;
        int i2;
        ArrayList<Integer> lUncivilizedCivs = new ArrayList<Integer>();
        for (int i3 = 1; i3 < CFG.core.getCivsSize(); ++i3) {
            if (CFG.core.getCiv(i3).getNumOfProvs() <= 0 || CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)i3).getIdeology()).CAN_BECOME_CIVILIZED < 0) continue;
            lUncivilizedCivs.add(i3);
        }
        ArrayList<Integer> lUncivilizedSorted = new ArrayList<Integer>();
        while (!lUncivilizedCivs.isEmpty()) {
            int tBestID = 0;
            for (i2 = 1; i2 < lUncivilizedCivs.size(); ++i2) {
                if (!(CFG.core.getCiv((Integer)lUncivilizedCivs.get(tBestID)).getTechLevel() < CFG.core.getCiv((Integer)lUncivilizedCivs.get(i2)).getTechLevel())) continue;
                tBestID = i2;
            }
            lUncivilizedSorted.add((Integer)lUncivilizedCivs.get(tBestID));
            lUncivilizedCivs.remove(tBestID);
        }
        if (!lUncivilizedSorted.isEmpty()) {
            int top10 = Math.max(1, lUncivilizedSorted.size() / 10);
            for (i2 = 0; i2 < top10 && i2 < lUncivilizedSorted.size(); ++i2) {
                CFG.core.getCiv((int)((Integer)lUncivilizedSorted.get((int)i2)).intValue()).UNCIVILIZED_MIGRATE = 55 + CFG.oR.nextInt(45);
                CFG.core.getCiv((int)((Integer)lUncivilizedSorted.get((int)i2)).intValue()).UNCIVILIZED_WILLING_TO_CIVILIZE = 55 + CFG.oR.nextInt(45);
            }
        }
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
            CFG.core.getCiv(i).setCoreCapitalProvID(CFG.core.getCiv(i).getCapitalProvID());
        }
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
            CFG.core.getCiv(i).buildCivPersonality_AIAggression();
        }
    }

    public final void buildCurrentWars2() {
        CFG.core.buildWars();
        this.buildCurrentWars();
    }

    public final void buildCurrentWars() {
        for (int i = 1; i < CFG.core.getCivsSize() - 1; ++i) {
            for (int j = i + 1; j < CFG.core.getCivsSize(); ++j) {
                if ((int)CFG.core.getCivRelationOfCivB(i, j) != GameValues.gvDiplomacy.RELATION_AT_WAR) continue;
                CFG.core.addWarData(i, j);
                CFG.core.getCiv((int)i).isAtWarWithCivs.add(j);
                CFG.core.getCiv((int)j).isAtWarWithCivs.add(i);
                CFG.core.getCiv((int)i).getCivDiploGD().messageBox.addMessage(new Message_War(j, i));
                CFG.core.getCiv((int)j).getCivDiploGD().messageBox.addMessage(new Message_War(i, j));
            }
        }
    }

    public final void build_StartingBuildings() {
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            CFG.oAI.getAIStyle(CFG.core.getCiv(i).getAIStyleID()).buildStartingBuildings(i);
        }
    }

    public final void newRandomGamePrep() {
        int i;
        GameCalendar.TURNID = 1;
        CFG.PLAYER_TURN_ID = 0;
        SaveGameManager.saveRequest = false;
        GameAction.gameEnded = false;
        CFG.gameAction.battleReports.clear();
        CFG.gameAction.setActiveTurnState(GameAction.TurnStates.INPUT_ORDERS);
        CFG.core.clearMoveUnits_JustDraw_AnotherArmies();
        CFG.menus.setVisibleInGame_Event(false);
        CFG.mapModesManager.disableAllViews();
        CFG.mapModesManager.clearData();
        CFG.mapModesManager = new MapModesManager();
        GameCalendar.updateAge();
        for (i = 0; i < CFG.core.getProvinSize(); ++i) {
            CFG.core.getProv(i).resetArmiesAll(0);
        }
        if (CFG.RANDOM_FILL) {
            this.randomFill();
            CFG.core.getGameScenars().buildProvincePopulationAndEconomy(false, false);
        }
        CFG.core.sortCivilizationsAZ();
        NewGameManager.buildFormableCivilizations();
        for (i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getSeaProv()) continue;
            CFG.core.getProv(i).buildProvinceCore();
        }
        if (CFG.SPECTATOR_MODE) {
            NewGameManager.newGame_InitPlayers_SpectatorMode();
        } else {
            this.newGame_InitPlayers();
            CFG.map.getMpC().centerToProvID(CFG.core.getCiv(CFG.core.getPlayer(0).getCivId()).getCapitalProvID());
        }
        this.build_StartingBuildings();
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.core.getCiv(i).getCapitalProvID() >= 0) {
                CFG.core.getProv(CFG.core.getCiv(i).getCapitalProvID()).updateArmy4(CFG.core.getGameScenars().getScenario_StartingArmyInCapitals());
            }
            CFG.core.getCiv(i).updateNumberOfUnits();
        }
        for (i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0 || CFG.core.getProv(i).getCivId() != 0) continue;
            CFG.core.getProv(i).updateArmy4(CFG.randomGameManager.getNeutralArmy());
        }
        CFG.map.getMpC().setDisableMovingMap(false);
        CFG.core.setActiveProvID(CFG.core.getCiv(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()).getCapitalProvID());
        this.buildAIPersonalities();
        GameManager.sendUncivilizedMessages();
        GameManager.sendTechPointsMessages();
        CFG.gameAction.updateCivsMovementPoints();
        CFG.gameAction.updateCivsDiploPoints_StartTheGame();
        CFG.core.buildWastelandLevels();
        CFG.gameAction.updateIsSupplied();
        NewGameManager.build_ArmyInAnotherProvince();
        if (CFG.FOG_OF_WAR > 0) {
            if (CFG.FOG_OF_WAR == 2) {
                for (i = 0; i < CFG.core.getPlayersSize(); ++i) {
                    CFG.PLAYER_TURN_ID = i;
                    CFG.gameAction.buildFogOfWar(i);
                    CFG.core.getPlayer(i).buildMetProvsAndCivs();
                }
                CFG.PLAYER_TURN_ID = 0;
                for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                    CFG.core.getProv(i).updateProvinceBorder();
                }
                Render.updateDrawCivRegionNames_FogOfWar();
            } else {
                for (i = 0; i < CFG.core.getPlayersSize(); ++i) {
                    CFG.PLAYER_TURN_ID = i;
                    CFG.gameAction.buildFogOfWar(i);
                }
                CFG.PLAYER_TURN_ID = 0;
            }
        }
        for (i = 0; i < CFG.core.getProvinSize(); ++i) {
            CFG.core.getProv(i).updateDrawArmyInProv();
        }
        CFG.gameAction.updateCivsHappiness_AllCivs();
        CFG.gameUpdate.updateProvinceStabilityAllProvinces();
        NewGameManager.updateBudgetSpendings();
        CFG.gameUpdate.updateInflationPeakValueAllCivs();
        CFG.gameUpdate.updatePlayableProvinces();
        TechManager.updateAverageTechLevel();
        if (CFG.SANDBOX_MODE && !CFG.SPECTATOR_MODE) {
            NewGameManager.sandboxMode();
        }
        if (CFG.SANDBOX_MODE_AI) {
            NewGameManager.sandboxMode_AI();
        }
        CFG.setActiveCivInfoId(0);
        CitiesManager.buildLevelsOfCities();
        CFG.map.getMpB().disposeMinimapOfCivilizations();
        CFG.timelapseManager.newGame();
        SaveGameManager.newGame();
        SaveGameManager.gameCanBeContinued = true;
        VictoryManager.checkVictoryConditions();
        CFG.oAI.updateExpand();
        this.updateDeclareWarAll();
        CFG.core.clearPropaganda();
        CFG.core.cleanForeignInvestmentBuild();
    }

    public final void updateTrueOwners() {
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            for (int j = 0; j < CFG.core.getCiv(i).getNumOfProvs(); ++j) {
                CFG.core.getProv(CFG.core.getCiv(i).getProvID(j)).setTrueOwnerOfProv(i);
            }
        }
    }

    public static final void updateBudgetSpendings() {
        int i;
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
            CFG.gameUpdate.getBalance_UpdateBudgetPrepare(i);
        }
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
            CFG.gameUpdate.updateSpendingOfCivID(i, CFG.core.getCiv((int)i).iBudget);
        }
    }

    public static void sandboxMode() {
        try {
            CFG.FOG_OF_WAR = 0;
            for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                CFG.gameAction.buildFogOfWar(i);
            }
            if (!CFG.SPECTATOR_MODE) {
                for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                    if (CFG.core.getPlayer(i).getCivId() <= 0 || CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getNumOfProvs() <= 0 || CFG.PXSX) continue;
                    CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).setGold(500000000000L);
                    CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).setMovementPoints(999);
                    CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).setDiploPoints(999);
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static void sandboxMode_AI() {
        try {
            if (CFG.SPECTATOR_MODE) {
                for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                    if (CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
                    CFG.core.getCiv(i).setGold(500000000000L);
                    CFG.core.getCiv(i).setMovementPoints(999);
                    CFG.core.getCiv(i).setDiploPoints(999);
                }
            } else {
                for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                    if (!CFG.core.getCiv(i).getIsPlayer() || CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
                    CFG.core.getCiv(i).setGold(500000000000L);
                    CFG.core.getCiv(i).setMovementPoints(999);
                    CFG.core.getCiv(i).setDiploPoints(999);
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    private final void newGame_InitPlayers() {
        int i;
        for (i = 0; i < CFG.core.getPlayersSize(); ++i) {
            if (CFG.core.getPlayer(i).getCivId() > 0) continue;
            CFG.core.randomPlayerCivilizations(i);
        }
        for (i = 0; i < CFG.core.getCivsSize(); ++i) {
            CFG.core.getCiv(i).setIsPlayer(false);
        }
        for (i = 0; i < CFG.core.getPlayersSize(); ++i) {
            if (CFG.core.getPlayer(i).getCivId() <= 0) continue;
            CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).setIsPlayer(true);
        }
        for (i = 0; i < CFG.core.getPlayersSize(); ++i) {
            CFG.core.getPlayer(i).loadPlayersFlag();
        }
    }

    public static final void newGame_InitPlayers_SpectatorMode() {
        int i;
        CFG.core.initPlayers();
        CFG.core.getPlayer(0).setCivId(1);
        CFG.FOG_OF_WAR = 0;
        for (i = 0; i < CFG.core.getCivsSize(); ++i) {
            CFG.core.getCiv(i).setIsPlayer(false);
        }
        for (i = 0; i < CFG.core.getPlayersSize(); ++i) {
            CFG.core.getPlayer(i).loadPlayersFlag();
        }
    }

    public final void randomPlacement() {
        int j;
        int i;
        Random oR = new Random();
        ArrayList<Integer> lExistingCivs = new ArrayList<Integer>();
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.core.getCiv(i).getIsAvailable()) {
                lExistingCivs.add(i);
            }
            CFG.core.getCiv(i).clearProvinces_FillTheMap(false);
        }
        for (i = 0; i < CFG.core.getProvinSize(); ++i) {
            CFG.core.getProv(i).setCivIdJust(0);
            CFG.core.getProv(i).setIsCapital(false);
            j = 1;
            while (j < CFG.core.getProv(i).getCivsSize()) {
                CFG.core.getProv(i).removeArmy(j);
            }
        }
        for (i = 0; i < lExistingCivs.size(); ++i) {
            this.findRandomCapital((Integer)lExistingCivs.get(i));
        }
        if (!CFG.RANDOM_FILL) {
            for (i = 0; i < CFG.core.getProvinSize(); ++i) {
                for (j = 0; j < CFG.core.getProv(i).getProvinceBordersLandByLandSize(); ++j) {
                    CFG.core.getProv(i).getProvBordersLandByLand().get(j).setIsCivilizationBorder(false, i);
                }
            }
        }
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
            CFG.core.getProv(CFG.core.getCiv(i).getCapitalProvID()).updateProvinceBorder();
        }
        for (i = 0; i < lExistingCivs.size(); ++i) {
            CFG.core.getCiv((Integer)lExistingCivs.get(i)).addProv(CFG.core.getCiv((Integer)lExistingCivs.get(i)).getCapitalProvID());
        }
    }

    public final void findRandomCapital(int nCivID) {
        try {
            int tempCapitalID;
            block6: {
                tempCapitalID = 0;
                int iNumOfItterations = 0;
                do {
                    if (CFG.core.getProv(tempCapitalID = this.getRandomLandProvinceID()).isCapital()) continue;
                    boolean found = true;
                    for (int i = 0; i < CFG.core.getProv(tempCapitalID).getNeighProvincesSize(); ++i) {
                        if (!CFG.core.getProv(CFG.core.getProv(tempCapitalID).getNeighProvinces(i)).isCapital()) continue;
                        found = false;
                        break;
                    }
                    if (found) break block6;
                } while (++iNumOfItterations <= 100);
                for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                    if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).isCapital() || CFG.core.getProv(i).getWastelandLvl() >= 0) continue;
                    CFG.core.getCiv(nCivID).setCapitalProvID(i);
                    CFG.core.getProv(i).setCivId_LoadScenario(nCivID);
                    CFG.core.getProv(i).setIsCapital(true);
                    break;
                }
                return;
            }
            CFG.core.getCiv(nCivID).setCapitalProvID(tempCapitalID);
            CFG.core.getProv(tempCapitalID).setCivId_LoadScenario(nCivID);
            CFG.core.getProv(tempCapitalID).setIsCapital(true);
        }
        catch (StackOverflowError ex) {
            for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
                if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).isCapital() || CFG.core.getProv(i).getWastelandLvl() >= 0) continue;
                CFG.core.getCiv(nCivID).setCapitalProvID(i);
                CFG.core.getProv(i).setCivId_LoadScenario(nCivID);
                CFG.core.getProv(i).setIsCapital(true);
                break;
            }
        }
    }

    private final int getRandomLandProvinceID() {
        int tID = CFG.oR.nextInt(CFG.core.getProvinSize());
        if (CFG.core.getProv(tID).getSeaProv() || CFG.core.getProv(tID).getWastelandLvl() >= 0) {
            return this.getRandomLandProvinceID();
        }
        return tID;
    }

    
    public final void randomFill() {
        ArrayList<Integer> lLandProvinces = new ArrayList<Integer>();
        ArrayList<Integer> lWas = new ArrayList<Integer>();
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).isCapital() || CFG.core.getProv(i).getWastelandLvl() >= 0) continue;
            lLandProvinces.add(i);
            lWas.add(0);
            CFG.core.getProv(i).setCivId(0, false, false);
            int j = 1;
            while (j < CFG.core.getProv(i).getCivsSize()) {
                CFG.core.getProv(i).removeArmy(j);
            }
        }
        int tProvinceID = 0;
        int tCivID = 0;
        ArrayList<Integer> lExistingCivs = new ArrayList<Integer>();
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (!CFG.core.getCiv(i).getIsAvailable()) continue;
            lExistingCivs.add(i);
        }
        Random oR = new Random();
        ArrayList<Integer> lNeighCivs = new ArrayList<Integer>();
        while (true) {
            block18: {
                if (lLandProvinces.isEmpty()) break;
                tProvinceID = oR.nextInt(lLandProvinces.size());
                lNeighCivs.clear();
                int i = 0;
                while (true) {
                    block19: {
                        if (i >= CFG.core.getProv((Integer)lLandProvinces.get(tProvinceID)).getNeighProvincesSize()) break;
                        if (CFG.core.getProv(CFG.core.getProv((Integer)lLandProvinces.get(tProvinceID)).getNeighProvinces(i)).getCivId() == 0) break block19;
                        lNeighCivs.add(CFG.core.getProv(CFG.core.getProv((Integer)lLandProvinces.get(tProvinceID)).getNeighProvinces(i)).getCivId());
                        lNeighCivs.add(CFG.core.getProv(CFG.core.getProv((Integer)lLandProvinces.get(tProvinceID)).getNeighProvinces(i)).getCivId());
                        if (CFG.core.getCiv(CFG.core.getProv(CFG.core.getProv((Integer)lLandProvinces.get(tProvinceID)).getNeighProvinces(i)).getCivId()).getCapitalProvID() != ((Integer)lLandProvinces.get(tProvinceID)).intValue()) break block19;
                        for (int u = 0; u < 5 + 30 / CFG.core.getCiv(CFG.core.getProv(CFG.core.getProv((Integer)lLandProvinces.get(tProvinceID)).getNeighProvinces(i)).getCivId()).getNumOfProvs() + (CFG.core.getProv(CFG.core.getProv((Integer)lLandProvinces.get(tProvinceID)).getNeighProvinces(i)).isCapital() ? 60 : 0); ++u) {
                            lNeighCivs.add(CFG.core.getProv(CFG.core.getProv((Integer)lLandProvinces.get(tProvinceID)).getNeighProvinces(i)).getCivId());
                        }
                    }
                    ++i;
                }
                for (i = 0; i < CFG.core.getProv((Integer)lLandProvinces.get(tProvinceID)).getNeighSeaProvincesSize(); ++i) {
                    for (int j = 0; j < CFG.core.getProv(CFG.core.getProv((Integer)lLandProvinces.get(tProvinceID)).getNeighSeaProvinces(i)).getNeighProvincesSize(); ++j) {
                        if (CFG.core.getProv(CFG.core.getProv(CFG.core.getProv((Integer)lLandProvinces.get(tProvinceID)).getNeighSeaProvinces(i)).getNeighProvinces(j)).getCivId() == 0 || CFG.core.getProv(CFG.core.getProv(CFG.core.getProv((Integer)lLandProvinces.get(tProvinceID)).getNeighSeaProvinces(i)).getNeighProvinces(j)).getSeaProv()) continue;
                        lNeighCivs.add(CFG.core.getProv(CFG.core.getProv(CFG.core.getProv((Integer)lLandProvinces.get(tProvinceID)).getNeighSeaProvinces(i)).getNeighProvinces(j)).getCivId());
                    }
                }
                if (lNeighCivs.isEmpty()) {
                    if ((Integer)lWas.get(tProvinceID) > 4) {
                        tCivID = (Integer)lExistingCivs.get(oR.nextInt(lExistingCivs.size()));
                        break block18;
                    } else {
                        lWas.set(tProvinceID, (Integer)lWas.get(tProvinceID) + 1);
                        continue;
                    }
                }
                tCivID = (Integer)lNeighCivs.get(oR.nextInt(lNeighCivs.size()));
            }
            CFG.core.getProv((Integer)lLandProvinces.get(tProvinceID)).setCivId(tCivID, false, false);
            lLandProvinces.remove(tProvinceID);
            lWas.remove(tProvinceID);
        }
        boolean changeOwner = true;
        int i = 0;
        while (true) {
            block22: {
                block23: {
                    block21: {
                        if (i >= CFG.core.getProvinSize()) break block21;
                        if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).isCapital() || CFG.core.getProv(i).getWastelandLvl() >= 0 || CFG.core.getProv(i).getNeighProvincesSize() <= 0) break block22;
                        changeOwner = true;
                        break block23;
                    }
                    i = 1;
                    while (true) {
                        if (i >= CFG.core.getCivsSize()) {
                            this.updateTrueOwners();
                            CFG.core.buildCivilizationsRegions();
                            return;
                        }
                        if (CFG.core.getCiv(i).getNumOfProvs() > 0 && CFG.core.getCiv(i).getCapitalProvID() < 0) {
                            CFG.core.getCiv(i).setCapitalProvID(CFG.core.getCiv(i).getProvID(0));
                        }
                        ++i;
                    }
                }
                for (int j = 0; j < CFG.core.getProv(i).getNeighProvincesSize(); ++j) {
                    if (CFG.core.getProv(i).getCivId() == CFG.core.getProv(CFG.core.getProv(i).getNeighProvinces(j)).getCivId()) {
                        changeOwner = false;
                        break;
                    }
                    if (CFG.core.getProv(CFG.core.getProv(i).getNeighProvinces(0)).getCivId() == CFG.core.getProv(CFG.core.getProv(i).getNeighProvinces(j)).getCivId()) continue;
                    changeOwner = false;
                    break;
                }
                if (changeOwner) {
                    CFG.core.getProv(i).setCivId(CFG.core.getProv(CFG.core.getProv(i).getNeighProvinces(0)).getCivId(), false, false);
                }
            }
            ++i;
        }
    }

    public static final void buildFormableCivilizations() {
        ArrayList<String> tempTags;
        block22: {
            tempTags = new ArrayList<String>();
            try {
                String[] tagsSPLITED;
                String tempT;
                FileHandle tempFileT;
                int i;
                int iSize;
                if (CFG.readLocalFiles()) {
                    String[] tagsSPLITED2;
                    String tempT2;
                    FileHandle tempFileT22;
                    try {
                        tempFileT22 = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "formable_civs/" + "Age_of_Civilizations");
                        tempT2 = tempFileT22.readString();
                        tagsSPLITED2 = tempT2.split(";");
                        iSize = tagsSPLITED2.length;
                        for (i = 0; i < iSize; ++i) {
                            tempTags.add(tagsSPLITED2[i]);
                        }
                    }
                    catch (GdxRuntimeException tempFileT22a) {
                        
                    }
                    try {
                        tempFileT22 = Gdx.files.internal("map/" + CFG.map.getFileActiveMapPath() + "formable_civs/" + "Age_of_Civilizations");
                        tempT2 = tempFileT22.readString();
                        tagsSPLITED2 = tempT2.split(";");
                        iSize = tagsSPLITED2.length;
                        for (i = 0; i < iSize; ++i) {
                            if (tempTags.contains(tagsSPLITED2[i])) continue;
                            tempTags.add(tagsSPLITED2[i]);
                        }
                    }
                    catch (GdxRuntimeException tempFileT23) {
                        
                    }
                    try {
                        tempFileT = Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "formable_civs/" + "Age_of_Civilizations");
                        tempT = tempFileT.readString();
                        tagsSPLITED = tempT.split(";");
                        iSize = tagsSPLITED.length;
                        for (i = 0; i < iSize; ++i) {
                            boolean add = true;
                            for (int j = 0; j < tempTags.size(); ++j) {
                                if (!tagsSPLITED[i].equals(tempTags.get(j))) continue;
                                add = false;
                            }
                            if (!add) continue;
                            tempTags.add(tagsSPLITED[i]);
                        }
                        break block22;
                    }
                    catch (GdxRuntimeException tempFileT3) {
                        break block22;
                    }
                }
                tempFileT = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "formable_civs/" + "Age_of_Civilizations");
                tempT = tempFileT.readString();
                tagsSPLITED = tempT.split(";");
                iSize = tagsSPLITED.length;
                for (i = 0; i < iSize; ++i) {
                    tempTags.add(tagsSPLITED[i]);
                }
            }
            catch (GdxRuntimeException tempFileT) {
                
            }
        }
        for (int i = tempTags.size() - 1; i >= 0; --i) {
            try {
                FileHandle file;
                try {
                    file = Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "formable_civs/" + (String)tempTags.get(i));
                    CFG.formableCivs_GameData = (FormableCivs_GameData)CFG.deserialize(file.readBytes());
                }
                catch (GdxRuntimeException ex) {
                    file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "formable_civs/" + (String)tempTags.get(i));
                    CFG.formableCivs_GameData = (FormableCivs_GameData)CFG.deserialize(file.readBytes());
                }
                if (CFG.formableCivs_GameData != null) {
                    for (int j = CFG.formableCivs_GameData.getClaimantsSize() - 1; j >= 0; --j) {
                        for (int k = 1; k < CFG.core.getCivsSize(); ++k) {
                            if (!CFG.core.getCiv(k).getCivTag().equals(CFG.formableCivs_GameData.getClaimant(j)) && (!CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(k).getCivTag()).equals(CFG.formableCivs_GameData.getClaimant(j)) || CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(k).getCivTag()).equals(CFG.ideologiesMgr.getRealTag(CFG.formableCivs_GameData.getFormableCivTag())))) continue;
                            CFG.core.getCiv(k).addTagsCanForm(CFG.formableCivs_GameData.getFormableCivTag());
                            boolean ownsAllAtStart = true;
                            for (int p = 0; p < CFG.formableCivs_GameData.getProvincesSize(); ++p) {
                                int provID = CFG.formableCivs_GameData.getProvinceID(p);
                                if (provID >= 0 && provID < CFG.core.getProvinSize() && CFG.core.getProv(provID).getWastelandLvl() < 0 && CFG.core.getProv(provID).getCivId() != k) {
                                    ownsAllAtStart = false;
                                    break;
                                }
                            }
                            if (ownsAllAtStart) {
                                CFG.core.getCiv(k).addBlockedFormable(CFG.formableCivs_GameData.getFormableCivTag());
                            }
                        }
                    }
                }
            }
            catch (Exception exception) {
                
            }
            CFG.formableCivs_GameData.clearProvinces();
            CFG.formableCivs_GameData = null;
        }
    }

    public final void updateFormableCivilizations(int nCivID) {
        ArrayList<String> tempTags;
        block21: {
            tempTags = new ArrayList<String>();
            try {
                String[] tagsSPLITED;
                String tempT;
                FileHandle tempFileT;
                int i;
                int iSize;
                if (CFG.readLocalFiles()) {
                    String[] tagsSPLITED2;
                    String tempT2;
                    FileHandle tempFileT22;
                    try {
                        tempFileT22 = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "formable_civs/" + "Age_of_Civilizations");
                        tempT2 = tempFileT22.readString();
                        tagsSPLITED2 = tempT2.split(";");
                        iSize = tagsSPLITED2.length;
                        for (i = 0; i < iSize; ++i) {
                            tempTags.add(tagsSPLITED2[i]);
                        }
                    }
                    catch (GdxRuntimeException tempFileT22b) {
                        
                    }
                    try {
                        tempFileT22 = Gdx.files.internal("map/" + CFG.map.getFileActiveMapPath() + "formable_civs/" + "Age_of_Civilizations");
                        tempT2 = tempFileT22.readString();
                        tagsSPLITED2 = tempT2.split(";");
                        iSize = tagsSPLITED2.length;
                        for (i = 0; i < iSize; ++i) {
                            if (tempTags.contains(tagsSPLITED2[i])) continue;
                            tempTags.add(tagsSPLITED2[i]);
                        }
                    }
                    catch (GdxRuntimeException tempFileT23) {
                        
                    }
                    try {
                        tempFileT = Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "formable_civs/" + "Age_of_Civilizations");
                        tempT = tempFileT.readString();
                        tagsSPLITED = tempT.split(";");
                        iSize = tagsSPLITED.length;
                        for (i = 0; i < iSize; ++i) {
                            boolean add = true;
                            for (int j = 0; j < tempTags.size(); ++j) {
                                if (!tagsSPLITED[i].equals(tempTags.get(j))) continue;
                                add = false;
                            }
                            if (!add) continue;
                            tempTags.add(tagsSPLITED[i]);
                        }
                        break block21;
                    }
                    catch (GdxRuntimeException tempFileT3) {
                        break block21;
                    }
                }
                tempFileT = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "formable_civs/" + "Age_of_Civilizations");
                tempT = tempFileT.readString();
                tagsSPLITED = tempT.split(";");
                iSize = tagsSPLITED.length;
                for (i = 0; i < iSize; ++i) {
                    tempTags.add(tagsSPLITED[i]);
                }
            }
            catch (GdxRuntimeException tempFileT) {
                
            }
        }
        CFG.core.getCiv(nCivID).clearTagsCanForm();
        int iSize = tempTags.size();
        for (int i = 0; i < iSize; ++i) {
            try {
                FileHandle file;
                try {
                    file = Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "formable_civs/" + (String)tempTags.get(i));
                    CFG.formableCivs_GameData = (FormableCivs_GameData)CFG.deserialize(file.readBytes());
                }
                catch (GdxRuntimeException ex) {
                    file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "formable_civs/" + (String)tempTags.get(i));
                    CFG.formableCivs_GameData = (FormableCivs_GameData)CFG.deserialize(file.readBytes());
                }
                if (CFG.formableCivs_GameData != null) {
                    for (int j = CFG.formableCivs_GameData.getClaimantsSize() - 1; j >= 0; --j) {
                        if (!CFG.core.getCiv(nCivID).getCivTag().equals(CFG.formableCivs_GameData.getClaimant(j)) && (!CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(nCivID).getCivTag()).equals(CFG.formableCivs_GameData.getClaimant(j)) || CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(nCivID).getCivTag()).equals(CFG.ideologiesMgr.getRealTag(CFG.formableCivs_GameData.getFormableCivTag())))) continue;
                        CFG.core.getCiv(nCivID).addTagsCanForm(CFG.formableCivs_GameData.getFormableCivTag());
                    }
                }
            }
            catch (Exception exception) {
                
            }
            CFG.formableCivs_GameData.clearProvinces();
            CFG.formableCivs_GameData = null;
        }
    }
}

