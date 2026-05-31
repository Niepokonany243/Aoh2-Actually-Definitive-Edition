
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Ideology;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;
import java.util.List;

public class Event_Outcome_ChangeIdeology
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
            this.iValue = CFG.oR.nextInt(CFG.ideologiesMgr.getIdeologiesSize());
        }
        if (this.getCivID() >= 0 && this.getCivID() < CFG.core.getCivsSize()) {
            try {
                CFG.core.getCiv(this.getCivID()).setIdeology((int)this.getValue());
                CFG.core.getCiv(this.getCivID()).setCivTag(CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(this.getCivID()).getCivTag()) + CFG.ideologiesMgr.getIdeologyID(CFG.core.getCiv(this.getCivID()).getIdeology()).getExtraTag());
                Core.addSimpleTask(new Core.SimpleTask("LoadFlag" + this.getCivID(), this.getCivID()){

                    @Override
                    public void update() {
                        CFG.core.getCiv(this.id).loadFlag();
                    }
                });
                Core.addSimpleTask(new Core.SimpleTask("loadPlayersFlags"){

                    @Override
                    public void update() {
                        for (int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                            if (CFG.core.getPlayer(i).getCivId() != Event_Outcome_ChangeIdeology.this.getCivID()) continue;
                            CFG.core.getPlayer(i).loadPlayersFlag();
                            break;
                        }
                    }
                });
                CFG.setActiveCivInfoId(CFG.getActiveCivInfoId());
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("ChangeIdeology") + ": " + CFG.core.getCiv(this.getCivID()).getCivName() + " -> " + CFG.ideologiesMgr.getIdeologyID((int)this.getValue()).getName();
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("ChangeIdeology");
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
            tData.add(new ME_Hover_2Type_Text(CFG.lang.get("ChangeIdeology") + ": ", CFG.COLOR_HOVER_TITLE));
            tData.add(new ME_Hover_2Type_Text(CFG.ideologiesMgr.getIdeologyID((int)this.getValue()).getName(), CFG.ideologiesMgr.getIdeologyID((int)this.getValue()).getColor()));
            tData.add(new ME_Hover_2Type_Ideology((int)this.getValue(), CFG.PADD, 0));
            tElements.add(new MEHover_2E(tData));
            tData.clear();
            return tElements;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        }
        catch (NullPointerException nullPointerException) {
            
        }
        return new ArrayList<MEHover_2E>();
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_CHANGEIDEOLOGY);
    }
}

