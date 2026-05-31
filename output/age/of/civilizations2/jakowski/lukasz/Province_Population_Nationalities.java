
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class Province_Population_Nationalities
implements Serializable {
    private static final long serialVersionUID = 0L;
    private int iCivID;
    private long iPopulation;

    public Province_Population_Nationalities(int n, int n2) {
        this.iCivID = n;
        this.iPopulation = (long)n2;
    }

    public Province_Population_Nationalities(int n, long l) {
        this.iCivID = n;
        this.iPopulation = l;
    }

    public final int getCivID() {
        return this.iCivID;
    }

    public final long getPopulation() {
        return this.iPopulation;
    }

    public final void setPopulaton(int n) {
        this.iPopulation = (long)n;
    }

    public final void setPopulaton(long l) {
        this.iPopulation = l;
    }
}

