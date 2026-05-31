/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome;
import age.of.civilizations2.jakowski.lukasz.GameManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;
import java.util.List;

public class Event_Outcome_ImposeSanctions
extends Event_Outcome {
    private static final long serialVersionUID = 6256813467866475732L;
    public int iCivID = -1;
    public int onCivID = -1;

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
        return this.onCivID;
    }

    @Override
    public void setCivID2(int nCivID) {
        this.onCivID = nCivID;
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
        if (this.onCivID == nRemovedCivID) {
            this.onCivID = -1;
            out = true;
        } else if (nRemovedCivID < this.onCivID) {
            --this.onCivID;
        }
        return out;
    }

    @Override
    public void outcomeAction() {
        if (this.canMakeAction()) {
            GameManager.imposeSanctions(this.getCivID(), this.getCivID2(), GameValues.gvSanctions.SANCTIONS_MAX_TURNS, true, false);
        }
    }

    public boolean canMakeAction() {
        try {
            return this.getCivID() > 0 && this.getCivID() < CFG.core.getCivsSize() && this.getCivID2() > 0 && this.getCivID2() < CFG.core.getCivsSize();
        }
        catch (Exception exception) {
            return false;
        }
    }

    @Override
    public List<MEHover_2E> getHoverText() {
        ArrayList<MEHover_2E> tElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> tData = new ArrayList<ME_Hover_2Type>();
        if (this.canMakeAction()) {
            tData.add(new ME_Hover_2Type_Flag(this.getCivID()));
            tData.add(new ME_Hover_2Type_Text(CFG.lang.get("ImposeSanctions") + ": ", CFG.COLOR_HOVER_TITLE));
            tData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(this.getCivID()).getCivName()));
            tData.add(new ME_Hover_2Type_Text(" -> "));
            tData.add(new ME_Hover_2Type_Text("" + CFG.core.getCiv(this.getCivID2()).getCivName()));
            tData.add(new ME_Hover_2Type_Image(Images.sanctions, CFG.PADD, 0));
            tData.add(new ME_Hover_2Type_Flag(this.getCivID2(), CFG.PADD, 0));
            tElements.add(new MEHover_2E(tData));
            tData.clear();
        }
        return tElements;
    }

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("ImposeSanctions") + ": " + CFG.core.getCiv(this.getCivID()).getCivName() + " -> " + CFG.core.getCiv(this.getCivID2()).getCivName();
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("ImposeSanctions");
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_IMPOSE_SANCTIONS);
    }
}

