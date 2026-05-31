package age.of.civilizations2.jakowski.lukasz.AI.FrontLine;

import age.of.civilizations2.jakowski.lukasz.CFG;
import java.util.ArrayList;
import java.util.List;

public class AI_Frontline {
    public List<Integer> lProvinces = new ArrayList<Integer>();
    public int iRegionID = -1;
    public int iWithCivID = 0;
    public boolean bordersWithEnemy = false;

    public AI_Frontline(int nProvinceID, int iRegionID, int iWithCivID, boolean bordersWithEnemy) {
        this.lProvinces.add(nProvinceID);
        this.iRegionID = iRegionID;
        this.iWithCivID = iWithCivID;
        this.bordersWithEnemy = bordersWithEnemy;
    }

    public boolean containsProvince(int nProvinceID) {
        for (int i = 0; i < this.lProvinces.size(); ++i) {
            if (this.lProvinces.get(i) != nProvinceID) continue;
            return true;
        }
        return false;
    }

    public long getFrontLineArmy(int nCivID) {
        long out = 0;
        for (int i = this.lProvinces.size() - 1; i >= 0; --i) {
            out += CFG.core.getProv(this.lProvinces.get(i)).getArmyCivID1(nCivID);
        }
        return out;
    }
}
