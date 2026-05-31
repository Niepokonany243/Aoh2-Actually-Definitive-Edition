/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class Scenario_GameData_Diplomacy_Data
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iCivA;
    public int iCivB;
    public int iValue;

    public Scenario_GameData_Diplomacy_Data() {
    }

    public Scenario_GameData_Diplomacy_Data(int iCivA, int iCivB, int iValue) {
        this.iCivA = iCivA;
        this.iCivB = iCivB;
        this.iValue = iValue;
    }

    public final int getCivA() {
        return this.iCivA;
    }

    public final void setCivA(int iCivA) {
        this.iCivA = iCivA;
    }

    public final int getCivB() {
        return this.iCivB;
    }

    public final void setCivB(int iCivB) {
        this.iCivB = iCivB;
    }

    public final int getValue() {
        return this.iValue;
    }

    public final void setValue(int iValue) {
        this.iValue = iValue;
    }
}

