
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class Province_Cores_Civs_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    public int iCivID;
    public float fPercPop;

    public Province_Cores_Civs_GameData() {
    }

    public Province_Cores_Civs_GameData(int nCivID, int nPerc) {
        this.iCivID = nCivID;
        this.fPercPop = (float)nPerc / 100.0f;
    }

    public final void setPerc(float nPerc) {
        this.fPercPop = nPerc;
        if (this.fPercPop < 0.01f) {
            this.fPercPop = 0.01f;
        } else if (this.fPercPop > 1.0f) {
            this.fPercPop = 1.0f;
        }
    }
}

