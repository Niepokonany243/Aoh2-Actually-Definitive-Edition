
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;
import java.util.List;

public class Event_Outcome_MoveCapital
extends Event_Outcome {
    private static final long serialVersionUID = 4324417786790844898L;
    public int iCivID = -1;
    public long iValue = -1;

    @Override
    public int getCivID() {
        return this.iCivID;
    }

    @Override
    public void setCivID(int nCivID) {
        this.iCivID = nCivID;
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
    public long getValue() {
        return this.iValue;
    }

    @Override
    public void setValue(long nValue) {
        this.iValue = nValue;
    }

    @Override
    public void outcomeAction() {
        if (this.canMakeAction()) {
            if (CFG.core.getCiv(this.getCivID()).getCapitalProvID() >= 0) {
                CFG.core.getProv(CFG.core.getCiv(this.getCivID()).getCapitalProvID()).setIsCapital(false);
                CFG.core.getProv(CFG.core.getCiv(this.getCivID()).getCapitalProvID()).updateDrawArmyInProv();
                try {
                    CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCapitalProvID()).getCit(0).setCityLevel(CFG.getEditorCityLevel(1));
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    
                }
            }
            CFG.core.getProv((int)this.getValue()).setIsCapital(true);
            CFG.core.getCiv(this.getCivID()).setCapitalProvID((int)this.getValue());
            CFG.core.getCiv(this.getCivID()).setCoreCapitalProvID((int)this.getValue());
            try {
                CFG.core.getProv(CFG.core.getCiv(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId()).getCapitalProvID()).getCit(0).setCityLevel(CFG.getEditorCityLevel(0));
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                
            }
            CFG.core.getProv(CFG.core.getCiv(this.getCivID()).getCapitalProvID()).updateDrawArmyInProv();
            CFG.core.getProv(CFG.core.getCiv(this.getCivID()).getCapitalProvID()).setDrawCitiesInProv(true);
        }
    }

    @Override
    public List<MEHover_2E> getHoverText() {
        try {
            ArrayList<MEHover_2E> tElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> tData = new ArrayList<ME_Hover_2Type>();
            if (this.canMakeAction()) {
                tData.add(new ME_Hover_2Type_Flag(this.getCivID()));
                tData.add(new ME_Hover_2Type_Text(CFG.lang.get("MoveCapital") + ":", CFG.COLOR_HOVER_TITLE));
                tData.add(new ME_Hover_2Type_Text("" + (CFG.core.getProv((int)this.getValue()).getName().length() == 0 ? Integer.valueOf((int)this.getValue()) : CFG.core.getProv((int)this.getValue()).getName())));
                tElements.add(new MEHover_2E(tData));
                tData.clear();
            }
            return tElements;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        }
        catch (NullPointerException nullPointerException) {
            
        }
        return new ArrayList<MEHover_2E>();
    }

    public boolean canMakeAction() {
        try {
            return this.getCivID() >= 0 && this.getCivID() < CFG.core.getCivsSize() && this.getValue() >= 0 && this.getValue() < CFG.core.getProvinSize() && !CFG.core.getProv((int)this.getValue()).getSeaProv() && CFG.core.getProv((int)this.getValue()).getWastelandLvl() < 0 && CFG.core.getProv((int)this.getValue()).getCivId() == this.getCivID();
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return false;
        }
    }

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("MoveCapital") + ": " + CFG.core.getCiv(this.getCivID()).getCivName();
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("MoveCapital");
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_MOVECAPITAL);
    }
}

