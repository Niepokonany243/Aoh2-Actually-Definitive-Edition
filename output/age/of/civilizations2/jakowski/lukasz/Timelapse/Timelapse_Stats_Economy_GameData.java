
package age.of.civilizations2.jakowski.lukasz.Timelapse;

import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Timelapse_Stats_Economy_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<List<Long>> lEconomy = new ArrayList<List<Long>>();

    public final void addData(List<Long> tData) {
        this.lEconomy.add(tData);
        if (GameValues.gvTimelapse.GRAPH_DATA_LIMIT_ECONOMY > 0 && this.lEconomy.size() > GameValues.gvTimelapse.GRAPH_DATA_LIMIT_ECONOMY) {
            this.lEconomy.remove(0);
        }
    }
}
