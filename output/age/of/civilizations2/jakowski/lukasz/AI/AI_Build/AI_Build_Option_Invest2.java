
package age.of.civilizations2.jakowski.lukasz.AI.AI_Build;

import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Invest2;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Option;
import age.of.civilizations2.jakowski.lukasz.CFG;

public class AI_Build_Option_Invest2
extends AI_Build_Option {
    @Override
    public float getScore(int nCivID) {
        return CFG.core.getCiv((int)nCivID).civGD.civPers.BUILD_INVEST * (1.0f - (float)CFG.core.getCiv(nCivID).getInvestsSize() / (float)CFG.core.getCiv(nCivID).getNumOfProvs());
    }

    @Override
    public AI_Build getData(int nCivID) {
        return new AI_Build_Invest2(nCivID, this.getMoney(nCivID));
    }
}

