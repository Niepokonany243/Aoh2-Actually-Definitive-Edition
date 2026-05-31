/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.AI;

import java.io.Serializable;

public class AI_Rival
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iCivID;
    public int iUntilTurnID;

    public AI_Rival(int iCivID, int iUntilTurnID) {
        this.iCivID = iCivID;
        this.iUntilTurnID = iUntilTurnID;
    }
}

