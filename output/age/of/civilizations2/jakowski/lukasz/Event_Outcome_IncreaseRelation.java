
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

public class Event_Outcome_IncreaseRelation
extends Event_Outcome {
    private static final long serialVersionUID = -6122261243068534687L;
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
        if (this.canMakeAction()) {
            CFG.core.setCivRelationOfCivB(this.getCivID(), this.getCivID2(), CFG.core.getCivRelationOfCivB(this.getCivID(), this.getCivID2()) + (float)this.getValue());
            CFG.core.setCivRelationOfCivB(this.getCivID2(), this.getCivID(), CFG.core.getCivRelationOfCivB(this.getCivID2(), this.getCivID()) + (float)this.getValue());
        }
    }

    public boolean canMakeAction() {
        try {
            return this.getValue() != 0 && this.getCivID() >= 0 && this.getCivID() < CFG.core.getCivsSize() && this.getCivID2() >= 0 && this.getCivID2() < CFG.core.getCivsSize() && this.getCivID() != this.getCivID2() && !CFG.core.getCivsAtWar(this.getCivID(), this.getCivID2());
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return false;
        }
    }

    @Override
    public List<MEHover_2E> getHoverText() {
        try {
            ArrayList<MEHover_2E> tElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> tData = new ArrayList<ME_Hover_2Type>();
            if (this.canMakeAction()) {
                tData.add(new ME_Hover_2Type_Text(CFG.lang.get("Relation") + ": ", CFG.COLOR_HOVER_TITLE));
                tData.add(new ME_Hover_2Type_Flag(this.getCivID(), 0, CFG.PADD));
                tData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(this.getCivID()).getCivName()));
                tData.add(new ME_Hover_2Type_Text(" - "));
                tData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(this.getCivID2()).getCivName()));
                tData.add(new ME_Hover_2Type_Flag(this.getCivID2(), CFG.PADD, 0));
                tData.add(new ME_Hover_2Type_Text(": " + (this.getValue() > 0 ? "+" : "") + this.getValue(), this.getValue() > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
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

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("UpdateRelation") + ": " + CFG.core.getCiv(this.getCivID()).getCivName() + ", " + CFG.core.getCiv(this.getCivID2()).getCivName() + ": " + (this.getValue() > 0 ? "+" : "") + this.getValue();
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("UpdateRelation");
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_INCRELATION);
    }
}

