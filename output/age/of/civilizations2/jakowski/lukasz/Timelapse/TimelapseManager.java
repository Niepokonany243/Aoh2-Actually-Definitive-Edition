
package age.of.civilizations2.jakowski.lukasz.Timelapse;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;
import age.of.civilizations2.jakowski.lukasz.Timelapse.Timelapse_Capitals;
import age.of.civilizations2.jakowski.lukasz.Timelapse.Timelapse_GameData;
import age.of.civilizations2.jakowski.lukasz.Timelapse.Timelapse_Owners_GameData;
import age.of.civilizations2.jakowski.lukasz.Timelapse.Timelapse_Stats_Economy_GameData;
import age.of.civilizations2.jakowski.lukasz.Timelapse.Timelapse_Stats_GameData;
import age.of.civilizations2.jakowski.lukasz.Timelapse.Timelapse_Stats_History_GameData;
import age.of.civilizations2.jakowski.lukasz.Timelapse.Timelapse_Stats_Population_GameData;
import age.of.civilizations2.jakowski.lukasz.Timelapse.Timelapse_Stats_Provinces_GameData;
import age.of.civilizations2.jakowski.lukasz.Timelapse.Timelapse_Stats_Rank_GameData;
import age.of.civilizations2.jakowski.lukasz.Timelapse.Timelapse_Stats_Tech_GameData;
import age.of.civilizations2.jakowski.lukasz.Timelapse.Timelapse_TurnChanges;
import age.of.civilizations2.jakowski.lukasz.Timelapse.Timelapse_TurnChanges_GameData;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import java.util.ArrayList;
import java.util.List;

public class TimelapseManager {
    public Timelapse_GameData timelapseGameData = new Timelapse_GameData();
    public Timelapse_Owners_GameData timelapseOwnersGameData = new Timelapse_Owners_GameData();
    public Timelapse_TurnChanges_GameData timelapseTurnChanges = new Timelapse_TurnChanges_GameData();
    public Timelapse_Stats_GameData timelapseStatsGD = new Timelapse_Stats_GameData();
    public Timelapse_Stats_Provinces_GameData timelapseStatsProvinces = new Timelapse_Stats_Provinces_GameData();
    public Timelapse_Stats_Population_GameData timelapseStatsPopulation = new Timelapse_Stats_Population_GameData();
    public Timelapse_Stats_Rank_GameData timelapseStatsRank = new Timelapse_Stats_Rank_GameData();
    public Timelapse_Stats_Tech_GameData timelapseStatsTechnology = new Timelapse_Stats_Tech_GameData();
    public Timelapse_Stats_History_GameData timelapseStatsHistory = new Timelapse_Stats_History_GameData();
    public Timelapse_Stats_Economy_GameData timelapseStatsEconomy = new Timelapse_Stats_Economy_GameData();
    public static int SOURCE = 0;
    public static final int[] TIME_REQUIRED_TO_ACTION = new int[]{1, 2000, 1500, 1000, 750, 500, 250};
    public static final int MAX_SPEED = 6;
    public static int SPEED = 1;
    public static boolean PAUSE = true;
    public static long TIME_PAST = 0L;
    public static long TIME_LAST_UPDATE = 0L;
    public List<Integer> timelineOwners = new ArrayList<Integer>();
    public List<Boolean> timelineOwners_IsOccupied = new ArrayList<Boolean>();
    public List<Integer> timelineOwners_Capitals = new ArrayList<Integer>();
    public Timelapse_TurnChanges_GameData timelineOwners_Changes = new Timelapse_TurnChanges_GameData();
    public int iTimelineTurnID = 0;

    public final void updateTime() {
        block3: {
            try {
                TIME_PAST += System.currentTimeMillis() - TIME_LAST_UPDATE;
                TIME_LAST_UPDATE = System.currentTimeMillis();
                if (this.timePasted()) {
                    TIME_PAST = 0L;
                    this.loadNextTurn();
                }
            }
            catch (Exception ex) {
                if (!CFG.LOGs) break block3;
                CFG.exceptionStack(ex);
            }
        }
    }

    private final boolean timePasted() {
        return TIME_PAST > (long)this.getRequiredTime();
    }

    public final int getRequiredTime() {
        return TIME_REQUIRED_TO_ACTION[SPEED];
    }

    public final float getTimePerc() {
        return Math.min((float)TIME_PAST / (float)this.getRequiredTime(), 1.0f);
    }

    public final void resetTime() {
        TIME_PAST = 0L;
        TIME_LAST_UPDATE = System.currentTimeMillis();
    }

    public void pauseUnpause() {
        boolean bl = PAUSE = !PAUSE;
        if (!PAUSE) {
            if (this.iTimelineTurnID >= this.timelineOwners_Changes.lTurnChanges.size() - 1) {
                this.buildTimeline();
                PAUSE = false;
                if (CFG.menus.getInGame_Timeline()) {
                    CFG.menus.getInGame_Timeline_UpdateLanguage();
                } else if (CFG.menus.getInVictory()) {
                    CFG.menus.getInGame_Victory_UpdateLanguage();
                }
            }
            TIME_LAST_UPDATE = System.currentTimeMillis();
        }
    }

    public void updateSpeed(int nDiff) {
        float tempTimePastPerc = this.getTimePerc();
        if ((SPEED += nDiff) < 1) {
            SPEED = 1;
        } else if (SPEED > 6) {
            SPEED = 6;
        }
        TIME_PAST = (long)((float)TIME_REQUIRED_TO_ACTION[SPEED] * tempTimePastPerc);
    }

    public final void buildTimeline() {
        int tempCapital;
        int i;
        this.clearTimeline();
        this.iTimelineTurnID = 0;
        this.resetTime();
        PAUSE = true;
        if (CFG.FOG_OF_WAR == 2) {
            for (i = 0; i < this.timelapseOwnersGameData.lProvinceOwnersAtBeginning.size(); ++i) {
                if (CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(i)) {
                    this.timelineOwners.add(this.timelapseOwnersGameData.lProvinceOwnersAtBeginning.get(i));
                } else {
                    this.timelineOwners.add(0);
                }
                this.timelineOwners_IsOccupied.add(false);
            }
            for (i = 0; i < this.timelapseGameData.lCivsCapitals.size(); ++i) {
                tempCapital = this.timelapseGameData.lCivsCapitals.get(i).getCapitalID(this.iTimelineTurnID + 1);
                if (tempCapital >= 0 && this.timelineOwners.get(tempCapital) == i + 1 && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(i + 1)) {
                    this.timelineOwners_Capitals.add(tempCapital);
                    continue;
                }
                this.timelineOwners_Capitals.add(-1);
            }
        } else {
            for (i = 0; i < this.timelapseOwnersGameData.lProvinceOwnersAtBeginning.size(); ++i) {
                this.timelineOwners.add(this.timelapseOwnersGameData.lProvinceOwnersAtBeginning.get(i));
                this.timelineOwners_IsOccupied.add(false);
            }
            for (i = 0; i < this.timelapseGameData.lCivsCapitals.size(); ++i) {
                tempCapital = this.timelapseGameData.lCivsCapitals.get(i).getCapitalID(this.iTimelineTurnID + 1);
                if (tempCapital >= 0 && this.timelineOwners.get(tempCapital) == i + 1) {
                    this.timelineOwners_Capitals.add(tempCapital);
                    continue;
                }
                this.timelineOwners_Capitals.add(-1);
            }
        }
        if (SaveGameManager.saveTag != null) {
            int turnSavesID = 0;
            try {
                FileHandle fileReadData3 = null;
                fileReadData3 = CFG.readLocalFiles() ? Gdx.files.local("saves/games/" + CFG.map.getFileActiveMapPath() + SaveGameManager.saveTag + "/" + "TS/" + "TURN/" + "Age_of_Civilizations") : FileManager.loadFile("saves/games/" + CFG.map.getFileActiveMapPath() + SaveGameManager.saveTag + "/" + "TS/" + "TURN/" + "Age_of_Civilizations");
                String tRead = fileReadData3.readString();
                turnSavesID = Integer.parseInt(tRead) + 1;
                for (int i2 = 0; i2 < turnSavesID; ++i2) {
                    FileHandle fileReadData4 = null;
                    fileReadData4 = CFG.readLocalFiles() ? Gdx.files.local("saves/games/" + CFG.map.getFileActiveMapPath() + SaveGameManager.saveTag + "/" + "TS/" + "TURN/" + SaveGameManager.saveTag + "_C" + "_" + i2) : FileManager.loadFile("saves/games/" + CFG.map.getFileActiveMapPath() + SaveGameManager.saveTag + "/" + "TS/" + "TURN/" + SaveGameManager.saveTag + "_C" + "_" + i2);
                    Timelapse_TurnChanges_GameData tempChangesData = (Timelapse_TurnChanges_GameData)CFG.deserialize(fileReadData4.readBytes());
                    for (int j = 0; j < tempChangesData.lTurnChanges.size(); ++j) {
                        this.timelineOwners_Changes.lTurnChanges.add(tempChangesData.lTurnChanges.get(j));
                    }
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        for (int j = 0; j < this.timelapseTurnChanges.lTurnChanges.size(); ++j) {
            this.timelineOwners_Changes.lTurnChanges.add(this.timelapseTurnChanges.lTurnChanges.get(j));
        }
    }

    public final void clearTimeline() {
        this.timelineOwners.clear();
        this.timelineOwners_IsOccupied.clear();
        this.timelineOwners_Capitals.clear();
        this.timelineOwners_Changes.lTurnChanges.clear();
    }

    public final void clearTimeline_Statistics() {
        this.timelapseStatsProvinces.lProvinces.clear();
        this.timelapseStatsPopulation.lPopulation.clear();
        this.timelapseStatsRank.lRank.clear();
        this.timelapseStatsEconomy.lEconomy.clear();
        this.timelapseStatsTechnology.lTechnologyLevel.clear();
        this.timelapseStatsGD.lPlayers_Treasury.clear();
        this.timelapseStatsGD.lPlayers_Income.clear();
        this.timelapseStatsGD.lPlayers_Expenses.clear();
        this.timelapseStatsGD.lPlayers_Balance.clear();
        this.timelapseStatsGD.lPlayers_MilitarySpendings.clear();
        this.timelapseStatsGD.lPlayers_Happiness.clear();
        this.timelapseStatsGD.lPlayers_ArmySize.clear();
        this.timelapseStatsGD.lPlayers_Stability.clear();
        this.timelapseStatsHistory.lHistory = new ArrayList<List<HistoryLog>>();
    }

    public final void loadNextTurn() {
        if (this.iTimelineTurnID < this.timelineOwners_Changes.lTurnChanges.size() - 1) {
            this.timelineOwners_Capitals.clear();
            if (CFG.FOG_OF_WAR == 2) {
                int i;
                for (i = 0; i < this.timelineOwners_Changes.lTurnChanges.get(this.iTimelineTurnID).size(); ++i) {
                    if (!CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetProv(this.timelineOwners_Changes.lTurnChanges.get((int)this.iTimelineTurnID).get((int)i).iProvinceID)) continue;
                    this.timelineOwners.set(this.timelineOwners_Changes.lTurnChanges.get((int)this.iTimelineTurnID).get((int)i).iProvinceID, this.timelineOwners_Changes.lTurnChanges.get((int)this.iTimelineTurnID).get((int)i).iToCivID);
                    this.timelineOwners_IsOccupied.set(this.timelineOwners_Changes.lTurnChanges.get((int)this.iTimelineTurnID).get((int)i).iProvinceID, this.timelineOwners_Changes.lTurnChanges.get((int)this.iTimelineTurnID).get((int)i).isOccupied);
                }
                for (i = 0; i < this.timelapseGameData.lCivsCapitals.size(); ++i) {
                    int tempCapital = this.timelapseGameData.lCivsCapitals.get(i).getCapitalID(this.iTimelineTurnID + 1);
                    if (tempCapital >= 0 && this.timelineOwners.get(tempCapital) == i + 1 && CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getMetCiv(i + 1)) {
                        this.timelineOwners_Capitals.add(tempCapital);
                        continue;
                    }
                    this.timelineOwners_Capitals.add(-1);
                }
            } else {
                int i;
                for (i = 0; i < this.timelineOwners_Changes.lTurnChanges.get(this.iTimelineTurnID).size(); ++i) {
                    this.timelineOwners.set(this.timelineOwners_Changes.lTurnChanges.get((int)this.iTimelineTurnID).get((int)i).iProvinceID, this.timelineOwners_Changes.lTurnChanges.get((int)this.iTimelineTurnID).get((int)i).iToCivID);
                    this.timelineOwners_IsOccupied.set(this.timelineOwners_Changes.lTurnChanges.get((int)this.iTimelineTurnID).get((int)i).iProvinceID, this.timelineOwners_Changes.lTurnChanges.get((int)this.iTimelineTurnID).get((int)i).isOccupied);
                }
                for (i = 0; i < this.timelapseGameData.lCivsCapitals.size(); ++i) {
                    int tempCapital = this.timelapseGameData.lCivsCapitals.get(i).getCapitalID(this.iTimelineTurnID + 1);
                    if (tempCapital >= 0 && this.timelineOwners.get(tempCapital) == i + 1) {
                        this.timelineOwners_Capitals.add(tempCapital);
                        continue;
                    }
                    this.timelineOwners_Capitals.add(-1);
                }
            }
            ++this.iTimelineTurnID;
            if (CFG.menus.getInGame_Timeline()) {
                CFG.menus.getInGame_Timeline_UpdateLanguage();
            } else if (CFG.menus.getInVictory()) {
                CFG.menus.getInGame_Victory_UpdateLanguage();
                CFG.map.getMpC().centerToCivilizationBox_Timeline(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), true);
            }
        } else {
            PAUSE = true;
        }
    }

    public final void newGame() {
        int i;
        this.timelapseOwnersGameData.lProvinceOwnersAtBeginning.clear();
        this.timelapseGameData.lCivsCapitals.clear();
        this.timelapseTurnChanges.lTurnChanges.clear();
        this.clearTimeline();
        this.clearTimeline_Statistics();
        for (i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getSeaProv()) {
                this.timelapseOwnersGameData.lProvinceOwnersAtBeginning.add(0);
                continue;
            }
            if (CFG.core.getProv(i).getWastelandLvl() >= 0) {
                this.timelapseOwnersGameData.lProvinceOwnersAtBeginning.add(-1);
                continue;
            }
            this.timelapseOwnersGameData.lProvinceOwnersAtBeginning.add(CFG.core.getProv(i).getCivId());
        }
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
            this.timelapseGameData.lCivsCapitals.add(new Timelapse_Capitals(CFG.core.getCiv(i).getCapitalProvID(), 1));
        }
        this.timelapseTurnChanges.lTurnChanges.add(new ArrayList());
        ArrayList<Integer> tempProvinces = new ArrayList<Integer>();
        ArrayList<Long> tempPopulation = new ArrayList<Long>();
        ArrayList<Long> tempRank = new ArrayList<Long>();
        ArrayList<Integer> tempTechnology = new ArrayList<Integer>();
        ArrayList<Long> tempEconomy = new ArrayList<Long>();
        for (int i2 = 0; i2 < CFG.core.getCivsSize(); ++i2) {
            tempProvinces.add(CFG.core.getCiv(i2).getNumOfProvs());
            tempPopulation.add(Math.max(1L, CFG.core.getCiv(i2).countPop() + CFG.core.getCiv(i2).getNumberOfUnits()));
            tempEconomy.add(Math.max(0L, CFG.core.getCiv(i2).countEco()));
            tempRank.add(CFG.core.getCiv(i2).getRankScore());
            tempTechnology.add((int)(CFG.core.getCiv(i2).getTechLevel() * 100.0f));
        }
        this.timelapseStatsProvinces.addProvinces(tempProvinces);
        this.timelapseStatsPopulation.addPopulation(tempPopulation);
        this.timelapseStatsEconomy.addData(tempEconomy);
        this.timelapseStatsRank.addRank(tempRank);
        this.timelapseStatsTechnology.addTechLevel(tempTechnology);
    }

    public final void newTurn() {
        this.timelapseTurnChanges.lTurnChanges.add(new ArrayList());
        this.updateTurnStatistics();
    }

    public final void addChange(int nProvinceID, int toCivID, boolean isOccupied) {
        try {
            int iSize = this.timelapseTurnChanges.lTurnChanges.size() - 1;
            for (int i = 0; i < this.timelapseTurnChanges.lTurnChanges.get(iSize).size(); ++i) {
                if (this.timelapseTurnChanges.lTurnChanges.get((int)iSize).get((int)i).iProvinceID != nProvinceID) continue;
                this.timelapseTurnChanges.lTurnChanges.get((int)iSize).get((int)i).iToCivID = toCivID;
                this.timelapseTurnChanges.lTurnChanges.get((int)iSize).get((int)i).isOccupied = isOccupied;
                return;
            }
            this.timelapseTurnChanges.lTurnChanges.get(iSize).add(new Timelapse_TurnChanges(nProvinceID, toCivID, isOccupied));
        }
        catch (Exception exception) {
            
        }
    }

    public final void updateTurnStatistics() {
        try {
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                this.timelapseGameData.lCivsCapitals.get(i - 1).updateCapital(CFG.core.getCiv(i).getCapitalProvID(), GameCalendar.TURNID);
            }
        }
        catch (Exception ex) {
            for (int i = this.timelapseGameData.lCivsCapitals.size() + 1; i < CFG.core.getCivsSize(); ++i) {
                this.timelapseGameData.lCivsCapitals.add(new Timelapse_Capitals(CFG.core.getCiv(i).getCapitalProvID(), GameCalendar.TURNID));
            }
        }
        try {
            Civilization civI;
            if (GameCalendar.TURNID % GameValues.gvTimelapse.GRAPH_DATA_UPDATE_EVERY_X_TURNS == 0) {
                ArrayList<Integer> tempProvinces = new ArrayList<Integer>();
                ArrayList<Long> tempPopulation = new ArrayList<Long>();
                ArrayList<Long> tempRank = new ArrayList<Long>();
                ArrayList<Long> tempEconomy = new ArrayList<Long>();
                for (int i = 0; i < CFG.core.getCivsSize(); ++i) {
                    Civilization civI2 = CFG.core.getCiv(i);
                    tempProvinces.add(civI2.getNumOfProvs());
                    tempPopulation.add(Math.max(1L, civI2.countPop() + civI2.getNumberOfUnits()));
                    tempEconomy.add(Math.max(1L, civI2.countEco()));
                    tempRank.add(civI2.getRankScore());
                }
                this.timelapseStatsProvinces.addProvinces(tempProvinces);
                this.timelapseStatsPopulation.addPopulation(tempPopulation);
                this.timelapseStatsEconomy.addData(tempEconomy);
                this.timelapseStatsRank.addRank(tempRank);
            }
            if (GameCalendar.TURNID % GameValues.gvTimelapse.GRAPH_DATA_UPDATE_EVERY_X_TURNS_RANK == 0) {
                ArrayList<Long> tempRank = new ArrayList<Long>();
                for (int i = 0; i < CFG.core.getCivsSize(); ++i) {
                    civI = CFG.core.getCiv(i);
                    tempRank.add(civI.getRankScore());
                }
                this.timelapseStatsRank.addRank(tempRank);
            }
            if (GameCalendar.TURNID % GameValues.gvTimelapse.GRAPH_DATA_UPDATE_EVERY_X_TURNS_TECH_LEVEL == 0) {
                ArrayList<Integer> tempTechnology = new ArrayList<Integer>();
                for (int i = 0; i < CFG.core.getCivsSize(); ++i) {
                    civI = CFG.core.getCiv(i);
                    tempTechnology.add((int)(civI.getTechLevel() * 100.0f));
                }
                this.timelapseStatsTechnology.addTechLevel(tempTechnology);
            }
            ArrayList<Integer> tempIncome = new ArrayList<Integer>();
            ArrayList<Integer> tempExpenses = new ArrayList<Integer>();
            ArrayList<Integer> tempBalance = new ArrayList<Integer>();
            ArrayList<Integer> tempMilitarySpendings = new ArrayList<Integer>();
            ArrayList<Long> tempTreasury = new ArrayList<Long>();
            ArrayList<Integer> tempHappiness = new ArrayList<Integer>();
            ArrayList<Long> tempArmy = new ArrayList<Long>();
            ArrayList<Integer> tempStability = new ArrayList<Integer>();
            for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                Civilization civPlayer = CFG.core.getCiv(CFG.core.getPlayer(i).getCivId());
                tempTreasury.add(civPlayer.getGold());
                tempHappiness.add(civPlayer.getHappiness());
                tempArmy.add(civPlayer.getNumberOfUnits());
                tempStability.add((int)(civPlayer.getStabilityCiv() * 100.0f));
                tempExpenses.add((int)CFG.gameUpdate.getExpenses(CFG.core.getPlayer(i).getCivId()));
                tempIncome.add((int)(civPlayer.incomeTaxation + civPlayer.incomeProduction));
                tempMilitarySpendings.add((int)CFG.gameUpdate.getMilitaryUpkeep_Total(CFG.core.getPlayer(i).getCivId()));
                tempBalance.add((int)(CFG.gameUpdate.getIncome(CFG.core.getPlayer(i).getCivId()) - CFG.gameUpdate.getExpenses(CFG.core.getPlayer(i).getCivId())));
            }
            this.timelapseStatsGD.lPlayers_Treasury.add(tempTreasury);
            this.timelapseStatsGD.lPlayers_Happiness.add(tempHappiness);
            this.timelapseStatsGD.lPlayers_ArmySize.add(tempArmy);
            this.timelapseStatsGD.lPlayers_Stability.add(tempStability);
            this.timelapseStatsGD.lPlayers_Income.add(tempIncome);
            this.timelapseStatsGD.lPlayers_Expenses.add(tempExpenses);
            this.timelapseStatsGD.lPlayers_Balance.add(tempBalance);
            this.timelapseStatsGD.lPlayers_MilitarySpendings.add(tempMilitarySpendings);
            if (this.timelapseStatsGD.lPlayers_Income.size() > GameValues.gvTimelapse.GRAPH_DATA_LIMIT_PLAYER_DATA) {
                this.timelapseStatsGD.lPlayers_Income.remove(0);
            }
            if (this.timelapseStatsGD.lPlayers_Happiness.size() > GameValues.gvTimelapse.GRAPH_DATA_LIMIT_PLAYER_DATA) {
                this.timelapseStatsGD.lPlayers_Happiness.remove(0);
            }
            if (this.timelapseStatsGD.lPlayers_ArmySize.size() > GameValues.gvTimelapse.GRAPH_DATA_LIMIT_PLAYER_DATA) {
                this.timelapseStatsGD.lPlayers_ArmySize.remove(0);
            }
            if (this.timelapseStatsGD.lPlayers_Expenses.size() > GameValues.gvTimelapse.GRAPH_DATA_LIMIT_PLAYER_DATA) {
                this.timelapseStatsGD.lPlayers_Expenses.remove(0);
            }
            if (this.timelapseStatsGD.lPlayers_Stability.size() > GameValues.gvTimelapse.GRAPH_DATA_LIMIT_PLAYER_DATA) {
                this.timelapseStatsGD.lPlayers_Stability.remove(0);
            }
            if (this.timelapseStatsGD.lPlayers_Expenses.size() > GameValues.gvTimelapse.GRAPH_DATA_LIMIT_PLAYER_DATA) {
                this.timelapseStatsGD.lPlayers_Expenses.remove(0);
            }
            if (this.timelapseStatsGD.lPlayers_Balance.size() > GameValues.gvTimelapse.GRAPH_DATA_LIMIT_PLAYER_DATA) {
                this.timelapseStatsGD.lPlayers_Balance.remove(0);
            }
            if (this.timelapseStatsGD.lPlayers_MilitarySpendings.size() > GameValues.gvTimelapse.GRAPH_DATA_LIMIT_PLAYER_DATA) {
                this.timelapseStatsGD.lPlayers_MilitarySpendings.remove(0);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final int getNumOfProvinces(int nCivID) {
        int out = 0;
        try {
            for (int i = this.timelineOwners.size() - 1; i >= 0; --i) {
                if (this.timelineOwners.get(i) != nCivID) continue;
                ++out;
            }
        }
        catch (Exception exception) {
            
        }
        return out;
    }

    public final int getPlayerIncome(int iPlayerID, int iTurnID) {
        try {
            return this.timelapseStatsGD.lPlayers_Income.get(iTurnID).get(iPlayerID);
        }
        catch (IndexOutOfBoundsException ex) {
            try {
                if (iTurnID >= this.timelapseStatsGD.lPlayers_Income.size()) {
                    return this.timelapseStatsGD.lPlayers_Income.get(this.timelapseStatsGD.lPlayers_Income.size() - 1).get(iPlayerID);
                }
            }
            catch (Exception exception) {
                
            }
            return 0;
        }
    }
}

