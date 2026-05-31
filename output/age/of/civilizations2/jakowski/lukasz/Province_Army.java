/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import java.io.Serializable;

public class Province_Army
implements Serializable {
    private static final long serialVersionUID = 0L;
    private int iCivID;
    private long iArmy;
    private String sArmy = "0";
    private int iArmyWidth;

    public Province_Army(int nCivID, long nArmy, int nProvinceID) {
        this.iCivID = nCivID;
        this.setArmy(nArmy, nProvinceID);
    }

    public final void updateArmyWidth_Just(int nProvinceID) {
        try {
            CFG.glyphLay.setText(CFG.fontArmy, this.sArmy);
            this.iArmyWidth = (int)CFG.glyphLay.width;
        }
        catch (Exception ex) {
            CFG.core.addLoadArmiesWidth_ErrorIDs(nProvinceID);
            this.iArmyWidth = 1;
        }
    }

    public final void updateArmyWidth(long nValue) {
        try {
            CFG.glyphLay.setText(CFG.fontArmy, "" + nValue);
            this.iArmyWidth = (int)CFG.glyphLay.width;
        }
        catch (Exception ex) {
            this.iArmyWidth = CFG.TEXT_HEIGHT_DEFAULT * 2;
            CFG.exceptionStack(ex);
        }
    }

    public final void updateArmyWidth(int nValue) {
        this.updateArmyWidth((long)nValue);
    }

    public final void updateArmyWidth(String nValue) {
        try {
            CFG.glyphLay.setText(CFG.fontArmy, "" + nValue);
            this.iArmyWidth = (int)CFG.glyphLay.width;
        }
        catch (Exception ex) {
            this.iArmyWidth = CFG.TEXT_HEIGHT_DEFAULT * 2;
            CFG.exceptionStack(ex);
        }
    }

    public final void updateArmyWidth(float nValue) {
        try {
            CFG.glyphLay.setText(CFG.fontArmy, "" + nValue);
            this.iArmyWidth = (int)CFG.glyphLay.width;
        }
        catch (Exception ex) {
            this.iArmyWidth = CFG.TEXT_HEIGHT_DEFAULT * 2;
            CFG.exceptionStack(ex);
        }
    }

    public final int getCivID() {
        return this.iCivID;
    }

    public final void setCivID(int nCivID) {
        this.iCivID = nCivID;
    }

    public final long getArmy() {
        return this.iArmy;
    }

    public final String getArmyS() {
        return this.sArmy;
    }

    public final void setArmy(long nArmy, int nProvinceID) {
        this.iArmy = Math.max(0L, nArmy);
        this.sArmy = "" + CFG.getNumber_SHORT_ARMY(this.iArmy);
        this.updateArmyWidth_Just(nProvinceID);
    }

    public int getArmyWidth() {
        return this.iArmyWidth;
    }
}
