
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class Civilization_Friends_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iCivID;
    public int iSinceTurnID = 0;

    public Civilization_Friends_GameData(int iCivID, int iSinceTurnID) {
        this.iCivID = iCivID;
        this.iSinceTurnID = iSinceTurnID;
    }
}

