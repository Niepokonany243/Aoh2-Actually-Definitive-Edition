/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.AI;

import java.io.Serializable;

public class AI_CivsInRange
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iCivID;
    public float fDistance;

    public AI_CivsInRange(int iCivID, float fDistance) {
        this.iCivID = iCivID;
        this.fDistance = fDistance;
    }
}

