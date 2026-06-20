
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class CivTask
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iProvinceID;
    public int iTurnsLeft;
    public boolean armyStabilization;
    public float armyStabilizationRate = 1.0f;

    public CivTask(int iProvinceID, int iTurnsLeft) {
        this.iProvinceID = iProvinceID;
        this.iTurnsLeft = iTurnsLeft;
    }

    public CivTask(int iProvinceID, int iTurnsLeft, boolean armyStabilization) {
        this.iProvinceID = iProvinceID;
        this.iTurnsLeft = iTurnsLeft;
        this.armyStabilization = armyStabilization;
        this.armyStabilizationRate = armyStabilization ? 0.5f : 1.0f;
    }

    public CivTask(int iProvinceID, int iTurnsLeft, boolean armyStabilization, float armyStabilizationRate) {
        this.iProvinceID = iProvinceID;
        this.iTurnsLeft = iTurnsLeft;
        this.armyStabilization = armyStabilization;
        this.armyStabilizationRate = armyStabilizationRate;
    }
}

