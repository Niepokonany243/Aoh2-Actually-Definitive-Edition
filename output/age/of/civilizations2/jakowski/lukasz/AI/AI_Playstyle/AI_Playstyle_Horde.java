/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle;

import age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle.AIPlaystyle;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;

public class AI_Playstyle_Horde
extends AIPlaystyle {
    public AI_Playstyle_Horde() {
        this.TAG = "HORDE";
        this.PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT = 0.22f;
        this.PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM = 16;
        this.PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT = 35.0f;
        this.PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM = 55;
        this.PERSONALITY_MIN_HAPPINESS_DEFAULT = 60;
        this.PERSONALITY_MIN_HAPPINESS_RANDOM = 20;
        this.PERSONALITY_FORGIVENESS_DEFAULT = 1.5f;
        this.PERSONALITY_FORGIVENESS_RANDOM = 50;
        this.PERSONALITY_PLUNDER_MIN = 10;
        this.PERSONALITY_PLUNDER_RANDOM = 325;
        this.PERSONALITY_PLUNDER_LOCK = 35;
        this.PERSONALITY_MIN_AGGRESSION_DEFAULT = 0.45f;
        this.PERSONALITY_MIN_AGGRESSION_RANDOM_100 = 12000;
    }

    @Override
    public void buildStartingBuildings(int nCivID) {
        block3: {
            super.buildStartingBuildings(nCivID);
            try {
                if (CFG.core.getCiv(nCivID).getCapitalProvID() >= 0 && CFG.core.getCiv(nCivID).getTechLevel() >= BuildingsManager.getArmoury_TechLevel(1) * 0.94f) {
                    CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).setLvlOfArmoury(Math.max(CFG.core.getProv(CFG.core.getCiv(nCivID).getCapitalProvID()).getLvlOfArmoury(), 1));
                }
            }
            catch (IndexOutOfBoundsException ex) {
                if (!CFG.LOGs) break block3;
                CFG.exceptionStack(ex);
            }
        }
    }
}

