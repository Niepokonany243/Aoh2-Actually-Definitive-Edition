
package age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.Vassal;

import age.of.civilizations2.jakowski.lukasz.CFG;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PeaceTreaty_ReleaseableVassals
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iCivID;
    public List<Integer> lProvinces = new ArrayList<Integer>();
    public int iReleasesToCivID = -1;

    public PeaceTreaty_ReleaseableVassals(int iCivID, int iProvinceID) {
        this.iCivID = iCivID;
        this.lProvinces.add(iProvinceID);
    }

    public int getScoreValue() {
        int out = 0;
        for (int i = 0; i < this.lProvinces.size(); ++i) {
            out += CFG.core.getProvinceValue(this.lProvinces.get(i));
        }
        return Math.max(out, 1);
    }

    public final void addProvince(int nProvinceID) {
        for (int i = 0; i < this.lProvinces.size(); ++i) {
            if (this.lProvinces.get(i) != nProvinceID) continue;
            return;
        }
        this.lProvinces.add(nProvinceID);
    }
}

