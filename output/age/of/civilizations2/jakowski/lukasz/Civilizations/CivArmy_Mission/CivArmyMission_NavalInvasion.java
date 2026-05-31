
package age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission;

import age.of.civilizations2.jakowski.lukasz.AI.AI_NeighProvinces;
import age.of.civilizations2.jakowski.lukasz.AI.Province.AI_ProvinceInfo_War;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission_Type;
import age.of.civilizations2.jakowski.lukasz.Civilizations.Construction.ConstructionType;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy_AtWar;
import java.util.ArrayList;
import java.util.List;

public class CivArmyMission_NavalInvasion
extends CivArmyMission {
    private int iCivID;
    public int moveArmyInNextXTurns = 1;
    public int numOfUnitsMoved = 0;

    public CivArmyMission_NavalInvasion(int nCivID, int fromProvinceID, int toProvinceID) {
        this.iProvinceID = fromProvinceID;
        this.toProvinceID = toProvinceID;
        this.MISSION_ID = -1;
        this.iCivID = nCivID;
        this.MISSION_TYPE = CivArmyMission_Type.NAVAL_INVASION;
        this.TURN_ID = GameCalendar.TURNID;
        this.iObsolete = 10;
        this.iArmy = (long)((float)CFG.core.getProv(fromProvinceID).getArmyCivID1(nCivID) * 0.7f);
    }

    @Override
    public boolean canMakeAction(int nCivID, int iTurnsLeft) {
        return true;
    }

    @Override
    public boolean action(int nCivID) {
        if (GameValues.gvAiWar.USE_NEW_NAVAL_INVASION) {
            return this.actionMission_New(nCivID);
        }
        return this.actionMission_Old(nCivID);
    }

    
    public boolean actionMission_New(int nCivID) {
        if (!CFG.core.getCivsAtWar(nCivID, CFG.core.getProv(this.toProvinceID).getCivId())) {
            if (!CFG.core.getCivsAreAllied(nCivID, CFG.core.getProv(this.toProvinceID).getCivId())) {
                this.iObsolete = 0;
                return true;
            }
            if (!CFG.core.getCiv(CFG.core.getProv(this.toProvinceID).getCivId()).getCivRegion(CFG.core.getProv(this.toProvinceID).getCivRegionID()).checkRegionBordersWithEnemy(nCivID)) {
                this.iObsolete = 0;
                return true;
            }
        }
        if (CFG.core.getProv(this.iProvinceID).getBordersWithEnemy()) {
            this.iObsolete = 0;
            return true;
        }
        if (CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCivId()).getCivRegion(CFG.core.getProv(this.iProvinceID).getCivRegionID()).checkRegionBordersWithEnemy(nCivID)) {
            this.iObsolete = 0;
            return true;
        }
        if (CFG.core.getCiv(nCivID).getMovemPoints() < CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_MOVE) {
            return false;
        }
        if (CFG.core.getProv(this.iProvinceID).getLvlOfPort() <= 0 || this.action_BuildPort(this.iProvinceID, this.toProvinceID)) {
            List<AI_NeighProvinces> listOfPossibleProvinces;
            block35: {
                if (CFG.core.getProv(this.iProvinceID).getArmyCivID1(nCivID) > 0 && this.moveArmyInNextXTurns-- <= 0) {
                    RegroupArmy_AtWar tryRegroupArmy = new RegroupArmy_AtWar(nCivID, this.iProvinceID, this.toProvinceID);
                    if (tryRegroupArmy.getRouteSize() <= 0) {
                        this.iObsolete = 0;
                        return true;
                    }
                    long tArmyToRecruit_PRE = CFG.core.getProv(this.iProvinceID).getArmyCivID1(nCivID);
                    int enemyArmy = 0;
                    if (CFG.core.getCivsAtWar(nCivID, CFG.core.getProv(this.toProvinceID).getCivId())) {
                        for (int i = 0; i < CFG.core.getCiv(CFG.core.getProv(this.toProvinceID).getCivId()).getCivRegion(CFG.core.getProv(this.toProvinceID).getCivRegionID()).getProvincesSize(); enemyArmy += CFG.core.getProvinceArmy(CFG.core.getCiv(CFG.core.getProv(this.toProvinceID).getCivId()).getCivRegion(CFG.core.getProv(this.toProvinceID).getCivRegionID()).getProvince(i)), ++i) {
                        }
                    } else if (!CFG.core.getCiv(CFG.core.getProv(this.toProvinceID).getCivId()).getCivRegion(CFG.core.getProv(this.toProvinceID).getCivRegionID()).checkRegionBordersWithEnemy(nCivID)) {
                        this.iObsolete = 0;
                        return true;
                    }
                    if ((float)enemyArmy * 0.675f > (float)CFG.core.getCiv(nCivID).getNumberOfUnits()) {
                        this.moveArmyInNextXTurns = Math.max(this.moveArmyInNextXTurns, 3);
                        this.action_RecruitArmy(nCivID);
                        return false;
                    }
                    if ((float)enemyArmy * 0.575f > (float)(tArmyToRecruit_PRE + this.numOfUnitsMoved)) {
                        this.moveArmyInNextXTurns = Math.max(this.moveArmyInNextXTurns, 3);
                        this.action_RecruitArmy(nCivID);
                        return false;
                    }
                    if (CFG.core.getProv(this.iProvinceID).isOccupied()) {
                        tArmyToRecruit_PRE = CFG.core.getProv(this.iProvinceID).getArmyCivID1(nCivID);
                    } else {
                        if ((float)tArmyToRecruit_PRE > (float)enemyArmy * 1.175f) {
                            if (true) { 
                                if ((float)tArmyToRecruit_PRE > (float)((long)enemyArmy + CFG.core.getCiv(CFG.core.getProv(this.toProvinceID).getCivId()).getGold() / (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT) * 1.175f) {
                                    tArmyToRecruit_PRE = (int)Math.min((double)tArmyToRecruit_PRE, (double)(GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT + CFG.oR.nextInt(GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT * 4)) + Math.ceil(((float)enemyArmy + ((float)CFG.core.getCiv(CFG.core.getProv(this.toProvinceID).getCivId()).getGold() + Math.max(0.0f, (float)CFG.core.getCiv((int)CFG.core.getProv((int)this.toProvinceID).getCivId()).iBudget * 1.5f)) / (float)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT) * 1.175f * (1.745f + (float)CFG.oR.nextInt(925) / 1000.0f)));
                                }
                            } else {
                                tArmyToRecruit_PRE = (int)Math.min((double)tArmyToRecruit_PRE, (double)(5 + CFG.oR.nextInt(10)) + Math.ceil((float)enemyArmy * (1.745f + (float)CFG.oR.nextInt(925) / 1000.0f)));
                            }
                        }
                        if ((float)tArmyToRecruit_PRE > (float)CFG.core.getCiv(nCivID).getNumberOfUnits() * (0.725f + (float)CFG.oR.nextInt(105) / 1000.0f)) {
                            tArmyToRecruit_PRE = (long)((float)CFG.core.getCiv(nCivID).getNumberOfUnits() * (0.725f + (float)CFG.oR.nextInt(105) / 1000.0f));
                            this.action_RecruitArmy(nCivID);
                        }
                        if (CFG.core.getCiv(nCivID).getBordersWithEnemy() == 0 && CFG.core.getProv(this.iProvinceID).getCivId() == nCivID && CFG.core.getProv(this.toProvinceID).getCivId() != nCivID) {
                            tArmyToRecruit_PRE = (long)Math.ceil((float)tArmyToRecruit_PRE * (0.46f + (float)CFG.oR.nextInt(33) / 100.0f));
                        }
                    }
                    if (tryRegroupArmy.getRouteSize() == 1) {
                        if (!CFG.gameAction.moveArmyAction(this.iProvinceID, this.toProvinceID, tArmyToRecruit_PRE, nCivID, true, false)) {
                            this.moveArmyInNextXTurns = 1;
                            break block35;
                        } else {
                            this.moveArmyInNextXTurns = 3;
                            this.numOfUnitsMoved += tArmyToRecruit_PRE;
                            CFG.core.getCiv((int)nCivID).civGD.iNextPossibleNavalInvasionTurnID = GameCalendar.TURNID + GameValues.gvAiWar.NAVAL_INVASION_DELAY_MIN_TURNS + CFG.oR.nextInt(GameValues.gvAiWar.NAVAL_INVASION_DELAY_RANDOM_TURNS) + (GameValues.gvAiWar.ENABLE_NAVAL_INVASION_DELAY_DISTANCE ? tryRegroupArmy.getRouteSize() : 0);
                            this.iObsolete = 0;
                            return true;
                        }
                    }
                    if (CFG.gameAction.moveArmyAction(this.iProvinceID, tryRegroupArmy.getRoute(0), tArmyToRecruit_PRE, nCivID, true, false)) {
                        tryRegroupArmy.setFromProvinceID(tryRegroupArmy.getRoute(0));
                        tryRegroupArmy.removeRoute(0);
                        tryRegroupArmy.setNumOfUnits(tArmyToRecruit_PRE);
                        CFG.core.getCiv(nCivID).addRegroupArmy(tryRegroupArmy);
                        this.moveArmyInNextXTurns = 3;
                        this.numOfUnitsMoved += tArmyToRecruit_PRE;
                        CFG.core.getCiv((int)nCivID).civGD.iNextPossibleNavalInvasionTurnID = GameCalendar.TURNID + GameValues.gvAiWar.NAVAL_INVASION_DELAY_MIN_TURNS + CFG.oR.nextInt(GameValues.gvAiWar.NAVAL_INVASION_DELAY_RANDOM_TURNS) + (GameValues.gvAiWar.ENABLE_NAVAL_INVASION_DELAY_DISTANCE ? tryRegroupArmy.getRouteSize() : 0);
                        this.iObsolete = 0;
                        return true;
                    }
                }
            }
            this.action_RecruitArmy(nCivID);
            if (CFG.core.getCiv(nCivID).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_RECRUIT + CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_MOVE_OWN_PROVINCE && this.iObsolete > 1 && !(listOfPossibleProvinces = CFG.oAI.getAllNeighboringProvincesInRange_Regroup_ForNavalInvasion(this.iProvinceID, nCivID, this.iObsolete, new ArrayList<AI_NeighProvinces>(), new ArrayList<Integer>())).isEmpty()) {
                while (CFG.core.getCiv(nCivID).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_RECRUIT + CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_MOVE_OWN_PROVINCE && listOfPossibleProvinces.size() > 0) {
                    RegroupArmy tryRegroupArmy;
                    int iBestID = 0;
                    for (int i = listOfPossibleProvinces.size() - 1; i > 0; --i) {
                        if (CFG.core.getProv(listOfPossibleProvinces.get((int)i).iProvinceID).getArmyCivID1(nCivID) <= CFG.core.getProv(listOfPossibleProvinces.get((int)iBestID).iProvinceID).getArmyCivID1(nCivID)) continue;
                        iBestID = i;
                    }
                    long tArmyToRecruit_PRE = CFG.core.getProv(listOfPossibleProvinces.get((int)iBestID).iProvinceID).getArmyCivID1(nCivID) - CFG.core.getCiv((int)nCivID).civGD.civPlans.haveMission_Army(listOfPossibleProvinces.get((int)iBestID).iProvinceID);
                    if (tArmyToRecruit_PRE > 0 && (tryRegroupArmy = new RegroupArmy(nCivID, listOfPossibleProvinces.get((int)iBestID).iProvinceID, this.iProvinceID)).getRouteSize() > 0) {
                        if (tryRegroupArmy.getRouteSize() == 1) {
                            if (!CFG.gameAction.moveArmyAction(listOfPossibleProvinces.get((int)iBestID).iProvinceID, this.iProvinceID, tArmyToRecruit_PRE, nCivID, true, false)) {
                                
                            }
                        } else if (CFG.gameAction.moveArmyAction(listOfPossibleProvinces.get((int)iBestID).iProvinceID, tryRegroupArmy.getRoute(0), tArmyToRecruit_PRE, nCivID, true, false)) {
                            tryRegroupArmy.setFromProvinceID(tryRegroupArmy.getRoute(0));
                            tryRegroupArmy.removeRoute(0);
                            tryRegroupArmy.setNumOfUnits(tArmyToRecruit_PRE);
                            CFG.core.getCiv(nCivID).addRegroupArmy(tryRegroupArmy);
                        }
                    }
                    listOfPossibleProvinces.remove(iBestID);
                }
            }
        }
        this.iArmy = (long)((float)CFG.core.getProv(this.iProvinceID).getArmyCivID1(nCivID) * 0.7f);
        return false;
    }

    
    public boolean actionMission_Old(int nCivID) {
        if (!CFG.core.getCivsAtWar(nCivID, CFG.core.getProv(this.toProvinceID).getCivId())) {
            if (!CFG.core.getCivsAreAllied(nCivID, CFG.core.getProv(this.toProvinceID).getCivId())) {
                this.iObsolete = 0;
                return true;
            }
            if (!CFG.core.getCiv(CFG.core.getProv(this.toProvinceID).getCivId()).getCivRegion(CFG.core.getProv(this.toProvinceID).getCivRegionID()).checkRegionBordersWithEnemy(nCivID)) {
                this.iObsolete = 0;
                return true;
            }
        }
        if (CFG.core.getProv(this.iProvinceID).getBordersWithEnemy()) {
            this.iObsolete = 0;
            return true;
        }
        if (CFG.core.getCiv(CFG.core.getProv(this.iProvinceID).getCivId()).getCivRegion(CFG.core.getProv(this.iProvinceID).getCivRegionID()).checkRegionBordersWithEnemy(nCivID)) {
            this.iObsolete = 0;
            return true;
        }
        if ((float)CFG.core.getCiv(nCivID).getMovemPoints() < (float)CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_MOVE * 2.5f) {
            return false;
        }
        if (CFG.core.getProv(this.iProvinceID).getLvlOfPort() <= 0 || this.action_BuildPort(this.iProvinceID, this.toProvinceID)) {
            List<AI_NeighProvinces> listOfPossibleProvinces;
            if (CFG.core.getProv(this.iProvinceID).getArmyCivID1(nCivID) > 0 && this.moveArmyInNextXTurns-- <= 0) {
                RegroupArmy_AtWar tryRegroupArmy = new RegroupArmy_AtWar(nCivID, this.iProvinceID, this.toProvinceID);
                if (tryRegroupArmy.getRouteSize() <= 0) {
                    this.iObsolete = 0;
                    return true;
                }
                long tArmyToRecruit_PRE = CFG.core.getProv(this.iProvinceID).getArmyCivID1(nCivID);
                int enemyArmy = 0;
                if (CFG.core.getCivsAtWar(nCivID, CFG.core.getProv(this.toProvinceID).getCivId())) {
                    for (int i = 0; i < CFG.core.getCiv(CFG.core.getProv(this.toProvinceID).getCivId()).getCivRegion(CFG.core.getProv(this.toProvinceID).getCivRegionID()).getProvincesSize(); enemyArmy += CFG.core.getProvinceArmy(CFG.core.getCiv(CFG.core.getProv(this.toProvinceID).getCivId()).getCivRegion(CFG.core.getProv(this.toProvinceID).getCivRegionID()).getProvince(i)), ++i) {
                    }
                } else if (!CFG.core.getCiv(CFG.core.getProv(this.toProvinceID).getCivId()).getCivRegion(CFG.core.getProv(this.toProvinceID).getCivRegionID()).checkRegionBordersWithEnemy(nCivID)) {
                    this.iObsolete = 0;
                    return true;
                }
                if ((float)enemyArmy * 0.825f > (float)CFG.core.getCiv(nCivID).getNumberOfUnits()) {
                    this.moveArmyInNextXTurns = Math.max(this.moveArmyInNextXTurns, 3);
                    return false;
                }
                if ((float)enemyArmy * 0.915f > (float)(tArmyToRecruit_PRE + this.numOfUnitsMoved)) {
                    this.moveArmyInNextXTurns = Math.max(this.moveArmyInNextXTurns, 3);
                    return false;
                }
                if ((float)tArmyToRecruit_PRE > (float)enemyArmy * 1.175f) {
                    if (true) { 
                        if ((float)tArmyToRecruit_PRE > (float)((long)enemyArmy + CFG.core.getCiv(CFG.core.getProv(this.toProvinceID).getCivId()).getGold() / (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT) * 1.175f) {
                            tArmyToRecruit_PRE = (int)Math.min((double)tArmyToRecruit_PRE, (double)(GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT + CFG.oR.nextInt(GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT * 4)) + Math.ceil(((float)enemyArmy + ((float)CFG.core.getCiv(CFG.core.getProv(this.toProvinceID).getCivId()).getGold() + Math.max(0.0f, (float)CFG.core.getCiv((int)CFG.core.getProv((int)this.toProvinceID).getCivId()).iBudget * 1.5f)) / (float)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT) * 1.175f * (1.745f + (float)CFG.oR.nextInt(925) / 1000.0f)));
                        }
                    } else {
                        tArmyToRecruit_PRE = (int)Math.min((double)tArmyToRecruit_PRE, (double)(5 + CFG.oR.nextInt(10)) + Math.ceil((float)enemyArmy * (1.745f + (float)CFG.oR.nextInt(925) / 1000.0f)));
                    }
                }
                if ((float)tArmyToRecruit_PRE > (float)CFG.core.getCiv(nCivID).getNumberOfUnits() * (0.525f + (float)CFG.oR.nextInt(150) / 1000.0f)) {
                    tArmyToRecruit_PRE = (int)((float)(CFG.core.getCiv(nCivID).getNumberOfUnits() - this.numOfUnitsMoved) * (0.525f + (float)CFG.oR.nextInt(150) / 1000.0f));
                    if (tArmyToRecruit_PRE <= 0) {
                        this.moveArmyInNextXTurns = 6 + tryRegroupArmy.getRouteSize();
                        this.iArmy = 0;
                        return false;
                    }
                } else if ((float)(tArmyToRecruit_PRE + this.numOfUnitsMoved) > (float)CFG.core.getCiv(nCivID).getNumberOfUnits() * 0.525f) {
                    this.moveArmyInNextXTurns = 5 + tryRegroupArmy.getRouteSize();
                    this.iArmy = 0;
                    return false;
                }
                if (CFG.core.getCiv(nCivID).getBordersWithEnemy() == 0 && CFG.core.getProv(this.iProvinceID).getCivId() == nCivID && CFG.core.getProv(this.toProvinceID).getCivId() != nCivID) {
                    tArmyToRecruit_PRE = (long)Math.ceil((float)tArmyToRecruit_PRE * (0.46f + (float)CFG.oR.nextInt(33) / 100.0f));
                }
                if (tryRegroupArmy.getRouteSize() == 1) {
                    if (CFG.gameAction.moveArmyAction(this.iProvinceID, this.toProvinceID, tArmyToRecruit_PRE, nCivID, true, false)) {
                        this.moveArmyInNextXTurns = 3;
                        this.numOfUnitsMoved += tArmyToRecruit_PRE;
                        CFG.core.getCiv((int)nCivID).civGD.iNextPossibleNavalInvasionTurnID = GameCalendar.TURNID + 4 + tryRegroupArmy.getRouteSize() + CFG.oR.nextInt(14);
                        this.iObsolete = 0;
                        return true;
                    }
                    this.moveArmyInNextXTurns = 1;
                } else if (CFG.gameAction.moveArmyAction(this.iProvinceID, tryRegroupArmy.getRoute(0), tArmyToRecruit_PRE, nCivID, true, false)) {
                    tryRegroupArmy.setFromProvinceID(tryRegroupArmy.getRoute(0));
                    tryRegroupArmy.removeRoute(0);
                    tryRegroupArmy.setNumOfUnits(tArmyToRecruit_PRE);
                    CFG.core.getCiv(nCivID).addRegroupArmy(tryRegroupArmy);
                    this.moveArmyInNextXTurns = 3;
                    this.numOfUnitsMoved += tArmyToRecruit_PRE;
                    CFG.core.getCiv((int)nCivID).civGD.iNextPossibleNavalInvasionTurnID = GameCalendar.TURNID + 4 + tryRegroupArmy.getRouteSize() + CFG.oR.nextInt(14);
                    this.iObsolete = 0;
                    return true;
                }
            }
            this.action_RecruitArmy(nCivID);
            if (CFG.core.getCiv(nCivID).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_RECRUIT + CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_MOVE_OWN_PROVINCE && this.iObsolete > 1 && (listOfPossibleProvinces = CFG.oAI.getAllNeighboringProvincesInRange_Regroup_ForNavalInvasion(this.iProvinceID, nCivID, this.iObsolete, new ArrayList<AI_NeighProvinces>(), new ArrayList<Integer>())).size() > 0) {
                while (CFG.core.getCiv(nCivID).getMovemPoints() >= CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_RECRUIT + CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_MOVE_OWN_PROVINCE && listOfPossibleProvinces.size() > 0) {
                    RegroupArmy tryRegroupArmy;
                    int iBestID = 0;
                    for (int i = listOfPossibleProvinces.size() - 1; i > 0; --i) {
                        if (CFG.core.getProv(listOfPossibleProvinces.get((int)i).iProvinceID).getArmyCivID1(nCivID) <= CFG.core.getProv(listOfPossibleProvinces.get((int)iBestID).iProvinceID).getArmyCivID1(nCivID)) continue;
                        iBestID = i;
                    }
                    long tArmyToRecruit_PRE = CFG.core.getProv(listOfPossibleProvinces.get((int)iBestID).iProvinceID).getArmyCivID1(nCivID) - CFG.core.getCiv((int)nCivID).civGD.civPlans.haveMission_Army(listOfPossibleProvinces.get((int)iBestID).iProvinceID);
                    if (tArmyToRecruit_PRE > 0 && (tryRegroupArmy = new RegroupArmy(nCivID, listOfPossibleProvinces.get((int)iBestID).iProvinceID, this.iProvinceID)).getRouteSize() > 0) {
                        if (tryRegroupArmy.getRouteSize() == 1) {
                            if (!CFG.gameAction.moveArmyAction(listOfPossibleProvinces.get((int)iBestID).iProvinceID, this.iProvinceID, tArmyToRecruit_PRE, nCivID, true, false)) {
                                
                            }
                        } else if (CFG.gameAction.moveArmyAction(listOfPossibleProvinces.get((int)iBestID).iProvinceID, tryRegroupArmy.getRoute(0), tArmyToRecruit_PRE, nCivID, true, false)) {
                            tryRegroupArmy.setFromProvinceID(tryRegroupArmy.getRoute(0));
                            tryRegroupArmy.removeRoute(0);
                            tryRegroupArmy.setNumOfUnits(tArmyToRecruit_PRE);
                            CFG.core.getCiv(nCivID).addRegroupArmy(tryRegroupArmy);
                        }
                    }
                    listOfPossibleProvinces.remove(iBestID);
                }
            }
        }
        this.iArmy = (long)((float)CFG.core.getProv(this.iProvinceID).getArmyCivID1(nCivID) * 0.7f);
        return false;
    }

    public final boolean action_RecruitArmy(int nCivID) {
        if (CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)this.iCivID).getIdeology()).COST_OF_RECRUIT <= CFG.core.getCiv(this.iCivID).getMovemPoints()) {
            ArrayList<AI_ProvinceInfo_War> nProvinces = new ArrayList<AI_ProvinceInfo_War>();
            nProvinces.add(new AI_ProvinceInfo_War(this.iProvinceID, 100, true));
            CFG.oAI.getAIStyle(CFG.core.getCiv(nCivID).getAIStyleID()).moveAtWar_Recruit(nCivID, nProvinces, new ArrayList<Integer>(), true);
        }
        return true;
    }

    public final boolean action_BuildPort(int nFromProvinceID, int toProvinceID) {
        if (CFG.core.getProv(nFromProvinceID).getLvlOfPort() == 0) {
            if (CFG.core.getProv(nFromProvinceID).getCivId() == this.iCivID) {
                if (CFG.core.getCiv(this.iCivID).isInConstruction(nFromProvinceID, ConstructionType.PORT) == 0) {
                    if (BuildingsManager.constructPort(nFromProvinceID, this.iCivID)) {
                        this.iObsolete = 10;
                        return false;
                    }
                    this.lockTreasury_Port(nFromProvinceID);
                    return false;
                }
                return false;
            }
            this.iObsolete = 0;
            return false;
        }
        return true;
    }

    public final void lockTreasury_Port(int nProvinceID) {
        int colonizeCost = (int)((float)BuildingsManager.getPort_BuildCost(CFG.core.getProv(nProvinceID).getLvlOfPort() + 1, nProvinceID) * 1.05f);
        CFG.core.getCiv((int)this.iCivID).civGD.iLockTreasury = Math.max(CFG.core.getCiv((int)this.iCivID).civGD.iLockTreasury, colonizeCost);
        if (CFG.core.getCiv((int)this.iCivID).iBudget <= 0 || CFG.core.getCiv(this.iCivID).getGold() <= 0L || CFG.core.getCiv(this.iCivID).getGold() < (long)colonizeCost) {
            
        }
    }
}


