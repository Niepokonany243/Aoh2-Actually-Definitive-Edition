
package age.of.civilizations2.jakowski.lukasz.RegroupArmy;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy_ToTheFront;

public class RegroupArmy_ToTheFront_Double
extends RegroupArmy_ToTheFront {
    public RegroupArmy_ToTheFront_Double(int nCivID, int fromProvinceID, int toProvinceID) {
        super(nCivID, fromProvinceID, toProvinceID);
    }

    @Override
    public boolean continueMovingArmy(int nCivID) {
        if (CFG.core.getProv(this.getFromProvinceID()).getBordersWithEnemy()) {
            return false;
        }
        if (!CFG.core.getProv(this.getToProvinceID()).getBordersWithEnemy() && !CFG.core.getCivsAtWar(nCivID, CFG.core.getProv(this.getToProvinceID()).getCivId())) {
            return false;
        }
        return super.continueMovingArmy(nCivID);
    }
}

