/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Province_GameData_Occupied
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<Integer> provinceID = new ArrayList<Integer>();
    public List<Integer> civID = new ArrayList<Integer>();

    public void addData(int provinceID, int civID) {
        this.provinceID.add(provinceID);
        this.civID.add(civID);
    }
}

