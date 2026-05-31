
package age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy;

public class CivArmyMission_PrepareForWar
extends CivArmyMission {
    public int iTurnsRequiredToMoveToFrontLine = 1;

    public CivArmyMission_PrepareForWar(int nCivID, int fromProvinceID, int toProvinceID, long iArmy, int MISSION_ID) {
        this.iArmy = iArmy;
        this.iProvinceID = fromProvinceID;
        this.toProvinceID = toProvinceID;
        this.MISSION_ID = MISSION_ID;
        RegroupArmy tryRegroupArmy = new RegroupArmy(nCivID, this.iProvinceID, toProvinceID);
        this.iTurnsRequiredToMoveToFrontLine = tryRegroupArmy.getRouteSize();
        tryRegroupArmy = null;
    }

    @Override
    public boolean canMakeAction(int nCivID, int iTurnsLeft) {
        return true;
    }

    @Override
    public boolean action(int nCivID) {
        RegroupArmy tryRegroupArmy;
        if (this.iProvinceID != this.toProvinceID && (tryRegroupArmy = new RegroupArmy(nCivID, this.iProvinceID, this.toProvinceID)).getRouteSize() > 0) {
            if (tryRegroupArmy.getRouteSize() == 1) {
                return CFG.gameAction.moveArmyAction(this.iProvinceID, this.toProvinceID, this.iArmy, nCivID, true, false);
            }
            if (CFG.gameAction.moveArmyAction(this.iProvinceID, tryRegroupArmy.getRoute(0), this.iArmy, nCivID, true, false)) {
                tryRegroupArmy.setFromProvinceID(tryRegroupArmy.getRoute(0));
                tryRegroupArmy.removeRoute(0);
                tryRegroupArmy.setNumOfUnits(this.iArmy);
                CFG.core.getCiv(nCivID).addRegroupArmy(tryRegroupArmy);
                return true;
            }
            return false;
        }
        return true;
    }
}

