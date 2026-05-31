
package age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT;

import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.Vassal.PeaceTreaty_ReleaseableVassals;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.Vassal.PeaceTreaty_ReleaseableVassals_TakeConrol;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PeaceTreaty_Demands
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iCivID;
    public int iVictoryPointsLeft;
    public boolean peaceTreatyAccepted = false;
    public List<Integer> lDemands = new ArrayList<Integer>();
    public int iTotalNumOfVicotryPoints = 0;
    public List<Integer> lWarReparationsFromCivsID = new ArrayList<Integer>();
    public int iPaysWarReparationsToCivID = -1;
    public int changeGovernmentTypeToCivID = -1;
    public int changeReligionToCivID = -1;
    public List<Integer> lWillVassalizeCivsID = new ArrayList<Integer>();
    public int iWillBecomeVassalOfCivID = -1;
    public List<PeaceTreaty_ReleaseableVassals> lReleasableCivs = new ArrayList<PeaceTreaty_ReleaseableVassals>();
    public List<PeaceTreaty_ReleaseableVassals_TakeConrol> lReleasableCivs_TakeControl = new ArrayList<PeaceTreaty_ReleaseableVassals_TakeConrol>();

    public PeaceTreaty_Demands(int iCivID, int iVictoryPointsLeft) {
        this.iCivID = iCivID;
        this.iVictoryPointsLeft = iVictoryPointsLeft;
    }

    public final void addDemandOnProvince(int nProvinceID) {
        for (int i = 0; i < this.lDemands.size(); ++i) {
            if (this.lDemands.get(i) != nProvinceID) continue;
            return;
        }
        this.lDemands.add(nProvinceID);
    }

    public final void removeDemandOnProvince(int nProvinceID) {
        for (int i = 0; i < this.lDemands.size(); ++i) {
            if (this.lDemands.get(i) != nProvinceID) continue;
            this.lDemands.remove(i);
            break;
        }
    }

    public final void removeWarReparationsFromCivID(int nID) {
        for (int i = 0; i < this.lWarReparationsFromCivsID.size(); ++i) {
            if (this.lWarReparationsFromCivsID.get(i) != nID) continue;
            this.lWarReparationsFromCivsID.remove(i);
            return;
        }
    }

    public final void addWarReparationsFromCivID(int nID) {
        for (int i = 0; i < this.lWarReparationsFromCivsID.size(); ++i) {
            if (this.lWarReparationsFromCivsID.get(i) != nID) continue;
            return;
        }
        this.lWarReparationsFromCivsID.add(nID);
    }

    public final void removeTakeGovernmentFromCivID(int nID) {
    }

    public final void addTakeGovernmentFromCivID(int nID) {
    }

    public final void removeTakeReligionFromCivID(int nID) {
    }

    public final void addTakeReligionFromCivID(int nID) {
    }

    public final void removeWillVassalizeCivID(int nID) {
        for (int i = 0; i < this.lWillVassalizeCivsID.size(); ++i) {
            if (this.lWillVassalizeCivsID.get(i) != nID) continue;
            this.lWillVassalizeCivsID.remove(i);
            return;
        }
    }

    public final void addWillVassalizeCivID(int nID) {
        for (int i = 0; i < this.lWillVassalizeCivsID.size(); ++i) {
            if (this.lWillVassalizeCivsID.get(i) != nID) continue;
            return;
        }
        this.lWillVassalizeCivsID.add(nID);
    }

    public final void removeReleaseVassal_TakeControl(int nFromCivID, int nVassalID) {
        for (int i = 0; i < this.lReleasableCivs_TakeControl.size(); ++i) {
            if (this.lReleasableCivs_TakeControl.get((int)i).iFromCivID != nFromCivID || this.lReleasableCivs_TakeControl.get((int)i).iVassalCivID != nVassalID) continue;
            this.lReleasableCivs_TakeControl.remove(i);
            return;
        }
    }

    public final void addReleaseVassal_TakeControl(int nFromCivID, int nVassalID) {
        for (int i = 0; i < this.lReleasableCivs_TakeControl.size(); ++i) {
            if (this.lReleasableCivs_TakeControl.get((int)i).iFromCivID != nFromCivID || this.lReleasableCivs_TakeControl.get((int)i).iVassalCivID != nVassalID) continue;
            return;
        }
        this.lReleasableCivs_TakeControl.add(new PeaceTreaty_ReleaseableVassals_TakeConrol(nFromCivID, nVassalID));
    }
}

