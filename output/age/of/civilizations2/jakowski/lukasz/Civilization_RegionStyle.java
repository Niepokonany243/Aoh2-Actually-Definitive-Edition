/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;

public class Civilization_RegionStyle {
    public void updatePB(int nProvinceID, int withProvinceID) {
        CFG.core.getProv(nProvinceID).getProvBordersLandByLand(withProvinceID).updateDrawProvinceBorder_CivRegion();
    }
}

