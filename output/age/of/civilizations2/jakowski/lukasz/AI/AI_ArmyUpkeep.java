/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.AI;

import age.of.civilizations2.jakowski.lukasz.CFG;

public class AI_ArmyUpkeep {
    public int iProvinceID;
    public int iCost;
    public float fScore = 0.0f;

    public AI_ArmyUpkeep(int nCivID, int nProvinceID) {
        this.iProvinceID = nProvinceID;
        this.iCost = (int)CFG.gameUpdate.getMilitaryUpkeepP(nProvinceID, nCivID);
    }
}

