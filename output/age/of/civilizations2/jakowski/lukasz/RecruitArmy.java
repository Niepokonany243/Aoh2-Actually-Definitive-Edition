
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import java.io.Serializable;

public class RecruitArmy
implements Serializable {
    private static final long serialVersionUID = 0L;
    private long iArmy;
    private int iProvinceID;
    private int iArmyWidth = 0;
    private int iTurnsLeft = 1;

    public RecruitArmy(int iProvinceID, long iArmy, int iTurnsLeft) {
        this.iProvinceID = iProvinceID;
        this.setArmy(iArmy);
        this.iTurnsLeft = iTurnsLeft;
    }

    public final long getArmy() {
        return this.iArmy;
    }

    public final void setArmy(long iArmy) {
        this.iArmy = iArmy;
        try {
            CFG.glyphLay.setText(CFG.fontArmy, "" + iArmy);
            this.iArmyWidth = (int)CFG.glyphLay.width;
        }
        catch (Exception ex) {
            this.iArmyWidth = 0;
        }
    }

    public final int getProvinceID() {
        return this.iProvinceID;
    }

    public final void setProvinceID(int iProvinceID) {
        this.iProvinceID = iProvinceID;
    }

    public final int getArmyWidth() {
        return this.iArmyWidth;
    }

    public final int getTurnsLeft() {
        return this.iTurnsLeft;
    }

    public final void setTurnsLeft(int iTurnsLeft) {
        this.iTurnsLeft = iTurnsLeft;
    }
}
