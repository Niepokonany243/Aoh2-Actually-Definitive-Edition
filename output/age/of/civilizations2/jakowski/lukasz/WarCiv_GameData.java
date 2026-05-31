
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class WarCiv_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iCivID = 0;
    public long iCasualties = 0L;
    public long iCivilianDeaths = 0L;
    public long iEconomicLosses = 0L;
    public int iConqueredProvinces = 0;

    public WarCiv_GameData(int iCivID) {
        this.iCivID = iCivID;
    }

    public final int getCivID() {
        return this.iCivID;
    }

    public final void setCivID(int iCivID) {
        this.iCivID = iCivID;
    }

    public final long getCasualties() {
        return this.iCasualties;
    }

    public final void addCasualties(long nCasualties) {
        this.iCasualties += nCasualties;
    }

    public final void addCasualties(int nCasualties) {
        this.addCasualties((long)nCasualties);
    }

    public final long getCivilianDeaths() {
        return this.iCivilianDeaths;
    }

    public final void addCivilianDeaths(long nCivilianDeaths) {
        this.iCivilianDeaths += nCivilianDeaths;
    }

    public final long getEconomicLosses() {
        return this.iEconomicLosses;
    }

    public final void addEconomicLosses(long nEconomicLosses) {
        this.iEconomicLosses += nEconomicLosses;
    }

    public final int getConqueredProvinces() {
        return this.iConqueredProvinces;
    }

    public final void setConqueredProvinces(int iConqueredProvinces) {
        this.iConqueredProvinces = iConqueredProvinces;
    }

    public final void addConqueredProvinces() {
        ++this.iConqueredProvinces;
    }
}
