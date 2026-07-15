
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.AI.AI_CivsInRange;
import age.of.civilizations2.jakowski.lukasz.AI.FrontLine.AI_Frontline;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.CivBonus_GameData;
import age.of.civilizations2.jakowski.lukasz.CivBonus_Type;
import age.of.civilizations2.jakowski.lukasz.CivInvest;
import age.of.civilizations2.jakowski.lukasz.CivInvest_Development;
import age.of.civilizations2.jakowski.lukasz.CivPersonality;
import age.of.civilizations2.jakowski.lukasz.CivPlans;
import age.of.civilizations2.jakowski.lukasz.CivTask;
import age.of.civilizations2.jakowski.lukasz.Civilization_Diplomacy_GameData;
import age.of.civilizations2.jakowski.lukasz.Civilization_Friends_GameData;
import age.of.civilizations2.jakowski.lukasz.Civilization_GameData3;
import age.of.civilizations2.jakowski.lukasz.Civilization_Hated_GameData;
import age.of.civilizations2.jakowski.lukasz.Civilization_Region;
import age.of.civilizations2.jakowski.lukasz.Civilization_Sanctions;
import age.of.civilizations2.jakowski.lukasz.Civilization_SentMessages;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Civ_Gift_GameData;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivilizationsNeighbors;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.BuildingsConstruction;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.BuildingsConstruction__Armoury;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.BuildingsConstruction__Farm;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.BuildingsConstruction__Fort;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.BuildingsConstruction__Library;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.BuildingsConstruction__Market;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.BuildingsConstruction__Supply;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.BuildingsConstruction__Tower;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.BuildingsConstruction__Workshop;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.ConstructionType;
import age.of.civilizations2.jakowski.lukasz.Civilizations.LoanCiv_GameData;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Loan_GameData;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Diplomacy.Festivals.Festival;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog_FriendlyCivs;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Image;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.LeaderOfCiv_GameData;
import age.of.civilizations2.jakowski.lukasz.Menus.ZRest.Menu_InGame_Event;
import age.of.civilizations2.jakowski.lukasz.Messages.Info.Message_AssimilationEnd;
import age.of.civilizations2.jakowski.lukasz.Messages.Info.Message_FestivalIsOver;
import age.of.civilizations2.jakowski.lukasz.Messages.Info.Message_Repaid;
import age.of.civilizations2.jakowski.lukasz.Messages.Invest.Message_InvestDone;
import age.of.civilizations2.jakowski.lukasz.Messages.Invest.Message_InvestDone_Development;
import age.of.civilizations2.jakowski.lukasz.Messages.MessageType;
import age.of.civilizations2.jakowski.lukasz.Messages.Relations.Message_Relations_Friendly;
import age.of.civilizations2.jakowski.lukasz.Messages.Relations.Sanctions.Message_SanctionsExpired;
import age.of.civilizations2.jakowski.lukasz.Messages.War.Reparations.Message_WarReparationsRepaid;
import age.of.civilizations2.jakowski.lukasz.Messages.War.Reparations.Message_WarReparationsRepaid_Green;
import age.of.civilizations2.jakowski.lukasz.MoveUnitsB.Line.MoveUnits_Line;
import age.of.civilizations2.jakowski.lukasz.MoveUnitsB.Line.MoveUnits_Line_Highlighted;
import age.of.civilizations2.jakowski.lukasz.MoveUnitsB.MoveUnits;
import age.of.civilizations2.jakowski.lukasz.MoveUnitsB.GenocideOperation;
import age.of.civilizations2.jakowski.lukasz.MoveUnitsB.MoveUnits_Plunder;
import age.of.civilizations2.jakowski.lukasz.RecruitArmy;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy;
import age.of.civilizations2.jakowski.lukasz.Save.Save_Civ_GameData;
import age.of.civilizations2.jakowski.lukasz.UnionFlagsToGenerate;
import age.of.civilizations2.jakowski.lukasz.UnionFlagsToGenerate_TypesOfAction;
import age.of.civilizations2.jakowski.lukasz.Vassal_GameData;
import age.of.civilizations2.jakowski.lukasz.WarReparations;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Civilization {

    public List<Vassal_GameData> lVassals = new ArrayList<Vassal_GameData>();
    public int iMissiles = 0;
    public int iMissileProductionTurnsLeft = 0;
    public int getRecruitmentTurns() { return 1; }
    public void runStrategy() {
        if (this.civGD.autoAssimilation || this.civGD.autoHappiness || this.civGD.autoInvest || this.civGD.autoBuild) {
            boolean runHappi = this.civGD.autoHappiness && GameCalendar.TURNID % this.civGD.autoHappinessTurns == 0;
            boolean runInvest = this.civGD.autoInvest && GameCalendar.TURNID % this.civGD.autoInvestTurns == 0;
            boolean runBuild = this.civGD.autoBuild && GameCalendar.TURNID % this.civGD.autoBuildTurns == 0;
            boolean runAssi = this.civGD.autoAssimilation && GameCalendar.TURNID % 5 == 0;

            if (runAssi || runHappi || runInvest || runBuild) {
                for (int i = 0; i < this.getNumOfProvs(); i++) {
                    int provinceID = this.getProvID(i);
                    if (CFG.core.getProv(provinceID).getCivId() == this.getCivId() && !CFG.core.getProv(provinceID).isOccupied()) {
                        
                        
                        if (runAssi && CFG.core.getProv(provinceID).getProviStability() < this.civGD.autoAssimilationThreshold && this.isAssimilateOrganized_GET(provinceID) == null) {
                            long cost = GameManager.assimilateCost(provinceID, GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MAX);
                            if (this.getGold() >= cost) {
                                if (this.addAssimilate(new CivTask(provinceID, GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MAX))) {
                                    this.setGold(this.getGold() - cost);
                                    this.civGD.aACSG += cost;
                                    ++this.civGD.aACS;
                                }
                            }
                        }
                        
                        
                        if (runHappi && CFG.core.getProv(provinceID).getHappi() < this.civGD.autoHappinessThreshold && !this.isFestivalOrganized(provinceID)) {
                            long cost = Festival.festivalCost(provinceID);
                            if ((float)cost <= (float)this.getGold() * this.civGD.autoHappinessMaxMoney && this.getMovemPoints() >= GameValues.gvFestival.COST_FESTIVAL_MOVEMENT_POINTS) {
                                if (this.addFestival(new CivTask(provinceID, GameValues.gvFestival.FESTIVAL_NUM_OF_TURNS))) {
                                    this.setMovementPoints(this.getMovemPoints() - GameValues.gvFestival.COST_FESTIVAL_MOVEMENT_POINTS);
                                    this.setGold(this.getGold() - cost);
                                    ++this.civGD.fE;
                                    this.civGD.fECG += cost;
                                }
                            }
                        }
                        
                        
                        if (runInvest && !this.isInvestedDev(provinceID)) {
                            if (this.getMovemPoints() >= GameValues.gvInvestDevelopment.INVEST_DEVELOPMENT_MOVEMENT_POINTS && this.getTechLevel() > CFG.core.getProv(provinceID).getDeveLvl()) {
                                long investAmount = GameManager.investMaxDevGold(provinceID, this.getCivId());
                                long maxBudget = Math.max(500L, (long)((float)this.getGold() * this.civGD.autoInvestMaxMoney));
                                if (investAmount > 500L) {
                                    long toInvest = Math.min(investAmount, maxBudget);
                                    GameManager.investDevelopment(provinceID, this.getCivId(), toInvest);
                                }
                            }
                        }
                        
                        
                        if (runBuild) {
                            if (this.civGD.autoBuild_Farm && BuildingsManager.canBuildFarm(provinceID)) {
                                int moveCost = BuildingsManager.getFarm_BuildMovementCost(CFG.core.getProv(provinceID).getLvlOfFarm() + 1);
                                long goldCost = (long)BuildingsManager.getFarm_BuildCost(CFG.core.getProv(provinceID).getLvlOfFarm() + 1, provinceID);
                                if (this.getMovemPoints() >= moveCost && this.getGold() >= goldCost && this.isInConstruction(provinceID, ConstructionType.FARM) <= 0) {
                                    this.setMovementPoints(this.getMovemPoints() - moveCost);
                                    this.setGold(this.getGold() - goldCost);
                                    this.addNewConstruction(new BuildingsConstruction__Farm(provinceID, BuildingsManager.getFarm_Construction(CFG.core.getProv(provinceID).getLvlOfFarm() + 1)));
                                }
                            } else if (this.civGD.autoBuild_Workshop && BuildingsManager.canBuildWorkshop(provinceID)) {
                                int moveCost = BuildingsManager.getWorkshop_BuildMovementCost(CFG.core.getProv(provinceID).getLvlOfWorkshop() + 1);
                                long goldCost = (long)BuildingsManager.getWorkshop_BuildCost(CFG.core.getProv(provinceID).getLvlOfWorkshop() + 1, provinceID);
                                if (this.getMovemPoints() >= moveCost && this.getGold() >= goldCost && this.isInConstruction(provinceID, ConstructionType.WORKSHOP) <= 0) {
                                    this.setMovementPoints(this.getMovemPoints() - moveCost);
                                    this.setGold(this.getGold() - goldCost);
                                    this.addNewConstruction(new BuildingsConstruction__Workshop(provinceID, BuildingsManager.getWorkshop_Construction(CFG.core.getProv(provinceID).getLvlOfWorkshop() + 1)));
                                }
                            } else if (this.civGD.autoBuild_Library && BuildingsManager.canBuildLibrary(provinceID)) {
                                int moveCost = BuildingsManager.getLibrary_BuildMovementCost(CFG.core.getProv(provinceID).getLvlOfLibrary() + 1);
                                long goldCost = (long)BuildingsManager.getLibrary_BuildCost(CFG.core.getProv(provinceID).getLvlOfLibrary() + 1, provinceID);
                                if (this.getMovemPoints() >= moveCost && this.getGold() >= goldCost && this.isInConstruction(provinceID, ConstructionType.LIBRARY) <= 0) {
                                    this.setMovementPoints(this.getMovemPoints() - moveCost);
                                    this.setGold(this.getGold() - goldCost);
                                    this.addNewConstruction(new BuildingsConstruction__Library(provinceID, BuildingsManager.getLibrary_Construction(CFG.core.getProv(provinceID).getLvlOfLibrary() + 1)));
                                }
                            } else if (this.civGD.autoBuild_Port && BuildingsManager.canBuildPort(provinceID)) {
                                int moveCost = BuildingsManager.getPort_BuildMovementCost(CFG.core.getProv(provinceID).getLvlOfPort() + 1);
                                long goldCost = (long)BuildingsManager.getPort_BuildCost(CFG.core.getProv(provinceID).getLvlOfPort() + 1, provinceID);
                                if (this.getMovemPoints() >= moveCost && this.getGold() >= goldCost && this.isInConstruction(provinceID, ConstructionType.PORT) <= 0) {
                                    this.setMovementPoints(this.getMovemPoints() - moveCost);
                                    this.setGold(this.getGold() - goldCost);
                                    this.addNewConstruction(new BuildingsConstruction(provinceID, BuildingsManager.getPort_Construction(CFG.core.getProv(provinceID).getLvlOfPort() + 1)));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public void removeVassal(int iVassal) {
        for (int i = 0; i < lVassals.size(); i++) {
            if (lVassals.get(i).iCivID == iVassal) {
                lVassals.remove(i);
                break;
            }
        }
    }
    public void addVassal(int nCivA) {
        lVassals.add(new Vassal_GameData(nCivA));
    }
    public Vassal_GameData getVassal(int iVassal) {
        for (int i = 0; i < lVassals.size(); i++) {
            if (lVassals.get(i).iCivID == iVassal) return lVassals.get(i);
        }
        return new Vassal_GameData(0);
    }

    public final int getAllianceID() {
        return this.civGD.allianceID;
    }

    public final boolean isNeighbor(int civID) {
        return this.civNeighbors.isNeighbor(civID);
    }

    public Save_Civ_GameData civGD = new Save_Civ_GameData();
    public List<Integer> armyInAnotherProv = new ArrayList<Integer>();
    public int armyInAnotherProvinceSize = 0;
    public List<Integer> armiesPosition = new ArrayList<Integer>();
    public int armiesPositionSize = 0;
    public List<Integer> bordersWithWastelandProvsID = new ArrayList<Integer>();
    public List<Integer> bordersWithNeutralProvcsID = new ArrayList<Integer>();
    private List<Civilization_Region> civRegions = new ArrayList<Civilization_Region>();
    private int iCivRegionsSize;
    public long freeValue = 0L;
    private boolean isAvailable = true;
    private int movePoints;
    private int happiness;
    private int ideologyID = 0;
    public CivilizationsNeighbors civNeighbors = new CivilizationsNeighbors();
    private List<Character> lCivNameChars;
    private int iCivNameLength = 0;
    private int iCivNameWidth;
    private int iCivNameHeight;
    public boolean isFlagNearest = false;
    private Image civFlag = null;
    public boolean iFVS = false;
    private List<String> tagsCanForm = null;
    private List<String> blockedFormables = null;
    private List<Integer> lEventsToRun = new ArrayList<Integer>();
    private int numOfProvinces;
    private long numOfUnits;
    private List<Integer> provinces = new ArrayList<Integer>();
    private int iCivId;
    private boolean controlledByPlayer = false;
    public ConcurrentHashMap<Integer, DiplomacyData> guarantee = new ConcurrentHashMap();
    public List<Integer> iDMAS = new ArrayList<Integer>();
    private boolean updateRegions = false;
    public boolean uFOL = true;
    public int iLeague = 0;
    public long iBudget = 0;
    public long incomeTaxation = 0;
    public long incomeProduction = 0;
    public long administrationCosts = 0;
    public long iMilitaryUpkeep_Total = 0;
    public float iMilitaryUpkeep_PERC = 0.0f;
    public long iAveragePopulation = 0L;
    public List<Integer> provincesWithLowStability = new ArrayList<Integer>();
    public List<Integer> provincesWithLowHappiness = new ArrayList<Integer>();
    public List<Integer> lProvincesWithHighRevRisk = new ArrayList<Integer>();
    public float fStability = 1.0f;
    public float fAverageDevelopment = 1.0f;
    public int numOf_Forts = 0;
    public int numOf_Towers = 0;
    public int numOf_Ports = 0;
    public int numOf_Farms = 0;
    public int numOf_Farms_ProvincesPossibleToBuild = 0;
    public int numOf_Workshops = 0;
    public int numOf_Libraries = 0;
    public int numOf_Armories = 0;
    public int numOf_SuppliesCamp = 0;
    public int numOf_Markets = 0;
    public List<AI_CivsInRange> civsInRange = new ArrayList<AI_CivsInRange>();
    public float sanctionsImpact = 0.0f;
    private int seaAccess = 0;
    private List<Integer> seaAccessProvinces = new ArrayList<Integer>();
    private List<Integer> seaAccessPort = new ArrayList<Integer>();
    private int bordersWithEnemy = 0;
    public List<Integer> isAtWarWithCivs = new ArrayList<Integer>();
    private int iNumOfNeighboringNeutralProvinces = 0;
    public List<AI_Frontline> lFrontLines = new ArrayList<AI_Frontline>();
    private int iRankPosition = 1;
    private long iRankScore = 1;
    private List<MoveUnits> moveUnits;
    private int moveUnitsSize;
    private List<MoveUnits_Plunder> moveUnitsPlunder;
    private int moveUnits_PlunderSize;
    private List<GenocideOperation> genocideOperations;
    private int genocideOperationsSize;
    private List<List<MoveUnits_Line>> currentRegroupArmyLine = new ArrayList<List<MoveUnits_Line>>();

    public List<MoveUnits> lMigrate;
    public int iMigrateSize;
    public float RESPONSE_ALLIANCE_STRENGTH = 30.0f;
    public float RESPONSE_ALLIANCE_OPINION = 50.0f;
    public float TECH_POP = 1.0f;
    public float TECH_ECO = 1.0f;
    public float TECH_TAXATION = 1.0f;
    public float TECH_PRODUCTION = 1.0f;
    public float TECH_ADMINISTRATION = 1.0f;
    public float TECH_MILITARY_UPKEEP = 1.0f;
    public float TECH_MOVEMENT = 1.0f;
    public float TECH_ASSIMILATE = 1.0f;
    public float TECH_RESEARCH = 1.0f;
    public float TECH_RECRUITABLE = 1.0f;
    public float LIBERTY_ACCEPTABLE_TRIBUTE = 1.0f;
    public float LIBERTY_DECLARATION = 75.0f;
    public float VASSALS_TRIBUTE_PERC = 0.5f;
    public float VASSALS_TRIBUTE_PERC_RAND = 0.5f;
    public float VASSALS_TRIBUTE_PERC_FRIENDLY = 0.5f;
    public ConcurrentHashMap<Integer, DiplomacyData> truce = new ConcurrentHashMap();
    public ConcurrentHashMap<Integer, DiplomacyData> defensivePact = new ConcurrentHashMap();
    public String sCivName_UpperCase = "";
    public float[] colorFloat = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
    public ConcurrentHashMap<Integer, DiplomacyData> militaryAccess = new ConcurrentHashMap();
    public ConcurrentHashMap<Integer, DiplomacyData> nonAggressionPact = new ConcurrentHashMap();
    public float NEUTRAL_EXPAND_CAPITAL = 22.0f;
    public float NEUTRAL_EXPAND_OWN_PROVINCE = 10.0f;
    public float NEUTRAL_EXPAND_MORE_NEUTRAL = 4.0f;
    public float NEUTRAL_EXPAND_OTHER_CIV = 4.0f;
    public float NEUTRAL_EXPAND_GROWTH_RATE = 75.0f;
    public float NEUTRAL_EXPAND_LAST_PROVINCE = 75.0f;
    public float NEUTRAL_EXPAND_SEA_ACCESS = 20.0f;
    public float NEUTRAL_EXPAND_SEA_ACCESS_EXTRA = 3.0f;
    public float NEUTRAL_EXPAND_NEIGHBORING_PROVINCES = 3.0f;
    public float NEUTRAL_EXPAND_NEIGHBORING_PROVINCES_POTENTIAL = 25.0f;
    public int UNCIVILIZED_WILLING_TO_CIVILIZE = 50;
    public int UNCIVILIZED_MIGRATE = 50;
    public float RESPONSE_MILITARY_ACCESS_DISTANCE_SCORE = 20.0f;
    public float RESPONSE_MILITARY_ACCESS_RELATION_SCORE = 41.25f;
    public float RESPONSE_MILITARY_ACCESS_RANK_SCORE = 6.45f;
    public float RESPONSE_MILITARY_ACCESS_RANK_OWN_SCORE = 8.25f;
    public float RESPONSE_MILITARY_ACCESS_DEFENSIVE_PACT_SCORE = 5.75f;
    public float HRE_VOTE_FOR_RANK = 18.0f;
    public float HRE_VOTE_FOR_PROVINCES = 22.0f;

    public final float getSpendingResearchB() {
        return this.civGD.spendingsResearch;
    }

    public final void setSpendingResearchB(float fSpendings_Research) {
        if (this.getGold() < (long)GameValues.gvTechnology.MIN_MONEY_REQUIRED_TO_ENABLE_RESEARCH) {
            this.civGD.spendingsResearch = 0.0f;
        } else {
            if (!this.getIsPlayer() && (float)this.civGD.techLevel >= GameValues.gvTechnology.MAX_TECHNOLOGY_LEVEL * 100.0f) {
                this.civGD.spendingsResearch = 0.0f;
                return;
            }
            this.civGD.spendingsResearch = fSpendings_Research;
            if (this.civGD.spendingsResearch < 0.0f) {
                this.civGD.spendingsResearch = 0.0f;
            } else if (this.civGD.spendingsResearch > GameValues.gvInGame.getBudgetSpendingSliderMaxValue()) {
                this.civGD.spendingsResearch = GameValues.gvInGame.getBudgetSpendingSliderMaxValue();
            }
        }
    }

    public final float getSpendingInvestmentsB() {
        return this.civGD.spendingsInvestments;
    }

    public final void setSpendingInvestmentsB(float fSpendings_Investments) {
        this.civGD.spendingsInvestments = fSpendings_Investments;
        if (this.civGD.spendingsInvestments < 0.0f) {
            this.civGD.spendingsInvestments = 0.0f;
        } else if (this.civGD.spendingsInvestments > GameValues.gvInGame.getBudgetSpendingSliderMaxValue()) {
            this.civGD.spendingsInvestments = GameValues.gvInGame.getBudgetSpendingSliderMaxValue();
        }
    }

    public final void buildCivPersonality_MoreOften() {
        this.civGD.civPers.TAXATION_LEVEL = GameValues.gvAiCivPersonality.TAXATION_LEVEL_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.TAXATION_LEVEL_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.USE_OF_BUDGET_FOR_SPENDINGS = (float)CFG.oAI.getAIStyle((int)this.getAIStyleID()).USE_OF_BUDGET_FOR_SPENDINGS / 100.0f + (float)CFG.oR.nextInt(CFG.oAI.getAIStyle((int)this.getAIStyleID()).USE_OF_BUDGET_FOR_SPENDINGS_RANDOM * 10) / 1000.0f;
        this.civGD.civPers.GOODS_EXTRA_PERC_OF_BUDGET = GameValues.gvAiCivPersonality.GOODS_EXTRA_PERC_OF_BUDGET_BASE + (float)CFG.oR.nextInt(CFG.oAI.getAIStyle((int)this.getAIStyleID()).PERSONALITY_GOODS_RANDOM) / 100.0f;
        this.civGD.civPers.INVESTMENTS_EXTRA_PERC_OF_BUDGET = GameValues.gvAiCivPersonality.INVESTMENTS_EXTRA_PERC_OF_BUDGET_BASE + (float)CFG.oR.nextInt(CFG.oAI.getAIStyle((int)this.getAIStyleID()).PERSONALITY_INVESTMENTS_RANDOM) / 100.0f;
        this.civGD.civPers.RESEARCH_PERC_OF_BUDGET = GameValues.gvAiCivPersonality.RESEARCH_PERC_OF_BUDGET_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.RESEARCH_PERC_OF_BUDGET_RANDOM_100) / 100.0f + (float)CFG.oR.nextInt(CFG.oAI.getAIStyle((int)this.getAIStyleID()).PERSONALITY_RESEARCH_RANDOM) / 100.0f;
    }

    public final boolean setNonAggPact(int iID, int iNumOfTurns) {
        block8: {
            try {
                if (iNumOfTurns < 0) {
                    iNumOfTurns = 0;
                } else if (iNumOfTurns > GameValues.gvDipNonAggression.DIPLOMACY_MAX_NUMBER_OF_TURNS_NON_AGGRESSION_PACT) {
                    iNumOfTurns = GameValues.gvDipNonAggression.DIPLOMACY_MAX_NUMBER_OF_TURNS_NON_AGGRESSION_PACT;
                }
                try {
                    if (iNumOfTurns <= 0) {
                        this.nonAggressionPact.remove(iID);
                        break block8;
                    }
                    this.nonAggressionPact.put(iID, new DiplomacyData(iID, iNumOfTurns));
                }
                catch (Exception exception) {}
            }
            catch (Exception exception) {
                
            }
        }
        return false;
    }

    public Civilization(String nCivTag, int iR, int iG, int iB, int nCapitalProvinceID, int nCivID, int iReligionID, int iGroupID, boolean loadFlag) {
        this.setCivId(nCivID);
        this.civGD.iReligionID = iReligionID;
        this.civGD.iGroupID = iGroupID;
        this.initCivilization(nCivTag, iR, iG, iB, nCapitalProvinceID, loadFlag);
        this.civGD.policyID = GameValues.gvAdministrationPolicy.DEFAULT_POLICY_ID;
    }

    public Civilization(Save_Civ_GameData nCivData, int nCivID) {
        this.setCivId(nCivID);
        this.civGD = nCivData;
        this.updateColorFloat();
        this.setCivName(nCivData.sCivName);
        this.updateCivilizationIdeology();
        this.tagsCanForm = new ArrayList<String>();
        this.moveUnits = new ArrayList<MoveUnits>();
        this.moveUnitsSize = 0;
        this.moveUnitsPlunder = new ArrayList<MoveUnits_Plunder>();
        this.moveUnits_PlunderSize = 0;
        this.genocideOperations = new ArrayList<GenocideOperation>();
        this.genocideOperationsSize = 0;
        this.lMigrate = new ArrayList<MoveUnits>();
        this.iMigrateSize = 0;
        this.currentRegroupArmyLine.clear();
        this.controlledByPlayer = false;
        this.isAvailable = true;
        this.happiness = 75;
        this.lEventsToRun.clear();
        this.lEventsToRun = new ArrayList<Integer>();
        if (this.civGD.lEvents_DecisionsTaken == null) {
            this.civGD.lEvents_DecisionsTaken = new ArrayList<String>();
        }
        this.loadFlag();
        this.updateSanctionsImpact();
    }

    public final void addNewConstruction(BuildingsConstruction nConstruction) {
        for (int i = 0; i < this.civGD.lConstructions.size(); ++i) {
            if (this.civGD.lConstructions.get((int)i).iProviID != nConstruction.iProviID || this.civGD.lConstructions.get((int)i).constructionType != nConstruction.constructionType) continue;
            return;
        }
        this.civGD.lConstructions.add(nConstruction);
    }

    public final int getConstructionsSize() {
        return this.civGD.lConstructions.size();
    }

    public final BuildingsConstruction getConstruction(int i) {
        return this.civGD.lConstructions.get(i);
    }

    private final void initCivilization(String nCivTag, int iR, int iG, int iB, int nCapitalProvinceID, boolean loadFlag) {
        this.civGD.sCivTag = nCivTag;
        this.setCivName(CFG.lang.getCiv(nCivTag));
        this.updateCivilizationIdeology();
        this.civGD.iTurnsSinceLastAttack = 100;
        this.civGD.capitalProvinceID = nCapitalProvinceID;
        if (nCapitalProvinceID >= 0) {
            CFG.core.getProv(nCapitalProvinceID).setIsCapital(true);
        }
        this.civGD.iR = (short)iR;
        this.civGD.iG = (short)iG;
        this.civGD.iB = (short)iB;
        this.updateColorFloat();
        this.civGD.civDiploGD = new Civilization_Diplomacy_GameData();
        this.buildCivPersonality();
        this.tagsCanForm = new ArrayList<String>();
        this.civGD.loansTaken = new ArrayList<Loan_GameData>();
        this.civGD.lLoansTakenFromCiv = new ArrayList<LoanCiv_GameData>();
        this.civGD.lWarReparationsGets = new ArrayList<WarReparations>();
        this.civGD.warReparationsPay = new ArrayList<WarReparations>();
        this.moveUnits = new ArrayList<MoveUnits>();
        this.moveUnitsSize = 0;
        this.moveUnitsPlunder = new ArrayList<MoveUnits_Plunder>();
        this.moveUnits_PlunderSize = 0;
        this.civGD.lRegroupArmy = new ArrayList<RegroupArmy>();
        this.civGD.iRegroupArmySize = 0;
        this.lMigrate = new ArrayList<MoveUnits>();
        this.iMigrateSize = 0;
        this.currentRegroupArmyLine.clear();
        this.controlledByPlayer = false;
        this.isAvailable = true;
        this.civGD.techLevel = GameValues.gvTechnology.ADD_CIV_DEFAULT_TECH_LEVEL;
        this.happiness = 75;
        this.lEventsToRun.clear();
        this.lEventsToRun = new ArrayList<Integer>();
        this.civGD.lEvents_DecisionsTaken.clear();
        this.civGD.lEvents_DecisionsTaken = new ArrayList<String>();
        if (loadFlag) {
            this.loadFlag();
        }
    }

    public final void buildCivPersonality_AIAggression() {
        try {
            int randValue = (int)(GameCalendar.AI_AGGRESSIVENESS * GameValues.gvAiDeclareWar.PERSONALITY_AI_AGGRESSION_RANDOM * 1000.0f);
            this.civGD.civPers.AI_CIV_AGGRESSION = GameCalendar.AI_AGGRESSIVENESS * GameValues.gvAiDeclareWar.PERSONALITY_AI_AGGRESSION_MIN + (randValue <= 0 ? 0.0f : (float)CFG.oR.nextInt(randValue) / 1000.0f);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void buildCivPersonality() {
        this.civGD.civPers.WAR_CLOSE_REGION_PROVINCES = GameValues.gvAiCivPersonality.WAR_CLOSE_REGION_PROVINCES_MIN + CFG.oR.nextInt(GameValues.gvAiCivPersonality.WAR_CLOSE_REGION_PROVINCES_RANDOM);
        this.civGD.civPers.WAR_CLOSE_REGION_EXTRA_SCORE = GameValues.gvAiCivPersonality.WAR_CLOSE_REGION_SCORE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.WAR_CLOSE_REGION_SCORE_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY = CFG.oAI.getAIStyle((int)this.getAIStyleID()).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT + (float)CFG.oR.nextInt(CFG.oAI.getAIStyle((int)this.getAIStyleID()).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM) / 100.0f;
        this.buildCivPersonality_AIAggression();
        this.buildCivPersonality_MoreOften();
        this.civGD.civPers.TREASURY_RESERVE = GameValues.gvAiCivPersonality.TREASURY_RESERVE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.TREASURY_RESERVE_RANDOM_1000) / 100.0f;
        this.civGD.civPers.TREASURY_RESERVE_MODIFIER = GameValues.gvAiCivPersonality.TREASURY_RESERVE_MODIFIER_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.TREASURY_RESERVE_MODIFIER_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.WAR_POTENTIAL = GameValues.gvAiCivPersonality.WAR_POTENTIAL_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.WAR_POTENTIAL_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.WAR_DANGER = GameValues.gvAiCivPersonality.WAR_DANGER_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.WAR_DANGER_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.WAR_REGION_NUM_OF_PROVINCES = GameValues.gvAiCivPersonality.WAR_REGION_NUM_OF_PROVINCES_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.WAR_REGION_NUM_OF_PROVINCES_RANDOM_100) / 1000.0f;
        this.civGD.civPers.WAR_REGION_POTENTIAL = GameValues.gvAiCivPersonality.WAR_REGION_POTENTIAL_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.WAR_REGION_POTENTIAL_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.WAR_NUM_OF_UNITS = GameValues.gvAiCivPersonality.WAR_NUM_OF_UNITS_BASE - (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.WAR_NUM_OF_UNITS_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.WAR_ATTACK_NAVAL_DISTANCE = GameValues.gvAiCivPersonality.WAR_ATTACK_NAVAL_DISTANCE_BASE - (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.WAR_ATTACK_NAVAL_DISTANCE_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.WAR_ATTACK_DISTANCE = GameValues.gvAiCivPersonality.WAR_ATTACK_DISTANCE_BASE - (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.WAR_ATTACK_DISTANCE_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.WAR_ATTACK_SCORE_ARMY = Math.max(0.01f, GameValues.gvAiCivPersonality.WAR_ATTACK_SCORE_ARMY_BASE - (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.WAR_ATTACK_SCORE_ARMY_RANDOM_1000) / 1000.0f);
        this.civGD.civPers.WAR_ATTACK_SCORE_POTENTIAL = Math.max(0.01f, GameValues.gvAiCivPersonality.WAR_ATTACK_SCORE_POTENTIAL_BASE - (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.WAR_ATTACK_SCORE_POTENTIAL_RANDOM_1000) / 1000.0f);
        this.civGD.civPers.WAR_ATTACK_SCORE_WAS_CONQUERED = Math.max(0.01f, GameValues.gvAiCivPersonality.WAR_ATTACK_SCORE_WAS_CONQUERED_BASE - (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.WAR_ATTACK_SCORE_WAS_CONQUERED_RANDOM_1000) / 1000.0f);
        this.civGD.civPers.WAR_REGROUP_SPLIT_MIN = GameValues.gvAiCivPersonality.WAR_REGROUP_SPLIT_MIN_BASE + CFG.oR.nextInt(GameValues.gvAiCivPersonality.WAR_REGROUP_SPLIT_MIN_RANDOM);
        this.civGD.civPers.WAR_REGROUP_SPLIT_EXTRA = GameValues.gvAiCivPersonality.WAR_REGROUP_SPLIT_EXTRA_BASE + CFG.oR.nextInt(GameValues.gvAiCivPersonality.WAR_REGROUP_SPLIT_EXTRA_RANDOM);
        this.civGD.civPers.VALUABLE_POTENTIAL = GameValues.gvAiCivPersonality.VALUABLE_POTENTIAL_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.VALUABLE_POTENTIAL_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.VALUABLE_POTENTIAL_MODIFIED_OWN_LOST_PROVINCE = GameValues.gvAiCivPersonality.VALUABLE_POTENTIAL_MODIFIED_OWN_LOST_PROVINCE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.VALUABLE_POTENTIAL_MODIFIED_OWN_LOST_PROVINCE_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.VALUABLE_DANGER = GameValues.gvAiCivPersonality.VALUABLE_DANGER_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.VALUABLE_DANGER_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.VALUABLE_REGION_NUM_OF_PROVINCES = GameValues.gvAiCivPersonality.VALUABLE_REGION_NUM_OF_PROVINCES_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.VALUABLE_REGION_NUM_OF_PROVINCES_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.VALUABLE_REGION_POTENTIAL = GameValues.gvAiCivPersonality.VALUABLE_REGION_POTENTIAL_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.VALUABLE_REGION_POTENTIAL_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.VALUABLE_NUM_OF_UNITS = GameValues.gvAiCivPersonality.VALUABLE_NUM_OF_UNITS_BASE - (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.VALUABLE_NUM_OF_UNITS_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.VALUABLE_NUM_OF_UNITS_RECRUITMENT = GameValues.gvAiCivPersonality.VALUABLE_NUM_OF_UNITS_RECRUITMENT_BASE - (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.VALUABLE_NUM_OF_UNITS_RECRUITMENT_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.MIN_MILITARY_SPENDINGS = CFG.oAI.getAIStyle((int)this.getAIStyleID()).PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT + (float)CFG.oR.nextInt(CFG.oAI.getAIStyle((int)this.getAIStyleID()).PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM) / 100.0f;
        this.civGD.civPers.VALUABLE_RECRUIT_FROM_FAR_AWAY_CHANCE = GameValues.gvAiCivPersonality.VALUABLE_RECRUIT_FROM_FAR_AWAY_CHANCE_BASE + CFG.oR.nextInt(GameValues.gvAiCivPersonality.VALUABLE_RECRUIT_FROM_FAR_AWAY_CHANCE_RANDOM);
        this.civGD.civPers.MIN_MILITARY_SPENDINGS_RECRUIT_AT_WAR = GameValues.gvAiCivPersonality.MIN_MILITARY_SPENDINGS_RECRUIT_AT_WAR_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.MIN_MILITARY_SPENDINGS_RECRUIT_AT_WAR_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.MIN_MILITARY_SPENDINGS_NOT_BORDERING_WITH_ENEMY = GameValues.gvAiCivPersonality.MIN_MILITARY_SPENDINGS_NOT_BORDERING_WITH_ENEMY_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.MIN_MILITARY_SPENDINGS_NOT_BORDERING_WITH_ENEMY_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.MIN_HAPPINESS_FOR_CIV = CFG.oAI.getAIStyle((int)this.getAIStyleID()).PERSONALITY_MIN_HAPPINESS_DEFAULT + CFG.oR.nextInt(CFG.oAI.getAIStyle((int)this.getAIStyleID()).PERSONALITY_MIN_HAPPINESS_RANDOM);
        this.civGD.civPers.MIN_MILITARY_SPENDINGS_WAR_MODIFIER = GameValues.gvAiCivPersonality.MIN_MILITARY_SPENDINGS_WAR_MODIFIER_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.MIN_MILITARY_SPENDINGS_WAR_MODIFIER_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.MIN_PROVINCE_HAPPINESS_RUN_FESTIVAL = GameValues.gvRebels.RISE_REVOLT_RISK_IN_PROVINCE_IF_HAPPINESS_BELOW + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.MIN_PROVINCE_HAPPINESS_RUN_FESTIVAL_RANDOM_100) / 100.0f;
        this.civGD.civPers.MIN_PROVINCE_STABILITY = this.getIsPlayer() ? 0.71f : GameValues.gvAiCivPersonality.MIN_PROVINCE_STABILITY_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.MIN_PROVINCE_STABILITY_RANDOM_100) / 100.0f;
        this.civGD.civPers.MIN_RESEARCH_SPENDINGS = -1.0f;
        this.civGD.civPers.ASSIMILATE_PERC_DISTANCE_SCORE = GameValues.gvAiCivPersonality.ASSIMILATE_PERC_DISTANCE_SCORE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.ASSIMILATE_PERC_DISTANCE_SCORE_RANDOM_100) / 100.0f;
        this.civGD.civPers.ASSIMILATE_PERC_LOW_STABILITY_SCORE = GameValues.gvAiCivPersonality.ASSIMILATE_PERC_LOW_STABILITY_SCORE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.ASSIMILATE_PERC_LOW_STABILITY_SCORE_RANDOM_100) / 100.0f;
        this.civGD.civPers.ASSIMILATE_PERC_POPULATION_SCORE = GameValues.gvAiCivPersonality.ASSIMILATE_PERC_POPULATION_SCORE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.ASSIMILATE_PERC_POPULATION_SCORE_RANDOM_100) / 100.0f;
        this.civGD.civPers.BUILD_STABILITY_SCORE = GameValues.gvAiCivPersonality.BUILD_STABILITY_SCORE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_STABILITY_SCORE_RANDOM_100) / 100.0f;
        this.civGD.civPers.BUILD_DANGER_SCORE = GameValues.gvAiCivPersonality.BUILD_DANGER_SCORE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_DANGER_SCORE_RANDOM_100) / 100.0f;
        this.buildCivPersonality_Buildings();
        this.buildCivPersonality_Colonization();
        this.civGD.civPers.POTENTIAL_POPULATION = GameValues.gvAiCivPersonality.POTENTIAL_POPULATION_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.POTENTIAL_POPULATION_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.POTENTIAL_ECONOMY = GameValues.gvAiCivPersonality.POTENTIAL_ECONOMY_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.POTENTIAL_ECONOMY_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.DANGER_EXTRA_KEY_REGION = GameValues.gvAiCivPersonality.DANGER_EXTRA_KEY_REGION_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.DANGER_EXTRA_KEY_REGION_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.DANGER_EXTRA_PER_OWN_PROVINCE = GameValues.gvAiCivPersonality.DANGER_EXTRA_PER_OWN_PROVINCE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.DANGER_EXTRA_PER_OWN_PROVINCE_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.DANGER_PERC_OF_UNITS = GameValues.gvAiCivPersonality.DANGER_PERC_OF_UNITS_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.DANGER_PERC_OF_UNITS_RANDOM_1000) / 1000.0f;
        this.buildCivPersonality_NonSavable();
    }

    public final void buildCivPersonality_NonSavable() {
        this.NEUTRAL_EXPAND_CAPITAL = GameValues.gvAiCivPersonality.NEUTRAL_EXPAND_CAPITAL_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.NEUTRAL_EXPAND_CAPITAL_RANDOM_1000) / 1000.0f;
        this.NEUTRAL_EXPAND_OWN_PROVINCE = GameValues.gvAiCivPersonality.NEUTRAL_EXPAND_OWN_PROVINCE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.NEUTRAL_EXPAND_OWN_PROVINCE_RANDOM_1000) / 1000.0f;
        this.NEUTRAL_EXPAND_MORE_NEUTRAL = GameValues.gvAiCivPersonality.NEUTRAL_EXPAND_MORE_NEUTRAL_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.NEUTRAL_EXPAND_MORE_NEUTRAL_RANDOM_1000) / 1000.0f;
        this.NEUTRAL_EXPAND_OTHER_CIV = GameValues.gvAiCivPersonality.NEUTRAL_EXPAND_OTHER_CIV_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.NEUTRAL_EXPAND_OTHER_CIV_RANDOM_1000) / 1000.0f;
        this.NEUTRAL_EXPAND_GROWTH_RATE = GameValues.gvAiCivPersonality.NEUTRAL_EXPAND_GROWTH_RATE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.NEUTRAL_EXPAND_GROWTH_RATE_RANDOM_1000) / 1000.0f;
        this.NEUTRAL_EXPAND_LAST_PROVINCE = GameValues.gvAiCivPersonality.NEUTRAL_EXPAND_LAST_PROVINCE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.NEUTRAL_EXPAND_LAST_PROVINCE_RANDOM_1000) / 1000.0f;
        this.NEUTRAL_EXPAND_SEA_ACCESS = GameValues.gvAiCivPersonality.NEUTRAL_EXPAND_SEA_ACCESS_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.NEUTRAL_EXPAND_SEA_ACCESS_RANDOM_1000) / 1000.0f;
        this.NEUTRAL_EXPAND_SEA_ACCESS_EXTRA = GameValues.gvAiCivPersonality.NEUTRAL_EXPAND_SEA_ACCESS_EXTRA_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.NEUTRAL_EXPAND_SEA_ACCESS_EXTRA_RANDOM) / 1000.0f;
        this.NEUTRAL_EXPAND_NEIGHBORING_PROVINCES = GameValues.gvAiCivPersonality.NEUTRAL_EXPAND_NEIGHBORING_PROVINCES_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.NEUTRAL_EXPAND_NEIGHBORING_PROVINCES_RANDOM) / 1000.0f;
        this.NEUTRAL_EXPAND_NEIGHBORING_PROVINCES_POTENTIAL = GameValues.gvAiCivPersonality.NEUTRAL_EXPAND_NEIGHBORING_PROVINCES_POTENTIAL_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.NEUTRAL_EXPAND_NEIGHBORING_PROVINCES_POTENTIAL_RANDOM) / 1000.0f;
        this.UNCIVILIZED_MIGRATE = GameValues.gvAiCivPersonality.UNCIVILIZED_MIGRATE_BASE + CFG.oR.nextInt(GameValues.gvAiCivPersonality.UNCIVILIZED_MIGRATE_RANDOM);
        this.UNCIVILIZED_WILLING_TO_CIVILIZE = GameValues.gvAiCivPersonality.UNCIVILIZED_WILLING_TO_CIVILIZE_BASE + CFG.oR.nextInt(GameValues.gvAiCivPersonality.UNCIVILIZED_WILLING_TO_CIVILIZE_RANDOM);
        this.RESPONSE_MILITARY_ACCESS_DISTANCE_SCORE = GameValues.gvAiCivPersonality.RESPONSE_MILITARY_ACCESS_DISTANCE_SCORE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.RESPONSE_MILITARY_ACCESS_DISTANCE_SCORE_RANDOM_100) / 100.0f;
        this.RESPONSE_MILITARY_ACCESS_RELATION_SCORE = GameValues.gvAiCivPersonality.RESPONSE_MILITARY_ACCESS_RELATION_SCORE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.RESPONSE_MILITARY_ACCESS_RELATION_SCORE_RANDOM);
        this.RESPONSE_MILITARY_ACCESS_RANK_SCORE = GameValues.gvAiCivPersonality.RESPONSE_MILITARY_ACCESS_RANK_SCORE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.RESPONSE_MILITARY_ACCESS_RANK_SCORE_RANDOM_10) / 10.0f;
        this.RESPONSE_MILITARY_ACCESS_RANK_OWN_SCORE = GameValues.gvAiCivPersonality.RESPONSE_MILITARY_ACCESS_RANK_OWN_SCORE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.RESPONSE_MILITARY_ACCESS_RANK_OWN_SCORE_RANDOM_10) / 10.0f;
        this.RESPONSE_MILITARY_ACCESS_DEFENSIVE_PACT_SCORE = GameValues.gvAiCivPersonality.RESPONSE_MILITARY_ACCESS_DEFENSIVE_PACT_SCORE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.RESPONSE_MILITARY_ACCESS_DEFENSIVE_PACT_SCORE_RANDOM_10) / 10.0f;
        this.HRE_VOTE_FOR_RANK = GameValues.gvAiCivPersonality.HRE_VOTE_FOR_RANK_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.HRE_VOTE_FOR_RANK_RANDOM);
        this.HRE_VOTE_FOR_PROVINCES = GameValues.gvAiCivPersonality.HRE_VOTE_FOR_PROVINCES_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.HRE_VOTE_FOR_PROVINCES_RANDOM);
        this.RESPONSE_ALLIANCE_OPINION = GameValues.gvAiCivPersonality.RESPONSE_ALLIANCE_OPINION_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.RESPONSE_ALLIANCE_OPINION_RANDOM_10) / 10.0f;
        this.RESPONSE_ALLIANCE_STRENGTH = GameValues.gvAiCivPersonality.RESPONSE_ALLIANCE_STRENGTH_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.RESPONSE_ALLIANCE_STRENGTH_RANDOM_10) / 10.0f;
        this.TECH_POP = GameValues.gvAiCivPersonality.TECH_POP_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.TECH_POP_RANDOM_100) / 100.0f;
        this.TECH_ECO = GameValues.gvAiCivPersonality.TECH_ECO_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.TECH_ECO_RANDOM_100) / 100.0f;
        this.TECH_TAXATION = GameValues.gvAiCivPersonality.TECH_TAXATION_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.TECH_TAXATION_RANDOM_100) / 100.0f;
        this.TECH_PRODUCTION = GameValues.gvAiCivPersonality.TECH_PRODUCTION_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.TECH_PRODUCTION_RANDOM_100) / 100.0f;
        this.TECH_ADMINISTRATION = GameValues.gvAiCivPersonality.TECH_ADMINISTRATION_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.TECH_ADMINISTRATION_RANDOM_100) / 100.0f;
        this.TECH_MILITARY_UPKEEP = GameValues.gvAiCivPersonality.TECH_MILITARY_UPKEEP_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.TECH_MILITARY_UPKEEP_RANDOM_100) / 100.0f;
        this.TECH_MOVEMENT = GameValues.gvAiCivPersonality.TECH_MOVEMENT_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.TECH_MOVEMENT_RANDOM_100) / 100.0f;
        this.TECH_RESEARCH = GameValues.gvAiCivPersonality.TECH_RESEARCH_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.TECH_RESEARCH_RANDOM_100) / 100.0f;
        this.TECH_ASSIMILATE = GameValues.gvAiCivPersonality.TECH_ASSIMILATE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.TECH_ASSIMILATE_RANDOM_100) / 100.0f;
        this.TECH_RECRUITABLE = GameValues.gvAiCivPersonality.TECH_RECRUITABLE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.TECH_RECRUITABLE_RANDOM_100) / 100.0f;
        this.LIBERTY_DECLARATION = GameValues.gvAiCivPersonality.LIBERTY_DECLARATION_BASE + CFG.oR.nextInt(GameValues.gvAiCivPersonality.LIBERTY_DECLARATION_RANDOM);
        this.LIBERTY_ACCEPTABLE_TRIBUTE = GameValues.gvAiCivPersonality.LIBERTY_ACCEPTABLE_TRIBUTE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.LIBERTY_ACCEPTABLE_TRIBUTE_RANDOM_100) / 100.0f;
        this.VASSALS_TRIBUTE_PERC = GameValues.gvAiCivPersonality.VASSALS_TRIBUTE_PERC_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.VASSALS_TRIBUTE_PERC_RANDOM_100) / 100.0f;
        this.VASSALS_TRIBUTE_PERC_RAND = GameValues.gvAiCivPersonality.VASSALS_TRIBUTE_PERC_RAND_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.VASSALS_TRIBUTE_PERC_RAND_RANDOM_100) / 100.0f;
        this.VASSALS_TRIBUTE_PERC_FRIENDLY = GameValues.gvAiCivPersonality.VASSALS_TRIBUTE_PERC_FRIENDLY_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.VASSALS_TRIBUTE_PERC_FRIENDLY_RANDOM_100) / 100.0f;
    }

    public final void buildCivPersonality_Colonization() {
        this.civGD.civPers.COLONIZATION_SEA = GameValues.gvAiCivPersonality.COLONIZATION_SEA_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.COLONIZATION_SEA_RANDOM) / (float)Math.max(this.civGD.coloniesFounded.size(), 1);
        this.civGD.civPers.COLONIZATION_OWN_PROVINCES = GameValues.gvAiCivPersonality.COLONIZATION_OWN_PROVINCES_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.COLONIZATION_OWN_PROVINCES_RANDOM);
        this.civGD.civPers.COLONIZATION_GROWTH_RATE = GameValues.gvAiCivPersonality.COLONIZATION_GROWTH_RATE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.COLONIZATION_GROWTH_RATE_RANDOM);
        this.civGD.civPers.COLONIZATION_DISTANCE = GameValues.gvAiCivPersonality.COLONIZATION_DISTANCE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.COLONIZATION_DISTANCE_RANDOM);
    }

    public final void buildCivPersonality_Buildings() {
        this.civGD.civPers.BUILD_FORT = GameValues.gvAiCivPersonality.BUILD_FORT_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_FORT_RANDOM_100) / 100.0f;
        this.civGD.civPers.BUILD_TOWER = GameValues.gvAiCivPersonality.BUILD_TOWER_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_TOWER_RANDOM_100) / 100.0f;
        this.civGD.civPers.BUILD_PORT = GameValues.gvAiCivPersonality.BUILD_PORT_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_PORT_RANDOM_100) / 100.0f;
        this.civGD.civPers.BUILD_FARM = GameValues.gvAiCivPersonality.BUILD_FARM_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_FARM_RANDOM_100) / 100.0f;
        this.civGD.civPers.BUILD_WORKSHOP = GameValues.gvAiCivPersonality.BUILD_WORKSHOP_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_WORKSHOP_RANDOM_100) / 100.0f;
        this.civGD.civPers.BUILD_WORKSHOP_POP_SCORE = GameValues.gvAiCivPersonality.BUILD_WORKSHOP_POP_SCORE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_WORKSHOP_POP_SCORE_RANDOM_100) / 100.0f;
        this.civGD.civPers.BUILD_WORKSHOP_ECO_SCORE = GameValues.gvAiCivPersonality.BUILD_WORKSHOP_ECO_SCORE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_WORKSHOP_ECO_SCORE_RANDOM_100) / 100.0f;
        this.civGD.civPers.BUILD_MARKET = GameValues.gvAiCivPersonality.BUILD_MARKET_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_MARKET_RANDOM_100) / 100.0f;
        this.civGD.civPers.BUILD_MARKET_POP_SCORE = GameValues.gvAiCivPersonality.BUILD_MARKET_POP_SCORE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_MARKET_POP_SCORE_RANDOM_100) / 100.0f;
        this.civGD.civPers.BUILD_MARKET_ECO_SCORE = GameValues.gvAiCivPersonality.BUILD_MARKET_ECO_SCORE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_MARKET_ECO_SCORE_RANDOM_100) / 100.0f;
        this.civGD.civPers.BUILD_LIBRARY = GameValues.gvAiCivPersonality.BUILD_LIBRARY_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_LIBRARY_RANDOM_100) / 100.0f;
        this.civGD.civPers.BUILD_ARMOURY = GameValues.gvAiCivPersonality.BUILD_ARMOURY_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_ARMOURY_RANDOM_100) / 100.0f;
        this.civGD.civPers.BUILD_ARMOURY_RECRUITABLE_SCORE = GameValues.gvAiCivPersonality.BUILD_ARMOURY_RECRUITABLE_SCORE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_ARMOURY_RECRUITABLE_SCORE_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.BUILD_SUPPLYLINE = GameValues.gvAiCivPersonality.BUILD_SUPPLYLINE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_SUPPLYLINE_RANDOM_100) / 100.0f;
        this.civGD.civPers.BUILD_INVEST = GameValues.gvAiCivPersonality.BUILD_INVEST_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_INVEST_RANDOM_100) / 100.0f;
        this.civGD.civPers.BUILD_INVEST_DEVELOPMENT = GameValues.gvAiCivPersonality.BUILD_INVEST_DEVELOPMENT_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_INVEST_DEVELOPMENT_RANDOM_100) / 100.0f;
        this.civGD.civPers.BUILD_INVEST_POP_SCORE = GameValues.gvAiCivPersonality.BUILD_INVEST_POP_SCORE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_INVEST_POP_SCORE_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.BUILD_INVEST_DEVELOPMENT_SCORE = GameValues.gvAiCivPersonality.BUILD_INVEST_DEVELOPMENT_SCORE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_INVEST_DEVELOPMENT_SCORE_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.BUILD_INVEST_POP_ECO_DIFFERENCE_SCORE = GameValues.gvAiCivPersonality.BUILD_INVEST_POP_ECO_DIFFERENCE_SCORE_BASE + (float)CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_INVEST_POP_ECO_DIFFERENCE_SCORE_RANDOM_1000) / 1000.0f;
        this.civGD.civPers.BUILD_INVEST_SECOND_INVEST_MAX_PERC = GameValues.gvAiCivPersonality.BUILD_INVEST_SECOND_INVEST_MAX_PERC_BASE + CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_INVEST_SECOND_INVEST_MAX_PERC_RANDOM);
        this.civGD.civPers.BUILD_INVEST_SECOND_INVEST_CHANCE = GameValues.gvAiCivPersonality.BUILD_INVEST_SECOND_INVEST_CHANCE_BASE + CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_INVEST_SECOND_INVEST_CHANCE_RANDOM);
        this.civGD.civPers.BUILD_RESERVE_RAND = GameValues.gvAiCivPersonality.BUILD_RESERVE_RAND_BASE + CFG.oR.nextInt(GameValues.gvAiCivPersonality.BUILD_RESERVE_RAND_RANDOM);
    }

    public final void createCivilizationRegion(int nProvinceID) {
        this.civRegions.add(new Civilization_Region(nProvinceID, this.iCivRegionsSize));
        this.iCivRegionsSize = this.civRegions.size();
        CFG.core.getProv(nProvinceID).setCivRegionID(this.iCivRegionsSize - 1);
        CFG.core.getProv((int)nProvinceID).wasInProv = true;
        this.buildCivilizationRegion(nProvinceID, this.iCivRegionsSize - 1);
        for (int i = 0; i < this.getNumOfProvs(); ++i) {
            CFG.core.getProv((int)this.getProvID((int)i)).wasInProv = false;
        }
    }

    private final void buildCivilizationRegion(int nProvinceID, int nCivRegionID) {
        for (int i = 0; i < CFG.core.getProv(nProvinceID).getNeighProvincesSize(); ++i) {
            if (CFG.core.getProv(CFG.core.getProv(nProvinceID).getNeighProvinces(i)).getCivId() != this.iCivId || CFG.core.getProv((int)CFG.core.getProv((int)nProvinceID).getNeighProvinces((int)i)).wasInProv) continue;
            CFG.core.getProv((int)CFG.core.getProv((int)nProvinceID).getNeighProvinces((int)i)).wasInProv = true;
            this.civRegions.get(nCivRegionID).addProvince(CFG.core.getProv(nProvinceID).getNeighProvinces(i));
            CFG.core.getProv(CFG.core.getProv(nProvinceID).getNeighProvinces(i)).setCivRegionID(nCivRegionID);
            this.buildCivilizationRegion(CFG.core.getProv(nProvinceID).getNeighProvinces(i), nCivRegionID);
        }
    }

    public final boolean civRegionsContainsProvince(int nProvinceID) {
        for (int i = 0; i < this.iCivRegionsSize; ++i) {
            if (!this.civRegions.get(i).containsProvince(nProvinceID)) continue;
            return true;
        }
        return false;
    }

    private final void removeCivRegionID(int id) {
        int i;
        for (i = 0; i < this.civRegions.get(id).getProvincesSize(); ++i) {
            CFG.core.getProv(this.civRegions.get(id).getProvince(i)).setCivRegionID(-1);
        }
        this.civRegions.remove(id);
        this.iCivRegionsSize = this.civRegions.size();
        for (i = 0; i < this.iCivRegionsSize; ++i) {
            this.civRegions.get(i).setRegionID(i);
        }
    }

    public final void clearCivRegions() {
        for (int i = 0; i < this.getNumOfProvs(); ++i) {
            CFG.core.getProv(this.getProvID(i)).setCivRegionID(-1);
        }
        this.civRegions.clear();
        this.iCivRegionsSize = 0;
    }

    public final void updateCivilizationIdeology(String nCivTag, int iR, int iG, int iB) {
        this.setCivTag(nCivTag);
        this.civGD.iR = (short)iR;
        this.civGD.iG = (short)iG;
        this.civGD.iB = (short)iB;
        this.updateColorFloat();
        this.updateCivilizationIdeology();
        Core.addSimpleTask(new Core.SimpleTask("loadFlag_" + this.getCivId(), this.getCivId()){

            @Override
            public void update() {
                CFG.core.getCiv(this.id).loadFlag();
            }
        });
    }

    public final void updateCivilizationIdeology() {
        this.setIdeology(CFG.ideologiesMgr.getIdeologyID(this.getCivTag()));
    }

    public final void buildDiplomacy(boolean buildRelations) {
        if (buildRelations) {
            this.civGD.relation.clear();
        }
        this.guarantee.clear();
        this.militaryAccess.clear();
        this.nonAggressionPact.clear();
        this.truce.clear();
        this.defensivePact.clear();
        if (buildRelations) {
            this.civGD.allianceID = 0;
        }
    }

    public final void updateDiplomacy_AfterRemoveCivilization_Relations(int nIDToRemove) {
        ConcurrentHashMap<Integer, DiplomacyData> nList;
        try {
            ConcurrentHashMap<Integer, Float> nRelation = new ConcurrentHashMap<Integer, Float>();
            for (Map.Entry<Integer, Float> entry : this.civGD.relation.entrySet()) {
                if (entry.getKey() > nIDToRemove) {
                    nRelation.put(entry.getKey() - 1, entry.getValue());
                    continue;
                }
                if (entry.getKey() == nIDToRemove) continue;
                nRelation.put(entry.getKey(), entry.getValue());
            }
            this.civGD.relation = nRelation;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            nList = new ConcurrentHashMap<Integer, DiplomacyData>();
            for (Map.Entry<Integer, DiplomacyData> entry : this.guarantee.entrySet()) {
                if (entry.getKey() > nIDToRemove) {
                    nList.put(entry.getKey() - 1, new DiplomacyData(((DiplomacyData)entry.getValue()).iCivID - 1, ((DiplomacyData)entry.getValue()).iTurnID));
                    continue;
                }
                if (entry.getKey() == nIDToRemove) continue;
                nList.put(entry.getKey(), (DiplomacyData)entry.getValue());
            }
            this.guarantee = nList;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            nList = new ConcurrentHashMap();
            for (Map.Entry<Integer, DiplomacyData> entry : this.militaryAccess.entrySet()) {
                if (entry.getKey() > nIDToRemove) {
                    nList.put(entry.getKey() - 1, new DiplomacyData(((DiplomacyData)entry.getValue()).iCivID - 1, ((DiplomacyData)entry.getValue()).iTurnID));
                    continue;
                }
                if (entry.getKey() == nIDToRemove) continue;
                nList.put(entry.getKey(), (DiplomacyData)entry.getValue());
            }
            this.militaryAccess = nList;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void updateRevolutionaryTransition() {
        if (this.numOfProvinces > 0 && CFG.ideologiesMgr.getIdeologyID(this.getIdeology()).REVOLUTIONARY) {
            this.civGD.iTurnsSinceLastAttack--;
            if (this.civGD.iTurnsSinceLastAttack <= 0) {
                Gdx.app.postRunnable(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            for (int i = 0; i < CFG.ideologiesMgr.getIdeologiesSize(); i++) {
                                if (!CFG.ideologiesMgr.getIdeologyID(i).REVOLUTIONARY) {
                                    Civilization.this.setIdeology(i);
                                    Civilization.this.civGD.iTurnsSinceLastAttack = 100;
                                    Civilization.this.setCivName(CFG.lang.getCiv(Civilization.this.getCivTag()));
                                    break;
                                }
                            }
                        } catch (Exception ex) {}
                    }
                });
            }
        } else {
            this.civGD.iTurnsSinceLastAttack = 100;
        }
    }

    public final Color getRGB() {
        return this.getRGB(1.0f);
    }

    public final Color getRGB(float nAlpha) {
        return new Color((float)this.getR() / 255.0f, (float)this.getG() / 255.0f, (float)this.getB() / 255.0f, nAlpha);
    }

    public final Color getColor(float fAlpha) {
        return this.getRGB(fAlpha);
    }

    public final int getMovemPoints() {
        return this.movePoints;
    }

    public final void setMovementPoints(int iMovePoints) {
        this.movePoints = iMovePoints;
    }

    public final long getGold() {
        return this.civGD.iGold;
    }

    public final void setGold(long iMoney) {
        this.civGD.iGold = iMoney;
    }

    public final int getCapitalProvID() {
        return this.civGD.capitalProvinceID;
    }

    public final void setCapitalProvID(int iCapitalProvinceID) {
        this.civGD.capitalProvinceID = iCapitalProvinceID;
    }

    public final int getCoreCapitalProvID() {
        return this.civGD.coreCapitalProvinceID;
    }

    public final void setCoreCapitalProvID(int iCoreCapitalProvinceID) {
        this.civGD.coreCapitalProvinceID = iCoreCapitalProvinceID;
    }

    public final int getCapitalMoved_LastTurnID() {
        return this.civGD.capitalMoved_LastTurnID;
    }

    public final void setCapitalMoved_LastTurnID(int iCapitalMoved_LastTurnID) {
        this.civGD.capitalMoved_LastTurnID = iCapitalMoved_LastTurnID;
    }

    public final void updateDiplomacyAfterRemoveCiv(int nIDToRemove) {
        ConcurrentHashMap<Integer, DiplomacyData> nList;
        try {
            nList = new ConcurrentHashMap<Integer, DiplomacyData>();
            for (Map.Entry<Integer, DiplomacyData> entry : this.truce.entrySet()) {
                if (entry.getKey() > nIDToRemove) {
                    nList.put(entry.getKey() - 1, new DiplomacyData(entry.getValue().iCivID - 1, entry.getValue().iTurnID));
                    continue;
                }
                if (entry.getKey() == nIDToRemove) continue;
                nList.put(entry.getKey(), entry.getValue());
            }
            this.truce = nList;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            nList = new ConcurrentHashMap();
            for (Map.Entry<Integer, DiplomacyData> entry : this.nonAggressionPact.entrySet()) {
                if (entry.getKey() > nIDToRemove) {
                    nList.put(entry.getKey() - 1, new DiplomacyData(entry.getValue().iCivID - 1, entry.getValue().iTurnID));
                    continue;
                }
                if (entry.getKey() == nIDToRemove) continue;
                nList.put(entry.getKey(), entry.getValue());
            }
            this.nonAggressionPact = nList;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            nList = new ConcurrentHashMap();
            for (Map.Entry<Integer, DiplomacyData> entry : this.defensivePact.entrySet()) {
                if (entry.getKey() > nIDToRemove) {
                    nList.put(entry.getKey() - 1, new DiplomacyData(entry.getValue().iCivID - 1, entry.getValue().iTurnID));
                    continue;
                }
                if (entry.getKey() == nIDToRemove) continue;
                nList.put(entry.getKey(), entry.getValue());
            }
            this.defensivePact = nList;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void updateDiplomacy_AfterAddingCivilization() {
    }

    public final void newMove(int fromProvinceID, int toProvinceID, long nNumOfUnits, boolean buildLine) {
        this.moveUnits.add(new MoveUnits(fromProvinceID, toProvinceID, nNumOfUnits, buildLine));
        this.moveUnitsSize = this.moveUnits.size();
    }

    public final void addResearchProgressT(float fAdd) {
        this.civGD.researchProgress += fAdd;
    }

    public final void setResearchProgressT(float fResearchProgress) {
        this.civGD.researchProgress = fResearchProgress;
    }

    public final void clearMoveUnits() {
        this.moveUnits.clear();
        this.moveUnitsSize = 0;
    }

    public final void newMigrate(int fromProvinceID, int toProvinceID, boolean buildLine) {
        for (int i = 0; i < this.iMigrateSize; ++i) {
            if (this.lMigrate.get(i).getFromProviID() != fromProvinceID) continue;
            this.removeMigrate(i);
            this.setMovementPoints(this.getMovemPoints() + CFG.ideologiesMgr.getIdeologyID((int)this.getIdeology()).COST_OF_MOVE);
            break;
        }
        this.lMigrate.add(new MoveUnits(fromProvinceID, toProvinceID, CFG.core.getProv(fromProvinceID).getPop().getPops(), buildLine, true));
        this.iMigrateSize = this.lMigrate.size();
    }

    public final void removeMigrate(int i) {
        this.lMigrate.remove(i);
        this.iMigrateSize = this.lMigrate.size();
    }

    public final void clearMigrate() {
        this.lMigrate.clear();
        this.iMigrateSize = this.lMigrate.size();
    }

    public final boolean migratesFromProvinceID(int nProvinceID) {
        for (int i = 0; i < this.iMigrateSize; ++i) {
            if (this.lMigrate.get(i).getFromProviID() != nProvinceID) continue;
            return true;
        }
        return false;
    }

    public final void newPlunder(int fromProvinceID, long nNumOfUnits) {
        for (int i = 0; i < this.moveUnits_PlunderSize; ++i) {
            if (this.moveUnitsPlunder.get(i).getFromProvinceID() != fromProvinceID) continue;
            this.moveUnitsPlunder.get(i).setNumOfUnits(nNumOfUnits);
            return;
        }
        this.moveUnitsPlunder.add(new MoveUnits_Plunder(fromProvinceID, nNumOfUnits));
        this.moveUnits_PlunderSize = this.moveUnitsPlunder.size();
    }

    public final void removePlunder(int i) {
        this.moveUnitsPlunder.remove(i);
        this.moveUnits_PlunderSize = this.moveUnitsPlunder.size();
    }

    public final void removePlunder_ProvinceID(int nProvinceID) {
        for (int i = 0; i < this.moveUnits_PlunderSize; ++i) {
            if (this.moveUnitsPlunder.get(i).getFromProvinceID() != nProvinceID) continue;
            CFG.core.getProv(this.moveUnitsPlunder.get(i).getFromProvinceID()).updateArmy4(this.getCivId(), CFG.core.getProv(this.moveUnitsPlunder.get(i).getFromProvinceID()).getArmyCivID1(this.getCivId()) + this.moveUnitsPlunder.get(i).getNumOfUnits());
            this.moveUnitsPlunder.remove(i);
            this.moveUnits_PlunderSize = this.moveUnitsPlunder.size();
            return;
        }
    }

    public final void clearMoveUnits_Plunder() {
        this.moveUnitsPlunder.clear();
        this.moveUnits_PlunderSize = this.moveUnitsPlunder.size();
    }

    public final boolean isPlundred(int nProvinceID) {
        for (int i = 0; i < this.moveUnits_PlunderSize; ++i) {
            if (this.moveUnitsPlunder.get(i).getFromProvinceID() != nProvinceID) continue;
            return true;
        }
        return false;
    }

    public final void newGenocideOperation(int nProvinceID, int targetCivID, long nArmy, long totalPopToRemove, float effectivePower, float resistancePower, long currentArmy) {
        if (this.genocideOperations == null) {
            this.genocideOperations = new ArrayList<GenocideOperation>();
            this.genocideOperationsSize = 0;
        }
        for (int i = 0; i < this.genocideOperationsSize; ++i) {
            if (this.genocideOperations.get(i).getProvinceID() != nProvinceID || this.genocideOperations.get(i).getTargetCivID() != targetCivID) continue;
            this.genocideOperations.remove(i);
            this.genocideOperationsSize = this.genocideOperations.size();
            break;
        }
        float ratio = resistancePower > 0.0f ? effectivePower / resistancePower : 10.0f;
        ratio = Math.max(GameValues.gvGenocide.POWER_MIN_RATIO, Math.min(GameValues.gvGenocide.POWER_MAX_RATIO, ratio));
        int turns = (int)Math.ceil((float)GameValues.gvGenocide.TURNS_BASE / Math.max(0.25f, Math.min(4.0f, ratio)));
        if (turns < 1) turns = 1;
        this.genocideOperations.add(new GenocideOperation(this.getCivId(), nProvinceID, targetCivID, nArmy, totalPopToRemove, turns, effectivePower, resistancePower, currentArmy));
        this.genocideOperationsSize = this.genocideOperations.size();
    }

    public final int getGenocideOperationsSize() {
        return this.genocideOperations == null ? 0 : this.genocideOperationsSize;
    }

    public final GenocideOperation getGenocideOperation(int i) {
        return this.genocideOperations == null ? null : this.genocideOperations.get(i);
    }

    public final void removeGenocideOperation(int i) {
        if (this.genocideOperations == null) return;
        this.genocideOperations.remove(i);
        this.genocideOperationsSize = this.genocideOperations.size();
    }

    public final void removeGenocideOperation_ProvinceID(int nProvinceID) {
        if (this.genocideOperations == null) return;
        for (int i = 0; i < this.genocideOperationsSize; ++i) {
            if (this.genocideOperations.get(i).getProvinceID() != nProvinceID) continue;
            this.genocideOperations.remove(i);
            this.genocideOperationsSize = this.genocideOperations.size();
            return;
        }
    }

    public final boolean isGenociding(int nProvinceID) {
        if (this.genocideOperations == null) return false;
        for (int i = 0; i < this.genocideOperationsSize; ++i) {
            if (this.genocideOperations.get(i).getProvinceID() != nProvinceID) continue;
            return true;
        }
        return false;
    }

    public final boolean hasActiveGenocideOperations() {
        return this.genocideOperations != null && this.genocideOperationsSize > 0;
    }

    public final void clearGenocideOperations() {
        if (this.genocideOperations == null) return;
        this.genocideOperations.clear();
        this.genocideOperationsSize = this.genocideOperations.size();
    }

    public final boolean addFestival(CivTask nFestival) {
        for (int i = 0; i < this.civGD.festivals.size(); ++i) {
            if (nFestival.iProvinceID != this.civGD.festivals.get((int)i).iProvinceID) continue;
            return false;
        }
        this.civGD.festivals.add(nFestival);
        return true;
    }

    public final CivTask getFestival(int i) {
        return this.civGD.festivals.get(i);
    }

    public final void removeFestival(int i) {
        this.civGD.festivals.remove(i);
    }

    public final void removeFestival_ProvinceID(int nProvinceID) {
        for (int i = 0; i < this.civGD.festivals.size(); ++i) {
            if (nProvinceID != this.civGD.festivals.get((int)i).iProvinceID) continue;
            this.civGD.festivals.remove(i);
            break;
        }
    }

    public final void runFestivals() {
        for (int i = 0; i < this.civGD.festivals.size(); ++i) {
            if (CFG.core.getProv(this.civGD.festivals.get((int)i).iProvinceID).getCivId() == this.getCivId() || CFG.core.getCiv(CFG.core.getProv(this.civGD.festivals.get((int)i).iProvinceID).getCivId()).getPuppetOfCiv() == this.getCivId()) {
                --this.civGD.festivals.get((int)i).iTurnsLeft;
                CFG.core.getProv(this.civGD.festivals.get((int)i).iProvinceID).setHappi(CFG.core.getProv(this.civGD.festivals.get((int)i).iProvinceID).getHappi() + Festival.festivalHappinessPerTurn(this.civGD.festivals.get((int)i).iProvinceID));
                for (int j = 0; j < CFG.core.getProv(this.civGD.festivals.get((int)i).iProvinceID).getNeighProvincesSize(); ++j) {
                    CFG.core.getProv(CFG.core.getProv(this.civGD.festivals.get((int)i).iProvinceID).getNeighProvinces(j)).setHappi(CFG.core.getProv(CFG.core.getProv(this.civGD.festivals.get((int)i).iProvinceID).getNeighProvinces(j)).getHappi() + Festival.festivalHappinessPerTurn_NeighboringProvinces());
                }
                if (this.civGD.festivals.get((int)i).iTurnsLeft > 0) continue;
                if (CFG.core.getCiv(this.iCivId).getIsPlayer()) {
                    CFG.core.getCiv((int)this.iCivId).getCivDiploGD().messageBox.addMessage(new Message_FestivalIsOver(this.iCivId, this.civGD.festivals.get((int)i).iProvinceID));
                }
                this.civGD.festivals.remove(i--);
                continue;
            }
            this.civGD.festivals.remove(i--);
        }
    }

    public final boolean isFestivalOrganized(int nProvinceID) {
        for (int i = 0; i < this.civGD.festivals.size(); ++i) {
            if (nProvinceID != this.civGD.festivals.get((int)i).iProvinceID) continue;
            return true;
        }
        return false;
    }

    public final CivTask isFestivalOrganized_GET(int nProvinceID) {
        for (int i = 0; i < this.civGD.festivals.size(); ++i) {
            if (nProvinceID != this.civGD.festivals.get((int)i).iProvinceID) continue;
            return this.civGD.festivals.get(i);
        }
        return null;
    }

    public final int isFestivalOrganized_TurnsLeft(int nProvinceID) {
        for (int i = 0; i < this.civGD.festivals.size(); ++i) {
            if (nProvinceID != this.civGD.festivals.get((int)i).iProvinceID) continue;
            return this.civGD.festivals.get((int)i).iTurnsLeft;
        }
        return 0;
    }

    public final int getFestivalsSize() {
        return this.civGD.festivals.size();
    }

    public final boolean addAssimilate(CivTask civTask) {
        for (int i = 0; i < this.civGD.assimilates.size(); ++i) {
            if (civTask.iProvinceID != this.civGD.assimilates.get((int)i).iProvinceID) continue;
            return false;
        }
        this.civGD.assimilates.add(civTask);
        return true;
    }

    public final CivTask getAssimilate(int i) {
        return this.civGD.assimilates.get(i);
    }

    public final void removeAssimilate(int i) {
        this.civGD.assimilates.remove(i);
    }

    public final void removeAssimilate_ProvinceID(int nProvinceID) {
        for (int i = 0; i < this.civGD.assimilates.size(); ++i) {
            if (nProvinceID != this.civGD.assimilates.get((int)i).iProvinceID) continue;
            this.civGD.assimilates.remove(i);
            break;
        }
    }

    public final void runAssimilates() {
        for (int i = 0; i < this.civGD.assimilates.size(); ++i) {
            if (CFG.core.getProv(this.civGD.assimilates.get((int)i).iProvinceID).getCivId() == this.getCivId() || CFG.core.getCiv(CFG.core.getProv(this.civGD.assimilates.get((int)i).iProvinceID).getCivId()).getPuppetOfCiv() == this.getCivId()) {
                --this.civGD.assimilates.get((int)i).iTurnsLeft;
                float popToAssimilate = 0.0f;
                float ownerPop = 1.0f + CFG.core.getProv(this.civGD.assimilates.get((int)i).iProvinceID).getPop().getPopulationOfCivID(this.getCivId());
                for (int j = 0; j < CFG.core.getProv(this.civGD.assimilates.get((int)i).iProvinceID).getPop().getNatsSize(); ++j) {
                    if (CFG.core.getProv(this.civGD.assimilates.get((int)i).iProvinceID).getPop().getCivID(j) == CFG.core.getProv(this.civGD.assimilates.get((int)i).iProvinceID).getCivId()) continue;
                    popToAssimilate += (float)CFG.core.getProv(this.civGD.assimilates.get((int)i).iProvinceID).getPop().getPopulationID(j);
                }
                float assimilatedPop = 0.0f;
                float tCurrentPopChange = 0.0f;
                for (int j = CFG.core.getProv(this.civGD.assimilates.get((int)i).iProvinceID).getPop().getNatsSize() - 1; j >= 0; --j) {
                    if (CFG.core.getProv(this.civGD.assimilates.get((int)i).iProvinceID).getPop().getCivID(j) == CFG.core.getProv(this.civGD.assimilates.get((int)i).iProvinceID).getCivId()) continue;
                    float tPerc = (GameValues.gvAssimilate.BASE_ASSIMILATION_RATE + (GameValues.gvAssimilate.ASSIMILATION_SCALING_BASE + (float)CFG.oR.nextInt(GameValues.gvAssimilate.ASSIMILATION_SCALING_RANDOM_10000) / 10000.0f) * (ownerPop / (popToAssimilate + ownerPop)) * CFG.core.getProv(this.civGD.assimilates.get((int)i).iProvinceID).getHappi() * Math.min(1.0f - CFG.core.getProv(this.civGD.assimilates.get((int)i).iProvinceID).getDeveLvl() / GameValues.gvAssimilate.ASSIMILATION_DEVELOPMENT_DIVIDER, 1.0f)) * (1.0f - GameValues.gvAssimilate.ASSIMILATION_INSTABILITY_PENALTY * (1.0f - CFG.core.getCiv(this.getCivId()).getStabilityCiv()) - GameValues.gvAssimilate.ASSIMILATION_REVOLUTION_RISK_PENALTY * CFG.core.getProv(this.civGD.assimilates.get((int)i).iProvinceID).getRevRisk()) * GameValues.gvAssimilate.ASSIMILATION_FINAL_MULTIPLIER * CFG.ASSIMILATION_SPEED_MODIFIER;
                    if (this.civGD.assimilates.get((int)i).armyStabilization) {
                        tPerc *= this.civGD.assimilates.get((int)i).armyStabilizationRate > 0.0f ? this.civGD.assimilates.get((int)i).armyStabilizationRate : 0.5f;
                    }
                    tCurrentPopChange = (float)CFG.core.getProv(this.civGD.assimilates.get((int)i).iProvinceID).getPop().getPopulationID(j) * tPerc;
                    if (tCurrentPopChange < 1.0f) {
                        tCurrentPopChange = (float)CFG.oR.nextInt(2);
                    }
                    assimilatedPop += tCurrentPopChange;
                    CFG.core.getProv(this.civGD.assimilates.get((int)i).iProvinceID).getPop().setPopulationOfCivID(CFG.core.getProv(this.civGD.assimilates.get((int)i).iProvinceID).getPop().getCivID(j), (int)((float)CFG.core.getProv(this.civGD.assimilates.get((int)i).iProvinceID).getPop().getPopulationID(j) - tCurrentPopChange));
                }
                CFG.core.getProv(this.civGD.assimilates.get((int)i).iProvinceID).getPop().setPopulationOfCivID(this.getCivId(), (int)((float)CFG.core.getProv(this.civGD.assimilates.get((int)i).iProvinceID).getPop().getPopulationOfCivID(this.getCivId()) + assimilatedPop));
                float armyStabilizationRate = this.civGD.assimilates.get((int)i).armyStabilizationRate > 0.0f ? this.civGD.assimilates.get((int)i).armyStabilizationRate : 0.5f;
                CFG.core.getProv(this.civGD.assimilates.get((int)i).iProvinceID).setHappi(CFG.core.getProv(this.civGD.assimilates.get((int)i).iProvinceID).getHappi() + GameValues.gvAssimilate.ASSIMILATE_HAPPINESS_CHANGE_PER_TURN * (this.civGD.assimilates.get((int)i).armyStabilization ? armyStabilizationRate : 1.0f));
                if (this.civGD.assimilates.get((int)i).iTurnsLeft > 0) continue;
                if (CFG.core.getCiv(this.iCivId).getIsPlayer()) {
                    CFG.core.getCiv((int)this.iCivId).getCivDiploGD().messageBox.addMessage(new Message_AssimilationEnd(this.iCivId, this.civGD.assimilates.get((int)i).iProvinceID));
                }
                this.civGD.assimilates.remove(i--);
                continue;
            }
            this.civGD.assimilates.remove(i--);
        }
    }

    public final CivTask isAssimilateOrganized_GET(int nProvinceID) {
        for (int i = 0; i < this.civGD.assimilates.size(); ++i) {
            if (nProvinceID != this.civGD.assimilates.get((int)i).iProvinceID) continue;
            return this.civGD.assimilates.get(i);
        }
        return null;
    }

    public final int getAssimilatesSize() {
        return this.civGD.assimilates.size();
    }

    public final boolean addInvest(CivInvest nInvest) {
        for (int i = 0; i < this.civGD.investsEco.size(); ++i) {
            if (nInvest.provinceID != this.civGD.investsEco.get((int)i).provinceID) continue;
            return false;
        }
        this.civGD.investsEco.add(nInvest);
        return true;
    }

    public final boolean addInvest_2(CivInvest nInvest) {
        for (int i = 0; i < this.civGD.investsEco.size(); ++i) {
            if (nInvest.provinceID != this.civGD.investsEco.get((int)i).provinceID) continue;
            this.civGD.investsEco.get((int)i).iEconomyLeft += nInvest.iEconomyLeft;
            this.civGD.investsEco.get((int)i).turnsLeft = nInvest.turnsLeft;
            this.civGD.investsEco.get((int)i).iEconomyPerTurn += this.civGD.investsEco.get((int)i).iEconomyLeft / (float)this.civGD.investsEco.get((int)i).turnsLeft;
            return true;
        }
        this.civGD.investsEco.add(nInvest);
        return true;
    }

    public final boolean isInvested(int id) {
        try {
            for (int i = 0; i < this.civGD.investsEco.size(); ++i) {
                if (id != this.civGD.investsEco.get((int)i).provinceID) continue;
                return true;
            }
        }
        catch (Exception exception) {
            
        }
        return false;
    }

    public final boolean isInvestedDev(int id) {
        try {
            for (int i = 0; i < this.civGD.investsDev.size(); ++i) {
                if (id != this.civGD.investsDev.get((int)i).provinceID) continue;
                return true;
            }
        }
        catch (Exception exception) {
            
        }
        return false;
    }

    public final void runRecruitArmyNT() {
        if (this.civGD.recruitArmy == null) {
            this.civGD.recruitArmy = new ArrayList<RecruitArmy>();
            this.civGD.recruitArmySize = 0;
            return;
        }
        try {
            for (int i = 0; i < this.civGD.recruitArmySize; ++i) {
                try {
                    this.civGD.recruitArmy.get(i).setTurnsLeft(this.civGD.recruitArmy.get(i).getTurnsLeft() - 1);
                    if (this.civGD.recruitArmy.get(i).getTurnsLeft() > 0) continue;

                    if (CFG.core.getProv(this.civGD.recruitArmy.get(i).getProvinceID()).getCivId() == this.getCivId()) {
                        CFG.gameAction.recruitArmy(this.civGD.recruitArmy.get(i).getProvinceID(), this.civGD.recruitArmy.get(i).getArmy(), this.getCivId());
                    } else {
                        CFG.core.getCiv(this.getCivId()).setGold(CFG.core.getCiv(this.getCivId()).getGold() + (long)((int)((float)(this.civGD.recruitArmy.get(i).getArmy() * CFG.gCARR(this.civGD.recruitArmy.get(i).getProvinceID(), this.getCivId())) * GameValues.gvArmyRecruit.RECRUIT_ARMY_PROVINCE_LOST_RETURN_PERC_GOLD)));
                    }

                    if (this.getIsPlayer() && CFG.RECRUIT_AND_COUNTERATTACK) {
                        ArrayList<Integer> counterProvinces = new ArrayList<Integer>();
                        for (int a = 0; a < CFG.core.getProv(this.civGD.recruitArmy.get(i).getProvinceID()).getNeighProvincesSize(); ++a) {
                            if (CFG.core.getProv(CFG.core.getProv(this.civGD.recruitArmy.get(i).getProvinceID()).getNeighProvinces(a)).getCivId() == this.getCivId() || CFG.core.getProv(CFG.core.getProv(this.civGD.recruitArmy.get(i).getProvinceID()).getNeighProvinces(a)).getTrueOwnerOfProv() != this.getCivId() || !CFG.core.getCivsAtWar(this.getCivId(), CFG.core.getProv(CFG.core.getProv(this.civGD.recruitArmy.get(i).getProvinceID()).getNeighProvinces(a)).getCivId())) continue;
                            counterProvinces.add(CFG.core.getProv(this.civGD.recruitArmy.get(i).getProvinceID()).getNeighProvinces(a));
                        }
                        if (!counterProvinces.isEmpty()) {
                            long perMove = this.civGD.recruitArmy.get(i).getArmy() / counterProvinces.size();
                            int moved = 0;
                            for (int a = counterProvinces.size() - 1; a >= 0; --a) {
                                this.newMove(this.civGD.recruitArmy.get(i).getProvinceID(), (Integer)counterProvinces.get(a), a == 0 ? Math.max(0, this.civGD.recruitArmy.get(i).getArmy() - moved) : perMove, true);
                                moved += perMove;
                            }
                        }
                    }
                    this.civGD.recruitArmy.remove(i--);
                    this.civGD.recruitArmySize = this.civGD.recruitArmy.size();
                }
                catch (Exception exception) {
                    
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public final void removeMove(int i) {
        this.moveUnits.remove(i);
        this.moveUnitsSize = this.moveUnits.size();
    }

    public final void runConstructions() {
        for (int i = 0; i < this.civGD.lConstructions.size(); ++i) {
            if (CFG.core.getProv(this.civGD.lConstructions.get((int)i).iProviID).getCivId() != this.getCivId() && CFG.core.getCiv(CFG.core.getProv(this.civGD.lConstructions.get((int)i).iProviID).getCivId()).getPuppetOfCiv() != this.getCivId()) {
                this.civGD.lConstructions.remove(i--);
                continue;
            }
            --this.civGD.lConstructions.get((int)i).iNumOfTurnsLeft;
            if (this.civGD.lConstructions.get((int)i).iNumOfTurnsLeft > 0) continue;
            this.civGD.lConstructions.get(i).onConstructedRun(this.getCivId());
            this.civGD.lConstructions.remove(i--);
        }
    }

    public final boolean addInvest_Development(CivInvest_Development nInvest) {
        for (int i = 0; i < this.civGD.investsDev.size(); ++i) {
            if (nInvest.provinceID != this.civGD.investsDev.get((int)i).provinceID) continue;
            return false;
        }
        this.civGD.investsDev.add(nInvest);
        return true;
    }

    public final CivInvest_Development getInvest_Development(int i) {
        return this.civGD.investsDev.get(i);
    }

    public final void removeInvest_Development(int i) {
        this.civGD.investsDev.remove(i);
    }

    public final void removeInvest_ProvinceID_Development(int nProvinceID) {
        for (int i = 0; i < this.civGD.investsDev.size(); ++i) {
            if (nProvinceID != this.civGD.investsDev.get((int)i).provinceID) continue;
            this.civGD.investsDev.remove(i);
            break;
        }
    }

    public final void runInvests_Development() {
        for (int i = 0; i < this.civGD.investsDev.size(); ++i) {
            if (CFG.core.getProv(this.civGD.investsDev.get((int)i).provinceID).getCivId() == this.getCivId() || CFG.core.getCiv(CFG.core.getProv(this.civGD.investsDev.get((int)i).provinceID).getCivId()).getPuppetOfCiv() == this.getCivId()) {
                --this.civGD.investsDev.get((int)i).turnsLeft;
                float ecoToAdd = Math.min(this.civGD.investsDev.get((int)i).iDevelopmentPerTurn, this.civGD.investsDev.get((int)i).iDevelopmentLeft);
                if (this.civGD.investsDev.get((int)i).turnsLeft == 0) {
                    ecoToAdd = this.civGD.investsDev.get((int)i).iDevelopmentLeft;
                }
                CFG.core.getProv(this.civGD.investsDev.get((int)i).provinceID).setDevLvl(CFG.core.getProv(this.civGD.investsDev.get((int)i).provinceID).getDeveLvl() + ecoToAdd);
                this.civGD.investsDev.get((int)i).iDevelopmentLeft -= ecoToAdd;
                if (this.civGD.investsDev.get((int)i).turnsLeft > 0 && !(this.civGD.investsDev.get((int)i).iDevelopmentLeft <= 0.0f)) continue;
                if (CFG.core.getCiv(this.iCivId).getIsPlayer()) {
                    CFG.core.getCiv((int)this.iCivId).getCivDiploGD().messageBox.addMessage(new Message_InvestDone_Development(this.iCivId, this.civGD.investsDev.get((int)i).provinceID));
                }
                this.civGD.investsDev.remove(i--);
                continue;
            }
            this.civGD.investsDev.remove(i--);
        }
    }

    public final int isInvestOrganized_TurnsLeft(int nProvinceID) {
        for (int i = 0; i < this.civGD.investsEco.size(); ++i) {
            if (nProvinceID != this.civGD.investsEco.get((int)i).provinceID) continue;
            return this.civGD.investsEco.get((int)i).turnsLeft;
        }
        return 0;
    }

    public final CivInvest isInvestOrganized_GET(int nProvinceID) {
        for (int i = 0; i < this.civGD.investsEco.size(); ++i) {
            if (nProvinceID != this.civGD.investsEco.get((int)i).provinceID) continue;
            return this.civGD.investsEco.get(i);
        }
        return null;
    }

    public final long isInvestOrganized_EconomyLeft(int nProvinceID) {
        for (int i = 0; i < this.civGD.investsEco.size(); ++i) {
            if (nProvinceID != this.civGD.investsEco.get((int)i).provinceID) continue;
            return (long)this.civGD.investsEco.get((int)i).iEconomyLeft;
        }
        return 0;
    }

    public final float isInvestOrganized_EconomyLeft_Development(int nProvinceID) {
        for (int i = 0; i < this.civGD.investsDev.size(); ++i) {
            if (nProvinceID != this.civGD.investsDev.get((int)i).provinceID) continue;
            return this.civGD.investsDev.get((int)i).iDevelopmentLeft;
        }
        return 0.0f;
    }

    public final int getInvestsSize_Development() {
        return this.civGD.investsDev.size();
    }

    public final void addVassalN(int nCivID) {
        for (int i = 0; i < this.civGD.vassals.size(); ++i) {
            if (this.civGD.vassals.get((int)i).iCivID != nCivID) continue;
            return;
        }
        this.civGD.vassals.add(new Vassal_GameData(nCivID));
        this.civGD.iVassalsSize = this.civGD.vassals.size();
    }

    public final void removeVassalN(int nCivID) {
        for (int i = 0; i < this.civGD.vassals.size(); ++i) {
            if (this.civGD.vassals.get((int)i).iCivID != nCivID) continue;
            this.civGD.vassals.remove(i);
            this.civGD.iVassalsSize = this.civGD.vassals.size();
            return;
        }
    }

    public final int getVassal_Tribute(int nCivID) {
        for (int i = 0; i < this.civGD.vassals.size(); ++i) {
            if (this.civGD.vassals.get((int)i).iCivID != nCivID) continue;
            return this.civGD.vassals.get((int)i).iTribute;
        }
        this.civGD.vassals.add(new Vassal_GameData(nCivID));
        this.civGD.iVassalsSize = this.civGD.vassals.size();
        return GameValues.gvVassal.PERCENTAGE_OF_INCOME_FOR_LORD_DEFAULT;
    }

    public final void runInvests() {
        for (int i = 0; i < this.civGD.investsEco.size(); ++i) {
            if (CFG.core.getProv(this.civGD.investsEco.get((int)i).provinceID).getCivId() == this.getCivId() || CFG.core.getCiv(CFG.core.getProv(this.civGD.investsEco.get((int)i).provinceID).getCivId()).getPuppetOfCiv() == this.getCivId()) {
                --this.civGD.investsEco.get((int)i).turnsLeft;
                long ecoToAdd = (long)Math.min(this.civGD.investsEco.get((int)i).iEconomyPerTurn, this.civGD.investsEco.get((int)i).iEconomyLeft);
                if (this.civGD.investsEco.get((int)i).turnsLeft == 0) {
                    ecoToAdd = (long)this.civGD.investsEco.get((int)i).iEconomyLeft;
                }
                CFG.core.getProv(this.civGD.investsEco.get((int)i).provinceID).setEco(CFG.core.getProv(this.civGD.investsEco.get((int)i).provinceID).getEco() + ecoToAdd);
                this.civGD.investsEco.get((int)i).iEconomyLeft -= ecoToAdd;
                if (this.civGD.investsEco.get((int)i).turnsLeft > 0 && this.civGD.investsEco.get((int)i).iEconomyLeft > 0) continue;
                if (CFG.core.getCiv(this.iCivId).getIsPlayer()) {
                    CFG.core.getCiv((int)this.iCivId).getCivDiploGD().messageBox.addMessage(new Message_InvestDone(this.iCivId, this.civGD.investsEco.get((int)i).provinceID));
                }
                this.civGD.investsEco.remove(i--);
                continue;
            }
            this.civGD.investsEco.remove(i--);
        }
    }

    public final boolean isInvestOrganized(int nProvinceID) {
        for (int i = 0; i < this.civGD.investsEco.size(); ++i) {
            if (nProvinceID != this.civGD.investsEco.get((int)i).provinceID) continue;
            return true;
        }
        return false;
    }

    public final int isInConstruction(int nProvinceID, ConstructionType nType) {
        for (int i = 0; i < this.civGD.lConstructions.size(); ++i) {
            if (this.civGD.lConstructions.get((int)i).iProviID != nProvinceID || this.civGD.lConstructions.get((int)i).constructionType != nType) continue;
            return this.civGD.lConstructions.get((int)i).iNumOfTurnsLeft;
        }
        return 0;
    }

    public final void clearConstructions() {
        this.civGD.lConstructions.clear();
    }

    public final boolean recruitArmy_AI(int nProvinceID, long nArmy) {
        if (this.civGD.recruitArmy == null) {
            this.civGD.recruitArmy = new ArrayList<RecruitArmy>();
            this.civGD.recruitArmySize = 0;
        }
        for (int i = 0; i < this.civGD.recruitArmySize; ++i) {
            if (this.civGD.recruitArmy.get(i).getProvinceID() != nProvinceID) continue;
            return this.recruitArmy(nProvinceID, Math.max(this.civGD.recruitArmy.get(i).getArmy(), nArmy));
        }
        return this.recruitArmy(nProvinceID, nArmy);
    }

    public final void removeRecruitArmy(int i) {
        if (this.civGD.recruitArmy == null) {
            this.civGD.recruitArmy = new ArrayList<RecruitArmy>();
            this.civGD.recruitArmySize = 0;
            return;
        }
        this.civGD.recruitArmy.remove(i);
        this.civGD.recruitArmySize = this.civGD.recruitArmy.size();
    }

    public final void clearRecruitArmy() {
        if (this.civGD.recruitArmy == null) {
            this.civGD.recruitArmy = new ArrayList<RecruitArmy>();
            this.civGD.recruitArmySize = 0;
            return;
        }
        this.civGD.recruitArmy.clear();
        this.civGD.recruitArmySize = this.civGD.recruitArmy.size();
    }

    public final int getSentMessagesSize() {
        return this.civGD.sentMessages.size();
    }

    public final Civilization_SentMessages getSentMessage(int i) {
        return this.civGD.sentMessages.get(i);
    }

    public final float getStabilityCiv() {
        return this.fStability;
    }

    public final void setStabilityCiv(float nStability) {
        this.fStability = Math.min(Math.max(nStability, 0.01f), 1.0f);
    }

    public int getReligionID() {
        return this.civGD.iReligionID;
    }

    public void setReligionID(int religionID) {
        this.civGD.iReligionID = religionID;
    }

    public int getGroupID() {
        return this.civGD.iGroupID;
    }

    public void setGroupID(int groupID) {
        this.civGD.iGroupID = groupID;
    }

    public final void addGift_Received(int iCivID) {
        for (int i = this.civGD.lGifts_Received.size() - 1; i >= 0; --i) {
            if (this.civGD.lGifts_Received.get((int)i).iFromCivID != iCivID) continue;
            this.civGD.lGifts_Received.get((int)i).iTurnID = GameCalendar.TURNID;
            return;
        }
        this.civGD.lGifts_Received.add(new Civ_Gift_GameData(iCivID, GameCalendar.TURNID));
    }

    public final void updateGift_Received() {
        for (int i = this.civGD.lGifts_Received.size() - 1; i >= 0; --i) {
            if (this.civGD.lGifts_Received.get((int)i).iTurnID + GameValues.gvGift.GIFT_INFO_EXPIRATION_TURNS >= GameCalendar.TURNID) continue;
            this.civGD.lGifts_Received.remove(i);
        }
    }

    public final void buildRegroupLines_AfterLoading() {
        for (int j = 0; j < this.civGD.iRegroupArmySize; ++j) {
            ArrayList<MoveUnits_Line> tMoveUnitsLine = new ArrayList<MoveUnits_Line>();
            tMoveUnitsLine.add(new MoveUnits_Line_Highlighted(this.civGD.lRegroupArmy.get(j).getFromProvinceID(), this.civGD.lRegroupArmy.get(j).getRoute(0)));
            for (int i = 0; i < this.civGD.lRegroupArmy.get(j).getRouteSize() - 1; ++i) {
                tMoveUnitsLine.add(new MoveUnits_Line_Highlighted(this.civGD.lRegroupArmy.get(j).getRoute(i), this.civGD.lRegroupArmy.get(j).getRoute(i + 1)));
            }
            this.currentRegroupArmyLine.add(tMoveUnitsLine);
        }
    }

    public final void addRegroupArmy(RegroupArmy nData) {
        this.civGD.lRegroupArmy.add(nData);
        this.civGD.iRegroupArmySize = this.civGD.lRegroupArmy.size();
        ArrayList<MoveUnits_Line> tMoveUnitsLine = new ArrayList<MoveUnits_Line>();
        tMoveUnitsLine.add(new MoveUnits_Line_Highlighted(nData.getFromProvinceID(), nData.getRoute(0)));
        for (int i = 0; i < nData.getRouteSize() - 1; ++i) {
            tMoveUnitsLine.add(new MoveUnits_Line_Highlighted(nData.getRoute(i), nData.getRoute(i + 1)));
        }
        this.currentRegroupArmyLine.add(tMoveUnitsLine);
    }

    public final void removeTagsCanForm(int i) {
        this.tagsCanForm.remove(i);
    }

    public final void removeTagsCanForm(String nTag) {
        for (int i = 0; i < this.tagsCanForm.size(); ++i) {
            if (!this.tagsCanForm.get(i).equals(nTag)) continue;
            this.tagsCanForm.remove(i);
            return;
        }
    }

    public final float getResearchProgressT() {
        return this.civGD.researchProgress;
    }

    public final boolean getIsPartOfHolyRomanEmpire() {
        return this.civGD.isPartOfHolyRomaEmpire;
    }

    public final void setIsPartOfHolyRomanEmpire(boolean isPartOfHolyRomaEmpire) {
        this.civGD.isPartOfHolyRomaEmpire = isPartOfHolyRomaEmpire;
    }

    public final void runNextEvent2() {
        try {
            if (this.getIsPlayer()) {
                if (this.getEventsToRunSize() > 0) {
                    Menu_InGame_Event.EVENT_ID = this.getEventsToRun(0);
                    this.removeEventToRun(0);
                    CFG.menus.rebuildInGame_Event();
                }
            } else {
                for (int i = this.getEventsToRunSize() - 1; i >= 0; --i) {
                    try {
                        int decistionTaken = 0;
                        int tempAIChanceTotal = 0;
                        for (int j = 0; j < CFG.eventsManager.getEvent((int)this.getEventsToRun((int)i)).lDecisions.size(); ++j) {
                            tempAIChanceTotal += CFG.eventsManager.getEvent((int)this.getEventsToRun((int)i)).lDecisions.get((int)j).iAIChance;
                        }
                        int randNum = CFG.oR.nextInt(tempAIChanceTotal);
                        int countChance = 0;
                        for (int j = 0; j < CFG.eventsManager.getEvent((int)this.getEventsToRun((int)i)).lDecisions.size(); ++j) {
                            if (randNum >= countChance && randNum < countChance + CFG.eventsManager.getEvent((int)this.getEventsToRun((int)i)).lDecisions.get((int)j).iAIChance) {
                                decistionTaken = j;
                                break;
                            }
                            countChance += CFG.eventsManager.getEvent((int)this.getEventsToRun((int)i)).lDecisions.get((int)j).iAIChance;
                        }
                        if (CFG.eventsManager.getEvent(this.getEventsToRun(i)).getCivID() >= 0) {
                            CFG.core.getCiv(CFG.eventsManager.getEvent(this.getEventsToRun(i)).getCivID()).addEventDecisionTaken(CFG.eventsManager.getEvent(this.getEventsToRun(i)).getEventTag() + "_" + decistionTaken);
                        }
                        CFG.eventsManager.getEvent((int)this.getEventsToRun((int)i)).lDecisions.get(decistionTaken).executeDecision();
                        this.removeEventToRun(0);
                        continue;
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }
                }
            }
        }
        catch (Exception exception) {
            
        }
    }

    public final int isRAIP(int nProvinceID) {
        for (int i = 0; i < this.civGD.recruitArmySize; ++i) {
            if (this.civGD.recruitArmy.get(i).getProvinceID() != nProvinceID) continue;
            return i;
        }
        return -1;
    }

    public final void addEventToRunId(int id) {
        this.lEventsToRun.add(id);
    }

    public final void removeEventToRun(int i) {
        this.lEventsToRun.remove(i);
    }

    public final int getEventsToRunSize() {
        return this.lEventsToRun.size();
    }

    public final void addEventDecisionTaken(String nEventDecTAG) {
        this.civGD.lEvents_DecisionsTaken.add(nEventDecTAG);
    }

    public final boolean getEventTookDecision(String nEventDecTAG) {
        for (int i = 0; i < this.civGD.lEvents_DecisionsTaken.size(); ++i) {
            if (!this.civGD.lEvents_DecisionsTaken.get(i).equals(nEventDecTAG)) continue;
            return true;
        }
        return false;
    }

    public final Civilization_Diplomacy_GameData getCivDiploGD() {
        return this.civGD.civDiploGD;
    }

    public final Loan_GameData getLoan(int i) {
        return this.civGD.loansTaken.get(i);
    }

    public final int getLoansSize() {
        return this.civGD.loansTaken.size();
    }

    public final void addLoanNew(int iGoldPerTurn, int iDuration) {
        this.civGD.loansTaken.add(new Loan_GameData(iGoldPerTurn, iDuration));
    }

    public final void updateLoansNextTurn() {
        for (int i = 0; i < this.civGD.loansTaken.size(); ++i) {
            --this.civGD.loansTaken.get((int)i).iTurnsLeft;
            if (this.civGD.loansTaken.get((int)i).iTurnsLeft > 0) continue;
            this.civGD.loansTaken.remove(i--);
            if (!this.getIsPlayer()) continue;
            this.getCivDiploGD().messageBox.addMessage(new Message_Repaid(this.getCivId(), 0));
        }
    }

    public final int getLoans_GoldTotalPerTurn() {
        int out = 0;
        for (int i = 0; i < this.civGD.loansTaken.size(); ++i) {
            out += this.civGD.loansTaken.get((int)i).iGoldPerTurn;
        }
        return out;
    }

    public final void clearLoans() {
        this.civGD.loansTaken.clear();
    }

    public final void removeLoan(int i) {
        this.civGD.loansTaken.remove(i);
    }

    public final LoanCiv_GameData getLoanFromCiv(int i) {
        return this.civGD.lLoansTakenFromCiv.get(i);
    }

    public final int getLoansFromCivSize() {
        return this.civGD.lLoansTakenFromCiv.size();
    }

    public final void addLoanFromCiv(int iGoldPerTurn, int iDuration, int fromCivID) {
        this.civGD.lLoansTakenFromCiv.add(new LoanCiv_GameData(iGoldPerTurn, iDuration, fromCivID));
    }

    public final void updateLoansFromCivNextTurn() {
        for (int i = 0; i < this.civGD.lLoansTakenFromCiv.size(); ++i) {
            --this.civGD.lLoansTakenFromCiv.get((int)i).iTurnsLeft;
            CFG.core.getCiv(this.civGD.lLoansTakenFromCiv.get((int)i).fromCivID).setGold(CFG.core.getCiv(this.civGD.lLoansTakenFromCiv.get((int)i).fromCivID).getGold() + (long)this.civGD.lLoansTakenFromCiv.get((int)i).iGoldPerTurn);
            if (this.civGD.lLoansTakenFromCiv.get((int)i).iTurnsLeft > 0) continue;
            this.civGD.lLoansTakenFromCiv.remove(i--);
            if (!this.getIsPlayer()) continue;
            this.getCivDiploGD().messageBox.addMessage(new Message_Repaid(this.getCivId(), 0));
        }
    }

    public void updateLoansFromCiv_WarDeclared(int warOnCivID) {
        for (int i = this.civGD.lLoansTakenFromCiv.size() - 1; i >= 0; --i) {
            if (this.civGD.lLoansTakenFromCiv.get((int)i).fromCivID != warOnCivID) continue;
            this.setGold(this.getGold() - (long)this.civGD.lLoansTakenFromCiv.get((int)i).iGoldPerTurn * (long)this.civGD.lLoansTakenFromCiv.get((int)i).iTurnsLeft);
            CFG.core.getCiv(warOnCivID).setGold(CFG.core.getCiv(warOnCivID).getGold() + (long)((float)this.civGD.lLoansTakenFromCiv.get((int)i).iGoldPerTurn * GameValues.gvLoan.REQUEST_LOAN_WAR_DECLARED_ON_LENDER_PENALTY) * (long)this.civGD.lLoansTakenFromCiv.get((int)i).iTurnsLeft);
            this.civGD.lLoansTakenFromCiv.remove(i);
        }
    }

    public final boolean haveLoansFromCiv(int fromCivID) {
        for (int i = 0; i < this.civGD.lLoansTakenFromCiv.size(); ++i) {
            if (this.civGD.lLoansTakenFromCiv.get((int)i).fromCivID != fromCivID) continue;
            return true;
        }
        return false;
    }

    public final int getLoansFromCiv_GoldTotalPerTurn() {
        int out = 0;
        for (int i = 0; i < this.civGD.lLoansTakenFromCiv.size(); ++i) {
            out += this.civGD.lLoansTakenFromCiv.get((int)i).iGoldPerTurn;
        }
        return out;
    }

    public final void clearLoansFromCiv() {
        this.civGD.lLoansTakenFromCiv.clear();
    }

    public final void removeLoanFromCiv(int i) {
        this.civGD.lLoansTakenFromCiv.remove(i);
    }

    public final void addWarReparationsGets(int nCivID) {
        for (int i = 0; i < this.civGD.lWarReparationsGets.size(); ++i) {
            if (this.civGD.lWarReparationsGets.get((int)i).iFromCivID != nCivID) continue;
            this.civGD.lWarReparationsGets.get((int)i).iTurnsLeft = GameValues.gvPeaceTreaty.WAR_REPARATIONS_LENGTH;
            return;
        }
        this.civGD.lWarReparationsGets.add(new WarReparations(nCivID, GameValues.gvPeaceTreaty.WAR_REPARATIONS_LENGTH));
    }

    public final void addWarReparationsPay(int nCivID) {
        for (int i = 0; i < this.civGD.warReparationsPay.size(); ++i) {
            if (this.civGD.warReparationsPay.get((int)i).iFromCivID != nCivID) continue;
            this.civGD.warReparationsPay.get((int)i).iTurnsLeft = GameValues.gvPeaceTreaty.WAR_REPARATIONS_LENGTH;
            return;
        }
        this.civGD.warReparationsPay.add(new WarReparations(nCivID, GameValues.gvPeaceTreaty.WAR_REPARATIONS_LENGTH));
    }

    public final WarReparations getWarReparationsPays(int i) {
        return this.civGD.warReparationsPay.get(i);
    }

    public final int getWarReparationsPaysTurnsLeft(int nCivID) {
        for (int i = 0; i < this.civGD.warReparationsPay.size(); ++i) {
            if (this.civGD.warReparationsPay.get((int)i).iFromCivID != nCivID) continue;
            return this.civGD.warReparationsPay.get((int)i).iTurnsLeft;
        }
        return 0;
    }

    public final WarReparations getWarReparationsGets(int i) {
        return this.civGD.lWarReparationsGets.get(i);
    }

    public final int getWarReparationsGets_TurnsLeft(int nCivID) {
        for (int i = 0; i < this.civGD.lWarReparationsGets.size(); ++i) {
            if (this.civGD.lWarReparationsGets.get((int)i).iFromCivID != nCivID) continue;
            return this.civGD.lWarReparationsGets.get((int)i).iTurnsLeft;
        }
        return 0;
    }

    public final void runWarReparations() {
        int i;
        for (i = this.civGD.warReparationsPay.size() - 1; i >= 0; --i) {
            if (this.civGD.warReparationsPay.get((int)i).iTurnsLeft-- > 0) continue;
            if (this.getIsPlayer()) {
                this.getCivDiploGD().messageBox.addMessage(new Message_WarReparationsRepaid_Green(this.civGD.warReparationsPay.get((int)i).iFromCivID));
            }
            this.civGD.warReparationsPay.remove(i);
        }
        for (i = this.civGD.lWarReparationsGets.size() - 1; i >= 0; --i) {
            if (this.civGD.lWarReparationsGets.get((int)i).iTurnsLeft-- > 0) continue;
            if (this.getIsPlayer()) {
                this.getCivDiploGD().messageBox.addMessage(new Message_WarReparationsRepaid(this.civGD.lWarReparationsGets.get((int)i).iFromCivID));
            }
            this.civGD.lWarReparationsGets.remove(i);
        }
    }

    public final int getWarReparationsPaysSize() {
        return this.civGD.warReparationsPay.size();
    }

    public final int getWarReparationsGetsSize() {
        return this.civGD.lWarReparationsGets.size();
    }

    public final int getEventsToRun(int i) {
        return this.lEventsToRun.get(i);
    }

    public final boolean addNewBonus(CivBonus_GameData nBonus) {
        if (nBonus.BONUS_TYPE == CivBonus_Type.GOLDEN_AGE_PROSPERITY) {
            for (int i = 0; i < this.civGD.bonusesCiv.size(); ++i) {
                if (this.civGD.bonusesCiv.get((int)i).BONUS_TYPE != CivBonus_Type.GOLDEN_AGE_PROSPERITY) continue;
                return false;
            }
        } else if (nBonus.BONUS_TYPE == CivBonus_Type.GOLDEN_AGE_SCIENCE) {
            for (int i = 0; i < this.civGD.bonusesCiv.size(); ++i) {
                if (this.civGD.bonusesCiv.get((int)i).BONUS_TYPE != CivBonus_Type.GOLDEN_AGE_SCIENCE) continue;
                return false;
            }
        } else if (nBonus.BONUS_TYPE == CivBonus_Type.GOLDEN_AGE_MILITARY) {
            for (int i = 0; i < this.civGD.bonusesCiv.size(); ++i) {
                if (this.civGD.bonusesCiv.get((int)i).BONUS_TYPE != CivBonus_Type.GOLDEN_AGE_MILITARY) continue;
                return false;
            }
        }
        this.civGD.bonusesCiv.add(nBonus);
        this.applyBonusChanges(nBonus);
        return true;
    }

    public final void updateBonuses() {
        for (int i = 0; i < this.civGD.bonusesCiv.size(); ++i) {
            --this.civGD.bonusesCiv.get((int)i).iTurnsLeft;
            if (this.civGD.bonusesCiv.get((int)i).iTurnsLeft > 0) continue;
            this.applyBonusChangesExpired(this.civGD.bonusesCiv.get(i));
            this.civGD.bonusesCiv.remove(i--);
        }
    }

    public final void moveRegroupArmy() {
        for (int i = 0; i < this.civGD.iRegroupArmySize; ++i) {
            try {
                if (!RegroupArmy.canBeUsedInPath(this.getCivId(), this.civGD.lRegroupArmy.get(i).getRoute(0), false, this.civGD.lRegroupArmy.get(i).getToProvinceID())) {
                    this.removeRegroupArmy(i);
                    --i;
                    continue;
                }
                if (!this.civGD.lRegroupArmy.get(i).continueMovingArmy(this.getCivId())) {
                    this.removeRegroupArmy(i);
                    --i;
                    continue;
                }
                if (this.civGD.lRegroupArmy.get(i).getObsolate() < 0) {
                    this.removeRegroupArmy(i);
                    --i;
                    continue;
                }
                this.civGD.lRegroupArmy.get(i).updateObsolate();
                if (CFG.core.getProv(this.civGD.lRegroupArmy.get(i).getFromProvinceID()).getArmyCivID1(this.getCivId()) <= this.civGD.lRegroupArmy.get(i).getNumOfUnits()) {
                    if (CFG.core.getProv(this.civGD.lRegroupArmy.get(i).getFromProvinceID()).getArmyCivID1(this.getCivId()) <= 0) {
                        this.removeRegroupArmy(i);
                        --i;
                        continue;
                    }
                    this.civGD.lRegroupArmy.get(i).setNumOfUnits(CFG.core.getProv(this.civGD.lRegroupArmy.get(i).getFromProvinceID()).getArmyCivID1(this.getCivId()));
                }
                if (!CFG.gameAction.moveArmyAction(this.civGD.lRegroupArmy.get(i).getFromProvinceID(), this.civGD.lRegroupArmy.get(i).getRoute(0), this.civGD.lRegroupArmy.get(i).getNumOfUnits(), this.getCivId(), true, true)) continue;
                this.civGD.aiNoDisbandUntilTurnID = Math.max(this.civGD.aiNoDisbandUntilTurnID, GameCalendar.TURNID + 6);
                this.civGD.lRegroupArmy.get(i).setFromProvinceID(this.civGD.lRegroupArmy.get(i).getRoute(0));
                this.civGD.lRegroupArmy.get(i).removeRoute(0);
                if (this.civGD.lRegroupArmy.get(i).getRouteSize() != 0) continue;
                this.removeRegroupArmy(i);
                --i;
                continue;
            }
            catch (IndexOutOfBoundsException ex) {
                this.removeRegroupArmy(i);
                --i;
                continue;
            }
            catch (NullPointerException ex) {
                this.removeRegroupArmy(i);
                --i;
            }
        }
    }

    public final void removeRegroupArmy(int i) {
        this.civGD.lRegroupArmy.remove(i);
        this.currentRegroupArmyLine.remove(i);
        this.civGD.iRegroupArmySize = this.civGD.lRegroupArmy.size();
    }

    public final void clearRegroupArmy() {
        this.civGD.lRegroupArmy.clear();
        this.currentRegroupArmyLine.clear();
        this.civGD.iRegroupArmySize = this.civGD.lRegroupArmy.size();
    }

    public final void addProv_Just(int nProvinceID) {
        for (int i = 0; i < this.numOfProvinces; ++i) {
            if (this.provinces.get(i) != nProvinceID) continue;
            return;
        }
        this.provinces.add(nProvinceID);
        this.numOfProvinces = this.provinces.size();
        this.uFOL = true;
    }

    public final void addProv(int nProvinceID) {
        for (int i = 0; i < this.numOfProvinces; ++i) {
            if (this.provinces.get(i) != nProvinceID) continue;
            return;
        }
        this.provinces.add(nProvinceID);
        this.numOfProvinces = this.provinces.size();
        CFG.core.getProv(nProvinceID).setCivRegionID(-1);
        this.uFOL = true;
    }

    public final boolean isAssimilateOrganized(int nProvinceID) {
        for (int i = 0; i < this.civGD.assimilates.size(); ++i) {
            if (nProvinceID != this.civGD.assimilates.get((int)i).iProvinceID) continue;
            return true;
        }
        return false;
    }

    public final int isAssimilateOrganized_TurnsLeft(int nProvinceID) {
        for (int i = 0; i < this.civGD.assimilates.size(); ++i) {
            if (nProvinceID != this.civGD.assimilates.get((int)i).iProvinceID) continue;
            return this.civGD.assimilates.get((int)i).iTurnsLeft;
        }
        return 0;
    }

    public final CivInvest getInvest(int i) {
        return this.civGD.investsEco.get(i);
    }

    public final void removeInvest(int i) {
        this.civGD.investsEco.remove(i);
    }

    public final void removeInvest_ProvinceID(int nProvinceID) {
        for (int i = 0; i < this.civGD.investsEco.size(); ++i) {
            if (nProvinceID != this.civGD.investsEco.get((int)i).provinceID) continue;
            this.civGD.investsEco.remove(i);
            break;
        }
    }

    public final boolean areSanctionsAdded(int byCivID, int onCivID) {
        for (int i = 0; i < this.civGD.lSanctions.size(); ++i) {
            if ((this.civGD.lSanctions.get((int)i).byCivID != byCivID || this.civGD.lSanctions.get((int)i).onCivID != onCivID) && (this.civGD.lSanctions.get((int)i).byCivID != onCivID || this.civGD.lSanctions.get((int)i).onCivID != byCivID)) continue;
            return true;
        }
        return false;
    }

    public final int getInvestsSize() {
        return this.civGD.investsEco.size();
    }

    public final void removeProv(int nProvinceID) {
        for (int i = 0; i < this.numOfProvinces; ++i) {
            if (this.provinces.get(i) != nProvinceID) continue;
            this.provinces.remove(i);
            this.numOfProvinces = this.provinces.size();
            break;
        }
        CFG.core.getProv(nProvinceID).setCivRegionID(-1);
        this.uFOL = true;
        if (this.numOfProvinces == 0) {
            this.civGD.iTurnsSinceLastAttack = 100;
        }
    }

    public final void clearProvinces_FillTheMap(boolean addCapital) {
        this.civRegions.clear();
        this.iCivRegionsSize = 0;
        this.provinces.clear();
        if (addCapital) {
            this.provinces.add(this.getCapitalProvID());
            this.numOfProvinces = this.provinces.size();
            this.createCivilizationRegion(this.getCapitalProvID());
        } else {
            this.numOfProvinces = this.provinces.size();
        }
        this.uFOL = true;
    }

    public final int getProvID(int i) {
        try {
            return this.provinces.get(i);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
            return -1;
        }
    }

    public final boolean controlsProvince(int nProvinceID) {
        for (int i = 0; i < this.getNumOfProvs(); ++i) {
            if (nProvinceID != this.getProvID(i)) continue;
            return true;
        }
        return false;
    }

    public final int getNumOfProvs() {
        return this.numOfProvinces;
    }

    public final int getNumOfProvs_NotOccupied() {
        int count = 0;
        for (int i = 0; i < this.numOfProvinces; ++i) {
            if (!CFG.core.getProv(this.getProvID(i)).isOccupied()) {
                count++;
            }
        }
        return count;
    }

    public final void setCivName(String sCivName) {
        if (sCivName == null || sCivName.isEmpty()) {
            sCivName = "A";
        }
        this.civGD.sCivName = sCivName;
        this.iCivNameWidth = CFG.getGlyphWidth(CFG.fontMain.get(0), sCivName);
        this.iCivNameHeight = CFG.getGlyphHeight(CFG.fontMain.get(0), sCivName);

        this.lCivNameChars = new ArrayList<Character>();
        this.sCivName_UpperCase = sCivName.toUpperCase();
        String sUpper = sCivName.toUpperCase();
        for (int i = 0; i < sUpper.length(); ++i) {
            this.lCivNameChars.add(Character.valueOf(sUpper.charAt(i)));
        }
        this.iCivNameLength = this.lCivNameChars.size();
    }

    public final int getCivNameWidth() {
        if (this.iCivNameWidth <= 1) {
            try {
                this.iCivNameWidth = Math.max(2, CFG.getGlyphWidth(CFG.fontMain.get(0), this.getCivName()));
            } catch (Exception ex) {
                return 100;
            }
        }
        return this.iCivNameWidth;
    }

    public final int getCivNameHeight() {
        if (this.iCivNameHeight <= 1) {
            try {
                this.iCivNameHeight = Math.max(2, CFG.getGlyphHeight(CFG.fontMain.get(0), this.getCivName()));
            } catch (Exception ex) {
                return CFG.TEXT_HEIGHT_DEFAULT;
            }
        }
        return this.iCivNameHeight;
    }

    public final char getCivNameCharacter(int id) {
        return this.lCivNameChars.get(id).charValue();
    }

    public final int getCivNameLength() {
        return this.iCivNameLength;
    }

    public final int getR() {
        return this.civGD.iR;
    }

    public final void setR(int iR) {
        this.civGD.iR = (short)iR;
        this.colorFloat[0] = (float)iR / 255.0f;
        ProvinceMesh.markCivDirty(this.iCivId);
    }

    public final int getG() {
        return this.civGD.iG;
    }

    public final void setG(int iG) {
        this.civGD.iG = (short)iG;
        this.colorFloat[1] = (float)iG / 255.0f;
        ProvinceMesh.markCivDirty(this.iCivId);
    }

    public final int getB() {
        return this.civGD.iB;
    }

    public final void setB(int iB) {
        this.civGD.iB = (short)iB;
        this.colorFloat[2] = (float)iB / 255.0f;
        ProvinceMesh.markCivDirty(this.iCivId);
    }

    public final int getCivId() {
        return this.iCivId;
    }

    public final void updateColorFloat() {
        this.colorFloat[0] = (float)this.civGD.iR / 255.0f;
        this.colorFloat[1] = (float)this.civGD.iG / 255.0f;
        this.colorFloat[2] = (float)this.civGD.iB / 255.0f;
        ProvinceMesh.markCivDirty(this.iCivId);
    }

    public final void setCivId(int iCivID) {
        this.iCivId = iCivID;
        this.civGD.puppetOfCivID = iCivID;
        this.iRankPosition = iCivID;
    }

    public final void setCivId_Just(int iCivID) {
        this.iCivId = iCivID;
    }

    public final String getCivName() {
        if (this.civGD.sCivName == null || this.civGD.sCivName.isEmpty() || this.civGD.sCivName.equals(" ")) {
            return this.getCivTag();
        }
        return this.civGD.sCivName;
    }

    public final String getCivTag() {
        return this.civGD.sCivTag;
    }

    public final void setCivTag(String sCivTag) {
        this.civGD.sCivTag = sCivTag;
        if (sCivTag.indexOf(59) > 0) {
            String[] tempTags = sCivTag.split(";");
            String tempName = "";
            for (int i = 0; i < tempTags.length; ++i) {
                tempName = tempName + CFG.lang.getCiv(tempTags[i]) + (i < tempTags.length - 1 ? "-" : "");
            }
            this.setCivName(tempName);
        } else {
            this.setCivName(CFG.lang.getCiv(sCivTag));
        }
    }

    public final int getHappiness() {
        return this.happiness;
    }

    public final void setHappiness(int nHappiness) {
        this.happiness = nHappiness;
        if (this.happiness > 100) {
            this.happiness = 100;
        } else if (this.happiness < 0) {
            this.happiness = 0;
        }
    }

    public final void addArmyInAnotherProv(int nProvinceID) {
        synchronized(this.armyInAnotherProv) {
            for (int i = 0; i < this.getArmyInAnotherProvinceSize(); ++i) {
                if (this.getArmyInAnotherProviP(i) != nProvinceID) continue;
                return;
            }
            this.armyInAnotherProv.add(nProvinceID);
            this.armyInAnotherProvinceSize = this.armyInAnotherProv.size();
        }
    }

    public final void removeArmyInAnotherProvinP(int nProvinceID) {
        synchronized(this.armyInAnotherProv) {
            for (int i = 0; i < this.getArmyInAnotherProvinceSize(); ++i) {
                if (this.getArmyInAnotherProviP(i) != nProvinceID) continue;
                this.armyInAnotherProv.remove(i);
                this.armyInAnotherProvinceSize = this.armyInAnotherProv.size();
                return;
            }
        }
    }

    public final int getArmyInAnotherProvinceSize() {
        return this.armyInAnotherProvinceSize;
    }

    public final float getRelationD(int i) {
        try {
            if (this.civGD.relation.containsKey(i)) {
                return this.civGD.relation.get(i).floatValue();
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return 0.0f;
    }

    public final void setTechLevel_INT(int nTechnologyLevel) {
        this.civGD.techLevel = nTechnologyLevel;
        if ((float)this.civGD.techLevel > GameValues.gvTechnology.MAX_TECHNOLOGY_LEVEL * 100.0f) {
            this.civGD.techLevel = (int)(GameValues.gvTechnology.MAX_TECHNOLOGY_LEVEL * 100.0f);
        }
    }

    public final boolean recruitArmy(int nProvinceID, long nArmy) {
        if (CFG.core.getProv(nProvinceID).getCivId() != CFG.core.getProv(nProvinceID).getTrueOwnerOfProv()) {
            if (CFG.core.getProv(nProvinceID).getPop().getPopulationOfCivID(this.getCivId()) > 0) {
                if (nArmy > CFG.core.getProv(nProvinceID).getPop().getPopulationOfCivID(this.getCivId())) {
                    nArmy = CFG.core.getProv(nProvinceID).getPop().getPopulationOfCivID(this.getCivId());
                }
            } else {
                return false;
            }
        }
        if (nArmy >= CFG.gameAction.gMARY(nProvinceID)) {
            nArmy = CFG.gameAction.gMARY(nProvinceID);
        }
        for (int i = 0; i < this.civGD.recruitArmySize; ++i) {
            if (this.civGD.recruitArmy.get(i).getProvinceID() != nProvinceID) continue;
            if (nArmy == 0 && this.civGD.recruitArmy.get(i).getArmy() > 0) {
                CFG.core.getCiv(this.getCivId()).setMovementPoints(CFG.core.getCiv(this.getCivId()).getMovemPoints() + CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.getCivId()).getIdeology()).COST_OF_RECRUIT);
                CFG.core.getCiv(this.getCivId()).setGold(CFG.core.getCiv(this.getCivId()).getGold() + (long)(this.civGD.recruitArmy.get(i).getArmy() * CFG.gCARR(nProvinceID, this.getCivId())));
                this.removeRecruitArmy(i);
                return true;
            }
            long currentArmy = this.civGD.recruitArmy.get(i).getArmy();
            long recruitCost = Math.max(1L, (long)CFG.gCARR(nProvinceID, this.getCivId()));
            if (nArmy > currentArmy) {
                nArmy = currentArmy + Math.min(nArmy - currentArmy, CFG.core.getCiv(this.getCivId()).getGold() / recruitCost);
            }
            long tDiff = currentArmy - nArmy;
            this.civGD.recruitArmy.get(i).setArmy(nArmy);
            CFG.core.getCiv(this.getCivId()).setGold(CFG.core.getCiv(this.getCivId()).getGold() + tDiff * recruitCost);
            return true;
        }
        if (!CFG.core.getCiv((int)this.getCivId()).isAtWarC() && !CFG.core.getCiv((int)this.getCivId()).civGD.civPlans.isPreparingForTheWar() && CFG.core.getCiv(this.getCivId()).getMovemPoints() < CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.getCivId()).getIdeology()).COST_OF_RECRUIT) {
            return false;
        }
        if (nArmy >= CFG.core.getCiv(this.getCivId()).getGold() / (long)CFG.gCARR(nProvinceID, this.getCivId())) {
            nArmy = CFG.core.getCiv(this.getCivId()).getGold() / (long)CFG.gCARR(nProvinceID, this.getCivId());
        }
        if (nArmy <= 0) {
            return false;
        }
        CFG.core.getCiv(this.getCivId()).setMovementPoints(CFG.core.getCiv(this.getCivId()).getMovemPoints() - CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.getCivId()).getIdeology()).COST_OF_RECRUIT);
        CFG.core.getCiv(this.getCivId()).setGold(CFG.core.getCiv(this.getCivId()).getGold() - (long)(nArmy * CFG.gCARR(nProvinceID, this.getCivId())));
        float tech = this.getTechLevel();
        int turns = GameValues.gvArmyRecruit.RECRUIT_ARMY_BASE_TURNS;
        if (tech > 0.9f) {
            turns = GameValues.gvArmyRecruit.RECRUIT_ARMY_TECH_OVER_09_TURNS;
        } else if (tech > 0.7f) {
            turns = GameValues.gvArmyRecruit.RECRUIT_ARMY_TECH_07_09_TURNS;
        } else if (tech >= 0.1f) {
            turns = GameValues.gvArmyRecruit.RECRUIT_ARMY_BASE_TURNS - (int)(tech * 10.0f);
        }
        if (this.civGD.recruitArmy == null) {
            this.civGD.recruitArmy = new ArrayList<RecruitArmy>();
            this.civGD.recruitArmySize = 0;
        }
        this.civGD.recruitArmy.add(new RecruitArmy(nProvinceID, nArmy, turns));
        this.civGD.recruitArmySize = this.civGD.recruitArmy.size();
        return true;
    }

    public final void setAlliance(int iAllianceID) {
        this.civGD.allianceID = iAllianceID;
    }

    public final boolean getIsPlayer() {
        return !CFG.SPECTATOR_MODE && this.controlledByPlayer;
    }

    public final int getTruce2(int i) {
        try {
            if (this.truce.containsKey(i)) {
                return this.truce.get((Object)Integer.valueOf((int)i)).iTurnID;
            }
            return 0;
        }
        catch (Exception ex) {
            return 0;
        }
    }

    public final boolean setTruce3(int iID, int iNumOfTurns) {
        block8: {
            try {
                if (iNumOfTurns < 0) {
                    iNumOfTurns = 0;
                } else if (iNumOfTurns > GameValues.gvDipTruce.DIPLOMACY_MAX_NUMBER_OF_TURNS_FOR_TRUCE) {
                    iNumOfTurns = GameValues.gvDipTruce.DIPLOMACY_MAX_NUMBER_OF_TURNS_FOR_TRUCE;
                }
                try {
                    if (iNumOfTurns <= 0) {
                        this.truce.remove(iID);
                        break block8;
                    }
                    this.truce.put(iID, new DiplomacyData(iID, iNumOfTurns));
                }
                catch (Exception exception) {}
            }
            catch (Exception exception) {
                
            }
        }
        return false;
    }

    public final int getDefensivePact8(int i) {
        try {
            if (this.defensivePact.containsKey(i)) {
                return this.defensivePact.get((Object)Integer.valueOf((int)i)).iTurnID;
            }
            return 0;
        }
        catch (Exception ex) {
            return 0;
        }
    }

    public final boolean setDefensivePact4(int iID, int iNumOfTurns) {
        block8: {
            try {
                if (iNumOfTurns < 0) {
                    iNumOfTurns = 0;
                } else if (iNumOfTurns > GameValues.gvDipDefensivePact.DIPLOMACY_MAX_NUMBER_OF_TURNS_FOR_DEFENSIVE_PACT) {
                    iNumOfTurns = GameValues.gvDipDefensivePact.DIPLOMACY_MAX_NUMBER_OF_TURNS_FOR_DEFENSIVE_PACT;
                }
                try {
                    if (iNumOfTurns <= 0) {
                        this.defensivePact.remove(iID);
                        break block8;
                    }
                    this.defensivePact.put(iID, new DiplomacyData(iID, iNumOfTurns));
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
        return false;
    }

    public final int getGuarantee9(int i) {
        try {
            if (this.guarantee.containsKey(i)) {
                return this.guarantee.get((Object)Integer.valueOf((int)i)).iTurnID;
            }
            return 0;
        }
        catch (Exception ex) {
            return 0;
        }
    }

    public final boolean setGuarantee2(int iID, int iNumOfTurns) {
        block8: {
            try {
                if (iNumOfTurns < 0) {
                    iNumOfTurns = 0;
                } else if (iNumOfTurns > GameValues.gvDipGuarantee.DIPLOMACY_MAX_NUMBER_OF_TURNS_FOR_GUARANTEE) {
                    iNumOfTurns = GameValues.gvDipGuarantee.DIPLOMACY_MAX_NUMBER_OF_TURNS_FOR_GUARANTEE;
                }
                try {
                    if (iNumOfTurns <= 0) {
                        this.guarantee.remove(iID);
                        break block8;
                    }
                    this.guarantee.put(iID, new DiplomacyData(iID, iNumOfTurns));
                }
                catch (Exception exception) {}
            }
            catch (Exception exception) {
                
            }
        }
        return false;
    }

    public final int getMilitaryAccess3(int i) {
        try {
            if (this.militaryAccess.containsKey(i)) {
                return this.militaryAccess.get((Object)Integer.valueOf((int)i)).iTurnID;
            }
            return 0;
        }
        catch (Exception ex) {
            return 0;
        }
    }

    public final boolean loadFlag_Vassal() {
        try {
            String realTagLeft = CFG.ideologiesMgr.getRealTag(this.getCivTag());
            String realTagRight = CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.getPuppetOfCiv()).getCivTag());
            if (CFG.ideologiesMgr.getIdeologyID((int)this.getIdeology()).REVOLUTIONARY) {
                return false;
            }
            if (FileManager.loadFile("game/flagsXH/" + realTagLeft + "-" + realTagRight + ".png").exists()) {
                if (this.civFlag != null) {
                    this.disposeFlag();
                }
                this.iFVS = true;
                this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/" + realTagLeft + "-" + realTagRight + ".png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Linear);
                return true;
            }
            if (FileManager.loadFile("game/flagsH/" + realTagLeft + "-" + realTagRight + ".png").exists()) {
                if (this.civFlag != null) {
                    this.disposeFlag();
                }
                this.iFVS = true;
                this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsH/" + realTagLeft + "-" + realTagRight + ".png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Linear);
                return true;
            }
            if (FileManager.loadFile("game/flags/" + realTagLeft + "-" + realTagRight + ".png").exists()) {
                if (this.civFlag != null) {
                    this.disposeFlag();
                }
                this.iFVS = true;
                this.civFlag = new Image(new Texture(FileManager.loadFile("game/flags/" + realTagLeft + "-" + realTagRight + ".png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Linear);
                return true;
            }
        }
        catch (Exception exception) {
            
        }
        return false;
    }

    public final void loadFlag_Task() {
        block21: {
            this.iFVS = false;
            if (this.getCivTag().indexOf(";") > 0) {
                try {
                    CFG.unionFlagsToGenerate_Manager.lFlags.add(new UnionFlagsToGenerate());
                    int tGenerateID = CFG.unionFlagsToGenerate_Manager.lFlags.size() - 1;
                    String[] tempD = this.getCivTag().split(";");
                    for (int i = 0; i < tempD.length; ++i) {
                        CFG.unionFlagsToGenerate_Manager.lFlags.get((int)tGenerateID).lTags.add(tempD[i]);
                    }
                    CFG.unionFlagsToGenerate_Manager.lFlags.get((int)tGenerateID).typeOfAction = UnionFlagsToGenerate_TypesOfAction.CIV_ID_SMALL;
                    CFG.unionFlagsToGenerate_Manager.lFlags.get((int)tGenerateID).iID = this.getCivId();
                    this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/ran.png")), Texture.TextureFilter.Nearest);
                    this.isFlagNearest = true;
                }
                catch (GdxRuntimeException ex) {
                    CFG.exceptionStack(ex);
                }
                return;
            }
            try {
                if (this.civFlag != null) {
                    this.disposeFlag();
                }
            }
            catch (RuntimeException ex) {
                
            }
            if (GameValues.gvInGame.LOAD_LORD_VASSAL_SPECIAL_FLAG && this.getPuppetOfCiv() != this.getCivId() && this.loadFlag_Vassal()) {
                return;
            }
            try {
                try {
                    if (CFG.ideologiesMgr.getIdeologyID((int)this.getIdeology()).REVOLUTIONARY) {
                        this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/rb" + (this.getCivId() + this.getCivTag().charAt(0)) % 6 + ".png")), Texture.TextureFilter.Linear);
                        return;
                    }
                    if (FileManager.loadFile("game/flagsXH/" + this.getCivTag() + ".png").exists()) {
                        this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/" + this.getCivTag() + ".png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Linear);
                        break block21;
                    }
                    if (FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(this.getCivTag()) + ".png").exists()) {
                        this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(this.getCivTag()) + ".png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Linear);
                        break block21;
                    }
                    if (FileManager.loadFile("game/flagsH/" + this.getCivTag() + ".png").exists()) {
                        this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsH/" + this.getCivTag() + ".png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Linear);
                        break block21;
                    }
                    if (FileManager.loadFile("game/flagsH/" + CFG.ideologiesMgr.getRealTag(this.getCivTag()) + ".png").exists()) {
                        this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsH/" + CFG.ideologiesMgr.getRealTag(this.getCivTag()) + ".png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Linear);
                        break block21;
                    }
                    if (FileManager.loadFile("game/flags/" + this.getCivTag() + ".png").exists()) {
                        this.civFlag = new Image(new Texture(FileManager.loadFile("game/flags/" + this.getCivTag() + ".png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Nearest);
                        this.isFlagNearest = true;
                        break block21;
                    }
                    if (FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(this.getCivTag()) + ".png").exists()) {
                        this.civFlag = new Image(new Texture(FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(this.getCivTag()) + ".png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Nearest);
                        this.isFlagNearest = true;
                        break block21;
                    }
                    if (CFG.isAndroid() && FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "_FL.png").exists()) {
                        this.civFlag = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "_FL.png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Nearest);
                        this.isFlagNearest = true;
                        break block21;
                    }
                    if (FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "_FL.png").exists()) {
                        this.civFlag = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "_FL.png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Nearest);
                        this.isFlagNearest = true;
                        break block21;
                    }
                    this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/ran.png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Nearest);
                    this.isFlagNearest = true;
                }
                catch (RuntimeException ex) {
                    this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/ran.png")), Texture.TextureFilter.Nearest);
                }
            }
            catch (Exception exception) {
                
            }
        }
    }

    public final boolean loadFlag() {
        block22: {
            this.iFVS = false;
            if (this.getCivTag().indexOf(";") > 0) {
                try {
                    CFG.unionFlagsToGenerate_Manager.lFlags.add(new UnionFlagsToGenerate());
                    int tGenerateID = CFG.unionFlagsToGenerate_Manager.lFlags.size() - 1;
                    String[] tempD = this.getCivTag().split(";");
                    for (int i = 0; i < tempD.length; ++i) {
                        CFG.unionFlagsToGenerate_Manager.lFlags.get((int)tGenerateID).lTags.add(tempD[i]);
                    }
                    CFG.unionFlagsToGenerate_Manager.lFlags.get((int)tGenerateID).typeOfAction = UnionFlagsToGenerate_TypesOfAction.CIV_ID_SMALL;
                    CFG.unionFlagsToGenerate_Manager.lFlags.get((int)tGenerateID).iID = this.getCivId();
                    this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/ran.png")), Texture.TextureFilter.Nearest);
                    this.isFlagNearest = true;
                }
                catch (GdxRuntimeException ex) {
                    CFG.exceptionStack(ex);
                }
                return true;
            }
            try {
                if (this.civFlag != null) {
                    this.disposeFlag();
                }
            }
            catch (RuntimeException ex) {
                
            }
            try {
                try {
                    if (CFG.ideologiesMgr.getIdeologyID((int)this.getIdeology()).REVOLUTIONARY) {
                        this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/rb" + (this.getCivId() + this.getCivTag().charAt(0)) % 6 + ".png")), Texture.TextureFilter.Linear);
                        return true;
                    }
                    if (FileManager.loadFile("game/flagsXH/" + this.getCivTag() + ".png").exists()) {
                        this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/" + this.getCivTag() + ".png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Linear);
                        break block22;
                    }
                    if (FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(this.getCivTag()) + ".png").exists()) {
                        this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/" + CFG.ideologiesMgr.getRealTag(this.getCivTag()) + ".png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Linear);
                        break block22;
                    }
                    if (FileManager.loadFile("game/flagsH/" + this.getCivTag() + ".png").exists()) {
                        this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsH/" + this.getCivTag() + ".png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Linear);
                        break block22;
                    }
                    if (FileManager.loadFile("game/flagsH/" + CFG.ideologiesMgr.getRealTag(this.getCivTag()) + ".png").exists()) {
                        this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsH/" + CFG.ideologiesMgr.getRealTag(this.getCivTag()) + ".png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Linear);
                        break block22;
                    }
                    if (FileManager.loadFile("game/flags/" + this.getCivTag() + ".png").exists()) {
                        this.civFlag = new Image(new Texture(FileManager.loadFile("game/flags/" + this.getCivTag() + ".png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Nearest);
                        this.isFlagNearest = true;
                        break block22;
                    }
                    if (FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(this.getCivTag()) + ".png").exists()) {
                        this.civFlag = new Image(new Texture(FileManager.loadFile("game/flags/" + CFG.ideologiesMgr.getRealTag(this.getCivTag()) + ".png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Nearest);
                        this.isFlagNearest = true;
                        break block22;
                    }
                    if (CFG.isAndroid() && FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "_FLH.png").exists()) {
                        this.civFlag = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "_FLH.png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Linear);
                        break block22;
                    }
                    if (FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "_FLH.png").exists()) {
                        this.civFlag = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "_FLH.png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Linear);
                        break block22;
                    }
                    if (CFG.isAndroid() && FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "_FL.png").exists()) {
                        this.civFlag = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "_FL.png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Nearest);
                        this.isFlagNearest = true;
                        break block22;
                    }
                    if (FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "_FL.png").exists()) {
                        this.civFlag = new Image(new Texture(FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "/" + CFG.ideologiesMgr.getRealTag(this.civGD.sCivTag) + "_FL.png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Nearest);
                        this.isFlagNearest = true;
                        break block22;
                    }
                    this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/ran.png"), Pixmap.Format.RGB888, false), Texture.TextureFilter.Nearest);
                    this.isFlagNearest = true;
                }
                catch (RuntimeException ex) {
                    this.civFlag = new Image(new Texture(FileManager.loadFile("game/flagsXH/ran.png")), Texture.TextureFilter.Nearest);
                }
            }
            catch (Exception ex) {
                Core.addSimpleTask(new Core.SimpleTask("loadFlagTask_" + this.getCivId() + this.getCivTag()){

                    @Override
                    public void update() {
                        CFG.core.getCiv(this.id).loadFlag_Task();
                    }
                });
            }
        }
        return true;
    }

    public final Image getFlagC() {
        return this.civFlag == null ? IMGManager.getIMG(Images.randomCivilizationFlag) : this.civFlag;
    }

    public final boolean getFlag_IsNull() {
        return this.civFlag == null;
    }

    public final Civilization_Region getCivRegion(int i) {
        try {
            return this.civRegions.get(i);
        }
        catch (Exception ex) {
            this.updateRegions = true;
            return new Civilization_Region();
        }
    }

    public final int getCivRegionsSize() {
        return this.iCivRegionsSize;
    }

    public final boolean getUpdateRegions() {
        return this.updateRegions;
    }

    public final void setUpdateRegions(boolean updateRegions) {
        this.updateRegions = updateRegions;
        if (updateRegions) {
            this.uFOL = true;
        }
    }

    public final int getPuppetOfCiv() {
        return this.civGD.puppetOfCivID;
    }

    public final void setPuppetOfCivId(int iPuppetOfCivID) {
        if (GameValues.gvInGame.LOAD_LORD_VASSAL_SPECIAL_FLAG && this.civGD.puppetOfCivID != iPuppetOfCivID) {
            if (iPuppetOfCivID != this.getCivId()) {
                if (this.iFVS) {
                    Core.addSimpleTask(new Core.SimpleTask("loadFlagVassalRev" + this.getCivId(), this.getCivId()){

                        @Override
                        public void update() {
                            CFG.core.getCiv(this.id).loadFlag_Task();
                        }
                    });
                } else {
                    Core.addSimpleTask(new Core.SimpleTask("loadFlagVassal" + this.getCivId(), this.getCivId()){

                        @Override
                        public void update() {
                            CFG.core.getCiv(this.id).loadFlag_Vassal();
                        }
                    });
                }
            } else if (this.iFVS) {
                Core.addSimpleTask(new Core.SimpleTask("loadFlagVassalRev" + this.getCivId(), this.getCivId()){

                    @Override
                    public void update() {
                        CFG.core.getCiv(this.id).loadFlag_Task();
                    }
                });
            }
        }
        if (this.civGD.puppetOfCivID != this.iCivId && this.civGD.puppetOfCivID != iPuppetOfCivID) {
            CFG.core.getCiv(this.civGD.puppetOfCivID).removeVassalN(this.iCivId);
        }
        this.civGD.puppetOfCivID = iPuppetOfCivID;
        if (this.civGD.puppetOfCivID != this.iCivId) {
            CFG.core.getCiv(this.civGD.puppetOfCivID).addVassalN(this.iCivId);
            try {
                Color nC = CFG.getColorMixed_2(this.getColor(1.0f), CFG.core.getCiv(this.civGD.puppetOfCivID).getColor(1.0f));
                this.setR((int)(nC.r * 255.0f));
                this.setG((int)(nC.g * 255.0f));
                this.setB((int)(nC.b * 255.0f));
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        } else {
            try {
                Core.addSimpleTask(new Core.SimpleTask("LoadColor" + this.getCivId(), this.getCivId()){

                    @Override
                    public void update() {
                        try {
                            FileHandle file = null;
                            Civilization_GameData3 tempCiv = null;
                            try {
                                file = FileManager.loadFile("game/civilizations/" + CFG.core.getCiv(this.id).getCivTag());
                                tempCiv = (Civilization_GameData3)CFG.deserialize(file.readBytes());
                            }
                            catch (GdxRuntimeException e) {
                                try {
                                    file = FileManager.loadFile("game/civilizations/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.id).getCivTag()));
                                    tempCiv = (Civilization_GameData3)CFG.deserialize(file.readBytes());
                                    int tempIdeologyID = CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(this.id).getCivTag());
                                    Color tempColor = CFG.getColorMixed(new Color((float)tempCiv.getR() / 255.0f, (float)tempCiv.getG() / 255.0f, (float)tempCiv.getB() / 255.0f, 0.775f), new Color(CFG.ideologiesMgr.getIdeologyID((int)tempIdeologyID).getColor().r, CFG.ideologiesMgr.getIdeologyID((int)tempIdeologyID).getColor().g, CFG.ideologiesMgr.getIdeologyID((int)tempIdeologyID).getColor().b, 0.225f));
                                    tempCiv.setR((int)(tempColor.r * 255.0f));
                                    tempCiv.setG((int)(tempColor.g * 255.0f));
                                    tempCiv.setB((int)(tempColor.b * 255.0f));
                                }
                                catch (GdxRuntimeException exr) {
                                    try {
                                        if (CFG.isAndroid()) {
                                            try {
                                                file = Gdx.files.local("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.id).getCivTag()) + "/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.id).getCivTag()));
                                                tempCiv = (Civilization_GameData3)CFG.deserialize(file.readBytes());
                                            }
                                            catch (GdxRuntimeException er) {
                                                file = FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.id).getCivTag()) + "/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.id).getCivTag()));
                                                tempCiv = (Civilization_GameData3)CFG.deserialize(file.readBytes());
                                            }
                                        } else {
                                            file = FileManager.loadFile("game/civilizations_editor/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.id).getCivTag()) + "/" + CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.id).getCivTag()));
                                            tempCiv = (Civilization_GameData3)CFG.deserialize(file.readBytes());
                                        }
                                    }
                                    catch (GdxRuntimeException r) {
                                        file = FileManager.loadFile("game/civilizations/ran");
                                        tempCiv = (Civilization_GameData3)CFG.deserialize(file.readBytes());
                                    }
                                }
                            }
                            Civilization.this.setR(tempCiv.getR());
                            Civilization.this.setG(tempCiv.getG());
                            Civilization.this.setB(tempCiv.getB());
                        }
                        catch (Exception exception) {
                            
                        }
                    }
                });
            }
            catch (Exception exception) {
                
            }
        }
    }

    public final float getVassalLibertyDesire() {
        return this.civGD.fVassalLibertyDesire;
    }

    public final void setVassalLibertyDesire(float fLiberityDesire) {
        if (fLiberityDesire < 0.0f) {
            fLiberityDesire = 0.0f;
        } else if (fLiberityDesire > 100.0f) {
            fLiberityDesire = 100.0f;
        }
        this.civGD.fVassalLibertyDesire = fLiberityDesire;
    }

    public final void setRelationD(int iID, float nOpinion) {
        try {
            float minRelation = Math.max((float)GameValues.gvRelations.MIN_RELATION_VALUE, (float)(GameValues.gvDiplomacy.RELATION_AT_WAR + 1));
            if (nOpinion > (float)GameValues.gvRelations.MAX_RELATION_VALUE) {
                nOpinion = GameValues.gvRelations.MAX_RELATION_VALUE;
            } else if (nOpinion < minRelation) {
                nOpinion = minRelation;
            }
            this.civGD.relation.put(iID, Float.valueOf(nOpinion));
        }
        catch (Exception exception) {
            
        }
    }

    public final void setRelationD_AtWar(int iID) {
        try {
            this.civGD.relation.put(iID, Float.valueOf(GameValues.gvDiplomacy.RELATION_AT_WAR));
        }
        catch (Exception exception) {
            
        }
    }

    public final int getNonAggPact(int i) {
        try {
            if (this.nonAggressionPact.containsKey(i)) {
                return this.nonAggressionPact.get((Object)Integer.valueOf((int)i)).iTurnID;
            }
            return 0;
        }
        catch (Exception ex) {
            return 0;
        }
    }

    public final void setVassal_Tribute(int nCivID, int nTribute) {
        for (int i = 0; i < this.civGD.vassals.size(); ++i) {
            if (this.civGD.vassals.get((int)i).iCivID != nCivID) continue;
            this.civGD.vassals.get(i).setTribute(nTribute);
            return;
        }
        this.civGD.vassals.add(new Vassal_GameData(nCivID));
        this.civGD.iVassalsSize = this.civGD.vassals.size();
    }

    public final MoveUnits getMoveUnits(int i) {
        return this.moveUnits.get(i);
    }

    public final int getMoveUnits_NumFromProvince(int nProvinceID) {
        int out = 0;
        for (int i = 0; i < this.moveUnitsSize(); ++i) {
            if (this.getMoveUnits(i).getFromProviID() != nProvinceID) continue;
            out += this.getMoveUnits(i).getNumberOfUnits();
        }
        return out;
    }

    public final boolean isMovingUnitsFromProvID(int nProvinceID) {
        for (int i = 0; i < this.moveUnitsSize(); ++i) {
            if (this.getMoveUnits(i).getFromProviID() != nProvinceID) continue;
            return true;
        }
        return false;
    }

    public final boolean isMovingUnitsToProvID(int nProvinceID) {
        for (int i = 0; i < this.moveUnitsSize(); ++i) {
            if (this.getMoveUnits(i).getToProvID() != nProvinceID) continue;
            return true;
        }
        return false;
    }

    public final long isMovingUnitsToProvID_Num(int nProvinceID) {
        for (int i = 0; i < this.moveUnitsSize(); ++i) {
            if (this.getMoveUnits(i).getToProvID() != nProvinceID) continue;
            return this.getMoveUnits(i).getNumberOfUnits();
        }
        return 0;
    }

    public final MoveUnits getMigrateMU(int i) {
        return this.lMigrate.get(i);
    }

    public final MoveUnits_Plunder getMoveUnitsPlunder(int i) {
        return this.moveUnitsPlunder.get(i);
    }

    public final RecruitArmy getRecruitArmy(int i) {
        if (this.civGD.recruitArmy == null) {
            this.civGD.recruitArmy = new ArrayList<RecruitArmy>();
            this.civGD.recruitArmySize = 0;
            return null;
        }
        return this.civGD.recruitArmy.get(i);
    }

    public final long getRecruitArmy_BasedOnProvinceID(int nProvinceID) {
        if (this.civGD.recruitArmy == null) {
            this.civGD.recruitArmy = new ArrayList<RecruitArmy>();
            this.civGD.recruitArmySize = 0;
            return 0;
        }
        for (int i = 0; i < this.civGD.recruitArmySize; ++i) {
            if (this.civGD.recruitArmy.get(i).getProvinceID() != nProvinceID) continue;
            return this.civGD.recruitArmy.get(i).getArmy();
        }
        return 0;
    }

    public final int getRecruitArmySize() {
        return this.civGD.recruitArmySize;
    }

    public final int moveUnitsSize() {
        return this.moveUnitsSize;
    }

    public final int getMigrateSize() {
        return this.iMigrateSize;
    }

    public final int getMoveUnitsPlunderSize() {
        return this.moveUnits_PlunderSize;
    }

    public final List<MoveUnits_Line> getCurrentRegroupArmyLine(int i) {
        return this.currentRegroupArmyLine.get(i);
    }

    public final RegroupArmy getRegroupArmy(int i) {
        return this.civGD.lRegroupArmy.get(i);
    }

    public final long isRegroupingArmy_ToProvID(int toProvinceID) {
        for (int i = 0; i < this.civGD.iRegroupArmySize; ++i) {
            if (this.civGD.lRegroupArmy.get(i).getToProvinceID() != toProvinceID) continue;
            return this.civGD.lRegroupArmy.get(i).getNumOfUnits();
        }
        return 0;
    }

    public final int getRegroupArmySize() {
        return this.civGD.iRegroupArmySize;
    }

    public final int getAlliance() {
        return this.civGD.allianceID;
    }

    public final void setIsPlayer(boolean controlledByPlayer) {
        this.controlledByPlayer = controlledByPlayer;
    }

    public final long getNumberOfUnits() {
        return this.numOfUnits;
    }

    public final void setNumberOfUnits(long iNumOfUnits) {
        this.numOfUnits = Math.max(iNumOfUnits, 0);
    }

    public final void updateNumberOfUnits() {
        int i;
        this.numOfUnits = 0;
        for (i = 0; i < this.getNumOfProvs(); ++i) {
            this.numOfUnits += CFG.core.getProv(this.getProvID(i)).getArmyCivID1(this.getCivId());
        }
        for (i = 0; i < this.moveUnitsSize(); ++i) {
            this.numOfUnits += this.getMoveUnits(i).getNumberOfUnits();
        }
        for (i = 0; i < this.getArmyInAnotherProvinceSize(); ++i) {
            this.numOfUnits += CFG.core.getProv(this.getArmyInAnotherProviP(i)).getArmyCivID1(this.getCivId());
        }
    }

    public final int getArmyInAnotherProviP(int i) {
        try {
            synchronized(this.armyInAnotherProv) {
                if (i >= 0 && i < this.armyInAnotherProv.size()) {
                    Integer val = this.armyInAnotherProv.get(i);
                    return val != null ? val : -1;
                }
            }
            return -1;
        }
        catch (Exception ex) {
            if (CFG.LOGs) {
                CFG.exceptionStack(ex);
            }
            return -1;
        }
    }

    public final int getRankPos() {
        return this.iRankPosition;
    }

    public final void setRankPos(int iRankPosition) {
        this.iRankPosition = iRankPosition;
    }

    public final long getRankScore() {
        return this.iRankScore;
    }

    public final void setRankScore(long iRankScore) {
        this.iRankScore = iRankScore;
    }

    public final int getIdeology() {
        return this.ideologyID;
    }

    public final int getAIStyleID() {
        return this.civGD.iAIStyleID;
    }

    public final void setAI_Style(int iAI_Style) {
        this.civGD.iAIStyleID = iAI_Style;
    }

    public final CivPersonality getCivPersonality() {
        return this.civGD.civPers;
    }

    public final CivPlans getCivPlans() {
        return this.civGD.civPlans;
    }

    public final boolean getIsAvailable() {
        return this.isAvailable;
    }

    public final void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public final long countPop() {
        long nPopulation = 0L;
        for (int i = 0; i < this.numOfProvinces; ++i) {
            nPopulation += (long)CFG.core.getProv(this.getProvID(i)).getPop().getPops();
        }
        return nPopulation;
    }

    public final long countPopWithoutOccupied() {
        long nPopulation = 0L;
        for (int i = 0; i < this.numOfProvinces; ++i) {
            if (CFG.core.getProv(this.getProvID(i)).isOccupied()) continue;
            nPopulation += (long)CFG.core.getProv(this.getProvID(i)).getPop().getPops();
        }
        return nPopulation;
    }

    public final long countEco() {
        long nEconomy = 0L;
        for (int i = 0; i < this.numOfProvinces; ++i) {
            nEconomy += (long)CFG.core.getProv(this.getProvID(i)).getEco();
        }
        return nEconomy;
    }

    public final long countEco_WithoutOccupied() {
        long nEconomy = 0L;
        for (int i = 0; i < this.numOfProvinces; ++i) {
            if (CFG.core.getProv(this.getProvID(i)).isOccupied()) continue;
            nEconomy += (long)CFG.core.getProv(this.getProvID(i)).getEco();
        }
        return nEconomy;
    }

    public final float getTechLevel() {
        return (float)this.civGD.techLevel / 100.0f;
    }

    public final int getTechLevelINT() {
        return this.civGD.techLevel;
    }

    public final void setTechLevel(float nTechnologyLevel) {
        this.civGD.techLevel = (int)Math.max(1.0f, nTechnologyLevel * 100.0f);
        if ((float)this.civGD.techLevel > GameValues.gvTechnology.MAX_TECHNOLOGY_LEVEL * 100.0f) {
            this.civGD.techLevel = (int)(GameValues.gvTechnology.MAX_TECHNOLOGY_LEVEL * 100.0f);
        }
    }

    public final int sanctionsTurns(int byCivID, int onCivID) {
        for (int i = 0; i < this.civGD.lSanctions.size(); ++i) {
            if ((this.civGD.lSanctions.get((int)i).byCivID != byCivID || this.civGD.lSanctions.get((int)i).onCivID != onCivID) && (this.civGD.lSanctions.get((int)i).byCivID != onCivID || this.civGD.lSanctions.get((int)i).onCivID != byCivID)) continue;
            return this.civGD.lSanctions.get((int)i).untilTurnID;
        }
        return 0;
    }

    public final float getSpendingGoodsB() {
        return this.civGD.spendingsGoods;
    }

    public final void setSpendingGoodsB(float fSpendings_Goods) {
        this.civGD.spendingsGoods = fSpendings_Goods;
        if (this.civGD.spendingsGoods < 0.0f) {
            this.civGD.spendingsGoods = 0.0f;
        } else if (this.civGD.spendingsGoods > GameValues.gvInGame.getBudgetSpendingSliderMaxValue()) {
            this.civGD.spendingsGoods = GameValues.gvInGame.getBudgetSpendingSliderMaxValue();
        }
    }

    public final float getTaxationLvl() {
        return this.civGD.fTaxationLevel;
    }

    public final void setTaxationLvl(float fTaxationLevel) {
        this.civGD.fTaxationLevel = fTaxationLevel;
        if (this.civGD.fTaxationLevel < 0.0f) {
            this.civGD.fTaxationLevel = 0.0f;
        } else if (this.civGD.fTaxationLevel > 1.0f) {
            this.civGD.fTaxationLevel = 1.0f;
        }
    }

    public final int getDiploPoints() {
        return this.civGD.diploPoints;
    }

    public final void setDiploPoints(int nDiplomacyPoints) {
        if ((float)nDiplomacyPoints > (float)GameValues.gvDiplomacyPoints.MAX_DIPLOMACY_POINTS + (float)GameValues.gvDiplomacyPoints.MAX_DIPLOMACY_POINTS * this.getTechLevel() * GameValues.gvDiplomacy.MAX_DIPLOMACY_POINTS_TECHNOLOGY_MODIFIER_EXTRA && nDiplomacyPoints > this.civGD.diploPoints) {
            nDiplomacyPoints = (int)((float)GameValues.gvDiplomacyPoints.MAX_DIPLOMACY_POINTS + (float)GameValues.gvDiplomacyPoints.MAX_DIPLOMACY_POINTS * this.getTechLevel() * GameValues.gvDiplomacy.MAX_DIPLOMACY_POINTS_TECHNOLOGY_MODIFIER_EXTRA);
        }
        this.civGD.diploPoints = Math.max(0, nDiplomacyPoints);
    }

    public final void setIdeology(int iIdeologyID) {
        this.ideologyID = iIdeologyID;
        this.setAI_Style(CFG.oAI.getAIStyle_ByTag(CFG.ideologiesMgr.getIdeologyID((int)this.getIdeology()).AI_TYPE));
    }

    public final int getSeaAccess() {
        return this.seaAccess;
    }

    public final void setSeaAccess(int seaAccess) {
        this.seaAccess = seaAccess;
    }

    public final void clearSeaAccess_Provinces() {
        this.seaAccessProvinces.clear();
    }

    public final void addSeaAccess_Provinces(int nProvinceID) {
        this.seaAccessProvinces.add(nProvinceID);
    }

    public final List<Integer> getSeaAccessProvinces() {
        return this.seaAccessProvinces;
    }

    public final int getSeaAccess_Provinces_Size() {
        return this.seaAccessProvinces.size();
    }

    public final void clearSeaAccess_PortProvinces() {
        this.seaAccessPort.clear();
    }

    public final void addSeaAccess_PortProvinces(int nProvinceID) {
        this.seaAccessPort.add(nProvinceID);
    }

    public final List<Integer> getSeaAccess_PortProvinces() {
        return this.seaAccessPort;
    }

    public final int getSeaAccess_PortProvinces_Size() {
        return this.seaAccessPort.size();
    }

    public final int getBordersWithEnemy() {
        return this.bordersWithEnemy;
    }

    public final void setBordersWithEnemy(int bordersWithEnemy) {
        this.bordersWithEnemy = bordersWithEnemy;
    }

    public final boolean isAtWarC() {
        return !this.isAtWarWithCivs.isEmpty();
    }

    public final int getNumOfNeighboringNeutralProvinces() {
        return this.iNumOfNeighboringNeutralProvinces;
    }

    public final void setNumOfNeighboringNeutralProvinces(int iNumOfNeighboringNeutralProvinces) {
        this.iNumOfNeighboringNeutralProvinces = iNumOfNeighboringNeutralProvinces;
    }

    public final void clearTagsCanForm() {
        this.tagsCanForm.clear();
    }

    public final int getTagsCanFormCSize() {
        return this.tagsCanForm.size();
    }

    public final String getTagsCanFormC(int i) {
        return this.tagsCanForm.get(i);
    }

    public final void addTagsCanForm(String nTag) {
        for (int i = 0; i < this.tagsCanForm.size(); ++i) {
            if (!this.tagsCanForm.get(i).equals(nTag)) continue;
            return;
        }
        this.tagsCanForm.add(nTag);
    }

    public final void addBlockedFormable(String nTag) {
        if (this.blockedFormables == null) {
            this.blockedFormables = new ArrayList<String>();
        }
        for (int i = 0; i < this.blockedFormables.size(); ++i) {
            if (!this.blockedFormables.get(i).equals(nTag)) continue;
            return;
        }
        this.blockedFormables.add(nTag);
    }

    public final boolean isFormableBlocked(String nTag) {
        if (this.blockedFormables == null) return false;
        for (int i = 0; i < this.blockedFormables.size(); ++i) {
            if (this.blockedFormables.get(i).equals(nTag)) return true;
        }
        return false;
    }

    public final boolean setMilitaryAccess7(int iID, int iNumOfTurns) {
        block8: {
            try {
                if (iNumOfTurns < 0) {
                    iNumOfTurns = 0;
                } else if (iNumOfTurns > GameValues.gvDipMilitaryAccess.DIPLOMACY_MAX_NUMBER_OF_TURNS_FOR_MILITARY_ACCESS) {
                    iNumOfTurns = GameValues.gvDipMilitaryAccess.DIPLOMACY_MAX_NUMBER_OF_TURNS_FOR_MILITARY_ACCESS;
                }
                try {
                    if (iNumOfTurns <= 0) {
                        this.militaryAccess.remove(iID);
                        break block8;
                    }
                    this.militaryAccess.put(iID, new DiplomacyData(iID, iNumOfTurns));
                }
                catch (Exception exception) {}
            }
            catch (Exception exception) {
                
            }
        }
        return false;
    }

    public final void disposeFlag() {
        this.isFlagNearest = false;
        this.iFVS = false;
        if (this.civFlag != null) {
            this.civFlag.getTexture().dispose();
            this.civFlag = null;
        }
    }

    public final void setFlag(Image nFlag) {
        this.disposeFlag();
        this.civFlag = nFlag;
        this.isFlagNearest = false;
        this.iFVS = false;
    }

    public final CivBonus_GameData getBonus(int i) {
        return this.civGD.bonusesCiv.get(i);
    }

    public final int getBonusesSize() {
        return this.civGD.bonusesCiv.size();
    }

    private final void applyBonusChanges(CivBonus_GameData nBonus) {
        this.civGD.modifier_PopGrowth += nBonus.fModifier_PopGrowth;
        this.civGD.modifier_EconomyGrowth += nBonus.fModifier_EconomyGrowth;
        this.civGD.modifier_IncomeTaxation += nBonus.fModifier_IncomeTaxation;
        this.civGD.modifier_IncomeProduction += nBonus.fModifier_IncomeProduction;
        this.civGD.modifier_Research += nBonus.fModifier_Research;
        this.civGD.modifier_MilitaryUpkeep += nBonus.fModifier_MilitaryUpkeep;
        this.civGD.modifier_AttackBonus += nBonus.fModifier_AttackBonus;
        this.civGD.modifier_DefenseBonus += nBonus.fModifier_DefenseBonus;
        this.civGD.modifier_MovementPoints += nBonus.fModifier_MovementPoints;
    }

    public final boolean isInvestOrganized_Devel(int nProvinceID) {
        for (int i = 0; i < this.civGD.investsDev.size(); ++i) {
            if (nProvinceID != this.civGD.investsDev.get((int)i).provinceID) continue;
            return true;
        }
        return false;
    }

    public final int isInvestOrganized_TurnsLeft_Devel(int nProvinceID) {
        for (int i = 0; i < this.civGD.investsDev.size(); ++i) {
            if (nProvinceID != this.civGD.investsDev.get((int)i).provinceID) continue;
            return this.civGD.investsDev.get((int)i).turnsLeft;
        }
        return 0;
    }

    public final CivInvest_Development isInvestOrganized_GET_Development(int nProvinceID) {
        for (int i = 0; i < this.civGD.investsDev.size(); ++i) {
            if (nProvinceID != this.civGD.investsDev.get((int)i).provinceID) continue;
            return this.civGD.investsDev.get(i);
        }
        return null;
    }

    private final void applyBonusChangesExpired(CivBonus_GameData nBonus) {
        this.civGD.modifier_PopGrowth -= nBonus.fModifier_PopGrowth;
        this.civGD.modifier_EconomyGrowth -= nBonus.fModifier_EconomyGrowth;
        this.civGD.modifier_IncomeTaxation -= nBonus.fModifier_IncomeTaxation;
        this.civGD.modifier_IncomeProduction -= nBonus.fModifier_IncomeProduction;
        this.civGD.modifier_Research -= nBonus.fModifier_Research;
        this.civGD.modifier_MilitaryUpkeep -= nBonus.fModifier_MilitaryUpkeep;
        this.civGD.modifier_AttackBonus -= nBonus.fModifier_AttackBonus;
        this.civGD.modifier_DefenseBonus -= nBonus.fModifier_DefenseBonus;
        this.civGD.modifier_MovementPoints -= nBonus.fModifier_MovementPoints;
    }

    public final float getModifier_PopGrowth() {
        return this.civGD.modifier_PopGrowth;
    }

    public final void setModifier_PopGrowth(float fModifier_PopGrowth) {
        this.civGD.modifier_PopGrowth = fModifier_PopGrowth;
    }

    public final float getModifier_EconomyGrowth() {
        return this.civGD.modifier_EconomyGrowth;
    }

    public final void setModifier_EconomyGrowth(float fModifier_EconomyGrowth) {
        this.civGD.modifier_EconomyGrowth = fModifier_EconomyGrowth;
    }

    public final float getModifier_IncomeTaxation() {
        return this.civGD.modifier_IncomeTaxation;
    }

    public final float getModifier_Administation() {
        return this.civGD.modifier_Administration;
    }

    public final void setModifier_IncomeTaxation(float fModifier_IncomeTaxation) {
        this.civGD.modifier_IncomeTaxation = fModifier_IncomeTaxation;
    }

    public final float getModifier_IncomeProduction() {
        return this.civGD.modifier_IncomeProduction;
    }

    public final void setModifier_IncomeProduction(float fModifier_IncomeProduction) {
        this.civGD.modifier_IncomeProduction = fModifier_IncomeProduction;
    }

    public final float getModifier_Research() {
        return this.civGD.modifier_Research;
    }

    public final void setModifier_Research(float fModifier_Research) {
        this.civGD.modifier_Research = fModifier_Research;
    }

    public final float getModifier_MilitaryUpkeep() {
        return this.civGD.modifier_MilitaryUpkeep;
    }

    public final void setModifier_MilitaryUpkeep(float fModifier_MilitaryUpkeep) {
        this.civGD.modifier_MilitaryUpkeep = fModifier_MilitaryUpkeep;
    }

    public final float getModifier_AttackBonus() {
        return this.civGD.modifier_AttackBonus;
    }

    public final void setModifier_AttackBonus(float fModifier_AttackBonus) {
        this.civGD.modifier_AttackBonus = fModifier_AttackBonus;
    }

    public final float getModifier_DefenseBonus() {
        return this.civGD.modifier_DefenseBonus;
    }

    public final void setModifier_DefenseBonus(float fModifier_DefenseBonus) {
        this.civGD.modifier_DefenseBonus = fModifier_DefenseBonus;
    }

    public final float getModifier_MovementPoints() {
        return this.civGD.modifier_MovementPoints;
    }

    public final void setModifier_MovementPoints(float fModifier_MovementPoints) {
        this.civGD.modifier_MovementPoints = fModifier_MovementPoints;
    }

    public int getGoldenAge_Science() {
        return this.civGD.goldenAge_Science;
    }

    public void setGoldenAge_Science(int iGoldenAge_Science) {
        this.civGD.goldenAge_Science = iGoldenAge_Science;
    }

    public int getGoldenAge_Military() {
        return this.civGD.goldenAge_Military;
    }

    public void setGoldenAge_Military(int iGoldenAge_Military) {
        this.civGD.goldenAge_Military = iGoldenAge_Military;
    }

    public int getGoldenAge_Prosperity() {
        return this.civGD.goldenAge_Prosperity;
    }

    public void setGoldenAge_Prosperity(int iGoldenAge_Prosperity) {
        this.civGD.goldenAge_Prosperity = iGoldenAge_Prosperity;
    }

    public final float getWarWeariness() {
        return this.civGD.warWeariness;
    }

    public final void setWarWeariness(float fWarWeariness) {
        if (fWarWeariness > GameValues.gvWarWeariness.WAR_WEARINESS_LIMIT) {
            fWarWeariness = GameValues.gvWarWeariness.WAR_WEARINESS_LIMIT;
        } else if (fWarWeariness < 0.0f) {
            fWarWeariness = 0.0f;
        }
        this.civGD.warWeariness = fWarWeariness;
    }

    public final boolean addHatedCiv(int nCivID) {
        for (int i = 0; i < this.getHatedCivsSize(); ++i) {
            if (nCivID != this.civGD.lHatedCivs.get((int)i).iCivID) continue;
            return false;
        }
        CFG.core.getCiv(nCivID).addHatedCiv_By(this.getCivId());
        this.civGD.lHatedCivs.add(new Civilization_Hated_GameData(nCivID));
        this.civGD.iHatedCivsSize = this.civGD.lHatedCivs.size();
        return true;
    }

    public final int getHatedCivsSize() {
        return this.civGD.iHatedCivsSize;
    }

    public final Civilization_Hated_GameData getHatedCiv(int i) {
        return this.civGD.lHatedCivs.get(i);
    }

    public final boolean isHatedCiv(int nCivID) {
        for (int i = this.getHatedCivsSize() - 1; i >= 0; --i) {
            if (this.civGD.lHatedCivs.get((int)i).iCivID != nCivID) continue;
            return true;
        }
        return false;
    }

    public final void clearHatedCivs() {
        for (int i = 0; i < this.getHatedCivsSize(); ++i) {
            CFG.core.getCiv(this.civGD.lHatedCivs.get((int)i).iCivID).removeHatedCiv_BY(this.getCivId());
        }
        this.civGD.lHatedCivs.clear();
        this.civGD.iHatedCivsSize = this.civGD.lHatedCivs.size();
    }

    public final void removeHatedCiv(int nCivID) {
        for (int i = this.getHatedCivsSize() - 1; i >= 0; --i) {
            if (this.civGD.lHatedCivs.get((int)i).iCivID != nCivID) continue;
            CFG.core.getCiv(this.civGD.lHatedCivs.get((int)i).iCivID).removeHatedCiv_BY(this.getCivId());
            this.civGD.lHatedCivs.remove(i);
            this.civGD.iHatedCivsSize = this.civGD.lHatedCivs.size();
            return;
        }
    }

    public final int getHatedCivs_BySize() {
        return this.civGD.iHatedCivs_BySize;
    }

    public final int getHatedCiv_By(int i) {
        return this.civGD.lHatedCivs_By.get(i);
    }

    public final void addHatedCiv_By(int nCivID) {
        for (int i = 0; i < this.getHatedCivs_BySize(); ++i) {
            if (this.civGD.lHatedCivs_By.get(i) != nCivID) continue;
            return;
        }
        this.civGD.lHatedCivs_By.add(nCivID);
        this.civGD.iHatedCivs_BySize = this.civGD.lHatedCivs_By.size();
    }

    public final void removeHatedCiv_BY(int nCivID) {
        for (int i = this.getHatedCivs_BySize() - 1; i >= 0; --i) {
            if (this.civGD.lHatedCivs_By.get(i) != nCivID) continue;
            this.civGD.lHatedCivs_By.remove(i);
            this.civGD.iHatedCivs_BySize = this.civGD.lHatedCivs_By.size();
            return;
        }
    }

    public final boolean addFriendlyCiv(int nCivID) {
        for (int i = 0; i < this.civGD.friendlyCivs.size(); ++i) {
            if (nCivID != this.civGD.friendlyCivs.get((int)i).iCivID) continue;
            return false;
        }
        this.civGD.friendlyCivs.add(new Civilization_Friends_GameData(nCivID, GameCalendar.TURNID));
        if (this.getIsPlayer()) {
            this.getCivDiploGD().messageBox.addMessage(new Message_Relations_Friendly(nCivID));
        }
        try {
            CFG.historyManager.addHistoryLog(new HistoryLog_FriendlyCivs(this.getCivId(), nCivID));
        }
        catch (NullPointerException nullPointerException) {
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            
        }
        return true;
    }

    public final void updateFriendlyCiv() {
    }

    public final int getFriendlyCivsSize() {
        return this.civGD.friendlyCivs.size();
    }

    public final Civilization_Friends_GameData getFriendlyCiv(int i) {
        return this.civGD.friendlyCivs.get(i);
    }

    public final int isFriendlyCiv(int nCivID) {
        for (int i = this.civGD.friendlyCivs.size() - 1; i >= 0; --i) {
            if (this.civGD.friendlyCivs.get((int)i).iCivID != nCivID) continue;
            return (int)Math.ceil(this.civGD.friendlyCivs.get((int)i).iSinceTurnID);
        }
        return -1;
    }

    public final void clearFriendlyCivs() {
        this.civGD.friendlyCivs.clear();
    }

    public final void removeFriendlyCiv(int nCivID) {
        for (int i = this.civGD.friendlyCivs.size() - 1; i >= 0; --i) {
            if (this.civGD.friendlyCivs.get((int)i).iCivID != nCivID) continue;
            this.civGD.friendlyCivs.remove(i);
            return;
        }
    }

    public final void addSentMessages(Civilization_SentMessages nSentMessage) {
        for (int i = this.civGD.sentMessages.size() - 1; i >= 0; --i) {
            if (this.civGD.sentMessages.get((int)i).iToCivID != nSentMessage.iToCivID || this.civGD.sentMessages.get((int)i).messageType != nSentMessage.messageType) continue;
            this.civGD.sentMessages.get((int)i).iSentInTurnID = GameCalendar.TURNID;
            return;
        }
        this.civGD.sentMessages.add(nSentMessage);
    }

    public final void clearSentMessages() {
        this.civGD.sentMessages.clear();
    }

    public final void removeSentMessages(MessageType nMessageType) {
        for (int i = this.civGD.sentMessages.size() - 1; i >= 0; --i) {
            if (this.civGD.sentMessages.get((int)i).messageType != nMessageType) continue;
            this.civGD.sentMessages.remove(i);
        }
    }

    public final void removeSentMessage(int i) {
        this.civGD.sentMessages.remove(i);
    }

    public final boolean messageWasSent(int nToCivID, MessageType nMessageType) {
        for (int i = this.civGD.sentMessages.size() - 1; i >= 0; --i) {
            if (this.civGD.sentMessages.get((int)i).iToCivID != nToCivID || this.civGD.sentMessages.get((int)i).messageType != nMessageType) continue;
            return true;
        }
        return false;
    }

    public final boolean messageWasSent(int nToCivID) {
        for (int i = this.civGD.sentMessages.size() - 1; i >= 0; --i) {
            if (this.civGD.sentMessages.get((int)i).iToCivID != nToCivID) continue;
            return true;
        }
        return false;
    }

    public final boolean messageWasSent(MessageType nMessageType) {
        for (int i = this.civGD.sentMessages.size() - 1; i >= 0; --i) {
            if (this.civGD.sentMessages.get((int)i).messageType != nMessageType) continue;
            return true;
        }
        return false;
    }

    public final void setLeaderN(LeaderOfCiv_GameData nLeaderData) {
        if (this.civGD.leaderData != null) {
            this.civGD.modifier_PopGrowth -= this.civGD.leaderData.fModifier_PopGrowth;
            this.civGD.modifier_EconomyGrowth -= this.civGD.leaderData.fModifier_EconomyGrowth;
            this.civGD.modifier_IncomeTaxation -= this.civGD.leaderData.fModifier_IncomeTaxation;
            this.civGD.modifier_IncomeProduction -= this.civGD.leaderData.fModifier_IncomeProduction;
            this.civGD.modifier_Administration -= this.civGD.leaderData.fModifier_Administration;
            this.civGD.modifier_Research -= this.civGD.leaderData.fModifier_Research;
            this.civGD.modifier_MilitaryUpkeep -= this.civGD.leaderData.fModifier_MilitaryUpkeep;
            this.civGD.modifier_AttackBonus -= this.civGD.leaderData.fModifier_AttackBonus;
            this.civGD.modifier_DefenseBonus -= this.civGD.leaderData.fModifier_DefenseBonus;
            this.civGD.modifier_MovementPoints -= this.civGD.leaderData.fModifier_MovementPoints;
        }
        if (nLeaderData != null) {
            if (nLeaderData.fModifier_PopGrowth > GameValues.gvLeader.LEADER_MAX_VALUE) {
                nLeaderData.fModifier_PopGrowth = GameValues.gvLeader.LEADER_MAX_VALUE;
            } else if (nLeaderData.fModifier_PopGrowth < GameValues.gvLeader.LEADER_MIN_VALUE) {
                nLeaderData.fModifier_PopGrowth = GameValues.gvLeader.LEADER_MIN_VALUE;
            }
            if (nLeaderData.fModifier_EconomyGrowth > GameValues.gvLeader.LEADER_MAX_VALUE) {
                nLeaderData.fModifier_EconomyGrowth = GameValues.gvLeader.LEADER_MAX_VALUE;
            } else if (nLeaderData.fModifier_EconomyGrowth < GameValues.gvLeader.LEADER_MIN_VALUE) {
                nLeaderData.fModifier_EconomyGrowth = GameValues.gvLeader.LEADER_MIN_VALUE;
            }
            if (nLeaderData.fModifier_IncomeTaxation > GameValues.gvLeader.LEADER_MAX_VALUE) {
                nLeaderData.fModifier_IncomeTaxation = GameValues.gvLeader.LEADER_MAX_VALUE;
            } else if (nLeaderData.fModifier_IncomeTaxation < GameValues.gvLeader.LEADER_MIN_VALUE) {
                nLeaderData.fModifier_IncomeTaxation = GameValues.gvLeader.LEADER_MIN_VALUE;
            }
            if (nLeaderData.fModifier_IncomeProduction > GameValues.gvLeader.LEADER_MAX_VALUE) {
                nLeaderData.fModifier_IncomeProduction = GameValues.gvLeader.LEADER_MAX_VALUE;
            } else if (nLeaderData.fModifier_IncomeProduction < GameValues.gvLeader.LEADER_MIN_VALUE) {
                nLeaderData.fModifier_IncomeProduction = GameValues.gvLeader.LEADER_MIN_VALUE;
            }
            if (nLeaderData.fModifier_Administration > GameValues.gvLeader.LEADER_MAX_VALUE) {
                nLeaderData.fModifier_Administration = GameValues.gvLeader.LEADER_MAX_VALUE;
            } else if (nLeaderData.fModifier_Administration < GameValues.gvLeader.LEADER_MIN_VALUE) {
                nLeaderData.fModifier_Administration = GameValues.gvLeader.LEADER_MIN_VALUE;
            }
            if (nLeaderData.fModifier_Research > GameValues.gvLeader.LEADER_MAX_VALUE) {
                nLeaderData.fModifier_Research = GameValues.gvLeader.LEADER_MAX_VALUE;
            } else if (nLeaderData.fModifier_Research < GameValues.gvLeader.LEADER_MIN_VALUE) {
                nLeaderData.fModifier_Research = GameValues.gvLeader.LEADER_MIN_VALUE;
            }
            if (nLeaderData.fModifier_MilitaryUpkeep > GameValues.gvLeader.LEADER_MAX_VALUE) {
                nLeaderData.fModifier_MilitaryUpkeep = GameValues.gvLeader.LEADER_MAX_VALUE;
            } else if (nLeaderData.fModifier_MilitaryUpkeep < GameValues.gvLeader.LEADER_MIN_VALUE) {
                nLeaderData.fModifier_MilitaryUpkeep = GameValues.gvLeader.LEADER_MIN_VALUE;
            }
            if (nLeaderData.fModifier_AttackBonus > GameValues.gvLeader.LEADER_MAX_VALUE) {
                nLeaderData.fModifier_AttackBonus = GameValues.gvLeader.LEADER_MAX_VALUE;
            } else if (nLeaderData.fModifier_AttackBonus < GameValues.gvLeader.LEADER_MIN_VALUE) {
                nLeaderData.fModifier_AttackBonus = GameValues.gvLeader.LEADER_MIN_VALUE;
            }
            if (nLeaderData.fModifier_DefenseBonus > GameValues.gvLeader.LEADER_MAX_VALUE) {
                nLeaderData.fModifier_DefenseBonus = GameValues.gvLeader.LEADER_MAX_VALUE;
            } else if (nLeaderData.fModifier_DefenseBonus < GameValues.gvLeader.LEADER_MIN_VALUE) {
                nLeaderData.fModifier_DefenseBonus = GameValues.gvLeader.LEADER_MIN_VALUE;
            }
            if (nLeaderData.fModifier_MovementPoints > GameValues.gvLeader.LEADER_MAX_VALUE) {
                nLeaderData.fModifier_MovementPoints = GameValues.gvLeader.LEADER_MAX_VALUE;
            } else if (nLeaderData.fModifier_MovementPoints < GameValues.gvLeader.LEADER_MIN_VALUE) {
                nLeaderData.fModifier_MovementPoints = GameValues.gvLeader.LEADER_MIN_VALUE;
            }
            this.civGD.modifier_PopGrowth += nLeaderData.fModifier_PopGrowth;
            this.civGD.modifier_EconomyGrowth += nLeaderData.fModifier_EconomyGrowth;
            this.civGD.modifier_IncomeTaxation += nLeaderData.fModifier_IncomeTaxation;
            this.civGD.modifier_IncomeProduction += nLeaderData.fModifier_IncomeProduction;
            this.civGD.modifier_Administration += nLeaderData.fModifier_Administration;
            this.civGD.modifier_Research += nLeaderData.fModifier_Research;
            this.civGD.modifier_MilitaryUpkeep += nLeaderData.fModifier_MilitaryUpkeep;
            this.civGD.modifier_AttackBonus += nLeaderData.fModifier_AttackBonus;
            this.civGD.modifier_DefenseBonus += nLeaderData.fModifier_DefenseBonus;
            this.civGD.modifier_MovementPoints += nLeaderData.fModifier_MovementPoints;
        }
        this.civGD.leaderData = nLeaderData;
    }

    public final void addNewSanctions(Civilization_Sanctions civSanctions) {
        if (this.areSanctionsAdded(civSanctions.byCivID, civSanctions.onCivID)) {
            return;
        }
        this.civGD.lSanctions.add(civSanctions);
        this.updateSanctionsImpact();
    }

    public final void updateSanctionsTurns() {
        if (!this.civGD.lSanctions.isEmpty()) {
            for (int i = this.civGD.lSanctions.size() - 1; i >= 0; --i) {
                if (GameCalendar.TURNID >= this.civGD.lSanctions.get((int)i).untilTurnID) {
                    if (CFG.core.getCiv(this.civGD.lSanctions.get((int)i).byCivID).getIsPlayer()) {
                        CFG.core.getCiv((int)this.civGD.lSanctions.get((int)i).byCivID).getCivDiploGD().messageBox.addMessage(new Message_SanctionsExpired(this.civGD.lSanctions.get((int)i).onCivID));
                    }
                    this.civGD.lSanctions.remove(i);
                    this.updateSanctionsImpact();
                    continue;
                }
                if (CFG.core.getCiv(this.civGD.lSanctions.get((int)i).byCivID).getNumOfProvs() != 0 && CFG.core.getCiv(this.civGD.lSanctions.get((int)i).onCivID).getNumOfProvs() != 0) continue;
                this.civGD.lSanctions.remove(i);
                this.updateSanctionsImpact();
            }
        }
    }

    public final void updateSanctionsImpact() {
        this.sanctionsImpact = 0.0f;
        for (int i = 0; i < this.civGD.lSanctions.size(); ++i) {
            this.sanctionsImpact += this.civGD.lSanctions.get((int)i).impact;
        }
        this.sanctionsImpact = Math.max(0.0f, Math.min(GameValues.gvSanctions.MAX_IMPACT_TOTAL, this.sanctionsImpact));
    }

    public boolean isRival(int civID) {
        for (int i = 0; i < this.civGD.civRivals.size(); ++i) {
            if (this.civGD.civRivals.get((int)i).iCivID != civID) continue;
            return true;
        }
        return false;
    }

    public class DiplomacyData {
        public int iCivID;
        public int iTurnID;

        public DiplomacyData(int iCivID, int iTurnID) {
            this.iCivID = iCivID;
            this.iTurnID = iTurnID;
        }
    }
}

