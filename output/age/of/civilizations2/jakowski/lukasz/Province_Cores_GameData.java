/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Province_Cores_Provinces_GameData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Province_Cores_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public List<Province_Cores_Provinces_GameData> lProvinces = new ArrayList<Province_Cores_Provinces_GameData>();

    public final int getProvincesSize() {
        return this.lProvinces.size();
    }

    public final void addCore(int nProvinceID, int nCivID) {
        this.addCore(nProvinceID, nCivID, 100);
    }

    public final void addCore(int nProvinceID, int nCivID, int nPerc) {
        if (nCivID == 0) {
            return;
        }
        int iSize = this.lProvinces.size();
        for (int i = 0; i < iSize; ++i) {
            if (this.lProvinces.get((int)i).iProvinceID != nProvinceID) continue;
            this.lProvinces.get(i).addCore(nCivID, nPerc);
            return;
        }
        this.lProvinces.add(new Province_Cores_Provinces_GameData(nProvinceID, nCivID, 100));
    }

    public final void removeCore(int nProvinceID, int nCivID) {
        int iSize = this.lProvinces.size();
        for (int i = 0; i < iSize; ++i) {
            if (this.lProvinces.get((int)i).iProvinceID != nProvinceID) continue;
            this.lProvinces.get(i).removeCore(nCivID);
            return;
        }
    }

    public final void updatePercOfPopulation(int nProvinceID, int nCivID, int nPerc) {
        int i;
        for (i = 0; i < this.lProvinces.size(); ++i) {
            if (this.lProvinces.get((int)i).iProvinceID != nProvinceID) continue;
            this.lProvinces.get(i).updateCorePercOfPopulation(nCivID, nPerc);
            return;
        }
        this.addCore(nProvinceID, nCivID, nPerc);
        for (i = 0; i < this.lProvinces.size(); ++i) {
            if (this.lProvinces.get((int)i).iProvinceID != nProvinceID) continue;
            this.lProvinces.get(i).updateCorePercOfPopulation(nCivID, nPerc);
            return;
        }
    }

    public final void updateAfterRemove(int nRemovedCivID) {
        for (int i = 0; i < this.lProvinces.size(); ++i) {
            if (CFG.core.getProv(this.lProvinces.get((int)i).iProvinceID).getCivId() == 0) {
                this.lProvinces.remove(i--);
                continue;
            }
            this.lProvinces.get(i).updateAfterRemove(nRemovedCivID);
            if (this.lProvinces.get((int)i).lCores.size() >= 1) continue;
            this.lProvinces.remove(i--);
        }
    }

    public final float getPercOfPop(int nProvinceID, int nCivID) {
        int iSize = this.lProvinces.size();
        for (int i = 0; i < iSize; ++i) {
            if (this.lProvinces.get((int)i).iProvinceID != nProvinceID) continue;
            return this.lProvinces.get(i).getPercOfPop(nCivID);
        }
        return 1.0f;
    }

    public final void clearCoresData(int nProvinceID) {
        for (int i = 0; i < this.lProvinces.size(); ++i) {
            if (this.lProvinces.get((int)i).iProvinceID != nProvinceID) continue;
            this.lProvinces.remove(i);
            return;
        }
    }

    public final void clearUselessData() {
        for (int i = 0; i < this.lProvinces.size(); ++i) {
            if (this.lProvinces.get((int)i).lCores.size() >= 2) continue;
            this.lProvinces.remove(i--);
        }
    }
}

