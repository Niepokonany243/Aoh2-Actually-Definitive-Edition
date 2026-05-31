
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome;
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

public class Event_Outcome_DeclareWar
extends Event_Outcome {
    private static final long serialVersionUID = -5222143330055832078L;
    public int iCivID = -1;
    public int iCivID2 = -1;

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
    public void outcomeAction() {
        if (this.canMakeAction()) {
            CFG.core.declareWar(this.getCivID(), this.getCivID2(), true);
            CFG.oAI.buildAI_Data();
        }
    }

    public boolean canMakeAction() {
        try {
            return this.getCivID() >= 0 && this.getCivID() < CFG.core.getCivsSize() && this.getCivID2() >= 0 && this.getCivID2() < CFG.core.getCivsSize() && this.getCivID() != this.getCivID2() && (int)CFG.core.getCivRelationOfCivB(this.getCivID(), this.getCivID2()) != GameValues.gvDiplomacy.RELATION_AT_WAR && CFG.core.getCiv(this.getCivID()).getNumOfProvs() > 0 && CFG.core.getCiv(this.getCivID2()).getNumOfProvs() > 0;
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
                tData.add(new ME_Hover_2Type_Text(CFG.lang.get("War") + ": ", CFG.COLOR_NEGATIVE_2));
                tData.add(new ME_Hover_2Type_Flag(this.getCivID(), 0, CFG.PADD));
                tData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(this.getCivID()).getCivName()));
                tData.add(new ME_Hover_2Type_Image(Images.diploRivals, CFG.PADD, CFG.PADD));
                tData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(this.getCivID2()).getCivName()));
                tData.add(new ME_Hover_2Type_Flag(this.getCivID2(), CFG.PADD, 0));
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
            return CFG.lang.get("DeclareWar") + ": " + CFG.core.getCiv(this.getCivID()).getCivName() + ", " + CFG.core.getCiv(this.getCivID2()).getCivName();
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("DeclareWar");
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_DECLAREWAR);
    }
}

