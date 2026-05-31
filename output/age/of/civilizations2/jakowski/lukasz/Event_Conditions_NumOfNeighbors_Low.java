/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;

public class Event_Conditions_NumOfNeighbors_Low
extends Event_Conditions {
    private static final long serialVersionUID = 8289996079484521104L;
    public int iCivID = -1;
    public long iValue = 0;

    @Override
    public int getCivID() {
        return this.iCivID;
    }

    @Override
    public void setCivID(int nCivID) {
        this.iCivID = nCivID;
    }

    @Override
    public long getValue() {
        return this.iValue;
    }

    @Override
    public void setValue(long nValue) {
        this.iValue = nValue;
    }

    @Override
    public boolean updateCivIDAfterRemove(int nRemovedCivID) {
        if (this.iCivID == nRemovedCivID) {
            this.iCivID = -1;
            return true;
        }
        if (nRemovedCivID < this.iCivID) {
            --this.iCivID;
        }
        return false;
    }

    @Override
    public boolean outCondition() {
        try {
            ArrayList<Integer> lNeigh = new ArrayList<Integer>();
            for (int i = 0; i < CFG.core.getCiv(this.getCivID()).getNumOfProvs(); ++i) {
                for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(this.getCivID()).getProvID(i)).getNeighProvincesSize(); ++j) {
                    if (CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(this.getCivID()).getProvID(i)).getNeighProvinces(j)).getCivId() <= 0 || CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(this.getCivID()).getProvID(i)).getNeighProvinces(j)).getCivId() == this.getCivID()) continue;
                    boolean tAdd = true;
                    for (int k = 0; k < lNeigh.size(); ++k) {
                        if (((Integer)lNeigh.get(k)).intValue() != CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(this.getCivID()).getProvID(i)).getNeighProvinces(j)).getCivId()) continue;
                        tAdd = false;
                        break;
                    }
                    if (!tAdd) continue;
                    lNeigh.add(CFG.core.getProv(CFG.core.getProv(CFG.core.getCiv(this.getCivID()).getProvID(i)).getNeighProvinces(j)).getCivId());
                }
            }
            return lNeigh.size() < this.getValue();
        }
        catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("NumberOfNeighbors") + " < " + this.getValue() + ", " + CFG.core.getCiv(this.getCivID()).getCivName();
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("NumberOfNeighbors");
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_NUMOFNEIGHBORS_LOW);
    }
}

