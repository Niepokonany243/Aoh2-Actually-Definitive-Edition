
package age.of.civilizations2.jakowski.lukasz.Timelapse;

import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Timelapse_Stats_History_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<List<HistoryLog>> lHistory = new ArrayList<List<HistoryLog>>();
}

