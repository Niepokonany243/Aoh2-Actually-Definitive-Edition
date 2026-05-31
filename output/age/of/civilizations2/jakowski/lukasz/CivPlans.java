/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.AI.AI_WarPreparations;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Messages.War.Spy.Message_SpyPreparingForWar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CivPlans
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<AI_WarPreparations> warPreps = new ArrayList<AI_WarPreparations>();
    public int iWarPrepsSize = 0;
    public List<CivArmyMission> armiesMissions = new ArrayList<CivArmyMission>();

    public final void addNewWarPreps(int iLeaderCivID, int iCivID, int onCivID, int numOfTurns) {
        if (!CFG.core.getCivsAtWar(iCivID, onCivID)) {
            if (this.isPreparingForTheWar(onCivID)) {
                this.updatePrepsTime(onCivID, numOfTurns);
                return;
            }
            if (CFG.core.getCiv(onCivID).getIsPlayer() && (CFG.core.getCiv(iCivID).getPuppetOfCiv() == iCivID || !GameValues.gvWar.SPY_MESSAGE_ABOUT_AI_PREPARING_FOR_WAR_ONLY_FROM_LORDS) && CFG.oR.nextInt(1000) < CFG.GET_SPY_MESSAGE_ABOUT_AI_PREPARING_FOR_WAR_CHANCE_1000) {
                CFG.core.getCiv((int)onCivID).getCivDiploGD().messageBox.addMessage(new Message_SpyPreparingForWar(iCivID, onCivID));
            }
            this.warPreps.add(new AI_WarPreparations(iLeaderCivID, onCivID, true, numOfTurns));
            this.iWarPrepsSize = this.warPreps.size();
            try {
                CFG.core.getCiv((int)iCivID).uFOL = true;
                CFG.core.getCiv((int)onCivID).uFOL = true;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public final boolean isPreparingForTheWar() {
        return !this.warPreps.isEmpty();
    }

    public final boolean checkWarPreparations(int nCivID) {
        for (int i = 0; i < CFG.core.getCiv((int)nCivID).civGD.civPlans.warPreps.size(); ++i) {
            if (!CFG.core.getCivsAtWar(nCivID, CFG.core.getCiv((int)nCivID).civGD.civPlans.warPreps.get((int)i).onCivID)) continue;
            CFG.core.getCiv((int)nCivID).civGD.civPlans.warPreps.remove(i--);
            this.iWarPrepsSize = this.warPreps.size();
        }
        return !this.warPreps.isEmpty();
    }

    public final boolean isPreparingForTheWar(int onCivID) {
        for (int i = 0; i < this.warPreps.size(); ++i) {
            if (this.warPreps.get((int)i).onCivID != onCivID) continue;
            return true;
        }
        return false;
    }

    public final boolean isPreparingForTheWar(int iWarLeaderID, int onCivID) {
        for (int i = 0; i < this.warPreps.size(); ++i) {
            if (this.warPreps.get((int)i).onCivID != onCivID || this.warPreps.get((int)i).iLeaderCivID != iWarLeaderID) continue;
            return true;
        }
        return false;
    }

    public final void updatePrepsTime(int onCivID, int numOfTurns) {
        for (int i = 0; i < this.warPreps.size(); ++i) {
            if (this.warPreps.get((int)i).onCivID != onCivID) continue;
            this.warPreps.get((int)i).iNumOfTurnsLeft = numOfTurns;
            return;
        }
    }

    public final int getPrepsTime(int onCivID) {
        for (int i = 0; i < this.warPreps.size(); ++i) {
            if (this.warPreps.get((int)i).onCivID != onCivID) continue;
            return this.warPreps.get((int)i).iNumOfTurnsLeft;
        }
        return 0;
    }

    public final int getPreps_LeaderCivID(int onCivID) {
        for (int i = 0; i < this.warPreps.size(); ++i) {
            if (this.warPreps.get((int)i).onCivID != onCivID) continue;
            return this.warPreps.get((int)i).iLeaderCivID;
        }
        return 0;
    }

    public final boolean addNewArmyMission(int nProvinceID, CivArmyMission nMission) {
        for (int i = this.armiesMissions.size() - 1; i >= 0; --i) {
            if (this.armiesMissions.get((int)i).iProvinceID != nProvinceID) continue;
            return false;
        }
        this.armiesMissions.add(nMission);
        return true;
    }

    public final void checkArmyMissions(int nCivID) {
        for (int i = 0; i < this.armiesMissions.size(); ++i) {
            if (CFG.core.getProv(this.armiesMissions.get((int)i).iProvinceID).getArmyCivID1(nCivID) > 0) continue;
            this.armiesMissions.remove(i--);
        }
    }

    public final void removeMission(int nProvinceID) {
        for (int i = 0; i < this.armiesMissions.size(); ++i) {
            if (this.armiesMissions.get((int)nProvinceID).iProvinceID != nProvinceID) continue;
            this.armiesMissions.remove(i--);
            return;
        }
    }

    public final boolean haveMission(int nProvinceID) {
        for (int i = 0; i < this.armiesMissions.size(); ++i) {
            if (this.armiesMissions.get((int)i).iProvinceID != nProvinceID) continue;
            return true;
        }
        return false;
    }

    public final long haveMission_Army(int nProvinceID) {
        long out = 0;
        for (int i = 0; i < this.armiesMissions.size(); ++i) {
            if (this.armiesMissions.get((int)i).iProvinceID != nProvinceID) continue;
            out += this.armiesMissions.get((int)i).iArmy;
        }
        return out;
    }

    public final long haveMission_Army_ToProvinceID(int nProvinceID) {
        for (int i = 0; i < this.armiesMissions.size(); ++i) {
            if (this.armiesMissions.get((int)i).toProvinceID != nProvinceID) continue;
            return this.armiesMissions.get((int)i).iArmy;
        }
        return 0;
    }

    public final void updateObsolateMissions() {
        for (int i = 0; i < this.armiesMissions.size(); ++i) {
            if (this.armiesMissions.get((int)i).iObsolete-- > 0) continue;
            this.armiesMissions.remove(i--);
        }
    }
}

