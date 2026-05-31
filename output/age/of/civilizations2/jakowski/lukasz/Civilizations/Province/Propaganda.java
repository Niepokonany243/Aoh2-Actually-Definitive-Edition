/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Civilizations.Province;

import java.io.Serializable;

public class Propaganda
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int byCivID = 0;
    public int provinceID = 0;
    public int endTurnID = 0;

    public Propaganda(int byCivID, int provinceID, int endTurnID) {
        this.byCivID = byCivID;
        this.provinceID = provinceID;
        this.endTurnID = endTurnID;
    }
}

