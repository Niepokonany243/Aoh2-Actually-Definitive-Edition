/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class WarReparations
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iFromCivID = 0;
    public int iTurnsLeft = 0;

    public WarReparations(int iFromCivID, int iTurnsLeft) {
        this.iFromCivID = iFromCivID;
        this.iTurnsLeft = iTurnsLeft;
    }
}

