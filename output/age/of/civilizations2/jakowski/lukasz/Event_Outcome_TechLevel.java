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
import java.util.ArrayList;
import java.util.List;

public class Event_Outcome_TechLevel
extends Event_Outcome {
    private static final long serialVersionUID = -5995563665557126248L;
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
        if (this.canMakeAction()) {
            if (this.getCivID() < 0) {
                try {
                    int randID = 0;
                    for (int a = 0; a < 500; ++a) {
                        int randA = CFG.oR.nextInt(CFG.core.getCivsSize());
                        if (randA <= 0 || CFG.core.getCiv(randA).getNumOfProvs() <= 0) continue;
                        randID = randA;
                        break;
                    }
                    if (randID > 0) {
                        CFG.core.getCiv(randID).setTechLevel(CFG.core.getCiv(randID).getTechLevel() + (float)this.getValue() / 100.0f);
                    }
                }
                catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
            } else if (this.getCivID() == 0) {
                for (int a = 1; a < CFG.core.getCivsSize(); ++a) {
                    if (CFG.core.getCiv(a).getNumOfProvs() <= 0) continue;
                    CFG.core.getCiv(a).setTechLevel(CFG.core.getCiv(a).getTechLevel() + (float)this.getValue() / 100.0f);
                }
            } else {
                CFG.core.getCiv(this.getCivID()).setTechLevel(CFG.core.getCiv(this.getCivID()).getTechLevel() + (float)this.getValue() / 100.0f);
            }
        }
    }

    public boolean canMakeAction() {
        try {
            if (this.getCivID() <= 0) {
                return true;
            }
            return this.getValue() != 0 && this.getCivID() >= 0 && this.getCivID() < CFG.core.getCivsSize();
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
                if (this.getCivID() < 0) {
                    tData.add(new ME_Hover_2Type_Text(CFG.lang.get("RandomCivilization") + ": "));
                } else if (this.getCivID() == 0) {
                    tData.add(new ME_Hover_2Type_Text(CFG.lang.get("AllCivilizations") + ": "));
                } else {
                    tData.add(new ME_Hover_2Type_Flag(this.getCivID()));
                }
                tData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyLevel") + ": "));
                tData.add(new ME_Hover_2Type_Text((this.getValue() > 0 ? "+" : "") + (float)this.getValue() / 100.0f + " ", this.getValue() > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
                tData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
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
    public String getConditionText() {
        try {
            if (this.getCivID() < 0) {
                return CFG.lang.get("UpdateTechnologyLevel") + ": " + CFG.lang.get("RandomCivilization") + ", " + (this.getValue() > 0 ? "+" : "") + (float)this.getValue() / 100.0f;
            }
            if (this.getCivID() == 0) {
                return CFG.lang.get("UpdateTechnologyLevel") + ": " + CFG.lang.get("AllCivilizations") + ", " + (this.getValue() > 0 ? "+" : "") + (float)this.getValue() / 100.0f;
            }
            return CFG.lang.get("UpdateTechnologyLevel") + ": " + CFG.core.getCiv(this.getCivID()).getCivName() + ", " + (this.getValue() > 0 ? "+" : "") + (float)this.getValue() / 100.0f;
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("UpdateTechnologyLevel");
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_TECHLEVEL);
    }
}

