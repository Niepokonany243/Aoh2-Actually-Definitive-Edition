/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.AI;

import age.of.civilizations2.jakowski.lukasz.AI.AI_NeighProvinces;
import age.of.civilizations2.jakowski.lukasz.AI.AI_NeighProvinces_Army;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle.AIPlaystyle;
import age.of.civilizations2.jakowski.lukasz.AI.FrontLine.AI_Frontline;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle.AI_Playstyle_CityState;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle.AI_Playstyle_Communism;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle.AI_Playstyle_Fascism;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle.AI_Playstyle_Horde;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle.AI_Playstyle_Rebels;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle.AI_Playstyle_Tribal;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization;
import age.of.civilizations2.jakowski.lukasz.Civilization_Region;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission_ExpandNeutralProvince;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission_ExpandNeutral_Check;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission_Expand_BuildPort;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission_Type;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.ConstructionType;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.PeaceTreaty_Data;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.PeaceTreaty_GameData_MessageData;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Mode.MapModesManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Plagues.Nuke.NukeManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Wonders.Wonders_Manager;
import age.of.civilizations2.jakowski.lukasz.Menus.PeaceTreaty.Menu_PeaceTreaty;
import age.of.civilizations2.jakowski.lukasz.Menus.Vassal.Menu_InGame_Tribute;
import age.of.civilizations2.jakowski.lukasz.Messages.Alliance.Become.Message_BecomeVassal;
import age.of.civilizations2.jakowski.lukasz.Messages.Truce.SignPeace.Message_WeCanSignPeace;
import age.of.civilizations2.jakowski.lukasz.Parallel;
import age.of.civilizations2.jakowski.lukasz.Province;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy_PortToBuild;
import age.of.civilizations2.jakowski.lukasz.War_GameData;
import java.util.ArrayList;
import java.util.List;

public class AI {
    public boolean doneLoadingOrders = false;
    public int iLoadingTurnActionsOfCivID = 0;
    public List<AIPlaystyle> aiPlaystyles = new ArrayList<AIPlaystyle>();
    public int NUM_OF_CIVS_IN_THE_GAME = 0;
    public int PLAYABLE_PROVINCES = 1;
    public int MIN_NUM_OF_RIVALS = 1;
    public List<Integer> lNeutralProvincesWithSeaAccess = new ArrayList<Integer>();
    public int iNeutralProvincesWithSeaAccessSize = 0;
    public List<Integer> lWastelandProvincesWithSeaAccess = new ArrayList<Integer>();
    public static int REBUILD_PERSONALITYX = 224;
    public int iNumOfColonizedProvcs = 0;
    public Expand expandNeutral;

    public AI() {
        this.updateExpand();
        this.aiPlaystyles.add(new AIPlaystyle());
        this.aiPlaystyles.add(new AI_Playstyle_Communism());
        this.aiPlaystyles.add(new AI_Playstyle_Horde());
        this.aiPlaystyles.add(new AI_Playstyle_Fascism());
        this.aiPlaystyles.add(new AI_Playstyle_CityState());
        this.aiPlaystyles.add(new AI_Playstyle_Tribal());
        this.aiPlaystyles.add(new AI_Playstyle_Rebels());
        this.rebuildPersonality();
    }

    public final int getAIStyle_ByTag(String nTag) {
        for (int i = 0; i < this.aiPlaystyles.size(); ++i) {
            if (!this.aiPlaystyles.get((int)i).TAG.equals(nTag)) continue;
            return i;
        }
        return 0;
    }

    public final AIPlaystyle getAIStyle(int i) {
        try {
            return this.aiPlaystyles.get(i);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            return this.aiPlaystyles.get(0);
        }
    }

    public final void turnOrders_0() {
        this.doneLoadingOrders = false;
        this.buildWonders();
        this.buildNukes();
        try {
            for (int i = 1 + GameCalendar.TURNID % REBUILD_PERSONALITYX; i < CFG.core.getCivsSize(); i += REBUILD_PERSONALITYX) {
                if (CFG.core.getCiv(i).getIsPlayer() || CFG.oR.nextInt(100) <= GameValues.gvAiCivPersonality.REBUILD_AI_PERSONALITY_CHANCE) continue;
                CFG.core.getCiv(i).buildCivPersonality();
                if (CFG.core.getCiv(i).getCivId() == CFG.core.getCiv(i).getPuppetOfCiv() || !CFG.core.getCiv(CFG.core.getCiv(i).getPuppetOfCiv()).getIsPlayer()) continue;
                Menu_InGame_Tribute.updateVassalsSpendings(i);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            this.checkWarsLookingForPeace();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void turnOrders_1() {
        long time = System.nanoTime();
        if (CFG.SAVED_GAME_LOADED_2) {
            CFG.SAVED_GAME_LOADED_2 = false;
            for (int i = 0; i < CFG.core.getCivsSize(); ++i) {
                CFG.core.getCiv((int)i).civGD.nextBuildCivsInRange_TurnID = 0;
            }
        }
        AIPlaystyle.diplomacyActions_RivalCiv_Update();
        try {
            AIPlaystyle.sendUltimatumToPlayer();
            this.aiBecomesAVassal();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            try {
                if (!CFG.core.getCiv(i).getIsPlayer()) {
                    if (CFG.core.getCiv(i).getNumOfProvs() > 0) {
                        this.iLoadingTurnActionsOfCivID = i;
                        this.aiPlaystyles.get(CFG.core.getCiv(i).getAIStyleID()).turnOrdersEssential(i);
                    } else {
                        this.aiPlaystyles.get(CFG.core.getCiv(i).getAIStyleID()).respondToMessages(i);
                    }
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            for (int i = 1 + GameCalendar.TURNID % GameValues.gvAiBudget.EXTRA_RESEARCH_EVERY_X_TURN; i < CFG.core.getCivsSize(); i += GameValues.gvAiBudget.EXTRA_RESEARCH_EVERY_X_TURN) {
                if (CFG.core.getCiv(i).getNumOfProvs() <= 0 || CFG.core.getCiv(i).getIsPlayer() || CFG.core.getCiv(i).isAtWarC() || CFG.core.getCiv((int)i).civGD.civPlans.isPreparingForTheWar() || CFG.core.getCiv(i).getGold() <= (long)GameValues.gvAiBudget.EXTRA_RESEARCH_MIN_GOLD) continue;
                CFG.core.getCiv(i).setSpendingResearchB(Math.max(CFG.core.getCiv(i).getSpendingResearchB(), GameValues.gvAiBudget.EXTRA_RESEARCH_MIN + (float)CFG.oR.nextInt(GameValues.gvAiBudget.EXTRA_RESEARCH_RAND_100) / 100.0f));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        time = System.nanoTime();
    }

    public final void turnOrders_2() {
        long time = System.nanoTime();
        try {
            for (int i = 1 + GameCalendar.TURNID % GameValues.gvUpdate.AI_TURN_ESSENTIALS_2; i < CFG.core.getCivsSize(); i += GameValues.gvUpdate.AI_TURN_ESSENTIALS_2) {
                try {
                    if (CFG.core.getCiv(i).getIsPlayer() || CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
                    this.iLoadingTurnActionsOfCivID = i;
                    this.aiPlaystyles.get(CFG.core.getCiv(i).getAIStyleID()).turnOrdersEssential_2(i);
                    continue;
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        time = System.nanoTime();
    }

    public final void turnOrders() {
        block10: {
            long time = System.nanoTime();
            try {
                for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            try {
                if (!CFG.core.getCiv(i).getIsPlayer() && CFG.core.getCiv(i).getNumOfProvs() > 0) {
                    this.iLoadingTurnActionsOfCivID = i;
                    this.aiPlaystyles.get(CFG.core.getCiv(i).getAIStyleID()).turnOrders(i);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
                if (CFG.SPECTATOR_MODE || !CFG.MOVE_AND_RECRUIT_ARMY_AT_WAR_BY_AI) break block10;
                try {
                    for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                        try {
                            if (!CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).isAtWarC()) continue;
                            this.aiPlaystyles.get(CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getAIStyleID()).moveAtWar(CFG.core.getPlayer(i).getCivId());
                            continue;
                        }
                        catch (Exception exr) {
                            CFG.exceptionStack(exr);
                        }
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    public final void resetNeutralProvsWithSeaAccess() {
        this.lNeutralProvincesWithSeaAccess.clear();
        this.iNeutralProvincesWithSeaAccessSize = 0;
    }

    public final synchronized void addNeutralProvsWithSeaAccess(int nProvinceID) {
        this.lNeutralProvincesWithSeaAccess.add(nProvinceID);
    }

    public final void resetWastelandProvsWithSeaAccess() {
        this.lWastelandProvincesWithSeaAccess.clear();
    }

    public final synchronized void addWastelandProvsWithSeaAccess(int nProvinceID) {
        this.lWastelandProvincesWithSeaAccess.add(nProvinceID);
    }

    public final void rebuildPersonality() {
        REBUILD_PERSONALITYX = GameValues.gvAiCivPersonality.UPDATE_REBUILD_PERSONALITY_BASE + CFG.oR.nextInt(GameValues.gvAiCivPersonality.UPDATE_REBUILD_PERSONALITY_RANDOM);
    }

    public final void checkWarsLookingForPeace() {
        try {
            for (int i = CFG.core.getWarsSize() - 1; i >= 0; --i) {
                int k;
                int j;
                War_GameData warData = CFG.core.getWar(i);
                boolean next = false;
                for (j = 0; j < warData.getDefendersSize(); ++j) {
                    if (warData.getDefenderID(j).getCivID() >= 0) continue;
                    CFG.core.removeWarData(i);
                    next = true;
                    break;
                }
                if (!next) {
                    for (j = 0; j < warData.getAggressorsSize(); ++j) {
                        if (warData.getAggressorID(j).getCivID() >= 0) continue;
                        CFG.core.removeWarData(i);
                        next = true;
                        break;
                    }
                }
                if (next) continue;
                
                int currentWarScore = CFG.core.getCachedWarScore(warData);
                
                for (j = 0; j < warData.getDefendersSize(); ++j) {
                    int defenderCivID = warData.getDefenderID(j).getCivID();
                    if (CFG.core.getCiv(defenderCivID).getNumOfProvs() != 0 && currentWarScore > -100) continue;
                    for (k = 0; k < warData.getAggressorsSize(); ++k) {
                        if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)warData.getAggressorID((int)k).getCivID()).getIdeology()).REVOLUTIONARY) continue;
                        CFG.core.getCiv((int)warData.getAggressorID((int)k).getCivID()).getCivDiploGD().messageBox.addMessage(new Message_WeCanSignPeace(defenderCivID));
                    }
                }
                for (j = 0; j < warData.getAggressorsSize(); ++j) {
                    int aggressorCivID = warData.getAggressorID(j).getCivID();
                    if (CFG.core.getCiv(aggressorCivID).getNumOfProvs() != 0 && currentWarScore < 100) continue;
                    for (k = 0; k < warData.getDefendersSize(); ++k) {
                        if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)warData.getDefenderID((int)k).getCivID()).getIdeology()).REVOLUTIONARY) continue;
                        CFG.core.getCiv((int)warData.getDefenderID((int)k).getCivID()).getCivDiploGD().messageBox.addMessage(new Message_WeCanSignPeace(aggressorCivID));
                    }
                }
                try {
                    if (warData.getAggressorsSize() > 0 && CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)warData.getAggressorID((int)0).getCivID()).getIdeology()).REVOLUTIONARY && CFG.core.getCiv(warData.getAggressorID(0).getCivID()).getNumOfProvs() == 0 && CFG.core.getCiv(warData.getAggressorID(0).getCivID()).civGD.iTurnsSinceLastAttack <= 0) {
                        try {
                            int a;
                            ArrayList<Boolean> lDefenders = new ArrayList<Boolean>();
                            ArrayList<Boolean> lAggressors = new ArrayList<Boolean>();
                            for (a = warData.getAggressorsSize() - 1; a >= 0; --a) {
                                lAggressors.add(true);
                            }
                            for (a = warData.getDefendersSize() - 1; a >= 0; --a) {
                                lDefenders.add(true);
                            }
                            Menu_PeaceTreaty.WAR_ID = i;
                            CFG.peaceTreatyData = new PeaceTreaty_Data(Menu_PeaceTreaty.WAR_ID, lDefenders, lAggressors, true);
                            int toCivID = warData.getAggressorID(0).getCivID();
                            CFG.peaceTreatyData.preparePeaceTreatyToSend(toCivID);
                            CFG.core.lPeaceTreaties.add(new PeaceTreaty_GameData_MessageData(CFG.peaceTreatyData.peaceTreatyGD));
                            String peaceTreatyTag = CFG.core.lPeaceTreaties.get((int)(CFG.core.lPeaceTreaties.size() - 1)).PEACE_TREATY_TAG;
                            GameManager.acceptPeaceTreaty(toCivID, peaceTreatyTag, true);
                            continue;
                        }
                        catch (Exception ex) {
                            CFG.exceptionStack(ex);
                        }
                    }
                }
                catch (Exception exr) {
                    CFG.exceptionStack(exr);
                }
                if (warData.getWarTurnID() < GameCalendar.TURNID - GameValues.gvAiWar.STATUS_QUO_WAR_IS_TOO_LONG) {
                    int a;
                    boolean playerInWar = false;
                    for (a = warData.getAggressorsSize() - 1; a >= 0; --a) {
                        if (!CFG.core.getCiv(warData.getAggressorID(a).getCivID()).getIsPlayer()) continue;
                        playerInWar = true;
                        break;
                    }
                    for (a = warData.getDefendersSize() - 1; a >= 0; --a) {
                        if (!CFG.core.getCiv(warData.getDefenderID(a).getCivID()).getIsPlayer()) continue;
                        playerInWar = true;
                        break;
                    }
                    if (!playerInWar || CFG.SPECTATOR_MODE) {
                        try {
                            int a2;
                            ArrayList<Boolean> lDefenders = new ArrayList<Boolean>();
                            ArrayList<Boolean> lAggressors = new ArrayList<Boolean>();
                            for (a2 = warData.getAggressorsSize() - 1; a2 >= 0; --a2) {
                                lAggressors.add(true);
                            }
                            for (a2 = warData.getDefendersSize() - 1; a2 >= 0; --a2) {
                                lDefenders.add(true);
                            }
                            Menu_PeaceTreaty.WAR_ID = i;
                            CFG.peaceTreatyData = new PeaceTreaty_Data(Menu_PeaceTreaty.WAR_ID, lDefenders, lAggressors, true);
                            int toCivID = warData.getAggressorID(0).getCivID();
                            CFG.peaceTreatyData.preparePeaceTreatyToSend(toCivID);
                            CFG.core.lPeaceTreaties.add(new PeaceTreaty_GameData_MessageData(CFG.peaceTreatyData.peaceTreatyGD));
                            String peaceTreatyTag = CFG.core.lPeaceTreaties.get((int)(CFG.core.lPeaceTreaties.size() - 1)).PEACE_TREATY_TAG;
                            GameManager.acceptPeaceTreaty(toCivID, peaceTreatyTag, true);
                        }
                        catch (Exception ex) {
                            CFG.exceptionStack(ex);
                        }
                        continue;
                    }
                }
                if (warData.iLastFight_InTurns <= (warData.wasAnyAttack ? GameValues.gvAiWar.STATUS_QUO_SINCE_LAST_ATTACK_TURNS : GameValues.gvAiWar.STATUS_QUO_TURNS_NO_ONE_ATTACKED) && warData.iLastTurn_ConqueredProvince >= GameCalendar.TURNID - GameValues.gvAiWar.STATUS_QUO_NO_PROGRESS) continue;
                for (int j2 = 0; j2 < warData.getAggressorsSize(); ++j2) {
                    if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)warData.getAggressorID((int)j2).getCivID()).getIdeology()).REVOLUTIONARY) continue;
                    for (k = 0; k < warData.getDefendersSize(); ++k) {
                        if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)warData.getDefenderID((int)k).getCivID()).getIdeology()).REVOLUTIONARY) continue;
                        CFG.core.getCiv((int)warData.getDefenderID((int)k).getCivID()).getCivDiploGD().messageBox.addMessage(new Message_WeCanSignPeace(warData.getAggressorID(j2).getCivID()));
                    }
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void turnOrders_InvestForeign() {
        try {
            for (int i = GameCalendar.TURNID % GameValues.gvAiInvest.UPDATE_FOREIGN_INVEST; i < CFG.core.getCivsSize(); i += GameValues.gvAiInvest.UPDATE_FOREIGN_INVEST) {
                if (CFG.core.getCiv(i).getIsPlayer()) continue;
                this.aiPlaystyles.get(CFG.core.getCiv(i).getAIStyleID()).investForeign(i);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void turnOrders_End() {
        try {
            for (int i = GameCalendar.TURNID % GameValues.gvAiVassals.UPDATE_VASSALS_TRIBUTE; i < CFG.core.getCivsSize(); i += GameValues.gvAiVassals.UPDATE_VASSALS_TRIBUTE) {
                if (CFG.core.getCiv(i).getIsPlayer()) continue;
                this.aiPlaystyles.get(CFG.core.getCiv(i).getAIStyleID()).manageVassalsTribute(i);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        finally {
            this.doneLoadingOrders = true;
        }
    }

    public final void updateMinRivals() {
        this.MIN_NUM_OF_RIVALS = (int)Math.min((double)GameValues.gvAiRivals.RIVALS_LIMIT, Math.ceil((float)(CFG.oAI.NUM_OF_CIVS_IN_THE_GAME - 1) / 2.0f));
    }

    public final void buildAI_Data() {
        int i;
        int j;
        Civilization civ;
        long nTime = System.nanoTime();
        this.resetNeutralProvsWithSeaAccess();
        this.resetWastelandProvsWithSeaAccess();
        this.iNumOfColonizedProvcs = 0;
        this.NUM_OF_CIVS_IN_THE_GAME = 0;
        Parallel.range(1, CFG.core.getCivsSize(), (int civIndex) -> {
            Civilization civLambda = CFG.core.getCiv(civIndex);
            civLambda.setSeaAccess(0);
            civLambda.clearSeaAccess_Provinces();
            civLambda.clearSeaAccess_PortProvinces();
            civLambda.setBordersWithEnemy(0);
            civLambda.setNumOfNeighboringNeutralProvinces(0);
            civLambda.armiesPosition.clear();
            civLambda.armiesPositionSize = 0;
            civLambda.iAveragePopulation = 1L;
            civLambda.bordersWithNeutralProvcsID.clear();
            civLambda.bordersWithWastelandProvsID.clear();
            civLambda.civGD.civPlans.updateObsolateMissions();
            CFG.core.countAverageDevelopmentLevel_Float(civIndex);
            civLambda.lProvincesWithHighRevRisk.clear();
            civLambda.isAtWarWithCivs.clear();
            civLambda.numOf_Forts = 0;
            civLambda.numOf_Towers = 0;
            civLambda.numOf_Ports = 0;
            civLambda.numOf_Farms = 0;
            civLambda.numOf_Farms_ProvincesPossibleToBuild = 0;
            civLambda.numOf_Workshops = 0;
            civLambda.numOf_Libraries = 0;
            civLambda.numOf_Armories = 0;
            civLambda.numOf_SuppliesCamp = 0;
            civLambda.numOf_Markets = 0;
        });
        // O(W * A * D) instead of O(C²) - populate isAtWarWithCivs from war objects
        for (i = 0; i < CFG.core.getWarsSize(); ++i) {
            War_GameData war = CFG.core.getWar(i);
            for (int a = 0; a < war.getAggressorsSize(); ++a) {
                int aggr = war.getAggressorID(a).getCivID();
                if (aggr <= 0) continue;
                for (int d = 0; d < war.getDefendersSize(); ++d) {
                    int def = war.getDefenderID(d).getCivID();
                    if (def <= 0 || aggr == def) continue;
                    CFG.core.getCiv(aggr).isAtWarWithCivs.add(def);
                    CFG.core.getCiv(def).isAtWarWithCivs.add(aggr);
                }
            }
        }
        
        // This count needs to be synchronized or calculated after
        this.iNumOfColonizedProvcs = 0;
        for (int i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
            this.iNumOfColonizedProvcs += CFG.core.getCiv(i2).civGD.coloniesFounded.size();
        }
        if (GameCalendar.TURNID <= 1 || CFG.SAVED_GAME_LOADED) {
            CFG.SAVED_GAME_LOADED = false;
            CFG.mapModesManager.updateMaxPopulation();
            CFG.mapModesManager.updateMaxEconomy();
        } else if (GameCalendar.TURNID % GameValues.gvUpdate.UPDATE_MAX_POPULATION_X_TURNS == 0) {
            CFG.mapModesManager.updateMaxPopulation();
        } else if (GameCalendar.TURNID % GameValues.gvUpdate.UPDATE_MAX_ECONOMY_X_TURNS == 0) {
            CFG.mapModesManager.updateMaxEconomy();
        }
        this.NUM_OF_CIVS_IN_THE_GAME = 0;
        for (int iIndex = 0; iIndex < CFG.core.getCivsSize(); ++iIndex) {
            Civilization civLambda = CFG.core.getCiv(iIndex);
            if (civLambda.getNumOfProvs() > 0) {
                if (civLambda.isAtWarC()) {
                    ++civLambda.civGD.iNumOfTurnsAtWar;
                } else {
                    civLambda.civGD.iNumOfTurnsAtWar -= 2;
                    if (civLambda.civGD.iNumOfTurnsAtWar < 0) {
                        civLambda.civGD.iNumOfTurnsAtWar = 0;
                    }
                }
                for (int jIndex = 0; jIndex < civLambda.getCivRegionsSize(); ++jIndex) {
                    civLambda.getCivRegion((int)jIndex).iAveragePotential = 0;
                }
                ++this.NUM_OF_CIVS_IN_THE_GAME;
            }
        }
        this.updateMinRivals();
        this.PLAYABLE_PROVINCES = 0;
        nTime = System.nanoTime();
        for (int provIndex = 0; provIndex < CFG.core.getProvinSize(); ++provIndex) {
            if (!CFG.core.getProv(provIndex).getSeaProv()) {
                if (CFG.core.getProv(provIndex).getWastelandLvl() >= 0) {
                    if (GameCalendar.getColonizationOfWastelandIsEnabled()) {
                        for (int j2 = 0; j2 < CFG.core.getProv(provIndex).getNeighSeaProvincesSize(); ++j2) {
                            if (CFG.core.getProv(CFG.core.getProv(provIndex).getNeighSeaProvinces(j2)).getLvlOfPort() == -2) {
                                this.addWastelandProvsWithSeaAccess(provIndex);
                                break;
                            }
                        }
                    }
                } else {
                    this.buildProvinceData(provIndex);
                }
            }
        }
        
        // Count playable provinces (needs synchronization or sequential count)
        this.PLAYABLE_PROVINCES = 0;
        for (int i4 = 0; i4 < CFG.core.getProvinSize(); ++i4) {
            if (!CFG.core.getProv(i4).getSeaProv() && CFG.core.getProv(i4).getWastelandLvl() < 0) {
                ++this.PLAYABLE_PROVINCES;
            }
        }
        nTime = System.nanoTime();
        for (int civIdx = 1; civIdx < CFG.core.getCivsSize(); ++civIdx) {
            Civilization civ2 = CFG.core.getCiv(civIdx);
            for (int k = 0; k < civ2.getCivRegionsSize(); ++k) {
                if (civ2.getCivRegion(k).getProvincesSize() <= 0) continue;
                civ2.getCivRegion(k).iAveragePotential /= civ2.getCivRegion(k).getProvincesSize();
            }
            civ2.armiesPositionSize = civ2.armiesPosition.size();
            civ2.iAveragePopulation = civ2.getNumOfProvs() > 0 ? (civ2.iAveragePopulation /= (long)civ2.getNumOfProvs()) : 1L;
            for (int k = 0; k < civ2.getConstructionsSize(); ++k) {
                if (civ2.getConstruction(k).constructionType == ConstructionType.FARM) {
                    ++civ2.numOf_Farms;
                    continue;
                }
                if (civ2.getConstruction(k).constructionType == ConstructionType.ARMOURY) {
                    ++civ2.numOf_Armories;
                    continue;
                }
                if (civ2.getConstruction(k).constructionType == ConstructionType.MARKET) {
                    ++civ2.numOf_Markets;
                    continue;
                }
                if (civ2.getConstruction(k).constructionType == ConstructionType.TOWER) {
                    ++civ2.numOf_Towers;
                    continue;
                }
                if (civ2.getConstruction(k).constructionType == ConstructionType.LIBRARY) {
                    ++civ2.numOf_Libraries;
                    continue;
                }
                if (civ2.getConstruction(k).constructionType == ConstructionType.PORT) {
                    ++civ2.numOf_Ports;
                    continue;
                }
                if (civ2.getConstruction(k).constructionType == ConstructionType.FORT) {
                    ++civ2.numOf_Forts;
                    continue;
                }
                if (civ2.getConstruction(k).constructionType != ConstructionType.SUPPLY) continue;
                ++civ2.numOf_SuppliesCamp;
            }
        }
        nTime = System.nanoTime();
        for (int iIndex = 1; iIndex < CFG.core.getCivsSize(); ++iIndex) {
            Civilization civ3 = CFG.core.getCiv(iIndex);
            if (civ3.uFOL) {
                civ3.lFrontLines.clear();
                civ3.uFOL = false;
                if (civ3.getNumOfProvs() > 0) {
                    int puppetOf = civ3.getPuppetOfCiv();
                    for (int j3 = 0; j3 < civ3.getCivRegionsSize(); ++j3) {
                        Civilization_Region region = civ3.getCivRegion(j3);
                        for (int k = 0; k < region.getProvincesSize(); ++k) {
                            int provinceId = region.getProvince(k);
                            Province province = CFG.core.getProv(provinceId);
                            if (province.getDangerLvl() <= 0) continue;
                            for (int u = 0; u < province.getNeighProvincesSize(); ++u) {
                                int neighborId = province.getNeighProvinces(u);
                                Province neighbor = CFG.core.getProv(neighborId);
                                int neighborCivId = neighbor.getCivId();
                                if (neighborCivId <= 0 || neighborCivId == iIndex) continue;
                                Civilization neighborCiv = CFG.core.getCiv(neighborCivId);
                                if (CFG.core.getCivsAreAllied(iIndex, neighborCivId) || puppetOf == neighborCivId || neighborCiv.getPuppetOfCiv() == iIndex || neighborCiv.getPuppetOfCiv() == puppetOf) continue;
                                boolean addNew = true;
                                for (AI_Frontline frontline : civ3.lFrontLines) {
                                    if (frontline.iRegionID != j3 || frontline.iWithCivID != neighborCivId) continue;
                                    addNew = false;
                                    frontline.lProvinces.add(provinceId);
                                    if (!province.getBordersWithEnemy()) break;
                                    frontline.bordersWithEnemy = true;
                                    break;
                                }
                                if (addNew) {
                                    civ3.lFrontLines.add(new AI_Frontline(provinceId, j3, neighborCivId, province.getBordersWithEnemy()));
                                }
                            }
                        }
                    }
                }
            }
        }
        nTime = System.nanoTime();
        for (int iIndex = 1; iIndex < CFG.core.getCivsSize(); ++iIndex) {
            Civilization civLambda = CFG.core.getCiv(iIndex);
            if (civLambda.getNumOfProvs() > 0) {
                for (int j4 = 0; j4 < civLambda.civGD.civPlans.iWarPrepsSize; ++j4) {
                    for (int f = 0; f < civLambda.lFrontLines.size(); ++f) {
                        if (civLambda.lFrontLines.get((int)f).iWithCivID != civLambda.civGD.civPlans.warPreps.get((int)j4).onCivID) continue;
                        for (int e = 0; e < civLambda.lFrontLines.get((int)f).lProvinces.size(); ++e) {
                            CFG.core.getProv(civLambda.lFrontLines.get((int)f).lProvinces.get(e)).addDangerLvl((int)((float)GameValues.gvAiProvince.DANGER_EXTRA_AT_WAR * (GameValues.gvAiProvince.DANGER_PREPARE_FOR_WAR_BASE + GameValues.gvAiProvince.DANGER_PREPARE_FOR_WAR_TURNS_LEFT / (float)civLambda.civGD.civPlans.warPreps.get((int)j4).iNumOfTurnsLeft)));
                        }
                    }
                }
            }
        }
        this.iNeutralProvincesWithSeaAccessSize = this.lNeutralProvincesWithSeaAccess.size();
    }

    public final void buildProvinceData(int i) {
        int j;
        int k;
        Province province = CFG.core.getProv(i);
        Civilization civProvince = CFG.core.getCiv(province.getCivId());
        province.setBordersWithEnemy(false);
        province.setDangerLvl(GameValues.gvAiProvince.DANGER_LEVEL_BASE);
        province.setPotential(GameValues.gvAiProvince.POTENTIAL_BASE);
        province.setNumOfNeighboringNeutralProvinces(0);
        province.wasInProv = false;
        if (province.getRevRisk() > GameValues.gvRebels.START_UPRAISE_IGNITE_REV_RISK_VALUE * GameValues.gvRebels.START_UPRAISE_IGNITE_REV_RISK_NOTIFY_CIV_BEFORE_IGNITE_MODIFIER) {
            civProvince.lProvincesWithHighRevRisk.add(i);
        }
        if (province.getCivId() > 0) {
            civProvince.numOf_Forts += province.getLvlOfFort();
            civProvince.numOf_Towers += province.getLvlOfWatchTower();
            if (CFG.terrainTypesManager.getPopulationGrowth(province.getTerrainTypeID()) >= 0.0f) {
                civProvince.numOf_Farms += province.getLvlOfFarm();
                ++civProvince.numOf_Farms_ProvincesPossibleToBuild;
            }
            civProvince.numOf_Workshops += province.getLvlOfWorkshop();
            civProvince.numOf_Libraries += province.getLvlOfLibrary();
            civProvince.numOf_Armories += province.getLvlOfArmoury();
            civProvince.numOf_Markets += province.getLvlOfMarket();
            civProvince.numOf_SuppliesCamp += province.getLvlOfSupply();
            if (province.getLvlOfPort() > 0) {
                civProvince.numOf_Ports += province.getLvlOfPort();
                civProvince.addSeaAccess_PortProvinces(i);
            }
            if (province.getNeighSeaProvincesSize() > 0) {
                civProvince.addSeaAccess_Provinces(i);
            }
            for (k = 0; k < province.getCivsSize(); ++k) {
                if (province.getArmyID(k) <= 0) continue;
                CFG.core.getCiv((int)province.getCivId((int)k)).armiesPosition.add(i);
            }
            for (j = 0; j < province.getNeighProvincesSize(); ++j) {
                if (CFG.core.getProv(province.getNeighProvinces(j)).getWastelandLvl() >= 0) {
                    civProvince.bordersWithWastelandProvsID.add(province.getNeighProvinces(j));
                    continue;
                }
                if (CFG.core.getProv(province.getNeighProvinces(j)).getCivId() != 0) continue;
                civProvince.bordersWithNeutralProvcsID.add(province.getNeighProvinces(j));
            }
        } else if (province.getSeaProv()) {
            for (k = 1; k < province.getCivsSize(); ++k) {
                if (province.getArmyID(k) <= 0) continue;
                CFG.core.getCiv((int)province.getCivId((int)k)).armiesPosition.add(i);
            }
        }
        if (province.getWasAttacked() > 0) {
            province.addDangerLvl((int)(province.isCapital() ? (float)GameValues.gvAiProvince.DANGER_PROVINCE_WAS_ATTACKED_CAPITAL : (float)GameValues.gvAiProvince.DANGER_PROVINCE_WAS_ATTACKED * ((100.0f - (float)(GameValues.gvAiProvince.DANGER_PROVINCE_WAS_ATTACKED_ARMY_IN_PROVINCE_MODIFIER_100 * province.getArmyID(0)) / (float)civProvince.getNumberOfUnits()) / 100.0f)));
            province.setArmyWasRecruited(0);
            province.setWasAttacked(province.getWasAttacked() - 1);
        }
        province.addPotentialP(province.getNeighProvincesSize());
        province.addPotentialP(province.getNeighSeaProvincesSize());
        province.addPotentialP((int)((float)(GameValues.gvAiProvince.POTENTIAL_POPULATION * province.getPop().getPops()) / (float)MapModesManager.POPULATION_MAX));
        province.addPotentialP((int)((float)GameValues.gvAiProvince.POTENTIAL_GROWTH_RATE * province.getGrowthRate_Pop_WithFarm()));
        province.addPotentialP((int)((float)(GameValues.gvAiProvince.POTENTIAL_ECONOMY * province.getEco()) / (float)MapModesManager.ECONOMY_MAX));
        province.addPotentialP((int)((float)GameValues.gvAiProvince.POTENTIAL_DEVELOPMENT * province.getDeveLvl()));
        province.addDangerLvl((int)(province.getRevRisk() * GameValues.gvAiProvince.DANGER_REV_RISK_MODIFIER));
        if (province.getCivId() == 0) {
            province.addPotentialP(GameValues.gvAiProvince.POTENTIAL_NEUTRAL_BASE + (int)(((float)GameValues.gvAiProvince.POTENTIAL_NEUTRAL_GROWTH_RATE_BASE + (float)GameValues.gvAiProvince.POTENTIAL_NEUTRAL_GROWTH_RATE_NEIGH_PROVINCES_BASE * (GameValues.gvAiProvince.POTENTIAL_NEUTRAL_GROWTH_RATE_NEIGH_PROVINCES_BASE_MODIFIER + GameValues.gvAiProvince.POTENTIAL_NEUTRAL_GROWTH_RATE_NEIGH_PROVINCES_BASE_PER_PROVINCE * (float)province.getNeighProvincesSize())) * province.getGrowthRate_Pop_WithFarm()));
            for (j = 0; j < province.getNeighSeaProvincesSize(); ++j) {
                if (CFG.core.getProv(province.getNeighSeaProvinces(j)).getLvlOfPort() != -2) continue;
                this.addNeutralProvsWithSeaAccess(i);
                break;
            }
        } else {
            civProvince.iAveragePopulation += (long)province.getPop().getPops();
            if (province.getLvlOfWatchTower() > 0) {
                province.addPotentialP(GameValues.gvAiProvince.POTENTIAL_LVL_WATCH_TOWER * province.getLvlOfWatchTower() * province.getNeighProvincesSize());
            }
            province.addPotentialP(GameValues.gvAiProvince.POTENTIAL_LVL_PORT * province.getLvlOfPort() * province.getNeighProvincesSize());
            province.addPotentialP(GameValues.gvAiProvince.POTENTIAL_LVL_FORT * province.getLvlOfFort());
            province.addPotentialP(GameValues.gvAiProvince.POTENTIAL_LVL_FARM * province.getLvlOfFarm());
            province.addPotentialP(GameValues.gvAiProvince.POTENTIAL_LVL_WORKSHOP * province.getLvlOfWorkshop());
            if (province.getNeighSeaProvincesSize() > 0) {
                civProvince.setSeaAccess(civProvince.getSeaAccess() + 1);
            }
            int nNeighbooringOwnProvinces = 0;
            for (int j2 = 0; j2 < province.getNeighProvincesSize(); ++j2) {
                Province neighProvince = CFG.core.getProv(province.getNeighProvinces(j2));
                if (neighProvince.getCivId() > 0) {
                    if (province.getCivId() != neighProvince.getCivId() && civProvince.getPuppetOfCiv() != CFG.core.getCiv(neighProvince.getCivId()).getPuppetOfCiv()) {
                        if (CFG.core.getCivsAtWar(province.getCivId(), neighProvince.getCivId())) {
                            province.setBordersWithEnemy(true);
                            province.addDangerLvl((int)((float)(province.isCapital() ? GameValues.gvAiProvince.DANGER_NEIGH_PROVINCE_AT_WAR_CAPITAL : GameValues.gvAiProvince.DANGER_NEIGH_PROVINCE_AT_WAR) * (province.getWasAttacked() > 0 ? GameValues.gvAiProvince.DANGER_NEIGH_PROVINCE_AT_WAR_WAS_ATTACKED_MODIFIER : 1.0f) * (float)(neighProvince.getWasConquered() + 1)));
                        }
                        if (!CFG.core.getCivsAreAllied(province.getCivId(), neighProvince.getCivId()) && civProvince.getPuppetOfCiv() != CFG.core.getCiv(neighProvince.getCivId()).getPuppetOfCiv() && CFG.core.getDefensivePact(province.getCivId(), neighProvince.getCivId()) == 0 && CFG.core.getGuarantee(province.getCivId(), neighProvince.getCivId()) == 0 && CFG.core.getCivNonAggressionPact(province.getCivId(), neighProvince.getCivId()) == 0 && CFG.core.getCivTruce(province.getCivId(), neighProvince.getCivId()) < 4) {
                            province.addDangerLvl(province.isCapital() ? GameValues.gvAiProvince.DANGER_NEIGH_PROVINCE_DIFFERENT_CIV_CAPITAL : GameValues.gvAiProvince.DANGER_NEIGH_PROVINCE_DIFFERENT_CIV);
                            province.addDangerLvl((int)((province.isCapital() ? GameValues.gvAiProvince.DANGER_DIFFERENT_CIV_BASE_CAPITAL : GameValues.gvAiProvince.DANGER_DIFFERENT_CIV_BASE) * (CFG.core.getCivsAtWar(province.getCivId(), neighProvince.getCivId()) ? GameValues.gvAiProvince.DANGER_AT_WAR_RELATION_MULTIPLIER * (float)(neighProvince.getWasConquered() + 1) : Math.max(GameValues.gvAiProvince.DANGER_RELATION_MIN, GameValues.gvAiProvince.DANGER_RELATION_BASE - CFG.core.getCivRelationOfCivB(province.getCivId(), neighProvince.getCivId()) / GameValues.gvAiProvince.DANGER_RELATION_DIVISOR)) * (GameValues.gvAiProvince.DANGER_PROVINCE_COUNT_BASE + Math.min(GameValues.gvAiProvince.DANGER_PROVINCE_COUNT_MAX, (float)CFG.core.getCiv(neighProvince.getCivId()).getNumOfProvs() / (float)civProvince.getNumOfProvs() / (float)province.getNeighProvincesSize()))));
                        }
                        province.addPotentialP(-((int)(civProvince.civGD.civPers.POTENTIAL_POPULATION * GameValues.gvAiProvince.POTENTIAL_NEIGHBOR_DIFFERENT_OWNER_MODIFIER * (float)neighProvince.getPop().getPops() / (float)MapModesManager.POPULATION_MAX)));
                        province.addPotentialP(-((int)(civProvince.civGD.civPers.POTENTIAL_ECONOMY * GameValues.gvAiProvince.POTENTIAL_NEIGHBOR_DIFFERENT_OWNER_MODIFIER * (float)neighProvince.getEco() / (float)MapModesManager.ECONOMY_MAX)));
                        province.addPotentialP(GameValues.gvAiProvince.POTENTIAL_NEIGHBOR_DIFFERENT_OWNER_FLAT_PENALTY);
                    } else {
                        province.addPotentialP(GameValues.gvAiProvince.POTENTIAL_NEIGHBOR_SAME_OWNER_BONUS);
                        ++nNeighbooringOwnProvinces;
                    }
                } else {
                    province.setNumOfNeighboringNeutralProvinces(province.getNumOfNeighboringNeutralProvinces() + 1);
                    province.addPotentialP(GameValues.gvAiProvince.POTENTIAL_NEUTRAL_NEIGH_BASE + (int)(GameValues.gvAiProvince.POTENTIAL_NEUTRAL_NEIGH_GROWTH_MULTIPLIER * neighProvince.getGrowthRate_Pop()));
                }
                province.addPotentialP((int)(civProvince.civGD.civPers.POTENTIAL_POPULATION * (float)neighProvince.getPop().getPops() / (float)MapModesManager.POPULATION_MAX));
                province.addPotentialP((int)(civProvince.civGD.civPers.POTENTIAL_ECONOMY * (float)neighProvince.getEco() / (float)MapModesManager.ECONOMY_MAX));
            }
            if (nNeighbooringOwnProvinces > 0) {
                province.setDangerLvl((int)((float)province.getDangerLvl() + civProvince.civGD.civPers.DANGER_EXTRA_PER_OWN_PROVINCE * (float)nNeighbooringOwnProvinces * (float)province.getDangerLvl()));
            }
            if (province.getBordersWithEnemy()) {
                province.addDangerLvl(GameValues.gvAiProvince.DANGER_EXTRA_AT_WAR);
            }
            if (province.isCapital()) {
                province.addPotentialP(GameValues.gvAiProvince.POTENTIAL_CAPITAL);
                if (province.getNeighSeaProvincesSize() > 0) {
                    province.addDangerLvl(GameValues.gvAiProvince.DANGER_CAPITAL_SEA_BASE + GameValues.gvAiProvince.DANGER_CAPITAL_SEA_PER_NEIGHBOR * province.getNeighSeaProvincesSize());
                }
            }
        }
        for (j = 0; j < province.getNeighSeaProvincesSize(); ++j) {
            for (int k2 = 1; k2 < CFG.core.getProv(province.getNeighSeaProvinces(j)).getCivsSize(); ++k2) {
                if (CFG.core.getCivsAtWar(province.getCivId(), CFG.core.getProv(province.getNeighSeaProvinces(j)).getCivId(k2))) {
                    province.addDangerLvl((int)((province.isCapital() ? GameValues.gvAiProvince.DANGER_SEA_AT_WAR_CAPITAL : GameValues.gvAiProvince.DANGER_SEA_AT_WAR) * Math.min(1.0f * (float)CFG.core.getProv(province.getNeighSeaProvinces(j)).getArmyID(k2) / Math.max((float)province.getArmyID(0), 1.0f), 2.0f)));
                    continue;
                }
                if (!(CFG.core.getCivRelationOfCivB(province.getCivId(), CFG.core.getProv(province.getNeighSeaProvinces(j)).getCivId(k2)) < (float)GameValues.gvAiProvince.DANGER_SEA_BAD_RELATIONS_VALUE)) continue;
                province.addDangerLvl((int)((province.isCapital() ? GameValues.gvAiProvince.DANGER_SEA_BAD_RELATIONS_CAPITAL : GameValues.gvAiProvince.DANGER_SEA_BAD_RELATIONS) * Math.min(1.0f * (float)CFG.core.getProv(province.getNeighSeaProvinces(j)).getArmyID(k2) / Math.max((float)province.getArmyID(0), 1.0f), 2.0f) * (-CFG.core.getCivRelationOfCivB(province.getCivId(), CFG.core.getProv(province.getNeighSeaProvinces(j)).getCivId(k2)) / 100.0f)));
            }
        }
        try {
            if (province.getArmyID(0) > 0) {
                province.setDangerLevel_WithArmy((int)Math.ceil((float)province.getDangerLvl() * (1.0f - civProvince.civGD.civPers.DANGER_PERC_OF_UNITS * (float)province.getArmyID(0) / (float)civProvince.getNumberOfUnits())));
            } else {
                province.setDangerLevel_WithArmy(province.getDangerLvl());
            }
        }
        catch (Exception ex) {
            province.setDangerLevel_WithArmy(province.getDangerLvl());
            CFG.exceptionStack(ex);
        }
        if (province.getLvlOfFort() > 0) {
            province.setPotential((int)Math.ceil((float)province.getPotential() * GameValues.gvAiProvince.POTENTIAL_FORT_REDUCTION_MULTIPLIER));
        }
        if (province.getCivId() > 0) {
            try {
                civProvince.getCivRegion((int)province.getCivRegionID()).iAveragePotential += province.getPotential();
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        try {
            if (province.getCivId() > 0 && civProvince.getCivRegion((int)province.getCivRegionID()).isKeyRegion) {
                province.setDangerLvl((int)((float)province.getDangerLvl() * civProvince.civGD.civPers.DANGER_EXTRA_KEY_REGION));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        if (province.getNeighProvinceOfCivWasLost() > 0) {
            province.addDangerLvl((int)((float)province.getDangerLvl() * GameValues.gvAiProvince.DANGER_NEIGHBOR_PROVINCE_LOST_MULTIPLIER * (float)province.getNeighProvinceOfCivWasLost()));
        }
        if (province.getArmyWasRecruited() > 0) {
            province.setArmyWasRecruited(province.getArmyWasRecruited() - 1);
        }
        if (province.getBordersWithEnemy()) {
            civProvince.setBordersWithEnemy(civProvince.getBordersWithEnemy() + 1);
        }
        if (province.getNumOfNeighboringNeutralProvinces() > 0) {
            civProvince.setNumOfNeighboringNeutralProvinces(civProvince.getNumOfNeighboringNeutralProvinces() + province.getNumOfNeighboringNeutralProvinces());
        }
        province.setWasConquered((byte)(province.getWasConquered() - 1));
        province.setNeighProvinceOfCivWasLost((byte)(province.getNeighProvinceOfCivWasLost() - 1));
    }

    public final List<AI_NeighProvinces_Army> getAllNeighboringProvcsInRange_WithArmyToRegroup(int nProvinceID, int nCivID, int iRange, boolean onlyTrueOwner, boolean dontBreakIfNotFoundRecentlyProvince, List<AI_NeighProvinces_Army> out, List<Integer> was, long nRequiredArmy) {
        ArrayList<Integer> recentlyAdded = new ArrayList<Integer>();
        recentlyAdded.add(nProvinceID);
        was.add(nProvinceID);
        CFG.core.getProv((int)nProvinceID).wasInProv = true;
        ArrayList<Integer> currProvinces = new ArrayList<Integer>();
        int nIteration_Distance = 0;
        long nArmyCollected = 0;
        while (iRange-- > 0 && (dontBreakIfNotFoundRecentlyProvince || !recentlyAdded.isEmpty())) {
            int a;
            currProvinces.clear();
            ++nIteration_Distance;
            for (a = recentlyAdded.size() - 1; a >= 0; --a) {
                boolean wasntAdded = true;
                for (int j = currProvinces.size() - 1; j >= 0; --j) {
                    if (currProvinces.get(j) != recentlyAdded.get(a)) continue;
                    wasntAdded = false;
                    break;
                }
                if (!wasntAdded) continue;
                currProvinces.add((Integer)recentlyAdded.get(a));
            }
            recentlyAdded.clear();
            for (a = currProvinces.size() - 1; a >= 0; --a) {
                for (int i = 0; i < CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvincesSize(); ++i) {
                    if (CFG.core.getProv((int)CFG.core.getProv((int)((Integer)currProvinces.get((int)a)).intValue()).getNeighProvinces((int)i)).wasInProv) continue;
                    was.add(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i));
                    CFG.core.getProv((int)CFG.core.getProv((int)((Integer)currProvinces.get((int)a)).intValue()).getNeighProvinces((int)i)).wasInProv = true;
                    if (CFG.core.getProv(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i)).getCivId() != nCivID || onlyTrueOwner && CFG.core.getProv(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i)).getCivId() != CFG.core.getProv(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i)).getTrueOwnerOfProv()) continue;
                    if (CFG.core.getProv(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i)).getArmyCivID1(nCivID) - CFG.core.getCiv((int)nCivID).civGD.civPlans.haveMission_Army(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i)) > 0) {
                        long tArmy = CFG.core.getProv(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i)).getArmyCivID1(nCivID) - CFG.core.getCiv((int)nCivID).civGD.civPlans.haveMission_Army(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i));
                        nArmyCollected += tArmy;
                        out.add(new AI_NeighProvinces_Army(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i), nIteration_Distance, tArmy));
                    }
                    recentlyAdded.add(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i));
                }
            }
            if (nArmyCollected < nRequiredArmy) continue;
        }
        for (int j = was.size() - 1; j >= 0; --j) {
            CFG.core.getProv((int)was.get((int)j).intValue()).wasInProv = false;
        }
        recentlyAdded.clear();
        recentlyAdded = null;
        was.clear();
        was = null;
        return out;
    }

    public final List<AI_NeighProvinces> getAllNeighboringProvincesInRange_RecruitAtWAr(int nProvinceID, int nCivID, int iRange, boolean onlyTrueOwner, boolean dontBreakIfNotFoundRecentlyProvince, List<AI_NeighProvinces> out, List<Integer> was) {
        ArrayList<Integer> recentlyAdded = new ArrayList<Integer>();
        recentlyAdded.add(nProvinceID);
        was.add(nProvinceID);
        CFG.core.getProv((int)nProvinceID).wasInProv = true;
        ArrayList<Integer> currProvinces = new ArrayList<Integer>();
        int nIteration_Distance = 0;
        int iFirstFoundRange = -1;
        while ((nIteration_Distance < iRange || out.size() == 0) && recentlyAdded.size() > 0) {
            int a;
            currProvinces.clear();
            ++nIteration_Distance;
            for (a = recentlyAdded.size() - 1; a >= 0; --a) {
                boolean wasntAdded = true;
                for (int j = currProvinces.size() - 1; j >= 0; --j) {
                    if (currProvinces.get(j) != recentlyAdded.get(a)) continue;
                    wasntAdded = false;
                    break;
                }
                if (!wasntAdded) continue;
                currProvinces.add((Integer)recentlyAdded.get(a));
            }
            recentlyAdded.clear();
            for (a = currProvinces.size() - 1; a >= 0; --a) {
                for (int i = 0; i < CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvincesSize(); ++i) {
                    if (CFG.core.getProv((int)CFG.core.getProv((int)((Integer)currProvinces.get((int)a)).intValue()).getNeighProvinces((int)i)).wasInProv) continue;
                    was.add(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i));
                    CFG.core.getProv((int)CFG.core.getProv((int)((Integer)currProvinces.get((int)a)).intValue()).getNeighProvinces((int)i)).wasInProv = true;
                    if (!CFG.core.isAlly(nCivID, CFG.core.getProv(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i)).getCivId()) && CFG.core.getMilitaryAccess(nCivID, CFG.core.getProv(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i)).getCivId()) <= 0) continue;
                    if (!CFG.core.getProv(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i)).isOccupied() && nCivID == CFG.core.getProv(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i)).getCivId() && CFG.core.getCiv(nCivID).isRAIP(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i)) < 0) {
                        out.add(new AI_NeighProvinces(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i), nIteration_Distance));
                        if (iFirstFoundRange < 0) {
                            iFirstFoundRange = nIteration_Distance;
                            iRange += 4;
                        }
                    }
                    recentlyAdded.add(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i));
                }
            }
            if (iFirstFoundRange <= 0 || iFirstFoundRange + 8 >= nIteration_Distance) continue;
        }
        for (int j = was.size() - 1; j >= 0; --j) {
            CFG.core.getProv((int)was.get((int)j).intValue()).wasInProv = false;
        }
        recentlyAdded.clear();
        recentlyAdded = null;
        was.clear();
        was = null;
        return out;
    }

    public final List<AI_NeighProvinces> getAllNeighboringProvincesInRange_Recruit(int nProvinceID, int nCivID, int iRange, boolean onlyTrueOwner, boolean dontBreakIfNotFoundRecentlyProvince, List<AI_NeighProvinces> out, List<Integer> was) {
        ArrayList<Integer> recentlyAdded = new ArrayList<Integer>();
        recentlyAdded.add(nProvinceID);
        was.add(nProvinceID);
        CFG.core.getProv((int)nProvinceID).wasInProv = true;
        ArrayList<Integer> currProvinces = new ArrayList<Integer>();
        int nIteration_Distance = 0;
        while (iRange-- > 0 && (dontBreakIfNotFoundRecentlyProvince || recentlyAdded.size() > 0)) {
            int a;
            currProvinces.clear();
            ++nIteration_Distance;
            for (a = recentlyAdded.size() - 1; a >= 0; --a) {
                boolean wasntAdded = true;
                for (int j = currProvinces.size() - 1; j >= 0; --j) {
                    if (currProvinces.get(j) != recentlyAdded.get(a)) continue;
                    wasntAdded = false;
                    break;
                }
                if (!wasntAdded) continue;
                currProvinces.add((Integer)recentlyAdded.get(a));
            }
            recentlyAdded.clear();
            for (a = currProvinces.size() - 1; a >= 0; --a) {
                for (int i = 0; i < CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvincesSize(); ++i) {
                    if (CFG.core.getProv((int)CFG.core.getProv((int)((Integer)currProvinces.get((int)a)).intValue()).getNeighProvinces((int)i)).wasInProv) continue;
                    was.add(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i));
                    CFG.core.getProv((int)CFG.core.getProv((int)((Integer)currProvinces.get((int)a)).intValue()).getNeighProvinces((int)i)).wasInProv = true;
                    if (CFG.core.getProv(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i)).getCivId() != nCivID) continue;
                    if (!CFG.core.getProv(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i)).isOccupied() && CFG.core.getCiv(nCivID).isRAIP(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i)) < 0) {
                        out.add(new AI_NeighProvinces(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i), nIteration_Distance));
                    }
                    recentlyAdded.add(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i));
                }
            }
        }
        for (int j = was.size() - 1; j >= 0; --j) {
            CFG.core.getProv((int)was.get((int)j).intValue()).wasInProv = false;
        }
        recentlyAdded.clear();
        recentlyAdded = null;
        was.clear();
        was = null;
        return out;
    }

    public static final void fFBRA(int civID) {
        CFG.core.getCiv((int)civID).armiesPosition.clear();
        for (int i = 0; i < CFG.core.getCiv(civID).getNumOfProvs(); ++i) {
            Province province = CFG.core.getProv(CFG.core.getCiv(civID).getProvID(i));
            if (province.getArmyCivID1(civID) <= 0) continue;
            CFG.core.getCiv((int)civID).armiesPosition.add(CFG.core.getCiv(civID).getProvID(i));
        }
        CFG.core.getCiv((int)civID).armiesPositionSize = CFG.core.getCiv((int)civID).armiesPosition.size();
    }

    public final List<AI_NeighProvinces> getAllNeighboringProvincesInRange_Clear(int nProvinceID, int nCivID, int iRange, boolean onlyTrueOwner, boolean dontBreakIfNotFoundRecentlyProvince, List<AI_NeighProvinces> out, List<Integer> was) {
        ArrayList<Integer> recentlyAdded = new ArrayList<Integer>();
        recentlyAdded.add(nProvinceID);
        was.add(nProvinceID);
        CFG.core.getProv((int)nProvinceID).wasInProv = true;
        ArrayList<Integer> currProvinces = new ArrayList<Integer>();
        int nIteration_Distance = 0;
        while (iRange-- > 0 && (dontBreakIfNotFoundRecentlyProvince || !recentlyAdded.isEmpty())) {
            int a;
            currProvinces.clear();
            ++nIteration_Distance;
            for (a = recentlyAdded.size() - 1; a >= 0; --a) {
                boolean wasntAdded = true;
                for (int j = currProvinces.size() - 1; j >= 0; --j) {
                    if (currProvinces.get(j) != recentlyAdded.get(a)) continue;
                    wasntAdded = false;
                    break;
                }
                if (!wasntAdded) continue;
                currProvinces.add((Integer)recentlyAdded.get(a));
            }
            recentlyAdded.clear();
            for (a = currProvinces.size() - 1; a >= 0; --a) {
                for (int i = 0; i < CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvincesSize(); ++i) {
                    if (CFG.core.getProv((int)CFG.core.getProv((int)((Integer)currProvinces.get((int)a)).intValue()).getNeighProvinces((int)i)).wasInProv) continue;
                    was.add(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i));
                    CFG.core.getProv((int)CFG.core.getProv((int)((Integer)currProvinces.get((int)a)).intValue()).getNeighProvinces((int)i)).wasInProv = true;
                    if (CFG.core.getProv(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i)).getCivId() != nCivID || onlyTrueOwner && CFG.core.getProv(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i)).getCivId() != CFG.core.getProv(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i)).getTrueOwnerOfProv()) continue;
                    out.add(new AI_NeighProvinces(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i), nIteration_Distance));
                    recentlyAdded.add(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i));
                }
            }
        }
        for (int j = was.size() - 1; j >= 0; --j) {
            CFG.core.getProv((int)was.get((int)j).intValue()).wasInProv = false;
        }
        recentlyAdded.clear();
        recentlyAdded = null;
        was.clear();
        was = null;
        return out;
    }

    public final List<AI_NeighProvinces> getAllNeighboringProvincesInRange_OnlyOwn_Clear(int nProvinceID, int nCivID, int iRange, boolean onlyTrueOwner, boolean dontBreakIfNotFoundRecentlyProvince, List<AI_NeighProvinces> out, List<Integer> was) {
        ArrayList<Integer> recentlyAdded = new ArrayList<Integer>();
        recentlyAdded.add(nProvinceID);
        was.add(nProvinceID);
        CFG.core.getProv((int)nProvinceID).wasInProv = true;
        ArrayList<Integer> currProvinces = new ArrayList<Integer>();
        int nIteration_Distance = 0;
        int iFirstFoundRange = -1;
        while (iRange-- > 0) {
            int a;
            currProvinces.clear();
            ++nIteration_Distance;
            for (a = recentlyAdded.size() - 1; a >= 0; --a) {
                boolean wasntAdded = true;
                for (int j = currProvinces.size() - 1; j >= 0; --j) {
                    if (currProvinces.get(j) != recentlyAdded.get(a)) continue;
                    wasntAdded = false;
                    break;
                }
                if (!wasntAdded) continue;
                currProvinces.add((Integer)recentlyAdded.get(a));
            }
            recentlyAdded.clear();
            for (a = currProvinces.size() - 1; a >= 0; --a) {
                for (int i = 0; i < CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvincesSize(); ++i) {
                    if (CFG.core.getProv((int)CFG.core.getProv((int)((Integer)currProvinces.get((int)a)).intValue()).getNeighProvinces((int)i)).wasInProv) continue;
                    was.add(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i));
                    CFG.core.getProv((int)CFG.core.getProv((int)((Integer)currProvinces.get((int)a)).intValue()).getNeighProvinces((int)i)).wasInProv = true;
                    if (CFG.core.getProv(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i)).getCivId() == nCivID) {
                        out.add(new AI_NeighProvinces(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i), nIteration_Distance));
                        iFirstFoundRange = nIteration_Distance;
                    }
                    recentlyAdded.add(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i));
                }
            }
            if (iFirstFoundRange <= 0 || iFirstFoundRange + 4 >= nIteration_Distance) continue;
        }
        for (int j = was.size() - 1; j >= 0; --j) {
            CFG.core.getProv((int)was.get((int)j).intValue()).wasInProv = false;
        }
        recentlyAdded.clear();
        recentlyAdded = null;
        was.clear();
        was = null;
        return out;
    }

    public final int getLoadingTurnActionsOfCivID() {
        return this.iLoadingTurnActionsOfCivID;
    }

    public final void setLoadingTurnActionsOfCivID(int iLoadingTurnActionsOfCivID) {
        this.iLoadingTurnActionsOfCivID = iLoadingTurnActionsOfCivID;
    }

    public final void updateExpand() {
        this.expandNeutral = !GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES ? new Expand(){

            @Override
            public boolean expandToNeutralProvinces(int nCivID) {
                return AI.this.expandToNeutralProvinces_Out(nCivID, true);
            }
        } : new Expand(){

            @Override
            public boolean expandToNeutralProvinces(int nCivID) {
                return false;
            }
        };
    }

    public final void expandToNeutralProvinces_Run(int nCivID) {
        for (int k = CFG.core.getCiv((int)nCivID).civGD.civPlans.armiesMissions.size() - 1; k >= 0; --k) {
            if (CFG.core.getCiv((int)nCivID).civGD.civPlans.armiesMissions.get((int)k).MISSION_TYPE != CivArmyMission_Type.EXPAND_NETURAL_PROVINCE || !CFG.core.getCiv((int)nCivID).civGD.civPlans.armiesMissions.get(k).action(nCivID)) continue;
            CFG.core.getCiv((int)nCivID).civGD.civPlans.armiesMissions.get(k).onRemove();
            CFG.core.getCiv((int)nCivID).civGD.civPlans.armiesMissions.remove(k);
        }
    }

    public final boolean expandToNeutralProvinces_Out(int nCivID, boolean maybeGoToTheSea) {
        block56: {
            try {
                if (CFG.core.getCiv(nCivID).getBordersWithEnemy() != 0) break block56;
                this.expandToNeutralProvinces_Run(nCivID);
                if (CFG.core.getCiv(nCivID).getMovemPoints() < CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_MOVE) {
                    return false;
                }
                if (!(CFG.core.getCiv((int)nCivID).bordersWithNeutralProvcsID.isEmpty() || this.iNeutralProvincesWithSeaAccessSize > 0 && maybeGoToTheSea && CFG.oR.nextInt(100) < 5 && CFG.core.getCiv(nCivID).getGold() > (long)BuildingsManager.getPort_BuildCost(1, CFG.core.getCiv(nCivID).getProvID(0)))) {
                    int i;
                    int recruitableArmyMax = (int)(CFG.core.getCiv(nCivID).getGold() / (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT);
                    ArrayList<NeutralProvinces> possibleProvinces = new ArrayList<NeutralProvinces>();
                    for (i = CFG.core.getCiv((int)nCivID).bordersWithNeutralProvcsID.size() - 1; i >= 0; --i) {
                        if (CFG.core.getProv(CFG.core.getCiv((int)nCivID).bordersWithNeutralProvcsID.get(i)).getArmyID(0) + 2 >= recruitableArmyMax + CFG.core.getCiv(nCivID).getNumberOfUnits()) continue;
                        possibleProvinces.add(new NeutralProvinces(CFG.core.getCiv((int)nCivID).bordersWithNeutralProvcsID.get(i), nCivID));
                    }
                    if (!possibleProvinces.isEmpty()) {
                        int i2;
                        ArrayList<Integer> sorted = new ArrayList<Integer>();
                        ArrayList<Integer> tempIDs = new ArrayList<Integer>();
                        int iSize = possibleProvinces.size();
                        for (i2 = 0; i2 < iSize; ++i2) {
                            tempIDs.add(i2);
                        }
                        while (!tempIDs.isEmpty()) {
                            int tBest = 0;
                            for (int i3 = tempIDs.size() - 1; i3 > 0; --i3) {
                                if (!(((NeutralProvinces)possibleProvinces.get((int)((Integer)tempIDs.get((int)tBest)).intValue())).iScore < ((NeutralProvinces)possibleProvinces.get((int)((Integer)tempIDs.get((int)i3)).intValue())).iScore)) continue;
                                tBest = i3;
                            }
                            sorted.add((Integer)tempIDs.get(tBest));
                            tempIDs.remove(tBest);
                        }
                        iSize = sorted.size();
                        for (i2 = 0; i2 < iSize; ++i2) {
                            ArrayList<Integer> possibleFrom = new ArrayList<Integer>();
                            for (int k = 0; k < CFG.core.getProv(((NeutralProvinces)possibleProvinces.get((int)((Integer)sorted.get((int)i2)).intValue())).iProvinceID).getNeighProvincesSize(); ++k) {
                                if (CFG.core.getProv(CFG.core.getProv(((NeutralProvinces)possibleProvinces.get((int)((Integer)sorted.get((int)i2)).intValue())).iProvinceID).getNeighProvinces(k)).getCivId() != nCivID) continue;
                                possibleFrom.add(CFG.core.getProv(((NeutralProvinces)possibleProvinces.get((int)((Integer)sorted.get((int)i2)).intValue())).iProvinceID).getNeighProvinces(k));
                            }
                            ArrayList<Integer> canMoveImmediately = new ArrayList<Integer>();
                            for (int k = possibleFrom.size() - 1; k >= 0; --k) {
                                if (CFG.core.getProv((Integer)possibleFrom.get(k)).getArmyCivID1(nCivID) - CFG.core.getCiv((int)nCivID).civGD.civPlans.haveMission_Army((Integer)possibleFrom.get(k)) <= CFG.core.getProv(((NeutralProvinces)possibleProvinces.get((int)((Integer)sorted.get((int)i2)).intValue())).iProvinceID).getArmyID(0)) continue;
                                canMoveImmediately.add((Integer)possibleFrom.get(k));
                            }
                            if (!canMoveImmediately.isEmpty()) {
                                int randID = CFG.oR.nextInt(canMoveImmediately.size());
                                int numOfNeutral = 0;
                                for (int k = 0; k < CFG.core.getProv((Integer)canMoveImmediately.get(randID)).getNeighProvincesSize(); ++k) {
                                    if (CFG.core.getProv(CFG.core.getProv((Integer)canMoveImmediately.get(randID)).getNeighProvinces(k)).getCivId() != 0 || CFG.core.getCiv(nCivID).isMovingUnitsToProvID(CFG.core.getProv((Integer)canMoveImmediately.get(randID)).getNeighProvinces(k))) continue;
                                    ++numOfNeutral;
                                }
                                long tArmyToMove = CFG.core.getProv((Integer)canMoveImmediately.get(randID)).getArmyCivID1(nCivID);
                                if (numOfNeutral > 1) {
                                    tArmyToMove = CFG.core.getProv(((NeutralProvinces)possibleProvinces.get((int)((Integer)sorted.get((int)i2)).intValue())).iProvinceID).getArmyID(0) + 5 + CFG.oR.nextInt(5);
                                }
                                if (CFG.gameAction.moveArmyAction((Integer)canMoveImmediately.get(randID), ((NeutralProvinces)possibleProvinces.get((int)((Integer)sorted.get((int)i2)).intValue())).iProvinceID, tArmyToMove, nCivID, true, false)) continue;
                                break block56;
                            }
                            if (!CFG.core.getCiv((int)nCivID).civGD.civPlans.addNewArmyMission(((NeutralProvinces)possibleProvinces.get((int)((Integer)sorted.get((int)i2)).intValue())).iProvinceID, new CivArmyMission_ExpandNeutralProvince(nCivID, ((NeutralProvinces)possibleProvinces.get((int)((Integer)sorted.get((int)i2)).intValue())).iProvinceID))) continue;
                        }
                        break block56;
                    }
                    for (i = CFG.core.getCiv((int)nCivID).bordersWithNeutralProvcsID.size() - 1; i >= 0; --i) {
                        possibleProvinces.add(new NeutralProvinces(CFG.core.getCiv((int)nCivID).bordersWithNeutralProvcsID.get(i), nCivID));
                    }
                    int tBest = 0;
                    for (int i4 = possibleProvinces.size() - 1; i4 > 0; --i4) {
                        if (!(((NeutralProvinces)possibleProvinces.get((int)tBest)).iScore < ((NeutralProvinces)possibleProvinces.get((int)i4)).iScore)) continue;
                        tBest = i4;
                    }
                    CFG.core.getCiv((int)nCivID).civGD.civPlans.addNewArmyMission(((NeutralProvinces)possibleProvinces.get((int)tBest)).iProvinceID, new CivArmyMission_ExpandNeutralProvince(nCivID, ((NeutralProvinces)possibleProvinces.get((int)tBest)).iProvinceID));
                    break block56;
                }
                if (maybeGoToTheSea) {
                    maybeGoToTheSea = false;
                    if (this.iNeutralProvincesWithSeaAccessSize > 0) {
                        long neutralArmy;
                        int i;
                        int tBest;
                        int o;
                        int k;
                        int j;
                        int i5;
                        ArrayList<NeutralProvinces> possibleTo = new ArrayList<NeutralProvinces>();
                        ArrayList<Integer> possibleTo_MoveFrom = new ArrayList<Integer>();
                        for (i5 = 0; i5 < CFG.core.getCiv(nCivID).getCivRegionsSize(); ++i5) {
                            if (!CFG.core.getCiv(nCivID).getCivRegion(i5).getSeaAccess()) continue;
                            for (j = 0; j < CFG.core.getCiv(nCivID).getCivRegion(i5).getProvincesSize(); ++j) {
                                if (CFG.core.getProv(CFG.core.getCiv(nCivID).getCivRegion(i5).getProvince(j)).getLvlOfPort() <= 0) continue;
                                for (k = 0; k < CFG.core.getProv(CFG.core.getCiv(nCivID).getCivRegion(i5).getProvince(j)).getNeighSeaProvincesSize(); ++k) {
                                    for (o = 0; o < CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getCivRegion(i5).getProvince(j)).getNeighSeaProvinces(k)).getNeighProvincesSize(); ++o) {
                                        if (CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getCivRegion(i5).getProvince(j)).getNeighSeaProvinces(k)).getNeighProvinces(o)).getSeaProv() || CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getCivRegion(i5).getProvince(j)).getNeighSeaProvinces(k)).getNeighProvinces(o)).getWastelandLvl() >= 0 || CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getCivRegion(i5).getProvince(j)).getNeighSeaProvinces(k)).getNeighProvinces(o)).getCivId() != 0) continue;
                                        possibleTo.add(new NeutralProvinces(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getCivRegion(i5).getProvince(j)).getNeighSeaProvinces(k)).getNeighProvinces(o), nCivID));
                                        possibleTo_MoveFrom.add(CFG.core.getCiv(nCivID).getCivRegion(i5).getProvince(j));
                                    }
                                }
                            }
                        }
                        for (i5 = 0; i5 < CFG.core.getCiv(nCivID).getCivRegionsSize(); ++i5) {
                            if (!CFG.core.getCiv(nCivID).getCivRegion(i5).getSeaAccess()) continue;
                            for (j = 0; j < CFG.core.getCiv(nCivID).getCivRegion(i5).getProvincesSize(); ++j) {
                                if (CFG.core.getProv(CFG.core.getCiv(nCivID).getCivRegion(i5).getProvince(j)).getLvlOfPort() <= 0) continue;
                                for (k = 0; k < CFG.core.getProv(CFG.core.getCiv(nCivID).getCivRegion(i5).getProvince(j)).getNeighSeaProvincesSize(); ++k) {
                                    for (o = 0; o < CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getCivRegion(i5).getProvince(j)).getNeighSeaProvinces(k)).getNeighProvincesSize(); ++o) {
                                        if (!CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getCivRegion(i5).getProvince(j)).getNeighSeaProvinces(k)).getNeighProvinces(o)).getSeaProv()) continue;
                                        for (int z = 0; z < CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getCivRegion(i5).getProvince(j)).getNeighSeaProvinces(k)).getNeighProvinces(o)).getNeighProvincesSize(); ++z) {
                                            if (CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getCivRegion(i5).getProvince(j)).getNeighSeaProvinces(k)).getNeighProvinces(o)).getNeighProvinces(z)).getSeaProv() || CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getCivRegion(i5).getProvince(j)).getNeighSeaProvinces(k)).getNeighProvinces(o)).getNeighProvinces(z)).getWastelandLvl() >= 0 || CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getCivRegion(i5).getProvince(j)).getNeighSeaProvinces(k)).getNeighProvinces(o)).getNeighProvinces(z)).getCivId() != 0) continue;
                                            possibleTo.add(new NeutralProvinces(CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(nCivID).getCivRegion(i5).getProvince(j)).getNeighSeaProvinces(k)).getNeighProvinces(o)).getNeighProvinces(z), nCivID));
                                            possibleTo_MoveFrom.add(CFG.core.getCiv(nCivID).getCivRegion(i5).getProvince(j));
                                        }
                                    }
                                }
                            }
                        }
                        if (!possibleTo.isEmpty()) {
                            tBest = 0;
                            for (i = possibleTo.size() - 1; i > 0; --i) {
                                if (!(((NeutralProvinces)possibleTo.get((int)tBest)).iScore < ((NeutralProvinces)possibleTo.get((int)i)).iScore)) continue;
                                tBest = i;
                            }
                            neutralArmy = CFG.core.getProv(((NeutralProvinces)possibleTo.get((int)tBest)).iProvinceID).getArmyID(0) + 6 - CFG.core.getCiv(nCivID).isMovingUnitsToProvID_Num(((NeutralProvinces)possibleTo.get((int)tBest)).iProvinceID) - CFG.core.getCiv((int)nCivID).civGD.civPlans.haveMission_Army(((NeutralProvinces)possibleTo.get((int)tBest)).iProvinceID);
                            if (neutralArmy >= 0) {
                                if (CFG.core.getProv((Integer)possibleTo_MoveFrom.get(tBest)).getArmyCivID1(nCivID) > neutralArmy) {
                                    RegroupArmy tryRegroupArmy = new RegroupArmy(nCivID, (Integer)possibleTo_MoveFrom.get(tBest), ((NeutralProvinces)possibleTo.get((int)tBest)).iProvinceID);
                                    if (tryRegroupArmy.getRouteSize() > 0 && CFG.gameAction.moveArmyAction((Integer)possibleTo_MoveFrom.get(tBest), tryRegroupArmy.getRoute(0), neutralArmy, nCivID, true, false)) {
                                        if (tryRegroupArmy.getRouteSize() > 1) {
                                            CFG.core.getCiv((int)nCivID).civGD.civPlans.armiesMissions.add(new CivArmyMission_ExpandNeutral_Check(nCivID, tryRegroupArmy.getRoute(0), ((NeutralProvinces)possibleTo.get((int)tBest)).iProvinceID, (int)neutralArmy));
                                        }
                                        return false;
                                    }
                                } else {
                                    long tArmyToRecruit = neutralArmy - CFG.core.getProv((Integer)possibleTo_MoveFrom.get(tBest)).getArmyCivID1(nCivID);
                                    CFG.core.getCiv(nCivID).recruitArmy_AI((Integer)possibleTo_MoveFrom.get(tBest), tArmyToRecruit);
                                    long tempArmy = CFG.core.getCiv(nCivID).getRecruitArmy_BasedOnProvinceID((Integer)possibleTo_MoveFrom.get(tBest)) + CFG.core.getProv((Integer)possibleTo_MoveFrom.get(tBest)).getArmyCivID1(nCivID);
                                    if (tempArmy > 0) {
                                        CFG.core.getCiv((int)nCivID).civGD.civPlans.armiesMissions.add(new CivArmyMission_ExpandNeutral_Check(nCivID, (Integer)possibleTo_MoveFrom.get(tBest), ((NeutralProvinces)possibleTo.get((int)tBest)).iProvinceID, (int)tempArmy));
                                    }
                                }
                            }
                        } else {
                            possibleTo_MoveFrom.clear();
                            possibleTo.clear();
                            for (int z = 0; z < CFG.core.getCiv(nCivID).getCivRegionsSize(); ++z) {
                                if (!CFG.core.getCiv(nCivID).getCivRegion(z).getSeaAccess()) continue;
                                for (j = 0; j < CFG.core.getCiv(nCivID).getCivRegion(z).getProvincesSize(); ++j) {
                                    if (CFG.core.getProv(CFG.core.getCiv(nCivID).getCivRegion(z).getProvince(j)).getLvlOfPort() < 0) continue;
                                    ArrayList<Integer> recentlyAdded = new ArrayList<Integer>();
                                    ArrayList<Integer> was = new ArrayList<Integer>();
                                    for (int k2 = 0; k2 < CFG.core.getProv(CFG.core.getCiv(nCivID).getCivRegion(z).getProvince(j)).getNeighSeaProvincesSize(); ++k2) {
                                        recentlyAdded.add(CFG.core.getProv(CFG.core.getCiv(nCivID).getCivRegion(z).getProvince(j)).getNeighSeaProvinces(k2));
                                        was.add(CFG.core.getProv(CFG.core.getCiv(nCivID).getCivRegion(z).getProvince(j)).getNeighSeaProvinces(k2));
                                        CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getCiv((int)nCivID).getCivRegion((int)z).getProvince((int)j)).getNeighSeaProvinces((int)k2)).wasInProv = true;
                                    }
                                    ArrayList<Integer> currProvinces = new ArrayList<Integer>();
                                    int nIteration_Distance = 0;
                                    boolean foundProvince = false;
                                    while (nIteration_Distance < CFG.core.getCiv((int)nCivID).civGD.expandNeutralProvinces_RangeCheck && !recentlyAdded.isEmpty()) {
                                        int a;
                                        currProvinces.clear();
                                        ++nIteration_Distance;
                                        for (a = recentlyAdded.size() - 1; a >= 0; --a) {
                                            boolean wasntAdded = true;
                                            for (int p = currProvinces.size() - 1; p >= 0; --p) {
                                                if (currProvinces.get(p) != recentlyAdded.get(a)) continue;
                                                wasntAdded = false;
                                                break;
                                            }
                                            if (!wasntAdded) continue;
                                            currProvinces.add((Integer)recentlyAdded.get(a));
                                        }
                                        recentlyAdded.clear();
                                        for (a = currProvinces.size() - 1; a >= 0; --a) {
                                            for (int i6 = 0; i6 < CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvincesSize(); ++i6) {
                                                if (CFG.core.getProv((int)CFG.core.getProv((int)((Integer)currProvinces.get((int)a)).intValue()).getNeighProvinces((int)i6)).wasInProv) continue;
                                                was.add(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i6));
                                                CFG.core.getProv((int)CFG.core.getProv((int)((Integer)currProvinces.get((int)a)).intValue()).getNeighProvinces((int)i6)).wasInProv = true;
                                                if (CFG.core.getProv(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i6)).getSeaProv()) {
                                                    recentlyAdded.add(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i6));
                                                    continue;
                                                }
                                                if (CFG.core.getProv(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i6)).getCivId() != 0 || CFG.core.getProv(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i6)).getWastelandLvl() >= 0) continue;
                                                possibleTo.add(new NeutralProvinces(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i6), nCivID));
                                                possibleTo_MoveFrom.add(CFG.core.getCiv(nCivID).getCivRegion(z).getProvince(j));
                                                foundProvince = true;
                                                recentlyAdded.add(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i6));
                                            }
                                        }
                                        if (!foundProvince) continue;
                                    }
                                    for (int p = was.size() - 1; p >= 0; --p) {
                                        CFG.core.getProv((int)((Integer)was.get((int)p)).intValue()).wasInProv = false;
                                    }
                                    recentlyAdded.clear();
                                    recentlyAdded = null;
                                    was.clear();
                                    was = null;
                                }
                            }
                            if (possibleTo.isEmpty()) {
                                CFG.core.getCiv((int)nCivID).civGD.expandNeutralProvinces_RangeCheck = Math.max(CFG.core.getCiv((int)nCivID).civGD.expandNeutralProvinces_RangeCheck + 1, CFG.core.getProvinSize() / 15);
                                this.expandToNeutralProvinces_Out(nCivID, false);
                            } else {
                                tBest = 0;
                                for (i = possibleTo.size() - 1; i > 0; --i) {
                                    if (!(((NeutralProvinces)possibleTo.get((int)tBest)).iScore < ((NeutralProvinces)possibleTo.get((int)i)).iScore)) continue;
                                    tBest = i;
                                }
                                neutralArmy = CFG.core.getProv(((NeutralProvinces)possibleTo.get((int)tBest)).iProvinceID).getArmyID(0) + 10 - CFG.core.getCiv(nCivID).isMovingUnitsToProvID_Num(((NeutralProvinces)possibleTo.get((int)tBest)).iProvinceID) - CFG.core.getCiv((int)nCivID).civGD.civPlans.haveMission_Army(((NeutralProvinces)possibleTo.get((int)tBest)).iProvinceID);
                                if (neutralArmy >= 0) {
                                    if (CFG.core.getProv((Integer)possibleTo_MoveFrom.get(tBest)).getArmyCivID1(nCivID) > neutralArmy) {
                                        RegroupArmy_PortToBuild tryRegroupArmy = new RegroupArmy_PortToBuild(nCivID, (Integer)possibleTo_MoveFrom.get(tBest), ((NeutralProvinces)possibleTo.get((int)tBest)).iProvinceID);
                                        if (tryRegroupArmy.getRouteSize() > 0 && CFG.gameAction.moveArmyAction((Integer)possibleTo_MoveFrom.get(tBest), tryRegroupArmy.getRoute(0), neutralArmy, nCivID, true, false)) {
                                            if (tryRegroupArmy.getRouteSize() > 1) {
                                                CFG.core.getCiv((int)nCivID).civGD.civPlans.armiesMissions.add(new CivArmyMission_Expand_BuildPort(nCivID, tryRegroupArmy.getRoute(0), ((NeutralProvinces)possibleTo.get((int)tBest)).iProvinceID, (int)neutralArmy));
                                            }
                                            return false;
                                        }
                                    } else {
                                        long tArmyToRecruit = neutralArmy - CFG.core.getProv((Integer)possibleTo_MoveFrom.get(tBest)).getArmyCivID1(nCivID);
                                        CFG.core.getCiv(nCivID).recruitArmy_AI((Integer)possibleTo_MoveFrom.get(tBest), tArmyToRecruit);
                                        long tempArmy = CFG.core.getCiv(nCivID).getRecruitArmy_BasedOnProvinceID((Integer)possibleTo_MoveFrom.get(tBest)) + CFG.core.getProv((Integer)possibleTo_MoveFrom.get(tBest)).getArmyCivID1(nCivID);
                                        if (tempArmy > 0) {
                                            CFG.core.getCiv((int)nCivID).civGD.civPlans.armiesMissions.add(new CivArmyMission_Expand_BuildPort(nCivID, (Integer)possibleTo_MoveFrom.get(tBest), ((NeutralProvinces)possibleTo.get((int)tBest)).iProvinceID, (int)tempArmy));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        return false;
    }

    public void aiBecomesAVassal() {
        try {
            if (GameCalendar.TURNID < GameValues.gvAiVassals.BECOME_VASSAL_MAX_TURN_ID && GameCalendar.TURNID % GameValues.gvAiVassals.BECOME_VASSAL_MODULO_TURN == GameValues.gvAiVassals.BECOME_VASSAL_TURN_CHECK_IF) {
                for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                    if (CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getNumOfProvs() <= 0 || CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civGD.iVassalsSize >= GameValues.gvAiVassals.BECOME_VASSAL_VASSALS_LIMIT || CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getPuppetOfCiv() != CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getCivId() || CFG.oR.nextInt(1000) > GameValues.gvAiVassals.BECOME_VASSAL_CHANCE_1000) continue;
                    ArrayList<Integer> possibleCivs = new ArrayList<Integer>();
                    for (int a = 0; a < CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civNeighbors.civsSize; ++a) {
                        if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civNeighbors.civs.get((int)a).civID).getIdeology()).REVOLUTIONARY || CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civNeighbors.civs.get((int)a).civID).getIsPlayer() || CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civNeighbors.civs.get((int)a).civID).getPuppetOfCiv() != CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civNeighbors.civs.get((int)a).civID || CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civNeighbors.civs.get((int)a).civID).getNumOfProvs() >= GameValues.gvAiVassals.BECOME_VASSAL_MAX_PROVINCES || !((float)CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civNeighbors.civs.get((int)a).civID).getNumOfProvs() < (float)CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getNumOfProvs() * GameValues.gvAiVassals.BECOME_VASSAL_LORD_PROVINCES_MODIFIER) || CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civNeighbors.civs.get((int)a).civID).getRankScore() >= CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getRankScore() || !(CFG.core.getCivRelationOfCivB(CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civNeighbors.civs.get((int)a).civID, CFG.core.getPlayer(i).getCivId()) >= (float)GameValues.gvAiVassals.BECOME_VASSAL_MIN_RELATION)) continue;
                        possibleCivs.add(CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civNeighbors.civs.get((int)a).civID);
                    }
                    if (possibleCivs.isEmpty()) continue;
                    int randID = CFG.oR.nextInt(possibleCivs.size());
                    CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).getCivDiploGD().messageBox.addMessage(new Message_BecomeVassal((Integer)possibleCivs.get(randID), CFG.core.getPlayer(i).getCivId()));
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public final List<AI_NeighProvinces> getAllNeighboringProvincesInRange_Regroup_ForNavalInvasion(int nProvinceID, int nCivID, int iRange, List<AI_NeighProvinces> out, List<Integer> was) {
        ArrayList<Integer> recentlyAdded = new ArrayList<Integer>();
        recentlyAdded.add(nProvinceID);
        was.add(nProvinceID);
        CFG.core.getProv((int)nProvinceID).wasInProv = true;
        ArrayList<Integer> currProvinces = new ArrayList<Integer>();
        int nIteration_Distance = 0;
        int iFirstFoundRange = -1;
        while ((nIteration_Distance < iRange || out.size() == 0) && recentlyAdded.size() > 0) {
            int a;
            currProvinces.clear();
            ++nIteration_Distance;
            for (a = recentlyAdded.size() - 1; a >= 0; --a) {
                boolean wasntAdded = true;
                for (int j = currProvinces.size() - 1; j >= 0; --j) {
                    if (currProvinces.get(j) != recentlyAdded.get(a)) continue;
                    wasntAdded = false;
                    break;
                }
                if (!wasntAdded) continue;
                currProvinces.add((Integer)recentlyAdded.get(a));
            }
            recentlyAdded.clear();
            for (a = currProvinces.size() - 1; a >= 0; --a) {
                for (int i = 0; i < CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvincesSize(); ++i) {
                    if (CFG.core.getProv((int)CFG.core.getProv((int)((Integer)currProvinces.get((int)a)).intValue()).getNeighProvinces((int)i)).wasInProv) continue;
                    was.add(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i));
                    CFG.core.getProv((int)CFG.core.getProv((int)((Integer)currProvinces.get((int)a)).intValue()).getNeighProvinces((int)i)).wasInProv = true;
                    if (!CFG.core.isAlly(nCivID, CFG.core.getProv(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i)).getCivId())) continue;
                    if (CFG.core.getProv(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i)).getArmyCivID1(nCivID) > 0) {
                        out.add(new AI_NeighProvinces(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i), nIteration_Distance));
                        if (iFirstFoundRange < 0) {
                            iFirstFoundRange = nIteration_Distance;
                        }
                    }
                    recentlyAdded.add(CFG.core.getProv((Integer)currProvinces.get(a)).getNeighProvinces(i));
                }
            }
            if (iFirstFoundRange <= 0 || iFirstFoundRange + 2 >= nIteration_Distance) continue;
        }
        for (int j = was.size() - 1; j >= 0; --j) {
            CFG.core.getProv((int)was.get((int)j).intValue()).wasInProv = false;
        }
        recentlyAdded.clear();
        recentlyAdded = null;
        was.clear();
        was = null;
        return out;
    }

    public final boolean prepareForWar_BordersWithEnemy(int nCivID, int nProvinceID) {
        Province province = CFG.core.getProv(nProvinceID);
        if (province.getBordersWithEnemy()) {
            for (int z = 0; z < province.getNeighProvincesSize(); ++z) {
                if (!CFG.core.getCivsAtWar(nCivID, CFG.core.getProv(province.getNeighProvinces(z)).getCivId())) continue;
                return true;
            }
        }
        return this.prepareForWar_BordersWithEnemy_Just(nCivID, nProvinceID);
    }

    public final boolean prepareForWar_BordersWithEnemy_Just(int nCivID, int nProvinceID) {
        for (int u = 0; u < CFG.core.getCiv((int)nCivID).civGD.civPlans.iWarPrepsSize; ++u) {
            Province province = CFG.core.getProv(nProvinceID);
            for (int k = 0; k < province.getNeighProvincesSize(); ++k) {
                if (CFG.core.getProv(province.getNeighProvinces(k)).getCivId() != CFG.core.getCiv((int)nCivID).civGD.civPlans.warPreps.get((int)u).onCivID) continue;
                return true;
            }
        }
        return false;
    }

    public void buildNukes() {
        try {
            if (!CFG.ENABLE_NUKES) {
                return;
            }
            if (CFG.NUKES_MIN_YEAR_ENABLED && GameCalendar.currYear < GameValues.gvAtomic.ATOMIC_BOMB_MIN_YEAR) {
                return;
            }
            for (int i = 1 + GameCalendar.TURNID % GameValues.gvAiNuke.BUILD_NUKE_GAME_UPDATE_TURNS; i < CFG.core.getCivsSize(); i += GameValues.gvAiNuke.BUILD_NUKE_GAME_UPDATE_TURNS) {
                if (CFG.core.getCiv(i).getIsPlayer() || !(CFG.core.getCiv(i).getTechLevel() >= CFG.NUKES_REQUIRED_TECH_LVL) || !NukeManager.canBuildMore(i)) continue;
                for (int a = 0; a < GameValues.gvAiNuke.BUILD_NUKE_LIMIT_PER_TURN && NukeManager.buildNuke(i); ++a) {
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public void buildWonders() {
        try {
            if (!CFG.core.wondersMgr.wondersProvinceIDs.isEmpty()) {
                for (int i = GameCalendar.TURNID % CFG.core.wondersMgr.wondersProvinceIDs.size(); i < CFG.core.wondersMgr.wondersProvinceIDs.size(); i += CFG.core.wondersMgr.wondersProvinceIDs.size()) {
                    if (CFG.core.getProv((int)CFG.core.wondersMgr.wondersProvinceIDs.get((int)i).intValue()).provGD.wonderBuilt || CFG.core.getCiv(CFG.core.getProv(CFG.core.wondersMgr.wondersProvinceIDs.get(i)).getCivId()).getIsPlayer() || CFG.core.getCiv(CFG.core.getProv(CFG.core.wondersMgr.wondersProvinceIDs.get(i)).getCivId()).isAtWarC() || CFG.core.getCiv(i).getGold() < (long)Wonders_Manager.getWonderCost(CFG.core.wondersMgr.wondersProvinceIDs.get(i))) continue;
                    Wonders_Manager.buildWonder(CFG.core.wondersMgr.wondersProvinceIDs.get(i));
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static interface Expand {
        public boolean expandToNeutralProvinces(int var1);
    }

    public class NeutralProvinces {
        public int iProvinceID;
        public float iScore;

        public NeutralProvinces(int nProvinceID, int nCivID) {
            this.iProvinceID = nProvinceID;
            this.buildScore(nCivID);
        }

        public final void buildScore(int nCivID) {
            int neighboring_NeutralProvinces = 0;
            int neighboring_CivProvinces = 0;
            int neighboring_OtherCivProvinces = 0;
            for (int i = 0; i < CFG.core.getProv(this.iProvinceID).getNeighProvincesSize(); ++i) {
                if (CFG.core.getProv(CFG.core.getProv(this.iProvinceID).getNeighProvinces(i)).getWastelandLvl() >= 0) continue;
                if (CFG.core.getProv(CFG.core.getProv(this.iProvinceID).getNeighProvinces(i)).getCivId() == nCivID) {
                    this.iScore = CFG.core.getProv(this.iProvinceID).getNeighProvinces(i) == CFG.core.getCiv(nCivID).getCapitalProvID() ? (this.iScore += CFG.core.getCiv((int)nCivID).NEUTRAL_EXPAND_CAPITAL) : (this.iScore += CFG.core.getCiv((int)nCivID).NEUTRAL_EXPAND_OWN_PROVINCE);
                    ++neighboring_CivProvinces;
                    continue;
                }
                if (CFG.core.getProv(CFG.core.getProv(this.iProvinceID).getNeighProvinces(i)).getCivId() == 0) {
                    ++neighboring_NeutralProvinces;
                    this.iScore += CFG.core.getCiv((int)nCivID).NEUTRAL_EXPAND_MORE_NEUTRAL;
                    continue;
                }
                ++neighboring_OtherCivProvinces;
                this.iScore += CFG.core.getCiv((int)nCivID).NEUTRAL_EXPAND_OTHER_CIV;
            }
            this.iScore += CFG.core.getCiv((int)nCivID).NEUTRAL_EXPAND_GROWTH_RATE * CFG.core.getProv(this.iProvinceID).getGrowthRate_Pop();
            if (CFG.core.getProv(this.iProvinceID).getNeighSeaProvincesSize() > 0) {
                this.iScore += CFG.core.getCiv((int)nCivID).NEUTRAL_EXPAND_SEA_ACCESS + CFG.core.getCiv((int)nCivID).NEUTRAL_EXPAND_SEA_ACCESS_EXTRA * (float)CFG.core.getProv(this.iProvinceID).getNeighSeaProvincesSize();
            }
            this.iScore += CFG.core.getCiv((int)nCivID).NEUTRAL_EXPAND_NEIGHBORING_PROVINCES * (float)(neighboring_CivProvinces + neighboring_NeutralProvinces + neighboring_OtherCivProvinces);
            this.iScore += (float)((int)(CFG.core.getCiv((int)nCivID).NEUTRAL_EXPAND_NEIGHBORING_PROVINCES_POTENTIAL * (float)(neighboring_NeutralProvinces + neighboring_CivProvinces) / (float)(neighboring_CivProvinces + neighboring_NeutralProvinces + neighboring_OtherCivProvinces)));
            if (neighboring_NeutralProvinces == 0 && CFG.core.getProv(this.iProvinceID).getNeighProvincesSize() > 0) {
                this.iScore += CFG.core.getCiv((int)nCivID).NEUTRAL_EXPAND_LAST_PROVINCE;
            } else if (neighboring_CivProvinces <= 1) {
                this.iScore *= 0.725f;
            }
        }
    }
}

