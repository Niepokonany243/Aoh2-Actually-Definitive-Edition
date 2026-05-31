
package age.of.civilizations2.jakowski.lukasz.RegroupArmy;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy;

public class RegroupArmy_AtPeace
extends RegroupArmy {
    public RegroupArmy_AtPeace(int nCivID, int fromProvinceID, int toProvinceID) {
        super(nCivID, fromProvinceID, toProvinceID);
    }

    @Override
    public boolean continueMovingArmy(int nCivID) {
        if (CFG.core.getCiv(nCivID).isAtWarC()) {
            return false;
        }
        return super.continueMovingArmy(nCivID);
    }
}

