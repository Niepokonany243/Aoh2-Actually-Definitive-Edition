
package age.of.civilizations2.jakowski.lukasz.AI.AI_Skills;

import age.of.civilizations2.jakowski.lukasz.AI.AI_Skills.AI_Skills;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.SkillsManager;

public class AI_Skills_Movement
extends AI_Skills {
    public AI_Skills_Movement(int iPoints, int iPointsMax) {
        super(iPoints, iPointsMax);
    }

    @Override
    public void addPoint_CivID(int nCivID) {
        SkillsManager.add_Movement(nCivID);
        this.iPoints = CFG.core.getCiv((int)nCivID).civGD.techPoints.POINTS_MOVEMENT;
    }

    @Override
    public float getScore_Personality(int nCivID) {
        return CFG.core.getCiv((int)nCivID).TECH_MOVEMENT;
    }
}

