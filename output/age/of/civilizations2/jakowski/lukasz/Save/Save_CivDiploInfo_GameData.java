
package age.of.civilizations2.jakowski.lukasz.Save;

import java.io.Serializable;

public class Save_CivDiploInfo_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int id = 0;
    public int iValue;

    public Save_CivDiploInfo_GameData(int id, int iValue) {
        this.id = id;
        this.iValue = iValue;
    }
}

