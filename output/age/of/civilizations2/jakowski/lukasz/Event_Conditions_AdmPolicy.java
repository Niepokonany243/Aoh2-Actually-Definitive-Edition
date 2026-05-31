
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.View;

public class Event_Conditions_AdmPolicy
extends Event_Conditions {
    private static final long serialVersionUID = -5690722306211998319L;
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
            return CFG.core.getCiv((int)this.getCivID()).civGD.policyID == this.getValue();
        }
        catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("AdministrationPolicy") + " == " + CFG.lang.get(GameValues.gvAdministrationPolicy.POLICY_NAME[(int)this.getValue()]) + ", " + CFG.core.getCiv(this.getCivID()).getCivName();
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("AdministrationPolicy");
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_ADM_POLICY);
    }
}

