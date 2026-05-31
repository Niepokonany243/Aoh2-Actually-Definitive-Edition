/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.AI.AI_Skills;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.SkillsManager;

public class AI_Skills {
    public int iPoints;
    public int iPointsMax;

    public AI_Skills(int iPoints, int iPointsMax) {
        this.iPoints = iPoints;
        this.iPointsMax = iPointsMax;
    }

    public void addPoint_CivID(int nCivID) {
        SkillsManager.add_PopGrowth(nCivID);
        this.iPoints = CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_POP_GROWTH;
    }

    public float getScore_Personality(int nCivID) {
        return CFG.core.getCiv((int)nCivID).TECH_POP;
    }

    public float getScore(int nCivID) {
        return this.getScore_Personality(nCivID) * (1.0f - (float)this.iPoints / (float)this.iPointsMax);
    }
}

