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

public class Event_Outcome_UpdatePopulationOfCiv
extends Event_Outcome {
    private static final long serialVersionUID = 3805985645176083799L;
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
        block16: {
            try {
                if (!this.canMakeAction()) break block16;
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
                            for (int i = 0; i < CFG.core.getCiv(randID).getNumOfProvs(); ++i) {
                                for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(randID).getProvID(i)).getPop().getNatsSize(); ++j) {
                                    CFG.core.getProv(CFG.core.getCiv(randID).getProvID(i)).getPop().setPopulationOfCivID(CFG.core.getProv(CFG.core.getCiv(randID).getProvID(i)).getPop().getCivID(j), CFG.core.getProv(CFG.core.getCiv(randID).getProvID(i)).getPop().getPopulationID(j) + (int)((float)CFG.core.getProv(CFG.core.getCiv(randID).getProvID(i)).getPop().getPopulationID(j) * ((float)this.getValue() / 100.0f)));
                                }
                            }
                        }
                        break block16;
                    }
                    catch (Exception ex) {
                        CFG.exceptionStack(ex);
                        break block16;
                    }
                }
                if (this.getCivID() == 0) {
                    for (int a = 1; a < CFG.core.getCivsSize(); ++a) {
                        if (CFG.core.getCiv(a).getNumOfProvs() <= 0) continue;
                        for (int i = 0; i < CFG.core.getCiv(a).getNumOfProvs(); ++i) {
                            for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(a).getProvID(i)).getPop().getNatsSize(); ++j) {
                                CFG.core.getProv(CFG.core.getCiv(a).getProvID(i)).getPop().setPopulationOfCivID(CFG.core.getProv(CFG.core.getCiv(a).getProvID(i)).getPop().getCivID(j), CFG.core.getProv(CFG.core.getCiv(a).getProvID(i)).getPop().getPopulationID(j) + (int)((float)CFG.core.getProv(CFG.core.getCiv(a).getProvID(i)).getPop().getPopulationID(j) * ((float)this.getValue() / 100.0f)));
                            }
                        }
                    }
                } else {
                    for (int i = 0; i < CFG.core.getCiv(this.getCivID()).getNumOfProvs(); ++i) {
                        for (int j = 0; j < CFG.core.getProv(CFG.core.getCiv(this.getCivID()).getProvID(i)).getPop().getNatsSize(); ++j) {
                            CFG.core.getProv(CFG.core.getCiv(this.getCivID()).getProvID(i)).getPop().setPopulationOfCivID(CFG.core.getProv(CFG.core.getCiv(this.getCivID()).getProvID(i)).getPop().getCivID(j), CFG.core.getProv(CFG.core.getCiv(this.getCivID()).getProvID(i)).getPop().getPopulationID(j) + (int)((float)CFG.core.getProv(CFG.core.getCiv(this.getCivID()).getProvID(i)).getPop().getPopulationID(j) * ((float)this.getValue() / 100.0f)));
                        }
                    }
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public boolean canMakeAction() {
        try {
            if (this.getCivID() <= 0) {
                return true;
            }
            return this.getCivID() > 0 && this.getCivID() < CFG.core.getCivsSize() && CFG.core.getCiv(this.getCivID()).getNumOfProvs() > 0;
        }
        catch (Exception exception) {
            return false;
        }
    }

    @Override
    public String getConditionText() {
        try {
            if (this.getCivID() < 0) {
                return CFG.lang.get("UpdatePopulationOfCiv") + ": " + CFG.lang.get("RandomCivilization") + ", " + (this.getValue() > 0 ? "+" : "") + this.getValue() + "%";
            }
            if (this.getCivID() == 0) {
                return CFG.lang.get("UpdatePopulationOfCiv") + ": " + CFG.lang.get("AllCivilizations") + ", " + (this.getValue() > 0 ? "+" : "") + this.getValue() + "%";
            }
            return CFG.lang.get("UpdatePopulationOfCiv") + ": " + CFG.core.getCiv(this.getCivID()).getCivName() + ", " + (this.getValue() > 0 ? "+" : "") + this.getValue() + "%";
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("UpdatePopulationOfCiv");
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
                tData.add(new ME_Hover_2Type_Text(CFG.lang.get("Population") + ": ", CFG.COLOR_HOVER_TITLE));
                tData.add(new ME_Hover_2Type_Text((this.getValue() > 0 ? "+" : "") + CFG.getNumberWthSpaces("" + this.getValue()) + "%", this.getValue() > 0 ? CFG.COLOR_POSITIVE : (this.getValue() == 0 ? CFG.COLOR_NEUTRAL2 : CFG.COLOR_NEGATIVE_2)));
                tData.add(new ME_Hover_2Type_Image(Images.pop, CFG.PADD, 0));
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
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_UPDATEPOPULATION_OFCIV);
    }
}

