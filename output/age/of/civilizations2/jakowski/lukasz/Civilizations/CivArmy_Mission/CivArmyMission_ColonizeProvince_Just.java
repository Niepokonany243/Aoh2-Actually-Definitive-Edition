/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission;
import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission_Type;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.GameManager;

public class CivArmyMission_ColonizeProvince_Just
extends CivArmyMission {
    private int iCivID;
    private int iColonizeProvinceID;

    public CivArmyMission_ColonizeProvince_Just(int nCivID, int colonizeProvinceID) {
        this.toProvinceID = colonizeProvinceID;
        this.iColonizeProvinceID = colonizeProvinceID;
        this.MISSION_ID = -1;
        this.iCivID = nCivID;
        this.MISSION_TYPE = CivArmyMission_Type.COLONIZE_PROVINCE;
        this.TURN_ID = GameCalendar.TURNID;
        this.iObsolete = (int)Math.max((float)CFG.core.getProvinSize() * 0.01f, 30.0f);
        this.iArmy = 0;
        this.generateColonizeData();
    }

    public final boolean generateColonizeData() {
        this.iProvinceID = -1;
        if (CFG.core.getCiv((int)this.iCivID).iBudget < 0) {
            this.iObsolete = 0;
            CFG.core.getCiv((int)this.iCivID).civGD.iLockTreasury = 1;
            return false;
        }
        for (int i = 0; i < CFG.core.getProv(this.iColonizeProvinceID).getNeighProvincesSize(); ++i) {
            if (this.iCivID != CFG.core.getProv(CFG.core.getProv(this.iColonizeProvinceID).getNeighProvinces(i)).getCivId()) continue;
            this.iProvinceID = CFG.core.getProv(this.iColonizeProvinceID).getNeighProvinces(i);
            break;
        }
        this.lockTreasury();
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
            CFG.core.getCiv((int)this.iCivID).civGD.iLockTreasury = 1;
            return true;
        }
        if (GameManager.colonizeProvince(this.iColonizeProvinceID, this.iCivID, false)) {
            CFG.core.getCiv((int)this.iCivID).civGD.iLockTreasury = 1;
            CFG.core.getCiv(this.iCivID).buildCivPersonality_Colonization();
            return true;
        }
        this.lockTreasury();
        return false;
    }

    public final void lockTreasury() {
        int colonizeCost = (int)((float)GameManager.getColonizeCost(this.iColonizeProvinceID, this.iCivID) * 1.05f);
        CFG.core.getCiv((int)this.iCivID).civGD.iLockTreasury = Math.max(CFG.core.getCiv((int)this.iCivID).civGD.iLockTreasury, colonizeCost);
        if (CFG.core.getCiv((int)this.iCivID).iBudget > 0) {
            this.iObsolete = CFG.core.getCiv(this.iCivID).getGold() > 0L && CFG.core.getCiv(this.iCivID).getGold() < (long)colonizeCost ? Math.max(this.iObsolete, Math.max(2, (int)Math.ceil((float)CFG.core.getCiv(this.iCivID).getGold() / (float)colonizeCost))) : Math.max(2, this.iObsolete);
        }
    }
}

