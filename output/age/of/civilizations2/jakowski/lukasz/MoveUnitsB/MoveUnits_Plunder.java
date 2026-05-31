
package age.of.civilizations2.jakowski.lukasz.MoveUnitsB;

import age.of.civilizations2.jakowski.lukasz.CFG;

public class MoveUnits_Plunder {
    private int iFromProvinceID;
    private long iNumOfUnits;
    private int iNumOfUnitsWidth;

    public MoveUnits_Plunder(int iFromProvinceID, long iNumOfUnits) {
        this.iFromProvinceID = iFromProvinceID;
        this.setNumOfUnits(iNumOfUnits);
    }

    public final int getFromProvinceID() {
        return this.iFromProvinceID;
    }

    public final long getNumOfUnits() {
        return this.iNumOfUnits;
    }

    public final void setNumOfUnits(long iNumOfUnits) {
        try {
            this.iNumOfUnits = iNumOfUnits;
            CFG.glyphLay.setText(CFG.fontArmy, CFG.getNumber_SHORT_ARMY(iNumOfUnits));
            this.iNumOfUnitsWidth = (int)CFG.glyphLay.width;
        }
        catch (IllegalArgumentException illegalArgumentException) {
        }
        catch (Exception exception) {
            
        }
    }

    public final int getUnitsWidth() {
        return this.iNumOfUnitsWidth;
    }
}

