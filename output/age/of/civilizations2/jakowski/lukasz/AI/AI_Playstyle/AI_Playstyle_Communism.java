
package age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle;

import age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle.AIPlaystyle;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;

public class AI_Playstyle_Communism
extends AIPlaystyle {
    public AI_Playstyle_Communism() {
        this.TAG = "COMMUNISM";
        this.PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT = 0.15f;
        this.PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM = 14;
        this.PERSONALITY_MIN_HAPPINESS_DEFAULT = 56;
        this.PERSONALITY_MIN_HAPPINESS_RANDOM = 18;
        this.PERSONALITY_FORGIVENESS_DEFAULT = 0.6f;
        this.PERSONALITY_FORGIVENESS_RANDOM = 80;
        this.USE_OF_BUDGET_FOR_SPENDINGS = 38;
        this.USE_OF_BUDGET_FOR_SPENDINGS_RANDOM = 62;
    }

    @Override
    public void buildStartingBuildings(int nCivID) {
        block3: {
            super.buildStartingBuildings(nCivID);
            try {
                if (CFG.core.getCiv(nCivID).getCapitalProvID() >= 0 && CFG.core.getCiv(nCivID).getTechLevel() >= BuildingsManager.getWorkshop_TechLevel(1) * 0.92f) {
                    CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).setLvlOfWorkshop(Math.max(CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getLvlOfWorkshop(), 1));
                }
            }
            catch (IndexOutOfBoundsException ex) {
                if (!CFG.LOGs) break block3;
                CFG.exceptionStack(ex);
            }
        }
    }
}

