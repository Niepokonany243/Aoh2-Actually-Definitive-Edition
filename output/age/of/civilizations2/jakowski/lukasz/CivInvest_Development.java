
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class CivInvest_Development
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int provinceID;
    public int turnsLeft;
    public float iDevelopmentLeft;
    public float iDevelopmentPerTurn;

    public CivInvest_Development(int provinceID, int turnsLeft, float iDevelopmentLeft, float iDevelopmentPerTurn) {
        this.provinceID = provinceID;
        this.turnsLeft = turnsLeft;
        this.iDevelopmentLeft = iDevelopmentLeft;
        this.iDevelopmentPerTurn = iDevelopmentPerTurn;
    }
}

