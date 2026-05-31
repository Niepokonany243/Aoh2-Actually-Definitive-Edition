
package age.of.civilizations2.jakowski.lukasz.RegroupArmy;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy;

public class RegroupArmy_ExpandCheck
extends RegroupArmy {
    public RegroupArmy_ExpandCheck(int nCivID, int fromProvinceID, int toProvinceID) {
        super(nCivID, fromProvinceID, toProvinceID);
    }

    @Override
    public boolean continueMovingArmy(int nCivID) {
        if (CFG.core.getProv(this.getToProvinceID()).getCivId() != 0 && CFG.core.getProv(this.getToProvinceID()).getCivId() != nCivID) {
            return false;
        }
        return super.continueMovingArmy(nCivID);
    }
}

