
package age.of.civilizations2.jakowski.lukasz;

import java.io.Serializable;

public class TradeRoute_GameData
implements Serializable {
    private static final long serialVersionUID = 0L;
    private String sFromTagID;
    private String sToTagID;
    private int iAgeFoundID;

    public final String getFromTagID() {
        return this.sFromTagID;
    }

    public final void setFromTagID(String sFromTagID) {
        this.sFromTagID = sFromTagID;
    }

    public final String getToTagID() {
        return this.sToTagID;
    }

    public final void setToTagID(String sToTagID) {
        this.sToTagID = sToTagID;
    }

    public final int getAgeFoundID() {
        return this.iAgeFoundID;
    }

    public final void setAgeFoundID(int iAgeFoundID) {
        this.iAgeFoundID = iAgeFoundID;
    }
}

