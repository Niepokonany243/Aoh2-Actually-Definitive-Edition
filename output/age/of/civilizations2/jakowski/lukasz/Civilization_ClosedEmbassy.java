
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class Civilization_ClosedEmbassy
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iCivID = 0;
    public int iNumOfTurns = 0;

    public Civilization_ClosedEmbassy(int iCivID, int iNumOfTurns) {
        this.iCivID = iCivID;
        this.iNumOfTurns = iNumOfTurns;
    }
}

