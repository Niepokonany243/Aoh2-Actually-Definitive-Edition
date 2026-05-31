
package age.of.civilizations2.jakowski.lukasz.Save.SaveGameData;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;
import age.of.civilizations2.jakowski.lukasz.Save.Save_Civ_GameData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Save_GameData_2
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<Save_Civ_GameData> lCivsData = new ArrayList<Save_Civ_GameData>();

    public final void buildData(int startID) {
        int i = startID;
        for (int j = 0; i < CFG.core.getCivsSize() && j < SaveGameManager.CIVS_PER_FILE; ++i, ++j) {
            this.lCivsData.add(CFG.core.getCiv((int)i).civGD);
        }
    }
}

