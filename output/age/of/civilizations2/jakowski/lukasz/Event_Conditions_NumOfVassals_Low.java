
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions;
import age.of.civilizations2.jakowski.lukasz.View;

public class Event_Conditions_NumOfVassals_Low
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
            int tNumOfVassals = 0;
            for (int i = 0; i < CFG.core.getCivsSize(); ++i) {
                if (CFG.core.getCiv(i).getPuppetOfCiv() != this.getCivID() || i == this.getCivID()) continue;
                ++tNumOfVassals;
            }
            return tNumOfVassals < this.getValue();
        }
        catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("NumberOfVassals") + " < " + this.getValue() + ", " + CFG.core.getCiv(this.getCivID()).getCivName();
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("NumberOfVassals");
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_NUMOFVASSALS_LOW);
    }
}

