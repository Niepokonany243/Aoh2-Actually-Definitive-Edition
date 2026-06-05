
package age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle;

import age.of.civilizations2.jakowski.lukasz.AI.AI_ArmyUpkeep;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Assimilate_Data;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Option;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Option_Armoury;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Option_Fort;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Option_Invest;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Option_Invest2;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Option_Invest_Development;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Option_Invest_Development2;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Option_Library;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Option_Market;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Option_Port;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Option_Supplies;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Option_Tower;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Option_Workshop;
import age.of.civilizations2.jakowski.lukasz.AI.AI_CivsInRange;
import age.of.civilizations2.jakowski.lukasz.AI.AI_ImproveRelations;
import age.of.civilizations2.jakowski.lukasz.AI.AI_NeighProvinces;
import age.of.civilizations2.jakowski.lukasz.AI.AI_RegoupArmyData;
import age.of.civilizations2.jakowski.lukasz.AI.AI_ReleaseVassal;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Rival;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Skills.AI_Skills;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Skills.AI_Skills_Administration;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Skills.AI_Skills_Assimilate;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Skills.AI_Skills_Eco;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Skills.AI_Skills_Military;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Skills.AI_Skills_Movement;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Skills.AI_Skills_Production;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Skills.AI_Skills_Recruitable;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Skills.AI_Skills_Research;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Skills.AI_Skills_Taxation;
import age.of.civilizations2.jakowski.lukasz.AI.FrontLine.AI_Frontline;
import age.of.civilizations2.jakowski.lukasz.AI.Province.AI_ProvinceInfo;
import age.of.civilizations2.jakowski.lukasz.AI.Province.AI_ProvinceInfo_War;
import age.of.civilizations2.jakowski.lukasz.AI.Province.AI_ProvinceValue;
import age.of.civilizations2.jakowski.lukasz.Alliance;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Civilization_SentMessages;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission_ColonizeProvince;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission_ColonizeProvince_Just;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission_NavalInvasion;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission_RegroupAfterRecruitment;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission_RegroupAfterRecruitment_War;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission_RegroupAfterRecruitment_War_Double;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission_Type;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.PeaceTreaty_Data;
import age.of.civilizations2.jakowski.lukasz.Diplomacy.Festivals.Festival;
import age.of.civilizations2.jakowski.lukasz.Diplomacy.Loans;
import age.of.civilizations2.jakowski.lukasz.Diplomacy.Plunder;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Managers.RivalsManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Distance;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Distance;
import age.of.civilizations2.jakowski.lukasz.MapA.Plagues.Nuke.NukeManager;
import age.of.civilizations2.jakowski.lukasz.Menus.PeaceTreaty.Menu_PeaceTreaty;
import age.of.civilizations2.jakowski.lukasz.Messages.Message;
import age.of.civilizations2.jakowski.lukasz.Messages.MessageBox_GameData;
import age.of.civilizations2.jakowski.lukasz.Messages.MessageType;
import age.of.civilizations2.jakowski.lukasz.Messages.Relations.Message_Rivals;
import age.of.civilizations2.jakowski.lukasz.Province;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy_AtPeace;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy_AtWar;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy_ToTheFront_Double;
import age.of.civilizations2.jakowski.lukasz.SkillsManager;
import age.of.civilizations2.jakowski.lukasz.TradeRequest_GameData;
import age.of.civilizations2.jakowski.lukasz.Ultimatum_GameData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AIPlaystyle {
    public String TAG = "DEFAULT";
    public float PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT = 0.1f;
    public int PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM = 13;
    public float PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT = 0.6f;
    public int PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM = 35;
    public int PERSONALITY_MIN_HAPPINESS_DEFAULT = 69;
    public int PERSONALITY_MIN_HAPPINESS_RANDOM = 24;
    public float PERSONALITY_FORGIVENESS_DEFAULT = 1.0f;
    public int PERSONALITY_FORGIVENESS_RANDOM = 50;
    public int USE_OF_BUDGET_FOR_SPENDINGS = 35;
    public int USE_OF_BUDGET_FOR_SPENDINGS_RANDOM = 65;
    public int PERSONALITY_GOODS_RANDOM = 100;
    public int PERSONALITY_INVESTMENTS_RANDOM = 100;
    public int PERSONALITY_RESEARCH_RANDOM = 100;
    public int PERSONALITY_PLUNDER_MIN = 0;
    public int PERSONALITY_PLUNDER_RANDOM = 45;
    public int PERSONALITY_PLUNDER_LOCK = 78;
    public float PERSONALITY_MIN_AGGRESSION_DEFAULT = 0.2475f;
    public int PERSONALITY_MIN_AGGRESSION_RANDOM_100 = 4825;
    public boolean armyOverBudget = false;
    public int MIN_TURNS_TO_ABANDON_USELESS_PROVINCE = 25;

    public float getMinMilitarySpending(int nCivID) {
        if (CFG.core.getCiv((int)nCivID).civGD.sandboxMilitarySpendInfinite) {
            return 2.5f;
        }
        if (CFG.core.getCiv((int)nCivID).civGD.sandboxMilitarise) {
            return CFG.core.getCiv((int)nCivID).civGD.sandboxMilitarySpendTarget > 0.0f ? CFG.core.getCiv((int)nCivID).civGD.sandboxMilitarySpendTarget : 1.0f;
        }
        if (CFG.core.getCiv((int)nCivID).civGD.sandboxMilitarySpendTarget > 0.0f) {
            return CFG.core.getCiv((int)nCivID).civGD.sandboxMilitarySpendTarget;
        }
        return CFG.core.getCiv((int)nCivID).civGD.civPers.MIN_MILITARY_SPENDINGS;
    }

    public void turnOrders(int nCivID) {
        this.armyOverBudget = false;
        this.relocateLostCapital(nCivID);
        this.changeTypeOfIdeology(nCivID);
        if (CFG.core.getCiv((int)nCivID).civGD.civPlans.iWarPrepsSize > 0) {
            CFG.core.getCiv((int)nCivID).civGD.civPlans.checkWarPreparations(nCivID);
        }
        
        boolean isAtWar = CFG.core.getCiv(nCivID).isAtWarC();
        boolean isPreparingForWar = CFG.core.getCiv((int)nCivID).civGD.civPlans.isPreparingForTheWar();
        boolean sandboxMilitaryControl = CFG.core.getCiv((int)nCivID).civGD.sandboxMilitarySpendInfinite || CFG.core.getCiv((int)nCivID).civGD.sandboxMilitarySpendTarget > 0.0f || CFG.core.getCiv((int)nCivID).civGD.sandboxMilitarise;
        if (CFG.core.getCiv(nCivID).civGD.sandboxNoDisband) {
            CFG.core.getCiv(nCivID).civGD.aiNoDisbandUntilTurnID = Integer.MAX_VALUE;
        }
        this.sandboxRegroupArmies(nCivID);
        if (sandboxMilitaryControl) {
            this.sandboxRecruitToMilitaryTarget(nCivID);
        }
        this.applySandboxSpendings(nCivID);
        this.sandboxForcedDomesticSpend(nCivID);

        try {
            if (isAtWar) {
                this.takeLoanAtWar(nCivID);
                this.defendFromSeaInvasion(nCivID);
                this.moveAtWar(nCivID);
                this.armyOverBudget = true;
            }
            if (isPreparingForWar) {
                this.prepareForWar2(nCivID);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        
        if (isAtWar || isPreparingForWar) {
            if (CFG.core.getCiv(nCivID).civGD.sandboxMissileSpend > 0) {
                this.sandboxMissileProduction(nCivID);
            } else {
                this.missileProduction(nCivID, true);
            }
        }

        CFG.oAI.expandNeutral.expandToNeutralProvinces(nCivID);
        if (!sandboxMilitaryControl && this.getMinMilitarySpending(nCivID) + 0.025f < CFG.core.getCiv((int)nCivID).iMilitaryUpkeep_PERC) {
            if (!(CFG.settingsGD.EXPERIMENTAL_BATTLE_SYSTEM && GameCalendar.TURNID - CFG.core.getCiv(nCivID).civGD.iLastWarTurnID < 30)) {
                this.armyOverBudget_Disband(nCivID);
            }
            this.armyOverBudget = true;
        }
        if (CFG.core.getCiv(nCivID).getHappiness() < GameValues.gvAiProvince.HAPPINESS_CRISIS_BASE + CFG.oR.nextInt(GameValues.gvAiProvince.HAPPINESS_CRISIS_RANDOM)) {
            this.happinessCrisis(nCivID);
        } else if (!CFG.core.getCiv((int)nCivID).provincesWithLowHappiness.isEmpty() && CFG.core.getCiv(nCivID).getTaxationLvl() <= CFG.ideologiesMgr.getAcceptableTaxation(CFG.core.getCiv(nCivID).getIdeology(), nCivID) && CFG.core.getCiv(nCivID).getSpendingGoodsB() >= CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).getMin_Goods(nCivID)) {
            if (isAtWar || isPreparingForWar) {
                long income = CFG.gameUpdate.getIncome(nCivID);
                long festivalBudget = (long)((float)income * 0.05f);
                int maxFestivals = 1;
                if (festivalBudget > 0L && CFG.core.getCiv((int)nCivID).provincesWithLowHappiness.size() > 0) {
                    long cost = Festival.festivalCost(CFG.core.getCiv((int)nCivID).provincesWithLowHappiness.get(0));
                    if (cost > 0L) {
                        maxFestivals = Math.max(1, (int)(festivalBudget / cost));
                    }
                }
                this.hostFestivals(nCivID, maxFestivals);
            } else {
                this.hostFestivals(nCivID, CFG.core.getCiv(nCivID).getNumOfProvs());
            }
        }
        if (!CFG.core.getCiv((int)nCivID).provincesWithLowStability.isEmpty()) {
            this.assimilateProvinces(nCivID);
        }
        if (!this.isAtWarOnlyWithWeakRebels(nCivID)) {
            if ((!this.armyOverBudget || CFG.core.getCiv(nCivID).getBordersWithEnemy() == 0 || sandboxMilitaryControl) && CFG.core.getCiv(nCivID).getGold() > 0L && this.getMinMilitarySpending(nCivID) > CFG.core.getCiv((int)nCivID).iMilitaryUpkeep_PERC) {
                this.recruitMilitary_MinSpending(nCivID);
            }
            if (sandboxMilitaryControl) {
                this.sandboxRecruitToMilitaryTarget(nCivID);
            }
        }
        if (!this.armyOverBudget) {
            this.colonizeProvinces(nCivID);
        }
        if (!isAtWar && !isPreparingForWar && CFG.core.getCiv((int)nCivID).civGD.sandboxRegroupUntilTurnID < GameCalendar.TURNID) {
            this.regroupArmy_AtPeace(nCivID);
        }
        this.regroupArmyAfterRecruitment(nCivID);
        if (isAtWar && CFG.core.getCiv(nCivID).numOf_Ports == 0 && CFG.core.getCiv(nCivID).getSeaAccess() > 0) {
            this.buildBuildings(nCivID);
        } else if (isAtWar && CFG.core.getCiv(nCivID).civGD.sandboxBuildAtWar && CFG.core.getCiv(nCivID).getMovemPoints() > GameValues.gvAiProvince.BUILD_INVEST_MIN_MOVEMENT_POINTS && CFG.core.getCiv(nCivID).getGold() > (long)GameValues.gvAiProvince.MIN_GOLD_TO_BUILD) {
            this.buildBuildings(nCivID);
        }
        if (isPreparingForWar) {
            this.prepareForWar_MoveReadyArmies(nCivID);
            List<Integer> prepLeaders = new ArrayList<Integer>();
            List<Integer> prepWarIDs = new ArrayList<Integer>();
            for (int i = CFG.core.getCiv((int)nCivID).civGD.civPlans.iWarPrepsSize - 1; i >= 0; --i) {
                if (CFG.core.getCiv((int)nCivID).civGD.civPlans.warPreps.get((int)i).iNumOfTurnsLeft-- > 0) continue;
                int tOnCivID = CFG.core.getCiv((int)nCivID).civGD.civPlans.warPreps.get((int)i).onCivID;
                int tLeaderCivID = CFG.core.getCiv((int)nCivID).civGD.civPlans.warPreps.get((int)i).iLeaderCivID;
                int tLeaderID = -1;
                int tWarID = -1;
                for (int j = 0; j < prepLeaders.size(); ++j) {
                    if (prepLeaders.get(j) != tLeaderCivID) continue;
                    tLeaderID = j;
                    tWarID = prepWarIDs.get(j);
                    break;
                }
                tWarID = GameManager.declareWarInWarGroup(nCivID, tOnCivID, tWarID, false);
                if (tWarID >= 0) {
                    if (tLeaderID >= 0) {
                        prepWarIDs.set(tLeaderID, tWarID);
                    } else {
                        prepLeaders.add(tLeaderCivID);
                        prepWarIDs.add(tWarID);
                    }
                }
                for (int k = CFG.core.getCiv((int)nCivID).civGD.civPlans.armiesMissions.size() - 1; k >= 0; --k) {
                    if (CFG.core.getCiv((int)nCivID).civGD.civPlans.armiesMissions.get((int)k).MISSION_TYPE != CivArmyMission_Type.PREAPARE_FOR_WAR || CFG.core.getCiv((int)nCivID).civGD.civPlans.armiesMissions.get((int)k).MISSION_ID != tOnCivID) continue;
                    CFG.core.getCiv((int)nCivID).civGD.civPlans.armiesMissions.remove(k);
                }
                try {
                    CFG.core.getCiv((int)nCivID).civGD.civPlans.warPreps.remove(i);
                    CFG.core.getCiv((int)nCivID).civGD.civPlans.iWarPrepsSize = CFG.core.getCiv((int)nCivID).civGD.civPlans.warPreps.size();
                    continue;
                }
                catch (Exception exception) {
                    
                }
            }
        } else if (!isAtWar && !CFG.core.getCiv(nCivID).civGD.sandboxMilitarise && CFG.core.getCiv(nCivID).getMovemPoints() > GameValues.gvAiProvince.BUILD_INVEST_MIN_MOVEMENT_POINTS) {
            
            this.billionaireBuilding(nCivID);

            if (!CFG.settingsGD.DISABLE_AI_INVESTING && GameCalendar.TURNID % GameValues.gvAiProvince.EXTRA_INVEST_ECO_EVERY_X_TURN == nCivID % GameValues.gvAiProvince.EXTRA_INVEST_ECO_EVERY_X_TURN) {
                if (CFG.core.getCiv(nCivID).getMovemPoints() >= GameValues.gvInvestEconomy.INVEST_ECO_COST_MOVEMENT_POINTS && CFG.core.getCiv(nCivID).getGold() > (long)GameValues.gvAiProvince.MIN_GOLD_TO_INVEST) {
                    this.buildInvestEco(nCivID);
                }
            } else if (CFG.core.getCiv(nCivID).getMovemPoints() > GameValues.gvAiProvince.BUILD_INVEST_MIN_MOVEMENT_POINTS && CFG.core.getCiv(nCivID).getGold() > (long)GameValues.gvAiProvince.MIN_GOLD_TO_BUILD) {
                this.buildBuildings(nCivID);
            }
            if (GameCalendar.TURNID > GameValues.gvAiProvince.EXTRA_INVEST_DEVELOPMENT_MIN_TURN_ID && CFG.core.getCiv(nCivID).getMovemPoints() >= GameValues.gvInvestEconomy.INVEST_ECO_COST_MOVEMENT_POINTS && CFG.core.getCiv(nCivID).getGold() > (long)GameValues.gvAiProvince.MIN_GOLD_TO_INVEST) {
                this.buildInvestDev(nCivID);
            }
        }
        CFG.core.getCiv((int)nCivID).civGD.moveAtWar_ProvincesLostAndConquered_LastTurn = 0;
        
        
        if (!isAtWar && !isPreparingForWar) {
            if (CFG.core.getCiv(nCivID).civGD.sandboxMissileSpend > 0) {
                this.sandboxMissileProduction(nCivID);
            } else {
                this.missileProduction(nCivID, false);
            }
        }

        if (sandboxMilitaryControl) {
            this.sandboxRecruitToMilitaryTarget(nCivID);
        }

        this.nukeDropBomb(nCivID);
    }

    private void sandboxRegroupArmies(int nCivID) {
        Civilization civ = CFG.core.getCiv(nCivID);
        if (civ.civGD.sandboxRegroupUntilTurnID < GameCalendar.TURNID || civ.getRegroupArmySize() > 0) {
            return;
        }
        if (civ.civGD.sandboxRegroupTargetProvinceIDs == null) {
            civ.civGD.sandboxRegroupTargetProvinceIDs = new java.util.ArrayList<Integer>();
        }
        if (civ.civGD.sandboxRegroupTargetProvinceID >= 0 && !civ.civGD.sandboxRegroupTargetProvinceIDs.contains(civ.civGD.sandboxRegroupTargetProvinceID)) {
            civ.civGD.sandboxRegroupTargetProvinceIDs.add(civ.civGD.sandboxRegroupTargetProvinceID);
        }
        for (int i = civ.civGD.sandboxRegroupTargetProvinceIDs.size() - 1; i >= 0; --i) {
            int provinceID = civ.civGD.sandboxRegroupTargetProvinceIDs.get(i);
            if (provinceID < 0 || provinceID >= CFG.core.getProvinSize() || CFG.core.getProv(provinceID).getCivId() != nCivID) {
                civ.civGD.sandboxRegroupTargetProvinceIDs.remove(i);
            }
        }
        if (civ.civGD.sandboxRegroupTargetProvinceIDs.isEmpty()) {
            civ.civGD.sandboxRegroupTargetProvinceID = -1;
            return;
        }
        civ.civGD.sandboxRegroupTargetProvinceID = civ.civGD.sandboxRegroupTargetProvinceIDs.get(0);
        for (int i = civ.armiesPositionSize - 1; i >= 0; --i) {
            int fromProvinceID = civ.armiesPosition.get(i);
            if (civ.civGD.sandboxRegroupTargetProvinceIDs.contains(fromProvinceID) || CFG.core.getProv(fromProvinceID).getArmyCivID1(nCivID) <= 0L) continue;
            int targetProvinceID = civ.civGD.sandboxRegroupTargetProvinceIDs.get(Math.abs(fromProvinceID) % civ.civGD.sandboxRegroupTargetProvinceIDs.size());
            RegroupArmy regroupArmy = new RegroupArmy(nCivID, fromProvinceID, targetProvinceID);
            if (regroupArmy.getRouteSize() <= 0) continue;
            regroupArmy.setNumOfUnits((int)CFG.core.getProv(fromProvinceID).getArmyCivID1(nCivID));
            civ.addRegroupArmy(regroupArmy);
        }
        if (civ.civGD.sandboxRegroupUntilTurnID == Integer.MAX_VALUE) {
            civ.civGD.aiNoDisbandUntilTurnID = Integer.MAX_VALUE;
        } else {
            civ.civGD.aiNoDisbandUntilTurnID = Math.max(civ.civGD.aiNoDisbandUntilTurnID, civ.civGD.sandboxRegroupUntilTurnID + 3);
        }
    }

    private void sandboxRecruitToMilitaryTarget(int nCivID) {
        Civilization civ = CFG.core.getCiv(nCivID);
        float targetMilitarySpend = civ.civGD.sandboxMilitarySpendInfinite ? 2.5f : (civ.civGD.sandboxMilitarySpendTarget > 0.0f ? civ.civGD.sandboxMilitarySpendTarget : (civ.civGD.sandboxMilitarise ? 1.0f : 0.0f));
        if (targetMilitarySpend <= 0.0f) {
            return;
        }
        long budget = Math.max(1L, CFG.core.getCiv((int)nCivID).iBudget);
        long targetUpkeep = (long)((float)budget * targetMilitarySpend);
        long currentUpkeep = CFG.gameUpdate.getMilitaryUpkeep_Total(nCivID);
        if ((!civ.civGD.sandboxMilitarySpendInfinite && currentUpkeep >= targetUpkeep) || civ.getGold() <= 0L) {
            return;
        }
        long maxSpend = civ.civGD.sandboxMilitarySpendInfinite || civ.civGD.sandboxMilitarise ? civ.getGold() : (long)((float)civ.getGold() * 0.4f);
        if (maxSpend <= 0L) {
            return;
        }
        long spent = 0L;
        java.util.ArrayList<Integer> shuffledProvinces = new java.util.ArrayList<Integer>();
        for (int i = 0; i < civ.getNumOfProvs(); i++) {
            shuffledProvinces.add(civ.getProvID(i));
        }
        java.util.Collections.shuffle(shuffledProvinces, CFG.oR);
        for (int i = 0; i < shuffledProvinces.size() && spent < maxSpend && (civ.civGD.sandboxMilitarySpendInfinite || currentUpkeep < targetUpkeep); ++i) {
            int provinceID = shuffledProvinces.get(i);
            if (CFG.core.getProv(provinceID).isOccupied() || Core.ISIP(provinceID)) continue;
            if (civ.isAtWarC() && !this.isValidAIWarRecruitProvince(nCivID, provinceID)) continue;
            long cost = Math.max(1L, (long)CFG.gCARR(provinceID));
            long recruitable = CFG.gameAction.gMARY(provinceID);
            if (recruitable <= 0L) continue;
            float upkeepPerUnit = Math.max(0.001f, CFG.gameUpdate.getMilitaryUpkeepP(provinceID, 1, nCivID));
            long neededUnits = civ.civGD.sandboxMilitarySpendInfinite ? recruitable : (long)Math.ceil((float)(targetUpkeep - currentUpkeep) / upkeepPerUnit);
            long toRecruit = Math.min(recruitable, Math.min(neededUnits, (maxSpend - spent) / cost));
            if (toRecruit <= 0L) continue;
            civ.recruitArmy_AI(provinceID, toRecruit);
            spent += toRecruit * cost;
            currentUpkeep += (long)((float)toRecruit * upkeepPerUnit);
            civ.civGD.aiNoDisbandUntilTurnID = civ.civGD.sandboxMilitarySpendInfinite || civ.civGD.sandboxMilitarise ? Math.max(civ.civGD.aiNoDisbandUntilTurnID, GameCalendar.TURNID + 50) : Math.max(civ.civGD.aiNoDisbandUntilTurnID, GameCalendar.TURNID + 10);
            if (civ.getMovemPoints() < CFG.ideologiesMgr.getIdeologyID(civ.getIdeology()).COST_OF_RECRUIT) {
                return;
            }
        }
    }

    private void sandboxMissileProduction(int nCivID) {
        if (!CFG.settingsGD.MISSILES) return;
        Civilization civ = CFG.core.getCiv(nCivID);
        long maxSpend = Math.min((long)civ.civGD.sandboxMissileSpend, civ.getGold());
        long spent = 0L;
        while (spent < maxSpend) {
            long missileCost = age.of.civilizations2.jakowski.lukasz.MapA.MissileManager.calculateMissileCost(nCivID, civ.civGD.iMissileTier);
            if (missileCost <= 0L || spent + missileCost > maxSpend || civ.getGold() < missileCost) break;
            if (!age.of.civilizations2.jakowski.lukasz.MapA.MissileManager.buildMissile(nCivID)) break;
            spent += missileCost;
        }
    }

    private void applySandboxSpendings(int nCivID) {
        Civilization civ = CFG.core.getCiv(nCivID);
        if (civ.civGD.sandboxGoodsSpendTarget >= 0.0f) {
            civ.setSpendingGoodsB(civ.civGD.sandboxGoodsSpendTarget);
        }
        if (civ.civGD.sandboxResearchSpendTarget >= 0.0f) {
            civ.setSpendingResearchB(civ.civGD.sandboxResearchSpendTarget);
        }
        if (civ.civGD.sandboxInvestmentsSpendTarget >= 0.0f) {
            civ.setSpendingInvestmentsB(civ.civGD.sandboxInvestmentsSpendTarget);
        }
    }

    private void sandboxForcedDomesticSpend(int nCivID) {
        Civilization civ = CFG.core.getCiv(nCivID);
        if (civ.civGD.sandboxBuildingSpend > 0) {
            long spent = 0L;
            while (spent < (long)civ.civGD.sandboxBuildingSpend && civ.getGold() > 0L) {
                long before = civ.getGold();
                this.sandboxBuildBuildingsOnly(nCivID);
                long delta = before - civ.getGold();
                if (delta <= 0L) break;
                spent += delta;
            }
        }
        if (civ.civGD.sandboxDevelopmentSpend > 0) {
            long spent = 0L;
            while (spent < (long)civ.civGD.sandboxDevelopmentSpend && civ.getGold() > 0L) {
                long before = civ.getGold();
                this.buildInvestDev(nCivID);
                long delta = before - civ.getGold();
                if (delta <= 0L) break;
                spent += delta;
            }
        }
    }

    private void sandboxBuildBuildingsOnly(int nCivID) {
        if (this.build_GetMoney(nCivID) <= 0L) return;
        ArrayList<AI_Build_Option> options = new ArrayList<AI_Build_Option>();
        Civilization civ = CFG.core.getCiv(nCivID);
        try {
            if (civ.getTechLevel() >= BuildingsManager.getFarm_TechLevel(1) && civ.numOf_Farms_ProvincesPossibleToBuild * BuildingsManager.getWorkshop_MaxLevel_CanBuild(nCivID) > civ.numOf_Farms) {
                options.add(new AI_Build_Option());
            }
            if (civ.getTechLevel() >= BuildingsManager.getWorkshop_TechLevel(1) && civ.getNumOfProvs() * BuildingsManager.getWorkshop_MaxLevel_CanBuild(nCivID) > civ.numOf_Workshops) {
                options.add(new AI_Build_Option_Workshop());
            }
            if (civ.getTechLevel() >= BuildingsManager.getMarket_TechLevel(1) && civ.getNumOfProvs() * BuildingsManager.getMarket_MaxLevel_CanBuild(nCivID) > civ.numOf_Markets) {
                options.add(new AI_Build_Option_Market());
            }
            if (civ.getTechLevel() >= BuildingsManager.getLibrary_TechLevel(1) && civ.getNumOfProvs() * BuildingsManager.getLibrary_MaxLevel_CanBuild(nCivID) > civ.numOf_Libraries) {
                options.add(new AI_Build_Option_Library());
            }
            if (civ.getSeaAccess() > 0 && civ.getTechLevel() >= BuildingsManager.getPort_TechLevel(1) && civ.getNumOfProvs() > civ.numOf_Ports) {
                options.add(new AI_Build_Option_Port());
            }
            if (civ.getTechLevel() >= BuildingsManager.getArmoury_TechLevel(1) && civ.getNumOfProvs() > civ.numOf_Armories) {
                options.add(new AI_Build_Option_Armoury());
            }
            if (civ.getTechLevel() >= BuildingsManager.getSupply_TechLevel(1) && civ.getNumOfProvs() > civ.numOf_SuppliesCamp) {
                options.add(new AI_Build_Option_Supplies());
            }
            if (civ.getTechLevel() >= BuildingsManager.getFort_TechLevel(1) && civ.getNumOfProvs() * BuildingsManager.getFort_MaxLevel_CanBuild(nCivID) > civ.numOf_Forts) {
                options.add(new AI_Build_Option_Fort());
            }
            if (civ.getTechLevel() >= BuildingsManager.getTower_TechLevel(1) && civ.getNumOfProvs() * BuildingsManager.getTower_MaxLevel_CanBuild(nCivID) > civ.numOf_Towers) {
                options.add(new AI_Build_Option_Tower());
            }
            if (options.isEmpty()) return;
            int best = 0;
            for (int i = 1; i < options.size(); ++i) {
                if (options.get(i).getScore(nCivID) > options.get(best).getScore(nCivID)) {
                    best = i;
                }
            }
            AI_Build build = options.get(best).getData(nCivID);
            if (build.build(nCivID, 0, false)) {
                civ.buildCivPersonality_Buildings();
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        options.clear();
    }

    private void sandboxForcedForeignSpend(int nCivID) {
        Civilization civ = CFG.core.getCiv(nCivID);
        if (civ.getGold() <= 0L) return;
        if (civ.civGD.sandboxForeignInvestSpend > 0 && civ.getMovemPoints() >= GameValues.gvInvestForeign.INVEST_ECO_COST_MOVEMENT_POINTS) {
            int provinceID = this.sandboxBestForeignProvince(nCivID);
            if (provinceID >= 0) {
                long spend = Math.min((long)civ.civGD.sandboxForeignInvestSpend, Math.min(civ.getGold(), (long)GameManager.invest_MaxEconomy_Gold(provinceID, nCivID)));
                if (spend > 0L) {
                    GameManager.investForeignEconomy(nCivID, provinceID, spend);
                }
            }
        }
        if (civ.civGD.sandboxForeignBuildSpend > 0 && civ.getGold() > 0L) {
            this.sandboxForcedForeignBuild(nCivID, Math.min((long)civ.civGD.sandboxForeignBuildSpend, civ.getGold()));
        }
    }

    private int sandboxBestForeignProvince(int nCivID) {
        int bestProvinceID = -1;
        float bestScore = -1.0f;
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            Province province = CFG.core.getProv(i);
            if (province.getCivId() <= 0 || province.getCivId() == nCivID || province.getSeaProv() || province.getWastelandLvl() >= 0) continue;
            if (CFG.core.getCiv(nCivID).areSanctionsAdded(nCivID, province.getCivId()) || CFG.core.getCiv(province.getCivId()).areSanctionsAdded(province.getCivId(), nCivID)) continue;
            float score = GameManager.investForeignEconomy_ReturnRate(nCivID, i) + GameManager.buildForeignEconomy_ReturnRate(nCivID, i) + (float)province.getEco() / 100000.0f;
            if (score <= bestScore) continue;
            bestScore = score;
            bestProvinceID = i;
        }
        return bestProvinceID;
    }

    private void sandboxForcedForeignBuild(int nCivID, long maxSpend) {
        if (maxSpend <= 0L) return;
        int bestProvinceID = -1;
        int bestBuildID = -1;
        int bestCost = 0;
        float bestScore = -1.0f;
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            Province province = CFG.core.getProv(i);
            if (province.getCivId() <= 0 || province.getCivId() == nCivID || province.getSeaProv() || province.getWastelandLvl() >= 0) continue;
            if (CFG.core.getCiv(nCivID).areSanctionsAdded(nCivID, province.getCivId()) || CFG.core.getCiv(province.getCivId()).areSanctionsAdded(province.getCivId(), nCivID)) continue;
            for (int buildID = 0; buildID <= 8; ++buildID) {
                int cost = this.sandboxForeignBuildCost(i, buildID);
                if (cost <= 0 || (long)cost > maxSpend || (long)cost > CFG.core.getCiv(nCivID).getGold()) continue;
                float score = GameManager.buildForeignEconomy_ReturnRate(nCivID, i) + (float)cost / 1000000.0f;
                if (score <= bestScore) continue;
                bestScore = score;
                bestProvinceID = i;
                bestBuildID = buildID;
                bestCost = cost;
            }
        }
        if (bestProvinceID >= 0 && bestBuildID >= 0 && bestCost > 0) {
            ArrayList<Boolean> build = new ArrayList<Boolean>();
            for (int i = 0; i < 20; ++i) {
                build.add(false);
            }
            build.set(bestBuildID, true);
            GameManager.buildForeignProvince(nCivID, bestProvinceID, build, bestCost);
        }
    }

    private int sandboxForeignBuildCost(int provinceID, int buildID) {
        Province province = CFG.core.getProv(provinceID);
        switch (buildID) {
            case 0: {
                if (province.getLvlOfFort() >= BuildingsManager.getFort_MaxLevel()) return 0;
                return BuildingsManager.getFort_BuildCost(province.getLvlOfFort() + 1, provinceID);
            }
            case 1: {
                if (province.getLvlOfWatchTower() >= BuildingsManager.getTower_MaxLevel()) return 0;
                return BuildingsManager.getTower_BuildCost(province.getLvlOfWatchTower() + 1, provinceID);
            }
            case 2: {
                if (province.getLvlOfPort() >= BuildingsManager.getPort_MaxLevel() || province.getNeighSeaProvincesSize() <= 0) return 0;
                return BuildingsManager.getPort_BuildCost(province.getLvlOfPort() + 1, provinceID);
            }
            case 3: {
                if (province.getLvlOfFarm() >= BuildingsManager.getFarm_MaxLevel()) return 0;
                return BuildingsManager.getFarm_BuildCost(province.getLvlOfFarm() + 1, provinceID);
            }
            case 4: {
                if (province.getLvlOfWorkshop() >= BuildingsManager.getWorkshop_MaxLevel()) return 0;
                return BuildingsManager.getWorkshop_BuildCost(province.getLvlOfWorkshop() + 1, provinceID);
            }
            case 5: {
                if (province.getLvlOfMarket() >= BuildingsManager.getMarket_MaxLevel()) return 0;
                return BuildingsManager.getMarket_BuildCost(province.getLvlOfMarket() + 1, provinceID);
            }
            case 6: {
                if (province.getLvlOfLibrary() >= BuildingsManager.getLibrary_MaxLevel()) return 0;
                return BuildingsManager.getLibrary_BuildCost(province.getLvlOfLibrary() + 1, provinceID);
            }
            case 7: {
                if (province.getLvlOfArmoury() >= BuildingsManager.getArmoury_MaxLevel()) return 0;
                return BuildingsManager.getArmoury_BuildCost(province.getLvlOfArmoury() + 1, provinceID);
            }
            case 8: {
                if (province.getLvlOfSupply() >= BuildingsManager.getSupply_MaxLevel()) return 0;
                return BuildingsManager.getSupply_BuildCost(province.getLvlOfSupply() + 1, provinceID);
            }
        }
        return 0;
    }

    public final void turnOrdersEssential(int nCivID) {
        this.respondToEvents(nCivID);
        this.updateSentMessages(nCivID);
        this.respondToMessages(nCivID);
        this.diplomacyActions(nCivID);
        this.manageBudget(nCivID);
        this.applySandboxSpendings(nCivID);
    }

    public final void turnOrdersEssential_respondToEvents(int nCivID) {
        this.respondToEvents(nCivID);
    }

    public final void turnOrdersEssential_updateSentMessages(int nCivID) {
        this.updateSentMessages(nCivID);
    }

    public final void turnOrdersEssential_respondToMessages(int nCivID) {
        this.respondToMessages(nCivID);
    }

    public final void turnOrdersEssential_diplomacyActions(int nCivID) {
        this.diplomacyActions(nCivID);
    }

    public final void turnOrdersEssential_diplomacyActions_diplomacyActions_BuildCivsInRange(int nCivID) {
        this.diplomacyActions_diplomacyActions_BuildCivsInRange(nCivID);
    }

    public final void turnOrdersEssential_diplomacyActions_diplomacyActions_RivalCiv(int nCivID) {
        this.diplomacyActions_diplomacyActions_RivalCiv(nCivID);
    }

    public final void turnOrdersEssential_diplomacyActions_diplomacyActions_FindFriendlyCivs(int nCivID) {
        this.diplomacyActions_diplomacyActions_FindFriendlyCivs(nCivID);
    }

    public final void turnOrdersEssential_diplomacyActions_diplomacyActions_DeclareWar(int nCivID) {
        this.diplomacyActions_diplomacyActions_DeclareWar(nCivID);
    }

    public final void turnOrdersEssential_diplomacyActions_diplomacyActions_Ally(int nCivID) {
        this.diplomacyActions_diplomacyActions_Ally(nCivID);
    }

    public final void turnOrdersEssential_manageBudget(int nCivID) {
        this.manageBudget(nCivID);
        this.applySandboxSpendings(nCivID);
    }

    public final void turnOrdersEssential_2(int nCivID) {
        this.updateLibertyDesire(nCivID);
    }

    public void diplomacyActions(int nCivID) {
        this.diplomacyActions_BuildCivsInRange(nCivID);
        if (!CFG.core.getCiv(nCivID).isAtWarC() && !CFG.core.getCiv((int)nCivID).civGD.civPlans.isPreparingForTheWar()) {
            if (GameValues.gvAiRivals.USE_NEW_RIVALS_SYSTEM) {
                this.diplomacyActions_RivalCiv_New(nCivID);
            } else {
                this.diplomacyActions_RivalCiv(nCivID);
            }
            this.diplomacyActions_FormCiv(nCivID);
            this.diplomacyActions_SurroundedVassals(nCivID);
        }
        this.diplomacyActions_FindFriendlyCivs(nCivID);
        if (!CFG.core.getCiv(nCivID).isAtWarC() && !CFG.core.getCiv((int)nCivID).civGD.civPlans.isPreparingForTheWar()) {
            if (CFG.USE_NEW_DECLARE_WAR_SYSTEM && (CFG.USE_OLD_DECLARE_WAR_CHANGE_100 == 0 || CFG.oR.nextInt(100) >= CFG.USE_OLD_DECLARE_WAR_CHANGE_100)) {
                this.diplomacyActions_DeclareWar(nCivID);
            } else {
                this.diplomacyActions_DeclareWar_Old(nCivID);
            }
        }
        this.diplomacyActions_Ally(nCivID);
    }

    public void diplomacyActions_diplomacyActions_BuildCivsInRange(int nCivID) {
        this.diplomacyActions_BuildCivsInRange(nCivID);
    }

    public void diplomacyActions_diplomacyActions_RivalCiv(int nCivID) {
        if (!CFG.core.getCiv(nCivID).isAtWarC() && !CFG.core.getCiv((int)nCivID).civGD.civPlans.isPreparingForTheWar()) {
            if (GameValues.gvAiRivals.USE_NEW_RIVALS_SYSTEM) {
                this.diplomacyActions_RivalCiv_New(nCivID);
            } else {
                this.diplomacyActions_RivalCiv(nCivID);
            }
            this.diplomacyActions_FormCiv(nCivID);
            this.diplomacyActions_SurroundedVassals(nCivID);
        }
    }

    public void diplomacyActions_diplomacyActions_FindFriendlyCivs(int nCivID) {
        this.diplomacyActions_FindFriendlyCivs(nCivID);
    }

    public void diplomacyActions_diplomacyActions_DeclareWar(int nCivID) {
        if (!CFG.core.getCiv(nCivID).isAtWarC() && !CFG.core.getCiv((int)nCivID).civGD.civPlans.isPreparingForTheWar()) {
            if (CFG.USE_NEW_DECLARE_WAR_SYSTEM && (CFG.USE_OLD_DECLARE_WAR_CHANGE_100 == 0 || CFG.oR.nextInt(100) >= CFG.USE_OLD_DECLARE_WAR_CHANGE_100)) {
                this.diplomacyActions_DeclareWar(nCivID);
            } else {
                this.diplomacyActions_DeclareWar_Old(nCivID);
            }
        }
    }

    public void diplomacyActions_diplomacyActions_Ally(int nCivID) {
        this.diplomacyActions_Ally(nCivID);
    }

    public final void diplomacyActions_FormCiv(int nCivID) {
        if (!GameValues.gvAiFormCiv.AI_FORM_CIV_ENABLED) return;
        if (GameCalendar.TURNID >= CFG.core.getCiv((int)nCivID).civGD.checkFormCiv_TurnID) {
            if (CFG.core.getCiv(nCivID).getTagsCanFormCSize() > 0) {
                for (int i = 0; i < CFG.core.getCiv(nCivID).getTagsCanFormCSize(); ++i) {
                    if (!CFG.canFormACiv(nCivID, CFG.core.getCiv(nCivID).getTagsCanFormC(i), true)) continue;
                    CFG.loadFormableCiv_GameData(CFG.core.getCiv(nCivID).getTagsCanFormC(i));
                    CFG.formCiv(nCivID);
                    CFG.core.getCiv((int)nCivID).civGD.checkFormCiv_TurnID = GameCalendar.TURNID + GameValues.gvAiFormCiv.NEXT_FORM_CIV_CHECK_TURN_ID_AFTER_FORMING + CFG.oR.nextInt(GameValues.gvAiFormCiv.NEXT_FORM_CIV_CHECK_TURN_ID_RANDOM_AFTER_FORMING);
                    return;
                }
                CFG.core.getCiv((int)nCivID).civGD.checkFormCiv_TurnID = GameCalendar.TURNID + GameValues.gvAiFormCiv.NEXT_FORM_CIV_CHECK_TURN_ID + CFG.oR.nextInt(GameValues.gvAiFormCiv.NEXT_FORM_CIV_CHECK_TURN_ID_RANDOM);
            } else {
                CFG.core.getCiv((int)nCivID).civGD.checkFormCiv_TurnID = GameCalendar.TURNID + GameValues.gvAiFormCiv.NEXT_FORM_CIV_CHECK_TURN_ID_NONE_TO_FORM + CFG.oR.nextInt(GameValues.gvAiFormCiv.NEXT_FORM_CIV_CHECK_TURN_ID_RANDOM_NONE_TO_FORM);
            }
        }
    }

    public final void diplomacyActions_SurroundedVassals(int nCivID) {
        if (CFG.core.getCiv((int)nCivID).civGD.circledVassals_TurnID <= GameCalendar.TURNID) {
            if (CFG.core.getCiv((int)nCivID).civGD.iVassalsSize > 0) {
                try {
                    for (int z = 0; z < CFG.core.getCiv((int)nCivID).civGD.iVassalsSize; ++z) {
                        if (!CFG.core.getCiv((int)CFG.core.getCiv((int)nCivID).civGD.vassals.get((int)z).iCivID).lFrontLines.isEmpty() || CFG.core.getCiv(CFG.core.getCiv((int)nCivID).civGD.vassals.get((int)z).iCivID).getSeaAccess() > 0) continue;
                        if (CFG.core.getCivRelationOfCivB(nCivID, CFG.core.getCiv((int)nCivID).civGD.vassals.get((int)z).iCivID) > (float)GameValues.gvUltimatum.ULTIMATUM_REQUIRED_RELATIONS) {
                            int randNum = CFG.oR.nextInt(5);
                            for (int a = 0; a < 3 + randNum; ++a) {
                                GameManager.decreaseRelation(nCivID, CFG.core.getCiv((int)nCivID).civGD.vassals.get((int)z).iCivID, 10);
                            }
                        }
                        Ultimatum_GameData nUltimatum = new Ultimatum_GameData();
                        nUltimatum.demandAnexation = true;
                        GameManager.sendUltimatum(CFG.core.getCiv((int)nCivID).civGD.vassals.get((int)z).iCivID, nCivID, nUltimatum, CFG.core.getCiv(nCivID).getNumberOfUnits());
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            CFG.core.getCiv((int)nCivID).civGD.circledVassals_TurnID = GameCalendar.TURNID + GameValues.gvAiVassals.NEXT_SURROUNDED_VASSALS_CHECK_TURN_ID + CFG.oR.nextInt(GameValues.gvAiVassals.NEXT_SURROUNDED_VASSALS_CHECK_TURN_ID_RANDOM);
        }
    }

    
    public final void diplomacyActions_DeclareWar(int nCivID) {
        if (GameCalendar.AI_AGGRESSIVENESS > 0.0f) {
            Civilization civ = CFG.core.getCiv(nCivID);
            if (civ.civGD.declareWarCheckNextTurnID <= GameCalendar.TURNID) {
                if ((float)CFG.oR.nextInt(GameCalendar.MAX_AI_AGGRESSIVENESS) > civ.civGD.civPers.AI_CIV_AGGRESSION * 100.0f) {
                    CFG.core.getCiv((int)nCivID).civGD.declareWarCheckNextTurnID = GameCalendar.TURNID + (int)(((float)(GameValues.gvAiDeclareWar.BASE_WAR_CHECK_DELAY_TURNS + CFG.oR.nextInt(GameValues.gvAiDeclareWar.WAR_CHECK_DELAY_RANDOM_TURNS)) + (float)CFG.oR.nextInt(CFG.oAI.NUM_OF_CIVS_IN_THE_GAME + 1) / GameValues.gvAiDeclareWar.WAR_CHECK_CIV_COUNT_RANDOM_DIVISOR) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
                    return;
                }
                if (civ.getGold() < (long)GameValues.gvAiDeclareWar.AI_DECLARE_WAR_ONLY_IF_GOLD_OVER) {
                    CFG.core.getCiv((int)nCivID).civGD.declareWarCheckNextTurnID = GameCalendar.TURNID + GameValues.gvAiDeclareWar.BASE_WAR_CHECK_DELAY_TURNS + (int)(((float)(1 + CFG.oR.nextInt(GameValues.gvAiDeclareWar.WAR_CHECK_DELAY_RANDOM_TURNS)) + (float)CFG.oR.nextInt(CFG.oAI.NUM_OF_CIVS_IN_THE_GAME + 1) / GameValues.gvAiDeclareWar.WAR_CHECK_CIV_COUNT_RANDOM_DIVISOR_2) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
                    return;
                }
                if (civ.getStabilityCiv() < GameValues.gvAiDeclareWar.AI_DECLARE_WAR_ONLY_IF_STABILITY_OVER) {
                    CFG.core.getCiv((int)nCivID).civGD.declareWarCheckNextTurnID = GameCalendar.TURNID + GameValues.gvAiDeclareWar.BASE_WAR_CHECK_DELAY_TURNS + (int)(((float)(CFG.core.getCiv((int)nCivID).provincesWithLowStability.size() * 2 + CFG.oR.nextInt(GameValues.gvAiDeclareWar.WAR_CHECK_DELAY_RANDOM_TURNS)) + (float)CFG.oR.nextInt(CFG.oAI.NUM_OF_CIVS_IN_THE_GAME + 1) / GameValues.gvAiDeclareWar.WAR_CHECK_CIV_COUNT_RANDOM_DIVISOR_2) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
                    return;
                }
                if ((float)civ.getHappiness() < GameValues.gvAiDeclareWar.AI_DECLARE_WAR_ONLY_IF_HAPPINESS_OVER) {
                    CFG.core.getCiv((int)nCivID).civGD.declareWarCheckNextTurnID = GameCalendar.TURNID + GameValues.gvAiDeclareWar.BASE_WAR_CHECK_DELAY_TURNS + (int)(((float)(CFG.core.getCiv((int)nCivID).provincesWithLowHappiness.size() * 2 + CFG.oR.nextInt(GameValues.gvAiDeclareWar.WAR_CHECK_DELAY_RANDOM_TURNS)) + (float)CFG.oR.nextInt(CFG.oAI.NUM_OF_CIVS_IN_THE_GAME + 1) / GameValues.gvAiDeclareWar.WAR_CHECK_CIV_COUNT_RANDOM_DIVISOR_2) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
                    return;
                }
                int pID;
                if (CFG.core.getCiv(civ.getPuppetOfCiv()).getIsPlayer() && CFG.core.getCiv(civ.getPuppetOfCiv()).getNumOfProvs() > 0) {
                    pID = CFG.core.getPlayerIDbyCivID(civ.getPuppetOfCiv());
                    if (pID >= 0 && !CFG.core.getPlayer((int)pID).playerGD.VASSALS_CAN_DECLARE_WARS) {
                        CFG.core.getCiv((int)nCivID).civGD.declareWarCheckNextTurnID = GameCalendar.TURNID + GameValues.gvAiDeclareWar.BASE_WAR_CHECK_DELAY_TURNS + (int)(((float)(CFG.core.getCiv((int)nCivID).provincesWithLowHappiness.size() * 2 + CFG.oR.nextInt(GameValues.gvAiDeclareWar.WAR_CHECK_DELAY_RANDOM_TURNS)) + (float)CFG.oR.nextInt(CFG.oAI.NUM_OF_CIVS_IN_THE_GAME + 1) / GameValues.gvAiDeclareWar.WAR_CHECK_CIV_COUNT_RANDOM_DIVISOR_2) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
                        return;
                    }
                } else if (civ.getPuppetOfCiv() != nCivID && CFG.core.getCiv(civ.getPuppetOfCiv()).getNumOfProvs() > 0 && !CFG.AI_VASSALS_CAN_DECLARE_WARS) {
                    CFG.core.getCiv((int)nCivID).civGD.declareWarCheckNextTurnID = GameCalendar.TURNID + GameValues.gvAiDeclareWar.BASE_WAR_CHECK_DELAY_TURNS + (int)(((float)(CFG.core.getCiv((int)nCivID).provincesWithLowHappiness.size() * 2 + CFG.oR.nextInt(GameValues.gvAiDeclareWar.WAR_CHECK_DELAY_RANDOM_TURNS)) + (float)CFG.oR.nextInt(CFG.oAI.NUM_OF_CIVS_IN_THE_GAME + 1) / GameValues.gvAiDeclareWar.WAR_CHECK_CIV_COUNT_RANDOM_DIVISOR_2) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
                    return;
                }
                ArrayList<Integer> possibleCivs = new ArrayList<Integer>();
                int a;
                if (GameValues.gvAiDeclareWar.AI_PREPARE_FOR_WAR_PRIORITIZE_TRIBAL && CFG.oR.nextInt(100) < GameValues.gvAiDeclareWar.AI_PREPARE_FOR_WAR_PRIORITIZE_NEIGHBORS_TRIBAL_CHANCE && CFG.ideologiesMgr.getIdeologyID((int)civ.getIdeology()).CAN_BECOME_CIVILIZED < 0) {
                    for (a = 0; a < civ.civNeighbors.civsSize; ++a) {
                        if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)civ.civNeighbors.civs.get((int)a).civID).getIdeology()).CAN_BECOME_CIVILIZED < 0 || CFG.core.getCiv(civ.civNeighbors.civs.get((int)a).civID).getNumOfProvs() <= 0 || CFG.core.isAlly(nCivID, civ.civNeighbors.civs.get((int)a).civID)) continue;
                        possibleCivs.add(civ.civNeighbors.civs.get((int)a).civID);
                    }
                }
                int i;
                int bestID;
                int jSize;
                int j;
                if (possibleCivs.isEmpty() && civ.getRankPos() < GameValues.gvAiDeclareWar.AI_PREPARE_FOR_WAR_CONQUER_TRIBAL_TOP_RANK_CIVS && civ.getSeaAccess_PortProvinces_Size() > 0 && CFG.oR.nextInt(100) < GameValues.gvAiDeclareWar.AI_PREPARE_FOR_WAR_CONQUER_TRIBAL_TOP_RANK_CIVS_CHANCE) {
                    ArrayList<CivDistance> distance = new ArrayList<CivDistance>();
                    for (i = 1; i < nCivID; ++i) {
                        if (CFG.core.getCiv(i).getNumOfProvs() <= 0 || CFG.core.getCiv(i).getSeaAccess() <= 0 || CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)i).getIdeology()).CAN_BECOME_CIVILIZED < 0) continue;
                        distance.add(new CivDistance(i, Distance.getDistanceFromAToB_PercOfMax(civ.getCapitalProvID(), CFG.core.getCiv(i).getCapitalProvID())));
                    }
                    for (i = nCivID + 1; i < CFG.core.getCivsSize(); ++i) {
                        if (CFG.core.getCiv(i).getNumOfProvs() <= 0 || CFG.core.getCiv(i).getSeaAccess() <= 0 || CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)i).getIdeology()).CAN_BECOME_CIVILIZED < 0) continue;
                        distance.add(new CivDistance(i, Distance.getDistanceFromAToB_PercOfMax(civ.getCapitalProvID(), CFG.core.getCiv(i).getCapitalProvID())));
                    }
                    for (i = 0; !distance.isEmpty() && i < GameValues.gvAiDeclareWar.AI_PREPARE_FOR_WAR_CONQUER_TRIBAL_LIMIT; ++i) {
                        bestID = 0;
                        jSize = distance.size();
                        for (j = 1; j < jSize; ++j) {
                            if (!(((CivDistance)distance.get((int)bestID)).distance > ((CivDistance)distance.get((int)j)).distance)) continue;
                            bestID = j;
                        }
                        if (!CFG.core.isAlly(nCivID, ((CivDistance)distance.get((int)bestID)).civID)) {
                            possibleCivs.add(((CivDistance)distance.get((int)bestID)).civID);
                        } else {
                            --i;
                        }
                        distance.remove(bestID);
                    }
                }
                if (possibleCivs.isEmpty() && CFG.AI_CONQUER_VASSALS) {
                    boolean conquerVassal = false;
                    if (civ.civGD.iVassalsSize > 0 && civ.civGD.iVassalsSize > CFG.AI_CONQUER_OWN_VASSALS_IF_OVER && CFG.oR.nextInt(100) < GameValues.gvAiDeclareWar.AI_CONQUER_OWN_VASSALS_CHANCE) {
                        for (i = 0; i < civ.civNeighbors.civsSize; ++i) {
                            if (CFG.core.getCiv(civ.civNeighbors.civs.get((int)i).civID).getPuppetOfCiv() != nCivID || CFG.core.isAlly(nCivID, civ.civNeighbors.civs.get((int)i).civID)) continue;
                            possibleCivs.add(civ.civNeighbors.civs.get((int)i).civID);
                            conquerVassal = true;
                        }
                    }
                    if (!conquerVassal) {
                        for (i = 0; i < civ.civNeighbors.civsSize; ++i) {
                            if (CFG.core.getCiv(civ.civNeighbors.civs.get((int)i).civID).getPuppetOfCiv() == nCivID) {
                                if (CFG.oR.nextInt(100) < GameValues.gvAiDeclareWar.AI_PREPARE_FOR_WAR_AGAINST_OWN_VASSAL_CHANCE && !CFG.core.isAlly(nCivID, civ.civNeighbors.civs.get((int)i).civID)) {
                                    possibleCivs.add(civ.civNeighbors.civs.get((int)i).civID);
                                    continue;
                                }
                                for (j = 0; j < CFG.core.getCiv((int)civ.civNeighbors.civs.get((int)i).civID).civNeighbors.civsSize; ++j) {
                                    if (CFG.core.getCiv((int)civ.civNeighbors.civs.get((int)i).civID).civNeighbors.civs.get((int)j).civID == nCivID || CFG.core.isAlly(nCivID, CFG.core.getCiv((int)civ.civNeighbors.civs.get((int)i).civID).civNeighbors.civs.get((int)j).civID) || possibleCivs.contains(CFG.core.getCiv((int)civ.civNeighbors.civs.get((int)i).civID).civNeighbors.civs.get((int)j).civID)) continue;
                                    possibleCivs.add(CFG.core.getCiv((int)civ.civNeighbors.civs.get((int)i).civID).civNeighbors.civs.get((int)j).civID);
                                }
                                continue;
                            }
                            if (CFG.core.isAlly(nCivID, civ.civNeighbors.civs.get((int)i).civID) || possibleCivs.contains(civ.civNeighbors.civs.get((int)i).civID)) continue;
                            possibleCivs.add(civ.civNeighbors.civs.get((int)i).civID);
                        }
                    }
                }
                if (possibleCivs.isEmpty() && CFG.oR.nextInt(100) < GameValues.gvAiDeclareWar.AI_PREPARE_FOR_WAR_CLOSEST_CIV_CHANCE) {
                    ArrayList<CivDistance> distance = new ArrayList<CivDistance>();
                    for (i = 1; i < nCivID; ++i) {
                        if (CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
                        distance.add(new CivDistance(i, Distance.getDistanceFromAToB_PercOfMax(civ.getCapitalProvID(), CFG.core.getCiv(i).getCapitalProvID())));
                    }
                    for (i = nCivID + 1; i < CFG.core.getCivsSize(); ++i) {
                        if (CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
                        distance.add(new CivDistance(i, Distance.getDistanceFromAToB_PercOfMax(civ.getCapitalProvID(), CFG.core.getCiv(i).getCapitalProvID())));
                    }
                    for (i = 0; !distance.isEmpty() && i < GameValues.gvAiDeclareWar.AI_PREPARE_FOR_WAR_CLOSEST_CIV_CIVS_LIMIT; ++i) {
                        bestID = 0;
                        jSize = distance.size();
                        for (j = 1; j < jSize; ++j) {
                            if (!(((CivDistance)distance.get((int)bestID)).distance > ((CivDistance)distance.get((int)j)).distance)) continue;
                            bestID = j;
                        }
                        if (!CFG.core.isAlly(nCivID, ((CivDistance)distance.get((int)bestID)).civID)) {
                            possibleCivs.add(((CivDistance)distance.get((int)bestID)).civID);
                        } else {
                            --i;
                        }
                        distance.remove(bestID);
                    }
                }
                if (!possibleCivs.isEmpty()) {
                    for (int var5_5 = 0; var5_5 < GameValues.gvAiDeclareWar.AI_PREPARE_FOR_WAR_CHECK_LIMIT && !possibleCivs.isEmpty() && !civ.isAtWarC(); ++var5_5) {
                        bestID = 0;
                        int randomWeight = CFG.oR.nextInt(GameValues.gvAiDeclareWar.AI_PREPARE_FOR_WAR_CHOOSE_WEAKEST_RANDOM_NUMBER);
                        if (randomWeight < GameValues.gvAiDeclareWar.AI_PREPARE_FOR_WAR_CHOOSE_WEAKEST_CLOSEST_CIV_ALL_PROVINCES_CHANCE) {
                            ArrayList<Float> distanceWeights = new ArrayList<Float>();
                            for (j = 0; j < possibleCivs.size(); ++j) {
                                float avgDistance = 0.0f;
                                Civilization targetCiv = CFG.core.getCiv(possibleCivs.get(j));
                            for (int k = 0; k < targetCiv.getNumOfProvs(); ++k) {
                                    avgDistance += Distance.getDistanceFromAToB_PercOfMax(civ.getCapitalProvID(), targetCiv.getProvID(k));
                                }
                                distanceWeights.add(avgDistance / (float)targetCiv.getNumOfProvs());
                            }
                            bestID = 0;
                            for (j = 1; j < possibleCivs.size(); ++j) {
                                if (distanceWeights.get(bestID) > distanceWeights.get(j)) {
                                    bestID = j;
                                }
                            }
                        } else if (randomWeight < GameValues.gvAiDeclareWar.AI_PREPARE_FOR_WAR_CHOOSE_WEAKEST_CLOSEST_CIV_CAPITAL_CHANCE) {
                            float bestDist = Distance.getDistanceFromAToB_PercOfMax(civ.getCapitalProvID(), CFG.core.getCiv(possibleCivs.get(bestID)).getCapitalProvID());
                            for (j = 1; j < possibleCivs.size(); ++j) {
                                float currentDist = Distance.getDistanceFromAToB_PercOfMax(civ.getCapitalProvID(), CFG.core.getCiv(possibleCivs.get(j)).getCapitalProvID());
                                if (bestDist > currentDist) {
                                    bestDist = currentDist;
                                    bestID = j;
                                }
                            }
                        } else if (randomWeight < GameValues.gvAiDeclareWar.AI_PREPARE_FOR_WAR_CHOOSE_WEAKEST_CIV_PROVINCES_CHANCE) {
                            for (j = 1; j < possibleCivs.size(); ++j) {
                                if (CFG.core.getCiv(possibleCivs.get(bestID)).getNumOfProvs() + CFG.core.getCiv(CFG.core.getCiv(possibleCivs.get(bestID)).getPuppetOfCiv()).getNumOfProvs() <= CFG.core.getCiv(CFG.core.getCiv(possibleCivs.get(j)).getPuppetOfCiv()).getNumOfProvs() + CFG.core.getCiv(possibleCivs.get(j)).getNumOfProvs()) continue;
                                bestID = j;
                            }
                        } else if (randomWeight < GameValues.gvAiDeclareWar.AI_PREPARE_FOR_WAR_CHOOSE_WEAKEST_CIV_ARMY_MAX_CHANCE) {
                            for (j = 1; j < possibleCivs.size(); ++j) {
                                if (CFG.core.getCiv(possibleCivs.get(bestID)).getNumberOfUnits() + CFG.core.getCiv(CFG.core.getCiv(possibleCivs.get(bestID)).getPuppetOfCiv()).getNumberOfUnits() <= CFG.core.getCiv(CFG.core.getCiv(possibleCivs.get(j)).getPuppetOfCiv()).getNumberOfUnits() + CFG.core.getCiv(possibleCivs.get(j)).getNumberOfUnits()) continue;
                                bestID = j;
                            }
                        } else {
                            bestID = CFG.oR.nextInt(possibleCivs.size());
                        }

                        int targetCivID = possibleCivs.get(bestID);
                        if ((CFG.core.getCiv(targetCivID).getIsPlayer() && civ.getRelationD(targetCivID) > GameValues.gvAiDeclareWar.AI_MAX_RELATION_TO_DECLARE_WAR_WITH_PLAYER) || civ.getRelationD(targetCivID) > GameValues.gvAiDeclareWar.AI_MAX_RELATION_TO_DECLARE_WAR) {
                            int decreaseCount = CFG.oR.nextInt(4);
                            for (int d = 0; d < 2 + decreaseCount; ++d) {
                                GameManager.decreaseRelation(nCivID, targetCivID, 10);
                            }
                            possibleCivs.remove(bestID);
                            continue;
                        }
                        if (civ.isFriendlyCiv(targetCivID) >= 0) {
                            possibleCivs.remove(bestID);
                            continue;
                        }
                        if (CFG.core.isAlly(nCivID, targetCivID)) {
                            possibleCivs.remove(bestID);
                            continue;
                        }
                        if (CFG.core.getGuarantee(nCivID, targetCivID) > 0 || CFG.core.getGuarantee(targetCivID, nCivID) > 0) {
                            possibleCivs.remove(bestID);
                            continue;
                        }
                        if (CFG.core.getCivNonAggressionPact(nCivID, targetCivID) > 0) {
                            possibleCivs.remove(bestID);
                            continue;
                        }
                        if (CFG.core.getCivTruce(nCivID, targetCivID) > 0) {
                            possibleCivs.remove(bestID);
                            continue;
                        }
                        if (CFG.core.getCivNonAggressionPact(nCivID, targetCivID) > 0) {
                            int decreaseCount = CFG.oR.nextInt(2);
                            for (int d = 0; d < 1 + decreaseCount; ++d) {
                                GameManager.decreaseRelation(nCivID, targetCivID, 10);
                            }
                            possibleCivs.remove(bestID);
                            continue;
                        }
                        if (!AIPlaystyle.checkArmy_ForWar(nCivID, targetCivID)) {
                            possibleCivs.remove(bestID);
                            continue;
                        }
                        long civBudget = this.diplomacyActions_DeclareWar_Budgets(nCivID, false);
                        long targetBudget = this.diplomacyActions_DeclareWar_Budgets(targetCivID, true);
                        if ((float)civBudget > (float)targetBudget * GameValues.gvAiDeclareWar.WAR_PREPARATION_MIN_BUDGET_RATIO) {
                            int preparationTurns = GameValues.gvAiDeclareWar.WAR_PREPARATION_MIN_TURNS + CFG.oR.nextInt(GameValues.gvAiDeclareWar.WAR_PREPARATION_RANDOM_TURNS);
                            civ.civGD.civPlans.addNewWarPreps(nCivID, nCivID, targetCivID, preparationTurns);
                            List<Integer> alliesToCall = GameManager.callToArmsListOfCivs(nCivID, targetCivID);
                            for (int a_ = 0; a_ < alliesToCall.size(); ++a_) {
                                GameManager.sendPrepareForWar(alliesToCall.get(a_), nCivID, targetCivID, preparationTurns, nCivID);
                            }
                        } else {
                            ArrayList<Integer> coalitionCivs = new ArrayList<Integer>();
                            Civilization targetCivObj = CFG.core.getCiv(targetCivID);
                            for (int h = 0; h < targetCivObj.getHatedCivs_BySize(); ++h) {
                                int hatedID = targetCivObj.getHatedCiv_By(h);
                                if (civ.isHatedCiv(hatedID) || CFG.core.getCiv(hatedID).getNumOfProvs() <= 0) continue;
                                coalitionCivs.add(hatedID);
                            }
                            for (int c = 0; c < coalitionCivs.size(); ++c) {
                                civBudget += this.diplomacyActions_DeclareWar_Budgets(coalitionCivs.get(c), false);
                            }
                            if ((float)civBudget > (float)targetBudget * GameValues.gvAiDeclareWar.TRADE_RQ_COALITION_MIN_BUDGET_RATIO) {
                                for (int c = 0; c < coalitionCivs.size(); ++c) {
                                    int coalitionPartnerID = coalitionCivs.get(c);
                                    if (coalitionPartnerID == targetCivID) continue;
                                    TradeRequest_GameData trData = new TradeRequest_GameData();
                                    trData.iCivLEFT = nCivID;
                                    trData.iCivRIGHT = coalitionPartnerID;
                                    trData.listRight.lFormCoalitionAgainst.add(targetCivID);
                                    trData.listLEFT.iGold = (long)(GameValues.gvAiDeclareWar.TRADE_RQ_COALITION_BRIBE_GOLD_MIN + CFG.oR.nextInt(GameValues.gvAiDeclareWar.TRADE_RQ_COALITION_BRIBE_GOLD_RANDOM)) + (long)Math.max(0.0f, Math.min((float)civ.getGold(), (float)CFG.core.getCiv(coalitionPartnerID).getNumberOfUnits() * (GameValues.gvAiDeclareWar.TRADE_RQ_COALITION_BRIBE_GOLD_PERC_OF_ARMY_MIN + (float)CFG.oR.nextInt(GameValues.gvAiDeclareWar.TRADE_RQ_COALITION_BRIBE_GOLD_PERC_OF_ARMY_RANDOM_100) / 100.0f)));
                                    GameManager.sendTradeRequest(coalitionPartnerID, nCivID, trData);
                                }
                                int preparationTurns = GameValues.gvAiDeclareWar.WAR_PREPARATION_MIN_TURNS + CFG.oR.nextInt(GameValues.gvAiDeclareWar.WAR_PREPARATION_RANDOM_TURNS);
                                civ.civGD.civPlans.addNewWarPreps(nCivID, nCivID, targetCivID, preparationTurns);
                                List<Integer> alliesToCall = GameManager.callToArmsListOfCivs(nCivID, targetCivID);
                                for (int a_ = 0; a_ < alliesToCall.size(); ++a_) {
                                    GameManager.sendPrepareForWar(alliesToCall.get(a_), nCivID, targetCivID, preparationTurns, nCivID);
                                }
                            } else {
                                GameManager.sendNonAggressionProposal(targetCivID, nCivID, GameValues.gvDipNonAggression.DIPLOMACY_MAX_NUMBER_OF_TURNS_NON_AGGRESSION_PACT);
                            }
                        }
                        if (civ.civGD.civPlans.iWarPrepsSize >= GameValues.gvAiDeclareWar.AI_PREPARE_FOR_WAR_CIVS_LIMIT) break;
                }
                civ.civGD.declareWarCheckNextTurnID = GameCalendar.TURNID + GameValues.gvAiDeclareWar.BASE_WAR_CHECK_DELAY_TURNS + (int)(((float)CFG.oR.nextInt(GameValues.gvAiDeclareWar.WAR_CHECK_DELAY_RANDOM_TURNS_AFTER_PREPARATION) + (float)CFG.oR.nextInt(CFG.oAI.NUM_OF_CIVS_IN_THE_GAME + 1) / GameValues.gvAiDeclareWar.WAR_CHECK_CIV_COUNT_RANDOM_DIVISOR_2) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
                possibleCivs.clear();
            }
        } else {
            CFG.core.getCiv((int)nCivID).civGD.declareWarCheckNextTurnID = GameCalendar.TURNID + GameValues.gvAiDeclareWar.BASE_WAR_CHECK_DELAY_TURNS + (int)(((float)CFG.oR.nextInt(GameValues.gvAiDeclareWar.WAR_CHECK_DELAY_RANDOM_TURNS) + (float)CFG.oR.nextInt(CFG.oAI.NUM_OF_CIVS_IN_THE_GAME + 1) / GameValues.gvAiDeclareWar.WAR_CHECK_CIV_COUNT_RANDOM_DIVISOR) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
        }
    }
}

    public static final boolean checkArmy_ForWar(int n, int n2) {
        int n3;
        List<Integer> list = AIPlaystyle.declareWar_AlliesAttacker(n, n2);
        List<Integer> list2 = AIPlaystyle.declareWar_AlliesDefender(n2, n);
        int n4 = 0;
        int n5 = 0;
        try {
            for (n3 = list.size() - 1; n3 >= 0; --n3) {
                n4 += CFG.core.getCiv(list.get(n3)).getNumberOfUnits();
            }
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
        try {
            for (n3 = list2.size() - 1; n3 >= 0; --n3) {
                n5 += CFG.core.getCiv(list2.get(n3)).getNumberOfUnits();
            }
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
        n4 = (int)((float)n4 * GameValues.gvAiDeclareWar.AI_DECLARE_WAR_ALLIES_ARMY_MODIFIER);
        n5 = (int)((float)n5 * GameValues.gvAiDeclareWar.AI_DECLARE_WAR_ALLIES_ARMY_MODIFIER_DEFENDERS);
        list.clear();
        list2.clear();
        return (n4 += CFG.core.getCiv(n).getNumberOfUnits()) >= (n5 += (int)Math.max(0.0f, (float)CFG.core.getCiv(n2).getNumberOfUnits() * GameValues.gvAiDeclareWar.AI_DECLARE_WAR_DEFENDER_ARMY_MODIFIER));
    }

    public static final List<Integer> declareWar_AlliesAttacker(int n, int n2) {
        int n3;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (CFG.core.getCiv(n).getAlliance() > 0) {
            for (n3 = 0; n3 < CFG.core.getAlliance(CFG.core.getCiv(n).getAlliance()).getCivilizationsSize(); ++n3) {
                if (n == CFG.core.getAlliance(CFG.core.getCiv(n).getAlliance()).getCivilization(n3) || n == CFG.core.getCiv(CFG.core.getAlliance(CFG.core.getCiv(n).getAlliance()).getCivilization(n3)).getPuppetOfCiv() || CFG.core.getCiv(n).getPuppetOfCiv() == CFG.core.getAlliance(CFG.core.getCiv(n).getAlliance()).getCivilization(n3) || arrayList.contains(CFG.core.getAlliance(CFG.core.getCiv(n).getAlliance()).getCivilization(n3))) continue;
                arrayList.add(CFG.core.getAlliance(CFG.core.getCiv(n).getAlliance()).getCivilization(n3));
            }
        }
        for (n3 = 0; n3 < CFG.core.getCiv((int)n).civGD.iVassalsSize; ++n3) {
            if (CFG.core.getCiv((int)n).civGD.vassals.get((int)n3).iCivID == n || CFG.core.getCiv((int)n).civGD.vassals.get((int)n3).iCivID == n2 || arrayList.contains(CFG.core.getCiv((int)n).civGD.vassals.get((int)n3).iCivID)) continue;
            arrayList.add(CFG.core.getCiv((int)n).civGD.vassals.get((int)n3).iCivID);
        }
        for (n3 = arrayList.size() - 1; n3 >= 0; --n3) {
            if (arrayList.get(n3) < 1 || CFG.core.getCiv(arrayList.get(n3)).getNumOfProvs() <= 0) {
                arrayList.remove(n3);
                continue;
            }
            if (arrayList.get(n3) != n && arrayList.get(n3) != n2) continue;
            arrayList.remove(n3);
        }
        return arrayList;
    }

    public static final List<Integer> declareWar_AlliesDefender(int n, int n2) {
        int n3;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Civilization civilization = CFG.core.getCiv(n);
        if (civilization.getAlliance() > 0) {
            for (n3 = 0; n3 < CFG.core.getAlliance(civilization.getAlliance()).getCivilizationsSize(); ++n3) {
                if (n == CFG.core.getAlliance(civilization.getAlliance()).getCivilization(n3) || arrayList.contains(CFG.core.getAlliance(civilization.getAlliance()).getCivilization(n3))) continue;
                arrayList.add(CFG.core.getAlliance(civilization.getAlliance()).getCivilization(n3));
            }
        }
        for (n3 = 1; n3 < n; ++n3) {
            if (CFG.core.getDefensivePact(n, n3) > 0) {
                if (CFG.core.getCiv(n3).getNumOfProvs() <= 0 || arrayList.contains(n3)) continue;
                arrayList.add(n3);
                continue;
            }
            if (CFG.core.getGuarantee(n3, n) <= 0 || CFG.core.getCiv(n3).getNumOfProvs() <= 0 || arrayList.contains(n3)) continue;
            arrayList.add(n3);
        }
        for (n3 = n; n3 < CFG.core.getCivsSize(); ++n3) {
            if (CFG.core.getDefensivePact(n, n3) > 0) {
                if (CFG.core.getCiv(n3).getNumOfProvs() <= 0 || arrayList.contains(n3)) continue;
                arrayList.add(n3);
                continue;
            }
            if (CFG.core.getGuarantee(n, n3) <= 0 || CFG.core.getCiv(n3).getNumOfProvs() <= 0 || arrayList.contains(n3)) continue;
            arrayList.add(n3);
        }
        for (n3 = 0; n3 < civilization.civGD.iVassalsSize; ++n3) {
            if (civilization.civGD.vassals.get((int)n3).iCivID == n || civilization.civGD.vassals.get((int)n3).iCivID == n2 || arrayList.contains(civilization.civGD.vassals.get((int)n3).iCivID)) continue;
            arrayList.add(civilization.civGD.vassals.get((int)n3).iCivID);
        }
        if (civilization.getPuppetOfCiv() != n && CFG.core.getCiv(n2).getPuppetOfCiv() != civilization.getPuppetOfCiv() && !arrayList.contains(civilization.getPuppetOfCiv())) {
            arrayList.add(civilization.getPuppetOfCiv());
        }
        for (n3 = arrayList.size() - 1; n3 >= 0; --n3) {
            if (arrayList.get(n3) < 1 || CFG.core.getCiv(arrayList.get(n3)).getNumOfProvs() <= 0) {
                arrayList.remove(n3);
                continue;
            }
            if (arrayList.get(n3) != n2 && arrayList.get(n3) != n) continue;
            arrayList.remove(n3);
        }
        return arrayList;
    }

    public static final List<Integer> declareWar_AlliesDefender2(int n) {
        int n2;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Civilization civilization = CFG.core.getCiv(n);
        if (civilization.getAlliance() > 0) {
            for (n2 = 0; n2 < CFG.core.getAlliance(civilization.getAlliance()).getCivilizationsSize(); ++n2) {
                if (n == CFG.core.getAlliance(civilization.getAlliance()).getCivilization(n2) || arrayList.contains(CFG.core.getAlliance(civilization.getAlliance()).getCivilization(n2))) continue;
                arrayList.add(CFG.core.getAlliance(civilization.getAlliance()).getCivilization(n2));
            }
        }
        for (n2 = 1; n2 < n; ++n2) {
            if (CFG.core.getDefensivePact(n, n2) > 0) {
                if (CFG.core.getCiv(n2).getNumOfProvs() <= 0 || arrayList.contains(n2)) continue;
                arrayList.add(n2);
                continue;
            }
            if (CFG.core.getGuarantee(n2, n) <= 0 || CFG.core.getCiv(n2).getNumOfProvs() <= 0 || arrayList.contains(n2)) continue;
            arrayList.add(n2);
        }
        for (n2 = n; n2 < CFG.core.getCivsSize(); ++n2) {
            if (CFG.core.getDefensivePact(n, n2) > 0) {
                if (CFG.core.getCiv(n2).getNumOfProvs() <= 0 || arrayList.contains(n2)) continue;
                arrayList.add(n2);
                continue;
            }
            if (CFG.core.getGuarantee(n, n2) <= 0 || CFG.core.getCiv(n2).getNumOfProvs() <= 0 || arrayList.contains(n2)) continue;
            arrayList.add(n2);
        }
        for (n2 = 0; n2 < civilization.civGD.iVassalsSize; ++n2) {
            if (civilization.civGD.vassals.get((int)n2).iCivID == n || arrayList.contains(civilization.civGD.vassals.get((int)n2).iCivID)) continue;
            arrayList.add(civilization.civGD.vassals.get((int)n2).iCivID);
        }
        for (n2 = arrayList.size() - 1; n2 >= 0; --n2) {
            if (arrayList.get(n2) < 1 || CFG.core.getCiv(arrayList.get(n2)).getNumOfProvs() <= 0) {
                arrayList.remove(n2);
                continue;
            }
            if (arrayList.get(n2) != n) continue;
            arrayList.remove(n2);
        }
        return arrayList;
    }

    public final void diplomacyActions_DeclareWar_Old(int n) {
        if (CFG.core.getCiv((int)n).civGD.declareWarCheckNextTurnID <= GameCalendar.TURNID && GameCalendar.AI_AGGRESSIVENESS > 0.0f) {
            int n2;
            if (CFG.core.getCiv(CFG.core.getCiv(n).getPuppetOfCiv()).getIsPlayer() && CFG.core.getCiv(CFG.core.getCiv(n).getPuppetOfCiv()).getNumOfProvs() > 0 && (n2 = CFG.core.getPlayerIDbyCivID(CFG.core.getCiv(n).getPuppetOfCiv())) >= 0 && !CFG.core.getPlayer((int)n2).playerGD.VASSALS_CAN_DECLARE_WARS) {
                return;
            }
            if (CFG.core.getCiv(n).getPuppetOfCiv() != n && CFG.core.getCiv(CFG.core.getCiv(n).getPuppetOfCiv()).getNumOfProvs() > 0 && !CFG.AI_VASSALS_CAN_DECLARE_WARS) {
                CFG.core.getCiv((int)n).civGD.declareWarCheckNextTurnID = GameCalendar.TURNID + GameValues.gvAiDeclareWar.BASE_WAR_CHECK_DELAY_TURNS + (int)(((float)(CFG.core.getCiv((int)n).provincesWithLowHappiness.size() * 2 + CFG.oR.nextInt(GameValues.gvAiDeclareWar.WAR_CHECK_DELAY_RANDOM_TURNS)) + (float)CFG.oR.nextInt(CFG.oAI.NUM_OF_CIVS_IN_THE_GAME + 1) / GameValues.gvAiDeclareWar.WAR_CHECK_CIV_COUNT_RANDOM_DIVISOR_2) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
                return;
            }
            if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).CAN_BECOME_CIVILIZED >= 0) {
                CFG.core.getCiv((int)n).civGD.declareWarCheckNextTurnID = GameCalendar.TURNID + (int)(((float)(GameValues.gvAiDeclareWar.BASE_WAR_CHECK_DELAY_TURNS + CFG.oR.nextInt(GameValues.gvAiDeclareWar.WAR_CHECK_DELAY_RANDOM_TURNS_TRIBAL)) + (float)CFG.oR.nextInt(CFG.oAI.NUM_OF_CIVS_IN_THE_GAME + 1) / GameValues.gvAiDeclareWar.WAR_CHECK_CIV_COUNT_RANDOM_DIVISOR) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
            } else {
                float f;
                float f2 = f = CFG.core.getCiv(n).getPuppetOfCiv() == n ? CFG.oAI.getAIStyle((int)CFG.core.getCiv((int)n).getAIStyleID()).PERSONALITY_MIN_AGGRESSION_DEFAULT + (float)CFG.oR.nextInt(CFG.oAI.getAIStyle((int)CFG.core.getCiv((int)n).getAIStyleID()).PERSONALITY_MIN_AGGRESSION_RANDOM_100) / 100.0f : (CFG.oAI.getAIStyle((int)CFG.core.getCiv((int)n).getAIStyleID()).PERSONALITY_MIN_AGGRESSION_DEFAULT + (float)CFG.oR.nextInt(CFG.oAI.getAIStyle((int)CFG.core.getCiv((int)n).getAIStyleID()).PERSONALITY_MIN_AGGRESSION_RANDOM_100) / 100.0f) / 8.0f;
                if (f * GameCalendar.AI_AGGRESSIVENESS >= (float)CFG.oR.nextInt(10000) / 100.0f) {
                    int n3;
                    int n4;
                    int n5;
                    boolean bl;
                    int n6;
                    ArrayList<Integer> arrayList = new ArrayList<Integer>();
                    if (!CFG.core.getCiv((int)n).provincesWithLowStability.isEmpty()) {
                        CFG.core.getCiv((int)n).civGD.declareWarCheckNextTurnID = GameCalendar.TURNID + GameValues.gvAiDeclareWar.BASE_WAR_CHECK_DELAY_TURNS + (int)(((float)(CFG.core.getCiv((int)n).provincesWithLowStability.size() * 2 + CFG.oR.nextInt(GameValues.gvAiDeclareWar.WAR_CHECK_DELAY_RANDOM_TURNS)) + (float)CFG.oR.nextInt(CFG.oAI.NUM_OF_CIVS_IN_THE_GAME + 1) / GameValues.gvAiDeclareWar.WAR_CHECK_CIV_COUNT_RANDOM_DIVISOR_2) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
                        return;
                    }
                    if (!CFG.core.getCiv((int)n).provincesWithLowHappiness.isEmpty()) {
                        CFG.core.getCiv((int)n).civGD.declareWarCheckNextTurnID = GameCalendar.TURNID + GameValues.gvAiDeclareWar.BASE_WAR_CHECK_DELAY_TURNS + (int)(((float)(CFG.core.getCiv((int)n).provincesWithLowHappiness.size() * 2 + CFG.oR.nextInt(GameValues.gvAiDeclareWar.WAR_CHECK_DELAY_RANDOM_TURNS)) + (float)CFG.oR.nextInt(CFG.oAI.NUM_OF_CIVS_IN_THE_GAME + 1) / GameValues.gvAiDeclareWar.WAR_CHECK_CIV_COUNT_RANDOM_DIVISOR_2) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
                        return;
                    }
                    for (n6 = CFG.core.getCiv((int)n).lFrontLines.size() - 1; n6 >= 0; --n6) {
                        bl = false;
                        for (n5 = arrayList.size() - 1; n5 >= 0; --n5) {
                            if ((Integer)arrayList.get(n5) != CFG.core.getCiv((int)n).lFrontLines.get((int)n6).iWithCivID) continue;
                            bl = true;
                        }
                        if (bl) continue;
                        arrayList.add(CFG.core.getCiv((int)n).lFrontLines.get((int)n6).iWithCivID);
                    }
                    for (n6 = 0; n6 < CFG.core.getCiv(n).getSeaAccess_Provinces_Size(); ++n6) {
                        for (int i = 0; i < CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n6)).getNeighSeaProvincesSize(); ++i) {
                            for (int j = 0; j < CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n6)).getNeighSeaProvinces(i)).getNeighProvincesSize(); ++j) {
                                int n7;
                                if (!CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n6)).getNeighSeaProvinces(i)).getNeighProvinces(j)).getSeaProv()) {
                                    if (CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n6)).getNeighSeaProvinces(i)).getNeighProvinces(j)).getCivId() <= 0) continue;
                                    n4 = 0;
                                    for (n7 = arrayList.size() - 1; n7 >= 0; --n7) {
                                        if (((Integer)arrayList.get(n7)).intValue() != CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n6)).getNeighSeaProvinces(i)).getNeighProvinces(j)).getCivId()) continue;
                                        n4 = 1;
                                    }
                                    if (n4 != 0) continue;
                                    arrayList.add(CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n6)).getNeighSeaProvinces(i)).getNeighProvinces(j)).getCivId());
                                    continue;
                                }
                                for (n4 = 0; n4 < CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n6)).getNeighSeaProvinces(i)).getNeighProvinces(j)).getNeighProvincesSize(); ++n4) {
                                    if (CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n6)).getNeighSeaProvinces(i)).getNeighProvinces(j)).getNeighProvinces(n4)).getCivId() <= 0) continue;
                                    n7 = 0;
                                    for (int k = arrayList.size() - 1; k >= 0; --k) {
                                        if (((Integer)arrayList.get(k)).intValue() != CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n6)).getNeighSeaProvinces(i)).getNeighProvinces(j)).getNeighProvinces(n4)).getCivId()) continue;
                                        n7 = 1;
                                    }
                                    if (n7 != 0) continue;
                                    arrayList.add(CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n6)).getNeighSeaProvinces(i)).getNeighProvinces(j)).getNeighProvinces(n4)).getCivId());
                                }
                            }
                        }
                    }
                    if ((arrayList.isEmpty() || CFG.oR.nextInt(100) < GameValues.gvAiDeclareWar.NAVAL_EXPANSION_RANDOM_CHANCE_100) && CFG.core.getCiv(n).getSeaAccess_PortProvinces_Size() > 0 && CFG.core.getCiv(n).getNumOfProvs() > GameValues.gvAiDeclareWar.MIN_PROVINCES_FOR_NAVAL_ACTIONS) {
                        for (n6 = CFG.core.getCiv((int)n).civsInRange.size() - 1; n6 >= 0; --n6) {
                            arrayList.add(CFG.core.getCiv((int)n).civsInRange.get((int)n6).iCivID);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        for (n6 = 0; n6 < CFG.core.getCiv((int)n).civGD.civRivalsSize; ++n6) {
                            bl = false;
                            for (n5 = arrayList.size() - 1; n5 >= 0; --n5) {
                                if ((Integer)arrayList.get(n5) != CFG.core.getCiv((int)n).civGD.civRivals.get((int)n6).iCivID) continue;
                                bl = true;
                            }
                            if (bl) continue;
                            arrayList.add(CFG.core.getCiv((int)n).civGD.civRivals.get((int)n6).iCivID);
                        }
                    }
                    for (n6 = arrayList.size() - 1; n6 >= 0; --n6) {
                        float f3;
                        if (CFG.core.getCiv((Integer)arrayList.get(n6)).getPuppetOfCiv() != ((Integer)arrayList.get(n6)).intValue()) {
                            arrayList.remove(n6);
                            continue;
                        }
                        if (CFG.core.getCiv(n).isFriendlyCiv((Integer)arrayList.get(n6)) >= 0) {
                            arrayList.remove(n6);
                            continue;
                        }
                        if (CFG.core.isAlly(n, (Integer)arrayList.get(n6))) {
                            arrayList.remove(n6);
                            continue;
                        }
                        if (CFG.core.getGuarantee(n, (Integer)arrayList.get(n6)) > 0 || CFG.core.getGuarantee((Integer)arrayList.get(n6), n) > 0) {
                            arrayList.remove(n6);
                            continue;
                        }
                        if (CFG.core.getCivNonAggressionPact(n, (Integer)arrayList.get(n6)) > 0) {
                            arrayList.remove(n6);
                            continue;
                        }
                        if (CFG.core.getCivTruce(n, (Integer)arrayList.get(n6)) > 0) {
                            arrayList.remove(n6);
                            continue;
                        }
                        float f4 = CFG.core.getCivRelationOfCivB(n, (Integer)arrayList.get(n6));
                        float f5 = f3 = CFG.oAI.NUM_OF_CIVS_IN_THE_GAME < 10 ? 10.0f : Math.max((float)GameValues.gvAiDeclareWar.DECLARE_WAR_TARGET_RELATION, (float)GameValues.gvAiDeclareWar.DECLARE_WAR_TARGET_RELATION / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
                        if (f4 > f3) {
                            arrayList.remove(n6);
                            continue;
                        }
                        if (!(CFG.core.getCiv((Integer)arrayList.get(n6)).getIsPlayer() && CFG.core.getCiv(n).getRelationD((Integer)arrayList.get(n6)) > GameValues.gvAiDeclareWar.AI_MAX_RELATION_TO_DECLARE_WAR_WITH_PLAYER || CFG.core.getCiv(n).getRelationD((Integer)arrayList.get(n6)) > GameValues.gvAiDeclareWar.AI_MAX_RELATION_TO_DECLARE_WAR)) continue;
                        n4 = CFG.oR.nextInt(4);
                        for (n3 = 0; n3 < 2 + n4; ++n3) {
                            GameManager.decreaseRelation(n, (Integer)arrayList.get(n6), 10);
                        }
                        arrayList.remove(n6);
                    }
                    if (!arrayList.isEmpty()) {
                        boolean bl2 = false;
                        if (!CFG.core.getCiv((int)n).civGD.coloniesFounded.isEmpty() && CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).CAN_BECOME_CIVILIZED < 0) {
                            ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
                            for (n3 = 0; n3 < arrayList.size(); ++n3) {
                                if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)((Integer)arrayList.get((int)n3)).intValue()).getIdeology()).CAN_BECOME_CIVILIZED < 0) continue;
                                arrayList2.add((Integer)arrayList.get(n3));
                            }
                            if (!arrayList2.isEmpty()) {
                                CFG.core.declareWar(n, (Integer)arrayList2.get(CFG.oR.nextInt(arrayList2.size())), false);
                                bl2 = true;
                            }
                        }
                        if (!bl2) {
                            int n8;
                            int n9;
                            int n10;
                            ArrayList<Float> arrayList3 = new ArrayList<Float>();
                            float f6 = GameValues.gvAiDeclareWar.RELATION_MODIFIER_BASE + (float)CFG.oR.nextInt(GameValues.gvAiDeclareWar.RELATION_MODIFIER_RANDOM_1000) / 1000.0f;
                            float f7 = GameValues.gvAiDeclareWar.BUDGET_MODIFIER_BASE + (float)CFG.oR.nextInt(GameValues.gvAiDeclareWar.BUDGET_MODIFIER_RANDOM_1000) / 1000.0f;
                            float f8 = GameValues.gvAiDeclareWar.CIV_SIZE_MODIFIER;
                            for (n10 = 0; n10 < arrayList.size(); ++n10) {
                                arrayList3.add(Float.valueOf(this.diplomacyActions_DeclareWar_Score(n, (Integer)arrayList.get(n10), f7, f8, f6)));
                            }
                            n10 = 0;
                            for (n9 = 1; n9 < arrayList.size(); ++n9) {
                                if (!(((Float)arrayList3.get(n10)).floatValue() < ((Float)arrayList3.get(n9)).floatValue())) continue;
                                n10 = n9;
                            }
                            long n9_budgets = this.diplomacyActions_DeclareWar_Budgets(n, false);
                            long n11 = this.diplomacyActions_DeclareWar_Budgets((Integer)arrayList.get(n10), true);
                            if ((float)n9_budgets > (float)n11 * GameValues.gvAiDeclareWar.WAR_PREPARATION_MIN_BUDGET_RATIO) {
                                int n12 = GameValues.gvAiDeclareWar.WAR_PREPARATION_MIN_TURNS + CFG.oR.nextInt(GameValues.gvAiDeclareWar.WAR_PREPARATION_RANDOM_TURNS);
                                CFG.core.getCiv((int)n).civGD.civPlans.addNewWarPreps(n, n, (Integer)arrayList.get(n10), n12);
                                List<Integer> list = GameManager.callToArmsListOfCivs(n, (Integer)arrayList.get(n10));
                                for (int i = 0; i < list.size(); ++i) {
                                    GameManager.sendPrepareForWar(list.get(i), n, (Integer)arrayList.get(n10), n12, n);
                                }
                            } else {
                                int n13;
                                ArrayList<Integer> arrayList4 = new ArrayList<Integer>();
                                for (int i = 0; i < CFG.core.getCiv((Integer)arrayList.get(n10)).getHatedCivs_BySize(); ++i) {
                                    if (CFG.core.getCiv(n).isHatedCiv(CFG.core.getCiv((Integer)arrayList.get(n10)).getHatedCiv_By(i)) || CFG.core.getCiv(CFG.core.getCiv((Integer)arrayList.get(n10)).getHatedCiv_By(i)).getNumOfProvs() <= 0) continue;
                                    arrayList4.add(CFG.core.getCiv((Integer)arrayList.get(n10)).getHatedCiv_By(i));
                                }
                                for (n13 = 0; n13 < arrayList4.size(); ++n13) {
                                    n9 += this.diplomacyActions_DeclareWar_Budgets((Integer)arrayList4.get(n13), false);
                                }
                                if ((float)n9 > (float)n11 * GameValues.gvAiDeclareWar.TRADE_RQ_COALITION_MIN_BUDGET_RATIO) {
                                    for (n13 = 0; n13 < arrayList4.size(); ++n13) {
                                        if (Objects.equals(arrayList.get(n10), arrayList4.get(n13))) continue;
                                        TradeRequest_GameData tradeRequest_GameData = new TradeRequest_GameData();
                                        tradeRequest_GameData.iCivLEFT = n;
                                        tradeRequest_GameData.iCivRIGHT = (Integer)arrayList4.get(n13);
                                        tradeRequest_GameData.listRight.lFormCoalitionAgainst.add((Integer)arrayList.get(n10));
                                        tradeRequest_GameData.listLEFT.iGold = (long)GameValues.gvAiDeclareWar.TRADE_RQ_COALITION_BRIBE_GOLD_MIN + CFG.oR.nextInt(GameValues.gvAiDeclareWar.TRADE_RQ_COALITION_BRIBE_GOLD_RANDOM) + (long)Math.max(0.0f, Math.min((float)CFG.core.getCiv(n).getGold(), (float)CFG.core.getCiv((Integer)arrayList4.get(n13)).getNumberOfUnits() * (GameValues.gvAiDeclareWar.TRADE_RQ_COALITION_BRIBE_GOLD_PERC_OF_ARMY_MIN + (float)CFG.oR.nextInt(GameValues.gvAiDeclareWar.TRADE_RQ_COALITION_BRIBE_GOLD_PERC_OF_ARMY_RANDOM_100) / 100.0f)));
                                        GameManager.sendTradeRequest((Integer)arrayList4.get(n13), n, tradeRequest_GameData);
                                    }
                                    int n14 = GameValues.gvAiDeclareWar.WAR_PREPARATION_MIN_TURNS + CFG.oR.nextInt(GameValues.gvAiDeclareWar.WAR_PREPARATION_RANDOM_TURNS);
                                    CFG.core.getCiv((int)n).civGD.civPlans.addNewWarPreps(n, n, (Integer)arrayList.get(n10), n14);
                                    List<Integer> list = GameManager.callToArmsListOfCivs(n, (Integer)arrayList.get(n10));
                                    for (int i = 0; i < list.size(); ++i) {
                                        GameManager.sendPrepareForWar(list.get(i), n, (Integer)arrayList.get(n10), n14, n);
                                    }
                                } else {
                                    GameManager.sendNonAggressionProposal((Integer)arrayList.get(n10), n, GameValues.gvDipNonAggression.DIPLOMACY_MAX_NUMBER_OF_TURNS_NON_AGGRESSION_PACT);
                                }
                            }
                        }
                        CFG.core.getCiv((int)n).civGD.declareWarCheckNextTurnID = GameCalendar.TURNID + (int)(((float)(GameValues.gvAiDeclareWar.BASE_WAR_CHECK_DELAY_TURNS + CFG.core.getCiv((Integer)arrayList.get(CFG.oR.nextInt(arrayList.size()))).getNumOfProvs() + CFG.oR.nextInt(GameValues.gvAiDeclareWar.WAR_CHECK_DELAY_RANDOM_TURNS_AFTER_PREPARATION)) + (float)CFG.oR.nextInt(CFG.oAI.NUM_OF_CIVS_IN_THE_GAME + 1) / GameValues.gvAiDeclareWar.WAR_CHECK_CIV_COUNT_RANDOM_DIVISOR_2) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
                    } else {
                        CFG.core.getCiv((int)n).civGD.declareWarCheckNextTurnID = GameCalendar.TURNID + (int)(((float)(GameValues.gvAiDeclareWar.BASE_WAR_CHECK_DELAY_TURNS + CFG.oR.nextInt(GameValues.gvAiDeclareWar.WAR_CHECK_DELAY_RANDOM_TURNS)) + (float)CFG.oR.nextInt(CFG.oAI.NUM_OF_CIVS_IN_THE_GAME + 1) / GameValues.gvAiDeclareWar.WAR_CHECK_CIV_COUNT_RANDOM_DIVISOR_2) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
                    }
                } else {
                    CFG.core.getCiv((int)n).civGD.declareWarCheckNextTurnID = GameCalendar.TURNID + (int)(((float)(GameValues.gvAiDeclareWar.BASE_WAR_CHECK_DELAY_TURNS + CFG.oR.nextInt(GameValues.gvAiDeclareWar.WAR_CHECK_DELAY_RANDOM_TURNS)) + (float)CFG.oR.nextInt(CFG.oAI.NUM_OF_CIVS_IN_THE_GAME + 1) / GameValues.gvAiDeclareWar.WAR_CHECK_CIV_COUNT_RANDOM_DIVISOR) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS));
                }
            }
        }
    }

    public final float diplomacyActions_DeclareWar_Score(int n, int n2, float f, float f2, float f3) {
        return f * (1.0f - Math.min((float)CFG.core.getCiv((int)n2).iBudget / (float)CFG.core.getCiv((int)n).iBudget, GameValues.gvAiDeclareWar.SCORE_MAX_BUDGET_RATIO)) + f3 * (1.0f + CFG.core.getCiv((int)n2).civGD.civAggressionLevel / GameValues.gvAiDeclareWar.SCORE_CIV_AGGRESSION_DIVISOR) * (1.0f - Math.min(CFG.core.getCivRelationOfCivB(n, n2) + 100.0f, 200.0f) / 200.0f);
    }

    public final long diplomacyActions_DeclareWar_Budgets(int n, boolean bl) {
        int n2;
        long n3 = CFG.core.getCiv((int)n).iBudget;
        if (CFG.core.getCiv(n).getPuppetOfCiv() != n) {
            n3 += CFG.core.getCiv((int)CFG.core.getCiv((int)n).getPuppetOfCiv()).iBudget;
        }
        for (n2 = 0; n2 < CFG.core.getCiv((int)n).civGD.iVassalsSize; ++n2) {
            n3 += CFG.core.getCiv((int)CFG.core.getCiv((int)n).civGD.vassals.get((int)n2).iCivID).iBudget;
        }
        if (CFG.core.getCiv(n).getAlliance() > 0) {
            for (n2 = 0; n2 < CFG.core.getAlliance(CFG.core.getCiv(n).getAlliance()).getCivilizationsSize(); ++n2) {
                if (n == CFG.core.getAlliance(CFG.core.getCiv(n).getAlliance()).getCivilization(n2) || n == CFG.core.getCiv(CFG.core.getAlliance(CFG.core.getCiv(n).getAlliance()).getCivilization(n2)).getPuppetOfCiv() || CFG.core.getCiv(n).getPuppetOfCiv() == CFG.core.getAlliance(CFG.core.getCiv(n).getAlliance()).getCivilization(n2)) continue;
                n3 += CFG.core.getCiv((int)CFG.core.getAlliance((int)CFG.core.getCiv((int)n).getAlliance()).getCivilization((int)n2)).iBudget;
            }
        }
        try {
            if (bl) {
                for (n2 = 1; n2 < n; ++n2) {
                    if (CFG.core.getDefensivePact(n, n2) > 0) {
                        if (CFG.core.getCiv(n2).getNumOfProvs() <= 0) continue;
                        n3 += CFG.core.getCiv((int)n2).iBudget;
                        continue;
                    }
                    if (CFG.core.getGuarantee(n2, n) <= 0 || CFG.core.getCiv(n2).getNumOfProvs() <= 0) continue;
                    n3 += CFG.core.getCiv((int)n2).iBudget;
                }
                for (n2 = n; n2 < CFG.core.getCivsSize(); ++n2) {
                    if (CFG.core.getDefensivePact(n, n2) > 0) {
                        if (CFG.core.getCiv(n2).getNumOfProvs() <= 0) continue;
                        n3 += CFG.core.getCiv((int)n2).iBudget;
                        continue;
                    }
                    if (CFG.core.getGuarantee(n, n2) <= 0 || CFG.core.getCiv(n2).getNumOfProvs() <= 0) continue;
                    n3 += CFG.core.getCiv((int)n2).iBudget;
                }
            }
        }
        catch (Exception exception) {
            
        }
        return n3;
    }

    public final void diplomacyActions_BuildCivsInRange(int n) {
        if (GameCalendar.TURNID >= CFG.core.getCiv((int)n).civGD.nextBuildCivsInRange_TurnID) {
            if (CFG.core.getCiv(n).getCapitalProvID() >= 0) {
                CFG.core.getCiv((int)n).civsInRange.clear();
                CFG.core.getCiv((int)n).civsInRange = this.diplomacyActions_CivsInRange(n);
                CFG.core.getCiv((int)n).civGD.nextBuildCivsInRange_TurnID = !CFG.core.getCiv((int)n).civsInRange.isEmpty() ? GameCalendar.TURNID + GameValues.gvAiCivsInRange.REBUILD_CIVS_IN_RANGE_AFTER_X_TURNS_EMPTY + CFG.oR.nextInt(GameValues.gvAiCivsInRange.REBUILD_CIVS_IN_RANGE_AFTER_X_TURNS_RANDOM_EMPTY) : GameCalendar.TURNID + GameValues.gvAiCivsInRange.REBUILD_CIVS_IN_RANGE_AFTER_X_TURNS + CFG.oR.nextInt(Math.max(GameValues.gvAiCivsInRange.REBUILD_CIVS_IN_RANGE_AFTER_X_TURNS_RANDOM, CFG.core.getCivsSize() / 4));
            } else {
                CFG.core.getCiv((int)n).civGD.nextBuildCivsInRange_TurnID = GameCalendar.TURNID + GameValues.gvAiCivsInRange.REBUILD_CIVS_IN_RANGE_AFTER_X_TURNS_NO_CAPITAL + CFG.oR.nextInt(GameValues.gvAiCivsInRange.REBUILD_CIVS_IN_RANGE_AFTER_X_TURNS_NO_CAPITAL_RANDOM);
            }
        }
    }

    public final void diplomacyActions_Ally(int n) {
        if (CFG.core.getCiv((int)n).civGD.resumeAllianceCheckAtTurnID <= GameCalendar.TURNID) {
            this.diplomacyActions_Union(n);
            if (CFG.core.getCiv(n).getPuppetOfCiv() == n && (CFG.MAX_PROVINCES_FOR_ALLIANCE_PROPOSAL == 0 || CFG.core.getCiv(n).getNumOfProvs() < CFG.MAX_PROVINCES_FOR_ALLIANCE_PROPOSAL) && CFG.core.getCiv(n).getAlliance() == 0 && CFG.oR.nextInt(100) < CFG.PROPOSE_ALLIANCE_CHANCE_100 && CFG.core.getCiv(n).getFriendlyCivsSize() > 0) {
                int n2;
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                for (n2 = 0; n2 < CFG.core.getCiv(n).getFriendlyCivsSize(); ++n2) {
                    if (CFG.core.getCiv(CFG.core.getCiv((int)n).getFriendlyCiv((int)n2).iCivID).getPuppetOfCiv() != CFG.core.getCiv((int)n).getFriendlyCiv((int)n2).iCivID || CFG.core.getCiv(CFG.core.getCiv((int)n).getFriendlyCiv((int)n2).iCivID).isAtWarC() || CFG.core.getCiv(CFG.core.getCiv((int)n).getFriendlyCiv((int)n2).iCivID).getCapitalProvID() < 0 || CFG.core.getCiv(CFG.core.getCiv((int)n).getFriendlyCiv((int)n2).iCivID).getAlliance() != 0) continue;
                    arrayList.add(CFG.core.getCiv((int)n).getFriendlyCiv((int)n2).iCivID);
                }
                if (!arrayList.isEmpty()) {
                    if (CFG.oR.nextInt(100) < GameValues.gvAiDiplomacy.ALLY_CHOOSE_RANDOM_CHANCE_100) {
                        n2 = CFG.oR.nextInt(CFG.core.getCiv(n).getFriendlyCivsSize());
                        if (CFG.core.getCiv(CFG.core.getCiv((int)n).getFriendlyCiv((int)n2).iCivID).getPuppetOfCiv() == CFG.core.getCiv((int)n).getFriendlyCiv((int)n2).iCivID && CFG.core.getCiv(CFG.core.getCiv((int)n).getFriendlyCiv((int)n2).iCivID).getAlliance() == 0) {
                            GameManager.sendAllianceProposal(CFG.core.getCiv((int)n).getFriendlyCiv((int)n2).iCivID, n);
                            GameManager.improveRelation(n, CFG.core.getCiv((int)n).getFriendlyCiv((int)n2).iCivID);
                        }
                    } else {
                        int n3;
                        int n4;
                        ArrayList<Float> arrayList2 = new ArrayList<Float>();
                        for (n4 = 0; n4 < arrayList.size(); ++n4) {
                            arrayList2.add(Float.valueOf(Distance.getDistanceFromAToB_PercOfMax(CFG.core.getCiv(n).getCapitalProvID(), CFG.core.getCiv((Integer)arrayList.get(n4)).getCapitalProvID())));
                        }
                        n4 = 0;
                        for (n3 = 1; n3 < arrayList.size(); ++n3) {
                            if (!(((Float)arrayList2.get(n4)).floatValue() > ((Float)arrayList2.get(n3)).floatValue())) continue;
                            n4 = n3;
                        }
                        n3 = (Integer)arrayList.get(n4);
                        if (CFG.core.getCiv(n3).getPuppetOfCiv() == n3 && CFG.core.getCiv(n3).getAlliance() == 0) {
                            GameManager.sendAllianceProposal(n3, n);
                            GameManager.improveRelation(n, n3);
                        }
                    }
                }
            }
            CFG.core.getCiv((int)n).civGD.resumeAllianceCheckAtTurnID = GameCalendar.TURNID + GameValues.gvAiAlliance.NEXT_ALLIANCE_CHECK_TURN_ID + CFG.oR.nextInt(GameValues.gvAiAlliance.NEXT_ALLIANCE_CHECK_TURN_ID_RANDOM);
        }
    }

    public final void diplomacyActions_Union(int n) {
        if (CFG.AI_UNIONS_ENABLED && CFG.core.getCiv(n).getPuppetOfCiv() == n && CFG.core.getCiv(n).getAlliance() > 0 && CFG.core.getAlliance(CFG.core.getCiv(n).getAlliance()).getCivilizationsSize() == 2) {
            int n2 = -1;
            for (int i = 0; i < CFG.core.getAlliance(CFG.core.getCiv(n).getAlliance()).getCivilizationsSize(); ++i) {
                if (n == CFG.core.getAlliance(CFG.core.getCiv(n).getAlliance()).getCivilization(i)) continue;
                n2 = CFG.core.getAlliance(CFG.core.getCiv(n).getAlliance()).getCivilization(i);
                break;
            }
            if (!GameValues.gvAiDiplomacy.ENABLE_AI_UNIONS_DIFFERENT_RELIGION && CFG.core.getCiv(n).getReligionID() != CFG.core.getCiv(n2).getReligionID()) {
                return;
            }
            if (n2 > 0 && CFG.core.getCiv(n2).getPuppetOfCiv() == n2) {
                if (CFG.core.getCivRelationOfCivB(n, n2) > (float)GameValues.gvAiDiplomacy.UNION_ALLY_MIN_RELATION) {
                    GameManager.sendUnionProposal(n2, n);
                } else {
                    GameManager.improveRelation(n, n2);
                    CFG.core.getCiv(n).getCivDiploGD().addImproveRelations(n, n2, GameValues.gvRelationImprove.IMPROVE_RELATIONS_MAX_NUM_OF_TURNS);
                    if (!CFG.core.getCiv(n2).getIsPlayer()) {
                        CFG.core.getCiv(n2).getCivDiploGD().addImproveRelations(n2, n, GameValues.gvRelationImprove.IMPROVE_RELATIONS_MAX_NUM_OF_TURNS);
                    }
                }
            }
        }
    }

    public final void diplomacyActions_FindFriendlyCivs(int n) {
        this.diplomacyActions_InfluencedCiv_Update(n);
        if (GameCalendar.TURNID >= CFG.core.getCiv((int)n).civGD.resumeLookingForFriendsAtTurnID) {
            int n2;
            try {
                if (CFG.core.getCiv((int)n).civGD.iVassalsSize > 0) {
                    for (n2 = 0; n2 < CFG.core.getCiv((int)n).civGD.iVassalsSize; ++n2) {
                        if (!(CFG.core.getCiv(CFG.core.getCiv((int)n).civGD.vassals.get((int)n2).iCivID).getRelationD(n) < 0.0f) || CFG.core.getCiv(n).getCivDiploGD().getIsImprovingRelations(CFG.core.getCiv((int)n).civGD.vassals.get((int)n2).iCivID)) continue;
                        CFG.core.getCiv(n).getCivDiploGD().addImproveRelations(n, CFG.core.getCiv((int)n).civGD.vassals.get((int)n2).iCivID, (int)Math.min((float)GameValues.gvRelationImprove.IMPROVE_RELATIONS_MAX_NUM_OF_TURNS, Math.max(GameValues.gvRelationImprove.IMPROVE_RELATIONS_WITH_VASSAL_TURNS_MIN, GameValues.gvRelationImprove.IMPROVE_RELATIONS_WITH_VASSAL_TURNSLIMIT - CFG.core.getCiv(CFG.core.getCiv((int)n).civGD.vassals.get((int)n2).iCivID).getRelationD(n)) / GameValues.gvRelationImprove.IMPROVE_RELATIONS_BASE));
                    }
                }
            }
            catch (Exception exception) {
                CFG.exceptionStack(exception);
            }
            n2 = Math.min(CFG.oAI.MIN_NUM_OF_RIVALS, CFG.core.getCiv(n).getNumOfProvs()) - CFG.core.getCiv((int)n).civGD.civsToImproveRelationsWithSize;
            if (n2 > 0) {
                if (CFG.gameAction.getUpdateCivsDiploPoints(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) <= GameValues.gvRelationImprove.COST_OFFER_IMPROVE_RELATIONS_DIPLOMACY_POINTS / 2) {
                    CFG.core.getCiv((int)n).civGD.resumeLookingForFriendsAtTurnID = GameCalendar.TURNID + GameValues.gvAiRelations.RESUME_LOOKING_FOR_FRIENDS_AFTER_X_TURNS + CFG.oR.nextInt(GameValues.gvAiRelations.RESUME_LOOKING_FOR_FRIENDS_AFTER_X_TURNS_RANDOM);
                } else if (!CFG.core.getCiv((int)n).civsInRange.isEmpty()) {
                    int n3;
                    ArrayList<AI_CivsInRange> arrayList = new ArrayList<AI_CivsInRange>();
                    for (n3 = CFG.core.getCiv((int)n).civsInRange.size() - 1; n3 >= 0; --n3) {
                        arrayList.add(CFG.core.getCiv((int)n).civsInRange.get(n3));
                    }
                    for (n3 = arrayList.size() - 1; n3 >= 0; --n3) {
                        if (AIPlaystyle.diplomacyActions_RivalCiv_IsRival(n, ((AI_CivsInRange)arrayList.get((int)n3)).iCivID)) {
                            arrayList.remove(n3);
                            continue;
                        }
                        if (this.diplomacyActions_IsInfluenced(n, ((AI_CivsInRange)arrayList.get((int)n3)).iCivID)) {
                            arrayList.remove(n3);
                            continue;
                        }
                        if (this.diplomacyActions_IsInfluenced(((AI_CivsInRange)arrayList.get((int)n3)).iCivID, n) && CFG.oR.nextInt(100) < GameValues.gvAiRelations.IMPROVE_RELATIONS_SKIP_IF_CIV_IMPROVES_RELATIONS_CHANCE_100) {
                            arrayList.remove(n3);
                            continue;
                        }
                        if (!(CFG.core.getCivRelationOfCivB(n, ((AI_CivsInRange)arrayList.get((int)n3)).iCivID) > (float)GameValues.gvAiRelations.IMPROVE_RELATIONS_SKIP_IF_RELATIONS_OVER) && !(CFG.core.getCivRelationOfCivB(((AI_CivsInRange)arrayList.get((int)n3)).iCivID, n) > (float)GameValues.gvAiRelations.IMPROVE_RELATIONS_SKIP_IF_RELATIONS_OVER)) continue;
                        arrayList.remove(n3);
                    }
                    if (!arrayList.isEmpty()) {
                        int n4;
                        int n5;
                        ArrayList<Float> arrayList2 = new ArrayList<Float>();
                        ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
                        float f = GameValues.gvAiRelations.IMPROVE_RELATIONS_BASE_BUDGET_MODIFIER + (float)CFG.oR.nextInt(GameValues.gvAiRelations.IMPROVE_RELATIONS_BUDGET_MODIFIER_RANDOM_RANGE_1000) / 1000.0f;
                        float f2 = GameValues.gvAiRelations.IMPROVE_RELATIONS_BASE_CIV_SIZE_MODIFIER + (float)CFG.oR.nextInt(GameValues.gvAiRelations.IMPROVE_RELATIONS_CIV_SIZE_RANDOM_RANGE_1000) / 1000.0f;
                        float f3 = GameValues.gvAiRelations.IMPROVE_RELATIONS_BASE_RANGE_MODIFIER + GameValues.gvAiRelations.IMPROVE_RELATIONS_RANGE_RANK_SCALING * ((float)CFG.core.getCiv(n).getRankPos() / (float)CFG.core.getCivsSize());
                        int n6 = (int)((float)CFG.core.getCiv((int)n).iBudget * (GameValues.gvAiRelations.IMPROVE_RELATIONS_BASE_BUDGET_SCALE + (float)CFG.oR.nextInt(GameValues.gvAiRelations.IMPROVE_RELATIONS_BUDGET_SCALE_RANDOM_RANGE_100) / 100.0f));
                        int n7 = arrayList.size();
                        for (int i = 0; i < n7; ++i) {
                            arrayList2.add(Float.valueOf(this.diplomacyActions_FriendlyCiv_Score(n6, n, (AI_CivsInRange)arrayList.get(i), f, f2)));
                            arrayList3.add(i);
                        }
                        float f4 = CFG.gameAges.getAge_FogOfWarDiscovery_MetProvinces(GameCalendar.CURRENT_AGEID);
                        for (int i = arrayList.size() - 1; i >= 0; --i) {
                            arrayList2.set(i, Float.valueOf((float)CFG.oR.nextInt(GameValues.gvAiRelations.IMPROVE_RELATIONS_SCORE_RANDOM_RANGE_100) / 100.0f + ((Float)arrayList2.get(i)).floatValue() * (1.0f - f3 * ((AI_CivsInRange)arrayList.get((int)i)).fDistance / ((f4 + f4 * GameValues.gvAiRelations.IMPROVE_RELATIONS_DISTANCE_MULTIPLIER) * CFG.core.getCiv(n).getTechLevel()) + GameValues.gvAiRelations.IMPROVE_RELATIONS_RELATIONS_MODIFIER * (Math.min(CFG.core.getCivRelationOfCivB(n, ((AI_CivsInRange)arrayList.get((int)i)).iCivID), 0.0f) / 100.0f))));
                        }
                        ArrayList<Integer> arrayList4 = new ArrayList<Integer>();
                        while (!arrayList3.isEmpty() && arrayList4.size() < n2) {
                            n5 = 0;
                            for (n4 = arrayList3.size() - 1; n4 > 0; --n4) {
                                if (!(((Float)arrayList2.get((Integer)arrayList3.get(n4))).floatValue() > ((Float)arrayList2.get((Integer)arrayList3.get(n5))).floatValue())) continue;
                                n5 = n4;
                            }
                            arrayList4.add((Integer)arrayList3.get(n5));
                            arrayList3.remove(n5);
                        }
                        n5 = Math.min(1 + CFG.oR.nextInt(2), n2);
                        for (n4 = 0; n4 < arrayList.size() && n4 < n5; ++n4) {
                            int n8 = GameValues.gvAiRelations.IMPROVE_RELATIONS_MIN_VALUE + CFG.oR.nextInt(GameValues.gvAiRelations.IMPROVE_RELATIONS_RANDOM);
                            CFG.core.getCiv(n).getCivDiploGD().addImproveRelations(n, ((AI_CivsInRange)arrayList.get((int)((Integer)arrayList4.get((int)n4)).intValue())).iCivID, (int)Math.min((float)GameValues.gvRelationImprove.IMPROVE_RELATIONS_MAX_NUM_OF_TURNS, Math.max(10.0f, (float)n8 - CFG.core.getCiv(((AI_CivsInRange)arrayList.get((int)((Integer)arrayList4.get((int)n4)).intValue())).iCivID).getRelationD(n)) / GameValues.gvRelationImprove.IMPROVE_RELATIONS_BASE));
                            CFG.core.getCiv((int)n).civGD.civsToImproveRelationsWith.add(new AI_ImproveRelations(((AI_CivsInRange)arrayList.get((int)((Integer)arrayList4.get((int)n4)).intValue())).iCivID, n8, GameCalendar.TURNID + GameValues.gvAiRelations.IMPROVE_RELATIONS_MIN_NUM_OF_TURNS + CFG.oR.nextInt(GameValues.gvAiRelations.IMPROVE_RELATIONS_MIN_NUM_OF_TURNS_RANDOM)));
                            --n2;
                        }
                        CFG.core.getCiv((int)n).civGD.civsToImproveRelationsWithSize = CFG.core.getCiv((int)n).civGD.civsToImproveRelationsWith.size();
                        if (n2 <= 0) {
                            CFG.core.getCiv((int)n).civGD.resumeLookingForFriendsAtTurnID = GameCalendar.TURNID + GameValues.gvAiRelations.RESUME_LOOKING_FOR_FRIENDS_AFTER_X_TURNS + CFG.oR.nextInt(GameValues.gvAiRelations.RESUME_LOOKING_FOR_FRIENDS_AFTER_X_TURNS_RANDOM);
                        } else if (arrayList.size() - n5 > Math.min(CFG.oAI.MIN_NUM_OF_RIVALS, CFG.core.getCiv(n).getNumOfProvs()) - CFG.core.getCiv((int)n).civGD.civsToImproveRelationsWithSize) {
                            CFG.core.getCiv((int)n).civGD.resumeLookingForFriendsAtTurnID = GameCalendar.TURNID + GameValues.gvAiRelations.RESUME_LOOKING_FOR_FRIENDS_AFTER_X_TURNS + CFG.oR.nextInt(GameValues.gvAiRelations.RESUME_LOOKING_FOR_FRIENDS_AFTER_X_TURNS_RANDOM);
                        }
                    } else {
                        CFG.core.getCiv((int)n).civGD.resumeLookingForFriendsAtTurnID = GameCalendar.TURNID + GameValues.gvAiRelations.RESUME_LOOKING_FOR_FRIENDS_AFTER_X_TURNS + CFG.oR.nextInt(GameValues.gvAiRelations.RESUME_LOOKING_FOR_FRIENDS_AFTER_X_TURNS_RANDOM);
                    }
                    CFG.core.getCiv((int)n).civGD.resumeLookingForFriendsAtTurnID = GameCalendar.TURNID + GameValues.gvAiRelations.RESUME_LOOKING_FOR_FRIENDS_AFTER_X_TURNS + CFG.oR.nextInt(GameValues.gvAiRelations.RESUME_LOOKING_FOR_FRIENDS_AFTER_X_TURNS_RANDOM);
                } else {
                    CFG.core.getCiv((int)n).civGD.resumeLookingForFriendsAtTurnID = GameCalendar.TURNID + GameValues.gvAiRelations.RESUME_LOOKING_FOR_FRIENDS_AFTER_X_TURNS + CFG.oR.nextInt(GameValues.gvAiRelations.RESUME_LOOKING_FOR_FRIENDS_AFTER_X_TURNS_RANDOM);
                }
            } else {
                CFG.core.getCiv((int)n).civGD.resumeLookingForFriendsAtTurnID = GameCalendar.TURNID + GameValues.gvAiRelations.RESUME_LOOKING_FOR_FRIENDS_AFTER_X_TURNS + CFG.oR.nextInt(GameValues.gvAiRelations.RESUME_LOOKING_FOR_FRIENDS_AFTER_X_TURNS_RANDOM);
            }
        }
    }

    public final float diplomacyActions_FriendlyCiv_Score(int n, int n2, AI_CivsInRange aI_CivsInRange, float f, float f2) {
        return f * (float)Math.min(n, CFG.core.getCiv((int)aI_CivsInRange.iCivID).iBudget) / (float)Math.max(n, CFG.core.getCiv((int)aI_CivsInRange.iCivID).iBudget) + f2 * (float)Math.min(CFG.core.getCiv(n2).getNumOfProvs(), CFG.core.getCiv(aI_CivsInRange.iCivID).getNumOfProvs()) / (float)Math.max(CFG.core.getCiv(n2).getNumOfProvs(), CFG.core.getCiv(aI_CivsInRange.iCivID).getNumOfProvs()) * (this.isRivalOfMyRival(n2, aI_CivsInRange.iCivID) ? GameValues.gvAiRelations.IMPROVE_RELATIONS_SCORE_RIVAL_OF_RIVAL_BONUS : 1.0f) * (CFG.core.getCivRelationOfCivB(n2, aI_CivsInRange.iCivID) > (float)GameValues.gvAiRelations.IMPROVE_RELATIONS_SCORE_RELATION_THRESHOLD ? GameValues.gvAiRelations.IMPROVE_RELATIONS_SCORE_HIGH_RELATION_PENALTY : 1.0f);
    }

    public final boolean isRivalOfMyRival(int n, int n2) {
        for (int i = 0; i < CFG.core.getCiv((int)n).civGD.civRivalsSize; ++i) {
            if (!AIPlaystyle.diplomacyActions_RivalCiv_IsRival(CFG.core.getCiv((int)n).civGD.civRivals.get((int)i).iCivID, n2)) continue;
            return true;
        }
        return false;
    }

    public final void diplomacyActions_RivalCiv_New(int n) {
        if (GameCalendar.TURNID >= CFG.core.getCiv((int)n).civGD.resumeLookingForRivalAtTurnID) {
            int n2 = Math.min(CFG.oAI.MIN_NUM_OF_RIVALS, CFG.core.getCiv(n).getNumOfProvs()) - CFG.core.getCiv((int)n).civGD.civRivalsSize;
            if (n2 > 0) {
                try {
                    List<Integer> list = RivalsManager.buildRivals(n, GameValues.gvAiRivals.NUM_OF_RIVALS_TO_CHOOSE_FROM);
                    List<Float> list2 = RivalsManager.chooseRivals_BuildScore(n, list);
                    int n3 = list.size();
                    for (int i = 0; i < n2 && !list.isEmpty(); ++i) {
                        int n4;
                        int n5 = 0;
                        for (n4 = 1; n4 < n3; ++n4) {
                            if (!(list2.get(n5).floatValue() > list2.get(n4).floatValue())) continue;
                            n5 = n4;
                        }
                        n4 = GameValues.gvRelationDecrease.SUSPEND_DIPLOMATIC_RELATIONS_MIN + CFG.oR.nextInt(GameValues.gvRelationDecrease.SUSPEND_DIPLOMATIC_RELATIONS_MAX - GameValues.gvRelationDecrease.SUSPEND_DIPLOMATIC_RELATIONS_MIN);
                        GameManager.decreaseRelation(n, list.get(n5), n4);
                        if (CFG.oR.nextInt(1000) < GameValues.gvAiDiplomacy.ADD_RIVAL_IMPOSE_SANCTIONS_CHANCE_1000) {
                            GameManager.imposeSanctions(n, list.get(n5), GameValues.gvSanctions.SANCTIONS_MIN_TURNS + CFG.oR.nextInt(Math.max(1, GameValues.gvSanctions.SANCTIONS_MAX_TURNS - GameValues.gvSanctions.SANCTIONS_MIN_TURNS)));
                        }
                        CFG.core.getCiv((int)n).civGD.civRivals.add(new AI_Rival(list.get(n5), GameCalendar.TURNID + GameValues.gvAiRivals.END_OF_RIVALRY_AFTER_EXTRA_TURNS_BASE + CFG.oR.nextInt(GameValues.gvAiRivals.END_OF_RIVALRY_AFTER_EXTRA_TURNS_RANDOM)));
                        CFG.core.getCiv((int)n).civGD.civRivalsSize = CFG.core.getCiv((int)n).civGD.civRivals.size();
                        if (CFG.core.getCiv(list.get(n5)).getIsPlayer()) {
                            CFG.core.getCiv((int)list.get((int)n5).intValue()).getCivDiploGD().messageBox.addMessage(new Message_Rivals(n));
                        }
                        list.remove(n5);
                        list2.remove(n5);
                        n3 = list.size();
                    }
                    list.clear();
                    list2.clear();
                    CFG.core.getCiv((int)n).civGD.resumeLookingForRivalAtTurnID = GameCalendar.TURNID + GameValues.gvAiRivals.RESUME_LOOKING_FOR_ENEMY_AT_TURN_ID + CFG.oR.nextInt(GameValues.gvAiRivals.RESUME_LOOKING_FOR_ENEMY_AT_TURN_ID_RANDOM);
                }
                catch (Exception exception) {
                    CFG.exceptionStack(exception);
                    CFG.core.getCiv((int)n).civGD.resumeLookingForRivalAtTurnID = GameCalendar.TURNID + GameValues.gvAiRivals.RESUME_LOOKING_FOR_ENEMY_AT_TURN_ID + CFG.oR.nextInt(GameValues.gvAiRivals.RESUME_LOOKING_FOR_ENEMY_AT_TURN_ID_RANDOM);
                }
            } else {
                CFG.core.getCiv((int)n).civGD.resumeLookingForRivalAtTurnID = GameCalendar.TURNID + GameValues.gvAiRivals.RESUME_LOOKING_FOR_ENEMY_AT_TURN_ID + CFG.oR.nextInt(GameValues.gvAiRivals.RESUME_LOOKING_FOR_ENEMY_AT_TURN_ID_RANDOM);
            }
        }
    }

    public final void diplomacyActions_RivalCiv(int n) {
        if (GameCalendar.TURNID >= CFG.core.getCiv((int)n).civGD.resumeLookingForRivalAtTurnID) {
            int n2 = Math.min(CFG.oAI.MIN_NUM_OF_RIVALS, CFG.core.getCiv(n).getNumOfProvs()) - CFG.core.getCiv((int)n).civGD.civRivalsSize;
            if (n2 > 0) {
                if (!CFG.core.getCiv((int)n).civsInRange.isEmpty()) {
                    int n3;
                    ArrayList<AI_CivsInRange> arrayList = new ArrayList<AI_CivsInRange>();
                    for (n3 = CFG.core.getCiv((int)n).civsInRange.size() - 1; n3 >= 0; --n3) {
                        arrayList.add(CFG.core.getCiv((int)n).civsInRange.get(n3));
                    }
                    for (n3 = arrayList.size() - 1; n3 >= 0; --n3) {
                        if (AIPlaystyle.diplomacyActions_RivalCiv_IsRival(n, ((AI_CivsInRange)arrayList.get((int)n3)).iCivID)) {
                            arrayList.remove(n3);
                            continue;
                        }
                        if (!this.diplomacyActions_IsInfluenced(n, ((AI_CivsInRange)arrayList.get((int)n3)).iCivID)) continue;
                        arrayList.remove(n3);
                    }
                    if (!arrayList.isEmpty()) {
                        int n4;
                        int n5;
                        ArrayList<Float> arrayList2 = new ArrayList<Float>();
                        ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
                        float f = GameValues.gvAiRivals.OLD_RIVALS_BUDGET_MODIFIER + (float)CFG.oR.nextInt(GameValues.gvAiRivals.OLD_RIVALS_BUDGET_MODIFIER_RANDOM_1000) / 1000.0f;
                        float f2 = GameValues.gvAiRivals.OLD_RIVALS_CIV_SIZE_MODIFIER + (float)CFG.oR.nextInt(GameValues.gvAiRivals.OLD_RIVALS_CIV_SIZE_MODIFIER_RANDOM_1000) / 1000.0f;
                        float f3 = GameValues.gvAiRivals.OLD_RIVALS_DISTANCE_MODIFIER + GameValues.gvAiRivals.OLD_RIVALS_DISTANCE_RANK_MODIFIER * ((float)CFG.core.getCiv(n).getRankPos() / (float)CFG.core.getCivsSize());
                        int n6 = 0;
                        n6 = CFG.core.getCiv(n).getNumOfProvs() < GameValues.gvAiRivals.OLD_RIVALS_BUDGET_MODIFIER_2_SMALL_CIV_PROVINCES_BELOW || CFG.core.getCiv((int)n).iLeague > 6 ? (int)((float)CFG.core.getCiv((int)n).iBudget * (GameValues.gvAiRivals.OLD_RIVALS_BUDGET_MODIFIER_2_SMALL_CIV + (float)CFG.oR.nextInt(GameValues.gvAiRivals.OLD_RIVALS_BUDGET_MODIFIER_2_SMALL_CIV_RANDOM_100) / 100.0f)) : (int)((float)CFG.core.getCiv((int)n).iBudget * (GameValues.gvAiRivals.OLD_RIVALS_BUDGET_MODIFIER_2 + (float)CFG.oR.nextInt(GameValues.gvAiRivals.OLD_RIVALS_BUDGET_MODIFIER_2_RANDOM_100) / 100.0f));
                        int n7 = arrayList.size();
                        for (int i = 0; i < n7; ++i) {
                            arrayList2.add(Float.valueOf(this.diplomacyActions_RivalCiv_Score(n6, n, (AI_CivsInRange)arrayList.get(i), f, f2)));
                            arrayList3.add(i);
                        }
                        float f4 = CFG.gameAges.getAge_FogOfWarDiscovery_MetProvinces(GameCalendar.CURRENT_AGEID);
                        for (int i = arrayList.size() - 1; i >= 0; --i) {
                            arrayList2.set(i, Float.valueOf(((Float)arrayList2.get(i)).floatValue() * (1.0f + (-f3 + (GameValues.gvAiRivals.OLD_RIVALS_RANGE_AGGRESSION_BASE + (float)CFG.oR.nextInt(GameValues.gvAiRivals.OLD_RIVALS_RANGE_AGGRESSION_RANDOM_100) / 100.0f) * CFG.core.getCiv((int)((AI_CivsInRange)arrayList.get((int)i)).iCivID).civGD.civAggressionLevel) * ((AI_CivsInRange)arrayList.get((int)i)).fDistance / ((f4 + f4 * GameValues.gvAiRivals.OLD_RIVALS_DISTANCE_BONUS) * CFG.core.getCiv(n).getTechLevel()) + GameValues.gvAiRivals.OLD_RIVALS_RELATIONS_MODIFIER * (Math.min(CFG.core.getCivRelationOfCivB(n, ((AI_CivsInRange)arrayList.get((int)i)).iCivID), 0.0f) / 100.0f))));
                        }
                        ArrayList<Integer> arrayList4 = new ArrayList<Integer>();
                        while (!arrayList3.isEmpty() && arrayList4.size() < n2) {
                            n5 = 0;
                            for (n4 = arrayList3.size() - 1; n4 > 0; --n4) {
                                if (!(((Float)arrayList2.get((Integer)arrayList3.get(n4))).floatValue() > ((Float)arrayList2.get((Integer)arrayList3.get(n5))).floatValue())) continue;
                                n5 = n4;
                            }
                            arrayList4.add((Integer)arrayList3.get(n5));
                            arrayList3.remove(n5);
                        }
                        n5 = Math.min(CFG.oAI.MIN_NUM_OF_RIVALS + CFG.oR.nextInt(3), n2);
                        for (n4 = 0; n4 < arrayList.size() && n4 < n5; ++n4) {
                            int n8 = GameValues.gvRelationDecrease.SUSPEND_DIPLOMATIC_RELATIONS_MIN + CFG.oR.nextInt(GameValues.gvRelationDecrease.SUSPEND_DIPLOMATIC_RELATIONS_MAX - GameValues.gvRelationDecrease.SUSPEND_DIPLOMATIC_RELATIONS_MIN);
                            GameManager.decreaseRelation(n, ((AI_CivsInRange)arrayList.get((int)((Integer)arrayList4.get((int)n4)).intValue())).iCivID, n8);
                            CFG.core.getCiv((int)n).civGD.civRivals.add(new AI_Rival(((AI_CivsInRange)arrayList.get((int)((Integer)arrayList4.get((int)n4)).intValue())).iCivID, GameCalendar.TURNID + GameValues.gvAiRivals.END_OF_RIVALRY_AFTER_EXTRA_TURNS_BASE + CFG.oR.nextInt(GameValues.gvAiRivals.END_OF_RIVALRY_AFTER_EXTRA_TURNS_RANDOM)));
                            if (CFG.core.getCiv(((AI_CivsInRange)arrayList.get((int)((Integer)arrayList4.get((int)n4)).intValue())).iCivID).getIsPlayer()) {
                                CFG.core.getCiv((int)((AI_CivsInRange)arrayList.get((int)((Integer)arrayList4.get((int)n4)).intValue())).iCivID).getCivDiploGD().messageBox.addMessage(new Message_Rivals(n));
                            }
                            --n2;
                        }
                        CFG.core.getCiv((int)n).civGD.civRivalsSize = CFG.core.getCiv((int)n).civGD.civRivals.size();
                        if (n2 <= 0) {
                            CFG.core.getCiv((int)n).civGD.resumeLookingForRivalAtTurnID = GameCalendar.TURNID + GameValues.gvAiRivals.RESUME_LOOKING_FOR_ENEMY_AT_TURN_ID + CFG.oR.nextInt(GameValues.gvAiRivals.RESUME_LOOKING_FOR_ENEMY_AT_TURN_ID_RANDOM);
                        } else if (arrayList.size() - n5 > Math.min(CFG.oAI.MIN_NUM_OF_RIVALS, CFG.core.getCiv(n).getNumOfProvs()) - CFG.core.getCiv((int)n).civGD.civRivalsSize) {
                            CFG.core.getCiv((int)n).civGD.resumeLookingForRivalAtTurnID = GameCalendar.TURNID + GameValues.gvAiRivals.RESUME_LOOKING_FOR_ENEMY_AT_TURN_ID + CFG.oR.nextInt(GameValues.gvAiRivals.RESUME_LOOKING_FOR_ENEMY_AT_TURN_ID_RANDOM);
                        }
                    } else {
                        CFG.core.getCiv((int)n).civGD.resumeLookingForRivalAtTurnID = GameCalendar.TURNID + GameValues.gvAiRivals.RESUME_LOOKING_FOR_ENEMY_AT_TURN_ID + CFG.oR.nextInt(GameValues.gvAiRivals.RESUME_LOOKING_FOR_ENEMY_AT_TURN_ID_RANDOM);
                    }
                } else {
                    CFG.core.getCiv((int)n).civGD.resumeLookingForRivalAtTurnID = GameCalendar.TURNID + GameValues.gvAiRivals.RESUME_LOOKING_FOR_ENEMY_AT_TURN_ID + CFG.oR.nextInt(GameValues.gvAiRivals.RESUME_LOOKING_FOR_ENEMY_AT_TURN_ID_RANDOM);
                }
            } else {
                CFG.core.getCiv((int)n).civGD.resumeLookingForRivalAtTurnID = GameCalendar.TURNID + GameValues.gvAiRivals.RESUME_LOOKING_FOR_ENEMY_AT_TURN_ID + CFG.oR.nextInt(GameValues.gvAiRivals.RESUME_LOOKING_FOR_ENEMY_AT_TURN_ID_RANDOM);
            }
        }
    }

    public static final boolean diplomacyActions_RivalCiv_IsRival(int n, int n2) {
        for (int i = 0; i < CFG.core.getCiv((int)n).civGD.civRivalsSize; ++i) {
            if (CFG.core.getCiv((int)n).civGD.civRivals.get((int)i).iCivID != n2) continue;
            return true;
        }
        return false;
    }

    public final boolean diplomacyActions_IsInfluenced(int n, int n2) {
        Civilization civ = CFG.core.getCiv(n);
        synchronized (civ.civGD.civsToImproveRelationsWith) {
            for (int i = 0; i < civ.civGD.civsToImproveRelationsWith.size(); ++i) {
                if (civ.civGD.civsToImproveRelationsWith.get((int)i).iCivID != n2) continue;
                return true;
            }
        }
        return false;
    }

    public static void diplomacyActions_RivalCiv_Update() {
        for (int i = 1 + GameCalendar.TURNID % GameValues.gvAiRivals.UPDATE_RIVALRY_END_EVERY_X_TURNS; i < CFG.core.getCivsSize(); i += GameValues.gvAiRivals.UPDATE_RIVALRY_END_EVERY_X_TURNS) {
            AIPlaystyle.diplomacyActions_RivalCiv_Update(i);
        }
    }

    public static void diplomacyActions_RivalCiv_Update(int n) {
        for (int i = CFG.core.getCiv((int)n).civGD.civRivalsSize - 1; i >= 0; --i) {
            if (CFG.core.getCiv((int)n).civGD.civRivals.get((int)i).iUntilTurnID > GameCalendar.TURNID) continue;
            CFG.core.getCiv((int)n).civGD.civRivals.remove(i);
            CFG.core.getCiv((int)n).civGD.civRivalsSize = CFG.core.getCiv((int)n).civGD.civRivals.size();
            CFG.core.getCiv((int)n).civGD.resumeLookingForRivalAtTurnID = GameCalendar.TURNID;
        }
    }

    public final void diplomacyActions_InfluencedCiv_Update(int n) {
        synchronized (CFG.core.getCiv((int)n).civGD.civsToImproveRelationsWith) {
            for (int i = CFG.core.getCiv((int)n).civGD.civsToImproveRelationsWith.size() - 1; i >= 0; --i) {
                if (CFG.core.getCiv((int)n).civGD.civsToImproveRelationsWith.get((int)i).iUntilTurnID > GameCalendar.TURNID) continue;
                CFG.core.getCiv((int)n).civGD.civsToImproveRelationsWith.remove(i);
            }
            CFG.core.getCiv((int)n).civGD.civsToImproveRelationsWithSize = CFG.core.getCiv((int)n).civGD.civsToImproveRelationsWith.size();
        }
        CFG.core.getCiv((int)n).civGD.resumeLookingForFriendsAtTurnID = GameCalendar.TURNID;
    }

    public final float diplomacyActions_RivalCiv_Score(int n, int n2, AI_CivsInRange aI_CivsInRange, float f, float f2) {
        return f * (float)Math.min(n, CFG.core.getCiv((int)aI_CivsInRange.iCivID).iBudget) / (float)Math.max(n, CFG.core.getCiv((int)aI_CivsInRange.iCivID).iBudget) + f2 * (float)Math.min(CFG.core.getCiv(n2).getNumOfProvs(), CFG.core.getCiv(aI_CivsInRange.iCivID).getNumOfProvs()) / (float)Math.max(CFG.core.getCiv(n2).getNumOfProvs(), CFG.core.getCiv(aI_CivsInRange.iCivID).getNumOfProvs());
    }

    public final List<AI_CivsInRange> diplomacyActions_CivsInRange(int n) {
        int n2;
        ArrayList<AI_CivsInRange> arrayList = new ArrayList<AI_CivsInRange>();
        float f = 1.0f;
        float f2 = CFG.gameAges.getAge_FogOfWarDiscovery_MetProvinces(GameCalendar.CURRENT_AGEID);
        for (n2 = 1; n2 < n; ++n2) {
            if (CFG.core.getCiv(n2).getNumOfProvs() <= 0 || CFG.core.getCiv(n2).getCapitalProvID() <= 0 || !((f = Distance.getDistanceFromAToB_PercOfMax(CFG.core.getCiv(n).getCapitalProvID(), CFG.core.getCiv(n2).getCapitalProvID())) * GameValues.gvAiCivsInRange.CIVS_IN_RANGE_DISTANCE_MODIFIER < (f2 + f2 * GameValues.gvAiCivsInRange.CIVS_IN_RANGE_DISTANCE_EXTRA_MODIFIER) * CFG.core.getCiv(n).getTechLevel())) continue;
            arrayList.add(new AI_CivsInRange(n2, f));
        }
        for (n2 = n + 1; n2 < CFG.core.getCivsSize(); ++n2) {
            if (CFG.core.getCiv(n2).getNumOfProvs() <= 0 || CFG.core.getCiv(n2).getCapitalProvID() <= 0 || !((f = Distance.getDistanceFromAToB_PercOfMax(CFG.core.getCiv(n).getCapitalProvID(), CFG.core.getCiv(n2).getCapitalProvID())) * GameValues.gvAiCivsInRange.CIVS_IN_RANGE_DISTANCE_MODIFIER < (f2 + f2 * GameValues.gvAiCivsInRange.CIVS_IN_RANGE_DISTANCE_EXTRA_MODIFIER) * CFG.core.getCiv(n).getTechLevel())) continue;
            arrayList.add(new AI_CivsInRange(n2, f));
        }
        return arrayList;
    }

    public final void colonizeProvinces(int n) {
        block17: {
            if (GameCalendar.getColonizationOfWastelandIsEnabled() || GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES) {
                int n2;
                boolean bl = false;
                for (n2 = CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.size() - 1; n2 >= 0; --n2) {
                    if (CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.get((int)n2).MISSION_TYPE != CivArmyMission_Type.COLONIZE_PROVINCE) continue;
                    bl = true;
                    if (!CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.get(n2).canMakeAction(n, 0)) continue;
                    if (CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.get(n2).action(n)) {
                        CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.remove(n2);
                        CFG.core.getCiv((int)n).civGD.resumeColonizationCheckAtTurnID = Math.max(GameCalendar.TURNID + GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_X_TURNS_IN_PROGRESS + CFG.oR.nextInt(GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_X_TURNS_IN_PROGRESS_RANDOM), CFG.core.getCiv((int)n).civGD.resumeColonizationCheckAtTurnID);
                        continue;
                    }
                    if (CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.get((int)n2).iObsolete > 0) continue;
                    CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.remove(n2);
                    CFG.core.getCiv((int)n).civGD.resumeColonizationCheckAtTurnID = Math.max(GameCalendar.TURNID + GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_X_TURNS_IN_PROGRESS + CFG.oR.nextInt(GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_X_TURNS_IN_PROGRESS_RANDOM), CFG.core.getCiv((int)n).civGD.resumeColonizationCheckAtTurnID);
                }
                if (bl) {
                    return;
                }
                CFG.core.getCiv((int)n).civGD.iLockTreasury = 1;
                if (CFG.core.getCiv((int)n).civGD.resumeColonizationCheckAtTurnID > GameCalendar.TURNID) {
                    return;
                }
                if (!GameCalendar.getCanColonize_TechLevel(n) && CFG.core.getCiv(n).getTechLevel() / GameCalendar.COLONIZATION_TECH_LEVEL < 1.0f - GameValues.gvAiColonization.TECH_GAP_REDUCTION_FACTOR * Math.min((float)CFG.oAI.iNumOfColonizedProvcs / Math.min((float)(GameValues.gvAiColonization.BASE_COLONIZATION_DIVISOR + Math.min((CFG.core.getCiv(n).getRankPos() - 1) * GameValues.gvAiColonization.RANK_COLONIZATION_MULTIPLIER, GameValues.gvAiColonization.MAX_RANK_COLONIZATION_BONUS)), (float)CFG.core.getProvinSize() * GameValues.gvAiColonization.PROVINCE_SCALING_FACTOR), 1.0f)) {
                    CFG.core.getCiv((int)n).civGD.resumeColonizationCheckAtTurnID = Math.max(GameCalendar.TURNID + GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_X_TURNS_INSUFFICIENT_TECH + CFG.oR.nextInt(GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_X_TURNS_INSUFFICIENT_TECH_RANDOM), CFG.core.getCiv((int)n).civGD.resumeColonizationCheckAtTurnID);
                    return;
                }
                if (CFG.core.getCiv((int)n).iBudget < 1) {
                    CFG.core.getCiv((int)n).civGD.resumeColonizationCheckAtTurnID = Math.max(GameCalendar.TURNID + GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_X_TURNS_INSUFFICIENT_GOLD + CFG.oR.nextInt(GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_X_TURNS_INSUFFICIENT_GOLD_RANDOM), CFG.core.getCiv((int)n).civGD.resumeColonizationCheckAtTurnID);
                    return;
                }
                if ((float)GameManager.getColonizeCost_AI(n) / (float)CFG.core.getCiv((int)n).iBudget > GameValues.gvAiColonization.MAX_COLONIZATION_COST_TO_BUDGET_RATIO) {
                    CFG.core.getCiv((int)n).civGD.resumeColonizationCheckAtTurnID = Math.max(GameCalendar.TURNID + GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_TURNS_TOO_EXPENSIVE + CFG.oR.nextInt(GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_TURNS_TOO_EXPENSIVE_RANDOM), CFG.core.getCiv((int)n).civGD.resumeColonizationCheckAtTurnID);
                    return;
                }
                if ((float)CFG.core.getCiv(n).getRankPos() < Math.max((float)CFG.core.getCivsSize() * GameValues.gvAiColonization.CAN_COLONIZE_TOP_CIVS_PERCENT, (float)GameValues.gvAiColonization.CAN_COLONIZE_TOP_CIVS_LIMIT)) {
                    try {
                        if (CFG.core.getCiv(n).isAtWarC()) {
                            CFG.core.getCiv((int)n).civGD.resumeColonizationCheckAtTurnID = Math.max(GameCalendar.TURNID + GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_X_TURNS_AT_WAR + CFG.oR.nextInt(GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_X_TURNS_AT_WAR_RANDOM), CFG.core.getCiv((int)n).civGD.resumeColonizationCheckAtTurnID);
                            return;
                        }
                        n2 = 0;
                        if (GameCalendar.getColonizationOfWastelandIsEnabled()) {
                            n2 += CFG.oAI.lWastelandProvincesWithSeaAccess.size();
                            n2 += CFG.core.getCiv((int)n).bordersWithWastelandProvsID.size();
                        }
                        if (GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES) {
                            n2 += CFG.oAI.lNeutralProvincesWithSeaAccess.size();
                            n2 += CFG.core.getCiv((int)n).bordersWithNeutralProvcsID.size();
                        }
                        if (n2 <= 0) break block17;
                        boolean bl2 = true;
                        if (!CFG.core.getCiv((int)n).civGD.coloniesFounded.isEmpty()) {
                            bl2 = !this.colonizeProvinces_ExtendColony(n);
                            boolean bl3 = bl2;
                        }
                        if (bl2) {
                            this.colonizeProvinces_FoundNewColony(n);
                        }
                    }
                    catch (Exception exception) {
                        CFG.exceptionStack(exception);
                    }
                } else {
                    CFG.core.getCiv((int)n).civGD.resumeColonizationCheckAtTurnID = Math.max(GameCalendar.TURNID + GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_X_TURNS_INSUFFICIENT_TECH + CFG.oR.nextInt(GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_X_TURNS_INSUFFICIENT_TECH_RANDOM), CFG.core.getCiv((int)n).civGD.resumeColonizationCheckAtTurnID);
                }
            }
        }
    }

    public final void colonizeProvinces_FoundNewColony(int n) {
        int n2;
        int n3;
        boolean bl;
        int n4;
        ArrayList<AI_ProvinceValue> arrayList = new ArrayList<AI_ProvinceValue>();
        ArrayList<Boolean> arrayList2 = new ArrayList<Boolean>();
        for (n4 = 0; n4 < CFG.map.numOfBasins; ++n4) {
            arrayList2.add(false);
        }
        for (n4 = CFG.core.getCiv(n).getSeaAccess_Provinces_Size() - 1; n4 >= 0; --n4) {
            if (CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n4)).isOccupied()) continue;
            for (int i = 0; i < CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n4)).getNeighSeaProvincesSize(); ++i) {
                arrayList2.set(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n4)).getNeighSeaProvinces(i)).getBasinID(), true);
            }
        }
        for (n4 = CFG.oAI.lNeutralProvincesWithSeaAccess.size() - 1; n4 >= 0; --n4) {
            bl = false;
            for (n3 = 0; n3 < CFG.core.getProv(CFG.oAI.lNeutralProvincesWithSeaAccess.get(n4)).getNeighSeaProvincesSize(); ++n3) {
                if (!((Boolean)arrayList2.get(CFG.core.getProv(CFG.core.getProv(CFG.oAI.lNeutralProvincesWithSeaAccess.get(n4)).getNeighSeaProvinces(n3)).getBasinID())).booleanValue()) continue;
                bl = true;
                break;
            }
            if (!bl) continue;
            arrayList.add(new AI_ProvinceValue(CFG.oAI.lNeutralProvincesWithSeaAccess.get(n4)));
        }
        if (arrayList.isEmpty() && GameCalendar.getColonizationOfWastelandIsEnabled()) {
            for (n4 = CFG.oAI.lWastelandProvincesWithSeaAccess.size() - 1; n4 >= 0; --n4) {
                bl = false;
                for (n3 = 0; n3 < CFG.core.getProv(CFG.oAI.lWastelandProvincesWithSeaAccess.get(n4)).getNeighSeaProvincesSize(); ++n3) {
                    if (!((Boolean)arrayList2.get(CFG.core.getProv(CFG.core.getProv(CFG.oAI.lWastelandProvincesWithSeaAccess.get(n4)).getNeighSeaProvinces(n3)).getBasinID())).booleanValue()) continue;
                    bl = true;
                    break;
                }
                if (!bl) continue;
                arrayList.add(new AI_ProvinceValue(CFG.oAI.lWastelandProvincesWithSeaAccess.get(n4)));
            }
        }
        if (!arrayList.isEmpty() && CFG.core.getProv(n2 = ((AI_ProvinceValue)arrayList.get((int)CFG.oR.nextInt((int)arrayList.size()))).iProvinceID).getCivId() == 0) {
            CFG.core.getCiv((int)n).civGD.civPlans.addNewArmyMission(n2, new CivArmyMission_ColonizeProvince(n, n2));
            CFG.core.getCiv((int)n).civGD.declareWarCheckNextTurnID = Math.max(CFG.core.getCiv((int)n).civGD.declareWarCheckNextTurnID, GameCalendar.TURNID + (int)(((float)(GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_X_TURNS_AFTER_COLONIZATION + CFG.oR.nextInt(GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_X_TURNS_AFTER_COLONIZATION_RANDOM)) + (float)CFG.oR.nextInt(CFG.core.getCivsSize() + 1) / GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_X_TURNS_AFTER_COLONIZATION_SIZE_DIVISOR) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS)));
        }
    }

    public final boolean colonizeProvinces_ExtendColony(int n) {
        try {
            int n2;
            int n3;
            int n4;
            ArrayList<AI_ProvinceValue> arrayList = new ArrayList<AI_ProvinceValue>();
            for (n4 = CFG.core.getCiv((int)n).bordersWithNeutralProvcsID.size() - 1; n4 >= 0; --n4) {
                if (CFG.core.getProv(CFG.core.getCiv((int)n).bordersWithNeutralProvcsID.get(n4)).getCivId() != 0) continue;
                arrayList.add(new AI_ProvinceValue(CFG.core.getCiv((int)n).bordersWithNeutralProvcsID.get(n4), this.colonizeProvinces_ExtendColony_Score(n, CFG.core.getCiv((int)n).bordersWithNeutralProvcsID.get(n4))));
            }
            for (n4 = CFG.core.getCiv((int)n).bordersWithWastelandProvsID.size() - 1; n4 >= 0; --n4) {
                if (CFG.core.getProv(CFG.core.getCiv((int)n).bordersWithWastelandProvsID.get(n4)).getCivId() != 0) continue;
                arrayList.add(new AI_ProvinceValue(CFG.core.getCiv((int)n).bordersWithWastelandProvsID.get(n4), this.colonizeProvinces_ExtendColony_Score(n, CFG.core.getCiv((int)n).bordersWithWastelandProvsID.get(n4))));
            }
            for (n4 = CFG.core.getCiv((int)n).civGD.coloniesFounded.size() - 1; n4 >= 0; --n4) {
                for (n3 = 0; n3 < CFG.core.getProv(CFG.core.getCiv((int)n).civGD.coloniesFounded.get((int)n4).iProvinceID).getNeighProvincesSize(); ++n3) {
                    if (CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv((int)n).civGD.coloniesFounded.get((int)n4).iProvinceID).getNeighProvinces(n3)).getCivId() != 0 && CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv((int)n).civGD.coloniesFounded.get((int)n4).iProvinceID).getNeighProvinces(n3)).getWastelandLvl() < 0) continue;
                    arrayList.add(new AI_ProvinceValue(CFG.core.getProv(CFG.core.getCiv((int)n).civGD.coloniesFounded.get((int)n4).iProvinceID).getNeighProvinces(n3), this.colonizeProvinces_ExtendColony_Score(n, CFG.core.getProv(CFG.core.getCiv((int)n).civGD.coloniesFounded.get((int)n4).iProvinceID).getNeighProvinces(n3))));
                }
            }
            for (n4 = 0; n4 < CFG.core.getCiv(n).getNumOfProvs(); ++n4) {
                for (n3 = 0; n3 < CFG.core.getProv(CFG.core.getCiv(n).getProvID(n4)).getNeighSeaProvincesSize(); ++n3) {
                    for (n2 = 0; n2 < CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getProvID(n4)).getNeighSeaProvinces(n3)).getNeighProvincesSize(); ++n2) {
                        if (CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getProvID(n4)).getNeighSeaProvinces(n3)).getNeighProvinces(n2)).getSeaProv() || CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getProvID(n4)).getNeighSeaProvinces(n3)).getNeighProvinces(n2)).getCivId() != 0) continue;
                        arrayList.add(new AI_ProvinceValue(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getProvID(n4)).getNeighSeaProvinces(n3)).getNeighProvinces(n2), (int)((float)this.colonizeProvinces_ExtendColony_Score(n, CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getProvID(n4)).getNeighSeaProvinces(n3)).getNeighProvinces(n2)) * (CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getProvID(n4)).getNeighSeaProvinces(n3)).getNeighProvinces(n2)).getNeighProvincesSize() == 0 ? 1.0f : 0.625f))));
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                for (n4 = arrayList.size() - 1; n4 >= 0; --n4) {
                    for (n3 = 0; n3 < CFG.core.getProv(((AI_ProvinceValue)arrayList.get((int)n4)).iProvinceID).getNeighSeaProvincesSize(); ++n3) {
                        for (n2 = 0; n2 < CFG.core.getProv(CFG.core.getProv(((AI_ProvinceValue)arrayList.get((int)n4)).iProvinceID).getNeighSeaProvinces(n3)).getNeighProvincesSize(); ++n2) {
                            if (CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(((AI_ProvinceValue)arrayList.get((int)n4)).iProvinceID).getNeighSeaProvinces(n3)).getNeighProvinces(n2)).getSeaProv() || CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(((AI_ProvinceValue)arrayList.get((int)n4)).iProvinceID).getNeighSeaProvinces(n3)).getNeighProvinces(n2)).getNeighProvincesSize() != 0 || CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(((AI_ProvinceValue)arrayList.get((int)n4)).iProvinceID).getNeighSeaProvinces(n3)).getNeighProvinces(n2)).getCivId() != 0) continue;
                            arrayList.add(new AI_ProvinceValue(CFG.core.getProv(CFG.core.getProv(((AI_ProvinceValue)arrayList.get((int)n4)).iProvinceID).getNeighSeaProvinces(n3)).getNeighProvinces(n2), this.colonizeProvinces_ExtendColony_Score(n, CFG.core.getProv(CFG.core.getProv(((AI_ProvinceValue)arrayList.get((int)n4)).iProvinceID).getNeighSeaProvinces(n3)).getNeighProvinces(n2))));
                        }
                    }
                }
                int n5 = 0;
                for (int i = arrayList.size() - 1; i > 0; --i) {
                    if (((AI_ProvinceValue)arrayList.get((int)n5)).iValue < ((AI_ProvinceValue)arrayList.get((int)i)).iValue) {
                        n5 = i;
                        continue;
                    }
                    if (((AI_ProvinceValue)arrayList.get((int)n5)).iValue != ((AI_ProvinceValue)arrayList.get((int)i)).iValue || CFG.oR.nextInt(100) >= 50) continue;
                    n5 = i;
                }
                if (CFG.core.getProv(((AI_ProvinceValue)arrayList.get((int)n5)).iProvinceID).getCivId() == 0) {
                    if (CFG.gameAction.canColonizieWasteland_BorderOrArmy(((AI_ProvinceValue)arrayList.get((int)n5)).iProvinceID, n)) {
                        CFG.core.getCiv((int)n).civGD.civPlans.addNewArmyMission(((AI_ProvinceValue)arrayList.get((int)n5)).iProvinceID, new CivArmyMission_ColonizeProvince_Just(n, ((AI_ProvinceValue)arrayList.get((int)n5)).iProvinceID));
                        CFG.core.getCiv((int)n).civGD.declareWarCheckNextTurnID = Math.max(CFG.core.getCiv((int)n).civGD.declareWarCheckNextTurnID, GameCalendar.TURNID + (int)(((float)(GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_X_TURNS_AFTER_COLONIZATION + CFG.oR.nextInt(GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_X_TURNS_AFTER_COLONIZATION_RANDOM)) + (float)CFG.oR.nextInt(CFG.core.getCivsSize() + 1) / GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_X_TURNS_AFTER_COLONIZATION_SIZE_DIVISOR) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS)));
                    } else {
                        CFG.core.getCiv((int)n).civGD.civPlans.addNewArmyMission(((AI_ProvinceValue)arrayList.get((int)n5)).iProvinceID, new CivArmyMission_ColonizeProvince(n, ((AI_ProvinceValue)arrayList.get((int)n5)).iProvinceID));
                        CFG.core.getCiv((int)n).civGD.declareWarCheckNextTurnID = Math.max(CFG.core.getCiv((int)n).civGD.declareWarCheckNextTurnID, GameCalendar.TURNID + (int)(((float)(GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_X_TURNS_AFTER_COLONIZATION + CFG.oR.nextInt(GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_X_TURNS_AFTER_COLONIZATION_RANDOM)) + (float)CFG.oR.nextInt(CFG.core.getCivsSize() + 1) / GameValues.gvAiColonization.RESUME_COLONIZATION_AFTER_X_TURNS_AFTER_COLONIZATION_SIZE_DIVISOR) / Math.max(0.01f, GameCalendar.AI_AGGRESSIVENESS)));
                    }
                    return true;
                }
            }
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
        return false;
    }

    public final int colonizeProvinces_ExtendColony_Score(int n, int n2) {
        float f = 1.0f;
        if (CFG.core.getProv(n2).getNeighProvincesSize() > 0) {
            int n3 = 0;
            for (int i = 0; i < CFG.core.getProv(n2).getNeighProvincesSize(); ++i) {
                if (CFG.core.getProv(CFG.core.getProv(n2).getNeighProvinces(i)).getCivId() != n) continue;
                ++n3;
                f += GameValues.gvAiColonization.COLONIZATION_SCORE_PER_OWN_NEIGH_PROVINCE;
            }
            f += CFG.core.getCiv((int)n).civGD.civPers.COLONIZATION_OWN_PROVINCES * ((float)n3 / (float)Math.max(CFG.core.getProv(n2).getNeighProvincesSize(), 1));
        }
        f += CFG.core.getCiv((int)n).civGD.civPers.COLONIZATION_DISTANCE * (1.0f - Distance.getDistanceFromAToB_PercOfMax(CFG.core.getCiv(n).getCapitalProvID(), n2));
        if (CFG.core.getProv(n2).getNeighSeaProvincesSize() > 0) {
            f += CFG.core.getCiv((int)n).civGD.civPers.COLONIZATION_SEA;
        }
        return (int)(f += CFG.core.getCiv((int)n).civGD.civPers.COLONIZATION_GROWTH_RATE * CFG.core.getProv(n2).getGrowthRate_Pop());
    }

    private boolean provinceBordersEnemyAtWar(int nCivID, int nProvinceID) {
        for (int i = 0; i < CFG.core.getProv(nProvinceID).getNeighProvincesSize(); ++i) {
            int neighProvinceID = CFG.core.getProv(nProvinceID).getNeighProvinces(i);
            for (int j = 0; j < CFG.core.getProv(neighProvinceID).getCivsSize(); ++j) {
                int neighCivID = CFG.core.getProv(neighProvinceID).getCivId(j);
                if (neighCivID > 0 && CFG.core.getCivsAtWar(nCivID, neighCivID)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean civHasEnemyWarBorder(int nCivID) {
        for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
            int provinceID = CFG.core.getCiv(nCivID).getProvID(i);
            if (CFG.core.getProv(provinceID).getCivId() == nCivID && this.provinceBordersEnemyAtWar(nCivID, provinceID)) {
                return true;
            }
        }
        return false;
    }

    private int getDistanceToEnemyWarBorder(int nCivID, int nProvinceID, int maxDistance) {
        if (this.provinceBordersEnemyAtWar(nCivID, nProvinceID)) {
            return 0;
        }
        ArrayList<Integer> was = new ArrayList<Integer>();
        ArrayList<Integer> recentlyAdded = new ArrayList<Integer>();
        recentlyAdded.add(nProvinceID);
        was.add(nProvinceID);
        for (int distance = 1; distance <= maxDistance && !recentlyAdded.isEmpty(); ++distance) {
            ArrayList<Integer> current = new ArrayList<Integer>(recentlyAdded);
            recentlyAdded.clear();
            for (int i = 0; i < current.size(); ++i) {
                int currentProvinceID = current.get(i);
                for (int j = 0; j < CFG.core.getProv(currentProvinceID).getNeighProvincesSize(); ++j) {
                    int neighProvinceID = CFG.core.getProv(currentProvinceID).getNeighProvinces(j);
                    if (was.contains(neighProvinceID) || CFG.core.getProv(neighProvinceID).getCivId() != nCivID || CFG.core.getProv(neighProvinceID).isOccupied()) {
                        continue;
                    }
                    if (this.provinceBordersEnemyAtWar(nCivID, neighProvinceID)) {
                        return distance;
                    }
                    was.add(neighProvinceID);
                    recentlyAdded.add(neighProvinceID);
                }
            }
        }
        return -1;
    }

    private boolean isAtWarOnlyWithWeakRebels(int nCivID) {
        if (!CFG.core.getCiv(nCivID).isAtWarC()) {
            return false;
        }
        long civMilitary = CFG.core.getCiv(nCivID).getNumberOfUnits();
        boolean foundRebels = false;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (i == nCivID) continue;
            if (CFG.core.getCivsAtWar(nCivID, i)) {
                if (CFG.core.getCiv(i).getIdeology() != CFG.ideologiesMgr.REBELS_ID) {
                    return false;
                }
                foundRebels = true;
                long rebelMilitary = CFG.core.getCiv(i).getNumberOfUnits();
                if (rebelMilitary >= civMilitary / 2L) {
                    return false;
                }
            }
        }
        return foundRebels;
    }

    private boolean isValidAIWarRecruitProvince(int nCivID, int nProvinceID) {
        if (nProvinceID < 0 || CFG.core.getProv(nProvinceID).getCivId() != nCivID || CFG.core.getProv(nProvinceID).isOccupied() || Core.ISIP(nProvinceID) || CFG.core.getCiv(nCivID).isRAIP(nProvinceID) >= 0) {
            return false;
        }
        return true;
    }

    private List<AI_NeighProvinces> filterAIWarRecruitProvinces(int nCivID, List<AI_NeighProvinces> list) {
        List<AI_NeighProvinces> out = new ArrayList<AI_NeighProvinces>();
        for (int i = 0; i < list.size(); ++i) {
            if (this.isValidAIWarRecruitProvince(nCivID, list.get(i).iProvinceID)) {
                out.add(list.get(i));
            }
        }
        return out;
    }

    private AI_NeighProvinces getBestAIWarRecruitProvince(int nCivID, int frontProvinceID, int maxRange) {
        List<AI_NeighProvinces> list = this.filterAIWarRecruitProvinces(nCivID, CFG.oAI.getAllNeighboringProvincesInRange_RecruitAtWAr(frontProvinceID, nCivID, maxRange, true, false, new ArrayList<AI_NeighProvinces>(), new ArrayList<Integer>()));
        if (list.isEmpty()) {
            return null;
        }
        int bestID = 0;
        int bestRecruitable = CFG.gameAction.gMARY(list.get(0).iProvinceID, nCivID);
        for (int i = 1; i < list.size(); ++i) {
            int recruitable = CFG.gameAction.gMARY(list.get(i).iProvinceID, nCivID);
            if (bestRecruitable >= recruitable) continue;
            bestID = i;
            bestRecruitable = recruitable;
        }
        return list.get(bestID);
    }

    public final void recruitMilitary_MinSpending(int n) {
        try {
            Civilization civ = CFG.core.getCiv(n);
            if (!civ.isAtWarC() && !civ.civGD.civPlans.isPreparingForTheWar()) {
                this.billionaireRecruitment(n);
                return;
            }
            long n2 = (long)((float)CFG.core.getCiv((int)n).iBudget * this.getMinMilitarySpending(n) - (float)CFG.core.getCiv((int)n).iBudget * CFG.core.getCiv((int)n).iMilitaryUpkeep_PERC);
            if (n2 > 0 && !CFG.core.getCiv((int)n).lFrontLines.isEmpty()) {
                int n3;
                int n4;
                int n5 = 1;
                float f = 1.0f;
                ArrayList<AI_ProvinceInfo> arrayList = new ArrayList<AI_ProvinceInfo>();
                for (n4 = CFG.core.getCiv((int)n).lFrontLines.size() - 1; n4 >= 0; --n4) {
                    for (n3 = CFG.core.getCiv((int)n).lFrontLines.get((int)n4).lProvinces.size() - 1; n3 >= 0; --n3) {
                        boolean bl = false;
                        for (int i = arrayList.size() - 1; i >= 0; --i) {
                            if (((AI_ProvinceInfo)arrayList.get((int)i)).iProvinceID != CFG.core.getCiv((int)n).lFrontLines.get((int)n4).lProvinces.get(n3)) continue;
                            bl = true;
                            break;
                        }
                        if (bl) continue;
                        arrayList.add(new AI_ProvinceInfo(CFG.core.getCiv((int)n).lFrontLines.get((int)n4).lProvinces.get(n3), this.getPotential_BasedOnNeighboringProvs(CFG.core.getCiv((int)n).lFrontLines.get((int)n4).lProvinces.get(n3), n), CFG.gameAction.gMARY(CFG.core.getCiv((int)n).lFrontLines.get((int)n4).lProvinces.get(n3))));
                    }
                }
                if (CFG.core.getCiv(n).getCapitalProvID() >= 0 && CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).getNeighSeaProvincesSize() > 0 && CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).getCivId() == n) {
                    n4 = 0;
                    for (n3 = arrayList.size() - 1; n3 >= 0; --n3) {
                        if (((AI_ProvinceInfo)arrayList.get((int)n3)).iProvinceID != CFG.core.getCiv(n).getCapitalProvID()) continue;
                        n4 = 1;
                        break;
                    }
                    if (n4 == 0) {
                        arrayList.add(new AI_ProvinceInfo(CFG.core.getCiv(n).getCapitalProvID(), this.getPotential_BasedOnNeighboringProvs(CFG.core.getCiv(n).getCapitalProvID(), n), CFG.gameAction.gMARY(CFG.core.getCiv(n).getCapitalProvID())));
                    }
                }
                if (!arrayList.isEmpty()) {
                    int n6;
                    int n7;
                    int n8;
                    long maxArmyCount = 1L;
                    float f2 = 1.0f;
                    float f3 = 1.0f;
                    ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
                    int n9 = arrayList.size();
                    int n10 = 0;
                    for (n8 = 0; n8 < n9; ++n8) {
                        if (((AI_ProvinceInfo)arrayList.get((int)n8)).iValue > f) {
                            f = ((AI_ProvinceInfo)arrayList.get((int)n8)).iValue;
                        }
                        if (CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n8)).iProvinceID).getDangerLevel_WithArmy() > n5) {
                            n5 = CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n8)).iProvinceID).getDangerLevel_WithArmy();
                        }
                        if ((float)CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n8)).iProvinceID).getRegion_NumOfProvinces() > f2) {
                            f2 = CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n8)).iProvinceID).getRegion_NumOfProvinces();
                        }
                        if ((float)CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n8)).iProvinceID).getPotentialRegion() > f3) {
                            f3 = CFG.core.getProv(arrayList.get((int)n8).iProvinceID).getPotentialRegion();
                        }
                        arrayList2.add(n10 += this.getMovingArmyToProvinceID(n, arrayList.get((int)n8).iProvinceID));
                        if (CFG.core.getProv(arrayList.get((int)n8).iProvinceID).getArmyID(0) + (long)n10 <= maxArmyCount) continue;
                        maxArmyCount = CFG.core.getProv(arrayList.get((int)n8).iProvinceID).getArmyID(0) + (long)n10;
                    }
                    long n8_l = (long)((float)n2 / (CFG.gameUpdate.getMilitaryUpkeep_WithoutDefensivePosition(((AI_ProvinceInfo)arrayList.get((int)0)).iProvinceID, 1000, n) / 1000.0f));
                    int n11 = arrayList.size();
                    for (int i = 0; i < n11; ++i) {
                        ((AI_ProvinceInfo)arrayList.get((int)i)).iValue = this.getValue_PositionOfArmy(n, arrayList, i, (Integer)arrayList2.get(i), f, f3, n5, maxArmyCount, n8_l, f2);
                    }
                    ArrayList<AI_ProvinceInfo> arrayList3 = new ArrayList<AI_ProvinceInfo>();
                    while (!arrayList.isEmpty()) {
                        n7 = 0;
                        int n12 = arrayList.size();
                        for (int i = 1; i < n12; ++i) {
                            if (!(arrayList.get((int)n7).iValue < arrayList.get((int)i).iValue)) continue;
                            n7 = i;
                        }
                        arrayList3.add(arrayList.get(n7));
                        arrayList.remove(n7);
                    }
                    n7 = Math.max(1, Math.min((CFG.core.getCiv(n).getMovemPoints() - CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE_OWN_PROVINCE) / CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_RECRUIT, CFG.core.getCiv(n).getNumOfProvs()));
                    ArrayList<AI_ProvinceInfo> arrayList4 = new ArrayList<AI_ProvinceInfo>();
                    float f4 = 0.0f;
                    for (n6 = 0; n6 < n7 && n6 < arrayList3.size(); ++n6) {
                        arrayList4.add((AI_ProvinceInfo)arrayList3.get(n6));
                        f4 += ((AI_ProvinceInfo)arrayList3.get((int)n6)).iValue;
                    }
                    long currentGold = CFG.core.getCiv(n).getGold();
                    for (int i = 0; i < arrayList4.size(); ++i) {
                        int n13 = (int)((float)Math.min(n8_l, (float)currentGold / (float)(CFG.core.getProv(((AI_ProvinceInfo)arrayList4.get((int)i)).iProvinceID).getLvlOfArmoury() > 0 ? GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT - 1 : GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT)) * ((AI_ProvinceInfo)arrayList4.get((int)i)).iValue / f4);
                        List<AI_NeighProvinces> list = CFG.oAI.getAllNeighboringProvincesInRange_Recruit(((AI_ProvinceInfo)arrayList4.get((int)i)).iProvinceID, n, 5, true, false, new ArrayList<AI_NeighProvinces>(), new ArrayList<Integer>());
                        java.util.List<AI_NeighProvinces> filteredList = this.filterAIWarRecruitProvinces(n, list);
                        if (!filteredList.isEmpty()) {
                            int n16 = CFG.oR.nextInt(filteredList.size());
                            int n15 = (int)((float)Math.min(n8_l, Math.min(CFG.gameAction.gMARY(filteredList.get((int)n16).iProvinceID), (float)n6 / (float)(CFG.core.getProv(filteredList.get((int)n16).iProvinceID).getLvlOfArmoury() > 0 ? GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT - 1 : GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT))) * ((AI_ProvinceInfo)arrayList4.get((int)i)).iValue / f4);
                            CFG.core.getCiv(n).recruitArmy_AI(filteredList.get((int)n16).iProvinceID, (long)n15);
                            long n14 = CFG.core.getCiv(n).getRecruitArmy_BasedOnProvinceID(filteredList.get((int)n16).iProvinceID);
                            if (n14 > 0) {
                                CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.add(new CivArmyMission_RegroupAfterRecruitment(n, filteredList.get((int)n16).iProvinceID, ((AI_ProvinceInfo)arrayList4.get((int)i)).iProvinceID, n14));
                            }
                        }
                    }
                }
            }
            this.billionaireRecruitment(n);
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
    }

    public final void billionaireRecruitment(int n) {
        Civilization civ = CFG.core.getCiv(n);
        
        boolean preparingForWar = false;
        for (int i = 1; i < CFG.core.getCivsSize(); i++) {
            if (civ.civGD.civPlans.isPreparingForTheWar(i)) {
                preparingForWar = true;
                break;
            }
        }
        
        long income = Math.max(1L, CFG.core.getCiv((int)n).iBudget);
        long currentUpkeep = CFG.gameUpdate.getMilitaryUpkeep_Total(n);
        float targetPerc = civ.isAtWarC() ? civ.civGD.civPers.MIN_MILITARY_SPENDINGS_WAR : this.getMinMilitarySpending(n);
        long targetUpkeep = (long)(income * targetPerc);

        if (!civ.isAtWarC() && !preparingForWar && currentUpkeep >= targetUpkeep) {
            return;
        }

        long maxSpend = civ.isAtWarC() || preparingForWar ? civ.getGold() : (long)((float)civ.getGold() * 0.4f);
        long spent = 0L;
        if (maxSpend > 0L) {
            java.util.ArrayList<Integer> shuffledProvinces = new java.util.ArrayList<Integer>();
            for (int i = 0; i < civ.getNumOfProvs(); i++) {
                shuffledProvinces.add(civ.getProvID(i));
            }
            java.util.Collections.shuffle(shuffledProvinces, CFG.oR);
            for (int i = 0; i < shuffledProvinces.size(); i++) {
                int provinceID = shuffledProvinces.get(i);
                if (CFG.core.getProv(provinceID).isOccupied() || Core.ISIP(provinceID)) continue;
                if (civ.isAtWarC() && !this.isValidAIWarRecruitProvince(n, provinceID)) continue;

                long recruitable = CFG.gameAction.gMARY(provinceID);
                if (recruitable > 0) {
                    long cost = Math.max(1L, (long)CFG.gCARR(provinceID));
                    long toRecruit = Math.min(recruitable, Math.min(civ.getGold(), maxSpend - spent) / cost);
                    
                    if (!civ.isAtWarC() && !preparingForWar) {
                        float upkeepPerUnit = CFG.gameUpdate.getMilitaryUpkeepP(provinceID, 1, n);
                        long neededUnits = (long)((targetUpkeep - currentUpkeep) / Math.max(0.001f, upkeepPerUnit));
                        if (neededUnits <= 0) break;
                        toRecruit = Math.min(toRecruit, neededUnits);
                    }

                    if (toRecruit > 0) {
                        civ.recruitArmy_AI(provinceID, toRecruit);
                        spent += toRecruit * cost;
                        civ.civGD.aiNoDisbandUntilTurnID = Math.max(civ.civGD.aiNoDisbandUntilTurnID, GameCalendar.TURNID + 10);
                        currentUpkeep += (long)(toRecruit * CFG.gameUpdate.getMilitaryUpkeepP(provinceID, 1, n));
                        if (civ.getMovemPoints() < CFG.ideologiesMgr.getIdeologyID(civ.getIdeology()).COST_OF_RECRUIT) return;
                        if (!civ.isAtWarC() && !preparingForWar && currentUpkeep >= targetUpkeep) return;
                        if (civ.getGold() <= 0L || spent >= maxSpend) return;
                    }
                }
            }
        }
    }

    public final void missileProduction(int n, boolean isAtWarOrPrep) {
        if (!CFG.settingsGD.MISSILES) return;
        Civilization civ = CFG.core.getCiv(n);
        long income = CFG.gameUpdate.getIncome(n);
        long missileCost = age.of.civilizations2.jakowski.lukasz.MapA.MissileManager.calculateMissileCost(n, civ.civGD.iMissileTier);
        
        if (missileCost > income * 0.5f) return;
        
        long maxSpend = (long)(income * (isAtWarOrPrep ? 0.2f : 0.1f));
        long spent = 0;
        while (spent < maxSpend && civ.getGold() >= missileCost) {
            if (age.of.civilizations2.jakowski.lukasz.MapA.MissileManager.buildMissile(n)) {
                spent += missileCost;
                missileCost = age.of.civilizations2.jakowski.lukasz.MapA.MissileManager.calculateMissileCost(n, civ.civGD.iMissileTier);
            } else break;
        }
    }

    public final void billionaireBuilding(int n) {
        Civilization civ = CFG.core.getCiv(n);
        if (civ.getGold() < 1000L) return;

        
        boolean preparingForWar = false;
        for (int i = 1; i < CFG.core.getCivsSize(); i++) {
            if (civ.civGD.civPlans.isPreparingForTheWar(i)) {
                preparingForWar = true;
                break;
            }
        }
        if (civ.isAtWarC() || preparingForWar) return;

        
        if (!civ.isAtWarC() && civ.civGD.iMissileTier < 3) {
            long upgradeCost = (long)(civ.incomeTaxation * (civ.civGD.iMissileTier == 1 ? 25.0f : 62.5f));
            if (civ.getGold() >= upgradeCost * 2) { 
                age.of.civilizations2.jakowski.lukasz.MapA.MissileManager.upgradeMissileTier(n);
            }
        }
        
        long totalGoldAtStart = civ.getGold();
        long maxSpendBuildings = (long)(totalGoldAtStart * 0.50f);
        long maxSpendInvesting = (long)(totalGoldAtStart * 0.20f);
        long spentBuildings = 0;
        long spentInvesting = 0;
        
        ArrayList<Integer> sortedProvs = new ArrayList<Integer>();
        for (int i = 0; i < civ.getNumOfProvs(); i++) {
            sortedProvs.add(civ.getProvID(i));
        }
        
        
        java.util.Collections.sort(sortedProvs, new java.util.Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Long.compare(CFG.core.getProv(b).getEco(), CFG.core.getProv(a).getEco());
            }
        });
        
        for (Integer pID : sortedProvs) {
            if ((spentBuildings >= maxSpendBuildings && spentInvesting >= maxSpendInvesting) || civ.getMovemPoints() < 2) break;
            
            age.of.civilizations2.jakowski.lukasz.Province p = CFG.core.getProv(pID);
            if (p.isOccupied()) continue;
            
            int rand = CFG.oR.nextInt(100);
            boolean actionDone = false;

            if (spentBuildings < maxSpendBuildings) {
                
                if (rand < 45) {
                    if (p.getBasinID() >= 0 || p.getNeighSeaProvincesSize() > 0) {
                        if (civ.getTechLevel() >= age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.getPort_TechLevel(1) && p.getLvlOfPort() < age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.getPort_MaxLevel()) {
                             long cost = age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.getPort_BuildCost(p.getLvlOfPort() + 1, pID);
                             if (age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.buildPort(pID, n)) {
                                 spentBuildings += cost;
                                 actionDone = true;
                             }
                        }
                    }
                    if (!actionDone && civ.getTechLevel() >= age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.getWorkshop_TechLevel(1) && p.getLvlOfWorkshop() < age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.getWorkshop_MaxLevel_CanBuild(n)) {
                        long cost = age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.getWorkshop_BuildCost(p.getLvlOfWorkshop() + 1, pID);
                        if (age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.buildWorkshop(pID, n)) {
                            spentBuildings += cost;
                            actionDone = true;
                        }
                    }
                }
                
                
                if (!actionDone && rand < 40) {
                    if (civ.getTechLevel() >= age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.getFort_TechLevel(1) && p.getLvlOfFort() < age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.getFort_MaxLevel_CanBuild(n)) {
                        long cost = age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.getFort_BuildCost(p.getLvlOfFort() + 1, pID);
                        if (age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.buildFort(pID, n)) {
                            spentBuildings += cost;
                            actionDone = true;
                        }
                    }
                    if (!actionDone && civ.getTechLevel() >= age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.getTower_TechLevel(1) && p.getLvlOfWatchTower() < age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.getTower_MaxLevel_CanBuild(n)) {
                        long cost = age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.getTower_BuildCost(p.getLvlOfWatchTower() + 1, pID);
                        if (age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.buildTower(pID, n)) {
                            spentBuildings += cost;
                            actionDone = true;
                        }
                    }
                }

                
                if (!actionDone && rand < 30 && age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.canBuildAirDefense(pID)) {
                    long cost = age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.getAirDefense_BuildCost(p.provGD.iAirDefense + 1, pID);
                    if (age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.buildAirDefense(pID, n)) {
                        spentBuildings += cost;
                        actionDone = true;
                    }
                }
                
                
                if (!actionDone && rand < 20) {
                    if (civ.getTechLevel() >= age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.getFarm_TechLevel(1) && p.getLvlOfFarm() < age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.getFarm_MaxLevel_CanBuild(n)) {
                        long cost = age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.getFarm_BuildCost(p.getLvlOfFarm() + 1, pID);
                        if (age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager.buildFarm(pID, n)) {
                            spentBuildings += cost;
                            actionDone = true;
                        }
                    }
                }
            }
            
            
            if (civ.getGold() > 0L && !civ.isInvestedDev(pID)) {
                long investAmount = GameManager.investMaxDevGold(pID, n);
                if (investAmount > 0) {
                    if (GameManager.investDevelopment(pID, n, investAmount)) {
                        spentInvesting += investAmount;
                    }
                }
            }
        }
    }

    public final void regroupArmy_AtPeace(int n) {
        try {
            if (CFG.core.getCiv((int)n).civGD.iRegroupArmyAtPeace_CheckTurnID <= GameCalendar.TURNID) {
                long n2;
                int n3;
                ArrayList<AI_RegoupArmyData> arrayList = new ArrayList<AI_RegoupArmyData>();
                ArrayList<AI_RegoupArmyData> arrayList2 = new ArrayList<AI_RegoupArmyData>();
                ArrayList<AI_RegoupArmyData> arrayList3 = new ArrayList<AI_RegoupArmyData>();
                ArrayList<AI_RegoupArmyData> arrayList4 = new ArrayList<AI_RegoupArmyData>();
                int n4 = 0;
                boolean isPlayerControlledVassal = false;
                int puppetOfCiv = CFG.core.getCiv(n).getPuppetOfCiv();
                if (puppetOfCiv >= 0 && puppetOfCiv != n) {
                    for (int p = 0; p < CFG.core.getPlayersSize(); ++p) {
                        if (CFG.core.getPlayer(p).getCivId() == puppetOfCiv) {
                            isPlayerControlledVassal = !CFG.core.getPlayer(p).playerGD.VASSALS_INDEPENDENT_ARMY;
                            break;
                        }
                    }
                }
                for (n3 = 0; n3 < CFG.core.getCiv((int)n).armiesPositionSize; ++n3) {
                    n2 = this.getRegroupArmy_NumOfUnits(n, CFG.core.getCiv((int)n).armiesPosition.get(n3));
                    if (n2 <= 0) continue;
                    if (CFG.core.getProv(CFG.core.getCiv((int)n).armiesPosition.get(n3)).getSeaProv()) {
                        arrayList3.add(new AI_RegoupArmyData(CFG.core.getCiv((int)n).armiesPosition.get(n3), n2));
                        continue;
                    }
                    if (CFG.core.getProv(CFG.core.getCiv((int)n).armiesPosition.get(n3)).getCivId() != n) {
                        if (!isPlayerControlledVassal) {
                            arrayList2.add(new AI_RegoupArmyData(CFG.core.getCiv((int)n).armiesPosition.get(n3), n2));
                        }
                        continue;
                    }
                    if (CFG.core.getProv(CFG.core.getCiv((int)n).armiesPosition.get(n3)).getDangerLvl() == 0) {
                        arrayList.add(new AI_RegoupArmyData(CFG.core.getCiv((int)n).armiesPosition.get(n3), n2));
                        n4 += n2;
                        continue;
                    }
                    arrayList4.add(new AI_RegoupArmyData(CFG.core.getCiv((int)n).armiesPosition.get(n3), n2));
                }
                for (n3 = 0; n3 < CFG.core.getCiv(n).getArmyInAnotherProvinceSize(); ++n3) {
                    n2 = this.getRegroupArmy_NumOfUnits(n, CFG.core.getCiv(n).getArmyInAnotherProviP(n3));
                    if (n2 <= 0) continue;
                    if (CFG.core.getProv(CFG.core.getCiv(n).getArmyInAnotherProviP(n3)).getSeaProv()) {
                        arrayList3.add(new AI_RegoupArmyData(CFG.core.getCiv(n).getArmyInAnotherProviP(n3), n2));
                        continue;
                    }
                    if (CFG.core.getProv(CFG.core.getCiv(n).getArmyInAnotherProviP(n3)).getCivId() != n) {
                        if (!isPlayerControlledVassal) {
                            arrayList2.add(new AI_RegoupArmyData(CFG.core.getCiv(n).getArmyInAnotherProviP(n3), n2));
                        }
                        continue;
                    }
                    if (CFG.core.getProv(CFG.core.getCiv(n).getArmyInAnotherProviP(n3)).getDangerLvl() == 0) {
                        arrayList.add(new AI_RegoupArmyData(CFG.core.getCiv(n).getArmyInAnotherProviP(n3), n2));
                        n4 += n2;
                        continue;
                    }
                    arrayList4.add(new AI_RegoupArmyData(CFG.core.getCiv((int)n).armiesPosition.get(n3), n2));
                }
                if (arrayList.size() == CFG.core.getCiv(n).getNumOfProvs()) {
                    arrayList.clear();
                }
                while (!(arrayList.isEmpty() && arrayList3.isEmpty() && arrayList2.isEmpty())) {
                    int n5;
                    int n6 = -1;
                    long n7 = 0L;
                    int n8 = -1;
                    for (n5 = arrayList.size() - 1; n5 >= 0; --n5) {
                        if (n6 >= 0 && n7 >= ((AI_RegoupArmyData)arrayList.get((int)n5)).iArmy) continue;
                        n6 = n5;
                        n7 = ((AI_RegoupArmyData)arrayList.get((int)n5)).iArmy;
                        n8 = 0;
                    }
                    for (n5 = arrayList3.size() - 1; n5 >= 0; --n5) {
                        if (n6 >= 0 && n7 >= ((AI_RegoupArmyData)arrayList3.get((int)n5)).iArmy) continue;
                        n6 = n5;
                        n7 = ((AI_RegoupArmyData)arrayList3.get((int)n5)).iArmy;
                        n8 = 1;
                    }
                    for (n5 = arrayList2.size() - 1; n5 >= 0; --n5) {
                        if (n6 >= 0 && n7 >= ((AI_RegoupArmyData)arrayList2.get((int)n5)).iArmy) continue;
                        n6 = n5;
                        n7 = ((AI_RegoupArmyData)arrayList2.get((int)n5)).iArmy;
                        n8 = 2;
                    }
                    if (GameCalendar.TURNID >= CFG.core.getCiv((int)n).civGD.nextArmyRestRegroupment_TurnID && (CFG.core.getCiv(n).isAtWarC() || CFG.core.getCiv((int)n).civGD.civPlans.isPreparingForTheWar())) {
                        for (n5 = arrayList4.size() - 1; n5 >= 0; --n5) {
                            if (n6 >= 0 && n7 >= ((AI_RegoupArmyData)arrayList4.get((int)n5)).iArmy) continue;
                            n6 = n5;
                            n7 = ((AI_RegoupArmyData)arrayList4.get((int)n5)).iArmy;
                            n8 = 3;
                        }
                    }
                    if (n6 >= 0 && n8 >= 0 && n7 > 0) {
                        switch (n8) {
                            case 0: {
                                this.regroupArmy_AtPeace_InOwnTerritory_WithoutDanger(n, (AI_RegoupArmyData)arrayList.get(n6), false);
                                arrayList.remove(n6);
                                break;
                            }
                            case 1: {
                                this.regroupArmy_AtPeace_AtSea(n, (AI_RegoupArmyData)arrayList3.get(n6));
                                arrayList3.remove(n6);
                                break;
                            }
                            case 2: {
                                this.regroupArmy_AtPeace_InAnotherTerritory(n, (AI_RegoupArmyData)arrayList2.get(n6));
                                arrayList2.remove(n6);
                                break;
                            }
                            case 3: {
                                this.regroupArmy_AtPeace_InOwnTerritory_WithoutDanger(n, (AI_RegoupArmyData)arrayList4.get(n6), true);
                                arrayList4.remove(n6);
                                CFG.core.getCiv((int)n).civGD.nextArmyRestRegroupment_TurnID = Math.max(CFG.core.getCiv((int)n).civGD.nextArmyRestRegroupment_TurnID, GameCalendar.TURNID + 3 + CFG.oR.nextInt(9));
                            }
                        }
                    }
                    if (CFG.core.getCiv(n).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE && CFG.core.getCiv(n).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE_OWN_PROVINCE) continue;
                }
                if (arrayList.size() == CFG.core.getCiv(n).getNumOfProvs() || !arrayList3.isEmpty()) {
                    CFG.core.getCiv((int)n).civGD.iRegroupArmyAtPeace_CheckTurnID = GameCalendar.TURNID + 4 + CFG.oR.nextInt(4);
                }
            }
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
        catch (StackOverflowError stackOverflowError) {
            CFG.exceptionStack(stackOverflowError);
        }
    }

    public final boolean regroupArmy_AtPeace_AtSea(int n, AI_RegoupArmyData aI_RegoupArmyData) {
        int n2;
        ArrayList<AI_ProvinceInfo> arrayList = new ArrayList<AI_ProvinceInfo>();
        for (n2 = 0; n2 < CFG.core.getProv(aI_RegoupArmyData.iProvinceID).getNeighProvincesSize(); ++n2) {
            if (CFG.core.getProv(CFG.core.getProv(aI_RegoupArmyData.iProvinceID).getNeighProvinces(n2)).getCivId() != n) continue;
            arrayList.add(new AI_ProvinceInfo(CFG.core.getProv(aI_RegoupArmyData.iProvinceID).getNeighProvinces(n2), this.getPotential_BasedOnNeighboringProvs(CFG.core.getProv(aI_RegoupArmyData.iProvinceID).getNeighProvinces(n2), n), 1));
        }
        if (!arrayList.isEmpty()) {
            int n3;
            int n4;
            int n5;
            int n6;
            int n7 = 1;
            float f = 1.0f;
            float f2 = 1.0f;
            float f3 = 1.0f;
            long maxArmyCount = 1L;
            ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
            int n9 = arrayList.size();
            int n10 = 0;
            float n8 = 0.0f;
            for (n6 = 0; n6 < n9; ++n6) {
                if (((AI_ProvinceInfo)arrayList.get((int)n6)).iValue > f) {
                    f = ((AI_ProvinceInfo)arrayList.get((int)n6)).iValue;
                }
                if (CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n6)).iProvinceID).getDangerLevel_WithArmy() > n8) {
                    n8 = CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n6)).iProvinceID).getDangerLevel_WithArmy();
                }
                if ((float)CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n6)).iProvinceID).getRegion_NumOfProvinces() > f2) {
                    f2 = CFG.core.getProv(arrayList.get((int)n6).iProvinceID).getRegion_NumOfProvinces();
                }
                if ((float)CFG.core.getProv(arrayList.get((int)n6).iProvinceID).getPotentialRegion() > f3) {
                    f3 = CFG.core.getProv(arrayList.get((int)n6).iProvinceID).getPotentialRegion();
                }
                arrayList2.add(n10 += this.getMovingArmyToProvinceID(n, arrayList.get((int)n6).iProvinceID));
                if (CFG.core.getProv(arrayList.get((int)n6).iProvinceID).getArmyID(0) + (long)n10 <= maxArmyCount) continue;
                maxArmyCount = CFG.core.getProv(arrayList.get((int)n6).iProvinceID).getArmyID(0) + (long)n10;
            }
            n9 = arrayList.size();
            for (n6 = 0; n6 < n9; ++n6) {
                ((AI_ProvinceInfo)arrayList.get((int)n6)).iValue = this.getValue_PositionOfArmy(n, arrayList, n6, (Integer)arrayList2.get(n6), f, f3, (int)n8, maxArmyCount, aI_RegoupArmyData.iArmy, aI_RegoupArmyData.iArmy);
            }
            ArrayList<AI_ProvinceInfo> arrayList3 = new ArrayList<AI_ProvinceInfo>();
            while (!arrayList.isEmpty()) {
                int n11 = 0;
                n5 = arrayList.size();
                for (int i = 1; i < n5; ++i) {
                    if (!(((AI_ProvinceInfo)arrayList.get((int)n11)).iValue < arrayList.get((int)i).iValue)) continue;
                    n11 = i;
                }
                arrayList3.add((AI_ProvinceInfo)arrayList.get(n11));
                arrayList.remove(n11);
            }
            float f4 = Math.max((float)aI_RegoupArmyData.iArmy / (float)CFG.core.getCiv(n).getNumberOfUnits(), 0.01f);
            n5 = 1;
            if (GameValues.gvAiArmy.REGROUP_AT_PEACE_MAX_ONE_MOVE_IF_PERC_OF_ARMY > f4) {
                n5 = 1;
            } else {
                n5 = Math.max(1, Math.min((CFG.core.getCiv(n).getMovemPoints() - CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE) / (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE * 2), 1 + CFG.oR.nextInt(3)));
                n5 = f4 > 0.54f ? Math.min(n5, 4) : (f4 > 0.34f ? Math.min(n5, 3) : (f4 > 0.14f ? Math.min(n5, 2) : Math.min(n5, 1)));
            }
            ArrayList<AI_ProvinceInfo> arrayList4 = new ArrayList<AI_ProvinceInfo>();
            float f5 = 0.0f;
            for (n4 = 0; n4 < n5 && n4 < arrayList3.size(); ++n4) {
                arrayList4.add((AI_ProvinceInfo)arrayList3.get(n4));
                f5 += ((AI_ProvinceInfo)arrayList3.get((int)n4)).iValue;
            }
            for (n4 = 0; n4 < arrayList4.size() && (n3 = (int)Math.ceil((float)aI_RegoupArmyData.iArmy * ((AI_ProvinceInfo)arrayList4.get((int)n4)).iValue / f5)) > 0; ++n4) {
                RegroupArmy_AtPeace regroupArmy_AtPeace = new RegroupArmy_AtPeace(n, aI_RegoupArmyData.iProvinceID, ((AI_ProvinceInfo)arrayList4.get((int)n4)).iProvinceID);
                if (regroupArmy_AtPeace.getRouteSize() <= 0) continue;
                if (regroupArmy_AtPeace.getRouteSize() == 1) {
                    if (!CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, ((AI_ProvinceInfo)arrayList4.get((int)n4)).iProvinceID, n3, n, true, false)) continue;
                    continue;
                }
                if (!CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, regroupArmy_AtPeace.getRoute(0), n3, n, true, false)) continue;
                regroupArmy_AtPeace.setFromProvinceID(regroupArmy_AtPeace.getRoute(0));
                regroupArmy_AtPeace.removeRoute(0);
                regroupArmy_AtPeace.setNumOfUnits(n3);
                CFG.core.getCiv(n).addRegroupArmy(regroupArmy_AtPeace);
            }
            return true;
        }
        block7: for (n2 = CFG.core.getCiv(n).getSeaAccess_Provinces_Size() - 1; n2 >= 0; --n2) {
            for (int i = 0; i < CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n2)).getNeighSeaProvincesSize(); ++i) {
                if (CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n2)).getNeighSeaProvinces(i)).getBasinID() != CFG.core.getProv(aI_RegoupArmyData.iProvinceID).getBasinID()) continue;
                arrayList.add(new AI_ProvinceInfo(CFG.core.getCiv(n).getSeaAccessProvinces().get(n2), this.getPotential_BasedOnNeighboringProvs(CFG.core.getCiv(n).getSeaAccessProvinces().get(n2), n), 1));
                continue block7;
            }
        }
        if (!arrayList.isEmpty()) {
            RegroupArmy_AtPeace regroupArmy_AtPeace;
            int n12;
            long n13 = 1L;
            float f = 1.0f;
            float f6 = 1.0f;
            float f7 = 1.0f;
            int n14 = 1;
            ArrayList<Integer> arrayList5 = new ArrayList<Integer>();
            int n15 = arrayList.size();
            int n16 = 0;
            for (n12 = 0; n12 < n15; ++n12) {
                if (((AI_ProvinceInfo)arrayList.get((int)n12)).iValue > f) {
                    f = ((AI_ProvinceInfo)arrayList.get((int)n12)).iValue;
                }
                if (CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n12)).iProvinceID).getDangerLevel_WithArmy() > n14) {
                    n14 = CFG.core.getProv(arrayList.get((int)n12).iProvinceID).getDangerLevel_WithArmy();
                }
                if ((float)CFG.core.getProv(arrayList.get((int)n12).iProvinceID).getRegion_NumOfProvinces() > f6) {
                    f6 = CFG.core.getProv(arrayList.get((int)n12).iProvinceID).getRegion_NumOfProvinces();
                }
                if ((float)CFG.core.getProv(arrayList.get((int)n12).iProvinceID).getPotentialRegion() > f7) {
                    f7 = CFG.core.getProv(arrayList.get((int)n12).iProvinceID).getPotentialRegion();
                }
                arrayList5.add(n16 += this.getMovingArmyToProvinceID(n, arrayList.get((int)n12).iProvinceID));
                if (CFG.core.getProv(arrayList.get((int)n12).iProvinceID).getArmyID(0) + (long)n16 <= n13) continue;
                n13 = CFG.core.getProv(arrayList.get((int)n12).iProvinceID).getArmyID(0) + (long)n16;
            }
            n15 = arrayList.size();
            for (n12 = 0; n12 < n15; ++n12) {
                ((AI_ProvinceInfo)arrayList.get((int)n12)).iValue = this.getValue_PositionOfArmy(n, arrayList, n12, (Integer)arrayList5.get(n12), f, f7, n14, n13, aI_RegoupArmyData.iArmy, aI_RegoupArmyData.iArmy);
            }
            ArrayList<AI_ProvinceInfo> arrayList6 = new ArrayList<AI_ProvinceInfo>();
            if (!arrayList.isEmpty()) {
                int n17 = 0;
                int n18 = arrayList.size();
                for (int i = 1; i < n18; ++i) {
                    if (!(arrayList.get((int)n17).iValue < arrayList.get((int)i).iValue)) continue;
                    n17 = i;
                }
                arrayList6.add(arrayList.get(n17));
                arrayList.remove(n17);
            }
            if ((regroupArmy_AtPeace = new RegroupArmy_AtPeace(n, aI_RegoupArmyData.iProvinceID, ((AI_ProvinceInfo)arrayList6.get((int)0)).iProvinceID)).getRouteSize() > 0) {
                if (regroupArmy_AtPeace.getRouteSize() == 1) {
                    if (!CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, ((AI_ProvinceInfo)arrayList6.get((int)0)).iProvinceID, aI_RegoupArmyData.iArmy, n, true, false)) {
                        
                    }
                } else if (CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, regroupArmy_AtPeace.getRoute(0), aI_RegoupArmyData.iArmy, n, true, false)) {
                    regroupArmy_AtPeace.setFromProvinceID(regroupArmy_AtPeace.getRoute(0));
                    regroupArmy_AtPeace.removeRoute(0);
                    regroupArmy_AtPeace.setNumOfUnits(aI_RegoupArmyData.iArmy);
                    CFG.core.getCiv(n).addRegroupArmy(regroupArmy_AtPeace);
                }
            }
            return true;
        }
        if (CFG.core.getCiv(n).getCapitalProvID() >= 0 && CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).getCivId() == n) {
            RegroupArmy_AtPeace regroupArmy_AtPeace = new RegroupArmy_AtPeace(n, aI_RegoupArmyData.iProvinceID, CFG.core.getCiv(n).getCapitalProvID());
            if (regroupArmy_AtPeace.getRouteSize() > 0) {
                if (regroupArmy_AtPeace.getRouteSize() == 1) {
                    if (!CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, CFG.core.getCiv(n).getCapitalProvID(), aI_RegoupArmyData.iArmy, n, true, false)) {
                        
                    }
                } else if (CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, regroupArmy_AtPeace.getRoute(0), aI_RegoupArmyData.iArmy, n, true, false)) {
                    regroupArmy_AtPeace.setFromProvinceID(regroupArmy_AtPeace.getRoute(0));
                    regroupArmy_AtPeace.removeRoute(0);
                    regroupArmy_AtPeace.setNumOfUnits(aI_RegoupArmyData.iArmy);
                    CFG.core.getCiv(n).addRegroupArmy(regroupArmy_AtPeace);
                } else {
                    CFG.gameAction.disbandArmy(aI_RegoupArmyData.iProvinceID, aI_RegoupArmyData.iArmy, n);
                }
            } else {
                CFG.gameAction.disbandArmy(aI_RegoupArmyData.iProvinceID, aI_RegoupArmyData.iArmy, n);
            }
        } else {
            CFG.gameAction.disbandArmy(aI_RegoupArmyData.iProvinceID, aI_RegoupArmyData.iArmy, n);
        }
        return true;
    }

    public final boolean regroupArmy_AtPeace_InAnotherTerritory(int n, AI_RegoupArmyData aI_RegoupArmyData) {
        try {
            float f = Math.max((float)aI_RegoupArmyData.iArmy / (float)CFG.core.getCiv(n).getNumberOfUnits(), 0.01f);
            List<AI_NeighProvinces> list = CFG.oAI.getAllNeighboringProvincesInRange_OnlyOwn_Clear(aI_RegoupArmyData.iProvinceID, n, CFG.core.getCiv((int)n).civGD.civPers.REGROUP_AT_PEACE_MAX_PROVINCES + CFG.core.getCiv(n).getNumOfProvs() / 15, false, false, new ArrayList<AI_NeighProvinces>(), new ArrayList<Integer>());
            if (!list.isEmpty()) {
                int n2;
                int n3;
                int n4 = CFG.core.getCiv(n).getMovemPoints() / CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE;
                int n5 = n4 = f > 0.275f ? Math.min(n4, 2) : Math.min(n4, 1);
                if (CFG.settingsGD.AI_GROUP_UNITS) {
                    n4 = 1;
                }
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
                for (n3 = list.size() - 1; n3 >= 0; --n3) {
                    arrayList2.add(n3);
                }
                while (!arrayList2.isEmpty()) {
                    n3 = 0;
                    for (n2 = arrayList2.size() - 1; n2 > 0; --n2) {
                        if (CFG.core.getProv(list.get((int)((Integer)arrayList2.get((int)n3)).intValue()).iProvinceID).getPotential() >= CFG.core.getProv(list.get((int)((Integer)arrayList2.get((int)n2)).intValue()).iProvinceID).getPotential()) continue;
                        n3 = n2;
                    }
                    arrayList.add((Integer)arrayList2.get(n3));
                    arrayList2.remove(n3);
                }
                n3 = 0;
                for (n2 = 0; n2 < n4 && n2 < arrayList.size(); ++n2) {
                    n3 += CFG.core.getProv(list.get((int)((Integer)arrayList.get((int)n2)).intValue()).iProvinceID).getPotential();
                }
                int n6 = -1;
                for (int i = 0; i < n4 && i < arrayList.size() && aI_RegoupArmyData.iArmy > 0; ++i) {
                    RegroupArmy_AtPeace regroupArmy_AtPeace = new RegroupArmy_AtPeace(n, aI_RegoupArmyData.iProvinceID, list.get((int)((Integer)arrayList.get((int)i)).intValue()).iProvinceID);
                    if (regroupArmy_AtPeace.getRouteSize() > 0) {
                        long n7 = i == n4 || i == arrayList.size() - 1 ? aI_RegoupArmyData.iArmy : (long)Math.ceil((float)aI_RegoupArmyData.iArmy * ((float)CFG.core.getProv(list.get((int)((Integer)arrayList.get((int)i)).intValue()).iProvinceID).getPotential() / (float)n3));
                        aI_RegoupArmyData.iArmy -= n7;
                        if (n7 <= 0) break;
                        if (!CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, regroupArmy_AtPeace.getRoute(0), n7, n, true, false)) continue;
                        if (regroupArmy_AtPeace.getRouteSize() > 1) {
                            CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.add(new CivArmyMission_RegroupAfterRecruitment(n, regroupArmy_AtPeace.getRoute(0), list.get((int)((Integer)arrayList.get((int)i)).intValue()).iProvinceID, n7));
                        }
                        n6 = i;
                        continue;
                    }
                    if (n6 < 0 || (regroupArmy_AtPeace = new RegroupArmy_AtPeace(n, aI_RegoupArmyData.iProvinceID, list.get((int)((Integer)arrayList.get((int)n6)).intValue()).iProvinceID)).getRouteSize() <= 0 || !CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, regroupArmy_AtPeace.getRoute(0), aI_RegoupArmyData.iArmy, n, true, false)) continue;
                    if (regroupArmy_AtPeace.getRouteSize() > 1) {
                        CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.add(new CivArmyMission_RegroupAfterRecruitment(n, regroupArmy_AtPeace.getRoute(0), list.get((int)((Integer)arrayList.get((int)n6)).intValue()).iProvinceID, aI_RegoupArmyData.iArmy));
                    }
                    return true;
                }
                if (n6 >= 0) {
                    return true;
                }
            } else if (CFG.core.getCiv(n).getCapitalProvID() >= 0 && CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).getCivId() == n) {
                RegroupArmy_AtPeace regroupArmy_AtPeace = new RegroupArmy_AtPeace(n, aI_RegoupArmyData.iProvinceID, CFG.core.getCiv(n).getCapitalProvID());
                if (regroupArmy_AtPeace.getRouteSize() > 0) {
                    if (regroupArmy_AtPeace.getRouteSize() == 1) {
                        if (!CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, CFG.core.getCiv(n).getCapitalProvID(), aI_RegoupArmyData.iArmy, n, true, false)) {
                            
                        }
                    } else if (CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, regroupArmy_AtPeace.getRoute(0), aI_RegoupArmyData.iArmy, n, true, false)) {
                        regroupArmy_AtPeace.setFromProvinceID(regroupArmy_AtPeace.getRoute(0));
                        regroupArmy_AtPeace.removeRoute(0);
                        regroupArmy_AtPeace.setNumOfUnits(aI_RegoupArmyData.iArmy);
                        CFG.core.getCiv(n).addRegroupArmy(regroupArmy_AtPeace);
                    }
                } else {
                    CFG.gameAction.disbandArmy(aI_RegoupArmyData.iProvinceID, aI_RegoupArmyData.iArmy, n);
                }
            } else {
                CFG.gameAction.disbandArmy(aI_RegoupArmyData.iProvinceID, aI_RegoupArmyData.iArmy, n);
            }
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
        catch (StackOverflowError stackOverflowError) {
            CFG.exceptionStack(stackOverflowError);
        }
        return false;
    }

    public final boolean regroupArmy_AtPeace_InOwnTerritory_WithoutDanger(int n, AI_RegoupArmyData aI_RegoupArmyData, boolean bl) {
        try {
            Serializable serializable;
            int n2;
            float f = Math.max((float)aI_RegoupArmyData.iArmy / (float)CFG.core.getCiv(n).getNumberOfUnits(), 0.01f);
            if (CFG.settingsGD.AI_GROUP_UNITS && CFG.core.getCiv(n).getBordersWithEnemy() > 0 && !CFG.core.getProv(aI_RegoupArmyData.iProvinceID).getBordersWithEnemy() && this.regroupArmy_AtPeace_ToOwnedBorder(n, aI_RegoupArmyData)) {
                return true;
            }
            try {
                if (CFG.core.getCiv(n).getCivRegion(CFG.core.getProv(aI_RegoupArmyData.iProvinceID).getCivRegionID()).getProvincesSize() > 1) {
                    int n3;
                    int n4 = 1;
                    float f2 = 1.0f;
                    ArrayList<AI_ProvinceInfo> arrayList = new ArrayList<AI_ProvinceInfo>();
                    for (n2 = CFG.core.getCiv((int)n).lFrontLines.size() - 1; n2 >= 0; --n2) {
                        try {
                            int n5;
                            if (CFG.core.getProv(CFG.core.getCiv((int)n).lFrontLines.get((int)n2).lProvinces.get(0)).getCivRegionID() != CFG.core.getProv(aI_RegoupArmyData.iProvinceID).getCivRegionID() && (!CFG.settingsGD.AI_GROUP_UNITS || Distance.getDistanceFromAToB_PercOfMax(aI_RegoupArmyData.iProvinceID, n5 = CFG.core.getCiv((int)n).lFrontLines.get((int)n2).lProvinces.get(0).intValue()) > 0.15f || ((RegroupArmy)(serializable = new RegroupArmy_AtPeace(n, aI_RegoupArmyData.iProvinceID, n5))).getRouteSize() <= 0 || ((RegroupArmy)serializable).getRouteSize() > 4)) continue;
                            for (n5 = CFG.core.getCiv((int)n).lFrontLines.get((int)n2).lProvinces.size() - 1; n5 >= 0; --n5) {
                                boolean bl2 = false;
                                for (n3 = arrayList.size() - 1; n3 >= 0; --n3) {
                                    if (((AI_ProvinceInfo)arrayList.get((int)n3)).iProvinceID != CFG.core.getCiv((int)n).lFrontLines.get((int)n2).lProvinces.get(n5)) continue;
                                    bl2 = true;
                                    break;
                                }
                                if (bl2) continue;
                                arrayList.add(new AI_ProvinceInfo(CFG.core.getCiv((int)n).lFrontLines.get((int)n2).lProvinces.get(n5), this.getPotential_BasedOnNeighboringProvs(CFG.core.getCiv((int)n).lFrontLines.get((int)n2).lProvinces.get(n5), n), 1));
                            }
                            continue;
                        }
                        catch (Exception exception) {
                            
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        int n6;
                        int n7;
                        int n8;
                        long n9 = 1L;
                        float f3 = 1.0f;
                        float f4 = 1.0f;
                        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
                        int n10 = arrayList.size();
                        long n11 = 0L;
                        for (n3 = 0; n3 < n10; ++n3) {
                            if (((AI_ProvinceInfo)arrayList.get((int)n3)).iValue > f2) {
                                f2 = ((AI_ProvinceInfo)arrayList.get((int)n3)).iValue;
                            }
                            if (CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n3)).iProvinceID).getDangerLevel_WithArmy() > n4) {
                                n4 = CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n3)).iProvinceID).getDangerLevel_WithArmy();
                            }
                            if ((float)CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n3)).iProvinceID).getRegion_NumOfProvinces() > f3) {
                                f3 = CFG.core.getProv(arrayList.get((int)n3).iProvinceID).getRegion_NumOfProvinces();
                            }
                            if ((float)CFG.core.getProv(arrayList.get((int)n3).iProvinceID).getPotentialRegion() > f4) {
                                f4 = CFG.core.getProv(arrayList.get((int)n3).iProvinceID).getPotentialRegion();
                            }
                            arrayList2.add((int)(n11 += this.getMovingArmyToProvinceID(n, arrayList.get((int)n3).iProvinceID)));
                            if (CFG.core.getProv(arrayList.get((int)n3).iProvinceID).getArmyID(0) + n11 <= n9) continue;
                            n9 = CFG.core.getProv(arrayList.get((int)n3).iProvinceID).getArmyID(0) + n11;
                        }
                        n10 = arrayList.size();
                        for (n3 = 0; n3 < n10; ++n3) {
                            ((AI_ProvinceInfo)arrayList.get((int)n3)).iValue = this.getValue_PositionOfArmy(n, arrayList, n3, (Integer)arrayList2.get(n3), f2, f4, n4, n9, aI_RegoupArmyData.iArmy, f3);
                        }
                        ArrayList<AI_ProvinceInfo> arrayList3 = new ArrayList<AI_ProvinceInfo>();
                        while (!arrayList.isEmpty()) {
                            n8 = 0;
                            int n12 = arrayList.size();
                            for (int i = 1; i < n12; ++i) {
                                if (!(((AI_ProvinceInfo)arrayList.get((int)n8)).iValue < arrayList.get((int)i).iValue)) continue;
                                n8 = i;
                            }
                            arrayList3.add(arrayList.get(n8));
                            arrayList.remove(n8);
                        }
                        n8 = 1;
                        int n13 = bl ? Math.max(1, Math.min((CFG.core.getCiv(n).getMovemPoints() - CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE) / CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE_OWN_PROVINCE, Math.min(CFG.core.getCiv(n).getNumOfProvs(), 2 + CFG.oR.nextInt(3)))) : (n8 = GameValues.gvAiArmy.REGROUP_AT_PEACE_MAX_ONE_MOVE_IF_PERC_OF_ARMY > f ? 1 : Math.max(1, Math.min((CFG.core.getCiv(n).getMovemPoints() - CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE) / CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE_OWN_PROVINCE, Math.min(CFG.core.getCiv(n).getNumOfProvs(), 2 + CFG.oR.nextInt(3)))));
                        if (CFG.settingsGD.AI_GROUP_UNITS) {
                            n8 = Math.max(1, Math.min(n8, 2));
                        }
                        ArrayList<AI_ProvinceInfo> arrayList4 = new ArrayList<AI_ProvinceInfo>();
                        float f5 = 0.0f;
                        for (n7 = 0; n7 < n8 && n7 < arrayList3.size(); ++n7) {
                            arrayList4.add((AI_ProvinceInfo)arrayList3.get(n7));
                            f5 += ((AI_ProvinceInfo)arrayList3.get((int)n7)).iValue;
                        }
                        for (n7 = 0; n7 < arrayList4.size() && (n6 = (int)Math.ceil((float)aI_RegoupArmyData.iArmy * ((AI_ProvinceInfo)arrayList4.get((int)n7)).iValue / f5)) > 0; ++n7) {
                            RegroupArmy_AtPeace regroupArmy_AtPeace = new RegroupArmy_AtPeace(n, aI_RegoupArmyData.iProvinceID, ((AI_ProvinceInfo)arrayList4.get((int)n7)).iProvinceID);
                            if (regroupArmy_AtPeace.getRouteSize() <= 0) continue;
                            if (regroupArmy_AtPeace.getRouteSize() == 1) {
                                if (!CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, ((AI_ProvinceInfo)arrayList4.get((int)n7)).iProvinceID, n6, n, true, false)) continue;
                                continue;
                            }
                            if (!CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, regroupArmy_AtPeace.getRoute(0), n6, n, true, false)) continue;
                            regroupArmy_AtPeace.setFromProvinceID(regroupArmy_AtPeace.getRoute(0));
                            regroupArmy_AtPeace.removeRoute(0);
                            regroupArmy_AtPeace.setNumOfUnits(n6);
                            CFG.core.getCiv(n).addRegroupArmy(regroupArmy_AtPeace);
                        }
                        return true;
                    }
                }
            }
            catch (NullPointerException nullPointerException) {
                
            }
            List<AI_NeighProvinces> list = CFG.oAI.getAllNeighboringProvincesInRange_OnlyOwn_Clear(aI_RegoupArmyData.iProvinceID, n, Math.max(CFG.core.getCiv((int)n).civGD.civPers.REGROUP_AT_PEACE_MAX_PROVINCES, CFG.core.getCiv(n).getNumOfProvs() / 10), false, false, new ArrayList<AI_NeighProvinces>(), new ArrayList<Integer>());
            if (!list.isEmpty()) {
                int n14 = CFG.core.getCiv(n).getMovemPoints() / CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE;
                int n15 = f > 0.375f ? Math.min(n14, 4) : (f > 0.25f ? Math.min(n14, 3) : (n14 = f > 0.1f ? Math.min(n14, 2) : Math.min(n14, 1)));
                if (CFG.settingsGD.AI_GROUP_UNITS) {
                    n14 = 1;
                }
                boolean bl3 = false;
                for (n2 = list.size() - 1; n2 >= 0; --n2) {
                    if (CFG.core.getProv(list.get((int)n2).iProvinceID).getDangerLvl() <= 0) continue;
                    bl3 = true;
                    break;
                }
                if (bl3) {
                    int n16;
                    serializable = new ArrayList();
                    ArrayList<Integer> arrayList = new ArrayList<Integer>();
                    for (n16 = list.size() - 1; n16 >= 0; --n16) {
                        arrayList.add(n16);
                    }
                    while (!arrayList.isEmpty()) {
                        n16 = 0;
                        for (int i = arrayList.size() - 1; i > 0; --i) {
                            if (CFG.core.getProv(list.get((int)((Integer)arrayList.get((int)n16)).intValue()).iProvinceID).getDangerLevel_WithArmy() >= CFG.core.getProv(list.get((int)((Integer)arrayList.get((int)i)).intValue()).iProvinceID).getDangerLevel_WithArmy()) continue;
                            n16 = i;
                        }
                        ((ArrayList)serializable).add((Integer)arrayList.get(n16));
                        arrayList.remove(n16);
                    }
                    n16 = 0;
                    for (int i = 0; i < n14 && i < ((ArrayList)serializable).size(); ++i) {
                        n16 += CFG.core.getProv(list.get((int)((Integer)((ArrayList)serializable).get((int)i)).intValue()).iProvinceID).getDangerLevel_WithArmy();
                    }
                    int n17 = -1;
                    for (int i = 0; i < n14 && i < ((ArrayList)serializable).size() && aI_RegoupArmyData.iArmy > 0; ++i) {
                        RegroupArmy_AtPeace regroupArmy_AtPeace = new RegroupArmy_AtPeace(n, aI_RegoupArmyData.iProvinceID, list.get((int)((Integer)((ArrayList)serializable).get((int)i)).intValue()).iProvinceID);
                        if (regroupArmy_AtPeace.getRouteSize() > 0) {
                            long n18 = i == n14 || i == ((ArrayList)serializable).size() - 1 ? aI_RegoupArmyData.iArmy : (long)Math.ceil((float)aI_RegoupArmyData.iArmy * ((float)CFG.core.getProv(list.get((int)((Integer)((ArrayList)serializable).get((int)i)).intValue()).iProvinceID).getDangerLevel_WithArmy() / (float)n16));
                            aI_RegoupArmyData.iArmy -= n18;
                            if (n18 <= 0L) break;
                            if (!CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, regroupArmy_AtPeace.getRoute(0), n18, n, true, false)) continue;
                            if (regroupArmy_AtPeace.getRouteSize() > 1) {
                                CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.add(new CivArmyMission_RegroupAfterRecruitment(n, regroupArmy_AtPeace.getRoute(0), list.get((int)((Integer)((ArrayList)serializable).get((int)i)).intValue()).iProvinceID, n18));
                            }
                            n17 = i;
                            continue;
                        }
                        if (n17 < 0 || (regroupArmy_AtPeace = new RegroupArmy_AtPeace(n, aI_RegoupArmyData.iProvinceID, list.get((int)((Integer)((ArrayList)serializable).get((int)n17)).intValue()).iProvinceID)).getRouteSize() <= 0 || !CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, regroupArmy_AtPeace.getRoute(0), aI_RegoupArmyData.iArmy, n, true, false)) continue;
                        if (regroupArmy_AtPeace.getRouteSize() > 1) {
                            CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.add(new CivArmyMission_RegroupAfterRecruitment(n, regroupArmy_AtPeace.getRoute(0), list.get((int)((Integer)((ArrayList)serializable).get((int)n17)).intValue()).iProvinceID, aI_RegoupArmyData.iArmy));
                        }
                        return true;
                    }
                    if (n17 >= 0) {
                        return true;
                    }
                } else {
                    if (CFG.settingsGD.EXPERIMENTAL_BATTLE_SYSTEM && GameCalendar.TURNID - CFG.core.getCiv(n).civGD.iLastWarTurnID < 30) {
                        int targetProv = -1;
                        float minDist = 999.0f;
                        Civilization civEBS = CFG.core.getCiv(n);
                        for (int kr = 0; kr < civEBS.getCivRegionsSize(); kr++) {
                            if (civEBS.getCivRegion(kr).isKeyRegion) {
                                for (int kp = 0; kp < civEBS.getCivRegion(kr).getProvincesSize(); kp++) {
                                    int pID = civEBS.getCivRegion(kr).getProvince(kp);
                                    if (CFG.core.getProv(pID).getCivId() == n && !CFG.core.getProv(pID).isOccupied()) {
                                        float dist = Distance.getDistanceFromAToB_PercOfMax(aI_RegoupArmyData.iProvinceID, pID);
                                        if (dist < minDist) {
                                            minDist = dist;
                                            targetProv = pID;
                                        }
                                    }
                                }
                            }
                        }
                        if (targetProv == -1) targetProv = civEBS.getCapitalProvID();
                        
                        if (targetProv >= 0 && targetProv != aI_RegoupArmyData.iProvinceID) {
                            RegroupArmy_AtPeace regroup = new RegroupArmy_AtPeace(n, aI_RegoupArmyData.iProvinceID, targetProv);
                            if (regroup.getRouteSize() > 0) {
                                CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, regroup.getRoute(0), aI_RegoupArmyData.iArmy, n, true, false);
                                if (regroup.getRouteSize() > 1) {
                                    regroup.setFromProvinceID(regroup.getRoute(0));
                                    regroup.removeRoute(0);
                                    regroup.setNumOfUnits((int)aI_RegoupArmyData.iArmy);
                                    CFG.core.getCiv(n).addRegroupArmy(regroup);
                                }
                                return true;
                            }
                        }
                    }
                    if (CFG.core.getProv(aI_RegoupArmyData.iProvinceID).getCivId() != n) {
                        CFG.gameAction.disbandArmy(aI_RegoupArmyData.iProvinceID, aI_RegoupArmyData.iArmy, n);
                    } else if (!CFG.core.getCiv((int)n).getCivRegion((int)CFG.core.getProv((int)aI_RegoupArmyData.iProvinceID).getCivRegionID()).isKeyRegion) {
                        CFG.gameAction.disbandArmy(aI_RegoupArmyData.iProvinceID, aI_RegoupArmyData.iArmy, n);
                    }
                }
            }
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
        catch (StackOverflowError stackOverflowError) {
            CFG.exceptionStack(stackOverflowError);
        }
        return false;
    }

    private boolean regroupArmy_AtPeace_ToOwnedBorder(int n, AI_RegoupArmyData aI_RegoupArmyData) {
        ArrayList<Integer> borderProvinceIDs = new ArrayList<Integer>();
        ArrayList<Float> borderScores = new ArrayList<Float>();
        ArrayList<RegroupArmy_AtPeace> borderRoutes = new ArrayList<RegroupArmy_AtPeace>();
        int fromRegionID = CFG.core.getProv(aI_RegoupArmyData.iProvinceID).getCivRegionID();
        Civilization civ = CFG.core.getCiv(n);
        for (int i = 0; i < civ.getNumOfProvs(); ++i) {
            int provinceID = civ.getProvID(i);
            Province province = CFG.core.getProv(provinceID);
            if (provinceID == aI_RegoupArmyData.iProvinceID || province.getCivId() != n || province.isOccupied() || !province.getBordersWithEnemy()) continue;
            float score = (province.getCivRegionID() == fromRegionID ? 1000.0f : 0.0f) + (float)province.getDangerLevel_WithArmy() * 25.0f + (float)this.getPotential_BasedOnNeighboringProvs(provinceID, n) - Distance.getDistanceFromAToB_PercOfMax(aI_RegoupArmyData.iProvinceID, provinceID) * 500.0f - (float)(province.getArmyCivID1(n) + (long)this.getMovingArmyToProvinceID(n, provinceID)) * 0.05f;
            RegroupArmy_AtPeace regroupArmy_AtPeace = new RegroupArmy_AtPeace(n, aI_RegoupArmyData.iProvinceID, provinceID);
            if (regroupArmy_AtPeace.getRouteSize() <= 0) continue;
            borderProvinceIDs.add(provinceID);
            borderScores.add(Float.valueOf(score));
            borderRoutes.add(regroupArmy_AtPeace);
        }
        if (borderProvinceIDs.isEmpty()) {
            return false;
        }
        int targets = Math.min(borderProvinceIDs.size(), (int)Math.min(8L, Math.max(1L, aI_RegoupArmyData.iArmy)));
        long remainingArmy = aI_RegoupArmyData.iArmy;
        boolean movedAny = false;
        for (int target = 0; target < targets && remainingArmy > 0L && !borderProvinceIDs.isEmpty(); ++target) {
            int bestID = 0;
            for (int i = 1; i < borderScores.size(); ++i) {
                if (((Float)borderScores.get(bestID)).floatValue() >= ((Float)borderScores.get(i)).floatValue()) continue;
                bestID = i;
            }
            int toProvinceID = ((Integer)borderProvinceIDs.get(bestID)).intValue();
            RegroupArmy_AtPeace route = (RegroupArmy_AtPeace)borderRoutes.get(bestID);
            int targetsLeft = targets - target;
            long armyToMove = target == targets - 1 ? remainingArmy : Math.max(1L, remainingArmy / (long)Math.max(1, targetsLeft));
            boolean moved = false;
            if (route.getRouteSize() == 1) {
                moved = CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, toProvinceID, armyToMove, n, true, false);
            } else if (CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, route.getRoute(0), armyToMove, n, true, false)) {
                route.setFromProvinceID(route.getRoute(0));
                route.removeRoute(0);
                route.setNumOfUnits(armyToMove);
                CFG.core.getCiv(n).addRegroupArmy(route);
                moved = true;
            }
            if (moved) {
                remainingArmy -= armyToMove;
                movedAny = true;
            }
            borderProvinceIDs.remove(bestID);
            borderScores.remove(bestID);
            borderRoutes.remove(bestID);
        }
        return movedAny;
    }

    public final long getRegroupArmy_NumOfUnits(int n, int n2) {
        long n3 = CFG.core.getProv(n2).getArmyCivID1(n);
        for (int i = CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.size() - 1; i >= 0; --i) {
            if (CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.get((int)i).iProvinceID != n2) continue;
            n3 -= CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.get((int)i).iArmy;
        }
        return n3;
    }

    public final float getValue_PositionOfArmy(int n, List<AI_ProvinceInfo> list, int n2, int n3, float f, float f2, int n4, long n5, long n6, float f3) {
        return CFG.core.getCiv((int)n).civGD.civPers.VALUABLE_POTENTIAL * (list.get((int)n2).iValue / f) + CFG.core.getCiv((int)n).civGD.civPers.VALUABLE_DANGER * ((float)CFG.core.getProv(list.get((int)n2).iProvinceID).getDangerLevel_WithArmy() / (float)n4) * (1.0f - CFG.core.getCiv((int)n).civGD.civPers.VALUABLE_NUM_OF_UNITS + CFG.core.getCiv((int)n).civGD.civPers.VALUABLE_NUM_OF_UNITS * (1.0f - (float)(CFG.core.getProv(list.get((int)n2).iProvinceID).getArmyID(0) + (long)n3) / ((float)n5 + (float)n6 * CFG.core.getCiv((int)n).civGD.civPers.VALUABLE_NUM_OF_UNITS_RECRUITMENT))) * (1.0f - CFG.core.getCiv((int)n).civGD.civPers.VALUABLE_REGION_NUM_OF_PROVINCES + CFG.core.getCiv((int)n).civGD.civPers.VALUABLE_REGION_NUM_OF_PROVINCES * (float)CFG.core.getProv(list.get((int)n2).iProvinceID).getRegion_NumOfProvinces() / f3 - CFG.core.getCiv((int)n).civGD.civPers.VALUABLE_REGION_POTENTIAL + CFG.core.getCiv((int)n).civGD.civPers.VALUABLE_REGION_POTENTIAL * (float)CFG.core.getProv(list.get((int)n2).iProvinceID).getPotentialRegion() / f2);
    }

    public final void nukeDropBomb(int n) {
        if (CFG.core.getCiv((int)n).civGD.iNukes > 0) {
            try {
                int n2;
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                ArrayList<Float> arrayList2 = new ArrayList<Float>();
                for (n2 = CFG.core.getCiv((int)n).isAtWarWithCivs.size() - 1; n2 >= 0; --n2) {
                    Civilization civilization = CFG.core.getCiv(CFG.core.getCiv((int)n).isAtWarWithCivs.get(n2));
                    if (CFG.core.getCiv(n).getNumOfProvs() >= GameValues.gvAiNuke.NUKE_OR_IF_NUM_OF_PROVINCES_BELOW && !((float)civilization.getNumOfProvs() / (float)CFG.core.getCiv(n).getNumOfProvs() > GameValues.gvAiNuke.NUKE_ONLY_IF_PROVINCE_RATIO_OVER)) continue;
                    for (int i = 0; i < civilization.getNumOfProvs(); ++i) {
                        Province province = CFG.core.getProv(civilization.getProvID(i));
                        arrayList.add(province.getProvID());
                        arrayList2.add(Float.valueOf((float)province.getPop().getPops() * GameValues.gvAiNuke.NUKE_SCORE_POPULATION_MODIFIER + (float)province.getEco() * GameValues.gvAiNuke.NUKE_SCORE_ECONOMY_MODIFIER));
                    }
                }
                while (!arrayList.isEmpty() && CFG.core.getCiv((int)n).civGD.iNukes > 0) {
                    n2 = 0;
                    for (int i = arrayList.size() - 1; i > 0; --i) {
                        if (!(((Float)arrayList2.get(n2)).floatValue() < ((Float)arrayList2.get(i)).floatValue())) continue;
                        n2 = i;
                    }
                    age.of.civilizations2.jakowski.lukasz.MapA.Plagues.Nuke.NukeManager.dropNuke(n, (Integer)arrayList.get(n2));
                    arrayList.remove(n2);
                    arrayList2.remove(n2);
                }
            }
            catch (Exception exception) {
                CFG.exceptionStack(exception);
            }
        }
        
        
        if (CFG.settingsGD.MISSILES && (CFG.core.getCiv(n).civGD.iMissiles > 0 || CFG.core.getCiv(n).civGD.iMissiles_T2 > 0 || CFG.core.getCiv(n).civGD.iMissiles_T3 > 0)) {
            try {
                age.of.civilizations2.jakowski.lukasz.MapA.MissileManager.strikeAllEnemies(n);
            } catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    public final void takeLoanAtWar(int n) {
        try {
            if (CFG.core.getCiv(n).getLoansSize() < GameValues.gvLoan.LOAN_MAX_NUM_OF_LOANS && ((float)CFG.core.getCiv(n).getGold() < (float)Loans.takeLoan_MaxValue(n) * GameValues.gvAiLoan.LOW_MONEY_RELATIVE_TO_LOAN_MULTIPLIER || CFG.core.getCiv(n).getGold() < (long)GameValues.gvAiLoan.LOW_MONEY_THRESHOLD)) {
                for (int i = CFG.core.getCiv((int)n).isAtWarWithCivs.size() - 1; i >= 0; --i) {
                    if (!((float)CFG.core.getCiv(CFG.core.getCiv((int)n).isAtWarWithCivs.get(i)).getNumberOfUnits() > (float)CFG.core.getCiv(n).getNumberOfUnits() * GameValues.gvAiLoan.ENEMY_ARMY_MODIFIER)) continue;
                    Loans.takeLoan(n, Loans.takeLoan_MaxValue(n), GameValues.gvLoan.LOAN_MIN_DURATION + CFG.oR.nextInt(Math.max(1, GameValues.gvLoan.LOAN_MAX_DURATION - GameValues.gvLoan.LOAN_MIN_DURATION)));
                }
            }
            if (CFG.core.getCiv(n).getLoansFromCivSize() < GameValues.gvLoan.REQUEST_LOAN_MAX_NUM_OF_LOANS && ((float)CFG.core.getCiv(n).getGold() < (float)Loans.takeLoan_MaxValue(n) * GameValues.gvAiLoan.LOW_MONEY_RELATIVE_TO_LOAN_MULTIPLIER || CFG.core.getCiv(n).getGold() < (long)GameValues.gvAiLoan.LOW_MONEY_THRESHOLD)) {
                int n2;
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                for (n2 = CFG.core.getCiv((int)n).civsInRange.size() - 1; n2 >= 0; --n2) {
                    if (!(CFG.core.getCiv(CFG.core.getCiv((int)n).civsInRange.get((int)n2).iCivID).getRelationD(n) > (float)GameValues.gvLoan.REQUEST_LOAN_REQUIRED_RELATION)) continue;
                    arrayList.add(CFG.core.getCiv((int)n).civsInRange.get((int)n2).iCivID);
                }
                if (!arrayList.isEmpty()) {
                    for (n2 = CFG.core.getCiv(n).getLoansFromCivSize(); n2 < GameValues.gvLoan.REQUEST_LOAN_MAX_NUM_OF_LOANS; ++n2) {
                        int n3 = CFG.oR.nextInt(arrayList.size());
                        GameManager.sendLoanRequest((Integer)arrayList.get(n3), n, Loans.takeLoan_MaxValue(n), GameValues.gvLoan.REQUEST_LOAN_MIN_DURATION + CFG.oR.nextInt(Math.max(1, GameValues.gvLoan.REQUEST_LOAN_MAX_DURATION - GameValues.gvLoan.REQUEST_LOAN_MIN_DURATION)));
                    }
                }
            }
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
    }

    public final void regroupArmyAfterRecruitment(int n) {
        for (int i = CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.size() - 1; i >= 0; --i) {
            if (CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.get((int)i).MISSION_TYPE != CivArmyMission_Type.REGRUOP_AFTER_RECRUIT || !CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.get(i).canMakeAction(n, 0) || !CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.get(i).action(n)) continue;
            CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.remove(i);
        }
    }

    public final void defendFromSeaInvasion(int n) {
        int n2;
        int n3;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<Long> arrayList2 = new ArrayList<Long>();
        for (n3 = CFG.core.getCiv((int)n).isAtWarWithCivs.size() - 1; n3 >= 0; --n3) {
            for (n2 = 0; n2 < CFG.core.getCiv(CFG.core.getCiv((int)n).isAtWarWithCivs.get(n3)).moveUnitsSize(); ++n2) {
                if (CFG.core.getProv(CFG.core.getCiv(CFG.core.getCiv((int)n).isAtWarWithCivs.get(n3)).getMoveUnits(n2).getToProvID()).getCivId() != n || !CFG.core.getProv(CFG.core.getCiv(CFG.core.getCiv((int)n).isAtWarWithCivs.get(n3)).getMoveUnits(n2).getFromProviID()).getSeaProv() || CFG.core.getProv(CFG.core.getCiv(CFG.core.getCiv((int)n).isAtWarWithCivs.get(n3)).getMoveUnits(n2).getToProvID()).isOccupied()) continue;
                arrayList.add(CFG.core.getCiv(CFG.core.getCiv((int)n).isAtWarWithCivs.get(n3)).getMoveUnits(n2).getToProvID());
                arrayList2.add(CFG.core.getCiv(CFG.core.getCiv((int)n).isAtWarWithCivs.get(n3)).getMoveUnits(n2).getNumberOfUnits());
            }
        }
        while (!arrayList.isEmpty()) {
            n3 = 0;
            for (n2 = 1; n2 < arrayList.size(); ++n2) {
                if (CFG.core.getProv((Integer)arrayList.get(n3)).getPotential() >= CFG.core.getProv((Integer)arrayList.get(n2)).getPotential()) continue;
                n3 = n2;
            }
            if (CFG.core.getProv((Integer)arrayList.get(n3)).getArmyCivID1(n) < (Long)arrayList2.get(n3)) {
                long n4 = (Long)arrayList2.get(n3) - CFG.core.getProv((Integer)arrayList.get(n3)).getArmyCivID1(n);
                n4 = (long)Math.ceil((float)n4 * (GameValues.gvAiArmy.DEFEND_FROM_SEA_INVASION_REQUIRED_ARMY_MODIFIER + (float)CFG.oR.nextInt(GameValues.gvAiArmy.DEFEND_FROM_SEA_INVASION_REQUIRED_ARMY_MODIFIER_RANDOM_1000) / 1000.0f));
                if (CFG.core.getCiv(n).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_RECRUIT) {
                    if (CFG.core.getCiv(n).getGold() < (long)(GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT * n4) && CFG.core.getCiv(n).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_RECRUIT + GameValues.gvLoan.COST_TAKE_LOAN) {
                        long n5 = (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT * n4 - CFG.core.getCiv(n).getGold();
                        if (CFG.core.getCiv(n).getGold() + n5 > (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT) {
                            Loans.takeLoan(n, n5, GameValues.gvLoan.LOAN_MIN_DURATION);
                        }
                    }
                    if (CFG.core.getCiv(n).getGold() <= (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT || CFG.core.getCiv(n).recruitArmy_AI((Integer)arrayList.get(n3), n4)) {
                        
                    }
                }
            }
            arrayList.remove(n3);
            arrayList2.remove(n3);
            if (CFG.core.getCiv(n).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE) continue;
        }
    }

    public final void moveAtWar(int n) {
        Civilization civilization = CFG.core.getCiv(n);
        try {
            block100: {
                int n2;
                int n3;
                block101: {
                    int n4;
                    int n5;
                    int n6;
                    ArrayList<AI_ProvinceInfo_War> arrayList;
                    ArrayList<Integer> arrayList2;
                    float f;
                    int n7;
                    ArrayList<Object> arrayList3;
                    block102: {
                        block104: {
                            block103: {
                                float f2 = 0.0f;
                                int n8;
                                int n9;
                                int n10;
                                int n11;
                                int n12;
                                Object object;
                                int n13;
                                arrayList3 = new ArrayList<Object>();
                                for (n13 = 0; n13 < civilization.isAtWarWithCivs.size(); ++n13) {
                                }
                                for (n13 = civilization.lFrontLines.size() - 1; n13 >= 0; --n13) {
                                    object = civilization.lFrontLines.get(n13);
                                    if (!CFG.core.getCivsAtWar(n, ((AI_Frontline)object).iWithCivID)) continue;
                                    for (n12 = ((AI_Frontline)object).lProvinces.size() - 1; n12 >= 0; --n12) {
                                        boolean bl = true;
                                        for (n11 = arrayList3.size() - 1; n11 >= 0; --n11) {
                                            if (((AI_ProvinceInfo_War)arrayList3.get((int)n11)).iProvinceID != ((AI_Frontline)object).lProvinces.get(n12)) continue;
                                            bl = false;
                                            break;
                                        }
                                        if (!bl) continue;
                                        arrayList3.add(new AI_ProvinceInfo_War(((AI_Frontline)object).lProvinces.get(n12), this.getPotential_BasedOnNeighboringProvs(((AI_Frontline)object).lProvinces.get(n12), n), true));
                                    }
                                }
                                for (n13 = 0; n13 < civilization.civGD.iVassalsSize; ++n13) {
                                    object = CFG.core.getCiv(civilization.civGD.vassals.get((int)n13).iCivID);
                                    for (n12 = ((Civilization)object).lFrontLines.size() - 1; n12 >= 0; --n12) {
                                        AI_Frontline aI_Frontline = ((Civilization)object).lFrontLines.get(n12);
                                        if (!CFG.core.getCivsAtWar(n, aI_Frontline.iWithCivID)) continue;
                                        for (n11 = aI_Frontline.lProvinces.size() - 1; n11 >= 0; --n11) {
                                            n3 = 1;
                                            for (n10 = arrayList3.size() - 1; n10 >= 0; --n10) {
                                                if (((AI_ProvinceInfo_War)arrayList3.get((int)n10)).iProvinceID != aI_Frontline.lProvinces.get(n11)) continue;
                                                n3 = 0;
                                                break;
                                            }
                                            if (n3 == 0) continue;
                                            arrayList3.add(new AI_ProvinceInfo_War(aI_Frontline.lProvinces.get(n11), this.getPotential_BasedOnNeighboringProvs(aI_Frontline.lProvinces.get(n11), civilization.civGD.vassals.get((int)n13).iCivID), false));
                                        }
                                    }
                                }
                                if (civilization.getPuppetOfCiv() != n) {
                                    Civilization civilization2 = CFG.core.getCiv(civilization.getPuppetOfCiv());
                                    for (int i = civilization2.lFrontLines.size() - 1; i >= 0; --i) {
                                        AI_Frontline aI_Frontline = civilization2.lFrontLines.get(i);
                                        if (!CFG.core.getCivsAtWar(n, aI_Frontline.iWithCivID)) continue;
                                        for (int j = aI_Frontline.lProvinces.size() - 1; j >= 0; --j) {
                                            n11 = 1;
                                            for (n2 = arrayList3.size() - 1; n2 >= 0; --n2) {
                                                if (((AI_ProvinceInfo_War)arrayList3.get((int)n2)).iProvinceID != aI_Frontline.lProvinces.get(j)) continue;
                                                n11 = 0;
                                                break;
                                            }
                                            if (n11 == 0) continue;
                                            arrayList3.add(new AI_ProvinceInfo_War(aI_Frontline.lProvinces.get(j), this.getPotential_BasedOnNeighboringProvs(aI_Frontline.lProvinces.get(j), civilization.getPuppetOfCiv()), false));
                                        }
                                    }
                                }
                                if (civilization.getAlliance() > 0) {
                                    Alliance alliance = CFG.core.getAlliance(civilization.getAlliance());
                                    for (int i = 0; i < alliance.getCivilizationsSize(); ++i) {
                                        Civilization civilization3 = CFG.core.getCiv(alliance.getCivilization(i));
                                        if (alliance.getCivilization(i) == n) continue;
                                        for (int j = civilization3.lFrontLines.size() - 1; j >= 0; --j) {
                                            AI_Frontline aI_Frontline = civilization3.lFrontLines.get(j);
                                            if (!CFG.core.getCivsAtWar(n, aI_Frontline.iWithCivID)) continue;
                                            for (n10 = aI_Frontline.lProvinces.size() - 1; n10 >= 0; --n10) {
                                                n7 = 1;
                                                for (int k = arrayList3.size() - 1; k >= 0; --k) {
                                                    if (((AI_ProvinceInfo_War)arrayList3.get((int)k)).iProvinceID != aI_Frontline.lProvinces.get(n10)) continue;
                                                    n7 = 0;
                                                    break;
                                                }
                                                if (n7 == 0) continue;
                                                arrayList3.add(new AI_ProvinceInfo_War(aI_Frontline.lProvinces.get(n10), this.getPotential_BasedOnNeighboringProvs(aI_Frontline.lProvinces.get(n10), alliance.getCivilization(i)), false));
                                            }
                                        }
                                    }
                                }
                                try {
                                    for (Map.Entry<Integer, Civilization.DiplomacyData> entry : civilization.militaryAccess.entrySet()) {
                                        for (int i = CFG.core.getCiv((int)entry.getKey().intValue()).lFrontLines.size() - 1; i >= 0; --i) {
                                            AI_Frontline aI_Frontline = CFG.core.getCiv((int)entry.getKey().intValue()).lFrontLines.get(i);
                                            if (!CFG.core.getCivsAtWar(n, aI_Frontline.iWithCivID)) continue;
                                            for (int j = aI_Frontline.lProvinces.size() - 1; j >= 0; --j) {
                                                n3 = 1;
                                                for (n10 = arrayList3.size() - 1; n10 >= 0; --n10) {
                                                    if (((AI_ProvinceInfo_War)arrayList3.get((int)n10)).iProvinceID != aI_Frontline.lProvinces.get(j)) continue;
                                                    n3 = 0;
                                                    break;
                                                }
                                                if (n3 == 0) continue;
                                                arrayList3.add(new AI_ProvinceInfo_War(aI_Frontline.lProvinces.get(j), this.getPotential_BasedOnNeighboringProvs(aI_Frontline.lProvinces.get(j), entry.getKey()), false));
                                            }
                                        }
                                    }
                                }
                                catch (Exception exception) {
                                    CFG.exceptionStack(exception);
                                }
                                if (arrayList3.isEmpty()) break block101;
                                int n14 = 1;
                                f = 1.0f;
                                ArrayList<Integer> arrayList4 = new ArrayList<Integer>();
                                int n15 = 1;
                                float f3 = 1.0f;
                                float f4 = 1.0f;
                                arrayList2 = new ArrayList<Integer>();
                                n7 = 0;
                                for (n9 = arrayList3.size() - 1; n9 >= 0; --n9) {
                                    Province province = CFG.core.getProv(((AI_ProvinceInfo_War)arrayList3.get((int)n9)).iProvinceID);
                                    if (((AI_ProvinceInfo_War)arrayList3.get((int)n9)).iValue > f) {
                                        f = ((AI_ProvinceInfo_War)arrayList3.get((int)n9)).iValue;
                                    }
                                    if (province.getDangerLevel_WithArmy() > n14) {
                                        n14 = province.getDangerLevel_WithArmy();
                                    }
                                    if ((float)province.getRegion_NumOfProvinces() > f3) {
                                        f3 = province.getRegion_NumOfProvinces();
                                    }
                                    if ((float)province.getPotentialRegion() > f4) {
                                        f4 = province.getPotentialRegion();
                                    }
                                    arrayList4.add(n7 += this.getMovingArmyToProvinceID(n, ((AI_ProvinceInfo_War)arrayList3.get((int)n9)).iProvinceID));
                                    n8 = CFG.core.getProvinceArmy(((AI_ProvinceInfo_War)arrayList3.get((int)n9)).iProvinceID);
                                    if (n8 + n7 <= n15) continue;
                                    n15 = n8 + n7;
                                }
                                for (n9 = arrayList3.size() - 1; n9 >= 0; --n9) {
                                    Province province = CFG.core.getProv(((AI_ProvinceInfo_War)arrayList3.get((int)n9)).iProvinceID);
                                    ((AI_ProvinceInfo_War)arrayList3.get((int)n9)).iValue = (civilization.civGD.civPers.WAR_POTENTIAL * (((AI_ProvinceInfo_War)arrayList3.get((int)n9)).iValue / f) + civilization.civGD.civPers.WAR_DANGER * ((float)province.getDangerLevel_WithArmy() / (float)n14) + (1.0f - civilization.civGD.civPers.WAR_REGION_NUM_OF_PROVINCES + civilization.civGD.civPers.WAR_REGION_NUM_OF_PROVINCES * (float)province.getRegion_NumOfProvinces() / f3 - civilization.civGD.civPers.WAR_REGION_POTENTIAL + civilization.civGD.civPers.WAR_REGION_POTENTIAL * (float)province.getPotentialRegion() / f4)) * (1.0f - civilization.civGD.civPers.WAR_ATTACK_DISTANCE * Distance.getDistanceFromAToB_PercOfMax(CFG.gameUpdate.getAdministration_Capital(n), ((AI_ProvinceInfo_War)arrayList3.get((int)n9)).iProvinceID)) + (1.0f - civilization.civGD.civPers.WAR_NUM_OF_UNITS + civilization.civGD.civPers.WAR_NUM_OF_UNITS * (1.0f - (float)(CFG.core.getProvinceArmy(((AI_ProvinceInfo_War)arrayList3.get((int)n9)).iProvinceID) + (Integer)arrayList4.get(n9)) / (float)n15) * (province.getNeighProvinceOfCivWasLost() > 0 ? 0.55f + (float)CFG.oR.nextInt(30) / 100.0f : 1.0f));
                                }
                                arrayList = new ArrayList<AI_ProvinceInfo_War>();
                                n6 = 0;
                                while (!arrayList3.isEmpty()) {
                                    n8 = 0;
                                    int n16 = arrayList3.size();
                                    for (int i = 1; i < n16; ++i) {
                                        if (((AI_ProvinceInfo_War)arrayList3.get((int)n8)).iValue < ((AI_ProvinceInfo_War)arrayList3.get((int)i)).iValue) {
                                            n8 = i;
                                            continue;
                                        }
                                        if (((AI_ProvinceInfo_War)arrayList3.get((int)n8)).iValue != ((AI_ProvinceInfo_War)arrayList3.get((int)i)).iValue || CFG.oR.nextInt(100) >= 50) continue;
                                        n8 = i;
                                    }
                                    if (CFG.core.getProv(((AI_ProvinceInfo_War)arrayList3.get((int)n8)).iProvinceID).getArmyCivID1(n) > 0) {
                                        arrayList2.add(n6);
                                    }
                                    arrayList.add((AI_ProvinceInfo_War)arrayList3.get(n8));
                                    arrayList3.remove(n8);
                                    ++n6;
                                }
                                this.moveAtWar_Regroup(n, arrayList, arrayList2);
                                if (civilization.getGold() <= (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT) break block102;
                                n5 = (float)arrayList2.size() * 1.75f * (float)CFG.ideologiesMgr.getIdeologyID((int)civilization.getIdeology()).COST_OF_MOVE <= (float)(civilization.getMovemPoints() - CFG.ideologiesMgr.getIdeologyID((int)civilization.getIdeology()).COST_OF_RECRUIT) ? 1 : 0;
                                n8 = n5;
                                if (n5 != 0) break block103;
                                float f5 = civilization.getGold() / (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT;
                                float f6 = civilization.civGD.moveAtWar_ProvincesLostAndConquered_LastTurn < 0 ? 0.16f + 0.03f * (float)civilization.civGD.moveAtWar_ProvincesLostAndConquered_LastTurn : (f2 = civilization.civGD.moveAtWar_ArmyFullyRecruitedLastTurn ? 0.6f : 0.75f);
                                if (!(f5 * f2 > (float)civilization.getNumberOfUnits()) && civilization.civGD.moveAtWar_ProvincesLostAndConquered_LastTurn >= -3 && civilization.getNumOfProvs() >= 3 && CFG.oR.nextInt(100) >= 6) break block104;
                            }
                            this.moveAtWar_Recruit(n, arrayList, arrayList2, false);
                        }
                        civilization.civGD.moveAtWar_ArmyFullyRecruitedLastTurn = false;
                    }
                    if ((n4 = civilization.getMovemPoints() / CFG.ideologiesMgr.getIdeologyID((int)civilization.getIdeology()).COST_OF_MOVE) > 0) {
                        arrayList3 = new ArrayList();
                        float f7 = 1.0f;
                        f = 1.0f;
                        for (n3 = arrayList2.size() - 1; n3 >= 0; --n3) {
                            if (CFG.core.getProv(arrayList.get((int)arrayList2.get((int)n3).intValue()).iProvinceID).getArmyCivID1(n) >= CFG.MIN_ARMY_REQUIRED_TO_ATTACK) continue;
                            arrayList2.remove(n3);
                        }
                        for (n3 = arrayList2.size() - 1; n3 >= 0; --n3) {
                            Province province = CFG.core.getProv(arrayList.get((int)arrayList2.get((int)n3).intValue()).iProvinceID);
                            if (f7 < (float)province.getArmyCivID1(n)) {
                                f7 = province.getArmyCivID1(n);
                            }
                            if (!(f < (float)province.getPotentialModified_WAR_MoveFrom(n))) continue;
                            f = province.getPotentialModified_WAR_MoveFrom(n);
                        }
                        for (n3 = 0; n3 < arrayList2.size(); ++n3) {
                            Province province = CFG.core.getProv(arrayList.get((int)arrayList2.get((int)n3).intValue()).iProvinceID);
                            float f8 = civilization.civGD.civPers.WAR_ATTACK_SCORE_ARMY * (float)province.getArmyCivID1(n) / f7 + civilization.civGD.civPers.WAR_ATTACK_SCORE_POTENTIAL * (float)province.getPotentialModified_WAR_MoveFrom(n) / f + (province.getWasConquered() > 0 ? civilization.civGD.civPers.WAR_ATTACK_SCORE_WAS_CONQUERED : 0.0f) + (province.getIsNotSuppliedForXTurns() > 0 ? 0.275f + 2.5f * (float)province.getArmyCivID1(n) / f7 : 0.0f);
                            if (CFG.settingsGD.AI_GROUP_UNITS) {
                                float f9 = province.getArmyCivID1(n);
                                for (int i = 0; i < province.getNeighProvincesSize(); ++i) {
                                    int n17 = province.getNeighProvinces(i);
                                    if (CFG.core.getProv(n17).getCivId() != n || !CFG.core.getProv(n17).getBordersWithEnemy()) continue;
                                    f9 = Math.min(f9, (float)CFG.core.getProv(n17).getArmyCivID1(n));
                                }
                                if ((float)province.getArmyCivID1(n) > f9 * 2.0f && f9 > 0.0f) {
                                    f8 *= 0.5f;
                                }
                            }
                            arrayList3.add(Float.valueOf(f8));
                        }
                        ArrayList<Integer> arrayList5 = new ArrayList<Integer>();
                        ArrayList<Integer> arrayList6 = new ArrayList<Integer>();
                        for (n5 = arrayList2.size() - 1; n5 >= 0; --n5) {
                            arrayList6.add(n5);
                        }
                        while (!arrayList6.isEmpty()) {
                            int n18 = 0;
                            for (int i = arrayList6.size() - 1; i > 0; --i) {
                                if (!(((Float)arrayList3.get((Integer)arrayList6.get(n18))).floatValue() < ((Float)arrayList3.get((Integer)arrayList6.get(i))).floatValue())) continue;
                                n18 = i;
                            }
                            arrayList5.add((Integer)arrayList6.get(n18));
                            arrayList6.remove(n18);
                        }
                        int n19 = arrayList5.size();
                        for (n5 = 0; n5 < n19; ++n5) {
                            int n20;
                            Object object;
                            int n21;
                            arrayList3.clear();
                            arrayList6.clear();
                            if (CFG.oR.nextInt(100) < 65) {
                                Province province = CFG.core.getProv(arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID);
                                for (n6 = 0; n6 < province.getNeighProvincesSize(); ++n6) {
                                    n7 = province.getNeighProvinces(n6);
                                    if (!CFG.core.getCivsAtWar(n, CFG.core.getProv(n7).getCivId()) || civilization.isMovingUnitsToProvID(n7)) continue;
                                    arrayList6.add(n7);
                                    arrayList3.add(Float.valueOf(this.moveAtWar_AttackTo_Score(n, n7)));
                                }
                            }
                            if (arrayList6.isEmpty()) {
                                Province province = CFG.core.getProv(arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID);
                                for (n6 = 0; n6 < province.getNeighProvincesSize(); ++n6) {
                                    n7 = province.getNeighProvinces(n6);
                                    if (!CFG.core.getCivsAtWar(n, CFG.core.getProv(n7).getCivId())) continue;
                                    arrayList6.add(n7);
                                    arrayList3.add(Float.valueOf(this.moveAtWar_AttackTo_Score(n, n7) * (civilization.isMovingUnitsToProvID(n7) ? 0.625f : 1.0f)));
                                }
                            }
                            if (CFG.AI_PLUNDER_ENABLED && !CFG.core.getCiv(n).getIsPlayer() && CFG.oR.nextInt(100) < (int)(CFG.PLUNDER_CHANCE * 100.0f) && this.plunderProvince(n, arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID)) {
                                int n22 = (int)this.getRegroupArmy_NumOfUnits(n, arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID);
                                n22 = (int)Math.max(Plunder.plunderEfficiency_RequiredMAX(n, arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID), (float)n22);
                                Plunder.plunderProvince(n, arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID, n22);
                            }
                            if (CFG.AI_GENOCIDE_ENABLED && !CFG.core.getCiv(n).getIsPlayer() && CFG.oR.nextInt(100) < (int)(CFG.GENOCIDE_CHANCE * 100.0f) && CFG.core.getProv((int)arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID).getCivId() != n && GameManager.hasGenocidablePopulation(n, arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID)) {
                                GameManager.genocideAllMinorities(n, arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID);
                            }
                            if (arrayList6.isEmpty()) continue;
                            if (!CFG.settingsGD.AI_GROUP_UNITS && arrayList6.size() > 1 && civilization.getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)civilization.getIdeology()).COST_OF_MOVE * 2) {
                                int n23;
                                int n24;
                                int n25;
                                int n26;
                                int n27 = (int)this.getRegroupArmy_NumOfUnits(n, arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID);
                                if (n27 <= 0) continue;
                                n21 = civilization.getMovemPoints() / CFG.ideologiesMgr.getIdeologyID((int)civilization.getIdeology()).COST_OF_MOVE;
                                object = new ArrayList();
                                ArrayList<Integer> arrayList7 = new ArrayList<Integer>();
                                for (n26 = arrayList3.size() - 1; n26 >= 0; --n26) {
                                    arrayList7.add(n26);
                                }
                                while (!arrayList7.isEmpty()) {
                                    n26 = 0;
                                    for (int i = arrayList7.size() - 1; i > 0; --i) {
                                        if (!(((Float)arrayList3.get((Integer)arrayList7.get(n26))).floatValue() < ((Float)arrayList3.get((Integer)arrayList7.get(i))).floatValue())) continue;
                                        n26 = i;
                                    }
                                    ((ArrayList)object).add((Integer)arrayList7.get(n26));
                                    arrayList7.remove(n26);
                                }
                                n21 = Math.min(n21, arrayList6.size());
                                float f10 = 0.0f;
                                for (int i = 0; i < ((ArrayList)object).size(); ++i) {
                                    f10 += ((Float)arrayList3.get((Integer)((ArrayList)object).get(i))).floatValue();
                                }
                                ArrayList<Boolean> arrayList8 = new ArrayList<Boolean>();
                                for (n25 = 0; n25 < n21; ++n25) {
                                    int n28 = (int)Math.ceil((float)n27 * ((Float)arrayList3.get(n25)).floatValue() / f10);
                                    if ((CFG.core.getProv((Integer)arrayList6.get((Integer)((ArrayList)object).get(n25))).getWasAttacked() > 0 || CFG.core.getProv(arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID).getLvlOfWatchTower() > 0 && CFG.core.getProv((Integer)arrayList6.get((Integer)((ArrayList)object).get(n25))).getLvlOfFort() <= 0) && n28 < (n24 = (int)((float)(CFG.core.getProvinceArmy((Integer)arrayList6.get((Integer)((ArrayList)object).get(n25))) + this.getEnemyArmy_ExtraMovedArmy((Integer)arrayList6.get((Integer)((ArrayList)object).get(n25)))) * 1.05f))) {
                                        if (CFG.core.getProv(arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID).getArmyCivID1(n) > (long)n24) {
                                            n28 = (int)Math.min((float)CFG.core.getProv(arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID).getArmyCivID1(n), (float)CFG.core.getProvinceArmy((Integer)arrayList6.get((Integer)((ArrayList)object).get(n25))) * (1.04f + (float)CFG.oR.nextInt(20) / 100.0f));
                                            n27 -= n28;
                                            f10 = Math.max(1.0f, f10 - ((Float)arrayList3.get(n25)).floatValue());
                                        } else if ((long)n24 >= CFG.core.getProvinceArmy(arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID)) {
                                            long n29 = 0L;
                                            for (n23 = 0; n23 < CFG.core.getProv((Integer)arrayList6.get((Integer)((ArrayList)object).get(n25))).getNeighProvincesSize(); ++n23) {
                                                if (CFG.core.getProv((Integer)arrayList6.get((Integer)((ArrayList)object).get(n25))).getNeighProvinces(n23) == arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID) continue;
                                                n29 += CFG.core.getProv(CFG.core.getProv((Integer)arrayList6.get((Integer)((ArrayList)object).get(n25))).getNeighProvinces(n23)).getArmyCivID1(n);
                                            }
                                            if ((long)n24 >= (long)n28 + (long)n29) {
                                                arrayList8.add(false);
                                                continue;
                                            }
                                        }
                                    }
                                    arrayList8.add(true);
                                    if (!CFG.gameAction.moveArmyAction(arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID, (Integer)arrayList6.get((Integer)((ArrayList)object).get(n25)), n28, n, true, false)) break;
                                }
                                if (CFG.ideologiesMgr.getIdeologyID((int)civilization.getIdeology()).COST_OF_MOVE_SAME_PROVINCE > civilization.getMovemPoints()) continue;
                                for (n25 = 0; n25 < arrayList8.size(); ++n25) {
                                    if (!((Boolean)arrayList8.get(n25)).booleanValue()) continue;
                                    for (n24 = 0; n24 < n21; ++n24) {
                                        Province province;
                                        Province province2 = CFG.core.getProv((Integer)arrayList6.get((Integer)((ArrayList)object).get(n24)));
                                        for (n23 = 0; n23 < province2.getNeighProvincesSize() && ((province = CFG.core.getProv(province2.getNeighProvinces(n23))).getArmyCivID1(n) <= 0 || province.getCivId() == n && this.moveAtWar_NumOfNotCoveredNeighEnemyProvinces(n, province2.getNeighProvinces(n23)) > 1 || CFG.gameAction.moveArmyAction(province2.getNeighProvinces(n23), (Integer)arrayList6.get((Integer)((ArrayList)object).get(n24)), province.getArmyCivID1(n), n, true, false) || civilization.getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)civilization.getIdeology()).COST_OF_MOVE_SAME_PROVINCE); ++n23) {
                                        }
                                    }
                                }
                                continue;
                            }
                            int n30 = 0;
                            for (int i = arrayList3.size() - 1; i > 0; --i) {
                                if (!(((Float)arrayList3.get(n30)).floatValue() < ((Float)arrayList3.get(i)).floatValue())) continue;
                                n30 = i;
                            }
                            float f11 = 0.0f;
                            for (n21 = arrayList6.size() - 1; n21 >= 0; --n21) {
                                if (civilization.isMovingUnitsToProvID((Integer)arrayList6.get(n21))) continue;
                                f11 += ((Float)arrayList3.get(n21)).floatValue();
                            }
                            long lArmyCount = !CFG.settingsGD.AI_GROUP_UNITS && f11 > 0.0f && CFG.oR.nextInt(100) < 90 ? (long)Math.ceil((float)CFG.core.getProv(arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID).getArmyCivID1(n) * ((Float)arrayList3.get(n30)).floatValue() / f11) : CFG.core.getProv(arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID).getArmyCivID1(n);
                            object = CFG.core.getProv((Integer)arrayList6.get(n30));
                            if ((((Province)object).getWasAttacked() > 0 || CFG.core.getProv(arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID).getLvlOfWatchTower() > 0 && ((Province)object).getLvlOfFort() <= 0) && lArmyCount < (long)(n20 = (int)((float)(this.getHostileArmyInProvince((Integer)arrayList6.get(n30), n) + (long)this.getEnemyArmy_ExtraMovedArmy((Integer)arrayList6.get(n30))) * 1.05f))) {
                                if (CFG.core.getProv(arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID).getArmyCivID1(n) > (long)n20) {
                                    lArmyCount = (long)Math.min((float)CFG.core.getProv(arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID).getArmyCivID1(n), (float)this.getHostileArmyInProvince((Integer)arrayList6.get(n30), n) * (1.04f + (float)CFG.oR.nextInt(20) / 100.0f));
                                } else if ((long)n20 >= this.getHostileArmyInProvince(arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID, n)) {
                                    long n31 = 0L;
                                    for (int i = 0; i < ((Province)object).getNeighProvincesSize(); ++i) {
                                        if (((Province)object).getNeighProvinces(i) == arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID) continue;
                                        n31 += CFG.core.getProv(((Province)object).getNeighProvinces(i)).getArmyCivID1(n);
                                    }
                                    if ((long)n20 >= lArmyCount + (long)n31) continue;
                                }
                            }
                            if (CFG.gameAction.moveArmyAction(arrayList.get((int)arrayList2.get((int)((Integer)arrayList5.get((int)n5)).intValue()).intValue()).iProvinceID, (Integer)arrayList6.get(n30), lArmyCount, n, true, false)) {
                                Province province;
                                Province province3 = CFG.core.getProv((Integer)arrayList6.get(n30));
                                for (int i = 0; i < province3.getNeighProvincesSize() && ((province = CFG.core.getProv(province3.getNeighProvinces(i))).getArmyCivID1(n) <= 0 || province.getCivId() == n && this.moveAtWar_NumOfNotCoveredNeighEnemyProvinces(n, province3.getNeighProvinces(i)) > 1 || CFG.gameAction.moveArmyAction(province3.getNeighProvinces(i), (Integer)arrayList6.get(n30), province.getArmyCivID1(n), n, true, false) || civilization.getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)civilization.getIdeology()).COST_OF_MOVE); ++i) {
                                }
                                continue;
                            }
                            if (civilization.getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)civilization.getIdeology()).COST_OF_MOVE) {
                                continue;
                            }
                            break block100;
                        }
                    }
                    break block100;
                }
                if (civilization.civGD.iNextCheckMilitaryAccessTurnID <= GameCalendar.TURNID && CFG.oR.nextInt(100) < 72) {
                    int n32;
                    ArrayList<Integer> arrayList = new ArrayList<Integer>();
                    for (n32 = civilization.lFrontLines.size() - 1; n32 >= 0; --n32) {
                        AI_Frontline aI_Frontline = civilization.lFrontLines.get(n32);
                        if (CFG.core.getCivsAtWar(n, aI_Frontline.iWithCivID)) continue;
                        for (int i = CFG.core.getCiv((int)aI_Frontline.iWithCivID).lFrontLines.size() - 1; i >= 0; --i) {
                            if (!CFG.core.getCivsAtWar(n, CFG.core.getCiv((int)aI_Frontline.iWithCivID).lFrontLines.get((int)i).iWithCivID) || civilization.iBudget <= CFG.core.getCiv((int)CFG.core.getCiv((int)aI_Frontline.iWithCivID).lFrontLines.get((int)i).iWithCivID).iBudget && CFG.oR.nextInt(100) >= 6) continue;
                            boolean bl = false;
                            for (n3 = arrayList.size() - 1; n3 >= 0; --n3) {
                                if ((Integer)arrayList.get(n3) != aI_Frontline.iWithCivID) continue;
                                bl = true;
                                break;
                            }
                            if (bl) continue;
                            arrayList.add(aI_Frontline.iWithCivID);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        while (!arrayList.isEmpty() && civilization.getDiploPoints() >= GameValues.gvDipMilitaryAccess.COST_OFFER_MILITARY_ACCESS_ASK_DIPLOMACY_POINTS) {
                            n32 = CFG.oR.nextInt(arrayList.size());
                            if (CFG.core.getMilitaryAccess(n, (Integer)arrayList.get(n32)) <= 10 && !civilization.messageWasSent((Integer)arrayList.get(n32), MessageType.MILITARY_ACCESS_ASK)) {
                                GameManager.sendMilitaryAccess_AskProposal((Integer)arrayList.get(n32), n, GameValues.gvDipMilitaryAccess.DIPLOMACY_MAX_NUMBER_OF_TURNS_FOR_MILITARY_ACCESS);
                            }
                            arrayList.remove(n32);
                        }
                        civilization.civGD.iNextCheckMilitaryAccessTurnID = GameCalendar.TURNID + 6 + CFG.oR.nextInt(20);
                    }
                } else if (civilization.civGD.iNextCheckMilitaryAccessSeaTurnID <= GameCalendar.TURNID) {
                    int n33;
                    ArrayList<Integer> arrayList = new ArrayList<Integer>();
                    for (n33 = civilization.isAtWarWithCivs.size() - 1; n33 >= 0; --n33) {
                        Civilization civilization4 = CFG.core.getCiv(civilization.isAtWarWithCivs.get(n33));
                        if (civilization.iBudget <= civilization4.iBudget || civilization4.getSeaAccess() != 0) continue;
                        for (int i = civilization4.lFrontLines.size() - 1; i >= 0; --i) {
                            if (CFG.core.getCivsAtWar(n, civilization4.lFrontLines.get((int)i).iWithCivID) || CFG.core.getCiv(civilization4.lFrontLines.get((int)i).iWithCivID).getSeaAccess() <= 0) continue;
                            boolean bl = false;
                            for (n2 = arrayList.size() - 1; n2 >= 0; --n2) {
                                if ((Integer)arrayList.get(n2) != civilization4.lFrontLines.get((int)i).iWithCivID) continue;
                                bl = true;
                                break;
                            }
                            if (bl) continue;
                            arrayList.add(civilization4.lFrontLines.get((int)i).iWithCivID);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        while (!arrayList.isEmpty() && civilization.getDiploPoints() >= GameValues.gvDipMilitaryAccess.COST_OFFER_MILITARY_ACCESS_ASK_DIPLOMACY_POINTS) {
                            n33 = CFG.oR.nextInt(arrayList.size());
                            if (CFG.core.getMilitaryAccess(n, (Integer)arrayList.get(n33)) <= 10 && !civilization.messageWasSent((Integer)arrayList.get(n33), MessageType.MILITARY_ACCESS_ASK)) {
                                GameManager.sendMilitaryAccess_AskProposal((Integer)arrayList.get(n33), n, GameValues.gvDipMilitaryAccess.DIPLOMACY_MAX_NUMBER_OF_TURNS_FOR_MILITARY_ACCESS);
                            }
                            arrayList.remove(n33);
                        }
                    }
                    civilization.civGD.iNextCheckMilitaryAccessSeaTurnID = GameCalendar.TURNID + 6 + CFG.oR.nextInt(20);
                }
            }
            this.moveAtWar_EnemyProvinceFallback(n);
            if (GameValues.gvAiWar.USE_NEW_NAVAL_INVASION) {
                this.moveAtWar_AtSea_New(n);
            } else {
                this.moveAtWar_AtSea(n);
            }
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
    }

    private void moveAtWar_EnemyProvinceFallback(int nCivID) {
        Civilization civ = CFG.core.getCiv(nCivID);
        if (civ.getMovemPoints() < CFG.ideologiesMgr.getIdeologyID((int)civ.getIdeology()).COST_OF_MOVE) return;
        for (int i = civ.armiesPositionSize - 1; i >= 0 && civ.getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)civ.getIdeology()).COST_OF_MOVE; --i) {
            int fromProvinceID = civ.armiesPosition.get(i);
            if (fromProvinceID < 0 || fromProvinceID >= CFG.core.getProvinSize()) continue;
            Province fromProvince = CFG.core.getProv(fromProvinceID);
            long army = this.getRegroupArmy_NumOfUnits(nCivID, fromProvinceID);
            if (army < CFG.MIN_ARMY_REQUIRED_TO_ATTACK) continue;
            int bestTarget = -1;
            float bestScore = -1.0f;
            for (int j = 0; j < fromProvince.getNeighProvincesSize(); ++j) {
                int toProvinceID = fromProvince.getNeighProvinces(j);
                Province toProvince = CFG.core.getProv(toProvinceID);
                if (!CFG.core.getCivsAtWar(nCivID, toProvince.getCivId()) || toProvince.getSeaProv() || civ.isMovingUnitsToProvID(toProvinceID)) continue;
                long hostileArmy = Math.max(1L, this.getHostileArmyInProvince(toProvinceID, nCivID) + (long)this.getEnemyArmy_ExtraMovedArmy(toProvinceID));
                float score = this.moveAtWar_AttackTo_Score(nCivID, toProvinceID) * ((float)army / (float)hostileArmy);
                if (score <= bestScore) continue;
                bestScore = score;
                bestTarget = toProvinceID;
            }
            if (bestTarget < 0) continue;
            long hostileArmy = this.getHostileArmyInProvince(bestTarget, nCivID) + (long)this.getEnemyArmy_ExtraMovedArmy(bestTarget);
            long moveArmy = hostileArmy > 0L ? Math.min(army, Math.max(CFG.MIN_ARMY_REQUIRED_TO_ATTACK, (long)((float)hostileArmy * 1.15f))) : army;
            CFG.gameAction.moveArmyAction(fromProvinceID, bestTarget, moveArmy, nCivID, true, false);
        }
    }

    public final boolean plunderProvince(int n, int n2) {
        if (CFG.settingsGD.ANNEXATION_DELAY && CFG.core.getProv(n2).getOccupationTurnsLeft() > 0) {
            return false;
        }
        if (CFG.core.getProv(n2).isOccupied() && !CFG.core.getProv(n2).getCores().getHaveACore(n) && CFG.core.getProv(n2).getCivId() != n && CFG.core.getProv(n2).getTrueOwnerOfProv() != n && (float)CFG.core.getProv(n2).getArmyCivID1(n) < (float)CFG.core.getCiv(n).getNumberOfUnits() * 0.235f && CFG.core.getCiv((int)n).civGD.iPlunder_LastTurnID <= GameCalendar.TURNID) {
            int n4 = (int)this.getRegroupArmy_NumOfUnits(n, n2);
            if ((float)n4 / Plunder.plunderEfficiency_RequiredMAX(n, n2) > 0.45f && CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_PLUNDER <= CFG.core.getCiv(n).getMovemPoints()) {
                if ((float)CFG.oAI.getAIStyle((int)CFG.core.getCiv((int)n).getAIStyleID()).PERSONALITY_PLUNDER_MIN + (float)CFG.oR.nextInt(CFG.oAI.getAIStyle((int)CFG.core.getCiv((int)n).getAIStyleID()).PERSONALITY_PLUNDER_RANDOM) / 1000.0f > (float)CFG.oR.nextInt(1000) / 1000.0f) {
                    CFG.core.getCiv((int)n).civGD.iPlunder_LastTurnID = GameCalendar.TURNID - 1;
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    public final long getHostileArmyInProvince(int nProvinceID, int nCivID) {
        long out = 0L;
        Province province = CFG.core.getProv(nProvinceID);
        for (int i = 0; i < province.getCivsSize(); ++i) {
            int currentCivID = province.getCivId(i);
            if (currentCivID == nCivID || !CFG.core.getCivsAtWar(nCivID, currentCivID)) continue;
            out += province.getArmyID(i);
        }
        return out;
    }

    public final int getEnemyArmy_ExtraMovedArmy(int n) {
        int n2 = 0;
        Province province = CFG.core.getProv(n);
        for (int i = 0; i < province.getCivsSize(); ++i) {
            for (int j = 0; j < CFG.core.getCiv(province.getCivId(i)).moveUnitsSize(); ++j) {
                if (CFG.core.getCiv(province.getCivId(i)).getMoveUnits(j).getFromProviID() != n) continue;
                n2 += (int)CFG.core.getCiv(province.getCivId(i)).getMoveUnits(j).getNumberOfUnits();
            }
        }
        return n2;
    }

    public final int moveAtWar_AtSea_RunMissions(int n) {
        int n2 = 0;
        Civilization civilization = CFG.core.getCiv(n);
        for (int i = civilization.civGD.civPlans.armiesMissions.size() - 1; i >= 0; --i) {
            if (civilization.civGD.civPlans.armiesMissions.get((int)i).MISSION_TYPE != CivArmyMission_Type.NAVAL_INVASION || !civilization.civGD.civPlans.armiesMissions.get(i).canMakeAction(n, 0)) continue;
            if (civilization.civGD.civPlans.armiesMissions.get(i).action(n)) {
                civilization.civGD.civPlans.armiesMissions.remove(i);
                continue;
            }
            if (civilization.civGD.civPlans.armiesMissions.get((int)i).iObsolete <= 0) {
                civilization.civGD.civPlans.armiesMissions.remove(i);
                continue;
            }
            ++n2;
        }
        return n2;
    }

    public final void moveAtWar_AtSea_New(int n) {
        block29: {
            int n2;
            Civilization civilization = CFG.core.getCiv(n);
            for (n2 = civilization.civGD.civPlans.armiesMissions.size() - 1; n2 >= 0; --n2) {
                if (civilization.civGD.civPlans.armiesMissions.get((int)n2).MISSION_TYPE == CivArmyMission_Type.NAVAL_INVASION) continue;
            }
            try {
                int n3;
                int n4;
                int n5;
                int n6;
                if (civilization.getMovemPoints() < CFG.ideologiesMgr.getIdeologyID((int)civilization.getIdeology()).COST_OF_MOVE) break block29;
                int n7 = this.moveAtWar_AtSea_RunMissions(n);
                if (GameCalendar.TURNID <= civilization.civGD.iNextPossibleNavalInvasionTurnID) {
                    return;
                }
                if ((civilization.getBordersWithEnemy() == 1 || civilization.getBordersWithEnemy() == 2 && CFG.oR.nextInt(100) < 75) && n7 >= GameValues.gvAiWar.NAVAL_INVASION_LIMIT) {
                    return;
                }
                if ((float)n7 >= Math.max(1.0f, (float)civilization.getNumOfProvs() / 10.0f)) {
                    return;
                }
                if (civilization.getBordersWithEnemy() != 0) break block29;
                boolean bl = BuildingsManager.canBuildPort(civilization.getProvID(0));
                if (civilization.getSeaAccess_PortProvinces_Size() == 0 && !bl) {
                    return;
                }
                if (civilization.getSeaAccess() <= 0) break block29;
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                for (int i = civilization.isAtWarWithCivs.size() - 1; i >= 0; --i) {
                    if (CFG.core.getCiv(civilization.isAtWarWithCivs.get(i)).getSeaAccess() <= 0) continue;
                    arrayList.add(civilization.isAtWarWithCivs.get(i));
                }
                if (arrayList.isEmpty()) break block29;
                ArrayList<Boolean> arrayList2 = new ArrayList<Boolean>();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                for (n6 = 0; n6 < CFG.map.numOfBasins; ++n6) {
                    arrayList2.add(false);
                    arrayList3.add(new ArrayList());
                    arrayList4.add(new ArrayList());
                }
                if (!bl) {
                    for (n6 = civilization.getSeaAccess_PortProvinces_Size() - 1; n6 >= 0; --n6) {
                        for (n2 = 0; n2 < CFG.core.getProv(civilization.getSeaAccess_PortProvinces().get(n6)).getNeighSeaProvincesSize(); ++n2) {
                            arrayList2.set(CFG.core.getProv(CFG.core.getProv(civilization.getSeaAccess_PortProvinces().get(n6)).getNeighSeaProvinces(n2)).getBasinID(), true);
                        }
                    }
                } else {
                    for (n6 = civilization.getSeaAccess_Provinces_Size() - 1; n6 >= 0; --n6) {
                        for (n2 = 0; n2 < CFG.core.getProv(civilization.getSeaAccessProvinces().get(n6)).getNeighSeaProvincesSize(); ++n2) {
                            arrayList2.set(CFG.core.getProv(CFG.core.getProv(civilization.getSeaAccessProvinces().get(n6)).getNeighSeaProvinces(n2)).getBasinID(), true);
                        }
                    }
                }
                int n8 = 0;
                int n9 = 0;
                for (n5 = arrayList.size() - 1; n5 >= 0; --n5) {
                    Civilization civilization2 = CFG.core.getCiv((Integer)arrayList.get(n5));
                    for (n4 = civilization2.getSeaAccess_Provinces_Size() - 1; n4 >= 0; --n4) {
                        for (n3 = 0; n3 < CFG.core.getProv(civilization2.getSeaAccessProvinces().get(n4)).getNeighSeaProvincesSize(); ++n3) {
                            if (!((Boolean)arrayList2.get(CFG.core.getProv(CFG.core.getProv(civilization2.getSeaAccessProvinces().get(n4)).getNeighSeaProvinces(n3)).getBasinID())).booleanValue()) continue;
                            if (CFG.core.getProv(civilization2.getSeaAccessProvinces().get(n4)).getTrueOwnerOfProv() == n) {
                                ((List)arrayList3.get(CFG.core.getProv(CFG.core.getProv(civilization2.getSeaAccessProvinces().get(n4)).getNeighSeaProvinces(n3)).getBasinID())).add(civilization2.getSeaAccessProvinces().get(n4));
                                ++n8;
                                continue;
                            }
                            ((List)arrayList4.get(CFG.core.getProv(CFG.core.getProv(civilization2.getSeaAccessProvinces().get(n4)).getNeighSeaProvinces(n3)).getBasinID())).add(civilization2.getSeaAccessProvinces().get(n4));
                            ++n9;
                        }
                    }
                }
                if (n9 <= 0 && n8 <= 0) break block29;
                for (n5 = 0; n5 < 5; ++n5) {
                    n3 = -1;
                    float f = -1.0f;
                    int n10 = -1;
                    int n11 = -1;
                    boolean bl2 = true;
                    float f2 = 0.0f;
                    for (n4 = arrayList3.size() - 1; n4 >= 0; --n4) {
                        for (int i = ((List)arrayList3.get(n4)).size() - 1; i >= 0; --i) {
                            f2 = this.moveAtWar_AtSea_ToProvinceID_Score_New(n, (Integer)((List)arrayList3.get(n4)).get(i), true);
                            if (!(f2 > f)) continue;
                            n3 = (Integer)((List)arrayList3.get(n4)).get(i);
                            f = f2;
                            n10 = n4;
                            n11 = i;
                            bl2 = true;
                        }
                    }
                    for (n4 = arrayList4.size() - 1; n4 >= 0; --n4) {
                        for (int i = ((List)arrayList4.get(n4)).size() - 1; i >= 0; --i) {
                            f2 = this.moveAtWar_AtSea_ToProvinceID_Score_New(n, (Integer)((List)arrayList4.get(n4)).get(i), false);
                            if (!(f2 > f)) continue;
                            n3 = (Integer)((List)arrayList4.get(n4)).get(i);
                            f = f2;
                            n10 = n4;
                            n11 = i;
                            bl2 = false;
                        }
                    }
                    if (n3 >= 0) {
                        if (!(CFG.core.isAlly(n, CFG.core.getProv(n3).getCivId()) || CFG.core.getProv(n3).getTrueOwnerOfProv() == n && CFG.core.getProv(n3).isOccupied() && CFG.oR.nextInt(100) < GameValues.gvAiWar.NAVAL_INVASION_RETAKE_OCCUPIED_PROVINCE_CHANCE_100 || civilization.getRankPos() <= CFG.core.getCiv(CFG.core.getProv(n3).getCivId()).getRankPos() || CFG.oR.nextInt(100) >= GameValues.gvAiWar.NAVAL_INVASION_DELAY_HIGHER_RANK_CHANCE)) {
                            civilization.civGD.iNextPossibleNavalInvasionTurnID = GameCalendar.TURNID + GameValues.gvAiWar.NAVAL_INVASION_DELAY_HIGHER_RANK_MIN_TURNS + CFG.oR.nextInt(GameValues.gvAiWar.NAVAL_INVASION_DELAY_HIGHER_RANK_RANDOM_TURNS);
                        } else if (this.moveAtWar_AtSea_ToProvinceID_New(n, n3)) {
                            if (bl2) {
                                ((List)arrayList3.get(n10)).remove(n11);
                                if (!((List)arrayList3.get(n10)).isEmpty()) continue;
                                arrayList3.remove(n10);
                                continue;
                            }
                            ((List)arrayList4.get(n10)).remove(n11);
                            if (!((List)arrayList4.get(n10)).isEmpty()) continue;
                            arrayList4.remove(n10);
                            continue;
                        }
                    }
                    break;
                }
            }
            catch (Exception exception) {
                CFG.exceptionStack(exception);
            }
        }
    }

    public final float moveAtWar_AtSea_ToProvinceID_Score_New(int n, int n2, boolean bl) {
        return ((float)CFG.core.getProv(n2).getPotential() + (float)(CFG.core.getProv(n2).getPotentialRegion() * CFG.core.getCiv(CFG.core.getProv(n2).getCivId()).getCivRegion(CFG.core.getProv(n2).getCivRegionID()).getProvincesSize()) / (float)CFG.core.getCiv(CFG.core.getProv(n2).getCivId()).getNumOfProvs()) * (bl ? 2.5f : (CFG.core.getProv(n2).isOccupied() ? 0.625f : 1.0f)) * (CFG.core.getProv(n2).isCapital() && CFG.core.getProv(n2).getCivId() == n ? 1.15f : 1.0f) * (CFG.core.getProv(n2).getLvlOfPort() > 0 ? 1.5f : 1.0f) * (1.0f - CFG.core.getCiv((int)n).civGD.civPers.WAR_ATTACK_NAVAL_DISTANCE_NEW * Distance.getDistanceFromAToB_PercOfMax(CFG.gameUpdate.getAdministration_Capital(n), n2));
    }

    public final float moveAtWar_AtSea_FromProvinceID_Score_New(int n, int n2, int n3, boolean bl, long n4) {
        return ((float)CFG.core.getProv(n2).getPotential() * 0.2f + 500.0f) * (0.625f * ((float)CFG.core.getProv(n2).getArmyCivID1(n) + (float)Math.min(CFG.gameAction.gMARY(n2, n), n4) * 0.1f)) * (CFG.core.getProv(n2).getLvlOfPort() > 0 ? 2.0f : 1.0f) * (1.0f - Distance.getDistanceFromAToB_PercOfMax(n2, n3) / 2.0f);
    }

    public final boolean moveAtWar_AtSea_ToProvinceID_New(int n, int n2) {
        try {
            int n3;
            int n4;
            int n5;
            ArrayList<Boolean> arrayList = new ArrayList<Boolean>();
            for (n5 = 0; n5 < CFG.map.numOfBasins; ++n5) {
                arrayList.add(false);
            }
            for (n5 = 0; n5 < CFG.core.getProv(n2).getNeighSeaProvincesSize(); ++n5) {
                arrayList.set(CFG.core.getProv(CFG.core.getProv(n2).getNeighSeaProvinces(n5)).getBasinID(), true);
            }
            int n6 = -1;
            float f = -1.0f;
            long n7 = 0L;
            if (CFG.core.getCiv(n).getGold() > (long)(GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT * CFG.MIN_ARMY_REQUIRED_TO_ATTACK * 2)) {
                n7 = CFG.core.getCiv(n).getGold() / (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT;
            }
            block4: for (n4 = CFG.core.getCiv(n).getSeaAccess_Provinces_Size() - 1; n4 >= 0; --n4) {
                if (CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n4)).isOccupied() && GameCalendar.TURNID % GameValues.gvAiWar.NAVAL_INVASION_FROM_OCCUPIED_ONLY_EVERY_X_TURNS != 0) continue;
                for (n3 = 0; n3 < CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n4)).getNeighSeaProvincesSize(); ++n3) {
                    float f2;
                    if (!((Boolean)arrayList.get(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n4)).getNeighSeaProvinces(n3)).getBasinID())).booleanValue()) continue;
                    if (CFG.core.getCiv(n).getCivRegion(CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n4)).getCivRegionID()).checkRegionBordersWithEnemy(n) || !((f2 = this.moveAtWar_AtSea_FromProvinceID_Score_New(n, CFG.core.getCiv(n).getSeaAccessProvinces().get(n4), n2, false, n7)) > f)) continue block4;
                    n6 = CFG.core.getCiv(n).getSeaAccessProvinces().get(n4);
                    f = f2;
                    continue block4;
                }
            }
            if (n6 >= 0) {
                if (CFG.core.getProv(n6).getLvlOfPort() <= 0) {
                    n3 = 0;
                    for (n4 = 0; n4 < CFG.core.getProv(n6).getNeighProvincesSize(); ++n4) {
                        if (CFG.core.getProv(CFG.core.getProv(n6).getNeighProvinces(n4)).getCivId() != n || CFG.core.getProv(CFG.core.getProv(n6).getNeighProvinces(n4)).getLvlOfPort() <= 0) continue;
                        n6 = CFG.core.getProv(n6).getNeighProvinces(n4);
                        n3 = 1;
                        break;
                    }
                    if (n3 == 0) {
                        block7: for (n4 = 0; n4 < CFG.core.getProv(n6).getNeighProvincesSize(); ++n4) {
                            if (CFG.core.getProv(CFG.core.getProv(n6).getNeighProvinces(n4)).getCivId() != n || CFG.core.getProv(CFG.core.getProv(n6).getNeighProvinces(n4)).getLvlOfPort() <= 0) continue;
                            for (int i = 0; i < CFG.core.getProv(CFG.core.getProv(n6).getNeighProvinces(n4)).getNeighProvincesSize(); ++i) {
                                if (CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(n6).getNeighProvinces(n4)).getNeighProvinces(i)).getCivId() != n || CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(n6).getNeighProvinces(n4)).getNeighProvinces(i)).getLvlOfPort() <= 0) continue;
                                n6 = CFG.core.getProv(CFG.core.getProv(n6).getNeighProvinces(n4)).getNeighProvinces(i);
                                n4 = CFG.core.getProv(n6).getNeighProvincesSize();
                                continue block7;
                            }
                        }
                    }
                    if (CFG.core.getProv(n6).getLvlOfPort() > 0 || BuildingsManager.constructPort(n6, n)) {
                        
                    }
                }
                for (n4 = CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.size() - 1; n4 >= 0; --n4) {
                    if (CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.get((int)n4).MISSION_TYPE != CivArmyMission_Type.NAVAL_INVASION || CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.get((int)n4).iProvinceID != n6) continue;
                    return true;
                }
                CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.add(new CivArmyMission_NavalInvasion(n, n6, n2));
                CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.get(CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.size() - 1).action(n);
                return true;
            }
            return false;
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
            return false;
        }
    }

    public final void moveAtWar_AtSea(int n) {
        Civilization civilization = CFG.core.getCiv(n);
        if (civilization.getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)civilization.getIdeology()).COST_OF_MOVE) {
            int n2 = this.moveAtWar_AtSea_RunMissions(n);
            if (GameCalendar.TURNID <= civilization.civGD.iNextPossibleNavalInvasionTurnID) {
                return;
            }
            if (civilization.getBordersWithEnemy() == 0 && n2 > 0) {
                return;
            }
            if ((float)n2 >= Math.max(1.0f, (float)civilization.getNumOfProvs() / 10.0f)) {
                return;
            }
            if (civilization.getBordersWithEnemy() == 0) {
                boolean bl = BuildingsManager.canBuildPort(civilization.getProvID(0));
                if (civilization.getSeaAccess_PortProvinces_Size() == 0 && !bl) {
                    return;
                }
                if (civilization.getSeaAccess() > 0) {
                    int n3;
                    ArrayList<Integer> arrayList = new ArrayList<Integer>();
                    for (n3 = civilization.isAtWarWithCivs.size() - 1; n3 >= 0; --n3) {
                        if (CFG.core.getCiv(civilization.isAtWarWithCivs.get(n3)).getSeaAccess() <= 0) continue;
                        arrayList.add(civilization.isAtWarWithCivs.get(n3));
                    }
                    if (!arrayList.isEmpty()) {
                        int n4;
                        int n5;
                        int n6;
                        int n7;
                        ArrayList<Boolean> arrayList2 = new ArrayList<Boolean>();
                        ArrayList arrayList3 = new ArrayList();
                        ArrayList arrayList4 = new ArrayList();
                        for (n7 = 0; n7 < CFG.map.numOfBasins; ++n7) {
                            arrayList2.add(false);
                            arrayList3.add(new ArrayList());
                            arrayList4.add(new ArrayList());
                        }
                        if (!bl) {
                            for (n7 = civilization.getSeaAccess_PortProvinces_Size() - 1; n7 >= 0; --n7) {
                                for (n3 = 0; n3 < CFG.core.getProv(civilization.getSeaAccess_PortProvinces().get(n7)).getNeighSeaProvincesSize(); ++n3) {
                                    arrayList2.set(CFG.core.getProv(CFG.core.getProv(civilization.getSeaAccess_PortProvinces().get(n7)).getNeighSeaProvinces(n3)).getBasinID(), true);
                                }
                            }
                        } else {
                            for (n7 = civilization.getSeaAccess_Provinces_Size() - 1; n7 >= 0; --n7) {
                                for (n3 = 0; n3 < CFG.core.getProv(civilization.getSeaAccessProvinces().get(n7)).getNeighSeaProvincesSize(); ++n3) {
                                    arrayList2.set(CFG.core.getProv(CFG.core.getProv(civilization.getSeaAccessProvinces().get(n7)).getNeighSeaProvinces(n3)).getBasinID(), true);
                                }
                            }
                        }
                        int n8 = 0;
                        int n9 = 0;
                        for (n6 = arrayList.size() - 1; n6 >= 0; --n6) {
                            Civilization civilization2 = CFG.core.getCiv((Integer)arrayList.get(n6));
                            for (n5 = civilization2.getSeaAccess_Provinces_Size() - 1; n5 >= 0; --n5) {
                                for (n4 = 0; n4 < CFG.core.getProv(civilization2.getSeaAccessProvinces().get(n5)).getNeighSeaProvincesSize(); ++n4) {
                                    if (!((Boolean)arrayList2.get(CFG.core.getProv(CFG.core.getProv(civilization2.getSeaAccessProvinces().get(n5)).getNeighSeaProvinces(n4)).getBasinID())).booleanValue()) continue;
                                    if (CFG.core.getProv(civilization2.getSeaAccessProvinces().get(n5)).getTrueOwnerOfProv() == n) {
                                        ((List)arrayList3.get(CFG.core.getProv(CFG.core.getProv(civilization2.getSeaAccessProvinces().get(n5)).getNeighSeaProvinces(n4)).getBasinID())).add(civilization2.getSeaAccessProvinces().get(n5));
                                        ++n8;
                                        continue;
                                    }
                                    ((List)arrayList4.get(CFG.core.getProv(CFG.core.getProv(civilization2.getSeaAccessProvinces().get(n5)).getNeighSeaProvinces(n4)).getBasinID())).add(civilization2.getSeaAccessProvinces().get(n5));
                                    ++n9;
                                }
                            }
                        }
                        if (n9 + n8 == 0) {
                            return;
                        }
                        n6 = -1;
                        float f = -1.0f;
                        if (n9 > 0 || n8 > 0) {
                            float f2 = 0.0f;
                            for (n4 = arrayList3.size() - 1; n4 >= 0; --n4) {
                                for (n5 = ((List)arrayList3.get(n4)).size() - 1; n5 >= 0; --n5) {
                                    f2 = this.moveAtWar_AtSea_ToProvinceID_Score(n, (Integer)((List)arrayList3.get(n4)).get(n5), true);
                                    if (!(f2 > f)) continue;
                                    n6 = (Integer)((List)arrayList3.get(n4)).get(n5);
                                    f = f2;
                                }
                            }
                            for (n4 = arrayList4.size() - 1; n4 >= 0; --n4) {
                                for (n5 = ((List)arrayList4.get(n4)).size() - 1; n5 >= 0; --n5) {
                                    f2 = this.moveAtWar_AtSea_ToProvinceID_Score(n, (Integer)((List)arrayList4.get(n4)).get(n5), false);
                                    if (!(f2 > f)) continue;
                                    n6 = (Integer)((List)arrayList4.get(n4)).get(n5);
                                    f = f2;
                                }
                            }
                            if (n6 >= 0) {
                                if (!CFG.core.isAlly(n, CFG.core.getProv(n6).getCivId()) && civilization.getRankPos() > CFG.core.getCiv(CFG.core.getProv(n6).getCivId()).getRankPos() && CFG.oR.nextInt(100) < 62) {
                                    civilization.civGD.iNextPossibleNavalInvasionTurnID = GameCalendar.TURNID + 3 + CFG.oR.nextInt(4);
                                    return;
                                }
                                this.moveAtWar_AtSea_ToProvinceID(n, n6);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void moveAtWar_AtSea_ToProvinceID(int n, int n2) {
        int n3;
        int n4;
        int n5;
        ArrayList<Boolean> arrayList = new ArrayList<Boolean>();
        for (n5 = 0; n5 < CFG.map.numOfBasins; ++n5) {
            arrayList.add(false);
        }
        for (n5 = 0; n5 < CFG.core.getProv(n2).getNeighSeaProvincesSize(); ++n5) {
            arrayList.set(CFG.core.getProv(CFG.core.getProv(n2).getNeighSeaProvinces(n5)).getBasinID(), true);
        }
        int n6 = -1;
        float f = -1.0f;
        long n7 = CFG.core.getCiv(n).getGold() > (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT ? CFG.core.getCiv(n).getGold() / (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT : 0L;
        block2: for (n4 = CFG.core.getCiv(n).getSeaAccess_Provinces_Size() - 1; n4 >= 0; --n4) {
            for (n3 = 0; n3 < CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n4)).getNeighSeaProvincesSize(); ++n3) {
                float f2;
                if (!((Boolean)arrayList.get(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n4)).getNeighSeaProvinces(n3)).getBasinID())).booleanValue()) continue;
                if (CFG.core.getCiv(n).getCivRegion(CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n4)).getCivRegionID()).checkRegionBordersWithEnemy(n) || !((f2 = this.moveAtWar_AtSea_FromProvinceID_Score(n, CFG.core.getCiv(n).getSeaAccessProvinces().get(n4), n2, false, n7)) > f)) continue block2;
                n6 = CFG.core.getCiv(n).getSeaAccessProvinces().get(n4);
                f = f2;
                continue block2;
            }
        }
        if (n6 >= 0) {
            if (CFG.core.getProv(n6).getLvlOfPort() <= 0) {
                n3 = 0;
                for (n4 = 0; n4 < CFG.core.getProv(n6).getNeighProvincesSize(); ++n4) {
                    if (CFG.core.getProv(CFG.core.getProv(n6).getNeighProvinces(n4)).getCivId() != n || CFG.core.getProv(CFG.core.getProv(n6).getNeighProvinces(n4)).getLvlOfPort() <= 0) continue;
                    n6 = CFG.core.getProv(n6).getNeighProvinces(n4);
                    n3 = 1;
                    break;
                }
                if (n3 == 0) {
                    block5: for (n4 = 0; n4 < CFG.core.getProv(n6).getNeighProvincesSize(); ++n4) {
                        if (CFG.core.getProv(CFG.core.getProv(n6).getNeighProvinces(n4)).getCivId() != n || CFG.core.getProv(CFG.core.getProv(n6).getNeighProvinces(n4)).getLvlOfPort() <= 0) continue;
                        for (int i = 0; i < CFG.core.getProv(CFG.core.getProv(n6).getNeighProvinces(n4)).getNeighProvincesSize(); ++i) {
                            if (CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(n6).getNeighProvinces(n4)).getNeighProvinces(i)).getCivId() != n || CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(n6).getNeighProvinces(n4)).getNeighProvinces(i)).getLvlOfPort() <= 0) continue;
                            n6 = CFG.core.getProv(CFG.core.getProv(n6).getNeighProvinces(n4)).getNeighProvinces(i);
                            n4 = CFG.core.getProv(n6).getNeighProvincesSize();
                            continue block5;
                        }
                    }
                }
            }
            CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.add(new CivArmyMission_NavalInvasion(n, n6, n2));
            CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.get(CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.size() - 1).action(n);
        }
    }

    public final float moveAtWar_AtSea_ToProvinceID_Score(int n, int n2, boolean bl) {
        return ((float)CFG.core.getProv(n2).getPotential() + (float)(CFG.core.getProv(n2).getPotentialRegion() * CFG.core.getCiv(CFG.core.getProv(n2).getCivId()).getCivRegion(CFG.core.getProv(n2).getCivRegionID()).getProvincesSize()) / (float)CFG.core.getCiv(CFG.core.getProv(n2).getCivId()).getNumOfProvs()) * (bl ? 1.625f : (CFG.core.getProv(n2).isOccupied() ? 0.725f : 1.0f)) * (CFG.core.getProv(n2).isCapital() ? (CFG.core.getProv(n2).getCivId() != n ? 0.725f : 1.45f) : 1.0f) * (1.0f - CFG.core.getCiv((int)n).civGD.civPers.WAR_ATTACK_NAVAL_DISTANCE * Distance.getDistanceFromAToB_PercOfMax(CFG.gameUpdate.getAdministration_Capital(n), n2));
    }

    public final float moveAtWar_AtSea_FromProvinceID_Score(int n, int n2, int n3, boolean bl, long n4) {
        return (float)CFG.core.getProv(n2).getPotential() * (0.375f + 0.625f * (float)((CFG.core.getProv(n2).getArmyCivID1(n) + (long)(CFG.core.getProv(n2).isOccupied() ? 0 : n4)) / Math.max(1L, CFG.core.getCiv(n).getNumberOfUnits() + n4))) * (CFG.core.getProv(n2).getLvlOfPort() > 0 ? 1.5f : 1.0f) * (1.0f - Distance.getDistanceFromAToB_PercOfMax(n2, n3) / 2.0f);
    }

    public final int moveAtWar_NumOfNotCoveredNeighEnemyProvinces(int n, int n2) {
        int n3 = 0;
        for (int i = 0; i < CFG.core.getProv(n2).getNeighProvincesSize(); ++i) {
            if (!CFG.core.getCivsAtWar(n, CFG.core.getProv(CFG.core.getProv(n2).getNeighProvinces(i)).getCivId()) || CFG.core.getCiv(n).isMovingUnitsToProvID(CFG.core.getProv(n2).getNeighProvinces(i))) continue;
            ++n3;
        }
        return n3;
    }

    public final float moveAtWar_AttackTo_Score(int n, int n2) {
        float f = CFG.core.getProv(n2).getPotentialModified_WAR_MoveTo(n);
        if (CFG.settingsGD.AI_GROUP_UNITS) {
            int n3 = 0;
            int n4 = 0;
            for (int i = 0; i < CFG.core.getProv(n2).getNeighProvincesSize(); ++i) {
                int n5 = CFG.core.getProv(n2).getNeighProvinces(i);
                if (CFG.core.getProv(n5).getCivId() == n) {
                    ++n4;
                    continue;
                }
                if (!CFG.core.getCivsAtWar(n, CFG.core.getProv(n5).getCivId())) continue;
                ++n3;
            }
            if (n3 > n4 + 1) {
                f *= 0.5f;
            }
        }
        return f;
    }

    public final void prepareForWar_Regroup(int n, List<AI_ProvinceInfo_War> list, List<Integer> list2) {
        try {
            if (CFG.core.getCiv((int)n).civGD.iRegroupArmyAtPeace_CheckTurnID <= GameCalendar.TURNID) {
                int n2;
                int n3;
                int n4;
                int n5;
                ArrayList<AI_RegoupArmyData> arrayList = new ArrayList<AI_RegoupArmyData>();
                ArrayList<AI_RegoupArmyData> arrayList2 = new ArrayList<AI_RegoupArmyData>();
                for (n5 = 0; n5 < CFG.core.getCiv((int)n).armiesPositionSize; ++n5) {
                    long n4_val = this.getRegroupArmy_NumOfUnits(n, CFG.core.getCiv((int)n).armiesPosition.get(n5));
                    if (n4_val <= 0L || CFG.oAI.prepareForWar_BordersWithEnemy(n, CFG.core.getCiv((int)n).armiesPosition.get(n5))) continue;
                    arrayList.add(new AI_RegoupArmyData(CFG.core.getCiv((int)n).armiesPosition.get(n5), n4_val));
                }
                for (n5 = 0; n5 < CFG.core.getCiv(n).getArmyInAnotherProvinceSize(); ++n5) {
                    long n4_val = this.getRegroupArmy_NumOfUnits(n, CFG.core.getCiv(n).getArmyInAnotherProviP(n5));
                    if (n4_val <= 0L || CFG.oAI.prepareForWar_BordersWithEnemy(n, CFG.core.getCiv(n).getArmyInAnotherProviP(n5))) continue;
                    n3 = 1;
                    for (n2 = arrayList.size() - 1; n2 >= 0; --n2) {
                        if (((AI_RegoupArmyData)arrayList.get((int)n2)).iProvinceID != CFG.core.getCiv(n).getArmyInAnotherProviP(n5)) continue;
                        n3 = 0;
                    }
                    if (n3 == 0) continue;
                    arrayList2.add(new AI_RegoupArmyData(CFG.core.getCiv(n).getArmyInAnotherProviP(n5), n4_val));
                }
                if (arrayList.size() + arrayList2.size() == CFG.core.getCiv(n).getNumOfProvs()) {
                    arrayList.clear();
                    arrayList2.clear();
                }
                while (arrayList.size() > 0 || arrayList2.size() > 0) {
                    long n6;
                    n2 = -1;
                    n6 = 0L;
                    int n7 = -1;
                    for (n3 = arrayList.size() - 1; n3 >= 0; --n3) {
                        if (n2 >= 0 && n6 >= ((AI_RegoupArmyData)arrayList.get((int)n3)).iArmy) continue;
                        n2 = n3;
                        n6 = ((AI_RegoupArmyData)arrayList.get((int)n3)).iArmy;
                        n7 = 0;
                    }
                    for (n3 = arrayList2.size() - 1; n3 >= 0; --n3) {
                        if (n2 >= 0 && n6 >= ((AI_RegoupArmyData)arrayList2.get((int)n3)).iArmy) continue;
                        n2 = n3;
                        n6 = ((AI_RegoupArmyData)arrayList2.get((int)n3)).iArmy;
                        n7 = 2;
                    }
                    if (n2 >= 0 && n7 >= 0 && n6 > 0L) {
                        switch (n7) {
                            case 0: {
                                this.regroupArmy_PrepareForWar_WithoutDanger(n, (AI_RegoupArmyData)arrayList.get(n2));
                                arrayList.remove(n2);
                                break;
                            }
                            case 2: {
                                this.regroupArmy_PrepareForWar_WithoutDanger(n, (AI_RegoupArmyData)arrayList2.get(n2));
                                arrayList2.remove(n2);
                            }
                        }
                    }
                    if (CFG.core.getCiv(n).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE && CFG.core.getCiv(n).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE_OWN_PROVINCE) continue;
                    return;
                }
                CFG.core.getCiv((int)n).civGD.iRegroupArmyAtPeace_CheckTurnID = 0;
            }
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
    }

    public final boolean moveAtWar_BordersWithEnemyCheck(int n, int n2) {
        Province province = CFG.core.getProv(n2);
        for (int i = 0; i < province.getNeighProvincesSize(); ++i) {
            if (!CFG.core.getCivsAtWar(n, CFG.core.getProv(province.getNeighProvinces(i)).getCivId())) continue;
            return true;
        }
        return false;
    }

    public final void moveAtWar_Regroup(int n, List<AI_ProvinceInfo_War> list, List<Integer> list2) {
        try {
            if (CFG.settingsGD.AI_GROUP_UNITS || CFG.core.getCiv((int)n).civGD.iRegroupArmyAtPeace_CheckTurnID <= GameCalendar.TURNID) {
                int n2;
                int n3;
                int n4;
                int n5;
                int n6;
                int n7;
                ArrayList<AI_RegoupArmyData> arrayList = new ArrayList<AI_RegoupArmyData>();
                ArrayList<AI_RegoupArmyData> arrayList2 = new ArrayList<AI_RegoupArmyData>();
                ArrayList<AI_RegoupArmyData> arrayList3 = new ArrayList<AI_RegoupArmyData>();
                for (n7 = 0; n7 < CFG.core.getCiv((int)n).armiesPositionSize; ++n7) {
                    long n6_val = this.getRegroupArmy_NumOfUnits(n, CFG.core.getCiv((int)n).armiesPosition.get(n7));
                    if (n6_val <= 0L) continue;
                    if (CFG.core.getProv(CFG.core.getCiv((int)n).armiesPosition.get(n7)).getSeaProv()) {
                        arrayList3.add(new AI_RegoupArmyData(CFG.core.getCiv((int)n).armiesPosition.get(n7), n6_val));
                        continue;
                    }
                    if (CFG.core.getProv(CFG.core.getCiv((int)n).armiesPosition.get(n7)).getCivId() != n && !CFG.core.getProv(CFG.core.getCiv((int)n).armiesPosition.get(n7)).getBordersWithEnemy() && !this.moveAtWar_BordersWithEnemyCheck(n, CFG.core.getCiv((int)n).armiesPosition.get(n7))) {
                        arrayList2.add(new AI_RegoupArmyData(CFG.core.getCiv((int)n).armiesPosition.get(n7), n6_val));
                        continue;
                    }
                    if (CFG.core.getProv(CFG.core.getCiv((int)n).armiesPosition.get(n7)).getBordersWithEnemy() || this.moveAtWar_BordersWithEnemyCheck(n, CFG.core.getCiv((int)n).armiesPosition.get(n7))) continue;
                    arrayList.add(new AI_RegoupArmyData(CFG.core.getCiv((int)n).armiesPosition.get(n7), n6_val));
                }
                for (n7 = 0; n7 < CFG.core.getCiv(n).getArmyInAnotherProvinceSize(); ++n7) {
                    long n6_val = this.getRegroupArmy_NumOfUnits(n, CFG.core.getCiv(n).getArmyInAnotherProviP(n7));
                    if (n6_val <= 0L) continue;
                    if (CFG.core.getProv(CFG.core.getCiv(n).getArmyInAnotherProviP(n7)).getSeaProv()) {
                        arrayList3.add(new AI_RegoupArmyData(CFG.core.getCiv(n).getArmyInAnotherProviP(n7), n6_val));
                        continue;
                    }
                    if (CFG.core.getProv(CFG.core.getCiv(n).getArmyInAnotherProviP(n7)).getCivId() != n && !CFG.core.getProv(CFG.core.getCiv(n).getArmyInAnotherProviP(n7)).getBordersWithEnemy() && !this.moveAtWar_BordersWithEnemyCheck(n, CFG.core.getCiv(n).getArmyInAnotherProviP(n7))) {
                        arrayList2.add(new AI_RegoupArmyData(CFG.core.getCiv(n).getArmyInAnotherProviP(n7), n6_val));
                        continue;
                    }
                    if (CFG.core.getProv(CFG.core.getCiv(n).getArmyInAnotherProviP(n7)).getDangerLvl() != 0 || CFG.core.getProv(CFG.core.getCiv(n).getArmyInAnotherProviP(n7)).getBordersWithEnemy() || this.moveAtWar_BordersWithEnemyCheck(n, CFG.core.getCiv(n).getArmyInAnotherProviP(n7))) continue;
                    arrayList.add(new AI_RegoupArmyData(CFG.core.getCiv(n).getArmyInAnotherProviP(n7), n6_val));
                }
                if (arrayList.size() + arrayList2.size() == CFG.core.getCiv(n).getNumOfProvs()) {
                    arrayList.clear();
                    arrayList2.clear();
                }
                while (!arrayList3.isEmpty()) {
                    n5 = -1;
                    n4 = 0;
                    n3 = -1;
                    for (n2 = arrayList3.size() - 1; n2 >= 0; --n2) {
                        if (n5 >= 0 && n4 >= ((AI_RegoupArmyData)arrayList3.get((int)n2)).iArmy) continue;
                        n5 = n2;
                        n4 = (int)((AI_RegoupArmyData)arrayList3.get((int)n2)).iArmy;
                        n3 = 1;
                    }
                    if (n5 >= 0 && n3 >= 0 && n4 > 0) {
                        switch (n3) {
                            case 1: {
                                this.regroupArmy_AtWar_AtSea(n, (AI_RegoupArmyData)arrayList3.get(n5));
                                arrayList3.remove(n5);
                            }
                        }
                    }
                    if (CFG.core.getCiv(n).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE && CFG.core.getCiv(n).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE_OWN_PROVINCE) continue;
                    return;
                }
                while (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
                    n5 = -1;
                    n4 = 0;
                    n3 = -1;
                    for (n2 = arrayList.size() - 1; n2 >= 0; --n2) {
                        if (n5 >= 0 && n4 >= ((AI_RegoupArmyData)arrayList.get((int)n2)).iArmy) continue;
                        n5 = n2;
                        n4 = (int)((AI_RegoupArmyData)arrayList.get((int)n2)).iArmy;
                        n3 = 0;
                    }
                    for (n2 = arrayList2.size() - 1; n2 >= 0; --n2) {
                        if (n5 >= 0 && n4 >= ((AI_RegoupArmyData)arrayList2.get((int)n2)).iArmy) continue;
                        n5 = n2;
                        n4 = (int)((AI_RegoupArmyData)arrayList2.get((int)n2)).iArmy;
                        n3 = 2;
                    }
                    if (n5 >= 0 && n3 >= 0 && n4 > 0) {
                        switch (n3) {
                            case 0: {
                                this.regroupArmy_AtWar_WithoutDanger(n, (AI_RegoupArmyData)arrayList.get(n5));
                                arrayList.remove(n5);
                                break;
                            }
                            case 2: {
                                this.regroupArmy_AtWar_WithoutDanger(n, (AI_RegoupArmyData)arrayList2.get(n5));
                                arrayList2.remove(n5);
                            }
                        }
                    }
                    if (CFG.core.getCiv(n).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE && CFG.core.getCiv(n).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE_OWN_PROVINCE) continue;
                    return;
                }
                CFG.core.getCiv((int)n).civGD.iRegroupArmyAtPeace_CheckTurnID = 0;
            }
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
    }

    public final boolean regroupArmy_AtWar_AtSea(int n, AI_RegoupArmyData aI_RegoupArmyData) {
        int n2;
        Object object;
        int n3;
        ArrayList<AI_ProvinceInfo> arrayList = new ArrayList<AI_ProvinceInfo>();
        Province province = CFG.core.getProv(aI_RegoupArmyData.iProvinceID);
        for (n3 = 0; n3 < province.getNeighProvincesSize(); ++n3) {
            object = CFG.core.getProv(province.getNeighProvinces(n3));
            if (((Province)object).getCivId() != n && !CFG.core.getCivsAtWar(n, ((Province)object).getCivId())) continue;
            arrayList.add(new AI_ProvinceInfo(province.getNeighProvinces(n3), this.getPotential_BasedOnNeighboringProvs(province.getNeighProvinces(n3), n), 1));
        }
        if (!arrayList.isEmpty()) {
            int n4;
            int n5;
            int n6;
            int n7;
            long n8 = 1L;
            float f = 1.0f;
            float f2 = 1.0f;
            float f3 = 1.0f;
            long n9 = 1L;
            ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
            int n10 = arrayList.size();
            long n11 = 0L;
            for (n7 = 0; n7 < n10; ++n7) {
                if (((AI_ProvinceInfo)arrayList.get((int)n7)).iValue > f) {
                    f = ((AI_ProvinceInfo)arrayList.get((int)n7)).iValue;
                }
                if (CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n7)).iProvinceID).getDangerLevel_WithArmy() > n9) {
                    n9 = (long)CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n7)).iProvinceID).getDangerLevel_WithArmy();
                }
                if ((float)CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n7)).iProvinceID).getRegion_NumOfProvinces() > f2) {
                    f2 = (float)CFG.core.getProv(arrayList.get((int)n7).iProvinceID).getRegion_NumOfProvinces();
                }
                if ((float)CFG.core.getProv(arrayList.get((int)n7).iProvinceID).getPotentialRegion() > f3) {
                    f3 = (float)CFG.core.getProv(arrayList.get((int)n7).iProvinceID).getPotentialRegion();
                }
                arrayList2.add((int)(n11 += this.getMovingArmyToProvinceID(n, arrayList.get((int)n7).iProvinceID)));
                if (CFG.core.getProv(arrayList.get((int)n7).iProvinceID).getArmyID(0) + n11 <= n8) continue;
                n8 = CFG.core.getProv(arrayList.get((int)n7).iProvinceID).getArmyID(0) + n11;
            }
            n10 = arrayList.size();
            for (n7 = 0; n7 < n10; ++n7) {
                ((AI_ProvinceInfo)arrayList.get((int)n7)).iValue = this.getValue_PositionOfArmy(n, arrayList, n7, (Integer)arrayList2.get(n7), f, f3, (int)n9, n8, (int)aI_RegoupArmyData.iArmy, (int)aI_RegoupArmyData.iArmy);
            }
            ArrayList<AI_ProvinceInfo> arrayList3 = new ArrayList<AI_ProvinceInfo>();
            while (!arrayList.isEmpty()) {
                int n12 = 0;
                n6 = arrayList.size();
                for (int i = 1; i < n6; ++i) {
                    if (!(((AI_ProvinceInfo)arrayList.get((int)n12)).iValue < arrayList.get((int)i).iValue)) continue;
                    n12 = i;
                }
                arrayList3.add((AI_ProvinceInfo)arrayList.get(n12));
                arrayList.remove(n12);
            }
            float f4 = Math.max((float)aI_RegoupArmyData.iArmy / (float)CFG.core.getCiv(n).getNumberOfUnits(), 0.01f);
            n6 = 1;
            if (GameValues.gvAiArmy.REGROUP_AT_PEACE_MAX_ONE_MOVE_IF_PERC_OF_ARMY > f4) {
                n6 = 1;
            } else {
                n6 = Math.max(1, Math.min((CFG.core.getCiv(n).getMovemPoints() - CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE) / (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE * 2), 1 + CFG.oR.nextInt(3)));
                n6 = f4 > 0.34f ? Math.min(n6, 4) : (f4 > 0.24f ? Math.min(n6, 3) : (f4 > 0.1f ? Math.min(n6, 2) : Math.min(n6, 1)));
            }
            ArrayList<AI_ProvinceInfo> arrayList4 = new ArrayList<AI_ProvinceInfo>();
            float f5 = 0.0f;
            for (n5 = 0; n5 < n6 && n5 < arrayList3.size(); ++n5) {
                arrayList4.add((AI_ProvinceInfo)arrayList3.get(n5));
                f5 += ((AI_ProvinceInfo)arrayList3.get((int)n5)).iValue;
            }
            for (n5 = 0; n5 < arrayList4.size() && (n4 = (int)Math.ceil((float)aI_RegoupArmyData.iArmy * ((AI_ProvinceInfo)arrayList4.get((int)n5)).iValue / f5)) > 0; ++n5) {
                RegroupArmy_AtWar regroupArmy_AtWar = new RegroupArmy_AtWar(n, aI_RegoupArmyData.iProvinceID, ((AI_ProvinceInfo)arrayList4.get((int)n5)).iProvinceID);
                if (regroupArmy_AtWar.getRouteSize() <= 0) continue;
                if (regroupArmy_AtWar.getRouteSize() == 1) {
                    if (!CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, ((AI_ProvinceInfo)arrayList4.get((int)n5)).iProvinceID, n4, n, true, false)) continue;
                    continue;
                }
                if (!CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, regroupArmy_AtWar.getRoute(0), n4, n, true, false)) continue;
                regroupArmy_AtWar.setFromProvinceID(regroupArmy_AtWar.getRoute(0));
                regroupArmy_AtWar.removeRoute(0);
                regroupArmy_AtWar.setNumOfUnits(n4);
                CFG.core.getCiv(n).addRegroupArmy(regroupArmy_AtWar);
            }
            return true;
        }
        block7: for (n3 = CFG.core.getCiv(n).getSeaAccess_Provinces_Size() - 1; n3 >= 0; --n3) {
            object = CFG.core.getProv(CFG.core.getCiv(n).getSeaAccessProvinces().get(n3));
            for (n2 = 0; n2 < ((Province)object).getNeighSeaProvincesSize(); ++n2) {
                if (CFG.core.getProv(((Province)object).getNeighSeaProvinces(n2)).getBasinID() != CFG.core.getProv(aI_RegoupArmyData.iProvinceID).getBasinID()) continue;
                arrayList.add(new AI_ProvinceInfo(CFG.core.getCiv(n).getSeaAccessProvinces().get(n3), this.getPotential_BasedOnNeighboringProvs(CFG.core.getCiv(n).getSeaAccessProvinces().get(n3), n), 1));
                continue block7;
            }
        }
        if (!arrayList.isEmpty()) {
            Object object2;
            long n13 = 1L;
            float f = 1.0f;
            float f6 = 1.0f;
            float f7 = 1.0f;
            long n14 = 1L;
            ArrayList<Integer> arrayList5 = new ArrayList<Integer>();
            int n15 = arrayList.size();
            long n16 = 0L;
            for (n2 = 0; n2 < n15; ++n2) {
                if (((AI_ProvinceInfo)arrayList.get((int)n2)).iValue > f) {
                    f = ((AI_ProvinceInfo)arrayList.get((int)n2)).iValue;
                }
                if ((long)((Province)(object2 = CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n2)).iProvinceID))).getDangerLevel_WithArmy() > n14) {
                    n14 = (long)((Province)object2).getDangerLevel_WithArmy();
                }
                if ((float)((Province)object2).getRegion_NumOfProvinces() > f6) {
                    f6 = (float)((Province)object2).getRegion_NumOfProvinces();
                }
                if ((float)((Province)object2).getPotentialRegion() > f7) {
                    f7 = (float)((Province)object2).getPotentialRegion();
                }
                arrayList5.add((int)(n16 += (long)this.getMovingArmyToProvinceID(n, arrayList.get((int)n2).iProvinceID)));
                if ((long)((Province)object2).getArmyID(0) + n16 <= n13) continue;
                n13 = (long)((Province)object2).getArmyID(0) + n16;
            }
            n15 = arrayList.size();
            for (n2 = 0; n2 < n15; ++n2) {
                ((AI_ProvinceInfo)arrayList.get((int)n2)).iValue = this.getValue_PositionOfArmy(n, arrayList, n2, (Integer)arrayList5.get(n2), f, f7, (int)n14, n13, (int)aI_RegoupArmyData.iArmy, (int)aI_RegoupArmyData.iArmy);
            }
            object2 = new ArrayList();
            if (!arrayList.isEmpty()) {
                int n17 = 0;
                int n18 = arrayList.size();
                for (int i = 1; i < n18; ++i) {
                    if (!(arrayList.get((int)n17).iValue < arrayList.get((int)i).iValue)) continue;
                    n17 = i;
                }
                ((ArrayList)object2).add(arrayList.get(n17));
                arrayList.remove(n17);
            }
            if (((RegroupArmy)(object = new RegroupArmy_AtWar(n, aI_RegoupArmyData.iProvinceID, ((AI_ProvinceInfo)((ArrayList)object2).get((int)0)).iProvinceID))).getRouteSize() > 0) {
                if (((RegroupArmy)object).getRouteSize() == 1) {
                    if (!CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, ((AI_ProvinceInfo)((ArrayList)object2).get((int)0)).iProvinceID, (int)aI_RegoupArmyData.iArmy, n, true, false)) {
                        
                    }
                } else if (CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, ((RegroupArmy)object).getRoute(0), (int)aI_RegoupArmyData.iArmy, n, true, false)) {
                    ((RegroupArmy)object).setFromProvinceID(((RegroupArmy)object).getRoute(0));
                    ((RegroupArmy)object).removeRoute(0);
                    ((RegroupArmy)object).setNumOfUnits((int)aI_RegoupArmyData.iArmy);
                    CFG.core.getCiv(n).addRegroupArmy((RegroupArmy)object);
                }
            }
            return true;
        }
        if (CFG.core.getCiv(n).getCapitalProvID() >= 0 && CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).getCivId() == n) {
            object = new RegroupArmy_AtWar(n, aI_RegoupArmyData.iProvinceID, CFG.core.getCiv(n).getCapitalProvID());
            if (((RegroupArmy)object).getRouteSize() > 0) {
                if (((RegroupArmy)object).getRouteSize() == 1) {
                    if (!CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, CFG.core.getCiv(n).getCapitalProvID(), (int)aI_RegoupArmyData.iArmy, n, true, false)) {
                        
                    }
                } else if (CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, ((RegroupArmy)object).getRoute(0), (int)aI_RegoupArmyData.iArmy, n, true, false)) {
                    ((RegroupArmy)object).setFromProvinceID(((RegroupArmy)object).getRoute(0));
                    ((RegroupArmy)object).removeRoute(0);
                    ((RegroupArmy)object).setNumOfUnits((int)aI_RegoupArmyData.iArmy);
                    CFG.core.getCiv(n).addRegroupArmy((RegroupArmy)object);
                }
            } else {
                CFG.gameAction.disbandArmy(aI_RegoupArmyData.iProvinceID, (int)aI_RegoupArmyData.iArmy, n);
            }
        } else {
            CFG.gameAction.disbandArmy(aI_RegoupArmyData.iProvinceID, (int)aI_RegoupArmyData.iArmy, n);
        }
        return true;
    }

    public final boolean regroupArmy_PrepareForWar_WithoutDanger(int n, AI_RegoupArmyData aI_RegoupArmyData) {
        try {
            int n2;
            int n3;
            int n4;
            float f = Math.max((float)aI_RegoupArmyData.iArmy / (float)CFG.core.getCiv(n).getNumberOfUnits(), 0.01f);
            try {
                if (CFG.core.getCiv(n).getCivRegion(CFG.core.getProv(aI_RegoupArmyData.iProvinceID).getCivRegionID()).getProvincesSize() > 1) {
                    int n5;
                    int n6;
                    int n7 = 1;
                    float f2 = 1.0f;
                    ArrayList<AI_ProvinceInfo> arrayList = new ArrayList<AI_ProvinceInfo>();
                    for (n4 = CFG.core.getCiv((int)CFG.core.getProv((int)aI_RegoupArmyData.iProvinceID).getCivId()).lFrontLines.size() - 1; n4 >= 0; --n4) {
                        for (n3 = 0; n3 < CFG.core.getCiv((int)n).civGD.civPlans.iWarPrepsSize; ++n3) {
                            if (CFG.core.getCiv((int)CFG.core.getProv((int)aI_RegoupArmyData.iProvinceID).getCivId()).lFrontLines.get((int)n4).iWithCivID != CFG.core.getCiv((int)n).civGD.civPlans.warPreps.get((int)n3).onCivID) continue;
                            try {
                                if (CFG.core.getProv(CFG.core.getCiv((int)CFG.core.getProv((int)aI_RegoupArmyData.iProvinceID).getCivId()).lFrontLines.get((int)n4).lProvinces.get(0)).getCivRegionID() != CFG.core.getProv(aI_RegoupArmyData.iProvinceID).getCivRegionID()) continue;
                                for (n6 = CFG.core.getCiv((int)CFG.core.getProv((int)aI_RegoupArmyData.iProvinceID).getCivId()).lFrontLines.get((int)n4).lProvinces.size() - 1; n6 >= 0; --n6) {
                                    n5 = 0;
                                    for (n2 = arrayList.size() - 1; n2 >= 0; --n2) {
                                        if (((AI_ProvinceInfo)arrayList.get((int)n2)).iProvinceID != CFG.core.getCiv((int)CFG.core.getProv((int)aI_RegoupArmyData.iProvinceID).getCivId()).lFrontLines.get((int)n4).lProvinces.get(n6)) continue;
                                        n5 = 1;
                                        break;
                                    }
                                    if (n5 != 0) continue;
                                    arrayList.add(new AI_ProvinceInfo(CFG.core.getCiv((int)CFG.core.getProv((int)aI_RegoupArmyData.iProvinceID).getCivId()).lFrontLines.get((int)n4).lProvinces.get(n6), 1, 1));
                                }
                                continue;
                            }
                            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                                
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        int n8;
                        int n9;
                        long n5_l = 1L;
                        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
                        int n10 = arrayList.size();
                        long n11 = 0L;
                        for (n9 = 0; n9 < n10; ++n9) {
                            if (((AI_ProvinceInfo)arrayList.get((int)n9)).iValue > f2) {
                                f2 = ((AI_ProvinceInfo)arrayList.get((int)n9)).iValue;
                            }
                            if ((long)CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n9)).iProvinceID).getDangerLevel_WithArmy() > n7) {
                                n7 = (int)CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n9)).iProvinceID).getDangerLevel_WithArmy();
                            }
                            arrayList2.add((int)(n11 += (long)this.getMovingArmyToProvinceID(n, ((AI_ProvinceInfo)arrayList.get((int)n9)).iProvinceID)));
                            if ((long)CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n9)).iProvinceID).getArmyID(0) + n11 <= n5_l) continue;
                            n5_l = (long)CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n9)).iProvinceID).getArmyID(0) + n11;
                        }
                        n10 = arrayList.size();
                        for (n9 = 0; n9 < n10; ++n9) {
                            ((AI_ProvinceInfo)arrayList.get((int)n9)).iValue = (1.0f - (float)((long)CFG.core.getProvinceArmy(((AI_ProvinceInfo)arrayList.get((int)n9)).iProvinceID) + (long)((Integer)arrayList2.get(n9)).intValue()) / (float)n5_l + 0.2f * ((float)CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n9)).iProvinceID).getDangerLvl() / (float)n7) + 0.2f * ((float)CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n9)).iProvinceID).getPotentialModified_WAR_MoveFrom(n) / f2) + 0.2f * (float)CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n9)).iProvinceID).getNeighProvinceOfCivWasLost()) * ((float)((AI_ProvinceInfo)arrayList.get((int)n9)).iRecruitable == 0.0f ? 0.725f : 1.0f);
                        }
                        ArrayList<AI_ProvinceInfo> arrayList3 = new ArrayList<AI_ProvinceInfo>();
                        while (arrayList.size() > 0) {
                            n8 = 0;
                            int n12 = arrayList.size();
                            for (int i = 1; i < n12; ++i) {
                                if (!(((AI_ProvinceInfo)arrayList.get((int)n8)).iValue < ((AI_ProvinceInfo)arrayList.get((int)i)).iValue)) continue;
                                n8 = i;
                            }
                            arrayList3.add((AI_ProvinceInfo)arrayList.get(n8));
                            arrayList.remove(n8);
                        }
                        n8 = 1;
                        if (GameValues.gvAiArmy.REGROUP_AT_PEACE_MAX_ONE_MOVE_IF_PERC_OF_ARMY > f) {
                            n8 = 1;
                        } else {
                            n8 = Math.max(1, Math.min((CFG.core.getCiv(n).getMovemPoints() - CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE) / CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE_OWN_PROVINCE, Math.min(CFG.core.getCiv(n).getNumOfProvs(), 2 + CFG.oR.nextInt(3))));
                            n8 = f > 0.4f ? Math.min(n8, 4) : (f > 0.3f ? Math.min(n8, 3) : (f > 0.2f ? Math.min(n8, 2) : Math.min(n8, 1)));
                        }
                        ArrayList<AI_ProvinceInfo> arrayList4 = new ArrayList<AI_ProvinceInfo>();
                        float f3 = 0.0f;
                        for (n6 = 0; n6 < n8 && n6 < arrayList3.size(); ++n6) {
                            arrayList4.add((AI_ProvinceInfo)arrayList3.get(n6));
                            f3 += ((AI_ProvinceInfo)arrayList3.get((int)n6)).iValue;
                        }
                        for (n6 = 0; n6 < arrayList4.size(); ++n6) {
                            int n3_val = (int)Math.ceil((double)((double)aI_RegoupArmyData.iArmy * (double)((AI_ProvinceInfo)arrayList4.get((int)n6)).iValue / (double)f3));
                            if (n3_val <= 0) continue;
                            RegroupArmy regroupArmy = new RegroupArmy(n, aI_RegoupArmyData.iProvinceID, ((AI_ProvinceInfo)arrayList4.get((int)n6)).iProvinceID);
                            if (regroupArmy.getRouteSize() <= 0) continue;
                            if (regroupArmy.getRouteSize() == 1) {
                                if (!CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, ((AI_ProvinceInfo)arrayList4.get((int)n6)).iProvinceID, (long)n3_val, n, true, false)) continue;
                                continue;
                            }
                            if (!CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, regroupArmy.getRoute(0), (long)n3_val, n, true, false)) continue;
                            regroupArmy.setFromProvinceID(regroupArmy.getRoute(0));
                            regroupArmy.removeRoute(0);
                            regroupArmy.setNumOfUnits((long)n3_val);
                            CFG.core.getCiv(n).addRegroupArmy(regroupArmy);
                        }
                        return true;
                    }
                }
            }
            catch (NullPointerException nullPointerException) {
                
            }
            List<AI_NeighProvinces> list = this.getAllNeighboringProvincesInRange_RegroupPrepareForWAr(aI_RegoupArmyData.iProvinceID, n, CFG.core.getCiv((int)n).civGD.civPers.REGROUP_AT_PEACE_MAX_PROVINCES + CFG.core.getCiv(n).getNumOfProvs() / 15, new ArrayList<AI_NeighProvinces>(), new ArrayList<Integer>());
            if (list.size() > 0) {
                int n13 = CFG.core.getCiv(n).getMovemPoints() / CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE;
                n13 = f > 0.54f ? Math.min(n13, 4) : (f > 0.35f ? Math.min(n13, 3) : (f > 0.25f ? Math.min(n13, 2) : Math.min(n13, 1)));
                boolean bl = false;
                for (n4 = list.size() - 1; n4 >= 0; --n4) {
                    if (CFG.core.getProv(list.get((int)n4).iProvinceID).getDangerLvl() <= 0) continue;
                    bl = true;
                    break;
                }
                if (bl) {
                    ArrayList<Integer> arrayList = new ArrayList<Integer>();
                    ArrayList<Integer> arrayList5 = new ArrayList<Integer>();
                    for (int i = list.size() - 1; i >= 0; --i) {
                        arrayList5.add(i);
                    }
                    while (arrayList5.size() > 0) {
                        n2 = 0;
                        for (n3 = arrayList5.size() - 1; n3 > 0; --n3) {
                            if (CFG.core.getProv(list.get((int)((Integer)arrayList5.get((int)n2)).intValue()).iProvinceID).getDangerLevel_WithArmy() >= CFG.core.getProv(list.get((int)((Integer)arrayList5.get((int)n3)).intValue()).iProvinceID).getDangerLevel_WithArmy()) continue;
                            n2 = n3;
                        }
                        arrayList.add((Integer)arrayList5.get(n2));
                        arrayList5.remove(n2);
                    }
                    int n2_val = 0;
                    for (n3 = 0; n3 < n13 && n3 < arrayList.size(); ++n3) {
                        n2_val += CFG.core.getProv(list.get((int)((Integer)arrayList.get((int)n3)).intValue()).iProvinceID).getDangerLevel_WithArmy();
                    }
                    int n14 = -1;
                    for (int i = 0; i < n13 && i < arrayList.size() && aI_RegoupArmyData.iArmy > 0L; ++i) {
                        RegroupArmy regroupArmy = new RegroupArmy(n, aI_RegoupArmyData.iProvinceID, list.get((int)((Integer)arrayList.get((int)i)).intValue()).iProvinceID);
                        if (regroupArmy.getRouteSize() > 0) {
                            long n15 = i == n13 || i == arrayList.size() - 1 ? aI_RegoupArmyData.iArmy : (long)Math.ceil((double)((double)aI_RegoupArmyData.iArmy * ((double)CFG.core.getProv(list.get((int)((Integer)arrayList.get((int)i)).intValue()).iProvinceID).getDangerLevel_WithArmy() / (double)n2_val)));
                            aI_RegoupArmyData.iArmy -= n15;
                            if (n15 <= 0L) break;
                            if (!CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, regroupArmy.getRoute(0), n15, n, true, false)) continue;
                            if (regroupArmy.getRouteSize() > 1) {
                                CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.add(new CivArmyMission_RegroupAfterRecruitment(n, regroupArmy.getRoute(0), list.get((int)((Integer)arrayList.get((int)i)).intValue()).iProvinceID, n15));
                            }
                            n14 = i;
                            continue;
                        }
                        if (n14 < 0 || (regroupArmy = new RegroupArmy(n, aI_RegoupArmyData.iProvinceID, list.get((int)((Integer)arrayList.get((int)n14)).intValue()).iProvinceID)).getRouteSize() <= 0 || !CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, regroupArmy.getRoute(0), aI_RegoupArmyData.iArmy, n, true, false)) continue;
                        if (regroupArmy.getRouteSize() > 1) {
                            CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.add(new CivArmyMission_RegroupAfterRecruitment(n, regroupArmy.getRoute(0), list.get((int)((Integer)arrayList.get((int)n14)).intValue()).iProvinceID, aI_RegoupArmyData.iArmy));
                        }
                        return true;
                    }
                    if (n14 >= 0) {
                        return true;
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            CFG.exceptionStack(indexOutOfBoundsException);
        }
        catch (StackOverflowError stackOverflowError) {
            CFG.exceptionStack(stackOverflowError);
        }
        return false;
    }

    public final boolean regroupArmy_AtWar_WithoutDanger(int n, AI_RegoupArmyData aI_RegoupArmyData) {
        try {
            Serializable serializable;
            int n2;
            float f = Math.max((float)aI_RegoupArmyData.iArmy / (float)CFG.core.getCiv(n).getNumberOfUnits(), 0.01f);
            try {
                if (CFG.core.getCiv(n).getCivRegion(CFG.core.getProv(aI_RegoupArmyData.iProvinceID).getCivRegionID()).getProvincesSize() > 1) {
                    int n3 = 1;
                    float f2 = 1.0f;
                    ArrayList<AI_ProvinceInfo> arrayList = new ArrayList<AI_ProvinceInfo>();
                    for (n2 = CFG.core.getCiv((int)CFG.core.getProv((int)aI_RegoupArmyData.iProvinceID).getCivId()).lFrontLines.size() - 1; n2 >= 0; --n2) {
                        if (!CFG.core.getCivsAtWar(n, CFG.core.getCiv((int)CFG.core.getProv((int)aI_RegoupArmyData.iProvinceID).getCivId()).lFrontLines.get((int)n2).iWithCivID)) continue;
                        try {
                            int n4;
                            if (CFG.core.getProv(CFG.core.getCiv((int)CFG.core.getProv((int)aI_RegoupArmyData.iProvinceID).getCivId()).lFrontLines.get((int)n2).lProvinces.get(0)).getCivRegionID() != CFG.core.getProv(aI_RegoupArmyData.iProvinceID).getCivRegionID() && (!CFG.settingsGD.AI_GROUP_UNITS || Distance.getDistanceFromAToB_PercOfMax(aI_RegoupArmyData.iProvinceID, n4 = CFG.core.getCiv((int)n).lFrontLines.get((int)n2).lProvinces.get(0).intValue()) > 0.15f || ((RegroupArmy)(serializable = new RegroupArmy_ToTheFront_Double(n, aI_RegoupArmyData.iProvinceID, n4))).getRouteSize() <= 0 || ((RegroupArmy)serializable).getRouteSize() > 4)) continue;
                            for (n4 = CFG.core.getCiv((int)CFG.core.getProv((int)aI_RegoupArmyData.iProvinceID).getCivId()).lFrontLines.get((int)n2).lProvinces.size() - 1; n4 >= 0; --n4) {
                                boolean bl = false;
                                for (int i = arrayList.size() - 1; i >= 0; --i) {
                                    if (((AI_ProvinceInfo)arrayList.get((int)i)).iProvinceID != CFG.core.getCiv((int)CFG.core.getProv((int)aI_RegoupArmyData.iProvinceID).getCivId()).lFrontLines.get((int)n2).lProvinces.get(n4)) continue;
                                    bl = true;
                                    break;
                                }
                                if (bl) continue;
                                arrayList.add(new AI_ProvinceInfo(CFG.core.getCiv((int)CFG.core.getProv((int)aI_RegoupArmyData.iProvinceID).getCivId()).lFrontLines.get((int)n2).lProvinces.get(n4), 1, 1));
                            }
                            continue;
                        }
                        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            
                        }
                    }
                    if (arrayList.size() > 0) {
                        int n5;
                        int n6;
                        int n7;
                        long n8 = 1L;
                        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
                        int n9 = arrayList.size();
                        long n10 = 0L;
                        for (n7 = 0; n7 < n9; ++n7) {
                            if (((AI_ProvinceInfo)arrayList.get((int)n7)).iValue > f2) {
                                f2 = ((AI_ProvinceInfo)arrayList.get((int)n7)).iValue;
                            }
                            if ((long)CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n7)).iProvinceID).getDangerLevel_WithArmy() > (long)n3) {
                                n3 = (int)CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n7)).iProvinceID).getDangerLevel_WithArmy();
                            }
                            arrayList2.add((int)(n10 += (long)this.getMovingArmyToProvinceID(n, ((AI_ProvinceInfo)arrayList.get((int)n7)).iProvinceID)));
                            if ((long)CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n7)).iProvinceID).getArmyID(0) + n10 <= n8) continue;
                            n8 = (long)CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n7)).iProvinceID).getArmyID(0) + n10;
                        }
                        n9 = arrayList.size();
                        for (n7 = 0; n7 < n9; ++n7) {
                            float f3 = 1.0f - (float)((long)CFG.core.getProvinceArmy(((AI_ProvinceInfo)arrayList.get((int)n7)).iProvinceID) + (long)((Integer)arrayList2.get(n7)).intValue()) / (float)n8;
                            ((AI_ProvinceInfo)arrayList.get((int)n7)).iValue = (f3 * 1.5f + 0.2f * ((float)CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n7)).iProvinceID).getDangerLvl() / (float)n3) + 0.1f * ((float)CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n7)).iProvinceID).getPotentialModified_WAR_MoveFrom(n) / f2) + 0.3f * (float)CFG.core.getProv(((AI_ProvinceInfo)arrayList.get((int)n7)).iProvinceID).getNeighProvinceOfCivWasLost()) * ((float)((AI_ProvinceInfo)arrayList.get((int)n7)).iRecruitable == 0.0f ? 0.725f : 1.0f);
                        }
                        ArrayList<AI_ProvinceInfo> arrayList3 = new ArrayList<AI_ProvinceInfo>();
                        while (arrayList.size() > 0) {
                            n6 = 0;
                            int n11 = arrayList.size();
                            for (int i = 1; i < n11; ++i) {
                                if (!(((AI_ProvinceInfo)arrayList.get((int)n6)).iValue < ((AI_ProvinceInfo)arrayList.get((int)i)).iValue)) continue;
                                n6 = i;
                            }
                            arrayList3.add((AI_ProvinceInfo)arrayList.get(n6));
                            arrayList.remove(n6);
                        }
                        n6 = 1;
                        if (GameValues.gvAiArmy.REGROUP_AT_PEACE_MAX_ONE_MOVE_IF_PERC_OF_ARMY > f) {
                            n6 = 1;
                        } else {
                            n6 = Math.max(1, Math.min((CFG.core.getCiv(n).getMovemPoints() - CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE) / CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE_OWN_PROVINCE, Math.min(CFG.core.getCiv(n).getNumOfProvs(), 2 + CFG.oR.nextInt(3))));
                            int n12 = f > 0.34f ? Math.min(n6, 4) : (f > 0.24f ? Math.min(n6, 3) : (n6 = f > 0.1f ? Math.min(n6, 2) : Math.min(n6, 1)));
                        }
                        if (CFG.settingsGD.AI_GROUP_UNITS) {
                            n6 = Math.max(1, Math.min(n6, 2));
                        }
                        ArrayList<AI_ProvinceInfo> arrayList4 = new ArrayList<AI_ProvinceInfo>();
                        float f4 = 0.0f;
                        for (n5 = 0; n5 < n6 && n5 < arrayList3.size(); ++n5) {
                            arrayList4.add((AI_ProvinceInfo)arrayList3.get(n5));
                            f4 += ((AI_ProvinceInfo)arrayList3.get((int)n5)).iValue;
                        }
                        for (n5 = 0; n5 < arrayList4.size(); ++n5) {
                            int n13;
                            int n14 = (int)aI_RegoupArmyData.iArmy;
                            if (CFG.core.getCiv(n).getBordersWithEnemy() == 0 && CFG.core.getProv(aI_RegoupArmyData.iProvinceID).getCivId() == n && CFG.core.getProv(((AI_ProvinceInfo)arrayList4.get((int)n5)).iProvinceID).getCivId() != n) {
                                n14 = (int)Math.ceil((float)n14 * (0.72f + (float)CFG.oR.nextInt(12) / 100.0f));
                            }
                            if ((n13 = (int)Math.ceil((float)n14 * ((AI_ProvinceInfo)arrayList4.get((int)n5)).iValue / f4)) <= 0) break;
                            RegroupArmy_ToTheFront_Double regroupArmy_ToTheFront_Double = new RegroupArmy_ToTheFront_Double(n, aI_RegoupArmyData.iProvinceID, ((AI_ProvinceInfo)arrayList4.get((int)n5)).iProvinceID);
                            if (regroupArmy_ToTheFront_Double.getRouteSize() <= 0) continue;
                            if (regroupArmy_ToTheFront_Double.getRouteSize() == 1) {
                                if (!CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, ((AI_ProvinceInfo)arrayList4.get((int)n5)).iProvinceID, n13, n, true, false)) continue;
                                continue;
                            }
                            if (!CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, regroupArmy_ToTheFront_Double.getRoute(0), n13, n, true, false)) continue;
                            regroupArmy_ToTheFront_Double.setFromProvinceID(regroupArmy_ToTheFront_Double.getRoute(0));
                            regroupArmy_ToTheFront_Double.removeRoute(0);
                            regroupArmy_ToTheFront_Double.setNumOfUnits(n13);
                            CFG.core.getCiv(n).addRegroupArmy(regroupArmy_ToTheFront_Double);
                        }
                        return true;
                    }
                }
            }
            catch (NullPointerException nullPointerException) {
                
            }
            List<AI_NeighProvinces> list = this.getAllNeighboringProvincesInRange_RegroupAtWar(aI_RegoupArmyData.iProvinceID, n, CFG.core.getCiv((int)n).civGD.civPers.REGROUP_AT_PEACE_MAX_PROVINCES + CFG.core.getCiv(n).getNumOfProvs() / 15, new ArrayList<AI_NeighProvinces>(), new ArrayList<Integer>());
            if (list.size() > 0) {
                int n15 = CFG.core.getCiv(n).getMovemPoints() / CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE;
                int n16 = f > 0.54f ? Math.min(n15, 4) : (f > 0.34f ? Math.min(n15, 3) : (n15 = f > 0.19f ? Math.min(n15, 2) : Math.min(n15, 1)));
                if (CFG.settingsGD.AI_GROUP_UNITS) {
                    n15 = 1;
                }
                boolean bl = false;
                for (n2 = list.size() - 1; n2 >= 0; --n2) {
                    if (CFG.core.getProv(list.get((int)n2).iProvinceID).getDangerLvl() <= 0) continue;
                    bl = true;
                    break;
                }
                if (bl) {
                    int n17;
                    serializable = new ArrayList<Integer>();
                    ArrayList<Integer> arrayList = new ArrayList<Integer>();
                    for (int i = list.size() - 1; i >= 0; --i) {
                        arrayList.add(i);
                    }
                    while (arrayList.size() > 0) {
                        n17 = 0;
                        for (int i = arrayList.size() - 1; i > 0; --i) {
                            if (CFG.core.getProv(list.get((int)((Integer)arrayList.get((int)n17)).intValue()).iProvinceID).getDangerLevel_WithArmy() >= CFG.core.getProv(list.get((int)((Integer)arrayList.get((int)i)).intValue()).iProvinceID).getDangerLevel_WithArmy()) continue;
                            n17 = i;
                        }
                        ((ArrayList)serializable).add((Integer)arrayList.get(n17));
                        arrayList.remove(n17);
                    }
                    n17 = 0;
                    for (int i = 0; i < n15 && i < ((ArrayList)serializable).size(); ++i) {
                        n17 += CFG.core.getProv(list.get((int)((Integer)((ArrayList)serializable).get((int)i)).intValue()).iProvinceID).getDangerLevel_WithArmy();
                    }
                    int n18 = -1;
                    for (int i = 0; i < n15 && i < ((ArrayList)serializable).size() && aI_RegoupArmyData.iArmy > 0; ++i) {
                        RegroupArmy_AtWar regroupArmy_AtWar = new RegroupArmy_AtWar(n, aI_RegoupArmyData.iProvinceID, list.get((int)((Integer)((ArrayList)serializable).get((int)i)).intValue()).iProvinceID);
                        if (regroupArmy_AtWar.getRouteSize() <= 0) continue;
                        int n19 = (int)aI_RegoupArmyData.iArmy;
                        if (CFG.core.getCiv(n).getBordersWithEnemy() == 0 && CFG.core.getProv(aI_RegoupArmyData.iProvinceID).getCivId() == n && CFG.core.getProv(list.get((int)((Integer)((ArrayList)serializable).get((int)i)).intValue()).iProvinceID).getCivId() != n) {
                            n19 = (int)Math.ceil((float)n19 * (0.72f + (float)CFG.oR.nextInt(12) / 100.0f));
                        }
                        int n20 = i == n15 || i == ((ArrayList)serializable).size() - 1 ? n19 : (int)Math.ceil((float)n19 * ((float)CFG.core.getProv(list.get((int)((Integer)((ArrayList)serializable).get((int)i)).intValue()).iProvinceID).getDangerLevel_WithArmy() / (float)n17));
                        aI_RegoupArmyData.iArmy -= n20;
                        if (n20 <= 0) break;
                        if (!CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, regroupArmy_AtWar.getRoute(0), n20, n, true, false)) continue;
                        if (regroupArmy_AtWar.getRouteSize() > 1) {
                            CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.add(new CivArmyMission_RegroupAfterRecruitment_War_Double(n, regroupArmy_AtWar.getRoute(0), list.get((int)((Integer)((ArrayList)serializable).get((int)i)).intValue()).iProvinceID, n20));
                        }
                        n18 = i;
                    }
                    if (n18 >= 0) {
                        return true;
                    }
                }
            }
            if (CFG.core.getCiv(n).getCapitalProvID() >= 0 && CFG.core.getCiv(n).getCapitalProvID() != aI_RegoupArmyData.iProvinceID && (CFG.core.getCiv(n).getBordersWithEnemy() > 0 || CFG.core.getProv(aI_RegoupArmyData.iProvinceID).getNeighSeaProvincesSize() <= 0 || CFG.oR.nextInt(100) >= 80) && CFG.oR.nextInt(100) < 15) {
                if (f < 0.01f) {
                    CFG.gameAction.disbandArmy(aI_RegoupArmyData.iProvinceID, (int)aI_RegoupArmyData.iArmy, n);
                } else {
                    RegroupArmy_AtWar regroupArmy_AtWar = new RegroupArmy_AtWar(n, aI_RegoupArmyData.iProvinceID, CFG.core.getCiv(n).getCapitalProvID());
                    if (regroupArmy_AtWar.getRouteSize() > 0) {
                        if (regroupArmy_AtWar.getRouteSize() == 1) {
                            if (!CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, CFG.core.getCiv(n).getCapitalProvID(), (int)aI_RegoupArmyData.iArmy, n, true, false)) {
                                
                            }
                        } else if (CFG.gameAction.moveArmyAction(aI_RegoupArmyData.iProvinceID, regroupArmy_AtWar.getRoute(0), (int)aI_RegoupArmyData.iArmy, n, true, false)) {
                            regroupArmy_AtWar.setFromProvinceID(regroupArmy_AtWar.getRoute(0));
                            regroupArmy_AtWar.removeRoute(0);
                            regroupArmy_AtWar.setNumOfUnits((int)aI_RegoupArmyData.iArmy);
                            CFG.core.getCiv(n).addRegroupArmy(regroupArmy_AtWar);
                        }
                    } else if (!CFG.core.getCiv((int)CFG.core.getProv((int)aI_RegoupArmyData.iProvinceID).getCivId()).getCivRegion((int)CFG.core.getProv((int)aI_RegoupArmyData.iProvinceID).getCivRegionID()).isKeyRegion) {
                        CFG.gameAction.disbandArmy(aI_RegoupArmyData.iProvinceID, (int)aI_RegoupArmyData.iArmy, n);
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            CFG.exceptionStack(indexOutOfBoundsException);
        }
        catch (StackOverflowError stackOverflowError) {
            CFG.exceptionStack(stackOverflowError);
        }
        catch (NullPointerException nullPointerException) {
            CFG.exceptionStack(nullPointerException);
        }
        return false;
    }

    public final List<AI_NeighProvinces> getAllNeighboringProvincesInRange_RegroupAtWar(int n, int n2, int n3, List<AI_NeighProvinces> list, List<Integer> list2) {
        int n4;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(n);
        list2.add(n);
        CFG.core.getProv((int)n).wasInProv = true;
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        int n5 = 0;
        int n6 = -1;
        while ((n5 < n3 || list.size() == 0) && arrayList.size() > 0) {
            int n7;
            int n8;
            arrayList2.clear();
            ++n5;
            for (n4 = arrayList.size() - 1; n4 >= 0; --n4) {
                n8 = 1;
                for (n7 = arrayList2.size() - 1; n7 >= 0; --n7) {
                    if (arrayList2.get(n7) != arrayList.get(n4)) continue;
                    n8 = 0;
                    break;
                }
                if (n8 == 0) continue;
                arrayList2.add((Integer)arrayList.get(n4));
            }
            arrayList.clear();
            for (n4 = arrayList2.size() - 1; n4 >= 0; --n4) {
                for (n8 = 0; n8 < CFG.core.getProv((Integer)arrayList2.get(n4)).getNeighProvincesSize(); ++n8) {
                    if (CFG.core.getProv((int)CFG.core.getProv((int)((Integer)arrayList2.get((int)n4)).intValue()).getNeighProvinces((int)n8)).wasInProv) continue;
                    list2.add(CFG.core.getProv((Integer)arrayList2.get(n4)).getNeighProvinces(n8));
                    CFG.core.getProv((int)CFG.core.getProv((int)((Integer)arrayList2.get((int)n4)).intValue()).getNeighProvinces((int)n8)).wasInProv = true;
                    if (!CFG.core.isAlly(n2, CFG.core.getProv(CFG.core.getProv((Integer)arrayList2.get(n4)).getNeighProvinces(n8)).getCivId()) && CFG.core.getMilitaryAccess(n2, CFG.core.getProv(CFG.core.getProv((Integer)arrayList2.get(n4)).getNeighProvinces(n8)).getCivId()) <= 0) continue;
                    if (CFG.core.getProv(CFG.core.getProv((Integer)arrayList2.get(n4)).getNeighProvinces(n8)).getBordersWithEnemy()) {
                        n7 = 0;
                        for (int i = 0; i < CFG.core.getProv(CFG.core.getProv((Integer)arrayList2.get(n4)).getNeighProvinces(n8)).getNeighProvincesSize(); ++i) {
                            if (!CFG.core.getCivsAtWar(n2, CFG.core.getProv(CFG.core.getProv(CFG.core.getProv((Integer)arrayList2.get(n4)).getNeighProvinces(n8)).getNeighProvinces(i)).getCivId())) continue;
                            n7 = 1;
                            break;
                        }
                        if (n7 != 0) {
                            list.add(new AI_NeighProvinces(CFG.core.getProv((Integer)arrayList2.get(n4)).getNeighProvinces(n8), n5));
                            if (n6 < 0) {
                                n6 = n5;
                            }
                        }
                    } else if (this.moveAtWar_BordersWithEnemyCheck(n2, CFG.core.getProv((Integer)arrayList2.get(n4)).getNeighProvinces(n8))) {
                        list.add(new AI_NeighProvinces(CFG.core.getProv((Integer)arrayList2.get(n4)).getNeighProvinces(n8), n5));
                        if (n6 < 0) {
                            n6 = n5;
                        }
                    }
                    arrayList.add(CFG.core.getProv((Integer)arrayList2.get(n4)).getNeighProvinces(n8));
                }
            }
            if (n6 > 0 && n6 + 2 < n5) continue;
        }
        for (n4 = list2.size() - 1; n4 >= 0; --n4) {
            CFG.core.getProv((int)list2.get((int)n4).intValue()).wasInProv = false;
        }
        arrayList.clear();
        arrayList = null;
        list2.clear();
        list2 = null;
        return list;
    }

    public final List<AI_NeighProvinces> getAllNeighboringProvincesInRange_RegroupPrepareForWAr(int n, int n2, int n3, List<AI_NeighProvinces> list, List<Integer> list2) {
        int n4;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(n);
        list2.add(n);
        CFG.core.getProv((int)n).wasInProv = true;
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        int n5 = 0;
        int n6 = -1;
        while ((n5 < n3 || list.size() == 0) && arrayList.size() > 0) {
            int n7;
            arrayList2.clear();
            ++n5;
            for (n4 = arrayList.size() - 1; n4 >= 0; --n4) {
                n7 = 1;
                for (int i = arrayList2.size() - 1; i >= 0; --i) {
                    if (arrayList2.get(i) != arrayList.get(n4)) continue;
                    n7 = 0;
                    break;
                }
                if (n7 == 0) continue;
                arrayList2.add((Integer)arrayList.get(n4));
            }
            arrayList.clear();
            for (n4 = arrayList2.size() - 1; n4 >= 0; --n4) {
                for (n7 = 0; n7 < CFG.core.getProv((Integer)arrayList2.get(n4)).getNeighProvincesSize(); ++n7) {
                    if (CFG.core.getProv((int)CFG.core.getProv((int)((Integer)arrayList2.get((int)n4)).intValue()).getNeighProvinces((int)n7)).wasInProv) continue;
                    list2.add(CFG.core.getProv((Integer)arrayList2.get(n4)).getNeighProvinces(n7));
                    CFG.core.getProv((int)CFG.core.getProv((int)((Integer)arrayList2.get((int)n4)).intValue()).getNeighProvinces((int)n7)).wasInProv = true;
                    if (!CFG.core.isAlly(n2, CFG.core.getProv(CFG.core.getProv((Integer)arrayList2.get(n4)).getNeighProvinces(n7)).getCivId()) && CFG.core.getMilitaryAccess(n2, CFG.core.getProv(CFG.core.getProv((Integer)arrayList2.get(n4)).getNeighProvinces(n7)).getCivId()) <= 0) continue;
                    if (CFG.oAI.prepareForWar_BordersWithEnemy(n2, CFG.core.getProv((Integer)arrayList2.get(n4)).getNeighProvinces(n7))) {
                        list.add(new AI_NeighProvinces(CFG.core.getProv((Integer)arrayList2.get(n4)).getNeighProvinces(n7), n5));
                        if (n6 < 0) {
                            n6 = n5;
                        }
                    }
                    arrayList.add(CFG.core.getProv((Integer)arrayList2.get(n4)).getNeighProvinces(n7));
                }
            }
            if (n6 > 0 && n6 + 2 < n5) continue;
        }
        for (n4 = list2.size() - 1; n4 >= 0; --n4) {
            CFG.core.getProv((int)list2.get((int)n4).intValue()).wasInProv = false;
        }
        arrayList.clear();
        arrayList = null;
        list2.clear();
        list2 = null;
        return list;
    }

    public final void prepareForWar_Recruit(int n, List<AI_ProvinceInfo_War> list, List<Integer> list2, boolean bl) {
        int n2;
        int n3;
        int n4;
        if (this.isAtWarOnlyWithWeakRebels(n)) {
            return;
        }
        if (CFG.core.getCiv(n).getMovemPoints() < CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_RECRUIT) {
            return;
        }
        if (list2.size() * CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE > CFG.core.getCiv(n).getMovemPoints() && Math.max((float)(CFG.core.getCiv(n).getGold() / (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT) / (float)CFG.core.getCiv(n).getNumberOfUnits(), 0.001f) < 0.048f && CFG.oR.nextInt(100) < 85) {
            return;
        }
        if (!bl && CFG.core.getCiv(n).getCapitalProvID() >= 0 && CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).getCivId() == n && CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).getNeighSeaProvincesSize() > 0) {
            n4 = 0;
            for (n3 = list.size() - 1; n3 >= 0; --n3) {
                if (list.get((int)n3).iProvinceID != CFG.core.getCiv(n).getCapitalProvID()) continue;
                n4 = 1;
                break;
            }
            if (n4 == 0) {
                list.add(new AI_ProvinceInfo_War(CFG.core.getCiv(n).getCapitalProvID(), this.getPotential_BasedOnNeighboringProvs(CFG.core.getCiv(n).getCapitalProvID(), n), true));
            }
        }
        n4 = (int)(CFG.core.getCiv(n).getGold() / (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT);
        n3 = list.size();
        ArrayList<AI_ProvinceInfo_War> arrayList = new ArrayList<AI_ProvinceInfo_War>();
        float f = 0.0f;
        for (n2 = 0; n2 < n3 && n2 < list.size(); ++n2) {
            arrayList.add(list.get(n2));
            f += list.get((int)n2).iValue;
        }
        long currentGold_War = CFG.core.getCiv(n).getGold();
        boolean bl2 = false;
        for (int i = 0; i < arrayList.size(); ++i) {
            int n6;
            int n7 = ((AI_ProvinceInfo_War)arrayList.get(i)).getRecruitableArmy(n);
            boolean bl3 = false;
            if (CFG.core.getProv(((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID).isOccupied() || CFG.core.getProv(((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID).getCivId() != n || bl3) {
                int n8;
                List<AI_NeighProvinces> list3 = CFG.oAI.getAllNeighboringProvincesInRange_RecruitAtWAr(((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID, n, Math.max(10, CFG.core.getCiv(n).getNumOfProvs() / 8), true, false, new ArrayList<AI_NeighProvinces>(), new ArrayList<Integer>());
                list3 = this.filterAIWarRecruitProvinces(n, list3);
                if (list3.size() <= 0) continue;
                int n9 = 0;
                if (bl3 || CFG.oR.nextInt(100) < 90) {
                    int n10 = 0;
                    int n11 = CFG.gameAction.gMARY(list3.get((int)n10).iProvinceID);
                    for (int j = 1; j < list3.size(); ++j) {
                        if (n11 >= CFG.gameAction.gMARY(list3.get((int)j).iProvinceID)) continue;
                        n10 = j;
                        n11 = CFG.gameAction.gMARY(list3.get((int)j).iProvinceID);
                    }
                    n9 = n10;
                } else {
                    n9 = CFG.oR.nextInt(list3.size());
                }
                n8 = Math.min(CFG.gameAction.gMARY(list3.get((int)n9).iProvinceID, n), ((AI_ProvinceInfo_War)arrayList.get(i)).getRecruitableArmy(n));
                if (CFG.core.getCiv(n).recruitArmy_AI(list3.get((int)n9).iProvinceID, n8)) {
                    bl2 = true;
                }
                if ((n6 = (int)CFG.core.getCiv(n).getRecruitArmy_BasedOnProvinceID(list3.get((int)n9).iProvinceID)) <= 0) continue;
                CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.add(new CivArmyMission_RegroupAfterRecruitment(n, list3.get((int)n9).iProvinceID, ((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID, n6));
                continue;
            }
            int recruitProvinceID = ((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID;
            if (!this.isValidAIWarRecruitProvince(n, recruitProvinceID)) {
                AI_NeighProvinces fallbackRecruitProvince = this.getBestAIWarRecruitProvince(n, recruitProvinceID, 5);
                if (fallbackRecruitProvince == null) continue;
                recruitProvinceID = fallbackRecruitProvince.iProvinceID;
            }
            n6 = (int)((float)Math.min(n4, Math.min((long)n4, currentGold_War / (long)(CFG.core.getProv(recruitProvinceID).getLvlOfArmoury() > 0 ? GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT - 1 : GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT))) * ((AI_ProvinceInfo_War)arrayList.get((int)i)).iValue / f);
            if (!CFG.core.getCiv(n).recruitArmy_AI(recruitProvinceID, n6)) continue;
            if (recruitProvinceID != ((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID) {
                int recruitedArmy = (int)CFG.core.getCiv(n).getRecruitArmy_BasedOnProvinceID(recruitProvinceID);
                if (recruitedArmy > 0) {
                    CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.add(new CivArmyMission_RegroupAfterRecruitment(n, recruitProvinceID, ((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID, recruitedArmy));
                }
            }
            bl2 = true;
        }
        if (bl2 && CFG.core.getCiv(n).getGold() < (long)(GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT * 5)) {
            CFG.core.getCiv((int)n).civGD.moveAtWar_ArmyFullyRecruitedLastTurn = true;
        }
    }

    public final void moveAtWar_Recruit(int n, List<AI_ProvinceInfo_War> list, List<Integer> list2, boolean bl) {
        int n2;
        int n3;
        int n4;
        if (this.isAtWarOnlyWithWeakRebels(n)) {
            return;
        }
        Civilization civilization = CFG.core.getCiv(n);
        if (civilization.getMovemPoints() < CFG.ideologiesMgr.getIdeologyID((int)civilization.getIdeology()).COST_OF_RECRUIT) {
            return;
        }
        if (list2.size() * CFG.ideologiesMgr.getIdeologyID((int)civilization.getIdeology()).COST_OF_MOVE > civilization.getMovemPoints() && Math.max((float)(civilization.getGold() / (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT) / (float)civilization.getNumberOfUnits(), 0.001f) < 0.048f && CFG.oR.nextInt(100) < 85) {
            return;
        }
        if (!bl && civilization.getCapitalProvID() >= 0 && CFG.core.getProv(civilization.getCapitalProvID()).getCivId() == n && CFG.core.getProv(civilization.getCapitalProvID()).getNeighSeaProvincesSize() > 0) {
            n4 = 0;
            for (n3 = list.size() - 1; n3 >= 0; --n3) {
                if (list.get((int)n3).iProvinceID != civilization.getCapitalProvID()) continue;
                n4 = 1;
                break;
            }
            if (n4 == 0) {
                list.add(new AI_ProvinceInfo_War(civilization.getCapitalProvID(), this.getPotential_BasedOnNeighboringProvs(civilization.getCapitalProvID(), n), true));
            }
        }
        n4 = (int)(civilization.getGold() / (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT);
        n3 = list.size();
        ArrayList<AI_ProvinceInfo_War> arrayList = new ArrayList<AI_ProvinceInfo_War>();
        float f = 0.0f;
        for (n2 = 0; n2 < n3 && n2 < list.size(); ++n2) {
            arrayList.add(list.get(n2));
            f += list.get((int)n2).iValue;
        }
        long currentGold_War = civilization.getGold();
        boolean bl2 = false;
        for (int i = 0; i < arrayList.size(); ++i) {
            int n6 = ((AI_ProvinceInfo_War)arrayList.get(i)).getRecruitableArmy(n);
            boolean bl3 = false;
            if (CFG.core.getProv(((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID).isOccupied() || CFG.core.getProv(((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID).getCivId() != n || bl3) {
                int n7;
                int n8;
                int n9;
                int n10;
                List<AI_NeighProvinces> list3 = CFG.oAI.getAllNeighboringProvincesInRange_RecruitAtWAr(((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID, n, Math.max(10, civilization.getNumOfProvs() / 8), true, false, new ArrayList<AI_NeighProvinces>(), new ArrayList<Integer>());
                list3 = this.filterAIWarRecruitProvinces(n, list3);
                if (!list3.isEmpty()) {
                    n10 = 0;
                    if (bl3 || CFG.oR.nextInt(100) < 90) {
                        n9 = 0;
                        int n11 = CFG.gameAction.gMARY(list3.get((int)n9).iProvinceID);
                        for (int j = 1; j < list3.size(); ++j) {
                            if (n11 >= CFG.gameAction.gMARY(list3.get((int)j).iProvinceID)) continue;
                            n9 = j;
                            n11 = CFG.gameAction.gMARY(list3.get((int)j).iProvinceID);
                        }
                        n10 = n9;
                    } else {
                        n10 = CFG.oR.nextInt(list3.size());
                    }
                    n8 = Math.min(CFG.gameAction.gMARY(list3.get((int)n10).iProvinceID, n), ((AI_ProvinceInfo_War)arrayList.get(i)).getRecruitableArmy(n));
                    if (civilization.recruitArmy_AI(list3.get((int)n10).iProvinceID, n8)) {
                        bl2 = true;
                    }
                    if ((n7 = (int)civilization.getRecruitArmy_BasedOnProvinceID(list3.get((int)n10).iProvinceID)) <= 0) continue;
                    civilization.civGD.civPlans.armiesMissions.add(new CivArmyMission_RegroupAfterRecruitment_War(n, list3.get((int)n10).iProvinceID, ((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID, n7));
                    continue;
                }
                if (bl) continue;
                n7 = 1;
                for (n8 = civilization.civGD.civPlans.armiesMissions.size() - 1; n8 >= 0; --n8) {
                    if (civilization.civGD.civPlans.armiesMissions.get((int)n8).MISSION_TYPE != CivArmyMission_Type.NAVAL_INVASION || civilization.civGD.civPlans.armiesMissions.get((int)n8).toProvinceID != ((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID) continue;
                    n7 = 0;
                    break;
                }
                if (n7 == 0) continue;
                n8 = ((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID;
                if (CFG.core.getProv(((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID).getNeighSeaProvincesSize() == 0) {
                    n10 = 0;
                    for (n9 = 0; n9 < CFG.core.getProv(((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID).getNeighSeaProvincesSize(); ++n9) {
                        if (CFG.core.getProv(CFG.core.getProv(((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID).getNeighProvinces(n9)).getLvlOfPort() < 0 || CFG.core.getProv(CFG.core.getProv(((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID).getNeighProvinces(n9)).getCivId() != n && !CFG.core.getCivsAtWar(n, CFG.core.getProv(CFG.core.getProv(((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID).getNeighProvinces(n9)).getCivId())) continue;
                        if (n10 != 0) {
                            if (CFG.oR.nextInt(100) >= 50) continue;
                            n8 = CFG.core.getProv(((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID).getNeighProvinces(n9);
                            continue;
                        }
                        n8 = CFG.core.getProv(((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID).getNeighProvinces(n9);
                        n10 = 1;
                    }
                }
                if (GameValues.gvAiWar.USE_NEW_NAVAL_INVASION) {
                    this.moveAtWar_AtSea_ToProvinceID_New(n, n8);
                    continue;
                }
                this.moveAtWar_AtSea_ToProvinceID(n, n8);
                continue;
            }
            int recruitProvinceID = ((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID;
            if (!this.isValidAIWarRecruitProvince(n, recruitProvinceID)) {
                AI_NeighProvinces fallbackRecruitProvince = this.getBestAIWarRecruitProvince(n, recruitProvinceID, 5);
                if (fallbackRecruitProvince == null) continue;
                recruitProvinceID = fallbackRecruitProvince.iProvinceID;
            }
            int n12 = (int)((float)Math.min(n4, Math.min((long)n4, currentGold_War / (long)(CFG.core.getProv(recruitProvinceID).getLvlOfArmoury() > 0 ? GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT - 1 : GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT))) * ((AI_ProvinceInfo_War)arrayList.get((int)i)).iValue / f);
            if (!civilization.recruitArmy_AI(recruitProvinceID, n12)) continue;
            if (recruitProvinceID != ((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID) {
                int recruitedArmy = (int)civilization.getRecruitArmy_BasedOnProvinceID(recruitProvinceID);
                if (recruitedArmy > 0) {
                    civilization.civGD.civPlans.armiesMissions.add(new CivArmyMission_RegroupAfterRecruitment_War(n, recruitProvinceID, ((AI_ProvinceInfo_War)arrayList.get((int)i)).iProvinceID, recruitedArmy));
                }
            }
            bl2 = true;
        }
        if (bl2 && civilization.getGold() < (long)(GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT * 5)) {
            civilization.civGD.moveAtWar_ArmyFullyRecruitedLastTurn = true;
        }
        this.billionaireRecruitment(n);
    }

    public void buildStartingBuildings(int n) {
        try {
            if (CFG.core.getCiv(n).getCapitalProvID() >= 0) {
                if (CFG.core.getCiv(n).getTechLevel() >= BuildingsManager.getTower_TechLevel(1) * GameValues.gvProvince.STARTING_BUILDING_WATCHTOWER_TECH_REQUIRED) {
                    CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).setLvlOfWatchTower(1);
                }
                if (CFG.core.getCiv(n).getTechLevel() >= BuildingsManager.getFort_TechLevel(1) * GameValues.gvProvince.STARTING_BUILDING_FORT_TECH_REQUIRED) {
                    CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).setLvlOfFort(1);
                }
                if (CFG.core.getCiv(n).getTechLevel() >= BuildingsManager.getPort_TechLevel(1) * GameValues.gvProvince.STARTING_BUILDING_PORT_TECH_REQUIRED) {
                    this.buildStartingBuildings_Port(n);
                }
                if (CFG.core.getCiv(n).getTechLevel() >= BuildingsManager.getFarm_TechLevel(1) && CFG.oR.nextInt(1000) < GameValues.gvProvince.STARTING_BUILDING_FARM_RANDOM_1000) {
                    CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).setLvlOfFarm(1);
                }
                if (CFG.core.getCiv(n).getTechLevel() >= BuildingsManager.getMarket_TechLevel(1) && CFG.oR.nextInt(1000) < GameValues.gvProvince.STARTING_BUILDING_MARKET_RANDOM_1000) {
                    CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).setLvlOfMarket(1);
                }
                if (CFG.core.getCiv(n).getTechLevel() >= BuildingsManager.getWorkshop_TechLevel(1) && CFG.oR.nextInt(1000) < GameValues.gvProvince.STARTING_BUILDING_WORKSHOP_RANDOM_1000) {
                    CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).setLvlOfWorkshop(1);
                }
                if (CFG.core.getCiv(n).getTechLevel() >= BuildingsManager.getLibrary_TechLevel(1) && CFG.oR.nextInt(1000) < GameValues.gvProvince.STARTING_BUILDING_LIBRARY_RANDOM_1000) {
                    CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).setLvlOfLibrary(1);
                }
            }
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
    }

    public final void buildStartingBuildings_Port(int n) {
        int n2 = -1;
        if (CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).getLvlOfPort() >= 0) {
            n2 = CFG.core.getCiv(n).getCapitalProvID();
        } else {
            for (int i = 0; i < CFG.core.getCiv(n).getNumOfProvs(); ++i) {
                if (CFG.core.getProv(CFG.core.getCiv(n).getProvID(i)).getLvlOfPort() != 0) continue;
                if (n2 < 0) {
                    n2 = CFG.core.getCiv(n).getProvID(i);
                    continue;
                }
                if (CFG.core.getProv(n2).getPop().getPops() >= CFG.core.getProv(CFG.core.getCiv(n).getProvID(i)).getPop().getPops()) continue;
                n2 = CFG.core.getCiv(n).getProvID(i);
            }
        }
        if (n2 >= 0 && CFG.core.getProv(n2).getLvlOfPort() >= 0) {
            CFG.core.getProv(n2).setLvlOfPort(1);
        }
    }

    public static final long getMoney_MinReserve_LockTreasury(int n) {
        if (CFG.core.getCiv((int)n).civGD.changeTypeOfGovernment != null) {
            return Math.max(CFG.core.getCiv((int)n).civGD.changeTypeOfGovernment.iCost, CFG.core.getCiv((int)n).civGD.iLockTreasury);
        }
        return CFG.core.getCiv((int)n).civGD.iLockTreasury;
    }

    public static final long getMoney_MinReserve(int n) {
        return (long)Math.max((float)AIPlaystyle.getMoney_MinReserve_LockTreasury(n), (float)CFG.core.getCiv((int)n).iBudget * CFG.core.getCiv((int)n).civGD.civPers.TREASURY_RESERVE);
    }

    public void manageBudget(int n) {
        CFG.core.getCiv(n).setSpendingGoodsB(Math.max(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(n).getIdeology()).getMin_Goods(n) + 0.01f, CFG.core.getCiv(n).getSpendingGoodsB()));
        CFG.core.getCiv(n).setSpendingInvestmentsB(Math.max(CFG.ideologiesMgr.getInvestments(CFG.core.getCiv(n).getIdeology(), n) + 0.01f, CFG.core.getCiv(n).getSpendingInvestmentsB()));
        if (CFG.core.getCiv(n).isAtWarC() || CFG.core.getCiv((int)n).civGD.civPlans.isPreparingForTheWar()) {
            float f;
            if (!CFG.core.getCiv((int)n).isAtWarWithCivs.isEmpty()) {
                long n2 = 0L;
                for (int i = CFG.core.getCiv((int)n).isAtWarWithCivs.size() - 1; i >= 0; --i) {
                    n2 += (long)Math.max(1.0f, (float)CFG.core.getCiv((int)CFG.core.getCiv((int)n).isAtWarWithCivs.get((int)i).intValue()).iBudget * CFG.core.getCiv((int)n).civGD.civPers.MIN_MILITARY_SPENDINGS_WAR_MODIFIER);
                }
                CFG.core.getCiv((int)n).civGD.civPers.MIN_MILITARY_SPENDINGS_WAR = Math.max(Math.min(2.0f, (float)n2 / (float)CFG.core.getCiv((int)n).iBudget), CFG.core.getCiv((int)n).civGD.civPers.MIN_MILITARY_SPENDINGS);
            } else {
                CFG.core.getCiv((int)n).civGD.civPers.MIN_MILITARY_SPENDINGS_WAR = CFG.core.getCiv((int)n).civGD.civPers.MIN_MILITARY_SPENDINGS;
            }
            float f2 = GameValues.gvAiBudget.WAR_BASE_HAPPINESS;
            if (CFG.core.getCiv(n).getHappiness() - CFG.core.getCiv((int)n).civGD.civPers.MIN_HAPPINESS_FOR_CIV < 0) {
                if (CFG.core.getCiv(n).getHappiness() < GameValues.gvAiBudget.WAR_HAPPINESS_THRESHOLD_VERY_LOW) {
                    f2 = (float)CFG.core.getCiv((int)n).civGD.civPers.MIN_HAPPINESS_FOR_CIV / 100.0f / GameValues.gvAiBudget.WAR_HAPPINESS_DIVISOR_VERY_LOW;
                    f = 0.0f;
                } else if (CFG.core.getCiv(n).getHappiness() < GameValues.gvAiBudget.WAR_HAPPINESS_THRESHOLD_LOW) {
                    f2 = (float)CFG.core.getCiv((int)n).civGD.civPers.MIN_HAPPINESS_FOR_CIV / 100.0f / GameValues.gvAiBudget.WAR_HAPPINESS_DIVISOR_LOW;
                    f = 0.0f;
                } else if (CFG.core.getCiv(n).getHappiness() < GameValues.gvAiBudget.WAR_HAPPINESS_THRESHOLD_MEDIUM) {
                    f2 = (float)CFG.core.getCiv((int)n).civGD.civPers.MIN_HAPPINESS_FOR_CIV / 100.0f / GameValues.gvAiBudget.WAR_HAPPINESS_DIVISOR_MEDIUM;
                    f = 0.0f;
                } else {
                    f = (1.0f - f2) * ((float)CFG.core.getCiv(n).getHappiness() / (float)CFG.core.getCiv((int)n).civGD.civPers.MIN_HAPPINESS_FOR_CIV);
                }
            } else {
                f = 1.0f - f2;
                if (CFG.core.getCiv(n).getHappiness() > GameValues.gvAiBudget.WAR_HAPPINESS_THRESHOLD_HIGH && (float)CFG.core.getCiv(n).getHappiness() > CFG.core.getCiv((int)n).civGD.civPers.MIN_PROVINCE_HAPPINESS_RUN_FESTIVAL * GameValues.gvAiBudget.WAR_MIN_PROVINCE_HAPPINESS_RUN_FESTIVAL_MODIFIER) {
                    f = 1.0f - f2 + (float)CFG.oR.nextInt(GameValues.gvAiBudget.WAR_HAPPINESS_HIGH_RANDOM_1000) / 1000.0f;
                }
            }
            CFG.core.getCiv(n).setTaxationLvl((CFG.ideologiesMgr.getAcceptableTaxation(CFG.core.getCiv(n).getIdeology(), n) * f2 + CFG.ideologiesMgr.getAcceptableTaxation(CFG.core.getCiv(n).getIdeology(), n) * f) * CFG.core.getCiv((int)n).civGD.civPers.TAXATION_LEVEL);
            this.updateMilitarySpending(n);
            CFG.core.getCiv(n).setSpendingGoodsB(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(n).getIdeology()).getMin_Goods(n));
            CFG.core.getCiv(n).setSpendingInvestmentsB(CFG.ideologiesMgr.getInvestments(CFG.core.getCiv(n).getIdeology(), n));
            CFG.core.getCiv(n).setSpendingResearchB(0.0f);
        } else {
            float f;
            float f9 = GameValues.gvAiBudget.GOLD_RESERVE_BASE;
            if (CFG.core.getCiv(n).getGold() < AIPlaystyle.getMoney_MinReserve_LockTreasury(n)) {
                f9 = GameValues.gvAiBudget.GOLD_RESERVE_LOCKED;
                if (CFG.core.getCiv(n).getGold() > 0L) {
                    f9 += GameValues.gvAiBudget.GOLD_RESERVE_LOCKED_BONUS * ((float)CFG.core.getCiv(n).getGold() / (float)AIPlaystyle.getMoney_MinReserve_LockTreasury(n));
                }
            } else {
                if (CFG.core.getCiv(n).getGold() < AIPlaystyle.getMoney_MinReserve(n)) {
                    if (CFG.gameUpdate.getInflationPerc(n) * 100.0f > 0.0f) {
                        f9 = 1.0f + CFG.gameUpdate.getInflationPerc(n) * 100.0f;
                        CFG.core.getCiv((int)n).civGD.civPers.TREASURY_RESERVE = Math.max(GameValues.gvAiBudget.GOLD_RESERVE_TREASURY_MAX, CFG.core.getCiv((int)n).civGD.civPers.TREASURY_RESERVE - GameValues.gvAiBudget.GOLD_RESERVE_TREASURY_DECREASE);
                    } else {
                        f9 = CFG.core.getCiv((int)n).civGD.civPers.TREASURY_RESERVE_MODIFIER + (1.0f - CFG.core.getCiv((int)n).civGD.civPers.TREASURY_RESERVE_MODIFIER) * (float)CFG.core.getCiv(n).getGold() / ((float)CFG.core.getCiv((int)n).iBudget * CFG.core.getCiv((int)n).civGD.civPers.TREASURY_RESERVE);
                    }
                } else if (CFG.gameUpdate.getInflationPerc(n) * 100.0f > 0.0f) {
                    f9 = 1.0f + CFG.gameUpdate.getInflationPerc(n) * 100.0f;
                }
                if (!CFG.core.getCiv((int)n).provincesWithLowStability.isEmpty()) {
                    long n3 = GameManager.assimilateCost(CFG.core.getCiv((int)n).provincesWithLowStability.get(0), GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MAX / 2) * (long)CFG.core.getCiv((int)n).provincesWithLowStability.size();
                    f9 = Math.min(f9, GameValues.gvAiBudget.GOLD_RESERVE_ASSIMILATION_MIN + GameValues.gvAiBudget.GOLD_RESERVE_ASSIMILATION_SCALE * (float)CFG.core.getCiv(n).getGold() / (float)n3);
                }
            }
            float f10 = GameValues.gvAiBudget.BASE_HAPPINESS;
            if (CFG.core.getCiv(n).getHappiness() - CFG.core.getCiv((int)n).civGD.civPers.MIN_HAPPINESS_FOR_CIV < 0) {
                if (CFG.core.getCiv(n).getHappiness() < GameValues.gvAiBudget.HAPPINESS_THRESHOLD_VERY_LOW) {
                    f10 = (float)CFG.core.getCiv((int)n).civGD.civPers.MIN_HAPPINESS_FOR_CIV / 100.0f / GameValues.gvAiBudget.HAPPINESS_DIVISOR_VERY_LOW;
                    f = 0.0f;
                } else if (CFG.core.getCiv(n).getHappiness() < GameValues.gvAiBudget.HAPPINESS_THRESHOLD_LOW) {
                    f10 = (float)CFG.core.getCiv((int)n).civGD.civPers.MIN_HAPPINESS_FOR_CIV / 100.0f / GameValues.gvAiBudget.HAPPINESS_DIVISOR_LOW;
                    f = 0.0f;
                } else if (CFG.core.getCiv(n).getHappiness() < GameValues.gvAiBudget.HAPPINESS_THRESHOLD_MEDIUM) {
                    f10 = (float)CFG.core.getCiv((int)n).civGD.civPers.MIN_HAPPINESS_FOR_CIV / 100.0f / GameValues.gvAiBudget.HAPPINESS_DIVISOR_MEDIUM;
                    f = 0.0f;
                } else {
                    f = (1.0f - f10) * ((float)CFG.core.getCiv(n).getHappiness() / (float)CFG.core.getCiv((int)n).civGD.civPers.MIN_HAPPINESS_FOR_CIV);
                }
            } else {
                f = 1.0f - f10;
                if (CFG.core.getCiv(n).getHappiness() > GameValues.gvAiBudget.HAPPINESS_THRESHOLD_HIGH && (float)CFG.core.getCiv(n).getHappiness() > CFG.core.getCiv((int)n).civGD.civPers.MIN_PROVINCE_HAPPINESS_RUN_FESTIVAL * GameValues.gvAiBudget.MIN_PROVINCE_HAPPINESS_RUN_FESTIVAL_MODIFIER) {
                    f = 1.0f - f10 + (float)CFG.oR.nextInt(GameValues.gvAiBudget.HAPPINESS_HIGH_RANDOM_1000) / 1000.0f;
                }
            }
            CFG.core.getCiv(n).setTaxationLvl((CFG.ideologiesMgr.getAcceptableTaxation(CFG.core.getCiv(n).getIdeology(), n) * f10 + CFG.ideologiesMgr.getAcceptableTaxation(CFG.core.getCiv(n).getIdeology(), n) * f) * CFG.core.getCiv((int)n).civGD.civPers.TAXATION_LEVEL);
            this.updateMilitarySpending(n);
            float f11 = GameValues.gvAiBudget.TOTAL_BUDGET_BASE - CFG.core.getCiv((int)n).iMilitaryUpkeep_PERC - CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(n).getIdeology()).getMin_Goods(n) - CFG.ideologiesMgr.getInvestments(CFG.core.getCiv(n).getIdeology(), n);
            if (f11 > 0.0f) {
                if (CFG.core.getCiv(n).getGold() < 0L) {
                    float f12 = CFG.core.getCiv((int)n).civGD.civPers.GOODS_EXTRA_PERC_OF_BUDGET + CFG.core.getCiv((int)n).civGD.civPers.INVESTMENTS_EXTRA_PERC_OF_BUDGET + CFG.core.getCiv((int)n).civGD.civPers.RESEARCH_PERC_OF_BUDGET;
                    CFG.core.getCiv(n).setSpendingGoodsB(Math.max(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(n).getIdeology()).getMin_Goods(n) + CFG.core.getCiv((int)n).civGD.civPers.GOODS_EXTRA_PERC_OF_BUDGET / f12 * ((f11 *= GameValues.gvAiBudget.NO_MONEY_SPENDING_MIN + (float)CFG.oR.nextInt(GameValues.gvAiBudget.NO_MONEY_SPENDING_RAND_100) / 100.0f) * CFG.core.getCiv((int)n).civGD.civPers.USE_OF_BUDGET_FOR_SPENDINGS), CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(n).getIdeology()).getMin_Goods(n)));
                    CFG.core.getCiv(n).setSpendingInvestmentsB(Math.max(CFG.ideologiesMgr.getInvestments(CFG.core.getCiv(n).getIdeology(), n) + CFG.core.getCiv((int)n).civGD.civPers.INVESTMENTS_EXTRA_PERC_OF_BUDGET / f12 * (f11 * CFG.core.getCiv((int)n).civGD.civPers.USE_OF_BUDGET_FOR_SPENDINGS), CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).MIN_INVESTMENTS));
                    CFG.core.getCiv(n).setSpendingResearchB(0.0f);
                } else {
                    float f13 = 1.0f;
                    if (CFG.core.getCiv((int)n).fAverageDevelopment / CFG.core.getCiv(n).getTechLevel() < CFG.core.getCiv((int)n).civGD.civPers.MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY) {
                        f13 = 1.0f + (CFG.core.getCiv((int)n).civGD.civPers.MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY - CFG.core.getCiv((int)n).fAverageDevelopment / CFG.core.getCiv(n).getTechLevel()) / CFG.core.getCiv(n).getTechLevel();
                    }
                    float f14 = CFG.core.getCiv((int)n).civGD.civPers.GOODS_EXTRA_PERC_OF_BUDGET + CFG.core.getCiv((int)n).civGD.civPers.INVESTMENTS_EXTRA_PERC_OF_BUDGET * f13 + CFG.core.getCiv((int)n).civGD.civPers.RESEARCH_PERC_OF_BUDGET;
                    CFG.core.getCiv(n).setSpendingGoodsB(Math.max(CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(n).getIdeology()).getMin_Goods(n) + CFG.core.getCiv((int)n).civGD.civPers.GOODS_EXTRA_PERC_OF_BUDGET / f14 * (f11 * CFG.core.getCiv((int)n).civGD.civPers.USE_OF_BUDGET_FOR_SPENDINGS) * f9, CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(n).getIdeology()).getMin_Goods(n)));
                    CFG.core.getCiv(n).setSpendingInvestmentsB(Math.max(CFG.ideologiesMgr.getInvestments(CFG.core.getCiv(n).getIdeology(), n) + CFG.core.getCiv((int)n).civGD.civPers.INVESTMENTS_EXTRA_PERC_OF_BUDGET * f13 / f14 * (f11 * CFG.core.getCiv((int)n).civGD.civPers.USE_OF_BUDGET_FOR_SPENDINGS) * f9, CFG.ideologiesMgr.getInvestments(CFG.core.getCiv(n).getIdeology(), n)));
                    CFG.core.getCiv(n).setSpendingResearchB(CFG.core.getCiv((int)n).civGD.civPers.RESEARCH_PERC_OF_BUDGET / f14 * (f11 * CFG.core.getCiv((int)n).civGD.civPers.USE_OF_BUDGET_FOR_SPENDINGS) * f9);
                }
            } else {
                CFG.core.getCiv(n).setSpendingResearchB(0.0f);
            }
            if (CFG.core.getCiv(n).getGold() > (long)GameValues.gvAiBudget.MAX_RESEARCH_IF_GOLD_OVER && CFG.core.getCiv(n).getTechLevel() < GameValues.gvTechnology.MAX_TECHNOLOGY_LEVEL) {
                CFG.core.getCiv(n).setSpendingResearchB(1.0f);
            }
        }
    }

    public final void manageVassalsTribute(int n) {
        try {
            for (int i = 0; i < CFG.core.getCiv((int)n).civGD.vassals.size(); ++i) {
                CFG.core.getCiv((int)n).civGD.vassals.get(i).setTribute(Math.min((int)((float)GameValues.gvVassal.PERCENTAGE_OF_INCOME_FOR_LORD_MAX * GameValues.gvAiVassals.PERCENTAGE_OF_INCOME_FOR_LORD_MAX_PERC_MAX), (int)((float)GameValues.gvVassal.PERCENTAGE_OF_INCOME_FOR_LORD_MAX * (CFG.core.getCiv((int)n).VASSALS_TRIBUTE_PERC - (CFG.core.getCivRelationOfCivB(n, CFG.core.getCiv((int)n).civGD.vassals.get((int)i).iCivID) > 0.0f ? CFG.core.getCiv((int)n).VASSALS_TRIBUTE_PERC * CFG.core.getCiv((int)n).VASSALS_TRIBUTE_PERC_FRIENDLY * CFG.core.getCivRelationOfCivB(n, CFG.core.getCiv((int)n).civGD.vassals.get((int)i).iCivID) / 100.0f : 0.0f) + (float)CFG.oR.nextInt((int)(CFG.core.getCiv((int)n).VASSALS_TRIBUTE_PERC_RAND * 100.0f)) / 100.0f))));
                if (!(CFG.core.getCiv(CFG.core.getCiv((int)n).civGD.vassals.get((int)i).iCivID).getRelationD(n) < 0.0f)) continue;
                CFG.core.getCiv(n).getCivDiploGD().addImproveRelations(n, CFG.core.getCiv((int)n).civGD.vassals.get((int)i).iCivID, Math.min(GameValues.gvAiVassals.UPDATE_VASSALS_TRIBUTE, 5 + Math.abs((int)(CFG.core.getCiv(CFG.core.getCiv((int)n).civGD.vassals.get((int)i).iCivID).getRelationD(n) - 1.0f))));
            }
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
    }

    public final void happinessCrisis(int n) {
        try {
            if (!CFG.core.getCiv((int)n).provincesWithLowHappiness.isEmpty() && CFG.core.getCiv(n).getMovemPoints() >= GameValues.gvFestival.COST_FESTIVAL_MOVEMENT_POINTS && (float)CFG.core.getCiv(n).getGold() >= 0.5f * (float)Festival.festivalCost(CFG.core.getCiv((int)n).provincesWithLowHappiness.get(0))) {
                ArrayList<AI_Assimilate_Data> arrayList = new ArrayList<AI_Assimilate_Data>();
                for (int i = CFG.core.getCiv((int)n).provincesWithLowHappiness.size() - 1; i >= 0; --i) {
                    if (CFG.core.getProv(CFG.core.getCiv((int)n).provincesWithLowHappiness.get(i)).getHappi() < GameValues.gvRebels.RISE_REVOLT_RISK_IN_PROVINCE_IF_HAPPINESS_BELOW) {
                        arrayList.add(new AI_Assimilate_Data(CFG.core.getCiv((int)n).provincesWithLowHappiness.get(i), (float)CFG.core.getProv(CFG.core.getCiv((int)n).provincesWithLowHappiness.get(i)).getPop().getPops() * (1.0f - CFG.core.getProv(CFG.core.getCiv((int)n).provincesWithLowHappiness.get(i)).getHappi() / 4.0f)));
                        continue;
                    }
                    arrayList.add(new AI_Assimilate_Data(CFG.core.getCiv((int)n).provincesWithLowHappiness.get(i), (float)CFG.core.getProv(CFG.core.getCiv((int)n).provincesWithLowHappiness.get(i)).getPop().getPops() * (1.0f - CFG.core.getProv(CFG.core.getCiv((int)n).provincesWithLowHappiness.get(i)).getHappi())));
                }
                ArrayList<AI_Assimilate_Data> arrayList2 = new ArrayList<AI_Assimilate_Data>();
                while (!arrayList.isEmpty()) {
                    int n2 = 0;
                    for (int i = n2 + 1; i < arrayList.size(); ++i) {
                        if (!(((AI_Assimilate_Data)arrayList.get((int)i)).fScore > ((AI_Assimilate_Data)arrayList.get((int)n2)).fScore)) continue;
                        n2 = i;
                    }
                    arrayList2.add((AI_Assimilate_Data)arrayList.get(n2));
                    arrayList.remove(n2);
                }
                while (CFG.core.getCiv(n).getMovemPoints() >= GameValues.gvFestival.COST_FESTIVAL_MOVEMENT_POINTS && !arrayList2.isEmpty() && Festival.addFestival(n, ((AI_Assimilate_Data)arrayList2.get((int)0)).iProvinceID)) {
                    arrayList2.remove(0);
                }
                arrayList2.clear();
            }
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
    }

    public void updateMilitarySpending(int n) {
        long totalUpkeep = CFG.gameUpdate.getMilitaryUpkeep_Total(n);
        Civilization civ = CFG.core.getCiv(n);
        boolean isAtWar = civ.isAtWarC() || civ.civGD.civPlans.isPreparingForTheWar();
        if (isAtWar) {
            totalUpkeep = Math.max(1L, totalUpkeep / 4L);
        }
        civ.iMilitaryUpkeep_Total = totalUpkeep;
        civ.iMilitaryUpkeep_PERC = civ.iBudget <= 0L && civ.getNumberOfUnits() > 0L ? 100.0f : Math.max(0.0f, (float)totalUpkeep / (float)civ.iBudget);
        if (!isAtWar && civ.getNumberOfUnits() > 0L) {
            long baseUpkeep = (long)((float)civ.getNumberOfUnits() * CFG.gameAges.getAge_MilitaryUpkeep(GameCalendar.CURRENT_AGEID) * GameCalendar.GAME_SPEED);
            float peaceBudget = civ.iBudget > 0L ? (float)baseUpkeep / (float)civ.iBudget : 0.0f;
            float minSpending = civ.civGD.civPers.MIN_MILITARY_SPENDINGS;
            if (peaceBudget > minSpending + 0.1f) {
                civ.iMilitaryUpkeep_PERC = Math.max(civ.iMilitaryUpkeep_PERC, peaceBudget);
            }
        }
    }

    public long build_GetMoney(int n) {
        if (CFG.core.getCiv(n).getGold() < AIPlaystyle.getMoney_MinReserve(n)) {
            return 0L;
        }
        return CFG.core.getCiv(n).getGold() - AIPlaystyle.getMoney_MinReserve(n);
    }

    public void buildBuildings(int n) {
        if (this.build_GetMoney(n) > 0L) {
            ArrayList<AI_Build> arrayList = new ArrayList<AI_Build>();
            ArrayList<AI_Build_Option> arrayList2 = new ArrayList<AI_Build_Option>();
            Civilization civilization = CFG.core.getCiv(n);
            try {
                if (civilization.getTechLevel() >= BuildingsManager.getFarm_TechLevel(1) && civilization.numOf_Farms_ProvincesPossibleToBuild * BuildingsManager.getWorkshop_MaxLevel_CanBuild(n) > civilization.numOf_Farms) {
                    arrayList2.add(new AI_Build_Option());
                }
                if (civilization.getTechLevel() >= BuildingsManager.getWorkshop_TechLevel(1) && civilization.getNumOfProvs() * BuildingsManager.getWorkshop_MaxLevel_CanBuild(n) > civilization.numOf_Workshops) {
                    arrayList2.add(new AI_Build_Option_Workshop());
                }
                if (civilization.getTechLevel() >= BuildingsManager.getMarket_TechLevel(1) && civilization.getNumOfProvs() * BuildingsManager.getMarket_MaxLevel_CanBuild(n) > civilization.numOf_Markets) {
                    arrayList2.add(new AI_Build_Option_Market());
                }
                if (civilization.getTechLevel() >= BuildingsManager.getLibrary_TechLevel(1) && civilization.getNumOfProvs() * BuildingsManager.getLibrary_MaxLevel_CanBuild(n) > civilization.numOf_Libraries) {
                    arrayList2.add(new AI_Build_Option_Library());
                }
                if (civilization.getSeaAccess() > 0 && civilization.getTechLevel() >= BuildingsManager.getPort_TechLevel(1) && civilization.getNumOfProvs() > civilization.numOf_Ports) {
                    arrayList2.add(new AI_Build_Option_Port());
                }
                if (civilization.getTechLevel() >= BuildingsManager.getArmoury_TechLevel(1) && civilization.getNumOfProvs() > civilization.numOf_Armories) {
                    arrayList2.add(new AI_Build_Option_Armoury());
                }
                if (civilization.getTechLevel() >= BuildingsManager.getSupply_TechLevel(1) && civilization.getNumOfProvs() > civilization.numOf_SuppliesCamp) {
                    arrayList2.add(new AI_Build_Option_Supplies());
                }
                if (civilization.getTechLevel() >= BuildingsManager.getFort_TechLevel(1) && civilization.getNumOfProvs() * BuildingsManager.getFort_MaxLevel_CanBuild(n) > civilization.numOf_Forts) {
                    arrayList2.add(new AI_Build_Option_Fort());
                }
                if (civilization.getTechLevel() >= BuildingsManager.getTower_TechLevel(1) && civilization.getNumOfProvs() * BuildingsManager.getTower_MaxLevel_CanBuild(n) > civilization.numOf_Towers) {
                    arrayList2.add(new AI_Build_Option_Tower());
                }
                arrayList2.add(new AI_Build_Option_Invest());
                if (civilization.fAverageDevelopment / civilization.getTechLevel() < GameValues.gvAiInvest.INVEST_DEV_DEVELOPMENT_TO_TECH_RATIO) {
                    arrayList2.add(new AI_Build_Option_Invest_Development());
                }
                arrayList2.add(new AI_Build_Option_Invest());
                if (!arrayList2.isEmpty()) {
                    int n2 = 0;
                    for (int i = n2 + 1; i < arrayList2.size(); ++i) {
                        if (!(((AI_Build_Option)arrayList2.get(i)).getScore(n) > ((AI_Build_Option)arrayList2.get(n2)).getScore(n))) continue;
                        n2 = i;
                    }
                    arrayList.add(((AI_Build_Option)arrayList2.get(n2)).getData(n));
                    if (((AI_Build)arrayList.get(0)).build(n, 0, false)) {
                        civilization.buildCivPersonality_Buildings();
                    }
                }
            }
            catch (Exception exception) {
                CFG.exceptionStack(exception);
            }
            arrayList2.clear();
            arrayList2 = null;
            arrayList.clear();
        }
    }

    public void buildInvestEco(int n) {
        if (this.build_GetMoney(n) <= 0L) {
            return;
        }
        try {
            AI_Build_Option_Invest2 aI_Build_Option_Invest2 = new AI_Build_Option_Invest2();
            AI_Build aI_Build = ((AI_Build_Option)aI_Build_Option_Invest2).getData(n);
            if (!aI_Build.build(n, 0, false)) {
                return;
            }
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
    }

    public void buildInvestDev(int n) {
        if (this.build_GetMoney(n) <= 0L) {
            return;
        }
        try {
            AI_Build_Option_Invest_Development2 aI_Build_Option_Invest_Development2 = new AI_Build_Option_Invest_Development2();
            AI_Build aI_Build = ((AI_Build_Option)aI_Build_Option_Invest_Development2).getData(n);
            if (!aI_Build.build(n, 0, false)) {
                return;
            }
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
    }

    public final void prepareArmyForRevolution(int n) {
    }

    public final void assimilateProvinces(int n) {
        try {
            if (CFG.core.getCiv(n).getDiploPoints() < GameValues.gvAssimilate.COST_ASSIMILATE_MOVEMENT) return;
            if (CFG.core.getCiv((int)n).provincesWithLowStability.isEmpty()) return;
            Civilization civ = CFG.core.getCiv(n);
            boolean isAtWarOrPreparing = civ.isAtWarC() || civ.civGD.civPlans.isPreparingForTheWar();
            long assimilateBudget;
            if (isAtWarOrPreparing) {
                assimilateBudget = Math.max(1L, (long)((float)civ.getGold() * 0.60f));
            } else {
                if ((float)civ.getGold() < GameValues.gvAssimilate.AI_ASSIMILATE_MIN_GOLD_MODIFIER * (float)GameManager.assimilateCost(civ.provincesWithLowStability.get(0), GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MIN)) return;
                assimilateBudget = civ.getGold();
            }
            ArrayList<AI_Assimilate_Data> arrayList = new ArrayList<AI_Assimilate_Data>();
            int n2 = civ.getCapitalProvID() >= 0 ? civ.getCapitalProvID() : civ.getProvID(0);
            for (int i = civ.provincesWithLowStability.size() - 1; i >= 0; --i) {
                arrayList.add(new AI_Assimilate_Data(civ.provincesWithLowStability.get(i), civ.civGD.civPers.ASSIMILATE_PERC_POPULATION_SCORE * Math.min((float)CFG.core.getProv(civ.provincesWithLowStability.get(i)).getPop().getPops() / (float)CFG.core.getGameScenars().getScenario_StartingPopulation(), 1.0f) + civ.civGD.civPers.ASSIMILATE_PERC_DISTANCE_SCORE * Distance.getDistanceFromCapital_PercOfMax(n2, civ.provincesWithLowStability.get(i)) + civ.civGD.civPers.ASSIMILATE_PERC_LOW_STABILITY_SCORE * (1.0f - CFG.core.getProv(civ.provincesWithLowStability.get(i)).getProviStability())));
            }
            ArrayList<AI_Assimilate_Data> arrayList2 = new ArrayList<AI_Assimilate_Data>();
            while (!arrayList.isEmpty()) {
                int n3 = 0;
                for (int i = n3 + 1; i < arrayList.size(); ++i) {
                    if (!(((AI_Assimilate_Data)arrayList.get((int)i)).fScore > ((AI_Assimilate_Data)arrayList.get((int)n3)).fScore)) continue;
                    n3 = i;
                }
                arrayList2.add((AI_Assimilate_Data)arrayList.get(n3));
                arrayList.remove(n3);
            }
            while (CFG.core.getCiv(n).getDiploPoints() >= GameValues.gvAssimilate.COST_ASSIMILATE_MOVEMENT && !arrayList2.isEmpty() && assimilateBudget > 0L) {
                long costPerTurn = GameManager.assimilateCost(((AI_Assimilate_Data)arrayList2.get((int)0)).iProvinceID, 1);
                if (costPerTurn > assimilateBudget) break;
                int numTurns = (int)Math.min(Math.min((100.0f - CFG.core.getProv(((AI_Assimilate_Data)arrayList2.get((int)0)).iProvinceID).getProviStability() * 100.0f) / GameValues.gvAiProvince.ASSIMILATE_STABILITY_TO_TURNS_DIVISOR, (float)(assimilateBudget / costPerTurn)), (float)GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MAX);
                long totalCost = GameManager.assimilateCost(((AI_Assimilate_Data)arrayList2.get((int)0)).iProvinceID, numTurns);
                if (totalCost > assimilateBudget) {
                    numTurns = 1;
                    totalCost = costPerTurn;
                }
                if (GameManager.addAssi(n, ((AI_Assimilate_Data)arrayList2.get((int)0)).iProvinceID, numTurns)) {
                    assimilateBudget -= totalCost;
                    arrayList2.remove(0);
                } else break;
            }
            arrayList2.clear();
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
    }

    public final void hostFestivals(int n, int n2) {
        try {
            if (CFG.core.getCiv(n).getMovemPoints() >= GameValues.gvFestival.COST_FESTIVAL_MOVEMENT_POINTS && (float)CFG.core.getCiv(n).getGold() >= GameValues.gvFestival.AI_FESTIVAL_MIN_GOLD_MODIFIER * (float)Festival.festivalCost(CFG.core.getCiv((int)n).provincesWithLowHappiness.get(0))) {
                ArrayList<AI_Assimilate_Data> arrayList = new ArrayList<AI_Assimilate_Data>();
                int n3 = CFG.core.getCiv(n).getCapitalProvID() >= 0 ? CFG.core.getCiv(n).getCapitalProvID() : CFG.core.getCiv(n).getProvID(0);
                for (int i = CFG.core.getCiv((int)n).provincesWithLowHappiness.size() - 1; i >= 0; --i) {
                    arrayList.add(new AI_Assimilate_Data(CFG.core.getCiv((int)n).provincesWithLowHappiness.get(i), (CFG.core.getCiv((int)n).civGD.civPers.ASSIMILATE_PERC_POPULATION_SCORE * Math.min((float)CFG.core.getProv(CFG.core.getCiv((int)n).provincesWithLowHappiness.get(i)).getPop().getPops() / (float)CFG.core.getGameScenars().getScenario_StartingPopulation(), 1.0f) + CFG.core.getCiv((int)n).civGD.civPers.ASSIMILATE_PERC_DISTANCE_SCORE * Distance.getDistanceFromCapital_PercOfMax(n3, CFG.core.getCiv((int)n).provincesWithLowHappiness.get(i))) * CFG.core.getProv(CFG.core.getCiv((int)n).provincesWithLowHappiness.get(i)).getProviStability()));
                }
                ArrayList<AI_Assimilate_Data> arrayList2 = new ArrayList<AI_Assimilate_Data>();
                while (!arrayList.isEmpty()) {
                    int n4 = 0;
                    for (int i = n4 + 1; i < arrayList.size(); ++i) {
                        if (!(((AI_Assimilate_Data)arrayList.get((int)i)).fScore > ((AI_Assimilate_Data)arrayList.get((int)n4)).fScore)) continue;
                        n4 = i;
                    }
                    arrayList2.add((AI_Assimilate_Data)arrayList.get(n4));
                    arrayList.remove(n4);
                }
                while (CFG.core.getCiv(n).getMovemPoints() >= GameValues.gvFestival.COST_FESTIVAL_MOVEMENT_POINTS && !arrayList2.isEmpty() && (float)CFG.core.getCiv(n).getGold() >= GameValues.gvFestival.AI_FESTIVAL_MIN_GOLD_MODIFIER * (float)Festival.festivalCost(((AI_Assimilate_Data)arrayList2.get((int)0)).iProvinceID) && Festival.addFestival(n, ((AI_Assimilate_Data)arrayList2.get((int)0)).iProvinceID)) {
                    arrayList2.remove(0);
                    if (n2-- > 0) continue;
                    return;
                }
                arrayList2.clear();
            }
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
    }

    public final void changeTypeOfIdeology(int n) {
        if (CFG.core.getCiv((int)n).civGD.changeTypeOfGovernment != null) {
            if (CFG.core.getCiv(n).isAtWarC()) {
                CFG.core.getCiv((int)n).civGD.changeTypeOfGovernment = null;
            } else if (CFG.core.getCiv((int)n).civGD.changeTypeOfGovernment.action(n)) {
                CFG.core.getCiv((int)n).civGD.changeTypeOfGovernment = null;
            }
        }
    }

    public final void relocateLostCapital(int n) {
        try {
            if (!(CFG.core.getCiv(n).getCapitalProvID() == CFG.core.getCiv(n).getCoreCapitalProvID() || CFG.core.getCiv(n).getCoreCapitalProvID() < 0 || CFG.core.getProv(CFG.core.getCiv(n).getCoreCapitalProvID()).getCivId() != n || CFG.core.getProv(CFG.core.getCiv(n).getCoreCapitalProvID()).isOccupied() || CFG.core.getCiv(n).getCapitalProvID() >= 0 && CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).getCivId() != n)) {
                if ((float)CFG.core.getCiv(n).getGold() > (float)CFG.gameAction.moveCapital_Cost(n) * 4.76124f) {
                    CFG.gameAction.moveCapital(n, CFG.core.getCiv(n).getCoreCapitalProvID());
                }
            } else if (CFG.core.getCiv(n).getCapitalProvID() < 0 || CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).getCivId() != n && (!CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).isOccupied() || !CFG.core.getCivsAtWar(n, CFG.core.getProv(CFG.core.getCiv(n).getCapitalProvID()).getCivId()))) {
                int n2 = CFG.core.getCiv(n).getProvID(0);
                int n3 = this.relocateLostCapital_ProvinceScore(n, CFG.core.getCiv(n).getProvID(0));
                for (int i = 1; i < CFG.core.getCiv(n).getNumOfProvs(); ++i) {
                    int n4 = this.relocateLostCapital_ProvinceScore(n, CFG.core.getCiv(n).getProvID(i));
                    if (n3 >= n4) continue;
                    n3 = n4;
                    n2 = CFG.core.getCiv(n).getProvID(i);
                }
                if (!CFG.core.getProv(n2).isOccupied()) {
                    CFG.gameAction.moveCapital(n, n2);
                }
            }
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
    }

    public final int relocateLostCapital_ProvinceScore(int n, int n2) {
        return CFG.core.getProv(n2).isOccupied() ? -1 : (int)((float)CFG.core.getProv(n).getPop().getPopulationOfCivID(n) + (float)CFG.core.getProv(n).getPop().getPops() / GameValues.gvAiProvince.RELOCATE_CAPITAL_TOTAL_POPULATION_DIVISOR + (float)CFG.core.getProv(n).getEco() / GameValues.gvAiProvince.RELOCATE_CAPITAL_ECONOMY_DIVISOR);
    }

    public final void respondToEvents(int n) {
        CFG.core.getCiv(n).runNextEvent2();
    }

    public final void respondToMessages(int n) {
        try {
            Civilization civ = CFG.core.getCiv(n);
            MessageBox_GameData messageBox = civ.getCivDiploGD().messageBox;
            if (messageBox.lMessages.isEmpty()) {
                return;
            }
            int i = messageBox.getMessagesSize() - 1;
            int tLimit = 0;
            int a;
            int b;
            int j;
            int k;
            int o;
            int z;
            int p;
            int peaceID;
            int warID;
            int nWarID;
            int trueOwnerProvinces;
            long powerLeft;
            long powerRight;
            int playerID_InPeaceTreaty;
            long civIncome;
            long totalCost;
            long maxGold;
            int tPlayerID;
            int nPlayerID;
            long totalBudget;
            long totalGold;
            float nPercOfBudget;
            float nScore;
            float minDistance;
            float relationModifier;
            boolean canEnd;
            boolean canEnd_V2;
            boolean playerTakesPartInPeaceTreaty;

            
            int var1_1 = n;
            Civilization var2_2 = civ;
            MessageBox_GameData var3_4 = messageBox;
            int var4_5 = i;
            int var6_7 = 0;
            int var10_11 = 0;
            int var13_14 = 0;
            int var14_15 = 0;
            int var15_16 = 0;
            int var16_17 = 0;
            long var17_18 = 0L;
            long var18_19 = 0L;
            int var19_20 = 0;
            boolean var32_32 = false;
            boolean var33_33 = false;
            boolean var34_34 = false;
            boolean var35_35 = false;
            boolean var37_37 = false;
            boolean v0 = false;
            Message var40_40 = null;
            PeaceTreaty_Data var41_41 = null;
            
            boolean playerOccupiedProvincesInThisPeace;
            boolean alreadyGuaratneed;
            boolean sameRivals;
            boolean warAgainstFriendlyCiv;
            boolean haveACore;
            Message message;
            PeaceTreaty_Data tempData;
            TradeRequest_GameData tradeRequest;
            List<Boolean> lDefenders;
            List<Boolean> lAggressors;
            List<Integer> callToArms;

            block55: for (tLimit = 0; i >= 0 && tLimit < 100; --i, ++tLimit) {
                message = messageBox.getMessage(i);
                var40_40 = message;
                var4_5 = i;
                switch (message.messageType) {
                    case PEACE_TREATY_LIST_OF_DEMANDS: {
                        try {
                            if (CFG.SANDBOX_MODE) {
                                var40_40.onAccept(var1_1);
                                var3_4.removeMessage(var4_5);
                                continue block55;
                            }
                            if (CFG.ideologiesMgr.getIdeologyID((int)var2_2.getIdeology()).REVOLUTIONARY) {
                                var3_4.removeMessage(var4_5);
                                continue block55;
                            }
                            if (var2_2.getNumOfProvs_NotOccupied() == 0) {
                                var40_40.onAccept(var1_1);
                                var3_4.removeMessage(var4_5);
                                continue block55;
                            }
                            var13_14 = CFG.core.getPeaceTreaty_GameDataID(var40_40.TAG);
                            if (var13_14 < 0) {
                                var3_4.removeMessage(var4_5);
                                continue block55;
                            }
                            var41_41 = new PeaceTreaty_Data(CFG.core.lPeaceTreaties.get((int)var13_14).peaceTreaty_GameData);
                            if (var41_41.peaceTreatyGD.civsDataDefenders.isEmpty() || var41_41.peaceTreatyGD.civsDataAggressors.isEmpty()) {
                                try {
                                    var40_40.onAccept(var1_1);
                                }
                                catch (Exception var46_47) {
                                    CFG.exceptionStack(var46_47);
                                }
                                var3_4.removeMessage(var4_5);
                                continue block55;
                            }
                            var14_15 = CFG.core.getWarID(var41_41.peaceTreatyGD.civsDataDefenders.get((int)0).iCivID, var41_41.peaceTreatyGD.civsDataAggressors.get((int)0).iCivID);
                            if (var14_15 < 0) {
                                try {
                                    var40_40.onAccept(var1_1);
                                }
                                catch (Exception var46_48) {
                                    CFG.exceptionStack(var46_48);
                                }
                                var3_4.removeMessage(var4_5);
                                continue block55;
                            }
                            
                            int currentWarScore = CFG.core.getCachedWarScore(CFG.core.getWar(var14_15));
                            if (CFG.core.getWar(var14_15).getIsDefender(var1_1)) {
                                if (currentWarScore <= -100) {
                                    var40_40.onAccept(var1_1);
                                    var3_4.removeMessage(var4_5);
                                    continue block55;
                                }
                            } else if (currentWarScore >= 100) {
                                var40_40.onAccept(var1_1);
                                var3_4.removeMessage(var4_5);
                                continue block55;
                            }

                            var32_32 = false;
                            try {
                                var32_32 = GameCalendar.TURNID > CFG.core.getWar(var14_15).getWarTurnID() + GameValues.gvPeaceTreaty.AI_PEACE_TREATY_ACCEPTED_WAR_TURNS;
                            }
                            catch (Exception var46_49) {
                                CFG.exceptionStack(var46_49);
                            }
                            if (!var32_32) {
                                try {
                                    if (var2_2.getNumOfProvs_NotOccupied() == 0) {
                                        var32_32 = true;
                                    }
                                }
                                catch (Exception var46_50) {
                                    CFG.exceptionStack(var46_50);
                                }
                            }
                            if (!var32_32) {
                                try {
                                    if (currentWarScore < -25) {
                                        if (CFG.core.getCiv(CFG.core.getWar(var14_15).getDefenderID(0).getCivID()).getNumOfProvs_NotOccupied() == 0) {
                                            var32_32 = true;
                                        }
                                    } else if (currentWarScore > 25) {
                                        if (CFG.core.getCiv(CFG.core.getWar(var14_15).getAggressorID(0).getCivID()).getNumOfProvs_NotOccupied() == 0) {
                                            var32_32 = true;
                                        }
                                    }
                                }
                                catch (Exception var46_51) {
                                    CFG.exceptionStack(var46_51);
                                }
                            }
                            if (!var32_32) {
                                try {
                                    for (var6_7 = 0; var6_7 < CFG.core.getPlayersSize(); ++var6_7) {
                                        if (var2_2.getPuppetOfCiv() != CFG.core.getPlayer(var6_7).getCivId()) continue;
                                        var32_32 = true;
                                        break;
                                    }
                                }
                                catch (Exception var46_52) {
                                    CFG.exceptionStack(var46_52);
                                }
                            }
                            
                            var33_33 = false;
                            try {
                                for (var10_11 = 0; var10_11 < var41_41.peaceTreatyGD.civsDataDefenders.size(); ++var10_11) {
                                    if (CFG.core.getCiv(var41_41.peaceTreatyGD.civsDataDefenders.get((int)var10_11).iCivID).getNumOfProvs_NotOccupied() == 0) {
                                        var33_33 = true;
                                        break;
                                    }
                                }
                                if (!var33_33) {
                                    for (var10_11 = 0; var10_11 < var41_41.peaceTreatyGD.civsDataAggressors.size(); ++var10_11) {
                                        if (CFG.core.getCiv(var41_41.peaceTreatyGD.civsDataAggressors.get((int)var10_11).iCivID).getNumOfProvs_NotOccupied() == 0) {
                                            var33_33 = true;
                                            break;
                                        }
                                    }
                                }
                            }
                            catch (Exception var46_53) {
                                var33_33 = true;
                            }
                            
                            if (var32_32 || var33_33) {
                                var40_40.onAccept(var1_1);
                            } else {
                                var17_18 = 0;
                                var18_19 = 0;
                                try {
                                    for (var10_11 = 0; var10_11 < var41_41.peaceTreatyGD.civsDataDefenders.size(); ++var10_11) {
                                        var17_18 += Math.max(CFG.core.getCiv(var41_41.peaceTreatyGD.civsDataDefenders.get((int)var10_11).iCivID).getGold(), 0L) / (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT + CFG.core.getCiv(var41_41.peaceTreatyGD.civsDataDefenders.get((int)var10_11).iCivID).getNumberOfUnits() + (long)CFG.core.getCiv(var41_41.peaceTreatyGD.civsDataDefenders.get((int)var10_11).iCivID).getNumOfProvs();
                                    }
                                    for (var10_11 = 0; var10_11 < var41_41.peaceTreatyGD.civsDataAggressors.size(); ++var10_11) {
                                        var18_19 += Math.max(CFG.core.getCiv(var41_41.peaceTreatyGD.civsDataAggressors.get((int)var10_11).iCivID).getGold(), 0L) / (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT + CFG.core.getCiv(var41_41.peaceTreatyGD.civsDataAggressors.get((int)var10_11).iCivID).getNumberOfUnits() + (long)CFG.core.getCiv(var41_41.peaceTreatyGD.civsDataAggressors.get((int)var10_11).iCivID).getNumOfProvs();
                                    }
                                }
                                catch (Exception var46_53) {}

                                if (CFG.core.getWar(var14_15).getIsDefender(var1_1)) {
                                    if ((float)var17_18 > (float)var18_19 * GameValues.gvPeaceTreaty.AI_PEACE_TREATY_POWER_RIGHT_MODIFIER) {
                                        var40_40.onDecline(var1_1);
                                    } else {
                                        var40_40.onAccept(var1_1);
                                    }
                                } else if ((float)var18_19 > (float)var17_18 * GameValues.gvPeaceTreaty.AI_PEACE_TREATY_POWER_RIGHT_MODIFIER) {
                                    var40_40.onDecline(var1_1);
                                } else {
                                    var40_40.onAccept(var1_1);
                                }
                            }
                        }
                        catch (Exception ex) {
                            CFG.exceptionStack(ex);
                        }
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case WE_CAN_SIGN_PEACE:
                    case WE_CAN_SIGN_PEACE_STATUS_QUO: {
                        nWarID = CFG.core.getWarID(n, message.fromCivID);
                        playerTakesPartInPeaceTreaty = false;
                        playerID_InPeaceTreaty = -1;
                        if (nWarID >= 0) {
                            if (CFG.core.getPeaceTreaty_GameData_AlreadySent(n, message.fromCivID)) {
                                messageBox.removeMessage(i);
                                continue block55;
                            }
                            lDefenders = new ArrayList<Boolean>();
                            lAggressors = new ArrayList<Boolean>();
                            if (CFG.core.getWar(nWarID).getIsAggressor(n)) {
                                for (o = 0; o < CFG.core.getWar(nWarID).getAggressorsSize(); ++o) {
                                    lAggressors.add(true);
                                    if (!CFG.core.getCiv(CFG.core.getWar(nWarID).getAggressorID(o).getCivID()).getIsPlayer()) continue;
                                    playerOccupiedProvincesInThisPeace = false;
                                    block63: for (z = 0; z < CFG.core.getCiv(CFG.core.getWar(nWarID).getAggressorID(o).getCivID()).getNumOfProvs(); ++z) {
                                        if (!CFG.core.getProv(CFG.core.getCiv(CFG.core.getWar(nWarID).getAggressorID(o).getCivID()).getProvID(z)).isOccupied()) continue;
                                        for (p = 0; p < CFG.core.getWar(nWarID).getDefendersSize(); ++p) {
                                            if (CFG.core.getWar(nWarID).getDefenderID(p).getCivID() != CFG.core.getProv(CFG.core.getCiv(CFG.core.getWar(nWarID).getAggressorID(o).getCivID()).getProvID(z)).getTrueOwnerOfProv()) continue;
                                            playerOccupiedProvincesInThisPeace = true;
                                            z = CFG.core.getCiv(CFG.core.getWar(nWarID).getAggressorID(o).getCivID()).getNumOfProvs();
                                            continue block63;
                                        }
                                    }
                                    if (!var35_35) continue;
                                    var34_34 = true;
                                }
                                for (o = 0; o < CFG.core.getWar(nWarID).getDefendersSize(); ++o) {
                                    lDefenders.add(CFG.core.getWar(nWarID).getDefenderID(o).getCivID() == message.fromCivID || CFG.core.getCiv(CFG.core.getWar(nWarID).getDefenderID(o).getCivID()).getNumOfProvs() == 0);
                                }
                            } else {
                                for (o = 0; o < CFG.core.getWar(nWarID).getAggressorsSize(); ++o) {
                                    lAggressors.add(CFG.core.getWar(nWarID).getAggressorID(o).getCivID() == message.fromCivID || CFG.core.getCiv(CFG.core.getWar(nWarID).getAggressorID(o).getCivID()).getNumOfProvs() == 0);
                                }
                                for (o = 0; o < CFG.core.getWar(nWarID).getDefendersSize(); ++o) {
                                    lDefenders.add(true);
                                    if (!CFG.core.getCiv(CFG.core.getWar(nWarID).getDefenderID(o).getCivID()).getIsPlayer()) continue;
                                    playerTakesPartInPeaceTreaty = true;
                                    playerOccupiedProvincesInThisPeace = false;
                                    block68: for (z = 0; z < CFG.core.getCiv(CFG.core.getWar(nWarID).getDefenderID(o).getCivID()).getNumOfProvs(); ++z) {
                                        if (!CFG.core.getProv(CFG.core.getCiv(CFG.core.getWar(nWarID).getDefenderID(o).getCivID()).getProvID(z)).isOccupied()) continue;
                                        for (p = 0; p < CFG.core.getWar(nWarID).getAggressorsSize(); ++p) {
                                            if (CFG.core.getWar(nWarID).getAggressorID(p).getCivID() != CFG.core.getProv(CFG.core.getCiv(CFG.core.getWar(nWarID).getDefenderID(o).getCivID()).getProvID(z)).getTrueOwnerOfProv()) continue;
                                            playerOccupiedProvincesInThisPeace = true;
                                            z = CFG.core.getCiv(CFG.core.getWar(nWarID).getDefenderID(o).getCivID()).getNumOfProvs();
                                            continue block68;
                                        }
                                    }
                                    if (!var35_35) continue;
                                    var34_34 = true;
                                }
                            }
                            if (playerTakesPartInPeaceTreaty) {
                                messageBox.removeMessage(i);
                                continue block55;
                            }
                            if (!CFG.SPECTATOR_MODE && GameValues.gvInGame.ENABLE_PLAYER_AI_PEACE_PROPOSITION_RETRY) {
                                try {
                                    for (var10_11 = 0; var10_11 < CFG.core.getWar(var15_16).getAggressorsSize(); ++var10_11) {
                                        if (!CFG.core.getCiv(CFG.core.getWar(var15_16).getAggressorID(var10_11).getCivID()).getIsPlayer()) continue;
                                        var19_20 = CFG.core.getPlayerIDbyCivID(CFG.core.getWar(var15_16).getAggressorID(var10_11).getCivID());
                                    }
                                    for (var10_11 = 0; var10_11 < CFG.core.getWar(var15_16).getDefendersSize(); ++var10_11) {
                                        if (!CFG.core.getCiv(CFG.core.getWar(var15_16).getDefenderID(var10_11).getCivID()).getIsPlayer()) continue;
                                        var19_20 = CFG.core.getPlayerIDbyCivID(CFG.core.getWar(var15_16).getDefenderID(var10_11).getCivID());
                                    }
                                    if (playerID_InPeaceTreaty >= 0) {
                                        if (GameManager.playerAIPeace_WasSent(n, CFG.core.getPlayer(playerID_InPeaceTreaty).getCivId())) {
                                            messageBox.removeMessage(i);
                                            continue block55;
                                        }
                                        GameManager.playerAIPeace_AddCiv(n, CFG.core.getPlayer(playerID_InPeaceTreaty).getCivId());
                                    }
                                }
                                catch (Exception var46_55) {
                                    CFG.exceptionStack(var46_55);
                                }
                            }
                            Menu_PeaceTreaty.WAR_ID = nWarID;
                            CFG.peaceTreatyData = new PeaceTreaty_Data(Menu_PeaceTreaty.WAR_ID, lDefenders, lAggressors, CFG.core.getWar(nWarID).getIsAggressor(n));
                            CFG.peaceTreatyData.AIUseVictoryPoints();
                            GameManager.sendPeaceTreaty(CFG.core.getWar(CFG.peaceTreatyData.peaceTreatyGD.iWarID).getIsAggressor(n), n, CFG.peaceTreatyData.peaceTreatyGD);
                        }
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case JOIN_ALLIANCE: {
                        if (CFG.core.getCiv(message.fromCivID).getCivDiploGD().getIsEmbassyClosed(n)) {
                            message.onDecline(n);
                        } else if (civ.civGD.civPlans.isPreparingForTheWar(message.fromCivID)) {
                            message.onDecline(n);
                        } else if (GameManager.getAllianceProposal_Positive(message.fromCivID, n) + GameManager.getAllianceProposal_Negative(message.fromCivID, n) > 0 || CFG.core.getCivRelationOfCivB(n, message.fromCivID) > 0.0f && CFG.oR.nextInt(1000) < GameValues.gvAiDiplomacy.ALLIANCE_RANDOM_ACCEPT_CHANCE_PER_1000) {
                            message.onAccept(n);
                        } else {
                            message.onDecline(n);
                        }
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case NONAGGRESSIONPACT: {
                        if (civ.civGD.civPlans.isPreparingForTheWar(message.fromCivID)) {
                            message.onDecline(n);
                        } else if (CFG.core.getCivRelationOfCivB(n, message.fromCivID) > (float)GameValues.gvAiDiplomacy.NON_AGGRESSION_PACT_ACCEPT_MIN_RELATION) {
                            message.onAccept(n);
                        } else {
                            message.onDecline(n);
                        }
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case PREPARE_FOR_WAR: {
                        if (CFG.core.getCiv(message.fromCivID).getCivDiploGD().getIsEmbassyClosed(n)) {
                            message.onDecline(n);
                        } else if (CFG.core.getCivRelationOfCivB(n, message.fromCivID) > (float)GameValues.gvAiDiplomacy.PREPARE_FOR_WAR_ACCEPT_MIN_RELATION) {
                            message.onAccept(n);
                        } else {
                            message.onDecline(n);
                        }
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case DEFENSIVEPACT: {
                        if (civ.civGD.civPlans.isPreparingForTheWar(message.fromCivID)) {
                            message.onDecline(n);
                        } else if (CFG.core.getCivRelationOfCivB(n, message.fromCivID) > (float)GameValues.gvAiDiplomacy.DEFENSIVE_PACT_ACCEPT_MIN_RELATION) {
                            sameRivals = false;
                            for (a = 0; a < civ.getHatedCivsSize(); ++a) {
                                for (b = 0; b < CFG.core.getCiv(message.fromCivID).getHatedCivsSize(); ++b) {
                                    if (!CFG.core.getCiv(message.fromCivID).isHatedCiv(civ.getHatedCiv((int)a).iCivID)) continue;
                                    sameRivals = true;
                                    break;
                                }
                                if (var37_37) break;
                            }
                            if (sameRivals || !GameValues.gvAiDiplomacy.DEFENSIVE_PACT_ACCEPT_SAME_RIVALS_REQUIRED) {
                                message.onAccept(n);
                            } else {
                                message.onDecline(n);
                            }
                        } else {
                            message.onDecline(n);
                        }
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case DEFENSIVEPACT_EXPIRED: {
                        if (!civ.isAtWarC() && !CFG.core.getCiv(message.fromCivID).isAtWarC() && civ.isFriendlyCiv(message.fromCivID) > 0 && CFG.oR.nextInt(100) < GameValues.gvAiDiplomacy.DEFENSIVE_PACT_RENEW_CHANCE_100) {
                            GameManager.sendDefensivePactProposal(message.fromCivID, n, GameValues.gvDipNonAggression.DIPLOMACY_MAX_NUMBER_OF_TURNS_NON_AGGRESSION_PACT);
                        }
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case NONAGGRESSIONPACT_EXPIRED: {
                        if (CFG.core.getCivsAtWar(n, message.fromCivID) || civ.isFriendlyCiv(message.fromCivID) <= 0 || CFG.oR.nextInt(100) >= GameValues.gvAiDiplomacy.NONAGGRESSION_PACT_RENEW_CHANCE_100) continue block55;
                        GameManager.sendNonAggressionProposal(message.fromCivID, n, GameValues.gvDipNonAggression.DIPLOMACY_MAX_NUMBER_OF_TURNS_NON_AGGRESSION_PACT);
                        continue block55;
                    }
                    case GIFT: {
                        nPercOfBudget = (float)message.iValue / (float)civ.iBudget;
                        if (civ.civGD.civPlans.isPreparingForTheWar(message.fromCivID)) {
                            message.onAccept(n);
                            if (civ.getPuppetOfCiv() == message.fromCivID) {
                                civ.setVassalLibertyDesire(civ.getVassalLibertyDesire() - Math.max(GameValues.gvGift.GIFT_LIBERTY_DESIRE_DECREASE_MIN, Math.min(GameValues.gvGift.GIFT_LIBERTY_DESIRE_DECREASE_MAX, GameValues.gvGift.GIFT_LIBERTY_DESIRE_DECREASE_MAX * ((float)message.iValue / (float)(civ.incomeTaxation + civ.incomeProduction)))));
                            }
                        } else if (civ.isHatedCiv(message.fromCivID) || CFG.core.getCiv(message.fromCivID).isHatedCiv(n)) {
                            if (nPercOfBudget > GameValues.gvAiDiplomacy.GIFT_HATED_CIV_THRESHOLD + (float)CFG.oR.nextInt(GameValues.gvAiDiplomacy.GIFT_HATED_CIV_THRESHOLD_RANDOM_1000) / 1000.0f) {
                                civ.getCivDiploGD().addImproveRelations(n, message.fromCivID, GameValues.gvAiDiplomacy.GIFT_IMPROVE_RELATIONS_HATED_TURNS_MIN + CFG.oR.nextInt(GameValues.gvAiDiplomacy.GIFT_IMPROVE_RELATIONS_HATED_TURNS_RANDOM));
                                message.onAccept(n);
                                if (civ.getPuppetOfCiv() == message.fromCivID) {
                                    civ.setVassalLibertyDesire(civ.getVassalLibertyDesire() - Math.max(GameValues.gvGift.GIFT_LIBERTY_DESIRE_DECREASE_MIN, Math.min(GameValues.gvGift.GIFT_LIBERTY_DESIRE_DECREASE_MAX, GameValues.gvGift.GIFT_LIBERTY_DESIRE_DECREASE_MAX * ((float)message.iValue / (float)(civ.incomeTaxation + civ.incomeProduction)))));
                                }
                            } else {
                                message.onAccept(n);
                                if (civ.getPuppetOfCiv() == message.fromCivID) {
                                    civ.setVassalLibertyDesire(civ.getVassalLibertyDesire() - Math.max(GameValues.gvGift.GIFT_LIBERTY_DESIRE_DECREASE_MIN, Math.min(GameValues.gvGift.GIFT_LIBERTY_DESIRE_DECREASE_MAX, GameValues.gvGift.GIFT_LIBERTY_DESIRE_DECREASE_MAX * ((float)message.iValue / (float)(civ.incomeTaxation + civ.incomeProduction)))));
                                }
                            }
                        } else {
                            message.onAccept(n);
                            if (civ.getPuppetOfCiv() == message.fromCivID) {
                                civ.setVassalLibertyDesire(civ.getVassalLibertyDesire() - Math.max(GameValues.gvGift.GIFT_LIBERTY_DESIRE_DECREASE_MIN, Math.min(GameValues.gvGift.GIFT_LIBERTY_DESIRE_DECREASE_MAX, GameValues.gvGift.GIFT_LIBERTY_DESIRE_DECREASE_MAX * ((float)message.iValue / (float)(civ.incomeTaxation + civ.incomeProduction)))));
                            }
                            if (nPercOfBudget > GameValues.gvAiDiplomacy.GIFT_RELATION_IMPROVE_THRESHOLD + (float)CFG.oR.nextInt(GameValues.gvAiDiplomacy.GIFT_RELATION_IMPROVE_THRESHOLD_RANDOM_1000) / 1000.0f) {
                                civ.getCivDiploGD().addImproveRelations(n, message.fromCivID, GameValues.gvAiDiplomacy.GIFT_IMPROVE_RELATIONS_TURNS_MIN + CFG.oR.nextInt(GameValues.gvAiDiplomacy.GIFT_IMPROVE_RELATIONS_TURNS_RANDOM));
                            }
                            if ((civ.isFriendlyCiv(message.fromCivID) >= 0 || CFG.core.getCiv(message.fromCivID).isFriendlyCiv(n) >= 0) && civ.getNumOfProvs() > GameValues.gvAiDiplomacy.GIFT_GUARANTEE_MIN_OWN_PROVINCES && civ.getNumOfProvs() > CFG.core.getCiv(message.fromCivID).getNumOfProvs() && CFG.core.getCiv(message.fromCivID).getNumOfProvs() < GameValues.gvAiDiplomacy.GIFT_GUARANTEE_MAX_FROM_CIV_PROVINCES) {
                                alreadyGuaratneed = false;
                                for (z = 1; z < CFG.core.getCivsSize(); ++z) {
                                    if (CFG.core.getGuarantee(z, message.fromCivID) <= 0) continue;
                                    alreadyGuaratneed = true;
                                    break;
                                }
                                if (!alreadyGuaratneed) {
                                    GameManager.sendGuaranteeIndependence_AskProposal(message.fromCivID, n, GameValues.gvDipNonAggression.DIPLOMACY_MAX_NUMBER_OF_TURNS_NON_AGGRESSION_PACT);
                                }
                            }
                        }
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case GUARANTEE_ASK: {
                        if (civ.civGD.civPlans.isPreparingForTheWar(message.fromCivID)) {
                            message.onDecline(n);
                        } else if (civ.isHatedCiv(message.fromCivID)) {
                            message.onDecline(n);
                        } else if ((float)civ.iBudget > (float)CFG.core.getCiv((int)message.fromCivID).iBudget * GameValues.gvAiDiplomacy.GUARANTEE_DECLINE_BUDGET_MODIFIER_FROM_CIV) {
                            message.onDecline(n);
                        } else {
                            message.onAccept(n);
                        }
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case MILITARY_ACCESS_ASK: {
                        if (CFG.core.getCiv(message.fromCivID).getCivDiploGD().getIsEmbassyClosed(n)) {
                            message.onDecline(n);
                        } else {
                            nScore = GameValues.gvAiDiplomacy.MILITARY_ACCESS_BASE_SCORE;
                            if (!civ.civGD.civPlans.isPreparingForTheWar(message.fromCivID)) {
                                minDistance = 1.0f;
                                for (k = 0; k < civ.getNumOfProvs(); ++k) {
                                    for (j = 0; j < CFG.core.getCiv(message.fromCivID).getNumOfProvs(); ++j) {
                                        minDistance = Math.min(minDistance, Distance.getDistanceFromAToB_PercOfMax(civ.getProvID(k), CFG.core.getCiv(message.fromCivID).getProvID(j)));
                                    }
                                }
                                nScore -= civ.RESPONSE_MILITARY_ACCESS_DISTANCE_SCORE * minDistance;
                                nScore += civ.RESPONSE_MILITARY_ACCESS_RELATION_SCORE * CFG.core.getCivRelationOfCivB(n, message.fromCivID) / 100.0f;
                                nScore += civ.RESPONSE_MILITARY_ACCESS_RANK_SCORE * ((float)CFG.core.getCiv(message.fromCivID).getRankScore() / (float)CFG.core.getCivsSize());
                                nScore -= civ.RESPONSE_MILITARY_ACCESS_RANK_OWN_SCORE * ((float)civ.getRankScore() / (float)CFG.core.getCivsSize());
                                if (CFG.core.getMilitaryAccess(n, message.fromCivID) > 0) {
                                    nScore += GameValues.gvAiDiplomacy.MILITARY_ACCESS_SCORE_EXISTING_OUTGOING;
                                }
                                if (CFG.core.getMilitaryAccess(message.fromCivID, n) > 0) {
                                    nScore += GameValues.gvAiDiplomacy.MILITARY_ACCESS_SCORE_EXISTING_INCOMING;
                                }
                                if (CFG.core.getGuarantee(message.fromCivID, n) > 0) {
                                    nScore += GameValues.gvAiDiplomacy.MILITARY_ACCESS_SCORE_GUARANTEE;
                                }
                                if (civ.getIsPartOfHolyRomanEmpire() || CFG.core.getCiv(message.fromCivID).getIsPartOfHolyRomanEmpire()) {
                                    if (civ.getIsPartOfHolyRomanEmpire() && CFG.core.getCiv(message.fromCivID).getIsPartOfHolyRomanEmpire()) {
                                        if (CFG.core.getCivRelationOfCivB(n, message.fromCivID) > GameValues.gvAiDiplomacy.MILITARY_ACCESS_SCORE_HRE_FRIENDLY_MIN_RELATION) {
                                            nScore += GameValues.gvAiDiplomacy.MILITARY_ACCESS_SCORE_HRE_FRIENDLY;
                                            if (CFG.hreMgr.getHRE().getIsEmperor(message.fromCivID)) {
                                                nScore += GameValues.gvAiDiplomacy.MILITARY_ACCESS_SCORE_HRE_EMPEROR;
                                            }
                                        }
                                    } else if (!CFG.core.getCiv(message.fromCivID).getIsPartOfHolyRomanEmpire()) {
                                        nScore += GameValues.gvAiDiplomacy.MILITARY_ACCESS_SCORE_HRE_CIV_FROM_IS_NOT_IN_HRE;
                                    }
                                }
                                if (civ.getAlliance() > 0) {
                                    for (j = 0; j < CFG.core.getAlliance(civ.getAlliance()).getCivilizationsSize(); ++j) {
                                        if (CFG.core.getAlliance(civ.getAlliance()).getCivilization(j) != n && CFG.core.getCivRelationOfCivB(CFG.core.getAlliance(civ.getAlliance()).getCivilization(j), message.fromCivID) < 0.0f) {
                                            nScore -= GameValues.gvAiDiplomacy.MILITARY_ACCESS_ALLIANCE_PENALTY_MULT * CFG.core.getCivRelationOfCivB(CFG.core.getAlliance(civ.getAlliance()).getCivilization(j), message.fromCivID) / 100.0f;
                                        }
                                        if (!CFG.core.getCivsAtWar(CFG.core.getAlliance(civ.getAlliance()).getCivilization(j), message.fromCivID)) continue;
                                        nScore = GameValues.gvAiDiplomacy.MILITARY_ACCESS_SCORE_ALLY_AT_WAR;
                                    }
                                }
                                if (civ.isAtWarC()) {
                                    for (j = 0; j < CFG.core.getWarsSize(); ++j) {
                                        if (CFG.core.getWar(j).getIsDefender(n) && CFG.core.getWar(j).getIsDefender(message.fromCivID)) {
                                            nScore += GameValues.gvAiDiplomacy.MILITARY_ACCESS_SCORE_SHARED_WAR;
                                            break;
                                        }
                                        if (!CFG.core.getWar(j).getIsAggressor(n) || !CFG.core.getWar(j).getIsAggressor(message.fromCivID)) continue;
                                        nScore += GameValues.gvAiDiplomacy.MILITARY_ACCESS_SCORE_SHARED_WAR;
                                        break;
                                    }
                                }
                                try {
                                    if ((float)civ.getDefensivePact8(message.fromCivID) > GameValues.gvAiDiplomacy.MILITARY_ACCESS_ACCEPT_MIN_SCORE) {
                                        nScore += civ.RESPONSE_MILITARY_ACCESS_DEFENSIVE_PACT_SCORE;
                                    }
                                }
                                catch (Exception var46_56) {
                                    
                                }
                                if (nScore > 0.0f) {
                                    message.onAccept(n);
                                } else {
                                    message.onDecline(n);
                                }
                            }
                        }
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case MILITARY_ACCESS_ASK_DENIED: {
                        if (CFG.core.getMilitaryAccess(n, message.fromCivID) > 0 || civ.messageWasSent(message.fromCivID, MessageType.TRADE_REQUEST)) continue block55;
                        tradeRequest = new TradeRequest_GameData();
                        tradeRequest.iCivLEFT = n;
                        tradeRequest.iCivRIGHT = message.fromCivID;
                        tradeRequest.listRight.militaryAccess = true;
                        tradeRequest.listLEFT.iGold = (int)(Math.min((float)civ.iBudget, (float)CFG.core.getCiv((int)message.fromCivID).iBudget * GameValues.gvAiDiplomacy.MILITARY_ACCESS_DENIED_GOLD_OFFER_BUDGET_MULT) * (GameValues.gvAiDiplomacy.MILITARY_ACCESS_DENIED_GOLD_OFFER_BASE + (float)CFG.oR.nextInt(GameValues.gvAiDiplomacy.MILITARY_ACCESS_DENIED_GOLD_OFFER_RANDOM_1000) / 1000.0f));
                        GameManager.sendTradeRequest(message.fromCivID, n, tradeRequest);
                        continue block55;
                    }
                    case UNION_ACCEPTED: {
                        message.onAccept(n);
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case WAR_DECLARED_ON_ALLY: {
                        if (GameValues.gvAiWar.ALWAYS_JOIN_WAR) {
                            GameManager.DECLINE_CALL_TO_ARMS_REASON = -1;
                            message.onAccept(n);
                            messageBox.removeMessage(i);
                            continue block55;
                        }
                        if (CFG.core.getCiv(n).getGold() < (long)GameValues.gvAiWar.DENY_JOIN_WAR_IF_GOLD_BELOW) {
                            GameManager.DECLINE_CALL_TO_ARMS_REASON = 1;
                            message.onDecline(n);
                            messageBox.removeMessage(i);
                            continue block55;
                        }
                        if (CFG.core.getCiv(n).getCivPlans().isPreparingForTheWar(n)) {
                            GameManager.DECLINE_CALL_TO_ARMS_REASON = 2;
                            message.onDecline(n);
                            messageBox.removeMessage(i);
                            continue block55;
                        }
                        if (GameValues.gvAiWar.DENY_JOIN_WAR_IF_IS_ALREADY_AT_WAR && CFG.core.getCiv(n).isAtWarC()) {
                            GameManager.DECLINE_CALL_TO_ARMS_REASON = 3;
                            message.onDecline(n);
                            messageBox.removeMessage(i);
                            continue block55;
                        }
                        if (CFG.core.getCiv(n).getRelationD(message.fromCivID) < (float)GameValues.gvAiWar.DENY_JOIN_WAR_IF_RELATIONS_BELOW) {
                            GameManager.DECLINE_CALL_TO_ARMS_REASON = 4;
                            message.onDecline(n);
                            messageBox.removeMessage(i);
                            continue block55;
                        }
                        if (GameValues.gvAiWar.DENY_JOIN_WAR_IF_AGAINST_FRIENDLY_CIV && CFG.core.getCiv(n).isFriendlyCiv((int)message.iValue) >= 0) {
                            GameManager.DECLINE_CALL_TO_ARMS_REASON = 5;
                            message.onDecline(n);
                            messageBox.removeMessage(i);
                            continue block55;
                        }
                        if (CFG.core.getCiv(message.fromCivID).getIsPlayer() && CFG.core.getCiv(message.fromCivID).getPuppetOfCiv() == n && !CFG.SPECTATOR_MODE && !CFG.SANDBOX_MODE && (tPlayerID = CFG.core.getPlayerIDbyCivID(message.fromCivID)) >= 0 && tPlayerID < CFG.core.getPlayersSize()) {
                            ++CFG.core.getPlayer((int)tPlayerID).playerGD.WARS_DECLARED_AS_VASSAL_AND_LORD_JOINED_WAR;
                            if (CFG.core.getPlayer((int)tPlayerID).playerGD.WARS_DECLARED_AS_VASSAL_AND_LORD_JOINED_WAR > GameValues.gvAiWar.AI_LORD_MAX_WARS_JOINED_WHEN_PLAYER_IS_VASSAL) {
                                GameManager.DECLINE_CALL_TO_ARMS_REASON = 6;
                                message.onDecline(n);
                                messageBox.removeMessage(i);
                                continue block55;
                            }
                        }
                        GameManager.DECLINE_CALL_TO_ARMS_REASON = -1;
                        message.onAccept(n);
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case TRADE_REQUEST: {
                        if (CFG.SANDBOX_MODE) {
                            message.onAccept(n);
                        } else if (message.tradeRequest.listRight.lDeclareWarOnCivID.size() > 0) {
                            int targetCivID = message.tradeRequest.listRight.lDeclareWarOnCivID.get(0);
                            if (message.tradeRequest.listLEFT.iGold == GameValues.gvTrade.DECLARE_WAR_MAGIC_NUM_ALWAYS_ACCEPT) {
                                message.onAccept(n);
                            } else if (civ.isHatedCiv(message.fromCivID)) {
                                message.onDecline(n);
                            } else if (civ.isFriendlyCiv(targetCivID) >= 0) {
                                message.onDecline(n);
                            } else if ((float)civ.countPop() * GameValues.gvTrade.DECLARE_WAR_CIV_POP_MODIFIER < (float)CFG.core.getCiv(targetCivID).countPop()) {
                                message.onDecline(n);
                            } else if (message.tradeRequest.listLEFT.iGold == GameValues.gvTrade.DECLARE_WAR_MAGIC_NUM_ALWAYS_ACCEPT) {
                                message.onAccept(n);
                            } else if (message.tradeRequest.listRight.iGold > 0) {
                                message.onDecline(n);
                            } else {
                                civIncome = Math.max(CFG.core.getCiv((int)n).incomeTaxation + CFG.core.getCiv((int)n).incomeProduction, CFG.core.getCiv((int)targetCivID).incomeTaxation + CFG.core.getCiv((int)targetCivID).incomeProduction);
                                civIncome += (int)Math.max(1.0f, (float)CFG.core.getCiv(targetCivID).getNumberOfUnits() * GameValues.gvTrade.DECLARE_WAR_CIV_GOLD_PER_ENEMY_UNIT);
                                if (message.tradeRequest.listLEFT.iGold >= (civIncome = (int)((float)civIncome * GameValues.gvTrade.DECLARE_WAR_CIV_INCOME_MULTIPLIER))) {
                                    message.onAccept(n);
                                } else if (!message.tradeRequest.listLEFT.lProvinces.isEmpty()) {
                                    totalGold = message.tradeRequest.listLEFT.iGold;
                                    for (a = 0; a < message.tradeRequest.listLEFT.lProvinces.size(); ++a) {
                                        totalGold = (long)((float)totalGold + Math.max(GameValues.gvTrade.AI_TRADE_PROVINCE_MIN_COST, CFG.core.getProv((int)message.tradeRequest.listLEFT.lProvinces.get((int)a).intValue()).incomeTaxation * GameValues.gvTrade.AI_TRADE_PROVINCE_INCOME_TAXATION_WEIGHT + CFG.core.getProv((int)message.tradeRequest.listLEFT.lProvinces.get((int)a).intValue()).incomeProduction * GameValues.gvTrade.AI_TRADE_PROVINCE_INCOME_PRODUCTION_WEIGHT));
                                    }
                                    if (totalGold >= (long)civIncome) {
                                        message.onAccept(n);
                                    } else {
                                        message.onDecline(n);
                                    }
                                } else {
                                    message.onDecline(n);
                                }
                            }
                        } else if (message.tradeRequest.listRight.lFormCoalitionAgainst.size() > 0 || message.tradeRequest.listLEFT.lFormCoalitionAgainst.size() > 0) {
                            if (civ.isHatedCiv(message.fromCivID)) {
                                message.onDecline(n);
                            } else if (!message.tradeRequest.listRight.lProvinces.isEmpty()) {
                                message.onDecline(n);
                            } else if (message.tradeRequest.listRight.iGold > 0) {
                                message.onDecline(n);
                            } else if (civ.isAtWarC()) {
                                message.onDecline(n);
                            } else if (civ.isHatedCiv(message.tradeRequest.listLEFT.lFormCoalitionAgainst.get(0)) || civ.isHatedCiv(message.tradeRequest.listRight.lFormCoalitionAgainst.get(0))) {
                                if (civ.isFriendlyCiv(message.fromCivID) >= 0) {
                                    message.onAccept(n);
                                } else {
                                    message.onDecline(n);
                                }
                            } else {
                                message.onDecline(n);
                            }
                        } else if (message.tradeRequest.listRight.lProvinces.size() > 0) {
                            if ((float)message.tradeRequest.listRight.lProvinces.size() / (float)civ.getNumOfProvs() > GameValues.gvTrade.AI_TRADE_MAX_PROVINCE_SHARE_TO_ACCEPT) {
                                message.onDecline(n);
                            } else {
                                haveACore = false;
                                for (z = 0; z < message.tradeRequest.listRight.lProvinces.size(); ++z) {
                                    if (!CFG.core.getProv(message.tradeRequest.listRight.lProvinces.get(z)).getCores().getHaveACore(n)) continue;
                                    haveACore = true;
                                    break;
                                }
                                if (!haveACore) {
                                    totalCost = 0;
                                    for (z = 0; z < message.tradeRequest.listRight.lProvinces.size(); ++z) {
                                        totalCost = (int)((float)totalCost + Math.max(GameValues.gvTrade.AI_TRADE_PROVINCE_MIN_COST, CFG.core.getProv((int)message.tradeRequest.listRight.lProvinces.get((int)z).intValue()).incomeTaxation * GameValues.gvTrade.AI_TRADE_PROVINCE_INCOME_TAXATION_WEIGHT + CFG.core.getProv((int)message.tradeRequest.listRight.lProvinces.get((int)z).intValue()).incomeProduction * GameValues.gvTrade.AI_TRADE_PROVINCE_INCOME_PRODUCTION_WEIGHT));
                                    }
                                    if (message.tradeRequest.listLEFT.iGold > (totalCost = (int)Math.ceil((float)totalCost * GameValues.gvTrade.AI_TRADE_PROVINCE_COST_MULTIPLIER))) {
                                        message.onAccept(n);
                                    } else {
                                        message.onDecline(n);
                                    }
                                } else {
                                    message.onDecline(n);
                                }
                            }
                        } else if (!message.tradeRequest.listLEFT.lProvinces.isEmpty() && message.tradeRequest.listRight.iGold > 0) {
                            maxGold = (int)Math.ceil((float)message.tradeRequest.listLEFT.lProvinces.size() * GameValues.gvTrade.AI_TRADE_ACCEPT_PROVINCES_MAX_GOLD_PER_PROVINCE);
                            if (maxGold >= message.tradeRequest.listRight.iGold) {
                                if ((float)(civ.getGold() - (long)message.tradeRequest.listRight.iGold) > GameValues.gvTrade.AI_TRADE_ACCEPT_PROVINCES_ONLY_IF_TREASURY_AFTER_PAYING_IS_OVER) {
                                    message.onAccept(n);
                                } else {
                                    message.onDecline(n);
                                }
                            } else {
                                message.onDecline(n);
                            }
                        } else if (message.tradeRequest.listRight.militaryAccess && !message.tradeRequest.listRight.proclaimIndependence && !message.tradeRequest.listRight.nonAggressionPact && !message.tradeRequest.listRight.defensivePact && message.tradeRequest.listRight.iGold <= 0 && message.tradeRequest.listRight.lProvinces.isEmpty()) {
                            warAgainstFriendlyCiv = false;
                            for (z = 0; z < CFG.core.getCiv((int)message.fromCivID).isAtWarWithCivs.size(); ++z) {
                                if (civ.isFriendlyCiv(CFG.core.getCiv((int)message.fromCivID).isAtWarWithCivs.get(z)) < 0) continue;
                                warAgainstFriendlyCiv = true;
                                break;
                            }
                            if (warAgainstFriendlyCiv) {
                                if (civ.isHatedCiv(message.fromCivID)) {
                                    if ((float)message.tradeRequest.listLEFT.iGold > (float)civ.iBudget * GameValues.gvTrade.AI_TRADE_MILITARY_ACCESS_BUDGET_MULTIPLIER_AT_WAR_WITH_FRIENDLY) {
                                        message.onAccept(n);
                                    } else {
                                        message.onDecline(n);
                                    }
                                }
                            } else if (civ.isHatedCiv(message.fromCivID)) {
                                if ((float)message.tradeRequest.listLEFT.iGold > (float)civ.iBudget * GameValues.gvTrade.AI_TRADE_MILITARY_ACCESS_BUDGET_MULTIPLIER_FROM_HATED_CIV) {
                                    message.onAccept(n);
                                } else {
                                    message.onDecline(n);
                                }
                            } else if (message.tradeRequest.listLEFT.iGold > 0) {
                                if (civ.iBudget > 0) {
                                    if ((float)message.tradeRequest.listLEFT.iGold > (float)civ.iBudget * GameValues.gvTrade.AI_TRADE_MILITARY_ACCESS_BUDGET_MULTIPLIER) {
                                        message.onAccept(n);
                                    } else {
                                        message.onDecline(n);
                                    }
                                } else {
                                    message.onAccept(n);
                                }
                            }
                        } else if (message.tradeRequest.listRight.defensivePact || message.tradeRequest.listLEFT.defensivePact) {
                            if (civ.isHatedCiv(message.fromCivID)) {
                                message.onDecline(n);
                            } else {
                                civIncome = Math.max(CFG.core.getCiv((int)n).incomeTaxation + CFG.core.getCiv((int)n).incomeProduction, CFG.core.getCiv((int)message.tradeRequest.listRight.lDeclareWarOnCivID.get(0)).incomeTaxation + CFG.core.getCiv((int)message.tradeRequest.listRight.lDeclareWarOnCivID.get(0)).incomeProduction);
                                civIncome = (int)((float)Math.max(1, civIncome) * GameValues.gvTrade.AI_TRADE_DEFENSIVE_INCOME_MULTIPLIER);
                                relationModifier = (float)message.tradeRequest.listLEFT.iGold / (float)civIncome;
                                if (message.tradeRequest.listRight.iGold > 0) {
                                    message.onDecline(n);
                                } else if ((float)CFG.oR.nextInt(100) < GameValues.gvTrade.AI_TRADE_DEFENSIVE_RELATION_GOLD_MAX * Math.min(1.0f, relationModifier) + CFG.core.getCivRelationOfCivB(n, message.fromCivID)) {
                                    message.onAccept(n);
                                } else {
                                    message.onDecline(n);
                                }
                            }
                        } else if (message.tradeRequest.listRight.proclaimIndependence || message.tradeRequest.listLEFT.proclaimIndependence) {
                            if (civ.isHatedCiv(message.fromCivID)) {
                                message.onDecline(n);
                            } else if (message.tradeRequest.listRight.proclaimIndependence && CFG.core.getCiv(n).getNumOfProvs() > CFG.core.getCiv(message.fromCivID).getNumOfProvs()) {
                                if (CFG.core.getCiv(message.fromCivID).getPuppetOfCiv() != message.fromCivID) {
                                    message.onDecline(n);
                                } else if (GameManager.getGuaranteeTheirIndependenceSize(message.fromCivID) >= GameValues.gvTrade.PROCLAIM_THEIR_INDEPENDENCE_CIVS_LIMIT) {
                                    message.onDecline(n);
                                } else if (CFG.core.getCiv((int)n).civNeighbors.isNeighbor(message.fromCivID) && CFG.core.getCivRelationOfCivB(n, message.fromCivID) > 0.0f && CFG.core.getCiv(message.fromCivID).getNumOfProvs() < GameValues.gvTrade.PROCLAIM_INDEPENDENCE_MAX_PROVINCES) {
                                    if ((float)CFG.oR.nextInt(100) < CFG.core.getCivRelationOfCivB(n, message.fromCivID) * 2.0f) {
                                        message.onAccept(n);
                                    }
                                } else if ((float)CFG.oR.nextInt(100) < CFG.core.getCivRelationOfCivB(n, message.fromCivID)) {
                                    message.onAccept(n);
                                } else {
                                    message.onDecline(n);
                                }
                            } else if (message.tradeRequest.listLEFT.proclaimIndependence && CFG.core.getCiv(n).getNumOfProvs() < CFG.core.getCiv(message.fromCivID).getNumOfProvs() && CFG.core.getCiv(n).getNumOfProvs() < GameValues.gvTrade.PROCLAIM_INDEPENDENCE_MAX_PROVINCES) {
                                if (CFG.core.getCiv(n).getPuppetOfCiv() != n) {
                                    message.onDecline(n);
                                } else if (CFG.core.getCiv(n).civNeighbors.isNeighbor(message.fromCivID) && CFG.core.getCivRelationOfCivB(n, message.fromCivID) > 0.0f) {
                                    if ((float)CFG.oR.nextInt(100) < CFG.core.getCivRelationOfCivB(n, message.fromCivID) * 2.0f) {
                                        message.onAccept(n);
                                    }
                                } else if ((float)CFG.oR.nextInt(100) < CFG.core.getCivRelationOfCivB(n, message.fromCivID)) {
                                    message.onAccept(n);
                                } else {
                                    message.onDecline(n);
                                }
                            } else if (CFG.core.getCiv(n).getPuppetOfCiv() != n || CFG.core.getCiv(message.fromCivID).getPuppetOfCiv() != message.fromCivID) {
                                message.onDecline(n);
                            } else if ((float)CFG.oR.nextInt(100) < CFG.core.getCivRelationOfCivB(n, message.fromCivID)) {
                                if (message.tradeRequest.listRight.proclaimIndependence) {
                                    if (GameManager.getGuaranteeTheirIndependenceSize(message.fromCivID) >= GameValues.gvTrade.PROCLAIM_THEIR_INDEPENDENCE_CIVS_LIMIT) {
                                        message.onAccept(n);
                                    } else {
                                        message.onDecline(n);
                                    }
                                } else {
                                    message.onAccept(n);
                                }
                            } else {
                                message.onDecline(n);
                            }
                        } else if (message.tradeRequest.listRight.nonAggressionPact || message.tradeRequest.listLEFT.nonAggressionPact) {
                            if (civ.isHatedCiv(message.fromCivID)) {
                                message.onDecline(n);
                            } else if (message.tradeRequest.listRight.iGold > 0) {
                                message.onDecline(n);
                            } else if ((float)CFG.oR.nextInt(100) < CFG.core.getCivRelationOfCivB(n, message.fromCivID)) {
                                message.onAccept(n);
                            } else {
                                message.onDecline(n);
                            }
                        } else if (message.tradeRequest.listRight.militaryAccess || message.tradeRequest.listLEFT.militaryAccess) {
                            if (civ.isHatedCiv(message.fromCivID)) {
                                message.onDecline(n);
                            } else if (message.tradeRequest.listRight.iGold > 0) {
                                message.onDecline(n);
                            } else if ((float)CFG.oR.nextInt(100) < CFG.core.getCivRelationOfCivB(n, message.fromCivID)) {
                                message.onAccept(n);
                            } else {
                                message.onDecline(n);
                            }
                        } else if (message.tradeRequest.listRight.iGold > 0 || message.tradeRequest.listLEFT.iGold > 0) {
                            if (message.tradeRequest.listRight.iGold > message.tradeRequest.listLEFT.iGold) {
                                message.onDecline(n);
                            } else {
                                message.onAccept(n);
                            }
                        } else {
                            message.onAccept(n);
                        }
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case ULTIMATUM_REFUSED: {
                        if ((float)CFG.core.getCiv(message.fromCivID).getNumberOfUnits() < (float)civ.getNumberOfUnits() * GameValues.gvAiDiplomacy.ULTIMATUM_REFUSED_RESPONSE_ARMY_CIV_MODIFIER) {
                            message.onAccept(n);
                        } else {
                            message.onDecline(n);
                        }
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case ULTIMATUM: {
                        if (message.ultimatum.demandAnexation) {
                            try {
                                if (CFG.core.getCiv(message.fromCivID).getIsPlayer()) {
                                    nPlayerID = CFG.core.getPlayerIDbyCivID(message.fromCivID);
                                    if (CFG.core.getPlayer((int)nPlayerID).playerGD.ULTIMATUMS_SENT > GameValues.gvAiDiplomacy.ULTIMATUM_ANNEXATION_MAX_NUM_OF_ULTIMATUMS_SENT_BY_PLAYER) {
                                        message.onDecline(n);
                                        messageBox.removeMessage(i);
                                        continue block55;
                                    }
                                }
                            }
                            catch (Exception var46_57) {
                                CFG.exceptionStack(var46_57);
                            }
                            if ((long)message.ultimatum.numOfUntis < (long)civ.getNumberOfUnits() + Math.max(((long)(civ.incomeTaxation + civ.incomeProduction) + Math.max(0L, civ.getGold())) / (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT, 0L)) {
                                message.onDecline(n);
                                if (CFG.oR.nextInt(1000) < GameValues.gvAiDiplomacy.ULTIMATUM_REFUSE_SANCTIONS_CHANCE_1000) {
                                    GameManager.imposeSanctions(n, message.fromCivID, GameValues.gvSanctions.SANCTIONS_MIN_TURNS + CFG.oR.nextInt(Math.max(1, GameValues.gvSanctions.SANCTIONS_MAX_TURNS - GameValues.gvSanctions.SANCTIONS_MIN_TURNS)));
                                }
                                GameManager.declarationOfIndependenceByVassal(civ.getPuppetOfCiv(), n);
                            } else if (civ.getRelationD(message.fromCivID) > (float)GameValues.gvAiDiplomacy.ULTIMATUM_ANNEXATION_MIN_RELATION_TO_ACCEPT && civ.getRankPos() >= GameValues.gvAiDiplomacy.ULTIMATUM_ANNEXATION_MIN_RANK_TO_ACCEPT && (float)message.ultimatum.numOfUntis * GameValues.gvAiDiplomacy.ULTIMATUM_ANNEXATION_UNITS_FROM_MODIFIER > (float)civ.getNumberOfUnits() * GameValues.gvAiDiplomacy.ULTIMATUM_ANNEXATION_UNITS_TO_MODIFIER + Math.max((float)((long)(civ.incomeTaxation + civ.incomeProduction) + Math.max(0L, civ.getGold())) * GameValues.gvAiDiplomacy.ULTIMATUM_ANNEXATION_GOLD_TO_MODIFIER / (float)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT, 0.0f)) {
                                message.onAccept(n);
                            } else {
                                message.onDecline(n);
                            }
                        } else if (!message.ultimatum.demandProvinces.isEmpty()) {
                            try {
                                if (CFG.core.getCiv(message.fromCivID).getIsPlayer()) {
                                    nPlayerID = CFG.core.getPlayerIDbyCivID(message.fromCivID);
                                    if (CFG.core.getPlayer((int)nPlayerID).playerGD.ULTIMATUMS_SENT > GameValues.gvAiDiplomacy.ULTIMATUM_PROVINCES_MAX_NUM_OF_ULTIMATUMS_SENT_BY_PLAYER) {
                                        message.onDecline(n);
                                        messageBox.removeMessage(i);
                                        continue block55;
                                    }
                                }
                            }
                            catch (Exception var46_58) {
                                CFG.exceptionStack(var46_58);
                            }
                            if ((float)message.ultimatum.demandProvinces.size() >= (float)CFG.core.getCiv(n).getNumOfProvs() * GameValues.gvAiDiplomacy.ULTIMATUM_PROVINCES_REFUSE_DEMAND_VS_NUM_OF_PROVINCES_MODIFIER) {
                                GameManager.decreaseRelation(n, message.fromCivID, GameValues.gvRelationDecrease.SUSPEND_DIPLOMATIC_RELATIONS_MAX);
                                message.onDecline(n);
                            } else if (civ.getRelationD(message.fromCivID) > (float)GameValues.gvAiDiplomacy.ULTIMATUM_PROVINCES_MIN_RELATION_TO_ACCEPT && civ.getRankPos() >= GameValues.gvAiDiplomacy.ULTIMATUM_PROVINCES_MIN_RANK_TO_ACCEPT && (float)message.ultimatum.numOfUntis * GameValues.gvAiDiplomacy.ULTIMATUM_PROVINCES_UNITS_FROM_MODIFIER > (float)civ.getNumberOfUnits() * GameValues.gvAiDiplomacy.ULTIMATUM_PROVINCES_UNITS_TO_MODIFIER + Math.max((float)((long)(civ.incomeTaxation + civ.incomeProduction) + Math.max(0L, civ.getGold())) * GameValues.gvAiDiplomacy.ULTIMATUM_PROVINCES_GOLD_TO_MODIFIER / (float)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT, 0.0f)) {
                                GameManager.decreaseRelation(n, message.fromCivID, GameValues.gvRelationDecrease.SUSPEND_DIPLOMATIC_RELATIONS_MAX);
                                message.onAccept(n);
                            } else {
                                message.onDecline(n);
                                if (CFG.oR.nextInt(1000) < GameValues.gvAiDiplomacy.ULTIMATUM_REFUSE_SANCTIONS_CHANCE_1000) {
                                    GameManager.imposeSanctions(n, message.fromCivID, GameValues.gvSanctions.SANCTIONS_MIN_TURNS + CFG.oR.nextInt(Math.max(1, GameValues.gvSanctions.SANCTIONS_MAX_TURNS - GameValues.gvSanctions.SANCTIONS_MIN_TURNS)));
                                }
                                totalBudget = CFG.core.getCiv((int)message.fromCivID).iBudget;
                                if (CFG.core.getCiv(message.fromCivID).getAlliance() > 0) {
                                    for (a = 0; a < CFG.core.getAlliance(CFG.core.getCiv(message.fromCivID).getAlliance()).getCivilizationsSize(); ++a) {
                                        if (CFG.core.getAlliance(CFG.core.getCiv(message.fromCivID).getAlliance()).getCivilization(a) == message.fromCivID) continue;
                                        totalBudget += CFG.core.getCiv((int)CFG.core.getAlliance((int)CFG.core.getCiv((int)message.fromCivID).getAlliance()).getCivilization((int)a)).iBudget;
                                    }
                                }
                                if (CFG.core.getCiv((int)message.fromCivID).civGD.iVassalsSize > 0) {
                                    for (a = 0; a < CFG.core.getCiv((int)message.fromCivID).civGD.iVassalsSize; ++a) {
                                        totalBudget += CFG.core.getCiv((int)CFG.core.getCiv((int)message.fromCivID).civGD.vassals.get((int)a).iCivID).iBudget;
                                    }
                                }
                                if (CFG.core.getCiv(message.fromCivID).getCivId() != CFG.core.getCiv(message.fromCivID).getPuppetOfCiv()) {
                                    totalBudget += CFG.core.getCiv((int)CFG.core.getCiv((int)message.fromCivID).getPuppetOfCiv()).iBudget;
                                }
                                if ((float)((long)(civ.incomeTaxation + civ.incomeProduction) + Math.max(0L, civ.getGold())) * GameValues.gvAiDiplomacy.ULTIMATUM_PROVINCES_REFUSE_DECLARE_WAR_BUDGET_MODIFIER > (float)totalBudget) {
                                    CFG.core.declareWar(n, message.fromCivID, false);
                                }
                            }
                        } else if (message.ultimatum.demandVasalization) {
                            if (civ.getRelationD(message.fromCivID) > (float)GameValues.gvAiDiplomacy.ULTIMATUM_VASSALIZATION_MIN_RELATION_TO_ACCEPT && civ.getRankPos() >= GameValues.gvAiDiplomacy.ULTIMATUM_VASSALIZATION_MIN_RANK_TO_ACCEPT && (float)message.ultimatum.numOfUntis * GameValues.gvAiDiplomacy.ULTIMATUM_VASSALIZATION_UNITS_FROM_MODIFIER > (float)civ.getNumberOfUnits() * GameValues.gvAiDiplomacy.ULTIMATUM_VASSALIZATION_UNITS_TO_MODIFIER + Math.max((float)((long)(civ.incomeTaxation + civ.incomeProduction) + Math.max(0L, civ.getGold())) * GameValues.gvAiDiplomacy.ULTIMATUM_VASSALIZATION_GOLD_TO_MODIFIER / (float)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT, 0.0f)) {
                                message.onAccept(n);
                            } else {
                                message.onDecline(n);
                                if (CFG.oR.nextInt(1000) < GameValues.gvAiDiplomacy.ULTIMATUM_REFUSE_SANCTIONS_CHANCE_1000) {
                                    GameManager.imposeSanctions(n, message.fromCivID, GameValues.gvSanctions.SANCTIONS_MIN_TURNS + CFG.oR.nextInt(Math.max(1, GameValues.gvSanctions.SANCTIONS_MAX_TURNS - GameValues.gvSanctions.SANCTIONS_MIN_TURNS)));
                                }
                                totalBudget = CFG.core.getCiv((int)message.fromCivID).iBudget;
                                if (CFG.core.getCiv(message.fromCivID).getAlliance() > 0) {
                                    for (a = 0; a < CFG.core.getAlliance(CFG.core.getCiv(message.fromCivID).getAlliance()).getCivilizationsSize(); ++a) {
                                        if (CFG.core.getAlliance(CFG.core.getCiv(message.fromCivID).getAlliance()).getCivilization(a) == message.fromCivID) continue;
                                        totalBudget += CFG.core.getCiv((int)CFG.core.getAlliance((int)CFG.core.getCiv((int)message.fromCivID).getAlliance()).getCivilization((int)a)).iBudget;
                                    }
                                }
                                if (CFG.core.getCiv((int)message.fromCivID).civGD.iVassalsSize > 0) {
                                    for (a = 0; a < CFG.core.getCiv((int)message.fromCivID).civGD.iVassalsSize; ++a) {
                                        totalBudget += CFG.core.getCiv((int)CFG.core.getCiv((int)message.fromCivID).civGD.vassals.get((int)a).iCivID).iBudget;
                                    }
                                }
                                if (CFG.core.getCiv(message.fromCivID).getCivId() != CFG.core.getCiv(message.fromCivID).getPuppetOfCiv()) {
                                    totalBudget += CFG.core.getCiv((int)CFG.core.getCiv((int)message.fromCivID).getPuppetOfCiv()).iBudget;
                                }
                                if ((float)((long)(civ.incomeTaxation + civ.incomeProduction) + Math.max(0L, civ.getGold())) * GameValues.gvAiDiplomacy.ULTIMATUM_VASSALIZATION_REFUSE_DECLARE_WAR_BUDGET_MODIFIER > (float)totalBudget) {
                                    CFG.core.declareWar(n, message.fromCivID, false);
                                }
                            }
                        } else if (message.ultimatum.demandChangeOfGovernment) {
                            if ((float)message.ultimatum.numOfUntis * GameValues.gvAiDiplomacy.ULTIMATUM_CHANGE_GOV_UNITS_FROM_MODIFIER > (float)civ.getNumberOfUnits() * GameValues.gvAiDiplomacy.ULTIMATUM_CHANGE_GOV_UNITS_TO_MODIFIER + Math.max((float)((long)(civ.incomeTaxation + civ.incomeProduction) + Math.max(0L, civ.getGold())) * GameValues.gvAiDiplomacy.ULTIMATUM_CHANGE_GOV_GOLD_TO_MODIFIER / (float)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT, 0.0f)) {
                                GameManager.decreaseRelation(n, message.fromCivID, GameValues.gvRelationDecrease.SUSPEND_DIPLOMATIC_RELATIONS_MIN);
                                message.onAccept(n);
                            } else {
                                message.onDecline(n);
                                if (CFG.oR.nextInt(1000) < GameValues.gvAiDiplomacy.ULTIMATUM_REFUSE_SANCTIONS_CHANCE_1000) {
                                    GameManager.imposeSanctions(n, message.fromCivID, GameValues.gvSanctions.SANCTIONS_MIN_TURNS + CFG.oR.nextInt(Math.max(1, GameValues.gvSanctions.SANCTIONS_MAX_TURNS - GameValues.gvSanctions.SANCTIONS_MIN_TURNS)));
                                }
                            }
                        } else if (message.ultimatum.demandMilitaryAccess) {
                            if ((float)message.ultimatum.numOfUntis * GameValues.gvAiDiplomacy.ULTIMATUM_MILITARY_ACCESS_UNITS_FROM_MODIFIER > (float)civ.getNumberOfUnits() * GameValues.gvAiDiplomacy.ULTIMATUM_MILITARY_ACCESS_UNITS_TO_MODIFIER + Math.max((float)((long)(civ.incomeTaxation + civ.incomeProduction) + Math.max(0L, civ.getGold())) * GameValues.gvAiDiplomacy.ULTIMATUM_MILITARY_ACCESS_GOLD_TO_MODIFIER / (float)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT, 0.0f)) {
                                GameManager.decreaseRelation(n, message.fromCivID, GameValues.gvRelationDecrease.SUSPEND_DIPLOMATIC_RELATIONS_MIN);
                                message.onAccept(n);
                            } else {
                                message.onDecline(n);
                            }
                        } else if (message.ultimatum.demandLiberation.size() > 0) {
                            if ((float)message.ultimatum.numOfUntis * GameValues.gvAiDiplomacy.ULTIMATUM_LIBERATION_UNITS_FROM_MODIFIER / (float)message.ultimatum.demandLiberation.size() > (float)civ.getNumberOfUnits() * GameValues.gvAiDiplomacy.ULTIMATUM_LIBERATION_UNITS_TO_MODIFIER + Math.max((float)((long)(civ.incomeTaxation + civ.incomeProduction) + Math.max(0L, civ.getGold())) * GameValues.gvAiDiplomacy.ULTIMATUM_LIBERATION_GOLD_TO_MODIFIER / (float)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT, 0.0f)) {
                                message.onAccept(n);
                            } else {
                                message.onDecline(n);
                            }
                        } else {
                            message.onAccept(n);
                        }
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case UNION: {
                        if (CFG.core.getCiv(message.fromCivID).getCivDiploGD().getIsEmbassyClosed(n)) {
                            message.onDecline(n);
                        } else if (civ.civGD.civPlans.isPreparingForTheWar(message.fromCivID)) {
                            message.onDecline(n);
                        } else if (civ.iLeague < GameValues.gvAiDiplomacy.UNION_MIN_LEAGUE && CFG.core.getCiv((int)message.fromCivID).iLeague < GameValues.gvAiDiplomacy.UNION_MIN_LEAGUE) {
                            message.onDecline(n);
                        } else if (CFG.core.isAlly(message.fromCivID, n)) {
                            if (CFG.core.getCiv((int)message.fromCivID).civGD.numOfUnions == 0 && civ.civGD.numOfUnions == 0) {
                                sameRivals = false;
                                for (a = 0; a < civ.getHatedCivsSize(); ++a) {
                                    for (b = 0; b < CFG.core.getCiv(message.fromCivID).getHatedCivsSize(); ++b) {
                                        if (!CFG.core.getCiv(message.fromCivID).isHatedCiv(civ.getHatedCiv((int)a).iCivID)) continue;
                                        sameRivals = true;
                                        break;
                                    }
                                    if (var37_37) break;
                                }
                                if (sameRivals) {
                                    message.onAccept(n);
                                } else if (CFG.core.getCiv(n).getRelationD(message.fromCivID) > (float)GameValues.gvAiDiplomacy.UNION_ALLY_MIN_RELATION && (float)CFG.core.getCiv(message.fromCivID).getNumOfProvs() >= (float)CFG.core.getCiv(n).getNumOfProvs() * GameValues.gvAiDiplomacy.UNION_ALLY_NUM_OF_PROVINCES_MODIFIER) {
                                    message.onAccept(n);
                                } else {
                                    message.onDecline(n);
                                }
                            } else if (civ.getNumOfProvs() <= GameValues.gvAiDiplomacy.UNION_SECOND_UNION_MAX_PROVINCES) {
                                if (CFG.core.getCiv((int)message.fromCivID).civGD.numOfUnions < GameValues.gvAiDiplomacy.UNION_MAX_NUM_OF_UNIONS && civ.civGD.numOfUnions < GameValues.gvAiDiplomacy.UNION_MAX_NUM_OF_UNIONS) {
                                    if (CFG.core.getCiv(n).getRelationD(message.fromCivID) > (float)GameValues.gvAiDiplomacy.UNION_ALLY_MIN_RELATION && (float)CFG.core.getCiv(message.fromCivID).getNumOfProvs() >= (float)CFG.core.getCiv(n).getNumOfProvs() * GameValues.gvAiDiplomacy.UNION_ALLY_NUM_OF_PROVINCES_MODIFIER) {
                                        message.onAccept(n);
                                    } else {
                                        message.onDecline(n);
                                    }
                                } else {
                                    message.onDecline(n);
                                }
                            } else {
                                message.onDecline(n);
                            }
                        } else if (CFG.core.getCiv(n).getRelationD(message.fromCivID) > (float)GameValues.gvAiDiplomacy.UNION_MIN_RELATION && (float)CFG.core.getCiv(message.fromCivID).getNumOfProvs() >= (float)CFG.core.getCiv(n).getNumOfProvs() * GameValues.gvAiDiplomacy.UNION_NUM_OF_PROVINCES_MODIFIER) {
                            message.onAccept(n);
                        } else {
                            message.onDecline(n);
                        }
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case OFFERVASALIZATION: {
                        if (CFG.core.getCiv(message.fromCivID).getCivDiploGD().getIsEmbassyClosed(n)) {
                            message.onDecline(n);
                        } else if (CFG.core.getCiv(message.fromCivID).getPuppetOfCiv() == n) {
                            message.onDecline(n);
                        } else if ((float)civ.iBudget * (GameValues.gvAiDiplomacy.OFFER_VASSALIZATION_BUDGET_RATIO_TO_ACCEPT + (float)CFG.core.getCiv((int)message.fromCivID).civGD.iVassalsSize * GameValues.gvAiDiplomacy.OFFER_VASSALIZATION_BUDGET_RATIO_TO_ACCEPT_EXTRA_PER_VASSAL) < (float)CFG.core.getCiv((int)message.fromCivID).iBudget && !civ.isHatedCiv(message.fromCivID) && civ.getRelationD(message.fromCivID) >= GameValues.gvAiDiplomacy.OFFER_VASSALIZATION_MIN_RELATION) {
                            message.onAccept(n);
                        } else {
                            CFG.core.getCiv(message.fromCivID).setRelationD(n, CFG.core.getCiv(message.fromCivID).getRelationD(n) + (float)GameValues.gvDiplomacy.OFFER_VASSALIZATION_REJECT_RELATION_CHANGE);
                            CFG.core.getCiv(n).setRelationD(message.fromCivID, CFG.core.getCiv(n).getRelationD(message.fromCivID) + (float)GameValues.gvDiplomacy.OFFER_VASSALIZATION_REJECT_RELATION_CHANGE);
                            message.onDecline(n);
                        }
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case VASSALIZATION_ACCEPTED: {
                        message.onAccept(n);
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case LOAN_REQUEST: {
                        if (CFG.core.getCivsAtWar(n, message.fromCivID)) {
                            message.onDecline(n);
                        } else if (CFG.core.getCiv(message.fromCivID).getLoansFromCivSize() >= GameValues.gvLoan.REQUEST_LOAN_MAX_NUM_OF_LOANS) {
                            message.onDecline(n);
                        } else if (civ.getCivPlans().isPreparingForTheWar(message.fromCivID)) {
                            message.onDecline(n);
                        } else if (civ.isRival(message.fromCivID)) {
                            message.onDecline(n);
                        } else if ((float)civ.getGold() >= (float)message.iValue * GameValues.gvLoan.AI_RESPONSE_REQUEST_LOAN_ACCEPT_MIN_TREASURY_RATIO) {
                            message.onAccept(n);
                        } else if (civ.getGold() < 0L) {
                            message.onDecline(n);
                        } else {
                            message.iValue = (int)((float)message.iValue * (GameValues.gvLoan.AI_RESPONSE_REQUEST_LOAN_GOLD_MODIFIER_BASE + (float)CFG.oR.nextInt(GameValues.gvLoan.AI_RESPONSE_REQUEST_LOAN_GOLD_MODIFIER_RANDOM_100) / 100.0f));
                            message.onAccept(n);
                        }
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case INVEST_IS_OVER_DEVELOPMENT: {
                        CFG.core.getCiv(n).setSpendingInvestmentsB(Math.max(2.0f, CFG.core.getCiv(n).getSpendingInvestmentsB()));
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case DECLARATION_OF_INDEPENDENCE: {
                        if ((float)civ.iBudget > (float)CFG.core.getCiv((int)message.fromCivID).iBudget * GameValues.gvAiDiplomacy.DECLARATION_OF_INDEPENDENCE_BUDGET_MODIFIER) {
                            message.onAccept(n);
                        } else {
                            message.onDecline(n);
                        }
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case WAR: {
                        if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)message.fromCivID).getIdeology()).REVOLUTIONARY) {
                            messageBox.removeMessage(i);
                            continue block55;
                        }
                        callToArms = GameManager.callToArmsListOfCivs(n, message.fromCivID);
                        for (j = 0; j < callToArms.size(); ++j) {
                            GameManager.sendCallToArms(callToArms.get(j), n, message.fromCivID);
                        }
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case DECLARATION_OF_INDEPENDENCE_BYVASSAl: {
                        if ((float)civ.iBudget > (float)CFG.core.getCiv((int)message.fromCivID).iBudget * GameValues.gvAiDiplomacy.DECLARATION_OF_INDEPENDENCE_BY_VASSAL_BUDGET_MODIFIER) {
                            message.onAccept(n);
                        } else {
                            message.onDecline(n);
                        }
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case TECHNOLOGY_POINTS: {
                        this.useTechnologyPoints(n);
                        messageBox.removeMessage(i);
                        continue block55;
                    }
                    case BUDGET: {
                        messageBox.removeMessage(i);
                    }
                }
            }
        }
        catch (Exception var2_3) {
            CFG.exceptionStack(var2_3);
        }
    }

    public final void updateSentMessages(int n) {
        try {
            block5: for (int i = CFG.core.getCiv(n).getSentMessagesSize() - 1; i >= 0; --i) {
                switch (CFG.core.getCiv((int)n).getSentMessage((int)i).messageType) {
                    case TRADE_REQUEST: {
                        if (GameCalendar.TURNID - CFG.core.getCiv((int)n).getSentMessage((int)i).iSentInTurnID <= GameValues.gvAiDiplomacy.REMOVE_MESSAGES_TURNS) continue block5;
                        CFG.core.getCiv(n).removeSentMessage(i);
                        continue block5;
                    }
                }
            }
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
    }

    public final int getPrepareForWar_TurnsLeft(int n, int n2) {
        for (int i = 0; i < CFG.core.getCiv((int)n).civGD.civPlans.iWarPrepsSize; ++i) {
            if (CFG.core.getCiv((int)n).civGD.civPlans.warPreps.get((int)i).onCivID != n2) continue;
            return CFG.core.getCiv((int)n).civGD.civPlans.warPreps.get((int)i).iNumOfTurnsLeft;
        }
        return -1;
    }

    public final int getPrepareForWar_TurnsLeft_BasedOnNeighboors(int n, int n2) {
        int n3 = 8;
        for (int i = 0; i < CFG.core.getProv(n2).getNeighProvincesSize(); ++i) {
            if (CFG.core.getProv(CFG.core.getProv(n2).getNeighProvinces(i)).getCivId() <= 0 || CFG.core.getProv(CFG.core.getProv(n2).getNeighProvinces(i)).getCivId() == n) continue;
            for (int j = 0; j < CFG.core.getCiv((int)n).civGD.civPlans.iWarPrepsSize; ++j) {
                if (CFG.core.getCiv((int)n).civGD.civPlans.warPreps.get((int)j).onCivID != CFG.core.getProv(CFG.core.getProv(n2).getNeighProvinces(i)).getCivId()) continue;
                n3 = Math.max(CFG.core.getCiv((int)n).civGD.civPlans.warPreps.get((int)j).iNumOfTurnsLeft, n3);
            }
        }
        return n3;
    }

    public final void prepareForWar_MoveReadyArmies(int n) {
        for (int i = CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.size() - 1; i >= 0; --i) {
            int n2;
            if (CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.get((int)i).MISSION_TYPE != CivArmyMission_Type.PREAPARE_FOR_WAR) continue;
            int n3 = n2 = CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.get((int)i).MISSION_ID < 0 ? 0 : this.getPrepareForWar_TurnsLeft(n, CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.get((int)i).MISSION_ID);
            if (n2 < 0) {
                CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.remove(i);
                continue;
            }
            if (!CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.get(i).canMakeAction(n, n2) || !CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.get(i).action(n)) continue;
            CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.remove(i);
        }
    }

    public final void prepareForWar2(int n) {
        try {
            block38: {
                block40: {
                    ArrayList<AI_ProvinceInfo_War> sortedFrontProvinces = null;
                    ArrayList<Integer> lFrontIDsWithArmies = null;
                    int n12, n11, n10, n9, n8, n7, n6, n5, n4, n3, n2, i;
                    ArrayList<AI_ProvinceInfo_War> arrayList = null;
                    ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
                    boolean bl2;
                    block39: {
                        boolean canRecruitAndMove;
                        if (CFG.core.getCiv((int)n).civGD.civPlans.iWarPrepsSize == 0) {
                            return;
                        }
                        boolean bl3 = false;
                        ArrayList<AI_ProvinceInfo_War> arrayList3 = new ArrayList<AI_ProvinceInfo_War>();
                        ArrayList arrayList4 = new ArrayList();
                        for (n12 = CFG.core.getCiv((int)n).lFrontLines.size() - 1; n12 >= 0; --n12) {
                            for (n11 = 0; n11 < CFG.core.getCiv((int)n).civGD.civPlans.iWarPrepsSize; ++n11) {
                                if (CFG.core.getCiv((int)n).lFrontLines.get((int)n12).iWithCivID != CFG.core.getCiv((int)n).civGD.civPlans.warPreps.get((int)n11).onCivID) continue;
                                bl3 = true;
                                for (n10 = CFG.core.getCiv((int)n).lFrontLines.get((int)n12).lProvinces.size() - 1; n10 >= 0; --n10) {
                                    bl2 = true;
                                    for (n9 = arrayList3.size() - 1; n9 >= 0; --n9) {
                                        if (((AI_ProvinceInfo_War)arrayList3.get((int)n9)).iProvinceID != CFG.core.getCiv((int)n).lFrontLines.get((int)n12).lProvinces.get(n10)) continue;
                                        bl2 = false;
                                        break;
                                    }
                                    if (!bl2) continue;
                                    arrayList3.add(new AI_ProvinceInfo_War(CFG.core.getCiv((int)n).lFrontLines.get((int)n12).lProvinces.get(n10), this.getPotential_BasedOnNeighboringProvs(CFG.core.getCiv((int)n).lFrontLines.get((int)n12).lProvinces.get(n10), n), true));
                                }
                            }
                        }
                        for (n8 = 0; n8 < CFG.core.getCiv((int)n).civGD.iVassalsSize; ++n8) {
                            for (n7 = CFG.core.getCiv((int)CFG.core.getCiv((int)n).civGD.vassals.get((int)n8).iCivID).lFrontLines.size() - 1; n7 >= 0; --n7) {
                                for (n6 = 0; n6 < CFG.core.getCiv((int)n).civGD.civPlans.iWarPrepsSize; ++n6) {
                                    if (CFG.core.getCiv((int)CFG.core.getCiv((int)n).civGD.vassals.get((int)n8).iCivID).lFrontLines.get((int)n7).iWithCivID != CFG.core.getCiv((int)n).civGD.civPlans.warPreps.get((int)n6).onCivID) continue;
                                    for (n5 = CFG.core.getCiv((int)CFG.core.getCiv((int)n).civGD.vassals.get((int)n8).iCivID).lFrontLines.get((int)n7).lProvinces.size() - 1; n5 >= 0; --n5) {
                                        boolean bl = true;
                                        for (n4 = arrayList3.size() - 1; n4 >= 0; --n4) {
                                            if (((AI_ProvinceInfo_War)arrayList3.get((int)n4)).iProvinceID != CFG.core.getCiv((int)CFG.core.getCiv((int)n).civGD.vassals.get((int)n8).iCivID).lFrontLines.get((int)n7).lProvinces.get(n5)) continue;
                                            bl = false;
                                            break;
                                        }
                                        if (!bl) continue;
                                        arrayList3.add(new AI_ProvinceInfo_War(CFG.core.getCiv((int)CFG.core.getCiv((int)n).civGD.vassals.get((int)n8).iCivID).lFrontLines.get((int)n7).lProvinces.get(n5), this.getPotential_BasedOnNeighboringProvs(CFG.core.getCiv((int)CFG.core.getCiv((int)n).civGD.vassals.get((int)n8).iCivID).lFrontLines.get((int)n7).lProvinces.get(n5), CFG.core.getCiv((int)n).civGD.vassals.get((int)n8).iCivID), false));
                                    }
                                }
                            }
                        }
                        if (CFG.core.getCiv(n).getPuppetOfCiv() != n) {
                            for (n12 = CFG.core.getCiv((int)CFG.core.getCiv((int)n).getPuppetOfCiv()).lFrontLines.size() - 1; n12 >= 0; --n12) {
                                for (n11 = 0; n11 < CFG.core.getCiv((int)n).civGD.civPlans.iWarPrepsSize; ++n11) {
                                    if (CFG.core.getCiv((int)CFG.core.getCiv((int)n).getPuppetOfCiv()).lFrontLines.get((int)n12).iWithCivID != CFG.core.getCiv((int)n).civGD.civPlans.warPreps.get((int)n11).onCivID) continue;
                                    for (n10 = CFG.core.getCiv((int)CFG.core.getCiv((int)n).getPuppetOfCiv()).lFrontLines.get((int)n12).lProvinces.size() - 1; n10 >= 0; --n10) {
                                        bl2 = true;
                                        for (n9 = arrayList3.size() - 1; n9 >= 0; --n9) {
                                            if (((AI_ProvinceInfo_War)arrayList3.get((int)n9)).iProvinceID != CFG.core.getCiv((int)CFG.core.getCiv((int)n).getPuppetOfCiv()).lFrontLines.get((int)n12).lProvinces.get(n10)) continue;
                                            bl2 = false;
                                            break;
                                        }
                                        if (!bl2) continue;
                                        arrayList3.add(new AI_ProvinceInfo_War(CFG.core.getCiv((int)CFG.core.getCiv((int)n).getPuppetOfCiv()).lFrontLines.get((int)n12).lProvinces.get(n10), this.getPotential_BasedOnNeighboringProvs(CFG.core.getCiv((int)CFG.core.getCiv((int)n).getPuppetOfCiv()).lFrontLines.get((int)n12).lProvinces.get(n10), CFG.core.getCiv(n).getPuppetOfCiv()), false));
                                    }
                                }
                            }
                        }
                        if (CFG.core.getCiv(n).getAlliance() > 0) {
                            for (n8 = 0; n8 < CFG.core.getAlliance(CFG.core.getCiv(n).getAlliance()).getCivilizationsSize(); ++n8) {
                                if (CFG.core.getAlliance(CFG.core.getCiv(n).getAlliance()).getCivilization(n8) == n) continue;
                                for (n7 = CFG.core.getCiv((int)CFG.core.getAlliance((int)CFG.core.getCiv((int)n).getAlliance()).getCivilization((int)n8)).lFrontLines.size() - 1; n7 >= 0; --n7) {
                                    for (n6 = 0; n6 < CFG.core.getCiv((int)n).civGD.civPlans.iWarPrepsSize; ++n6) {
                                        if (CFG.core.getCiv((int)CFG.core.getAlliance((int)CFG.core.getCiv((int)n).getAlliance()).getCivilization((int)n8)).lFrontLines.get((int)n7).iWithCivID != CFG.core.getCiv((int)n).civGD.civPlans.warPreps.get((int)n6).onCivID) continue;
                                        for (n5 = CFG.core.getCiv((int)CFG.core.getAlliance((int)CFG.core.getCiv((int)n).getAlliance()).getCivilization((int)n8)).lFrontLines.get((int)n7).lProvinces.size() - 1; n5 >= 0; --n5) {
                                            boolean bl = true;
                                            for (n4 = arrayList3.size() - 1; n4 >= 0; --n4) {
                                                if (((AI_ProvinceInfo_War)arrayList3.get((int)n4)).iProvinceID != CFG.core.getCiv((int)CFG.core.getAlliance((int)CFG.core.getCiv((int)n).getAlliance()).getCivilization((int)n8)).lFrontLines.get((int)n7).lProvinces.get(n5)) continue;
                                                bl = false;
                                                break;
                                            }
                                            if (!bl) continue;
                                            arrayList3.add(new AI_ProvinceInfo_War(CFG.core.getCiv((int)CFG.core.getAlliance((int)CFG.core.getCiv((int)n).getAlliance()).getCivilization((int)n8)).lFrontLines.get((int)n7).lProvinces.get(n5), this.getPotential_BasedOnNeighboringProvs(CFG.core.getCiv((int)CFG.core.getAlliance((int)CFG.core.getCiv((int)n).getAlliance()).getCivilization((int)n8)).lFrontLines.get((int)n7).lProvinces.get(n5), CFG.core.getAlliance(CFG.core.getCiv(n).getAlliance()).getCivilization(n8)), false));
                                        }
                                    }
                                }
                            }
                        }
                        if (arrayList3.isEmpty()) break block38;
                        int tMaxDL = 1;
                        float tMaxPotential = 1.0f;
                        ArrayList<Integer> tMovingArmy_toFrontProvince = new ArrayList<Integer>();
                        long tMaxArmy = 1L;
                        float tMaxRegion_NumOfProvinces = 1.0f;
                        float tMaxRegion_Potential = 1.0f;
                        lFrontIDsWithArmies = new ArrayList<Integer>();
                        int tempMovingArmy = 0;
                        for (n3 = arrayList3.size() - 1; n3 >= 0; --n3) {
                            if (((AI_ProvinceInfo_War)arrayList3.get((int)n3)).iValue > tMaxPotential) {
                                tMaxPotential = ((AI_ProvinceInfo_War)arrayList3.get((int)n3)).iValue;
                            }
                            if (CFG.core.getProv(((AI_ProvinceInfo_War)arrayList3.get((int)n3)).iProvinceID).getDangerLevel_WithArmy() > tMaxDL) {
                                tMaxDL = CFG.core.getProv(((AI_ProvinceInfo_War)arrayList3.get((int)n3)).iProvinceID).getDangerLevel_WithArmy();
                            }
                            if ((float)CFG.core.getProv(((AI_ProvinceInfo_War)arrayList3.get((int)n3)).iProvinceID).getRegion_NumOfProvinces() > tMaxRegion_NumOfProvinces) {
                                tMaxRegion_NumOfProvinces = CFG.core.getProv(((AI_ProvinceInfo_War)arrayList3.get((int)n3)).iProvinceID).getRegion_NumOfProvinces();
                            }
                            if ((float)CFG.core.getProv(((AI_ProvinceInfo_War)arrayList3.get((int)n3)).iProvinceID).getPotentialRegion() > tMaxRegion_Potential) {
                                tMaxRegion_Potential = CFG.core.getProv(((AI_ProvinceInfo_War)arrayList3.get((int)n3)).iProvinceID).getPotentialRegion();
                            }
                            tMovingArmy_toFrontProvince.add(tempMovingArmy += (int)this.getMovingArmyToProvinceID(n, ((AI_ProvinceInfo_War)arrayList3.get((int)n3)).iProvinceID));
                            if (CFG.core.getProvinceArmy(((AI_ProvinceInfo_War)arrayList3.get((int)n3)).iProvinceID) + (long)tempMovingArmy <= tMaxArmy) continue;
                            tMaxArmy = CFG.core.getProvinceArmy(((AI_ProvinceInfo_War)arrayList3.get((int)n3)).iProvinceID) + (long)tempMovingArmy;
                        }
                        for (n3 = arrayList3.size() - 1; n3 >= 0; --n3) {
                            ((AI_ProvinceInfo_War)arrayList3.get((int)n3)).iValue = CFG.core.getCiv((int)n).civGD.civPers.WAR_POTENTIAL * (((AI_ProvinceInfo_War)arrayList3.get((int)n3)).iValue / tMaxPotential) + CFG.core.getCiv((int)n).civGD.civPers.WAR_DANGER * ((float)CFG.core.getProv(((AI_ProvinceInfo_War)arrayList3.get((int)n3)).iProvinceID).getDangerLevel_WithArmy() / (float)tMaxDL) + (1.0f - CFG.core.getCiv((int)n).civGD.civPers.WAR_NUM_OF_UNITS + CFG.core.getCiv((int)n).civGD.civPers.WAR_NUM_OF_UNITS * (1.0f - (float)(CFG.core.getProvinceArmy(((AI_ProvinceInfo_War)arrayList3.get((int)n3)).iProvinceID) + (long)((Integer)tMovingArmy_toFrontProvince.get(n3))) / (float)tMaxArmy)) + (1.0f - CFG.core.getCiv((int)n).civGD.civPers.WAR_REGION_NUM_OF_PROVINCES + CFG.core.getCiv((int)n).civGD.civPers.WAR_REGION_NUM_OF_PROVINCES * (float)CFG.core.getProv(((AI_ProvinceInfo_War)arrayList3.get((int)n3)).iProvinceID).getRegion_NumOfProvinces() / tMaxRegion_NumOfProvinces - CFG.core.getCiv((int)n).civGD.civPers.WAR_REGION_POTENTIAL + CFG.core.getCiv((int)n).civGD.civPers.WAR_REGION_POTENTIAL * (float)CFG.core.getProv(((AI_ProvinceInfo_War)arrayList3.get((int)n3)).iProvinceID).getPotentialRegion() / tMaxRegion_Potential);
                        }
                        arrayList = new ArrayList<AI_ProvinceInfo_War>();
                        int n16 = 0;
                        while (!arrayList3.isEmpty()) {
                            n2 = 0;
                            int n17 = arrayList3.size();
                            for (i = 1; i < n17; ++i) {
                                if (((AI_ProvinceInfo_War)arrayList3.get((int)n2)).iValue < ((AI_ProvinceInfo_War)arrayList3.get((int)i)).iValue) {
                                    n2 = i;
                                    continue;
                                }
                                if (((AI_ProvinceInfo_War)arrayList3.get((int)n2)).iValue != ((AI_ProvinceInfo_War)arrayList3.get((int)i)).iValue || CFG.oR.nextInt(100) >= 50) continue;
                                n2 = i;
                            }
                            if (CFG.core.getProv(((AI_ProvinceInfo_War)arrayList3.get((int)n2)).iProvinceID).getArmyCivID1(n) > 0) {
                                arrayList2.add(n16);
                            }
                            arrayList.add((AI_ProvinceInfo_War)arrayList3.get(n2));
                            arrayList3.remove(n2);
                            ++n16;
                        }
                        this.prepareForWar_Regroup(n, sortedFrontProvinces, lFrontIDsWithArmies);
                        if (CFG.core.getCiv(n).getGold() <= (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT) break block38;
                        boolean bl = canRecruitAndMove = (float)lFrontIDsWithArmies.size() * 1.75f * (float)CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE <= (float)(CFG.core.getCiv(n).getMovemPoints() - CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_RECRUIT);
                        if (canRecruitAndMove) break block39;
                        float f = CFG.core.getCiv(n).getGold() / (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT;
                        float f2 = CFG.core.getCiv((int)n).civGD.moveAtWar_ProvincesLostAndConquered_LastTurn < 0 ? 0.16f + 0.03f * (float)CFG.core.getCiv((int)n).civGD.moveAtWar_ProvincesLostAndConquered_LastTurn : (CFG.core.getCiv((int)n).civGD.moveAtWar_ArmyFullyRecruitedLastTurn ? 0.6f : 0.75f);
                        if (!(f * f2 > (float)CFG.core.getCiv(n).getNumberOfUnits()) && CFG.core.getCiv((int)n).civGD.moveAtWar_ProvincesLostAndConquered_LastTurn >= -3 && CFG.core.getCiv(n).getNumOfProvs() >= 3) break block40;
                    }
                    this.prepareForWar_Recruit(n, arrayList, arrayList2, false);
                }
                CFG.core.getCiv((int)n).civGD.moveAtWar_ArmyFullyRecruitedLastTurn = false;
            }
            if (GameValues.gvAiWar.USE_NEW_NAVAL_INVASION) {
                this.moveAtWar_AtSea_New(n);
            } else {
                this.moveAtWar_AtSea(n);
            }
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
    }

    public final void prepareForWar(int n, float fMovemnetPointsToUse) {
        if (CFG.core.getCiv((int)n).civGD.civPlans.iWarPrepsSize > 0) {
            ArrayList<Integer> tempFrontlinesIDs = new ArrayList<Integer>();
            block0: for (int i = 0; i < CFG.core.getCiv((int)n).lFrontLines.size(); ++i) {
                for (int j = 0; j < CFG.core.getCiv((int)n).civGD.civPlans.iWarPrepsSize; ++j) {
                    if (CFG.core.getCiv((int)n).lFrontLines.get((int)i).iWithCivID != CFG.core.getCiv((int)n).civGD.civPlans.warPreps.get((int)j).onCivID) continue;
                    tempFrontlinesIDs.add(i);
                    continue block0;
                }
            }
            if (!tempFrontlinesIDs.isEmpty()) {
                int n2;
                int n3;
                int n4;
                int n5;
                int n6;
                long n7;
                long n11;
                long maxArmyCount;
                ArrayList<AI_ProvinceInfo> arrayList2 = new ArrayList<AI_ProvinceInfo>();
                n2 = 1;
                float f2 = 1.0f;
                ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
                for (n6 = 0; n6 < CFG.core.getCiv((int)n).civGD.civPlans.iWarPrepsSize; ++n6) {
                    arrayList3.add(CFG.core.getCiv((int)n).civGD.civPlans.warPreps.get((int)n6).onCivID);
                }
                for (n6 = 0; n6 < tempFrontlinesIDs.size(); ++n6) {
                    n5 = CFG.core.getCiv((int)n).lFrontLines.get((int)tempFrontlinesIDs.get(n6)).lProvinces.size();
                    for (n4 = 0; n4 < n5; ++n4) {
                        boolean bl = false;
                        for (n3 = 0; n3 < arrayList2.size(); ++n3) {
                            if (((AI_ProvinceInfo)arrayList2.get((int)n3)).iProvinceID != CFG.core.getCiv((int)n).lFrontLines.get((int)tempFrontlinesIDs.get(n6)).lProvinces.get(n4)) continue;
                            bl = true;
                            break;
                        }
                        if (bl) continue;
                        arrayList2.add(new AI_ProvinceInfo(CFG.core.getCiv((int)n).lFrontLines.get((int)tempFrontlinesIDs.get(n6)).lProvinces.get(n4), this.getPotential_BasedOnNeighboringProvs((int)CFG.core.getCiv((int)n).lFrontLines.get((int)tempFrontlinesIDs.get(n6)).lProvinces.get(n4), n, arrayList3), CFG.gameAction.gMARY(CFG.core.getCiv((int)n).lFrontLines.get((int)tempFrontlinesIDs.get(n6)).lProvinces.get(n4))));
                    }
                }
                arrayList3.clear();
                arrayList3 = null;
                if (!arrayList2.isEmpty()) {
                    maxArmyCount = 1L;
                    ArrayList<Integer> arrayList4 = new ArrayList<Integer>();
                    n3 = arrayList2.size();
                    n7 = 0L;
                    for (n5 = 0; n5 < n3; ++n5) {
                        if (((AI_ProvinceInfo)arrayList2.get((int)n5)).iValue > f2) {
                            f2 = ((AI_ProvinceInfo)arrayList2.get((int)n5)).iValue;
                        }
                        if (CFG.core.getProv(((AI_ProvinceInfo)arrayList2.get((int)n5)).iProvinceID).getDangerLvl() > n2) {
                            n2 = CFG.core.getProv(((AI_ProvinceInfo)arrayList2.get((int)n5)).iProvinceID).getDangerLvl();
                        }
                        arrayList4.add((int)(n7 += this.getMovingArmyToProvinceID(n, ((AI_ProvinceInfo)arrayList2.get((int)n5)).iProvinceID)));
                        if (CFG.core.getProv(((AI_ProvinceInfo)arrayList2.get((int)n5)).iProvinceID).getArmyID(0) + n7 <= maxArmyCount) continue;
                        maxArmyCount = CFG.core.getProv(((AI_ProvinceInfo)arrayList2.get((int)n5)).iProvinceID).getArmyID(0) + n7;
                    }
                    n3 = arrayList2.size();
                    for (n5 = 0; n5 < n3; ++n5) {
                        ((AI_ProvinceInfo)arrayList2.get((int)n5)).iValue = CFG.core.getCiv((int)n).civGD.civPers.VALUABLE_POTENTIAL * (((AI_ProvinceInfo)arrayList2.get((int)n5)).iValue / f2) + CFG.core.getCiv((int)n).civGD.civPers.VALUABLE_DANGER * ((float)CFG.core.getProv(((AI_ProvinceInfo)arrayList2.get((int)n5)).iProvinceID).getDangerLvl() / (float)n2) * (1.0f - CFG.core.getCiv((int)n).civGD.civPers.VALUABLE_NUM_OF_UNITS + CFG.core.getCiv((int)n).civGD.civPers.VALUABLE_NUM_OF_UNITS * (1.0f - (float)(CFG.core.getProv(((AI_ProvinceInfo)arrayList2.get((int)n5)).iProvinceID).getArmyID(0) + (long)arrayList4.get(n5)) / (float)maxArmyCount));
                    }
                    ArrayList<AI_ProvinceInfo> arrayList5 = new ArrayList<AI_ProvinceInfo>();
                    while (!arrayList2.isEmpty()) {
                        int n8 = 0;
                        int n9 = arrayList2.size();
                        for (n6 = 1; n6 < n9; ++n6) {
                            if (!(((AI_ProvinceInfo)arrayList2.get((int)n8)).iValue < ((AI_ProvinceInfo)arrayList2.get((int)n6)).iValue)) continue;
                            n8 = n6;
                        }
                        arrayList5.add((AI_ProvinceInfo)arrayList2.get(n8));
                        arrayList2.remove(n8);
                    }
                    ArrayList<Integer> arrayList6 = new ArrayList<Integer>();
                    for (n6 = 0; n6 < CFG.core.getCiv((int)n).armiesPositionSize; ++n6) {
                        if (CFG.core.getCiv((int)n).civGD.civPlans.haveMission(CFG.core.getCiv((int)n).armiesPosition.get(n6))) continue;
                        arrayList6.add(CFG.core.getCiv((int)n).armiesPosition.get(n6));
                    }
                    List<AI_NeighProvinces> list = this.filterAIWarRecruitProvinces(n, CFG.oAI.getAllNeighboringProvincesInRange_Recruit(((AI_ProvinceInfo)arrayList5.get((int)0)).iProvinceID, n, 5, true, false, new ArrayList<AI_NeighProvinces>(), new ArrayList<Integer>()));
                    if (!list.isEmpty()) {
                        int n10 = CFG.oR.nextInt(list.size());
                        CFG.core.getCiv(n).recruitArmy_AI(list.get((int)n10).iProvinceID, CFG.gameAction.gMARY(list.get((int)n10).iProvinceID));
                        n11 = CFG.core.getCiv(n).getRecruitArmy_BasedOnProvinceID(list.get((int)n10).iProvinceID);
                        if (n11 > 0) {
                            CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.add(new CivArmyMission_RegroupAfterRecruitment(n, list.get((int)n10).iProvinceID, ((AI_ProvinceInfo)arrayList5.get((int)0)).iProvinceID, n11));
                        }
                    }
                }
            }
        }
    }

    public final long getMovingArmyToProvinceID(int nCivID, int nProvinceID) {
        long out = 0;
        for (int i = 0; i < CFG.core.getCiv((int)nCivID).civGD.civPlans.armiesMissions.size(); ++i) {
            if (CFG.core.getCiv((int)nCivID).civGD.civPlans.armiesMissions.get((int)i).toProvinceID != nProvinceID) continue;
            out += CFG.core.getCiv((int)nCivID).civGD.civPlans.armiesMissions.get((int)i).iArmy;
        }
        for (int j = 0; j < CFG.core.getCiv(nCivID).getRegroupArmySize(); ++j) {
            if (CFG.core.getCiv(nCivID).getRegroupArmy(j).getToProvinceID() != nProvinceID) continue;
            out += CFG.core.getCiv(nCivID).getRegroupArmy(j).getNumOfUnits();
        }
        for (int j = 0; j < CFG.core.getCiv(nCivID).moveUnitsSize(); ++j) {
            if (CFG.core.getCiv(nCivID).getMoveUnits(j).getToProvID() != nProvinceID) continue;
            out += CFG.core.getCiv(nCivID).getMoveUnits(j).getNumberOfUnits();
        }
        return out;
    }

    public final int getPotential_BasedOnNeighboringProvs(int n, int n2) {
        int n3 = CFG.core.getProv(n).getPotential();
        int n4 = 1;
        for (int i = 0; i < CFG.core.getProv(n).getNeighProvincesSize(); ++i) {
            if (CFG.core.getProv(CFG.core.getProv(n).getNeighProvinces(i)).getCivId() == n2) continue;
            n3 += CFG.core.getProv(CFG.core.getProv(n).getNeighProvinces(i)).getPotentialModified(n2);
            ++n4;
        }
        return n3 / n4;
    }

    public final int getPotential_BasedOnNeighboringProvs(int n, int n2, int n3) {
        int n4 = CFG.core.getProv(n).getPotential();
        int n5 = 1;
        for (int i = 0; i < CFG.core.getProv(n).getNeighProvincesSize(); ++i) {
            if (CFG.core.getProv(CFG.core.getProv(n).getNeighProvinces(i)).getCivId() != n3) continue;
            n4 += CFG.core.getProv(CFG.core.getProv(n).getNeighProvinces(i)).getPotentialModified(n2);
            ++n5;
        }
        return n4 / n5;
    }

    public final int getPotential_BasedOnNeighboringProvs(int n, int n2, List<Integer> list) {
        int n3 = CFG.core.getProv(n).getPotential();
        int n4 = 1;
        int n5 = list.size();
        for (int i = 0; i < CFG.core.getProv(n).getNeighProvincesSize(); ++i) {
            for (int j = 0; j < n5; ++j) {
                if (CFG.core.getProv(CFG.core.getProv(n).getNeighProvinces(i)).getCivId() != list.get(j).intValue()) continue;
                n3 += CFG.core.getProv(CFG.core.getProv(n).getNeighProvinces(i)).getPotentialModified(n2);
                ++n4;
            }
        }
        return n3 / n4;
    }

    public boolean canMove(int n) {
        return CFG.core.getCiv(n).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE;
    }

    public boolean canMoveAndRecruit(int n) {
        return CFG.core.getCiv(n).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_MOVE + CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_RECRUIT;
    }

    public boolean canMoveArmyToProvinceID(int n, int n2) {
        return CFG.core.getProv(n).getCivId() == n2 || CFG.core.getCivsAreAllied(n2, CFG.core.getProv(n).getCivId()) || CFG.core.getCiv(CFG.core.getProv(n).getCivId()).getPuppetOfCiv() == n2 || CFG.core.getCiv(n2).getPuppetOfCiv() == CFG.core.getProv(n).getCivId() || CFG.core.getMilitaryAccess(n2, CFG.core.getProv(n).getCivId()) > 0;
    }

    public boolean alliesAtWar(int n) {
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (i == n || !CFG.core.isAlly(n, i) || !CFG.core.getCiv(i).isAtWarC()) continue;
            return true;
        }
        return false;
    }

    public boolean canRecruit(int n, int n2) {
        return CFG.core.getCiv(n).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).COST_OF_RECRUIT && CFG.core.getCiv(n).getGold() >= (long)CFG.gCARR(n2);
    }

    public final long getRecruitableArmy(int n, int n2) {
        return Math.min(CFG.gameAction.gMARY(n, n2), (long)(CFG.core.getCiv(n2).getGold() / (long)CFG.gCARR(n)));
    }

    public final boolean doHaveAVisionInProvince(int n, int n2) {
        if (CFG.FOG_OF_WAR == 0) {
            return true;
        }
        if (CFG.core.getProv(n).getLvlOfFort() == 0) {
            for (int i = 0; i < CFG.core.getProv(n).getNeighProvincesSize(); ++i) {
                if (CFG.core.getProv(CFG.core.getProv(n).getNeighProvinces(i)).getLvlOfWatchTower() <= 0 || !CFG.core.isAlly(CFG.core.getProv(CFG.core.getProv(n).getNeighProvinces(i)).getCivId(), n2)) continue;
                return true;
            }
        }
        return false;
    }

    public final int getEnemyArmyInNeighbooringProvinces_ArmyOnlyAtWar(int n, int n2) {
        int n3 = 0;
        for (int i = 0; i < CFG.core.getProv(n).getNeighProvincesSize(); ++i) {
            if (CFG.core.getProv(CFG.core.getProv(n).getNeighProvinces(i)).getCivId() <= 0) continue;
            for (int j = 0; j < CFG.core.getProv(CFG.core.getProv(n).getNeighProvinces(i)).getCivsSize(); ++j) {
                if (!CFG.core.getCivsAtWar(CFG.core.getProv(CFG.core.getProv(n).getNeighProvinces(i)).getCivId(j), n2)) continue;
                n3 += CFG.core.getProv(CFG.core.getProv(n).getNeighProvinces(i)).getArmyCivID1(CFG.core.getProv(CFG.core.getProv(n).getNeighProvinces(i)).getCivId(j));
            }
        }
        return n3;
    }

    public final int getEnemyArmyInNeighbooringProvinces_Total(int nProvinceID, int nCivID) {
        int nOut = 0;
        block0: for (int i = 0; i < CFG.core.getProv(nProvinceID).getNeighProvincesSize(); ++i) {
            if (CFG.core.getProv(CFG.core.getProv(nProvinceID).getNeighProvinces(i)).getCivId() <= 0) continue;
            for (int j = 0; j < CFG.core.getProv(CFG.core.getProv(nProvinceID).getNeighProvinces(i)).getCivsSize(); ++j) {
                if (!CFG.core.getCivsAtWar(CFG.core.getProv(CFG.core.getProv(nProvinceID).getNeighProvinces(i)).getCivId(j), nCivID)) continue;
                nOut += CFG.core.getProvinceArmy(CFG.core.getProv(nProvinceID).getNeighProvinces(i));
                continue block0;
            }
        }
        return nOut;
    }

    public final int getEnemyArmyInNeighbooringSeaProvinces_Total(int n, int n2) {
        int n3 = 0;
        for (int i = 0; i < CFG.core.getProv(n).getNeighSeaProvincesSize(); ++i) {
            for (int j = 1; j < CFG.core.getProv(CFG.core.getProv(n).getNeighSeaProvinces(i)).getCivsSize(); ++j) {
                if (!CFG.core.getCivsAtWar(CFG.core.getProv(CFG.core.getProv(n).getNeighSeaProvinces(i)).getCivId(j), n2)) continue;
                n3 += CFG.core.getProv(CFG.core.getProv(n).getNeighSeaProvinces(i)).getArmyID(j);
            }
        }
        return n3;
    }

    public final boolean isUncivilzed(int n) {
        return CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).CAN_BECOME_CIVILIZED >= 0;
    }

    public final boolean canCivlize(int n) {
        return CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)n).getIdeology()).CIVILIZE_TECH_LEVEL <= CFG.core.getCiv(n).getTechLevel();
    }

    public final boolean civilize(int n) {
        if (this.isUncivilzed(n) && this.canCivlize(n)) {
            if (GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES && this.tryToExpandBeforeCivilize(n) && CFG.oR.nextInt(100) > 2) {
                return false;
            }
            if (GameManager.civilizeCiv(n)) {
                return true;
            }
        }
        return false;
    }

    public final boolean tryToExpandBeforeCivilize(int n) {
        if (CFG.core.getCiv(n).getBordersWithEnemy() > 0) {
            return false;
        }
        if (CFG.core.getCiv(n).getGold() + (long)CFG.core.getCiv((int)n).iBudget > -1000L && CFG.core.getCiv(n).getNumOfNeighboringNeutralProvinces() > 0) {
            int n2;
            for (n2 = CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.size() - 1; n2 >= 0; --n2) {
                if (CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.get((int)n2).MISSION_TYPE != CivArmyMission_Type.EXPAND_NETURAL_PROVINCE) continue;
                if (CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.get(n2).action(n)) {
                    CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.get(n2).onRemove();
                    CFG.core.getCiv((int)n).civGD.civPlans.armiesMissions.remove(n2);
                    continue;
                }
                return true;
            }
            if (CFG.core.getCiv(n).getNumOfProvs() < 6 + n % 2) {
                int n3;
                long n2_l = -1L;
                for (n3 = 0; n3 < CFG.core.getCiv(n).getNumOfProvs(); ++n3) {
                    for (int i = 0; i < CFG.core.getProv(CFG.core.getCiv(n).getProvID(n3)).getNeighProvincesSize(); ++i) {
                        if (CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getProvID(n3)).getNeighProvinces(i)).getCivId() != 0) continue;
                        n2_l = n2_l < 0L ? CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getProvID(n3)).getNeighProvinces(i)).getArmyID(0) : Math.min(n2_l, CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(n).getProvID(n3)).getNeighProvinces(i)).getArmyID(0));
                    }
                }
                if (n2_l < 0L) {
                    return false;
                }
                if ((n2_l = n2_l - ((long)CFG.core.getCiv(n).getNumberOfUnits() + Math.max(CFG.core.getCiv(n).getGold(), 0L) / (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT)) <= 0L) {
                    CFG.oAI.expandToNeutralProvinces_Out(n, false);
                    return true;
                }
                n3 = (int)Math.ceil((float)n2 / (float)(CFG.core.getCiv((int)n).iBudget / GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT));
                if (n3 < 50) {
                    CFG.oAI.expandToNeutralProvinces_Out(n, false);
                    return true;
                }
            }
        }
        return false;
    }

    public final void checkBalanceOfProvinces_Tribal(int n) {
        try {
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            int n2 = 0;
            int n3 = 0;
            for (int i = 0; i < CFG.core.getCiv(n).getNumOfProvs(); ++i) {
                if (CFG.core.getProv(CFG.core.getCiv(n).getProvID(i)).isOccupied()) continue;
                if (CFG.core.getProv(CFG.core.getCiv(n).getProvID(i)).getBalance_LastTurn() < 0) {
                    if (CFG.core.getCiv(n).getProvID(i) != CFG.core.getCiv(n).getCapitalProvID()) {
                        n2 += CFG.core.getProv(CFG.core.getCiv(n).getProvID(i)).getBalance_LastTurn();
                        arrayList.add(CFG.core.getCiv(n).getProvID(i));
                        continue;
                    }
                    n2 += CFG.core.getProv(CFG.core.getCiv(n).getProvID(i)).getBalance_LastTurn();
                    continue;
                }
                n3 += CFG.core.getProv(CFG.core.getCiv(n).getProvID(i)).getBalance_LastTurn();
            }
            if (!arrayList.isEmpty() && (float)n3 * 0.65f < (float)Math.abs(n2)) {
                float f = 0.0f;
                for (int i = arrayList.size() - 1; i >= 0; --i) {
                    f += (float)CFG.core.getProv((Integer)arrayList.get(i)).getBalance_LastTurn();
                }
                f /= (float)arrayList.size();
                ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
                for (int i = arrayList.size() - 1; i >= 0; --i) {
                    if (!(f * 0.375f > (float)CFG.core.getProv((Integer)arrayList.get(i)).getBalance_LastTurn())) continue;
                    arrayList2.add((Integer)arrayList.get(i));
                }
                this.abandonOrReleaseAsVassalProvinces(n, arrayList2, true);
            }
        }
        catch (Exception exception) {
            CFG.exceptionStack(exception);
        }
    }

    public static void sendUltimatumToPlayer() {
        if (GameCalendar.TURNID % GameValues.gvAiDiplomacy.DEMAND_VASSALIZATION_MODULO_TURN == GameValues.gvAiDiplomacy.DEMAND_VASSALIZATION_MODULO_TURN_CHECK_IF) {
            for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                int n;
                if (CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civNeighbors.civsSize <= 0 || CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getPuppetOfCiv() != CFG.core.getPlayer(i).getCivId() || CFG.oR.nextInt(100) >= GameValues.gvAiDiplomacy.DEMAND_VASSALIZATION_CHECK_CHANCE_100) continue;
                int n2 = 0;
                for (n = 0; n < CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civNeighbors.civsSize; ++n) {
                    if (CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civNeighbors.civs.get((int)n).civID).getNumOfProvs() <= 0 || CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civNeighbors.civs.get((int)n).civID).getPuppetOfCiv() != CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civNeighbors.civs.get((int)n).civID || CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civNeighbors.civs.get((int)n).civID).isAtWarC() || CFG.core.getCiv((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civNeighbors.civs.get((int)n).civID).civGD.civPlans.isPreparingForTheWar() || CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civNeighbors.civs.get((int)n).civID).getNumberOfUnits() <= CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civNeighbors.civs.get((int)n2).civID).getNumberOfUnits()) continue;
                    n2 = n;
                }
                n = CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).civNeighbors.civs.get((int)n2).civID;
                if (n != CFG.core.getCiv(n).getPuppetOfCiv() || CFG.core.getCiv(n).isAtWarC() || CFG.core.getCiv((int)n).civGD.civPlans.isPreparingForTheWar() || CFG.core.getCiv(n).getNumberOfUnits() < CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getNumberOfUnits() || !((float)CFG.core.getCiv((int)n).iBudget * GameValues.gvAiDiplomacy.DEMAND_VASSALIZATION_CIV_FROM_BUDGET_MODIFIER > (float)CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).iBudget)) continue;
                GameManager.decreaseRelation(n, CFG.core.getPlayer(i).getCivId(), GameValues.gvRelationDecrease.SUSPEND_DIPLOMATIC_RELATIONS_MAX);
                GameManager.decreaseRelation(n, CFG.core.getPlayer(i).getCivId(), GameValues.gvRelationDecrease.SUSPEND_DIPLOMATIC_RELATIONS_MAX);
                if (CFG.core.getCiv(n).getNumOfProvs() <= 0) continue;
                Ultimatum_GameData ultimatum_GameData = new Ultimatum_GameData();
                ultimatum_GameData.demandVasalization = true;
                GameManager.sendUltimatumFree(CFG.core.getPlayer(i).getCivId(), n, ultimatum_GameData, CFG.core.getCiv(n).getNumberOfUnits());
            }
        }
    }

    public final boolean abandonOrReleaseAsVassalProvinces(int n, List<Integer> list, boolean bl) {
        int n2;
        int n3;
        int n4;
        int n5;
        boolean bl2;
        int n6;
        int n7;
        ArrayList<AI_ReleaseVassal> arrayList = new ArrayList<AI_ReleaseVassal>();
        for (n7 = list.size() - 1; n7 >= 0; --n7) {
            for (n6 = 0; n6 < CFG.core.getProv(list.get(n7)).getCores().getCivsSize(); ++n6) {
                if (CFG.core.getCiv(CFG.core.getProv(list.get(n7)).getCores().getCivID(n6)).getNumOfProvs() != 0) continue;
                bl2 = true;
                for (n5 = arrayList.size() - 1; n5 >= 0; --n5) {
                    if (arrayList.get((int)n5).iCivID != CFG.core.getProv(list.get(n7)).getCores().getCivID(n6)) continue;
                    bl2 = false;
                    arrayList.get(n5).addProvince(list.get(n7));
                    break;
                }
                if (!bl2) continue;
                arrayList.add(new AI_ReleaseVassal(CFG.core.getProv(list.get(n7)).getCores().getCivID(n6), list.get(n7)));
            }
        }
        if (!arrayList.isEmpty() && (n4 = this.abandonOrReleaseAsVassalProvinces_ReleaseVassal(arrayList, list, n)) >= 0) {
            for (int i = list.size() - 1; i >= 0; --i) {
                if (!CFG.core.getCiv(n4).controlsProvince(list.get(i))) continue;
                list.remove(i);
            }
            return this.abandonOrReleaseAsVassalProvinces(n, list, bl);
        }
        arrayList.clear();
        for (n7 = list.size() - 1; n7 >= 0; --n7) {
            for (n6 = 0; n6 < CFG.core.getProv(list.get(n7)).getNeighProvincesSize(); ++n6) {
                if (CFG.core.getProv(CFG.core.getProv(list.get(n7)).getNeighProvinces(n6)).getCivId() <= 0 || CFG.core.getProv(CFG.core.getProv(list.get(n7)).getNeighProvinces(n6)).getCivId() == n) continue;
                bl2 = true;
                for (n5 = arrayList.size() - 1; n5 >= 0; --n5) {
                    if (arrayList.get((int)n5).iCivID != CFG.core.getProv(CFG.core.getProv(list.get(n7)).getNeighProvinces(n6)).getCivId()) continue;
                    bl2 = false;
                    arrayList.get(n5).addProvince(list.get(n7));
                    break;
                }
                if (!bl2) continue;
                arrayList.add(new AI_ReleaseVassal(CFG.core.getProv(CFG.core.getProv(list.get(n7)).getNeighProvinces(n6)).getCivId(), list.get(n7)));
            }
            for (n6 = 0; n6 < CFG.core.getProv(list.get(n7)).getCores().getCivsSize(); ++n6) {
                if (CFG.core.getProv(list.get(n7)).getCores().getCivID(n6) == n) continue;
                bl2 = true;
                for (n5 = arrayList.size() - 1; n5 >= 0; --n5) {
                    if (arrayList.get((int)n5).iCivID != CFG.core.getProv(list.get(n7)).getCores().getCivID(n6)) continue;
                    bl2 = false;
                    if (arrayList.get(n5).haveProvince(list.get(n7))) break;
                    arrayList.get(n5).addProvince(list.get(n7));
                    break;
                }
                if (!bl2) continue;
                arrayList.add(new AI_ReleaseVassal(CFG.core.getProv(list.get(n7)).getCores().getCivID(n6), list.get(n7)));
            }
        }
        ArrayList<AI_ReleaseVassal> arrayList2 = new ArrayList<AI_ReleaseVassal>();
        for (n3 = arrayList.size() - 1; n3 >= 0; --n3) {
            if (!CFG.core.isAlly(n, arrayList.get((int)n3).iCivID)) continue;
            arrayList2.add(arrayList.get(n3));
        }
        for (n6 = arrayList2.size() - 1; n6 >= 0; --n6) {
            for (n2 = CFG.core.getCiv(n).getSentMessagesSize() - 1; n2 >= 0; --n2) {
                if (CFG.core.getCiv((int)n).getSentMessage((int)n2).messageType != MessageType.TRADE_REQUEST_GIVE_PROVINCES || CFG.core.getCiv((int)n).getSentMessage((int)n2).iToCivID != ((AI_ReleaseVassal)arrayList2.get((int)n6)).iCivID) continue;
                arrayList2.remove(n6);
            }
        }
        while (!arrayList2.isEmpty()) {
            int n8;
            int n9;
            int n10 = 0;
            for (int i = arrayList2.size() - 1; i > 0; --i) {
                if (((AI_ReleaseVassal)arrayList2.get((int)n10)).lProvinces.size() >= ((AI_ReleaseVassal)arrayList2.get((int)i)).lProvinces.size() && CFG.oR.nextInt(100) >= 10) continue;
                n10 = i;
            }
            TradeRequest_GameData tradeRequest_GameData = new TradeRequest_GameData();
            for (n9 = ((AI_ReleaseVassal)arrayList2.get((int)n10)).lProvinces.size() - 1; n9 >= 0; --n9) {
                tradeRequest_GameData.listLEFT.lProvinces.add(((AI_ReleaseVassal)arrayList2.get((int)n10)).lProvinces.get(n9));
            }
            boolean messageSent = GameManager.sendTradeRequest(((AI_ReleaseVassal)arrayList2.get((int)n10)).iCivID, n, tradeRequest_GameData);
            if (!messageSent) break;
            CFG.core.getCiv((int)n).civGD.sentMessages.add(new Civilization_SentMessages(((AI_ReleaseVassal)arrayList2.get((int)n10)).iCivID, MessageType.TRADE_REQUEST_GIVE_PROVINCES));
            CFG.core.getCiv((int)((AI_ReleaseVassal)arrayList2.get((int)n10)).iCivID).civGD.sentMessages.add(new Civilization_SentMessages(n, MessageType.TRADE_REQUEST_GIVE_PROVINCES));
            block15: for (int j2 = tradeRequest_GameData.listLEFT.lProvinces.size() - 1; j2 >= 0; --j2) {
                for (int i7 = list.size() - 1; i7 >= 0; --i7) {
                    if (!list.get(i7).equals(tradeRequest_GameData.listLEFT.lProvinces.get(j2))) continue;
                    list.remove(i7);
                    continue block15;
                }
            }
            for (n2 = arrayList2.size() - 1; n2 >= 0; --n2) {
                if (n2 == n10) continue;
                for (n8 = ((AI_ReleaseVassal)arrayList2.get((int)n10)).lProvinces.size() - 1; n8 >= 0; --n8) {
                    ((AI_ReleaseVassal)arrayList2.get(n2)).removeProvinceID(((AI_ReleaseVassal)arrayList2.get((int)n10)).lProvinces.get(n8));
                }
            }
            arrayList2.remove(n10);
            for (n2 = arrayList2.size() - 1; n2 >= 0; --n2) {
                if (((AI_ReleaseVassal)arrayList2.get((int)n2)).lProvinces.size() != 0) continue;
                arrayList2.remove(n2);
            }
        }
        for (n3 = list.size() - 1; n3 >= 0; --n3) {
            CFG.gameAction.abandonProvince(list.get(n3), n);
        }
        return true;
    }

    public final int abandonOrReleaseAsVassalProvinces_ReleaseVassal(List<AI_ReleaseVassal> list, List<Integer> list2, int n) {
        int n2;
        int n3 = 0;
        for (n2 = list.size() - 1; n2 > 0; --n2) {
            if (list.get((int)n3).lProvinces.size() < list.get((int)n2).lProvinces.size()) {
                n3 = n2;
                continue;
            }
            if (list.get((int)n3).lProvinces.size() != list.get((int)n2).lProvinces.size() || CFG.oR.nextInt(100) >= 50) continue;
            n3 = n2;
        }
        for (n2 = list2.size() - 1; n2 >= 0; --n2) {
            CFG.core.getProv((int)list2.get((int)n2).intValue()).wasInProv = true;
        }
        for (n2 = list.get((int)n3).lProvinces.size() - 1; n2 >= 0; --n2) {
            CFG.core.getProv((int)list.get((int)n3).lProvinces.get((int)n2).intValue()).wasInProv = false;
        }
        for (n2 = 0; n2 < list.get((int)n3).lProvinces.size(); ++n2) {
            int n4;
            int n5;
            int n6;
            int n7;
            for (n7 = 0; n7 < CFG.core.getProv(list.get((int)n3).lProvinces.get(n2)).getNeighProvincesSize(); ++n7) {
                if (!CFG.core.getProv((int)CFG.core.getProv((int)list.get((int)n3).lProvinces.get((int)n2).intValue()).getNeighProvinces((int)n7)).wasInProv) continue;
                n6 = 1;
                for (n5 = list.size() - 1; n5 >= 0; --n5) {
                    if (!CFG.core.getProv(CFG.core.getProv(list.get((int)n3).lProvinces.get(n2)).getNeighProvinces(n7)).getCores().getHaveACore(list.get((int)n5).iCivID)) continue;
                    n6 = 0;
                    break;
                }
                boolean canBeAdded = true;
                block6: for (int m = 0; m < CFG.core.getProv(CFG.core.getProv(list.get((int)n3).lProvinces.get(n2)).getNeighProvinces(n7)).getNeighProvincesSize(); ++m) {
                    for (int u = list.size() - 1; u >= 0; --u) {
                        if (u == n3 || !list.get(u).haveProvince(CFG.core.getProv(CFG.core.getProv(list.get((int)n3).lProvinces.get(n2)).getNeighProvinces(n7)).getNeighProvinces(m))) continue;
                        canBeAdded = false;
                        break block6;
                    }
                }
                if (n6 == 0 || !canBeAdded) continue;
                list.get(n3).addProvince(CFG.core.getProv(list.get((int)n3).lProvinces.get(n2)).getNeighProvinces(n7));
                CFG.core.getProv((int)CFG.core.getProv((int)list.get((int)n3).lProvinces.get((int)n2).intValue()).getNeighProvinces((int)n7)).wasInProv = false;
            }
            for (n7 = 0; n7 < CFG.core.getProv(list.get((int)n3).lProvinces.get(n2)).getNeighSeaProvincesSize(); ++n7) {
                for (n6 = 0; n6 < CFG.core.getProv(CFG.core.getProv(list.get((int)n3).lProvinces.get(n2)).getNeighSeaProvinces(n7)).getNeighProvincesSize(); ++n6) {
                    if (CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(list.get((int)n3).lProvinces.get(n2)).getNeighSeaProvinces(n7)).getNeighProvinces(n6)).getSeaProv() || !CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)list.get((int)n3).lProvinces.get((int)n2).intValue()).getNeighSeaProvinces((int)n7)).getNeighProvinces((int)n6)).wasInProv) continue;
                    n5 = 1;
                    for (n4 = list.size() - 1; n4 >= 0; --n4) {
                        if (!CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(list.get((int)n3).lProvinces.get(n2)).getNeighSeaProvinces(n7)).getNeighProvinces(n6)).getCores().getHaveACore(list.get((int)n4).iCivID)) continue;
                        n5 = 0;
                        break;
                    }
                    boolean canBeAdded2 = true;
                    block11: for (int m = 0; m < CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(list.get((int)n3).lProvinces.get(n2)).getNeighSeaProvinces(n7)).getNeighProvinces(n6)).getNeighProvincesSize(); ++m) {
                        for (int u = list.size() - 1; u >= 0; --u) {
                            if (u == n3 || !list.get(u).haveProvince(CFG.core.getProv(CFG.core.getProv(CFG.core.getProv(list.get((int)n3).lProvinces.get(n2)).getNeighSeaProvinces(n7)).getNeighProvinces(n6)).getNeighProvinces(m))) continue;
                            canBeAdded2 = false;
                            break block11;
                        }
                    }
                    if (n5 == 0 || !canBeAdded2) continue;
                    list.get(n3).addProvince(CFG.core.getProv(CFG.core.getProv(list.get((int)n3).lProvinces.get(n2)).getNeighSeaProvinces(n7)).getNeighProvinces(n6));
                    CFG.core.getProv((int)CFG.core.getProv((int)CFG.core.getProv((int)list.get((int)n3).lProvinces.get((int)n2).intValue()).getNeighSeaProvinces((int)n7)).getNeighProvinces((int)n6)).wasInProv = false;
                }
            }
        }
        this.clearWas(list2);
        return CFG.core.releaseVassal(CFG.core.getCiv(list.get((int)n3).iCivID).getCivTag(), list.get((int)n3).lProvinces, -1, n, true);
    }

    public final void clearWas(List<Integer> was) {
        for (int i = was.size() - 1; i >= 0; --i) {
            CFG.core.getProv((int)was.get((int)i).intValue()).wasInProv = false;
        }
    }

    public final void clearWas() {
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            CFG.core.getProv((int)i).wasInProv = false;
        }
    }

    public final float armyOverBudget_Disband_AtWar(int nCivID) {
        return 0.9f - CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).getMin_Goods(nCivID) - CFG.ideologiesMgr.getInvestments(CFG.core.getCiv(nCivID).getIdeology(), nCivID);
    }

    public void armyOverBudget_Disband(int nCivID) {
        if (CFG.core.getCiv(nCivID).isAtWarC() || CFG.core.getCiv(nCivID).civGD.civPlans.isPreparingForTheWar() || GameCalendar.TURNID - CFG.core.getCiv(nCivID).civGD.iLastWarTurnID < (CFG.settingsGD.EXPERIMENTAL_BATTLE_SYSTEM ? 30 : 4)) {
            return;
        }
        if (CFG.core.getCiv(nCivID).civGD.aiNoDisbandUntilTurnID >= GameCalendar.TURNID || CFG.core.getCiv(nCivID).getRegroupArmySize() > 0 || CFG.core.getCiv(nCivID).civGD.recruitArmySize > 0) {
            return;
        }
        if (CFG.core.getCiv(nCivID).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_DISBAND) {
            boolean atWar = false;
            if ((CFG.core.getCiv(nCivID).isAtWarC() || CFG.core.getCiv((int)nCivID).civGD.civPlans.isPreparingForTheWar()) && CFG.core.getCiv((int)nCivID).iBudget > 0 && CFG.core.getCiv(nCivID).getGold() + (long)(CFG.core.getCiv((int)nCivID).iBudget * 3) > 0L) {
                atWar = true;
                return;
            }
            ArrayList<AI_ArmyUpkeep> armyUpkeep = new ArrayList<AI_ArmyUpkeep>();
            int spendingsOnArmy = (int)((float)CFG.core.getCiv((int)nCivID).iBudget * (atWar ? this.armyOverBudget_Disband_AtWar(nCivID) : this.getMinMilitarySpending(nCivID)));
            int budgetForArmyisOver = (int)Math.abs((float)CFG.core.getCiv((int)nCivID).iBudget * (atWar ? this.armyOverBudget_Disband_AtWar(nCivID) : this.getMinMilitarySpending(nCivID)) - (float)CFG.core.getCiv((int)nCivID).iBudget * CFG.core.getCiv((int)nCivID).iMilitaryUpkeep_PERC);
            if (CFG.core.getCiv((int)nCivID).iMilitaryUpkeep_Total > spendingsOnArmy) {
                int i;
                for (int i2 = 0; i2 < CFG.core.getCiv((int)nCivID).armiesPositionSize; ++i2) {
                    armyUpkeep.add(new AI_ArmyUpkeep(nCivID, CFG.core.getCiv((int)nCivID).armiesPosition.get(i2)));
                }
                ArrayList<AI_ArmyUpkeep> armiesOver = new ArrayList<AI_ArmyUpkeep>();
                for (i = armyUpkeep.size() - 1; i >= 0; --i) {
                    if (((AI_ArmyUpkeep)armyUpkeep.get((int)i)).iCost < budgetForArmyisOver) continue;
                    armiesOver.add((AI_ArmyUpkeep)armyUpkeep.get(i));
                }
                if (armiesOver.size() > 0) {
                    int tBestID = 0;
                    for (int i3 = tBestID + 1; i3 < armiesOver.size(); ++i3) {
                        if (CFG.core.getProv(((AI_ArmyUpkeep)armiesOver.get((int)tBestID)).iProvinceID).getDangerLvl() <= CFG.core.getProv(((AI_ArmyUpkeep)armiesOver.get((int)i3)).iProvinceID).getDangerLvl()) continue;
                        tBestID = i3;
                    }
                    float costPerUnit = CFG.gameUpdate.getMilitaryUpkeepP(((AI_ArmyUpkeep)armiesOver.get((int)tBestID)).iProvinceID, 1000, nCivID) / 1000.0f * 1.05f;
                    long maxDisbandArmy = CFG.core.getProv(((AI_ArmyUpkeep)armiesOver.get((int)tBestID)).iProvinceID).getArmyCivID1(nCivID);
                    if (maxDisbandArmy > 0) {
                        CFG.gameAction.disbandArmy(((AI_ArmyUpkeep)armiesOver.get((int)tBestID)).iProvinceID, (int)Math.min(Math.ceil((float)budgetForArmyisOver / costPerUnit), (double)maxDisbandArmy), nCivID);
                    }
                } else {
                    armiesOver.clear();
                    for (i = armyUpkeep.size() - 1; i >= 0; --i) {
                        if (CFG.core.getProv(((AI_ArmyUpkeep)armyUpkeep.get((int)i)).iProvinceID).getDangerLvl() != 0) continue;
                        armiesOver.add((AI_ArmyUpkeep)armyUpkeep.get(i));
                    }
                    if (armiesOver.size() > 0) {
                        int tTotalCost = 0;
                        for (int i4 = armiesOver.size() - 1; i4 >= 0; --i4) {
                            tTotalCost += ((AI_ArmyUpkeep)armiesOver.get((int)i4)).iCost;
                        }
                        if (tTotalCost >= budgetForArmyisOver) {
                            while (CFG.core.getCiv(nCivID).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_DISBAND && armiesOver.size() > 0) {
                                if (budgetForArmyisOver <= 0) {
                                    return;
                                }
                                int tBest = 0;
                                for (int i5 = armiesOver.size() - 1; i5 > 0; --i5) {
                                    if (((AI_ArmyUpkeep)armiesOver.get((int)tBest)).iCost >= ((AI_ArmyUpkeep)armiesOver.get((int)i5)).iCost) continue;
                                    tBest = i5;
                                }
                                float costPerUnit = CFG.gameUpdate.getMilitaryUpkeepP(((AI_ArmyUpkeep)armiesOver.get((int)tBest)).iProvinceID, 1000, nCivID) / 1000.0f * 1.05f;
                                CFG.gameAction.disbandArmy(((AI_ArmyUpkeep)armiesOver.get((int)tBest)).iProvinceID, (int)Math.ceil((float)budgetForArmyisOver / costPerUnit), nCivID);
                                budgetForArmyisOver -= ((AI_ArmyUpkeep)armiesOver.get((int)tBest)).iCost;
                                armiesOver.remove(tBest);
                            }
                        }
                    }
                    while (CFG.core.getCiv(nCivID).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_DISBAND && armyUpkeep.size() > 0) {
                        if (budgetForArmyisOver <= 0) {
                            return;
                        }
                        int tBest = 0;
                        for (int i6 = armyUpkeep.size() - 1; i6 > 0; --i6) {
                            if (((AI_ArmyUpkeep)armyUpkeep.get((int)tBest)).iCost >= ((AI_ArmyUpkeep)armyUpkeep.get((int)i6)).iCost) continue;
                            tBest = i6;
                        }
                        float costPerUnit = CFG.gameUpdate.getMilitaryUpkeepP(((AI_ArmyUpkeep)armyUpkeep.get((int)tBest)).iProvinceID, 1000, nCivID) / 1000.0f * 1.05f;
                        CFG.gameAction.disbandArmy(((AI_ArmyUpkeep)armyUpkeep.get((int)tBest)).iProvinceID, (int)Math.ceil((float)budgetForArmyisOver / costPerUnit), nCivID);
                        budgetForArmyisOver -= ((AI_ArmyUpkeep)armyUpkeep.get((int)tBest)).iCost;
                        armyUpkeep.remove(tBest);
                    }
                }
            }
        }
    }

    public final void useTechnologyPoints(int nCivID) {
        if (CFG.core.getCiv((int)nCivID).civGD.techPoints.getPointsLeft(nCivID) > 0) {
            ArrayList<AI_Skills> nSkills = new ArrayList<AI_Skills>();
            nSkills.add(new AI_Skills_Movement(CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_MOVEMENT, GameValues.gvTechnology.MAX_POINTS_MOVEMENT));
            nSkills.add(new AI_Skills(CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_POP_GROWTH, GameValues.gvTechnology.MAX_POINTS_POP_GROWTH));
            nSkills.add(new AI_Skills_Eco(CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_ECONOMY_GROWTH, GameValues.gvTechnology.MAX_POINTS_ECONOMY_GROWTH));
            nSkills.add(new AI_Skills_Taxation(CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_INCOME_TAXATION, GameValues.gvTechnology.MAX_POINTS_INCOME_TAXATION));
            nSkills.add(new AI_Skills_Production(CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_INCOME_PRODUCTION, GameValues.gvTechnology.MAX_POINTS_INCOME_PRODUCTION));
            nSkills.add(new AI_Skills_Administration(CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_ADMINISTRATION, GameValues.gvTechnology.MAX_POINTS_ADMINISTRATION));
            nSkills.add(new AI_Skills_Military(CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_MILITARY_UPKEEP, GameValues.gvTechnology.MAX_POINTS_MILITARY_UPKEEP));
            nSkills.add(new AI_Skills_Assimilate(CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_ASSIMILATE, GameValues.gvTechnology.MAX_POINTS_ASSIMILATE));
            nSkills.add(new AI_Skills_Research(CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_RESEARCH, GameValues.gvTechnology.MAX_POINTS_RESEARCH));
            nSkills.add(new AI_Skills_Recruitable(CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_RECRUITABLE, GameValues.gvTechnology.MAX_POINTS_RECRUITABLE));
            int pointsToUse = CFG.core.getCiv((int)nCivID).civGD.techPoints.getPointsLeft(nCivID);
            int nSkillsSize = nSkills.size();
            if (!CFG.core.getCiv((int)nCivID).civGD.coloniesFounded.isEmpty() && CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_COLONIZATION < GameValues.gvTechnology.MAX_POINTS_COLONIZATION && CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_COLONIZATION < CFG.core.getCiv((int)nCivID).civGD.coloniesFounded.size()) {
                SkillsManager.add_Colonization(nCivID);
            }
            while (true) {
                int n = --pointsToUse;
                --pointsToUse;
                if (n <= 0) break;
                int tBestID = 0;
                for (int i = tBestID + 1; i < nSkillsSize; ++i) {
                    if (!(((AI_Skills)nSkills.get(tBestID)).getScore(nCivID) < ((AI_Skills)nSkills.get(i)).getScore(nCivID))) continue;
                    tBestID = i;
                }
                ((AI_Skills)nSkills.get(tBestID)).addPoint_CivID(nCivID);
            }
        }
    }

    public final void updateLibertyDesire(int nCivID) {
        if (CFG.core.getCiv(nCivID).getPuppetOfCiv() != nCivID) {
            if (!CFG.VASSALS_CAN_DECLARE_INDEPENDENCE) {
                CFG.core.getCiv(nCivID).setVassalLibertyDesire(0.0f);
                return;
            }
            boolean updateLiberity = true;
            Civilization civ = CFG.core.getCiv(nCivID);
            try {
                if ((float)civ.getNumOfProvs() > (float)CFG.core.getCiv(civ.getPuppetOfCiv()).getNumOfProvs() * GameValues.gvVassalLiberty.PROVINCE_RATIO_THRESHOLD) {
                    civ.setVassalLibertyDesire(civ.getVassalLibertyDesire() + (GameValues.gvVassalLiberty.BASE_PROVINCE_LIBERTY_INCREASE + (float)CFG.oR.nextInt(GameValues.gvVassalLiberty.RANDOM_PROVINCE_LIBERTY_MAX_1000) / 1000.0f) * ((float)civ.getNumOfProvs() / (float)CFG.core.getCiv(civ.getPuppetOfCiv()).getNumOfProvs() * GameValues.gvVassalLiberty.PROVINCE_RATIO_MULTIPLIER) * (float)GameValues.gvUpdate.AI_TURN_ESSENTIALS_2);
                    updateLiberity = false;
                }
            }
            catch (Exception exception) {
                
            }
            try {
                if ((float)CFG.core.getCiv(civ.getPuppetOfCiv()).getVassal_Tribute(nCivID) > (float)GameValues.gvVassal.PERCENTAGE_OF_INCOME_FOR_LORD_MAX * civ.LIBERTY_ACCEPTABLE_TRIBUTE) {
                    civ.setVassalLibertyDesire(civ.getVassalLibertyDesire() + (civ.getVassalLibertyDesire() * GameValues.gvVassalLiberty.BASE_LIBERTY_HIGH_MULTIPLIER_PERC + (GameValues.gvVassalLiberty.BASE_TRIBUTE_HIGH_LIBERTY_INCREASE + (float)CFG.oR.nextInt(GameValues.gvVassalLiberty.RANDOM_TRIBUTE_HIGH_LIBERTY_100) / 100.0f) * ((float)CFG.core.getCiv(civ.getPuppetOfCiv()).getVassal_Tribute(nCivID) / (float)GameValues.gvVassal.PERCENTAGE_OF_INCOME_FOR_LORD_MAX)) * (float)GameValues.gvUpdate.AI_TURN_ESSENTIALS_2);
                    updateLiberity = false;
                } else if ((float)CFG.core.getCiv(civ.getPuppetOfCiv()).getVassal_Tribute(nCivID) < (float)GameValues.gvVassal.PERCENTAGE_OF_INCOME_FOR_LORD_MAX * civ.LIBERTY_ACCEPTABLE_TRIBUTE * GameValues.gvVassalLiberty.TRIBUTE_LOW_THRESHOLD_MULTIPLIER) {
                    civ.setVassalLibertyDesire(civ.getVassalLibertyDesire() - (GameValues.gvVassalLiberty.BASE_TRIBUTE_LOW_LIBERTY_DECREASE + (float)CFG.oR.nextInt(GameValues.gvVassalLiberty.RANDOM_TRIBUTE_LOW_LIBERTY_DECREASE_100) / 100.0f) * (1.0f - (float)CFG.core.getCiv(civ.getPuppetOfCiv()).getVassal_Tribute(nCivID) / (float)GameValues.gvVassal.PERCENTAGE_OF_INCOME_FOR_LORD_MAX) * (float)GameValues.gvUpdate.AI_TURN_ESSENTIALS_2);
                }
            }
            catch (Exception exception) {
                
            }
            try {
                if (CFG.core.getCivRelationOfCivB(nCivID, civ.getPuppetOfCiv()) < (float)GameValues.gvVassalLiberty.RELATION_NEGATIVE_THRESHOLD) {
                    civ.setVassalLibertyDesire(civ.getVassalLibertyDesire() + GameValues.gvVassalLiberty.BASE_RELATION_LIBERTY_LOW_INCREASE * Math.abs(CFG.core.getCivRelationOfCivB(nCivID, civ.getPuppetOfCiv()) / 100.0f) * (float)GameValues.gvUpdate.AI_TURN_ESSENTIALS_2);
                    updateLiberity = false;
                }
            }
            catch (Exception exception) {
                
            }
            if (updateLiberity) {
                civ.setVassalLibertyDesire(civ.getVassalLibertyDesire() - civ.getVassalLibertyDesire() * GameValues.gvVassalLiberty.PASSIVE_LIBERTY_DECAY_PERC * (float)GameValues.gvUpdate.AI_TURN_ESSENTIALS_2);
            }
            if (civ.getVassalLibertyDesire() > civ.LIBERTY_DECLARATION) {
                GameManager.declarationOfIndependenceByVassal(civ.getPuppetOfCiv(), nCivID);
            }
        }
    }

    public static float getLibertyDesireChange_JustInfo(int nCivID) {
        if (CFG.core.getCiv(nCivID).getPuppetOfCiv() != nCivID) {
            float out = 0.0f;
            boolean updateLiberity = true;
            Civilization civ = CFG.core.getCiv(nCivID);
            try {
                if ((float)civ.getNumOfProvs() > (float)CFG.core.getCiv(civ.getPuppetOfCiv()).getNumOfProvs() * GameValues.gvVassalLiberty.PROVINCE_RATIO_THRESHOLD) {
                    out += (GameValues.gvVassalLiberty.BASE_PROVINCE_LIBERTY_INCREASE + (float)GameValues.gvVassalLiberty.RANDOM_PROVINCE_LIBERTY_MAX_1000 * GameValues.gvVassalLiberty.LIBERTY_CHANGE_JUST_INFO_RANDOM_MODIFIER / 1000.0f) * ((float)civ.getNumOfProvs() / (float)CFG.core.getCiv(civ.getPuppetOfCiv()).getNumOfProvs() * GameValues.gvVassalLiberty.PROVINCE_RATIO_MULTIPLIER);
                    updateLiberity = false;
                }
            }
            catch (Exception exception) {
                
            }
            try {
                if ((float)CFG.core.getCiv(civ.getPuppetOfCiv()).getVassal_Tribute(nCivID) > (float)GameValues.gvVassal.PERCENTAGE_OF_INCOME_FOR_LORD_MAX * civ.LIBERTY_ACCEPTABLE_TRIBUTE) {
                    out += civ.getVassalLibertyDesire() * GameValues.gvVassalLiberty.BASE_LIBERTY_HIGH_MULTIPLIER_PERC + (GameValues.gvVassalLiberty.BASE_TRIBUTE_HIGH_LIBERTY_INCREASE + (float)GameValues.gvVassalLiberty.RANDOM_TRIBUTE_HIGH_LIBERTY_100 * GameValues.gvVassalLiberty.LIBERTY_CHANGE_JUST_INFO_RANDOM_MODIFIER / 100.0f) * ((float)CFG.core.getCiv(civ.getPuppetOfCiv()).getVassal_Tribute(nCivID) / (float)GameValues.gvVassal.PERCENTAGE_OF_INCOME_FOR_LORD_MAX);
                    updateLiberity = false;
                } else if ((float)CFG.core.getCiv(civ.getPuppetOfCiv()).getVassal_Tribute(nCivID) < (float)GameValues.gvVassal.PERCENTAGE_OF_INCOME_FOR_LORD_MAX * civ.LIBERTY_ACCEPTABLE_TRIBUTE * GameValues.gvVassalLiberty.TRIBUTE_LOW_THRESHOLD_MULTIPLIER) {
                    out -= (GameValues.gvVassalLiberty.BASE_TRIBUTE_LOW_LIBERTY_DECREASE + (float)GameValues.gvVassalLiberty.RANDOM_TRIBUTE_LOW_LIBERTY_DECREASE_100 * GameValues.gvVassalLiberty.LIBERTY_CHANGE_JUST_INFO_RANDOM_MODIFIER / 100.0f) * (1.0f - (float)CFG.core.getCiv(civ.getPuppetOfCiv()).getVassal_Tribute(nCivID) / (float)GameValues.gvVassal.PERCENTAGE_OF_INCOME_FOR_LORD_MAX);
                }
            }
            catch (Exception exception) {
                
            }
            try {
                if (CFG.core.getCivRelationOfCivB(nCivID, civ.getPuppetOfCiv()) < (float)GameValues.gvVassalLiberty.RELATION_NEGATIVE_THRESHOLD) {
                    out += GameValues.gvVassalLiberty.BASE_RELATION_LIBERTY_LOW_INCREASE * Math.abs(CFG.core.getCivRelationOfCivB(nCivID, civ.getPuppetOfCiv()) / 100.0f);
                    updateLiberity = false;
                }
            }
            catch (Exception exception) {
                
            }
            if (updateLiberity) {
                out -= civ.getVassalLibertyDesire() * GameValues.gvVassalLiberty.PASSIVE_LIBERTY_DECAY_PERC;
            }
            return out;
        }
        return 0.0f;
    }

    public final void investForeign(int civID) {
        try {
            if (!CFG.core.getCiv(civID).isAtWarC() && !CFG.core.getCiv((int)civID).civGD.civPlans.isPreparingForTheWar() && CFG.core.getCiv(civID).getGold() > (long)GameValues.gvAiInvest.INVEST_FOREIGN_MIN_GOLD && CFG.oR.nextInt(1000) < GameValues.gvAiInvest.INVEST_FOREIGN_RAND_CHANCE_1000) {
                int randValue = CFG.oR.nextInt(100);
                if (randValue < GameValues.gvAiInvest.INVEST_FOREIGN_FRIENDLY_CIV) {
                    if (CFG.core.getCiv(civID).getFriendlyCivsSize() > 0) {
                        int randProvince;
                        int randFriendly = CFG.oR.nextInt(CFG.core.getCiv(civID).getFriendlyCivsSize());
                        if (CFG.core.getCiv(CFG.core.getCiv((int)civID).getFriendlyCiv((int)randFriendly).iCivID).getNumOfProvs() > 0 && !CFG.core.getProv(randProvince = CFG.core.getCiv(CFG.core.getCiv((int)civID).getFriendlyCiv((int)randFriendly).iCivID).getProvID(CFG.oR.nextInt(CFG.core.getCiv(CFG.core.getCiv((int)civID).getFriendlyCiv((int)randFriendly).iCivID).getNumOfProvs()))).getSeaProv() && CFG.core.getProv(randProvince).getWastelandLvl() < 0 && CFG.core.getProv(randProvince).getCivId() != civID && CFG.core.getProv(randProvince).getCivId() > 0) {
                            long maxInvestGold = Math.min(CFG.core.getCiv(civID).getGold(), GameManager.invest_MaxEconomy_Gold(randProvince, civID));
                            GameManager.investForeignEconomy(civID, randProvince, (long)((float)maxInvestGold * GameValues.gvAiInvest.INVEST_FOREIGN_MAX_GOLD_MIN + (float)CFG.oR.nextInt((int)Math.max(1.0, Math.ceil((float)maxInvestGold * GameValues.gvAiInvest.INVEST_FOREIGN_MAX_GOLD_RAND)))));
                        }
                    }
                } else if (randValue < GameValues.gvAiInvest.INVEST_FOREIGN_NEIGHBOURING_CIV) {
                    if (CFG.core.getCiv((int)civID).civNeighbors.civsSize > 0) {
                        int randProvince;
                        int randCiv;
                        ArrayList<Integer> possibleCivs = new ArrayList<Integer>();
                        for (int i = 0; i < CFG.core.getCiv((int)civID).civNeighbors.civsSize; ++i) {
                            if (!(CFG.core.getCiv(civID).getRelationD(CFG.core.getCiv((int)civID).civNeighbors.civs.get((int)i).civID) >= (float)GameValues.gvAiInvest.INVEST_FOREIGN_MIN_RELATION) || CFG.core.getCiv(civID).areSanctionsAdded(civID, CFG.core.getCiv((int)civID).civNeighbors.civs.get((int)i).civID) || CFG.core.getCiv(CFG.core.getCiv((int)civID).civNeighbors.civs.get((int)i).civID).areSanctionsAdded(CFG.core.getCiv((int)civID).civNeighbors.civs.get((int)i).civID, civID)) continue;
                            possibleCivs.add(CFG.core.getCiv((int)civID).civNeighbors.civs.get((int)i).civID);
                        }
                        if (!possibleCivs.isEmpty() && CFG.core.getCiv((Integer)possibleCivs.get(randCiv = CFG.oR.nextInt(possibleCivs.size()))).getNumOfProvs() > 0 && !CFG.core.getProv(randProvince = CFG.core.getCiv((Integer)possibleCivs.get(randCiv)).getProvID(CFG.oR.nextInt(CFG.core.getCiv((Integer)possibleCivs.get(randCiv)).getNumOfProvs()))).getSeaProv() && CFG.core.getProv(randProvince).getWastelandLvl() < 0 && CFG.core.getProv(randProvince).getCivId() != civID && CFG.core.getProv(randProvince).getCivId() > 0) {
                            long maxInvestGold = Math.min(CFG.core.getCiv(civID).getGold(), GameManager.invest_MaxEconomy_Gold(randProvince, civID));
                            GameManager.investForeignEconomy(civID, randProvince, (long)((float)maxInvestGold * GameValues.gvAiInvest.INVEST_FOREIGN_MAX_GOLD_MIN + (float)CFG.oR.nextInt((int)Math.max(1.0, Math.ceil((float)maxInvestGold * GameValues.gvAiInvest.INVEST_FOREIGN_MAX_GOLD_RAND)))));
                        }
                        possibleCivs.clear();
                    }
                } else {
                    int randProvince = CFG.oR.nextInt(CFG.core.getProvinSize());
                    if (!CFG.core.getProv(randProvince).getSeaProv() && CFG.core.getProv(randProvince).getWastelandLvl() < 0 && CFG.core.getProv(randProvince).getCivId() != civID && CFG.core.getProv(randProvince).getCivId() > 0) {
                        long maxInvestGold = Math.min(CFG.core.getCiv(civID).getGold(), GameManager.invest_MaxEconomy_Gold(randProvince, civID));
                        GameManager.investForeignEconomy(civID, randProvince, (long)((float)maxInvestGold * GameValues.gvAiInvest.INVEST_FOREIGN_MAX_GOLD_MIN + (float)CFG.oR.nextInt((int)Math.max(1.0, Math.ceil((float)maxInvestGold * GameValues.gvAiInvest.INVEST_FOREIGN_MAX_GOLD_RAND)))));
                    }
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static boolean unionResponseAI(int fromCivID, int nCivID) {
        if (CFG.core.getCiv(fromCivID).getCivDiploGD().getIsEmbassyClosed(nCivID)) {
            return false;
        }
        if (CFG.core.getCiv((int)nCivID).civGD.civPlans.isPreparingForTheWar(fromCivID)) {
            return false;
        }
        return CFG.core.getCiv(nCivID).getRelationD(fromCivID) >= 75.0f;
    }

    public static boolean offerVassalization_AIResponse(int fromCivID, int toCivID) {
        return (float)CFG.core.getCiv((int)toCivID).iBudget * (GameValues.gvAiDiplomacy.OFFER_VASSALIZATION_BUDGET_RATIO_TO_ACCEPT + (float)CFG.core.getCiv((int)fromCivID).civGD.iVassalsSize * GameValues.gvAiDiplomacy.OFFER_VASSALIZATION_BUDGET_RATIO_TO_ACCEPT_EXTRA_PER_VASSAL) < (float)CFG.core.getCiv((int)fromCivID).iBudget && !CFG.core.getCiv(toCivID).isHatedCiv(fromCivID) && CFG.core.getCiv(toCivID).getRelationD(fromCivID) >= GameValues.gvAiDiplomacy.OFFER_VASSALIZATION_MIN_RELATION;
    }

    public static float offerVassalization_BudgetToAccept(int byCivID) {
        return GameValues.gvAiDiplomacy.OFFER_VASSALIZATION_BUDGET_RATIO_TO_ACCEPT + (float)CFG.core.getCiv((int)byCivID).civGD.iVassalsSize * GameValues.gvAiDiplomacy.OFFER_VASSALIZATION_BUDGET_RATIO_TO_ACCEPT_EXTRA_PER_VASSAL;
    }

    public static int tradeDealAI_ResponseInfo(TradeRequest_GameData tradeRequest, int fromCivID, int nCivID) {
        if (CFG.SANDBOX_MODE) {
            return 2;
        }
        Civilization civ = CFG.core.getCiv(nCivID);
        if (tradeRequest.listRight.lDeclareWarOnCivID.size() > 0) {
            int targetCivID = tradeRequest.listRight.lDeclareWarOnCivID.get(0);
            if (tradeRequest.listLEFT.iGold == GameValues.gvTrade.DECLARE_WAR_MAGIC_NUM_ALWAYS_ACCEPT) {
                return 2;
            }
            if (civ.isHatedCiv(fromCivID)) {
                return -1;
            }
            if (civ.isFriendlyCiv(targetCivID) >= 0) {
                return -1;
            }
            if ((float)civ.countPop() * GameValues.gvTrade.DECLARE_WAR_CIV_POP_MODIFIER < (float)CFG.core.getCiv(targetCivID).countPop()) {
                return -1;
            }
            if (tradeRequest.listLEFT.iGold == GameValues.gvTrade.DECLARE_WAR_MAGIC_NUM_ALWAYS_ACCEPT) {
                return 2;
            }
            if (tradeRequest.listRight.iGold > 0) {
                return -1;
            }
            long civIncome = Math.max(CFG.core.getCiv((int)nCivID).incomeTaxation + CFG.core.getCiv((int)nCivID).incomeProduction, CFG.core.getCiv((int)targetCivID).incomeTaxation + CFG.core.getCiv((int)targetCivID).incomeProduction);
            civIncome += (long)Math.max(1.0f, (float)CFG.core.getCiv(targetCivID).getNumberOfUnits() * GameValues.gvTrade.DECLARE_WAR_CIV_GOLD_PER_ENEMY_UNIT);
            if ((long)tradeRequest.listLEFT.iGold >= (civIncome = (long)((float)civIncome * GameValues.gvTrade.DECLARE_WAR_CIV_INCOME_MULTIPLIER))) {
                return 2;
            }
            if (!tradeRequest.listLEFT.lProvinces.isEmpty()) {
                long totalGold = tradeRequest.listLEFT.iGold;
                for (int a = 0; a < tradeRequest.listLEFT.lProvinces.size(); ++a) {
                    totalGold = (long)((float)totalGold + Math.max(GameValues.gvTrade.AI_TRADE_PROVINCE_MIN_COST, CFG.core.getProv((int)tradeRequest.listLEFT.lProvinces.get((int)a).intValue()).incomeTaxation * GameValues.gvTrade.AI_TRADE_PROVINCE_INCOME_TAXATION_WEIGHT + CFG.core.getProv((int)tradeRequest.listLEFT.lProvinces.get((int)a).intValue()).incomeProduction * GameValues.gvTrade.AI_TRADE_PROVINCE_INCOME_PRODUCTION_WEIGHT));
                }
                if (totalGold >= (long)civIncome) {
                    return 2;
                }
                return -1;
            }
            return -1;
        }
        if (tradeRequest.listRight.lFormCoalitionAgainst.size() > 0 || tradeRequest.listLEFT.lFormCoalitionAgainst.size() > 0) {
            if (civ.isHatedCiv(fromCivID)) {
                return -1;
            }
            if (!tradeRequest.listRight.lProvinces.isEmpty()) {
                return -1;
            }
            if (tradeRequest.listRight.iGold > 0) {
                return -1;
            }
            if (civ.isAtWarC()) {
                return -1;
            }
            if (civ.isHatedCiv(tradeRequest.listLEFT.lFormCoalitionAgainst.get(0)) || civ.isHatedCiv(tradeRequest.listRight.lFormCoalitionAgainst.get(0))) {
                if (civ.isFriendlyCiv(fromCivID) >= 0) {
                    return 2;
                }
                return -1;
            }
            return -1;
        }
        if (tradeRequest.listRight.lSanctionCivID.size() > 0) {
            if (civ.isFriendlyCiv(tradeRequest.listRight.lSanctionCivID.get(0)) >= 0) {
                return -1;
            }
            long totalValue = tradeRequest.listLEFT.iGold;
            for (int a = 0; a < tradeRequest.listLEFT.lProvinces.size(); ++a) {
                totalValue += Math.max(GameValues.gvTrade.AI_TRADE_PROVINCE_MIN_COST, (long)((float)CFG.core.getProv(tradeRequest.listLEFT.lProvinces.get(a)).incomeTaxation * GameValues.gvTrade.AI_TRADE_PROVINCE_INCOME_TAXATION_WEIGHT));
            }
            long targetIncome = Math.max(1L, (long)civ.incomeTaxation + (long)civ.incomeProduction);
            if (totalValue >= 20 * targetIncome) {
                if (CFG.oR.nextInt(100) < 60) {
                    return 2;
                }
                return 0;
            }
            if (totalValue >= 5 * targetIncome) {
                return 0;
            }
            return -1;
        }
        if (tradeRequest.listRight.lProvinces.size() > 0) {
            if ((float)tradeRequest.listRight.lProvinces.size() / (float)civ.getNumOfProvs() > GameValues.gvTrade.AI_TRADE_MAX_PROVINCE_SHARE_TO_ACCEPT) {
                return -1;
            }
            boolean haveACore = false;
            for (int z = 0; z < tradeRequest.listRight.lProvinces.size(); ++z) {
                if (!CFG.core.getProv(tradeRequest.listRight.lProvinces.get(z)).getCores().getHaveACore(nCivID)) continue;
                haveACore = true;
                break;
            }
            if (!haveACore) {
                long totalCost = 0L;
                for (int z = 0; z < tradeRequest.listRight.lProvinces.size(); ++z) {
                    totalCost = (int)((float)totalCost + Math.max(GameValues.gvTrade.AI_TRADE_PROVINCE_MIN_COST, CFG.core.getProv((int)tradeRequest.listRight.lProvinces.get((int)z).intValue()).incomeTaxation * GameValues.gvTrade.AI_TRADE_PROVINCE_INCOME_TAXATION_WEIGHT + CFG.core.getProv((int)tradeRequest.listRight.lProvinces.get((int)z).intValue()).incomeProduction * GameValues.gvTrade.AI_TRADE_PROVINCE_INCOME_PRODUCTION_WEIGHT));
                }
                if (tradeRequest.listLEFT.iGold > (totalCost = (int)Math.ceil((float)totalCost * GameValues.gvTrade.AI_TRADE_PROVINCE_COST_MULTIPLIER))) {
                    return 2;
                }
                return -1;
            }
            return -1;
        }
        if (!tradeRequest.listLEFT.lProvinces.isEmpty() && tradeRequest.listRight.iGold > 0) {
            int maxGold = (int)Math.ceil((float)tradeRequest.listLEFT.lProvinces.size() * GameValues.gvTrade.AI_TRADE_ACCEPT_PROVINCES_MAX_GOLD_PER_PROVINCE);
            if (maxGold >= tradeRequest.listRight.iGold) {
                if ((float)(civ.getGold() - (long)tradeRequest.listRight.iGold) > GameValues.gvTrade.AI_TRADE_ACCEPT_PROVINCES_ONLY_IF_TREASURY_AFTER_PAYING_IS_OVER) {
                    return 2;
                }
                return -1;
            }
            return -1;
        }
        if (tradeRequest.listRight.militaryAccess && !tradeRequest.listRight.proclaimIndependence && !tradeRequest.listRight.nonAggressionPact && !tradeRequest.listRight.defensivePact && tradeRequest.listRight.iGold <= 0 && tradeRequest.listRight.lProvinces.isEmpty()) {
            boolean warAgainstFriendlyCiv = false;
            for (int z = 0; z < CFG.core.getCiv((int)fromCivID).isAtWarWithCivs.size(); ++z) {
                if (civ.isFriendlyCiv(CFG.core.getCiv((int)fromCivID).isAtWarWithCivs.get(z)) < 0) continue;
                warAgainstFriendlyCiv = true;
                break;
            }
            if (warAgainstFriendlyCiv) {
                if (civ.isHatedCiv(fromCivID)) {
                    if ((float)tradeRequest.listLEFT.iGold > (float)civ.iBudget * GameValues.gvTrade.AI_TRADE_MILITARY_ACCESS_BUDGET_MULTIPLIER_AT_WAR_WITH_FRIENDLY) {
                        return 2;
                    }
                    return -1;
                }
            } else {
                if (civ.isHatedCiv(fromCivID)) {
                    if ((float)tradeRequest.listLEFT.iGold > (float)civ.iBudget * GameValues.gvTrade.AI_TRADE_MILITARY_ACCESS_BUDGET_MULTIPLIER_FROM_HATED_CIV) {
                        return 2;
                    }
                    return -1;
                }
                if (tradeRequest.listLEFT.iGold > 0) {
                    if (civ.iBudget > 0) {
                        if ((float)tradeRequest.listLEFT.iGold > (float)civ.iBudget * GameValues.gvTrade.AI_TRADE_MILITARY_ACCESS_BUDGET_MULTIPLIER) {
                            return 2;
                        }
                        return -1;
                    }
                    return 2;
                }
            }
        } else {
            if (tradeRequest.listRight.defensivePact || tradeRequest.listLEFT.defensivePact) {
                if (civ.isHatedCiv(fromCivID)) {
                    return -1;
                }
                if (tradeRequest.listRight.iGold > 0) {
                    return -1;
                }
                return 0;
            }
            if (tradeRequest.listRight.proclaimIndependence || tradeRequest.listLEFT.proclaimIndependence) {
                if (civ.isHatedCiv(fromCivID)) {
                    return -1;
                }
                if (tradeRequest.listRight.proclaimIndependence && CFG.core.getCiv(nCivID).getNumOfProvs() > CFG.core.getCiv(fromCivID).getNumOfProvs()) {
                    if (CFG.core.getCiv(fromCivID).getPuppetOfCiv() != fromCivID) {
                        return -1;
                    }
                    if (GameManager.getGuaranteeTheirIndependenceSize(fromCivID) >= GameValues.gvTrade.PROCLAIM_THEIR_INDEPENDENCE_CIVS_LIMIT) {
                        return -1;
                    }
                    return 0;
                }
                if (tradeRequest.listLEFT.proclaimIndependence && CFG.core.getCiv(nCivID).getNumOfProvs() < CFG.core.getCiv(fromCivID).getNumOfProvs() && CFG.core.getCiv(nCivID).getNumOfProvs() < GameValues.gvTrade.PROCLAIM_INDEPENDENCE_MAX_PROVINCES) {
                    if (CFG.core.getCiv(nCivID).getPuppetOfCiv() != nCivID) {
                        return -1;
                    }
                    return 0;
                }
                if (CFG.core.getCiv(nCivID).getPuppetOfCiv() != nCivID || CFG.core.getCiv(fromCivID).getPuppetOfCiv() != fromCivID) {
                    return -1;
                }
                return 0;
            }
            if (tradeRequest.listRight.nonAggressionPact || tradeRequest.listLEFT.nonAggressionPact) {
                if (civ.isHatedCiv(fromCivID)) {
                    return -1;
                }
                if (tradeRequest.listRight.iGold > 0) {
                    return -1;
                }
                return 0;
            }
            if (tradeRequest.listRight.militaryAccess || tradeRequest.listLEFT.militaryAccess) {
                if (civ.isHatedCiv(fromCivID)) {
                    return -1;
                }
                if (tradeRequest.listRight.iGold > 0) {
                    return -1;
                }
                return 0;
            }
            if (tradeRequest.listRight.iGold > 0 || tradeRequest.listLEFT.iGold > 0) {
                if (tradeRequest.listRight.iGold > tradeRequest.listLEFT.iGold) {
                    return -1;
                }
                return 2;
            }
            return 2;
        }
        return -1;
    }

    public static class CivDistance {
        public int civID;
        public float distance;

        public CivDistance(int civID, float distance) {
            this.civID = civID;
            this.distance = distance;
        }
    }
}






















