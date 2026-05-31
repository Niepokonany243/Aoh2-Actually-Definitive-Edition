
package age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission_Type;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy_ToTheFront;

public class CivArmyMission_RegroupAfterRecruitment_War
extends CivArmyMission {
    public int iTurnsRequiredToMoveToFrontLine = 1;

    public CivArmyMission_RegroupAfterRecruitment_War(int nCivID, int fromProvinceID, int toProvinceID, long iArmy) {
        this.iArmy = iArmy;
        this.iProvinceID = fromProvinceID;
        this.toProvinceID = toProvinceID;
        this.MISSION_ID = -1;
        RegroupArmy tryRegroupArmy = new RegroupArmy(nCivID, this.iProvinceID, toProvinceID);
        this.iTurnsRequiredToMoveToFrontLine = tryRegroupArmy.getRouteSize();
        this.MISSION_TYPE = CivArmyMission_Type.REGRUOP_AFTER_RECRUIT;
        this.TURN_ID = GameCalendar.TURNID;
        this.iObsolete = 15;
    }

    @Override
    public boolean canMakeAction(int nCivID, int iTurnsLeft) {
        return GameCalendar.TURNID != this.TURN_ID;
    }

    @Override
    public boolean action(int nCivID) {
        RegroupArmy_ToTheFront tryRegroupArmy;
        if (this.iProvinceID != this.toProvinceID && (tryRegroupArmy = new RegroupArmy_ToTheFront(nCivID, this.iProvinceID, this.toProvinceID)).getRouteSize() > 0) {
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

