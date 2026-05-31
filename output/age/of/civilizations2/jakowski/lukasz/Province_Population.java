/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Province_Population_Nationalities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Province_Population
implements Serializable {
    private static final long serialVersionUID = 0L;
    private double iPopulation = 0.0;
    private List<Province_Population_Nationalities> lNationalities = new ArrayList<Province_Population_Nationalities>();
    private int iNationalitiesSize = 0;

    public final void updatePopulationOfProvince() {
        this.iPopulation = 0.0;
        for (int i = 0; i < this.iNationalitiesSize; ++i) {
            this.iPopulation += (double)this.lNationalities.get(i).getPopulation();
        }
    }

    public final long getPopulationID(int n) {
        return this.lNationalities.get(n).getPopulation();
    }

    public final long getPopulationOfCivID(int n) {
        for (int i = 0; i < this.iNationalitiesSize; ++i) {
            if (this.lNationalities.get(i).getCivID() != n) continue;
            return this.lNationalities.get(i).getPopulation();
        }
        return 0L;
    }

    public final boolean setPopulationOfCivID(int n, int n2) {
        return this.setPopulationOfCivID(n, (long)n2);
    }

    public final synchronized boolean setPopulationOfCivID(int n, long l) {
        for (int i = 0; i < this.iNationalitiesSize; ++i) {
            if (this.lNationalities.get(i).getCivID() != n) continue;
            if (l <= 0L) {
                if (this.lNationalities.size() > 1) {
                    this.iPopulation -= (double)this.lNationalities.get(i).getPopulation();
                    this.lNationalities.remove(i);
                    this.iNationalitiesSize = this.lNationalities.size();
                    return true;
                }
                this.lNationalities.get(i).setPopulaton(10L);
                this.iPopulation = 10.0;
            } else {
                this.iPopulation -= (double)this.lNationalities.get(i).getPopulation();
                this.iPopulation += (double)l;
                this.lNationalities.get(i).setPopulaton(l);
            }
            return false;
        }
        if (l > 0L) {
            this.lNationalities.add(new Province_Population_Nationalities(n, l));
            this.iPopulation += (double)l;
            this.iNationalitiesSize = this.lNationalities.size();
        }
        return false;
    }

    public final synchronized void clearData() {
        this.iPopulation = 0.0;
        this.lNationalities.clear();
        this.iNationalitiesSize = 0;
    }

    public final long getPops() {
        return (long)this.iPopulation;
    }

    public final int getNatsSize() {
        return this.iNationalitiesSize;
    }

    public final int getCivID(int n) {
        return this.lNationalities.get(n).getCivID();
    }
}

