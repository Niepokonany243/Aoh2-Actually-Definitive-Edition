
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class Civilization_Colonies
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iProvinceID;
    public int iTurnID;

    public Civilization_Colonies(int nProvinceID) {
        this.iProvinceID = nProvinceID;
    }
}

