/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle.AIPlaystyle;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.CivBonus_GameData;
import age.of.civilizations2.jakowski.lukasz.CivBonus_Type;
import age.of.civilizations2.jakowski.lukasz.CivInvest;
import age.of.civilizations2.jakowski.lukasz.CivInvest_Development;
import age.of.civilizations2.jakowski.lukasz.CivTask;
import age.of.civilizations2.jakowski.lukasz.Civilization_ClosedEmbassy;
import age.of.civilizations2.jakowski.lukasz.Civilization_Colonies;
import age.of.civilizations2.jakowski.lukasz.Civilization_Sanctions;
import age.of.civilizations2.jakowski.lukasz.Civilization_SentMessages;
import age.of.civilizations2.jakowski.lukasz.Civilizations.DiplomaticSummitA.DiplomaticSummit;
import age.of.civilizations2.jakowski.lukasz.Civilizations.DiplomaticSummitA.DiplomaticSummitCooldown;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.PeaceTreaty_Data;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.PeaceTreaty_GameData;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.PeaceTreaty_GameData_MessageData;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Province.ForeignInvest;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Province.Propaganda;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Diplomacy.Festivals.Festival;
import age.of.civilizations2.jakowski.lukasz.Diplomacy.Loans;
import age.of.civilizations2.jakowski.lukasz.Diplomacy.WorldReactions;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog_Annexation;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog_Guarantee;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog_HaveMilitartyAccess;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog_IsNotVassal;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog_IsVassal;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog_JoinAlliance;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog_LeavesAlliance;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog_NewColony;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog_SignedDefensivePact;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog_SignedNonAggressionPact;
import age.of.civilizations2.jakowski.lukasz.IdeologiesManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Distance;
import age.of.civilizations2.jakowski.lukasz.Menus.PeaceTreaty.Menu_PeaceTreaty;
import age.of.civilizations2.jakowski.lukasz.Messages.Alliance.Message_Alliance_Accepted;
import age.of.civilizations2.jakowski.lukasz.Messages.Alliance.Message_Alliance_Denied;
import age.of.civilizations2.jakowski.lukasz.Messages.Alliance.Message_AllyJoinedAWar;
import age.of.civilizations2.jakowski.lukasz.Messages.Alliance.Message_LeftAlliance;
import age.of.civilizations2.jakowski.lukasz.Messages.CallToArms.Message_CallToArms;
import age.of.civilizations2.jakowski.lukasz.Messages.CallToArms.Message_CallToArms_Deny;
import age.of.civilizations2.jakowski.lukasz.Messages.CallToArms.Message_CallToArms_Join;
import age.of.civilizations2.jakowski.lukasz.Messages.DefensivePact.Message_DefensivePact;
import age.of.civilizations2.jakowski.lukasz.Messages.DefensivePact.Message_DefensivePact_Accepted;
import age.of.civilizations2.jakowski.lukasz.Messages.DefensivePact.Response.Message_DefensivePact_Denied;
import age.of.civilizations2.jakowski.lukasz.Messages.Gift.Message_Gift;
import age.of.civilizations2.jakowski.lukasz.Messages.Gift.Message_Gift_Accepted;
import age.of.civilizations2.jakowski.lukasz.Messages.Gift.Message_Gift_Refused;
import age.of.civilizations2.jakowski.lukasz.Messages.GoldenAge.Message_GoldenAge;
import age.of.civilizations2.jakowski.lukasz.Messages.GoldenAge.Message_GoldenAgeMilitary;
import age.of.civilizations2.jakowski.lukasz.Messages.GoldenAge.Message_GoldenAgeScience;
import age.of.civilizations2.jakowski.lukasz.Messages.Guarantee.Ask.Message_Independence_Ask;
import age.of.civilizations2.jakowski.lukasz.Messages.Guarantee.Ask.Message_Independence_Ask_Accepted;
import age.of.civilizations2.jakowski.lukasz.Messages.Guarantee.Ask.Message_Independence_Ask_Denied;
import age.of.civilizations2.jakowski.lukasz.Messages.Info.Message_LowHappiness;
import age.of.civilizations2.jakowski.lukasz.Messages.Info.Message_LowStability;
import age.of.civilizations2.jakowski.lukasz.Messages.Info.Message_OpenBudget;
import age.of.civilizations2.jakowski.lukasz.Messages.Info.Message_TechPoints;
import age.of.civilizations2.jakowski.lukasz.Messages.Info.Message_Uncivilized;
import age.of.civilizations2.jakowski.lukasz.Messages.Invest.Message_InvestForeignBuilding_Receiving;
import age.of.civilizations2.jakowski.lukasz.Messages.Invest.Message_InvestForeign_Receiving;
import age.of.civilizations2.jakowski.lukasz.Messages.LoanRQ.Message_LoanRequest;
import age.of.civilizations2.jakowski.lukasz.Messages.LoanRQ.Message_LoanRequest_Accepted;
import age.of.civilizations2.jakowski.lukasz.Messages.LoanRQ.Message_LoanRequest_Refused;
import age.of.civilizations2.jakowski.lukasz.Messages.Message;
import age.of.civilizations2.jakowski.lukasz.Messages.MessageType;
import age.of.civilizations2.jakowski.lukasz.Messages.MilitaryAccess.Message_MilitaryAccess_Ask;
import age.of.civilizations2.jakowski.lukasz.Messages.MilitaryAccess.Message_MilitaryAccess_Ask_Accepted;
import age.of.civilizations2.jakowski.lukasz.Messages.MilitaryAccess.Message_MilitaryAccess_Ask_Denied;
import age.of.civilizations2.jakowski.lukasz.Messages.MilitaryAccess.Message_MilitaryAccess_Give;
import age.of.civilizations2.jakowski.lukasz.Messages.NonAggression.Message_NonAggressionPact;
import age.of.civilizations2.jakowski.lukasz.Messages.NonAggression.Message_NonAggressionPact_Accepted;
import age.of.civilizations2.jakowski.lukasz.Messages.NonAggression.Message_NonAggressionPact_Denied;
import age.of.civilizations2.jakowski.lukasz.Messages.PrepForWar.Message_PrepareForWar;
import age.of.civilizations2.jakowski.lukasz.Messages.PrepForWar.Message_PrepareForWar_Accepted;
import age.of.civilizations2.jakowski.lukasz.Messages.PrepForWar.Message_PrepareForWar_Refused;
import age.of.civilizations2.jakowski.lukasz.Messages.Province.Message_RebelsSupported;
import age.of.civilizations2.jakowski.lukasz.Messages.Province.Message_VolunteerArmy;
import age.of.civilizations2.jakowski.lukasz.Messages.Province.Nuke.Message_NukeSent;
import age.of.civilizations2.jakowski.lukasz.Messages.Relations.Message_Relations_Increase;
import age.of.civilizations2.jakowski.lukasz.Messages.Relations.Message_Relations_Insult;
import age.of.civilizations2.jakowski.lukasz.Messages.Relations.Sanctions.Message_Sanctioned;
import age.of.civilizations2.jakowski.lukasz.Messages.Relations.Summit.Message_SummitInvited;
import age.of.civilizations2.jakowski.lukasz.Messages.Trade.Message_TradeRequest;
import age.of.civilizations2.jakowski.lukasz.Messages.Trade.Message_TradeReuest_Accepted;
import age.of.civilizations2.jakowski.lukasz.Messages.Trade.Message_TradeReuest_Denied;
import age.of.civilizations2.jakowski.lukasz.Messages.Truce.Message_NTR;
import age.of.civilizations2.jakowski.lukasz.Messages.Truce.Message_PeaceTreaty;
import age.of.civilizations2.jakowski.lukasz.Messages.Truce.Message_PeaceTreaty_Rejected;
import age.of.civilizations2.jakowski.lukasz.Messages.Ultimatum.Message_Ultimatum;
import age.of.civilizations2.jakowski.lukasz.Messages.Ultimatum.Message_UltimatumAccepted;
import age.of.civilizations2.jakowski.lukasz.Messages.Ultimatum.Message_UltimatumRefused;
import age.of.civilizations2.jakowski.lukasz.Messages.Union.Message_Union;
import age.of.civilizations2.jakowski.lukasz.Messages.Union.Message_Union_Accepted;
import age.of.civilizations2.jakowski.lukasz.Messages.Union.Message_Union_Refused;
import age.of.civilizations2.jakowski.lukasz.Messages.Vassal.Declaration.Message_DeclarationOfIndependence_ByVassal;
import age.of.civilizations2.jakowski.lukasz.Messages.Vassal.Message_Liberation;
import age.of.civilizations2.jakowski.lukasz.Messages.Vassal.Message_OfferVasalization;
import age.of.civilizations2.jakowski.lukasz.Messages.Vassal.Vassalization.Message_Vassalization_Accepted;
import age.of.civilizations2.jakowski.lukasz.Messages.Vassal.Vassalization.Message_Vassalization_Rejected;
import age.of.civilizations2.jakowski.lukasz.Messages.War.Message_NW;
import age.of.civilizations2.jakowski.lukasz.Messages.War.Message_War;
import age.of.civilizations2.jakowski.lukasz.PlayerAIPeace_GameData;
import age.of.civilizations2.jakowski.lukasz.Province_SupportRebels;
import age.of.civilizations2.jakowski.lukasz.Province_SupportRebels_Help;
import age.of.civilizations2.jakowski.lukasz.Province_VolunteerArmySent;
import age.of.civilizations2.jakowski.lukasz.SupportRebels_List;
import age.of.civilizations2.jakowski.lukasz.TradeRequest_GameData;
import age.of.civilizations2.jakowski.lukasz.Ultimatum_GameData;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import age.of.civilizations2.jakowski.lukasz.MoveUnitsB.GenocideOperation;
import java.util.ArrayList;
import java.util.List;

public class GameManager {
    public static int DECLINE_CALL_TO_ARMS_REASON = -1;
    public static int WAR_PREPARATIONS_REFUSE_OPINION_CHANGE = -10;
    public static boolean supportRevolutionCivilWarStarted = false;

    public static final float getLikelihoodScore(int iScore) {
        return (float)(Math.min(Math.max(iScore, -100), 100) + 100) / 200.0f;
    }

    public static final float invest_DevelopmentByGold(int nProvinceID, long nMoney) {
        float adminEff = Math.max(0.1f, CFG.gameUpdate.getAdministrationEfficiency(CFG.core.getProv(nProvinceID).getCivId()));
        float adminFactor = Math.max(0.1f, Math.min(10.0f, 0.36f / (adminEff * adminEff)));
        return ((float)nMoney / 12.0f) / ((float)CFG.core.getGameScenars().getScenario_StartingPopulation() * GameValues.gvInvestDevelopment.INVEST_COST_GOLD_STARTING_POPULATION_MODIFIER * (1.0f + Core.getOverInvestmentsPenalty(CFG.core.getProv(nProvinceID).getCivId())) * adminFactor) * (GameValues.gvInvestDevelopment.INVEST_COST_GOLD_AGE_ECONOMY_GROWTH_RATE_BASE + GameValues.gvInvestDevelopment.INVEST_COST_GOLD_AGE_ECONOMY_GROWTH_RATE_MODIFIER * (CFG.gameAges.getAge_Economy_GrowthRate(GameCalendar.CURRENT_AGEID) * 100.0f));
    }

    public static final long investMaxDevGold(int nProvinceID, int nCivID) {
        float requiredDevPoints = CFG.core.getCiv(nCivID).getTechLevel() * 0.9999f - CFG.core.getProv(nProvinceID).getDeveLvl();
        if (requiredDevPoints <= 0.0f) return 0L;
        float K = GameManager.invest_DevelopmentByGold(nProvinceID, 1200) / 1200.0f;
        if (K <= 0.0f) return 0L;
        long investAmount = (long)(requiredDevPoints / K);
        return Math.max(0L, Math.min(investAmount, CFG.core.getCiv(nCivID).getGold()));
    }

    public static final boolean investDevelopment(int nProvinceID, int nCivID, long nMoney) {
        if ((CFG.core.getProv(nProvinceID).getCivId() == nCivID || CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getPuppetOfCiv() == nCivID) && CFG.core.getCiv(nCivID).getMovemPoints() >= GameValues.gvInvestDevelopment.INVEST_DEVELOPMENT_MOVEMENT_POINTS && CFG.core.getCiv(nCivID).getTechLevel() > CFG.core.getProv(nProvinceID).getDeveLvl()) {
            float devPoints;
            if (CFG.core.getCiv(nCivID).getGold() < nMoney) {
                nMoney = CFG.core.getCiv(nCivID).getGold();
            }
            if (nMoney > 0L && (devPoints = GameManager.invest_DevelopmentByGold(nProvinceID, nMoney)) > 0.0f) {
                float ecoPointsPerTurn = Math.max(devPoints / (float)GameValues.gvInvestDevelopment.INVEST_DEVELOPMENT_NUM_OF_TURNS, GameValues.gvInvestDevelopment.INVEST_DEVELOPMENT_MIN_INCREASE_PER_TURN);
                if (CFG.core.getCiv(nCivID).addInvest_Development(new CivInvest_Development(nProvinceID, GameValues.gvInvestDevelopment.INVEST_DEVELOPMENT_NUM_OF_TURNS, devPoints, ecoPointsPerTurn))) {
                    CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - GameValues.gvInvestDevelopment.INVEST_DEVELOPMENT_MOVEMENT_POINTS);
                    CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - nMoney);
                    CFG.core.getCiv((int)nCivID).civGD.numberOfInvestments += GameValues.gvOverInvestment.INVEST_DEV_VALUE_ADDED;
                    if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                        Core.addDiplomacyLines(CFG.core.getCapitalOrProvince(nCivID), nProvinceID, CFG.COLOR_DEVELOPMENT);
                    }
                    CFG.core.getCiv((int)nCivID).civGD.iGD += nMoney;
                    return true;
                }
            }
        }
        return false;
    }

    public static int investForeignEconomy_Return(int civID, int provinceID, long nMoney) {
        return (int)nMoney + (int)Math.floor((float)nMoney * GameManager.investForeignEconomy_ReturnRate(civID, provinceID));
    }

    public static float investForeignEconomy_ReturnRate(int civID, int provinceID) {
        float distance = 0.0f;
        if (CFG.core.getCiv(civID).getCapitalProvID() >= 0) {
            distance = 1.0f - Distance.getDistanceFromAToB_PercOfMax(CFG.core.getCiv(civID).getCapitalProvID(), provinceID);
        }
        return GameValues.gvInvestForeign.INVEST_ECO_EXTRA_RETURN + GameValues.gvInvestForeign.INVEST_ECO_EXTRA_RETURN_DISTANCE * distance;
    }

    public static boolean investForeignEconomy(int civID, int provinceID, long nMoney) {
        try {
            if (nMoney > 0L && provinceID >= 0 && CFG.core.getProv(provinceID).getCivId() > 0 && !CFG.core.getProv(provinceID).getSeaProv() && CFG.core.getProv(provinceID).getWastelandLvl() < 0) {
                if (CFG.core.getCiv(civID).areSanctionsAdded(civID, CFG.core.getProv(provinceID).getCivId()) || CFG.core.getCiv(CFG.core.getProv(provinceID).getCivId()).areSanctionsAdded(CFG.core.getProv(provinceID).getCivId(), civID)) {
                    return false;
                }
                CFG.core.getCiv(civID).setMovementPoints(CFG.core.getCiv(civID).getMovemPoints() - GameValues.gvInvestForeign.INVEST_ECO_COST_MOVEMENT_POINTS);
                CFG.core.getCiv(civID).setGold(CFG.core.getCiv(civID).getGold() - nMoney);
                int ecoPoints = GameManager.invest_EconomyByGold(provinceID, nMoney);
                if (ecoPoints > 0) {
                    int ecoPointsPerTurn = Math.max(ecoPoints / GameValues.gvInvestEconomy.INVEST_ECO_NUM_OF_TURNS, GameValues.gvInvestEconomy.INVEST_ECONOMY_MIN_INCREASE_PER_TURN);
                    CFG.core.getCiv(CFG.core.getProv(provinceID).getCivId()).addInvest_2(new CivInvest(provinceID, GameValues.gvInvestEconomy.INVEST_ECO_NUM_OF_TURNS, ecoPoints, ecoPointsPerTurn));
                    CFG.core.getCiv((int)civID).civGD.numberOfInvestments += GameValues.gvOverInvestment.INVEST_ECONOMY_FOREIGN_MAKING_VALUE_ADDED;
                    CFG.core.getCiv((int)CFG.core.getCiv((int)provinceID).getCivId()).civGD.numberOfInvestments += GameValues.gvOverInvestment.INVEST_ECONOMY_FOREIGN_RECEIVING_VALUE_ADDED;
                    ForeignInvest foreignInvest = new ForeignInvest();
                    foreignInvest.civID = civID;
                    foreignInvest.inCivID = CFG.core.getProv(provinceID).getCivId();
                    foreignInvest.provinceID = provinceID;
                    foreignInvest.gold = GameManager.investForeignEconomy_Return(civID, provinceID, nMoney);
                    foreignInvest.profit = (long)GameManager.investForeignEconomy_Return(civID, provinceID, nMoney) - nMoney;
                    foreignInvest.returnTurnID = GameCalendar.TURNID + GameValues.gvInvestForeign.INVEST_ECO_RETURN_TURNS;
                    CFG.core.investForeignGold.add(foreignInvest);
                    if (CFG.core.getCiv(CFG.core.getProv(provinceID).getCivId()).getIsPlayer()) {
                        CFG.core.getCiv((int)CFG.core.getProv((int)provinceID).getCivId()).getCivDiploGD().messageBox.addMessage(new Message_InvestForeign_Receiving(civID, provinceID, (long)foreignInvest.gold, (long)foreignInvest.profit));
                    }
                    CFG.core.getCiv((int)civID).civGD.iGE += nMoney;
                    CFG.core.getCiv((int)CFG.core.getCiv((int)provinceID).getCivId()).civGD.iGEG += (long)ecoPoints;
                }
                if (civID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getCiv(CFG.core.getProv(provinceID).getCivId()).getIsPlayer()) {
                    Core.addDiplomacyLines(CFG.core.getCapitalOrProvince(civID), provinceID, CFG.COLOR_ECONOMY);
                }
                return true;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return false;
    }

    public static final int invest_EconomyByGold(int nProvinceID, long nMoney) {
        float adminEff = Math.max(0.1f, CFG.gameUpdate.getAdministrationEfficiency(CFG.core.getProv(nProvinceID).getCivId()));
        float adminFactor = Math.max(0.1f, Math.min(10.0f, 0.36f / (adminEff * adminEff)));
        return (int)(((float)nMoney / 12.0f) / (GameValues.gvInvestEconomy.INVEST_ECO_GAIN_PER_GOLD_DIVIDE * (1.0f + Core.getOverInvestmentsPenalty(CFG.core.getProv(nProvinceID).getCivId())) * adminFactor) * (GameValues.gvInvestEconomy.INVEST_ECO_GAIN_PER_GOLD_DEVELOPMENT_BASE + GameValues.gvInvestEconomy.INVEST_ECO_GAIN_PER_GOLD_DEVELOPMENT_MODIFIER * Math.min(1.0f, CFG.core.getProv(nProvinceID).getDeveLvl() * GameValues.gvInvestEconomy.INVEST_ECO_GAIN_PER_GOLD_DEVELOPMENT_MULTIPLY)) * (GameValues.gvInvestEconomy.INVEST_ECO_GAIN_PER_GOLD_ECO_GROWTH_RATE_BASE + GameValues.gvInvestEconomy.INVEST_ECO_GAIN_PER_GOLD_ECO_GROWTH_RATE_MODIFIER * CFG.gameAges.getAge_Economy_GrowthRate(GameCalendar.CURRENT_AGEID) * 10.0f));
    }

    public static final long invest_MaxEconomy_Gold(int nProvinceID, int nCivID) {
        return Math.max((long)Math.min(Math.min((float)CFG.core.getProv(nProvinceID).getEco() * GameValues.gvInvestEconomy.INVEST_ECO_MAX_GOLD_ECONOMY_MODIFIER, (float)CFG.core.getProv(nProvinceID).getPop().getPops() * GameValues.gvInvestEconomy.INVEST_ECO_MAX_GOLD_POPULATION_MODIFIER) * (GameValues.gvInvestEconomy.INVEST_ECO_MAX_GOLD_DEVELOPMENT_BASE + GameValues.gvInvestEconomy.INVEST_ECO_MAX_GOLD_DEVELOPMENT_MODIFIER * Math.min(CFG.core.getProv(nProvinceID).getDeveLvl(), GameValues.gvInvestEconomy.INVEST_ECO_MAX_GOLD_DEVELOPMENT_LIMIT)) * GameValues.gvInvestEconomy.INVEST_ECO_MAX_GOLD_FINAL_MODIFIER * 12.0f, (float)CFG.core.getCiv(nCivID).getGold()), 0L);
    }

    public static final boolean invest(int nProvinceID, int nCivID, long nMoney) {
        if (CFG.settingsGD.DISABLE_AI_INVESTING && !CFG.core.getCiv(nCivID).getIsPlayer()) {
            return false;
        }
        if ((CFG.core.getProv(nProvinceID).getCivId() == nCivID || CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getPuppetOfCiv() == nCivID) && nMoney > 0L && CFG.core.getCiv(nCivID).getMovemPoints() >= GameValues.gvInvestEconomy.INVEST_ECO_COST_MOVEMENT_POINTS) {
            int ecoPoints;
            if (CFG.core.getCiv(nCivID).getGold() < nMoney) {
                nMoney = CFG.core.getCiv(nCivID).getGold();
            }
            if (nMoney > 0L && (ecoPoints = GameManager.invest_EconomyByGold(nProvinceID, nMoney)) > 0) {
                float ecoPointsPerTurn = Math.max((float)ecoPoints / (float)GameValues.gvInvestEconomy.INVEST_ECO_NUM_OF_TURNS, (float)GameValues.gvInvestEconomy.INVEST_ECONOMY_MIN_INCREASE_PER_TURN);
                if (CFG.core.getCiv(nCivID).addInvest(new CivInvest(nProvinceID, GameValues.gvInvestEconomy.INVEST_ECO_NUM_OF_TURNS, (float)ecoPoints, ecoPointsPerTurn))) {
                    CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - GameValues.gvInvestEconomy.INVEST_ECO_COST_MOVEMENT_POINTS);
                    CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - nMoney);
                    CFG.core.getCiv((int)nCivID).civGD.numberOfInvestments += GameValues.gvOverInvestment.INVEST_ECONOMY_VALUE_ADDED;
                    if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                        Core.addDiplomacyLines(CFG.core.getCapitalOrProvince(nCivID), nProvinceID, CFG.COLOR_ECONOMY);
                    }
                    CFG.core.getCiv((int)nCivID).civGD.iGE += nMoney;
                    CFG.core.getCiv((int)nCivID).civGD.iGEG += (long)ecoPoints;
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean canMoveToNeighbooringProvince(int nProvinceID, int nCivID) {
        if (nProvinceID < 0) {
            return false;
        }
        return !GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES || CFG.core.getProv(nProvinceID).getSeaProv() || CFG.core.getProv(nProvinceID).getCivId() > 0 || CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).CAN_BECOME_CIVILIZED >= 0;
    }

    public static final int getColonizeCost(int nProvinceID, int nCivID) {
        return (int)((float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (CFG.gameAges.getAge((int)GameCalendar.CURRENT_AGEID).COLONIZE_COST_GOLD_PERC + GameValues.gvColonize.COLONIZE_COST_GOLD_GROWTH_RATE_MODIFIER * CFG.core.getProv(nProvinceID).getGrowthRate_Pop() + GameValues.gvColonize.COLONIZE_COST_GOLD_DISTANCE_MODIFIER * (CFG.core.getCiv(nCivID).getCapitalProvID() >= 0 ? 3.475f * Distance.getDistanceFromCapital_PercOfMax(CFG.core.getCiv(nCivID).getCapitalProvID(), nProvinceID) : 1.0f)) * GameManager.getColonizeCost_OwnNeighboringProvincesModifier(nProvinceID, nCivID) * GameManager.getColonizeCost_ContinentAndRegion_Modifier(nProvinceID, nCivID) * (1.0f - CFG.core.getCiv((int)nCivID).civGD.modifier_ColonizationCost) * (CFG.core.getCiv(nCivID).getTechLevel() < GameCalendar.COLONIZATION_TECH_LEVEL ? GameValues.gvColonize.COLONIZE_COST_PENALTY_LOW_TECH_BASE + (GameCalendar.COLONIZATION_TECH_LEVEL - CFG.core.getCiv(nCivID).getTechLevel()) * GameValues.gvColonize.COLONIZE_COST_PENALTY_LOW_TECH_DIFFERENCE_MODIFIER : 1.0f));
    }

    public static final int getColonizeCost_AI(int nCivID) {
        return (int)((float)CFG.core.getGameScenars().getScenario_StartingPopulation() * (CFG.gameAges.getAge((int)GameCalendar.CURRENT_AGEID).COLONIZE_COST_GOLD_PERC + GameValues.gvColonize.COLONIZE_COST_GOLD_GROWTH_RATE_MODIFIER * 0.35f + GameValues.gvColonize.COLONIZE_COST_GOLD_DISTANCE_MODIFIER * 0.7f) * (1.0f - CFG.core.getCiv((int)nCivID).civGD.modifier_ColonizationCost) * (CFG.core.getCiv(nCivID).getTechLevel() < GameCalendar.COLONIZATION_TECH_LEVEL ? GameValues.gvColonize.COLONIZE_COST_PENALTY_LOW_TECH_BASE + (GameCalendar.COLONIZATION_TECH_LEVEL - CFG.core.getCiv(nCivID).getTechLevel()) * GameValues.gvColonize.COLONIZE_COST_PENALTY_LOW_TECH_DIFFERENCE_MODIFIER : 1.0f));
    }

    public static final float getColonizeCost_ContinentAndRegion_Modifier(int nProvinceID, int nCivID) {
        if (CFG.core.getCiv(nCivID).getCapitalProvID() >= 0) {
            if (CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getContinent() == CFG.core.getProv(nProvinceID).getContinent()) {
                if (CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getRegion() == CFG.core.getProv(nProvinceID).getRegion()) {
                    return GameValues.gvColonize.COLONIZE_COST_GOLD_SAME_REGION_AND_CONTINENT_MODIFIER;
                }
                return GameValues.gvColonize.COLONIZE_COST_GOLD_SAME_CONTINENT_MODIFIER;
            }
            if (CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getRegion() == CFG.core.getProv(nProvinceID).getRegion()) {
                return GameValues.gvColonize.COLONIZE_COST_GOLD_SAME_REGION_MODIFIER;
            }
        }
        return GameValues.gvColonize.COLONIZE_COST_GOLD_NONE_MODIFIER;
    }

    public static final float getColonizeCost_OwnNeighboringProvincesModifier(int nProvinceID, int nCivID) {
        int ownsNeighboringProvinces = 0;
        for (int i = 0; i < CFG.core.getProv(nProvinceID).getNeighProvincesSize(); ++i) {
            if (CFG.core.getProv(CFG.core.getProv(nProvinceID).getNeighProvinces(i)).getCivId() != nCivID) continue;
            ++ownsNeighboringProvinces;
        }
        return 1.0f + GameValues.gvColonize.COLONIZE_COST_REDUCTION_SAME_CIV_NEIGHBORING_PROVINCES_PERC * (float)ownsNeighboringProvinces / (float)Math.max(CFG.core.getProv(nProvinceID).getNeighProvincesSize(), 1);
    }

    public static final int getColonizeCost_Movement(int nProvinceID, int nCivID) {
        return (int)Math.min((float)GameValues.gvColonize.COLONIZE_COST_MOVEMENT_POINTS_MAX, (float)CFG.gameAges.getAge((int)GameCalendar.CURRENT_AGEID).COLONIZE_COST_MOVEMENT_POINTS + (float)CFG.gameAges.getAge((int)GameCalendar.CURRENT_AGEID).COLONIZE_COST_MOVEMENT_POINTS * (CFG.core.getCiv(nCivID).getCapitalProvID() >= 0 ? GameValues.gvColonize.COLONIZE_COST_MOVEMENT_POINTS_DISTANCE_MODIFIER * Distance.getDistanceFromCapital_PercOfMax(CFG.core.getCiv(nCivID).getCapitalProvID(), nProvinceID) : 2.0f));
    }

    public static final boolean colonizeProvince(int nProvinceID, int nCivID, boolean free) {
        boolean wasWasteland;
        if (CFG.core.getProv(nProvinceID).getWastelandLvl() < 0 && CFG.core.getProv(nProvinceID).getCivId() != 0) {
            return false;
        }
        if (!free) {
            if (CFG.core.getCiv(nCivID).getMovemPoints() < GameManager.getColonizeCost_Movement(nProvinceID, nCivID)) {
                return false;
            }
            if (CFG.core.getCiv(nCivID).getDiploPoints() < CFG.gameAges.getAge((int)GameCalendar.CURRENT_AGEID).COLONIZE_COST_DIPLOMACY_POINTS) {
                return false;
            }
            if (CFG.core.getCiv(nCivID).getGold() < (long)GameManager.getColonizeCost(nProvinceID, nCivID)) {
                return false;
            }
            if (!CFG.gameAction.canColonizieWasteland_BorderOrArmy(nProvinceID, nCivID)) {
                return false;
            }
        }
        boolean bl = wasWasteland = CFG.core.getProv(nProvinceID).getWastelandLvl() >= 0;
        if (!free) {
            CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - GameManager.getColonizeCost_Movement(nProvinceID, nCivID));
            CFG.core.getCiv(nCivID).setDiploPoints(CFG.core.getCiv(nCivID).getDiploPoints() - CFG.gameAges.getAge((int)GameCalendar.CURRENT_AGEID).COLONIZE_COST_DIPLOMACY_POINTS);
            CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)GameManager.getColonizeCost(nProvinceID, nCivID));
        }
        CFG.core.getProv(nProvinceID).setWastelandLvl(-1);
        CFG.core.getProv(nProvinceID).resetArmiesAll(0);
        CFG.core.getProv(nProvinceID).setCivId(nCivID, false, true);
        if (!free) {
            int ranArmy = GameValues.gvColonize.COLONIZE_ARMY_MIN;
            if (GameValues.gvColonize.COLONIZE_ARMY_RANDOM > 0) {
                ranArmy += CFG.oR.nextInt(GameValues.gvColonize.COLONIZE_ARMY_RANDOM);
            }
            CFG.core.getProv(nProvinceID).updateArmy4(nCivID, ranArmy);
            CFG.core.getCiv(nCivID).setNumberOfUnits(CFG.core.getCiv(nCivID).getNumberOfUnits() + ranArmy);
        }
        CFG.core.getProv(nProvinceID).getCores().addNewCore(nCivID, GameCalendar.TURNID);
        CFG.core.getProv(nProvinceID).setHappi(Math.max(CFG.core.getProv(nProvinceID).getHappi(), (float)(GameValues.gvColonize.HAPPINESS_MIN + CFG.oR.nextInt(GameValues.gvColonize.HAPPINESS_RANDOM)) / 100.0f));
        CFG.core.getProv(nProvinceID).setDevLvl(Math.max(CFG.core.getProv(nProvinceID).getDeveLvl(), CFG.core.getCiv(nCivID).getTechLevel() * (GameValues.gvColonize.DEVELOPMENT_MIN + (float)CFG.oR.nextInt(GameValues.gvColonize.DEVELOPMENT_RANDOM_1000) / 1000.0f)));
        CFG.core.getProv((int)nProvinceID).provGD.iNewColonyBonus = GameValues.gvColonize.NEW_COLONY_BONUS;
        if (wasWasteland) {
            CFG.core.getProv(nProvinceID).getPop().setPopulationOfCivID(nCivID, GameValues.gvColonize.BASE_POPULATION + Math.max((int)((float)GameValues.gvProvince.MIN_POPULATION_IN_PROVINCE * GameValues.gvProvince.MIN_POPULATION_IN_PROVINCE_WASTELAND_MODIFIER) + CFG.oR.nextInt(GameValues.gvProvince.MIN_POPULATION_IN_PROVINCE * 5), CFG.core.getProv(nProvinceID).getPop().getPopulationOfCivID(nCivID)));
            CFG.core.getProv(nProvinceID).setEco(Math.max(CFG.core.getProv(nProvinceID).getEco(), GameValues.gvColonize.BASE_ECONOMY_MIN + (int)((float)GameValues.gvProvince.MIN_ECONOMY_IN_PROVINCE * GameValues.gvProvince.MIN_ECONOMY_IN_PROVINCE_WASTELAND_MODIFIER) + CFG.oR.nextInt(GameValues.gvProvince.MIN_ECONOMY_IN_PROVINCE * 4)));
            CFG.core.buildWastelandLevels();
        }
        for (int i = 0; i < CFG.core.getProv(nProvinceID).getPop().getNatsSize(); ++i) {
            if (CFG.core.getProv(nProvinceID).getPop().getCivID(i) != 0) continue;
            float randPop = GameValues.gvColonize.NEUTRAL_POPULATION_ASSIMILATION_BASE + (float)CFG.oR.nextInt(GameValues.gvColonize.NEUTRAL_POPULATION_ASSIMILATION_RANDOM_100) / 100.0f;
            CFG.core.getProv(nProvinceID).getPop().setPopulationOfCivID(nCivID, CFG.core.getProv(nProvinceID).getPop().getPopulationOfCivID(nCivID) + (int)((float)CFG.core.getProv(nProvinceID).getPop().getPopulationID(i) * randPop));
            CFG.core.getProv(nProvinceID).getPop().setPopulationOfCivID(CFG.core.getProv(nProvinceID).getPop().getCivID(i), CFG.core.getProv(nProvinceID).getPop().getPopulationID(i) - (int)((float)CFG.core.getProv(nProvinceID).getPop().getPopulationID(i) * randPop));
            break;
        }
        CFG.core.getCiv((int)nCivID).civGD.coloniesFounded.add(new Civilization_Colonies(nProvinceID));
        CFG.oAI.buildProvinceData(nProvinceID);
        if (CFG.core.getActiveProvID() == nProvinceID) {
            CFG.core.setActiveProvID(-1);
            CFG.core.setActiveProvID(nProvinceID);
        }
        try {
            CFG.historyManager.addHistoryLog(new HistoryLog_NewColony(nCivID, nProvinceID));
        }
        catch (Exception exception) {
            // empty catch block
        }
        return true;
    }

    public static int hostSummitCostGold(int civID, List<Integer> civs) {
        int out = GameValues.gvSummit.SUMMIT_GOLD_COST_BASE;
        int capitalID = CFG.core.getCiv(civID).getCapitalProvID() >= 0 ? CFG.core.getCiv(civID).getCapitalProvID() : 0;
        for (int i = 1; i < civs.size(); ++i) {
            out += (int)((float)GameValues.gvSummit.SUMMIT_GOLD_COST_PER_CIVILIZATION + (float)GameValues.gvSummit.SUMMIT_GOLD_COST_PER_CIVILIZATION * (GameValues.gvSummit.SUMMIT_GOLD_COST_PER_CIVILIZATION_DISTANCE_MODIFIER * Distance.getDistanceFromCapital_PercOfMax(capitalID, CFG.core.getCiv(civs.get(i)).getCapitalProvID())));
        }
        return out;
    }

    public static int hostSummitCostGold(int civID, int toCivID) {
        int capitalID = CFG.core.getCiv(civID).getCapitalProvID() >= 0 ? CFG.core.getCiv(civID).getCapitalProvID() : 0;
        return (int)((float)GameValues.gvSummit.SUMMIT_GOLD_COST_PER_CIVILIZATION + (float)GameValues.gvSummit.SUMMIT_GOLD_COST_PER_CIVILIZATION * (GameValues.gvSummit.SUMMIT_GOLD_COST_PER_CIVILIZATION_DISTANCE_MODIFIER * Distance.getDistanceFromCapital_PercOfMax(capitalID, CFG.core.getCiv(toCivID).getCapitalProvID())));
    }

    public static int hostSummitCostDiplomacyPoints(int civID, List<Integer> civs) {
        int out = GameValues.gvSummit.SUMMIT_DIPLOMACY_POINTS_COST_BASE;
        for (int i = 1; i < civs.size(); ++i) {
            out += GameValues.gvSummit.SUMMIT_DIPLOMACY_POINTS_COST_PER_CIVILIZATION;
        }
        return out;
    }

    public static boolean hostSummit(int civID, List<Integer> civs) {
        for (int i = CFG.core.diplomaticSummitCooldowns.size() - 1; i >= 0; --i) {
            if (CFG.core.diplomaticSummitCooldowns.get((int)i).civID != civID) continue;
            return false;
        }
        int costGold = GameManager.hostSummitCostGold(civID, civs);
        int costDiplo = GameManager.hostSummitCostDiplomacyPoints(civID, civs);
        if (CFG.core.getCiv(civID).getGold() < (long)costGold) {
            return false;
        }
        if (CFG.core.getCiv(civID).getDiploPoints() < costDiplo) {
            return false;
        }
        CFG.core.getCiv(civID).setGold(CFG.core.getCiv(civID).getGold() - (long)costGold);
        CFG.core.getCiv(civID).setDiploPoints(CFG.core.getCiv(civID).getDiploPoints() - costDiplo);
        DiplomaticSummit diplomaticSummit = new DiplomaticSummit();
        diplomaticSummit.civHostID = civID;
        diplomaticSummit.endTurnID = GameCalendar.TURNID + GameValues.gvSummit.SUMMIT_TURNS;
        int civsSize = civs.size();
        for (int i = 0; i < civsSize; ++i) {
            diplomaticSummit.invitedCivs.add(civs.get(i));
        }
        CFG.core.diplomaticSummits.add(diplomaticSummit);
        DiplomaticSummitCooldown diplomaticSummitCooldown = new DiplomaticSummitCooldown();
        diplomaticSummitCooldown.civID = civID;
        diplomaticSummitCooldown.turnID = GameCalendar.TURNID + GameValues.gvSummit.SUMMIT_COOLDOWN_TURNS;
        CFG.core.diplomaticSummitCooldowns.add(diplomaticSummitCooldown);
        int civsSize2 = civs.size();
        for (int i = 1; i < civsSize2; ++i) {
            Core.addDiplomacyLines(CFG.core.getCapitalOrProvince(civs.get(i)), CFG.core.getCapitalOrProvince(civID), CFG.COLOR_POSITIVE);
            if (!CFG.core.getCiv(civs.get(i)).getIsPlayer()) continue;
            CFG.core.getCiv((int)civs.get((int)i).intValue()).getCivDiploGD().messageBox.addMessage(new Message_SummitInvited(civID, GameValues.gvSummit.SUMMIT_TURNS));
        }
        return true;
    }

    public static void summitImproveRelations(List<Integer> civs) {
        int civsSize = civs.size();
        for (int i = 0; i < civsSize; ++i) {
            for (int j = i + 1; j < civsSize; ++j) {
                if (CFG.core.getCivsAtWar(civs.get(i), civs.get(j))) continue;
                float relation = GameValues.gvSummit.IMPROVE_RELATIONS_BASE + (float)CFG.oR.nextInt(GameValues.gvSummit.IMPROVE_RELATIONS_RANDOM_100) / 100.0f;
                CFG.core.getCiv(civs.get(i)).setRelationD(civs.get(j), CFG.core.getCiv(civs.get(i)).getRelationD(civs.get(j)) + relation);
                CFG.core.getCiv(civs.get(j)).setRelationD(civs.get(i), CFG.core.getCiv(civs.get(j)).getRelationD(civs.get(i)) + relation);
            }
        }
    }

    public static int buildForeignEconomy_Return(int civID, int provinceID, long nMoney) {
        return (int)nMoney + (int)Math.floor((float)nMoney * GameManager.buildForeignEconomy_ReturnRate(civID, provinceID));
    }

    public static float buildForeignEconomy_ReturnRate(int civID, int provinceID) {
        float distance = 0.0f;
        if (CFG.core.getCiv(civID).getCapitalProvID() >= 0) {
            distance = 1.0f - Distance.getDistanceFromAToB_PercOfMax(CFG.core.getCiv(civID).getCapitalProvID(), provinceID);
        }
        return GameValues.gvInvestForeign.BUILD_EXTRA_RETURN + GameValues.gvInvestForeign.BUILD_EXTRA_RETURN_DISTANCE * distance;
    }

    public static boolean buildForeignProvince(int civID, int provinceID, List<Boolean> build, int buildCost) {
        try {
            if (provinceID >= 0 && CFG.core.getProv(provinceID).getCivId() > 0) {
                if (CFG.core.getCiv(civID).areSanctionsAdded(civID, CFG.core.getProv(provinceID).getCivId()) || CFG.core.getCiv(CFG.core.getProv(provinceID).getCivId()).areSanctionsAdded(CFG.core.getProv(provinceID).getCivId(), civID)) {
                    return false;
                }
                block13: for (int a = 0; a < build.size(); ++a) {
                    if (!build.get(a).booleanValue()) continue;
                    switch (a) {
                        case 0: {
                            if (BuildingsManager.constructFort_Foreign(provinceID, civID)) continue block13;
                            buildCost -= BuildingsManager.getFort_BuildCost(CFG.core.getProv(provinceID).getLvlOfFort() + 1, provinceID);
                            continue block13;
                        }
                        case 1: {
                            if (BuildingsManager.constructTower_Foreign(provinceID, civID)) continue block13;
                            buildCost -= BuildingsManager.getTower_BuildCost(CFG.core.getProv(provinceID).getLvlOfWatchTower() + 1, provinceID);
                            continue block13;
                        }
                        case 2: {
                            if (BuildingsManager.constructPort_Foreign(provinceID, civID)) continue block13;
                            buildCost -= BuildingsManager.getPort_BuildCost(CFG.core.getProv(provinceID).getLvlOfPort() + 1, provinceID);
                            continue block13;
                        }
                        case 3: {
                            if (BuildingsManager.constructFarm_Foreign(provinceID, civID)) continue block13;
                            buildCost -= BuildingsManager.getFarm_BuildCost(CFG.core.getProv(provinceID).getLvlOfFarm() + 1, provinceID);
                            continue block13;
                        }
                        case 4: {
                            if (BuildingsManager.constructWorkshop_Foreign(provinceID, civID)) continue block13;
                            buildCost -= BuildingsManager.getWorkshop_BuildCost(CFG.core.getProv(provinceID).getLvlOfWorkshop() + 1, provinceID);
                            continue block13;
                        }
                        case 5: {
                            if (BuildingsManager.constructMarket_Foreign(provinceID, civID)) continue block13;
                            buildCost -= BuildingsManager.getMarket_BuildCost(CFG.core.getProv(provinceID).getLvlOfMarket() + 1, provinceID);
                            continue block13;
                        }
                        case 6: {
                            if (BuildingsManager.constructLibrary_Foreign(provinceID, civID)) continue block13;
                            buildCost -= BuildingsManager.getLibrary_BuildCost(CFG.core.getProv(provinceID).getLvlOfLibrary() + 1, provinceID);
                            continue block13;
                        }
                        case 7: {
                            if (BuildingsManager.constructArmoury_Foreign(provinceID, civID)) continue block13;
                            buildCost -= BuildingsManager.getArmoury_BuildCost(CFG.core.getProv(provinceID).getLvlOfArmoury() + 1, provinceID);
                            continue block13;
                        }
                        case 8: {
                            if (BuildingsManager.constructSupply_Foreign(provinceID, civID)) continue block13;
                            buildCost -= BuildingsManager.getSupply_BuildCost(CFG.core.getProv(provinceID).getLvlOfSupply() + 1, provinceID);
                        }
                    }
                }
                if (buildCost > 0) {
                    ForeignInvest foreignInvest = new ForeignInvest();
                    foreignInvest.civID = civID;
                    foreignInvest.inCivID = CFG.core.getProv(provinceID).getCivId();
                    foreignInvest.provinceID = provinceID;
                    foreignInvest.gold = GameManager.buildForeignEconomy_Return(civID, provinceID, buildCost);
                    foreignInvest.profit = GameManager.buildForeignEconomy_Return(civID, provinceID, buildCost) - buildCost;
                    foreignInvest.returnTurnID = GameCalendar.TURNID + GameValues.gvInvestForeign.BUILD_RETURN_TURNS;
                    CFG.core.buildForeignGold.add(foreignInvest);
                    if (CFG.core.getCiv(CFG.core.getProv(provinceID).getCivId()).getIsPlayer()) {
                        CFG.core.getCiv((int)CFG.core.getProv((int)provinceID).getCivId()).getCivDiploGD().messageBox.addMessage(new Message_InvestForeignBuilding_Receiving(civID, provinceID, foreignInvest.gold, foreignInvest.profit));
                    }
                }
                if (civID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId() || CFG.core.getCiv(CFG.core.getProv(provinceID).getCivId()).getIsPlayer()) {
                    Core.addDiplomacyLines(CFG.core.getCapitalOrProvince(civID), provinceID, CFG.COLOR_ECONOMY);
                }
                return true;
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return false;
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    public static final long assimilateCost(int nProvinceID, int numOfTurns) {
        return (long)((float)(GameValues.gvAssimilate.BASE_COST_OF_ASSIMILATE + (long)((CFG.gameUpdate.getProvIncomeTaxation(nProvinceID) * GameValues.gvAssimilate.COST_OF_ASSIMILATE_INCOME_TAXATION + CFG.gameUpdate.getProvIncomeProduction(nProvinceID) * GameValues.gvAssimilate.COST_OF_ASSIMILATE_INCOME_PRODUCTION) * (GameValues.gvAssimilate.COST_OF_ASSIMILATE_BASE_MODIFIER_DEVELOPMENT + GameValues.gvAssimilate.COST_OF_ASSIMILATE_MODIFIER_DEVELOPMENT * CFG.core.getProv(nProvinceID).getDeveLvl() + GameValues.gvAssimilate.COST_OF_ASSIMILATE_MODIFIER_CIV_ASSIMILATION_IN_PROGRESS * (float)CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getAssimilatesSize()) * (1.0f + GameValues.gvAssimilate.COST_OF_ASSIMILATE_MODIFIER_DISTANCE * Distance.getDistanceFromAToB_PercOfMax(CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getCapitalProvID(), nProvinceID)) * (GameValues.gvAssimilate.COST_OF_ASSIMILATE_BASE_MODIFIER_POPULATION_PERC - (float)CFG.core.getProv(nProvinceID).getPop().getPopulationOfCivID(CFG.core.getProv(nProvinceID).getCivId()) / (float)CFG.core.getProv(nProvinceID).getPop().getPops()))) / (float)GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MIN * (float)numOfTurns * (1.0f + GameValues.gvTechnology.PER_POINT_ASSIMILATE * (float)CFG.core.getCiv((int)CFG.core.getProv((int)nProvinceID).getCivId()).civGD.techPoints.POINTS_ASSIMILATE) * CFG.ASSIMILATION_COST_MODIFIER);
    }

    public static final boolean addAssi(int nCivID, int nProvinceID, int numOfTurns) {
        if (numOfTurns == 0) {
            return false;
        }
        if ((nCivID == CFG.core.getProv(nProvinceID).getCivId() || nCivID == CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getPuppetOfCiv()) && !CFG.core.getProv(nProvinceID).isOccupied() && CFG.core.getCiv(nCivID).getGold() >= GameManager.assimilateCost(nProvinceID, numOfTurns) && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).addAssimilate(new CivTask(nProvinceID, numOfTurns))) {
            long assimilateCost = Math.abs(GameManager.assimilateCost(nProvinceID, numOfTurns));
            CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - assimilateCost);
            CFG.core.getCiv((int)nCivID).civGD.aACSG += assimilateCost;
            ++CFG.core.getCiv((int)nCivID).civGD.aACS;
            if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                Core.addDiplomacyLines(CFG.core.getCapitalOrProvince(nCivID), nProvinceID, CFG.COLOR_PROVINCE_STABILITY_MAX);
            }
            return true;
        }
        return false;
    }

    public static final boolean addAssimilateFree(int nCivID, int nProvinceID, int numOfTurns) {
        if (numOfTurns == 0) {
            return false;
        }
        if ((nCivID == CFG.core.getProv(nProvinceID).getCivId() || nCivID == CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getPuppetOfCiv()) && !CFG.core.getProv(nProvinceID).isOccupied() && CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).addAssimilate(new CivTask(nProvinceID, numOfTurns))) {
            ++CFG.core.getCiv((int)nCivID).civGD.aACS;
            if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                Core.addDiplomacyLines(CFG.core.getCapitalOrProvince(nCivID), nProvinceID, CFG.COLOR_PROVINCE_STABILITY_MAX);
            }
            return true;
        }
        return false;
    }

    public static final boolean hasGenocidablePopulation(int nCivID, int nProvinceID) {
        if (nProvinceID < 0 || nProvinceID >= CFG.core.getProvinSize() || nCivID <= 0 || nCivID >= CFG.core.getCivsSize()) {
            return false;
        }
        if (CFG.gameAction.getControlledArmySizeInProvince(nProvinceID, nCivID) <= 0L) {
            return false;
        }
        for (int i = 0; i < CFG.core.getProv(nProvinceID).getPop().getNatsSize(); ++i) {
            if (CFG.core.getProv(nProvinceID).getPop().getPopulationID(i) > 0) {
                return true;
            }
        }
        return false;
    }

    public static final boolean canGenocidePopulation(int nCivID, int nProvinceID, int targetCivID, long nArmy) {
        return GameManager.hasGenocidablePopulation(nCivID, nProvinceID) && targetCivID >= 0 && targetCivID < CFG.core.getCivsSize() && nArmy > 0L && CFG.gameAction.getControlledArmySizeInProvince(nProvinceID, nCivID) >= nArmy && CFG.core.getProv(nProvinceID).getPop().getPopulationOfCivID(targetCivID) > 0L;
    }

    public static final long genocidePopulation(int nCivID, int nProvinceID, int targetCivID, long nArmy) {
        if (!GameManager.canGenocidePopulation(nCivID, nProvinceID, targetCivID, nArmy)) {
            return 0L;
        }
        Province province = CFG.core.getProv(nProvinceID);
        long targetPop = province.getPop().getPopulationOfCivID(targetCivID);
        if (targetPop <= 0L) {
            return 0L;
        }
        int armyCivID = CFG.gameAction.getControlledArmyCivIDInProvince(nProvinceID, nCivID);
        long armyLoss = Math.max(1L, nArmy / 200L);
        province.updateArmy4(armyCivID, Math.max(0L, province.getArmyCivID1(armyCivID) - armyLoss));
        CFG.core.getCiv(nCivID).newGenocideOperation(nProvinceID, targetCivID, nArmy, targetPop);
        CFG.toastM.addM("Genocide started: 4 turns remaining", CFG.COLOR_NEGATIVE_2);
        return targetPop;
    }

    public static final void processGenocideOperations(int nCivID) {
        Civilization civ = CFG.core.getCiv(nCivID);
        for (int i = 0; i < civ.getGenocideOperationsSize(); ++i) {
            GenocideOperation op = civ.getGenocideOperation(i);
            if (op.getCivID() != nCivID) continue;
            Province province = CFG.core.getProv(op.getProvinceID());
            if (province == null) {
                civ.removeGenocideOperation(i--);
                continue;
            }
            long remainingTargetPop = province.getPop().getPopulationOfCivID(op.getTargetCivID());
            if (remainingTargetPop <= 0L) {
                civ.removeGenocideOperation(i--);
                continue;
            }
            long tempPopulationBefore = province.getPop().getPops();
            long removedPop = Math.min(remainingTargetPop, Math.max(1L, op.getTotalPopToRemove() / 4L));
            province.getPop().setPopulationOfCivID(op.getTargetCivID(), remainingTargetPop - removedPop);
            float removedShare = Math.min(1.0f, (float)removedPop / (float)Math.max(1L, province.getPop().getPops()));
            province.setHappi(province.getHappi() - 0.02f - removedShare * 0.05f);
            province.setRevRisk(province.getRevRisk() + 0.01f + removedShare * 0.05f);
            int tempWarID = CFG.core.getWarID(nCivID, province.getTrueOwnerOfProv());
            if (tempWarID >= 0) {
                CFG.core.updateWarStatistics(tempWarID, nCivID, province.getTrueOwnerOfProv(), Math.max(tempPopulationBefore - province.getPop().getPops(), 0L), 0L);
            }
            op.setTurnsRemaining(op.getTurnsRemaining() - 1);
            if (op.getTurnsRemaining() <= 0) {
                civ.removeGenocideOperation(i--);
                continue;
            }
        }
    }

    public static final boolean isGenocideActive(int nCivID, int nProvinceID) {
        return CFG.core.getCiv(nCivID).isGenociding(nProvinceID);
    }

    public static final int getGenocideTurnsLeft(int nCivID, int nProvinceID) {
        if (nCivID <= 0 || nCivID >= CFG.core.getCivsSize()) return 0;
        for (int i = 0; i < CFG.core.getCiv(nCivID).getGenocideOperationsSize(); ++i) {
            GenocideOperation op = CFG.core.getCiv(nCivID).getGenocideOperation(i);
            if (op.getProvinceID() == nProvinceID) {
                return op.getTurnsRemaining();
            }
        }
        return 0;
    }

    public static final long genocideMinorities(int nCivID, int nProvinceID) {
        int targetCivID = -1;
        long bestPop = 0L;
        for (int i = 0; i < CFG.core.getProv(nProvinceID).getPop().getNatsSize(); ++i) {
            int natCivID = CFG.core.getProv(nProvinceID).getPop().getCivID(i);
            long pop = CFG.core.getProv(nProvinceID).getPop().getPopulationID(i);
            if (pop <= bestPop) continue;
            bestPop = pop;
            targetCivID = natCivID;
        }
        return targetCivID >= 0 ? GameManager.genocidePopulation(nCivID, nProvinceID, targetCivID, CFG.gameAction.getControlledArmySizeInProvince(nProvinceID, nCivID)) : 0L;
    }

    public static final void genocideAllMinorities(int nCivID, int nProvinceID) {
        long totalArmy = CFG.gameAction.getControlledArmySizeInProvince(nProvinceID, nCivID);
        if (totalArmy <= 0L) return;
        long armyPerTarget = Math.max(1L, totalArmy / (long)Math.max(1, CFG.core.getProv(nProvinceID).getPop().getNatsSize()));
        for (int i = 0; i < CFG.core.getProv(nProvinceID).getPop().getNatsSize(); ++i) {
            int natCivID = CFG.core.getProv(nProvinceID).getPop().getCivID(i);
            long pop = CFG.core.getProv(nProvinceID).getPop().getPopulationID(i);
            if (pop <= 0L) continue;
            GameManager.genocidePopulation(nCivID, nProvinceID, natCivID, armyPerTarget);
        }
    }

    public static final SupportRebels_List supportRebels(int iOnCivID) {
        SupportRebels_List outCivs = new SupportRebels_List();
        for (int i = 0; i < CFG.core.getCiv(iOnCivID).getNumOfProvs(); ++i) {
            for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getCores().getCivsSize(); ++j) {
                if (CFG.core.getCiv(CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getCores().getCivID(j)).getNumOfProvs() > 0) continue;
                boolean tAdd = true;
                for (int k = 0; k < outCivs.lMovementsCivID.size(); ++k) {
                    if (outCivs.lMovementsCivID.get(k).intValue() != CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getCores().getCivID(j)) continue;
                    tAdd = false;
                    outCivs.lPopulation.set(k, outCivs.lPopulation.get(k) + CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getPop().getPopulationOfCivID(CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getCores().getCivID(j)));
                    outCivs.lUnrest.set(k, outCivs.lUnrest.get(k) + (int)(CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getRevRisk() * 100.0f));
                    outCivs.lProvinces.set(k, outCivs.lProvinces.get(k) + 1);
                    break;
                }
                if (!tAdd) continue;
                outCivs.lMovementsCivID.add(CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getCores().getCivID(j));
                outCivs.lPopulation.add(CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getPop().getPopulationOfCivID(CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getCores().getCivID(j)));
                outCivs.lUnrest.add((int)(CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getRevRisk() * 100.0f));
                outCivs.lProvinces.add(1);
            }
            for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getPop().getNatsSize(); ++j) {
                int ideologyMovementID = CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getPop().getCivID(j);
                if (CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getCores().getHaveACore(ideologyMovementID) && CFG.core.getCiv(ideologyMovementID).getNumOfProvs() <= 0) continue;
                if (!GameManager.canSupportIdeologyMovement(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), iOnCivID, ideologyMovementID, CFG.core.getCiv(iOnCivID).getProvID(i))) continue;
                boolean tAdd = true;
                for (int k = 0; k < outCivs.lMovementsCivID.size(); ++k) {
                    if (outCivs.lMovementsCivID.get(k).intValue() != ideologyMovementID) continue;
                    tAdd = false;
                    outCivs.lPopulation.set(k, outCivs.lPopulation.get(k) + CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getPop().getPopulationOfCivID(ideologyMovementID));
                    outCivs.lUnrest.set(k, outCivs.lUnrest.get(k) + (int)(CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getRevRisk() * 100.0f));
                    outCivs.lProvinces.set(k, outCivs.lProvinces.get(k) + 1);
                    break;
                }
                if (!tAdd) continue;
                outCivs.lMovementsCivID.add(ideologyMovementID);
                outCivs.lPopulation.add(CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getPop().getPopulationOfCivID(ideologyMovementID));
                outCivs.lUnrest.add((int)(CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getRevRisk() * 100.0f));
                outCivs.lProvinces.add(1);
            }
        }
        return outCivs;
    }

    public static final boolean canSupportIdeologyMovement(int byCivID, int iOnCivID, int supportCivID, int provinceID) {
        return byCivID > 0 && iOnCivID > 0 && supportCivID > 0 && supportCivID < CFG.core.getCivsSize() && supportCivID != iOnCivID && supportCivID != byCivID && CFG.core.getProv(provinceID).getPop().getPopulationOfCivID(supportCivID) > 0;
    }

    public static final List<Integer> supportRebels_Provinces(int iOnCivID, int iRebelsID) {
        ArrayList<Integer> outProvinces = new ArrayList<Integer>();
        block0: for (int i = 0; i < CFG.core.getCiv(iOnCivID).getNumOfProvs(); ++i) {
            for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getCores().getCivsSize(); ++j) {
                if (CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getCores().getCivID(j) != iRebelsID) continue;
                outProvinces.add(CFG.core.getCiv(iOnCivID).getProvID(i));
                continue block0;
            }
            if (!GameManager.canSupportIdeologyMovement(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), iOnCivID, iRebelsID, CFG.core.getCiv(iOnCivID).getProvID(i))) continue;
            outProvinces.add(CFG.core.getCiv(iOnCivID).getProvID(i));
        }
        return outProvinces;
    }

    public static final float getSUPPORT_REBELS_ASSIMILATE_PERC(int iNumOfSupporters) {
        if (iNumOfSupporters <= 1) {
            return GameValues.gvRebelsSupport.SUPPORT_REBELS_ASSIMILATE_PERC;
        }
        return GameValues.gvRebelsSupport.SUPPORT_REBELS_ASSIMILATE_PERC + GameValues.gvRebelsSupport.SUPPORT_REBELS_ASSIMILATE_MORE_SUPPORTERS_MODIFIER * Math.min(1.0f, (float)(iNumOfSupporters / 4));
    }

    public static final long supportRebels_MaxGold(List<Integer> nProvinces) {
        long out = 1L;
        int iSize = nProvinces.size();
        for (int i = 0; i < iSize; ++i) {
            out += (long)((float)GameManager.assimilateCost(nProvinces.get(i), GameValues.gvRebelsSupport.SUPPORT_REBELS_NUM_OF_TURNS_MAX) * GameValues.gvRebelsSupport.SUPPORT_REBELS_ASSIMILATE_COST_MODIFIER);
        }
        return (long)((float)out * GameValues.gvRebelsSupport.SUPPORT_REBELS_MAX_COST_MODIFIER);
    }

    public static final List<Integer> supportRevolution_Ideologies(int iOnCivID) {
        ArrayList<Integer> out = new ArrayList<Integer>();
        if (iOnCivID <= 0 || iOnCivID >= CFG.core.getCivsSize()) {
            return out;
        }
        for (int i = 0; i < CFG.ideologiesMgr.getIdeologiesSize(); ++i) {
            if (i == CFG.core.getCiv(iOnCivID).getIdeology() || CFG.ideologiesMgr.getIdeologyID(i).REVOLUTIONARY || CFG.ideologiesMgr.getIdeologyID(i).CAN_BECOME_CIVILIZED >= 0 || CFG.ideologiesMgr.getIdeologyID(i).AVAILABLE_SINCE_AGE_ID > GameCalendar.CURRENT_AGEID) continue;
            out.add(i);
        }
        return out;
    }

    public static final long supportRevolution_MaxGold(int iOnCivID) {
        return Math.max(1L, (long)IdeologiesManager.getChangeGovernmentCost(iOnCivID) * 2L);
    }

    public static final float supportRevolution_Pressure(int iOnCivID, long nMoney) {
        return Math.max(0.0f, (float)nMoney / (float)Math.max(1L, GameManager.supportRevolution_MaxGold(iOnCivID)));
    }

    public static final int supportRevolution_Chance(int iOnCivID, long nMoney) {
        if (iOnCivID <= 0 || iOnCivID >= CFG.core.getCivsSize() || CFG.core.getCiv(iOnCivID).getNumOfProvs() <= 0) {
            return 0;
        }
        float avgRevRisk = 0.0f;
        for (int i = 0; i < CFG.core.getCiv(iOnCivID).getNumOfProvs(); ++i) {
            avgRevRisk += CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getRevRisk();
        }
        avgRevRisk /= (float)CFG.core.getCiv(iOnCivID).getNumOfProvs();
        return Math.max(1, Math.min(90, (int)(5.0f + GameManager.supportRevolution_Pressure(iOnCivID, nMoney) * 11.25f + avgRevRisk * 45.0f)));
    }

    public static final boolean canSupportRevolution(int byCivID, int iOnCivID, int ideologyID, long nMoney) {
        return byCivID > 0 && iOnCivID > 0 && byCivID != iOnCivID && iOnCivID < CFG.core.getCivsSize() && ideologyID >= 0 && ideologyID < CFG.ideologiesMgr.getIdeologiesSize() && CFG.core.getCiv(iOnCivID).getIdeology() != ideologyID && !CFG.ideologiesMgr.getIdeologyID(ideologyID).REVOLUTIONARY && CFG.ideologiesMgr.getIdeologyID(ideologyID).CAN_BECOME_CIVILIZED < 0 && CFG.ideologiesMgr.getIdeologyID(ideologyID).AVAILABLE_SINCE_AGE_ID <= GameCalendar.CURRENT_AGEID && nMoney > 0L && CFG.core.getCiv(byCivID).getGold() > 0L && CFG.core.getCiv(byCivID).getDiploPoints() >= GameValues.gvRebelsSupport.COST_SUPPORT_REBELS_DIPLOMACY_POINTS;
    }

    public static final boolean supportRevolution(int byCivID, int iOnCivID, int ideologyID, long nMoney) {
        GameManager.supportRevolutionCivilWarStarted = false;
        if (!GameManager.canSupportRevolution(byCivID, iOnCivID, ideologyID, nMoney)) {
            return false;
        }
        nMoney = Math.min(nMoney, CFG.core.getCiv(byCivID).getGold());
        float pressure = GameManager.supportRevolution_Pressure(iOnCivID, nMoney);
        CFG.core.getCiv(byCivID).setDiploPoints(CFG.core.getCiv(byCivID).getDiploPoints() - GameValues.gvRebelsSupport.COST_SUPPORT_REBELS_DIPLOMACY_POINTS);
        CFG.core.getCiv(byCivID).setGold(CFG.core.getCiv(byCivID).getGold() - nMoney);
        float avgRevRisk = 0.0f;
        for (int i = 0; i < CFG.core.getCiv(iOnCivID).getNumOfProvs(); ++i) {
            int provID = CFG.core.getCiv(iOnCivID).getProvID(i);
            CFG.core.getProv(provID).setRevRisk(Math.min(GameValues.gvRevolutionaryRisk.REV_RISK_MAX, CFG.core.getProv(provID).getRevRisk() + 0.08f + pressure * Math.max(0.15f, 1.0f - CFG.core.getProv(provID).getHappi()) * 0.55f));
            CFG.core.getProv(provID).setHappi(CFG.core.getProv(provID).getHappi() - (0.02f + pressure * 0.1f));
            avgRevRisk += CFG.core.getProv(provID).getRevRisk();
        }
        if (CFG.core.getCiv(iOnCivID).getNumOfProvs() > 0) {
            avgRevRisk /= (float)CFG.core.getCiv(iOnCivID).getNumOfProvs();
        }
        CFG.core.getCiv(byCivID).setHappiness(Math.max(0, CFG.core.getCiv(byCivID).getHappiness() - (int)(1.0f + pressure * 5.0f)));
        if (CFG.oR.nextInt(100) < GameManager.supportRevolution_Chance(iOnCivID, nMoney)) {
            GameManager.supportRevolutionCivilWarStarted = GameManager.startIdeologyCivilWar(iOnCivID, ideologyID, pressure, avgRevRisk);
        }
        return true;
    }

    public static final boolean startIdeologyCivilWar(int iOnCivID, int ideologyID, float pressure, float avgRevRisk) {
        if (iOnCivID <= 0 || iOnCivID >= CFG.core.getCivsSize() || CFG.core.getCiv(iOnCivID).getNumOfProvs() <= 0 || ideologyID < 0 || ideologyID >= CFG.ideologiesMgr.getIdeologiesSize()) {
            return false;
        }
        ArrayList<Integer> revoltProvinces = new ArrayList<Integer>();
        ArrayList<Integer> overMin = new ArrayList<Integer>();
        int maxProvs = Math.max(1, Math.min(CFG.core.getCiv(iOnCivID).getNumOfProvs(), (int)((float)CFG.core.getCiv(iOnCivID).getNumOfProvs() * Math.min(0.85f, pressure * 0.5f + avgRevRisk * 0.5f))));
        for (int a = 0; a < maxProvs; ++a) {
            int bestID = -1;
            for (int i = 0; i < CFG.core.getCiv(iOnCivID).getNumOfProvs(); ++i) {
                int provID = CFG.core.getCiv(iOnCivID).getProvID(i);
                if (CFG.core.getProv(provID).getSeaProv()) continue;
                boolean alreadyAdded = false;
                for (int j = 0; j < revoltProvinces.size(); ++j) {
                    if (revoltProvinces.get(j) != provID) continue;
                    alreadyAdded = true;
                    break;
                }
                if (alreadyAdded || bestID >= 0 && CFG.core.getProv(bestID).getRevRisk() >= CFG.core.getProv(provID).getRevRisk()) continue;
                bestID = provID;
            }
            if (bestID < 0) break;
            revoltProvinces.add(bestID);
            if (CFG.core.getProv(bestID).getRevRisk() >= 0.5f) {
                overMin.add(bestID);
            }
        }
        for (int i = 0; i < CFG.core.getCiv(iOnCivID).getNumOfProvs(); ++i) {
            int provID = CFG.core.getCiv(iOnCivID).getProvID(i);
            if (CFG.core.getProv(provID).getSeaProv()) continue;
            boolean alreadyAdded = false;
            for (int j = 0; j < revoltProvinces.size(); ++j) {
                if (revoltProvinces.get(j) != provID) continue;
                alreadyAdded = true;
                break;
            }
            if (alreadyAdded) continue;
            boolean hasDeadCore = false;
            for (int j = 0; j < CFG.core.getProv(provID).getCores().getCivsSize(); ++j) {
                int coreCivID = CFG.core.getProv(provID).getCores().getCivID(j);
                if (coreCivID != iOnCivID && coreCivID != CFG.core.getProv(provID).getTrueOwnerOfProv() && CFG.core.getCiv(coreCivID).getNumOfProvs() <= 0) {
                    hasDeadCore = true;
                    break;
                }
            }
            boolean hasMinority = false;
            for (int j = 0; j < CFG.core.getProv(provID).getPop().getNatsSize(); ++j) {
                int natCivID = CFG.core.getProv(provID).getPop().getCivID(j);
                if (natCivID != iOnCivID && natCivID > 0 && CFG.core.getProv(provID).getPop().getPopulationID(j) > 0L) {
                    hasMinority = true;
                    break;
                }
            }
            if (!hasDeadCore && !hasMinority) continue;
            revoltProvinces.add(provID);
            overMin.add(provID);
        }
        if (revoltProvinces.isEmpty()) {
            return false;
        }
        int capitalProvince = revoltProvinces.get(0);
        CFG.gameAction.spawnRevolutionInProvinceID(iOnCivID, -1, capitalProvince, new ArrayList<Integer>(revoltProvinces), overMin);
        int rebelCivID = CFG.core.getProv(capitalProvince).getCivId();
        if (rebelCivID > 0 && rebelCivID != iOnCivID) {
            CFG.core.getCiv(rebelCivID).setIdeology(ideologyID);
            CFG.core.getCiv(rebelCivID).setCivTag(CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(iOnCivID).getCivTag()) + CFG.ideologiesMgr.getIdeologyID(ideologyID).getExtraTag());
            CFG.core.getCiv(rebelCivID).setCivName(CFG.ideologiesMgr.getIdeologyID(ideologyID).getName() + " Revolution");
        }
        return true;
    }

    public static final boolean supportRebels(int byCivID, int iOnCivID, int supportCivID, long nMoney) {
        if (CFG.core.getCiv(byCivID).getGold() < nMoney) {
            nMoney = CFG.core.getCiv(byCivID).getGold();
        }
        if (nMoney <= 0) {
            return false;
        }
        if (CFG.core.getCiv(byCivID).getDiploPoints() < GameValues.gvRebelsSupport.COST_SUPPORT_REBELS_DIPLOMACY_POINTS) {
            return false;
        }
        CFG.core.getCiv(byCivID).setDiploPoints(CFG.core.getCiv(byCivID).getDiploPoints() - GameValues.gvRebelsSupport.COST_SUPPORT_REBELS_DIPLOMACY_POINTS);
        CFG.core.getCiv(byCivID).setGold(CFG.core.getCiv(byCivID).getGold() - (long)nMoney);
        ArrayList<Integer> supportedProvinces = new ArrayList<Integer>();
        ArrayList<Long> supportedPopulation = new ArrayList<Long>();
        ArrayList<Integer> supportCostPerTurn = new ArrayList<Integer>();
        long supportedPopulationTotal = 0L;
        for (int i = 0; i < CFG.core.getCiv(iOnCivID).getNumOfProvs(); ++i) {
            if (!CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getCores().getHaveACore(supportCivID) && !GameManager.canSupportIdeologyMovement(byCivID, iOnCivID, supportCivID, CFG.core.getCiv(iOnCivID).getProvID(i))) continue;
            supportedProvinces.add(CFG.core.getCiv(iOnCivID).getProvID(i));
            supportedPopulation.add(CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getPop().getPopulationOfCivID(supportCivID) + 1L);
            supportCostPerTurn.add((int)((float)GameManager.assimilateCost(CFG.core.getCiv(iOnCivID).getProvID(i), 1) * GameValues.gvRebelsSupport.SUPPORT_REBELS_ASSIMILATE_COST_MODIFIER));
            supportedPopulationTotal += CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getPop().getPopulationOfCivID(supportCivID) + 1L;
        }
        try {
            if (CFG.core.getCiv(iOnCivID).getIsPlayer()) {
                CFG.core.getCiv((int)iOnCivID).getCivDiploGD().messageBox.addMessage(new Message_RebelsSupported(supportCivID, (Integer)supportedProvinces.get(0)));
            }
        }
        catch (Exception i) {
            // empty catch block
        }
        while (!supportedProvinces.isEmpty() && nMoney > 0) {
            int numOfTunrs;
            long nRandPop = supportedPopulationTotal <= 0L ? 0L : Math.abs(CFG.oR.nextLong()) % supportedPopulationTotal;
            long currPop = 0L;
            int bestSuppProvID = 0;
            for (int i = 0; i < supportedProvinces.size(); ++i) {
                if (nRandPop < currPop || nRandPop > currPop + supportedPopulation.get(i)) continue;
                bestSuppProvID = i;
                break;
            }
            if (!(Math.floor((float)nMoney / (float)((Integer)supportCostPerTurn.get(bestSuppProvID)).intValue()) > 0.0) || (numOfTunrs = (int)Math.floor((float)nMoney / (float)((Integer)supportCostPerTurn.get(bestSuppProvID)).intValue())) <= 1) break;
            if ((numOfTunrs = 1 + CFG.oR.nextInt(numOfTunrs)) > GameValues.gvRebelsSupport.SUPPORT_REBELS_NUM_OF_TURNS_MAX) {
                numOfTunrs = GameValues.gvRebelsSupport.SUPPORT_REBELS_NUM_OF_TURNS_MAX;
            }
            Province_SupportRebels_Help outHelp = CFG.core.getProv((Integer)supportedProvinces.get(bestSuppProvID)).addSupportRebels(new Province_SupportRebels(byCivID, supportCivID, numOfTunrs));
            nMoney -= (long)((float)((Integer)supportCostPerTurn.get(bestSuppProvID)).intValue() * (float)outHelp.iTurns);
            if (!outHelp.max) continue;
            supportedPopulationTotal -= supportedPopulation.get(bestSuppProvID);
            supportedProvinces.remove(bestSuppProvID);
            supportedPopulation.remove(bestSuppProvID);
            supportCostPerTurn.remove(bestSuppProvID);
        }
        supportedProvinces.clear();
        supportedPopulation.clear();
        supportedPopulationTotal = 0;
        for (int i = 0; i < CFG.core.getCiv(iOnCivID).getNumOfProvs(); ++i) {
            if (CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getPop().getPopulationOfCivID(supportCivID) <= 0) continue;
            supportedProvinces.add(CFG.core.getCiv(iOnCivID).getProvID(i));
            supportedPopulation.add(CFG.core.getProv(CFG.core.getCiv(iOnCivID).getProvID(i)).getPop().getPopulationOfCivID(supportCivID));
            supportedPopulationTotal += supportedPopulation.get(supportedPopulation.size() - 1);
        }
        float efficiency = (float)nMoney / ((float)supportedPopulationTotal * GameValues.gvRebelsSupport.SUPPORT_REBELS_MONEY_TO_POPULATION_RATIO_MODIFIER * (float)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT);
        for (int i = 0; i < supportedProvinces.size(); ++i) {
            float tempPercOfPopulation = (float)supportedPopulation.get(i).longValue() / (float)CFG.core.getProv(supportedProvinces.get(i)).getPop().getPops();
            CFG.core.getProv((Integer)supportedProvinces.get(i)).setRevRisk(CFG.gameAges.getAge_RevolutionaryRiskModifier(GameCalendar.CURRENT_AGEID) * CFG.core.getProv((Integer)supportedProvinces.get(i)).getRevRisk() + GameValues.gvRebelsSupport.SUPPORT_REBELS_REV_RISK_CHANGE_BASE_VALUE * efficiency * tempPercOfPopulation * (1.01f - CFG.core.getProv((Integer)supportedProvinces.get(i)).getHappi()));
        }
        return true;
    }

    public static final boolean civilizeCiv(int nCivID) {
        if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).CAN_BECOME_CIVILIZED >= 0 && CFG.core.getCiv(nCivID).getDiploPoints() >= GameValues.gvCivilize.COST_CIVILIZE_DIPLOMACY_POINTS && CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).CIVILIZE_TECH_LEVEL <= CFG.core.getCiv(nCivID).getTechLevel()) {
            CFG.core.getCiv(nCivID).setIdeology(CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).CAN_BECOME_CIVILIZED);
            CFG.core.getCiv(nCivID).setCivTag(CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(nCivID).getCivTag()) + CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).getExtraTag());
            CFG.unionFlagsToGenerate_Manager.addFlagToLoad(nCivID);
            CFG.core.getCiv(nCivID).setDiploPoints(CFG.core.getCiv(nCivID).getDiploPoints() - GameValues.gvCivilize.COST_CIVILIZE_DIPLOMACY_POINTS);
            if (CFG.core.getCiv(nCivID).getCapitalProvID() >= 0 && CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getCivId() == nCivID) {
                CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).setEco(CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getEco() + GameValues.gvTribal.CIVILIZE_ECONOMY_BONUS_CAPITAL);
                CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getPop().setPopulationOfCivID(nCivID, CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getPop().getPopulationOfCivID(nCivID) + GameValues.gvTribal.CIVILIZE_POPULATION_BONUS_CAPITAL);
            }
            if (CFG.core.getPlayerIDbyCivID(nCivID) >= 0) {
                Core.addSimpleTask(new Core.SimpleTask("CivilizeLoadFlag" + nCivID){

                    @Override
                    public void update() {
                        CFG.core.getPlayer(CFG.PLAYER_TURN_ID).loadPlayersFlag();
                    }
                });
            }
            CFG.mapModesManager.disableAllViews();
            for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
                CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).setFromCivID(0);
            }
            CFG.palletManager.loadCivilizationStandardColor(nCivID);
            if (CFG.core.getCiv(nCivID).getNumOfNeighboringNeutralProvinces() > 0) {
                ArrayList<Integer> possibleProvinces = new ArrayList<Integer>();
                for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
                    for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getNeighProvincesSize(); ++j) {
                        possibleProvinces.add(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getNeighProvinces(j));
                    }
                }
                if (!possibleProvinces.isEmpty()) {
                    CFG.core.getProv((Integer)possibleProvinces.get(CFG.oR.nextInt(possibleProvinces.size()))).setCivId(nCivID, false);
                }
            }
            return true;
        }
        return false;
    }

    public static void sendTechPointsMessages() {
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
            if (CFG.core.getCiv((int)i).civGD.techPoints.getPointsLeft(i) > 0) {
                CFG.core.getCiv((int)i).getCivDiploGD().messageBox.addMessage(new Message_TechPoints(i));
            }
            if (!CFG.core.getCiv(i).getIsPlayer()) continue;
            CFG.core.getCiv((int)i).getCivDiploGD().messageBox.addMessage(new Message_OpenBudget(i));
        }
    }

    public static void sendUncivilizedMessages() {
        for (int a = 0; a < CFG.core.getPlayersSize(); ++a) {
            if (CFG.core.getCiv(CFG.core.getPlayer(a).getCivId()).getNumOfProvs() <= 0 || CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)CFG.core.getPlayer((int)a).getCivId()).getIdeology()).CAN_BECOME_CIVILIZED < 0) continue;
            CFG.core.getCiv((int)CFG.core.getPlayer((int)a).getCivId()).getCivDiploGD().messageBox.addMessage(new Message_Uncivilized(CFG.core.getPlayer(a).getCivId()));
        }
    }

    public static void sendLowHappiness() {
        for (int a = 0; a < CFG.core.getPlayersSize(); ++a) {
            if (CFG.core.getCiv(CFG.core.getPlayer(a).getCivId()).getNumOfProvs() <= 0) continue;
            if (CFG.core.getCiv(CFG.core.getPlayer(a).getCivId()).getHappiness() < GameValues.gvHappiness.SEND_MESSAGE_LOW_HAPPINESS_IF_BELOW) {
                CFG.core.getCiv((int)CFG.core.getPlayer((int)a).getCivId()).getCivDiploGD().messageBox.addMessage(new Message_LowHappiness(CFG.core.getPlayer(a).getCivId(), 0));
            }
            if (CFG.core.getCiv((int)CFG.core.getPlayer((int)a).getCivId()).provincesWithLowStability.isEmpty()) continue;
            boolean sendLowStability = false;
            for (int j = CFG.core.getCiv((int)CFG.core.getPlayer((int)a).getCivId()).provincesWithLowStability.size() - 1; j >= 0; --j) {
                if (!(CFG.core.getProv(CFG.core.getCiv((int)CFG.core.getPlayer((int)a).getCivId()).provincesWithLowStability.get(j)).getProviStability() < (float)GameValues.gvStability.SEND_MESSAGE_LOW_STABILITY_IF_BELOW)) continue;
                sendLowStability = true;
                break;
            }
            if (!sendLowStability) continue;
            CFG.core.getCiv((int)CFG.core.getPlayer((int)a).getCivId()).getCivDiploGD().messageBox.addMessage(new Message_LowStability(CFG.core.getPlayer(a).getCivId(), 0));
        }
    }

    public static int propagandaCost_AllProvinces(int civID, int turns) {
        int out = 0;
        for (int i = 0; i < CFG.core.getCiv(civID).getNumOfProvs(); ++i) {
            out += GameManager.propagandaCost(civID, CFG.core.getCiv(civID).getProvID(i), turns);
        }
        return out;
    }

    public static int propagandaCost(int civID, int provinceID, int turns) {
        int festivalCost = (int)Festival.festivalCost(provinceID);
        int capitalID = Math.max(CFG.core.getCiv(civID).getCapitalProvID(), 0);
        return (int)(((float)GameValues.gvPropaganda.PROPAGANDA_COST_GOLD_BASE + (float)festivalCost * GameValues.gvPropaganda.PROPAGANDA_COST_GOLD_COST_OF_FESTIVAL_MODIFIER + (float)festivalCost * Distance.getDistanceFromCapital_PercOfMax(capitalID, provinceID) * GameValues.gvPropaganda.PROPAGANDA_COST_GOLD_DISTANCE_MODIFIER) * (float)turns / (float)GameValues.gvPropaganda.PROPAGANDA_TURNS);
    }

    public static int propagandaCost(int civID, List<Integer> provinces, int turns) {
        int out = 0;
        int capitalID = Math.max(CFG.core.getCiv(civID).getCapitalProvID(), 0);
        for (int i = 0; i < provinces.size(); ++i) {
            int festivalCost = (int)Festival.festivalCost(provinces.get(i));
            out += (int)(((float)GameValues.gvPropaganda.PROPAGANDA_COST_GOLD_BASE + (float)festivalCost * GameValues.gvPropaganda.PROPAGANDA_COST_GOLD_COST_OF_FESTIVAL_MODIFIER + (float)festivalCost * Distance.getDistanceFromCapital_PercOfMax(capitalID, provinces.get(i)) * GameValues.gvPropaganda.PROPAGANDA_COST_GOLD_DISTANCE_MODIFIER) * (float)turns / (float)GameValues.gvPropaganda.PROPAGANDA_TURNS);
        }
        return out;
    }

    public static int propagandaCostDiplomacy_AllProvinces(int civID, int turns) {
        int out = 0;
        for (int i = 0; i < CFG.core.getCiv(civID).getNumOfProvs(); ++i) {
            out += GameManager.propagandaCostDiplomacy(turns);
        }
        return out;
    }

    public static int propagandaCostDiplomacy(int turns) {
        return (int)((float)GameValues.gvPropaganda.PROPAGANDA_COST_DIPLOMACY * (float)turns / (float)GameValues.gvPropaganda.PROPAGANDA_TURNS);
    }

    public static int propagandaCostDiplomacy(List<Integer> provinces, int turns) {
        return GameManager.propagandaCostDiplomacy(turns) * provinces.size();
    }

    
    public static boolean spreadPropaganda(int byCivID, int civID, List<Integer> provinces) { return GameManager.spreadPropaganda(byCivID, civID, provinces, GameValues.gvPropaganda.PROPAGANDA_TURNS); }
    public static boolean spreadPropaganda(int byCivID, int civID, int provinceID) { return GameManager.spreadPropaganda(byCivID, civID, provinceID, GameValues.gvPropaganda.PROPAGANDA_TURNS); }
    public static int propagandaCost(int civID, List<Integer> provinces) { return GameManager.propagandaCost(civID, provinces, GameValues.gvPropaganda.PROPAGANDA_TURNS); }
    public static int propagandaCost(int civID, int provinceID) { return GameManager.propagandaCost(civID, provinceID, GameValues.gvPropaganda.PROPAGANDA_TURNS); }
    public static int propagandaCostDiplomacy(List<Integer> provinces) { return GameManager.propagandaCostDiplomacy(provinces, GameValues.gvPropaganda.PROPAGANDA_TURNS); }
    public static int propagandaCostDiplomacy() { return GameValues.gvPropaganda.PROPAGANDA_COST_DIPLOMACY; }
    public static int propagandaCost_AllProvinces(int civID) { return GameManager.propagandaCost_AllProvinces(civID, GameValues.gvPropaganda.PROPAGANDA_TURNS); }
    public static int propagandaCostDiplomacy_AllProvinces(int civID) { return GameManager.propagandaCostDiplomacy_AllProvinces(civID, GameValues.gvPropaganda.PROPAGANDA_TURNS); }
    public static boolean spreadPropaganda(int byCivID, int civID, List<Integer> provinces, int turns) {
        int i;
        int costGold = GameManager.propagandaCost(byCivID, provinces, turns);
        int costDiplo = 50;
        if (CFG.core.getCiv(byCivID).getGold() < (long)costGold) {
            return false;
        }
        if (CFG.core.getCiv(byCivID).getDiploPoints() < costDiplo) {
            return false;
        }
        CFG.core.getCiv(byCivID).setGold(CFG.core.getCiv(byCivID).getGold() - (long)costGold);
        CFG.core.getCiv(byCivID).setDiploPoints(CFG.core.getCiv(byCivID).getDiploPoints() - costDiplo);
        for (i = provinces.size() - 1; i >= 0; --i) {
            Propaganda nPropaganda = new Propaganda(byCivID, provinces.get(i), GameCalendar.TURNID + turns);
            CFG.core.addPropaganda(nPropaganda);
        }
        if (CFG.core.getCiv(byCivID).getIsPlayer()) {
            try {
                for (i = 0; i < provinces.size(); ++i) {
                    Core.addDiplomacyLines(CFG.core.getCapitalOrProvince(byCivID), provinces.get(i), CFG.COLOR_NEGATIVE_2);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return true;
    }

    public static boolean spreadPropaganda_AllProvinces(int byCivID, int civID) {
        int a;
        int bestID;
        if (byCivID == civID) {
            return false;
        }
        int out = 0;
        ArrayList<Integer> provinces = new ArrayList<Integer>();
        for (int i = 0; i < CFG.core.getCiv(civID).getNumOfProvs(); ++i) {
            if (!(CFG.core.getProv(CFG.core.getCiv(civID).getProvID(i)).getHappi() > 0.01f)) continue;
            provinces.add(CFG.core.getCiv(civID).getProvID(i));
        }
        while (!provinces.isEmpty()) {
            bestID = 0;
            for (a = provinces.size() - 1; a > 0; --a) {
                if (!(CFG.core.getProv((Integer)provinces.get(a)).getHappi() > CFG.core.getProv((Integer)provinces.get(bestID)).getHappi()) || CFG.core.isPropagandaOrganized((Integer)provinces.get(a)) >= 0) continue;
                bestID = a;
            }
            if (CFG.core.isPropagandaOrganized((Integer)provinces.get(bestID)) > 0 || !GameManager.spreadPropaganda(byCivID, civID, (Integer)provinces.get(bestID), GameValues.gvPropaganda.PROPAGANDA_TURNS)) break;
            ++out;
            provinces.remove(bestID);
        }
        while (!provinces.isEmpty()) {
            bestID = 0;
            for (a = provinces.size() - 1; a > 0; --a) {
                if (CFG.core.isPropagandaOrganized((Integer)provinces.get(a)) >= CFG.core.isPropagandaOrganized((Integer)provinces.get(bestID))) continue;
                bestID = a;
            }
            if (!GameManager.spreadPropaganda(byCivID, civID, (Integer)provinces.get(bestID), GameValues.gvPropaganda.PROPAGANDA_TURNS)) break;
            ++out;
            provinces.remove(bestID);
        }
        if (out > 0 && byCivID == CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId()) {
            CFG.menus.rebuildMenu_InGame_Infobox(CFG.lang.get("SpreadPropaganda") + ": " + CFG.core.getCiv(civID).getCivName(), CFG.lang.get("Provinces") + ": " + CFG.getNumberWthSpaces("" + out), Images.infoDiplomacy);
            CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
        }
        return out > 0;
    }

    public static boolean spreadPropaganda(int byCivID, int civID, int provinceID, int turns) {
        int costGold = GameManager.propagandaCost(byCivID, provinceID, turns);
        int costDiplo = GameManager.propagandaCostDiplomacy(turns);
        if (CFG.core.getCiv(byCivID).getGold() < (long)costGold) {
            return false;
        }
        if (CFG.core.getCiv(byCivID).getDiploPoints() < costDiplo) {
            return false;
        }
        CFG.core.getCiv(byCivID).setGold(CFG.core.getCiv(byCivID).getGold() - (long)costGold);
        CFG.core.getCiv(byCivID).setDiploPoints(CFG.core.getCiv(byCivID).getDiploPoints() - costDiplo);
        Propaganda nPropaganda = new Propaganda(byCivID, provinceID, GameCalendar.TURNID + turns);
        CFG.core.addPropaganda(nPropaganda);
        if (CFG.core.getCiv(byCivID).getIsPlayer()) {
            try {
                Core.addDiplomacyLines(CFG.core.getCapitalOrProvince(byCivID), provinceID, CFG.COLOR_NEGATIVE_2);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return true;
    }

    public static final int getCostOfCurrentDiplomaticActions(int nCivID) {
        int out = 0;
        if (CFG.core.getCiv(nCivID).getAlliance() > 0 && CFG.core.getAlliance(CFG.core.getCiv(nCivID).getAlliance()).getCivilizationsSize() > 1) {
            out += GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_ALLIANCE;
        }
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.core.getCiv(i).getNumOfProvs() <= 0 || i == nCivID) continue;
            if (CFG.core.getCivNonAggressionPact(nCivID, i) > 0) {
                out += GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_NONAGGRESSION;
            }
            if (CFG.core.getGuarantee(nCivID, i) > 0) {
                out += GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_GUARANTEE;
            }
            if (CFG.core.getDefensivePact(nCivID, i) > 0) {
                out += GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_DEFENSIVE_PACT;
            }
            if (CFG.core.getMilitaryAccess(nCivID, i) > 0) {
                out += GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_MILITARY_ACCESS;
            }
            out += GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_VASSAL * CFG.core.getCiv((int)nCivID).civGD.iVassalsSize;
            out += GameManager.getCostOfFriendlyCivs(nCivID);
        }
        return out;
    }

    public static final int getCostOfFriendlyCivs(int nCivID) {
        return GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_FRIENDLY_CIV * CFG.core.getCiv(nCivID).getFriendlyCivsSize();
    }

    public static final int getCostOfCurrentDiplomaticActionsUpdate(int nCivID) {
        int out = 0;
        if (CFG.core.getCiv(nCivID).getAlliance() > 0 && CFG.core.getAlliance(CFG.core.getCiv(nCivID).getAlliance()).getCivilizationsSize() > 1) {
            out += GameValues.gvDiplomacyPoints.DIPLOMACY_COST_PER_ALLIANCE;
        }
        return out;
    }

    public static final void updateGoldenAge() {
        block30: {
            int counted;
            int i;
            int toRand;
            ArrayList<Integer> tCivs;
            float fAverage;
            int nCivs;
            int nAverageScore;
            int i2;
            float militarySpending = 0.0f;
            for (i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                if (CFG.core.getCiv(i2).getNumOfProvs() <= 0) continue;
                CFG.core.getCiv(i2).setGoldenAge_Prosperity(CFG.core.getCiv(i2).getGoldenAge_Prosperity() + (int)((CFG.core.getCiv(i2).getSpendingGoodsB() - CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(i2).getIdeology()).getMin_Goods(i2)) * 100.0f * GameValues.gvGoldenAge.GOLDEN_AGE_PROSPERITY_PROGRESS_MODIFIER) + (int)((CFG.core.getCiv(i2).getSpendingInvestmentsB() - CFG.ideologiesMgr.getInvestments(CFG.core.getCiv(i2).getIdeology(), i2)) * 100.0f * GameValues.gvGoldenAge.GOLDEN_AGE_PROSPERITY_PROGRESS_MODIFIER));
                CFG.core.getCiv(i2).setGoldenAge_Science(CFG.core.getCiv(i2).getGoldenAge_Science() + (int)(CFG.core.getCiv(i2).getSpendingResearchB() * 100.0f * GameValues.gvGoldenAge.GOLDEN_AGE_SCIENCE_PROGRESS_MODIFIER));
                militarySpending = CFG.gameUpdate.getMilitarySpending2(i2, CFG.core.getCiv((int)i2).iBudget);
                CFG.core.getCiv(i2).setGoldenAge_Military(CFG.core.getCiv(i2).getGoldenAge_Military() + (int)((float)CFG.gameUpdate.getMilitarySpending(i2, CFG.core.getCiv((int)i2).iBudget) * GameValues.gvGoldenAge.GOLDEN_AGE_MILITARY_PROGRESS_MODIFIER));
                
            }
            if (GameCalendar.TURNID % GameValues.gvGoldenAge.GOLDEN_AGE_UPDATE_EVERY_X_TURNS == GameValues.gvGoldenAge.GOLDEN_AGE_SCIENCE_UPDATE_TURN) {
                if (GameManager.getNumOfCivsInTheGame() > GameValues.gvGoldenAge.GOLDEN_AGE_MIN_NUM_OF_CIVS) {
                    nAverageScore = 0;
                    nCivs = 0;
                    for (int i3 = 1; i3 < CFG.core.getCivsSize(); ++i3) {
                        if (CFG.core.getCiv(i3).getNumOfProvs() <= 0) continue;
                        nAverageScore += CFG.core.getCiv(i3).getGoldenAge_Science();
                        ++nCivs;
                    }
                    fAverage = (float)Math.ceil((float)nAverageScore / (float)Math.max(nCivs, 1));
                    tCivs = new ArrayList<Integer>();
                    toRand = 0;
                    for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                        if (CFG.core.getCiv(i).getNumOfProvs() <= 0 || !((float)CFG.core.getCiv(i).getGoldenAge_Science() >= fAverage)) continue;
                        toRand += CFG.core.getCiv(i).getGoldenAge_Science();
                        tCivs.add(i);
                    }
                    if (toRand > 0) {
                        toRand = CFG.oR.nextInt(toRand);
                        counted = 0;
                        for (i = 0; i < tCivs.size(); ++i) {
                            if (toRand >= counted && toRand < counted + CFG.core.getCiv((Integer)tCivs.get(i)).getGoldenAge_Science()) {
                                GameManager.goldenAge_Science((Integer)tCivs.get(i));
                                CFG.core.getCiv((Integer)tCivs.get(i)).setGoldenAge_Science(0);
                                break;
                            }
                            counted += CFG.core.getCiv((Integer)tCivs.get(i)).getGoldenAge_Science();
                        }
                    }
                    tCivs.clear();
                    for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                        CFG.core.getCiv(i).setGoldenAge_Science((int)((float)CFG.core.getCiv(i).getGoldenAge_Science() * GameValues.gvGoldenAge.GOLDEN_AGE_SCIENCE_DECAY_PER_UPDATE));
                    }
                } else {
                    for (i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                        CFG.core.getCiv(i2).setGoldenAge_Science((int)((float)CFG.core.getCiv(i2).getGoldenAge_Science() * GameValues.gvGoldenAge.GOLDEN_AGE_SCIENCE_DECAY_PER_UPDATE / 2.0f));
                    }
                }
            }
            if (GameCalendar.TURNID % GameValues.gvGoldenAge.GOLDEN_AGE_UPDATE_EVERY_X_TURNS == GameValues.gvGoldenAge.GOLDEN_AGE_MILITARY_UPDATE_TURN) {
                if (GameManager.getNumOfCivsInTheGame() > GameValues.gvGoldenAge.GOLDEN_AGE_MIN_NUM_OF_CIVS) {
                    nAverageScore = 0;
                    nCivs = 0;
                    for (int i4 = 1; i4 < CFG.core.getCivsSize(); ++i4) {
                        if (CFG.core.getCiv(i4).getNumOfProvs() <= 0) continue;
                        nAverageScore += CFG.core.getCiv(i4).getGoldenAge_Military();
                        ++nCivs;
                    }
                    fAverage = (float)Math.ceil((float)nAverageScore / (float)Math.max(nCivs, 1));
                    tCivs = new ArrayList();
                    toRand = 0;
                    for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                        if (CFG.core.getCiv(i).getNumOfProvs() <= 0 || !((float)CFG.core.getCiv(i).getGoldenAge_Military() >= fAverage)) continue;
                        toRand += CFG.core.getCiv(i).getGoldenAge_Military();
                        tCivs.add(i);
                    }
                    if (toRand > 0) {
                        toRand = CFG.oR.nextInt(toRand);
                        counted = 0;
                        for (i = 0; i < tCivs.size(); ++i) {
                            if (toRand >= counted && toRand < counted + CFG.core.getCiv((Integer)tCivs.get(i)).getGoldenAge_Military()) {
                                GameManager.goldenAge_Military((Integer)tCivs.get(i));
                                CFG.core.getCiv((Integer)tCivs.get(i)).setGoldenAge_Military(0);
                                break;
                            }
                            counted += CFG.core.getCiv((Integer)tCivs.get(i)).getGoldenAge_Military();
                        }
                    }
                    tCivs.clear();
                    for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                        CFG.core.getCiv(i).setGoldenAge_Military((int)((float)CFG.core.getCiv(i).getGoldenAge_Military() * GameValues.gvGoldenAge.GOLDEN_AGE_MILITARY_DECAY_PER_UPDATE));
                    }
                } else {
                    for (i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                        CFG.core.getCiv(i2).setGoldenAge_Military((int)((float)CFG.core.getCiv(i2).getGoldenAge_Military() * GameValues.gvGoldenAge.GOLDEN_AGE_MILITARY_DECAY_PER_UPDATE / 2.0f));
                    }
                }
            }
            if (GameCalendar.TURNID % GameValues.gvGoldenAge.GOLDEN_AGE_UPDATE_EVERY_X_TURNS != GameValues.gvGoldenAge.GOLDEN_AGE_PROSPERITY_UPDATE_TURN) break block30;
            if (GameManager.getNumOfCivsInTheGame() > GameValues.gvGoldenAge.GOLDEN_AGE_MIN_NUM_OF_CIVS) {
                nAverageScore = 0;
                nCivs = 0;
                for (int i5 = 1; i5 < CFG.core.getCivsSize(); ++i5) {
                    if (CFG.core.getCiv(i5).getNumOfProvs() <= 0) continue;
                    nAverageScore += CFG.core.getCiv(i5).getGoldenAge_Prosperity();
                    ++nCivs;
                }
                float fAverage2 = (float)Math.ceil((float)nAverageScore / (float)Math.max(nCivs, 1));
                tCivs = new ArrayList();
                toRand = 0;
                for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                    if (CFG.core.getCiv(i).getNumOfProvs() <= 0 || !((float)CFG.core.getCiv(i).getGoldenAge_Prosperity() >= fAverage2)) continue;
                    toRand += CFG.core.getCiv(i).getGoldenAge_Prosperity();
                    tCivs.add(i);
                }
                if (toRand > 0) {
                    toRand = CFG.oR.nextInt(toRand);
                    counted = 0;
                    for (i = 0; i < tCivs.size(); ++i) {
                        if (toRand >= counted && toRand < counted + CFG.core.getCiv((Integer)tCivs.get(i)).getGoldenAge_Prosperity()) {
                            GameManager.goldenAge_Prosperity((Integer)tCivs.get(i));
                            CFG.core.getCiv((Integer)tCivs.get(i)).setGoldenAge_Prosperity(0);
                            break;
                        }
                        counted += CFG.core.getCiv((Integer)tCivs.get(i)).getGoldenAge_Prosperity();
                    }
                }
                tCivs.clear();
                for (i = 1; i < CFG.core.getCivsSize(); ++i) {
                    CFG.core.getCiv(i).setGoldenAge_Prosperity((int)((float)CFG.core.getCiv(i).getGoldenAge_Prosperity() * GameValues.gvGoldenAge.GOLDEN_AGE_PROSPERITY_DECAY_PER_UPDATE));
                }
            } else {
                for (i2 = 1; i2 < CFG.core.getCivsSize(); ++i2) {
                    CFG.core.getCiv(i2).setGoldenAge_Prosperity((int)((float)CFG.core.getCiv(i2).getGoldenAge_Prosperity() * GameValues.gvGoldenAge.GOLDEN_AGE_PROSPERITY_DECAY_PER_UPDATE / 2.0f));
                }
            }
        }
    }

    public static int getNumOfCivsInTheGame() {
        int nCivs = 0;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
            ++nCivs;
        }
        return nCivs;
    }

    public static final void goldenAge_Prosperity(int nCivID) {
        CivBonus_GameData nGodlenAge = new CivBonus_GameData();
        nGodlenAge.iTurnsLeft = GameValues.gvGoldenAgeProsperity.NUM_OF_TURNS;
        nGodlenAge.BONUS_TYPE = CivBonus_Type.GOLDEN_AGE_PROSPERITY;
        nGodlenAge.fModifier_PopGrowth = GameValues.gvGoldenAgeProsperity.POP_GROWTH_BASE + (float)CFG.oR.nextInt(GameValues.gvGoldenAgeProsperity.POP_GROWTH_RANDOM_100) / 100.0f;
        nGodlenAge.fModifier_EconomyGrowth = GameValues.gvGoldenAgeProsperity.ECO_GROWTH_BASE + (float)CFG.oR.nextInt(GameValues.gvGoldenAgeProsperity.ECO_GROWTH_RANDOM_100) / 100.0f;
        nGodlenAge.fModifier_IncomeTaxation = GameValues.gvGoldenAgeProsperity.INCOME_TAXATION_BASE + (float)CFG.oR.nextInt(GameValues.gvGoldenAgeProsperity.INCOME_TAXATION_RANDOM_100) / 100.0f;
        if (CFG.core.getCiv(nCivID).addNewBonus(nGodlenAge) && CFG.core.getCiv(nCivID).getIsPlayer()) {
            CFG.core.getCiv((int)nCivID).getCivDiploGD().messageBox.addMessage(new Message_GoldenAge(nCivID, nGodlenAge.iTurnsLeft));
        }
    }

    public static final void goldenAge_Military(int nCivID) {
        CivBonus_GameData nGodlenAge = new CivBonus_GameData();
        nGodlenAge.iTurnsLeft = GameValues.gvGoldenAgeMilitary.NUM_OF_TURNS;
        nGodlenAge.BONUS_TYPE = CivBonus_Type.GOLDEN_AGE_MILITARY;
        nGodlenAge.fModifier_AttackBonus = GameValues.gvGoldenAgeMilitary.ATTACK_BONUS_BASE + (float)CFG.oR.nextInt(GameValues.gvGoldenAgeMilitary.ATTACK_BONUS_RANDOM_100) / 100.0f;
        nGodlenAge.fModifier_MilitaryUpkeep = GameValues.gvGoldenAgeMilitary.MILITARY_UPKEEP_BASE - (float)CFG.oR.nextInt(GameValues.gvGoldenAgeMilitary.MILITARY_UPKEEP_RANDOM_100) / 100.0f;
        nGodlenAge.fModifier_MovementPoints = GameValues.gvGoldenAgeMilitary.MOVEMENT_POINTS_BASE + (float)CFG.oR.nextInt(GameValues.gvGoldenAgeMilitary.MOVEMENT_POINTS_RANDOM_100) / 100.0f;
        if (CFG.core.getCiv(nCivID).addNewBonus(nGodlenAge) && CFG.core.getCiv(nCivID).getIsPlayer()) {
            CFG.core.getCiv((int)nCivID).getCivDiploGD().messageBox.addMessage(new Message_GoldenAgeMilitary(nCivID, nGodlenAge.iTurnsLeft));
        }
    }

    public static final void goldenAge_Science(int nCivID) {
        CivBonus_GameData nGodlenAge = new CivBonus_GameData();
        nGodlenAge.iTurnsLeft = GameValues.gvGoldenAgeScience.NUM_OF_TURNS;
        nGodlenAge.BONUS_TYPE = CivBonus_Type.GOLDEN_AGE_SCIENCE;
        nGodlenAge.fModifier_Research = GameValues.gvGoldenAgeScience.RESEARCH_BASE + (float)CFG.oR.nextInt(GameValues.gvGoldenAgeScience.RESEARCH_RANDOM_100) / 100.0f;
        nGodlenAge.fModifier_DefenseBonus = GameValues.gvGoldenAgeScience.DEFENSE_BONUS_BASE + (float)CFG.oR.nextInt(GameValues.gvGoldenAgeScience.DEFENSE_BONUS_RANDOM_100) / 100.0f;
        nGodlenAge.fModifier_IncomeProduction = GameValues.gvGoldenAgeScience.INCOME_PRODUCTION_BASE + (float)CFG.oR.nextInt(GameValues.gvGoldenAgeScience.INCOME_PRODUCTION_RANDOM_100) / 100.0f;
        if (CFG.core.getCiv(nCivID).addNewBonus(nGodlenAge) && CFG.core.getCiv(nCivID).getIsPlayer()) {
            CFG.core.getCiv((int)nCivID).getCivDiploGD().messageBox.addMessage(new Message_GoldenAgeScience(nCivID, nGodlenAge.iTurnsLeft));
        }
    }

    public static boolean changeAdministrationPolicy(int civID, int toPolicyID) {
        if (CFG.core.getCiv(civID).getGold() < (long)CFG.ideologiesMgr.getChangeAdministrationPolicyCost(civID)) {
            return false;
        }
        if (toPolicyID < 0) {
            return false;
        }
        CFG.core.getCiv(civID).setGold(CFG.core.getCiv(civID).getGold() - (long)Math.max(1, CFG.ideologiesMgr.getChangeAdministrationPolicyCost(civID)));
        CFG.core.getCiv((int)civID).civGD.policyID = toPolicyID;
        return true;
    }

    public static final void sendAllianceProposal(int iToCivID, int iFromCivID) {
        if (CFG.core.getCiv(iToCivID).getAlliance() > 0 && CFG.core.getAlliance(CFG.core.getCiv(iToCivID).getAlliance()).getCivilizationsSize() > 0) {
            CFG.core.getCiv((int)CFG.core.getAlliance((int)CFG.core.getCiv((int)iToCivID).getAlliance()).getCivilization((int)0)).getCivDiploGD().messageBox.addMessage(new Message(iFromCivID, 0));
        } else {
            CFG.core.getCiv((int)iToCivID).getCivDiploGD().messageBox.addMessage(new Message(iFromCivID, 0));
        }
        CFG.core.getCiv(iFromCivID).setDiploPoints(CFG.core.getCiv(iFromCivID).getDiploPoints() - GameValues.gvAllianceOffer.COST_OFFER_ALLIANCE_DIPLOMACY_POINTS);
        if (!CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.core.getCiv(iFromCivID).addSentMessages(new Civilization_SentMessages(iToCivID, MessageType.JOIN_ALLIANCE));
        }
    }

    public static final void declineAllianceProposal(int iCivID, int iFromCivID) {
        if (CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_Alliance_Denied(iCivID));
        }
    }

    public static final void acceptAllianceProposal(int iCivID, int iFromCivID) {
        if (CFG.core.getCiv(iCivID).getAlliance() == 0 && CFG.core.getCiv(iFromCivID).getAlliance() == 0) {
            CFG.core.addAlliance(CFG.getRandomAllianceName(0));
            int tempAllianceID = CFG.core.getAlliancesSize() - 1;
            if (CFG.core.getCiv(iCivID).getIsPlayer()) {
                CFG.core.getAlliance(tempAllianceID).addCivilization(iCivID);
                CFG.core.getAlliance(tempAllianceID).addCivilization(iFromCivID);
            } else if (CFG.core.getCiv(iFromCivID).getIsPlayer()) {
                CFG.core.getAlliance(tempAllianceID).addCivilization(iFromCivID);
                CFG.core.getAlliance(tempAllianceID).addCivilization(iCivID);
            } else {
                CFG.core.getAlliance(tempAllianceID).addCivilization(iCivID);
                CFG.core.getAlliance(tempAllianceID).addCivilization(iFromCivID);
            }
            CFG.core.getCiv(iCivID).setAlliance(tempAllianceID);
            CFG.core.getCiv(iFromCivID).setAlliance(tempAllianceID);
            CFG.historyManager.addHistoryLog(new HistoryLog_JoinAlliance(iCivID, tempAllianceID));
            CFG.historyManager.addHistoryLog(new HistoryLog_JoinAlliance(iFromCivID, tempAllianceID));
        } else if (CFG.core.getCiv(iFromCivID).getAlliance() > 0 && CFG.core.getCiv(iCivID).getAlliance() == 0) {
            CFG.core.getAlliance(CFG.core.getCiv(iFromCivID).getAlliance()).addCivilization(iCivID);
            CFG.core.getCiv(iCivID).setAlliance(CFG.core.getCiv(iFromCivID).getAlliance());
            CFG.historyManager.addHistoryLog(new HistoryLog_JoinAlliance(iCivID, CFG.core.getCiv(iFromCivID).getAlliance()));
        } else if (CFG.core.getCiv(iCivID).getAlliance() > 0 && CFG.core.getCiv(iFromCivID).getAlliance() == 0) {
            CFG.core.getAlliance(CFG.core.getCiv(iCivID).getAlliance()).addCivilization(iFromCivID);
            CFG.core.getCiv(iFromCivID).setAlliance(CFG.core.getCiv(iCivID).getAlliance());
            CFG.historyManager.addHistoryLog(new HistoryLog_JoinAlliance(iFromCivID, CFG.core.getCiv(iCivID).getAlliance()));
        } else {
            CFG.core.getAlliance(CFG.core.getCiv(iCivID).getAlliance()).removeCivilization(iCivID);
            CFG.core.getAlliance(CFG.core.getCiv(iFromCivID).getAlliance()).addCivilization(iCivID);
            CFG.core.getCiv(iCivID).setAlliance(CFG.core.getCiv(iFromCivID).getAlliance());
            CFG.core.getCiv(iCivID).setAlliance(CFG.core.getCiv(iFromCivID).getAlliance());
        }
        if (CFG.core.getCiv(iCivID).getIsPlayer()) {
            CFG.gameAction.buildFogOfWar(CFG.core.getPlayerIDbyCivID(iCivID));
            CFG.core.getPlayer(CFG.core.getPlayerIDbyCivID(iCivID)).buildMetProvsAndCivs();
        }
        if (CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.gameAction.buildFogOfWar(CFG.core.getPlayerIDbyCivID(iFromCivID));
            CFG.core.getPlayer(CFG.core.getPlayerIDbyCivID(iFromCivID)).buildMetProvsAndCivs();
        }
        CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_Alliance_Accepted(iCivID));
    }

    public static int getAllianceProposal_Positive(int nCivA, int nCivB) {
        int out = 0;
        out += GameManager.getAllianceProposal_Positive_Opinion(nCivA, nCivB);
        out += GameManager.getAllianceProposal_Positive_Government(nCivA, nCivB);
        out += GameManager.getAllianceProposal_Positive_Religion(nCivA, nCivB);
        if (GameManager.getAllianceProposal_CivStrength(nCivA, nCivB) > 0) {
            out += GameManager.getAllianceProposal_CivStrength(nCivA, nCivB);
        }
        return out += GameManager.getAllianceProposal_Positive_HRE(nCivA, nCivB);
    }

    public static int getAllianceProposal_Negative(int nCivA, int nCivB) {
        int out = 0;
        out += GameManager.getAllianceProposal_Negative_Opinion(nCivA, nCivB);
        out += GameManager.getAllianceProposal_Negative_Government(nCivA, nCivB);
        out += GameManager.getAllianceProposal_Negative_Religion(nCivA, nCivB);
        out += GameManager.getAllianceProposal_Negative_HRE(nCivA, nCivB);
        out += GameManager.getAllianceProposal_Negative_PowerfulAllies(nCivA, nCivB);
        out += GameManager.getAllianceProposal_Negative_PowerfulAllies(nCivB, nCivA);
        out += GameManager.getAllianceProposal_Negative_CivIsAtWar(nCivA);
        out += GameManager.getAllianceProposal_Negative_EmbassyClosed(nCivA, nCivB);
        out += GameManager.getAllianceProposal_Negative_HaveACore(nCivA, nCivB);
        out += GameManager.getAllianceProposal_Negative_IsAVassal(nCivA, nCivB);
        out += GameManager.getAllianceProposal_Negative_Distance(nCivA, nCivB);
        if (GameManager.getAllianceProposal_CivStrength(nCivA, nCivB) < 0) {
            out += GameManager.getAllianceProposal_CivStrength(nCivA, nCivB);
        }
        return out;
    }

    public static int getAllianceProposal_Positive_HRE(int nCivA, int nCivB) {
        if (CFG.core.getCiv(nCivA).getIsPartOfHolyRomanEmpire() && CFG.core.getCiv(nCivB).getIsPartOfHolyRomanEmpire()) {
            return GameValues.gvAllianceOffer.SCORE_POSITIVE_HRE;
        }
        return 0;
    }

    public static int getAllianceProposal_Positive_Opinion(int nCivA, int nCivB) {
        if (CFG.core.getCivRelationOfCivB(nCivB, nCivA) - CFG.core.getCiv((int)nCivB).RESPONSE_ALLIANCE_OPINION > 0.0f) {
            return (int)((CFG.core.getCivRelationOfCivB(nCivB, nCivA) - CFG.core.getCiv((int)nCivB).RESPONSE_ALLIANCE_OPINION) * GameValues.gvAllianceOffer.SCORE_POSITIVE_RELATION_MODIFIER);
        }
        return 0;
    }

    public static int getAllianceProposal_Positive_Government(int nCivA, int nCivB) {
        if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivA).getIdeology()).GOV_GROUP_ID == CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivB).getIdeology()).GOV_GROUP_ID) {
            if (CFG.core.getCiv(nCivA).getIdeology() == CFG.core.getCiv(nCivB).getIdeology()) {
                return GameValues.gvAllianceOffer.SCORE_POSITIVE_SAME_GOVERNMENT;
            }
            return GameValues.gvAllianceOffer.SCORE_POSITIVE_SAME_GOVERNMENT_GROUP;
        }
        return GameValues.gvAllianceOffer.SCORE_POSITIVE_DIFFERENT_GOVERNMENT;
    }

    public static int getAllianceProposal_Positive_Religion(int nCivA, int nCivB) {
        if (CFG.religionManager.getReligion((int)CFG.core.getCiv((int)nCivA).getReligionID()).ReligionGroupID == CFG.religionManager.getReligion((int)CFG.core.getCiv((int)nCivB).getReligionID()).ReligionGroupID) {
            if (CFG.core.getCiv(nCivA).getReligionID() == CFG.core.getCiv(nCivB).getReligionID()) {
                return GameValues.gvAllianceOffer.SCORE_POSITIVE_SAME_RELIGION;
            }
            return GameValues.gvAllianceOffer.SCORE_POSITIVE_SAME_RELIGION_GROUP;
        }
        return GameValues.gvAllianceOffer.SCORE_POSITIVE_DIFFERENT_RELIGION;
    }

    public static int getAllianceProposal_CivStrength(int nCivA, int nCivB) { float ratio = (float)CFG.core.getCiv(nCivA).getRankScore() / (float)Math.max(1, CFG.core.getCiv(nCivB).getRankScore()); return Math.min(40, (int)(ratio * 4.0f)); }

    public static int getAllianceProposal_Negative_Opinion(int nCivA, int nCivB) {
        if (CFG.core.getCivRelationOfCivB(nCivB, nCivA) - CFG.core.getCiv((int)nCivB).RESPONSE_ALLIANCE_OPINION < 0.0f) {
            return (int)((CFG.core.getCivRelationOfCivB(nCivB, nCivA) - CFG.core.getCiv((int)nCivB).RESPONSE_ALLIANCE_OPINION) * GameValues.gvAllianceOffer.SCORE_NEGATIVE_RELATION_MODIFIER - (float)(CFG.core.getCivRelationOfCivB(nCivB, nCivA) < (float)GameValues.gvAllianceOffer.SCORE_NEGATIVE_RELATION_BELOW_X_VALUE ? GameValues.gvAllianceOffer.SCORE_NEGATIVE_RELATION_BELOW_X_PENALTY : 0));
        }
        return 0;
    }

    public static int getAllianceProposal_Negative_HRE(int nCivA, int nCivB) {
        if (CFG.core.getCiv(nCivA).getIsPartOfHolyRomanEmpire() && !CFG.core.getCiv(nCivB).getIsPartOfHolyRomanEmpire() || !CFG.core.getCiv(nCivA).getIsPartOfHolyRomanEmpire() && CFG.core.getCiv(nCivB).getIsPartOfHolyRomanEmpire()) {
            return GameValues.gvAllianceOffer.SCORE_NEGATIVE_HRE_MEMBERSHIP_DIFFERENCE;
        }
        return 0;
    }

    public static int getAllianceProposal_Negative_Government(int nCivA, int nCivB) {
        if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivA).getIdeology()).GOV_GROUP_ID == CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivB).getIdeology()).GOV_GROUP_ID) {
            if (CFG.core.getCiv(nCivA).getIdeology() == CFG.core.getCiv(nCivB).getIdeology()) {
                return 0;
            }
            return GameValues.gvAllianceOffer.SCORE_NEGATIVE_GOVERNMENT_SAME_GROUP;
        }
        if (CFG.core.getCiv(nCivA).getIdeology() != CFG.core.getCiv(nCivB).getIdeology()) {
            return GameValues.gvAllianceOffer.SCORE_NEGATIVE_GOVERNMENT_DIFFERENT_GROUP_AND_GOVERNMENT;
        }
        return 0;
    }

    public static int getAllianceProposal_Negative_Religion(int nCivA, int nCivB) {
        if (CFG.religionManager.getReligion((int)CFG.core.getCiv((int)nCivA).getReligionID()).ReligionGroupID == CFG.religionManager.getReligion((int)CFG.core.getCiv((int)nCivB).getReligionID()).ReligionGroupID) {
            if (CFG.core.getCiv(nCivA).getReligionID() == CFG.core.getCiv(nCivB).getReligionID()) {
                return 0;
            }
            return GameValues.gvAllianceOffer.SCORE_NEGATIVE_RELIGION_SAME_GROUP;
        }
        if (CFG.core.getCiv(nCivA).getReligionID() != CFG.core.getCiv(nCivB).getReligionID()) {
            return GameValues.gvAllianceOffer.SCORE_NEGATIVE_RELIGION_DIFFERENT_GROUP_AND_RELIGION;
        }
        return 0;
    }

    public static int getAllianceProposal_Negative_PowerfulAllies(int nCivA, int nCivB) {
        return 0;
    }

    public static int getAllianceProposal_Negative_CivIsAtWar(int nCivA) {
        if (CFG.core.getCiv(nCivA).isAtWarC()) {
            return GameValues.gvAllianceOffer.SCORE_NEGATIVE_CIV_AT_WAR;
        }
        return 0;
    }

    public static int getAllianceProposal_Negative_EmbassyClosed(int nCivA, int nCivB) {
        if (CFG.core.getCiv(nCivA).getCivDiploGD().getIsEmbassyClosed(nCivB) || CFG.core.getCiv(nCivB).getCivDiploGD().getIsEmbassyClosed(nCivA)) {
            return GameValues.gvAllianceOffer.SCORE_NEGATIVE_EMBASSY_CLOSED;
        }
        return 0;
    }

    public static int getAllianceProposal_Negative_HaveACore(int nCivA, int nCivB) {
        int nNumOfCores = 0;
        for (int i = 0; i < CFG.core.getCiv(nCivA).getNumOfProvs(); ++i) {
            if (!CFG.core.getProv(CFG.core.getCiv(nCivA).getProvID(i)).getCores().getHaveACore(nCivB)) continue;
            ++nNumOfCores;
        }
        return nNumOfCores > 0 ? -Math.min(GameValues.gvAllianceOffer.SCORE_NEGATIVE_CORE_PENALTY_BASE + GameValues.gvAllianceOffer.SCORE_NEGATIVE_PER_EXTRA_CORE * (nNumOfCores - 1), GameValues.gvAllianceOffer.SCORE_NEGATIVE_CORE_PENALTY_MAX) : 0;
    }

    public static int getAllianceProposal_Negative_IsAVassal(int nCivA, int nCivB) {
        return CFG.core.getCiv(nCivA).getPuppetOfCiv() != nCivA && CFG.core.getCiv(nCivA).getPuppetOfCiv() != nCivB ? GameValues.gvAllianceOffer.SCORE_NEGATIVE_IS_VASSAL : 0;
    }

    public static int getAllianceProposal_Negative_Distance(int nCivA, int nCivB) {
        return 0;
    }

    public static final void joinAWar(int iCivID, int iFromCivID, int iValue) {
        int tWarID = CFG.core.getWarID(iFromCivID, iValue);
        CFG.core.joinWar(iCivID, iValue, tWarID);
        if (CFG.core.getCivsAtWar(iCivID, iValue)) {
            CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_AllyJoinedAWar(iCivID, iValue, iFromCivID));
            CFG.core.setCivRelationOfCivB(iCivID, iFromCivID, CFG.core.getCivRelationOfCivB(iCivID, iFromCivID) + (float)(GameValues.gvDipCallToArms.CALL_TO_ARMS_ACCEPT_RELATION_CHANGE / 2));
            CFG.core.setCivRelationOfCivB(iFromCivID, iCivID, CFG.core.getCivRelationOfCivB(iFromCivID, iCivID) + (float)(GameValues.gvDipCallToArms.CALL_TO_ARMS_ACCEPT_RELATION_CHANGE / 2));
        }
    }

    public static final List<Integer> callToArmsListOfCivs(int byCivID, int onCivID) {
        int i;
        ArrayList<Integer> alliesToCall = new ArrayList<Integer>();
        int tWarID = CFG.core.getWarID(byCivID, onCivID);
        if (CFG.core.getCiv(byCivID).getAlliance() > 0) {
            for (i = 0; i < CFG.core.getAlliance(CFG.core.getCiv(byCivID).getAlliance()).getCivilizationsSize(); ++i) {
                if (CFG.core.getCiv(CFG.core.getAlliance(CFG.core.getCiv(byCivID).getAlliance()).getCivilization(i)).getNumOfProvs() <= 0 || CFG.core.getAlliance(CFG.core.getCiv(byCivID).getAlliance()).getCivilization(i) == byCivID || CFG.core.getCivsAtWar(CFG.core.getAlliance(CFG.core.getCiv(byCivID).getAlliance()).getCivilization(i), onCivID)) continue;
                alliesToCall.add(CFG.core.getAlliance(CFG.core.getCiv(byCivID).getAlliance()).getCivilization(i));
            }
        }
        try {
            for (i = 0; i < CFG.core.getCiv((int)byCivID).civGD.iVassalsSize; ++i) {
                if (tWarID >= 0 && (CFG.core.getWar(tWarID).getIsInDefenders(CFG.core.getCiv((int)byCivID).civGD.vassals.get((int)i).iCivID) || CFG.core.getWar(tWarID).getIsAggressor(CFG.core.getCiv((int)byCivID).civGD.vassals.get((int)i).iCivID)) || CFG.core.getCiv(CFG.core.getCiv((int)byCivID).civGD.vassals.get((int)i).iCivID).getNumOfProvs() <= 0) continue;
                boolean wasAdded = false;
                for (int j = 0; j < alliesToCall.size(); ++j) {
                    if ((Integer)alliesToCall.get(j) != CFG.core.getCiv((int)byCivID).civGD.vassals.get((int)i).iCivID) continue;
                    wasAdded = true;
                    break;
                }
                if (wasAdded) continue;
                alliesToCall.add(CFG.core.getCiv((int)byCivID).civGD.vassals.get((int)i).iCivID);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        try {
            if (CFG.core.getCiv(byCivID).getCivId() != CFG.core.getCiv(byCivID).getPuppetOfCiv() && (tWarID < 0 || !CFG.core.getWar(tWarID).getIsInDefenders(CFG.core.getCiv(byCivID).getPuppetOfCiv()) && !CFG.core.getWar(tWarID).getIsAggressor(CFG.core.getCiv(byCivID).getPuppetOfCiv())) && CFG.core.getCiv(CFG.core.getCiv(byCivID).getPuppetOfCiv()).getNumOfProvs() > 0) {
                boolean wasAdded = false;
                for (int j = 0; j < alliesToCall.size(); ++j) {
                    if (((Integer)alliesToCall.get(j)).intValue() != CFG.core.getCiv(byCivID).getPuppetOfCiv()) continue;
                    wasAdded = true;
                    break;
                }
                if (!wasAdded) {
                    alliesToCall.add(CFG.core.getCiv(byCivID).getPuppetOfCiv());
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return alliesToCall;
    }

    public static final void sendCallToArms(int iToCivID, int iFromCivID, int warAgainstCivID) {
        CFG.core.getCiv((int)iToCivID).getCivDiploGD().messageBox.addMessage(new Message_CallToArms(iFromCivID, warAgainstCivID));
        CFG.core.getCiv(iFromCivID).setDiploPoints(CFG.core.getCiv(iFromCivID).getDiploPoints() - GameValues.gvDipCallToArms.COST_CALL_TO_ARMS_DIPLOMACY_POINTS);
        if (!CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.core.getCiv(iFromCivID).addSentMessages(new Civilization_SentMessages(iToCivID, MessageType.WAR_DECLARED_ON_ALLY));
        }
    }

    public static final void acceptCallToArms(int iCivID, int iFromCivID, int iValue) {
        int tWarID = CFG.core.getWarID(iFromCivID, iValue);
        CFG.core.joinWar(iCivID, iValue, tWarID);
        if (CFG.core.getCivsAtWar(iCivID, iValue)) {
            CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_CallToArms_Join(iCivID, iValue, iFromCivID));
            CFG.core.setCivRelationOfCivB(iCivID, iFromCivID, CFG.core.getCivRelationOfCivB(iCivID, iFromCivID) + (float)GameValues.gvDipCallToArms.CALL_TO_ARMS_ACCEPT_RELATION_CHANGE);
            CFG.core.setCivRelationOfCivB(iFromCivID, iCivID, CFG.core.getCivRelationOfCivB(iFromCivID, iCivID) + (float)GameValues.gvDipCallToArms.CALL_TO_ARMS_ACCEPT_RELATION_CHANGE);
        }
        CFG.oAI.buildAI_Data();
    }

    public static final void declineCallToArms(int iCivID, int iFromCivID, int iValue) {
        if (!CFG.core.getCivsAtWar(iCivID, iValue)) {
            CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_CallToArms_Deny(iCivID, iValue, iFromCivID, DECLINE_CALL_TO_ARMS_REASON));
            CFG.core.setCivRelationOfCivB(iCivID, iFromCivID, CFG.core.getCivRelationOfCivB(iCivID, iFromCivID) > (float)GameValues.gvDiplomacy.RELATION_AT_WAR && CFG.core.getCivRelationOfCivB(iCivID, iFromCivID) + (float)GameValues.gvDipCallToArms.CALL_TO_ARMS_DENY_RELATION_CHANGE <= (float)GameValues.gvDiplomacy.RELATION_AT_WAR ? (float)(GameValues.gvDiplomacy.RELATION_AT_WAR + 1) : CFG.core.getCivRelationOfCivB(iCivID, iFromCivID) + (float)GameValues.gvDipCallToArms.CALL_TO_ARMS_DENY_RELATION_CHANGE);
            CFG.core.setCivRelationOfCivB(iFromCivID, iCivID, CFG.core.getCivRelationOfCivB(iFromCivID, iCivID) > (float)GameValues.gvDiplomacy.RELATION_AT_WAR && CFG.core.getCivRelationOfCivB(iFromCivID, iCivID) + (float)GameValues.gvDipCallToArms.CALL_TO_ARMS_DENY_RELATION_CHANGE <= (float)GameValues.gvDiplomacy.RELATION_AT_WAR ? (float)(GameValues.gvDiplomacy.RELATION_AT_WAR + 1) : CFG.core.getCivRelationOfCivB(iFromCivID, iCivID) + (float)GameValues.gvDipCallToArms.CALL_TO_ARMS_DENY_RELATION_CHANGE);
        }
    }

    public static final void callToArms_Denied_SendInsult(int iCivID, int iFromCivID, int iValue) {
        GameManager.decreaseRelation(iCivID, iFromCivID, GameValues.gvRelationDecrease.SUSPEND_DIPLOMATIC_RELATIONS_MIN);
    }

    public static final void sendPrepareForWar(int iToCivID, int iFromCivID, int warAgainstCivID, int numOfTurns, int iLeaderCivID) {
        CFG.core.getCiv((int)iToCivID).getCivDiploGD().messageBox.addMessage(new Message_PrepareForWar(iFromCivID, warAgainstCivID, GameCalendar.TURNID + numOfTurns, iLeaderCivID));
        CFG.core.getCiv(iFromCivID).setDiploPoints(CFG.core.getCiv(iFromCivID).getDiploPoints() - GameValues.gvWarPreparations.COST_WAR_PREPARATIONS_DIPLOMACY_POINTS);
        if (!CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.core.getCiv(iFromCivID).addSentMessages(new Civilization_SentMessages(iToCivID, MessageType.PREPARE_FOR_WAR));
        }
    }

    public static final void acceptPrepareForWar(int iLeaderCivID, int iCivID, int iFromCivID, int warAgainstCivID, int numOfTurns) {
        CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_PrepareForWar_Accepted(iCivID, warAgainstCivID));
        CFG.core.getCiv((int)iFromCivID).civGD.civPlans.addNewWarPreps(iLeaderCivID, iFromCivID, warAgainstCivID, numOfTurns);
        CFG.core.getCiv((int)iCivID).civGD.civPlans.addNewWarPreps(iLeaderCivID, iCivID, warAgainstCivID, numOfTurns);
    }

    public static final void declinePrepareForWar(int iLeaderCivID, int iCivID, int iFromCivID, int warAgainstCivID, int numOfTurns) {
        CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_PrepareForWar_Refused(iCivID, warAgainstCivID));
        CFG.core.setCivRelationOfCivB(iCivID, iFromCivID, CFG.core.getCivRelationOfCivB(iCivID, iFromCivID) > (float)GameValues.gvDiplomacy.RELATION_AT_WAR && CFG.core.getCivRelationOfCivB(iCivID, iFromCivID) + (float)WAR_PREPARATIONS_REFUSE_OPINION_CHANGE <= (float)GameValues.gvDiplomacy.RELATION_AT_WAR ? (float)(GameValues.gvDiplomacy.RELATION_AT_WAR + 1) : CFG.core.getCivRelationOfCivB(iCivID, iFromCivID) + (float)WAR_PREPARATIONS_REFUSE_OPINION_CHANGE);
        CFG.core.setCivRelationOfCivB(iFromCivID, iCivID, CFG.core.getCivRelationOfCivB(iFromCivID, iCivID) > (float)GameValues.gvDiplomacy.RELATION_AT_WAR && CFG.core.getCivRelationOfCivB(iFromCivID, iCivID) + (float)WAR_PREPARATIONS_REFUSE_OPINION_CHANGE <= (float)GameValues.gvDiplomacy.RELATION_AT_WAR ? (float)(GameValues.gvDiplomacy.RELATION_AT_WAR + 1) : CFG.core.getCivRelationOfCivB(iFromCivID, iCivID) + (float)WAR_PREPARATIONS_REFUSE_OPINION_CHANGE);
    }

    public static final void sendUnionProposal(int iToCivID, int iFromCivID) {
        CFG.core.getCiv((int)iToCivID).getCivDiploGD().messageBox.addMessage(new Message_Union(iFromCivID, 0));
        CFG.core.getCiv(iFromCivID).setDiploPoints(CFG.core.getCiv(iFromCivID).getDiploPoints() - GameValues.gvDipUnion.COST_OFFER_FORM_UNION_DIPLOMACY_POINTS);
        if (!CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.core.getCiv(iFromCivID).addSentMessages(new Civilization_SentMessages(iToCivID, MessageType.UNION));
        }
    }

    public static final void sendUnionProposalFree(int iToCivID, int iFromCivID) {
        CFG.core.getCiv((int)iToCivID).getCivDiploGD().messageBox.addMessage(new Message_Union(iFromCivID, 0));
        if (!CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.core.getCiv(iFromCivID).addSentMessages(new Civilization_SentMessages(iToCivID, MessageType.UNION));
        }
    }

    public static final void acceptUnionProposal(int iCivID, int iFromCivID) {
        if (iCivID != iFromCivID && CFG.core.getCiv(iCivID).getNumOfProvs() > 0 && CFG.core.getCiv(iFromCivID).getNumOfProvs() > 0) {
            ++CFG.core.getCiv((int)iCivID).civGD.numOfUnions;
            ++CFG.core.getCiv((int)iFromCivID).civGD.numOfUnions;
            CFG.createUnionCivs(iCivID, iFromCivID);
            CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_Union_Accepted(iCivID, 0));
            CFG.core.getCiv((int)iCivID).getCivDiploGD().messageBox.addMessage(new Message_Union_Accepted(iFromCivID, 0));
        }
    }

    public static final void declineUnionProposal(int iCivID, int iFromCivID) {
        CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_Union_Refused(iCivID, 0));
    }

    public static final void sendNonAggressionProposal(int iToCivID, int iFromCivID, int iValue) {
        CFG.core.getCiv((int)iToCivID).getCivDiploGD().messageBox.addMessage(new Message_NonAggressionPact(iFromCivID, iValue));
        CFG.core.getCiv(iFromCivID).setDiploPoints(CFG.core.getCiv(iFromCivID).getDiploPoints() - GameValues.gvDipNonAggression.COST_OFFER_NONAGGRESSION_PACT_DIPLOMACY_POINTS);
        if (!CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.core.getCiv(iFromCivID).addSentMessages(new Civilization_SentMessages(iToCivID, MessageType.NONAGGRESSIONPACT));
        }
    }

    public static final void acceptNonAggressionPact(int iCivID, int iFromCivID, int iValue) {
        CFG.core.setCivNonAggressionPact(iCivID, iFromCivID, iValue);
        if (CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_NonAggressionPact_Accepted(iCivID));
        }
        CFG.historyManager.addHistoryLog(new HistoryLog_SignedNonAggressionPact(iFromCivID, iCivID));
    }

    public static final void declineNonAggressionPact(int iCivID, int iFromCivID, int iValue) {
        if (CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_NonAggressionPact_Denied(iCivID));
        }
    }

    public static final void sendOfferVassalizationProposal(int iToCivID, int iFromCivID, int iValue) {
        CFG.core.getCiv((int)iToCivID).getCivDiploGD().messageBox.addMessage(new Message_OfferVasalization(iFromCivID, iValue));
        CFG.core.getCiv(iFromCivID).setDiploPoints(CFG.core.getCiv(iFromCivID).getDiploPoints() - GameValues.gvDipVassalization.COST_OFFER_VASSALIZATION_DIPLOMACY_POINTS);
        if (!CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.core.getCiv(iFromCivID).addSentMessages(new Civilization_SentMessages(iToCivID, MessageType.OFFERVASALIZATION));
        }
    }

    public static final void acceptOfferVassalization(int iCivID, int iFromCivID, int iValue) {
        int tPlayerID;
        CFG.core.getCiv(iCivID).setPuppetOfCivId(iFromCivID);
        if (CFG.core.getCiv(iFromCivID).getIsPlayer() && CFG.FOG_OF_WAR > 0 && (tPlayerID = CFG.core.getPlayerIDbyCivID(iFromCivID)) >= 0) {
            for (int i = 0; i < CFG.core.getCiv(iCivID).getNumOfProvs(); ++i) {
                CFG.core.getProv(CFG.core.getCiv(iCivID).getProvID(i)).updateFogOfWar(tPlayerID);
            }
        }
        CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_Vassalization_Accepted(iCivID));
        CFG.historyManager.addHistoryLog(new HistoryLog_IsVassal(iFromCivID, iCivID));
    }

    public static final void declineOfferVassalization(int iCivID, int iFromCivID, int iValue) {
        CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_Vassalization_Rejected(iCivID));
    }

    public static final void sendMilitaryAccess_AskProposal(int iToCivID, int iFromCivID, int iValue) {
        if (CFG.core.getCiv(iFromCivID).getDiploPoints() >= GameValues.gvDipMilitaryAccess.COST_OFFER_MILITARY_ACCESS_ASK_DIPLOMACY_POINTS) {
            CFG.core.getCiv((int)iToCivID).getCivDiploGD().messageBox.addMessage(new Message_MilitaryAccess_Ask(iFromCivID, iValue));
            CFG.core.getCiv(iFromCivID).setDiploPoints(CFG.core.getCiv(iFromCivID).getDiploPoints() - GameValues.gvDipMilitaryAccess.COST_OFFER_MILITARY_ACCESS_ASK_DIPLOMACY_POINTS);
            if (!CFG.core.getCiv(iFromCivID).getIsPlayer()) {
                CFG.core.getCiv(iFromCivID).addSentMessages(new Civilization_SentMessages(iToCivID, MessageType.MILITARY_ACCESS_ASK));
            }
        }
    }

    public static final void acceptMilitaryAccess_Ask(int iCivID, int iFromCivID, int iValue) {
        CFG.core.setMilitaryAccess(iFromCivID, iCivID, iValue);
        if (CFG.core.getCivRelationOfCivB(iCivID, iFromCivID) > 0.0f) {
            CFG.core.setCivRelationOfCivB(iCivID, iFromCivID, CFG.core.getCivRelationOfCivB(iCivID, iFromCivID) - Math.max(CFG.core.getCivRelationOfCivB(iCivID, iFromCivID) / 9.325f, 1.127f));
        }
        if (CFG.core.getCivRelationOfCivB(iFromCivID, iCivID) > 0.0f) {
            CFG.core.setCivRelationOfCivB(iFromCivID, iCivID, CFG.core.getCivRelationOfCivB(iFromCivID, iCivID) - Math.max(CFG.core.getCivRelationOfCivB(iFromCivID, iCivID) / 9.325f, 1.127f));
        }
        CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_MilitaryAccess_Ask_Accepted(iCivID));
        CFG.historyManager.addHistoryLog(new HistoryLog_HaveMilitartyAccess(iCivID, iFromCivID));
    }

    public static final void declineMilitaryAccess_Ask(int iCivID, int iFromCivID, int iValue) {
        CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_MilitaryAccess_Ask_Denied(iCivID));
    }

    public static final void sendMilitaryAccess_GiveProposal(int iToCivID, int iFromCivID, int iValue) {
        CFG.core.getCiv((int)iToCivID).getCivDiploGD().messageBox.addMessage(new Message_MilitaryAccess_Give(iFromCivID, iValue));
        CFG.core.getCiv(iFromCivID).setDiploPoints(CFG.core.getCiv(iFromCivID).getDiploPoints() - GameValues.gvDipMilitaryAccess.COST_OFFER_MILITARY_ACCESS_GIVE_DIPLOMACY_POINTS);
        if (!CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.core.getCiv(iFromCivID).addSentMessages(new Civilization_SentMessages(iToCivID, MessageType.MILITARY_ACCESS_GIVE));
        }
    }

    public static final void acceptMilitaryAccess_Give(int iCivID, int iFromCivID, int iValue) {
        CFG.core.setMilitaryAccess(iCivID, iFromCivID, iValue);
        CFG.historyManager.addHistoryLog(new HistoryLog_HaveMilitartyAccess(iFromCivID, iCivID));
    }

    public static final void declineMilitaryAccess_Give(int iCivID, int iFromCivID, int iValue) {
    }

    public static final void sendGuaranteeIndependence_AskProposal(int iToCivID, int iFromCivID, int iValue) {
        CFG.core.getCiv((int)iToCivID).getCivDiploGD().messageBox.addMessage(new Message_Independence_Ask(iFromCivID, iValue));
        CFG.core.getCiv(iFromCivID).setDiploPoints(CFG.core.getCiv(iFromCivID).getDiploPoints() - GameValues.gvDipMilitaryAccess.COST_OFFER_MILITARY_ACCESS_ASK_DIPLOMACY_POINTS);
        if (!CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.core.getCiv(iFromCivID).addSentMessages(new Civilization_SentMessages(iToCivID, MessageType.GUARANTEE_ASK));
        }
    }

    public static final void acceptGuaranteeIndependence_Ask(int iCivID, int iFromCivID, int iValue) {
        CFG.core.setGuarantee(iFromCivID, iCivID, iValue);
        if (CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_Independence_Ask_Accepted(iCivID));
        }
        try {
            CFG.historyManager.addHistoryLog(new HistoryLog_Guarantee(iCivID, iFromCivID));
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static final void declineGuaranteeIndependence_Ask(int iCivID, int iFromCivID, int iValue) {
        if (CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_Independence_Ask_Denied(iCivID));
        }
    }

    public static int getGuaranteeTheirIndependenceSize(int civID) {
        int out = 0;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (i == civID || CFG.core.getCiv(i).getNumOfProvs() <= 0 || CFG.core.getGuarantee(i, civID) <= 0) continue;
            ++out;
        }
        return out;
    }

    public static final void sendDefensivePactProposal(int iToCivID, int iFromCivID, int iValue) {
        CFG.core.getCiv((int)iToCivID).getCivDiploGD().messageBox.addMessage(new Message_DefensivePact(iFromCivID, iValue));
        CFG.core.getCiv(iFromCivID).setDiploPoints(CFG.core.getCiv(iFromCivID).getDiploPoints() - GameValues.gvDipDefensivePact.COST_OFFER_DEFENSIVE_PACT_DIPLOMACY_POINTS);
        if (!CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.core.getCiv(iFromCivID).addSentMessages(new Civilization_SentMessages(iToCivID, MessageType.DEFENSIVEPACT));
        }
    }

    public static void acceptDefensivePact(int iCivID, int iFromCivID, int iValue) {
        CFG.core.setDefensivePact(iCivID, iFromCivID, iValue);
        if (CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_DefensivePact_Accepted(iCivID));
        }
        CFG.historyManager.addHistoryLog(new HistoryLog_SignedDefensivePact(iFromCivID, iCivID));
    }

    public static void declineDefensivePact(int iCivID, int iFromCivID, int iValue) {
        if (CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_DefensivePact_Denied(iCivID));
        }
    }

    public static void sendVolunteerArmy(long armyToSend, int civID, int fromProvinceID, int toProvinceID) {
        try {
            long army = Math.min((long)armyToSend, CFG.core.getProv(fromProvinceID).getArmyCivID1(civID));
            if (army > 0) {
                CFG.core.getProv(fromProvinceID).updateArmy4(civID, CFG.core.getProv(fromProvinceID).getArmyCivID1(civID) - army);
                CFG.core.getProv(toProvinceID).updateArmy4(CFG.core.getProv(toProvinceID).getCivId(), CFG.core.getProv(toProvinceID).getArmyCivID1(CFG.core.getProv(toProvinceID).getCivId()) + army);
                CFG.core.getCiv(civID).updateNumberOfUnits();
                CFG.core.getCiv(CFG.core.getCiv(toProvinceID).getCivId()).updateNumberOfUnits();
                CFG.core.getProv((int)toProvinceID).provinceVolunteerArmySent.add(new Province_VolunteerArmySent(civID, CFG.core.getProv(toProvinceID).getCivId(), (int)army, GameCalendar.TURNID));
                if (CFG.core.getCiv(CFG.core.getProv(toProvinceID).getCivId()).getIsPlayer()) {
                    CFG.core.getCiv((int)CFG.core.getProv((int)toProvinceID).getCivId()).getCivDiploGD().messageBox.addMessage(new Message_VolunteerArmy(civID, army, toProvinceID));
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static void sendLoanRequest(int iToCivID, int iFromCivID, long iGold, int iTurns) {
        if (CFG.core.getCiv(iFromCivID).getLoansFromCivSize() >= GameValues.gvLoan.REQUEST_LOAN_MAX_NUM_OF_LOANS) {
            return;
        }
        if (iGold > 0) {
            CFG.core.getCiv((int)iToCivID).getCivDiploGD().messageBox.addMessage(new Message_LoanRequest(iFromCivID, iGold, iTurns));
            CFG.core.getCiv(iFromCivID).setDiploPoints(CFG.core.getCiv(iFromCivID).getDiploPoints() - GameValues.gvLoan.COST_REQUEST_LOAN);
        }
    }

    public static void acceptLoanRequest(int iCivID, int iFromCivID, int iGold, int iTurns) {
        if (iGold >= 0) {
            CFG.core.getCiv(iCivID).setGold(CFG.core.getCiv(iCivID).getGold() - (long)iGold);
            CFG.core.getCiv(iFromCivID).setGold(CFG.core.getCiv(iFromCivID).getGold() + (long)iGold);
            CFG.core.getCiv(iFromCivID).addLoanFromCiv((int)Math.ceil((float)(iGold + (int)((float)iGold * Loans.takeLoan_InterestRate(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId(), iGold, iTurns) / 100.0f)) / (float)iTurns), iTurns, iCivID);
            if (CFG.core.getCiv(iFromCivID).getIsPlayer()) {
                CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_LoanRequest_Accepted(iCivID, iGold));
            }
        }
    }

    public static void declineLoanRequest(int iCivID, int iFromCivID, int iGold, int iTurns) {
        if (CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_LoanRequest_Refused(iCivID, iGold));
        }
    }

    public static void sendGift(int iToCivID, int iFromCivID, long iValue) {
        if ((double)CFG.core.getCiv(iFromCivID).getGold() * (double)GameValues.gvGift.GIFT_MAX_PERC_OF_TREASURY < (double)iValue) {
            iValue = (long)Math.max(0.0, (double)CFG.core.getCiv(iFromCivID).getGold() * (double)GameValues.gvGift.GIFT_MAX_PERC_OF_TREASURY);
        }
        if (iValue > 0L) {
            CFG.core.getCiv((int)iToCivID).getCivDiploGD().messageBox.addMessage(new Message_Gift(iFromCivID, iValue));
            CFG.core.getCiv(iFromCivID).setGold(CFG.core.getCiv(iFromCivID).getGold() - iValue);
            CFG.core.getCiv(iFromCivID).setDiploPoints(CFG.core.getCiv(iFromCivID).getDiploPoints() - GameValues.gvGift.COST_OFFER_GIFT_DIPLOMACY_POINTS);
            if (!CFG.core.getCiv(iFromCivID).getIsPlayer()) {
                CFG.core.getCiv(iFromCivID).addSentMessages(new Civilization_SentMessages(iToCivID, MessageType.GIFT));
            }
        }
    }

    public static void acceptGift(int iCivID, int iFromCivID, long iValue) {
        if (iValue >= 0L) {
            CFG.core.getCiv(iCivID).setGold(CFG.core.getCiv(iCivID).getGold() + iValue);
            if (CFG.core.getCiv(iFromCivID).getIsPlayer()) {
                CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_Gift_Accepted(iCivID, iValue));
            }
            CFG.core.getCiv(iCivID).addGift_Received(iFromCivID);
        }
    }

    public static void declineGift(int iCivID, int iFromCivID, long iValue) {
        CFG.core.getCiv(iFromCivID).setGold(CFG.core.getCiv(iFromCivID).getGold() + iValue);
        CFG.core.setCivRelationOfCivB(iCivID, iFromCivID, CFG.core.getCivRelationOfCivB(iCivID, iFromCivID) > (float)GameValues.gvDiplomacy.RELATION_AT_WAR && CFG.core.getCivRelationOfCivB(iCivID, iFromCivID) + (float)GameValues.gvGift.GIFT_REFUSE_OPINION_CHANGE <= (float)GameValues.gvDiplomacy.RELATION_AT_WAR ? (float)(GameValues.gvDiplomacy.RELATION_AT_WAR + 1) : CFG.core.getCivRelationOfCivB(iCivID, iFromCivID) + (float)GameValues.gvGift.GIFT_REFUSE_OPINION_CHANGE);
        CFG.core.setCivRelationOfCivB(iFromCivID, iCivID, CFG.core.getCivRelationOfCivB(iFromCivID, iCivID) > (float)GameValues.gvDiplomacy.RELATION_AT_WAR && CFG.core.getCivRelationOfCivB(iFromCivID, iCivID) + (float)GameValues.gvGift.GIFT_REFUSE_OPINION_CHANGE <= (float)GameValues.gvDiplomacy.RELATION_AT_WAR ? (float)(GameValues.gvDiplomacy.RELATION_AT_WAR + 1) : CFG.core.getCivRelationOfCivB(iFromCivID, iCivID) + (float)GameValues.gvGift.GIFT_REFUSE_OPINION_CHANGE);
        if (CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_Gift_Refused(iCivID, iValue));
        }
    }

    public static void sendNukes(int nukesToSend, int civID, int toCivID) {
        try {
            int nukes = Math.min(nukesToSend, CFG.core.getCiv((int)civID).civGD.iNukes);
            if (nukes > 0) {
                CFG.core.getCiv((int)civID).civGD.iNukes = Math.max(0, CFG.core.getCiv((int)civID).civGD.iNukes - nukesToSend);
                CFG.core.getCiv((int)toCivID).civGD.iNukes = Math.max(0, CFG.core.getCiv((int)toCivID).civGD.iNukes + nukesToSend);
                if (CFG.core.getCiv(toCivID).getIsPlayer()) {
                    CFG.core.getCiv((int)toCivID).getCivDiploGD().messageBox.addMessage(new Message_NukeSent(civID, nukes));
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final boolean sendUltimatum(int iToCivID, int iFromCivID, Ultimatum_GameData nUltimatum, long nUnits) {
        if (CFG.core.getCivRelationOfCivB(iToCivID, iFromCivID) > (float)GameValues.gvUltimatum.ULTIMATUM_REQUIRED_RELATIONS) {
            return false;
        }
        if (CFG.core.getCiv(iToCivID).getPuppetOfCiv() == iToCivID || CFG.core.getCiv(iToCivID).getPuppetOfCiv() == iFromCivID) {
            if (CFG.core.getCiv(iFromCivID).getDiploPoints() >= GameValues.gvUltimatum.COST_ULTIMATUM_DIPLOMACY_POINTS) {
                CFG.core.getCiv((int)iToCivID).getCivDiploGD().messageBox.addMessage(new Message_Ultimatum(iFromCivID, nUltimatum, nUnits));
                CFG.core.getCiv(iFromCivID).setDiploPoints(CFG.core.getCiv(iFromCivID).getDiploPoints() - GameValues.gvUltimatum.COST_ULTIMATUM_DIPLOMACY_POINTS);
            } else {
                return false;
            }
        }
        if (!CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.core.getCiv(iFromCivID).addSentMessages(new Civilization_SentMessages(iToCivID, MessageType.ULTIMATUM));
        }
        return true;
    }

    public static final boolean sendUltimatumFree(int iToCivID, int iFromCivID, Ultimatum_GameData nUltimatum, long nUnits) {
        if (CFG.core.getCiv(iToCivID).getPuppetOfCiv() == iToCivID || CFG.core.getCiv(iToCivID).getPuppetOfCiv() == iFromCivID) {
            CFG.core.getCiv((int)iToCivID).getCivDiploGD().messageBox.addMessage(new Message_Ultimatum(iFromCivID, nUltimatum, nUnits));
            CFG.core.getCiv(iFromCivID).setDiploPoints(CFG.core.getCiv(iFromCivID).getDiploPoints() - GameValues.gvUltimatum.COST_ULTIMATUM_DIPLOMACY_POINTS);
        }
        if (!CFG.core.getCiv(iFromCivID).getIsPlayer()) {
            CFG.core.getCiv(iFromCivID).addSentMessages(new Civilization_SentMessages(iToCivID, MessageType.ULTIMATUM));
        }
        return true;
    }

    public static final void acceptUltimatum(int iToCivID, int iFromCivID, Ultimatum_GameData ultimatum) {
        if (CFG.core.getCiv(iFromCivID).getPuppetOfCiv() == iFromCivID || CFG.core.getCiv(iFromCivID).getPuppetOfCiv() == iToCivID) {
            int j;
            int i;
            CFG.core.getCiv(iFromCivID).setVassalLibertyDesire(CFG.core.getCiv(iFromCivID).getVassalLibertyDesire() * GameValues.gvUltimatum.ULTIMATUM_VASSAL_LIBERTY_DESIRE_PERC_INCREASE + GameValues.gvUltimatum.ULTIMATUM_VASSAL_LIBERTY_DESIRE_BASE_INCREASE + (float)CFG.oR.nextInt(GameValues.gvUltimatum.ULTIMATUM_VASSAL_LIBERTY_DESIRE_RANDOM_INCREASE));
            if (ultimatum.demandAnexation) {
                ArrayList<Integer> tempProvinces = new ArrayList<Integer>();
                for (i = 0; i < CFG.core.getCiv(iFromCivID).getNumOfProvs(); ++i) {
                    tempProvinces.add(CFG.core.getCiv(iFromCivID).getProvID(i));
                }
                for (i = 0; i < tempProvinces.size(); ++i) {
                    if (CFG.core.getProv((Integer)tempProvinces.get(i)).getCivId() != iFromCivID || CFG.core.getProv((Integer)tempProvinces.get(i)).getTrueOwnerOfProv() != iFromCivID) continue;
                    long nArmyNewOwnerArmy = CFG.core.getProv((Integer)tempProvinces.get(i)).getArmyCivID1(iToCivID);
                    CFG.core.getProv((Integer)tempProvinces.get(i)).updateArmy4(0);
                    CFG.core.getProv((Integer)tempProvinces.get(i)).updateArmy4(iToCivID, 0);
                    CFG.core.getProv((Integer)tempProvinces.get(i)).setTrueOwnerOfProv(iToCivID);
                    CFG.core.getProv((Integer)tempProvinces.get(i)).setCivId(iToCivID, false);
                    CFG.core.getProv((Integer)tempProvinces.get(i)).setHappi(CFG.core.getProv((Integer)tempProvinces.get(i)).getHappi() * GameValues.gvUltimatum.ANNEXATION_HAPPINESS_CHANGE);
                    CFG.core.getProv((Integer)tempProvinces.get(i)).setRevRisk(CFG.core.getProv((Integer)tempProvinces.get(i)).getRevRisk() + GameValues.gvUltimatum.ANNEXATION_REV_RISK_EXTRA_BASE + (float)CFG.oR.nextInt(GameValues.gvUltimatum.ANNEXATION_REV_RISK_EXTRA_RANDOM_100) / 100.0f);
                    CFG.core.getProv((Integer)tempProvinces.get(i)).updateArmy4(iToCivID, nArmyNewOwnerArmy);
                    for (j = CFG.core.getProv((Integer)tempProvinces.get(i)).getCivsSize() - 1; j >= 0; --j) {
                        if (CFG.core.getCiv(CFG.core.getProv((Integer)tempProvinces.get(i)).getCivId(j)).getPuppetOfCiv() == iToCivID || CFG.core.getCiv(iToCivID).getPuppetOfCiv() == CFG.core.getProv((Integer)tempProvinces.get(i)).getCivId(j) || CFG.core.getCiv(CFG.core.getProv((Integer)tempProvinces.get(i)).getCivId(j)).getAlliance() > 0 && CFG.core.getCiv(CFG.core.getProv((Integer)tempProvinces.get(i)).getCivId(j)).getAlliance() == CFG.core.getCiv(iToCivID).getAlliance() || CFG.core.getMilitaryAccess(CFG.core.getProv((Integer)tempProvinces.get(i)).getCivId(j), iToCivID) > 0) continue;
                        CFG.gameAction.accessLost_MoveArmyToClosetsProvince(CFG.core.getProv((Integer)tempProvinces.get(i)).getCivId(j), (Integer)tempProvinces.get(i));
                    }
                }
                if (CFG.core.getCiv(iFromCivID).getCapitalProvID() >= 0) {
                    CFG.core.getProv(CFG.core.getCiv(iFromCivID).getCapitalProvID()).setIsCapital(false);
                    for (i = 0; i < CFG.core.getProv(CFG.core.getCiv(iFromCivID).getCapitalProvID()).getCitSize(); ++i) {
                        if (CFG.core.getProv(CFG.core.getCiv(iFromCivID).getCapitalProvID()).getCit(i).getCityLevel() != CFG.getEditorCityLevel(0)) continue;
                        CFG.core.getProv(CFG.core.getCiv(iFromCivID).getCapitalProvID()).getCit(i).setCityLevel(CFG.getEditorCityLevel(1));
                    }
                }
                CFG.core.getCiv(iFromCivID).updateNumberOfUnits();
                tempProvinces.clear();
                CFG.core.buildCivilizationsRegions_TextOver(iFromCivID);
                CFG.core.buildCivilizationsRegions_TextOver(iToCivID);
                CFG.core.getCiv(iFromCivID).setPuppetOfCivId(iFromCivID);
                CFG.historyManager.addHistoryLog(new HistoryLog_Annexation(iFromCivID, iToCivID));
            }
            if (ultimatum.demandVasalization) {
                int tPlayerID;
                CFG.core.getCiv(iFromCivID).setPuppetOfCivId(iToCivID);
                if (CFG.core.getCiv(iToCivID).getIsPlayer() && CFG.FOG_OF_WAR > 0 && (tPlayerID = CFG.core.getPlayerIDbyCivID(iToCivID)) >= 0) {
                    for (i = 0; i < CFG.core.getCiv(iFromCivID).getNumOfProvs(); ++i) {
                        CFG.core.getProv(CFG.core.getCiv(iFromCivID).getProvID(i)).updateFogOfWar(tPlayerID);
                    }
                }
                CFG.historyManager.addHistoryLog(new HistoryLog_IsVassal(iToCivID, iFromCivID));
            }
            if (ultimatum.demandChangeOfGovernment && CFG.core.getCiv(iFromCivID).getIdeology() != CFG.core.getCiv(iToCivID).getIdeology()) {
                CFG.core.updateCivilizationIdeology(iFromCivID, CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(iFromCivID).getCivTag()) + CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(iToCivID).getIdeology()).getExtraTag());
            }
            if (ultimatum.demandMilitaryAccess) {
                CFG.core.setMilitaryAccess(iToCivID, iFromCivID, Math.max(CFG.core.getMilitaryAccess(iToCivID, iFromCivID), GameValues.gvDipMilitaryAccess.DIPLOMACY_MAX_NUMBER_OF_TURNS_FOR_MILITARY_ACCESS));
                CFG.historyManager.addHistoryLog(new HistoryLog_HaveMilitartyAccess(iFromCivID, iToCivID));
            }
            if (!ultimatum.demandLiberation.isEmpty()) {
                for (int i2 = 0; i2 < ultimatum.demandLiberation.size(); ++i2) {
                    GameManager.liberateAVassal(iFromCivID, ultimatum.demandLiberation.get(i2));
                    CFG.core.setCivTruce(iFromCivID, ultimatum.demandLiberation.get(i2), GameValues.gvUltimatum.ULTIMATUM_TRUCE_TURNS_DEMAND_LIBERATION);
                }
            }
            if (!ultimatum.demandProvinces.isEmpty()) {
                for (int i3 = 0; i3 < ultimatum.demandProvinces.size(); ++i3) {
                    if (CFG.core.getProv(ultimatum.demandProvinces.get(i3)).getCivId() != iFromCivID || CFG.core.getProv(ultimatum.demandProvinces.get(i3)).getTrueOwnerOfProv() != iFromCivID) continue;
                    ArrayList<Integer> tempCivs = new ArrayList<Integer>();
                    ArrayList<Long> tempArmies = new ArrayList<Long>();
                    for (j = 0; j < CFG.core.getProv(ultimatum.demandProvinces.get(i3)).getCivsSize(); ++j) {
                        tempCivs.add(CFG.core.getProv(ultimatum.demandProvinces.get(i3)).getCivId(j));
                        tempArmies.add(CFG.core.getProv(ultimatum.demandProvinces.get(i3)).getArmyID(j));
                    }
                    long nArmyNewOwnerArmy = CFG.core.getProv(ultimatum.demandProvinces.get(i3)).getArmyCivID1(iToCivID);
                    long nOwnerArmy = CFG.core.getProv(ultimatum.demandProvinces.get(i3)).getArmyID(0);
                    int nOwnerCivID = CFG.core.getProv(ultimatum.demandProvinces.get(i3)).getCivId();
                    CFG.core.getProv(ultimatum.demandProvinces.get(i3)).updateArmy4(0);
                    CFG.core.getProv(ultimatum.demandProvinces.get(i3)).updateArmy4(iToCivID, 0);
                    CFG.core.getProv(ultimatum.demandProvinces.get(i3)).setTrueOwnerOfProv(iToCivID);
                    CFG.core.getProv(ultimatum.demandProvinces.get(i3)).setCivId(iToCivID, false);
                    if (!CFG.core.getProv(ultimatum.demandProvinces.get(i3)).isCapital()) {
                        CFG.core.getProv(ultimatum.demandProvinces.get(i3)).removeCapitalCityIcon();
                    }
                    CFG.core.getProv(ultimatum.demandProvinces.get(i3)).setHappi(CFG.core.getProv(ultimatum.demandProvinces.get(i3)).getHappi() * GameValues.gvUltimatum.ANNEX_PROVINCE_HAPPINESS_CHANGE);
                    CFG.core.getProv(ultimatum.demandProvinces.get(i3)).setRevRisk(CFG.core.getProv(ultimatum.demandProvinces.get(i3)).getRevRisk() + GameValues.gvUltimatum.ANNEX_PROVINCE_RISK_EXTRA_BASE + (float)CFG.oR.nextInt(GameValues.gvUltimatum.ANNEX_PROVINCE_RISK_EXTRA_RANDOM_100) / 100.0f);
                    CFG.core.getProv(ultimatum.demandProvinces.get(i3)).updateArmy4(iToCivID, nArmyNewOwnerArmy);
                    CFG.core.getProv(ultimatum.demandProvinces.get(i3)).updateArmy4(nOwnerCivID, nOwnerArmy);
                    for (int j2 = 0; j2 < tempCivs.size(); ++j2) {
                        if (CFG.core.getCiv((Integer)tempCivs.get(j2)).getPuppetOfCiv() == iToCivID || CFG.core.getCiv(iToCivID).getPuppetOfCiv() == ((Integer)tempCivs.get(j2)).intValue() || CFG.core.getCiv((Integer)tempCivs.get(j2)).getAlliance() > 0 && CFG.core.getCiv((Integer)tempCivs.get(j2)).getAlliance() == CFG.core.getCiv(iToCivID).getAlliance() || CFG.core.getMilitaryAccess((Integer)tempCivs.get(j2), iToCivID) > 0) continue;
                        CFG.gameAction.accessLost_MoveArmyToClosetsProvince((Integer)tempCivs.get(j2), ultimatum.demandProvinces.get(i3), tempArmies.get(j2));
                    }
                }
                CFG.core.buildCivilizationsRegions_TextOver(iFromCivID);
                CFG.core.buildCivilizationsRegions_TextOver(iToCivID);
            }
            CFG.core.setCivTruce(iToCivID, iFromCivID, GameValues.gvUltimatum.ULTIMATUM_TRUCE_TURNS);
            CFG.core.getCiv((int)iToCivID).getCivDiploGD().messageBox.addMessage(new Message_UltimatumAccepted(iFromCivID));
        }
    }

    public static final void refuseUltimatum(int iToCivID, int iFromCivID, Ultimatum_GameData ultimatum) {
        CFG.core.getCiv((int)iToCivID).getCivDiploGD().messageBox.addMessage(new Message_UltimatumRefused(iFromCivID));
    }

    public static final void refuseUltimatum_AcceptWar(int iFromCivID, int iToCivID) {
        CFG.core.declareWar(iFromCivID, iToCivID, false);
    }

    public static final void vassalDeclareIndependence_War(int iFromCivID, int iToCivID) {
        CFG.core.declareWar(iFromCivID, iToCivID, true);
    }

    public static final void vassalDeclareIndependence_Fine(int iFromCivID, int iToCivID) {
        CFG.core.acceptPeaceOffer(iFromCivID, iToCivID, GameValues.gvUltimatum.ULTIMATUM_TRUCE_TURNS);
    }

    public static boolean playerAIPeace_WasSent(int fromCivID, int playerCivID) {
        try {
            int a;
            for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                for (a = CFG.core.getPlayer((int)i).playerGD.playerAIPeace.size() - 1; a >= 0; --a) {
                    if (CFG.core.getPlayer((int)i).playerGD.playerAIPeace.get((int)a).turnID + GameValues.gvInGame.PLAYER_AI_PEACE_PROPOSITION_RETRY_TURNS > GameCalendar.TURNID) continue;
                    CFG.core.getPlayer((int)i).playerGD.playerAIPeace.remove(a);
                }
            }
            int playerID = CFG.core.getPlayerIDbyCivID(playerCivID);
            if (playerID >= 0) {
                for (a = CFG.core.getPlayer((int)playerID).playerGD.playerAIPeace.size() - 1; a >= 0; --a) {
                    if (CFG.core.getPlayer((int)playerID).playerGD.playerAIPeace.get((int)a).iCivID != fromCivID) continue;
                    return true;
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return false;
    }

    public static void playerAIPeace_AddCiv(int fromCivID, int playerCivID) {
        try {
            int playerID = CFG.core.getPlayerIDbyCivID(playerCivID);
            if (playerID >= 0) {
                for (int a = CFG.core.getPlayer((int)playerID).playerGD.playerAIPeace.size() - 1; a >= 0; --a) {
                    if (CFG.core.getPlayer((int)playerID).playerGD.playerAIPeace.get((int)a).iCivID != fromCivID) continue;
                    return;
                }
                CFG.core.getPlayer((int)playerID).playerGD.playerAIPeace.add(new PlayerAIPeace_GameData(fromCivID, GameCalendar.TURNID));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static final void sendPeaceTreaty(boolean toDefenders, int iFromCivID, PeaceTreaty_GameData peaceTreaty_GameData) {
        try {
            int i;
            CFG.peaceTreatyData.preparePeaceTreatyToSend(iFromCivID);
            CFG.core.lPeaceTreaties.add(new PeaceTreaty_GameData_MessageData(peaceTreaty_GameData));
            String peaceTreatyTag = CFG.core.lPeaceTreaties.get((int)(CFG.core.lPeaceTreaties.size() - 1)).PEACE_TREATY_TAG;
            for (i = 0; i < peaceTreaty_GameData.civsDemandsDefenders.size(); ++i) {
                if (peaceTreaty_GameData.civsDemandsDefenders.get((int)i).peaceTreatyAccepted) continue;
                CFG.core.getCiv((int)peaceTreaty_GameData.civsDemandsDefenders.get((int)i).iCivID).getCivDiploGD().messageBox.addMessage(new Message_PeaceTreaty(iFromCivID, peaceTreatyTag));
            }
            for (i = 0; i < peaceTreaty_GameData.civsDemandsAggressors.size(); ++i) {
                if (peaceTreaty_GameData.civsDemandsAggressors.get((int)i).peaceTreatyAccepted) continue;
                CFG.core.getCiv((int)peaceTreaty_GameData.civsDemandsAggressors.get((int)i).iCivID).getCivDiploGD().messageBox.addMessage(new Message_PeaceTreaty(iFromCivID, peaceTreatyTag));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public static void acceptPeaceTreaty(int iCivID, String nTag) {
        GameManager.acceptPeaceTreaty(iCivID, nTag, false);
    }

    public static void acceptPeaceTreaty(int iCivID, String nTag, boolean forcePeace) {
        int i;
        int peaceID = CFG.core.getPeaceTreaty_GameDataID(nTag);
        boolean everyoneAccepted = true;
        PeaceTreaty_GameData peaceTreaty = CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData;
        if (!forcePeace) {
            for (i = 0; i < peaceTreaty.civsDemandsDefenders.size(); ++i) {
                if (iCivID == peaceTreaty.civsDemandsDefenders.get((int)i).iCivID) {
                    peaceTreaty.civsDemandsDefenders.get((int)i).peaceTreatyAccepted = true;
                }
                if (peaceTreaty.civsDemandsDefenders.get((int)i).peaceTreatyAccepted) continue;
                everyoneAccepted = false;
            }
            for (i = 0; i < peaceTreaty.civsDemandsAggressors.size(); ++i) {
                if (iCivID == peaceTreaty.civsDemandsAggressors.get((int)i).iCivID) {
                    peaceTreaty.civsDemandsAggressors.get((int)i).peaceTreatyAccepted = true;
                }
                if (peaceTreaty.civsDemandsAggressors.get((int)i).peaceTreatyAccepted) continue;
                everyoneAccepted = false;
            }
        }
        if (everyoneAccepted) {
            try {
                int nCivNewOwner;
                long tempArmy0;
                long nArmyNewOwner;
                long nArmyNewOwner2;
                long nArmy0;
                int nCivNewOwner2;
                int nCiv0;
                int u;
                boolean zeroProvinces;
                int o;
                int k;
                int i2;
                int tempCiv0;
                int m;
                for (i = 0; i < peaceTreaty.civsDemandsDefenders.size(); ++i) {
                    try {
                        int j;
                        for (j = 0; j < peaceTreaty.civsDemandsDefenders.get((int)i).lDemands.size(); ++j) {
                            CFG.core.getCiv(CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)i).lDemands.get(j)).getCivId()).removePlunder_ProvinceID(peaceTreaty.civsDemandsDefenders.get((int)i).lDemands.get(j));
                            nArmy0 = CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)i).lDemands.get(j)).getArmyID(0);
                            nCiv0 = CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)i).lDemands.get(j)).getCivId();
                            nArmyNewOwner2 = CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)i).lDemands.get(j)).getArmyCivID1(peaceTreaty.civsDemandsDefenders.get((int)i).iCivID);
                            nCivNewOwner2 = peaceTreaty.civsDemandsDefenders.get((int)i).iCivID;
                            CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)i).lDemands.get(j)).updateArmy4(0);
                            CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)i).lDemands.get(j)).updateArmy4(peaceTreaty.civsDemandsDefenders.get((int)i).iCivID, 0);
                            if (CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)i).lDemands.get(j)).getCivId() == peaceTreaty.civsDemandsDefenders.get((int)i).iCivID) {
                                CFG.timelapseManager.addChange(peaceTreaty.civsDemandsDefenders.get((int)i).lDemands.get(j), peaceTreaty.civsDemandsDefenders.get((int)i).iCivID, false);
                            }
                            CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)i).lDemands.get(j)).setTrueOwnerOfProv(peaceTreaty.civsDemandsDefenders.get((int)i).iCivID);
                            CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)i).lDemands.get(j)).setCivId(peaceTreaty.civsDemandsDefenders.get((int)i).iCivID, false, true);
                            if (!CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)i).lDemands.get(j)).isCapital()) {
                                CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)i).lDemands.get(j)).removeCapitalCityIcon();
                            }
                            CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)i).lDemands.get(j)).updateArmy4(nCiv0, nArmy0);
                            CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)i).lDemands.get(j)).updateArmy4(nCivNewOwner2, nArmyNewOwner2);
                        }
                        for (j = 0; j < peaceTreaty.civsDemandsDefenders.get((int)i).lWarReparationsFromCivsID.size(); ++j) {
                            CFG.core.getCiv(peaceTreaty.civsDemandsDefenders.get((int)i).iCivID).addWarReparationsGets(peaceTreaty.civsDemandsDefenders.get((int)i).lWarReparationsFromCivsID.get(j));
                            CFG.core.getCiv(peaceTreaty.civsDemandsDefenders.get((int)i).lWarReparationsFromCivsID.get(j)).addWarReparationsPay(peaceTreaty.civsDemandsDefenders.get((int)i).iCivID);
                        }
                        if (peaceTreaty.civsDemandsDefenders.get((int)i).changeGovernmentTypeToCivID > 0) {
                            try {
                                if (CFG.core.getCiv(peaceTreaty.civsDemandsDefenders.get((int)i).iCivID).getIdeology() != CFG.core.getCiv(peaceTreaty.civsDemandsDefenders.get((int)i).changeGovernmentTypeToCivID).getIdeology()) {
                                    CFG.core.updateCivilizationIdeology(peaceTreaty.civsDemandsDefenders.get((int)i).iCivID, CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(peaceTreaty.civsDemandsDefenders.get((int)i).iCivID).getCivTag()) + CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(peaceTreaty.civsDemandsDefenders.get((int)i).changeGovernmentTypeToCivID).getIdeology()).getExtraTag());
                                }
                            }
                            catch (Exception j2) {
                                // empty catch block
                            }
                        }
                        if (peaceTreaty.civsDemandsDefenders.get((int)i).changeReligionToCivID <= 0 || CFG.core.getCiv(peaceTreaty.civsDemandsDefenders.get((int)i).iCivID).getReligionID() == CFG.core.getCiv(peaceTreaty.civsDemandsDefenders.get((int)i).changeReligionToCivID).getReligionID()) continue;
                        CFG.core.getCiv(peaceTreaty.civsDemandsDefenders.get((int)i).iCivID).setReligionID(CFG.core.getCiv(peaceTreaty.civsDemandsDefenders.get((int)i).changeReligionToCivID).getReligionID());
                        continue;
                    }
                    catch (Exception exr) {
                        CFG.exceptionStack(exr);
                    }
                }
                for (i = 0; i < peaceTreaty.civsDemandsAggressors.size(); ++i) {
                    try {
                        int j;
                        for (j = 0; j < peaceTreaty.civsDemandsAggressors.get((int)i).lDemands.size(); ++j) {
                            CFG.core.getCiv(CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)i).lDemands.get(j)).getCivId()).removePlunder_ProvinceID(peaceTreaty.civsDemandsAggressors.get((int)i).lDemands.get(j));
                            nArmy0 = CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)i).lDemands.get(j)).getArmyID(0);
                            nCiv0 = CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)i).lDemands.get(j)).getCivId();
                            nArmyNewOwner2 = CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)i).lDemands.get(j)).getArmyCivID1(peaceTreaty.civsDemandsAggressors.get((int)i).iCivID);
                            nCivNewOwner2 = peaceTreaty.civsDemandsAggressors.get((int)i).iCivID;
                            CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)i).lDemands.get(j)).updateArmy4(0);
                            CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)i).lDemands.get(j)).updateArmy4(peaceTreaty.civsDemandsAggressors.get((int)i).iCivID, 0);
                            if (CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)i).lDemands.get(j)).getCivId() == peaceTreaty.civsDemandsAggressors.get((int)i).iCivID) {
                                CFG.timelapseManager.addChange(peaceTreaty.civsDemandsAggressors.get((int)i).lDemands.get(j), peaceTreaty.civsDemandsAggressors.get((int)i).iCivID, false);
                            }
                            CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)i).lDemands.get(j)).setTrueOwnerOfProv(peaceTreaty.civsDemandsAggressors.get((int)i).iCivID);
                            CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)i).lDemands.get(j)).setCivId(peaceTreaty.civsDemandsAggressors.get((int)i).iCivID, false, true);
                            if (!CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)i).lDemands.get(j)).isCapital()) {
                                CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)i).lDemands.get(j)).removeCapitalCityIcon();
                            }
                            CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)i).lDemands.get(j)).updateArmy4(nCiv0, nArmy0);
                            CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)i).lDemands.get(j)).updateArmy4(nCivNewOwner2, nArmyNewOwner2);
                        }
                        for (j = 0; j < peaceTreaty.civsDemandsAggressors.get((int)i).lWarReparationsFromCivsID.size(); ++j) {
                            CFG.core.getCiv(peaceTreaty.civsDemandsAggressors.get((int)i).iCivID).addWarReparationsGets(peaceTreaty.civsDemandsAggressors.get((int)i).lWarReparationsFromCivsID.get(j));
                            CFG.core.getCiv(peaceTreaty.civsDemandsAggressors.get((int)i).lWarReparationsFromCivsID.get(j)).addWarReparationsPay(peaceTreaty.civsDemandsAggressors.get((int)i).iCivID);
                        }
                        if (peaceTreaty.civsDemandsAggressors.get((int)i).changeGovernmentTypeToCivID > 0) {
                            try {
                                if (CFG.core.getCiv(peaceTreaty.civsDemandsAggressors.get((int)i).iCivID).getIdeology() != CFG.core.getCiv(peaceTreaty.civsDemandsAggressors.get((int)i).changeGovernmentTypeToCivID).getIdeology()) {
                                    CFG.core.updateCivilizationIdeology(peaceTreaty.civsDemandsAggressors.get((int)i).iCivID, CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(peaceTreaty.civsDemandsAggressors.get((int)i).iCivID).getCivTag()) + CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(peaceTreaty.civsDemandsAggressors.get((int)i).changeGovernmentTypeToCivID).getIdeology()).getExtraTag());
                                }
                            }
                            catch (Exception j3) {
                                // empty catch block
                            }
                        }
                        if (peaceTreaty.civsDemandsAggressors.get((int)i).changeReligionToCivID <= 0 || CFG.core.getCiv(peaceTreaty.civsDemandsAggressors.get((int)i).iCivID).getReligionID() == CFG.core.getCiv(peaceTreaty.civsDemandsAggressors.get((int)i).changeReligionToCivID).getReligionID()) continue;
                        CFG.core.getCiv(peaceTreaty.civsDemandsAggressors.get((int)i).iCivID).setReligionID(CFG.core.getCiv(peaceTreaty.civsDemandsAggressors.get((int)i).changeReligionToCivID).getReligionID());
                        continue;
                    }
                    catch (Exception exr) {
                        CFG.exceptionStack(exr);
                    }
                }
                try {
                    for (i = 0; i < peaceTreaty.civsDemandsDefenders.size(); ++i) {
                        for (int j = 0; j < peaceTreaty.civsDemandsDefenders.get((int)i).lWillVassalizeCivsID.size(); ++j) {
                            CFG.core.getCiv(peaceTreaty.civsDemandsDefenders.get((int)i).lWillVassalizeCivsID.get(j)).setPuppetOfCivId(peaceTreaty.civsDemandsDefenders.get((int)i).iCivID);
                            CFG.core.setCivRelationOfCivB(peaceTreaty.civsDemandsDefenders.get((int)i).lWillVassalizeCivsID.get(j), peaceTreaty.civsDemandsDefenders.get((int)i).iCivID, Math.max(CFG.core.getCivRelationOfCivB(peaceTreaty.civsDemandsDefenders.get((int)i).lWillVassalizeCivsID.get(j), peaceTreaty.civsDemandsDefenders.get((int)i).iCivID), 22.0f));
                            CFG.core.setCivRelationOfCivB(peaceTreaty.civsDemandsDefenders.get((int)i).iCivID, peaceTreaty.civsDemandsDefenders.get((int)i).lWillVassalizeCivsID.get(j), Math.max(CFG.core.getCivRelationOfCivB(peaceTreaty.civsDemandsDefenders.get((int)i).iCivID, peaceTreaty.civsDemandsDefenders.get((int)i).lWillVassalizeCivsID.get(j)), 22.0f));
                            CFG.historyManager.addHistoryLog(new HistoryLog_IsVassal(peaceTreaty.civsDemandsDefenders.get((int)i).iCivID, peaceTreaty.civsDemandsDefenders.get((int)i).lWillVassalizeCivsID.get(j)));
                        }
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                try {
                    for (int i3 = 0; i3 < peaceTreaty.civsDemandsAggressors.size(); ++i3) {
                        for (int j = 0; j < peaceTreaty.civsDemandsAggressors.get((int)i3).lWillVassalizeCivsID.size(); ++j) {
                            CFG.core.getCiv(peaceTreaty.civsDemandsAggressors.get((int)i3).lWillVassalizeCivsID.get(j)).setPuppetOfCivId(peaceTreaty.civsDemandsAggressors.get((int)i3).iCivID);
                            CFG.core.setCivRelationOfCivB(peaceTreaty.civsDemandsAggressors.get((int)i3).lWillVassalizeCivsID.get(j), peaceTreaty.civsDemandsAggressors.get((int)i3).iCivID, Math.max(CFG.core.getCivRelationOfCivB(peaceTreaty.civsDemandsAggressors.get((int)i3).lWillVassalizeCivsID.get(j), peaceTreaty.civsDemandsAggressors.get((int)i3).iCivID), 22.0f));
                            CFG.core.setCivRelationOfCivB(peaceTreaty.civsDemandsAggressors.get((int)i3).iCivID, peaceTreaty.civsDemandsAggressors.get((int)i3).lWillVassalizeCivsID.get(j), Math.max(CFG.core.getCivRelationOfCivB(peaceTreaty.civsDemandsAggressors.get((int)i3).iCivID, peaceTreaty.civsDemandsAggressors.get((int)i3).lWillVassalizeCivsID.get(j)), 22.0f));
                            CFG.historyManager.addHistoryLog(new HistoryLog_IsVassal(peaceTreaty.civsDemandsAggressors.get((int)i3).iCivID, peaceTreaty.civsDemandsAggressors.get((int)i3).lWillVassalizeCivsID.get(j)));
                        }
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                for (i2 = 0; i2 < peaceTreaty.civsDemandsDefenders.size(); ++i2) {
                    try {
                        for (int j = 0; j < peaceTreaty.civsDemandsDefenders.get((int)i2).lReleasableCivs_TakeControl.size(); ++j) {
                            for (k = 0; k < peaceTreaty.civsDemandsAggressors.size(); ++k) {
                                if (peaceTreaty.civsDemandsDefenders.get((int)i2).lReleasableCivs_TakeControl.get((int)j).iFromCivID != peaceTreaty.civsDemandsAggressors.get((int)k).iCivID) continue;
                                for (o = 0; o < peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.size(); ++o) {
                                    if (peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).iCivID != peaceTreaty.civsDemandsDefenders.get((int)i2).lReleasableCivs_TakeControl.get((int)j).iVassalCivID) continue;
                                    zeroProvinces = CFG.core.getCiv(peaceTreaty.civsDemandsDefenders.get((int)i2).lReleasableCivs_TakeControl.get((int)j).iVassalCivID).getNumOfProvs() == 0;
                                    for (u = 0; u < peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.size(); ++u) {
                                        tempArmy0 = CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getArmyID(0);
                                        tempCiv0 = CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivId();
                                        nArmyNewOwner = CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getArmyCivID1(peaceTreaty.civsDemandsDefenders.get((int)i2).iCivID);
                                        nCivNewOwner = peaceTreaty.civsDemandsDefenders.get((int)i2).iCivID;
                                        CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).updateArmy4(0);
                                        CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).updateArmy4(nCivNewOwner, 0);
                                        CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).setTrueOwnerOfProv(peaceTreaty.civsDemandsDefenders.get((int)i2).lReleasableCivs_TakeControl.get((int)j).iVassalCivID);
                                        CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).setCivId(peaceTreaty.civsDemandsDefenders.get((int)i2).lReleasableCivs_TakeControl.get((int)j).iVassalCivID, false, true);
                                        CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).updateArmy4(tempCiv0, tempArmy0);
                                        CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).updateArmy4(nCivNewOwner, nArmyNewOwner);
                                        if (zeroProvinces) {
                                            CFG.core.getCiv(peaceTreaty.civsDemandsDefenders.get((int)i2).lReleasableCivs_TakeControl.get((int)j).iVassalCivID).setPuppetOfCivId(peaceTreaty.civsDemandsDefenders.get((int)i2).iCivID);
                                            CFG.historyManager.addHistoryLog(new HistoryLog_IsVassal(peaceTreaty.civsDemandsDefenders.get((int)i2).iCivID, peaceTreaty.civsDemandsDefenders.get((int)i2).lReleasableCivs_TakeControl.get((int)j).iVassalCivID));
                                            if (CFG.core.getCivRelationOfCivB(peaceTreaty.civsDemandsDefenders.get((int)i2).lReleasableCivs_TakeControl.get((int)j).iVassalCivID, peaceTreaty.civsDemandsDefenders.get((int)i2).iCivID) < GameValues.gvVassal.RELEASED_VASSAL_MIN_OPINION) {
                                                CFG.core.setCivRelationOfCivB(peaceTreaty.civsDemandsDefenders.get((int)i2).lReleasableCivs_TakeControl.get((int)j).iVassalCivID, peaceTreaty.civsDemandsDefenders.get((int)i2).iCivID, GameValues.gvVassal.RELEASED_VASSAL_MIN_OPINION);
                                            }
                                            if (CFG.core.getCivRelationOfCivB(peaceTreaty.civsDemandsDefenders.get((int)i2).iCivID, peaceTreaty.civsDemandsDefenders.get((int)i2).lReleasableCivs_TakeControl.get((int)j).iVassalCivID) < GameValues.gvVassal.RELEASED_VASSAL_MIN_OPINION) {
                                                CFG.core.setCivRelationOfCivB(peaceTreaty.civsDemandsDefenders.get((int)i2).iCivID, peaceTreaty.civsDemandsDefenders.get((int)i2).lReleasableCivs_TakeControl.get((int)j).iVassalCivID, GameValues.gvVassal.RELEASED_VASSAL_MIN_OPINION);
                                            }
                                            zeroProvinces = false;
                                        }
                                        for (m = CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivsSize() - 1; m >= 0; --m) {
                                            if (CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivId(m) == CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivId() || CFG.core.getCiv(CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivId(m)).getPuppetOfCiv() == CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivId() || CFG.core.getCiv(CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivId()).getPuppetOfCiv() == CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivId(m) || CFG.core.getCiv(CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivId(m)).getAlliance() > 0 && CFG.core.getCiv(CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivId(m)).getAlliance() == CFG.core.getCiv(CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivId()).getAlliance()) continue;
                                            CFG.gameAction.accessLost_MoveArmyToClosetsProvince(CFG.core.getProv(peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivId(m), peaceTreaty.civsDemandsAggressors.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u));
                                        }
                                    }
                                }
                            }
                        }
                        continue;
                    }
                    catch (Exception exr) {
                        CFG.exceptionStack(exr);
                    }
                }
                for (i2 = 0; i2 < peaceTreaty.civsDemandsAggressors.size(); ++i2) {
                    try {
                        for (int j = 0; j < peaceTreaty.civsDemandsAggressors.get((int)i2).lReleasableCivs_TakeControl.size(); ++j) {
                            for (k = 0; k < peaceTreaty.civsDemandsDefenders.size(); ++k) {
                                if (peaceTreaty.civsDemandsAggressors.get((int)i2).lReleasableCivs_TakeControl.get((int)j).iFromCivID != peaceTreaty.civsDemandsDefenders.get((int)k).iCivID) continue;
                                for (o = 0; o < peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.size(); ++o) {
                                    if (peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).iCivID != peaceTreaty.civsDemandsAggressors.get((int)i2).lReleasableCivs_TakeControl.get((int)j).iVassalCivID) continue;
                                    zeroProvinces = CFG.core.getCiv(peaceTreaty.civsDemandsAggressors.get((int)i2).lReleasableCivs_TakeControl.get((int)j).iVassalCivID).getNumOfProvs() == 0;
                                    for (u = 0; u < peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.size(); ++u) {
                                        tempArmy0 = CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getArmyID(0);
                                        tempCiv0 = CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivId();
                                        nArmyNewOwner = CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getArmyCivID1(peaceTreaty.civsDemandsAggressors.get((int)i2).iCivID);
                                        nCivNewOwner = peaceTreaty.civsDemandsAggressors.get((int)i2).iCivID;
                                        CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).updateArmy4(0);
                                        CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).updateArmy4(nCivNewOwner, 0);
                                        CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).setTrueOwnerOfProv(peaceTreaty.civsDemandsAggressors.get((int)i2).lReleasableCivs_TakeControl.get((int)j).iVassalCivID);
                                        CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).setCivId(peaceTreaty.civsDemandsAggressors.get((int)i2).lReleasableCivs_TakeControl.get((int)j).iVassalCivID, false, true);
                                        CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).updateArmy4(tempCiv0, tempArmy0);
                                        CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).updateArmy4(nCivNewOwner, nArmyNewOwner);
                                        if (zeroProvinces) {
                                            CFG.core.getCiv(peaceTreaty.civsDemandsAggressors.get((int)i2).lReleasableCivs_TakeControl.get((int)j).iVassalCivID).setPuppetOfCivId(peaceTreaty.civsDemandsAggressors.get((int)i2).iCivID);
                                            CFG.historyManager.addHistoryLog(new HistoryLog_IsVassal(peaceTreaty.civsDemandsAggressors.get((int)i2).iCivID, peaceTreaty.civsDemandsAggressors.get((int)i2).lReleasableCivs_TakeControl.get((int)j).iVassalCivID));
                                            if (CFG.core.getCivRelationOfCivB(peaceTreaty.civsDemandsAggressors.get((int)i2).lReleasableCivs_TakeControl.get((int)j).iVassalCivID, peaceTreaty.civsDemandsAggressors.get((int)i2).iCivID) < GameValues.gvVassal.RELEASED_VASSAL_MIN_OPINION) {
                                                CFG.core.setCivRelationOfCivB(peaceTreaty.civsDemandsAggressors.get((int)i2).lReleasableCivs_TakeControl.get((int)j).iVassalCivID, peaceTreaty.civsDemandsAggressors.get((int)i2).iCivID, GameValues.gvVassal.RELEASED_VASSAL_MIN_OPINION);
                                            }
                                            if (CFG.core.getCivRelationOfCivB(peaceTreaty.civsDemandsAggressors.get((int)i2).iCivID, peaceTreaty.civsDemandsAggressors.get((int)i2).lReleasableCivs_TakeControl.get((int)j).iVassalCivID) < GameValues.gvVassal.RELEASED_VASSAL_MIN_OPINION) {
                                                CFG.core.setCivRelationOfCivB(peaceTreaty.civsDemandsAggressors.get((int)i2).iCivID, peaceTreaty.civsDemandsAggressors.get((int)i2).lReleasableCivs_TakeControl.get((int)j).iVassalCivID, GameValues.gvVassal.RELEASED_VASSAL_MIN_OPINION);
                                            }
                                            zeroProvinces = false;
                                        }
                                        for (m = CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivsSize() - 1; m >= 0; --m) {
                                            if (CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivId(m) == CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivId() || CFG.core.getCiv(CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivId(m)).getPuppetOfCiv() == CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivId() || CFG.core.getCiv(CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivId()).getPuppetOfCiv() == CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivId(m) || CFG.core.getCiv(CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivId(m)).getAlliance() > 0 && CFG.core.getCiv(CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivId(m)).getAlliance() == CFG.core.getCiv(CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivId()).getAlliance()) continue;
                                            CFG.gameAction.accessLost_MoveArmyToClosetsProvince(CFG.core.getProv(peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u)).getCivId(m), peaceTreaty.civsDemandsDefenders.get((int)k).lReleasableCivs.get((int)o).lProvinces.get(u));
                                        }
                                    }
                                }
                            }
                        }
                        continue;
                    }
                    catch (Exception exr) {
                        CFG.exceptionStack(exr);
                    }
                }
                try {
                    for (i2 = 0; i2 < peaceTreaty.civsDemandsDefenders.size(); ++i2) {
                        for (int j = 0; j < peaceTreaty.civsDemandsAggressors.size(); ++j) {
                            if (CFG.core.getCivsAtWar(peaceTreaty.civsDemandsDefenders.get((int)i2).iCivID, peaceTreaty.civsDemandsAggressors.get((int)j).iCivID)) {
                                CFG.core.acceptPeaceOffer(peaceTreaty.civsDemandsDefenders.get((int)i2).iCivID, peaceTreaty.civsDemandsAggressors.get((int)j).iCivID, peaceTreaty.TRUCE_LENGTH + 1);
                                if (CFG.core.getMilitaryAccess(peaceTreaty.civsDemandsDefenders.get((int)i2).iCivID, peaceTreaty.civsDemandsAggressors.get((int)j).iCivID) <= 0 && CFG.core.getCiv(peaceTreaty.civsDemandsDefenders.get((int)i2).iCivID).getPuppetOfCiv() != peaceTreaty.civsDemandsAggressors.get((int)j).iCivID && CFG.core.getCiv(peaceTreaty.civsDemandsAggressors.get((int)j).iCivID).getPuppetOfCiv() != peaceTreaty.civsDemandsDefenders.get((int)i2).iCivID) {
                                    CFG.gameAction.accessLost_UpdateArmies(peaceTreaty.civsDemandsDefenders.get((int)i2).iCivID, peaceTreaty.civsDemandsAggressors.get((int)j).iCivID);
                                }
                                if (CFG.core.getMilitaryAccess(peaceTreaty.civsDemandsAggressors.get((int)j).iCivID, peaceTreaty.civsDemandsDefenders.get((int)i2).iCivID) > 0 || CFG.core.getCiv(peaceTreaty.civsDemandsDefenders.get((int)i2).iCivID).getPuppetOfCiv() == peaceTreaty.civsDemandsAggressors.get((int)j).iCivID || CFG.core.getCiv(peaceTreaty.civsDemandsAggressors.get((int)j).iCivID).getPuppetOfCiv() == peaceTreaty.civsDemandsDefenders.get((int)i2).iCivID) continue;
                                CFG.gameAction.accessLost_UpdateArmies(peaceTreaty.civsDemandsAggressors.get((int)j).iCivID, peaceTreaty.civsDemandsDefenders.get((int)i2).iCivID);
                                continue;
                            }
                            if (CFG.core.getCiv(peaceTreaty.civsDemandsDefenders.get((int)i2).iCivID).getPuppetOfCiv() != peaceTreaty.civsDemandsAggressors.get((int)j).iCivID && CFG.core.getCiv(peaceTreaty.civsDemandsAggressors.get((int)j).iCivID).getPuppetOfCiv() != peaceTreaty.civsDemandsDefenders.get((int)i2).iCivID) continue;
                            CFG.core.acceptPeaceOffer(peaceTreaty.civsDemandsDefenders.get((int)i2).iCivID, peaceTreaty.civsDemandsAggressors.get((int)j).iCivID, peaceTreaty.TRUCE_LENGTH + 1);
                        }
                    }
                }
                catch (Exception exr) {
                    CFG.exceptionStack(exr);
                }
                try {
                    for (int j = 0; j < peaceTreaty.civsDemandsDefenders.size(); ++j) {
                        if (CFG.core.getCiv(peaceTreaty.civsDemandsDefenders.get((int)j).iCivID).getNumOfProvs() != 0) continue;
                        for (int i4 = 1; i4 < CFG.core.getCivsSize(); ++i4) {
                            if (CFG.core.getCiv(i4).getPuppetOfCiv() != peaceTreaty.civsDemandsDefenders.get((int)j).iCivID) continue;
                            CFG.core.getCiv(i4).setPuppetOfCivId(i4);
                        }
                        if (!CFG.hreMgr.getHRE().getIsElector(peaceTreaty.civsDemandsDefenders.get((int)j).iCivID)) continue;
                        CFG.hreMgr.getHRE().removeElector(peaceTreaty.civsDemandsDefenders.get((int)j).iCivID);
                        CFG.hreMgr.getHRE().addStrongestPrinceAsElector();
                    }
                }
                catch (Exception exr) {
                    CFG.exceptionStack(exr);
                }
                try {
                    for (int j = 0; j < peaceTreaty.civsDemandsAggressors.size(); ++j) {
                        if (CFG.core.getCiv(peaceTreaty.civsDemandsAggressors.get((int)j).iCivID).getNumOfProvs() != 0) continue;
                        for (int i5 = 1; i5 < CFG.core.getCivsSize(); ++i5) {
                            if (CFG.core.getCiv(i5).getPuppetOfCiv() == peaceTreaty.civsDemandsAggressors.get((int)j).iCivID) {
                                CFG.core.getCiv(i5).setPuppetOfCivId(i5);
                            }
                            if (!CFG.hreMgr.getHRE().getIsElector(peaceTreaty.civsDemandsAggressors.get((int)j).iCivID)) continue;
                            CFG.hreMgr.getHRE().removeElector(peaceTreaty.civsDemandsAggressors.get((int)j).iCivID);
                            CFG.hreMgr.getHRE().addStrongestPrinceAsElector();
                        }
                    }
                }
                catch (Exception exr) {
                    CFG.exceptionStack(exr);
                }
                try {
                    for (int i6 = 0; i6 < peaceTreaty.civsDataDefenders.size(); ++i6) {
                        Core.addSimpleTask(new Core.SimpleTask("buildCivilizationRegions" + peaceTreaty.civsDataDefenders.get((int)i6).iCivID, peaceTreaty.civsDataDefenders.get((int)i6).iCivID){

                            @Override
                            public void update() {
                                try {
                                    CFG.core.buildCivilizationRegions(this.id);
                                }
                                catch (Exception exception) {
                                    // empty catch block
                                }
                            }
                        });
                    }
                }
                catch (Exception exr) {
                    CFG.exceptionStack(exr);
                }
                try {
                    for (int i7 = 0; i7 < peaceTreaty.civsDataAggressors.size(); ++i7) {
                        Core.addSimpleTask(new Core.SimpleTask("buildCivilizationRegions" + peaceTreaty.civsDataAggressors.get((int)i7).iCivID, peaceTreaty.civsDataAggressors.get((int)i7).iCivID){

                            @Override
                            public void update() {
                                try {
                                    CFG.core.buildCivilizationRegions(this.id);
                                }
                                catch (Exception exception) {
                                    // empty catch block
                                }
                            }
                        });
                    }
                }
                catch (Exception exr) {
                    CFG.exceptionStack(exr);
                }
                try {
                    int i8;
                    for (i8 = 0; i8 < peaceTreaty.civsDataDefenders.size(); ++i8) {
                        if (CFG.core.getCiv(peaceTreaty.civsDataDefenders.get((int)i8).iCivID).getNumOfProvs() != 0) continue;
                        for (int z = CFG.core.getCiv(peaceTreaty.civsDataDefenders.get((int)i8).iCivID).getArmyInAnotherProvinceSize() - 1; z >= 0; --z) {
                            CFG.core.getProv(CFG.core.getCiv(peaceTreaty.civsDataDefenders.get((int)i8).iCivID).getArmyInAnotherProviP(z)).updateArmy4(peaceTreaty.civsDataDefenders.get((int)i8).iCivID, 0);
                        }
                        CFG.core.getCiv(peaceTreaty.civsDataDefenders.get((int)i8).iCivID).setNumberOfUnits(0);
                    }
                    for (i8 = 0; i8 < peaceTreaty.civsDataAggressors.size(); ++i8) {
                        if (CFG.core.getCiv(peaceTreaty.civsDataAggressors.get((int)i8).iCivID).getNumOfProvs() != 0) continue;
                        for (int z = CFG.core.getCiv(peaceTreaty.civsDataAggressors.get((int)i8).iCivID).getArmyInAnotherProvinceSize() - 1; z >= 0; --z) {
                            CFG.core.getProv(CFG.core.getCiv(peaceTreaty.civsDataAggressors.get((int)i8).iCivID).getArmyInAnotherProviP(z)).updateArmy4(peaceTreaty.civsDataAggressors.get((int)i8).iCivID, 0);
                        }
                        CFG.core.getCiv(peaceTreaty.civsDataAggressors.get((int)i8).iCivID).setNumberOfUnits(0);
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                int tWarID = -1;
                try {
                    for (int i9 = 0; i9 < CFG.core.getWarsSize(); ++i9) {
                        if (!CFG.core.getWar((int)i9).WAR_TAG.equals(peaceTreaty.WAR_TAG)) continue;
                        tWarID = i9;
                        break;
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                try {
                    if (tWarID >= 0) {
                        int i10;
                        boolean everyoneAtPeace = true;
                        block71: for (i10 = 0; i10 < CFG.core.getWar(tWarID).getDefendersSize(); ++i10) {
                            for (int j = 0; j < CFG.core.getWar(tWarID).getAggressorsSize(); ++j) {
                                if (!CFG.core.getCivsAtWar(CFG.core.getWar(tWarID).getDefenderID(i10).getCivID(), CFG.core.getWar(tWarID).getAggressorID(j).getCivID())) continue;
                                everyoneAtPeace = false;
                                i10 = CFG.core.getWar(tWarID).getDefendersSize();
                                continue block71;
                            }
                        }
                        if (everyoneAtPeace) {
                            CFG.core.removeWarData(tWarID);
                            if (CFG.menus.getVisibleInGame_WarDetails()) {
                                CFG.menus.setVisibleInGame_WarDetails(false);
                            }
                        } else {
                            int j;
                            boolean isAtPeace;
                            for (i10 = CFG.core.getWar(tWarID).getDefendersSize() - 1; i10 >= 0; --i10) {
                                isAtPeace = true;
                                for (j = 0; j < CFG.core.getWar(tWarID).getAggressorsSize(); ++j) {
                                    if (!CFG.core.getCivsAtWar(CFG.core.getWar(tWarID).getDefenderID(i10).getCivID(), CFG.core.getWar(tWarID).getAggressorID(j).getCivID())) continue;
                                    isAtPeace = false;
                                    break;
                                }
                                if (!isAtPeace) continue;
                                CFG.core.getWar(tWarID).removeDefender(CFG.core.getWar(tWarID).getDefenderID(i10).getCivID());
                            }
                            for (i10 = CFG.core.getWar(tWarID).getAggressorsSize() - 1; i10 >= 0; --i10) {
                                isAtPeace = true;
                                for (j = 0; j < CFG.core.getWar(tWarID).getDefendersSize(); ++j) {
                                    if (!CFG.core.getCivsAtWar(CFG.core.getWar(tWarID).getDefenderID(j).getCivID(), CFG.core.getWar(tWarID).getAggressorID(i10).getCivID())) continue;
                                    isAtPeace = false;
                                    break;
                                }
                                if (!isAtPeace) continue;
                                CFG.core.getWar(tWarID).removeAggressor(CFG.core.getWar(tWarID).getAggressorID(i10).getCivID());
                            }
                            if (CFG.core.getWar(tWarID).getDefendersSize() == 0 || CFG.core.getWar(tWarID).getAggressorsSize() == 0) {
                                CFG.core.removeWarData(tWarID);
                                if (CFG.menus.getVisibleInGame_WarDetails()) {
                                    CFG.menus.setVisibleInGame_WarDetails(false);
                                }
                            }
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
            PeaceTreaty_GameData peaceGD = CFG.core.lPeaceTreaties.get(peaceID).peaceTreaty_GameData;
            CFG.core.lPeaceTreaties.remove(peaceID);
            for (int k_Agg = 0; k_Agg < peaceGD.civsDataAggressors.size(); k_Agg++) {
                int cID = peaceGD.civsDataAggressors.get(k_Agg).iCivID;
                if (cID > 0 && !CFG.core.getCiv(cID).isAtWarC()) {
                    CFG.core.getCiv(cID).civGD.iLastWarTurnID = GameCalendar.TURNID;
                }
            }
            for (int k_Def = 0; k_Def < peaceGD.civsDataDefenders.size(); k_Def++) {
                int cID = peaceGD.civsDataDefenders.get(k_Def).iCivID;
                if (cID > 0 && !CFG.core.getCiv(cID).isAtWarC()) {
                    CFG.core.getCiv(cID).civGD.iLastWarTurnID = GameCalendar.TURNID;
                }
            }
            return;
        }
    }

    public static final void declinePeaceTreaty(int iCivID, String nTag) {
        int i;
        int peaceID = CFG.core.getPeaceTreaty_GameDataID(nTag);
        if (peaceID >= 0 && peaceID < CFG.core.lPeaceTreaties.size()) {
            for (i = 0; i < CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsAggressors.size(); ++i) {
                if (!CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsAggressors.get((int)i).peaceTreatyAccepted) continue;
                CFG.core.getCiv((int)CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsAggressors.get((int)i).iCivID).getCivDiploGD().messageBox.addMessage(new Message_PeaceTreaty_Rejected(iCivID));
            }
            for (i = 0; i < CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsDefenders.size(); ++i) {
                if (!CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsDefenders.get((int)i).peaceTreatyAccepted) continue;
                CFG.core.getCiv((int)CFG.core.lPeaceTreaties.get((int)peaceID).peaceTreaty_GameData.civsDemandsDefenders.get((int)i).iCivID).getCivDiploGD().messageBox.addMessage(new Message_PeaceTreaty_Rejected(iCivID));
            }
            CFG.core.lPeaceTreaties.remove(peaceID);
        }
    }

    public static final boolean sendTradeRequest(int iToCivID, int iFromCivID, TradeRequest_GameData tradeRequest) {
        if (CFG.SANDBOX_MODE || CFG.core.getCiv(iFromCivID).getDiploPoints() >= GameValues.gvTrade.COST_OFFER_TRADE_REQUEST_DIPLOMACY_POINTS) {
            if (CFG.SANDBOX_MODE && !CFG.core.getCiv(iToCivID).getIsPlayer()) {
                GameManager.acceptTradeRequest(iToCivID, iFromCivID, tradeRequest);
                CFG.core.getCiv(iFromCivID).setDiploPoints(CFG.core.getCiv(iFromCivID).getDiploPoints() - GameValues.gvTrade.COST_OFFER_TRADE_REQUEST_DIPLOMACY_POINTS);
                return true;
            }
            CFG.core.getCiv((int)iToCivID).getCivDiploGD().messageBox.addMessage(new Message_TradeRequest(iFromCivID, tradeRequest));
            CFG.core.getCiv(iFromCivID).setDiploPoints(CFG.core.getCiv(iFromCivID).getDiploPoints() - GameValues.gvTrade.COST_OFFER_TRADE_REQUEST_DIPLOMACY_POINTS);
            if (!CFG.core.getCiv(iFromCivID).getIsPlayer()) {
                CFG.core.getCiv(iFromCivID).addSentMessages(new Civilization_SentMessages(iToCivID, MessageType.TRADE_REQUEST));
            }
            return true;
        }
        return false;
    }

    private static void addTradeWarTarget(List<Integer> out, int actorCivID, int partnerCivID, int targetCivID) {
        if (targetCivID <= 0 || targetCivID == actorCivID || targetCivID == partnerCivID || CFG.core.getCiv(targetCivID).getNumOfProvs() <= 0 || out.contains(targetCivID)) {
            return;
        }
        out.add(targetCivID);
    }

    private static List<Integer> getTradeCoalitionTargets(List<Integer> selectedTargets, boolean fightAllNeighbors, int neighborSourceCivID, int actorCivID, int partnerCivID) {
        List<Integer> out = new ArrayList<Integer>();
        for (int i = 0; i < selectedTargets.size(); ++i) {
            GameManager.addTradeWarTarget(out, actorCivID, partnerCivID, selectedTargets.get(i));
        }
        if (fightAllNeighbors && neighborSourceCivID > 0) {
            for (int i = 0; i < CFG.core.getCiv(neighborSourceCivID).civNeighbors.civsSize; ++i) {
                GameManager.addTradeWarTarget(out, actorCivID, partnerCivID, CFG.core.getCiv(neighborSourceCivID).civNeighbors.civs.get(i).civID);
            }
        }
        return out;
    }

    private static void applyTradeRequestWarTargets(int actorCivID, int partnerCivID, List<Integer> declareTargets, List<Integer> coalitionTargets) {
        List<Integer> allTargets = new ArrayList<Integer>();
        for (int i = 0; i < declareTargets.size(); ++i) {
            GameManager.addTradeWarTarget(allTargets, actorCivID, partnerCivID, declareTargets.get(i));
        }
        for (int i = 0; i < coalitionTargets.size(); ++i) {
            GameManager.addTradeWarTarget(allTargets, actorCivID, partnerCivID, coalitionTargets.get(i));
        }
        if (allTargets.isEmpty()) {
            return;
        }
        int warID = -1;
        int primaryTarget = -1;
        for (int i = 0; i < allTargets.size() && warID < 0; ++i) {
            warID = CFG.core.getWarID(actorCivID, allTargets.get(i));
            if (warID >= 0) {
                primaryTarget = allTargets.get(i);
            }
        }
        for (int i = 0; i < allTargets.size() && warID < 0; ++i) {
            CFG.core.declareWar(actorCivID, allTargets.get(i), false);
            warID = CFG.core.getWarID(actorCivID, allTargets.get(i));
            if (warID >= 0) {
                primaryTarget = allTargets.get(i);
            }
        }
        if (warID < 0 || primaryTarget < 0) {
            return;
        }
        if (!coalitionTargets.isEmpty() && partnerCivID > 0 && partnerCivID != actorCivID && !CFG.core.getCivsAtWar(partnerCivID, primaryTarget)) {
            CFG.core.joinWar(partnerCivID, primaryTarget, warID);
        }
        boolean actorIsAggressor = CFG.core.getWar(warID).getIsAggressor(actorCivID);
        for (int i = 0; i < allTargets.size(); ++i) {
            int targetCivID = allTargets.get(i);
            if (!CFG.core.getCivsAtWar(actorCivID, targetCivID)) {
                CFG.core.joinWar(targetCivID, actorCivID, warID);
                continue;
            }
            if (CFG.core.getWar(warID).getIsAggressor(targetCivID) || CFG.core.getWar(warID).getIsDefender(targetCivID)) {
                continue;
            }
            if (actorIsAggressor) {
                CFG.core.getWar(warID).addDefender(targetCivID);
            } else {
                CFG.core.getWar(warID).addAggressor(targetCivID);
            }
            CFG.core.invalidateWarCache();
        }
    }

    public static int declareWarInWarGroup(int actorCivID, int targetCivID, int warID, boolean forceWar) {
        if (actorCivID == 0 || targetCivID == 0 || actorCivID == targetCivID) {
            return warID;
        }
        if (warID < 0 || warID >= CFG.core.getWarsSize() || !CFG.core.getWar(warID).getIsAggressor(actorCivID) && !CFG.core.getWar(warID).getIsDefender(actorCivID)) {
            CFG.core.declareWar(actorCivID, targetCivID, forceWar);
            return CFG.core.getWarID(actorCivID, targetCivID);
        }
        if (CFG.core.getWar(warID).getIsAggressor(targetCivID) || CFG.core.getWar(warID).getIsDefender(targetCivID) || CFG.core.getCivsAtWar(actorCivID, targetCivID)) {
            return warID;
        }
        if (!CFG.SANDBOX_MODE && CFG.core.getCivTruce(actorCivID, targetCivID) > 0) {
            return warID;
        }
        if (!CFG.SANDBOX_MODE && !forceWar && !CFG.core.canDeclareWar_TribalColonize_NeedsToBorder(actorCivID, targetCivID)) {
            return warID;
        }
        CFG.core.joinWar(targetCivID, actorCivID, warID);
        return CFG.core.getWarID(actorCivID, targetCivID) >= 0 ? CFG.core.getWarID(actorCivID, targetCivID) : warID;
    }

    public static final void acceptTradeRequest(int iCivID, int iFromCivID, TradeRequest_GameData tradeRequest) {
        int j;
        ArrayList<Integer> tempCivsLostAccess;
        long tempArmyNewOwner;
        int tempCiv0;
        long tempArmy0;
        int i;
        if (tradeRequest.listLEFT.militaryAccess) {
            CFG.core.setMilitaryAccess(iCivID, iFromCivID, GameValues.gvDipMilitaryAccess.DIPLOMACY_MAX_NUMBER_OF_TURNS_FOR_MILITARY_ACCESS);
            CFG.historyManager.addHistoryLog(new HistoryLog_HaveMilitartyAccess(iFromCivID, iCivID));
        }
        if (tradeRequest.listRight.militaryAccess) {
            CFG.core.setMilitaryAccess(iFromCivID, iCivID, GameValues.gvDipMilitaryAccess.DIPLOMACY_MAX_NUMBER_OF_TURNS_FOR_MILITARY_ACCESS);
            CFG.historyManager.addHistoryLog(new HistoryLog_HaveMilitartyAccess(iCivID, iFromCivID));
        }
        if (tradeRequest.listLEFT.iGold > 0) {
            CFG.core.getCiv(iFromCivID).setGold(CFG.core.getCiv(iFromCivID).getGold() - (long)tradeRequest.listLEFT.iGold);
            CFG.core.getCiv(iCivID).setGold(CFG.core.getCiv(iCivID).getGold() + (long)tradeRequest.listLEFT.iGold);
        }
        if (tradeRequest.listLEFT.lProvinces.size() > 0) {
            for (i = 0; i < tradeRequest.listLEFT.lProvinces.size(); ++i) {
                if (CFG.core.getProv(tradeRequest.listLEFT.lProvinces.get(i)).getCivId() != iFromCivID || CFG.core.getProv(tradeRequest.listLEFT.lProvinces.get(i)).getTrueOwnerOfProv() != iFromCivID) continue;
                tempArmy0 = CFG.core.getProv(tradeRequest.listLEFT.lProvinces.get(i)).getArmyID(0);
                tempCiv0 = CFG.core.getProv(tradeRequest.listLEFT.lProvinces.get(i)).getCivId();
                tempArmyNewOwner = CFG.core.getProv(tradeRequest.listLEFT.lProvinces.get(i)).getArmyCivID1((int)iCivID);
                CFG.core.getProv(tradeRequest.listLEFT.lProvinces.get(i)).updateArmy4(0);
                CFG.core.getProv(tradeRequest.listLEFT.lProvinces.get(i)).setTrueOwnerOfProv(iCivID);
                CFG.core.getProv(tradeRequest.listLEFT.lProvinces.get(i)).setCivId(iCivID, false);
                CFG.core.getProv(tradeRequest.listLEFT.lProvinces.get(i)).updateArmy4(tempCiv0, tempArmy0);
                CFG.core.getProv(tradeRequest.listLEFT.lProvinces.get(i)).updateArmy4(iCivID, tempArmyNewOwner);
                tempCivsLostAccess = new ArrayList<Integer>();
                for (j = 0; j < CFG.core.getProv(tradeRequest.listLEFT.lProvinces.get(i)).getCivsSize(); ++j) {
                    tempCivsLostAccess.add(CFG.core.getProv(tradeRequest.listLEFT.lProvinces.get(i)).getCivId(j));
                }
                for (j = 0; j < tempCivsLostAccess.size(); ++j) {
                    if (CFG.core.getCiv((Integer)tempCivsLostAccess.get(j)).getPuppetOfCiv() == iCivID || CFG.core.getCiv(iCivID).getPuppetOfCiv() == ((Integer)tempCivsLostAccess.get(j)).intValue() || CFG.core.getCiv((Integer)tempCivsLostAccess.get(j)).getAlliance() > 0 && CFG.core.getCiv((Integer)tempCivsLostAccess.get(j)).getAlliance() == CFG.core.getCiv(iCivID).getAlliance() || CFG.core.getMilitaryAccess((Integer)tempCivsLostAccess.get(j), iCivID) > 0) continue;
                    CFG.gameAction.accessLost_MoveArmyToClosetsProvince((Integer)tempCivsLostAccess.get(j), tradeRequest.listLEFT.lProvinces.get(i));
                }
                if (!CFG.core.getProv(tradeRequest.listLEFT.lProvinces.get(i)).isCapital()) {
                    CFG.core.getProv(tradeRequest.listLEFT.lProvinces.get(i)).removeCapitalCityIcon();
                }
                CFG.core.getProv(tradeRequest.listLEFT.lProvinces.get(i)).getCores().removeCore(tradeRequest.iCivLEFT);
            }
            CFG.core.buildCivilizationsRegions_TextOver(iFromCivID);
            CFG.core.buildCivilizationsRegions_TextOver(iCivID);
        }
        java.util.List<Integer> lCoalitionTargets_LEFT = GameManager.getTradeCoalitionTargets(tradeRequest.listLEFT.lFormCoalitionAgainst, tradeRequest.listLEFT.fightCoalitionAllNeighbors, tradeRequest.iCivRIGHT, iFromCivID, iCivID);
        GameManager.applyTradeRequestWarTargets(iFromCivID, iCivID, tradeRequest.listLEFT.lDeclareWarOnCivID, lCoalitionTargets_LEFT);
        for (int prepCivID : tradeRequest.listLEFT.lPrepareForWarCivID) {
            CFG.core.getCiv(iFromCivID).civGD.civPlans.addNewWarPreps(iCivID, iFromCivID, prepCivID, tradeRequest.listLEFT.iPrepareForWarTurns);
        }
        if (!lCoalitionTargets_LEFT.isEmpty()) {
            CFG.core.setCivNonAggressionPact(iFromCivID, iCivID, GameValues.gvDipNonAggression.DIPLOMACY_MAX_NUMBER_OF_TURNS_NON_AGGRESSION_PACT);
            CFG.core.setMilitaryAccess(iFromCivID, iCivID, GameValues.gvDipMilitaryAccess.DIPLOMACY_MAX_NUMBER_OF_TURNS_FOR_MILITARY_ACCESS);
            CFG.core.setMilitaryAccess(iCivID, iFromCivID, GameValues.gvDipMilitaryAccess.DIPLOMACY_MAX_NUMBER_OF_TURNS_FOR_MILITARY_ACCESS);
            CFG.historyManager.addHistoryLog(new HistoryLog_HaveMilitartyAccess(iCivID, iFromCivID));
            CFG.historyManager.addHistoryLog(new HistoryLog_HaveMilitartyAccess(iFromCivID, iCivID));
        }
        if (tradeRequest.listLEFT.defensivePact) {
            CFG.core.setDefensivePact(iFromCivID, iCivID, GameValues.gvDipDefensivePact.DIPLOMACY_MAX_NUMBER_OF_TURNS_FOR_DEFENSIVE_PACT);
            CFG.historyManager.addHistoryLog(new HistoryLog_SignedDefensivePact(iCivID, iFromCivID));
        }
        if (tradeRequest.listLEFT.nonAggressionPact) {
            CFG.core.setCivNonAggressionPact(iFromCivID, iCivID, GameValues.gvDipNonAggression.DIPLOMACY_MAX_NUMBER_OF_TURNS_NON_AGGRESSION_PACT);
            CFG.historyManager.addHistoryLog(new HistoryLog_SignedNonAggressionPact(iCivID, iFromCivID));
        }
        if (tradeRequest.listLEFT.proclaimIndependence) {
            CFG.core.setGuarantee(iFromCivID, iCivID, GameValues.gvDipGuarantee.DIPLOMACY_MAX_NUMBER_OF_TURNS_FOR_GUARANTEE);
            CFG.historyManager.addHistoryLog(new HistoryLog_Guarantee(iFromCivID, iCivID));
        }
        for (int sanCivID : tradeRequest.listLEFT.lSanctionCivID) {
            GameManager.imposeSanctions(iFromCivID, sanCivID, tradeRequest.listLEFT.iSanctionTurns);
        }
        if (tradeRequest.listRight.iGold > 0) {
            CFG.core.getCiv(iCivID).setGold(CFG.core.getCiv(iCivID).getGold() - (long)tradeRequest.listRight.iGold);
            CFG.core.getCiv(iFromCivID).setGold(CFG.core.getCiv(iFromCivID).getGold() + (long)tradeRequest.listRight.iGold);
        }
        if (tradeRequest.listRight.lProvinces.size() > 0) {
            for (i = 0; i < tradeRequest.listRight.lProvinces.size(); ++i) {
                if (CFG.core.getProv(tradeRequest.listRight.lProvinces.get(i)).getCivId() != iCivID || CFG.core.getProv(tradeRequest.listRight.lProvinces.get(i)).getTrueOwnerOfProv() != iCivID) continue;
                tempArmy0 = CFG.core.getProv(tradeRequest.listRight.lProvinces.get(i)).getArmyID(0);
                tempCiv0 = CFG.core.getProv(tradeRequest.listRight.lProvinces.get(i)).getCivId();
                tempArmyNewOwner = CFG.core.getProv(tradeRequest.listRight.lProvinces.get(i)).getArmyCivID1((int)iCivID);
                CFG.core.getProv(tradeRequest.listRight.lProvinces.get(i)).updateArmy4(0);
                CFG.core.getProv(tradeRequest.listRight.lProvinces.get(i)).setTrueOwnerOfProv(iFromCivID);
                CFG.core.getProv(tradeRequest.listRight.lProvinces.get(i)).setCivId(iFromCivID, false);
                CFG.core.getProv(tradeRequest.listRight.lProvinces.get(i)).updateArmy4(tempCiv0, tempArmy0);
                CFG.core.getProv(tradeRequest.listRight.lProvinces.get(i)).updateArmy4(iCivID, tempArmyNewOwner);
                tempCivsLostAccess = new ArrayList();
                for (j = 0; j < CFG.core.getProv(tradeRequest.listRight.lProvinces.get(i)).getCivsSize(); ++j) {
                    tempCivsLostAccess.add(CFG.core.getProv(tradeRequest.listRight.lProvinces.get(i)).getCivId(j));
                }
                for (j = 0; j < tempCivsLostAccess.size(); ++j) {
                    if (CFG.core.getCiv((Integer)tempCivsLostAccess.get(j)).getPuppetOfCiv() == iFromCivID || CFG.core.getCiv(iFromCivID).getPuppetOfCiv() == ((Integer)tempCivsLostAccess.get(j)).intValue() || CFG.core.getCiv((Integer)tempCivsLostAccess.get(j)).getAlliance() > 0 && CFG.core.getCiv((Integer)tempCivsLostAccess.get(j)).getAlliance() == CFG.core.getCiv(iFromCivID).getAlliance() || CFG.core.getMilitaryAccess((Integer)tempCivsLostAccess.get(j), iFromCivID) > 0) continue;
                    CFG.gameAction.accessLost_MoveArmyToClosetsProvince((Integer)tempCivsLostAccess.get(j), tradeRequest.listRight.lProvinces.get(i));
                }
                if (!CFG.core.getProv(tradeRequest.listRight.lProvinces.get(i)).isCapital()) {
                    CFG.core.getProv(tradeRequest.listRight.lProvinces.get(i)).removeCapitalCityIcon();
                }
                CFG.core.getProv(tradeRequest.listRight.lProvinces.get(i)).getCores().removeCore(tradeRequest.iCivRIGHT);
            }
            CFG.core.buildCivilizationsRegions_TextOver(iFromCivID);
            CFG.core.buildCivilizationsRegions_TextOver(iCivID);
        }
        java.util.List<Integer> lCoalitionTargets_RIGHT = GameManager.getTradeCoalitionTargets(tradeRequest.listRight.lFormCoalitionAgainst, tradeRequest.listRight.fightCoalitionAllNeighbors, tradeRequest.iCivLEFT, iCivID, iFromCivID);
        GameManager.applyTradeRequestWarTargets(iCivID, iFromCivID, tradeRequest.listRight.lDeclareWarOnCivID, lCoalitionTargets_RIGHT);
        for (int prepCivID : tradeRequest.listRight.lPrepareForWarCivID) {
            CFG.core.getCiv(iCivID).civGD.civPlans.addNewWarPreps(iFromCivID, iCivID, prepCivID, tradeRequest.listRight.iPrepareForWarTurns);
        }
        if (!lCoalitionTargets_RIGHT.isEmpty()) {
            CFG.core.setCivNonAggressionPact(iFromCivID, iCivID, GameValues.gvDipNonAggression.DIPLOMACY_MAX_NUMBER_OF_TURNS_NON_AGGRESSION_PACT);
            CFG.core.setMilitaryAccess(iFromCivID, iCivID, GameValues.gvDipMilitaryAccess.DIPLOMACY_MAX_NUMBER_OF_TURNS_FOR_MILITARY_ACCESS);
            CFG.core.setMilitaryAccess(iCivID, iFromCivID, GameValues.gvDipMilitaryAccess.DIPLOMACY_MAX_NUMBER_OF_TURNS_FOR_MILITARY_ACCESS);
            CFG.historyManager.addHistoryLog(new HistoryLog_HaveMilitartyAccess(iFromCivID, iCivID));
            CFG.historyManager.addHistoryLog(new HistoryLog_HaveMilitartyAccess(iCivID, iFromCivID));
        }
        if (tradeRequest.listRight.defensivePact) {
            CFG.core.setDefensivePact(iFromCivID, iCivID, GameValues.gvDipDefensivePact.DIPLOMACY_MAX_NUMBER_OF_TURNS_FOR_DEFENSIVE_PACT);
            CFG.historyManager.addHistoryLog(new HistoryLog_SignedDefensivePact(iFromCivID, iCivID));
        }
        if (tradeRequest.listRight.nonAggressionPact) {
            CFG.core.setCivNonAggressionPact(iFromCivID, iCivID, GameValues.gvDipNonAggression.DIPLOMACY_MAX_NUMBER_OF_TURNS_NON_AGGRESSION_PACT);
            CFG.historyManager.addHistoryLog(new HistoryLog_SignedNonAggressionPact(iCivID, iFromCivID));
        }
        if (tradeRequest.listRight.proclaimIndependence) {
            CFG.core.setGuarantee(iCivID, iFromCivID, GameValues.gvDipGuarantee.DIPLOMACY_MAX_NUMBER_OF_TURNS_FOR_GUARANTEE);
            CFG.historyManager.addHistoryLog(new HistoryLog_Guarantee(iFromCivID, iCivID));
        }
        for (int sanCivID : tradeRequest.listRight.lSanctionCivID) {
            GameManager.imposeSanctions(iCivID, sanCivID, tradeRequest.listRight.iSanctionTurns);
        }
        CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_TradeReuest_Accepted(iCivID));
    }

    public static final void declineTradeRequest(int iCivID, int iFromCivID, TradeRequest_GameData tradeRequest) {
        CFG.core.getCiv((int)iFromCivID).getCivDiploGD().messageBox.addMessage(new Message_TradeReuest_Denied(iCivID));
    }

    public static String getTradeRequest_LikelihoodOfSuccess_Text() {
        try {
            int tradeOut = AIPlaystyle.tradeDealAI_ResponseInfo(CFG.tradeRequest, CFG.tradeRequest.iCivLEFT, CFG.tradeRequest.iCivRIGHT);
            switch (tradeOut) {
                case -1: {
                    return CFG.lang.get("Low");
                }
                case 0: {
                    return CFG.lang.get("Medium");
                }
                case 2: {
                    return CFG.lang.get("High");
                }
            }
            return CFG.lang.get("Medium");
        }
        catch (Exception exception) {
            if (!CFG.core.getCiv(CFG.tradeRequest.iCivRIGHT).getIsPlayer()) {
                return CFG.lang.get("Medium");
            }
            return CFG.lang.get("NoData");
        }
    }

    public static void enforcePeace(int byCivID, int civID, int warID) {
        if (CFG.core.getCiv(byCivID).getDiploPoints() < GameValues.gvEnforcePeace.COST_ENFORCE_PEACE) {
            return;
        }
        boolean truceAccepted = false;
        CFG.core.getCiv(byCivID).setDiploPoints(CFG.core.getCiv(byCivID).getDiploPoints() - GameValues.gvEnforcePeace.COST_ENFORCE_PEACE);
        float score = GameValues.gvEnforcePeace.ENFORCE_PEACE_SCORE_BASE;
        score = CFG.core.getCiv(byCivID).getCapitalProvID() >= 0 && CFG.core.getCiv(civID).getCapitalProvID() >= 0 ? (score += GameValues.gvEnforcePeace.ENFORCE_PEACE_SCORE_DISTANCE * Distance.getDistanceFromAToB_PercOfMax(CFG.core.getCiv(byCivID).getCapitalProvID(), CFG.core.getCiv(civID).getCapitalProvID())) : (score += GameValues.gvEnforcePeace.ENFORCE_PEACE_SCORE_DISTANCE);
        try {
            int i;
            float aggressorsArmy = 0.0f;
            int defendersArmy = 0;
            for (i = 0; i < CFG.core.getWar(warID).getAggressorsSize(); ++i) {
                aggressorsArmy += (float)CFG.core.getCiv(CFG.core.getWar(warID).getAggressorID(i).getCivID()).getNumberOfUnits();
                if (CFG.core.getCiv(CFG.core.getWar(warID).getAggressorID(i).getCivID()).getGold() <= 0L) continue;
                aggressorsArmy += (float)CFG.core.getCiv(CFG.core.getWar(warID).getAggressorID(i).getCivID()).getGold() / (float)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT;
            }
            aggressorsArmy *= GameValues.gvEnforcePeace.ENFORCE_PEACE_SCORE_ARMY_AGGRESSORS_MODIFIER;
            for (i = 0; i < CFG.core.getWar(warID).getDefendersSize(); ++i) {
                defendersArmy += CFG.core.getCiv(CFG.core.getWar(warID).getDefenderID(i).getCivID()).getNumberOfUnits();
            }
            score += GameValues.gvEnforcePeace.ENFORCE_PEACE_SCORE_ARMY * Math.min(GameValues.gvEnforcePeace.ENFORCE_PEACE_SCORE_ARMY_MAX_MODIFIER, Math.max(0.01f, (float)(defendersArmy += (int)((float)CFG.core.getCiv(byCivID).getNumberOfUnits() * GameValues.gvEnforcePeace.ENFORCE_PEACE_SCORE_PLAYERS_ARMY_MODIFIER)) / aggressorsArmy));
            score += GameValues.gvEnforcePeace.ENFORCE_PEACE_SCORE_CURRENT_WAR_SCORE * ((float)CFG.core.getWar(warID).getWarScore() / 100.0f);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        CFG.core.getCiv(civID).setRelationD(byCivID, CFG.core.getCiv(civID).getRelationD(byCivID) + GameValues.gvEnforcePeace.ENFORCE_PEACE_RELATIONS_CHANGE);
        CFG.core.getCiv(byCivID).setRelationD(civID, CFG.core.getCiv(byCivID).getRelationD(civID) + GameValues.gvEnforcePeace.ENFORCE_PEACE_RELATIONS_CHANGE);
        try {
            CFG.core.getCiv(CFG.core.getWar(warID).getDefenderID(0).getCivID()).setRelationD(byCivID, CFG.core.getCiv(civID).getRelationD(byCivID) + GameValues.gvEnforcePeace.ENFORCE_PEACE_RELATIONS_DEFENDER);
            CFG.core.getCiv(byCivID).setRelationD(CFG.core.getWar(warID).getDefenderID(0).getCivID(), CFG.core.getCiv(byCivID).getRelationD(CFG.core.getWar(warID).getDefenderID(0).getCivID()) + GameValues.gvEnforcePeace.ENFORCE_PEACE_RELATIONS_DEFENDER);
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        if (GameValues.gvEnforcePeace.ENABLE_REFUSE_IF_HIGHER_RANK && CFG.core.getCiv(civID).getRankPos() < CFG.core.getCiv(byCivID).getRankPos()) {
            score = -1000.0f;
        }
        try {
            if (score >= 0.0f) {
                int o;
                truceAccepted = true;
                ArrayList<Boolean> lDefenders = new ArrayList<Boolean>();
                ArrayList<Boolean> lAggressors = new ArrayList<Boolean>();
                for (o = 0; o < CFG.core.getWar(warID).getAggressorsSize(); ++o) {
                    lAggressors.add(true);
                }
                for (o = 0; o < CFG.core.getWar(warID).getDefendersSize(); ++o) {
                    lDefenders.add(true);
                }
                Menu_PeaceTreaty.WAR_ID = warID;
                CFG.peaceTreatyData = new PeaceTreaty_Data(Menu_PeaceTreaty.WAR_ID, lDefenders, lAggressors, true);
                CFG.peaceTreatyData.preparePeaceTreatyToSend(civID);
                CFG.core.lPeaceTreaties.add(new PeaceTreaty_GameData_MessageData(CFG.peaceTreatyData.peaceTreatyGD));
                String peaceTreatyTag = CFG.core.lPeaceTreaties.get((int)(CFG.core.lPeaceTreaties.size() - 1)).PEACE_TREATY_TAG;
                GameManager.acceptPeaceTreaty(civID, peaceTreatyTag, true);
                if (GameValues.gvEnforcePeace.ENFORCE_PEACE_SIGN_TRUCE_WITH_AGGRESSOR) {
                    CFG.core.setCivTruce(byCivID, civID, GameValues.gvEnforcePeace.ENFORCE_PEACE_SIGN_TRUCE_WITH_AGGRESSOR_TURNS);
                }
            } else {
                truceAccepted = false;
                CFG.core.joinWar(byCivID, civID, warID);
                if (CFG.core.getCivsAtWar(byCivID, civID)) {
                    CFG.core.getCiv((int)byCivID).getCivDiploGD().messageBox.addMessage(new Message_War(civID, byCivID));
                    GameManager.sNCIAW(civID, byCivID);
                    CFG.menus.rebuildInGame_Messages();
                    CFG.menus.setVisible_Menu_InGame_CurrentWars(true);
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        if (truceAccepted) {
            CFG.menus.rebuildMenu_InGame_InfoboxSmallFlags(CFG.lang.get("EnforcePeaceAccepted1"), byCivID, civID, Images.infoTruce);
        } else {
            CFG.menus.rebuildMenu_InGame_InfoboxSmallFlags(CFG.lang.get("EnforcePeaceRefused1"), byCivID, civID, Images.infoTruce);
        }
    }

    public static void sNCIAW(int civA, int civB) {
        for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
            if (civA == CFG.core.getPlayer(i).getCivId() || civB == CFG.core.getPlayer(i).getCivId()) continue;
            if (CFG.core.getCiv((int)civA).civNeighbors.isNeighbor(CFG.core.getPlayer(i).getCivId())) {
                CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).getCivDiploGD().messageBox.addMessage(new Message_NW(civA, civB));
            }
            if (!CFG.core.getCiv((int)civB).civNeighbors.isNeighbor(CFG.core.getPlayer(i).getCivId())) continue;
            CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).getCivDiploGD().messageBox.addMessage(new Message_NW(civA, civB));
        }
    }

    public static void sNCST(int civA, int civB) {
        for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
            if (civA == CFG.core.getPlayer(i).getCivId() || civB == CFG.core.getPlayer(i).getCivId()) continue;
            if (CFG.core.getCiv((int)civA).civNeighbors.isNeighbor(CFG.core.getPlayer(i).getCivId())) {
                CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).getCivDiploGD().messageBox.addMessage(new Message_NTR(civA, civB));
            }
            if (!CFG.core.getCiv((int)civB).civNeighbors.isNeighbor(CFG.core.getPlayer(i).getCivId())) continue;
            CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).getCivDiploGD().messageBox.addMessage(new Message_NTR(civA, civB));
        }
    }

    public static final void buildFriendlyCivs() {
        int i;
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
            CFG.core.getCiv(i).clearFriendlyCivs();
        }
        for (i = 1; i < CFG.core.getCivsSize() - 1; ++i) {
            for (int j = i + 1; j < CFG.core.getCivsSize(); ++j) {
                if (CFG.core.getCivRelationOfCivB(i, j) > (float)GameValues.gvRelations.FRIENDLY_MIN_RELATION) {
                    CFG.core.getCiv(i).addFriendlyCiv(j);
                } else if (CFG.core.getCivRelationOfCivB(i, j) < (float)GameValues.gvRelations.HATED_MIN_RELATION) {
                    CFG.core.getCiv(i).addHatedCiv(j);
                }
                if (CFG.core.getCivRelationOfCivB(j, i) > (float)GameValues.gvRelations.FRIENDLY_MIN_RELATION) {
                    CFG.core.getCiv(j).addFriendlyCiv(i);
                    continue;
                }
                if (!(CFG.core.getCivRelationOfCivB(j, i) < (float)GameValues.gvRelations.HATED_MIN_RELATION)) continue;
                CFG.core.getCiv(j).addHatedCiv(i);
            }
        }
    }

    public static final void updatePlayersFriendlyCivs() {
        if (!CFG.SPECTATOR_MODE) {
            try {
                for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                    if (CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getNumOfProvs() <= 0) continue;
                    for (int z = CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getFriendlyCivsSize() - 1; z >= 0; --z) {
                        if (!(CFG.core.getCivRelationOfCivB(CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).getFriendlyCiv((int)z).iCivID, CFG.core.getPlayer(i).getCivId()) < (float)(GameValues.gvRelations.FRIENDLY_MIN_RELATION - 5))) continue;
                        CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).removeFriendlyCiv(CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).getFriendlyCiv((int)z).iCivID);
                    }
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public static final void checkCivsHatedCivilizations_IfStillExists() {
        for (int i = 1 + GameCalendar.TURNID % GameValues.gvUpdate.HATED_CIVS_CHECK_INTERVAL_TURNS; i < CFG.core.getCivsSize(); i += GameValues.gvUpdate.HATED_CIVS_CHECK_INTERVAL_TURNS) {
            if (CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
            for (int z = CFG.core.getCiv(i).getHatedCivsSize() - 1; z >= 0; --z) {
                if (CFG.core.getCiv(CFG.core.getCiv((int)i).getHatedCiv((int)z).iCivID).getNumOfProvs() != 0) continue;
                CFG.core.getCiv(i).removeHatedCiv(CFG.core.getCiv((int)i).getHatedCiv((int)z).iCivID);
            }
        }
    }

    public static final void updateFriendlyCiv(int nCivA, int nCivB) {
        if (CFG.core.getCivRelationOfCivB(nCivA, nCivB) > (float)GameValues.gvRelations.FRIENDLY_MIN_RELATION) {
            if (CFG.core.getCiv(nCivB).addFriendlyCiv(nCivA)) {
                CFG.core.getCiv(nCivA).removeHatedCiv(nCivB);
            }
        } else if (CFG.core.getCivRelationOfCivB(nCivA, nCivB) < (float)GameValues.gvRelations.HATED_MIN_RELATION && CFG.core.getCiv(nCivA).addHatedCiv(nCivB)) {
            CFG.core.getCiv(nCivB).removeFriendlyCiv(nCivA);
        }
        if (CFG.core.getCivRelationOfCivB(nCivB, nCivA) > (float)GameValues.gvRelations.FRIENDLY_MIN_RELATION) {
            if (CFG.core.getCiv(nCivA).addFriendlyCiv(nCivB)) {
                CFG.core.getCiv(nCivB).removeHatedCiv(nCivA);
            }
        } else if (CFG.core.getCivRelationOfCivB(nCivB, nCivA) < (float)GameValues.gvRelations.HATED_MIN_RELATION && CFG.core.getCiv(nCivB).addHatedCiv(nCivA)) {
            CFG.core.getCiv(nCivA).removeFriendlyCiv(nCivB);
        }
    }

    public static boolean improveRelation(int iCivA, int iCivB) {
        if (CFG.core.getCiv(iCivA).getNumOfProvs() == 0) {
            return false;
        }
        if (CFG.core.getCiv(iCivB).getCivDiploGD().getIsEmbassyClosed(iCivA)) {
            return false;
        }
        if (CFG.core.getCiv(iCivA).getDiploPoints() >= GameValues.gvRelationImprove.COST_OFFER_IMPROVE_RELATIONS_DIPLOMACY_POINTS && !CFG.core.getCivsAtWar(iCivA, iCivB)) {
            float out = GameManager.getImproveRelation(iCivA, iCivB);
            float out2 = GameManager.getImproveRelation(iCivB, iCivA) * GameValues.gvRelationImprove.IMPROVE_RELATIONS_RECIPROCITY_MODIFIER;
            boolean updateFriendlyRelation = false;
            if (CFG.core.getCivRelationOfCivB(iCivA, iCivB) < (float)GameValues.gvRelations.FRIENDLY_MIN_RELATION) {
                updateFriendlyRelation = true;
            }
            CFG.core.setCivRelationOfCivB(iCivA, iCivB, CFG.core.getCivRelationOfCivB(iCivA, iCivB) + out2);
            CFG.core.setCivRelationOfCivB(iCivB, iCivA, CFG.core.getCivRelationOfCivB(iCivB, iCivA) + out);
            if (updateFriendlyRelation) {
                GameManager.updateFriendlyCiv(iCivA, iCivB);
            }
            return true;
        }
        return false;
    }

    public static void improveRelationAddMessage(int iWithCivID, int byCivID) {
        if (CFG.core.getCiv(iWithCivID).getIsPlayer()) {
            CFG.core.getCiv((int)iWithCivID).getCivDiploGD().messageBox.addMessage(new Message_Relations_Increase(byCivID));
        }
    }

    public static float getImproveRelation(int iCivA, int iCivB) {
        float out = GameValues.gvRelationImprove.IMPROVE_RELATIONS_BASE + (float)CFG.oR.nextInt(GameValues.gvRelationImprove.IMPROVE_RELATIONS_RANDOM_100) / 100.0f;
        out = GameValues.gvRelationImprove.IMPROVE_RELATIONS_MIN_GAIN + out * (Math.min(CFG.core.getCivRelationOfCivB(iCivB, iCivA) + 100.0f, GameValues.gvRelationImprove.IMPROVE_RELATIONS_RELATION_MAX_EFFECTIVE) / 200.0f) * Math.min(Math.max(GameValues.gvRelationImprove.IMPROVE_RELATIONS_RANK_SCORE_MIN_RATIO, (float)CFG.core.getCiv(iCivA).getRankScore() / (float)CFG.core.getCiv(iCivB).getRankScore()), GameValues.gvRelationImprove.IMPROVE_RELATIONS_RANK_SCORE_MAX_RATIO);
        return out;
    }

    public static boolean decreaseRelation(int iCivA, int iCivB, int nNumOfTurns) {
        if (CFG.core.getCiv(iCivA).getDiploPoints() >= GameValues.gvRelationDecrease.COST_OFFER_DECREASE_RELATIONS_DIPLOMACY_POINTS) {
            CFG.core.getCiv(iCivA).setDiploPoints(CFG.core.getCiv(iCivA).getDiploPoints() - GameValues.gvRelationDecrease.COST_OFFER_DECREASE_RELATIONS_DIPLOMACY_POINTS);
            if (CFG.core.getCiv(iCivB).getIsPlayer()) {
                CFG.core.getCiv((int)iCivB).getCivDiploGD().messageBox.addMessage(new Message_Relations_Insult(iCivA));
            }
            CFG.core.getCiv(iCivA).getCivDiploGD().removeImproveRelations_WithCivID(iCivA, iCivB);
            CFG.core.getCiv(iCivB).getCivDiploGD().removeImproveRelations_WithCivID(iCivB, iCivA);
            CFG.core.getCiv(iCivA).getCivDiploGD().addEmbassyClosed(new Civilization_ClosedEmbassy(iCivB, nNumOfTurns));
            CFG.core.getCiv(iCivB).getCivDiploGD().addEmbassyClosed(new Civilization_ClosedEmbassy(iCivA, nNumOfTurns));
            if (CFG.core.getCiv(iCivA).getIsPlayer()) {
                Core.addDiplomacyLines(CFG.core.getCapitalOrProvince(iCivA), CFG.core.getCapitalOrProvince(iCivB), CFG.COLOR_NEGATIVE_1, CFG.COLOR_NEGATIVE_ACTIVE);
            } else if (CFG.core.getCiv(iCivB).getIsPlayer()) {
                Core.addDiplomacyLines(CFG.core.getCapitalOrProvince(iCivB), CFG.core.getCapitalOrProvince(iCivA), CFG.COLOR_NEGATIVE_1, CFG.COLOR_NEGATIVE_ACTIVE);
            }
            float out = GameManager.getDecreaseRelation(iCivA, iCivB);
            CFG.core.setCivRelationOfCivB(iCivA, iCivB, CFG.core.getCivRelationOfCivB(iCivA, iCivB) > (float)GameValues.gvDiplomacy.RELATION_AT_WAR && CFG.core.getCivRelationOfCivB(iCivA, iCivB) + out <= (float)GameValues.gvDiplomacy.RELATION_AT_WAR ? (float)(GameValues.gvDiplomacy.RELATION_AT_WAR + 1) : CFG.core.getCivRelationOfCivB(iCivA, iCivB) + out);
            CFG.core.setCivRelationOfCivB(iCivB, iCivA, CFG.core.getCivRelationOfCivB(iCivB, iCivA) > (float)GameValues.gvDiplomacy.RELATION_AT_WAR && CFG.core.getCivRelationOfCivB(iCivB, iCivA) + out <= (float)GameValues.gvDiplomacy.RELATION_AT_WAR ? (float)(GameValues.gvDiplomacy.RELATION_AT_WAR + 1) : CFG.core.getCivRelationOfCivB(iCivB, iCivA) + out);
            if (GameValues.gvDiplomacy.INSULT_WORLD_REACTIONS) {
                WorldReactions.worldReactions((int)Math.min((float)GameValues.gvRelationsReactions.INSULT_WORLD_REACTION_MAX, CFG.core.getCivRelationOfCivB(iCivA, iCivB) + 100.0f) / GameValues.gvRelationsReactions.INSULT_WORLD_REACTION_RELATION_MODIFIER_DIVISOR, iCivA, iCivB);
            }
            GameManager.updateFriendlyCiv(iCivA, iCivB);
            return true;
        }
        return false;
    }

    public static float getDecreaseRelation(int iCivA, int iCivB) {
        float out = -((float)GameValues.gvRelationDecrease.INSULT_DECREASE_RELATIONS + (float)CFG.oR.nextInt(GameValues.gvRelationDecrease.INSULT_DECREASE_RELATIONS_RANDOM_VALUE) / 100.0f);
        out = out * GameValues.gvRelationDecrease.INSULT_DECREASE_RELATIONS_BASE_PENALTY_RATIO + out * GameValues.gvRelationDecrease.INSULT_DECREASE_RELATIONS_BASED_ON_CURRENT_RELATION_RATIO * ((CFG.core.getCivRelationOfCivB(iCivB, iCivA) + 100.0f) / 200.0f);
        return out;
    }

    public static final void liberateAVassal(int iLord, int iVassal) {
        if (CFG.core.getCiv(iVassal).getPuppetOfCiv() == iLord) {
            CFG.core.getCiv(iLord).removeVassal(iVassal);
            CFG.core.getCiv(iVassal).setPuppetOfCivId(iVassal);
            if (CFG.core.getMilitaryAccess(iLord, iVassal) <= 0) {
                CFG.gameAction.accessLost_UpdateArmies(iVassal, iLord);
            }
            if (CFG.core.getMilitaryAccess(iVassal, iLord) <= 0) {
                CFG.gameAction.accessLost_UpdateArmies(iLord, iVassal);
            }
            if (CFG.FOG_OF_WAR > 0) {
                if (CFG.core.getPlayerIDbyCivID(iLord) >= 0) {
                    CFG.gameAction.buildFogOfWar(CFG.core.getPlayerIDbyCivID(iLord));
                }
                if (CFG.core.getPlayerIDbyCivID(iVassal) >= 0) {
                    CFG.gameAction.buildFogOfWar(CFG.core.getPlayerIDbyCivID(iVassal));
                }
            }
            CFG.historyManager.addHistoryLog(new HistoryLog_IsNotVassal(iLord, iVassal));
            CFG.core.getCiv((int)iVassal).getCivDiploGD().messageBox.addMessage(new Message_Liberation(iLord));
            if (!CFG.core.getCiv(iLord).getIsPlayer()) {
                CFG.core.getCiv(iLord).addSentMessages(new Civilization_SentMessages(iVassal, MessageType.LIBERATION_OF_VASSAL));
            }
        }
    }

    public static final void declarationOfIndependenceByVassal(int iLord, int iVassal) {
        if (CFG.core.getCivTruce(iLord, iVassal) > 0) {
            return;
        }
        if (CFG.VASSALS_CAN_DECLARE_INDEPENDENCE && !CFG.core.getCiv(iVassal).getIsPlayer()) {
            return;
        }
        if (CFG.core.getCiv(iVassal).getPuppetOfCiv() == iLord) {
            CFG.core.getCiv(iVassal).setPuppetOfCivId(iVassal);
            CFG.core.getCiv(iVassal).setVassalLibertyDesire(0.0f);
            if (CFG.core.getMilitaryAccess(iLord, iVassal) <= 0) {
                CFG.gameAction.accessLost_UpdateArmies(iVassal, iLord);
            }
            if (CFG.core.getMilitaryAccess(iVassal, iLord) <= 0) {
                CFG.gameAction.accessLost_UpdateArmies(iLord, iVassal);
            }
            if (CFG.FOG_OF_WAR > 0) {
                if (CFG.core.getPlayerIDbyCivID(iLord) >= 0) {
                    CFG.gameAction.buildFogOfWar(CFG.core.getPlayerIDbyCivID(iLord));
                }
                if (CFG.core.getPlayerIDbyCivID(iVassal) >= 0) {
                    CFG.gameAction.buildFogOfWar(CFG.core.getPlayerIDbyCivID(iVassal));
                }
            }
            CFG.historyManager.addHistoryLog(new HistoryLog_IsNotVassal(iLord, iVassal));
            CFG.core.getCiv((int)iVassal).getCivDiploGD().messageBox.addMessage(new Message_Liberation(iLord));
            CFG.core.getCiv((int)iLord).getCivDiploGD().messageBox.addMessage(new Message_DeclarationOfIndependence_ByVassal(iVassal));
            if (!CFG.core.getCiv(iLord).getIsPlayer()) {
                CFG.core.getCiv(iLord).addSentMessages(new Civilization_SentMessages(iVassal, MessageType.LIBERATION_OF_VASSAL));
            }
        }
    }

    public static final void leaveAlliance(int nCivID) {
        if (CFG.core.getCiv(nCivID).getAlliance() > 0 && CFG.core.getCiv(nCivID).getAlliance() < CFG.core.getAlliancesSize()) {
            int allianceID = CFG.core.getCiv(nCivID).getAlliance();
            CFG.core.getAlliance(allianceID).removeCivilization(nCivID);
            CFG.core.getCiv(nCivID).setAlliance(0);
            if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                int tPlayerID = CFG.core.getPlayerIDbyCivID(nCivID);
                for (int i = 0; i < CFG.core.getAlliance(allianceID).getCivilizationsSize(); ++i) {
                    int j;
                    int tPlayerID2;
                    if (CFG.core.getCiv(CFG.core.getAlliance(allianceID).getCivilization(i)).getIsPlayer() && (tPlayerID2 = CFG.core.getPlayerIDbyCivID(CFG.core.getAlliance(allianceID).getCivilization(i))) >= 0) {
                        int j2;
                        for (j2 = 0; j2 < CFG.core.getCiv(nCivID).getNumOfProvs(); ++j2) {
                            CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(j2)).updateFogOfWar(tPlayerID2);
                        }
                        for (j2 = 0; j2 < CFG.core.getCiv((int)nCivID).civGD.vassals.size(); ++j2) {
                            for (int k = 0; k < CFG.core.getCiv(CFG.core.getCiv((int)nCivID).civGD.vassals.get((int)j2).iCivID).getNumOfProvs(); ++k) {
                                CFG.core.getProv(CFG.core.getCiv(CFG.core.getCiv((int)nCivID).civGD.vassals.get((int)j2).iCivID).getProvID(j2)).updateFogOfWar(tPlayerID2);
                            }
                        }
                    }
                    if (tPlayerID < 0) continue;
                    for (j = 0; j < CFG.core.getCiv(CFG.core.getAlliance(allianceID).getCivilization(i)).getNumOfProvs(); ++j) {
                        CFG.core.getProv(CFG.core.getCiv(CFG.core.getAlliance(allianceID).getCivilization(i)).getProvID(j)).updateFogOfWar(tPlayerID);
                    }
                    for (j = 0; j < CFG.core.getCiv((int)CFG.core.getAlliance((int)allianceID).getCivilization((int)i)).civGD.vassals.size(); ++j) {
                        for (int k = 0; k < CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getAlliance((int)allianceID).getCivilization((int)i)).civGD.vassals.get((int)j).iCivID).getNumOfProvs(); ++k) {
                            CFG.core.getProv(CFG.core.getCiv(CFG.core.getCiv((int)CFG.core.getAlliance((int)allianceID).getCivilization((int)i)).civGD.vassals.get((int)j).iCivID).getProvID(j)).updateFogOfWar(tPlayerID);
                        }
                    }
                }
            }
            for (int i = 0; i < CFG.core.getAlliance(allianceID).getCivilizationsSize(); ++i) {
                int out = -10;
                CFG.core.setCivRelationOfCivB(nCivID, CFG.core.getAlliance(allianceID).getCivilization(i), CFG.core.getCivRelationOfCivB(nCivID, CFG.core.getAlliance(allianceID).getCivilization(i)) > (float)GameValues.gvDiplomacy.RELATION_AT_WAR && CFG.core.getCivRelationOfCivB(nCivID, CFG.core.getAlliance(allianceID).getCivilization(i)) + (float)out <= (float)GameValues.gvDiplomacy.RELATION_AT_WAR ? (float)(GameValues.gvDiplomacy.RELATION_AT_WAR + 1) : CFG.core.getCivRelationOfCivB(nCivID, CFG.core.getAlliance(allianceID).getCivilization(i)) + (float)out);
                CFG.core.setCivRelationOfCivB(CFG.core.getAlliance(allianceID).getCivilization(i), nCivID, CFG.core.getCivRelationOfCivB(CFG.core.getAlliance(allianceID).getCivilization(i), nCivID) > (float)GameValues.gvDiplomacy.RELATION_AT_WAR && CFG.core.getCivRelationOfCivB(CFG.core.getAlliance(allianceID).getCivilization(i), nCivID) + (float)out <= (float)GameValues.gvDiplomacy.RELATION_AT_WAR ? (float)(GameValues.gvDiplomacy.RELATION_AT_WAR + 1) : CFG.core.getCivRelationOfCivB(CFG.core.getAlliance(allianceID).getCivilization(i), nCivID) + (float)out);
                CFG.core.getCiv((int)CFG.core.getAlliance((int)allianceID).getCivilization((int)i)).getCivDiploGD().messageBox.addMessage(new Message_LeftAlliance(nCivID, allianceID));
            }
            CFG.historyManager.addHistoryLog(new HistoryLog_LeavesAlliance(nCivID, allianceID));
        }
    }

    public static final void kickFromAlliance(int nCivID, int byCivID) {
        if (CFG.core.getCiv(nCivID).getAlliance() > 0 && CFG.core.getCiv(nCivID).getAlliance() < CFG.core.getAlliancesSize() && CFG.core.getCiv(nCivID).getAlliance() == CFG.core.getCiv(byCivID).getAlliance()) {
            int k;
            int j;
            int i;
            int allianceID = CFG.core.getCiv(nCivID).getAlliance();
            CFG.core.getAlliance(allianceID).removeCivilization(nCivID);
            CFG.core.getCiv(nCivID).setAlliance(0);
            for (i = 0; i < CFG.core.getAlliance(allianceID).getCivilizationsSize(); ++i) {
                int tPlayerID;
                if (!CFG.core.getCiv(CFG.core.getAlliance(allianceID).getCivilization(i)).getIsPlayer()) continue;
                if (CFG.core.getAlliance(allianceID).getCivilization(i) == nCivID && (tPlayerID = CFG.core.getPlayerIDbyCivID(nCivID)) >= 0) {
                    for (j = 0; j < CFG.core.getCiv(byCivID).getNumOfProvs(); ++j) {
                        CFG.core.getProv(CFG.core.getCiv(byCivID).getProvID(j)).updateFogOfWar(tPlayerID);
                    }
                    for (j = 0; j < CFG.core.getCiv((int)byCivID).civGD.vassals.size(); ++j) {
                        for (k = 0; k < CFG.core.getCiv(CFG.core.getCiv((int)byCivID).civGD.vassals.get((int)j).iCivID).getNumOfProvs(); ++k) {
                            CFG.core.getProv(CFG.core.getCiv(CFG.core.getCiv((int)byCivID).civGD.vassals.get((int)j).iCivID).getProvID(j)).updateFogOfWar(tPlayerID);
                        }
                    }
                }
                if (CFG.core.getAlliance(allianceID).getCivilization(i) != nCivID || (tPlayerID = CFG.core.getPlayerIDbyCivID(nCivID)) < 0) continue;
                for (j = 0; j < CFG.core.getCiv(nCivID).getNumOfProvs(); ++j) {
                    CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(j)).updateFogOfWar(tPlayerID);
                }
                for (j = 0; j < CFG.core.getCiv((int)nCivID).civGD.vassals.size(); ++j) {
                    for (k = 0; k < CFG.core.getCiv(CFG.core.getCiv((int)nCivID).civGD.vassals.get((int)j).iCivID).getNumOfProvs(); ++k) {
                        CFG.core.getProv(CFG.core.getCiv(CFG.core.getCiv((int)nCivID).civGD.vassals.get((int)j).iCivID).getProvID(j)).updateFogOfWar(tPlayerID);
                    }
                }
            }
            for (i = 0; i < CFG.core.getAlliance(allianceID).getCivilizationsSize(); ++i) {
                int tPlayerID2;
                if (!CFG.core.getCiv(CFG.core.getAlliance(allianceID).getCivilization(i)).getIsPlayer() || (tPlayerID2 = CFG.core.getPlayerIDbyCivID(CFG.core.getAlliance(allianceID).getCivilization(i))) < 0) continue;
                for (j = 0; j < CFG.core.getCiv(nCivID).getNumOfProvs(); ++j) {
                    CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(j)).updateFogOfWar(tPlayerID2);
                }
                for (j = 0; j < CFG.core.getCiv((int)nCivID).civGD.vassals.size(); ++j) {
                    for (k = 0; k < CFG.core.getCiv(CFG.core.getCiv((int)nCivID).civGD.vassals.get((int)j).iCivID).getNumOfProvs(); ++k) {
                        CFG.core.getProv(CFG.core.getCiv(CFG.core.getCiv((int)nCivID).civGD.vassals.get((int)j).iCivID).getProvID(j)).updateFogOfWar(tPlayerID2);
                    }
                }
            }
            int out = -25;
            CFG.core.setCivRelationOfCivB(nCivID, byCivID, CFG.core.getCivRelationOfCivB(nCivID, byCivID) > (float)GameValues.gvDiplomacy.RELATION_AT_WAR && CFG.core.getCivRelationOfCivB(nCivID, byCivID) + (float)out <= (float)GameValues.gvDiplomacy.RELATION_AT_WAR ? (float)(GameValues.gvDiplomacy.RELATION_AT_WAR + 1) : CFG.core.getCivRelationOfCivB(nCivID, byCivID) + (float)out);
            CFG.core.setCivRelationOfCivB(byCivID, nCivID, CFG.core.getCivRelationOfCivB(byCivID, nCivID) > (float)GameValues.gvDiplomacy.RELATION_AT_WAR && CFG.core.getCivRelationOfCivB(byCivID, nCivID) + (float)out <= (float)GameValues.gvDiplomacy.RELATION_AT_WAR ? (float)(GameValues.gvDiplomacy.RELATION_AT_WAR + 1) : CFG.core.getCivRelationOfCivB(byCivID, nCivID) + (float)out);
            for (int i2 = 0; i2 < CFG.core.getAlliance(allianceID).getCivilizationsSize(); ++i2) {
                CFG.core.getCiv((int)CFG.core.getAlliance((int)allianceID).getCivilization((int)i2)).getCivDiploGD().messageBox.addMessage(new Message_LeftAlliance(nCivID, allianceID));
            }
            CFG.historyManager.addHistoryLog(new HistoryLog_LeavesAlliance(nCivID, allianceID));
        }
    }

    public static boolean changeGovernmentType(int nCivID, int toGovType) {
        int i;
        if (CFG.core.getCiv(nCivID).getIdeology() == toGovType) {
            return false;
        }
        if (CFG.core.getCiv(nCivID).getGold() < (long)IdeologiesManager.getChangeGovernmentCost(nCivID)) {
            return false;
        }
        if (CFG.core.getCiv(nCivID).getMovemPoints() < GameValues.gvGovernment.CHANGE_GOV_MOVEMENT_COST) {
            return false;
        }
        CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)IdeologiesManager.getChangeGovernmentCost(nCivID));
        CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - GameValues.gvGovernment.CHANGE_GOV_MOVEMENT_COST);
        CFG.core.updateCivilizationIdeology(nCivID, CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(nCivID).getCivTag()) + CFG.ideologiesMgr.getIdeologyID(toGovType).getExtraTag());
        for (i = 0; i < CFG.core.getCiv(nCivID).getCivRegionsSize(); ++i) {
            CFG.core.getCiv(nCivID).getCivRegion(i).buildScaleOfText();
        }
        for (i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
            CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).setHappi(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getHappi() - GameValues.gvGovernment.CHANGE_GOV_DECREASE_HAPPINESS / 100.0f);
        }
        return true;
    }

    public static boolean changeReligion(int nCivID, int toReligionID) {
        if (CFG.core.getCiv(nCivID).getReligionID() == toReligionID) {
            return false;
        }
        if (CFG.core.getCiv(nCivID).getGold() < (long)IdeologiesManager.getChangeReligionCost(nCivID)) {
            return false;
        }
        CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - (long)IdeologiesManager.getChangeReligionCost(nCivID));
        CFG.core.getCiv(nCivID).setReligionID(toReligionID);
        for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
            CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).setHappi(CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).getHappi() - GameValues.gvGovernment.CHANGE_RELIGION_DECREASE_HAPPINESS / 100.0f);
        }
        return true;
    }

    public static final String getInsult() {
        switch (CFG.oR.nextInt(5)) {
            case 0: {
                return CFG.lang.get("WeWillClaimBothYourLivesAndYourFreedom");
            }
            case 1: {
                return CFG.lang.get("YourCivilizationWillCrumbleAndWeShallDanceUponTheRuinsOfYourFormerGreatness");
            }
            case 2: {
                return CFG.lang.get("WellSnatchAwayYourMightLeavingYourCivilizationInTheShadowsOfItsFormerSelf");
            }
            case 3: {
                return CFG.lang.get("PrepareForTheDemiseOfYourSovereigntyForWeWillSeizeIt");
            }
        }
        return CFG.lang.get("YourStandingWillBeReducedToRuinsAndWeShallRevelInYourDownfall");
    }

    public static final String getInsult(int id) {
        switch (id % 5) {
            case 0: {
                return CFG.lang.get("WeWillClaimBothYourLivesAndYourFreedom");
            }
            case 1: {
                return CFG.lang.get("YourCivilizationWillCrumbleAndWeShallDanceUponTheRuinsOfYourFormerGreatness");
            }
            case 2: {
                return CFG.lang.get("WellSnatchAwayYourMightLeavingYourCivilizationInTheShadowsOfItsFormerSelf");
            }
            case 3: {
                return CFG.lang.get("PrepareForTheDemiseOfYourSovereigntyForWeWillSeizeIt");
            }
        }
        return CFG.lang.get("YourStandingWillBeReducedToRuinsAndWeShallRevelInYourDownfall");
    }

    public static final String getWarMessage() {
        switch (CFG.oR.nextInt(7)) {
            case 0: {
                return CFG.lang.get("WitnessTheMightOfMyForcesAsWeDeclareWarUponYouForYourWeaknessCannotWithstandOurStrength");
            }
            case 1: {
                return CFG.lang.get("BraceYourselfForIDeclareWarUponYouToAssertMyRightfulAuthorityOverYourTerritories");
            }
            case 2: {
                return CFG.lang.get("ThisWarIsTheDestinyYouCannotEscapeAsWeRiseToCrushYourFeebleResistance");
            }
            case 3: {
                return CFG.lang.get("YourLandsWillBeReshapedUnderOurBannerAsWarIsDeclaredToSecureOurRightfulDominion");
            }
            case 4: {
                return CFG.lang.get("PrepareForTheMarchOfOurArmiesAsWeDeclareWarToAssertOurDominanceOverYourLands");
            }
            case 5: {
                return CFG.lang.get("TheDrumsOfWarBeatLoudlyAnnouncingTheBeginningOfYourDemiseUnderOurRule");
            }
        }
        return CFG.lang.get("TheBannersOfWarUnfurlMarkingTheBeginningOfTheEndForYourInsignificantCivilization");
    }

    public static final String getWarMessage(int id) {
        switch (id % 7) {
            case 0: {
                return CFG.lang.get("WitnessTheMightOfMyForcesAsWeDeclareWarUponYouForYourWeaknessCannotWithstandOurStrength");
            }
            case 1: {
                return CFG.lang.get("BraceYourselfForIDeclareWarUponYouToAssertMyRightfulAuthorityOverYourTerritories");
            }
            case 2: {
                return CFG.lang.get("ThisWarIsTheDestinyYouCannotEscapeAsWeRiseToCrushYourFeebleResistance");
            }
            case 3: {
                return CFG.lang.get("YourLandsWillBeReshapedUnderOurBannerAsWarIsDeclaredToSecureOurRightfulDominion");
            }
            case 4: {
                return CFG.lang.get("PrepareForTheMarchOfOurArmiesAsWeDeclareWarToAssertOurDominanceOverYourLands");
            }
            case 5: {
                return CFG.lang.get("TheDrumsOfWarBeatLoudlyAnnouncingTheBeginningOfYourDemiseUnderOurRule");
            }
        }
        return CFG.lang.get("TheBannersOfWarUnfurlMarkingTheBeginningOfTheEndForYourInsignificantCivilization");
    }

    public static final String getImproveRelationsMessage() {
        switch (CFG.oR.nextInt(6)) {
            case 0: {
                return CFG.lang.get("TogetherWeCanAchieveAStabilityThatNeitherCouldAlone");
            }
            case 1: {
                return CFG.lang.get("WeSeekNotDominanceButUnderstandingAndLastingFriendship");
            }
            case 2: {
                return CFG.lang.get("LetThisBeTheDawnOfANewEraOfCooperationBetweenUs");
            }
            case 3: {
                return CFG.lang.get("OurPeoplesDeservePeaceLetUsGiveItToThemTogether");
            }
            case 4: {
                return CFG.lang.get("TheFutureIsBrighterWhenEnemiesBecomeAllies");
            }
        }
        return CFG.lang.get("LetUsSetAsideOurDifferencesAndBuildANewFutureUnited");
    }

    public static final String getImproveRelationsMessage(int id) {
        switch (id % 6) {
            case 0: {
                return CFG.lang.get("TogetherWeCanAchieveAStabilityThatNeitherCouldAlone");
            }
            case 1: {
                return CFG.lang.get("WeSeekNotDominanceButUnderstandingAndLastingFriendship");
            }
            case 2: {
                return CFG.lang.get("LetThisBeTheDawnOfANewEraOfCooperationBetweenUs");
            }
            case 3: {
                return CFG.lang.get("OurPeoplesDeservePeaceLetUsGiveItToThemTogether");
            }
            case 4: {
                return CFG.lang.get("TheFutureIsBrighterWhenEnemiesBecomeAllies");
            }
        }
        return CFG.lang.get("LetUsSetAsideOurDifferencesAndBuildANewFutureUnited");
    }

    public static final String getAllianceMessage() {
        switch (CFG.oR.nextInt(7)) {
            case 0: {
                return CFG.lang.get("TogetherWeShallStandStrongerThanEitherCouldAlone");
            }
            case 1: {
                return CFG.lang.get("AnAllianceBetweenUsWouldShakeTheWorldAndSecurePeace");
            }
            case 2: {
                return CFG.lang.get("YourEnemiesAreOursLetUsFaceThemSideBySide");
            }
            case 3: {
                return CFG.lang.get("JoinUsAndLetOurBannersFlyTogetherAcrossTheWorld");
            }
            case 4: {
                return CFG.lang.get("LetThisAllianceBeTheFoundationOfANewGoldenAge");
            }
            case 5: {
                return CFG.lang.get("AloneWeSurviveTogetherWeThrive");
            }
        }
        return CFG.lang.get("LetUsSecurePeaceThroughPowerAndAlliance");
    }

    public static final String getAllianceMessage(int id) {
        switch (id % 7) {
            case 0: {
                return CFG.lang.get("TogetherWeShallStandStrongerThanEitherCouldAlone");
            }
            case 1: {
                return CFG.lang.get("AnAllianceBetweenUsWouldShakeTheWorldAndSecurePeace");
            }
            case 2: {
                return CFG.lang.get("YourEnemiesAreOursLetUsFaceThemSideBySide");
            }
            case 3: {
                return CFG.lang.get("JoinUsAndLetOurBannersFlyTogetherAcrossTheWorld");
            }
            case 4: {
                return CFG.lang.get("LetThisAllianceBeTheFoundationOfANewGoldenAge");
            }
            case 5: {
                return CFG.lang.get("AloneWeSurviveTogetherWeThrive");
            }
        }
        return CFG.lang.get("LetUsSecurePeaceThroughPowerAndAlliance");
    }

    public static final String getUnionMessage() {
        switch (CFG.oR.nextInt(5)) {
            case 0: {
                return CFG.lang.get("LetUsUniteAsOnePeopleOneDestinyOneCivilization");
            }
            case 1: {
                return CFG.lang.get("OurFuturesAreStrongerTogetherLetUsBecomeOneCivilization");
            }
            case 2: {
                return CFG.lang.get("LetUsMergeOurStrengthsOurCulturesOurFatesForever");
            }
            case 3: {
                return CFG.lang.get("LetThisBeTheBeginningOfOneGreatAndUndividedEmpire");
            }
        }
        return CFG.lang.get("OurStrengthsOurValuesOurPeopleShallBeOneFromThisDay");
    }

    public static final String getUnionMessage(int id) {
        switch (id % 5) {
            case 0: {
                return CFG.lang.get("LetUsUniteAsOnePeopleOneDestinyOneCivilization");
            }
            case 1: {
                return CFG.lang.get("OurFuturesAreStrongerTogetherLetUsBecomeOneCivilization");
            }
            case 2: {
                return CFG.lang.get("LetUsMergeOurStrengthsOurCulturesOurFatesForever");
            }
            case 3: {
                return CFG.lang.get("LetThisBeTheBeginningOfOneGreatAndUndividedEmpire");
            }
        }
        return CFG.lang.get("OurStrengthsOurValuesOurPeopleShallBeOneFromThisDay");
    }

    public static String getDefensivePactMessage() {
        switch (CFG.oR.nextInt(5)) {
            case 0: {
                return CFG.lang.get("OurEnemiesWillThinkTwiceIfTheyKnowYouDoNotStandAlone");
            }
            case 1: {
                return CFG.lang.get("InDangerWeWillNotAbandonYouAndWeAskTheSameInReturn");
            }
            case 2: {
                return CFG.lang.get("WhenOneIsAttackedBothWillAnswerThisIsOurOath");
            }
            case 3: {
                return CFG.lang.get("TogetherWeCreateABarrierNoEnemyCanBreach");
            }
        }
        return CFG.lang.get("WeStandReadyToDefendYourBordersAsWeDoOurOwn");
    }

    public static String getDefensivePactMessage(int id) {
        switch (id % 5) {
            case 0: {
                return CFG.lang.get("OurEnemiesWillThinkTwiceIfTheyKnowYouDoNotStandAlone");
            }
            case 1: {
                return CFG.lang.get("InDangerWeWillNotAbandonYouAndWeAskTheSameInReturn");
            }
            case 2: {
                return CFG.lang.get("WhenOneIsAttackedBothWillAnswerThisIsOurOath");
            }
            case 3: {
                return CFG.lang.get("TogetherWeCreateABarrierNoEnemyCanBreach");
            }
        }
        return CFG.lang.get("WeStandReadyToDefendYourBordersAsWeDoOurOwn");
    }

    public static String getNonAggressionPactMessage() {
        switch (CFG.oR.nextInt(6)) {
            case 0: {
                return CFG.lang.get("WeSwearToRespectYourBordersAndExpectTheSameInReturn");
            }
            case 1: {
                return CFG.lang.get("LetUsAvoidTheFiresOfWarAndKeepPeaceBetweenUs");
            }
            case 2: {
                return CFG.lang.get("WeOfferYouThePromiseOfNonAggressionForMutualBenefit");
            }
            case 3: {
                return CFG.lang.get("MayOurCivilizationsCoexistWithoutTheShadowOfWar");
            }
            case 4: {
                return CFG.lang.get("LetThisPactMarkTheEndOfHostilityBetweenUs");
            }
        }
        return CFG.lang.get("LetUsPutAsideOurDifferencesAndAvoidNeedlessWar");
    }

    public static final String getNonAggressionPactMessage(int id) {
        switch (id % 6) {
            case 0: {
                return CFG.lang.get("WeSwearToRespectYourBordersAndExpectTheSameInReturn");
            }
            case 1: {
                return CFG.lang.get("LetUsAvoidTheFiresOfWarAndKeepPeaceBetweenUs");
            }
            case 2: {
                return CFG.lang.get("WeOfferYouThePromiseOfNonAggressionForMutualBenefit");
            }
            case 3: {
                return CFG.lang.get("MayOurCivilizationsCoexistWithoutTheShadowOfWar");
            }
            case 4: {
                return CFG.lang.get("LetThisPactMarkTheEndOfHostilityBetweenUs");
            }
        }
        return CFG.lang.get("LetUsPutAsideOurDifferencesAndAvoidNeedlessWar");
    }

    public static float getSanctionsImpact(int byCivID, int onCivID) {
        long byCivEco = CFG.core.getCiv(byCivID).countEco();
        long worldEco = 0L;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.core.getCiv(i).getNumOfProvs() > 0) {
                worldEco += CFG.core.getCiv(i).countEco();
            }
        }
        long sanctionedGroupSupport = CFG.core.getCiv(onCivID).countEco();
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (i == onCivID || CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
            float relation = CFG.core.getCiv(i).getRelationD(onCivID);
            if (relation < 10.0f) continue;
            if (CFG.core.getCiv(i).getAlliance() > 0 && CFG.core.getCiv(i).getAlliance() == CFG.core.getCiv(onCivID).getAlliance()) {
                sanctionedGroupSupport += CFG.core.getCiv(i).countEco();
                continue;
            }
            if (relation >= 50.0f) {
                sanctionedGroupSupport += CFG.core.getCiv(i).countEco();
                continue;
            }
            if (relation >= 30.0f) {
                sanctionedGroupSupport += (long)((double)CFG.core.getCiv(i).countEco() * 0.5);
            }
        }
        float impact = (float)((double)byCivEco / (double)Math.max(1L, worldEco - byCivEco + sanctionedGroupSupport)) * 1.0f;
        return Math.min(0.99f, impact);
    }

    public static boolean imposeSanctions(int byCivID, int onCivID, int turns) {
        return GameManager.imposeSanctions(byCivID, onCivID, turns, false, true);
    }

    public static boolean imposeSanctions(int byCivID, int onCivID, int turns, boolean free, boolean chain) {
        if (!free && CFG.core.getCiv(byCivID).getDiploPoints() < GameValues.gvSanctions.COST_SANCTIONS_DIPLOMACY_POINTS) {
            return false;
        }
        if (CFG.core.getCiv(onCivID).areSanctionsAdded(byCivID, onCivID)) {
            return false;
        }
        if (!free) {
            CFG.core.getCiv(byCivID).setDiploPoints(CFG.core.getCiv(byCivID).getDiploPoints() - GameValues.gvSanctions.COST_SANCTIONS_DIPLOMACY_POINTS);
        }
        CFG.core.getCiv(onCivID).addNewSanctions(new Civilization_Sanctions(byCivID, onCivID, GameManager.getSanctionsImpact(byCivID, onCivID), GameCalendar.TURNID + turns));
        if (!CFG.core.getCivsAtWar(byCivID, onCivID)) {
            CFG.core.getCiv(byCivID).setRelationD(onCivID, CFG.core.getCiv(byCivID).getRelationD(onCivID) + GameValues.gvSanctions.RELATIONS_CHANGE);
            CFG.core.getCiv(onCivID).setRelationD(byCivID, CFG.core.getCiv(onCivID).getRelationD(byCivID) + GameValues.gvSanctions.RELATIONS_CHANGE);
        }
        if (chain) {
            for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
                if (i == byCivID || i == onCivID || CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
                Civilization joiningCiv = CFG.core.getCiv(i);
                boolean join = false;
                if (joiningCiv.getAlliance() > 0 && joiningCiv.getAlliance() == CFG.core.getCiv(byCivID).getAlliance()) {
                    if (CFG.oR.nextInt(100) < 85) {
                        join = true;
                    }
                } else if (joiningCiv.getRelationD(byCivID) >= 75.0f) {
                    if (CFG.oR.nextInt(100) < 65) {
                        join = true;
                    }
                } else if (joiningCiv.getRelationD(byCivID) >= 50.0f) {
                    if (CFG.oR.nextInt(100) < 55) {
                        join = true;
                    }
                }
                if (!join) continue;
                GameManager.imposeSanctions(i, onCivID, turns, true, false);
            }
        }
        if (CFG.core.getCiv(onCivID).getIsPlayer()) {
            CFG.core.getCiv((int)onCivID).getCivDiploGD().messageBox.addMessage(new Message_Sanctioned(byCivID));
        }
        return true;
    }

    public static void sendInviteToHRE(int nCivA, int nCivB) {
        if (CFG.hreMgr.getHRE().getIsPrince(nCivA) && !CFG.hreMgr.getHRE().getIsPrince(nCivB)) {
            CFG.hreMgr.getHRE().addPrince(nCivB);
            CFG.toastM.addM(CFG.lang.get("Civilization") + " " + CFG.lang.get("Invited") + ": " + CFG.core.getCiv(nCivB).getCivName());
        }
    }

    public static void sendJoinToHRE(int nCivID) {
        if (!CFG.hreMgr.getHRE().getIsPrince(nCivID)) {
            CFG.hreMgr.getHRE().addPrince(nCivID);
            CFG.toastM.addM(CFG.lang.get("Joined") + ": " + CFG.lang.get("HolyRomanEmpire"));
        }
    }

    public static void sendLeaveHRE(int nCivID) {
        if (CFG.hreMgr.getHRE().getIsPrince(nCivID)) {
            CFG.hreMgr.getHRE().removePrince(nCivID);
            CFG.toastM.addM(CFG.lang.get("Removed") + ": " + CFG.lang.get("HolyRomanEmpire"));
        }
    }

    public static void sendDissolveHRE(int nCivID) {
        if (CFG.hreMgr.getHRE().getIsEmperor(nCivID)) {
            CFG.hreMgr.getHRE().dissolveHRE();
            CFG.toastM.addM(CFG.lang.get("Dissolved") + ": " + CFG.lang.get("HolyRomanEmpire"));
        }
    }

    public static void sendUniteHRE(int nCivID) {
        if (CFG.hreMgr.getHRE().getIsEmperor(nCivID) && CFG.hreMgr.getHRE().canUnitHRE()) {
            CFG.hreMgr.getHRE().uniteHRE(nCivID);
            CFG.toastM.addM(CFG.lang.get("United") + ": " + CFG.lang.get("HolyRomanEmpire"));
        }
    }

    public static void sendBecomeVassal(int nCivA, int nCivB) {
        if (CFG.core.getCiv(nCivA).getPuppetOfCiv() == nCivA) {
            CFG.core.getCiv(nCivA).setPuppetOfCivId(nCivB);
            CFG.core.getCiv(nCivB).addVassal(nCivA);
            CFG.toastM.addM(CFG.lang.get("VassalOf") + ": " + CFG.core.getCiv(nCivB).getCivName());
            CFG.updateActiveCivilizationInfoInGame();
        }
    }

    public static void sendFightCoalition(int nCivA, int nCivB) {
        CFG.gameAction.fightCoalition(nCivB);
        CFG.toastM.addM(CFG.lang.get("FightTheCoalition") + "!");
    }
}











