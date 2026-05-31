
package age.of.civilizations2.jakowski.lukasz.Menus.CreateScenarios;

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
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import java.util.ArrayList;
import java.util.List;

public class Event_Outcome_AssimilateAll
extends Event_Outcome {
    private static final long serialVersionUID = 2940259767308827562L;
    public int iCivID = -1;

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

    public int getImageWidth(int image) {
        return sUM.sUT.getImageWidth(image);
    }

    public int getImageHeight(int image) {
        return sUM.sUT.getImageHeight(image);
    }

    @Override
    public void outcomeAction() {
        try {
            if (this.canMakeAction()) {
                for (int i = 0; i < CFG.core.getCiv(this.getCivID()).getNumOfProvs(); ++i) {
                    GameManager.addAssimilateFree(this.getCivID(), CFG.core.getCiv(this.getCivID()).getProvID(i), GameValues.gvAssimilate.ASSIMILATE_NUM_OF_TURNS_MAX);
                }
                if (CFG.core.getCiv(this.getCivID()).getIsPlayer()) {
                    CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                }
            }
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
    }

    public boolean canMakeAction() {
        try {
            return this.getCivID() >= 0 && this.getCivID() < CFG.core.getCivsSize() && CFG.core.getCiv(this.getCivID()).getNumOfProvs() > 0;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return false;
        }
    }

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("Assimilate") + ": " + CFG.core.getCiv(this.getCivID()).getCivName() + " -> " + CFG.lang.get("AllProvinces");
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("Assimilate");
        }
    }

    @Override
    public List<MEHover_2E> getHoverText() {
        try {
            ArrayList<MEHover_2E> tElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> tData = new ArrayList<ME_Hover_2Type>();
            if (this.canMakeAction()) {
                tData.add(new ME_Hover_2Type_Flag(this.getCivID()));
                tData.add(new ME_Hover_2Type_Text(CFG.lang.get("Assimilate") + ": "));
                tData.add(new ME_Hover_2Type_Text("" + CFG.lang.get("AllProvinces"), CFG.COLOR_HOVER_TITLE));
                tData.add(new ME_Hover_2Type_Image(Images.diploStability, CFG.PADD, 0));
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
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_ASSIMILATE_ALL);
    }
}

