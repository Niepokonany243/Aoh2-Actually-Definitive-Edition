/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.Menus.CreateScenarios;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Religion;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;
import java.util.List;

public class Event_Outcome_ChangeReligion
extends Event_Outcome {
    private static final long serialVersionUID = 6045654316483668628L;
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
        if (this.getValue() < 0) {
            this.iValue = CFG.oR.nextInt(CFG.religionManager.getReligionsSize());
        }
        if (this.getCivID() >= 0 && this.getCivID() < CFG.core.getCivsSize()) {
            try {
                CFG.core.getCiv(this.getCivID()).setReligionID((int)this.getValue());
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("ChangeReligion") + ": " + CFG.core.getCiv(this.getCivID()).getCivName() + " -> " + CFG.religionManager.getReligion((int)this.getValue()).getName();
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("ChangeReligion");
        }
    }

    public boolean canMakeAction() {
        return false;
    }

    @Override
    public List<MEHover_2E> getHoverText() {
        try {
            ArrayList<MEHover_2E> tElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> tData = new ArrayList<ME_Hover_2Type>();
            tData.add(new ME_Hover_2Type_Flag(this.getCivID()));
            tData.add(new ME_Hover_2Type_Text(CFG.lang.get("ChangeReligion") + ": "));
            tData.add(new ME_Hover_2Type_Text(CFG.religionManager.getReligion((int)this.getValue()).getName(), CFG.COLOR_HOVER_TITLE));
            tData.add(new ME_Hover_2Type_Religion((int)this.getValue(), CFG.PADD, 0));
            tElements.add(new MEHover_2E(tData));
            tData.clear();
            return tElements;
        }
        catch (Exception ex) {
            ArrayList<MEHover_2E> tElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> tData = new ArrayList<ME_Hover_2Type>();
            tData.add(new ME_Hover_2Type_Flag(this.getCivID()));
            tData.add(new ME_Hover_2Type_Text(CFG.lang.get("ChangeReligion")));
            tElements.add(new MEHover_2E(tData));
            tData.clear();
            return tElements;
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_CHANGERELIGION);
    }
}

