/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Z_Other.Undo;

public class Undo_AssignProvinceCiv {
    private int iProvinceID;
    private int iCivID;

    public Undo_AssignProvinceCiv(int iProvinceID, int iCivID) {
        this.iProvinceID = iProvinceID;
        this.iCivID = iCivID;
    }

    public final int getProvinceID() {
        return this.iProvinceID;
    }

    public final int getCivID() {
        return this.iCivID;
    }
}

