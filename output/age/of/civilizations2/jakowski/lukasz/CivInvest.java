/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class CivInvest
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int provinceID;
    public int turnsLeft;
    public float iEconomyLeft;
    public float iEconomyPerTurn;

    public CivInvest(int provinceID, int turnsLeft, float iEconomyLeft, float iEconomyPerTurn) {
        this.provinceID = provinceID;
        this.turnsLeft = turnsLeft;
        this.iEconomyLeft = iEconomyLeft;
        this.iEconomyPerTurn = iEconomyPerTurn;
    }
}

