/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome;
import age.of.civilizations2.jakowski.lukasz.View;

public class Event_Outcome_DecreaseRelation
extends Event_Outcome {
    private static final long serialVersionUID = 8289996079484521104L;
    public int iCivID = -1;
    public int iCivID2 = -1;
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
    public int getCivID2() {
        return this.iCivID2;
    }

    @Override
    public void setCivID2(int nCivID) {
        this.iCivID2 = nCivID;
    }

    @Override
    public boolean updateCivIDAfterRemove(int nRemovedCivID) {
        boolean out = false;
        if (this.iCivID == nRemovedCivID) {
            this.iCivID = -1;
            out = true;
        } else if (nRemovedCivID < this.iCivID) {
            --this.iCivID;
        }
        if (this.iCivID2 == nRemovedCivID) {
            this.iCivID2 = -1;
            out = true;
        } else if (nRemovedCivID < this.iCivID2) {
            --this.iCivID2;
        }
        return out;
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
    public void outcomeAction() {
        if (this.getCivID() < 0 || this.getCivID() >= CFG.core.getCivsSize() || this.getCivID2() < 0 || this.getCivID2() < CFG.core.getCivsSize()) {
            // empty if block
        }
    }

    public boolean canMakeAction() {
        return false;
    }

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("DecreaseRelation") + ": " + CFG.core.getCiv(this.getCivID()).getCivName() + ", " + CFG.core.getCiv(this.getCivID2()).getCivName();
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("DecreaseRelation");
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_DECRELATION);
    }
}

