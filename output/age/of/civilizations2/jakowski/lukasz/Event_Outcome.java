
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.View;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Event_Outcome
implements Serializable {
    private static final long serialVersionUID = 0L;

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

    public String getText() {
        return "";
    }

    public void setText(String nText) {
    }

    public boolean updateCivIDAfterRemove(int nRemovedCivID) {
        return false;
    }

    public void outcomeAction() {
    }

    public List<MEHover_2E> getHoverText() {
        ArrayList<MEHover_2E> tElements = new ArrayList<MEHover_2E>();
        return tElements;
    }

    public String getConditionText() {
        return "";
    }

    public void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_CHANGE_OWNER);
    }
}

