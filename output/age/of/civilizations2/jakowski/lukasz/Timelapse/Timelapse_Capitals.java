/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Timelapse;

import age.of.civilizations2.jakowski.lukasz.Timelapse.Timelapse_Capital;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Timelapse_Capitals
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<Timelapse_Capital> lCapitals = new ArrayList<Timelapse_Capital>();

    public Timelapse_Capitals(int iProvinceID, int iSinceTurnID) {
        this.lCapitals.add(new Timelapse_Capital(iProvinceID, iSinceTurnID));
    }

    public void updateCapital(int iProvinceID, int iSinceTurnID) {
        try {
            if (this.lCapitals.get((int)(this.lCapitals.size() - 1)).iProvinceID != iProvinceID) {
                this.lCapitals.add(new Timelapse_Capital(iProvinceID, iSinceTurnID));
            }
        }
        catch (IndexOutOfBoundsException ex) {
            this.lCapitals.add(new Timelapse_Capital(iProvinceID, iSinceTurnID));
        }
    }

    public int getCapitalID(int iTurnID) {
        for (int i = 0; i < this.lCapitals.size() - 1; ++i) {
            if (this.lCapitals.get((int)i).iSinceTurnID > iTurnID || this.lCapitals.get((int)(i + 1)).iSinceTurnID <= iTurnID) continue;
            return this.lCapitals.get((int)i).iProvinceID;
        }
        return this.lCapitals.get((int)(this.lCapitals.size() - 1)).iProvinceID;
    }
}

