
package age.of.civilizations2.jakowski.lukasz.Timelapse;

import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Timelapse_Stats_Provinces_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<List<Integer>> lProvinces = new ArrayList<List<Integer>>();

    public final void addProvinces(List<Integer> tData) {
        this.lProvinces.add(tData);
        if (GameValues.gvTimelapse.GRAPH_DATA_LIMIT_PROVINCES > 0 && this.lProvinces.size() > GameValues.gvTimelapse.GRAPH_DATA_LIMIT_PROVINCES) {
            this.lProvinces.remove(0);
        }
    }
}

