
package age.of.civilizations2.jakowski.lukasz.Timelapse;

import java.io.Serializable;

public class Timelapse_TurnChanges
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iProvinceID;
    public int iToCivID;
    public boolean isOccupied = false;

    public Timelapse_TurnChanges(int iProvinceID, int iToCivID, boolean isOccupied) {
        this.iProvinceID = iProvinceID;
        this.iToCivID = iToCivID;
        this.isOccupied = isOccupied;
    }
}

