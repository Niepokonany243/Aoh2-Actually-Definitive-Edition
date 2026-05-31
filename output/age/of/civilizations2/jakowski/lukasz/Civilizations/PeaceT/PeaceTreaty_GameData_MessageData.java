
package age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.PeaceTreaty_GameData;
import java.io.Serializable;

public class PeaceTreaty_GameData_MessageData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public String PEACE_TREATY_TAG;
    public PeaceTreaty_GameData peaceTreaty_GameData;

    public PeaceTreaty_GameData_MessageData(PeaceTreaty_GameData peaceTreaty_GameData) {
        this.peaceTreaty_GameData = peaceTreaty_GameData;
        this.PEACE_TREATY_TAG = "" + System.currentTimeMillis() + CFG.extraRandomTag();
    }
}

