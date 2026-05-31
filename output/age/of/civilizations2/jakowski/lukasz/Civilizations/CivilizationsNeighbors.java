
package age.of.civilizations2.jakowski.lukasz.Civilizations;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Province;
import java.util.ArrayList;
import java.util.List;

public class CivilizationsNeighbors {
    public List<CivNeighbor> civs = new ArrayList<CivNeighbor>();
    public int civsSize = 0;

    public final void buildNeighbors(int civID) {
        this.civs.clear();
        this.civsSize = 0;
        try {
            for (int i = 0; i < CFG.core.getCiv(civID).getNumOfProvs(); ++i) {
                int provinceID = CFG.core.getCiv(civID).getProvID(i);
                if (provinceID < 0) continue;
                this.addLandNeighbors(CFG.core.getProv(provinceID), civID);
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        this.civsSize = this.civs.size();
    }

    private void addLandNeighbors(Province province, int civID) {
        int numNeighbors = province.getNeighProvincesSize();
        for (int j = 0; j < numNeighbors; ++j) {
            int neighborCivID = CFG.core.getProv(province.getNeighProvinces(j)).getCivId();
            if (neighborCivID <= 0 || neighborCivID == civID) continue;
            this.addCiv(neighborCivID);
        }
    }

    public boolean isNeighbor(int civID) {
        for (int i = 0; i < this.civsSize; ++i) {
            if (this.civs.get((int)i).civID != civID) continue;
            return true;
        }
        return false;
    }

    public void addCiv(int civID) {
        for (int i = this.civs.size() - 1; i >= 0; --i) {
            if (this.civs.get((int)i).civID != civID) continue;
            return;
        }
        this.civs.add(new CivNeighbor(civID));
    }

    public class CivNeighbor {
        public int civID;

        public CivNeighbor() {
        }

        public CivNeighbor(int civID) {
            this.civID = civID;
        }
    }
}

