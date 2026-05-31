
package age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle;

import age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle.AIPlaystyle;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;

public class AI_Playstyle_Fascism
extends AIPlaystyle {
    public AI_Playstyle_Fascism() {
        this.TAG = "FASCISM";
        this.PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT = 0.14f;
        this.PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM = 18;
        this.PERSONALITY_MIN_HAPPINESS_DEFAULT = 68;
        this.PERSONALITY_MIN_HAPPINESS_RANDOM = 25;
        this.PERSONALITY_FORGIVENESS_DEFAULT = 0.9f;
        this.PERSONALITY_FORGIVENESS_RANDOM = 40;
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

