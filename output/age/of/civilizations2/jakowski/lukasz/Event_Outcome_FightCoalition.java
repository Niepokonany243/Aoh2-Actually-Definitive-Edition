
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;
import java.util.List;

public class Event_Outcome_FightCoalition
extends Event_Outcome {
    private static final long serialVersionUID = 2940259767308827562L;
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
    public void outcomeAction() {
        if (this.canMakeAction()) {
            CFG.gameAction.fightCoalition(this.getCivID());
        }
    }

    public boolean canMakeAction() {
        try {
            return this.getCivID() > 0 && this.getCivID() < CFG.core.getCivsSize() && CFG.core.getCiv(this.getCivID()).getNumOfProvs() > 0;
        }
        catch (Exception exception) {
            return false;
        }
    }

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("FightTheCoalition");
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("FightTheCoalition");
        }
    }

    @Override
    public List<MEHover_2E> getHoverText() {
        try {
            ArrayList<MEHover_2E> tElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> tData = new ArrayList<ME_Hover_2Type>();
            if (this.canMakeAction()) {
                tData.add(new ME_Hover_2Type_Flag(this.getCivID()));
                tData.add(new ME_Hover_2Type_Text(CFG.lang.get("FightTheCoalition"), CFG.COLOR_HOVER_TITLE));
                tData.add(new ME_Hover_2Type_Image(Images.diploWar, CFG.PADD, 0));
                tElements.add(new MEHover_2E(tData));
                tData.clear();
            }
            return tElements;
        }
        catch (Exception exception) {
            return new ArrayList<MEHover_2E>();
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_COALITION);
    }
}

