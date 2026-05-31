
package age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT;

import age.of.civilizations2.jakowski.lukasz.CFG;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PeaceTreaty_Civs
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iCivID;
    public List<Integer> lProvincesLost = new ArrayList<Integer>();
    public boolean showProvinces = false;

    public PeaceTreaty_Civs(int iCivID) {
        this.iCivID = iCivID;
    }

    public final void addProvince(int nProvinceID) {
        for (int i = 0; i < this.lProvincesLost.size(); ++i) {
            if (this.lProvincesLost.get(i) == nProvinceID) {
                return;
            }
        }
        this.lProvincesLost.add(nProvinceID);
    }

    public final int getVictoryPointsTotal() {
        int out = 0;
        for (int i = 0; i < this.lProvincesLost.size(); ++i) {
            out += CFG.core.getProvinceValue(this.lProvincesLost.get(i));
        }
        return out;
    }
}

