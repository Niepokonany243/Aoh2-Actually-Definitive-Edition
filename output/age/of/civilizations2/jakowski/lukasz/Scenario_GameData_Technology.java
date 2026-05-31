/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class Scenario_GameData_Technology
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iContinentID;
    public int iPercentage;

    public Scenario_GameData_Technology() {
    }

    public Scenario_GameData_Technology(int iContinentID, int iPercentage) {
        this.iContinentID = iContinentID;
        this.iPercentage = iPercentage;
    }

    public final int getPercentage() {
        return this.iPercentage;
    }

    public final void setPercentage(int iPercentage) {
        this.iPercentage = iPercentage;
    }

    public final int getContinentID() {
        return this.iContinentID;
    }

    public final void setContinentID(int iContinentID) {
        this.iContinentID = iContinentID;
    }
}

