/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Event_Outcome;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.MapA.BuildingsManager;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.View;
import java.util.ArrayList;
import java.util.List;

public class Event_Outcome_RandArmoury
extends Event_Outcome {
    private static final long serialVersionUID = 2940259767308827562L;
    public int iCivID = -1;
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
        block11: {
            try {
                if (!this.canMakeAction()) break block11;
                if (this.getValue() < 0) {
                    int i;
                    ArrayList<Integer> lProvinces = new ArrayList<Integer>();
                    for (i = 0; i < CFG.core.getCiv(this.getCivID()).getNumOfProvs(); ++i) {
                        if (CFG.core.getProv(CFG.core.getCiv(this.getCivID()).getProvID(i)).getLvlOfArmoury() <= 0) continue;
                        lProvinces.add(CFG.core.getCiv(this.getCivID()).getProvID(i));
                    }
                    if (!lProvinces.isEmpty()) {
                        for (i = 0; i < Math.abs(this.getValue()); ++i) {
                            int randID = CFG.oR.nextInt(lProvinces.size());
                            if (CFG.core.getProv((Integer)lProvinces.get(randID)).getLvlOfArmoury() <= 0) continue;
                            CFG.core.getProv((Integer)lProvinces.get(randID)).setLvlOfArmoury(CFG.core.getProv((Integer)lProvinces.get(randID)).getLvlOfArmoury() - 1);
                        }
                    }
                } else {
                    int i;
                    ArrayList<Integer> lProvinces = new ArrayList<Integer>();
                    for (i = 0; i < CFG.core.getCiv(this.getCivID()).getNumOfProvs(); ++i) {
                        if (CFG.core.getProv(CFG.core.getCiv(this.getCivID()).getProvID(i)).getLvlOfArmoury() >= BuildingsManager.getArmoury_MaxLevel()) continue;
                        lProvinces.add(CFG.core.getCiv(this.getCivID()).getProvID(i));
                    }
                    if (!lProvinces.isEmpty()) {
                        for (i = 0; i < this.getValue(); ++i) {
                            int randID = CFG.oR.nextInt(lProvinces.size());
                            if (CFG.core.getProv((Integer)lProvinces.get(randID)).getLvlOfArmoury() >= BuildingsManager.getArmoury_MaxLevel()) continue;
                            CFG.core.getProv((Integer)lProvinces.get(randID)).setLvlOfArmoury(CFG.core.getProv((Integer)lProvinces.get(randID)).getLvlOfArmoury() + 1);
                        }
                    }
                }
                if (CFG.core.getCiv(this.getCivID()).getIsPlayer()) {
                    CFG.menus.updateInGameTopAll(CFG.core.getPlayer(CFG.PLAYER_TURN_ID).getCivId());
                }
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
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
            if (this.getValue() < 0) {
                return CFG.lang.get("DestroyBuilding") + ": " + CFG.lang.get("Armoury") + " -> " + CFG.lang.get("Random") + ": " + CFG.core.getCiv(this.getCivID()).getCivName() + ", " + (this.getValue() > 0 ? "+" : "") + this.getValue();
            }
            return CFG.lang.get("Build") + " " + CFG.lang.get("Armoury") + " -> " + CFG.lang.get("Random") + ": " + CFG.core.getCiv(this.getCivID()).getCivName() + ", " + (this.getValue() > 0 ? "+" : "") + this.getValue();
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("Build") + " " + CFG.lang.get("Armoury") + " -> " + CFG.lang.get("Random");
        }
    }

    @Override
    public List<MEHover_2E> getHoverText() {
        try {
            ArrayList<MEHover_2E> tElements = new ArrayList<MEHover_2E>();
            ArrayList<ME_Hover_2Type> tData = new ArrayList<ME_Hover_2Type>();
            if (this.canMakeAction()) {
                tData.add(new ME_Hover_2Type_Flag(this.getCivID()));
                if (this.getValue() < 0) {
                    tData.add(new ME_Hover_2Type_Text(CFG.lang.get("DestroyBuilding") + " -> "));
                    tData.add(new ME_Hover_2Type_Text(CFG.lang.get("Armoury") + ": ", CFG.COLOR_HOVER_TITLE));
                } else {
                    tData.add(new ME_Hover_2Type_Text(CFG.lang.get("Build") + " -> "));
                    tData.add(new ME_Hover_2Type_Text(CFG.lang.get("Armoury") + ": ", CFG.COLOR_HOVER_TITLE));
                }
                tData.add(new ME_Hover_2Type_Text(" " + (this.getValue() > 0 ? "x" : "") + Math.abs(this.getValue()), this.getValue() > 0 ? CFG.COLOR_POSITIVE : (this.getValue() == 0 ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2)));
                tData.add(new ME_Hover_2Type_Image(Images.bArmoury, CFG.PADD, 0));
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
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_RAND_ARMOURY);
    }
}

