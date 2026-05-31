
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.View;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Event_Outcome_ChangeOwner
extends Event_Outcome {
    private static final long serialVersionUID = -6847725667278667470L;
    public int iCivID = -1;
    public int iCivID_ControlledBy = -1;
    public List<Integer> lProvinces = new ArrayList<Integer>();

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
        return this.iCivID_ControlledBy;
    }

    @Override
    public void setCivID2(int nCivID) {
        this.iCivID_ControlledBy = nCivID;
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
        boolean out = false;
        if (this.iCivID == nRemovedCivID) {
            this.iCivID = -1;
            out = true;
        } else if (nRemovedCivID < this.iCivID) {
            --this.iCivID;
        }
        if (this.iCivID_ControlledBy == nRemovedCivID) {
            this.iCivID_ControlledBy = -1;
            out = true;
        } else if (nRemovedCivID < this.iCivID_ControlledBy) {
            --this.iCivID;
        }
        return out;
    }

    @Override
    public void outcomeAction() {
        if (this.getCivID() >= 0 && this.getCivID() < CFG.core.getCivsSize()) {
            for (int i = 0; i < this.lProvinces.size(); ++i) {
                try {
                    if (!this.canMakeAction(i)) continue;
                    CFG.core.getProv(this.lProvinces.get(i)).setCivId(this.getCivID(), false);
                    CFG.core.getProv(this.lProvinces.get(i)).setTrueOwnerOfProv(this.getCivID());
                    continue;
                }
                catch (IndexOutOfBoundsException ex) {
                    CFG.exceptionStack(ex);
                }
            }
        }
        CFG.gameAction.updateCivsHappiness(this.getCivID());
        if (this.getCivID2() > 0) {
            CFG.gameAction.updateCivsHappiness(this.getCivID2());
        }
        if (CFG.core.getCiv(this.getCivID()).getCapitalProvID() < 0 || CFG.core.getProv(CFG.core.getCiv(this.getCivID()).getCapitalProvID()).getCivId() != this.getCivID()) {
            CFG.core.moveCapitalToTheLargestCity(this.getCivID());
        }
        Core.addSimpleTask(new Core.SimpleTask("buildCivilizationRegions" + this.getCivID(), this.getCivID()){

            @Override
            public void update() {
                try {
                    CFG.core.buildCivilizationRegions(this.id);
                }
                catch (Exception exception) {
                    
                }
            }
        });
        if (this.getCivID2() > 0) {
            Core.addSimpleTask(new Core.SimpleTask("buildCivilizationRegions" + this.getCivID2(), this.getCivID2()){

                @Override
                public void update() {
                    try {
                        CFG.core.buildCivilizationRegions(this.id);
                    }
                    catch (Exception exception) {
                        
                    }
                }
            });
        }
    }

    public boolean canMakeAction(int i) {
        try {
            return !CFG.core.getProv(this.getProvinces().get(i)).getSeaProv() && CFG.core.getProv(this.getProvinces().get(i)).getWastelandLvl() < 0 && (CFG.core.getProv(this.getProvinces().get(i)).getCivId() == this.getCivID2() || this.getCivID2() < 0) && this.getCivID() != this.getCivID2();
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return false;
        }
    }

    @Override
    public List<MEHover_2E> getHoverText() {
        ArrayList<MEHover_2E> tElements = new ArrayList<MEHover_2E>();
        ArrayList<ME_Hover_2Type> tData = new ArrayList<ME_Hover_2Type>();
        if (this.getProvinces().size() < 9) {
            for (int i = 0; i < this.getProvinces().size(); ++i) {
                if (!this.canMakeAction(i)) continue;
                tData.add(new ME_Hover_2Type_Flag(this.getCivID()));
                tData.add(new ME_Hover_2Type_Text(CFG.lang.get("Annexation") + ": ", CFG.COLOR_HOVER_TITLE));
                tData.add(new ME_Hover_2Type_Text("" + (CFG.core.getProv(this.getProvinces().get(i)).getName().length() == 0 ? (Serializable)this.getProvinces().get(i) : CFG.core.getProv(this.getProvinces().get(i)).getName())));
                tData.add(new ME_Hover_2Type_Flag(CFG.core.getProv(this.getProvinces().get(i)).getCivId(), CFG.PADD, 0));
                tElements.add(new MEHover_2E(tData));
                tData.clear();
            }
        } else {
            tData.add(new ME_Hover_2Type_Flag(this.getCivID()));
            tData.add(new ME_Hover_2Type_Text(CFG.lang.get("Annexation") + ": ", CFG.COLOR_HOVER_TITLE));
            tData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
            tData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + this.getProvinces().size()), CFG.COLOR_HOVER_TITLE));
            tData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
            tElements.add(new MEHover_2E(tData));
            tData.clear();
        }
        return tElements;
    }

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("Annexation") + ": " + CFG.core.getCiv(this.getCivID()).getCivName();
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("Annexation");
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_CHANGE_OWNER);
    }
}

