/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Civilizations;

import java.io.Serializable;

public class Civ_Gift_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iFromCivID;
    public int iTurnID;

    public Civ_Gift_GameData(int iFromCivID, int iTurnID) {
        this.iFromCivID = iFromCivID;
        this.iTurnID = iTurnID;
    }
}

