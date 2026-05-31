package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ultimatum_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public boolean demandAnexation = false;
    public boolean demandVasalization = false;
    public boolean demandMilitaryAccess = false;
    public List<Integer> demandProvinces = new ArrayList<Integer>();
    public List<Integer> demandLiberation = new ArrayList<Integer>();
    public boolean demandChangeOfGovernment = false;
    public long numOfUntis = 0L;

    public boolean isLiberationDemanded(int nCivID) {
        for (int i = 0; i < this.demandLiberation.size(); ++i) {
            if (this.demandLiberation.get(i) != nCivID) continue;
            return true;
        }
        return false;
    }

    public void updateLiberationDemand(int nCivID) {
        for (int i = 0; i < this.demandLiberation.size(); ++i) {
            if (this.demandLiberation.get(i) != nCivID) continue;
            this.demandLiberation.remove(i);
            return;
        }
        this.demandLiberation.add(nCivID);
    }

    public final boolean canBeSend() {
        return this.demandAnexation || this.demandVasalization || this.demandMilitaryAccess || this.demandProvinces.size() > 0 || this.demandLiberation.size() > 0 || this.demandChangeOfGovernment;
    }
}
