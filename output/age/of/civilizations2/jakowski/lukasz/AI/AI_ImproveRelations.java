
package age.of.civilizations2.jakowski.lukasz.AI;

import java.io.Serializable;

public class AI_ImproveRelations
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iCivID;
    public int iMinRelation;
    public int iUntilTurnID;

    public AI_ImproveRelations(int iCivID, int iMinRelation, int iUntilTurnID) {
        this.iCivID = iCivID;
        this.iMinRelation = iMinRelation;
        this.iUntilTurnID = iUntilTurnID;
    }
}

