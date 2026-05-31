/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.View;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Event_Outcome_Wasteland
extends Event_Outcome {
    private static final long serialVersionUID = 7679706044195701793L;
    public List<Integer> lProvinces = new ArrayList<Integer>();
    public long iValue = 0;

    @Override
    public long getValue() {
        return this.iValue;
    }

    @Override
    public void setValue(long nValue) {
        this.iValue = nValue;
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
    public void outcomeAction() {
        for (int i = 0; i < this.getProvinces().size(); ++i) {
            if (!this.canMakeAction(i)) continue;
            if (this.getValue() == 0) {
                CFG.core.getProv(this.getProvinces().get(i)).setWastelandLvl(-1);
                CFG.core.getProv(this.getProvinces().get(i)).setCivId(0, false);
                CFG.core.getProv(this.getProvinces().get(i)).getPop().setPopulationOfCivID(0, GameValues.gvProvince.MIN_POPULATION_IN_PROVINCE);
                CFG.core.getProv(this.getProvinces().get(i)).setEco(GameValues.gvProvince.MIN_ECONOMY_IN_PROVINCE);
                CFG.core.buildWastelandLevels();
                if (CFG.core.getActiveProvID() != this.getProvinces().get(i).intValue()) continue;
                CFG.core.setActiveProvID(-1);
                CFG.core.setActiveProvID(this.getProvinces().get(i));
                continue;
            }
            CFG.core.getProv(this.getProvinces().get(i)).setWastelandLvl(0);
            CFG.core.getProv(this.getProvinces().get(i)).setCivId(0, false);
            CFG.core.getProv(this.getProvinces().get(i)).getPop().setPopulationOfCivID(0, GameValues.gvProvince.MIN_POPULATION_IN_PROVINCE);
            CFG.core.getProv(this.getProvinces().get(i)).setEco(GameValues.gvProvince.MIN_ECONOMY_IN_PROVINCE);
            CFG.core.buildWastelandLevels();
            if (CFG.core.getActiveProvID() != this.getProvinces().get(i).intValue()) continue;
            CFG.core.setActiveProvID(-1);
            CFG.core.setActiveProvID(this.getProvinces().get(i));
        }
        CFG.core.buildWastelandLevels();
    }

    public boolean canMakeAction(int i) {
        try {
            return !CFG.core.getProv(this.getProvinces().get(i)).getSeaProv();
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return false;
        }
    }

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("UpdateWastelandProvinces") + ": " + CFG.lang.get("Provinces") + ": " + this.getProvinces().size() + ", " + (this.getValue() == 0 ? CFG.lang.get("WontBeAWastelandAnymore") : CFG.lang.get("WillTurnIntoAWasteland"));
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("UpdateWastelandProvinces");
        }
    }

    @Override
    public List<MEHover_2E> getHoverText() {
        try {
            ArrayList<MEHover_2E> tElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> tData = new ArrayList<ME_Hover_2Type>();
            for (int i = 0; i < this.getProvinces().size(); ++i) {
                if (!this.canMakeAction(i)) continue;
                tData.add(new ME_Hover_2Type_Text("" + (CFG.core.getProv(this.getProvinces().get(i)).getName().length() == 0 ? (Serializable)this.getProvinces().get(i) : CFG.core.getProv(this.getProvinces().get(i)).getName()) + ": "));
                if (this.getValue() == 0) {
                    tData.add(new ME_Hover_2Type_Text(CFG.lang.get("WontBeAWastelandAnymore"), CFG.COLOR_HOVER_TITLE));
                } else {
                    tData.add(new ME_Hover_2Type_Text(CFG.lang.get("WillTurnIntoAWasteland"), CFG.COLOR_HOVER_TITLE));
                }
                tElements.add(new MEHover_2E(tData));
                tData.clear();
            }
            return tElements;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
        return new ArrayList<MEHover_2E>();
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_WASTELAND);
    }
}

