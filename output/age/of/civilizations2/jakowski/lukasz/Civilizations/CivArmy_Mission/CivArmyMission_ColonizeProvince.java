
package age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission_RegroupAfterRecruitment;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission_Type;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.ConstructionType;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy_PortToBuild;
import java.util.ArrayList;

public class CivArmyMission_ColonizeProvince
extends CivArmyMission {
    private int iCivID;
    private int iColonizeProvinceID;

    public CivArmyMission_ColonizeProvince(int nCivID, int colonizeProvinceID) {
        this.toProvinceID = colonizeProvinceID;
        this.iColonizeProvinceID = colonizeProvinceID;
        this.MISSION_ID = -1;
        this.iCivID = nCivID;
        this.MISSION_TYPE = CivArmyMission_Type.COLONIZE_PROVINCE;
        this.TURN_ID = GameCalendar.TURNID;
        this.iObsolete = (int)Math.max((float)CFG.core.getProvinSize() * 0.01f, 30.0f);
        this.iArmy = 0L;
        this.generateColonizeData();
    }

    public final boolean generateColonizeData() {
        RegroupArmy tryRegroupArmy;
        int j;
        int i;
        int tBestID_To;
        int tBestRouteSize;
        int tBestID;
        int j2;
        int i2;
        this.iProvinceID = -1;
        if (CFG.core.getCiv((int)this.iCivID).iBudget < 0) {
            this.iObsolete = 0;
            CFG.core.getCiv((int)this.iCivID).civGD.iLockTreasury = 1;
            return false;
        }
        ArrayList<Boolean> haveAccessToBasins = new ArrayList<Boolean>();
        for (int i3 = 0; i3 < CFG.map.numOfBasins; ++i3) {
            haveAccessToBasins.add(false);
        }
        ArrayList<Integer> lPossibleProvincesFrom = new ArrayList<Integer>();
        ArrayList<Integer> lPossibleProvincesTo = new ArrayList<Integer>();
        for (i2 = 0; i2 < CFG.core.getProv(this.iColonizeProvinceID).getNeighSeaProvincesSize(); ++i2) {
            CFG.basinSet(haveAccessToBasins, CFG.core.getProv(CFG.core.getProv(this.iColonizeProvinceID).getNeighSeaProvinces(i2)).getBasinID(), true);
            lPossibleProvincesTo.add(CFG.core.getProv(this.iColonizeProvinceID).getNeighSeaProvinces(i2));
        }
        block2: for (i2 = 0; i2 < CFG.core.getCiv(this.iCivID).getNumOfProvs(); ++i2) {
            if (CFG.core.getProv(CFG.core.getCiv(this.iCivID).getProvID(i2)).isOccupied() || CFG.core.getProv(CFG.core.getCiv(this.iCivID).getProvID(i2)).getLvlOfPort() <= 0) continue;
            for (j2 = 0; j2 < CFG.core.getProv(CFG.core.getCiv(this.iCivID).getProvID(i2)).getNeighSeaProvincesSize(); ++j2) {
                if (!CFG.basinGet(haveAccessToBasins, CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(this.iCivID).getProvID(i2)).getNeighSeaProvinces(j2)).getBasinID())) continue;
                lPossibleProvincesFrom.add(CFG.core.getCiv(this.iCivID).getProvID(i2));
                continue block2;
            }
        }
        if (!lPossibleProvincesFrom.isEmpty()) {
            tBestID = -1;
            tBestRouteSize = -1;
            tBestID_To = -1;
            for (i = lPossibleProvincesFrom.size() - 1; i >= 0; --i) {
                for (j = lPossibleProvincesTo.size() - 1; j >= 0; --j) {
                    tryRegroupArmy = new RegroupArmy(this.iCivID, (Integer)lPossibleProvincesFrom.get(i), (Integer)lPossibleProvincesTo.get(j));
                    if (tryRegroupArmy.getRouteSize() <= 0) continue;
                    if (tBestID < 0) {
                        tBestID = i;
                        tBestID_To = j;
                        tBestRouteSize = tryRegroupArmy.getRouteSize();
                        continue;
                    }
                    if (tBestRouteSize > tryRegroupArmy.getRouteSize()) {
                        tBestID = i;
                        tBestID_To = j;
                        tBestRouteSize = tryRegroupArmy.getRouteSize();
                        continue;
                    }
                    if (tBestRouteSize != tryRegroupArmy.getRouteSize() || CFG.oR.nextInt(100) >= 50) continue;
                    tBestID = i;
                    tBestID_To = j;
                    tBestRouteSize = tryRegroupArmy.getRouteSize();
                }
            }
            if (tBestID >= 0) {
                this.iArmy = CFG.core.getProv((Integer)lPossibleProvincesFrom.get(tBestID)).getArmyCivID1(this.iCivID) > 0L ? Math.min(CFG.core.getProv((Integer)lPossibleProvincesFrom.get(tBestID)).getArmyCivID1(this.iCivID), 1L + (long)CFG.oR.nextInt(9)) : Math.max(2L, 1L + (long)CFG.oR.nextInt(9));
                RegroupArmy tryRegroupArmy2 = new RegroupArmy(this.iCivID, (Integer)lPossibleProvincesFrom.get(tBestID), (Integer)lPossibleProvincesTo.get(tBestID_To));
                if (tryRegroupArmy2.getRouteSize() > 0) {
                    this.iProvinceID = (Integer)lPossibleProvincesFrom.get(tBestID);
                    this.toProvinceID = (Integer)lPossibleProvincesTo.get(tBestID_To);
                    this.iObsolete = Math.max(this.iObsolete, (int)((float)tryRegroupArmy2.getRouteSize() * 1.25f));
                    this.lockTreasury();
                    return true;
                }
            }
        }
        lPossibleProvincesFrom.clear();
        block6: for (i2 = 0; i2 < CFG.core.getCiv(this.iCivID).getNumOfProvs(); ++i2) {
            if (CFG.core.getProv(CFG.core.getCiv(this.iCivID).getProvID(i2)).isOccupied()) continue;
            for (j2 = 0; j2 < CFG.core.getProv(CFG.core.getCiv(this.iCivID).getProvID(i2)).getNeighSeaProvincesSize(); ++j2) {
                if (!CFG.basinGet(haveAccessToBasins, CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(this.iCivID).getProvID(i2)).getNeighSeaProvinces(j2)).getBasinID())) continue;
                lPossibleProvincesFrom.add(CFG.core.getCiv(this.iCivID).getProvID(i2));
                continue block6;
            }
        }
        if (!lPossibleProvincesFrom.isEmpty()) {
            tBestID = -1;
            tBestRouteSize = -1;
            tBestID_To = -1;
            for (i = lPossibleProvincesFrom.size() - 1; i >= 0; --i) {
                for (j = lPossibleProvincesTo.size() - 1; j >= 0; --j) {
                    tryRegroupArmy = new RegroupArmy_PortToBuild(this.iCivID, (Integer)lPossibleProvincesFrom.get(i), (Integer)lPossibleProvincesTo.get(j));
                    if (tryRegroupArmy.getRouteSize() <= 0) continue;
                    if (tBestID < 0) {
                        tBestID = i;
                        tBestID_To = j;
                        tBestRouteSize = tryRegroupArmy.getRouteSize();
                        continue;
                    }
                    if (tBestRouteSize > tryRegroupArmy.getRouteSize()) {
                        tBestID = i;
                        tBestID_To = j;
                        tBestRouteSize = tryRegroupArmy.getRouteSize();
                        continue;
                    }
                    if (tBestRouteSize != tryRegroupArmy.getRouteSize() || CFG.oR.nextInt(100) >= 50) continue;
                    tBestID = i;
                    tBestID_To = j;
                    tBestRouteSize = tryRegroupArmy.getRouteSize();
                }
            }
            if (tBestID >= 0) {
                this.iArmy = CFG.core.getProv((Integer)lPossibleProvincesFrom.get(tBestID)).getArmyCivID1(this.iCivID) > 0L ? Math.min(CFG.core.getProv((Integer)lPossibleProvincesFrom.get(tBestID)).getArmyCivID1(this.iCivID), 1L + (long)CFG.oR.nextInt(9)) : Math.max(2L, 1L + (long)CFG.oR.nextInt(9));
                RegroupArmy_PortToBuild tryRegroupArmy3 = new RegroupArmy_PortToBuild(this.iCivID, (Integer)lPossibleProvincesFrom.get(tBestID), (Integer)lPossibleProvincesTo.get(tBestID_To));
                if (tryRegroupArmy3.getRouteSize() > 0) {
                    this.iProvinceID = (Integer)lPossibleProvincesFrom.get(tBestID);
                    this.toProvinceID = (Integer)lPossibleProvincesTo.get(tBestID_To);
                    this.iObsolete = Math.max(this.iObsolete, (int)((float)tryRegroupArmy3.getRouteSize() * 1.25f));
                    this.lockTreasury();
                    return true;
                }
            }
        }
        if (this.iProvinceID < 0) {
            this.iObsolete = 0;
            CFG.core.getCiv((int)this.iCivID).civGD.iLockTreasury = 1;
            return false;
        }
        return true;
    }

    @Override
    public boolean canMakeAction(int nCivID, int iTurnsLeft) {
        return true;
    }

    @Override
    public boolean action(int nCivID) {
        if (CFG.core.getProv(this.iColonizeProvinceID).getCivId() != 0) {
            CFG.core.setCivRelationOfCivB(this.iCivID, CFG.core.getProv(this.iColonizeProvinceID).getCivId(), CFG.core.getCivRelationOfCivB(this.iCivID, CFG.core.getProv(this.iColonizeProvinceID).getCivId()) - 0.25f - (float)CFG.oR.nextInt(425) / 100.0f);
            ArrayList<Integer> tProv = new ArrayList<Integer>();
            for (int i = 0; i < CFG.core.getProv(this.toProvinceID).getNeighProvincesSize(); ++i) {
                if (CFG.core.getProv(this.toProvinceID).getNeighProvinces(i) == this.iColonizeProvinceID || CFG.core.getProv(CFG.core.getProv(this.toProvinceID).getNeighProvinces(i)).getSeaProv() || CFG.core.getProv(CFG.core.getProv(this.toProvinceID).getNeighProvinces(i)).getCivId() != 0) continue;
                tProv.add(CFG.core.getProv(this.toProvinceID).getNeighProvinces(i));
            }
            if (tProv.isEmpty()) {
                this.iObsolete = 0;
                CFG.core.getCiv((int)this.iCivID).civGD.iLockTreasury = 1;
                return true;
            }
            int tBest = 0;
            for (int i = tProv.size() - 1; i > 0; --i) {
                if (!(CFG.core.getProv((Integer)tProv.get(tBest)).getGrowthRate_Pop() < CFG.core.getProv((Integer)tProv.get(i)).getGrowthRate_Pop())) continue;
                tBest = i;
            }
            this.iColonizeProvinceID = (Integer)tProv.get(tBest);
        }
        if (this.iProvinceID != this.toProvinceID) {
            RegroupArmy_PortToBuild tryRegroupArmy;
            if (this.action_RecruitArmy() && (tryRegroupArmy = new RegroupArmy_PortToBuild(nCivID, this.iProvinceID, this.toProvinceID)).getRouteSize() > 0) {
                int moveToProvinceID = tryRegroupArmy.getRoute(0);
                if (!CFG.core.getProv(this.iProvinceID).getSeaProv() && CFG.core.getProv(tryRegroupArmy.getRoute(0)).getSeaProv() && !this.action_BuildPort(this.iProvinceID, tryRegroupArmy.getRoute(0))) {
                    return false;
                }
                if (CFG.gameAction.moveArmyAction(this.iProvinceID, tryRegroupArmy.getRoute(0), this.iArmy, nCivID, true, false)) {
                    this.iProvinceID = tryRegroupArmy.getRoute(0);
                    return false;
                }
            }
        } else {
            if (GameManager.colonizeProvince(this.iColonizeProvinceID, this.iCivID, false)) {
                CFG.core.getCiv((int)this.iCivID).civGD.iLockTreasury = 1;
                CFG.core.getCiv(this.iCivID).buildCivPersonality_Colonization();
                if (!CFG.gameAction.moveArmyAction(this.iProvinceID, this.iColonizeProvinceID, this.iArmy, nCivID, true, false)) {
                    CFG.core.getCiv((int)this.iCivID).civGD.civPlans.addNewArmyMission(this.iProvinceID, new CivArmyMission_RegroupAfterRecruitment(this.iCivID, this.iProvinceID, this.iColonizeProvinceID, this.iArmy));
                }
                return true;
            }
            this.lockTreasury();
            return false;
        }
        CFG.core.getCiv((int)this.iCivID).civGD.iLockTreasury = 1;
        return true;
    }

    public final boolean action_RecruitArmy() {
        if (CFG.core.getProv(this.iProvinceID).getArmyCivID1(this.iCivID) < 1) {
            if (CFG.core.getProv(this.iProvinceID).getTrueOwnerOfProv() != this.iCivID || CFG.core.getProv(this.iProvinceID).getSeaProv()) {
                this.generateColonizeData();
                return false;
            }
            if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.iCivID).getIdeology()).COST_OF_RECRUIT <= CFG.core.getCiv(this.iCivID).getMovemPoints() && CFG.core.getCiv(this.iCivID).recruitArmy_AI(this.iProvinceID, this.iArmy)) {
                return false;
            }
            return false;
        }
        return true;
    }

    public final boolean action_BuildPort(int nFromProvinceID, int toProvinceID) {
        if (CFG.core.getProv(nFromProvinceID).getLvlOfPort() == 0) {
            if (CFG.core.getProv(nFromProvinceID).getCivId() == this.iCivID) {
                if (CFG.core.getCiv(this.iCivID).isInConstruction(nFromProvinceID, ConstructionType.PORT) == 0) {
                    if (BuildingsManager.constructPort(nFromProvinceID, this.iCivID)) {
                        return false;
                    }
                    this.lockTreasury_Port(nFromProvinceID);
                    return false;
                }
                return false;
            }
            this.generateColonizeData();
            return false;
        }
        return true;
    }

    public final void lockTreasury() {
        int colonizeCost = (int)((float)GameManager.getColonizeCost(this.iColonizeProvinceID, this.iCivID) * 1.05f);
        CFG.core.getCiv((int)this.iCivID).civGD.iLockTreasury = Math.max(CFG.core.getCiv((int)this.iCivID).civGD.iLockTreasury, colonizeCost);
        if (CFG.core.getCiv((int)this.iCivID).iBudget > 0) {
            this.iObsolete = CFG.core.getCiv(this.iCivID).getGold() > 0L && CFG.core.getCiv(this.iCivID).getGold() < (long)colonizeCost ? Math.max(this.iObsolete, Math.max(2, (int)Math.ceil((float)CFG.core.getCiv(this.iCivID).getGold() / (float)colonizeCost))) : Math.max(2, this.iObsolete);
        }
    }

    public final void lockTreasury_Port(int nProvinceID) {
        int colonizeCost = (int)((float)BuildingsManager.getPort_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfPort() + 1, nProvinceID) * 1.05f);
        CFG.core.getCiv((int)this.iCivID).civGD.iLockTreasury = Math.max(CFG.core.getCiv((int)this.iCivID).civGD.iLockTreasury, colonizeCost);
        if (CFG.core.getCiv((int)this.iCivID).iBudget > 0) {
            this.iObsolete = CFG.core.getCiv(this.iCivID).getGold() > 0L && CFG.core.getCiv(this.iCivID).getGold() < (long)colonizeCost ? Math.max(this.iObsolete, Math.max(2, (int)Math.ceil((float)CFG.core.getCiv(this.iCivID).getGold() / (float)colonizeCost))) : Math.max(2, this.iObsolete);
        }
    }
}

