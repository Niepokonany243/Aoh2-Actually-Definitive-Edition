
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Conditions;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;
import java.util.List;

public class Event_Conditions_Farm
extends Event_Conditions {
    private static final long serialVersionUID = 8289996079484521104L;
    public List<Integer> lProvinces = new ArrayList<Integer>();
    public long iValue = 0;

    @Override
    public long getValue() {
        return this.iValue;
    }

    @Override
    public void setValue(long nValue) {
        this.iValue = nValue;
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
    public boolean outCondition() {
        try {
            if (this.getValue() == 0) {
                for (int i = 0; i < this.getProvinces().size(); ++i) {
                    if (CFG.core.getProv(this.getProvinces().get(i)).getLvlOfFarm() != 0) continue;
                    return false;
                }
            } else {
                for (int i = 0; i < this.getProvinces().size(); ++i) {
                    if (CFG.core.getProv(this.getProvinces().get(i)).getLvlOfFarm() <= 0) continue;
                    return false;
                }
            }
            return true;
        }
        catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("Farm") + ": " + (this.getValue() == 0);
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("Farm");
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_FARM);
    }
}

