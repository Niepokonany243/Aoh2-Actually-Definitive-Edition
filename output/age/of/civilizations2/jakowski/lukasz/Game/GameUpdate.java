/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Game;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.MapA.Distance;
import age.of.civilizations2.jakowski.lukasz.Messages.Info.Message_HighInflation;
import age.of.civilizations2.jakowski.lukasz.Parallel;
import age.of.civilizations2.jakowski.lukasz.Province;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.codedisaster.steamworks.SteamFriends;
import com.codedisaster.steamworks.SteamID;

public class GameUpdate {
    public static final float TAXES_INFLUENCE_POP = 0.3f;
    public long inflationMaxIncomeAllCivs = 100L;
    public static float LEAGUE_BUDGET = 1.0f;

    public final float getHappinessChange_ByTaxation(int nCivID) {
        return GameValues.gvTaxation.HAPPINESS_CHANGE_BASE + ((CFG.ideologiesMgr.getAcceptableTaxation(CFG.core.getCiv(nCivID).getIdeology(), nCivID) + CFG.ideologiesMgr.getAcceptableTaxation(CFG.core.getCiv(nCivID).getIdeology(), nCivID) * CFG.core.getCiv(nCivID).getTechLevel() / 21.73f) * 100.0f - CFG.core.getCiv(nCivID).getTaxationLvl() * 100.0f) * GameValues.gvTaxation.HAPPINESS_CHANGE_MODIFIER;
    }

    public final float getHappinessChange_ByTaxation_Occupied(int nCivID) {
        return GameValues.gvTaxation.HAPPINESS_CHANGE_BASE_OCCUPIED + ((CFG.ideologiesMgr.getAcceptableTaxation(CFG.core.getCiv(nCivID).getIdeology(), nCivID) + CFG.ideologiesMgr.getAcceptableTaxation(CFG.core.getCiv(nCivID).getIdeology(), nCivID) * CFG.core.getCiv(nCivID).getTechLevel() / 21.73f) * 100.0f - CFG.core.getCiv(nCivID).getTaxationLvl() * 100.0f) * GameValues.gvTaxation.HAPPINESS_CHANGE_MODIFIER;
    }

    public final float getIncome_DebuffWarReparations(int nCivID) {
        float tempTotal = 0.0f;
        for (int i = CFG.core.getCiv(nCivID).getWarReparationsPaysSize() - 1; i >= 0; --i) {
            tempTotal -= this.getWarReparations_Money(nCivID);
        }
        return tempTotal;
    }

    public final float getIncome_BuffWarReparations(int nCivID) {
        float tempTotal = 0.0f;
        for (int i = CFG.core.getCiv(nCivID).getWarReparationsGetsSize() - 1; i >= 0; --i) {
            tempTotal += this.getWarReparations_Money(CFG.core.getCiv((int)nCivID).getWarReparationsGets((int)i).iFromCivID);
        }
        return tempTotal;
    }

    public final float getWarReparations_Money(int nCivID) {
        return (float)CFG.core.getCiv((int)nCivID).incomeTaxation * GameValues.gvPeaceTreaty.PERCENTAGE_OF_INCOME_FOR_WAR_REPARATIONS;
    }

    public final long getMilitaryUpkeep_Total(int nCivID) {
        int i;
        double tempTotal = 0.0;
        for (i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
            int tempProvID = CFG.core.getCiv(nCivID).getProvID(i);
            tempTotal += (double)this.getMilitaryUpkeepP(tempProvID, nCivID);
            for (int vi = 0; vi < CFG.core.getProv(tempProvID).getCivsSize(); ++vi) {
                int vassalArmyCivID = CFG.core.getProv(tempProvID).getCivId(vi);
                if (vassalArmyCivID > 0 && CFG.core.getCiv(vassalArmyCivID).getPuppetOfCiv() == nCivID && vassalArmyCivID != nCivID) {
                    tempTotal += (double)this.getMilitaryUpkeepP(tempProvID, CFG.core.getProv(tempProvID).getArmyID(vi), nCivID);
                }
            }
        }
        for (i = 0; i < CFG.core.getCiv(nCivID).getArmyInAnotherProvinceSize(); ++i) {
            tempTotal += (double)this.getMilitaryUpkeepP(CFG.core.getCiv(nCivID).getArmyInAnotherProviP(i), nCivID);
        }
        for (i = 0; i < CFG.core.getCiv(nCivID).moveUnitsSize(); ++i) {
            tempTotal += (double)this.getMilitaryUpkeepP(CFG.core.getCiv(nCivID).getMoveUnits(i).getFromProviID(), (long)CFG.core.getCiv(nCivID).getMoveUnits(i).getNumberOfUnits(), nCivID);
        }
        for (i = 0; i < CFG.core.getCiv(nCivID).getMoveUnitsPlunderSize(); ++i) {
            tempTotal += (double)this.getMilitaryUpkeepP(CFG.core.getCiv(nCivID).getMoveUnitsPlunder(i).getFromProvinceID(), (long)CFG.core.getCiv(nCivID).getMoveUnitsPlunder(i).getNumOfUnits(), nCivID);
        }
        tempTotal += (double)((float)CFG.core.getCiv(nCivID).civGD.iMissiles * 0.25f);
        for (i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); i++) {
            if (CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).provGD.iAirDefense > 0) {
                tempTotal += (double)((float)CFG.core.getProv(CFG.core.getCiv(nCivID).getProvID(i)).provGD.iAirDefense * 5.0f);
            }
        }
        return (long)Math.ceil(tempTotal);
    }

    public final float getMilitaryUpkeep_WithAllRecruitmentsInProcess(int nProvinceID, long nArmy, int nCivID) {
        float out = 0.0f;
        Civilization civ = CFG.core.getCiv(nCivID);
        for (int i = 0; i < civ.getRecruitArmySize(); ++i) {
            if (civ.getRecruitArmy(i).getProvinceID() == nProvinceID) continue;
            out += this.getMilitaryUpkeepP(civ.getRecruitArmy(i).getProvinceID(), (long)civ.getRecruitArmy(i).getArmy(), nCivID);
        }
        return out + this.getMilitaryUpkeepP(nProvinceID, nArmy, nCivID);
    }

    public final float getMilitaryUpkeep_WithAllRecruitmentsInProcess_Disband(int nProvinceID, long nArmy, int nCivID) {
        float out = 0.0f;
        Civilization civ = CFG.core.getCiv(nCivID);
        for (int i = 0; i < civ.getRecruitArmySize(); ++i) {
            if (civ.getRecruitArmy(i).getProvinceID() == nProvinceID) continue;
            out += this.getMilitaryUpkeepP(civ.getRecruitArmy(i).getProvinceID(), (long)civ.getRecruitArmy(i).getArmy(), nCivID);
        }
        return out - this.getMilitaryUpkeepP(nProvinceID, nArmy, nCivID);
    }

    public final float getMilitaryUpkeepP(int nProvinceID, long nArmy, int nCivID) {
        Province province = CFG.core.getProv(nProvinceID);
        Civilization civ = CFG.core.getCiv(nCivID);
        return (float)Math.pow((float)nArmy * CFG.gameAges.getAge_MilitaryUpkeep(GameCalendar.CURRENT_AGEID), GameValues.gvMilitary.UPKEEP_MIN + GameValues.gvMilitary.UPKEEP_DEVELOPMENT * province.getDeveLvl() + GameValues.gvMilitary.UPKEEP_TECHNOLOGY_LEVEL * civ.getTechLevel()) * (1.0f + CFG.terrainTypesManager.getMilitaryUpkeep(province.getTerrainTypeID())) * CFG.ideologiesMgr.getMilitaryUpkeep(civ.getIdeology(), nCivID) * CFG.gameAges.getAge_TreasuryModifier_MilitaryUpkeep(GameCalendar.CURRENT_AGEID) * (1.0f + (float)civ.getNumOfProvs() / (float)CFG.core.getProvinSize() * GameValues.gvMilitary.UPKEEP_CIV_PROVINCES_SHARE_PERC_OF_ALL + civ.getWarWeariness() + civ.getModifier_MilitaryUpkeep() - BuildingsManager.getSupply_Bonus(province.getLvlOfSupply())) * GameCalendar.GAME_SPEED * (1.0f - (civ.isAtWarC() || civ.civGD.civPlans.isPreparingForTheWar() ? 0.0f : this.getMilitaryUpkeepDefensivePosition(nProvinceID)));
    }

    public final float getMilitaryUpkeep_WithoutDefensivePosition(int nProvinceID, long nArmy, int nCivID) {
        Province province = CFG.core.getProv(nProvinceID);
        Civilization civ = CFG.core.getCiv(nCivID);
        return (float)Math.pow((float)nArmy * CFG.gameAges.getAge_MilitaryUpkeep(GameCalendar.CURRENT_AGEID), GameValues.gvMilitary.UPKEEP_MIN + GameValues.gvMilitary.UPKEEP_DEVELOPMENT * province.getDeveLvl() + GameValues.gvMilitary.UPKEEP_TECHNOLOGY_LEVEL * civ.getTechLevel()) * (1.0f + CFG.terrainTypesManager.getMilitaryUpkeep(province.getTerrainTypeID())) * CFG.ideologiesMgr.getMilitaryUpkeep(civ.getIdeology(), nCivID) * CFG.gameAges.getAge_TreasuryModifier_MilitaryUpkeep(GameCalendar.CURRENT_AGEID) * (1.0f + (float)civ.getNumOfProvs() / (float)CFG.core.getProvinSize() * GameValues.gvMilitary.UPKEEP_CIV_PROVINCES_SHARE_PERC_OF_ALL + civ.getWarWeariness() + civ.getModifier_MilitaryUpkeep() - BuildingsManager.getSupply_Bonus(province.getLvlOfSupply())) * GameCalendar.GAME_SPEED;
    }

    public final float getMilitaryUpkeepDefensivePosition(int nProvinceID) {
        return GameValues.gvDefensivePosition.DEFENSIVE_POSITION_MILITARY_UPKEEP_PER_TUR * (float)CFG.core.getProv(nProvinceID).getDefensivePosition();
    }

    public final float getProvIncomeAndExpenses_Total(int nProvinceID) {
        return this.getProvIncomeTaxation(nProvinceID) + this.getProvIncomeProduction(nProvinceID) - (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getCapitalProvID() >= 0 ? this.getProvinceAdministrationCost(nProvinceID, CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getCapitalProvID()) : 0.0f);
    }

    public final float getProvIncomeTaxation(int nProvinceID) {
        return this.getProvIncomeTaxation(nProvinceID, CFG.core.getProv(nProvinceID).getCivId(), this.taxIncome_Modifier(CFG.core.getProv(nProvinceID).getCivId()));
    }

    public final float getProvIncomeTaxation(int nProvinceID, int nCivID, float incomeModifier) {
        if (CFG.core.getProv(nProvinceID).isOccupied() && CFG.core.getCiv(nCivID).getIdeology() != CFG.ideologiesMgr.REBELS_ID) {
            return this.getProvinceAdministrationCost(nProvinceID, CFG.gameUpdate.getAdministration_Capital(nCivID));
        }
        return (CFG.core.getProv((int)nProvinceID).provGD.wonderBuilt ? GameValues.gvWonder.INCOME_TAXATION : 0.0f) + (float)(Math.pow((float)this.getProvince_EmploymentPopulation(nProvinceID) * (CFG.gameAges.getAge_IncomeTaxationBase(GameCalendar.CURRENT_AGEID) + CFG.gameAges.getAge_IncomeTaxation_PerTechnology(GameCalendar.CURRENT_AGEID) * CFG.core.getCiv(nCivID).getTechLevel() * GameValues.gvIncomeTaxation.TECHNOLOGY_LEVEL_TAX_INCOME_MULTIPLIER), GameValues.gvIncomeTaxation.EMPLOYED_POPULATION_TAX_EXPONENT) + Math.pow((float)this.getProvUnemploymentPopulation(nProvinceID) * (CFG.gameAges.getAge_IncomeTaxationBase(GameCalendar.CURRENT_AGEID) + CFG.gameAges.getAge_IncomeTaxation_PerTechnology(GameCalendar.CURRENT_AGEID) * CFG.core.getCiv(nCivID).getTechLevel() * GameValues.gvIncomeTaxation.TECHNOLOGY_LEVEL_TAX_INCOME_MULTIPLIER), GameValues.gvIncomeTaxation.UNEMPLOYED_TAX_EXPONENT)) * CFG.gameAges.getAge_TreasuryModifier(GameCalendar.CURRENT_AGEID) * (GameValues.gvIncomeTaxation.PROV_STABILITY_TAX_BASE + GameValues.gvIncomeTaxation.PROV_STABILITY_TAX_MODIFIER * CFG.core.getProv(nProvinceID).getProviStability()) * (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).INCOME_TAXATION + BuildingsManager.getMarket_IncomeTaxation(CFG.core.getProv(nProvinceID).getLvlOfMarket()) + CFG.core.getCiv(nCivID).getModifier_IncomeTaxation() + (CFG.core.getProv(nProvinceID).isCapital() ? GameValues.gvIncomeTaxation.CAPITAL_TAX_BONUS_MODIFIER : 0.0f) + GameValues.gvIncomeTaxation.PROV_HAPPINESS_TAX_BASE_PENALTY + GameValues.gvIncomeTaxation.PROV_HAPPINESS_TAX_MODIFIER_PER_HAPPINESS * CFG.core.getProv(nProvinceID).getHappi()) * (0.7f + 0.3f * CFG.core.getCiv(nCivID).getTaxationLvl()) * incomeModifier * 0.5f * (1.0f - CFG.core.getCiv((int)nCivID).sanctionsImpact) * GameCalendar.GAME_SPEED;
    }

    public final long getProvince_EmploymentPopulation(int nProvinceID) {
        return (long)Math.min((float)CFG.core.getProv(nProvinceID).getPop().getPops(), (float)CFG.core.getProv(nProvinceID).getEco() * (GameValues.gvIncome.EMPLOYMENT_PER_ECONOMY_POPULATION_TAXATION + GameValues.gvIncome.EMPLOYMENT_DEV_MODIFIER * CFG.core.getProv(nProvinceID).getDeveLvl() + GameValues.gvIncome.EMPLOYMENT_TECH_MODIFIER * CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel()));
    }

    public final int getMilitarySpending(int nCivID, long iBudget) {
        return Math.max(0, (int)(this.getMilitaryUpkeep_Total(nCivID) / (float)iBudget * 100.0f));
    }

    public final float getMilitarySpending2(int nCivID, long iBudget) {
        return Math.max(0.0f, this.getMilitaryUpkeep_Total(nCivID) / (float)iBudget * 100.0f);
    }

    public final long getIncome(int nCivID) {
        long tempTotal = 0L;
        tempTotal += CFG.core.getCiv((int)nCivID).incomeTaxation;
        tempTotal += CFG.core.getCiv((int)nCivID).incomeProduction;
        tempTotal += (long)this.getIncome_FromVassalsOfCiv(nCivID);
        tempTotal += (long)this.getIncome_Debuff_IsVassal(nCivID);
        tempTotal += (long)this.getIncome_BuffWarReparations(nCivID);
        return tempTotal + (long)this.getIncome_DebuffWarReparations(nCivID);
    }

    public final float getIncome_TaxesLevel(int nCivID) {
        return this.getIncome_TaxesLevel_Taxation(nCivID) + this.getIncome_TaxesLevel_Production(nCivID);
    }

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    public final float getIncome_TaxesLevel_Taxation(int nCivID) {
        float tempTotal = 0.0f;
        for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
            tempTotal += this.getProvIncomeTaxation(CFG.core.getCiv(nCivID).getProvID(i));
        }
        return tempTotal;
    }

    public final float getIncome_TaxesLevel_Production(int nCivID) {
        float tempTotal = 0.0f;
        for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
            tempTotal += this.getProvIncomeProduction(CFG.core.getCiv(nCivID).getProvID(i));
        }
        return tempTotal;
    }

    public final float getIncomeVassals(int nForCivID, int nIsVassal) {
        if (CFG.core.getCiv(nIsVassal).getPuppetOfCiv() == nForCivID) {
            return this.getVassalizationMoney(nIsVassal);
        }
        return 0.0f;
    }

    public final float getVassalizationMoney(int nVassalID) {
        return (float)CFG.core.getCiv((int)nVassalID).incomeTaxation * ((float)CFG.core.getCiv(CFG.core.getCiv(nVassalID).getPuppetOfCiv()).getVassal_Tribute(nVassalID) / 100.0f);
    }

    public final float getInvestments_Total(int nCivID, long iBudget) {
        return this.getResearchSpending(nCivID, iBudget) + this.getInvestmentsSpending(nCivID, iBudget);
    }

    public String getFriendName(SteamID steamIDFriend) {
        return sUM.uSF.getFriendPersonaName(steamIDFriend);
    }

    public void openFriendsOverlay(SteamFriends.OverlayDialog dialog) {
        sUM.uSF.activateGameOverlay(dialog);
    }

    public void openCommunity(SteamFriends.OverlayDialog dialog) {
        sUM.uSF.activateGameOverlay(dialog);
    }

    public final float getInvestmentsSpending(int nCivID, long iBudget) {
        return (float)iBudget * CFG.core.getCiv(nCivID).getSpendingInvestmentsB();
    }

    public final void updateSpendingOfCivID(int nCivID, long iBudget) {
        Civilization civ = CFG.core.getCiv(nCivID);
        civ.updateNumberOfUnits();
        if (CFG.SANDBOX_MODE && !CFG.PXSX) {
            if (civ.getIsPlayer()) {
                return;
            }
        }
        if (CFG.SANDBOX_MODE_AI && !civ.getIsPlayer()) {
            return;
        }
        if (civ.getCapitalProvID() >= 0 && civ.getNumOfProvs() > 0) {
            int tempMilitary;
            if (civ.getGold() < (long)GameValues.gvTechnology.MIN_MONEY_REQUIRED_TO_ENABLE_RESEARCH) {
                civ.setSpendingResearchB(0.0f);
            }
            if (iBudget <= 0L) {
                civ.setSpendingGoodsB(0.0f);
                civ.setSpendingResearchB(0.0f);
                civ.setSpendingInvestmentsB(0.0f);
            }
            if ((tempMilitary = this.getMilitarySpending(nCivID, iBudget)) + (int)(civ.getSpendingGoodsB() * 100.0f) > GameValues.gvAiBudget.BUDGET_MAX) {
                civ.setSpendingGoodsB((float)(GameValues.gvAiBudget.BUDGET_MAX - tempMilitary) / 100.0f);
            }
            if ((tempMilitary += (int)(civ.getSpendingGoodsB() * 100.0f)) + (int)(civ.getSpendingResearchB() * 100.0f) + (int)(civ.getSpendingInvestmentsB() * 100.0f) > GameValues.gvAiBudget.BUDGET_MAX) {
                if (tempMilitary > GameValues.gvAiBudget.BUDGET_MAX) {
                    civ.setSpendingResearchB(0.0f);
                    civ.setSpendingInvestmentsB(0.0f);
                    return;
                }
                int overBudget = (int)(civ.getSpendingResearchB() * 100.0f) + (int)(civ.getSpendingInvestmentsB() * 100.0f) + tempMilitary - GameValues.gvAiBudget.BUDGET_MAX;
                int tempBef = (int)(civ.getSpendingResearchB() * 100.0f);
                civ.setSpendingResearchB(civ.getSpendingResearchB() - (float)overBudget / 2.0f / 100.0f);
                overBudget -= (int)((float)tempBef - civ.getSpendingResearchB() * 100.0f);
                if ((float)overBudget < civ.getSpendingInvestmentsB() * 100.0f) {
                    civ.setSpendingInvestmentsB(civ.getSpendingInvestmentsB() - (float)overBudget / 100.0f);
                } else {
                    civ.setSpendingInvestmentsB(0.0f);
                    civ.setSpendingResearchB(civ.getSpendingResearchB() - (float)(overBudget -= (int)(civ.getSpendingInvestmentsB() * 100.0f)) / 100.0f);
                }
            }
        }
    }

    public final float getMilitaryUpkeepP(int nProvinceID, int nCivID) {
        return this.getMilitaryUpkeepP(nProvinceID, CFG.core.getProv(nProvinceID).getArmyCivID1(nCivID), nCivID);
    }

    public final float getMilitaryUpkeep_PlusMoveUnits(int nProvinceID, int nCivID) {
        return this.getMilitaryUpkeepP(nProvinceID, CFG.core.getProv(nProvinceID).getArmyCivID1(nCivID) + CFG.core.getCiv(nCivID).getMoveUnits_NumFromProvince(nProvinceID), nCivID);
    }

    public final int getAdministration_Capital(int nCivID) {
        Civilization civ = CFG.core.getCiv(nCivID);
        return civ.getCapitalProvID() < 0 ? (civ.getNumOfProvs() > 0 ? civ.getProvID(0) : 0) : civ.getCapitalProvID();
    }

    public float taxIncome_Modifier(int nCivID) {
        if (CFG.core.getCiv(nCivID).getIsPlayer()) {
            switch (CFG.DIFFICULTY) {
                case 0: {
                    return GameValues.gvDifficulty.TAX_INCOME_MODIFIER_PLAYER_BEGINNER;
                }
                case 1: {
                    return GameValues.gvDifficulty.TAX_INCOME_MODIFIER_PLAYER_NORMAL;
                }
                case 2: {
                    return GameValues.gvDifficulty.TAX_INCOME_MODIFIER_PLAYER_HARD;
                }
                case 3: {
                    return GameValues.gvDifficulty.TAX_INCOME_MODIFIER_PLAYER_EXTREME;
                }
                case 4: {
                    return GameValues.gvDifficulty.TAX_INCOME_MODIFIER_PLAYER_LEGENDARY;
                }
            }
        }
        switch (CFG.DIFFICULTY) {
            case 0: {
                return GameValues.gvDifficulty.TAX_INCOME_MODIFIER_NON_PLAYER_BEGINNER;
            }
            case 1: {
                return GameValues.gvDifficulty.TAX_INCOME_MODIFIER_NON_PLAYER_NORMAL;
            }
            case 2: {
                return GameValues.gvDifficulty.TAX_INCOME_MODIFIER_NON_PLAYER_HARD;
            }
            case 3: {
                return GameValues.gvDifficulty.TAX_INCOME_MODIFIER_NON_PLAYER_EXTREME;
            }
            case 4: {
                return GameValues.gvDifficulty.TAX_INCOME_MODIFIER_NON_PLAYER_LEGENDARY;
            }
        }
        return 1.0f;
    }

    public final float getIncome_Debuff_IsVassal(int nCivID) {
        if (CFG.core.getCiv(nCivID).getPuppetOfCiv() != nCivID) {
            return -this.getIncomeVassals(CFG.core.getCiv(nCivID).getPuppetOfCiv(), nCivID);
        }
        return 0.0f;
    }

    public final long getProvUnemploymentPopulation(int nProvinceID) {
        return (long)Math.max(CFG.core.getProv(nProvinceID).getPop().getPops() - this.getProvince_EmploymentPopulation(nProvinceID), 0L);
    }

    public final long getEmploymentPopulation(int nCivID) {
        long out = 0L;
        for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
            out += this.getProvince_EmploymentPopulation(CFG.core.getCiv(nCivID).getProvID(i));
        }
        return out;
    }

    public final float getProvIncomeProduction(int nProvinceID, int nCivID, float incomeModifer) {
        Civilization civ = CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId());
        Province province = CFG.core.getProv(nProvinceID);
        if (province.isOccupied() && civ.getIdeology() != CFG.ideologiesMgr.REBELS_ID) {
            return (float)((int)province.getEco()) * (CFG.gameAges.getAge_IncomeProductionBase(GameCalendar.CURRENT_AGEID) + CFG.gameAges.getAge_IncomeProduction_PerDev(GameCalendar.CURRENT_AGEID) * province.getDeveLvl()) * (GameValues.gvIncomeProduction.BASE_PRODUCTION_EFFICIENCY + GameValues.gvIncomeProduction.PRODUCTION_EFFICIENCY_PER_TECH_LVL * civ.getTechLevel() + GameValues.gvIncomeProduction.PRODUCTION_EFFICIENCY_PER_DEVELOPMENT * province.getDeveLvl()) * (GameValues.gvIncomeProduction.PROV_STABILITY_BASE + GameValues.gvIncomeProduction.PROV_STABILITY_MODIFIER * province.getProviStability()) * CFG.gameAges.getAge_TreasuryModifier_Production(GameCalendar.CURRENT_AGEID) * (CFG.ideologiesMgr.getIncomeProduction(civ.getIdeology(), nCivID) + BuildingsManager.getPort_IncomeProduction(province.getLvlOfPort()) + civ.getModifier_IncomeProduction() + (province.isCapital() ? GameValues.gvIncomeProduction.CAPITAL_PRODUCTION_BONUS_MODIFIER : 0.0f) + BuildingsManager.getWorkshop_IncomeProduction(province.getLvlOfWorkshop())) * (1.0f - GameValues.gvIncomeProduction.TAXATION_LEVEL_INFLUENCE_PRODUCTION + GameValues.gvIncomeProduction.TAXATION_LEVEL_INFLUENCE_PRODUCTION * CFG.core.getCiv(nCivID).getTaxationLvl()) * incomeModifer * 2.0f * (1.0f - CFG.core.getCiv((int)nCivID).sanctionsImpact) * GameCalendar.GAME_SPEED * GameValues.gvIncomeProduction.OCCUPIED_PROVINCE_INCOME_PRODUCTION_MODIFIER;
        }
        return (float)((int)province.getEco()) * (CFG.gameAges.getAge_IncomeProductionBase(GameCalendar.CURRENT_AGEID) + CFG.gameAges.getAge_IncomeProduction_PerDev(GameCalendar.CURRENT_AGEID) * province.getDeveLvl()) * (GameValues.gvIncomeProduction.BASE_PRODUCTION_EFFICIENCY + GameValues.gvIncomeProduction.PRODUCTION_EFFICIENCY_PER_TECH_LVL * civ.getTechLevel() + GameValues.gvIncomeProduction.PRODUCTION_EFFICIENCY_PER_DEVELOPMENT * province.getDeveLvl()) * (GameValues.gvIncomeProduction.PROV_STABILITY_BASE + GameValues.gvIncomeProduction.PROV_STABILITY_MODIFIER * province.getProviStability()) * CFG.gameAges.getAge_TreasuryModifier_Production(GameCalendar.CURRENT_AGEID) * (CFG.ideologiesMgr.getIncomeProduction(civ.getIdeology(), nCivID) + BuildingsManager.getPort_IncomeProduction(province.getLvlOfPort()) + civ.getModifier_IncomeProduction() + (province.isCapital() ? GameValues.gvIncomeProduction.CAPITAL_PRODUCTION_BONUS_MODIFIER : 0.0f) + BuildingsManager.getWorkshop_IncomeProduction(province.getLvlOfWorkshop())) * (1.0f - GameValues.gvIncomeProduction.TAXATION_LEVEL_INFLUENCE_PRODUCTION + GameValues.gvIncomeProduction.TAXATION_LEVEL_INFLUENCE_PRODUCTION * CFG.core.getCiv(nCivID).getTaxationLvl()) * incomeModifer * 2.0f * (1.0f - CFG.core.getCiv((int)nCivID).sanctionsImpact) * GameCalendar.GAME_SPEED;
    }

    public float getMaxProvEconomy(int nProvinceID) {
        Civilization civ = CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId());
        Province province = CFG.core.getProv(nProvinceID);
        return (float)province.getPop().getPops() * (GameValues.gvIncome.EMPLOYMENT_PER_ECONOMY_INCOME_PRODUCTION + GameValues.gvIncomeProduction.DEVELOPMENT_EMPLOYMENT_BONUS_PER_DEV * province.getDeveLvl() + GameValues.gvIncomeProduction.TECH_EMPLOYMENT_BONUS_PER_TECH_LEVEL * civ.getTechLevel());
    }

    public final long getExpenses(int nCivID) {
        double tempTotal = 0.0;
        tempTotal += (double)CFG.core.getCiv((int)nCivID).administrationCosts;
        tempTotal += (double)this.getMilitaryUpkeep_Total(nCivID);
        tempTotal += (double)this.getInvestments_Total(nCivID, CFG.core.getCiv((int)nCivID).iBudget);
        tempTotal += (double)this.getGoodsSpending(nCivID, CFG.core.getCiv((int)nCivID).iBudget);
        tempTotal += (double)this.getInflationInterestCost(nCivID);
        tempTotal += (double)this.getInflation(nCivID);
        tempTotal += (double)CFG.core.getCiv(nCivID).getLoans_GoldTotalPerTurn();
        return (long)Math.ceil(tempTotal += (double)CFG.core.getCiv(nCivID).getLoansFromCiv_GoldTotalPerTurn());
    }

    public final long getResearchSpending_Long(int nCivID, long iBudget) {
        return (long)((double)iBudget * (double)CFG.core.getCiv(nCivID).getSpendingResearchB());
    }

    public final long getGoodsSpending_Long(int nCivID, long iBudget) {
        return (long)((double)iBudget * (double)CFG.core.getCiv(nCivID).getSpendingGoodsB());
    }

    public final float getIncome_FromVassalsOfCiv(int nCivID) {
        float tempTotal = 0.0f;
        for (int i = CFG.core.getCiv((int)nCivID).civGD.vassals.size() - 1; i >= 0; --i) {
            tempTotal += this.getIncomeVassals(nCivID, CFG.core.getCiv((int)nCivID).civGD.vassals.get((int)i).iCivID);
        }
        return tempTotal;
    }

    public final float getExpenses_Budget(int nCivID) {
        float tempTotal = 0.0f;
        return (int)Math.ceil(tempTotal += (float)CFG.core.getCiv((int)nCivID).administrationCosts);
    }

    public String getPlayerName() {
        return sUM.uSF.getPersonaName();
    }

    public int getFriends(SteamFriends.FriendFlags friendFlag) {
        return sUM.uSF.getFriendCount(friendFlag);
    }

    public void openProfile(SteamFriends.OverlayToUserDialog dialog, SteamID steamID) {
        sUM.uSF.activateGameOverlayToUser(dialog, steamID);
    }

    public void openWeb(String url, SteamFriends.OverlayToWebPageMode mode) {
        sUM.uSF.activateGameOverlayToWebPage(url, mode);
    }

    public final void updatePlayableProvinces() {
        int i;
        CFG.oAI.PLAYABLE_PROVINCES = 0;
        for (i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getSeaProv() || CFG.core.getProv(i).getWastelandLvl() >= 0) continue;
            ++CFG.oAI.PLAYABLE_PROVINCES;
        }
        CFG.oAI.NUM_OF_CIVS_IN_THE_GAME = 0;
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
            ++CFG.oAI.NUM_OF_CIVS_IN_THE_GAME;
        }
        CFG.oAI.NUM_OF_CIVS_IN_THE_GAME = Math.max(1, CFG.oAI.NUM_OF_CIVS_IN_THE_GAME);
        CFG.oAI.updateMinRivals();
    }

    public final void updateInflationPeakValueAllCivs() {
        int i;
        this.inflationMaxIncomeAllCivs = 1;
        for (i = 1; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.core.getCiv(i).getNumOfProvs() <= 0) continue;
            this.inflationMaxIncomeAllCivs = Math.max(this.inflationMaxIncomeAllCivs, CFG.core.getCiv((int)i).incomeTaxation + CFG.core.getCiv((int)i).incomeProduction);
            LEAGUE_BUDGET = Math.max(LEAGUE_BUDGET, (float)(CFG.core.getCiv((int)i).incomeTaxation + CFG.core.getCiv((int)i).incomeProduction - CFG.core.getCiv((int)i).administrationCosts));
        }
        LEAGUE_BUDGET = LEAGUE_BUDGET * 0.9f;
        final float fLeagueBudget = LEAGUE_BUDGET;
        Parallel.range(1, CFG.core.getCivsSize(), (int civIdx) -> {
            if (CFG.core.getCiv(civIdx).getNumOfProvs() <= 0) return;
            CFG.core.getCiv(civIdx).iLeague = Math.min((int)((float)Math.max(CFG.core.getCiv((int)civIdx).incomeTaxation + CFG.core.getCiv((int)civIdx).incomeProduction - CFG.core.getCiv((int)civIdx).administrationCosts, 0) / fLeagueBudget * 10.0f), 10);
        });
        if (!CFG.SANDBOX_MODE && !CFG.PXSX) {
            for (i = 0; i < CFG.core.getPlayersSize(); ++i) {
                if (!(this.getInflationPerc(CFG.core.getPlayer(i).getCivId()) > GameValues.gvInflation.SEND_HIGH_INFLATION_MESS_IF_OVER)) continue;
                CFG.core.getCiv((int)CFG.core.getPlayer((int)i).getCivId()).getCivDiploGD().messageBox.addMessage(new Message_HighInflation(CFG.core.getPlayer(i).getCivId(), 0));
            }
        }
    }

    public final void updateCivs_Money() {
        Parallel.range(1, CFG.core.getCivsSize(), (int i) -> {
            this.getBalance_UpdateBudgetPrepare(i);
        });
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            Civilization civ = CFG.core.getCiv(i);
            if (civ.getNumOfProvs() > 0) {
                civ.setGold(civ.getGold() + (long)this.getBalanceCivId(i));
                civ.updateLoansNextTurn();
                civ.updateLoansFromCivNextTurn();
            }
        }
    }

    public void setStatus(String status) {
        sUM.uSF.setRichPresence("status", status);
    }

    public void updatePresence(String key, String value) {
        sUM.uSF.setRichPresence(key, value);
    }

    public void clearStatus() {
        sUM.uSF.clearRichPresence();
    }

    public int lastUpdateTurnID = -1;

    public final void updatePrvStability() {
        if (this.lastUpdateTurnID == GameCalendar.TURNID) {
            return;
        }
        this.lastUpdateTurnID = GameCalendar.TURNID;
        int i;
        for (i = 1 + GameCalendar.TURNID % GameValues.gvUpdate.UPDATE_PROVINCE_STABILITY; i < CFG.core.getCivsSize(); i += GameValues.gvUpdate.UPDATE_PROVINCE_STABILITY) {
            Civilization civ = CFG.core.getCiv(i);
            civ.provincesWithLowStability.clear();
            civ.fStability = 0.0f;
        }
        for (i = 1 + GameCalendar.TURNID % GameValues.gvUpdate.UPDATE_PROVINCE_STABILITY; i < CFG.core.getCivsSize(); i += GameValues.gvUpdate.UPDATE_PROVINCE_STABILITY) {
            for (int j = 0; j < CFG.core.getCiv(i).getNumOfProvs(); ++j) {
                Province province = CFG.core.getProv(CFG.core.getCiv(i).getProvID(j));
                if (province.getSeaProv() || province.getWastelandLvl() >= 0) continue;
                province.updateProvStability();
                CFG.core.getCiv((int)province.getCivId()).fStability += province.getProviStability();
            }
        }
        for (i = 1 + GameCalendar.TURNID % GameValues.gvUpdate.UPDATE_PROVINCE_STABILITY; i < CFG.core.getCivsSize(); i += GameValues.gvUpdate.UPDATE_PROVINCE_STABILITY) {
            Civilization civ = CFG.core.getCiv(i);
            civ.setStabilityCiv(civ.fStability / (float)civ.getNumOfProvs());
        }
        for (i = 0; i < CFG.core.getProvinSize(); i++) {
            CFG.core.getProv(i).updateOccupationTurns();
        }
    }

    public final long getUnemploymentPop(int nCivID) {
        long out = 0L;
        for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
            out += this.getProvUnemploymentPopulation(CFG.core.getCiv(nCivID).getProvID(i));
        }
        return out;
    }

    public final float getResearchSpending(int nCivID, long iBudget) {
        return (float)iBudget * CFG.core.getCiv(nCivID).getSpendingResearchB();
    }

    public final float getGoodsSpending(int nCivID, long iBudget) {
        return (float)iBudget * CFG.core.getCiv(nCivID).getSpendingGoodsB();
    }

    public final float getProvIncomeProduction(int nProvinceID) {
        return this.getProvIncomeProduction(nProvinceID, CFG.core.getProv(nProvinceID).getCivId(), this.taxIncome_Modifier(CFG.core.getProv(nProvinceID).getCivId()));
    }

    public final void updateProvinceStabilityAllProvinces() {
        if (this.lastUpdateTurnID == GameCalendar.TURNID) {
            return;
        }
        this.lastUpdateTurnID = GameCalendar.TURNID;
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            Civilization civ = CFG.core.getCiv(i);
            civ.provincesWithLowStability.clear();
            civ.fStability = 0.0f;
        }
        for (int i = 0; i < CFG.core.getProvinSize(); i++) {
            Province province = CFG.core.getProv(i);
            if (!province.getSeaProv() && province.getWastelandLvl() < 0) {
                province.updateProvStability();
            }
        }
        for (int i = 0; i < CFG.core.getProvinSize(); i++) {
            CFG.core.getProv(i).updateOccupationTurns();
        }
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            Province province = CFG.core.getProv(i);
            if (province.getSeaProv() || province.getWastelandLvl() >= 0 || province.getCivId() <= 0) continue;
            CFG.core.getCiv((int)province.getCivId()).fStability += province.getProviStability();
        }
        for (int i = 1; i < CFG.core.getCivsSize(); ++i) {
            Civilization civ = CFG.core.getCiv(i);
            for (int j = civ.provincesWithLowStability.size() - 1; j >= 0; --j) {
                if (!civ.isAssimilateOrganized(civ.provincesWithLowStability.get(j))) continue;
                civ.provincesWithLowStability.remove(j);
            }
            if (civ.getNumOfProvs() > 0) {
                civ.setStabilityCiv(civ.fStability / (float)civ.getNumOfProvs());
            }
        }
    }

    public final long getBalanceCivId(int nCivID) {
        return (long)(this.getIncome(nCivID) - this.getExpenses(nCivID));
    }

    public final float getInflation(int nCivID) {
        if (CFG.settingsGD.DISABLE_INFLATION) {
            return 0.0f;
        }
        if ((float)CFG.core.getCiv(nCivID).getGold() < GameValues.gvInflation.INFLATION_MIN_GOLD_IN_TREASURY) {
            return 0.0f;
        }
        try {
            if ((float)CFG.core.getCiv(nCivID).getGold() / (((float)this.inflationMaxIncomeAllCivs * GameValues.gvInflation.INFLATION_MAX_TREASURY_MODIFIER + (float)(CFG.core.getCiv((int)nCivID).incomeTaxation + CFG.core.getCiv((int)nCivID).incomeProduction) * GameValues.gvInflation.INFLATION_CIV_INCOME_MODIFIER) * GameValues.gvInflation.INFLATION_GOLD_MODIFIER) > GameValues.gvInflation.INFLATION_STARTS_AT) {
                return 1.0f + (float)CFG.core.getCiv(nCivID).getGold() * ((float)CFG.core.getCiv(nCivID).getGold() / ((float)this.inflationMaxIncomeAllCivs * GameValues.gvInflation.INFLATION_GOLD_MODIFIER) - GameValues.gvInflation.INFLATION_STARTS_AT) * GameValues.gvInflation.INFLATION_VALUE_MODIFIER;
            }
        }
        catch (Exception ex) {
            return 0.0f;
        }
        return 0.0f;
    }

    public final float getInflationPerc(int nCivID) {
        return Math.max(this.getInflation(nCivID) / (float)CFG.core.getCiv(nCivID).getGold(), 0.0f);
    }

    public final float getInflationInterestCost(int nCivID) {
        if (CFG.core.getCiv(nCivID).getGold() < 0L) {
            return Math.min((float)Math.abs(CFG.core.getCiv(nCivID).getGold()) * GameValues.gvInflation.INTEREST_RATE_TREASURY_PERC, Math.abs((float)CFG.core.getCiv((int)nCivID).iBudget * GameValues.gvInflation.INTEREST_RATE_BUDGET_PERC));
        }
        return 0.0f;
    }

    public final float getAdministrationCost_Update(int nCivID) {
        float tempTotal = 0.0f;
        try {
            for (int i = 0; i < CFG.core.getCiv(nCivID).getNumOfProvs(); ++i) {
                tempTotal += this.getProvinceAdministrationCost(CFG.core.getCiv(nCivID).getProvID(i), CFG.gameUpdate.getAdministration_Capital(nCivID));
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return tempTotal;
    }

    public final float getProvinceAdministrationCost(int nProvinceID, int nCapital) {
        Province province = CFG.core.getProv(nProvinceID);
        if (province.isOccupied()) return 0.0f;
        Civilization civ = CFG.core.getCiv((int)province.getCivId());
        float maxEco = this.getMaxProvEconomy(nProvinceID);
        float curEco = Math.max(1.0f, (float)province.getEco());
        float devRatio = Math.min(1.0f, curEco / maxEco);
        float devFactor;
        if (devRatio < 0.05f) devFactor = 0.8f;
        else if (devRatio < 0.10f) devFactor = 0.9f;
        else if (devRatio < 0.20f) devFactor = 1.0f;
        else if (devRatio < 0.35f) devFactor = 1.1f;
        else if (devRatio < 0.55f) devFactor = 1.1f;
        else if (devRatio < 0.75f) devFactor = 1.0f;
        else devFactor = 0.8f;
        float happiness = Math.max(0.001f, Math.min(1.0f, province.getHappi()));
        float stability = Math.max(0.001f, Math.min(1.0f, province.getProviStability()));
        int numProvs = Math.max(1, civ.getNumOfProvs());
        float adminPerc = 0.25f * devFactor * (1.0f + 0.3f * (1.0f - happiness)) * (1.0f + 0.3f * (1.0f - stability)) * (1.0f + 0.1f * (float)Math.log(1.0f + (float)numProvs / 10.0f)) / (1.0f + 0.03f * civ.getTechLevel()) * (1.0f + 0.3f * (1.0f - happiness) * CFG.ideologiesMgr.getIdeologyID((int)civ.getIdeology()).ADMINISTRATION_COST_DISTANCE) * (nProvinceID == nCapital ? 0.5f : 1.0f) * (CFG.ideologiesMgr.getAdministration(civ.getIdeology(), (int)province.getCivId()) + civ.getModifier_Administation()) * CFG.gameAges.getAge_TreasuryModifier_Administration(GameCalendar.CURRENT_AGEID) * GameCalendar.GAME_SPEED;
        float taxationIncome = Math.max(1.0f, this.getProvIncomeTaxation(nProvinceID));
        return Math.min(taxationIncome * adminPerc, 2.0f * taxationIncome);
    }

    public final float getProvinceAdminQuality(int nProvinceID) {
        Province province = CFG.core.getProv(nProvinceID);
        float maxEco = this.getMaxProvEconomy(nProvinceID);
        float curEco = Math.max(1.0f, (float)province.getEco());
        float devRatio = Math.min(1.0f, curEco / maxEco);
        float happiness = Math.max(0.001f, Math.min(1.0f, province.getHappi()));
        float stability = Math.max(0.001f, Math.min(1.0f, province.getProviStability()));
        return devRatio * 0.35f + happiness * 0.3f + stability * 0.35f;
    }

    public final float getAdministrationEfficiency(int nCivID) {
        if (nCivID <= 0) return 0.5f;
        Civilization civ = CFG.core.getCiv(nCivID);
        if (civ.getNumOfProvs() <= 0) return 0.5f;
        float totalRatio = 0.0f;
        int nCapital = this.getAdministration_Capital(nCivID);
        int count = 0;
        for (int i = 0; i < civ.getNumOfProvs(); ++i) {
            int provID = civ.getProvID(i);
            if (CFG.core.getProv(provID).isOccupied()) continue;
            float adminCost = this.getProvinceAdministrationCost(provID, nCapital);
            float totalIncome = this.getProvIncomeTaxation(provID) + this.getProvIncomeProduction(provID);
            if (totalIncome <= 0.0f || adminCost <= 0.0f) {
                totalRatio += 0.5f;
            } else {
                totalRatio += Math.min(4.0f, totalIncome / Math.max(1.0f, adminCost));
            }
            ++count;
        }
        float avgRatio = totalRatio / (float)Math.max(1, count);
        float efficiency = Math.max(0.1f, Math.min(1.0f, avgRatio / 2.0f));
        float sizeFactor = 1.0f - 0.05f * (float)Math.log(1.0f + (float)Math.max(1, civ.getNumOfProvs()) / 10.0f);
        float techFactor = 1.0f + 0.02f * civ.getTechLevel();
        float ideologyFactor = CFG.ideologiesMgr.getAdministration(civ.getIdeology(), nCivID);
        efficiency = efficiency * Math.max(0.5f, sizeFactor) * techFactor / ideologyFactor;
        return Math.max(0.1f, Math.min(1.0f, efficiency));
    }

    public final void getBalance_UpdateBudgetPrepare(int nCivID) {
        Civilization civ = CFG.core.getCiv(nCivID);
        civ.incomeTaxation = 0;
        civ.incomeProduction = 0;
        civ.administrationCosts = 0;
        int nCapital = this.getAdministration_Capital(nCivID);
        float incomeModifier = this.taxIncome_Modifier(nCivID);
        
        for (int i = 0; i < civ.getNumOfProvs(); ++i) {
            int provID = civ.getProvID(i);
            Province province = CFG.core.getProv(provID);
            province.incomeTaxation = this.getProvIncomeTaxation(provID, nCivID, incomeModifier);
            province.incomeProduction = this.getProvIncomeProduction(provID, nCivID, incomeModifier);
            province.administrationCost = Math.min(province.incomeTaxation + province.incomeProduction, this.getProvinceAdministrationCost(provID, nCapital));
            civ.incomeTaxation += (long)province.incomeTaxation;
            civ.incomeProduction += (long)province.incomeProduction;
        }
        civ.administrationCosts = 0L;
        civ.iBudget = (long)this.getIncome(nCivID);
    }
}
