
package age.of.civilizations2.jakowski.lukasz.AI;

import java.util.ArrayList;
import java.util.List;

public class AI_ReleaseVassal {
    public int iCivID;
    public List<Integer> lProvinces = new ArrayList<Integer>();

    public AI_ReleaseVassal(int iCivID, int nProvinceID) {
        this.iCivID = iCivID;
        this.addProvince(nProvinceID);
    }

    public final void addProvince(int nProvinceID) {
        this.lProvinces.add(nProvinceID);
    }

    public final boolean haveProvince(int nProvinceID) {
        for (int i = this.lProvinces.size() - 1; i >= 0; --i) {
            if (this.lProvinces.get(i) != nProvinceID) continue;
            return true;
        }
        return false;
    }

    public final boolean removeProvinceID(int nProvinceID) {
        for (int i = this.lProvinces.size() - 1; i >= 0; --i) {
            if (this.lProvinces.get(i) != nProvinceID) continue;
            this.lProvinces.remove(i);
            return true;
        }
        return false;
    }
}

