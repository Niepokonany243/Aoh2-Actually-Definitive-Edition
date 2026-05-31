/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission;

import age.of.civilizations2.jakowski.lukasz.AI.AI_NeighProvinces;
import age.of.civilizations2.jakowski.lukasz.AI.AI_NeighProvinces_Army;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission_RegroupAfterRecruitment;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission_Type;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.RegroupArmy.RegroupArmy;
import java.util.ArrayList;
import java.util.List;

public class CivArmyMission_ExpandNeutralProvince
extends CivArmyMission {
    private int iCivID;
    private int iConquerProvinceID;
    private int iRegroupArmyPlace = -1;
    private int iRangeOfRegroup = 3;

    public CivArmyMission_ExpandNeutralProvince(int nCivID, int conquerProvinceID) {
        this.toProvinceID = conquerProvinceID;
        this.iConquerProvinceID = conquerProvinceID;
        this.MISSION_ID = -1;
        this.iCivID = nCivID;
        this.MISSION_TYPE = CivArmyMission_Type.EXPAND_NETURAL_PROVINCE;
        this.TURN_ID = GameCalendar.TURNID;
        this.iObsolete = 4;
        this.iArmy = 0L;
        this.action(nCivID);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public boolean action(int nCivID) {
        int i;
        int i2;
        ArrayList<Integer> possibleFrom = new ArrayList<Integer>();
        if (CFG.core.getProv(this.iConquerProvinceID).getCivId() != 0) {
            this.iObsolete = -1;
            return true;
        }
        for (int i3 = 0; i3 < CFG.core.getProv(this.iConquerProvinceID).getNeighProvincesSize(); ++i3) {
            if (CFG.core.getProv(CFG.core.getProv(this.iConquerProvinceID).getNeighProvinces(i3)).getCivId() != this.iCivID) continue;
            possibleFrom.add(CFG.core.getProv(this.iConquerProvinceID).getNeighProvinces(i3));
        }
        if (possibleFrom.size() == 0) {
            this.iObsolete = -1;
            return true;
        }
        if ((long)CFG.core.getProv(this.iConquerProvinceID).getArmyID(0) > (long)CFG.core.getCiv(this.iCivID).getNumberOfUnits() + CFG.core.getCiv(this.iCivID).getGold() / (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT) {
            CFG.core.getCiv((int)this.iCivID).civGD.iLockTreasury = (int)((CFG.core.getProv(this.iConquerProvinceID).getArmyID(0) + GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT - CFG.core.getCiv(this.iCivID).getNumberOfUnits()) * GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT);
            ++this.iObsolete;
        }
        ArrayList<Integer> canMoveImmediately = new ArrayList<Integer>();
        for (int i4 = possibleFrom.size() - 1; i4 >= 0; --i4) {
            if (CFG.core.getProv((Integer)possibleFrom.get(i4)).getArmyCivID1(this.iCivID) - CFG.core.getCiv((int)this.iCivID).civGD.civPlans.haveMission_Army((Integer)possibleFrom.get(i4)) <= CFG.core.getProv(this.iConquerProvinceID).getArmyID(0)) continue;
            canMoveImmediately.add((Integer)possibleFrom.get(i4));
        }
        if (canMoveImmediately.size() > 0) {
            int randID = CFG.oR.nextInt(canMoveImmediately.size());
            int numOfNeutral = 0;
            for (int k = 0; k < CFG.core.getProv((Integer)canMoveImmediately.get(randID)).getNeighProvincesSize(); ++k) {
                if (CFG.core.getProv(CFG.core.getProv((Integer)canMoveImmediately.get(randID)).getNeighProvinces(k)).getCivId() != 0) continue;
                ++numOfNeutral;
            }
            long tArmyToMove = CFG.core.getProv((Integer)canMoveImmediately.get(randID)).getArmyCivID1(this.iCivID);
            if (numOfNeutral > 1) {
                tArmyToMove = CFG.core.getProv(this.iConquerProvinceID).getArmyID(0) + 5L + (long)CFG.oR.nextInt(5);
            }
            if (!CFG.gameAction.moveArmyAction((Integer)canMoveImmediately.get(randID), this.iConquerProvinceID, tArmyToMove, this.iCivID, true, false)) return false;
            this.iProvinceID = (Integer)canMoveImmediately.get(randID);
            this.iObsolete = -1;
            return true;
        }
        canMoveImmediately.clear();
        long nArmiesInNeighbooringProvinces = 0L;
        for (int i5 = possibleFrom.size() - 1; i5 >= 0; --i5) {
            if (CFG.core.getProv((Integer)possibleFrom.get(i5)).getArmyCivID1(this.iCivID) - CFG.core.getCiv((int)this.iCivID).civGD.civPlans.haveMission_Army((Integer)possibleFrom.get(i5)) <= 0) continue;
            canMoveImmediately.add((Integer)possibleFrom.get(i5));
            nArmiesInNeighbooringProvinces += CFG.core.getProv((Integer)possibleFrom.get(i5)).getArmyCivID1(this.iCivID) - CFG.core.getCiv((int)this.iCivID).civGD.civPlans.haveMission_Army((Integer)possibleFrom.get(i5));
        }
        if (CFG.core.getProv(this.iConquerProvinceID).getArmyID(0) + 4 < nArmiesInNeighbooringProvinces) {
            ArrayList<Integer> sortedByArmy = new ArrayList<Integer>();
            while (canMoveImmediately.size() > 0) {
                int tBest = 0;
                for (i2 = canMoveImmediately.size() - 1; i2 > 0; --i2) {
                    if (CFG.core.getProv((Integer)canMoveImmediately.get(tBest)).getArmyCivID1(this.iCivID) - CFG.core.getCiv((int)this.iCivID).civGD.civPlans.haveMission_Army((Integer)canMoveImmediately.get(tBest)) >= CFG.core.getProv((Integer)canMoveImmediately.get(i2)).getArmyCivID1(this.iCivID) - CFG.core.getCiv((int)this.iCivID).civGD.civPlans.haveMission_Army((Integer)canMoveImmediately.get(i2))) continue;
                    tBest = i2;
                }
                sortedByArmy.add((Integer)canMoveImmediately.get(tBest));
                canMoveImmediately.remove(tBest);
            }
            for (int i6 = 0; i6 < sortedByArmy.size(); ++i6) {
                if (CFG.gameAction.moveArmyAction((Integer)sortedByArmy.get(i6), this.iConquerProvinceID, CFG.core.getProv((Integer)sortedByArmy.get(i6)).getArmyCivID1(this.iCivID) - CFG.core.getCiv((int)this.iCivID).civGD.civPlans.haveMission_Army((Integer)sortedByArmy.get(i6)), nCivID, true, false)) continue;
                return false;
            }
        }
        if (this.iRegroupArmyPlace < 0) {
            this.iProvinceID = this.iRegroupArmyPlace = ((Integer)possibleFrom.get(0)).intValue();
            this.iArmy = CFG.core.getProv(this.iRegroupArmyPlace).getArmyCivID1(this.iCivID);
        } else if (CFG.core.getProv(this.iRegroupArmyPlace).getCivId() != nCivID) {
            this.iProvinceID = this.iRegroupArmyPlace = ((Integer)possibleFrom.get(0)).intValue();
            this.iArmy = CFG.core.getProv(this.iRegroupArmyPlace).getArmyCivID1(this.iCivID);
        } else {
            if (CFG.core.getProv(this.iRegroupArmyPlace).getArmyCivID1(this.iCivID) > 2) {
                CFG.gameAction.moveArmyAction(this.iRegroupArmyPlace, this.iConquerProvinceID, CFG.core.getProv(this.iRegroupArmyPlace).getArmyCivID1(this.iCivID), this.iCivID, true, false);
            }
            this.iProvinceID = this.iRegroupArmyPlace;
            this.iArmy = CFG.core.getProv(this.iRegroupArmyPlace).getArmyCivID1(this.iCivID);
        }
        long requiredArmy = CFG.core.getProv(this.iConquerProvinceID).getArmyID(0) - CFG.core.getCiv(nCivID).isMovingUnitsToProvID_Num(this.iConquerProvinceID) - CFG.core.getCiv(nCivID).isRegroupingArmy_ToProvID(this.iRegroupArmyPlace);
        if (CFG.core.getCiv(nCivID).getNumberOfUnits() > requiredArmy) {
            if (requiredArmy <= 0L) return false;
            List<AI_NeighProvinces_Army> closestArmy = CFG.oAI.getAllNeighboringProvcsInRange_WithArmyToRegroup(this.iRegroupArmyPlace, nCivID, this.iRangeOfRegroup, true, false, new ArrayList<AI_NeighProvinces_Army>(), new ArrayList<Integer>(), requiredArmy);
            long nClosestArmy_Num = 0L;
            for (i = closestArmy.size() - 1; i >= 0; nClosestArmy_Num += closestArmy.get((int)i).iArmy, --i) {
            }
            if (nClosestArmy_Num > requiredArmy) {
            } else {
                if (CFG.core.getCiv(nCivID).getMovemPoints() < CFG.ideologiesMgr.getIdeologyID((int)CFG.core.getCiv((int)nCivID).getIdeology()).COST_OF_RECRUIT) return false;
                List<AI_NeighProvinces> listOfPossibleProvincesToRecruit = CFG.oAI.getAllNeighboringProvincesInRange_Recruit(this.iRegroupArmyPlace, nCivID, 3, true, false, new ArrayList<AI_NeighProvinces>(), new ArrayList<Integer>());
                if (this.iRegroupArmyPlace >= 0 && !CFG.core.getProv(this.iRegroupArmyPlace).isOccupied() && CFG.core.getProv(this.iRegroupArmyPlace).getCivId() == nCivID) {
                    listOfPossibleProvincesToRecruit.add(new AI_NeighProvinces(this.iRegroupArmyPlace, 1));
                }
                if (listOfPossibleProvincesToRecruit.size() <= 0) return false;
                int tempRand = 0;
                int tBest = 0;
                int tBestArmy = CFG.gameAction.gMARY(listOfPossibleProvincesToRecruit.get((int)tBest).iProvinceID);
                for (int k = 1; k < listOfPossibleProvincesToRecruit.size(); ++k) {
                    if (tBestArmy >= CFG.gameAction.gMARY(listOfPossibleProvincesToRecruit.get((int)k).iProvinceID)) continue;
                    tBest = k;
                    tBestArmy = CFG.gameAction.gMARY(listOfPossibleProvincesToRecruit.get((int)k).iProvinceID);
                }
                tempRand = tBest;
                long tArmyToRecruit = Math.min(requiredArmy, Math.min(CFG.gameAction.gMARY(listOfPossibleProvincesToRecruit.get((int)tempRand).iProvinceID), (long)(CFG.core.getCiv(nCivID).getGold() / (long)(CFG.core.getProv(listOfPossibleProvincesToRecruit.get((int)tempRand).iProvinceID).getLvlOfArmoury() > 0 ? GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT - GameValues.gvBuildingArmoury.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT_REDUCTION * CFG.core.getProv(listOfPossibleProvincesToRecruit.get((int)tempRand).iProvinceID).getLvlOfArmoury() : GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT))));
                CFG.core.getCiv(nCivID).recruitArmy_AI(listOfPossibleProvincesToRecruit.get((int)tempRand).iProvinceID, tArmyToRecruit);
                long tempArmy = CFG.core.getCiv(nCivID).getRecruitArmy_BasedOnProvinceID(listOfPossibleProvincesToRecruit.get((int)tempRand).iProvinceID);
                if (tempArmy <= 0) return false;
                CFG.core.getCiv((int)nCivID).civGD.civPlans.armiesMissions.add(new CivArmyMission_RegroupAfterRecruitment(nCivID, listOfPossibleProvincesToRecruit.get((int)tempRand).iProvinceID, this.iRegroupArmyPlace, tempArmy));
                return false;
            }
            for (i = closestArmy.size() - 1; i >= 0; --i) {
                RegroupArmy tryRegroupArmy;
                boolean alreadyNeighboors = false;
                for (int j = 0; j < CFG.core.getProv(closestArmy.get((int)i).iProvinceID).getNeighProvincesSize(); ++j) {
                    if (this.iConquerProvinceID != CFG.core.getProv(closestArmy.get((int)i).iProvinceID).getNeighProvinces(j)) continue;
                    alreadyNeighboors = true;
                    break;
                }
                if (!alreadyNeighboors && (tryRegroupArmy = new RegroupArmy(nCivID, closestArmy.get((int)i).iProvinceID, this.iRegroupArmyPlace)).getRouteSize() > 0) {
                    if (tryRegroupArmy.getRouteSize() == 1) {
                        if (!CFG.gameAction.moveArmyAction(closestArmy.get((int)i).iProvinceID, this.iRegroupArmyPlace, closestArmy.get((int)i).iArmy, nCivID, true, false)) return false;
                        requiredArmy -= closestArmy.get((int)i).iArmy;
                    } else {
                        if (!CFG.gameAction.moveArmyAction(closestArmy.get((int)i).iProvinceID, tryRegroupArmy.getRoute(0), closestArmy.get((int)i).iArmy, nCivID, true, false)) return false;
                        tryRegroupArmy.setFromProvinceID(tryRegroupArmy.getRoute(0));
                        tryRegroupArmy.removeRoute(0);
                        tryRegroupArmy.setNumOfUnits(closestArmy.get((int)i).iArmy);
                        CFG.core.getCiv(nCivID).addRegroupArmy(tryRegroupArmy);
                        requiredArmy -= closestArmy.get((int)i).iArmy;
                    }
                }
                if (requiredArmy >= 0) continue;
                return false;
            }
        }
        if (requiredArmy > 0L) {
            long recrutiableUnits_Treasury = CFG.core.getCiv(nCivID).getGold() / (long)GameValues.gvArmyRecruit.COST_OF_RECRUIT_ARMY_GOLD_PER_UNIT;
            if (recrutiableUnits_Treasury > requiredArmy) {
                canMoveImmediately.clear();
                for (i2 = possibleFrom.size() - 1; i2 >= 0; --i2) {
                    if (CFG.gameAction.gMARY((Integer)possibleFrom.get(i2), nCivID) <= requiredArmy) continue;
                    canMoveImmediately.add((Integer)possibleFrom.get(i2));
                }
                if (canMoveImmediately.size() != 0) {
                    int tRand = CFG.oR.nextInt(canMoveImmediately.size());
                    CFG.core.getCiv(nCivID).recruitArmy_AI((Integer)canMoveImmediately.get(tRand), requiredArmy + 5 + CFG.oR.nextInt(5));
                    return false;
                }
                int tBest = 0;
                for (i = possibleFrom.size() - 1; i > 0; --i) {
                    if (CFG.gameAction.gMARY((Integer)possibleFrom.get(i), nCivID) <= CFG.gameAction.gMARY((Integer)possibleFrom.get(tBest), nCivID)) continue;
                    tBest = i;
                }
                CFG.core.getCiv(nCivID).recruitArmy_AI((Integer)possibleFrom.get(tBest), requiredArmy + 5 + CFG.oR.nextInt(5));
            } else {
                this.iRangeOfRegroup = 6;
            }
        }
        int i7 = 0;
        while (i7 < possibleFrom.size()) {
            if (!CFG.gameAction.moveArmyAction((Integer)possibleFrom.get(i7), this.iConquerProvinceID, CFG.core.getProv((Integer)possibleFrom.get(i7)).getArmyCivID1(this.iCivID), this.iCivID, true, false)) {
                return false;
            }
            ++i7;
        }
        return false;
    }

    @Override
    public void onRemove() {
        CFG.core.getCiv((int)this.iCivID).civGD.iLockTreasury = -1;
    }
}

