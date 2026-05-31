/*
 * Decompiled with CFR 0.152.
 */
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Event_Outcome_UpdatePopulation
extends Event_Outcome {
    private static final long serialVersionUID = -6816800534618459583L;
    public int iCivID = -1;
    public List<Integer> lProvinces = new ArrayList<Integer>();
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
        if (this.getCivID() >= 0 && this.getCivID() < CFG.core.getCivsSize()) {
            for (int i = 0; i < this.getProvinces().size(); ++i) {
                if (!this.canMakeAction(i)) continue;
                if (this.getValue() < 0) {
                    float tPerc = (float)CFG.core.getProv(this.getProvinces().get(i)).getPop().getPops() / (float)this.getValue() / 100.0f;
                    for (int j = 0; j < CFG.core.getProv(this.getProvinces().get(i)).getPop().getNatsSize(); ++j) {
                        CFG.core.getProv(this.getProvinces().get(i)).getPop().setPopulationOfCivID(CFG.core.getProv(this.getProvinces().get(i)).getPop().getCivID(j), CFG.core.getProv(this.getProvinces().get(i)).getPop().getPopulationID(j) - (int)((float)CFG.core.getProv(this.getProvinces().get(i)).getPop().getPopulationID(j) * tPerc));
                    }
                    continue;
                }
                CFG.core.getProv(this.getProvinces().get(i)).getPop().setPopulationOfCivID(this.getCivID(), CFG.core.getProv(this.getProvinces().get(i)).getPop().getPopulationOfCivID(this.getCivID()) + this.getValue());
            }
        }
    }

    public boolean canMakeAction(int i) {
        try {
            return !CFG.core.getProv(this.getProvinces().get(i)).getSeaProv() && CFG.core.getProv(this.getProvinces().get(i)).getWastelandLvl() < 0;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return false;
        }
    }

    @Override
    public String getConditionText() {
        try {
            return CFG.lang.get("UpdatePopulation") + ": " + CFG.core.getCiv(this.getCivID()).getCivName() + ", " + this.getValue();
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("UpdatePopulation");
        }
    }

    @Override
    public List<MEHover_2E> getHoverText() {
        try {
            ArrayList<MEHover_2E> tElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> tData = new ArrayList<ME_Hover_2Type>();
            if (this.getProvinces().size() < 5) {
                for (int i = 0; i < this.getProvinces().size(); ++i) {
                    tData.add(new ME_Hover_2Type_Flag(this.getCivID()));
                    tData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": ", CFG.COLOR_HOVER_TITLE));
                    tData.add(new ME_Hover_2Type_Text((CFG.core.getProv(this.getProvinces().get(i)).getName().length() == 0 ? (Serializable)this.getProvinces().get(i) : CFG.core.getProv(this.getProvinces().get(i)).getName()) + ": "));
                    tData.add(new ME_Hover_2Type_Text((this.getValue() > 0 ? "+" : "") + CFG.getNumberWthSpaces("" + this.getValue()), this.getValue() > 0 ? CFG.COLOR_POSITIVE : (this.getValue() == 0 ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2)));
                    tData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
                    tElements.add(new MEHover_2E(tData));
                    tData.clear();
                }
            } else {
                tData.add(new ME_Hover_2Type_Flag(this.getCivID()));
                tData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": ", CFG.COLOR_HOVER_TITLE));
                tData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
                tData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + this.getProvinces().size()), CFG.COLOR_HOVER_TITLE));
                tData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, CFG.PADD));
                tData.add(new ME_Hover_2Type_Text((this.getValue() > 0 ? "+" : "") + CFG.getNumberWthSpaces("" + this.getValue()), this.getValue() > 0 ? CFG.COLOR_POSITIVE : (this.getValue() == 0 ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2)));
                tData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
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
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_UPDATEPOPULATION);
    }
}

