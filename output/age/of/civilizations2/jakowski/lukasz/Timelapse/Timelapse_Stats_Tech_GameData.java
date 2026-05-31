
package age.of.civilizations2.jakowski.lukasz.Timelapse;

import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Timelapse_Stats_Tech_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<List<Integer>> lTechnologyLevel = new ArrayList<List<Integer>>();

    public final void addTechLevel(List<Integer> tData) {
        this.lTechnologyLevel.add(tData);
        if (GameValues.gvTimelapse.GRAPH_DATA_LIMIT_TECH_LEVEL > 0 && this.lTechnologyLevel.size() > GameValues.gvTimelapse.GRAPH_DATA_LIMIT_TECH_LEVEL) {
            this.lTechnologyLevel.remove(0);
        }
    }
}

