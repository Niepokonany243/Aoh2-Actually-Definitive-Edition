
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class Civilization_Sanctions
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int byCivID;
    public int onCivID;
    public float impact = 0.0f;
    public int untilTurnID = 0;

    public Civilization_Sanctions(int byCivID, int onCivID, float impact, int untilTurnID) {
        this.byCivID = byCivID;
        this.onCivID = onCivID;
        this.impact = impact;
        this.untilTurnID = untilTurnID;
    }
}

