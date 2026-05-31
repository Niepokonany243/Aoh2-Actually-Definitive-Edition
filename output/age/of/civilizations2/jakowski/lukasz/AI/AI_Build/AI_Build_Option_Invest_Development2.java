/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.AI.AI_Build;

import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Invest_Development2;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Option;
import age.of.civilizations2.jakowski.lukasz.CFG;

public class AI_Build_Option_Invest_Development2
extends AI_Build_Option {
    @Override
    public float getScore(int nCivID) {
        return CFG.core.getCiv((int)nCivID).civGD.civPers.BUILD_INVEST_DEVELOPMENT * (1.0f - (float)(CFG.core.getCiv(nCivID).getInvestsSize_Development() * 2) / (float)CFG.core.getCiv(nCivID).getNumOfProvs()) * (0.65f + 0.45f * (1.0f - CFG.core.getCiv((int)nCivID).fAverageDevelopment / CFG.core.getCiv(nCivID).getTechLevel()));
    }

    @Override
    public AI_Build getData(int nCivID) {
        return new AI_Build_Invest_Development2(nCivID, this.getMoney(nCivID));
    }
}

