/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WastelandMap_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    private String sName = "";
    private List<Integer> lWastelandProvincesIDs = new ArrayList<Integer>();

    public final void generateData() {
        if (this.lWastelandProvincesIDs != null) {
            this.lWastelandProvincesIDs.clear();
        } else {
            this.lWastelandProvincesIDs = new ArrayList<Integer>();
        }
        for (int i = 0; i < CFG.core.getProvinSize(); ++i) {
            if (CFG.core.getProv(i).getWastelandLvl() < 0) continue;
            this.lWastelandProvincesIDs.add(i);
        }
    }

    public final String getName() {
        return this.sName;
    }

    public final void setName(String sName) {
        this.sName = sName;
    }

    public final int getWastelandProvincesSize() {
        return this.lWastelandProvincesIDs.size();
    }

    public final int getWastelandProvinceID(int i) {
        return this.lWastelandProvincesIDs.get(i);
    }
}

