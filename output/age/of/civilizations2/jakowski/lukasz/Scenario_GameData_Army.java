
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class Scenario_GameData_Army
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iProvinceID;
    public int iCivID;
    public long iArmy;

    public Scenario_GameData_Army() {
    }

    public Scenario_GameData_Army(int iProvinceID, int iCivID, long iArmy) {
        this.iProvinceID = iProvinceID;
        this.iCivID = iCivID;
        this.iArmy = iArmy;
    }

    public final int getProvinceID() {
        return this.iProvinceID;
    }

    public final int getCivID() {
        return this.iCivID;
    }

    public final long getArmy() {
        return this.iArmy;
    }
}

