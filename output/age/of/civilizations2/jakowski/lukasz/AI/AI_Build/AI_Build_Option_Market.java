/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.AI.AI_Build;

import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Market;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Option;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;

public class AI_Build_Option_Market
extends AI_Build_Option {
    @Override
    public float getScore(int nCivID) {
        return CFG.core.getCiv((int)nCivID).civGD.civPers.BUILD_MARKET * (1.0f - (float)CFG.core.getCiv((int)nCivID).numOf_Markets / (float)Math.max(CFG.core.getCiv(nCivID).getNumOfProvs() * BuildingsManager.getMarket_MaxLevel(), 1));
    }

    @Override
    public AI_Build getData(int nCivID) {
        return new AI_Build_Market(nCivID, this.getMoney(nCivID));
    }
}

