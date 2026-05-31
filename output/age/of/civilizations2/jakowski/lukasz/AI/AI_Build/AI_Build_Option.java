/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.AI.AI_Build;

import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Farm;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle.AIPlaystyle;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;

public class AI_Build_Option {
    public float getScore(int nCivID) {
        return CFG.core.getCiv((int)nCivID).civGD.civPers.BUILD_FARM * (1.0f - (float)(CFG.core.getCiv((int)nCivID).numOf_Farms / Math.max(CFG.core.getCiv((int)nCivID).numOf_Farms_ProvincesPossibleToBuild * BuildingsManager.getFarm_MaxLevel(), 1)));
    }

    public AI_Build getData(int nCivID) {
        return new AI_Build_Farm(nCivID, this.getMoney(nCivID));
    }

    public long getMoney(int nCivID) {
        if (CFG.core.getCiv(nCivID).getGold() < AIPlaystyle.getMoney_MinReserve(nCivID)) {
            return 0L;
        }
        return CFG.core.getCiv(nCivID).getGold() - AIPlaystyle.getMoney_MinReserve(nCivID);
    }
}

