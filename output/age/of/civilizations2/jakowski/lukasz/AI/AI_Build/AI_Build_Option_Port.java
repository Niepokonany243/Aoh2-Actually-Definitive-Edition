/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.AI.AI_Build;

import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Option;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Build.AI_Build_Port;
import age.of.civilizations2.jakowski.lukasz.Civilization;
import age.of.civilizations2.jakowski.lukasz.CFG;

public class AI_Build_Option_Port
extends AI_Build_Option {
    @Override
    public float getScore(int nCivID) {
        try {
            Civilization civ = CFG.core.getCiv(nCivID);
            if (civ.isAtWarC() && civ.numOf_Ports == 0 && civ.getSeaAccess() > 0 && civ.getBordersWithEnemy() == 0) {
                return 1000000.0f; // Force port construction if at war and no way to reach enemies except by sea
            }
            if (CFG.core.getCiv(nCivID).getCivRegionsSize() > CFG.core.getCiv((int)nCivID).numOf_Ports) {
                for (int i = 0; i < CFG.core.getCiv(nCivID).getCivRegionsSize(); ++i) {
                    if (!CFG.core.getCiv(nCivID).getCivRegion(i).getSeaAccess() || CFG.core.getCiv(nCivID).getCivRegion(i).getProvincesSize() <= 0 || CFG.core.getCiv(nCivID).getCivRegion(i).getSeaAccess_HavePort()) continue;
                    return 40.0f;
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        return CFG.core.getCiv((int)nCivID).civGD.civPers.BUILD_PORT * (1.0f - (float)CFG.core.getCiv((int)nCivID).numOf_Ports / (float)Math.max(CFG.core.getCiv(nCivID).getSeaAccess_Provinces_Size(), 1));
    }

    @Override
    public AI_Build getData(int nCivID) {
        return new AI_Build_Port(nCivID, this.getMoney(nCivID));
    }

    @Override
    public long getMoney(int nCivID) {
        if (CFG.core.getCiv(nCivID).isAtWarC() || CFG.core.getCiv(nCivID).civGD.civPlans.isPreparingForTheWar()) {
            return CFG.core.getCiv(nCivID).getGold();
        }
        return super.getMoney(nCivID);
    }
}

