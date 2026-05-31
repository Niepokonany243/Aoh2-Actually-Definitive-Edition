/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Civilizations.PeaceT.Vassal;

import java.io.Serializable;

public class PeaceTreaty_ReleaseableVassals_TakeConrol
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iFromCivID;
    public int iVassalCivID;

    public PeaceTreaty_ReleaseableVassals_TakeConrol(int iFromCivID, int iVassalCivID) {
        this.iFromCivID = iFromCivID;
        this.iVassalCivID = iVassalCivID;
    }
}

