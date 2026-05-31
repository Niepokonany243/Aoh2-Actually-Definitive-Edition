/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Diplomacy.Festivals;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.CivTask;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;

public class Festival {
    public static final long festivalCost(int nProvinceID) {
        return (long)((float)GameValues.gvFestival.FESTIVAL_COST_GOLD_BASE + (float)(CFG.gameUpdate.getProvIncomeTaxation(nProvinceID) + CFG.gameUpdate.getProvIncomeProduction(nProvinceID)) * (GameValues.gvFestival.FESTIVAL_COST_GOLD_BASE_MODIFIER + GameValues.gvFestival.FESTIVAL_COST_GOLD_TECH_LEVEL_MODIFIER * CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getTechLevel() + GameValues.gvFestival.FESTIVAL_COST_GOLD_ACTIVE_FESTIVAL_MODIFIER * (float)CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getFestivalsSize()));
    }

    public static final float festivalHappinessPerTurn(int nProvinceID) {
        return GameValues.gvFestival.HAPPINESS_GAIN_PER_TURN_BASE + GameValues.gvFestival.HAPPINESS_GAIN_PER_TURN_BASED_ON_PROVINCE_HAPPINESS_MODIFIER * (1.0f - CFG.core.getProv(nProvinceID).getHappi());
    }

    public static final float festivalHappinessPerTurn_NeighboringProvinces() {
        return GameValues.gvFestival.HAPPINESS_GAIN_NEIGHBORING_PROVINCES;
    }

    public static final boolean addFestival(int nCivID, int nProvinceID) {
        if ((nCivID == CFG.core.getProv(nProvinceID).getCivId() || nCivID == CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getPuppetOfCiv()) && CFG.core.getCiv(nCivID).getMovemPoints() >= GameValues.gvFestival.COST_FESTIVAL_MOVEMENT_POINTS && CFG.core.getCiv(nCivID).getGold() >= Festival.festivalCost(nProvinceID) && CFG.core.getCiv(nCivID).addFestival(new CivTask(nProvinceID, GameValues.gvFestival.FESTIVAL_NUM_OF_TURNS))) {
            CFG.core.getCiv(nCivID).setMovementPoints(CFG.core.getCiv(nCivID).getMovemPoints() - GameValues.gvFestival.COST_FESTIVAL_MOVEMENT_POINTS);
            long festivalCost = Festival.festivalCost(nProvinceID);
            CFG.core.getCiv(nCivID).setGold(CFG.core.getCiv(nCivID).getGold() - festivalCost);
            ++CFG.core.getCiv((int)nCivID).civGD.fE;
            CFG.core.getCiv((int)nCivID).civGD.fECG += festivalCost;
            if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                Core.addDiplomacyLines(CFG.core.getCapitalOrProvince(nCivID), nProvinceID, CFG.COLOR_HAPPINESS_MAX);
            }
            return true;
        }
        return false;
    }

    public static final boolean addFestivalFree(int nCivID, int nProvinceID) {
        if ((nCivID == CFG.core.getProv(nProvinceID).getCivId() || nCivID == CFG.core.getCiv(CFG.core.getProv(nProvinceID).getCivId()).getPuppetOfCiv()) && CFG.core.getCiv(nCivID).addFestival(new CivTask(nProvinceID, GameValues.gvFestival.FESTIVAL_NUM_OF_TURNS))) {
            ++CFG.core.getCiv((int)nCivID).civGD.fE;
            if (CFG.core.getCiv(nCivID).getIsPlayer()) {
                Core.addDiplomacyLines(CFG.core.getCapitalOrProvince(nCivID), nProvinceID, CFG.COLOR_HAPPINESS_MAX);
            }
            return true;
        }
        return false;
    }
}

