
package age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission;

import age.of.civilizations2.jakowski.lukasz.Civilizations.CivArmy_Mission.CivArmyMission_Type;
import java.io.Serializable;

public class CivArmyMission
implements Serializable {
    private static final long serialVersionUID = 0L;
    public CivArmyMission_Type MISSION_TYPE = CivArmyMission_Type.PREAPARE_FOR_WAR;
    public int iProvinceID;
    public int toProvinceID;
    public long iArmy = 0L;
    public int MISSION_ID = 0;
    public int iObsolete = 10;
    public int TURN_ID = 0;

    public boolean canMakeAction(int nCivID, int iTurnsLeft) {
        return true;
    }

    public boolean action(int nCivID) {
        return true;
    }

    public boolean prepareData() {
        return true;
    }

    public void onRemove() {
    }
}

