
package age.of.civilizations2.jakowski.lukasz.Timelapse;

import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Timelapse_Stats_Population_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<List<Long>> lPopulation = new ArrayList<List<Long>>();

    public final void addPopulation(List<Long> tData) {
        this.lPopulation.add(tData);
        if (GameValues.gvTimelapse.GRAPH_DATA_LIMIT_POPULATION > 0 && this.lPopulation.size() > GameValues.gvTimelapse.GRAPH_DATA_LIMIT_POPULATION) {
            this.lPopulation.remove(0);
        }
    }
}
