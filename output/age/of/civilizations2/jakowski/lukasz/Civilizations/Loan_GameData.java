
package age.of.civilizations2.jakowski.lukasz.Civilizations;

import java.io.Serializable;

public class Loan_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iGoldPerTurn;
    public int iTurnsLeft;

    public Loan_GameData(int iGoldPerTurn, int iTurnsLeft) {
        this.iGoldPerTurn = iGoldPerTurn;
        this.iTurnsLeft = iTurnsLeft;
    }
}

