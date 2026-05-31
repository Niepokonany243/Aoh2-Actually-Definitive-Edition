/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class Scenario_GameData_Diplomacy_VassalsData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iCivID;
    public int iCivLordID;

    public Scenario_GameData_Diplomacy_VassalsData() {
    }

    public Scenario_GameData_Diplomacy_VassalsData(int iCivID, int iCivLordID) {
        this.setCivID(iCivID);
        this.setCivLordID(iCivLordID);
    }

    public final int getCivID() {
        return this.iCivID;
    }

    public final void setCivID(int iCivID) {
        this.iCivID = iCivID;
    }

    public final int getCivLordID() {
        return this.iCivLordID;
    }

    public final void setCivLordID(int iCivLordID) {
        this.iCivLordID = iCivLordID;
    }
}

