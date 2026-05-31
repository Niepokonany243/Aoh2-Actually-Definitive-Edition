
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;

public class SkillsManager {
    public static final boolean canAdd_PopGrowth(int nCivID) {
        return CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_POP_GROWTH < GameValues.gvTechnology.MAX_POINTS_POP_GROWTH;
    }

    public static final void add_PopGrowth(int nCivID) {
        if (CFG.core.getCiv((int)nCivID).civGD.techPoints.getPointsLeft(nCivID) <= 0) {
            return;
        }
        CFG.core.getCiv((int)nCivID).civGD.modifier_PopGrowth -= (float)CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_POP_GROWTH * GameValues.gvTechnology.PER_POINT_POP_GROWTH / 100.0f;
        CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_POP_GROWTH = Math.min(CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_POP_GROWTH + 1, GameValues.gvTechnology.MAX_POINTS_POP_GROWTH);
        CFG.core.getCiv((int)nCivID).civGD.modifier_PopGrowth += (float)CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_POP_GROWTH * GameValues.gvTechnology.PER_POINT_POP_GROWTH / 100.0f;
    }

    public static final boolean canAdd_EcoGrowth(int nCivID) {
        return CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_ECONOMY_GROWTH < GameValues.gvTechnology.MAX_POINTS_ECONOMY_GROWTH;
    }

    public static final void add_EcoGrowth(int nCivID) {
        if (CFG.core.getCiv((int)nCivID).civGD.techPoints.getPointsLeft(nCivID) <= 0) {
            return;
        }
        CFG.core.getCiv((int)nCivID).civGD.modifier_EconomyGrowth -= (float)CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_ECONOMY_GROWTH * GameValues.gvTechnology.PER_POINT_ECONOMY_GROWTH / 100.0f;
        CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_ECONOMY_GROWTH = Math.min(CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_ECONOMY_GROWTH + 1, GameValues.gvTechnology.MAX_POINTS_ECONOMY_GROWTH);
        CFG.core.getCiv((int)nCivID).civGD.modifier_EconomyGrowth += (float)CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_ECONOMY_GROWTH * GameValues.gvTechnology.PER_POINT_ECONOMY_GROWTH / 100.0f;
    }

    public static final boolean canAdd_IncomeTaxation(int nCivID) {
        return CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_INCOME_TAXATION < GameValues.gvTechnology.MAX_POINTS_INCOME_TAXATION;
    }

    public static final void add_IncomeTaxation(int nCivID) {
        if (CFG.core.getCiv((int)nCivID).civGD.techPoints.getPointsLeft(nCivID) <= 0) {
            return;
        }
        CFG.core.getCiv((int)nCivID).civGD.modifier_IncomeTaxation -= (float)CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_INCOME_TAXATION * GameValues.gvTechnology.PER_POINT_INCOME_TAXATION / 100.0f;
        CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_INCOME_TAXATION = Math.min(CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_INCOME_TAXATION + 1, GameValues.gvTechnology.MAX_POINTS_INCOME_TAXATION);
        CFG.core.getCiv((int)nCivID).civGD.modifier_IncomeTaxation += (float)CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_INCOME_TAXATION * GameValues.gvTechnology.PER_POINT_INCOME_TAXATION / 100.0f;
    }

    public static final boolean canAdd_IncomeProduction(int nCivID) {
        return CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_INCOME_PRODUCTION < GameValues.gvTechnology.MAX_POINTS_INCOME_PRODUCTION;
    }

    public static final void add_IncomeProduction(int nCivID) {
        if (CFG.core.getCiv((int)nCivID).civGD.techPoints.getPointsLeft(nCivID) <= 0) {
            return;
        }
        CFG.core.getCiv((int)nCivID).civGD.modifier_IncomeProduction -= (float)CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_INCOME_PRODUCTION * GameValues.gvTechnology.PER_POINT_INCOME_PRODUCTION / 100.0f;
        CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_INCOME_PRODUCTION = Math.min(CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_INCOME_PRODUCTION + 1, GameValues.gvTechnology.MAX_POINTS_INCOME_PRODUCTION);
        CFG.core.getCiv((int)nCivID).civGD.modifier_IncomeProduction += (float)CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_INCOME_PRODUCTION * GameValues.gvTechnology.PER_POINT_INCOME_PRODUCTION / 100.0f;
    }

    public static final boolean canAdd_Administration(int nCivID) {
        return CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_ADMINISTRATION < GameValues.gvTechnology.MAX_POINTS_ADMINISTRATION;
    }

    public static final void add_Administration(int nCivID) {
        if (CFG.core.getCiv((int)nCivID).civGD.techPoints.getPointsLeft(nCivID) <= 0) {
            return;
        }
        CFG.core.getCiv((int)nCivID).civGD.modifier_Administration += (float)CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_ADMINISTRATION * GameValues.gvTechnology.PER_POINT_ADMINISTRATION / 100.0f;
        CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_ADMINISTRATION = Math.min(CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_ADMINISTRATION + 1, GameValues.gvTechnology.MAX_POINTS_ADMINISTRATION);
        CFG.core.getCiv((int)nCivID).civGD.modifier_Administration -= (float)CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_ADMINISTRATION * GameValues.gvTechnology.PER_POINT_ADMINISTRATION / 100.0f;
    }

    public static final boolean canAdd_MilitaryUpkeep(int nCivID) {
        return CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_MILITARY_UPKEEP < GameValues.gvTechnology.MAX_POINTS_MILITARY_UPKEEP;
    }

    public static final void add_MilitaryUpkeep(int nCivID) {
        if (CFG.core.getCiv((int)nCivID).civGD.techPoints.getPointsLeft(nCivID) <= 0) {
            return;
        }
        CFG.core.getCiv((int)nCivID).civGD.modifier_MilitaryUpkeep += (float)CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_MILITARY_UPKEEP * GameValues.gvTechnology.PER_POINT_MILITARY_UPKEEP / 100.0f;
        CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_MILITARY_UPKEEP = Math.min(CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_MILITARY_UPKEEP + 1, GameValues.gvTechnology.MAX_POINTS_MILITARY_UPKEEP);
        CFG.core.getCiv((int)nCivID).civGD.modifier_MilitaryUpkeep -= (float)CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_MILITARY_UPKEEP * GameValues.gvTechnology.PER_POINT_MILITARY_UPKEEP / 100.0f;
    }

    public static final boolean canAdd_Research(int nCivID) {
        return CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_RESEARCH < GameValues.gvTechnology.MAX_POINTS_RESEARCH;
    }

    public static final void add_Research(int nCivID) {
        if (CFG.core.getCiv((int)nCivID).civGD.techPoints.getPointsLeft(nCivID) <= 0) {
            return;
        }
        CFG.core.getCiv((int)nCivID).civGD.modifier_Research -= (float)CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_RESEARCH * GameValues.gvTechnology.PER_POINT_RESEARCH / 100.0f;
        CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_RESEARCH = Math.min(CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_RESEARCH + 1, GameValues.gvTechnology.MAX_POINTS_RESEARCH);
        CFG.core.getCiv((int)nCivID).civGD.modifier_Research += (float)CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_RESEARCH * GameValues.gvTechnology.PER_POINT_RESEARCH / 100.0f;
    }

    public static final boolean canAdd_Colonization(int nCivID) {
        return CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_COLONIZATION < GameValues.gvTechnology.MAX_POINTS_COLONIZATION;
    }

    public static final void add_Colonization(int nCivID) {
        if (CFG.core.getCiv((int)nCivID).civGD.techPoints.getPointsLeft(nCivID) <= 0) {
            return;
        }
        CFG.core.getCiv((int)nCivID).civGD.modifier_ColonizationCost -= (float)CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_COLONIZATION * GameValues.gvTechnology.PER_POINT_COLONIZATION / 100.0f;
        CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_COLONIZATION = Math.min(CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_COLONIZATION + 1, GameValues.gvTechnology.MAX_POINTS_COLONIZATION);
        CFG.core.getCiv((int)nCivID).civGD.modifier_ColonizationCost += (float)CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_COLONIZATION * GameValues.gvTechnology.PER_POINT_COLONIZATION / 100.0f;
    }

    public static final boolean canAdd_Movement(int nCivID) {
        return CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_MOVEMENT < GameValues.gvTechnology.MAX_POINTS_MOVEMENT;
    }

    public static final void add_Movement(int nCivID) {
        if (CFG.core.getCiv((int)nCivID).civGD.techPoints.getPointsLeft(nCivID) <= 0) {
            return;
        }
        CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_MOVEMENT = Math.min(CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_MOVEMENT + 1, GameValues.gvTechnology.MAX_POINTS_MOVEMENT);
    }

    public static final boolean canAdd_Recruitable(int nCivID) {
        return CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_RECRUITABLE < GameValues.gvTechnology.MAX_POINTS_RECRUITABLE;
    }

    public static final void add_Recruitable(int nCivID) {
        if (CFG.core.getCiv((int)nCivID).civGD.techPoints.getPointsLeft(nCivID) <= 0) {
            return;
        }
        CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_RECRUITABLE = Math.min(CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_RECRUITABLE + 1, GameValues.gvTechnology.MAX_POINTS_RECRUITABLE);
    }

    public static final boolean canAdd_Assimilate(int nCivID) {
        return CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_ASSIMILATE < GameValues.gvTechnology.MAX_POINTS_ASSIMILATE;
    }

    public static final void add_Assimilate(int nCivID) {
        if (CFG.core.getCiv((int)nCivID).civGD.techPoints.getPointsLeft(nCivID) <= 0) {
            return;
        }
        CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_ASSIMILATE = Math.min(CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_ASSIMILATE + 1, GameValues.gvTechnology.MAX_POINTS_ASSIMILATE);
    }
}

