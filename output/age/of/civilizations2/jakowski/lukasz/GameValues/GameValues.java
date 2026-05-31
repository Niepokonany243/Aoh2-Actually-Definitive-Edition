
package age.of.civilizations2.jakowski.lukasz.GameValues;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Alliance;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Army;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Budget;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_CivPersonality;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_CivPersonalityType;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_CivsInRange;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Colonization;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_DeclareWar;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Diplomacy;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_FormCiv;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Invest;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Loan;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Nuke;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Province;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Relations;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Rivals;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Vassals;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_War;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_About;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Achievements;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Administration;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_AdministrationPolicy;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_AllianceOffer;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_ArmyDisband;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_ArmyRecruit;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_ArmyRecruitable;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Assimilate;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Atomic;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Battle;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_BuildingArmoury;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_BuildingFarm;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_BuildingFort;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_BuildingLibrary;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_BuildingMarket;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_BuildingPort;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_BuildingSupplyCamp;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_BuildingWatchTower;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_BuildingWorkshop;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Buildings;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Capital;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Capitulation;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Ceasefire;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Civilize;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Colonize;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Commands;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_DefensivePosition;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Development;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Dices;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Difficulty;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_DipCallToArms;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_DipDefensivePact;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_DipGuarantee;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_DipMilitaryAccess;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_DipNonAggression;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_DipTransferControl;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_DipTruce;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_DipUnion;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_DipVassalization;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Diplomacy;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_DiplomacyPoints;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Economy;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_EconomyGrowth;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_EnforcePeace;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Festival;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_FormCiv;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Gift;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_GoldenAge;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_GoldenAgeMilitary;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_GoldenAgeProsperity;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_GoldenAgeScience;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Goods;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Government;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_HRE;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Happiness;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_InGame;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Income;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_IncomeProduction;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_IncomeTaxation;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Inflation;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_InvestDevelopment;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_InvestEconomy;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_InvestForeign;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Leader;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Loan;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Logs;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_MapOverlays;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_MapScroll;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Migrate;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Military;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Move;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_MoveCapital;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_MovementPoints;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Outliner;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_OverInvestment;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_PeaceTreaty;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Plunder;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_PopRelocate;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_PopulationGrowth;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Propaganda;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Province;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_ProvinceAnimation;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_ProvinceBorder;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_ProvinceNotSupplied;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_ProvinceValue;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_RankScore;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_RankStars;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Rebels;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_RebelsIndependence;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_RebelsSupport;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_RelationDecrease;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_RelationImprove;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Relations;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_RelationsReactions;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Research;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_RevolutionaryRisk;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Sanctions;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_ServiceRibbon;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Ships;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Stability;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Summit;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Taxation;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Technology;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Timelapse;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Trade;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Tribal;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Ultimatum;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Update;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Vassal;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_VassalLiberty;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_War;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_WarPreparations;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_WarWeariness;
import age.of.civilizations2.jakowski.lukasz.GameValues.GV_Wonder;
import com.badlogic.gdx.utils.Json;

public class GameValues {
    public static GV_DefensivePosition gvDefensivePosition = new GV_DefensivePosition();
    public static GV_Military gvMilitary = new GV_Military();
    public static GV_Assimilate gvAssimilate = new GV_Assimilate();
    public static GV_RebelsSupport gvRebelsSupport = new GV_RebelsSupport();
    public static GV_Rebels gvRebels = new GV_Rebels();
    public static GV_Technology gvTechnology = new GV_Technology();
    public static GV_Civilize gvCivilize = new GV_Civilize();
    public static GV_Happiness gvHappiness = new GV_Happiness();
    public static GV_Stability gvStability = new GV_Stability();
    public static GV_Diplomacy gvDiplomacy = new GV_Diplomacy();
    public static GV_MovementPoints gvMovementPoints = new GV_MovementPoints();
    public static GV_Achievements gvAchievements = new GV_Achievements();
    public static GV_Logs gvLogs = new GV_Logs();
    public static GV_AI_CivPersonalityType gvAiCivPersonalityType = new GV_AI_CivPersonalityType();
    public static GV_Loan gvLoan = new GV_Loan();
    public static GV_Ceasefire gvCeasefire = new GV_Ceasefire();
    public static GV_Taxation gvTaxation = new GV_Taxation();
    public static GV_Goods gvGoods = new GV_Goods();
    public static GV_Development gvDevelopment = new GV_Development();
    public static GV_PopulationGrowth gvPopulationGrowth = new GV_PopulationGrowth();
    public static GV_EconomyGrowth gvEconomyGrowth = new GV_EconomyGrowth();
    public static GV_RevolutionaryRisk gvRevolutionaryRisk = new GV_RevolutionaryRisk();
    public static GV_RelationDecrease gvRelationDecrease = new GV_RelationDecrease();
    public static GV_RelationImprove gvRelationImprove = new GV_RelationImprove();
    public static GV_Plunder gvPlunder = new GV_Plunder();
    public static GV_Genocide gvGenocide = new GV_Genocide();
    public static GV_Government gvGovernment = new GV_Government();
    public static GV_Relations gvRelations = new GV_Relations();
    public static GV_Update gvUpdate = new GV_Update();
    public static GV_PeaceTreaty gvPeaceTreaty = new GV_PeaceTreaty();
    public static GV_Ultimatum gvUltimatum = new GV_Ultimatum();
    public static GV_Gift gvGift = new GV_Gift();
    public static GV_Province gvProvince = new GV_Province();
    public static GV_Colonize gvColonize = new GV_Colonize();
    public static GV_Festival gvFestival = new GV_Festival();
    public static GV_InvestDevelopment gvInvestDevelopment = new GV_InvestDevelopment();
    public static GV_InvestEconomy gvInvestEconomy = new GV_InvestEconomy();
    public static GV_RelationsReactions gvRelationsReactions = new GV_RelationsReactions();
    public static GV_DipTruce gvDipTruce = new GV_DipTruce();
    public static GV_DipDefensivePact gvDipDefensivePact = new GV_DipDefensivePact();
    public static GV_DipNonAggression gvDipNonAggression = new GV_DipNonAggression();
    public static GV_DipGuarantee gvDipGuarantee = new GV_DipGuarantee();
    public static GV_DipMilitaryAccess gvDipMilitaryAccess = new GV_DipMilitaryAccess();
    public static GV_Capitulation gvCapitulation = new GV_Capitulation();
    public static GV_DiplomacyPoints gvDiplomacyPoints = new GV_DiplomacyPoints();
    public static GV_AllianceOffer gvAllianceOffer = new GV_AllianceOffer();
    public static GV_DipVassalization gvDipVassalization = new GV_DipVassalization();
    public static GV_Trade gvTrade = new GV_Trade();
    public static GV_WarPreparations gvWarPreparations = new GV_WarPreparations();
    public static GV_DipUnion gvDipUnion = new GV_DipUnion();
    public static GV_DipTransferControl gvDipTransferControl = new GV_DipTransferControl();
    public static GV_DipCallToArms gvDipCallToArms = new GV_DipCallToArms();
    public static GV_GoldenAge gvGoldenAge = new GV_GoldenAge();
    public static GV_GoldenAgeProsperity gvGoldenAgeProsperity = new GV_GoldenAgeProsperity();
    public static GV_GoldenAgeMilitary gvGoldenAgeMilitary = new GV_GoldenAgeMilitary();
    public static GV_GoldenAgeScience gvGoldenAgeScience = new GV_GoldenAgeScience();
    public static GV_Difficulty gvDifficulty = new GV_Difficulty();
    public static GV_ProvinceAnimation gvProvinceAnimation = new GV_ProvinceAnimation();
    public static GV_ProvinceBorder gvProvinceBorder = new GV_ProvinceBorder();
    public static GV_Vassal gvVassal = new GV_Vassal();
    public static GV_Timelapse gvTimelapse = new GV_Timelapse();
    public static GV_HRE gvHre = new GV_HRE();
    public static GV_RebelsIndependence gvRebelsIndependence = new GV_RebelsIndependence();
    public static GV_Battle gvBattle = new GV_Battle();
    public static GV_ArmyRecruitable gvArmyRecruitable = new GV_ArmyRecruitable();
    public static GV_Move gvMove = new GV_Move();
    public static GV_Economy gvEconomy = new GV_Economy();
    public static GV_Dices gvDices = new GV_Dices();
    public static GV_Capital gvCapital = new GV_Capital();
    public static GV_Buildings gvBuildings = new GV_Buildings();
    public static GV_ProvinceNotSupplied gvProvinceNotSupplied = new GV_ProvinceNotSupplied();
    public static GV_ArmyRecruit gvArmyRecruit = new GV_ArmyRecruit();
    public static GV_FormCiv gvFormCiv = new GV_FormCiv();
    public static GV_BuildingArmoury gvBuildingArmoury = new GV_BuildingArmoury();
    public static GV_RankStars gvRankStars = new GV_RankStars();
    public static GV_RankScore gvRankScore = new GV_RankScore();
    public static GV_MoveCapital gvMoveCapital = new GV_MoveCapital();
    public static GV_ArmyDisband gvArmyDisband = new GV_ArmyDisband();
    public static GV_Migrate gvMigrate = new GV_Migrate();
    public static GV_Research gvResearch = new GV_Research();
    public static GV_BuildingFort gvBuildingFort = new GV_BuildingFort();
    public static GV_BuildingWatchTower gvBuildingWatchTower = new GV_BuildingWatchTower();
    public static GV_BuildingPort gvBuildingPort = new GV_BuildingPort();
    public static GV_BuildingSupplyCamp gvBuildingSupplyCamp = new GV_BuildingSupplyCamp();
    public static GV_BuildingFarm gvBuildingFarm = new GV_BuildingFarm();
    public static GV_BuildingLibrary gvBuildingLibrary = new GV_BuildingLibrary();
    public static GV_BuildingWorkshop gvBuildingWorkshop = new GV_BuildingWorkshop();
    public static GV_BuildingMarket gvBuildingMarket = new GV_BuildingMarket();
    public static GV_Income gvIncome = new GV_Income();
    public static GV_IncomeTaxation gvIncomeTaxation = new GV_IncomeTaxation();
    public static GV_IncomeProduction gvIncomeProduction = new GV_IncomeProduction();
    public static GV_Inflation gvInflation = new GV_Inflation();
    public static GV_Administration gvAdministration = new GV_Administration();
    public static GV_ServiceRibbon gvServiceRibbon = new GV_ServiceRibbon();
    public static GV_War gvWar = new GV_War();
    public static GV_ProvinceValue gvProvinceValue = new GV_ProvinceValue();
    public static GV_Leader gvLeader = new GV_Leader();
    public static GV_InGame gvInGame = new GV_InGame();
    public static GV_MapOverlays gvMapOverlays = new GV_MapOverlays();
    public static GV_Core gvCore = new GV_Core();
    public static GV_About gvAbout = new GV_About();
    public static GV_Outliner gvOutliner = new GV_Outliner();
    public static GV_WarWeariness gvWarWeariness = new GV_WarWeariness();
    public static GV_Atomic gvAtomic = new GV_Atomic();
    public static GV_Missiles gvMissiles = new GV_Missiles();
    public static GV_AirDefense gvAirDefense = new GV_AirDefense();
    public static GV_PopRelocate gvPopRelocate = new GV_PopRelocate();
    public static GV_VassalLiberty gvVassalLiberty = new GV_VassalLiberty();
    public static GV_Commands gvCommands = new GV_Commands();
    public static GV_Tribal gvTribal = new GV_Tribal();
    public static GV_EnforcePeace gvEnforcePeace = new GV_EnforcePeace();
    public static GV_InvestForeign gvInvestForeign = new GV_InvestForeign();
    public static GV_Summit gvSummit = new GV_Summit();
    public static GV_Propaganda gvPropaganda = new GV_Propaganda();
    public static GV_OverInvestment gvOverInvestment = new GV_OverInvestment();
    public static GV_Ships gvShips = new GV_Ships();
    public static GV_Wonder gvWonder = new GV_Wonder();
    public static GV_Sanctions gvSanctions = new GV_Sanctions();
    public static GV_AdministrationPolicy gvAdministrationPolicy = new GV_AdministrationPolicy();
    public static GV_AI_Nuke gvAiNuke = new GV_AI_Nuke();
    public static GV_AI_DeclareWar gvAiDeclareWar = new GV_AI_DeclareWar();
    public static GV_AI_Rivals gvAiRivals = new GV_AI_Rivals();
    public static GV_AI_Relations gvAiRelations = new GV_AI_Relations();
    public static GV_AI_CivsInRange gvAiCivsInRange = new GV_AI_CivsInRange();
    public static GV_AI_FormCiv gvAiFormCiv = new GV_AI_FormCiv();
    public static GV_AI_Vassals gvAiVassals = new GV_AI_Vassals();
    public static GV_AI_Alliance gvAiAlliance = new GV_AI_Alliance();
    public static GV_AI_Colonization gvAiColonization = new GV_AI_Colonization();
    public static GV_AI_Loan gvAiLoan = new GV_AI_Loan();
    public static GV_AI_Army gvAiArmy = new GV_AI_Army();
    public static GV_AI_Province gvAiProvince = new GV_AI_Province();
    public static GV_AI_Diplomacy gvAiDiplomacy = new GV_AI_Diplomacy();
    public static GV_AI_Invest gvAiInvest = new GV_AI_Invest();
    public static GV_AI_CivPersonality gvAiCivPersonality = new GV_AI_CivPersonality();
    public static GV_AI_War gvAiWar = new GV_AI_War();
    public static GV_AI_Budget gvAiBudget = new GV_AI_Budget();
    public static GV_MapScroll gvMapScroll = new GV_MapScroll();
    public static GV_RankingSystem gvRankingSystem = new GV_RankingSystem();
    public static int DEFAULT_FONT_SIZE = 18;

    public static final void init() {
        if (!CFG.getIsDesktop()) {
            return;
        }
        Json json = new Json();
        try {
            if (FileManager.loadFile("game/gameValues/gvDefensivePosition.json").exists()) {
                gvDefensivePosition = json.fromJson(GV_DefensivePosition.class, FileManager.loadFile("game/gameValues/gvDefensivePosition.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvMilitary.json").exists()) {
                gvMilitary = json.fromJson(GV_Military.class, FileManager.loadFile("game/gameValues/gvMilitary.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAssimilate.json").exists()) {
                gvAssimilate = json.fromJson(GV_Assimilate.class, FileManager.loadFile("game/gameValues/gvAssimilate.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvRebelsSupport.json").exists()) {
                gvRebelsSupport = json.fromJson(GV_RebelsSupport.class, FileManager.loadFile("game/gameValues/gvRebelsSupport.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvRebels.json").exists()) {
                gvRebels = json.fromJson(GV_Rebels.class, FileManager.loadFile("game/gameValues/gvRebels.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvTechnology.json").exists()) {
                gvTechnology = json.fromJson(GV_Technology.class, FileManager.loadFile("game/gameValues/gvTechnology.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvCivilize.json").exists()) {
                gvCivilize = json.fromJson(GV_Civilize.class, FileManager.loadFile("game/gameValues/gvCivilize.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvHappiness.json").exists()) {
                gvHappiness = json.fromJson(GV_Happiness.class, FileManager.loadFile("game/gameValues/gvHappiness.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvStability.json").exists()) {
                gvStability = json.fromJson(GV_Stability.class, FileManager.loadFile("game/gameValues/gvStability.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvDiplomacy.json").exists()) {
                gvDiplomacy = json.fromJson(GV_Diplomacy.class, FileManager.loadFile("game/gameValues/gvDiplomacy.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvMovementPoints.json").exists()) {
                gvMovementPoints = json.fromJson(GV_MovementPoints.class, FileManager.loadFile("game/gameValues/gvMovementPoints.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAchievements.json").exists()) {
                gvAchievements = json.fromJson(GV_Achievements.class, FileManager.loadFile("game/gameValues/gvAchievements.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvLogs.json").exists()) {
                gvLogs = json.fromJson(GV_Logs.class, FileManager.loadFile("game/gameValues/gvLogs.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        boolean gvAiCivPersonalityTypeLoaded = false;
        try {
            if (FileManager.loadFile("game/gameValues/gvAiCivPersonalityType.json").exists()) {
                gvAiCivPersonalityType = json.fromJson(GV_AI_CivPersonalityType.class, FileManager.loadFile("game/gameValues/gvAiCivPersonalityType.json"));
                gvAiCivPersonalityTypeLoaded = true;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvLoan.json").exists()) {
                gvLoan = json.fromJson(GV_Loan.class, FileManager.loadFile("game/gameValues/gvLoan.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvCeasefire.json").exists()) {
                gvCeasefire = json.fromJson(GV_Ceasefire.class, FileManager.loadFile("game/gameValues/gvCeasefire.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvTaxation.json").exists()) {
                gvTaxation = json.fromJson(GV_Taxation.class, FileManager.loadFile("game/gameValues/gvTaxation.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvGoods.json").exists()) {
                gvGoods = json.fromJson(GV_Goods.class, FileManager.loadFile("game/gameValues/gvGoods.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvDevelopment.json").exists()) {
                gvDevelopment = json.fromJson(GV_Development.class, FileManager.loadFile("game/gameValues/gvDevelopment.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvPopulationGrowth.json").exists()) {
                gvPopulationGrowth = json.fromJson(GV_PopulationGrowth.class, FileManager.loadFile("game/gameValues/gvPopulationGrowth.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvEconomyGrowth.json").exists()) {
                gvEconomyGrowth = json.fromJson(GV_EconomyGrowth.class, FileManager.loadFile("game/gameValues/gvEconomyGrowth.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvRevolutionaryRisk.json").exists()) {
                gvRevolutionaryRisk = json.fromJson(GV_RevolutionaryRisk.class, FileManager.loadFile("game/gameValues/gvRevolutionaryRisk.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvRelationDecrease.json").exists()) {
                gvRelationDecrease = json.fromJson(GV_RelationDecrease.class, FileManager.loadFile("game/gameValues/gvRelationDecrease.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvRelationImprove.json").exists()) {
                gvRelationImprove = json.fromJson(GV_RelationImprove.class, FileManager.loadFile("game/gameValues/gvRelationImprove.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvPlunder.json").exists()) {
                gvPlunder = json.fromJson(GV_Plunder.class, FileManager.loadFile("game/gameValues/gvPlunder.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvGovernment.json").exists()) {
                gvGovernment = json.fromJson(GV_Government.class, FileManager.loadFile("game/gameValues/gvGovernment.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvRelations.json").exists()) {
                gvRelations = json.fromJson(GV_Relations.class, FileManager.loadFile("game/gameValues/gvRelations.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvUpdate.json").exists()) {
                gvUpdate = json.fromJson(GV_Update.class, FileManager.loadFile("game/gameValues/gvUpdate.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvPeaceTreaty.json").exists()) {
                gvPeaceTreaty = json.fromJson(GV_PeaceTreaty.class, FileManager.loadFile("game/gameValues/gvPeaceTreaty.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvUltimatum.json").exists()) {
                gvUltimatum = json.fromJson(GV_Ultimatum.class, FileManager.loadFile("game/gameValues/gvUltimatum.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvGift.json").exists()) {
                gvGift = json.fromJson(GV_Gift.class, FileManager.loadFile("game/gameValues/gvGift.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvProvince.json").exists()) {
                gvProvince = json.fromJson(GV_Province.class, FileManager.loadFile("game/gameValues/gvProvince.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvColonize.json").exists()) {
                gvColonize = json.fromJson(GV_Colonize.class, FileManager.loadFile("game/gameValues/gvColonize.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvFestival.json").exists()) {
                gvFestival = json.fromJson(GV_Festival.class, FileManager.loadFile("game/gameValues/gvFestival.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvInvestDevelopment.json").exists()) {
                gvInvestDevelopment = json.fromJson(GV_InvestDevelopment.class, FileManager.loadFile("game/gameValues/gvInvestDevelopment.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvInvestEconomy.json").exists()) {
                gvInvestEconomy = json.fromJson(GV_InvestEconomy.class, FileManager.loadFile("game/gameValues/gvInvestEconomy.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvRelationsReactions.json").exists()) {
                gvRelationsReactions = json.fromJson(GV_RelationsReactions.class, FileManager.loadFile("game/gameValues/gvRelationsReactions.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvDipTruce.json").exists()) {
                gvDipTruce = json.fromJson(GV_DipTruce.class, FileManager.loadFile("game/gameValues/gvDipTruce.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvDipDefensivePact.json").exists()) {
                gvDipDefensivePact = json.fromJson(GV_DipDefensivePact.class, FileManager.loadFile("game/gameValues/gvDipDefensivePact.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvDipNonAggression.json").exists()) {
                gvDipNonAggression = json.fromJson(GV_DipNonAggression.class, FileManager.loadFile("game/gameValues/gvDipNonAggression.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvDipGuarantee.json").exists()) {
                gvDipGuarantee = json.fromJson(GV_DipGuarantee.class, FileManager.loadFile("game/gameValues/gvDipGuarantee.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvDipMilitaryAccess.json").exists()) {
                gvDipMilitaryAccess = json.fromJson(GV_DipMilitaryAccess.class, FileManager.loadFile("game/gameValues/gvDipMilitaryAccess.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvCapitulation.json").exists()) {
                gvCapitulation = json.fromJson(GV_Capitulation.class, FileManager.loadFile("game/gameValues/gvCapitulation.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvDiplomacyPoints.json").exists()) {
                gvDiplomacyPoints = json.fromJson(GV_DiplomacyPoints.class, FileManager.loadFile("game/gameValues/gvDiplomacyPoints.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAllianceOffer.json").exists()) {
                gvAllianceOffer = json.fromJson(GV_AllianceOffer.class, FileManager.loadFile("game/gameValues/gvAllianceOffer.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvDipVassalization.json").exists()) {
                gvDipVassalization = json.fromJson(GV_DipVassalization.class, FileManager.loadFile("game/gameValues/gvDipVassalization.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvTrade.json").exists()) {
                gvTrade = json.fromJson(GV_Trade.class, FileManager.loadFile("game/gameValues/gvTrade.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvWarPreparations.json").exists()) {
                gvWarPreparations = json.fromJson(GV_WarPreparations.class, FileManager.loadFile("game/gameValues/gvWarPreparations.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvDipUnion.json").exists()) {
                gvDipUnion = json.fromJson(GV_DipUnion.class, FileManager.loadFile("game/gameValues/gvDipUnion.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvDipTransferControl.json").exists()) {
                gvDipTransferControl = json.fromJson(GV_DipTransferControl.class, FileManager.loadFile("game/gameValues/gvDipTransferControl.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvDipCallToArms.json").exists()) {
                gvDipCallToArms = json.fromJson(GV_DipCallToArms.class, FileManager.loadFile("game/gameValues/gvDipCallToArms.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvGoldenAge.json").exists()) {
                gvGoldenAge = json.fromJson(GV_GoldenAge.class, FileManager.loadFile("game/gameValues/gvGoldenAge.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvGoldenAgeProsperity.json").exists()) {
                gvGoldenAgeProsperity = json.fromJson(GV_GoldenAgeProsperity.class, FileManager.loadFile("game/gameValues/gvGoldenAgeProsperity.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvGoldenAgeMilitary.json").exists()) {
                gvGoldenAgeMilitary = json.fromJson(GV_GoldenAgeMilitary.class, FileManager.loadFile("game/gameValues/gvGoldenAgeMilitary.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvGoldenAgeScience.json").exists()) {
                gvGoldenAgeScience = json.fromJson(GV_GoldenAgeScience.class, FileManager.loadFile("game/gameValues/gvGoldenAgeScience.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvDifficulty.json").exists()) {
                gvDifficulty = json.fromJson(GV_Difficulty.class, FileManager.loadFile("game/gameValues/gvDifficulty.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvProvinceAnimation.json").exists()) {
                gvProvinceAnimation = json.fromJson(GV_ProvinceAnimation.class, FileManager.loadFile("game/gameValues/gvProvinceAnimation.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvProvinceBorder.json").exists()) {
                gvProvinceBorder = json.fromJson(GV_ProvinceBorder.class, FileManager.loadFile("game/gameValues/gvProvinceBorder.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvVassal.json").exists()) {
                gvVassal = json.fromJson(GV_Vassal.class, FileManager.loadFile("game/gameValues/gvVassal.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvTimelapse.json").exists()) {
                gvTimelapse = json.fromJson(GV_Timelapse.class, FileManager.loadFile("game/gameValues/gvTimelapse.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvHre.json").exists()) {
                gvHre = json.fromJson(GV_HRE.class, FileManager.loadFile("game/gameValues/gvHre.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvRebelsIndependence.json").exists()) {
                gvRebelsIndependence = json.fromJson(GV_RebelsIndependence.class, FileManager.loadFile("game/gameValues/gvRebelsIndependence.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvBattle.json").exists()) {
                gvBattle = json.fromJson(GV_Battle.class, FileManager.loadFile("game/gameValues/gvBattle.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvArmyRecruitable.json").exists()) {
                gvArmyRecruitable = json.fromJson(GV_ArmyRecruitable.class, FileManager.loadFile("game/gameValues/gvArmyRecruitable.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvRankingSystem.json").exists()) {
                gvRankingSystem = json.fromJson(GV_RankingSystem.class, FileManager.loadFile("game/gameValues/gvRankingSystem.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvMove.json").exists()) {
                gvMove = json.fromJson(GV_Move.class, FileManager.loadFile("game/gameValues/gvMove.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvEconomy.json").exists()) {
                gvEconomy = json.fromJson(GV_Economy.class, FileManager.loadFile("game/gameValues/gvEconomy.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvDices.json").exists()) {
                gvDices = json.fromJson(GV_Dices.class, FileManager.loadFile("game/gameValues/gvDices.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvCapital.json").exists()) {
                gvCapital = json.fromJson(GV_Capital.class, FileManager.loadFile("game/gameValues/gvCapital.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvBuildings.json").exists()) {
                gvBuildings = json.fromJson(GV_Buildings.class, FileManager.loadFile("game/gameValues/gvBuildings.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvProvinceNotSupplied.json").exists()) {
                gvProvinceNotSupplied = json.fromJson(GV_ProvinceNotSupplied.class, FileManager.loadFile("game/gameValues/gvProvinceNotSupplied.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvArmyRecruit.json").exists()) {
                gvArmyRecruit = json.fromJson(GV_ArmyRecruit.class, FileManager.loadFile("game/gameValues/gvArmyRecruit.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvFormCiv.json").exists()) {
                gvFormCiv = json.fromJson(GV_FormCiv.class, FileManager.loadFile("game/gameValues/gvFormCiv.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvBuildingArmoury.json").exists()) {
                gvBuildingArmoury = json.fromJson(GV_BuildingArmoury.class, FileManager.loadFile("game/gameValues/gvBuildingArmoury.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final void init2() {
        if (!CFG.getIsDesktop()) {
            return;
        }
        Json json = new Json();
        try {
            if (FileManager.loadFile("game/gameValues/gvRankStars.json").exists()) {
                gvRankStars = json.fromJson(GV_RankStars.class, FileManager.loadFile("game/gameValues/gvRankStars.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvRankScore.json").exists()) {
                gvRankScore = json.fromJson(GV_RankScore.class, FileManager.loadFile("game/gameValues/gvRankScore.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvMoveCapital.json").exists()) {
                gvMoveCapital = json.fromJson(GV_MoveCapital.class, FileManager.loadFile("game/gameValues/gvMoveCapital.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvArmyDisband.json").exists()) {
                gvArmyDisband = json.fromJson(GV_ArmyDisband.class, FileManager.loadFile("game/gameValues/gvArmyDisband.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvMigrate.json").exists()) {
                gvMigrate = json.fromJson(GV_Migrate.class, FileManager.loadFile("game/gameValues/gvMigrate.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvResearch.json").exists()) {
                gvResearch = json.fromJson(GV_Research.class, FileManager.loadFile("game/gameValues/gvResearch.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvBuildingFort.json").exists()) {
                gvBuildingFort = json.fromJson(GV_BuildingFort.class, FileManager.loadFile("game/gameValues/gvBuildingFort.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvBuildingWatchTower.json").exists()) {
                gvBuildingWatchTower = json.fromJson(GV_BuildingWatchTower.class, FileManager.loadFile("game/gameValues/gvBuildingWatchTower.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvBuildingPort.json").exists()) {
                gvBuildingPort = json.fromJson(GV_BuildingPort.class, FileManager.loadFile("game/gameValues/gvBuildingPort.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvBuildingSupplyCamp.json").exists()) {
                gvBuildingSupplyCamp = json.fromJson(GV_BuildingSupplyCamp.class, FileManager.loadFile("game/gameValues/gvBuildingSupplyCamp.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvBuildingFarm.json").exists()) {
                gvBuildingFarm = json.fromJson(GV_BuildingFarm.class, FileManager.loadFile("game/gameValues/gvBuildingFarm.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvBuildingLibrary.json").exists()) {
                gvBuildingLibrary = json.fromJson(GV_BuildingLibrary.class, FileManager.loadFile("game/gameValues/gvBuildingLibrary.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvBuildingWorkshop.json").exists()) {
                gvBuildingWorkshop = json.fromJson(GV_BuildingWorkshop.class, FileManager.loadFile("game/gameValues/gvBuildingWorkshop.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvBuildingMarket.json").exists()) {
                gvBuildingMarket = json.fromJson(GV_BuildingMarket.class, FileManager.loadFile("game/gameValues/gvBuildingMarket.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvIncome.json").exists()) {
                gvIncome = json.fromJson(GV_Income.class, FileManager.loadFile("game/gameValues/gvIncome.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvIncomeTaxation.json").exists()) {
                gvIncomeTaxation = json.fromJson(GV_IncomeTaxation.class, FileManager.loadFile("game/gameValues/gvIncomeTaxation.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvIncomeProduction.json").exists()) {
                gvIncomeProduction = json.fromJson(GV_IncomeProduction.class, FileManager.loadFile("game/gameValues/gvIncomeProduction.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvInflation.json").exists()) {
                gvInflation = json.fromJson(GV_Inflation.class, FileManager.loadFile("game/gameValues/gvInflation.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAdministration.json").exists()) {
                gvAdministration = json.fromJson(GV_Administration.class, FileManager.loadFile("game/gameValues/gvAdministration.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvServiceRibbon.json").exists()) {
                gvServiceRibbon = json.fromJson(GV_ServiceRibbon.class, FileManager.loadFile("game/gameValues/gvServiceRibbon.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvWar.json").exists()) {
                gvWar = json.fromJson(GV_War.class, FileManager.loadFile("game/gameValues/gvWar.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvProvinceValue.json").exists()) {
                gvProvinceValue = json.fromJson(GV_ProvinceValue.class, FileManager.loadFile("game/gameValues/gvProvinceValue.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvLeader.json").exists()) {
                gvLeader = json.fromJson(GV_Leader.class, FileManager.loadFile("game/gameValues/gvLeader.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvInGame.json").exists()) {
                gvInGame = json.fromJson(GV_InGame.class, FileManager.loadFile("game/gameValues/gvInGame.json"));
                CFG.map.getMpB().updateMinimapResolution(1);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvMapOverlays.json").exists()) {
                gvMapOverlays = json.fromJson(GV_MapOverlays.class, FileManager.loadFile("game/gameValues/gvMapOverlays.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvCore.json").exists()) {
                gvCore = json.fromJson(GV_Core.class, FileManager.loadFile("game/gameValues/gvCore.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAbout.json").exists()) {
                gvAbout = json.fromJson(GV_About.class, FileManager.loadFile("game/gameValues/gvAbout.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvOutliner.json").exists()) {
                gvOutliner = json.fromJson(GV_Outliner.class, FileManager.loadFile("game/gameValues/gvOutliner.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvWarWeariness.json").exists()) {
                gvWarWeariness = json.fromJson(GV_WarWeariness.class, FileManager.loadFile("game/gameValues/gvWarWeariness.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAtomic.json").exists()) {
                gvAtomic = json.fromJson(GV_Atomic.class, FileManager.loadFile("game/gameValues/gvAtomic.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvPopRelocate.json").exists()) {
                gvPopRelocate = json.fromJson(GV_PopRelocate.class, FileManager.loadFile("game/gameValues/gvPopRelocate.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvVassalLiberty.json").exists()) {
                gvVassalLiberty = json.fromJson(GV_VassalLiberty.class, FileManager.loadFile("game/gameValues/gvVassalLiberty.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvCommands.json").exists()) {
                gvCommands = json.fromJson(GV_Commands.class, FileManager.loadFile("game/gameValues/gvCommands.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvTribal.json").exists()) {
                gvTribal = json.fromJson(GV_Tribal.class, FileManager.loadFile("game/gameValues/gvTribal.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvEnforcePeace.json").exists()) {
                gvEnforcePeace = json.fromJson(GV_EnforcePeace.class, FileManager.loadFile("game/gameValues/gvEnforcePeace.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvInvestForeign.json").exists()) {
                gvInvestForeign = json.fromJson(GV_InvestForeign.class, FileManager.loadFile("game/gameValues/gvInvestForeign.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvSummit.json").exists()) {
                gvSummit = json.fromJson(GV_Summit.class, FileManager.loadFile("game/gameValues/gvSummit.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvPropaganda.json").exists()) {
                gvPropaganda = json.fromJson(GV_Propaganda.class, FileManager.loadFile("game/gameValues/gvPropaganda.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvOverInvestment.json").exists()) {
                gvOverInvestment = json.fromJson(GV_OverInvestment.class, FileManager.loadFile("game/gameValues/gvOverInvestment.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvShips.json").exists()) {
                gvShips = json.fromJson(GV_Ships.class, FileManager.loadFile("game/gameValues/gvShips.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvWonder.json").exists()) {
                gvWonder = json.fromJson(GV_Wonder.class, FileManager.loadFile("game/gameValues/gvWonder.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvSanctions.json").exists()) {
                gvSanctions = json.fromJson(GV_Sanctions.class, FileManager.loadFile("game/gameValues/gvSanctions.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAdministrationPolicy.json").exists()) {
                gvAdministrationPolicy = json.fromJson(GV_AdministrationPolicy.class, FileManager.loadFile("game/gameValues/gvAdministrationPolicy.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAiNuke.json").exists()) {
                gvAiNuke = json.fromJson(GV_AI_Nuke.class, FileManager.loadFile("game/gameValues/gvAiNuke.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAiDeclareWar.json").exists()) {
                gvAiDeclareWar = json.fromJson(GV_AI_DeclareWar.class, FileManager.loadFile("game/gameValues/gvAiDeclareWar.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAiRivals.json").exists()) {
                gvAiRivals = json.fromJson(GV_AI_Rivals.class, FileManager.loadFile("game/gameValues/gvAiRivals.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAiRelations.json").exists()) {
                gvAiRelations = json.fromJson(GV_AI_Relations.class, FileManager.loadFile("game/gameValues/gvAiRelations.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAiCivsInRange.json").exists()) {
                gvAiCivsInRange = json.fromJson(GV_AI_CivsInRange.class, FileManager.loadFile("game/gameValues/gvAiCivsInRange.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAiFormCiv.json").exists()) {
                gvAiFormCiv = json.fromJson(GV_AI_FormCiv.class, FileManager.loadFile("game/gameValues/gvAiFormCiv.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAiVassals.json").exists()) {
                gvAiVassals = json.fromJson(GV_AI_Vassals.class, FileManager.loadFile("game/gameValues/gvAiVassals.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAiAlliance.json").exists()) {
                gvAiAlliance = json.fromJson(GV_AI_Alliance.class, FileManager.loadFile("game/gameValues/gvAiAlliance.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAiColonization.json").exists()) {
                gvAiColonization = json.fromJson(GV_AI_Colonization.class, FileManager.loadFile("game/gameValues/gvAiColonization.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAiLoan.json").exists()) {
                gvAiLoan = json.fromJson(GV_AI_Loan.class, FileManager.loadFile("game/gameValues/gvAiLoan.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAiArmy.json").exists()) {
                gvAiArmy = json.fromJson(GV_AI_Army.class, FileManager.loadFile("game/gameValues/gvAiArmy.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAiProvince.json").exists()) {
                gvAiProvince = json.fromJson(GV_AI_Province.class, FileManager.loadFile("game/gameValues/gvAiProvince.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAiDiplomacy.json").exists()) {
                gvAiDiplomacy = json.fromJson(GV_AI_Diplomacy.class, FileManager.loadFile("game/gameValues/gvAiDiplomacy.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAiInvest.json").exists()) {
                gvAiInvest = json.fromJson(GV_AI_Invest.class, FileManager.loadFile("game/gameValues/gvAiInvest.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAiCivPersonality.json").exists()) {
                gvAiCivPersonality = json.fromJson(GV_AI_CivPersonality.class, FileManager.loadFile("game/gameValues/gvAiCivPersonality.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAiWar.json").exists()) {
                gvAiWar = json.fromJson(GV_AI_War.class, FileManager.loadFile("game/gameValues/gvAiWar.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvAiBudget.json").exists()) {
                gvAiBudget = json.fromJson(GV_AI_Budget.class, FileManager.loadFile("game/gameValues/gvAiBudget.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (FileManager.loadFile("game/gameValues/gvMapScroll.json").exists()) {
                gvMapScroll = json.fromJson(GV_MapScroll.class, FileManager.loadFile("game/gameValues/gvMapScroll.json"));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static void updateCivPersonalityType() {
        try {
            CFG.oAI.aiPlaystyles.get((int)0).PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT = GameValues.gvAiCivPersonalityType.DEFAULT_PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)0).PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM = GameValues.gvAiCivPersonalityType.DEFAULT_PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)0).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT = GameValues.gvAiCivPersonalityType.DEFAULT_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)0).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM = GameValues.gvAiCivPersonalityType.DEFAULT_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)0).PERSONALITY_MIN_HAPPINESS_DEFAULT = GameValues.gvAiCivPersonalityType.DEFAULT_PERSONALITY_MIN_HAPPINESS_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)0).PERSONALITY_MIN_HAPPINESS_RANDOM = GameValues.gvAiCivPersonalityType.DEFAULT_PERSONALITY_MIN_HAPPINESS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)0).PERSONALITY_FORGIVENESS_DEFAULT = GameValues.gvAiCivPersonalityType.DEFAULT_PERSONALITY_FORGIVENESS_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)0).PERSONALITY_FORGIVENESS_RANDOM = GameValues.gvAiCivPersonalityType.DEFAULT_PERSONALITY_FORGIVENESS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)0).USE_OF_BUDGET_FOR_SPENDINGS = GameValues.gvAiCivPersonalityType.DEFAULT_USE_OF_BUDGET_FOR_SPENDINGS;
            CFG.oAI.aiPlaystyles.get((int)0).USE_OF_BUDGET_FOR_SPENDINGS_RANDOM = GameValues.gvAiCivPersonalityType.DEFAULT_USE_OF_BUDGET_FOR_SPENDINGS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)0).PERSONALITY_GOODS_RANDOM = GameValues.gvAiCivPersonalityType.DEFAULT_PERSONALITY_GOODS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)0).PERSONALITY_INVESTMENTS_RANDOM = GameValues.gvAiCivPersonalityType.DEFAULT_PERSONALITY_INVESTMENTS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)0).PERSONALITY_RESEARCH_RANDOM = GameValues.gvAiCivPersonalityType.DEFAULT_PERSONALITY_RESEARCH_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)0).PERSONALITY_PLUNDER_MIN = GameValues.gvAiCivPersonalityType.DEFAULT_PERSONALITY_PLUNDER_MIN;
            CFG.oAI.aiPlaystyles.get((int)0).PERSONALITY_PLUNDER_RANDOM = GameValues.gvAiCivPersonalityType.DEFAULT_PERSONALITY_PLUNDER_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)0).PERSONALITY_PLUNDER_LOCK = GameValues.gvAiCivPersonalityType.DEFAULT_PERSONALITY_PLUNDER_LOCK;
            CFG.oAI.aiPlaystyles.get((int)0).PERSONALITY_MIN_AGGRESSION_DEFAULT = GameValues.gvAiCivPersonalityType.DEFAULT_PERSONALITY_MIN_AGGRESSION_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)0).PERSONALITY_MIN_AGGRESSION_RANDOM_100 = GameValues.gvAiCivPersonalityType.DEFAULT_PERSONALITY_MIN_AGGRESSION_RANDOM_100;
            CFG.oAI.aiPlaystyles.get((int)1).PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT = GameValues.gvAiCivPersonalityType.COMMUNISM_PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)1).PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM = GameValues.gvAiCivPersonalityType.COMMUNISM_PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)1).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT = GameValues.gvAiCivPersonalityType.COMMUNISM_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)1).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM = GameValues.gvAiCivPersonalityType.COMMUNISM_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)1).PERSONALITY_MIN_HAPPINESS_DEFAULT = GameValues.gvAiCivPersonalityType.COMMUNISM_PERSONALITY_MIN_HAPPINESS_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)1).PERSONALITY_MIN_HAPPINESS_RANDOM = GameValues.gvAiCivPersonalityType.COMMUNISM_PERSONALITY_MIN_HAPPINESS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)1).PERSONALITY_FORGIVENESS_DEFAULT = GameValues.gvAiCivPersonalityType.COMMUNISM_PERSONALITY_FORGIVENESS_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)1).PERSONALITY_FORGIVENESS_RANDOM = GameValues.gvAiCivPersonalityType.COMMUNISM_PERSONALITY_FORGIVENESS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)1).USE_OF_BUDGET_FOR_SPENDINGS = GameValues.gvAiCivPersonalityType.COMMUNISM_USE_OF_BUDGET_FOR_SPENDINGS;
            CFG.oAI.aiPlaystyles.get((int)1).USE_OF_BUDGET_FOR_SPENDINGS_RANDOM = GameValues.gvAiCivPersonalityType.COMMUNISM_USE_OF_BUDGET_FOR_SPENDINGS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)1).PERSONALITY_GOODS_RANDOM = GameValues.gvAiCivPersonalityType.COMMUNISM_PERSONALITY_GOODS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)1).PERSONALITY_INVESTMENTS_RANDOM = GameValues.gvAiCivPersonalityType.COMMUNISM_PERSONALITY_INVESTMENTS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)1).PERSONALITY_RESEARCH_RANDOM = GameValues.gvAiCivPersonalityType.COMMUNISM_PERSONALITY_RESEARCH_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)1).PERSONALITY_PLUNDER_MIN = GameValues.gvAiCivPersonalityType.COMMUNISM_PERSONALITY_PLUNDER_MIN;
            CFG.oAI.aiPlaystyles.get((int)1).PERSONALITY_PLUNDER_RANDOM = GameValues.gvAiCivPersonalityType.COMMUNISM_PERSONALITY_PLUNDER_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)1).PERSONALITY_PLUNDER_LOCK = GameValues.gvAiCivPersonalityType.COMMUNISM_PERSONALITY_PLUNDER_LOCK;
            CFG.oAI.aiPlaystyles.get((int)1).PERSONALITY_MIN_AGGRESSION_DEFAULT = GameValues.gvAiCivPersonalityType.COMMUNISM_PERSONALITY_MIN_AGGRESSION_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)1).PERSONALITY_MIN_AGGRESSION_RANDOM_100 = GameValues.gvAiCivPersonalityType.COMMUNISM_PERSONALITY_MIN_AGGRESSION_RANDOM_100;
            CFG.oAI.aiPlaystyles.get((int)2).PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT = GameValues.gvAiCivPersonalityType.HORDE_PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)2).PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM = GameValues.gvAiCivPersonalityType.HORDE_PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)2).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT = GameValues.gvAiCivPersonalityType.HORDE_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)2).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM = GameValues.gvAiCivPersonalityType.HORDE_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)2).PERSONALITY_MIN_HAPPINESS_DEFAULT = GameValues.gvAiCivPersonalityType.HORDE_PERSONALITY_MIN_HAPPINESS_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)2).PERSONALITY_MIN_HAPPINESS_RANDOM = GameValues.gvAiCivPersonalityType.HORDE_PERSONALITY_MIN_HAPPINESS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)2).PERSONALITY_FORGIVENESS_DEFAULT = GameValues.gvAiCivPersonalityType.HORDE_PERSONALITY_FORGIVENESS_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)2).PERSONALITY_FORGIVENESS_RANDOM = GameValues.gvAiCivPersonalityType.HORDE_PERSONALITY_FORGIVENESS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)2).USE_OF_BUDGET_FOR_SPENDINGS = GameValues.gvAiCivPersonalityType.HORDE_USE_OF_BUDGET_FOR_SPENDINGS;
            CFG.oAI.aiPlaystyles.get((int)2).USE_OF_BUDGET_FOR_SPENDINGS_RANDOM = GameValues.gvAiCivPersonalityType.HORDE_USE_OF_BUDGET_FOR_SPENDINGS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)2).PERSONALITY_GOODS_RANDOM = GameValues.gvAiCivPersonalityType.HORDE_PERSONALITY_GOODS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)2).PERSONALITY_INVESTMENTS_RANDOM = GameValues.gvAiCivPersonalityType.HORDE_PERSONALITY_INVESTMENTS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)2).PERSONALITY_RESEARCH_RANDOM = GameValues.gvAiCivPersonalityType.HORDE_PERSONALITY_RESEARCH_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)2).PERSONALITY_PLUNDER_MIN = GameValues.gvAiCivPersonalityType.HORDE_PERSONALITY_PLUNDER_MIN;
            CFG.oAI.aiPlaystyles.get((int)2).PERSONALITY_PLUNDER_RANDOM = GameValues.gvAiCivPersonalityType.HORDE_PERSONALITY_PLUNDER_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)2).PERSONALITY_PLUNDER_LOCK = GameValues.gvAiCivPersonalityType.HORDE_PERSONALITY_PLUNDER_LOCK;
            CFG.oAI.aiPlaystyles.get((int)2).PERSONALITY_MIN_AGGRESSION_DEFAULT = GameValues.gvAiCivPersonalityType.HORDE_PERSONALITY_MIN_AGGRESSION_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)2).PERSONALITY_MIN_AGGRESSION_RANDOM_100 = GameValues.gvAiCivPersonalityType.HORDE_PERSONALITY_MIN_AGGRESSION_RANDOM_100;
            CFG.oAI.aiPlaystyles.get((int)3).PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT = GameValues.gvAiCivPersonalityType.FASCISM_PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)3).PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM = GameValues.gvAiCivPersonalityType.FASCISM_PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)3).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT = GameValues.gvAiCivPersonalityType.FASCISM_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)3).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM = GameValues.gvAiCivPersonalityType.FASCISM_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)3).PERSONALITY_MIN_HAPPINESS_DEFAULT = GameValues.gvAiCivPersonalityType.FASCISM_PERSONALITY_MIN_HAPPINESS_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)3).PERSONALITY_MIN_HAPPINESS_RANDOM = GameValues.gvAiCivPersonalityType.FASCISM_PERSONALITY_MIN_HAPPINESS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)3).PERSONALITY_FORGIVENESS_DEFAULT = GameValues.gvAiCivPersonalityType.FASCISM_PERSONALITY_FORGIVENESS_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)3).PERSONALITY_FORGIVENESS_RANDOM = GameValues.gvAiCivPersonalityType.FASCISM_PERSONALITY_FORGIVENESS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)3).USE_OF_BUDGET_FOR_SPENDINGS = GameValues.gvAiCivPersonalityType.FASCISM_USE_OF_BUDGET_FOR_SPENDINGS;
            CFG.oAI.aiPlaystyles.get((int)3).USE_OF_BUDGET_FOR_SPENDINGS_RANDOM = GameValues.gvAiCivPersonalityType.FASCISM_USE_OF_BUDGET_FOR_SPENDINGS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)3).PERSONALITY_GOODS_RANDOM = GameValues.gvAiCivPersonalityType.FASCISM_PERSONALITY_GOODS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)3).PERSONALITY_INVESTMENTS_RANDOM = GameValues.gvAiCivPersonalityType.FASCISM_PERSONALITY_INVESTMENTS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)3).PERSONALITY_RESEARCH_RANDOM = GameValues.gvAiCivPersonalityType.FASCISM_PERSONALITY_RESEARCH_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)3).PERSONALITY_PLUNDER_MIN = GameValues.gvAiCivPersonalityType.FASCISM_PERSONALITY_PLUNDER_MIN;
            CFG.oAI.aiPlaystyles.get((int)3).PERSONALITY_PLUNDER_RANDOM = GameValues.gvAiCivPersonalityType.FASCISM_PERSONALITY_PLUNDER_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)3).PERSONALITY_PLUNDER_LOCK = GameValues.gvAiCivPersonalityType.FASCISM_PERSONALITY_PLUNDER_LOCK;
            CFG.oAI.aiPlaystyles.get((int)3).PERSONALITY_MIN_AGGRESSION_DEFAULT = GameValues.gvAiCivPersonalityType.FASCISM_PERSONALITY_MIN_AGGRESSION_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)3).PERSONALITY_MIN_AGGRESSION_RANDOM_100 = GameValues.gvAiCivPersonalityType.FASCISM_PERSONALITY_MIN_AGGRESSION_RANDOM_100;
            CFG.oAI.aiPlaystyles.get((int)4).PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT = GameValues.gvAiCivPersonalityType.CITY_PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)4).PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM = GameValues.gvAiCivPersonalityType.CITY_PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)4).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT = GameValues.gvAiCivPersonalityType.CITY_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)4).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM = GameValues.gvAiCivPersonalityType.CITY_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)4).PERSONALITY_MIN_HAPPINESS_DEFAULT = GameValues.gvAiCivPersonalityType.CITY_PERSONALITY_MIN_HAPPINESS_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)4).PERSONALITY_MIN_HAPPINESS_RANDOM = GameValues.gvAiCivPersonalityType.CITY_PERSONALITY_MIN_HAPPINESS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)4).PERSONALITY_FORGIVENESS_DEFAULT = GameValues.gvAiCivPersonalityType.CITY_PERSONALITY_FORGIVENESS_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)4).PERSONALITY_FORGIVENESS_RANDOM = GameValues.gvAiCivPersonalityType.CITY_PERSONALITY_FORGIVENESS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)4).USE_OF_BUDGET_FOR_SPENDINGS = GameValues.gvAiCivPersonalityType.CITY_USE_OF_BUDGET_FOR_SPENDINGS;
            CFG.oAI.aiPlaystyles.get((int)4).USE_OF_BUDGET_FOR_SPENDINGS_RANDOM = GameValues.gvAiCivPersonalityType.CITY_USE_OF_BUDGET_FOR_SPENDINGS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)4).PERSONALITY_GOODS_RANDOM = GameValues.gvAiCivPersonalityType.CITY_PERSONALITY_GOODS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)4).PERSONALITY_INVESTMENTS_RANDOM = GameValues.gvAiCivPersonalityType.CITY_PERSONALITY_INVESTMENTS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)4).PERSONALITY_RESEARCH_RANDOM = GameValues.gvAiCivPersonalityType.CITY_PERSONALITY_RESEARCH_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)4).PERSONALITY_PLUNDER_MIN = GameValues.gvAiCivPersonalityType.CITY_PERSONALITY_PLUNDER_MIN;
            CFG.oAI.aiPlaystyles.get((int)4).PERSONALITY_PLUNDER_RANDOM = GameValues.gvAiCivPersonalityType.CITY_PERSONALITY_PLUNDER_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)4).PERSONALITY_PLUNDER_LOCK = GameValues.gvAiCivPersonalityType.CITY_PERSONALITY_PLUNDER_LOCK;
            CFG.oAI.aiPlaystyles.get((int)4).PERSONALITY_MIN_AGGRESSION_DEFAULT = GameValues.gvAiCivPersonalityType.CITY_PERSONALITY_MIN_AGGRESSION_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)4).PERSONALITY_MIN_AGGRESSION_RANDOM_100 = GameValues.gvAiCivPersonalityType.CITY_PERSONALITY_MIN_AGGRESSION_RANDOM_100;
            CFG.oAI.aiPlaystyles.get((int)5).PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT = GameValues.gvAiCivPersonalityType.TRIBAL_PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)5).PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM = GameValues.gvAiCivPersonalityType.TRIBAL_PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)5).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT = GameValues.gvAiCivPersonalityType.TRIBAL_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)5).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM = GameValues.gvAiCivPersonalityType.TRIBAL_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)5).PERSONALITY_MIN_HAPPINESS_DEFAULT = GameValues.gvAiCivPersonalityType.TRIBAL_PERSONALITY_MIN_HAPPINESS_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)5).PERSONALITY_MIN_HAPPINESS_RANDOM = GameValues.gvAiCivPersonalityType.TRIBAL_PERSONALITY_MIN_HAPPINESS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)5).PERSONALITY_FORGIVENESS_DEFAULT = GameValues.gvAiCivPersonalityType.TRIBAL_PERSONALITY_FORGIVENESS_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)5).PERSONALITY_FORGIVENESS_RANDOM = GameValues.gvAiCivPersonalityType.TRIBAL_PERSONALITY_FORGIVENESS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)5).USE_OF_BUDGET_FOR_SPENDINGS = GameValues.gvAiCivPersonalityType.TRIBAL_USE_OF_BUDGET_FOR_SPENDINGS;
            CFG.oAI.aiPlaystyles.get((int)5).USE_OF_BUDGET_FOR_SPENDINGS_RANDOM = GameValues.gvAiCivPersonalityType.TRIBAL_USE_OF_BUDGET_FOR_SPENDINGS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)5).PERSONALITY_GOODS_RANDOM = GameValues.gvAiCivPersonalityType.TRIBAL_PERSONALITY_GOODS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)5).PERSONALITY_INVESTMENTS_RANDOM = GameValues.gvAiCivPersonalityType.TRIBAL_PERSONALITY_INVESTMENTS_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)5).PERSONALITY_RESEARCH_RANDOM = GameValues.gvAiCivPersonalityType.TRIBAL_PERSONALITY_RESEARCH_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)5).PERSONALITY_PLUNDER_MIN = GameValues.gvAiCivPersonalityType.TRIBAL_PERSONALITY_PLUNDER_MIN;
            CFG.oAI.aiPlaystyles.get((int)5).PERSONALITY_PLUNDER_RANDOM = GameValues.gvAiCivPersonalityType.TRIBAL_PERSONALITY_PLUNDER_RANDOM;
            CFG.oAI.aiPlaystyles.get((int)5).PERSONALITY_PLUNDER_LOCK = GameValues.gvAiCivPersonalityType.TRIBAL_PERSONALITY_PLUNDER_LOCK;
            CFG.oAI.aiPlaystyles.get((int)5).PERSONALITY_MIN_AGGRESSION_DEFAULT = GameValues.gvAiCivPersonalityType.TRIBAL_PERSONALITY_MIN_AGGRESSION_DEFAULT;
            CFG.oAI.aiPlaystyles.get((int)5).PERSONALITY_MIN_AGGRESSION_RANDOM_100 = GameValues.gvAiCivPersonalityType.TRIBAL_PERSONALITY_MIN_AGGRESSION_RANDOM_100;
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }
}

