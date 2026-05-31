/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.AI.AI_Build;

import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Library;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Option;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;

public class AI_Build_Option_Library
extends AI_Build_Option {
    @Override
    public float getScore(int nCivID) {
        return CFG.core.getCiv((int)nCivID).civGD.civPers.BUILD_LIBRARY * (1.0f - (float)CFG.core.getCiv((int)nCivID).numOf_Libraries / (float)Math.max(CFG.core.getCiv(nCivID).getNumOfProvs() * BuildingsManager.getLibrary_MaxLevel(), 1));
    }

    @Override
    public AI_Build getData(int nCivID) {
        return new AI_Build_Library(nCivID, this.getMoney(nCivID));
    }
}

