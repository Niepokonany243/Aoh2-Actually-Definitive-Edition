
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class PlayerAIPeace_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iCivID;
    public int turnID;

    public PlayerAIPeace_GameData(int iCivID, int turnID) {
        this.iCivID = iCivID;
        this.turnID = turnID;
    }
}

