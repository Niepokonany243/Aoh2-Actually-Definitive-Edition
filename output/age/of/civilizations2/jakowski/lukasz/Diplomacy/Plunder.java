/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Diplomacy;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Messages.Province.Message_Plunder;
import age.of.civilizations2.jakowski.lukasz.Messages.Province.Message_Plunder_Plundred;

public class Plunder {
    public static final float plunderEfficiency(int nCivID, int nProvinceID, long nArmy) {
        return Math.min(1.0f, (float)nArmy / Plunder.plunderEfficiency_RequiredMAX(nCivID, nProvinceID));
    }

    public static final float plunderEfficiency_RequiredMAX(int nCivID, int nProvinceID) {
        return (float)CFG.core.getProv(nProvinceID).getPop().getPops() * (GameValues.gvPlunder.PLUNDER_MIN_ARMY_POP_RATIO + GameValues.gvPlunder.PLUNDER_MIN_ARMY_POP_RATIO_TECH_MODIFIER * Math.min(CFG.core.getCiv(nCivID).getTechLevel(), 1.0f));
    }

    public static final long plunderProvinceIncome(int nCivID, int nProvinceID, long nArmy) {
        return (long)(CFG.gameUpdate.getProvIncomeTaxation(nProvinceID) + CFG.gameUpdate.getProvIncomeProduction(nProvinceID));
    }

    public static final long plunderTreasuryIncome(int nCivID, int nProvinceID, long nArmy) {
        return (long)((float)Plunder.plunderProvinceIncome(nCivID, nProvinceID, nArmy) * GameValues.gvPlunder.PLUNDER_TAX_INCOME_MODIFIER * Plunder.plunderEfficiency(nCivID, nProvinceID, nArmy) * (1.0f - GameValues.gvPlunder.PLUNDER_INCOME_HIGH_REV_RISK_MODIFIER * CFG.core.getProv(nProvinceID).getRevRisk()) * CFG.PLUNDER_MODIFIER);
    }

    public static final float plunder_LossesEconomy_Perc(int nCivID, int nProvinceID, long nArmy) {
        return (GameValues.gvPlunder.PLUNDER_ECONOMY_LOSS_BASE_RATIO + (float)CFG.oR.nextInt(GameValues.gvPlunder.PLUNDER_ECONOMY_LOSS_RANDOM_RATIO_10000) / 10000.0f) * Plunder.plunderEfficiency(nCivID, nProvinceID, nArmy) * CFG.PLUNDER_MODIFIER;
    }

    public static final float plunder_LossesDevelopment_Perc(int nCivID, int nProvinceID, long nArmy) {
        return (GameValues.gvPlunder.PLUNDER_DEV_LOSS_BASE_RATIO + (float)CFG.oR.nextInt(GameValues.gvPlunder.PLUNDER_DEV_LOSS_RANDOM_RATIO_10000) / 10000.0f) * Plunder.plunderEfficiency(nCivID, nProvinceID, nArmy) * CFG.PLUNDER_MODIFIER;
    }

    public static final float plunder_Happiness(int nCivID, int nProvinceID, long nArmy) {
        return (GameValues.gvPlunder.PLUNDER_HAPPINESS_LOSS_BASE_RATIO + (float)CFG.oR.nextInt(GameValues.gvPlunder.PLUNDER_HAPPINESS_LOSS_RANDOM_RATIO_10000) / 10000.0f) * Plunder.plunderEfficiency(nCivID, nProvinceID, nArmy);
    }

    public static final float plunder_RevolutionaryRisk(int nCivID, int nProvinceID, long nArmy) {
        return Math.max((GameValues.gvPlunder.PLUNDER_REV_RISK_BASE_RATIO + (float)CFG.oR.nextInt(GameValues.gvPlunder.PLUNDER_REV_RISK_RANDOM_RATIO_10000) / 10000.0f) * Plunder.plunderEfficiency(nCivID, nProvinceID, nArmy), GameValues.gvPlunder.PLUNDER_REV_RISK_MIN);
    }

    public static final long plunder_Population(int nCivID, int nProvinceID, long nArmy) {
        return (long)(Math.min((float)nArmy * (GameValues.gvPlunder.PLUNDER_POP_LOSS_BASE_RATIO_ARMY + (float)CFG.oR.nextInt(GameValues.gvPlunder.PLUNDER_POP_LOSS_RANDOM_RATIO_10000_ARMY) / 10000.0f), (float)CFG.core.getProv(nProvinceID).getPop().getPops() * GameValues.gvPlunder.PLUNDER_POP_LOSS_BASE_RATIO_POPULATION) * CFG.PLUNDER_MODIFIER);
    }

    public static final void plunderProvince(int iCivID, int nProvinceID, long nArmy) {
        if (CFG.core.getCiv(iCivID).getMovemPoints() < CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)iCivID).getIdeology()).COST_OF_PLUNDER) {
            return;
        }
        if (nProvinceID < 0 || !CFG.core.getProv(nProvinceID).isOccupied() || CFG.core.getProv(nProvinceID).getSeaProv()) {
            return;
        }
        long currPlunderArmy = 0L;
        for (int i = 0; i < CFG.core.getCiv(iCivID).getMoveUnitsPlunderSize(); ++i) {
            if (CFG.core.getCiv(iCivID).getMoveUnitsPlunder(i).getFromProvinceID() != nProvinceID) continue;
            currPlunderArmy = CFG.core.getCiv(iCivID).getMoveUnitsPlunder(i).getNumOfUnits();
            if (nArmy != 0) break;
            CFG.core.getCiv(iCivID).removePlunder(i);
            CFG.core.getProv(nProvinceID).updateArmy4(iCivID, CFG.core.getProv(nProvinceID).getArmyCivID1((int)iCivID) + currPlunderArmy);
            if (currPlunderArmy > 0) {
                CFG.core.getCiv(iCivID).setMovementPoints(CFG.core.getCiv(iCivID).getMovemPoints() + CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)iCivID).getIdeology()).COST_OF_PLUNDER);
            }
            return;
        }
        if (nArmy > CFG.core.getProv(nProvinceID).getArmyCivID1((int)iCivID) + currPlunderArmy) {
            nArmy = CFG.core.getProv(nProvinceID).getArmyCivID1((int)iCivID) + currPlunderArmy;
        }
        if (nArmy <= 0) {
            return;
        }
        CFG.core.getCiv(iCivID).newPlunder(nProvinceID, nArmy);
        CFG.core.getProv(nProvinceID).updateArmy4(iCivID, CFG.core.getProv(nProvinceID).getArmyCivID1((int)iCivID) + currPlunderArmy - nArmy);
        if (currPlunderArmy == 0) {
            CFG.core.getCiv(iCivID).setMovementPoints(CFG.core.getCiv(iCivID).getMovemPoints() - CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)iCivID).getIdeology()).COST_OF_PLUNDER);
        }
    }

    public static final void plunder(int iCivID, int nProvinceID, long nArmy) {
        if (CFG.core.getProv(nProvinceID).getTrueOwnerOfProv() == iCivID) {
            return;
        }
        long nTreasury = Plunder.plunderTreasuryIncome(iCivID, nProvinceID, nArmy);
        float nHappiness = Plunder.plunder_Happiness(iCivID, nProvinceID, nArmy);
        int nEconomy = (int)((double)GameValues.gvPlunder.PLUNDER_ECONOMY_LOSS_BASE_MIN + Math.ceil((float)CFG.core.getProv(nProvinceID).getEco() * Plunder.plunder_LossesEconomy_Perc(iCivID, nProvinceID, nArmy)));
        float nDevelopment = CFG.core.getProv(nProvinceID).getDeveLvl() * Plunder.plunder_LossesDevelopment_Perc(iCivID, nProvinceID, nArmy);
        float fRevolutionary = Plunder.plunder_RevolutionaryRisk(iCivID, nProvinceID, nArmy) * CFG.PLUNDER_MODIFIER;
        long nPopulation = Plunder.plunder_Population(iCivID, nProvinceID, nArmy);
        long tempPopulationBefore = CFG.core.getProv(nProvinceID).getPop().getPops();
        long tempEconomyBefore = (long)CFG.core.getProv(nProvinceID).getEco();
        CFG.core.getCiv(iCivID).setGold(CFG.core.getCiv(iCivID).getGold() + (long)nTreasury);
        CFG.core.getProv(nProvinceID).setEco(CFG.core.getProv(nProvinceID).getEco() - nEconomy);
        CFG.core.getProv(nProvinceID).setDevLvl(CFG.core.getProv(nProvinceID).getDeveLvl() - nDevelopment);
        CFG.core.getProv(nProvinceID).setHappi(CFG.core.getProv(nProvinceID).getHappi() - nHappiness);
        CFG.core.getProv(nProvinceID).setRevRisk(CFG.core.getProv(nProvinceID).getRevRisk() + CFG.gameAges.getAge_RevolutionaryRiskModifier(GameCalendar.CURRENT_AGEID) * fRevolutionary);
        CFG.gameAction.updatePopulationLosses(nProvinceID, nPopulation);
        int tempWarID = CFG.core.getWarID(iCivID, CFG.core.getProv(nProvinceID).getTrueOwnerOfProv());
        if (tempWarID >= 0) {
            CFG.core.updateWarStatistics(tempWarID, iCivID, CFG.core.getProv(nProvinceID).getTrueOwnerOfProv(), Math.max(tempPopulationBefore - CFG.core.getProv(nProvinceID).getPop().getPops(), 0L), Math.max(tempEconomyBefore - (long)CFG.core.getProv(nProvinceID).getEco(), 0L));
        }
        if (CFG.core.getCiv(iCivID).getIsPlayer()) {
            CFG.core.getCiv((int)iCivID).getCivDiploGD().messageBox.addMessage(new Message_Plunder(iCivID, nProvinceID, (int)nTreasury, nEconomy, nDevelopment, nHappiness, nPopulation));
        }
        if (CFG.core.getCiv(CFG.core.getProv(nProvinceID).getTrueOwnerOfProv()).getIsPlayer()) {
            CFG.core.getCiv((int)CFG.core.getProv((int)nProvinceID).getTrueOwnerOfProv()).getCivDiploGD().messageBox.addMessage(new Message_Plunder_Plundred(iCivID, nProvinceID, nEconomy, nDevelopment, nHappiness, nPopulation));
        }
    }
}

