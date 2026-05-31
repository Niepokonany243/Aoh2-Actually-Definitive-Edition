
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;
import java.util.List;

public class Scenario_WastelandProvinces_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<Integer> lWastelandProvincesIDs;

    public Scenario_WastelandProvinces_GameData() {
    }

    public Scenario_WastelandProvinces_GameData(List<Integer> lProvinces) {
        this.lWastelandProvincesIDs = lProvinces;
    }

    public final int getWastelandProvincesSize() {
        return this.lWastelandProvincesIDs.size();
    }

    public final int getWastelandProvinceID(int i) {
        return this.lWastelandProvincesIDs.get(i);
    }
}

