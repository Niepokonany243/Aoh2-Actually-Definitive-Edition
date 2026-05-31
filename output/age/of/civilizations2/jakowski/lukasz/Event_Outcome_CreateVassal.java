/*
 * Decompiled with CFR 0.152.
 */
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

public class Event_Outcome_CreateVassal
extends Event_Outcome {
    private static final long serialVersionUID = -8277689643360271505L;
    public int iCivID = -1;
    public int iCivID2 = -1;
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
        return this.iCivID2;
    }

    @Override
    public void setCivID2(int nCivID) {
        this.iCivID2 = nCivID;
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
        if (this.getCivID2() <= 0 && this.getCivID() > 0 && this.getCivID() < CFG.core.getCivsSize()) {
            try {
                for (int i = 0; i < this.lProvinces.size(); ++i) {
                    try {
                        if (!this.canMakeAction2(i)) continue;
                        CFG.core.getProv(this.getProvinces().get(i)).setCivId(this.getCivID(), false);
                        CFG.core.getProv(this.getProvinces().get(i)).setTrueOwnerOfProv(this.getCivID());
                        continue;
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
                CFG.gameAction.updateCivsHappiness(this.getCivID());
                Core.addSimpleTask(new Core.SimpleTask("buildCivilizationRegions" + this.getCivID(), this.getCivID()){

                    @Override
                    public void update() {
                        try {
                            CFG.core.buildCivilizationRegions(this.id);
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }
                });
                CFG.core.moveCapitalToTheLargestCity(this.getCivID());
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        } else if (this.getCivID() >= 0 && this.getCivID() < CFG.core.getCivsSize() && this.getCivID2() >= 0 && this.getCivID2() < CFG.core.getCivsSize()) {
            try {
                CFG.core.setVassal_OfCiv(this.getCivID(), this.getCivID2());
                for (int i = 0; i < this.lProvinces.size(); ++i) {
                    try {
                        if (!this.canMakeAction(i)) continue;
                        CFG.core.getProv(this.getProvinces().get(i)).setCivId(this.getCivID2(), false);
                        CFG.core.getProv(this.getProvinces().get(i)).setTrueOwnerOfProv(this.getCivID2());
                        continue;
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
                CFG.gameAction.updateCivsHappiness(this.getCivID());
                CFG.gameAction.updateCivsHappiness(this.getCivID2());
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
                            // empty catch block
                        }
                    }
                });
                Core.addSimpleTask(new Core.SimpleTask("buildCivilizationRegions" + this.getCivID2(), this.getCivID2()){

                    @Override
                    public void update() {
                        try {
                            CFG.core.buildCivilizationRegions(this.id);
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }
                });
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    public boolean canMakeAction(int i) {
        try {
            return !CFG.core.getProv(this.getProvinces().get(i)).getSeaProv() && CFG.core.getProv(this.getProvinces().get(i)).getWastelandLvl() < 0 && (CFG.core.getProv(this.getProvinces().get(i)).getCivId() == this.getCivID() || CFG.core.getCiv(CFG.core.getProv(this.getProvinces().get(i)).getCivId()).getPuppetOfCiv() == this.getCivID()) && this.getCivID() != this.getCivID2();
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return false;
        }
    }

    public boolean canMakeAction2(int i) {
        try {
            return !CFG.core.getProv(this.getProvinces().get(i)).getSeaProv() && CFG.core.getProv(this.getProvinces().get(i)).getWastelandLvl() < 0;
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
            if (this.getCivID2() <= 0) {
                tData.add(new ME_Hover_2Type_Text(CFG.lang.get("AddCivilization") + ": ", CFG.COLOR_HOVER_TITLE));
                tData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(this.getCivID()).getCivName()));
                tData.add(new ME_Hover_2Type_Flag(this.getCivID(), CFG.PADD, 0));
                tElements.add(new MEHover_2E(tData));
                tData.clear();
                if (this.getProvinces().size() < 5) {
                    for (int i = 0; i < this.getProvinces().size(); ++i) {
                        if (!this.canMakeAction2(i)) continue;
                        tData.add(new ME_Hover_2Type_Flag(this.getCivID()));
                        tData.add(new ME_Hover_2Type_Text(CFG.lang.get("Controls") + ": ", CFG.COLOR_HOVER_TITLE));
                        tData.add(new ME_Hover_2Type_Text("" + (CFG.core.getProv(this.getProvinces().get(i)).getName().length() == 0 ? (Serializable)this.getProvinces().get(i) : CFG.core.getProv(this.getProvinces().get(i)).getName())));
                        tElements.add(new MEHover_2E(tData));
                        tData.clear();
                    }
                } else {
                    tData.add(new ME_Hover_2Type_Flag(this.getCivID()));
                    tData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
                    tData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + this.getProvinces().size()), CFG.COLOR_HOVER_TITLE));
                    tData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                    tElements.add(new MEHover_2E(tData));
                    tData.clear();
                }
            } else {
                tData.add(new ME_Hover_2Type_Text(CFG.lang.get("CreateAVassal") + ": ", CFG.COLOR_HOVER_TITLE));
                tData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(this.getCivID2()).getCivName()));
                tData.add(new ME_Hover_2Type_Flag(this.getCivID2(), CFG.PADD, 0));
                tElements.add(new MEHover_2E(tData));
                tData.clear();
                if (this.getProvinces().size() < 5) {
                    for (int i = 0; i < this.getProvinces().size(); ++i) {
                        if (!this.canMakeAction(i)) continue;
                        tData.add(new ME_Hover_2Type_Flag(this.getCivID2()));
                        tData.add(new ME_Hover_2Type_Text(CFG.lang.get("Controls") + ": ", CFG.COLOR_HOVER_TITLE));
                        tData.add(new ME_Hover_2Type_Text("" + (CFG.core.getProv(this.getProvinces().get(i)).getName().length() == 0 ? (Serializable)this.getProvinces().get(i) : CFG.core.getProv(this.getProvinces().get(i)).getName())));
                        tElements.add(new MEHover_2E(tData));
                        tData.clear();
                    }
                } else {
                    tData.add(new ME_Hover_2Type_Flag(this.getCivID2()));
                    tData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
                    tData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + this.getProvinces().size()), CFG.COLOR_HOVER_TITLE));
                    tData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                    tElements.add(new MEHover_2E(tData));
                    tData.clear();
                }
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
    public String getConditionText() {
        try {
            if (this.getCivID2() <= 0) {
                return CFG.lang.get("AddCivilization") + ": " + CFG.core.getCiv(this.getCivID()).getCivName();
            }
            return CFG.lang.get("CreateAVassal") + ": " + CFG.core.getCiv(this.getCivID2()).getCivName();
        }
        catch (IndexOutOfBoundsException ex) {
            return CFG.lang.get("CreateAVassal");
        }
    }

    @Override
    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_CREATEVASSAL);
    }
}

