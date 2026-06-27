
package age.of.civilizations2.jakowski.lukasz.RegroupArmy;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy;

public class RegroupArmy_AtWar
extends RegroupArmy {
    public RegroupArmy_AtWar(int nCivID, int fromProvinceID, int toProvinceID) {
        super(nCivID, fromProvinceID, toProvinceID);
    }

    @Override
    public boolean continueMovingArmy(int nCivID) {
        if (!CFG.core.getCiv(nCivID).isAtWarC()) {
            return false;
        }
        if (!CFG.core.getProv(this.getFromProvinceID()).getSeaProv() && CFG.core.getProv(this.getFromProvinceID()).getBordersWithEnemy()) {
            return false;
        }
        return super.continueMovingArmy(nCivID);
    }
}

