
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PreDefined_Borders_Data_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    private List<Integer> lProvinces = new ArrayList<Integer>();
    private int iCapitalProvinceID = -1;

    public final void setCapitalProvinceID(int nProvinceID) {
        this.iCapitalProvinceID = nProvinceID;
    }

    public final int getCapitalProvinceID() {
        return this.iCapitalProvinceID;
    }

    public final int getProvincesSize() {
        return this.lProvinces.size();
    }

    public final int getProvinceID(int i) {
        return this.lProvinces.get(i);
    }

    public final boolean hasProvinceID(int nProvinceID) {
        for (int i = 0; i < this.lProvinces.size(); ++i) {
            if (this.lProvinces.get(i) != nProvinceID) continue;
            return true;
        }
        return false;
    }

    public final void addProvinceID(int nProvinceID) {
        for (int i = 0; i < this.lProvinces.size(); ++i) {
            if (this.lProvinces.get(i) != nProvinceID) continue;
            return;
        }
        this.lProvinces.add(nProvinceID);
    }

    public final void removeProvinceID(int nProvinceID) {
        for (int i = 0; i < this.lProvinces.size(); ++i) {
            if (this.lProvinces.get(i) != nProvinceID) continue;
            this.lProvinces.remove(i);
            return;
        }
    }
}

