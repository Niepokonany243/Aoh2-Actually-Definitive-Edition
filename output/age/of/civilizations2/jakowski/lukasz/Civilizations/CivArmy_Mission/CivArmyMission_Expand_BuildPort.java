
package age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission_Type;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.ConstructionType;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy_PortToBuild;

public class CivArmyMission_Expand_BuildPort
extends CivArmyMission {
    public int iBuildPortInProvinceID = -1;

    public CivArmyMission_Expand_BuildPort(int nCivID, int fromProvinceID, int toProvinceID, long iArmy) {
        this.iArmy = iArmy;
        this.iProvinceID = fromProvinceID;
        this.iBuildPortInProvinceID = fromProvinceID;
        this.toProvinceID = toProvinceID;
        this.MISSION_ID = -1;
        this.MISSION_TYPE = CivArmyMission_Type.EXPAND_NETURAL_PROVINCE;
        RegroupArmy_PortToBuild tryRegroupArmy = new RegroupArmy_PortToBuild(nCivID, this.iProvinceID, toProvinceID);
        this.TURN_ID = GameCalendar.TURNID;
        this.iObsolete = tryRegroupArmy.getRouteSize() + 6;
    }

    @Override
    public boolean canMakeAction(int nCivID, int iTurnsLeft) {
        return GameCalendar.TURNID != this.TURN_ID;
    }

    @Override
    public boolean action(int nCivID) {
        if (this.iProvinceID != this.toProvinceID && CFG.core.getProv(this.toProvinceID).getCivId() == 0) {
            RegroupArmy_PortToBuild tryRegroupArmy = new RegroupArmy_PortToBuild(nCivID, this.iProvinceID, this.toProvinceID);
            if (CFG.core.getProv(this.iBuildPortInProvinceID).getCivId() == nCivID) {
                if (this.action_BuildPort(nCivID, this.iBuildPortInProvinceID) && tryRegroupArmy.getRouteSize() > 0) {
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
            } else {
                return true;
            }
        }
        return true;
    }

    public final boolean action_BuildPort(int nCivID, int nFromProvinceID) {
        if (CFG.core.getProv(nFromProvinceID).getLvlOfPort() == 0) {
            if (CFG.core.getProv(nFromProvinceID).getCivId() == nCivID) {
                if (CFG.core.getCiv(nCivID).isInConstruction(nFromProvinceID, ConstructionType.PORT) == 0) {
                    if (BuildingsManager.constructPort(nFromProvinceID, nCivID)) {
                        ++this.iObsolete;
                        return false;
                    }
                    this.lockTreasury_Port(nCivID, nFromProvinceID);
                    return false;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public final void lockTreasury_Port(int nCivID, int nProvinceID) {
        int colonizeCost = (int)((float)BuildingsManager.getPort_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfPort() + 1, nProvinceID) * 1.05f);
        CFG.core.getCiv((int)nCivID).civGD.iLockTreasury = Math.max(CFG.core.getCiv((int)nCivID).civGD.iLockTreasury, colonizeCost);
        if (CFG.core.getCiv((int)nCivID).iBudget > 0) {
            this.iObsolete = CFG.core.getCiv(nCivID).getGold() > 0L && CFG.core.getCiv(nCivID).getGold() < (long)colonizeCost ? Math.max(this.iObsolete, Math.max(2, (int)Math.ceil((float)CFG.core.getCiv(nCivID).getGold() / (float)colonizeCost))) : Math.max(2, this.iObsolete);
        }
    }
}

