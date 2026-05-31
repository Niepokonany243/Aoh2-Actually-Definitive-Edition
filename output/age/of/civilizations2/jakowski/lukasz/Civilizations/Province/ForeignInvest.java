
package age.of.civilizations2.jakowski.lukasz.Civilizations.Province;

import java.io.Serializable;

public class ForeignInvest
implements Serializable {
    private static final long serialVersionUID = 1L;
    public int civID = 0;
    public long gold = 0L;
    public long profit = 0L;
    public int provinceID = 0;
    public int inCivID = 0;
    public int returnTurnID;
}

