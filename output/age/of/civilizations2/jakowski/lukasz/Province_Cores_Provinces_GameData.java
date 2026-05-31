/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Province_Cores_Civs_GameData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Province_Cores_Provinces_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iProvinceID;
    public List<Province_Cores_Civs_GameData> lCores = new ArrayList<Province_Cores_Civs_GameData>();

    public Province_Cores_Provinces_GameData() {
    }

    public Province_Cores_Provinces_GameData(int nProvinceID, int nCivID, int nPerc) {
        this.iProvinceID = nProvinceID;
        this.addCore(nCivID, nPerc);
    }

    public final void addCore(int nCivID, int nPerc) {
        for (int i = 0; i < this.lCores.size(); ++i) {
            if (this.lCores.get((int)i).iCivID != nCivID) continue;
            return;
        }
        this.lCores.add(new Province_Cores_Civs_GameData(nCivID, Math.min(nPerc, 100 - this.lCores.size())));
        this.updateCorePercOfPopulation(nCivID, nPerc);
    }

    public final void updateCorePercOfPopulation(int nCivID, int nPerc) {
        if (this.lCores.size() > 1) {
            for (int i = 0; i < this.lCores.size(); ++i) {
                if (this.lCores.get((int)i).iCivID != nCivID) continue;
                this.lCores.get(i).setPerc((float)nPerc / 100.0f);
                break;
            }
            float tempPercAll = 0.0f;
            for (int i = 0; i < this.lCores.size(); ++i) {
                tempPercAll += this.lCores.get((int)i).fPercPop;
            }
            if (tempPercAll > 1.0f) {
                int i;
                float tempTotal = 0.0f;
                float tempCivTotal = 0.0f;
                for (int i2 = 0; i2 < this.lCores.size(); ++i2) {
                    if (this.lCores.get((int)i2).iCivID != nCivID) {
                        tempTotal += this.lCores.get((int)i2).fPercPop;
                        continue;
                    }
                    this.lCores.get(i2).setPerc((float)Math.min(nPerc, 100 - this.lCores.size()) / 100.0f);
                    tempCivTotal = this.lCores.get((int)i2).fPercPop;
                }
                float tDiff = 1.0f - Math.min(1.0f, tempCivTotal);
                for (i = 0; i < this.lCores.size(); ++i) {
                    if (this.lCores.get((int)i).iCivID == nCivID) continue;
                    this.lCores.get(i).setPerc(tDiff * this.lCores.get((int)i).fPercPop / tempTotal);
                }
                tempTotal = 0.0f;
                for (i = 0; i < this.lCores.size(); ++i) {
                    tempTotal += this.lCores.get((int)i).fPercPop;
                }
                if ((tempTotal = 1.0f - tempTotal) > 0.0f) {
                    this.lCores.get(this.lCores.size() - 1).setPerc(this.lCores.get((int)(this.lCores.size() - 1)).fPercPop + tempTotal);
                }
            }
        } else if (this.lCores.size() > 0) {
            if (nPerc > 100) {
                this.lCores.get(0).setPerc(1.0f);
            } else if (nPerc < 1) {
                this.lCores.get(0).setPerc(0.01f);
            } else {
                this.lCores.get(0).setPerc((float)nPerc / 100.0f);
            }
        }
    }

    public final void removeCore(int nCivID) {
        for (int i = 0; i < this.lCores.size(); ++i) {
            if (this.lCores.get((int)i).iCivID != nCivID) continue;
            this.lCores.remove(i);
            return;
        }
    }

    public final float getPercOfPop(int nCivID) {
        for (int i = 0; i < this.lCores.size(); ++i) {
            if (this.lCores.get((int)i).iCivID != nCivID) continue;
            return this.lCores.get((int)i).fPercPop;
        }
        return 0.0f;
    }

    public final void updateAfterRemove(int nRemovedCivID) {
        for (int i = 0; i < this.lCores.size(); ++i) {
            if (this.lCores.get((int)i).iCivID > nRemovedCivID) {
                --this.lCores.get((int)i).iCivID;
                continue;
            }
            if (this.lCores.get((int)i).iCivID != nRemovedCivID) continue;
            this.lCores.remove(i--);
        }
    }
}

