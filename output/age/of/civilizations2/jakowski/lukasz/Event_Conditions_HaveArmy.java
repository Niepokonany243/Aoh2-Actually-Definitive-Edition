
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;
import java.util.List;

public class Event_Conditions_HaveArmy
extends Event_Conditions {
    private static final long serialVersionUID = 8289996079484521104L;
    public int iCivID = -1;
    public List<Integer> lProvinces = new ArrayList<Integer>();
    public int iPercentage = 100;

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
        return this.iPercentage;
    }

    @Override
    public void setValue(long nValue) {
        this.iPercentage = (int)nValue;
    }

    @Override
    public List<Integer> getProvinces() {
        return this.lProvinces;
    }

    @Override
    public void setProvinces(List<Integer> nProvinces) {
        this.lProvinces.clear();
        for (int i = 0; i < nProvinces.size(); ++i) {
            this.lProvinces.add(nProvinces.get(i));
        }
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
        int numOut = 0;
        try {
            for (int i = 0; i < this.lProvinces.size(); ++i) {
                if (CFG.core.getProv(this.lProvinces.get(i)).getArmyCivID1(this.getCivID()) <= 0) continue;
                ++numOut;
            }
        }
        catch (IndexOutOfBoundsException ex) {
            return false;
        }
        return !((float)numOut / (float)this.lProvinces.size() > (float)this.getValue() / 100.0f);
    }

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("HaveArmy") + ": " + CFG.core.getCiv(this.getCivID()).getCivName();
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("HaveArmy");
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_HAVEARMY);
    }
}

