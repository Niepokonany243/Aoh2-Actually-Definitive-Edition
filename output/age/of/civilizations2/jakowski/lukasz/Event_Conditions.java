
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Type;
import age.of.civilizations2.jakowski.lukasz.View;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Event_Conditions
implements Serializable {
    private static final long serialVersionUID = 0L;
    public Event_Type conditionType = Event_Type.AND;

    public int getCivID() {
        return -1;
    }

    public void setCivID(int nCivID) {
    }

    public int getCivID2() {
        return -1;
    }

    public void setCivID2(int nCivID) {
    }

    public long getValue() {
        return -1L;
    }

    public void setValue(long nValue) {
    }

    public List<Integer> getProvinces() {
        return new ArrayList<Integer>();
    }

    public void setProvinces(List<Integer> nProvinces) {
    }

    public boolean updateCivIDAfterRemove(int nRemovedCivID) {
        return false;
    }

    public String getText() {
        return "";
    }

    public void setText(String nText) {
    }

    public boolean outCondition() {
        return false;
    }

    public String getConditionText() {
        return "";
    }

    public void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_COND_CIVEXIST);
    }
}

