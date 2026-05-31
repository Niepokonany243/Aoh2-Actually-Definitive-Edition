package age.of.civilizations2.jakowski.lukasz.AI.Province;

import age.of.civilizations2.jakowski.lukasz.CFG;
import java.util.ArrayList;
import java.util.List;

public class AI_ProvinceInfo_War {
    public int iProvinceID;
    public float iValue;
    public boolean ownFrontProvince = false;
    public List<Integer> lProvinces_Enemy = new ArrayList<Integer>();

    public AI_ProvinceInfo_War(int iProvinceID, int iValue, boolean ownFrontProvince) {
        this.iProvinceID = iProvinceID;
        this.iValue = iValue;
        this.ownFrontProvince = ownFrontProvince;
    }

    public final void buildEnemyProvinces(int nCivID) {
        for (int i = 0; i < CFG.core.getProv(this.iProvinceID).getNeighProvincesSize(); ++i) {
            if (!CFG.core.getCivsAtWar(nCivID, CFG.core.getProv(CFG.core.getProv(this.iProvinceID).getNeighProvinces(i)).getCivId())) continue;
            this.lProvinces_Enemy.add(CFG.core.getProv(this.iProvinceID).getNeighProvinces(i));
        }
    }

    public final boolean enemyProvinceBordersWithOurTrueProvince(int nCivID) {
        for (int i = 0; i < this.lProvinces_Enemy.size(); ++i) {
            for (int j = 0; j < CFG.core.getProv(this.lProvinces_Enemy.get(i)).getNeighProvincesSize(); ++j) {
                if (CFG.core.getProv(CFG.core.getProv(this.lProvinces_Enemy.get(i)).getNeighProvinces(j)).getCivId() != nCivID) continue;
                return true;
            }
        }
        return false;
    }

    public final boolean isOccupied() {
        return CFG.core.getProv(this.iProvinceID).isOccupied();
    }

    public final long getArmy(int nCivID) {
        return CFG.core.getProv(this.iProvinceID).getArmyCivID1(nCivID);
    }

    public final int getRecruitableArmy(int nCivID) {
        return CFG.gameAction.gMARY(this.iProvinceID, nCivID);
    }
}
