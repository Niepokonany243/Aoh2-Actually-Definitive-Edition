
package age.of.civilizations2.jakowski.lukasz.Civilizations;

import java.io.Serializable;

public class LoanCiv_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iGoldPerTurn;
    public int iTurnsLeft;
    public int fromCivID;

    public LoanCiv_GameData(int iGoldPerTurn, int iTurnsLeft, int fromCivID) {
        this.iGoldPerTurn = iGoldPerTurn;
        this.iTurnsLeft = iTurnsLeft;
        this.fromCivID = fromCivID;
    }
}

